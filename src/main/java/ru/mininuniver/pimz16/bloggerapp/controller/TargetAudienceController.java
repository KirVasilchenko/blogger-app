package ru.mininuniver.pimz16.bloggerapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.mininuniver.pimz16.bloggerapp.model.TargetAudience;
import ru.mininuniver.pimz16.bloggerapp.service.TargetAudienceService;

import java.util.List;

@RestController
@RequestMapping("/audience")
@Api(description = "Операции с ЦА")
public class TargetAudienceController {

    private TargetAudienceService targetAudienceService;

    @Autowired
    public TargetAudienceController(TargetAudienceService targetAudienceService) {
        this.targetAudienceService = targetAudienceService;
        Assert.notNull(this.targetAudienceService, "TargetAudience service must not be null");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск сегмента ЦА по идентификатору", response = ResponseEntity.class)
    public ResponseEntity<TargetAudience> getById(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(targetAudienceService.getById(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает список сегмнетов ЦА", response = ResponseEntity.class)
    public ResponseEntity<List<TargetAudience>> getAll() {
        return ResponseEntity.ok()
                .body(targetAudienceService.getAll());
    }

    @GetMapping("/search")
    @ApiOperation(value = "Возвращает список сегментов ЦА по фильтру названия", response = ResponseEntity.class)
    public ResponseEntity<List<TargetAudience>> findByQuery(@RequestParam @ApiParam("Запрос") String query) {
        return ResponseEntity.ok()
                .body(targetAudienceService.findByQuery(query));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохраняет новый сегмент ЦА под новым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<String> save(TargetAudience post) {
        return ResponseEntity.ok()
                .body(targetAudienceService.save(post));
    }

    @PutMapping("/")
    @ApiOperation(value = "Сохраняет изменения в сегменте ЦА под старым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<TargetAudience> update(TargetAudience post) {
        return ResponseEntity.ok()
                .body(targetAudienceService.update(post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет сегмент ЦА", response = ResponseEntity.class)
    public ResponseEntity<Boolean> delete(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(targetAudienceService.deleteById(id));
    }


}
