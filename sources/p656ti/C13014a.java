package p656ti;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import ki.C11055a;

/* renamed from: ti.a */
/* loaded from: classes.dex */
public final class C13014a {

    /* renamed from: a */
    public static final AbstractC13015b f59266a = new C13016c("-_.*", true);

    /* renamed from: b */
    public static final AbstractC13015b f59267b = new C13016c("-_.!~*'()@:$&,;=", false);

    /* renamed from: c */
    public static final AbstractC13015b f59268c = new C13016c("-_.!~*'()@:$&,;=+/?", false);

    /* renamed from: d */
    public static final AbstractC13015b f59269d = new C13016c("-_.!~*'():$&,;=", false);

    /* renamed from: e */
    public static final AbstractC13015b f59270e = new C13016c("-_.!~*'()@:$,/?:", false);

    /* renamed from: a */
    public static String m78323a(String str) {
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            throw new C11055a(e10);
        }
    }

    /* renamed from: b */
    public static String m78324b(String str) {
        return f59266a.mo78329a(str);
    }

    /* renamed from: c */
    public static String m78325c(String str) {
        return f59267b.mo78329a(str);
    }

    /* renamed from: d */
    public static String m78326d(String str) {
        return f59268c.mo78329a(str);
    }

    /* renamed from: e */
    public static String m78327e(String str) {
        return f59270e.mo78329a(str);
    }

    /* renamed from: f */
    public static String m78328f(String str) {
        return f59269d.mo78329a(str);
    }
}
