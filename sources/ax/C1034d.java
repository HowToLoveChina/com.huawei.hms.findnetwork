package ax;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.nio.charset.Charset;
import p692uw.C13267j;

/* renamed from: ax.d */
/* loaded from: classes9.dex */
public final class C1034d {

    /* renamed from: a */
    public static final C1034d f5098a = new C1034d();

    /* renamed from: b */
    public static final Charset f5099b;

    /* renamed from: c */
    public static final Charset f5100c;

    /* renamed from: d */
    public static final Charset f5101d;

    /* renamed from: e */
    public static final Charset f5102e;

    /* renamed from: f */
    public static final Charset f5103f;

    /* renamed from: g */
    public static final Charset f5104g;

    static {
        Charset charsetForName = Charset.forName(Constants.UTF_8);
        C13267j.m79676d(charsetForName, "forName(\"UTF-8\")");
        f5099b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        C13267j.m79676d(charsetForName2, "forName(\"UTF-16\")");
        f5100c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        C13267j.m79676d(charsetForName3, "forName(\"UTF-16BE\")");
        f5101d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        C13267j.m79676d(charsetForName4, "forName(\"UTF-16LE\")");
        f5102e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        C13267j.m79676d(charsetForName5, "forName(\"US-ASCII\")");
        f5103f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        C13267j.m79676d(charsetForName6, "forName(\"ISO-8859-1\")");
        f5104g = charsetForName6;
    }
}
