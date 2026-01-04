package p807yd;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.CBState;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupState;
import com.huawei.android.hicloud.cloudbackup.broadcast.ICBBroadcastManager;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.BackupDeviceView;
import com.huawei.android.hicloud.p088ui.uiextend.NewBmBackupItemView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.router.data.SwitchInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import ne.C11667a;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0237v;
import p015ak.C0241z;
import p020ap.C1006a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p336he.C10155f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12591s1;
import p676ud.AbstractC13155b;
import p684un.C13225d;
import p847zk.C14317j;
import pm.C12199z;
import sk.C12809f;

/* renamed from: yd.f */
/* loaded from: classes3.dex */
public class C13950f {

    /* renamed from: a */
    public SharedPreferences f62565a;

    /* renamed from: b */
    public Activity f62566b;

    /* renamed from: c */
    public BackupDeviceView f62567c;

    /* renamed from: d */
    public NewBmBackupItemView f62568d;

    /* renamed from: e */
    public HwRecyclerView f62569e;

    /* renamed from: f */
    public SyncItemRecyclerAdapter f62570f;

    /* renamed from: g */
    public LinkedHashMap<String, SyncItemInfo> f62571g;

    /* renamed from: h */
    public AbstractC13155b f62572h;

    /* renamed from: i */
    public SwitchInfo f62573i;

    /* renamed from: j */
    public boolean f62574j;

    /* renamed from: k */
    public int f62575k = -1;

    /* renamed from: l */
    public Handler f62576l = new f(this, null);

    /* renamed from: m */
    public Handler f62577m = new a();

    /* renamed from: n */
    public Handler.Callback f62578n = new b();

    /* renamed from: yd.f$a */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
            if (bundle == null) {
                C11839m.m70687e("MainItemStatusController", "handleMessage bundle is null");
                return;
            }
            if (!C1006a.m5936k().m5938B()) {
                int i10 = message.what;
                if (i10 == 7016 || i10 == 9000) {
                    C13950f.this.m83878s0(bundle);
                    return;
                }
                return;
            }
            int i11 = message.what;
            if (i11 != 9097) {
                if (i11 != 9099 || C1006a.m5936k().m5975v(C13950f.this.f62566b)) {
                    return;
                }
                C13950f.this.m83854f0();
                return;
            }
            C11839m.m70686d("MainItemStatusController", "handleMessage, SYNC_PROMPT_UPDATE: " + message.what);
            C13950f.this.m83878s0(bundle);
        }
    }

    /* renamed from: yd.f$b */
    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 9009) {
                C11839m.m70686d("MainItemStatusController", "MSG_CLEAN_CACHE_FAIL");
                if (!C13950f.this.f62574j) {
                    return false;
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                Object obj = message.obj;
                String string = obj == null ? "" : obj.toString();
                if (!TextUtils.isEmpty(string)) {
                    linkedHashMap.put("filepath", string);
                }
                C13225d.m79490f1().m79567R("action_code_backup_clean_cache_fail", linkedHashMap);
                return false;
            }
            if (i10 == 32999) {
                if (message.arg1 == 3) {
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle == null) {
                        return false;
                    }
                    C13950f.this.m83882v(Long.valueOf(bundle.getLong("cloudbackup_last_success_time")));
                } else {
                    C13950f.this.m83882v((Long) message.obj);
                }
                C13950f c13950f = C13950f.this;
                c13950f.m83880u(c13950f.f62566b);
                return false;
            }
            if (i10 == 33038) {
                if (C13950f.this.f62567c == null) {
                    return false;
                }
                C13950f.this.f62567c.notifyItem();
                return false;
            }
            if (i10 == 32308) {
                C13950f.this.m83846X((CBState) message.obj);
                return false;
            }
            if (i10 != 32309 || C13950f.this.f62567c == null || message.arg1 != 0) {
                return false;
            }
            C13950f.this.f62567c.notifyItem();
            return false;
        }
    }

    /* renamed from: yd.f$c */
    public class c extends AbstractC12367d {
        public c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean zM75941k = C12591s1.m75931a().m75941k();
            Message messageObtain = Message.obtain();
            messageObtain.what = 33035;
            messageObtain.obj = Boolean.valueOf(zM75941k);
            C13950f.this.f62576l.sendMessage(messageObtain);
        }
    }

    /* renamed from: yd.f$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C13950f c13950f = C13950f.this;
            c13950f.f62570f.m25290f0(c13950f.f62571g);
        }
    }

    /* renamed from: yd.f$e */
    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ SyncItemInfo f62583a;

        public e(SyncItemInfo syncItemInfo) {
            this.f62583a = syncItemInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            SyncItemRecyclerAdapter syncItemRecyclerAdapter = C13950f.this.f62570f;
            if (syncItemRecyclerAdapter != null) {
                syncItemRecyclerAdapter.m25279U(this.f62583a);
            }
        }
    }

    /* renamed from: yd.f$f */
    public static class f extends Handler {

        /* renamed from: a */
        public WeakReference<C13950f> f62585a;

        public /* synthetic */ f(C13950f c13950f, a aVar) {
            this(c13950f);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 33035) {
                C13950f c13950f = this.f62585a.get();
                if (c13950f == null || c13950f.f62567c == null) {
                    return;
                }
                boolean z10 = Boolean.parseBoolean(String.valueOf(message.obj));
                C11839m.m70688i("MainItemStatusController", " isRefurbishing " + z10);
                c13950f.f62567c.setRefurbishing(z10);
                return;
            }
            if (i10 != 33428) {
                C11839m.m70687e("MainItemStatusController", "cloudBackupHandler invalid message :" + message.what);
                return;
            }
            CloudBackupState cloudBackupState = (CloudBackupState) message.obj;
            C13950f c13950f2 = this.f62585a.get();
            if (c13950f2 != null) {
                if (c13950f2.m83867n() != null && message.arg2 == 0) {
                    c13950f2.m83867n().show(cloudBackupState);
                }
                C11839m.m70688i("MainItemStatusController", "CloudBackupHandler: " + cloudBackupState + ", msg.arg2 = " + message.arg2);
            }
        }

        public f(C13950f c13950f) {
            this.f62585a = new WeakReference<>(c13950f);
        }
    }

    public C13950f(Activity activity, LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        this.f62566b = activity;
        this.f62565a = C0214f0.m1382b(activity, "sync_contact_spfile", 0);
        this.f62571g = linkedHashMap;
        if (linkedHashMap == null) {
            this.f62571g = new LinkedHashMap<>();
        }
    }

    /* renamed from: A */
    public final void m83823A() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        long j10 = this.f62565a.getLong("addressbooksync_syncTime", 0L);
        long j11 = this.f62565a.getLong("sync_syncTime", 0L);
        if (j10 < j11) {
            this.f62565a.edit().putLong("addressbooksync_syncTime", j11).commit();
            this.f62565a.edit().remove("sync_syncTime").commit();
            j10 = j11;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("addressbook");
        C11839m.m70688i("MainItemStatusController", "onContactSyncEnd lastSuccessTime=" + j10);
        if (j10 == 0 || !zM62388s) {
            m83860j0("addressbook", true);
        } else {
            m83872p0("addressbook", C11667a.m69662d(this.f62566b, j10));
        }
    }

    /* renamed from: B */
    public final void m83824B() {
        C11839m.m70688i("MainItemStatusController", "onContactSyncStart");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("addressbook");
        C11839m.m70688i("MainItemStatusController", "onContactSyncStart switchStatus=" + zM62388s);
        if (zM62388s) {
            m83864l0("addressbook", true, this.f62566b.getString(R$string.main_syncing));
        }
    }

    /* renamed from: C */
    public final void m83825C(String str) {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        long j10 = this.f62565a.getLong(str + "sync_syncTime", 0L);
        boolean zM62388s = C10028c.m62182c0().m62388s(str);
        C11839m.m70688i("MainItemStatusController", "onModuleSyncEnd lastSuccessTime=" + j10 + ",moduleName = " + str + ",moduleSwitchStatus=" + zM62388s);
        if (j10 == 0 || !zM62388s) {
            m83855g0(str, "", 0);
        } else {
            m83855g0(str, C11667a.m69662d(this.f62566b, j10), 2);
        }
    }

    /* renamed from: D */
    public final void m83826D(String str) {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s(str);
        C11839m.m70688i("MainItemStatusController", "query module " + str + " switchStatus=" + zM62388s);
        if (zM62388s) {
            m83856h0(str, this.f62566b.getString(R$string.main_syncing), 1);
        }
    }

    /* renamed from: E */
    public final void m83827E() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        long j10 = this.f62565a.getLong("notepadsync_syncTime", 0L);
        boolean zM62388s = C10028c.m62182c0().m62388s("notepad");
        C11839m.m70688i("MainItemStatusController", "onNotePadSyncEnd lastSuccessTime=" + j10 + ",notePadSwitchStatus=" + zM62388s);
        if (j10 == 0 || !zM62388s) {
            m83860j0("notepad", true);
        } else {
            m83872p0("notepad", C11667a.m69662d(this.f62566b, j10));
        }
    }

    /* renamed from: F */
    public final void m83828F() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("notepad");
        C11839m.m70688i("MainItemStatusController", "queryNotePadStatus switchStatus=" + zM62388s);
        if (zM62388s) {
            m83864l0("notepad", true, this.f62566b.getString(R$string.main_syncing));
        }
    }

    /* renamed from: G */
    public final void m83829G(String str) {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "onStorageLacked mActivity null");
        } else {
            C0237v.m1661c();
            m83855g0(str, this.f62566b.getString(R$string.no_storage_paused), 2);
        }
    }

    /* renamed from: H */
    public void m83830H(String str) {
        C11839m.m70688i("MainItemStatusController", "onSyncEnd");
        if ("addressbook".equals(str)) {
            m83839Q();
            return;
        }
        if ("calendar".equals(str)) {
            m83838P();
            return;
        }
        if ("notepad".equals(str)) {
            m83842T();
            return;
        }
        if ("browser".equals(str)) {
            m83837O();
        } else if ("wlan".equals(str)) {
            m83845W();
        } else {
            m83841S(str);
        }
    }

    /* renamed from: I */
    public void m83831I(String str) {
        C11839m.m70688i("MainItemStatusController", "onSyncStart");
        if ("addressbook".equals(str)) {
            m83824B();
            return;
        }
        if ("calendar".equals(str)) {
            m83890z();
            return;
        }
        if ("notepad".equals(str)) {
            m83828F();
            return;
        }
        if ("browser".equals(str)) {
            m83886x();
        } else if ("wlan".equals(str)) {
            m83834L();
        } else {
            m83826D(str);
        }
    }

    /* renamed from: J */
    public void m83832J(String str) {
        if ("addressbook".equals(str)) {
            m83860j0("addressbook", true);
            return;
        }
        if ("calendar".equals(str)) {
            m83860j0("calendar", true);
            return;
        }
        if ("notepad".equals(str)) {
            m83860j0("notepad", true);
            return;
        }
        if ("browser".equals(str)) {
            m83860j0("browser", true);
        } else if ("wlan".equals(str)) {
            m83860j0("wlan", true);
        } else {
            m83855g0(str, "", 0);
        }
    }

    /* renamed from: K */
    public final void m83833K() {
        C11839m.m70688i("MainItemStatusController", "onWlanSyncEnd");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity is null");
            return;
        }
        long jM1688f = C0241z.m1688f(this.f62565a.getString("wlansync_syncTime", "0"));
        boolean zM62388s = C10028c.m62182c0().m62388s("wlan");
        C11839m.m70688i("MainItemStatusController", "onWlanSyncEnd lastSuccessTime=" + jM1688f);
        if (jM1688f == 0 || !zM62388s) {
            m83860j0("wlan", true);
        } else {
            m83872p0("wlan", C11667a.m69662d(this.f62566b, jM1688f));
        }
    }

    /* renamed from: L */
    public final void m83834L() {
        C11839m.m70688i("MainItemStatusController", "onWlanSyncStart");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity is null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("wlan");
        C11839m.m70688i("MainItemStatusController", "onWlanSyncStart switchStatus=" + zM62388s);
        if (zM62388s) {
            m83870o0("wlan", this.f62566b.getString(R$string.main_syncing));
        }
    }

    /* renamed from: M */
    public void m83835M() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("MainItemStatusController", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58361C0(this);
        }
    }

    /* renamed from: N */
    public final void m83836N() {
        C11839m.m70688i("MainItemStatusController", "queryAlbumStatus");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        Bundle bundleM5971r = C1006a.m5936k().m5971r(this.f62566b);
        if (bundleM5971r != null) {
            m83878s0(bundleM5971r);
        } else {
            C11839m.m70688i("MainItemStatusController", "get gallery uploading status failed");
        }
    }

    /* renamed from: O */
    public final void m83837O() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("browser");
        C11839m.m70688i("MainItemStatusController", "query module:browser switchStatus:" + zM62388s);
        if (zM62388s) {
            int i10 = this.f62565a.getInt("browsersync_retcode", 5);
            if (i10 == 0) {
                m83884w();
                return;
            }
            if (i10 == 4) {
                m83886x();
                return;
            }
            if (i10 != 20) {
                m83884w();
                return;
            }
            Activity activity = this.f62566b;
            if (activity != null) {
                m83872p0("browser", activity.getString(R$string.no_storage_paused));
            }
        }
    }

    /* renamed from: P */
    public final void m83838P() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("calendar");
        C11839m.m70688i("MainItemStatusController", "query module:calendar switchStatus:" + zM62388s);
        if (zM62388s) {
            int i10 = this.f62565a.getInt("calendarsync_retcode", 5);
            if (i10 == 0) {
                m83888y();
                return;
            }
            if (i10 == 4) {
                m83890z();
                return;
            }
            if (i10 != 20) {
                m83888y();
                return;
            }
            Activity activity = this.f62566b;
            if (activity != null) {
                m83872p0("calendar", activity.getString(R$string.no_storage_paused));
            }
        }
    }

    /* renamed from: Q */
    public final void m83839Q() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("addressbook");
        C11839m.m70688i("MainItemStatusController", "query module:addressbook switchStatus:" + zM62388s);
        if (zM62388s) {
            int i10 = this.f62565a.getInt("addressbooksync_retcode", 5);
            C11839m.m70688i("MainItemStatusController", "queryContactStatus syncStatus=" + i10);
            if (i10 == 0) {
                m83823A();
                return;
            }
            if (i10 == 4) {
                m83824B();
                return;
            }
            if (i10 != 20) {
                m83823A();
                return;
            }
            Activity activity = this.f62566b;
            if (activity != null) {
                m83872p0("addressbook", activity.getString(R$string.no_storage_paused));
            }
        }
    }

    /* renamed from: R */
    public final void m83840R() {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            C11839m.m70687e("MainItemStatusController", "queryDriveItemsStatus, adapter is null.");
            return;
        }
        ArrayList<SyncItemInfo> arrayListM25272K = syncItemRecyclerAdapter.m25272K(this.f62571g);
        if (arrayListM25272K == null || arrayListM25272K.isEmpty()) {
            return;
        }
        Iterator<SyncItemInfo> it = arrayListM25272K.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            String id2 = next.getId();
            boolean zM62388s = C10028c.m62182c0().m62388s(id2);
            next.setSwitchStatus(zM62388s);
            C11839m.m70688i("MainItemStatusController", "query module:" + id2 + " switchStatus:" + zM62388s);
            this.f62571g.put(next.getId(), next);
        }
        m83887x0();
    }

    /* renamed from: S */
    public final void m83841S(String str) {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s(str);
        C11839m.m70688i("MainItemStatusController", "query module:" + str + " switchStatus:" + zM62388s);
        if (zM62388s) {
            int i10 = this.f62565a.getInt(str + "sync_retcode", 5);
            C11839m.m70688i("MainItemStatusController", "query module:" + str + " syncStatus:" + i10);
            if (i10 == 0) {
                m83825C(str);
                return;
            }
            if (i10 == 4) {
                m83826D(str);
            } else if (i10 == 20) {
                m83829G(str);
            } else {
                m83825C(str);
            }
        }
    }

    /* renamed from: T */
    public final void m83842T() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("notepad");
        C11839m.m70688i("MainItemStatusController", "query module:notepad switchStatus:" + zM62388s);
        if (zM62388s) {
            int i10 = this.f62565a.getInt("notepadsync_retcode", 5);
            if (i10 == 0) {
                m83827E();
                return;
            }
            if (i10 == 4) {
                m83828F();
                return;
            }
            if (i10 != 20) {
                m83827E();
                return;
            }
            Activity activity = this.f62566b;
            if (activity != null) {
                m83872p0("notepad", activity.getString(R$string.no_storage_paused));
            }
        }
    }

    /* renamed from: U */
    public final void m83843U() {
        if (this.f62570f == null) {
            C11839m.m70687e("MainItemStatusController", "querySyncItemsStatus, adapter is null.");
            return;
        }
        ArrayList<SyncItemInfo> arrayListM83871p = m83871p();
        if (arrayListM83871p == null || arrayListM83871p.isEmpty()) {
            C11839m.m70687e("MainItemStatusController", "querySyncItemsStatus, services is null or empty.");
            return;
        }
        Iterator<SyncItemInfo> it = arrayListM83871p.iterator();
        while (it.hasNext()) {
            SyncItemInfo next = it.next();
            if (next.isSyncConfig()) {
                String id2 = next.getId();
                if (TextUtils.isEmpty(id2)) {
                    C11839m.m70687e("MainItemStatusController", "querySyncItemsStatus, serviceId is null");
                } else {
                    m83841S(id2);
                }
            } else if (next.isDriveConfig()) {
                String id3 = next.getId();
                C11839m.m70688i("MainItemStatusController", "query module:" + id3 + " switchStatus:" + C10028c.m62182c0().m62388s(id3));
            } else {
                C11839m.m70687e("MainItemStatusController", "querySyncItemsStatus, not instanceof SyncConfigService");
            }
        }
    }

    /* renamed from: V */
    public final void m83844V() {
        m83839Q();
        m83838P();
        m83842T();
        m83837O();
        m83845W();
        m83843U();
        m83840R();
    }

    /* renamed from: W */
    public final void m83845W() {
        C11839m.m70688i("MainItemStatusController", "queryWlanStatus");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity is null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("wlan");
        C11839m.m70688i("MainItemStatusController", "query module:wlan switchStatus:" + zM62388s);
        if (zM62388s) {
            int i10 = this.f62565a.getInt("wlansync_retcode", 5);
            C11839m.m70688i("MainItemStatusController", "queryWlanStatus syncStatus=" + i10);
            if (i10 == 4) {
                m83834L();
                return;
            }
            if (i10 == 0) {
                m83833K();
                return;
            }
            if (i10 != 20) {
                m83833K();
                return;
            }
            Activity activity = this.f62566b;
            if (activity != null) {
                m83872p0("wlan", activity.getString(R$string.no_storage_paused));
            }
        }
    }

    /* renamed from: X */
    public final void m83846X(CBState cBState) {
        int status = cBState.getStatus();
        CacheTask.State state = cBState.getState();
        C11839m.m70688i("MainItemStatusController", "refreshCloudBackupStatus backupStatus=" + status + ", currentState=" + state);
        if (status == 1) {
            if (CacheTask.State.CANCEL.equals(state)) {
                m83881u0(1);
                return;
            } else {
                m83879t0();
                return;
            }
        }
        if (status != 2) {
            if (status != 3) {
                m83882v(Long.valueOf(cBState.getLastTimeStamp()));
                return;
            } else {
                m83883v0();
                return;
            }
        }
        if (CacheTask.State.CANCEL.equals(state)) {
            m83881u0(2);
        } else {
            m83885w0();
        }
    }

    /* renamed from: Y */
    public final void m83847Y(SyncItemInfo syncItemInfo) {
        if (syncItemInfo != null && !TextUtils.isEmpty(syncItemInfo.getId())) {
            this.f62571g.put(syncItemInfo.getId(), syncItemInfo);
        }
        this.f62569e.post(new e(syncItemInfo));
    }

    /* renamed from: Z */
    public final void m83848Z() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        Bundle bundleM5971r = C1006a.m5936k().m5971r(this.f62566b);
        if (bundleM5971r != null) {
            m83878s0(bundleM5971r);
        } else {
            C11839m.m70688i("MainItemStatusController", "get gallery uploading status failed");
        }
    }

    /* renamed from: a0 */
    public void m83849a0() {
        m83877s();
        m83836N();
        m83844V();
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("MainItemStatusController", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58374J(this, this.f62577m);
            C12515a.m75110o().m75172d(new c());
        }
    }

    /* renamed from: b0 */
    public final void m83850b0(C10028c c10028c) {
        if (c10028c.m62388s("browser")) {
            return;
        }
        m83860j0("browser", true);
    }

    /* renamed from: c0 */
    public final void m83851c0(C10028c c10028c) {
        if (c10028c.m62388s("calendar")) {
            return;
        }
        m83860j0("calendar", true);
    }

    /* renamed from: d0 */
    public final void m83852d0(C10028c c10028c) {
        if (c10028c.m62388s("addressbook")) {
            return;
        }
        m83860j0("addressbook", true);
    }

    /* renamed from: e0 */
    public final void m83853e0() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM5975v = C1006a.m5936k().m5975v(this.f62566b);
        C11839m.m70688i("MainItemStatusController", "setGalleryFrame switchStatus=" + zM5975v);
        if (zM5975v) {
            return;
        }
        m83860j0(HNConstants.DataType.MEDIA, true);
    }

    /* renamed from: f0 */
    public void m83854f0() {
        m83853e0();
        m83889y0(false);
    }

    /* renamed from: g0 */
    public final void m83855g0(String str, String str2, int i10) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            C11839m.m70687e("MainItemStatusController", "setModuleSubTitle, adapter is null, moduleName = " + str);
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25274M(str));
        C11839m.m70688i("MainItemStatusController", "setModuleSubTitle moduleName = " + str + ", subTitleText = " + str2 + ", subTitleStatus = " + i10);
        syncItemInfoM83869o.setSyncItemSubtitleStatus(i10);
        syncItemInfoM83869o.setSubStringText(str2);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: h0 */
    public final void m83856h0(String str, String str2, int i10) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            C11839m.m70687e("MainItemStatusController", "setModuleSyncStartStatus, syncItemRecyclerAdapter is null, moduleName = " + str);
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25274M(str));
        C11839m.m70688i("MainItemStatusController", "setModuleSyncStartStatus moduleName = " + str + ", subTitleText = " + str2 + ", subTitleStatus = ");
        syncItemInfoM83869o.setSyncItemSubtitleStatus(i10);
        syncItemInfoM83869o.setSubStringText(str2);
        syncItemInfoM83869o.setSwitchStatus(true);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: i */
    public void m83857i(Context context, String str) {
        this.f62572h.mo79141a(context, str);
    }

    /* renamed from: i0 */
    public void m83858i0(String str, Boolean bool) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter != null) {
            SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25274M(str));
            syncItemInfoM83869o.setSwitchStatus(bool.booleanValue());
            m83847Y(syncItemInfoM83869o);
        } else {
            C11839m.m70687e("MainItemStatusController", "setModuleSubTitle, syncItemView is null, moduleName = " + str);
        }
    }

    /* renamed from: j */
    public void m83859j(Context context, String str, String str2) {
        this.f62572h.mo79142b(context, str, str2);
    }

    /* renamed from: j0 */
    public final void m83860j0(String str, boolean z10) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25275O(str));
        syncItemInfoM83869o.setNoSubTitle(z10);
        syncItemInfoM83869o.setShowSubTitle(!z10);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: k */
    public final void m83861k(C10028c c10028c) {
        if (this.f62570f == null) {
            C11839m.m70687e("MainItemStatusController", "checkSyncItemsSubtitle, adapter is null.");
            return;
        }
        ArrayList<SyncItemInfo> arrayListM83871p = m83871p();
        if (arrayListM83871p == null || arrayListM83871p.isEmpty()) {
            C11839m.m70687e("MainItemStatusController", "checkSyncItemsSubtitle, services is null or empty.");
            return;
        }
        for (int i10 = 0; i10 < arrayListM83871p.size(); i10++) {
            SyncItemInfo syncItemInfo = arrayListM83871p.get(i10);
            if (syncItemInfo.isSyncConfig()) {
                String id2 = syncItemInfo.getId();
                if (!TextUtils.isEmpty(id2) && !c10028c.m62388s(id2)) {
                    syncItemInfo.setSyncItemSubtitleStatus(0);
                    this.f62571g.put(syncItemInfo.getId(), syncItemInfo);
                }
            }
        }
        m83887x0();
    }

    /* renamed from: k0 */
    public final void m83862k0(C10028c c10028c) {
        if (c10028c.m62388s("notepad")) {
            return;
        }
        m83860j0("notepad", true);
    }

    /* renamed from: l */
    public void m83863l() {
        CloudBackupService.getInstance().unregister(this.f62578n);
        C14317j.m85300d().m85322w(this.f62576l);
        NewBmBackupItemView newBmBackupItemView = this.f62568d;
        if (newBmBackupItemView != null) {
            newBmBackupItemView.onDestroy();
        }
    }

    /* renamed from: l0 */
    public final void m83864l0(String str, boolean z10, String str2) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25275O(str));
        syncItemInfoM83869o.setCheckedProgrammatically(z10);
        syncItemInfoM83869o.setSubTitleLoadingText(str2);
        syncItemInfoM83869o.setShowSubTitle(true);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: m */
    public final String m83865m(Context context, Long l10) {
        Resources resources = context.getResources();
        if (resources == null) {
            return null;
        }
        long offset = Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis());
        long jCurrentTimeMillis = ((System.currentTimeMillis() + offset) / 86400000) - ((l10.longValue() + offset) / 86400000);
        if (jCurrentTimeMillis == 0) {
            return context.getString(R$string.backup_time1, context.getString(R$string.main_today));
        }
        if (jCurrentTimeMillis == 1) {
            return context.getString(R$string.backup_time1, context.getString(R$string.backup_yesterday));
        }
        if (jCurrentTimeMillis <= 1) {
            return "";
        }
        int i10 = (int) jCurrentTimeMillis;
        return resources.getQuantityString(R$plurals.backup_time2, i10, Integer.valueOf(i10));
    }

    /* renamed from: m0 */
    public void m83866m0(boolean z10) {
        this.f62574j = z10;
    }

    /* renamed from: n */
    public NewBmBackupItemView m83867n() {
        return this.f62568d;
    }

    /* renamed from: n0 */
    public final void m83868n0(String str, String str2) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25275O(str));
        syncItemInfoM83869o.setStatusText(str2);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: o */
    public final SyncItemInfo m83869o(String str, SyncItemInfo syncItemInfo) {
        if (syncItemInfo != null) {
            return syncItemInfo;
        }
        if (this.f62571g.containsKey(str)) {
            return this.f62571g.get(str);
        }
        SyncItemInfo syncItemInfo2 = new SyncItemInfo();
        syncItemInfo2.setId(str);
        m83874q0(str, syncItemInfo2);
        return syncItemInfo2;
    }

    /* renamed from: o0 */
    public final void m83870o0(String str, String str2) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25275O(str));
        syncItemInfoM83869o.setSubTitleLoadingText(str2);
        syncItemInfoM83869o.setShowSubTitle(true);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: p */
    public final ArrayList<SyncItemInfo> m83871p() {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        return syncItemRecyclerAdapter == null ? new ArrayList<>() : syncItemRecyclerAdapter.m25276P(this.f62571g);
    }

    /* renamed from: p0 */
    public final void m83872p0(String str, String str2) {
        SyncItemRecyclerAdapter syncItemRecyclerAdapter = this.f62570f;
        if (syncItemRecyclerAdapter == null) {
            return;
        }
        SyncItemInfo syncItemInfoM83869o = m83869o(str, syncItemRecyclerAdapter.m25275O(str));
        syncItemInfoM83869o.setSubTitleText(str2);
        syncItemInfoM83869o.setShowSubTitle(true);
        m83847Y(syncItemInfoM83869o);
    }

    /* renamed from: q */
    public final void m83873q() {
        if (this.f62567c == null) {
            this.f62567c = (BackupDeviceView) C12809f.m76829b(this.f62566b, R$id.cloud_backup_vertical_item_view);
        }
        if (this.f62568d == null) {
            this.f62568d = (NewBmBackupItemView) C12809f.m76829b(this.f62566b, R$id.cloud_backup_item_view_new);
        }
        this.f62568d.setActivity(this.f62566b);
    }

    /* renamed from: q0 */
    public final void m83874q0(String str, SyncItemInfo syncItemInfo) {
        if (this.f62566b == null) {
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("MainItemStatusController", "setTitleWithId4Sync, moduleName is null");
            return;
        }
        str.hashCode();
        switch (str) {
            case "addressbook":
                syncItemInfo.setTitle(this.f62566b.getString(R$string.contact));
                break;
            case "gallery":
                syncItemInfo.setTitle(this.f62566b.getString(R$string.gallery_item_title));
                break;
            case "calendar":
                syncItemInfo.setTitle(this.f62566b.getString(R$string.calendar_sync_item));
                break;
            case "wlan":
                if (!C0209d.m1262h2()) {
                    syncItemInfo.setTitle(this.f62566b.getString(R$string.wifi_sync));
                    break;
                } else {
                    syncItemInfo.setTitle(this.f62566b.getString(R$string.wlan_sync));
                    break;
                }
            case "browser":
                syncItemInfo.setTitle(this.f62566b.getString(R$string.browser));
                break;
            case "notepad":
                syncItemInfo.setTitle(this.f62566b.getString(R$string.notepad_app_name));
                break;
        }
    }

    /* renamed from: r */
    public void m83875r() {
        CloudBackupService.getInstance().register(this.f62578n);
        C14317j.m85300d().m85311l(this.f62576l);
        C12515a.m75110o().m75172d(new C12199z());
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("MainItemStatusController", "cloudAlbumRouterImpl is null");
        } else {
            if (interfaceC9282a.mo58441m()) {
                return;
            }
            m83848Z();
        }
    }

    /* renamed from: r0 */
    public final void m83876r0(C10028c c10028c) {
        if (c10028c.m62388s("wlan")) {
            return;
        }
        m83860j0("wlan", true);
    }

    /* renamed from: s */
    public final void m83877s() {
        C11839m.m70688i("MainItemStatusController", "initTips");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        m83853e0();
        m83852d0(c10028cM62182c0);
        m83851c0(c10028cM62182c0);
        m83862k0(c10028cM62182c0);
        m83850b0(c10028cM62182c0);
        m83876r0(c10028cM62182c0);
        m83861k(c10028cM62182c0);
    }

    /* renamed from: s0 */
    public final void m83878s0(Bundle bundle) {
        C11839m.m70688i("MainItemStatusController", "showAlbumStatus");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            this.f62573i = interfaceC9282a.mo58451r(this.f62566b);
        } else {
            C11839m.m70688i("MainItemStatusController", "cloudAlbumRouterImpl is null");
        }
        boolean zIsGeneralAlbumOn = this.f62573i.isGeneralAlbumOn();
        m83889y0(zIsGeneralAlbumOn);
        if (!zIsGeneralAlbumOn) {
            C11839m.m70688i("MainItemStatusController", "showAlbumStatus album off");
        } else {
            C11839m.m70688i("MainItemStatusController", "showAlbumStatus album on");
            this.f62572h.mo79143e(this.f62566b, bundle, bundle.getInt("msgID"));
        }
    }

    /* renamed from: t */
    public void mo83728t() {
        C11839m.m70688i("MainItemStatusController", "initView");
        Activity activity = this.f62566b;
        if (activity == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        HwRecyclerView hwRecyclerView = (HwRecyclerView) C12809f.m76829b(activity, R$id.sync_normal_recycler_view);
        this.f62569e = hwRecyclerView;
        RecyclerView.AbstractC0838h adapter = hwRecyclerView.getAdapter();
        if (adapter instanceof SyncItemRecyclerAdapter) {
            this.f62570f = (SyncItemRecyclerAdapter) adapter;
        }
        m83873q();
        this.f62572h = new C13949e(this.f62570f, this.f62569e, this.f62571g);
        C10028c.m62182c0().m62264Q1(1, R$string.cloud_backup_explain_main);
    }

    /* renamed from: t0 */
    public final void m83879t0() {
        C11839m.m70688i("MainItemStatusController", "showBackuping");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
        } else {
            C10028c.m62182c0().m62264Q1(3, R$string.main_cloudbackuping);
        }
    }

    /* renamed from: u */
    public final void m83880u(Context context) {
        if (context == null) {
            C11839m.m70688i("MainItemStatusController", "notifyClearCacheStatus context is null");
        } else {
            C11839m.m70688i("MainItemStatusController", "notifyClearCacheStatus");
            ICBBroadcastManager.sendBackupRestoreEnd(context);
        }
    }

    /* renamed from: u0 */
    public final void m83881u0(int i10) {
        C11839m.m70688i("MainItemStatusController", "showCloudBackupCancelView cbStatus=" + i10);
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
        } else if (i10 == 1) {
            C10028c.m62182c0().m62264Q1(1, R$string.canceling_cloudbackup);
        } else if (i10 == 2) {
            C10028c.m62182c0().m62264Q1(1, R$string.canceling_cloudrestore);
        }
    }

    /* renamed from: v */
    public final void m83882v(Long l10) {
        C11839m.m70688i("MainItemStatusController", "onBackupFinish");
        Activity activity = this.f62566b;
        if (activity == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        String strM83865m = m83865m(activity, l10);
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        if (TextUtils.isEmpty(strM83865m) || l10.longValue() == 0 || !zM62388s) {
            C10028c.m62182c0().m62264Q1(1, R$string.cloud_backup_explain_main);
        } else {
            C10028c.m62182c0().m62268R1(2, l10.toString());
        }
    }

    /* renamed from: v0 */
    public final void m83883v0() {
        C11839m.m70688i("MainItemStatusController", "showRestorePaused");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
        } else {
            C10028c.m62182c0().m62264Q1(1, R$string.main_restore_paused);
        }
    }

    /* renamed from: w */
    public final void m83884w() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        long j10 = this.f62565a.getLong("browsersync_syncTime", 0L);
        boolean zM62388s = C10028c.m62182c0().m62388s("browser");
        C11839m.m70688i("MainItemStatusController", "onBrowserSyncEnd lastSuccessTime=" + j10 + ",browserSwitchStatus=" + zM62388s);
        if (j10 == 0 || !zM62388s) {
            m83860j0("browser", true);
        } else {
            m83872p0("browser", C11667a.m69662d(this.f62566b, j10));
        }
    }

    /* renamed from: w0 */
    public final void m83885w0() {
        C11839m.m70688i("MainItemStatusController", "showRestoring");
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
        } else {
            C10028c.m62182c0().m62264Q1(3, R$string.restoring_data);
        }
    }

    /* renamed from: x */
    public final void m83886x() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("browser");
        C11839m.m70688i("MainItemStatusController", "queryBrowserStatus switchStatus=" + zM62388s);
        if (zM62388s) {
            m83864l0("browser", true, this.f62566b.getString(R$string.main_syncing));
        }
    }

    /* renamed from: x0 */
    public final void m83887x0() {
        this.f62569e.post(new d());
    }

    /* renamed from: y */
    public final void m83888y() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        long j10 = this.f62565a.getLong("calendarsync_syncTime", 0L);
        boolean zM62388s = C10028c.m62182c0().m62388s("calendar");
        C11839m.m70688i("MainItemStatusController", "onCalendarSyncEnd lastSuccessTime=" + j10 + ",calendarSwitchStatus=" + zM62388s);
        if (j10 == 0 || !zM62388s) {
            m83860j0("calendar", true);
        } else {
            m83872p0("calendar", C11667a.m69662d(this.f62566b, j10));
        }
    }

    /* renamed from: y0 */
    public final void m83889y0(boolean z10) {
        Activity activity = this.f62566b;
        if (activity == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
        } else if (z10) {
            m83868n0(HNConstants.DataType.MEDIA, activity.getResources().getString(R$string.cloudalbum_switch_open));
        } else {
            m83868n0(HNConstants.DataType.MEDIA, activity.getResources().getString(R$string.sync_switch_button_close));
        }
    }

    /* renamed from: z */
    public final void m83890z() {
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "mActivity null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("calendar");
        C11839m.m70688i("MainItemStatusController", "queryCalendarStatus switchStatus=" + zM62388s);
        if (zM62388s) {
            m83864l0("calendar", true, this.f62566b.getString(R$string.main_syncing));
        }
    }

    /* renamed from: z0 */
    public void m83891z0() {
        if (!C10155f.m63299w()) {
            C11839m.m70686d("MainItemStatusController", " updateGalleryTips isCloudphotoManagerEnable false");
            return;
        }
        if (this.f62566b == null) {
            C11839m.m70687e("MainItemStatusController", "updateGalleryTips mActivity null");
            return;
        }
        Bundle bundleM5971r = C1006a.m5936k().m5971r(this.f62566b);
        if (bundleM5971r == null) {
            C11839m.m70687e("MainItemStatusController", "updateGalleryTips statusBundle null");
            return;
        }
        int i10 = bundleM5971r.getInt(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        C11839m.m70686d("MainItemStatusController", "updateGalleryTips status " + i10 + " lastStatus " + this.f62575k);
        if (this.f62575k == -1) {
            this.f62575k = i10;
        }
        if (this.f62575k == i10) {
            this.f62572h.mo79143e(this.f62566b, bundleM5971r, bundleM5971r.getInt("msgID"));
        } else {
            this.f62575k = i10;
        }
    }
}
