package com.huawei.android.hicloud.cloudbackup.process;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBLockTimer;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.common.receiver.FlowControlReceiver;
import com.huawei.hicloud.request.cbs.bean.CBSLockAndFlowControlReq;
import com.huawei.hicloud.request.cbs.bean.CBSLockAndFlowControlResp;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p458lo.C11322a;
import p514o9.C11839m;
import p616rk.C12515a;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes2.dex */
public class CBLockAndFlowControlManager {
    private static final long DEFAULT_LOCKINTERVAL = 600;
    private static final long DOWN_LOCKINTERVAL = 60;
    private static final Object NO_NETWORK_KEEPLOCK_SET_LOCK = new Object();
    private static final String TAG = "CBLockAndFlowControlManager";
    private static final long UP_LOCKINTERVAL = 3600;
    private String backupId;
    private C13029h mBackupTags;
    private C11322a mCBSService;
    private CBSbkFlowHead mCBSbkFlowHead;
    private CBSLockAndFlowControlReq mFlowControlReq;
    private ProgressCallback mProgressCallback;
    private boolean noNetWorkKeeplock = false;

    public CBLockAndFlowControlManager(ProgressCallback progressCallback, CBSbkFlowHead cBSbkFlowHead, CBSLockAndFlowControlReq cBSLockAndFlowControlReq, C11322a c11322a, C13029h c13029h) {
        this.mProgressCallback = progressCallback;
        this.mCBSbkFlowHead = cBSbkFlowHead;
        this.mFlowControlReq = cBSLockAndFlowControlReq;
        this.mCBSService = c11322a;
        this.mBackupTags = c13029h;
    }

    public static void cancelAlarm(Context context) {
        C11839m.m70688i(TAG, "cancel flow control alarm");
        ((AlarmManager) context.getSystemService("alarm")).cancel(getAlarmPendingIntent(context, CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_ACTION, CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_CLENT_ID));
    }

    private long checkInterval(long j10) {
        return (j10 > UP_LOCKINTERVAL || j10 < 60) ? DEFAULT_LOCKINTERVAL : j10;
    }

    private static PendingIntent getAlarmPendingIntent(Context context, String str, int i10) {
        Intent intent = new Intent(context, (Class<?>) FlowControlReceiver.class);
        intent.setAction(str);
        return PendingIntent.getBroadcast(context, i10, intent, 1073741824);
    }

    public static String getChargeMode() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Context contextM1377a = C0213f.m1377a();
        String str = "none";
        if (contextM1377a == null) {
            return "none";
        }
        SafeIntent safeIntent = new SafeIntent(contextM1377a.registerReceiver(null, intentFilter));
        int intExtra = safeIntent.getIntExtra("status", -1);
        boolean z10 = intExtra == 2 || intExtra == 5;
        if (z10) {
            int intExtra2 = safeIntent.getIntExtra("plugged", -1);
            if (intExtra2 == 1 || intExtra2 == 2) {
                str = CBSbkFlowHead.CHARGE_MODE_WIRE;
            } else if (intExtra2 == 4) {
                str = CBSbkFlowHead.CHARGE_MODE_WIRELESS;
            }
        }
        C11839m.m70688i(TAG, "getChargeMode: " + z10 + ", status: " + intExtra + ", chargePlug: " + str);
        return str;
    }

    private void handleBackupFlowControl() throws C9721b {
        notEmpty(this.mCBSbkFlowHead, "handleBackupFlowControl mCBSbkFlowHead is null");
        notEmpty(this.mBackupTags, "handleBackupFlowControl mBackupTags is null");
        C13030i c13030i = new C13030i();
        int iM1685c = C0241z.m1685c(this.mCBSbkFlowHead.getFlowControlCnt());
        C11839m.m70688i(TAG, "handleBackupFlowControl flowControlCnt = " + iM1685c);
        this.mBackupTags.m78455U(String.valueOf(iM1685c + 1));
        c13030i.m78496g(this.mBackupTags);
        throw new C9721b(SNSCode.Status.GET_FRIEND_LIST_FAIL, "flow control");
    }

    private void handleBackupRecordNotExist() throws C9721b {
        notEmpty(this.mFlowControlReq, "handleBackupRecordNotExist mFlowControlReq is null");
        SnapshotTreeManagementService.getInstance().deleteSnapshotDB(this.mFlowControlReq.getBackupId());
        throw new C9721b(3109, "cbs record is not exist");
    }

    private void handleBackupServerErr(int i10, String str) throws C9721b {
        C11839m.m70688i(TAG, "handleBackupServerErr retryTimes=" + i10);
        if (i10 > 2) {
            handleBackupFlowControl();
        } else {
            waitRetry(i10);
            keepLock(i10 + 1, str);
        }
    }

    private void handleReqSuccess(long j10) throws C9721b {
        C13029h c13029h = this.mBackupTags;
        if (c13029h != null && C0241z.m1685c(c13029h.m78480t()) != 0) {
            C11839m.m70688i(TAG, "handleReqSuccess clear tag flowcontrol count");
            C13030i c13030i = new C13030i();
            this.mBackupTags.m78455U(String.valueOf(0));
            c13030i.m78496g(this.mBackupTags);
        }
        startNextDelayTask(j10);
    }

    private static void notEmpty(Object obj, String str) throws C9721b {
        if (obj == null) {
            throw new C9721b(1009, str);
        }
    }

    private static void release() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        cancelAlarm(contextM1377a);
    }

    private void waitRetry(int i10) {
        int i11 = i10 * 60;
        for (int i12 = 0; i12 < i11 && !this.mProgressCallback.onStop(); i12++) {
            SystemClock.sleep(1000L);
        }
    }

    public void cancel() {
        release();
        CBSLockAndFlowControlReq cBSLockAndFlowControlReq = this.mFlowControlReq;
        if (cBSLockAndFlowControlReq == null || this.mCBSbkFlowHead == null) {
            C11839m.m70689w(TAG, "cancel unlock error mFlowControlReq or mCBSbkFlowHead is null");
            return;
        }
        CBLockTimer.CBUnLockTask cBUnLockTask = new CBLockTimer.CBUnLockTask(this.mCBSService, cBSLockAndFlowControlReq.getTheDeviceId(), this.mFlowControlReq.getDeviceType(), this.mFlowControlReq.getLockType());
        cBUnLockTask.setBackupId(this.backupId);
        C12515a.m75110o().m75172d(cBUnLockTask);
    }

    public boolean isNoNetWorkKeeplock() {
        boolean z10;
        synchronized (NO_NETWORK_KEEPLOCK_SET_LOCK) {
            z10 = this.noNetWorkKeeplock;
        }
        return z10;
    }

    public void keepLock(int i10, String str) throws C9721b {
        BackupPowerKitKeepTimer.getInstance().keepAlive(str);
        setNoNetWorkKeeplock(false);
        Context contextM1377a = C0213f.m1377a();
        notEmpty(contextM1377a, "keeplock context is null");
        notEmpty(this.mCBSService, "keeplock mCBSService is null");
        notEmpty(this.mCBSbkFlowHead, "keeplock mCBSbkFlowHead is null");
        notEmpty(this.mFlowControlReq, "keeplock mFlowControlReq is null");
        if (!C0209d.m1254f2(contextM1377a) && CBAccess.isAppDataPreparing()) {
            C11839m.m70687e(TAG, "cbsLockAndFlowControlResp result not success while prepare data no network");
            setNoNetWorkKeeplock(true);
            return;
        }
        this.mCBSbkFlowHead.setChargeMode(getChargeMode());
        this.mCBSbkFlowHead.setNetwork(C0209d.m1228Z(C0209d.m1225Y(C0213f.m1377a())));
        C11839m.m70686d(TAG, "startNewLock mCBSbkFlowHead = " + this.mCBSbkFlowHead + " ,mFlowControlReq = " + this.mFlowControlReq);
        CBSLockAndFlowControlResp cBSLockAndFlowControlRespM68036x = this.mCBSService.m68036x(this.mCBSbkFlowHead, this.mFlowControlReq);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("endNewLock cbsLockAndFlowControlResp = ");
        sb2.append(cBSLockAndFlowControlRespM68036x);
        C11839m.m70686d(TAG, sb2.toString());
        notEmpty(cBSLockAndFlowControlRespM68036x, "cbsLockAndFlowControlResp is null");
        int result = cBSLockAndFlowControlRespM68036x.getResult();
        C11839m.m70688i(TAG, "processGetCmd result: " + result);
        if (result == 0) {
            handleReqSuccess(cBSLockAndFlowControlRespM68036x.getLockInterval());
            return;
        }
        if (result == 503) {
            handleBackupServerErr(i10, str);
            return;
        }
        if (result == 506) {
            handleBackupFlowControl();
            return;
        }
        if (result == 601) {
            handleBackupRecordNotExist();
            return;
        }
        C11839m.m70687e(TAG, "cbsLockAndFlowControlResp result is not success");
        throw new C9721b(3112, "keeplock error " + result);
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setNoNetWorkKeeplock(boolean z10) {
        synchronized (NO_NETWORK_KEEPLOCK_SET_LOCK) {
            this.noNetWorkKeeplock = z10;
        }
    }

    public void startNextDelayTask(long j10) throws C9721b {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        cancelAlarm(contextM1377a);
        AlarmManager alarmManager = (AlarmManager) contextM1377a.getSystemService("alarm");
        PendingIntent alarmPendingIntent = getAlarmPendingIntent(contextM1377a, CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_ACTION, CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_CLENT_ID);
        long jCheckInterval = checkInterval(j10);
        C11839m.m70688i(TAG, "startNextDelayTask intervalAfterCheck=" + jCheckInterval + ",lockInterval=" + j10);
        alarmManager.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + (jCheckInterval * 1000), alarmPendingIntent);
    }
}
