package com.example.jsonrpc.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 16:31 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RpcException {
    @JsonProperty("jsonrpc")
    private String jsonRpc;
    private Object id;
    private ExceptionResponse error;
}
