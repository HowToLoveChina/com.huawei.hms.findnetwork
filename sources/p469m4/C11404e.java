package p469m4;

import android.text.TextUtils;

/* renamed from: m4.e */
/* loaded from: classes.dex */
public class C11404e {

    /* renamed from: a */
    public final String f53166a;

    /* renamed from: b */
    public final String f53167b;

    /* renamed from: c */
    public final String f53168c;

    /* renamed from: d */
    public final String f53169d;

    /* renamed from: e */
    public final String f53170e;

    /* renamed from: f */
    public final int f53171f;

    /* renamed from: g */
    public int f53172g;

    public C11404e(String str, String str2, String str3, String str4, String str5, int i10) {
        this.f53172g = 0;
        this.f53166a = str;
        this.f53167b = str2;
        this.f53168c = str3;
        this.f53169d = str4;
        this.f53170e = str5;
        this.f53171f = i10;
        if (str != null) {
            this.f53172g = str.length() / 2;
        }
    }

    /* renamed from: a */
    public boolean m68334a() {
        return (TextUtils.isEmpty(this.f53166a) || TextUtils.isEmpty(this.f53167b) || TextUtils.isEmpty(this.f53168c) || TextUtils.isEmpty(this.f53169d) || this.f53166a.length() != this.f53167b.length() || this.f53167b.length() != this.f53168c.length() || this.f53168c.length() != this.f53172g * 2 || this.f53171f < 0 || TextUtils.isEmpty(this.f53170e)) ? false : true;
    }

    /* renamed from: b */
    public String m68335b() {
        return this.f53166a;
    }

    /* renamed from: c */
    public String m68336c() {
        return this.f53167b;
    }

    /* renamed from: d */
    public String m68337d() {
        return this.f53168c;
    }

    /* renamed from: e */
    public String m68338e() {
        return this.f53169d;
    }

    /* renamed from: f */
    public String m68339f() {
        return this.f53170e;
    }

    /* renamed from: g */
    public int m68340g() {
        return this.f53171f;
    }

    /* renamed from: h */
    public int m68341h() {
        return this.f53172g;
    }
}
