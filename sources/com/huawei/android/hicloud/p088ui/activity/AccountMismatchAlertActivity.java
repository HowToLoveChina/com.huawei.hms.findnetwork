package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.huawei.android.p073ds.R$anim;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity;
import java.lang.reflect.InvocationTargetException;
import p514o9.C11829c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class AccountMismatchAlertActivity extends HiAnalyticsBaselActivity {

    /* renamed from: b */
    public Context f13493b;

    /* renamed from: c */
    public int f13494c;

    /* renamed from: d */
    public AlertDialog f13495d;

    /* renamed from: com.huawei.android.hicloud.ui.activity.AccountMismatchAlertActivity$a */
    public class ViewOnClickListenerC3118a implements View.OnClickListener {
        public ViewOnClickListenerC3118a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccountMismatchAlertActivity.this.finish();
        }
    }

    /* renamed from: c */
    public final void m18550c() {
        AlertDialog alertDialog = this.f13495d;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.f13495d = null;
        }
    }

    /* renamed from: d */
    public final void m18551d() throws IllegalAccessException, IllegalArgumentException {
        View viewInflate = LayoutInflater.from(this.f13493b).inflate(R$layout.hicloud_account_mismatch_dialog, (ViewGroup) null);
        String string = getString(R$string.account_mismatch_title);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f13493b).create();
        this.f13495d = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f13495d.setCancelable(false);
        if (this.f13494c == 1) {
            C11829c.m70585i1(this.f13495d.getWindow());
        }
        this.f13495d.setView(viewInflate, 0, 0, 0, 0);
        this.f13495d.setTitle(string);
        ((Button) C12809f.m76831d(viewInflate, R$id.confirm_btn)).setOnClickListener(new ViewOnClickListenerC3118a());
        this.f13495d.show();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.activity_close, 0);
    }

    @Override // com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException {
        super.onConfigurationChanged(configuration);
        m18550c();
        m18551d();
    }

    @Override // com.huawei.hicloud.report.p107bi.HiAnalyticsBaselActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f13494c = new HiCloudSafeIntent(intent).getIntExtra(FamilyShareConstants.ENTRY_TYPE, 0);
        }
        this.f13493b = this;
        m18551d();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        m18550c();
        super.onDestroy();
    }
}
