package com.huawei.updatesdk.p191b.p198e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.appgallery.markethomecountrysdk.api.HomeCountryApi;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8778b;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.service.otaupdate.C8871f;
import java.util.List;
import java.util.concurrent.ExecutionException;
import p208cq.C8943k;

/* renamed from: com.huawei.updatesdk.b.e.a */
/* loaded from: classes9.dex */
public abstract class AbstractC8822a {

    /* renamed from: a */
    private String f45161a;

    /* renamed from: b */
    private String f45162b;

    /* renamed from: c */
    private void m56270c() {
        String str;
        Context contextM56133a = C8793a.m56132c().m56133a();
        try {
            String str2 = (String) C8943k.m56661a(HomeCountryApi.getHomeCountry(contextM56133a, "UpdateSDK", false));
            if (TextUtils.isEmpty(str2)) {
                m56272e(contextM56133a);
            } else {
                C8871f.m56464e().m56466a(str2);
            }
        } catch (InterruptedException unused) {
            str = "get country code InterruptedException";
            C8774a.m56008a("AbstractTaskInit", str);
            m56272e(contextM56133a);
        } catch (ExecutionException unused2) {
            str = "get country code ExecutionException.";
            C8774a.m56008a("AbstractTaskInit", str);
            m56272e(contextM56133a);
        }
    }

    /* renamed from: d */
    private String m56271d(Context context) {
        m56270c();
        String strM56465a = C8871f.m56464e().m56465a();
        if (!TextUtils.isEmpty(this.f45161a) && TextUtils.equals(this.f45161a, strM56465a) && !TextUtils.isEmpty(this.f45162b)) {
            C8774a.m56009b("AbstractTaskInit", "UpdateSDK Get url from cache!" + m56269b(this.f45162b));
            return this.f45162b;
        }
        this.f45161a = strM56465a;
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(strM56465a);
        this.f45162b = new GrsClient(context, grsBaseInfo).synGetGrsUrl(mo56274a(), "ROOT");
        C8774a.m56009b("AbstractTaskInit", "UpdateSDK Get url from GRS_SDK Success!" + m56269b(this.f45162b));
        if (!TextUtils.isEmpty(this.f45162b)) {
            return this.f45162b;
        }
        C8774a.m56009b("AbstractTaskInit", "UpdateSDK Get url is default url");
        return mo56275a(context);
    }

    /* renamed from: e */
    private void m56272e(Context context) {
        String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(context);
        C8774a.m56009b("AbstractTaskInit", "UpdateSDK use grs issue country code");
        C8871f.m56464e().m56466a(issueCountryCode);
    }

    /* renamed from: a */
    public abstract int mo56273a(Context context, String str);

    /* renamed from: a */
    public abstract String mo56274a();

    /* renamed from: a */
    public abstract String mo56275a(Context context);

    /* renamed from: a */
    public void mo56276a(String str) {
    }

    /* renamed from: a */
    public abstract void mo56277a(List<String> list);

    /* renamed from: b */
    public abstract String mo56278b();

    /* renamed from: b */
    public String m56279b(Context context) {
        if (!TextUtils.equals("SECURITY", C8778b.m56031a())) {
            return m56271d(context);
        }
        C8774a.m56009b("AbstractTaskInit", "UpdateSDK Get url is security url");
        return mo56275a(context);
    }

    /* renamed from: c */
    public abstract boolean mo56280c(Context context);

    /* renamed from: b */
    private String m56269b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.substring(0, str.indexOf(46));
        } catch (Exception e10) {
            C8777a.m56028b("AbstractTaskInit", e10.toString());
            return null;
        }
    }
}
