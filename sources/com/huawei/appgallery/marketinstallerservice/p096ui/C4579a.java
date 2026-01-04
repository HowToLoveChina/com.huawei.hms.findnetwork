package com.huawei.appgallery.marketinstallerservice.p096ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.appgallery.marketinstallerservice.R$string;

/* renamed from: com.huawei.appgallery.marketinstallerservice.ui.a */
/* loaded from: classes4.dex */
public class C4579a {

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.a$a */
    public interface a {
        /* renamed from: a */
        void mo28076a();

        /* renamed from: b */
        void mo28079b();
    }

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.a$b */
    public static class b implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: a */
        public a f21042a;

        /* renamed from: b */
        public int f21043b;

        /* renamed from: c */
        public boolean f21044c = true;

        public b(a aVar, int i10) {
            this.f21042a = aVar;
            this.f21043b = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            a aVar;
            if (i10 != -1 || (aVar = this.f21042a) == null) {
                return;
            }
            int i11 = this.f21043b;
            if (i11 == -3 || i11 == -2) {
                aVar.mo28076a();
                this.f21044c = false;
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a aVar = this.f21042a;
            if (aVar == null || !this.f21044c) {
                return;
            }
            aVar.mo28079b();
        }
    }

    /* renamed from: a */
    public static AlertDialog m28087a(Context context, int i10, a aVar, String str) {
        int i11;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        b bVar = new b(aVar, i10);
        if (str == null) {
            str = "";
        }
        if (i10 != -4) {
            if (i10 != -3) {
                if (i10 == -2) {
                    builder.setMessage(context.getResources().getString(R$string.market_install_market_failed, str));
                    i11 = R$string.market_install_retry_download;
                }
                return builder.create();
            }
            builder.setMessage(context.getResources().getString(R$string.market_install_download_failed));
            i11 = R$string.market_install_retry;
            builder.setPositiveButton(i11, bVar);
            builder.setNegativeButton(R$string.market_install_cancel, (DialogInterface.OnClickListener) null);
        } else {
            builder.setMessage(context.getResources().getString(R$string.market_install_can_not_get_market_info, str));
            builder.setPositiveButton(R$string.market_install_alert_dialog_ok, (DialogInterface.OnClickListener) null);
        }
        builder.setOnDismissListener(bVar);
        return builder.create();
    }
}
