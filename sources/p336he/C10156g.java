package p336he;

import android.text.TextUtils;
import com.huawei.cloud.base.http.C4604g;
import com.huawei.cloud.base.http.C4609l;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import p015ak.C0215g;
import p292fn.C9733f;
import p514o9.C11839m;
import p579qi.AbstractC12361b;
import p783xp.C13843a;
import tm.C13041d;

/* renamed from: he.g */
/* loaded from: classes3.dex */
public class C10156g {
    /* renamed from: a */
    public static String m63304a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = m63305b(str);
        }
        String strM1387c = C0215g.m1384f().m1387c(str2);
        C11839m.m70686d("CookieUtil", "getCookie domain = " + str2 + ", cookies = " + strM1387c);
        return strM1387c;
    }

    /* renamed from: b */
    public static String m63305b(String str) {
        return C13041d.m78675e().m78679d(C13843a.m83101w(str));
    }

    /* renamed from: c */
    public static void m63306c(C4609l c4609l, C4604g c4604g) {
        if (c4609l == null || c4604g == null) {
            C11839m.m70689w("CookieUtil", "headers or url is null");
            return;
        }
        String strM63304a = m63304a(c4604g.toString(), null);
        if (TextUtils.isEmpty(strM63304a)) {
            return;
        }
        c4609l.set("x-hw-cookie", strM63304a);
    }

    /* renamed from: d */
    public static void m63307d(C4609l c4609l, C4604g c4604g) {
        if (C9733f.m60705z().m60726U()) {
            m63306c(c4609l, c4604g);
        }
    }

    /* renamed from: e */
    public static void m63308e(C11918e0.a aVar, String str) {
        if (!C9733f.m60705z().m60726U() || aVar == null) {
            return;
        }
        String strM63304a = m63304a(null, str);
        if (TextUtils.isEmpty(strM63304a)) {
            return;
        }
        aVar.m71574a("x-hw-cookie", strM63304a);
    }

    /* renamed from: f */
    public static void m63309f(AbstractC12361b<?> abstractC12361b) {
        if (!C9733f.m60705z().m60726U() || abstractC12361b == null) {
            return;
        }
        m63306c(abstractC12361b.getHeaders(), abstractC12361b.buildHttpRequestUrl());
    }

    /* renamed from: g */
    public static void m63310g(C4609l c4609l) {
        if (!C9733f.m60705z().m60726U() || c4609l == null) {
            return;
        }
        C0215g.m1384f().m1396m(c4609l);
    }

    /* renamed from: h */
    public static void m63311h(C11922g0 c11922g0) {
        if (!C9733f.m60705z().m60726U() || c11922g0 == null) {
            return;
        }
        C0215g.m1384f().m1393j(c11922g0.m71599w("x-hw-cookie"));
    }
}
