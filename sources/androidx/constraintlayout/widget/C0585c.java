package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p504o.C11770c;
import p561q.C12258e;
import p561q.C12263j;
import p642t.C12896a;

/* renamed from: androidx.constraintlayout.widget.c */
/* loaded from: classes.dex */
public class C0585c {

    /* renamed from: i */
    public static final int[] f3094i = {0, 4, 8};

    /* renamed from: j */
    public static SparseIntArray f3095j = new SparseIntArray();

    /* renamed from: k */
    public static SparseIntArray f3096k = new SparseIntArray();

    /* renamed from: a */
    public boolean f3097a;

    /* renamed from: b */
    public String f3098b;

    /* renamed from: c */
    public String f3099c = "";

    /* renamed from: d */
    public String[] f3100d = new String[0];

    /* renamed from: e */
    public int f3101e = 0;

    /* renamed from: f */
    public HashMap<String, C0583a> f3102f = new HashMap<>();

    /* renamed from: g */
    public boolean f3103g = true;

    /* renamed from: h */
    public HashMap<Integer, a> f3104h = new HashMap<>();

    /* renamed from: androidx.constraintlayout.widget.c$a */
    public static class a {

        /* renamed from: a */
        public int f3105a;

        /* renamed from: b */
        public String f3106b;

        /* renamed from: c */
        public final d f3107c = new d();

        /* renamed from: d */
        public final c f3108d = new c();

        /* renamed from: e */
        public final b f3109e = new b();

        /* renamed from: f */
        public final e f3110f = new e();

        /* renamed from: g */
        public HashMap<String, C0583a> f3111g = new HashMap<>();

        /* renamed from: h */
        public C14406a f3112h;

        /* renamed from: androidx.constraintlayout.widget.c$a$a */
        public static class C14406a {

            /* renamed from: a */
            public int[] f3113a = new int[10];

            /* renamed from: b */
            public int[] f3114b = new int[10];

            /* renamed from: c */
            public int f3115c = 0;

            /* renamed from: d */
            public int[] f3116d = new int[10];

            /* renamed from: e */
            public float[] f3117e = new float[10];

            /* renamed from: f */
            public int f3118f = 0;

            /* renamed from: g */
            public int[] f3119g = new int[5];

            /* renamed from: h */
            public String[] f3120h = new String[5];

            /* renamed from: i */
            public int f3121i = 0;

            /* renamed from: j */
            public int[] f3122j = new int[4];

            /* renamed from: k */
            public boolean[] f3123k = new boolean[4];

            /* renamed from: l */
            public int f3124l = 0;

            /* renamed from: a */
            public void m3657a(int i10, float f10) {
                int i11 = this.f3118f;
                int[] iArr = this.f3116d;
                if (i11 >= iArr.length) {
                    this.f3116d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f3117e;
                    this.f3117e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f3116d;
                int i12 = this.f3118f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f3117e;
                this.f3118f = i12 + 1;
                fArr2[i12] = f10;
            }

            /* renamed from: b */
            public void m3658b(int i10, int i11) {
                int i12 = this.f3115c;
                int[] iArr = this.f3113a;
                if (i12 >= iArr.length) {
                    this.f3113a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f3114b;
                    this.f3114b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f3113a;
                int i13 = this.f3115c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f3114b;
                this.f3115c = i13 + 1;
                iArr4[i13] = i11;
            }

            /* renamed from: c */
            public void m3659c(int i10, String str) {
                int i11 = this.f3121i;
                int[] iArr = this.f3119g;
                if (i11 >= iArr.length) {
                    this.f3119g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f3120h;
                    this.f3120h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f3119g;
                int i12 = this.f3121i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f3120h;
                this.f3121i = i12 + 1;
                strArr2[i12] = str;
            }

            /* renamed from: d */
            public void m3660d(int i10, boolean z10) {
                int i11 = this.f3124l;
                int[] iArr = this.f3122j;
                if (i11 >= iArr.length) {
                    this.f3122j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f3123k;
                    this.f3123k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f3122j;
                int i12 = this.f3124l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f3123k;
                this.f3124l = i12 + 1;
                zArr2[i12] = z10;
            }

            /* renamed from: e */
            public void m3661e(a aVar) {
                for (int i10 = 0; i10 < this.f3115c; i10++) {
                    C0585c.m3608O(aVar, this.f3113a[i10], this.f3114b[i10]);
                }
                for (int i11 = 0; i11 < this.f3118f; i11++) {
                    C0585c.m3607N(aVar, this.f3116d[i11], this.f3117e[i11]);
                }
                for (int i12 = 0; i12 < this.f3121i; i12++) {
                    C0585c.m3609P(aVar, this.f3119g[i12], this.f3120h[i12]);
                }
                for (int i13 = 0; i13 < this.f3124l; i13++) {
                    C0585c.m3610Q(aVar, this.f3122j[i13], this.f3123k[i13]);
                }
            }
        }

        /* renamed from: d */
        public void m3651d(a aVar) {
            C14406a c14406a = this.f3112h;
            if (c14406a != null) {
                c14406a.m3661e(aVar);
            }
        }

        /* renamed from: e */
        public void m3652e(ConstraintLayout.LayoutParams layoutParams) {
            b bVar = this.f3109e;
            layoutParams.f2984e = bVar.f3170j;
            layoutParams.f2986f = bVar.f3172k;
            layoutParams.f2988g = bVar.f3174l;
            layoutParams.f2990h = bVar.f3176m;
            layoutParams.f2992i = bVar.f3178n;
            layoutParams.f2994j = bVar.f3180o;
            layoutParams.f2996k = bVar.f3182p;
            layoutParams.f2998l = bVar.f3184q;
            layoutParams.f3000m = bVar.f3186r;
            layoutParams.f3002n = bVar.f3187s;
            layoutParams.f3004o = bVar.f3188t;
            layoutParams.f3012s = bVar.f3189u;
            layoutParams.f3014t = bVar.f3190v;
            layoutParams.f3016u = bVar.f3191w;
            layoutParams.f3018v = bVar.f3192x;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bVar.f3133H;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bVar.f3134I;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = bVar.f3135J;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bVar.f3136K;
            layoutParams.f2950A = bVar.f3145T;
            layoutParams.f2951B = bVar.f3144S;
            layoutParams.f3022x = bVar.f3141P;
            layoutParams.f3024z = bVar.f3143R;
            layoutParams.f2956G = bVar.f3193y;
            layoutParams.f2957H = bVar.f3194z;
            layoutParams.f3006p = bVar.f3127B;
            layoutParams.f3008q = bVar.f3128C;
            layoutParams.f3010r = bVar.f3129D;
            layoutParams.f2958I = bVar.f3126A;
            layoutParams.f2973X = bVar.f3130E;
            layoutParams.f2974Y = bVar.f3131F;
            layoutParams.f2962M = bVar.f3147V;
            layoutParams.f2961L = bVar.f3148W;
            layoutParams.f2964O = bVar.f3150Y;
            layoutParams.f2963N = bVar.f3149X;
            layoutParams.f2977a0 = bVar.f3179n0;
            layoutParams.f2979b0 = bVar.f3181o0;
            layoutParams.f2965P = bVar.f3151Z;
            layoutParams.f2966Q = bVar.f3153a0;
            layoutParams.f2969T = bVar.f3155b0;
            layoutParams.f2970U = bVar.f3157c0;
            layoutParams.f2967R = bVar.f3159d0;
            layoutParams.f2968S = bVar.f3161e0;
            layoutParams.f2971V = bVar.f3163f0;
            layoutParams.f2972W = bVar.f3165g0;
            layoutParams.f2975Z = bVar.f3132G;
            layoutParams.f2980c = bVar.f3166h;
            layoutParams.f2976a = bVar.f3162f;
            layoutParams.f2978b = bVar.f3164g;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = bVar.f3158d;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = bVar.f3160e;
            String str = bVar.f3177m0;
            if (str != null) {
                layoutParams.f2981c0 = str;
            }
            layoutParams.f2983d0 = bVar.f3185q0;
            layoutParams.setMarginStart(bVar.f3138M);
            layoutParams.setMarginEnd(this.f3109e.f3137L);
            layoutParams.m3570c();
        }

        /* renamed from: f */
        public a clone() {
            a aVar = new a();
            aVar.f3109e.m3662a(this.f3109e);
            aVar.f3108d.m3664a(this.f3108d);
            aVar.f3107c.m3666a(this.f3107c);
            aVar.f3110f.m3668a(this.f3110f);
            aVar.f3105a = this.f3105a;
            aVar.f3112h = this.f3112h;
            return aVar;
        }

        /* renamed from: g */
        public final void m3654g(int i10, ConstraintLayout.LayoutParams layoutParams) {
            this.f3105a = i10;
            b bVar = this.f3109e;
            bVar.f3170j = layoutParams.f2984e;
            bVar.f3172k = layoutParams.f2986f;
            bVar.f3174l = layoutParams.f2988g;
            bVar.f3176m = layoutParams.f2990h;
            bVar.f3178n = layoutParams.f2992i;
            bVar.f3180o = layoutParams.f2994j;
            bVar.f3182p = layoutParams.f2996k;
            bVar.f3184q = layoutParams.f2998l;
            bVar.f3186r = layoutParams.f3000m;
            bVar.f3187s = layoutParams.f3002n;
            bVar.f3188t = layoutParams.f3004o;
            bVar.f3189u = layoutParams.f3012s;
            bVar.f3190v = layoutParams.f3014t;
            bVar.f3191w = layoutParams.f3016u;
            bVar.f3192x = layoutParams.f3018v;
            bVar.f3193y = layoutParams.f2956G;
            bVar.f3194z = layoutParams.f2957H;
            bVar.f3126A = layoutParams.f2958I;
            bVar.f3127B = layoutParams.f3006p;
            bVar.f3128C = layoutParams.f3008q;
            bVar.f3129D = layoutParams.f3010r;
            bVar.f3130E = layoutParams.f2973X;
            bVar.f3131F = layoutParams.f2974Y;
            bVar.f3132G = layoutParams.f2975Z;
            bVar.f3166h = layoutParams.f2980c;
            bVar.f3162f = layoutParams.f2976a;
            bVar.f3164g = layoutParams.f2978b;
            bVar.f3158d = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            bVar.f3160e = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            bVar.f3133H = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            bVar.f3134I = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            bVar.f3135J = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            bVar.f3136K = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            bVar.f3139N = layoutParams.f2953D;
            bVar.f3147V = layoutParams.f2962M;
            bVar.f3148W = layoutParams.f2961L;
            bVar.f3150Y = layoutParams.f2964O;
            bVar.f3149X = layoutParams.f2963N;
            bVar.f3179n0 = layoutParams.f2977a0;
            bVar.f3181o0 = layoutParams.f2979b0;
            bVar.f3151Z = layoutParams.f2965P;
            bVar.f3153a0 = layoutParams.f2966Q;
            bVar.f3155b0 = layoutParams.f2969T;
            bVar.f3157c0 = layoutParams.f2970U;
            bVar.f3159d0 = layoutParams.f2967R;
            bVar.f3161e0 = layoutParams.f2968S;
            bVar.f3163f0 = layoutParams.f2971V;
            bVar.f3165g0 = layoutParams.f2972W;
            bVar.f3177m0 = layoutParams.f2981c0;
            bVar.f3141P = layoutParams.f3022x;
            bVar.f3143R = layoutParams.f3024z;
            bVar.f3140O = layoutParams.f3020w;
            bVar.f3142Q = layoutParams.f3023y;
            bVar.f3145T = layoutParams.f2950A;
            bVar.f3144S = layoutParams.f2951B;
            bVar.f3146U = layoutParams.f2952C;
            bVar.f3185q0 = layoutParams.f2983d0;
            bVar.f3137L = layoutParams.getMarginEnd();
            this.f3109e.f3138M = layoutParams.getMarginStart();
        }

        /* renamed from: h */
        public final void m3655h(int i10, Constraints.LayoutParams layoutParams) {
            m3654g(i10, layoutParams);
            this.f3107c.f3213d = layoutParams.f3046x0;
            e eVar = this.f3110f;
            eVar.f3217b = layoutParams.f3036A0;
            eVar.f3218c = layoutParams.f3037B0;
            eVar.f3219d = layoutParams.f3038C0;
            eVar.f3220e = layoutParams.f3039D0;
            eVar.f3221f = layoutParams.f3040E0;
            eVar.f3222g = layoutParams.f3041F0;
            eVar.f3223h = layoutParams.f3042G0;
            eVar.f3225j = layoutParams.f3043H0;
            eVar.f3226k = layoutParams.f3044I0;
            eVar.f3227l = layoutParams.f3045J0;
            eVar.f3229n = layoutParams.f3048z0;
            eVar.f3228m = layoutParams.f3047y0;
        }

        /* renamed from: i */
        public final void m3656i(ConstraintHelper constraintHelper, int i10, Constraints.LayoutParams layoutParams) {
            m3655h(i10, layoutParams);
            if (constraintHelper instanceof Barrier) {
                b bVar = this.f3109e;
                bVar.f3171j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                bVar.f3167h0 = barrier.getType();
                this.f3109e.f3173k0 = barrier.getReferencedIds();
                this.f3109e.f3169i0 = barrier.getMargin();
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$b */
    public static class b {

        /* renamed from: r0 */
        public static SparseIntArray f3125r0;

        /* renamed from: d */
        public int f3158d;

        /* renamed from: e */
        public int f3160e;

        /* renamed from: k0 */
        public int[] f3173k0;

        /* renamed from: l0 */
        public String f3175l0;

        /* renamed from: m0 */
        public String f3177m0;

        /* renamed from: a */
        public boolean f3152a = false;

        /* renamed from: b */
        public boolean f3154b = false;

        /* renamed from: c */
        public boolean f3156c = false;

        /* renamed from: f */
        public int f3162f = -1;

        /* renamed from: g */
        public int f3164g = -1;

        /* renamed from: h */
        public float f3166h = -1.0f;

        /* renamed from: i */
        public boolean f3168i = true;

        /* renamed from: j */
        public int f3170j = -1;

        /* renamed from: k */
        public int f3172k = -1;

        /* renamed from: l */
        public int f3174l = -1;

        /* renamed from: m */
        public int f3176m = -1;

        /* renamed from: n */
        public int f3178n = -1;

        /* renamed from: o */
        public int f3180o = -1;

        /* renamed from: p */
        public int f3182p = -1;

        /* renamed from: q */
        public int f3184q = -1;

        /* renamed from: r */
        public int f3186r = -1;

        /* renamed from: s */
        public int f3187s = -1;

        /* renamed from: t */
        public int f3188t = -1;

        /* renamed from: u */
        public int f3189u = -1;

        /* renamed from: v */
        public int f3190v = -1;

        /* renamed from: w */
        public int f3191w = -1;

        /* renamed from: x */
        public int f3192x = -1;

        /* renamed from: y */
        public float f3193y = 0.5f;

        /* renamed from: z */
        public float f3194z = 0.5f;

        /* renamed from: A */
        public String f3126A = null;

        /* renamed from: B */
        public int f3127B = -1;

        /* renamed from: C */
        public int f3128C = 0;

        /* renamed from: D */
        public float f3129D = 0.0f;

        /* renamed from: E */
        public int f3130E = -1;

        /* renamed from: F */
        public int f3131F = -1;

        /* renamed from: G */
        public int f3132G = -1;

        /* renamed from: H */
        public int f3133H = 0;

        /* renamed from: I */
        public int f3134I = 0;

        /* renamed from: J */
        public int f3135J = 0;

        /* renamed from: K */
        public int f3136K = 0;

        /* renamed from: L */
        public int f3137L = 0;

        /* renamed from: M */
        public int f3138M = 0;

        /* renamed from: N */
        public int f3139N = 0;

        /* renamed from: O */
        public int f3140O = Integer.MIN_VALUE;

        /* renamed from: P */
        public int f3141P = Integer.MIN_VALUE;

        /* renamed from: Q */
        public int f3142Q = Integer.MIN_VALUE;

        /* renamed from: R */
        public int f3143R = Integer.MIN_VALUE;

        /* renamed from: S */
        public int f3144S = Integer.MIN_VALUE;

        /* renamed from: T */
        public int f3145T = Integer.MIN_VALUE;

        /* renamed from: U */
        public int f3146U = Integer.MIN_VALUE;

        /* renamed from: V */
        public float f3147V = -1.0f;

        /* renamed from: W */
        public float f3148W = -1.0f;

        /* renamed from: X */
        public int f3149X = 0;

        /* renamed from: Y */
        public int f3150Y = 0;

        /* renamed from: Z */
        public int f3151Z = 0;

        /* renamed from: a0 */
        public int f3153a0 = 0;

        /* renamed from: b0 */
        public int f3155b0 = 0;

        /* renamed from: c0 */
        public int f3157c0 = 0;

        /* renamed from: d0 */
        public int f3159d0 = 0;

        /* renamed from: e0 */
        public int f3161e0 = 0;

        /* renamed from: f0 */
        public float f3163f0 = 1.0f;

        /* renamed from: g0 */
        public float f3165g0 = 1.0f;

        /* renamed from: h0 */
        public int f3167h0 = -1;

        /* renamed from: i0 */
        public int f3169i0 = 0;

        /* renamed from: j0 */
        public int f3171j0 = -1;

        /* renamed from: n0 */
        public boolean f3179n0 = false;

        /* renamed from: o0 */
        public boolean f3181o0 = false;

        /* renamed from: p0 */
        public boolean f3183p0 = true;

        /* renamed from: q0 */
        public int f3185q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3125r0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f3125r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f3125r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f3125r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f3125r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f3125r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f3125r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f3125r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f3125r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f3125r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f3125r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f3125r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f3125r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f3125r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            SparseIntArray sparseIntArray2 = f3125r0;
            int i10 = R$styleable.Layout_guidelineUseRtl;
            sparseIntArray2.append(i10, 90);
            f3125r0.append(R$styleable.Layout_android_orientation, 26);
            f3125r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f3125r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f3125r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f3125r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f3125r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f3125r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f3125r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f3125r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f3125r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f3125r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f3125r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f3125r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f3125r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f3125r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f3125r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f3125r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f3125r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f3125r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            f3125r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            f3125r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            f3125r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            f3125r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            f3125r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f3125r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f3125r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f3125r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f3125r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f3125r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f3125r0.append(R$styleable.Layout_android_layout_width, 22);
            f3125r0.append(R$styleable.Layout_android_layout_height, 21);
            SparseIntArray sparseIntArray3 = f3125r0;
            int i11 = R$styleable.Layout_layout_constraintWidth;
            sparseIntArray3.append(i11, 41);
            SparseIntArray sparseIntArray4 = f3125r0;
            int i12 = R$styleable.Layout_layout_constraintHeight;
            sparseIntArray4.append(i12, 42);
            f3125r0.append(R$styleable.Layout_layout_constrainedWidth, 87);
            f3125r0.append(R$styleable.Layout_layout_constrainedHeight, 88);
            f3125r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            f3125r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f3125r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f3125r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f3125r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f3125r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f3125r0.append(R$styleable.Layout_chainUseRtl, 71);
            f3125r0.append(R$styleable.Layout_barrierDirection, 72);
            f3125r0.append(R$styleable.Layout_barrierMargin, 73);
            f3125r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f3125r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
            SparseIntArray sparseIntArray5 = f3125r0;
            int i13 = R$styleable.Layout_layout_constraintWidth_max;
            sparseIntArray5.append(i13, 84);
            f3125r0.append(R$styleable.Layout_layout_constraintWidth_min, 86);
            f3125r0.append(i13, 83);
            f3125r0.append(R$styleable.Layout_layout_constraintHeight_min, 85);
            f3125r0.append(i11, 87);
            f3125r0.append(i12, 88);
            f3125r0.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            f3125r0.append(i10, 90);
        }

        /* renamed from: a */
        public void m3662a(b bVar) {
            this.f3152a = bVar.f3152a;
            this.f3158d = bVar.f3158d;
            this.f3154b = bVar.f3154b;
            this.f3160e = bVar.f3160e;
            this.f3162f = bVar.f3162f;
            this.f3164g = bVar.f3164g;
            this.f3166h = bVar.f3166h;
            this.f3168i = bVar.f3168i;
            this.f3170j = bVar.f3170j;
            this.f3172k = bVar.f3172k;
            this.f3174l = bVar.f3174l;
            this.f3176m = bVar.f3176m;
            this.f3178n = bVar.f3178n;
            this.f3180o = bVar.f3180o;
            this.f3182p = bVar.f3182p;
            this.f3184q = bVar.f3184q;
            this.f3186r = bVar.f3186r;
            this.f3187s = bVar.f3187s;
            this.f3188t = bVar.f3188t;
            this.f3189u = bVar.f3189u;
            this.f3190v = bVar.f3190v;
            this.f3191w = bVar.f3191w;
            this.f3192x = bVar.f3192x;
            this.f3193y = bVar.f3193y;
            this.f3194z = bVar.f3194z;
            this.f3126A = bVar.f3126A;
            this.f3127B = bVar.f3127B;
            this.f3128C = bVar.f3128C;
            this.f3129D = bVar.f3129D;
            this.f3130E = bVar.f3130E;
            this.f3131F = bVar.f3131F;
            this.f3132G = bVar.f3132G;
            this.f3133H = bVar.f3133H;
            this.f3134I = bVar.f3134I;
            this.f3135J = bVar.f3135J;
            this.f3136K = bVar.f3136K;
            this.f3137L = bVar.f3137L;
            this.f3138M = bVar.f3138M;
            this.f3139N = bVar.f3139N;
            this.f3140O = bVar.f3140O;
            this.f3141P = bVar.f3141P;
            this.f3142Q = bVar.f3142Q;
            this.f3143R = bVar.f3143R;
            this.f3144S = bVar.f3144S;
            this.f3145T = bVar.f3145T;
            this.f3146U = bVar.f3146U;
            this.f3147V = bVar.f3147V;
            this.f3148W = bVar.f3148W;
            this.f3149X = bVar.f3149X;
            this.f3150Y = bVar.f3150Y;
            this.f3151Z = bVar.f3151Z;
            this.f3153a0 = bVar.f3153a0;
            this.f3155b0 = bVar.f3155b0;
            this.f3157c0 = bVar.f3157c0;
            this.f3159d0 = bVar.f3159d0;
            this.f3161e0 = bVar.f3161e0;
            this.f3163f0 = bVar.f3163f0;
            this.f3165g0 = bVar.f3165g0;
            this.f3167h0 = bVar.f3167h0;
            this.f3169i0 = bVar.f3169i0;
            this.f3171j0 = bVar.f3171j0;
            this.f3177m0 = bVar.f3177m0;
            int[] iArr = bVar.f3173k0;
            if (iArr == null || bVar.f3175l0 != null) {
                this.f3173k0 = null;
            } else {
                this.f3173k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f3175l0 = bVar.f3175l0;
            this.f3179n0 = bVar.f3179n0;
            this.f3181o0 = bVar.f3181o0;
            this.f3183p0 = bVar.f3183p0;
            this.f3185q0 = bVar.f3185q0;
        }

        /* renamed from: b */
        public void m3663b(Context context, AttributeSet attributeSet) throws NumberFormatException {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.f3154b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = f3125r0.get(index);
                switch (i11) {
                    case 1:
                        this.f3186r = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3186r);
                        break;
                    case 2:
                        this.f3136K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3136K);
                        break;
                    case 3:
                        this.f3184q = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3184q);
                        break;
                    case 4:
                        this.f3182p = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3182p);
                        break;
                    case 5:
                        this.f3126A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f3130E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3130E);
                        break;
                    case 7:
                        this.f3131F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3131F);
                        break;
                    case 8:
                        this.f3137L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3137L);
                        break;
                    case 9:
                        this.f3192x = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3192x);
                        break;
                    case 10:
                        this.f3191w = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3191w);
                        break;
                    case 11:
                        this.f3143R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3143R);
                        break;
                    case 12:
                        this.f3144S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3144S);
                        break;
                    case 13:
                        this.f3140O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3140O);
                        break;
                    case 14:
                        this.f3142Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3142Q);
                        break;
                    case 15:
                        this.f3145T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3145T);
                        break;
                    case 16:
                        this.f3141P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3141P);
                        break;
                    case 17:
                        this.f3162f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3162f);
                        break;
                    case 18:
                        this.f3164g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3164g);
                        break;
                    case 19:
                        this.f3166h = typedArrayObtainStyledAttributes.getFloat(index, this.f3166h);
                        break;
                    case 20:
                        this.f3193y = typedArrayObtainStyledAttributes.getFloat(index, this.f3193y);
                        break;
                    case 21:
                        this.f3160e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f3160e);
                        break;
                    case 22:
                        this.f3158d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f3158d);
                        break;
                    case 23:
                        this.f3133H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3133H);
                        break;
                    case 24:
                        this.f3170j = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3170j);
                        break;
                    case 25:
                        this.f3172k = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3172k);
                        break;
                    case 26:
                        this.f3132G = typedArrayObtainStyledAttributes.getInt(index, this.f3132G);
                        break;
                    case 27:
                        this.f3134I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3134I);
                        break;
                    case 28:
                        this.f3174l = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3174l);
                        break;
                    case 29:
                        this.f3176m = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3176m);
                        break;
                    case 30:
                        this.f3138M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3138M);
                        break;
                    case 31:
                        this.f3189u = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3189u);
                        break;
                    case 32:
                        this.f3190v = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3190v);
                        break;
                    case 33:
                        this.f3135J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3135J);
                        break;
                    case 34:
                        this.f3180o = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3180o);
                        break;
                    case 35:
                        this.f3178n = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3178n);
                        break;
                    case 36:
                        this.f3194z = typedArrayObtainStyledAttributes.getFloat(index, this.f3194z);
                        break;
                    case 37:
                        this.f3148W = typedArrayObtainStyledAttributes.getFloat(index, this.f3148W);
                        break;
                    case 38:
                        this.f3147V = typedArrayObtainStyledAttributes.getFloat(index, this.f3147V);
                        break;
                    case 39:
                        this.f3149X = typedArrayObtainStyledAttributes.getInt(index, this.f3149X);
                        break;
                    case 40:
                        this.f3150Y = typedArrayObtainStyledAttributes.getInt(index, this.f3150Y);
                        break;
                    case 41:
                        C0585c.m3603G(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        C0585c.m3603G(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.f3127B = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3127B);
                                break;
                            case 62:
                                this.f3128C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3128C);
                                break;
                            case 63:
                                this.f3129D = typedArrayObtainStyledAttributes.getFloat(index, this.f3129D);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f3163f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f3165g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f3167h0 = typedArrayObtainStyledAttributes.getInt(index, this.f3167h0);
                                        break;
                                    case 73:
                                        this.f3169i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3169i0);
                                        break;
                                    case 74:
                                        this.f3175l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f3183p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3183p0);
                                        break;
                                    case 76:
                                        this.f3185q0 = typedArrayObtainStyledAttributes.getInt(index, this.f3185q0);
                                        break;
                                    case 77:
                                        this.f3187s = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3187s);
                                        break;
                                    case 78:
                                        this.f3188t = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3188t);
                                        break;
                                    case 79:
                                        this.f3146U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3146U);
                                        break;
                                    case 80:
                                        this.f3139N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3139N);
                                        break;
                                    case 81:
                                        this.f3151Z = typedArrayObtainStyledAttributes.getInt(index, this.f3151Z);
                                        break;
                                    case 82:
                                        this.f3153a0 = typedArrayObtainStyledAttributes.getInt(index, this.f3153a0);
                                        break;
                                    case 83:
                                        this.f3157c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3157c0);
                                        break;
                                    case 84:
                                        this.f3155b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3155b0);
                                        break;
                                    case 85:
                                        this.f3161e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3161e0);
                                        break;
                                    case 86:
                                        this.f3159d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f3159d0);
                                        break;
                                    case 87:
                                        this.f3179n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3179n0);
                                        break;
                                    case 88:
                                        this.f3181o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f3181o0);
                                        break;
                                    case 89:
                                        this.f3177m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f3168i = typedArrayObtainStyledAttributes.getBoolean(index, this.f3168i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f3125r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f3125r0.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c */
    public static class c {

        /* renamed from: o */
        public static SparseIntArray f3195o;

        /* renamed from: a */
        public boolean f3196a = false;

        /* renamed from: b */
        public int f3197b = -1;

        /* renamed from: c */
        public int f3198c = 0;

        /* renamed from: d */
        public String f3199d = null;

        /* renamed from: e */
        public int f3200e = -1;

        /* renamed from: f */
        public int f3201f = 0;

        /* renamed from: g */
        public float f3202g = Float.NaN;

        /* renamed from: h */
        public int f3203h = -1;

        /* renamed from: i */
        public float f3204i = Float.NaN;

        /* renamed from: j */
        public float f3205j = Float.NaN;

        /* renamed from: k */
        public int f3206k = -1;

        /* renamed from: l */
        public String f3207l = null;

        /* renamed from: m */
        public int f3208m = -3;

        /* renamed from: n */
        public int f3209n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3195o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f3195o.append(R$styleable.Motion_pathMotionArc, 2);
            f3195o.append(R$styleable.Motion_transitionEasing, 3);
            f3195o.append(R$styleable.Motion_drawPath, 4);
            f3195o.append(R$styleable.Motion_animateRelativeTo, 5);
            f3195o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f3195o.append(R$styleable.Motion_motionStagger, 7);
            f3195o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f3195o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f3195o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        /* renamed from: a */
        public void m3664a(c cVar) {
            this.f3196a = cVar.f3196a;
            this.f3197b = cVar.f3197b;
            this.f3199d = cVar.f3199d;
            this.f3200e = cVar.f3200e;
            this.f3201f = cVar.f3201f;
            this.f3204i = cVar.f3204i;
            this.f3202g = cVar.f3202g;
            this.f3203h = cVar.f3203h;
        }

        /* renamed from: b */
        public void m3665b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.f3196a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f3195o.get(index)) {
                    case 1:
                        this.f3204i = typedArrayObtainStyledAttributes.getFloat(index, this.f3204i);
                        break;
                    case 2:
                        this.f3200e = typedArrayObtainStyledAttributes.getInt(index, this.f3200e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f3199d = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f3199d = C11770c.f54392c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f3201f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f3197b = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3197b);
                        break;
                    case 6:
                        this.f3198c = typedArrayObtainStyledAttributes.getInteger(index, this.f3198c);
                        break;
                    case 7:
                        this.f3202g = typedArrayObtainStyledAttributes.getFloat(index, this.f3202g);
                        break;
                    case 8:
                        this.f3206k = typedArrayObtainStyledAttributes.getInteger(index, this.f3206k);
                        break;
                    case 9:
                        this.f3205j = typedArrayObtainStyledAttributes.getFloat(index, this.f3205j);
                        break;
                    case 10:
                        int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f3209n = resourceId;
                            if (resourceId != -1) {
                                this.f3208m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i11 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f3207l = string;
                            if (string.indexOf("/") > 0) {
                                this.f3209n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f3208m = -2;
                                break;
                            } else {
                                this.f3208m = -1;
                                break;
                            }
                        } else {
                            this.f3208m = typedArrayObtainStyledAttributes.getInteger(index, this.f3209n);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$d */
    public static class d {

        /* renamed from: a */
        public boolean f3210a = false;

        /* renamed from: b */
        public int f3211b = 0;

        /* renamed from: c */
        public int f3212c = 0;

        /* renamed from: d */
        public float f3213d = 1.0f;

        /* renamed from: e */
        public float f3214e = Float.NaN;

        /* renamed from: a */
        public void m3666a(d dVar) {
            this.f3210a = dVar.f3210a;
            this.f3211b = dVar.f3211b;
            this.f3213d = dVar.f3213d;
            this.f3214e = dVar.f3214e;
            this.f3212c = dVar.f3212c;
        }

        /* renamed from: b */
        public void m3667b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.f3210a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f3213d = typedArrayObtainStyledAttributes.getFloat(index, this.f3213d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.f3211b = typedArrayObtainStyledAttributes.getInt(index, this.f3211b);
                    this.f3211b = C0585c.f3094i[this.f3211b];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.f3212c = typedArrayObtainStyledAttributes.getInt(index, this.f3212c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f3214e = typedArrayObtainStyledAttributes.getFloat(index, this.f3214e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$e */
    public static class e {

        /* renamed from: o */
        public static SparseIntArray f3215o;

        /* renamed from: a */
        public boolean f3216a = false;

        /* renamed from: b */
        public float f3217b = 0.0f;

        /* renamed from: c */
        public float f3218c = 0.0f;

        /* renamed from: d */
        public float f3219d = 0.0f;

        /* renamed from: e */
        public float f3220e = 1.0f;

        /* renamed from: f */
        public float f3221f = 1.0f;

        /* renamed from: g */
        public float f3222g = Float.NaN;

        /* renamed from: h */
        public float f3223h = Float.NaN;

        /* renamed from: i */
        public int f3224i = -1;

        /* renamed from: j */
        public float f3225j = 0.0f;

        /* renamed from: k */
        public float f3226k = 0.0f;

        /* renamed from: l */
        public float f3227l = 0.0f;

        /* renamed from: m */
        public boolean f3228m = false;

        /* renamed from: n */
        public float f3229n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3215o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            f3215o.append(R$styleable.Transform_android_rotationX, 2);
            f3215o.append(R$styleable.Transform_android_rotationY, 3);
            f3215o.append(R$styleable.Transform_android_scaleX, 4);
            f3215o.append(R$styleable.Transform_android_scaleY, 5);
            f3215o.append(R$styleable.Transform_android_transformPivotX, 6);
            f3215o.append(R$styleable.Transform_android_transformPivotY, 7);
            f3215o.append(R$styleable.Transform_android_translationX, 8);
            f3215o.append(R$styleable.Transform_android_translationY, 9);
            f3215o.append(R$styleable.Transform_android_translationZ, 10);
            f3215o.append(R$styleable.Transform_android_elevation, 11);
            f3215o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        /* renamed from: a */
        public void m3668a(e eVar) {
            this.f3216a = eVar.f3216a;
            this.f3217b = eVar.f3217b;
            this.f3218c = eVar.f3218c;
            this.f3219d = eVar.f3219d;
            this.f3220e = eVar.f3220e;
            this.f3221f = eVar.f3221f;
            this.f3222g = eVar.f3222g;
            this.f3223h = eVar.f3223h;
            this.f3224i = eVar.f3224i;
            this.f3225j = eVar.f3225j;
            this.f3226k = eVar.f3226k;
            this.f3227l = eVar.f3227l;
            this.f3228m = eVar.f3228m;
            this.f3229n = eVar.f3229n;
        }

        /* renamed from: b */
        public void m3669b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.f3216a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f3215o.get(index)) {
                    case 1:
                        this.f3217b = typedArrayObtainStyledAttributes.getFloat(index, this.f3217b);
                        break;
                    case 2:
                        this.f3218c = typedArrayObtainStyledAttributes.getFloat(index, this.f3218c);
                        break;
                    case 3:
                        this.f3219d = typedArrayObtainStyledAttributes.getFloat(index, this.f3219d);
                        break;
                    case 4:
                        this.f3220e = typedArrayObtainStyledAttributes.getFloat(index, this.f3220e);
                        break;
                    case 5:
                        this.f3221f = typedArrayObtainStyledAttributes.getFloat(index, this.f3221f);
                        break;
                    case 6:
                        this.f3222g = typedArrayObtainStyledAttributes.getDimension(index, this.f3222g);
                        break;
                    case 7:
                        this.f3223h = typedArrayObtainStyledAttributes.getDimension(index, this.f3223h);
                        break;
                    case 8:
                        this.f3225j = typedArrayObtainStyledAttributes.getDimension(index, this.f3225j);
                        break;
                    case 9:
                        this.f3226k = typedArrayObtainStyledAttributes.getDimension(index, this.f3226k);
                        break;
                    case 10:
                        this.f3227l = typedArrayObtainStyledAttributes.getDimension(index, this.f3227l);
                        break;
                    case 11:
                        this.f3228m = true;
                        this.f3229n = typedArrayObtainStyledAttributes.getDimension(index, this.f3229n);
                        break;
                    case 12:
                        this.f3224i = C0585c.m3602F(typedArrayObtainStyledAttributes, index, this.f3224i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f3095j.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f3095j.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f3095j.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f3095j.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f3095j.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f3095j.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f3095j.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f3095j.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f3095j.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f3095j.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f3095j.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f3095j.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f3095j.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f3095j.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f3095j.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f3095j.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f3095j.append(R$styleable.Constraint_guidelineUseRtl, 99);
        f3095j.append(R$styleable.Constraint_android_orientation, 27);
        f3095j.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f3095j.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f3095j.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f3095j.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f3095j.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f3095j.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f3095j.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f3095j.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f3095j.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f3095j.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f3095j.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f3095j.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f3095j.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f3095j.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f3095j.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f3095j.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f3095j.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f3095j.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f3095j.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f3095j.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f3095j.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f3095j.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f3095j.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f3095j.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f3095j.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f3095j.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f3095j.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f3095j.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f3095j.append(R$styleable.Constraint_android_layout_width, 23);
        f3095j.append(R$styleable.Constraint_android_layout_height, 21);
        f3095j.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f3095j.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f3095j.append(R$styleable.Constraint_android_visibility, 22);
        f3095j.append(R$styleable.Constraint_android_alpha, 43);
        f3095j.append(R$styleable.Constraint_android_elevation, 44);
        f3095j.append(R$styleable.Constraint_android_rotationX, 45);
        f3095j.append(R$styleable.Constraint_android_rotationY, 46);
        f3095j.append(R$styleable.Constraint_android_rotation, 60);
        f3095j.append(R$styleable.Constraint_android_scaleX, 47);
        f3095j.append(R$styleable.Constraint_android_scaleY, 48);
        f3095j.append(R$styleable.Constraint_android_transformPivotX, 49);
        f3095j.append(R$styleable.Constraint_android_transformPivotY, 50);
        f3095j.append(R$styleable.Constraint_android_translationX, 51);
        f3095j.append(R$styleable.Constraint_android_translationY, 52);
        f3095j.append(R$styleable.Constraint_android_translationZ, 53);
        f3095j.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f3095j.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f3095j.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f3095j.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f3095j.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f3095j.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f3095j.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f3095j.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f3095j.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f3095j.append(R$styleable.Constraint_animateRelativeTo, 64);
        f3095j.append(R$styleable.Constraint_transitionEasing, 65);
        f3095j.append(R$styleable.Constraint_drawPath, 66);
        f3095j.append(R$styleable.Constraint_transitionPathRotate, 67);
        f3095j.append(R$styleable.Constraint_motionStagger, 79);
        f3095j.append(R$styleable.Constraint_android_id, 38);
        f3095j.append(R$styleable.Constraint_motionProgress, 68);
        f3095j.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f3095j.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f3095j.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f3095j.append(R$styleable.Constraint_chainUseRtl, 71);
        f3095j.append(R$styleable.Constraint_barrierDirection, 72);
        f3095j.append(R$styleable.Constraint_barrierMargin, 73);
        f3095j.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f3095j.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f3095j.append(R$styleable.Constraint_pathMotionArc, 76);
        f3095j.append(R$styleable.Constraint_layout_constraintTag, 77);
        f3095j.append(R$styleable.Constraint_visibilityMode, 78);
        f3095j.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f3095j.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f3095j.append(R$styleable.Constraint_polarRelativeTo, 82);
        f3095j.append(R$styleable.Constraint_transformPivotTarget, 83);
        f3095j.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f3095j.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f3095j.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f3096k;
        int i10 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i10, 6);
        f3096k.append(i10, 7);
        f3096k.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f3096k.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f3096k.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f3096k.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f3096k.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f3096k.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f3096k.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f3096k.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f3096k.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f3096k.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f3096k.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f3096k.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f3096k.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f3096k.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f3096k.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f3096k.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f3096k.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f3096k.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f3096k.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f3096k.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f3096k.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f3096k.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f3096k.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f3096k.append(R$styleable.ConstraintOverride_drawPath, 66);
        f3096k.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f3096k.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f3096k.append(R$styleable.ConstraintOverride_android_id, 38);
        f3096k.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f3096k.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f3096k.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f3096k.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f3096k.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f3096k.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f3096k.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f3096k.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f3096k.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f3096k.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f3096k.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f3096k.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f3096k.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f3096k.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f3096k.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f3096k.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f3096k.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f3096k.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    /* renamed from: F */
    public static int m3602F(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0041  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m3603G(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) throws java.lang.NumberFormatException {
        /*
            if (r4 != 0) goto L3
            return
        L3:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L71
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2a
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L26
            r6 = -3
            if (r5 == r6) goto L20
            if (r5 == r0) goto L22
            r6 = -1
            if (r5 == r6) goto L22
        L20:
            r5 = r2
            goto L2f
        L22:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L2f
        L26:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L2f
        L2a:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L22
        L2f:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r6 == 0) goto L41
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            if (r7 != 0) goto L3c
            r4.width = r2
            r4.f2977a0 = r5
            goto L70
        L3c:
            r4.height = r2
            r4.f2979b0 = r5
            goto L70
        L41:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.C0585c.b
            if (r6 == 0) goto L53
            androidx.constraintlayout.widget.c$b r4 = (androidx.constraintlayout.widget.C0585c.b) r4
            if (r7 != 0) goto L4e
            r4.f3158d = r2
            r4.f3179n0 = r5
            goto L70
        L4e:
            r4.f3160e = r2
            r4.f3181o0 = r5
            goto L70
        L53:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.C0585c.a.C14406a
            if (r6 == 0) goto L70
            androidx.constraintlayout.widget.c$a$a r4 = (androidx.constraintlayout.widget.C0585c.a.C14406a) r4
            if (r7 != 0) goto L66
            r6 = 23
            r4.m3658b(r6, r2)
            r6 = 80
            r4.m3660d(r6, r5)
            goto L70
        L66:
            r6 = 21
            r4.m3658b(r6, r2)
            r6 = 81
            r4.m3660d(r6, r5)
        L70:
            return
        L71:
            java.lang.String r5 = r5.getString(r6)
            m3604H(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.C0585c.m3603G(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    /* renamed from: H */
    public static void m3604H(Object obj, String str, int i10) throws NumberFormatException {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i10 == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                    }
                    m3605I(layoutParams, strTrim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f3126A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C14406a) {
                        ((a.C14406a) obj).m3659c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f10 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                            layoutParams2.f2961L = f10;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                            layoutParams2.f2962M = f10;
                        }
                    } else if (obj instanceof b) {
                        b bVar = (b) obj;
                        if (i10 == 0) {
                            bVar.f3158d = 0;
                            bVar.f3148W = f10;
                        } else {
                            bVar.f3160e = 0;
                            bVar.f3147V = f10;
                        }
                    } else if (obj instanceof a.C14406a) {
                        a.C14406a c14406a = (a.C14406a) obj;
                        if (i10 == 0) {
                            c14406a.m3658b(23, 0);
                            c14406a.m3657a(39, f10);
                        } else {
                            c14406a.m3658b(21, 0);
                            c14406a.m3657a(40, f10);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                            layoutParams3.f2971V = fMax;
                            layoutParams3.f2965P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                            layoutParams3.f2972W = fMax;
                            layoutParams3.f2966Q = 2;
                        }
                    } else if (obj instanceof b) {
                        b bVar2 = (b) obj;
                        if (i10 == 0) {
                            bVar2.f3158d = 0;
                            bVar2.f3163f0 = fMax;
                            bVar2.f3151Z = 2;
                        } else {
                            bVar2.f3160e = 0;
                            bVar2.f3165g0 = fMax;
                            bVar2.f3153a0 = 2;
                        }
                    } else if (obj instanceof a.C14406a) {
                        a.C14406a c14406a2 = (a.C14406a) obj;
                        if (i10 == 0) {
                            c14406a2.m3658b(23, 0);
                            c14406a2.m3658b(54, 2);
                        } else {
                            c14406a2.m3658b(21, 0);
                            c14406a2.m3658b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* renamed from: I */
    public static void m3605I(ConstraintLayout.LayoutParams layoutParams, String str) throws NumberFormatException {
        float fAbs = Float.NaN;
        int i10 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i11 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i10 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i10 = 1;
                }
                i11 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i11);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i11, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 > 0.0f && f11 > 0.0f) {
                            fAbs = i10 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.f2958I = str;
        layoutParams.f2959J = fAbs;
        layoutParams.f2960K = i10;
    }

    /* renamed from: K */
    public static void m3606K(a aVar, TypedArray typedArray) throws NumberFormatException {
        int indexCount = typedArray.getIndexCount();
        a.C14406a c14406a = new a.C14406a();
        aVar.f3112h = c14406a;
        aVar.f3108d.f3196a = false;
        aVar.f3109e.f3154b = false;
        aVar.f3107c.f3210a = false;
        aVar.f3110f.f3216a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            switch (f3096k.get(index)) {
                case 2:
                    c14406a.m3658b(2, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3136K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f3095j.get(index));
                    break;
                case 5:
                    c14406a.m3659c(5, typedArray.getString(index));
                    break;
                case 6:
                    c14406a.m3658b(6, typedArray.getDimensionPixelOffset(index, aVar.f3109e.f3130E));
                    break;
                case 7:
                    c14406a.m3658b(7, typedArray.getDimensionPixelOffset(index, aVar.f3109e.f3131F));
                    break;
                case 8:
                    c14406a.m3658b(8, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3137L));
                    break;
                case 11:
                    c14406a.m3658b(11, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3143R));
                    break;
                case 12:
                    c14406a.m3658b(12, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3144S));
                    break;
                case 13:
                    c14406a.m3658b(13, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3140O));
                    break;
                case 14:
                    c14406a.m3658b(14, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3142Q));
                    break;
                case 15:
                    c14406a.m3658b(15, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3145T));
                    break;
                case 16:
                    c14406a.m3658b(16, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3141P));
                    break;
                case 17:
                    c14406a.m3658b(17, typedArray.getDimensionPixelOffset(index, aVar.f3109e.f3162f));
                    break;
                case 18:
                    c14406a.m3658b(18, typedArray.getDimensionPixelOffset(index, aVar.f3109e.f3164g));
                    break;
                case 19:
                    c14406a.m3657a(19, typedArray.getFloat(index, aVar.f3109e.f3166h));
                    break;
                case 20:
                    c14406a.m3657a(20, typedArray.getFloat(index, aVar.f3109e.f3193y));
                    break;
                case 21:
                    c14406a.m3658b(21, typedArray.getLayoutDimension(index, aVar.f3109e.f3160e));
                    break;
                case 22:
                    c14406a.m3658b(22, f3094i[typedArray.getInt(index, aVar.f3107c.f3211b)]);
                    break;
                case 23:
                    c14406a.m3658b(23, typedArray.getLayoutDimension(index, aVar.f3109e.f3158d));
                    break;
                case 24:
                    c14406a.m3658b(24, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3133H));
                    break;
                case 27:
                    c14406a.m3658b(27, typedArray.getInt(index, aVar.f3109e.f3132G));
                    break;
                case 28:
                    c14406a.m3658b(28, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3134I));
                    break;
                case 31:
                    c14406a.m3658b(31, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3138M));
                    break;
                case 34:
                    c14406a.m3658b(34, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3135J));
                    break;
                case 37:
                    c14406a.m3657a(37, typedArray.getFloat(index, aVar.f3109e.f3194z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f3105a);
                    aVar.f3105a = resourceId;
                    c14406a.m3658b(38, resourceId);
                    break;
                case 39:
                    c14406a.m3657a(39, typedArray.getFloat(index, aVar.f3109e.f3148W));
                    break;
                case 40:
                    c14406a.m3657a(40, typedArray.getFloat(index, aVar.f3109e.f3147V));
                    break;
                case 41:
                    c14406a.m3658b(41, typedArray.getInt(index, aVar.f3109e.f3149X));
                    break;
                case 42:
                    c14406a.m3658b(42, typedArray.getInt(index, aVar.f3109e.f3150Y));
                    break;
                case 43:
                    c14406a.m3657a(43, typedArray.getFloat(index, aVar.f3107c.f3213d));
                    break;
                case 44:
                    c14406a.m3660d(44, true);
                    c14406a.m3657a(44, typedArray.getDimension(index, aVar.f3110f.f3229n));
                    break;
                case 45:
                    c14406a.m3657a(45, typedArray.getFloat(index, aVar.f3110f.f3218c));
                    break;
                case 46:
                    c14406a.m3657a(46, typedArray.getFloat(index, aVar.f3110f.f3219d));
                    break;
                case 47:
                    c14406a.m3657a(47, typedArray.getFloat(index, aVar.f3110f.f3220e));
                    break;
                case 48:
                    c14406a.m3657a(48, typedArray.getFloat(index, aVar.f3110f.f3221f));
                    break;
                case 49:
                    c14406a.m3657a(49, typedArray.getDimension(index, aVar.f3110f.f3222g));
                    break;
                case 50:
                    c14406a.m3657a(50, typedArray.getDimension(index, aVar.f3110f.f3223h));
                    break;
                case 51:
                    c14406a.m3657a(51, typedArray.getDimension(index, aVar.f3110f.f3225j));
                    break;
                case 52:
                    c14406a.m3657a(52, typedArray.getDimension(index, aVar.f3110f.f3226k));
                    break;
                case 53:
                    c14406a.m3657a(53, typedArray.getDimension(index, aVar.f3110f.f3227l));
                    break;
                case 54:
                    c14406a.m3658b(54, typedArray.getInt(index, aVar.f3109e.f3151Z));
                    break;
                case 55:
                    c14406a.m3658b(55, typedArray.getInt(index, aVar.f3109e.f3153a0));
                    break;
                case 56:
                    c14406a.m3658b(56, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3155b0));
                    break;
                case 57:
                    c14406a.m3658b(57, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3157c0));
                    break;
                case 58:
                    c14406a.m3658b(58, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3159d0));
                    break;
                case 59:
                    c14406a.m3658b(59, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3161e0));
                    break;
                case 60:
                    c14406a.m3657a(60, typedArray.getFloat(index, aVar.f3110f.f3217b));
                    break;
                case 62:
                    c14406a.m3658b(62, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3128C));
                    break;
                case 63:
                    c14406a.m3657a(63, typedArray.getFloat(index, aVar.f3109e.f3129D));
                    break;
                case 64:
                    c14406a.m3658b(64, m3602F(typedArray, index, aVar.f3108d.f3197b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c14406a.m3659c(65, typedArray.getString(index));
                        break;
                    } else {
                        c14406a.m3659c(65, C11770c.f54392c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    c14406a.m3658b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c14406a.m3657a(67, typedArray.getFloat(index, aVar.f3108d.f3204i));
                    break;
                case 68:
                    c14406a.m3657a(68, typedArray.getFloat(index, aVar.f3107c.f3214e));
                    break;
                case 69:
                    c14406a.m3657a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c14406a.m3657a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c14406a.m3658b(72, typedArray.getInt(index, aVar.f3109e.f3167h0));
                    break;
                case 73:
                    c14406a.m3658b(73, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3169i0));
                    break;
                case 74:
                    c14406a.m3659c(74, typedArray.getString(index));
                    break;
                case 75:
                    c14406a.m3660d(75, typedArray.getBoolean(index, aVar.f3109e.f3183p0));
                    break;
                case 76:
                    c14406a.m3658b(76, typedArray.getInt(index, aVar.f3108d.f3200e));
                    break;
                case 77:
                    c14406a.m3659c(77, typedArray.getString(index));
                    break;
                case 78:
                    c14406a.m3658b(78, typedArray.getInt(index, aVar.f3107c.f3212c));
                    break;
                case 79:
                    c14406a.m3657a(79, typedArray.getFloat(index, aVar.f3108d.f3202g));
                    break;
                case 80:
                    c14406a.m3660d(80, typedArray.getBoolean(index, aVar.f3109e.f3179n0));
                    break;
                case 81:
                    c14406a.m3660d(81, typedArray.getBoolean(index, aVar.f3109e.f3181o0));
                    break;
                case 82:
                    c14406a.m3658b(82, typedArray.getInteger(index, aVar.f3108d.f3198c));
                    break;
                case 83:
                    c14406a.m3658b(83, m3602F(typedArray, index, aVar.f3110f.f3224i));
                    break;
                case 84:
                    c14406a.m3658b(84, typedArray.getInteger(index, aVar.f3108d.f3206k));
                    break;
                case 85:
                    c14406a.m3657a(85, typedArray.getFloat(index, aVar.f3108d.f3205j));
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f3108d.f3209n = typedArray.getResourceId(index, -1);
                        c14406a.m3658b(89, aVar.f3108d.f3209n);
                        c cVar = aVar.f3108d;
                        if (cVar.f3209n != -1) {
                            cVar.f3208m = -2;
                            c14406a.m3658b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i11 == 3) {
                        aVar.f3108d.f3207l = typedArray.getString(index);
                        c14406a.m3659c(90, aVar.f3108d.f3207l);
                        if (aVar.f3108d.f3207l.indexOf("/") > 0) {
                            aVar.f3108d.f3209n = typedArray.getResourceId(index, -1);
                            c14406a.m3658b(89, aVar.f3108d.f3209n);
                            aVar.f3108d.f3208m = -2;
                            c14406a.m3658b(88, -2);
                            break;
                        } else {
                            aVar.f3108d.f3208m = -1;
                            c14406a.m3658b(88, -1);
                            break;
                        }
                    } else {
                        c cVar2 = aVar.f3108d;
                        cVar2.f3208m = typedArray.getInteger(index, cVar2.f3209n);
                        c14406a.m3658b(88, aVar.f3108d.f3208m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f3095j.get(index));
                    break;
                case 93:
                    c14406a.m3658b(93, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3139N));
                    break;
                case 94:
                    c14406a.m3658b(94, typedArray.getDimensionPixelSize(index, aVar.f3109e.f3146U));
                    break;
                case 95:
                    m3603G(c14406a, typedArray, index, 0);
                    break;
                case 96:
                    m3603G(c14406a, typedArray, index, 1);
                    break;
                case 97:
                    c14406a.m3658b(97, typedArray.getInt(index, aVar.f3109e.f3185q0));
                    break;
                case 98:
                    if (MotionLayout.f2560E0) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f3105a);
                        aVar.f3105a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f3106b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f3106b = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f3105a = typedArray.getResourceId(index, aVar.f3105a);
                        break;
                    }
                case 99:
                    c14406a.m3660d(99, typedArray.getBoolean(index, aVar.f3109e.f3168i));
                    break;
            }
        }
    }

    /* renamed from: N */
    public static void m3607N(a aVar, int i10, float f10) {
        if (i10 == 19) {
            aVar.f3109e.f3166h = f10;
        }
        if (i10 == 20) {
            aVar.f3109e.f3193y = f10;
            return;
        }
        if (i10 == 37) {
            aVar.f3109e.f3194z = f10;
            return;
        }
        if (i10 == 60) {
            aVar.f3110f.f3217b = f10;
            return;
        }
        if (i10 == 63) {
            aVar.f3109e.f3129D = f10;
            return;
        }
        if (i10 == 79) {
            aVar.f3108d.f3202g = f10;
            return;
        }
        if (i10 == 85) {
            aVar.f3108d.f3205j = f10;
            return;
        }
        if (i10 != 87) {
            if (i10 == 39) {
                aVar.f3109e.f3148W = f10;
                return;
            }
            if (i10 == 40) {
                aVar.f3109e.f3147V = f10;
                return;
            }
            switch (i10) {
                case 43:
                    aVar.f3107c.f3213d = f10;
                    break;
                case 44:
                    e eVar = aVar.f3110f;
                    eVar.f3229n = f10;
                    eVar.f3228m = true;
                    break;
                case 45:
                    aVar.f3110f.f3218c = f10;
                    break;
                case 46:
                    aVar.f3110f.f3219d = f10;
                    break;
                case 47:
                    aVar.f3110f.f3220e = f10;
                    break;
                case 48:
                    aVar.f3110f.f3221f = f10;
                    break;
                case 49:
                    aVar.f3110f.f3222g = f10;
                    break;
                case 50:
                    aVar.f3110f.f3223h = f10;
                    break;
                case 51:
                    aVar.f3110f.f3225j = f10;
                    break;
                case 52:
                    aVar.f3110f.f3226k = f10;
                    break;
                case 53:
                    aVar.f3110f.f3227l = f10;
                    break;
                default:
                    switch (i10) {
                        case 67:
                            aVar.f3108d.f3204i = f10;
                            break;
                        case 68:
                            aVar.f3107c.f3214e = f10;
                            break;
                        case 69:
                            aVar.f3109e.f3163f0 = f10;
                            break;
                        case 70:
                            aVar.f3109e.f3165g0 = f10;
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            break;
                    }
            }
        }
    }

    /* renamed from: O */
    public static void m3608O(a aVar, int i10, int i11) {
        if (i10 == 6) {
            aVar.f3109e.f3130E = i11;
        }
        if (i10 == 7) {
            aVar.f3109e.f3131F = i11;
            return;
        }
        if (i10 == 8) {
            aVar.f3109e.f3137L = i11;
            return;
        }
        if (i10 == 27) {
            aVar.f3109e.f3132G = i11;
            return;
        }
        if (i10 == 28) {
            aVar.f3109e.f3134I = i11;
            return;
        }
        if (i10 == 41) {
            aVar.f3109e.f3149X = i11;
            return;
        }
        if (i10 == 42) {
            aVar.f3109e.f3150Y = i11;
            return;
        }
        if (i10 == 61) {
            aVar.f3109e.f3127B = i11;
            return;
        }
        if (i10 == 62) {
            aVar.f3109e.f3128C = i11;
            return;
        }
        if (i10 == 72) {
            aVar.f3109e.f3167h0 = i11;
            return;
        }
        if (i10 == 73) {
            aVar.f3109e.f3169i0 = i11;
            return;
        }
        switch (i10) {
            case 2:
                aVar.f3109e.f3136K = i11;
                break;
            case 11:
                aVar.f3109e.f3143R = i11;
                break;
            case 12:
                aVar.f3109e.f3144S = i11;
                break;
            case 13:
                aVar.f3109e.f3140O = i11;
                break;
            case 14:
                aVar.f3109e.f3142Q = i11;
                break;
            case 15:
                aVar.f3109e.f3145T = i11;
                break;
            case 16:
                aVar.f3109e.f3141P = i11;
                break;
            case 17:
                aVar.f3109e.f3162f = i11;
                break;
            case 18:
                aVar.f3109e.f3164g = i11;
                break;
            case 31:
                aVar.f3109e.f3138M = i11;
                break;
            case 34:
                aVar.f3109e.f3135J = i11;
                break;
            case 38:
                aVar.f3105a = i11;
                break;
            case 64:
                aVar.f3108d.f3197b = i11;
                break;
            case 66:
                aVar.f3108d.f3201f = i11;
                break;
            case 76:
                aVar.f3108d.f3200e = i11;
                break;
            case 78:
                aVar.f3107c.f3212c = i11;
                break;
            case 93:
                aVar.f3109e.f3139N = i11;
                break;
            case 94:
                aVar.f3109e.f3146U = i11;
                break;
            case 97:
                aVar.f3109e.f3185q0 = i11;
                break;
            default:
                switch (i10) {
                    case 21:
                        aVar.f3109e.f3160e = i11;
                        break;
                    case 22:
                        aVar.f3107c.f3211b = i11;
                        break;
                    case 23:
                        aVar.f3109e.f3158d = i11;
                        break;
                    case 24:
                        aVar.f3109e.f3133H = i11;
                        break;
                    default:
                        switch (i10) {
                            case 54:
                                aVar.f3109e.f3151Z = i11;
                                break;
                            case 55:
                                aVar.f3109e.f3153a0 = i11;
                                break;
                            case 56:
                                aVar.f3109e.f3155b0 = i11;
                                break;
                            case 57:
                                aVar.f3109e.f3157c0 = i11;
                                break;
                            case 58:
                                aVar.f3109e.f3159d0 = i11;
                                break;
                            case 59:
                                aVar.f3109e.f3161e0 = i11;
                                break;
                            default:
                                switch (i10) {
                                    case 82:
                                        aVar.f3108d.f3198c = i11;
                                        break;
                                    case 83:
                                        aVar.f3110f.f3224i = i11;
                                        break;
                                    case 84:
                                        aVar.f3108d.f3206k = i11;
                                        break;
                                    default:
                                        switch (i10) {
                                            case 87:
                                                break;
                                            case 88:
                                                aVar.f3108d.f3208m = i11;
                                                break;
                                            case 89:
                                                aVar.f3108d.f3209n = i11;
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                break;
                                        }
                                }
                        }
                }
        }
    }

    /* renamed from: P */
    public static void m3609P(a aVar, int i10, String str) {
        if (i10 == 5) {
            aVar.f3109e.f3126A = str;
            return;
        }
        if (i10 == 65) {
            aVar.f3108d.f3199d = str;
            return;
        }
        if (i10 == 74) {
            b bVar = aVar.f3109e;
            bVar.f3175l0 = str;
            bVar.f3173k0 = null;
        } else if (i10 == 77) {
            aVar.f3109e.f3177m0 = str;
        } else if (i10 != 87) {
            if (i10 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f3108d.f3207l = str;
            }
        }
    }

    /* renamed from: Q */
    public static void m3610Q(a aVar, int i10, boolean z10) {
        if (i10 == 44) {
            aVar.f3110f.f3228m = z10;
            return;
        }
        if (i10 == 75) {
            aVar.f3109e.f3183p0 = z10;
            return;
        }
        if (i10 != 87) {
            if (i10 == 80) {
                aVar.f3109e.f3179n0 = z10;
            } else if (i10 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f3109e.f3181o0 = z10;
            }
        }
    }

    /* renamed from: m */
    public static a m3617m(Context context, XmlPullParser xmlPullParser) throws NumberFormatException {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R$styleable.ConstraintOverride);
        m3606K(aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    /* renamed from: A */
    public int m3618A(int i10) {
        return m3643v(i10).f3107c.f3211b;
    }

    /* renamed from: B */
    public int m3619B(int i10) {
        return m3643v(i10).f3107c.f3212c;
    }

    /* renamed from: C */
    public int m3620C(int i10) {
        return m3643v(i10).f3109e.f3158d;
    }

    /* renamed from: D */
    public void m3621D(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    a aVarM3642u = m3642u(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarM3642u.f3109e.f3152a = true;
                    }
                    this.f3104h.put(Integer.valueOf(aVarM3642u.f3105a), aVarM3642u);
                }
            }
        } catch (IOException e10) {
            Log.e("ConstraintSet", "Error parsing resource: " + i10, e10);
        } catch (XmlPullParserException e11) {
            Log.e("ConstraintSet", "Error parsing resource: " + i10, e11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:251:0x01d3, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3622E(android.content.Context r12, org.xmlpull.v1.XmlPullParser r13) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.C0585c.m3622E(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* renamed from: J */
    public final void m3623J(a aVar, TypedArray typedArray, boolean z10) throws NumberFormatException {
        if (z10) {
            m3606K(aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                aVar.f3108d.f3196a = true;
                aVar.f3109e.f3154b = true;
                aVar.f3107c.f3210a = true;
                aVar.f3110f.f3216a = true;
            }
            switch (f3095j.get(index)) {
                case 1:
                    b bVar = aVar.f3109e;
                    bVar.f3186r = m3602F(typedArray, index, bVar.f3186r);
                    break;
                case 2:
                    b bVar2 = aVar.f3109e;
                    bVar2.f3136K = typedArray.getDimensionPixelSize(index, bVar2.f3136K);
                    break;
                case 3:
                    b bVar3 = aVar.f3109e;
                    bVar3.f3184q = m3602F(typedArray, index, bVar3.f3184q);
                    break;
                case 4:
                    b bVar4 = aVar.f3109e;
                    bVar4.f3182p = m3602F(typedArray, index, bVar4.f3182p);
                    break;
                case 5:
                    aVar.f3109e.f3126A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f3109e;
                    bVar5.f3130E = typedArray.getDimensionPixelOffset(index, bVar5.f3130E);
                    break;
                case 7:
                    b bVar6 = aVar.f3109e;
                    bVar6.f3131F = typedArray.getDimensionPixelOffset(index, bVar6.f3131F);
                    break;
                case 8:
                    b bVar7 = aVar.f3109e;
                    bVar7.f3137L = typedArray.getDimensionPixelSize(index, bVar7.f3137L);
                    break;
                case 9:
                    b bVar8 = aVar.f3109e;
                    bVar8.f3192x = m3602F(typedArray, index, bVar8.f3192x);
                    break;
                case 10:
                    b bVar9 = aVar.f3109e;
                    bVar9.f3191w = m3602F(typedArray, index, bVar9.f3191w);
                    break;
                case 11:
                    b bVar10 = aVar.f3109e;
                    bVar10.f3143R = typedArray.getDimensionPixelSize(index, bVar10.f3143R);
                    break;
                case 12:
                    b bVar11 = aVar.f3109e;
                    bVar11.f3144S = typedArray.getDimensionPixelSize(index, bVar11.f3144S);
                    break;
                case 13:
                    b bVar12 = aVar.f3109e;
                    bVar12.f3140O = typedArray.getDimensionPixelSize(index, bVar12.f3140O);
                    break;
                case 14:
                    b bVar13 = aVar.f3109e;
                    bVar13.f3142Q = typedArray.getDimensionPixelSize(index, bVar13.f3142Q);
                    break;
                case 15:
                    b bVar14 = aVar.f3109e;
                    bVar14.f3145T = typedArray.getDimensionPixelSize(index, bVar14.f3145T);
                    break;
                case 16:
                    b bVar15 = aVar.f3109e;
                    bVar15.f3141P = typedArray.getDimensionPixelSize(index, bVar15.f3141P);
                    break;
                case 17:
                    b bVar16 = aVar.f3109e;
                    bVar16.f3162f = typedArray.getDimensionPixelOffset(index, bVar16.f3162f);
                    break;
                case 18:
                    b bVar17 = aVar.f3109e;
                    bVar17.f3164g = typedArray.getDimensionPixelOffset(index, bVar17.f3164g);
                    break;
                case 19:
                    b bVar18 = aVar.f3109e;
                    bVar18.f3166h = typedArray.getFloat(index, bVar18.f3166h);
                    break;
                case 20:
                    b bVar19 = aVar.f3109e;
                    bVar19.f3193y = typedArray.getFloat(index, bVar19.f3193y);
                    break;
                case 21:
                    b bVar20 = aVar.f3109e;
                    bVar20.f3160e = typedArray.getLayoutDimension(index, bVar20.f3160e);
                    break;
                case 22:
                    d dVar = aVar.f3107c;
                    dVar.f3211b = typedArray.getInt(index, dVar.f3211b);
                    d dVar2 = aVar.f3107c;
                    dVar2.f3211b = f3094i[dVar2.f3211b];
                    break;
                case 23:
                    b bVar21 = aVar.f3109e;
                    bVar21.f3158d = typedArray.getLayoutDimension(index, bVar21.f3158d);
                    break;
                case 24:
                    b bVar22 = aVar.f3109e;
                    bVar22.f3133H = typedArray.getDimensionPixelSize(index, bVar22.f3133H);
                    break;
                case 25:
                    b bVar23 = aVar.f3109e;
                    bVar23.f3170j = m3602F(typedArray, index, bVar23.f3170j);
                    break;
                case 26:
                    b bVar24 = aVar.f3109e;
                    bVar24.f3172k = m3602F(typedArray, index, bVar24.f3172k);
                    break;
                case 27:
                    b bVar25 = aVar.f3109e;
                    bVar25.f3132G = typedArray.getInt(index, bVar25.f3132G);
                    break;
                case 28:
                    b bVar26 = aVar.f3109e;
                    bVar26.f3134I = typedArray.getDimensionPixelSize(index, bVar26.f3134I);
                    break;
                case 29:
                    b bVar27 = aVar.f3109e;
                    bVar27.f3174l = m3602F(typedArray, index, bVar27.f3174l);
                    break;
                case 30:
                    b bVar28 = aVar.f3109e;
                    bVar28.f3176m = m3602F(typedArray, index, bVar28.f3176m);
                    break;
                case 31:
                    b bVar29 = aVar.f3109e;
                    bVar29.f3138M = typedArray.getDimensionPixelSize(index, bVar29.f3138M);
                    break;
                case 32:
                    b bVar30 = aVar.f3109e;
                    bVar30.f3189u = m3602F(typedArray, index, bVar30.f3189u);
                    break;
                case 33:
                    b bVar31 = aVar.f3109e;
                    bVar31.f3190v = m3602F(typedArray, index, bVar31.f3190v);
                    break;
                case 34:
                    b bVar32 = aVar.f3109e;
                    bVar32.f3135J = typedArray.getDimensionPixelSize(index, bVar32.f3135J);
                    break;
                case 35:
                    b bVar33 = aVar.f3109e;
                    bVar33.f3180o = m3602F(typedArray, index, bVar33.f3180o);
                    break;
                case 36:
                    b bVar34 = aVar.f3109e;
                    bVar34.f3178n = m3602F(typedArray, index, bVar34.f3178n);
                    break;
                case 37:
                    b bVar35 = aVar.f3109e;
                    bVar35.f3194z = typedArray.getFloat(index, bVar35.f3194z);
                    break;
                case 38:
                    aVar.f3105a = typedArray.getResourceId(index, aVar.f3105a);
                    break;
                case 39:
                    b bVar36 = aVar.f3109e;
                    bVar36.f3148W = typedArray.getFloat(index, bVar36.f3148W);
                    break;
                case 40:
                    b bVar37 = aVar.f3109e;
                    bVar37.f3147V = typedArray.getFloat(index, bVar37.f3147V);
                    break;
                case 41:
                    b bVar38 = aVar.f3109e;
                    bVar38.f3149X = typedArray.getInt(index, bVar38.f3149X);
                    break;
                case 42:
                    b bVar39 = aVar.f3109e;
                    bVar39.f3150Y = typedArray.getInt(index, bVar39.f3150Y);
                    break;
                case 43:
                    d dVar3 = aVar.f3107c;
                    dVar3.f3213d = typedArray.getFloat(index, dVar3.f3213d);
                    break;
                case 44:
                    e eVar = aVar.f3110f;
                    eVar.f3228m = true;
                    eVar.f3229n = typedArray.getDimension(index, eVar.f3229n);
                    break;
                case 45:
                    e eVar2 = aVar.f3110f;
                    eVar2.f3218c = typedArray.getFloat(index, eVar2.f3218c);
                    break;
                case 46:
                    e eVar3 = aVar.f3110f;
                    eVar3.f3219d = typedArray.getFloat(index, eVar3.f3219d);
                    break;
                case 47:
                    e eVar4 = aVar.f3110f;
                    eVar4.f3220e = typedArray.getFloat(index, eVar4.f3220e);
                    break;
                case 48:
                    e eVar5 = aVar.f3110f;
                    eVar5.f3221f = typedArray.getFloat(index, eVar5.f3221f);
                    break;
                case 49:
                    e eVar6 = aVar.f3110f;
                    eVar6.f3222g = typedArray.getDimension(index, eVar6.f3222g);
                    break;
                case 50:
                    e eVar7 = aVar.f3110f;
                    eVar7.f3223h = typedArray.getDimension(index, eVar7.f3223h);
                    break;
                case 51:
                    e eVar8 = aVar.f3110f;
                    eVar8.f3225j = typedArray.getDimension(index, eVar8.f3225j);
                    break;
                case 52:
                    e eVar9 = aVar.f3110f;
                    eVar9.f3226k = typedArray.getDimension(index, eVar9.f3226k);
                    break;
                case 53:
                    e eVar10 = aVar.f3110f;
                    eVar10.f3227l = typedArray.getDimension(index, eVar10.f3227l);
                    break;
                case 54:
                    b bVar40 = aVar.f3109e;
                    bVar40.f3151Z = typedArray.getInt(index, bVar40.f3151Z);
                    break;
                case 55:
                    b bVar41 = aVar.f3109e;
                    bVar41.f3153a0 = typedArray.getInt(index, bVar41.f3153a0);
                    break;
                case 56:
                    b bVar42 = aVar.f3109e;
                    bVar42.f3155b0 = typedArray.getDimensionPixelSize(index, bVar42.f3155b0);
                    break;
                case 57:
                    b bVar43 = aVar.f3109e;
                    bVar43.f3157c0 = typedArray.getDimensionPixelSize(index, bVar43.f3157c0);
                    break;
                case 58:
                    b bVar44 = aVar.f3109e;
                    bVar44.f3159d0 = typedArray.getDimensionPixelSize(index, bVar44.f3159d0);
                    break;
                case 59:
                    b bVar45 = aVar.f3109e;
                    bVar45.f3161e0 = typedArray.getDimensionPixelSize(index, bVar45.f3161e0);
                    break;
                case 60:
                    e eVar11 = aVar.f3110f;
                    eVar11.f3217b = typedArray.getFloat(index, eVar11.f3217b);
                    break;
                case 61:
                    b bVar46 = aVar.f3109e;
                    bVar46.f3127B = m3602F(typedArray, index, bVar46.f3127B);
                    break;
                case 62:
                    b bVar47 = aVar.f3109e;
                    bVar47.f3128C = typedArray.getDimensionPixelSize(index, bVar47.f3128C);
                    break;
                case 63:
                    b bVar48 = aVar.f3109e;
                    bVar48.f3129D = typedArray.getFloat(index, bVar48.f3129D);
                    break;
                case 64:
                    c cVar = aVar.f3108d;
                    cVar.f3197b = m3602F(typedArray, index, cVar.f3197b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f3108d.f3199d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f3108d.f3199d = C11770c.f54392c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f3108d.f3201f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f3108d;
                    cVar2.f3204i = typedArray.getFloat(index, cVar2.f3204i);
                    break;
                case 68:
                    d dVar4 = aVar.f3107c;
                    dVar4.f3214e = typedArray.getFloat(index, dVar4.f3214e);
                    break;
                case 69:
                    aVar.f3109e.f3163f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f3109e.f3165g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f3109e;
                    bVar49.f3167h0 = typedArray.getInt(index, bVar49.f3167h0);
                    break;
                case 73:
                    b bVar50 = aVar.f3109e;
                    bVar50.f3169i0 = typedArray.getDimensionPixelSize(index, bVar50.f3169i0);
                    break;
                case 74:
                    aVar.f3109e.f3175l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f3109e;
                    bVar51.f3183p0 = typedArray.getBoolean(index, bVar51.f3183p0);
                    break;
                case 76:
                    c cVar3 = aVar.f3108d;
                    cVar3.f3200e = typedArray.getInt(index, cVar3.f3200e);
                    break;
                case 77:
                    aVar.f3109e.f3177m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f3107c;
                    dVar5.f3212c = typedArray.getInt(index, dVar5.f3212c);
                    break;
                case 79:
                    c cVar4 = aVar.f3108d;
                    cVar4.f3202g = typedArray.getFloat(index, cVar4.f3202g);
                    break;
                case 80:
                    b bVar52 = aVar.f3109e;
                    bVar52.f3179n0 = typedArray.getBoolean(index, bVar52.f3179n0);
                    break;
                case 81:
                    b bVar53 = aVar.f3109e;
                    bVar53.f3181o0 = typedArray.getBoolean(index, bVar53.f3181o0);
                    break;
                case 82:
                    c cVar5 = aVar.f3108d;
                    cVar5.f3198c = typedArray.getInteger(index, cVar5.f3198c);
                    break;
                case 83:
                    e eVar12 = aVar.f3110f;
                    eVar12.f3224i = m3602F(typedArray, index, eVar12.f3224i);
                    break;
                case 84:
                    c cVar6 = aVar.f3108d;
                    cVar6.f3206k = typedArray.getInteger(index, cVar6.f3206k);
                    break;
                case 85:
                    c cVar7 = aVar.f3108d;
                    cVar7.f3205j = typedArray.getFloat(index, cVar7.f3205j);
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f3108d.f3209n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f3108d;
                        if (cVar8.f3209n != -1) {
                            cVar8.f3208m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i11 == 3) {
                        aVar.f3108d.f3207l = typedArray.getString(index);
                        if (aVar.f3108d.f3207l.indexOf("/") > 0) {
                            aVar.f3108d.f3209n = typedArray.getResourceId(index, -1);
                            aVar.f3108d.f3208m = -2;
                            break;
                        } else {
                            aVar.f3108d.f3208m = -1;
                            break;
                        }
                    } else {
                        c cVar9 = aVar.f3108d;
                        cVar9.f3208m = typedArray.getInteger(index, cVar9.f3209n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f3095j.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f3095j.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f3109e;
                    bVar54.f3187s = m3602F(typedArray, index, bVar54.f3187s);
                    break;
                case 92:
                    b bVar55 = aVar.f3109e;
                    bVar55.f3188t = m3602F(typedArray, index, bVar55.f3188t);
                    break;
                case 93:
                    b bVar56 = aVar.f3109e;
                    bVar56.f3139N = typedArray.getDimensionPixelSize(index, bVar56.f3139N);
                    break;
                case 94:
                    b bVar57 = aVar.f3109e;
                    bVar57.f3146U = typedArray.getDimensionPixelSize(index, bVar57.f3146U);
                    break;
                case 95:
                    m3603G(aVar.f3109e, typedArray, index, 0);
                    break;
                case 96:
                    m3603G(aVar.f3109e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f3109e;
                    bVar58.f3185q0 = typedArray.getInt(index, bVar58.f3185q0);
                    break;
            }
        }
        b bVar59 = aVar.f3109e;
        if (bVar59.f3175l0 != null) {
            bVar59.f3173k0 = null;
        }
    }

    /* renamed from: L */
    public void m3624L(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f3103g && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f3104h.containsKey(Integer.valueOf(id2))) {
                this.f3104h.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f3104h.get(Integer.valueOf(id2));
            if (aVar != null) {
                if (!aVar.f3109e.f3154b) {
                    aVar.m3654g(id2, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f3109e.f3173k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f3109e.f3183p0 = barrier.getAllowsGoneWidget();
                            aVar.f3109e.f3167h0 = barrier.getType();
                            aVar.f3109e.f3169i0 = barrier.getMargin();
                        }
                    }
                    aVar.f3109e.f3154b = true;
                }
                d dVar = aVar.f3107c;
                if (!dVar.f3210a) {
                    dVar.f3211b = childAt.getVisibility();
                    aVar.f3107c.f3213d = childAt.getAlpha();
                    aVar.f3107c.f3210a = true;
                }
                e eVar = aVar.f3110f;
                if (!eVar.f3216a) {
                    eVar.f3216a = true;
                    eVar.f3217b = childAt.getRotation();
                    aVar.f3110f.f3218c = childAt.getRotationX();
                    aVar.f3110f.f3219d = childAt.getRotationY();
                    aVar.f3110f.f3220e = childAt.getScaleX();
                    aVar.f3110f.f3221f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f3110f;
                        eVar2.f3222g = pivotX;
                        eVar2.f3223h = pivotY;
                    }
                    aVar.f3110f.f3225j = childAt.getTranslationX();
                    aVar.f3110f.f3226k = childAt.getTranslationY();
                    aVar.f3110f.f3227l = childAt.getTranslationZ();
                    e eVar3 = aVar.f3110f;
                    if (eVar3.f3228m) {
                        eVar3.f3229n = childAt.getElevation();
                    }
                }
            }
        }
    }

    /* renamed from: M */
    public void m3625M(C0585c c0585c) {
        for (Integer num : c0585c.f3104h.keySet()) {
            num.intValue();
            a aVar = c0585c.f3104h.get(num);
            if (!this.f3104h.containsKey(num)) {
                this.f3104h.put(num, new a());
            }
            a aVar2 = this.f3104h.get(num);
            if (aVar2 != null) {
                b bVar = aVar2.f3109e;
                if (!bVar.f3154b) {
                    bVar.m3662a(aVar.f3109e);
                }
                d dVar = aVar2.f3107c;
                if (!dVar.f3210a) {
                    dVar.m3666a(aVar.f3107c);
                }
                e eVar = aVar2.f3110f;
                if (!eVar.f3216a) {
                    eVar.m3668a(aVar.f3110f);
                }
                c cVar = aVar2.f3108d;
                if (!cVar.f3196a) {
                    cVar.m3664a(aVar.f3108d);
                }
                for (String str : aVar.f3111g.keySet()) {
                    if (!aVar2.f3111g.containsKey(str)) {
                        aVar2.f3111g.put(str, aVar.f3111g.get(str));
                    }
                }
            }
        }
    }

    /* renamed from: R */
    public void m3626R(boolean z10) {
        this.f3103g = z10;
    }

    /* renamed from: S */
    public void m3627S(String str) {
        this.f3100d = str.split(",");
        int i10 = 0;
        while (true) {
            String[] strArr = this.f3100d;
            if (i10 >= strArr.length) {
                return;
            }
            strArr[i10] = strArr[i10].trim();
            i10++;
        }
    }

    /* renamed from: T */
    public void m3628T(boolean z10) {
        this.f3097a = z10;
    }

    /* renamed from: g */
    public void m3629g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f3104h.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + C12896a.m77318d(childAt));
            } else {
                if (this.f3103g && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f3104h.containsKey(Integer.valueOf(id2)) && (aVar = this.f3104h.get(Integer.valueOf(id2))) != null) {
                    C0583a.m3585j(childAt, aVar.f3111g);
                }
            }
        }
    }

    /* renamed from: h */
    public void m3630h(C0585c c0585c) {
        for (a aVar : c0585c.f3104h.values()) {
            if (aVar.f3112h != null) {
                if (aVar.f3106b == null) {
                    aVar.f3112h.m3661e(m3644w(aVar.f3105a));
                } else {
                    Iterator<Integer> it = this.f3104h.keySet().iterator();
                    while (it.hasNext()) {
                        a aVarM3644w = m3644w(it.next().intValue());
                        String str = aVarM3644w.f3109e.f3177m0;
                        if (str != null && aVar.f3106b.matches(str)) {
                            aVar.f3112h.m3661e(aVarM3644w);
                            aVarM3644w.f3111g.putAll((HashMap) aVar.f3111g.clone());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public void m3631i(ConstraintLayout constraintLayout) {
        m3633k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    /* renamed from: j */
    public void m3632j(ConstraintHelper constraintHelper, C12258e c12258e, ConstraintLayout.LayoutParams layoutParams, SparseArray<C12258e> sparseArray) {
        a aVar;
        int id2 = constraintHelper.getId();
        if (this.f3104h.containsKey(Integer.valueOf(id2)) && (aVar = this.f3104h.get(Integer.valueOf(id2))) != null && (c12258e instanceof C12263j)) {
            constraintHelper.mo3232p(aVar, (C12263j) c12258e, layoutParams, sparseArray);
        }
    }

    /* renamed from: k */
    public void m3633k(ConstraintLayout constraintLayout, boolean z10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f3104h.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f3104h.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + C12896a.m77318d(childAt));
            } else {
                if (this.f3103g && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.f3104h.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        a aVar = this.f3104h.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f3109e.f3171j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(aVar.f3109e.f3167h0);
                                barrier.setMargin(aVar.f3109e.f3169i0);
                                barrier.setAllowsGoneWidget(aVar.f3109e.f3183p0);
                                b bVar = aVar.f3109e;
                                int[] iArr = bVar.f3173k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f3175l0;
                                    if (str != null) {
                                        bVar.f3173k0 = m3641t(barrier, str);
                                        barrier.setReferencedIds(aVar.f3109e.f3173k0);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.m3570c();
                            aVar.m3652e(layoutParams);
                            if (z10) {
                                C0583a.m3585j(childAt, aVar.f3111g);
                            }
                            childAt.setLayoutParams(layoutParams);
                            d dVar = aVar.f3107c;
                            if (dVar.f3212c == 0) {
                                childAt.setVisibility(dVar.f3211b);
                            }
                            childAt.setAlpha(aVar.f3107c.f3213d);
                            childAt.setRotation(aVar.f3110f.f3217b);
                            childAt.setRotationX(aVar.f3110f.f3218c);
                            childAt.setRotationY(aVar.f3110f.f3219d);
                            childAt.setScaleX(aVar.f3110f.f3220e);
                            childAt.setScaleY(aVar.f3110f.f3221f);
                            e eVar = aVar.f3110f;
                            if (eVar.f3224i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f3110f.f3224i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f3222g)) {
                                    childAt.setPivotX(aVar.f3110f.f3222g);
                                }
                                if (!Float.isNaN(aVar.f3110f.f3223h)) {
                                    childAt.setPivotY(aVar.f3110f.f3223h);
                                }
                            }
                            childAt.setTranslationX(aVar.f3110f.f3225j);
                            childAt.setTranslationY(aVar.f3110f.f3226k);
                            childAt.setTranslationZ(aVar.f3110f.f3227l);
                            e eVar2 = aVar.f3110f;
                            if (eVar2.f3228m) {
                                childAt.setElevation(eVar2.f3229n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f3104h.get(num);
            if (aVar2 != null) {
                if (aVar2.f3109e.f3171j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar2 = aVar2.f3109e;
                    int[] iArr2 = bVar2.f3173k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.f3175l0;
                        if (str2 != null) {
                            bVar2.f3173k0 = m3641t(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f3109e.f3173k0);
                        }
                    }
                    barrier2.setType(aVar2.f3109e.f3167h0);
                    barrier2.setMargin(aVar2.f3109e.f3169i0);
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.m3567w();
                    aVar2.m3652e(layoutParamsGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
                }
                if (aVar2.f3109e.f3152a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.m3652e(layoutParamsGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).mo3256j(constraintLayout);
            }
        }
    }

    /* renamed from: l */
    public void m3634l(int i10, ConstraintLayout.LayoutParams layoutParams) {
        a aVar;
        if (!this.f3104h.containsKey(Integer.valueOf(i10)) || (aVar = this.f3104h.get(Integer.valueOf(i10))) == null) {
            return;
        }
        aVar.m3652e(layoutParams);
    }

    /* renamed from: n */
    public void m3635n(int i10, int i11) {
        a aVar;
        if (!this.f3104h.containsKey(Integer.valueOf(i10)) || (aVar = this.f3104h.get(Integer.valueOf(i10))) == null) {
            return;
        }
        switch (i11) {
            case 1:
                b bVar = aVar.f3109e;
                bVar.f3172k = -1;
                bVar.f3170j = -1;
                bVar.f3133H = -1;
                bVar.f3140O = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = aVar.f3109e;
                bVar2.f3176m = -1;
                bVar2.f3174l = -1;
                bVar2.f3134I = -1;
                bVar2.f3142Q = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = aVar.f3109e;
                bVar3.f3180o = -1;
                bVar3.f3178n = -1;
                bVar3.f3135J = 0;
                bVar3.f3141P = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = aVar.f3109e;
                bVar4.f3182p = -1;
                bVar4.f3184q = -1;
                bVar4.f3136K = 0;
                bVar4.f3143R = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = aVar.f3109e;
                bVar5.f3186r = -1;
                bVar5.f3187s = -1;
                bVar5.f3188t = -1;
                bVar5.f3139N = 0;
                bVar5.f3146U = Integer.MIN_VALUE;
                return;
            case 6:
                b bVar6 = aVar.f3109e;
                bVar6.f3189u = -1;
                bVar6.f3190v = -1;
                bVar6.f3138M = 0;
                bVar6.f3145T = Integer.MIN_VALUE;
                return;
            case 7:
                b bVar7 = aVar.f3109e;
                bVar7.f3191w = -1;
                bVar7.f3192x = -1;
                bVar7.f3137L = 0;
                bVar7.f3144S = Integer.MIN_VALUE;
                return;
            case 8:
                b bVar8 = aVar.f3109e;
                bVar8.f3129D = -1.0f;
                bVar8.f3128C = -1;
                bVar8.f3127B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    /* renamed from: o */
    public void m3636o(Context context, int i10) {
        m3637p((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    /* renamed from: p */
    public void m3637p(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f3104h.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f3103g && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f3104h.containsKey(Integer.valueOf(id2))) {
                this.f3104h.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f3104h.get(Integer.valueOf(id2));
            if (aVar != null) {
                aVar.f3111g = C0583a.m3583b(this.f3102f, childAt);
                aVar.m3654g(id2, layoutParams);
                aVar.f3107c.f3211b = childAt.getVisibility();
                aVar.f3107c.f3213d = childAt.getAlpha();
                aVar.f3110f.f3217b = childAt.getRotation();
                aVar.f3110f.f3218c = childAt.getRotationX();
                aVar.f3110f.f3219d = childAt.getRotationY();
                aVar.f3110f.f3220e = childAt.getScaleX();
                aVar.f3110f.f3221f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f3110f;
                    eVar.f3222g = pivotX;
                    eVar.f3223h = pivotY;
                }
                aVar.f3110f.f3225j = childAt.getTranslationX();
                aVar.f3110f.f3226k = childAt.getTranslationY();
                aVar.f3110f.f3227l = childAt.getTranslationZ();
                e eVar2 = aVar.f3110f;
                if (eVar2.f3228m) {
                    eVar2.f3229n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f3109e.f3183p0 = barrier.getAllowsGoneWidget();
                    aVar.f3109e.f3173k0 = barrier.getReferencedIds();
                    aVar.f3109e.f3167h0 = barrier.getType();
                    aVar.f3109e.f3169i0 = barrier.getMargin();
                }
            }
        }
    }

    /* renamed from: q */
    public void m3638q(C0585c c0585c) {
        this.f3104h.clear();
        for (Integer num : c0585c.f3104h.keySet()) {
            a aVar = c0585c.f3104h.get(num);
            if (aVar != null) {
                this.f3104h.put(num, aVar.clone());
            }
        }
    }

    /* renamed from: r */
    public void m3639r(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f3104h.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraints.getChildAt(i10);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f3103g && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f3104h.containsKey(Integer.valueOf(id2))) {
                this.f3104h.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f3104h.get(Integer.valueOf(id2));
            if (aVar != null) {
                if (childAt instanceof ConstraintHelper) {
                    aVar.m3656i((ConstraintHelper) childAt, id2, layoutParams);
                }
                aVar.m3655h(id2, layoutParams);
            }
        }
    }

    /* renamed from: s */
    public void m3640s(int i10, int i11, int i12, float f10) {
        b bVar = m3643v(i10).f3109e;
        bVar.f3127B = i11;
        bVar.f3128C = i12;
        bVar.f3129D = f10;
    }

    /* renamed from: t */
    public final int[] m3641t(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < strArrSplit.length) {
            String strTrim = strArrSplit[i10].trim();
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i11] = iIntValue;
            i10++;
            i11++;
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    /* renamed from: u */
    public final a m3642u(Context context, AttributeSet attributeSet, boolean z10) throws NumberFormatException {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        m3623J(aVar, typedArrayObtainStyledAttributes, z10);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    /* renamed from: v */
    public final a m3643v(int i10) {
        if (!this.f3104h.containsKey(Integer.valueOf(i10))) {
            this.f3104h.put(Integer.valueOf(i10), new a());
        }
        return this.f3104h.get(Integer.valueOf(i10));
    }

    /* renamed from: w */
    public a m3644w(int i10) {
        if (this.f3104h.containsKey(Integer.valueOf(i10))) {
            return this.f3104h.get(Integer.valueOf(i10));
        }
        return null;
    }

    /* renamed from: x */
    public int m3645x(int i10) {
        return m3643v(i10).f3109e.f3160e;
    }

    /* renamed from: y */
    public int[] m3646y() {
        Integer[] numArr = (Integer[]) this.f3104h.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    /* renamed from: z */
    public a m3647z(int i10) {
        return m3643v(i10);
    }
}
