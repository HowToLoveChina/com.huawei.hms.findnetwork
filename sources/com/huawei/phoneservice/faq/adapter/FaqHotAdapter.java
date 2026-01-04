package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.response.C8342b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqHotAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f38554a;

    /* renamed from: b */
    public List<C8342b.a> f38555b = new ArrayList();

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqHotAdapter$a */
    public static class C8278a {

        /* renamed from: a */
        public TextView f38556a;

        /* renamed from: b */
        public View f38557b;
    }

    public FaqHotAdapter(Context context) {
        this.f38554a = context;
    }

    /* renamed from: a */
    public void m51692a(List<C8342b.a> list, boolean z10) {
        if (list != null) {
            if (z10) {
                this.f38555b.clear();
            }
            for (C8342b.a aVar : list) {
                if ("Y".equals(aVar.m51993a())) {
                    this.f38555b.add(aVar);
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38555b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<C8342b.a> list = this.f38555b;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f38555b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C8278a c8278a;
        if (view == null) {
            view = LayoutInflater.from(this.f38554a).inflate(R$layout.faq_sdk_adapter_hot_issues_item, viewGroup, false);
            c8278a = new C8278a();
            c8278a.f38556a = (TextView) view.findViewById(R$id.hot_tv);
            c8278a.f38557b = view.findViewById(R$id.hot_item_img);
            view.setTag(c8278a);
        } else {
            c8278a = (C8278a) view.getTag();
        }
        c8278a.f38556a.setText(this.f38555b.get(i10).m51995c());
        c8278a.f38557b.setVisibility(i10 == getCount() + (-1) ? 8 : 0);
        return view;
    }
}
