package p861do;

import android.text.TextUtils;
import bo.C1267a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.agreement.request.BaseRsp;
import com.huawei.hicloud.request.agreement.request.ConsentInformation;
import com.huawei.hicloud.request.agreement.request.ConsentQueryInformation;
import com.huawei.hicloud.request.agreement.request.QueryAgreementReq;
import com.huawei.hicloud.request.agreement.request.QueryAgreementRsp;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideReq;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideRsp;
import com.huawei.hicloud.request.agreement.request.SignAgreementReq;
import com.huawei.hicloud.request.agreement.request.SignAgreementRsp;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import com.huawei.hicloud.request.agreement.request.SignPushGuideReq;
import com.huawei.hicloud.request.agreement.request.SignPushGuideRsp;
import com.huawei.hicloud.request.basic.bean.AgrInfo;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11827a;
import p514o9.C11829c;
import p514o9.C11839m;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import ro.C12612a;

/* renamed from: do.a */
/* loaded from: classes6.dex */
public class C9281a {

    /* renamed from: b */
    public static final Gson f46609b = new Gson();

    /* renamed from: a */
    public String f46610a;

    /* renamed from: a */
    public static String m58346a(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
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

    /* renamed from: b */
    public static <T> T m58347b(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f46609b.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(4003, "json err = " + str, "AgreementService_fromJson");
        }
    }

    /* renamed from: c */
    public final String m58348c(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("Agreement", str);
        } catch (C13194k e10) {
            C11839m.m70687e("AgreementService", "onAccessToken: " + e10.toString());
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("AgreementService", "onAccessToken: " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: d */
    public final String m58349d(String str, String str2) throws Throwable {
        String strM70476a;
        CheckAppStatus checkAppStatus = new CheckAppStatus();
        checkAppStatus.checkStInvalidByServer();
        checkAppStatus.checkSiteNotMatch();
        String strM58348c = m58348c(str);
        try {
            if (TextUtils.equals(str, "cs.user.client.query") || TextUtils.equals(str, "cs.user.client.sign")) {
                strM70476a = C11827a.m70477b() + "/consentservice/user/api";
            } else {
                strM70476a = C11827a.m70476a();
            }
            String str3 = this.f46610a;
            String strM66627b = (str3 == null || str3.isEmpty()) ? C11058a.m66627b("00000") : this.f46610a;
            C11839m.m70688i("AgreementService", m58346a(strM70476a, str, "x-hw-trace-id = ", strM66627b));
            C11839m.m70686d("AgreementService", m58346a(str, str2));
            String str4 = (String) C12612a.m76107g(strM70476a, new C1267a(strM58348c, str, str2, strM66627b), null);
            C11839m.m70686d("AgreementService", m58346a(str, str4));
            if (str4 == null || str4.isEmpty()) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", str);
            }
            return m58350e(str4, null, str);
        } catch (C9721b e10) {
            C11839m.m70687e("AgreementService", m58346a(str, e10));
            if (39999 == e10.m60659c()) {
                C11839m.m70689w("AgreementService", " [AT OPERATION] query tms AT auth failed:" + e10.toString());
                C13195l.m79272J().m79325o0(strM58348c);
            }
            return m58351f(str, e10);
        } catch (Exception e11) {
            C11839m.m70687e("AgreementService", m58346a(str, e11));
            throw new C9721b(4001, e11.getMessage(), str);
        }
    }

    /* renamed from: e */
    public final String m58350e(String str, C11060c c11060c, String str2) throws C9721b {
        try {
            BaseRsp baseRsp = (BaseRsp) m58347b(str, BaseRsp.class);
            int errorCode = baseRsp.getErrorCode();
            if (c11060c != null) {
                c11060c.m66665u("" + errorCode);
                c11060c.m66635A(baseRsp.toString());
            }
            String strM70476a = C11827a.m70476a();
            if (errorCode == 0) {
                return str;
            }
            C11839m.m70687e("AgreementService", m58346a(strM70476a, "errorCode:" + errorCode));
            throw new C9721b(errorCode, errorCode, baseRsp.toString(), str2);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AgreementService", "processBody, json exception is: " + e10.toString());
            throw new C9721b(4003, "json err");
        }
    }

    /* renamed from: f */
    public final String m58351f(String str, C9721b c9721b) throws C9721b {
        int iM60659c = c9721b.m60659c();
        if (iM60659c == 3012 || iM60659c == 39999) {
            throw c9721b;
        }
        throw new C9721b(9100, m58346a("response code = ", Integer.valueOf(c9721b.m60659c()), c9721b.getMessage()), str);
    }

    /* renamed from: g */
    public QueryAgreementRsp m58352g(String str) throws C9721b {
        AgrInfo agrInfo = new AgrInfo(125, str);
        AgrInfo agrInfo2 = new AgrInfo(RequestManager.NOTIFY_CONNECT_SUSPENDED, str);
        AgrInfo agrInfo3 = new AgrInfo(10000, str);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(agrInfo);
        arrayList.add(agrInfo2);
        if ("CN".equalsIgnoreCase(str)) {
            arrayList.add(agrInfo3);
        }
        try {
            return (QueryAgreementRsp) m58347b(m58349d("as.user.query", new QueryAgreementReq(arrayList).toString()), QueryAgreementRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AgreementService", "queryAgreement, json exception is: " + e10.toString());
            throw new C9721b(4003, "json err");
        }
    }

    /* renamed from: h */
    public QueryPushGuideRsp m58353h() throws C9721b {
        ConsentQueryInformation consentQueryInformation = new ConsentQueryInformation(100022, C11829c.m70533N());
        ArrayList arrayList = new ArrayList();
        arrayList.add(consentQueryInformation);
        try {
            return (QueryPushGuideRsp) m58347b(m58349d("cs.user.client.query", new QueryPushGuideReq("cloud 16.0.0.300", arrayList).toString()), QueryPushGuideRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AgreementService", "queryPushGuideAgreement, json exception is: " + e10.toString());
            throw new C9721b(4003, "json err");
        }
    }

    /* renamed from: i */
    public int m58354i(List<SignInfo> list) throws C9721b {
        try {
            return ((SignAgreementRsp) m58347b(m58349d("as.user.sign", new SignAgreementReq(list).toString()), SignAgreementRsp.class)).getErrorCode();
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AgreementService", "signAgreement, json exception is: " + e10.toString());
            throw new C9721b(4003, "json err");
        }
    }

    /* renamed from: j */
    public SignPushGuideRsp m58355j(String str, String str2, boolean z10, String str3) throws C9721b {
        ConsentInformation consentInformation = new ConsentInformation(100022, str, str2, z10, str3, System.currentTimeMillis(), false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(consentInformation);
        try {
            return (SignPushGuideRsp) m58347b(m58349d("cs.user.client.sign", new SignPushGuideReq("cloud 16.0.0.300", arrayList).toString()), SignPushGuideRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("AgreementService", "signPushGuideAgreement, json exception is: " + e10.toString());
            throw new C9721b(4003, "json err");
        }
    }
}
