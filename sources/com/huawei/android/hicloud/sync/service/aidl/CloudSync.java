package com.huawei.android.hicloud.sync.service.aidl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Messenger;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.android.hicloud.sync.contact.ContactManager;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.android.hicloud.task.frame.RequestDispatcher;
import com.huawei.hicloud.notification.HiCloudNotification;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import gp.C10028c;
import je.C10800n;
import md.C11440c;
import md.C11442e;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p609rc.C12487a;
import p709vj.C13452e;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CloudSync {
    private static final CloudSync CLOUD_DISK_INSTANCE = new CloudSync();
    private static final String TAG = "CloudSync";
    private Context appContext = C0213f.m1377a();
    private RequestDispatcher mDispatcher = new RequestDispatcher(this.appContext);
    private C10028c settingMgr;
    protected SharedPreferences syncSharedPre;

    private CloudSync() {
        C12487a.m74966b(this.appContext.getApplicationContext());
        this.settingMgr = C10028c.m62183d0(this.appContext);
        this.syncSharedPre = C0214f0.m1382b(this.appContext, "sync_contact_spfile", 0);
    }

    private int checkContactSyncCondition(int i10) {
        if (C13843a.m83073Y(this.appContext)) {
            C11839m.m70687e(TAG, "doAutoSyncContact: isSupportSyncAbility is false");
            SyncObserverServiceInvoker.getInstance().startContactSyncWithAIDL(this.appContext, i10, "");
            return -4;
        }
        if (!C0209d.m1208S0(this.appContext)) {
            C11839m.m70689w(TAG, "network is not available");
            processNetNotConnected("addressbook");
            if (!C11829c.m70611r0()) {
                SharedPreferences.Editor editorEdit = this.syncSharedPre.edit();
                editorEdit.putBoolean("addressbooknotAllSucess", true);
                editorEdit.commit();
                C12338d.m74195s().m74241o0();
                C12338d.m74195s().m74216T();
            }
            return -4;
        }
        if (CloudSyncUtil.m16019j0("addressbook")) {
            C11839m.m70688i(TAG, "contact is in restoring");
            return -4;
        }
        if (CloudSyncUtil.m15965N() == 1) {
            C11839m.m70689w(TAG, "Server Control Reset");
            return -13;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70689w(TAG, "Sync Risk");
            return FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
        }
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70689w(TAG, "Local ST invalid flag is true");
            return 2001;
        }
        if (10 == i10) {
            int i11 = this.syncSharedPre.getInt("addressbooksync_retcode", -1);
            boolean z10 = this.syncSharedPre.getBoolean("addressbooknotAllSucess", false);
            C11839m.m70686d(TAG, "isLastSyncFail = " + z10 + ", lastSyncState = " + i11);
            if (z10 && 14 == i11) {
                C11839m.m70688i(TAG, "last sync fail and network change, but last sync status is exceed.");
                return -4;
            }
        }
        ContactManager contactManager = new ContactManager(this.appContext);
        if ((6 != i10 && 9 != i10) || contactManager.m17210M() || contactManager.m17211N()) {
            return 0;
        }
        C11839m.m70688i(TAG, "local contact or group not changed.");
        return -4;
    }

    private int checkWlanSyncCondition(SyncType syncType) {
        if (!C0209d.m1208S0(this.appContext)) {
            C11839m.m70689w(TAG, "network is not available");
            processNetNotConnected("wlan");
            if (!C11829c.m70611r0()) {
                SharedPreferences.Editor editorEdit = this.syncSharedPre.edit();
                editorEdit.putBoolean("wlannotAllSucess", true);
                editorEdit.commit();
                CloudSyncUtil.m16014h1("wlannotAllSucess", String.valueOf(5));
                C12338d.m74195s().m74241o0();
                C12338d.m74195s().m74216T();
            }
            return -4;
        }
        if (CloudSyncUtil.m16019j0("wlan")) {
            C11839m.m70688i(TAG, "wlan is in restoring");
            return -4;
        }
        if (CloudSyncUtil.m15965N() == 1) {
            C11839m.m70689w(TAG, "Server Control Reset");
            return -13;
        }
        if (C13452e.m80781L().m80927i1()) {
            C11839m.m70689w(TAG, "Sync Risk");
            return FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
        }
        if (C13452e.m80781L().m80917g1()) {
            C11839m.m70689w(TAG, "Local ST invalid flag is true");
            return 2001;
        }
        if (10 != syncType.getBiReportType() || this.syncSharedPre.getBoolean("wlannotAllSucess", false)) {
            return 0;
        }
        C11839m.m70688i(TAG, "last sync fail and network change, but sync status is success.");
        return -4;
    }

    public static CloudSync getInstance() {
        return CLOUD_DISK_INSTANCE;
    }

    private void processNetNotConnected(String str) {
        SharedPreferences.Editor editorEdit = this.syncSharedPre.edit();
        editorEdit.putInt(str + "sync_retcode", 19);
        editorEdit.commit();
        if ("addressbook".equals(str)) {
            CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", "addressbook");
        } else if ("wlan".equals(str)) {
            CloudSyncUtil.m15972Q0("com.huawei.hicloud.action.UI_NOTIFY_SYNC_END", "wlan");
        }
    }

    public int doAutoSyncContact(SyncType syncType) {
        if (syncType == null) {
            syncType = SyncType.COMMON_SYNC;
        }
        C11839m.m70688i(TAG, "doAutoSyncContact type: " + syncType.getBiReportType());
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "not login, ignore sync");
            return -4;
        }
        int iCheckContactSyncCondition = checkContactSyncCondition(syncType.getBiReportType());
        if (iCheckContactSyncCondition != 0) {
            return iCheckContactSyncCondition;
        }
        if (!C11829c.m70611r0()) {
            C2986o.m17946c(this.appContext, "com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
        }
        boolean zM62388s = this.settingMgr.m62388s("addressbook");
        boolean zM68534l = C11440c.m68534l("addressbook");
        C11839m.m70688i(TAG, "doAutoSyncContact: isBackupOn = " + zM62388s + ", hasSyncTask = " + zM68534l);
        if (zM62388s && !zM68534l) {
            C10800n c10800n = new C10800n();
            c10800n.m65743h("BackupModuleArray", new String[]{"addressbook"});
            c10800n.m65743h("synctype", syncType);
            c10800n.m65743h("synauto", Boolean.FALSE);
            c10800n.m65743h("sync_report_end_info", new ReportSyncEndInfo());
            this.mDispatcher.m18035b(new C11442e(55000004, c10800n), "addressbook");
            HiCloudNotification.getInstance().executeFromDataUse();
        }
        return -4;
    }

    public int doAutoSyncWlan(SyncType syncType) {
        if (syncType == null) {
            syncType = SyncType.WlanSyncType.COMMON_SYNC;
        }
        C11839m.m70688i(TAG, "doAutoSyncWlan type: " + syncType.getBiReportType());
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e(TAG, "not login, ignore sync");
            return -4;
        }
        int iCheckWlanSyncCondition = checkWlanSyncCondition(syncType);
        if (iCheckWlanSyncCondition != 0) {
            return iCheckWlanSyncCondition;
        }
        if (!C11829c.m70611r0()) {
            C2986o.m17946c(this.appContext, "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
        }
        boolean zM62388s = this.settingMgr.m62388s("wlan");
        boolean zM68534l = C11440c.m68534l("wlan");
        C11839m.m70688i(TAG, "doAutoSyncWlan: isBackupOn = " + zM62388s + ", hasSyncTask = " + zM68534l);
        if (zM62388s && !zM68534l) {
            C10800n c10800n = new C10800n();
            c10800n.m65743h("BackupModuleArray", new String[]{"wlan"});
            c10800n.m65743h("synctype", Integer.valueOf(syncType.getSyncType()));
            c10800n.m65743h("synauto", Boolean.FALSE);
            c10800n.m65743h("sync_report_end_info", new ReportSyncEndInfo());
            this.mDispatcher.m18035b(new C11442e(55000005, c10800n), "wlan");
            HiCloudNotification.getInstance().executeFromDataUse();
        }
        return -4;
    }

    public void register(Messenger messenger, int i10) {
        this.mDispatcher.m18037e(messenger, i10);
    }
}
