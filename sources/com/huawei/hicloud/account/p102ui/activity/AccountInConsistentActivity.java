package com.huawei.hicloud.account.p102ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import com.huawei.hicloud.account.R$string;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p399jk.AbstractC10896a;
import p709vj.C13452e;
import p846zj.C14306d;
import sk.C12808e;

/* loaded from: classes5.dex */
public class AccountInConsistentActivity extends Activity {

    /* renamed from: a */
    public AlertDialog f22084a;

    /* renamed from: com.huawei.hicloud.account.ui.activity.AccountInConsistentActivity$a */
    public static class DialogInterfaceOnClickListenerC4848a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public boolean f22085a;

        /* renamed from: b */
        public Activity f22086b;

        public DialogInterfaceOnClickListenerC4848a(Activity activity, boolean z10) {
            this.f22085a = z10;
            this.f22086b = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            try {
                if (this.f22086b == null) {
                    AbstractC10896a.m65887i("AccountInConsistentActivity", "mActivity null");
                } else if (this.f22085a) {
                    AbstractC10896a.m65887i("AccountInConsistentActivity", "dialog positive");
                    this.f22086b.finishAffinity();
                    C14306d.m85221v("com.huawei.hicloud.actoin.ACTION_ACCOUNT_INCONSISTENT_EXIT_APP");
                }
            } catch (Exception e10) {
                AbstractC10896a.m65887i("AccountInConsistentActivity", "inconsistent dialog exception:" + e10.toString());
            }
        }
    }

    /* renamed from: a */
    public void m29090a() {
        AbstractC10896a.m65887i("AccountInConsistentActivity", "show consistent dialog");
        String strM80900d = C13452e.m80781L().m80900d();
        if (strM80900d == null) {
            strM80900d = "";
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(getString(R$string.alert)).setMessage(getString(R$string.account_inconsistent_alert, strM80900d)).setPositiveButton(R$string.account_inconsistent_btn_ok, new DialogInterfaceOnClickListenerC4848a(this, true)).create();
        this.f22084a = alertDialogCreate;
        try {
            alertDialogCreate.setCancelable(false);
            this.f22084a.show();
        } catch (Exception unused) {
            AbstractC10896a.m65886e("AccountInConsistentActivity", "showConsistentDialog exception");
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        m29090a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            AlertDialog alertDialog = this.f22084a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f22084a = null;
            }
        } catch (Exception e10) {
            AbstractC10896a.m65887i("AccountInConsistentActivity", "consistentDialog exception: " + e10.toString());
        }
    }
}
