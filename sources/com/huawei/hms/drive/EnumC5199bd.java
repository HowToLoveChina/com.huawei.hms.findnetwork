package com.huawei.hms.drive;

import com.huawei.hms.network.embedded.C5927g2;
import java.io.IOException;

/* renamed from: com.huawei.hms.drive.bd */
/* loaded from: classes8.dex */
public enum EnumC5199bd {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC(C5927g2.QUIC);


    /* renamed from: g */
    private final String f23909g;

    EnumC5199bd(String str) {
        this.f23909g = str;
    }

    /* renamed from: a */
    public static EnumC5199bd m31091a(String str) throws IOException {
        EnumC5199bd enumC5199bd = HTTP_1_0;
        if (str.equals(enumC5199bd.f23909g)) {
            return enumC5199bd;
        }
        EnumC5199bd enumC5199bd2 = HTTP_1_1;
        if (str.equals(enumC5199bd2.f23909g)) {
            return enumC5199bd2;
        }
        EnumC5199bd enumC5199bd3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(enumC5199bd3.f23909g)) {
            return enumC5199bd3;
        }
        EnumC5199bd enumC5199bd4 = HTTP_2;
        if (str.equals(enumC5199bd4.f23909g)) {
            return enumC5199bd4;
        }
        EnumC5199bd enumC5199bd5 = SPDY_3;
        if (str.equals(enumC5199bd5.f23909g)) {
            return enumC5199bd5;
        }
        EnumC5199bd enumC5199bd6 = QUIC;
        if (str.equals(enumC5199bd6.f23909g)) {
            return enumC5199bd6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f23909g;
    }
}
