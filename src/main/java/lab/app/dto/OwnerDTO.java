package lab.app.dto;

import lab.app.entities.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public @Data class OwnerDTO {

    @NonNull
    private long id;

    @NonNull
    private String name;

    @NonNull
    private LocalDate date;

    @NonNull
    private List<Cat> cats = new ArrayList<>();
}
