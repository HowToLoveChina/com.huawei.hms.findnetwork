package com.huawei.hicloud.cloudbackup.p104v3.core;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import bm.InterfaceC1262c;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.process.AutoBackupKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.BackupPowerKitKeepTimer;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.clone.ClonePowerKit;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.report.MobileTrafficReport;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.cbs.bean.CBSBaseReq;
import fk.C9721b;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.function.Consumer;
import je.C10782d;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0221j;
import p292fn.C9731d;
import p292fn.C9733f;
import p514o9.C11839m;
import p572qb.C12299b;
import p616rk.C12515a;
import p618rm.C12565k;
import p618rm.C12586r;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12592t;
import p618rm.C12604x;
import p684un.C13225d;
import p711vl.C13466f;
import p847zk.C14315h;
import tl.C13029h;

/* loaded from: classes6.dex */
public abstract class ICBBaseV3Task extends CacheTask {

    /* renamed from: a */
    public PowerManager.WakeLock f22421a;

    /* renamed from: b */
    public ICBBaseReceiver f22422b;

    /* renamed from: c */
    public AutoBackupKeepTimer f22423c;

    /* renamed from: d */
    public String f22424d;

    /* renamed from: e */
    public int f22425e;

    /* renamed from: f */
    public boolean f22426f = false;

    /* renamed from: g */
    public String f22427g = "1";

    /* renamed from: h */
    public long f22428h = System.currentTimeMillis();

    /* renamed from: i */
    public String f22429i = "user-cloudBackup_apply";

    /* renamed from: j */
    public InterfaceC1262c f22430j;

    public class ICBBaseReceiver extends BroadcastReceiver {

        /* renamed from: a */
        public final Handler f22431a = new HandlerC4878a(Looper.getMainLooper());

        /* renamed from: com.huawei.hicloud.cloudbackup.v3.core.ICBBaseV3Task$ICBBaseReceiver$a */
        public class HandlerC4878a extends Handler {
            public HandlerC4878a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                C11839m.m70688i("ICBBaseReceiver", "mCloudBackupHandler get message");
                int i10 = message.what;
                if (i10 != 3202) {
                    if (i10 != 3204) {
                        return;
                    }
                    ICBBaseV3Task.this.abort(1006);
                    C11839m.m70688i("ICBBaseReceiver", "handleMessage USER_PRESENT.");
                    return;
                }
                if (C0209d.m1254f2(C0213f.m1377a())) {
                    return;
                }
                C11839m.m70688i("ICBBaseReceiver", "net disable");
                ICBBaseV3Task.this.abort(1002);
            }
        }

        public ICBBaseReceiver() {
        }

        /* renamed from: a */
        public void m29602a() {
            this.f22431a.removeCallbacksAndMessages(null);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70689w("ICBBaseReceiver", "intent is empty");
            } else {
                ICBBaseV3Task.this.mo29592o(context, new HiCloudSafeIntent(intent), this.f22431a);
            }
        }
    }

    public ICBBaseV3Task() {
        C0221j.m1478F(CacheTask.getContext());
    }

    /* renamed from: A */
    public final void m29579A() {
        ICBBaseReceiver iCBBaseReceiver = this.f22422b;
        if (iCBBaseReceiver != null) {
            iCBBaseReceiver.m29602a();
            CacheTask.getContext().unregisterReceiver(this.f22422b);
        }
    }

    /* renamed from: B */
    public final void m29580B() {
        PowerManager.WakeLock wakeLock = this.f22421a;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.f22421a.release();
        C11839m.m70688i("ICBBaseV3Task", "cloud backup wakelock release.");
    }

    public void abort(int i10) {
        m29581c(i10, null, null);
    }

    public void addEntryType(LinkedHashMap<String, String> linkedHashMap) {
    }

    public void autoBackupKeepLock() {
        this.f22423c = null;
        this.f22423c = new AutoBackupKeepTimer();
        C12515a.m75110o().m75172d(this.f22423c);
    }

    public void autoBackupKeepUnLock() {
        AutoBackupKeepTimer autoBackupKeepTimer = this.f22423c;
        if (autoBackupKeepTimer != null) {
            autoBackupKeepTimer.cancel();
            this.f22423c = null;
        }
    }

    /* renamed from: c */
    public void m29581c(int i10, String str, InterfaceC1262c interfaceC1262c) {
        this.f22430j = interfaceC1262c;
        if (mo29582d(i10)) {
            C11839m.m70688i("ICBBaseV3Task", "abort condition not match: " + i10);
            Optional.ofNullable(interfaceC1262c).ifPresent(new Consumer() { // from class: am.e1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((InterfaceC1262c) obj).mo1753a();
                }
            });
            return;
        }
        C11839m.m70688i("ICBBaseV3Task", "abortCode = " + i10 + ", cmd = " + str);
        setErrCode(i10, str);
        abort();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("ICBBaseV3Task", "v3 task start.");
        try {
            if (this instanceof C4879a) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("doBackupTime", Long.valueOf(System.currentTimeMillis()));
                C12299b.m73937s(contentValues);
                autoBackupKeepLock();
            }
            isCancel();
            setState(CacheTask.State.PREPARE);
            init();
            mo29594q();
            mo29598u(this.f22428h, "Prepare data");
            this.f22428h = System.currentTimeMillis();
            isCancel();
            setState(CacheTask.State.RUN);
            mo29593p();
            mo29598u(this.f22428h, "Operate cloudbackup");
            this.f22428h = System.currentTimeMillis();
            isCancel();
            mo29586h();
            this.f22426f = true;
            C11839m.m70688i("ICBBaseV3Task", "v3 task end.");
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask, p581qk.AbstractC12365b
    public void callback(Message message) {
        BackupPowerKitKeepTimer.getInstance().keepAlive(this.f22429i);
        super.callback(message);
    }

    public final void cleanCloneCache() {
        C11839m.m70688i("ICBBaseV3Task", "v3 task cleanCloneCache start.");
        if (C12565k.m75529o()) {
            ScanAppDataUtil.executePmsMoveProcess(C0213f.m1377a().getFilesDir() + "/app_medaicache");
            ScanAppDataUtil.executePmsMoveProcess(C0213f.m1377a().getFilesDir() + "/mediacache");
        }
        C11839m.m70688i("ICBBaseV3Task", "v3 task cleanCloneCache end.");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask
    public boolean condition() {
        boolean zM65642i = C10782d.m65634a().m65642i(CacheTask.getContext());
        if (!zM65642i) {
            if (C0209d.m1150A1(CacheTask.getContext())) {
                C10782d.m65634a().m65650q(2);
            } else {
                C10782d.m65634a().m65650q(1);
            }
        }
        return zM65642i;
    }

    /* renamed from: d */
    public abstract boolean mo29582d(int i10);

    /* renamed from: e */
    public final void m29583e(Throwable th2) {
        if ((th2 instanceof C9721b) && ((C9721b) th2).m60659c() == 1007) {
            return;
        }
        try {
            C12590s0.m75773M2(100000000L);
            C12590s0.m75845e1(C12586r.m75710a(), 1000L, C12586r.m75710a());
        } catch (C9721b e10) {
            setErrCode(e10.m60659c());
        }
    }

    /* renamed from: f */
    public abstract void mo29584f();

    /* renamed from: g */
    public abstract void mo29585g(C9721b c9721b);

    public String getCurrent() {
        return this.f22424d;
    }

    /* renamed from: h */
    public abstract void mo29586h() throws C9721b;

    public void init() throws C9721b {
        C11839m.m70688i("ICBBaseV3Task", "v3 task init begin.");
        C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
        C9731d.m60699d().m60701b();
        C12604x.m76064c();
        new CheckAppStatus().checkAll();
        registThermalCallback();
        BackupPowerKitKeepTimer.getInstance().keepAlive(this.f22429i);
        ClonePowerKit.getInstance().init();
        CloudBackupTaskManager.getInstance().setMaxFileTaskSize(0);
        C12565k.m75521g();
        C12565k.m75522h();
        C12565k.m75520f();
        C12565k.m75519e();
        C12565k.m75524j();
        cleanCloneCache();
        ICBBaseReceiver iCBBaseReceiver = new ICBBaseReceiver();
        this.f22422b = iCBBaseReceiver;
        mo29595r(iCBBaseReceiver);
        C11839m.m70688i("ICBBaseV3Task", "v3 task init end.");
    }

    /* renamed from: j */
    public String m29587j() {
        return this.f22427g;
    }

    /* renamed from: k */
    public int m29588k() {
        return this.f22425e;
    }

    /* renamed from: l */
    public String m29589l() {
        return this.f22429i;
    }

    /* renamed from: m */
    public abstract boolean mo29590m();

    /* renamed from: n */
    public abstract boolean mo29591n();

    /* renamed from: o */
    public abstract void mo29592o(Context context, HiCloudSafeIntent hiCloudSafeIntent, Handler handler);

    /* renamed from: p */
    public abstract void mo29593p() throws C9721b;

    public void processNetworkChanged(Context context, Handler handler) {
        C11839m.m70688i("ICBBaseV3Task", "processNetworkChanged " + C0209d.m1333z1(context));
        MobileTrafficReport.getInstance().setMobile(false);
        C12592t.m75950g().m75966r();
        if (!C0209d.m1333z1(context)) {
            C11839m.m70688i("ICBBaseV3Task", "send abort delayed and do pause. network is not connected");
            C10782d.m65634a().m65650q(1);
            sendAbortMessage(true, handler);
            return;
        }
        if (C0209d.m1254f2(context)) {
            C11839m.m70688i("ICBBaseV3Task", "processNetworkChanged is wifi connected");
            C10782d.m65634a().m65651r(2);
            return;
        }
        int iM65636c = C10782d.m65634a().m65636c();
        if (!C10782d.m65634a().m65643j(context)) {
            C11839m.m70688i("ICBBaseV3Task", "send delayed and do pause CMD_TYPE_CBABORT_WIFI.");
            m29601z(iM65636c);
            sendAbortMessage(true, handler);
            return;
        }
        MobileTrafficReport.getInstance().setMobile(true);
        int iM65637d = C10782d.m65634a().m65637d(context);
        C11839m.m70688i("ICBBaseV3Task", "currentSlotId " + iM65637d + " slotId " + iM65636c);
        if (C10782d.m65634a().m65649p(context)) {
            if (iM65636c != 3) {
                C11839m.m70688i("ICBBaseV3Task", "vsim send abort delayed and do pause.");
                m29601z(iM65636c);
                sendAbortMessage(false, handler);
                return;
            }
            return;
        }
        if (iM65637d != iM65636c) {
            C11839m.m70688i("ICBBaseV3Task", "send abort delayed and do pause.");
            m29601z(iM65636c);
            sendAbortMessage(false, handler);
        }
    }

    /* renamed from: q */
    public abstract void mo29594q() throws C9721b;

    /* renamed from: r */
    public abstract void mo29595r(ICBBaseReceiver iCBBaseReceiver);

    public void registThermalCallback() {
    }

    @Override // p581qk.AbstractC12365b, p616rk.AbstractRunnableC12516b
    public void release() {
        synchronized (this) {
            try {
                CacheTask.State state = CacheTask.State.DONE;
                if (state.equals(getState())) {
                    C11839m.m70688i("ICBBaseV3Task", "task already released.");
                    return;
                }
                setState(state);
                C11839m.m70688i("ICBBaseV3Task", "task released start.");
                C12591s1.m75931a().m75946p(false);
                m29579A();
                unRegistThermalCallback();
                try {
                    reportEvent();
                    mo29584f();
                } catch (Exception e10) {
                    C11839m.m70687e("ICBBaseV3Task", "task released error." + e10.toString());
                }
                mo29598u(this.f22428h, "Finish cloudbackup");
                CBAccess.removeTask(this);
                mo29597t();
                autoBackupKeepUnLock();
                ContentValues contentValues = new ContentValues();
                contentValues.put("doBackupTime", (Long) 0L);
                C12299b.m73937s(contentValues);
                m29580B();
                BackupPowerKitKeepTimer.getInstance().remove(this.f22429i);
                ClonePowerKit.getInstance().release();
                C11839m.m70688i("ICBBaseV3Task", "task released success.");
                if (3935 == getErrCode()) {
                    C11839m.m70688i("ICBBaseV3Task", "get backup lock fail, the device was freeze, close the backup switch.");
                    C14315h.m85262p().m85272K(false);
                    Message message = new Message();
                    message.what = 33036;
                    CBCallBack.getInstance().sendMessage(message);
                }
                Optional.ofNullable(this.f22430j).ifPresent(new Consumer() { // from class: am.f1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((InterfaceC1262c) obj).mo1754b();
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void reportEachTask(C13029h c13029h, String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap;
        C11839m.m70686d("ICBBaseV3Task", "report each period");
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", c13029h.m78444J());
        linkedHashMap.put("backupId", c13029h.m78465h());
        linkedHashMap.put("id", c13029h.m78436B());
        linkedHashMap.put("backupVersion", CBSBaseReq.CURRENT_API_VERSION);
        linkedHashMap.put("is_refurbish", String.valueOf(mo29590m()));
        linkedHashMap.put("is_temp_backup", String.valueOf(mo29591n()));
        linkedHashMap.put("bakCategory", String.valueOf(m29587j()));
        addEntryType(linkedHashMap);
        str.hashCode();
        switch (str) {
            case "cloudbackup_total_size":
            case "restore_total_size":
                C11839m.m70686d("ICBBaseV3Task", "report total size");
                linkedHashMap.put("totalSize", str2);
                linkedHashMap.put("isSuccess", String.valueOf(this.f22426f));
                linkedHashMap.put("code", c13029h.m78474q());
                linkedHashMap.put("errMsg", this.errMsg);
                long jM81078f = C13466f.m81073d().m81078f("restoringBackupRecordEndTime", 0L);
                if (jM81078f > 0) {
                    linkedHashMap.put("backupEndTime", String.valueOf(jM81078f));
                    break;
                }
                break;
            case "restore_each_size":
            case "cloudbackup_each_backup_size":
                C11839m.m70686d("ICBBaseV3Task", "report each backup or restore datasize. ");
                linkedHashMap.put("data_size", str2);
                break;
            case "restore_each_period":
            case "cloudbackup_each_period":
                C11839m.m70686d("ICBBaseV3Task", "report each period. ");
                linkedHashMap.put("startTime", String.valueOf(c13029h.m78440F()));
                linkedHashMap.put(FrequencyManager.H5DialogConstant.BEGIN_TIME, String.valueOf(c13029h.m78469k()));
                linkedHashMap.put("endTime", String.valueOf(c13029h.m78464f()));
                long jM76065d = C12604x.m76065d(c13029h.m78444J());
                C12604x.m76064c();
                linkedHashMap.put("actuallySize", String.valueOf(jM76065d));
                long jCurrentTimeMillis = System.currentTimeMillis() - c13029h.m78469k();
                if (jCurrentTimeMillis > 0) {
                    linkedHashMap.put("restoreTime", String.valueOf(jCurrentTimeMillis));
                    break;
                }
                break;
        }
        if (!TextUtils.equals("restore_each_period", str) && !TextUtils.equals("cloudbackup_each_period", str)) {
            linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, c13029h.m78465h())));
        }
        C13225d.m79490f1().m79603z0(str, linkedHashMap);
    }

    public abstract void reportEvent();

    public void reportInterruptOrAuto(C13029h c13029h, String str) {
        LinkedHashMap<String, String> linkedHashMap;
        C11839m.m70686d("ICBBaseV3Task", "report interrupt status");
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", c13029h.m78444J());
        linkedHashMap.put("backupId", c13029h.m78465h());
        linkedHashMap.put("id", c13029h.m78436B());
        addEntryType(linkedHashMap);
        str.hashCode();
        switch (str) {
            case "cloudbackup_auto_times":
                C11839m.m70686d("ICBBaseV3Task", "report autobackup times");
                linkedHashMap.put("count", String.valueOf(c13029h.m78476r()));
                break;
            case "restore_interrupt_times":
                C11839m.m70686d("ICBBaseV3Task", "report interrupt times");
                linkedHashMap.put("times", "1");
                linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, c13029h.m78465h())));
                break;
            case "restore_interrupt_report":
                C11839m.m70686d("ICBBaseV3Task", "report interrupt details");
                linkedHashMap.put("reason", c13029h.m78474q());
                linkedHashMap.put(FrequencyManager.H5DialogConstant.BEGIN_TIME, String.valueOf(c13029h.m78469k()));
                linkedHashMap.put("endTime", String.valueOf(c13029h.m78464f()));
                linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, c13029h.m78465h())));
                break;
        }
        C13225d.m79490f1().m79603z0(str, linkedHashMap);
    }

    /* renamed from: s */
    public void m29596s() {
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) CacheTask.getContext().getSystemService("power")).newWakeLock(1, "CloudBackup");
        this.f22421a = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
        C11839m.m70688i("ICBBaseV3Task", "cloud backup wakelock acquire.");
    }

    public final void sendAbortMessage(boolean z10, Handler handler) {
        pause();
        if (z10) {
            handler.sendEmptyMessageDelayed(3202, 10000L);
        } else {
            handler.sendEmptyMessage(3202);
        }
    }

    /* renamed from: t */
    public void mo29597t() {
    }

    /* renamed from: u */
    public abstract void mo29598u(long j10, String str);

    public void unRegistThermalCallback() {
    }

    /* renamed from: v */
    public void m29599v(String str) {
        this.f22424d = str;
    }

    /* renamed from: y */
    public void m29600y(int i10) {
        this.f22425e = i10;
    }

    /* renamed from: z */
    public final void m29601z(int i10) {
        if (i10 == 2) {
            C10782d.m65634a().m65650q(2);
        } else {
            C10782d.m65634a().m65650q(1);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask, p581qk.AbstractC12365b
    public void abort() {
        super.abort();
        executeAsyncTask(new CacheTask.AsyncTask(new CacheTask.IAsyncTask() { // from class: am.g1
            @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask.IAsyncTask
            public final void run() {
                this.f942a.release();
            }
        }));
    }
}
