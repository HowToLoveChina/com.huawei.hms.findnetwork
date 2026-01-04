package p696v1;

import android.annotation.TargetApi;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: v1.a */
/* loaded from: classes.dex */
public final class C13325a implements Closeable {

    /* renamed from: a */
    public final File f60103a;

    /* renamed from: b */
    public final File f60104b;

    /* renamed from: c */
    public final File f60105c;

    /* renamed from: d */
    public final File f60106d;

    /* renamed from: e */
    public final int f60107e;

    /* renamed from: f */
    public long f60108f;

    /* renamed from: g */
    public final int f60109g;

    /* renamed from: i */
    public Writer f60111i;

    /* renamed from: k */
    public int f60113k;

    /* renamed from: h */
    public long f60110h = 0;

    /* renamed from: j */
    public final LinkedHashMap<String, d> f60112j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l */
    public long f60114l = 0;

    /* renamed from: m */
    public final ThreadPoolExecutor f60115m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n */
    public final Callable<Void> f60116n = new a();

    /* renamed from: v1.a$a */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (C13325a.this) {
                try {
                    if (C13325a.this.f60111i == null) {
                        return null;
                    }
                    C13325a.this.m79897J();
                    if (C13325a.this.m79891B()) {
                        C13325a.this.m79895G();
                        C13325a.this.f60113k = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: v1.a$b */
    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: v1.a$c */
    public final class c {

        /* renamed from: a */
        public final d f60118a;

        /* renamed from: b */
        public final boolean[] f60119b;

        /* renamed from: c */
        public boolean f60120c;

        public /* synthetic */ c(C13325a c13325a, d dVar, a aVar) {
            this(dVar);
        }

        /* renamed from: a */
        public void m79906a() throws IOException {
            C13325a.this.m79899u(this, false);
        }

        /* renamed from: b */
        public void m79907b() {
            if (this.f60120c) {
                return;
            }
            try {
                m79906a();
            } catch (IOException unused) {
            }
        }

        /* renamed from: e */
        public void m79908e() throws IOException {
            C13325a.this.m79899u(this, true);
            this.f60120c = true;
        }

        /* renamed from: f */
        public File m79909f(int i10) throws IOException {
            File fileM79920k;
            synchronized (C13325a.this) {
                try {
                    if (this.f60118a.f60127f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f60118a.f60126e) {
                        this.f60119b[i10] = true;
                    }
                    fileM79920k = this.f60118a.m79920k(i10);
                    C13325a.this.f60103a.mkdirs();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return fileM79920k;
        }

        public c(d dVar) {
            this.f60118a = dVar;
            this.f60119b = dVar.f60126e ? null : new boolean[C13325a.this.f60109g];
        }
    }

    /* renamed from: v1.a$d */
    public final class d {

        /* renamed from: a */
        public final String f60122a;

        /* renamed from: b */
        public final long[] f60123b;

        /* renamed from: c */
        public File[] f60124c;

        /* renamed from: d */
        public File[] f60125d;

        /* renamed from: e */
        public boolean f60126e;

        /* renamed from: f */
        public c f60127f;

        /* renamed from: g */
        public long f60128g;

        public /* synthetic */ d(C13325a c13325a, String str, a aVar) {
            this(str);
        }

        /* renamed from: j */
        public File m79919j(int i10) {
            return this.f60124c[i10];
        }

        /* renamed from: k */
        public File m79920k(int i10) {
            return this.f60125d[i10];
        }

        /* renamed from: l */
        public String m79921l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f60123b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        /* renamed from: m */
        public final IOException m79922m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: n */
        public final void m79923n(String[] strArr) throws IOException {
            if (strArr.length != C13325a.this.f60109g) {
                throw m79922m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f60123b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m79922m(strArr);
                }
            }
        }

        public d(String str) {
            this.f60122a = str;
            this.f60123b = new long[C13325a.this.f60109g];
            this.f60124c = new File[C13325a.this.f60109g];
            this.f60125d = new File[C13325a.this.f60109g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < C13325a.this.f60109g; i10++) {
                sb2.append(i10);
                this.f60124c[i10] = new File(C13325a.this.f60103a, sb2.toString());
                sb2.append(".tmp");
                this.f60125d[i10] = new File(C13325a.this.f60103a, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    /* renamed from: v1.a$e */
    public final class e {

        /* renamed from: a */
        public final String f60130a;

        /* renamed from: b */
        public final long f60131b;

        /* renamed from: c */
        public final long[] f60132c;

        /* renamed from: d */
        public final File[] f60133d;

        public /* synthetic */ e(C13325a c13325a, String str, long j10, File[] fileArr, long[] jArr, a aVar) {
            this(str, j10, fileArr, jArr);
        }

        /* renamed from: a */
        public File m79924a(int i10) {
            return this.f60133d[i10];
        }

        public e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f60130a = str;
            this.f60131b = j10;
            this.f60133d = fileArr;
            this.f60132c = jArr;
        }
    }

    public C13325a(File file, int i10, int i11, long j10) {
        this.f60103a = file;
        this.f60107e = i10;
        this.f60104b = new File(file, "journal");
        this.f60105c = new File(file, "journal.tmp");
        this.f60106d = new File(file, "journal.bkp");
        this.f60109g = i11;
        this.f60108f = j10;
    }

    /* renamed from: C */
    public static C13325a m79877C(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m79878I(file2, file3, false);
            }
        }
        C13325a c13325a = new C13325a(file, i10, i11, j10);
        if (c13325a.f60104b.exists()) {
            try {
                c13325a.m79893E();
                c13325a.m79892D();
                return c13325a;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                c13325a.m79900v();
            }
        }
        file.mkdirs();
        C13325a c13325a2 = new C13325a(file, i10, i11, j10);
        c13325a2.m79895G();
        return c13325a2;
    }

    /* renamed from: I */
    public static void m79878I(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            m79888w(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    /* renamed from: t */
    public static void m79887t(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* renamed from: w */
    public static void m79888w(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    /* renamed from: z */
    public static void m79889z(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* renamed from: A */
    public synchronized e m79890A(String str) throws IOException {
        m79898s();
        d dVar = this.f60112j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f60126e) {
            return null;
        }
        for (File file : dVar.f60124c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f60113k++;
        this.f60111i.append((CharSequence) "READ");
        this.f60111i.append(' ');
        this.f60111i.append((CharSequence) str);
        this.f60111i.append('\n');
        if (m79891B()) {
            this.f60115m.submit(this.f60116n);
        }
        return new e(this, str, dVar.f60128g, dVar.f60124c, dVar.f60123b, null);
    }

    /* renamed from: B */
    public final boolean m79891B() {
        int i10 = this.f60113k;
        return i10 >= 2000 && i10 >= this.f60112j.size();
    }

    /* renamed from: D */
    public final void m79892D() throws IOException {
        m79888w(this.f60105c);
        Iterator<d> it = this.f60112j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f60127f == null) {
                while (i10 < this.f60109g) {
                    this.f60110h += next.f60123b[i10];
                    i10++;
                }
            } else {
                next.f60127f = null;
                while (i10 < this.f60109g) {
                    m79888w(next.m79919j(i10));
                    m79888w(next.m79920k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: E */
    public final void m79893E() throws IOException {
        C13326b c13326b = new C13326b(new FileInputStream(this.f60104b), C13327c.f60141a);
        try {
            String strM79928u = c13326b.m79928u();
            String strM79928u2 = c13326b.m79928u();
            String strM79928u3 = c13326b.m79928u();
            String strM79928u4 = c13326b.m79928u();
            String strM79928u5 = c13326b.m79928u();
            if (!"libcore.io.DiskLruCache".equals(strM79928u) || !"1".equals(strM79928u2) || !Integer.toString(this.f60107e).equals(strM79928u3) || !Integer.toString(this.f60109g).equals(strM79928u4) || !"".equals(strM79928u5)) {
                throw new IOException("unexpected journal header: [" + strM79928u + ", " + strM79928u2 + ", " + strM79928u4 + ", " + strM79928u5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    m79894F(c13326b.m79928u());
                    i10++;
                } catch (EOFException unused) {
                    this.f60113k = i10 - this.f60112j.size();
                    if (c13326b.m79927t()) {
                        m79895G();
                    } else {
                        this.f60111i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f60104b, true), C13327c.f60141a));
                    }
                    C13327c.m79929a(c13326b);
                    return;
                }
            }
        } catch (Throwable th2) {
            C13327c.m79929a(c13326b);
            throw th2;
        }
    }

    /* renamed from: F */
    public final void m79894F(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f60112j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = this.f60112j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.f60112j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f60126e = true;
            dVar.f60127f = null;
            dVar.m79923n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f60127f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: G */
    public final synchronized void m79895G() throws IOException {
        try {
            Writer writer = this.f60111i;
            if (writer != null) {
                m79887t(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f60105c), C13327c.f60141a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f60107e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f60109g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f60112j.values()) {
                    if (dVar.f60127f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f60122a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f60122a + dVar.m79921l() + '\n');
                    }
                }
                m79887t(bufferedWriter);
                if (this.f60104b.exists()) {
                    m79878I(this.f60104b, this.f60106d, true);
                }
                m79878I(this.f60105c, this.f60104b, false);
                this.f60106d.delete();
                this.f60111i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f60104b, true), C13327c.f60141a));
            } catch (Throwable th2) {
                m79887t(bufferedWriter);
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* renamed from: H */
    public synchronized boolean m79896H(String str) throws IOException {
        try {
            m79898s();
            d dVar = this.f60112j.get(str);
            if (dVar != null && dVar.f60127f == null) {
                for (int i10 = 0; i10 < this.f60109g; i10++) {
                    File fileM79919j = dVar.m79919j(i10);
                    if (fileM79919j.exists() && !fileM79919j.delete()) {
                        throw new IOException("failed to delete " + fileM79919j);
                    }
                    this.f60110h -= dVar.f60123b[i10];
                    dVar.f60123b[i10] = 0;
                }
                this.f60113k++;
                this.f60111i.append((CharSequence) "REMOVE");
                this.f60111i.append(' ');
                this.f60111i.append((CharSequence) str);
                this.f60111i.append('\n');
                this.f60112j.remove(str);
                if (m79891B()) {
                    this.f60115m.submit(this.f60116n);
                }
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: J */
    public final void m79897J() throws IOException {
        while (this.f60110h > this.f60108f) {
            m79896H(this.f60112j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f60111i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f60112j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f60127f != null) {
                    dVar.f60127f.m79906a();
                }
            }
            m79897J();
            m79887t(this.f60111i);
            this.f60111i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: s */
    public final void m79898s() {
        if (this.f60111i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: u */
    public final synchronized void m79899u(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f60118a;
        if (dVar.f60127f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f60126e) {
            for (int i10 = 0; i10 < this.f60109g; i10++) {
                if (!cVar.f60119b[i10]) {
                    cVar.m79906a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.m79920k(i10).exists()) {
                    cVar.m79906a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f60109g; i11++) {
            File fileM79920k = dVar.m79920k(i11);
            if (!z10) {
                m79888w(fileM79920k);
            } else if (fileM79920k.exists()) {
                File fileM79919j = dVar.m79919j(i11);
                fileM79920k.renameTo(fileM79919j);
                long j10 = dVar.f60123b[i11];
                long length = fileM79919j.length();
                dVar.f60123b[i11] = length;
                this.f60110h = (this.f60110h - j10) + length;
            }
        }
        this.f60113k++;
        dVar.f60127f = null;
        if (dVar.f60126e || z10) {
            dVar.f60126e = true;
            this.f60111i.append((CharSequence) "CLEAN");
            this.f60111i.append(' ');
            this.f60111i.append((CharSequence) dVar.f60122a);
            this.f60111i.append((CharSequence) dVar.m79921l());
            this.f60111i.append('\n');
            if (z10) {
                long j11 = this.f60114l;
                this.f60114l = 1 + j11;
                dVar.f60128g = j11;
            }
        } else {
            this.f60112j.remove(dVar.f60122a);
            this.f60111i.append((CharSequence) "REMOVE");
            this.f60111i.append(' ');
            this.f60111i.append((CharSequence) dVar.f60122a);
            this.f60111i.append('\n');
        }
        m79889z(this.f60111i);
        if (this.f60110h > this.f60108f || m79891B()) {
            this.f60115m.submit(this.f60116n);
        }
    }

    /* renamed from: v */
    public void m79900v() throws IOException {
        close();
        C13327c.m79930b(this.f60103a);
    }

    /* renamed from: x */
    public c m79901x(String str) throws IOException {
        return m79902y(str, -1L);
    }

    /* renamed from: y */
    public final synchronized c m79902y(String str, long j10) throws IOException {
        m79898s();
        d dVar = this.f60112j.get(str);
        a aVar = null;
        if (j10 != -1 && (dVar == null || dVar.f60128g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f60112j.put(str, dVar);
        } else if (dVar.f60127f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f60127f = cVar;
        this.f60111i.append((CharSequence) "DIRTY");
        this.f60111i.append(' ');
        this.f60111i.append((CharSequence) str);
        this.f60111i.append('\n');
        m79889z(this.f60111i);
        return cVar;
    }
}
