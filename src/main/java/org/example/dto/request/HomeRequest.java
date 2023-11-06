package org.example.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class HomeRequest {
    @NotBlank
    @Length(min = 3, max = 30)
    private String name;
    @Length(min = 3, max = 30)
    private String address;
}
