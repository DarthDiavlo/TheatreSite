package ru.mirea.theatre.modeldata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsModel {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("fullDescription")
    private String fullDescription;

    @JsonProperty("dateTime")
    @JsonSerialize(using = LocalDateTimeSerializer.class) // Сериализация LocalDateTime
    private LocalDateTime dateTime;

    @JsonProperty("image")
    private String imageBase64;

}