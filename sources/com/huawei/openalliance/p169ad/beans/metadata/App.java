package com.huawei.openalliance.p169ad.beans.metadata;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.C7830i;

@DataKeep
/* loaded from: classes8.dex */
public class App {
    private static final String TAG = "App";
    private Integer brand;
    private String country;
    private AppExt ext;
    private String hostPkgname;
    private String lang;
    private String lmt;

    @InterfaceC6929a
    private String mediaContent;
    private Integer mediaGpsOn;
    private String name;
    private String pkgname;
    private String sign;
    private Integer systemFlag;
    private String verCode;
    private String version;

    public App() {
    }

    public App(Context context) {
        this.pkgname = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return;
        }
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.pkgname, 128);
            this.version = packageInfo.versionName;
            this.name = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            this.brand = HiAd.m44014a(context).mo44057j();
            this.lmt = interfaceC7146gcM43316b.mo43379bF();
            this.sign = C7830i.m48435e(context, this.pkgname);
        } catch (PackageManager.NameNotFoundException unused) {
            AbstractC7185ho.m43823c(TAG, "fail to get packageInfo");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(TAG, "fail to get packageInfo: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public String m39697a() {
        return this.version;
    }

    /* renamed from: b */
    public String m39701b() {
        return this.name;
    }

    /* renamed from: c */
    public String m39704c() {
        return this.pkgname;
    }

    /* renamed from: d */
    public String m39706d() {
        return this.mediaContent;
    }

    /* renamed from: e */
    public String m39708e() {
        return this.lang;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof App) {
            App app = (App) obj;
            if (!TextUtils.isEmpty(app.pkgname) && app.pkgname.equals(this.pkgname)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public String m39710f() {
        return this.country;
    }

    /* renamed from: g */
    public Integer m39712g() {
        return this.systemFlag;
    }

    /* renamed from: h */
    public String m39713h() {
        return this.lmt;
    }

    public int hashCode() {
        String str = this.pkgname;
        return str == null ? super.hashCode() : str.hashCode();
    }

    /* renamed from: i */
    public Integer m39714i() {
        return this.brand;
    }

    /* renamed from: j */
    public String m39715j() {
        return this.verCode;
    }

    /* renamed from: k */
    public Integer m39716k() {
        return this.mediaGpsOn;
    }

    /* renamed from: l */
    public AppExt m39717l() {
        return this.ext;
    }

    /* renamed from: m */
    public String m39718m() {
        return this.sign;
    }

    /* renamed from: n */
    public String m39719n() {
        return this.hostPkgname;
    }

    public App(Context context, com.huawei.openalliance.p169ad.beans.parameter.App app) {
        if (app == null) {
            return;
        }
        m39696a(context, app.getPkgname());
        if (app.getBrand() != null) {
            this.brand = app.getBrand();
        }
        if (TextUtils.isEmpty(this.name)) {
            this.name = app.getName();
        }
        if (TextUtils.isEmpty(this.version)) {
            this.version = app.getVersion();
        }
        if (TextUtils.isEmpty(this.hostPkgname)) {
            this.hostPkgname = app.getHostPkgname();
        }
        this.lmt = C7124fh.m43316b(context).mo43379bF();
    }

    /* renamed from: a */
    private void m39696a(Context context, String str) {
        this.pkgname = str;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.version = context.getPackageManager().getPackageInfo(str, 128).versionName;
            this.systemFlag = Integer.valueOf(AbstractC7807d.m48222b(context, str) ? 1 : 0);
            this.sign = C7830i.m48435e(context, str);
        } catch (PackageManager.NameNotFoundException unused) {
            AbstractC7185ho.m43823c(TAG, "fail to get packageInfo");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c(TAG, "fail to get packageInfo: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    public void m39702b(Integer num) {
        this.mediaGpsOn = num;
    }

    /* renamed from: c */
    public void m39705c(String str) {
        this.mediaContent = str;
    }

    /* renamed from: d */
    public void m39707d(String str) {
        this.lang = str;
    }

    /* renamed from: e */
    public void m39709e(String str) {
        this.country = str;
    }

    /* renamed from: f */
    public void m39711f(String str) {
        this.verCode = str;
    }

    public App(Context context, String str) {
        m39696a(context, str);
    }

    /* renamed from: a */
    public void m39698a(AppExt appExt) {
        this.ext = appExt;
    }

    /* renamed from: b */
    public void m39703b(String str) {
        this.pkgname = str;
    }

    /* renamed from: a */
    public void m39699a(Integer num) {
        this.brand = num;
    }

    /* renamed from: a */
    public void m39700a(String str) {
        this.version = str;
    }
}
