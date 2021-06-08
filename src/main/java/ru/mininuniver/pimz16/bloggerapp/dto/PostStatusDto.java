package ru.mininuniver.pimz16.bloggerapp.dto;

import io.swagger.annotations.ApiModel;

@ApiModel("Представление статуса публикации")
public enum PostStatusDto {
    TO_DO,
    DRAFT,
    SCHEDULED,
    PUBLISHED
}
