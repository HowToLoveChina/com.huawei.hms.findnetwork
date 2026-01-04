package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class RiskConfirmDialog extends AlertDialogC13154a {
    public RiskConfirmDialog(Context context) {
        super(context);
    }

    private void initDialogView(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        setCancelable(false);
        if (!TextUtils.isEmpty(str)) {
            setTitle(str);
        }
        setMessage(str2);
        setButton(-2, str3, onClickListener);
        setButton(-1, str4, onClickListener);
    }

    public void show(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener) {
        initDialogView(str, str2, str3, str4, onClickListener);
        super.show();
    }
}
