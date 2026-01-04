package com.huawei.android.backup.service.logic;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import com.huawei.android.backup.filelogic.appdata.model.AppSizeBean;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.backup.service.logic.BackupLogicService;
import com.huawei.android.backup.service.logic.apprisk.AppsRisk;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.fastengine.fastview.NavigationUtils;
import gt.C10046b;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p006a5.AbstractC0048c;
import p229di.C9142g;
import p278f5.C9657a;
import p386j6.C10713c;
import p544p4.C12086a;
import p632s4.C12699c;
import p632s4.C12703g;
import p699v4.C13334c;
import p699v4.C13345n;
import p699v4.C13349r;
import p728w4.C13529c;
import p762x4.AbstractC13696c;
import p762x4.C13694a;
import p763x5.C13703a;

/* renamed from: com.huawei.android.backup.service.logic.l */
/* loaded from: classes.dex */
public class C2153l {

    /* renamed from: a */
    public static final String f9669a;

    /* renamed from: b */
    public static final int[][] f9670b;

    /* renamed from: c */
    public static final Object f9671c;

    /* renamed from: d */
    public static final Object f9672d;

    /* renamed from: e */
    public static AbstractC2131d f9673e;

    /* renamed from: f */
    public static volatile boolean f9674f;

    /* renamed from: g */
    public static volatile boolean f9675g;

    /* renamed from: h */
    public static volatile Handler.Callback f9676h;

    /* renamed from: i */
    public static volatile Handler f9677i;

    /* renamed from: j */
    public static volatile Thread f9678j;

    /* renamed from: k */
    public static Bundle f9679k;

    /* renamed from: l */
    public static int f9680l;

    /* renamed from: m */
    public static AtomicInteger f9681m;

    /* renamed from: n */
    public static long f9682n;

    /* renamed from: o */
    public static volatile boolean f9683o;

    /* renamed from: com.huawei.android.backup.service.logic.l$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ b f9684a;

        public a(b bVar) {
            this.f9684a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2153l.m13065q0(this.f9684a);
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$c */
    public static class c extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) throws IOException {
            if (message == null) {
                return;
            }
            C2111d.m12654j("ControlThread", "ControlHandler handle message ", Integer.valueOf(message.what));
            Object obj = message.obj;
            if (obj == null) {
                C2111d.m12648d("ControlThread", "BackupCmd backupCmd is null!");
            } else if (obj instanceof b) {
                b bVar = (b) obj;
                if (C2153l.m13061o0(message, bVar)) {
                    return;
                }
                C2153l.m13063p0(message, bVar);
            }
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$d */
    public static class d extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            C2153l.m13004B();
            Looper.prepare();
            Handler unused = C2153l.f9677i = new c();
            Looper.loop();
            C2153l.m13007C0();
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$e */
    public static class e implements Runnable {

        /* renamed from: a */
        public b f9691a;

        /* renamed from: b */
        public Set<String> f9692b;

        /* renamed from: c */
        public String f9693c;

        public e(b bVar, Set<String> set, String str) {
            this.f9691a = bVar;
            this.f9692b = set;
            this.f9693c = str;
        }

        /* renamed from: a */
        public final List<String> m13090a(Bundle bundle) {
            return bundle != null ? C10713c.m65401k(bundle, this.f9693c) : new ArrayList();
        }

        /* renamed from: c */
        public final Bundle m13091c(Context context, Long l10) {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(64);
            if (installedPackages == null) {
                C2111d.m12653i("ControlThread", "installedAppList is null");
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<PackageInfo> it = installedPackages.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                arrayList.add(it.next().packageName);
                i10++;
            }
            C2111d.m12654j("ControlThread", " onBackupAppsDataItemTotal, totalNumber: ", Integer.valueOf(i10));
            long jLongValue = i10 == 0 ? 0L : l10.longValue();
            Bundle bundle = new Bundle();
            bundle.putInt("ModuleCount", i10);
            bundle.putLong("ModuleSize", jLongValue);
            bundle.putStringArrayList("AppPackageList", arrayList);
            bundle.putInt("APPDataFlag", AbstractC2124a.m12751c());
            return bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2111d.m12654j("ControlThread", "Current Thread is Running, Thread name is :", this.f9693c);
            Bundle bundle = new Bundle();
            bundle.putString("getbackupmoduleinfo", this.f9693c);
            if (BackupConstant.m13136j().get(this.f9693c) != null) {
                bundle.putAll(BackupConstant.m13136j().get(this.f9693c));
            }
            Bundle bundle2 = BackupConstant.m13137k().get(this.f9693c);
            ArrayList<String> arrayList = new ArrayList<>(m13090a(bundle2));
            String[] strArr = this.f9691a.f9686b;
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                String str = strArr[i10];
                C2111d.m12654j("ControlThread", this.f9693c, ":", str);
                if (C2153l.m13035b0()) {
                    C2111d.m12657m("ControlThread", "The module is abort.");
                    break;
                }
                if (this.f9692b.contains(str)) {
                    BackupConstant.m13136j().put(this.f9693c, bundle);
                    if (arrayList.isEmpty() || !arrayList.contains(str)) {
                        arrayList.add(str);
                        if (bundle2 != null) {
                            bundle2.putStringArrayList(this.f9693c, arrayList);
                        }
                        BackupConstant.m13137k().put(this.f9693c, bundle2);
                        if (C2153l.f9673e.mo12792r(str, this.f9691a.f9687c) != null) {
                            Bundle bundleM13091c = m13091c(this.f9691a.f9685a, 102400L);
                            if (bundleM13091c != null) {
                                bundle.putParcelable(str, bundleM13091c);
                            } else {
                                C2111d.m12658n("ControlThread", "ModuleBundle is null, ", this.f9693c, ":", str);
                            }
                        }
                    }
                }
                i10++;
            }
            C2111d.m12654j("ControlThread", "GetBackupModuleDataInfo finish,mModuleMap:", this.f9692b.toString());
            BackupConstant.m13138l().put(this.f9693c, Boolean.TRUE);
            C2153l.m13080y(this.f9691a.f9687c, 1065, bundle);
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$f */
    public static class f implements Runnable {

        /* renamed from: a */
        public b f9694a;

        /* renamed from: b */
        public String f9695b;

        /* renamed from: c */
        public ConcurrentHashMap<String, Long> f9696c;

        public f(b bVar, String str, ConcurrentHashMap<String, Long> concurrentHashMap) {
            this.f9694a = bVar;
            this.f9695b = str;
            this.f9696c = concurrentHashMap;
        }

        /* renamed from: a */
        public final Bundle m13092a() {
            int iM79993z = C13334c.m79993z(this.f9694a.f9688d);
            BackupObject backupObjectMo12792r = C2153l.f9673e.mo12792r(this.f9695b, this.f9694a.f9687c);
            if (backupObjectMo12792r == null) {
                return null;
            }
            long jLongValue = 102400;
            long jM13217y = 0;
            if (BackupConstant.m13146t().containsKey(this.f9695b)) {
                Long l10 = this.f9696c.get(BackupConstant.m13146t().get(this.f9695b));
                if (l10 != null && l10.longValue() != 0) {
                    jLongValue = l10.longValue();
                }
                if (BackupConstant.m13133g().containsKey(this.f9695b)) {
                    jM13217y = C2157a.m13217y(this.f9694a.f9685a, this.f9695b, backupObjectMo12792r.reassembleExtra(null));
                    jLongValue += jM13217y;
                }
            }
            Bundle bundleOnBackupModulesDataItemTotal = backupObjectMo12792r.onBackupModulesDataItemTotal(this.f9694a.f9685a, Long.valueOf(jLongValue), iM79993z, this.f9695b);
            if (bundleOnBackupModulesDataItemTotal != null) {
                C2111d.m12654j("ControlThread", "GetSystemModuleInfo media size is ", Long.valueOf(jM13217y));
                bundleOnBackupModulesDataItemTotal.putLong("SystemMediaSize", jM13217y);
            }
            return bundleOnBackupModulesDataItemTotal;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundleM13092a;
            C2111d.m12654j("ControlThread", "GetSystemModuleInfo Start, name = ", this.f9695b);
            if (C2153l.m13035b0() || C2153l.m13047h0()) {
                C2111d.m12653i("ControlThread", "stop loading data");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Set<String> setM13145s = BackupConstant.m13145s();
            C2152k c2152kM12988n = C2152k.m12988n();
            if (c2152kM12988n.m12992p() && setM13145s.contains(this.f9695b)) {
                C2111d.m12654j("ControlThread", "get preview load module start module = ", this.f9695b);
                bundleM13092a = c2152kM12988n.m12991o(this.f9695b);
                C2111d.m12653i("ControlThread", "get preview load module end");
            } else {
                bundleM13092a = m13092a();
            }
            synchronized (C2153l.f9672d) {
                if (bundleM13092a != null) {
                    try {
                        C2153l.f9679k.putParcelable(this.f9695b, bundleM13092a);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                C2153l.f9681m.incrementAndGet();
                C2111d.m12654j("ControlThread", "GetSystemModuleInfo end, name = ", this.f9695b, ", index = ", Integer.valueOf(C2153l.f9681m.get()), ", all size = ", Integer.valueOf(C2153l.f9680l), " , cost time = ", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                if (C2153l.f9681m.get() >= C2153l.f9680l && !C2153l.f9675g) {
                    C2153l.m13051j0(this.f9694a);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$g */
    public static class g implements Handler.Callback {

        /* renamed from: a */
        public Handler.Callback f9697a;

        /* renamed from: b */
        public String f9698b;

        public g(Handler.Callback callback, String str) {
            this.f9697a = callback;
            this.f9698b = str;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (this.f9697a == null || message == null) {
                return false;
            }
            if (message.obj == null) {
                message.obj = this.f9698b;
            }
            message.what = C2153l.m13053k0(message.what);
            this.f9697a.handleMessage(message);
            return false;
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$h */
    public static class h implements Runnable {

        /* renamed from: a */
        public b f9699a;

        public h(b bVar) {
            this.f9699a = bVar;
        }

        /* renamed from: a */
        public final boolean m13093a() {
            return System.currentTimeMillis() - C2153l.f9682n > 300000;
        }

        /* renamed from: c */
        public final boolean m13094c() {
            boolean z10;
            synchronized (C2153l.f9672d) {
                z10 = C2153l.f9681m.get() >= C2153l.f9680l;
            }
            return z10;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            C2111d.m12653i("ControlThread", "SystemLoadWatcher begin ...");
            while (true) {
                if (m13094c() || C2153l.m13035b0() || C2153l.m13047h0()) {
                    break;
                }
                if (m13093a()) {
                    C2111d.m12657m("ControlThread", "load system module timeout, return current load result");
                    boolean unused = C2153l.f9675g = true;
                    C2153l.m13051j0(this.f9699a);
                    break;
                } else {
                    try {
                        Thread.sleep(1000L);
                        C2111d.m12653i("ControlThread", "SystemLoadWatcher waiting ...");
                    } catch (InterruptedException unused2) {
                        C2111d.m12653i("ControlThread", "SystemLoadWatcher InterruptedException");
                    }
                }
            }
            C2111d.m12653i("ControlThread", "SystemLoadWatcher end ...");
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$i */
    public static class i extends Thread {

        /* renamed from: a */
        public Map<String, e> f9700a;

        /* renamed from: b */
        public C12699c f9701b;

        /* renamed from: c */
        public List<String> f9702c;

        public i(Map<String, e> map, List<String> list, C12699c c12699c) {
            this.f9700a = map;
            this.f9701b = c12699c;
            this.f9702c = list;
        }

        /* renamed from: a */
        public final void m13095a() {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f9702c) {
                if (this.f9701b.m80075a() == 0 && !BackupConstant.m13138l().get(str).booleanValue()) {
                    C2111d.m12654j("ControlThread", str, "is not finish,so submit.");
                    this.f9701b.m80077c(this.f9700a.get(str));
                }
                if (BackupConstant.m13138l().get(str).booleanValue()) {
                    C2111d.m12654j("ControlThread", str, "is finish,so remove.");
                    arrayList.add(str);
                }
            }
            this.f9702c.removeAll(arrayList);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            C2111d.m12654j("ControlThread", "WatchPrepareDataThread start,Thread name is :", Thread.currentThread().getName());
            while (!this.f9702c.isEmpty()) {
                try {
                    Thread.sleep(100L);
                    m13095a();
                } catch (InterruptedException unused) {
                    C2111d.m12648d("ControlThread", "InterruptedException");
                }
            }
            C2153l.m13006C();
            C2111d.m12653i("ControlThread", "GetBackupModuleDataInfo, WatchPrepareDataThread end, clearCurrentThreadData end");
        }
    }

    static {
        f9669a = C9142g.m57463b() ? "com.hihonor.android.launcher.intent.action.RESTORE" : "com.huawei.android.launcher.intent.action.RESTORE";
        f9670b = new int[][]{new int[]{0, 0}, new int[]{3, 1}, new int[]{71, 71}, new int[]{1, 2}, new int[]{4, 3}, new int[]{2, 12}, new int[]{5, 13}, new int[]{15, 20}, new int[]{11, 23}, new int[]{14, 21}, new int[]{16, 24}, new int[]{12, 27}, new int[]{13, 25}, new int[]{17, 15}, new int[]{22, 1067}, new int[]{9, 9}, new int[]{24, 19}, new int[]{25, 11}, new int[]{7, 7}, new int[]{100, 1100}, new int[]{101, 1101}, new int[]{102, 1102}};
        f9671c = new Object();
        f9672d = new Object();
        f9673e = null;
        f9674f = false;
        f9675g = false;
        f9676h = null;
        f9677i = null;
        f9678j = null;
        f9679k = null;
        f9681m = new AtomicInteger();
        f9683o = false;
    }

    /* renamed from: A */
    public static boolean m13002A(Handler.Callback callback, int i10, Object obj, Bundle bundle) {
        if (callback == null) {
            return false;
        }
        Message messageObtain = Message.obtain(null, i10, obj);
        messageObtain.setData(bundle);
        return callback.handleMessage(messageObtain);
    }

    /* renamed from: A0 */
    public static void m13003A0(b bVar) {
        String[] strArr;
        Bundle bundle = bVar.f9690f;
        if (bundle != null && bundle.containsKey("FollowingRestoreModules")) {
            BackupObject.setFollowingRestoreModules(C10713c.m65401k(bVar.f9690f, "FollowingRestoreModules"));
        } else if (bVar.f9686b != null) {
            BackupObject.setFollowingRestoreModules(new ArrayList(Arrays.asList(bVar.f9686b)));
        } else {
            C2111d.m12646b("ControlThread", "backupCmd is no operate");
        }
        if (bVar.f9690f == null || (strArr = bVar.f9686b) == null || strArr.length == 0 || BackupObject.isMediaModule(strArr[0])) {
            return;
        }
        C2111d.m12653i("ControlThread", "set APP_EXTRA_PARAMETER");
        Bundle bundle2 = BackupObject.APP_EXTRA_PARAMETER;
        bundle2.clear();
        if (bVar.f9690f.containsKey("VersionCode")) {
            bundle2.putInt("VersionCode", C10713c.m65394d(bVar.f9690f, "VersionCode"));
        }
        if (bVar.f9690f.containsKey("key_encrypt")) {
            bundle2.putBundle("key_encrypt", C10713c.m65393c(bVar.f9690f, "key_encrypt"));
        }
    }

    /* renamed from: B */
    public static void m13004B() {
        C2111d.m12653i("ControlThread", "clear abort flag");
        f9674f = false;
        f9683o = false;
        BackupObject.clearAbort();
        AbstractC0048c.m182e();
        AbstractC13696c.m82341j();
    }

    /* renamed from: B0 */
    public static void m13005B0(Map<String, e> map, List<String> list, C12699c c12699c) {
        i iVar = new i(map, list, c12699c);
        iVar.setName("WatchPrepareDataThread");
        iVar.start();
    }

    /* renamed from: C */
    public static void m13006C() {
        C2111d.m12653i("ControlThread", "Clear current thread name and current bundle when get backup module data info.");
        BackupConstant.m13137k().put("systemmodule", new Bundle());
        BackupConstant.m13137k().put("mediamodule", new Bundle());
        BackupConstant.m13137k().put("appmodule", new Bundle());
        BackupConstant.m13137k().put("mediasdmodule", new Bundle());
        BackupConstant.m13136j().put("systemmodule", new Bundle());
        BackupConstant.m13136j().put("mediamodule", new Bundle());
        BackupConstant.m13136j().put("appmodule", new Bundle());
        BackupConstant.m13136j().put("mediasdmodule", new Bundle());
        Map<String, Boolean> mapM13138l = BackupConstant.m13138l();
        Boolean bool = Boolean.FALSE;
        mapM13138l.put("systemmodule", bool);
        BackupConstant.m13138l().put("mediamodule", bool);
        BackupConstant.m13138l().put("appmodule", bool);
        BackupConstant.m13138l().put("mediasdmodule", bool);
    }

    /* renamed from: C0 */
    public static void m13007C0() {
        if (m13035b0()) {
            m13076w(f9676h, 19);
            m13004B();
        }
    }

    /* renamed from: D */
    public static void m13008D() {
        synchronized (f9671c) {
            try {
                if (f9677i != null) {
                    Looper looper = f9677i.getLooper();
                    f9677i = null;
                    if (looper != null) {
                        looper.quit();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        f9678j = null;
    }

    /* renamed from: D0 */
    public static boolean m13009D0() throws InterruptedException {
        if (f9678j == null) {
            f9678j = m13029X();
        }
        if (f9678j.getState() == Thread.State.NEW) {
            f9678j.start();
        }
        int i10 = 0;
        while (f9677i == null) {
            try {
                Thread.sleep(5L);
            } catch (InterruptedException unused) {
                C2111d.m12648d("ControlThread", "InterruptedException");
            }
            i10++;
            if (i10 > 100) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: E */
    public static long m13010E(Context context, String str, boolean z10) {
        Iterator<String> it = C2157a.m13198f(context, str, z10).iterator();
        long jM79988u = 0;
        while (it.hasNext()) {
            jM79988u += C13334c.m79988u(new File(it.next()));
        }
        return jM79988u;
    }

    /* renamed from: F */
    public static int m13011F(Context context) {
        AppsRisk appsRisk = new AppsRisk(context);
        if (!appsRisk.m12760f()) {
            return -1;
        }
        appsRisk.m12758d();
        return 1;
    }

    /* renamed from: G */
    public static boolean m13012G(Context context, Bundle bundle, Handler.Callback callback) {
        b bVar = new b(context, callback);
        bVar.f9690f = new Bundle(bundle);
        return m13073u0(31, bVar);
    }

    /* renamed from: H */
    public static void m13013H(b bVar) {
        m13080y(bVar.f9687c, 38, C2151j.m12976b(bVar));
    }

    /* renamed from: I */
    public static void m13014I(b bVar, String str) {
        Bundle bundleM12990m = C2152k.m12988n().m12990m(str);
        C9657a.m60323c(bVar.f9685a, str, (AppSizeBean) C10713c.m65398h(bundleM12990m, "appSizeDetail"));
        m13002A(bVar.f9687c, 1068, str, bundleM12990m);
    }

    /* renamed from: J */
    public static boolean m13015J(Context context, String[] strArr, Handler.Callback callback) {
        return m13073u0(26, new b(context, strArr, callback));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m13016K(com.huawei.android.backup.service.logic.C2153l.b r25) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.C2153l.m13016K(com.huawei.android.backup.service.logic.l$b):void");
    }

    /* renamed from: L */
    public static void m13017L(b bVar) {
        C2111d.m12653i("ControlThread", "get backup cloud module info start.");
        Bundle bundle = new Bundle();
        f9673e = C2134g.m12824a(bVar);
        ConcurrentHashMap<String, Long> concurrentHashMapM12742g = new PackageSizeUtils(bVar.f9685a).m12742g(bVar.f9685a, bVar.f9686b);
        for (String str : bVar.f9686b) {
            try {
            } catch (IllegalArgumentException unused) {
                m13082z(bVar.f9687c, 1100, C2111d.m12652h("ControlThread", str, "getBackupCloudModuleInfo", "IllegalArgumentException"));
                C2111d.m12654j("ControlThread", "module name:", str, " getBackupCloudModuleInfo IllegalArgumentException");
            } catch (Exception unused2) {
                m13082z(bVar.f9687c, 1100, C2111d.m12652h("ControlThread", str, "getBackupCloudModuleInfo", "Exception"));
                C2111d.m12654j("ControlThread", "module name:", str, " getBackupCloudModuleInfo Exception");
            }
            if (m13035b0()) {
                break;
            }
            BackupObject backupObjectM13020O = m13020O(bVar, str);
            if (backupObjectM13020O != null) {
                Bundle bundleOnBackupModulesDataItemTotal = "fmradio".equals(str) ? null : backupObjectM13020O.onBackupModulesDataItemTotal(bVar.f9685a, Long.valueOf(m13026U(bVar, concurrentHashMapM12742g, str, backupObjectM13020O.reassembleExtra(null))), C13334c.m79993z(bVar.f9688d), str);
                if (bundleOnBackupModulesDataItemTotal != null) {
                    bundle.putParcelable(str, bundleOnBackupModulesDataItemTotal);
                }
            }
        }
        m13080y(bVar.f9687c, 1065, bundle);
        C2111d.m12653i("ControlThread", "get backup cloud module info end.");
    }

    /* renamed from: M */
    public static void m13018M(b bVar) {
        if (C10713c.m65395e(bVar.f9690f, CloneService.KEY_ACTION_FLAG, -1) >= 10) {
            m13083z0(bVar);
            m13017L(bVar);
        } else {
            m13083z0(bVar);
            m13021P(bVar);
        }
    }

    /* renamed from: N */
    public static boolean m13019N(Context context, String[] strArr, Bundle bundle, Handler.Callback callback) {
        b bVar = new b(context, strArr, callback);
        bVar.f9690f = new Bundle(bundle);
        return m13073u0(23, bVar);
    }

    /* renamed from: O */
    public static BackupObject m13020O(b bVar, String str) {
        return f9673e.mo12792r(str, bVar.f9687c);
    }

    /* renamed from: P */
    public static void m13021P(b bVar) {
        C2111d.m12653i("ControlThread", "Get phone clone backup module info.");
        AbstractC2131d abstractC2131dM12824a = C2134g.m12824a(bVar);
        f9673e = abstractC2131dM12824a;
        abstractC2131dM12824a.mo12795u(bVar, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        f9673e.mo12774C(bVar, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        f9673e.mo12772A(bVar);
        ConcurrentHashMap<String, Long> concurrentHashMapM12742g = new PackageSizeUtils(bVar.f9685a).m12742g(bVar.f9685a, null);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str : bVar.f9686b) {
            if (BackupConstant.m13147u().contains(str) && !C2108a.m12621g(bVar.f9685a, str)) {
                hashSet.add(str);
            } else if ("app".equals(str)) {
                hashSet2.add(str);
            } else {
                C2111d.m12654j("ControlThread", "other module module = ", str);
            }
        }
        f9683o = false;
        f9675g = false;
        C12699c c12699cM76422d = C12699c.m76422d();
        m13069s0(bVar, concurrentHashMapM12742g, hashSet, c12699cM76422d);
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (!hashSet2.isEmpty()) {
            C2111d.m12653i("ControlThread", "mAppModules submit.");
            C12703g.m76454g(false);
            e eVar = new e(bVar, hashSet2, "appmodule");
            c12699cM76422d.m80077c(eVar);
            map.put("appmodule", eVar);
            arrayList.add("appmodule");
        }
        m13005B0(map, arrayList, c12699cM76422d);
    }

    /* renamed from: Q */
    public static long m13022Q(b bVar, String str) {
        if (BackupObject.isTwinApp(str)) {
            return m13010E(bVar.f9685a, str, true);
        }
        return 0L;
    }

    /* renamed from: R */
    public static void m13023R(Bundle bundle, long j10, long j11) {
        bundle.putLong("dataSize", j10);
        bundle.putLong("apkSize", j11);
    }

    /* renamed from: S */
    public static Bundle m13024S(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(64);
        if (installedPackages == null) {
            C2111d.m12653i("ControlThread", "installedAppList is null");
            return null;
        }
        Bundle bundle = new Bundle();
        Set<String> setM13200h = C2157a.m13200h();
        for (PackageInfo packageInfo : installedPackages) {
            if (!setM13200h.contains(packageInfo.packageName) && C13334c.m79959C(packageInfo.applicationInfo.sourceDir)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("VersionName", packageInfo.versionName);
                bundle2.putInt("VersionCode", packageInfo.versionCode);
                bundle2.putBoolean("is_hap_app", C10046b.m62458f(packageInfo.packageName));
                bundle.putBundle(packageInfo.packageName, bundle2);
            }
        }
        return bundle;
    }

    /* renamed from: T */
    public static Bundle m13025T(Context context) {
        Bundle bundle = new Bundle();
        AccountManager accountManager = AccountManager.get(context);
        if (accountManager == null) {
            return bundle;
        }
        Account[] accounts = accountManager.getAccounts();
        if (accounts.length > 0) {
            int length = accounts.length;
            for (int i10 = 0; i10 < length; i10++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("AccountName", "");
                bundle2.putString("AccountType", accounts[i10].type);
                bundle.putBundle(String.valueOf(i10), bundle2);
            }
        }
        return bundle;
    }

    /* renamed from: U */
    public static long m13026U(b bVar, ConcurrentHashMap<String, Long> concurrentHashMap, String str, Bundle bundle) {
        long jLongValue = 102400;
        if (!BackupConstant.m13146t().containsKey(str)) {
            return 102400L;
        }
        String str2 = BackupConstant.m13146t().get(str);
        if (str2 == null) {
            C2111d.m12653i("ControlThread", "get module size return 0: " + str);
            return 0L;
        }
        Long l10 = concurrentHashMap.get(str2);
        if (l10 != null && l10.longValue() != 0) {
            jLongValue = l10.longValue();
        }
        if (!BackupConstant.m13132f().contains(str)) {
            return jLongValue;
        }
        C2111d.m12654j("ControlThread", "common module name = ", str);
        return jLongValue + C2157a.m13217y(bVar.f9685a, str, bundle);
    }

    /* renamed from: V */
    public static void m13027V(b bVar) {
        C2111d.m12653i("ControlThread", "get device info begin");
        boolean zM65392b = C10713c.m65392b(bVar.f9690f, "isOldPhoneCmd", false);
        Bundle bundle = new Bundle();
        C13703a.m82444c().m82449g();
        if (zM65392b) {
            bundle.putStringArrayList("twinAppList", C12086a.m72264k(bVar.f9685a));
        } else {
            AbstractC2131d abstractC2131dM12824a = C2134g.m12824a(bVar);
            f9673e = abstractC2131dM12824a;
            bundle.putBundle("AllModulesInfo", abstractC2131dM12824a.mo12795u(bVar, "restore"));
            f9673e.mo12774C(bVar, "restore");
            bundle.putStringArrayList("SupprotedModule", f9673e.mo12789o(bVar));
            bundle.putBundle("ModuleExtraValue", f9673e.mo12787m(bVar));
            bundle.putBundle("InstalledAPP", m13024S(bVar.f9685a));
            bundle.putInt("APPDataFlag", AbstractC2124a.m12751c());
            bundle.putInt("APPRiskFlag", m13011F(bVar.f9685a));
            bundle.putBundle("LoginedAccount", m13025T(bVar.f9685a));
        }
        m13074v(bVar, zM65392b, bundle, true);
        m13080y(bVar.f9687c, 37, bundle);
        C2111d.m12653i("ControlThread", "get device info end");
    }

    /* renamed from: W */
    public static boolean m13028W(Context context, Bundle bundle, Handler.Callback callback) {
        b bVar = new b(context, callback);
        bVar.f9690f = new Bundle(bundle);
        return m13073u0(6, bVar);
    }

    /* renamed from: X */
    public static Thread m13029X() {
        return new d();
    }

    /* renamed from: Y */
    public static long m13030Y(b bVar, PackageSizeUtils packageSizeUtils, int i10, String str) {
        if (!BackupObject.isTwinApp(str)) {
            return 0L;
        }
        long jM12738c = packageSizeUtils.m12738c(bVar.f9685a, str, i10);
        C2111d.m12654j("ControlThread", "twin app size is : ", Long.valueOf(jM12738c));
        return jM12738c;
    }

    /* renamed from: Z */
    public static boolean m13031Z(Context context) {
        C2111d.m12653i("ControlThread", "Init socket.");
        return m13073u0(30, new b(context));
    }

    /* renamed from: a */
    public static void m13032a() {
        f9683o = true;
    }

    /* renamed from: a0 */
    public static void m13033a0() throws IOException {
        AbstractC2124a.m12752d();
    }

    /* renamed from: b */
    public static void m13034b(Handler.Callback callback) {
        f9676h = callback;
        m13079x0();
        BackupObject.setAbort();
        AbstractC0048c.m184x();
        AbstractC13696c.m82344x();
        synchronized (f9671c) {
            try {
                if (f9677i != null) {
                    Looper looper = f9677i.getLooper();
                    f9677i = null;
                    if (looper != null) {
                        looper.quit();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        f9678j = null;
    }

    /* renamed from: b0 */
    public static boolean m13035b0() {
        return f9674f;
    }

    /* renamed from: c0 */
    public static boolean m13037c0(Context context) {
        boolean z10 = C2157a.m13177L(context) && C13349r.m80088d() && PmsCheckUtil.m12613g();
        C2111d.m12654j("ControlThread", "[SplitTar] isDeviceSupportSplitTar ", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: d0 */
    public static boolean m13039d0(boolean z10) {
        if (PmsCheckUtil.m12614h() && C13349r.m80087c() && m13049i0()) {
            return z10 || PmsCheckUtil.m12609c();
        }
        return false;
    }

    /* renamed from: e0 */
    public static boolean m13041e0(Context context) {
        boolean z10 = C2157a.m13177L(context) && C13349r.m80088d() && PmsCheckUtil.m12612f();
        C2111d.m12654j("ControlThread", "[Shortcut] isSupportShortcutBackup ", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: f0 */
    public static boolean m13043f0(String str) {
        return NavigationUtils.SMS_SCHEMA_PREF.equals(str) || BackupObject.isMediaModule(str);
    }

    /* renamed from: g0 */
    public static boolean m13045g0() {
        boolean z10 = PmsCheckUtil.m12614h() && PmsCheckUtil.m12607a() > 0;
        C2111d.m12654j("ControlThread", " isPmsSupportDecompressTarByPath = ", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: h0 */
    public static boolean m13047h0() {
        return f9683o;
    }

    /* renamed from: i0 */
    public static boolean m13049i0() {
        boolean zM81425c = C13529c.m81425c(C9142g.m57463b() ? "msc.config.support_clone_app" : "ro.config.hw_support_clone_app", false);
        C2111d.m12654j("ControlThread", "isSystemSupportTwinApp ", Boolean.valueOf(zM81425c));
        return zM81425c;
    }

    /* renamed from: j0 */
    public static void m13051j0(b bVar) {
        C2111d.m12654j("ControlThread", "query all system module end, cost time = ", Long.valueOf(System.currentTimeMillis() - f9682n));
        f9679k.putString("getbackupmoduleinfo", "systemmodule");
        m13080y(bVar.f9687c, 1065, f9679k);
    }

    /* renamed from: k0 */
    public static int m13053k0(int i10) {
        for (int[] iArr : f9670b) {
            if (iArr[0] == i10) {
                return iArr[1];
            }
        }
        return 6;
    }

    /* renamed from: l0 */
    public static boolean m13055l0(Context context, String[] strArr, BackupLogicService.C2116b c2116b, Handler.Callback callback) {
        if (c2116b == null) {
            return false;
        }
        b bVar = new b(context, c2116b.m12698b(), c2116b.m12697a(), strArr, callback);
        bVar.f9690f = new Bundle(c2116b.m12699c());
        return m13073u0(0, bVar);
    }

    /* renamed from: m0 */
    public static boolean m13057m0(Context context, String[] strArr, BackupLogicService.C2116b c2116b, Handler.Callback callback) {
        if (c2116b == null) {
            return false;
        }
        C2111d.m12654j("ControlThread", "Restore start! modules:", strArr != null ? Arrays.toString(strArr) : "");
        b bVar = new b(context, c2116b.m12698b(), c2116b.m12697a(), strArr, callback);
        bVar.f9690f = new Bundle(c2116b.m12699c());
        return m13073u0(1, bVar);
    }

    /* renamed from: n0 */
    public static void m13059n0(b bVar, Bundle bundle) {
        if (!"com.huawei.hidisk".equals(bVar.f9685a.getPackageName())) {
            bundle.putBoolean("isPerformanceService", true);
            return;
        }
        C2111d.m12653i("ControlThread", "isHidiskService");
        bundle.putBoolean("isPerformanceService", false);
        bundle.putBoolean("isPerformanceHidiskService", true);
    }

    /* renamed from: o0 */
    public static boolean m13061o0(Message message, b bVar) throws PackageManager.NameNotFoundException {
        int i10 = message.what;
        if (i10 == 6) {
            m13027V(bVar);
        } else if (i10 == 23) {
            m13018M(bVar);
        } else {
            if (i10 != 26) {
                return false;
            }
            m13016K(bVar);
        }
        return true;
    }

    /* renamed from: p0 */
    public static void m13063p0(Message message, b bVar) throws IOException {
        C2111d.m12654j("ControlThread", "restoreCommon sendCmd ", Integer.valueOf(message.what));
        int i10 = message.what;
        if (i10 == 0) {
            C2111d.m12653i("ControlThread", "restoreCommon sendCmd CMD_BACKUP_START!");
            m13072u(bVar);
            return;
        }
        if (i10 == 1) {
            C2111d.m12653i("ControlThread", "restoreCommon sendCmd CMD_RESTORE_START!");
            m13071t0(bVar);
        } else if (i10 == 30) {
            C2111d.m12653i("ControlThread", "restoreCommon sendCmd CMD_INIT_SOCKET_SUPPORT!");
            m13033a0();
        } else {
            if (i10 != 31) {
                return;
            }
            C2111d.m12653i("ControlThread", "restoreCommon sendCmd CMD_GET_APP_RISK_INFO!");
            m13013H(bVar);
        }
    }

    /* renamed from: q0 */
    public static void m13065q0(b bVar) {
        if (!C13349r.m80086b(bVar.f9685a)) {
            m13075v0(bVar.f9685a, BackupConstant.KoBackupIntent.RESTORE_BEGIN);
        }
        m13077w0(bVar.f9685a, 1000);
        String[] strArr = bVar.f9686b;
        C2111d.m12654j("ControlThread", "RestoreRaw real start! modules:", strArr != null ? Arrays.toString(strArr) : "");
        m13083z0(bVar);
        m13003A0(bVar);
        AbstractC2131d abstractC2131dM12824a = C2134g.m12824a(bVar);
        f9673e = abstractC2131dM12824a;
        abstractC2131dM12824a.mo12799y(bVar);
        f9673e.mo12797w(bVar);
        m13077w0(bVar.f9685a, 1001);
        m13075v0(bVar.f9685a, BackupConstant.KoBackupIntent.RESTORE_COMPLETE);
    }

    /* renamed from: r0 */
    public static void m13067r0(Context context, Bundle bundle) {
        UserManager userManager = (UserManager) context.getSystemService("user");
        if (userManager != null) {
            boolean zHasUserRestriction = userManager.hasUserRestriction("no_sms");
            bundle.putBoolean("isSupportSms", zHasUserRestriction);
            boolean zHasUserRestriction2 = userManager.hasUserRestriction("no_outgoing_calls");
            bundle.putBoolean("isSupportCall", zHasUserRestriction2);
            C2111d.m12654j("ControlThread", "isDisallowSms ", Boolean.valueOf(zHasUserRestriction), ", isDisallowCall ", Boolean.valueOf(zHasUserRestriction2));
        }
    }

    /* renamed from: s0 */
    public static void m13069s0(b bVar, ConcurrentHashMap<String, Long> concurrentHashMap, Set<String> set, C12699c c12699c) {
        if (set.isEmpty()) {
            return;
        }
        C2111d.m12653i("ControlThread", "mSystemModules submit.");
        C12703g.m76454g(false);
        synchronized (f9672d) {
            f9682n = System.currentTimeMillis();
            Bundle bundle = new Bundle();
            f9679k = bundle;
            C10713c.m65403m(bundle);
            f9680l = set.size();
            f9681m.set(0);
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            c12699c.m80077c(new f(bVar, it.next(), concurrentHashMap));
        }
        c12699c.m80077c(new h(bVar));
    }

    /* renamed from: t0 */
    public static void m13071t0(b bVar) {
        if (m13043f0(bVar.f9686b[0])) {
            new Thread(new a(bVar), "restoreRaw").start();
        } else {
            m13065q0(bVar);
        }
    }

    /* renamed from: u */
    public static void m13072u(b bVar) {
        if (C13334c.m79969b(bVar.f9688d, bVar.f9687c, 115343360L)) {
            String[] strArr = bVar.f9686b;
            C2111d.m12654j("ControlThread", "backupCommon backupRaw real start!modules:", strArr != null ? Arrays.toString(strArr) : "");
            m13083z0(bVar);
            f9673e = C2134g.m12824a(bVar);
            if (C10713c.m65392b(bVar.f9690f, "isFromBreakPoint", false)) {
                C2111d.m12653i("ControlThread", "It's break point case, phone clone need reset extra values to supported modules!");
                f9673e.mo12795u(bVar, CloudBackupConstant.Command.PMS_CMD_BACKUP);
                f9673e.mo12774C(bVar, CloudBackupConstant.Command.PMS_CMD_BACKUP);
                f9673e.mo12772A(bVar);
            }
            f9673e.mo12800z(bVar);
            f9673e.mo12776b(bVar);
        }
    }

    /* renamed from: u0 */
    public static boolean m13073u0(int i10, b bVar) {
        C2111d.m12654j("ControlThread", "Send backupCmd start,cmdType:", Integer.valueOf(i10));
        if (!m13009D0()) {
            C2111d.m12648d("ControlThread", "waitBackupThreadStarted fail!");
            return false;
        }
        if (f9677i != null) {
            return f9677i.sendMessage(f9677i.obtainMessage(i10, bVar));
        }
        C2111d.m12648d("ControlThread", "backupHandler is null");
        return false;
    }

    /* renamed from: v */
    public static void m13074v(b bVar, boolean z10, Bundle bundle, boolean z11) {
        bundle.putBoolean("isOldPhoneCmd", z10);
        m13059n0(bVar, bundle);
        bundle.putBoolean("isSupportTar", PmsCheckUtil.m12614h());
        bundle.putBoolean("isSupportPMS", PmsCheckUtil.m12611e());
        bundle.putBoolean("SupportTaskParallelOptimization", true);
        bundle.putBoolean("isSupportTwinApp", m13039d0(z10));
        bundle.putBoolean("isSupportPduFileOptimization", true);
        bundle.putBoolean("isSupportShortcutBackup", m13041e0(bVar.f9685a));
        bundle.putBoolean("isSupportTarRecorder", true);
        bundle.putBoolean("isSupportAppObb", true);
        bundle.putBoolean("isSupportPmsSplitTar", m13037c0(bVar.f9685a));
        bundle.putBoolean("isSupportGalleryClone", true);
        bundle.putString("cpuArchitectureType", C2157a.m13204l());
        bundle.putBoolean("isSupportBundleApp", z11);
        bundle.putBoolean("isPmsSupportDecompressTarByPath", m13045g0());
        if (z11) {
            bundle.putInt("displayMetrics", C2157a.m13210r(bVar.f9685a));
            if (z10) {
                bundle.putStringArrayList("allLanguages", C2157a.m13197e());
            } else {
                bundle.putString("curLanguage", C2157a.m13205m());
            }
        }
        m13067r0(bVar.f9685a, bundle);
    }

    /* renamed from: v0 */
    public static void m13075v0(Context context, String str) {
        C2111d.m12647c("ControlThread", "sendBroadcast: ", str);
        context.sendBroadcast(new Intent(str));
    }

    /* renamed from: w */
    public static boolean m13076w(Handler.Callback callback, int i10) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain((Handler) null, i10));
    }

    /* renamed from: w0 */
    public static void m13077w0(Context context, int i10) {
        if (C13349r.m80086b(context)) {
            return;
        }
        Intent intent = new Intent(f9669a);
        intent.putExtra("action_type", i10);
        context.sendBroadcast(intent);
    }

    /* renamed from: x */
    public static boolean m13078x(Handler.Callback callback, int i10, int i11, int i12, Object obj) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain(null, i10, i11, i12, obj));
    }

    /* renamed from: x0 */
    public static void m13079x0() {
        f9674f = true;
    }

    /* renamed from: y */
    public static boolean m13080y(Handler.Callback callback, int i10, Bundle bundle) {
        if (callback == null) {
            return false;
        }
        Message messageObtain = Message.obtain((Handler) null, i10);
        messageObtain.setData(bundle);
        return callback.handleMessage(messageObtain);
    }

    /* renamed from: y0 */
    public static void m13081y0(b bVar, String str, long j10, AppSizeBean appSizeBean) {
        appSizeBean.m12596c(j10);
        appSizeBean.m12601h(C13694a.m82330h(bVar.f9685a, str));
    }

    /* renamed from: z */
    public static boolean m13082z(Handler.Callback callback, int i10, Object obj) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain(null, i10, obj));
    }

    /* renamed from: z0 */
    public static void m13083z0(b bVar) {
        Bundle bundle = bVar.f9690f;
        if (bundle == null) {
            return;
        }
        BackupObject.updateExecuteParameter(bundle);
    }

    /* renamed from: com.huawei.android.backup.service.logic.l$b */
    public static class b {

        /* renamed from: a */
        public Context f9685a;

        /* renamed from: b */
        public String[] f9686b;

        /* renamed from: c */
        public Handler.Callback f9687c;

        /* renamed from: d */
        public String f9688d;

        /* renamed from: e */
        public String f9689e;

        /* renamed from: f */
        public Bundle f9690f;

        public b(Context context, String str, String str2, String[] strArr, Handler.Callback callback) {
            this(context, strArr, callback);
            this.f9688d = str;
            this.f9689e = str2;
        }

        /* renamed from: a */
        public final long m13084a(Context context) {
            return C13345n.m80064c(this.f9688d) + C13334c.m79988u(new File(this.f9688d)) + C13334c.m79957A(context);
        }

        /* renamed from: b */
        public final List<String> m13085b(HashMap<String, Long> map) {
            Bundle bundleM65393c = C10713c.m65393c(BackupObject.getExecuteParameter(), "app");
            if (bundleM65393c == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : this.f9686b) {
                if (bundleM65393c.containsKey(str)) {
                    if (C10713c.m65395e(bundleM65393c, str, 3) == 1) {
                        map.put(str, 0L);
                        arrayList.add(str);
                    } else {
                        AppSizeBean appSizeBeanM60322b = C9657a.m60322b(this.f9685a, str);
                        if (appSizeBeanM60322b != null) {
                            C2111d.m12654j("ControlThread", "module ", str, ", appSize ", Long.valueOf(appSizeBeanM60322b.m12595a()));
                            map.put(str, Long.valueOf(appSizeBeanM60322b.m12595a()));
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.HashMap<java.lang.String, java.lang.Long> m13086c() {
            /*
                r13 = this;
                java.lang.String r0 = "initBackupModuleMap begin"
                java.lang.String r1 = "ControlThread"
                com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r0)
                android.content.Context r0 = r13.f9685a
                if (r0 == 0) goto Lce
                java.lang.String[] r0 = r13.f9686b
                if (r0 == 0) goto Lce
                int r0 = r0.length
                if (r0 != 0) goto L14
                goto Lce
            L14:
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.util.List r2 = r13.m13085b(r0)
                java.util.HashSet r3 = new java.util.HashSet
                java.lang.String[] r4 = r13.f9686b
                java.util.List r4 = java.util.Arrays.asList(r4)
                r3.<init>(r4)
                r3.removeAll(r2)
                int r2 = r3.size()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.String r4 = " "
                java.lang.String r5 = "needQueryModules size "
                java.lang.Object[] r2 = new java.lang.Object[]{r5, r2, r4, r3}
                com.huawei.android.backup.filelogic.utils.C2111d.m12654j(r1, r2)
                com.huawei.android.backup.service.logic.PackageSizeUtils r2 = new com.huawei.android.backup.service.logic.PackageSizeUtils
                android.content.Context r4 = r13.f9685a
                r2.<init>(r4)
                android.content.Context r4 = r13.f9685a
                java.util.concurrent.ConcurrentHashMap r2 = r2.m12741f(r4, r3)
                java.lang.String r4 = "needQueryModules query end"
                com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r4)
                android.os.Bundle r4 = com.huawei.android.backup.service.logic.BackupObject.getExecuteParameter()
                java.lang.String r5 = "app"
                android.os.Bundle r4 = p386j6.C10713c.m65393c(r4, r5)
                java.util.Iterator r3 = r3.iterator()
            L5e:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto Lb5
                java.lang.Object r5 = r3.next()
                java.lang.String r5 = (java.lang.String) r5
                boolean r6 = r13.m13088e(r2, r5)
                r7 = 102400(0x19000, double:5.05923E-319)
                r9 = 0
                if (r6 == 0) goto L92
                java.util.concurrent.ConcurrentHashMap r6 = com.huawei.android.backup.service.utils.BackupConstant.m13146t()
                java.lang.Object r6 = r6.get(r5)
                java.lang.Object r6 = r2.get(r6)
                java.lang.Long r6 = (java.lang.Long) r6
                if (r6 == 0) goto Lad
                long r11 = r6.longValue()
                int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r9 == 0) goto Lad
                long r7 = r6.longValue()
                goto Lad
            L92:
                boolean r6 = r13.m13087d(r2, r4, r5)
                if (r6 == 0) goto La6
                java.lang.Object r6 = r2.get(r5)
                java.lang.Long r6 = (java.lang.Long) r6
                if (r6 == 0) goto Lac
                long r6 = r6.longValue()
                r7 = r6
                goto Lad
            La6:
                boolean r6 = com.huawei.android.backup.service.logic.BackupObject.isMediaModule(r5)
                if (r6 == 0) goto Lad
            Lac:
                r7 = r9
            Lad:
                java.lang.Long r6 = java.lang.Long.valueOf(r7)
                r0.put(r5, r6)
                goto L5e
            Lb5:
                java.lang.String r13 = "com.tencent.mm"
                boolean r2 = r0.containsKey(r13)
                if (r2 == 0) goto Lc8
                long r2 = com.huawei.android.backup.service.logic.BackupObject.getWeChatDataSize()
                java.lang.Long r2 = java.lang.Long.valueOf(r2)
                r0.put(r13, r2)
            Lc8:
                java.lang.String r13 = "initBackupModuleMapNew end"
                com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r1, r13)
                return r0
            Lce:
                r13 = 0
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.backup.service.logic.C2153l.b.m13086c():java.util.HashMap");
        }

        /* renamed from: d */
        public final boolean m13087d(ConcurrentHashMap<String, Long> concurrentHashMap, Bundle bundle, String str) {
            return bundle != null && bundle.containsKey(str) && concurrentHashMap.containsKey(str);
        }

        /* renamed from: e */
        public final boolean m13088e(ConcurrentHashMap<String, Long> concurrentHashMap, String str) {
            return BackupConstant.m13146t().containsKey(str) && concurrentHashMap.containsKey(BackupConstant.m13146t().get(str));
        }

        /* renamed from: f */
        public boolean m13089f(long j10) throws InterruptedException {
            int i10 = 0;
            while (!C2153l.m13035b0()) {
                long jM13084a = m13084a(this.f9685a);
                C2111d.m12654j("ControlThread", "waitUntilSpaceFree, need size: ", Long.valueOf(j10), " , total usable size: ", Long.valueOf(jM13084a));
                if (jM13084a < j10) {
                    if (i10 == 2) {
                        C2111d.m12649e("ControlThread", "waitUntilSpaceFree, free Size: ", Long.valueOf(C13345n.m80064c(this.f9688d)), " , temp file size: ", Long.valueOf(C13334c.m79988u(new File(this.f9688d))), " , temp app tar size: ", Long.valueOf(C13334c.m79957A(this.f9685a)), " location: ", this.f9688d);
                        return false;
                    }
                    C2111d.m12658n("ControlThread", "waitUntilSpaceFree totalUsable is not enough, retry time: ", Integer.valueOf(i10));
                    i10++;
                }
                try {
                    Thread.sleep(500L);
                    if (C13334c.m79968a(this.f9688d, j10)) {
                        return true;
                    }
                } catch (InterruptedException e10) {
                    C2111d.m12649e("ControlThread", "InterruptedException ", e10.getMessage());
                    return false;
                }
            }
            C2111d.m12648d("ControlThread", "waitUntilSpaceFree abort");
            return false;
        }

        public b(Context context) {
            this.f9685a = context;
        }

        public b(Context context, Handler.Callback callback) {
            this.f9685a = context;
            this.f9687c = callback;
        }

        public b(Context context, String[] strArr, Handler.Callback callback) {
            this(context, callback);
            this.f9686b = strArr;
        }
    }
}
