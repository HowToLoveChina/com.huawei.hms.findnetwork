package com.huawei.android.hicloud.cloudbackup.service;

import am.C0257c1;
import am.C0258d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.cloudbackup.bean.CBState;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CloudBackupCheckTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.task.BackupSingleTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetBackupRecordsNumTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetLastOneWeekAutoBackupTimesTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetNextBackupTimesTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetOptionsInfoFromCloneTask;
import com.huawei.android.hicloud.cloudbackup.process.task.GetWaitBackupTimesTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupSwitchBmChanger;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.service.C4877a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.util.GeneralRedirectUtil;
import com.huawei.hicloud.request.basic.bean.CBSAllDevicesRsp;
import com.huawei.hicloud.request.basic.bean.CBSSyncRecordDeviceInfo;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import com.huawei.hicloud.request.opengw.bean.LsRequest;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import gp.C10028c;
import il.C10542o;
import io.C10582a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import p015ak.C0206b0;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0241z;
import p020ap.C1007b;
import p020ap.C1008c;
import p292fn.C9733f;
import p336he.C10155f;
import p429kk.C11058a;
import p429kk.C11060c;
import p458lo.C11322a;
import p495nm.C11727h;
import p514o9.C11839m;
import p572qb.C12299b;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12600v1;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p684un.C13225d;
import p703v8.C13367d;
import p709vj.C13452e;
import p711vl.C13465e;
import p711vl.C13466f;
import p744wl.C13617a;
import p744wl.C13619c;
import p746wn.C13622a;
import p780xm.InterfaceC13829a;
import p814yl.C13998b0;
import p815ym.AbstractC14026a;
import p847zk.C14315h;
import p847zk.C14317j;
import p847zk.C14329v;
import p848zl.C14339h;
import pm.C12176c;
import sl.C12816g;
import tj.C13019a;
import tl.C13026e;
import tl.C13029h;
import tl.C13030i;
import tl.C13035n;
import tl.C13036o;
import tm.C13040c;
import to.C13049a;
import vn.C13471c;

/* loaded from: classes2.dex */
public class CloudBackupService implements ICloudBackupService {
    private static final int CMD_CLOUDSPACE_DETAIL = 10;
    private static final int CMD_DELETE_DEVICE_BACKUP_RECORDS = 21;
    private static final int CMD_DELETE_DEVICE_RECORDS_AND_CLOSE_BACKUP = 26;
    private static final int CMD_DELETE_RECORDS = 9;
    private static final int CMD_DELETE_SINGLE_RECORD = 16;
    private static final int CMD_DELETE_SINGLE_TEMP_BACKUP_RECORDS = 28;
    private static final int CMD_QUERY_BACKUPRESTORE = 18;
    private static final int CMD_QUERY_CURRENT_RECORD = 25;
    private static final int CMD_QUERY_LAST_RECORD_TIME = 23;
    private static final int CMD_QUERY_USER_BACKUP_INFO = 27;
    private static final int CMD_SHOW_BACKUP_TIMES = 15;
    private static final int CMD_SHOW_RECORDS = 7;
    private static final int CMD_SHOW_REPORTS = 11;
    private static final int CMD_SHOW_V3_RECORDS_DETAILS = 24;
    private static final int CMD_UPDATE_SHOWTAG = 19;
    private static final String TAG = "CloudBackupService";
    private static CloudBackupService mCbService = new CloudBackupService();
    private static final Object REFRESH_SWITCH_STATUS_LOCK = new Object();
    private volatile Handler mHandler = null;
    private volatile HandlerThread mThread = null;
    private boolean isDeletingDeviceRecord = false;
    private final ReadWriteLock deleteFlagRWLock = new ReentrantReadWriteLock();
    private final C12526j backupConfigOperator = new C12526j();

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$1 */
    public class C26681 extends AbstractC12367d {
        final /* synthetic */ String val$bakId;
        final /* synthetic */ String val$from;

        public C26681(String str, String str2) {
            str = str;
            str = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13998b0 c13998b0 = new C13998b0();
            try {
                C11839m.m70688i(CloudBackupService.TAG, "deleteSingleFromServer: " + str);
                c13998b0.m84130a0("backupDeviceIdV1V2", str, CBSBaseReq.CURRENT_API_VERSION, C11058a.m66627b("02007"), str);
            } catch (C9721b e10) {
                C11839m.m70689w(CloudBackupService.TAG, "server delete error: " + e10);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$10 */
    public class C266910 extends AbstractC12367d {
        final /* synthetic */ int val$deleteReportEntry;

        public C266910(int i10) {
            i = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v3, types: [int] */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Message messageObtain = Message.obtain();
            C11839m.m70686d(CloudBackupService.TAG, "deleteAllBaseAppModule");
            messageObtain.what = 33045;
            messageObtain.arg2 = i;
            String message = "0";
            String strM66627b = null;
            try {
                try {
                    C13998b0 c13998b0 = new C13998b0();
                    strM66627b = C11058a.m66627b("02109");
                    c13998b0.m84129Z("backupDeviceIdV1V2", strM66627b);
                    CloudBackupService.this.handleDeleteBaseAppSuccess(messageObtain);
                    messageObtain.arg1 = 0;
                } catch (C9721b e10) {
                    message = e10.getMessage();
                    C11839m.m70688i(CloudBackupService.TAG, "deleteAllBaseAppModule e " + message);
                    CloudBackupService.trasferDeleteError(e10, messageObtain, String.valueOf(e10.m60663g()));
                } catch (Exception e11) {
                    message = e11.getMessage();
                    C11839m.m70688i(CloudBackupService.TAG, "deleteAllBaseAppModule Exception " + message);
                    messageObtain.arg1 = 2;
                }
            } finally {
                CBCallBack.getInstance().sendMessage(messageObtain);
                CloudBackupReport.reportDeleteBaseAppModule(message, i, strM66627b);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$2 */
    public class C26702 extends AbstractC12367d {
        public C26702() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i(CloudBackupService.TAG, "get cloudBackup state start.");
            CBState cBState = new CBState();
            if (CBAccess.inBackup()) {
                int iM80916g0 = C13452e.m80781L().m80916g0();
                boolean zIsInTempBackup = CBAccess.isInTempBackup();
                C11839m.m70688i(CloudBackupService.TAG, "get cloudBackup restoreStatus = " + iM80916g0 + " ,inTempBackup: " + zIsInTempBackup);
                if (iM80916g0 != 3 && !zIsInTempBackup) {
                    C13452e.m80781L().m80890b();
                    RestoreNotification.getInstance().cancelNotification();
                    ICBBroadcastManager.sendCancelRestoreBroadcast(C0213f.m1377a());
                    C13452e.m80781L().m80909e3(0.0f);
                }
                cBState.setStatus(1);
            }
            if (CBAccess.inRestore()) {
                cBState.setStatus(2);
            }
            int iInRestorePaused = CBAccess.inRestorePaused();
            if (iInRestorePaused > 0) {
                cBState.setStatus(3);
                cBState.setAmount(iInRestorePaused);
            }
            cBState.setState(CBAccess.getState());
            if (cBState.getStatus() == 0) {
                CloudBackupService.this.getLastSuccessTime(cBState);
            }
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 32308, cBState));
            C11839m.m70688i(CloudBackupService.TAG, "get cloudBackup state end, status = " + cBState.getStatus() + ", state = " + cBState.getState());
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$3 */
    public class C26713 extends AbstractC12367d {
        final /* synthetic */ boolean val$isMain;

        public C26713(boolean z10) {
            z = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            CloudBackupService.this.queryLastRecord(z);
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$4 */
    public class C26724 extends AbstractC12367d {
        final /* synthetic */ List val$latestList;
        final /* synthetic */ List val$oldestList;

        public C26724(List list, List list2) {
            list = list;
            list = list2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                CloudBackupService.this.checkRecordsCompatibility(list);
                CloudBackupService.this.checkRecordsCompatibility(list);
                Message messageObtain = Message.obtain();
                messageObtain.what = 33052;
                messageObtain.arg1 = 0;
                C11839m.m70688i(CloudBackupService.TAG, "queryRecordsCompatibility success ");
                CBCallBack.getInstance().sendMessage(messageObtain);
            } catch (C9721b e10) {
                C11839m.m70687e(CloudBackupService.TAG, "checkRecordsCompatibility error: " + e10.toString());
                CBCallBack.getInstance().sendMessage(Message.obtain(null, 33052, 1, e10.m60659c()));
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$5 */
    public class HandlerC26735 extends Handler {
        public HandlerC26735(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            CloudBackupService.this.processGetCmd(message);
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$6 */
    public class C26746 extends AbstractC12367d {
        final /* synthetic */ Bundle val$bundleTemp;

        public C26746(Bundle bundle) {
            bundle = bundle;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String strM66627b = C11058a.m66627b("02026");
            String str = "backup_delete_report_entry : " + bundle.getInt("backup_delete_report_entry", 0);
            C11839m.m70688i(CloudBackupService.TAG, "deleteSingleTempRecord start");
            try {
                try {
                    try {
                        String string = bundle.getString(CloudBackupConstant.BACKUP_DEVICE_ID);
                        boolean z10 = bundle.getBoolean("isCurrent", false);
                        new C13998b0().m84127X(string, strM66627b, 1, 0, "3");
                        if (z10) {
                            CloudBackupService.this.cancelTempBackup("delete_single_from_view");
                        }
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 33047;
                        messageObtain.arg1 = 0;
                        CBCallBack.getInstance().sendMessage(messageObtain);
                    } catch (C9721b e10) {
                        C11839m.m70689w(CloudBackupService.TAG, "deleteSingleTempRecordRaw server delete error: " + e10.getMessage());
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.what = 33047;
                        messageObtain2.arg1 = 1;
                        messageObtain2.arg2 = e10.m60663g();
                        CBCallBack.getInstance().sendMessage(messageObtain2);
                        CloudBackupReport.reportTempDeviceDelete(strM66627b, str + e10.getMessage(), String.valueOf(e10.m60659c()));
                    }
                } catch (Exception e11) {
                    C11839m.m70689w(CloudBackupService.TAG, "deleteSingleTempRecordRaw Exception " + e11.getMessage());
                    Message messageObtain3 = Message.obtain();
                    messageObtain3.what = 33047;
                    messageObtain3.arg1 = 3;
                    CBCallBack.getInstance().sendMessage(messageObtain3);
                }
                CloudBackupReport.reportTempDeviceDelete(strM66627b, str, "200");
                C11839m.m70688i(CloudBackupService.TAG, "deleteSingleTempRecord end");
            } catch (Throwable th2) {
                CloudBackupReport.reportTempDeviceDelete(strM66627b, str, "200");
                C11839m.m70688i(CloudBackupService.TAG, "deleteSingleTempRecord end");
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$7 */
    public class C26757 extends BackupSingleTask {
        final /* synthetic */ boolean val$isRefreshUI;

        public C26757(boolean z10) {
            z = z10;
        }

        @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupSingleTask
        public void execute() throws C9721b {
            C12515a.m75110o().m75165a1(this);
            if (CBAccess.inBackup()) {
                C11839m.m70688i(CloudBackupService.TAG, "refreshSwitchStatusAsync is backuping");
            } else {
                CloudBackupService.this.refreshSwitchStatusSync(z, null);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$8 */
    public class C26768 extends AbstractC12367d {
        final /* synthetic */ boolean val$isRefresh;

        public C26768(boolean z10) {
            z = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11839m.m70688i(CloudBackupService.TAG, "refreshGradeWhiteBusinessModel");
            Message messageObtain = Message.obtain();
            messageObtain.what = 33044;
            if (!C0209d.m1333z1(CloudBackupService.getContext())) {
                messageObtain.arg1 = 1;
                CBCallBack.getInstance().sendMessage(messageObtain);
                return;
            }
            BackupSwitchBmChanger backupSwitchBmChanger = new BackupSwitchBmChanger(false, true, null);
            messageObtain.what = z ? 33017 : 33044;
            messageObtain.arg1 = 8;
            messageObtain.obj = backupSwitchBmChanger;
            CBCallBack.getInstance().sendMessage(messageObtain);
            C11839m.m70688i(CloudBackupService.TAG, "refreshGradeWhiteBusinessModel end");
        }
    }

    /* renamed from: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService$9 */
    public class C26779 extends AbstractC12367d {
        final /* synthetic */ InterfaceC13829a val$closeResult;

        public C26779(InterfaceC13829a interfaceC13829a) {
            this.val$closeResult = interfaceC13829a;
        }

        public static /* synthetic */ void lambda$call$0() {
            CloudBackupService.getInstance().cancelRefurbish();
        }

        public static /* synthetic */ void lambda$call$1(boolean z10, InterfaceC13829a interfaceC13829a) {
            interfaceC13829a.accept(Boolean.valueOf(z10));
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final boolean zM75941k = C12591s1.m75931a().m75941k();
            C11839m.m70688i(CloudBackupService.TAG, "closeBackupAfterConfirm check mIsRefurbish " + zM75941k);
            if (zM75941k) {
                C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.cloudbackup.service.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        CloudBackupService.C26779.lambda$call$0();
                    }
                });
            }
            Optional.ofNullable(this.val$closeResult).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.service.j
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CloudBackupService.C26779.lambda$call$1(zM75941k, (InterfaceC13829a) obj);
                }
            });
        }
    }

    public static class CloseSwitchTask extends AbstractC12368e {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i(CloudBackupService.TAG, "closeSwitchTask");
            try {
                C13225d.m79490f1().m79601y0(new SettingOperator().queryinitopentime(), new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78754r());
            } catch (C9721b e10) {
                C11839m.m70688i(CloudBackupService.TAG, "reportCloseBackup error: " + e10.toString());
            }
        }
    }

    public static class DeleteLocalRecordCacheTask extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (CBAccess.inBackup()) {
                C11839m.m70688i(CloudBackupService.TAG, "DeleteLocalRecordCacheTask is backuping");
            } else {
                C13617a.m81921c(CloudBackupService.getContext(), !CBAccess.hasValidTempBackup());
            }
        }
    }

    public static class GetBackupLearnAboutUrlTask extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78659m;
            try {
                strM78659m = C13040c.m78609F().m78659m();
            } catch (C9721b e10) {
                C11839m.m70687e(CloudBackupService.TAG, "GetLearnAboutBackupUrl error " + e10.toString());
                strM78659m = "";
            }
            Message messageObtain = Message.obtain();
            messageObtain.obj = strM78659m;
            messageObtain.what = 3210;
            CBCallBack.getInstance().sendMessage(messageObtain);
        }
    }

    public static class GetBackupLinkAddressTask extends AbstractC12367d {
        private final int cmd;

        public GetBackupLinkAddressTask(int i10) {
            this.cmd = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78625Q;
            try {
                strM78625Q = C13040c.m78609F().m78625Q();
            } catch (C9721b e10) {
                C11839m.m70689w(CloudBackupService.TAG, "queryAgreementUrl = " + e10);
                strM78625Q = null;
            }
            if (TextUtils.isEmpty(strM78625Q)) {
                strM78625Q = "";
            }
            String str = (strM78625Q + (C10155f.m63293q(500L) ? "/cloudbackupN" : "/cloudbackup") + "?lang=") + C12590s0.m75852g0();
            Message messageObtain = Message.obtain();
            messageObtain.what = this.cmd;
            messageObtain.obj = str;
            CBCallBack.getInstance().sendMessage(messageObtain);
        }
    }

    public static class QueryCloudSpaceByServer extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            Object objM80181d;
            int i10;
            Message messageObtain = Message.obtain();
            messageObtain.what = 33043;
            if (C0209d.m1333z1(CloudBackupService.getContext())) {
                objM80181d = C13367d.m80180e().m80181d();
                i10 = objM80181d == null ? 5 : 6;
            } else {
                objM80181d = null;
                i10 = 4;
            }
            messageObtain.arg1 = i10;
            messageObtain.obj = objM80181d;
            CBCallBack.getInstance().sendMessage(messageObtain);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("QueryCloudSpaceByServer , cloudSpace = ");
            if (objM80181d == null) {
                objM80181d = "";
            }
            sb2.append(objM80181d);
            C11839m.m70688i(CloudBackupService.TAG, sb2.toString());
        }
    }

    private CloudBackupService() {
    }

    private void abortBackupTask() {
        BackupNotification.getInstance().cancelBackupNotification();
        getInstance().abort(1001);
        CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33031));
    }

    private void backupRecordsSort(Map<String, CloudBackupDeviceInfo> map, boolean z10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<Map.Entry<String, CloudBackupDeviceInfo>> it = map.entrySet().iterator();
        CloudRecoveryItem cloudRecoveryItem = null;
        while (it.hasNext()) {
            List<CloudRecoveryItem> recoveryItems = it.next().getValue().getRecoveryItems();
            if (recoveryItems != null && recoveryItems.size() > 0) {
                Collections.sort(recoveryItems);
                int i10 = 0;
                boolean z11 = false;
                for (CloudRecoveryItem cloudRecoveryItem2 : recoveryItems) {
                    cloudRecoveryItem2.setIndex(i10);
                    if (cloudRecoveryItem2.isTempBackup()) {
                        arrayList5.add(cloudRecoveryItem2);
                    } else {
                        if (cloudRecoveryItem == null && cloudRecoveryItem2.isCurrent() && !cloudRecoveryItem2.isRefurbishment()) {
                            cloudRecoveryItem = cloudRecoveryItem2;
                        }
                        if (C13452e.m80781L().m80887a1() && cloudRecoveryItem2.isRefurbishment()) {
                            arrayList4.add(cloudRecoveryItem2);
                        } else if (cloudRecoveryItem2.isCurrent()) {
                            if (cloudRecoveryItem2.isBackupCompleted() && !z11) {
                                arrayList3.add(cloudRecoveryItem2);
                                z11 = true;
                            } else if (cloudRecoveryItem2.isBackupCompleted()) {
                                arrayList2.add(cloudRecoveryItem2);
                            } else {
                                arrayList3.add(cloudRecoveryItem2);
                            }
                            if (!C9733f.m60705z().m60720O("cloudBackupDeviceNameManagement")) {
                                cloudRecoveryItem2.setDevDisplayName(C0209d.m1171G());
                            }
                        } else if (cloudRecoveryItem2.isBackupCompleted() && !z11) {
                            arrayList.add(cloudRecoveryItem2);
                            z11 = true;
                        } else if (cloudRecoveryItem2.isBackupCompleted()) {
                            arrayList2.add(cloudRecoveryItem2);
                        } else {
                            arrayList.add(cloudRecoveryItem2);
                        }
                        i10++;
                    }
                }
            }
        }
        ArrayList arrayList6 = new ArrayList();
        if (arrayList3.size() > 0) {
            arrayList6.addAll(arrayList3);
        }
        Collections.sort(arrayList);
        arrayList6.addAll(arrayList);
        Collections.sort(arrayList2);
        dealCurrentLatesRecord(cloudRecoveryItem);
        sendResult(arrayList6, arrayList2, arrayList4, arrayList5, z10);
    }

    private static void checkAndAbortBackup(boolean z10) throws C9721b {
        if (z10) {
            if (CBAccess.inBackup() || CBAccess.inRestore()) {
                C11839m.m70688i(TAG, "checkAndAbortBackup");
                throw new C9721b(3912, 4291, "is backup or restore");
            }
        }
    }

    public void checkRecordsCompatibility(List<CloudRecoveryItem> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean zM60720O = C9733f.m60705z().m60720O("supportNext2HmosRestore");
        for (CloudRecoveryItem cloudRecoveryItem : list) {
            C11839m.m70688i(TAG, "checkRecordsCompatibility start " + cloudRecoveryItem.getBackupRecordLabel() + "; support next restore: " + zM60720O);
            if (cloudRecoveryItem.getBackupRecordLabel() == 3 && zM60720O) {
                if (TextUtils.isEmpty(cloudRecoveryItem.getBackupDeviceId()) || TextUtils.isEmpty(cloudRecoveryItem.getBackupId())) {
                    C11839m.m70687e(TAG, "checkRecordsCompatibility backupDeviceId or backupId is empty");
                    throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "backupDeviceId or backupId is empty");
                }
                CloudRecoveryItem cloudRecoveryItemQueryV3RecordAppInfosFromServer = getInstance().queryV3RecordAppInfosFromServer(cloudRecoveryItem.getBackupDeviceId(), cloudRecoveryItem.getBackupId(), false, false, cloudRecoveryItem.isNewBmRecord(), true);
                C11839m.m70688i(TAG, "checkRecordsCompatibility end, Compatibility: " + cloudRecoveryItemQueryV3RecordAppInfosFromServer.getModuleCompatibility());
                cloudRecoveryItem.setModuleCompatibility(cloudRecoveryItemQueryV3RecordAppInfosFromServer.getModuleCompatibility());
            }
        }
    }

    private void checkRetryTimeIsExpired(C13030i c13030i, C13029h c13029h, boolean z10) {
        int i10;
        if (isRestoreRetryTimeExpires(c13029h, C13452e.m80781L().m80916g0())) {
            C11839m.m70688i(TAG, "timeout, enter restore tasks status clean");
            c13029h.m78477r0(4);
            c13030i.m78496g(c13029h);
            CloudRestoreClient cloudRestoreClient = new CloudRestoreClient();
            if (z10) {
                List<CloudRestoreStatusV3> listM76946j = new C12816g().m76946j();
                i10 = RestoreUtil.isAllModulesRestoreFailed(listM76946j) ? 5 : 3;
                C13452e.m80781L().m80914f3(i10);
                cloudRestoreClient.refreshStatusV3(i10, listM76946j, new C12816g(), null);
            } else {
                C13035n c13035n = new C13035n();
                List<CloudRestoreStatus> listM78553e = c13035n.m78553e();
                i10 = RestoreUtil.isAllModulesRestoreFailed(listM78553e) ? 5 : 3;
                C13452e.m80781L().m80914f3(i10);
                cloudRestoreClient.refreshStatus(i10, listM78553e, c13035n, null);
            }
            CBAccess.clearRestoreCacheAsync(false);
            RestoreProgress.clearCache();
            RestoreNotification.getInstance().cancelNotification();
        }
    }

    private void clearServerSwitch(String str, List<String> list, C13998b0 c13998b0, String str2) {
        if (list.isEmpty()) {
            return;
        }
        C11839m.m70688i(TAG, "clearServerSwitch start");
        if (c13998b0 == null) {
            c13998b0 = new C13998b0();
        }
        try {
            c13998b0.m84124U(str2, list, str);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "clearAppsSwitch error: " + e10.getMessage());
        }
        C11839m.m70688i(TAG, "clearServerSwitch end");
    }

    private void dealCurrentLatesRecord(CloudRecoveryItem cloudRecoveryItem) {
        long jM81058g = C13465e.m81052f().m81058g("lastRecordTime", 0L);
        if (cloudRecoveryItem == null) {
            C13465e.m81052f().m81065n("lastRecordTime", 0L);
            C13465e.m81052f().m81065n("currentDeviceBackupedDataSize", 0L);
        } else {
            if (!cloudRecoveryItem.isBackupCompleted() || jM81058g == cloudRecoveryItem.getBackupEndTime()) {
                return;
            }
            C13465e.m81052f().m81065n("lastRecordTime", cloudRecoveryItem.getBackupEndTime());
        }
    }

    private void deleteByModules(String str, boolean z10) {
        if (C10028c.m62182c0().m62420y1()) {
            deleteByModulesNormal(str, z10);
        } else {
            deleteByModulesEncrypt(str, z10);
        }
    }

    private void deleteByModulesEncrypt(String str, boolean z10) {
        if (C1008c.m6035v().m6040E(getDiskModule(str))) {
            return;
        }
        try {
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
            ArrayList arrayList = new ArrayList();
            if ("record".equals(str)) {
                arrayList.add("/RecordBackup");
            } else if ("notepad".equals(str)) {
                arrayList.add("/NoteSync");
            } else if ("phonemanager".equals(str)) {
                arrayList.add("/BlockedBackup");
            }
            deleteCloudData(str, z10, c13049a, arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "delete record by deviceId failed." + e10.getMessage());
            Message message = new Message();
            message.what = 32309;
            message.arg1 = -1;
            CBCallBack.getInstance().sendMessage(message);
        }
    }

    private void deleteByModulesNormal(String str, boolean z10) {
        if (C1008c.m6035v().m6040E(getDiskModule(str))) {
            return;
        }
        try {
            C13049a c13049a = new C13049a(EnumC12999a.CLOUD_MORE, null);
            LsRequest lsRequest = new LsRequest();
            lsRequest.setServerPath("/Hicloud");
            lsRequest.setFields(new String[]{"name"});
            lsRequest.setType(2);
            lsRequest.setRecursive(1);
            List<Map<String, Object>> listM78718T = c13049a.m78718T(lsRequest);
            ArrayList arrayList = new ArrayList();
            for (Map<String, Object> map : listM78718T) {
                if ("record".equals(str)) {
                    arrayList.add("/Hicloud/" + map.get("name") + "/media/recording");
                } else if ("notepad".equals(str)) {
                    String str2 = "/Hicloud/" + map.get("name") + "/sysdata/notepad.db";
                    String str3 = "/Hicloud/" + map.get("name") + "/sysdata/notepadRes.zip";
                    arrayList.add(str2);
                    arrayList.add(str3);
                } else if ("phonemanager".equals(str)) {
                    arrayList.add("/Hicloud/" + map.get("name") + "/sysdata/phonemanager.db");
                }
            }
            deleteCloudData(str, z10, c13049a, arrayList);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "delete record by deviceId failed." + e10.getMessage());
            Message message = new Message();
            message.what = 32309;
            message.arg1 = -1;
            CBCallBack.getInstance().sendMessage(message);
        }
    }

    private void deleteCloudData(String str, boolean z10, C13049a c13049a, List<String> list) throws C9721b {
        int errCode;
        if ("notepad".equals(str) && z10) {
            String strM81958d = C13622a.m81958d("03006");
            C1008c.m6035v().m6068d(getContext(), "pimds.drop.note", "notepad");
            C11839m.m70688i(TAG, "clear cloud notepad data code = -1, traceId = " + strM81958d);
        }
        Result resultM78736f0 = c13049a.m78736f0((String[]) list.toArray(new String[list.size()]), false);
        boolean z11 = true;
        String errMsg = "";
        if (resultM78736f0.getFailList().isEmpty()) {
            errCode = 0;
        } else {
            errCode = 0;
            for (Result.ErrMsg errMsg2 : resultM78736f0.getFailList()) {
                errMsg = errMsg2.getErrMsg();
                errCode = errMsg2.getErrCode();
                if (errCode != 102 && errCode != 401) {
                    z11 = false;
                }
            }
        }
        C11839m.m70688i(TAG, "delete result = " + z11 + ",  module = " + str + ", errorCode = " + errCode + ", erroMsg = " + errMsg);
        Message message = new Message();
        message.what = 32309;
        if ("notepad".equals(str) && z10) {
            syncByHand(-1);
        }
        message.arg1 = z11 ? 0 : -1;
        message.arg2 = -1;
        CBCallBack.getInstance().sendMessage(message);
    }

    private void deleteDeviceRecordRaw(Bundle bundle) throws Throwable {
        String string;
        String string2;
        String str;
        boolean z10;
        int i10;
        boolean z11;
        boolean z12;
        LinkedHashMap<String, String> linkedHashMap;
        C13225d c13225dM79490f1;
        String str2;
        String str3 = "cloudbackup_device_delete_result";
        String str4 = "";
        if (bundle == null) {
            C11839m.m70688i(TAG, "deleteDeviceRecordRaw deviceBundle is null.");
            return;
        }
        C11839m.m70688i(TAG, "delete device record by deviceId deviceType start.");
        boolean z13 = bundle.getBoolean("delete_from_backup_card_switch", false);
        try {
            setDeviceDeletingFlag(z13, true);
            checkAndAbortBackup(z13);
            string2 = bundle.getString("deviceId");
        } catch (C9721b e10) {
            e = e10;
            str = "";
            string2 = "";
        } catch (Throwable th2) {
            th = th2;
            string = "";
            str4 = string;
            string2 = str4;
        }
        try {
            String string3 = bundle.getString(CloudBackupConstant.BACKUP_DEVICE_ID);
            String string4 = bundle.getString(GeneralRedirectUtil.BAK_ID);
            int i11 = bundle.getInt("sendPush", 0);
            i10 = bundle.getInt("backup_delete_report_entry", 0);
            try {
                String strM66627b = C11058a.m66627b("02007");
                try {
                    new C13998b0().m84127X(string3, strM66627b, 1, i11, null);
                    str = "";
                    try {
                        C11839m.m70688i(TAG, "delete device record success.");
                        new C13036o().m78561a(string3, string4);
                        Message message = new Message();
                        if (z13) {
                            setDeviceDeletingFlag(true, false);
                            closeCloudBackup();
                            afterCloseCloudBackup(getContext(), null);
                        }
                        message.what = 32309;
                        message.setData(bundle);
                        message.arg1 = 0;
                        CBCallBack.getInstance().sendMessage(message);
                        str2 = "delete device record success, deviceId: " + string2 + " ,deleteEntry: " + i10;
                    } catch (C9721b e11) {
                        e = e11;
                        str4 = strM66627b;
                        z11 = false;
                        try {
                            StringBuilder sb2 = new StringBuilder();
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            sb2.append("delete device record failed.");
                            sb2.append(e.getMessage());
                            C11839m.m70689w(TAG, sb2.toString());
                            Message message2 = new Message();
                            message2.what = 32309;
                            trasferDeleteError(e, message2, String.valueOf(e.m60663g()));
                            message2.setData(bundle);
                            string = e.toString();
                        } catch (Throwable th4) {
                            th = th4;
                            str3 = "cloudbackup_device_delete_result";
                            z12 = z11;
                            string = str;
                            z10 = false;
                            setDeviceDeletingFlag(z13, z10);
                            LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                            linkedHashMap2.put("transId", str4);
                            linkedHashMap2.put("deviceId", String.valueOf(string2));
                            linkedHashMap2.put("errorReason", string);
                            linkedHashMap2.put("deleteReportEntry", String.valueOf(i10));
                            linkedHashMap2.put("isSuccess", String.valueOf(z12));
                            C13225d.m79490f1().m79603z0(str3, linkedHashMap2);
                            throw th;
                        }
                        try {
                            setDeviceDeletingFlag(z13, false);
                            CBCallBack.getInstance().sendMessage(message2);
                            setDeviceDeletingFlag(z13, false);
                            linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.put("transId", str4);
                            linkedHashMap.put("deviceId", String.valueOf(string2));
                            linkedHashMap.put("errorReason", string);
                            linkedHashMap.put("deleteReportEntry", String.valueOf(i10));
                            linkedHashMap.put("isSuccess", String.valueOf(z11));
                            c13225dM79490f1 = C13225d.m79490f1();
                            str3 = "cloudbackup_device_delete_result";
                            c13225dM79490f1.m79603z0(str3, linkedHashMap);
                        } catch (Throwable th5) {
                            th = th5;
                            str3 = "cloudbackup_device_delete_result";
                            z12 = z11;
                            z10 = false;
                            setDeviceDeletingFlag(z13, z10);
                            LinkedHashMap<String, String> linkedHashMap22 = new LinkedHashMap<>();
                            linkedHashMap22.put("transId", str4);
                            linkedHashMap22.put("deviceId", String.valueOf(string2));
                            linkedHashMap22.put("errorReason", string);
                            linkedHashMap22.put("deleteReportEntry", String.valueOf(i10));
                            linkedHashMap22.put("isSuccess", String.valueOf(z12));
                            C13225d.m79490f1().m79603z0(str3, linkedHashMap22);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        str4 = strM66627b;
                        string = str;
                        z10 = false;
                        z12 = false;
                        setDeviceDeletingFlag(z13, z10);
                        LinkedHashMap<String, String> linkedHashMap222 = new LinkedHashMap<>();
                        linkedHashMap222.put("transId", str4);
                        linkedHashMap222.put("deviceId", String.valueOf(string2));
                        linkedHashMap222.put("errorReason", string);
                        linkedHashMap222.put("deleteReportEntry", String.valueOf(i10));
                        linkedHashMap222.put("isSuccess", String.valueOf(z12));
                        C13225d.m79490f1().m79603z0(str3, linkedHashMap222);
                        throw th;
                    }
                    try {
                        reportEvent(strM66627b, "deletedeviceRecord", str2);
                        deleteLocalCache(string2);
                        setDeviceDeletingFlag(z13, false);
                        linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.put("transId", strM66627b);
                        linkedHashMap.put("deviceId", String.valueOf(string2));
                        linkedHashMap.put("errorReason", str2);
                        linkedHashMap.put("deleteReportEntry", String.valueOf(i10));
                        linkedHashMap.put("isSuccess", String.valueOf(true));
                        c13225dM79490f1 = C13225d.m79490f1();
                    } catch (C9721b e12) {
                        e = e12;
                        z11 = true;
                        str = str2;
                        str4 = strM66627b;
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("delete device record failed.");
                        sb22.append(e.getMessage());
                        C11839m.m70689w(TAG, sb22.toString());
                        Message message22 = new Message();
                        message22.what = 32309;
                        trasferDeleteError(e, message22, String.valueOf(e.m60663g()));
                        message22.setData(bundle);
                        string = e.toString();
                        setDeviceDeletingFlag(z13, false);
                        CBCallBack.getInstance().sendMessage(message22);
                        setDeviceDeletingFlag(z13, false);
                        linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.put("transId", str4);
                        linkedHashMap.put("deviceId", String.valueOf(string2));
                        linkedHashMap.put("errorReason", string);
                        linkedHashMap.put("deleteReportEntry", String.valueOf(i10));
                        linkedHashMap.put("isSuccess", String.valueOf(z11));
                        c13225dM79490f1 = C13225d.m79490f1();
                        str3 = "cloudbackup_device_delete_result";
                        c13225dM79490f1.m79603z0(str3, linkedHashMap);
                    } catch (Throwable th7) {
                        th = th7;
                        z11 = true;
                        string = str2;
                        str4 = strM66627b;
                        z12 = z11;
                        z10 = false;
                        setDeviceDeletingFlag(z13, z10);
                        LinkedHashMap<String, String> linkedHashMap2222 = new LinkedHashMap<>();
                        linkedHashMap2222.put("transId", str4);
                        linkedHashMap2222.put("deviceId", String.valueOf(string2));
                        linkedHashMap2222.put("errorReason", string);
                        linkedHashMap2222.put("deleteReportEntry", String.valueOf(i10));
                        linkedHashMap2222.put("isSuccess", String.valueOf(z12));
                        C13225d.m79490f1().m79603z0(str3, linkedHashMap2222);
                        throw th;
                    }
                } catch (C9721b e13) {
                    e = e13;
                    str = "";
                } catch (Throwable th8) {
                    th = th8;
                    str = "";
                }
            } catch (C9721b e14) {
                e = e14;
                str = "";
            } catch (Throwable th9) {
                th = th9;
                string = "";
                str4 = string;
            }
        } catch (C9721b e15) {
            e = e15;
            str = "";
            z11 = false;
            i10 = 0;
            StringBuilder sb222 = new StringBuilder();
            sb222.append("delete device record failed.");
            sb222.append(e.getMessage());
            C11839m.m70689w(TAG, sb222.toString());
            Message message222 = new Message();
            message222.what = 32309;
            trasferDeleteError(e, message222, String.valueOf(e.m60663g()));
            message222.setData(bundle);
            string = e.toString();
            setDeviceDeletingFlag(z13, false);
            CBCallBack.getInstance().sendMessage(message222);
            setDeviceDeletingFlag(z13, false);
            linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("transId", str4);
            linkedHashMap.put("deviceId", String.valueOf(string2));
            linkedHashMap.put("errorReason", string);
            linkedHashMap.put("deleteReportEntry", String.valueOf(i10));
            linkedHashMap.put("isSuccess", String.valueOf(z11));
            c13225dM79490f1 = C13225d.m79490f1();
            str3 = "cloudbackup_device_delete_result";
            c13225dM79490f1.m79603z0(str3, linkedHashMap);
        } catch (Throwable th10) {
            th = th10;
            string = "";
            str4 = string;
            z10 = false;
            i10 = 0;
            z12 = false;
            setDeviceDeletingFlag(z13, z10);
            LinkedHashMap<String, String> linkedHashMap22222 = new LinkedHashMap<>();
            linkedHashMap22222.put("transId", str4);
            linkedHashMap22222.put("deviceId", String.valueOf(string2));
            linkedHashMap22222.put("errorReason", string);
            linkedHashMap22222.put("deleteReportEntry", String.valueOf(i10));
            linkedHashMap22222.put("isSuccess", String.valueOf(z12));
            C13225d.m79490f1().m79603z0(str3, linkedHashMap22222);
            throw th;
        }
        c13225dM79490f1.m79603z0(str3, linkedHashMap);
    }

    private static void deleteSingleFromServer(String str, String str2) {
        if (CBAccess.deleteTempSingleBak(str)) {
            return;
        }
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.1
            final /* synthetic */ String val$bakId;
            final /* synthetic */ String val$from;

            public C26681(String str3, String str22) {
                str = str3;
                str = str22;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                C13998b0 c13998b0 = new C13998b0();
                try {
                    C11839m.m70688i(CloudBackupService.TAG, "deleteSingleFromServer: " + str);
                    c13998b0.m84130a0("backupDeviceIdV1V2", str, CBSBaseReq.CURRENT_API_VERSION, C11058a.m66627b("02007"), str);
                } catch (C9721b e10) {
                    C11839m.m70689w(CloudBackupService.TAG, "server delete error: " + e10);
                }
            }
        });
    }

    private void deleteSingleRecordRaw(String str, String str2, int i10) {
        C11839m.m70688i(TAG, "delete single record by deviceId backupId start.");
        try {
            String strM66627b = C11058a.m66627b("02007");
            new C11322a(strM66627b).m68032p(str, i10, str2);
            C11839m.m70688i(TAG, "delete single record success.");
            Message message = new Message();
            message.what = 32333;
            message.arg1 = 0;
            CBCallBack.getInstance().sendMessage(message);
            reportEvent(strM66627b, "deleteSingleRecord", "delete single record success, backupid: " + str2);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "delete single record failed." + e10.getMessage());
            Message message2 = new Message();
            message2.what = 32333;
            if (3107 == e10.m60659c() && e10.m60663g() == 603) {
                message2.arg1 = 1;
            } else {
                message2.arg1 = 2;
            }
            CBCallBack.getInstance().sendMessage(message2);
        }
    }

    private void deleteSingleTempRecordRaw(Bundle bundle) {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.6
            final /* synthetic */ Bundle val$bundleTemp;

            public C26746(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                String strM66627b = C11058a.m66627b("02026");
                String str = "backup_delete_report_entry : " + bundle.getInt("backup_delete_report_entry", 0);
                C11839m.m70688i(CloudBackupService.TAG, "deleteSingleTempRecord start");
                try {
                    try {
                        try {
                            String string = bundle.getString(CloudBackupConstant.BACKUP_DEVICE_ID);
                            boolean z10 = bundle.getBoolean("isCurrent", false);
                            new C13998b0().m84127X(string, strM66627b, 1, 0, "3");
                            if (z10) {
                                CloudBackupService.this.cancelTempBackup("delete_single_from_view");
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 33047;
                            messageObtain.arg1 = 0;
                            CBCallBack.getInstance().sendMessage(messageObtain);
                        } catch (C9721b e10) {
                            C11839m.m70689w(CloudBackupService.TAG, "deleteSingleTempRecordRaw server delete error: " + e10.getMessage());
                            Message messageObtain2 = Message.obtain();
                            messageObtain2.what = 33047;
                            messageObtain2.arg1 = 1;
                            messageObtain2.arg2 = e10.m60663g();
                            CBCallBack.getInstance().sendMessage(messageObtain2);
                            CloudBackupReport.reportTempDeviceDelete(strM66627b, str + e10.getMessage(), String.valueOf(e10.m60659c()));
                        }
                    } catch (Exception e11) {
                        C11839m.m70689w(CloudBackupService.TAG, "deleteSingleTempRecordRaw Exception " + e11.getMessage());
                        Message messageObtain3 = Message.obtain();
                        messageObtain3.what = 33047;
                        messageObtain3.arg1 = 3;
                        CBCallBack.getInstance().sendMessage(messageObtain3);
                    }
                    CloudBackupReport.reportTempDeviceDelete(strM66627b, str, "200");
                    C11839m.m70688i(CloudBackupService.TAG, "deleteSingleTempRecord end");
                } catch (Throwable th2) {
                    CloudBackupReport.reportTempDeviceDelete(strM66627b, str, "200");
                    C11839m.m70688i(CloudBackupService.TAG, "deleteSingleTempRecord end");
                    throw th2;
                }
            }
        }, true);
    }

    public static Context getContext() {
        return C0213f.m1377a();
    }

    private String getDiskModule(String str) {
        return "record".equals(str) ? "autorecordingkey" : "phonemanager".equals(str) ? "autophonemanagerkey" : str;
    }

    public static CloudBackupService getInstance() {
        return mCbService;
    }

    public void getLastSuccessTime(CBState cBState) {
        long jQuerylastsuccesstime = new SettingOperator().querylastsuccesstime();
        if (jQuerylastsuccesstime == 0 && C10028c.m62182c0().m62360m1()) {
            jQuerylastsuccesstime = RestoreUtil.setLastSuccessTime();
            C11839m.m70688i(TAG, "getLastSuccessTime first get lastsuccesstime = " + jQuerylastsuccesstime);
        }
        cBState.setLastTimeStamp(jQuerylastsuccesstime);
    }

    private ArrayList<CloudBackupDeviceInfo> getSortedByDeviceInfo(Map<String, CloudBackupDeviceInfo> map) {
        final ArrayList<CloudBackupDeviceInfo> arrayList = new ArrayList<>();
        if (map == null || map.entrySet().isEmpty()) {
            C11839m.m70689w(TAG, "sortByDeviceInfo warn,deviceInfoMap is empty.");
            return arrayList;
        }
        ArrayList arrayList2 = (ArrayList) map.entrySet().stream().map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.service.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (CloudBackupDeviceInfo) ((Map.Entry) obj).getValue();
            }
        }).collect(Collectors.toCollection(new C2695b()));
        final AtomicReference atomicReference = new AtomicReference();
        final ArrayList arrayList3 = new ArrayList();
        arrayList2.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.service.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                CloudBackupService.lambda$getSortedByDeviceInfo$0(arrayList3, (CloudBackupDeviceInfo) obj);
            }
        });
        arrayList3.forEach(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.service.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                CloudBackupService.lambda$getSortedByDeviceInfo$2(arrayList, atomicReference, (CloudBackupDeviceInfo) obj);
            }
        });
        if (atomicReference.get() != null) {
            arrayList3.remove(atomicReference.get());
        }
        arrayList.addAll((Collection) arrayList3.stream().sorted(Comparator.comparingLong(new ToLongFunction() { // from class: com.huawei.android.hicloud.cloudbackup.service.e
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((CloudBackupDeviceInfo) obj).getLastBackupTime();
            }
        }).reversed()).collect(Collectors.toCollection(new C2695b())));
        return arrayList;
    }

    public void handleDeleteBaseAppSuccess(Message message) {
        String simpleName = getClass().getSimpleName();
        Activity activityM78351m = C13019a.m78347n().m78351m();
        if (activityM78351m != null) {
            simpleName = activityM78351m.getClass().getSimpleName();
        }
        int i10 = message.arg2;
        if (i10 == 0 || i10 == 1) {
            C14315h.m85262p().m85272K(false);
            getInstance().afterCloseCloudBackup(C0213f.m1377a(), null);
            C13225d.m79490f1().m79597u0(simpleName + ":  delete all base app module", C13471c.f.ALL_SWITCH, false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        C13225d.m79490f1().m79597u0(simpleName + ":  delete all base app module", C13471c.f.BASE_SWITCH, false);
        C14315h.m85262p().m85271J(false);
        if (C12591s1.m75931a().m75941k()) {
            return;
        }
        deleteLocalRecordCache();
    }

    private synchronized boolean initOpr() {
        Looper looper;
        try {
            if (this.mThread == null) {
                this.mThread = new HandlerThread("cloudbackup");
                this.mThread.start();
                if (this.mHandler == null && this.mThread != null && (looper = this.mThread.getLooper()) != null) {
                    this.mHandler = new Handler(looper) { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.5
                        public HandlerC26735(Looper looper2) {
                            super(looper2);
                        }

                        @Override // android.os.Handler
                        public void handleMessage(Message message) throws Throwable {
                            CloudBackupService.this.processGetCmd(message);
                        }
                    };
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.mHandler != null;
    }

    private static boolean isRestoreRetryTimeExpires(C13029h c13029h, int i10) {
        boolean z10 = ICBUtil.isRestoreRetryTimeExpires(c13029h.m78440F()) || TextUtils.equals(c13029h.m78484v(), "1");
        C11839m.m70688i(TAG, "checkRetryTimeIsExpired restoreRetryTimeExpires: " + z10 + " ,status: " + i10 + " ,isRestoreTaskExpired: " + c13029h.m78484v());
        if (z10) {
            if (i10 == 1 && !CBAccess.inRestoreTask() && c13029h.m78441G() != 4) {
                return true;
            }
            if ((i10 == 7 && !C13466f.m81073d().m81075b("has_moudles_restore_pause", false)) || i10 == 2 || i10 == 6 || i10 == 4) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSupportCloseBackup(boolean z10, String str, boolean z11) throws C9721b {
        List<CBSSyncRecordDeviceInfo> deviceList;
        if (!z11) {
            return false;
        }
        if (z10) {
            long jM1688f = C0241z.m1688f(C1443a.f6213a);
            C11839m.m70688i(TAG, "checkDeleteBackupSwitch current appVersion: " + jM1688f);
            return C14329v.m85349e0().m85397O(jM1688f);
        }
        CBSAllDevicesRsp cBSAllDevicesRspM64917R = new C10582a(null).m64917R(6);
        if (cBSAllDevicesRspM64917R == null || (deviceList = cBSAllDevicesRspM64917R.getDeviceList()) == null) {
            return false;
        }
        for (CBSSyncRecordDeviceInfo cBSSyncRecordDeviceInfo : deviceList) {
            if (TextUtils.equals(str, cBSSyncRecordDeviceInfo.getDeviceID())) {
                long jM1689g = C0241z.m1689g(cBSSyncRecordDeviceInfo.getAppVersion(), 0L);
                C11839m.m70688i(TAG, "checkDeleteBackupSwitch appVersion: " + jM1689g);
                return C14329v.m85349e0().m85397O(jM1689g);
            }
        }
        return false;
    }

    public static /* synthetic */ void lambda$getSortedByDeviceInfo$0(ArrayList arrayList, CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        if (AbstractC14026a.m84159a(cloudBackupDeviceInfo.getRecoveryItems())) {
            return;
        }
        cloudBackupDeviceInfo.setRecoveryItems((List) cloudBackupDeviceInfo.getRecoveryItems().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.service.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((CloudRecoveryItem) obj).isBackupCompleted();
            }
        }).collect(Collectors.toList()));
        if (AbstractC14026a.m84159a(cloudBackupDeviceInfo.getRecoveryItems())) {
            return;
        }
        arrayList.add(cloudBackupDeviceInfo);
    }

    public static /* synthetic */ void lambda$getSortedByDeviceInfo$1(ArrayList arrayList, CloudBackupDeviceInfo cloudBackupDeviceInfo, AtomicReference atomicReference, CloudRecoveryItem cloudRecoveryItem) {
        arrayList.add(cloudBackupDeviceInfo);
        atomicReference.set(cloudBackupDeviceInfo);
    }

    public static /* synthetic */ void lambda$getSortedByDeviceInfo$2(final ArrayList arrayList, final AtomicReference atomicReference, final CloudBackupDeviceInfo cloudBackupDeviceInfo) {
        if (AbstractC14026a.m84159a(cloudBackupDeviceInfo.getRecoveryItems())) {
            return;
        }
        cloudBackupDeviceInfo.getRecoveryItems().stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.service.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((CloudRecoveryItem) obj).isCurrent();
            }
        }).findFirst().ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.service.h
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                CloudBackupService.lambda$getSortedByDeviceInfo$1(arrayList, cloudBackupDeviceInfo, atomicReference, (CloudRecoveryItem) obj);
            }
        });
    }

    public void processGetCmd(Message message) throws Throwable {
        switch (message.what) {
            case 7:
                queryAllCloudBackupRecords(false, message.arg1 == 1, message.arg2 == 1, (String) message.obj);
                break;
            case 9:
                Bundle bundle = (Bundle) message.obj;
                deleteByModules(bundle.getString("deviceId"), bundle.getBoolean("isSync"));
                C13108a.m78878b(getContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
                break;
            case 10:
                new UserSpaceUtil(getContext()).getUserSpaceDetail();
                break;
            case 11:
                showRestoreDetail();
                break;
            case 15:
                refreshBackupTimes();
                break;
            case 16:
                Bundle bundle2 = (Bundle) message.obj;
                deleteSingleRecordRaw(bundle2.getString("deviceId"), bundle2.getString("backupId"), bundle2.getInt("device_type", 0));
                C13108a.m78878b(getContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
                break;
            case 18:
                showBackupRecord();
                break;
            case 19:
                Bundle bundle3 = (Bundle) message.obj;
                updateShowTag(bundle3.getInt("tag"), bundle3.getString("id"));
                break;
            case 21:
                deleteDeviceRecordRaw((Bundle) message.obj);
                C13108a.m78878b(getContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT"));
                break;
            case 23:
                updateLastSuccessTime(message);
                break;
            case 24:
                Bundle bundle4 = (Bundle) message.obj;
                queryV3RecordAppInfos(bundle4.getString(CloudBackupConstant.BACKUP_DEVICE_ID), bundle4.getString(GeneralRedirectUtil.BAK_ID), bundle4.getBoolean("isNewBmRecord", false), bundle4.getBoolean("isHarmonyRecord", false));
                break;
            case 25:
                queryCurrentRecordInfo(((Bundle) message.obj).getString("backupId"));
                break;
            case 26:
                deleteDeviceRecordRaw((Bundle) message.obj);
                closeCloudBackup();
                break;
            case 27:
                queryUserAllBackupInfo();
                break;
            case 28:
                deleteSingleTempRecordRaw((Bundle) message.obj);
                break;
        }
    }

    private void queryAllCloudBackupRecords(boolean z10, boolean z11, boolean z12, String str) {
        C10542o c10542o = new C10542o();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11839m.m70688i(TAG, "queryAllBackupRecords begin.");
            CloudBackupUserInfo cloudBackupUserInfoM64680g1 = c10542o.m64680g1(false, z11, z10);
            C11839m.m70688i(TAG, "queryAllBackupRecords end,time cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            Map<String, CloudBackupDeviceInfo> deviceInfoMap = cloudBackupUserInfoM64680g1.getDeviceInfoMap();
            boolean zIsSupportCloseBackup = isSupportCloseBackup(z11, str, z12);
            queryOperationControl();
            backupRecordsSort(deviceInfoMap, zIsSupportCloseBackup);
            C11839m.m70688i(TAG, "query cloud backup records success.");
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "query about failed." + e10.getMessage());
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 32315, 1, e10.m60659c()));
        }
    }

    private void queryCurrentRecordInfo(String str) {
        C11839m.m70688i(TAG, "query current record info, backupId : " + str);
        try {
            Iterator<Map.Entry<String, CloudBackupDeviceInfo>> it = new C10542o().m64679f1(true, true).getDeviceInfoMap().entrySet().iterator();
            String backupDeviceId = "";
            String version = "";
            while (it.hasNext()) {
                List<CloudRecoveryItem> recoveryItems = it.next().getValue().getRecoveryItems();
                if (recoveryItems != null && recoveryItems.size() > 0) {
                    Iterator<CloudRecoveryItem> it2 = recoveryItems.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            CloudRecoveryItem next = it2.next();
                            if (str.equals(next.getBackupId())) {
                                backupDeviceId = next.getBackupDeviceId();
                                version = next.getVersion();
                                break;
                            }
                        }
                    }
                }
            }
            Message message = new Message();
            message.what = 33019;
            message.arg1 = 0;
            Bundle bundle = new Bundle();
            bundle.putString(CloudBackupConstant.BACKUP_DEVICE_ID, backupDeviceId);
            bundle.putString("version", version);
            message.obj = bundle;
            CBCallBack.getInstance().sendMessage(message);
            C11839m.m70688i(TAG, "query cloud backup records success.");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "query current record info error : " + e10.getMessage());
            Message messageObtain = Message.obtain();
            messageObtain.what = 32422;
            CBCallBack.getInstance().sendMessage(messageObtain);
        }
    }

    public void queryLastRecord(boolean z10) {
        C11839m.m70688i(TAG, "query last record begin isMain = " + z10);
        try {
            CloudRecoveryItem currentLatestBackupRecord = new C10542o().m64685l1(false, true, true).getCurrentLatestBackupRecord();
            if (currentLatestBackupRecord == null) {
                currentLatestBackupRecord = new CloudRecoveryItem();
                currentLatestBackupRecord.setBackupEndTime(0L);
                currentLatestBackupRecord.setDevDisplayName("");
            }
            String devDisplayName = currentLatestBackupRecord.getDevDisplayName();
            long backupEndTime = currentLatestBackupRecord.getBackupEndTime();
            Bundle bundle = new Bundle();
            bundle.putLong("lastRecordTime", backupEndTime);
            bundle.putString("deviceName", devDisplayName);
            if (z10 && initOpr() && this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(23, bundle));
            }
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 32338, 0, 0, bundle));
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "query last record failed." + e10.getMessage());
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 32338, 1, e10.m60659c()));
        }
    }

    private void queryOperationControl() throws C9721b {
        C11839m.m70688i(TAG, "queryOperationControl");
        C12176c.m73268k(new C13998b0().m84137z("operationControl", C11058a.m66627b("02101")));
    }

    private void queryUserAllBackupInfo() {
        new C10542o();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11839m.m70688i(TAG, "queryUserAllBackupInfo begin.");
            Map<String, CloudBackupDeviceInfo> deviceInfoMap = ((CloudBackupUserInfo) C1007b.m5980s().m5991K(false, false, true)).getDeviceInfoMap();
            C11839m.m70688i(TAG, "queryUserAllBackupInfo end,time cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            ArrayList<? extends Parcelable> sortedByDeviceInfo = getSortedByDeviceInfo(deviceInfoMap);
            ArrayList arrayList = new ArrayList();
            Iterator<? extends Parcelable> it = sortedByDeviceInfo.iterator();
            while (it.hasNext()) {
                CloudBackupDeviceInfo cloudBackupDeviceInfo = (CloudBackupDeviceInfo) it.next();
                if (cloudBackupDeviceInfo.isTempBackup()) {
                    CloudBackupDeviceInfo cloudBackupDeviceInfoM85643clone = cloudBackupDeviceInfo.m85643clone();
                    List<CloudRecoveryItem> recoveryItems = cloudBackupDeviceInfoM85643clone.getRecoveryItems();
                    recoveryItems.clear();
                    List<CloudRecoveryItem> recoveryItems2 = cloudBackupDeviceInfo.getRecoveryItems();
                    Iterator<CloudRecoveryItem> it2 = recoveryItems2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        CloudRecoveryItem next = it2.next();
                        if (next.isTempBackup()) {
                            recoveryItems.add(next);
                            break;
                        }
                    }
                    recoveryItems2.removeAll(recoveryItems);
                    if (!AbstractC14026a.m84159a(recoveryItems)) {
                        CloudRecoveryItem cloudRecoveryItem = recoveryItems.get(0);
                        cloudBackupDeviceInfoM85643clone.setDeviceBackupSpace(cloudRecoveryItem.getSize());
                        if (cloudRecoveryItem.getOccupySpaceType() == 1) {
                            cloudBackupDeviceInfo.setDeviceBackupSpace(cloudBackupDeviceInfo.getDeviceBackupSpace() - cloudBackupDeviceInfoM85643clone.getDeviceBackupSpace());
                        }
                        arrayList.add(cloudBackupDeviceInfoM85643clone);
                    }
                    cloudBackupDeviceInfo.setTempBackup(false);
                    if (AbstractC14026a.m84159a(recoveryItems2)) {
                        it.remove();
                    }
                }
            }
            sortedByDeviceInfo.addAll(arrayList);
            Message messageObtain = Message.obtain();
            messageObtain.what = 32315;
            messageObtain.arg1 = 0;
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("userBackupInfo", sortedByDeviceInfo);
            messageObtain.setData(bundle);
            CBCallBack.getInstance().sendMessage(messageObtain);
            C11839m.m70688i(TAG, "query cloud backup records success.");
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "query about failed." + e10.getMessage());
            CBCallBack.getInstance().sendMessage(Message.obtain(null, 32315, 1, e10.m60659c()));
        }
    }

    private void queryV3RecordAppInfos(String str, String str2, boolean z10, boolean z11) {
        try {
            CloudRecoveryItem cloudRecoveryItemQueryV3RecordAppInfosFromServer = queryV3RecordAppInfosFromServer(str, str2, true, true, z10, z11);
            Message messageObtain = Message.obtain();
            messageObtain.what = 32322;
            messageObtain.arg1 = 0;
            Bundle bundle = new Bundle();
            bundle.putParcelable("recordItem", cloudRecoveryItemQueryV3RecordAppInfosFromServer);
            messageObtain.setData(bundle);
            CBCallBack.getInstance().sendMessage(messageObtain);
        } catch (C9721b e10) {
            C11839m.m70688i(TAG, "queryRecordAppData" + e10.getMessage());
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 32422;
            CBCallBack.getInstance().sendMessage(messageObtain2);
        }
    }

    private void quit() {
        if (this.mHandler != null) {
            Looper looper = this.mHandler.getLooper();
            this.mHandler = null;
            if (looper != null) {
                looper.quit();
            }
        }
        this.mThread = null;
    }

    private void refreshBackupTimes() {
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 32331, new SettingOperator().queryBackupTimes(), 0, null));
        C12515a.m75110o().m75172d(new GetBackupRecordsNumTask());
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private fk.C9721b refreshSwitchStatus(boolean r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.refreshSwitchStatus(boolean, java.lang.String):fk.b");
    }

    private void reportEvent(String str, String str2, String str3) {
        C11060c c11060cM66626a = C11058a.m66626a(str, str2, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66635A(str3);
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66668x("1");
        c11060cM66626a.m66664t("success");
        C13622a.m81968n(getContext(), c11060cM66626a);
    }

    private static void sendResult(ArrayList<CloudRecoveryItem> arrayList, ArrayList<CloudRecoveryItem> arrayList2, ArrayList<CloudRecoveryItem> arrayList3, ArrayList<CloudRecoveryItem> arrayList4, boolean z10) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 32315;
        messageObtain.arg1 = 0;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("latest", arrayList);
        bundle.putParcelableArrayList("oldest", arrayList2);
        bundle.putParcelableArrayList("refurbishment", arrayList3);
        bundle.putParcelableArrayList("tempBackup", arrayList4);
        bundle.putBoolean("isSupportCloseBackup", z10);
        messageObtain.setData(bundle);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.addAll(arrayList);
        arrayList5.addAll(arrayList2);
        arrayList5.addAll(arrayList3);
        Collections.sort(arrayList5);
        messageObtain.obj = arrayList5;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    private void setDeviceDeletingFlag(boolean z10, boolean z11) {
        if (z10) {
            this.deleteFlagRWLock.writeLock().lock();
            try {
                this.isDeletingDeviceRecord = z11;
            } finally {
                this.deleteFlagRWLock.writeLock().unlock();
            }
        }
    }

    private void showBackupRecord() {
        C13029h c13029h;
        C11839m.m70688i(TAG, "start show BackupTags.");
        List<C13029h> listM78494e = new C13030i().m78494e();
        if (listM78494e == null || listM78494e.isEmpty()) {
            c13029h = null;
        } else {
            Collections.sort(listM78494e);
            c13029h = listM78494e.get(0);
        }
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 33426, c13029h));
    }

    private void showRestoreDetail() {
        C13029h c13029hM78495f;
        C11839m.m70688i(TAG, "showRestoreDetail");
        String strM81079g = C13466f.m81073d().m81079g("restore_process_type", "");
        boolean zEquals = !TextUtils.isEmpty(strM81079g) ? TextUtils.equals(CBSBaseReq.CURRENT_API_VERSION, strM81079g) : false;
        C13030i c13030i = new C13030i();
        try {
            c13029hM78495f = c13030i.m78495f(3);
        } catch (C9721b unused) {
            C11839m.m70687e(TAG, "showRestoreDetail tags is null");
            c13029hM78495f = null;
        }
        if (c13029hM78495f != null) {
            boolean zM81952h = C13619c.m81952h(c13029hM78495f.m78480t());
            if (TextUtils.isEmpty(strM81079g)) {
                zEquals = zM81952h;
            }
            checkRetryTimeIsExpired(c13030i, c13029hM78495f, zM81952h);
        }
        int iM80916g0 = C13452e.m80781L().m80916g0();
        if (zEquals) {
            RestoreProgress.initRestoreItemsV3();
        } else {
            RestoreProgress.initRestoreItems();
        }
        Integer restoreErrCode = RestoreUtil.getRestoreErrCode();
        Message messageObtain = Message.obtain();
        messageObtain.what = 3205;
        messageObtain.arg1 = iM80916g0;
        if (restoreErrCode != null) {
            messageObtain.arg2 = restoreErrCode.intValue();
        }
        messageObtain.obj = Boolean.FALSE;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    private void syncByHand(int i10) {
        if (i10 == 0 && C0206b0.m1131c("notepad", getContext())) {
            C1008c.m6035v().m6077h0(getContext(), 3, "");
        }
    }

    public static void trasferDeleteError(C9721b c9721b, Message message, String str) {
        if ((3107 == c9721b.m60659c() && c9721b.m60663g() == 603) || str.endsWith(String.valueOf(4291))) {
            message.arg1 = 1;
        } else if (C14339h.m85516o().contains(Integer.valueOf(c9721b.m60659c())) || C14339h.m85514m().contains(Integer.valueOf(c9721b.m60659c()))) {
            message.arg1 = 2;
        } else {
            message.arg1 = 3;
        }
    }

    private static void updateCancelRestoreStatus() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        ICBBroadcastManager.sendCancelRestoreBroadcast(context);
        RestoreNotification.getInstance().cancelNotification();
        C13452e.m80781L().m80909e3(0.0f);
        C13452e.m80781L().m80914f3(8);
    }

    private void updateLastSuccessTime(Message message) {
        long j10 = ((Bundle) message.obj).getLong("lastRecordTime");
        SettingOperator settingOperator = new SettingOperator();
        if (j10 != settingOperator.querylastsuccesstime()) {
            settingOperator.replace(new Settings[]{new Settings("lastsuccesstime", String.valueOf(j10), "2")});
            C14317j.m85300d().m85319t();
        }
        getState();
    }

    private static void updateSplitSwitchToDb(C13026e c13026e, String str, boolean z10, long j10) {
        List<BackupOptionItem> listM78368C = c13026e.m78368C(str);
        if (z10 || listM78368C == null || listM78368C.isEmpty()) {
            return;
        }
        Iterator<BackupOptionItem> it = listM78368C.iterator();
        while (it.hasNext()) {
            c13026e.m78378M(false, it.next().getAppId(), Long.valueOf(j10));
        }
    }

    private void updateSwitchToDb(String str, C13026e c13026e, boolean z10, long j10, BackupOptionItem backupOptionItem) throws C9721b {
        if (!TextUtils.equals(NavigationUtils.SMS_SCHEMA_PREF, str) && !TextUtils.equals("soundrecorder", str)) {
            if (backupOptionItem != null) {
                c13026e.m78378M(z10, str, Long.valueOf(j10));
                return;
            }
            BackupOptionItem backupOptionItem2 = new BackupOptionItem(str);
            backupOptionItem2.setOperateTime(j10);
            backupOptionItem2.setOperateType(1);
            c13026e.m78370E(backupOptionItem2);
            return;
        }
        List<BackupOptionItem> listM78399w = c13026e.m78399w(str);
        if (listM78399w == null || listM78399w.isEmpty()) {
            c13026e.m78378M(z10, str, Long.valueOf(j10));
            return;
        }
        Iterator<BackupOptionItem> it = listM78399w.iterator();
        while (it.hasNext()) {
            c13026e.m78378M(z10, it.next().getAppId(), Long.valueOf(j10));
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized void abort() {
        abort(1001);
    }

    public synchronized void abortBackup(int i10) {
        C11839m.m70688i(TAG, "abortBackup: " + i10 + " ,result: " + CBAccess.manualAbort(i10));
    }

    public synchronized void abortRestore(int i10) {
        try {
            C11839m.m70688i(TAG, "abortRestore: " + i10);
            if (CBAccess.inBackup() || !CBAccess.manualAbort(i10)) {
                CBAccess.clearRestoreCacheAsync(true);
                C11839m.m70688i(TAG, "abort, send restore cache clear success message");
                CBCallBack.getInstance().sendMessageDelayed(Message.obtain((Handler) null, 33015), 500L);
            }
            updateCancelRestoreStatus();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void afterCloseCloudBackup(Context context, InterfaceC13829a<Boolean> interfaceC13829a) {
        C12515a.m75110o().m75172d(new C26779(interfaceC13829a));
        C13466f.m81073d().m81084l("broadcast_backupId", "");
        if (!CBAccess.hasValidTempBackup()) {
            BackupNotification.getInstance().cancelBackupNotification();
        }
        C10155f.m63262O(context, false);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean backup(boolean z10, boolean z11) {
        if (!z11) {
            if (!C12591s1.m75931a().m75941k()) {
                return CBAccess.addTask(new C0258d(z10, false, false));
            }
        }
        return doRefurbishBackup(z10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean cancelRefurbish() {
        return cancelRefurbish(true);
    }

    public synchronized boolean cancelTempBackup(String str) {
        try {
            C11839m.m70688i(TAG, "cancelTempBackup: " + str);
            C13030i c13030i = new C13030i();
            try {
                C13029h c13029hM78495f = c13030i.m78495f(5);
                if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                    C11839m.m70688i(TAG, "tempbackup tag is null or done.");
                    return true;
                }
                BackupNotification.getInstance().cancelBackupNotification();
                getInstance().abortBackup(1001);
                c13030i.m78490a(5);
                deleteSingleFromServer(c13029hM78495f.m78465h(), str);
                C12299b.m73932n("backupAction", "");
                if (C10028c.m62182c0().m62388s("backup_key")) {
                    C12299b.m73927i();
                } else {
                    C14315h.m85247M(false, 0, true);
                }
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70688i(TAG, "cancel tempbackup context return null.");
                    return false;
                }
                C14315h.m85262p().m85277i(contextM1377a, true, true);
                return true;
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "cancelTempBackup query backup tags error: " + e10);
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void checkBackup(Handler handler) {
        C12515a.m75110o().m75172d(new CloudBackupCheckTask(handler));
    }

    public void closeCloudBackup() {
        getInstance().cloudbackupOpr(false);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33036;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public void cloudbackupOpr(boolean z10) {
        C14315h.m85262p().m85272K(z10);
    }

    public void deleteAllBaseAppModule(int i10) {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.10
            final /* synthetic */ int val$deleteReportEntry;

            public C266910(int i102) {
                i = i102;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v3, types: [int] */
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                Message messageObtain = Message.obtain();
                C11839m.m70686d(CloudBackupService.TAG, "deleteAllBaseAppModule");
                messageObtain.what = 33045;
                messageObtain.arg2 = i;
                String message = "0";
                String strM66627b = null;
                try {
                    try {
                        C13998b0 c13998b0 = new C13998b0();
                        strM66627b = C11058a.m66627b("02109");
                        c13998b0.m84129Z("backupDeviceIdV1V2", strM66627b);
                        CloudBackupService.this.handleDeleteBaseAppSuccess(messageObtain);
                        messageObtain.arg1 = 0;
                    } catch (C9721b e10) {
                        message = e10.getMessage();
                        C11839m.m70688i(CloudBackupService.TAG, "deleteAllBaseAppModule e " + message);
                        CloudBackupService.trasferDeleteError(e10, messageObtain, String.valueOf(e10.m60663g()));
                    } catch (Exception e11) {
                        message = e11.getMessage();
                        C11839m.m70688i(CloudBackupService.TAG, "deleteAllBaseAppModule Exception " + message);
                        messageObtain.arg1 = 2;
                    }
                } finally {
                    CBCallBack.getInstance().sendMessage(messageObtain);
                    CloudBackupReport.reportDeleteBaseAppModule(message, i, strM66627b);
                }
            }
        }, false);
    }

    public void deleteDeviceRecord(String str, String str2, int i10, int i11, boolean z10) {
        if (!ICBUtil.checkPrivacyUser(getContext()) && initOpr()) {
            Bundle bundle = new Bundle();
            bundle.putString("deviceId", str);
            bundle.putString(CloudBackupConstant.BACKUP_DEVICE_ID, str2);
            bundle.putInt("sendPush", i10);
            bundle.putInt("backup_delete_report_entry", i11);
            bundle.putBoolean("delete_from_backup_card_switch", z10);
            C11839m.m70688i(TAG, "deleteDeviceRecord");
            this.mHandler.sendMessage(this.mHandler.obtainMessage(21, bundle));
        }
    }

    public void deleteLocalCache(String str) {
        if (TextUtils.equals(C13452e.m80781L().m80950o(), str)) {
            new SettingOperator().replace(new Settings[]{new Settings("lastsuccesstime", "0", "2"), new Settings("lastfailedtime", "0", "2")});
            C12299b.m73927i();
            C11839m.m70688i(TAG, "reset lastSuccessTime, lastFailedTime success");
            C13465e.m81052f().m81065n("lastRecordTime", 0L);
            C13465e.m81052f().m81065n("currentDeviceBackupedDataSize", 0L);
            C14315h.m85262p().m85277i(getContext(), !CBAccess.hasValidTempBackup(), true);
            C12515a.m75110o().m75172d(new GetOptionsInfoFromCloneTask(false));
            C11839m.m70688i(TAG, "deleteLocalCache clear local backuptag db");
        }
    }

    public void deleteLocalRecordCache() {
        C12515a.m75110o().m75172d(new DeleteLocalRecordCacheTask());
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean deleteRecord(String str, boolean z10) {
        if (ICBUtil.checkPrivacyUser(getContext()) || !initOpr()) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("deviceId", str);
        bundle.putBoolean("isSync", z10);
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(9, bundle));
    }

    public boolean deleteRecordAndCloseBackup(String str, int i10, int i11) {
        if (ICBUtil.checkPrivacyUser(getContext()) || !initOpr()) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("deviceId", str);
        bundle.putString(CloudBackupConstant.BACKUP_DEVICE_ID, "backupDeviceIdV1V2");
        bundle.putInt("sendPush", i10);
        bundle.putInt("backup_delete_report_entry", i11);
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(26, bundle));
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean deleteSingleRecord(String str, int i10, String str2) {
        if (ICBUtil.checkPrivacyUser(getContext()) || !initOpr()) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("deviceId", str);
        bundle.putInt("device_type", i10);
        bundle.putString("backupId", str2);
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(16, bundle));
    }

    public void deleteSingleTempRecord(String str, String str2, boolean z10, int i10) {
        if (!ICBUtil.checkPrivacyUser(getContext()) && initOpr()) {
            Bundle bundle = new Bundle();
            bundle.putString(CloudBackupConstant.BACKUP_DEVICE_ID, str);
            bundle.putString(GeneralRedirectUtil.BAK_ID, str2);
            bundle.putBoolean("isCurrent", z10);
            bundle.putInt("backup_delete_report_entry", i10);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(28, bundle));
        }
    }

    public boolean doRefurbishBackup(boolean z10) {
        boolean zHasValidTempBackup = CBAccess.hasValidTempBackup();
        boolean zHasTaskWorking = CBAccess.hasTaskWorking();
        C11839m.m70688i(TAG, "doRefurbishBackup: " + z10 + " hasValidTempBackup: " + zHasValidTempBackup + " hasTaskWorking: " + zHasTaskWorking);
        if (zHasValidTempBackup) {
            getInstance().cancelTempBackup("delete_single_from_backup_furbish");
            CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33046));
        } else if (zHasTaskWorking) {
            C11839m.m70688i(TAG, "doRefurbishBackup no TempBackup, hasTaskWorking");
            return false;
        }
        return CBAccess.addRefurbish(new C0258d(z10, true, false));
    }

    public synchronized boolean doTempBackup(boolean z10, int i10) {
        try {
            C11839m.m70688i(TAG, "doTempBackup begin ,isAutoBackup:" + z10 + ",occupySpaceType:" + i10);
            if (C12591s1.m75931a().m75941k()) {
                getInstance().cancelRefurbish();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return CBAccess.addTempTask(new C0258d(z10, false, false, false, true, i10));
    }

    public String getBackupDeviceId() {
        try {
            C13030i c13030i = new C13030i();
            C13029h c13029hM78495f = c13030i.m78495f(2);
            if (c13029hM78495f == null) {
                c13029hM78495f = c13030i.m78495f(1);
            }
            if (c13029hM78495f == null || c13029hM78495f.m78488y() == null || !c13029hM78495f.m78488y().startsWith("V3_")) {
                return null;
            }
            return c13029hM78495f.m78488y().replaceFirst("V3_", "");
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "querytags error: " + e10.getMessage());
            return null;
        }
    }

    public void getBackupLearnAboutAddress() {
        C12515a.m75110o().m75172d(new GetBackupLearnAboutUrlTask());
    }

    public void getBackupLinkAddress(int i10) {
        C12515a.m75110o().m75172d(new GetBackupLinkAddressTask(i10));
    }

    public CBState getCloudBackupStateSynchronous() {
        CBState cBState = new CBState();
        if (CBAccess.inBackup()) {
            cBState.setStatus(1);
        }
        if (CBAccess.inRestore()) {
            cBState.setStatus(2);
        }
        int iInRestorePaused = CBAccess.inRestorePaused();
        if (iInRestorePaused > 0) {
            cBState.setStatus(3);
            cBState.setAmount(iInRestorePaused);
        }
        cBState.setState(CBAccess.getState());
        if (cBState.getStatus() == 0) {
            cBState.setLastTimeStamp(new SettingOperator().querylastsuccesstime());
        }
        C11839m.m70688i(TAG, "getCloudBackupStateForHWID cloudbackup state end, status = " + cBState.getStatus() + ", state = " + cBState.getState());
        return cBState;
    }

    public int getModuleCountFromOption(String str) {
        BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(str, false);
        if (backupOptionItemQueryItem != null) {
            return backupOptionItemQueryItem.getItemTotal();
        }
        return 0;
    }

    public long getModuleIncSizeFromOption() {
        return C12590s0.m75923y(true).m69963a();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean getState() {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.2
            public C26702() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                C11839m.m70688i(CloudBackupService.TAG, "get cloudBackup state start.");
                CBState cBState = new CBState();
                if (CBAccess.inBackup()) {
                    int iM80916g0 = C13452e.m80781L().m80916g0();
                    boolean zIsInTempBackup = CBAccess.isInTempBackup();
                    C11839m.m70688i(CloudBackupService.TAG, "get cloudBackup restoreStatus = " + iM80916g0 + " ,inTempBackup: " + zIsInTempBackup);
                    if (iM80916g0 != 3 && !zIsInTempBackup) {
                        C13452e.m80781L().m80890b();
                        RestoreNotification.getInstance().cancelNotification();
                        ICBBroadcastManager.sendCancelRestoreBroadcast(C0213f.m1377a());
                        C13452e.m80781L().m80909e3(0.0f);
                    }
                    cBState.setStatus(1);
                }
                if (CBAccess.inRestore()) {
                    cBState.setStatus(2);
                }
                int iInRestorePaused = CBAccess.inRestorePaused();
                if (iInRestorePaused > 0) {
                    cBState.setStatus(3);
                    cBState.setAmount(iInRestorePaused);
                }
                cBState.setState(CBAccess.getState());
                if (cBState.getStatus() == 0) {
                    CloudBackupService.this.getLastSuccessTime(cBState);
                }
                CBCallBack.getInstance().sendMessage(Message.obtain(null, 32308, cBState));
                C11839m.m70688i(CloudBackupService.TAG, "get cloudBackup state end, status = " + cBState.getStatus() + ", state = " + cBState.getState());
            }
        }, false);
        return true;
    }

    public void getSwitchTime() {
        SettingOperator settingOperator = new SettingOperator();
        long jQueryBackupSwitchTime = settingOperator.queryBackupSwitchTime();
        long jQueryinitopentime = settingOperator.queryinitopentime();
        C11839m.m70688i(TAG, "backupSwitchTime:  " + jQueryBackupSwitchTime + "initopentime:  " + jQueryinitopentime);
        if (jQueryBackupSwitchTime == 0 && jQueryinitopentime != 0) {
            settingOperator.replace(new Settings[]{new Settings("backupswitchtime", String.valueOf(jQueryinitopentime), "2")});
            jQueryBackupSwitchTime = jQueryinitopentime;
        }
        CBCallBack.getInstance().sendMessage(Message.obtain(null, 33014, Long.valueOf(jQueryBackupSwitchTime)));
    }

    public boolean isDeletingDeviceRecord() {
        this.deleteFlagRWLock.readLock().lock();
        try {
            return this.isDeletingDeviceRecord;
        } finally {
            this.deleteFlagRWLock.readLock().unlock();
        }
    }

    public boolean manualBaseBackup(boolean z10) {
        return CBAccess.addTask(new C0258d(false, false, true, z10, false, C12600v1.m76047c().m76053d().m24616e()));
    }

    public void openCloudBackup() {
        getInstance().cloudbackupOpr(true);
    }

    public void queryCloudSpaceByServer() {
        C12515a.m75110o().m75175e(new QueryCloudSpaceByServer(), true);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean queryCurrentRecord(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("backupId", str);
        return !ICBUtil.checkPrivacyUser(getContext()) && initOpr() && this.mHandler.sendMessage(this.mHandler.obtainMessage(25, bundle));
    }

    public synchronized void queryRecordsCompatibility(List<CloudRecoveryItem> list, List<CloudRecoveryItem> list2) {
        if (initOpr()) {
            C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.4
                final /* synthetic */ List val$latestList;
                final /* synthetic */ List val$oldestList;

                public C26724(List list3, List list22) {
                    list = list3;
                    list = list22;
                }

                @Override // p616rk.AbstractRunnableC12516b
                public void call() {
                    try {
                        CloudBackupService.this.checkRecordsCompatibility(list);
                        CloudBackupService.this.checkRecordsCompatibility(list);
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 33052;
                        messageObtain.arg1 = 0;
                        C11839m.m70688i(CloudBackupService.TAG, "queryRecordsCompatibility success ");
                        CBCallBack.getInstance().sendMessage(messageObtain);
                    } catch (C9721b e10) {
                        C11839m.m70687e(CloudBackupService.TAG, "checkRecordsCompatibility error: " + e10.toString());
                        CBCallBack.getInstance().sendMessage(Message.obtain(null, 33052, 1, e10.m60659c()));
                    }
                }
            }, false);
        }
    }

    public synchronized void queryUserBackupInfo() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 27;
        if (initOpr()) {
            this.mHandler.sendMessage(messageObtain);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem queryV3RecordAppInfosFromServer(java.lang.String r24, java.lang.String r25, boolean r26, boolean r27, boolean r28, boolean r29) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.queryV3RecordAppInfosFromServer(java.lang.String, java.lang.String, boolean, boolean, boolean, boolean):com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem");
    }

    public void refreshGradeWhiteBusinessModel(boolean z10) {
        C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.8
            final /* synthetic */ boolean val$isRefresh;

            public C26768(boolean z102) {
                z = z102;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() throws C9721b {
                C11839m.m70688i(CloudBackupService.TAG, "refreshGradeWhiteBusinessModel");
                Message messageObtain = Message.obtain();
                messageObtain.what = 33044;
                if (!C0209d.m1333z1(CloudBackupService.getContext())) {
                    messageObtain.arg1 = 1;
                    CBCallBack.getInstance().sendMessage(messageObtain);
                    return;
                }
                BackupSwitchBmChanger backupSwitchBmChanger = new BackupSwitchBmChanger(false, true, null);
                messageObtain.what = z ? 33017 : 33044;
                messageObtain.arg1 = 8;
                messageObtain.obj = backupSwitchBmChanger;
                CBCallBack.getInstance().sendMessage(messageObtain);
                C11839m.m70688i(CloudBackupService.TAG, "refreshGradeWhiteBusinessModel end");
            }
        }, true);
    }

    public void refreshGuideBackupInfo(boolean z10) {
        C12515a.m75110o().m75172d(new GetLastOneWeekAutoBackupTimesTask());
        C12515a.m75110o().m75172d(new GetNextBackupTimesTask());
        if (z10) {
            C12515a.m75110o().m75172d(new GetWaitBackupTimesTask());
        }
    }

    public void refreshSwitchStatusAsync(boolean z10) {
        C12515a.m75110o().m75175e(new BackupSingleTask() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.7
            final /* synthetic */ boolean val$isRefreshUI;

            public C26757(boolean z102) {
                z = z102;
            }

            @Override // com.huawei.android.hicloud.cloudbackup.process.task.BackupSingleTask
            public void execute() throws C9721b {
                C12515a.m75110o().m75165a1(this);
                if (CBAccess.inBackup()) {
                    C11839m.m70688i(CloudBackupService.TAG, "refreshSwitchStatusAsync is backuping");
                } else {
                    CloudBackupService.this.refreshSwitchStatusSync(z, null);
                }
            }
        }, true);
    }

    public C9721b refreshSwitchStatusSync(boolean z10, String str) {
        if (C0209d.m1333z1(getContext())) {
            return refreshSwitchStatus(z10, str);
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 33024;
        messageObtain.arg1 = 1;
        CBCallBack.getInstance().sendMessage(messageObtain);
        return null;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean register(Handler.Callback callback) {
        return CBCallBack.getInstance().registerCallback(callback);
    }

    public void reportCloseBackup() {
        C12515a.m75110o().m75172d(new CloseSwitchTask());
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean restore(String str, int i10, String str2, int i11) {
        C13466f.m81073d().m81084l("restore_process_type", "V2");
        C4877a.m29281i().m29284k(str, str2, i10, i11);
        return true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean restoreLast(boolean z10) {
        return false;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean restoreRetry(boolean z10, boolean z11, boolean z12) {
        if (!C10155f.m63259L(getContext())) {
            return false;
        }
        C4877a.m29281i().m29285l(z10, z11, z12);
        return true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean restoreRetryV3(boolean z10, boolean z11) {
        return restoreRetryV3(z10, z11, false);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean restoreV3(String str, String str2, String str3, int i10, String str4, String str5) {
        C13466f.m81073d().m81084l("restore_process_type", CBSBaseReq.CURRENT_API_VERSION);
        C4877a.m29281i().m29287n(str, str2, str3, i10, str4, str5);
        return true;
    }

    public synchronized boolean showLastRecord(boolean z10) {
        if (ICBUtil.checkPrivacyUser(getContext())) {
            return false;
        }
        if (initOpr()) {
            C12515a.m75110o().m75175e(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.3
                final /* synthetic */ boolean val$isMain;

                public C26713(boolean z102) {
                    z = z102;
                }

                @Override // p616rk.AbstractRunnableC12516b
                public void call() {
                    CloudBackupService.this.queryLastRecord(z);
                }
            }, false);
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public synchronized boolean showRecords(boolean z10, boolean z11, String str) {
        boolean z12;
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        z12 = false;
        messageObtain.arg1 = z10 ? 1 : 0;
        messageObtain.arg2 = z11 ? 1 : 0;
        messageObtain.obj = str;
        if (!ICBUtil.checkPrivacyUser(getContext()) && initOpr()) {
            if (this.mHandler.sendMessage(messageObtain)) {
                z12 = true;
            }
        }
        return z12;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean showReports() {
        return initOpr() && this.mHandler.sendEmptyMessage(11);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean showV3RecordsDetail(java.lang.String r3, java.lang.String r4, boolean r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L3c
            r0.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = "backupDeviceId"
            r0.putString(r1, r3)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "bakId"
            r0.putString(r3, r4)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "isNewBmRecord"
            r0.putBoolean(r3, r5)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "isHarmonyRecord"
            r0.putBoolean(r3, r6)     // Catch: java.lang.Throwable -> L3c
            android.content.Context r3 = getContext()     // Catch: java.lang.Throwable -> L3c
            boolean r3 = com.huawei.android.hicloud.cloudbackup.util.ICBUtil.checkPrivacyUser(r3)     // Catch: java.lang.Throwable -> L3c
            if (r3 != 0) goto L3e
            boolean r3 = r2.initOpr()     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            android.os.Handler r3 = r2.mHandler     // Catch: java.lang.Throwable -> L3c
            android.os.Handler r4 = r2.mHandler     // Catch: java.lang.Throwable -> L3c
            r5 = 24
            android.os.Message r4 = r4.obtainMessage(r5, r0)     // Catch: java.lang.Throwable -> L3c
            boolean r3 = r3.sendMessage(r4)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3e
            r3 = 1
            goto L3f
        L3c:
            r3 = move-exception
            goto L41
        L3e:
            r3 = 0
        L3f:
            monitor-exit(r2)
            return r3
        L41:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.service.CloudBackupService.showV3RecordsDetail(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean spaceManager() {
        return !ICBUtil.checkPrivacyUser(getContext()) && initOpr() && this.mHandler.sendEmptyMessage(10);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public void unregister(Handler.Callback callback) {
        CBCallBack.getInstance().unregisterCallback(callback);
        quit();
    }

    public boolean updateShowTag(C13029h c13029h) {
        if (!initOpr()) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("tag", c13029h.m78442H());
        bundle.putString("id", c13029h.m78436B());
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(19, bundle));
    }

    public synchronized boolean cancelRefurbish(boolean z10) {
        try {
            C11727h.m69967b().m69968a();
            if (z10) {
                abortBackupTask();
            }
            C13030i c13030i = new C13030i();
            try {
                C13029h c13029hM78495f = c13030i.m78495f(4);
                if (c13029hM78495f == null || c13029hM78495f.m78441G() == 4) {
                    C11839m.m70688i(TAG, "refurbish tag is null.");
                    ICBBroadcastManager.sendCancelCloudBackupStateBroadcast2(1);
                    C14317j.m85300d().m85316q(false);
                    c13030i.m78490a(4);
                    return true;
                }
                C14317j.m85300d().m85316q(false);
                c13030i.m78490a(4);
                C12299b.m73932n("backupAction", "");
                C12299b.m73927i();
                CBAccess.startDeleteTask(new C0257c1(C12590s0.m75786Q(c13029hM78495f), c13029hM78495f.m78465h(), true, true, true));
                ICBBroadcastManager.sendCancelCloudBackupStateBroadcast2(1);
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    C11839m.m70688i(TAG, "cancel refurbish context return null.");
                    return false;
                }
                C14315h.m85262p().m85277i(contextM1377a, true, true);
                return true;
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "query backup tags error: " + e10.toString());
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean restoreRetryV3(boolean z10, boolean z11, boolean z12) {
        if (!C10155f.m63259L(getContext())) {
            return false;
        }
        C4877a.m29281i().m29286m(z10, z11, z12);
        return true;
    }

    public synchronized void abort(int i10) {
        try {
            C11839m.m70688i(TAG, "do abort: " + i10);
            if (!CBAccess.manualAbort(i10)) {
                CBAccess.clearRestoreCacheAsync(true);
                updateCancelRestoreStatus();
                C11839m.m70688i(TAG, "abort, send restore cache clear success message");
                CBCallBack.getInstance().sendMessageDelayed(Message.obtain((Handler) null, 33015), 500L);
            }
            if (CBAccess.inRestore()) {
                updateCancelRestoreStatus();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void updateShowTag(int i10, String str) {
        new C13030i().m78499j(i10, str, 1);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.service.ICloudBackupService
    public boolean refreshBackupTimes(boolean z10) {
        return initOpr() && this.mHandler.sendEmptyMessage(15);
    }
}
