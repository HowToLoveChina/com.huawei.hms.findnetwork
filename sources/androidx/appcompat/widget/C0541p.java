package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import com.huawei.hiar.ARImageMetadata;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import p273f0.C9603h0;

/* renamed from: androidx.appcompat.widget.p */
/* loaded from: classes.dex */
public class C0541p {

    /* renamed from: l */
    public static final RectF f2398l = new RectF();

    /* renamed from: m */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> f2399m = new ConcurrentHashMap<>();

    /* renamed from: n */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> f2400n = new ConcurrentHashMap<>();

    /* renamed from: h */
    public TextPaint f2408h;

    /* renamed from: i */
    public final TextView f2409i;

    /* renamed from: j */
    public final Context f2410j;

    /* renamed from: a */
    public int f2401a = 0;

    /* renamed from: b */
    public boolean f2402b = false;

    /* renamed from: c */
    public float f2403c = -1.0f;

    /* renamed from: d */
    public float f2404d = -1.0f;

    /* renamed from: e */
    public float f2405e = -1.0f;

    /* renamed from: f */
    public int[] f2406f = new int[0];

    /* renamed from: g */
    public boolean f2407g = false;

    /* renamed from: k */
    public final f f2411k = new e();

    /* renamed from: androidx.appcompat.widget.p$a */
    public static final class a {
        /* renamed from: a */
        public static StaticLayout m3134a(CharSequence charSequence, Layout.Alignment alignment, int i10, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        /* renamed from: b */
        public static int m3135b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* renamed from: androidx.appcompat.widget.p$b */
    public static final class b {
        /* renamed from: a */
        public static boolean m3136a(View view) {
            return view.isInLayout();
        }
    }

    /* renamed from: androidx.appcompat.widget.p$c */
    public static final class c {
        /* renamed from: a */
        public static StaticLayout m3137a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                fVar.mo3138a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* renamed from: androidx.appcompat.widget.p$d */
    public static class d extends f {
    }

    /* renamed from: androidx.appcompat.widget.p$e */
    public static class e extends d {
        @Override // androidx.appcompat.widget.C0541p.f
        /* renamed from: a */
        public void mo3138a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.C0541p.f
        /* renamed from: b */
        public boolean mo3139b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* renamed from: androidx.appcompat.widget.p$f */
    public static class f {
        /* renamed from: a */
        public void mo3138a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        /* renamed from: b */
        public boolean mo3139b(TextView textView) {
            throw null;
        }
    }

    public C0541p(TextView textView) {
        this.f2409i = textView;
        this.f2410j = textView.getContext();
    }

    /* renamed from: k */
    public static Method m3108k(String str) throws SecurityException {
        try {
            Method declaredMethod = f2399m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f2399m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    /* renamed from: m */
    public static <T> T m3109m(Object obj, String str, T t10) {
        try {
            return (T) m3108k(str).invoke(obj, new Object[0]);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return t10;
        }
    }

    /* renamed from: a */
    public void m3110a() {
        if (m3121n()) {
            if (this.f2402b) {
                if (this.f2409i.getMeasuredHeight() <= 0 || this.f2409i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f2411k.mo3139b(this.f2409i) ? ARImageMetadata.SHADING_MODE : (this.f2409i.getMeasuredWidth() - this.f2409i.getTotalPaddingLeft()) - this.f2409i.getTotalPaddingRight();
                int height = (this.f2409i.getHeight() - this.f2409i.getCompoundPaddingBottom()) - this.f2409i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f2398l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fM3114e = m3114e(rectF);
                        if (fM3114e != this.f2409i.getTextSize()) {
                            m3127t(0, fM3114e);
                        }
                    } finally {
                    }
                }
            }
            this.f2402b = true;
        }
    }

    /* renamed from: b */
    public final int[] m3111b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    /* renamed from: c */
    public final void m3112c() {
        this.f2401a = 0;
        this.f2404d = -1.0f;
        this.f2405e = -1.0f;
        this.f2403c = -1.0f;
        this.f2406f = new int[0];
        this.f2402b = false;
    }

    /* renamed from: d */
    public StaticLayout m3113d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        return c.m3137a(charSequence, alignment, i10, i11, this.f2409i, this.f2408h, this.f2411k);
    }

    /* renamed from: e */
    public final int m3114e(RectF rectF) {
        int length = this.f2406f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = 1;
        int i11 = length - 1;
        int i12 = 0;
        while (i10 <= i11) {
            int i13 = (i10 + i11) / 2;
            if (m3131x(this.f2406f[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i10;
                i10 = i14;
            } else {
                i12 = i13 - 1;
                i11 = i12;
            }
        }
        return this.f2406f[i12];
    }

    /* renamed from: f */
    public int m3115f() {
        return Math.round(this.f2405e);
    }

    /* renamed from: g */
    public int m3116g() {
        return Math.round(this.f2404d);
    }

    /* renamed from: h */
    public int m3117h() {
        return Math.round(this.f2403c);
    }

    /* renamed from: i */
    public int[] m3118i() {
        return this.f2406f;
    }

    /* renamed from: j */
    public int m3119j() {
        return this.f2401a;
    }

    /* renamed from: l */
    public void m3120l(int i10) {
        TextPaint textPaint = this.f2408h;
        if (textPaint == null) {
            this.f2408h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f2408h.set(this.f2409i.getPaint());
        this.f2408h.setTextSize(i10);
    }

    /* renamed from: n */
    public boolean m3121n() {
        return m3132y() && this.f2401a != 0;
    }

    /* renamed from: o */
    public void m3122o(AttributeSet attributeSet, int i10) {
        int resourceId;
        Context context = this.f2410j;
        int[] iArr = R$styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f2409i;
        C9603h0.m59898n0(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        int i11 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f2401a = typedArrayObtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i12) ? typedArrayObtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i13) ? typedArrayObtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i14) ? typedArrayObtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i15) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m3129v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!m3132y()) {
            this.f2401a = 0;
            return;
        }
        if (this.f2401a == 1) {
            if (!this.f2407g) {
                DisplayMetrics displayMetrics = this.f2410j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m3133z(dimension2, dimension3, dimension);
            }
            m3128u();
        }
    }

    /* renamed from: p */
    public void m3123p(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (m3132y()) {
            DisplayMetrics displayMetrics = this.f2410j.getResources().getDisplayMetrics();
            m3133z(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (m3128u()) {
                m3110a();
            }
        }
    }

    /* renamed from: q */
    public void m3124q(int[] iArr, int i10) throws IllegalArgumentException {
        if (m3132y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i10 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2410j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArrCopyOf[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f2406f = m3111b(iArrCopyOf);
                if (!m3130w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f2407g = false;
            }
            if (m3128u()) {
                m3110a();
            }
        }
    }

    /* renamed from: r */
    public void m3125r(int i10) {
        if (m3132y()) {
            if (i10 == 0) {
                m3112c();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.f2410j.getResources().getDisplayMetrics();
            m3133z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (m3128u()) {
                m3110a();
            }
        }
    }

    /* renamed from: s */
    public final void m3126s(float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f10 != this.f2409i.getPaint().getTextSize()) {
            this.f2409i.getPaint().setTextSize(f10);
            boolean zM3136a = b.m3136a(this.f2409i);
            if (this.f2409i.getLayout() != null) {
                this.f2402b = false;
                try {
                    Method methodM3108k = m3108k("nullLayouts");
                    if (methodM3108k != null) {
                        methodM3108k.invoke(this.f2409i, new Object[0]);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (zM3136a) {
                    this.f2409i.forceLayout();
                } else {
                    this.f2409i.requestLayout();
                }
                this.f2409i.invalidate();
            }
        }
    }

    /* renamed from: t */
    public void m3127t(int i10, float f10) {
        Context context = this.f2410j;
        m3126s(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    /* renamed from: u */
    public final boolean m3128u() {
        if (m3132y() && this.f2401a == 1) {
            if (!this.f2407g || this.f2406f.length == 0) {
                int iFloor = ((int) Math.floor((this.f2405e - this.f2404d) / this.f2403c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i10 = 0; i10 < iFloor; i10++) {
                    iArr[i10] = Math.round(this.f2404d + (i10 * this.f2403c));
                }
                this.f2406f = m3111b(iArr);
            }
            this.f2402b = true;
        } else {
            this.f2402b = false;
        }
        return this.f2402b;
    }

    /* renamed from: v */
    public final void m3129v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f2406f = m3111b(iArr);
            m3130w();
        }
    }

    /* renamed from: w */
    public final boolean m3130w() {
        boolean z10 = this.f2406f.length > 0;
        this.f2407g = z10;
        if (z10) {
            this.f2401a = 1;
            this.f2404d = r0[0];
            this.f2405e = r0[r1 - 1];
            this.f2403c = -1.0f;
        }
        return z10;
    }

    /* renamed from: x */
    public final boolean m3131x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f2409i.getText();
        TransformationMethod transformationMethod = this.f2409i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f2409i)) != null) {
            text = transformation;
        }
        int iM3135b = a.m3135b(this.f2409i);
        m3120l(i10);
        StaticLayout staticLayoutM3113d = m3113d(text, (Layout.Alignment) m3109m(this.f2409i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iM3135b);
        return (iM3135b == -1 || (staticLayoutM3113d.getLineCount() <= iM3135b && staticLayoutM3113d.getLineEnd(staticLayoutM3113d.getLineCount() - 1) == text.length())) && ((float) staticLayoutM3113d.getHeight()) <= rectF.bottom;
    }

    /* renamed from: y */
    public final boolean m3132y() {
        return !(this.f2409i instanceof AppCompatEditText);
    }

    /* renamed from: z */
    public final void m3133z(float f10, float f11, float f12) throws IllegalArgumentException {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f2401a = 1;
        this.f2404d = f10;
        this.f2405e = f11;
        this.f2403c = f12;
        this.f2407g = false;
    }
}
