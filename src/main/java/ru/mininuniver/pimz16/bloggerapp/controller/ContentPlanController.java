package ru.mininuniver.pimz16.bloggerapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlan;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanService;

import java.util.List;

@RestController
@RequestMapping("/content-plan")
@Api(description = "Операции с контент-планом")
public class ContentPlanController {

    private ContentPlanService contentPlanService;

    @Autowired
    public ContentPlanController(ContentPlanService contentPlanService) {
        this.contentPlanService = contentPlanService;
        Assert.notNull(this.contentPlanService, "ContentPlan service must not be null");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск контент-плана по идентификатору", response = ResponseEntity.class)
    public ResponseEntity<ContentPlan> getById(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(contentPlanService.getById(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает список контент-планов", response = ResponseEntity.class)
    public ResponseEntity<List<ContentPlan>> getAll() {
        return ResponseEntity.ok()
                .body(contentPlanService.getAll());
    }

    @GetMapping("/search")
    @ApiOperation(value = "Возвращает список контент-планов по фильтру названия", response = ResponseEntity.class)
    public ResponseEntity<List<ContentPlan>> findByQuery(@RequestParam @ApiParam("Запрос") String query) {
        return ResponseEntity.ok()
                .body(contentPlanService.findByQuery(query));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохраняет новый контент-план под новым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<String> save(ContentPlan post) {
        return ResponseEntity.ok()
                .body(contentPlanService.save(post));
    }

    @PutMapping("/")
    @ApiOperation(value = "Сохраняет изменения в контент-плане под старым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<ContentPlan> update(ContentPlan post) {
        return ResponseEntity.ok()
                .body(contentPlanService.update(post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет контент-план", response = ResponseEntity.class)
    public ResponseEntity<Boolean> delete(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(contentPlanService.deleteById(id));
    }


}
