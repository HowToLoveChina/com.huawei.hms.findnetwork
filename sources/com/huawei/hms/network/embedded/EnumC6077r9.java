package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.r9 */
/* loaded from: classes8.dex */
public enum EnumC6077r9 {
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


    /* renamed from: a */
    public final int f28121a;

    EnumC6077r9(int i10) {
        this.f28121a = i10;
    }

    /* renamed from: a */
    public static EnumC6077r9 m35230a(int i10) {
        for (EnumC6077r9 enumC6077r9 : values()) {
            if (enumC6077r9.f28121a == i10) {
                return enumC6077r9;
            }
        }
        return null;
    }
}
