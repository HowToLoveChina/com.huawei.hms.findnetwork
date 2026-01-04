package com.huawei.android.hicloud.cloudbackup.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.CloudRestoreOneModuleTask;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import dm.C9205f2;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import sl.C12816g;
import tl.C13029h;
import tl.C13030i;
import tl.C13035n;

/* loaded from: classes2.dex */
public class BackupRestoreControlService extends Service {
    private static final int CANCEL = 3;
    private static final int CONFLICT = 4;
    public static final String PACKAGE_NAME = "packagename";
    private static final int PAUSE = 1;
    public static final int RESUME = 2;
    private static final int RESUME_ALL = 5;
    private static final int START = 0;
    private static final String TAG = "BackupRestoreControlService";
    private RestoreMainActivity mainActivity;
    private C13035n statusOperator = new C13035n();
    private C12816g statusV3Operator = new C12816g();
    RestoreActivityBinder restoreActivityBinder = new RestoreActivityBinder();

    public class RestoreActivityBinder extends Binder {
        public RestoreActivityBinder() {
        }

        public void restore3rd(String str, boolean z10, RestoreMainActivity restoreMainActivity) {
            BackupRestoreControlService.this.restore3rdFromAct(str, z10, restoreMainActivity);
        }
    }

    private void cancelTasks(String str) {
        CloudBackupBaseTask moduleTask = CloudBackupTaskManager.getInstance().getModuleTask(str);
        if (moduleTask instanceof CloudRestoreOneModuleTask) {
            C11839m.m70688i(TAG, "cancel v2 module task");
            CloudRestoreOneModuleTask cloudRestoreOneModuleTask = (CloudRestoreOneModuleTask) moduleTask;
            cloudRestoreOneModuleTask.cancel();
            cloudRestoreOneModuleTask.cancel(false);
            return;
        }
        if (!(moduleTask instanceof C9205f2)) {
            C11839m.m70688i(TAG, "restore3rdCancel get CloudRestoreOneModuleTask from thread map null.");
            return;
        }
        C11839m.m70688i(TAG, "cancel v3 module task");
        C9205f2 c9205f2 = (C9205f2) moduleTask;
        c9205f2.cancel();
        c9205f2.cancel(false);
    }

    private boolean cannotCancel(CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (cloudRestoreStatusV3 != null) {
            return false;
        }
        int status = cloudRestoreStatusV3.getStatus();
        return status != 5 ? status == 6 || status == 7 || status == 8 : cloudRestoreStatusV3.getType() == 1;
    }

    private boolean checkTwinAppsInstallStatus(List<CloudRestoreStatusV3> list) {
        if (AbstractC14026a.m84159a(list) || list.size() < 2) {
            return false;
        }
        Iterator<CloudRestoreStatusV3> it = list.iterator();
        while (it.hasNext()) {
            if (cannotCancel(it.next())) {
                return true;
            }
        }
        return false;
    }

    private RestoreStatus getMainRestoreStatus(String str, List<String> list, List<CloudRestoreStatusV3> list2) {
        List<CloudRestoreStatusV3> listM76942f;
        if (!isV3Restore()) {
            return this.statusOperator.m78554f(str);
        }
        CloudRestoreStatusV3 cloudRestoreStatusV3M76947k = this.statusV3Operator.m76947k(str);
        try {
            listM76942f = this.statusV3Operator.m76942f(str);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "restore3rdResume query: " + str + " error: " + e10.getMessage());
            listM76942f = null;
        }
        if (listM76942f != null) {
            Iterator<CloudRestoreStatusV3> it = listM76942f.iterator();
            while (it.hasNext()) {
                list.add(it.next().m29468L());
            }
            list2.addAll(listM76942f);
        }
        List<CloudRestoreStatusV3> listM76949m = this.statusV3Operator.m76949m(str);
        if (listM76949m == null) {
            return cloudRestoreStatusV3M76947k;
        }
        Iterator<CloudRestoreStatusV3> it2 = listM76949m.iterator();
        while (it2.hasNext()) {
            list.add(it2.next().m29468L());
        }
        list2.addAll(listM76949m);
        return cloudRestoreStatusV3M76947k;
    }

    private boolean isV3Restore() {
        C13029h c13029hM78495f;
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "restore3rdPause tags is null, exception: " + e10.getMessage());
            c13029hM78495f = null;
        }
        if (c13029hM78495f == null) {
            C11839m.m70688i(TAG, "restore3rdPause tags is null");
            return false;
        }
        if (TextUtils.isEmpty(C12590s0.m75924y0(c13029hM78495f))) {
            C11839m.m70688i(TAG, "current is v2 restore");
            return false;
        }
        C11839m.m70688i(TAG, "current is v3 restore");
        return true;
    }

    private RestoreStatus queryRestoreStatus(boolean z10, String str) {
        if (!z10) {
            C11839m.m70688i(TAG, "resume v2 3rd module task");
            return this.statusOperator.m78554f(str);
        }
        C11839m.m70688i(TAG, "resume v3 3rd module task");
        List<CloudRestoreStatusV3> listM76951o = this.statusV3Operator.m76951o(str);
        if (listM76951o == null || listM76951o.size() <= 0) {
            return null;
        }
        return listM76951o.get(0);
    }

    private void restore3rdCancel(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        RestoreStatus mainRestoreStatus = getMainRestoreStatus(str, arrayList, arrayList2);
        if (mainRestoreStatus == null) {
            C11839m.m70689w(TAG, "restore3rdCancel query status null, appId: " + str);
            return;
        }
        arrayList.add(mainRestoreStatus.getAppId());
        if (!RestoreUtil.getRestoreStatus(this)) {
            C11839m.m70688i(TAG, "restore end, do not cancel");
            return;
        }
        if (checkTwinAppsInstallStatus(arrayList2)) {
            C11839m.m70688i(TAG, "already installing or installed, do not cancel");
            return;
        }
        int status = mainRestoreStatus.getStatus();
        int type = mainRestoreStatus.getType();
        C11839m.m70688i(TAG, "restore3rdCancel, status:" + status + ", type = " + type);
        if (status == 0 || status == 2 || status == 4 || status == 5) {
            if (status == 5 && type == 1) {
                C11839m.m70688i(TAG, "restore3rdCancel download success, do not cancel.");
            } else if ((status == 4 || status == 5) && type == 2) {
                C11839m.m70688i(TAG, "restore3rdCancel download failed, do not cancel.");
            } else {
                C11839m.m70688i(TAG, "restore3rdCancel update status to STATUS_CANCEL.");
                Iterator<CloudRestoreStatusV3> it = arrayList2.iterator();
                while (it.hasNext()) {
                    updateStatus(it.next(), 1);
                }
            }
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            cancelTasks(it2.next());
        }
    }

    private void restore3rdConflict(String str) {
        long versionCode = ICBUtil.getVersionCode(C0213f.m1377a().getPackageManager(), str);
        RestoreStatus mainRestoreStatus = getMainRestoreStatus(str, new ArrayList(), new ArrayList());
        if (mainRestoreStatus == null) {
            C11839m.m70689w(TAG, "restore3rdConflict query status null, appId: " + str);
            return;
        }
        if (mainRestoreStatus instanceof CloudRestoreStatusV3) {
            if (versionCode >= ((CloudRestoreStatusV3) mainRestoreStatus).getVersionCode()) {
                C11839m.m70689w(TAG, "restore3rdConflict app has installed V3");
                return;
            }
        } else if ((mainRestoreStatus instanceof CloudRestoreStatus) && versionCode >= ((CloudRestoreStatus) mainRestoreStatus).getVersionCode()) {
            C11839m.m70689w(TAG, "restore3rdConflict app has installed V2");
            return;
        }
        restore3rdCancel(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restore3rdFromAct(String str, boolean z10, RestoreMainActivity restoreMainActivity) {
        restore3rdResume(str, z10, restoreMainActivity);
        this.mainActivity = restoreMainActivity;
    }

    private void restore3rdPause(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (isV3Restore()) {
            restore3rdPauseV3(str);
        } else {
            restore3rdPauseV2(str);
        }
    }

    private void restore3rdPauseV2(String str) {
        CloudRestoreStatus cloudRestoreStatusM78554f = this.statusOperator.m78554f(str);
        if (cloudRestoreStatusM78554f == null) {
            C11839m.m70689w(TAG, "restore3rdPauseV2 query status null, appId: " + str);
            return;
        }
        C11839m.m70688i(TAG, "restore3rdPauseV2, appId = " + str + ", status = " + cloudRestoreStatusM78554f.getStatus());
        int status = cloudRestoreStatusM78554f.getStatus();
        if (status == 4 || status == 5) {
            CloudBackupBaseTask moduleTask = CloudBackupTaskManager.getInstance().getModuleTask(str);
            if (moduleTask instanceof CloudRestoreOneModuleTask) {
                CloudRestoreOneModuleTask cloudRestoreOneModuleTask = (CloudRestoreOneModuleTask) moduleTask;
                cloudRestoreOneModuleTask.pause();
                CloudBackupTaskManager.getInstance().removeModuleTask(str, cloudRestoreOneModuleTask);
                C11839m.m70688i(TAG, "restore3rdPauseV2, pause done, appId = " + str);
                this.statusOperator.m78558j(str, 2, 0);
            } else {
                C11839m.m70688i(TAG, "restore3rdPauseV2 get CloudRestoreOneModuleTask from thread map null.");
            }
            SystemClock.sleep(600L);
        }
    }

    private void restore3rdPauseV3(String str) {
        List<CloudRestoreStatusV3> listM76951o = this.statusV3Operator.m76951o(str);
        List<CloudRestoreStatusV3> listM76949m = this.statusV3Operator.m76949m(str);
        if (listM76949m != null) {
            listM76951o.addAll(listM76949m);
        }
        Iterator<CloudRestoreStatusV3> it = listM76951o.iterator();
        while (it.hasNext()) {
            restore3rdPauseV3(str, it.next());
        }
        SystemClock.sleep(600L);
    }

    private void restore3rdResume(String str, boolean z10, RestoreMainActivity restoreMainActivity) {
        RestoreStatus restoreStatusM78554f;
        boolean z11;
        RestoreStatus restoreStatus;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RestoreMainActivity restoreMainActivity2 = this.mainActivity;
        if (restoreMainActivity2 != null && restoreMainActivity2.m22049B2()) {
            boolean zIsV3Restore = isV3Restore();
            ICBBroadcastManager.send3rdStatusToLauncher(6, queryRestoreStatus(zIsV3Restore, str), zIsV3Restore, this);
            C11839m.m70688i(TAG, "restore3rdResume mainActivity isLoading = " + str);
            return;
        }
        if (C10782d.m65634a().m65645l() && z10 && C0209d.m1150A1(this) && !CBAccess.inRestoreTask()) {
            if (!C0209d.m1226Y0()) {
                Intent intent = new Intent(getBaseContext(), (Class<?>) RestoreMainActivity.class);
                intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                intent.putExtra("restore_app", str);
                intent.putExtra("is_form_service", true);
                startActivity(intent);
                return;
            }
            boolean zIsV3Restore2 = isV3Restore();
            ICBBroadcastManager.send3rdStatusToLauncher(6, queryRestoreStatus(zIsV3Restore2, str), zIsV3Restore2, this);
            C11839m.m70688i(TAG, "restore3rdResume isFastClick appId = " + str);
            return;
        }
        List<CloudRestoreStatusV3> arrayList = new ArrayList<>();
        if (isV3Restore()) {
            C11839m.m70688i(TAG, "resume v3 3rd module task");
            List<CloudRestoreStatusV3> listM76951o = this.statusV3Operator.m76951o(str);
            List<CloudRestoreStatusV3> listM76949m = this.statusV3Operator.m76949m(str);
            if (listM76951o == null || listM76951o.size() <= 0) {
                restoreStatus = null;
            } else {
                restoreStatus = listM76951o.get(0);
                arrayList.addAll(listM76951o);
            }
            if (listM76949m != null && listM76949m.size() > 0) {
                arrayList.addAll(listM76949m);
            }
            restoreStatusM78554f = restoreStatus;
            z11 = true;
        } else {
            C11839m.m70688i(TAG, "resume v2 3rd module task");
            restoreStatusM78554f = this.statusOperator.m78554f(str);
            z11 = false;
        }
        if (restoreStatusM78554f == null) {
            C11839m.m70689w(TAG, "restore3rdResume query main status null, appId: " + str);
            return;
        }
        if (!C10782d.m65634a().m65642i(this)) {
            Toast.makeText(this, C2783d.m16179s1(R$string.backup_no_wlan_restore_tip, R$string.backup_no_wifi_restore_tip), 0).show();
            ICBBroadcastManager.send3rdStatusToLauncher(6, restoreStatusM78554f, z11, this);
            return;
        }
        if (!CBAccess.isSupportResume(restoreStatusM78554f.getUid() == 0 ? restoreStatusM78554f.getAppId() : restoreStatusM78554f.getAppId() + restoreStatusM78554f.getUid())) {
            C11839m.m70688i(TAG, "restore3rdResume, resume unsupported, status = " + restoreStatusM78554f.getStatus());
            if (3 != restoreStatusM78554f.getStatus()) {
                ICBBroadcastManager.send3rdStatusToLauncher(6, restoreStatusM78554f, z11, this);
                return;
            }
            return;
        }
        int status = restoreStatusM78554f.getStatus();
        C11839m.m70688i(TAG, "restore3rdResume status = " + status);
        if (status == 2 || status == 3) {
            restore3rdResumeStart(restoreStatusM78554f, arrayList, z11);
            if (restoreMainActivity != null) {
                restoreMainActivity.m22103v3();
                return;
            }
            return;
        }
        if (status == 4 || status == 5 || status == 6) {
            if (CBAccess.inRestoreTask()) {
                return;
            }
            if (isV3Restore()) {
                for (CloudRestoreStatusV3 cloudRestoreStatusV3 : arrayList) {
                    this.statusV3Operator.m76959w(str, 2, cloudRestoreStatusV3.getUid(), 0, cloudRestoreStatusV3.getSubStatus());
                }
            } else {
                this.statusOperator.m78558j(str, 2, 0);
            }
            ICBBroadcastManager.send3rdStatusToLauncher(6, restoreStatusM78554f, z11, this);
        } else {
            Toast.makeText(this, C2783d.m16179s1(R$string.backup_no_wlan_restore_tip, R$string.backup_no_wifi_restore_tip), 0).show();
            ICBBroadcastManager.send3rdStatusToLauncher(6, restoreStatusM78554f, z11, this);
        }
    }

    private void restore3rdResumeAll() {
        C11839m.m70688i(TAG, "restore3rdResumeAll");
        if (!C10782d.m65634a().m65642i(this) && CBAccess.inBackup() && CBAccess.inRestore()) {
            C11839m.m70688i(TAG, "now inBackup or inRestore or noWifi, end.");
        } else if (isV3Restore()) {
            restore3rdResumeAllV3();
        } else {
            restore3rdResumeAllV2();
        }
    }

    private void restore3rdResumeAllV2() {
        List<CloudRestoreStatus> listM78553e = this.statusOperator.m78553e();
        if (listM78553e.isEmpty()) {
            C11839m.m70688i(TAG, "reports null, no need to resume, end.");
            return;
        }
        for (CloudRestoreStatus cloudRestoreStatus : listM78553e) {
            if (cloudRestoreStatus == null) {
                C11839m.m70689w(TAG, "restore3rdResumeAll status is null.");
            } else if (cloudRestoreStatus.getStatus() == 2) {
                this.statusOperator.m78557i(cloudRestoreStatus, 3, 0);
                ICBBroadcastManager.send3rdStatusToLauncher(0, cloudRestoreStatus, false, this);
            }
        }
        CloudBackupService.getInstance().restoreRetry(true, true, false);
    }

    private void restore3rdResumeAllV3() {
        List<CloudRestoreStatusV3> listM76946j = this.statusV3Operator.m76946j();
        if (listM76946j.isEmpty()) {
            C11839m.m70688i(TAG, "reports null, no need to resume, end.");
            return;
        }
        for (CloudRestoreStatusV3 cloudRestoreStatusV3 : listM76946j) {
            if (cloudRestoreStatusV3 == null) {
                C11839m.m70689w(TAG, "restore3rdResumeAll status is null.");
            } else if (cloudRestoreStatusV3.getStatus() == 2) {
                this.statusV3Operator.m76958v(cloudRestoreStatusV3, 3, 0);
                ICBBroadcastManager.send3rdStatusToLauncher(0, cloudRestoreStatusV3, true, this);
            }
        }
        CloudBackupService.getInstance().restoreRetryV3(true, true);
    }

    private void restore3rdResumeStart(RestoreStatus restoreStatus, List<CloudRestoreStatusV3> list, boolean z10) {
        if (z10) {
            Iterator<CloudRestoreStatusV3> it = list.iterator();
            while (it.hasNext()) {
                restore3rdResumeStart(it.next(), z10);
            }
        } else {
            restore3rdResumeStart(restoreStatus, z10);
        }
        if (CBAccess.inRestoreLast()) {
            SystemClock.sleep(100L);
            return;
        }
        C11839m.m70688i(TAG, "restore3rdResume, call restoreRetry do resume.");
        if (isV3Restore()) {
            CloudBackupService.getInstance().restoreRetryV3(true, true);
        } else {
            CloudBackupService.getInstance().restoreRetry(true, true, false);
        }
        SystemClock.sleep(300L);
    }

    private void restore3rdStart() {
        if (C10782d.m65634a().m65642i(this) && !CBAccess.inBackup()) {
            if (CBAccess.inRestoreFirst()) {
                CBAccess.setLauncherLayoutOk();
            } else {
                CBAccess.startRestoreLast();
            }
        }
    }

    private void updateStatus(RestoreStatus restoreStatus, int i10) {
        C11839m.m70686d(TAG, "update status appId = " + restoreStatus.getAppId() + " uid: " + restoreStatus.getUid() + " status = " + i10);
        restoreStatus.setStatus(i10).setType(0);
        if (isV3Restore()) {
            this.statusV3Operator.m76959w(restoreStatus.getAppId(), i10, restoreStatus.getUid(), 0, restoreStatus.getSubStatus());
        } else {
            this.statusOperator.m78558j(restoreStatus.getAppId(), i10, 0);
        }
        RestoreProgress.updateStatus(restoreStatus);
        List<RestoreStatus> listRestoreStatusList = CBAccess.restoreStatusList();
        if (listRestoreStatusList != null) {
            for (RestoreStatus restoreStatus2 : listRestoreStatusList) {
                if (restoreStatus.getAppId().equals(restoreStatus2.getAppId()) && restoreStatus.getUid() == restoreStatus2.getUid()) {
                    restoreStatus2.setStatus(i10).setType(0);
                    return;
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.restoreActivityBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        C11839m.m70688i(TAG, "receive msg from desk.");
        if (intent == null) {
            return 2;
        }
        try {
            String stringExtra = intent.getStringExtra(PACKAGE_NAME);
            int intExtra = intent.getIntExtra(CommonNotifyReceiver.COMMAND_KEY, 0);
            C11839m.m70688i(TAG, "appId:" + stringExtra + ", command:" + intExtra);
            if (CBAccess.isInRelease()) {
                C11839m.m70688i(TAG, "task in release.");
                return 2;
            }
            if (intExtra == 0) {
                restore3rdStart();
            } else if (intExtra == 1) {
                restore3rdPause(stringExtra);
            } else if (intExtra == 2) {
                restore3rdResume(stringExtra, true, null);
            } else if (intExtra == 3) {
                restore3rdCancel(stringExtra);
            } else if (intExtra == 4) {
                restore3rdConflict(stringExtra);
            } else if (intExtra == 5) {
                restore3rdResumeAll();
            }
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("appId", stringExtra);
            linkedHashMapM79499C.put(CommonNotifyReceiver.COMMAND_KEY, Integer.valueOf(intExtra));
            C13225d.m79490f1().m79603z0("restoring_lanucher_notify_event", linkedHashMapM79499C);
            return 2;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "get params from desk error:" + e10.getMessage());
            return super.onStartCommand(intent, i10, i11);
        }
    }

    private void restore3rdPauseV3(String str, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        if (cloudRestoreStatusV3 == null) {
            C11839m.m70689w(TAG, "restore3rdPauseV3 query status null, appId: " + str);
            return;
        }
        C11839m.m70688i(TAG, "restore3rdPauseV3, appId = " + cloudRestoreStatusV3.m29468L() + ", status = " + cloudRestoreStatusV3.getStatus());
        int status = cloudRestoreStatusV3.getStatus();
        if (status != 4 && status != 5) {
            if (cloudRestoreStatusV3.isTwinApp()) {
                updateStatus(cloudRestoreStatusV3, 2);
                return;
            }
            return;
        }
        CloudBackupBaseTask moduleTask = CloudBackupTaskManager.getInstance().getModuleTask(cloudRestoreStatusV3.m29468L());
        if (!(moduleTask instanceof C9205f2)) {
            C11839m.m70688i(TAG, "restore3rdPauseV3 get CloudRestoreV3ModuleDownload from thread map null.");
            return;
        }
        C9205f2 c9205f2 = (C9205f2) moduleTask;
        c9205f2.cancel(false);
        c9205f2.pause();
        CloudBackupTaskManager.getInstance().removeModuleTask(cloudRestoreStatusV3.m29468L(), c9205f2);
        C11839m.m70688i(TAG, "restore3rdPauseV3, pause done, moduleId = " + cloudRestoreStatusV3.m29468L());
        this.statusV3Operator.m76959w(str, 2, cloudRestoreStatusV3.getUid(), 0, cloudRestoreStatusV3.getSubStatus());
    }

    private void restore3rdResumeStart(RestoreStatus restoreStatus, boolean z10) {
        updateStatus(restoreStatus, 3);
        ICBBroadcastManager.send3rdStatusToLauncher(0, restoreStatus, z10, this);
        C11839m.m70688i(TAG, "restore3rdResume, inRestoreLast do resume.");
        if (CBAccess.inRestoreLast()) {
            try {
                restoreStatus.setStatus(0).setType(0);
                RestoreProgress.updateStatus(restoreStatus);
                CBAccess.appRestoreResume(restoreStatus.getAppId(), restoreStatus.getUid());
            } catch (Exception e10) {
                updateStatus(restoreStatus, 2);
                ICBBroadcastManager.send3rdStatusToLauncher(6, restoreStatus, z10, this);
                C11839m.m70689w(TAG, "restore3rdResume, restore resume error." + e10.toString());
            }
        }
    }
}
