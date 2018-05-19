package organizational.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organizational.model.Post;

import java.util.List;

@Service
public class ServicePost {
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

    public void update(Post post) {
        SqlSession session = factory.getFactory().openSession();
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
