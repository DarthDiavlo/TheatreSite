package ru.mirea.theatre.modeldata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerfomanceDTO {
    private int id;
    private String name;
    private LocalDateTime date;
    private String decription;
    private int ticketsLeft;
    private int minPrice;
    private int maxPrice;
    private String style;
    private List<String> workerNames;
    private String imageBase64;
}
