package com.huawei.hms.network.embedded;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.huawei.hms.network.embedded.l8 */
/* loaded from: classes8.dex */
public final class C5998l8 implements Closeable, Flushable {

    /* renamed from: A */
    public static final Pattern f27388A = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: B */
    public static final String f27389B = "CLEAN";

    /* renamed from: C */
    public static final String f27390C = "DIRTY";

    /* renamed from: D */
    public static final String f27391D = "REMOVE";

    /* renamed from: E */
    public static final String f27392E = "READ";

    /* renamed from: F */
    public static final /* synthetic */ boolean f27393F = true;

    /* renamed from: u */
    public static final String f27394u = "journal";

    /* renamed from: v */
    public static final String f27395v = "journal.tmp";

    /* renamed from: w */
    public static final String f27396w = "journal.bkp";

    /* renamed from: x */
    public static final String f27397x = "libcore.io.DiskLruCache";

    /* renamed from: y */
    public static final String f27398y = "1";

    /* renamed from: z */
    public static final long f27399z = -1;

    /* renamed from: a */
    public final InterfaceC5909ea f27400a;

    /* renamed from: b */
    public final File f27401b;

    /* renamed from: c */
    public final File f27402c;

    /* renamed from: d */
    public final File f27403d;

    /* renamed from: e */
    public final File f27404e;

    /* renamed from: f */
    public final int f27405f;

    /* renamed from: g */
    public long f27406g;

    /* renamed from: h */
    public final int f27407h;

    /* renamed from: j */
    public InterfaceC5882cb f27409j;

    /* renamed from: l */
    public int f27411l;

    /* renamed from: m */
    public boolean f27412m;

    /* renamed from: n */
    public boolean f27413n;

    /* renamed from: o */
    public boolean f27414o;

    /* renamed from: p */
    public boolean f27415p;

    /* renamed from: q */
    public boolean f27416q;

    /* renamed from: s */
    public final Executor f27418s;

    /* renamed from: i */
    public long f27408i = 0;

    /* renamed from: k */
    public final LinkedHashMap<String, e> f27410k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: r */
    public long f27417r = 0;

    /* renamed from: t */
    public final Runnable f27419t = new a();

    /* renamed from: com.huawei.hms.network.embedded.l8$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C5998l8.this) {
                C5998l8 c5998l8 = C5998l8.this;
                if ((!c5998l8.f27413n) || c5998l8.f27414o) {
                    return;
                }
                try {
                    c5998l8.m34678C();
                } catch (IOException unused) {
                    C5998l8.this.f27415p = true;
                }
                try {
                    if (C5998l8.this.m34692y()) {
                        C5998l8.this.m34693z();
                        C5998l8.this.f27411l = 0;
                    }
                } catch (IOException unused2) {
                    C5998l8 c5998l82 = C5998l8.this;
                    c5998l82.f27416q = true;
                    c5998l82.f27409j = C6040ob.m34933a(C6040ob.m34935a());
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l8$b */
    public class b extends C6011m8 {

        /* renamed from: d */
        public static final /* synthetic */ boolean f27421d = true;

        public b(InterfaceC6170yb interfaceC6170yb) {
            super(interfaceC6170yb);
        }

        @Override // com.huawei.hms.network.embedded.C6011m8
        /* renamed from: a */
        public void mo34694a(IOException iOException) {
            if (!f27421d && !Thread.holdsLock(C5998l8.this)) {
                throw new AssertionError();
            }
            C5998l8.this.f27412m = true;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l8$c */
    public class c implements Iterator<f> {

        /* renamed from: a */
        public final Iterator<e> f27423a;

        /* renamed from: b */
        public f f27424b;

        /* renamed from: c */
        public f f27425c;

        public c() {
            this.f27423a = new ArrayList(C5998l8.this.f27410k.values()).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            f fVarM34702a;
            if (this.f27424b != null) {
                return true;
            }
            synchronized (C5998l8.this) {
                try {
                    if (C5998l8.this.f27414o) {
                        return false;
                    }
                    while (this.f27423a.hasNext()) {
                        e next = this.f27423a.next();
                        if (next.f27436e && (fVarM34702a = next.m34702a()) != null) {
                            this.f27424b = fVarM34702a;
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public f next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            f fVar = this.f27424b;
            this.f27425c = fVar;
            this.f27424b = null;
            return fVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            f fVar = this.f27425c;
            if (fVar == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                C5998l8.this.m34684d(fVar.f27440a);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.f27425c = null;
                throw th2;
            }
            this.f27425c = null;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l8$d */
    public final class d {

        /* renamed from: a */
        public final e f27427a;

        /* renamed from: b */
        public final boolean[] f27428b;

        /* renamed from: c */
        public boolean f27429c;

        /* renamed from: com.huawei.hms.network.embedded.l8$d$a */
        public class a extends C6011m8 {
            public a(InterfaceC6170yb interfaceC6170yb) {
                super(interfaceC6170yb);
            }

            @Override // com.huawei.hms.network.embedded.C6011m8
            /* renamed from: a */
            public void mo34694a(IOException iOException) {
                synchronized (C5998l8.this) {
                    d.this.m34700d();
                }
            }
        }

        public d(e eVar) {
            this.f27427a = eVar;
            this.f27428b = eVar.f27436e ? null : new boolean[C5998l8.this.f27407h];
        }

        /* renamed from: a */
        public InterfaceC6170yb m34695a(int i10) {
            synchronized (C5998l8.this) {
                try {
                    if (this.f27429c) {
                        throw new IllegalStateException();
                    }
                    e eVar = this.f27427a;
                    if (eVar.f27437f != this) {
                        return C6040ob.m34935a();
                    }
                    if (!eVar.f27436e) {
                        this.f27428b[i10] = true;
                    }
                    try {
                        return new a(C5998l8.this.f27400a.mo34142e(eVar.f27435d[i10]));
                    } catch (FileNotFoundException unused) {
                        return C6040ob.m34935a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: b */
        public InterfaceC6183zb m34697b(int i10) {
            synchronized (C5998l8.this) {
                try {
                    if (this.f27429c) {
                        throw new IllegalStateException();
                    }
                    e eVar = this.f27427a;
                    if (!eVar.f27436e || eVar.f27437f != this) {
                        return null;
                    }
                    try {
                        return C5998l8.this.f27400a.mo34140c(eVar.f27434c[i10]);
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: c */
        public void m34699c() throws IOException {
            synchronized (C5998l8.this) {
                try {
                    if (this.f27429c) {
                        throw new IllegalStateException();
                    }
                    if (this.f27427a.f27437f == this) {
                        C5998l8.this.m34680a(this, true);
                    }
                    this.f27429c = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: d */
        public void m34700d() {
            if (this.f27427a.f27437f != this) {
                return;
            }
            int i10 = 0;
            while (true) {
                C5998l8 c5998l8 = C5998l8.this;
                if (i10 >= c5998l8.f27407h) {
                    this.f27427a.f27437f = null;
                    return;
                } else {
                    try {
                        c5998l8.f27400a.mo34139b(this.f27427a.f27435d[i10]);
                    } catch (IOException unused) {
                    }
                    i10++;
                }
            }
        }

        /* renamed from: a */
        public void m34696a() throws IOException {
            synchronized (C5998l8.this) {
                try {
                    if (this.f27429c) {
                        throw new IllegalStateException();
                    }
                    if (this.f27427a.f27437f == this) {
                        C5998l8.this.m34680a(this, false);
                    }
                    this.f27429c = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: b */
        public void m34698b() {
            synchronized (C5998l8.this) {
                if (!this.f27429c && this.f27427a.f27437f == this) {
                    try {
                        C5998l8.this.m34680a(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l8$e */
    public final class e {

        /* renamed from: a */
        public final String f27432a;

        /* renamed from: b */
        public final long[] f27433b;

        /* renamed from: c */
        public final File[] f27434c;

        /* renamed from: d */
        public final File[] f27435d;

        /* renamed from: e */
        public boolean f27436e;

        /* renamed from: f */
        public d f27437f;

        /* renamed from: g */
        public long f27438g;

        public e(String str) {
            this.f27432a = str;
            int i10 = C5998l8.this.f27407h;
            this.f27433b = new long[i10];
            this.f27434c = new File[i10];
            this.f27435d = new File[i10];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < C5998l8.this.f27407h; i11++) {
                sb2.append(i11);
                this.f27434c[i11] = new File(C5998l8.this.f27401b, sb2.toString());
                sb2.append(".tmp");
                this.f27435d[i11] = new File(C5998l8.this.f27401b, sb2.toString());
                sb2.setLength(length);
            }
        }

        /* renamed from: b */
        private IOException m34701b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public f m34702a() throws IOException {
            InterfaceC6183zb interfaceC6183zb;
            if (!Thread.holdsLock(C5998l8.this)) {
                throw new AssertionError();
            }
            InterfaceC6183zb[] interfaceC6183zbArr = new InterfaceC6183zb[C5998l8.this.f27407h];
            long[] jArr = (long[]) this.f27433b.clone();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    C5998l8 c5998l8 = C5998l8.this;
                    if (i11 >= c5998l8.f27407h) {
                        return c5998l8.new f(this.f27432a, this.f27438g, interfaceC6183zbArr, jArr);
                    }
                    interfaceC6183zbArr[i11] = c5998l8.f27400a.mo34140c(this.f27434c[i11]);
                    i11++;
                } catch (FileNotFoundException unused) {
                    while (true) {
                        C5998l8 c5998l82 = C5998l8.this;
                        if (i10 >= c5998l82.f27407h || (interfaceC6183zb = interfaceC6183zbArr[i10]) == null) {
                            try {
                                c5998l82.m34681a(this);
                                return null;
                            } catch (IOException unused2) {
                                return null;
                            }
                        }
                        C5920f8.m34248a(interfaceC6183zb);
                        i10++;
                    }
                }
            }
        }

        /* renamed from: a */
        public void m34703a(InterfaceC5882cb interfaceC5882cb) throws IOException {
            for (long j10 : this.f27433b) {
                interfaceC5882cb.writeByte(32).mo33926a(j10);
            }
        }

        /* renamed from: a */
        public void m34704a(String[] strArr) throws IOException {
            if (strArr.length != C5998l8.this.f27407h) {
                throw m34701b(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f27433b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m34701b(strArr);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.l8$f */
    public final class f implements Closeable {

        /* renamed from: a */
        public final String f27440a;

        /* renamed from: b */
        public final long f27441b;

        /* renamed from: c */
        public final InterfaceC6183zb[] f27442c;

        /* renamed from: d */
        public final long[] f27443d;

        public f(String str, long j10, InterfaceC6183zb[] interfaceC6183zbArr, long[] jArr) {
            this.f27440a = str;
            this.f27441b = j10;
            this.f27442c = interfaceC6183zbArr;
            this.f27443d = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (InterfaceC6183zb interfaceC6183zb : this.f27442c) {
                C5920f8.m34248a(interfaceC6183zb);
            }
        }

        /* renamed from: d */
        public long m34706d(int i10) {
            return this.f27443d[i10];
        }

        /* renamed from: e */
        public InterfaceC6183zb m34707e(int i10) {
            return this.f27442c[i10];
        }

        /* renamed from: s */
        public d m34708s() throws IOException {
            return C5998l8.this.m34679a(this.f27440a, this.f27441b);
        }

        /* renamed from: t */
        public String m34709t() {
            return this.f27440a;
        }
    }

    public C5998l8(InterfaceC5909ea interfaceC5909ea, File file, int i10, int i11, long j10, Executor executor) {
        this.f27400a = interfaceC5909ea;
        this.f27401b = file;
        this.f27405f = i10;
        this.f27402c = new File(file, "journal");
        this.f27403d = new File(file, "journal.tmp");
        this.f27404e = new File(file, "journal.bkp");
        this.f27407h = i11;
        this.f27406g = j10;
        this.f27418s = executor;
    }

    /* renamed from: D */
    private synchronized void m34669D() {
        if (m34691x()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: E */
    private InterfaceC5882cb m34670E() throws FileNotFoundException {
        return C6040ob.m34933a(new b(this.f27400a.mo34144g(this.f27402c)));
    }

    /* renamed from: F */
    private void m34671F() throws IOException {
        this.f27400a.mo34139b(this.f27403d);
        Iterator<e> it = this.f27410k.values().iterator();
        while (it.hasNext()) {
            e next = it.next();
            int i10 = 0;
            if (next.f27437f == null) {
                while (i10 < this.f27407h) {
                    this.f27408i += next.f27433b[i10];
                    i10++;
                }
            } else {
                next.f27437f = null;
                while (i10 < this.f27407h) {
                    this.f27400a.mo34139b(next.f27434c[i10]);
                    this.f27400a.mo34139b(next.f27435d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* renamed from: G */
    private void m34672G() throws IOException {
        InterfaceC5896db interfaceC5896dbM34934a = C6040ob.m34934a(this.f27400a.mo34140c(this.f27402c));
        try {
            String strMo33978n = interfaceC5896dbM34934a.mo33978n();
            String strMo33978n2 = interfaceC5896dbM34934a.mo33978n();
            String strMo33978n3 = interfaceC5896dbM34934a.mo33978n();
            String strMo33978n4 = interfaceC5896dbM34934a.mo33978n();
            String strMo33978n5 = interfaceC5896dbM34934a.mo33978n();
            if (!"libcore.io.DiskLruCache".equals(strMo33978n) || !"1".equals(strMo33978n2) || !Integer.toString(this.f27405f).equals(strMo33978n3) || !Integer.toString(this.f27407h).equals(strMo33978n4) || !"".equals(strMo33978n5)) {
                throw new IOException("unexpected journal header: [" + strMo33978n + ", " + strMo33978n2 + ", " + strMo33978n4 + ", " + strMo33978n5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    m34674e(interfaceC5896dbM34934a.mo33978n());
                    i10++;
                } catch (EOFException unused) {
                    this.f27411l = i10 - this.f27410k.size();
                    if (interfaceC5896dbM34934a.mo33971i()) {
                        this.f27409j = m34670E();
                    } else {
                        m34693z();
                    }
                    interfaceC5896dbM34934a.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            if (interfaceC5896dbM34934a != null) {
                try {
                    interfaceC5896dbM34934a.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    /* renamed from: e */
    private void m34674e(String str) throws IOException {
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
                this.f27410k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        e eVar = this.f27410k.get(strSubstring);
        if (eVar == null) {
            eVar = new e(strSubstring);
            this.f27410k.put(strSubstring, eVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            eVar.f27436e = true;
            eVar.f27437f = null;
            eVar.m34704a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            eVar.f27437f = new d(eVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* renamed from: f */
    private void m34675f(String str) {
        if (f27388A.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* renamed from: A */
    public synchronized long m34676A() throws IOException {
        m34690w();
        return this.f27408i;
    }

    /* renamed from: B */
    public synchronized Iterator<f> m34677B() throws IOException {
        m34690w();
        return new c();
    }

    /* renamed from: C */
    public void m34678C() throws IOException {
        while (this.f27408i > this.f27406g) {
            m34681a(this.f27410k.values().iterator().next());
        }
        this.f27415p = false;
    }

    /* renamed from: a */
    public synchronized d m34679a(String str, long j10) throws IOException {
        m34690w();
        m34669D();
        m34675f(str);
        e eVar = this.f27410k.get(str);
        if (j10 != -1 && (eVar == null || eVar.f27438g != j10)) {
            return null;
        }
        if (eVar != null && eVar.f27437f != null) {
            return null;
        }
        if (!this.f27415p && !this.f27416q) {
            this.f27409j.mo33934a("DIRTY").writeByte(32).mo33934a(str).writeByte(10);
            this.f27409j.flush();
            if (this.f27412m) {
                return null;
            }
            if (eVar == null) {
                eVar = new e(str);
                this.f27410k.put(str, eVar);
            }
            d dVar = new d(eVar);
            eVar.f27437f = dVar;
            return dVar;
        }
        this.f27418s.execute(this.f27419t);
        return null;
    }

    /* renamed from: b */
    public d m34682b(String str) throws IOException {
        return m34679a(str, -1L);
    }

    /* renamed from: c */
    public synchronized f m34683c(String str) throws IOException {
        m34690w();
        m34669D();
        m34675f(str);
        e eVar = this.f27410k.get(str);
        if (eVar != null && eVar.f27436e) {
            f fVarM34702a = eVar.m34702a();
            if (fVarM34702a == null) {
                return null;
            }
            this.f27411l++;
            this.f27409j.mo33934a("READ").writeByte(32).mo33934a(str).writeByte(10);
            if (m34692y()) {
                this.f27418s.execute(this.f27419t);
            }
            return fVarM34702a;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        try {
            if (this.f27413n && !this.f27414o) {
                for (e eVar : (e[]) this.f27410k.values().toArray(new e[this.f27410k.size()])) {
                    d dVar = eVar.f27437f;
                    if (dVar != null) {
                        dVar.m34696a();
                    }
                }
                m34678C();
                this.f27409j.close();
                this.f27409j = null;
                this.f27414o = true;
                return;
            }
            this.f27414o = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: d */
    public synchronized boolean m34684d(String str) throws IOException {
        m34690w();
        m34669D();
        m34675f(str);
        e eVar = this.f27410k.get(str);
        if (eVar == null) {
            return false;
        }
        boolean zM34681a = m34681a(eVar);
        if (zM34681a && this.f27408i <= this.f27406g) {
            this.f27415p = false;
        }
        return zM34681a;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f27413n) {
            m34669D();
            m34678C();
            this.f27409j.flush();
        }
    }

    /* renamed from: j */
    public synchronized void m34685j(long j10) {
        this.f27406g = j10;
        if (this.f27413n) {
            this.f27418s.execute(this.f27419t);
        }
    }

    /* renamed from: s */
    public void m34686s() throws IOException {
        close();
        this.f27400a.mo34143f(this.f27401b);
    }

    /* renamed from: t */
    public synchronized void m34687t() throws IOException {
        try {
            m34690w();
            for (e eVar : (e[]) this.f27410k.values().toArray(new e[this.f27410k.size()])) {
                m34681a(eVar);
            }
            this.f27415p = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: u */
    public File m34688u() {
        return this.f27401b;
    }

    /* renamed from: v */
    public synchronized long m34689v() {
        return this.f27406g;
    }

    /* renamed from: w */
    public synchronized void m34690w() throws IOException {
        try {
            if (!f27393F && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (this.f27413n) {
                return;
            }
            if (this.f27400a.mo34138a(this.f27404e)) {
                if (this.f27400a.mo34138a(this.f27402c)) {
                    this.f27400a.mo34139b(this.f27404e);
                } else {
                    this.f27400a.mo34137a(this.f27404e, this.f27402c);
                }
            }
            if (this.f27400a.mo34138a(this.f27402c)) {
                try {
                    m34672G();
                    m34671F();
                    this.f27413n = true;
                    return;
                } catch (IOException e10) {
                    C6013ma.m34863f().mo34331a(5, "DiskLruCache " + this.f27401b + " is corrupt: " + e10.getMessage() + ", removing", e10);
                    try {
                        m34686s();
                        this.f27414o = false;
                    } catch (Throwable th2) {
                        this.f27414o = false;
                        throw th2;
                    }
                }
            }
            m34693z();
            this.f27413n = true;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    /* renamed from: x */
    public synchronized boolean m34691x() {
        return this.f27414o;
    }

    /* renamed from: y */
    public boolean m34692y() {
        int i10 = this.f27411l;
        return i10 >= 2000 && i10 >= this.f27410k.size();
    }

    /* renamed from: z */
    public synchronized void m34693z() throws IOException {
        try {
            InterfaceC5882cb interfaceC5882cb = this.f27409j;
            if (interfaceC5882cb != null) {
                interfaceC5882cb.close();
            }
            InterfaceC5882cb interfaceC5882cbM34933a = C6040ob.m34933a(this.f27400a.mo34142e(this.f27403d));
            try {
                interfaceC5882cbM34933a.mo33934a("libcore.io.DiskLruCache").writeByte(10);
                interfaceC5882cbM34933a.mo33934a("1").writeByte(10);
                interfaceC5882cbM34933a.mo33926a(this.f27405f).writeByte(10);
                interfaceC5882cbM34933a.mo33926a(this.f27407h).writeByte(10);
                interfaceC5882cbM34933a.writeByte(10);
                for (e eVar : this.f27410k.values()) {
                    if (eVar.f27437f != null) {
                        interfaceC5882cbM34933a.mo33934a("DIRTY").writeByte(32);
                        interfaceC5882cbM34933a.mo33934a(eVar.f27432a);
                    } else {
                        interfaceC5882cbM34933a.mo33934a("CLEAN").writeByte(32);
                        interfaceC5882cbM34933a.mo33934a(eVar.f27432a);
                        eVar.m34703a(interfaceC5882cbM34933a);
                    }
                    interfaceC5882cbM34933a.writeByte(10);
                }
                interfaceC5882cbM34933a.close();
                if (this.f27400a.mo34138a(this.f27402c)) {
                    this.f27400a.mo34137a(this.f27402c, this.f27404e);
                }
                this.f27400a.mo34137a(this.f27403d, this.f27402c);
                this.f27400a.mo34139b(this.f27404e);
                this.f27409j = m34670E();
                this.f27412m = false;
                this.f27416q = false;
            } finally {
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public static C5998l8 m34673a(InterfaceC5909ea interfaceC5909ea, File file, int i10, int i11, long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 > 0) {
            return new C5998l8(interfaceC5909ea, file, i10, i11, j10, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C5920f8.m34245a("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    /* renamed from: a */
    public synchronized void m34680a(d dVar, boolean z10) throws IOException {
        e eVar = dVar.f27427a;
        if (eVar.f27437f != dVar) {
            throw new IllegalStateException();
        }
        if (z10 && !eVar.f27436e) {
            for (int i10 = 0; i10 < this.f27407h; i10++) {
                if (!dVar.f27428b[i10]) {
                    dVar.m34696a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!this.f27400a.mo34138a(eVar.f27435d[i10])) {
                    dVar.m34696a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f27407h; i11++) {
            File file = eVar.f27435d[i11];
            if (!z10) {
                this.f27400a.mo34139b(file);
            } else if (this.f27400a.mo34138a(file)) {
                File file2 = eVar.f27434c[i11];
                this.f27400a.mo34137a(file, file2);
                long j10 = eVar.f27433b[i11];
                long jMo34141d = this.f27400a.mo34141d(file2);
                eVar.f27433b[i11] = jMo34141d;
                this.f27408i = (this.f27408i - j10) + jMo34141d;
            }
        }
        this.f27411l++;
        eVar.f27437f = null;
        if (eVar.f27436e || z10) {
            eVar.f27436e = true;
            this.f27409j.mo33934a("CLEAN").writeByte(32);
            this.f27409j.mo33934a(eVar.f27432a);
            eVar.m34703a(this.f27409j);
            this.f27409j.writeByte(10);
            if (z10) {
                long j11 = this.f27417r;
                this.f27417r = 1 + j11;
                eVar.f27438g = j11;
            }
        } else {
            this.f27410k.remove(eVar.f27432a);
            this.f27409j.mo33934a("REMOVE").writeByte(32);
            this.f27409j.mo33934a(eVar.f27432a);
            this.f27409j.writeByte(10);
        }
        this.f27409j.flush();
        if (this.f27408i > this.f27406g || m34692y()) {
            this.f27418s.execute(this.f27419t);
        }
    }

    /* renamed from: a */
    public boolean m34681a(e eVar) throws IOException {
        d dVar = eVar.f27437f;
        if (dVar != null) {
            dVar.m34700d();
        }
        for (int i10 = 0; i10 < this.f27407h; i10++) {
            this.f27400a.mo34139b(eVar.f27434c[i10]);
            long j10 = this.f27408i;
            long[] jArr = eVar.f27433b;
            this.f27408i = j10 - jArr[i10];
            jArr[i10] = 0;
        }
        this.f27411l++;
        this.f27409j.mo33934a("REMOVE").writeByte(32).mo33934a(eVar.f27432a).writeByte(10);
        this.f27410k.remove(eVar.f27432a);
        if (m34692y()) {
            this.f27418s.execute(this.f27419t);
        }
        return true;
    }
}
