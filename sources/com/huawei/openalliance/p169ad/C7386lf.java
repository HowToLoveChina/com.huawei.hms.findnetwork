package com.huawei.openalliance.p169ad;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.activity.PPSNotificationActivity;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.AdShowExtras;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7830i;

/* renamed from: com.huawei.openalliance.ad.lf */
/* loaded from: classes8.dex */
public class C7386lf extends AbstractC7400lj {

    /* renamed from: c */
    private AppDownloadTask f34309c;

    /* renamed from: d */
    private AppInfo f34310d;

    public C7386lf(Context context, AppDownloadTask appDownloadTask) {
        super(context);
        this.f34309c = appDownloadTask;
        this.f34310d = appDownloadTask.m42222B();
    }

    /* renamed from: b */
    private PendingIntent m45473b(String str) {
        if (!m45475g()) {
            return null;
        }
        Intent intent = new Intent(this.f34416a, (Class<?>) PPSNotificationActivity.class);
        intent.setAction(str);
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.f34310d);
        AppDownloadTask appDownloadTask = this.f34309c;
        if (appDownloadTask != null) {
            intent.putExtra(AdShowExtras.DOWNLOAD_SOURCE, appDownloadTask.m42226F());
            if (this.f34309c.m42223C() != null) {
                intent.putExtra(MapKeyNames.CONTENT_RECORD, this.f34309c.m42223C().mo46574a());
            }
        }
        return PendingIntent.getActivity(this.f34416a, mo45477a(), intent, 201326592);
    }

    /* renamed from: g */
    private boolean m45475g() {
        AppInfo appInfo = this.f34310d;
        return (appInfo == null || TextUtils.isEmpty(appInfo.getPackageName())) ? false : true;
    }

    /* renamed from: h */
    private boolean m45476h() {
        AppInfo appInfo = this.f34310d;
        return (appInfo == null || appInfo.m44418o() != 1 || TextUtils.isEmpty(this.f34310d.m44394f())) ? false : true;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: a */
    public int mo45477a() {
        if (m45475g()) {
            return this.f34310d.getPackageName().hashCode();
        }
        return 1;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: c */
    public String mo45480c() {
        AppInfo appInfo = this.f34310d;
        return appInfo != null ? appInfo.getAppName() : "";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: d */
    public String mo45481d() {
        return "AppInstalledNotification";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: e */
    public String mo45482e() {
        AppInfo appInfo = this.f34310d;
        return appInfo != null ? AbstractC7806cz.m48168c(appInfo.m44394f()) : "";
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: f */
    public PendingIntent mo45483f() {
        return m45473b("com.huawei.ads.notification.action.CLICK");
    }

    /* renamed from: a */
    private PendingIntent m45472a(String str) {
        if (!m45475g()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setPackage(this.f34416a.getPackageName());
        intent.putExtra("type", 1);
        intent.putExtra("appInfo", this.f34310d);
        AppDownloadTask appDownloadTask = this.f34309c;
        if (appDownloadTask != null) {
            intent.putExtra(AdShowExtras.DOWNLOAD_SOURCE, appDownloadTask.m42226F());
            if (this.f34309c.m42223C() != null) {
                intent.putExtra(MapKeyNames.CONTENT_RECORD, this.f34309c.m42223C().mo46574a());
            }
        }
        return PendingIntent.getBroadcast(this.f34416a, mo45477a(), intent, 201326592);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: b */
    public void mo45479b() {
        if (m45476h()) {
            C7402ll.m45597a(this.f34416a).m45601a(this.f34310d.getPackageName());
            super.mo45479b();
            AppDownloadTask appDownloadTask = this.f34309c;
            if (appDownloadTask == null || appDownloadTask.m42223C() == null || !AbstractC7811dd.m48348x(this.f34416a)) {
                return;
            }
            new C6928i(this.f34416a).m39216c(this.f34309c.m42223C().mo46574a(), "0");
        }
    }

    /* renamed from: b */
    private void m45474b(Notification.Builder builder) {
        Context context;
        ApplicationInfo applicationInfo;
        Drawable drawableLoadIcon;
        if (!m45475g() || (context = this.f34416a) == null || (applicationInfo = C7830i.m48427b(context, this.f34310d.getPackageName()).applicationInfo) == null || (drawableLoadIcon = applicationInfo.loadIcon(this.f34416a.getPackageManager())) == null) {
            return;
        }
        builder.setLargeIcon(C7752az.m47684a(drawableLoadIcon));
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7400lj
    /* renamed from: a */
    public void mo45478a(Notification.Builder builder) {
        if (builder == null || !m45475g()) {
            return;
        }
        m45474b(builder);
        builder.setDeleteIntent(m45472a("com.huawei.ads.notification.action.DELETE"));
    }
}
