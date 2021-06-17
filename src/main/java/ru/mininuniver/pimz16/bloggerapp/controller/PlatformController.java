package ru.mininuniver.pimz16.bloggerapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.mininuniver.pimz16.bloggerapp.dto.PostDto;
import ru.mininuniver.pimz16.bloggerapp.model.Platform;
import ru.mininuniver.pimz16.bloggerapp.service.PlatformService;
import ru.mininuniver.pimz16.bloggerapp.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/platform")
@Api(description = "Операции с платформами")
public class PlatformController {

    private PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
        Assert.notNull(this.platformService, "Platform service must not be null");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск платформы по идентификатору", response = ResponseEntity.class)
    public ResponseEntity<Platform> getById(@PathVariable @ApiParam("Идентификатор") Integer id) {
        return ResponseEntity.ok()
                .body(platformService.getById(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает список платформ", response = ResponseEntity.class)
    public ResponseEntity<List<Platform>> getAll() {
        return ResponseEntity.ok()
                .body(platformService.getAll());
    }

    @GetMapping("/search")
    @ApiOperation(value = "Возвращает список платформ по фильтру названия", response = ResponseEntity.class)
    public ResponseEntity<List<Platform>> findByQuery(@RequestParam @ApiParam("Запрос") String query) {
        return ResponseEntity.ok()
                .body(platformService.findByQuery(query));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохраняет новую платформу под новым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<Integer> save(Platform post) {
        return ResponseEntity.ok()
                .body(platformService.save(post));
    }

    @PutMapping("/")
    @ApiOperation(value = "Сохраняет изменения в платформе под старым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<Platform> update(Platform post) {
        return ResponseEntity.ok()
                .body(platformService.update(post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет платформу", response = ResponseEntity.class)
    public ResponseEntity<Boolean> delete(@PathVariable @ApiParam("Идентификатор") Integer id) {
        return ResponseEntity.ok()
                .body(platformService.deleteById(id));
    }


}
