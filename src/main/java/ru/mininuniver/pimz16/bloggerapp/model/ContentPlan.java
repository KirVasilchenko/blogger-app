package ru.mininuniver.pimz16.bloggerapp.model;

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
@ApiModel("Контент-план")
public class ContentPlan {

    @ApiModelProperty("Идентификатор")
    private Integer id;
    @ApiModelProperty("Название")
    private String name;
    @ApiModelProperty("Описание")
    private String description;

}
