package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import fk.C9721b;
import p054cj.C1442a;
import tm.C13040c;

/* renamed from: hj.g1 */
/* loaded from: classes5.dex */
public class C10230g1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49591b;

    public C10230g1(Handler handler) {
        this.f49591b = handler;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        String strM78669v;
        try {
            strM78669v = C13040c.m78609F().m78669v();
        } catch (C9721b e10) {
            C1442a.m8291w("QueryHiCloudAgreementHostTask", "queryHiCloudAgreementHostTask error = " + e10.toString());
            strM78669v = null;
        }
        if (TextUtils.isEmpty(strM78669v)) {
            strM78669v = "";
        }
        m63380f(this.f49591b, 2129, strM78669v);
    }
}
