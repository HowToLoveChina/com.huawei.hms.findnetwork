package com.huawei.hms.drive;

/* renamed from: com.huawei.hms.drive.cw */
/* loaded from: classes8.dex */
public enum EnumC5246cw {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* renamed from: l */
    public final int f24267l;

    EnumC5246cw(int i10) {
        this.f24267l = i10;
    }

    /* renamed from: a */
    public static EnumC5246cw m31455a(int i10) {
        for (EnumC5246cw enumC5246cw : values()) {
            if (enumC5246cw.f24267l == i10) {
                return enumC5246cw;
            }
        }
        return null;
    }
}
