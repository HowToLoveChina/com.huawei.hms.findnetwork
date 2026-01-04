package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes2.dex */
public class UpgradeAlbumSpaceDialog extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public Context f10963a;

    /* renamed from: b */
    public LinearLayout f10964b;

    /* renamed from: c */
    public TextView f10965c;

    public UpgradeAlbumSpaceDialog(Context context) {
        super(context);
        this.f10963a = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6678w("UpgradeAlbumSpaceDialog", "click too fast");
            return;
        }
        int id2 = view.getId();
        if (id2 != R$id.upgrade_album_space_click_area) {
            if (id2 == R$id.upgrade_album_space_confirm_button) {
                dismiss();
            }
        } else {
            Intent intent = new Intent();
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setAction("com.huawei.android.hicloud.ui.cloudpay.CloudSpaceUpgradeActivity");
            C0224k0.m1542L(this.f10963a, intent);
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.upgrade_album_space_dialog_layout);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76830c(this, R$id.upgrade_album_space_click_area);
        this.f10964b = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76830c(this, R$id.upgrade_album_space_confirm_button);
        this.f10965c = textView;
        textView.setOnClickListener(this);
    }
}
