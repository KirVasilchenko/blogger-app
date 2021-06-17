package ru.mininuniver.pimz16.bloggerapp.service;

import ru.mininuniver.pimz16.bloggerapp.model.Multimedia;

import java.util.List;

public interface MultimediaService {

    List<Multimedia> getAll();

    List<Multimedia> findByQuery(String query);

    Multimedia getById(Integer id);

    Integer save(Multimedia content);

    Multimedia update(Multimedia content);

    boolean deleteById(Integer id);

}
