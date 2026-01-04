package je;

import android.content.Context;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import com.tencent.p204mm.opensdk.openapi.WXAPIFactory;
import p514o9.C11839m;

/* renamed from: je.v */
/* loaded from: classes3.dex */
public class C10808v {

    /* renamed from: a */
    public static volatile IWXAPI f51585a;

    /* renamed from: a */
    public static synchronized void m65794a() {
        if (f51585a == null) {
            return;
        }
        try {
            f51585a.unregisterApp();
            f51585a = null;
        } catch (Exception unused) {
            C11839m.m70687e("Share2WeChat", "unregisterApp fail exception");
        }
    }

    /* renamed from: b */
    public static synchronized IWXAPI m65795b() {
        return f51585a;
    }

    /* renamed from: c */
    public static synchronized void m65796c(Context context, String str) {
        if (f51585a == null) {
            f51585a = WXAPIFactory.createWXAPI(context, str, true);
            f51585a.registerApp(str);
        }
    }
}
