package p778xk;

import android.database.SQLException;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.service.C5019m;
import java.io.File;
import p015ak.C0213f;
import p783xp.C13843a;

/* renamed from: xk.e */
/* loaded from: classes6.dex */
public class C13824e {

    /* renamed from: a */
    public C5019m f62036a;

    /* renamed from: b */
    public String f62037b;

    /* renamed from: xk.e$b */
    public static class b {

        /* renamed from: a */
        public static C13824e f62038a = new C13824e();
    }

    /* renamed from: e */
    public static C13824e m82943e() {
        return b.f62038a;
    }

    /* renamed from: a */
    public void m82944a() throws SQLException {
        NotifyLogger.m29915i("NoticesConfigManager", "clear all files");
        m82945b();
        m82946c();
        m82947d();
    }

    /* renamed from: b */
    public final void m82945b() throws SQLException {
        C13825f c13825f = new C13825f();
        c13825f.clearLanguageDb();
        c13825f.clearLangVersionAndResult();
        c13825f.clearCurrentLanguageDownloadResult();
        c13825f.deleteLanguageFile();
    }

    /* renamed from: c */
    public final void m82946c() {
        NotifyLogger.m29915i("NoticesConfigManager", "delete cached pictures");
        C13843a.m83085g(m82948f());
    }

    /* renamed from: d */
    public final void m82947d() {
        File file = new File(this.f62036a.getConfigFilePath());
        if (!file.exists() || file.delete()) {
            return;
        }
        NotifyLogger.m29914e("NoticesConfigManager", "delete config file failed");
    }

    /* renamed from: f */
    public String m82948f() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append("campaignNotices");
        sb2.append(str);
        return sb2.toString();
    }

    public C13824e() {
        this.f62036a = null;
        this.f62036a = new C5019m(null);
        this.f62037b = "HiCloudCampaignNotices";
    }
}
