package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class CloudSpaceShareUsageBaseAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f18707a;

    /* renamed from: b */
    public List<FamilyDetailInfo> f18708b = new ArrayList();

    /* renamed from: c */
    public Context f18709c;

    public CloudSpaceShareUsageBaseAdapter(Context context) {
        this.f18707a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18709c = context;
    }

    /* renamed from: a */
    public void mo989a(List<FamilyDetailInfo> list) {
        List<FamilyDetailInfo> list2 = this.f18708b;
        if (list2 != null) {
            list2.clear();
            this.f18708b.addAll(list);
            notifyDataSetChanged();
        }
    }
}
