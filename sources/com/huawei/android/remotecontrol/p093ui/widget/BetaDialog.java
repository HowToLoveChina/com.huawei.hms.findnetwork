package com.huawei.android.remotecontrol.p093ui.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.android.remotecontrol.p093ui.activation.OOBEPhoneFinderActivity;
import com.huawei.android.remotecontrol.sdk.R$string;
import hu.C10343b;
import p514o9.C11829c;
import p514o9.C11842p;

/* loaded from: classes4.dex */
public class BetaDialog extends DialogFragment implements DialogInterface.OnClickListener {
    public static final String IS_PWD = "is_pwd";
    private boolean mIsPassword;
    private OOBEPhoneFinderActivity mOOBEPhoneFinderActivity;

    public static BetaDialog newInstances(boolean z10) {
        BetaDialog betaDialog = new BetaDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_PWD, z10);
        betaDialog.setArguments(bundle);
        return betaDialog;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OOBEPhoneFinderActivity) {
            this.mOOBEPhoneFinderActivity = (OOBEPhoneFinderActivity) activity;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        dialogInterface.cancel();
        OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.mOOBEPhoneFinderActivity;
        if (oOBEPhoneFinderActivity != null && this.mIsPassword) {
            oOBEPhoneFinderActivity.m27613b();
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        this.mIsPassword = new C10343b(arguments).m63681c(IS_PWD);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R$string.beta_title);
        builder.setMessage(this.mIsPassword ? R$string.beta_message_password : C11842p.m70762R0() ? R$string.beta_message_pad : R$string.beta_message);
        builder.setPositiveButton(R$string.beta_ok, this);
        AlertDialog alertDialogCreate = builder.create();
        C11829c.m70594l1(getActivity(), alertDialogCreate);
        return alertDialogCreate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        this.mOOBEPhoneFinderActivity = null;
        super.onDetach();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OOBEPhoneFinderActivity oOBEPhoneFinderActivity = this.mOOBEPhoneFinderActivity;
        if (oOBEPhoneFinderActivity == null) {
            return;
        }
        C11829c.m70585i1(oOBEPhoneFinderActivity.getWindow());
    }
}
