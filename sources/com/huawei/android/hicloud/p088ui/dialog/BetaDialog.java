package com.huawei.android.hicloud.p088ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hicloud.sync.R$string;
import p514o9.C11829c;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class BetaDialog extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: c */
    public static int f17863c = 1;

    /* renamed from: a */
    public boolean f17864a;

    /* renamed from: b */
    public BetaDialogInterface f17865b;

    /* renamed from: a */
    public static BetaDialog m23933a(boolean z10) {
        BetaDialog betaDialog = new BetaDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("has_lock_screen", z10);
        betaDialog.setArguments(bundle);
        return betaDialog;
    }

    /* renamed from: b */
    public static BetaDialog m23934b(boolean z10, int i10) {
        f17863c = i10;
        return m23933a(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BetaDialogInterface) {
            this.f17865b = (BetaDialogInterface) activity;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        dialogInterface.cancel();
        BetaDialogInterface betaDialogInterface = this.f17865b;
        if (betaDialogInterface != null && this.f17864a) {
            betaDialogInterface.mo16966b();
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        this.f17864a = arguments.getBoolean("has_lock_screen");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R$string.beta_title);
        builder.setMessage(this.f17864a ? R$string.beta_message_password : C11842p.m70762R0() ? R$string.beta_message_pad : R$string.beta_message);
        builder.setPositiveButton(R$string.beta_ok, this);
        AlertDialog alertDialogCreate = builder.create();
        C11829c.m70594l1(getActivity(), alertDialogCreate);
        return alertDialogCreate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDetach() {
        this.f17865b = null;
        super.onDetach();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        BetaDialogInterface betaDialogInterface = this.f17865b;
        if (betaDialogInterface != null && f17863c == 1) {
            C11829c.m70585i1(betaDialogInterface.getWindow());
        }
    }
}
