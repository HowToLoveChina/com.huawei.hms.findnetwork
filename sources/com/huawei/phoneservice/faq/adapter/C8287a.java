package com.huawei.phoneservice.faq.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.response.C8341a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.faq.adapter.a */
/* loaded from: classes4.dex */
public class C8287a extends BaseAdapter {

    /* renamed from: a */
    public List<C8341a.a> f38601a;

    /* renamed from: com.huawei.phoneservice.faq.adapter.a$a */
    public static class a {

        /* renamed from: a */
        public TextView f38602a;

        /* renamed from: b */
        public RadioButton f38603b;

        /* renamed from: c */
        public View f38604c;
    }

    public C8287a(List<C8341a.a> list) {
        this.f38601a = new ArrayList();
        if (list != null) {
            this.f38601a = list;
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C8341a.a getItem(int i10) {
        if (i10 < 0 || i10 >= getCount()) {
            return null;
        }
        return this.f38601a.get(i10);
    }

    /* renamed from: b */
    public List<C8341a.a> m51746b() {
        return this.f38601a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38601a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.faq_sdk_evaluate_list_item, viewGroup, false);
            aVar.f38602a = (TextView) viewInflate.findViewById(R$id.evaluate_list_item_content);
            aVar.f38603b = (RadioButton) viewInflate.findViewById(R$id.evaluate_list_item_radio);
            aVar.f38604c = viewInflate.findViewById(R$id.evaluate_list_item_line);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        aVar.f38602a.setText(getItem(i10).m51988a());
        aVar.f38603b.setChecked(getItem(i10).m51990c());
        aVar.f38604c.setVisibility(i10 == getCount() + (-1) ? 8 : 0);
        return viewInflate;
    }
}
