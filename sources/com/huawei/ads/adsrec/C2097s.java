package com.huawei.ads.adsrec;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p216d4.C9020l;
import p216d4.C9027o0;
import p216d4.C9031r;
import p216d4.InterfaceC9032s;
import p277f4.C9655a;
import p277f4.InterfaceC9656b;
import p405jt.AbstractC10915a;

/* renamed from: com.huawei.ads.adsrec.s */
/* loaded from: classes.dex */
public class C2097s implements InterfaceC9032s {

    /* renamed from: a */
    public Context f9501a;

    public C2097s(Context context) {
        this.f9501a = context.getApplicationContext();
    }

    @Override // p216d4.InterfaceC9032s
    /* renamed from: a */
    public <T> C9020l mo12549a(C9655a c9655a, C9020l c9020l) throws JSONException {
        m12554d(c9020l, c9655a);
        return c9020l;
    }

    @Override // p216d4.InterfaceC9032s
    /* renamed from: b */
    public <T> C9020l mo12550b(C9655a c9655a, T t10) {
        AbstractC10915a.m65972d("CloudRecallTask", "recall");
        if (!(t10 instanceof InterfaceC9656b)) {
            AbstractC10915a.m65972d("CloudRecallTask", "not delegate");
            return null;
        }
        try {
            String strRequestAd = ((InterfaceC9656b) t10).requestAd();
            if (strRequestAd == null) {
                return null;
            }
            C9020l c9020l = new C9020l(c9655a.m60304j(), new JSONObject(strRequestAd));
            m12554d(c9020l, c9655a);
            return c9020l;
        } catch (Throwable th2) {
            AbstractC10915a.m65978j("CloudRecallTask", "delegate recall err: " + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: c */
    public final void m12553c(C9020l c9020l) {
        new C2093e(this.f9501a).mo12536c(c9020l.m56944o());
    }

    /* renamed from: d */
    public final void m12554d(C9020l c9020l, C9655a c9655a) throws JSONException {
        m12556f(c9020l, c9655a);
        m12553c(c9020l);
        m12555e(c9020l);
    }

    /* renamed from: e */
    public final void m12555e(C9020l c9020l) {
        new C2093e(this.f9501a).mo12539f(c9020l.m56946q());
    }

    /* renamed from: f */
    public final void m12556f(C9020l c9020l, C9655a c9655a) throws JSONException {
        List<C9031r> listM56946q = c9020l.m56946q();
        C9027o0 c9027o0M56955b = C9027o0.m56955b(this.f9501a);
        if (listM56946q != null) {
            for (C9031r c9031r : listM56946q) {
                JSONObject jSONObjectM56972m = c9031r.m56972m();
                if (jSONObjectM56972m != null) {
                    String strOptString = jSONObjectM56972m.optString("configMap");
                    if (!TextUtils.isEmpty(strOptString)) {
                        try {
                            c9027o0M56955b.m56958c(c9031r.m56976q(), new JSONObject(strOptString), c9655a);
                        } catch (Throwable unused) {
                            AbstractC10915a.m65978j("CloudRecallTask", "save cfgs json err");
                        }
                    }
                }
            }
        }
    }
}
