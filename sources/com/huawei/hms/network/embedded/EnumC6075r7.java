package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.r7 */
/* loaded from: classes8.dex */
public enum EnumC6075r7 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC(C5927g2.QUIC);


    /* renamed from: a */
    public final String f28108a;

    EnumC6075r7(String str) {
        this.f28108a = str;
    }

    /* renamed from: a */
    public static EnumC6075r7 m35227a(String str) throws IOException {
        EnumC6075r7 enumC6075r7 = HTTP_1_0;
        if (str.equals(enumC6075r7.f28108a)) {
            return enumC6075r7;
        }
        EnumC6075r7 enumC6075r72 = HTTP_1_1;
        if (str.equals(enumC6075r72.f28108a)) {
            return enumC6075r72;
        }
        EnumC6075r7 enumC6075r73 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(enumC6075r73.f28108a)) {
            return enumC6075r73;
        }
        EnumC6075r7 enumC6075r74 = HTTP_2;
        if (str.equals(enumC6075r74.f28108a)) {
            return enumC6075r74;
        }
        EnumC6075r7 enumC6075r75 = SPDY_3;
        if (str.equals(enumC6075r75.f28108a)) {
            return enumC6075r75;
        }
        EnumC6075r7 enumC6075r76 = QUIC;
        if (str.equals(enumC6075r76.f28108a)) {
            return enumC6075r76;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f28108a;
    }
}
