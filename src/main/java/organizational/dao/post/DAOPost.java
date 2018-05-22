package organizational.dao.post;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Primary;
import organizational.model.Post;

import java.util.List;

@Mapper
public interface DAOPost {
    int insert(Post post);
    void update(int id, Post post);
    void delete(int id);
    Post findPostById(int id);
    List<Post> allPost();
}
