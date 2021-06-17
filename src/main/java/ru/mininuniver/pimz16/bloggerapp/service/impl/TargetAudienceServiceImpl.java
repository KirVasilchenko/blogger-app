package ru.mininuniver.pimz16.bloggerapp.service.impl;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Service;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlanElement;
import ru.mininuniver.pimz16.bloggerapp.model.TargetAudience;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;
import ru.mininuniver.pimz16.bloggerapp.service.TargetAudienceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TargetAudienceServiceImpl implements TargetAudienceService {

    private Map<Integer, TargetAudience> mockData;

    private Integer mockIndex = 0;

    public TargetAudienceServiceImpl() {
        this.mockData = new HashMap<>();

        addMockEntry("Молодые специалисты", "all", 18, 30, "РФ", "Полезная информация", "Выходные");
        addMockEntry("Бизнесмены Н.Новгорода", "all", 18, 65, "Нижний Новгород", "Полезная информация", "Несерьезность");
        addMockEntry("Женщины в декрете", "F", 18, 40, "РФ", "???", "???");
    }

    private TargetAudience addMockEntry(String name, String gender,
                                        Integer minAge, Integer maxAge,
                                        String geo, String likes, String dislikes) {
        var entry = TargetAudience.builder()
                .id(++mockIndex)
                .name(name)
                .gender(gender)
                .minAge(minAge)
                .maxAge(maxAge)
                .geo(geo)
                .likes(likes)
                .dislikes(dislikes)
                .build();
        mockData.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public List<TargetAudience> getAll() {
        return new ArrayList<>(mockData.values());
    }

    @Override
    public List<TargetAudience> findByQuery(String query) {
        return mockData.entrySet().stream()
                .filter(
                        e -> e.getValue().getName().toUpperCase()
                                .contains(query.toUpperCase())
                )
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public TargetAudience getById(Integer id) {
        return mockData.entrySet().stream()
                .filter( e -> e.getKey().equals(id))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Integer save(TargetAudience content) {
        if (content.getId() != null) {
            throw new RuntimeException("ID must be null for new element");
        }

        return addMockEntry(content.getName(), content.getGender(),
                content.getMinAge(), content.getMaxAge(),
                content.getGeo(), content.getLikes(), content.getDislikes())
                .getId();
    }

    @Override
    public TargetAudience update(TargetAudience content) {
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
