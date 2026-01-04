package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0219i;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PermissionsItemAdapter extends BaseAdapter {

    /* renamed from: a */
    public Context f18781a;

    /* renamed from: b */
    public int[] f18782b = {R$drawable.ic_agr_internet, R$drawable.ic_agr_phone, R$drawable.ic_agr_storage, R$drawable.ic_agr_camera, R$drawable.ic_agr_sms, R$drawable.ic_agr_contacts, R$drawable.ic_agr_calendar, R$drawable.ic_agr_calllogs, R$drawable.ic_agr_location};

    /* renamed from: c */
    public int[] f18783c = {R$string.huaweicloud_internet, R$string.huaweicloud_phone, R$string.hicloud_permission_storage, R$string.huaweicloud_camera, R$string.huaweicloud_sms, R$string.huaweicloud_contacts, R$string.huaweicloud_calender, R$string.huaweicloud_call_log, R$string.huaweicloud_location};

    /* renamed from: d */
    public int[] f18784d = {R$string.huaweicloud_internet_hint, R$string.huaweicloud_phone_hint, R$string.huaweicloud_storage_hint, R$string.huaweicloud_camera_sg_hint, R$string.huaweicloud_sms_sg_hint, R$string.huaweicloud_contacts_hint, R$string.huaweicloud_calender_hint, R$string.huaweicloud_call_log_hint, R$string.huaweicloud_location_hint};

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.PermissionsItemAdapter$b */
    public static class C4057b {

        /* renamed from: a */
        public ImageView f18785a;

        /* renamed from: b */
        public TextView f18786b;

        /* renamed from: c */
        public TextView f18787c;

        public C4057b() {
        }
    }

    public PermissionsItemAdapter(Context context) {
        this.f18781a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18782b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C4057b c4057b;
        if (view != null) {
            c4057b = (C4057b) view.getTag();
        } else {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f18781a);
            view = C0219i.m1463a() < 21 ? layoutInflaterFrom.inflate(R$layout.hisync_agr_permissions_agreement_item_emui9, viewGroup, false) : layoutInflaterFrom.inflate(R$layout.hisync_agr_permissions_agreement_item, viewGroup, false);
            c4057b = new C4057b();
            c4057b.f18785a = (ImageView) C12809f.m76831d(view, R$id.image_head);
            c4057b.f18786b = (TextView) C12809f.m76831d(view, R$id.text_head);
            c4057b.f18787c = (TextView) C12809f.m76831d(view, R$id.text_hint);
            view.setTag(c4057b);
        }
        c4057b.f18785a.setImageResource(this.f18782b[i10]);
        c4057b.f18786b.setText(this.f18783c[i10]);
        c4057b.f18787c.setText(this.f18784d[i10]);
        View viewM76831d = C12809f.m76831d(view, R$id.item_divider);
        if (viewM76831d != null && i10 == this.f18783c.length - 1) {
            viewM76831d.setVisibility(8);
        } else if (viewM76831d != null) {
            viewM76831d.setVisibility(0);
        }
        return view;
    }
}
