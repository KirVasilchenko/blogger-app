package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.dto.PostDto;
import ru.mininuniver.pimz16.bloggerapp.dto.PostStatus;
import ru.mininuniver.pimz16.bloggerapp.service.PostService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private Map<String, PostDto> mockData;

    private Long mockIndex = 0L;

    public PostServiceImpl() {
        this.mockData = new HashMap<>();

        addMockPost("Приветствие", PostStatus.PUBLISHED, "Текст приветствия");
        addMockPost("Знакомство", PostStatus.SCHEDULED, "Текст поста-знакомства");

    }

    private PostDto addMockPost(String title, PostStatus status, String content) {
        var post = PostDto.builder().id(String.valueOf(++mockIndex)).title(title).status(status).content(content).build();
        mockData.put(post.getId(), post);
        return post;
    }


    @Override
    public List<PostDto> getAll() {
        return new ArrayList<>(mockData.values());
    }

    @Override
    public List<PostDto> findByContent(String query) {
        return mockData.entrySet().stream()
                .filter( e -> e.getValue().getContent().contains(query))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getById(String id) {
        return mockData.entrySet().stream()
                .filter( e -> e.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String save(PostDto post) {
        if (post.getId() != null) {
            throw new RuntimeException("ID must be null for new post");
        }

        return addMockPost(post.getTitle(), post.getStatus(), post.getContent())
                .getId();
    }

    @Override
    public PostDto update(PostDto post) {
        if (post.getId() == null) {
            throw new RuntimeException("ID must not be null for updating post");
        }
        if (!mockData.containsKey(post.getId())) {
            throw new RuntimeException("Post not found");
        }

        return mockData.put(post.getId(), post);
    }

    @Override
    public boolean deleteById(String id) {

        if (id == null) {
            throw new RuntimeException("ID must not be null for deleting post");
        }
        if (!mockData.containsKey(id)) {
            throw new RuntimeException("Post not found");
        }

        PostDto remove = mockData.remove(id);

        if (remove != null) {
            return true;
        }

        return false;

    }
}
