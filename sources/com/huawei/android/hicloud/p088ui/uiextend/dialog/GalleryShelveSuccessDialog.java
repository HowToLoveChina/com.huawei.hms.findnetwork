package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.DialogInterface;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.GalleryDetailActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class GalleryShelveSuccessDialog extends AlertDialogC13154a {
    private GalleryDetailActivity hostActivity;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, IllegalArgumentException {
            GalleryShelveSuccessDialog.this.hostActivity.m20510C4(false);
            if (-1 == i10) {
                GalleryShelveSuccessDialog.this.hostActivity.m20556r4();
            }
            GalleryShelveSuccessDialog.this.dismiss();
        }
    }

    public GalleryShelveSuccessDialog(GalleryDetailActivity galleryDetailActivity) {
        super(galleryDetailActivity);
        this.hostActivity = galleryDetailActivity;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, galleryDetailActivity.getString(R$string.general_download_to_gallery_text), btnOnClickListner);
        setButton(-2, galleryDetailActivity.getString(R$string.gallery_shelve_download_later), btnOnClickListner);
        setCanceledOnTouchOutside(false);
        setTitle(this.hostActivity.getResources().getString(R$string.gallery_shelve_success_title));
    }

    public void showDialog() {
        setMessage(this.hostActivity.getResources().getString(R$string.gallery_shelve_success_tip, Integer.valueOf(C2783d.m16162n())));
        show();
    }
}
