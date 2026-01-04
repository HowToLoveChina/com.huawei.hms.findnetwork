package com.huawei.hwcloudjs.service.debugtool;

import com.huawei.hwcloudjs.support.enables.NoProguard;

/* loaded from: classes8.dex */
public class SetUrl {

    /* renamed from: a */
    private static SetUrl f30913a;

    /* renamed from: b */
    private GetUrlCallBack f30914b;

    @NoProguard
    public interface GetUrlCallBack {
        void onResult(String str);
    }

    /* renamed from: a */
    public static synchronized SetUrl m37916a() {
        try {
            if (f30913a == null) {
                f30913a = new SetUrl();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f30913a;
    }

    /* renamed from: b */
    public GetUrlCallBack m37918b() {
        return this.f30914b;
    }

    /* renamed from: a */
    public void m37917a(GetUrlCallBack getUrlCallBack) {
        this.f30914b = getUrlCallBack;
    }
}
