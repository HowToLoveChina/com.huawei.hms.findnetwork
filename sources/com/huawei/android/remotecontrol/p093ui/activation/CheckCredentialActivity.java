package com.huawei.android.remotecontrol.p093ui.activation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c;
import androidx.fragment.app.FragmentActivity;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import p015ak.C0209d;
import p514o9.C11829c;
import p521og.C11868a;
import p577qg.C12354d;
import p809yg.C13981a;
import sk.C12808e;

/* loaded from: classes4.dex */
public class CheckCredentialActivity extends FragmentActivity {

    /* renamed from: A */
    public boolean f20650A;

    /* renamed from: B */
    public String f20651B;

    /* renamed from: C */
    public String f20652C;

    /* renamed from: D */
    public String f20653D;

    /* renamed from: E */
    public String f20654E;

    /* renamed from: F */
    public String f20655F;

    /* renamed from: G */
    public String f20656G;

    /* renamed from: H */
    public String f20657H;

    /* renamed from: I */
    public DialogInterfaceOnClickListenerC4499a f20658I;

    /* renamed from: J */
    public DialogInterfaceOnClickListenerC4500b f20659J;

    /* renamed from: K */
    public DialogInterfaceOnClickListenerC4501c f20660K;

    /* renamed from: L */
    public boolean f20661L = false;

    /* renamed from: y */
    public boolean f20662y;

    /* renamed from: z */
    public boolean f20663z;

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckCredentialActivity$a */
    public static class DialogInterfaceOnClickListenerC4499a extends DialogInterfaceOnCancelListenerC0738c implements DialogInterface.OnClickListener {
        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c
        /* renamed from: J1 */
        public Dialog mo4702J1(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(m4400f()).setTitle(R$string.pf_activation_tilte).setMessage(R$string.pf_activation_msg).setPositiveButton(R$string.pf_activation_verify, this).setNegativeButton(R$string.pf_activation_cancel, this).create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            C11829c.m70594l1(m4400f(), alertDialogCreate);
            return alertDialogCreate;
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onCancel(dialogInterface);
            FragmentActivity fragmentActivityM4400f = m4400f();
            if (fragmentActivityM4400f instanceof CheckCredentialActivity) {
                C12354d.m74329E(1004, "");
                CheckCredentialActivity checkCredentialActivity = (CheckCredentialActivity) fragmentActivityM4400f;
                checkCredentialActivity.f20661L = true;
                checkCredentialActivity.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, JSONException, IllegalArgumentException, InvocationTargetException {
            if (i10 == -2) {
                C13981a.m83989i("CheckCredentialActivity", "cancel");
                C12354d.m74356v("checkCredentialDialogClick", "fail", "cancel");
                dialogInterface.cancel();
                return;
            }
            if (i10 != -1) {
                return;
            }
            if (C0209d.m1226Y0()) {
                C13981a.m83990w("CheckCredentialActivity", "fast click!!!");
                return;
            }
            dialogInterface.dismiss();
            FragmentActivity fragmentActivityM4400f = m4400f();
            if (fragmentActivityM4400f == null) {
                C13981a.m83990w("CheckCredentialActivity", "activity null");
                return;
            }
            CheckCredentialActivity checkCredentialActivity = (CheckCredentialActivity) fragmentActivityM4400f;
            checkCredentialActivity.f20661L = true;
            if (!C0209d.m1333z1(checkCredentialActivity)) {
                C13981a.m83989i("CheckCredentialActivity", "network disconnected");
                C11829c.m70612r1(fragmentActivityM4400f);
                C12354d.m74329E(1002, "");
                checkCredentialActivity.finish();
                return;
            }
            try {
                Intent intent = new Intent(checkCredentialActivity, (Class<?>) ActivationLockCredentialActivity.class);
                intent.putExtra("showErrorPage", checkCredentialActivity.f20662y);
                intent.putExtra(JsbMapKeyNames.H5_USER_ID, checkCredentialActivity.f20651B);
                intent.putExtra("parentUid", checkCredentialActivity.f20652C);
                intent.putExtra(HwPayConstant.KEY_SITE_ID, checkCredentialActivity.f20655F);
                intent.putExtra("deviceId", checkCredentialActivity.f20653D);
                intent.putExtra(JsbMapKeyNames.H5_DEVICE_TYPE, checkCredentialActivity.f20654E);
                intent.putExtra("accountName", checkCredentialActivity.f20656G);
                intent.putExtra("parentAccountName", checkCredentialActivity.f20657H);
                checkCredentialActivity.startActivity(intent);
                checkCredentialActivity.finish();
            } catch (Exception e10) {
                C13981a.m83989i("CheckCredentialActivity", "startActivity exception" + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckCredentialActivity$b */
    public static class DialogInterfaceOnClickListenerC4500b extends DialogInterfaceOnCancelListenerC0738c implements DialogInterface.OnClickListener {
        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c
        /* renamed from: J1 */
        public Dialog mo4702J1(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(m4400f()).setTitle(R$string.pf_activation_tilte).setMessage(R$string.pf_activation_tip_network_dialog).setPositiveButton(R$string.cloudpay_estimate_dialog_positive, this).create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            C11829c.m70594l1(m4400f(), alertDialogCreate);
            return alertDialogCreate;
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onCancel(dialogInterface);
            FragmentActivity fragmentActivityM4400f = m4400f();
            C12354d.m74329E(1002, "");
            if (fragmentActivityM4400f instanceof CheckCredentialActivity) {
                ((CheckCredentialActivity) fragmentActivityM4400f).finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws IllegalAccessException, JSONException, IllegalArgumentException, InvocationTargetException {
            if (i10 != -1) {
                return;
            }
            C13981a.m83989i("CheckCredentialActivity", "ok");
            if (C0209d.m1226Y0()) {
                C13981a.m83990w("CheckCredentialActivity", "fast click!!!");
                return;
            }
            dialogInterface.dismiss();
            C12354d.m74329E(1002, "");
            FragmentActivity fragmentActivityM4400f = m4400f();
            if (fragmentActivityM4400f instanceof CheckCredentialActivity) {
                ((CheckCredentialActivity) fragmentActivityM4400f).finish();
            }
            C12354d.m74356v("checkCredentialDialogClick", "fail", "ok");
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.ui.activation.CheckCredentialActivity$c */
    public static class DialogInterfaceOnClickListenerC4501c extends DialogInterfaceOnCancelListenerC0738c implements DialogInterface.OnClickListener {
        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c
        /* renamed from: J1 */
        public Dialog mo4702J1(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(m4400f()).setTitle(R$string.pf_activation_tilte).setMessage(R$string.pf_activation_tip_assistance_dialog).setPositiveButton(R$string.cloudpay_estimate_dialog_positive, this).create();
            alertDialogCreate.setCanceledOnTouchOutside(false);
            C11829c.m70594l1(m4400f(), alertDialogCreate);
            return alertDialogCreate;
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0738c, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C13981a.m83989i("CheckCredentialActivity", "SocIdErrorDialog, onCancel.");
            super.onCancel(dialogInterface);
            FragmentActivity fragmentActivityM4400f = m4400f();
            if (fragmentActivityM4400f instanceof CheckCredentialActivity) {
                fragmentActivityM4400f.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C13981a.m83989i("CheckCredentialActivity", "SocIdErrorDialog, click ok.");
            FragmentActivity fragmentActivityM4400f = m4400f();
            if (fragmentActivityM4400f instanceof CheckCredentialActivity) {
                fragmentActivityM4400f.finish();
            }
        }
    }

    /* renamed from: m0 */
    private void m27442m0() throws JSONException {
        C13981a.m83989i("CheckCredentialActivity", "showDialog");
        try {
            this.f20658I = (DialogInterfaceOnClickListenerC4499a) m4473U().m4571i0("confirm");
        } catch (ClassCastException e10) {
            C13981a.m83989i("CheckCredentialActivity", "showDialog exception:" + e10.getMessage());
            this.f20658I = null;
        }
        if (this.f20658I == null) {
            DialogInterfaceOnClickListenerC4499a dialogInterfaceOnClickListenerC4499a = new DialogInterfaceOnClickListenerC4499a();
            this.f20658I = dialogInterfaceOnClickListenerC4499a;
            dialogInterfaceOnClickListenerC4499a.m4708P1(m4473U(), "confirm");
        }
        C12354d.m74354t("showDialog");
    }

    @Override // android.app.Activity
    public void finish() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.finish();
        new HwAnimationReflection(this).m15927c(0);
    }

    /* renamed from: l0 */
    public final void m27443l0() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f20662y = safeIntent.getBooleanExtra("showErrorPage", false);
        this.f20663z = safeIntent.getBooleanExtra("showTaErrorPage", false);
        this.f20650A = safeIntent.getBooleanExtra("showNetworkError", false);
        this.f20651B = safeIntent.getStringExtra(JsbMapKeyNames.H5_USER_ID);
        this.f20652C = safeIntent.getStringExtra("parentUid");
        this.f20653D = safeIntent.getStringExtra("deviceId");
        this.f20654E = safeIntent.getStringExtra(JsbMapKeyNames.H5_DEVICE_TYPE);
        this.f20655F = safeIntent.getStringExtra(HwPayConstant.KEY_SITE_ID);
        this.f20656G = safeIntent.getStringExtra("accountName");
        this.f20657H = safeIntent.getStringExtra("parentAccountName");
    }

    /* renamed from: n0 */
    public final void m27444n0() throws JSONException {
        C13981a.m83989i("CheckCredentialActivity", "showNetWorkDialog");
        try {
            this.f20659J = (DialogInterfaceOnClickListenerC4500b) m4473U().m4571i0("confirm_network");
        } catch (ClassCastException e10) {
            C13981a.m83989i("CheckCredentialActivity", "showNetWorkDialog exception:" + e10.getMessage());
            this.f20659J = null;
        }
        if (this.f20659J == null) {
            DialogInterfaceOnClickListenerC4500b dialogInterfaceOnClickListenerC4500b = new DialogInterfaceOnClickListenerC4500b();
            this.f20659J = dialogInterfaceOnClickListenerC4500b;
            dialogInterfaceOnClickListenerC4500b.m4708P1(m4473U(), "confirm_network");
        }
        C12354d.m74354t("showNetWorkDialog");
    }

    /* renamed from: o0 */
    public final void m27445o0() throws JSONException {
        C13981a.m83989i("CheckCredentialActivity", "showSocIdErrorDialog");
        try {
            this.f20660K = (DialogInterfaceOnClickListenerC4501c) m4473U().m4571i0("socId_origin_error");
        } catch (ClassCastException e10) {
            C13981a.m83989i("CheckCredentialActivity", "showSocIdErrorDialog exception:" + e10.getMessage());
            this.f20660K = null;
        }
        if (this.f20660K == null) {
            DialogInterfaceOnClickListenerC4501c dialogInterfaceOnClickListenerC4501c = new DialogInterfaceOnClickListenerC4501c();
            this.f20660K = dialogInterfaceOnClickListenerC4501c;
            dialogInterfaceOnClickListenerC4501c.m4708P1(m4473U(), "socId_origin_error");
        }
        C12354d.m74354t("showSocIdErrorDialog");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11868a.m71128d().m71129a(this);
        C13981a.m83989i("CheckCredentialActivity", "onCreate");
        C12808e.m76824c(this);
        m27443l0();
        C13981a.m83989i("CheckCredentialActivity", "onCreate, isShowNetworkError: " + this.f20650A + ", isShowTaErrorDialog: " + this.f20663z);
        if (this.f20650A) {
            m27444n0();
        } else if (this.f20663z) {
            m27445o0();
        } else {
            m27442m0();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C13981a.m83989i("CheckCredentialActivity", "onDestroy");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13981a.m83989i("CheckCredentialActivity", "onResume");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("CheckCredentialActivity", "onStop");
        DialogInterfaceOnClickListenerC4499a dialogInterfaceOnClickListenerC4499a = this.f20658I;
        if (dialogInterfaceOnClickListenerC4499a != null) {
            dialogInterfaceOnClickListenerC4499a.m4698F1();
            this.f20658I = null;
        }
        DialogInterfaceOnClickListenerC4500b dialogInterfaceOnClickListenerC4500b = this.f20659J;
        if (dialogInterfaceOnClickListenerC4500b != null) {
            dialogInterfaceOnClickListenerC4500b.m4698F1();
            this.f20659J = null;
        }
        DialogInterfaceOnClickListenerC4501c dialogInterfaceOnClickListenerC4501c = this.f20660K;
        if (dialogInterfaceOnClickListenerC4501c != null) {
            dialogInterfaceOnClickListenerC4501c.m4698F1();
            this.f20660K = null;
        }
        if (!this.f20661L) {
            C12354d.m74329E(1004, "");
            finish();
        }
        if (this.f20650A) {
            C12354d.m74329E(1002, "");
            finish();
        }
        super.onStop();
    }
}
