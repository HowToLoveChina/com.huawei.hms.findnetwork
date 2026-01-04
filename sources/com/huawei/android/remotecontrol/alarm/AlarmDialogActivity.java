package com.huawei.android.remotecontrol.alarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.android.remotecontrol.alarm.AlarmDialogActivity;
import com.huawei.android.remotecontrol.sdk.R$dimen;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.track.C4452n;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0224k0;
import p015ak.C0234s;
import p514o9.C11829c;
import p514o9.C11842p;
import p664u0.C13108a;
import p809yg.C13981a;
import se.C12785g;

/* loaded from: classes4.dex */
public class AlarmDialogActivity extends Activity {

    /* renamed from: a */
    public C4321b f19718a;

    public static class CloseAlarmDialog extends DialogFragment implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public DialogInterface.OnKeyListener f19719a = new DialogInterface.OnKeyListener() { // from class: se.c
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return AlarmDialogActivity.CloseAlarmDialog.m25977b(dialogInterface, i10, keyEvent);
            }
        };

        /* renamed from: b */
        public static /* synthetic */ boolean m25977b(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            return (i10 == 4 && keyEvent.getRepeatCount() == 0) || i10 == 25 || i10 == 24 || i10 == 82;
        }

        /* renamed from: c */
        public final void m25978c(Dialog dialog) {
            WindowManager.LayoutParams attributes;
            int paddingLeft;
            if (dialog == null) {
                return;
            }
            dialog.show();
            Window window = dialog.getWindow();
            if (window != null) {
                attributes = window.getAttributes();
                paddingLeft = window.getDecorView().getPaddingLeft();
            } else {
                attributes = null;
                paddingLeft = 0;
            }
            if (attributes != null) {
                int iM70758Q = C11842p.m70758Q(getActivity());
                int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.cloud_space_328_dp) + (paddingLeft * 2);
                if (dimensionPixelSize <= iM70758Q) {
                    C13981a.m83987d("AlarmDialogActivity", "setDialogWidth, set maxwidth");
                    attributes.width = dimensionPixelSize;
                    window.setAttributes(attributes);
                }
            }
        }

        @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            Activity activity = getActivity();
            if (activity != null) {
                AlarmDialogActivity alarmDialogActivity = (AlarmDialogActivity) activity;
                alarmDialogActivity.m25971c();
                alarmDialogActivity.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -2) {
                dialogInterface.cancel();
            }
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) throws Resources.NotFoundException {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            String string = getActivity().getResources().getString(R$string.alarm_msg_default_new);
            builder.setMessage(string).setNegativeButton(getActivity().getResources().getString(R$string.alarm_msg_positive_btn_new), this).setCancelable(false).setOnKeyListener(this.f19719a);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            m25978c(alertDialogCreate);
            return alertDialogCreate;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.alarm.AlarmDialogActivity$b */
    public class C4321b extends BroadcastReceiver {
        public C4321b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C13981a.m83989i("AlarmDialogActivity", "FinishActivityReceiver onReceive");
            if ("action_finish_alarm_dialog".equals(new SafeIntent(intent).getAction())) {
                AlarmDialogActivity.this.finish();
            }
        }

        public /* synthetic */ C4321b(AlarmDialogActivity alarmDialogActivity, C4320a c4320a) {
            this();
        }
    }

    /* renamed from: c */
    public final void m25971c() {
        C13981a.m83989i("AlarmDialogActivity", "finishAlarm");
        if (!C0224k0.m1532B(this)) {
            C13981a.m83987d("AlarmDialogActivity", "finishAlarm in sub user");
            sendBroadcastAsUser(new Intent("action_alarm_dialog_on_destroy"), UserHandle.getUserHandleForUid(0), "com.huawei.remotocontrol.permission.REMOTECALL");
        }
        C12785g.m76715s().m76739q();
    }

    /* renamed from: d */
    public final /* synthetic */ void m25972d(int i10) {
        C11829c.m70585i1(getWindow());
        C11829c.m70633y1(getApplicationContext(), getWindow());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (4 == keyEvent.getKeyCode() || 82 == keyEvent.getKeyCode() || 25 == keyEvent.getKeyCode() || 24 == keyEvent.getKeyCode()) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: e */
    public final void m25973e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_finish_alarm_dialog");
        C13108a.m78878b(this).m78880c(this.f19718a, intentFilter);
    }

    /* renamed from: f */
    public final void m25974f() {
        C11829c.m70585i1(getWindow());
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: se.b
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i10) {
                this.f58433a.m25972d(i10);
            }
        });
        C11829c.m70633y1(this, getWindow());
    }

    /* renamed from: g */
    public final void m25975g() {
        CloseAlarmDialog closeAlarmDialog;
        try {
            closeAlarmDialog = (CloseAlarmDialog) getFragmentManager().findFragmentByTag("AlarmDialogActivity");
        } catch (ClassCastException e10) {
            C13981a.m83989i("AlarmDialogActivity", "show CloseAlarmDialog error: " + e10.getMessage());
            closeAlarmDialog = null;
        }
        if (closeAlarmDialog == null) {
            new CloseAlarmDialog().show(getFragmentManager(), "AlarmDialogActivity");
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("AlarmDialogActivity", "onCreate AlarmDialogActivity");
        super.onCreate(bundle);
        requestWindowFeature(1);
        C0224k0.m1541K(getWindow(), false);
        if (new SafeIntent(getIntent()).getBooleanExtra("full_screen", true)) {
            getWindow().addFlags(2098304);
        } else {
            getWindow().addFlags(2097280);
        }
        getWindow().setType(2003);
        this.f19718a = new C4321b();
        m25973e();
        if (C0224k0.m1532B(this)) {
            return;
        }
        C12785g.m76715s().m76724H();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("AlarmDialogActivity", "onDestroy");
        boolean zM27030j = C4452n.m27030j(this);
        C13981a.m83987d("AlarmDialogActivity", "onDestroy, screen is lock: " + zM27030j);
        if (!zM27030j && C12785g.m76715s().m76740r()) {
            m25971c();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        C13981a.m83989i("AlarmDialogActivity", "onResume");
        super.onResume();
        m25974f();
        m25975g();
    }
}
