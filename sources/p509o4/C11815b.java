package p509o4;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p417k4.AbstractC10984c;
import p417k4.C10983b;
import p417k4.C10987f;
import p417k4.InterfaceC10985d;
import p443l4.AbstractC11229a;
import p469m4.C11402c;
import p484n4.C11632a;

/* renamed from: o4.b */
/* loaded from: classes.dex */
public class C11815b extends AbstractC10984c {

    /* renamed from: d */
    public static List<C11632a> f54709d;

    /* renamed from: e */
    public static final Map<String, AbstractC10984c> f54710e = new HashMap();

    /* renamed from: f */
    public static String f54711f;

    /* renamed from: a */
    public final InterfaceC10985d f54712a;

    /* renamed from: b */
    public final C11817d f54713b;

    /* renamed from: c */
    public final C11817d f54714c;

    /* renamed from: o4.b$a */
    public static class a implements C10987f.a {
        @Override // p417k4.C10987f.a
        /* renamed from: a */
        public String mo66362a(InterfaceC10985d interfaceC10985d) {
            String str;
            if (interfaceC10985d.mo66357c().equals(C10983b.f52044c)) {
                str = "/agcgw_all/CN";
            } else if (interfaceC10985d.mo66357c().equals(C10983b.f52046e)) {
                str = "/agcgw_all/RU";
            } else if (interfaceC10985d.mo66357c().equals(C10983b.f52045d)) {
                str = "/agcgw_all/DE";
            } else {
                if (!interfaceC10985d.mo66357c().equals(C10983b.f52047f)) {
                    return null;
                }
                str = "/agcgw_all/SG";
            }
            return interfaceC10985d.mo66356b(str);
        }
    }

    /* renamed from: o4.b$b */
    public static class b implements C10987f.a {
        @Override // p417k4.C10987f.a
        /* renamed from: a */
        public String mo66362a(InterfaceC10985d interfaceC10985d) {
            String str;
            if (interfaceC10985d.mo66357c().equals(C10983b.f52044c)) {
                str = "/agcgw_all/CN_back";
            } else if (interfaceC10985d.mo66357c().equals(C10983b.f52046e)) {
                str = "/agcgw_all/RU_back";
            } else if (interfaceC10985d.mo66357c().equals(C10983b.f52045d)) {
                str = "/agcgw_all/DE_back";
            } else {
                if (!interfaceC10985d.mo66357c().equals(C10983b.f52047f)) {
                    return null;
                }
                str = "/agcgw_all/SG_back";
            }
            return interfaceC10985d.mo66356b(str);
        }
    }

    public C11815b(InterfaceC10985d interfaceC10985d) throws SecurityException {
        Log.d("AGC_Instance", "AGConnectInstanceImpl init");
        this.f54712a = interfaceC10985d;
        if (f54709d == null) {
            Log.e("AGC_Instance", "please call `initialize()` first");
        }
        this.f54713b = new C11817d(f54709d, interfaceC10985d.getContext());
        C11817d c11817d = new C11817d(null, interfaceC10985d.getContext());
        this.f54714c = c11817d;
        if (interfaceC10985d instanceof C11402c) {
            c11817d.m70389c(((C11402c) interfaceC10985d).m68326e(), interfaceC10985d.getContext());
        }
        Log.d("AGC_Instance", "AGConnectInstanceImpl init end");
    }

    /* renamed from: f */
    public static AbstractC10984c m70375f() {
        String str = f54711f;
        if (str == null) {
            str = "DEFAULT_INSTANCE";
        }
        return m70376g(str);
    }

    /* renamed from: g */
    public static synchronized AbstractC10984c m70376g(String str) {
        AbstractC10984c abstractC10984c;
        try {
            abstractC10984c = f54710e.get(str);
            if (abstractC10984c == null) {
                if ("DEFAULT_INSTANCE".equals(str)) {
                    Log.w("AGC_Instance", "please call `initialize()` first");
                } else {
                    Log.w("AGC_Instance", "not find instance for : " + str);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return abstractC10984c;
    }

    /* renamed from: h */
    public static AbstractC10984c m70377h(InterfaceC10985d interfaceC10985d) {
        return m70378i(interfaceC10985d, false);
    }

    /* renamed from: i */
    public static synchronized AbstractC10984c m70378i(InterfaceC10985d interfaceC10985d, boolean z10) {
        AbstractC10984c c11815b;
        Map<String, AbstractC10984c> map = f54710e;
        c11815b = map.get(interfaceC10985d.mo66355a());
        if (c11815b == null || z10) {
            c11815b = new C11815b(interfaceC10985d);
            map.put(interfaceC10985d.mo66355a(), c11815b);
        }
        return c11815b;
    }

    /* renamed from: j */
    public static synchronized void m70379j(Context context) {
        Log.w("AGC_Instance", "agc sdk initialize");
        if (f54710e.size() > 0) {
            Log.w("AGC_Instance", "Repeated invoking initialize");
        } else {
            m70380k(context, AbstractC11229a.m67436d(context));
        }
    }

    /* renamed from: k */
    public static synchronized void m70380k(Context context, InterfaceC10985d interfaceC10985d) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGC_Instance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            m70381l();
            if (f54709d == null) {
                f54709d = new C11816c(context).m70382a();
            }
            m70378i(interfaceC10985d, true);
            f54711f = interfaceC10985d.mo66355a();
            Log.i("AGC_Instance", "initFinish callback start");
            C11814a.m70374a();
            Log.i("AGC_Instance", "AGC SDK initialize end");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: l */
    public static void m70381l() {
        C10987f.m66361b("/agcgw/url", new a());
        C10987f.m66361b("/agcgw/backurl", new b());
    }

    @Override // p417k4.AbstractC10984c
    /* renamed from: b */
    public Context mo66353b() {
        return this.f54712a.getContext();
    }

    @Override // p417k4.AbstractC10984c
    /* renamed from: d */
    public InterfaceC10985d mo66354d() {
        return this.f54712a;
    }
}
