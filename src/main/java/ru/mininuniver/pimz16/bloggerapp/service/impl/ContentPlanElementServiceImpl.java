package ru.mininuniver.pimz16.bloggerapp.service.impl;

import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.dto.PostDto;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlanElement;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanElementService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentPlanElementServiceImpl implements ContentPlanElementService {

    private Map<Integer, ContentPlanElement> mockData;

    private Integer mockIndex = 0;

    public ContentPlanElementServiceImpl() {
        this.mockData = new HashMap<>();
        addMockEntry(1, 1, "Комментарии", LocalDate.now());
        addMockEntry(2, 1, "Лайки", LocalDate.now());
        addMockEntry(3, 1, "Подписки", LocalDate.now());
        addMockEntry(4, 1, "Комментарии", LocalDate.now());
    }

    private ContentPlanElement addMockEntry(Integer postId, Integer cpId, String target, LocalDate publishDate) {
        var entry = ContentPlanElement.builder().id(++mockIndex).postId(postId).contentPlanId(cpId).target(target).publishDate(publishDate).build();
        mockData.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public List<ContentPlanElement> getAll() {
        return new ArrayList<>(mockData.values());
    }

    @Override
    public List<ContentPlanElement> findByQuery(String query) {
        throw new RuntimeException("Cannot apply any query to content plan elements");
    }

    @Override
    public ContentPlanElement getById(Integer id) {
        return mockData.entrySet().stream()
                .filter(e -> e.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow( ()->{ throw new RuntimeException("No such content plan element with ID" + id); } );
    }

    @Override
    public Integer save(ContentPlanElement content) {
        if (content.getId() != null) {
            throw new RuntimeException("ID must be null for new element");
        }

        return addMockEntry(content.getPostId(), content.getContentPlanId(), content.getTarget(), content.getPublishDate()).getId();
    }

    @Override
    public ContentPlanElement update(ContentPlanElement content) {
        if (content.getId() == null) {
            throw new RuntimeException("ID must not be null for updating content plan element");
        }
        if (!mockData.containsKey(content.getId())) {
            throw new RuntimeException("Content plan element not found");
        }

        mockData.put(content.getId(), content);
        return mockData.get(content.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id == null) {
            throw new RuntimeException("ID must not be null for deleting content plan element");
        }
        if (!mockData.containsKey(id)) {
            throw new RuntimeException("Content plan element not found");
        }
        var remove = mockData.remove(id);
        if (remove != null) {
            return true;
        }
        return false;
    }
}
