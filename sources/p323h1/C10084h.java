package p323h1;

import java.lang.reflect.Type;

/* renamed from: h1.h */
/* loaded from: classes.dex */
public class C10084h {

    /* renamed from: a */
    public Object f49222a;

    /* renamed from: b */
    public final C10084h f49223b;

    /* renamed from: c */
    public final Object f49224c;

    /* renamed from: d */
    public final int f49225d;

    /* renamed from: e */
    public Type f49226e;

    /* renamed from: f */
    public transient String f49227f;

    public C10084h(C10084h c10084h, Object obj, Object obj2) {
        this.f49223b = c10084h;
        this.f49222a = obj;
        this.f49224c = obj2;
        this.f49225d = c10084h == null ? 0 : c10084h.f49225d + 1;
    }

    public String toString() {
        if (this.f49227f == null) {
            if (this.f49223b == null) {
                this.f49227f = "$";
            } else if (this.f49224c instanceof Integer) {
                this.f49227f = this.f49223b.toString() + "[" + this.f49224c + "]";
            } else {
                this.f49227f = this.f49223b.toString() + "." + this.f49224c;
            }
        }
        return this.f49227f;
    }
}
