package p553pi;

import java.io.Serializable;

/* renamed from: pi.d */
/* loaded from: classes.dex */
public final class C12146d implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public String f56349a;

    /* renamed from: b */
    public String f56350b;

    /* renamed from: c */
    public long f56351c;

    /* renamed from: b */
    public String m72858b() {
        return this.f56350b;
    }

    /* renamed from: c */
    public String m72859c() {
        return this.f56349a;
    }

    /* renamed from: d */
    public boolean m72860d() {
        return System.currentTimeMillis() - this.f56351c >= 864000000;
    }

    /* renamed from: e */
    public void m72861e(String str) {
        this.f56350b = str;
    }

    /* renamed from: f */
    public void m72862f(long j10) {
        this.f56351c = j10;
    }

    /* renamed from: g */
    public void m72863g(String str) {
        this.f56349a = str;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - this.f56351c >= 604800000;
    }
}
