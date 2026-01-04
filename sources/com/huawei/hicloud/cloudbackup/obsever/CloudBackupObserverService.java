package com.huawei.hicloud.cloudbackup.obsever;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.service.CBNotifyTimer;
import com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p015ak.C0206b0;
import p015ak.C0209d;
import p015ak.C0214f0;
import p514o9.C11839m;
import p529op.C11979a;
import p552pd.C12129a;
import p552pd.C12130b;
import p616rk.C12515a;
import p617rl.C12526j;
import p664u0.C13108a;
import p711vl.C13464d;

/* loaded from: classes6.dex */
public class CloudBackupObserverService extends Service {

    /* renamed from: a */
    public Context f22279a = null;

    /* renamed from: b */
    public C12130b f22280b = null;

    /* renamed from: c */
    public ObserverReceiver f22281c = null;

    /* renamed from: d */
    public BroadcastReceiver f22282d = null;

    /* renamed from: e */
    public BroadcastReceiver f22283e = null;

    /* renamed from: f */
    public boolean f22284f = false;

    /* renamed from: g */
    public boolean f22285g = false;

    /* renamed from: h */
    public Handler f22286h = null;

    /* renamed from: i */
    public C12129a f22287i;

    public class CBObserverReceiver extends BroadcastReceiver {
        public CBObserverReceiver() {
        }

        /* renamed from: a */
        public final void m29256a() {
            C11839m.m70688i("CloudBackupObserverService", "doGetOptionsFromClone");
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(CloudBackupObserverService.this.getApplicationContext(), "cloudbackupreport", 0);
            long j10 = sharedPreferencesM1382b.getLong("lastPowerConnectTime", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11839m.m70688i("CloudBackupObserverService", "lastPowerConnectTime: " + j10 + ", currentTime: " + jCurrentTimeMillis);
            if (jCurrentTimeMillis - j10 >= 86400000) {
                ICBServiceProtocol.getInstance().doGetBackupOptions();
                sharedPreferencesM1382b.edit().putLong("lastPowerConnectTime", System.currentTimeMillis()).apply();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                try {
                    intExtra = intent.getIntExtra("status", 1);
                } catch (RuntimeException unused) {
                    C11839m.m70688i("CloudBackupObserverService", "intent Serializable error.");
                    intExtra = 1;
                }
                if (intExtra != 2) {
                    if (intExtra == 3 || intExtra == 4) {
                        CloudBackupObserverService.this.f22284f = false;
                        CloudBackupObserverService.this.f22280b.m72710A(false);
                        return;
                    } else if (intExtra != 5) {
                        return;
                    }
                }
                CloudBackupObserverService.this.f22284f = true;
                CloudBackupObserverService.this.f22280b.m72710A(true);
                m29256a();
                return;
            }
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                C11839m.m70688i("CloudBackupObserverService", "action screen on.");
                CloudBackupObserverService.this.f22280b.m72713D(true);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C11839m.m70688i("CloudBackupObserverService", "action screen off.");
                CloudBackupObserverService.this.f22285g = false;
                CloudBackupObserverService.this.f22280b.m72713D(false);
                if (CloudBackupObserverService.this.m29250u()) {
                    CloudBackupObserverService.this.f22286h.removeMessages(3204);
                    C11839m.m70688i("CloudBackupObserverService", "removeMessages ACTION_SCREEN_OFF");
                    return;
                }
                return;
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                C11839m.m70688i("CloudBackupObserverService", "action user present");
                CloudBackupObserverService.this.f22285g = true;
                if (!CloudBackupObserverService.this.m29250u()) {
                    ICBServiceProtocol.getInstance().doAbort(1);
                    CloudBackupObserverService.this.m29243C();
                    CloudBackupObserverService.this.f22286h.removeMessages(3204);
                    return;
                }
                Message message = new Message();
                message.what = 3204;
                message.arg1 = 1;
                long jM75338H = new C12526j().m75338H(C13464d.m81030f(CloudBackupObserverService.this.getApplicationContext()).m81037h("breakedtime"));
                CloudBackupObserverService.this.f22286h.sendMessageDelayed(message, jM75338H);
                C11839m.m70688i("CloudBackupObserverService", "sendMessageDelayed isUserPresent,isCharging, break time = " + jM75338H);
            }
        }
    }

    public class CBObserverTimerReceiver extends BroadcastReceiver {
        public CBObserverTimerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            if (!"com.huawei.hicloud.intent.action.CB_OBSERVER_TIMER_REGISTER".equals(action)) {
                if ("com.huawei.hicloud.intent.action.CB_OBSERVER_RESTORE_TIMER_REGISTER_OR_UNREGISTER".equals(action)) {
                    boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("paramter_restore_timer_register_or_unregister", false);
                    C11839m.m70688i("CloudBackupObserverService", "CBObserverTimerReceiver restore, isRegisterTimer: " + booleanExtra);
                    if (!booleanExtra) {
                        CloudBackupObserverService.this.m29245E();
                        return;
                    }
                    long longExtra = hiCloudSafeIntent.getLongExtra("paramter_restore_timer_delay_duration", 0L);
                    C11839m.m70688i("CloudBackupObserverService", "CBObserverTimerReceiver restore, delaytime: " + longExtra);
                    CloudBackupObserverService.this.m29242B(longExtra);
                    return;
                }
                return;
            }
            C11839m.m70688i("CloudBackupObserverService", "receive action: " + action);
            if (CloudBackupObserverService.this.f22280b != null) {
                CloudBackupObserverService.this.f22280b.m72731t();
                CloudBackupObserverService.this.f22280b.cancel();
            }
            long longExtra2 = hiCloudSafeIntent.getLongExtra("checkInterval", 2L);
            long longExtra3 = hiCloudSafeIntent.getLongExtra("delayedstarttime", 0L);
            long longExtra4 = hiCloudSafeIntent.getLongExtra("satisfyNum", 0L);
            boolean booleanExtra2 = hiCloudSafeIntent.getBooleanExtra("isdispersed", false);
            String stringExtra = hiCloudSafeIntent.getStringExtra("cycle_check_type");
            C11839m.m70688i("CloudBackupObserverService", "CBObserverTimerReceiver, get checkInterval: " + longExtra2 + ", delayTime = " + longExtra3 + ", satifyNum = " + longExtra4 + " ,cycleType: " + stringExtra);
            CloudBackupObserverService.this.m29249t(longExtra2, longExtra4, longExtra3, booleanExtra2, stringExtra);
        }
    }

    public class ObserverReceiver extends BroadcastReceiver {
        public ObserverReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70689w("CloudBackupObserverService", "intent is empty");
                return;
            }
            String action = intent.getAction();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                CloudBackupObserverService.this.m29253x(context);
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                C11839m.m70686d("CloudBackupObserverService", "ACTION_BATTERY_CHANGED");
                CloudBackupObserverService.this.m29252w(intent);
                return;
            }
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action)) {
                C11839m.m70688i("CloudBackupObserverService", "ACTION_POWER_CONNECTED");
                if (CloudBackupObserverService.this.m29251v()) {
                    CloudBackupObserverService.this.m29255z();
                }
                if (CloudBackupObserverService.this.f22285g) {
                    return;
                }
                CloudBackupObserverService.this.f22286h.removeMessages(3204);
                return;
            }
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                C11839m.m70688i("CloudBackupObserverService", "action power disconnected.");
                CloudBackupObserverService.this.m29243C();
                CloudBackupObserverService.this.f22286h.removeMessages(3203);
                CloudBackupObserverService.this.f22286h.removeMessages(3204);
                ICBServiceProtocol.getInstance().doAbort(2);
            }
        }
    }

    /* renamed from: com.huawei.hicloud.cloudbackup.obsever.CloudBackupObserverService$a */
    public class HandlerC4871a extends Handler {
        public HandlerC4871a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3201:
                    if (C0209d.m1254f2(CloudBackupObserverService.this.f22279a)) {
                        ICBServiceProtocol.getInstance().doRestore(message.arg1);
                        break;
                    }
                    break;
                case 3202:
                    if (!C0209d.m1254f2(CloudBackupObserverService.this.f22279a)) {
                        ICBServiceProtocol.getInstance().doAbort(0);
                        break;
                    }
                    break;
                case 3203:
                    Object obj = message.obj;
                    ICBServiceProtocol.getInstance().doNewBackup(obj instanceof String ? (String) obj : "3");
                    CloudBackupObserverService.this.m29254y();
                    break;
                case 3204:
                    ICBServiceProtocol.getInstance().doAbort(1);
                    break;
            }
        }
    }

    /* renamed from: A */
    public final void m29241A() {
        if (this.f22281c == null) {
            this.f22281c = new ObserverReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            registerReceiver(this.f22281c, intentFilter);
            if (m29251v()) {
                this.f22284f = CloudBackupConditionsUtil.getChargeAttr().isCharging();
                if (m29250u()) {
                    C11839m.m70688i("CloudBackupObserverService", "registerReceiver isCharging");
                    m29255z();
                }
            }
        }
    }

    /* renamed from: B */
    public final void m29242B(long j10) {
        if (this.f22287i == null) {
            long j11 = j10 / 1000;
            C11839m.m70688i("CloudBackupObserverService", "registerRestoreTimer delayTime: " + j11);
            this.f22287i = new C12129a(getApplicationContext(), this.f22286h, j11, j11);
            C12515a.m75110o().m75172d(this.f22287i);
        }
    }

    /* renamed from: C */
    public final void m29243C() {
        C11979a.m72102l().m72111q(1);
        BroadcastReceiver broadcastReceiver = this.f22282d;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f22282d = null;
        }
        if (this.f22283e != null) {
            C13108a.m78878b(this.f22279a).m78883f(this.f22283e);
            this.f22283e = null;
        }
        C12130b c12130b = this.f22280b;
        if (c12130b != null) {
            String strM72728q = c12130b.m72728q(false, c12130b.m72718f(), C0209d.m1254f2(getApplicationContext()), this.f22280b.m72724m(), false, this.f22280b.m72723l());
            if (this.f22280b.m72717e()) {
                C11839m.m70686d("CloudBackupObserverService", "dissatisfy the auto backup condition");
                long jCurrentTimeMillis = System.currentTimeMillis();
                C12130b c12130b2 = this.f22280b;
                c12130b2.m72732u(c12130b2.m72721j(), jCurrentTimeMillis, strM72728q);
            }
            this.f22280b.m72727p(strM72728q);
            this.f22280b.m72710A(false);
            this.f22280b.m72731t();
            this.f22280b.cancel();
            this.f22280b = null;
        }
        m29245E();
    }

    /* renamed from: D */
    public final void m29244D() {
        ObserverReceiver observerReceiver = this.f22281c;
        if (observerReceiver != null) {
            unregisterReceiver(observerReceiver);
            this.f22281c = null;
        }
    }

    /* renamed from: E */
    public final void m29245E() {
        if (this.f22287i != null) {
            C11839m.m70688i("CloudBackupObserverService", "unRegisterRestoreTimer");
            this.f22287i.cancel();
            this.f22287i.m72708c();
            this.f22287i = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11839m.m70688i("CloudBackupObserverService", "**************** onCreate");
        this.f22279a = getApplicationContext();
        m29248s();
        m29241A();
        C12515a.m75110o().m75172d(new CBNotifyTimer(this.f22279a));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("CloudBackupObserverService", "**************** onDestroy");
        m29244D();
        m29243C();
        C12515a.m75110o().m75183g1();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        C11839m.m70688i("CloudBackupObserverService", "**************** onStartCommand");
        if (intent == null || !"com.huawei.hicloud.cloudbackup.observer.service".equals(intent.getAction())) {
            return 1;
        }
        m29241A();
        return 1;
    }

    /* renamed from: q */
    public final long m29246q(String str) {
        return C13464d.m81030f(this.f22279a).m81037h(str);
    }

    /* renamed from: r */
    public final long m29247r(ICycleChecker iCycleChecker) {
        return CloudBackupConditionsUtil.checkDelayTime(CloudBackupConditionsUtil.getTargetBackupTime(iCycleChecker.isCycleSatisfy(), iCycleChecker, CloudBackupConditionsUtil.isRetryIntervalSatisfy(), CloudBackupConditionsUtil.isNextBackupTimeSatisfy()));
    }

    /* renamed from: s */
    public final void m29248s() {
        Looper mainLooper = Looper.getMainLooper();
        if (this.f22286h == null) {
            this.f22286h = new HandlerC4871a(mainLooper);
        }
    }

    /* renamed from: t */
    public final void m29249t(long j10, long j11, long j12, boolean z10, String str) {
        long j13 = j12 / 1000;
        long j14 = j10 * 60;
        if (!z10) {
            j13 += j14;
        }
        long j15 = j13;
        boolean zM1131c = C0206b0.m1131c("is_hicloud_terms_confirm", this.f22279a);
        C11839m.m70688i("CloudBackupObserverService", "onStartCommand isAgreeTerms: " + zM1131c + ", delayTime seconds:" + j15 + ", cycleSeconds: " + j14);
        C12130b c12130b = this.f22280b;
        boolean zM72717e = c12130b != null ? c12130b.m72717e() : false;
        CloudBackupConditionsUtil.recordCycleCondition(str, this.f22279a);
        C12130b c12130b2 = new C12130b(this.f22279a, this.f22286h, zM1131c, j15, j14);
        this.f22280b = c12130b2;
        c12130b2.m72710A(this.f22284f);
        this.f22280b.m72712C(j11);
        this.f22280b.m72711B(zM72717e);
        long jM81037h = j10 / C13464d.m81030f(this.f22279a).m81037h("checkInterval");
        if (jM81037h >= 1) {
            this.f22280b.m72735z(jM81037h);
        }
        this.f22280b.m72713D(((PowerManager) getSystemService("power")).isScreenOn());
        C12515a.m75110o().m75172d(this.f22280b);
    }

    /* renamed from: u */
    public final boolean m29250u() {
        if (this.f22284f) {
            return true;
        }
        boolean zIsSmartCharging = CloudBackupConditionsUtil.isSmartCharging();
        C11839m.m70688i("CloudBackupObserverService", "smartCharging: " + zIsSmartCharging);
        return zIsSmartCharging;
    }

    /* renamed from: v */
    public final boolean m29251v() {
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        boolean zEquals = "interim".equals(c13464dM81030f.m81039j("backupAction", ""));
        boolean zM81033c = c13464dM81030f.m81033c("backup_key");
        C11839m.m70688i("CloudBackupObserverService", "isSwitchOn hasTempBackup: " + zEquals + " switchOn: " + zM81033c);
        return zM81033c || zEquals;
    }

    /* renamed from: w */
    public final void m29252w(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            C11839m.m70688i("CloudBackupObserverService", "batteryStatus: " + new HiCloudSafeIntent(intent).getIntExtra("status", 1));
        } catch (RuntimeException unused) {
            C11839m.m70688i("CloudBackupObserverService", "intent Serializable error.");
        }
    }

    /* renamed from: x */
    public final void m29253x(Context context) {
        C11839m.m70688i("CloudBackupObserverService", "process net changed.");
        if (!C0209d.m1254f2(context)) {
            C11839m.m70688i("CloudBackupObserverService", "send abort delayed and do pause.");
            ICBServiceProtocol.getInstance().doPause();
            this.f22286h.sendEmptyMessageDelayed(3202, 10000L);
            this.f22286h.removeMessages(3201);
            return;
        }
        C11839m.m70688i("CloudBackupObserverService", "send restore message delayed.");
        Message messageObtain = Message.obtain();
        messageObtain.what = 3201;
        messageObtain.arg1 = 1;
        this.f22286h.sendMessageDelayed(messageObtain, 8000L);
        this.f22286h.removeMessages(3202);
    }

    /* renamed from: y */
    public final void m29254y() {
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        if (c13464dM81030f.m81037h("autobackupstarttime") == 0) {
            c13464dM81030f.m81048s("autobackupstarttime", System.currentTimeMillis());
            c13464dM81030f.m81048s("autobackupblowouttime", 0L);
        }
    }

    /* renamed from: z */
    public final void m29255z() {
        C11839m.m70688i("CloudBackupObserverService", "registerObserverReceiver");
        if (this.f22282d == null) {
            this.f22282d = new CBObserverReceiver();
            long jM29246q = m29246q("checkInterval");
            ICycleChecker cycleChecker = CloudBackupConditionsUtil.getCycleChecker();
            m29249t(jM29246q, 0L, m29247r(cycleChecker), false, cycleChecker.getType() + cycleChecker.isCycleSatisfy());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            registerReceiver(this.f22282d, intentFilter);
        } else {
            C11839m.m70688i("CloudBackupObserverService", "registerObserverReceiver mObserverReceiver is exist");
        }
        if (this.f22283e != null) {
            C11839m.m70688i("CloudBackupObserverService", "registerObserverReceiver mObserverTimerReceiver is exist");
            return;
        }
        this.f22283e = new CBObserverTimerReceiver();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.huawei.hicloud.intent.action.CB_OBSERVER_TIMER_REGISTER");
        intentFilter2.addAction("com.huawei.hicloud.intent.action.CB_OBSERVER_RESTORE_TIMER_REGISTER_OR_UNREGISTER");
        C13108a.m78878b(this.f22279a).m78880c(this.f22283e, intentFilter2);
        m29242B(RestoreUtil.getRestoreDelayTime());
    }
}
