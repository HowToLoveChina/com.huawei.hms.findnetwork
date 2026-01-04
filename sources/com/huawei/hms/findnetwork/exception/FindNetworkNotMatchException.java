package com.huawei.hms.findnetwork.exception;

import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;

/* loaded from: classes8.dex */
public class FindNetworkNotMatchException extends FindNetworkException {
    private static final String EXCEP_MSG = "The HMS core version don't match 601000300";

    public FindNetworkNotMatchException(int i10) {
        super(EXCEP_MSG, i10);
    }
}
