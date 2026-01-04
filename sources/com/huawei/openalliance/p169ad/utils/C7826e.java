package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7118fb;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.utils.e */
/* loaded from: classes2.dex */
public class C7826e {

    /* renamed from: com.huawei.openalliance.ad.utils.e$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f36099a;

        /* renamed from: b */
        final /* synthetic */ Context f36100b;

        public AnonymousClass1(List list, Context context) {
            list = list;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!AbstractC7760bg.m47767a(list) && context != null) {
                    for (AdSource adSource : list) {
                        if (adSource != null) {
                            C7653sb c7653sb = new C7653sb();
                            c7653sb.m47185c(true);
                            c7653sb.m47181b(false);
                            c7653sb.m47187d(adSource.m39554b());
                            C7654sc c7654scMo43274a = C7118fb.m43196a(context.getApplicationContext()).mo43274a(c7653sb);
                            Object[] objArr = new Object[1];
                            objArr[0] = c7654scMo43274a != null ? AbstractC7819dl.m48375a(c7654scMo43274a.m47210b()) : null;
                            AbstractC7185ho.m43821b("AdSourceUtil", "downloadDspLogo result= %s", objArr);
                        }
                    }
                }
            } catch (Throwable unused) {
                AbstractC7185ho.m43826d("AdSourceUtil", "downloadDspLogo error");
            }
        }
    }

    /* renamed from: a */
    public static void m48392a(Context context, List<AdSource> list) {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.utils.e.1

            /* renamed from: a */
            final /* synthetic */ List f36099a;

            /* renamed from: b */
            final /* synthetic */ Context f36100b;

            public AnonymousClass1(List list2, Context context2) {
                list = list2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!AbstractC7760bg.m47767a(list) && context != null) {
                        for (AdSource adSource : list) {
                            if (adSource != null) {
                                C7653sb c7653sb = new C7653sb();
                                c7653sb.m47185c(true);
                                c7653sb.m47181b(false);
                                c7653sb.m47187d(adSource.m39554b());
                                C7654sc c7654scMo43274a = C7118fb.m43196a(context.getApplicationContext()).mo43274a(c7653sb);
                                Object[] objArr = new Object[1];
                                objArr[0] = c7654scMo43274a != null ? AbstractC7819dl.m48375a(c7654scMo43274a.m47210b()) : null;
                                AbstractC7185ho.m43821b("AdSourceUtil", "downloadDspLogo result= %s", objArr);
                            }
                        }
                    }
                } catch (Throwable unused) {
                    AbstractC7185ho.m43826d("AdSourceUtil", "downloadDspLogo error");
                }
            }
        });
    }
}
