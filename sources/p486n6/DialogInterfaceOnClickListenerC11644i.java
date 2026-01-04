package p486n6;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.huawei.android.p069cg.R$string;
import p676ud.AlertDialogC13154a;

/* renamed from: n6.i */
/* loaded from: classes2.dex */
public class DialogInterfaceOnClickListenerC11644i extends AlertDialogC13154a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    public Context f54014a;

    /* renamed from: b */
    public Handler f54015b;

    public DialogInterfaceOnClickListenerC11644i(Context context, Handler handler) {
        super(context);
        this.f54014a = context;
        this.f54015b = handler;
        setButton(-2, context.getString(R$string.cloudbackup_btn_cancel), this);
        setButton(-1, context.getString(R$string.cloudpay_estimate_dialog_positive), this);
        setMessage(this.f54014a.getString(R$string.viewer_delete_tips));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        if (-1 == i10) {
            this.f54015b.sendEmptyMessage(2);
            dismiss();
        } else if (-2 == i10) {
            dismiss();
        }
    }
}
