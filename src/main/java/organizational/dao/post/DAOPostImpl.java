package organizational.dao.post;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import organizational.dao.Factory;
import organizational.model.Post;

import java.util.List;

@Primary
@Repository
public class DAOPostImpl implements DAOPost {

    @Autowired
    private Factory factory;

    public int insert(Post post) {
        int id = -1;
        SqlSession session = factory.getFactory().openSession();
        try {
            id = session.insert("Post.insert",post);
        } finally {
            session.commit();
            session.close();
        }
        return id;
    }

    public void update(int id, Post post) {
        SqlSession session = factory.getFactory().openSession();
        post.setId(id);
        try {
            session.update("Post.update", post);
        } finally {
            session.commit();
            session.close();
        }
    }

    public void delete(int id) {
        SqlSession session = factory.getFactory().openSession();
        try {
            session.delete("Post.delete",id);
        } finally {
            session.commit();
            session.close();
        }
    }

    public Post findPostById(int id) {
        Post post;
        SqlSession session = factory.getFactory().openSession();
        try {
            post = session.selectOne("Post.findById",id);
        } finally {
            session.close();
        }
        return post;
    }

    public List<Post> allPost() {
        List<Post> posts;
        SqlSession session = factory.getFactory().openSession();
        try {
            posts = session.selectList("Post.allPost");
        } finally {
            session.close();
        }
        return posts;
    }
}
