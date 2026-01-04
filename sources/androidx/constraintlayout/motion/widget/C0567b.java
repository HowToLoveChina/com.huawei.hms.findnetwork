package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;
import p642t.C12896a;

/* renamed from: androidx.constraintlayout.motion.widget.b */
/* loaded from: classes.dex */
public class C0567b {

    /* renamed from: G */
    public static final float[][] f2735G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: H */
    public static final float[][] f2736H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: r */
    public float f2760r;

    /* renamed from: s */
    public float f2761s;

    /* renamed from: t */
    public final MotionLayout f2762t;

    /* renamed from: a */
    public int f2743a = 0;

    /* renamed from: b */
    public int f2744b = 0;

    /* renamed from: c */
    public int f2745c = 0;

    /* renamed from: d */
    public int f2746d = -1;

    /* renamed from: e */
    public int f2747e = -1;

    /* renamed from: f */
    public int f2748f = -1;

    /* renamed from: g */
    public float f2749g = 0.5f;

    /* renamed from: h */
    public float f2750h = 0.5f;

    /* renamed from: i */
    public float f2751i = 0.5f;

    /* renamed from: j */
    public float f2752j = 0.5f;

    /* renamed from: k */
    public int f2753k = -1;

    /* renamed from: l */
    public boolean f2754l = false;

    /* renamed from: m */
    public float f2755m = 0.0f;

    /* renamed from: n */
    public float f2756n = 1.0f;

    /* renamed from: o */
    public boolean f2757o = false;

    /* renamed from: p */
    public float[] f2758p = new float[2];

    /* renamed from: q */
    public int[] f2759q = new int[2];

    /* renamed from: u */
    public float f2763u = 4.0f;

    /* renamed from: v */
    public float f2764v = 1.2f;

    /* renamed from: w */
    public boolean f2765w = true;

    /* renamed from: x */
    public float f2766x = 1.0f;

    /* renamed from: y */
    public int f2767y = 0;

    /* renamed from: z */
    public float f2768z = 10.0f;

    /* renamed from: A */
    public float f2737A = 10.0f;

    /* renamed from: B */
    public float f2738B = 1.0f;

    /* renamed from: C */
    public float f2739C = Float.NaN;

    /* renamed from: D */
    public float f2740D = Float.NaN;

    /* renamed from: E */
    public int f2741E = 0;

    /* renamed from: F */
    public int f2742F = 0;

    /* renamed from: androidx.constraintlayout.motion.widget.b$a */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.b$b */
    public class b implements NestedScrollView.InterfaceC0659c {
        public b() {
        }

        @Override // androidx.core.widget.NestedScrollView.InterfaceC0659c
        /* renamed from: a */
        public void mo3496a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        }
    }

    public C0567b(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f2762t = motionLayout;
        m3472c(context, Xml.asAttributeSet(xmlPullParser));
    }

    /* renamed from: A */
    public void m3469A() {
        View viewFindViewById;
        int i10 = this.f2746d;
        if (i10 != -1) {
            viewFindViewById = this.f2762t.findViewById(i10);
            if (viewFindViewById == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + C12896a.m77317c(this.f2762t.getContext(), this.f2746d));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new a());
            nestedScrollView.setOnScrollChangeListener(new b());
        }
    }

    /* renamed from: a */
    public float m3470a(float f10, float f11) {
        return (f10 * this.f2755m) + (f11 * this.f2756n);
    }

    /* renamed from: b */
    public final void m3471b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index == R$styleable.OnSwipe_touchAnchorId) {
                this.f2746d = typedArray.getResourceId(index, this.f2746d);
            } else if (index == R$styleable.OnSwipe_touchAnchorSide) {
                int i11 = typedArray.getInt(index, this.f2743a);
                this.f2743a = i11;
                float[] fArr = f2735G[i11];
                this.f2750h = fArr[0];
                this.f2749g = fArr[1];
            } else if (index == R$styleable.OnSwipe_dragDirection) {
                int i12 = typedArray.getInt(index, this.f2744b);
                this.f2744b = i12;
                float[][] fArr2 = f2736H;
                if (i12 < fArr2.length) {
                    float[] fArr3 = fArr2[i12];
                    this.f2755m = fArr3[0];
                    this.f2756n = fArr3[1];
                } else {
                    this.f2756n = Float.NaN;
                    this.f2755m = Float.NaN;
                    this.f2754l = true;
                }
            } else if (index == R$styleable.OnSwipe_maxVelocity) {
                this.f2763u = typedArray.getFloat(index, this.f2763u);
            } else if (index == R$styleable.OnSwipe_maxAcceleration) {
                this.f2764v = typedArray.getFloat(index, this.f2764v);
            } else if (index == R$styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f2765w = typedArray.getBoolean(index, this.f2765w);
            } else if (index == R$styleable.OnSwipe_dragScale) {
                this.f2766x = typedArray.getFloat(index, this.f2766x);
            } else if (index == R$styleable.OnSwipe_dragThreshold) {
                this.f2768z = typedArray.getFloat(index, this.f2768z);
            } else if (index == R$styleable.OnSwipe_touchRegionId) {
                this.f2747e = typedArray.getResourceId(index, this.f2747e);
            } else if (index == R$styleable.OnSwipe_onTouchUp) {
                this.f2745c = typedArray.getInt(index, this.f2745c);
            } else if (index == R$styleable.OnSwipe_nestedScrollFlags) {
                this.f2767y = typedArray.getInteger(index, 0);
            } else if (index == R$styleable.OnSwipe_limitBoundsTo) {
                this.f2748f = typedArray.getResourceId(index, 0);
            } else if (index == R$styleable.OnSwipe_rotationCenterId) {
                this.f2753k = typedArray.getResourceId(index, this.f2753k);
            } else if (index == R$styleable.OnSwipe_springDamping) {
                this.f2737A = typedArray.getFloat(index, this.f2737A);
            } else if (index == R$styleable.OnSwipe_springMass) {
                this.f2738B = typedArray.getFloat(index, this.f2738B);
            } else if (index == R$styleable.OnSwipe_springStiffness) {
                this.f2739C = typedArray.getFloat(index, this.f2739C);
            } else if (index == R$styleable.OnSwipe_springStopThreshold) {
                this.f2740D = typedArray.getFloat(index, this.f2740D);
            } else if (index == R$styleable.OnSwipe_springBoundary) {
                this.f2741E = typedArray.getInt(index, this.f2741E);
            } else if (index == R$styleable.OnSwipe_autoCompleteMode) {
                this.f2742F = typedArray.getInt(index, this.f2742F);
            }
        }
    }

    /* renamed from: c */
    public final void m3472c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OnSwipe);
        m3471b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: d */
    public int m3473d() {
        return this.f2742F;
    }

    /* renamed from: e */
    public int m3474e() {
        return this.f2767y;
    }

    /* renamed from: f */
    public RectF m3475f(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i10 = this.f2748f;
        if (i10 == -1 || (viewFindViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    /* renamed from: g */
    public float m3476g() {
        return this.f2764v;
    }

    /* renamed from: h */
    public float m3477h() {
        return this.f2763u;
    }

    /* renamed from: i */
    public boolean m3478i() {
        return this.f2765w;
    }

    /* renamed from: j */
    public float m3479j(float f10, float f11) throws Resources.NotFoundException {
        this.f2762t.m3312S(this.f2746d, this.f2762t.getProgress(), this.f2750h, this.f2749g, this.f2758p);
        float f12 = this.f2755m;
        if (f12 != 0.0f) {
            float[] fArr = this.f2758p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f10 * f12) / fArr[0];
        }
        float[] fArr2 = this.f2758p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f11 * this.f2756n) / fArr2[1];
    }

    /* renamed from: k */
    public int m3480k() {
        return this.f2741E;
    }

    /* renamed from: l */
    public float m3481l() {
        return this.f2737A;
    }

    /* renamed from: m */
    public float m3482m() {
        return this.f2738B;
    }

    /* renamed from: n */
    public float m3483n() {
        return this.f2739C;
    }

    /* renamed from: o */
    public float m3484o() {
        return this.f2740D;
    }

    /* renamed from: p */
    public RectF m3485p(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i10 = this.f2747e;
        if (i10 == -1 || (viewFindViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    /* renamed from: q */
    public int m3486q() {
        return this.f2747e;
    }

    /* renamed from: r */
    public boolean m3487r() {
        return this.f2757o;
    }

    /* renamed from: s */
    public void m3488s(MotionEvent motionEvent, MotionLayout.InterfaceC0561g interfaceC0561g, int i10, C0566a c0566a) throws Resources.NotFoundException {
        int i11;
        if (this.f2754l) {
            m3489t(motionEvent, interfaceC0561g, i10, c0566a);
            return;
        }
        interfaceC0561g.mo3363b(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2760r = motionEvent.getRawX();
            this.f2761s = motionEvent.getRawY();
            this.f2757o = false;
            return;
        }
        if (action == 1) {
            this.f2757o = false;
            interfaceC0561g.mo3366e(1000);
            float fMo3365d = interfaceC0561g.mo3365d();
            float fMo3364c = interfaceC0561g.mo3364c();
            float progress = this.f2762t.getProgress();
            int i12 = this.f2746d;
            if (i12 != -1) {
                this.f2762t.m3312S(i12, progress, this.f2750h, this.f2749g, this.f2758p);
            } else {
                float fMin = Math.min(this.f2762t.getWidth(), this.f2762t.getHeight());
                float[] fArr = this.f2758p;
                fArr[1] = this.f2756n * fMin;
                fArr[0] = fMin * this.f2755m;
            }
            float f10 = this.f2755m;
            float[] fArr2 = this.f2758p;
            float fAbs = f10 != 0.0f ? fMo3365d / fArr2[0] : fMo3364c / fArr2[1];
            float f11 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress : progress;
            if (f11 == 0.0f || f11 == 1.0f || (i11 = this.f2745c) == 3) {
                if (0.0f >= f11 || 1.0f <= f11) {
                    this.f2762t.setState(MotionLayout.EnumC0565k.FINISHED);
                    return;
                }
                return;
            }
            float f12 = ((double) f11) < 0.5d ? 0.0f : 1.0f;
            if (i11 == 6) {
                if (progress + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f12 = 1.0f;
            }
            if (this.f2745c == 7) {
                if (progress + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f12 = 0.0f;
            }
            this.f2762t.m3328i0(this.f2745c, f12, fAbs);
            if (0.0f >= progress || 1.0f <= progress) {
                this.f2762t.setState(MotionLayout.EnumC0565k.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.f2761s;
        float rawX = motionEvent.getRawX() - this.f2760r;
        if (Math.abs((this.f2755m * rawX) + (this.f2756n * rawY)) > this.f2768z || this.f2757o) {
            float progress2 = this.f2762t.getProgress();
            if (!this.f2757o) {
                this.f2757o = true;
                this.f2762t.setProgress(progress2);
            }
            int i13 = this.f2746d;
            if (i13 != -1) {
                this.f2762t.m3312S(i13, progress2, this.f2750h, this.f2749g, this.f2758p);
            } else {
                float fMin2 = Math.min(this.f2762t.getWidth(), this.f2762t.getHeight());
                float[] fArr3 = this.f2758p;
                fArr3[1] = this.f2756n * fMin2;
                fArr3[0] = fMin2 * this.f2755m;
            }
            float f13 = this.f2755m;
            float[] fArr4 = this.f2758p;
            if (Math.abs(((f13 * fArr4[0]) + (this.f2756n * fArr4[1])) * this.f2766x) < 0.01d) {
                float[] fArr5 = this.f2758p;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float fMax = Math.max(Math.min(progress2 + (this.f2755m != 0.0f ? rawX / this.f2758p[0] : rawY / this.f2758p[1]), 1.0f), 0.0f);
            if (this.f2745c == 6) {
                fMax = Math.max(fMax, 0.01f);
            }
            if (this.f2745c == 7) {
                fMax = Math.min(fMax, 0.99f);
            }
            float progress3 = this.f2762t.getProgress();
            if (fMax != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.f2762t.m3305L(progress3 == 0.0f);
                }
                this.f2762t.setProgress(fMax);
                interfaceC0561g.mo3366e(1000);
                this.f2762t.f2594d = this.f2755m != 0.0f ? interfaceC0561g.mo3365d() / this.f2758p[0] : interfaceC0561g.mo3364c() / this.f2758p[1];
            } else {
                this.f2762t.f2594d = 0.0f;
            }
            this.f2760r = motionEvent.getRawX();
            this.f2761s = motionEvent.getRawY();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02be  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3489t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0561g r25, int r26, androidx.constraintlayout.motion.widget.C0566a r27) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 834
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.C0567b.m3489t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$g, int, androidx.constraintlayout.motion.widget.a):void");
    }

    public String toString() {
        if (Float.isNaN(this.f2755m)) {
            return "rotation";
        }
        return this.f2755m + " , " + this.f2756n;
    }

    /* renamed from: u */
    public void m3490u(float f10, float f11) throws Resources.NotFoundException {
        float progress = this.f2762t.getProgress();
        if (!this.f2757o) {
            this.f2757o = true;
            this.f2762t.setProgress(progress);
        }
        this.f2762t.m3312S(this.f2746d, progress, this.f2750h, this.f2749g, this.f2758p);
        float f12 = this.f2755m;
        float[] fArr = this.f2758p;
        if (Math.abs((f12 * fArr[0]) + (this.f2756n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f2758p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f13 = this.f2755m;
        float fMax = Math.max(Math.min(progress + (f13 != 0.0f ? (f10 * f13) / this.f2758p[0] : (f11 * this.f2756n) / this.f2758p[1]), 1.0f), 0.0f);
        if (fMax != this.f2762t.getProgress()) {
            this.f2762t.setProgress(fMax);
        }
    }

    /* renamed from: v */
    public void m3491v(float f10, float f11) throws Resources.NotFoundException {
        int i10;
        this.f2757o = false;
        float progress = this.f2762t.getProgress();
        this.f2762t.m3312S(this.f2746d, progress, this.f2750h, this.f2749g, this.f2758p);
        float f12 = this.f2755m;
        float[] fArr = this.f2758p;
        float f13 = f12 != 0.0f ? (f10 * f12) / fArr[0] : (f11 * this.f2756n) / fArr[1];
        if (!Float.isNaN(f13)) {
            progress += f13 / 3.0f;
        }
        if (progress == 0.0f || progress == 1.0f || (i10 = this.f2745c) == 3) {
            return;
        }
        this.f2762t.m3328i0(i10, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f13);
    }

    /* renamed from: w */
    public void m3492w(float f10, float f11) {
        this.f2760r = f10;
        this.f2761s = f11;
    }

    /* renamed from: x */
    public void m3493x(boolean z10) {
        if (z10) {
            float[][] fArr = f2736H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = f2735G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f2736H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = f2735G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = f2735G[this.f2743a];
        this.f2750h = fArr5[0];
        this.f2749g = fArr5[1];
        int i10 = this.f2744b;
        float[][] fArr6 = f2736H;
        if (i10 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i10];
        this.f2755m = fArr7[0];
        this.f2756n = fArr7[1];
    }

    /* renamed from: y */
    public void m3494y(int i10) {
        this.f2745c = i10;
    }

    /* renamed from: z */
    public void m3495z(float f10, float f11) {
        this.f2760r = f10;
        this.f2761s = f11;
        this.f2757o = false;
    }
}
