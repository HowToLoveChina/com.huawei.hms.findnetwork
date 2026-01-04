package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* renamed from: K */
    public ArrayList<Transition> f4807K;

    /* renamed from: L */
    public boolean f4808L;

    /* renamed from: M */
    public int f4809M;

    /* renamed from: N */
    public boolean f4810N;

    /* renamed from: O */
    public int f4811O;

    /* renamed from: androidx.transition.TransitionSet$a */
    public class C0924a extends C0955p {

        /* renamed from: a */
        public final /* synthetic */ Transition f4812a;

        public C0924a(Transition transition) {
            this.f4812a = transition;
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            this.f4812a.mo5725Z();
            transition.mo5721V(this);
        }
    }

    /* renamed from: androidx.transition.TransitionSet$b */
    public static class C0925b extends C0955p {

        /* renamed from: a */
        public TransitionSet f4814a;

        public C0925b(TransitionSet transitionSet) {
            this.f4814a = transitionSet;
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: a */
        public void mo5755a(Transition transition) {
            TransitionSet transitionSet = this.f4814a;
            if (transitionSet.f4810N) {
                return;
            }
            transitionSet.m5737h0();
            this.f4814a.f4810N = true;
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            TransitionSet transitionSet = this.f4814a;
            int i10 = transitionSet.f4809M - 1;
            transitionSet.f4809M = i10;
            if (i10 == 0) {
                transitionSet.f4810N = false;
                transitionSet.m5745r();
            }
            transition.mo5721V(this);
        }
    }

    public TransitionSet() {
        this.f4807K = new ArrayList<>();
        this.f4808L = true;
        this.f4810N = false;
        this.f4811O = 0;
    }

    @Override // androidx.transition.Transition
    /* renamed from: T */
    public void mo5719T(View view) {
        super.mo5719T(view);
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4807K.get(i10).mo5719T(view);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: X */
    public void mo5723X(View view) {
        super.mo5723X(view);
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4807K.get(i10).mo5723X(view);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: Z */
    public void mo5725Z() {
        if (this.f4807K.isEmpty()) {
            m5737h0();
            m5745r();
            return;
        }
        m5768v0();
        if (this.f4808L) {
            Iterator<Transition> it = this.f4807K.iterator();
            while (it.hasNext()) {
                it.next().mo5725Z();
            }
            return;
        }
        for (int i10 = 1; i10 < this.f4807K.size(); i10++) {
            this.f4807K.get(i10 - 1).mo5726a(new C0924a(this.f4807K.get(i10)));
        }
        Transition transition = this.f4807K.get(0);
        if (transition != null) {
            transition.mo5725Z();
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: b0 */
    public void mo5729b0(Transition.AbstractC0922e abstractC0922e) {
        super.mo5729b0(abstractC0922e);
        this.f4811O |= 8;
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4807K.get(i10).mo5729b0(abstractC0922e);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: e0 */
    public void mo5733e0(PathMotion pathMotion) {
        super.mo5733e0(pathMotion);
        this.f4811O |= 4;
        if (this.f4807K != null) {
            for (int i10 = 0; i10 < this.f4807K.size(); i10++) {
                this.f4807K.get(i10).mo5733e0(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: f0 */
    public void mo5734f0(AbstractC0957r abstractC0957r) {
        super.mo5734f0(abstractC0957r);
        this.f4811O |= 2;
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4807K.get(i10).mo5734f0(abstractC0957r);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        if (m5713L(c0959t.f4889b)) {
            Iterator<Transition> it = this.f4807K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.m5713L(c0959t.f4889b)) {
                    next.mo5618i(c0959t);
                    c0959t.f4890c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: i0 */
    public String mo5738i0(String str) {
        String strMo5738i0 = super.mo5738i0(str);
        for (int i10 = 0; i10 < this.f4807K.size(); i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strMo5738i0);
            sb2.append("\n");
            sb2.append(this.f4807K.get(i10).mo5738i0(str + "  "));
            strMo5738i0 = sb2.toString();
        }
        return strMo5738i0;
    }

    @Override // androidx.transition.Transition
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5726a(Transition.InterfaceC0923f interfaceC0923f) {
        return (TransitionSet) super.mo5726a(interfaceC0923f);
    }

    @Override // androidx.transition.Transition
    /* renamed from: k */
    public void mo5740k(C0959t c0959t) {
        super.mo5740k(c0959t);
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4807K.get(i10).mo5740k(c0959t);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5728b(View view) {
        for (int i10 = 0; i10 < this.f4807K.size(); i10++) {
            this.f4807K.get(i10).mo5728b(view);
        }
        return (TransitionSet) super.mo5728b(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        if (m5713L(c0959t.f4889b)) {
            Iterator<Transition> it = this.f4807K.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.m5713L(c0959t.f4889b)) {
                    next.mo5621l(c0959t);
                    c0959t.f4890c.add(next);
                }
            }
        }
    }

    /* renamed from: l0 */
    public TransitionSet m5758l0(Transition transition) {
        m5759m0(transition);
        long j10 = this.f4775c;
        if (j10 >= 0) {
            transition.mo5727a0(j10);
        }
        if ((this.f4811O & 1) != 0) {
            transition.mo5731c0(m5749v());
        }
        if ((this.f4811O & 2) != 0) {
            transition.mo5734f0(m5753z());
        }
        if ((this.f4811O & 4) != 0) {
            transition.mo5733e0(m5752y());
        }
        if ((this.f4811O & 8) != 0) {
            transition.mo5729b0(m5748u());
        }
        return this;
    }

    /* renamed from: m0 */
    public final void m5759m0(Transition transition) {
        this.f4807K.add(transition);
        transition.f4790r = this;
    }

    /* renamed from: n0 */
    public Transition m5760n0(int i10) {
        if (i10 < 0 || i10 >= this.f4807K.size()) {
            return null;
        }
        return this.f4807K.get(i10);
    }

    @Override // androidx.transition.Transition
    /* renamed from: o */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.f4807K = new ArrayList<>();
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            transitionSet.m5759m0(this.f4807K.get(i10).clone());
        }
        return transitionSet;
    }

    /* renamed from: o0 */
    public int m5761o0() {
        return this.f4807K.size();
    }

    @Override // androidx.transition.Transition
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5721V(Transition.InterfaceC0923f interfaceC0923f) {
        return (TransitionSet) super.mo5721V(interfaceC0923f);
    }

    @Override // androidx.transition.Transition
    /* renamed from: q */
    public void mo5744q(ViewGroup viewGroup, C0960u c0960u, C0960u c0960u2, ArrayList<C0959t> arrayList, ArrayList<C0959t> arrayList2) {
        long jM5706B = m5706B();
        int size = this.f4807K.size();
        for (int i10 = 0; i10 < size; i10++) {
            Transition transition = this.f4807K.get(i10);
            if (jM5706B > 0 && (this.f4808L || i10 == 0)) {
                long jM5706B2 = transition.m5706B();
                if (jM5706B2 > 0) {
                    transition.mo5736g0(jM5706B2 + jM5706B);
                } else {
                    transition.mo5736g0(jM5706B);
                }
            }
            transition.mo5744q(viewGroup, c0960u, c0960u2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5722W(View view) {
        for (int i10 = 0; i10 < this.f4807K.size(); i10++) {
            this.f4807K.get(i10).mo5722W(view);
        }
        return (TransitionSet) super.mo5722W(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5727a0(long j10) {
        ArrayList<Transition> arrayList;
        super.mo5727a0(j10);
        if (this.f4775c >= 0 && (arrayList = this.f4807K) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f4807K.get(i10).mo5727a0(j10);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5731c0(TimeInterpolator timeInterpolator) {
        this.f4811O |= 1;
        ArrayList<Transition> arrayList = this.f4807K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f4807K.get(i10).mo5731c0(timeInterpolator);
            }
        }
        return (TransitionSet) super.mo5731c0(timeInterpolator);
    }

    /* renamed from: t0 */
    public TransitionSet m5766t0(int i10) {
        if (i10 == 0) {
            this.f4808L = true;
        } else {
            if (i10 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
            this.f4808L = false;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public TransitionSet mo5736g0(long j10) {
        return (TransitionSet) super.mo5736g0(j10);
    }

    /* renamed from: v0 */
    public final void m5768v0() {
        C0925b c0925b = new C0925b(this);
        Iterator<Transition> it = this.f4807K.iterator();
        while (it.hasNext()) {
            it.next().mo5726a(c0925b);
        }
        this.f4809M = this.f4807K.size();
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4807K = new ArrayList<>();
        this.f4808L = true;
        this.f4810N = false;
        this.f4811O = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4872i);
        m5766t0(TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
