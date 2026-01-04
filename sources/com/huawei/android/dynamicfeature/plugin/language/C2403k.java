package com.huawei.android.dynamicfeature.plugin.language;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import p250e7.C9419a;
import p250e7.C9420b;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.k */
/* loaded from: classes2.dex */
public class C2403k {

    /* renamed from: a */
    public static final String f11487a = "k";

    /* renamed from: b */
    public static String f11488b = "nopress";

    /* renamed from: c */
    public static String f11489c = "false";

    /* JADX WARN: Removed duplicated region for block: B:69:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[Catch: IOException -> 0x0047, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0047, blocks: (B:3:0x000b, B:23:0x0041, B:24:0x0043, B:19:0x0037, B:52:0x0083, B:51:0x007e, B:46:0x0072, B:41:0x006a, B:36:0x005e, B:38:0x0065, B:16:0x0032, B:43:0x006d, B:20:0x003c, B:33:0x0059, B:48:0x0079), top: B:64:0x000b, inners: #0, #2, #3, #6, #8, #9 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m15006a(android.content.Context r8, java.io.File r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.dynamicfeature.plugin.language.C2403k.m15006a(android.content.Context, java.io.File, java.lang.String):void");
    }

    /* renamed from: b */
    public static void m15007b(Context context) {
        m15010e(context);
        if (!f11488b.equals("single-lang")) {
            C9419a.m59080f(f11487a, "means that not use brotli single-lang press");
            return;
        }
        C2398f c2398fM14996d = C2398f.m14996d(context, "hw");
        try {
            String[] list = context.getAssets().list("langs");
            if (list == null || list.length <= 0) {
                return;
            }
            for (String str : list) {
                C9419a.m59080f(f11487a, "langsFile:" + str);
                if (!TextUtils.isEmpty(str) && str.endsWith("langs.br")) {
                    File file = new File(c2398fM14996d.m14999f(), str.substring(0, str.indexOf("langs.br")) + "decompressed-langs.zip");
                    if (!file.exists()) {
                        m15006a(context, file, "langs" + File.separator + str);
                    }
                }
            }
        } catch (IOException unused) {
            C9419a.m59077c(f11487a, "decompress langs.br failed");
        }
    }

    /* renamed from: c */
    public static String m15008c() {
        return f11488b;
    }

    /* renamed from: d */
    public static String m15009d() {
        return f11489c;
    }

    /* renamed from: e */
    public static void m15010e(Context context) {
        Bundle bundleM59089c = C9420b.m59089c(context);
        String string = bundleM59089c != null ? bundleM59089c.getString("brotlipress") : "nopress";
        f11488b = string != null ? string : "nopress";
        String string2 = bundleM59089c != null ? bundleM59089c.getString("compress_by_region") : "false";
        f11489c = string2 != null ? string2 : "false";
    }
}
