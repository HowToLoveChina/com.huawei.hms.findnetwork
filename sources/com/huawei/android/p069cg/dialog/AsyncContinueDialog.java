package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import p676ud.AlertDialogC13154a;

/* loaded from: classes2.dex */
public class AsyncContinueDialog extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f10951a;

    /* renamed from: com.huawei.android.cg.dialog.AsyncContinueDialog$a */
    public class DialogInterfaceOnClickListenerC2272a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2272a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                CloudAlbumManager.m14456v().m14500r(AsyncContinueDialog.this.f10951a);
            } else if (-2 == i10) {
                AsyncContinueDialog.this.dismiss();
            }
        }
    }

    public AsyncContinueDialog(Context context) {
        super(context);
        this.f10951a = context;
        DialogInterfaceOnClickListenerC2272a dialogInterfaceOnClickListenerC2272a = new DialogInterfaceOnClickListenerC2272a();
        setButton(-1, context.getString(R$string.save_battery_dialog_sync_continue), dialogInterfaceOnClickListenerC2272a);
        setButton(-2, context.getString(R$string.save_battery_dialog_cancle), dialogInterfaceOnClickListenerC2272a);
        setMessage(this.f10951a.getString(R$string.sdk_tip_save_battery_dialog_updating_message));
    }
}
