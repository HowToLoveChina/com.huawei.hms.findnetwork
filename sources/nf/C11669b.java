package nf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.remotecontrol.sdk.R$string;
import p677ue.C13168a;
import p809yg.C13981a;

/* renamed from: nf.b */
/* loaded from: classes4.dex */
public class C11669b {

    /* renamed from: a */
    public static AlertDialog f54115a;

    /* renamed from: b */
    public static void m69675b() {
        AlertDialog alertDialog = f54115a;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        f54115a.dismiss();
        f54115a = null;
    }

    /* renamed from: c */
    public static /* synthetic */ void m69676c(DialogInterface dialogInterface, int i10) {
        C13981a.m83989i("BluetoothDialogUtil", "showBluetoothDialog click enable");
        C13168a.m79187p();
    }

    /* renamed from: d */
    public static void m69677d(Context context, String str) {
        C13981a.m83989i("BluetoothDialogUtil", "showBluetoothDialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(R$string.open_bluetooth).setMessage(context.getResources().getString(R$string.open_bluetooth_dialog)).setPositiveButton(R$string.pf_tips_start_now, new DialogInterface.OnClickListener() { // from class: nf.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                C11669b.m69676c(dialogInterface, i10);
            }
        }).setNegativeButton(R$string.supper_privacy_dialog_negitive, (DialogInterface.OnClickListener) null).create();
        f54115a = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        f54115a.show();
        C11690w.m69700W(str, "nearLinkOperation", "bluetoothRing", "showBluetoothDialog", "0", null);
    }
}
