package p493nj;

import android.view.animation.Interpolator;
import com.huawei.dynamicanimation.AbstractC4672b;
import com.huawei.dynamicanimation.AbstractC4674d;
import com.huawei.dynamicanimation.AbstractC4679i;
import com.huawei.dynamicanimation.C4675e;
import java.math.BigDecimal;
import p493nj.AbstractInterpolatorC11715b;

/* renamed from: nj.b */
/* loaded from: classes5.dex */
public abstract class AbstractInterpolatorC11715b<T extends AbstractInterpolatorC11715b<T>> implements Interpolator {

    /* renamed from: e */
    public static final float f54206e = new BigDecimal(1.0d).divide(new BigDecimal("10")).floatValue();

    /* renamed from: f */
    public static final float f54207f = new BigDecimal(1.0d).divide(new BigDecimal("256")).floatValue();

    /* renamed from: g */
    public static final float f54208g = new BigDecimal(1.0d).divide(new BigDecimal("500")).floatValue();

    /* renamed from: h */
    public static final float f54209h = new BigDecimal(1.0d).divide(new BigDecimal("1000")).floatValue();

    /* renamed from: a */
    public final AbstractC4674d f54210a;

    /* renamed from: b */
    public float f54211b;

    /* renamed from: c */
    public long f54212c;

    /* renamed from: d */
    public AbstractC4679i f54213d;

    /* renamed from: nj.b$a */
    public class a extends AbstractC4674d {

        /* renamed from: b */
        public final /* synthetic */ C4675e f54214b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, C4675e c4675e) {
            super(str);
            this.f54214b = c4675e;
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: a */
        public float mo28644a(Object obj) {
            return this.f54214b.m28681a();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: b */
        public void mo28645b(Object obj, float f10) {
            this.f54214b.m28682b(f10);
        }
    }

    public AbstractInterpolatorC11715b(C4675e c4675e, AbstractC4679i abstractC4679i) {
        this.f54212c = 300L;
        this.f54213d = abstractC4679i;
        this.f54210a = new a("FloatValueHolder", c4675e);
        this.f54211b = f54209h;
    }

    /* renamed from: a */
    public float mo69892a() {
        return Math.abs(m69896d().getEndPosition() - m69896d().getStartPosition());
    }

    /* renamed from: b */
    public float m69894b() {
        return m69896d().getEstimatedDuration();
    }

    /* renamed from: c */
    public float m69895c() {
        return m69896d().getEndPosition();
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Lcom/huawei/dynamicanimation/i;>()TT; */
    /* renamed from: d */
    public final AbstractC4679i m69896d() {
        return this.f54213d;
    }

    /* renamed from: e */
    public final float m69897e() {
        return this.f54211b * 0.75f;
    }

    /* renamed from: f */
    public T m69898f(AbstractC4679i abstractC4679i) {
        this.f54213d = abstractC4679i;
        return this;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float position = m69896d().getPosition((f10 * m69894b()) / 1000.0f);
        if (mo69892a() == 0.0f) {
            return 0.0f;
        }
        return position / mo69892a();
    }

    public <K> AbstractInterpolatorC11715b(AbstractC4674d<K> abstractC4674d, AbstractC4679i abstractC4679i) {
        this.f54212c = 300L;
        this.f54213d = abstractC4679i;
        this.f54210a = abstractC4674d;
        if (abstractC4674d != AbstractC4672b.f21518u && abstractC4674d != AbstractC4672b.f21519v && abstractC4674d != AbstractC4672b.f21520w) {
            if (abstractC4674d == AbstractC4672b.f21507A) {
                this.f54211b = f54207f;
                return;
            } else if (abstractC4674d != AbstractC4672b.f21516s && abstractC4674d != AbstractC4672b.f21517t) {
                this.f54211b = 1.0f;
                return;
            } else {
                this.f54211b = f54208g;
                return;
            }
        }
        this.f54211b = f54206e;
    }
}
