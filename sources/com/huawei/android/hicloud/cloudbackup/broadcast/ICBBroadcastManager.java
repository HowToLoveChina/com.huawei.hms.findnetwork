package com.huawei.android.hicloud.cloudbackup.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.service.BackupRestoreControlService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p618rm.C12591s1;
import p664u0.C13108a;
import p711vl.C13466f;
import sl.C12816g;
import tl.C13035n;

/* loaded from: classes2.dex */
public class ICBBroadcastManager {
    public static final String MYHUAWEI_PACKAGE = "com.huawei.phoneservice";
    private static final String MYHUAWEI_PERMISSION = "com.huawei.phoneservice.permission.ACCESS";
    private static final String PERMISSION = "com.huawei.hidisk.permission.cloudbackup";
    private static final String TAG = "ICBBroadcastManager";
    private static CloudBackupReceiver receiver = new CloudBackupReceiver();
    private static AtomicBoolean isRegister = new AtomicBoolean(false);
    private static AtomicBoolean isExitAccount = new AtomicBoolean(false);

    public static class DelayClearIcon extends AbstractC12369f {
        private Context context;

        /* JADX WARN: Illegal instructions before constructor call */
        public DelayClearIcon(int i10, Context context) {
            long j10 = i10;
            super(j10, j10);
            this.context = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ICBBroadcastManager.sendCancelRestoreBroadcast(this.context);
            cancel();
        }
    }

    public static AtomicBoolean getIsExitAccount() {
        return isExitAccount;
    }

    private static void makeBackupStateBundle(Context context) {
        isExitAccount.set(true);
        Bundle bundle = new Bundle();
        bundle.putString("broadCastType", CloudBackupConstant.Command.PMS_CMD_BACKUP);
        bundle.putInt("backupStatus", -1);
        C13466f.m81073d().m81084l("broadcast_backupId", "");
        C11839m.m70688i(TAG, "backup cancel status:" + bundle.getInt("backupStatus"));
        sendBackupRestoreStateToMyHW(context, bundle);
    }

    private static void makeRestoreStateBundle(Context context) {
        isExitAccount.set(true);
        Bundle bundle = new Bundle();
        bundle.putString("broadCastType", "restore");
        bundle.putInt("restoreStatus", -2);
        C13466f.m81073d().m81084l("broadcast_restoreId", "");
        C11839m.m70688i(TAG, "restore cancel status:" + bundle.getInt("restoreStatus"));
        sendBackupRestoreStateToMyHW(context, bundle);
    }

    public static void registerBroadcastReceiver(Context context) {
        if (context == null) {
            C11839m.m70688i(TAG, "registerBroadcastReceiver context is null");
            return;
        }
        if (isRegister.compareAndSet(false, true)) {
            C11839m.m70688i(TAG, "registerBroadcastReceiver");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS");
            intentFilter.addAction("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_CHANGE");
            C13108a.m78878b(context).m78880c(receiver, intentFilter);
        }
    }

    public static void send3rdStatusToLauncher(int i10, RestoreStatus restoreStatus, boolean z10, Context context) {
        if (restoreStatus == null) {
            C11839m.m70687e(TAG, "send3rdStatusToLauncher restoreStatus is null");
            return;
        }
        C11839m.m70688i(TAG, "sendLauncher3rdStatus, appId = " + restoreStatus.getAppId() + ", launcher status = " + i10);
        Bundle bundle = new Bundle();
        bundle.putString("name_", restoreStatus.getAppName());
        bundle.putInt("status_", i10);
        if (!z10) {
            bundle.putString("packageName_", restoreStatus.getAppId());
            sendServiceDownloadBroadcast(context, bundle);
        } else {
            if (restoreStatus instanceof CloudRestoreStatusV3) {
                bundle.putString("packageName_", ((CloudRestoreStatusV3) restoreStatus).m29470M());
            } else {
                bundle.putString("packageName_", restoreStatus.getAppId());
            }
            sendServiceDownloadBroadcastV3(context, bundle, restoreStatus);
        }
    }

    public static void sendBackupRestoreEnd(Context context) {
        SafeIntent safeIntent = new SafeIntent(new Intent());
        safeIntent.setAction("com.huawei.hicloud.backup.end.refresh.clear.cache");
        C13108a.m78878b(context).m78881d(safeIntent);
    }

    private static void sendBackupRestoreStateToMyHW(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(BroadcastConstants.CLOUD_BACKUP_RESTORE_STATE_ACTION);
        C0209d.m1302r2(intent, MYHUAWEI_PACKAGE);
        intent.putExtras(bundle);
        context.sendBroadcast(intent, MYHUAWEI_PERMISSION);
        C11839m.m70688i(TAG, "sendBackupRestoreStateToMyHW");
    }

    public static void sendCancelCloudBackupStateBroadcast(int i10, String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast，context is null.");
            return;
        }
        if (C12591s1.m75931a().m75943m()) {
            sendCancelCloudBackupStateBroadcast2(i10);
            return;
        }
        if (!CloudBackupStateUtil.checkBroadcastId(i10, str)) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast not send broadcast.");
            return;
        }
        Cursor cursorQueryRestoreState = null;
        try {
            try {
                if (i10 == 1) {
                    cursorQueryRestoreState = CloudBackupStateUtil.getInstance().queryBackupState(new String[]{str});
                    if (cursorQueryRestoreState == null) {
                        if (cursorQueryRestoreState != null) {
                            cursorQueryRestoreState.close();
                            return;
                        }
                        return;
                    }
                    cursorQueryRestoreState.moveToFirst();
                    makeBackupStateBundle(contextM1377a);
                } else {
                    cursorQueryRestoreState = CloudBackupStateUtil.getInstance().queryRestoreState(new String[]{str});
                    if (cursorQueryRestoreState == null) {
                        if (cursorQueryRestoreState != null) {
                            cursorQueryRestoreState.close();
                            return;
                        }
                        return;
                    }
                    cursorQueryRestoreState.moveToFirst();
                    makeRestoreStateBundle(contextM1377a);
                }
            } catch (Exception e10) {
                C11839m.m70687e(TAG, "sendCancelCloudBackupStateBroadcast exception: " + e10.toString());
                if (cursorQueryRestoreState == null) {
                    return;
                }
            }
            cursorQueryRestoreState.close();
        } catch (Throwable th2) {
            if (cursorQueryRestoreState != null) {
                cursorQueryRestoreState.close();
            }
            throw th2;
        }
    }

    public static void sendCancelCloudBackupStateBroadcast2(int i10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast，context is null.");
            return;
        }
        try {
            if (i10 == 1) {
                makeBackupStateBundle(contextM1377a);
            } else {
                makeRestoreStateBundle(contextM1377a);
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "sendCancelCloudBackupStateBroadcast2 exception: " + e10.toString());
        }
    }

    public static void sendCancelRestoreBroadcast(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(BroadcastConstants.RESTORE_CANCEL_ACTION);
        context.sendBroadcast(intent, PERMISSION);
        C11839m.m70688i(TAG, "sendCancelRestoreBroadcast");
    }

    public static void sendCloudBackupPrepareState() {
        isExitAccount.set(false);
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast，context is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("broadCastType", CloudBackupConstant.Command.PMS_CMD_BACKUP);
        bundle.putInt("backupState", 0);
        bundle.putInt(VastAttribute.PROGRESS, 0);
        C11839m.m70688i(TAG, "backup Status:" + bundle.getInt("backupStatus"));
        sendBackupRestoreStateToMyHW(contextM1377a, bundle);
    }

    public static void sendCloudBackupStateBroadcast(int i10, String str, boolean z10) {
        if (isExitAccount.get()) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast, isExitAccount return ");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast，context is null.");
            return;
        }
        Bundle bundleQueryBackupRestoreState = CloudBackupStateUtil.getInstance().queryBackupRestoreState(i10, str);
        if (bundleQueryBackupRestoreState == null) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast bundle is null.");
            return;
        }
        if (i10 == 1) {
            if (z10) {
                bundleQueryBackupRestoreState.putInt("backupStatus", 0);
            }
            C11839m.m70688i(TAG, "backup Status:" + bundleQueryBackupRestoreState.getInt("backupStatus") + ", progress: " + bundleQueryBackupRestoreState.getInt(VastAttribute.PROGRESS) + ", broadCastType: " + i10);
        } else {
            int i11 = bundleQueryBackupRestoreState.getInt("restoreStatus");
            if (i11 == -2 || i11 == 1) {
                C13466f.m81073d().m81084l("broadcast_restoreId", "");
            }
            C11839m.m70688i(TAG, "restore Status:" + i11 + ", broadCastType: " + i10);
        }
        if (isExitAccount.get()) {
            C11839m.m70688i(TAG, "sendCloudBackupStateBroadcast, isExitAccount return ");
        } else {
            sendBackupRestoreStateToMyHW(contextM1377a, bundleQueryBackupRestoreState);
        }
    }

    public static void sendDelayCancelRestoreBroadcast(Context context, int i10) {
        C11839m.m70688i(TAG, "sendDelayCancelRestoreBroadcast delay = " + i10);
        C12515a.m75110o().m75172d(new DelayClearIcon(i10, context));
    }

    public static void sendDownloadEventBroadcast(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(BroadcastConstants.DOWNLOAD_EVENT_ACTION);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("DownloadTask", bundle);
        intent.putExtras(bundle2);
        context.sendBroadcast(intent, PERMISSION);
        C11839m.m70688i(TAG, "sendDownloadEventBroadcast");
    }

    public static void sendInstallEventBroadcast(Context context, String str, int i10) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BackupRestoreControlService.PACKAGE_NAME, str);
        bundle.putInt("status", i10);
        Intent intent = new Intent();
        intent.setAction(BroadcastConstants.INSTALL_EVENT_ACTION);
        intent.putExtras(bundle);
        context.sendBroadcast(intent, PERMISSION);
        C11839m.m70688i(TAG, "sendInstallEventBroadcast，packagename: " + str + " | status: " + i10);
    }

    private static void sendServiceDownloadBroadcast(Context context, Bundle bundle) {
        if (context == null || bundle == null || !bundle.containsKey("packageName_")) {
            return;
        }
        CloudRestoreStatus cloudRestoreStatusM78554f = new C13035n().m78554f(bundle.getString("packageName_"));
        if (cloudRestoreStatusM78554f == null) {
            C11839m.m70686d(TAG, "invalid report!");
        } else if (cloudRestoreStatusM78554f.m29526N() == 0) {
            C11839m.m70686d(TAG, "cant launch, do not notify!");
        } else {
            sendDownloadEventBroadcast(context, bundle);
            C11839m.m70688i(TAG, "sendServiceDownloadBroadcast");
        }
    }

    private static void sendServiceDownloadBroadcastV3(Context context, Bundle bundle, RestoreStatus restoreStatus) {
        if (context == null || bundle == null || restoreStatus == null || !bundle.containsKey("packageName_")) {
            return;
        }
        CloudRestoreStatusV3 cloudRestoreStatusV3M76948l = new C12816g().m76948l(restoreStatus.getAppId(), restoreStatus.getUid());
        if (cloudRestoreStatusV3M76948l == null) {
            C11839m.m70686d(TAG, "invalid report!");
        } else if (cloudRestoreStatusV3M76948l.m29455A() == 0) {
            C11839m.m70686d(TAG, "cant launch, do not notify!");
        } else {
            sendDownloadEventBroadcast(context, bundle);
            C11839m.m70688i(TAG, "sendServiceDownloadBroadcast");
        }
    }

    public static void setIsExitAccount(AtomicBoolean atomicBoolean) {
        isExitAccount = atomicBoolean;
    }

    public static void unRegisterBroadcastReceiver(Context context) {
        if (!isRegister.compareAndSet(true, false) || receiver == null) {
            return;
        }
        C11839m.m70688i(TAG, "unRegisterBroadcastReceiver");
        C13108a.m78878b(context).m78883f(receiver);
    }

    public static void unrestrictedCloudStateBroadcast() {
        isExitAccount.set(false);
    }
}
