package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class ForegroundBusResponseMgr {

    /* renamed from: b */
    private static final ForegroundBusResponseMgr f23070b = new ForegroundBusResponseMgr();

    /* renamed from: a */
    private final Map<String, BusResponseCallback> f23071a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f23070b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f23071a) {
            busResponseCallback = this.f23071a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.f23071a) {
            try {
                if (!this.f23071a.containsKey(str)) {
                    this.f23071a.put(str, busResponseCallback);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f23071a) {
            this.f23071a.remove(str);
        }
    }
}
