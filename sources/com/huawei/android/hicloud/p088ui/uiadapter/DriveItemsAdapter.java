package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.huawei.android.hicloud.p088ui.extend.HiCloudItemView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.DriveConfigService;
import java.util.ArrayList;
import p015ak.C0209d;
import p514o9.C11829c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class DriveItemsAdapter extends BaseAdapter {

    /* renamed from: a */
    public LayoutInflater f18736a;

    /* renamed from: b */
    public ArrayList<DriveConfigService> f18737b = new ArrayList<>();

    /* renamed from: c */
    public Context f18738c;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.DriveItemsAdapter$a */
    public static class C4051a {

        /* renamed from: a */
        public HiCloudItemView f18739a;

        /* renamed from: b */
        public int f18740b;

        /* renamed from: b */
        public void m25016b(int i10) {
            this.f18740b = i10;
        }

        /* renamed from: c */
        public void m25017c(HiCloudItemView hiCloudItemView) {
            this.f18739a = hiCloudItemView;
        }
    }

    public DriveItemsAdapter(Context context) {
        this.f18736a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18738c = context;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public DriveConfigService getItem(int i10) {
        if (i10 < 0 || i10 >= this.f18737b.size()) {
            return null;
        }
        return this.f18737b.get(i10);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18737b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        C4051a c4051a;
        if (view == null) {
            c4051a = new C4051a();
            viewM76832e = C12809f.m76832e(this.f18736a, R$layout.sync_func_list_item_layout);
            HiCloudItemView hiCloudItemView = (HiCloudItemView) C12809f.m76831d(viewM76832e, R$id.sync_func_list_item);
            hiCloudItemView.m23989v();
            c4051a.m25017c(hiCloudItemView);
            viewM76832e.setTag(c4051a);
            c4051a.f18739a.m23971b();
            c4051a.f18739a.m23962B();
            viewM76832e.setEnabled(true);
        } else {
            viewM76832e = view;
            c4051a = (C4051a) view.getTag();
        }
        c4051a.m25016b(i10);
        DriveConfigService driveConfigService = this.f18737b.get(i10);
        if (!C0209d.m1166E1()) {
            c4051a.f18739a.m23970a();
        }
        c4051a.f18739a.setTag(driveConfigService.getId());
        c4051a.f18739a.setTitle(driveConfigService.getTitleText());
        c4051a.f18739a.m23964D();
        c4051a.f18739a.m23990w();
        c4051a.f18739a.m23965E();
        if (driveConfigService.isSwitchStatus()) {
            c4051a.f18739a.setStatusText(this.f18738c.getString(R$string.cloudalbum_switch_open));
        } else {
            c4051a.f18739a.setStatusText(this.f18738c.getString(R$string.sync_switch_button_close));
        }
        Bitmap bitmapM70501B = C11829c.m70501B(driveConfigService.getIconPath());
        if (bitmapM70501B != null) {
            c4051a.f18739a.setImage(new BitmapDrawable((Resources) null, bitmapM70501B));
        }
        c4051a.f18739a.m23987t();
        return viewM76832e;
    }
}
