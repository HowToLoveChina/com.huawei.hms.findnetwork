package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.R$attr;
import androidx.constraintlayout.widget.R$styleable;
import java.util.Objects;
import p642t.C12896a;
import p642t.InterfaceC12898c;

/* loaded from: classes.dex */
public class MotionLabel extends View implements InterfaceC12898c {

    /* renamed from: A */
    public float f2882A;

    /* renamed from: B */
    public float f2883B;

    /* renamed from: C */
    public float f2884C;

    /* renamed from: D */
    public Drawable f2885D;

    /* renamed from: E */
    public Matrix f2886E;

    /* renamed from: F */
    public Bitmap f2887F;

    /* renamed from: G */
    public BitmapShader f2888G;

    /* renamed from: H */
    public Matrix f2889H;

    /* renamed from: I */
    public float f2890I;

    /* renamed from: J */
    public float f2891J;

    /* renamed from: K */
    public float f2892K;

    /* renamed from: L */
    public float f2893L;

    /* renamed from: M */
    public Paint f2894M;

    /* renamed from: N */
    public int f2895N;

    /* renamed from: O */
    public Rect f2896O;

    /* renamed from: P */
    public Paint f2897P;

    /* renamed from: Q */
    public float f2898Q;

    /* renamed from: R */
    public float f2899R;

    /* renamed from: S */
    public float f2900S;

    /* renamed from: T */
    public float f2901T;

    /* renamed from: U */
    public float f2902U;

    /* renamed from: a */
    public TextPaint f2903a;

    /* renamed from: b */
    public Path f2904b;

    /* renamed from: c */
    public int f2905c;

    /* renamed from: d */
    public int f2906d;

    /* renamed from: e */
    public boolean f2907e;

    /* renamed from: f */
    public float f2908f;

    /* renamed from: g */
    public float f2909g;

    /* renamed from: h */
    public ViewOutlineProvider f2910h;

    /* renamed from: i */
    public RectF f2911i;

    /* renamed from: j */
    public float f2912j;

    /* renamed from: k */
    public float f2913k;

    /* renamed from: l */
    public int f2914l;

    /* renamed from: m */
    public int f2915m;

    /* renamed from: n */
    public float f2916n;

    /* renamed from: o */
    public String f2917o;

    /* renamed from: p */
    public boolean f2918p;

    /* renamed from: q */
    public Rect f2919q;

    /* renamed from: r */
    public int f2920r;

    /* renamed from: s */
    public int f2921s;

    /* renamed from: t */
    public int f2922t;

    /* renamed from: u */
    public int f2923u;

    /* renamed from: v */
    public String f2924v;

    /* renamed from: w */
    public Layout f2925w;

    /* renamed from: x */
    public int f2926x;

    /* renamed from: y */
    public int f2927y;

    /* renamed from: z */
    public boolean f2928z;

    /* renamed from: androidx.constraintlayout.utils.widget.MotionLabel$a */
    public class C0577a extends ViewOutlineProvider {
        public C0577a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.f2908f) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.MotionLabel$b */
    public class C0578b extends ViewOutlineProvider {
        public C0578b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f2909g);
        }
    }

    public MotionLabel(Context context) {
        super(context);
        this.f2903a = new TextPaint();
        this.f2904b = new Path();
        this.f2905c = 65535;
        this.f2906d = 65535;
        this.f2907e = false;
        this.f2908f = 0.0f;
        this.f2909g = Float.NaN;
        this.f2912j = 48.0f;
        this.f2913k = Float.NaN;
        this.f2916n = 0.0f;
        this.f2917o = "Hello World";
        this.f2918p = true;
        this.f2919q = new Rect();
        this.f2920r = 1;
        this.f2921s = 1;
        this.f2922t = 1;
        this.f2923u = 1;
        this.f2926x = 8388659;
        this.f2927y = 0;
        this.f2928z = false;
        this.f2890I = Float.NaN;
        this.f2891J = Float.NaN;
        this.f2892K = 0.0f;
        this.f2893L = 0.0f;
        this.f2894M = new Paint();
        this.f2895N = 0;
        this.f2899R = Float.NaN;
        this.f2900S = Float.NaN;
        this.f2901T = Float.NaN;
        this.f2902U = Float.NaN;
        m3549g(context, null);
    }

    private float getHorizontalOffset() {
        float f10 = Float.isNaN(this.f2913k) ? 1.0f : this.f2912j / this.f2913k;
        TextPaint textPaint = this.f2903a;
        String str = this.f2917o;
        return (((((Float.isNaN(this.f2883B) ? getMeasuredWidth() : this.f2883B) - getPaddingLeft()) - getPaddingRight()) - (f10 * textPaint.measureText(str, 0, str.length()))) * (this.f2892K + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f10 = Float.isNaN(this.f2913k) ? 1.0f : this.f2912j / this.f2913k;
        Paint.FontMetrics fontMetrics = this.f2903a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.f2884C) ? getMeasuredHeight() : this.f2884C) - getPaddingTop()) - getPaddingBottom();
        float f11 = fontMetrics.descent;
        float f12 = fontMetrics.ascent;
        return (((measuredHeight - ((f11 - f12) * f10)) * (1.0f - this.f2893L)) / 2.0f) - (f10 * f12);
    }

    private void setUpTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f2903a;
        int i10 = typedValue.data;
        this.f2905c = i10;
        textPaint.setColor(i10);
    }

    @Override // p642t.InterfaceC12898c
    /* renamed from: a */
    public void mo3545a(float f10, float f11, float f12, float f13) {
        int i10 = (int) (f10 + 0.5f);
        this.f2882A = f10 - i10;
        int i11 = (int) (f12 + 0.5f);
        int i12 = i11 - i10;
        int i13 = (int) (f13 + 0.5f);
        int i14 = (int) (0.5f + f11);
        int i15 = i13 - i14;
        float f14 = f12 - f10;
        this.f2883B = f14;
        float f15 = f13 - f11;
        this.f2884C = f15;
        m3546d(f10, f11, f12, f13);
        if (getMeasuredHeight() == i15 && getMeasuredWidth() == i12) {
            super.layout(i10, i14, i11, i13);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
            super.layout(i10, i14, i11, i13);
        }
        if (this.f2928z) {
            if (this.f2896O == null) {
                this.f2897P = new Paint();
                this.f2896O = new Rect();
                this.f2897P.set(this.f2903a);
                this.f2898Q = this.f2897P.getTextSize();
            }
            this.f2883B = f14;
            this.f2884C = f15;
            Paint paint = this.f2897P;
            String str = this.f2917o;
            paint.getTextBounds(str, 0, str.length(), this.f2896O);
            float fHeight = this.f2896O.height() * 1.3f;
            float f16 = (f14 - this.f2921s) - this.f2920r;
            float f17 = (f15 - this.f2923u) - this.f2922t;
            float fWidth = this.f2896O.width();
            if (fWidth * f17 > fHeight * f16) {
                this.f2903a.setTextSize((this.f2898Q * f16) / fWidth);
            } else {
                this.f2903a.setTextSize((this.f2898Q * f17) / fHeight);
            }
            if (this.f2907e || !Float.isNaN(this.f2913k)) {
                m3548f(Float.isNaN(this.f2913k) ? 1.0f : this.f2912j / this.f2913k);
            }
        }
    }

    /* renamed from: d */
    public final void m3546d(float f10, float f11, float f12, float f13) {
        if (this.f2889H == null) {
            return;
        }
        this.f2883B = f12 - f10;
        this.f2884C = f13 - f11;
        m3553k();
    }

    /* renamed from: e */
    public Bitmap m3547e(Bitmap bitmap, int i10) {
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i11 = 0; i11 < i10 && width >= 32 && height >= 32; i11++) {
            width /= 2;
            height /= 2;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
        }
        return bitmapCreateScaledBitmap;
    }

    /* renamed from: f */
    public void m3548f(float f10) {
        if (this.f2907e || f10 != 1.0f) {
            this.f2904b.reset();
            String str = this.f2917o;
            int length = str.length();
            this.f2903a.getTextBounds(str, 0, length, this.f2919q);
            this.f2903a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f2904b);
            if (f10 != 1.0f) {
                Log.v("MotionLabel", C12896a.m77315a() + " scale " + f10);
                Matrix matrix = new Matrix();
                matrix.postScale(f10, f10);
                this.f2904b.transform(matrix);
            }
            Rect rect = this.f2919q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f2918p = false;
        }
    }

    /* renamed from: g */
    public final void m3549g(Context context, AttributeSet attributeSet) {
        setUpTheme(context);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == R$styleable.MotionLabel_android_fontFamily) {
                    this.f2924v = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.MotionLabel_scaleFromTextSize) {
                    this.f2913k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f2913k);
                } else if (index == R$styleable.MotionLabel_android_textSize) {
                    this.f2912j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f2912j);
                } else if (index == R$styleable.MotionLabel_android_textStyle) {
                    this.f2914l = typedArrayObtainStyledAttributes.getInt(index, this.f2914l);
                } else if (index == R$styleable.MotionLabel_android_typeface) {
                    this.f2915m = typedArrayObtainStyledAttributes.getInt(index, this.f2915m);
                } else if (index == R$styleable.MotionLabel_android_textColor) {
                    this.f2905c = typedArrayObtainStyledAttributes.getColor(index, this.f2905c);
                } else if (index == R$styleable.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.f2909g);
                    this.f2909g = dimension;
                    setRound(dimension);
                } else if (index == R$styleable.MotionLabel_borderRoundPercent) {
                    float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f2908f);
                    this.f2908f = f10;
                    setRoundPercent(f10);
                } else if (index == R$styleable.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == R$styleable.MotionLabel_android_autoSizeTextType) {
                    this.f2927y = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.MotionLabel_textOutlineColor) {
                    this.f2906d = typedArrayObtainStyledAttributes.getInt(index, this.f2906d);
                    this.f2907e = true;
                } else if (index == R$styleable.MotionLabel_textOutlineThickness) {
                    this.f2916n = typedArrayObtainStyledAttributes.getDimension(index, this.f2916n);
                    this.f2907e = true;
                } else if (index == R$styleable.MotionLabel_textBackground) {
                    this.f2885D = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.f2907e = true;
                } else if (index == R$styleable.MotionLabel_textBackgroundPanX) {
                    this.f2899R = typedArrayObtainStyledAttributes.getFloat(index, this.f2899R);
                } else if (index == R$styleable.MotionLabel_textBackgroundPanY) {
                    this.f2900S = typedArrayObtainStyledAttributes.getFloat(index, this.f2900S);
                } else if (index == R$styleable.MotionLabel_textPanX) {
                    this.f2892K = typedArrayObtainStyledAttributes.getFloat(index, this.f2892K);
                } else if (index == R$styleable.MotionLabel_textPanY) {
                    this.f2893L = typedArrayObtainStyledAttributes.getFloat(index, this.f2893L);
                } else if (index == R$styleable.MotionLabel_textBackgroundRotate) {
                    this.f2902U = typedArrayObtainStyledAttributes.getFloat(index, this.f2902U);
                } else if (index == R$styleable.MotionLabel_textBackgroundZoom) {
                    this.f2901T = typedArrayObtainStyledAttributes.getFloat(index, this.f2901T);
                } else if (index == R$styleable.MotionLabel_textureHeight) {
                    this.f2890I = typedArrayObtainStyledAttributes.getDimension(index, this.f2890I);
                } else if (index == R$styleable.MotionLabel_textureWidth) {
                    this.f2891J = typedArrayObtainStyledAttributes.getDimension(index, this.f2891J);
                } else if (index == R$styleable.MotionLabel_textureEffect) {
                    this.f2895N = typedArrayObtainStyledAttributes.getInt(index, this.f2895N);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        m3552j();
        m3551i();
    }

    public float getRound() {
        return this.f2909g;
    }

    public float getRoundPercent() {
        return this.f2908f;
    }

    public float getScaleFromTextSize() {
        return this.f2913k;
    }

    public float getTextBackgroundPanX() {
        return this.f2899R;
    }

    public float getTextBackgroundPanY() {
        return this.f2900S;
    }

    public float getTextBackgroundRotate() {
        return this.f2902U;
    }

    public float getTextBackgroundZoom() {
        return this.f2901T;
    }

    public int getTextOutlineColor() {
        return this.f2906d;
    }

    public float getTextPanX() {
        return this.f2892K;
    }

    public float getTextPanY() {
        return this.f2893L;
    }

    public float getTextureHeight() {
        return this.f2890I;
    }

    public float getTextureWidth() {
        return this.f2891J;
    }

    public Typeface getTypeface() {
        return this.f2903a.getTypeface();
    }

    /* renamed from: h */
    public final void m3550h(String str, int i10, int i11) {
        Typeface typefaceCreate;
        if (str != null) {
            typefaceCreate = Typeface.create(str, i11);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (i10 == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (i10 == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (i10 == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (i11 <= 0) {
            this.f2903a.setFakeBoldText(false);
            this.f2903a.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        } else {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typefaceCreate, i11);
            setTypeface(typefaceDefaultFromStyle);
            int i12 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i11;
            this.f2903a.setFakeBoldText((i12 & 1) != 0);
            this.f2903a.setTextSkewX((i12 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    /* renamed from: i */
    public void m3551i() {
        this.f2920r = getPaddingLeft();
        this.f2921s = getPaddingRight();
        this.f2922t = getPaddingTop();
        this.f2923u = getPaddingBottom();
        m3550h(this.f2924v, this.f2915m, this.f2914l);
        this.f2903a.setColor(this.f2905c);
        this.f2903a.setStrokeWidth(this.f2916n);
        this.f2903a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f2903a.setFlags(128);
        setTextSize(this.f2912j);
        this.f2903a.setAntiAlias(true);
    }

    /* renamed from: j */
    public final void m3552j() {
        if (this.f2885D != null) {
            this.f2889H = new Matrix();
            int intrinsicWidth = this.f2885D.getIntrinsicWidth();
            int intrinsicHeight = this.f2885D.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.f2891J) ? 128 : (int) this.f2891J;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.f2890I) ? 128 : (int) this.f2890I;
            }
            if (this.f2895N != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.f2887F = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f2887F);
            this.f2885D.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f2885D.setFilterBitmap(true);
            this.f2885D.draw(canvas);
            if (this.f2895N != 0) {
                this.f2887F = m3547e(this.f2887F, 4);
            }
            Bitmap bitmap = this.f2887F;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f2888G = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    /* renamed from: k */
    public final void m3553k() {
        float f10 = Float.isNaN(this.f2899R) ? 0.0f : this.f2899R;
        float f11 = Float.isNaN(this.f2900S) ? 0.0f : this.f2900S;
        float f12 = Float.isNaN(this.f2901T) ? 1.0f : this.f2901T;
        float f13 = Float.isNaN(this.f2902U) ? 0.0f : this.f2902U;
        this.f2889H.reset();
        float width = this.f2887F.getWidth();
        float height = this.f2887F.getHeight();
        float f14 = Float.isNaN(this.f2891J) ? this.f2883B : this.f2891J;
        float f15 = Float.isNaN(this.f2890I) ? this.f2884C : this.f2890I;
        float f16 = f12 * (width * f15 < height * f14 ? f14 / width : f15 / height);
        this.f2889H.postScale(f16, f16);
        float f17 = width * f16;
        float f18 = f14 - f17;
        float f19 = f16 * height;
        float f20 = f15 - f19;
        if (!Float.isNaN(this.f2890I)) {
            f20 = this.f2890I / 2.0f;
        }
        if (!Float.isNaN(this.f2891J)) {
            f18 = this.f2891J / 2.0f;
        }
        this.f2889H.postTranslate((((f10 * f18) + f14) - f17) * 0.5f, (((f11 * f20) + f15) - f19) * 0.5f);
        this.f2889H.postRotate(f13, f14 / 2.0f, f15 / 2.0f);
        this.f2888G.setLocalMatrix(this.f2889H);
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        boolean zIsNaN = Float.isNaN(this.f2913k);
        float f10 = zIsNaN ? 1.0f : this.f2912j / this.f2913k;
        this.f2883B = i12 - i10;
        this.f2884C = i13 - i11;
        if (this.f2928z) {
            if (this.f2896O == null) {
                this.f2897P = new Paint();
                this.f2896O = new Rect();
                this.f2897P.set(this.f2903a);
                this.f2898Q = this.f2897P.getTextSize();
            }
            Paint paint = this.f2897P;
            String str = this.f2917o;
            paint.getTextBounds(str, 0, str.length(), this.f2896O);
            int iWidth = this.f2896O.width();
            int iHeight = (int) (this.f2896O.height() * 1.3f);
            float f11 = (this.f2883B - this.f2921s) - this.f2920r;
            float f12 = (this.f2884C - this.f2923u) - this.f2922t;
            if (zIsNaN) {
                float f13 = iWidth;
                float f14 = iHeight;
                if (f13 * f12 > f14 * f11) {
                    this.f2903a.setTextSize((this.f2898Q * f11) / f13);
                } else {
                    this.f2903a.setTextSize((this.f2898Q * f12) / f14);
                }
            } else {
                float f15 = iWidth;
                float f16 = iHeight;
                f10 = f15 * f12 > f16 * f11 ? f11 / f15 : f12 / f16;
            }
        }
        if (this.f2907e || !zIsNaN) {
            m3546d(i10, i11, i12, i13);
            m3548f(f10);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10 = Float.isNaN(this.f2913k) ? 1.0f : this.f2912j / this.f2913k;
        super.onDraw(canvas);
        if (!this.f2907e && f10 == 1.0f) {
            canvas.drawText(this.f2917o, this.f2882A + this.f2920r + getHorizontalOffset(), this.f2922t + getVerticalOffset(), this.f2903a);
            return;
        }
        if (this.f2918p) {
            m3548f(f10);
        }
        if (this.f2886E == null) {
            this.f2886E = new Matrix();
        }
        if (!this.f2907e) {
            float horizontalOffset = this.f2920r + getHorizontalOffset();
            float verticalOffset = this.f2922t + getVerticalOffset();
            this.f2886E.reset();
            this.f2886E.preTranslate(horizontalOffset, verticalOffset);
            this.f2904b.transform(this.f2886E);
            this.f2903a.setColor(this.f2905c);
            this.f2903a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f2903a.setStrokeWidth(this.f2916n);
            canvas.drawPath(this.f2904b, this.f2903a);
            this.f2886E.reset();
            this.f2886E.preTranslate(-horizontalOffset, -verticalOffset);
            this.f2904b.transform(this.f2886E);
            return;
        }
        this.f2894M.set(this.f2903a);
        this.f2886E.reset();
        float horizontalOffset2 = this.f2920r + getHorizontalOffset();
        float verticalOffset2 = this.f2922t + getVerticalOffset();
        this.f2886E.postTranslate(horizontalOffset2, verticalOffset2);
        this.f2886E.preScale(f10, f10);
        this.f2904b.transform(this.f2886E);
        if (this.f2888G != null) {
            this.f2903a.setFilterBitmap(true);
            this.f2903a.setShader(this.f2888G);
        } else {
            this.f2903a.setColor(this.f2905c);
        }
        this.f2903a.setStyle(Paint.Style.FILL);
        this.f2903a.setStrokeWidth(this.f2916n);
        canvas.drawPath(this.f2904b, this.f2903a);
        if (this.f2888G != null) {
            this.f2903a.setShader(null);
        }
        this.f2903a.setColor(this.f2906d);
        this.f2903a.setStyle(Paint.Style.STROKE);
        this.f2903a.setStrokeWidth(this.f2916n);
        canvas.drawPath(this.f2904b, this.f2903a);
        this.f2886E.reset();
        this.f2886E.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f2904b.transform(this.f2886E);
        this.f2903a.set(this.f2894M);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        this.f2928z = false;
        this.f2920r = getPaddingLeft();
        this.f2921s = getPaddingRight();
        this.f2922t = getPaddingTop();
        this.f2923u = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f2903a;
            String str = this.f2917o;
            textPaint.getTextBounds(str, 0, str.length(), this.f2919q);
            if (mode != 1073741824) {
                size = (int) (this.f2919q.width() + 0.99999f);
            }
            size += this.f2920r + this.f2921s;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f2903a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f2922t + this.f2923u + fontMetricsInt;
            }
        } else if (this.f2927y != 0) {
            this.f2928z = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i10) {
        if ((i10 & 8388615) == 0) {
            i10 |= 8388611;
        }
        if ((i10 & 112) == 0) {
            i10 |= 48;
        }
        if (i10 != this.f2926x) {
            invalidate();
        }
        this.f2926x = i10;
        int i11 = i10 & 112;
        if (i11 == 48) {
            this.f2893L = -1.0f;
        } else if (i11 != 80) {
            this.f2893L = 0.0f;
        } else {
            this.f2893L = 1.0f;
        }
        int i12 = i10 & 8388615;
        if (i12 != 3) {
            if (i12 != 5) {
                if (i12 != 8388611) {
                    if (i12 != 8388613) {
                        this.f2892K = 0.0f;
                        return;
                    }
                }
            }
            this.f2892K = 1.0f;
            return;
        }
        this.f2892K = -1.0f;
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f2909g = f10;
            float f11 = this.f2908f;
            this.f2908f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f2909g != f10;
        this.f2909g = f10;
        if (f10 != 0.0f) {
            if (this.f2904b == null) {
                this.f2904b = new Path();
            }
            if (this.f2911i == null) {
                this.f2911i = new RectF();
            }
            if (this.f2910h == null) {
                C0578b c0578b = new C0578b();
                this.f2910h = c0578b;
                setOutlineProvider(c0578b);
            }
            setClipToOutline(true);
            this.f2911i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2904b.reset();
            Path path = this.f2904b;
            RectF rectF = this.f2911i;
            float f12 = this.f2909g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f2908f != f10;
        this.f2908f = f10;
        if (f10 != 0.0f) {
            if (this.f2904b == null) {
                this.f2904b = new Path();
            }
            if (this.f2911i == null) {
                this.f2911i = new RectF();
            }
            if (this.f2910h == null) {
                C0577a c0577a = new C0577a();
                this.f2910h = c0577a;
                setOutlineProvider(c0577a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2908f) / 2.0f;
            this.f2911i.set(0.0f, 0.0f, width, height);
            this.f2904b.reset();
            this.f2904b.addRoundRect(this.f2911i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f10) {
        this.f2913k = f10;
    }

    public void setText(CharSequence charSequence) {
        this.f2917o = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f10) {
        this.f2899R = f10;
        m3553k();
        invalidate();
    }

    public void setTextBackgroundPanY(float f10) {
        this.f2900S = f10;
        m3553k();
        invalidate();
    }

    public void setTextBackgroundRotate(float f10) {
        this.f2902U = f10;
        m3553k();
        invalidate();
    }

    public void setTextBackgroundZoom(float f10) {
        this.f2901T = f10;
        m3553k();
        invalidate();
    }

    public void setTextFillColor(int i10) {
        this.f2905c = i10;
        invalidate();
    }

    public void setTextOutlineColor(int i10) {
        this.f2906d = i10;
        this.f2907e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f10) {
        this.f2916n = f10;
        this.f2907e = true;
        if (Float.isNaN(f10)) {
            this.f2916n = 1.0f;
            this.f2907e = false;
        }
        invalidate();
    }

    public void setTextPanX(float f10) {
        this.f2892K = f10;
        invalidate();
    }

    public void setTextPanY(float f10) {
        this.f2893L = f10;
        invalidate();
    }

    public void setTextSize(float f10) {
        this.f2912j = f10;
        TextPaint textPaint = this.f2903a;
        if (!Float.isNaN(this.f2913k)) {
            f10 = this.f2913k;
        }
        textPaint.setTextSize(f10);
        m3548f(Float.isNaN(this.f2913k) ? 1.0f : this.f2912j / this.f2913k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f10) {
        this.f2890I = f10;
        m3553k();
        invalidate();
    }

    public void setTextureWidth(float f10) {
        this.f2891J = f10;
        m3553k();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (Objects.equals(this.f2903a.getTypeface(), typeface)) {
            return;
        }
        this.f2903a.setTypeface(typeface);
        if (this.f2925w != null) {
            this.f2925w = null;
            requestLayout();
            invalidate();
        }
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2903a = new TextPaint();
        this.f2904b = new Path();
        this.f2905c = 65535;
        this.f2906d = 65535;
        this.f2907e = false;
        this.f2908f = 0.0f;
        this.f2909g = Float.NaN;
        this.f2912j = 48.0f;
        this.f2913k = Float.NaN;
        this.f2916n = 0.0f;
        this.f2917o = "Hello World";
        this.f2918p = true;
        this.f2919q = new Rect();
        this.f2920r = 1;
        this.f2921s = 1;
        this.f2922t = 1;
        this.f2923u = 1;
        this.f2926x = 8388659;
        this.f2927y = 0;
        this.f2928z = false;
        this.f2890I = Float.NaN;
        this.f2891J = Float.NaN;
        this.f2892K = 0.0f;
        this.f2893L = 0.0f;
        this.f2894M = new Paint();
        this.f2895N = 0;
        this.f2899R = Float.NaN;
        this.f2900S = Float.NaN;
        this.f2901T = Float.NaN;
        this.f2902U = Float.NaN;
        m3549g(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2903a = new TextPaint();
        this.f2904b = new Path();
        this.f2905c = 65535;
        this.f2906d = 65535;
        this.f2907e = false;
        this.f2908f = 0.0f;
        this.f2909g = Float.NaN;
        this.f2912j = 48.0f;
        this.f2913k = Float.NaN;
        this.f2916n = 0.0f;
        this.f2917o = "Hello World";
        this.f2918p = true;
        this.f2919q = new Rect();
        this.f2920r = 1;
        this.f2921s = 1;
        this.f2922t = 1;
        this.f2923u = 1;
        this.f2926x = 8388659;
        this.f2927y = 0;
        this.f2928z = false;
        this.f2890I = Float.NaN;
        this.f2891J = Float.NaN;
        this.f2892K = 0.0f;
        this.f2893L = 0.0f;
        this.f2894M = new Paint();
        this.f2895N = 0;
        this.f2899R = Float.NaN;
        this.f2900S = Float.NaN;
        this.f2901T = Float.NaN;
        this.f2902U = Float.NaN;
        m3549g(context, attributeSet);
    }
}
