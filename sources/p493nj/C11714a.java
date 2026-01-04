package p493nj;

import com.huawei.dynamicanimation.AbstractC4672b;
import com.huawei.dynamicanimation.C4673c;
import com.huawei.dynamicanimation.C4677g;

/* renamed from: nj.a */
/* loaded from: classes5.dex */
public class C11714a extends AbstractInterpolatorC11715b<C11714a> {
    public C11714a(float f10, float f11) {
        super(AbstractC4672b.f21521x, new C4673c(f10, f11));
        ((C4673c) m69896d()).setValueThreshold(m69897e());
    }

    @Override // p493nj.AbstractInterpolatorC11715b
    /* renamed from: a */
    public float mo69892a() {
        return m69895c();
    }

    /* renamed from: g */
    public C4677g m69893g(float f10) {
        float fM69894b = (f10 * m69894b()) / 1000.0f;
        return new C4677g(fM69894b, m69896d().getPosition(fM69894b), m69896d().getVelocity(fM69894b), m69896d().getAcceleration(fM69894b));
    }
}
