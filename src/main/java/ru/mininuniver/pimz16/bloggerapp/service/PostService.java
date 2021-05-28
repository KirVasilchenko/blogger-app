package ru.mininuniver.pimz16.bloggerapp.service;

import ru.mininuniver.pimz16.bloggerapp.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAll();

    List<PostDto> findByContent(String query);

    PostDto getById(String id);

    String save(PostDto content);

    PostDto update(PostDto content);

    boolean deleteById(String id);

}
