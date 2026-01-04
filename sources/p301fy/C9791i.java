package p301fy;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import ky.C11201a;
import p351hz.AbstractC10369h;
import p351hz.C10362a;
import p351hz.C10363b;
import p351hz.C10370i;
import p351hz.C10374m;
import p351hz.C10375n;
import p351hz.C10378q;
import p410jy.C10959a;

/* renamed from: fy.i */
/* loaded from: classes9.dex */
public final class C9791i {

    /* renamed from: a */
    public static final Map<EnumC9804v, AbstractC9786d> f48140a = new a();

    /* renamed from: fy.i$a */
    public class a extends HashMap<EnumC9804v, AbstractC9786d> {
        private static final long serialVersionUID = 1664829131806520867L;

        public a() {
            put(EnumC9804v.COPY, new d());
            put(EnumC9804v.LZMA, new C9795m());
            put(EnumC9804v.LZMA2, new C9794l());
            put(EnumC9804v.DEFLATE, new f());
            put(EnumC9804v.DEFLATE64, new e());
            put(EnumC9804v.BZIP2, new c());
            put(EnumC9804v.AES256SHA256, new C9784b());
            put(EnumC9804v.BCJ_X86_FILTER, new b(new C10378q()));
            put(EnumC9804v.BCJ_PPC_FILTER, new b(new C10374m()));
            put(EnumC9804v.BCJ_IA64_FILTER, new b(new C10370i()));
            put(EnumC9804v.BCJ_ARM_FILTER, new b(new C10362a()));
            put(EnumC9804v.BCJ_ARM_THUMB_FILTER, new b(new C10363b()));
            put(EnumC9804v.BCJ_SPARC_FILTER, new b(new C10375n()));
            put(EnumC9804v.DELTA_FILTER, new C9792j());
        }
    }

    /* renamed from: fy.i$b */
    public static class b extends AbstractC9786d {

        /* renamed from: b */
        public final AbstractC10369h f48141b;

        public b(AbstractC10369h abstractC10369h) {
            super(new Class[0]);
            this.f48141b = abstractC10369h;
        }

        @Override // p301fy.AbstractC9786d
        /* renamed from: b */
        public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
            try {
                return this.f48141b.m63798a(inputStream);
            } catch (AssertionError e10) {
                throw new IOException("BCJ filter used in " + str + " needs XZ for Java > 1.4 - see https://commons.apache.org/proper/commons-compress/limitations.html#7Z", e10);
            }
        }
    }

    /* renamed from: fy.i$c */
    public static class c extends AbstractC9786d {
        public c() {
            super(Number.class);
        }

        @Override // p301fy.AbstractC9786d
        /* renamed from: b */
        public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
            return new C10959a(inputStream);
        }
    }

    /* renamed from: fy.i$d */
    public static class d extends AbstractC9786d {
        public d() {
            super(new Class[0]);
        }

        @Override // p301fy.AbstractC9786d
        /* renamed from: b */
        public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
            return inputStream;
        }
    }

    /* renamed from: fy.i$e */
    public static class e extends AbstractC9786d {
        public e() {
            super(Number.class);
        }

        @Override // p301fy.AbstractC9786d
        /* renamed from: b */
        public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
            return new C11201a(inputStream);
        }
    }

    /* renamed from: fy.i$f */
    public static class f extends AbstractC9786d {

        /* renamed from: b */
        public static final byte[] f48142b = new byte[1];

        /* renamed from: fy.i$f$a */
        public static class a extends FilterInputStream {

            /* renamed from: a */
            public Inflater f48143a;

            public a(InflaterInputStream inflaterInputStream, Inflater inflater) {
                super(inflaterInputStream);
                this.f48143a = inflater;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    super.close();
                } finally {
                    this.f48143a.end();
                }
            }
        }

        public f() {
            super(Number.class);
        }

        @Override // p301fy.AbstractC9786d
        /* renamed from: b */
        public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
            Inflater inflater = new Inflater(true);
            return new a(new InflaterInputStream(new SequenceInputStream(inputStream, new ByteArrayInputStream(f48142b)), inflater), inflater);
        }
    }

    /* renamed from: a */
    public static InputStream m60867a(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
        AbstractC9786d abstractC9786dM60868b = m60868b(EnumC9804v.m60983e(c9790h.f48136a));
        if (abstractC9786dM60868b != null) {
            return abstractC9786dM60868b.mo60858b(str, inputStream, j10, c9790h, bArr, i10);
        }
        throw new IOException("Unsupported compression method " + Arrays.toString(c9790h.f48136a) + " used in " + str);
    }

    /* renamed from: b */
    public static AbstractC9786d m60868b(EnumC9804v enumC9804v) {
        return f48140a.get(enumC9804v);
    }
}
