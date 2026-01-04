package com.huawei.hms.findnetwork.exception;

import com.huawei.hms.findnetwork.comm.exception.FindNetworkException;

/* loaded from: classes8.dex */
public class FindNetworkUnsupportedException extends FindNetworkException {
    private static final String DESC_FUNCTION_UNSUPPORTED = "Current function is unsupported on version: %s";
    private static final String ERR_DESC = String.format(DESC_FUNCTION_UNSUPPORTED, "6.15.2.320");

    public FindNetworkUnsupportedException(int i10) {
        super(ERR_DESC, i10);
    }
}
