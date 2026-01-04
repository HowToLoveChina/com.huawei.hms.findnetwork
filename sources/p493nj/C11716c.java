package p493nj;

import android.util.Log;
import com.huawei.dynamicanimation.AbstractC4674d;
import com.huawei.dynamicanimation.AbstractC4679i;
import com.huawei.dynamicanimation.C4675e;
import com.huawei.dynamicanimation.C4681k;
import p524oj.C11907b;

/* renamed from: nj.c */
/* loaded from: classes5.dex */
public class C11716c extends AbstractInterpolatorC11715b<C11716c> {
    public <K> C11716c(AbstractC4674d<K> abstractC4674d, float f10, float f11, float f12) {
        super(abstractC4674d, (AbstractC4679i) null);
        C4681k c4681k = new C4681k(f10, f11, m69897e());
        c4681k.snap(0.0f);
        c4681k.setEndPosition(f12, 0.0f, -1L);
        m69898f(c4681k);
    }

    @Override // p493nj.AbstractInterpolatorC11715b, android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        super.getInterpolation(f10);
        if (Float.compare(f10, 1.0f) == 0) {
            return 1.0f;
        }
        float fM69894b = (f10 * m69894b()) / 1000.0f;
        float position = m69896d().getPosition(fM69894b);
        if (m69896d().isAtEquilibrium(fM69894b)) {
            Log.i("SpringInterpolator", "done at" + fM69894b + "");
        }
        float endPosition = m69896d().getEndPosition() - m69896d().getStartPosition();
        float fAbs = (m69896d() instanceof C4681k ? Math.abs(((C4681k) m69896d()).getFirstExtremumX()) : 0.0f) + endPosition;
        return C11907b.m71441a(endPosition) ? (position + fAbs) / fAbs : position / endPosition;
    }

    public <K> C11716c(AbstractC4674d<K> abstractC4674d, float f10, float f11, float f12, float f13) {
        super(abstractC4674d, (AbstractC4679i) null);
        C4681k c4681k = new C4681k(f10, f11, m69897e());
        c4681k.snap(0.0f);
        c4681k.setEndPosition(f12, f13, -1L);
        m69898f(c4681k);
    }

    public C11716c(C4675e c4675e) {
        super(c4675e, (AbstractC4679i) null);
        C4681k c4681k = new C4681k(800.0f, 15.0f, m69897e());
        c4681k.setValueThreshold(Math.abs(1.0f) * C4681k.DEFAULT_VALUE_THRESHOLD);
        c4681k.snap(0.0f);
        c4681k.setEndPosition(1.0f, 0.0f, -1L);
        m69898f(c4681k);
    }

    public C11716c(C4675e c4675e, float f10, float f11, float f12, float f13) {
        super(c4675e, (AbstractC4679i) null);
        C4681k c4681k = new C4681k(f10, f11, m69897e());
        c4681k.setValueThreshold(Math.abs(f12 - 0.0f) * C4681k.DEFAULT_VALUE_THRESHOLD);
        c4681k.snap(0.0f);
        c4681k.setEndPosition(f12, f13, -1L);
        m69898f(c4681k);
    }

    public C11716c(C4675e c4675e, float f10, float f11, float f12, float f13, float f14) {
        super(c4675e, (AbstractC4679i) null);
        C4681k c4681k = new C4681k(f10, f11, f14 * 0.75f);
        c4681k.snap(0.0f);
        c4681k.setEndPosition(f12, f13, -1L);
        m69898f(c4681k);
    }

    public C11716c() {
        this(new C4675e(0.0f));
    }

    public C11716c(float f10, float f11, float f12, float f13) {
        this(new C4675e(0.0f), f10, f11, f12, f13);
    }

    public C11716c(float f10, float f11, float f12, float f13, float f14) {
        this(new C4675e(0.0f), f10, f11, f12, f13, f14);
    }
}
