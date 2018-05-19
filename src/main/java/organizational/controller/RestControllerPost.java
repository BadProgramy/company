package organizational.controller;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Post;
import organizational.service.ServicePost;

import java.util.List;

@RestController
@RequestMapping("post")
public class RestControllerPost {

    @Autowired
    private ServicePost servicePost;

    @GetMapping("add")
    public int add(Post post) {
        return servicePost.insert(post);
    }

    @GetMapping("update")
    public void update(Post post) {
        servicePost.update(post);
    }

    @GetMapping("delete")
    public void delete(int id) {
        servicePost.delete(id);
    }

    @GetMapping("find")
    public Post findById (int id){
        return servicePost.findPostById(id);
    }

    @GetMapping("all")
    public List<Post> allPosts() {
        return servicePost.allPost();
    }
}
