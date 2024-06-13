package com.groades.acl.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateRequest {
    @NotNull(message = "The field id is mandatory")
    private Integer id;
    @NotNull(message = "The field Description is mandatory")
    @NotBlank(message = "The field Description is mandatory")
    private String description;
    @NotNull(message = "the field is valid is mandatory")
    private Boolean isvalid;
}
