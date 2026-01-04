package com.huawei.android.p069cg.p071ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import java.util.ArrayList;
import java.util.List;
import sk.C12809f;

/* loaded from: classes2.dex */
public class FilterConditionAdapter extends RecyclerView.AbstractC0838h {

    /* renamed from: d */
    public LayoutInflater f11172d;

    /* renamed from: f */
    public InterfaceC2338c f11174f;

    /* renamed from: i */
    public Context f11177i;

    /* renamed from: e */
    public List<String> f11173e = new ArrayList();

    /* renamed from: g */
    public int f11175g = -1;

    /* renamed from: h */
    public int f11176h = -1;

    /* renamed from: com.huawei.android.cg.ui.FilterConditionAdapter$a */
    public class ViewOnClickListenerC2336a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f11178a;

        public ViewOnClickListenerC2336a(int i10) {
            this.f11178a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FilterConditionAdapter.this.f11174f.mo14707a(this.f11178a, (String) FilterConditionAdapter.this.f11173e.get(this.f11178a));
        }
    }

    /* renamed from: com.huawei.android.cg.ui.FilterConditionAdapter$b */
    public static class C2337b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f11180u;

        /* renamed from: v */
        public TextView f11181v;

        /* renamed from: w */
        public View f11182w;

        /* renamed from: x */
        public LinearLayout f11183x;

        public C2337b(View view) {
            super(view);
            this.f11183x = (LinearLayout) C12809f.m76831d(view, R$id.llay_container);
            this.f11182w = C12809f.m76831d(view, R$id.view_indicate);
            this.f11180u = (TextView) C12809f.m76831d(view, R$id.tv_content);
            this.f11181v = (TextView) C12809f.m76831d(view, R$id.tv_content_medium);
        }
    }

    /* renamed from: com.huawei.android.cg.ui.FilterConditionAdapter$c */
    public interface InterfaceC2338c {
        /* renamed from: a */
        void mo14707a(int i10, String str);
    }

    public FilterConditionAdapter(Context context) {
        this.f11172d = LayoutInflater.from(context);
        this.f11177i = context;
    }

    /* renamed from: F */
    public void m14703F(List<String> list) {
        this.f11173e = list;
    }

    /* renamed from: G */
    public void m14704G(InterfaceC2338c interfaceC2338c) {
        this.f11174f = interfaceC2338c;
    }

    /* renamed from: H */
    public void m14705H(int i10, int i11) {
        this.f11175g = i10;
        this.f11176h = i11;
    }

    /* renamed from: I */
    public final void m14706I(int i10, C2337b c2337b) {
        c2337b.f11182w.setVisibility(i10 == this.f11175g ? 0 : 4);
        c2337b.f11180u.setVisibility(i10 == this.f11175g ? 8 : 0);
        c2337b.f11181v.setVisibility(i10 != this.f11175g ? 8 : 0);
        int i11 = this.f11176h;
        if (i11 == 0) {
            c2337b.f11183x.setBackgroundColor(this.f11177i.getColor(i10 == this.f11175g ? R$color.color_mid_filter_bg : R$color.color_filter_gap));
        } else if (i11 == 1) {
            c2337b.f11183x.setBackgroundColor(this.f11177i.getColor(i10 == this.f11175g ? R$color.color_last_filter_bg : R$color.color_mid_filter_bg));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f11173e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) {
        C2337b c2337b = (C2337b) abstractC0833c0;
        c2337b.f11180u.setText(this.f11173e.get(i10));
        c2337b.f11181v.setText(this.f11173e.get(i10));
        m14706I(i10, c2337b);
        c2337b.f11183x.setOnClickListener(new ViewOnClickListenerC2336a(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new C2337b(this.f11172d.inflate(R$layout.item_filter_condition, viewGroup, false));
    }
}
