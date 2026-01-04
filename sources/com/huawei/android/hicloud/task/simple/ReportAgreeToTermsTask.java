package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import gp.C10028c;
import java.util.HashMap;
import java.util.Map;
import p015ak.C0209d;
import p458lo.C11322a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* loaded from: classes3.dex */
public class ReportAgreeToTermsTask extends AbstractC12367d {

    /* renamed from: b */
    public static final Object f13101b = new Object();

    /* renamed from: a */
    public Context f13102a;

    public ReportAgreeToTermsTask(Context context) {
        this.f13102a = context;
    }

    /* renamed from: c */
    public final Map<String, String> m18104c(C10028c c10028c) {
        String strValueOf = String.valueOf(c10028c.m62306b0("huawei_privacy_policy"));
        String strValueOf2 = String.valueOf(c10028c.m62306b0("about_cloud_and_privacy"));
        String strValueOf3 = String.valueOf(c10028c.m62306b0("cloud_user_agreement"));
        HashMap map = new HashMap();
        map.put("huawei_privacy_policy", strValueOf);
        map.put("about_cloud_and_privacy", strValueOf2);
        map.put("cloud_user_agreement", strValueOf3);
        return map;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        synchronized (f13101b) {
            try {
                if (m18105d(this.f13102a)) {
                    C11322a c11322a = new C11322a();
                    C10028c c10028cM62183d0 = C10028c.m62183d0(this.f13102a);
                    boolean zM68017a = c11322a.m68017a(m18104c(c10028cM62183d0));
                    C11839m.m70688i("ReportAgreeToTermsTask", "Agree to terms report: " + zM68017a);
                    if (zM68017a) {
                        c10028cM62183d0.m62377p3("agree_to_terms_result", true);
                    } else {
                        c10028cM62183d0.m62377p3("agree_to_terms_result", false);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public final boolean m18105d(Context context) {
        if (!C0209d.m1309t1(context)) {
            return false;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        return !c10028cM62183d0.m62395t1("agree_to_terms_result") && c10028cM62183d0.m62221H1();
    }
}
