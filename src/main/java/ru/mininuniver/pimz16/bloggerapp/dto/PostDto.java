package ru.mininuniver.pimz16.bloggerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostDto {

    private String id;
    private String title;
    private String content;
    private PostStatus status;

}
