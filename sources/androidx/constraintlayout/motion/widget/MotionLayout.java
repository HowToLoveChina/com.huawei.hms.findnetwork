package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.C0566a;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.C0584b;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.C0588f;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p273f0.InterfaceC9638z;
import p504o.C11771d;
import p561q.C12254a;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12260g;
import p561q.C12261h;
import p561q.C12263j;
import p561q.C12265l;
import p561q.C12266m;
import p561q.InterfaceC12262i;
import p627s.C12655b;
import p627s.C12658e;
import p642t.AbstractInterpolatorC12909n;
import p642t.C12896a;
import p642t.C12897b;
import p642t.C12908m;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements InterfaceC9638z {

    /* renamed from: E0 */
    public static boolean f2560E0;

    /* renamed from: A */
    public C12655b f2561A;

    /* renamed from: A0 */
    public RectF f2562A0;

    /* renamed from: B */
    public C0558d f2563B;

    /* renamed from: B0 */
    public View f2564B0;

    /* renamed from: C */
    public C12897b f2565C;

    /* renamed from: C0 */
    public Matrix f2566C0;

    /* renamed from: D */
    public boolean f2567D;

    /* renamed from: D0 */
    public ArrayList<Integer> f2568D0;

    /* renamed from: E */
    public int f2569E;

    /* renamed from: F */
    public int f2570F;

    /* renamed from: G */
    public int f2571G;

    /* renamed from: H */
    public int f2572H;

    /* renamed from: I */
    public boolean f2573I;

    /* renamed from: J */
    public float f2574J;

    /* renamed from: K */
    public float f2575K;

    /* renamed from: L */
    public long f2576L;

    /* renamed from: M */
    public float f2577M;

    /* renamed from: N */
    public boolean f2578N;

    /* renamed from: O */
    public ArrayList<MotionHelper> f2579O;

    /* renamed from: P */
    public ArrayList<MotionHelper> f2580P;

    /* renamed from: Q */
    public ArrayList<MotionHelper> f2581Q;

    /* renamed from: R */
    public CopyOnWriteArrayList<InterfaceC0564j> f2582R;

    /* renamed from: S */
    public int f2583S;

    /* renamed from: T */
    public long f2584T;

    /* renamed from: U */
    public float f2585U;

    /* renamed from: V */
    public int f2586V;

    /* renamed from: W */
    public float f2587W;

    /* renamed from: a */
    public C0566a f2588a;

    /* renamed from: a0 */
    public boolean f2589a0;

    /* renamed from: b */
    public Interpolator f2590b;

    /* renamed from: b0 */
    public boolean f2591b0;

    /* renamed from: c */
    public Interpolator f2592c;

    /* renamed from: c0 */
    public int f2593c0;

    /* renamed from: d */
    public float f2594d;

    /* renamed from: d0 */
    public int f2595d0;

    /* renamed from: e */
    public int f2596e;

    /* renamed from: e0 */
    public int f2597e0;

    /* renamed from: f */
    public int f2598f;

    /* renamed from: f0 */
    public int f2599f0;

    /* renamed from: g */
    public int f2600g;

    /* renamed from: g0 */
    public int f2601g0;

    /* renamed from: h */
    public int f2602h;

    /* renamed from: h0 */
    public int f2603h0;

    /* renamed from: i */
    public int f2604i;

    /* renamed from: i0 */
    public float f2605i0;

    /* renamed from: j */
    public boolean f2606j;

    /* renamed from: j0 */
    public C11771d f2607j0;

    /* renamed from: k */
    public HashMap<View, C12908m> f2608k;

    /* renamed from: k0 */
    public boolean f2609k0;

    /* renamed from: l */
    public long f2610l;

    /* renamed from: l0 */
    public C0563i f2611l0;

    /* renamed from: m */
    public float f2612m;

    /* renamed from: m0 */
    public Runnable f2613m0;

    /* renamed from: n */
    public float f2614n;

    /* renamed from: n0 */
    public int[] f2615n0;

    /* renamed from: o */
    public float f2616o;

    /* renamed from: o0 */
    public int f2617o0;

    /* renamed from: p */
    public long f2618p;

    /* renamed from: p0 */
    public boolean f2619p0;

    /* renamed from: q */
    public float f2620q;

    /* renamed from: q0 */
    public int f2621q0;

    /* renamed from: r */
    public boolean f2622r;

    /* renamed from: r0 */
    public HashMap<View, C12658e> f2623r0;

    /* renamed from: s */
    public boolean f2624s;

    /* renamed from: s0 */
    public int f2625s0;

    /* renamed from: t */
    public boolean f2626t;

    /* renamed from: t0 */
    public int f2627t0;

    /* renamed from: u */
    public InterfaceC0564j f2628u;

    /* renamed from: u0 */
    public int f2629u0;

    /* renamed from: v */
    public float f2630v;

    /* renamed from: v0 */
    public Rect f2631v0;

    /* renamed from: w */
    public float f2632w;

    /* renamed from: w0 */
    public boolean f2633w0;

    /* renamed from: x */
    public int f2634x;

    /* renamed from: x0 */
    public EnumC0565k f2635x0;

    /* renamed from: y */
    public C0559e f2636y;

    /* renamed from: y0 */
    public C0560f f2637y0;

    /* renamed from: z */
    public boolean f2638z;

    /* renamed from: z0 */
    public boolean f2639z0;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$a */
    public class RunnableC0555a implements Runnable {
        public RunnableC0555a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f2611l0.m3368a();
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$b */
    public class RunnableC0556b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f2641a;

        public RunnableC0556b(View view) {
            this.f2641a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2641a.setNestedScrollingEnabled(true);
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$c */
    public class RunnableC0557c implements Runnable {
        public RunnableC0557c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f2611l0.m3368a();
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$d */
    public class C0558d extends AbstractInterpolatorC12909n {

        /* renamed from: a */
        public float f2644a = 0.0f;

        /* renamed from: b */
        public float f2645b = 0.0f;

        /* renamed from: c */
        public float f2646c;

        public C0558d() {
        }

        @Override // p642t.AbstractInterpolatorC12909n
        /* renamed from: a */
        public float mo3338a() {
            return MotionLayout.this.f2594d;
        }

        /* renamed from: b */
        public void m3339b(float f10, float f11, float f12) {
            this.f2644a = f10;
            this.f2645b = f11;
            this.f2646c = f12;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11;
            float f12;
            float f13 = this.f2644a;
            if (f13 > 0.0f) {
                float f14 = this.f2646c;
                if (f13 / f14 < f10) {
                    f10 = f13 / f14;
                }
                MotionLayout.this.f2594d = f13 - (f14 * f10);
                f11 = (f13 * f10) - (((f14 * f10) * f10) / 2.0f);
                f12 = this.f2645b;
            } else {
                float f15 = this.f2646c;
                if ((-f13) / f15 < f10) {
                    f10 = (-f13) / f15;
                }
                MotionLayout.this.f2594d = (f15 * f10) + f13;
                f11 = (f13 * f10) + (((f15 * f10) * f10) / 2.0f);
                f12 = this.f2645b;
            }
            return f11 + f12;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$e */
    public class C0559e {

        /* renamed from: a */
        public float[] f2648a;

        /* renamed from: b */
        public int[] f2649b;

        /* renamed from: c */
        public float[] f2650c;

        /* renamed from: d */
        public Path f2651d;

        /* renamed from: e */
        public Paint f2652e;

        /* renamed from: f */
        public Paint f2653f;

        /* renamed from: g */
        public Paint f2654g;

        /* renamed from: h */
        public Paint f2655h;

        /* renamed from: i */
        public Paint f2656i;

        /* renamed from: j */
        public float[] f2657j;

        /* renamed from: p */
        public DashPathEffect f2663p;

        /* renamed from: q */
        public int f2664q;

        /* renamed from: t */
        public int f2667t;

        /* renamed from: k */
        public final int f2658k = -21965;

        /* renamed from: l */
        public final int f2659l = -2067046;

        /* renamed from: m */
        public final int f2660m = -13391360;

        /* renamed from: n */
        public final int f2661n = 1996488704;

        /* renamed from: o */
        public final int f2662o = 10;

        /* renamed from: r */
        public Rect f2665r = new Rect();

        /* renamed from: s */
        public boolean f2666s = false;

        public C0559e() {
            this.f2667t = 1;
            Paint paint = new Paint();
            this.f2652e = paint;
            paint.setAntiAlias(true);
            this.f2652e.setColor(-21965);
            this.f2652e.setStrokeWidth(2.0f);
            Paint paint2 = this.f2652e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f2653f = paint3;
            paint3.setAntiAlias(true);
            this.f2653f.setColor(-2067046);
            this.f2653f.setStrokeWidth(2.0f);
            this.f2653f.setStyle(style);
            Paint paint4 = new Paint();
            this.f2654g = paint4;
            paint4.setAntiAlias(true);
            this.f2654g.setColor(-13391360);
            this.f2654g.setStrokeWidth(2.0f);
            this.f2654g.setStyle(style);
            Paint paint5 = new Paint();
            this.f2655h = paint5;
            paint5.setAntiAlias(true);
            this.f2655h.setColor(-13391360);
            this.f2655h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f2657j = new float[8];
            Paint paint6 = new Paint();
            this.f2656i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f2663p = dashPathEffect;
            this.f2654g.setPathEffect(dashPathEffect);
            this.f2650c = new float[100];
            this.f2649b = new int[50];
            if (this.f2666s) {
                this.f2652e.setStrokeWidth(8.0f);
                this.f2656i.setStrokeWidth(8.0f);
                this.f2653f.setStrokeWidth(8.0f);
                this.f2667t = 4;
            }
        }

        /* renamed from: a */
        public void m3340a(Canvas canvas, HashMap<View, C12908m> map, int i10, int i11) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i11 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f2600g) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f2655h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f2652e);
            }
            for (C12908m c12908m : map.values()) {
                int iM77503m = c12908m.m77503m();
                if (i11 > 0 && iM77503m == 0) {
                    iM77503m = 1;
                }
                if (iM77503m != 0) {
                    this.f2664q = c12908m.m77493c(this.f2650c, this.f2649b);
                    if (iM77503m >= 1) {
                        int i12 = i10 / 16;
                        float[] fArr = this.f2648a;
                        if (fArr == null || fArr.length != i12 * 2) {
                            this.f2648a = new float[i12 * 2];
                            this.f2651d = new Path();
                        }
                        int i13 = this.f2667t;
                        canvas.translate(i13, i13);
                        this.f2652e.setColor(1996488704);
                        this.f2656i.setColor(1996488704);
                        this.f2653f.setColor(1996488704);
                        this.f2654g.setColor(1996488704);
                        c12908m.m77494d(this.f2648a, i12);
                        m3341b(canvas, iM77503m, this.f2664q, c12908m);
                        this.f2652e.setColor(-21965);
                        this.f2653f.setColor(-2067046);
                        this.f2656i.setColor(-2067046);
                        this.f2654g.setColor(-13391360);
                        int i14 = this.f2667t;
                        canvas.translate(-i14, -i14);
                        m3341b(canvas, iM77503m, this.f2664q, c12908m);
                        if (iM77503m == 5) {
                            m3349j(canvas, c12908m);
                        }
                    }
                }
            }
            canvas.restore();
        }

        /* renamed from: b */
        public void m3341b(Canvas canvas, int i10, int i11, C12908m c12908m) {
            if (i10 == 4) {
                m3343d(canvas);
            }
            if (i10 == 2) {
                m3346g(canvas);
            }
            if (i10 == 3) {
                m3344e(canvas);
            }
            m3342c(canvas);
            m3350k(canvas, i10, i11, c12908m);
        }

        /* renamed from: c */
        public final void m3342c(Canvas canvas) {
            canvas.drawLines(this.f2648a, this.f2652e);
        }

        /* renamed from: d */
        public final void m3343d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f2664q; i10++) {
                int i11 = this.f2649b[i10];
                if (i11 == 1) {
                    z10 = true;
                }
                if (i11 == 0) {
                    z11 = true;
                }
            }
            if (z10) {
                m3346g(canvas);
            }
            if (z11) {
                m3344e(canvas);
            }
        }

        /* renamed from: e */
        public final void m3344e(Canvas canvas) {
            float[] fArr = this.f2648a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f2654g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f2654g);
        }

        /* renamed from: f */
        public final void m3345f(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f2648a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float fMin = Math.min(f12, f14);
            float fMax = Math.max(f13, f15);
            float fMin2 = f10 - Math.min(f12, f14);
            float fMax2 = Math.max(f13, f15) - f11;
            String str = "" + (((int) (((fMin2 * 100.0f) / Math.abs(f14 - f12)) + 0.5d)) / 100.0f);
            m3351l(str, this.f2655h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.f2665r.width() / 2)) + fMin, f11 - 20.0f, this.f2655h);
            canvas.drawLine(f10, f11, Math.min(f12, f14), f11, this.f2654g);
            String str2 = "" + (((int) (((fMax2 * 100.0f) / Math.abs(f15 - f13)) + 0.5d)) / 100.0f);
            m3351l(str2, this.f2655h);
            canvas.drawText(str2, f10 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.f2665r.height() / 2)), this.f2655h);
            canvas.drawLine(f10, f11, f10, Math.max(f13, f15), this.f2654g);
        }

        /* renamed from: g */
        public final void m3346g(Canvas canvas) {
            float[] fArr = this.f2648a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f2654g);
        }

        /* renamed from: h */
        public final void m3347h(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f2648a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f12 - f14, f13 - f15);
            float f16 = f14 - f12;
            float f17 = f15 - f13;
            float f18 = (((f10 - f12) * f16) + ((f11 - f13) * f17)) / (fHypot * fHypot);
            float f19 = f12 + (f16 * f18);
            float f20 = f13 + (f18 * f17);
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f19, f20);
            float fHypot2 = (float) Math.hypot(f19 - f10, f20 - f11);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            m3351l(str, this.f2655h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f2665r.width() / 2), -20.0f, this.f2655h);
            canvas.drawLine(f10, f11, f19, f20, this.f2654g);
        }

        /* renamed from: i */
        public final void m3348i(Canvas canvas, float f10, float f11, int i10, int i11) {
            String str = "" + (((int) ((((f10 - (i10 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i10)) + 0.5d)) / 100.0f);
            m3351l(str, this.f2655h);
            canvas.drawText(str, ((f10 / 2.0f) - (this.f2665r.width() / 2)) + 0.0f, f11 - 20.0f, this.f2655h);
            canvas.drawLine(f10, f11, Math.min(0.0f, 1.0f), f11, this.f2654g);
            String str2 = "" + (((int) ((((f11 - (i11 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i11)) + 0.5d)) / 100.0f);
            m3351l(str2, this.f2655h);
            canvas.drawText(str2, f10 + 5.0f, 0.0f - ((f11 / 2.0f) - (this.f2665r.height() / 2)), this.f2655h);
            canvas.drawLine(f10, f11, f10, Math.max(0.0f, 1.0f), this.f2654g);
        }

        /* renamed from: j */
        public final void m3349j(Canvas canvas, C12908m c12908m) {
            this.f2651d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                c12908m.m77495e(i10 / 50, this.f2657j, 0);
                Path path = this.f2651d;
                float[] fArr = this.f2657j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f2651d;
                float[] fArr2 = this.f2657j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f2651d;
                float[] fArr3 = this.f2657j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f2651d;
                float[] fArr4 = this.f2657j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f2651d.close();
            }
            this.f2652e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f2651d, this.f2652e);
            canvas.translate(-2.0f, -2.0f);
            this.f2652e.setColor(-65536);
            canvas.drawPath(this.f2651d, this.f2652e);
        }

        /* renamed from: k */
        public final void m3350k(Canvas canvas, int i10, int i11, C12908m c12908m) {
            int width;
            int height;
            float f10;
            float f11;
            View view = c12908m.f58833b;
            if (view != null) {
                width = view.getWidth();
                height = c12908m.f58833b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i12 = 1; i12 < i11 - 1; i12++) {
                if (i10 != 4 || this.f2649b[i12 - 1] != 0) {
                    float[] fArr = this.f2650c;
                    int i13 = i12 * 2;
                    float f12 = fArr[i13];
                    float f13 = fArr[i13 + 1];
                    this.f2651d.reset();
                    this.f2651d.moveTo(f12, f13 + 10.0f);
                    this.f2651d.lineTo(f12 + 10.0f, f13);
                    this.f2651d.lineTo(f12, f13 - 10.0f);
                    this.f2651d.lineTo(f12 - 10.0f, f13);
                    this.f2651d.close();
                    int i14 = i12 - 1;
                    c12908m.m77506q(i14);
                    if (i10 == 4) {
                        int i15 = this.f2649b[i14];
                        if (i15 == 1) {
                            m3347h(canvas, f12 - 0.0f, f13 - 0.0f);
                        } else if (i15 == 0) {
                            m3345f(canvas, f12 - 0.0f, f13 - 0.0f);
                        } else {
                            if (i15 == 2) {
                                f10 = f13;
                                f11 = f12;
                                m3348i(canvas, f12 - 0.0f, f13 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.f2651d, this.f2656i);
                        }
                        f10 = f13;
                        f11 = f12;
                        canvas.drawPath(this.f2651d, this.f2656i);
                    } else {
                        f10 = f13;
                        f11 = f12;
                    }
                    if (i10 == 2) {
                        m3347h(canvas, f11 - 0.0f, f10 - 0.0f);
                    }
                    if (i10 == 3) {
                        m3345f(canvas, f11 - 0.0f, f10 - 0.0f);
                    }
                    if (i10 == 6) {
                        m3348i(canvas, f11 - 0.0f, f10 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.f2651d, this.f2656i);
                }
            }
            float[] fArr2 = this.f2648a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f2653f);
                float[] fArr3 = this.f2648a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f2653f);
            }
        }

        /* renamed from: l */
        public void m3351l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f2665r);
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$f */
    public class C0560f {

        /* renamed from: a */
        public C12259f f2669a = new C12259f();

        /* renamed from: b */
        public C12259f f2670b = new C12259f();

        /* renamed from: c */
        public C0585c f2671c = null;

        /* renamed from: d */
        public C0585c f2672d = null;

        /* renamed from: e */
        public int f2673e;

        /* renamed from: f */
        public int f2674f;

        public C0560f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x013c A[SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m3352a() {
            /*
                Method dump skipped, instructions count: 359
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.C0560f.m3352a():void");
        }

        /* renamed from: b */
        public final void m3353b(int i10, int i11) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f2598f == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                C12259f c12259f = this.f2670b;
                C0585c c0585c = this.f2672d;
                motionLayout2.resolveSystem(c12259f, optimizationLevel, (c0585c == null || c0585c.f3101e == 0) ? i10 : i11, (c0585c == null || c0585c.f3101e == 0) ? i11 : i10);
                C0585c c0585c2 = this.f2671c;
                if (c0585c2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    C12259f c12259f2 = this.f2669a;
                    int i12 = c0585c2.f3101e;
                    int i13 = i12 == 0 ? i10 : i11;
                    if (i12 == 0) {
                        i10 = i11;
                    }
                    motionLayout3.resolveSystem(c12259f2, optimizationLevel, i13, i10);
                    return;
                }
                return;
            }
            C0585c c0585c3 = this.f2671c;
            if (c0585c3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                C12259f c12259f3 = this.f2669a;
                int i14 = c0585c3.f3101e;
                motionLayout4.resolveSystem(c12259f3, optimizationLevel, i14 == 0 ? i10 : i11, i14 == 0 ? i11 : i10);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            C12259f c12259f4 = this.f2670b;
            C0585c c0585c4 = this.f2672d;
            int i15 = (c0585c4 == null || c0585c4.f3101e == 0) ? i10 : i11;
            if (c0585c4 == null || c0585c4.f3101e == 0) {
                i10 = i11;
            }
            motionLayout5.resolveSystem(c12259f4, optimizationLevel, i15, i10);
        }

        /* renamed from: c */
        public void m3354c(C12259f c12259f, C12259f c12259f2) {
            ArrayList<C12258e> arrayListM73795w1 = c12259f.m73795w1();
            HashMap<C12258e, C12258e> map = new HashMap<>();
            map.put(c12259f, c12259f2);
            c12259f2.m73795w1().clear();
            c12259f2.mo73514n(c12259f, map);
            Iterator<C12258e> it = arrayListM73795w1.iterator();
            while (it.hasNext()) {
                C12258e next = it.next();
                C12258e c12254a = next instanceof C12254a ? new C12254a() : next instanceof C12261h ? new C12261h() : next instanceof C12260g ? new C12260g() : next instanceof C12265l ? new C12265l() : next instanceof InterfaceC12262i ? new C12263j() : new C12258e();
                c12259f2.m73794a(c12254a);
                map.put(next, c12254a);
            }
            Iterator<C12258e> it2 = arrayListM73795w1.iterator();
            while (it2.hasNext()) {
                C12258e next2 = it2.next();
                map.get(next2).mo73514n(next2, map);
            }
        }

        /* renamed from: d */
        public C12258e m3355d(C12259f c12259f, View view) {
            if (c12259f.m73650u() == view) {
                return c12259f;
            }
            ArrayList<C12258e> arrayListM73795w1 = c12259f.m73795w1();
            int size = arrayListM73795w1.size();
            for (int i10 = 0; i10 < size; i10++) {
                C12258e c12258e = arrayListM73795w1.get(i10);
                if (c12258e.m73650u() == view) {
                    return c12258e;
                }
            }
            return null;
        }

        /* renamed from: e */
        public void m3356e(C12259f c12259f, C0585c c0585c, C0585c c0585c2) {
            this.f2671c = c0585c;
            this.f2672d = c0585c2;
            this.f2669a = new C12259f();
            this.f2670b = new C12259f();
            this.f2669a.m73692b2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.m73680O1());
            this.f2670b.m73692b2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.m73680O1());
            this.f2669a.m73797z1();
            this.f2670b.m73797z1();
            m3354c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f2669a);
            m3354c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f2670b);
            if (MotionLayout.this.f2616o > 0.5d) {
                if (c0585c != null) {
                    m3361j(this.f2669a, c0585c);
                }
                m3361j(this.f2670b, c0585c2);
            } else {
                m3361j(this.f2670b, c0585c2);
                if (c0585c != null) {
                    m3361j(this.f2669a, c0585c);
                }
            }
            this.f2669a.m73695e2(MotionLayout.this.isRtl());
            this.f2669a.m73697g2();
            this.f2670b.m73695e2(MotionLayout.this.isRtl());
            this.f2670b.m73697g2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    C12259f c12259f2 = this.f2669a;
                    C12258e.b bVar = C12258e.b.WRAP_CONTENT;
                    c12259f2.m73587U0(bVar);
                    this.f2670b.m73587U0(bVar);
                }
                if (layoutParams.height == -2) {
                    C12259f c12259f3 = this.f2669a;
                    C12258e.b bVar2 = C12258e.b.WRAP_CONTENT;
                    c12259f3.m73628l1(bVar2);
                    this.f2670b.m73628l1(bVar2);
                }
            }
        }

        /* renamed from: f */
        public boolean m3357f(int i10, int i11) {
            return (i10 == this.f2673e && i11 == this.f2674f) ? false : true;
        }

        /* renamed from: g */
        public void m3358g(int i10, int i11) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f2601g0 = mode;
            motionLayout.f2603h0 = mode2;
            m3353b(i10, i11);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                m3353b(i10, i11);
                MotionLayout.this.f2593c0 = this.f2669a.m73594Y();
                MotionLayout.this.f2595d0 = this.f2669a.m73662z();
                MotionLayout.this.f2597e0 = this.f2670b.m73594Y();
                MotionLayout.this.f2599f0 = this.f2670b.m73662z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.f2591b0 = (motionLayout2.f2593c0 == motionLayout2.f2597e0 && motionLayout2.f2595d0 == motionLayout2.f2599f0) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i12 = motionLayout3.f2593c0;
            int i13 = motionLayout3.f2595d0;
            int i14 = motionLayout3.f2601g0;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i12 = (int) (i12 + (motionLayout3.f2605i0 * (motionLayout3.f2597e0 - i12)));
            }
            int i15 = i12;
            int i16 = motionLayout3.f2603h0;
            if (i16 == Integer.MIN_VALUE || i16 == 0) {
                i13 = (int) (i13 + (motionLayout3.f2605i0 * (motionLayout3.f2599f0 - i13)));
            }
            MotionLayout.this.resolveMeasuredDimension(i10, i11, i15, i13, this.f2669a.m73688W1() || this.f2670b.m73688W1(), this.f2669a.m73686U1() || this.f2670b.m73686U1());
        }

        /* renamed from: h */
        public void m3359h() {
            m3358g(MotionLayout.this.f2602h, MotionLayout.this.f2604i);
            MotionLayout.this.m3326g0();
        }

        /* renamed from: i */
        public void m3360i(int i10, int i11) {
            this.f2673e = i10;
            this.f2674f = i11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: j */
        public final void m3361j(C12259f c12259f, C0585c c0585c) {
            SparseArray<C12258e> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, c12259f);
            sparseArray.put(MotionLayout.this.getId(), c12259f);
            if (c0585c != null && c0585c.f3101e != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f2670b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<C12258e> it = c12259f.m73795w1().iterator();
            while (it.hasNext()) {
                C12258e next = it.next();
                next.m73555E0(true);
                sparseArray.put(((View) next.m73650u()).getId(), next);
            }
            Iterator<C12258e> it2 = c12259f.m73795w1().iterator();
            while (it2.hasNext()) {
                C12258e next2 = it2.next();
                View view = (View) next2.m73650u();
                c0585c.m3634l(view.getId(), layoutParams);
                next2.m73638p1(c0585c.m3620C(view.getId()));
                next2.m73579Q0(c0585c.m3645x(view.getId()));
                if (view instanceof ConstraintHelper) {
                    c0585c.m3632j((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).m3567w();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (c0585c.m3619B(view.getId()) == 1) {
                    next2.m73636o1(view.getVisibility());
                } else {
                    next2.m73636o1(c0585c.m3618A(view.getId()));
                }
            }
            Iterator<C12258e> it3 = c12259f.m73795w1().iterator();
            while (it3.hasNext()) {
                C12258e next3 = it3.next();
                if (next3 instanceof C12266m) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) next3.m73650u();
                    InterfaceC12262i interfaceC12262i = (InterfaceC12262i) next3;
                    constraintHelper.mo3265v(c12259f, interfaceC12262i, sparseArray);
                    ((C12266m) interfaceC12262i).m73793z1();
                }
            }
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$g */
    public interface InterfaceC0561g {
        /* renamed from: a */
        void mo3362a();

        /* renamed from: b */
        void mo3363b(MotionEvent motionEvent);

        /* renamed from: c */
        float mo3364c();

        /* renamed from: d */
        float mo3365d();

        /* renamed from: e */
        void mo3366e(int i10);
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$h */
    public static class C0562h implements InterfaceC0561g {

        /* renamed from: b */
        public static C0562h f2676b = new C0562h();

        /* renamed from: a */
        public VelocityTracker f2677a;

        /* renamed from: f */
        public static C0562h m3367f() {
            f2676b.f2677a = VelocityTracker.obtain();
            return f2676b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0561g
        /* renamed from: a */
        public void mo3362a() {
            VelocityTracker velocityTracker = this.f2677a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2677a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0561g
        /* renamed from: b */
        public void mo3363b(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f2677a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0561g
        /* renamed from: c */
        public float mo3364c() {
            VelocityTracker velocityTracker = this.f2677a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0561g
        /* renamed from: d */
        public float mo3365d() {
            VelocityTracker velocityTracker = this.f2677a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.InterfaceC0561g
        /* renamed from: e */
        public void mo3366e(int i10) {
            VelocityTracker velocityTracker = this.f2677a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i10);
            }
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$i */
    public class C0563i {

        /* renamed from: a */
        public float f2678a = Float.NaN;

        /* renamed from: b */
        public float f2679b = Float.NaN;

        /* renamed from: c */
        public int f2680c = -1;

        /* renamed from: d */
        public int f2681d = -1;

        /* renamed from: e */
        public final String f2682e = "motion.progress";

        /* renamed from: f */
        public final String f2683f = "motion.velocity";

        /* renamed from: g */
        public final String f2684g = "motion.StartState";

        /* renamed from: h */
        public final String f2685h = "motion.EndState";

        public C0563i() {
        }

        /* renamed from: a */
        public void m3368a() {
            int i10 = this.f2680c;
            if (i10 != -1 || this.f2681d != -1) {
                if (i10 == -1) {
                    MotionLayout.this.m3332m0(this.f2681d);
                } else {
                    int i11 = this.f2681d;
                    if (i11 == -1) {
                        MotionLayout.this.setState(i10, -1, -1);
                    } else {
                        MotionLayout.this.m3325f0(i10, i11);
                    }
                }
                MotionLayout.this.setState(EnumC0565k.SETUP);
            }
            if (Float.isNaN(this.f2679b)) {
                if (Float.isNaN(this.f2678a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f2678a);
            } else {
                MotionLayout.this.m3324e0(this.f2678a, this.f2679b);
                this.f2678a = Float.NaN;
                this.f2679b = Float.NaN;
                this.f2680c = -1;
                this.f2681d = -1;
            }
        }

        /* renamed from: b */
        public Bundle m3369b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f2678a);
            bundle.putFloat("motion.velocity", this.f2679b);
            bundle.putInt("motion.StartState", this.f2680c);
            bundle.putInt("motion.EndState", this.f2681d);
            return bundle;
        }

        /* renamed from: c */
        public void m3370c() {
            this.f2681d = MotionLayout.this.f2600g;
            this.f2680c = MotionLayout.this.f2596e;
            this.f2679b = MotionLayout.this.getVelocity();
            this.f2678a = MotionLayout.this.getProgress();
        }

        /* renamed from: d */
        public void m3371d(int i10) {
            this.f2681d = i10;
        }

        /* renamed from: e */
        public void m3372e(float f10) {
            this.f2678a = f10;
        }

        /* renamed from: f */
        public void m3373f(int i10) {
            this.f2680c = i10;
        }

        /* renamed from: g */
        public void m3374g(Bundle bundle) {
            this.f2678a = bundle.getFloat("motion.progress");
            this.f2679b = bundle.getFloat("motion.velocity");
            this.f2680c = bundle.getInt("motion.StartState");
            this.f2681d = bundle.getInt("motion.EndState");
        }

        /* renamed from: h */
        public void m3375h(float f10) {
            this.f2679b = f10;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$j */
    public interface InterfaceC0564j {
        /* renamed from: a */
        void mo3226a(MotionLayout motionLayout, int i10, int i11, float f10);

        /* renamed from: b */
        void mo3270b(MotionLayout motionLayout, int i10, int i11);

        /* renamed from: c */
        void mo3271c(MotionLayout motionLayout, int i10, boolean z10, float f10);

        /* renamed from: d */
        void mo3227d(MotionLayout motionLayout, int i10);
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$k */
    public enum EnumC0565k {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.f2592c = null;
        this.f2594d = 0.0f;
        this.f2596e = -1;
        this.f2598f = -1;
        this.f2600g = -1;
        this.f2602h = 0;
        this.f2604i = 0;
        this.f2606j = true;
        this.f2608k = new HashMap<>();
        this.f2610l = 0L;
        this.f2612m = 1.0f;
        this.f2614n = 0.0f;
        this.f2616o = 0.0f;
        this.f2620q = 0.0f;
        this.f2624s = false;
        this.f2626t = false;
        this.f2634x = 0;
        this.f2638z = false;
        this.f2561A = new C12655b();
        this.f2563B = new C0558d();
        this.f2567D = true;
        this.f2573I = false;
        this.f2578N = false;
        this.f2579O = null;
        this.f2580P = null;
        this.f2581Q = null;
        this.f2582R = null;
        this.f2583S = 0;
        this.f2584T = -1L;
        this.f2585U = 0.0f;
        this.f2586V = 0;
        this.f2587W = 0.0f;
        this.f2589a0 = false;
        this.f2591b0 = false;
        this.f2607j0 = new C11771d();
        this.f2609k0 = false;
        this.f2613m0 = null;
        this.f2615n0 = null;
        this.f2617o0 = 0;
        this.f2619p0 = false;
        this.f2621q0 = 0;
        this.f2623r0 = new HashMap<>();
        this.f2631v0 = new Rect();
        this.f2633w0 = false;
        this.f2635x0 = EnumC0565k.UNDEFINED;
        this.f2637y0 = new C0560f();
        this.f2639z0 = false;
        this.f2562A0 = new RectF();
        this.f2564B0 = null;
        this.f2566C0 = null;
        this.f2568D0 = new ArrayList<>();
        m3318Y(null);
    }

    /* renamed from: s0 */
    public static boolean m3290s0(float f10, float f11, float f12) {
        if (f10 > 0.0f) {
            float f13 = f10 / f12;
            return f11 + ((f10 * f13) - (((f12 * f13) * f13) / 2.0f)) > 1.0f;
        }
        float f14 = (-f10) / f12;
        return f11 + ((f10 * f14) + (((f12 * f14) * f14) / 2.0f)) < 0.0f;
    }

    /* renamed from: E */
    public void m3298E(float f10) {
        if (this.f2588a == null) {
            return;
        }
        float f11 = this.f2616o;
        float f12 = this.f2614n;
        if (f11 != f12 && this.f2622r) {
            this.f2616o = f12;
        }
        float f13 = this.f2616o;
        if (f13 == f10) {
            return;
        }
        this.f2638z = false;
        this.f2620q = f10;
        this.f2612m = r0.m3421p() / 1000.0f;
        setProgress(this.f2620q);
        this.f2590b = null;
        this.f2592c = this.f2588a.m3424s();
        this.f2622r = false;
        this.f2610l = getNanoTime();
        this.f2624s = true;
        this.f2614n = f13;
        this.f2616o = f13;
        invalidate();
    }

    /* renamed from: F */
    public boolean m3299F(int i10, C12908m c12908m) {
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            return c0566a.m3412g(i10, c12908m);
        }
        return false;
    }

    /* renamed from: G */
    public final boolean m3300G(View view, MotionEvent motionEvent, float f10, float f11) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f10, f11);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f10, -f11);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f10, f11);
        if (this.f2566C0 == null) {
            this.f2566C0 = new Matrix();
        }
        matrix.invert(this.f2566C0);
        motionEventObtain.transform(this.f2566C0);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    /* renamed from: H */
    public final void m3301H() {
        C0566a c0566a = this.f2588a;
        if (c0566a == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int iM3388F = c0566a.m3388F();
        C0566a c0566a2 = this.f2588a;
        m3302I(iM3388F, c0566a2.m3417l(c0566a2.m3388F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<C0566a.b> it = this.f2588a.m3420o().iterator();
        while (it.hasNext()) {
            C0566a.b next = it.next();
            if (next == this.f2588a.f2694c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            m3303J(next);
            int iM3451A = next.m3451A();
            int iM3464y = next.m3464y();
            String strM77317c = C12896a.m77317c(getContext(), iM3451A);
            String strM77317c2 = C12896a.m77317c(getContext(), iM3464y);
            if (sparseIntArray.get(iM3451A) == iM3464y) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + strM77317c + "->" + strM77317c2);
            }
            if (sparseIntArray2.get(iM3464y) == iM3451A) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + strM77317c + "->" + strM77317c2);
            }
            sparseIntArray.put(iM3451A, iM3464y);
            sparseIntArray2.put(iM3464y, iM3451A);
            if (this.f2588a.m3417l(iM3451A) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + strM77317c);
            }
            if (this.f2588a.m3417l(iM3464y) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + strM77317c);
            }
        }
    }

    /* renamed from: I */
    public final void m3302I(int i10, C0585c c0585c) {
        String strM77317c = C12896a.m77317c(getContext(), i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + strM77317c + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (c0585c.m3644w(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + strM77317c + " NO CONSTRAINTS for " + C12896a.m77318d(childAt));
            }
        }
        int[] iArrM3646y = c0585c.m3646y();
        for (int i12 = 0; i12 < iArrM3646y.length; i12++) {
            int i13 = iArrM3646y[i12];
            String strM77317c2 = C12896a.m77317c(getContext(), i13);
            if (findViewById(iArrM3646y[i12]) == null) {
                Log.w("MotionLayout", "CHECK: " + strM77317c + " NO View matches id " + strM77317c2);
            }
            if (c0585c.m3645x(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + strM77317c + "(" + strM77317c2 + ") no LAYOUT_HEIGHT");
            }
            if (c0585c.m3620C(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + strM77317c + "(" + strM77317c2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    /* renamed from: J */
    public final void m3303J(C0566a.b bVar) {
        if (bVar.m3451A() == bVar.m3464y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    /* renamed from: K */
    public final void m3304K() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            C12908m c12908m = this.f2608k.get(childAt);
            if (c12908m != null) {
                c12908m.m77485E(childAt);
            }
        }
    }

    /* renamed from: L */
    public void m3305L(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            C12908m c12908m = this.f2608k.get(getChildAt(i10));
            if (c12908m != null) {
                c12908m.m77496f(z10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:243:0x00e2 A[PHI: r3
  0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:228:0x00ab, B:239:0x00d6, B:241:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0222  */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3306M(boolean r23) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.m3306M(boolean):void");
    }

    /* renamed from: N */
    public final void m3307N() {
        boolean z10;
        float fSignum = Math.signum(this.f2620q - this.f2616o);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f2590b;
        float interpolation = this.f2616o + (!(interpolator instanceof C12655b) ? (((nanoTime - this.f2618p) * fSignum) * 1.0E-9f) / this.f2612m : 0.0f);
        if (this.f2622r) {
            interpolation = this.f2620q;
        }
        if ((fSignum <= 0.0f || interpolation < this.f2620q) && (fSignum > 0.0f || interpolation > this.f2620q)) {
            z10 = false;
        } else {
            interpolation = this.f2620q;
            z10 = true;
        }
        if (interpolator != null && !z10) {
            interpolation = this.f2638z ? interpolator.getInterpolation((nanoTime - this.f2610l) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.f2620q) || (fSignum <= 0.0f && interpolation <= this.f2620q)) {
            interpolation = this.f2620q;
        }
        this.f2605i0 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f2592c;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            C12908m c12908m = this.f2608k.get(childAt);
            if (c12908m != null) {
                c12908m.m77513x(childAt, interpolation, nanoTime2, this.f2607j0);
            }
        }
        if (this.f2591b0) {
            requestLayout();
        }
    }

    /* renamed from: O */
    public final void m3308O() {
        CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList;
        if ((this.f2628u == null && ((copyOnWriteArrayList = this.f2582R) == null || copyOnWriteArrayList.isEmpty())) || this.f2587W == this.f2614n) {
            return;
        }
        if (this.f2586V != -1) {
            m3310Q();
            this.f2589a0 = true;
        }
        this.f2586V = -1;
        float f10 = this.f2614n;
        this.f2587W = f10;
        InterfaceC0564j interfaceC0564j = this.f2628u;
        if (interfaceC0564j != null) {
            interfaceC0564j.mo3226a(this, this.f2596e, this.f2600g, f10);
        }
        CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList2 = this.f2582R;
        if (copyOnWriteArrayList2 != null) {
            Iterator<InterfaceC0564j> it = copyOnWriteArrayList2.iterator();
            while (it.hasNext()) {
                it.next().mo3226a(this, this.f2596e, this.f2600g, this.f2614n);
            }
        }
        this.f2589a0 = true;
    }

    /* renamed from: P */
    public void m3309P() {
        int iIntValue;
        CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList;
        if ((this.f2628u != null || ((copyOnWriteArrayList = this.f2582R) != null && !copyOnWriteArrayList.isEmpty())) && this.f2586V == -1) {
            this.f2586V = this.f2598f;
            if (this.f2568D0.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.f2568D0;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i10 = this.f2598f;
            if (iIntValue != i10 && i10 != -1) {
                this.f2568D0.add(Integer.valueOf(i10));
            }
        }
        m3322c0();
        Runnable runnable = this.f2613m0;
        if (runnable != null) {
            runnable.run();
            this.f2613m0 = null;
        }
        int[] iArr = this.f2615n0;
        if (iArr == null || this.f2617o0 <= 0) {
            return;
        }
        m3332m0(iArr[0]);
        int[] iArr2 = this.f2615n0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f2617o0--;
    }

    /* renamed from: Q */
    public final void m3310Q() {
        InterfaceC0564j interfaceC0564j = this.f2628u;
        if (interfaceC0564j != null) {
            interfaceC0564j.mo3270b(this, this.f2596e, this.f2600g);
        }
        CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList = this.f2582R;
        if (copyOnWriteArrayList != null) {
            Iterator<InterfaceC0564j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().mo3270b(this, this.f2596e, this.f2600g);
            }
        }
    }

    /* renamed from: R */
    public void m3311R(int i10, boolean z10, float f10) {
        InterfaceC0564j interfaceC0564j = this.f2628u;
        if (interfaceC0564j != null) {
            interfaceC0564j.mo3271c(this, i10, z10, f10);
        }
        CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList = this.f2582R;
        if (copyOnWriteArrayList != null) {
            Iterator<InterfaceC0564j> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().mo3271c(this, i10, z10, f10);
            }
        }
    }

    /* renamed from: S */
    public void m3312S(int i10, float f10, float f11, float f12, float[] fArr) throws Resources.NotFoundException {
        String resourceName;
        HashMap<View, C12908m> map = this.f2608k;
        View viewById = getViewById(i10);
        C12908m c12908m = map.get(viewById);
        if (c12908m != null) {
            c12908m.m77502l(f10, f11, f12, fArr);
            float y10 = viewById.getY();
            this.f2630v = f10;
            this.f2632w = y10;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i10;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i10);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    /* renamed from: T */
    public C0585c m3313T(int i10) {
        C0566a c0566a = this.f2588a;
        if (c0566a == null) {
            return null;
        }
        return c0566a.m3417l(i10);
    }

    /* renamed from: U */
    public C12908m m3314U(int i10) {
        return this.f2608k.get(findViewById(i10));
    }

    /* renamed from: V */
    public C0566a.b m3315V(int i10) {
        return this.f2588a.m3389G(i10);
    }

    /* renamed from: W */
    public void m3316W(View view, float f10, float f11, float[] fArr, int i10) {
        float interpolation;
        float fMo3338a = this.f2594d;
        float f12 = this.f2616o;
        if (this.f2590b != null) {
            float fSignum = Math.signum(this.f2620q - f12);
            float interpolation2 = this.f2590b.getInterpolation(this.f2616o + 1.0E-5f);
            interpolation = this.f2590b.getInterpolation(this.f2616o);
            fMo3338a = (fSignum * ((interpolation2 - interpolation) / 1.0E-5f)) / this.f2612m;
        } else {
            interpolation = f12;
        }
        Interpolator interpolator = this.f2590b;
        if (interpolator instanceof AbstractInterpolatorC12909n) {
            fMo3338a = ((AbstractInterpolatorC12909n) interpolator).mo3338a();
        }
        C12908m c12908m = this.f2608k.get(view);
        if ((i10 & 1) == 0) {
            c12908m.m77507r(interpolation, view.getWidth(), view.getHeight(), f10, f11, fArr);
        } else {
            c12908m.m77502l(interpolation, f10, f11, fArr);
        }
        if (i10 < 2) {
            fArr[0] = fArr[0] * fMo3338a;
            fArr[1] = fArr[1] * fMo3338a;
        }
    }

    /* renamed from: X */
    public final boolean m3317X(float f10, float f11, View view, MotionEvent motionEvent) {
        boolean z10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (m3317X((r3.getLeft() + f10) - view.getScrollX(), (r3.getTop() + f11) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.f2562A0.set(f10, f11, (view.getRight() + f10) - view.getLeft(), (view.getBottom() + f11) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.f2562A0.contains(motionEvent.getX(), motionEvent.getY())) && m3300G(view, motionEvent, -f10, -f11)) {
                return true;
            }
        }
        return z10;
    }

    /* renamed from: Y */
    public final void m3318Y(AttributeSet attributeSet) {
        C0566a c0566a;
        f2560E0 = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.f2588a = new C0566a(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.f2598f = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.f2620q = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.f2624s = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z10 = typedArrayObtainStyledAttributes.getBoolean(index, z10);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.f2634x == 0) {
                        this.f2634x = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.f2634x = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.f2588a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.f2588a = null;
            }
        }
        if (this.f2634x != 0) {
            m3301H();
        }
        if (this.f2598f != -1 || (c0566a = this.f2588a) == null) {
            return;
        }
        this.f2598f = c0566a.m3388F();
        this.f2596e = this.f2588a.m3388F();
        this.f2600g = this.f2588a.m3422q();
    }

    /* renamed from: Z */
    public boolean m3319Z() {
        return this.f2606j;
    }

    /* renamed from: a0 */
    public InterfaceC0561g m3320a0() {
        return C0562h.m3367f();
    }

    /* renamed from: b0 */
    public void m3321b0() {
        C0566a c0566a = this.f2588a;
        if (c0566a == null) {
            return;
        }
        if (c0566a.m3413h(this, this.f2598f)) {
            requestLayout();
            return;
        }
        int i10 = this.f2598f;
        if (i10 != -1) {
            this.f2588a.m3411f(this, i10);
        }
        if (this.f2588a.m3409b0()) {
            this.f2588a.m3408Z();
        }
    }

    /* renamed from: c0 */
    public final void m3322c0() {
        CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList;
        if (this.f2628u == null && ((copyOnWriteArrayList = this.f2582R) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f2589a0 = false;
        Iterator<Integer> it = this.f2568D0.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            InterfaceC0564j interfaceC0564j = this.f2628u;
            if (interfaceC0564j != null) {
                interfaceC0564j.mo3227d(this, next.intValue());
            }
            CopyOnWriteArrayList<InterfaceC0564j> copyOnWriteArrayList2 = this.f2582R;
            if (copyOnWriteArrayList2 != null) {
                Iterator<InterfaceC0564j> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().mo3227d(this, next.intValue());
                }
            }
        }
        this.f2568D0.clear();
    }

    /* renamed from: d0 */
    public void m3323d0() {
        this.f2637y0.m3359h();
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        C0569d c0569d;
        ArrayList<MotionHelper> arrayList = this.f2581Q;
        if (arrayList != null) {
            Iterator<MotionHelper> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().m3268C(canvas);
            }
        }
        m3306M(false);
        C0566a c0566a = this.f2588a;
        if (c0566a != null && (c0569d = c0566a.f2709r) != null) {
            c0569d.m3518c();
        }
        super.dispatchDraw(canvas);
        if (this.f2588a == null) {
            return;
        }
        if ((this.f2634x & 1) == 1 && !isInEditMode()) {
            this.f2583S++;
            long nanoTime = getNanoTime();
            long j10 = this.f2584T;
            if (j10 != -1) {
                if (nanoTime - j10 > 200000000) {
                    this.f2585U = ((int) ((this.f2583S / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.f2583S = 0;
                    this.f2584T = nanoTime;
                }
            } else {
                this.f2584T = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.f2585U + " fps " + C12896a.m77319e(this, this.f2596e) + " -> ";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(C12896a.m77319e(this, this.f2600g));
            sb2.append(" (progress: ");
            sb2.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb2.append(" ) state=");
            int i10 = this.f2598f;
            sb2.append(i10 == -1 ? "undefined" : C12896a.m77319e(this, i10));
            String string = sb2.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.f2634x > 1) {
            if (this.f2636y == null) {
                this.f2636y = new C0559e();
            }
            this.f2636y.m3340a(canvas, this.f2608k, this.f2588a.m3421p(), this.f2634x);
        }
        ArrayList<MotionHelper> arrayList2 = this.f2581Q;
        if (arrayList2 != null) {
            Iterator<MotionHelper> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().m3267B(canvas);
            }
        }
    }

    /* renamed from: e0 */
    public void m3324e0(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.f2611l0 == null) {
                this.f2611l0 = new C0563i();
            }
            this.f2611l0.m3372e(f10);
            this.f2611l0.m3375h(f11);
            return;
        }
        setProgress(f10);
        setState(EnumC0565k.MOVING);
        this.f2594d = f11;
        if (f11 != 0.0f) {
            m3298E(f11 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f10 == 0.0f || f10 == 1.0f) {
                return;
            }
            m3298E(f10 > 0.5f ? 1.0f : 0.0f);
        }
    }

    /* renamed from: f0 */
    public void m3325f0(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f2611l0 == null) {
                this.f2611l0 = new C0563i();
            }
            this.f2611l0.m3373f(i10);
            this.f2611l0.m3371d(i11);
            return;
        }
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            this.f2596e = i10;
            this.f2600g = i11;
            c0566a.m3406X(i10, i11);
            this.f2637y0.m3356e(this.mLayoutWidget, this.f2588a.m3417l(i10), this.f2588a.m3417l(i11));
            m3323d0();
            this.f2616o = 0.0f;
            m3331l0();
        }
    }

    /* renamed from: g0 */
    public final void m3326g0() {
        int childCount = getChildCount();
        this.f2637y0.m3352a();
        this.f2624s = true;
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            sparseArray.put(childAt.getId(), this.f2608k.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iM3415j = this.f2588a.m3415j();
        if (iM3415j != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                C12908m c12908m = this.f2608k.get(getChildAt(i12));
                if (c12908m != null) {
                    c12908m.m77484D(iM3415j);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f2608k.size()];
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            C12908m c12908m2 = this.f2608k.get(getChildAt(i14));
            if (c12908m2.m77498h() != -1) {
                sparseBooleanArray.put(c12908m2.m77498h(), true);
                iArr[i13] = c12908m2.m77498h();
                i13++;
            }
        }
        if (this.f2581Q != null) {
            for (int i15 = 0; i15 < i13; i15++) {
                C12908m c12908m3 = this.f2608k.get(findViewById(iArr[i15]));
                if (c12908m3 != null) {
                    this.f2588a.m3425t(c12908m3);
                }
            }
            Iterator<MotionHelper> it = this.f2581Q.iterator();
            while (it.hasNext()) {
                it.next().mo3263D(this, this.f2608k);
            }
            for (int i16 = 0; i16 < i13; i16++) {
                C12908m c12908m4 = this.f2608k.get(findViewById(iArr[i16]));
                if (c12908m4 != null) {
                    c12908m4.m77489I(width, height, this.f2612m, getNanoTime());
                }
            }
        } else {
            for (int i17 = 0; i17 < i13; i17++) {
                C12908m c12908m5 = this.f2608k.get(findViewById(iArr[i17]));
                if (c12908m5 != null) {
                    this.f2588a.m3425t(c12908m5);
                    c12908m5.m77489I(width, height, this.f2612m, getNanoTime());
                }
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            C12908m c12908m6 = this.f2608k.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && c12908m6 != null) {
                this.f2588a.m3425t(c12908m6);
                c12908m6.m77489I(width, height, this.f2612m, getNanoTime());
            }
        }
        float fM3387E = this.f2588a.m3387E();
        if (fM3387E != 0.0f) {
            boolean z10 = ((double) fM3387E) < 0.0d;
            float fAbs = Math.abs(fM3387E);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            for (int i19 = 0; i19 < childCount; i19++) {
                C12908m c12908m7 = this.f2608k.get(getChildAt(i19));
                if (!Float.isNaN(c12908m7.f58844m)) {
                    for (int i20 = 0; i20 < childCount; i20++) {
                        C12908m c12908m8 = this.f2608k.get(getChildAt(i20));
                        if (!Float.isNaN(c12908m8.f58844m)) {
                            fMin = Math.min(fMin, c12908m8.f58844m);
                            fMax = Math.max(fMax, c12908m8.f58844m);
                        }
                    }
                    while (i10 < childCount) {
                        C12908m c12908m9 = this.f2608k.get(getChildAt(i10));
                        if (!Float.isNaN(c12908m9.f58844m)) {
                            c12908m9.f58846o = 1.0f / (1.0f - fAbs);
                            if (z10) {
                                c12908m9.f58845n = fAbs - (((fMax - c12908m9.f58844m) / (fMax - fMin)) * fAbs);
                            } else {
                                c12908m9.f58845n = fAbs - (((c12908m9.f58844m - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i10++;
                    }
                    return;
                }
                float fM77504n = c12908m7.m77504n();
                float fM77505o = c12908m7.m77505o();
                float f10 = z10 ? fM77505o - fM77504n : fM77505o + fM77504n;
                fMin2 = Math.min(fMin2, f10);
                fMax2 = Math.max(fMax2, f10);
            }
            while (i10 < childCount) {
                C12908m c12908m10 = this.f2608k.get(getChildAt(i10));
                float fM77504n2 = c12908m10.m77504n();
                float fM77505o2 = c12908m10.m77505o();
                float f11 = z10 ? fM77505o2 - fM77504n2 : fM77505o2 + fM77504n2;
                c12908m10.f58846o = 1.0f / (1.0f - fAbs);
                c12908m10.f58845n = fAbs - (((f11 - fMin2) * fAbs) / (fMax2 - fMin2));
                i10++;
            }
        }
    }

    public int[] getConstraintSetIds() {
        C0566a c0566a = this.f2588a;
        if (c0566a == null) {
            return null;
        }
        return c0566a.m3419n();
    }

    public int getCurrentState() {
        return this.f2598f;
    }

    public ArrayList<C0566a.b> getDefinedTransitions() {
        C0566a c0566a = this.f2588a;
        if (c0566a == null) {
            return null;
        }
        return c0566a.m3420o();
    }

    public C12897b getDesignTool() {
        if (this.f2565C == null) {
            this.f2565C = new C12897b(this);
        }
        return this.f2565C;
    }

    public int getEndState() {
        return this.f2600g;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f2616o;
    }

    public C0566a getScene() {
        return this.f2588a;
    }

    public int getStartState() {
        return this.f2596e;
    }

    public float getTargetPosition() {
        return this.f2620q;
    }

    public Bundle getTransitionState() {
        if (this.f2611l0 == null) {
            this.f2611l0 = new C0563i();
        }
        this.f2611l0.m3370c();
        return this.f2611l0.m3369b();
    }

    public long getTransitionTimeMs() {
        if (this.f2588a != null) {
            this.f2612m = r0.m3421p() / 1000.0f;
        }
        return (long) (this.f2612m * 1000.0f);
    }

    public float getVelocity() {
        return this.f2594d;
    }

    /* renamed from: h0 */
    public final Rect m3327h0(C12258e c12258e) {
        this.f2631v0.top = c12258e.m73598a0();
        this.f2631v0.left = c12258e.m73596Z();
        Rect rect = this.f2631v0;
        int iM73594Y = c12258e.m73594Y();
        Rect rect2 = this.f2631v0;
        rect.right = iM73594Y + rect2.left;
        int iM73662z = c12258e.m73662z();
        Rect rect3 = this.f2631v0;
        rect2.bottom = iM73662z + rect3.top;
        return rect3;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0093  */
    /* renamed from: i0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3328i0(int r10, float r11, float r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.m3328i0(int, float, float):void");
    }

    @Override // p273f0.InterfaceC9638z
    /* renamed from: j */
    public void mo2545j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (this.f2573I || i10 != 0 || i11 != 0) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.f2573I = false;
    }

    /* renamed from: j0 */
    public void m3329j0() {
        m3298E(1.0f);
        this.f2613m0 = null;
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: k */
    public void mo2546k(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    /* renamed from: k0 */
    public void m3330k0(Runnable runnable) {
        m3298E(1.0f);
        this.f2613m0 = runnable;
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: l */
    public boolean mo2547l(View view, View view2, int i10, int i11) {
        C0566a.b bVar;
        C0566a c0566a = this.f2588a;
        return (c0566a == null || (bVar = c0566a.f2694c) == null || bVar.m3452B() == null || (this.f2588a.f2694c.m3452B().m3474e() & 2) != 0) ? false : true;
    }

    /* renamed from: l0 */
    public void m3331l0() {
        m3298E(0.0f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i10) {
        C0566a.b bVar;
        if (i10 == 0) {
            this.f2588a = null;
            return;
        }
        try {
            C0566a c0566a = new C0566a(getContext(), this, i10);
            this.f2588a = c0566a;
            if (this.f2598f == -1) {
                this.f2598f = c0566a.m3388F();
                this.f2596e = this.f2588a.m3388F();
                this.f2600g = this.f2588a.m3422q();
            }
            if (!isAttachedToWindow()) {
                this.f2588a = null;
                return;
            }
            try {
                Display display = getDisplay();
                this.f2629u0 = display == null ? 0 : display.getRotation();
                C0566a c0566a2 = this.f2588a;
                if (c0566a2 != null) {
                    C0585c c0585cM3417l = c0566a2.m3417l(this.f2598f);
                    this.f2588a.m3402T(this);
                    ArrayList<MotionHelper> arrayList = this.f2581Q;
                    if (arrayList != null) {
                        Iterator<MotionHelper> it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().m3266A(this);
                        }
                    }
                    if (c0585cM3417l != null) {
                        c0585cM3417l.m3631i(this);
                    }
                    this.f2596e = this.f2598f;
                }
                m3321b0();
                C0563i c0563i = this.f2611l0;
                if (c0563i != null) {
                    if (this.f2633w0) {
                        post(new RunnableC0555a());
                        return;
                    } else {
                        c0563i.m3368a();
                        return;
                    }
                }
                C0566a c0566a3 = this.f2588a;
                if (c0566a3 == null || (bVar = c0566a3.f2694c) == null || bVar.m3463x() != 4) {
                    return;
                }
                m3329j0();
                setState(EnumC0565k.SETUP);
                setState(EnumC0565k.MOVING);
            } catch (Exception e10) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e10);
            }
        } catch (Exception e11) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e11);
        }
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: m */
    public void mo2548m(View view, View view2, int i10, int i11) {
        this.f2576L = getNanoTime();
        this.f2577M = 0.0f;
        this.f2574J = 0.0f;
        this.f2575K = 0.0f;
    }

    /* renamed from: m0 */
    public void m3332m0(int i10) {
        if (isAttachedToWindow()) {
            m3333n0(i10, -1, -1);
            return;
        }
        if (this.f2611l0 == null) {
            this.f2611l0 = new C0563i();
        }
        this.f2611l0.m3371d(i10);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: n */
    public void mo2549n(View view, int i10) {
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            float f10 = this.f2577M;
            if (f10 == 0.0f) {
                return;
            }
            c0566a.m3399Q(this.f2574J / f10, this.f2575K / f10);
        }
    }

    /* renamed from: n0 */
    public void m3333n0(int i10, int i11, int i12) {
        m3334o0(i10, i11, i12, -1);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: o */
    public void mo2550o(View view, int i10, int i11, int[] iArr, int i12) {
        C0566a.b bVar;
        C0567b c0567bM3452B;
        int iM3486q;
        C0566a c0566a = this.f2588a;
        if (c0566a == null || (bVar = c0566a.f2694c) == null || !bVar.m3453C()) {
            return;
        }
        int i13 = -1;
        if (!bVar.m3453C() || (c0567bM3452B = bVar.m3452B()) == null || (iM3486q = c0567bM3452B.m3486q()) == -1 || view.getId() == iM3486q) {
            if (c0566a.m3428w()) {
                C0567b c0567bM3452B2 = bVar.m3452B();
                if (c0567bM3452B2 != null && (c0567bM3452B2.m3474e() & 4) != 0) {
                    i13 = i11;
                }
                float f10 = this.f2614n;
                if ((f10 == 1.0f || f10 == 0.0f) && view.canScrollVertically(i13)) {
                    return;
                }
            }
            if (bVar.m3452B() != null && (bVar.m3452B().m3474e() & 1) != 0) {
                float fM3429x = c0566a.m3429x(i10, i11);
                float f11 = this.f2616o;
                if ((f11 <= 0.0f && fM3429x < 0.0f) || (f11 >= 1.0f && fM3429x > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new RunnableC0556b(view));
                    return;
                }
            }
            float f12 = this.f2614n;
            long nanoTime = getNanoTime();
            float f13 = i10;
            this.f2574J = f13;
            float f14 = i11;
            this.f2575K = f14;
            this.f2577M = (float) ((nanoTime - this.f2576L) * 1.0E-9d);
            this.f2576L = nanoTime;
            c0566a.m3398P(f13, f14);
            if (f12 != this.f2614n) {
                iArr[0] = i10;
                iArr[1] = i11;
            }
            m3306M(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f2573I = true;
        }
    }

    /* renamed from: o0 */
    public void m3334o0(int i10, int i11, int i12, int i13) {
        C0588f c0588f;
        int iM3672a;
        C0566a c0566a = this.f2588a;
        if (c0566a != null && (c0588f = c0566a.f2693b) != null && (iM3672a = c0588f.m3672a(this.f2598f, i10, i11, i12)) != -1) {
            i10 = iM3672a;
        }
        int i14 = this.f2598f;
        if (i14 == i10) {
            return;
        }
        if (this.f2596e == i10) {
            m3298E(0.0f);
            if (i13 > 0) {
                this.f2612m = i13 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f2600g == i10) {
            m3298E(1.0f);
            if (i13 > 0) {
                this.f2612m = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.f2600g = i10;
        if (i14 != -1) {
            m3325f0(i14, i10);
            m3298E(1.0f);
            this.f2616o = 0.0f;
            m3329j0();
            if (i13 > 0) {
                this.f2612m = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.f2638z = false;
        this.f2620q = 1.0f;
        this.f2614n = 0.0f;
        this.f2616o = 0.0f;
        this.f2618p = getNanoTime();
        this.f2610l = getNanoTime();
        this.f2622r = false;
        this.f2590b = null;
        if (i13 == -1) {
            this.f2612m = this.f2588a.m3421p() / 1000.0f;
        }
        this.f2596e = -1;
        this.f2588a.m3406X(-1, this.f2600g);
        SparseArray sparseArray = new SparseArray();
        if (i13 == 0) {
            this.f2612m = this.f2588a.m3421p() / 1000.0f;
        } else if (i13 > 0) {
            this.f2612m = i13 / 1000.0f;
        }
        int childCount = getChildCount();
        this.f2608k.clear();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            this.f2608k.put(childAt, new C12908m(childAt));
            sparseArray.put(childAt.getId(), this.f2608k.get(childAt));
        }
        this.f2624s = true;
        this.f2637y0.m3356e(this.mLayoutWidget, null, this.f2588a.m3417l(i10));
        m3323d0();
        this.f2637y0.m3352a();
        m3304K();
        int width = getWidth();
        int height = getHeight();
        if (this.f2581Q != null) {
            for (int i16 = 0; i16 < childCount; i16++) {
                C12908m c12908m = this.f2608k.get(getChildAt(i16));
                if (c12908m != null) {
                    this.f2588a.m3425t(c12908m);
                }
            }
            Iterator<MotionHelper> it = this.f2581Q.iterator();
            while (it.hasNext()) {
                it.next().mo3263D(this, this.f2608k);
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                C12908m c12908m2 = this.f2608k.get(getChildAt(i17));
                if (c12908m2 != null) {
                    c12908m2.m77489I(width, height, this.f2612m, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < childCount; i18++) {
                C12908m c12908m3 = this.f2608k.get(getChildAt(i18));
                if (c12908m3 != null) {
                    this.f2588a.m3425t(c12908m3);
                    c12908m3.m77489I(width, height, this.f2612m, getNanoTime());
                }
            }
        }
        float fM3387E = this.f2588a.m3387E();
        if (fM3387E != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i19 = 0; i19 < childCount; i19++) {
                C12908m c12908m4 = this.f2608k.get(getChildAt(i19));
                float fM77505o = c12908m4.m77505o() + c12908m4.m77504n();
                fMin = Math.min(fMin, fM77505o);
                fMax = Math.max(fMax, fM77505o);
            }
            for (int i20 = 0; i20 < childCount; i20++) {
                C12908m c12908m5 = this.f2608k.get(getChildAt(i20));
                float fM77504n = c12908m5.m77504n();
                float fM77505o2 = c12908m5.m77505o();
                c12908m5.f58846o = 1.0f / (1.0f - fM3387E);
                c12908m5.f58845n = fM3387E - ((((fM77504n + fM77505o2) - fMin) * fM3387E) / (fMax - fMin));
            }
        }
        this.f2614n = 0.0f;
        this.f2616o = 0.0f;
        this.f2624s = true;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        C0566a.b bVar;
        int i10;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f2629u0 = display.getRotation();
        }
        C0566a c0566a = this.f2588a;
        if (c0566a != null && (i10 = this.f2598f) != -1) {
            C0585c c0585cM3417l = c0566a.m3417l(i10);
            this.f2588a.m3402T(this);
            ArrayList<MotionHelper> arrayList = this.f2581Q;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().m3266A(this);
                }
            }
            if (c0585cM3417l != null) {
                c0585cM3417l.m3631i(this);
            }
            this.f2596e = this.f2598f;
        }
        m3321b0();
        C0563i c0563i = this.f2611l0;
        if (c0563i != null) {
            if (this.f2633w0) {
                post(new RunnableC0557c());
                return;
            } else {
                c0563i.m3368a();
                return;
            }
        }
        C0566a c0566a2 = this.f2588a;
        if (c0566a2 == null || (bVar = c0566a2.f2694c) == null || bVar.m3463x() != 4) {
            return;
        }
        m3329j0();
        setState(EnumC0565k.SETUP);
        setState(EnumC0565k.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C0567b c0567bM3452B;
        int iM3486q;
        RectF rectFM3485p;
        C0566a c0566a = this.f2588a;
        if (c0566a != null && this.f2606j) {
            C0569d c0569d = c0566a.f2709r;
            if (c0569d != null) {
                c0569d.m3523h(motionEvent);
            }
            C0566a.b bVar = this.f2588a.f2694c;
            if (bVar != null && bVar.m3453C() && (c0567bM3452B = bVar.m3452B()) != null && ((motionEvent.getAction() != 0 || (rectFM3485p = c0567bM3452B.m3485p(this, new RectF())) == null || rectFM3485p.contains(motionEvent.getX(), motionEvent.getY())) && (iM3486q = c0567bM3452B.m3486q()) != -1)) {
                View view = this.f2564B0;
                if (view == null || view.getId() != iM3486q) {
                    this.f2564B0 = findViewById(iM3486q);
                }
                if (this.f2564B0 != null) {
                    this.f2562A0.set(r0.getLeft(), this.f2564B0.getTop(), this.f2564B0.getRight(), this.f2564B0.getBottom());
                    if (this.f2562A0.contains(motionEvent.getX(), motionEvent.getY()) && !m3317X(this.f2564B0.getLeft(), this.f2564B0.getTop(), this.f2564B0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f2609k0 = true;
        try {
            if (this.f2588a == null) {
                super.onLayout(z10, i10, i11, i12, i13);
                return;
            }
            int i14 = i12 - i10;
            int i15 = i13 - i11;
            if (this.f2571G != i14 || this.f2572H != i15) {
                m3323d0();
                m3306M(true);
            }
            this.f2571G = i14;
            this.f2572H = i15;
            this.f2569E = i14;
            this.f2570F = i15;
        } finally {
            this.f2609k0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f2588a == null) {
            super.onMeasure(i10, i11);
            return;
        }
        boolean z10 = false;
        boolean z11 = (this.f2602h == i10 && this.f2604i == i11) ? false : true;
        if (this.f2639z0) {
            this.f2639z0 = false;
            m3321b0();
            m3322c0();
            z11 = true;
        }
        if (this.mDirtyHierarchy) {
            z11 = true;
        }
        this.f2602h = i10;
        this.f2604i = i11;
        int iM3388F = this.f2588a.m3388F();
        int iM3422q = this.f2588a.m3422q();
        if ((z11 || this.f2637y0.m3357f(iM3388F, iM3422q)) && this.f2596e != -1) {
            super.onMeasure(i10, i11);
            this.f2637y0.m3356e(this.mLayoutWidget, this.f2588a.m3417l(iM3388F), this.f2588a.m3417l(iM3422q));
            this.f2637y0.m3359h();
            this.f2637y0.m3360i(iM3388F, iM3422q);
        } else {
            if (z11) {
                super.onMeasure(i10, i11);
            }
            z10 = true;
        }
        if (this.f2591b0 || z10) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iM73594Y = this.mLayoutWidget.m73594Y() + getPaddingLeft() + getPaddingRight();
            int iM73662z = this.mLayoutWidget.m73662z() + paddingTop;
            int i12 = this.f2601g0;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                iM73594Y = (int) (this.f2593c0 + (this.f2605i0 * (this.f2597e0 - r8)));
                requestLayout();
            }
            int i13 = this.f2603h0;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                iM73662z = (int) (this.f2595d0 + (this.f2605i0 * (this.f2599f0 - r8)));
                requestLayout();
            }
            setMeasuredDimension(iM73594Y, iM73662z);
        }
        m3307N();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            c0566a.m3405W(isRtl());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0566a c0566a = this.f2588a;
        if (c0566a == null || !this.f2606j || !c0566a.m3409b0()) {
            return super.onTouchEvent(motionEvent);
        }
        C0566a.b bVar = this.f2588a.f2694c;
        if (bVar != null && !bVar.m3453C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f2588a.m3400R(motionEvent, getCurrentState(), this);
        if (this.f2588a.f2694c.m3454D(4)) {
            return this.f2588a.f2694c.m3452B().m3487r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f2582R == null) {
                this.f2582R = new CopyOnWriteArrayList<>();
            }
            this.f2582R.add(motionHelper);
            if (motionHelper.m3273z()) {
                if (this.f2579O == null) {
                    this.f2579O = new ArrayList<>();
                }
                this.f2579O.add(motionHelper);
            }
            if (motionHelper.m3272y()) {
                if (this.f2580P == null) {
                    this.f2580P = new ArrayList<>();
                }
                this.f2580P.add(motionHelper);
            }
            if (motionHelper.mo3264x()) {
                if (this.f2581Q == null) {
                    this.f2581Q = new ArrayList<>();
                }
                this.f2581Q.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f2579O;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f2580P;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    /* renamed from: p0 */
    public void m3335p0() {
        this.f2637y0.m3356e(this.mLayoutWidget, this.f2588a.m3417l(this.f2596e), this.f2588a.m3417l(this.f2600g));
        m3323d0();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = null;
    }

    /* renamed from: q0 */
    public void m3336q0(int i10, C0585c c0585c) {
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            c0566a.m3403U(i10, c0585c);
        }
        m3335p0();
        if (this.f2598f == i10) {
            c0585c.m3631i(this);
        }
    }

    /* renamed from: r0 */
    public void m3337r0(int i10, View... viewArr) {
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            c0566a.m3410c0(i10, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        C0566a c0566a;
        C0566a.b bVar;
        if (!this.f2591b0 && this.f2598f == -1 && (c0566a = this.f2588a) != null && (bVar = c0566a.f2694c) != null) {
            int iM3465z = bVar.m3465z();
            if (iM3465z == 0) {
                return;
            }
            if (iM3465z == 2) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    this.f2608k.get(getChildAt(i10)).m77515z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void setDebugMode(int i10) {
        this.f2634x = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f2633w0 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.f2606j = z10;
    }

    public void setInterpolatedProgress(float f10) {
        if (this.f2588a != null) {
            setState(EnumC0565k.MOVING);
            Interpolator interpolatorM3424s = this.f2588a.m3424s();
            if (interpolatorM3424s != null) {
                setProgress(interpolatorM3424s.getInterpolation(f10));
                return;
            }
        }
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<MotionHelper> arrayList = this.f2580P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f2580P.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<MotionHelper> arrayList = this.f2579O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f2579O.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f2611l0 == null) {
                this.f2611l0 = new C0563i();
            }
            this.f2611l0.m3372e(f10);
            return;
        }
        if (f10 <= 0.0f) {
            if (this.f2616o == 1.0f && this.f2598f == this.f2600g) {
                setState(EnumC0565k.MOVING);
            }
            this.f2598f = this.f2596e;
            if (this.f2616o == 0.0f) {
                setState(EnumC0565k.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            if (this.f2616o == 0.0f && this.f2598f == this.f2596e) {
                setState(EnumC0565k.MOVING);
            }
            this.f2598f = this.f2600g;
            if (this.f2616o == 1.0f) {
                setState(EnumC0565k.FINISHED);
            }
        } else {
            this.f2598f = -1;
            setState(EnumC0565k.MOVING);
        }
        if (this.f2588a == null) {
            return;
        }
        this.f2622r = true;
        this.f2620q = f10;
        this.f2614n = f10;
        this.f2618p = -1L;
        this.f2610l = -1L;
        this.f2590b = null;
        this.f2624s = true;
        invalidate();
    }

    public void setScene(C0566a c0566a) {
        this.f2588a = c0566a;
        c0566a.m3405W(isRtl());
        m3323d0();
    }

    public void setStartState(int i10) {
        if (isAttachedToWindow()) {
            this.f2598f = i10;
            return;
        }
        if (this.f2611l0 == null) {
            this.f2611l0 = new C0563i();
        }
        this.f2611l0.m3373f(i10);
        this.f2611l0.m3371d(i10);
    }

    public void setState(EnumC0565k enumC0565k) {
        EnumC0565k enumC0565k2 = EnumC0565k.FINISHED;
        if (enumC0565k == enumC0565k2 && this.f2598f == -1) {
            return;
        }
        EnumC0565k enumC0565k3 = this.f2635x0;
        this.f2635x0 = enumC0565k;
        EnumC0565k enumC0565k4 = EnumC0565k.MOVING;
        if (enumC0565k3 == enumC0565k4 && enumC0565k == enumC0565k4) {
            m3308O();
        }
        int iOrdinal = enumC0565k3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && enumC0565k == enumC0565k2) {
                m3309P();
                return;
            }
            return;
        }
        if (enumC0565k == enumC0565k4) {
            m3308O();
        }
        if (enumC0565k == enumC0565k2) {
            m3309P();
        }
    }

    public void setTransition(int i10) {
        if (this.f2588a != null) {
            C0566a.b bVarM3315V = m3315V(i10);
            this.f2596e = bVarM3315V.m3451A();
            this.f2600g = bVarM3315V.m3464y();
            if (!isAttachedToWindow()) {
                if (this.f2611l0 == null) {
                    this.f2611l0 = new C0563i();
                }
                this.f2611l0.m3373f(this.f2596e);
                this.f2611l0.m3371d(this.f2600g);
                return;
            }
            int i11 = this.f2598f;
            float f10 = i11 == this.f2596e ? 0.0f : i11 == this.f2600g ? 1.0f : Float.NaN;
            this.f2588a.m3407Y(bVarM3315V);
            this.f2637y0.m3356e(this.mLayoutWidget, this.f2588a.m3417l(this.f2596e), this.f2588a.m3417l(this.f2600g));
            m3323d0();
            if (this.f2616o != f10) {
                if (f10 == 0.0f) {
                    m3305L(true);
                    this.f2588a.m3417l(this.f2596e).m3631i(this);
                } else if (f10 == 1.0f) {
                    m3305L(false);
                    this.f2588a.m3417l(this.f2600g).m3631i(this);
                }
            }
            this.f2616o = Float.isNaN(f10) ? 0.0f : f10;
            if (!Float.isNaN(f10)) {
                setProgress(f10);
                return;
            }
            Log.v("MotionLayout", C12896a.m77316b() + " transitionToStart ");
            m3331l0();
        }
    }

    public void setTransitionDuration(int i10) {
        C0566a c0566a = this.f2588a;
        if (c0566a == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            c0566a.m3404V(i10);
        }
    }

    public void setTransitionListener(InterfaceC0564j interfaceC0564j) {
        this.f2628u = interfaceC0564j;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f2611l0 == null) {
            this.f2611l0 = new C0563i();
        }
        this.f2611l0.m3374g(bundle);
        if (isAttachedToWindow()) {
            this.f2611l0.m3368a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return C12896a.m77317c(context, this.f2596e) + "->" + C12896a.m77317c(context, this.f2600g) + " (pos:" + this.f2616o + " Dpos/Dt:" + this.f2594d;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i10, int i11, int i12) {
        setState(EnumC0565k.SETUP);
        this.f2598f = i10;
        this.f2596e = -1;
        this.f2600g = -1;
        C0584b c0584b = this.mConstraintLayoutSpec;
        if (c0584b != null) {
            c0584b.m3598d(i10, i11, i12);
            return;
        }
        C0566a c0566a = this.f2588a;
        if (c0566a != null) {
            c0566a.m3417l(i10).m3631i(this);
        }
    }

    public void setTransition(C0566a.b bVar) {
        this.f2588a.m3407Y(bVar);
        setState(EnumC0565k.SETUP);
        if (this.f2598f == this.f2588a.m3422q()) {
            this.f2616o = 1.0f;
            this.f2614n = 1.0f;
            this.f2620q = 1.0f;
        } else {
            this.f2616o = 0.0f;
            this.f2614n = 0.0f;
            this.f2620q = 0.0f;
        }
        this.f2618p = bVar.m3454D(1) ? -1L : getNanoTime();
        int iM3388F = this.f2588a.m3388F();
        int iM3422q = this.f2588a.m3422q();
        if (iM3388F == this.f2596e && iM3422q == this.f2600g) {
            return;
        }
        this.f2596e = iM3388F;
        this.f2600g = iM3422q;
        this.f2588a.m3406X(iM3388F, iM3422q);
        this.f2637y0.m3356e(this.mLayoutWidget, this.f2588a.m3417l(this.f2596e), this.f2588a.m3417l(this.f2600g));
        this.f2637y0.m3360i(this.f2596e, this.f2600g);
        this.f2637y0.m3359h();
        m3323d0();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2592c = null;
        this.f2594d = 0.0f;
        this.f2596e = -1;
        this.f2598f = -1;
        this.f2600g = -1;
        this.f2602h = 0;
        this.f2604i = 0;
        this.f2606j = true;
        this.f2608k = new HashMap<>();
        this.f2610l = 0L;
        this.f2612m = 1.0f;
        this.f2614n = 0.0f;
        this.f2616o = 0.0f;
        this.f2620q = 0.0f;
        this.f2624s = false;
        this.f2626t = false;
        this.f2634x = 0;
        this.f2638z = false;
        this.f2561A = new C12655b();
        this.f2563B = new C0558d();
        this.f2567D = true;
        this.f2573I = false;
        this.f2578N = false;
        this.f2579O = null;
        this.f2580P = null;
        this.f2581Q = null;
        this.f2582R = null;
        this.f2583S = 0;
        this.f2584T = -1L;
        this.f2585U = 0.0f;
        this.f2586V = 0;
        this.f2587W = 0.0f;
        this.f2589a0 = false;
        this.f2591b0 = false;
        this.f2607j0 = new C11771d();
        this.f2609k0 = false;
        this.f2613m0 = null;
        this.f2615n0 = null;
        this.f2617o0 = 0;
        this.f2619p0 = false;
        this.f2621q0 = 0;
        this.f2623r0 = new HashMap<>();
        this.f2631v0 = new Rect();
        this.f2633w0 = false;
        this.f2635x0 = EnumC0565k.UNDEFINED;
        this.f2637y0 = new C0560f();
        this.f2639z0 = false;
        this.f2562A0 = new RectF();
        this.f2564B0 = null;
        this.f2566C0 = null;
        this.f2568D0 = new ArrayList<>();
        m3318Y(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2592c = null;
        this.f2594d = 0.0f;
        this.f2596e = -1;
        this.f2598f = -1;
        this.f2600g = -1;
        this.f2602h = 0;
        this.f2604i = 0;
        this.f2606j = true;
        this.f2608k = new HashMap<>();
        this.f2610l = 0L;
        this.f2612m = 1.0f;
        this.f2614n = 0.0f;
        this.f2616o = 0.0f;
        this.f2620q = 0.0f;
        this.f2624s = false;
        this.f2626t = false;
        this.f2634x = 0;
        this.f2638z = false;
        this.f2561A = new C12655b();
        this.f2563B = new C0558d();
        this.f2567D = true;
        this.f2573I = false;
        this.f2578N = false;
        this.f2579O = null;
        this.f2580P = null;
        this.f2581Q = null;
        this.f2582R = null;
        this.f2583S = 0;
        this.f2584T = -1L;
        this.f2585U = 0.0f;
        this.f2586V = 0;
        this.f2587W = 0.0f;
        this.f2589a0 = false;
        this.f2591b0 = false;
        this.f2607j0 = new C11771d();
        this.f2609k0 = false;
        this.f2613m0 = null;
        this.f2615n0 = null;
        this.f2617o0 = 0;
        this.f2619p0 = false;
        this.f2621q0 = 0;
        this.f2623r0 = new HashMap<>();
        this.f2631v0 = new Rect();
        this.f2633w0 = false;
        this.f2635x0 = EnumC0565k.UNDEFINED;
        this.f2637y0 = new C0560f();
        this.f2639z0 = false;
        this.f2562A0 = new RectF();
        this.f2564B0 = null;
        this.f2566C0 = null;
        this.f2568D0 = new ArrayList<>();
        m3318Y(attributeSet);
    }
}
