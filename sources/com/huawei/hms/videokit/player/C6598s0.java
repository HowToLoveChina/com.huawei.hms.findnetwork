package com.huawei.hms.videokit.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeString;
import java.util.UUID;

/* renamed from: com.huawei.hms.videokit.player.s0 */
/* loaded from: classes8.dex */
public class C6598s0 {

    /* renamed from: a */
    private static String f30671a;

    /* renamed from: b */
    private static int f30672b = C6600t0.m37664a(0, Constants.MILLON);

    /* renamed from: a */
    public static String m37644a(Context context) {
        String string = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(string) ? string.replaceAll("-", "") : "";
    }

    /* renamed from: b */
    public static String m37645b(Context context) {
        try {
            if (f30671a == null) {
                f30671a = m37646c(context);
            }
            int i10 = f30672b;
            if (i10 >= 999999) {
                f30672b = 0;
            } else {
                f30672b = i10 + 1;
            }
            C6550c1.m37256a("TraceIdUtil", "TRACE_ID:" + f30671a + " SERIAL_NUMBER:" + f30672b);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f30671a);
            sb2.append(C6600t0.m37675a("%06d", Integer.valueOf(f30672b)));
            return sb2.toString();
        } catch (Exception e10) {
            C6550c1.m37258a("TraceIdUtil", "getTraceId e:", e10);
            return null;
        }
    }

    /* renamed from: c */
    public static String m37646c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("video_kit", 0);
            String string = sharedPreferences.getString("video_kit_uuid", null);
            if (string == null) {
                string = SafeString.replace(UUID.randomUUID().toString(), "-", "");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("video_kit_uuid", string);
                editorEdit.commit();
            }
            C6550c1.m37256a("TraceIdUtil", "UUID:" + string);
            return string;
        } catch (Exception e10) {
            C6550c1.m37258a("TraceIdUtil", "getUUID fail e:", e10);
            return null;
        }
    }
}
