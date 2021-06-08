package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlanElement;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanElementService;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanService;

import java.util.List;

@Service
public class ContentPlanElementServiceImpl implements ContentPlanElementService {

    @Override
    public List<ContentPlanElement> getAll() {
        return null;
    }

    @Override
    public List<ContentPlanElement> findByQuery(String query) {
        return null;
    }

    @Override
    public ContentPlanElement getById(String id) {
        return null;
    }

    @Override
    public String save(ContentPlanElement content) {
        return null;
    }

    @Override
    public ContentPlanElement update(ContentPlanElement content) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
