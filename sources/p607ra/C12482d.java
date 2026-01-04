package p607ra;

import java.util.Objects;
import java.util.concurrent.FutureTask;

/* renamed from: ra.d */
/* loaded from: classes3.dex */
public class C12482d extends FutureTask<Void> implements Comparable<C12482d> {

    /* renamed from: a */
    public RunnableC12480b f57477a;

    /* renamed from: b */
    public int f57478b;

    /* renamed from: c */
    public int f57479c;

    public C12482d(RunnableC12480b runnableC12480b, Void r22, int i10) {
        super(runnableC12480b, r22);
        this.f57477a = runnableC12480b;
        this.f57479c = i10;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C12482d c12482d) {
        return this.f57478b - c12482d.m74958e();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        this.f57477a.m74930a();
        return super.cancel(z10);
    }

    /* renamed from: e */
    public int m74958e() {
        return this.f57478b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C12482d c12482d = (C12482d) obj;
        return this.f57478b == c12482d.f57478b && Objects.equals(this.f57477a, c12482d.f57477a);
    }

    /* renamed from: f */
    public String m74959f() {
        return this.f57477a.m74944p(this.f57479c);
    }

    /* renamed from: h */
    public void m74960h(int i10) {
        this.f57478b = i10;
    }

    public int hashCode() {
        return Objects.hash(this.f57477a, Integer.valueOf(this.f57478b));
    }
}
