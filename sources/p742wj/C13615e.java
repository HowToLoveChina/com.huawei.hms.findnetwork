package p742wj;

import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import p399jk.AbstractC10896a;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;

/* renamed from: wj.e */
/* loaded from: classes5.dex */
public class C13615e implements InterfaceC13449b {

    /* renamed from: a */
    public Handler f61269a;

    public C13615e(Handler handler) {
        this.f61269a = handler;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        AbstractC10896a.m65887i("RefreshServiceCountryHandler", "authFailed");
        if (exc != null) {
            AbstractC10896a.m65887i("RefreshServiceCountryHandler", "getHomeCountry error: " + exc.toString());
        }
        Handler handler = this.f61269a;
        if (handler != null) {
            handler.sendEmptyMessage(20000);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        AbstractC10896a.m65887i("RefreshServiceCountryHandler", "authTokenSuccess");
        m81908a(bundle);
    }

    /* renamed from: a */
    public final void m81908a(Bundle bundle) {
        if (bundle == null) {
            AbstractC10896a.m65886e("RefreshServiceCountryHandler", "bundle is null");
            Handler handler = this.f61269a;
            if (handler != null) {
                handler.sendEmptyMessage(20000);
                return;
            }
            return;
        }
        String string = bundle.getString(CommonConstant.KEY_SERVICE_COUNTRY_CODE);
        if (TextUtils.isEmpty(string)) {
            AbstractC10896a.m65886e("RefreshServiceCountryHandler", "service country code is null.");
            Handler handler2 = this.f61269a;
            if (handler2 != null) {
                handler2.sendEmptyMessage(20000);
                return;
            }
            return;
        }
        AbstractC10896a.m65887i("RefreshServiceCountryHandler", "get service country code success, service country code is: " + string);
        C13452e.m80781L().m80821J2(string);
        C13452e.m80781L().m80825K2(System.currentTimeMillis());
        Handler handler3 = this.f61269a;
        if (handler3 != null) {
            handler3.sendEmptyMessage(20001);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        AbstractC10896a.m65887i("RefreshServiceCountryHandler", "authCanceled");
        Handler handler = this.f61269a;
        if (handler != null) {
            handler.sendEmptyMessage(20000);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
        AbstractC10896a.m65887i("RefreshServiceCountryHandler", "getUserInfoSuccess");
        m81908a(bundle);
    }
}
