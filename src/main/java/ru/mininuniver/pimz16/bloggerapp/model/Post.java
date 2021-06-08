package ru.mininuniver.pimz16.bloggerapp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel("Публикация")
public class Post {

    @ApiModelProperty("Идентификатор")
    private Integer id;
    @ApiModelProperty("Идентификатор статуса публикации")
    private Integer postStatusId;
    @ApiModelProperty("Заголовок")
    private String title;
    @ApiModelProperty("Содержимое поста")
    private String content;
    @ApiModelProperty("Дата последнего изменения")
    private LocalDate updateDate;


}
