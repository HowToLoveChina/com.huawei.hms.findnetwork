package com.huawei.hms.p148ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;

/* loaded from: classes8.dex */
public abstract class AbstractDialog {

    /* renamed from: a */
    private Activity f30123a;

    /* renamed from: b */
    private AlertDialog f30124b;

    /* renamed from: c */
    private Callback f30125c;

    public interface Callback {
        void onCancel(AbstractDialog abstractDialog);

        void onDoWork(AbstractDialog abstractDialog);
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$a */
    public class DialogInterfaceOnClickListenerC6510a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC6510a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AbstractDialog.this.fireDoWork();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$b */
    public class DialogInterfaceOnClickListenerC6511b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC6511b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AbstractDialog.this.cancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$c */
    public class DialogInterfaceOnCancelListenerC6512c implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC6512c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            AbstractDialog.this.fireCancel();
        }
    }

    /* renamed from: com.huawei.hms.ui.AbstractDialog$d */
    public class DialogInterfaceOnKeyListenerC6513d implements DialogInterface.OnKeyListener {
        public DialogInterfaceOnKeyListenerC6513d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (4 != i10 || keyEvent.getAction() != 1) {
                return false;
            }
            AbstractDialog.this.cancel();
            return true;
        }
    }

    public void cancel() {
        AlertDialog alertDialog = this.f30124b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f30124b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f30124b.dismiss();
    }

    public void fireCancel() {
        Callback callback = this.f30125c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    public void fireDoWork() {
        Callback callback = this.f30125c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    public Activity getActivity() {
        return this.f30123a;
    }

    public int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    public AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String strOnGetTitleString = onGetTitleString(activity);
        if (strOnGetTitleString != null) {
            builder.setTitle(strOnGetTitleString);
        }
        String strOnGetMessageString = onGetMessageString(activity);
        if (strOnGetMessageString != null) {
            builder.setMessage(strOnGetMessageString);
        }
        String strOnGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (strOnGetPositiveButtonString != null) {
            builder.setPositiveButton(strOnGetPositiveButtonString, new DialogInterfaceOnClickListenerC6510a());
        }
        String strOnGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (strOnGetNegativeButtonString != null) {
            builder.setNegativeButton(strOnGetNegativeButtonString, new DialogInterfaceOnClickListenerC6511b());
        }
        return builder.create();
    }

    public abstract String onGetMessageString(Context context);

    public abstract String onGetNegativeButtonString(Context context);

    public abstract String onGetPositiveButtonString(Context context);

    public abstract String onGetTitleString(Context context);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.f30124b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.f30124b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, Callback callback) {
        this.f30123a = activity;
        this.f30125c = callback;
        if (activity == null || activity.isFinishing()) {
            HMSLog.m36986e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        AlertDialog alertDialogOnCreateDialog = onCreateDialog(this.f30123a);
        this.f30124b = alertDialogOnCreateDialog;
        alertDialogOnCreateDialog.setCanceledOnTouchOutside(false);
        this.f30124b.setOnCancelListener(new DialogInterfaceOnCancelListenerC6512c());
        this.f30124b.setOnKeyListener(new DialogInterfaceOnKeyListenerC6513d());
        UIUtil.enableFocusedForButtonsInTV(this.f30124b);
        this.f30124b.show();
    }
}
