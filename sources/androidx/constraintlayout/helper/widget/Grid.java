package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class Grid extends VirtualLayout {

    /* renamed from: A */
    public int f2508A;

    /* renamed from: B */
    public boolean f2509B;

    /* renamed from: C */
    public boolean f2510C;

    /* renamed from: D */
    public boolean[][] f2511D;

    /* renamed from: E */
    public Set<Integer> f2512E;

    /* renamed from: F */
    public int[] f2513F;

    /* renamed from: l */
    public final int f2514l;

    /* renamed from: m */
    public final int f2515m;

    /* renamed from: n */
    public View[] f2516n;

    /* renamed from: o */
    public ConstraintLayout f2517o;

    /* renamed from: p */
    public int f2518p;

    /* renamed from: q */
    public int f2519q;

    /* renamed from: r */
    public int f2520r;

    /* renamed from: s */
    public int f2521s;

    /* renamed from: t */
    public String f2522t;

    /* renamed from: u */
    public String f2523u;

    /* renamed from: v */
    public String f2524v;

    /* renamed from: w */
    public String f2525w;

    /* renamed from: x */
    public float f2526x;

    /* renamed from: y */
    public float f2527y;

    /* renamed from: z */
    public int f2528z;

    public Grid(Context context) {
        super(context);
        this.f2514l = 50;
        this.f2515m = 50;
        this.f2508A = 0;
        this.f2512E = new HashSet();
    }

    private int getNextPosition() {
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            i10 = this.f2508A;
            if (i10 >= this.f2518p * this.f2520r) {
                return -1;
            }
            int iM3240F = m3240F(i10);
            int iM3239E = m3239E(this.f2508A);
            boolean[] zArr = this.f2511D[iM3240F];
            if (zArr[iM3239E]) {
                zArr[iM3239E] = false;
                z10 = true;
            }
            this.f2508A++;
        }
        return i10;
    }

    /* renamed from: A */
    public final void m3235A(View view) {
        ConstraintLayout.LayoutParams layoutParamsM3248N = m3248N(view);
        layoutParamsM3248N.f2961L = -1.0f;
        layoutParamsM3248N.f2986f = -1;
        layoutParamsM3248N.f2984e = -1;
        layoutParamsM3248N.f2988g = -1;
        layoutParamsM3248N.f2990h = -1;
        ((ViewGroup.MarginLayoutParams) layoutParamsM3248N).leftMargin = -1;
        view.setLayoutParams(layoutParamsM3248N);
    }

    /* renamed from: B */
    public final void m3236B(View view) {
        ConstraintLayout.LayoutParams layoutParamsM3248N = m3248N(view);
        layoutParamsM3248N.f2962M = -1.0f;
        layoutParamsM3248N.f2994j = -1;
        layoutParamsM3248N.f2992i = -1;
        layoutParamsM3248N.f2996k = -1;
        layoutParamsM3248N.f2998l = -1;
        ((ViewGroup.MarginLayoutParams) layoutParamsM3248N).topMargin = -1;
        view.setLayoutParams(layoutParamsM3248N);
    }

    /* renamed from: C */
    public final void m3237C(View view, int i10, int i11, int i12, int i13) {
        ConstraintLayout.LayoutParams layoutParamsM3248N = m3248N(view);
        int[] iArr = this.f2513F;
        layoutParamsM3248N.f2984e = iArr[i11];
        layoutParamsM3248N.f2992i = iArr[i10];
        layoutParamsM3248N.f2990h = iArr[(i11 + i13) - 1];
        layoutParamsM3248N.f2998l = iArr[(i10 + i12) - 1];
        view.setLayoutParams(layoutParamsM3248N);
    }

    /* renamed from: D */
    public final boolean m3238D(boolean z10) {
        int[][] iArrM3249O;
        int[][] iArrM3249O2;
        if (this.f2517o == null || this.f2518p < 1 || this.f2520r < 1) {
            return false;
        }
        if (z10) {
            for (int i10 = 0; i10 < this.f2511D.length; i10++) {
                int i11 = 0;
                while (true) {
                    boolean[][] zArr = this.f2511D;
                    if (i11 < zArr[0].length) {
                        zArr[i10][i11] = true;
                        i11++;
                    }
                }
            }
            this.f2512E.clear();
        }
        this.f2508A = 0;
        m3255z();
        String str = this.f2523u;
        boolean zM3241G = (str == null || str.trim().isEmpty() || (iArrM3249O2 = m3249O(this.f2523u)) == null) ? true : m3241G(iArrM3249O2) & true;
        String str2 = this.f2522t;
        if (str2 != null && !str2.trim().isEmpty() && (iArrM3249O = m3249O(this.f2522t)) != null) {
            zM3241G &= m3242H(this.f2941a, iArrM3249O);
        }
        return (zM3241G && m3254y()) || !this.f2509B;
    }

    /* renamed from: E */
    public final int m3239E(int i10) {
        return this.f2528z == 1 ? i10 / this.f2518p : i10 % this.f2520r;
    }

    /* renamed from: F */
    public final int m3240F(int i10) {
        return this.f2528z == 1 ? i10 % this.f2518p : i10 / this.f2520r;
    }

    /* renamed from: G */
    public final boolean m3241G(int[][] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            int iM3240F = m3240F(iArr[i10][0]);
            int iM3239E = m3239E(iArr[i10][0]);
            int[] iArr2 = iArr[i10];
            if (!m3244J(iM3240F, iM3239E, iArr2[1], iArr2[2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: H */
    public final boolean m3242H(int[] iArr, int[][] iArr2) {
        View[] viewArrM3564n = m3564n(this.f2517o);
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            int iM3240F = m3240F(iArr2[i10][0]);
            int iM3239E = m3239E(iArr2[i10][0]);
            int[] iArr3 = iArr2[i10];
            if (!m3244J(iM3240F, iM3239E, iArr3[1], iArr3[2])) {
                return false;
            }
            View view = viewArrM3564n[i10];
            int[] iArr4 = iArr2[i10];
            m3237C(view, iM3240F, iM3239E, iArr4[1], iArr4[2]);
            this.f2512E.add(Integer.valueOf(iArr[i10]));
        }
        return true;
    }

    /* renamed from: I */
    public final void m3243I() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.f2518p, this.f2520r);
        this.f2511D = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
    }

    /* renamed from: J */
    public final boolean m3244J(int i10, int i11, int i12, int i13) {
        for (int i14 = i10; i14 < i10 + i12; i14++) {
            for (int i15 = i11; i15 < i11 + i13; i15++) {
                boolean[][] zArr = this.f2511D;
                if (i14 < zArr.length && i15 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i14];
                    if (zArr2[i15]) {
                        zArr2[i15] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: K */
    public final boolean m3245K(CharSequence charSequence) {
        return true;
    }

    /* renamed from: L */
    public final boolean m3246L(String str) {
        return true;
    }

    /* renamed from: M */
    public final View m3247M() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.f2517o.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    /* renamed from: N */
    public final ConstraintLayout.LayoutParams m3248N(View view) {
        return (ConstraintLayout.LayoutParams) view.getLayoutParams();
    }

    /* renamed from: O */
    public final int[][] m3249O(String str) {
        if (!m3245K(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].trim().split(":");
            String[] strArrSplit3 = strArrSplit2[1].split(Constants.MULTIPLE_SIGN);
            iArr[i10][0] = Integer.parseInt(strArrSplit2[0]);
            iArr[i10][1] = Integer.parseInt(strArrSplit3[0]);
            iArr[i10][2] = Integer.parseInt(strArrSplit3[1]);
        }
        return iArr;
    }

    /* renamed from: P */
    public final float[] m3250P(int i10, String str) {
        float[] fArr = null;
        if (str != null && !str.trim().isEmpty()) {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length != i10) {
                return null;
            }
            fArr = new float[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                fArr[i11] = Float.parseFloat(strArrSplit[i11].trim());
            }
        }
        return fArr;
    }

    /* renamed from: Q */
    public final void m3251Q() {
        int i10;
        int id2 = getId();
        int iMax = Math.max(this.f2518p, this.f2520r);
        float[] fArrM3250P = m3250P(this.f2520r, this.f2525w);
        int i11 = 0;
        ConstraintLayout.LayoutParams layoutParamsM3248N = m3248N(this.f2516n[0]);
        if (this.f2520r == 1) {
            m3235A(this.f2516n[0]);
            layoutParamsM3248N.f2984e = id2;
            layoutParamsM3248N.f2990h = id2;
            this.f2516n[0].setLayoutParams(layoutParamsM3248N);
            return;
        }
        while (true) {
            i10 = this.f2520r;
            if (i11 >= i10) {
                break;
            }
            ConstraintLayout.LayoutParams layoutParamsM3248N2 = m3248N(this.f2516n[i11]);
            m3235A(this.f2516n[i11]);
            if (fArrM3250P != null) {
                layoutParamsM3248N2.f2961L = fArrM3250P[i11];
            }
            if (i11 > 0) {
                layoutParamsM3248N2.f2986f = this.f2513F[i11 - 1];
            } else {
                layoutParamsM3248N2.f2984e = id2;
            }
            if (i11 < this.f2520r - 1) {
                layoutParamsM3248N2.f2988g = this.f2513F[i11 + 1];
            } else {
                layoutParamsM3248N2.f2990h = id2;
            }
            if (i11 > 0) {
                ((ViewGroup.MarginLayoutParams) layoutParamsM3248N2).leftMargin = (int) this.f2526x;
            }
            this.f2516n[i11].setLayoutParams(layoutParamsM3248N2);
            i11++;
        }
        while (i10 < iMax) {
            ConstraintLayout.LayoutParams layoutParamsM3248N3 = m3248N(this.f2516n[i10]);
            m3235A(this.f2516n[i10]);
            layoutParamsM3248N3.f2984e = id2;
            layoutParamsM3248N3.f2990h = id2;
            this.f2516n[i10].setLayoutParams(layoutParamsM3248N3);
            i10++;
        }
    }

    /* renamed from: R */
    public final void m3252R() {
        int i10;
        int id2 = getId();
        int iMax = Math.max(this.f2518p, this.f2520r);
        float[] fArrM3250P = m3250P(this.f2518p, this.f2524v);
        int i11 = 0;
        if (this.f2518p == 1) {
            ConstraintLayout.LayoutParams layoutParamsM3248N = m3248N(this.f2516n[0]);
            m3236B(this.f2516n[0]);
            layoutParamsM3248N.f2992i = id2;
            layoutParamsM3248N.f2998l = id2;
            this.f2516n[0].setLayoutParams(layoutParamsM3248N);
            return;
        }
        while (true) {
            i10 = this.f2518p;
            if (i11 >= i10) {
                break;
            }
            ConstraintLayout.LayoutParams layoutParamsM3248N2 = m3248N(this.f2516n[i11]);
            m3236B(this.f2516n[i11]);
            if (fArrM3250P != null) {
                layoutParamsM3248N2.f2962M = fArrM3250P[i11];
            }
            if (i11 > 0) {
                layoutParamsM3248N2.f2994j = this.f2513F[i11 - 1];
            } else {
                layoutParamsM3248N2.f2992i = id2;
            }
            if (i11 < this.f2518p - 1) {
                layoutParamsM3248N2.f2996k = this.f2513F[i11 + 1];
            } else {
                layoutParamsM3248N2.f2998l = id2;
            }
            if (i11 > 0) {
                ((ViewGroup.MarginLayoutParams) layoutParamsM3248N2).topMargin = (int) this.f2526x;
            }
            this.f2516n[i11].setLayoutParams(layoutParamsM3248N2);
            i11++;
        }
        while (i10 < iMax) {
            ConstraintLayout.LayoutParams layoutParamsM3248N3 = m3248N(this.f2516n[i10]);
            m3236B(this.f2516n[i10]);
            layoutParamsM3248N3.f2992i = id2;
            layoutParamsM3248N3.f2998l = id2;
            this.f2516n[i10].setLayoutParams(layoutParamsM3248N3);
            i10++;
        }
    }

    /* renamed from: S */
    public final void m3253S() {
        int i10;
        int i11 = this.f2519q;
        if (i11 != 0 && (i10 = this.f2521s) != 0) {
            this.f2518p = i11;
            this.f2520r = i10;
            return;
        }
        int i12 = this.f2521s;
        if (i12 > 0) {
            this.f2520r = i12;
            this.f2518p = ((this.f2942b + i12) - 1) / i12;
        } else if (i11 > 0) {
            this.f2518p = i11;
            this.f2520r = ((this.f2942b + i11) - 1) / i11;
        } else {
            int iSqrt = (int) (Math.sqrt(this.f2942b) + 1.5d);
            this.f2518p = iSqrt;
            this.f2520r = ((this.f2942b + iSqrt) - 1) / iSqrt;
        }
    }

    public String getColumnWeights() {
        return this.f2525w;
    }

    public int getColumns() {
        return this.f2521s;
    }

    public float getHorizontalGaps() {
        return this.f2526x;
    }

    public int getOrientation() {
        return this.f2528z;
    }

    public String getRowWeights() {
        return this.f2524v;
    }

    public int getRows() {
        return this.f2519q;
    }

    public String getSkips() {
        return this.f2523u;
    }

    public String getSpans() {
        return this.f2522t;
    }

    public float getVerticalGaps() {
        return this.f2527y;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        this.f2945e = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.Grid);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.Grid_grid_rows) {
                    this.f2519q = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R$styleable.Grid_grid_columns) {
                    this.f2521s = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R$styleable.Grid_grid_spans) {
                    this.f2522t = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.Grid_grid_skips) {
                    this.f2523u = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.Grid_grid_rowWeights) {
                    this.f2524v = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.Grid_grid_columnWeights) {
                    this.f2525w = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R$styleable.Grid_grid_orientation) {
                    this.f2528z = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R$styleable.Grid_grid_horizontalGaps) {
                    this.f2526x = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R$styleable.Grid_grid_verticalGaps) {
                    this.f2527y = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R$styleable.Grid_grid_validateInputs) {
                    this.f2509B = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.Grid_grid_useRtl) {
                    this.f2510C = typedArrayObtainStyledAttributes.getBoolean(index, false);
                }
            }
            m3253S();
            m3243I();
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        this.f2517o = (ConstraintLayout) getParent();
        m3238D(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            Paint paint = new Paint();
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.STROKE);
            int top = getTop();
            int left = getLeft();
            int bottom = getBottom();
            int right = getRight();
            for (View view : this.f2516n) {
                int left2 = view.getLeft() - left;
                int top2 = view.getTop() - top;
                int right2 = view.getRight() - left;
                int bottom2 = view.getBottom() - top;
                canvas.drawRect(left2, 0.0f, right2, bottom - top, paint);
                canvas.drawRect(0.0f, top2, right - left, bottom2, paint);
            }
        }
    }

    public void setColumnWeights(String str) {
        if (m3246L(str)) {
            String str2 = this.f2525w;
            if (str2 == null || !str2.equals(str)) {
                this.f2525w = str;
                m3238D(true);
                invalidate();
            }
        }
    }

    public void setColumns(int i10) {
        if (i10 <= 50 && this.f2521s != i10) {
            this.f2521s = i10;
            m3253S();
            m3243I();
            m3238D(false);
            invalidate();
        }
    }

    public void setHorizontalGaps(float f10) {
        if (f10 >= 0.0f && this.f2526x != f10) {
            this.f2526x = f10;
            m3238D(true);
            invalidate();
        }
    }

    public void setOrientation(int i10) {
        if ((i10 == 0 || i10 == 1) && this.f2528z != i10) {
            this.f2528z = i10;
            m3238D(true);
            invalidate();
        }
    }

    public void setRowWeights(String str) {
        if (m3246L(str)) {
            String str2 = this.f2524v;
            if (str2 == null || !str2.equals(str)) {
                this.f2524v = str;
                m3238D(true);
                invalidate();
            }
        }
    }

    public void setRows(int i10) {
        if (i10 <= 50 && this.f2519q != i10) {
            this.f2519q = i10;
            m3253S();
            m3243I();
            m3238D(false);
            invalidate();
        }
    }

    public void setSkips(String str) {
        if (m3245K(str)) {
            String str2 = this.f2523u;
            if (str2 == null || !str2.equals(str)) {
                this.f2523u = str;
                m3238D(true);
                invalidate();
            }
        }
    }

    public void setSpans(CharSequence charSequence) {
        if (m3245K(charSequence)) {
            String str = this.f2522t;
            if (str == null || !str.contentEquals(charSequence)) {
                this.f2522t = charSequence.toString();
                m3238D(true);
                invalidate();
            }
        }
    }

    public void setVerticalGaps(float f10) {
        if (f10 >= 0.0f && this.f2527y != f10) {
            this.f2527y = f10;
            m3238D(true);
            invalidate();
        }
    }

    /* renamed from: y */
    public final boolean m3254y() {
        View[] viewArrM3564n = m3564n(this.f2517o);
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            if (!this.f2512E.contains(Integer.valueOf(this.f2941a[i10]))) {
                int nextPosition = getNextPosition();
                int iM3240F = m3240F(nextPosition);
                int iM3239E = m3239E(nextPosition);
                if (nextPosition == -1) {
                    return false;
                }
                m3237C(viewArrM3564n[i10], iM3240F, iM3239E, 1, 1);
            }
        }
        return true;
    }

    /* renamed from: z */
    public final void m3255z() {
        int iMax = Math.max(this.f2518p, this.f2520r);
        View[] viewArr = this.f2516n;
        int i10 = 0;
        if (viewArr == null) {
            this.f2516n = new View[iMax];
            int i11 = 0;
            while (true) {
                View[] viewArr2 = this.f2516n;
                if (i11 >= viewArr2.length) {
                    break;
                }
                viewArr2[i11] = m3247M();
                i11++;
            }
        } else if (iMax != viewArr.length) {
            View[] viewArr3 = new View[iMax];
            for (int i12 = 0; i12 < iMax; i12++) {
                View[] viewArr4 = this.f2516n;
                if (i12 < viewArr4.length) {
                    viewArr3[i12] = viewArr4[i12];
                } else {
                    viewArr3[i12] = m3247M();
                }
            }
            int i13 = iMax;
            while (true) {
                View[] viewArr5 = this.f2516n;
                if (i13 >= viewArr5.length) {
                    break;
                }
                this.f2517o.removeView(viewArr5[i13]);
                i13++;
            }
            this.f2516n = viewArr3;
        }
        this.f2513F = new int[iMax];
        while (true) {
            View[] viewArr6 = this.f2516n;
            if (i10 >= viewArr6.length) {
                m3252R();
                m3251Q();
                return;
            } else {
                this.f2513F[i10] = viewArr6[i10].getId();
                i10++;
            }
        }
    }

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2514l = 50;
        this.f2515m = 50;
        this.f2508A = 0;
        this.f2512E = new HashSet();
    }

    public Grid(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2514l = 50;
        this.f2515m = 50;
        this.f2508A = 0;
        this.f2512E = new HashSet();
    }
}
