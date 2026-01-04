package es;

import android.content.SharedPreferences;
import as.C1016d;
import java.util.HashMap;
import java.util.Map;
import p531or.C11991a;

/* renamed from: es.n */
/* loaded from: classes8.dex */
public class C9549n {

    /* renamed from: b */
    public static final Map<String, ?> f47455b = new HashMap();

    /* renamed from: a */
    public SharedPreferences f47456a;

    public C9549n(String str) {
        this(str, 0);
    }

    /* renamed from: a */
    public long m59623a(String str) {
        SharedPreferences sharedPreferences = this.f47456a;
        if (sharedPreferences == null) {
            return -1L;
        }
        try {
            return sharedPreferences.getLong(str, -1L);
        } catch (Exception unused) {
            C1016d.m6183c("LocationPreferences", "getLong fail");
            return -1L;
        }
    }

    /* renamed from: b */
    public String m59624b(String str) {
        SharedPreferences sharedPreferences = this.f47456a;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception unused) {
            C1016d.m6183c("LocationPreferences", "getString fail");
            return "";
        }
    }

    /* renamed from: c */
    public boolean m59625c(String str) {
        SharedPreferences sharedPreferences = this.f47456a;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            return sharedPreferences.edit().remove(str).commit();
        } catch (Exception unused) {
            C1016d.m6183c("LocationPreferences", "remove fail");
            return false;
        }
    }

    /* renamed from: d */
    public boolean m59626d(String str, long j10) {
        SharedPreferences sharedPreferences = this.f47456a;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            return sharedPreferences.edit().putLong(str, j10).commit();
        } catch (Exception unused) {
            C1016d.m6183c("LocationPreferences", "saveLong fail");
            return false;
        }
    }

    /* renamed from: e */
    public boolean m59627e(String str, String str2) {
        SharedPreferences sharedPreferences = this.f47456a;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit != null) {
                editorEdit.putString(str, str2);
                return editorEdit.commit();
            }
        } catch (Exception unused) {
            C1016d.m6183c("LocationPreferences", "saveString fail");
        }
        return false;
    }

    public C9549n(String str, int i10) {
        try {
            this.f47456a = (C9552q.m59643a() == 200 ? C11991a.m72146b() : C11991a.m72145a()).createDeviceProtectedStorageContext().getSharedPreferences(str, i10);
        } catch (Exception e10) {
            C1016d.m6183c("LocationPreferences", "init getSharedPreferences fail:" + e10.getMessage());
        }
    }
}
