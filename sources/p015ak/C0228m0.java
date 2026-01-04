package p015ak;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;
import p399jk.AbstractC10896a;

/* renamed from: ak.m0 */
/* loaded from: classes6.dex */
public class C0228m0 {

    /* renamed from: a */
    public String f848a;

    /* renamed from: ak.m0$b */
    public static class b {

        /* renamed from: a */
        public static C0228m0 f849a = new C0228m0();
    }

    /* renamed from: b */
    public static C0228m0 m1597b() {
        return b.f849a;
    }

    /* renamed from: a */
    public String m1598a() {
        return UUID.randomUUID().toString();
    }

    /* renamed from: c */
    public String m1599c() {
        if (!TextUtils.isEmpty(this.f848a)) {
            return this.f848a;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("UUIDUtil", "context is null");
            return "";
        }
        String strM1364n = C0212e0.m1364n(contextM1377a, "uuid_sp", "uuid", "");
        this.f848a = strM1364n;
        if (!TextUtils.isEmpty(strM1364n)) {
            return this.f848a;
        }
        String strM1598a = m1598a();
        this.f848a = strM1598a;
        m1600d(strM1598a);
        return this.f848a;
    }

    /* renamed from: d */
    public final void m1600d(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("UUIDUtil", "context is null");
        } else {
            C0212e0.m1373w(contextM1377a, "uuid_sp", "uuid", str);
        }
    }

    public C0228m0() {
    }
}
