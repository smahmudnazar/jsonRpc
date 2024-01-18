package com.example.jsonrpc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 10:58 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private Integer code;
    private String message;

}
