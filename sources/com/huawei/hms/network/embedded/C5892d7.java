package com.huawei.hms.network.embedded;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* renamed from: com.huawei.hms.network.embedded.d7 */
/* loaded from: classes8.dex */
public final class C5892d7 {
    /* renamed from: a */
    public static String m34104a(String str, String str2) {
        return m34105a(str, str2, StandardCharsets.ISO_8859_1);
    }

    /* renamed from: a */
    public static String m34105a(String str, String str2, Charset charset) {
        return "Basic " + C5910eb.m34150a(str + ":" + str2, charset).mo34175b();
    }
}
