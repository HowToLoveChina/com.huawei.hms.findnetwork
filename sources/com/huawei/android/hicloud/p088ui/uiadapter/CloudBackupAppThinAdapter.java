package com.huawei.android.hicloud.p088ui.uiadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.ThinAppStatus;
import java.util.ArrayList;
import p015ak.C0223k;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupAppThinAdapter extends BaseAdapter {

    /* renamed from: a */
    public ArrayList<ThinAppStatus> f18621a = new ArrayList<>();

    /* renamed from: b */
    public Context f18622b;

    /* renamed from: c */
    public LayoutInflater f18623c;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudBackupAppThinAdapter$a */
    public static class C4037a {

        /* renamed from: a */
        public ImageView f18624a;

        /* renamed from: b */
        public TextView f18625b;

        /* renamed from: c */
        public TextView f18626c;

        /* renamed from: d */
        public CheckBox f18627d;
    }

    public CloudBackupAppThinAdapter(Context context) {
        this.f18622b = context;
        this.f18623c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public final C4037a m24860a(View view) {
        C4037a c4037a = new C4037a();
        c4037a.f18624a = (ImageView) C12809f.m76831d(view, R$id.iv_app_icon);
        c4037a.f18625b = (TextView) C12809f.m76831d(view, R$id.tv_app_name);
        c4037a.f18626c = (TextView) C12809f.m76831d(view, R$id.tv_app_size);
        c4037a.f18627d = (CheckBox) C12809f.m76831d(view, R$id.cb_thin_app);
        return c4037a;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ThinAppStatus getItem(int i10) {
        return this.f18621a.get(i10);
    }

    /* renamed from: c */
    public void m24862c(ArrayList<ThinAppStatus> arrayList) {
        if (arrayList != null) {
            this.f18621a.clear();
            this.f18621a.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ThinAppStatus> arrayList = this.f18621a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C4037a c4037aM24860a;
        if (view == null) {
            view = C12809f.m76832e(this.f18623c, R$layout.item_app_thin);
            c4037aM24860a = m24860a(view);
            view.setTag(c4037aM24860a);
        } else {
            c4037aM24860a = (C4037a) view.getTag();
        }
        ThinAppStatus item = getItem(i10);
        c4037aM24860a.f18624a.setImageDrawable(this.f18622b.getDrawable(R$drawable.icon_cloudbackup_applist));
        String appName = item.getAppName();
        long appDelTotalSize = item.getAppDelTotalSize();
        int action = item.getAction();
        c4037aM24860a.f18625b.setText(appName);
        c4037aM24860a.f18626c.setText(C0223k.m1524g(this.f18622b, appDelTotalSize));
        c4037aM24860a.f18627d.setChecked(action == 0);
        return view;
    }
}
