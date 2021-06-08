package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.Platform;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Override
    public List<Platform> getAll() {
        return null;
    }

    @Override
    public List<Platform> findByQuery(String query) {
        return null;
    }

    @Override
    public Platform getById(String id) {
        return null;
    }

    @Override
    public String save(Platform content) {
        return null;
    }

    @Override
    public Platform update(Platform content) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
