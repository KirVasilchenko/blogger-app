package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.Multimedia;
import ru.mininuniver.pimz16.bloggerapp.service.MultimediaService;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;

import java.util.List;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    @Override
    public List<Multimedia> getAll() {
        return null;
    }

    @Override
    public List<Multimedia> findByQuery(String query) {
        return null;
    }

    @Override
    public Multimedia getById(String id) {
        return null;
    }

    @Override
    public String save(Multimedia content) {
        return null;
    }

    @Override
    public Multimedia update(Multimedia content) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }
}
