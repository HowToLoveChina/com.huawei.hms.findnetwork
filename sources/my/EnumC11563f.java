package my;

import java.util.Objects;

/* renamed from: my.f */
/* loaded from: classes9.dex */
public enum EnumC11563f {
    CR("\r"),
    CRLF("\r\n"),
    LF("\n");


    /* renamed from: a */
    public final String f53621a;

    EnumC11563f(String str) {
        Objects.requireNonNull(str, "lineSeparator");
        this.f53621a = str;
    }

    /* renamed from: e */
    public String m69041e() {
        return this.f53621a;
    }
}
