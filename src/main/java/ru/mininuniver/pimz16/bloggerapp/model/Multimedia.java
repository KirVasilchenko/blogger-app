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
@ApiModel("Объект мультимедиа")
public class Multimedia {

    @ApiModelProperty("Идентификатор")
    private Integer id;
    @ApiModelProperty("Название")
    private String name;
    @ApiModelProperty("Идентификатор типа мультимедиа")
    private Integer type_id;
    @ApiModelProperty("Ссылка на объект мультимедиа")
    private String link;

}
