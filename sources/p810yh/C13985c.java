package p810yh;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import com.huawei.appgallery.marketinstallerservice.api.Constant;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.InstallParamSpec;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import java.io.File;
import mh.C11468a;
import mh.C11469b;
import p679uh.C13175c;
import p740wh.AsyncTaskC13606a;
import p740wh.AsyncTaskC13607b;
import th.C13012a;

/* renamed from: yh.c */
/* loaded from: classes4.dex */
public class C13985c implements InterfaceC13983a, AsyncTaskC13606a.a, AsyncTaskC13607b.a {

    /* renamed from: a */
    public Activity f62668a;

    /* renamed from: b */
    public InterfaceC13984b f62669b;

    /* renamed from: e */
    public AsyncTaskC13606a f62672e;

    /* renamed from: c */
    public InstallParamSpec f62670c = null;

    /* renamed from: d */
    public String f62671d = null;

    /* renamed from: f */
    public FailResultParam f62673f = new FailResultParam();

    public C13985c(Activity activity, InterfaceC13984b interfaceC13984b) {
        this.f62668a = activity;
        this.f62669b = interfaceC13984b;
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: a */
    public void mo83995a() {
        this.f62670c.setMarketInfo(null);
        mo83999c(this.f62670c, this.f62671d);
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: b */
    public void mo83997b(int i10, int i11, int i12) {
        mo83996a(i10, i11, i12, 0);
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: c */
    public void mo83999c(InstallParamSpec installParamSpec, String str) {
        this.f62670c = installParamSpec;
        this.f62671d = str;
        if (!C13175c.m79222e(this.f62668a)) {
            this.f62669b.mo28081c();
            return;
        }
        AsyncTaskC13606a asyncTaskC13606a = new AsyncTaskC13606a(this, this.f62670c);
        this.f62672e = asyncTaskC13606a;
        asyncTaskC13606a.execute(new Void[0]);
        this.f62669b.mo28082d();
    }

    @Override // p740wh.AsyncTaskC13606a.a
    /* renamed from: d */
    public void mo81808d(MarketInfo marketInfo, int i10, int i11) {
        InstallParamSpec installParamSpec;
        if (marketInfo == null || (installParamSpec = this.f62670c) == null) {
            mo83997b(-4, i10, i11);
            this.f62669b.mo28077a(-4);
        } else {
            installParamSpec.setMarketInfo(marketInfo);
            this.f62669b.mo28080b(marketInfo);
        }
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: e */
    public void mo84001e() {
        InstallCallback installCallbackM68590a = C11468a.m68590a(this.f62671d);
        if (installCallbackM68590a != null) {
            installCallbackM68590a.onFailed(this.f62673f);
            C11468a.m68594e(this.f62671d);
        }
    }

    /* renamed from: f */
    public final void m84002f() {
        if (AsyncTaskC13607b.m81810f(this.f62668a)) {
            new AsyncTaskC13607b(this).execute(new Void[0]);
            return;
        }
        try {
            Activity activity = this.f62668a;
            activity.startActivityForResult(AsyncTaskC13607b.m81809a(activity), 1000);
        } catch (ActivityNotFoundException unused) {
            C13012a.m78317c("MarketDownloadPresenter", "startActivityForResult ActivityNotFoundException");
            mo83997b(-2, 0, 0);
            this.f62669b.mo28077a(-2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0026  */
    @Override // p740wh.AsyncTaskC13606a.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo81806a(int r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == r0) goto L2a
            r0 = 2
            r1 = 0
            r2 = -3
            if (r4 == r0) goto L26
            r0 = 3
            if (r4 == r0) goto L1d
            r5 = 4
            if (r4 == r5) goto L26
            r5 = 5
            if (r4 == r5) goto L12
            goto L2f
        L12:
            r4 = -10002(0xffffffffffffd8ee, float:NaN)
            r3.mo83996a(r2, r1, r1, r4)
        L17:
            yh.b r3 = r3.f62669b
            r3.mo28077a(r2)
            goto L2f
        L1d:
            yh.b r0 = r3.f62669b
            r0.mo28078a(r4, r5)
            r3.m84002f()
            goto L2f
        L26:
            r3.mo83997b(r2, r1, r1)
            goto L17
        L2a:
            yh.b r3 = r3.f62669b
            r3.mo28078a(r4, r5)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p810yh.C13985c.mo81806a(int, int):void");
    }

    @Override // p740wh.AsyncTaskC13606a.a, p740wh.AsyncTaskC13607b.a
    /* renamed from: b */
    public Context mo81807b() {
        return this.f62668a;
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: c */
    public void mo83998c() {
        AsyncTaskC13606a asyncTaskC13606a = this.f62672e;
        if (asyncTaskC13606a != null) {
            asyncTaskC13606a.cancel(true);
        }
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: d */
    public MarketInfo mo84000d() {
        InstallParamSpec installParamSpec = this.f62670c;
        return (installParamSpec == null || installParamSpec.getMarketInfo() == null) ? new MarketInfo() : this.f62670c.getMarketInfo();
    }

    @Override // p810yh.InterfaceC13983a
    /* renamed from: a */
    public void mo83996a(int i10, int i11, int i12, int i13) {
        C13012a.m78318d("MarketDownloadPresenter", "notifyResult errorCode" + i10 + ", responseCode=" + i11 + ", rtnCode=" + i12);
        this.f62673f.setResult(i10);
        this.f62673f.setResponseCode(i11);
        this.f62673f.setRtnCode(i12);
        this.f62673f.setReason(i13);
        InstallParamSpec installParamSpec = this.f62670c;
        MarketInfo marketInfo = installParamSpec != null ? installParamSpec.getMarketInfo() : null;
        this.f62673f.setMarketInfo(marketInfo);
        InstallParamSpec installParamSpec2 = this.f62670c;
        if (installParamSpec2 != null && installParamSpec2.getFailResultPromptType() == 2 && (-3 == i10 || -2 == i10)) {
            C13012a.m78318d("MarketDownloadPresenter", "need show retry dialog!");
        } else {
            InstallCallback installCallbackM68590a = C11468a.m68590a(this.f62671d);
            if (installCallbackM68590a != null) {
                if (i10 == 0) {
                    installCallbackM68590a.onSuccess(marketInfo);
                } else {
                    installCallbackM68590a.onFailed(this.f62673f);
                }
                C11468a.m68594e(this.f62671d);
            }
        }
        File file = new File(C11469b.m68596a(this.f62668a));
        if (!file.exists() || file.delete()) {
            return;
        }
        C13012a.m78318d("MarketDownloadPresenter", "delete DownloadFile failed");
    }

    @Override // p740wh.AsyncTaskC13607b.a
    /* renamed from: a */
    public void mo81815a(boolean z10) {
        if (z10) {
            return;
        }
        mo83996a(-2, 0, 0, Constant.INSTALL_FAILED_FILE_NOT_FOUND);
        this.f62669b.mo28077a(-2);
    }
}
