package p469m4;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.LazyInputStream;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.HashMap;
import java.util.Map;
import p417k4.C10983b;
import p417k4.C10987f;
import p443l4.AbstractC11229a;
import p443l4.InterfaceC11231c;

/* renamed from: m4.d */
/* loaded from: classes.dex */
public class C11403d extends AbstractC11229a {

    /* renamed from: c */
    public final Context f53158c;

    /* renamed from: d */
    public final String f53159d;

    /* renamed from: e */
    public LazyInputStream f53160e;

    /* renamed from: f */
    public volatile InterfaceC11231c f53161f;

    /* renamed from: g */
    public final Object f53162g = new Object();

    /* renamed from: h */
    public C10983b f53163h = C10983b.f52043b;

    /* renamed from: i */
    public final Map<String, String> f53164i = new HashMap();

    /* renamed from: j */
    public volatile C11405f f53165j;

    public C11403d(Context context, String str) {
        this.f53158c = context;
        this.f53159d = str;
    }

    /* renamed from: f */
    public static String m68329f(String str) {
        int i10 = 0;
        if (str.length() > 0) {
            while (str.charAt(i10) == '/') {
                i10++;
            }
        }
        return C5929g4.f26852n + str.substring(i10);
    }

    @Override // p417k4.InterfaceC10985d
    /* renamed from: a */
    public String mo66355a() {
        return "DEFAULT_INSTANCE";
    }

    @Override // p417k4.InterfaceC10985d
    /* renamed from: b */
    public String mo66356b(String str) {
        return m68333j(str, null);
    }

    @Override // p417k4.InterfaceC10985d
    /* renamed from: c */
    public C10983b mo66357c() {
        Log.d("AGC_ConfigImpl", "getRoutePolicy");
        if (this.f53163h == null) {
            this.f53163h = C10983b.f52043b;
        }
        C10983b c10983b = this.f53163h;
        C10983b c10983b2 = C10983b.f52043b;
        if (c10983b == c10983b2 && this.f53161f == null) {
            m68330g();
        }
        C10983b c10983b3 = this.f53163h;
        return c10983b3 == null ? c10983b2 : c10983b3;
    }

    /* renamed from: g */
    public final void m68330g() {
        Log.d("AGC_ConfigImpl", "initConfigReader");
        if (this.f53161f == null) {
            synchronized (this.f53162g) {
                try {
                    if (this.f53161f == null) {
                        LazyInputStream lazyInputStream = this.f53160e;
                        if (lazyInputStream != null) {
                            this.f53161f = new C11409j(lazyInputStream.m12574c(), Constants.UTF_8);
                            this.f53160e.m12572a();
                            this.f53160e = null;
                        } else {
                            this.f53161f = new C11413n(this.f53158c, this.f53159d);
                        }
                        this.f53165j = new C11405f(this.f53161f);
                    }
                    m68332i();
                } finally {
                }
            }
        }
    }

    @Override // p417k4.InterfaceC10985d
    public Context getContext() {
        return this.f53158c;
    }

    /* renamed from: h */
    public final String m68331h(String str) {
        C10987f.a aVar;
        Map<String, C10987f.a> mapM66360a = C10987f.m66360a();
        if (mapM66360a.containsKey(str) && (aVar = mapM66360a.get(str)) != null) {
            return aVar.mo66362a(this);
        }
        return null;
    }

    /* renamed from: i */
    public final void m68332i() {
        if (this.f53163h == C10983b.f52043b) {
            if (this.f53161f != null) {
                this.f53163h = C11401b.m68323f(this.f53161f.getString("/region", null), this.f53161f.getString("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
    }

    /* renamed from: j */
    public String m68333j(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.f53161f == null) {
            m68330g();
        }
        String strM68329f = m68329f(str);
        String str3 = this.f53164i.get(strM68329f);
        if (str3 != null) {
            return str3;
        }
        String strM68331h = m68331h(strM68329f);
        if (strM68331h != null) {
            return strM68331h;
        }
        String string = this.f53161f.getString(strM68329f, str2);
        return C11405f.m68342c(string) ? this.f53165j.mo67439a(string, str2) : string;
    }
}
