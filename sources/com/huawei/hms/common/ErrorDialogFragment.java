package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes8.dex */
public class ErrorDialogFragment extends DialogFragment {

    /* renamed from: a */
    private Dialog f23408a = null;

    /* renamed from: b */
    private DialogInterface.OnCancelListener f23409b = null;

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f23409b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f23408a == null) {
            setShowsDialog(false);
        }
        return this.f23408a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        errorDialogFragment.f23408a = dialog;
        dialog.setOnCancelListener(null);
        errorDialogFragment.f23408a.setOnDismissListener(null);
        if (onCancelListener != null) {
            errorDialogFragment.f23409b = onCancelListener;
        }
        return errorDialogFragment;
    }
}
