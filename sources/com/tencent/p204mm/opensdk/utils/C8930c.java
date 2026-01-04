package com.tencent.p204mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: com.tencent.mm.opensdk.utils.c */
/* loaded from: classes9.dex */
public final class C8930c {

    /* renamed from: com.tencent.mm.opensdk.utils.c$a */
    public static final class a {
        /* renamed from: a */
        public static Object m56646a(int i10, String str) {
            try {
                switch (i10) {
                    case 1:
                        return Integer.valueOf(str);
                    case 2:
                        return Long.valueOf(str);
                    case 3:
                        return str;
                    case 4:
                        return Boolean.valueOf(str);
                    case 5:
                        return Float.valueOf(str);
                    case 6:
                        return Double.valueOf(str);
                    default:
                        Log.m56639e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                        return null;
                }
            } catch (Exception e10) {
                Log.m56639e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e10.getMessage());
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.opensdk.utils.c$b */
    public static final class b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
