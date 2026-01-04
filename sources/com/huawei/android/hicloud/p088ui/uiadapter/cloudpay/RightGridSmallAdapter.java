package com.huawei.android.hicloud.p088ui.uiadapter.cloudpay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$layout;

/* loaded from: classes3.dex */
public class RightGridSmallAdapter extends RightGridAdapter {
    public RightGridSmallAdapter(Context context) {
        super(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.RightGridAdapter
    /* renamed from: d */
    public View mo25395d() {
        Object systemService = this.f19030b.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = systemService instanceof LayoutInflater ? (LayoutInflater) systemService : null;
        if (layoutInflater != null) {
            return layoutInflater.inflate(R$layout.right_grid_layout_small, (ViewGroup) null);
        }
        return null;
    }
}
