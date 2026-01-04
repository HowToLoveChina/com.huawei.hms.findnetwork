package bn;

import android.content.Context;
import com.huawei.fastengine.fastview.FastSDKEngine;
import com.huawei.hicloud.sync.R$string;
import fk.C9721b;
import p015ak.C0209d;
import p514o9.C11839m;
import p514o9.C11841o;
import tm.C13040c;

/* renamed from: bn.b */
/* loaded from: classes6.dex */
public final class C1264b {

    /* renamed from: bn.b$a */
    public interface a {
        void onResult(int i10);
    }

    /* renamed from: b */
    public static void m7519b(a aVar, int i10) {
        if (aVar != null) {
            aVar.onResult(i10);
        }
    }

    /* renamed from: c */
    public static void m7520c(Context context, a aVar) {
        m7523f(context, aVar);
    }

    /* renamed from: d */
    public static String m7521d() {
        try {
            return C13040c.m78609F().m78655k() + "/appdl/C100147161";
        } catch (C9721b e10) {
            C11839m.m70687e("FastDownloader", "getDefaultUrl error: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: e */
    public static /* synthetic */ void m7522e(a aVar, int i10) {
        C11839m.m70687e("FastDownloader", "FastEngine download result: " + i10);
        m7519b(aVar, i10);
    }

    /* renamed from: f */
    public static void m7523f(Context context, final a aVar) {
        if (context == null) {
            C11839m.m70687e("FastDownloader", "Failed to download FastEngine. Input parameter 'context' is null.");
            throw new IllegalArgumentException("argument 'context' must not be null.");
        }
        String strM7521d = m7521d();
        if (strM7521d == null) {
            C11839m.m70687e("FastDownloader", "Failed to download FastEngine. Input parameter 'url' is null.");
            m7519b(aVar, 80001);
        } else if (C0209d.m1333z1(context)) {
            C11839m.m70688i("FastDownloader", "Start do download FastEngine.");
            FastSDKEngine.downloadEngine(context, strM7521d, new FastSDKEngine.DownloadCallback() { // from class: bn.a
                @Override // com.huawei.fastengine.fastview.FastSDKEngine.DownloadCallback
                public final void onResult(int i10) {
                    C1264b.m7522e(aVar, i10);
                }
            });
        } else {
            C11839m.m70687e("FastDownloader", "Failed to download FastEngine.NetWork error");
            C11841o.m70708d(context, context.getString(R$string.network_unavailable), 0);
            m7519b(aVar, 90006);
        }
    }
}
