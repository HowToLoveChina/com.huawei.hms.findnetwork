package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.huawei.phoneservice.faq.R$styleable;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import p438l.C11214h;

/* loaded from: classes4.dex */
public class FaqListGridView extends FaqFootOverScrollListView {

    /* renamed from: i */
    public C8434a f39301i;

    /* renamed from: com.huawei.phoneservice.faq.widget.FaqListGridView$a */
    public class ViewOnClickListenerC8426a implements View.OnClickListener {
        public ViewOnClickListenerC8426a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            int iIntValue = ((Integer) view.getTag()).intValue();
            if (FaqListGridView.this.getOnItemClickListener() != null) {
                FaqListGridView.this.getOnItemClickListener().onItemClick(FaqListGridView.this, view, iIntValue, iIntValue);
            }
        }
    }

    public FaqListGridView(Context context) {
        super(context);
        m52452b(context, null);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        C11214h<View> c11214h = this.f39301i.f39374c;
        c11214h.m67344l(c11214h.m67346n(), view);
        DataSetObserver dataSetObserver = this.f39301i.f39372a;
        if (dataSetObserver != null) {
            dataSetObserver.onChanged();
        }
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        C11214h<View> c11214h = this.f39301i.f39373b;
        c11214h.m67344l(c11214h.m67346n(), view);
        DataSetObserver dataSetObserver = this.f39301i.f39372a;
        if (dataSetObserver != null) {
            dataSetObserver.onChanged();
        }
    }

    /* renamed from: b */
    public final void m52452b(Context context, AttributeSet attributeSet) {
        this.f39301i = new C8434a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FaqListGridView);
            this.f39301i.f39377f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.FaqListGridView_faqsdkhorizontalSpacing, 0);
            this.f39301i.f39378g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.FaqListGridView_faqsdkverticalSpacing, 0);
            this.f39301i.f39376e = typedArrayObtainStyledAttributes.getInt(R$styleable.FaqListGridView_faqsdknumColumns, 1);
            this.f39301i.f39380i = getPaddingStart();
            this.f39301i.f39381j = getPaddingEnd();
            C8434a c8434a = this.f39301i;
            c8434a.f39375d = typedArrayObtainStyledAttributes.getInt(R$styleable.FaqListGridView_faqsdkmaxNumColumns, c8434a.f39376e);
            C8434a c8434a2 = this.f39301i;
            c8434a2.f39384m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqListGridView_faqsdkhideBottomDivider, c8434a2.f39384m);
            C8434a c8434a3 = this.f39301i;
            c8434a3.f39383l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqListGridView_faqsdkhideTopDivider, c8434a3.f39383l);
            C8434a c8434a4 = this.f39301i;
            c8434a4.f39385n = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqListGridView_faqsdkhideExtraDivider, c8434a4.f39385n);
            C8434a c8434a5 = this.f39301i;
            c8434a5.f39382k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FaqListGridView_faqsdkpaddingClipDivider, c8434a5.f39382k);
            C8434a c8434a6 = this.f39301i;
            c8434a6.f39379h = typedArrayObtainStyledAttributes.getColor(R$styleable.FaqListGridView_faqsdkdividerColor, c8434a6.f39379h);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f39301i.f39382k) {
            return;
        }
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        C8434a c8434a = this.f39301i;
        return c8434a.f39382k ? super.getPaddingEnd() : c8434a.f39381j;
    }

    @Override // android.view.View
    public int getPaddingStart() {
        C8434a c8434a = this.f39301i;
        return c8434a.f39382k ? super.getPaddingStart() : c8434a.f39380i;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        for (int i10 = 0; i10 < this.f39301i.f39374c.m67346n(); i10++) {
            if (this.f39301i.f39374c.m67347o(i10) == view) {
                this.f39301i.f39374c.m67345m(i10);
                DataSetObserver dataSetObserver = this.f39301i.f39372a;
                if (dataSetObserver == null) {
                    return true;
                }
                dataSetObserver.onChanged();
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        for (int i10 = 0; i10 < this.f39301i.f39373b.m67346n(); i10++) {
            if (this.f39301i.f39373b.m67347o(i10) == view) {
                this.f39301i.f39373b.m67345m(i10);
                DataSetObserver dataSetObserver = this.f39301i.f39372a;
                if (dataSetObserver == null) {
                    return true;
                }
                dataSetObserver.onChanged();
                return true;
            }
        }
        return false;
    }

    public void setAdapter(SimpleBaseAdapter simpleBaseAdapter) throws Throwable {
        this.f39301i.m52490i(simpleBaseAdapter);
        super.setAdapter((ListAdapter) this.f39301i);
    }

    public void setNumColumns(int i10) {
        this.f39301i.m52495n(i10);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
        this.f39301i.setOnClickListener(new ViewOnClickListenerC8426a());
    }

    public FaqListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m52452b(context, attributeSet);
    }
}
