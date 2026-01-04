package com.huawei.android.hicloud.p088ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TermsOfAgreementDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TermsOfPrivacyNoticeDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.TermsOfServiceDialog;
import com.huawei.android.p073ds.R$anim;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0234s;
import p514o9.C11839m;
import p681uj.C13195l;
import p684un.C13223b;
import p684un.C13227f;
import p709vj.C13452e;
import sk.C12808e;

/* loaded from: classes3.dex */
public class AuthorizationAlertActitivty extends AuthCallbackActivity {

    /* renamed from: s */
    public long f13534s;

    /* renamed from: l */
    public Context f13527l = null;

    /* renamed from: m */
    public String f13528m = null;

    /* renamed from: n */
    public AlertDialog f13529n = null;

    /* renamed from: o */
    public TermsOfPrivacyNoticeDialog f13530o = null;

    /* renamed from: p */
    public TermsOfAgreementDialog f13531p = null;

    /* renamed from: q */
    public boolean f13532q = false;

    /* renamed from: r */
    public boolean f13533r = false;

    /* renamed from: t */
    public DialogInterface.OnClickListener f13535t = new DialogInterfaceOnClickListenerC3124a();

    /* renamed from: com.huawei.android.hicloud.ui.activity.AuthorizationAlertActitivty$a */
    public class DialogInterfaceOnClickListenerC3124a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3124a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -2) {
                if (AuthorizationAlertActitivty.this.f13531p == null || !AuthorizationAlertActitivty.this.f13531p.isShowing()) {
                    AuthorizationAlertActitivty.this.f13532q = true;
                    AuthorizationAlertActitivty.this.m18594n1();
                    return;
                } else {
                    AuthorizationAlertActitivty.this.m18594n1();
                    AuthorizationAlertActitivty.this.f13530o = new TermsOfPrivacyNoticeDialog(AuthorizationAlertActitivty.this.f13527l, AuthorizationAlertActitivty.this.f13535t);
                    AuthorizationAlertActitivty.this.f13530o.show();
                    return;
                }
            }
            if (i10 == -1) {
                if (AuthorizationAlertActitivty.this.f13530o != null && AuthorizationAlertActitivty.this.f13530o.isShowing()) {
                    AuthorizationAlertActitivty.this.m18594n1();
                    AuthorizationAlertActitivty.this.f13531p = new TermsOfAgreementDialog(AuthorizationAlertActitivty.this.f13527l, AuthorizationAlertActitivty.this.f13535t);
                    AuthorizationAlertActitivty.this.f13531p.show();
                    return;
                }
                AuthorizationAlertActitivty.this.f13532q = true;
                AuthorizationAlertActitivty.this.f13533r = true;
                if (!"newhisync".equals(AuthorizationAlertActitivty.this.f13528m) && !"cloudAlbum".equals(AuthorizationAlertActitivty.this.f13528m)) {
                    AuthorizationAlertActitivty.this.m18592o1();
                }
                AuthorizationAlertActitivty.this.m18594n1();
                C13223b.m79473a(AuthorizationAlertActitivty.this.f13527l, "CLOUDBACKUP_HICLOUD_CLICK_NEXT", "1");
                UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_HICLOUD_CLICK_NEXT", "1", "2");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public void m18592o1() {
        C13195l.m79272J().m79310a0(this, this);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity
    /* renamed from: F0 */
    public int mo18593F0() {
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f13534s) / 1000);
        if (iCurrentTimeMillis <= 0) {
            return 1;
        }
        return iCurrentTimeMillis;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.activity_close, 0);
    }

    /* renamed from: n1 */
    public final void m18594n1() {
        AlertDialog alertDialog = this.f13529n;
        if (alertDialog != null) {
            alertDialog.cancel();
            this.f13529n = null;
        }
        TermsOfPrivacyNoticeDialog termsOfPrivacyNoticeDialog = this.f13530o;
        if (termsOfPrivacyNoticeDialog != null) {
            termsOfPrivacyNoticeDialog.cancel();
            this.f13530o = null;
        }
        TermsOfAgreementDialog termsOfAgreementDialog = this.f13531p;
        if (termsOfAgreementDialog != null) {
            termsOfAgreementDialog.cancel();
            this.f13531p = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0234s.m1639q(this);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.AuthCallbackActivity, com.huawei.android.hicloud.p088ui.CommonActivity, com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C12808e.m76822a(this);
        C11839m.m70686d("AuthorizationAlertActitivty", "AuthorizationAlertActitivty on create, this: " + toString());
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f13527l = this;
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.f13528m = intent.getStringExtra("startSource");
            } catch (Exception unused) {
                C11839m.m70688i("AuthorizationAlertActitivty", "intent Serializable error.");
            }
        }
        if (!C10028c.m62182c0().m62221H1()) {
            m18596q1();
            return;
        }
        this.f13532q = true;
        this.f13533r = true;
        m18595p1(1);
        finish();
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        m18594n1();
        this.f13532q = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C13227f.m79492i1().m79577X(this);
        UBAAnalyze.m29964Y("PVC", getClass().getCanonicalName(), "1", "100", mo18593F0());
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.EntrancePermissionCheckActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        this.f13534s = System.currentTimeMillis();
        super.onResume();
        C13227f.m79492i1().m79582b0(this);
        UBAAnalyze.m29967a0("PVC", getClass().getCanonicalName(), "1", "100");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.f13532q) {
            if ("newhisync".equals(this.f13528m) || "cloudAlbum".equals(this.f13528m) || "phoneFinder".equals(this.f13528m)) {
                if (this.f13533r) {
                    m18595p1(1);
                } else {
                    m18595p1(2);
                }
            }
            finish();
        }
    }

    /* renamed from: p1 */
    public final void m18595p1(int i10) {
        setResult(i10, getIntent());
    }

    /* renamed from: q1 */
    public void m18596q1() {
        if (!"CN".equalsIgnoreCase(C13452e.m80781L().m80942m())) {
            m18595p1(2);
            finish();
        } else {
            TermsOfServiceDialog termsOfServiceDialog = new TermsOfServiceDialog(this.f13527l, null, this.f13535t);
            this.f13529n = termsOfServiceDialog;
            termsOfServiceDialog.show();
        }
    }
}
