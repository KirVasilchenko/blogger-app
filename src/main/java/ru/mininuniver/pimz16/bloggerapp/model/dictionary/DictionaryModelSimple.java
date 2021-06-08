package ru.mininuniver.pimz16.bloggerapp.model.dictionary;

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
@ApiModel("Абстрактная сущность справочника")
public class DictionaryModelSimple {

    @ApiModelProperty("Идентификатор")
    private Integer id;

    @ApiModelProperty("Строковое значение экземпляра сущности")
    private String value;

}
