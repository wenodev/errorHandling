package com.example.handleError.dto;

import javax.validation.constraints.NotBlank;

public class ProductData {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
