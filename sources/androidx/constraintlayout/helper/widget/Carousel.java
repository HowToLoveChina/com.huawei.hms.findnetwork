package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.C0566a;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Carousel extends MotionHelper {

    /* renamed from: A */
    public int f2475A;

    /* renamed from: B */
    public float f2476B;

    /* renamed from: C */
    public int f2477C;

    /* renamed from: D */
    public int f2478D;

    /* renamed from: E */
    public int f2479E;

    /* renamed from: F */
    public Runnable f2480F;

    /* renamed from: n */
    public final ArrayList<View> f2481n;

    /* renamed from: o */
    public int f2482o;

    /* renamed from: p */
    public int f2483p;

    /* renamed from: q */
    public MotionLayout f2484q;

    /* renamed from: r */
    public int f2485r;

    /* renamed from: s */
    public boolean f2486s;

    /* renamed from: t */
    public int f2487t;

    /* renamed from: u */
    public int f2488u;

    /* renamed from: v */
    public int f2489v;

    /* renamed from: w */
    public int f2490w;

    /* renamed from: x */
    public float f2491x;

    /* renamed from: y */
    public int f2492y;

    /* renamed from: z */
    public int f2493z;

    /* renamed from: androidx.constraintlayout.helper.widget.Carousel$a */
    public class RunnableC0553a implements Runnable {
        public RunnableC0553a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.this.f2484q.setProgress(0.0f);
            Carousel.this.m3225K();
            Carousel.m3223I(Carousel.this);
            int unused = Carousel.this.f2483p;
            throw null;
        }
    }

    /* renamed from: androidx.constraintlayout.helper.widget.Carousel$b */
    public interface InterfaceC0554b {
    }

    public Carousel(Context context) {
        super(context);
        this.f2481n = new ArrayList<>();
        this.f2482o = 0;
        this.f2483p = 0;
        this.f2485r = -1;
        this.f2486s = false;
        this.f2487t = -1;
        this.f2488u = -1;
        this.f2489v = -1;
        this.f2490w = -1;
        this.f2491x = 0.9f;
        this.f2492y = 0;
        this.f2493z = 4;
        this.f2475A = 1;
        this.f2476B = 2.0f;
        this.f2477C = -1;
        this.f2478D = 200;
        this.f2479E = -1;
        this.f2480F = new RunnableC0553a();
    }

    /* renamed from: I */
    public static /* synthetic */ InterfaceC0554b m3223I(Carousel carousel) {
        carousel.getClass();
        return null;
    }

    /* renamed from: J */
    public final void m3224J(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.f2485r = typedArrayObtainStyledAttributes.getResourceId(index, this.f2485r);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.f2487t = typedArrayObtainStyledAttributes.getResourceId(index, this.f2487t);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.f2488u = typedArrayObtainStyledAttributes.getResourceId(index, this.f2488u);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.f2493z = typedArrayObtainStyledAttributes.getInt(index, this.f2493z);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.f2489v = typedArrayObtainStyledAttributes.getResourceId(index, this.f2489v);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.f2490w = typedArrayObtainStyledAttributes.getResourceId(index, this.f2490w);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f2491x = typedArrayObtainStyledAttributes.getFloat(index, this.f2491x);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.f2475A = typedArrayObtainStyledAttributes.getInt(index, this.f2475A);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.f2476B = typedArrayObtainStyledAttributes.getFloat(index, this.f2476B);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.f2486s = typedArrayObtainStyledAttributes.getBoolean(index, this.f2486s);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: K */
    public final void m3225K() {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0564j
    /* renamed from: a */
    public void mo3226a(MotionLayout motionLayout, int i10, int i11, float f10) {
        this.f2479E = i10;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0564j
    /* renamed from: d */
    public void mo3227d(MotionLayout motionLayout, int i10) {
        int i11 = this.f2483p;
        this.f2482o = i11;
        if (i10 == this.f2490w) {
            this.f2483p = i11 + 1;
        } else if (i10 == this.f2489v) {
            this.f2483p = i11 - 1;
        }
        if (!this.f2486s) {
            throw null;
        }
        throw null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.f2483p;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            this.f2481n.clear();
            for (int i10 = 0; i10 < this.f2942b; i10++) {
                int i11 = this.f2941a[i10];
                View viewById = motionLayout.getViewById(i11);
                if (this.f2485r == i11) {
                    this.f2492y = i10;
                }
                this.f2481n.add(viewById);
            }
            this.f2484q = motionLayout;
            if (this.f2475A == 2) {
                C0566a.b bVarM3315V = motionLayout.m3315V(this.f2488u);
                if (bVarM3315V != null) {
                    bVarM3315V.m3457G(5);
                }
                C0566a.b bVarM3315V2 = this.f2484q.m3315V(this.f2487t);
                if (bVarM3315V2 != null) {
                    bVarM3315V2.m3457G(5);
                }
            }
            m3225K();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2481n.clear();
    }

    public void setAdapter(InterfaceC0554b interfaceC0554b) {
    }

    public void setInfinite(boolean z10) {
        this.f2486s = z10;
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2481n = new ArrayList<>();
        this.f2482o = 0;
        this.f2483p = 0;
        this.f2485r = -1;
        this.f2486s = false;
        this.f2487t = -1;
        this.f2488u = -1;
        this.f2489v = -1;
        this.f2490w = -1;
        this.f2491x = 0.9f;
        this.f2492y = 0;
        this.f2493z = 4;
        this.f2475A = 1;
        this.f2476B = 2.0f;
        this.f2477C = -1;
        this.f2478D = 200;
        this.f2479E = -1;
        this.f2480F = new RunnableC0553a();
        m3224J(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2481n = new ArrayList<>();
        this.f2482o = 0;
        this.f2483p = 0;
        this.f2485r = -1;
        this.f2486s = false;
        this.f2487t = -1;
        this.f2488u = -1;
        this.f2489v = -1;
        this.f2490w = -1;
        this.f2491x = 0.9f;
        this.f2492y = 0;
        this.f2493z = 4;
        this.f2475A = 1;
        this.f2476B = 2.0f;
        this.f2477C = -1;
        this.f2478D = 200;
        this.f2479E = -1;
        this.f2480F = new RunnableC0553a();
        m3224J(context, attributeSet);
    }
}
