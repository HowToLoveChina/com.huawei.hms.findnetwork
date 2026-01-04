package com.huawei.android.hicloud.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import p664u0.C13108a;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class UserInfoChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C11839m.m70686d("UserInfoChangeReceiver", "intent is empty");
            return;
        }
        String action = intent.getAction();
        if (!"com.huawei.hwid.ACTION_HEAD_PIC_CHANGE".equalsIgnoreCase(action)) {
            if ("com.huawei.hwid.ACTION_ACCOUNTNAME_CHANGE".equalsIgnoreCase(action)) {
                C11839m.m70688i("UserInfoChangeReceiver", "user accentName Change");
                C13612b.m81829B().m81895x0();
                return;
            }
            return;
        }
        try {
            boolean booleanExtra = intent.getBooleanExtra("nickNameChange", false);
            String stringExtra = intent.getStringExtra("loginUserName");
            if (booleanExtra && stringExtra != null) {
                Intent intent2 = new Intent("com.huawei.hicloud.intent.USERINFO_CHANGE");
                intent2.putExtra("loginUserName", stringExtra);
                C13108a.m78878b(context).m78881d(intent2);
                InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                if (interfaceC9282a != null) {
                    interfaceC9282a.mo58369G0(context, stringExtra);
                } else {
                    C11839m.m70688i("UserInfoChangeReceiver", "cloudAlbumRouterImpl is null");
                }
            }
        } catch (Exception unused) {
            C11839m.m70687e("UserInfoChangeReceiver", "intent Serializable error.");
        }
    }
}
