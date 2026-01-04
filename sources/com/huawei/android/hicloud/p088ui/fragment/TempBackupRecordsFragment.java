package com.huawei.android.hicloud.p088ui.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupMainDeviceAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.cloudbackup.model.C4867a;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedList;
import p015ak.C0209d;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TempBackupRecordsFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    public Context f18270a;

    /* renamed from: b */
    public View f18271b;

    /* renamed from: c */
    public BackupMainDeviceAdapter f18272c;

    /* renamed from: d */
    public HwRecyclerView f18273d;

    /* renamed from: e */
    public int f18274e = 1;

    /* renamed from: f */
    public Handler.Callback f18275f = new C3978a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.TempBackupRecordsFragment$a */
    public class C3978a implements Handler.Callback {
        public C3978a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 33055) {
                return false;
            }
            C11839m.m70688i("TempBackupRecordsFragment", "refresh deviceListTempAdapter");
            if (TempBackupRecordsFragment.this.f18272c == null) {
                return false;
            }
            TempBackupRecordsFragment.this.f18272c.m5213j();
            return false;
        }
    }

    /* renamed from: b */
    public int m24324b() {
        return this.f18274e;
    }

    /* renamed from: c */
    public final void m24325c() {
        BackupMainDeviceAdapter backupMainDeviceAdapter = new BackupMainDeviceAdapter(this.f18270a, this);
        this.f18272c = backupMainDeviceAdapter;
        this.f18273d.setAdapter(backupMainDeviceAdapter);
        this.f18273d.setLayoutManager(new BackupMainDeviceAdapter.LayoutManager(this.f18270a));
        this.f18273d.addOnItemTouchListener(new BackupMainDeviceAdapter.C4021c());
        this.f18273d.setFocusableInTouchMode(false);
        this.f18273d.setItemAnimator(null);
    }

    /* renamed from: d */
    public final void m24326d(C4867a c4867a) {
        Context context = this.f18270a;
        if (context instanceof BackupMainActivity) {
            ((BackupMainActivity) context).m18774X5(c4867a, true);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: e */
    public void m24327e(LinkedList<C4867a> linkedList, int i10) {
        if (linkedList == null || linkedList.isEmpty()) {
            C11839m.m70689w("TempBackupRecordsFragment", "tempItemLinkedList is null.");
            this.f18271b.setVisibility(8);
            return;
        }
        if (this.f18272c == null) {
            C11839m.m70689w("TempBackupRecordsFragment", "deviceListTempAdapter is null.");
            this.f18271b.setVisibility(8);
            return;
        }
        this.f18271b.setVisibility(0);
        this.f18273d.setVisibility(0);
        this.f18272c.m24744G();
        this.f18272c.m24741D(linkedList);
        if (i10 > 5) {
            if (this.f18274e == 2) {
                this.f18272c.m24743F(new C4867a(3));
            } else {
                this.f18272c.m24743F(new C4867a(2));
            }
        }
        this.f18272c.m5213j();
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"NotifyDataSetChanged"})
    public void onClick(View view) {
        if (R$id.device_item_view == view.getId()) {
            if (!C0209d.m1333z1(this.f18270a)) {
                C11839m.m70688i("TempBackupRecordsFragment", "<onDeviceItemClick> net work is not connected.");
                return;
            }
            BackupMainDeviceAdapter.C4022d c4022d = (BackupMainDeviceAdapter.C4022d) view.getTag();
            if (c4022d == null) {
                C11839m.m70688i("TempBackupRecordsFragment", "View has not holder.");
                return;
            }
            C4867a c4867a = (C4867a) this.f18272c.m24746I(c4022d.m5165l());
            if (c4867a == null) {
                C11839m.m70689w("TempBackupRecordsFragment", "deviceListTempAdapter Adapter item is null, viewId: " + view.getId());
                return;
            }
            int type = c4867a.getType();
            if (type == 1) {
                m24326d(c4867a);
                return;
            }
            if (type == 2) {
                this.f18274e = 2;
                this.f18272c.m24748K();
                this.f18272c.m24743F(new C4867a(4));
                this.f18272c.m5213j();
                Context context = this.f18270a;
                if (context instanceof BackupMainActivity) {
                    ((BackupMainActivity) context).m18808j6();
                    return;
                }
                return;
            }
            if (type == 3) {
                this.f18274e = 1;
                this.f18272c.m24750M();
                this.f18272c.m5213j();
            } else if (type != 4) {
                C11839m.m70689w("TempBackupRecordsFragment", "Unknown adapterItem type: " + c4867a.getType());
            }
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70688i("TempBackupRecordsFragment", "onCreateView: ");
        View view = this.f18271b;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18271b);
        }
        CloudBackupService.getInstance().register(this.f18275f);
        View viewInflate = layoutInflater.inflate(R$layout.fragment_temp_backup_records, viewGroup, false);
        this.f18271b = viewInflate;
        viewInflate.setVisibility(8);
        this.f18273d = (HwRecyclerView) C12809f.m76831d(this.f18271b, R$id.temp_devices_recycler_view);
        m24325c();
        return this.f18271b;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f18275f != null) {
            CloudBackupService.getInstance().unregister(this.f18275f);
        }
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        C11839m.m70688i("TempBackupRecordsFragment", "onInflate: ");
        super.onInflate(context, attributeSet, bundle);
        this.f18270a = context;
    }
}
