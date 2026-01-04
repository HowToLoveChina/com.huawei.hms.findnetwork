package p617rl;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.text.TextUtils;
import cn.C1461a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupDuration;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupDurationInfo;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchList;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchListApp;
import com.huawei.android.hicloud.cloudbackup.bean.AppBackupSwitchRecommendConfig;
import com.huawei.android.hicloud.cloudbackup.bean.BackupConfig;
import com.huawei.android.hicloud.cloudbackup.bean.BackupMemberPrivilege;
import com.huawei.android.hicloud.cloudbackup.bean.BackupTimeWindowBean;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupConfig;
import com.huawei.android.hicloud.cloudbackup.bean.Next2hmosMappingItem;
import com.huawei.android.hicloud.cloudbackup.bean.OverdueBackupRecordsPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishValidPeriod;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreConfig;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreRetry;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.bean.SCompressionPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.ServerRetryPolicy;
import com.huawei.android.hicloud.cloudbackup.bean.SplitAppSetting;
import com.huawei.android.hicloud.cloudbackup.bean.ThermalControl;
import com.huawei.android.hicloud.cloudbackup.bean.ThermalControlGroup;
import com.huawei.android.hicloud.cloudbackup.bean.TwinAppControl;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Settings;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.hicloud.bean.TempBackupPolicy;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.BackupOptionSize;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.OMFilterModule;
import com.huawei.hicloud.cloudbackup.p104v3.omconfig.model.SyncAppBackupPolicy;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import ml.AbstractC11478a;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p361i8.C10452a;
import p361i8.C10453b;
import p371ik.C10527a;
import p514o9.C11839m;
import p572qb.C12299b;
import p618rm.C12540b1;
import p618rm.C12590s0;
import p682ul.C13216j;
import p709vj.C13452e;
import p744wl.C13619c;
import p815ym.AbstractC14026a;

/* renamed from: rl.j */
/* loaded from: classes6.dex */
public class C12526j extends AbstractC11478a<C12527k> {

    /* renamed from: b */
    public static List<Next2hmosMappingItem> f57844b = new ArrayList();

    /* renamed from: a */
    public BackupMemberPrivilege f57845a;

    /* renamed from: rl.j$a */
    public class a extends TypeToken<List<ServerRetryPolicy>> {
        public a() {
        }
    }

    /* renamed from: rl.j$b */
    public static class b extends TypeToken<List<AppBackupSwitchList>> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$c */
    public static class c extends TypeToken<List<OMFilterModule>> {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$d */
    public static class d extends TypeToken<List<SCompressionPolicy>> {
        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$e */
    public static class e extends TypeToken<List<Next2hmosMappingItem>> {
        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$f */
    public static class f extends TypeToken<List<BackupOptionSize>> {
        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$g */
    public static class g extends TypeToken<List<SplitAppSetting>> {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$h */
    public static class h extends TypeToken<List<String>> {
        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* renamed from: rl.j$i */
    public static class i extends TypeToken<List<SyncAppBackupPolicy>> {
        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public C12526j() {
        super(C13216j.m79427l(C13216j.c.SETTING, null));
    }

    /* renamed from: e1 */
    public static boolean m75322e1(String str) throws PackageManager.NameNotFoundException {
        boolean z10;
        C11839m.m70688i("CloudBackupConfigOperator", "enter isSupportRecovery appName: " + str);
        try {
            ApplicationInfo applicationInfo = C0213f.m1377a().getPackageManager().getApplicationInfo(str, 128);
            if (C13619c.m81950f(str)) {
                int i10 = applicationInfo.metaData.getInt(NextRestoreConstants.KEY_META_DATA_SUPPORT_NEXT2HMOS);
                z10 = true;
                if (i10 <= 1) {
                    z10 = false;
                }
                C11839m.m70688i("CloudBackupConfigOperator", "enter isSupportRecovery gallery is: " + z10);
            } else {
                z10 = applicationInfo.metaData.getBoolean(NextRestoreConstants.KEY_META_DATA_SUPPORT_NEXT2HMOS);
            }
            C11839m.m70688i("CloudBackupConfigOperator", "isSupportRecovery: " + z10);
            return z10;
        } catch (Exception unused) {
            C11839m.m70687e("CloudBackupConfigOperator", "isSupportRecovery: getApplicationInfo failed");
            return false;
        }
    }

    /* renamed from: g1 */
    public static /* synthetic */ boolean m75323g1(String str, ServerRetryPolicy serverRetryPolicy) {
        return TextUtils.equals(serverRetryPolicy.getRequestCmd(), str);
    }

    /* renamed from: A */
    public long m75324A() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("cacheDuration");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 172800000L;
        }
        return iM1685c * 86400000;
    }

    /* renamed from: A0 */
    public RestoreRetry m75325A0() {
        RestoreRetry restoreRetry;
        try {
            restoreRetry = (RestoreRetry) new Gson().fromJson(m75327B0(), RestoreRetry.class);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getRestoreRetry error: " + e10.toString());
            restoreRetry = null;
        }
        if (restoreRetry != null) {
            return restoreRetry;
        }
        RestoreRetry restoreRetry2 = new RestoreRetry();
        C11839m.m70689w("CloudBackupConfigOperator", "getRestoreRetry restoreRetry is null");
        return restoreRetry2;
    }

    /* renamed from: B */
    public long m75326B() {
        C12527k c12527kM75407n = m75407n("cacheMin");
        if (c12527kM75407n == null) {
            return -1L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
        C11839m.m70688i("CloudBackupConfigOperator", "getCacheMinSize " + jM1688f);
        if (jM1688f > 0) {
            return jM1688f * 1048576;
        }
        return -1L;
    }

    /* renamed from: B0 */
    public String m75327B0() {
        C12527k c12527kM75407n = m75407n("restoreRetry");
        if (c12527kM75407n == null) {
            return "";
        }
        String strM75434b = c12527kM75407n.m75434b();
        C11839m.m70688i("CloudBackupConfigOperator", "getRestoreRetryJson " + strM75434b);
        return strM75434b;
    }

    /* renamed from: C */
    public double m75328C() {
        C12527k c12527kM75407n = m75407n("cacheRatio");
        if (c12527kM75407n == null) {
            return -1.0d;
        }
        double dDoubleValue = C0241z.m1683a(c12527kM75407n.m75434b(), Double.valueOf(0.0d)).doubleValue();
        C11839m.m70688i("CloudBackupConfigOperator", "getCacheRatio: " + dDoubleValue);
        if (dDoubleValue > 0.0d) {
            return dDoubleValue;
        }
        return -1.0d;
    }

    /* renamed from: C0 */
    public long m75329C0() {
        C12527k c12527kM75407n = m75407n("restoreRetryPeriod");
        if (c12527kM75407n == null) {
            return 172800000L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
        if (jM1688f > 0) {
            return jM1688f * C5863b6.g.f26453g;
        }
        return 172800000L;
    }

    /* renamed from: D */
    public long m75330D() {
        C12527k c12527kM75407n = m75407n("cacheUpper");
        if (c12527kM75407n == null) {
            return -1L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
        C11839m.m70688i("CloudBackupConfigOperator", "getCacheUpperSize: " + jM1688f);
        if (jM1688f > 0) {
            return jM1688f * Constants.ONE_GB_SIZE;
        }
        return -1L;
    }

    /* renamed from: D0 */
    public int m75331D0() {
        C12527k c12527kM75407n = m75407n("retryInterval");
        if (c12527kM75407n != null) {
            return C0241z.m1686d(c12527kM75407n.m75434b(), 30);
        }
        return 30;
    }

    /* renamed from: E */
    public int m75332E() {
        C12527k c12527kM75407n = m75407n("clientSizeCache");
        if (c12527kM75407n != null) {
            return C0241z.m1685c(c12527kM75407n.m75434b());
        }
        return 48;
    }

    /* renamed from: E0 */
    public int m75333E0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("sdcardAcptErrNum");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 20;
        }
        return iM1685c;
    }

    /* renamed from: F */
    public int m75334F() {
        C12527k c12527kM75407n = m75407n("closeSwitchDeleteTip");
        if (c12527kM75407n == null) {
            return 0;
        }
        int iM1685c = C0241z.m1685c(c12527kM75407n.m75434b());
        C11839m.m70688i("CloudBackupConfigOperator", "getCloseSwitchDeleteTip " + iM1685c);
        return iM1685c;
    }

    /* renamed from: F0 */
    public int m75335F0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("sdcardAcptErrRate");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 5;
        }
        return iM1685c;
    }

    /* renamed from: G */
    public long m75336G() {
        if (m75407n("cloudBackupCloneTimeoutDuration") != null) {
            return C0241z.m1686d(r4.m75434b(), 15) * 60000;
        }
        return 900000L;
    }

    /* renamed from: G0 */
    public long m75337G0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("sdcardCacheDuration");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 129600000L;
        }
        return iM1685c * C5863b6.g.f26453g;
    }

    /* renamed from: H */
    public long m75338H(long j10) {
        boolean zM60720O = C9733f.m60705z().m60720O("enableCloudBackupDelayStopOnScreen");
        C11839m.m70688i("CloudBackupConfigOperator", "getCloudBackupDelayStopOnScreenTime enableCloudBackupDelayStopOnScreen " + zM60720O);
        if (!zM60720O) {
            return j10;
        }
        C12527k c12527kM75407n = m75407n("cloudBackupDelayStopOnScreen");
        if (c12527kM75407n == null) {
            return 300000L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b()) * 1000;
        if (jM1688f < 0) {
            return 300000L;
        }
        C11839m.m70688i("CloudBackupConfigOperator", "getCloudBackupDelayStopOnScreenTime cloudBackupDelayStopOnScreen " + jM1688f);
        return jM1688f;
    }

    /* renamed from: H0 */
    public boolean m75339H0() {
        C12527k c12527kM75407n = m75407n("sdcardFileIgnore");
        return c12527kM75407n != null && 1 == C0241z.m1685c(c12527kM75407n.m75434b());
    }

    /* renamed from: I */
    public int m75340I() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("cloudBackupFrequencyOnDeviceIdle");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) < 0) {
            return 0;
        }
        return iM1685c;
    }

    /* renamed from: I0 */
    public String m75341I0(String str) {
        C12527k c12527kM75407n = m75407n(str);
        return c12527kM75407n != null ? c12527kM75407n.m75434b() : "";
    }

    @Override // ml.AbstractC11478a
    /* renamed from: J */
    public String[] getColumns(C12527k c12527k) {
        return new String[0];
    }

    /* renamed from: J0 */
    public ServerRetryPolicy m75343J0(final String str) {
        ServerRetryPolicy serverRetryPolicy = null;
        try {
            String strM75341I0 = m75341I0("retryPolicy");
            if (TextUtils.isEmpty(strM75341I0)) {
                C11839m.m70689w("CloudBackupConfigOperator", "getServerRetryPolicy jsonConfig is empty");
            } else {
                List list = (List) new Gson().fromJson(strM75341I0, new a().getType());
                if (AbstractC14026a.m84159a(list)) {
                    C11839m.m70689w("CloudBackupConfigOperator", "getServerRetryPolicy policyList is empty");
                } else {
                    serverRetryPolicy = (ServerRetryPolicy) list.stream().filter(new Predicate() { // from class: rl.h
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return C12526j.m75323g1(str, (ServerRetryPolicy) obj);
                        }
                    }).findFirst().orElse(null);
                }
            }
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getServerRetryPolicy error: " + e10.getMessage());
        }
        if (serverRetryPolicy == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "getServerRetryPolicy default");
            return new ServerRetryPolicy();
        }
        C11839m.m70688i("CloudBackupConfigOperator", "getServerRetryPolicy " + serverRetryPolicy);
        return serverRetryPolicy;
    }

    /* renamed from: K */
    public List<SCompressionPolicy> m75344K() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("compressionPolicy");
        if (c12527kM75407n == null || TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            C11839m.m70688i("CloudBackupConfigOperator", "getCompressionPolicy omConfig null, use default");
        } else {
            try {
                List list = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new d(null).getType());
                if (list != null) {
                    arrayList.addAll(list);
                }
            } catch (Exception e10) {
                C11839m.m70689w("CloudBackupConfigOperator", "getInterimBackupDefaultVirtualApps e" + e10.getMessage());
            }
        }
        return arrayList;
    }

    /* renamed from: K0 */
    public Map<String, Boolean> m75345K0() {
        final HashMap map = new HashMap();
        if (!C9733f.m60705z().m60720O("cloudBackupSwitchDeleteSnapshotHealth")) {
            C11839m.m70686d("CloudBackupConfigOperator", "isDoHealthCheck false");
            return map;
        }
        try {
            Arrays.asList("cloudBackupInvalidRecordCorruption", "cloudBackupInvalidRecordSnapEmpty", "cloudBackupInvalidRecordNoAttach", "cloudBackupSuccessRecordCorruption", "cloudBackupSuccessRecordSnapEmpty", "cloudBackupSuccessRecordNoAttach", "cloudBackupingRecordSnapEmpty").forEach(new Consumer() { // from class: rl.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f57842a.m75395h1(map, (String) obj);
                }
            });
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getAppBackupDurationConfig error: " + e10.getMessage());
        }
        return map;
    }

    /* renamed from: L */
    public <T> T m75346L(Class<T> cls, String str) {
        try {
            return (T) new Gson().fromJson(m75348M(str), (Class) cls);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getConfig error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: L0 */
    public long m75347L0() {
        C12527k c12527kM75407n = m75407n("cloudSpaceThreshold");
        if (c12527kM75407n != null) {
            return C0241z.m1688f(c12527kM75407n.m75434b());
        }
        return -1L;
    }

    /* renamed from: M */
    public String m75348M(String str) {
        C12527k c12527kM75407n = m75407n(str);
        if (c12527kM75407n == null) {
            return "";
        }
        String strM75434b = c12527kM75407n.m75434b();
        C11839m.m70688i("CloudBackupConfigOperator", "get " + str + ":" + strM75434b);
        return strM75434b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.List] */
    /* renamed from: M0 */
    public List<SplitAppSetting> m75349M0() {
        ArrayList arrayList = new ArrayList();
        try {
            String strM75341I0 = m75341I0("splitAppProcessControl");
            if (TextUtils.isEmpty(strM75341I0)) {
                C11839m.m70689w("CloudBackupConfigOperator", "getSplitAppProcessControl jsonConfig is empty");
            } else {
                arrayList = (List) new Gson().fromJson(strM75341I0, new g(null).getType());
            }
        } catch (Throwable th2) {
            C11839m.m70689w("CloudBackupConfigOperator", "getSplitAppProcessControl error: " + th2.getMessage());
        }
        C11839m.m70688i("CloudBackupConfigOperator", "getSplitAppProcessControl " + arrayList);
        return arrayList;
    }

    /* renamed from: N */
    public int m75350N() {
        C12527k c12527kM75407n = m75407n("correctLastBackupEndTime");
        if (c12527kM75407n == null) {
            return 1;
        }
        return C0241z.m1685c(c12527kM75407n.m75434b());
    }

    /* renamed from: N0 */
    public String m75351N0(String str) {
        C12527k c12527kM75407n = m75407n(str);
        if (c12527kM75407n == null) {
            return "";
        }
        String strM75434b = c12527kM75407n.m75434b();
        C11839m.m70688i("CloudBackupConfigOperator", "getStringBykey： " + strM75434b);
        return strM75434b;
    }

    /* renamed from: O */
    public int m75352O() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("DBDiffMaxFileSize");
        return (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) ? RuleConfig.DEFAULT_DB_DIFF_MAX_FILE_SIZE : iM1685c;
    }

    /* renamed from: O0 */
    public boolean m75353O0() {
        C12527k c12527kM75407n = m75407n("switch3rdApp");
        if (c12527kM75407n == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "switch3rdApp omConfig is null");
            CloudBackupReport.reportOmError("switch3rdApp omConfig is null");
            return true;
        }
        String strM75434b = c12527kM75407n.m75434b();
        C11839m.m70688i("CloudBackupConfigOperator", "switch3rdApp value is: " + strM75434b);
        if (!"1".equals(strM75434b)) {
            CloudBackupReport.reportOmError("switch3rdApp is not ture, value is: " + strM75434b);
        }
        return !"0".equals(strM75434b);
    }

    /* renamed from: P */
    public int m75354P() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("dataAcptErrNum");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) < 0) {
            return 0;
        }
        return iM1685c;
    }

    /* renamed from: P0 */
    public Map<String, SyncAppBackupPolicy> m75355P0() {
        HashMap map = new HashMap();
        C12527k c12527kM75407n = m75407n("syncAppBackupPolicies");
        Gson gson = new Gson();
        if (c12527kM75407n != null) {
            List<SyncAppBackupPolicy> list = null;
            try {
                C11839m.m70688i("CloudBackupConfigOperator", "getSyncAppBackupPolicy  " + c12527kM75407n.m75434b());
                list = (List) gson.fromJson(c12527kM75407n.m75434b(), new i(null).getType());
            } catch (JsonSyntaxException unused) {
                C11839m.m70689w("CloudBackupConfigOperator", String.format(Locale.ENGLISH, "parse %s error, om passed wrong format value", c12527kM75407n.m75433a()));
            }
            if (list != null) {
                for (SyncAppBackupPolicy syncAppBackupPolicy : list) {
                    C11839m.m70688i("CloudBackupConfigOperator", "add policy " + syncAppBackupPolicy.getBackupAppName() + ", " + syncAppBackupPolicy.toString());
                    map.put(syncAppBackupPolicy.getBackupAppName(), syncAppBackupPolicy);
                }
            }
        }
        return map;
    }

    /* renamed from: Q */
    public int m75356Q() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("dataAcptErrRate");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) < 0) {
            return 0;
        }
        return iM1685c;
    }

    /* renamed from: Q0 */
    public double m75357Q0() {
        C12527k c12527kM75407n = m75407n("tarReferenceRate");
        if (c12527kM75407n != null) {
            double dDoubleValue = C0241z.m1683a(c12527kM75407n.m75434b(), Double.valueOf(0.2d)).doubleValue();
            C11839m.m70688i("CloudBackupConfigOperator", "getTarReferenceRate: " + dDoubleValue);
            if (dDoubleValue >= 0.0d) {
                return dDoubleValue;
            }
        }
        return 0.2d;
    }

    /* renamed from: R */
    public long m75358R() {
        if (m75407n("dataCacheDuration") != null) {
            return C0241z.m1686d(r4.m75434b(), 0) * C5863b6.g.f26453g;
        }
        return 0L;
    }

    /* renamed from: R0 */
    public long m75359R0() {
        C12527k c12527kM75407n = m75407n("tarThreshold");
        if (c12527kM75407n == null) {
            return 4000L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
        if (jM1688f > 0) {
            return jM1688f;
        }
        return 4000L;
    }

    /* renamed from: S */
    public List<String> m75360S() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("dataErrApp");
        if (c12527kM75407n == null) {
            return arrayList;
        }
        return (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new h(null).getType());
    }

    /* renamed from: S0 */
    public TempBackupPolicy m75361S0() {
        try {
            C12527k c12527kM75407n = m75407n("tempBackupPolicy");
            if (c12527kM75407n == null) {
                C1461a.m8360w("CloudBackupConfigOperator", "getTempBackupPolicy omConfig is null ; ");
                return null;
            }
            String strM75434b = c12527kM75407n.m75434b();
            if (TextUtils.isEmpty(strM75434b)) {
                C1461a.m8360w("CloudBackupConfigOperator", "getTempBackupPolicy omConfig value null ;");
                return null;
            }
            C1461a.m8357d("CloudBackupConfigOperator", "getTempBackupPolicy json : " + strM75434b);
            return (TempBackupPolicy) new Gson().fromJson(strM75434b, TempBackupPolicy.class);
        } catch (Exception e10) {
            C1461a.m8358e("CloudBackupConfigOperator", "getTempBackupPolicy err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: T */
    public int m75362T() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("DBIncrBack");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 100;
        }
        return iM1685c;
    }

    /* renamed from: T0 */
    public ThermalControl m75363T0() {
        try {
            return (ThermalControl) new Gson().fromJson(m75367V0(), ThermalControl.class);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getThermalControl error: " + e10.getMessage());
            return new ThermalControl();
        }
    }

    /* renamed from: U */
    public double m75364U() {
        C12527k c12527kM75407n = m75407n("DBSimilarity");
        if (c12527kM75407n == null) {
            return 0.6d;
        }
        double dDoubleValue = C0241z.m1683a(c12527kM75407n.m75434b(), Double.valueOf(0.0d)).doubleValue();
        if (dDoubleValue > 0.0d) {
            return dDoubleValue;
        }
        return 0.6d;
    }

    /* renamed from: U0 */
    public ThermalControlGroup m75365U0() {
        try {
            return (ThermalControlGroup) new Gson().fromJson(m75348M("thermalControlGroup"), ThermalControlGroup.class);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getThermalControlGroup error: " + e10.getMessage());
            return new ThermalControlGroup();
        }
    }

    /* renamed from: V */
    public final void m75366V(List<String> list) {
        try {
            list.addAll(new C12519c().m75297h(2));
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupConfigOperator", "getInterimBackupDefaultVirtualApps e" + e10.getMessage());
            list.add("doc1");
            list.add("safebox1");
        }
        list.add("music");
        list.add(HNConstants.DataType.MEDIA);
    }

    /* renamed from: V0 */
    public final String m75367V0() {
        C12527k c12527kM75407n = m75407n("thermalControl");
        if (c12527kM75407n == null) {
            return "";
        }
        String strM75434b = c12527kM75407n.m75434b();
        C11839m.m70688i("CloudBackupConfigOperator", "getThermalControl " + strM75434b);
        return strM75434b;
    }

    /* renamed from: W */
    public final C10453b m75368W() {
        C10452a c10452a = new C10452a();
        c10452a.m64258b(3000);
        C10453b c10453b = new C10453b();
        c10453b.m64260b(c10452a);
        return c10453b;
    }

    /* renamed from: W0 */
    public boolean m75369W0() {
        C12527k c12527kM75407n = m75407n("switch3rdDefault");
        if (c12527kM75407n != null) {
            return "1".equals(c12527kM75407n.m75434b());
        }
        return false;
    }

    /* renamed from: X */
    public int m75370X() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("DffPacketNum");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 10;
        }
        return iM1685c;
    }

    /* renamed from: X0 */
    public List<String> m75371X0() {
        ArrayList arrayList = new ArrayList();
        try {
            List<C12527k> listQuery = query("select name, value from cloud_backup_om_config where name = ?", new String[]{"threadsAdvancedDevice"});
            if (!listQuery.isEmpty()) {
                Iterator<C12527k> it = listQuery.iterator();
                if (it.hasNext()) {
                    return (List) new Gson().fromJson(it.next().m75434b(), new h(null).getType());
                }
            }
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getThreadsAdvancedDevice error." + e10.getMessage());
        }
        return arrayList;
    }

    /* renamed from: Y */
    public String m75372Y() {
        String strM75434b = "";
        try {
            List<C12527k> listQuery = query("select name, value from cloud_backup_om_config value where name = 'disperseRule';", null);
            if (!listQuery.isEmpty()) {
                Iterator<C12527k> it = listQuery.iterator();
                while (it.hasNext()) {
                    strM75434b = it.next().m75434b();
                    if (strM75434b != null) {
                        return strM75434b;
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getDisperseRule error." + e10.getMessage());
        }
        return strM75434b;
    }

    /* renamed from: Y0 */
    public long m75373Y0() {
        C12527k c12527kM75407n = m75407n("tinyThreshold");
        if (c12527kM75407n == null) {
            return 200L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
        if (jM1688f > 0) {
            return jM1688f;
        }
        return 200L;
    }

    /* renamed from: Z */
    public int m75374Z() {
        C12527k c12527kM75407n = m75407n("enableAppBackupSwitchRecommend");
        if (c12527kM75407n == null) {
            return 15;
        }
        return C0241z.m1685c(c12527kM75407n.m75434b());
    }

    /* renamed from: Z0 */
    public TwinAppControl m75375Z0() {
        C12527k c12527kM75407n = m75407n("twinAppControl");
        if (c12527kM75407n != null) {
            try {
                return (TwinAppControl) C12540b1.m75483a(c12527kM75407n.m75434b(), TwinAppControl.class);
            } catch (Exception e10) {
                C11839m.m70689w("CloudBackupConfigOperator", "TwinAppControl error: " + e10.toString());
            }
        }
        return null;
    }

    /* renamed from: a0 */
    public int m75376a0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("fileFinishRetryInterval");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 10;
        }
        return iM1685c;
    }

    /* renamed from: a1 */
    public int m75377a1() {
        return 4;
    }

    /* renamed from: b0 */
    public float m75378b0() {
        C12527k c12527kM75407n = m75407n("fileFinishRetryIntervalRate");
        if (c12527kM75407n != null) {
            float fM1684b = C0241z.m1684b(c12527kM75407n.m75434b());
            if (fM1684b > 0.0f) {
                return fM1684b;
            }
        }
        return 0.0f;
    }

    /* renamed from: b1 */
    public List<RestoreConfig> m75379b1(CloudBackupConfig cloudBackupConfig) throws C9721b {
        C11839m.m70686d("CloudBackupConfigOperator", "updateCloudBackupConfig");
        if (cloudBackupConfig == null) {
            C11839m.m70687e("CloudBackupConfigOperator", "updateCloudBackupConfig error: cloudBackupConfig is null");
            return new ArrayList();
        }
        BackupConfig cloudBackup = cloudBackupConfig.getCloudBackup();
        if (cloudBackup == null) {
            C11839m.m70689w("CloudBackupConfigOperator", "updateCloudBackupConfig error: backupConfig is null");
            return new ArrayList();
        }
        RuleConfig ruleConfig = cloudBackup.getRuleConfig();
        if (ruleConfig == null) {
            C11839m.m70689w("CloudBackupConfigOperator", "updateCloudBackupConfig error: ruleConfig is null");
            return new ArrayList();
        }
        new SettingOperator().replace(new Settings[]{new Settings("backupCycle", String.valueOf(ruleConfig.getBackupCycle()), "1")});
        ContentValues contentValues = new ContentValues();
        contentValues.put("retryInterval", String.valueOf(ruleConfig.getRetryInterval()));
        contentValues.put("timeAdvanced", String.valueOf(ruleConfig.getTimeAdvanced()));
        contentValues.put("checkInterval", String.valueOf(ruleConfig.getCheckInterval()));
        contentValues.put("checkIntervalMax", String.valueOf(ruleConfig.getCheckIntervalMax()));
        contentValues.put("defaultRedDot", String.valueOf(ruleConfig.getDefaultRedDot()));
        C12299b.m73937s(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("batteryChargeConnected", String.valueOf(ruleConfig.getBatteryChargeConnected()));
        C12299b.m73929k(contentValues2, "autoBackupBatteryCharge");
        C12299b.m73930l(new Gson().toJson(ruleConfig.getDisperseRule()));
        C12299b.m73936r(ruleConfig.getThermalControl());
        C12299b.m73935q(ruleConfig.getThermalControlGroup());
        C12299b.m73932n("restoreRetry", ruleConfig.getRestoreRetry());
        List<RestoreConfig> restoreConfig = cloudBackupConfig.getRestoreConfig();
        if (restoreConfig != null && !restoreConfig.isEmpty()) {
            return restoreConfig;
        }
        C11839m.m70687e("CloudBackupConfigOperator", "updateCloudBackupConfig error: restoreConfig is null or empty.");
        return new ArrayList();
    }

    /* renamed from: c */
    public boolean m75380c() {
        C12527k c12527kM75407n = m75407n("appFileIdSupportVfs");
        return c12527kM75407n != null && C0241z.m1686d(c12527kM75407n.m75434b(), 0) == 1;
    }

    /* renamed from: c0 */
    public int m75381c0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("fileFinishRetryTimes");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 3;
        }
        return iM1685c;
    }

    /* renamed from: c1 */
    public boolean m75382c1(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AppBackupSwitchListApp appBackupSwitchListApp = new AppBackupSwitchListApp();
        appBackupSwitchListApp.setPackageName(str);
        appBackupSwitchListApp.setType(i10);
        return m75417s().contains(appBackupSwitchListApp);
    }

    public void clear() {
        try {
            this.f57845a = null;
            execSQL("delete from cloud_backup_om_config");
        } catch (C9721b e10) {
            C11839m.m70687e("CloudBackupConfigOperator", "execSQL clear error: " + e10.toString());
        }
    }

    /* renamed from: d */
    public void m75383d() {
        C11839m.m70688i("CloudBackupConfigOperator", "clearConfigCache");
        f57844b.clear();
    }

    /* renamed from: d0 */
    public List<String> m75384d0() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("interimBackupDefaultApps");
        if (c12527kM75407n == null || TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            arrayList.add("com.tencent.mm");
            arrayList.add("com.tencent.mobileqq");
        } else {
            try {
                List list = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new h(null).getType());
                if (list != null) {
                    arrayList.addAll(list);
                }
            } catch (Exception e10) {
                C11839m.m70689w("CloudBackupConfigOperator", "getInterimBackupDefaultApps  e" + e10.getMessage());
                arrayList.add("com.tencent.mm");
                arrayList.add("com.tencent.mobileqq");
            }
        }
        return arrayList;
    }

    /* renamed from: d1 */
    public boolean m75385d1(String str) {
        boolean z10 = m75407n(str) != null;
        C11839m.m70688i("CloudBackupConfigOperator", str + " exist:" + z10);
        return z10;
    }

    /* renamed from: e */
    public List<String> m75386e() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("appBackupBlackList");
        Gson gson = new Gson();
        if (c12527kM75407n != null) {
            List list = null;
            try {
                list = (List) gson.fromJson(c12527kM75407n.m75434b(), new h(null).getType());
            } catch (JsonSyntaxException unused) {
                C11839m.m70689w("CloudBackupConfigOperator", String.format(Locale.ENGLISH, "parse %s error, om passed wrong format value", c12527kM75407n.m75433a()));
            }
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        arrayList.add("com.huawei.hicreate");
        return arrayList;
    }

    /* renamed from: e0 */
    public List<String> m75387e0() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("interimBackupDefaultVirtualApps");
        if (c12527kM75407n == null || TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            C11839m.m70688i("CloudBackupConfigOperator", "getInterimBackupDefaultVirtualApps omConfig null, use default");
            m75366V(arrayList);
        } else {
            try {
                List list = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new h(null).getType());
                if (list != null) {
                    arrayList.addAll(list);
                }
            } catch (Exception e10) {
                C11839m.m70689w("CloudBackupConfigOperator", "getInterimBackupDefaultVirtualApps e" + e10.getMessage());
                m75366V(arrayList);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public final AppBackupDuration m75388f() {
        AppBackupDurationInfo appBackupDurationInfo = new AppBackupDurationInfo();
        appBackupDurationInfo.setDataCacheDurationMillis(m75358R());
        appBackupDurationInfo.setSdcardCacheDurationMillis(m75337G0());
        appBackupDurationInfo.setModuleDataCacheDurationMillis(m75324A());
        AppBackupDurationInfo appBackupDurationInfo2 = new AppBackupDurationInfo();
        appBackupDurationInfo2.setDataCacheDurationMillis(m75358R());
        appBackupDurationInfo2.setSdcardCacheDurationMillis(m75337G0());
        appBackupDurationInfo2.setModuleDataCacheDurationMillis(m75401k());
        AppBackupDuration appBackupDuration = new AppBackupDuration();
        appBackupDuration.setAuto(appBackupDurationInfo2);
        appBackupDuration.setManual(appBackupDurationInfo);
        return appBackupDuration;
    }

    /* renamed from: f0 */
    public long m75389f0() {
        C12527k c12527kM75407n = m75407n("backupRestoreMaxTarCount");
        return c12527kM75407n != null ? C0241z.m1688f(c12527kM75407n.m75434b()) : RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT;
    }

    /* renamed from: f1 */
    public boolean m75390f1(int i10) {
        int iM75374Z = m75374Z();
        int i11 = i10 & iM75374Z;
        if (i11 == 1) {
            C11839m.m70688i("CloudBackupConfigOperator", "appBackupSwitchRecommend " + iM75374Z + " status " + i10 + " OPEN");
            return true;
        }
        if (i11 == 2) {
            C11839m.m70688i("CloudBackupConfigOperator", "appBackupSwitchRecommend " + iM75374Z + " status " + i10 + " USE");
            return true;
        }
        if (i11 == 4) {
            C11839m.m70688i("CloudBackupConfigOperator", "appBackupSwitchRecommend " + iM75374Z + " status " + i10 + " BOOT_SWITCH");
            return true;
        }
        if (i11 != 8) {
            C11839m.m70688i("CloudBackupConfigOperator", "appBackupSwitchRecommend " + iM75374Z + " status " + i10);
            return false;
        }
        C11839m.m70688i("CloudBackupConfigOperator", "appBackupSwitchRecommend " + iM75374Z + " status " + i10 + " NOTIFY_SWITCH");
        return true;
    }

    /* renamed from: g */
    public AppBackupDuration m75391g() {
        if (!C9733f.m60705z().m60712G()) {
            return m75388f();
        }
        try {
            C12527k c12527kM75407n = m75407n("appBackupDurationConfig");
            String strM75434b = "";
            if (c12527kM75407n != null) {
                strM75434b = c12527kM75407n.m75434b();
                C11839m.m70688i("CloudBackupConfigOperator", "getAppBackupDurationConfig " + strM75434b);
            }
            AppBackupDuration appBackupDuration = (AppBackupDuration) new Gson().fromJson(strM75434b, AppBackupDuration.class);
            if (appBackupDuration != null) {
                return appBackupDuration;
            }
            C11839m.m70689w("CloudBackupConfigOperator", "getAppBackupDurationConfig, json parse error, use default value.");
            return new AppBackupDuration();
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getAppBackupDurationConfig error: " + e10.toString());
            return new AppBackupDuration();
        }
    }

    /* renamed from: g0 */
    public int m75392g0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("mkfileBatchNum");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 20;
        }
        return iM1685c;
    }

    /* renamed from: h */
    public AppBackupSwitchRecommendConfig m75393h() {
        AppBackupSwitchRecommendConfig appBackupSwitchRecommendConfig = new AppBackupSwitchRecommendConfig();
        C12527k c12527kM75407n = m75407n("appBackupSwitchRecommendConfig");
        if (c12527kM75407n == null) {
            return appBackupSwitchRecommendConfig;
        }
        if (TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            C11839m.m70687e("CloudBackupConfigOperator", "getAppBackupSwitchRecommendConfig json is null");
            return appBackupSwitchRecommendConfig;
        }
        try {
            return (AppBackupSwitchRecommendConfig) C12540b1.m75483a(c12527kM75407n.m75434b(), AppBackupSwitchRecommendConfig.class);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getAppBackupSwitchRecommendConfig error: " + e10.toString());
            return appBackupSwitchRecommendConfig;
        }
    }

    /* renamed from: h0 */
    public boolean m75394h0() {
        C12527k c12527kM75407n = m75407n("mkfileLgrScrPwr");
        return c12527kM75407n != null && C0241z.m1686d(c12527kM75407n.m75434b(), 0) == 1;
    }

    /* renamed from: h1 */
    public final /* synthetic */ void m75395h1(Map map, String str) {
        C12527k c12527kM75407n = m75407n(str);
        if (c12527kM75407n != null) {
            map.put(c12527kM75407n.m75433a(), Boolean.valueOf("1".equals(c12527kM75407n.m75434b())));
            C11839m.m70686d("CloudBackupConfigOperator", "getSnapshotCheckFlags name:" + c12527kM75407n.m75433a() + " value: " + c12527kM75407n.m75434b());
        }
    }

    /* renamed from: i */
    public List<String> m75396i() {
        List list;
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("appDataBackupBlackList");
        if (c12527kM75407n != null && (list = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new h(null).getType())) != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    /* renamed from: i0 */
    public int m75397i0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("mkfileThreads");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 1;
        }
        return Math.min(iM1685c, 10);
    }

    /* renamed from: i1 */
    public void m75398i1(JSONObject jSONObject) throws C9721b {
        try {
            try {
                ArrayList arrayList = new ArrayList();
                if (jSONObject.isNull("switch3rdApp")) {
                    CloudBackupReport.reportOmError("cloudBackupConfigParams SWITCH_3RD_APP is null");
                } else {
                    arrayList.add(new String[]{"switch3rdApp", jSONObject.getString("switch3rdApp")});
                }
                if (!jSONObject.isNull("switch3rdDefault")) {
                    arrayList.add(new String[]{"switch3rdDefault", jSONObject.getString("switch3rdDefault")});
                }
                if (!jSONObject.isNull("backupConfig")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("backupConfig");
                    if (!jSONObject2.isNull("compatibleRule")) {
                        arrayList.add(new String[]{"compatibleRule", new Gson().toJson(jSONObject2.getString("compatibleRule"))});
                    }
                    if (!jSONObject2.isNull("ruleConfig")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("ruleConfig");
                        if (!jSONObject3.isNull("reminderCycle")) {
                            new SettingOperator().replace(new Settings[]{new Settings("notifycycle", jSONObject3.getString("reminderCycle"), "1")});
                        }
                        Iterator<String> itKeys = jSONObject3.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            arrayList.add(new String[]{next, jSONObject3.getString(next)});
                        }
                    }
                }
                execute("replace into cloud_backup_om_config(name,value) VALUES(?,?);", arrayList);
                this.f57845a = null;
                m75403l();
            } catch (C9721b | JSONException e10) {
                C11839m.m70687e("CloudBackupConfigOperator", e10.getMessage());
                throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "backup config operator exec error. " + e10.getMessage(), "execSQL");
            }
        } catch (Throwable th2) {
            this.f57845a = null;
            m75403l();
            throw th2;
        }
    }

    /* renamed from: j */
    public int m75399j() {
        C12527k c12527kM75407n = m75407n("appFileIdMaxCnt");
        if (c12527kM75407n != null) {
            return C0241z.m1686d(c12527kM75407n.m75434b(), 0);
        }
        return 0;
    }

    /* renamed from: j0 */
    public int m75400j0() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("mkfileThreadsAdvanced");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 2;
        }
        return Math.min(iM1685c, 10);
    }

    /* renamed from: k */
    public long m75401k() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("autoBackupCacheDuration");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 172800000L;
        }
        return iM1685c * 86400000;
    }

    /* renamed from: k0 */
    public List<BackupOptionSize> m75402k0() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("backupOptionSize");
        Gson gson = new Gson();
        if (c12527kM75407n == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "omConfig is null.");
            return arrayList;
        }
        List list = null;
        try {
            list = (List) gson.fromJson(c12527kM75407n.m75434b(), new f(null).getType());
        } catch (JsonSyntaxException unused) {
            C11839m.m70689w("CloudBackupConfigOperator", String.format(Locale.ENGLISH, "parse %s error, om passed wrong format value", c12527kM75407n.m75433a()));
        }
        if (list == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "parseResult is null.");
            return arrayList;
        }
        arrayList.addAll(list);
        return arrayList;
    }

    /* renamed from: l */
    public BackupMemberPrivilege m75403l() {
        BackupMemberPrivilege backupMemberPrivilege;
        BackupMemberPrivilege backupMemberPrivilege2 = this.f57845a;
        if (backupMemberPrivilege2 != null && !AbstractC14026a.m84159a(backupMemberPrivilege2.getAutoBackupFrequency())) {
            return this.f57845a;
        }
        C12527k c12527kM75407n = m75407n("backupMemberPrivilege");
        if (c12527kM75407n == null) {
            return new BackupMemberPrivilege();
        }
        if (TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            C11839m.m70689w("CloudBackupConfigOperator", "getBackupMemberPrivilege json is null");
            return new BackupMemberPrivilege();
        }
        try {
            backupMemberPrivilege = (BackupMemberPrivilege) C12540b1.m75483a(c12527kM75407n.m75434b(), BackupMemberPrivilege.class);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupConfigOperator", "getBackupMemberPrivilege error: " + e10.getMessage());
            backupMemberPrivilege = null;
        }
        if (backupMemberPrivilege == null) {
            return new BackupMemberPrivilege();
        }
        this.f57845a = backupMemberPrivilege;
        return backupMemberPrivilege;
    }

    /* renamed from: l0 */
    public List<OMFilterModule> m75404l0() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("appBackupSkipList");
        Gson gson = new Gson();
        if (c12527kM75407n != null) {
            List list = null;
            try {
                list = (List) gson.fromJson(c12527kM75407n.m75434b(), new c(null).getType());
            } catch (JsonSyntaxException unused) {
                C11839m.m70689w("CloudBackupConfigOperator", String.format(Locale.ENGLISH, "parse %s error, om passed wrong format value", c12527kM75407n.m75433a()));
            }
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    /* renamed from: m */
    public int m75405m() {
        C12527k c12527kM75407n = m75407n("cacheNum");
        if (c12527kM75407n == null) {
            return 2;
        }
        int iM1685c = C0241z.m1685c(c12527kM75407n.m75434b());
        C11839m.m70688i("CloudBackupConfigOperator", "getBackupModulesCacheNum " + iM1685c);
        if (iM1685c <= 0 || iM1685c > 5) {
            return 2;
        }
        return iM1685c;
    }

    /* renamed from: m0 */
    public long m75406m0(boolean z10) {
        AppBackupDuration appBackupDurationM75391g = m75391g();
        return (z10 ? appBackupDurationM75391g.getAuto() : appBackupDurationM75391g.getManual()).getModuleDataCacheDurationMillis();
    }

    /* renamed from: n */
    public C12527k m75407n(String str) {
        C12527k c12527k = null;
        try {
            List<C12527k> listQuery = query("select name, value from cloud_backup_om_config where name = ?", new String[]{str});
            if (listQuery.isEmpty()) {
                C11839m.m70689w("CloudBackupConfigOperator", "CloudBackupOMConfig is empty");
                CloudBackupReport.reportOmError("CloudBackupOMConfig is empty");
            } else {
                c12527k = listQuery.get(0);
            }
        } catch (C9721b e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getBackupOMConfig " + str + " error." + e10.getMessage());
            CloudBackupReport.reportOmError("getBackupOMConfig " + str + " error." + e10.getMessage());
        }
        return c12527k;
    }

    /* renamed from: n0 */
    public long m75408n0(boolean z10) {
        AppBackupDuration appBackupDurationM75391g = m75391g();
        return (z10 ? appBackupDurationM75391g.getAuto() : appBackupDurationM75391g.getManual()).getDataCacheDurationMillis();
    }

    /* renamed from: o */
    public int m75409o() {
        C12527k c12527kM75407n = m75407n("defaultRedDot");
        return (c12527kM75407n == null || C0241z.m1686d(c12527kM75407n.m75434b(), 0) != -1) ? 0 : -1;
    }

    /* renamed from: o0 */
    public long m75410o0(boolean z10) {
        AppBackupDuration appBackupDurationM75391g = m75391g();
        return (z10 ? appBackupDurationM75391g.getAuto() : appBackupDurationM75391g.getManual()).getSdcardCacheDurationMillis();
    }

    /* renamed from: p */
    public long m75411p() {
        C12527k c12527kM75407n = m75407n("reservedSize");
        if (c12527kM75407n == null) {
            return -1L;
        }
        long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
        if (jM1688f > 0) {
            return jM1688f * 1048576;
        }
        return -1L;
    }

    /* renamed from: p0 */
    public List<Next2hmosMappingItem> m75412p0() throws Throwable {
        if (!AbstractC14026a.m84159a(f57844b)) {
            C11839m.m70688i("CloudBackupConfigOperator", "getNext2HmosMappingItems from cache");
            return f57844b;
        }
        String strM75414q0 = m75414q0();
        C11839m.m70688i("CloudBackupConfigOperator", "getNext2HmosMappingItems from database jsonStr: " + strM75414q0);
        List list = null;
        try {
            list = (List) new Gson().fromJson(strM75414q0, new e(null).getType());
        } catch (JsonSyntaxException unused) {
            C11839m.m70689w("CloudBackupConfigOperator", String.format(Locale.ENGLISH, "parse %s error, om passed wrong format value", "next2hmosMapping"));
        }
        if (list == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "parseResult is null.");
            return f57844b;
        }
        f57844b.addAll(list);
        return f57844b;
    }

    /* renamed from: q */
    public long m75413q() {
        C12527k c12527kM75407n = m75407n("backupStartInterval");
        if (c12527kM75407n != null) {
            return C0241z.m1689g(c12527kM75407n.m75434b(), 120L);
        }
        return 120L;
    }

    /* renamed from: q0 */
    public String m75414q0() throws Throwable {
        C12527k c12527kM75407n = m75407n("next2hmosMapping");
        String strM1290o2 = "";
        if (c12527kM75407n != null) {
            return c12527kM75407n.m75434b();
        }
        try {
            strM1290o2 = C0209d.m1290o2(C0213f.m1377a().getAssets().open("next2hmos_mapping.json"));
            C11839m.m70686d("CloudBackupConfigOperator", "getDefaultNext2HmosMappingConfig: " + strM1290o2);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupConfigOperator", "getDefaultNext2HmosMappingConfig error:" + e10.getMessage());
        }
        return strM1290o2;
    }

    /* renamed from: r */
    public int m75415r() {
        C12527k c12527kM75407n = m75407n("backupStartRetryTimes");
        if (c12527kM75407n != null) {
            return C0241z.m1686d(c12527kM75407n.m75434b(), 5);
        }
        return 5;
    }

    @Override // ml.AbstractC11478a
    /* renamed from: r0 */
    public C12527k getObject(Cursor cursor) {
        C12527k c12527k = new C12527k();
        c12527k.m75435c(cursor.getString(0));
        c12527k.m75436d(cursor.getString(1));
        return c12527k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.List] */
    /* renamed from: s */
    public List<AppBackupSwitchListApp> m75417s() {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("appBackupSwitchListAppsEx");
        if (c12527kM75407n == null) {
            return arrayList;
        }
        if (TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            C11839m.m70687e("CloudBackupConfigOperator", "getBackupSwitchListApp json is null");
            return arrayList;
        }
        ArrayList<AppBackupSwitchList> arrayList2 = new ArrayList();
        try {
            arrayList2 = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new b(null).getType());
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getBackupSwitchListApp error: " + e10.toString());
        }
        if (arrayList2 == null) {
            C11839m.m70687e("CloudBackupConfigOperator", "get backup switch config list is null");
            return arrayList;
        }
        final String strM80790C = C13452e.m80781L().m80790C();
        C11839m.m70686d("CloudBackupConfigOperator", "get backup switch config userGradeCode is:" + strM80790C);
        for (AppBackupSwitchList appBackupSwitchList : arrayList2) {
            if (appBackupSwitchList != null && appBackupSwitchList.getGradeCode() != null) {
                Stream<String> stream = appBackupSwitchList.getGradeCode().stream();
                Objects.requireNonNull(strM80790C);
                if (stream.anyMatch(new Predicate() { // from class: rl.g
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return strM80790C.equalsIgnoreCase((String) obj);
                    }
                })) {
                    C11839m.m70688i("CloudBackupConfigOperator", "grade code has backup switch list");
                    return appBackupSwitchList.getApps();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: s0 */
    public double m75418s0() {
        C12527k c12527kM75407n = m75407n("oldTarReferenceRate");
        if (c12527kM75407n != null) {
            double dDoubleValue = C0241z.m1683a(c12527kM75407n.m75434b(), Double.valueOf(0.1d)).doubleValue();
            C11839m.m70688i("CloudBackupConfigOperator", "getOldTarReferenceRate: " + dDoubleValue);
            if (dDoubleValue >= 0.0d) {
                return dDoubleValue;
            }
        }
        return 0.1d;
    }

    /* renamed from: t */
    public int m75419t() {
        C12527k c12527kM75407n = m75407n("backupThreadSize");
        if (c12527kM75407n != null) {
            return C0241z.m1685c(c12527kM75407n.m75434b());
        }
        return 6;
    }

    /* renamed from: t0 */
    public OverdueBackupRecordsPolicy m75420t0() {
        OverdueBackupRecordsPolicy overdueBackupRecordsPolicy;
        OverdueBackupRecordsPolicy overdueBackupRecordsPolicy2 = new OverdueBackupRecordsPolicy();
        C12527k c12527kM75407n = m75407n("overdueBackupRecordsPolicy");
        if (c12527kM75407n == null) {
            return overdueBackupRecordsPolicy2;
        }
        if (TextUtils.isEmpty(c12527kM75407n.m75434b())) {
            C11839m.m70689w("CloudBackupConfigOperator", "getOverdueBackupRecordsPolicy json is null");
            return overdueBackupRecordsPolicy2;
        }
        try {
            overdueBackupRecordsPolicy = (OverdueBackupRecordsPolicy) C12540b1.m75483a(c12527kM75407n.m75434b(), OverdueBackupRecordsPolicy.class);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupConfigOperator", "getOverdueBackupRecordsPolicy error: " + e10.getMessage());
            overdueBackupRecordsPolicy = null;
        }
        return overdueBackupRecordsPolicy == null ? overdueBackupRecordsPolicy2 : overdueBackupRecordsPolicy;
    }

    /* renamed from: u */
    public BackupTimeWindowBean m75421u() {
        try {
            C12527k c12527kM75407n = m75407n("timeWindowConfig");
            String strM75434b = "";
            if (c12527kM75407n != null) {
                strM75434b = c12527kM75407n.m75434b();
                C11839m.m70688i("CloudBackupConfigOperator", "getBackupTimeWindowConfig " + strM75434b);
            }
            BackupTimeWindowBean backupTimeWindowBean = (BackupTimeWindowBean) new Gson().fromJson(strM75434b, BackupTimeWindowBean.class);
            if (backupTimeWindowBean != null) {
                return backupTimeWindowBean;
            }
            C11839m.m70689w("CloudBackupConfigOperator", "getBackupTimeWindowConfig, timeWindowBean is null.");
            return new BackupTimeWindowBean();
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupConfigOperator", "getBackupTimeWindowConfig error: " + e10.getMessage());
            return new BackupTimeWindowBean();
        }
    }

    /* renamed from: u0 */
    public final String m75422u0() {
        C12527k c12527kM75407n = m75407n("refurbishValidPeriod");
        if (c12527kM75407n == null) {
            return "";
        }
        String strM75434b = c12527kM75407n.m75434b();
        C11839m.m70688i("CloudBackupConfigOperator", "getRefurbishBackupRecordValidPeriod " + strM75434b);
        return strM75434b;
    }

    /* renamed from: v */
    public int m75423v() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("batchRMNum");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 50;
        }
        return iM1685c;
    }

    /* renamed from: v0 */
    public List<String> m75424v0(Context context) {
        ArrayList arrayList = new ArrayList();
        C12527k c12527kM75407n = m75407n("refurbishImportantAppIds");
        if (c12527kM75407n == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "getRefurbishImportantAppIds: the config is null.");
            return arrayList;
        }
        List<String> list = (List) C12540b1.m75484b(c12527kM75407n.m75434b(), new h(null).getType());
        if (list == null) {
            C11839m.m70688i("CloudBackupConfigOperator", "getRefurbishImportantAppIds: the importApps is null.");
            return arrayList;
        }
        for (String str : list) {
            arrayList.add(str);
            C11839m.m70688i("CloudBackupConfigOperator", "getRefurbishImportantAppIds: add appId is: " + str + ",appName is:" + C12590s0.m75770M(context, str));
        }
        C11839m.m70688i("CloudBackupConfigOperator", "getRefurbishImportantAppIds: return the data size is: " + arrayList.size());
        return arrayList;
    }

    /* renamed from: w */
    public int m75425w() {
        C12527k c12527kM75407n = m75407n("batteryChargeConnected");
        if (c12527kM75407n != null) {
            return C0241z.m1685c(c12527kM75407n.m75434b());
        }
        return -1;
    }

    /* renamed from: w0 */
    public RefurbishValidPeriod m75426w0() {
        try {
            return (RefurbishValidPeriod) new Gson().fromJson(m75422u0(), RefurbishValidPeriod.class);
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupConfigOperator", "getThermalControl error: " + e10.toString());
            return new RefurbishValidPeriod();
        }
    }

    /* renamed from: x */
    public int m75427x() {
        C12527k c12527kM75407n = m75407n("bloomFilterItemsMax");
        int iM1685c = c12527kM75407n != null ? C0241z.m1685c(c12527kM75407n.m75434b()) : 0;
        if (iM1685c != 0) {
            return iM1685c;
        }
        C11839m.m70686d("CloudBackupConfigOperator", "getBloomFilterItemsMax is 0, get default value = 100000");
        return 100000;
    }

    /* renamed from: x0 */
    public long m75428x0() {
        C12527k c12527kM75407n = m75407n("reservedSize");
        if (c12527kM75407n != null) {
            long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
            if (jM1688f > 0) {
                return jM1688f * 1048576;
            }
        }
        return 0L;
    }

    /* renamed from: y */
    public int m75429y() {
        C12527k c12527kM75407n = m75407n("bloomFilterItemsMin");
        int iM1685c = c12527kM75407n != null ? C0241z.m1685c(c12527kM75407n.m75434b()) : 0;
        if (iM1685c != 0) {
            return iM1685c;
        }
        C11839m.m70686d("CloudBackupConfigOperator", "getBloomFilterItemsMin is 0, get default value = 10000");
        return 10000;
    }

    /* renamed from: y0 */
    public C10453b m75430y0() {
        C12527k c12527kM75407n = m75407n("restoreExperienceControl");
        return c12527kM75407n == null ? m75368W() : (C10453b) C10527a.m64630h(c12527kM75407n.m75434b(), C10453b.class, m75368W());
    }

    /* renamed from: z */
    public int m75431z() {
        int iM1685c;
        C12527k c12527kM75407n = m75407n("bmBaseDataBackupCycle");
        if (c12527kM75407n == null || (iM1685c = C0241z.m1685c(c12527kM75407n.m75434b())) <= 0) {
            return 7;
        }
        return iM1685c;
    }

    /* renamed from: z0 */
    public long m75432z0() {
        C12527k c12527kM75407n = m75407n("restoreReservedSize");
        if (c12527kM75407n != null) {
            long jM1688f = C0241z.m1688f(c12527kM75407n.m75434b());
            if (jM1688f > 0) {
                return jM1688f * 1048576;
            }
        }
        return 0L;
    }
}
