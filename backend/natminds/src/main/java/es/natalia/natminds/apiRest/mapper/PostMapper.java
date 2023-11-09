package es.natalia.natminds.apiRest.mapper;

import es.natalia.natminds.apiRest.dto.PostDto;
import es.natalia.natminds.apiRest.dto.PostDtoCreate;
import es.natalia.natminds.apiRest.dto.PostDtoPartialUpdate;
import es.natalia.natminds.model.model.Post;
import es.natalia.natminds.model.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/*Creamos la clase PostMapper para hacer las transformaciones entre la clase Post y sus respectivas clases DTO
 * utilizando mapstruct*/

//@Mapper(componentModel = "spring")
//@Component
public interface PostMapper {

    public default PostDto postToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setUserId(post.getUserId().getUserId());
        postDto.setText(post.getText());
        return postDto;
    }

    public default Post dtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setPostId(postDto.getPostId());
        post.setText(postDto.getText());

        User user = new User();
        user.setUserId(postDto.getUserId());
        post.setUserId(user);

        return post;
    }

    public default PostDtoCreate postToDtoCrate(Post post) {
        PostDtoCreate postDtoCreate = new PostDtoCreate();
        postDtoCreate.setUserId(post.getUserId().getUserId());
        postDtoCreate.setText(post.getText());
        return postDtoCreate;
    }

    public default Post dtoCreateToPost(PostDtoCreate postDtoCreate) {
        Post post = new Post();

        User user = new User();
        user.setUserId(postDtoCreate.getUserId());
        post.setUserId(user);

        post.setText(postDtoCreate.getText());

        return post;
    }

    public default PostDtoPartialUpdate postToDtoPartialUpdate(Post post) {
        PostDtoPartialUpdate postDtoPartialUpdate = new PostDtoPartialUpdate();
        postDtoPartialUpdate.setText(post.getText());
        return postDtoPartialUpdate;
    }

    public default Post dtoPartialUpdateToPost(PostDtoPartialUpdate postDtoPartialUpdate) {
        Post post = new Post();
        post.setText(postDtoPartialUpdate.getText());

        return post;
    }


    /*

    Post dtoToPost(PostDto postDto);
    PostDto postToDto(Post post);

    // Post: Create
    Post dtoCreateToPost(PostDtoCreate postDtoCreate);
    PostDtoCreate postToDtoCreate(Post post);

    // Post: PartialUpdate
    Post dtoPartialUpdateToPost(PostDtoPartialUpdate postDtoPartialUpdate);
    PostDtoPartialUpdate postToDtoPartialUpdate(Post post);

*/


}
