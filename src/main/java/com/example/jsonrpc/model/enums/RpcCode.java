package com.example.jsonrpc.model.enums;

import lombok.Getter;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 15:52 *
 */

@Getter
public enum RpcCode {
    PARSE_ERROR(-32700, "Parse error"),
    INVALID_REQUEST(-32600, "Invalid Request"),
    NOT_FOUND(-32601, "Method not found"),
    INVALID_PARAMS(-32602, "Invalid params"),
    INTERNAL_ERROR(-32603, "Internal error"),
    SERVER_ERROR(-32000, "Server error");

    private final Integer code;
    private final String message;

    RpcCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
