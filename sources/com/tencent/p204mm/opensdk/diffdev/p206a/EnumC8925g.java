package com.tencent.p204mm.opensdk.diffdev.p206a;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.g */
/* loaded from: classes9.dex */
public enum EnumC8925g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);

    private int code;

    EnumC8925g(int i10) {
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
