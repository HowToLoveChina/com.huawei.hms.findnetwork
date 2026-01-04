package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.cbs.bean.CBSDeviceCleanItem;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import p015ak.C0223k;
import p015ak.C0241z;
import p336he.C10159j;
import p514o9.C11839m;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ExpiredBackupRecordsAdapter extends BaseAdapter {

    /* renamed from: a */
    public final Context f18750a;

    /* renamed from: b */
    public final LayoutInflater f18751b;

    /* renamed from: c */
    public final DeviceCheckedCallback f18752c;

    /* renamed from: d */
    public List<CBSDeviceCleanItem> f18753d = new ArrayList();

    /* renamed from: e */
    public int f18754e = 0;

    public interface DeviceCheckedCallback {
        /* renamed from: a0 */
        void mo21924a0(boolean z10);

        /* renamed from: b */
        void mo21925b(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.ExpiredBackupRecordsAdapter$a */
    public static class C4053a {

        /* renamed from: a */
        public CheckBox f18755a;

        /* renamed from: b */
        public TextView f18756b;

        /* renamed from: c */
        public TextView f18757c;

        /* renamed from: d */
        public TextView f18758d;

        /* renamed from: e */
        public View f18759e = null;

        /* renamed from: f */
        public ImageView f18760f;

        /* renamed from: g */
        public CheckBox m25052g() {
            return this.f18755a;
        }

        /* renamed from: h */
        public void m25053h(CheckBox checkBox, TextView textView, TextView textView2, TextView textView3, View view, ImageView imageView) {
            this.f18755a = checkBox;
            this.f18756b = textView;
            this.f18758d = textView2;
            this.f18757c = textView3;
            this.f18759e = view;
            this.f18760f = imageView;
        }
    }

    public ExpiredBackupRecordsAdapter(Context context, DeviceCheckedCallback deviceCheckedCallback) {
        this.f18750a = context;
        this.f18751b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f18752c = deviceCheckedCallback;
    }

    /* renamed from: b */
    public int m25035b() {
        if (AbstractC14026a.m84159a(this.f18753d)) {
            this.f18754e = 0;
        }
        return this.f18754e;
    }

    /* renamed from: c */
    public final /* synthetic */ void m25036c(CheckBox checkBox, CBSDeviceCleanItem cBSDeviceCleanItem, View view) {
        boolean zIsChecked = checkBox.isChecked();
        cBSDeviceCleanItem.setChecked(zIsChecked);
        if (zIsChecked) {
            this.f18754e++;
        } else {
            this.f18754e--;
        }
        DeviceCheckedCallback deviceCheckedCallback = this.f18752c;
        if (deviceCheckedCallback == null) {
            return;
        }
        deviceCheckedCallback.mo21924a0(zIsChecked);
        this.f18752c.mo21925b(this.f18754e == this.f18753d.size());
    }

    /* renamed from: d */
    public void m25037d(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("ExpiredBackupRecordsAdapter", "deviceId is empty");
            return;
        }
        Iterator<CBSDeviceCleanItem> it = this.f18753d.iterator();
        while (it.hasNext()) {
            CBSDeviceCleanItem next = it.next();
            if (next != null && StringUtil.equals(str, next.getCbsDevice().getDeviceId())) {
                it.remove();
                this.f18754e--;
            }
        }
    }

    /* renamed from: e */
    public void m25038e(boolean z10) {
        if (AbstractC14026a.m84159a(this.f18753d)) {
            this.f18754e = 0;
        } else {
            this.f18754e = z10 ? this.f18753d.size() : 0;
        }
    }

    /* renamed from: f */
    public final void m25039f(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) {
        textView.setText(this.f18750a.getResources().getString(R$string.backup_last_used, C10159j.m63334j(new Date(C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getBakUpdateTime())))));
    }

    /* renamed from: g */
    public final void m25040g(final CBSDeviceCleanItem cBSDeviceCleanItem, final CheckBox checkBox) {
        if (checkBox == null || cBSDeviceCleanItem == null) {
            return;
        }
        checkBox.setChecked(cBSDeviceCleanItem.isChecked());
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: ae.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f490a.m25036c(checkBox, cBSDeviceCleanItem, view);
            }
        });
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18753d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f18753d.size()) {
            return null;
        }
        return this.f18753d.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewM76832e;
        C4053a c4053a;
        CBSDeviceCleanItem cBSDeviceCleanItem = this.f18753d.get(i10);
        if (view == null) {
            c4053a = new C4053a();
            viewM76832e = C12809f.m76832e(this.f18751b, R$layout.expired_backup_records_item);
            c4053a.m25053h((CheckBox) C12809f.m76831d(viewM76832e, R$id.check_box), (TextView) C12809f.m76831d(viewM76832e, R$id.backup_device_name), (TextView) C12809f.m76831d(viewM76832e, R$id.backup_last_time), (TextView) C12809f.m76831d(viewM76832e, R$id.space_value), C12809f.m76831d(viewM76832e, R$id.backup_item_divider), (ImageView) C12809f.m76831d(viewM76832e, R$id.backup_detail_icon));
            viewM76832e.setTag(c4053a);
        } else {
            viewM76832e = view;
            c4053a = (C4053a) view.getTag();
        }
        m25041h(cBSDeviceCleanItem, c4053a.f18756b);
        m25039f(cBSDeviceCleanItem, c4053a.f18758d);
        m25043j(cBSDeviceCleanItem, c4053a.f18757c);
        m25040g(cBSDeviceCleanItem, c4053a.f18755a);
        m25044k(i10, c4053a.f18759e);
        m25042i(cBSDeviceCleanItem, c4053a.f18760f);
        return viewM76832e;
    }

    /* renamed from: h */
    public final void m25041h(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) throws Resources.NotFoundException {
        String devDisplayName = cBSDeviceCleanItem.getCbsDevice().getDevDisplayName();
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = cBSDeviceCleanItem.getCbsDevice().getAliasName();
        }
        if (TextUtils.isEmpty(devDisplayName)) {
            devDisplayName = this.f18750a.getString(R$string.setting_other);
        }
        if (cBSDeviceCleanItem.isCurrent()) {
            devDisplayName = this.f18750a.getResources().getString(R$string.cloudbackup_self_device_new_update, devDisplayName);
        }
        textView.setText(devDisplayName);
        textView.setContentDescription(devDisplayName + ".");
    }

    /* renamed from: i */
    public void m25042i(CBSDeviceCleanItem cBSDeviceCleanItem, ImageView imageView) {
        imageView.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(cBSDeviceCleanItem.getCbsDevice().getTerminalType(), cBSDeviceCleanItem.getCbsDevice().getDeviceCategory()));
    }

    /* renamed from: j */
    public final void m25043j(CBSDeviceCleanItem cBSDeviceCleanItem, TextView textView) {
        String strM1524g = C0223k.m1524g(this.f18750a, C0241z.m1688f(cBSDeviceCleanItem.getCbsDevice().getDeviceSpace()));
        textView.setText(strM1524g);
        textView.setContentDescription(strM1524g);
    }

    /* renamed from: k */
    public final void m25044k(int i10, View view) {
        if (i10 == this.f18753d.size() - 1) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    /* renamed from: l */
    public void m25045l(List<CBSDeviceCleanItem> list) {
        this.f18753d = list;
    }
}
