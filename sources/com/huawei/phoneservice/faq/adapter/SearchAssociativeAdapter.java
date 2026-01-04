package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.response.C8351k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class SearchAssociativeAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f38598a;

    /* renamed from: b */
    public List<C8351k> f38599b = new ArrayList();

    /* renamed from: com.huawei.phoneservice.faq.adapter.SearchAssociativeAdapter$b */
    public static class C8286b {

        /* renamed from: a */
        public TextView f38600a;

        public C8286b() {
        }
    }

    public SearchAssociativeAdapter(Context context) {
        this.f38598a = context;
    }

    /* renamed from: a */
    public void m51742a(List<C8351k> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f38599b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38599b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f38599b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C8286b c8286b;
        if (view == null) {
            C8286b c8286b2 = new C8286b();
            View viewInflate = View.inflate(this.f38598a, R$layout.associative_search_item_layout, null);
            c8286b2.f38600a = (TextView) viewInflate.findViewById(R$id.associative_search_txt);
            c8286b2.f38600a.setTextDirection(6);
            viewInflate.setTag(c8286b2);
            c8286b = c8286b2;
            view = viewInflate;
        } else {
            c8286b = (C8286b) view.getTag();
        }
        c8286b.f38600a.setText(this.f38599b.get(i10).m52012a());
        return view;
    }
}
