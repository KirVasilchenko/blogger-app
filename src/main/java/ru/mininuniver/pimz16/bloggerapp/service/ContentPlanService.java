package ru.mininuniver.pimz16.bloggerapp.service;

import ru.mininuniver.pimz16.bloggerapp.model.ContentPlan;

import java.util.List;

public interface ContentPlanService {

    List<ContentPlan> getAll();

    List<ContentPlan> findByQuery(String query);

    ContentPlan getById(Integer id);

    Integer save(ContentPlan content);

    ContentPlan update(ContentPlan content);

    boolean deleteById(Integer id);

}
