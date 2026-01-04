package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.android.hicloud.oobe.R$color;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BaseCardActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import dj.C9158a;
import java.lang.reflect.InvocationTargetException;
import p054cj.C1442a;
import p254eb.C9441b;
import p284fb.C9681b;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class MemberQuitFamilyShareDialog extends AlertDialogC13154a {
    private static final String TAG = "MemberQuitFamilyShareDialog";
    private boolean isAopPay;
    private Context mContext;

    public class MemberStopShareDialogClickListner implements DialogInterface.OnClickListener {
        public MemberStopShareDialogClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (MemberQuitFamilyShareDialog.this.mContext == null) {
                C1442a.m8291w(MemberQuitFamilyShareDialog.TAG, "MemberStopShareDialogClickListner mContext is null");
                return;
            }
            if (MemberQuitFamilyShareDialog.this.mContext instanceof BuyPackageBaseActivity) {
                BuyPackageBaseActivity buyPackageBaseActivity = (BuyPackageBaseActivity) MemberQuitFamilyShareDialog.this.mContext;
                if (-1 == i10) {
                    C1442a.m8290i(MemberQuitFamilyShareDialog.TAG, "MemberStopShareDialogClickListner click positive button.");
                    C9158a.m57503F().m57536d0(buyPackageBaseActivity.f16524O);
                } else if (-2 == i10) {
                    C1442a.m8290i(MemberQuitFamilyShareDialog.TAG, "MemberStopShareDialogClickListner click negative button.");
                    if (MemberQuitFamilyShareDialog.this.isAopPay) {
                        buyPackageBaseActivity.m22863q2();
                    } else {
                        buyPackageBaseActivity.finish();
                    }
                }
            } else if (MemberQuitFamilyShareDialog.this.mContext instanceof BaseCardActivity) {
                BaseCardActivity baseCardActivity = (BaseCardActivity) MemberQuitFamilyShareDialog.this.mContext;
                if (-1 == i10) {
                    C1442a.m8290i(MemberQuitFamilyShareDialog.TAG, "MemberStopShareDialogClickListner baseCardActivity click positive button.");
                    C9158a.m57503F().m57536d0(new Handler());
                } else if (-2 == i10) {
                    C1442a.m8290i(MemberQuitFamilyShareDialog.TAG, "MemberStopShareDialogClickListner baseCardActivity click negative button.");
                    baseCardActivity.finish();
                }
            } else {
                C1442a.m8289e(MemberQuitFamilyShareDialog.TAG, "MemberStopShareDialogClickListner invalid activity");
            }
            MemberQuitFamilyShareDialog.this.dismiss();
        }
    }

    public MemberQuitFamilyShareDialog(Context context, boolean z10) {
        super(context);
        this.mContext = context;
        this.isAopPay = z10;
    }

    @Override // android.app.Dialog
    public void onBackPressed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Context context = this.mContext;
        if (context == null) {
            C1442a.m8291w(TAG, "onBackPressed mContext is null");
            return;
        }
        if (!(context instanceof CloudSpaceUpgradeActivity)) {
            if (context instanceof OperationWebViewActivity) {
                ((OperationWebViewActivity) context).m21823N2();
            }
        } else {
            CloudSpaceUpgradeActivity cloudSpaceUpgradeActivity = (CloudSpaceUpgradeActivity) context;
            C1442a.m8290i(TAG, "onBackPressed click.");
            if (this.isAopPay) {
                cloudSpaceUpgradeActivity.m22863q2();
            } else {
                cloudSpaceUpgradeActivity.finish();
            }
        }
    }

    public void showStopFamilyShareDialog() {
        if (this.mContext == null) {
            C1442a.m8289e(TAG, "showStopFamilyShareDialog mContext is null.");
            return;
        }
        C9441b c9441bM60500u = C9681b.m60470l().m60500u(5);
        if (c9441bM60500u == null) {
            C1442a.m8289e(TAG, "showStopFamilyShareDialog shareSpaceDialogDetail is null.");
            return;
        }
        String strM59223c = c9441bM60500u.m59223c();
        String strM59222b = c9441bM60500u.m59222b();
        String strM59221a = c9441bM60500u.m59221a();
        if (TextUtils.isEmpty(strM59223c)) {
            C1442a.m8289e(TAG, "showStopFamilyShareDialog mainText is null.");
            return;
        }
        if (TextUtils.isEmpty(strM59222b)) {
            C1442a.m8289e(TAG, "showStopFamilyShareDialog confirmText is null.");
            return;
        }
        if (TextUtils.isEmpty(strM59221a)) {
            C1442a.m8289e(TAG, "showStopFamilyShareDialog cancelText is null.");
            return;
        }
        setMessage(strM59223c);
        MemberStopShareDialogClickListner memberStopShareDialogClickListner = new MemberStopShareDialogClickListner();
        setButton(-1, strM59222b, memberStopShareDialogClickListner);
        setButton(-2, strM59221a, memberStopShareDialogClickListner);
        show();
        getButton(-1).setTextColor(this.mContext.getColor(R$color.emui_functional_red));
    }
}
