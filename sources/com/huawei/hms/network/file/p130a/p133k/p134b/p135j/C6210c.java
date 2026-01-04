package com.huawei.hms.network.file.p130a.p133k.p134b.p135j;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.PLSharedPreferences;
import gu.C10048b;
import gu.C10050d;

/* renamed from: com.huawei.hms.network.file.a.k.b.j.c */
/* loaded from: classes8.dex */
class C6210c {

    /* renamed from: a */
    private static volatile C10050d f29339a;

    /* renamed from: b */
    private static final Object f29340b = new Object();

    /* renamed from: a */
    public static C10050d m36135a() {
        if (f29339a == null) {
            synchronized (f29340b) {
                try {
                    if (f29339a == null) {
                        C10048b.m62475g(true);
                        String strM36136a = m36136a("cat", true);
                        String strM36136a2 = m36136a("dog", true);
                        String strM36136a3 = m36136a("pig", false);
                        if (TextUtils.isEmpty(strM36136a3)) {
                            strM36136a3 = "945e7f66c50dfefe6132c4acdf33005e";
                        }
                        f29339a = C10050d.m62478e(strM36136a, strM36136a2, strM36136a3, m36136a("salt", true));
                    }
                } finally {
                }
            }
        }
        return f29339a;
    }

    /* renamed from: a */
    private static String m36136a(String str, boolean z10) {
        PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(ContextHolder.getAppContext(), str);
        String string = pLSharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string) || !z10) {
            return string;
        }
        String strM62473e = C10048b.m62473e(16);
        pLSharedPreferences.putString(str, strM62473e);
        return strM62473e;
    }
}
