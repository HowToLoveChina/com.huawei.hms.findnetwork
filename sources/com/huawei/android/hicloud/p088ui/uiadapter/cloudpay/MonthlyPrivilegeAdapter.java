package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.model.MonthlyPrivilegeItem;
import java.util.ArrayList;
import java.util.List;
import sk.C12809f;

/* loaded from: classes3.dex */
public class MonthlyPrivilegeAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f19012a;

    /* renamed from: b */
    public List<MonthlyPrivilegeItem> f19013b = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.cloudpay.MonthlyPrivilegeAdapter$b */
    public static class C4087b {

        /* renamed from: a */
        public ImageView f19014a;

        /* renamed from: b */
        public TextView f19015b;

        /* renamed from: c */
        public TextView f19016c;

        public C4087b() {
        }
    }

    public MonthlyPrivilegeAdapter(Context context) {
        this.f19012a = context;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MonthlyPrivilegeItem getItem(int i10) {
        if (i10 < 0 || i10 >= this.f19013b.size()) {
            return null;
        }
        return this.f19013b.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19013b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C4087b c4087b;
        if (view == null) {
            view = LayoutInflater.from(this.f19012a).inflate(R$layout.continuous_monthly_privileges_item, viewGroup, false);
            c4087b = new C4087b();
            c4087b.f19014a = (ImageView) C12809f.m76831d(view, R$id.monthly_privileges_icon);
            c4087b.f19015b = (TextView) C12809f.m76831d(view, R$id.monthly_privileges_tag);
            c4087b.f19016c = (TextView) C12809f.m76831d(view, R$id.monthly_privileges_desc);
            view.setTag(c4087b);
        } else {
            c4087b = (C4087b) view.getTag();
        }
        MonthlyPrivilegeItem item = getItem(i10);
        if (item != null) {
            String privilegeTag = item.getPrivilegeTag();
            String privilegeDesc = item.getPrivilegeDesc();
            Bitmap privilegeIcon = item.getPrivilegeIcon();
            if (!TextUtils.isEmpty(privilegeTag) && !TextUtils.isEmpty(privilegeDesc) && privilegeIcon != null) {
                c4087b.f19014a.setImageBitmap(privilegeIcon);
                c4087b.f19015b.setText(privilegeTag);
                c4087b.f19016c.setText(privilegeDesc);
            }
        }
        return view;
    }
}
