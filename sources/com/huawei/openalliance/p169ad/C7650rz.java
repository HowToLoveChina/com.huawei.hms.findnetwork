package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.net.http.C7502e;
import com.huawei.openalliance.p169ad.net.http.Response;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7803cw;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.openalliance.ad.rz */
/* loaded from: classes8.dex */
public class C7650rz {

    /* renamed from: c */
    private static final LinkedHashMap<String, String> f35620c = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: a */
    private InterfaceC7649ry f35621a;

    /* renamed from: b */
    private String f35622b;

    /* renamed from: d */
    private C7653sb f35623d;

    /* renamed from: e */
    private InterfaceC7003ct f35624e;

    /* renamed from: f */
    private Context f35625f;

    /* renamed from: g */
    private C7022dk f35626g;

    /* renamed from: h */
    private String f35627h;

    /* renamed from: com.huawei.openalliance.ad.rz$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C7653sb f35628a;

        /* renamed from: b */
        final /* synthetic */ String f35629b;

        /* renamed from: c */
        final /* synthetic */ long f35630c;

        /* renamed from: d */
        final /* synthetic */ long f35631d;

        /* renamed from: e */
        final /* synthetic */ int f35632e;

        /* renamed from: f */
        final /* synthetic */ String f35633f;

        public AnonymousClass1(C7653sb c7653sb, String str, long j10, long j11, int i10, String str2) {
            c7653sb = c7653sb;
            str = str;
            j = j10;
            j = j11;
            i = i10;
            str = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7650rz.this.f35624e.mo39180a(c7653sb, str, j, j, i, str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.rz$a */
    public class a implements InterfaceC7377kx<Boolean> {

        /* renamed from: b */
        private final String f35636b;

        /* renamed from: c */
        private final long f35637c;

        /* renamed from: d */
        private long f35638d;

        public a(String str, long j10) {
            this.f35636b = str;
            this.f35637c = j10;
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7382lb
        /* renamed from: a */
        public long mo45459a() {
            return this.f35638d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v16 */
        /* JADX WARN: Type inference failed for: r12v4, types: [java.io.BufferedOutputStream] */
        /* JADX WARN: Type inference failed for: r15v10 */
        /* JADX WARN: Type inference failed for: r15v12, types: [java.io.BufferedInputStream, java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r15v7, types: [com.huawei.openalliance.ad.sb] */
        /* JADX WARN: Type inference failed for: r15v8 */
        /* JADX WARN: Type inference failed for: r15v9 */
        @Override // com.huawei.openalliance.p169ad.InterfaceC7382lb
        /* renamed from: b */
        public Boolean mo45460a(int i10, InputStream inputStream, long j10, InterfaceC7368ko interfaceC7368ko) throws Throwable {
            ?? r12;
            IOException e10;
            BufferedOutputStream bufferedOutputStream;
            Boolean bool;
            BufferedInputStream bufferedInputStream;
            C7650rz c7650rz;
            String str;
            if (200 == i10 || 206 == i10) {
                C7650rz.this.m47150b(j10);
                if (C7650rz.this.f35623d.m47174a()) {
                    C7650rz.this.m47137a(j10);
                }
                ?? bufferedInputStream2 = C7650rz.this.f35623d;
                long jM47193h = bufferedInputStream2.m47193h();
                if (j10 > jM47193h) {
                    AbstractC7185ho.m43824c("SourceFetcher", "fileSize is not under limit %s", String.valueOf(jM47193h));
                    c7650rz = C7650rz.this;
                    str = "fileSize_exceed_limit";
                } else {
                    File file = new File(m47159b());
                    BufferedInputStream bufferedInputStream3 = null;
                    try {
                        try {
                            bufferedInputStream2 = new BufferedInputStream(inputStream, 8192);
                        } catch (IOException e11) {
                            bufferedInputStream2 = 0;
                            e10 = e11;
                            bufferedOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            r12 = 0;
                            C7650rz.this.m47142a(bufferedInputStream3, (BufferedOutputStream) r12, file);
                            throw th;
                        }
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 8192);
                        } catch (IOException e12) {
                            e10 = e12;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            bufferedInputStream3 = bufferedInputStream2;
                            r12 = inputStream;
                            C7650rz.this.m47142a(bufferedInputStream3, (BufferedOutputStream) r12, file);
                            throw th;
                        }
                        try {
                            byte[] bArr = new byte[8192];
                            int i11 = 0;
                            while (true) {
                                int i12 = bufferedInputStream2.read(bArr);
                                if (i12 > 0) {
                                    i11 += i12;
                                    if (i11 > jM47193h) {
                                        C7650rz.this.m47146a("3", this.f35637c);
                                        AbstractC7185ho.m43823c("SourceFetcher", "downloadUrlToStream error, downloaded size " + i11 + ", over the limit");
                                        AbstractC7731ae.m47449a(file);
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, i12);
                                } else {
                                    this.f35638d = System.currentTimeMillis();
                                    bufferedOutputStream.flush();
                                    C7650rz.this.f35623d.m47177b(i11);
                                    C7650rz.this.f35623d.m47179b(Long.valueOf(System.currentTimeMillis()));
                                    String strM47189e = C7650rz.this.f35623d.m47189e();
                                    if (C7650rz.this.f35623d.m47195j() && !AbstractC7731ae.m47452a(strM47189e, file)) {
                                        C7650rz.this.m47146a("3", this.f35637c);
                                        AbstractC7185ho.m43823c("SourceFetcher", "downloadUrlToStream error, downloaded file hashcode is not right");
                                        AbstractC7731ae.m47449a(file);
                                    } else if (AbstractC7731ae.m47447a(C7650rz.this.f35625f, file, this.f35636b, C7652sa.m47163a(C7650rz.this.f35623d), C7650rz.this.f35627h)) {
                                        bool = Boolean.TRUE;
                                        bufferedInputStream = bufferedInputStream2;
                                    } else {
                                        C7650rz.this.m47145a("2", i10, "rename_file_fail", this.f35637c);
                                    }
                                }
                            }
                            bool = Boolean.FALSE;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (IOException e13) {
                            e10 = e13;
                            AbstractC7185ho.m43823c("SourceFetcher", "download file encounters IOException, ex:" + e10.getClass().getSimpleName());
                            C7650rz.this.m47145a("2", i10, e10.getClass().getSimpleName(), this.f35637c);
                            bool = Boolean.FALSE;
                            bufferedInputStream = bufferedInputStream2;
                            C7650rz.this.m47142a(bufferedInputStream, bufferedOutputStream, file);
                            return bool;
                        }
                        C7650rz.this.m47142a(bufferedInputStream, bufferedOutputStream, file);
                        return bool;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } else {
                AbstractC7185ho.m43823c("SourceFetcher", "downloadfailed, http.response.code:" + i10);
                c7650rz = C7650rz.this;
                str = "error_http_code";
            }
            c7650rz.m47145a("2", i10, str, this.f35637c);
            return Boolean.FALSE;
        }

        /* renamed from: b */
        private String m47159b() {
            StringBuilder sb2;
            String strM41955k;
            if (C7022dk.m41954i(this.f35636b)) {
                sb2 = new StringBuilder();
                sb2.append(C7650rz.this.f35622b);
                strM41955k = C7022dk.m41955k(this.f35636b);
            } else {
                sb2 = new StringBuilder();
                strM41955k = this.f35636b;
            }
            sb2.append(strM41955k);
            sb2.append(".bak");
            return sb2.toString();
        }
    }

    public C7650rz(Context context, C7653sb c7653sb) {
        this.f35627h = Constants.NORMAL_CACHE;
        if (!TextUtils.isEmpty(c7653sb.m47194i())) {
            c7653sb.m47187d(C7752az.m47696b(context, c7653sb.m47194i()));
        }
        String strM48136f = c7653sb.m47198m() ? AbstractC7803cw.m48136f(context) : AbstractC7803cw.m48133c(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strM48136f);
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.PPS_ROOT_PATH);
        sb2.append(str);
        this.f35622b = sb2.toString();
        if (!AbstractC7806cz.m48165b(c7653sb.m47186d())) {
            this.f35622b += c7653sb.m47186d() + str;
        }
        File file = new File(this.f35622b);
        if (!file.exists() && !AbstractC7731ae.m47468g(file)) {
            AbstractC7185ho.m43823c("SourceFetcher", "SourceFetcher mkdirs failed");
        }
        this.f35621a = (InterfaceC7649ry) new C7502e.a(context).m46062a(true).m46066b(false).m46060a(c7653sb.m47191f()).m46064b(c7653sb.m47192g()).m46063a().m46059a(InterfaceC7649ry.class);
        this.f35623d = c7653sb;
        if (c7653sb.m47203r() != null) {
            this.f35626g = C7019dh.m41937a(context, c7653sb.m47203r());
            this.f35627h = c7653sb.m47203r();
        } else {
            c7653sb.m47190e(Constants.NORMAL_CACHE);
            this.f35626g = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        }
        this.f35624e = new C6927h(context);
        this.f35625f = context.getApplicationContext();
    }

    /* renamed from: b */
    private synchronized String m47149b(String str) {
        return f35620c.get(str);
    }

    /* renamed from: c */
    private synchronized void m47153c(String str) {
        AbstractC7185ho.m43818a("SourceFetcher", "addLoadingImages, key:%s", AbstractC7819dl.m48375a(str));
        f35620c.put(str, str);
    }

    /* renamed from: d */
    private synchronized void m47155d(String str) {
        AbstractC7185ho.m43818a("SourceFetcher", "removeLoadingImages, key:%s", AbstractC7819dl.m48375a(str));
        f35620c.remove(str);
    }

    /* renamed from: e */
    private boolean m47157e(String str) {
        if (this.f35623d == null) {
            AbstractC7185ho.m43823c("SourceFetcher", "checkSourceDataAndFileState, source error");
            return false;
        }
        if (m47149b(str) == null) {
            return true;
        }
        AbstractC7185ho.m43820b("SourceFetcher", "file is in progress");
        m47143a((Integer) 3, "file is in progress");
        return false;
    }

    /* renamed from: a */
    public C7654sc m47158a() {
        if (!AbstractC7806cz.m48165b(this.f35622b)) {
            return m47134a(this.f35623d);
        }
        m47143a((Integer) 1, "root is blank");
        return null;
    }

    /* renamed from: a */
    private C7654sc m47134a(C7653sb c7653sb) {
        String strM47469h;
        StringBuilder sb2;
        String str;
        if (c7653sb == null) {
            AbstractC7185ho.m43823c("SourceFetcher", "downloadFile - data is null");
            return null;
        }
        String strM47194i = c7653sb.m47194i();
        if (TextUtils.isEmpty(strM47194i)) {
            AbstractC7185ho.m43820b("SourceFetcher", "downloadFile - file url is null");
            m47143a((Integer) 1, "downloadFile - file url is null");
            return null;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("SourceFetcher", "download file: %s cacheType: %s", AbstractC7819dl.m48375a(strM47194i), this.f35627h);
        }
        if (!c7653sb.m47198m()) {
            strM47469h = AbstractC7731ae.m47469h(new File(this.f35622b + C7652sa.m47164a(strM47194i)));
        } else if (this.f35623d.m47204s()) {
            strM47469h = C7022dk.m41953d(strM47194i) + AbstractC7731ae.m47465e(strM47194i);
        } else {
            strM47469h = C7022dk.m41953d(strM47194i);
        }
        if (!this.f35623d.m47205t() && AbstractC7731ae.m47462c(this.f35625f, strM47469h, Constants.NORMAL_CACHE)) {
            return m47135a(strM47469h, Constants.NORMAL_CACHE);
        }
        if (!this.f35623d.m47205t() && AbstractC7731ae.m47462c(this.f35625f, strM47469h, Constants.TPLATE_CACHE)) {
            return m47135a(strM47469h, Constants.TPLATE_CACHE);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (m47147a(strM47194i, strM47469h, jCurrentTimeMillis)) {
                AbstractC7185ho.m43820b("SourceFetcher", "download file from network");
                m47146a("5", jCurrentTimeMillis);
                return m47136a(strM47469h, true);
            }
        } catch (RuntimeException e10) {
            e = e10;
            AbstractC7731ae.m47441a(this.f35625f, strM47469h, this.f35627h);
            sb2 = new StringBuilder();
            str = "downloadFile RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            String string = sb2.toString();
            AbstractC7185ho.m43823c("SourceFetcher", string);
            this.m47143a((Integer) 2, string);
            return null;
        } catch (Exception e11) {
            e = e11;
            AbstractC7731ae.m47441a(this.f35625f, strM47469h, this.f35627h);
            sb2 = new StringBuilder();
            str = "downloadFile Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            String string2 = sb2.toString();
            AbstractC7185ho.m43823c("SourceFetcher", string2);
            this.m47143a((Integer) 2, string2);
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public void m47150b(long j10) {
        File file = new File(this.f35622b);
        if (!file.isDirectory() || file.getFreeSpace() > j10) {
            return;
        }
        m47144a("73");
    }

    /* renamed from: a */
    private C7654sc m47135a(String str, String str2) throws Throwable {
        AbstractC7185ho.m43821b("SourceFetcher", "download file from %s local", str2);
        if (C7022dk.m41954i(str)) {
            C7022dk c7022dkM41937a = C7019dh.m41937a(this.f35625f, str2);
            this.f35626g = c7022dkM41937a;
            this.f35627h = str2;
            C7652sa.m47165a(this.f35625f, str, c7022dkM41937a, this.f35623d, str2);
        } else {
            AbstractC7731ae.m47461c(new File(str));
        }
        return m47136a(str, false);
    }

    /* renamed from: a */
    private C7654sc m47136a(String str, boolean z10) {
        C7654sc c7654sc = new C7654sc();
        String strM41968c = C7022dk.m41954i(str) ? this.f35626g.m41968c(str) : str;
        if (AbstractC7731ae.m47462c(this.f35625f, strM41968c, this.f35627h)) {
            c7654sc.m47208a(str);
            c7654sc.m47211b(strM41968c);
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("SourceFetcher", "filePath: %s, localFilePath: %s", AbstractC7819dl.m48375a(str), AbstractC7819dl.m48375a(strM41968c));
        }
        c7654sc.m47209a(z10);
        return c7654sc;
    }

    /* renamed from: a */
    public void m47137a(long j10) {
        File file = new File(this.f35622b);
        if (!file.isDirectory() || file.getFreeSpace() > j10) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("SourceFetcher", "free disk space is: %d", Long.valueOf(file.getFreeSpace()));
        }
        AbstractC7731ae.m47442a(file, j10 * 3);
    }

    /* renamed from: a */
    public void m47142a(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream, File file) {
        AbstractC7805cy.m48142a(bufferedOutputStream);
        AbstractC7805cy.m48142a((Closeable) bufferedInputStream);
        AbstractC7731ae.m47449a(file);
    }

    /* renamed from: a */
    private void m47143a(Integer num, String str) {
        C7653sb c7653sb = this.f35623d;
        if (c7653sb != null) {
            c7653sb.m47170a(num);
            this.f35623d.m47172a(str);
        }
    }

    /* renamed from: a */
    private void m47144a(String str) {
        m47145a(str, 0, "", 0L);
    }

    /* renamed from: a */
    public void m47145a(String str, int i10, String str2, long j10) {
        if (this.f35624e != null) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.rz.1

                /* renamed from: a */
                final /* synthetic */ C7653sb f35628a;

                /* renamed from: b */
                final /* synthetic */ String f35629b;

                /* renamed from: c */
                final /* synthetic */ long f35630c;

                /* renamed from: d */
                final /* synthetic */ long f35631d;

                /* renamed from: e */
                final /* synthetic */ int f35632e;

                /* renamed from: f */
                final /* synthetic */ String f35633f;

                public AnonymousClass1(C7653sb c7653sb, String str3, long j102, long j11, int i102, String str22) {
                    c7653sb = c7653sb;
                    str = str3;
                    j = j102;
                    j = j11;
                    i = i102;
                    str = str22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7650rz.this.f35624e.mo39180a(c7653sb, str, j, j, i, str);
                }
            });
        }
    }

    /* renamed from: a */
    public void m47146a(String str, long j10) {
        m47145a(str, 0, "", j10);
    }

    /* renamed from: a */
    private boolean m47147a(String str, String str2, long j10) throws Throwable {
        int i10;
        int i11;
        if (!m47157e(str)) {
            AbstractC7185ho.m43823c("SourceFetcher", "downloadUrlToStream, checkSourceDataAndFileState failed");
            return false;
        }
        m47153c(str);
        try {
            try {
            } catch (IllegalArgumentException e10) {
                e = e10;
            } catch (Exception e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                m47155d(str);
                m47146a("72", j10);
                throw th;
            }
            try {
                Response<Boolean> responseM47132a = this.f35621a.m47132a(str, new a(str2, j10));
                AbstractC7185ho.m43821b("SourceFetcher", "httpCode: %s", Integer.valueOf(responseM47132a.m45977a()));
                if (responseM47132a.m45977a() != 200) {
                    i11 = 1;
                    m47145a("2", responseM47132a.m45977a(), responseM47132a.m45995d(), j10);
                } else {
                    i11 = 1;
                }
                this.f35623d.m47168a(responseM47132a.m46008m());
                Boolean boolM45987b = responseM47132a.m45987b();
                boolean zBooleanValue = boolM45987b != null ? boolM45987b.booleanValue() : false;
                Object[] objArr = new Object[i11];
                objArr[0] = Boolean.valueOf(zBooleanValue);
                AbstractC7185ho.m43821b("SourceFetcher", "file download result: %s", objArr);
                if (!zBooleanValue) {
                    m47143a((Integer) 0, "file download failed");
                }
                m47155d(str);
                m47146a("72", j10);
                return zBooleanValue;
            } catch (IllegalArgumentException e12) {
                e = e12;
                String str3 = "Error in download file - IllegalArgumentException:" + e.getClass().getSimpleName();
                AbstractC7185ho.m43823c("SourceFetcher", str3);
                m47143a((Integer) 2, str3);
                i10 = 5;
                AbstractC7185ho.m43815a(i10, e);
                m47155d(str);
                m47146a("72", j10);
                return false;
            } catch (Exception e13) {
                e = e13;
                String str4 = "Error in download file:" + e.getClass().getSimpleName();
                AbstractC7185ho.m43823c("SourceFetcher", str4);
                m47143a((Integer) 2, str4);
                i10 = 5;
                AbstractC7185ho.m43815a(i10, e);
                m47155d(str);
                m47146a("72", j10);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            m47155d(str);
            m47146a("72", j10);
            throw th;
        }
    }
}
