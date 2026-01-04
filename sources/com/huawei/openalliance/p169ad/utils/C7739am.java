package com.huawei.openalliance.p169ad.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7688tj;
import com.huawei.openalliance.p169ad.C7689tk;
import com.huawei.openalliance.p169ad.C7692tn;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.am */
/* loaded from: classes2.dex */
public class C7739am {
    /* renamed from: a */
    public static String m47522a() {
        return "harmonyos,android";
    }

    /* renamed from: b */
    public static Integer m47529b(Context context) {
        String strM48289a = AbstractC7811dd.m48289a(SystemProperties.HW_SC_BUILD_OS_API_VERSION);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("HarmonyUtils", "hmSdkInt: %s", strM48289a);
        }
        return AbstractC7806cz.m48178h(strM48289a);
    }

    /* renamed from: a */
    private static boolean m47523a(int i10) {
        return (i10 & ARImageMetadata.SHADING_MODE) != 0;
    }

    /* renamed from: b */
    public static boolean m47530b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            boolean zM47523a = m47523a(new C7689tk().m47254a(C7830i.m48432d(context.getApplicationContext(), str), context));
            AbstractC7185ho.m43821b("HarmonyUtils", "isHarmonyApp: %s", Boolean.valueOf(zM47523a));
            return zM47523a;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HarmonyUtils", "isHarmonyApp exception");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m47524a(Context context) {
        String strM48289a = AbstractC7811dd.m48289a(SystemProperties.HW_SC_BUILD_OS_ENABLE);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("HarmonyUtils", "hmftype: %s", strM48289a);
        }
        return Boolean.parseBoolean(strM48289a);
    }

    /* renamed from: a */
    public static boolean m47525a(Context context, AppInfo appInfo, String str, ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("HarmonyUtils", "openHarmonyApp intent");
        boolean z10 = false;
        if (appInfo == null) {
            return false;
        }
        if (!TextUtils.isEmpty(appInfo.m44340A())) {
            try {
                String strM44340A = appInfo.m44340A();
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(str, strM44340A));
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                new C7688tj().m47252a(context, intent);
                z10 = true;
            } catch (Throwable unused) {
                AbstractC7185ho.m43823c("HarmonyUtils", "handle harmony intent url fail");
            }
        }
        if (z10 || TextUtils.isEmpty(appInfo.getIntentUri())) {
            return z10;
        }
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47275a(appInfo).m47274a(contentRecord).m47279c(str);
        return C7830i.m48421a(context, str, appInfo.getIntentUri(), aVar.m47277a());
    }

    /* renamed from: a */
    public static boolean m47526a(Context context, String str) {
        try {
            if (C7830i.m48419a(context.getApplicationContext(), str)) {
                return true;
            }
            return !AbstractC7760bg.m47767a(new C7688tj().m47251a(str));
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HarmonyUtils", "check app installed fail");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m47527a(Context context, String str, ContentRecord contentRecord) {
        boolean zM48420a;
        AbstractC7185ho.m43820b("HarmonyUtils", "open harmony app main page");
        C7692tn.a aVar = new C7692tn.a();
        aVar.m47279c(str).m47274a(contentRecord);
        boolean z10 = false;
        try {
            zM48420a = C7830i.m48420a(context, str, aVar.m47277a());
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HarmonyUtils", "open app main page fail");
            zM48420a = false;
        }
        if (zM48420a) {
            return true;
        }
        try {
            C7688tj c7688tj = new C7688tj();
            List<Intent> listM47251a = c7688tj.m47251a(str);
            if (!AbstractC7760bg.m47767a(listM47251a)) {
                Intent intent = listM47251a.get(0);
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                c7688tj.m47252a(context, intent);
                z10 = true;
            }
            return z10;
        } catch (Throwable unused2) {
            AbstractC7185ho.m43823c("HarmonyUtils", "open harmony app main page fail");
            return zM48420a;
        }
    }

    /* renamed from: a */
    public static boolean m47528a(Context context, String str, String str2) {
        try {
            new C7688tj().m47253a(context, str, str2);
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HarmonyUtils", "handle harmony intent url fail");
            return false;
        }
    }
}
