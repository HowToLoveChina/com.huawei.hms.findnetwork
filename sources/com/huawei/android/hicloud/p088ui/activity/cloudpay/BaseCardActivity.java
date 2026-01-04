package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.MemberQuitFamilyShareDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.PayResultErrorDialog;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.regex.Pattern;
import p746wn.C13622a;

/* loaded from: classes3.dex */
public abstract class BaseCardActivity extends BuyPackageBaseActivity {
    /* renamed from: G5 */
    public boolean m22711G5(String str) {
        return str != null && str.length() == 18 && Pattern.matches("^[A-Za-z0-9]+$", str);
    }

    /* renamed from: H5 */
    public boolean m22712H5(String str) {
        return Pattern.matches("^[A-Za-z0-9]+$", str);
    }

    /* renamed from: I5 */
    public void m22713I5() {
        View viewPeekDecorView = getWindow().peekDecorView();
        if (viewPeekDecorView != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(viewPeekDecorView.getWindowToken(), 0);
        }
    }

    /* renamed from: J5 */
    public void m22714J5(int i10) {
        Intent intent = new Intent();
        intent.putExtra(MapKeyNames.RESULT_CODE, i10);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: K5 */
    public void m22715K5(int i10) {
        PayResultErrorDialog payResultErrorDialog;
        if (i10 != 4004) {
            this.f21448i.m66668x("1");
            C13622a.m81968n(this, this.f21448i);
        }
        if (i10 == 107) {
            mo22716i5();
            return;
        }
        if (!isFinishing() && (payResultErrorDialog = this.f16528Q) != null && payResultErrorDialog.isShowing()) {
            this.f16528Q.dismiss();
            this.f16528Q = null;
        }
        if (this.f16528Q == null) {
            this.f16528Q = new PayResultErrorDialog(this, false);
        }
        this.f16528Q.show(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: i5 */
    public void mo22716i5() {
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog;
        if (!isFinishing() && (memberQuitFamilyShareDialog = this.f16505E0) != null && memberQuitFamilyShareDialog.isShowing()) {
            this.f16505E0.dismiss();
        }
        this.f16505E0 = null;
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog2 = new MemberQuitFamilyShareDialog(this, false);
        this.f16505E0 = memberQuitFamilyShareDialog2;
        memberQuitFamilyShareDialog2.showStopFamilyShareDialog();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        PayResultErrorDialog payResultErrorDialog = this.f16528Q;
        if (payResultErrorDialog != null) {
            payResultErrorDialog.dismiss();
            this.f16528Q = null;
        }
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog = this.f16505E0;
        if (memberQuitFamilyShareDialog != null) {
            memberQuitFamilyShareDialog.dismiss();
            this.f16505E0 = null;
        }
        super.onDestroy();
    }
}
