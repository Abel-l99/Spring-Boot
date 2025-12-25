package com.ayawo.library.book.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BookDTO {

    @Data
    @AllArgsConstructor
    @Builder
    public static class PostInput{

        @NotNull @NotBlank  // il faut d'abord ajouter la dépendence et le valider dans l'appel
        String bookName;

        @Min(value = 1)
        int bookPages;

    }

    @Data
    @AllArgsConstructor
    @Builder
    public static class PostOutput {
        Long id;
        String bookName;
        int bookPages;
    }

}
