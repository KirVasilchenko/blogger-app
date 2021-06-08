package ru.mininuniver.pimz16.bloggerapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.mininuniver.pimz16.bloggerapp.model.Multimedia;
import ru.mininuniver.pimz16.bloggerapp.service.MultimediaService;

import java.util.List;

@RestController
@RequestMapping("/multimedia")
@Api(description = "Операции с метаданными объектов мультимедиа")
public class MultimediaController {

    private MultimediaService multimediaService;

    @Autowired
    public MultimediaController(MultimediaService multimediaService) {
        this.multimediaService = multimediaService;
        Assert.notNull(this.multimediaService, "Multimedia service must not be null");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск метаданных объекта мультимедиа по идентификатору", response = ResponseEntity.class)
    public ResponseEntity<Multimedia> getById(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(multimediaService.getById(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает список метаданных объектов мультимедиа", response = ResponseEntity.class)
    public ResponseEntity<List<Multimedia>> getAll() {
        return ResponseEntity.ok()
                .body(multimediaService.getAll());
    }

    @GetMapping("/search")
    @ApiOperation(value = "Возвращает список метаданных объектов мультимедиа по фильтру названия", response = ResponseEntity.class)
    public ResponseEntity<List<Multimedia>> findByQuery(@RequestParam @ApiParam("Запрос") String query) {
        return ResponseEntity.ok()
                .body(multimediaService.findByQuery(query));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохраняет метаданные нового объекта мультимедиа под новым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<String> save(Multimedia post) {
        return ResponseEntity.ok()
                .body(multimediaService.save(post));
    }

    @PutMapping("/")
    @ApiOperation(value = "Сохраняет изменения в метаданных объекта мультимедиа под старым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<Multimedia> update(Multimedia post) {
        return ResponseEntity.ok()
                .body(multimediaService.update(post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет метаданные объекта мультимедиа", response = ResponseEntity.class)
    public ResponseEntity<Boolean> delete(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(multimediaService.deleteById(id));
    }


}
