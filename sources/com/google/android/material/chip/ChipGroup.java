package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1770a;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.FlowLayout;
import java.util.List;
import java.util.Set;
import p273f0.C9603h0;
import p304g0.C9832l;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* renamed from: k */
    public static final int f7774k = R$style.Widget_MaterialComponents_ChipGroup;

    /* renamed from: e */
    public int f7775e;

    /* renamed from: f */
    public int f7776f;

    /* renamed from: g */
    public InterfaceC1706d f7777g;

    /* renamed from: h */
    public final C1770a<Chip> f7778h;

    /* renamed from: i */
    public final int f7779i;

    /* renamed from: j */
    public final ViewGroupOnHierarchyChangeListenerC1707e f7780j;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }
    }

    /* renamed from: com.google.android.material.chip.ChipGroup$a */
    public class C1703a implements C1770a.b {
        public C1703a() {
        }

        @Override // com.google.android.material.internal.C1770a.b
        /* renamed from: a */
        public void mo10033a(Set<Integer> set) {
            if (ChipGroup.this.f7777g != null) {
                InterfaceC1706d interfaceC1706d = ChipGroup.this.f7777g;
                ChipGroup chipGroup = ChipGroup.this;
                interfaceC1706d.mo10034a(chipGroup, chipGroup.f7778h.m10577j(ChipGroup.this));
            }
        }
    }

    /* renamed from: com.google.android.material.chip.ChipGroup$b */
    public class C1704b implements InterfaceC1706d {
        public C1704b(InterfaceC1705c interfaceC1705c) {
        }

        @Override // com.google.android.material.chip.ChipGroup.InterfaceC1706d
        /* renamed from: a */
        public void mo10034a(ChipGroup chipGroup, List<Integer> list) {
            if (ChipGroup.this.f7778h.m10579l()) {
                ChipGroup.this.getCheckedChipId();
                throw null;
            }
        }
    }

    @Deprecated
    /* renamed from: com.google.android.material.chip.ChipGroup$c */
    public interface InterfaceC1705c {
    }

    /* renamed from: com.google.android.material.chip.ChipGroup$d */
    public interface InterfaceC1706d {
        /* renamed from: a */
        void mo10034a(ChipGroup chipGroup, List<Integer> list);
    }

    /* renamed from: com.google.android.material.chip.ChipGroup$e */
    public class ViewGroupOnHierarchyChangeListenerC1707e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a */
        public ViewGroup.OnHierarchyChangeListener f7783a;

        public ViewGroupOnHierarchyChangeListenerC1707e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(C9603h0.m59891k());
                }
                ChipGroup.this.f7778h.m10572e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f7783a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.f7778h.m10581n((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f7783a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }

        public /* synthetic */ ViewGroupOnHierarchyChangeListenerC1707e(ChipGroup chipGroup, C1703a c1703a) {
            this();
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof Chip) {
                i10++;
            }
        }
        return i10;
    }

    @Override // com.google.android.material.internal.FlowLayout
    /* renamed from: c */
    public boolean mo10030c() {
        return super.mo10030c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* renamed from: g */
    public int m10031g(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof Chip) {
                if (((Chip) getChildAt(i11)) == view) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.f7778h.m10578k();
    }

    public List<Integer> getCheckedChipIds() {
        return this.f7778h.m10577j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f7775e;
    }

    public int getChipSpacingVertical() {
        return this.f7776f;
    }

    /* renamed from: h */
    public boolean m10032h() {
        return this.f7778h.m10579l();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f7779i;
        if (i10 != -1) {
            this.f7778h.m10573f(i10);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C9832l.m61042A0(accessibilityNodeInfo).m61067W(C9832l.b.m61126b(getRowCount(), mo10030c() ? getChipCount() : -1, false, m10032h() ? 1 : 2));
    }

    public void setChipSpacing(int i10) {
        setChipSpacingHorizontal(i10);
        setChipSpacingVertical(i10);
    }

    public void setChipSpacingHorizontal(int i10) {
        if (this.f7775e != i10) {
            this.f7775e = i10;
            setItemSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingResource(int i10) {
        setChipSpacing(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingVertical(int i10) {
        if (this.f7776f != i10) {
            this.f7776f = i10;
            setLineSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(InterfaceC1705c interfaceC1705c) {
        if (interfaceC1705c == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new C1704b(interfaceC1705c));
        }
    }

    public void setOnCheckedStateChangeListener(InterfaceC1706d interfaceC1706d) {
        this.f7777g = interfaceC1706d;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f7780j.f7783a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z10) {
        this.f7778h.m10583p(z10);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(boolean z10) {
        this.f7778h.m10584q(z10);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(int i10) {
        setSingleLine(getResources().getBoolean(i10));
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7774k;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        C1770a<Chip> c1770a = new C1770a<>();
        this.f7778h = c1770a;
        ViewGroupOnHierarchyChangeListenerC1707e viewGroupOnHierarchyChangeListenerC1707e = new ViewGroupOnHierarchyChangeListenerC1707e(this, null);
        this.f7780j = viewGroupOnHierarchyChangeListenerC1707e;
        TypedArray typedArrayM10770h = C1784o.m10770h(getContext(), attributeSet, R$styleable.ChipGroup, i10, i11, new int[0]);
        int dimensionPixelOffset = typedArrayM10770h.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayM10770h.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayM10770h.getDimensionPixelOffset(R$styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayM10770h.getBoolean(R$styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayM10770h.getBoolean(R$styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayM10770h.getBoolean(R$styleable.ChipGroup_selectionRequired, false));
        this.f7779i = typedArrayM10770h.getResourceId(R$styleable.ChipGroup_checkedChip, -1);
        typedArrayM10770h.recycle();
        c1770a.m10582o(new C1703a());
        super.setOnHierarchyChangeListener(viewGroupOnHierarchyChangeListenerC1707e);
        C9603h0.m59833A0(this, 1);
    }
}
