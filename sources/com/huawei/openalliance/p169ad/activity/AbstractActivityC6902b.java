package com.huawei.openalliance.p169ad.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;

/* renamed from: com.huawei.openalliance.ad.activity.b */
/* loaded from: classes8.dex */
public abstract class AbstractActivityC6902b extends AbstractActivityC6905e {

    /* renamed from: com.huawei.openalliance.ad.activity.b$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            String str;
            AbstractActivityC6902b abstractActivityC6902b;
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || !action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    return;
                }
                String stringExtra = intent.getStringExtra("reason");
                AbstractC7185ho.m43818a("BaseHomeActivity", "systemReason:%s", stringExtra);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (stringExtra.equalsIgnoreCase("homekey")) {
                    AbstractC7185ho.m43817a("BaseHomeActivity", "closedialog SYSTEM_HOME_KEY");
                    abstractActivityC6902b = AbstractActivityC6902b.this;
                } else {
                    if (!stringExtra.equalsIgnoreCase("recentapps")) {
                        return;
                    }
                    AbstractC7185ho.m43820b("BaseHomeActivity", "closedialog SYSTEM_RECENT_APPS");
                    abstractActivityC6902b = AbstractActivityC6902b.this;
                }
                abstractActivityC6902b.mo38698b();
            } catch (RuntimeException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str = "onReceive:";
                sb2.append(str);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("BaseHomeActivity", sb2.toString());
            } catch (Throwable th2) {
                e = th2;
                sb2 = new StringBuilder();
                str = "onReceive ex: ";
                sb2.append(str);
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("BaseHomeActivity", sb2.toString());
            }
        }
    }

    /* renamed from: b */
    public abstract void mo38698b();

    @Override // com.huawei.openalliance.p169ad.activity.AbstractActivityC6905e, com.huawei.openalliance.p169ad.activity.AbstractActivityC6906f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
