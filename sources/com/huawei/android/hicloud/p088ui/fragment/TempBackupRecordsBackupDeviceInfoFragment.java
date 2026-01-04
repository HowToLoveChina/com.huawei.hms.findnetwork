package com.huawei.android.hicloud.p088ui.fragment;

import ae.C0183y0;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupRecordsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudRestoreOptionsActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import java.util.List;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0224k0;
import p514o9.C11839m;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p815ym.AbstractC14026a;

/* loaded from: classes3.dex */
public class TempBackupRecordsBackupDeviceInfoFragment extends TempBackupRecordsBaseFragment {

    /* renamed from: e */
    public C0183y0 f18257e;

    /* renamed from: f */
    public String f18258f;

    /* renamed from: g */
    public Handler.Callback f18259g = new C3976a();

    /* renamed from: com.huawei.android.hicloud.ui.fragment.TempBackupRecordsBackupDeviceInfoFragment$a */
    public class C3976a implements Handler.Callback {
        public C3976a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 33055) {
                return false;
            }
            C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "refresh deviceRecordsAdapter");
            if (TempBackupRecordsBackupDeviceInfoFragment.this.f18257e == null) {
                return false;
            }
            TempBackupRecordsBackupDeviceInfoFragment.this.f18257e.notifyDataSetChanged();
            return false;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBaseFragment
    /* renamed from: a */
    public void mo24310a() {
        C0183y0 c0183y0 = new C0183y0(this.f18261a, this);
        this.f18257e = c0183y0;
        this.f18264d.setAdapter((ListAdapter) c0183y0);
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBaseFragment
    /* renamed from: b */
    public void mo24311b(View view) {
        if (R$id.backup_detail == view.getId()) {
            if (!C0209d.m1333z1(this.f18261a)) {
                C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "<onDeviceItemClick> net work is not connected.");
                return;
            }
            C0183y0.a aVar = (C0183y0.a) view.getTag();
            if (aVar == null) {
                C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "View has not holder.");
                return;
            }
            CloudBackupDeviceInfo cloudBackupDeviceInfo = (CloudBackupDeviceInfo) this.f18257e.getItem(aVar.m1057f());
            if (cloudBackupDeviceInfo == null) {
                C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "deviceListTempAdapter Adapter item is null, viewId: " + view.getId());
                return;
            }
            if (C12590s0.m75854g2(cloudBackupDeviceInfo.getRecoveryItems())) {
                C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "tempJump2BackupRecordsPage,recoveryItemList has one harmony record");
                m24312d(cloudBackupDeviceInfo);
            } else {
                C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "tempJump2BackupRecordsPage,recoveryItemList has zero harmony record");
                m24313e(cloudBackupDeviceInfo.getRecoveryItems().get(0));
            }
        }
    }

    /* renamed from: d */
    public final void m24312d(CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        if (cloudBackupDeviceInfo == null) {
            C11839m.m70687e("TempBackupRecordsCBSpaceDetailFragment", "jump2BackupRecordsPageByDetail error,backupRecord is null");
            return;
        }
        Intent intent = new Intent(this.f18261a, (Class<?>) CloudBackupRecordsActivity.class);
        intent.addFlags(65536);
        intent.putExtra("is_current_device", cloudBackupDeviceInfo.isCurrent());
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 1);
        intent.putExtra("backup_device_id", cloudBackupDeviceInfo.getBackupDeviceId());
        intent.putExtra("backup_device_category", cloudBackupDeviceInfo.getDeviceCategory());
        Bundle bundle = new Bundle();
        bundle.putParcelable("cloudBackupDeviceInfo", cloudBackupDeviceInfo);
        intent.putExtra(CommonPickerConstant.RequestParams.KEY_DEVICE_INFO, bundle);
        startActivityForResult(intent, PayStatusCodes.PAY_STATE_TIME_OUT);
    }

    /* renamed from: e */
    public final void m24313e(CloudRecoveryItem cloudRecoveryItem) {
        try {
            Intent intent = new Intent(this.f18261a, (Class<?>) CloudRestoreOptionsActivity.class);
            C13225d.m79490f1().m79585f0("mecloud_backupdetail_click_backup_restore", C13452e.m80781L().m80971t0());
            C13230i.m79525e1(intent, "1", "39");
            UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_click_backup_restore", "1", "39");
            intent.addFlags(65536);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_from_recovery", false);
            bundle.putInt(FamilyShareConstants.ENTRY_TYPE, 1);
            cloudRecoveryItem.setDeviceIdd(C11477c.m68636f(cloudRecoveryItem.getDeviceIdd()));
            bundle.putParcelable("backup_content_detail_list", cloudRecoveryItem);
            bundle.putString("entrance_of_restore", this.f18258f);
            bundle.putString("device_count", String.valueOf(1));
            bundle.putString("record_count", String.valueOf(1));
            bundle.putString("record_index", String.valueOf(1));
            bundle.putBoolean("new_version_flag", true);
            bundle.putInt("record_count_type_int", 1);
            intent.putExtra("isTempBackup", true);
            bundle.putBoolean("isNewBmRecord", cloudRecoveryItem.isNewBmRecord());
            intent.putExtras(bundle);
            intent.putExtra("backup_is_temp_backup_type", true);
            C0224k0.m1544N(getActivity(), intent, PayStatusCodes.PAY_STATE_PARAM_ERROR);
            getActivity().overridePendingTransition(0, 0);
        } catch (Exception e10) {
            C11839m.m70687e("TempBackupRecordsCBSpaceDetailFragment", " navToBackupContentDetail " + e10.getMessage());
        }
    }

    /* renamed from: f */
    public void m24314f(List<CloudBackupDeviceInfo> list) {
        if (this.f18257e == null) {
            C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "deviceListTempAdapter is null.");
            this.f18262b.setVisibility(8);
        } else if (AbstractC14026a.m84159a(list)) {
            C11839m.m70689w("TempBackupRecordsCBSpaceDetailFragment", "tempItemLinkedList is empty.");
            this.f18257e.m1049b();
            this.f18262b.setVisibility(8);
        } else {
            this.f18264d.setVisibility(0);
            this.f18262b.setVisibility(0);
            this.f18257e.m1049b();
            this.f18257e.m1048a(list);
            this.f18257e.notifyDataSetChanged();
        }
    }

    /* renamed from: g */
    public void m24315g(String str) {
        this.f18258f = str;
    }

    @Override // com.huawei.android.hicloud.p088ui.fragment.TempBackupRecordsBaseFragment, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C11839m.m70688i("TempBackupRecordsCBSpaceDetailFragment", "onCreateView: ");
        CloudBackupService.getInstance().register(this.f18259g);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f18259g != null) {
            CloudBackupService.getInstance().unregister(this.f18259g);
        }
    }
}
