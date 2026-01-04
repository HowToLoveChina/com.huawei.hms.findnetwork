package fk;

/* renamed from: fk.c */
/* loaded from: classes6.dex */
public class C9722c extends Exception {

    /* renamed from: a */
    public int f47952a;

    /* renamed from: b */
    public String f47953b;

    /* renamed from: c */
    public String f47954c;

    /* renamed from: d */
    public String f47955d;

    public C9722c(int i10, String str, String str2, String str3) {
        super(str);
        this.f47952a = i10;
        this.f47954c = str2;
        this.f47955d = str3;
    }

    /* renamed from: b */
    public String m60665b() {
        return this.f47955d;
    }

    /* renamed from: c */
    public int m60666c() {
        return this.f47952a;
    }

    /* renamed from: d */
    public String m60667d() {
        return this.f47953b;
    }

    /* renamed from: e */
    public String m60668e() {
        return this.f47954c;
    }

    /* renamed from: f */
    public void m60669f(String str) {
        this.f47955d = str;
    }

    /* renamed from: g */
    public void m60670g(String str) {
        this.f47953b = str;
    }

    /* renamed from: h */
    public void m60671h(String str) {
        this.f47954c = str;
    }

    public C9722c(int i10, String str, String str2, String str3, String str4) {
        this(i10, str2, str3, str4);
        this.f47953b = str;
    }

    public C9722c(int i10, String str) {
        super(str);
        this.f47952a = i10;
    }

    public C9722c(int i10, String str, String str2) {
        super(str2);
        this.f47953b = str;
        this.f47952a = i10;
    }
}
