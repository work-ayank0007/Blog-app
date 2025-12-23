package com.example.Blog_App.controllers;

import com.example.Blog_App.dto.PostDTO;
import com.example.Blog_App.services.IPostService;
import com.example.Blog_App.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/post")
public class PostController {
    private final IPostService postService;

    @GetMapping
    public List<PostDTO> getPosts(){
        return postService.getAllPost();
    }
    @GetMapping(path = "/{id}")
    public PostDTO getPost(@PathVariable Long id){
        return postService.getPostById(id);
    }
    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        return postService.createNewPost(postDTO);
    }
}
