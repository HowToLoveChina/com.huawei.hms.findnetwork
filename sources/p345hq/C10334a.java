package p345hq;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hwcloudjs.p165g.C6664a;
import java.util.HashMap;
import java.util.Map;
import p640sq.C12824c;
import p640sq.C12836o;

/* renamed from: hq.a */
/* loaded from: classes8.dex */
public final class C10334a {

    /* renamed from: a */
    public static C10334a f50018a;

    /* renamed from: b */
    public static GrsClient f50019b;

    /* renamed from: a */
    public static synchronized C10334a m63642a() {
        try {
            if (f50018a == null) {
                f50018a = new C10334a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f50018a;
    }

    /* renamed from: b */
    public Map<String, String> m63643b(Context context, String str, String str2) {
        m63644c(context, str);
        GrsClient grsClient = f50019b;
        return grsClient == null ? new HashMap() : grsClient.synGetGrsUrls(str2);
    }

    /* renamed from: c */
    public final void m63644c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77097b("HmsGrsApiManager", "initGrsClient grsAppName is empty", true);
            return;
        }
        C12836o.m77097b("HmsGrsApiManager", "initGrsClient grsAppName is " + str, false);
        if (f50019b == null) {
            f50019b = new GrsClient(context, m63645d(context, str));
        }
    }

    /* renamed from: d */
    public final GrsBaseInfo m63645d(Context context, String str) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setAndroidVersion(C12824c.m76982D(Build.VERSION.RELEASE));
        grsBaseInfo.setDeviceModel(C12824c.m76982D(Build.MODEL));
        grsBaseInfo.setRomVersion(C12824c.m76982D(C12824c.m76997S()));
        grsBaseInfo.setAppName(C12824c.m76982D(str));
        String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(context);
        if (TextUtils.isEmpty(issueCountryCode)) {
            issueCountryCode = "CN";
        }
        grsBaseInfo.setSerCountry(issueCountryCode);
        return grsBaseInfo;
    }

    /* renamed from: e */
    public String m63646e(Context context, String str, String str2) {
        String strSynGetGrsUrl = new GrsClient(context, m63645d(context, C6664a.f30905c)).synGetGrsUrl(str, str2);
        return TextUtils.isEmpty(strSynGetGrsUrl) ? "" : strSynGetGrsUrl;
    }
}
