package com.huawei.openalliance.p169ad.beans.metadata;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6932d;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class ApkInfo {
    private String actName;
    private String afDlBtnText;
    private long allAreaPopDelay;
    private String appDesc;
    private String appName;
    private int autoOpenAfterInstall;
    private int autoOpenAfterInstallV2;
    private String channelInfo;
    private int checkSha256Flag;
    private String contentBtnAction;
    private String contiBtn;
    private String detailUrl;
    private String developerName;
    private String dlBtnText;
    private String dlOpenBtnText;
    private String downCountDesc;
    private Long downloadNum;
    private long fileSize;
    private String fullScrnNotifyText;

    @InterfaceC6932d(m39225a = "hasper")
    private Integer hasPermission;
    private String hot;

    @InterfaceC6932d(m39225a = "appIcon")
    @InterfaceC6929a
    private String iconUrl;
    private String insActvNotifyBtnText;
    private InstallConfig installConfig;
    private String installPermiText;
    private String installPureModeText;
    private String intent;
    private String intentPackage;
    private String nextInstallWays;
    private int noAlertTime;
    private String packageName;
    private String permissionUrl;
    private List<Permission> permissions;
    private String pkgNameEncoded;
    private int popUpAfterInstallNew;
    private String popUpAfterInstallText;
    private int popUpStyle;
    private String priorInstallWay;
    private String pureModeText;
    private Long rateNum;
    private String reservedPkgName;

    @InterfaceC6929a
    private String secondUrl;
    private String sha256;
    private int trafficReminder;

    @InterfaceC6929a
    private String url;
    private String versionCode;
    private String versionName;
    private String permPromptForCard = "1";
    private String permPromptForLanding = "0";
    private int channelInfoSaveLimit = -2;
    private int popNotify = 1;
    private int fullScrnNotify = 0;
    private int insActvNotifyCfg = 1;
    private int appType = 1;

    /* renamed from: A */
    public int m39591A() {
        return this.noAlertTime;
    }

    /* renamed from: B */
    public int m39593B() {
        return this.trafficReminder;
    }

    /* renamed from: C */
    public String m39595C() {
        return this.dlBtnText;
    }

    /* renamed from: D */
    public String m39597D() {
        return this.afDlBtnText;
    }

    /* renamed from: E */
    public int m39599E() {
        return this.popNotify;
    }

    /* renamed from: F */
    public int m39601F() {
        return this.fullScrnNotify;
    }

    /* renamed from: G */
    public String m39603G() {
        return this.fullScrnNotifyText;
    }

    /* renamed from: H */
    public String m39605H() {
        return this.insActvNotifyBtnText;
    }

    /* renamed from: I */
    public int m39607I() {
        return this.insActvNotifyCfg;
    }

    /* renamed from: J */
    public String m39609J() {
        return this.intent;
    }

    /* renamed from: K */
    public String m39610K() {
        return this.intentPackage;
    }

    /* renamed from: L */
    public Integer m39611L() {
        return this.hasPermission;
    }

    /* renamed from: M */
    public String m39612M() {
        return this.developerName;
    }

    /* renamed from: N */
    public String m39613N() {
        return this.pkgNameEncoded;
    }

    /* renamed from: O */
    public String m39614O() {
        return this.nextInstallWays;
    }

    /* renamed from: P */
    public int m39615P() {
        return this.checkSha256Flag;
    }

    /* renamed from: Q */
    public String m39616Q() {
        return this.actName;
    }

    /* renamed from: R */
    public int m39617R() {
        return this.appType;
    }

    /* renamed from: S */
    public int m39618S() {
        return this.autoOpenAfterInstall;
    }

    /* renamed from: T */
    public long m39619T() {
        return this.allAreaPopDelay;
    }

    /* renamed from: U */
    public int m39620U() {
        return this.popUpStyle;
    }

    /* renamed from: V */
    public String m39621V() {
        return this.installPermiText;
    }

    /* renamed from: W */
    public String m39622W() {
        return this.pureModeText;
    }

    /* renamed from: X */
    public String m39623X() {
        return this.installPureModeText;
    }

    /* renamed from: Y */
    public String m39624Y() {
        return this.contiBtn;
    }

    /* renamed from: Z */
    public String m39625Z() {
        return this.reservedPkgName;
    }

    /* renamed from: a */
    public String m39626a() {
        return this.packageName;
    }

    /* renamed from: aa */
    public int m39634aa() {
        return this.autoOpenAfterInstallV2;
    }

    /* renamed from: ab */
    public String m39635ab() {
        return this.dlOpenBtnText;
    }

    /* renamed from: b */
    public String m39636b() {
        return this.versionCode;
    }

    /* renamed from: c */
    public String m39641c() {
        return this.versionName;
    }

    /* renamed from: d */
    public String m39644d() {
        return this.url;
    }

    /* renamed from: e */
    public long m39647e() {
        return this.fileSize;
    }

    /* renamed from: f */
    public String m39650f() {
        return this.sha256;
    }

    /* renamed from: g */
    public String m39653g() {
        return this.secondUrl;
    }

    /* renamed from: h */
    public String m39656h() {
        return this.permissionUrl;
    }

    /* renamed from: i */
    public String m39659i() {
        return this.detailUrl;
    }

    /* renamed from: j */
    public String m39662j() {
        return this.appName;
    }

    /* renamed from: k */
    public List<Permission> m39664k() {
        return this.permissions;
    }

    /* renamed from: l */
    public String m39666l() {
        return this.priorInstallWay;
    }

    /* renamed from: m */
    public String m39668m() {
        return this.hot;
    }

    /* renamed from: n */
    public Long m39670n() {
        return this.rateNum;
    }

    /* renamed from: o */
    public Long m39672o() {
        return this.downloadNum;
    }

    /* renamed from: p */
    public String m39674p() {
        return this.downCountDesc;
    }

    /* renamed from: q */
    public String m39676q() {
        return TextUtils.isEmpty(this.contentBtnAction) ? this.priorInstallWay : this.contentBtnAction;
    }

    /* renamed from: r */
    public InstallConfig m39678r() {
        return this.installConfig;
    }

    /* renamed from: s */
    public String m39680s() {
        String str = this.permPromptForCard;
        return str == null ? "1" : str;
    }

    /* renamed from: t */
    public String m39682t() {
        String str = this.permPromptForLanding;
        return str == null ? "0" : str;
    }

    /* renamed from: u */
    public int m39684u() {
        return this.popUpAfterInstallNew;
    }

    /* renamed from: v */
    public String m39686v() {
        return this.popUpAfterInstallText;
    }

    /* renamed from: w */
    public String m39688w() {
        return this.channelInfo;
    }

    /* renamed from: x */
    public String m39690x() {
        return this.iconUrl;
    }

    /* renamed from: y */
    public int m39692y() {
        return this.channelInfoSaveLimit;
    }

    /* renamed from: z */
    public String m39694z() {
        return this.appDesc;
    }

    /* renamed from: A */
    public void m39592A(String str) {
        this.pkgNameEncoded = str;
    }

    /* renamed from: B */
    public void m39594B(String str) {
        this.nextInstallWays = str;
    }

    /* renamed from: C */
    public void m39596C(String str) {
        this.actName = str;
    }

    /* renamed from: D */
    public void m39598D(String str) {
        this.installPermiText = str;
    }

    /* renamed from: E */
    public void m39600E(String str) {
        this.pureModeText = str;
    }

    /* renamed from: F */
    public void m39602F(String str) {
        this.installPureModeText = str;
    }

    /* renamed from: G */
    public void m39604G(String str) {
        this.contiBtn = str;
    }

    /* renamed from: H */
    public void m39606H(String str) {
        this.reservedPkgName = str;
    }

    /* renamed from: I */
    public void m39608I(String str) {
        this.dlOpenBtnText = str;
    }

    /* renamed from: a */
    public void m39627a(int i10) {
        this.popUpAfterInstallNew = i10;
    }

    /* renamed from: b */
    public void m39637b(int i10) {
        this.channelInfoSaveLimit = i10;
    }

    /* renamed from: c */
    public void m39642c(int i10) {
        this.trafficReminder = i10;
    }

    /* renamed from: d */
    public void m39645d(int i10) {
        this.popNotify = i10;
    }

    /* renamed from: e */
    public void m39648e(int i10) {
        this.fullScrnNotify = i10;
    }

    /* renamed from: f */
    public void m39651f(int i10) {
        this.insActvNotifyCfg = i10;
    }

    /* renamed from: g */
    public void m39654g(int i10) {
        this.appType = i10;
    }

    /* renamed from: h */
    public void m39657h(int i10) {
        this.autoOpenAfterInstall = i10;
    }

    /* renamed from: i */
    public void m39660i(int i10) {
        this.autoOpenAfterInstallV2 = i10;
    }

    /* renamed from: j */
    public void m39663j(String str) {
        this.priorInstallWay = str;
    }

    /* renamed from: k */
    public void m39665k(String str) {
        this.hot = str;
    }

    /* renamed from: l */
    public void m39667l(String str) {
        this.downCountDesc = str;
    }

    /* renamed from: m */
    public void m39669m(String str) {
        this.contentBtnAction = str;
    }

    /* renamed from: n */
    public void m39671n(String str) {
        this.permPromptForCard = str;
    }

    /* renamed from: o */
    public void m39673o(String str) {
        this.permPromptForLanding = str;
    }

    /* renamed from: p */
    public void m39675p(String str) {
        this.popUpAfterInstallText = str;
    }

    /* renamed from: q */
    public void m39677q(String str) {
        this.channelInfo = str;
    }

    /* renamed from: r */
    public void m39679r(String str) {
        this.iconUrl = str;
    }

    /* renamed from: s */
    public void m39681s(String str) {
        this.appDesc = str;
    }

    /* renamed from: t */
    public void m39683t(String str) {
        this.dlBtnText = str;
    }

    /* renamed from: u */
    public void m39685u(String str) {
        this.afDlBtnText = str;
    }

    /* renamed from: v */
    public void m39687v(String str) {
        this.fullScrnNotifyText = str;
    }

    /* renamed from: w */
    public void m39689w(String str) {
        this.insActvNotifyBtnText = str;
    }

    /* renamed from: x */
    public void m39691x(String str) {
        this.intent = str;
    }

    /* renamed from: y */
    public void m39693y(String str) {
        this.intentPackage = str;
    }

    /* renamed from: z */
    public void m39695z(String str) {
        this.developerName = str;
    }

    /* renamed from: a */
    public void m39628a(long j10) {
        this.fileSize = j10;
    }

    /* renamed from: b */
    public void m39638b(long j10) {
        this.allAreaPopDelay = j10;
    }

    /* renamed from: c */
    public void m39643c(String str) {
        this.versionName = str;
    }

    /* renamed from: d */
    public void m39646d(String str) {
        this.url = str;
    }

    /* renamed from: e */
    public void m39649e(String str) {
        this.sha256 = str;
    }

    /* renamed from: f */
    public void m39652f(String str) {
        this.secondUrl = str;
    }

    /* renamed from: g */
    public void m39655g(String str) {
        this.permissionUrl = str;
    }

    /* renamed from: h */
    public void m39658h(String str) {
        this.detailUrl = str;
    }

    /* renamed from: i */
    public void m39661i(String str) {
        this.appName = str;
    }

    /* renamed from: a */
    public void m39629a(InstallConfig installConfig) {
        this.installConfig = installConfig;
    }

    /* renamed from: b */
    public void m39639b(Long l10) {
        this.downloadNum = l10;
    }

    /* renamed from: a */
    public void m39630a(Integer num) {
        this.hasPermission = num;
    }

    /* renamed from: b */
    public void m39640b(String str) {
        this.versionCode = str;
    }

    /* renamed from: a */
    public void m39631a(Long l10) {
        this.rateNum = l10;
    }

    /* renamed from: a */
    public void m39632a(String str) {
        this.packageName = str;
    }

    /* renamed from: a */
    public void m39633a(List<Permission> list) {
        this.permissions = list;
    }
}
