package mv;

import android.text.TextUtils;
import p535ov.InterfaceC12038e;
import p535ov.InterfaceC12039f;
import p535ov.InterfaceC12041h;
import p535ov.InterfaceC12043j;

/* renamed from: mv.f */
/* loaded from: classes9.dex */
public final class C11533f {
    /* renamed from: a */
    public static String m68823a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    /* renamed from: b */
    public static String m68824b(InterfaceC12038e interfaceC12038e, String str) {
        return m68823a(interfaceC12038e.message(), str + " must <= " + interfaceC12038e.value());
    }

    /* renamed from: c */
    public static String m68825c(InterfaceC12039f interfaceC12039f, String str) {
        return m68823a(interfaceC12039f.message(), str + " must >= " + interfaceC12039f.value());
    }

    /* renamed from: d */
    public static String m68826d(InterfaceC12041h interfaceC12041h, String str) {
        return m68823a(interfaceC12041h.message(), str + " can't be empty");
    }

    /* renamed from: e */
    public static String m68827e(InterfaceC12043j interfaceC12043j, String str) {
        return m68823a(interfaceC12043j.message(), str + " len must between [" + interfaceC12043j.min() + ", " + interfaceC12043j.max() + "]");
    }
}
