package com.huawei.hms.network.embedded;

import android.annotation.TargetApi;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
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

/* renamed from: com.huawei.hms.network.embedded.a */
/* loaded from: classes8.dex */
public final class C5842a implements Closeable {

    /* renamed from: o */
    public static final String f26253o = "journal";

    /* renamed from: p */
    public static final String f26254p = "journal.tmp";

    /* renamed from: q */
    public static final String f26255q = "journal.bkp";

    /* renamed from: r */
    public static final String f26256r = "libcore.io.DiskLruCache";

    /* renamed from: s */
    public static final String f26257s = "1";

    /* renamed from: t */
    public static final long f26258t = -1;

    /* renamed from: u */
    public static final String f26259u = "CLEAN";

    /* renamed from: v */
    public static final String f26260v = "DIRTY";

    /* renamed from: w */
    public static final String f26261w = "REMOVE";

    /* renamed from: x */
    public static final String f26262x = "READ";

    /* renamed from: a */
    public final File f26263a;

    /* renamed from: b */
    public final File f26264b;

    /* renamed from: c */
    public final File f26265c;

    /* renamed from: d */
    public final File f26266d;

    /* renamed from: e */
    public final int f26267e;

    /* renamed from: f */
    public long f26268f;

    /* renamed from: g */
    public final int f26269g;

    /* renamed from: i */
    public Writer f26271i;

    /* renamed from: k */
    public int f26273k;

    /* renamed from: h */
    public long f26270h = 0;

    /* renamed from: j */
    public final LinkedHashMap<String, d> f26272j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l */
    public long f26274l = 0;

    /* renamed from: m */
    public final ThreadPoolExecutor f26275m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n */
    public final Callable<Void> f26276n = new a();

    /* renamed from: com.huawei.hms.network.embedded.a$a */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (C5842a.this) {
                try {
                    if (C5842a.this.f26271i == null) {
                        return null;
                    }
                    C5842a.this.m33674C();
                    if (C5842a.this.m33695y()) {
                        C5842a.this.m33673B();
                        C5842a.this.f26273k = 0;
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.a$b */
    public static final class b implements ThreadFactory {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.a$c */
    public final class c {

        /* renamed from: a */
        public final d f26278a;

        /* renamed from: b */
        public final boolean[] f26279b;

        /* renamed from: c */
        public boolean f26280c;

        public c(d dVar) {
            this.f26278a = dVar;
            this.f26279b = dVar.f26286e ? null : new boolean[C5842a.this.f26269g];
        }

        /* renamed from: c */
        private InputStream m33708c(int i10) throws IOException {
            synchronized (C5842a.this) {
                if (this.f26278a.f26287f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f26278a.f26286e) {
                    return null;
                }
                try {
                    return new FileInputStream(this.f26278a.m33726a(i10));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        /* renamed from: b */
        public String m33712b(int i10) throws IOException {
            InputStream inputStreamM33708c = m33708c(i10);
            if (inputStreamM33708c != null) {
                return C5842a.m33687b(inputStreamM33708c);
            }
            return null;
        }

        public /* synthetic */ c(C5842a c5842a, d dVar, a aVar) {
            this(dVar);
        }

        /* renamed from: a */
        public File m33709a(int i10) throws IOException {
            File fileM33728b;
            synchronized (C5842a.this) {
                try {
                    if (this.f26278a.f26287f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f26278a.f26286e) {
                        this.f26279b[i10] = true;
                    }
                    fileM33728b = this.f26278a.m33728b(i10);
                    C5842a.this.f26263a.mkdirs();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return fileM33728b;
        }

        /* renamed from: b */
        public void m33713b() {
            if (this.f26280c) {
                return;
            }
            try {
                m33710a();
            } catch (IOException unused) {
            }
        }

        /* renamed from: c */
        public void m33714c() throws IOException {
            C5842a.this.m33681a(this, true);
            this.f26280c = true;
        }

        /* renamed from: a */
        public void m33710a() throws IOException {
            C5842a.this.m33681a(this, false);
        }

        /* renamed from: a */
        public void m33711a(int i10, String str) throws Throwable {
            Throwable th2;
            OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(m33709a(i10)), C5870c.f26535b);
            } catch (Throwable th3) {
                th2 = th3;
                outputStreamWriter = null;
            }
            try {
                outputStreamWriter.write(str);
                C5870c.m33998a(outputStreamWriter);
            } catch (Throwable th4) {
                th2 = th4;
                C5870c.m33998a(outputStreamWriter);
                throw th2;
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.a$d */
    public final class d {

        /* renamed from: a */
        public final String f26282a;

        /* renamed from: b */
        public final long[] f26283b;

        /* renamed from: c */
        public File[] f26284c;

        /* renamed from: d */
        public File[] f26285d;

        /* renamed from: e */
        public boolean f26286e;

        /* renamed from: f */
        public c f26287f;

        /* renamed from: g */
        public long f26288g;

        public d(String str) {
            this.f26282a = str;
            this.f26283b = new long[C5842a.this.f26269g];
            this.f26284c = new File[C5842a.this.f26269g];
            this.f26285d = new File[C5842a.this.f26269g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < C5842a.this.f26269g; i10++) {
                sb2.append(i10);
                this.f26284c[i10] = new File(C5842a.this.f26263a, sb2.toString());
                sb2.append(".tmp");
                this.f26285d[i10] = new File(C5842a.this.f26263a, sb2.toString());
                sb2.setLength(length);
            }
        }

        /* renamed from: b */
        public File m33728b(int i10) {
            return this.f26285d[i10];
        }

        public /* synthetic */ d(C5842a c5842a, String str, a aVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m33722b(String[] strArr) throws IOException {
            if (strArr.length != C5842a.this.f26269g) {
                throw m33717a(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f26283b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m33717a(strArr);
                }
            }
        }

        /* renamed from: a */
        public File m33726a(int i10) {
            return this.f26284c[i10];
        }

        /* renamed from: a */
        private IOException m33717a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public String m33727a() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f26283b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.a$e */
    public final class e {

        /* renamed from: a */
        public final String f26290a;

        /* renamed from: b */
        public final long f26291b;

        /* renamed from: c */
        public final long[] f26292c;

        /* renamed from: d */
        public final File[] f26293d;

        public e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f26290a = str;
            this.f26291b = j10;
            this.f26293d = fileArr;
            this.f26292c = jArr;
        }

        /* renamed from: a */
        public c m33729a() throws IOException {
            return C5842a.this.m33677a(this.f26290a, this.f26291b);
        }

        /* renamed from: b */
        public long m33731b(int i10) {
            return this.f26292c[i10];
        }

        /* renamed from: c */
        public String m33732c(int i10) throws IOException {
            return C5842a.m33687b(new FileInputStream(this.f26293d[i10]));
        }

        public /* synthetic */ e(C5842a c5842a, String str, long j10, File[] fileArr, long[] jArr, a aVar) {
            this(str, j10, fileArr, jArr);
        }

        /* renamed from: a */
        public File m33730a(int i10) {
            return this.f26293d[i10];
        }
    }

    public C5842a(File file, int i10, int i11, long j10) {
        this.f26263a = file;
        this.f26267e = i10;
        this.f26264b = new File(file, "journal");
        this.f26265c = new File(file, "journal.tmp");
        this.f26266d = new File(file, "journal.bkp");
        this.f26269g = i11;
        this.f26268f = j10;
    }

    /* renamed from: A */
    private void m33672A() throws IOException {
        C5856b c5856b = new C5856b(new FileInputStream(this.f26264b), C5870c.f26534a);
        try {
            String strM33851t = c5856b.m33851t();
            String strM33851t2 = c5856b.m33851t();
            String strM33851t3 = c5856b.m33851t();
            String strM33851t4 = c5856b.m33851t();
            String strM33851t5 = c5856b.m33851t();
            if (!"libcore.io.DiskLruCache".equals(strM33851t) || !"1".equals(strM33851t2) || !Integer.toString(this.f26267e).equals(strM33851t3) || !Integer.toString(this.f26269g).equals(strM33851t4) || !"".equals(strM33851t5)) {
                throw new IOException("unexpected journal header: [" + strM33851t + ", " + strM33851t2 + ", " + strM33851t4 + ", " + strM33851t5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    m33691e(c5856b.m33851t());
                    i10++;
                } catch (EOFException unused) {
                    this.f26273k = i10 - this.f26272j.size();
                    if (c5856b.m33850s()) {
                        m33673B();
                    } else {
                        this.f26271i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f26264b, true), C5870c.f26534a));
                    }
                    C5870c.m33998a(c5856b);
                    return;
                }
            }
        } catch (Throwable th2) {
            C5870c.m33998a(c5856b);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public synchronized void m33673B() throws IOException {
        StringBuilder sb2;
        try {
            Writer writer = this.f26271i;
            if (writer != null) {
                m33685a(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f26265c), C5870c.f26534a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f26267e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f26269g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f26272j.values()) {
                    if (dVar.f26287f != null) {
                        sb2 = new StringBuilder();
                        sb2.append("DIRTY ");
                        sb2.append(dVar.f26282a);
                        sb2.append('\n');
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(dVar.f26282a);
                        sb2.append(dVar.m33727a());
                        sb2.append('\n');
                    }
                    bufferedWriter.write(sb2.toString());
                }
                m33685a(bufferedWriter);
                if (this.f26264b.exists()) {
                    m33684a(this.f26264b, this.f26266d, true);
                }
                m33684a(this.f26265c, this.f26264b, false);
                this.f26266d.delete();
                this.f26271i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f26264b, true), C5870c.f26534a));
            } catch (Throwable th2) {
                m33685a(bufferedWriter);
                throw th2;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m33674C() throws IOException {
        while (this.f26270h > this.f26268f) {
            m33699d(this.f26272j.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: e */
    private void m33691e(String str) throws IOException {
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
                this.f26272j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = this.f26272j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.f26272j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f26286e = true;
            dVar.f26287f = null;
            dVar.m33722b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f26287f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: x */
    private void m33694x() {
        if (this.f26271i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public boolean m33695y() {
        int i10 = this.f26273k;
        return i10 >= 2000 && i10 >= this.f26272j.size();
    }

    /* renamed from: z */
    private void m33696z() throws IOException {
        m33683a(this.f26265c);
        Iterator<d> it = this.f26272j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f26287f == null) {
                while (i10 < this.f26269g) {
                    this.f26270h += next.f26283b[i10];
                    i10++;
                }
            } else {
                next.f26287f = null;
                while (i10 < this.f26269g) {
                    m33683a(next.m33726a(i10));
                    m33683a(next.m33728b(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: c */
    public synchronized e m33698c(String str) throws IOException {
        m33694x();
        d dVar = this.f26272j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f26286e) {
            return null;
        }
        for (File file : dVar.f26284c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f26273k++;
        this.f26271i.append((CharSequence) "READ");
        this.f26271i.append(' ');
        this.f26271i.append((CharSequence) str);
        this.f26271i.append('\n');
        if (m33695y()) {
            this.f26275m.submit(this.f26276n);
        }
        return new e(this, str, dVar.f26288g, dVar.f26284c, dVar.f26283b, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f26271i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f26272j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f26287f != null) {
                    dVar.f26287f.m33710a();
                }
            }
            m33674C();
            m33685a(this.f26271i);
            this.f26271i = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void flush() throws IOException {
        m33694x();
        m33674C();
        m33688b(this.f26271i);
    }

    /* renamed from: j */
    public synchronized void m33700j(long j10) {
        this.f26268f = j10;
        this.f26275m.submit(this.f26276n);
    }

    /* renamed from: s */
    public void m33701s() throws IOException {
        close();
        C5870c.m33999a(this.f26263a);
    }

    /* renamed from: t */
    public File m33702t() {
        return this.f26263a;
    }

    /* renamed from: u */
    public synchronized long m33703u() {
        return this.f26268f;
    }

    /* renamed from: v */
    public synchronized boolean m33704v() {
        return this.f26271i == null;
    }

    /* renamed from: w */
    public synchronized long m33705w() {
        return this.f26270h;
    }

    /* renamed from: b */
    public c m33697b(String str) throws IOException {
        return m33677a(str, -1L);
    }

    /* renamed from: d */
    public synchronized boolean m33699d(String str) throws IOException {
        try {
            m33694x();
            d dVar = this.f26272j.get(str);
            if (dVar != null && dVar.f26287f == null) {
                for (int i10 = 0; i10 < this.f26269g; i10++) {
                    File fileM33726a = dVar.m33726a(i10);
                    if (fileM33726a.exists() && !fileM33726a.delete()) {
                        throw new IOException("failed to delete " + fileM33726a);
                    }
                    this.f26270h -= dVar.f26283b[i10];
                    dVar.f26283b[i10] = 0;
                }
                this.f26273k++;
                this.f26271i.append((CharSequence) "REMOVE");
                this.f26271i.append(' ');
                this.f26271i.append((CharSequence) str);
                this.f26271i.append('\n');
                this.f26272j.remove(str);
                if (m33695y()) {
                    this.f26275m.submit(this.f26276n);
                }
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized c m33677a(String str, long j10) throws IOException {
        m33694x();
        d dVar = this.f26272j.get(str);
        a aVar = null;
        if (j10 != -1 && (dVar == null || dVar.f26288g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f26272j.put(str, dVar);
        } else if (dVar.f26287f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f26287f = cVar;
        this.f26271i.append((CharSequence) "DIRTY");
        this.f26271i.append(' ');
        this.f26271i.append((CharSequence) str);
        this.f26271i.append('\n');
        m33688b(this.f26271i);
        return cVar;
    }

    /* renamed from: b */
    public static String m33687b(InputStream inputStream) throws IOException {
        return C5870c.m33997a((Reader) new InputStreamReader(inputStream, C5870c.f26535b));
    }

    /* renamed from: a */
    public static C5842a m33678a(File file, int i10, int i11, long j10) throws IOException {
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
                m33684a(file2, file3, false);
            }
        }
        C5842a c5842a = new C5842a(file, i10, i11, j10);
        if (c5842a.f26264b.exists()) {
            try {
                c5842a.m33672A();
                c5842a.m33696z();
                return c5842a;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                c5842a.m33701s();
            }
        }
        file.mkdirs();
        C5842a c5842a2 = new C5842a(file, i10, i11, j10);
        c5842a2.m33673B();
        return c5842a2;
    }

    @TargetApi(26)
    /* renamed from: b */
    public static void m33688b(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m33681a(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f26278a;
        if (dVar.f26287f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f26286e) {
            for (int i10 = 0; i10 < this.f26269g; i10++) {
                if (!cVar.f26279b[i10]) {
                    cVar.m33710a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.m33728b(i10).exists()) {
                    cVar.m33710a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f26269g; i11++) {
            File fileM33728b = dVar.m33728b(i11);
            if (!z10) {
                m33683a(fileM33728b);
            } else if (fileM33728b.exists()) {
                File fileM33726a = dVar.m33726a(i11);
                fileM33728b.renameTo(fileM33726a);
                long j10 = dVar.f26283b[i11];
                long length = fileM33726a.length();
                dVar.f26283b[i11] = length;
                this.f26270h = (this.f26270h - j10) + length;
            }
        }
        this.f26273k++;
        dVar.f26287f = null;
        if (!(dVar.f26286e | z10)) {
            this.f26272j.remove(dVar.f26282a);
            this.f26271i.append((CharSequence) "REMOVE");
            this.f26271i.append(' ');
            this.f26271i.append((CharSequence) dVar.f26282a);
            this.f26271i.append('\n');
        } else {
            dVar.f26286e = true;
            this.f26271i.append((CharSequence) "CLEAN");
            this.f26271i.append(' ');
            this.f26271i.append((CharSequence) dVar.f26282a);
            this.f26271i.append((CharSequence) dVar.m33727a());
            this.f26271i.append('\n');
            if (z10) {
                long j11 = this.f26274l;
                this.f26274l = 1 + j11;
                dVar.f26288g = j11;
            }
        }
        m33688b(this.f26271i);
        if (this.f26270h > this.f26268f || m33695y()) {
            this.f26275m.submit(this.f26276n);
        }
    }

    /* renamed from: a */
    public static void m33683a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public static void m33684a(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            m33683a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    /* renamed from: a */
    public static void m33685a(Writer writer) throws IOException {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
