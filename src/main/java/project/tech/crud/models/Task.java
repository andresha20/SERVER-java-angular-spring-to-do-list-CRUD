package project.tech.crud.models;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Task {
    @Id
    private String id;
    @NotEmpty
    private String name;
    @NotNull
    private boolean completed;
}

