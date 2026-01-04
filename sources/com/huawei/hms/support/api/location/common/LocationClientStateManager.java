package com.huawei.hms.support.api.location.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.locationSdk.C5733l1;
import com.huawei.hms.locationSdk.C5768x0;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class LocationClientStateManager {
    private static final int CP_PERMISSION_DENIED = 10803;
    private static final int DELAY_MSG_CHECK_TIME = 12000;
    private static final int DELAY_TIME = 300;
    private static final int INTERNAL_ERROR = 10000;
    public static final String IS_RE_REQUEST = "isReRequest";
    private static final String LOCATIONAVAILABILITY_EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_AVAILABILITY";
    private static final long MAX_INTERVAL_TIME = 300000;
    private static final int MAX_RECONNECT_COUNT = 3;
    private static final int MSG_RESTART = 1001;
    private static final int MSG_RESTART_DELAY_CHECK = 1002;
    private static final int PERMISSION_DENIED = 10102;
    private static final long REPEAT_REQUEST_INTERVAL_TIME = 500;
    public static final int RE_START_STATE_DOING = 1;
    public static final int RE_START_STATE_FAILED = 2;
    public static final int RE_START_STATE_INITIAL = 0;
    private static final String TAG = "LocationClientStateManager";
    private Handler handler;
    private volatile AtomicLong lastDisConnectTime;
    private volatile AtomicInteger reConnectCount;
    private volatile AtomicInteger resendState;

    /* renamed from: com.huawei.hms.support.api.location.common.LocationClientStateManager$a */
    public class C6330a implements InterfaceC8938f {

        /* renamed from: a */
        final /* synthetic */ LocationCallback f29806a;

        /* renamed from: b */
        final /* synthetic */ PendingIntent f29807b;

        public C6330a(LocationCallback locationCallback, PendingIntent pendingIntent) {
            this.f29806a = locationCallback;
            this.f29807b = pendingIntent;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) throws PendingIntent.CanceledException {
            HMSLog.m36986e(LocationClientStateManager.TAG, "task request onFailure");
            LocationClientStateManager.this.handler.removeMessages(1002);
            LocationClientStateManager.this.handlerOnFailureMsg(exc, this.f29806a, this.f29807b);
            LocationClientStateManager.getInstance().setResendState(2);
        }
    }

    /* renamed from: com.huawei.hms.support.api.location.common.LocationClientStateManager$b */
    public class C6331b implements InterfaceC8939g<Void> {
        public C6331b() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(Void r22) {
            HMSLog.m36988i(LocationClientStateManager.TAG, "task request onSuccess");
            LocationClientStateManager.this.handler.removeMessages(1002);
            LocationClientStateManager.getInstance().setResendState(0);
        }
    }

    /* renamed from: com.huawei.hms.support.api.location.common.LocationClientStateManager$c */
    public class C6332c implements Handler.Callback {
        public C6332c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1001) {
                if (i10 != 1002) {
                    return false;
                }
                LocationClientStateManager.this.checkReSendState();
                return false;
            }
            LocationClientStateManager.this.handler.removeMessages(1002);
            LocationClientStateManager.this.handler.sendEmptyMessageDelayed(1002, 12000L);
            LocationClientStateManager.this.reSendRequest();
            return false;
        }
    }

    /* renamed from: com.huawei.hms.support.api.location.common.LocationClientStateManager$d */
    public static class C6333d {

        /* renamed from: a */
        private static final LocationClientStateManager f29811a = new LocationClientStateManager(null);
    }

    private LocationClientStateManager() {
        this.lastDisConnectTime = new AtomicLong(0L);
        this.reConnectCount = new AtomicInteger(0);
        this.resendState = new AtomicInteger(0);
    }

    private void addListener(Task<Void> task, LocationCallback locationCallback, PendingIntent pendingIntent) {
        task.addOnSuccessListener(new C6331b()).addOnFailureListener(new C6330a(locationCallback, pendingIntent));
    }

    private boolean canResendRequest() {
        return this.resendState.get() == 2 || this.resendState.get() == 0;
    }

    private boolean checkCanResendRequest() {
        return checkReconnectStrategy() && canResendRequest();
    }

    public void checkReSendState() {
        if (getInstance().getResendState() == 1) {
            getInstance().setResendState(2);
            HMSLog.m36986e(TAG, "reSend request time out ,reset state to RE_START_STATE_FAILED");
        }
    }

    private boolean checkReconnectStrategy() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.lastDisConnectTime.get() < 500) {
            HMSLog.m36986e(TAG, "can not reconnect , not satisfied interval");
            return false;
        }
        if (this.reConnectCount.get() == 0) {
            this.lastDisConnectTime.set(jElapsedRealtime);
            this.reConnectCount.incrementAndGet();
            HMSLog.m36988i(TAG, "first reconnect");
            return true;
        }
        if (jElapsedRealtime - this.lastDisConnectTime.get() > 300000) {
            this.reConnectCount.set(1);
            this.lastDisConnectTime.set(jElapsedRealtime);
            HMSLog.m36988i(TAG, "over MAX_INTERVAL_TIME , restart first reconnect");
            return true;
        }
        if (this.reConnectCount.get() >= 3) {
            this.lastDisConnectTime.set(jElapsedRealtime);
            HMSLog.m36988i(TAG, "can not reconnect , cause count > MAX_RECONNECT_COUNT");
            return false;
        }
        HMSLog.m36988i(TAG, "can reconnect");
        this.lastDisConnectTime.set(jElapsedRealtime);
        this.reConnectCount.incrementAndGet();
        return true;
    }

    public static LocationClientStateManager getInstance() {
        return C6333d.f29811a;
    }

    public void handlerOnFailureMsg(Exception exc, LocationCallback locationCallback, PendingIntent pendingIntent) throws PendingIntent.CanceledException {
        String str;
        try {
            if (exc instanceof ApiException) {
                ApiException apiException = (ApiException) exc;
                int statusCode = apiException.getStatusCode();
                if (statusCode != 10000 && statusCode != 10102 && statusCode != 10803) {
                    if (statusCode != 907135004) {
                        return;
                    }
                    HMSLog.m36986e(TAG, "task request onFailure from HMS and checkRestart");
                    checkCanResend();
                    return;
                }
                if (locationCallback != null) {
                    LocationAvailability locationAvailability = new LocationAvailability();
                    locationAvailability.setLocationStatus(1001);
                    locationCallback.onLocationAvailability(locationAvailability);
                    HMSLog.m36986e(TAG, "task request onFailure from Location and callback to cp ,errorCode " + apiException.getStatusCode());
                }
                if (pendingIntent == null) {
                    return;
                }
                Intent intent = new Intent();
                LocationAvailability locationAvailability2 = new LocationAvailability();
                locationAvailability2.setLocationStatus(1001);
                intent.putExtra(LOCATIONAVAILABILITY_EXTRA_KEY, locationAvailability2);
                pendingIntent.send(C11991a.m72145a(), 0, intent);
                str = "task request onFailure from Location and pendingIntent to cp ,errorCode " + apiException.getStatusCode();
            } else {
                str = "handlerOnFailureMsg failed by instanceof failed";
            }
            HMSLog.m36986e(TAG, str);
        } catch (Exception unused) {
            HMSLog.m36986e(TAG, "handlerOnFailureMsg failed by exception");
        }
    }

    private void initHandler() {
        if (this.handler == null) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper(), new C6332c());
        }
    }

    public void reSendRequest() {
        try {
            List<C5733l1> listM33191a = C5768x0.m33197b().m33191a();
            if (CollectionsUtil.isEmpty(listM33191a)) {
                HMSLog.m36988i(TAG, "onConnected, requests cache list is empty remove delay check msg");
                this.handler.removeMessages(1002);
                getInstance().setResendState(0);
                return;
            }
            HMSLog.m36988i(TAG, "request cache list size:" + listM33191a.size());
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(C11991a.m72145a());
            for (C5733l1 c5733l1 : listM33191a) {
                HMSLocationLog.m36662i(TAG, c5733l1.m33186a(), "onConnected, request in cache list prepare to send");
                realRequest(fusedLocationProviderClient, c5733l1);
            }
        } catch (Exception unused) {
            getInstance().setResendState(2);
            HMSLog.m36986e(TAG, "onConnected exception");
        }
    }

    private void realRequest(FusedLocationProviderClient fusedLocationProviderClient, C5733l1 c5733l1) {
        Task<Void> taskRequestLocationUpdates;
        String strM33186a;
        String str;
        LocationCallback locationCallbackM33121c = c5733l1.m33121c();
        LocationRequest locationRequestM33122d = c5733l1.m33122d();
        PendingIntent pendingIntentM33119b = c5733l1.m33119b();
        if (locationRequestM33122d == null) {
            getInstance().setResendState(0);
            strM33186a = c5733l1.m33186a();
            str = "onConnected, requests cache list param is error,need remove";
        } else {
            if (locationRequestM33122d.getExpirationTime() - SystemClock.elapsedRealtime() >= 100) {
                locationRequestM33122d.putExtras(IS_RE_REQUEST, "1");
                if (locationCallbackM33121c != null) {
                    if (TextUtils.equals(c5733l1.m33124f(), "ExCallback")) {
                        HMSLocationLog.m36662i(TAG, c5733l1.m33186a(), "send ex location request");
                        taskRequestLocationUpdates = fusedLocationProviderClient.requestLocationUpdatesEx(locationRequestM33122d, locationCallbackM33121c, c5733l1.m33123e());
                    } else {
                        HMSLocationLog.m36662i(TAG, c5733l1.m33186a(), "send location request");
                        taskRequestLocationUpdates = fusedLocationProviderClient.requestLocationUpdates(locationRequestM33122d, locationCallbackM33121c, c5733l1.m33123e());
                    }
                    addListener(taskRequestLocationUpdates, locationCallbackM33121c, null);
                    return;
                }
                if (pendingIntentM33119b != null) {
                    addListener(fusedLocationProviderClient.requestLocationUpdates(locationRequestM33122d, pendingIntentM33119b), null, pendingIntentM33119b);
                    return;
                }
                getInstance().setResendState(0);
                HMSLocationLog.m36663w(TAG, c5733l1.m33186a(), "onConnected, requests cache list param is error");
                C5768x0.m33197b().mo33194c(c5733l1);
                this.handler.removeMessages(1002);
                getInstance().setResendState(0);
                return;
            }
            strM33186a = c5733l1.m33186a();
            str = "onConnected, requests cache list is expire,need remove";
        }
        HMSLocationLog.m36663w(TAG, strM33186a, str);
        C5768x0.m33197b().mo33194c(c5733l1);
        this.handler.removeMessages(1002);
        getInstance().setResendState(0);
    }

    public void setResendState(int i10) {
        this.resendState.set(i10);
    }

    public synchronized void checkCanResend() {
        try {
            boolean zCheckCanResendRequest = getInstance().checkCanResendRequest();
            if (zCheckCanResendRequest) {
                reStartHmsLocation();
            }
            HMSLog.m36988i(TAG, "checkCanResend:" + zCheckCanResendRequest + ",reStartHmsLocation restartState：" + getInstance().getResendState());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized int getResendState() {
        return this.resendState.get();
    }

    public synchronized void reStartHmsLocation() {
        HMSLog.m36988i(TAG, "reStartHmsLocation restartState：" + getInstance().getResendState());
        getInstance().setResendState(1);
        initHandler();
        this.handler.sendEmptyMessageDelayed(1001, 300L);
    }

    public synchronized void resetCache() {
        if (this.reConnectCount.get() == 0 && this.lastDisConnectTime.get() == 0) {
            HMSLog.m36988i(TAG, "not need resetCache");
            return;
        }
        HMSLog.m36988i(TAG, "resetCache");
        this.lastDisConnectTime.set(0L);
        this.reConnectCount.set(0);
    }

    public /* synthetic */ LocationClientStateManager(C6330a c6330a) {
        this();
    }
}
