package p351hz;

import java.io.InputStream;

/* renamed from: hz.g */
/* loaded from: classes9.dex */
public class C10368g extends AbstractC10369h {

    /* renamed from: a */
    public int f50113a = 1;

    public C10368g(int i10) throws C10377p {
        m63797c(i10);
    }

    @Override // p351hz.AbstractC10369h
    /* renamed from: b */
    public InputStream mo63793b(InputStream inputStream, C10364c c10364c) {
        return new C10367f(inputStream, this.f50113a);
    }

    /* renamed from: c */
    public void m63797c(int i10) throws C10377p {
        if (i10 >= 1 && i10 <= 256) {
            this.f50113a = i10;
            return;
        }
        throw new C10377p("Delta distance must be in the range [1, 256]: " + i10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }
}
