package p740wh;

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

/* renamed from: wh.c */
/* loaded from: classes4.dex */
public class C13608c implements AsyncTaskC13606a.a, AsyncTaskC13607b.a {

    /* renamed from: a */
    public Context f61209a;

    /* renamed from: b */
    public InstallParamSpec f61210b;

    /* renamed from: c */
    public InstallCallback f61211c;

    /* renamed from: d */
    public String f61212d = "";

    /* renamed from: e */
    public FailResultParam f61213e = new FailResultParam();

    /* renamed from: f */
    public AsyncTaskC13606a f61214f;

    public C13608c(Context context, InstallParamSpec installParamSpec, InstallCallback installCallback) {
        this.f61209a = context;
        this.f61210b = installParamSpec;
        this.f61211c = installCallback;
    }

    /* renamed from: c */
    private void m81816c() {
        this.f61213e.setMarketInfo(this.f61210b.getMarketInfo());
        InstallCallback installCallback = this.f61211c;
        if (installCallback != null) {
            installCallback.onFailed(this.f61213e);
        }
        File file = new File(C11469b.m68596a(this.f61209a));
        if (!file.exists() || file.delete()) {
            return;
        }
        C13012a.m78318d("SilentDownloadManager", "delete DownloadFile failed");
    }

    /* renamed from: a */
    public void m81817a() {
        if (!C13175c.m79222e(this.f61209a)) {
            this.f61213e.setResult(-1);
            m81816c();
        } else {
            AsyncTaskC13606a asyncTaskC13606a = new AsyncTaskC13606a(this, this.f61210b);
            this.f61214f = asyncTaskC13606a;
            asyncTaskC13606a.execute(new Void[0]);
        }
    }

    @Override // p740wh.AsyncTaskC13606a.a, p740wh.AsyncTaskC13607b.a
    /* renamed from: b */
    public Context mo81807b() {
        return this.f61209a;
    }

    @Override // p740wh.AsyncTaskC13606a.a
    /* renamed from: d */
    public void mo81808d(MarketInfo marketInfo, int i10, int i11) {
        this.f61213e.setResponseCode(i10);
        this.f61213e.setRtnCode(i11);
        this.f61210b.setMarketInfo(marketInfo);
        if (marketInfo == null) {
            this.f61213e.setResult(-4);
            m81816c();
        }
    }

    /* renamed from: e */
    public final void m81818e() {
        if (!AsyncTaskC13607b.m81810f(this.f61209a)) {
            this.f61213e.setResult(-2);
            m81816c();
        } else {
            String strM68591b = C11468a.m68591b(this.f61211c);
            this.f61212d = strM68591b;
            C11468a.m68592c(strM68591b, this.f61210b.getMarketInfo());
            new AsyncTaskC13607b(this, this.f61210b, this.f61212d).execute(new Void[0]);
        }
    }

    @Override // p740wh.AsyncTaskC13606a.a
    /* renamed from: a */
    public void mo81806a(int i10, int i11) {
        if (i10 != 2) {
            if (i10 == 3) {
                m81818e();
                return;
            } else if (i10 != 4) {
                if (i10 != 5) {
                    return;
                }
                this.f61213e.setReason(Constant.INSTALL_FAILED_SHA256_EEROR);
                this.f61213e.setResult(-3);
                return;
            }
        }
        this.f61213e.setResult(-3);
        m81816c();
    }

    @Override // p740wh.AsyncTaskC13607b.a
    /* renamed from: a */
    public void mo81815a(boolean z10) {
        if (z10) {
            return;
        }
        this.f61213e.setResult(-2);
        this.f61213e.setReason(Constant.INSTALL_FAILED_FILE_NOT_FOUND);
        m81816c();
        C11468a.m68595f(this.f61212d);
        C11468a.m68594e(this.f61212d);
    }
}
