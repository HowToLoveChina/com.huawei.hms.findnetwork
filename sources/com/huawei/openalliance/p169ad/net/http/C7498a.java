package com.huawei.openalliance.p169ad.net.http;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7079dw;
import com.huawei.openalliance.p169ad.InterfaceC7352jz;
import com.huawei.openalliance.p169ad.InterfaceC7354ka;
import com.huawei.openalliance.p169ad.InterfaceC7355kb;
import com.huawei.openalliance.p169ad.InterfaceC7356kc;
import com.huawei.openalliance.p169ad.InterfaceC7357kd;
import com.huawei.openalliance.p169ad.InterfaceC7358ke;
import com.huawei.openalliance.p169ad.InterfaceC7359kf;
import com.huawei.openalliance.p169ad.InterfaceC7360kg;
import com.huawei.openalliance.p169ad.InterfaceC7361kh;
import com.huawei.openalliance.p169ad.InterfaceC7362ki;
import com.huawei.openalliance.p169ad.InterfaceC7363kj;
import com.huawei.openalliance.p169ad.InterfaceC7364kk;
import com.huawei.openalliance.p169ad.InterfaceC7365kl;
import com.huawei.openalliance.p169ad.InterfaceC7366km;
import com.huawei.openalliance.p169ad.InterfaceC7367kn;
import com.huawei.openalliance.p169ad.InterfaceC7372ks;
import com.huawei.openalliance.p169ad.InterfaceC7377kx;
import com.huawei.openalliance.p169ad.beans.server.AdContentReq;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.net.http.C7503f;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7791ck;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7836o;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.huawei.openalliance.ad.net.http.a */
/* loaded from: classes2.dex */
public class C7498a {

    /* renamed from: a */
    static final Pattern f34793a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: b */
    final Class<?> f34794b;

    /* renamed from: c */
    final C7503f f34795c;

    /* renamed from: d */
    final String f34796d;

    /* renamed from: e */
    final String f34797e;

    /* renamed from: f */
    final C7500c f34798f;

    /* renamed from: g */
    final String f34799g;

    /* renamed from: h */
    final int f34800h;

    /* renamed from: i */
    final List<String> f34801i;

    /* renamed from: j */
    final byte[] f34802j;

    /* renamed from: k */
    final boolean f34803k;

    /* renamed from: l */
    final int f34804l;

    /* renamed from: m */
    final InterfaceC7377kx f34805m;

    /* renamed from: com.huawei.openalliance.ad.net.http.a$a */
    public static class a {

        /* renamed from: a */
        final C7502e f34806a;

        /* renamed from: b */
        final Method f34807b;

        /* renamed from: c */
        final Object[] f34808c;

        /* renamed from: d */
        final String f34809d;

        /* renamed from: e */
        final C7500c f34810e;

        /* renamed from: f */
        Class<?> f34811f;

        /* renamed from: g */
        C7503f f34812g;

        /* renamed from: h */
        String f34813h;

        /* renamed from: i */
        String f34814i;

        /* renamed from: l */
        byte[] f34817l;

        /* renamed from: m */
        String f34818m;

        /* renamed from: t */
        InterfaceC7377kx f34825t;

        /* renamed from: j */
        final List<String> f34815j = new ArrayList(4);

        /* renamed from: k */
        final Set<String> f34816k = new LinkedHashSet();

        /* renamed from: n */
        int f34819n = 0;

        /* renamed from: o */
        int f34820o = 0;

        /* renamed from: p */
        int f34821p = 0;

        /* renamed from: q */
        boolean f34822q = false;

        /* renamed from: r */
        boolean f34823r = false;

        /* renamed from: s */
        int f34824s = 0;

        public a(C7502e c7502e, Method method, Object[] objArr, C7500c c7500c, InterfaceC7365kl interfaceC7365kl) {
            this.f34806a = c7502e;
            this.f34807b = method;
            this.f34809d = method.getName();
            this.f34808c = objArr == null ? new Object[0] : objArr;
            this.f34810e = c7500c;
            this.f34812g = interfaceC7365kl != null ? new C7503f.a(interfaceC7365kl.m45452b()).m46072a(c7502e.f34836h, interfaceC7365kl.m45451a()).m46074a() : c7502e.f34829a;
        }

        /* renamed from: b */
        private void m46033b() {
            if (this.f34807b.getReturnType() != Response.class) {
                throw m46019a("Return type must be com.huawei.openplatform.baselibrary.net.http.Response!", new Object[0]);
            }
            Type genericReturnType = this.f34807b.getGenericReturnType();
            if (!(genericReturnType instanceof ParameterizedType)) {
                throw m46019a("Return type must be parameterized, eg. Response<Foo>.", new Object[0]);
            }
            this.f34811f = AbstractC7791ck.m48056a(AbstractC7791ck.m48059a(0, (ParameterizedType) genericReturnType));
        }

        /* renamed from: c */
        private void m46035c() throws UnsupportedEncodingException {
            Annotation[][] parameterAnnotations = this.f34807b.getParameterAnnotations();
            int length = parameterAnnotations.length;
            if (length != this.f34808c.length) {
                throw m46019a("Parameter annotation number doesn't equal to parameter number", new Object[0]);
            }
            for (int i10 = 0; i10 < length; i10++) {
                Annotation[] annotationArr = parameterAnnotations[i10];
                if (annotationArr == null || annotationArr.length == 0) {
                    throw m46019a("Argument " + i10 + " doesn't have annotations!", new Object[0]);
                }
                for (Annotation annotation : annotationArr) {
                    m46031a(annotation, i10);
                }
            }
        }

        /* renamed from: d */
        private void m46037d() {
            for (Annotation annotation : this.f34807b.getAnnotations()) {
                m46030a(annotation);
            }
        }

        /* renamed from: e */
        private void m46039e() {
            this.f34810e.m46050a(this.f34806a.m46058a((InterfaceC7359kf) this.f34807b.getAnnotation(InterfaceC7359kf.class)));
        }

        /* renamed from: f */
        private void m46041f(Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @HeaderMap annotation must not be null!", Integer.valueOf(i10));
            }
            if (!(obj instanceof Map)) {
                throw m46019a("Argument %d with @HeaderMap annotation can only be Map type!", Integer.valueOf(i10));
            }
            for (Object obj2 : ((Map) obj).entrySet()) {
                if (!(obj2 instanceof Map.Entry)) {
                    return;
                }
                Map.Entry entry = (Map.Entry) obj2;
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    throw m46019a("The key in HeaderMap must be String type [Argument %d]!", Integer.valueOf(i10));
                }
                Object value = entry.getValue();
                if (!(value instanceof String)) {
                    throw m46019a("The value in HeaderMap must be String type [Argument %d]!", Integer.valueOf(i10));
                }
                this.f34810e.m46051a((String) key, (String) value);
            }
        }

        /* renamed from: a */
        public C7498a m46042a() throws UnsupportedEncodingException {
            m46033b();
            m46037d();
            if (TextUtils.isEmpty(this.f34813h)) {
                throw m46019a("Http method annotation is needed! (eg. GET, POST etc.", new Object[0]);
            }
            if (this.f34814i == null) {
                throw m46019a("Url is not specified in @GET or @POST etc.", new Object[0]);
            }
            m46035c();
            if (this.f34812g != null) {
                return new C7498a(this);
            }
            throw m46019a("No url found in the request!", new Object[0]);
        }

        /* renamed from: a */
        private RuntimeException m46019a(String str, Object... objArr) {
            StringBuilder sb2 = new StringBuilder();
            if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.ENGLISH, str, objArr);
            }
            sb2.append(str);
            sb2.append(" (method: ");
            sb2.append(this.f34809d);
            sb2.append(")");
            String string = sb2.toString();
            AbstractC7185ho.m43823c("AccessMethod.Builder", string);
            return new IllegalArgumentException(string);
        }

        /* renamed from: b */
        private void m46034b(Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @Gzip annotation must not be null!", Integer.valueOf(i10));
            }
            if (obj.getClass() != Boolean.TYPE && !(obj instanceof Boolean)) {
                throw m46019a("Argument %d with @Gzip annotation must be boolean or Boolean", Integer.valueOf(i10));
            }
            this.f34823r = ((Boolean) obj).booleanValue();
        }

        /* renamed from: c */
        private void m46036c(Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @UserAgentSource annotation must not be null!", Integer.valueOf(i10));
            }
            if (obj.getClass() != Integer.TYPE && !(obj instanceof Integer)) {
                throw m46019a("Argument %d with @UserAgentSource annotation must be int or Integer", Integer.valueOf(i10));
            }
            this.f34821p = ((Integer) obj).intValue();
        }

        /* renamed from: d */
        private void m46038d(Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @ResponseConverter annotation must not be null!", Integer.valueOf(i10));
            }
            if (!(obj instanceof InterfaceC7377kx)) {
                throw m46019a("Argument %d with @Url annotation can only be IResponseConversionInterceptor type!", Integer.valueOf(i10));
            }
            this.f34825t = (InterfaceC7377kx) obj;
        }

        /* renamed from: e */
        private void m46040e(Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @ResponseEntity annotation must not be null!", Integer.valueOf(i10));
            }
            if (!(obj instanceof Class)) {
                throw m46019a("Argument %d with @HeaderMap annotation can only be Class type!", Integer.valueOf(i10));
            }
            this.f34811f = (Class) obj;
        }

        /* renamed from: a */
        private Set<String> m46020a(String str) {
            Matcher matcher = C7498a.f34793a.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        /* renamed from: a */
        private void m46021a(InterfaceC7357kd interfaceC7357kd, Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @Header annotation must not be null!", Integer.valueOf(i10));
            }
            if (!(obj instanceof String)) {
                throw m46019a("Argument %d with @Header annotation can only be String type!", Integer.valueOf(i10));
            }
            this.f34810e.m46051a(interfaceC7357kd.m45446a(), (String) obj);
        }

        /* renamed from: a */
        private void m46022a(InterfaceC7361kh interfaceC7361kh, Object obj, int i10) {
            this.f34819n++;
            String strM45449a = interfaceC7361kh.m45449a();
            if (!this.f34816k.contains(strM45449a)) {
                throw m46019a("Path name {" + strM45449a + "} (arg " + i10 + ") not existed in path url!", new Object[0]);
            }
            if (this.f34819n > this.f34816k.size()) {
                throw m46019a("@Path argument number is more than the path param elements in url", new Object[0]);
            }
            if (obj == null) {
                throw m46019a("Path {" + strM45449a + "} argument value cannot be null!", new Object[0]);
            }
            try {
                String strMo45455a = InterfaceC7372ks.a.m45457a(this.f34806a.f34836h, obj.getClass()).mo45455a(obj, this.f34806a.f34833e);
                this.f34814i = this.f34814i.replace("{" + strM45449a + "}", strMo45455a);
            } catch (Exception unused) {
                throw m46019a("process path annotation error", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m46023a(InterfaceC7362ki interfaceC7362ki, Object obj, int i10) {
            String strMo45455a;
            if (obj == null) {
                strMo45455a = "null";
            } else {
                try {
                    strMo45455a = InterfaceC7372ks.a.m45457a(this.f34806a.f34836h, obj.getClass()).mo45455a(obj, this.f34806a.f34833e);
                } catch (Exception unused) {
                    throw m46019a("process query annotation error", new Object[0]);
                }
            }
            String strM45450a = interfaceC7362ki.m45450a();
            if (TextUtils.isEmpty(strM45450a)) {
                throw m46019a("Query name of " + i10 + " arg cannot not be empty!", new Object[0]);
            }
            this.f34815j.add(strM45450a + "=" + strMo45455a);
        }

        /* renamed from: a */
        private void m46024a(InterfaceC7365kl interfaceC7365kl) {
            this.f34812g = new C7503f.a(interfaceC7365kl.m45452b()).m46072a(this.f34806a.f34836h, interfaceC7365kl.m45451a()).m46074a();
        }

        /* renamed from: a */
        private void m46025a(InterfaceC7366km interfaceC7366km) {
            this.f34821p = interfaceC7366km.m45453a();
        }

        /* renamed from: a */
        private void m46026a(Object obj) throws UnsupportedEncodingException {
            int i10 = this.f34820o + 1;
            this.f34820o = i10;
            if (i10 > 1) {
                throw m46019a("There are more than one @Body arguments in method!", new Object[0]);
            }
            if (obj == null) {
                this.f34817l = null;
                return;
            }
            if (obj instanceof byte[]) {
                this.f34817l = (byte[]) obj;
                return;
            }
            if (2 == this.f34824s && (obj instanceof AdContentReq)) {
                this.f34817l = C7079dw.m42738a((AdContentReq) obj);
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("AccessMethod.Builder", "req in fb, origin body: %s", AbstractC7758be.m47742b((AdContentReq) obj));
                    AbstractC7185ho.m43818a("AccessMethod.Builder", "req in fb, base64 body: %s", AbstractC7836o.m48492a(this.f34817l));
                    return;
                }
                return;
            }
            InterfaceC7372ks interfaceC7372ksM45457a = InterfaceC7372ks.a.m45457a(this.f34806a.f34836h, obj.getClass());
            this.f34818m = interfaceC7372ksM45457a.mo45456a();
            try {
                try {
                    byte[] bytes = interfaceC7372ksM45457a.mo45455a(obj, this.f34806a.f34833e).getBytes(Constants.UTF_8);
                    this.f34817l = bytes;
                    if (this.f34823r) {
                        this.f34817l = m46032a(bytes);
                    }
                    this.f34822q = this.f34823r;
                } catch (UnsupportedEncodingException unused) {
                    throw m46019a("UnsupportedEncodingException in get bytes from content", new Object[0]);
                }
            } catch (Exception unused2) {
                throw m46019a("process body annotation error", new Object[0]);
            }
        }

        /* renamed from: a */
        private void m46027a(Object obj, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @FB annotation must not be null!", Integer.valueOf(i10));
            }
            if (obj.getClass() != Integer.TYPE && !(obj instanceof Integer)) {
                throw m46019a("Argument %d with @Fb annotation must be int or Integer", Integer.valueOf(i10));
            }
            this.f34824s = ((Integer) obj).intValue();
        }

        /* renamed from: a */
        private void m46028a(Object obj, boolean z10, int i10) {
            if (obj == null) {
                throw m46019a("Argument %d with @Url annotation must not be null!", Integer.valueOf(i10));
            }
            if (!(obj instanceof String)) {
                throw m46019a("Argument %d with @Url annotation can only be String type!", Integer.valueOf(i10));
            }
            if (!TextUtils.isEmpty(this.f34814i)) {
                throw m46019a("Relative path in GET/POST annotation must be empty with @Url annotation as parameter!", new Object[0]);
            }
            this.f34812g = new C7503f.a(z10).m46072a(this.f34806a.f34836h, (String) obj).m46074a();
        }

        /* renamed from: a */
        private void m46029a(String str, String str2) {
            this.f34813h = str;
            this.f34814i = str2;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (C7498a.f34793a.matcher(strSubstring).find()) {
                    throw m46019a("URL query \"%s\" must not have replace block. use @Query instead.", strSubstring);
                }
            }
            this.f34816k.addAll(m46020a(str2));
        }

        /* renamed from: a */
        private void m46030a(Annotation annotation) {
            String strM45448a;
            String str;
            if (annotation instanceof InterfaceC7355kb) {
                strM45448a = ((InterfaceC7355kb) annotation).m45445a();
                str = "GET";
            } else {
                if (!(annotation instanceof InterfaceC7360kg)) {
                    if (annotation instanceof InterfaceC7359kf) {
                        m46039e();
                        return;
                    } else if (annotation instanceof InterfaceC7365kl) {
                        m46024a((InterfaceC7365kl) annotation);
                        return;
                    } else {
                        if (annotation instanceof InterfaceC7366km) {
                            m46025a((InterfaceC7366km) annotation);
                            return;
                        }
                        return;
                    }
                }
                strM45448a = ((InterfaceC7360kg) annotation).m45448a();
                str = "POST";
            }
            m46029a(str, strM45448a);
        }

        /* renamed from: a */
        private void m46031a(Annotation annotation, int i10) throws UnsupportedEncodingException {
            if (annotation instanceof InterfaceC7361kh) {
                m46022a((InterfaceC7361kh) annotation, this.f34808c[i10], i10);
                return;
            }
            if (annotation instanceof InterfaceC7362ki) {
                m46023a((InterfaceC7362ki) annotation, this.f34808c[i10], i10);
                return;
            }
            if (annotation instanceof InterfaceC7352jz) {
                m46026a(this.f34808c[i10]);
                return;
            }
            if (annotation instanceof InterfaceC7357kd) {
                m46021a((InterfaceC7357kd) annotation, this.f34808c[i10], i10);
                return;
            }
            if (annotation instanceof InterfaceC7358ke) {
                m46041f(this.f34808c[i10], i10);
                return;
            }
            if (annotation instanceof InterfaceC7364kk) {
                m46040e(this.f34808c[i10], i10);
                return;
            }
            if (annotation instanceof InterfaceC7365kl) {
                m46028a(this.f34808c[i10], ((InterfaceC7365kl) annotation).m45452b(), i10);
                return;
            }
            if (annotation instanceof InterfaceC7363kj) {
                m46038d(this.f34808c[i10], i10);
                return;
            }
            if (annotation instanceof InterfaceC7367kn) {
                m46036c(this.f34808c[i10], i10);
            } else if (annotation instanceof InterfaceC7356kc) {
                m46034b(this.f34808c[i10], i10);
            } else if (annotation instanceof InterfaceC7354ka) {
                m46027a(this.f34808c[i10], i10);
            }
        }

        /* renamed from: a */
        private static byte[] m46032a(byte[] bArr) {
            GZIPOutputStream gZIPOutputStream;
            AbstractC7185ho.m43820b("AccessMethod.Builder", "gzip content");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                th = th3;
                try {
                    AbstractC7185ho.m43823c("AccessMethod.Builder", "gzip fail " + th.getClass().getSimpleName());
                    return null;
                } finally {
                    AbstractC7805cy.m48142a(gZIPOutputStream);
                    AbstractC7805cy.m48142a(byteArrayOutputStream);
                }
            }
        }
    }

    private C7498a(a aVar) {
        this.f34794b = aVar.f34811f;
        this.f34795c = aVar.f34812g;
        this.f34796d = aVar.f34814i;
        this.f34797e = aVar.f34813h;
        this.f34801i = aVar.f34815j;
        this.f34802j = aVar.f34817l;
        this.f34798f = aVar.f34810e;
        this.f34805m = aVar.f34825t;
        this.f34799g = aVar.f34818m;
        this.f34800h = aVar.f34821p;
        this.f34803k = aVar.f34822q;
        this.f34804l = aVar.f34824s;
    }

    /* renamed from: a */
    public boolean m46016a() {
        return this.f34795c.m46069a();
    }

    /* renamed from: b */
    public String m46017b() {
        return this.f34795c.m46070b();
    }

    /* renamed from: c */
    public String m46018c() {
        StringBuilder sb2 = new StringBuilder(this.f34795c.m46071c());
        if (!TextUtils.isEmpty(this.f34796d)) {
            if (!this.f34796d.startsWith("/")) {
                sb2.append(C5929g4.f26852n);
            }
            sb2.append(this.f34796d);
        }
        return sb2.toString();
    }

    public /* synthetic */ C7498a(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }
}
