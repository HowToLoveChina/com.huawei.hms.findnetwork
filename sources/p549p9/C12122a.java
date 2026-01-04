package p549p9;

import com.huawei.android.hicloud.connect.progress.ICallback;

/* renamed from: p9.a */
/* loaded from: classes3.dex */
public class C12122a {

    /* renamed from: a */
    public long f56231a;

    /* renamed from: b */
    public long f56232b;

    /* renamed from: c */
    public long f56233c;

    /* renamed from: d */
    public int f56234d = 0;

    /* renamed from: e */
    public long f56235e = 0;

    /* renamed from: f */
    public ICallback f56236f;

    public C12122a(ICallback iCallback) {
        this.f56236f = iCallback;
    }

    /* renamed from: a */
    public ICallback mo17781a() {
        return this.f56236f;
    }

    /* renamed from: b */
    public long m72685b() {
        return this.f56233c;
    }

    /* renamed from: c */
    public void m72686c(long j10) {
        this.f56232b += j10;
        this.f56233c += j10;
        mo17783e(false);
    }

    /* renamed from: d */
    public boolean mo17782d() {
        return this.f56236f.onStop();
    }

    /* renamed from: e */
    public void mo17783e(boolean z10) {
        if (this.f56231a <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iFloor = (int) Math.floor((this.f56232b / this.f56231a) * 100.0d);
        int i10 = this.f56234d;
        boolean z11 = iFloor - i10 > 0;
        boolean z12 = jCurrentTimeMillis - this.f56235e >= ((long) 800) || iFloor - i10 >= 10;
        if (z11) {
            if (z12 || z10) {
                this.f56235e = jCurrentTimeMillis;
                this.f56234d = iFloor;
                this.f56236f.onProgress(this.f56232b, this.f56231a);
            }
        }
    }

    /* renamed from: f */
    public void mo17784f(long j10) {
        this.f56232b = j10;
    }

    /* renamed from: g */
    public void mo17785g(long j10) {
        this.f56231a = j10;
    }

    /* renamed from: h */
    public void m72687h(long j10) {
        this.f56232b += j10;
    }
}
