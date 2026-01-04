package com.huawei.android.hicloud.p088ui.fragment;

import ae.C0178w1;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudspace.bean.CBSpaceDetail;
import com.huawei.android.hicloud.hisync.model.BackupDetailItem;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceBackupDetailActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.p106db.bean.RecommendCardReport;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0224k0;
import p514o9.C11839m;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p815ym.AbstractC14026a;

/* loaded from: classes3.dex */
public class TempBackupRecordsCBSpaceDetailFragment extends TempBackupRecordsBaseFragment {

    /* renamed from: e */
    public C0178w1 f18265e;

    /* renamed from: f */
    public int f18266f;

    /* renamed from: g */
    public List<CBSpaceDetail> f18267g;

    /* renamed from: h */
    public Handler.Callback f18268h = new C3977a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.TempBackupRecordsCBSpaceDetailFragment$a */
    public class C3977a implements Handler.Callback {
        public C3977a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 33055) {
                return false;
            }
            C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "refresh deviceRecordsAdapter");
            if (TempBackupRecordsCBSpaceDetailFragment.this.f18265e == null) {
                return false;
            }
            TempBackupRecordsCBSpaceDetailFragment.this.f18265e.notifyDataSetChanged();
            return false;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBaseFragment
    /* renamed from: a */
    public void mo24310a() {
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBaseFragment
    /* renamed from: b */
    public void mo24311b(View view) {
        if (R$id.backup_detail == view.getId()) {
            if (!C0209d.m1333z1(this.f18261a)) {
                C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "<onDeviceItemClick> net work is not connected.");
                return;
            }
            C0178w1.a aVar = (C0178w1.a) view.getTag();
            if (aVar == null) {
                C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "View has not holder.");
                return;
            }
            CBSpaceDetail cBSpaceDetail = (CBSpaceDetail) this.f18265e.getItem(aVar.m984g());
            if (cBSpaceDetail == null) {
                C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "deviceListTempAdapter Adapter item is null, viewId: " + view.getId());
                return;
            }
            if (this.f18266f == 3) {
                m24318e(cBSpaceDetail);
            } else {
                m24317d(cBSpaceDetail);
            }
        }
    }

    /* renamed from: d */
    public final void m24317d(CBSpaceDetail cBSpaceDetail) {
        BackupDetailItem backupDetailItem = new BackupDetailItem();
        backupDetailItem.m16373a(cBSpaceDetail);
        backupDetailItem.m16368A(String.valueOf(cBSpaceDetail.getLastbackupTime()));
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("isCurrent", String.valueOf(backupDetailItem.m16376e() == 1));
        C13225d.m79490f1().m79591l0("mecloud_cloudspace_click_backup_detail", linkedHashMapM79499C);
        UBAAnalyze.m29954O("PVC", "mecloud_cloudspace_click_backup_detail", "1", "43");
        C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "mecloud_cloudspace_click_backup_detail");
        backupDetailItem.m16372M(C0223k.m1524g(this.f18261a, backupDetailItem.m16382l()));
        if (cBSpaceDetail.isTempBackup()) {
            backupDetailItem.m16385o(cBSpaceDetail.getBakId());
        }
        RecommendCardReport recommendCardReport = new RecommendCardReport();
        Intent intent = new Intent(this.f18261a, (Class<?>) CloudSpaceBackupDetailActivity.class);
        intent.putExtra("backup_delete_report_entry", 2);
        intent.putExtra("recommend_card_activity_id", recommendCardReport.getActivityId());
        intent.putExtra("isOnlyRefurbish", cBSpaceDetail.isOnlyRefurbish());
        intent.putExtra("isOnlyHarmonyNext", cBSpaceDetail.isOnlyHarmonyNext());
        intent.putExtra("recommend_card_activity_type", recommendCardReport.getActivityType());
        intent.putExtra("recommend_card_entrance", recommendCardReport.getEntrance());
        intent.putExtra("backup_item_param", backupDetailItem);
        intent.putExtra("terminalType", backupDetailItem.m16383m());
        intent.putExtra("isTempBackup", true);
        C0224k0.m1544N(getActivity(), intent, 10024);
    }

    /* renamed from: e */
    public final void m24318e(CBSpaceDetail cBSpaceDetail) {
        Intent intent = new Intent(this.f18261a, (Class<?>) CloudBackupRecordsActivity.class);
        C13225d.m79490f1().m79585f0("mecloud_backupdetail_click_backup_restore", C13452e.m80781L().m80971t0());
        C13230i.m79525e1(intent, "1", "39");
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_click_backup_restore", "1", "39");
        intent.putExtra("backup_device_id", cBSpaceDetail.getBackupDeviceId());
        intent.putExtra(C6148x2.DEVICE_ID, cBSpaceDetail.getDeviceID());
        intent.putExtra("is_current_device", cBSpaceDetail.isCurrent());
        if (this.f18266f == 3) {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 3);
        } else {
            intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 2);
        }
        intent.putExtra("isTempBackup", true);
        intent.putExtra("backup_device_new", cBSpaceDetail.getDeviceName());
        intent.putExtra("backup_data_size", cBSpaceDetail.getSize());
        intent.putExtra("backup_device_category", cBSpaceDetail.getDeviceCategory());
        intent.putExtra("backup_is_temp_backup_type", true);
        C0224k0.m1544N(getActivity(), intent, 10047);
        getActivity().overridePendingTransition(0, 0);
    }

    /* renamed from: f */
    public void m24319f(String str) {
        List<CBSpaceDetail> list = this.f18267g;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f18267g.size()) {
                break;
            }
            if (TextUtils.equals(str, this.f18267g.get(i10).getBakId())) {
                List<CBSpaceDetail> list2 = this.f18267g;
                list2.remove(list2.get(i10));
                break;
            }
            i10++;
        }
        C0178w1 c0178w1 = this.f18265e;
        if (c0178w1 != null) {
            c0178w1.notifyDataSetChanged();
        }
    }

    /* renamed from: g */
    public void m24320g(List<CBSpaceDetail> list) {
        if (this.f18265e == null) {
            C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "deviceListTempAdapter is null.");
            this.f18262b.setVisibility(8);
            return;
        }
        if (AbstractC14026a.m84159a(list)) {
            C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "tempItemLinkedList is empty.");
            this.f18265e.m974c();
            this.f18262b.setVisibility(8);
        } else {
            this.f18264d.setVisibility(0);
            this.f18262b.setVisibility(0);
            this.f18265e.m974c();
            this.f18267g = list;
            this.f18265e.m972a(list);
            this.f18265e.notifyDataSetChanged();
        }
    }

    /* renamed from: h */
    public void m24321h(int i10) {
        this.f18266f = i10;
        C0178w1 c0178w1 = new C0178w1(this.f18261a, this, i10 == 3);
        this.f18265e = c0178w1;
        this.f18264d.setAdapter((ListAdapter) c0178w1);
    }

    /* renamed from: i */
    public void m24322i(int i10) {
        this.f18262b.setVisibility(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBaseFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "onCreateView: ");
        CloudBackupService.getInstance().register(this.f18268h);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f18268h != null) {
            CloudBackupService.getInstance().unregister(this.f18268h);
        }
    }
}
