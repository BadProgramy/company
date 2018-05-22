package organizational.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import organizational.service.ServicePost;
import organizational.model.Post;

import java.util.List;

//По своему усмотрению я добавил справочник (должностей) свзяанный с бд таблицей
@RestController
@RequestMapping("organization/post")
public class RestControllerPost {

    @Autowired
    private ServicePost servicePost;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @ApiOperation("To add the post")
    public int add(Post post) {
        return servicePost.insert(post);
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    @ApiOperation("To edit the post")
    public void update(int id, Post post) {
        servicePost.update(id,post);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @ApiOperation("Remove post")
    public void delete(int id) {
        servicePost.delete(id);
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    @ApiOperation("Search post by id")
    public Post findById (int id){
        return servicePost.findPostById(id);
    }

    @RequestMapping(value = "all", method = RequestMethod.POST)
    @ApiOperation("Get all posts in organizational")
    public List<Post> allPosts() {
        return servicePost.allPost();
    }
}
