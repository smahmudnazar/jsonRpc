package com.example.jsonrpc.exception;

import com.example.jsonrpc.model.enums.RpcCode;

/**
 * @author * Sunnatullayev Mahmudnazar *  * jsonRpc *  * 15:51 *
 */
public class MethodNotFoundException extends JsonRpcException {
    public MethodNotFoundException(Object id, RpcCode rpcCode) {
        super(id, rpcCode);
    }

    public MethodNotFoundException(RpcCode rpcCode) {
        super(rpcCode);
    }
}
