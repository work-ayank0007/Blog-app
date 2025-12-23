package com.example.Blog_App.services;

import com.example.Blog_App.dto.PostDTO;

import java.util.List;

public interface IPostService {
    public PostDTO getPostById(Long id);
    public List<PostDTO> getAllPost();
    public PostDTO createNewPost(PostDTO postDTO);
}
