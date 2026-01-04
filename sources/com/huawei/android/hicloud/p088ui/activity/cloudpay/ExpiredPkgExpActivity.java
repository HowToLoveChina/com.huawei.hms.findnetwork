package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import com.huawei.android.p073ds.R$id;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p054cj.C1442a;

/* loaded from: classes3.dex */
public class ExpiredPkgExpActivity extends UnusefulVoucherActivity {

    /* renamed from: C1 */
    public PackageExpExpiredFragment f17094C1;

    /* renamed from: D1 */
    public PackageExpUsedFragment f17095D1;

    /* renamed from: R5 */
    public final void m23520R5() {
        this.f17424s1 = getFragmentManager();
        this.f17094C1 = new PackageExpExpiredFragment();
        this.f17095D1 = new PackageExpUsedFragment();
        FragmentTransaction fragmentTransactionBeginTransaction = this.f17424s1.beginTransaction();
        int i10 = R$id.frame_layout;
        fragmentTransactionBeginTransaction.add(i10, this.f17095D1).add(i10, this.f17094C1).hide(this.f17094C1).commitAllowingStateLoss();
        m23829O5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.UnusefulVoucherActivity, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("ExpiredPkgExpActivity", "initData");
        if (C0209d.m1333z1(this)) {
            mo19479s5();
        } else {
            m23830Q5();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.UnusefulVoucherActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.used_voucher) {
            m23826K5("UNIFORM_PKG_EXP_USED_CLICK");
            m23829O5();
            FragmentManager fragmentManager = this.f17424s1;
            if (fragmentManager != null) {
                fragmentManager.beginTransaction().show(this.f17095D1).hide(this.f17094C1).commitAllowingStateLoss();
            }
            mo19476h5();
            return;
        }
        if (id2 == R$id.expired_voucher) {
            m23825J5("UNIFORM_PKG_EXP_EXPIRED_CLICK");
            m23827L5();
            FragmentManager fragmentManager2 = this.f17424s1;
            if (fragmentManager2 != null) {
                fragmentManager2.beginTransaction().show(this.f17094C1).hide(this.f17095D1).commitAllowingStateLoss();
            }
            mo19476h5();
            return;
        }
        if (R$id.layout_nonetwork == id2) {
            mo19460T3();
        } else if (R$id.set_no_net_btn == id2) {
            mo19446D1();
        } else if (R$id.layout_nodata == id2) {
            mo19460T3();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.UnusefulVoucherActivity, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C1442a.m8290i("ExpiredPkgExpActivity", "onCreate");
        super.onCreate(bundle);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.UnusefulVoucherActivity, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        C1442a.m8290i("ExpiredPkgExpActivity", "begin showView");
        m23520R5();
        mo19476h5();
    }
}
