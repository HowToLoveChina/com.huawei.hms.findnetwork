package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9620q;
import p304g0.C9832l;
import p356i3.C10420a;
import p356i3.C10432m;
import p356i3.InterfaceC10422c;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k */
    public static final String f7693k = "MaterialButtonToggleGroup";

    /* renamed from: l */
    public static final int f7694l = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a */
    public final List<C1694c> f7695a;

    /* renamed from: b */
    public final C1696e f7696b;

    /* renamed from: c */
    public final LinkedHashSet<InterfaceC1695d> f7697c;

    /* renamed from: d */
    public final Comparator<MaterialButton> f7698d;

    /* renamed from: e */
    public Integer[] f7699e;

    /* renamed from: f */
    public boolean f7700f;

    /* renamed from: g */
    public boolean f7701g;

    /* renamed from: h */
    public boolean f7702h;

    /* renamed from: i */
    public final int f7703i;

    /* renamed from: j */
    public Set<Integer> f7704j;

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$a */
    public class C1692a implements Comparator<MaterialButton> {
        public C1692a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$b */
    public class C1693b extends C9582a {
        public C1693b() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            c9832l.m61068X(C9832l.c.m61127a(0, 1, MaterialButtonToggleGroup.this.m9932i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$c */
    public static class C1694c {

        /* renamed from: e */
        public static final InterfaceC10422c f7707e = new C10420a(0.0f);

        /* renamed from: a */
        public InterfaceC10422c f7708a;

        /* renamed from: b */
        public InterfaceC10422c f7709b;

        /* renamed from: c */
        public InterfaceC10422c f7710c;

        /* renamed from: d */
        public InterfaceC10422c f7711d;

        public C1694c(InterfaceC10422c interfaceC10422c, InterfaceC10422c interfaceC10422c2, InterfaceC10422c interfaceC10422c3, InterfaceC10422c interfaceC10422c4) {
            this.f7708a = interfaceC10422c;
            this.f7709b = interfaceC10422c3;
            this.f7710c = interfaceC10422c4;
            this.f7711d = interfaceC10422c2;
        }

        /* renamed from: a */
        public static C1694c m9943a(C1694c c1694c) {
            InterfaceC10422c interfaceC10422c = f7707e;
            return new C1694c(interfaceC10422c, c1694c.f7711d, interfaceC10422c, c1694c.f7710c);
        }

        /* renamed from: b */
        public static C1694c m9944b(C1694c c1694c, View view) {
            return C1788s.m10788i(view) ? m9945c(c1694c) : m9946d(c1694c);
        }

        /* renamed from: c */
        public static C1694c m9945c(C1694c c1694c) {
            InterfaceC10422c interfaceC10422c = c1694c.f7708a;
            InterfaceC10422c interfaceC10422c2 = c1694c.f7711d;
            InterfaceC10422c interfaceC10422c3 = f7707e;
            return new C1694c(interfaceC10422c, interfaceC10422c2, interfaceC10422c3, interfaceC10422c3);
        }

        /* renamed from: d */
        public static C1694c m9946d(C1694c c1694c) {
            InterfaceC10422c interfaceC10422c = f7707e;
            return new C1694c(interfaceC10422c, interfaceC10422c, c1694c.f7709b, c1694c.f7710c);
        }

        /* renamed from: e */
        public static C1694c m9947e(C1694c c1694c, View view) {
            return C1788s.m10788i(view) ? m9946d(c1694c) : m9945c(c1694c);
        }

        /* renamed from: f */
        public static C1694c m9948f(C1694c c1694c) {
            InterfaceC10422c interfaceC10422c = c1694c.f7708a;
            InterfaceC10422c interfaceC10422c2 = f7707e;
            return new C1694c(interfaceC10422c, interfaceC10422c2, c1694c.f7709b, interfaceC10422c2);
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$d */
    public interface InterfaceC1695d {
        /* renamed from: a */
        void mo9949a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    /* renamed from: com.google.android.material.button.MaterialButtonToggleGroup$e */
    public class C1696e implements MaterialButton.InterfaceC1691b {
        public C1696e() {
        }

        @Override // com.google.android.material.button.MaterialButton.InterfaceC1691b
        /* renamed from: a */
        public void mo9922a(MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ C1696e(MaterialButtonToggleGroup materialButtonToggleGroup, C1692a c1692a) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (m9934k(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m9934k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && m9934k(i11)) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: p */
    public static void m9924p(C10432m.b bVar, C1694c c1694c) {
        if (c1694c == null) {
            bVar.m64094o(0.0f);
        } else {
            bVar.m64088F(c1694c.f7708a).m64102w(c1694c.f7711d).m64092J(c1694c.f7709b).m64083A(c1694c.f7710c);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(C9603h0.m59891k());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f7696b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f7693k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        m9928e(materialButton.getId(), materialButton.isChecked());
        C10432m shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f7695a.add(new C1694c(shapeAppearanceModel.m64062r(), shapeAppearanceModel.m64055j(), shapeAppearanceModel.m64064t(), shapeAppearanceModel.m64057l()));
        C9603h0.m59902p0(materialButton, new C1693b());
    }

    /* renamed from: b */
    public void m9925b(InterfaceC1695d interfaceC1695d) {
        this.f7697c.add(interfaceC1695d);
    }

    /* renamed from: c */
    public final void m9926c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
            MaterialButton materialButtonM9931h = m9931h(i10);
            int iMin = Math.min(materialButtonM9931h.getStrokeWidth(), m9931h(i10 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsM9927d = m9927d(materialButtonM9931h);
            if (getOrientation() == 0) {
                C9620q.m60125c(layoutParamsM9927d, 0);
                C9620q.m60126d(layoutParamsM9927d, -iMin);
                layoutParamsM9927d.topMargin = 0;
            } else {
                layoutParamsM9927d.bottomMargin = 0;
                layoutParamsM9927d.topMargin = -iMin;
                C9620q.m60126d(layoutParamsM9927d, 0);
            }
            materialButtonM9931h.setLayoutParams(layoutParamsM9927d);
        }
        m9937n(firstVisibleChildIndex);
    }

    /* renamed from: d */
    public final LinearLayout.LayoutParams m9927d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        m9940r();
        super.dispatchDraw(canvas);
    }

    /* renamed from: e */
    public final void m9928e(int i10, boolean z10) {
        if (i10 == -1) {
            Log.e(f7693k, "Button ID is not valid: " + i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f7704j);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f7701g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i10))) {
                return;
            }
            if (!this.f7702h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        }
        m9939q(hashSet);
    }

    /* renamed from: f */
    public void m9929f() {
        m9939q(new HashSet());
    }

    /* renamed from: g */
    public final void m9930g(int i10, boolean z10) {
        Iterator<InterfaceC1695d> it = this.f7697c.iterator();
        while (it.hasNext()) {
            it.next().mo9949a(this, i10, z10);
        }
    }

    public int getCheckedButtonId() {
        if (!this.f7701g || this.f7704j.isEmpty()) {
            return -1;
        }
        return this.f7704j.iterator().next().intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = m9931h(i10).getId();
            if (this.f7704j.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f7699e;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w(f7693k, "Child order wasn't updated");
        return i11;
    }

    /* renamed from: h */
    public final MaterialButton m9931h(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    /* renamed from: i */
    public final int m9932i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && m9934k(i11)) {
                i10++;
            }
        }
        return -1;
    }

    /* renamed from: j */
    public final C1694c m9933j(int i10, int i11, int i12) {
        C1694c c1694c = this.f7695a.get(i10);
        if (i11 == i12) {
            return c1694c;
        }
        boolean z10 = getOrientation() == 0;
        if (i10 == i11) {
            return z10 ? C1694c.m9947e(c1694c, this) : C1694c.m9948f(c1694c);
        }
        if (i10 == i12) {
            return z10 ? C1694c.m9944b(c1694c, this) : C1694c.m9943a(c1694c);
        }
        return null;
    }

    /* renamed from: k */
    public final boolean m9934k(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    /* renamed from: l */
    public boolean m9935l() {
        return this.f7701g;
    }

    /* renamed from: m */
    public void m9936m(MaterialButton materialButton, boolean z10) {
        if (this.f7700f) {
            return;
        }
        m9928e(materialButton.getId(), z10);
    }

    /* renamed from: n */
    public final void m9937n(int i10) {
        if (getChildCount() == 0 || i10 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) m9931h(i10).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            C9620q.m60125c(layoutParams, 0);
            C9620q.m60126d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    /* renamed from: o */
    public final void m9938o(int i10, boolean z10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById instanceof MaterialButton) {
            this.f7700f = true;
            ((MaterialButton) viewFindViewById).setChecked(z10);
            this.f7700f = false;
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f7703i;
        if (i10 != -1) {
            m9939q(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C9832l.m61042A0(accessibilityNodeInfo).m61067W(C9832l.b.m61126b(1, getVisibleButtonCount(), false, m9935l() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        m9941s();
        m9926c();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f7695a.remove(iIndexOfChild);
        }
        m9941s();
        m9926c();
    }

    /* renamed from: q */
    public final void m9939q(Set<Integer> set) {
        Set<Integer> set2 = this.f7704j;
        this.f7704j = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = m9931h(i10).getId();
            m9938o(id2, set.contains(Integer.valueOf(id2)));
            if (set2.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                m9930g(id2, set.contains(Integer.valueOf(id2)));
            }
        }
        invalidate();
    }

    /* renamed from: r */
    public final void m9940r() {
        TreeMap treeMap = new TreeMap(this.f7698d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(m9931h(i10), Integer.valueOf(i10));
        }
        this.f7699e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    /* renamed from: s */
    public void m9941s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton materialButtonM9931h = m9931h(i10);
            if (materialButtonM9931h.getVisibility() != 8) {
                C10432m.b bVarM64066v = materialButtonM9931h.getShapeAppearanceModel().m64066v();
                m9924p(bVarM64066v, m9933j(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonM9931h.setShapeAppearanceModel(bVarM64066v.m64093m());
            }
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f7702h = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f7701g != z10) {
            this.f7701g = z10;
            m9929f();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7694l;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f7695a = new ArrayList();
        this.f7696b = new C1696e(this, null);
        this.f7697c = new LinkedHashSet<>();
        this.f7698d = new C1692a();
        this.f7700f = false;
        this.f7704j = new HashSet();
        TypedArray typedArrayM10770h = C1784o.m10770h(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i10, i11, new int[0]);
        setSingleSelection(typedArrayM10770h.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f7703i = typedArrayM10770h.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f7702h = typedArrayM10770h.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayM10770h.recycle();
        C9603h0.m59833A0(this, 1);
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
