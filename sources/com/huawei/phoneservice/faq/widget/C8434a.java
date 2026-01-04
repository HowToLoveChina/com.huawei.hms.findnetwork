package com.huawei.phoneservice.faq.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import java.util.List;
import p438l.C11214h;

/* renamed from: com.huawei.phoneservice.faq.widget.a */
/* loaded from: classes4.dex */
public class C8434a extends SimpleBaseAdapter {

    /* renamed from: a */
    public DataSetObserver f39372a;

    /* renamed from: b */
    public C11214h<View> f39373b = new C11214h<>();

    /* renamed from: c */
    public C11214h<View> f39374c = new C11214h<>();

    /* renamed from: d */
    public int f39375d = 1;

    /* renamed from: e */
    public int f39376e = 1;

    /* renamed from: f */
    public int f39377f = 0;

    /* renamed from: g */
    public int f39378g = 0;

    /* renamed from: h */
    public int f39379h = 0;

    /* renamed from: i */
    public int f39380i = 0;

    /* renamed from: j */
    public int f39381j = 0;

    /* renamed from: k */
    public boolean f39382k = true;

    /* renamed from: l */
    public boolean f39383l = true;

    /* renamed from: m */
    public boolean f39384m = true;

    /* renamed from: n */
    public boolean f39385n = false;

    /* renamed from: o */
    public SimpleBaseAdapter f39386o;

    /* renamed from: a */
    public final int m52482a(int i10) {
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        int count = simpleBaseAdapter == null ? 0 : simpleBaseAdapter.getCount();
        int iM67346n = i10 - this.f39373b.m67346n();
        int i11 = this.f39376e;
        return Math.min(count - (iM67346n * i11), i11);
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter
    public void add(int i10, Object obj) {
        super.add(i10, obj);
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.add(i10, obj);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter
    public void appendToList(int i10, List list) {
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.appendToList(i10, list);
        }
    }

    /* renamed from: b */
    public final View m52483b(int i10, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(0);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(viewGroup.getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams);
        m52489h(linearLayout2, this.f39377f, this.f39379h, "DIVIDER_TAG");
        linearLayout2.addView(linearLayout);
        linearLayout2.setTag(linearLayout);
        m52489h(linearLayout2, this.f39377f, this.f39379h, "DIVIDER_TAG");
        m52492k(linearLayout, this.f39382k ? 0 : this.f39380i, 0, "PADDING_DIVIDER_TAG");
        if (this.f39386o != null) {
            for (int i11 = 0; i11 < this.f39375d; i11++) {
                int iM67346n = ((i10 - this.f39373b.m67346n()) * this.f39376e) + i11;
                if (iM67346n >= this.f39386o.getCount()) {
                    iM67346n = this.f39386o.getCount() - 1;
                }
                View view = this.f39386o.getView(iM67346n, null, linearLayout);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                if (i11 != 0) {
                    m52492k(linearLayout, this.f39377f, this.f39379h, "DIVIDER_TAG");
                }
                linearLayout.addView(view, layoutParams2);
            }
        }
        m52492k(linearLayout, this.f39382k ? 0 : this.f39381j, 0, "PADDING_DIVIDER_TAG");
        return linearLayout2;
    }

    /* renamed from: c */
    public final void m52484c(int i10, int i11, View view, int i12, int i13, Object obj) {
        m52488g(view, i12, -1, i13, obj);
        view.setVisibility((i10 >= i11 && (this.f39385n || i10 >= this.f39376e)) ? 8 : 0);
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter
    public void cleanAll() {
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.cleanAll();
        }
    }

    /* renamed from: d */
    public final void m52485d(int i10, View view) {
        int i11;
        int i12;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int iM52482a = m52482a(i10);
            int i13 = 0;
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = viewGroup.getChildAt(i14);
                if ((childAt.getTag() == null || !"DIVIDER_TAG".equals(childAt.getTag())) && !"PADDING_DIVIDER_TAG".equals(childAt.getTag())) {
                    int iM67346n = (((i10 - this.f39373b.m67346n()) * this.f39376e) + i14) - i13;
                    SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
                    if (simpleBaseAdapter != null && iM67346n >= simpleBaseAdapter.getCount()) {
                        iM67346n = this.f39386o.getCount() - 1;
                    }
                    m52486e(i10, viewGroup, iM52482a, i13, i14, childAt, iM67346n);
                } else {
                    if ("PADDING_DIVIDER_TAG".equals(childAt.getTag())) {
                        boolean z10 = this.f39382k;
                        if (i14 == 0) {
                            if (!z10) {
                                i11 = this.f39380i;
                                i12 = i11;
                            }
                            i12 = 0;
                        } else {
                            if (!z10) {
                                i11 = this.f39381j;
                                i12 = i11;
                            }
                            i12 = 0;
                        }
                        m52488g(childAt, i12, -1, 0, "PADDING_DIVIDER_TAG");
                    } else {
                        m52484c(i14 - i13, iM52482a, childAt, this.f39377f, this.f39379h, "DIVIDER_TAG");
                    }
                    i13++;
                }
            }
        }
    }

    /* renamed from: e */
    public final void m52486e(int i10, ViewGroup viewGroup, int i11, int i12, int i13, View view, int i14) {
        int i15 = i13 - i12;
        if (i15 >= i11) {
            view.setVisibility(i15 < this.f39376e ? 4 : 8);
            return;
        }
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.getView(i14, view, viewGroup);
        }
        view.setOnClickListener(this.listener);
        view.setVisibility(0);
        if (view.getTag() == null) {
            view.setTag(Integer.valueOf(i10));
        }
    }

    /* renamed from: f */
    public final void m52487f(int i10, ViewGroup viewGroup, int i11, int i12, Object obj) {
        View childAt = viewGroup.getChildAt(0);
        m52488g(childAt, -1, i11, i12, obj);
        if (i10 != 0 || this.f39383l) {
            childAt.setVisibility(8);
        } else {
            childAt.setVisibility(0);
        }
        View childAt2 = viewGroup.getChildAt(2);
        m52488g(childAt2, -1, i11, i12, obj);
        if (this.f39384m && i10 == (getCount() - this.f39374c.m67346n()) - 1) {
            childAt2.setVisibility(8);
        } else {
            childAt2.setVisibility(0);
        }
    }

    /* renamed from: g */
    public final void m52488g(View view, int i10, int i11, int i12, Object obj) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams.width != i10 || layoutParams.height != i11)) {
            layoutParams.width = i10;
            layoutParams.height = i11;
            view.setLayoutParams(layoutParams);
        }
        view.setBackgroundColor(i12);
        view.setTag(obj);
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public int getCount() {
        if (this.f39376e == 0) {
            return 0;
        }
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        int count = simpleBaseAdapter == null ? 0 : simpleBaseAdapter.getCount();
        int i10 = this.f39376e;
        return (count / i10) + (count % i10 != 0 ? 1 : 0) + this.f39373b.m67346n() + this.f39374c.m67346n();
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public Object getItem(int i10) {
        return super.getItem(i10);
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public long getItemId(int i10) {
        return super.getItemId(i10);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return m52494m(i10) ? i10 : m52493l(i10) ? (i10 - (getCount() - this.f39374c.m67346n())) + 1 + this.f39373b.m67346n() : this.f39373b.m67346n();
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM67340g;
        int itemViewType = getItemViewType(i10);
        if (m52494m(i10)) {
            if (view != null) {
                return view;
            }
            viewM67340g = this.f39373b.m67340g(itemViewType);
        } else {
            if (!m52493l(i10)) {
                if (view == null) {
                    view = m52483b(i10, viewGroup);
                }
                m52491j(i10, view);
                return view;
            }
            if (view != null) {
                return view;
            }
            viewM67340g = this.f39374c.m67340g((itemViewType - this.f39373b.m67346n()) - 1);
        }
        return viewM67340g;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return (this.f39386o == null ? 0 : 1) + this.f39373b.m67346n() + this.f39374c.m67346n();
    }

    /* renamed from: h */
    public final void m52489h(ViewGroup viewGroup, int i10, int i11, Object obj) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i10);
        View view = new View(viewGroup.getContext());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i11);
        view.setTag(obj);
        viewGroup.addView(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m52490i(com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.String r0 = "ListGirdAdapter"
            com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter r1 = r3.f39386o     // Catch: java.lang.Exception -> Le java.lang.IllegalStateException -> L14
            if (r1 == 0) goto L17
            android.database.DataSetObserver r2 = r3.f39372a     // Catch: java.lang.Exception -> Le java.lang.IllegalStateException -> L14
            if (r2 == 0) goto L17
            r1.unregisterDataSetObserver(r2)     // Catch: java.lang.Exception -> Le java.lang.IllegalStateException -> L14
            goto L17
        Le:
            java.lang.String r1 = "setAdapter unregisterDataSetObserver "
        L10:
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r0, r1)
            goto L17
        L14:
            java.lang.String r1 = "setAdapter unregisterDataSetObserver IllegalState"
            goto L10
        L17:
            r3.f39386o = r4
            if (r4 == 0) goto L2a
            android.view.View$OnClickListener r4 = r4.getOnClickListener()
            if (r4 == 0) goto L2a
            com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter r4 = r3.f39386o
            android.view.View$OnClickListener r4 = r4.getOnClickListener()
            r3.setOnClickListener(r4)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.faq.widget.C8434a.m52490i(com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter):void");
    }

    /* renamed from: j */
    public final void m52491j(int i10, View view) {
        if (view.getTag() != null && (view.getTag() instanceof LinearLayout)) {
            m52487f(i10, (ViewGroup) view, this.f39378g, this.f39379h, "DIVIDER_TAG");
            view = (ViewGroup) view.getTag();
        }
        m52485d(i10, view);
    }

    /* renamed from: k */
    public final void m52492k(ViewGroup viewGroup, int i10, int i11, Object obj) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, -1);
        View view = new View(viewGroup.getContext());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i11);
        view.setTag(obj);
        viewGroup.addView(view);
    }

    /* renamed from: l */
    public final boolean m52493l(int i10) {
        return i10 >= getCount() - this.f39374c.m67346n() && i10 < getCount();
    }

    /* renamed from: m */
    public final boolean m52494m(int i10) {
        return i10 < this.f39373b.m67346n();
    }

    /* renamed from: n */
    public void m52495n(int i10) {
        this.f39376e = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) throws Throwable {
        String str;
        this.f39372a = dataSetObserver;
        try {
            SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
            if (simpleBaseAdapter != null) {
                simpleBaseAdapter.registerDataSetObserver(dataSetObserver);
            }
        } catch (IllegalStateException unused) {
            str = "unregisterDataSetObserver IllegalState";
            FaqLogger.m51840e("ListGirdAdapter", str);
        } catch (Exception unused2) {
            str = "unregisterDataSetObserver ";
            FaqLogger.m51840e("ListGirdAdapter", str);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter
    public void setResource(List list) {
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.setResource(list);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) throws Throwable {
        String str;
        this.f39372a = null;
        try {
            SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
            if (simpleBaseAdapter != null) {
                simpleBaseAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        } catch (IllegalStateException unused) {
            str = "unregisterDataSetObserver IllegalState";
            FaqLogger.m51840e("ListGirdAdapter", str);
        } catch (Exception unused2) {
            str = "unregisterDataSetObserver ";
            FaqLogger.m51840e("ListGirdAdapter", str);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter
    public void add(Object obj) {
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.add(obj);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter
    public void appendToList(List list) {
        SimpleBaseAdapter simpleBaseAdapter = this.f39386o;
        if (simpleBaseAdapter != null) {
            simpleBaseAdapter.appendToList(list);
        }
    }
}
