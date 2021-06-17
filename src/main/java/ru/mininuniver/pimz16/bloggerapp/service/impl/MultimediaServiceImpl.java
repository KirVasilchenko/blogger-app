package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlan;
import ru.mininuniver.pimz16.bloggerapp.model.Multimedia;
import ru.mininuniver.pimz16.bloggerapp.service.MultimediaService;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    private Map<Integer, Multimedia> mockData;

    private Integer mockIndex = 0;

    public MultimediaServiceImpl() {
        this.mockData = new HashMap<>();

        addMockEntry("Безмятежность", 1, "https://upload.wikimedia.org/wikipedia/ru/1/1d/%D0%91%D0%B5%D0%B7%D0%BC%D1%8F%D1%82%D0%B5%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%8C.png");
        addMockEntry("Пример плана эвакуации", 1, "https://host.dmn/resource/file.jpg");
    }

    private Multimedia addMockEntry(String name, Integer typeId, String link) {
        var entry = Multimedia.builder().id(++mockIndex).name(name).type_id(typeId).link(link).build();
        mockData.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public List<Multimedia> getAll() {
        return new ArrayList<>(mockData.values());
    }

    @Override
    public List<Multimedia> findByQuery(String query) {
        return mockData.entrySet().stream()
                .filter(
                        e -> e.getValue().getName().toUpperCase()
                                .contains(query.toUpperCase())
                )
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Multimedia getById(Integer id) {
        return mockData.entrySet().stream()
                .filter( e -> e.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Integer save(Multimedia content) {
        if (content.getId() != null) {
            throw new RuntimeException("ID must be null for new element");
        }

        return addMockEntry(content.getName(), content.getType_id(), content.getLink())
                .getId();
    }

    @Override
    public Multimedia update(Multimedia content) {
        if (content.getId() == null) {
            throw new RuntimeException("ID must not be null for updating multimedia element");
        }
        if (!mockData.containsKey(content.getId())) {
            throw new RuntimeException("Multimedia not found");
        }

        mockData.put(content.getId(), content);
        return mockData.get(content.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id == null) {
            throw new RuntimeException("ID must not be null for deleting multimedia");
        }
        if (!mockData.containsKey(id)) {
            throw new RuntimeException("Multimedia not found");
        }
        var remove = mockData.remove(id);
        if (remove != null) {
            return true;
        }
        return false;
    }
}
