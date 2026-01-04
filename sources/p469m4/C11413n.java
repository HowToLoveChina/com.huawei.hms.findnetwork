package p469m4;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p443l4.InterfaceC11231c;

/* renamed from: m4.n */
/* loaded from: classes.dex */
public class C11413n implements InterfaceC11231c {

    /* renamed from: a */
    public final Map<String, String> f53187a = new ConcurrentHashMap();

    /* renamed from: b */
    public final C11411l f53188b;

    public C11413n(Context context, String str) {
        this.f53188b = new C11411l(context, str);
    }

    @Override // p443l4.InterfaceC11231c
    public String getString(String str, String str2) {
        String str3 = this.f53187a.get(str);
        if (str3 != null) {
            return str3;
        }
        String strM68358b = this.f53188b.m68358b(str, str2);
        if (strM68358b == null) {
            return str2;
        }
        this.f53187a.put(str, strM68358b);
        return strM68358b;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
