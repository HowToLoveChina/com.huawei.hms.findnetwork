package p529op;

import android.webkit.WebView;
import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.hms.ads.jsb.PPSJsBridge;
import java.util.concurrent.atomic.AtomicBoolean;
import p399jk.AbstractC10896a;

/* renamed from: op.e */
/* loaded from: classes8.dex */
public class C11983e {

    /* renamed from: a */
    public final AtomicBoolean f55771a;

    /* renamed from: op.e$b */
    public static class b {

        /* renamed from: a */
        public static final C11983e f55772a = new C11983e();
    }

    /* renamed from: b */
    public static C11983e m72121b() {
        return b.f55772a;
    }

    /* renamed from: a */
    public PPSJsBridge m72122a(WebView webView) {
        AbstractC10896a.m65885d("PPSJsBridgeManager", "bind PPSJsBridge start");
        m72123c();
        return new PPSJsBridge(webView);
    }

    /* renamed from: c */
    public final void m72123c() {
        if (this.f55771a.compareAndSet(false, true)) {
            PPSJsBridge.init(new JsbConfig.Builder().enableUserInfo(true).initGrs("hicloud").enableLog(true).build());
        } else {
            AbstractC10896a.m65885d("PPSJsBridgeManager", "isInit return");
        }
    }

    /* renamed from: d */
    public boolean m72124d() {
        return true;
    }

    /* renamed from: e */
    public void m72125e(PPSJsBridge pPSJsBridge) {
        if (pPSJsBridge == null) {
            AbstractC10896a.m65888w("PPSJsBridgeManager", "unBind PPSJsBridge null");
        } else {
            pPSJsBridge.destroy();
        }
    }

    public C11983e() {
        this.f55771a = new AtomicBoolean(false);
    }
}
