package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.GalleryDetailActivity;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import p015ak.C0219i;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class GalleryShelveDialog extends AlertDialogC13154a {
    private TextView dialogMsg;
    private TextView dialogMsgAttention;
    private GalleryDetailActivity mActivity;

    public class BtnOnClickListner implements DialogInterface.OnClickListener {
        public BtnOnClickListner() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                GalleryShelveDialog.this.mActivity.m20557s4();
            }
            GalleryShelveDialog.this.mActivity.m20512E4(false);
            GalleryShelveDialog.this.dismiss();
        }
    }

    public GalleryShelveDialog(GalleryDetailActivity galleryDetailActivity) {
        super(galleryDetailActivity);
        this.mActivity = galleryDetailActivity;
        BtnOnClickListner btnOnClickListner = new BtnOnClickListner();
        View viewM76832e = C12809f.m76832e(getLayoutInflater(), C0219i.m1463a() >= 17 ? R$layout.gallery_shelve_dialog_emui9 : R$layout.gallery_shelve_dialog);
        this.dialogMsg = (TextView) C12809f.m76831d(viewM76832e, R$id.dialog_msg);
        this.dialogMsgAttention = (TextView) C12809f.m76831d(viewM76832e, R$id.dialog_attention);
        setButton(-1, galleryDetailActivity.getString(R$string.gallery_shelve_confirm), btnOnClickListner);
        setButton(-2, galleryDetailActivity.getString(R$string.gallery_shelve_cancel), btnOnClickListner);
        setView(viewM76832e);
        setTitle(this.mActivity.getResources().getString(R$string.gallery_shelve));
        setCanceledOnTouchOutside(false);
    }

    public void showDialog(Context context) throws Resources.NotFoundException {
        this.dialogMsg.setText(this.mActivity.getResources().getString(R$string.gallery_shelve_primary_alert, Integer.valueOf(C2783d.m16162n())));
        this.dialogMsgAttention.setText(this.mActivity.getResources().getString(R$string.gallery_shelve_primary_alert_attention));
        show();
        getButton(-1).setTextColor(context.getResources().getColor(R$color.enui50_red_color));
    }
}
