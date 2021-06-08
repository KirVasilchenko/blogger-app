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
@ApiModel("Целевая аудитория")
public class TargetAudience {

    @ApiModelProperty("Идентификатор")
    private Integer id;
    @ApiModelProperty("Название")
    private String name;
    @ApiModelProperty("Пол")
    private String gender;
    @ApiModelProperty("Минимальный возраст")
    private Integer minAge;
    @ApiModelProperty("Максимлаьный возраст")
    private Integer maxAge;
    @ApiModelProperty("География")
    private String geo;
    @ApiModelProperty("Предпочтения")
    private String likes;
    @ApiModelProperty("Антипредпочтения")
    private String dislikes;

}
