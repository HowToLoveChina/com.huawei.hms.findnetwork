package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceCleanItem;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0241z;
import p336he.C10159j;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackUpDeviceSpaceAdapter extends BaseAdapter {

    /* renamed from: a */
    public final Context f18449a;

    /* renamed from: b */
    public final LayoutInflater f18450b;

    /* renamed from: c */
    public final DeviceCheckedCallback f18451c;

    /* renamed from: d */
    public List<CBSDeviceCleanItem> f18452d = new ArrayList();

    /* renamed from: e */
    public int f18453e = 0;

    /* renamed from: f */
    public int f18454f = 3;

    /* renamed from: g */
    public long f18455g;

    public interface DeviceCheckedCallback {
        /* renamed from: b */
        void mo20664b(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackUpDeviceSpaceAdapter$a */
    public static class C4013a {

        /* renamed from: a */
        public TextView f18456a = null;

        /* renamed from: b */
        public TextView f18457b = null;

        /* renamed from: c */
        public TextView f18458c = null;

        /* renamed from: d */
        public TextView f18459d = null;

        /* renamed from: e */
        public View f18460e = null;

        /* renamed from: f */
        public ImageView f18461f;

        /* renamed from: g */
        public ImageView f18462g;

        /* renamed from: h */
        public void m24689h(TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, ImageView imageView, ImageView imageView2) {
            this.f18456a = textView;
            this.f18457b = textView2;
            this.f18458c = textView3;
            this.f18459d = textView4;
            this.f18460e = view;
            this.f18461f = imageView;
            this.f18462g = imageView2;
        }
    }

    public BackUpDeviceSpaceAdapter(Context context, DeviceCheckedCallback deviceCheckedCallback) {
        this.f18449a = context;
        this.f18450b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18451c = deviceCheckedCallback;
    }

    /* renamed from: b */
    public final /* synthetic */ void m24671b(View view) {
        this.f18451c.mo20664b(false);
    }

    /* renamed from: c */
    public void m24672c(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("BackUpDeviceSpaceAdapter", "deviceId is empty");
            return;
        }
        Iterator<CBSDeviceCleanItem> it = this.f18452d.iterator();
        while (it.hasNext()) {
            CBSDeviceCleanItem next = it.next();
            if (next != null && StringUtil.equals(str, next.getCbsDevice().getDeviceId())) {
                it.remove();
                this.f18453e--;
            }
        }
    }

    /* renamed from: d */
    public final void m24673d(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) {
        textView.setText(this.f18449a.getResources().getString(R$string.backup_last_used, C10159j.m63334j(new Date(C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime())))));
    }

    /* renamed from: e */
    public final void m24674e(CBSDeviceCleanItem cBSDeviceCleanItem, ImageView imageView) {
        if (imageView == null || cBSDeviceCleanItem == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ae.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f347a.m24671b(view);
            }
        });
    }

    /* renamed from: f */
    public void m24675f(int i10) {
        this.f18454f = i10;
        this.f18455g = Long.parseLong(String.valueOf(i10)) * 2592000000L;
    }

    /* renamed from: g */
    public final void m24676g(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) throws Resources.NotFoundException {
        String devDisplayName = cBSDeviceCleanItem.getCbsDevice().getDevDisplayName();
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = cBSDeviceCleanItem.getCbsDevice().getAliasName();
        }
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = this.f18449a.getString(R$string.setting_other);
        }
        if (cBSDeviceCleanItem.isCurrent()) {
            devDisplayName = this.f18449a.getResources().getString(R$string.cloudbackup_self_device_new_update, devDisplayName);
        }
        textView.setText(devDisplayName);
        textView.setContentDescription(devDisplayName + ".");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18452d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f18452d.size()) {
            return null;
        }
        return this.f18452d.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewM76832e;
        C4013a c4013a;
        CBSDeviceCleanItem cBSDeviceCleanItem = this.f18452d.get(i10);
        if (view == null) {
            c4013a = new C4013a();
            viewM76832e = C0209d.m1195O(this.f18449a) >= 1.45f ? C12809f.m76832e(this.f18450b, R$layout.device_space_clear_item_scale_3) : C12809f.m76832e(this.f18450b, R$layout.device_space_clear_item);
            c4013a.m24689h((TextView) C12809f.m76831d(viewM76832e, R$id.backup_device_name), (TextView) C12809f.m76831d(viewM76832e, R$id.backup_last_time), (TextView) C12809f.m76831d(viewM76832e, R$id.backup_overdue_time), (TextView) C12809f.m76831d(viewM76832e, R$id.space_value), C12809f.m76831d(viewM76832e, R$id.backup_item_divider), (ImageView) C12809f.m76831d(viewM76832e, R$id.backup_detail_icon), (ImageView) C12809f.m76831d(viewM76832e, R$id.device_space_clear_arrow));
            viewM76832e.setTag(c4013a);
        } else {
            viewM76832e = view;
            c4013a = (C4013a) view.getTag();
        }
        m24676g(cBSDeviceCleanItem, c4013a.f18456a);
        m24673d(cBSDeviceCleanItem, c4013a.f18457b);
        m24681l(cBSDeviceCleanItem, c4013a.f18458c);
        m24678i(cBSDeviceCleanItem, c4013a.f18459d);
        m24674e(cBSDeviceCleanItem, c4013a.f18462g);
        m24679j(i10, c4013a.f18460e);
        m24677h(cBSDeviceCleanItem, c4013a.f18461f);
        return viewM76832e;
    }

    /* renamed from: h */
    public final void m24677h(CBSDeviceCleanItem cBSDeviceCleanItem, ImageView imageView) {
        imageView.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(cBSDeviceCleanItem.getCbsDevice().getTerminalType(), cBSDeviceCleanItem.getCbsDevice().getDeviceCategory()));
    }

    /* renamed from: i */
    public final void m24678i(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) {
        String strM1524g = C0223k.m1524g(this.f18449a, C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getDeviceSpace()));
        textView.setText(strM1524g);
        textView.setContentDescription(strM1524g);
    }

    /* renamed from: j */
    public final void m24679j(int i10, View view) {
        if (i10 == this.f18452d.size() - 1) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    /* renamed from: k */
    public void m24680k(List<CBSDeviceCleanItem> list) {
        this.f18452d = list;
    }

    /* renamed from: l */
    public final void m24681l(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) {
        if (System.currentTimeMillis() - C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime()) <= this.f18455g) {
            textView.setVisibility(8);
            return;
        }
        Resources resources = this.f18449a.getResources();
        int i10 = R$plurals.cloudbackup_device_over_month;
        int i11 = this.f18454f;
        textView.setText(resources.getQuantityString(i10, i11, Integer.valueOf(i11)));
    }
}
