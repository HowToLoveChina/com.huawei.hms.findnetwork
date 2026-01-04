package p315gj;

import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.ExchangePackageReq;
import com.huawei.cloud.pay.model.ExchangePackageResp;
import com.huawei.cloud.pay.model.GetAllTicketsResp;
import com.huawei.cloud.pay.model.Response;
import com.huawei.cloud.pay.model.reward.GetRewardReq;
import com.huawei.cloud.pay.model.reward.GetRewardsResp;
import com.huawei.hicloud.bean.DispatchCampaignActivityResp;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import fj.C9718g;
import fk.C9720a;
import fk.C9721b;
import java.io.IOException;
import java.util.HashMap;
import p015ak.C0213f;
import p054cj.C1442a;
import p265ep.C9530a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11281d;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;
import p778xk.C13823d;
import tm.C13040c;

/* renamed from: gj.b */
/* loaded from: classes5.dex */
public class C9949b {

    /* renamed from: b */
    public static final Gson f48720b = new Gson();

    /* renamed from: a */
    public String f48721a = "";

    /* renamed from: gj.b$a */
    public static class a {

        /* renamed from: a */
        public static C9949b f48722a = new C9949b();
    }

    /* renamed from: j */
    public static C9949b m61704j() {
        return a.f48722a;
    }

    /* renamed from: a */
    public String m61705a(String str, String str2, String str3, String str4, String str5) throws C9721b {
        C11060c c11060cM66626a = C11058a.m66626a(str4, str, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66644J(C13452e.m80781L().m80971t0());
        c11060cM66626a.m66664t(str);
        HashMap map = new HashMap();
        try {
            String strM59527d = C9530a.m59524b().m59527d(map);
            this.f48721a = strM59527d;
            return m61717n(str, strM59527d, str2, c11060cM66626a, str3, null, str5);
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
        }
    }

    /* renamed from: b */
    public Response m61706b(C11060c c11060c, String str) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CampaignService", "campaignReportAfterMsgTask reqBody is empty");
            return null;
        }
        m61722s(c11060c, "/reportAfterMsg");
        HashMap map = new HashMap();
        try {
            try {
                String strM59527d = C9530a.m59524b().m59527d(map);
                this.f48721a = strM59527d;
                return (Response) m61709e(m61716m("/reportAfterMsg", strM59527d, str, c11060c, "POST", null), Response.class);
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignService", "campaignReportAfterMsgTask err. " + e10.m60659c() + " " + e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "campaignReportAfterMsgTask err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: c */
    public ExchangePackageResp m61707c(C11060c c11060c, String str, ChannelInfo channelInfo, long j10, int i10) throws C9721b {
        String str2 = "/rewards/" + str + "/exchangePackage";
        String string = new ExchangePackageReq(str2, channelInfo, j10, i10).toString();
        m61722s(c11060c, str2);
        HashMap map = new HashMap();
        try {
            try {
                String strM59527d = C9530a.m59524b().m59527d(map);
                this.f48721a = strM59527d;
                return (ExchangePackageResp) m61709e(m61716m(str2, strM59527d, string, c11060c, "POST", null), ExchangePackageResp.class);
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignService", "exchangePackage err. " + e10.m60659c() + " " + e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "exchangePackage err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: d */
    public final String m61708d(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: e */
    public <T> T m61709e(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f48720b.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10);
        }
    }

    /* renamed from: f */
    public GetAllTicketsResp m61710f(C11060c c11060c, String str, String str2, String str3) throws C9721b {
        String strM67708b = C11281d.m67708b(str, str2, str3);
        m61722s(c11060c, "/activities/tickets");
        HashMap map = new HashMap();
        try {
            try {
                try {
                    String strM59527d = C9530a.m59524b().m59527d(map);
                    this.f48721a = strM59527d;
                    return (GetAllTicketsResp) m61709e(m61716m("/activities/tickets", strM59527d, strM67708b, c11060c, "GET", null), GetAllTicketsResp.class);
                } catch (C9721b e10) {
                    C1442a.m8289e("CampaignService", "getAllTickets err. " + e10.m60659c() + " " + e10.getMessage());
                    throw e10;
                }
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "getAllTickets err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: g */
    public DispatchCampaignActivityResp m61711g(C11060c c11060c, String str, String str2, String str3) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CampaignService", "getCampaignActivityDispatch reqBody is empty");
            return null;
        }
        m61722s(c11060c, str2);
        HashMap map = new HashMap();
        try {
            try {
                String strM59527d = C9530a.m59524b().m59527d(map);
                this.f48721a = strM59527d;
                return (DispatchCampaignActivityResp) m61709e(m61716m(str2, strM59527d, str, c11060c, "POST", str3), DispatchCampaignActivityResp.class);
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignService", "getCampaignActivityDispatch err. " + e10.m60659c() + " " + e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "getCampaignActivityDispatch err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: h */
    public GetCampaignActivityEntryResp m61712h(C11060c c11060c, int i10) throws C9721b, IOException {
        String strM60634n = C9718g.m60602t().m60634n(i10);
        if (TextUtils.isEmpty(strM60634n)) {
            C1442a.m8289e("CampaignService", "getAvailableQuests is empty");
            return null;
        }
        m61722s(c11060c, "/activity/entry");
        HashMap map = new HashMap();
        try {
            try {
                String strM59527d = C9530a.m59524b().m59527d(map);
                this.f48721a = strM59527d;
                String strM61716m = m61716m("/activity/entry", strM59527d, strM60634n, c11060c, "POST", null);
                C13823d.m82904y().m82915K(C0213f.m1377a(), strM61716m);
                return (GetCampaignActivityEntryResp) m61709e(strM61716m, GetCampaignActivityEntryResp.class);
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignService", "getCampaignActivityEntry err. " + e10.m60659c() + " " + e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "getCampaignActivityEntry err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: i */
    public final String m61713i(String str) throws C9721b {
        return C13040c.m78609F().m78664q() + m61715l(str);
    }

    /* renamed from: k */
    public GetRewardsResp m61714k(C11060c c11060c, String str, Integer num, Integer num2) throws C9721b {
        String strM67707a = C11281d.m67707a(new GetRewardReq(str, num, num2).toMap());
        m61722s(c11060c, "/rewards");
        HashMap map = new HashMap();
        try {
            try {
                String strM59527d = C9530a.m59524b().m59527d(map);
                this.f48721a = strM59527d;
                return (GetRewardsResp) m61709e(m61716m("/rewards", strM59527d, strM67707a, c11060c, "GET", null), GetRewardsResp.class);
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignService", "getRewards err. " + e10.m60659c() + " " + e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "getRewards err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: l */
    public final String m61715l(String str) {
        return "/HiCloudCampaignService/Client/V1" + str;
    }

    /* renamed from: m */
    public final String m61716m(String str, String str2, String str3, C11060c c11060c, String str4, String str5) throws C9721b {
        return m61717n(str, str2, str3, c11060c, str4, str5, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:88|7|8|(1:10)(14:19|20|(1:22)|12|24|25|79|26|27|85|28|97|29|(3:86|49|(2:51|(2:53|(2:55|(3:57|101|100)(1:96))(1:95))(2:94|60))(1:93))(1:92))|11|12|24|25|79|26|27|85|28|97|29|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(1:10)(14:19|20|(1:22)|12|24|25|79|26|27|85|28|97|29|(3:86|49|(2:51|(2:53|(2:55|(3:57|101|100)(1:96))(1:95))(2:94|60))(1:93))(1:92))|85|28|97|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
    
        r15 = r3;
        r17 = r7;
        r19 = r12;
        r12 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
    
        p054cj.C1442a.m8289e("CampaignService", "invoke exception: " + m61708d(r21, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ff, code lost:
    
        if (r0.m60663g() == 401) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0101, code lost:
    
        r9 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0104, code lost:
    
        if (r12 < 3) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0106, code lost:
    
        p054cj.C1442a.m8291w("CampaignService", " [AT OPERATION] " + m61708d(r15, r21, java.lang.Integer.valueOf(r0.m60659c()), r0.getMessage()));
        p681uj.C13195l.m79272J().m79325o0(r17);
        r0 = r15;
        r12 = r19;
        r15 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0145, code lost:
    
        r2 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0148, code lost:
    
        r2 = r17;
        r9 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014b, code lost:
    
        m61719p(r0);
        m61720q(r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01d5, code lost:
    
        throw new fk.C9721b(com.huawei.hms.support.api.entity.sns.SNSCode.Status.HW_ACCOUNT_FAILED, "response is null");
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01cc A[EDGE_INSN: B:92:0x01cc->B:61:0x01cc BREAK  A[LOOP:0: B:3:0x0012->B:100:0x0012], SYNTHETIC] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m61717n(java.lang.String r21, java.lang.String r22, java.lang.String r23, p429kk.C11060c r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p315gj.C9949b.m61717n(java.lang.String, java.lang.String, java.lang.String, kk.c, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: o */
    public Response m61718o(C11060c c11060c, String str) throws C9721b {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CampaignService", "permissionUpdateTask reqBody is empty");
            return null;
        }
        m61722s(c11060c, "/permission/update");
        HashMap map = new HashMap();
        try {
            try {
                String strM59527d = C9530a.m59524b().m59527d(map);
                this.f48721a = strM59527d;
                return (Response) m61709e(m61716m("/permission/update", strM59527d, str, c11060c, "POST", null), Response.class);
            } catch (C9721b e10) {
                C1442a.m8289e("CampaignService", "permissionUpdateTask err. " + e10.m60659c() + " " + e10.getMessage());
                throw e10;
            } catch (Exception e11) {
                C1442a.m8289e("CampaignService", "permissionUpdateTask err. " + e11.getMessage());
                throw new C9721b(4001, e11.getMessage());
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }

    /* renamed from: p */
    public final void m61719p(C9721b c9721b) throws C9721b {
        if (c9721b.m60663g() == 403) {
            throw new C9721b(PayStatusCodes.ORDER_STATUS_UNTREATED, c9721b.getMessage());
        }
    }

    /* renamed from: q */
    public final void m61720q(C9721b c9721b) throws C9721b {
        if (!m61723t(c9721b)) {
            throw new C9721b(1, c9721b.getMessage());
        }
        throw c9721b;
    }

    /* renamed from: r */
    public final void m61721r() {
        C1442a.m8291w("CampaignService", "sendAuthFail campaign server auth failed.");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: s */
    public final void m61722s(C11060c c11060c, String str) throws C9721b {
        C9720a.m60657f(c11060c, "stat is null.");
        C9720a.m60657f(str, "cmd is null.");
        C9720a.m60653b(c11060c.m66661q(), "x-hw-trace-id is null.");
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C9720a.m60653b(strM80971t0, "userid is null.");
        c11060c.m66644J(strM80971t0);
        c11060c.m66664t(str);
    }

    /* renamed from: t */
    public final boolean m61723t(C9721b c9721b) {
        return c9721b.m60659c() == 9002 || c9721b.m60659c() == 9005 || c9721b.m60659c() == 9003 || c9721b.m60659c() == 9001 || c9721b.m60659c() == 9100;
    }
}
