package com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.p098ui.uiextend.view.UpgradeExtendCustomView;
import p054cj.C1442a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PriceDescriptionDialog extends AlertDialog {
    private static final String TAG = "PriceDescriptionDialog";

    public PriceDescriptionDialog(Context context) {
        super(context);
    }

    public void showDialog(String str, String str2) {
        C1442a.m8290i(TAG, "showDialog");
        View viewInflate = getLayoutInflater().inflate(R$layout.price_desc_dialog_layout, (ViewGroup) null);
        ((UpgradeExtendCustomView) C12809f.m76831d(viewInflate, R$id.price_desc_dialog_container)).m28609c(str, str2.split("\\$\\$x0A"));
        setView(viewInflate);
        show();
    }
}
