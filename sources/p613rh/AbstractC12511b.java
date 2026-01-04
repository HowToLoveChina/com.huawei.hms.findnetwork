package p613rh;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import th.C13012a;

/* renamed from: rh.b */
/* loaded from: classes4.dex */
public abstract class AbstractC12511b {
    /* renamed from: a */
    public static String m75108a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, Constants.UTF_8).replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
        } catch (UnsupportedEncodingException unused) {
            C13012a.m78317c("StringUtils", "encode2utf8 error");
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m75109b(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith("}");
    }
}
