package ru.mininuniver.pimz16.bloggerapp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ApiModel("Публикация")
public class PostDto {

    @ApiModelProperty("Идентификатор")
    private String id;

    @ApiModelProperty("Заголовок")
    private String title;

    @ApiModelProperty("Содержимое")
    private String content;

    @ApiModelProperty("Статус")
    private PostStatus status;

}
