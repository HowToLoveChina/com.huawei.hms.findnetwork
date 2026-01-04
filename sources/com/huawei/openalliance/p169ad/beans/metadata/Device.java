package com.huawei.openalliance.p169ad.beans.metadata;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC6998co;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6935g;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7816di;
import com.huawei.openalliance.p169ad.utils.C7726a;
import com.huawei.openalliance.p169ad.utils.C7739am;
import com.huawei.openalliance.p169ad.utils.C7787cg;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.util.List;
import java.util.Locale;

@DataKeep
/* loaded from: classes8.dex */
public class Device {
    private static final String TAG = "Device";

    @InterfaceC6935g
    private String adid;
    private Integer adsLoc;
    private String agCountryCode;

    @InterfaceC6935g
    private String agcAaid;

    @InterfaceC6929a
    private String androidid;
    private List<App> appList;
    private String belongCountry;
    private String brand;
    private String brandCust;
    private String buildVersion;
    private String clientTime;
    private int dpi;
    private Integer emuiSdkInt;
    private String emuiVer;
    private Integer encodingMode;
    private Long freeDiskSize;
    private Long freeSdcardSize;

    @InterfaceC6935g
    private String gaid;
    private String gaidTrackingEnabled;
    private Integer gpsOn;

    @InterfaceC6929a
    private String groupId;
    private int height;
    private Integer hmSdkInt;
    private String hmVer;
    private Integer hmftype;

    @InterfaceC6929a
    private List<String> insApps;
    private boolean isChinaROM;
    private String isTrackingEnabled;
    private String language;
    private String localeCountry;
    private String mVer;
    private String magicUIVer;
    private String maker;
    private String model;
    private String oVer;

    @InterfaceC6935g
    private String oaid;
    private String partnerChannel;
    private float pxratio;
    private String roLocale;
    private String roLocaleCountry;
    private String routerCountry;
    private String script;
    private Integer sdkType;
    private String simCountryIso;
    private Long totalDiskSize;
    private Long totalSdcardSize;
    private String tvModel;

    @InterfaceC6935g
    private String udid;
    private List<App> uninstalledPreAppList;
    private String useragent;

    @InterfaceC6935g
    private String uuid;
    private String vVer;
    private String vendor;
    private String vendorCountry;
    private String verCodeOfAG;
    private String verCodeOfHms;
    private String verCodeOfHsf;
    private String version;
    private int width;
    private int type = 4;

    /* renamed from: os */
    private String f32010os = OsType.ANDROID;
    private DeviceExt ext = new DeviceExt();

    public Device() {
    }

    /* renamed from: A */
    public String m40079A() {
        return this.gaidTrackingEnabled;
    }

    /* renamed from: B */
    public String m40080B() {
        return this.uuid;
    }

    /* renamed from: C */
    public String m40081C() {
        return this.vendorCountry;
    }

    /* renamed from: D */
    public String m40082D() {
        return this.roLocaleCountry;
    }

    /* renamed from: E */
    public String m40083E() {
        return this.routerCountry;
    }

    /* renamed from: F */
    public String m40084F() {
        return this.roLocale;
    }

    /* renamed from: G */
    public Long m40085G() {
        return this.totalDiskSize;
    }

    /* renamed from: H */
    public Long m40086H() {
        return this.freeDiskSize;
    }

    /* renamed from: I */
    public Long m40087I() {
        return this.totalSdcardSize;
    }

    /* renamed from: J */
    public Long m40088J() {
        return this.freeSdcardSize;
    }

    /* renamed from: K */
    public String m40089K() {
        return this.verCodeOfAG;
    }

    /* renamed from: L */
    public String m40090L() {
        return this.agCountryCode;
    }

    /* renamed from: M */
    public String m40091M() {
        return this.vendor;
    }

    /* renamed from: N */
    public Integer m40092N() {
        return this.gpsOn;
    }

    /* renamed from: O */
    public Integer m40093O() {
        return this.adsLoc;
    }

    /* renamed from: P */
    public String m40094P() {
        return this.mVer;
    }

    /* renamed from: Q */
    public String m40095Q() {
        return this.vVer;
    }

    /* renamed from: R */
    public String m40096R() {
        return this.oVer;
    }

    /* renamed from: S */
    public String m40097S() {
        return this.brand;
    }

    /* renamed from: T */
    public String m40098T() {
        return this.script;
    }

    /* renamed from: U */
    public Integer m40099U() {
        return this.emuiSdkInt;
    }

    /* renamed from: V */
    public String m40100V() {
        return this.brandCust;
    }

    /* renamed from: W */
    public String m40101W() {
        return this.partnerChannel;
    }

    /* renamed from: X */
    public List<String> m40102X() {
        return this.insApps;
    }

    /* renamed from: Y */
    public Integer m40103Y() {
        return this.encodingMode;
    }

    /* renamed from: Z */
    public String m40104Z() {
        return this.hmVer;
    }

    /* renamed from: a */
    public int m40105a() {
        return this.type;
    }

    /* renamed from: aa */
    public Integer m40111aa() {
        return this.hmftype;
    }

    /* renamed from: ab */
    public Integer m40112ab() {
        return this.hmSdkInt;
    }

    /* renamed from: ac */
    public String m40113ac() {
        return this.agcAaid;
    }

    /* renamed from: ad */
    public DeviceExt m40114ad() {
        return this.ext;
    }

    /* renamed from: ae */
    public String m40115ae() {
        return this.groupId;
    }

    /* renamed from: af */
    public List<App> m40116af() {
        return this.uninstalledPreAppList;
    }

    /* renamed from: ag */
    public boolean m40117ag() {
        return this.isChinaROM;
    }

    /* renamed from: ah */
    public List<App> m40118ah() {
        return this.appList;
    }

    /* renamed from: ai */
    public Integer m40119ai() {
        return this.sdkType;
    }

    /* renamed from: aj */
    public String m40120aj() {
        return this.adid;
    }

    /* renamed from: b */
    public String m40121b() {
        return this.f32010os;
    }

    /* renamed from: c */
    public String m40125c() {
        return this.version;
    }

    /* renamed from: d */
    public String m40128d() {
        return this.maker;
    }

    /* renamed from: e */
    public String m40130e() {
        return this.model;
    }

    /* renamed from: f */
    public int m40132f() {
        return this.width;
    }

    /* renamed from: g */
    public int m40134g() {
        return this.height;
    }

    /* renamed from: h */
    public String m40136h() {
        return this.language;
    }

    /* renamed from: i */
    public String m40138i() {
        return this.androidid;
    }

    /* renamed from: j */
    public String m40140j() {
        return this.buildVersion;
    }

    /* renamed from: k */
    public String m40142k() {
        return this.tvModel;
    }

    /* renamed from: l */
    public int m40144l() {
        return this.dpi;
    }

    /* renamed from: m */
    public float m40145m() {
        return this.pxratio;
    }

    /* renamed from: n */
    public String m40146n() {
        return this.useragent;
    }

    /* renamed from: o */
    public String m40147o() {
        return this.udid;
    }

    /* renamed from: p */
    public String m40148p() {
        return this.oaid;
    }

    /* renamed from: q */
    public String m40149q() {
        return this.isTrackingEnabled;
    }

    /* renamed from: r */
    public String m40150r() {
        return this.verCodeOfHsf;
    }

    /* renamed from: s */
    public String m40151s() {
        return this.emuiVer;
    }

    /* renamed from: t */
    public String m40152t() {
        return this.magicUIVer;
    }

    /* renamed from: u */
    public String m40153u() {
        return this.verCodeOfHms;
    }

    /* renamed from: v */
    public String m40154v() {
        return this.localeCountry;
    }

    /* renamed from: w */
    public String m40155w() {
        return this.simCountryIso;
    }

    /* renamed from: x */
    public String m40156x() {
        return this.belongCountry;
    }

    /* renamed from: y */
    public String m40157y() {
        return this.clientTime;
    }

    /* renamed from: z */
    public String m40158z() {
        return this.gaid;
    }

    public Device(Context context, int i10, int i11, int i12, boolean z10) {
        this.isChinaROM = C6982bz.m41148a(context).mo41175d();
        m40076a(context, z10);
        m40107a(context, i10, i11, i12);
    }

    /* renamed from: b */
    private void m40077b(Context context) {
        this.hmVer = C7845x.m48583m(context);
        if (C7739am.m47524a(context)) {
            this.hmftype = 1;
            this.f32010os = C7739am.m47522a();
        }
        this.hmSdkInt = C7739am.m47529b(context);
    }

    /* renamed from: c */
    private void m40078c(Context context) {
        String strM48136f = AbstractC7803cw.m48136f(context);
        if (!TextUtils.isEmpty(strM48136f)) {
            this.totalDiskSize = AbstractC7731ae.m47463d(strM48136f);
            this.freeDiskSize = AbstractC7731ae.m47459c(strM48136f);
        }
        String strM48137g = AbstractC7803cw.m48137g(context);
        if (TextUtils.isEmpty(strM48137g)) {
            return;
        }
        this.totalSdcardSize = AbstractC7731ae.m47463d(strM48137g);
        this.freeSdcardSize = AbstractC7731ae.m47459c(strM48137g);
    }

    /* renamed from: a */
    public void m40106a(Context context) {
        InterfaceC6998co interfaceC6998coM41148a = C6982bz.m41148a(context);
        this.version = Build.VERSION.RELEASE;
        this.maker = interfaceC6998coM41148a.mo41181j();
        this.brand = interfaceC6998coM41148a.mo41182k();
        String strMo41173b = interfaceC6998coM41148a.mo41173b();
        this.model = strMo41173b;
        if (strMo41173b != null) {
            this.model = strMo41173b.toUpperCase(Locale.ENGLISH);
        }
        this.language = AbstractC7807d.m48204a();
        this.script = AbstractC7807d.m48218b();
        this.emuiVer = interfaceC6998coM41148a.mo41176e();
        this.emuiSdkInt = interfaceC6998coM41148a.mo41179h();
        this.magicUIVer = interfaceC6998coM41148a.mo41180i();
        this.verCodeOfHsf = AbstractC7807d.m48249l(context);
        this.verCodeOfHms = AbstractC7807d.m48250m(context);
        this.verCodeOfAG = AbstractC7807d.m48251n(context);
        this.agCountryCode = AbstractC7807d.m48252o(context);
        this.localeCountry = AbstractC7811dd.m48322d();
        this.simCountryIso = AbstractC7811dd.m48324e(context);
        this.roLocaleCountry = AbstractC7806cz.m48183l(AbstractC7811dd.m48289a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP));
        this.roLocale = AbstractC7806cz.m48183l(AbstractC7811dd.m48289a("ro.product.locale"));
        this.vendorCountry = AbstractC7806cz.m48183l(AbstractC7811dd.m48289a(CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP));
        this.vendor = AbstractC7806cz.m48183l(AbstractC7811dd.m48289a(CountryCodeBean.VENDOR_SYSTEMPROP));
        this.type = C7845x.m48577k(context);
        this.sdkType = AbstractC7807d.m48190A(context);
        m40077b(context);
    }

    /* renamed from: d */
    public void m40129d(String str) {
        this.isTrackingEnabled = str;
    }

    /* renamed from: e */
    public void m40131e(String str) {
        this.gaid = str;
    }

    /* renamed from: f */
    public void m40133f(String str) {
        this.gaidTrackingEnabled = str;
    }

    /* renamed from: g */
    public void m40135g(String str) {
        this.uuid = str;
    }

    /* renamed from: h */
    public void m40137h(String str) {
        this.agCountryCode = str;
    }

    /* renamed from: i */
    public void m40139i(String str) {
        this.agcAaid = str;
    }

    /* renamed from: j */
    public void m40141j(String str) {
        this.groupId = str;
    }

    /* renamed from: k */
    public void m40143k(String str) {
        this.adid = str;
    }

    public Device(Context context, boolean z10) {
        this.isChinaROM = C6982bz.m41148a(context).mo41175d();
        m40076a(context, z10);
    }

    /* renamed from: a */
    public final void m40107a(Context context, int i10, int i11, int i12) {
        this.width = i10;
        this.height = i11;
        this.language = AbstractC7807d.m48204a();
        this.script = AbstractC7807d.m48218b();
        this.type = i12;
        this.localeCountry = AbstractC7811dd.m48322d();
        this.simCountryIso = AbstractC7811dd.m48324e(context);
        this.belongCountry = C7124fh.m43316b(context).mo43422bw();
        this.clientTime = AbstractC7816di.m48360a();
        this.routerCountry = C6982bz.m41148a(context).mo41186o();
        this.appList = C7124fh.m43316b(context).mo43381bH();
        this.ext.m40161a(C7787cg.m47900a(context).m47935N());
        if (this.isChinaROM) {
            String strM48559f = C7845x.m48559f();
            if (TextUtils.isEmpty(strM48559f)) {
                return;
            }
            this.ext.m40163b(strM48559f);
        }
    }

    /* renamed from: b */
    public void m40122b(Integer num) {
        this.adsLoc = num;
    }

    /* renamed from: c */
    public void m40126c(Integer num) {
        this.encodingMode = num;
    }

    /* renamed from: a */
    private void m40076a(Context context, boolean z10) {
        InterfaceC6998co interfaceC6998coM41148a = C6982bz.m41148a(context);
        this.dpi = AbstractC7807d.m48243i(context);
        this.pxratio = AbstractC7807d.m48245j(context);
        this.roLocale = AbstractC7806cz.m48183l(AbstractC7811dd.m48289a("ro.product.locale"));
        this.version = Build.VERSION.RELEASE;
        this.maker = interfaceC6998coM41148a.mo41181j();
        this.brand = interfaceC6998coM41148a.mo41182k();
        String strMo41173b = interfaceC6998coM41148a.mo41173b();
        this.model = strMo41173b;
        if (strMo41173b != null) {
            this.model = strMo41173b.toUpperCase(Locale.ENGLISH);
        }
        this.buildVersion = interfaceC6998coM41148a.mo41174c();
        this.useragent = AbstractC7807d.m48247k(context);
        this.verCodeOfHsf = AbstractC7807d.m48249l(context);
        this.emuiVer = interfaceC6998coM41148a.mo41176e();
        this.magicUIVer = interfaceC6998coM41148a.mo41180i();
        this.verCodeOfHms = AbstractC7807d.m48250m(context);
        this.verCodeOfAG = AbstractC7807d.m48251n(context);
        this.brandCust = AbstractC7807d.m48259v(context);
        this.partnerChannel = AbstractC7811dd.m48289a(Constants.PROPERTY_CHANNEL);
        if (z10 && this.isChinaROM && !C6982bz.m41152b(context)) {
            this.androidid = AbstractC7807d.m48239g(context);
        }
        if (this.isChinaROM) {
            String strM48554e = C7845x.m48554e();
            if (!TextUtils.isEmpty(strM48554e)) {
                this.ext.m40160a(strM48554e);
            }
        }
        if (z10) {
            this.udid = AbstractC7807d.m48241h(context);
            this.uuid = AbstractC7807d.m48208a(context, true);
        }
        AbstractC7806cz.m48183l(interfaceC6998coM41148a.mo41188q());
        this.vendor = AbstractC7806cz.m48183l(interfaceC6998coM41148a.mo41187p());
        this.roLocaleCountry = AbstractC7806cz.m48183l(AbstractC7811dd.m48289a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP));
        if (this.isChinaROM) {
            this.agcAaid = C7726a.m47420a(context);
        }
        this.sdkType = AbstractC7807d.m48190A(context);
        m40077b(context);
        m40078c(context);
    }

    /* renamed from: b */
    public void m40123b(String str) {
        this.udid = str;
    }

    /* renamed from: c */
    public void m40127c(String str) {
        this.oaid = str;
    }

    /* renamed from: a */
    public void m40108a(Integer num) {
        this.gpsOn = num;
    }

    /* renamed from: b */
    public void m40124b(List<App> list) {
        this.uninstalledPreAppList = list;
    }

    /* renamed from: a */
    public void m40109a(String str) {
        this.androidid = str;
    }

    /* renamed from: a */
    public void m40110a(List<String> list) {
        this.insApps = list;
    }
}
