package fk;

import android.text.TextUtils;

/* renamed from: fk.b */
/* loaded from: classes6.dex */
public class C9721b extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public int f47947a;

    /* renamed from: b */
    public String f47948b;

    /* renamed from: c */
    public int f47949c;

    /* renamed from: d */
    public String f47950d;

    /* renamed from: e */
    public String f47951e;

    public C9721b(int i10, String str) {
        super(str);
        this.f47951e = "";
        this.f47948b = "abort";
        this.f47947a = i10;
    }

    /* renamed from: b */
    public String m60658b() {
        return this.f47948b;
    }

    /* renamed from: c */
    public int m60659c() {
        return this.f47947a;
    }

    /* renamed from: d */
    public String m60660d() {
        return this.f47950d;
    }

    /* renamed from: e */
    public String m60661e() {
        return this.f47951e;
    }

    /* renamed from: f */
    public String m60662f() {
        StringBuilder sb2;
        int i10;
        if (TextUtils.isEmpty(this.f47950d)) {
            if (this.f47949c > 0) {
                sb2 = new StringBuilder();
                sb2.append(this.f47947a);
                sb2.append("_");
                i10 = this.f47949c;
            } else {
                sb2 = new StringBuilder();
                sb2.append("");
                i10 = this.f47947a;
            }
            sb2.append(i10);
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f47947a);
            sb2.append("_");
            sb2.append(this.f47950d);
        }
        return sb2.toString();
    }

    /* renamed from: g */
    public int m60663g() {
        return this.f47949c;
    }

    /* renamed from: h */
    public void m60664h(String str) {
        this.f47951e = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb2 = new StringBuilder("{");
        sb2.append("code=");
        sb2.append(this.f47947a);
        if (this.f47949c > 0) {
            sb2.append(", status=");
            sb2.append(this.f47949c);
        }
        String message = getMessage();
        if (message != null && !message.isEmpty()) {
            sb2.append(", message=");
            sb2.append(getMessage());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public C9721b(String str, int i10, String str2) {
        this(i10, str2);
        this.f47950d = str;
    }

    public C9721b(String str, int i10, String str2, String str3) {
        this(i10, str2, str3);
        this.f47950d = str;
    }

    public C9721b(int i10, String str, String str2) {
        super(str);
        this.f47951e = "";
        this.f47947a = i10;
        this.f47948b = str2;
    }

    public C9721b(int i10, int i11, String str) {
        super(str);
        this.f47951e = "";
        this.f47947a = i10;
        this.f47948b = "abort";
        this.f47949c = i11;
    }

    public C9721b(int i10, int i11, String str, String str2) {
        super(str);
        this.f47951e = "";
        this.f47947a = i10;
        this.f47949c = i11;
        this.f47948b = str2;
    }

    public C9721b(int i10, int i11, String str, String str2, String str3) {
        super(str);
        this.f47951e = "";
        this.f47947a = i10;
        this.f47949c = i11;
        this.f47948b = str2;
        this.f47950d = str3;
    }

    public C9721b(int i10, String str, Throwable th2) {
        super(str, th2);
        this.f47951e = "";
        this.f47947a = i10;
    }
}
