package p814yl;

import android.text.TextUtils;
import android.util.Log;
import ck.C1443a;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hicloud.cloudbackup.p104v3.server.CloudBackupV3Server;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.service.C5009e0;
import fk.C9721b;
import gp.C10028c;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import p340hi.C10209a;
import p477mi.C11472a;
import p514o9.C11839m;
import p523oi.C11903a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p712vm.C13468a;
import tm.C13040c;

/* renamed from: yl.b */
/* loaded from: classes6.dex */
public class C13997b {

    /* renamed from: a */
    public String f62706a;

    /* renamed from: b */
    public long f62707b = 0;

    /* renamed from: yl.b$a */
    public static class a {

        /* renamed from: a */
        public static C13997b f62708a = new C13997b();
    }

    /* renamed from: f */
    public static C13997b m84034f() {
        return a.f62708a;
    }

    /* renamed from: b */
    public final synchronized String m84035b() throws IOException {
        try {
            String strM79344y = C13195l.m79272J().m79344y("CloudBackup3", "");
            if (!strM79344y.equals(this.f62706a)) {
                this.f62706a = strM79344y;
                this.f62707b = System.currentTimeMillis();
            }
        } catch (C13194k e10) {
            C11839m.m70687e("CloudBackupCredential", "access token invalid.");
            throw m84036c(1201, e10.toString());
        } catch (C13199p e11) {
            C11839m.m70687e("CloudBackupCredential", "access token invalid, st invalid.");
            C13452e.m80781L().m80972t1();
            throw m84036c(1101, e11.toString());
        }
        return this.f62706a;
    }

    /* renamed from: c */
    public final C4616s m84036c(int i10, String str) {
        int i11 = i10 == 1201 ? 401 : 402;
        String str2 = i10 == 1201 ? "get access token error, st invalid." : "access token invalid.";
        C4609l c4609l = new C4609l();
        c4609l.m28221M("application/json; charset=utf-8");
        C4616s.a aVar = new C4616s.a(i11, "access token invalid.", c4609l);
        aVar.m28328e(str2);
        aVar.m28326c(new C11472a().m68602k(new C11472a.a().m68603b(402).m68604f(str)));
        ErrorResp errorResp = new ErrorResp();
        ErrorResp.Error error = new ErrorResp.Error();
        error.setCode(Integer.valueOf(i11));
        error.setDescription(str2);
        ErrorResp.ErrorMsg errorMsg = new ErrorResp.ErrorMsg();
        errorMsg.setErrorCode(String.valueOf(i10));
        errorMsg.setDescription(str);
        error.setErrorDetail(Collections.singletonList(errorMsg));
        errorResp.setError(error);
        errorResp.setFactory(C11903a.m71435l());
        aVar.m28325b(errorResp.toString());
        return aVar.m28324a();
    }

    /* renamed from: d */
    public CloudBackupV3Server m84037d() throws C9721b {
        C10209a c10209aM84039g = m84039g();
        if (!C10028c.m62182c0().m62221H1()) {
            throw new C9721b(1101, "terms is not confirmed.");
        }
        CloudBackupV3Server.Builder builder = new CloudBackupV3Server.Builder(C13040c.m78609F().m78666s(), CloudBackupV3Server.DEFAULT_SERVICE_PATH, c10209aM84039g);
        if (C1443a.f6214b.booleanValue()) {
            builder.setLogLevel(3).setAnonymousHeaders(Collections.singletonList("x-hw-client-ip"));
        } else {
            builder.setLogLevel(4);
        }
        return builder.build();
    }

    /* renamed from: e */
    public final void m84038e() throws C9721b {
        if (!C13468a.m81100c().m81101b()) {
            throw new C9721b(3900, "at invaild check network timeout");
        }
    }

    /* renamed from: g */
    public final C10209a m84039g() throws C9721b {
        C11472a.a aVarM68601f;
        try {
            return new C10209a.c(C13452e.m80781L().m80971t0(), new C10209a.b() { // from class: yl.a
                @Override // p340hi.C10209a.b
                /* renamed from: a */
                public final String mo7274a() {
                    return this.f62701a.m84040h();
                }
            }).m63363b().m63360j(m84035b());
        } catch (C4616s e10) {
            int iM28322f = e10.m28322f();
            String message = iM28322f == 402 ? "get service token error." : "get access token error.";
            int i10 = iM28322f == 402 ? 1101 : 1201;
            C11472a c11472aM28320d = e10.m28320d();
            if (c11472aM28320d != null && (aVarM68601f = c11472aM28320d.m68601f()) != null) {
                message = aVarM68601f.getMessage();
            }
            if (i10 == 1201) {
                this.m84038e();
            }
            C11839m.m70687e("CloudBackupCredential", "init credential error. " + message);
            throw new C9721b(i10, message);
        } catch (Exception e11) {
            this.m84038e();
            this.m84041i(e11);
            throw new C9721b(1201, "get access token error." + e11.toString());
        }
    }

    /* renamed from: h */
    public final synchronized String m84040h() throws IOException {
        String strM30050f = C5009e0.m30044e().m30050f();
        if (C13195l.m79272J().m79308X() && !TextUtils.isEmpty(this.f62706a) && !TextUtils.isEmpty(strM30050f) && !this.f62706a.equals(strM30050f)) {
            C11839m.m70688i("CloudBackupCredential", "smsAccessToken has been updated success");
            return m84035b();
        }
        if (System.currentTimeMillis() - this.f62707b > 60000) {
            C13195l.m79272J().m79325o0(this.f62706a);
        }
        return m84035b();
    }

    /* renamed from: i */
    public final void m84041i(Exception exc) {
        if (exc == null) {
            C11839m.m70687e("CloudBackupCredential", "report at exception error.");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("exception_details", Log.getStackTraceString(exc));
            C13225d.m79490f1().m79591l0("backup_http_initializer_error", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "backup_http_initializer_error", "4", "43", linkedHashMapM79497A);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupCredential", "get access token error.: " + e10.toString());
        }
    }
}
