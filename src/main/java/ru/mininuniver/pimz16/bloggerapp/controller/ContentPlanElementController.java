package ru.mininuniver.pimz16.bloggerapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.mininuniver.pimz16.bloggerapp.model.ContentPlanElement;
import ru.mininuniver.pimz16.bloggerapp.service.ContentPlanElementService;

import java.util.List;

@RestController
@RequestMapping("/content-plan/element")
@Api(description = "Операции с пунктами контент-плана")
public class ContentPlanElementController {

    private ContentPlanElementService contentPlanElementService;

    @Autowired
    public ContentPlanElementController(ContentPlanElementService contentPlanElementService) {
        this.contentPlanElementService = contentPlanElementService;
        Assert.notNull(this.contentPlanElementService, "ContentPlanElement service must not be null");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск пункта контент-плана по идентификатору", response = ResponseEntity.class)
    public ResponseEntity<ContentPlanElement> getById(@PathVariable @ApiParam("Идентификатор") Integer id) {
        return ResponseEntity.ok()
                .body(contentPlanElementService.getById(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает список пунктов контент-плана", response = ResponseEntity.class)
    public ResponseEntity<List<ContentPlanElement>> getAll() {
        return ResponseEntity.ok()
                .body(contentPlanElementService.getAll());
    }

    @GetMapping("/search")
    @ApiOperation(value = "(DEPRECATED) Возвращает список пунктов контент-плана по фильтру названия", response = ResponseEntity.class)
    public ResponseEntity<List<ContentPlanElement>> findByQuery(@RequestParam @ApiParam("Запрос") String query) {
        return ResponseEntity.ok()
                .body(contentPlanElementService.findByQuery(query));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохраняет новый пункт контент-плана под новым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<Integer> save(ContentPlanElement post) {
        return ResponseEntity.ok()
                .body(contentPlanElementService.save(post));
    }

    @PutMapping("/")
    @ApiOperation(value = "Сохраняет изменения в пункте контент-плана под старым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<ContentPlanElement> update(ContentPlanElement post) {
        return ResponseEntity.ok()
                .body(contentPlanElementService.update(post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет пункт контент-плана", response = ResponseEntity.class)
    public ResponseEntity<Boolean> delete(@PathVariable @ApiParam("Идентификатор") Integer id) {
        return ResponseEntity.ok()
                .body(contentPlanElementService.deleteById(id));
    }


}
