package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p069cg.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes2.dex */
public class UploadInsufficientSpace extends AlertDialogC13154a {
    public UploadInsufficientSpace(Context context) {
        super(context);
        setTitle(context.getString(R$string.upload_interrupted));
        setMessage(context.getString(R$string.upload_interrupted_msg));
        setButton(-1, context.getString(R$string.cs_confirm), new DialogInterface.OnClickListener() { // from class: n6.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f54055a.lambda$new$0(dialogInterface, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i10) {
        dismiss();
    }
}
