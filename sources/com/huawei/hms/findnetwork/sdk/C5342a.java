package com.huawei.hms.findnetwork.sdk;

import android.content.Context;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.huawei.hiar.ARCamera;
import com.huawei.hiar.ARConfigBase;
import com.huawei.hiar.AREnginesApk;
import com.huawei.hiar.ARFrame;
import com.huawei.hiar.ARPose;
import com.huawei.hiar.ARSession;
import com.huawei.hiar.ARTrackable;
import com.huawei.hiar.ARWorldTrackingConfig;
import com.huawei.hms.findnetwork.comm.util.ErrorCode;
import com.huawei.hms.findnetwork.threadpool.ThreadExec;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.findnetwork.sdk.a */
/* loaded from: classes8.dex */
public class C5342a {

    /* renamed from: a */
    public ARSession f24750a;

    /* renamed from: b */
    public ARTrackable.TrackingState f24751b;

    /* renamed from: com.huawei.hms.findnetwork.sdk.a$b */
    public static final class b {

        /* renamed from: a */
        public static final C5342a f24752a = new C5342a();
    }

    public C5342a() {
    }

    /* renamed from: c */
    public static C5342a m31942c() {
        return b.f24752a;
    }

    /* renamed from: b */
    public synchronized int m31945b(Context context) {
        HmsFindSDKLog.m32127i("ArEngineHelper", "initArEngine");
        int iM31943a = m31943a(context);
        if (iM31943a != 0) {
            HmsFindSDKLog.m32126e("ArEngineHelper", "checkCondition failed: " + iM31943a);
            return iM31943a;
        }
        if (this.f24750a == null) {
            try {
                this.f24750a = new ARSession(context);
                final ARWorldTrackingConfig aRWorldTrackingConfig = new ARWorldTrackingConfig(this.f24750a);
                aRWorldTrackingConfig.setPlaneFindingMode(ARConfigBase.PlaneFindingMode.DISABLED);
                aRWorldTrackingConfig.setUpdateMode(ARConfigBase.UpdateMode.LATEST_CAMERA_IMAGE);
                aRWorldTrackingConfig.setPowerMode(ARConfigBase.PowerMode.ULTRA_POWER_SAVING);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                ThreadExec.execNormalTask("ArEngineHelper", new Runnable() { // from class: fq.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f47993a.m31940a(aRWorldTrackingConfig, countDownLatch);
                    }
                });
                if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                    HmsFindSDKLog.m32126e("ArEngineHelper", "arSession configure await timeout.");
                    return ErrorCode.CODE_UNKNOWN_ERROR;
                }
            } catch (Exception e10) {
                HmsFindSDKLog.m32126e("ArEngineHelper", "initArEngine error, " + e10);
                return ErrorCode.CODE_UNKNOWN_ERROR;
            }
        }
        HmsFindSDKLog.m32127i("ArEngineHelper", "arSession resume");
        this.f24750a.resume();
        return 0;
    }

    /* renamed from: d */
    public ARTrackable.TrackingState m31948d() {
        return this.f24751b;
    }

    /* renamed from: a */
    public final int m31943a(Context context) {
        if (context == null) {
            HmsFindSDKLog.m32126e("ArEngineHelper", "context is null.");
            return ErrorCode.CODE_PARAMETER_INVALID;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") != 0) {
            HmsFindSDKLog.m32126e("ArEngineHelper", "android.permission.CAMERA not granted.");
            return ErrorCode.CODE_NO_CAMERA_PERMISSION;
        }
        if (AREnginesApk.isAREngineApkReady(context)) {
            return 0;
        }
        HmsFindSDKLog.m32126e("ArEngineHelper", "AR Engine app not installed.");
        return ErrorCode.CODE_AR_ENGINE_APP_NOT_INSTALLED;
    }

    /* renamed from: b */
    public synchronized Pair<Integer, ARPose> m31946b() {
        ARFrame aRFrameUpdate;
        String str;
        String str2;
        ARSession aRSession = this.f24750a;
        int i10 = ErrorCode.CODE_UNKNOWN_ERROR;
        if (aRSession == null) {
            HmsFindSDKLog.m32127i("ArEngineHelper", "ArSession is null.");
            return new Pair<>(Integer.valueOf(ErrorCode.CODE_UNKNOWN_ERROR), null);
        }
        try {
            aRFrameUpdate = aRSession.update();
        } catch (Throwable th2) {
            HmsFindSDKLog.m32126e("ArEngineHelper", "ArSession.update exception:" + th2.getMessage());
            aRFrameUpdate = null;
        }
        if (aRFrameUpdate == null) {
            HmsFindSDKLog.m32126e("ArEngineHelper", "ARFrame is null.");
            return new Pair<>(Integer.valueOf(ErrorCode.CODE_UNKNOWN_ERROR), null);
        }
        ARCamera camera = aRFrameUpdate.getCamera();
        if (camera == null) {
            HmsFindSDKLog.m32126e("ArEngineHelper", "ARCamera is null.");
            return new Pair<>(Integer.valueOf(ErrorCode.CODE_UNKNOWN_ERROR), null);
        }
        ARTrackable.TrackingState trackingState = camera.getTrackingState();
        this.f24751b = trackingState;
        if (trackingState == ARTrackable.TrackingState.TRACKING) {
            HmsFindSDKLog.m32127i("ArEngineHelper", "TrackingState.TRACKING");
            i10 = 0;
        } else if (trackingState == ARTrackable.TrackingState.PAUSED) {
            HmsFindSDKLog.m32128w("ArEngineHelper", "TrackingState.PAUSED");
            i10 = ErrorCode.CODE_AR_ENVIRONMENT_NOT_SATISFIED;
        } else {
            if (trackingState == ARTrackable.TrackingState.STOPPED) {
                str = "ArEngineHelper";
                str2 = "TrackingState.STOPPED";
            } else {
                str = "ArEngineHelper";
                str2 = "TrackingState.UNKNOWN_STATE.";
            }
            HmsFindSDKLog.m32128w(str, str2);
        }
        return new Pair<>(Integer.valueOf(i10), camera.getPose());
    }

    /* renamed from: c */
    public boolean m31947c(Context context) {
        return AREnginesApk.isAREngineApkReady(context);
    }

    /* renamed from: a */
    public synchronized void m31944a() {
        if (this.f24750a == null) {
            return;
        }
        HmsFindSDKLog.m32127i("ArEngineHelper", "deInitArEngine");
        this.f24750a.pause();
        this.f24750a.stop();
        HmsFindSDKLog.m32127i("ArEngineHelper", "deInitArEngine end.");
        this.f24750a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31940a(ARWorldTrackingConfig aRWorldTrackingConfig, CountDownLatch countDownLatch) {
        HmsFindSDKLog.m32127i("ArEngineHelper", "arSession configure start.");
        this.f24750a.configure(aRWorldTrackingConfig);
        countDownLatch.countDown();
    }
}
