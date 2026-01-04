package com.huawei.hms.findnetwork.exception;

import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;

/* loaded from: classes8.dex */
public class FindNetworkVerifyException extends FindNetworkException {
    private static final String EXCEP_MSG = "incorrect parameter format";

    public FindNetworkVerifyException(int i10) {
        super(EXCEP_MSG, i10);
    }
}
