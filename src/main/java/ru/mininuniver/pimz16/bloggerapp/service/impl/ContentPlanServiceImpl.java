package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlan;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanService;
import ru.mininuniver.pimz16.bloggerapp.service.MultimediaService;

import java.util.List;

@Service
public class ContentPlanServiceImpl implements ContentPlanService {

    @Override
    public List<ContentPlan> getAll() {
        return null;
    }

    @Override
    public List<ContentPlan> findByQuery(String query) {
        return null;
    }

    @Override
    public ContentPlan getById(String id) {
        return null;
    }

    @Override
    public String save(ContentPlan content) {
        return null;
    }

    @Override
    public ContentPlan update(ContentPlan content) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
