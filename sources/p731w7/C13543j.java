package p731w7;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.hihttp.rest.Response;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import p015ak.C0241z;
import p031b7.C1120a;
import p701v6.AbstractC13354a;
import p701v6.C13359f;

/* renamed from: w7.j */
/* loaded from: classes2.dex */
public class C13543j {
    /* renamed from: a */
    public <T> Response<T> m81470a(AbstractC13539f<?, T> abstractC13539f) {
        String string;
        String strM80149b;
        int iM81459x;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AbstractC13354a abstractC13354aM81456u = abstractC13539f.m81456u();
        String strMo76565p = null;
        if (abstractC13354aM81456u == null) {
            C1120a.m6676e("RestProtocol", "httpClientRequest is null!");
            return null;
        }
        try {
            strMo76565p = abstractC13354aM81456u.mo76565p();
            strM80149b = "0";
            string = "OK";
        } catch (C13359f e10) {
            C1120a.m6676e("RestProtocol", abstractC13539f.m81457v() + " ReportException:" + e10.toString());
            strM80149b = e10.m80149b();
            string = e10.getMessage();
        } catch (Exception e11) {
            C1120a.m6676e("RestProtocol", e11.toString());
            string = e11.toString();
            strM80149b = "1007";
        }
        try {
            iM81459x = C0241z.m1685c(strM80149b);
        } catch (NumberFormatException unused) {
            C1120a.m6676e("RestProtocol", "String trans to Integer error");
            iM81459x = 2000;
        }
        int iM80110i = iM81459x == 0 ? abstractC13354aM81456u.m80110i() : iM81459x;
        T tMo81440A = abstractC13539f.mo81440A(iM80110i, strMo76565p, string);
        if (abstractC13539f.m81433p()) {
            C1120a.m6678w("RestProtocol", "request isCanceled");
            return new C13545l(abstractC13539f, tMo81440A, SystemClock.elapsedRealtime() - jElapsedRealtime);
        }
        if (iM80110i == 200 && (abstractC13539f.m81454s() == 402 || abstractC13539f.m81454s() == 401)) {
            tMo81440A = abstractC13539f.mo81440A(iM80110i, abstractC13539f.m81458w().atInvalid(abstractC13354aM81456u), string);
        }
        C13545l c13545l = new C13545l(abstractC13539f, tMo81440A, SystemClock.elapsedRealtime() - jElapsedRealtime);
        int iM81454s = iM80110i == 200 ? abstractC13539f.m81454s() : iM81459x;
        if (iM80110i == 200) {
            iM81459x = abstractC13539f.m81459x();
        }
        int i10 = iM81459x;
        if (iM80110i == 200) {
            string = abstractC13539f.m81455t();
        }
        abstractC13539f.m81458w().opsReport(abstractC13539f.m81461z(), i10, string, abstractC13539f.m81457v(), c13545l.mo15150b());
        String strM15201z = SyncSessionManager.m15153t().m15201z();
        if (!TextUtils.isEmpty(strM15201z) && strM15201z.equals(abstractC13539f.m81461z())) {
            String str = abstractC13539f.m81457v() + "_" + iM81454s + "_" + string;
            C1120a.m6675d("RestProtocol", "serverErrorMsg: " + str);
            SyncSessionManager.m15153t().m15179c(strM15201z, str);
        }
        return c13545l;
    }
}
