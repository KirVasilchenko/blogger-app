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
@ApiModel("Пункт контент-плана")
public class ContentPlanElement {

    @ApiModelProperty("Идентификатор")
    private Integer id;
    @ApiModelProperty("Идентификатор поста")
    private Integer postId;
    @ApiModelProperty("Идентификатор контент-плана")
    private Integer contentPlanId;
    @ApiModelProperty(value = "Цель публикации", example = "Комментарии")
    private String target;
    @ApiModelProperty("Плановая дата публикации")
    private LocalDate publishDate;

}
