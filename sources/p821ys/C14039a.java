package p821ys;

import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.lite.common.report.ReportBuilder;
import es.C9536a;

/* renamed from: ys.a */
/* loaded from: classes8.dex */
public final class C14039a {

    /* renamed from: a */
    public ReportBuilder f62817a;

    /* renamed from: ys.a$a */
    public static class a {

        /* renamed from: a */
        public ReportBuilder f62818a = new ReportBuilder();

        /* renamed from: a */
        public final C14039a m84223a() {
            return new C14039a(this.f62818a);
        }

        /* renamed from: b */
        public final void m84224b(BaseLocationReq baseLocationReq) {
            if (baseLocationReq != null) {
                this.f62818a.setTransactionID(baseLocationReq.getLocTransactionId());
                this.f62818a.setPackage(baseLocationReq.getPackageName());
                this.f62818a.setCpAppVersion(String.valueOf(C9536a.m59551k(baseLocationReq.getPackageName())));
            }
        }

        /* renamed from: c */
        public final void m84225c(String str) {
            this.f62818a.setApiName(str);
        }
    }

    public C14039a(ReportBuilder reportBuilder) {
        this.f62817a = reportBuilder;
    }

    /* renamed from: a */
    public final void m84221a(String str) {
        this.f62817a.setResult(str);
        this.f62817a.setCostTime();
        C6791a.m38458h().m38467l(this.f62817a);
        C6791a.m38458h().m38468m(this.f62817a);
        this.f62817a.setCallTime();
    }

    /* renamed from: b */
    public final void m84222b(String str) {
        this.f62817a.setErrorCode(str);
        this.f62817a.setCostTime();
        C6791a.m38458h().m38467l(this.f62817a);
        C6791a.m38458h().m38468m(this.f62817a);
    }
}
