package p052cb;

/* renamed from: cb.d */
/* loaded from: classes3.dex */
public class C1407d {

    /* renamed from: a */
    public long f6031a = 0;

    /* renamed from: b */
    public long f6032b = 0;

    /* renamed from: c */
    public long f6033c = 0;

    /* renamed from: d */
    public long f6034d = 0;

    /* renamed from: a */
    public void m8117a(boolean z10) {
        if (z10) {
            this.f6033c++;
        } else {
            this.f6034d++;
        }
    }

    /* renamed from: b */
    public void m8118b() {
        m8119c();
    }

    /* renamed from: c */
    public void m8119c() {
        this.f6031a = System.currentTimeMillis();
        this.f6032b = 0L;
        this.f6033c = 0L;
        this.f6034d = 0L;
    }

    /* renamed from: d */
    public void m8120d() {
        this.f6032b++;
    }

    public String toString() {
        return "AnrStatistic{startTime=" + this.f6031a + ", taskStartNum=" + this.f6032b + ", taskSuccessNum=" + this.f6033c + ", taskFailNum=" + this.f6034d + '}';
    }
}
