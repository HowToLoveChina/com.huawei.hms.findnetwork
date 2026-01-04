package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p069cg.R$string;
import p031b7.C1120a;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p676ud.AlertDialogC13154a;

/* loaded from: classes2.dex */
public class UploadContinueDialog extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f10966a;

    /* renamed from: com.huawei.android.cg.dialog.UploadContinueDialog$a */
    public class DialogInterfaceOnClickListenerC2274a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2274a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 != i10) {
                if (-2 == i10) {
                    UploadContinueDialog.this.dismiss();
                }
            } else {
                InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
                if (interfaceC9282a == null) {
                    C1120a.m6677i("UploadContinueDialog", "cloudAlbumRouterImpl is null");
                } else {
                    interfaceC9282a.mo58467z(UploadContinueDialog.this.f10966a);
                }
            }
        }
    }

    public UploadContinueDialog(Context context) {
        super(context);
        this.f10966a = context;
        DialogInterfaceOnClickListenerC2274a dialogInterfaceOnClickListenerC2274a = new DialogInterfaceOnClickListenerC2274a();
        setButton(-1, context.getString(R$string.save_battery_dialog_upload_continue), dialogInterfaceOnClickListenerC2274a);
        setButton(-2, context.getString(R$string.save_battery_dialog_cancle), dialogInterfaceOnClickListenerC2274a);
        setMessage(this.f10966a.getString(R$string.sdk_tip_save_battery_dialog_upload_message));
    }
}
