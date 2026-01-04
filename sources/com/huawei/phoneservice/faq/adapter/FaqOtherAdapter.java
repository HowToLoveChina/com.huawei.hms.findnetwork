package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.widget.ListItemRelativeLayout;
import com.huawei.phoneservice.faq.response.C8342b;
import com.huawei.uikit.hwresources.C8732R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqOtherAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<C8342b.a> f38558a = new ArrayList();

    /* renamed from: b */
    public Context f38559b;

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqOtherAdapter$a */
    public static class C8279a {

        /* renamed from: a */
        public TextView f38560a;

        /* renamed from: b */
        public View f38561b;

        /* renamed from: c */
        public ListItemRelativeLayout f38562c;
    }

    public FaqOtherAdapter(Context context) {
        this.f38559b = context;
    }

    /* renamed from: a */
    public void m51693a(List<C8342b.a> list) {
        if (list != null) {
            for (C8342b.a aVar : list) {
                if ("N".equals(aVar.m51993a())) {
                    this.f38558a.add(aVar);
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38558a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<C8342b.a> list = this.f38558a;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f38558a.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C8279a c8279a;
        if (view == null) {
            view = LayoutInflater.from(this.f38559b).inflate(R$layout.faq_sdk_adapter_hot_issues_item, (ViewGroup) null, false);
            c8279a = new C8279a();
            c8279a.f38560a = (TextView) view.findViewById(R$id.hot_tv);
            c8279a.f38561b = view.findViewById(R$id.hot_item_img);
            c8279a.f38562c = (ListItemRelativeLayout) view.findViewById(R$id.item_rl);
            view.setTag(c8279a);
        } else {
            c8279a = (C8279a) view.getTag();
        }
        FaqTahitiUtils.setMargins(c8279a.f38562c, this.f38559b.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_start), this.f38559b.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_end));
        c8279a.f38561b.setVisibility(i10 == getCount() + (-1) ? 8 : 0);
        c8279a.f38560a.setText(this.f38558a.get(i10).m51995c());
        return view;
    }
}
