package com.huawei.hianalytics.framework.listener;

/* loaded from: classes5.dex */
public class HAEventManager {

    /* renamed from: b */
    public static final HAEventManager f21810b = new HAEventManager();

    /* renamed from: a */
    public IHAEventListener f21811a;

    public static HAEventManager getInstance() {
        return f21810b;
    }

    public IHAEventListener getEventListener() {
        return this.f21811a;
    }

    public void setEventListener(IHAEventListener iHAEventListener) {
        this.f21811a = iHAEventListener;
    }
}
