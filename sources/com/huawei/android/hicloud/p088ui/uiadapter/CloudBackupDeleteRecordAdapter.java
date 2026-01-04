package com.huawei.android.hicloud.p088ui.uiadapter;

import ae.C0138j0;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.request.cbs.bean.CBSDevice;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import p015ak.C0223k;
import p015ak.C0241z;
import p336he.C10159j;
import p514o9.C11839m;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CloudBackupDeleteRecordAdapter extends RecyclerView.AbstractC0838h<C0138j0> {

    /* renamed from: d */
    public Context f18628d;

    /* renamed from: e */
    public C0138j0 f18629e;

    /* renamed from: f */
    public List<CBSDevice> f18630f = new ArrayList();

    /* renamed from: g */
    public IRecyclerViewOnListener f18631g;

    /* renamed from: h */
    public int f18632h;

    /* renamed from: i */
    public long f18633i;

    public interface IRecyclerViewOnListener {
        /* renamed from: l0 */
        void mo19349l0(int i10, boolean z10);

        /* renamed from: r */
        void mo19350r(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudBackupDeleteRecordAdapter$a */
    public class C4038a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        public final /* synthetic */ int f18634a;

        public C4038a(int i10) {
            this.f18634a = i10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            C11839m.m70688i("CloudBackupDeleteRecordAdapter", "onCheckedChanged: " + z10);
            if (CloudBackupDeleteRecordAdapter.this.f18630f == null || CloudBackupDeleteRecordAdapter.this.f18630f.size() <= 0 || CloudBackupDeleteRecordAdapter.this.f18631g == null) {
                return;
            }
            ((CBSDevice) CloudBackupDeleteRecordAdapter.this.f18630f.get(this.f18634a)).setChecked(z10);
            CloudBackupDeleteRecordAdapter.this.f18631g.mo19349l0(this.f18634a, z10);
            CloudBackupDeleteRecordAdapter.this.m24875H();
        }
    }

    public CloudBackupDeleteRecordAdapter(Context context, List<CBSDevice> list, int i10) {
        this.f18633i = 0L;
        this.f18628d = context;
        this.f18632h = i10;
        this.f18633i = Long.parseLong(String.valueOf(i10)) * 2592000000L;
        this.f18630f.clear();
        this.f18630f.addAll(list);
    }

    /* renamed from: G */
    public void m24874G(List<CBSDevice> list, int i10) {
        this.f18632h = i10;
        this.f18633i = Long.parseLong(String.valueOf(i10)) * 2592000000L;
        this.f18630f.clear();
        this.f18630f.addAll(list);
    }

    /* renamed from: H */
    public final void m24875H() {
        Iterator<CBSDevice> it = this.f18630f.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().isChecked()) {
                i10++;
            }
        }
        if (this.f18631g != null) {
            if (i10 == this.f18630f.size()) {
                this.f18631g.mo19350r(true);
            } else {
                this.f18631g.mo19350r(false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void mo723s(C0138j0 c0138j0, int i10) throws Resources.NotFoundException {
        if (c0138j0 == null) {
            C11839m.m70687e("CloudBackupDeleteRecordAdapter", "holder is null");
            return;
        }
        CBSDevice cBSDevice = this.f18630f.get(i10);
        c0138j0.f497u.setText(cBSDevice.getDevDisplayName());
        long jM1688f = C0241z.m1688f(cBSDevice.getBakUpdateTime());
        c0138j0.f498v.setText(this.f18628d.getResources().getString(R$string.cloudbackup_last_time, C10159j.m63334j(new Date(jM1688f))));
        long jCurrentTimeMillis = System.currentTimeMillis() - jM1688f;
        C11839m.m70686d("CloudBackupDeleteRecordAdapter", "timer" + jCurrentTimeMillis + " devices:" + cBSDevice.getDevDisplayName() + " clearTimes:" + this.f18633i + " isChecked:" + cBSDevice.isChecked());
        if (jCurrentTimeMillis > this.f18633i) {
            Resources resources = this.f18628d.getResources();
            int i11 = R$plurals.cloudbackup_device_over_month;
            int i12 = this.f18632h;
            c0138j0.f499w.setText(resources.getQuantityString(i11, i12, Integer.valueOf(i12)));
        } else {
            c0138j0.f499w.setVisibility(8);
        }
        c0138j0.f500x.setText(C0223k.m1524g(this.f18628d, C0241z.m1688f(cBSDevice.getDeviceSpace())));
        c0138j0.f501y.setChecked(cBSDevice.isChecked());
        c0138j0.f501y.setOnCheckedChangeListener(new C4038a(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public C0138j0 mo724u(ViewGroup viewGroup, int i10) {
        if (this.f18628d == null) {
            C11839m.m70689w("CloudBackupDeleteRecordAdapter", "onCreateViewHolder context is null");
            return null;
        }
        C0138j0 c0138j0 = new C0138j0(C13843a.m83067S() ? LayoutInflater.from(this.f18628d).inflate(R$layout.backup_delete_records_zn, viewGroup, false) : LayoutInflater.from(this.f18628d).inflate(R$layout.backup_delete_records, viewGroup, false), this.f18628d);
        this.f18629e = c0138j0;
        return c0138j0;
    }

    /* renamed from: K */
    public void m24878K(IRecyclerViewOnListener iRecyclerViewOnListener) {
        this.f18631g = iRecyclerViewOnListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<CBSDevice> list = this.f18630f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
