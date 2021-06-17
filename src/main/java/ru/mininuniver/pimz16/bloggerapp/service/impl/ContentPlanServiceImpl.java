package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlan;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlanElement;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanService;
import ru.mininuniver.pimz16.bloggerapp.service.MultimediaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContentPlanServiceImpl implements ContentPlanService {

    private Map<Integer, ContentPlan> mockData;

    private Integer mockIndex = 0;

    public ContentPlanServiceImpl() {
        this.mockData = new HashMap<>();

        addMockEntry("Записки путешественника", "Описание путешествий по России");
        addMockEntry("Домашние дела", "Колонка полезных заметок о быте");
    }

    private ContentPlan addMockEntry(String name, String description) {
        var entry = ContentPlan.builder().id(++mockIndex).name(name).description(description).build();
        mockData.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public List<ContentPlan> getAll() {
        return new ArrayList<>(mockData.values());
    }

    @Override
    public List<ContentPlan> findByQuery(String query) {
        return mockData.entrySet().stream()
                .filter(
                        e -> e.getValue().getName().toUpperCase().contains(query.toUpperCase())
                                || e.getValue().getDescription().toUpperCase().contains(query.toUpperCase())
                )
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public ContentPlan getById(Integer id) {
        return mockData.entrySet().stream()
                .filter( e -> e.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Integer save(ContentPlan content) {
        if (content.getId() != null) {
            throw new RuntimeException("ID must be null for new element");
        }

        return addMockEntry(content.getName(), content.getDescription()).getId();
    }

    @Override
    public ContentPlan update(ContentPlan content) {
        if (content.getId() == null) {
            throw new RuntimeException("ID must not be null for updating content plan");
        }
        if (!mockData.containsKey(content.getId())) {
            throw new RuntimeException("Content plan not found");
        }

        mockData.put(content.getId(), content);
        return mockData.get(content.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id == null) {
            throw new RuntimeException("ID must not be null for deleting content plan");
        }
        if (!mockData.containsKey(id)) {
            throw new RuntimeException("Content plan not found");
        }
        var remove = mockData.remove(id);
        if (remove != null) {
            return true;
        }
        return false;
    }
}
