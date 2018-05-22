package organizational.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizational.model.Post;
import organizational.dao.post.DAOPost;

import java.util.List;

@Service
public class ServicePost {

    @Autowired
    private DAOPost daoPost;

    @Transactional
    public int insert(Post post) {
        return daoPost.insert(post);
    }

    @Transactional
    public void update(int id, Post post) {
        daoPost.update(id, post);
    }

    @Transactional
    public void delete(int id) {
        daoPost.delete(id);
    }

    @Transactional
    public Post findPostById(int id) {
        return daoPost.findPostById(id);
    }

    @Transactional
    public List<Post> allPost() {
        return daoPost.allPost();
    }
}
