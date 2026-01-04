package p469m4;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p417k4.C10983b;
import p417k4.C10987f;
import p417k4.InterfaceC10985d;
import p443l4.InterfaceC11231c;
import p484n4.C11632a;

/* renamed from: m4.c */
/* loaded from: classes.dex */
public class C11402c implements InterfaceC10985d {

    /* renamed from: a */
    public final String f53149a;

    /* renamed from: b */
    public final Context f53150b;

    /* renamed from: c */
    public final String f53151c;

    /* renamed from: d */
    public final C10983b f53152d;

    /* renamed from: e */
    public final InterfaceC11231c f53153e;

    /* renamed from: f */
    public final C11405f f53154f;

    /* renamed from: g */
    public final Map<String, String> f53155g;

    /* renamed from: h */
    public final List<C11632a> f53156h;

    /* renamed from: i */
    public final Map<String, String> f53157i = new HashMap();

    public C11402c(Context context, String str, C10983b c10983b, InputStream inputStream, Map<String, String> map, List<C11632a> list, String str2) throws IOException {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f53150b = context;
        str = str == null ? context.getPackageName() : str;
        this.f53151c = str;
        if (inputStream != null) {
            this.f53153e = new C11409j(inputStream, str);
            C11401b.m68318a(inputStream);
        } else {
            this.f53153e = new C11413n(context, str);
        }
        this.f53154f = new C11405f(this.f53153e);
        C10983b c10983b2 = C10983b.f52043b;
        if (c10983b != c10983b2 && "1.0".equals(this.f53153e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f53152d = (c10983b == null || c10983b == c10983b2) ? C11401b.m68323f(this.f53153e.getString("/region", null), this.f53153e.getString("/agcgw/url", null)) : c10983b;
        this.f53155g = C11401b.m68321d(map);
        this.f53156h = list;
        this.f53149a = str2 == null ? m68327f() : str2;
    }

    /* renamed from: d */
    private String m68325d(String str) {
        Map<String, C10987f.a> mapM66360a = C10987f.m66360a();
        if (!mapM66360a.containsKey(str)) {
            return null;
        }
        if (this.f53157i.containsKey(str)) {
            return this.f53157i.get(str);
        }
        C10987f.a aVar = mapM66360a.get(str);
        if (aVar == null) {
            return null;
        }
        String strMo66362a = aVar.mo66362a(this);
        this.f53157i.put(str, strMo66362a);
        return strMo66362a;
    }

    @Override // p417k4.InterfaceC10985d
    /* renamed from: a */
    public String mo66355a() {
        return this.f53149a;
    }

    @Override // p417k4.InterfaceC10985d
    /* renamed from: b */
    public String mo66356b(String str) {
        return m68328g(str, null);
    }

    @Override // p417k4.InterfaceC10985d
    /* renamed from: c */
    public C10983b mo66357c() {
        C10983b c10983b = this.f53152d;
        return c10983b == null ? C10983b.f52043b : c10983b;
    }

    /* renamed from: e */
    public List<C11632a> m68326e() {
        return this.f53156h;
    }

    /* renamed from: f */
    public final String m68327f() {
        return String.valueOf(("{packageName='" + this.f53151c + "', routePolicy=" + this.f53152d + ", reader=" + this.f53153e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f53155g).toString().hashCode() + '}').hashCode());
    }

    /* renamed from: g */
    public String m68328g(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String strM68322e = C11401b.m68322e(str);
        String str3 = this.f53155g.get(strM68322e);
        if (str3 != null) {
            return str3;
        }
        String strM68325d = m68325d(strM68322e);
        if (strM68325d != null) {
            return strM68325d;
        }
        String string = this.f53153e.getString(strM68322e, str2);
        return C11405f.m68342c(string) ? this.f53154f.mo67439a(string, str2) : string;
    }

    @Override // p417k4.InterfaceC10985d
    public Context getContext() {
        return this.f53150b;
    }
}
