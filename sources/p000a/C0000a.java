package p000a;

import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: a.a */
/* loaded from: classes.dex */
public class C0000a {
    /* renamed from: a */
    public static boolean m0a(Context context) throws Settings.SettingNotFoundException {
        int i10;
        if ("CN".equalsIgnoreCase(GrsApp.getInstance().getIssueCountryCode(context))) {
            return true;
        }
        try {
            i10 = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
        } catch (Settings.SettingNotFoundException unused) {
            HMSLog.m36989w(Utils.TAG, "HiAnalyticsClient_report_oobe： NotFoundException");
            i10 = 0;
        }
        HMSLog.m36988i(Utils.TAG, "HiAnalyticsClient_report_oobe: " + i10);
        return i10 == 1;
    }
}
