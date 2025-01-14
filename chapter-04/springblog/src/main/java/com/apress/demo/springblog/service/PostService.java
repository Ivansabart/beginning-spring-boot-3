package com.apress.demo.springblog.service;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// @Service sirve para indicar que esta clase es un servicio y un Spring Bean
@RequiredArgsConstructor
/*
*   @RequiredArgsConstructor sirve para crear un constructor con todos los campos requeridos
*   el contructor sería:
*    public PostService(PostRepository postRepository) {
*        this.postRepository = postRepository;
*    }
* */
public class PostService {

    // private final PostRepository postRepository sirve para crear un objeto de tipo PostRepository
    // para poder usar sus metodos en esta clase PostService
    private final PostRepository postRepository;

    // addPost sirve para agregar un post a la base de datos
    public void addPost(Post post) {
        postRepository.addPost(post);
    }

    // findAllPosts sirve para encontrar todos los posts de la base de datos
    public List<Post> findAllPosts() {
        return new ArrayList<>(postRepository.findAllPosts());
    }

    // findOnePost sirve para encontrar un post de la base de datos
    public Post findOnePost(Integer postId) {
        return postRepository.findOnePost(postId);
    }

    // updatePost sirve para actualizar un post de la base de datos
    public void updatePost(Post post) {
        postRepository.updatePost(post);
    }

    // deletePost sirve para eliminar un post de la base de datos
    public void deletePost(Integer id) {
        postRepository.deletePost(id);
    }

    // postExistsWithTitle sirve para verificar si existe un post con el mismo titulo en la base de datos
    public boolean postExistsWithTitle(String title) {
        return postRepository.findAllPosts().stream()
                .anyMatch(post -> post.getTitle().equals(title));
    }
}