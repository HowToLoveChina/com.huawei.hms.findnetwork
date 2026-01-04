package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.view.View;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.GalleryDetailActivity;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class GalleryShelveRequestResultTip extends AlertDialogC13154a {
    private TextView msgText;

    public GalleryShelveRequestResultTip(GalleryDetailActivity galleryDetailActivity) {
        super(galleryDetailActivity);
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), R$layout.gallery_shelve_request_result_tip);
        this.msgText = (TextView) C12809f.m76831d(viewM76832e, R$id.dialog_message);
        setView(viewM76832e);
        setCanceledOnTouchOutside(false);
        C12809f.m76831d(viewM76832e, R$id.positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.GalleryShelveRequestResultTip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GalleryShelveRequestResultTip.this.dismiss();
            }
        });
    }

    public void showDialog(String str) {
        if (isShowing()) {
            dismiss();
        }
        this.msgText.setText(str);
        show();
    }
}
