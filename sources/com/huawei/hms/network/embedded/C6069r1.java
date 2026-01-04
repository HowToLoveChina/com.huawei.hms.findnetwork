package com.huawei.hms.network.embedded;

import android.os.UserManager;
import com.huawei.hms.framework.common.CheckParamUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.Utils;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5913f1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.r1 */
/* loaded from: classes8.dex */
public class C6069r1 extends Interceptor {

    /* renamed from: b */
    public static final String f27973b = "CacheInterceptor";

    /* renamed from: c */
    public static final String f27974c = "com.huawei.secure.android.common.encrypt.aes.AesGcm";

    /* renamed from: d */
    public static final ResponseBody f27975d = new C5939h1.g(new C5913f1.b().build());

    /* renamed from: e */
    public static final int f27976e = 307;

    /* renamed from: f */
    public static final int f27977f = 308;

    /* renamed from: g */
    public static final int f27978g = 504;

    /* renamed from: h */
    public static final int f27979h = 0;

    /* renamed from: i */
    public static final int f27980i = 1;

    /* renamed from: j */
    public static final int f27981j = 2;

    /* renamed from: k */
    public static final int f27982k = 3;

    /* renamed from: l */
    public static final int f27983l = 4;

    /* renamed from: a */
    public C6017n1 f27984a;

    /* renamed from: com.huawei.hms.network.embedded.r1$b */
    public static class b {

        /* renamed from: n */
        public static final String f27985n = "If-None-Match";

        /* renamed from: o */
        public static final String f27986o = "If-Modified-Since";

        /* renamed from: a */
        public final long f27987a;

        /* renamed from: b */
        public final c f27988b;

        /* renamed from: c */
        public Request f27989c;

        /* renamed from: d */
        public Date f27990d;

        /* renamed from: e */
        public String f27991e;

        /* renamed from: f */
        public Date f27992f;

        /* renamed from: g */
        public String f27993g;

        /* renamed from: h */
        public Date f27994h;

        /* renamed from: i */
        public long f27995i;

        /* renamed from: j */
        public long f27996j;

        /* renamed from: k */
        public C6043p1 f27997k;

        /* renamed from: l */
        public String f27998l;

        /* renamed from: m */
        public int f27999m;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(com.huawei.hms.network.embedded.C6069r1.c r8) {
            /*
                r7 = this;
                r7.<init>()
                r0 = -1
                r7.f27999m = r0
                long r1 = java.lang.System.currentTimeMillis()
                r7.f27987a = r1
                r7.f27988b = r8
                if (r8 == 0) goto Laf
                com.huawei.hms.network.embedded.p1 r1 = r8.m35188b()
                r7.f27997k = r1
                long r1 = r8.m35192f()
                r7.f27995i = r1
                long r1 = r8.m35187a()
                r7.f27996j = r1
                com.huawei.hms.network.httpclient.Response r8 = r8.m35190d()
                java.util.Map r8 = r8.getHeaders()
                com.huawei.hms.network.base.common.Headers r8 = com.huawei.hms.network.base.common.Headers.m33636of(r8)
                int r1 = r8.size()
                r2 = 0
                r3 = r2
            L34:
                if (r3 >= r1) goto Laf
                java.lang.String r4 = r8.name(r3)
                java.util.Locale r5 = java.util.Locale.ROOT
                java.lang.String r4 = r4.toLowerCase(r5)
                java.lang.String r5 = r8.value(r3)
                r4.hashCode()
                int r6 = r4.hashCode()
                switch(r6) {
                    case -1309235404: goto L7c;
                    case 96511: goto L71;
                    case 3076014: goto L66;
                    case 3123477: goto L5b;
                    case 150043680: goto L50;
                    default: goto L4e;
                }
            L4e:
                r4 = r0
                goto L86
            L50:
                java.lang.String r6 = "last-modified"
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L59
                goto L4e
            L59:
                r4 = 4
                goto L86
            L5b:
                java.lang.String r6 = "etag"
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L64
                goto L4e
            L64:
                r4 = 3
                goto L86
            L66:
                java.lang.String r6 = "date"
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L6f
                goto L4e
            L6f:
                r4 = 2
                goto L86
            L71:
                java.lang.String r6 = "age"
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L7a
                goto L4e
            L7a:
                r4 = 1
                goto L86
            L7c:
                java.lang.String r6 = "expires"
                boolean r4 = r4.equals(r6)
                if (r4 != 0) goto L85
                goto L4e
            L85:
                r4 = r2
            L86:
                switch(r4) {
                    case 0: goto La6;
                    case 1: goto L9f;
                    case 2: goto L96;
                    case 3: goto L93;
                    case 4: goto L8a;
                    default: goto L89;
                }
            L89:
                goto Lac
            L8a:
                java.util.Date r4 = com.huawei.hms.network.embedded.C6108u1.parse(r5)
                r7.f27992f = r4
                r7.f27993g = r5
                goto Lac
            L93:
                r7.f27998l = r5
                goto Lac
            L96:
                java.util.Date r4 = com.huawei.hms.network.embedded.C6108u1.parse(r5)
                r7.f27990d = r4
                r7.f27991e = r5
                goto Lac
            L9f:
                int r4 = com.huawei.hms.network.embedded.C6108u1.parseSeconds(r5, r0)
                r7.f27999m = r4
                goto Lac
            La6:
                java.util.Date r4 = com.huawei.hms.network.embedded.C6108u1.parse(r5)
                r7.f27994h = r4
            Lac:
                int r3 = r3 + 1
                goto L34
            Laf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6069r1.b.<init>(com.huawei.hms.network.embedded.r1$c):void");
        }

        /* renamed from: b */
        private long m35182b() {
            if (this.f27988b.m35191e().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.f27994h != null) {
                Date date = this.f27990d;
                long time = this.f27994h.getTime() - (date != null ? date.getTime() : this.f27996j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f27992f == null) {
                return 0L;
            }
            Date date2 = this.f27990d;
            long time2 = (date2 != null ? date2.getTime() : this.f27995i) - this.f27992f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public int m35184c() {
            String str;
            long jM35181a = m35181a();
            long jM35182b = m35182b();
            if (this.f27997k.maxAgeSeconds() != -1) {
                jM35182b = Math.min(jM35182b, TimeUnit.SECONDS.toMillis(this.f27997k.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = this.f27997k.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(this.f27997k.minFreshSeconds()) : 0L;
            if (!this.f27997k.mustRevalidate() && this.f27997k.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(this.f27997k.maxStaleSeconds());
            }
            if (!this.f27988b.m35191e().noCache()) {
                long j10 = millis2 + jM35181a;
                if (j10 < millis + jM35182b) {
                    if (j10 >= jM35182b) {
                        return 2;
                    }
                    return (jM35181a <= 86400000 || !m35186e()) ? 1 : 3;
                }
            }
            String str2 = this.f27998l;
            if (str2 != null) {
                str = f27985n;
            } else {
                Date date = this.f27992f;
                str = f27986o;
                if (date != null) {
                    str2 = this.f27993g;
                } else {
                    if (this.f27990d == null) {
                        return 0;
                    }
                    str2 = this.f27991e;
                }
            }
            this.f27989c = this.f27988b.m35189c().newBuilder().addHeader(str, str2).build();
            return 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public Request m35185d() {
            return this.f27989c;
        }

        /* renamed from: e */
        private boolean m35186e() {
            return this.f27988b.m35191e().maxAgeSeconds() == -1 && this.f27994h == null;
        }

        /* renamed from: a */
        private long m35181a() {
            Date date = this.f27990d;
            long jMax = date != null ? Math.max(0L, this.f27996j - date.getTime()) : 0L;
            int i10 = this.f27999m;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            return jMax + (this.f27987a - this.f27995i);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.r1$c */
    public static final class c {

        /* renamed from: a */
        public final long f28000a;

        /* renamed from: b */
        public final long f28001b;

        /* renamed from: c */
        public final Response<ResponseBody> f28002c;

        /* renamed from: d */
        public final Request f28003d;

        public c(long j10, long j11, Request request, Response<ResponseBody> response) {
            CheckParamUtils.checkNotNull(response, "response == null");
            CheckParamUtils.checkNotNull(request, "request == null");
            this.f28000a = j10;
            this.f28001b = j11;
            this.f28002c = response;
            this.f28003d = request;
        }

        /* renamed from: a */
        public long m35187a() {
            return this.f28001b;
        }

        /* renamed from: b */
        public C6043p1 m35188b() {
            return C6043p1.parse(Headers.m33636of(this.f28003d.getHeaders()));
        }

        /* renamed from: c */
        public Request m35189c() {
            return this.f28003d;
        }

        /* renamed from: d */
        public Response<ResponseBody> m35190d() {
            return this.f28002c;
        }

        /* renamed from: e */
        public C6043p1 m35191e() {
            return C6043p1.parse(Headers.m33636of(this.f28002c.getHeaders()));
        }

        /* renamed from: f */
        public long m35192f() {
            return this.f28000a;
        }
    }

    public C6069r1(C6017n1 c6017n1) {
        if (c6017n1 != null) {
            this.f27984a = c6017n1;
        }
    }

    /* renamed from: a */
    public static Headers m35170a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strName = headers.name(i10);
            String strValue = headers.value(i10);
            if ((!"Warning".equalsIgnoreCase(strName) || !strValue.startsWith("1")) && (m35177b(strName) || !m35178c(strName) || headers2.get(strName) == null)) {
                builder.add(strName, strValue);
            }
        }
        int size2 = headers2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            String strName2 = headers2.name(i11);
            if (!m35177b(strName2) && m35178c(strName2)) {
                builder.add(strName2, headers2.value(i11));
            }
        }
        return builder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
    
        if (r3.m35191e().isPrivate() == false) goto L33;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m35176b(com.huawei.hms.network.embedded.C6069r1.c r3) {
        /*
            com.huawei.hms.network.httpclient.Response r0 = r3.m35190d()
            int r0 = r0.getCode()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L66
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L66
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L66
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L66
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L66
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L66
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L35
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L66
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L66
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L66
            switch(r0) {
                case 300: goto L66;
                case 301: goto L66;
                case 302: goto L35;
                default: goto L34;
            }
        L34:
            goto L65
        L35:
            com.huawei.hms.network.httpclient.Response r0 = r3.m35190d()
            java.util.Map r0 = r0.getHeaders()
            java.lang.String r1 = "Expires"
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L66
            com.huawei.hms.network.embedded.p1 r0 = r3.m35191e()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L66
            com.huawei.hms.network.embedded.p1 r0 = r3.m35191e()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L66
            com.huawei.hms.network.embedded.p1 r0 = r3.m35191e()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L65
            goto L66
        L65:
            return r2
        L66:
            com.huawei.hms.network.embedded.p1 r0 = r3.m35191e()
            boolean r0 = r0.noStore()
            if (r0 != 0) goto L7b
            com.huawei.hms.network.embedded.p1 r3 = r3.m35188b()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L7b
            r2 = 1
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6069r1.m35176b(com.huawei.hms.network.embedded.r1$c):boolean");
    }

    /* renamed from: c */
    public static boolean m35178c(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: d */
    public static boolean m35179d(String str) {
        return str.equals("GET");
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor
    public Response<ResponseBody> intercept(Interceptor.Chain chain) throws Throwable {
        Request request = chain.request();
        if (request == null) {
            throw new IOException("cacheInterceptor: request == null");
        }
        C6017n1 c6017n1 = this.f27984a;
        if (c6017n1 == null || c6017n1.isInvalid() || !m35175a(f27974c)) {
            return chain.proceed(request);
        }
        if (!m35179d(request.getMethod())) {
            return chain.proceed(request);
        }
        C6043p1 c6043p1 = C6043p1.parse(Headers.m33636of(request.getHeaders()));
        if (!m35172a()) {
            Logger.m32141i(f27973b, "The device is locked");
            if (!c6043p1.onlyIfCached()) {
                return chain.proceed(request);
            }
            Logger.m32145w(f27973b, "Device first started and unlocked, only-If-Cached:gateway timeout, 504");
            return new C6107u0.b().code(504).message("Unsatisfiable Request (only-if-cached)").body(f27975d).url(request.getUrl()).build();
        }
        if (c6043p1.noStore()) {
            Logger.m32141i(f27973b, "request with header:no-store");
            return chain.proceed(request);
        }
        if (c6043p1.noCache() || m35173a(request)) {
            long currentTime = Utils.getCurrentTime(false);
            Response<ResponseBody> responseProceed = chain.proceed(request);
            Logger.m32141i(f27973b, "request with header:no-cache or if-modified-since/if-none-match");
            return m35171a(new c(currentTime, Utils.getCurrentTime(false), request, responseProceed));
        }
        if (c6043p1.onlyIfCached()) {
            c cVar = this.f27984a.get(request);
            if (cVar == null || cVar.m35190d() == null || !m35174a(cVar.m35190d().getBody())) {
                Logger.m32141i(f27973b, "only-If-Cached:gateway timeout, 504");
                return new C6107u0.b().url(request.getUrl()).code(504).message("Unsatisfiable Request (only-if-cached)").body(f27975d).build();
            }
            Logger.m32141i(f27973b, "only-If-Cached: available response");
            return cVar.m35190d();
        }
        c cVar2 = this.f27984a.get(request);
        if (cVar2 == null || cVar2.m35190d() == null) {
            long currentTime2 = Utils.getCurrentTime(false);
            Response<ResponseBody> responseProceed2 = chain.proceed(request);
            Logger.m32141i(f27973b, "Cache response is null, send the request to server");
            return m35171a(new c(currentTime2, Utils.getCurrentTime(false), request, responseProceed2));
        }
        b bVar = new b(cVar2);
        int iM35184c = bVar.m35184c();
        Logger.m32141i(f27973b, "cacheStrategy cacheStrategy code is: " + iM35184c);
        C6107u0.b bVarErrorBody = new C6107u0.b().headers(cVar2.m35190d().getHeaders()).url(cVar2.m35190d().getUrl()).message(cVar2.m35190d().getMessage()).code(cVar2.m35190d().getCode()).body(cVar2.m35190d().getBody()).errorBody(cVar2.m35190d().getErrorBody());
        if (iM35184c == 0) {
            long currentTime3 = Utils.getCurrentTime(false);
            Response<ResponseBody> responseProceed3 = chain.proceed(request);
            IoUtils.closeSecure(cVar2.m35190d());
            Logger.m32141i(f27973b, "Cache response is expried， and without Etag");
            return m35171a(new c(currentTime3, Utils.getCurrentTime(false), request, responseProceed3));
        }
        if (iM35184c == 1 && m35174a(cVar2.m35190d().getBody())) {
            Logger.m32141i(f27973b, "Cached response is not expried");
            return bVarErrorBody.build();
        }
        if (iM35184c == 2 && m35174a(cVar2.m35190d().getBody())) {
            bVarErrorBody.headers(Headers.m33637of("Warning", "110 HttpURLConnection \"Response is stale\"").toMultimap());
            Logger.m32141i(f27973b, "Warning: 110 HttpURLConnection \"Response is stale\"");
            return bVarErrorBody.build();
        }
        if (iM35184c == 3 && m35174a(cVar2.m35190d().getBody())) {
            bVarErrorBody.url(request.getUrl()).headers(Headers.m33637of("Warning", "113 HttpURLConnection \"Heuristic expiration\"").toMultimap());
            Logger.m32141i(f27973b, "Warning: 113 HttpURLConnection \"Heuristic expiration\"");
            return bVarErrorBody.build();
        }
        if (iM35184c != 4) {
            return chain.proceed(request);
        }
        long currentTime4 = Utils.getCurrentTime(false);
        Response<ResponseBody> responseProceed4 = chain.proceed(bVar.m35185d());
        int code = responseProceed4.getCode();
        Response<ResponseBody> responseM35190d = cVar2.m35190d();
        if (code != 304) {
            IoUtils.closeSecure(responseM35190d);
            return m35171a(new c(currentTime4, Utils.getCurrentTime(false), request, responseProceed4));
        }
        C6107u0 c6107u0Build = bVarErrorBody.headers(m35170a(Headers.m33636of(responseM35190d.getHeaders()), Headers.m33636of(responseProceed4.getHeaders())).toMultimap()).build();
        Logger.m32141i(f27973b, "http not modified: 304, update the cached response");
        IoUtils.closeSecure(responseProceed4.getBody());
        this.f27984a.update(new c(currentTime4, Utils.getCurrentTime(false), request, c6107u0Build));
        return c6107u0Build;
    }

    /* renamed from: a */
    private Response<ResponseBody> m35171a(c cVar) throws Throwable {
        Response<ResponseBody> responseM35190d = cVar.m35190d();
        if (C6107u0.hasBody(responseM35190d) && m35176b(cVar)) {
            InterfaceC6030o1 interfaceC6030o1Put = this.f27984a.put(cVar);
            String str = Headers.m33636of(responseM35190d.getHeaders()).get("Content-Length");
            if (interfaceC6030o1Put != null && C6108u1.stringToLong(str, -1L) <= C6117ua.f28548H) {
                C6056q1 c6056q1 = new C6056q1(responseM35190d.isSuccessful() ? responseM35190d.getBody() : responseM35190d.getErrorBody(), interfaceC6030o1Put);
                ResponseBody body = responseM35190d.getBody();
                C5913f1 c5913f1Build = new C5913f1.b().contentLength(body.getContentLength()).contentType(body.getContentType()).charSet(body.charSet).inputStream(c6056q1).build();
                Logger.m32141i(f27973b, "The response has been cached to the file");
                return new C6107u0.b().url(responseM35190d.getUrl()).code(responseM35190d.getCode()).headers(responseM35190d.getHeaders()).message(responseM35190d.getMessage()).body(new C5939h1.g(c5913f1Build)).build();
            }
        }
        Logger.m32141i(f27973b, "The response isn't cached to the file");
        return responseM35190d;
    }

    /* renamed from: b */
    public static boolean m35177b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* renamed from: a */
    private boolean m35172a() {
        UserManager userManager = (UserManager) ContextHolder.getAppContext().getSystemService("user");
        if (userManager != null) {
            return userManager.isUserUnlocked();
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m35173a(Request request) {
        return (request.getHeaders().get(b.f27986o) == null && request.getHeaders().get(b.f27985n) == null) ? false : true;
    }

    /* renamed from: a */
    private boolean m35174a(ResponseBody responseBody) {
        if (responseBody == null) {
            Logger.m32141i(f27973b, "cacheResponseBody is null");
            return false;
        }
        InputStream inputStream = responseBody.getInputStream();
        if (inputStream != null) {
            return ((C6095t1) inputStream).isDecryptable();
        }
        Logger.m32141i(f27973b, "inputStream is null");
        return false;
    }

    /* renamed from: a */
    private boolean m35175a(String str) throws ClassNotFoundException {
        String str2;
        try {
            ClassLoader classLoader = C6069r1.class.getClassLoader();
            if (classLoader == null) {
                throw new ClassNotFoundException("not found classloader");
            }
            classLoader.loadClass(str);
            return true;
        } catch (ClassNotFoundException unused) {
            str2 = str + " ClassNotFoundException";
            Logger.m32145w(f27973b, str2);
            return false;
        } catch (Exception e10) {
            str2 = str + " exception: " + e10.getClass().getSimpleName();
            Logger.m32145w(f27973b, str2);
            return false;
        }
    }
}
