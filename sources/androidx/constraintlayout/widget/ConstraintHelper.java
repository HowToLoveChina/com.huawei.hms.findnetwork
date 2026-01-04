package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12263j;
import p561q.InterfaceC12262i;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a */
    public int[] f2941a;

    /* renamed from: b */
    public int f2942b;

    /* renamed from: c */
    public Context f2943c;

    /* renamed from: d */
    public InterfaceC12262i f2944d;

    /* renamed from: e */
    public boolean f2945e;

    /* renamed from: f */
    public String f2946f;

    /* renamed from: g */
    public String f2947g;

    /* renamed from: h */
    public View[] f2948h;

    /* renamed from: i */
    public HashMap<Integer, String> f2949i;

    public ConstraintHelper(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.f2941a = new int[32];
        this.f2945e = false;
        this.f2948h = null;
        this.f2949i = new HashMap<>();
        this.f2943c = context;
        mo3229o(null);
    }

    /* renamed from: e */
    public final void m3556e(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.f2943c == null) {
            return;
        }
        String strTrim = str.trim();
        int iM3563m = m3563m(strTrim);
        if (iM3563m != 0) {
            this.f2949i.put(Integer.valueOf(iM3563m), strTrim);
            m3557f(iM3563m);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    /* renamed from: f */
    public final void m3557f(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f2942b + 1;
        int[] iArr = this.f2941a;
        if (i11 > iArr.length) {
            this.f2941a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2941a;
        int i12 = this.f2942b;
        iArr2[i12] = i10;
        this.f2942b = i12 + 1;
    }

    /* renamed from: g */
    public final void m3558g(String str) {
        if (str == null || str.length() == 0 || this.f2943c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && strTrim.equals(((ConstraintLayout.LayoutParams) layoutParams).f2981c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    m3557f(childAt.getId());
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2941a, this.f2942b);
    }

    /* renamed from: h */
    public void m3559h() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        m3560i((ConstraintLayout) parent);
    }

    /* renamed from: i */
    public void m3560i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            View viewById = constraintLayout.getViewById(this.f2941a[i10]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* renamed from: j */
    public void mo3256j(ConstraintLayout constraintLayout) {
    }

    /* renamed from: k */
    public final int[] m3561k(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        for (String str2 : strArrSplit) {
            int iM3563m = m3563m(str2.trim());
            if (iM3563m != 0) {
                iArr[i10] = iM3563m;
                i10++;
            }
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    /* renamed from: l */
    public final int m3562l(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f2943c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* renamed from: m */
    public final int m3563m(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iM3562l = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                iM3562l = ((Integer) designInformation).intValue();
            }
        }
        if (iM3562l == 0 && constraintLayout != null) {
            iM3562l = m3562l(constraintLayout, str);
        }
        if (iM3562l == 0) {
            try {
                iM3562l = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iM3562l == 0 ? this.f2943c.getResources().getIdentifier(str, "id", this.f2943c.getPackageName()) : iM3562l;
    }

    /* renamed from: n */
    public View[] m3564n(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2948h;
        if (viewArr == null || viewArr.length != this.f2942b) {
            this.f2948h = new View[this.f2942b];
        }
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            this.f2948h[i10] = constraintLayout.getViewById(this.f2941a[i10]);
        }
        return this.f2948h;
    }

    /* renamed from: o */
    public void mo3229o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2946f = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f2947g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f2946f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f2947g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f2945e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* renamed from: p */
    public void mo3232p(C0585c.a aVar, C12263j c12263j, ConstraintLayout.LayoutParams layoutParams, SparseArray<C12258e> sparseArray) {
        C0585c.b bVar = aVar.f3109e;
        int[] iArr = bVar.f3173k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar.f3175l0;
            if (str != null) {
                if (str.length() > 0) {
                    C0585c.b bVar2 = aVar.f3109e;
                    bVar2.f3173k0 = m3561k(bVar2.f3175l0);
                } else {
                    aVar.f3109e.f3173k0 = null;
                }
            }
        }
        if (c12263j == null) {
            return;
        }
        c12263j.mo73767b();
        if (aVar.f3109e.f3173k0 == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            int[] iArr2 = aVar.f3109e.f3173k0;
            if (i10 >= iArr2.length) {
                return;
            }
            C12258e c12258e = sparseArray.get(iArr2[i10]);
            if (c12258e != null) {
                c12263j.mo73766a(c12258e);
            }
            i10++;
        }
    }

    /* renamed from: q */
    public void mo3233q(C12258e c12258e, boolean z10) {
    }

    /* renamed from: r */
    public void mo3257r(ConstraintLayout constraintLayout) {
    }

    /* renamed from: s */
    public void m3565s(ConstraintLayout constraintLayout) {
    }

    public void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f2946f = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f2942b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                m3556e(str.substring(i10));
                return;
            } else {
                m3556e(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f2947g = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f2942b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                m3558g(str.substring(i10));
                return;
            } else {
                m3558g(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f2946f = null;
        this.f2942b = 0;
        for (int i10 : iArr) {
            m3557f(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f2946f == null) {
            m3557f(i10);
        }
    }

    /* renamed from: t */
    public void mo3258t(ConstraintLayout constraintLayout) {
    }

    /* renamed from: u */
    public void m3566u(ConstraintLayout constraintLayout) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        String str;
        int iM3562l;
        if (isInEditMode()) {
            setIds(this.f2946f);
        }
        InterfaceC12262i interfaceC12262i = this.f2944d;
        if (interfaceC12262i == null) {
            return;
        }
        interfaceC12262i.mo73767b();
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            int i11 = this.f2941a[i10];
            View viewById = constraintLayout.getViewById(i11);
            if (viewById == null && (iM3562l = m3562l(constraintLayout, (str = this.f2949i.get(Integer.valueOf(i11))))) != 0) {
                this.f2941a[i10] = iM3562l;
                this.f2949i.put(Integer.valueOf(iM3562l), str);
                viewById = constraintLayout.getViewById(iM3562l);
            }
            if (viewById != null) {
                this.f2944d.mo73766a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f2944d.mo73768c(constraintLayout.mLayoutWidget);
    }

    /* renamed from: v */
    public void mo3265v(C12259f c12259f, InterfaceC12262i interfaceC12262i, SparseArray<C12258e> sparseArray) {
        interfaceC12262i.mo73767b();
        for (int i10 = 0; i10 < this.f2942b; i10++) {
            interfaceC12262i.mo73766a(sparseArray.get(this.f2941a[i10]));
        }
    }

    /* renamed from: w */
    public void m3567w() {
        if (this.f2944d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f3019v0 = (C12258e) this.f2944d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f2941a = new int[32];
        this.f2945e = false;
        this.f2948h = null;
        this.f2949i = new HashMap<>();
        this.f2943c = context;
        mo3229o(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet, i10);
        this.f2941a = new int[32];
        this.f2945e = false;
        this.f2948h = null;
        this.f2949i = new HashMap<>();
        this.f2943c = context;
        mo3229o(attributeSet);
    }
}
