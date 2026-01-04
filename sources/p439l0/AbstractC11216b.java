package p439l0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.ArrayList;
import p273f0.C9603h0;
import p439l0.AbstractC11216b;
import p439l0.C11215a;

/* renamed from: l0.b */
/* loaded from: classes.dex */
public abstract class AbstractC11216b<T extends AbstractC11216b<T>> implements C11215a.b {

    /* renamed from: m */
    public static final s f52663m = new g("translationX");

    /* renamed from: n */
    public static final s f52664n = new h("translationY");

    /* renamed from: o */
    public static final s f52665o = new i("translationZ");

    /* renamed from: p */
    public static final s f52666p = new j(TopAnimatorConfig.AnimatorType.SCALE_X);

    /* renamed from: q */
    public static final s f52667q = new k(TopAnimatorConfig.AnimatorType.SCALE_Y);

    /* renamed from: r */
    public static final s f52668r = new l("rotation");

    /* renamed from: s */
    public static final s f52669s = new m("rotationX");

    /* renamed from: t */
    public static final s f52670t = new n("rotationY");

    /* renamed from: u */
    public static final s f52671u = new o(Constants.MULTIPLE_SIGN);

    /* renamed from: v */
    public static final s f52672v = new a("y");

    /* renamed from: w */
    public static final s f52673w = new b("z");

    /* renamed from: x */
    public static final s f52674x = new c(TopAnimatorConfig.AnimatorType.ALPHA);

    /* renamed from: y */
    public static final s f52675y = new d("scrollX");

    /* renamed from: z */
    public static final s f52676z = new e("scrollY");

    /* renamed from: a */
    public float f52677a;

    /* renamed from: b */
    public float f52678b;

    /* renamed from: c */
    public boolean f52679c;

    /* renamed from: d */
    public final Object f52680d;

    /* renamed from: e */
    public final AbstractC11217c f52681e;

    /* renamed from: f */
    public boolean f52682f;

    /* renamed from: g */
    public float f52683g;

    /* renamed from: h */
    public float f52684h;

    /* renamed from: i */
    public long f52685i;

    /* renamed from: j */
    public float f52686j;

    /* renamed from: k */
    public final ArrayList<q> f52687k;

    /* renamed from: l */
    public final ArrayList<r> f52688l;

    /* renamed from: l0.b$a */
    public static class a extends s {
        public a(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getY();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* renamed from: l0.b$b */
    public static class b extends s {
        public b(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return C9603h0.m59856M(view);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            C9603h0.m59853K0(view, f10);
        }
    }

    /* renamed from: l0.b$c */
    public static class c extends s {
        public c(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getAlpha();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* renamed from: l0.b$d */
    public static class d extends s {
        public d(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getScrollX();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* renamed from: l0.b$e */
    public static class e extends s {
        public e(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getScrollY();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* renamed from: l0.b$f */
    public class f extends AbstractC11217c {

        /* renamed from: b */
        public final /* synthetic */ C11218d f52689b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, C11218d c11218d) {
            super(str);
            this.f52689b = c11218d;
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: a */
        public float mo58907a(Object obj) {
            return this.f52689b.m67399a();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: b */
        public void mo58908b(Object obj, float f10) {
            this.f52689b.m67400b(f10);
        }
    }

    /* renamed from: l0.b$g */
    public static class g extends s {
        public g(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getTranslationX();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* renamed from: l0.b$h */
    public static class h extends s {
        public h(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getTranslationY();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* renamed from: l0.b$i */
    public static class i extends s {
        public i(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return C9603h0.m59852K(view);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            C9603h0.m59849I0(view, f10);
        }
    }

    /* renamed from: l0.b$j */
    public static class j extends s {
        public j(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getScaleX();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* renamed from: l0.b$k */
    public static class k extends s {
        public k(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getScaleY();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* renamed from: l0.b$l */
    public static class l extends s {
        public l(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getRotation();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* renamed from: l0.b$m */
    public static class m extends s {
        public m(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getRotationX();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* renamed from: l0.b$n */
    public static class n extends s {
        public n(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getRotationY();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* renamed from: l0.b$o */
    public static class o extends s {
        public o(String str) {
            super(str, null);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(View view) {
            return view.getX();
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(View view, float f10) {
            view.setX(f10);
        }
    }

    /* renamed from: l0.b$p */
    public static class p {

        /* renamed from: a */
        public float f52691a;

        /* renamed from: b */
        public float f52692b;
    }

    /* renamed from: l0.b$q */
    public interface q {
        void onAnimationEnd(AbstractC11216b abstractC11216b, boolean z10, float f10, float f11);
    }

    /* renamed from: l0.b$r */
    public interface r {
        void onAnimationUpdate(AbstractC11216b abstractC11216b, float f10, float f11);
    }

    /* renamed from: l0.b$s */
    public static abstract class s extends AbstractC11217c<View> {
        public /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        public s(String str) {
            super(str);
        }
    }

    public AbstractC11216b(C11218d c11218d) {
        this.f52677a = 0.0f;
        this.f52678b = Float.MAX_VALUE;
        this.f52679c = false;
        this.f52682f = false;
        this.f52683g = Float.MAX_VALUE;
        this.f52684h = -Float.MAX_VALUE;
        this.f52685i = 0L;
        this.f52687k = new ArrayList<>();
        this.f52688l = new ArrayList<>();
        this.f52680d = null;
        this.f52681e = new f("FloatValueHolder", c11218d);
        this.f52686j = 1.0f;
    }

    /* renamed from: i */
    public static <T> void m67358i(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // p439l0.C11215a.b
    /* renamed from: a */
    public boolean mo67356a(long j10) {
        long j11 = this.f52685i;
        if (j11 == 0) {
            this.f52685i = j10;
            m67366j(this.f52678b);
            return false;
        }
        this.f52685i = j10;
        boolean zMo67370n = mo67370n(j10 - j11);
        float fMin = Math.min(this.f52678b, this.f52683g);
        this.f52678b = fMin;
        float fMax = Math.max(fMin, this.f52684h);
        this.f52678b = fMax;
        m67366j(fMax);
        if (zMo67370n) {
            m67362e(false);
        }
        return zMo67370n;
    }

    /* renamed from: b */
    public T m67359b(q qVar) {
        if (!this.f52687k.contains(qVar)) {
            this.f52687k.add(qVar);
        }
        return this;
    }

    /* renamed from: c */
    public T m67360c(r rVar) {
        if (m67365h()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f52688l.contains(rVar)) {
            this.f52688l.add(rVar);
        }
        return this;
    }

    /* renamed from: d */
    public void m67361d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f52682f) {
            m67362e(true);
        }
    }

    /* renamed from: e */
    public final void m67362e(boolean z10) {
        this.f52682f = false;
        C11215a.m67348d().m67354g(this);
        this.f52685i = 0L;
        this.f52679c = false;
        for (int i10 = 0; i10 < this.f52687k.size(); i10++) {
            if (this.f52687k.get(i10) != null) {
                this.f52687k.get(i10).onAnimationEnd(this, z10, this.f52678b, this.f52677a);
            }
        }
        m67358i(this.f52687k);
    }

    /* renamed from: f */
    public final float m67363f() {
        return this.f52681e.mo58907a(this.f52680d);
    }

    /* renamed from: g */
    public float m67364g() {
        return this.f52686j * 0.75f;
    }

    /* renamed from: h */
    public boolean m67365h() {
        return this.f52682f;
    }

    /* renamed from: j */
    public void m67366j(float f10) {
        this.f52681e.mo58908b(this.f52680d, f10);
        for (int i10 = 0; i10 < this.f52688l.size(); i10++) {
            if (this.f52688l.get(i10) != null) {
                this.f52688l.get(i10).onAnimationUpdate(this, this.f52678b, this.f52677a);
            }
        }
        m67358i(this.f52688l);
    }

    /* renamed from: k */
    public T m67367k(float f10) {
        this.f52678b = f10;
        this.f52679c = true;
        return this;
    }

    /* renamed from: l */
    public void mo67368l() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f52682f) {
            return;
        }
        m67369m();
    }

    /* renamed from: m */
    public final void m67369m() {
        if (this.f52682f) {
            return;
        }
        this.f52682f = true;
        if (!this.f52679c) {
            this.f52678b = m67363f();
        }
        float f10 = this.f52678b;
        if (f10 > this.f52683g || f10 < this.f52684h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        C11215a.m67348d().m67349a(this, 0L);
    }

    /* renamed from: n */
    public abstract boolean mo67370n(long j10);

    public <K> AbstractC11216b(K k10, AbstractC11217c<K> abstractC11217c) {
        this.f52677a = 0.0f;
        this.f52678b = Float.MAX_VALUE;
        this.f52679c = false;
        this.f52682f = false;
        this.f52683g = Float.MAX_VALUE;
        this.f52684h = -Float.MAX_VALUE;
        this.f52685i = 0L;
        this.f52687k = new ArrayList<>();
        this.f52688l = new ArrayList<>();
        this.f52680d = k10;
        this.f52681e = abstractC11217c;
        if (abstractC11217c != f52668r && abstractC11217c != f52669s && abstractC11217c != f52670t) {
            if (abstractC11217c == f52674x) {
                this.f52686j = 0.00390625f;
                return;
            } else if (abstractC11217c != f52666p && abstractC11217c != f52667q) {
                this.f52686j = 1.0f;
                return;
            } else {
                this.f52686j = 0.00390625f;
                return;
            }
        }
        this.f52686j = 0.1f;
    }
}
