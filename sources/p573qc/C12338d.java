package p573qc;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.StatusInfo;
import com.huawei.android.hicloud.sync.jobscheduler.CalllogJobService;
import com.huawei.android.hicloud.sync.jobscheduler.CalllogRetryJobService;
import com.huawei.android.hicloud.sync.jobscheduler.ContactObserverJobService;
import com.huawei.android.hicloud.sync.jobscheduler.ContactRetryJobService;
import com.huawei.android.hicloud.sync.jobscheduler.GroupObserverJobService;
import com.huawei.android.hicloud.sync.jobscheduler.NetConnectedJobService;
import com.huawei.android.hicloud.sync.jobscheduler.PhoneManagerJobService;
import com.huawei.android.hicloud.sync.jobscheduler.PhoneManagerRetryJobService;
import com.huawei.android.hicloud.sync.jobscheduler.RecordingJobService;
import com.huawei.android.hicloud.sync.jobscheduler.RecordingRetryJobService;
import com.huawei.android.hicloud.sync.jobscheduler.SMSJobService;
import com.huawei.android.hicloud.sync.jobscheduler.SmsBackupJobService;
import com.huawei.android.hicloud.sync.jobscheduler.SmsRetryJobService;
import com.huawei.android.hicloud.sync.jobscheduler.WlanRetryJobService;
import com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol;
import com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.android.hicloud.sync.syncutil.C2972a;
import com.huawei.android.hicloud.sync.wifi.datamanager.WlanManager;
import com.huawei.fastengine.fastview.NavigationUtils;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import gp.C10028c;
import java.util.Iterator;
import md.C11440c;
import nc.C11662a;
import p015ak.C0206b0;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p609rc.C12487a;
import p616rk.C12515a;
import p636s8.C12762a;
import p783xp.C13843a;
import p836z8.C14158g;
import p836z8.C14159h;
import sc.C12776i;

/* renamed from: qc.d */
/* loaded from: classes3.dex */
public class C12338d {

    /* renamed from: i */
    public static final C12338d f57101i = new C12338d();

    /* renamed from: j */
    public static final Uri f57102j = Uri.parse("content://com.huawei.android.ds.cloudsync.provider/sync_switch");

    /* renamed from: a */
    public boolean f57103a = false;

    /* renamed from: b */
    public Uri f57104b = Uri.parse("content://sms/");

    /* renamed from: c */
    public d f57105c;

    /* renamed from: d */
    public final Handler f57106d;

    /* renamed from: e */
    public C12336b f57107e;

    /* renamed from: f */
    public C12337c f57108f;

    /* renamed from: g */
    public C12762a f57109g;

    /* renamed from: h */
    public C12339e f57110h;

    /* renamed from: qc.d$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 8) {
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.NETWORK_CHANGE_SYNC);
                return;
            }
            if (i10 == 9) {
                C11839m.m70688i("ObserverManager", "contact change group change");
                if (C12338d.this.f57108f != null) {
                    C12338d.this.f57108f.m74182c(false);
                }
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.OBSERVE_CONTACT_CHANGE_SYNC);
                return;
            }
            if (i10 == 16) {
                C11839m.m70688i("ObserverManager", "contact change contact change");
                if (C12338d.this.f57107e != null) {
                    C12338d.this.f57107e.m74182c(false);
                }
                ICSServiceProtocol.getInstance().doSyncContact(SyncType.OBSERVE_CONTACT_CHANGE_SYNC);
                return;
            }
            if (i10 == 17) {
                C12338d.this.m74211O();
                return;
            }
            if (i10 == 96) {
                C11839m.m70688i("ObserverManager", "Content changed or receive push, sync contact");
                SyncType syncType = SyncType.MAMUNAL_OPENAUTO_SYNC;
                Object obj = message.obj;
                if (obj != null && (obj instanceof SyncType)) {
                    syncType = (SyncType) obj;
                }
                ICSServiceProtocol.getInstance().doSyncContact(syncType);
                return;
            }
            if (i10 == 112) {
                C12338d.this.f57103a = false;
                C11839m.m70688i("ObserverManager", "contact sync after net change");
                if (C12338d.this.m74257x("addressbook", C0213f.m1377a())) {
                    C11839m.m70688i("ObserverManager", "network change sync after last fail");
                    ICSServiceProtocol.getInstance().doSyncContact(SyncType.LAST_FAIL_NETWORK_CHANGE_SYNC);
                    return;
                }
                return;
            }
            if (i10 == 128) {
                C12338d.this.m74246r(message);
            } else if (i10 != 137) {
                C12338d.this.m74249t(message);
            } else {
                C12338d.this.m74210N();
            }
        }
    }

    /* renamed from: qc.d$b */
    public class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (CloudSyncUtil.m16045s()) {
                if (!C12338d.this.m74198B()) {
                    C11839m.m70688i("ObserverManager", "wlan not changed, not start doSyncWlan");
                } else {
                    C11839m.m70688i("ObserverManager", "wlan changed, start doSyncWlan");
                    ICSServiceProtocol.getInstance().doSyncWlan(SyncType.WlanSyncType.CONFIGURED_NETWORKS_CHANGE_SYNC);
                }
            }
        }
    }

    /* renamed from: qc.d$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Message f57113a;

        public c(Message message) {
            this.f57113a = message;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (CloudSyncUtil.m16045s()) {
                C11839m.m70688i("ObserverManager", "wlan sync AUTO_SYNC_WLAN");
                SyncType syncType = SyncType.WlanSyncType.COMMON_SYNC;
                Object obj = this.f57113a.obj;
                if (obj != null && (obj instanceof SyncType)) {
                    syncType = (SyncType) obj;
                }
                if (10 != syncType.getBiReportType() || C12338d.this.m74259y()) {
                    ICSServiceProtocol.getInstance().doSyncWlan(syncType);
                } else {
                    C11839m.m70688i("ObserverManager", "last sync fail and network change, but sync status is success.");
                }
            }
        }
    }

    /* renamed from: qc.d$d */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.intent.action.BATTERY_CHANGED".equals(new HiCloudSafeIntent(intent).getAction())) {
                C11839m.m70688i("ObserverManager", "ACTION_BATTERY_CHANGED");
                C12338d.this.m74205I(intent);
            }
        }

        public /* synthetic */ d(C12338d c12338d, a aVar) {
            this();
        }
    }

    /* renamed from: qc.d$e */
    public static class e extends AbstractC12367d {

        /* renamed from: a */
        public String f57116a;

        public /* synthetic */ e(String str, a aVar) {
            this(str);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if ("dsswitch".equals(this.f57116a)) {
                C12338d.m74183B0();
            }
        }

        public e(String str) {
            this.f57116a = str;
        }
    }

    public C12338d() {
        a aVar = new a(Looper.getMainLooper());
        this.f57106d = aVar;
        this.f57107e = new C12336b(aVar, C0213f.m1377a());
        this.f57108f = new C12337c(aVar, C0213f.m1377a());
        this.f57109g = new C12762a(C0213f.m1377a(), aVar);
        this.f57110h = new C12339e(C0213f.m1377a(), aVar);
    }

    /* renamed from: B0 */
    public static void m74183B0() {
        try {
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            boolean zM62388s = c10028cM62182c0.m62388s("wlan");
            boolean zM62388s2 = c10028cM62182c0.m62388s("autosmslistkey");
            boolean zM62388s3 = c10028cM62182c0.m62388s("autocallloglistkey");
            boolean zM62388s4 = c10028cM62182c0.m62388s("autorecordingkey");
            boolean zM62388s5 = c10028cM62182c0.m62388s("autophonemanagerkey");
            ContentValues contentValues = new ContentValues();
            contentValues.put("wlan", Boolean.valueOf(zM62388s));
            contentValues.put("autosmslistkey", Boolean.valueOf(zM62388s2));
            contentValues.put("autocallloglistkey", Boolean.valueOf(zM62388s3));
            contentValues.put("autorecordingkey", Boolean.valueOf(zM62388s4));
            contentValues.put("autophonemanagerkey", Boolean.valueOf(zM62388s5));
            int iUpdate = C0213f.m1377a().getContentResolver().update(f57102j, contentValues, null, null);
            c10028cM62182c0.m62281U2("has_send_switch_to_ds", iUpdate == 0);
            C11839m.m70688i("ObserverManager", "sync switch to ds: wlan,sms,calllog,recording,phoneManager:" + zM62388s + "," + zM62388s2 + "," + zM62388s3 + "," + zM62388s4 + "," + zM62388s5 + " to ds end, result:" + iUpdate);
        } catch (Exception e10) {
            C11839m.m70687e("ObserverManager", "sync switch to ds error: " + e10.toString());
        }
    }

    /* renamed from: s */
    public static final C12338d m74195s() {
        return f57101i;
    }

    /* renamed from: A */
    public boolean m74196A(int i10) {
        return m74255w(i10);
    }

    /* renamed from: A0 */
    public void m74197A0() {
        C11839m.m70688i("ObserverManager", "unRegisterWlanRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(1004);
        }
    }

    /* renamed from: B */
    public final boolean m74198B() {
        try {
            return new WlanManager(C0213f.m1377a()).isHaveChange();
        } catch (Exception e10) {
            C11839m.m70687e("ObserverManager", "check local wlan has changed exception: " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: C */
    public void m74199C() {
        C12762a c12762a = this.f57109g;
        if (c12762a != null) {
            c12762a.onChange(false);
        }
    }

    /* renamed from: D */
    public final void m74200D() {
        C11839m.m70686d("ObserverManager", "CONFIGURED_NETWORKS_CHANGED_ACTION");
        m74238n();
    }

    /* renamed from: E */
    public void m74201E() {
        m74207K(C0213f.m1377a());
    }

    /* renamed from: F */
    public void m74202F() {
        C12336b c12336b = this.f57107e;
        if (c12336b != null) {
            c12336b.onChange(false);
        }
    }

    /* renamed from: G */
    public void m74203G() {
        C12337c c12337c = this.f57108f;
        if (c12337c != null) {
            c12337c.onChange(false);
        }
    }

    /* renamed from: H */
    public void m74204H() {
        C12339e c12339e = this.f57110h;
        if (c12339e != null) {
            c12339e.onChange(false);
        }
    }

    /* renamed from: I */
    public final void m74205I(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = 0;
        try {
            intExtra = intent.getIntExtra(FaqConstants.FAQ_LEVEL, 0);
        } catch (RuntimeException unused) {
            C11839m.m70688i("ObserverManager", "intent Serializable error.");
        }
        int intExtra2 = 1;
        try {
            intExtra2 = intent.getIntExtra("status", 1);
        } catch (RuntimeException unused2) {
            C11839m.m70688i("ObserverManager", "intent Serializable error.");
        }
        C11839m.m70688i("ObserverManager", "batteryStatus: " + intExtra2);
        if (intExtra2 == 2 || intExtra2 == 5 || intExtra >= 10) {
            return;
        }
        C11839m.m70689w("ObserverManager", "battery level lower than 10%");
        C11440c.m68535m(-14);
    }

    /* renamed from: J */
    public final void m74206J() {
        if (m74236m(CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
            if (CloudSyncUtil.m16052u0(C0213f.m1377a(), "autosmslistkey") && m74261z("autosmslistkey", C0213f.m1377a())) {
                C11839m.m70688i("ObserverManager", "last sync fail doBackupSms");
                m74232j0(130, 40000L);
            }
            if (CloudSyncUtil.m16052u0(C0213f.m1377a(), "autocallloglistkey") && m74261z("autocallloglistkey", C0213f.m1377a())) {
                C11839m.m70688i("ObserverManager", "last sync fail doBackupCallog");
                m74232j0(SyncType.AUTO_SYNC_CALLLOG, 20000L);
            }
            if (CloudSyncUtil.m16052u0(C0213f.m1377a(), "autorecordingkey") && m74261z("autorecordingkey", C0213f.m1377a()) && CloudSyncUtil.m16062z0(C0213f.m1377a(), "autorecordingkey")) {
                C11839m.m70688i("ObserverManager", "last sync fail doBackupRecording");
                C14158g.m84966c(0L, C0213f.m1377a());
                m74231i0(SyncType.AUTO_SYNC_RECORD);
            }
            if (CloudSyncUtil.m16052u0(C0213f.m1377a(), "autophonemanagerkey") && m74261z("autophonemanagerkey", C0213f.m1377a()) && CloudSyncUtil.m16062z0(C0213f.m1377a(), "autophonemanagerkey")) {
                C11839m.m70688i("ObserverManager", "last sync fail doBackupPhoneManager");
                m74232j0(SyncType.AUTO_SYNC_PHONE_MANAGER, 30000L);
            }
        }
    }

    /* renamed from: K */
    public final void m74207K(Context context) {
        C11839m.m70688i("ObserverManager", "process net changed.");
        if (!C0209d.m1333z1(context)) {
            ICSServiceProtocol.getInstance().doAbort();
            return;
        }
        C11839m.m70686d("ObserverManager", "net connect");
        if (!C13843a.m83073Y(C0213f.m1377a())) {
            m74208L(context);
        }
        if (CloudSyncUtil.m15964M0(context) && m74259y()) {
            m74209M();
        }
    }

    /* renamed from: L */
    public final void m74208L(Context context) {
        if (!C0206b0.m1131c("addressbook", context) || C14159h.m84967a(context, "addressbook")) {
            return;
        }
        C11839m.m70686d("ObserverManager", "net connect,contact sync button open");
        if (!m74257x("addressbook", context)) {
            Message message = new Message();
            message.what = 8;
            message.obj = SyncType.NETWORK_CHANGE_SYNC;
            this.f57106d.sendMessage(message);
            return;
        }
        C11839m.m70688i("ObserverManager", "net connect,contact sync last fail , process ");
        if (this.f57103a) {
            return;
        }
        this.f57103a = true;
        Message message2 = new Message();
        message2.what = 112;
        message2.obj = SyncType.NETWORK_CHANGE_SYNC;
        this.f57106d.sendMessageDelayed(message2, 120000L);
    }

    /* renamed from: M */
    public final void m74209M() {
        C11839m.m70688i("ObserverManager", "net connect,wlan sync last fail , process ");
        this.f57106d.removeMessages(128);
        Message message = new Message();
        message.what = 128;
        message.obj = SyncType.WlanSyncType.LAST_FAIL_NETWORK_CHANGE_SYNC;
        this.f57106d.sendMessageDelayed(message, 120000L);
    }

    /* renamed from: N */
    public void m74210N() {
        C11839m.m70688i("ObserverManager", "processWifiConfigChanged");
        if (CloudSyncUtil.m15964M0(C0213f.m1377a())) {
            if (CloudSyncUtil.m16046s0()) {
                C11839m.m70688i("ObserverManager", "CONFIGURED_NETWORKS_CHANGE isInDelayTime.");
                return;
            } else if (m74259y()) {
                m74209M();
            } else {
                m74200D();
            }
        }
        if (!C13843a.m83073Y(C0213f.m1377a()) && m74257x("addressbook", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "last sync fail sync contact");
            m74208L(C0213f.m1377a());
        }
        m74206J();
    }

    /* renamed from: O */
    public final void m74211O() {
        C11839m.m70688i("ObserverManager", "receiveWlanChange");
        C12515a.m75110o().m75172d(new b());
    }

    /* renamed from: P */
    public final void m74212P() {
        if (CloudSyncUtil.m16062z0(C0213f.m1377a(), "autorecordingkey")) {
            C11839m.m70688i("ObserverManager", "do recording sync");
            ICDServiceProtocol.getInstance().doBackupRecording();
            C2972a.m17807a("recording");
            C14159h.m84968b(C0213f.m1377a(), "recording");
            return;
        }
        C11839m.m70689w("ObserverManager", "record Sync update only by wifi update SP result:" + C14158g.m84965b("autorecordingkeynotAllSucess", C0213f.m1377a()));
    }

    /* renamed from: Q */
    public void m74213Q() {
        C11839m.m70688i("ObserverManager", "registerBatteryReceiver");
        if (this.f57105c == null) {
            this.f57105c = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            C0213f.m1377a().registerReceiver(this.f57105c, intentFilter);
        }
    }

    /* renamed from: R */
    public void m74214R() {
        if (C11829c.m70611r0()) {
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            C11839m.m70688i("ObserverManager", "registerCallLogRetryScheduler");
            jobScheduler.schedule(new JobInfo.Builder(1007, new ComponentName(C0213f.m1377a(), (Class<?>) CalllogRetryJobService.class)).setMinimumLatency(300000L).setRequiredNetworkType(1).setOverrideDeadline(86400000L).setPersisted(true).build());
        }
    }

    /* renamed from: S */
    public void m74215S() {
        if (C11829c.m70611r0()) {
            return;
        }
        if (!C0206b0.m1131c("autocallloglistkey", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "calllog switch not open, not register scheduler");
            return;
        }
        if (!C0206b0.m1131c("funcfg_call_log_up", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "not support funcfg_call_log_up");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerCalllogScheduler");
        if (m74255w(1006)) {
            C11839m.m70688i("ObserverManager", "call log JobServiceOn");
        } else {
            C11839m.m70688i("ObserverManager", "registerCalllogScheduler do job");
            jobScheduler.schedule(new JobInfo.Builder(1006, new ComponentName(C0213f.m1377a(), (Class<?>) CalllogJobService.class)).addTriggerContentUri(new JobInfo.TriggerContentUri(CallLog.Calls.CONTENT_URI, 1)).setOverrideDeadline(86400000L).build());
        }
    }

    /* renamed from: T */
    public void m74216T() {
        if (C11829c.m70611r0()) {
            return;
        }
        C11839m.m70688i("ObserverManager", "registerConnectivityChange");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(1005, new ComponentName(C0213f.m1377a(), (Class<?>) NetConnectedJobService.class)).setOverrideDeadline(86400000L).setRequiredNetworkType(1).build());
        }
    }

    /* renamed from: U */
    public void m74217U() {
        if (C11829c.m70611r0()) {
            return;
        }
        C11839m.m70688i("ObserverManager", "registerContactRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(1003, new ComponentName(C0213f.m1377a(), (Class<?>) ContactRetryJobService.class)).setMinimumLatency(300000L).setOverrideDeadline(86400000L).setRequiredNetworkType(1).setPersisted(true).build());
        }
    }

    /* renamed from: V */
    public void m74218V() {
        if (C11829c.m70611r0()) {
            return;
        }
        if (C13843a.m83073Y(C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "support contact sync ability");
            return;
        }
        if (!C0206b0.m1131c("addressbook", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "contact switch not open");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerContactScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else if (m74255w(1001)) {
            C11839m.m70688i("ObserverManager", "has jobServiceOn JOB_ID_CONTACT");
        } else {
            C11839m.m70688i("ObserverManager", "register ContactObserverJobService");
            jobScheduler.schedule(new JobInfo.Builder(1001, new ComponentName(C0213f.m1377a(), (Class<?>) ContactObserverJobService.class)).addTriggerContentUri(new JobInfo.TriggerContentUri(ContactsContract.RawContacts.CONTENT_URI, 1)).setOverrideDeadline(86400000L).build());
        }
    }

    /* renamed from: W */
    public void m74219W() {
        if (C11829c.m70611r0()) {
            return;
        }
        if (C13843a.m83073Y(C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "support contact sync ability");
            return;
        }
        if (!C0206b0.m1131c("addressbook", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "contact switch not open");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerGroupScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else if (m74255w(1002)) {
            C11839m.m70688i("ObserverManager", "has jobServiceOn JOB_ID_GROUP");
        } else {
            C11839m.m70688i("ObserverManager", "register GroupObserverJobService");
            jobScheduler.schedule(new JobInfo.Builder(1002, new ComponentName(C0213f.m1377a(), (Class<?>) GroupObserverJobService.class)).addTriggerContentUri(new JobInfo.TriggerContentUri(ContactsContract.Groups.CONTENT_URI, 1)).setOverrideDeadline(86400000L).build());
        }
    }

    /* renamed from: X */
    public void m74220X() {
        if (C11829c.m70611r0()) {
            return;
        }
        C11839m.m70688i("ObserverManager", "registerPhoneManagerRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED, new ComponentName(C0213f.m1377a(), (Class<?>) PhoneManagerRetryJobService.class)).setMinimumLatency(300000L).setOverrideDeadline(86400000L).setRequiredNetworkType(1).setPersisted(true).build());
        }
    }

    /* renamed from: Y */
    public void m74221Y() {
        if (C11829c.m70611r0()) {
            return;
        }
        if (!C0206b0.m1131c("autophonemanagerkey", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "PhoneManager switch not open, not register scheduler");
            return;
        }
        if (!C0206b0.m1131c("funcfg_blocked_up", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "not support funcfg_blocked_up");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerPhoneManagerScheduler");
        if (m74255w(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN)) {
            C11839m.m70688i("ObserverManager", "PhoneManager JobServiceOn");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerPhoneManagerScheduler do job");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN, new ComponentName(C0213f.m1377a(), (Class<?>) PhoneManagerJobService.class)).setMinimumLatency(86400000L).setRequiredNetworkType(1).setOverrideDeadline(86400000L).setPersisted(true).build());
        }
    }

    /* renamed from: Z */
    public void m74222Z() {
        if (C11829c.m70611r0()) {
            return;
        }
        C11839m.m70688i("ObserverManager", "registerRecordingRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, new ComponentName(C0213f.m1377a(), (Class<?>) RecordingRetryJobService.class)).setMinimumLatency(300000L).setOverrideDeadline(86400000L).setRequiredNetworkType(1).setPersisted(true).build());
        }
    }

    /* renamed from: a0 */
    public void m74223a0() {
        if (!C0206b0.m1131c("autorecordingkey", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "Recording switch not open, not register scheduler");
            return;
        }
        if (!C0206b0.m1131c("funcfg_recordings_up", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "not support funcfg_recordings_up");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerRecordingScheduler");
        if (m74255w(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH)) {
            C11839m.m70688i("ObserverManager", "Recording JobServiceOn");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerRecordingScheduler do job");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, new ComponentName(C0213f.m1377a(), (Class<?>) RecordingJobService.class)).setMinimumLatency(82800000L).setRequiredNetworkType(1).setOverrideDeadline(82800000L).setPersisted(true).build());
        }
    }

    /* renamed from: b0 */
    public void m74224b0() {
        if (CloudSyncUtil.m16025l0() || !CloudSyncUtil.m15954H0(C0213f.m1377a())) {
            m74256w0();
        } else {
            m74223a0();
        }
    }

    /* renamed from: c0 */
    public void m74225c0() {
        if (C11829c.m70611r0()) {
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerSmsBackupScheduler");
        if (m74255w(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH)) {
            C11839m.m70688i("ObserverManager", "SMS backup JobServiceOn");
        } else {
            C11839m.m70688i("ObserverManager", "registerSmsBackupScheduler do job");
            jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, new ComponentName(C0213f.m1377a(), (Class<?>) SmsBackupJobService.class)).setMinimumLatency(2100000L).setRequiredNetworkType(1).setOverrideDeadline(86400000L).build());
        }
    }

    /* renamed from: d0 */
    public void m74226d0() {
        if (C11829c.m70611r0()) {
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            C11839m.m70688i("ObserverManager", "registerSmsRetryScheduler");
            jobScheduler.schedule(new JobInfo.Builder(1009, new ComponentName(C0213f.m1377a(), (Class<?>) SmsRetryJobService.class)).setMinimumLatency(300000L).setRequiredNetworkType(1).setOverrideDeadline(86400000L).setPersisted(true).build());
        }
    }

    /* renamed from: e0 */
    public void m74227e0() {
        if (C11829c.m70611r0()) {
            return;
        }
        if (!C0206b0.m1131c("autosmslistkey", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "SMS switch not open, not registe scheduler");
            return;
        }
        if (!C0206b0.m1131c("funcfg_messaging_up", C0213f.m1377a())) {
            C11839m.m70688i("ObserverManager", "not support funcfg_messaging_up");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
            return;
        }
        C11839m.m70688i("ObserverManager", "registerSmsScheduler");
        if (m74255w(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST)) {
            C11839m.m70688i("ObserverManager", "SMS JobServiceOn");
        } else {
            C11839m.m70688i("ObserverManager", "registerSmsScheduler do job");
            jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, new ComponentName(C0213f.m1377a(), (Class<?>) SMSJobService.class)).addTriggerContentUri(new JobInfo.TriggerContentUri(this.f57104b, 1)).setTriggerContentMaxDelay(2100000L).setMinimumLatency(2100000L).setOverrideDeadline(86400000L).build());
        }
    }

    /* renamed from: f0 */
    public void m74228f0() {
        if (C11829c.m70611r0()) {
            return;
        }
        C11839m.m70688i("ObserverManager", "registerWlanRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.schedule(new JobInfo.Builder(1004, new ComponentName(C0213f.m1377a(), (Class<?>) WlanRetryJobService.class)).setMinimumLatency(300000L).setOverrideDeadline(86400000L).setRequiredNetworkType(1).setPersisted(true).build());
        }
    }

    /* renamed from: g0 */
    public void m74229g0(String str) {
        C12515a.m75110o().m75172d(new e(str, null));
    }

    /* renamed from: h0 */
    public final boolean m74230h0() {
        if (!CloudSyncUtil.m15964M0(C0213f.m1377a())) {
            C11839m.m70686d("ObserverManager", "wlan switch not open.");
            return false;
        }
        Message message = new Message();
        message.what = 17;
        this.f57106d.sendMessageDelayed(message, 10000L);
        C11839m.m70686d("ObserverManager", "sendNetworksChangeMsg send message delay 10s");
        return true;
    }

    /* renamed from: i0 */
    public void m74231i0(int i10) {
        this.f57106d.removeMessages(i10);
        Message message = new Message();
        message.what = i10;
        this.f57106d.sendMessageDelayed(message, 10000L);
    }

    /* renamed from: j0 */
    public final void m74232j0(int i10, long j10) {
        this.f57106d.removeMessages(i10);
        Message message = new Message();
        message.what = i10;
        this.f57106d.sendMessageDelayed(message, j10);
    }

    /* renamed from: k0 */
    public void m74233k0() {
        C11839m.m70688i("ObserverManager", "unRegisterAllScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
            return;
        }
        jobScheduler.cancel(1001);
        jobScheduler.cancel(1002);
        jobScheduler.cancel(1003);
        jobScheduler.cancel(1004);
        jobScheduler.cancel(1005);
        jobScheduler.cancel(1006);
        jobScheduler.cancel(1007);
        jobScheduler.cancel(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
        jobScheduler.cancel(1009);
        jobScheduler.cancel(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH);
        jobScheduler.cancel(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN);
        jobScheduler.cancel(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
        jobScheduler.cancel(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED);
    }

    /* renamed from: l */
    public void m74234l() {
        C11839m.m70688i("ObserverManager", "call main process provider");
        if (C11662a.m69650c(C0213f.m1377a()).m69652b("already_update_badge")) {
            return;
        }
        C11839m.m70688i("ObserverManager", "first start call main process provider");
        C0206b0.m1129a(C0213f.m1377a());
        C11662a.m69650c(C0213f.m1377a()).m69654e("already_update_badge", true);
    }

    /* renamed from: l0 */
    public void m74235l0() {
        C11839m.m70688i("ObserverManager", "unRegisterBatteryReceiver");
        if (this.f57105c != null) {
            C0213f.m1377a().unregisterReceiver(this.f57105c);
            this.f57105c = null;
        }
    }

    /* renamed from: m */
    public boolean m74236m(String str) {
        int iM15939A = CloudSyncUtil.m15939A(C0213f.m1377a());
        C11839m.m70688i("ObserverManager", "checkBatteryLevel batteryLevel: " + iM15939A);
        if (iM15939A >= 10) {
            return true;
        }
        C11839m.m70689w("ObserverManager", "batterylever lower than 10%" + str + " no backup");
        if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(str)) {
            return false;
        }
        C14158g.m84965b(str + "notAllSucess", C0213f.m1377a());
        return false;
    }

    /* renamed from: m0 */
    public void m74237m0() {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            C11839m.m70688i("ObserverManager", "unRegisterCallLogRetryScheduler");
            jobScheduler.cancel(1007);
        }
    }

    /* renamed from: n */
    public final void m74238n() {
        this.f57106d.removeMessages(17);
        m74230h0();
    }

    /* renamed from: n0 */
    public void m74239n0() {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            C11839m.m70688i("ObserverManager", "unRegisterCalllogScheduler");
            jobScheduler.cancel(1006);
        }
    }

    /* renamed from: o */
    public void m74240o() {
        C11839m.m70688i("ObserverManager", "delayProcessWifiConfigChanged");
        this.f57106d.removeMessages(SyncType.DELAY_START_SYNC);
        Message message = new Message();
        message.what = SyncType.DELAY_START_SYNC;
        this.f57106d.sendMessageDelayed(message, 10000L);
    }

    /* renamed from: o0 */
    public void m74241o0() {
        C11839m.m70688i("ObserverManager", "unRegisterConnectivityChange");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(1005);
        }
    }

    /* renamed from: p */
    public final void m74242p() {
        ICDServiceProtocol.getInstance().doBackupPhoneManager();
        C2972a.m17807a("phonemanager");
        C14159h.m84968b(C0213f.m1377a(), "phonemanager");
    }

    /* renamed from: p0 */
    public void m74243p0() {
        C11839m.m70688i("ObserverManager", "unRegisterContactRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(1003);
        }
    }

    /* renamed from: q */
    public void m74244q() {
        if (m74236m("autorecordingkey")) {
            m74231i0(SyncType.AUTO_SYNC_RECORD);
        }
    }

    /* renamed from: q0 */
    public void m74245q0() {
        C11839m.m70688i("ObserverManager", "unRegisterContactScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(1001);
        }
    }

    /* renamed from: r */
    public final void m74246r(Message message) {
        C11839m.m70688i("ObserverManager", "doWlanSync");
        C12515a.m75110o().m75172d(new c(message));
    }

    /* renamed from: r0 */
    public void m74247r0() {
        C11839m.m70688i("ObserverManager", "unRegisterContactSyncScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
            return;
        }
        jobScheduler.cancel(1001);
        jobScheduler.cancel(1002);
        jobScheduler.cancel(1003);
    }

    /* renamed from: s0 */
    public void m74248s0() {
        C11839m.m70688i("ObserverManager", "unRegisterGroupScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(1002);
        }
    }

    /* renamed from: t */
    public final void m74249t(Message message) {
        int i10 = message.what;
        if (i10 == 136) {
            C11839m.m70688i("ObserverManager", "doBackupPhoneManager");
            m74242p();
        }
        switch (i10) {
            case 130:
                C11839m.m70688i("ObserverManager", "doBackupSms");
                ICDServiceProtocol.getInstance().doBackupSms();
                C2972a.m17807a(NavigationUtils.SMS_SCHEMA_PREF);
                C14159h.m84968b(C0213f.m1377a(), NavigationUtils.SMS_SCHEMA_PREF);
                break;
            case SyncType.AUTO_SYNC_CALLLOG /* 131 */:
                C11839m.m70688i("ObserverManager", "doBackupCallog");
                ICDServiceProtocol.getInstance().doBackupCallog();
                C2972a.m17807a("callLog");
                C14159h.m84968b(C0213f.m1377a(), "callLog");
                break;
            case SyncType.AUTO_SYNC_RECORD /* 132 */:
                C11839m.m70688i("ObserverManager", "recordSync");
                m74212P();
                break;
        }
    }

    /* renamed from: t0 */
    public void m74250t0() {
        C11839m.m70688i("ObserverManager", "unRegisterPhoneManagerRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(FamilyShareConstants.StatusCode.SPACE_SHARE_OPENED);
        }
    }

    /* renamed from: u */
    public void m74251u() {
        if (C11829c.m70611r0()) {
            return;
        }
        C11839m.m70688i("ObserverManager", "initContext");
        C12487a.m74966b(C0213f.m1377a());
        ICSServiceProtocol.getInstance().init(C0213f.m1377a());
        ICDServiceProtocol.getInstance().init(C0213f.m1377a());
    }

    /* renamed from: u0 */
    public void m74252u0() {
        C11839m.m70688i("ObserverManager", "unRegisterPhoneManagerScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
        }
    }

    /* renamed from: v */
    public void m74253v() {
        if (C11829c.m70611r0()) {
            return;
        }
        m74218V();
        m74219W();
        if (CloudSyncUtil.m16025l0()) {
            return;
        }
        m74215S();
        m74227e0();
        m74221Y();
    }

    /* renamed from: v0 */
    public void m74254v0() {
        C11839m.m70688i("ObserverManager", "unRegisterRecordingRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN);
        }
    }

    /* renamed from: w */
    public final boolean m74255w(int i10) {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
            return false;
        }
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: w0 */
    public void m74256w0() {
        C11839m.m70688i("ObserverManager", "unRegisterRecordingScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH);
        }
    }

    /* renamed from: x */
    public final boolean m74257x(String str, Context context) {
        return C0206b0.m1133e(str + "notAllSucess", context);
    }

    /* renamed from: x0 */
    public void m74258x0() {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            C11839m.m70688i("ObserverManager", "unRegisterSmsBackupScheduler");
            jobScheduler.cancel(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH);
        }
    }

    /* renamed from: y */
    public final boolean m74259y() {
        StatusInfo statusInfoM76683i = new C12776i().m76683i("wlannotAllSucess");
        if (statusInfoM76683i != null) {
            if (!String.valueOf(0).equals(statusInfoM76683i.getValue())) {
                C11839m.m70688i("ObserverManager", "wlan last sync fail");
                return true;
            }
        }
        return false;
    }

    /* renamed from: y0 */
    public void m74260y0() {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            C11839m.m70688i("ObserverManager", "unRegisterSmsRetryScheduler");
            jobScheduler.cancel(1009);
        }
    }

    /* renamed from: z */
    public final boolean m74261z(String str, Context context) {
        return C0206b0.m1130b(str + "notAllSucess", context);
    }

    /* renamed from: z0 */
    public void m74262z0() {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("ObserverManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
        }
    }
}
