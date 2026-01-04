package com.huawei.android.hicloud.p088ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.model.RestoreCache;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p514o9.C11839m;
import p848zl.C14333b;

/* loaded from: classes3.dex */
public abstract class CloudBaseRestoreOptionsActivity extends CloudBackupBaseUiActivity {

    /* renamed from: D */
    public CloudRecoveryItem f14175D;

    /* renamed from: E */
    public int f14176E;

    /* renamed from: G */
    public boolean f14178G;

    /* renamed from: H */
    public boolean f14179H;

    /* renamed from: I */
    public boolean f14180I;

    /* renamed from: J */
    public boolean f14181J;

    /* renamed from: C */
    public String f14174C = getClass().getSimpleName();

    /* renamed from: F */
    public String f14177F = "";

    /* renamed from: K */
    public final Handler.Callback f14182K = new Handler.Callback() { // from class: com.huawei.android.hicloud.ui.activity.e3
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f17595a.m19628W1(message);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W1 */
    public /* synthetic */ boolean m19628W1(Message message) {
        if (message.what == 33001) {
            mo19634a2((String) message.obj);
            return false;
        }
        mo19632Y1(message);
        return false;
    }

    /* renamed from: U1 */
    public LinkedHashMap m19629U1() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem == null) {
            return linkedHashMap;
        }
        String backupId = cloudRecoveryItem.getBackupId();
        String recordDeviceId = this.f14175D.getRecordDeviceId();
        String backupDeviceId = this.f14175D.getBackupDeviceId();
        linkedHashMap.put("backupId", backupId);
        linkedHashMap.put("deviceID", recordDeviceId);
        linkedHashMap.put(CloudBackupConstant.BACKUP_DEVICE_ID, backupDeviceId);
        linkedHashMap.put("entryType", String.valueOf(this.f14176E));
        if (this.f14176E == 2) {
            linkedHashMap.put("entranceOfRestore", this.f14177F);
        }
        return linkedHashMap;
    }

    /* renamed from: V1 */
    public LinkedHashMap m19630V1(boolean z10) {
        LinkedHashMap linkedHashMapM19629U1 = m19629U1();
        if (z10) {
            linkedHashMapM19629U1.put("status", "1");
        } else {
            linkedHashMapM19629U1.put("status", "2");
        }
        CloudRecoveryItem cloudRecoveryItem = this.f14175D;
        if (cloudRecoveryItem != null) {
            linkedHashMapM19629U1.put("is_refurbish", Boolean.valueOf(cloudRecoveryItem.isRefurbishment()));
        }
        return linkedHashMapM19629U1;
    }

    /* renamed from: X1 */
    public void m19631X1(Bundle bundle) {
        if (bundle != null) {
            C11839m.m70686d(this.f14174C, "onRestoreData ");
            this.f14178G = true;
            int i10 = bundle.getInt("save_cache_index");
            String string = bundle.getString("save_cache_entry", "2");
            ArrayList<CloudRestoreItem> parcelableArrayList = bundle.getParcelableArrayList("save_cache_list");
            this.f14179H = bundle.getBoolean("save_show_sync_gallery");
            this.f14180I = bundle.getBoolean("save_compatible_phone");
            RestoreCache.getInstance().setIndex(i10);
            RestoreCache.getInstance().setItemList(parcelableArrayList);
            RestoreCache.getInstance().setEntranceOfRestore(string);
        }
    }

    /* renamed from: Y1 */
    public void mo19632Y1(Message message) {
    }

    /* renamed from: Z1 */
    public void m19633Z1(List<CloudRestoreItem> list) {
        for (CloudRestoreItem cloudRestoreItem : list) {
            String appId = cloudRestoreItem.getAppId();
            if (C14333b.m85486u().containsKey(appId)) {
                cloudRestoreItem.setAppName(C2783d.m16079E(this, appId));
            }
        }
    }

    /* renamed from: a2 */
    public abstract void mo19634a2(String str);

    /* renamed from: b2 */
    public void m19635b2(CloudRestoreItem cloudRestoreItem) {
        List<CloudRestoreItem> listM29202r;
        boolean z10;
        if (cloudRestoreItem == null || (listM29202r = cloudRestoreItem.m29202r()) == null || listM29202r.isEmpty()) {
            return;
        }
        boolean z11 = true;
        loop0: while (true) {
            for (CloudRestoreItem cloudRestoreItem2 : listM29202r) {
                z11 = cloudRestoreItem2.getAction() == 0 && z11;
                z10 = cloudRestoreItem2.getAction() != 2 || z10;
            }
        }
        if (z11) {
            cloudRestoreItem.setAction(0);
        } else {
            cloudRestoreItem.setAction(z10 ? 1 : 2);
        }
        cloudRestoreItem.m29182J0();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.CloudBackupBaseUiActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        C11839m.m70688i(this.f14174C, "onCreate");
        this.f14178G = false;
        this.f14179H = false;
        this.f14180I = true;
        m19631X1(bundle);
        super.onCreate(bundle);
        this.f14177F = RestoreCache.getInstance().getEntranceOfRestore();
        CBCallBack.getInstance().registerCallback(this.f14182K);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CBCallBack.getInstance().unregisterCallback(this.f14182K);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            C11839m.m70686d(this.f14174C, "onSaveInstanceState");
            bundle.putParcelableArrayList("save_cache_list", RestoreCache.getInstance().getItemList());
            bundle.putInt("save_cache_index", RestoreCache.getInstance().getIndex());
            bundle.putString("save_cache_entry", RestoreCache.getInstance().getEntranceOfRestore());
            bundle.putBoolean("save_show_sync_gallery", this.f14179H);
            bundle.putBoolean("save_compatible_phone", this.f14180I);
        } catch (Exception e10) {
            C11839m.m70687e(this.f14174C, "onSaveInstanceState  fail==" + e10.toString());
        }
        super.onSaveInstanceState(bundle);
    }
}
