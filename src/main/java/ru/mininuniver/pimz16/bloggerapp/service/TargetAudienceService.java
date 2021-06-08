package ru.mininuniver.pimz16.bloggerapp.service;

import ru.mininuniver.pimz16.bloggerapp.model.TargetAudience;

import java.util.List;

public interface TargetAudienceService {

    List<TargetAudience> getAll();

    List<TargetAudience> findByQuery(String query);

    TargetAudience getById(String id);

    String save(TargetAudience content);

    TargetAudience update(TargetAudience content);

    boolean deleteById(String id);

}
