package ru.mininuniver.pimz16.bloggerapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ru.mininuniver.pimz16.bloggerapp.dto.PostDto;
import ru.mininuniver.pimz16.bloggerapp.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@Api(description = "Операции с публикациями")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
        Assert.notNull(this.postService, "Post service must not be null");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Поиск публикации по идентификатору", response = ResponseEntity.class)
    public ResponseEntity<PostDto> getById(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(postService.getById(id));
    }

    @GetMapping("/")
    @ApiOperation(value = "Возвращает список публикаций", response = ResponseEntity.class)
    public ResponseEntity<List<PostDto>> getAll() {
        return ResponseEntity.ok()
                .body(postService.getAll());
    }

    @GetMapping("/search")
    @ApiOperation(value = "Возвращает список публикаций, содержащих запрос", response = ResponseEntity.class)
    public ResponseEntity<List<PostDto>> findByContent(@RequestParam @ApiParam("Запрос") String query) {
        return ResponseEntity.ok()
                .body(postService.findByContent(query));
    }

    @PostMapping("/")
    @ApiOperation(value = "Сохраняет новый пост под новым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<String> save(PostDto post) {
        return ResponseEntity.ok()
                .body(postService.save(post));
    }

    @PutMapping("/")
    @ApiOperation(value = "Сохраняет изменения в посте под старым идентификатором", response = ResponseEntity.class)
    public ResponseEntity<PostDto> update(PostDto post) {
        return ResponseEntity.ok()
                .body(postService.update(post));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет пост", response = ResponseEntity.class)
    public ResponseEntity<Boolean> delete(@PathVariable @ApiParam("Идентификатор") String id) {
        return ResponseEntity.ok()
                .body(postService.deleteById(id));
    }


}
