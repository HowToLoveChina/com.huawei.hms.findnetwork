package com.huawei.appgallery.marketinstallerservice.impl.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import mh.C11468a;
import th.C13012a;

/* loaded from: classes4.dex */
public class MarketInstallReceiver extends SafeBroadcastReceiver {
    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public void onReceiveMsg(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("callback_key");
        InstallCallback installCallbackM68590a = C11468a.m68590a(stringExtra);
        MarketInfo marketInfoM68593d = C11468a.m68593d(stringExtra);
        if (installCallbackM68590a == null) {
            C13012a.m78318d("MarketInstallReceiver", "market install callback is null!");
            return;
        }
        int i10 = extras.getInt("android.content.pm.extra.STATUS");
        if (i10 == 0) {
            installCallbackM68590a.onSuccess(marketInfoM68593d);
        } else {
            FailResultParam failResultParam = new FailResultParam();
            failResultParam.setResult(-2);
            failResultParam.setReason(i10);
            failResultParam.setMarketInfo(marketInfoM68593d);
            installCallbackM68590a.onFailed(failResultParam);
        }
        C11468a.m68595f(stringExtra);
        C11468a.m68594e(stringExtra);
    }
}
