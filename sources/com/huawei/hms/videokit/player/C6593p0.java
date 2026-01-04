package com.huawei.hms.videokit.player;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: com.huawei.hms.videokit.player.p0 */
/* loaded from: classes8.dex */
public final class C6593p0 {

    /* renamed from: a */
    private static final HashSet<String> f30661a = new HashSet<>(Arrays.asList(".m3u8", ".mp4", ".mpd", ".m3u", ".flv"));

    /* renamed from: a */
    public static EnumC6602u0 m37593a(String str) {
        if (TextUtils.isEmpty(str)) {
            return EnumC6602u0.UNKNOWN;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        C6550c1.m37256a("StringUtils", "getVideoType: url = " + lowerCase);
        if (lowerCase.isEmpty()) {
            return EnumC6602u0.UNKNOWN;
        }
        if (lowerCase.contains(Constants.QUESTION_STR)) {
            lowerCase = SafeString.substring(lowerCase, 0, lowerCase.indexOf(Constants.QUESTION_STR));
            C6550c1.m37256a("StringUtils", "substring(?) url = " + lowerCase);
        }
        if (!lowerCase.startsWith("http") && !lowerCase.startsWith("https")) {
            return lowerCase.startsWith("offline://") ? EnumC6602u0.OFFLINE : EnumC6602u0.UNKNOWN;
        }
        C6550c1.m37256a("StringUtils", "start with http");
        if (lowerCase.endsWith(".mp4")) {
            return EnumC6602u0.MP4;
        }
        if (lowerCase.endsWith(".m3u8")) {
            return EnumC6602u0.HLS;
        }
        if (lowerCase.endsWith(".mpd")) {
            return EnumC6602u0.DASH;
        }
        if (!lowerCase.endsWith(".flv")) {
            return EnumC6602u0.UNKNOWN;
        }
        C6550c1.m37256a("StringUtils", "end with flv");
        return EnumC6602u0.FLV;
    }

    /* renamed from: b */
    public static boolean m37595b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (!lowerCase.startsWith("http") && !lowerCase.startsWith("https")) {
            return false;
        }
        if (lowerCase.contains(Constants.QUESTION_STR)) {
            lowerCase = SafeString.substring(lowerCase, 0, lowerCase.indexOf(Constants.QUESTION_STR));
        }
        String[] strArrSplit = lowerCase.split("/");
        String str2 = strArrSplit[strArrSplit.length - 1];
        C6550c1.m37256a("StringUtils", "current play url last parameter is " + str2);
        if (!str2.contains(".")) {
            return true;
        }
        String strSubstring = SafeString.substring(str2, str2.lastIndexOf("."));
        return strSubstring.length() < 1 || f30661a.contains(strSubstring);
    }

    /* renamed from: a */
    public static String m37594a(Context context, String str) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        AssetManager assets = context.getAssets();
        if (assets != null) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assets.open(str), "utf-8"));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                        } catch (IOException unused) {
                            bufferedReader = bufferedReader2;
                            C6550c1.m37262b("StringUtils", "getJson fail");
                            C6563i0.m37397a(bufferedReader);
                            return sb2.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C6563i0.m37397a(bufferedReader);
                            throw th;
                        }
                    }
                    C6563i0.m37397a(bufferedReader2);
                } catch (IOException unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return sb2.toString();
    }
}
