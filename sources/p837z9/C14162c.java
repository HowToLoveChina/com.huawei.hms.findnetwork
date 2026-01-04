package p837z9;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.datamigration.bean.AllowMigrateReq;
import com.huawei.android.hicloud.datamigration.bean.CutBaseReq;
import com.huawei.android.hicloud.datamigration.bean.CutBaseResp;
import com.huawei.android.hicloud.datamigration.bean.DataStatusResp;
import com.huawei.android.hicloud.datamigration.bean.DekInfo;
import com.huawei.android.hicloud.datamigration.bean.GetDeksReq;
import com.huawei.android.hicloud.datamigration.bean.GetDeksResp;
import com.huawei.android.hicloud.datamigration.bean.GetPublicKeyResp;
import com.huawei.android.hicloud.datamigration.bean.KeepLockTokenResp;
import com.huawei.android.hicloud.datamigration.bean.LockTokenResp;
import com.huawei.android.hicloud.datamigration.bean.Progress;
import com.huawei.android.hicloud.datamigration.bean.QueryStatusResp;
import com.huawei.android.hicloud.datamigration.bean.UpdateDeksReq;
import com.huawei.android.hicloud.datamigration.bean.UpdateDeksResp;
import com.huawei.android.hicloud.datamigration.bean.VerifyMigrationResp;
import com.huawei.android.hicloud.report.CloudCommonReport;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.hicloud.request.notify.constant.NotifyErr;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p585qo.C12381a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p709vj.C13452e;
import p746wn.C13622a;
import ro.C12612a;
import tm.C13040c;

/* renamed from: z9.c */
/* loaded from: classes3.dex */
public class C14162c {

    /* renamed from: b */
    public static final Gson f63316b = new Gson();

    /* renamed from: a */
    public C11060c f63317a;

    public C14162c() {
        this.f63317a = CloudCommonReport.m17077a();
    }

    /* renamed from: a */
    public static String m84969a(String str, Object... objArr) {
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
    public static <T> T m84970b(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f63316b.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err = " + str, "CBSService_fromJson");
        }
    }

    /* renamed from: c */
    public static Context m84971c() {
        return C0213f.m1377a();
    }

    /* renamed from: e */
    public static String m84972e() throws C9721b {
        return C13040c.m78609F().m78616H();
    }

    /* renamed from: d */
    public GetDeksResp m84973d(Progress progress, String str, String str2) throws C9721b {
        GetDeksReq getDeksReq = new GetDeksReq();
        getDeksReq.setProgress(progress);
        getDeksReq.setEncTempKey(str);
        try {
            return (GetDeksResp) m84970b(m84978j(getDeksReq, str2), GetDeksResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: f */
    public LockTokenResp m84974f() throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.lock");
        try {
            return (LockTokenResp) m84970b(m84977i(cutBaseReq), LockTokenResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: g */
    public GetPublicKeyResp m84975g() throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.getpk");
        try {
            return (GetPublicKeyResp) m84970b(m84977i(cutBaseReq), GetPublicKeyResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: h */
    public String m84976h(int i10, String str) {
        try {
            return UserKeyUtils.getInstance().getSyncUser(i10, str).getUserKeyGuid();
        } catch (C9721b e10) {
            C11839m.m70687e("DataMigrationService", "get user key guid error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: i */
    public final String m84977i(CutBaseReq cutBaseReq) throws C9721b {
        return m84978j(cutBaseReq, null);
    }

    /* renamed from: j */
    public final String m84978j(CutBaseReq cutBaseReq, String str) throws C9721b {
        m84981m();
        try {
            String strM84987s = m84987s(cutBaseReq.getCmd(), cutBaseReq.toString(), this.f63317a, str);
            C11839m.m70686d("DataMigrationService", "result = " + strM84987s);
            return strM84987s;
        } catch (C9721b e10) {
            C11839m.m70687e("DataMigrationService", m84969a(cutBaseReq.getCmd(), e10));
            C11060c c11060c = this.f63317a;
            if (c11060c != null) {
                c11060c.m66665u("119_" + e10.m60659c());
                this.f63317a.m66664t(cutBaseReq.getCmd());
                C13622a.m81968n(m84971c(), this.f63317a);
            }
            throw e10;
        }
    }

    /* renamed from: k */
    public KeepLockTokenResp m84979k(String str) throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.keeplock");
        try {
            return (KeepLockTokenResp) m84970b(m84978j(cutBaseReq, str), KeepLockTokenResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: l */
    public final String m84980l(String str) throws C9721b {
        try {
            return C13195l.m79272J().m79344y("DataMigration", str);
        } catch (C13194k e10) {
            C11839m.m70687e("DataMigrationService", "onAccessToken error is " + e10.toString());
            if (e10.m79269b() == 1199) {
                throw new C9721b(NotifyErr.NET_DISABLE_HMS_ERROR, e10.toString(), str);
            }
            throw new C9721b(1201, e10.toString(), str);
        } catch (C13199p e11) {
            C11839m.m70687e("DataMigrationService", "onAccessToken error is " + e11.toString());
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, e11.toString(), str);
        }
    }

    /* renamed from: m */
    public final void m84981m() throws C9721b {
        if (C13452e.m80781L().m80917g1()) {
            C13452e.m80781L().m80980v1();
            C13452e.m80781L().m80972t1();
            throw new C9721b(1102, "check local st is invalid", "checkLocalSTInvalid");
        }
    }

    /* renamed from: n */
    public DataStatusResp m84982n() throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.querydatastatus");
        try {
            return (DataStatusResp) m84970b(m84977i(cutBaseReq), DataStatusResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: o */
    public QueryStatusResp m84983o(String str) throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.querystatus");
        try {
            return (QueryStatusResp) m84970b(m84978j(cutBaseReq, str), QueryStatusResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: p */
    public CutBaseResp m84984p(String str) throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.unlock");
        try {
            return (CutBaseResp) m84970b(m84978j(cutBaseReq, str), CutBaseResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: q */
    public CutBaseResp m84985q(int i10) throws C9721b {
        AllowMigrateReq allowMigrateReq = new AllowMigrateReq();
        allowMigrateReq.setAllowStatus(i10);
        allowMigrateReq.setCountry(C13452e.m80781L().m80942m());
        allowMigrateReq.setUserID(C13452e.m80781L().m80971t0());
        try {
            return (CutBaseResp) m84970b(m84977i(allowMigrateReq), CutBaseResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: r */
    public final String m84986r(String str, C11060c c11060c, String str2) throws C9721b {
        try {
            CutBaseResp cutBaseResp = (CutBaseResp) m84970b(str, CutBaseResp.class);
            int code = cutBaseResp.getCode();
            if (c11060c != null) {
                c11060c.m66665u("119_" + code);
            }
            String strM84972e = m84972e();
            if (code == 0) {
                return str;
            }
            C11839m.m70687e("DataMigrationService", m84969a(strM84972e, cutBaseResp.toString()));
            throw new C9721b(code, cutBaseResp.toString(), str2);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("DataMigrationService", "result json exception is " + e10.toString());
            throw e10;
        }
    }

    /* renamed from: s */
    public final String m84987s(String str, String str2, C11060c c11060c, String str3) throws C9721b {
        int i10 = 1;
        while (true) {
            String strM84980l = m84980l(str);
            try {
                String strM84972e = m84972e();
                C11839m.m70688i("DataMigrationService", m84969a(strM84972e, str, "x-hw-trace-id = ", c11060c.m66661q()));
                C11839m.m70686d("DataMigrationService", m84969a(str, str2));
                C12381a c12381a = new C12381a(strM84980l, str, str2, c11060c.m66661q());
                if (!TextUtils.isEmpty(str3)) {
                    c12381a.m74444a(str3);
                }
                String str4 = (String) C12612a.m76107g(strM84972e, c12381a, c11060c);
                C11839m.m70686d("DataMigrationService", m84969a(str, str4));
                if (str4 == null || str4.isEmpty()) {
                    throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "response is null", str);
                }
                return m84986r(str4, c11060c, str);
            } catch (C9721b e10) {
                int iM60659c = e10.m60659c();
                if (401 != iM60659c && 402 != iM60659c) {
                    break;
                }
                int i11 = i10 + 1;
                if (i10 >= 3) {
                    break;
                }
                C11839m.m70687e("DataMigrationService", " [AT OPERATION] at invalid retry: " + i11);
                C13195l.m79272J().m79325o0(strM84980l);
                i10 = i11;
                throw e10;
            } catch (Exception e11) {
                C11839m.m70687e("DataMigrationService", m84969a(str, e11));
                throw new C9721b(4001, e11.getMessage(), str);
            }
        }
    }

    /* renamed from: t */
    public UpdateDeksResp m84988t(DekInfo dekInfo, int i10, String str) throws C9721b {
        UpdateDeksReq updateDeksReq = new UpdateDeksReq();
        String strM84976h = m84976h(i10, this.f63317a.m66661q());
        if (!TextUtils.isEmpty(strM84976h)) {
            updateDeksReq.setStrGuid(strM84976h);
            updateDeksReq.setUnstrGuid(strM84976h);
            updateDeksReq.setStrDataVer("3");
            updateDeksReq.setUnstrDataVer("3");
        }
        updateDeksReq.setDeks(dekInfo);
        try {
            return (UpdateDeksResp) m84970b(m84978j(updateDeksReq, str), UpdateDeksResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    /* renamed from: u */
    public VerifyMigrationResp m84989u(String str) throws C9721b {
        CutBaseReq cutBaseReq = new CutBaseReq();
        cutBaseReq.setCmd("common.datamigration.verify");
        try {
            return (VerifyMigrationResp) m84970b(m84978j(cutBaseReq, str), VerifyMigrationResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(SNSCode.Status.USER_NOT_FOUND, "json err " + e10.toString());
        }
    }

    public C14162c(String str) {
        this.f63317a = C11058a.m66626a(str, "07002", C13452e.m80781L().m80971t0());
    }

    public C14162c(C11060c c11060c) {
        if (c11060c == null) {
            this.f63317a = CloudCommonReport.m17077a();
        } else {
            this.f63317a = c11060c;
        }
    }
}
