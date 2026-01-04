package com.huawei.phoneservice.feedback.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.util.FaqTimeStringUtil;
import com.huawei.phoneservice.faq.base.widget.ListItemRelativeLayout;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8509a;
import com.huawei.phoneservice.feedback.widget.ItemView;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.uikit.hwresources.C8732R;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.adapter.a */
/* loaded from: classes5.dex */
public class C8462a extends SimpleBaseAdapter<FeedBackResponse.ProblemEnity> {

    /* renamed from: com.huawei.phoneservice.feedback.adapter.a$a */
    public static class a {

        /* renamed from: a */
        public TextView f39491a;

        /* renamed from: b */
        public TextView f39492b;

        /* renamed from: c */
        public TextView f39493c;

        /* renamed from: d */
        public ImageView f39494d;

        /* renamed from: e */
        public View f39495e;

        /* renamed from: f */
        public ItemView f39496f;

        /* renamed from: g */
        public ListItemRelativeLayout f39497g;

        /* renamed from: h */
        public ImageView f39498h;
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FeedBackResponse.ProblemEnity getItem(int i10) {
        List<T> list = this.arrayList;
        if (list == 0 || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return (FeedBackResponse.ProblemEnity) this.arrayList.get(i10);
    }

    /* renamed from: b */
    public List<FeedBackResponse.ProblemEnity> m52613b() {
        return this.arrayList;
    }

    /* renamed from: c */
    public final void m52614c(ViewGroup viewGroup, a aVar) {
        Context context = viewGroup.getContext();
        if (context != null) {
            FaqTahitiUtils.setMargins(aVar.f39497g, 0, context.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_end));
            View view = aVar.f39495e;
            Resources resources = context.getResources();
            int i10 = C8732R.dimen.emui_dimens_max_start;
            FaqTahitiUtils.setMargins(view, resources.getDimensionPixelOffset(i10), 0);
            FaqTahitiUtils.setWidth(aVar.f39496f, context.getResources().getDimensionPixelOffset(i10));
        }
    }

    /* renamed from: d */
    public void m52615d(int i10) {
        List<T> list = this.arrayList;
        if (list == 0 || i10 < 0 || i10 >= list.size()) {
            return;
        }
        this.arrayList.remove(i10);
    }

    @Override // com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.feedback_sdk_item_feedlist, viewGroup, false);
            aVar.f39491a = (TextView) viewInflate.findViewById(R$id.feed_title);
            aVar.f39492b = (TextView) viewInflate.findViewById(R$id.feed_time);
            aVar.f39493c = (TextView) viewInflate.findViewById(R$id.feed_content);
            aVar.f39494d = (ImageView) viewInflate.findViewById(R$id.iv_question_state);
            aVar.f39495e = viewInflate.findViewById(R$id.feedback_split_line);
            aVar.f39497g = (ListItemRelativeLayout) viewInflate.findViewById(R$id.feed_item_rl);
            aVar.f39496f = (ItemView) viewInflate.findViewById(R$id.item_view);
            aVar.f39498h = (ImageView) viewInflate.findViewById(R$id.feed_list_select);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        FeedBackResponse.ProblemEnity item = getItem(i10);
        if (item != null) {
            aVar.f39491a.setText(item.getProblemDesc());
            if (C8509a.m52862c(item.getCreateTime(), viewInflate.getContext())) {
                aVar.f39492b.setText(C8509a.m52861a(item.getCreateTime(), "HH:mm", viewInflate.getContext()));
            } else {
                aVar.f39492b.setText(FaqTimeStringUtil.formatDateString(C8509a.m52861a(item.getCreateTime(), "yyyy-MM-dd HH:mm", viewInflate.getContext()), viewInflate.getContext()).replace("-", "/"));
            }
            if (TextUtils.isEmpty(item.getAnswer())) {
                aVar.f39493c.setSingleLine(false);
                aVar.f39493c.setText(viewGroup.getContext().getResources().getString(R$string.feedback_sdk_question_state_no));
            } else {
                aVar.f39493c.setText(viewGroup.getContext().getString(R$string.feedback_sdk_question_state_yes, item.getAnswer()));
                aVar.f39493c.setSingleLine(true);
            }
            aVar.f39494d.setVisibility(item.getIsRead() ? 4 : 0);
            aVar.f39498h.setVisibility(item.isSelectMode() ? 0 : 8);
            aVar.f39498h.setImageResource(item.isChecked() ? R$drawable.feedback_sdk_ic_radio_checked : R$drawable.feedback_sdk_ic_radio_unchecked);
        }
        m52614c(viewGroup, aVar);
        aVar.f39495e.setVisibility(i10 == getCount() - 1 ? 4 : 0);
        return viewInflate;
    }
}
