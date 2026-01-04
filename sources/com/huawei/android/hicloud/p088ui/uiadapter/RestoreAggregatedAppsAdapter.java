package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.RestoreAggregatedAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ModuleRestoreResultUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.ArrayList;
import java.util.List;
import sk.C12809f;

/* loaded from: classes3.dex */
public class RestoreAggregatedAppsAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f18811a;

    /* renamed from: b */
    public LayoutInflater f18812b;

    /* renamed from: c */
    public List<CloudRestoreItem> f18813c = new ArrayList();

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.RestoreAggregatedAppsAdapter$b */
    public static class C4063b {

        /* renamed from: a */
        public ImageView f18814a;

        /* renamed from: b */
        public TextView f18815b;

        /* renamed from: c */
        public TextView f18816c;

        public C4063b() {
        }
    }

    public RestoreAggregatedAppsAdapter(Context context) {
        this.f18811a = context;
        if (context != null) {
            this.f18812b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* renamed from: a */
    public final C4063b m25106a(View view) {
        C4063b c4063b = new C4063b();
        c4063b.f18814a = (ImageView) view.findViewById(R$id.app_icon);
        c4063b.f18815b = (TextView) view.findViewById(R$id.app_name);
        c4063b.f18816c = (TextView) view.findViewById(R$id.app_desc);
        return c4063b;
    }

    /* renamed from: b */
    public void m25107b(List<CloudRestoreItem> list) {
        this.f18813c.clear();
        this.f18813c.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18813c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < this.f18813c.size()) {
            return this.f18813c.get(i10);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        CloudRestoreItem cloudRestoreItem;
        C4063b c4063bM25106a;
        View viewM76832e;
        if (i10 >= this.f18813c.size() || (cloudRestoreItem = this.f18813c.get(i10)) == null) {
            return view;
        }
        String appId = cloudRestoreItem.getAppId();
        if (view == null) {
            viewM76832e = C12809f.m76832e(this.f18812b, R$layout.aggregated_app_restore_result_item);
            c4063bM25106a = m25106a(viewM76832e);
            viewM76832e.setTag(c4063bM25106a);
        } else {
            c4063bM25106a = (C4063b) view.getTag();
            viewM76832e = view;
        }
        if (c4063bM25106a == null) {
            return view;
        }
        c4063bM25106a.f18814a.setImageDrawable(RestoreUtil.getRestoreItemDrawable(cloudRestoreItem, appId));
        c4063bM25106a.f18815b.setText(RestoreAggregatedAppUtil.getAppName(this.f18811a, cloudRestoreItem));
        c4063bM25106a.f18816c.setText(ModuleRestoreResultUtil.getRestoreResultTips(this.f18811a, cloudRestoreItem));
        C12809f.m76831d(viewM76832e, R$id.list_item_divider).setVisibility(getCount() + (-1) == i10 ? 8 : 0);
        return viewM76832e;
    }
}
