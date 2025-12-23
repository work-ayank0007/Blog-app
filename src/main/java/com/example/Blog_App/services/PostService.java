package com.example.Blog_App.services;

import com.example.Blog_App.dto.PostDTO;
import com.example.Blog_App.entity.PostEntity;
import com.example.Blog_App.expections.ResourceNotFoundException;
import com.example.Blog_App.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

    private final PostRepository postRepository;
    private final ModelMapper mapper;

    public PostDTO getPostById(Long id){
        return mapper.map(postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post Not Found with ID:"+ id)), PostDTO.class);
    };

    public List<PostDTO> getAllPost(){
        return postRepository.
                findAll()
                .stream()
                .map(p->mapper.map(p,PostDTO.class))
                .toList();

    }


    public PostDTO createNewPost(PostDTO postDTO){
        return mapper
                .map(postRepository.save(mapper.map(postDTO,PostEntity.class)),PostDTO.class);
    }
}
