package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes8.dex */
public class ErrDlgFragmentForSupport extends DialogFragment {

    /* renamed from: a */
    private Dialog f23406a = null;

    /* renamed from: b */
    private DialogInterface.OnCancelListener f23407b = null;

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f23407b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f23406a == null) {
            setShowsDialog(false);
        }
        return this.f23406a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrDlgFragmentForSupport newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrDlgFragmentForSupport errDlgFragmentForSupport = new ErrDlgFragmentForSupport();
        errDlgFragmentForSupport.f23406a = dialog;
        dialog.setOnCancelListener(null);
        errDlgFragmentForSupport.f23406a.setOnDismissListener(null);
        errDlgFragmentForSupport.f23407b = onCancelListener;
        return errDlgFragmentForSupport;
    }
}
