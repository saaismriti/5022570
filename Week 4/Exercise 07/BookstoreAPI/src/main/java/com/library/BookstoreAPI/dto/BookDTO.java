package com.library.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Include only non-null fields
public class BookDTO {
    
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("author")
    private String author;
    
    @JsonProperty("price")
    private double price;
    
    @JsonProperty("isbn")
    private String isbn;
}
