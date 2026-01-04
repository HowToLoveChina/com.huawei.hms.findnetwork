package p640sq;

import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;

/* renamed from: sq.x */
/* loaded from: classes8.dex */
public class C12845x {
    /* renamed from: a */
    public static String m77145a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String scheme = new URI(str.trim().replaceAll(" ", "%20").replaceAll("\\^", "%5E")).getScheme();
            return scheme == null ? "" : scheme;
        } catch (URISyntaxException unused) {
            C12836o.m77097b("UriUtils", "URISyntaxException", true);
            return "";
        }
    }
}
