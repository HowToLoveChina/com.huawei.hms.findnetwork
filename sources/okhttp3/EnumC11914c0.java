package okhttp3;

import com.huawei.hms.network.embedded.C5927g2;
import java.io.IOException;

/* renamed from: okhttp3.c0 */
/* loaded from: classes9.dex */
public enum EnumC11914c0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC(C5927g2.QUIC);


    /* renamed from: a */
    public final String f55235a;

    EnumC11914c0(String str) {
        this.f55235a = str;
    }

    /* renamed from: b */
    public static EnumC11914c0 m71525b(String str) throws IOException {
        EnumC11914c0 enumC11914c0 = HTTP_1_0;
        if (str.equals(enumC11914c0.f55235a)) {
            return enumC11914c0;
        }
        EnumC11914c0 enumC11914c02 = HTTP_1_1;
        if (str.equals(enumC11914c02.f55235a)) {
            return enumC11914c02;
        }
        EnumC11914c0 enumC11914c03 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(enumC11914c03.f55235a)) {
            return enumC11914c03;
        }
        EnumC11914c0 enumC11914c04 = HTTP_2;
        if (str.equals(enumC11914c04.f55235a)) {
            return enumC11914c04;
        }
        EnumC11914c0 enumC11914c05 = SPDY_3;
        if (str.equals(enumC11914c05.f55235a)) {
            return enumC11914c05;
        }
        EnumC11914c0 enumC11914c06 = QUIC;
        if (str.equals(enumC11914c06.f55235a)) {
            return enumC11914c06;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f55235a;
    }
}
