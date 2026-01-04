package com.huawei.android.backup.service.logic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.appdata.model.AppSizeBean;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.installedapps.C2150h;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p386j6.C10713c;
import p544p4.C12086a;
import p699v4.C13334c;
import p699v4.C13346o;
import p699v4.C13348q;
import p762x4.C13694a;

/* renamed from: com.huawei.android.backup.service.logic.k */
/* loaded from: classes.dex */
public class C2152k {

    /* renamed from: i */
    public static C2152k f9648i = new C2152k();

    /* renamed from: j */
    public static final Object f9649j = new Object();

    /* renamed from: k */
    public static final Object f9650k = new Object();

    /* renamed from: a */
    public volatile C13346o f9651a = null;

    /* renamed from: b */
    public Bundle f9652b = null;

    /* renamed from: c */
    public AtomicBoolean f9653c = new AtomicBoolean(false);

    /* renamed from: d */
    public AtomicInteger f9654d = new AtomicInteger();

    /* renamed from: e */
    public AtomicBoolean f9655e = new AtomicBoolean(false);

    /* renamed from: f */
    public ConcurrentHashMap<String, Bundle> f9656f = null;

    /* renamed from: g */
    public Bundle f9657g = null;

    /* renamed from: h */
    public AtomicBoolean f9658h = new AtomicBoolean(false);

    /* renamed from: com.huawei.android.backup.service.logic.k$a */
    public class a implements Runnable {

        /* renamed from: a */
        public Context f9659a;

        /* renamed from: b */
        public PackageSizeUtils f9660b;

        /* renamed from: c */
        public int f9661c;

        /* renamed from: d */
        public boolean f9662d;

        /* renamed from: e */
        public HashMap<String, Long> f9663e = new HashMap<>();

        /* renamed from: f */
        public ArrayList<String> f9664f = new ArrayList<>();

        public a(Context context) {
            this.f9659a = context;
            this.f9660b = new PackageSizeUtils(context);
        }

        /* renamed from: a */
        public final AppSizeBean m12999a(String str) throws PackageManager.NameNotFoundException {
            long jM12987k;
            long jM12738c;
            long jM12987k2;
            if (m13000c(str)) {
                Long l10 = this.f9663e.get(str);
                long jLongValue = l10 != null ? l10.longValue() : 0L;
                jM12738c = this.f9664f.contains(str) ? this.f9660b.m12738c(this.f9659a, str, this.f9661c) : 0L;
                if (C2157a.m13183R(this.f9659a, str)) {
                    jM12987k2 = C2152k.m12987k(this.f9659a, str, false);
                    j = jLongValue;
                    jM12987k = this.f9664f.contains(str) ? C2152k.m12987k(this.f9659a, str, true) : 0L;
                } else {
                    jM12987k2 = 0;
                    j = jLongValue;
                    jM12987k = 0;
                }
            } else {
                jM12987k = 0;
                jM12738c = 0;
                jM12987k2 = 0;
            }
            long jM82323a = C13694a.m82323a(this.f9659a, str);
            boolean zM82330h = C13694a.m82330h(this.f9659a, str);
            AppSizeBean appSizeBean = new AppSizeBean(str);
            appSizeBean.m12596c(jM82323a);
            appSizeBean.m12597d(j);
            appSizeBean.m12600g(jM12738c);
            appSizeBean.m12598e(jM12987k2);
            appSizeBean.m12599f(jM12987k);
            appSizeBean.m12601h(zM82330h);
            C2111d.m12647c("ControlPreloadManager", "[SplitTar] module size ", appSizeBean.toString());
            return appSizeBean;
        }

        /* renamed from: c */
        public final boolean m13000c(String str) {
            return this.f9662d && C13694a.m82335m(this.f9659a, str);
        }

        /* renamed from: d */
        public final void m13001d(ArrayList<String> arrayList) {
            if (this.f9662d) {
                this.f9663e = C13694a.m82337o(this.f9659a, arrayList);
            }
            this.f9664f = C12086a.m72264k(this.f9659a);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Bundle bundle = new Bundle();
                String str = arrayList.get(i10);
                bundle.putParcelable("appSizeDetail", m12999a(str));
                C2152k.this.f9656f.put(str, bundle);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            C2111d.m12653i("ControlPreloadManager", "PreloadAppModuleInfo start");
            List<PackageInfo> installedPackages = this.f9659a.getPackageManager().getInstalledPackages(64);
            if (installedPackages == null) {
                C2111d.m12653i("ControlPreloadManager", "installedAppList is null");
                return;
            }
            Set<String> setM13200h = C2157a.m13200h();
            int size = installedPackages.size();
            C2152k.this.f9656f = new ConcurrentHashMap(size);
            this.f9661c = C12086a.m72256c(this.f9659a);
            this.f9662d = C2157a.m13177L(this.f9659a);
            ArrayList<String> arrayList = new ArrayList<>();
            for (PackageInfo packageInfo : installedPackages) {
                if (C2150h.m12968b(packageInfo, setM13200h, null, 0, this.f9662d)) {
                    arrayList.add(packageInfo.packageName);
                } else {
                    C2111d.m12647c("ControlPreloadManager", "app [", packageInfo.packageName, "] doesn't support clone.");
                }
            }
            m13001d(arrayList);
            C2152k.this.m12994r(arrayList.size(), 1L, arrayList);
            C2152k.this.f9658h.set(true);
            C2111d.m12653i("ControlPreloadManager", "PreloadAppModuleInfo end");
        }
    }

    /* renamed from: com.huawei.android.backup.service.logic.k$b */
    public class b implements Runnable {

        /* renamed from: a */
        public Context f9666a;

        /* renamed from: b */
        public String f9667b;

        public b(Context context, String str) {
            this.f9666a = context;
            this.f9667b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2111d.m12654j("ControlPreloadManager", "PreloadSystemModuleInfo start moduleName = ", this.f9667b);
            BackupObject backupObjectMo12792r = new C2132e().mo12792r(this.f9667b, null);
            if (backupObjectMo12792r == null) {
                return;
            }
            ConcurrentHashMap<String, Long> concurrentHashMapM12742g = new PackageSizeUtils(this.f9666a).m12742g(this.f9666a, null);
            long jM13217y = 0;
            if (BackupConstant.m13146t().containsKey(this.f9667b)) {
                long jLongValue = concurrentHashMapM12742g.get(BackupConstant.m13146t().get(this.f9667b)).longValue();
                j = jLongValue != 0 ? jLongValue : 102400L;
                if (BackupConstant.m13133g().containsKey(this.f9667b)) {
                    jM13217y = C2157a.m13217y(this.f9666a, this.f9667b, backupObjectMo12792r.reassembleExtra(null));
                    j += jM13217y;
                }
            }
            Bundle bundleOnBackupModulesDataItemTotal = backupObjectMo12792r.onBackupModulesDataItemTotal(this.f9666a, Long.valueOf(j), 1, this.f9667b);
            if (bundleOnBackupModulesDataItemTotal != null) {
                C2111d.m12654j("ControlPreloadManager", "PreloadSystemModuleInfo media size is ", Long.valueOf(jM13217y));
                bundleOnBackupModulesDataItemTotal.putLong("SystemMediaSize", jM13217y);
            }
            synchronized (C2152k.f9650k) {
                try {
                    if (C2152k.this.f9652b == null) {
                        C2152k.this.f9652b = new Bundle();
                    }
                    C2152k.this.f9652b.putParcelable(this.f9667b, bundleOnBackupModulesDataItemTotal);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            C2152k.this.f9654d.incrementAndGet();
            C2111d.m12654j("ControlPreloadManager", "PreloadSystemModuleInfo end moduleName = ", this.f9667b);
            if (C2152k.this.f9654d.get() >= BackupConstant.m13145s().size()) {
                C2152k.this.f9653c.set(true);
                C2111d.m12653i("ControlPreloadManager", "PreloadSystemModuleInfo all system module finish ");
            }
        }
    }

    /* renamed from: k */
    public static long m12987k(Context context, String str, boolean z10) {
        Iterator<String> it = C2157a.m13198f(context, str, z10).iterator();
        long jM79988u = 0;
        while (it.hasNext()) {
            jM79988u += C13334c.m79988u(new File(it.next()));
        }
        return jM79988u;
    }

    /* renamed from: n */
    public static C2152k m12988n() {
        return f9648i;
    }

    /* renamed from: l */
    public Bundle m12989l(Set<String> set, int i10) {
        m12998v();
        synchronized (f9649j) {
            try {
                Bundle bundle = this.f9657g;
                if (bundle == null || set == null || i10 == 0) {
                    return bundle;
                }
                try {
                    ArrayList<String> arrayListM65401k = C10713c.m65401k(bundle, "AppPackageList");
                    ArrayList<String> arrayList = new ArrayList<>();
                    int i11 = 0;
                    if (C13348q.m80084d(arrayListM65401k)) {
                        int size = arrayListM65401k.size();
                        int i12 = 0;
                        while (i11 < size) {
                            String str = arrayListM65401k.get(i11);
                            if (!set.contains(str)) {
                                i12++;
                                arrayList.add(str);
                            }
                            i11++;
                        }
                        i11 = i12;
                    }
                    this.f9657g.putInt("ModuleCount", i11);
                    this.f9657g.putLong("ModuleSize", 1L);
                    this.f9657g.putStringArrayList("AppPackageList", arrayList);
                    return this.f9657g;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    C2111d.m12648d("ControlPreloadManager", "ArrayIndexOutOfBoundsException: get KEY_APP_PACKAGE_LIST");
                    return new Bundle();
                } catch (Exception unused2) {
                    C2111d.m12648d("ControlPreloadManager", "Exception: get KEY_APP_PACKAGE_LIST");
                    return new Bundle();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public Bundle m12990m(String str) {
        m12998v();
        ConcurrentHashMap<String, Bundle> concurrentHashMap = this.f9656f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return new Bundle();
        }
        Bundle bundle = this.f9656f.get(str);
        if (bundle == null) {
            return new Bundle();
        }
        AppSizeBean appSizeBean = (AppSizeBean) C10713c.m65398h(bundle, "appSizeDetail");
        if (appSizeBean != null) {
            if (!BackupObject.isTwinApp(str)) {
                appSizeBean.m12600g(0L);
                appSizeBean.m12599f(0L);
            }
            if (!BackupObject.isBothPhoneSupportAppExternalData()) {
                appSizeBean.m12598e(0L);
                appSizeBean.m12599f(0L);
            }
            bundle.putParcelable("appSizeDetail", appSizeBean);
        }
        return bundle;
    }

    /* renamed from: o */
    public Bundle m12991o(String str) {
        Bundle bundle;
        if (!BackupConstant.m13145s().contains(str)) {
            return null;
        }
        while (!this.f9653c.get() && m12992p() && m12997u()) {
        }
        C2111d.m12654j("ControlPreloadManager", "getLoadedModuleInfo finish moduleName = ", str);
        synchronized (f9650k) {
            try {
                Bundle bundle2 = this.f9652b;
                bundle = bundle2 != null ? (Bundle) C10713c.m65398h(bundle2, str) : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (bundle == null) {
            C2111d.m12653i("ControlPreloadManager", "getLoadedModuleInfo finish bunle is null");
        }
        return bundle;
    }

    /* renamed from: p */
    public boolean m12992p() {
        return this.f9655e.get();
    }

    /* renamed from: q */
    public final void m12993q() {
        C2111d.m12653i("ControlPreloadManager", "reset start");
        f9648i = new C2152k();
    }

    /* renamed from: r */
    public final void m12994r(int i10, long j10, ArrayList<String> arrayList) {
        synchronized (f9649j) {
            Bundle bundle = new Bundle();
            this.f9657g = bundle;
            bundle.putInt("ModuleCount", i10);
            this.f9657g.putLong("ModuleSize", j10);
            this.f9657g.putStringArrayList("AppPackageList", arrayList);
        }
    }

    /* renamed from: s */
    public void m12995s() {
        C2111d.m12653i("ControlPreloadManager", "shutDownPreadThread start");
        this.f9655e.set(false);
        if (this.f9651a != null) {
            this.f9651a.m80076b();
            this.f9651a = null;
        }
        m12993q();
    }

    /* renamed from: t */
    public void m12996t(Context context) {
        BackupConstant.m13146t();
        C2111d.m12653i("ControlPreloadManager", "startPreloadThread start");
        this.f9655e.set(true);
        Set<String> setM13145s = BackupConstant.m13145s();
        this.f9651a = new C13346o(5, 25, 30);
        this.f9651a.m80077c(new a(context));
        Iterator<String> it = setM13145s.iterator();
        while (it.hasNext()) {
            this.f9651a.m80077c(new b(context, it.next()));
        }
    }

    /* renamed from: u */
    public final boolean m12997u() throws InterruptedException {
        try {
            Thread.sleep(100L);
            return true;
        } catch (InterruptedException e10) {
            C2111d.m12654j("ControlPreloadManager", "InterruptedException e = ", e10.getMessage());
            return false;
        }
    }

    /* renamed from: v */
    public final void m12998v() {
        while (!this.f9658h.get() && m12992p() && m12997u()) {
        }
        C2111d.m12653i("ControlPreloadManager", "waitAppLoadOk");
    }
}
