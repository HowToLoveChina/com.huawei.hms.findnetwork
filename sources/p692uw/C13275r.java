package p692uw;

import p824yw.InterfaceC14050b;
import p824yw.InterfaceC14051c;
import p824yw.InterfaceC14054f;

/* renamed from: uw.r */
/* loaded from: classes9.dex */
public class C13275r {
    /* renamed from: a */
    public InterfaceC14050b m79695a(Class cls) {
        return new C13262e(cls);
    }

    /* renamed from: b */
    public InterfaceC14051c m79696b(Class cls, String str) {
        return new C13269l(cls, str);
    }

    /* renamed from: c */
    public InterfaceC14054f m79697c(AbstractC13270m abstractC13270m) {
        return abstractC13270m;
    }

    /* renamed from: d */
    public String m79698d(InterfaceC13265h interfaceC13265h) {
        String string = interfaceC13265h.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    /* renamed from: e */
    public String m79699e(AbstractC13268k abstractC13268k) {
        return m79698d(abstractC13268k);
    }
}
