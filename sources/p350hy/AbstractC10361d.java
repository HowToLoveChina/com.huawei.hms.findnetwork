package p350hy;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.function.Predicate;
import my.C11558a;

/* renamed from: hy.d */
/* loaded from: classes9.dex */
public abstract class AbstractC10361d {

    /* renamed from: a */
    public static final InterfaceC10359b f50104a = m63786c(StandardCharsets.UTF_8);

    /* renamed from: b */
    public static InterfaceC10359b m63785b(String str) {
        return new C10358a(m63792i(str), m63788e(m63792i(str).name()));
    }

    /* renamed from: c */
    public static InterfaceC10359b m63786c(Charset charset) {
        return new C10358a(C11558a.m69018c(charset), m63789f(C11558a.m69018c(charset)));
    }

    /* renamed from: d */
    public static ByteBuffer m63787d(ByteBuffer byteBuffer, int i10) {
        byteBuffer.limit(byteBuffer.position());
        byteBuffer.rewind();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity() + i10);
        byteBufferAllocate.put(byteBuffer);
        return byteBufferAllocate;
    }

    /* renamed from: e */
    public static boolean m63788e(String str) {
        if (str == null) {
            str = Charset.defaultCharset().name();
        }
        return m63790g(str);
    }

    /* renamed from: f */
    public static boolean m63789f(Charset charset) {
        return m63790g(C11558a.m69018c(charset).name());
    }

    /* renamed from: g */
    public static boolean m63790g(final String str) {
        Charset charset = StandardCharsets.UTF_8;
        return charset.name().equalsIgnoreCase(str) || charset.aliases().stream().anyMatch(new Predicate() { // from class: hy.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return AbstractC10361d.m63791h(str, (String) obj);
            }
        });
    }

    /* renamed from: h */
    public static /* synthetic */ boolean m63791h(String str, String str2) {
        return str2.equalsIgnoreCase(str);
    }

    /* renamed from: i */
    public static Charset m63792i(String str) {
        Charset charsetDefaultCharset = Charset.defaultCharset();
        try {
            return C11558a.m69016a(str);
        } catch (UnsupportedCharsetException unused) {
            return charsetDefaultCharset;
        }
    }
}
