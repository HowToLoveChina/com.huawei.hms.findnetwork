package p317go;

import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.request.appmashup.bean.C4984c;
import com.huawei.hicloud.request.appmashup.bean.C4985d;
import com.huawei.hicloud.request.appmashup.bean.C4986e;
import fk.C9721b;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p664u0.C13108a;
import tm.C13040c;

/* renamed from: go.a */
/* loaded from: classes6.dex */
public class C10025a {

    /* renamed from: a */
    public static final Gson f48982a = new Gson();

    /* renamed from: go.a$a */
    public static class a {

        /* renamed from: a */
        public static C10025a f48983a = new C10025a();
    }

    /* renamed from: c */
    public static C10025a m62170c() {
        return a.f48983a;
    }

    /* renamed from: a */
    public final String m62171a(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public final <T> T m62172b(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f48982a.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10);
        }
    }

    /* renamed from: d */
    public C4986e m62173d(C4984c c4984c, String str) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            str = "getParams";
        }
        try {
            return (C4986e) m62172b(m62175f(new C4985d("getParams", c4984c.m30016c()), m62174e(str), C13040c.m78609F().m78627S("com.huawei.hicloud.v2", C13040c.m78609F().m78613D(c4984c.m30017d())) + c4984c.m30015b(), c4984c.m30014a(), c4984c.m30018e()), C4986e.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AppMashupService", "queryPushGuideAgreement, json exception is: " + e10.toString());
            throw new C9721b(1, "json err");
        }
    }

    /* renamed from: e */
    public C11060c m62174e(String str) {
        C11060c c11060c = new C11060c();
        c11060c.m66636B(str);
        c11060c.m66643I(C11058a.m66627b(str));
        c11060c.m66637C("com.huawei.hidisk\u0001_cloud");
        c11060c.m66670z("1.0");
        return c11060c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fc, code lost:
    
        throw new fk.C9721b(r11, r10.m30013b());
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m62175f(com.huawei.hicloud.request.appmashup.bean.C4982a r20, p429kk.C11060c r21, java.lang.String r22, int r23, java.lang.String r24) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p317go.C10025a.m62175f(com.huawei.hicloud.request.appmashup.bean.a, kk.c, java.lang.String, int, java.lang.String):java.lang.String");
    }

    /* renamed from: g */
    public final void m62176g() {
        C11839m.m70689w("AppMashupService", "sendAuthFail business server auth failed.");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: h */
    public final boolean m62177h(C9721b c9721b) {
        return c9721b.m60659c() == 9002 || c9721b.m60659c() == 9005 || c9721b.m60659c() == 9003 || c9721b.m60659c() == 9001 || c9721b.m60659c() == 9100;
    }
}
