package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.DialogInterface;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.GalleryDetailActivity;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class GalleryDisableDialog extends AlertDialogC13154a {
    private GalleryDetailActivity mActivity;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.GalleryDisableDialog$1 */
    public class DialogInterfaceOnClickListenerC41941 implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC41941() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            GalleryDisableDialog.this.mActivity.m20542Z3();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            GalleryDisableDialog.this.mActivity.m20542Z3();
        }
    }

    public GalleryDisableDialog(GalleryDetailActivity galleryDetailActivity) {
        super(galleryDetailActivity);
        this.mActivity = galleryDetailActivity;
        setTitle(R$string.gallery_shelve_success_title);
        int iM16192z = C2783d.m16192z(galleryDetailActivity);
        setMessage(this.mActivity.getResources().getQuantityString(R$plurals.gallery_disable_dialog_msg, iM16192z, Integer.valueOf(iM16192z)));
        setOnCancelListener(new DialogOnCancelListener());
        setButton(-1, galleryDetailActivity.getResources().getString(R$string.cloudbackup_btn_ok), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.GalleryDisableDialog.1
            public DialogInterfaceOnClickListenerC41941() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                GalleryDisableDialog.this.mActivity.m20542Z3();
            }
        });
        setCanceledOnTouchOutside(false);
    }

    public void showDialog() {
        show();
        getButton(-1).setTextColor(this.mActivity.getResources().getColor(R$color.progressbar_front_color));
    }
}
