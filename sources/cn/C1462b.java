package cn;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p231dn.C9279a;
import p231dn.InterfaceC9280b;
import p263en.EnumC9527a;

/* renamed from: cn.b */
/* loaded from: classes6.dex */
public final class C1462b {

    /* renamed from: a */
    public static final CopyOnWriteArrayList<InterfaceC9280b> f6260a = new CopyOnWriteArrayList<>(Arrays.asList(new C9279a()));

    /* renamed from: b */
    public static final Map<String, String> f6261b = new ConcurrentHashMap();

    /* renamed from: c */
    public static final C1462b f6262c = new C1462b();

    /* renamed from: b */
    public static void m8361b(String str, Object obj) {
        f6262c.m8365d(EnumC9527a.ERROR, null, str, obj, null);
    }

    /* renamed from: f */
    public static void m8362f(String str, Object obj) {
        f6262c.m8365d(EnumC9527a.WARN, null, str, obj, null);
    }

    /* renamed from: a */
    public final String m8363a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "-" + str;
    }

    /* renamed from: c */
    public final String m8364c(Object obj, Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        if (obj != null) {
            sb2.append(obj);
        }
        if (th2 != null) {
            sb2.append('\n');
            sb2.append(th2.getMessage());
        }
        return sb2.toString();
    }

    /* renamed from: d */
    public final void m8365d(EnumC9527a enumC9527a, String str, String str2, Object obj, Throwable th2) {
        Iterator<InterfaceC9280b> it = f6260a.iterator();
        while (it.hasNext()) {
            it.next().mo58343a(enumC9527a, m8366e(str, str2), m8364c(obj, th2));
        }
    }

    /* renamed from: e */
    public final String m8366e(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str = f6261b.get(str2);
        }
        sb2.append(m8363a(str));
        sb2.append(m8363a(str2));
        return sb2.toString();
    }
}
