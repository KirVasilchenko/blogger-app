package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.Platform;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlatformServiceImpl implements PlatformService {

    private Map<Integer, Platform> mockData;

    private Integer mockIndex = 0;

    public PlatformServiceImpl() {
        this.mockData = new HashMap<>();

        addMockEntry("Twitter", "http://twitter.com/blogger", "blogger", "password");
        addMockEntry("Facebook", "http://facebook.com/blogger", "blogger", "password");
    }

    private Platform addMockEntry(String name, String link, String login, String password) {
        var entry = Platform.builder().id(++mockIndex).name(name).link(link).login(login).password(password).build();
        mockData.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public List<Platform> getAll() {
        return new ArrayList<>(mockData.values());
    }

    @Override
    public List<Platform> findByQuery(String query) {
        return mockData.entrySet().stream()
                .filter(
                        e -> e.getValue().getName().toUpperCase()
                                .contains(query.toUpperCase())
                )
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Platform getById(Integer id) {
        return mockData.entrySet().stream()
                .filter( e -> e.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Integer save(Platform content) {
        if (content.getId() != null) {
            throw new RuntimeException("ID must be null for new element");
        }

        return addMockEntry(content.getName(), content.getLink(), content.getLogin(), content.getPassword())
                .getId();
    }

    @Override
    public Platform update(Platform content) {
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
