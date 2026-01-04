package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.CreateFileUtil;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.base.common.Headers;
import com.huawei.hms.network.embedded.C5842a;
import com.huawei.hms.network.embedded.C5913f1;
import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.embedded.C6069r1;
import com.huawei.hms.network.embedded.C6107u0;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.n1 */
/* loaded from: classes8.dex */
public final class C6017n1 implements InterfaceC6121v1 {
    public static final int ENTRY_METADATA = 0;

    /* renamed from: b */
    public static final String f27540b = "Cache";

    /* renamed from: c */
    public static final String f27541c = "\n";

    /* renamed from: d */
    public static final int f27542d = 1;

    /* renamed from: e */
    public static final int f27543e = 2;

    /* renamed from: f */
    public static final int f27544f = 80001309;

    /* renamed from: a */
    public C5842a f27545a;

    /* renamed from: com.huawei.hms.network.embedded.n1$b */
    public final class b implements InterfaceC6030o1 {

        /* renamed from: f */
        public static final String f27546f = "CacheBodyImpl";

        /* renamed from: a */
        public boolean f27547a;

        /* renamed from: b */
        public C5842a.c f27548b;

        /* renamed from: c */
        public OutputStream f27549c;

        /* renamed from: d */
        public OutputStream f27550d;

        /* renamed from: com.huawei.hms.network.embedded.n1$b$a */
        public class a extends C14442b {

            /* renamed from: c */
            public final /* synthetic */ C6017n1 f27552c;

            /* renamed from: d */
            public final /* synthetic */ C5842a.c f27553d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(OutputStream outputStream, C6017n1 c6017n1, C5842a.c cVar) {
                super(outputStream);
                this.f27552c = c6017n1;
                this.f27553d = cVar;
            }

            @Override // com.huawei.hms.network.embedded.C6017n1.b.C14442b, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                synchronized (C6017n1.this) {
                    try {
                        b bVar = b.this;
                        if (bVar.f27547a) {
                            return;
                        }
                        bVar.f27547a = true;
                        super.close();
                        this.f27553d.m33714c();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        /* renamed from: com.huawei.hms.network.embedded.n1$b$b */
        public class C14442b extends OutputStream {

            /* renamed from: a */
            public final OutputStream f27555a;

            public C14442b(OutputStream outputStream) {
                if (outputStream == null) {
                    throw new IllegalArgumentException("outputStream == null");
                }
                this.f27555a = outputStream;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f27555a.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f27555a.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i10) throws IOException {
                this.f27555a.write(i10);
            }

            public /* synthetic */ C14442b(b bVar, OutputStream outputStream, a aVar) {
                this(outputStream);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr) throws IOException {
                this.f27555a.write(bArr);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) throws IOException {
                this.f27555a.write(bArr, i10, i11);
            }
        }

        public b(C5842a.c cVar) {
            this.f27548b = cVar;
            try {
                this.f27549c = new FileOutputStream(cVar.m33709a(1));
                this.f27550d = new a(this.f27549c, C6017n1.this, cVar);
            } catch (IOException unused) {
                Logger.m32145w(f27546f, "An exception occurred during the commit.");
                try {
                    cVar.m33710a();
                } catch (IOException unused2) {
                    Logger.m32145w(f27546f, "An exception occurred during the commit, Terminating the cached file failed !");
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6030o1
        public void abort() throws IOException {
            synchronized (C6017n1.this) {
                try {
                    if (this.f27547a) {
                        return;
                    }
                    this.f27547a = true;
                    IoUtils.closeSecure(this.f27549c);
                    try {
                        this.f27548b.m33710a();
                    } catch (IOException unused) {
                        Logger.m32145w(f27546f, "Terminating the cached file failed !");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6030o1
        public void close() throws IOException {
            OutputStream outputStream = this.f27550d;
            if (outputStream != null) {
                outputStream.close();
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6030o1
        public void write(byte[] bArr) throws IOException {
            OutputStream outputStream = this.f27550d;
            if (outputStream != null) {
                outputStream.write(bArr);
            }
        }

        public /* synthetic */ b(C6017n1 c6017n1, C5842a.c cVar, a aVar) {
            this(cVar);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.n1$c */
    public static final class c {

        /* renamed from: a */
        public final String f27557a;

        /* renamed from: b */
        public final int f27558b;

        /* renamed from: c */
        public final String f27559c;

        /* renamed from: d */
        public final Headers f27560d;

        /* renamed from: e */
        public final long f27561e;

        /* renamed from: f */
        public final long f27562f;

        /* renamed from: g */
        public final String f27563g;

        public c(C6069r1.c cVar) {
            this.f27557a = C6082s1.key(cVar.m35189c().getUrl());
            this.f27558b = cVar.m35190d().getCode();
            this.f27559c = cVar.m35190d().getMessage();
            this.f27560d = Headers.m33636of(cVar.m35190d().getHeaders());
            this.f27561e = cVar.m35192f();
            this.f27562f = cVar.m35187a();
            this.f27563g = cVar.m35190d().getUrl();
        }

        /* renamed from: a */
        public void m34880a(C5842a.c cVar) throws Throwable {
            BufferedWriter bufferedWriter;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cVar.m33709a(0)), Charset.forName(Constants.UTF_8)));
                try {
                    bufferedWriter.write(this.f27557a + '\n');
                    bufferedWriter.write(this.f27558b + "\n");
                    bufferedWriter.write(this.f27559c + '\n');
                    bufferedWriter.write(this.f27561e + "\n");
                    bufferedWriter.write(this.f27562f + "\n");
                    bufferedWriter.write(this.f27563g + "\n");
                    int size = this.f27560d.size();
                    bufferedWriter.write(size + "\n");
                    for (int i10 = 0; i10 < size; i10++) {
                        bufferedWriter.write(this.f27560d.name(i10) + ":" + this.f27560d.value(i10) + '\n');
                    }
                    bufferedWriter.flush();
                    IoUtils.closeSecure((Writer) bufferedWriter);
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeSecure((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
        }

        public C6069r1.c response(Request request, C5842a c5842a, C5842a.e eVar) throws IOException {
            String str = this.f27560d.get("Content-Type");
            long jStringToLong = C6108u1.stringToLong(this.f27560d.get("Content-Length"), -1L);
            return new C6069r1.c(this.f27561e, this.f27562f, request, new C6107u0.b().url(this.f27563g).code(this.f27558b).message(this.f27559c).headers(this.f27560d.toMultimap()).body(new C5939h1.g(new C5913f1.b().contentLength(jStringToLong).contentType(str).inputStream(new C6095t1(c5842a, this.f27557a, new FileInputStream(eVar.m33730a(1)))).build())).build());
        }

        public c(File file) throws Throwable {
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader;
            if (file == null) {
                throw new IOException("Cached file is empty");
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream2, Charset.forName(Constants.UTF_8));
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                    try {
                        this.f27557a = bufferedReader.readLine();
                        this.f27558b = C6108u1.stringToInteger(bufferedReader.readLine(), -1);
                        this.f27559c = bufferedReader.readLine();
                        this.f27561e = C6108u1.stringToLong(bufferedReader.readLine(), -1L);
                        this.f27562f = C6108u1.stringToLong(bufferedReader.readLine(), -1L);
                        this.f27563g = bufferedReader.readLine();
                        Headers.Builder builder = new Headers.Builder();
                        int iStringToInteger = C6108u1.stringToInteger(bufferedReader.readLine(), -1);
                        for (int i10 = 0; i10 < iStringToInteger; i10++) {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                builder.addLenient(line);
                            }
                        }
                        this.f27560d = builder.build();
                        IoUtils.closeSecure((Reader) bufferedReader);
                        IoUtils.closeSecure((Reader) inputStreamReader);
                        IoUtils.closeSecure((InputStream) fileInputStream2);
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        IoUtils.closeSecure((Reader) bufferedReader);
                        IoUtils.closeSecure((Reader) inputStreamReader);
                        IoUtils.closeSecure((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                bufferedReader = null;
            }
        }

        /* renamed from: a */
        public boolean m34883a(Request request) {
            return this.f27557a.equals(C6082s1.key(request.getUrl()));
        }
    }

    public C6017n1(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File fileNewFile = CreateFileUtil.newFile(ContextHolder.getAppContext().getCacheDir().getPath() + File.separator + str);
        try {
            this.f27545a = C5842a.m33678a(fileNewFile.getCanonicalFile(), 80001309, 2, j10);
        } catch (IOException unused) {
            CreateFileUtil.deleteSecure(fileNewFile);
            Logger.m32145w(f27540b, "DiskLruCache failed to create.");
            this.f27545a = null;
        }
    }

    /* renamed from: a */
    private void m34879a(C5842a.c cVar) {
        if (cVar != null) {
            try {
                cVar.m33710a();
            } catch (IOException unused) {
                Logger.m32145w(f27540b, "Terminating the cached file failed !");
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6121v1
    public C6069r1.c get(Request request) throws IOException {
        String strKey = C6082s1.key(request.getUrl());
        if (TextUtils.isEmpty(strKey)) {
            return null;
        }
        try {
            C5842a.e eVarM33698c = this.f27545a.m33698c(strKey);
            if (eVarM33698c == null) {
                return null;
            }
            c cVar = new c(eVarM33698c.m33730a(0));
            C6069r1.c cVarResponse = cVar.response(request, this.f27545a, eVarM33698c);
            if (cVar.m34883a(request)) {
                return cVarResponse;
            }
            IoUtils.closeSecure(cVarResponse.m35190d().getBody());
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean isInvalid() {
        return this.f27545a == null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6121v1
    public InterfaceC6030o1 put(C6069r1.c cVar) throws Throwable {
        C5842a.c cVarM33697b;
        String strKey = C6082s1.key(cVar.m35189c().getUrl());
        if (TextUtils.isEmpty(strKey)) {
            return null;
        }
        c cVar2 = new c(cVar);
        try {
            cVarM33697b = this.f27545a.m33697b(strKey);
            if (cVarM33697b == null) {
                return null;
            }
            try {
                cVar2.m34880a(cVarM33697b);
                return new b(cVarM33697b);
            } catch (IOException unused) {
                m34879a(cVarM33697b);
                return null;
            }
        } catch (IOException unused2) {
            cVarM33697b = null;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6121v1
    public void remove(C5872c1 c5872c1) {
        if (c5872c1 == null) {
            return;
        }
        String strKey = C6082s1.key(c5872c1.getUrl());
        if (TextUtils.isEmpty(strKey)) {
            return;
        }
        try {
            this.f27545a.m33699d(strKey);
        } catch (IOException unused) {
            Logger.m32138e(f27540b, "remove cached files of the request failed.");
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6121v1
    public void update(C6069r1.c cVar) throws Throwable {
        C5842a.c cVarM33729a;
        c cVar2 = new c(cVar);
        try {
            C5842a.e eVarM33698c = this.f27545a.m33698c(C6082s1.key(cVar.m35189c().getUrl()));
            if (eVarM33698c == null) {
                return;
            }
            try {
                cVarM33729a = eVarM33698c.m33729a();
                if (cVarM33729a != null) {
                    try {
                        cVar2.m34880a(cVarM33729a);
                        cVarM33729a.m33714c();
                    } catch (IOException unused) {
                        m34879a(cVarM33729a);
                    }
                }
            } catch (IOException unused2) {
                cVarM33729a = null;
            }
        } catch (IOException unused3) {
        }
    }
}
