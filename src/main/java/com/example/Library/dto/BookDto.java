package com.example.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private String name;
    private String edition;
    private  Integer volume;
}
