package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.android.hms.ppskit.RemoteInstallReq;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ow */
/* loaded from: classes8.dex */
public class C7562ow {

    /* renamed from: a */
    private static final byte[] f35245a = new byte[0];

    /* renamed from: b */
    private static C7562ow f35246b;

    /* renamed from: c */
    private Context f35247c;

    /* renamed from: com.huawei.openalliance.ad.ow$a */
    public interface a {
        /* renamed from: a */
        void mo42336a();

        /* renamed from: a */
        void mo42337a(int i10);

        /* renamed from: b */
        void mo42338b();
    }

    private C7562ow(Context context) {
        if (context != null) {
            this.f35247c = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    public static C7562ow m46641a(Context context) {
        C7562ow c7562ow;
        synchronized (f35245a) {
            try {
                if (f35246b == null) {
                    f35246b = new C7562ow(context);
                }
                c7562ow = f35246b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7562ow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m46651b(final AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.m44397g())) {
            return;
        }
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ow.2
            @Override // java.lang.Runnable
            public void run() {
                C7485mt.m45865a(C7562ow.this.f35247c).m45867a(appInfo.getPackageName(), appInfo.m44397g(), appInfo.m44400h());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m46642a(AppInfo appInfo) {
        if (appInfo == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String strM44397g = appInfo.m44397g();
            if (!AbstractC7806cz.m48165b(strM44397g)) {
                jSONObject = new JSONObject(AbstractC7806cz.m48168c(strM44397g));
            }
            jSONObject.put("appType", appInfo.m44342B());
            return AbstractC7806cz.m48170d(jSONObject.toString());
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("InstallProcessor", "putAppTypeToChannel err: " + th2.getClass().getSimpleName());
            return appInfo.m44397g();
        }
    }

    /* renamed from: a */
    private void m46643a(AppInfo appInfo, final int i10, final a aVar) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ow.3
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(C7562ow.this.f35247c, i10, 0).show();
                aVar.mo42337a(6);
            }
        });
    }

    /* renamed from: a */
    public void m46652a(AppInfo appInfo, AppDownloadTask appDownloadTask, a aVar) {
        m46645a(appInfo, true, appDownloadTask, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m46644a(AppInfo appInfo, String str, AppDownloadTask appDownloadTask, a aVar) {
        if (aVar != null) {
            aVar.mo42338b();
        }
        if (appDownloadTask != null) {
            C7830i.m48418a(appDownloadTask, EventType.APPINSTALLSTART, 2);
            appDownloadTask.m42248d(2);
        }
        C7830i.m48415a(this.f35247c, str, appInfo.getPackageName());
    }

    /* renamed from: a */
    private void m46645a(final AppInfo appInfo, final boolean z10, final AppDownloadTask appDownloadTask, final a aVar) {
        if (appDownloadTask == null) {
            AbstractC7185ho.m43823c("InstallProcessor", "installApk task is null");
        } else {
            final String strM42068d = appDownloadTask.m42068d();
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ow.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C7562ow.this.m46648a(appInfo, strM42068d, aVar)) {
                        String strM42225E = appDownloadTask.m42225E();
                        if (z10 && "3".equals(strM42225E)) {
                            appDownloadTask.m42248d(3);
                            C7830i.m48418a(appDownloadTask, EventType.APPINSTALLSTART, 3);
                            C7562ow.this.m46651b(appInfo);
                            C7830i.m48416a(C7562ow.this.f35247c, strM42068d, appInfo.getPackageName(), aVar);
                            return;
                        }
                        if (!z10 || !"4".equals(strM42225E)) {
                            C7562ow.this.m46644a(appInfo, strM42068d, appDownloadTask, aVar);
                            return;
                        }
                        appDownloadTask.m42248d(4);
                        C7830i.m48418a(appDownloadTask, EventType.APPINSTALLSTART, 4);
                        C7830i.m48414a(C7562ow.this.f35247c, new RemoteInstallReq(appDownloadTask.m42233M(), Config.SDK_VERSION, appInfo.getPackageName(), appDownloadTask.m42234N(), C7562ow.this.m46642a(appInfo), appInfo.m44400h()), strM42068d, appInfo.getPackageName(), aVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m46648a(AppInfo appInfo, String str, a aVar) {
        String str2;
        int i10;
        if (AbstractC7731ae.m47458b(str)) {
            File file = new File(str);
            if (appInfo.getFileSize() != file.length()) {
                str2 = "installApkViaHiFolder, file size error";
            } else {
                if (!appInfo.isCheckSha256() || AbstractC7731ae.m47452a(appInfo.getSha256(), file)) {
                    return true;
                }
                str2 = "installApkViaHiFolder, file sha256 error";
            }
            AbstractC7185ho.m43823c("InstallProcessor", str2);
            AbstractC7731ae.m47466e(file);
            i10 = C6849R.string.hiad_download_file_corrupted;
        } else {
            AbstractC7185ho.m43823c("InstallProcessor", "installApkViaHiFolder, file not exist");
            i10 = C6849R.string.hiad_download_file_not_exist;
        }
        m46643a(appInfo, i10, aVar);
        return false;
    }
}
