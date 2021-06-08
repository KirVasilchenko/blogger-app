package ru.mininuniver.pimz16.bloggerapp.service;

import ru.mininuniver.pimz16.bloggerapp.model.ContentPlanElement;

import java.util.List;

public interface ContentPlanElementService {

    List<ContentPlanElement> getAll();

    List<ContentPlanElement> findByQuery(String query);

    ContentPlanElement getById(String id);

    String save(ContentPlanElement content);

    ContentPlanElement update(ContentPlanElement content);

    boolean deleteById(String id);

}
