package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.activity.ShareAlbumApplicationInfoActivity;
import p676ud.AlertDialogC13154a;

/* loaded from: classes2.dex */
public class RejectApplicantConfirmDialog extends AlertDialogC13154a {

    /* renamed from: a */
    public Context f10955a;

    /* renamed from: com.huawei.android.cg.dialog.RejectApplicantConfirmDialog$a */
    public class DialogInterfaceOnClickListenerC2273a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2273a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1 && (RejectApplicantConfirmDialog.this.f10955a instanceof ShareAlbumApplicationInfoActivity)) {
                ((ShareAlbumApplicationInfoActivity) RejectApplicantConfirmDialog.this.f10955a).m13735r2();
            }
            RejectApplicantConfirmDialog.this.dismiss();
        }
    }

    public RejectApplicantConfirmDialog(Context context) {
        super(context);
        this.f10955a = context;
        setMessage(context.getString(R$string.applicant_reject_confirm));
        DialogInterfaceOnClickListenerC2273a dialogInterfaceOnClickListenerC2273a = new DialogInterfaceOnClickListenerC2273a();
        setButton(-1, context.getString(R$string.album_disagree_join), dialogInterfaceOnClickListenerC2273a);
        setButton(-2, context.getString(R$string.cancel), dialogInterfaceOnClickListenerC2273a);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        getButton(-1).setTextColor(getContext().getColor(R$color.red));
    }
}
