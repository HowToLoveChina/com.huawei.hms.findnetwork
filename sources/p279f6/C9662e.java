package p279f6;

import android.net.Uri;
import java.util.HashMap;

/* renamed from: f6.e */
/* loaded from: classes.dex */
public class C9662e {

    /* renamed from: a */
    public final Uri f47825a;

    /* renamed from: b */
    public final String[] f47826b;

    /* renamed from: c */
    public final String f47827c;

    /* renamed from: d */
    public final String[] f47828d;

    /* renamed from: e */
    public final String f47829e;

    /* renamed from: f */
    public HashMap<String, Integer> f47830f;

    public C9662e(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f47825a = uri;
        this.f47826b = strArr != null ? (String[]) strArr.clone() : null;
        this.f47827c = str;
        this.f47828d = strArr2 != null ? (String[]) strArr2.clone() : null;
        this.f47829e = str2;
    }

    /* renamed from: a */
    public HashMap<String, Integer> m60331a() {
        return this.f47830f;
    }

    /* renamed from: b */
    public String[] m60332b() {
        String[] strArr = this.f47826b;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    /* renamed from: c */
    public String m60333c() {
        return this.f47827c;
    }

    /* renamed from: d */
    public String[] m60334d() {
        String[] strArr = this.f47828d;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    /* renamed from: e */
    public String m60335e() {
        return this.f47829e;
    }

    /* renamed from: f */
    public Uri m60336f() {
        return this.f47825a;
    }

    /* renamed from: g */
    public void m60337g(HashMap<String, Integer> map) {
        this.f47830f = map;
    }
}
