package p341hj;

import android.os.Handler;
import android.text.TextUtils;
import fk.C9721b;
import p054cj.C1442a;
import tm.C13040c;

/* renamed from: hj.h1 */
/* loaded from: classes5.dex */
public class C10233h1 extends AbstractC10222e {

    /* renamed from: b */
    public Handler f49599b;

    public C10233h1(Handler handler) {
        this.f49599b = handler;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        String strM78625Q;
        try {
            strM78625Q = C13040c.m78609F().m78625Q();
        } catch (C9721b e10) {
            C1442a.m8291w("QueryMouthAgreementUrlHostTask", "queryMouthAgreementUrlHost error= " + e10.toString());
            strM78625Q = null;
        }
        if (TextUtils.isEmpty(strM78625Q)) {
            strM78625Q = "";
        }
        m63380f(this.f49599b, 2128, strM78625Q);
    }
}
