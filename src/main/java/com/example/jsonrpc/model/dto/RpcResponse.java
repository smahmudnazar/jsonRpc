package com.example.jsonrpc.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 15:49 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RpcResponse<T> {
    @JsonProperty("jsonrpc")
    private String jsonRpc;
    private Object id;
    private T result;

    public static <C> RpcResponse<C> responseBuilder(RpcRequest<?> request, C result) {
        return RpcResponse.<C>builder()
                .id(request.getId())
                .jsonRpc(request.getJsonRpc())
                .result(result)
                .build();
    }
}
