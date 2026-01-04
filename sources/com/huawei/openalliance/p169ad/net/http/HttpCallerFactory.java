package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class HttpCallerFactory {
    /* renamed from: a */
    private static InterfaceC7505h m45960a(Context context) {
        StringBuilder sb2;
        String str;
        try {
            if (!AbstractC7741ao.m47572d()) {
                return null;
            }
            AbstractC7185ho.m43820b("HttpCallerFactory", "create OkHttpCaller");
            return new OkHttpCaller(context);
        } catch (RuntimeException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "createOkHttpCaller RuntimeException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("HttpCallerFactory", sb2.toString());
            return null;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "createOkHttpCaller Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("HttpCallerFactory", sb2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static InterfaceC7505h m45961a(Context context, int i10) {
        InterfaceC7505h c7508k = i10 == 2 ? new C7508k(context) : i10 == 1 ? m45960a(context) : null;
        if (c7508k != null) {
            return c7508k;
        }
        AbstractC7185ho.m43820b("HttpCallerFactory", "create HttpUrlConnectionCaller");
        return new C7504g(context);
    }

    /* renamed from: a */
    public static InterfaceC7506i m45962a() {
        try {
            if (AbstractC7741ao.m47572d()) {
                return new C7501d();
            }
            return null;
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("HttpCallerFactory", "create http listener exception: " + th2.getClass().getSimpleName());
            return null;
        }
    }
}
