package p316gk;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.text.Normalizer;

/* renamed from: gk.h */
/* loaded from: classes6.dex */
public interface InterfaceC9958h {

    /* renamed from: gk.h$a */
    public class a implements InterfaceC9958h {

        /* renamed from: a */
        public final /* synthetic */ String f48767a;

        public a(String str) {
            this.f48767a = str;
        }

        @Override // p316gk.InterfaceC9958h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public String mo61778f(Object obj) {
            if (obj == null) {
                return null;
            }
            String strNormalize = Normalizer.normalize(String.valueOf(obj), Normalizer.Form.NFC);
            if (strNormalize.equals("null")) {
                return null;
            }
            return (strNormalize.startsWith("'") && strNormalize.endsWith("'") && strNormalize.length() > 1) ? strNormalize.substring(1, strNormalize.length() - 1) : strNormalize;
        }

        @Override // p316gk.InterfaceC9958h
        public String name() {
            return this.f48767a;
        }
    }

    /* renamed from: gk.h$b */
    public class b implements InterfaceC9958h {

        /* renamed from: a */
        public final /* synthetic */ String f48768a;

        public b(String str) {
            this.f48768a = str;
        }

        @Override // p316gk.InterfaceC9958h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer mo61778f(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (!(obj instanceof String)) {
                if (obj instanceof Boolean) {
                    return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                throw new C9952b("Unsupported to normalize the value: " + obj + " to integer.");
            }
            String str = (String) obj;
            if (str.equalsIgnoreCase(FaqConstants.DISABLE_HA_REPORT)) {
                return 1;
            }
            if (str.equalsIgnoreCase("false")) {
                return 0;
            }
            if ("null".equals(obj)) {
                return null;
            }
            return Integer.valueOf(InterfaceC9958h.m61772b(str, 0));
        }

        @Override // p316gk.InterfaceC9958h
        public String name() {
            return this.f48768a;
        }
    }

    /* renamed from: gk.h$c */
    public class c implements InterfaceC9958h {

        /* renamed from: a */
        public final /* synthetic */ String f48769a;

        public c(String str) {
            this.f48769a = str;
        }

        @Override // p316gk.InterfaceC9958h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long mo61778f(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
            if (obj instanceof String) {
                if ("null".equals(obj)) {
                    return null;
                }
                return Long.valueOf(InterfaceC9958h.m61777h((String) obj, 0L));
            }
            throw new C9952b("Unsupported to normalize the value: " + obj + " to long.");
        }

        @Override // p316gk.InterfaceC9958h
        public String name() {
            return this.f48769a;
        }
    }

    /* renamed from: gk.h$d */
    public class d implements InterfaceC9958h {

        /* renamed from: a */
        public final /* synthetic */ String f48770a;

        public d(String str) {
            this.f48770a = str;
        }

        @Override // p316gk.InterfaceC9958h
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Double mo61778f(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (obj instanceof String) {
                if ("null".equals(obj)) {
                    return null;
                }
                return Double.valueOf(InterfaceC9958h.m61775e((String) obj, 0.0d));
            }
            throw new C9952b("Unsupported to normalize the value: " + obj + " to double.");
        }

        @Override // p316gk.InterfaceC9958h
        public String name() {
            return this.f48770a;
        }
    }

    /* renamed from: a */
    static InterfaceC9958h m61771a(String str) {
        return new b(str);
    }

    /* renamed from: b */
    static int m61772b(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    /* renamed from: c */
    static InterfaceC9958h m61773c(String str) {
        return new c(str);
    }

    /* renamed from: d */
    static InterfaceC9958h m61774d(String str) {
        return new a(str);
    }

    /* renamed from: e */
    static double m61775e(String str, double d10) {
        if (str == null) {
            return d10;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    /* renamed from: g */
    static InterfaceC9958h m61776g(String str) {
        return new d(str);
    }

    /* renamed from: h */
    static long m61777h(String str, long j10) {
        if (str == null) {
            return j10;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    /* renamed from: f */
    Object mo61778f(Object obj);

    String name();
}
