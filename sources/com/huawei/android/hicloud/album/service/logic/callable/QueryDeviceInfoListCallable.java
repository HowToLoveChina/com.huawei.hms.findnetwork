package com.huawei.android.hicloud.album.service.logic.callable;

import com.huawei.android.hicloud.album.service.CallbackHandler;
import p031b7.C1122c;
import p581qk.AbstractC12367d;

/* loaded from: classes2.dex */
public class QueryDeviceInfoListCallable extends AbstractC12367d {
    private static final int CLIENT_TYPE = 4;
    private static final int PROD_TYPE = 1;
    private static final String TAG = "QueryDeviceInfoListCallable";
    private CallbackHandler callbackHandler;

    public QueryDeviceInfoListCallable(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    private long getUserDeviceInfoInterval() {
        return C1122c.m6839v0() != null ? r2.getUserDeviceInfoInterval() : 24;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f6  */
    @Override // p616rk.AbstractRunnableC12516b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void call() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.callable.QueryDeviceInfoListCallable.call():void");
    }
}
