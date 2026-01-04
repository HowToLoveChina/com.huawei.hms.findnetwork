package p745wm;

import android.text.TextUtils;
import mk.C11477c;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: wm.a */
/* loaded from: classes6.dex */
public class C13620a extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        String strM68636f = C11477c.m68636f("CBCKeyStoreAvailable");
        if (TextUtils.isEmpty(strM68636f)) {
            AbstractC10896a.m65886e("CBCKeyStoreAvailableTask", "CBC KeyStore encrypt fail");
            C13452e.m80781L().m80820J1(false);
            return;
        }
        String strM68633c = C11477c.m68633c(strM68636f);
        if (!TextUtils.isEmpty(strM68633c) && "CBCKeyStoreAvailable".equals(strM68633c)) {
            AbstractC10896a.m65887i("CBCKeyStoreAvailableTask", "CBC KeyStore available");
        } else {
            AbstractC10896a.m65886e("CBCKeyStoreAvailableTask", "CBC KeyStore decrypt fail");
            C13452e.m80781L().m80820J1(false);
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.QUERY_KEY;
    }
}
