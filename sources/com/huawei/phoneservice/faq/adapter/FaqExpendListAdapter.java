package com.huawei.phoneservice.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.base.util.FaqTahitiUtils;
import com.huawei.phoneservice.faq.base.widget.ListItemRelativeLayout;
import com.huawei.phoneservice.faq.response.C8342b;
import com.huawei.phoneservice.faq.response.FaqClassification;
import com.huawei.phoneservice.faq.widget.FaqNoticeView;
import com.huawei.uikit.hwresources.C8732R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class FaqExpendListAdapter extends BaseExpandableListAdapter {

    /* renamed from: a */
    public List<FaqClassification.Classification> f38544a = new ArrayList();

    /* renamed from: b */
    public Map<String, List<C8342b.a>> f38545b = new LinkedHashMap();

    /* renamed from: c */
    public Context f38546c;

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqExpendListAdapter$a */
    public static class C8275a {

        /* renamed from: a */
        public TextView f38547a;

        /* renamed from: b */
        public View f38548b;

        /* renamed from: c */
        public ListItemRelativeLayout f38549c;
    }

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqExpendListAdapter$b */
    public static class C8276b {

        /* renamed from: a */
        public FaqNoticeView f38550a;

        /* renamed from: b */
        public LinearLayout f38551b;
    }

    /* renamed from: com.huawei.phoneservice.faq.adapter.FaqExpendListAdapter$c */
    public static class C8277c {

        /* renamed from: a */
        public TextView f38552a;

        /* renamed from: b */
        public View f38553b;
    }

    public FaqExpendListAdapter(Context context) {
        this.f38546c = context;
    }

    /* renamed from: a */
    public void m51690a(List<FaqClassification.Classification> list) {
        this.f38544a = list;
    }

    /* renamed from: b */
    public void m51691b(Map<String, List<C8342b.a>> map) {
        this.f38545b = map;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i10, int i11) {
        FaqClassification.Classification classification = (FaqClassification.Classification) getGroup(i10);
        if (classification == null || this.f38545b == null) {
            return null;
        }
        List<C8342b.a> list = this.f38545b.get(classification.m51921d());
        if (list == null || list.size() <= i11 || i11 < 0) {
            return null;
        }
        return list.get(i11);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i10, int i11) {
        return i11;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i10, int i11) {
        FaqClassification.Classification classification = (FaqClassification.Classification) getGroup(i10);
        if (classification != null && this.f38545b != null) {
            List<C8342b.a> list = this.f38545b.get(classification.m51921d());
            if (list != null) {
                return (list.size() == 0 && getChildrenCount(i10) == 1) ? 1 : 0;
            }
        }
        return 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i10, int i11, boolean z10, View view, ViewGroup viewGroup) {
        C8275a c8275a;
        int childType = getChildType(i10, i11);
        if (childType != 0) {
            if (childType != 1) {
                return null;
            }
            C8276b c8276b = new C8276b();
            View viewInflate = LayoutInflater.from(this.f38546c).inflate(R$layout.faq_sdk_third_notice_item, (ViewGroup) null);
            c8276b.f38550a = (FaqNoticeView) viewInflate.findViewById(R$id.faq_third_noticeView);
            c8276b.f38551b = (LinearLayout) viewInflate.findViewById(R$id.faq_item_error);
            viewInflate.setTag(c8276b);
            if (this.f38544a.get(i10).m51924g()) {
                c8276b.f38550a.setVisibility(8);
                c8276b.f38551b.setVisibility(0);
            }
            return viewInflate;
        }
        if (view == null) {
            c8275a = new C8275a();
            view = LayoutInflater.from(this.f38546c).inflate(R$layout.faq_sdk_adapter_child_item, viewGroup, false);
            c8275a.f38547a = (TextView) view.findViewById(R$id.tv_name);
            c8275a.f38548b = view.findViewById(R$id.divider_view);
            c8275a.f38549c = (ListItemRelativeLayout) view.findViewById(R$id.item_rl);
            view.setTag(c8275a);
        } else {
            c8275a = (C8275a) view.getTag();
        }
        FaqTahitiUtils.setMargins(c8275a.f38549c, this.f38546c.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_start), this.f38546c.getResources().getDimensionPixelOffset(C8732R.dimen.emui_dimens_max_end));
        c8275a.f38548b.setVisibility((i10 == getGroupCount() - 1 && i11 == getChildrenCount(i10) - 1) ? 8 : 0);
        c8275a.f38547a.setText(((C8342b.a) getChild(i10, i11)).m51995c());
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i10) {
        FaqClassification.Classification classification = (FaqClassification.Classification) getGroup(i10);
        if (classification != null && this.f38545b != null) {
            List<C8342b.a> list = this.f38545b.get(classification.m51921d());
            if (list != null) {
                return list.size();
            }
        }
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i10) {
        List<FaqClassification.Classification> list = this.f38544a;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f38544a.get(i10);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f38544a.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i10) {
        return i10;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i10, boolean z10, View view, ViewGroup viewGroup) {
        View viewInflate;
        C8277c c8277c;
        if (view == null) {
            c8277c = new C8277c();
            viewInflate = LayoutInflater.from(this.f38546c).inflate(R$layout.faq_sdk_adapter_third_list_item, viewGroup, false);
            c8277c.f38552a = (TextView) viewInflate.findViewById(R$id.tv_name);
            c8277c.f38553b = viewInflate.findViewById(R$id.divider_view);
            viewInflate.setTag(c8277c);
        } else {
            viewInflate = view;
            c8277c = (C8277c) view.getTag();
        }
        c8277c.f38553b.setVisibility(i10 == getGroupCount() + (-1) ? 8 : 0);
        c8277c.f38552a.setText(this.f38544a.get(i10).m51922e());
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i10, int i11) {
        return true;
    }
}
