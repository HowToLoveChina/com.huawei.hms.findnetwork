package com.huawei.android.hicloud.oobe.p086ui.activity;

import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import com.huawei.android.hicloud.oobe.R$string;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import p422k9.C11019b;
import p514o9.C11839m;
import p514o9.C11842p;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class OOBELocalTermsActivity extends OOBEBaseActivity {

    /* renamed from: G */
    public static Thread.UncaughtExceptionHandler f12392G = new C2827b();

    /* renamed from: A */
    public ProgressBar f12393A;

    /* renamed from: B */
    public TextView f12394B;

    /* renamed from: C */
    public ViewGroup f12395C;

    /* renamed from: D */
    public ScrollView f12396D;

    /* renamed from: E */
    public String f12397E;

    /* renamed from: F */
    public Handler f12398F = new HandlerC2826a();

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBELocalTermsActivity$a */
    public class HandlerC2826a extends Handler {
        public HandlerC2826a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    OOBELocalTermsActivity.this.m16649L0((String) message.obj);
                } else if (i10 == 1) {
                    OOBELocalTermsActivity.this.m16644K0();
                }
            } catch (Exception e10) {
                C11839m.m70687e("OOBELocalTermsActivity", "handleMessage error!" + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBELocalTermsActivity$b */
    public class C2827b implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            C11839m.m70687e("OOBELocalTermsActivity", thread.getName() + ": " + th2.getMessage());
        }
    }

    /* renamed from: com.huawei.android.hicloud.oobe.ui.activity.OOBELocalTermsActivity$c */
    public class RunnableC2828c implements Runnable {
        public RunnableC2828c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            try {
                C11019b c11019bM66371t = C11019b.m66371t();
                OOBELocalTermsActivity oOBELocalTermsActivity = OOBELocalTermsActivity.this;
                String strM66446u = c11019bM66371t.m66446u(oOBELocalTermsActivity, oOBELocalTermsActivity.f12397E);
                if (!TextUtils.isEmpty(strM66446u)) {
                    message.what = 0;
                    message.obj = strM66446u;
                }
            } catch (Exception e10) {
                C11839m.m70687e("OOBELocalTermsActivity", "GetAgreementTask run error!" + e10.getMessage());
            }
            OOBELocalTermsActivity.this.f12398F.sendMessage(message);
        }

        public /* synthetic */ RunnableC2828c(OOBELocalTermsActivity oOBELocalTermsActivity, HandlerC2826a handlerC2826a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public void m16644K0() {
        this.f12393A.setVisibility(8);
        this.f12394B.setVisibility(8);
        this.f12395C.setVisibility(0);
    }

    /* renamed from: M0 */
    private void m16645M0() {
        C11842p.m70827j2(this.f12396D, C11842p.m70789a0(this) + C11842p.m70852q(this));
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: C0 */
    public void mo16555C0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() {
        this.f12393A = (ProgressBar) C12809f.m76829b(this, R$id.agreement_loading_progress);
        this.f12394B = (TextView) C12809f.m76829b(this, R$id.terms_content);
        ViewGroup viewGroup = (ViewGroup) C12809f.m76829b(this, R$id.agreement_info_timeout_layout);
        this.f12395C = viewGroup;
        viewGroup.setOnClickListener(this);
        this.f12396D = (ScrollView) C12809f.m76829b(this, R$id.agreement_main);
        m16645M0();
    }

    /* renamed from: H0 */
    public final String m16646H0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String string = Html.fromHtml(str, 63).toString();
        try {
            return string.substring(string.indexOf(10) + 1);
        } catch (Exception e10) {
            C11839m.m70687e("OOBELocalTermsActivity", "formatTitle error: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: I0 */
    public final int m16647I0() {
        return R$layout.oobe_local_terms_emui10;
    }

    /* renamed from: J0 */
    public final void m16648J0() {
        String string = "privacy_statement".equals(this.f12397E) ? getString(R$string.cloud_service_privacy_statement) : getString(R$string.cloud_service_terms_text);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(string);
        }
    }

    /* renamed from: L0 */
    public final void m16649L0(String str) {
        String strM16646H0 = m16646H0(m16650N0(str));
        if ("privacy_statement".equals(this.f12397E) && "CN".equalsIgnoreCase(C13452e.m80781L().m80942m())) {
            SpannableString spannableString = new SpannableString(strM16646H0);
            String strReplace = getString(R$string.cloud_service_legal_privacy_text).replace("།", "");
            if (spannableString.toString().indexOf(strReplace) == -1) {
                strReplace = "Huawei Consumer Business Privacy Statement";
            }
            this.f12394B.setText(strM16646H0.replace(strReplace, getString(R$string.about_recover_tip_null, strReplace, getString(R$string.oobelocal_term_show_url))));
        } else {
            this.f12394B.setText(strM16646H0);
        }
        this.f12394B.setVisibility(0);
        this.f12393A.setVisibility(8);
    }

    /* renamed from: N0 */
    public final String m16650N0(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll("<[a|A] +[h|H][r|R][e|E][f|F] *= *\".*?\" *>", "");
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: O */
    public void mo16566O() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: S */
    public void mo16569S() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: T */
    public void mo16570T() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: U */
    public void mo16571U() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: V */
    public void mo16572V() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Y */
    public void mo16574Y() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: Z */
    public void mo16575Z() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: a0 */
    public void mo16576a0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: b0 */
    public void mo16577b0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.oobe_local_terms;
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f */
    public int mo16583f() {
        return m16647I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: f0 */
    public void mo16584f0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g */
    public int mo16585g() {
        return m16647I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: g0 */
    public void mo16586g0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h */
    public int mo16587h() {
        return m16647I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: h0 */
    public void mo16588h0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i */
    public int mo16589i() {
        return m16647I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: i0 */
    public void mo16590i0(View view) {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: j */
    public int mo16591j() {
        return m16647I0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: l0 */
    public void mo16596l0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.agreement_info_timeout_layout) {
            this.f12393A.setVisibility(0);
            this.f12395C.setVisibility(8);
            try {
                Thread thread = new Thread(new RunnableC2828c(this, null), "GetAgreementThread");
                thread.setUncaughtExceptionHandler(f12392G);
                thread.start();
            } catch (Exception e10) {
                C11839m.m70687e("OOBELocalTermsActivity", "onClick exception:" + e10.getMessage());
            }
        }
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        try {
            this.f12393A.setVisibility(0);
            this.f12394B.setVisibility(8);
            this.f12397E = new HiCloudSafeIntent(getIntent()).getStringExtra("product_type");
            Thread thread = new Thread(new RunnableC2828c(this, null), "GetAgreementThread");
            thread.setUncaughtExceptionHandler(f12392G);
            thread.start();
        } catch (Exception e10) {
            C11839m.m70687e("OOBELocalTermsActivity", "onCreate exception:" + e10.toString());
        }
        m16648J0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: u0 */
    public void mo16613u0() {
        super.m16617w0();
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: x0 */
    public void mo16618x0() {
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: y0 */
    public void mo16620y0() {
    }
}
