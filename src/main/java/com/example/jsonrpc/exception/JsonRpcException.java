package com.example.jsonrpc.exception;

import com.example.jsonrpc.model.enums.RpcCode;
import lombok.Getter;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 15:22 *
 */

@Getter
public abstract class JsonRpcException extends RuntimeException {
    private final Object id;
    private final Integer code;

    public JsonRpcException(Object id, RpcCode rpcCode) {
        super(rpcCode.getMessage());
        this.id = id;
        this.code = rpcCode.getCode();
    }

    public JsonRpcException(RpcCode rpcCode) {
        super(rpcCode.getMessage());
        this.code = rpcCode.getCode();
        this.id = null;
    }
}
