package kh;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import java.util.Iterator;
import p368ih.AbstractC10506e;
import p368ih.C10504c;
import p368ih.C10505d;

/* renamed from: kh.a */
/* loaded from: classes4.dex */
public class C11054a {
    /* renamed from: a */
    public static String m66622a(Context context) {
        String strM28093b;
        try {
            ServiceVerifyKit.C4580a c4580a = new ServiceVerifyKit.C4580a();
            c4580a.m28096e(context).m28098g(new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId"), ServiceVerifyKit.C4580a.a.ACTIVITY);
            AbstractC10506e abstractC10506eM64588a = C10504c.m64588a(context);
            Iterator<String> it = abstractC10506eM64588a.mo64587b().iterator();
            while (it.hasNext()) {
                c4580a.m28092a(abstractC10506eM64588a.mo64586a(), it.next());
            }
            if (C10505d.m64589a(context) == 2) {
                c4580a.m28092a("com.huawei.appmarketwear", "CE1EF7188F820973C191227D95D54311ED3A65EC83E37009E898A1C058BBC775");
            }
            strM28093b = c4580a.m28093b();
            try {
                Log.d("ServiceVerifyKitUtils", "genVerifiedPackageName, get market packageName from verify kit is: " + strM28093b);
            } catch (Throwable unused) {
                Log.e("ServiceVerifyKitUtils", "genVerifiedPackageName error");
                return strM28093b;
            }
        } catch (Throwable unused2) {
            strM28093b = null;
        }
        return strM28093b;
    }
}
