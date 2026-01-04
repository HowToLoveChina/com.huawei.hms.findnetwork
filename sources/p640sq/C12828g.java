package p640sq;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: sq.g */
/* loaded from: classes8.dex */
public final class C12828g {

    /* renamed from: a */
    public ConcurrentHashMap<String, String> f58576a;

    public C12828g() {
        this.f58576a = null;
        ConcurrentHashMap<String, String> concurrentHashMapM76974f = C12822a.m76974f();
        this.f58576a = concurrentHashMapM76974f;
        if (concurrentHashMapM76974f.isEmpty()) {
            C12836o.m77097b("DataHelper", "resourcesMap is empty", true);
            return;
        }
        C12836o.m77097b("DataHelper", "resourcesMap--" + this.f58576a.size(), false);
    }

    /* renamed from: a */
    public boolean m77054a(String str) {
        return this.f58576a.containsKey(str);
    }

    /* renamed from: b */
    public WebResourceResponse m77055b(String str) throws Throwable {
        String str2;
        String str3 = this.f58576a.get(str);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            InputStream inputStreamM77072f = C12830i.m77072f(C12822a.m76973e() + str3);
            if (inputStreamM77072f == null) {
                return null;
            }
            if (str.contains(".css")) {
                C12836o.m77097b("DataHelper", "mimeType is css", false);
                str2 = "text/css";
            } else if (str.contains(".png") || str.contains(".ico") || str.contains(".gif")) {
                C12836o.m77097b("DataHelper", "mimeType is png", false);
                str2 = "image/*";
            } else {
                if (!str.contains(".js")) {
                    C12836o.m77097b("DataHelper", "getReplacedWebResourceResponse: mimetype default", false);
                    return null;
                }
                C12836o.m77097b("DataHelper", "mimeType is js", false);
                str2 = "text/javascript";
            }
            C12836o.m77097b("DataHelper", "getReplacedWebResourceResponse = " + this.f58576a.get(str), false);
            return new WebResourceResponse(str2, "utf-8", inputStreamM77072f);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
            C12836o.m77099d("DataHelper", "get hw folder or parse InputSteam failed", true);
            return null;
        }
    }
}
