package p755wx;

/* renamed from: wx.b */
/* loaded from: classes9.dex */
public enum EnumC13653b {
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
    public final int f61376a;

    EnumC13653b(int i10) {
        this.f61376a = i10;
    }

    /* renamed from: b */
    public static EnumC13653b m82040b(int i10) {
        for (EnumC13653b enumC13653b : values()) {
            if (enumC13653b.f61376a == i10) {
                return enumC13653b;
            }
        }
        return null;
    }
}
