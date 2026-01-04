package com.huawei.hms.push;

/* loaded from: classes8.dex */
public enum AttributionEvent {
    APP_START_COMPLETE(1),
    OPEN_PRIVACY_PAGE(2),
    REJECT_PRIVACY(3),
    AGREED_PRIVACY(4),
    PERMISSION_GRANTED(5),
    PERMISSION_DENIED(6),
    OPEN_LANDING_PAGE(7);


    /* renamed from: a */
    private final int f29599a;

    AttributionEvent(int i10) {
        this.f29599a = i10;
    }

    public int getEventId() {
        return this.f29599a;
    }
}
