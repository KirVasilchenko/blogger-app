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
@ApiModel("Платформа")
public class Platform {

    @ApiModelProperty("Идентификатор")
    private Integer id;
    @ApiModelProperty("Название")
    private String name;
    @ApiModelProperty("Ссылка на профиль на платформе")
    private String link;
    @ApiModelProperty("Логин")
    private String login;
    @ApiModelProperty("Пароль")
    private String password;

}
