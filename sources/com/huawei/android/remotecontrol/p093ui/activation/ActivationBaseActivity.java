package com.huawei.android.remotecontrol.p093ui.activation;

import android.R;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.phone.hwcheckbox.widget.HwCheckBox;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import p015ak.C0209d;
import p514o9.C11829c;
import p514o9.C11842p;
import p521og.C11880m;
import p664u0.C13108a;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public abstract class ActivationBaseActivity extends OOBEPhoneFinderBaseActivity {

    /* renamed from: C */
    public ProgressDialog f20540C;

    /* renamed from: D */
    public ErrorDialog f20541D;

    /* renamed from: E */
    public TextView f20542E;

    /* renamed from: F */
    public EditText f20543F = null;

    /* renamed from: G */
    public HwCheckBox f20544G;

    public static class ErrorDialog extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.cancel();
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return null;
            }
            int i10 = arguments.getInt("title_id");
            int i11 = arguments.getInt("message_id");
            String string = arguments.getString("message");
            int i12 = arguments.getInt("button_patter", -1);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            if (i10 > 0) {
                builder.setTitle(i10);
            }
            if (string == null || string.isEmpty()) {
                builder.setMessage(i11);
            } else {
                builder.setMessage(string);
            }
            if (i12 == -1) {
                builder.setPositiveButton(R.string.ok, this);
            } else {
                builder.setPositiveButton(R$string.alarm_msg_positive_btn, this);
            }
            AlertDialog alertDialogCreate = builder.create();
            C11829c.m70594l1(getActivity(), alertDialogCreate);
            return alertDialogCreate;
        }
    }

    public static class LogOffReceive extends BroadcastReceiver {

        /* renamed from: a */
        public boolean f20545a;

        /* renamed from: a */
        public void m27267a(Context context) {
            if (this.f20545a) {
                C13981a.m83988e("ActivationBaseActivity", "LogOffReceive--register error");
                return;
            }
            this.f20545a = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_COMPLETED");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_LOGOFF_DEREGISTRATION_FAIL");
            intentFilter.addAction("com.huawei.android.hicloud.intent.PHONEFINDER_CLOSE_AUTH_FAILE");
            C13108a.m78878b(context.getApplicationContext()).m78880c(this, intentFilter);
        }

        /* renamed from: b */
        public void m27268b(Context context) {
            if (!this.f20545a) {
                C13981a.m83988e("ActivationBaseActivity", "LogOffReceive--register error:registerFlag=false");
            } else {
                C13108a.m78878b(context.getApplicationContext()).m78883f(this);
                this.f20545a = false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C13981a.m83988e("ActivationBaseActivity", "mLogoffReceiver intent is null");
                return;
            }
            if (intent.getAction() == null) {
                C13981a.m83988e("ActivationBaseActivity", "mLogoffReceiver action is null");
                return;
            }
            m27268b(context);
            C13981a.m83987d("ActivationBaseActivity", "mLogoffReceiver intent action = " + intent.getAction());
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationBaseActivity$b */
    public static class ActionModeCallbackC4477b implements ActionMode.Callback {
        public ActionModeCallbackC4477b() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationBaseActivity$c */
    public static class C4478c extends PasswordTransformationMethod {

        /* renamed from: com.huawei.android.remotecontrol.ui.activation.ActivationBaseActivity$c$a */
        public static class a implements CharSequence {

            /* renamed from: a */
            public CharSequence f20546a;

            /* renamed from: b */
            public final boolean f20547b;

            public a(CharSequence charSequence) {
                this.f20547b = 1 == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault());
                this.f20546a = charSequence;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f20547b ? '*' : (char) 8226;
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f20546a.length();
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return this.f20546a.subSequence(i10, i11);
            }
        }

        public C4478c() {
        }

        @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            return new a(charSequence);
        }
    }

    /* renamed from: S0 */
    public static int m27248S0(int i10) {
        if (i10 == 1) {
            return R$string.activate_error_too_many_times;
        }
        if (i10 == 2) {
            return R$string.activate_error_timeout_please_retry;
        }
        if (i10 == 3) {
            return R$string.connect_server_fail_msg1;
        }
        if (i10 == 101) {
            return R$string.activate_error_request;
        }
        if (i10 == 405) {
            return R$string.close_finder_fail_dialog_content;
        }
        if (i10 == 202) {
            return R$string.activate_error_need_request;
        }
        if (i10 == 203) {
            return R$string.activate_error_overdue;
        }
        if (i10 == 401) {
            return R$string.activate_error_timeout_please_retry;
        }
        if (i10 == 402) {
            return R$string.activate_error_logoff;
        }
        switch (i10) {
            case ErrorCode.ERROR_CODE_NO_SDKVERSION /* 407 */:
                return R$string.activate_error_cannot_conn_server;
            case 408:
                return R$string.activate_error_lockscreen_invalid;
            case 409:
                return R$string.activate_error_lockscreen_invalid_new;
            default:
                C13981a.m83990w("ActivationBaseActivity", "cannot get message " + i10);
                return 0;
        }
    }

    /* renamed from: T0 */
    public static int m27249T0(int i10) {
        if (i10 == 1) {
            return R$string.activate_error_lockscreen_invalid_title;
        }
        C13981a.m83990w("ActivationBaseActivity", "cannot get titleId " + i10);
        return 0;
    }

    /* renamed from: V0 */
    private void m27250V0() {
        String strMo27240R0 = mo27240R0();
        if (strMo27240R0 == null) {
            strMo27240R0 = "";
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(strMo27240R0);
        }
    }

    /* renamed from: a1 */
    private void m27251a1() {
        ViewGroup viewGroup = (ViewGroup) C12809f.m76829b(this, R$id.avtivation_main_layout);
        if (viewGroup == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).setMargins(0, C11842p.m70852q(this) + C11842p.m70789a0(this), 0, 0);
        }
    }

    /* renamed from: b1 */
    private void m27252b1() {
        if (this.f12341a == 2) {
            setRequestedOrientation(1);
            return;
        }
        if (C11842p.m70771U0()) {
            setRequestedOrientation(-1);
            return;
        }
        if (C11842p.m70747M0(this)) {
            setRequestedOrientation(-1);
        } else if (C11842p.m70735I0()) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: B0 */
    public void mo16553B0() {
        m27252b1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: E0 */
    public void mo16659E0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: F0 */
    public void mo16660F0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: G0 */
    public void mo16661G0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: H0 */
    public int mo16662H0() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: I0 */
    public int mo16663I0() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: J0 */
    public int mo16664J0() {
        return mo16578c();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: K0 */
    public void mo16665K0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity
    /* renamed from: L0 */
    public void mo16666L0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
        if (mo27257W0()) {
            super.mo16566O();
        } else {
            m27251a1();
        }
    }

    /* renamed from: O0 */
    public final void m27253O0() {
        if (this.f20543F == null) {
            return;
        }
        this.f20543F.setCustomSelectionActionModeCallback(new ActionModeCallbackC4477b());
    }

    /* renamed from: P0 */
    public void m27254P0() {
        ProgressDialog progressDialog = this.f20540C;
        if (progressDialog != null) {
            progressDialog.cancel();
            this.f20540C = null;
        }
    }

    /* renamed from: Q0 */
    public final void m27255Q0() {
        ErrorDialog errorDialog = this.f20541D;
        if (errorDialog != null) {
            errorDialog.dismissAllowingStateLoss();
            this.f20541D = null;
        }
    }

    /* renamed from: R0 */
    public abstract String mo27240R0();

    /* renamed from: U0 */
    public void m27256U0() {
        this.f20543F = (EditText) C12809f.m76829b(this, R$id.activation_password);
        m27253O0();
        HwCheckBox hwCheckBox = (HwCheckBox) C12809f.m76829b(this, R$id.activation_password_eye);
        this.f20544G = hwCheckBox;
        if (hwCheckBox != null) {
            hwCheckBox.setOnClickListener(this);
        }
        m27266h1(false);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.activation_cancel);
        this.f20542E = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    /* renamed from: W0 */
    public boolean mo27257W0() {
        return false;
    }

    /* renamed from: X0 */
    public void m27258X0() {
        C11880m.m71337d(this, getString(R$string.net_err_tip_no_net));
    }

    /* renamed from: Y0 */
    public void mo27259Y0(boolean z10) {
        C13981a.m83989i("ActivationBaseActivity", "onBack isActivated = " + z10);
        setResult(z10 ? -1 : 0);
        finish();
    }

    /* renamed from: Z0 */
    public void m27260Z0() {
        HwCheckBox hwCheckBox = this.f20544G;
        if (hwCheckBox != null) {
            hwCheckBox.setChecked(!hwCheckBox.isChecked());
        }
    }

    /* renamed from: c1 */
    public void m27261c1() {
        m27254P0();
        ProgressDialog progressDialogShow = ProgressDialog.show(this, "", getString(R$string.activate_progress), true, false);
        this.f20540C = progressDialogShow;
        m16607r0(progressDialogShow);
        this.f20540C.show();
    }

    /* renamed from: d1 */
    public void m27262d1(int i10) {
        m27264f1(i10, 0, -1);
    }

    /* renamed from: e1 */
    public void m27263e1(int i10, int i11) throws Resources.NotFoundException {
        ErrorDialog errorDialog = this.f20541D;
        if (errorDialog != null && errorDialog.isVisible()) {
            C13981a.m83988e("ActivationBaseActivity", "showError isVisible");
            return;
        }
        if (isFinishing()) {
            C13981a.m83988e("ActivationBaseActivity", "showError isFinishing");
            return;
        }
        int iM27248S0 = m27248S0(i10);
        String str = ((getResources().getString(iM27248S0) + " (") + i11) + ")";
        if (iM27248S0 > 0) {
            try {
                this.f20541D = new ErrorDialog();
                Bundle bundle = new Bundle();
                bundle.putInt("title_id", 0);
                bundle.putString("message", str);
                this.f20541D.setArguments(bundle);
                this.f20541D.show(getFragmentManager(), VastAttribute.ERROR);
            } catch (Exception e10) {
                C13981a.m83988e("ActivationBaseActivity", "showError exception" + e10.getMessage());
            }
        }
    }

    /* renamed from: f1 */
    public void m27264f1(int i10, int i11, int i12) {
        ErrorDialog errorDialog = this.f20541D;
        if (errorDialog != null && errorDialog.isVisible()) {
            C13981a.m83988e("ActivationBaseActivity", "showError isVisible");
            return;
        }
        if (isFinishing()) {
            C13981a.m83988e("ActivationBaseActivity", "showError isFinishing");
            return;
        }
        int iM27249T0 = m27249T0(i11);
        int iM27248S0 = m27248S0(i10);
        if (iM27248S0 > 0) {
            try {
                this.f20541D = new ErrorDialog();
                Bundle bundle = new Bundle();
                bundle.putInt("title_id", iM27249T0);
                bundle.putInt("message_id", iM27248S0);
                bundle.putInt("button_patter", i12);
                this.f20541D.setArguments(bundle);
                this.f20541D.show(getFragmentManager(), VastAttribute.ERROR);
            } catch (Exception e10) {
                C13981a.m83988e("ActivationBaseActivity", "showError exception" + e10.getMessage());
            }
        }
    }

    /* renamed from: g1 */
    public void m27265g1() {
        boolean zBooleanValue;
        HwCheckBox hwCheckBox = this.f20544G;
        if (hwCheckBox == null) {
            return;
        }
        try {
            zBooleanValue = ((Boolean) hwCheckBox.getTag()).booleanValue();
        } catch (RuntimeException e10) {
            C13981a.m83990w("ActivationBaseActivity", "updatePasswordState" + e10.getMessage());
            zBooleanValue = false;
        }
        m27266h1(!zBooleanValue);
    }

    /* renamed from: h1 */
    public void m27266h1(boolean z10) {
        EditText editText = this.f20543F;
        if (editText != null) {
            if (z10) {
                editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                editText.setTransformationMethod(new C4478c());
            }
            try {
                EditText editText2 = this.f20543F;
                editText2.setSelection(editText2.getText().toString().length());
            } catch (Exception e10) {
                C13981a.m83988e("ActivationBaseActivity", "updatePasswordState" + e10.getMessage());
            }
        }
        if (this.f20544G != null) {
            if (C0209d.m1281m1()) {
                this.f20544G.setButtonDrawable(R$drawable.pf_box_pwd_eye_honor);
            } else {
                this.f20544G.setButtonDrawable(R$drawable.pf_box_pwd_eye);
            }
            this.f20544G.setTag(Boolean.valueOf(z10));
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.activation_cancel) {
            mo27259Y0(false);
        } else if (id2 == R$id.activation_password_eye) {
            m27265g1();
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C13981a.m83989i("ActivationBaseActivity", "onCreate " + getClass().getSimpleName());
        m27250V0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("ActivationBaseActivity", "onDestroy " + getClass().getSimpleName());
        m27255Q0();
        m27254P0();
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: q0 */
    public void mo16605q0() {
        m27252b1();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        m16617w0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y0 */
    public void mo16620y0() {
    }
}
