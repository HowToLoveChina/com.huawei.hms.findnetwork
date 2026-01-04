package com.huawei.android.hicloud.p088ui.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupDetailActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupCheckActivity;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupDeviceAdapter;
import com.huawei.android.hicloud.p088ui.uiadapter.BackupMainDeviceAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.BackupDeviceView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.router.data.UserBackupInfo;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0224k0;
import p053ce.C1424b;
import p292fn.C9733f;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TempMainPageRecordFragment extends Fragment implements BackupDeviceAdapter.IRecyclerViewOnListener {

    /* renamed from: a */
    public Context f18277a;

    /* renamed from: b */
    public View f18278b;

    /* renamed from: c */
    public BackupDeviceAdapter f18279c;

    /* renamed from: d */
    public RecyclerView f18280d;

    /* renamed from: e */
    public HwTextView f18281e;

    /* renamed from: f */
    public NotchFitLinearLayout f18282f;

    /* renamed from: g */
    public List<UserBackupInfo.UserDeviceInfo> f18283g;

    /* renamed from: h */
    public GridLayoutManager f18284h;

    /* renamed from: i */
    public C1424b f18285i;

    /* renamed from: j */
    public Handler.Callback f18286j = new C3979a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.TempMainPageRecordFragment$a */
    public class C3979a implements Handler.Callback {
        public C3979a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 33055) {
                return false;
            }
            C11839m.m70688i("TempBackupRecordsFragment", "refresh deviceListTempAdapter");
            if (TempMainPageRecordFragment.this.f18279c == null) {
                return false;
            }
            TempMainPageRecordFragment.this.f18279c.m5213j();
            return false;
        }
    }

    /* renamed from: c */
    public final String m24330c() {
        return !C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement") ? C0209d.m1174H() : C0209d.m1171G();
    }

    @SuppressLint({"NotifyDataSetChanged", "UseCompatLoadingForDrawables"})
    /* renamed from: d */
    public final void m24331d() {
        this.f18282f.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f18338a.m24333f(view);
            }
        });
        BackupDeviceAdapter backupDeviceAdapter = new BackupDeviceAdapter(this.f18277a);
        this.f18279c = backupDeviceAdapter;
        backupDeviceAdapter.m24721Z(this);
        this.f18280d.setAdapter(this.f18279c);
        this.f18280d.setLayoutManager(new BackupMainDeviceAdapter.LayoutManager(this.f18277a));
        this.f18280d.setHasFixedSize(true);
        Context context = this.f18277a;
        this.f18284h = new BackupDeviceView.LayoutManager(context, C11842p.m70868u(context));
        this.f18285i = new C1424b(C11842p.m70840n(this.f18277a, 8));
        this.f18280d.setLayoutManager(this.f18284h);
        this.f18280d.setNestedScrollingEnabled(false);
        m24337j();
    }

    /* renamed from: e */
    public final void m24332e(int i10) {
        UserBackupInfo.UserDeviceInfo userDeviceInfo = this.f18283g.get(i10);
        BackupDetailItem backupDetailItem = new BackupDetailItem();
        backupDetailItem.m16384n(userDeviceInfo.getBackupDeviceId());
        backupDetailItem.m16386p(userDeviceInfo.isCurrent() ? 1 : 0);
        backupDetailItem.m16388r(userDeviceInfo.getDeviceCategory());
        backupDetailItem.m16389s(userDeviceInfo.getDeviceID());
        backupDetailItem.m16390t(userDeviceInfo.getDeviceType());
        backupDetailItem.m16368A(String.valueOf(userDeviceInfo.getLastbackupTime()));
        backupDetailItem.m16369I(TextUtils.isEmpty(userDeviceInfo.getDevDisplayName()) ? userDeviceInfo.getDeviceName() : userDeviceInfo.getDevDisplayName());
        backupDetailItem.m16370K(userDeviceInfo.getSize());
        backupDetailItem.m16372M(C0223k.m1524g(this.f18277a, userDeviceInfo.getSize()));
        backupDetailItem.m16385o(userDeviceInfo.getBakId());
        SafeIntent safeIntent = new SafeIntent(new Intent(this.f18277a, (Class<?>) CloudSpaceBackupDetailActivity.class));
        safeIntent.putExtra("backup_item_param", backupDetailItem);
        safeIntent.putExtra("isTempBackup", true);
        safeIntent.putExtra("pageType", GeneralRedirectUtil.TEMP_BACKUP_DEVICE_DETAIL);
        C13225d.m79490f1().m79585f0("mecloud_backupmain_click_manage_data", C13452e.m80781L().m80971t0());
        C13230i.m79525e1(safeIntent, "1", "40");
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_manage_data", "1", "40");
        safeIntent.putExtra("queryType", true);
        safeIntent.putExtra("isOnlyRefurbish", userDeviceInfo.isOnlyRefurbish());
        safeIntent.putExtra("isOnlyHarmonyNext", userDeviceInfo.isOnlyHarmonyNext());
        safeIntent.putExtra("backup_delete_report_entry", 3);
        safeIntent.putExtra("terminalType", userDeviceInfo.getTerminalType());
        C0224k0.m1544N(getActivity(), safeIntent, 10024);
    }

    /* renamed from: f */
    public final /* synthetic */ void m24333f(View view) {
        m24338k();
    }

    /* renamed from: g */
    public void m24334g() {
        if (AbstractC14026a.m84159a(this.f18283g)) {
            C11839m.m70689w("TempBackupRecordsFragment", "tempItemLinkedList is empty");
            return;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f18283g.size(); i11++) {
            UserBackupInfo.UserDeviceInfo userDeviceInfo = this.f18283g.get(i11);
            if (userDeviceInfo.isCurrent()) {
                userDeviceInfo.setDevDisplayName(m24330c());
                i10 = i11;
            }
        }
        this.f18279c.m24719X(new ArrayList(this.f18283g));
        this.f18279c.m5214k(i10);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: h */
    public void m24335h(List<UserBackupInfo.UserDeviceInfo> list, int i10) {
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("TempBackupRecordsFragment", "tempItemLinkedList is null.");
            this.f18278b.setVisibility(8);
            return;
        }
        if (this.f18279c == null) {
            C11839m.m70689w("TempBackupRecordsFragment", "deviceListTempAdapter is null.");
            this.f18278b.setVisibility(8);
            return;
        }
        this.f18278b.setVisibility(0);
        this.f18280d.setVisibility(0);
        if (i10 > 3) {
            this.f18281e.setVisibility(0);
            this.f18282f.setClickable(true);
            this.f18282f.setEnabled(true);
        } else {
            this.f18281e.setVisibility(8);
            this.f18282f.setClickable(false);
            this.f18282f.setEnabled(false);
        }
        this.f18283g = list;
        m24337j();
        this.f18279c.m24719X(new ArrayList(list));
        this.f18279c.m5213j();
    }

    /* renamed from: i */
    public void m24336i(String str) {
        if (AbstractC14026a.m84159a(this.f18283g) || this.f18279c == null) {
            C11839m.m70689w("TempBackupRecordsFragment", "not init");
        }
        for (int i10 = 0; i10 < this.f18283g.size(); i10++) {
            if (TextUtils.equals(str, this.f18283g.get(i10).getBakId())) {
                List<UserBackupInfo.UserDeviceInfo> list = this.f18283g;
                list.remove(list.get(i10));
                if (this.f18283g.isEmpty()) {
                    C11839m.m70689w("TempBackupRecordsFragment", "tempItemLinkedList is empty");
                    this.f18278b.setVisibility(8);
                    return;
                } else {
                    this.f18279c.m24719X(new ArrayList(this.f18283g));
                    this.f18279c.m5213j();
                    return;
                }
            }
        }
    }

    /* renamed from: j */
    public void m24337j() {
        C1424b c1424b;
        int iM70868u = C11842p.m70868u(this.f18277a);
        if (this.f18277a instanceof TempBackupCheckActivity) {
            this.f18279c.m24720Y(true);
            iM70868u = 1;
        }
        if (iM70868u > 1) {
            this.f18280d.setBackground(null);
        } else {
            this.f18280d.setBackground(this.f18277a.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
        }
        C1424b c1424b2 = this.f18285i;
        if (c1424b2 != null) {
            this.f18280d.removeItemDecoration(c1424b2);
        }
        if (!AbstractC14026a.m84159a(this.f18283g) && this.f18283g.size() == 1) {
            this.f18280d.setBackground(this.f18277a.getDrawable(R$drawable.storage_manage_cardview_list_shape_white));
            iM70868u = 1;
        }
        if (iM70868u > 1 && (c1424b = this.f18285i) != null) {
            c1424b.m8279a(iM70868u);
            this.f18280d.addItemDecoration(this.f18285i);
        }
        this.f18279c.m24718W(iM70868u);
        this.f18284h.setSpanCount(iM70868u);
        this.f18279c.m5213j();
    }

    /* renamed from: k */
    public final void m24338k() {
        SafeIntent safeIntent = new SafeIntent(new Intent(this.f18277a, (Class<?>) CloudSpaceBackupActivity.class));
        safeIntent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        safeIntent.putExtra("queryType", true);
        C13230i.m79525e1(safeIntent, "1", "mecloud_backupmain_click_more");
        this.f18277a.startActivity(safeIntent);
        C13225d.m79490f1().m79585f0("mecloud_backupmain_click_more", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_backupmain_click_more", "1", "86");
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70688i("TempBackupRecordsFragment", "onCreateView: ");
        View view = this.f18278b;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18278b);
        }
        CloudBackupService.getInstance().register(this.f18286j);
        View viewInflate = layoutInflater.inflate(R$layout.fragment_temp_main_records, viewGroup, false);
        this.f18278b = viewInflate;
        viewInflate.setVisibility(8);
        this.f18280d = (RecyclerView) C12809f.m76831d(this.f18278b, R$id.temp_devices_recycler_view);
        this.f18282f = (NotchFitLinearLayout) C12809f.m76831d(this.f18278b, R$id.temp_device_title_layout);
        HwTextView hwTextView = (HwTextView) C12809f.m76831d(this.f18278b, R$id.temp_device_text_more);
        this.f18281e = hwTextView;
        hwTextView.setVisibility(8);
        this.f18282f.setClickable(false);
        m24331d();
        return this.f18278b;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f18286j != null) {
            CloudBackupService.getInstance().unregister(this.f18286j);
        }
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        C11839m.m70688i("TempBackupRecordsFragment", "onInflate: ");
        super.onInflate(context, attributeSet, bundle);
        this.f18277a = context;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.BackupDeviceAdapter.IRecyclerViewOnListener
    public void onItemClick(int i10, Object obj) {
        if (C0209d.m1226Y0()) {
            return;
        }
        if (!C0209d.m1333z1(this.f18277a)) {
            C11839m.m70688i("TempBackupRecordsFragment", "<onDeviceItemClick> net work is not connected.");
            return;
        }
        Context context = this.f18277a;
        if (context instanceof MainActivity) {
            m24332e(i10);
        } else if (context instanceof TempBackupCheckActivity) {
            m24332e(i10);
        }
    }
}
