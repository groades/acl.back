package com.groades.acl.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreationRequest {
    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    private String description;
}
