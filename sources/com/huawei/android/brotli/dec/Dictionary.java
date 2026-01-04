package com.huawei.android.brotli.dec;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Dictionary {
    private static volatile ByteBuffer data;

    /* renamed from: com.huawei.android.brotli.dec.Dictionary$a */
    public static class C2160a {

        /* renamed from: a */
        public static final boolean f9781a;

        static {
            boolean z10;
            try {
                Class.forName(Dictionary.class.getPackage().getName() + ".DictionaryData");
                z10 = true;
            } catch (Throwable unused) {
                z10 = false;
            }
            f9781a = z10;
        }
    }

    public static ByteBuffer getData() {
        if (data == null && !C2160a.f9781a) {
            throw new C2163c("brotli dictionary is not set");
        }
        return data;
    }

    public static void setData(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect() || !byteBuffer.isReadOnly()) {
            throw new C2163c("data must be a direct read-only byte buffer");
        }
        data = byteBuffer;
    }
}
