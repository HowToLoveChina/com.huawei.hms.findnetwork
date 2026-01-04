package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import p514o9.C11839m;
import p737wd.AlertDialogC13591d;

/* loaded from: classes3.dex */
public class RestrictedOperationActivity extends Activity {

    /* renamed from: a */
    public AlertDialogC13591d f15951a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_restricted_operation);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        C11839m.m70688i("RestrictedOperationActivity", "showRestrictionRunDialog");
        this.f15951a = new AlertDialogC13591d(this, getString(R$string.hidisk_restriction_run), getString(R$string.got_it));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialogC13591d alertDialogC13591d = this.f15951a;
        if (alertDialogC13591d != null) {
            alertDialogC13591d.dismiss();
            this.f15951a = null;
        }
    }
}
