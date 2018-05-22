package organizational.model;

import io.swagger.annotations.ApiParam;

public class Post {
    @ApiParam(hidden = true)
    private int id;
    @ApiParam(value = "Name post", required = true)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
