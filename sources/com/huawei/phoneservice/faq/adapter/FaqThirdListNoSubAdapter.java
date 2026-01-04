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
import com.huawei.phoneservice.faq.response.FaqClassification;
import com.huawei.uikit.hwresources.C8732R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class FaqThirdListNoSubAdapter extends BaseAdapter {

    /* renamed from: a */
    public List<FaqClassification.Classification> f38593a = new ArrayList();

    /* renamed from: b */
    public Context f38594b;

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqThirdListNoSubAdapter$a */
    public static class C8284a {

        /* renamed from: a */
        public TextView f38595a;

        /* renamed from: b */
        public View f38596b;

        /* renamed from: c */
        public ListItemRelativeLayout f38597c;
    }

    public FaqThirdListNoSubAdapter(Context context) {
        this.f38594b = context;
    }

    /* renamed from: a */
    public void m51741a(List<FaqClassification.Classification> list) {
        this.f38593a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38593a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<FaqClassification.Classification> list = this.f38593a;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f38593a.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        C8284a c8284a;
        if (view == null) {
            c8284a = new C8284a();
            viewInflate = LayoutInflater.from(this.f38594b).inflate(R$layout.faq_sdk_adapter_faq_secondary_list_item, viewGroup, false);
            c8284a.f38595a = (TextView) viewInflate.findViewById(R$id.tv_name);
            c8284a.f38596b = viewInflate.findViewById(R$id.divider_view);
            c8284a.f38597c = (ListItemRelativeLayout) viewInflate.findViewById(R$id.item_rl);
            viewInflate.setTag(c8284a);
        } else {
            viewInflate = view;
            c8284a = (C8284a) view.getTag();
        }
        FaqTahitiUtils.setMargins(c8284a.f38597c, this.f38594b.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_start), this.f38594b.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_end));
        c8284a.f38596b.setVisibility(i10 == getCount() + (-1) ? 8 : 0);
        c8284a.f38595a.setText(this.f38593a.get(i10).m51922e());
        return viewInflate;
    }
}
