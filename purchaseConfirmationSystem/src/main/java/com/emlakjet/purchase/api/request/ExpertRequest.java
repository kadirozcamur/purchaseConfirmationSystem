package com.emlakjet.purchase.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The type Expert request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class ExpertRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String mail;
}
