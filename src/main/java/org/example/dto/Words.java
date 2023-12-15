package org.example.dto;

import lombok.Data;

@Data
public class Words {
    private Integer id;
    private String word;
    private String translate;
    private String description;
}
