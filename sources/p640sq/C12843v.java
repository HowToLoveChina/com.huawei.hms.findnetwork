package p640sq;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.util.UUID;
import p530oq.C11990c;

/* renamed from: sq.v */
/* loaded from: classes8.dex */
public class C12843v {

    /* renamed from: a */
    public static String f58582a = "";

    /* renamed from: a */
    public static String m77124a() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    /* renamed from: b */
    public static String m77125b(Context context) {
        String string;
        try {
            string = Settings.Global.getString(context.getContentResolver(), "unified_device_name");
        } catch (Throwable th2) {
            C12836o.m77098c("TerminalInfo", "Settings.Global Exception = " + th2.getClass().getSimpleName(), true);
            string = null;
        }
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string.trim())) {
            return string;
        }
        String strM76992N = C12824c.m76992N();
        if (!TextUtils.isEmpty(strM76992N)) {
            return strM76992N;
        }
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    /* renamed from: c */
    public static String m77126c() {
        if (TextUtils.isEmpty(f58582a)) {
            String string = UUID.randomUUID().toString();
            f58582a = string;
            if (TextUtils.isEmpty(string)) {
                return "NULL";
            }
        }
        return f58582a;
    }

    /* renamed from: d */
    public static String m77127d(Context context) {
        C12836o.m77097b("TerminalInfo", "generateUuid start.", true);
        String strM72136c = C11990c.m72144k(context).m72136c("UUID", "");
        if (!TextUtils.isEmpty(strM72136c)) {
            return !"{{001}}".equalsIgnoreCase(SafeString.substring(strM72136c, 0, 7)) ? m77128e(context) : SafeString.substring(strM72136c, 7);
        }
        C12836o.m77097b("TerminalInfo", "deviceId is null.", true);
        return m77128e(context);
    }

    /* renamed from: e */
    public static String m77128e(Context context) {
        String str;
        String strM77126c = m77126c();
        if ("NULL".equalsIgnoreCase(strM77126c)) {
            str = strM77126c;
        } else {
            str = "{{001}}" + strM77126c;
        }
        C11990c.m72144k(context).m72142i("UUID", str);
        return strM77126c;
    }
}
