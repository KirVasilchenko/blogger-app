package ru.mininuniver.pimz16.bloggerapp.service;

import ru.mininuniver.pimz16.bloggerapp.dto.PostDto;
import ru.mininuniver.pimz16.bloggerapp.model.Platform;

import java.util.List;

public interface PlatformService {

    List<Platform> getAll();

    List<Platform> findByQuery(String query);

    Platform getById(String id);

    String save(Platform content);

    Platform update(Platform content);

    boolean deleteById(String id);

}
