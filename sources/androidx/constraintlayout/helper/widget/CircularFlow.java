package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {

    /* renamed from: v */
    public static int f2495v;

    /* renamed from: w */
    public static float f2496w;

    /* renamed from: l */
    public ConstraintLayout f2497l;

    /* renamed from: m */
    public int f2498m;

    /* renamed from: n */
    public float[] f2499n;

    /* renamed from: o */
    public int[] f2500o;

    /* renamed from: p */
    public int f2501p;

    /* renamed from: q */
    public int f2502q;

    /* renamed from: r */
    public String f2503r;

    /* renamed from: s */
    public String f2504s;

    /* renamed from: t */
    public Float f2505t;

    /* renamed from: u */
    public Integer f2506u;

    public CircularFlow(Context context) {
        super(context);
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f2502q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                m3230y(str.substring(i10).trim());
                return;
            } else {
                m3230y(str.substring(i10, iIndexOf).trim());
                i10 = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f2501p = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                m3231z(str.substring(i10).trim());
                return;
            } else {
                m3231z(str.substring(i10, iIndexOf).trim());
                i10 = iIndexOf + 1;
            }
        }
    }

    /* renamed from: A */
    public final void m3228A() {
        this.f2497l = (ConstraintLayout) getParent();
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            View viewById = this.f2497l.getViewById(this.f2941a[i10]);
            if (viewById != null) {
                int i11 = f2495v;
                float f10 = f2496w;
                int[] iArr = this.f2500o;
                if (iArr == null || i10 >= iArr.length) {
                    Integer num = this.f2506u;
                    if (num == null || num.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + this.f2949i.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.f2501p++;
                        if (this.f2500o == null) {
                            this.f2500o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f2500o = radius;
                        radius[this.f2501p - 1] = i11;
                    }
                } else {
                    i11 = iArr[i10];
                }
                float[] fArr = this.f2499n;
                if (fArr == null || i10 >= fArr.length) {
                    Float f11 = this.f2505t;
                    if (f11 == null || f11.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + this.f2949i.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.f2502q++;
                        if (this.f2499n == null) {
                            this.f2499n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f2499n = angles;
                        angles[this.f2502q - 1] = f10;
                    }
                } else {
                    f10 = fArr[i10];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.f3010r = f10;
                layoutParams.f3006p = this.f2498m;
                layoutParams.f3008q = i11;
                viewById.setLayoutParams(layoutParams);
            }
        }
        m3559h();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f2499n, this.f2502q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f2500o, this.f2501p);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.mo3229o(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f2498m = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2503r = string;
                    setAngles(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f2504s = string2;
                    setRadius(string2);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, f2496w));
                    this.f2505t = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, f2495v));
                    this.f2506u = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f2503r;
        if (str != null) {
            this.f2499n = new float[1];
            setAngles(str);
        }
        String str2 = this.f2504s;
        if (str2 != null) {
            this.f2500o = new int[1];
            setRadius(str2);
        }
        Float f10 = this.f2505t;
        if (f10 != null) {
            setDefaultAngle(f10.floatValue());
        }
        Integer num = this.f2506u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        m3228A();
    }

    public void setDefaultAngle(float f10) {
        f2496w = f10;
    }

    public void setDefaultRadius(int i10) {
        f2495v = i10;
    }

    /* renamed from: y */
    public final void m3230y(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f2943c == null || (fArr = this.f2499n) == null) {
            return;
        }
        if (this.f2502q + 1 > fArr.length) {
            this.f2499n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f2499n[this.f2502q] = Integer.parseInt(str);
        this.f2502q++;
    }

    /* renamed from: z */
    public final void m3231z(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.f2943c == null || (iArr = this.f2500o) == null) {
            return;
        }
        if (this.f2501p + 1 > iArr.length) {
            this.f2500o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f2500o[this.f2501p] = (int) (Integer.parseInt(str) * this.f2943c.getResources().getDisplayMetrics().density);
        this.f2501p++;
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
