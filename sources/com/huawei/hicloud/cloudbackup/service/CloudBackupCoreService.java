package com.huawei.hicloud.cloudbackup.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.notification.RestoreNotification;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.service.ICoreService;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0238w;
import p430kl.C11061a;
import p514o9.C11839m;
import p618rm.C12591s1;
import p684un.C13225d;
import p709vj.C13452e;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes6.dex */
public class CloudBackupCoreService extends Service {

    /* renamed from: a */
    public RemoteCallbackList<ICoreCallback> f22292a = new RemoteCallbackList<>();

    /* renamed from: b */
    public int f22293b = 0;

    /* renamed from: c */
    public Handler.Callback f22294c = new Handler.Callback() { // from class: kl.b
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.f52252a.m29262f(message);
        }
    };

    /* renamed from: d */
    public ICoreService.AbstractBinderC4876a f22295d = new BinderC4873a();

    /* renamed from: com.huawei.hicloud.cloudbackup.service.CloudBackupCoreService$a */
    public class BinderC4873a extends ICoreService.AbstractBinderC4876a {
        public BinderC4873a() {
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public void abort(int i10) throws RemoteException {
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int backup() throws RemoteException {
            return C11061a.m66671a();
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int cancelRefurbish(int i10) throws RemoteException {
            if (1 != i10) {
                return m29265f(-1);
            }
            C11839m.m70688i("CloudBackupCoreService", "cancel refurbish start.");
            CloudBackupCoreService.this.m29263g("2");
            boolean zCancelRefurbish = CloudBackupService.getInstance().cancelRefurbish();
            CBCallBack.getInstance().sendMessage(Message.obtain((Handler) null, 33031));
            return zCancelRefurbish ? m29265f(0) : m29265f(-1);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int doBackupOptions() throws RemoteException {
            return 0;
        }

        /* renamed from: f */
        public final int m29265f(int i10) {
            Message messageObtain = Message.obtain((Handler) null, 33030);
            messageObtain.arg1 = i10;
            CloudBackupCoreService.this.m29264h(messageObtain);
            C11839m.m70688i("CloudBackupCoreService", "cancel refurbish msg: " + i10);
            return i10;
        }

        /* renamed from: g */
        public final int m29266g(int i10) {
            Message messageObtain = Message.obtain((Handler) null, 33029);
            messageObtain.arg1 = i10;
            CloudBackupCoreService.this.m29264h(messageObtain);
            C11839m.m70688i("CloudBackupCoreService", "continue refurbish msg: " + i10);
            return i10;
        }

        /* renamed from: h */
        public final int m29267h(int i10) {
            Message messageObtain = Message.obtain((Handler) null, 33028);
            messageObtain.arg1 = i10;
            CloudBackupCoreService.this.m29264h(messageObtain);
            C11839m.m70688i("CloudBackupCoreService", "pause refurbish msg: " + i10);
            return i10;
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int pauseRefurbish(int i10) throws RemoteException {
            if (1 == i10) {
                C11839m.m70688i("CloudBackupCoreService", "pause refurbish start.");
                CloudBackupCoreService.this.m29263g("3");
                CloudBackupService.getInstance().abort(1001);
                int i11 = 0;
                while (true) {
                    if (i11 >= 10) {
                        break;
                    }
                    if (!CBAccess.hasTaskWorking()) {
                        C11839m.m70688i("CloudBackupCoreService", "pause refurbish abort task success.");
                        break;
                    }
                    SystemClock.sleep(100);
                    i11++;
                }
                if (i11 < 10) {
                    try {
                        C13029h c13029hM78495f = new C13030i().m78495f(4);
                        if (c13029hM78495f != null && c13029hM78495f.m78441G() != 4) {
                            return m29267h(0);
                        }
                    } catch (C9721b e10) {
                        C11839m.m70687e("CloudBackupCoreService", "query backup tags error: " + e10.toString());
                    }
                }
            }
            return this.m29267h(-1);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public void registerCallback(ICoreCallback iCoreCallback) throws RemoteException {
            CloudBackupCoreService.this.f22292a.register(iCoreCallback);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int restore(String str, String str2, int i10, int i11) throws RemoteException {
            return C11061a.m66672b(str, str2, i10, i11);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int restoreRetry(boolean z10, boolean z11, boolean z12) throws RemoteException {
            return C11061a.m66673c(z10, z11, z12);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int restoreRetryV3(boolean z10, boolean z11, boolean z12) throws RemoteException {
            return C11061a.m66674d(z10, z11, z12);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int restoreV3(String str, String str2, String str3, int i10, String str4, String str5) throws RemoteException {
            return C11061a.m66675e(str, str2, str3, i10, str4, str5);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int resumeRefurbish(int i10) throws RemoteException {
            if (1 == i10) {
                C11839m.m70688i("CloudBackupCoreService", "resume refurbish start.");
                CloudBackupService.getInstance().doRefurbishBackup(false);
                for (int i11 = 0; CloudBackupCoreService.this.f22293b == 0 && i11 <= 350; i11++) {
                    SystemClock.sleep(100);
                }
                if (CloudBackupCoreService.this.f22293b > 0) {
                    ICBBroadcastManager.sendCloudBackupPrepareState();
                    return m29266g(0);
                }
            }
            return m29266g(-1);
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public int startRefurbish(int i10) throws RemoteException {
            C11839m.m70688i("CloudBackupCoreService", "start refurbish.");
            return 0;
        }

        @Override // com.huawei.hicloud.cloudbackup.service.ICoreService
        public void unregisterCallback(ICoreCallback iCoreCallback) throws RemoteException {
            CloudBackupCoreService.this.f22292a.unregister(iCoreCallback);
        }
    }

    /* renamed from: f */
    public final /* synthetic */ boolean m29262f(Message message) {
        int i10 = message.what;
        if (i10 == 33027) {
            this.f22293b = -1;
        } else if (i10 == 33026) {
            this.f22293b = 1;
        }
        m29264h(message);
        return false;
    }

    /* renamed from: g */
    public final void m29263g(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is_refurbish", String.valueOf(C12591s1.m75931a().m75941k()));
        C13225d.m79490f1().m79590k0("mecloud_backupmain_click_now", str, "", C13452e.m80781L().m80971t0(), linkedHashMap);
        UBAAnalyze.m29979g0("PVC", "mecloud_backupmain_click_now", "1", "43", str, "", linkedHashMap);
    }

    /* renamed from: h */
    public final synchronized void m29264h(Message message) {
        RemoteCallbackList<ICoreCallback> remoteCallbackList = this.f22292a;
        if (remoteCallbackList != null) {
            int iBeginBroadcast = remoteCallbackList.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    ((ICoreCallback) this.f22292a.getBroadcastItem(i10)).callback(message.what, message.arg1, message.arg2, message.getData());
                } catch (Exception e10) {
                    C11839m.m70687e("CloudBackupCoreService", "handleMessage error: " + e10.toString());
                }
            }
            this.f22292a.finishBroadcast();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if ("com.huawei.hicloud.cloudbackup.service.action".equals(new SafeIntent(intent).getAction())) {
            return this.f22295d;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        CBCallBack.getInstance().registerCallback(this.f22294c);
        if (!C12591s1.m75931a().m75941k()) {
            Context applicationContext = getApplicationContext();
            Intent intent = new Intent(applicationContext, (Class<?>) RestoreMainActivity.class);
            Bundle bundle = new Bundle();
            int iM80916g0 = C13452e.m80781L().m80916g0();
            bundle.putInt("current_status", 2);
            bundle.putInt("restore_status", iM80916g0);
            bundle.putBoolean("is_form_notification", true);
            intent.putExtras(bundle);
            C0216g0.m1402e(applicationContext).m1408F(intent, "SOURCE_ID_BACKUP_RESTORING_NOTIFY");
            PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(applicationContext, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.substName", applicationContext.getResources().getString(R$string.backup_notification_title));
            NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(applicationContext, "com.huawei.android.hicloud.cloudbackup");
            if (C0209d.m1253f1()) {
                builderM1668i.m3811l(applicationContext.getString(R$string.notification_restoring_data));
                builderM1668i.m3810k(String.format(applicationContext.getString(R$string.restore_new_completed_part), C0209d.m1236b0(C2783d.m16085H(0.0f))));
            } else {
                builderM1668i.m3811l(applicationContext.getString(R$string.restore_new_restoring_data));
            }
            builderM1668i.m3807h(false).m3819t(true);
            builderM1668i.m3824y(R$drawable.logo_about_system);
            builderM1668i.m3809j(pendingIntentM1248e0).m3803c(bundle2).m3822w(100, 0, false).m3818s(false).m3817r("com.huawei.android.hicloud.cloudbackup").m3823x(false);
            startForeground(23, builderM1668i.m3804d());
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        C11839m.m70688i("CloudBackupCoreService", "onDestroy");
        CBCallBack.getInstance().unregisterCallback(this.f22294c);
        this.f22292a.kill();
        stopForeground(false);
        super.onDestroy();
        RestoreNotification restoreNotification = RestoreNotification.getInstance();
        int iM80916g0 = C13452e.m80781L().m80916g0();
        float fM80911f0 = C13452e.m80781L().m80911f0();
        C11839m.m70686d("CloudBackupCoreService", "status: " + iM80916g0);
        if (iM80916g0 == 3) {
            C13452e.m80781L().m80909e3(100.0f);
            restoreNotification.completedNotification(100.0f, iM80916g0);
            return;
        }
        if (iM80916g0 != 5) {
            if (iM80916g0 == 6) {
                restoreNotification.showNetErrNotification(fM80911f0);
                return;
            } else if (iM80916g0 != 7) {
                if (iM80916g0 != 8) {
                    return;
                }
                restoreNotification.cancelNotification();
                return;
            }
        }
        restoreNotification.completedNotification(fM80911f0, iM80916g0);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }
}
