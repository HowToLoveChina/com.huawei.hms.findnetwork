package my;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: my.a */
/* loaded from: classes9.dex */
public class C11558a {

    /* renamed from: a */
    public static final SortedMap<String, Charset> f53600a;

    /* renamed from: b */
    @Deprecated
    public static final Charset f53601b;

    /* renamed from: c */
    @Deprecated
    public static final Charset f53602c;

    /* renamed from: d */
    @Deprecated
    public static final Charset f53603d;

    /* renamed from: e */
    @Deprecated
    public static final Charset f53604e;

    /* renamed from: f */
    @Deprecated
    public static final Charset f53605f;

    /* renamed from: g */
    @Deprecated
    public static final Charset f53606g;

    static {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Charset charset = StandardCharsets.ISO_8859_1;
        treeMap.put(charset.name(), charset);
        Charset charset2 = StandardCharsets.US_ASCII;
        treeMap.put(charset2.name(), charset2);
        Charset charset3 = StandardCharsets.UTF_16;
        treeMap.put(charset3.name(), charset3);
        Charset charset4 = StandardCharsets.UTF_16BE;
        treeMap.put(charset4.name(), charset4);
        Charset charset5 = StandardCharsets.UTF_16LE;
        treeMap.put(charset5.name(), charset5);
        Charset charset6 = StandardCharsets.UTF_8;
        treeMap.put(charset6.name(), charset6);
        f53600a = Collections.unmodifiableSortedMap(treeMap);
        f53601b = charset;
        f53602c = charset2;
        f53603d = charset3;
        f53604e = charset4;
        f53605f = charset5;
        f53606g = charset6;
    }

    /* renamed from: a */
    public static Charset m69016a(String str) throws UnsupportedCharsetException {
        return m69017b(str, Charset.defaultCharset());
    }

    /* renamed from: b */
    public static Charset m69017b(String str, Charset charset) throws UnsupportedCharsetException {
        return str == null ? charset : Charset.forName(str);
    }

    /* renamed from: c */
    public static Charset m69018c(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
