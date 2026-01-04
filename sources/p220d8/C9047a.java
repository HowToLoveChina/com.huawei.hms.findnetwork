package p220d8;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.Requestable;
import com.huawei.android.hicloud.album.service.hihttp.request.DisableStateRequest;
import com.huawei.android.hicloud.album.service.hihttp.request.GetServerTimeRequest;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hwcloudjs.C6618c;
import p635s7.C12725c0;
import p635s7.C12749o0;
import p635s7.C12754s;
import p635s7.C12759x;
import p635s7.C12761z;
import p702v7.C13362a;
import p702v7.C13363b;
import p731w7.C13536c;
import p801y7.C13916d;

/* renamed from: d8.a */
/* loaded from: classes2.dex */
public class C9047a {

    /* renamed from: a */
    public Context f45709a;

    /* renamed from: b */
    public CallbackHandler f45710b;

    /* renamed from: c */
    public Requestable f45711c;

    /* renamed from: d */
    public C13362a f45712d;

    public C9047a(Context context, CallbackHandler callbackHandler, Requestable requestable) {
        this.f45712d = null;
        this.f45709a = context;
        this.f45710b = callbackHandler;
        this.f45711c = requestable;
        this.f45712d = new C13362a(context, callbackHandler);
    }

    /* renamed from: a */
    public void m57021a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        bundle.putInt("Status", 2);
        m57027g(9009, bundle);
    }

    /* renamed from: b */
    public void m57022b(String str) {
        this.f45711c.request(ConnectionResult.RESOLUTION_REQUIRED, str, new C13536c(), new C12754s(this.f45709a, str), this.f45712d);
    }

    /* renamed from: c */
    public void m57023c() {
        this.f45711c.request(C6618c.f30770o, OpsReport.m15259j(), new C13536c(), new GetServerTimeRequest(this.f45709a), this.f45712d);
    }

    /* renamed from: d */
    public void m57024d(String str) {
        this.f45711c.request(9003, str, new C13536c(), new C12761z(this.f45709a, str), this.f45712d);
    }

    /* renamed from: e */
    public void m57025e() {
        Bundle bundle = new Bundle();
        bundle.putInt("code", 0);
        bundle.putString("info", "Success");
        bundle.putString("TagTransferStatus", "1");
        bundle.putParcelable("HttpResult", new HttpResult(200, 0, "Success"));
        bundle.putString("sessionId", OpsReport.m15260k());
        this.f45710b.sendMessage(9062, bundle);
    }

    /* renamed from: f */
    public void m57026f(String str, String str2) {
        this.f45711c.request(ConnectionResult.SERVICE_UPDATING, str2, new C13536c(), new C12759x(this.f45709a, str2, str), new C13363b(this.f45709a, this.f45710b));
    }

    /* renamed from: g */
    public final void m57027g(int i10, Bundle bundle) {
        m57028h(i10, false, bundle);
    }

    /* renamed from: h */
    public final void m57028h(int i10, boolean z10, Bundle bundle) {
        if (z10) {
            i10 += 100;
        }
        this.f45710b.sendMessage(i10, bundle);
    }

    /* renamed from: i */
    public void m57029i(int i10, String str) {
        this.f45711c.request(9060, str, new C13536c(), new DisableStateRequest(this.f45709a, i10, str), this.f45712d);
    }

    /* renamed from: j */
    public void m57030j(String str, int i10, String str2, String str3, String str4) {
        this.f45711c.request(9087, str, new C13536c(), new C12725c0(this.f45709a, str, i10, str2, str3, str4), this.f45712d);
    }

    /* renamed from: k */
    public void m57031k(String str, String str2) {
        C13916d.m83404n(this.f45709a, this.f45710b, 152);
        this.f45711c.request(ConnectionResult.SIGN_IN_FAILED, str2, new C13536c(), new C12749o0(this.f45709a, str2, str), this.f45712d);
    }

    /* renamed from: l */
    public void m57032l(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", 0);
        bundle.putString("info", "Success");
        bundle.putParcelable("HttpResult", new HttpResult(200, 0, "Success"));
        bundle.putString("sessionId", OpsReport.m15260k());
        this.f45710b.sendMessage(9061, bundle);
    }

    /* renamed from: m */
    public void m57033m(int i10, Bundle bundle) {
    }
}
