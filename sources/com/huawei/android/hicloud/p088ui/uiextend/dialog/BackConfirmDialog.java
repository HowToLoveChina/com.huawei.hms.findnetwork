package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import p015ak.C0223k;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class BackConfirmDialog extends AlertDialogC13154a {
    private static final String TAG = "BackConfirmDialog";

    public BackConfirmDialog(Context context, int i10, int i11, long j10, DialogInterface.OnClickListener onClickListener) {
        String string;
        super(context);
        if (context == null) {
            C11839m.m70687e(TAG, "BackConfirmDialog init failed, context is null");
            return;
        }
        if (i10 < i11) {
            int i12 = i11 - i10;
            Resources resources = context.getResources();
            string = resources != null ? resources.getQuantityString(R$plurals.back_confirm_dialog_content_launch, i12, Integer.valueOf(i12), C0223k.m1524g(context, j10)) : "";
            setButton(-1, context.getString(R$string.back_confirm_dialog_positive_launch), onClickListener);
        } else {
            string = context.getString(R$string.back_confirm_dialog_content_accept, C0223k.m1524g(context, j10));
            setButton(-1, context.getString(R$string.back_confirm_dialog_positive_accept), onClickListener);
        }
        setMessage(string);
        setButton(-2, context.getString(R$string.back_confirm_dialog_negtive), onClickListener);
    }
}
