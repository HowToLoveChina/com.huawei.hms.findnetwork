package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$string;
import sk.AlertDialogC12804a;

/* loaded from: classes3.dex */
public class RefurbishConfirmationDialog extends AlertDialogC12804a {
    private ClickCallback clickCallback;

    public interface ClickCallback {
        void onRefurbishCancel();

        void onRefurbishContinue();
    }

    public RefurbishConfirmationDialog(Context context, CharSequence charSequence, ClickCallback clickCallback) {
        super(context);
        setMessage(charSequence);
        init(context, clickCallback);
    }

    private void init(Context context, ClickCallback clickCallback) {
        this.clickCallback = clickCallback;
        setButton(-1, context.getString(R$string.refurbish_continue_button), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.p0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19242a.lambda$init$0(dialogInterface, i10);
            }
        });
        setButton(-2, context.getString(R$string.refurbish_cancel_button), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.q0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19243a.lambda$init$1(dialogInterface, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(DialogInterface dialogInterface, int i10) {
        this.clickCallback.onRefurbishContinue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(DialogInterface dialogInterface, int i10) {
        this.clickCallback.onRefurbishCancel();
    }
}
