package p742wj;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.ApiException;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p664u0.C13108a;
import p709vj.C13452e;
import p709vj.InterfaceC13449b;

/* renamed from: wj.d */
/* loaded from: classes5.dex */
public class C13614d implements InterfaceC13449b {

    /* renamed from: a */
    public Activity f61268a;

    public C13614d(Activity activity) {
        this.f61268a = activity;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        if ((exc instanceof ApiException) && ((ApiException) exc).getStatusCode() == 2001) {
            mo81904c();
        }
        mo81905d();
        AbstractC10896a.m65886e("LoginConsistentHandler", "authFailed error: " + exc.toString());
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        AbstractC10896a.m65887i("LoginConsistentHandler", "authTokenSuccess");
        m81907a(bundle);
    }

    /* renamed from: a */
    public final void m81907a(Bundle bundle) {
        if (bundle == null) {
            AbstractC10896a.m65886e("LoginConsistentHandler", "onLogin return bundle is null");
            mo81904c();
            return;
        }
        String string = bundle.getString(JsbMapKeyNames.H5_USER_ID);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        boolean zIsEmpty = TextUtils.isEmpty(string);
        boolean zIsEmpty2 = TextUtils.isEmpty(strM80971t0);
        boolean z10 = !zIsEmpty && string.equals(strM80971t0);
        Activity activity = this.f61268a;
        if (activity != null && (activity.isFinishing() || this.f61268a.isDestroyed())) {
            AbstractC10896a.m65886e("LoginConsistentHandler", "isfinishing");
            return;
        }
        if (!zIsEmpty && !zIsEmpty2 && z10) {
            mo81903b();
            return;
        }
        AbstractC10896a.m65886e("LoginConsistentHandler", "account not consistent, isHwIdUserIDEmpty =" + zIsEmpty + ", isHiCloudUserIDEmpty = " + zIsEmpty2 + ", isConsistent = " + z10);
        mo81904c();
    }

    /* renamed from: b */
    public void mo81903b() {
        AbstractC10896a.m65887i("LoginConsistentHandler", "notifyAccountConsistent");
    }

    /* renamed from: c */
    public void mo81904c() {
        AbstractC10896a.m65887i("LoginConsistentHandler", "notifyAccountException");
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a != null) {
                Intent intent = new Intent();
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.setAction("com.huawei.hicloud.intent.action.ACCOUNT_INCONSISTENT_NOTICE");
                C13108a.m78878b(contextM1377a).m78881d(intent);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("LoginConsistentHandler", "notifyAccountInConsistent exception: " + e10.toString());
        }
    }

    /* renamed from: d */
    public void mo81905d() {
        AbstractC10896a.m65887i("LoginConsistentHandler", "notifyAuthFailed");
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        mo81906f();
    }

    /* renamed from: f */
    public void mo81906f() {
        AbstractC10896a.m65887i("LoginConsistentHandler", "notifyLoginCanceled");
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    public C13614d() {
    }
}
