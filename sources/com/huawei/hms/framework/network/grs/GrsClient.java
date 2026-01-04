package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class GrsClient {
    private static final String EMPTY_STRING = "";
    private final C5431c grsClientGlobal;
    private int queryTimeout;

    public GrsClient(Context context, GrsBaseInfo grsBaseInfo) {
        if (context == null || grsBaseInfo == null) {
            throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
        }
        this.grsClientGlobal = C5433d.m32187a(grsBaseInfo, context);
        this.queryTimeout = grsBaseInfo.getQueryTimeout();
    }

    public void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        C5431c c5431c = this.grsClientGlobal;
        if (c5431c == null) {
            iQueryUrlCallBack.onCallBackFail(-8);
        } else {
            c5431c.m32184a(str, str2, iQueryUrlCallBack, this.queryTimeout);
        }
    }

    public void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        C5431c c5431c = this.grsClientGlobal;
        if (c5431c == null) {
            iQueryUrlsCallBack.onCallBackFail(-8);
        } else {
            c5431c.m32183a(str, iQueryUrlsCallBack, this.queryTimeout);
        }
    }

    public void clearSp() {
        C5431c c5431c = this.grsClientGlobal;
        if (c5431c == null) {
            return;
        }
        c5431c.m32182a();
    }

    public boolean forceExpire() {
        C5431c c5431c = this.grsClientGlobal;
        if (c5431c == null) {
            return false;
        }
        return c5431c.m32186b();
    }

    public String synGetGrsUrl(String str, String str2) {
        C5431c c5431c = this.grsClientGlobal;
        return c5431c == null ? "" : c5431c.m32180a(str, str2, this.queryTimeout);
    }

    public Map<String, String> synGetGrsUrls(String str) {
        C5431c c5431c = this.grsClientGlobal;
        return c5431c == null ? new HashMap() : c5431c.m32181a(str, this.queryTimeout);
    }
}
