package com.huawei.hwidauth.p167ui;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.widget.ArrayAdapter;
import com.huawei.android.hms.hwid.R$id;
import com.huawei.android.hms.hwid.R$layout;
import com.huawei.android.hms.hwid.R$string;
import p640sq.C12836o;
import p640sq.C12844w;

/* renamed from: com.huawei.hwidauth.ui.a */
/* loaded from: classes8.dex */
public class AlertDialogBuilderC6716a extends AlertDialog.Builder {

    /* renamed from: a */
    public AlertDialog f31112a;

    /* renamed from: b */
    public Activity f31113b;

    /* renamed from: c */
    public Uri f31114c;

    /* renamed from: d */
    public String f31115d;

    /* renamed from: e */
    public InterfaceC6719d f31116e;

    /* renamed from: com.huawei.hwidauth.ui.a$a */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC6719d f31117a;

        public a(InterfaceC6719d interfaceC6719d) {
            this.f31117a = interfaceC6719d;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == 0) {
                C12836o.m77097b("WebViewActivityAddPicDialog", "startCamare", true);
                this.f31117a.mo38149b();
            } else if (i10 == 1) {
                C12836o.m77097b("WebViewActivityAddPicDialog", "startGallery", true);
                this.f31117a.mo38150c();
            } else {
                if (i10 != 2) {
                    return;
                }
                C12836o.m77097b("WebViewActivityAddPicDialog", "CANCEL", true);
                AlertDialogBuilderC6716a.this.f31116e.mo38148a();
                AlertDialogBuilderC6716a.this.m38166b();
            }
        }
    }

    public AlertDialogBuilderC6716a(Activity activity, Uri uri, InterfaceC6719d interfaceC6719d) {
        super(activity, C12844w.m77129a(activity));
        this.f31115d = ".hwidauth.fileProvider";
        this.f31113b = activity;
        this.f31114c = uri;
        this.f31116e = interfaceC6719d;
        setAdapter(new ArrayAdapter(this.f31113b, R$layout.item_hwid_auth_dialog_list, R$id.dialog_item_text, new CharSequence[]{activity.getResources().getString(R$string.CloudSetting_take_picture), activity.getResources().getString(R$string.hwid_string_choose_from_gallery), activity.getResources().getString(R.string.cancel)}), new a(interfaceC6719d));
    }

    /* renamed from: b */
    public void m38166b() {
        C12836o.m77099d("WebViewActivityAddPicDialog", "cancelDialog mDialog = " + this.f31112a, false);
        AlertDialog alertDialog = this.f31112a;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        C12836o.m77099d("WebViewActivityAddPicDialog", "cancelDialog enter ", true);
        this.f31112a.cancel();
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        AlertDialog alertDialogShow = super.show();
        this.f31112a = alertDialogShow;
        return alertDialogShow;
    }
}
