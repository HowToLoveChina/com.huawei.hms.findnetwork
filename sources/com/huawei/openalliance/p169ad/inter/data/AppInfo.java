package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.C7574ph;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.p169ad.beans.metadata.Permission;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class AppInfo implements Serializable {
    private static final String TAG = "AppInfo";
    private static final long serialVersionUID = 30414300;
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private boolean allowedNonWifiNetwork;
    private String appCountry;
    private String appDesc;
    private String appDetailsUrl;
    private String appLanguage;
    private String appName;
    private int appType;
    private int autoOpenAfterInstall;
    private int autoOpenSwitchLandingOrDetail;
    private String channelInfo;
    private int channelInfoSaveLimit;
    private boolean checkSha256;
    private String contentInstallBtnAction;
    private String contiBtn;
    private String curInstallWay;
    private String developerName;
    private String dlBtnText;
    private String dlOpenBtnText;
    private String downCountDesc;
    private Long downloadNum;
    private String downloadUrl;
    private long fileSize;
    private int fullScrnNotify;
    private String fullScrnNotifyText;
    private Integer hasPermissions;
    private String hot;
    private String iconUrl;
    private String insActvNotifyBtnText;
    private int insActvNotifyCfg;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String intentUri;
    private String nextInstallWays;
    private int noAlertTime;
    private String packageName;
    private boolean permPromptForCard;
    private boolean permPromptForLanding;
    private String permissionUrl;
    private List<PermissionEntity> permissions;
    private int popNotify;
    private int popUpAfterInstallNew;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String privacyUrl;
    private String pureModeText;
    private Long rateNum;
    private transient String remoteAfDlBtnText;
    private transient String remoteDlBtnText;
    private String reservedPkgName;
    private String safeDownloadUrl;
    private String sha256;
    private int trafficReminder;
    private String uniqueId;
    private String versionCode;
    private String versionName;

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$1 */
    public class RunnableC72911 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f33599a;

        /* renamed from: b */
        final /* synthetic */ String f33600b;

        public RunnableC72911(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7741ao.m47550a(context, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$2 */
    public class RunnableC72922 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f33602a;

        /* renamed from: b */
        final /* synthetic */ String f33603b;

        public RunnableC72922(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6980bx.m41139a(context, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$3 */
    public static /* synthetic */ class C72933 {

        /* renamed from: a */
        static final /* synthetic */ int[] f33605a;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f33605a = iArr;
            try {
                iArr[AppStatus.INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33605a[AppStatus.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @OuterVisible
    public interface PermissionCallBack {
        void onPermissionCallBack(List<PermissionEntity> list);
    }

    /* renamed from: com.huawei.openalliance.ad.inter.data.AppInfo$a */
    public static class C7294a implements C7574ph.a {

        /* renamed from: a */
        PermissionCallBack f33606a;

        public C7294a(PermissionCallBack permissionCallBack) {
            this.f33606a = permissionCallBack;
        }

        @Override // com.huawei.openalliance.p169ad.C7574ph.a
        /* renamed from: a */
        public void mo42424a(List<PermissionEntity> list) {
            PermissionCallBack permissionCallBack = this.f33606a;
            if (permissionCallBack != null) {
                permissionCallBack.onPermissionCallBack(list);
            }
        }
    }

    @OuterVisible
    public AppInfo() {
        this.priorInstallWay = "3";
        this.contentInstallBtnAction = "3";
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.popUpAfterInstallNew = 0;
        this.channelInfoSaveLimit = -2;
        this.insActvNotifyCfg = 1;
        this.appType = 1;
    }

    /* renamed from: A */
    public String m44340A() {
        return this.actName;
    }

    /* renamed from: B */
    public int m44342B() {
        return this.appType;
    }

    /* renamed from: C */
    public int m44344C() {
        return this.autoOpenAfterInstall;
    }

    /* renamed from: D */
    public long m44346D() {
        return this.allAreaPopDelay;
    }

    /* renamed from: E */
    public int m44348E() {
        return this.popUpStyle;
    }

    /* renamed from: F */
    public String m44350F() {
        return this.installPermiText;
    }

    /* renamed from: G */
    public String m44352G() {
        return this.pureModeText;
    }

    /* renamed from: H */
    public String m44354H() {
        return this.installPureModeText;
    }

    /* renamed from: I */
    public String m44356I() {
        return this.contiBtn;
    }

    /* renamed from: J */
    public String m44358J() {
        return this.reservedPkgName;
    }

    /* renamed from: K */
    public Integer m44360K() {
        return this.hasPermissions;
    }

    /* renamed from: L */
    public String m44362L() {
        return this.privacyUrl;
    }

    /* renamed from: M */
    public void m44364M(String str) {
        this.contiBtn = str;
    }

    /* renamed from: N */
    public void m44365N(String str) {
        this.reservedPkgName = str;
    }

    /* renamed from: a */
    public String m44366a() {
        return this.contentInstallBtnAction;
    }

    /* renamed from: b */
    public InstallConfig m44375b() {
        return this.installConfig;
    }

    /* renamed from: c */
    public int m44383c() {
        return this.autoOpenSwitchLandingOrDetail;
    }

    /* renamed from: d */
    public String m44388d() {
        return this.dlOpenBtnText;
    }

    /* renamed from: e */
    public int m44391e() {
        return this.popUpAfterInstallNew;
    }

    /* renamed from: f */
    public String m44394f() {
        return this.popUpAfterInstallText;
    }

    /* renamed from: g */
    public String m44397g() {
        return this.channelInfo;
    }

    @OuterVisible
    public String getAppDesc() {
        String str = this.appDesc;
        return str == null ? "" : str;
    }

    @OuterVisible
    public String getAppDetailUrl() {
        return this.appDetailsUrl;
    }

    @OuterVisible
    public String getAppName() {
        String str = this.appName;
        return str == null ? "" : str;
    }

    @OuterVisible
    public String getCta(AppStatus appStatus) {
        int i10 = C72933.f33605a[appStatus.ordinal()];
        if (i10 == 1) {
            return this.afDlBtnText;
        }
        if (i10 != 2) {
            return null;
        }
        return this.dlBtnText;
    }

    @OuterVisible
    public String getDeveloperName() {
        String str = this.developerName;
        return str == null ? "" : str;
    }

    @OuterVisible
    public String getDownCountDesc() {
        return this.downCountDesc;
    }

    @OuterVisible
    public Long getDownloadNum() {
        return this.downloadNum;
    }

    @OuterVisible
    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    @OuterVisible
    public long getFileSize() {
        return this.fileSize;
    }

    @OuterVisible
    public String getHot() {
        return this.hot;
    }

    @OuterVisible
    public String getIconUrl() {
        return this.iconUrl;
    }

    @OuterVisible
    public String getIntentUri() {
        return this.intentUri;
    }

    @OuterVisible
    public String getPackageName() {
        return this.packageName;
    }

    @OuterVisible
    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    @OuterVisible
    public List<PermissionEntity> getPermissions() {
        return this.permissions;
    }

    @OuterVisible
    public String getPriorInstallWay() {
        return this.priorInstallWay;
    }

    @OuterVisible
    public String getPrivacyLink() {
        return this.privacyUrl;
    }

    @OuterVisible
    public Long getRateNum() {
        return this.rateNum;
    }

    @OuterVisible
    public String getSafeDownloadUrl() {
        return this.safeDownloadUrl;
    }

    @OuterVisible
    public String getSha256() {
        return this.sha256;
    }

    @OuterVisible
    public String getUniqueId() {
        return this.uniqueId;
    }

    @OuterVisible
    public String getVersionCode() {
        return this.versionCode;
    }

    @OuterVisible
    public String getVersionName() {
        String str = this.versionName;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public int m44400h() {
        return this.channelInfoSaveLimit;
    }

    /* renamed from: i */
    public int m44403i() {
        return this.noAlertTime;
    }

    @OuterVisible
    public boolean isAllowedNonWifiNetwork() {
        return this.allowedNonWifiNetwork;
    }

    @OuterVisible
    public boolean isCheckSha256() {
        return this.checkSha256;
    }

    @OuterVisible
    public boolean isPermPromptForCard() {
        return this.permPromptForCard;
    }

    @OuterVisible
    public boolean isPermPromptForLanding() {
        return this.permPromptForLanding;
    }

    /* renamed from: j */
    public int m44406j() {
        return this.trafficReminder;
    }

    /* renamed from: k */
    public String m44409k() {
        return this.dlBtnText;
    }

    /* renamed from: l */
    public String m44412l() {
        return this.afDlBtnText;
    }

    /* renamed from: m */
    public String m44414m() {
        return this.remoteDlBtnText;
    }

    /* renamed from: n */
    public String m44416n() {
        return this.remoteAfDlBtnText;
    }

    /* renamed from: o */
    public int m44418o() {
        return this.popNotify;
    }

    /* renamed from: p */
    public int m44420p() {
        return this.fullScrnNotify;
    }

    /* renamed from: q */
    public String m44422q() {
        return this.fullScrnNotifyText;
    }

    /* renamed from: r */
    public String m44424r() {
        return this.insActvNotifyBtnText;
    }

    @OuterVisible
    public void requestPermissions(Context context, PermissionCallBack permissionCallBack) {
        if (getPermissions() == null) {
            new C7574ph(context, new C7294a(permissionCallBack)).m46765a(this);
        } else if (permissionCallBack != null) {
            permissionCallBack.onPermissionCallBack(getPermissions());
        }
    }

    /* renamed from: s */
    public int m44426s() {
        return this.insActvNotifyCfg;
    }

    @OuterVisible
    public void setAllowedNonWifiNetwork(boolean z10) {
        this.allowedNonWifiNetwork = z10;
    }

    @OuterVisible
    public void showPermissionPage(Context context) {
        m44337a(context, this.permissionUrl);
    }

    @OuterVisible
    public void showPermissionPageInWeb(Context context) {
        m44339b(this.permissionUrl, context);
    }

    @OuterVisible
    public void showPrivacyPolicy(Context context) {
        m44337a(context, this.privacyUrl);
    }

    @OuterVisible
    public void showPrivacyPolicyInWeb(Context context) {
        m44339b(this.privacyUrl, context);
    }

    /* renamed from: t */
    public String m44428t() {
        return this.intent;
    }

    /* renamed from: u */
    public String m44430u() {
        return this.intentPackage;
    }

    /* renamed from: v */
    public String m44432v() {
        return this.nextInstallWays;
    }

    /* renamed from: w */
    public void m44434w(String str) {
        this.dlBtnText = str;
    }

    /* renamed from: x */
    public String m44436x() {
        return this.appLanguage;
    }

    /* renamed from: y */
    public String m44438y() {
        return this.appCountry;
    }

    /* renamed from: z */
    public String m44440z() {
        return this.curInstallWay;
    }

    public AppInfo(ApkInfo apkInfo) {
        this.priorInstallWay = "3";
        this.contentInstallBtnAction = "3";
        this.permPromptForCard = true;
        this.permPromptForLanding = false;
        this.popUpAfterInstallNew = 0;
        this.channelInfoSaveLimit = -2;
        this.insActvNotifyCfg = 1;
        this.appType = 1;
        if (apkInfo != null) {
            this.appName = AbstractC7806cz.m48168c(apkInfo.m39662j());
            this.iconUrl = apkInfo.m39690x();
            this.packageName = apkInfo.m39626a();
            this.versionCode = apkInfo.m39636b();
            this.versionName = apkInfo.m39641c();
            this.downloadUrl = apkInfo.m39644d();
            this.permissionUrl = apkInfo.m39656h();
            this.appDetailsUrl = apkInfo.m39659i();
            this.fileSize = apkInfo.m39647e();
            this.sha256 = apkInfo.m39650f();
            this.hot = apkInfo.m39668m();
            this.rateNum = apkInfo.m39670n();
            this.downloadNum = apkInfo.m39672o();
            this.downCountDesc = apkInfo.m39674p();
            this.checkSha256 = apkInfo.m39615P() == 0;
            this.safeDownloadUrl = apkInfo.m39653g();
            this.channelInfo = apkInfo.m39688w();
            this.channelInfoSaveLimit = apkInfo.m39692y();
            String strM39666l = apkInfo.m39666l();
            if (!TextUtils.isEmpty(strM39666l)) {
                this.priorInstallWay = strM39666l;
            }
            String strM39676q = apkInfo.m39676q();
            if (!TextUtils.isEmpty(strM39676q)) {
                this.contentInstallBtnAction = strM39676q;
            }
            this.installConfig = apkInfo.m39678r();
            this.curInstallWay = this.priorInstallWay;
            this.permPromptForCard = "1".equals(apkInfo.m39680s());
            this.permPromptForLanding = "1".equals(apkInfo.m39682t());
            this.popUpAfterInstallNew = apkInfo.m39684u();
            this.popUpAfterInstallText = apkInfo.m39686v();
            this.dlBtnText = AbstractC7806cz.m48168c(apkInfo.m39595C());
            this.afDlBtnText = AbstractC7806cz.m48168c(apkInfo.m39597D());
            this.popNotify = apkInfo.m39599E();
            this.fullScrnNotify = apkInfo.m39601F();
            this.fullScrnNotifyText = AbstractC7806cz.m48168c(apkInfo.m39603G());
            this.insActvNotifyBtnText = AbstractC7806cz.m48168c(apkInfo.m39605H());
            this.insActvNotifyCfg = apkInfo.m39607I();
            m44372a(apkInfo.m39664k());
            this.iconUrl = apkInfo.m39690x();
            this.appDesc = AbstractC7806cz.m48168c(apkInfo.m39694z());
            this.developerName = AbstractC7806cz.m48168c(apkInfo.m39612M());
            this.noAlertTime = apkInfo.m39591A() > 0 ? apkInfo.m39591A() : 7;
            this.trafficReminder = apkInfo.m39593B();
            this.intent = apkInfo.m39609J();
            this.intentPackage = apkInfo.m39610K();
            this.hasPermissions = apkInfo.m39611L();
            this.nextInstallWays = apkInfo.m39614O();
            this.actName = apkInfo.m39616Q();
            this.appType = apkInfo.m39617R();
            this.autoOpenAfterInstall = apkInfo.m39618S();
            this.allAreaPopDelay = apkInfo.m39619T();
            this.popUpStyle = apkInfo.m39620U();
            this.installPermiText = AbstractC7806cz.m48168c(apkInfo.m39621V());
            this.pureModeText = AbstractC7806cz.m48168c(apkInfo.m39622W());
            this.installPureModeText = AbstractC7806cz.m48168c(apkInfo.m39623X());
            this.contiBtn = AbstractC7806cz.m48168c(apkInfo.m39624Y());
            this.reservedPkgName = apkInfo.m39625Z();
            this.autoOpenSwitchLandingOrDetail = apkInfo.m39634aa();
            this.dlOpenBtnText = AbstractC7806cz.m48168c(apkInfo.m39635ab());
        }
    }

    /* renamed from: A */
    public void m44341A(String str) {
        this.fullScrnNotifyText = str;
    }

    /* renamed from: B */
    public void m44343B(String str) {
        this.insActvNotifyBtnText = str;
    }

    /* renamed from: C */
    public void m44345C(String str) {
        this.intent = str;
    }

    /* renamed from: D */
    public void m44347D(String str) {
        this.intentPackage = str;
    }

    /* renamed from: E */
    public void m44349E(String str) {
        this.nextInstallWays = str;
    }

    /* renamed from: F */
    public void m44351F(String str) {
        this.appLanguage = str;
    }

    /* renamed from: G */
    public void m44353G(String str) {
        this.appCountry = str;
    }

    /* renamed from: H */
    public void m44355H(String str) {
        this.curInstallWay = str;
    }

    /* renamed from: I */
    public void m44357I(String str) {
        this.actName = str;
    }

    /* renamed from: J */
    public void m44359J(String str) {
        this.installPermiText = str;
    }

    /* renamed from: K */
    public void m44361K(String str) {
        this.pureModeText = str;
    }

    /* renamed from: L */
    public void m44363L(String str) {
        this.installPureModeText = str;
    }

    /* renamed from: a */
    public void m44367a(int i10) {
        this.autoOpenSwitchLandingOrDetail = i10;
    }

    /* renamed from: b */
    public String m44376b(Integer num) {
        if (num == null) {
            num = 5;
        }
        if (1 == num.intValue() || 14 == num.intValue() || 10005 == num.intValue()) {
            return m44366a();
        }
        String strM44440z = m44440z();
        return TextUtils.isEmpty(strM44440z) ? getPriorInstallWay() : strM44440z;
    }

    /* renamed from: c */
    public void m44384c(int i10) {
        this.channelInfoSaveLimit = i10;
    }

    /* renamed from: d */
    public void m44389d(int i10) {
        this.noAlertTime = i10;
    }

    /* renamed from: e */
    public void m44392e(int i10) {
        this.trafficReminder = i10;
    }

    /* renamed from: f */
    public void m44395f(int i10) {
        this.popNotify = i10;
    }

    /* renamed from: g */
    public void m44398g(int i10) {
        this.fullScrnNotify = i10;
    }

    /* renamed from: h */
    public void m44401h(int i10) {
        this.insActvNotifyCfg = i10;
    }

    /* renamed from: i */
    public void m44404i(int i10) {
        this.appType = i10;
    }

    /* renamed from: j */
    public void m44407j(int i10) {
        this.autoOpenAfterInstall = i10;
    }

    /* renamed from: k */
    public void m44410k(int i10) {
        this.popUpStyle = i10;
    }

    /* renamed from: l */
    public void m44413l(String str) {
        this.safeDownloadUrl = str;
    }

    /* renamed from: m */
    public void m44415m(String str) {
        this.intentUri = str;
    }

    /* renamed from: n */
    public void m44417n(String str) {
        this.appName = str;
    }

    /* renamed from: o */
    public void m44419o(String str) {
        this.appDesc = str;
    }

    /* renamed from: p */
    public void m44421p(String str) {
        this.developerName = str;
    }

    /* renamed from: q */
    public void m44423q(String str) {
        this.priorInstallWay = str;
    }

    /* renamed from: r */
    public void m44425r(String str) {
        this.contentInstallBtnAction = str;
    }

    /* renamed from: s */
    public void m44427s(String str) {
        this.dlOpenBtnText = str;
    }

    /* renamed from: t */
    public void m44429t(String str) {
        this.popUpAfterInstallText = str;
    }

    /* renamed from: u */
    public void m44431u(String str) {
        this.channelInfo = str;
    }

    /* renamed from: v */
    public void m44433v(String str) {
        this.uniqueId = str;
    }

    /* renamed from: w */
    public boolean m44435w() {
        Integer num = this.hasPermissions;
        return num != null ? num.intValue() == 1 : !AbstractC7760bg.m47767a(this.permissions);
    }

    /* renamed from: x */
    public void m44437x(String str) {
        this.afDlBtnText = str;
    }

    /* renamed from: y */
    public void m44439y(String str) {
        this.remoteDlBtnText = str;
    }

    /* renamed from: z */
    public void m44441z(String str) {
        this.remoteAfDlBtnText = str;
    }

    /* renamed from: a */
    public void m44368a(long j10) {
        this.fileSize = j10;
    }

    /* renamed from: b */
    public void m44377b(int i10) {
        this.popUpAfterInstallNew = i10;
    }

    /* renamed from: c */
    public void m44385c(Integer num) {
        this.hasPermissions = num;
    }

    /* renamed from: d */
    public void m44390d(String str) {
        this.iconUrl = str;
    }

    /* renamed from: e */
    public void m44393e(String str) {
        this.downloadUrl = str;
    }

    /* renamed from: f */
    public void m44396f(String str) {
        this.permissionUrl = str;
    }

    /* renamed from: g */
    public void m44399g(String str) {
        this.appDetailsUrl = str;
    }

    /* renamed from: h */
    public void m44402h(String str) {
        this.privacyUrl = str;
    }

    /* renamed from: i */
    public void m44405i(String str) {
        this.hot = str;
    }

    /* renamed from: j */
    public void m44408j(String str) {
        this.downCountDesc = str;
    }

    /* renamed from: k */
    public void m44411k(String str) {
        this.sha256 = str;
    }

    /* renamed from: a */
    private void m44337a(Context context, String str) {
        Boolean boolMo44062o = HiAd.m44014a(context).mo44062o();
        if (boolMo44062o == null || boolMo44062o.booleanValue()) {
            m44338a(str, context);
        } else {
            m44339b(str, context);
        }
    }

    /* renamed from: b */
    public void m44378b(long j10) {
        this.allAreaPopDelay = j10;
    }

    /* renamed from: c */
    public void m44386c(String str) {
        this.versionName = str;
    }

    /* renamed from: a */
    public void m44369a(InstallConfig installConfig) {
        this.installConfig = installConfig;
    }

    /* renamed from: b */
    public void m44379b(Long l10) {
        this.downloadNum = l10;
    }

    /* renamed from: c */
    public void m44387c(boolean z10) {
        this.checkSha256 = z10;
    }

    /* renamed from: a */
    public void m44370a(Long l10) {
        this.rateNum = l10;
    }

    /* renamed from: b */
    public void m44380b(String str) {
        this.versionCode = str;
    }

    /* renamed from: b */
    private void m44339b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b(TAG, "url is empty.");
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.data.AppInfo.2

                /* renamed from: a */
                final /* synthetic */ Context f33602a;

                /* renamed from: b */
                final /* synthetic */ String f33603b;

                public RunnableC72922(Context context2, String str2) {
                    context = context2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C6980bx.m41139a(context, str);
                }
            });
        }
    }

    /* renamed from: a */
    public void m44371a(String str) {
        this.packageName = str;
    }

    /* renamed from: a */
    private void m44338a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b(TAG, "url is empty.");
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.data.AppInfo.1

                /* renamed from: a */
                final /* synthetic */ Context f33599a;

                /* renamed from: b */
                final /* synthetic */ String f33600b;

                public RunnableC72911(Context context2, String str2) {
                    context = context2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractC7741ao.m47550a(context, str);
                }
            });
        }
    }

    /* renamed from: b */
    public void m44381b(List<PermissionEntity> list) {
        this.permissions = list;
    }

    /* renamed from: a */
    public void m44372a(List<Permission> list) {
        StringBuilder sb2;
        String str = "parsePermission Exception:";
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            ArrayMap arrayMap = new ArrayMap();
            for (Permission permission : list) {
                List arrayList = (List) arrayMap.get(permission.m40386b());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    arrayMap.put(permission.m40386b(), arrayList);
                }
                arrayList.add(new PermissionEntity(AbstractC7806cz.m48168c(permission.m40384a()), 1));
            }
            this.permissions = new ArrayList();
            for (Map.Entry entry : arrayMap.entrySet()) {
                this.permissions.add(new PermissionEntity(AbstractC7806cz.m48168c((String) entry.getKey()), 0));
                this.permissions.addAll((Collection) entry.getValue());
            }
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "parsePermission RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(TAG, sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(TAG, sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d(TAG, sb2.toString());
        }
    }

    /* renamed from: b */
    public void m44382b(boolean z10) {
        this.permPromptForLanding = z10;
    }

    /* renamed from: a */
    public void m44373a(boolean z10) {
        this.permPromptForCard = z10;
    }

    /* renamed from: a */
    public boolean m44374a(Integer num) {
        if (TextUtils.isEmpty(this.packageName)) {
            return false;
        }
        String strM44376b = m44376b(num);
        if (TextUtils.isEmpty(strM44376b)) {
            return false;
        }
        return strM44376b.equals("8") || strM44376b.equals("6") || strM44376b.equals("5");
    }
}
