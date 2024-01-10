package com.apress.demo.springblog.repository;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Repository
// @Repository sirve para indicar que esta clase es un repositorio de datos para la clase Post
// y sus atributos y metodos se van a usar para interactuar con la base de datos
public class PostRepository {
    // La lógica real para realizar las operaciones de agregar y recuperar está definida
    // dentro de la clase PostRepository.java.
    // Es una clase en lugar de una interfaz porque se va a usar un conjunto de posts en lugar
    // de una lista de posts. La razón de esto es que un conjunto no permite duplicados,
    // mientras que una lista sí. Esto es importante porque no se quiere que haya dos posts
    // con el mismo ID en el conjunto de posts.

    private final Set<Post> posts = new CopyOnWriteArraySet<>();
    // private final Set<Post> posts sirve para crear un conjunto de posts

    public void addPost(Post post) {
        posts.add(post);
    }
    // addPost sirve para agregar un post al conjunto de posts

    public Set<Post> findAllPosts() {
        return posts;
    }
    // findAllPosts sirve para encontrar todos los posts del conjunto de posts

    public Post findOnePost(Integer postId) {
        return posts.stream().filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new SpringBlogException("Cannot find post by id: " + postId));
    }
    // findOnePost sirve para encontrar un post del conjunto de posts

    public void updatePost(Post post) {
        Post savedPost = findOnePost(post.getId());
        post.setId(savedPost.getId());
        posts.add(post);
    }
    // updatePost sirve para actualizar un post del conjunto de posts

    public void deletePost(Integer id) {
        Post onePost = findOnePost(id);
        posts.remove(onePost);
    }
    // deletePost sirve para eliminar un post del conjunto de posts
}
