package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import com.huawei.android.p073ds.R$color;
import p676ud.AlertDialogC13154a;

/* loaded from: classes3.dex */
public class TempDoubleBtnDialog extends AlertDialogC13154a {
    private static final String TAG = "TempDoubleBtnDialog";
    private final Context mContext;
    private final BtnOnClickListener onClickListener;

    public interface BtnCallBack {
        default void btnLeftCallBack() {
        }

        default void btnRightCallBack() {
        }
    }

    public class BtnOnClickListener implements DialogInterface.OnClickListener {
        BtnCallBack btnCallBack;

        public BtnOnClickListener(BtnCallBack btnCallBack) {
            this.btnCallBack = btnCallBack;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                this.btnCallBack.btnRightCallBack();
            } else if (-2 == i10) {
                this.btnCallBack.btnLeftCallBack();
            }
            TempDoubleBtnDialog.this.dismiss();
        }
    }

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            TempDoubleBtnDialog.this.dismiss();
        }
    }

    public TempDoubleBtnDialog(Context context, BtnCallBack btnCallBack) {
        super(context);
        this.mContext = context;
        this.onClickListener = new BtnOnClickListener(btnCallBack);
        setOnCancelListener(new DialogOnCancelListener());
    }

    public void showCommonView(int i10, int i11, int i12, int i13, int i14) {
        setTitle(this.mContext.getResources().getString(i10));
        setMessage(this.mContext.getResources().getString(i11));
        setButton(-1, this.mContext.getString(i12), this.onClickListener);
        setButton(-2, this.mContext.getString(i13), this.onClickListener);
        show();
        if (i14 == 1) {
            getButton(-2).setTextColor(this.mContext.getResources().getColor(R$color.emui_functional_blue));
        } else {
            getButton(-2).setTextColor(this.mContext.getResources().getColor(R$color.emui_functional_red));
        }
    }

    public void showCommonView(String str, String str2, String str3, String str4, int i10) {
        setTitle(str);
        setMessage(str2);
        setButton(-1, str3, this.onClickListener);
        setButton(-2, str4, this.onClickListener);
        show();
        if (i10 == 1) {
            getButton(-2).setTextColor(this.mContext.getResources().getColor(R$color.emui_functional_blue));
        } else {
            getButton(-2).setTextColor(this.mContext.getResources().getColor(R$color.emui_functional_red));
        }
    }
}
