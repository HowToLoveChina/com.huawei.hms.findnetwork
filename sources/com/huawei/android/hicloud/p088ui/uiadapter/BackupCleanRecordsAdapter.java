package com.huawei.android.hicloud.p088ui.uiadapter;

import ae.C0121f;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.manager.DeviceIconManager;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupCleanRecordsAdapter extends RecyclerView.AbstractC0838h<C4015b> {

    /* renamed from: f */
    public static final String f18463f = "BackupCleanRecordsAdapter";

    /* renamed from: d */
    public Context f18464d;

    /* renamed from: e */
    public List<CloudBackupDeviceInfo> f18465e;

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupCleanRecordsAdapter$a */
    public static class C4014a extends RecyclerView.AbstractC0845o {

        /* renamed from: h0 */
        public int f18466h0;

        public C4014a(int i10) {
            this.f18466h0 = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0845o
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0856z c0856z) {
            super.getItemOffsets(rect, view, recyclerView, c0856z);
            if (recyclerView.getChildAdapterPosition(view) != c0856z.m5305b() - 1) {
                rect.bottom = this.f18466h0;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.BackupCleanRecordsAdapter$b */
    public static class C4015b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public ImageView f18467u;

        /* renamed from: v */
        public TextView f18468v;

        /* renamed from: w */
        public TextView f18469w;

        /* renamed from: x */
        public TextView f18470x;

        /* renamed from: y */
        public RecyclerView f18471y;

        public C4015b(View view) {
            super(view);
            this.f18467u = (ImageView) C12809f.m76831d(view, R$id.iv_device);
            this.f18468v = (TextView) C12809f.m76831d(view, R$id.tv_device_name);
            this.f18469w = (TextView) C12809f.m76831d(view, R$id.tv_current_device);
            this.f18470x = (TextView) C12809f.m76831d(view, R$id.tv_backup_size);
            this.f18471y = (RecyclerView) C12809f.m76831d(view, R$id.rv_device_records);
        }
    }

    public BackupCleanRecordsAdapter(Context context) {
        this.f18464d = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void mo723s(C4015b c4015b, int i10) {
        CloudBackupDeviceInfo cloudBackupDeviceInfo = this.f18465e.get(i10);
        if (cloudBackupDeviceInfo == null) {
            C11839m.m70687e(f18463f, "deviceInfo is null");
            return;
        }
        List<CloudRecoveryItem> recoveryItems = cloudBackupDeviceInfo.getRecoveryItems();
        if (recoveryItems == null || recoveryItems.isEmpty()) {
            C11839m.m70687e(f18463f, "itemList is null");
        } else {
            m24693G(c4015b, recoveryItems);
            c4015b.f18470x.setText(C0223k.m1524g(this.f18464d, cloudBackupDeviceInfo.getDeviceBackupSpace()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public C4015b mo724u(ViewGroup viewGroup, int i10) {
        if (this.f18464d == null) {
            C11839m.m70687e(f18463f, "context is null");
            this.f18464d = C0213f.m1377a();
        }
        return new C4015b(LayoutInflater.from(this.f18464d).inflate(R$layout.item_backup_clean_records, viewGroup, false));
    }

    /* renamed from: F */
    public void m24692F(List<CloudBackupDeviceInfo> list) {
        List<CloudBackupDeviceInfo> list2 = this.f18465e;
        if (list2 == null) {
            this.f18465e = new ArrayList();
        } else {
            list2.clear();
        }
        this.f18465e.addAll(list);
        m5213j();
    }

    /* renamed from: G */
    public final void m24693G(C4015b c4015b, List<CloudRecoveryItem> list) {
        CloudRecoveryItem cloudRecoveryItem = list.get(0);
        c4015b.f18467u.setImageDrawable(DeviceIconManager.getInstance().getDeviceIconFromCache(cloudRecoveryItem.getTerminalType(), cloudRecoveryItem.getDeviceCategory()));
        c4015b.f18468v.setText(CloudBackupUtil.getDeviceDisplayName(this.f18464d, cloudRecoveryItem));
        if (cloudRecoveryItem.isCurrent()) {
            c4015b.f18469w.setVisibility(0);
        } else {
            c4015b.f18469w.setVisibility(8);
        }
        c4015b.f18471y.setLayoutManager(new LinearLayoutManager(this.f18464d, 1, false));
        c4015b.f18471y.setNestedScrollingEnabled(false);
        c4015b.f18471y.setAdapter(new C0121f(this.f18464d, list));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<CloudBackupDeviceInfo> list = this.f18465e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
