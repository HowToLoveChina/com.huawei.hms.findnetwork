package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.DialogInterface;
import com.huawei.android.hicloud.p088ui.activity.GalleryDetailActivity;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class UnShelveSpaceNotEnoughDialog extends AlertDialogC13154a {
    private GalleryDetailActivity mActivity;
    private String needSpaceSize;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                UnShelveSpaceNotEnoughDialog.this.mActivity.m20558t4();
            }
            UnShelveSpaceNotEnoughDialog.this.dismiss();
        }
    }

    public UnShelveSpaceNotEnoughDialog(GalleryDetailActivity galleryDetailActivity, String str) {
        super(galleryDetailActivity);
        this.needSpaceSize = "";
        this.mActivity = galleryDetailActivity;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        setButton(-1, galleryDetailActivity.getString(R$string.gallery_unshelve_space_not_enough_upgrade), btnOnClickListner);
        setButton(-2, galleryDetailActivity.getString(R$string.gallery_shelve_cancel), btnOnClickListner);
        this.needSpaceSize = str;
        setCanceledOnTouchOutside(false);
        setTitle(this.mActivity.getResources().getString(R$string.gallery_unshelve_failed_title));
    }

    public void showDialog() {
        setMessage(this.mActivity.getString(R$string.gallery_unshelve_space_not_enough_dialog_msg, this.needSpaceSize));
        show();
    }
}
