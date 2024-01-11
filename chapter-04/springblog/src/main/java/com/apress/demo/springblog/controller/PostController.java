package com.apress.demo.springblog.controller;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.exception.SpringBlogException;
import com.apress.demo.springblog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // postPage sirve para mostrar todos los posts en la pagina principal de posts haciendo
    // uso de la estructura de datos del repositorio de posts y el argumento Model sirve para
    // pasar los datos del repositorio de posts a la vista de la pagina principal de posts
    @GetMapping
    public String postPage(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return "post";
    }


    @GetMapping("/{id}")
    public String onePostPage(Model model, @PathVariable Integer id) {
        model.addAttribute("posts", postService.findOnePost(id));
        return "onePost";
    }

    @GetMapping("/add")
    public String addPostPage(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }

    /*
        addPost sirve para agregar un post a la base de datos y redireccionar a la
        pagina principal de posts en caso de que no haya errores en el formulario
        de agregar post o redireccionar a la pagina de agregar post en caso de que
        haya errores en el formulario de agregar post, el argumento @ModelAttribute
        sirve para indicar que el objeto post se va a obtener de un formulario, el
        argumento @Valid sirve para indicar que se va a validar el objeto post, el
        argumento Errors sirve para indicar que se va a obtener los errores del
        formulario de agregar post y el metodo hasErrors sirve para verificar si
        hay errores en el formulario de agregar post
    */
    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "addPost";
        }
        postService.addPost(post);
        return "redirect:/posts";
    }


    @GetMapping("/update/{id}")
    public String updatePost(Model model, @PathVariable Integer id) {
        model.addAttribute("post", postService.findOnePost(id));
        return "updatePost";
    }

    @ExceptionHandler(SpringBlogException.class)
    public ModelAndView handleSpringBlogException(SpringBlogException ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("exception", ex);
        return model;
    }

}
