package com.ll.cha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Article {
    private Long id;
    private String title;
}
