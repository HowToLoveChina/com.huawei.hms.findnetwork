package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.phoneservice.faq.R$styleable;
import com.huawei.uikit.hwresources.C8732R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class FaqAutoConfigLinearLayout extends LinearLayout {

    /* renamed from: a */
    public SparseIntArray f39237a;

    /* renamed from: b */
    public Map<View, Integer> f39238b;

    /* renamed from: c */
    public Map<View, Integer> f39239c;

    /* renamed from: d */
    public SparseArray<View> f39240d;

    /* renamed from: e */
    public int f39241e;

    /* renamed from: f */
    public int f39242f;

    /* renamed from: g */
    public List<View> f39243g;

    /* renamed from: h */
    public List<View> f39244h;

    /* renamed from: i */
    public EnumC8418a f39245i;

    /* renamed from: j */
    public int f39246j;

    /* renamed from: k */
    public Map<View, Integer> f39247k;

    /* renamed from: l */
    public Map<View, Integer> f39248l;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqAutoConfigLinearLayout$a */
    public enum EnumC8418a {
        horizontal,
        vertical
    }

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqAutoConfigLinearLayout$b */
    public class C8419b extends LinearLayout.LayoutParams {

        /* renamed from: a */
        public boolean f39252a;

        public C8419b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FaqAutoConfigLinearLayout);
            this.f39252a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqAutoConfigLinearLayout_faqsdkgroup, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FaqAutoConfigLinearLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final int m52399a(int i10) {
        if (this.f39238b.size() <= 0) {
            i10 = 0;
        }
        View view = null;
        boolean z10 = true;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + i12;
            if (i13 >= this.f39241e) {
                break;
            }
            view = this.f39240d.get(i13);
            while (this.f39238b.containsKey(view)) {
                int i14 = i12 + 1;
                if (i12 == 0) {
                    z10 = !z10;
                }
                i12 = i14;
                view = this.f39240d.get(i11 + i14);
            }
            if ((z10 && this.f39245i == EnumC8418a.horizontal) || this.f39245i == EnumC8418a.vertical) {
                int i15 = i11 + i12;
                i10 += this.f39237a.get(i15);
                this.f39239c.put(view, Integer.valueOf(i15));
            }
            z10 = !z10;
            if (i10 >= this.f39242f * 0.5d) {
                break;
            }
            i11++;
        }
        if (view != null && this.f39239c.size() > 1 && this.f39239c.size() + this.f39238b.size() >= this.f39241e) {
            this.f39239c.remove(view);
        }
        this.f39243g.clear();
        this.f39244h.clear();
        SparseArray<View> sparseArray = this.f39240d;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return i10;
        }
        for (int i16 = 0; i16 < this.f39241e; i16++) {
            View view2 = this.f39240d.get(i16);
            ((this.f39238b.containsKey(view2) || this.f39239c.containsKey(view2)) ? this.f39243g : this.f39244h).add(view2);
        }
        m52401c();
        return Math.max(m52400b(this.f39243g), m52400b(this.f39244h));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if ((layoutParams instanceof C8419b) && ((C8419b) layoutParams).f39252a) {
            this.f39238b.put(view, 0);
        }
    }

    /* renamed from: b */
    public final int m52400b(List<View> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f39240d.size(); i11++) {
            if (list.contains(this.f39240d.get(i11))) {
                i10 += this.f39237a.get(i11);
            }
        }
        return i10;
    }

    /* renamed from: c */
    public final void m52401c() {
        int iM52400b = m52400b(this.f39243g);
        int iM52400b2 = m52400b(this.f39244h);
        while (iM52400b < iM52400b2 && this.f39244h.size() > 1) {
            List<View> list = this.f39244h;
            View view = list.get(list.size() - 1);
            iM52400b += view.getMeasuredHeight();
            iM52400b2 -= view.getMeasuredHeight();
            this.f39243g.add(view);
            this.f39244h.remove(view);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    /* renamed from: d */
    public final void m52402d(View view, int i10, int i11) {
        if (view instanceof FaqInScrollListView) {
            FaqInScrollListView faqInScrollListView = (FaqInScrollListView) view;
            faqInScrollListView.setInsetPaddingStart(i10);
            faqInScrollListView.setInsetPaddingEnd(i11);
            return;
        }
        if (!this.f39247k.containsKey(view)) {
            this.f39247k.put(view, Integer.valueOf(view.getPaddingStart()));
            this.f39248l.put(view, Integer.valueOf(view.getPaddingEnd()));
        }
        int iIntValue = i10 + this.f39247k.get(view).intValue();
        int iIntValue2 = i11 + this.f39248l.get(view).intValue();
        boolean z10 = getLayoutDirection() == 1;
        int i12 = z10 ? iIntValue2 : iIntValue;
        int paddingTop = view.getPaddingTop();
        if (!z10) {
            iIntValue = iIntValue2;
        }
        view.setPadding(i12, paddingTop, iIntValue, view.getPaddingBottom());
    }

    /* renamed from: e */
    public final void m52403e(ViewGroup viewGroup) {
        if (2 == getResources().getConfiguration().orientation) {
            int i10 = this.f39246j / 2;
            Iterator<View> it = this.f39243g.iterator();
            while (it.hasNext()) {
                m52402d(it.next(), this.f39246j, i10);
            }
            Iterator<View> it2 = this.f39244h.iterator();
            while (it2.hasNext()) {
                m52402d(it2.next(), (int) (i10 + 0.5d), this.f39246j);
            }
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int i12 = this.f39246j;
            m52402d(childAt, i12, i12);
        }
    }

    /* renamed from: f */
    public final void m52404f(List<View> list, int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int i17;
        if (list == null || list.size() == 0) {
            return;
        }
        int paddingTop = getPaddingTop();
        int i18 = i12 - i10;
        int i19 = i18 - i15;
        int i20 = (i18 - i14) - i15;
        int size = list.size();
        int gravity = getGravity() & 8388615;
        for (int i21 = 0; i21 < size; i21++) {
            View view = list.get(i21);
            if (view != null && view.getVisibility() != 8) {
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                int i22 = layoutParams.gravity;
                if (i22 < 0) {
                    i22 = gravity;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i22, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i16 = ((i20 - measuredWidth) / 2) + i14 + layoutParams.leftMargin;
                } else if (absoluteGravity != 8388613) {
                    i17 = layoutParams.leftMargin + i14;
                    int i23 = paddingTop + layoutParams.topMargin;
                    view.layout(i17, i23, measuredWidth + i17, i23 + measuredHeight);
                    paddingTop = i23 + measuredHeight + layoutParams.bottomMargin;
                } else {
                    i16 = i19 - measuredWidth;
                }
                i17 = i16 - layoutParams.rightMargin;
                int i232 = paddingTop + layoutParams.topMargin;
                view.layout(i17, i232, measuredWidth + i17, i232 + measuredHeight);
                paddingTop = i232 + measuredHeight + layoutParams.bottomMargin;
            }
        }
    }

    /* renamed from: g */
    public final int m52405g() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f39240d.size(); i11++) {
            View view = this.f39240d.get(i11);
            if (this.f39238b.containsKey(view)) {
                i10 += this.f39237a.get(i11);
                this.f39238b.put(view, Integer.valueOf(i11));
            }
        }
        return i10;
    }

    /* renamed from: h */
    public final EnumC8418a m52406h(int i10) {
        return i10 == 0 ? EnumC8418a.horizontal : EnumC8418a.vertical;
    }

    /* renamed from: i */
    public final int m52407i(int i10) {
        return 2 == getResources().getConfiguration().orientation ? m52399a(i10) : this.f39242f;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Configuration configuration = getResources().getConfiguration();
        m52403e(this);
        if (2 != configuration.orientation) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int i14 = (int) ((i12 - i10) * 0.5d);
        boolean z11 = getLayoutDirection() == 1;
        m52404f(z11 ? this.f39244h : this.f39243g, i10, i11, i14, i13, getPaddingLeft(), 0);
        m52404f(z11 ? this.f39243g : this.f39244h, i14, i11, i12, i13, i14, getPaddingRight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        this.f39241e = 0;
        this.f39242f = 0;
        this.f39237a.clear();
        this.f39240d.clear();
        this.f39239c.clear();
        Configuration configuration = getResources().getConfiguration();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = 2 == configuration.orientation ? View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * 0.5d), View.MeasureSpec.getMode(i10)) : i10;
        super.onMeasure(iMakeMeasureSpec2, iMakeMeasureSpec);
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0) {
                    this.f39242f += childAt.getMeasuredHeight();
                    this.f39240d.put(this.f39241e, childAt);
                    this.f39237a.put(this.f39241e, childAt.getMeasuredHeight());
                    this.f39241e++;
                }
            }
        }
        if (this.f39242f > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(m52407i(m52405g()) + getPaddingBottom() + getPaddingTop(), 1073741824);
            m52403e(this);
            super.onMeasure(iMakeMeasureSpec2, iMakeMeasureSpec);
        }
        setMeasuredDimension(i10, i11);
    }

    public FaqAutoConfigLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39237a = new SparseIntArray();
        this.f39238b = new HashMap();
        this.f39239c = new HashMap();
        this.f39240d = new SparseArray<>();
        this.f39243g = new ArrayList();
        this.f39244h = new ArrayList();
        this.f39247k = new HashMap();
        this.f39248l = new HashMap();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FaqAutoConfigLinearLayout);
        this.f39245i = m52406h(typedArrayObtainStyledAttributes.getInt(R$styleable.FaqAutoConfigLinearLayout_faqsdkfaqLayoutDirection, 1));
        this.f39246j = typedArrayObtainStyledAttributes.getInt(R$styleable.FaqAutoConfigLinearLayout_faqsdkinsetPadding, getResources().getDimensionPixelSize(C8732R.dimen.emui_dimens_max_start));
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(1);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        if ((layoutParams instanceof C8419b) && ((C8419b) layoutParams).f39252a) {
            this.f39238b.put(view, 0);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C8419b(getContext(), attributeSet);
    }
}
