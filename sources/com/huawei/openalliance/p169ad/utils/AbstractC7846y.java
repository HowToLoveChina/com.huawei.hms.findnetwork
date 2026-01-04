package com.huawei.openalliance.p169ad.utils;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.download.app.AlertDialogC7042a;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.utils.y */
/* loaded from: classes2.dex */
public abstract class AbstractC7846y {

    /* renamed from: com.huawei.openalliance.ad.utils.y$a */
    public interface a {
        /* renamed from: a */
        void mo42634a();

        /* renamed from: a */
        void mo42635a(boolean z10);
    }

    /* renamed from: a */
    public static AlertDialog.Builder m48617a(Context context) {
        return !C6982bz.m41153c(context) ? AbstractC7741ao.m47590l(context) ? new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Dialog.Alert) : new AlertDialog.Builder(context, R.style.Theme.DeviceDefault.Light.Dialog.Alert) : new AlertDialog.Builder(context);
    }

    /* renamed from: a */
    private static Dialog m48618a(Context context, AlertDialog.Builder builder, String str, String str2, String str3, final a aVar) {
        Window window;
        if (str != null) {
            builder.setTitle(str);
        }
        builder.setPositiveButton(str2, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.y.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo42634a();
                }
            }
        });
        builder.setNegativeButton(str3, new DialogInterface.OnClickListener() { // from class: com.huawei.openalliance.ad.utils.y.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo42635a(true);
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.huawei.openalliance.ad.utils.y.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo42635a(false);
                }
            }
        });
        if (!(context instanceof Activity) && (window = alertDialogCreate.getWindow()) != null) {
            window.setType(2038);
        }
        return alertDialogCreate;
    }

    /* renamed from: a */
    public static Dialog m48619a(Context context, ContentRecord contentRecord, AlertDialogC7042a.a aVar) throws Resources.NotFoundException {
        AlertDialogC7042a alertDialogC7042a = new AlertDialogC7042a(context, contentRecord, aVar);
        alertDialogC7042a.show();
        return alertDialogC7042a;
    }

    /* renamed from: a */
    public static Dialog m48620a(Context context, String str, String str2, String str3, String str4, a aVar) {
        AlertDialog.Builder builderM48617a = m48617a(context);
        if (str2 != null) {
            builderM48617a.setMessage(str2);
        }
        Dialog dialogM48618a = m48618a(context, builderM48617a, str, str3, str4, aVar);
        m48621a(dialogM48618a);
        return dialogM48618a;
    }

    /* renamed from: a */
    private static void m48621a(Dialog dialog) {
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException unused) {
            AbstractC7185ho.m43823c("DialogUtil", "showDialog BadTokenException");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("DialogUtil", "showDialog exception %s", th2.getClass().getSimpleName());
        }
    }
}
