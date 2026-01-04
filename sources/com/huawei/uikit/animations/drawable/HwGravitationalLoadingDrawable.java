package com.huawei.uikit.animations.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import com.huawei.uikit.hwanimations.C8701R;
import p322h0.C10076a;
import p723w.C13503b;

/* loaded from: classes6.dex */
public class HwGravitationalLoadingDrawable extends Drawable implements Animatable {

    /* renamed from: A */
    private static final float f40785A = 0.82f;

    /* renamed from: B */
    private static final float f40786B = 17.0f;

    /* renamed from: C */
    private static final float f40787C = 23.3f;

    /* renamed from: D */
    private static final int f40788D = 300;
    public static final int DEFAULT_SIZE_DIP = 40;

    /* renamed from: E */
    private static final int f40789E = 255;

    /* renamed from: F */
    private static final float f40790F = 1.0f;

    /* renamed from: G */
    private static final int f40791G = 2;

    /* renamed from: H */
    private static final int f40792H = 2;
    public static final int ROTATION_DURATION = 1200;

    /* renamed from: k */
    private static final String f40793k = "HwLoadingAnim";

    /* renamed from: l */
    static final String f40794l = "scale";

    /* renamed from: m */
    static final String f40795m = "alpha";

    /* renamed from: n */
    static final String f40796n = "degrees";

    /* renamed from: o */
    static final String f40797o = "offset";

    /* renamed from: p */
    static final int f40798p = 60;

    /* renamed from: q */
    static final float f40799q = 35.0f;

    /* renamed from: r */
    private static final float f40800r = 10.5f;

    /* renamed from: s */
    private static final float f40801s = 1.9f;

    /* renamed from: t */
    private static final int f40802t = 200;

    /* renamed from: u */
    private static final float f40803u = 0.2f;

    /* renamed from: v */
    private static final float f40804v = 3.0f;

    /* renamed from: w */
    private static final float f40805w = 2.0f;

    /* renamed from: x */
    private static final int f40806x = 135;

    /* renamed from: y */
    private static final float f40807y = 3.0f;

    /* renamed from: z */
    private static final int f40808z = 20;

    /* renamed from: a */
    awsks f40809a;

    /* renamed from: b */
    brnby f40810b;

    /* renamed from: c */
    private final anbq f40811c;

    /* renamed from: d */
    private final anbq f40812d;

    /* renamed from: e */
    private final anbq f40813e;

    /* renamed from: f */
    private final anbq f40814f;

    /* renamed from: g */
    private Animator f40815g;

    /* renamed from: h */
    private Animator f40816h;

    /* renamed from: i */
    private boolean f40817i = false;

    /* renamed from: j */
    private float f40818j = 0.0f;

    public static class ParamsBundle {

        /* renamed from: a */
        private final boolean f40819a;

        /* renamed from: b */
        private final bwuqo f40820b;

        /* renamed from: c */
        private final bxac f40821c;

        /* renamed from: d */
        private final bfscp f40822d;

        /* renamed from: e */
        private final akxao f40823e;

        public ParamsBundle(bwuqo bwuqoVar, bxac bxacVar, bfscp bfscpVar, boolean z10) {
            this(bwuqoVar, bxacVar, bfscpVar, null, z10);
        }

        public static ParamsBundle parse(Context context, AttributeSet attributeSet, int i10, int i11) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8701R.styleable.HwGravitationalLoadingAnimation, i10, i11);
            bwuqo bwuqoVarM53736b = bwuqo.m53736b(context, typedArrayObtainStyledAttributes);
            bxac bxacVarM53745b = bxac.m53745b(context, typedArrayObtainStyledAttributes);
            bfscp bfscpVarM53698b = bfscp.m53698b(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
            return new ParamsBundle(bwuqoVarM53736b, bxacVarM53745b, bfscpVarM53698b, false);
        }

        public static ParamsBundle parseForNightMode(Context context, AttributeSet attributeSet, int i10, int i11) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8701R.styleable.HwGravitationalLoadingAnimation, i10, i11);
            bwuqo bwuqoVarM53736b = bwuqo.m53736b(context, typedArrayObtainStyledAttributes);
            akxao akxaoVarM53676b = akxao.m53676b(context, typedArrayObtainStyledAttributes);
            bxac bxacVarM53745b = bxac.m53745b(context, typedArrayObtainStyledAttributes);
            bfscp bfscpVarM53698b = bfscp.m53698b(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
            return new ParamsBundle(bwuqoVarM53736b, bxacVarM53745b, bfscpVarM53698b, akxaoVarM53676b, true);
        }

        public ParamsBundle(bwuqo bwuqoVar, bxac bxacVar, bfscp bfscpVar, akxao akxaoVar, boolean z10) {
            this.f40820b = bwuqoVar;
            this.f40821c = bxacVar;
            this.f40822d = bfscpVar;
            this.f40819a = z10;
            this.f40823e = akxaoVar;
        }
    }

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {
        public aauaf() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwGravitationalLoadingDrawable.f40793k, "onAnimationUpdate: null animator");
                return;
            }
            HwGravitationalLoadingDrawable.this.f40810b.m53711a(((Float) valueAnimator.getAnimatedValue(HwGravitationalLoadingDrawable.f40796n)).floatValue(), ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue(), ((Float) valueAnimator.getAnimatedValue(HwGravitationalLoadingDrawable.f40794l)).floatValue());
            HwGravitationalLoadingDrawable.this.invalidateSelf();
        }
    }

    public static class aayti {

        /* renamed from: a */
        private static final int f40825a = 0;

        /* renamed from: b */
        private static final int f40826b = 1;

        /* renamed from: c */
        private static final int f40827c = 2;

        /* renamed from: d */
        private static final float[] f40828d = {16.0f, 40.0f, 76.0f};

        /* renamed from: e */
        private static final float[] f40829e = {2.8f, HwGravitationalLoadingDrawable.f40801s, 1.2f};

        /* renamed from: f */
        private static final float[] f40830f = {0.5f, 0.2f, 0.1f};

        /* renamed from: g */
        private static final float[] f40831g = {3.0f, 3.0f, 2.0f};

        /* renamed from: h */
        private static final float[] f40832h = {3.0f, 3.0f, 2.2f};

        /* renamed from: a */
        public static anbq m53654a(float f10) {
            return m53655a(f40831g, f10);
        }

        /* renamed from: b */
        public static anbq m53657b(float f10) {
            return m53655a(f40832h, f10);
        }

        /* renamed from: c */
        public static anbq m53659c(float f10) {
            return m53655a(f40830f, f10);
        }

        /* renamed from: d */
        public static anbq m53660d(float f10) {
            return m53655a(f40829e, f10);
        }

        /* renamed from: a */
        public static anbq m53655a(float[] fArr, float f10) {
            return new anbq(m53652a(m53658c(fArr), f10), m53652a(m53656b(fArr), f10), m53652a(m53653a(fArr), f10));
        }

        /* renamed from: b */
        private static PointF m53656b(float[] fArr) {
            return m53651a(1, fArr);
        }

        /* renamed from: c */
        private static PointF m53658c(float[] fArr) {
            return m53651a(0, fArr);
        }

        /* renamed from: a */
        private static PointF m53653a(float[] fArr) {
            return m53651a(2, fArr);
        }

        /* renamed from: a */
        private static PointF m53651a(int i10, float[] fArr) {
            if (i10 >= 0) {
                float[] fArr2 = f40828d;
                if (i10 < fArr2.length && i10 < fArr.length) {
                    return new PointF(fArr2[i10], fArr[i10]);
                }
            }
            return new PointF();
        }

        /* renamed from: a */
        private static PointF m53652a(PointF pointF, float f10) {
            pointF.x *= f10;
            pointF.y *= f10;
            return pointF;
        }
    }

    public static abstract class aijfr {

        /* renamed from: a */
        final Camera f40833a;

        /* renamed from: b */
        private final Matrix f40834b;

        public class bzrwd extends aijfr {
            public bzrwd(float f10) {
                super(f10, null);
            }

            @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable.aijfr
            /* renamed from: b */
            public void mo53667b(float f10) {
                this.f40833a.rotateY(f10);
            }
        }

        public /* synthetic */ aijfr(float f10, bzrwd bzrwdVar) {
            this(f10);
        }

        /* renamed from: a */
        public PointF m53665a(PointF pointF, float f10) {
            PointF pointF2 = new PointF();
            mo53667b(f10);
            m53663a(pointF, pointF2);
            m53662a();
            return pointF2;
        }

        /* renamed from: b */
        public abstract void mo53667b(float f10);

        /* renamed from: c */
        public void m53668c(float f10) {
            Camera camera = this.f40833a;
            camera.setLocation(f10, camera.getLocationY(), this.f40833a.getLocationZ());
        }

        /* renamed from: d */
        public void m53669d(float f10) {
            Camera camera = this.f40833a;
            camera.setLocation(camera.getLocationX(), f10, this.f40833a.getLocationZ());
        }

        /* renamed from: e */
        public void m53670e(float f10) {
            Camera camera = this.f40833a;
            camera.setLocation(camera.getLocationX(), this.f40833a.getLocationY(), f10);
        }

        private aijfr(float f10) {
            Camera camera = new Camera();
            this.f40833a = camera;
            this.f40834b = new Matrix();
            mo53667b(f10);
            camera.save();
        }

        /* renamed from: a */
        public void m53666a(PointF pointF, PointF pointF2, float f10) {
            mo53667b(f10);
            m53663a(pointF, pointF2);
            m53662a();
        }

        /* renamed from: a */
        private void m53663a(PointF pointF, PointF pointF2) {
            float[] fArrM53664a = m53664a(pointF);
            this.f40833a.getMatrix(this.f40834b);
            this.f40834b.mapPoints(fArrM53664a);
            pointF2.x = fArrM53664a[0];
            pointF2.y = fArrM53664a[1];
        }

        /* renamed from: a */
        private static float[] m53664a(PointF pointF) {
            return new float[]{pointF.x, pointF.y};
        }

        /* renamed from: a */
        private void m53662a() {
            this.f40833a.restore();
            this.f40833a.save();
        }

        /* renamed from: a */
        public static aijfr m53661a(float f10) {
            return new bzrwd(f10);
        }
    }

    public static class akxao {

        /* renamed from: a */
        private final float f40835a;

        /* renamed from: b */
        private final float f40836b;

        /* renamed from: c */
        private final int f40837c;

        public akxao(float f10, float f11, int i10) {
            this.f40835a = f10;
            this.f40836b = f11;
            this.f40837c = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static akxao m53676b(Context context, TypedArray typedArray) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new akxao(typedArray.getDimension(C8701R.styleable.f41422x35e8794a, HwGravitationalLoadingDrawable.m53639b(3.0f, displayMetrics)), typedArray.getDimension(C8701R.styleable.f41421x2d0a857d, HwGravitationalLoadingDrawable.m53639b(2.0f, displayMetrics)), typedArray.getInt(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarBackgroundRingAlpha, 135));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static akxao m53675b(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new akxao(HwGravitationalLoadingDrawable.m53639b(3.0f, displayMetrics), HwGravitationalLoadingDrawable.m53639b(2.0f, displayMetrics), 135);
        }
    }

    public static class anbq {

        /* renamed from: a */
        private final PointF f40838a;

        /* renamed from: b */
        private final PointF f40839b;

        /* renamed from: c */
        private final PointF f40840c;

        public anbq(PointF pointF, PointF pointF2, PointF pointF3) {
            m53679a(pointF.x, "start.x");
            m53679a(pointF.y, "start.y");
            m53679a(pointF2.y, "middle.y");
            m53679a(pointF3.y, "end.y");
            if (Float.compare(pointF.x, pointF2.x) >= 0) {
                throw new IllegalArgumentException("start.x >= middle.x");
            }
            if (Float.compare(pointF2.x, pointF3.x) >= 0) {
                throw new IllegalArgumentException("middle.x >= end.x");
            }
            this.f40838a = pointF;
            this.f40839b = pointF2;
            this.f40840c = pointF3;
        }

        /* renamed from: a */
        private float m53678a(float f10, float f11, float f12) {
            return (f10 * (f12 - f11)) + f11;
        }

        /* renamed from: a */
        private static void m53679a(float f10, String str) {
            if (f10 >= 0.0f) {
                return;
            }
            throw new IllegalArgumentException(str + " is negative");
        }

        /* renamed from: a */
        public float m53680a(float f10) {
            if (Float.compare(f10, this.f40838a.x) <= 0) {
                return this.f40838a.y;
            }
            if (Float.compare(f10, this.f40840c.x) >= 0) {
                return this.f40840c.y;
            }
            if (Float.compare(f10, this.f40838a.x) > 0 && Float.compare(f10, this.f40839b.x) <= 0) {
                PointF pointF = this.f40838a;
                float f11 = pointF.x;
                PointF pointF2 = this.f40839b;
                return m53678a((f10 - f11) / (pointF2.x - f11), pointF.y, pointF2.y);
            }
            PointF pointF3 = this.f40839b;
            float f12 = pointF3.x;
            PointF pointF4 = this.f40840c;
            return m53678a((f10 - f12) / (pointF4.x - f12), pointF3.y, pointF4.y);
        }
    }

    public interface avpbg {
        /* renamed from: a */
        void mo53681a(Paint paint);
    }

    public static class awsks {

        /* renamed from: a */
        private final Paint f40841a;

        /* renamed from: b */
        private final float f40842b;

        /* renamed from: c */
        private final bzqlh f40843c;

        /* renamed from: d */
        private final bzqlh f40844d;

        /* renamed from: e */
        private final boolean f40845e;

        /* renamed from: f */
        private float f40846f;

        /* renamed from: g */
        private Bitmap f40847g;

        /* renamed from: h */
        private Canvas f40848h;

        /* renamed from: i */
        private float f40849i;

        /* renamed from: j */
        private float f40850j;

        public awsks(float f10, bzqlh bzqlhVar, boolean z10) {
            this(f10, bzqlhVar, null, z10);
        }

        public awsks(float f10, bzqlh bzqlhVar, bzqlh bzqlhVar2, boolean z10) {
            this.f40841a = new Paint(1);
            this.f40849i = 1.0f;
            this.f40850j = 1.0f;
            this.f40842b = f10;
            this.f40843c = bzqlhVar;
            this.f40844d = bzqlhVar2;
            this.f40845e = z10;
            m53684a(300);
            m53686b();
        }

        /* renamed from: a */
        private void m53684a(int i10) {
            this.f40847g = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
            this.f40848h = new Canvas(this.f40847g);
            this.f40846f = i10;
        }

        /* renamed from: b */
        public void m53691b(int i10) {
            this.f40843c.m53750a(i10);
            bzqlh bzqlhVar = this.f40844d;
            if (bzqlhVar != null) {
                bzqlhVar.m53750a(i10);
            }
            m53683a();
            m53686b();
        }

        /* renamed from: c */
        public void m53692c(int i10) {
            if (this.f40847g == null || i10 > this.f40846f) {
                m53684a(i10);
            } else {
                m53683a();
            }
            this.f40850j = i10 / this.f40842b;
            m53686b();
        }

        /* renamed from: a */
        private void m53683a() {
            this.f40847g.eraseColor(0);
        }

        /* renamed from: a */
        public void m53689a(float f10) {
            this.f40849i = f10;
        }

        /* renamed from: b */
        private void m53686b() {
            this.f40848h.save();
            Canvas canvas = this.f40848h;
            float f10 = this.f40850j;
            canvas.scale(f10, f10);
            float fM53638b = HwGravitationalLoadingDrawable.m53638b(this.f40842b);
            bzqlh bzqlhVar = this.f40844d;
            if (bzqlhVar != null) {
                bzqlhVar.m53751a(this.f40848h, fM53638b, fM53638b);
            }
            this.f40843c.m53751a(this.f40848h, fM53638b, fM53638b);
            this.f40848h.restore();
        }

        /* renamed from: a */
        public void m53690a(Canvas canvas, Rect rect) {
            canvas.save();
            float f10 = this.f40849i;
            canvas.scale(f10, f10, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawBitmap(this.f40847g, rect.left, rect.top, this.f40841a);
            canvas.restore();
        }
    }

    public static final class bfscp {

        /* renamed from: a */
        private final int f40851a;

        /* renamed from: b */
        private final int f40852b;

        /* renamed from: c */
        private final float f40853c;

        public bfscp(int i10, int i11, float f10) {
            this.f40851a = i10;
            this.f40852b = i11;
            this.f40853c = f10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static bfscp m53698b(TypedArray typedArray) {
            int integer = typedArray.getInteger(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarCometTailCount, 20);
            int i10 = integer >= 0 ? integer : 20;
            int integer2 = typedArray.getInteger(C8701R.styleable.f41424x97d79ce4, 60);
            int i11 = integer2 > 0 ? integer2 : 60;
            int i12 = C8701R.styleable.f41423xdfd7bb1e;
            float f10 = HwGravitationalLoadingDrawable.f40785A;
            float fraction = typedArray.getFraction(i12, 1, 1, HwGravitationalLoadingDrawable.f40785A);
            if (fraction >= 0.0f) {
                f10 = fraction;
            }
            return new bfscp(i10, i11, f10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static bfscp m53697b() {
            return new bfscp(20, 60, HwGravitationalLoadingDrawable.f40785A);
        }
    }

    public static class brnby {

        /* renamed from: l */
        private static final int f40884l = -90;

        /* renamed from: b */
        private final bzrwd f40886b;

        /* renamed from: c */
        private final aauaf f40887c;

        /* renamed from: d */
        private final float f40888d;

        /* renamed from: e */
        private final float f40889e;

        /* renamed from: g */
        private float f40891g;

        /* renamed from: h */
        private Bitmap f40892h;

        /* renamed from: i */
        private Canvas f40893i;

        /* renamed from: j */
        private float f40894j;

        /* renamed from: k */
        private float f40895k;

        /* renamed from: a */
        private final Paint f40885a = new Paint(1);

        /* renamed from: f */
        private float f40890f = 1.0f;

        public static class aauaf {

            /* renamed from: a */
            private final Paint f40896a = new Paint(1);

            /* renamed from: b */
            private final int f40897b;

            /* renamed from: c */
            private final bqmxo[] f40898c;

            /* renamed from: d */
            private final PointF f40899d;

            /* renamed from: e */
            private final int f40900e;

            /* renamed from: f */
            private float f40901f;

            /* renamed from: g */
            private int f40902g;

            public aauaf(PointF pointF, aijfr aijfrVar, bfscp bfscpVar, int i10) {
                this.f40899d = pointF;
                int i11 = bfscpVar.f40851a;
                this.f40897b = i11;
                this.f40900e = bfscpVar.f40852b;
                this.f40901f = bfscpVar.f40852b;
                this.f40898c = new bqmxo[i11];
                float f10 = bfscpVar.f40853c;
                int i12 = 0;
                while (true) {
                    bqmxo[] bqmxoVarArr = this.f40898c;
                    if (i12 >= bqmxoVarArr.length) {
                        m53718a(i10);
                        return;
                    }
                    if (i12 == 0) {
                        bqmxoVarArr[i12] = new bqmxo(aijfrVar, m53716a(255, f10));
                    } else {
                        bqmxoVarArr[i12] = new bqmxo(aijfrVar, m53716a(this.f40898c[i12 - 1].f40906c, f10));
                    }
                    i12++;
                }
            }

            /* renamed from: a */
            private int m53716a(int i10, float f10) {
                return (int) (i10 * f10);
            }

            /* renamed from: b */
            public void m53722b(float f10) {
                this.f40901f = Math.min(f10, this.f40900e);
            }

            /* renamed from: a */
            private void m53718a(int i10) {
                this.f40896a.setColor(i10);
                this.f40896a.setStyle(Paint.Style.FILL);
            }

            /* renamed from: a */
            public void m53719a() {
                this.f40901f = this.f40900e;
            }

            /* renamed from: a */
            public void m53720a(float f10) {
                int i10 = this.f40900e;
                int i11 = 0;
                if (i10 <= 0) {
                    this.f40902g = 0;
                    return;
                }
                this.f40902g = (int) ((this.f40901f / i10) * this.f40897b);
                while (true) {
                    int i12 = this.f40902g;
                    if (i11 >= i12) {
                        return;
                    }
                    int i13 = i11 + 1;
                    this.f40898c[i11].m53724a(i13 / i12, this.f40899d, f10, this.f40901f);
                    i11 = i13;
                }
            }

            /* renamed from: a */
            public void m53721a(Canvas canvas, float f10) {
                for (int i10 = 0; i10 < this.f40902g; i10++) {
                    this.f40898c[i10].m53725a(canvas, this.f40896a, f10);
                }
            }
        }

        public static class bqmxo {

            /* renamed from: d */
            private static final FloatEvaluator f40903d = new FloatEvaluator();

            /* renamed from: a */
            private final PointF f40904a = new PointF();

            /* renamed from: b */
            private final aijfr f40905b;

            /* renamed from: c */
            private int f40906c;

            public bqmxo(aijfr aijfrVar, int i10) {
                this.f40905b = aijfrVar;
                this.f40906c = i10;
            }

            /* renamed from: a */
            public void m53725a(Canvas canvas, Paint paint, float f10) {
                int i10 = this.f40906c;
                if (i10 == 0) {
                    return;
                }
                paint.setAlpha(i10);
                PointF pointF = this.f40904a;
                canvas.drawCircle(pointF.x, pointF.y, f10, paint);
            }

            /* renamed from: a */
            public void m53724a(float f10, PointF pointF, float f11, float f12) {
                this.f40905b.m53666a(pointF, this.f40904a, f40903d.evaluate(f10, (Number) Float.valueOf(f11), (Number) Float.valueOf(f11 - f12)).floatValue());
            }
        }

        public static class bzrwd {

            /* renamed from: a */
            private final Paint f40907a = new Paint(1);

            /* renamed from: b */
            private final aijfr f40908b;

            /* renamed from: c */
            private final PointF f40909c;

            /* renamed from: d */
            private final PointF f40910d;

            public bzrwd(aijfr aijfrVar, PointF pointF, int i10) {
                this.f40908b = aijfrVar;
                this.f40909c = pointF;
                this.f40910d = new PointF(pointF.x, pointF.y);
                m53727a(i10);
            }

            /* renamed from: a */
            private void m53727a(int i10) {
                this.f40907a.setStyle(Paint.Style.FILL);
                this.f40907a.setColor(i10);
            }

            /* renamed from: a */
            public void m53728a(float f10) {
                this.f40908b.m53666a(this.f40909c, this.f40910d, f10);
            }

            /* renamed from: a */
            public void m53729a(Canvas canvas, float f10) {
                PointF pointF = this.f40910d;
                canvas.drawCircle(pointF.x, pointF.y, f10, this.f40907a);
            }
        }

        public brnby(int i10, float f10, float f11, float f12, bfscp bfscpVar) {
            this.f40889e = f10;
            m53707a(300);
            this.f40894j = f11;
            this.f40895k = f11;
            PointF pointF = new PointF(f12, 0.0f);
            aijfr aijfrVarM53661a = aijfr.m53661a(-90.0f);
            aijfrVarM53661a.m53669d(1.0f);
            this.f40888d = aijfrVarM53661a.m53665a(pointF, 0.0f).y;
            this.f40886b = new bzrwd(aijfrVarM53661a, pointF, i10);
            this.f40887c = new aauaf(pointF, aijfrVarM53661a, bfscpVar, i10);
        }

        /* renamed from: c */
        public void m53715c(int i10) {
            float f10 = i10;
            if (f10 > this.f40891g) {
                m53707a(i10);
            }
            this.f40890f = f10 / this.f40889e;
        }

        /* renamed from: a */
        private void m53707a(int i10) {
            this.f40892h = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
            this.f40893i = new Canvas(this.f40892h);
            this.f40891g = i10;
        }

        /* renamed from: b */
        public void m53713b(float f10) {
            this.f40887c.m53722b(f10);
        }

        /* renamed from: b */
        public void m53714b(int i10) {
            this.f40886b.f40907a.setColor(i10);
            this.f40887c.f40896a.setColor(i10);
        }

        /* renamed from: a */
        public void m53712a(Canvas canvas, Rect rect, float f10) {
            this.f40892h.eraseColor(0);
            this.f40893i.save();
            Canvas canvas2 = this.f40893i;
            float f11 = this.f40890f;
            canvas2.scale(f11, f11);
            float fM53638b = HwGravitationalLoadingDrawable.m53638b(this.f40889e);
            this.f40893i.translate(fM53638b, fM53638b);
            this.f40893i.rotate(-f10, 0.0f, 0.0f);
            this.f40893i.translate(0.0f, -this.f40888d);
            this.f40886b.m53729a(this.f40893i, this.f40895k);
            this.f40887c.m53721a(this.f40893i, this.f40895k);
            canvas.drawBitmap(this.f40892h, rect.left, rect.top, this.f40885a);
            this.f40893i.restore();
        }

        /* renamed from: a */
        public void m53711a(float f10, int i10, float f11) {
            m53710a(f10);
            this.f40885a.setAlpha(i10);
            this.f40895k = this.f40894j * f11;
        }

        /* renamed from: a */
        public void m53710a(float f10) {
            this.f40886b.m53728a(f10);
            this.f40887c.m53720a(f10);
        }
    }

    public static class bwuqo {

        /* renamed from: a */
        private final float f40911a;

        /* renamed from: b */
        private final float f40912b;

        /* renamed from: c */
        private final int f40913c;

        /* renamed from: d */
        private final float f40914d;

        /* renamed from: e */
        private final float f40915e;

        public bwuqo(float f10, float f11, int i10, float f12, float f13) {
            this.f40911a = f10;
            this.f40912b = f11;
            this.f40913c = i10;
            this.f40914d = f12;
            this.f40915e = f13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static bwuqo m53736b(Context context, TypedArray typedArray) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dimension = typedArray.getDimension(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarRingRadius, HwGravitationalLoadingDrawable.m53639b(HwGravitationalLoadingDrawable.f40800r, displayMetrics));
            float dimension2 = typedArray.getDimension(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarRingStrokeWidth, HwGravitationalLoadingDrawable.m53639b(HwGravitationalLoadingDrawable.f40801s, displayMetrics));
            int integer = typedArray.getInteger(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarRingAlpha, 200);
            float dimension3 = typedArray.getDimension(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarRingBlurRadius, HwGravitationalLoadingDrawable.m53639b(0.2f, displayMetrics));
            float f10 = displayMetrics.density * 40.0f;
            float dimension4 = typedArray.getDimension(C8701R.styleable.f41425x56c4edef, f10);
            return new bwuqo(dimension, dimension2, integer, dimension3, dimension4 <= 0.0f ? f10 : dimension4);
        }

        /* renamed from: a */
        private static bwuqo m53731a(Context context) {
            return m53735b(context, 200);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static bwuqo m53735b(Context context, int i10) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new bwuqo(HwGravitationalLoadingDrawable.m53639b(HwGravitationalLoadingDrawable.f40800r, displayMetrics), HwGravitationalLoadingDrawable.m53639b(HwGravitationalLoadingDrawable.f40801s, displayMetrics), i10, HwGravitationalLoadingDrawable.m53639b(0.2f, displayMetrics), displayMetrics.density * 40.0f);
        }
    }

    public static class bxac {

        /* renamed from: a */
        private final float f40916a;

        /* renamed from: b */
        private final float f40917b;

        /* renamed from: c */
        private final float f40918c;

        public bxac(float f10, float f11, float f12) {
            this.f40916a = f10;
            this.f40917b = f11;
            this.f40918c = f12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static bxac m53745b(Context context, TypedArray typedArray) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dimension = typedArray.getDimension(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarCometRadius, HwGravitationalLoadingDrawable.m53639b(3.0f, displayMetrics));
            float dimension2 = typedArray.getDimension(C8701R.styleable.HwGravitationalLoadingAnimation_hwProgressBarOrbitRadius, HwGravitationalLoadingDrawable.m53639b(HwGravitationalLoadingDrawable.f40786B, displayMetrics));
            float f10 = displayMetrics.density * 40.0f;
            float dimension3 = typedArray.getDimension(C8701R.styleable.f41425x56c4edef, f10);
            if (dimension3 > 0.0f) {
                f10 = dimension3;
            }
            return new bxac(dimension, dimension2, f10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static bxac m53744b(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new bxac(HwGravitationalLoadingDrawable.m53639b(3.0f, displayMetrics), HwGravitationalLoadingDrawable.m53639b(HwGravitationalLoadingDrawable.f40786B, displayMetrics), displayMetrics.density * 40.0f);
        }
    }

    public static class bzqlh {

        /* renamed from: a */
        private final Paint f40919a;

        /* renamed from: b */
        private final int f40920b;

        /* renamed from: c */
        private final float f40921c;

        /* renamed from: d */
        private final int f40922d;

        /* renamed from: e */
        private float f40923e;

        public bzqlh(int i10, float f10, float f11) {
            this(i10, f10, f11, 255);
        }

        public bzqlh(int i10, float f10, float f11, int i11) {
            this.f40919a = new Paint(1);
            this.f40920b = i10;
            this.f40921c = f10;
            this.f40923e = f11;
            this.f40922d = i11;
            m53748a();
        }

        /* renamed from: a */
        private void m53748a() {
            this.f40919a.setStyle(Paint.Style.STROKE);
            this.f40919a.setStrokeWidth(this.f40923e);
            this.f40919a.setColor(this.f40920b);
            this.f40919a.setAlpha(this.f40922d);
        }

        /* renamed from: a */
        public void m53750a(int i10) {
            this.f40919a.setColor(i10);
            this.f40919a.setAlpha(this.f40922d);
        }

        /* renamed from: a */
        public void m53749a(float f10) {
            this.f40923e = f10;
            this.f40919a.setStrokeWidth(f10);
        }

        /* renamed from: a */
        public void m53752a(avpbg avpbgVar) {
            avpbgVar.mo53681a(this.f40919a);
        }

        /* renamed from: a */
        public void m53751a(Canvas canvas, float f10, float f11) {
            canvas.drawCircle(f10, f11, this.f40921c, this.f40919a);
        }
    }

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {
        public bzrwd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwGravitationalLoadingDrawable.f40793k, "onAnimationUpdate:null animator");
                return;
            }
            HwGravitationalLoadingDrawable.this.f40818j = ((Float) valueAnimator.getAnimatedValue(HwGravitationalLoadingDrawable.f40797o)).floatValue() * HwGravitationalLoadingDrawable.this.f40809a.f40850j;
            HwGravitationalLoadingDrawable.this.invalidateSelf();
        }
    }

    public HwGravitationalLoadingDrawable(awsks awsksVar, brnby brnbyVar, int i10, float f10) {
        this.f40809a = awsksVar;
        this.f40810b = brnbyVar;
        m53642c(i10);
        m53641b(i10);
        this.f40811c = aayti.m53660d(f10);
        this.f40812d = aayti.m53659c(f10);
        this.f40813e = aayti.m53654a(f10);
        this.f40814f = aayti.m53657b(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static float m53638b(float f10) {
        return f10 / 2.0f;
    }

    /* renamed from: c */
    private void m53642c(int i10) {
        this.f40815g = bqmxo.m53701a(i10, this.f40809a.f40843c.f40921c * 2.0f, new bzrwd());
    }

    public static HwGravitationalLoadingDrawable create(int i10, ParamsBundle paramsBundle, DisplayMetrics displayMetrics, int i11) {
        if (i11 <= 0) {
            i11 = 1200;
        }
        int iM53633a = m53633a(i10);
        return new HwGravitationalLoadingDrawable(m53640b(iM53633a, paramsBundle), m53637a(iM53633a, paramsBundle), i11, displayMetrics.density);
    }

    /* renamed from: d */
    private void m53643d(int i10) {
        float f10 = i10;
        this.f40809a.f40843c.m53749a(this.f40811c.m53680a(f10));
        this.f40810b.f40894j = this.f40814f.m53680a(f10);
        brnby brnbyVar = this.f40810b;
        brnbyVar.f40895k = brnbyVar.f40894j;
        if (this.f40809a.f40845e) {
            this.f40809a.f40843c.m53752a(blfhz.m53700a(this.f40812d.m53680a(f10)));
            if (this.f40809a.f40844d != null) {
                this.f40809a.f40844d.m53749a(this.f40813e.m53680a(f10));
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, this.f40818j);
        this.f40809a.m53690a(canvas, getBounds());
        this.f40810b.m53712a(canvas, getBounds(), f40787C);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f40817i;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
        int iMin = Math.min(rect.width(), rect.height());
        m53643d(iMin);
        this.f40809a.m53692c(iMin);
        this.f40810b.m53715c(iMin);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    public void setColor(int i10) {
        int iM53633a = m53633a(i10);
        this.f40810b.m53714b(iM53633a);
        this.f40809a.m53691b(iM53633a);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        m53645a(true);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m53644a();
    }

    public static class blfhz implements avpbg {

        /* renamed from: a */
        private final float f40854a;

        /* renamed from: b */
        private final BlurMaskFilter.Blur f40855b;

        public blfhz(float f10, BlurMaskFilter.Blur blur) {
            this.f40854a = f10;
            this.f40855b = blur;
        }

        @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable.avpbg
        /* renamed from: a */
        public void mo53681a(Paint paint) {
            paint.setMaskFilter(null);
            paint.setMaskFilter(new BlurMaskFilter(this.f40854a, this.f40855b));
        }

        /* renamed from: a */
        public static blfhz m53700a(float f10) {
            return new blfhz(f10, BlurMaskFilter.Blur.NORMAL);
        }
    }

    /* renamed from: b */
    private void m53641b(int i10) {
        this.f40816h = bqmxo.m53702a(i10, f40799q, (ValueAnimator.AnimatorUpdateListener) new aauaf());
    }

    /* renamed from: b */
    public static awsks m53640b(int i10, ParamsBundle paramsBundle) {
        if (paramsBundle.f40819a && paramsBundle.f40823e == null) {
            throw new IllegalArgumentException("create for night mode, but BackgroundRingParams is null");
        }
        if (paramsBundle.f40819a) {
            return m53636a(i10, paramsBundle.f40820b, paramsBundle.f40823e);
        }
        return m53635a(i10, paramsBundle.f40820b);
    }

    /* renamed from: a */
    public void m53645a(boolean z10) {
        if (this.f40817i) {
            return;
        }
        if (z10) {
            this.f40810b.f40887c.m53719a();
        }
        this.f40816h.start();
        this.f40815g.start();
        this.f40817i = true;
    }

    public static class bqmxo {

        /* renamed from: A */
        private static final int f40856A = 255;

        /* renamed from: B */
        private static final float f40857B = 360.0f;

        /* renamed from: a */
        private static final float f40858a = 0.06f;

        /* renamed from: b */
        private static final int f40859b = 4;

        /* renamed from: c */
        private static final int f40860c = 2;

        /* renamed from: d */
        private static final float f40861d = 0.0f;

        /* renamed from: e */
        private static final float f40862e = 0.0f;

        /* renamed from: f */
        private static final float f40863f = 0.67f;

        /* renamed from: g */
        private static final float f40864g = 1.0f;

        /* renamed from: h */
        private static final float f40865h = 0.33f;

        /* renamed from: i */
        private static final float f40866i = 0.0f;

        /* renamed from: j */
        private static final float f40867j = 0.67f;

        /* renamed from: k */
        private static final float f40868k = 1.0f;

        /* renamed from: l */
        private static final float f40869l = 0.0f;

        /* renamed from: m */
        private static final float f40870m = 0.93f;

        /* renamed from: n */
        private static final float f40871n = 0.4f;

        /* renamed from: o */
        private static final float f40872o = 0.65f;

        /* renamed from: p */
        private static final float f40873p = 0.9f;

        /* renamed from: q */
        private static final float f40874q = 1.0f;

        /* renamed from: r */
        private static final float f40875r = 1.0f;

        /* renamed from: s */
        private static final float f40876s = 0.93f;

        /* renamed from: t */
        private static final float f40877t = 0.0f;

        /* renamed from: u */
        private static final int f40878u = 255;

        /* renamed from: v */
        private static final float f40879v = 0.4f;

        /* renamed from: w */
        private static final int f40880w = 51;

        /* renamed from: x */
        private static final float f40881x = 0.8f;

        /* renamed from: y */
        private static final int f40882y = 255;

        /* renamed from: z */
        private static final float f40883z = 1.0f;

        /* renamed from: a */
        public static Animator m53701a(long j10, float f10, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            float f11 = f10 * f40858a;
            ValueAnimator valueAnimatorM53704b = m53704b(j10, f11);
            valueAnimatorM53704b.addUpdateListener(animatorUpdateListener);
            ValueAnimator valueAnimatorM53703a = m53703a(j10, f11);
            valueAnimatorM53703a.addUpdateListener(animatorUpdateListener);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(valueAnimatorM53704b, valueAnimatorM53703a);
            return animatorSet;
        }

        /* renamed from: b */
        private static ValueAnimator m53704b(long j10, float f10) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(HwGravitationalLoadingDrawable.f40797o, 0.0f, -f10));
            valueAnimatorOfPropertyValuesHolder.setInterpolator(C10076a.m62701a(0.0f, 0.0f, 0.67f, 1.0f));
            valueAnimatorOfPropertyValuesHolder.setDuration(j10 / 4);
            return valueAnimatorOfPropertyValuesHolder;
        }

        /* renamed from: a */
        private static ValueAnimator m53703a(long j10, float f10) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(HwGravitationalLoadingDrawable.f40797o, -f10, f10));
            valueAnimatorOfPropertyValuesHolder.setDuration(j10 / 2);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(C10076a.m62701a(f40865h, 0.0f, 0.67f, 1.0f));
            valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            valueAnimatorOfPropertyValuesHolder.setRepeatMode(2);
            return valueAnimatorOfPropertyValuesHolder;
        }

        /* renamed from: a */
        public static ValueAnimator m53702a(int i10, float f10, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe(HwGravitationalLoadingDrawable.f40794l, Keyframe.ofFloat(0.0f, 0.93f), Keyframe.ofFloat(0.4f, f40872o), Keyframe.ofFloat(0.9f, 1.0f), Keyframe.ofFloat(1.0f, 0.93f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofInt(0.0f, 255), Keyframe.ofInt(0.4f, 51), Keyframe.ofInt(0.8f, 255), Keyframe.ofInt(1.0f, 255)), PropertyValuesHolder.ofFloat(HwGravitationalLoadingDrawable.f40796n, f10, f40857B + f10));
            valueAnimatorOfPropertyValuesHolder.setDuration(i10);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            valueAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            valueAnimatorOfPropertyValuesHolder.setRepeatMode(1);
            valueAnimatorOfPropertyValuesHolder.addUpdateListener(animatorUpdateListener);
            return valueAnimatorOfPropertyValuesHolder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static float m53639b(float f10, DisplayMetrics displayMetrics) {
        return f10 * displayMetrics.density;
    }

    /* renamed from: a */
    public void m53644a() {
        if (this.f40817i) {
            this.f40816h.end();
            this.f40815g.end();
            this.f40817i = false;
        }
    }

    /* renamed from: a */
    public static ParamsBundle m53634a(Context context, boolean z10, int i10) {
        return new ParamsBundle(bwuqo.m53735b(context, Color.alpha(i10)), bxac.m53744b(context), bfscp.m53697b(), akxao.m53675b(context), z10);
    }

    /* renamed from: a */
    private static awsks m53635a(int i10, bwuqo bwuqoVar) {
        return new awsks(bwuqoVar.f40915e, new bzqlh(i10, bwuqoVar.f40911a, bwuqoVar.f40912b, bwuqoVar.f40913c), false);
    }

    /* renamed from: a */
    private static awsks m53636a(int i10, bwuqo bwuqoVar, akxao akxaoVar) {
        bzqlh bzqlhVar = new bzqlh(i10, bwuqoVar.f40911a, akxaoVar.f40835a, akxaoVar.f40837c);
        bzqlhVar.m53752a(blfhz.m53700a(akxaoVar.f40836b));
        bzqlh bzqlhVar2 = new bzqlh(i10, bwuqoVar.f40911a, bwuqoVar.f40912b);
        bzqlhVar2.m53752a(blfhz.m53700a(bwuqoVar.f40914d));
        return new awsks(bwuqoVar.f40915e, bzqlhVar2, bzqlhVar, true);
    }

    /* renamed from: a */
    public static brnby m53637a(int i10, ParamsBundle paramsBundle) {
        return new brnby(i10, paramsBundle.f40821c.f40918c, paramsBundle.f40821c.f40916a, paramsBundle.f40821c.f40917b, paramsBundle.f40822d);
    }

    /* renamed from: a */
    public static int m53633a(int i10) {
        return C13503b.m81226j(i10, 255);
    }
}
