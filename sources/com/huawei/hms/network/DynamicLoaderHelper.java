package com.huawei.hms.network;

/* loaded from: classes8.dex */
public class DynamicLoaderHelper {

    /* renamed from: b */
    private static final DynamicLoaderHelper f25619b = new DynamicLoaderHelper();

    /* renamed from: a */
    private boolean f25620a = false;

    private DynamicLoaderHelper() {
    }

    public static DynamicLoaderHelper getInstance() {
        return f25619b;
    }

    public synchronized boolean getDynamicStatus() {
        return this.f25620a;
    }

    public synchronized void setDynamicStatus(boolean z10) {
        this.f25620a = z10;
    }
}
