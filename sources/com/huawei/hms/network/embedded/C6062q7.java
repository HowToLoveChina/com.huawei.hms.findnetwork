package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.AbstractC5932g7;
import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.C6178z6;
import com.huawei.hms.network.embedded.InterfaceC6100t6;
import com.huawei.hms.network.embedded.InterfaceC6179z7;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: com.huawei.hms.network.embedded.q7 */
/* loaded from: classes8.dex */
public class C6062q7 implements Cloneable, InterfaceC6100t6.a, InterfaceC6179z7.a {

    /* renamed from: F */
    public static final List<EnumC6075r7> f27854F = C5920f8.m34243a(EnumC6075r7.HTTP_2, EnumC6075r7.HTTP_1_1);

    /* renamed from: G */
    public static final List<C5850a7> f27855G = C5920f8.m34243a(C5850a7.f26359h, C5850a7.f26361j);

    /* renamed from: H */
    public static final int f27856H = 100;

    /* renamed from: I */
    public static final int f27857I = 2000;

    /* renamed from: J */
    public static final int f27858J = 200;

    /* renamed from: A */
    public final int f27859A;

    /* renamed from: B */
    public final int f27860B;

    /* renamed from: C */
    public final int f27861C;

    /* renamed from: D */
    public final int f27862D;

    /* renamed from: E */
    public final d f27863E;

    /* renamed from: a */
    public final C5906e7 f27864a;

    /* renamed from: b */
    public final Proxy f27865b;

    /* renamed from: c */
    public final List<EnumC6075r7> f27866c;

    /* renamed from: d */
    public final List<C5850a7> f27867d;

    /* renamed from: e */
    public final List<InterfaceC6023n7> f27868e;

    /* renamed from: f */
    public final List<InterfaceC6023n7> f27869f;

    /* renamed from: g */
    public final AbstractC5932g7.b f27870g;

    /* renamed from: h */
    public final ProxySelector f27871h;

    /* renamed from: i */
    public final InterfaceC5878c7 f27872i;

    /* renamed from: j */
    public final C6074r6 f27873j;

    /* renamed from: k */
    public final InterfaceC6024n8 f27874k;

    /* renamed from: l */
    public final SocketFactory f27875l;

    /* renamed from: m */
    public final SSLSocketFactory f27876m;

    /* renamed from: n */
    public final AbstractC6065qa f27877n;

    /* renamed from: o */
    public final HostnameVerifier f27878o;

    /* renamed from: p */
    public final C6126v6 f27879p;

    /* renamed from: q */
    public final InterfaceC6061q6 f27880q;

    /* renamed from: r */
    public final InterfaceC6061q6 f27881r;

    /* renamed from: s */
    public final C6178z6 f27882s;

    /* renamed from: t */
    public final InterfaceC5919f7 f27883t;

    /* renamed from: u */
    public final boolean f27884u;

    /* renamed from: v */
    public final boolean f27885v;

    /* renamed from: w */
    public final boolean f27886w;

    /* renamed from: x */
    public final int f27887x;

    /* renamed from: y */
    public final int f27888y;

    /* renamed from: z */
    public final int f27889z;

    /* renamed from: com.huawei.hms.network.embedded.q7$a */
    public class a extends AbstractC5879c8 {
        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public int mo34042a(C6127v7.a aVar) {
            return aVar.f28671c;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public InterfaceC6100t6 mo34043a(C6062q7 c6062q7, C6101t7 c6101t7) {
            return C6088s7.m35279a(c6062q7, c6101t7, true);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public C6128v8 mo34044a(C6127v7 c6127v7) {
            return c6127v7.f28667m;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public C6180z8 mo34045a(C6178z6 c6178z6) {
            return c6178z6.delegate;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public void mo34046a(C5850a7 c5850a7, SSLSocket sSLSocket, boolean z10) {
            c5850a7.m33814a(sSLSocket, z10);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public void mo34047a(C5971j7.a aVar, String str) {
            aVar.m34536b(str);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public void mo34048a(C5971j7.a aVar, String str, String str2) {
            aVar.m34537b(str, str2);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public void mo34049a(C6127v7.a aVar, C6128v8 c6128v8) {
            aVar.m35606a(c6128v8);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5879c8
        /* renamed from: a */
        public boolean mo34050a(C6048p6 c6048p6, C6048p6 c6048p62) {
            return c6048p6.m34979a(c6048p62);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.q7$b */
    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27890a;

        static {
            int[] iArr = new int[EnumC6075r7.values().length];
            f27890a = iArr;
            try {
                iArr[EnumC6075r7.HTTP_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27890a[EnumC6075r7.HTTP_1_0.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27890a[EnumC6075r7.HTTP_1_1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27890a[EnumC6075r7.SPDY_3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.q7$c */
    public static final class c {

        /* renamed from: A */
        public int f27891A;

        /* renamed from: B */
        public int f27892B;

        /* renamed from: C */
        public int f27893C;

        /* renamed from: D */
        public int f27894D;

        /* renamed from: a */
        public C5906e7 f27895a;

        /* renamed from: b */
        public Proxy f27896b;

        /* renamed from: c */
        public List<EnumC6075r7> f27897c;

        /* renamed from: d */
        public List<C5850a7> f27898d;

        /* renamed from: e */
        public final List<InterfaceC6023n7> f27899e;

        /* renamed from: f */
        public final List<InterfaceC6023n7> f27900f;

        /* renamed from: g */
        public AbstractC5932g7.b f27901g;

        /* renamed from: h */
        public ProxySelector f27902h;

        /* renamed from: i */
        public InterfaceC5878c7 f27903i;

        /* renamed from: j */
        public C6074r6 f27904j;

        /* renamed from: k */
        public InterfaceC6024n8 f27905k;

        /* renamed from: l */
        public SocketFactory f27906l;

        /* renamed from: m */
        public SSLSocketFactory f27907m;

        /* renamed from: n */
        public AbstractC6065qa f27908n;

        /* renamed from: o */
        public HostnameVerifier f27909o;

        /* renamed from: p */
        public C6126v6 f27910p;

        /* renamed from: q */
        public InterfaceC6061q6 f27911q;

        /* renamed from: r */
        public InterfaceC6061q6 f27912r;

        /* renamed from: s */
        public C6178z6 f27913s;

        /* renamed from: t */
        public InterfaceC5919f7 f27914t;

        /* renamed from: u */
        public boolean f27915u;

        /* renamed from: v */
        public boolean f27916v;

        /* renamed from: w */
        public boolean f27917w;

        /* renamed from: x */
        public int f27918x;

        /* renamed from: y */
        public int f27919y;

        /* renamed from: z */
        public int f27920z;

        public c() {
            this.f27899e = new ArrayList();
            this.f27900f = new ArrayList();
            this.f27895a = new C5906e7();
            this.f27897c = C6062q7.f27854F;
            this.f27898d = C6062q7.f27855G;
            this.f27901g = AbstractC5932g7.m34312a(AbstractC5932g7.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f27902h = proxySelector;
            if (proxySelector == null) {
                this.f27902h = new C6026na();
            }
            this.f27903i = InterfaceC5878c7.f26566a;
            this.f27906l = SocketFactory.getDefault();
            this.f27909o = C6091sa.f28246a;
            this.f27910p = C6126v6.f28646c;
            InterfaceC6061q6 interfaceC6061q6 = InterfaceC6061q6.f27853a;
            this.f27911q = interfaceC6061q6;
            this.f27912r = interfaceC6061q6;
            this.f27913s = new C6178z6();
            this.f27914t = InterfaceC5919f7.f26768a;
            this.f27915u = true;
            this.f27916v = true;
            this.f27917w = true;
            this.f27918x = 0;
            this.f27919y = 10000;
            this.f27920z = 10000;
            this.f27891A = 10000;
            this.f27892B = 0;
            this.f27894D = 0;
            this.f27893C = 200;
        }

        /* renamed from: a */
        public C5906e7 m35103a(EnumC6075r7 enumC6075r7) {
            int i10 = b.f27890a[enumC6075r7.ordinal()];
            if (i10 == 1) {
                return new C5984k7();
            }
            if (i10 == 2 || i10 == 3 || i10 == 4) {
                return new C5906e7();
            }
            throw new IllegalArgumentException("there is no dispatcher fit for the protocol " + enumC6075r7.toString());
        }

        /* renamed from: b */
        public c m35126b(long j10, TimeUnit timeUnit) {
            this.f27919y = C5920f8.m34231a("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: c */
        public c m35133c(long j10, TimeUnit timeUnit) {
            int iM34231a = C5920f8.m34231a("connectionAttemptDelay", j10, timeUnit);
            this.f27893C = iM34231a;
            if (iM34231a < 100 || iM34231a > 2000) {
                String str = "Connection Attempt Delay " + this.f27893C + " ms is out of range (100ms ~ 2000ms).";
                this.f27893C = 200;
                throw new IllegalArgumentException(str);
            }
            if (iM34231a < this.f27919y) {
                return this;
            }
            String str2 = "Connection Attempt Delay " + this.f27893C + " ms is out of range (100ms ~ 2000ms).";
            this.f27893C = 200;
            throw new IllegalArgumentException(str2);
        }

        /* renamed from: d */
        public c m35137d(long j10, TimeUnit timeUnit) {
            this.f27892B = C5920f8.m34231a("interval", j10, timeUnit);
            return this;
        }

        /* renamed from: e */
        public c m35139e(long j10, TimeUnit timeUnit) {
            this.f27920z = C5920f8.m34231a("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: f */
        public c m35141f(long j10, TimeUnit timeUnit) {
            this.f27891A = C5920f8.m34231a("timeout", j10, timeUnit);
            return this;
        }

        public c(C6062q7 c6062q7) {
            ArrayList arrayList = new ArrayList();
            this.f27899e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f27900f = arrayList2;
            this.f27895a = c6062q7.f27864a;
            this.f27896b = c6062q7.f27865b;
            this.f27897c = c6062q7.f27866c;
            this.f27898d = c6062q7.f27867d;
            arrayList.addAll(c6062q7.f27868e);
            arrayList2.addAll(c6062q7.f27869f);
            this.f27901g = c6062q7.f27870g;
            this.f27902h = c6062q7.f27871h;
            this.f27903i = c6062q7.f27872i;
            this.f27905k = c6062q7.f27874k;
            this.f27904j = c6062q7.f27873j;
            this.f27906l = c6062q7.f27875l;
            this.f27907m = c6062q7.f27876m;
            this.f27908n = c6062q7.f27877n;
            this.f27909o = c6062q7.f27878o;
            this.f27910p = c6062q7.f27879p;
            this.f27911q = c6062q7.f27880q;
            this.f27912r = c6062q7.f27881r;
            this.f27913s = c6062q7.f27882s;
            this.f27914t = c6062q7.f27883t;
            this.f27915u = c6062q7.f27884u;
            this.f27916v = c6062q7.f27885v;
            this.f27917w = c6062q7.f27886w;
            this.f27918x = c6062q7.f27887x;
            this.f27919y = c6062q7.f27888y;
            this.f27920z = c6062q7.f27889z;
            this.f27891A = c6062q7.f27859A;
            this.f27892B = c6062q7.f27860B;
            this.f27893C = c6062q7.f27861C;
            this.f27894D = c6062q7.f27862D;
        }

        /* renamed from: a */
        public c m35104a(int i10) {
            if (i10 < 0 || i10 > 255) {
                C6013ma.m34863f().mo34331a(5, "The trafficClass must be in the range 0 <= tc <= 255", (Throwable) null);
                return this;
            }
            this.f27894D = i10;
            return this;
        }

        /* renamed from: b */
        public c m35127b(InterfaceC6023n7 interfaceC6023n7) {
            if (interfaceC6023n7 == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f27900f.add(interfaceC6023n7);
            return this;
        }

        @IgnoreJRERequirement
        /* renamed from: c */
        public c m35134c(Duration duration) {
            this.f27892B = C5920f8.m34231a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        /* renamed from: d */
        public c m35138d(Duration duration) {
            this.f27920z = C5920f8.m34231a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        /* renamed from: e */
        public c m35140e(Duration duration) {
            this.f27891A = C5920f8.m34231a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        /* renamed from: a */
        public c m35105a(long j10, TimeUnit timeUnit) {
            this.f27918x = C5920f8.m34231a("timeout", j10, timeUnit);
            return this;
        }

        /* renamed from: b */
        public c m35128b(InterfaceC6061q6 interfaceC6061q6) {
            if (interfaceC6061q6 == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f27911q = interfaceC6061q6;
            return this;
        }

        /* renamed from: c */
        public c m35135c(boolean z10) {
            this.f27917w = z10;
            return this;
        }

        /* renamed from: a */
        public c m35106a(InterfaceC5878c7 interfaceC5878c7) {
            if (interfaceC5878c7 == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.f27903i = interfaceC5878c7;
            return this;
        }

        @IgnoreJRERequirement
        /* renamed from: b */
        public c m35129b(Duration duration) {
            int i10 = this.f27919y;
            int iM34231a = C5920f8.m34231a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            this.f27919y = iM34231a;
            if (this.f27893C < iM34231a) {
                return this;
            }
            String str = "Connection Attempt Delay (" + this.f27893C + " ms) is greater than or equal to Connect Timeout (" + this.f27919y + " ms)";
            this.f27919y = i10;
            throw new IllegalArgumentException(str);
        }

        /* renamed from: c */
        public List<InterfaceC6023n7> m35136c() {
            return this.f27900f;
        }

        /* renamed from: a */
        public c m35107a(C5906e7 c5906e7) {
            if (c5906e7 == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f27895a = c5906e7;
            return this;
        }

        /* renamed from: b */
        public c m35130b(List<EnumC6075r7> list) {
            ArrayList arrayList = new ArrayList(list);
            EnumC6075r7 enumC6075r7 = EnumC6075r7.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(enumC6075r7) && !arrayList.contains(EnumC6075r7.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(enumC6075r7) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(EnumC6075r7.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(EnumC6075r7.SPDY_3);
            this.f27897c = Collections.unmodifiableList(arrayList);
            return this;
        }

        /* renamed from: a */
        public c m35108a(InterfaceC5919f7 interfaceC5919f7) {
            if (interfaceC5919f7 == null) {
                throw new NullPointerException("dns == null");
            }
            this.f27914t = interfaceC5919f7;
            return this;
        }

        /* renamed from: b */
        public c m35131b(boolean z10) {
            this.f27915u = z10;
            return this;
        }

        /* renamed from: a */
        public c m35109a(AbstractC5932g7.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("eventListenerFactory == null");
            }
            this.f27901g = bVar;
            return this;
        }

        /* renamed from: b */
        public List<InterfaceC6023n7> m35132b() {
            return this.f27899e;
        }

        /* renamed from: a */
        public c m35110a(AbstractC5932g7 abstractC5932g7) {
            if (abstractC5932g7 == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.f27901g = AbstractC5932g7.m34312a(abstractC5932g7);
            return this;
        }

        /* renamed from: a */
        public c m35111a(InterfaceC6023n7 interfaceC6023n7) {
            if (interfaceC6023n7 == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f27899e.add(interfaceC6023n7);
            return this;
        }

        /* renamed from: a */
        public c m35112a(InterfaceC6061q6 interfaceC6061q6) {
            if (interfaceC6061q6 == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.f27912r = interfaceC6061q6;
            return this;
        }

        /* renamed from: a */
        public c m35113a(C6074r6 c6074r6) {
            this.f27904j = c6074r6;
            this.f27905k = null;
            return this;
        }

        /* renamed from: a */
        public c m35114a(C6126v6 c6126v6) {
            if (c6126v6 == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.f27910p = c6126v6;
            return this;
        }

        /* renamed from: a */
        public c m35115a(C6178z6 c6178z6) {
            if (c6178z6 == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f27913s = c6178z6;
            return this;
        }

        /* renamed from: a */
        public c m35116a(Proxy proxy) {
            this.f27896b = proxy;
            return this;
        }

        /* renamed from: a */
        public c m35117a(ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new NullPointerException("proxySelector == null");
            }
            this.f27902h = proxySelector;
            return this;
        }

        @IgnoreJRERequirement
        /* renamed from: a */
        public c m35118a(Duration duration) {
            this.f27918x = C5920f8.m34231a("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        /* renamed from: a */
        public c m35119a(List<C5850a7> list) {
            this.f27898d = C5920f8.m34242a(list);
            return this;
        }

        /* renamed from: a */
        public c m35120a(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            if (socketFactory instanceof SSLSocketFactory) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
            }
            this.f27906l = socketFactory;
            return this;
        }

        /* renamed from: a */
        public c m35121a(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.f27909o = hostnameVerifier;
            return this;
        }

        /* renamed from: a */
        public c m35122a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.f27907m = sSLSocketFactory;
            this.f27908n = C6013ma.m34863f().m34866a(sSLSocketFactory);
            return this;
        }

        /* renamed from: a */
        public c m35123a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.f27907m = sSLSocketFactory;
            this.f27908n = AbstractC6065qa.m35163a(x509TrustManager);
            return this;
        }

        /* renamed from: a */
        public c m35124a(boolean z10) {
            this.f27916v = z10;
            return this;
        }

        /* renamed from: a */
        public C6062q7 m35125a() {
            return new C6062q7(this);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.q7$d */
    public class d implements C6178z6.a {
        public d() {
        }

        @Override // com.huawei.hms.network.embedded.C6178z6.a
        /* renamed from: a */
        public void mo35142a(String str, int i10, String str2) {
            C6062q7.this.f27864a.mo34129b(str, i10, str2);
        }

        public /* synthetic */ d(C6062q7 c6062q7, a aVar) {
            this();
        }
    }

    static {
        AbstractC5879c8.f26567a = new a();
    }

    public C6062q7() {
        this(new c());
    }

    /* renamed from: E */
    public static String m35066E() {
        return C5933g8.m34314a();
    }

    /* renamed from: A */
    public boolean m35068A() {
        return this.f27886w;
    }

    /* renamed from: B */
    public SocketFactory m35069B() {
        return this.f27875l;
    }

    /* renamed from: C */
    public SSLSocketFactory m35070C() {
        return this.f27876m;
    }

    /* renamed from: D */
    public int m35071D() {
        return this.f27859A;
    }

    /* renamed from: a */
    public InterfaceC6061q6 m35072a() {
        return this.f27881r;
    }

    /* renamed from: b */
    public int m35076b(String str, int i10, String str2) {
        return this.f27882s.m35910a(str, i10, str2);
    }

    /* renamed from: c */
    public int m35078c() {
        return this.f27887x;
    }

    /* renamed from: d */
    public C6126v6 m35080d() {
        return this.f27879p;
    }

    /* renamed from: e */
    public int m35081e() {
        return this.f27888y;
    }

    /* renamed from: f */
    public int m35082f() {
        return this.f27861C;
    }

    /* renamed from: g */
    public C6178z6 m35083g() {
        return this.f27882s;
    }

    /* renamed from: h */
    public List<C5850a7> m35084h() {
        return this.f27867d;
    }

    /* renamed from: i */
    public InterfaceC5878c7 m35085i() {
        return this.f27872i;
    }

    /* renamed from: j */
    public C5906e7 m35086j() {
        return this.f27864a;
    }

    /* renamed from: k */
    public InterfaceC5919f7 m35087k() {
        return this.f27883t;
    }

    /* renamed from: l */
    public AbstractC5932g7.b m35088l() {
        return this.f27870g;
    }

    /* renamed from: m */
    public boolean m35089m() {
        return this.f27885v;
    }

    /* renamed from: n */
    public boolean m35090n() {
        return this.f27884u;
    }

    /* renamed from: o */
    public int m35091o() {
        return this.f27862D;
    }

    /* renamed from: p */
    public HostnameVerifier m35092p() {
        return this.f27878o;
    }

    /* renamed from: q */
    public List<InterfaceC6023n7> m35093q() {
        return this.f27868e;
    }

    /* renamed from: r */
    public InterfaceC6024n8 m35094r() {
        C6074r6 c6074r6 = this.f27873j;
        return c6074r6 != null ? c6074r6.f28063a : this.f27874k;
    }

    /* renamed from: s */
    public List<InterfaceC6023n7> m35095s() {
        return this.f27869f;
    }

    /* renamed from: t */
    public c m35096t() {
        return new c(this);
    }

    /* renamed from: u */
    public int m35097u() {
        return this.f27860B;
    }

    /* renamed from: v */
    public List<EnumC6075r7> m35098v() {
        return this.f27866c;
    }

    /* renamed from: w */
    public Proxy m35099w() {
        return this.f27865b;
    }

    /* renamed from: x */
    public InterfaceC6061q6 m35100x() {
        return this.f27880q;
    }

    /* renamed from: y */
    public ProxySelector m35101y() {
        return this.f27871h;
    }

    /* renamed from: z */
    public int m35102z() {
        return this.f27889z;
    }

    public C6062q7(c cVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z10;
        AbstractC6065qa abstractC6065qaM35163a;
        this.f27863E = new d(this, null);
        this.f27864a = cVar.f27895a;
        this.f27865b = cVar.f27896b;
        this.f27866c = cVar.f27897c;
        List<C5850a7> list = cVar.f27898d;
        this.f27867d = list;
        this.f27868e = C5920f8.m34242a(cVar.f27899e);
        this.f27869f = C5920f8.m34242a(cVar.f27900f);
        this.f27870g = cVar.f27901g;
        this.f27871h = cVar.f27902h;
        this.f27872i = cVar.f27903i;
        this.f27873j = cVar.f27904j;
        this.f27874k = cVar.f27905k;
        this.f27875l = cVar.f27906l;
        Iterator<C5850a7> it = list.iterator();
        loop0: while (true) {
            z10 = false;
            while (it.hasNext()) {
                z10 = (z10 || it.next().m33816b()) ? true : z10;
            }
        }
        SSLSocketFactory sSLSocketFactory = cVar.f27907m;
        if (sSLSocketFactory == null && z10) {
            X509TrustManager x509TrustManagerM34246a = C5920f8.m34246a();
            this.f27876m = m35067a(x509TrustManagerM34246a);
            abstractC6065qaM35163a = AbstractC6065qa.m35163a(x509TrustManagerM34246a);
        } else {
            this.f27876m = sSLSocketFactory;
            abstractC6065qaM35163a = cVar.f27908n;
        }
        this.f27877n = abstractC6065qaM35163a;
        if (this.f27876m != null) {
            C6013ma.m34863f().mo34423b(this.f27876m);
        }
        this.f27878o = cVar.f27909o;
        this.f27879p = cVar.f27910p.m35564a(this.f27877n);
        this.f27880q = cVar.f27911q;
        this.f27881r = cVar.f27912r;
        C6178z6 c6178z6 = cVar.f27913s;
        this.f27882s = c6178z6;
        this.f27883t = cVar.f27914t;
        this.f27884u = cVar.f27915u;
        this.f27885v = cVar.f27916v;
        this.f27886w = cVar.f27917w;
        this.f27887x = cVar.f27918x;
        this.f27888y = cVar.f27919y;
        this.f27889z = cVar.f27920z;
        this.f27859A = cVar.f27891A;
        this.f27860B = cVar.f27892B;
        this.f27862D = cVar.f27894D;
        if (this.f27868e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f27868e);
        }
        if (!this.f27869f.contains(null)) {
            this.f27861C = cVar.f27893C;
            c6178z6.m35911a(this.f27863E);
        } else {
            throw new IllegalStateException("Null network interceptor: " + this.f27869f);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6100t6.a
    /* renamed from: a */
    public InterfaceC6100t6 mo35073a(C6101t7 c6101t7) {
        return C6088s7.m35279a(this, c6101t7, false);
    }

    /* renamed from: b */
    public C6074r6 m35077b() {
        return this.f27873j;
    }

    /* renamed from: c */
    public boolean m35079c(String str, int i10, String str2) {
        return this.f27882s.m35914b(str, i10, str2);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6179z7.a
    /* renamed from: a */
    public InterfaceC6179z7 mo35074a(C6101t7 c6101t7, AbstractC5851a8 abstractC5851a8) {
        C6117ua c6117ua = new C6117ua(c6101t7, abstractC5851a8, new Random(), this.f27860B);
        c6117ua.m35525a(this);
        return c6117ua;
    }

    /* renamed from: a */
    public static SSLSocketFactory m35067a(X509TrustManager x509TrustManager) throws KeyManagementException {
        try {
            SSLContext sSLContextMo34335b = C6013ma.m34863f().mo34335b();
            sSLContextMo34335b.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContextMo34335b.getSocketFactory();
        } catch (GeneralSecurityException e10) {
            throw new AssertionError("No System TLS", e10);
        }
    }

    /* renamed from: a */
    public void m35075a(String str, int i10, String str2) {
        this.f27864a.mo34126a(str, i10, str2);
    }
}
