package com.huawei.animation.physical2;

import android.util.Log;
import android.view.Choreographer;
import com.huawei.animation.physical2.AbstractC4560i;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.animation.physical2.e */
/* loaded from: classes4.dex */
public class ChoreographerFrameCallbackC4556e implements AbstractC4560i.a, Choreographer.FrameCallback {

    /* renamed from: f */
    public AbstractC4560i f20924f;

    /* renamed from: a */
    public List<a> f20919a = new CopyOnWriteArrayList();

    /* renamed from: b */
    public float f20920b = 228.0f;

    /* renamed from: c */
    public float f20921c = 30.0f;

    /* renamed from: d */
    public InterfaceC4553b<Float> f20922d = new C4554c(1.0f);

    /* renamed from: e */
    public InterfaceC4553b<Float> f20923e = new C4554c();

    /* renamed from: g */
    public float f20925g = 1.0f;

    /* renamed from: h */
    public int f20926h = -1;

    /* renamed from: i */
    public int f20927i = -1;

    /* renamed from: j */
    public boolean f20928j = false;

    /* renamed from: com.huawei.animation.physical2.e$a */
    public interface a {
        /* renamed from: a */
        void m28005a();

        /* renamed from: b */
        void m28006b();
    }

    public ChoreographerFrameCallbackC4556e(AbstractC4560i abstractC4560i) {
        if (abstractC4560i == null) {
            throw new IllegalArgumentException("springAdapter can not be null");
        }
        this.f20924f = abstractC4560i;
        abstractC4560i.m28022f(this);
        m28004q();
    }

    @Override // com.huawei.animation.physical2.AbstractC4560i.a
    /* renamed from: a */
    public void mo27988a(AbstractC4561j abstractC4561j) {
        if (abstractC4561j == null) {
            return;
        }
        m27999l(abstractC4561j);
    }

    /* renamed from: b */
    public ChoreographerFrameCallbackC4556e m27989b() {
        for (int i10 = 0; i10 < this.f20924f.mo27980d(); i10++) {
            this.f20924f.mo27979c(i10).cancel();
        }
        this.f20928j = false;
        return this;
    }

    /* renamed from: c */
    public AbstractC4561j m27990c() {
        return this.f20924f.mo27977a();
    }

    /* renamed from: d */
    public boolean m27991d() {
        return this.f20928j;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        boolean zIsDoFrame;
        if (this.f20928j) {
            AbstractC4561j abstractC4561jMo27977a = this.f20924f.mo27977a();
            boolean zIsDoFrame2 = true;
            if ((abstractC4561jMo27977a instanceof AbstractC4558g) && (this.f20924f instanceof C4555d)) {
                zIsDoFrame = abstractC4561jMo27977a.isDoFrame() & true;
                C4555d c4555d = (C4555d) this.f20924f;
                int iM27982h = c4555d.m27982h();
                for (int i10 = 1; i10 <= iM27982h; i10++) {
                    int i11 = iM27982h + i10;
                    if (c4555d.m27983i(i11)) {
                        zIsDoFrame &= this.f20924f.mo27979c(i11).isDoFrame();
                    }
                    int i12 = iM27982h - i10;
                    if (c4555d.m27983i(i12)) {
                        zIsDoFrame &= this.f20924f.mo27979c(i12).isDoFrame();
                    }
                }
            } else {
                while (abstractC4561jMo27977a != null) {
                    zIsDoFrame2 &= abstractC4561jMo27977a.isDoFrame();
                    abstractC4561jMo27977a = this.f20924f.mo27978b(abstractC4561jMo27977a);
                }
                zIsDoFrame = zIsDoFrame2;
            }
            if (zIsDoFrame) {
                m27997j();
            } else {
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    /* renamed from: e */
    public void m27992e(int i10) {
        AbstractC4560i abstractC4560i = this.f20924f;
        if (abstractC4560i instanceof C4555d) {
            ((C4555d) abstractC4560i).m27984j(i10);
        }
    }

    /* renamed from: f */
    public ChoreographerFrameCallbackC4556e m27993f(float f10) {
        this.f20921c = f10;
        return this;
    }

    /* renamed from: g */
    public ChoreographerFrameCallbackC4556e m27994g(float f10) {
        this.f20920b = f10;
        return this;
    }

    /* renamed from: h */
    public ChoreographerFrameCallbackC4556e m27995h(InterfaceC4553b<Float> interfaceC4553b) {
        this.f20923e = interfaceC4553b;
        return this;
    }

    /* renamed from: i */
    public ChoreographerFrameCallbackC4556e m27996i(int i10, int i11) {
        if (i10 < 0 || i11 < 0 || i11 < i10) {
            Log.w("SimpleSpringChain", "setDistanceDelta: distance delta should be greater than zero.");
            return this;
        }
        this.f20926h = i10;
        this.f20927i = i11;
        return this;
    }

    /* renamed from: j */
    public final void m27997j() {
        this.f20928j = false;
        Choreographer.getInstance().removeFrameCallback(this);
        for (a aVar : this.f20919a) {
            if (aVar != null) {
                aVar.m28005a();
            }
        }
    }

    /* renamed from: k */
    public ChoreographerFrameCallbackC4556e m27998k(float f10) {
        this.f20925g = f10;
        return this;
    }

    /* renamed from: l */
    public final void m27999l(AbstractC4561j abstractC4561j) {
        int i10;
        int index = abstractC4561j.getIndex();
        AbstractC4561j abstractC4561jMo27977a = this.f20924f.mo27977a();
        if (abstractC4561jMo27977a == null) {
            abstractC4561jMo27977a = abstractC4561j;
        }
        int iAbs = Math.abs(index - abstractC4561jMo27977a.getIndex());
        abstractC4561j.transferParams(this.f20922d.mo27975a(Float.valueOf(this.f20920b), iAbs).floatValue(), this.f20923e.mo27975a(Float.valueOf(this.f20921c), iAbs).floatValue());
        abstractC4561j.setFrameDelta(this.f20925g);
        int i11 = this.f20926h;
        if (i11 != -1 && (i10 = this.f20927i) != -1) {
            abstractC4561j.setDistanceDelta(i11, i10);
        }
        if (abstractC4561j.getAdapter() == null) {
            abstractC4561j.setAdapter(this.f20924f);
        }
    }

    /* renamed from: m */
    public final void m28000m() {
        if (this.f20928j) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(this);
        this.f20928j = true;
        for (a aVar : this.f20919a) {
            if (aVar != null) {
                aVar.m28006b();
            }
        }
    }

    /* renamed from: n */
    public ChoreographerFrameCallbackC4556e m28001n(InterfaceC4553b<Float> interfaceC4553b) {
        this.f20922d = interfaceC4553b;
        return this;
    }

    /* renamed from: o */
    public ChoreographerFrameCallbackC4556e m28002o(float f10) {
        AbstractC4561j abstractC4561jMo27977a = this.f20924f.mo27977a();
        if (abstractC4561jMo27977a != null) {
            abstractC4561jMo27977a.setValue(f10);
        }
        m28000m();
        return this;
    }

    /* renamed from: p */
    public ChoreographerFrameCallbackC4556e m28003p() {
        m28004q();
        return this;
    }

    /* renamed from: q */
    public final void m28004q() {
        if (this.f20924f.mo27977a() instanceof AbstractC4558g) {
            AbstractC4560i abstractC4560i = this.f20924f;
            if (abstractC4560i instanceof C4555d) {
                ((C4555d) abstractC4560i).m27986l(abstractC4560i.mo27980d() / 2);
            }
        }
        for (int i10 = 0; i10 < this.f20924f.mo27980d(); i10++) {
            AbstractC4561j abstractC4561jMo27979c = this.f20924f.mo27979c(i10);
            if (abstractC4561jMo27979c != null) {
                m27999l(abstractC4561jMo27979c);
            }
        }
    }
}
