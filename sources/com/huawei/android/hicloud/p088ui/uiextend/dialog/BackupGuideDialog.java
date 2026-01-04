package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupGuideDialog extends AlertDialogC13154a {
    private Context context;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-2 == i10) {
                BackupGuideDialog.this.dismiss();
            }
        }
    }

    public BackupGuideDialog(Context context) {
        super(context);
        this.context = context;
        setTitle(R$string.backup_guide_tips_title);
        setButton(-2, context.getString(R$string.backup_guide_tips_button), new BtnOnClickListner());
        initView();
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.backup_guide_dialog, (ViewGroup) null);
        TextView textView = (TextView) C12809f.m76831d(viewInflate, R$id.tv_backup_guide1);
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_backup_guide2);
        textView.setText(C2783d.m16179s1(R$string.backup_guide_tips1_second, R$string.backup_guide_tips1_second_wifi));
        textView2.setText(C2783d.m16179s1(R$string.backup_guide_tips2_second, R$string.backup_guide_tips2_second_wifi));
        setView(viewInflate);
    }
}
