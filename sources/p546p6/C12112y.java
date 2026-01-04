package p546p6;

import android.content.Context;
import com.tencent.p204mm.opensdk.openapi.IWXAPI;
import com.tencent.p204mm.opensdk.openapi.WXAPIFactory;

/* renamed from: p6.y */
/* loaded from: classes2.dex */
public class C12112y {

    /* renamed from: a */
    public static volatile IWXAPI f56174a;

    /* renamed from: a */
    public static synchronized IWXAPI m72546a() {
        return f56174a;
    }

    /* renamed from: b */
    public static synchronized void m72547b(Context context, String str) {
        if (f56174a == null) {
            f56174a = WXAPIFactory.createWXAPI(context, str, true);
            f56174a.registerApp(str);
        }
    }
}
