package com.example.jsonrpc.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 11:22 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RpcRequest<T> {
    @JsonProperty("jsonrpc")
    @Pattern(regexp = "^2\\.0$", message = "must be exactly 2.0")
    private String jsonRpc;

    @NotBlank
    private String method;

    @NotNull
    private Object id;

    @NotNull
    private T params;
}
