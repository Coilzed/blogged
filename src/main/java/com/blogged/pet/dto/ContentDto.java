package com.blogged.pet.dto;

import javax.validation.constraints.NotBlank;

public class ContentDto {

    @NotBlank
    private String header;

    @NotBlank
    private String text;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
