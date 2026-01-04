package com.huawei.android.hicloud.common.receiver;

import android.accounts.OperationCanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.openalliance.p169ad.constant.Action;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import hu.C10343b;
import p015ak.C0209d;
import p020ap.C1009d;
import p514o9.C11839m;
import p681uj.C13195l;
import p709vj.InterfaceC13449b;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class AccountLoginNotificationReceiver extends BroadcastReceiver implements InterfaceC13449b {

    /* renamed from: a */
    public Context f11988a;

    /* renamed from: b */
    public String f11989b;

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        C11839m.m70688i("AccountLoginNotificationReceiver", "authFailed: " + exc.getMessage());
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
            C11839m.m70687e("AccountLoginNotificationReceiver", "authTokenSuccess error  bundle is null ");
            return;
        }
        String strM63694p = new C10343b(C13612b.m81829B().m81899z0(bundle)).m63694p("countryCode");
        this.f11989b = bundle.getString(JsbMapKeyNames.H5_USER_ID);
        C11839m.m70688i("AccountLoginNotificationReceiver", "countryCode: " + strM63694p);
        if ("CN".equals(strM63694p)) {
            C1009d.m6109e().m6110a(strM63694p);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
        C11839m.m70688i("AccountLoginNotificationReceiver", "authCanceled: " + (operationCanceledException != null ? operationCanceledException.getMessage() : ""));
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        C11839m.m70688i("AccountLoginNotificationReceiver", "receive account broadcast");
        if (C0209d.m1173G1(context) || !C0209d.m1166E1()) {
            C11839m.m70688i("AccountLoginNotificationReceiver", "isPrivacyUser or is not owner user, not need notify");
            return;
        }
        if (!C0209d.m1203Q1(context)) {
            C11839m.m70688i("AccountLoginNotificationReceiver", "OOBE not need notify");
        } else if (!Action.ACTION_HW_ACCOUNT_LOGIN.equals(new HiCloudSafeIntent(intent).getAction())) {
            C11839m.m70687e("AccountLoginNotificationReceiver", "not login action");
        } else {
            this.f11988a = context;
            C13195l.m79272J().m79337u0(this, false);
        }
    }
}
