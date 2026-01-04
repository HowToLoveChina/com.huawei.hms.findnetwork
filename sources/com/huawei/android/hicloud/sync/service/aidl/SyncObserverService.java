package com.huawei.android.hicloud.sync.service.aidl;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2986o;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import p015ak.C0206b0;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12336b;
import p573qc.C12337c;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12369f;
import p609rc.C12487a;
import p616rk.C12515a;
import p636s8.C12762a;
import p636s8.C12763b;
import p709vj.C13452e;
import p783xp.C13843a;
import p836z8.C14158g;
import p836z8.C14159h;

/* loaded from: classes3.dex */
public class SyncObserverService extends Service {
    private static final long DELAY = 10000;
    protected static final String TAG = "SyncObserverService";
    private static C12762a callLogContentObserver;
    private static C12336b contactContentObserver;
    private static C12337c groupContentObserver;
    private static final Object OBJECT = new Object();
    private static final Object CALL_LOG_OBJECT = new Object();
    private Context appContext = null;
    private BroadcastReceiver mReceiver = null;
    private BroadcastReceiver packagesChangeReceiver = null;
    private boolean sendContactNet = false;
    private final Handler mHandler = new Handler() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.1
        public HandlerC29601() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 8) {
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.NETWORK_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 == 9) {
                if (SyncObserverService.groupContentObserver != null) {
                    SyncObserverService.groupContentObserver.m74182c(false);
                }
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.OBSERVE_CONTACT_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 == 16) {
                if (SyncObserverService.contactContentObserver != null) {
                    SyncObserverService.contactContentObserver.m74182c(false);
                }
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.OBSERVE_CONTACT_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 == 17) {
                SyncObserverService.this.receiveWlanChange();
                return;
            }
            if (i10 == 96) {
                C11839m.m70688i(SyncObserverService.TAG, "content changed or receive push, sync contact");
                SyncType syncType = SyncType.MAMUNAL_OPENAUTO_SYNC;
                Object obj = message.obj;
                if (obj != null && (obj instanceof SyncType)) {
                    syncType = (SyncType) obj;
                }
                ICSServiceProtocol.getInstance().doSyncContact(syncType);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 != 112) {
                if (i10 == 128) {
                    SyncObserverService.this.doWlanSync(message);
                    return;
                } else if (i10 != 137) {
                    SyncObserverService.this.handleSyncObserverServiceMessage(message);
                    return;
                } else {
                    SyncObserverService.this.processWifiChanged();
                    return;
                }
            }
            SyncObserverService.this.sendContactNet = false;
            C11839m.m70688i(SyncObserverService.TAG, "contact sync after net change");
            SyncObserverService syncObserverService = SyncObserverService.this;
            if (syncObserverService.isLastSyncFail("addressbook", syncObserverService.appContext)) {
                C11839m.m70688i(SyncObserverService.TAG, "network change sync after last fail");
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.LAST_FAIL_NETWORK_CHANGE_SYNC);
            }
            SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
        }
    };

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService$1 */
    public class HandlerC29601 extends Handler {
        public HandlerC29601() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 8) {
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.NETWORK_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 == 9) {
                if (SyncObserverService.groupContentObserver != null) {
                    SyncObserverService.groupContentObserver.m74182c(false);
                }
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.OBSERVE_CONTACT_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 == 16) {
                if (SyncObserverService.contactContentObserver != null) {
                    SyncObserverService.contactContentObserver.m74182c(false);
                }
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.OBSERVE_CONTACT_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 == 17) {
                SyncObserverService.this.receiveWlanChange();
                return;
            }
            if (i10 == 96) {
                C11839m.m70688i(SyncObserverService.TAG, "content changed or receive push, sync contact");
                SyncType syncType = SyncType.MAMUNAL_OPENAUTO_SYNC;
                Object obj = message.obj;
                if (obj != null && (obj instanceof SyncType)) {
                    syncType = (SyncType) obj;
                }
                ICSServiceProtocol.getInstance().doSyncContact(syncType);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
                return;
            }
            if (i10 != 112) {
                if (i10 == 128) {
                    SyncObserverService.this.doWlanSync(message);
                    return;
                } else if (i10 != 137) {
                    SyncObserverService.this.handleSyncObserverServiceMessage(message);
                    return;
                } else {
                    SyncObserverService.this.processWifiChanged();
                    return;
                }
            }
            SyncObserverService.this.sendContactNet = false;
            C11839m.m70688i(SyncObserverService.TAG, "contact sync after net change");
            SyncObserverService syncObserverService = SyncObserverService.this;
            if (syncObserverService.isLastSyncFail("addressbook", syncObserverService.appContext)) {
                C11839m.m70688i(SyncObserverService.TAG, "network change sync after last fail");
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.LAST_FAIL_NETWORK_CHANGE_SYNC);
            }
            SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY");
        }
    }

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService$2 */
    public class C29612 extends AbstractC12367d {
        public C29612() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (CloudSyncUtil.m16045s()) {
                C11839m.m70688i(SyncObserverService.TAG, "start doSyncWlan");
                ICSServiceProtocol.getInstance().doSyncWlan(SyncType.WlanSyncType.CONFIGURED_NETWORKS_CHANGE_SYNC);
                SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService$3 */
    public class C29623 extends AbstractC12367d {
        final /* synthetic */ Message val$msg;

        public C29623(Message message) {
            message = message;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0038  */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() {
            /*
                r5 = this;
                boolean r0 = com.huawei.android.hicloud.complexutil.CloudSyncUtil.m16045s()
                if (r0 == 0) goto L46
                java.lang.String r0 = "wlan sync AUTO_SYNC_WLAN"
                java.lang.String r1 = "SyncObserverService"
                p514o9.C11839m.m70688i(r1, r0)
                com.huawei.android.hicloud.sync.service.aidl.SyncType r0 = com.huawei.android.hicloud.sync.service.aidl.SyncType.WlanSyncType.COMMON_SYNC
                android.os.Message r2 = r2
                java.lang.Object r2 = r2.obj
                if (r2 == 0) goto L1c
                boolean r3 = r2 instanceof com.huawei.android.hicloud.sync.service.aidl.SyncType
                if (r3 == 0) goto L1c
                r0 = r2
                com.huawei.android.hicloud.sync.service.aidl.SyncType r0 = (com.huawei.android.hicloud.sync.service.aidl.SyncType) r0
            L1c:
                int r2 = r0.getBiReportType()
                r3 = 10
                if (r3 != r2) goto L38
                com.huawei.android.hicloud.sync.service.aidl.SyncObserverService r2 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.this
                java.lang.String r3 = "wlan"
                android.content.Context r4 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.access$500(r2)
                boolean r2 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.access$600(r2, r3, r4)
                if (r2 != 0) goto L38
                java.lang.String r0 = "last sync fail and network change, but sync status is success."
                p514o9.C11839m.m70688i(r1, r0)
                goto L3f
            L38:
                com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol r1 = com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol.getInstance()
                r1.doSyncWlan(r0)
            L3f:
                com.huawei.android.hicloud.sync.service.aidl.SyncObserverService r5 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.this
                java.lang.String r0 = "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY"
                com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.access$100(r5, r0)
            L46:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.C29623.call():void");
        }
    }

    public class ObserverReceiver extends BroadcastReceiver {
        public ObserverReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) throws NumberFormatException {
            if (intent == null) {
                C11839m.m70689w(SyncObserverService.TAG, "intent is empty");
                return;
            }
            String action = intent.getAction();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                SyncObserverService.this.processNetworkChanged(context);
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                C11839m.m70686d(SyncObserverService.TAG, "ACTION_BATTERY_CHANGED");
                SyncObserverService.this.processBatteryChange(intent);
                return;
            }
            if (C11829c.m70611r0() && "android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(action)) {
                C11839m.m70686d(SyncObserverService.TAG, "CONFIGURED_NETWORKS_CHANGED_ACTION");
                SyncObserverService.this.delayProcessWifiChanged();
            } else if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action)) {
                C11839m.m70688i(SyncObserverService.TAG, "ACTION_POWER_CONNECTED");
                if (CloudSyncUtil.m16052u0(SyncObserverService.this.appContext, "autophonemanagerkey")) {
                    SyncObserverService.this.dealAutoBackupPhoneManger(context);
                }
            }
        }
    }

    public class PackagesChangeReceiver extends BroadcastReceiver {
        public PackagesChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String dataString;
            if (intent == null) {
                C11839m.m70689w(SyncObserverService.TAG, "intent is empty");
                return;
            }
            if (!"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) || (dataString = intent.getDataString()) == null) {
                return;
            }
            if (dataString.contains("com.huawei.contacts.sync") || dataString.contains("com.hihonor.contacts.sync")) {
                C11839m.m70688i(SyncObserverService.TAG, "receive contact sync removed broadcast");
                if (C13843a.m83073Y(SyncObserverService.this.appContext)) {
                    return;
                }
                SyncObserverService syncObserverService = SyncObserverService.this;
                syncObserverService.registerAddressBookChangeObserver(syncObserverService);
            }
        }
    }

    public static class SmsTimer extends AbstractC12369f {
        private static final long HALF_HOUR = 1800;
        private Context context;

        public SmsTimer(Context context) {
            super(0L, HALF_HOUR);
            this.context = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70686d(SyncObserverService.TAG, "sms timer start.");
            if (!C0209d.m1208S0(this.context)) {
                C11839m.m70689w(SyncObserverService.TAG, "sms timer start net disable.");
            } else if (CloudSyncUtil.m16052u0(this.context, "autosmslistkey")) {
                ICDServiceProtocol.getInstance().doBackupSms();
            }
        }
    }

    private void callLogSync() {
        C11839m.m70688i(TAG, "doBackupCallog");
        ICDServiceProtocol.getInstance().doBackupCallog();
    }

    public void cancelSyncRetryAlarm(String str) {
        C2986o.m17944a(this.appContext, str);
        C14159h.m84968b(this.appContext, str);
    }

    public void dealAutoBackupPhoneManger(Context context) throws NumberFormatException {
        Long lValueOf;
        C11839m.m70688i(TAG, "dealAutoBackupPhoneManger");
        if (TextUtils.isEmpty(C13452e.m80781L().m80971t0())) {
            C11839m.m70689w(TAG, "uid is empty");
            return;
        }
        if (CloudSyncUtil.m15939A(context) < 10) {
            C11839m.m70689w(TAG, "batterylever lower than 10%");
            return;
        }
        if (!C0209d.m1208S0(context)) {
            C11839m.m70689w(TAG, "wifi not Connect,result" + C14158g.m84965b("autophonemanagerkeynotAllSucess", context));
            return;
        }
        try {
            lValueOf = Long.valueOf(C14158g.m84964a("autophonemanagerkey_endtime", context));
        } catch (NumberFormatException e10) {
            C11839m.m70687e(TAG, "dealAutoBackupPhoneManger " + e10.toString());
            lValueOf = 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lValueOf.longValue();
        C11839m.m70688i(TAG, "backEndTime :" + lValueOf + ",intervalTime:" + Long.valueOf(jCurrentTimeMillis) + ",24h:86400000");
        if (jCurrentTimeMillis > 86400000) {
            C11839m.m70688i(TAG, "doBackupPhoneManager");
            CloudSyncUtil.m16023k1(this, "autophonemanagerkey");
            ICDServiceProtocol.getInstance().doBackupPhoneManager();
        }
    }

    private void dealNetworksChange() {
        if (!isLastSyncFail("wlan", this.appContext)) {
            this.mHandler.removeMessages(17);
            sendNetworksChangeMsg();
            return;
        }
        C11839m.m70688i(TAG, "net connect,wlan sync last fail , process ");
        this.mHandler.removeMessages(128);
        Message message = new Message();
        message.what = 128;
        message.obj = SyncType.WlanSyncType.LAST_FAIL_NETWORK_CHANGE_SYNC;
        this.mHandler.sendMessageDelayed(message, 120000L);
    }

    public void delayProcessWifiChanged() {
        C11839m.m70688i(TAG, "delayProcessWifiChanged");
        this.mHandler.removeMessages(SyncType.DELAY_START_SYNC);
        Message message = new Message();
        message.what = SyncType.DELAY_START_SYNC;
        this.mHandler.sendMessageDelayed(message, 10000L);
    }

    public void doWlanSync(Message message) {
        C11839m.m70688i(TAG, "doWlanSync");
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.3
            final /* synthetic */ Message val$msg;

            public C29623(Message message2) {
                message = message2;
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                /*
                    this = this;
                    boolean r0 = com.huawei.android.hicloud.complexutil.CloudSyncUtil.m16045s()
                    if (r0 == 0) goto L46
                    java.lang.String r0 = "wlan sync AUTO_SYNC_WLAN"
                    java.lang.String r1 = "SyncObserverService"
                    p514o9.C11839m.m70688i(r1, r0)
                    com.huawei.android.hicloud.sync.service.aidl.SyncType r0 = com.huawei.android.hicloud.sync.service.aidl.SyncType.WlanSyncType.COMMON_SYNC
                    android.os.Message r2 = r2
                    java.lang.Object r2 = r2.obj
                    if (r2 == 0) goto L1c
                    boolean r3 = r2 instanceof com.huawei.android.hicloud.sync.service.aidl.SyncType
                    if (r3 == 0) goto L1c
                    r0 = r2
                    com.huawei.android.hicloud.sync.service.aidl.SyncType r0 = (com.huawei.android.hicloud.sync.service.aidl.SyncType) r0
                L1c:
                    int r2 = r0.getBiReportType()
                    r3 = 10
                    if (r3 != r2) goto L38
                    com.huawei.android.hicloud.sync.service.aidl.SyncObserverService r2 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.this
                    java.lang.String r3 = "wlan"
                    android.content.Context r4 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.access$500(r2)
                    boolean r2 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.access$600(r2, r3, r4)
                    if (r2 != 0) goto L38
                    java.lang.String r0 = "last sync fail and network change, but sync status is success."
                    p514o9.C11839m.m70688i(r1, r0)
                    goto L3f
                L38:
                    com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol r1 = com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol.getInstance()
                    r1.doSyncWlan(r0)
                L3f:
                    com.huawei.android.hicloud.sync.service.aidl.SyncObserverService r5 = com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.this
                    java.lang.String r0 = "com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY"
                    com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.access$100(r5, r0)
                L46:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.C29623.call():void");
            }
        });
    }

    public void handleSyncObserverServiceMessage(Message message) {
        int i10 = message.what;
        if (i10 == 131) {
            callLogSync();
        } else {
            if (i10 != 132) {
                return;
            }
            recordSync();
        }
    }

    public boolean isLastSyncFail(String str, Context context) {
        return C0206b0.m1133e(str + "notAllSucess", context);
    }

    public void processBatteryChange(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = 0;
        try {
            intExtra = intent.getIntExtra(FaqConstants.FAQ_LEVEL, 0);
        } catch (RuntimeException unused) {
            C11839m.m70688i(TAG, "intent Serializable error.");
        }
        int intExtra2 = 1;
        try {
            intExtra2 = intent.getIntExtra("status", 1);
        } catch (RuntimeException unused2) {
            C11839m.m70688i(TAG, "intent Serializable error.");
        }
        C11839m.m70688i(TAG, "batteryStatus: " + intExtra2);
        if (intExtra2 == 2 || intExtra2 == 5 || intExtra >= 10) {
            return;
        }
        C11839m.m70689w(TAG, "battery level lower than 10%");
        ICDServiceProtocol.getInstance().processBattery(intExtra);
    }

    public void processNetworkChanged(Context context) {
        C11839m.m70688i(TAG, "process net changed.");
        if (!C0209d.m1333z1(context)) {
            ICSServiceProtocol.getInstance().doAbort();
            return;
        }
        C11839m.m70686d(TAG, "net connect");
        if (!C0209d.m1254f2(this.appContext) && C0206b0.m1134f("recording_need_wifi_condition", context)) {
            ICDServiceProtocol.getInstance().abort(55000018);
        }
        if (CloudSyncUtil.m16052u0(context, "autosmslistkey") && C0206b0.m1130b("autosmslistkeynotAllSucess", context)) {
            ICDServiceProtocol.getInstance().doBackupSms();
        }
        if (CloudSyncUtil.m16052u0(context, "autocallloglistkey") && C0206b0.m1130b("autocallloglistkeynotAllSucess", context)) {
            ICDServiceProtocol.getInstance().doBackupCallog();
        }
        if (CloudSyncUtil.m16052u0(context, "autophonemanagerkey") && CloudSyncUtil.m16062z0(context, "autophonemanagerkey") && C0206b0.m1130b("autophonemanagerkeynotAllSucess", context)) {
            ICDServiceProtocol.getInstance().doBackupPhoneManager();
        }
        if (CloudSyncUtil.m16052u0(context, "autorecordingkey") && CloudSyncUtil.m16062z0(context, "autorecordingkey") && C0206b0.m1130b("autorecordingkeynotAllSucess", context)) {
            ICDServiceProtocol.getInstance().doBackupRecording();
        }
        processNetworkChangedContact(context);
        processNetworkChangedWifi(context);
    }

    private void processNetworkChangedContact(Context context) {
        if (C13843a.m83073Y(this)) {
            C11839m.m70688i(TAG, "net connect, contact support sync ability, so do not retry");
            return;
        }
        if (!C0206b0.m1131c("addressbook", context) || C14159h.m84967a(context, "addressbook")) {
            return;
        }
        C11839m.m70686d(TAG, "net connect,contact sync button open");
        if (!isLastSyncFail("addressbook", context)) {
            Message message = new Message();
            message.what = 8;
            message.obj = SyncType.NETWORK_CHANGE_SYNC;
            this.mHandler.sendMessage(message);
            return;
        }
        C11839m.m70688i(TAG, "net connect,contact sync last fail , process ");
        if (this.sendContactNet) {
            return;
        }
        this.sendContactNet = true;
        Message message2 = new Message();
        message2.what = 112;
        message2.obj = SyncType.LAST_FAIL_NETWORK_CHANGE_SYNC;
        this.mHandler.sendMessageDelayed(message2, 120000L);
    }

    private void processNetworkChangedWifi(Context context) {
        if (!CloudSyncUtil.m15964M0(context) || C14159h.m84967a(context, "wlan")) {
            return;
        }
        C11839m.m70686d(TAG, "net connect,wlan sync button open");
        if (isLastSyncFail("wlan", context)) {
            C11839m.m70688i(TAG, "net connect,wlan sync last fail , process ");
            this.mHandler.removeMessages(128);
            Message message = new Message();
            message.what = 128;
            message.obj = SyncType.WlanSyncType.LAST_FAIL_NETWORK_CHANGE_SYNC;
            this.mHandler.sendMessageDelayed(message, 120000L);
        }
    }

    public void processWifiChanged() {
        C11839m.m70688i(TAG, "processWifiChanged");
        if (CloudSyncUtil.m15964M0(this.appContext)) {
            if (CloudSyncUtil.m16046s0()) {
                C11839m.m70688i(TAG, "CONFIGURED_NETWORKS_CHANGE isInDelayTime.");
            } else {
                dealNetworksChange();
            }
        }
    }

    public void receiveWlanChange() {
        C11839m.m70688i(TAG, "RECEIVE_WLAN_CHANGE");
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.sync.service.aidl.SyncObserverService.2
            public C29612() {
            }

            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                if (CloudSyncUtil.m16045s()) {
                    C11839m.m70688i(SyncObserverService.TAG, "start doSyncWlan");
                    ICSServiceProtocol.getInstance().doSyncWlan(SyncType.WlanSyncType.CONFIGURED_NETWORKS_CHANGE_SYNC);
                    SyncObserverService.this.cancelSyncRetryAlarm("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY");
                }
            }
        });
    }

    private void recordSync() {
        C11839m.m70688i(TAG, "recordSync");
        if (CloudSyncUtil.m16062z0(this.appContext, "autorecordingkey")) {
            ICDServiceProtocol.getInstance().doBackupRecording();
            return;
        }
        C11839m.m70689w(TAG, "HiSyncService record Sync update only by wifi update SP result:" + C14158g.m84965b("autorecordingkeynotAllSucess", this.appContext));
    }

    public void registerAddressBookChangeObserver(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "registerAddressBookChangeObserver error: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w(TAG, "registerAddressBookChangeObserver error: contentResolver is null");
            return;
        }
        try {
            synchronized (OBJECT) {
                try {
                    if (contactContentObserver == null) {
                        contactContentObserver = new C12336b(this.mHandler, this);
                        contentResolver.registerContentObserver(ContactsContract.RawContacts.CONTENT_URI, true, contactContentObserver);
                    }
                    if (groupContentObserver == null) {
                        groupContentObserver = new C12337c(this.mHandler, this);
                        contentResolver.registerContentObserver(ContactsContract.Groups.CONTENT_URI, true, groupContentObserver);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception unused) {
            C11839m.m70689w(TAG, "registerContentObserver failed.");
        }
    }

    private void registerCallLogChangeObserver(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "registerCallLogChangeObserver error: context is null");
            return;
        }
        if (context.getContentResolver() == null) {
            C11839m.m70689w(TAG, "registerCallLogChangeObserver error: contentResolver is null");
            return;
        }
        try {
            synchronized (CALL_LOG_OBJECT) {
                if (CloudSyncUtil.m16052u0(context, "autocallloglistkey") && C0206b0.m1131c("funcfg_call_log_up", context) && callLogContentObserver == null) {
                    C11839m.m70688i(TAG, "registerObserver callLogContentObserver");
                    ContentResolver contentResolver = getContentResolver();
                    callLogContentObserver = new C12762a(context, this.mHandler);
                    try {
                        contentResolver.registerContentObserver(CallLog.Calls.CONTENT_URI, true, callLogContentObserver);
                    } catch (Exception unused) {
                        C11839m.m70689w(TAG, "register callLog contentObserver failed.");
                    }
                }
            }
        } catch (Exception unused2) {
            C11839m.m70689w(TAG, "registerCallLogChangeObserver failed.");
        }
    }

    private void registerObserver() {
        if (!C13843a.m83073Y(this.appContext)) {
            registerAddressBookChangeObserver(this);
        }
        registerCallLogChangeObserver(this);
        if (CloudSyncUtil.m16052u0(this, "autophonemanagerkey") && C0206b0.m1131c("funcfg_blocked_up", this)) {
            C11839m.m70688i(TAG, "registerObserver setAutoItemBackupTimer");
            CloudSyncUtil.m16023k1(this, "autophonemanagerkey");
        }
    }

    private void registerPackagesChangeReceiver() {
        if (this.packagesChangeReceiver == null) {
            this.packagesChangeReceiver = new PackagesChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            intentFilter.addDataSchemeSpecificPart("com.huawei.contacts.sync", 0);
            C11839m.m70688i(TAG, "Register package change listener dynamically.");
            registerReceiver(this.packagesChangeReceiver, intentFilter);
        }
    }

    private void registerReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new ObserverReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private boolean sendNetworksChangeMsg() {
        if (!CloudSyncUtil.m15964M0(this.appContext)) {
            C11839m.m70686d(TAG, "[sendNetworksChangeMsg] Ignore Networks change. Syncing...");
            return false;
        }
        if (C14159h.m84967a(this.appContext, "wlan")) {
            C11839m.m70686d(TAG, "[sendNetworksChangeMsg] Ignore sync request.sync_wlan: false");
            return false;
        }
        Message message = new Message();
        message.what = 17;
        this.mHandler.sendMessageDelayed(message, 10000L);
        C11839m.m70686d(TAG, "[sendNetworksChangeMsg] send message delay 10s");
        return true;
    }

    public static void unRegisterAddressBookChangeObserver(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "unRegisterAddressBookChangeObserver error: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w(TAG, "unRegisterAddressBookChangeObserver error: contentResolver is null");
            return;
        }
        C11839m.m70688i(TAG, "unRegisterAddressBookChangeObserver");
        synchronized (OBJECT) {
            try {
                C12336b c12336b = contactContentObserver;
                if (c12336b != null) {
                    contentResolver.unregisterContentObserver(c12336b);
                    contactContentObserver = null;
                }
                C12337c c12337c = groupContentObserver;
                if (c12337c != null) {
                    contentResolver.unregisterContentObserver(c12337c);
                    groupContentObserver = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void unRegisterCallLogChangeObserver(Context context) {
        if (context == null) {
            C11839m.m70689w(TAG, "unRegisterCallLogChangeObserver error: context is null");
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            C11839m.m70689w(TAG, "unRegisterCallLogChangeObserver error: contentResolver is null");
            return;
        }
        C11839m.m70688i(TAG, "unRegisterCallLogChangeObserver");
        try {
            synchronized (CALL_LOG_OBJECT) {
                try {
                    C12762a c12762a = callLogContentObserver;
                    if (c12762a != null) {
                        contentResolver.unregisterContentObserver(c12762a);
                        callLogContentObserver = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception unused) {
            C11839m.m70689w(TAG, "unRegisterCallLogChangeObserver failed.");
        }
    }

    private void unRegisterPackagesChangeReceiver() {
        BroadcastReceiver broadcastReceiver = this.packagesChangeReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.packagesChangeReceiver = null;
        }
    }

    private void unRegisterReceiver() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }

    private void unregisterObserver() {
        ContentResolver contentResolver = getContentResolver();
        unRegisterAddressBookChangeObserver(this);
        C12762a c12762a = callLogContentObserver;
        if (c12762a != null) {
            contentResolver.unregisterContentObserver(c12762a);
            callLogContentObserver = null;
        }
        C12763b.m76596g().m76601k();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11839m.m70688i(TAG, "onCreate");
        Context applicationContext = getApplicationContext();
        this.appContext = applicationContext;
        C12487a.m74966b(applicationContext);
        ICSServiceProtocol.getInstance().init(this.appContext);
        ICDServiceProtocol.getInstance().init(this.appContext);
        registerObserver();
        registerReceiver();
        registerPackagesChangeReceiver();
        if (CloudSyncUtil.m16052u0(this.appContext, "autorecordingkey") && !CloudSyncUtil.m15954H0(this.appContext)) {
            C12763b.m76596g().m76599i(this, this.mHandler);
            C12763b.m76596g().m76598e();
        }
        C12515a.m75110o().m75172d(new SmsTimer(this.appContext));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i(TAG, "**************** onDestroy");
        unregisterObserver();
        unRegisterReceiver();
        unRegisterPackagesChangeReceiver();
        C12515a.m75110o().m75183g1();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            return 1;
        }
        C11839m.m70688i(TAG, "onStartCommand action: " + intent.getAction());
        if ("com.huawei.android.hicloud.sync.registerCallLogChangeObserver".equals(intent.getAction())) {
            registerCallLogChangeObserver(this);
            return 1;
        }
        if ("com.huawei.android.hicloud.sync.unregisterCallLogChangeObserver".equals(intent.getAction())) {
            unRegisterCallLogChangeObserver(this);
            return 1;
        }
        if ("com.huawei.android.hicloud.sync.unRegisterContactChangeObserver".equals(intent.getAction())) {
            unRegisterAddressBookChangeObserver(this);
            return 1;
        }
        if ("com.huawei.android.hicloud.sync.stopFileListener".equals(intent.getAction())) {
            C12763b.m76596g().m76601k();
            return 1;
        }
        if ("com.huawei.android.hicloud.sync.syncobserverservice.filelistener".equals(intent.getAction()) && !CloudSyncUtil.m15954H0(this.appContext)) {
            C12763b.m76596g().m76599i(this, this.mHandler);
            C12763b.m76596g().m76598e();
        }
        if (this.mReceiver == null) {
            registerReceiver();
        }
        if (this.packagesChangeReceiver == null) {
            registerPackagesChangeReceiver();
        }
        return 1;
    }
}
