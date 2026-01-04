package com.huawei.hms.adapter.p116ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    private WeakReference<Activity> f23131a;

    /* renamed from: b */
    private String f23132b = "";

    /* renamed from: c */
    private long f23133c = 0;

    /* renamed from: a */
    private void m30213a(long j10) throws JSONException {
        if (!RegionUtils.isChinaROM(m30216c())) {
            HMSLog.m36988i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity activityM30216c = m30216c();
        if (activityM30216c == null || activityM30216c.isFinishing()) {
            return;
        }
        HashMap map = new HashMap();
        map.put("package", activityM30216c.getPackageName());
        map.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f23133c + "-" + j10);
        HiAnalyticsUtils.getInstance().onEvent(activityM30216c, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, map);
        HMSLog.m36986e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f23132b + ", carriedTimeStamp: " + this.f23133c + ", savedTimeStamp: " + j10);
    }

    /* renamed from: b */
    private void m30215b() {
        Activity activityM30216c = m30216c();
        if (activityM30216c == null || activityM30216c.isFinishing()) {
            return;
        }
        activityM30216c.finish();
    }

    /* renamed from: c */
    private Activity m30216c() {
        WeakReference<Activity> weakReference = this.f23131a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: d */
    private void m30217d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f23132b);
        m30215b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBridgeActivityCreate(android.app.Activity r10) throws android.content.IntentSender.SendIntentException {
        /*
            r9 = this;
            java.lang.String r0 = "BaseResolutionAdapter"
            if (r10 != 0) goto Ld
            java.lang.String r10 = "activity is null"
            com.huawei.hms.support.log.HMSLog.m36986e(r0, r10)
            r9.m30217d()
            return
        Ld:
            boolean r1 = r10.isFinishing()
            if (r1 == 0) goto L19
            java.lang.String r9 = "activity is finishing"
            com.huawei.hms.support.log.HMSLog.m36986e(r0, r9)
            return
        L19:
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r10)
            r9.f23131a = r1
            android.content.Intent r1 = r10.getIntent()
            if (r1 != 0) goto L2a
            r9.m30217d()
            return
        L2a:
            android.os.Bundle r2 = r1.getExtras()     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "transaction_id"
            java.lang.String r3 = r1.getStringExtra(r3)     // Catch: java.lang.Throwable -> L41
            r9.f23132b = r3     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "resolution_flag"
            r4 = 0
            long r3 = r1.getLongExtra(r3, r4)     // Catch: java.lang.Throwable -> L41
            r9.f23133c = r3     // Catch: java.lang.Throwable -> L41
            goto L61
        L41:
            r1 = move-exception
            goto L45
        L43:
            r1 = move-exception
            r2 = 0
        L45:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "get transaction_id or resolution_flag exception:"
            r3.append(r4)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.hms.support.log.HMSLog.m36986e(r0, r1)
        L61:
            boolean r1 = r9.m30214a()
            if (r1 != 0) goto L6b
            r9.m30217d()
            return
        L6b:
            java.lang.String r1 = r9.f23132b
            if (r1 == 0) goto L7d
            java.lang.String r1 = "remove apk resolution failed task."
            com.huawei.hms.support.log.HMSLog.m36988i(r0, r1)
            com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager r1 = com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager.getInstance()
            java.lang.String r3 = r9.f23132b
            r1.removeTask(r3)
        L7d:
            if (r2 != 0) goto L83
            r9.m30217d()
            return
        L83:
            java.lang.String r1 = "resolution"
            android.os.Parcelable r1 = r2.getParcelable(r1)
            if (r1 != 0) goto L8f
            r9.m30217d()
            return
        L8f:
            boolean r2 = r1 instanceof android.content.Intent
            if (r2 == 0) goto La8
            android.content.Intent r1 = (android.content.Intent) r1     // Catch: java.lang.Throwable -> L9f
            android.content.Intent r1 = com.huawei.hms.utils.IntentUtil.modifyIntentBehaviorsSafe(r1)     // Catch: java.lang.Throwable -> L9f
            r2 = 1001(0x3e9, float:1.403E-42)
            r10.startActivityForResult(r1, r2)     // Catch: java.lang.Throwable -> L9f
            goto Lc5
        L9f:
            r9.m30217d()
            java.lang.String r9 = "ActivityNotFoundException:exception"
            com.huawei.hms.support.log.HMSLog.m36986e(r0, r9)
            goto Lc5
        La8:
            boolean r2 = r1 instanceof android.app.PendingIntent
            if (r2 == 0) goto Lc5
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1     // Catch: android.content.IntentSender.SendIntentException -> Lbd
            android.content.IntentSender r3 = r1.getIntentSender()     // Catch: android.content.IntentSender.SendIntentException -> Lbd
            r7 = 0
            r8 = 0
            r4 = 1001(0x3e9, float:1.403E-42)
            r5 = 0
            r6 = 0
            r2 = r10
            r2.startIntentSenderForResult(r3, r4, r5, r6, r7, r8)     // Catch: android.content.IntentSender.SendIntentException -> Lbd
            goto Lc5
        Lbd:
            r9.m30217d()
            java.lang.String r9 = "SendIntentException:exception"
            com.huawei.hms.support.log.HMSLog.m36986e(r0, r9)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.p116ui.BaseResolutionAdapter.onBridgeActivityCreate(android.app.Activity):void");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m36988i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f23131a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i10, int i11, Intent intent) {
        if (i10 != getRequestCode()) {
            return false;
        }
        HMSLog.m36988i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i11);
        if (i11 == 1001 || i11 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i11);
        }
        if (i11 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f23132b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(null, this.f23132b);
        }
        m30215b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m36988i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i10, KeyEvent keyEvent) {
        HMSLog.m36988i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    private boolean m30214a() throws JSONException {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f23132b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f23132b);
        if (resolutionFlag != 0 && resolutionFlag == this.f23133c) {
            return true;
        }
        m30213a(resolutionFlag);
        return false;
    }
}
