package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.a */
/* loaded from: classes8.dex */
public abstract class AbstractC5513a {

    /* renamed from: a */
    private static C5580z0 f25135a;

    /* renamed from: a */
    private static synchronized C5580z0 m32419a() {
        try {
            if (f25135a == null) {
                f25135a = C5561q.m32698c().m32701b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f25135a;
    }

    /* renamed from: b */
    public static void m32422b(int i10, String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        if (m32419a() == null || !C5563q1.m32725b().m32726a()) {
            return;
        }
        if (i10 == 1 || i10 == 0) {
            f25135a.m32845b(i10, str, linkedHashMap);
            return;
        }
        C5571v.m32794d("hmsSdk", "Data type no longer collects range.type: " + i10);
    }

    /* renamed from: c */
    public static void m32424c() {
        if (m32419a() == null || !C5563q1.m32725b().m32726a()) {
            return;
        }
        f25135a.m32841a(-1);
    }

    /* renamed from: a */
    public static void m32420a(int i10, String str, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        if (m32419a() == null || !C5563q1.m32725b().m32726a()) {
            return;
        }
        if (i10 == 1 || i10 == 0) {
            f25135a.m32842a(i10, str, linkedHashMap);
            return;
        }
        C5571v.m32794d("hmsSdk", "Data type no longer collects range.type: " + i10);
    }

    /* renamed from: b */
    public static boolean m32423b() {
        return C5561q.m32698c().m32700a();
    }

    @Deprecated
    /* renamed from: a */
    public static void m32421a(Context context, String str, String str2) throws JSONException {
        if (m32419a() != null) {
            f25135a.m32843a(context, str, str2);
        }
    }
}
