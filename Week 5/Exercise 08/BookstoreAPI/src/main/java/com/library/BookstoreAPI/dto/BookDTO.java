package com.library.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {

    @JsonProperty("id")
    private int id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "Author cannot be null")
    @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters")
    @JsonProperty("author")
    private String author;

    @Min(value = 0, message = "Price must be non-negative")
    @JsonProperty("price")
    private double price;

    @NotNull(message = "ISBN cannot be null")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    @JsonProperty("isbn")
    private String isbn;
}
