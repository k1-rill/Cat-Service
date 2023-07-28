package lab.app.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public @Data class CatDTO {

    @NonNull
    private String name;

    @NonNull
    private long id;

    @NonNull
    private LocalDate date;

    @NonNull
    private String breed;

    @NonNull
    private String color;
}
