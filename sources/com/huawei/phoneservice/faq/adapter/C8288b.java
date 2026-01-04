package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.widget.ListItemRelativeLayout;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import com.huawei.phoneservice.faq.response.FaqKnowSearchDetail;
import com.huawei.uikit.hwresources.C8732R;

/* renamed from: com.huawei.phoneservice.faq.adapter.b */
/* loaded from: classes4.dex */
public class C8288b extends SimpleBaseAdapter<FaqKnowSearchDetail> {

    /* renamed from: com.huawei.phoneservice.faq.adapter.b$a */
    public static class a {

        /* renamed from: a */
        public TextView f38605a;

        /* renamed from: b */
        public View f38606b;

        /* renamed from: c */
        public ListItemRelativeLayout f38607c;
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        TextView textView;
        CharSequence charSequenceM51969f;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.faq_sdk_search_item_single_title_layout, viewGroup, false);
            aVar.f38605a = (TextView) SimpleBaseAdapter.findViewById(viewInflate, R$id.tv_search_title);
            aVar.f38606b = SimpleBaseAdapter.findViewById(viewInflate, R$id.service_network_split_line);
            aVar.f38607c = (ListItemRelativeLayout) SimpleBaseAdapter.findViewById(viewInflate, R$id.item_rl);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        FaqKnowSearchDetail faqKnowSearchDetail = (FaqKnowSearchDetail) getItem(i10);
        if (faqKnowSearchDetail != null) {
            if (TextUtils.isEmpty(faqKnowSearchDetail.m51969f())) {
                textView = aVar.f38605a;
                charSequenceM51969f = faqKnowSearchDetail.m51976n();
            } else {
                textView = aVar.f38605a;
                charSequenceM51969f = faqKnowSearchDetail.m51969f();
            }
            textView.setText(charSequenceM51969f);
        }
        if (context != null) {
            FaqTahitiUtils.setMargins(aVar.f38607c, context.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_start), context.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_end));
        }
        aVar.f38606b.setVisibility(i10 == getCount() + (-1) ? 4 : 0);
        return viewInflate;
    }
}
