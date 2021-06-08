package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.TargetAudience;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;
import ru.mininuniver.pimz16.bloggerapp.service.TargetAudienceService;

import java.util.List;

@Service
public class TargetAudienceServiceImpl implements TargetAudienceService {

    @Override
    public List<TargetAudience> getAll() {
        return null;
    }

    @Override
    public List<TargetAudience> findByQuery(String query) {
        return null;
    }

    @Override
    public TargetAudience getById(String id) {
        return null;
    }

    @Override
    public String save(TargetAudience content) {
        return null;
    }

    @Override
    public TargetAudience update(TargetAudience content) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
