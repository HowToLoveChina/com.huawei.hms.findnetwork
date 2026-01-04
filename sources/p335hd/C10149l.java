package p335hd;

import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.StockActiveConstants;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import hu.C10343b;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p572qb.C12314i0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p681uj.C13195l;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;
import p742wj.C13612b;

/* renamed from: hd.l */
/* loaded from: classes3.dex */
public class C10149l extends AbstractC12367d {

    /* renamed from: a */
    public String f49451a;

    /* renamed from: hd.l$a */
    public class a implements InterfaceC13449b {
        public a() {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: L */
        public void mo13808L(Exception exc) {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: Q */
        public boolean mo13814Q(Bundle bundle) {
            return false;
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: W */
        public void mo13820W(Bundle bundle) {
            if (bundle == null) {
                C11839m.m70687e("StockActiveLoginTask", "aidlLoginForAccountInfo, getAccountInfo return null");
                return;
            }
            String strM63694p = new C10343b(C13612b.m81829B().m81899z0(bundle)).m63694p("countryCode");
            C11839m.m70688i("StockActiveLoginTask", "countryCode from login: " + strM63694p);
            if ("CN".equals(strM63694p)) {
                UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.ACTIVE_CLOUD_BY_LOGIN);
                C12314i0.m74036h().m74051q(true);
                UserActiveRecommendManager.getInstance().recommend();
            }
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: e */
        public void mo13829e(OperationCanceledException operationCanceledException) {
        }

        @Override // p709vj.InterfaceC13449b
        /* renamed from: m0 */
        public void mo13838m0(Bundle bundle) {
        }
    }

    public C10149l(String str) {
        this.f49451a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("StockActiveLoginTask", "context is null");
            return;
        }
        try {
            Thread.sleep(5000L);
            if (C0209d.m1185K1(contextM1377a) || C13452e.m80781L().m80850R0()) {
                C11839m.m70688i("StockActiveLoginTask", "cloud activated");
                return;
            }
            C12314i0.m74036h().m74052r();
            C11839m.m70688i("StockActiveLoginTask", "countryCode from hwid: " + this.f49451a);
            if (TextUtils.isEmpty(this.f49451a)) {
                C11839m.m70688i("StockActiveLoginTask", "AIDL Login");
                C13195l.m79272J().m79337u0(new a(), false);
            } else if (this.f49451a.equals("CN")) {
                UserActiveRecommendManager.getInstance().report(StockActiveConstants.Report.ACTIVE_CLOUD_BY_UNLOGIN);
                C12314i0.m74036h().m74051q(true);
                UserActiveRecommendManager.getInstance().recommend();
            }
        } catch (Exception e10) {
            C11839m.m70687e("StockActiveLoginTask", "sleep exception: " + e10.toString());
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.STOCK_ACTIVE;
    }
}
