package com.huawei.hwcloudjs.p154d.p158c.p159a;

import android.content.SharedPreferences;
import com.huawei.hwcloudjs.C6618c;
import com.huawei.hwcloudjs.p151b.C6617a;

/* renamed from: com.huawei.hwcloudjs.d.c.a.a */
/* loaded from: classes8.dex */
public final class C6643a {

    /* renamed from: a */
    private static C6643a f30852a = null;

    /* renamed from: b */
    private static final String f30853b = "SharedPreferencesStorage";

    private C6643a() {
    }

    /* renamed from: b */
    public static synchronized C6643a m37830b() {
        try {
            if (f30852a == null) {
                f30852a = new C6643a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f30852a;
    }

    /* renamed from: a */
    public void m37831a() {
        if (C6617a.m37753a() != null) {
            C6617a.m37753a().getSharedPreferences(C6618c.f30775t, 0).edit().clear().commit();
        }
    }

    /* renamed from: c */
    public String m37835c() {
        return C6617a.m37753a() != null ? C6617a.m37753a().getSharedPreferences(C6618c.f30775t, 0).getString(C6618c.f30776u, "") : "";
    }

    /* renamed from: a */
    public void m37832a(String str, boolean z10) {
        if (C6617a.m37753a() != null) {
            SharedPreferences.Editor editorEdit = C6617a.m37753a().getSharedPreferences(C6618c.f30775t, 0).edit();
            editorEdit.putBoolean(str, z10);
            editorEdit.commit();
        }
    }

    /* renamed from: b */
    public void m37834b(String str) {
        if (C6617a.m37753a() != null) {
            SharedPreferences.Editor editorEdit = C6617a.m37753a().getSharedPreferences(C6618c.f30775t, 0).edit();
            editorEdit.putString(C6618c.f30776u, str);
            editorEdit.commit();
        }
    }

    /* renamed from: a */
    public boolean m37833a(String str) {
        if (C6617a.m37753a() != null) {
            return C6617a.m37753a().getSharedPreferences(C6618c.f30775t, 0).getBoolean(str, false);
        }
        return false;
    }
}
