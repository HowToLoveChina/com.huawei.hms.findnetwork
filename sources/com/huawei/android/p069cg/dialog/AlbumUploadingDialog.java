package com.huawei.android.p069cg.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.huawei.android.p069cg.R$layout;
import p514o9.C11829c;
import p676ud.AlertDialogC13154a;

/* loaded from: classes2.dex */
public class AlbumUploadingDialog extends AlertDialogC13154a {
    public AlbumUploadingDialog(Context context) throws IllegalAccessException, IllegalArgumentException {
        super(context);
        setView(LayoutInflater.from(context).inflate(R$layout.item_creating_album, (ViewGroup) null));
        Window window = getWindow();
        if (window != null) {
            window.setFlags(1024, 1024);
        }
        setCanceledOnTouchOutside(false);
        C11829c.m70594l1(context, this);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
