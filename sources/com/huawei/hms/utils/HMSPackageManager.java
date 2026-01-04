package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.device.C5165a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes8.dex */
public class HMSPackageManager {

    /* renamed from: o */
    private static HMSPackageManager f30171o;

    /* renamed from: p */
    private static final Object f30172p = new Object();

    /* renamed from: q */
    private static final Object f30173q = new Object();

    /* renamed from: r */
    private static final Object f30174r = new Object();

    /* renamed from: s */
    private static final Map<String, String> f30175s;

    /* renamed from: a */
    private final Context f30176a;

    /* renamed from: b */
    private final PackageManagerHelper f30177b;

    /* renamed from: c */
    private String f30178c;

    /* renamed from: d */
    private String f30179d;

    /* renamed from: e */
    private int f30180e;

    /* renamed from: f */
    private String f30181f;

    /* renamed from: g */
    private String f30182g;

    /* renamed from: h */
    private String f30183h;

    /* renamed from: i */
    private String f30184i;

    /* renamed from: j */
    private int f30185j;

    /* renamed from: k */
    private int f30186k;

    /* renamed from: l */
    private long f30187l;

    /* renamed from: m */
    private boolean f30188m;

    /* renamed from: n */
    private int f30189n;

    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* renamed from: a */
        private String f30190a;

        /* renamed from: b */
        private String f30191b;

        /* renamed from: c */
        private String f30192c;

        /* renamed from: d */
        private String f30193d;

        /* renamed from: e */
        private String f30194e;

        /* renamed from: f */
        private Long f30195f;

        public PackagePriorityInfo(String str, String str2, String str3, String str4, String str5, long j10) {
            this.f30190a = str;
            this.f30191b = str2;
            this.f30192c = str3;
            this.f30193d = str4;
            this.f30194e = str5;
            this.f30195f = Long.valueOf(j10);
        }

        @Override // java.lang.Comparable
        public int compareTo(PackagePriorityInfo packagePriorityInfo) {
            return TextUtils.equals(this.f30194e, packagePriorityInfo.f30194e) ? this.f30195f.compareTo(packagePriorityInfo.f30195f) : this.f30194e.compareTo(packagePriorityInfo.f30194e);
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSPackageManager$a */
    public class C6522a implements Comparator<ResolveInfo> {
        public C6522a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            String str = resolveInfo.serviceInfo.applicationInfo.packageName;
            String str2 = resolveInfo2.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.f30175s.containsKey(str) && HMSPackageManager.f30175s.containsKey(str2)) {
                return str.compareTo(str2);
            }
            if (HMSPackageManager.f30175s.containsKey(str)) {
                return -1;
            }
            return HMSPackageManager.f30175s.containsKey(str2) ? 1 : 0;
        }
    }

    /* renamed from: com.huawei.hms.utils.HMSPackageManager$b */
    public class RunnableC6523b implements Runnable {
        public RunnableC6523b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m36988i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            try {
                List<ResolveInfo> listQueryIntentServices = HMSPackageManager.this.f30176a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
                if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                    HMSLog.m36989w("HMSPackageManager", "resolveInfoList is empty.");
                    return;
                }
                Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                while (it.hasNext()) {
                    if ("com.huawei.hwid".equals(it.next().serviceInfo.applicationInfo.packageName)) {
                        HMSPackageManager.this.m37033d();
                    }
                }
                HMSLog.m36988i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            } catch (Exception e10) {
                HMSLog.m36986e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e10.getMessage());
            }
        }
    }

    static {
        HashMap map = new HashMap();
        f30175s = map;
        map.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        map.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private HMSPackageManager(Context context) {
        this.f30176a = context;
        this.f30177b = new PackageManagerHelper(context);
    }

    /* renamed from: c */
    private boolean m37032c(String str, String str2) {
        return Objects.equals(str2, this.f30177b.getPackageSigningCertificate(str)) || Objects.equals(str2, this.f30177b.getPackageSignature(str));
    }

    /* renamed from: d */
    private Pair<String, String> m37034d(String str, String str2) {
        if (!f30175s.containsKey(str) || !PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(str2)) {
            return null;
        }
        this.f30189n = 3;
        return new Pair<>(str, str2);
    }

    /* renamed from: e */
    private void m37037e(String str) {
        if (SystemUtils.isHuawei() || SystemUtils.isSystemApp(this.f30176a, str) || m37028b(str)) {
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        }
    }

    /* renamed from: f */
    private void m37038f() {
        synchronized (f30173q) {
            this.f30178c = null;
            this.f30179d = null;
            this.f30180e = 0;
        }
    }

    /* renamed from: g */
    private String m37039g() {
        String str;
        HMSLog.m36988i("HMSPackageManager", "Enter getAvailableHMSPackageNameForMultiService.");
        String str2 = this.f30181f;
        if (str2 != null) {
            m37030c(str2);
            if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f30177b.getPackageStates(this.f30181f)) && (str = this.f30181f) != null) {
                return str;
            }
        }
        HMSLog.m36988i("HMSPackageManager", " return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public static HMSPackageManager getInstance(Context context) {
        synchronized (f30172p) {
            try {
                if (f30171o == null && context != null) {
                    if (context.getApplicationContext() != null) {
                        f30171o = new HMSPackageManager(context.getApplicationContext());
                    } else {
                        f30171o = new HMSPackageManager(context);
                    }
                    f30171o.m37044l();
                    f30171o.m37027b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f30171o;
    }

    /* renamed from: h */
    private Pair<String, String> m37040h() {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f30176a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.size() == 0) {
                HMSLog.m36986e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
                return null;
            }
            m37022a(listQueryIntentServices);
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                String packageSigningCertificate = this.f30177b.getPackageSigningCertificate(str);
                String packageSignature = this.f30177b.getPackageSignature(str);
                Pair<String, String> pairM37034d = m37034d(str, packageSigningCertificate);
                if (pairM37034d != null) {
                    HMSLog.m36988i("HMSPackageManager", "signature V3 check success");
                    return pairM37034d;
                }
                Pair<String, String> pairM37016a = m37016a(resolveInfo.serviceInfo.metaData, str, packageSigningCertificate, packageSignature);
                if (pairM37016a != null) {
                    HMSLog.m36988i("HMSPackageManager", "DSS signature check success");
                    return pairM37016a;
                }
                Pair<String, String> pairM37017a = m37017a(str, packageSignature);
                if (pairM37017a != null) {
                    HMSLog.m36988i("HMSPackageManager", "signature V2 check success");
                    return pairM37017a;
                }
            }
            return null;
        } catch (Exception e10) {
            HMSLog.m36986e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: i */
    private Pair<String, String> m37041i() {
        Pair<String, String> pairM37040h = m37040h();
        if (pairM37040h != null) {
            HMSLog.m36988i("HMSPackageManager", "aidlService pkgName: " + ((String) pairM37040h.first));
            this.f30183h = "com.huawei.hms.core.aidlservice";
            this.f30184i = null;
            return pairM37040h;
        }
        ArrayList<PackagePriorityInfo> arrayListM37042j = m37042j();
        if (arrayListM37042j == null) {
            HMSLog.m36986e("HMSPackageManager", "PackagePriorityInfo list is null");
            return null;
        }
        Iterator<PackagePriorityInfo> it = arrayListM37042j.iterator();
        while (it.hasNext()) {
            PackagePriorityInfo next = it.next();
            String str = next.f30190a;
            String str2 = next.f30191b;
            String str3 = next.f30192c;
            String str4 = next.f30193d;
            String packageSignature = this.f30177b.getPackageSignature(str);
            if (m37024a(str + "&" + packageSignature + "&" + str2, str3, str4)) {
                HMSLog.m36988i("HMSPackageManager", "result: " + str + ", " + str2 + ", " + next.f30195f);
                this.f30183h = PackageConstants.GENERAL_SERVICES_ACTION;
                m37035d(str2);
                return new Pair<>(str, packageSignature);
            }
        }
        return null;
    }

    /* renamed from: j */
    private ArrayList<PackagePriorityInfo> m37042j() {
        try {
            List<ResolveInfo> listQueryIntentServices = this.f30176a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);
            if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                HMSLog.m36986e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
                return null;
            }
            ArrayList<PackagePriorityInfo> arrayList = new ArrayList<>();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.applicationInfo.packageName;
                long packageFirstInstallTime = this.f30177b.getPackageFirstInstallTime(str);
                Bundle bundle = resolveInfo.serviceInfo.metaData;
                if (bundle == null) {
                    HMSLog.m36986e("HMSPackageManager", "package " + str + " get metaData is null");
                } else {
                    String strM37019a = m37019a(bundle, "hms_app_checker_config");
                    String strM37020a = m37020a(strM37019a);
                    if (TextUtils.isEmpty(strM37020a)) {
                        HMSLog.m36988i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + strM37019a);
                    } else {
                        String strM37019a2 = m37019a(bundle, "hms_app_signer_v2");
                        if (TextUtils.isEmpty(strM37019a2)) {
                            HMSLog.m36988i("HMSPackageManager", "get signerV2 fail.");
                        } else {
                            String strM37019a3 = m37019a(bundle, "hms_app_cert_chain");
                            if (TextUtils.isEmpty(strM37019a3)) {
                                HMSLog.m36988i("HMSPackageManager", "get certChain fail.");
                            } else {
                                HMSLog.m36988i("HMSPackageManager", "add: " + str + ", " + strM37019a + ", " + packageFirstInstallTime);
                                arrayList.add(new PackagePriorityInfo(str, strM37019a, strM37019a2, strM37019a3, strM37020a, packageFirstInstallTime));
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e10) {
            HMSLog.m36986e("HMSPackageManager", "query aglite action failed. " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    private void m37043k() {
        synchronized (f30173q) {
            try {
                Pair<String, String> pairM37040h = m37040h();
                if (pairM37040h == null) {
                    HMSLog.m36986e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");
                    m37038f();
                    return;
                }
                String str = (String) pairM37040h.first;
                this.f30178c = str;
                this.f30179d = (String) pairM37040h.second;
                this.f30180e = this.f30177b.getPackageVersionCode(str);
                HMSLog.m36988i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f30178c + " version: " + this.f30180e);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    private void m37044l() {
        synchronized (f30173q) {
            try {
                Pair<String, String> pairM37041i = m37041i();
                if (pairM37041i == null) {
                    HMSLog.m36986e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");
                    m37036e();
                    AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                    return;
                }
                this.f30181f = (String) pairM37041i.first;
                this.f30182g = (String) pairM37041i.second;
                this.f30185j = this.f30177b.getPackageVersionCode(m37039g());
                m37037e(this.f30181f);
                HMSLog.m36988i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f30181f + " version: " + this.f30185j);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    private boolean m37045m() {
        Bundle bundle;
        PackageManager packageManager = this.f30176a.getPackageManager();
        if (packageManager == null) {
            HMSLog.m36986e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
            return true;
        }
        try {
        } catch (AndroidException unused) {
            HMSLog.m36986e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
        } catch (RuntimeException e10) {
            HMSLog.m36987e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e10);
        }
        if (TextUtils.isEmpty(this.f30183h) || (!this.f30183h.equals(PackageConstants.GENERAL_SERVICES_ACTION) && !this.f30183h.equals(PackageConstants.INTERNAL_SERVICES_ACTION))) {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(getHMSPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("com.huawei.hms.kit.api_level:hmscore") && (getHmsVersionCode() >= 50000000 || getHmsVersionCode() <= 19999999)) {
                HMSLog.m36988i("HMSPackageManager", "MinApkVersion is disabled.");
                return false;
            }
            return true;
        }
        HMSLog.m36988i("HMSPackageManager", "action = " + this.f30183h + " exist");
        return false;
    }

    public String getHMSFingerprint() {
        String str = this.f30179d;
        return str == null ? "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05" : str;
    }

    public String getHMSPackageName() {
        HMSLog.m36988i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String str = this.f30178c;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f30177b.getPackageStates(str))) {
                HMSLog.m36988i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                m37043k();
            }
            String str2 = this.f30178c;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.m36988i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.m36988i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String str = this.f30181f;
        if (str != null) {
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(this.f30177b.getPackageStates(str))) {
                HMSLog.m36988i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
                m37044l();
            }
            String str2 = this.f30181f;
            if (str2 != null) {
                return str2;
            }
        }
        HMSLog.m36988i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        synchronized (f30172p) {
            try {
                refresh();
                PackageManagerHelper.PackageStates packageStates = this.f30177b.getPackageStates(this.f30178c);
                PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
                if (packageStates == packageStates2) {
                    m37038f();
                    return packageStates2;
                }
                if ("com.huawei.hwid".equals(this.f30178c) && m37033d() == 1) {
                    return PackageManagerHelper.PackageStates.SPOOF;
                }
                return (packageStates != PackageManagerHelper.PackageStates.ENABLED || m37032c(this.f30178c, this.f30179d)) ? packageStates : packageStates2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        synchronized (f30172p) {
            try {
                refreshForMultiService();
                PackageManagerHelper.PackageStates packageStates = this.f30177b.getPackageStates(this.f30181f);
                PackageManagerHelper.PackageStates packageStates2 = PackageManagerHelper.PackageStates.NOT_INSTALLED;
                if (packageStates == packageStates2) {
                    m37036e();
                    return packageStates2;
                }
                if ("com.huawei.hwid".equals(this.f30181f) && m37033d() == 1) {
                    return PackageManagerHelper.PackageStates.SPOOF;
                }
                return (packageStates != PackageManagerHelper.PackageStates.ENABLED || m37032c(this.f30181f, this.f30182g)) ? packageStates : packageStates2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int getHmsMultiServiceVersion() {
        return this.f30177b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f30177b.getPackageVersionCode(getHMSPackageName());
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    public String getServiceAction() {
        return !TextUtils.isEmpty(this.f30183h) ? this.f30183h : "com.huawei.hms.core.aidlservice";
    }

    public boolean hmsVerHigherThan(int i10) {
        if (this.f30180e >= i10 || !m37045m()) {
            return true;
        }
        int packageVersionCode = this.f30177b.getPackageVersionCode(getHMSPackageName());
        this.f30180e = packageVersionCode;
        return packageVersionCode >= i10;
    }

    public boolean isApkNeedUpdate(int i10) {
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m36988i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", target version requirements: " + i10);
        return hmsVersionCode < i10;
    }

    public boolean isApkUpdateNecessary(int i10) {
        if (isUpdateHmsForThirdPartyDevice()) {
            return true;
        }
        int hmsVersionCode = getHmsVersionCode();
        HMSLog.m36988i("HMSPackageManager", "current versionCode:" + hmsVersionCode + ", minimum version requirements: " + i10);
        return m37045m() && hmsVersionCode < i10;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        return "com.huawei.hwid".equals(this.f30181f) && AgHmsUpdateState.getInstance().isUpdateHms();
    }

    public boolean isUseOldCertificate() {
        return this.f30188m;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f30178c) || TextUtils.isEmpty(this.f30179d)) {
            m37043k();
        }
        m37030c(this.f30178c);
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f30181f) || TextUtils.isEmpty(this.f30182g)) {
            m37044l();
        }
        m37030c(this.f30181f);
    }

    public void resetMultiServiceState() {
        m37036e();
    }

    public void setUseOldCertificate(boolean z10) {
        this.f30188m = z10;
    }

    /* renamed from: b */
    private boolean m37028b(String str) {
        return !"com.huawei.hwid".equals(str) || this.f30189n == 3;
    }

    /* renamed from: a */
    private void m37022a(List<ResolveInfo> list) {
        if (list.size() <= 1) {
            return;
        }
        Collections.sort(list, new C6522a());
    }

    /* renamed from: b */
    private boolean m37029b(String str, String str2) {
        Map<String, String> map = f30175s;
        return map.containsKey(str) && map.get(str).equalsIgnoreCase(str2);
    }

    /* renamed from: c */
    private void m37030c(String str) {
        if ("com.huawei.hwid".equals(str) && AgHmsUpdateState.getInstance().isUpdateHms() && this.f30177b.getPackageVersionCode(str) >= AgHmsUpdateState.getInstance().getTargetVersionCode()) {
            AgHmsUpdateState.getInstance().resetUpdateState();
            HMSLog.m36988i("HMSPackageManager", "refresh update state for HMS V3");
        }
    }

    /* renamed from: a */
    private Pair<String, String> m37016a(Bundle bundle, String str, String str2, String str3) {
        String str4;
        if (bundle == null) {
            HMSLog.m36986e("HMSPackageManager", "DSS check: " + str + " for metadata is null");
            return null;
        }
        this.f30189n = 2;
        if (m37023a(bundle, str, str2)) {
            HMSLog.m36988i("HMSPackageManager", "support DSS V3 check");
            str3 = str2;
            str4 = "hms_app_signer_v3";
        } else {
            str4 = "hms_app_signer";
        }
        if (!bundle.containsKey(str4)) {
            HMSLog.m36986e("HMSPackageManager", "skip package " + str + " for no " + str4);
            return null;
        }
        if (!bundle.containsKey("hms_app_cert_chain")) {
            HMSLog.m36986e("HMSPackageManager", "skip package " + str + " for no cert chain");
            return null;
        }
        if (!m37024a(str + "&" + str3, bundle.getString(str4), bundle.getString("hms_app_cert_chain"))) {
            HMSLog.m36986e("HMSPackageManager", "checkSigner failed");
            return null;
        }
        if (str4.equals("hms_app_signer_v3")) {
            this.f30189n = 3;
        }
        return new Pair<>(str, str3);
    }

    /* renamed from: b */
    private void m37027b() {
        new Thread(new RunnableC6523b(), "Thread-asyncOnceCheckMDMState").start();
    }

    /* renamed from: d */
    private void m37035d(String str) {
        String strM37020a = m37020a(str);
        if (TextUtils.isEmpty(strM37020a)) {
            return;
        }
        this.f30184i = strM37020a.substring(9);
    }

    /* renamed from: e */
    private void m37036e() {
        synchronized (f30173q) {
            this.f30181f = null;
            this.f30182g = null;
            this.f30183h = null;
            this.f30184i = null;
            this.f30185j = 0;
        }
    }

    /* renamed from: d */
    public int m37033d() {
        synchronized (f30174r) {
            try {
                HMSLog.m36988i("HMSPackageManager", "enter checkHmsIsSpoof");
                long packageFirstInstallTime = this.f30177b.getPackageFirstInstallTime("com.huawei.hwid");
                if (this.f30186k != 3 && this.f30187l == packageFirstInstallTime) {
                    HMSLog.m36988i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + m37018a(this.f30186k));
                    return this.f30186k;
                }
                this.f30186k = m37031c() ? 2 : 1;
                this.f30187l = this.f30177b.getPackageFirstInstallTime("com.huawei.hwid");
                HMSLog.m36988i("HMSPackageManager", "quit checkHmsIsSpoof state: " + m37018a(this.f30186k));
                return this.f30186k;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    private boolean m37031c() {
        String hmsPath = ReadApkFileUtil.getHmsPath(this.f30176a);
        if (hmsPath == null) {
            HMSLog.m36988i("HMSPackageManager", "hmsPath is null!");
            return false;
        }
        if (!ReadApkFileUtil.isCertFound(hmsPath)) {
            HMSLog.m36988i("HMSPackageManager", "NO huawer.cer in HMS!");
            return false;
        }
        if (!ReadApkFileUtil.checkSignature()) {
            HMSLog.m36988i("HMSPackageManager", "checkSignature fail!");
            return false;
        }
        if (ReadApkFileUtil.verifyApkHash(hmsPath)) {
            return true;
        }
        HMSLog.m36988i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    }

    /* renamed from: a */
    private Pair<String, String> m37017a(String str, String str2) {
        if (m37029b(str, str2)) {
            return new Pair<>(str, str2);
        }
        HMSLog.m36989w("HMSPackageManager", "check sign fail: " + str + "_" + str2);
        return null;
    }

    /* renamed from: a */
    private boolean m37023a(Bundle bundle, String str, String str2) {
        return bundle.containsKey("hms_app_signer_v3") && !m37029b(str, str2);
    }

    /* renamed from: a */
    private String m37019a(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            HMSLog.m36986e("HMSPackageManager", "no " + str + " in metaData");
            return null;
        }
        return bundle.getString(str);
    }

    /* renamed from: a */
    private String m37020a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("priority=");
        if (iIndexOf == -1) {
            HMSLog.m36986e("HMSPackageManager", "get indexOfIdentifier -1");
            return null;
        }
        int iIndexOf2 = str.indexOf(",", iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    /* renamed from: a */
    private boolean m37024a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            List<X509Certificate> listM30785b = C5165a.m30785b(str3);
            if (listM30785b.size() == 0) {
                HMSLog.m36986e("HMSPackageManager", "certChain is empty");
                return false;
            }
            if (!C5165a.m30782a(C5165a.m30776a(this.f30176a), listM30785b)) {
                HMSLog.m36986e("HMSPackageManager", "failed to verify cert chain");
                return false;
            }
            if (!m37025a(listM30785b, Arrays.asList("Huawei CBG Application Integration CA", "Huawei CBG HMS"), Arrays.asList("Huawei CBG", "Huawei CBG Cloud Security Signer"))) {
                HMSLog.m36988i("HMSPackageManager", "failed to verify cert chain.");
                return false;
            }
            if (C5165a.m30781a(listM30785b.get(listM30785b.size() - 1), str, str2)) {
                return true;
            }
            HMSLog.m36986e("HMSPackageManager", "signature is invalid: " + str);
            return false;
        }
        HMSLog.m36986e("HMSPackageManager", "args is invalid");
        return false;
    }

    /* renamed from: a */
    private boolean m37025a(List<X509Certificate> list, List<String> list2, List<String> list3) {
        if (list != null && list2 != null && list3 != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                X509Certificate x509Certificate = list.get(size);
                if (size >= list2.size()) {
                    HMSLog.m36986e("HMSPackageManager", "CN is invalid, Array length mismatch.");
                    return false;
                }
                if (!C5165a.m30780a(x509Certificate, list2.get(size))) {
                    HMSLog.m36986e("HMSPackageManager", "CN is invalid");
                    return false;
                }
                if (size >= list3.size()) {
                    HMSLog.m36986e("HMSPackageManager", "OU is invalid, Array length mismatch.");
                    return false;
                }
                if (!C5165a.m30787b(x509Certificate, list3.get(size))) {
                    HMSLog.m36986e("HMSPackageManager", "OU is invalid");
                    return false;
                }
            }
            return true;
        }
        HMSLog.m36986e("HMSPackageManager", "checkSubjects, params is null.");
        return false;
    }

    /* renamed from: a */
    private static String m37018a(int i10) {
        if (i10 == 1) {
            return "SPOOFED";
        }
        if (i10 == 2) {
            return "SUCCESS";
        }
        if (i10 == 3) {
            return "UNCHECKED";
        }
        HMSLog.m36986e("HMSPackageManager", "invalid checkMDM state: " + i10);
        return "";
    }
}
