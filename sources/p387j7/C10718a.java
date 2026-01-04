package p387j7;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import bo.InterfaceC1268b;
import co.AbstractHandlerC1512a;
import com.huawei.android.hicloud.p088ui.activity.ForcedUpgradeActivity;
import com.huawei.hicloud.request.agreement.request.SignInfo;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import gp.C10028c;
import java.util.List;
import p015ak.C0209d;
import p020ap.C1008c;
import p020ap.C1010e;
import p223db.C9062b;
import p420k7.AlertDialogC11014a;
import p420k7.AlertDialogC11015b;
import p420k7.AlertDialogC11016c;
import p446l7.C11253a;
import p446l7.C11257e;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p681uj.C13195l;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p742wj.C13612b;

/* renamed from: j7.a */
/* loaded from: classes2.dex */
public class C10718a implements InterfaceC1268b {

    /* renamed from: a */
    public Activity f51363a;

    /* renamed from: b */
    public Handler f51364b = new Handler();

    /* renamed from: c */
    public boolean f51365c = false;

    /* renamed from: d */
    public boolean f51366d = true;

    /* renamed from: e */
    public boolean f51367e = true;

    /* renamed from: f */
    public boolean f51368f = true;

    /* renamed from: g */
    public AlertDialogC11016c f51369g = null;

    /* renamed from: h */
    public AlertDialogC11015b f51370h = null;

    /* renamed from: i */
    public AlertDialogC11014a f51371i = null;

    /* renamed from: j */
    public ProgressDialog f51372j = null;

    /* renamed from: k */
    public d f51373k = new d();

    /* renamed from: l */
    public Handler f51374l = null;

    /* renamed from: m */
    public String f51375m = "";

    /* renamed from: j7.a$a */
    public class a extends AbstractHandlerC1512a {
        public a(Activity activity) {
            super(activity);
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: d */
        public void mo8607d() {
            C10718a.this.m65426A();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: e */
        public void mo8608e(String str) {
            if (TextUtils.isEmpty(str) || C10718a.this.f51363a == null) {
                C11839m.m70687e("CheckPolicyService", "doHmsAgreementUpdate, uri is null");
                C10718a.this.m65426A();
                return;
            }
            try {
                Intent intentM79271I = C13195l.m79271I(C10718a.this.f51363a, str);
                if (intentM79271I == null) {
                    C11839m.m70687e("CheckPolicyService", "hmsPackage is invalid!");
                } else {
                    C10718a.this.f51363a.startActivityForResult(intentM79271I, 10028);
                    C10718a.this.m65428C();
                }
            } catch (Exception e10) {
                C11839m.m70687e("CheckPolicyService", "startActivityForResult Exception" + e10.getMessage());
                C10718a.this.m65426A();
            }
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: g */
        public void mo8610g() {
            C11839m.m70688i("CheckPolicyService", "doHmsQueryNext");
            C10028c.m62183d0(C10718a.this.f51363a).m62377p3("hms_agr_force_query", false);
            C10718a.this.m65426A();
            C11829c.m70604p();
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: h */
        public void mo8611h(List<SignInfo> list) {
            C10718a.this.m65434q(list);
        }

        @Override // co.AbstractHandlerC1512a
        /* renamed from: i */
        public void mo8612i() {
            C10718a c10718a = C10718a.this;
            c10718a.f51368f = c10718a.f51368f && "CN".equalsIgnoreCase(C11829c.m70533N());
            C10718a.this.mo7530X();
        }
    }

    /* renamed from: j7.a$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f51377a;

        /* renamed from: b */
        public final /* synthetic */ String f51378b;

        public b(boolean z10, String str) {
            this.f51377a = z10;
            this.f51378b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C11839m.m70688i("CheckPolicyService", "clear");
            C10718a.this.m65436t(this.f51377a, this.f51378b);
        }
    }

    /* renamed from: j7.a$c */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 4) {
                return;
            }
            C10718a.this.m65424r();
        }
    }

    /* renamed from: j7.a$d */
    public class d implements InterfaceC13450c {
        public d() {
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            if (errorStatus != null && !errorStatus.getErrorReason().isEmpty() && errorStatus.getErrorCode() != 3002) {
                String errorReason = errorStatus.getErrorReason();
                C11839m.m70687e("CheckPwdRequest", "CloudAccount on error reason: " + errorReason);
                if (C10718a.this.f51363a != null) {
                    Toast.makeText(C10718a.this.f51363a, errorReason, 0).show();
                }
            }
            C10718a.this.mo7530X();
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            C10718a c10718a = C10718a.this;
            c10718a.m65435s(c10718a.f51365c, "local_policy_exit_cloud");
        }
    }

    public C10718a(Activity activity) {
        this.f51363a = activity;
    }

    /* renamed from: p */
    private void m65423p(String str) {
        C11839m.m70686d("CheckPolicyService", "enter deleteSyncData()");
        if (this.f51363a == null) {
            return;
        }
        if (this.f51372j == null) {
            this.f51372j = new ProgressDialog(this.f51363a);
        }
        this.f51372j.setMessage(this.f51363a.getString(R$string.exit_account_removing));
        this.f51372j.setCancelable(false);
        this.f51372j.show();
        if (C13612b.m81829B().m81855T()) {
            return;
        }
        C1008c.m6035v().m6092p(this.f51363a, new c(), C9062b.m57146k().m57157j(), str);
        C13612b.m81829B().m81881q0(true);
        C11839m.m70688i("CheckPolicyService", "processExit flag is: true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m65424r() {
        C11839m.m70686d("CheckPolicyService", "enter exit()");
        try {
            ProgressDialog progressDialog = this.f51372j;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (IllegalArgumentException e10) {
            C11839m.m70687e("CheckPolicyService", "Dismiss delete progress dialog " + e10.toString());
        }
        C9062b.m57146k().m57155h(false, false);
        this.f51363a.finish();
    }

    /* renamed from: w */
    private void m65425w() {
        C11839m.m70688i("CheckPolicyService", "check to queryAgreement,from: " + this.f51375m);
        if (!C10028c.m62182c0().m62380q1() || this.f51363a.getLocalClassName().equals(ForcedUpgradeActivity.class.getName())) {
            C12515a.m75110o().m75172d(new C11253a(this.f51363a, new a(this.f51363a)));
        } else {
            C11839m.m70688i("CheckPolicyService", "queryAgreement forced upgrade");
            C13452e.m80781L().m80976u1();
            m65426A();
        }
    }

    /* renamed from: A */
    public final void m65426A() {
        Handler handler = this.f51374l;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 1;
            m65427B(messageObtainMessage);
            m65439y();
        }
    }

    /* renamed from: B */
    public final void m65427B(Message message) {
        Handler handler = this.f51374l;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: C */
    public final void m65428C() {
        Handler handler = this.f51374l;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 3;
            m65427B(messageObtainMessage);
            m65439y();
        }
    }

    /* renamed from: D */
    public void m65429D(Handler handler) {
        this.f51374l = handler;
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: M */
    public void mo7529M(boolean z10) {
        Handler handler = this.f51374l;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 5;
            messageObtainMessage.obj = Boolean.valueOf(z10);
            m65427B(messageObtainMessage);
        }
        m65439y();
        C12515a.m75110o().m75172d(new C11257e(this.f51363a, z10, this.f51366d, this.f51367e, this.f51368f));
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: X */
    public void mo7530X() {
        if (this.f51363a == null) {
            C11839m.m70687e("CheckPolicyService", "activity is null");
            return;
        }
        if (this.f51369g == null) {
            this.f51369g = new AlertDialogC11016c(this.f51363a, this, this.f51366d, this.f51367e, this.f51368f);
        }
        if (this.f51374l == null) {
            if (this.f51363a.isFinishing()) {
                C11839m.m70688i("CheckPolicyService", "termsOfServiceUpdDialog can not show because activity is finishing");
                return;
            }
            C11839m.m70688i("CheckPolicyService", "termsOfServiceUpdDialog show,from: " + this.f51375m);
            this.f51369g.show();
            return;
        }
        C11839m.m70688i("CheckPolicyService", "termsOfServiceUpdDialog canshow checkpolicy,from: " + this.f51375m);
        Message messageObtainMessage = this.f51374l.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = this.f51369g;
        m65427B(messageObtainMessage);
    }

    /* renamed from: k */
    public void m65430k() {
        C11839m.m70686d("CheckPolicyService", "enter cancelDialog()");
        AlertDialogC11016c alertDialogC11016c = this.f51369g;
        if (alertDialogC11016c != null) {
            alertDialogC11016c.dismiss();
            this.f51369g = null;
        }
        AlertDialogC11015b alertDialogC11015b = this.f51370h;
        if (alertDialogC11015b != null) {
            alertDialogC11015b.dismiss();
            this.f51370h = null;
        }
        AlertDialogC11014a alertDialogC11014a = this.f51371i;
        if (alertDialogC11014a != null) {
            alertDialogC11014a.dismiss();
            this.f51371i = null;
        }
        ProgressDialog progressDialog = this.f51372j;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f51372j = null;
        }
    }

    /* renamed from: l */
    public void m65431l() {
        C11839m.m70688i("CheckPolicyService", "checkCloseUpdDialog");
        Activity activity = this.f51363a;
        if (activity == null) {
            C11839m.m70687e("CheckPolicyService", "mActivity is null");
            return;
        }
        C10028c c10028cM62183d0 = C10028c.m62183d0(activity);
        if (C11829c.m70534N0(this.f51363a, C13452e.m80781L().m80942m())) {
            if (c10028cM62183d0.m62395t1("hms_agr_force_query") && C11829c.m70581h0(this.f51363a.getClass(), this.f51363a)) {
                C11839m.m70688i("CheckPolicyService", "activity is top of stack, query agreement");
                m65425w();
                return;
            }
            return;
        }
        AlertDialogC11016c alertDialogC11016c = this.f51369g;
        if (alertDialogC11016c == null || !alertDialogC11016c.isShowing()) {
            return;
        }
        this.f51369g.cancel();
        if (c10028cM62183d0.m62395t1("agr_force_query")) {
            C11839m.m70688i("CheckPolicyService", "checkCloseUpdDialog,from: " + this.f51375m);
            m65425w();
        }
    }

    /* renamed from: m */
    public void m65432m(String str) {
        this.f51375m = str;
        C11839m.m70686d("CheckPolicyService", "enter checkPolicy: " + this.f51375m);
        long jM70634z = C11829c.m70634z(this.f51363a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zM70631y = C11829c.m70631y(this.f51363a);
        C11839m.m70686d("CheckPolicyService", "checkPolicy(), agrForceQuery:" + zM70631y + ", queryTime:" + jM70634z + ", currentTime:" + jCurrentTimeMillis);
        if (zM70631y || jCurrentTimeMillis >= 86400000 + jM70634z || jCurrentTimeMillis <= jM70634z) {
            m65425w();
            return;
        }
        C11839m.m70686d("CheckPolicyService", "no need to query.from: " + this.f51375m);
        m65426A();
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: n */
    public void mo7531n(boolean z10) {
        this.f51365c = z10;
        boolean zM6139e = C1010e.m6125b().m6139e(this.f51363a);
        C11839m.m70688i("CheckPolicyService", "phoneStatus: " + zM6139e);
        if (zM6139e && C0209d.m1166E1()) {
            m65433o(z10);
        } else {
            m65435s(z10, "local_policy_exit_cloud");
        }
    }

    /* renamed from: o */
    public final void m65433o(boolean z10) {
        C11839m.m70686d("CheckPolicyService", "enter closePhoneFinder()");
        C13195l.m79272J().m79324o(this.f51363a, C1010e.m6125b().m6136a(this.f51363a), 8903, this.f51373k);
    }

    /* renamed from: q */
    public final void m65434q(List<SignInfo> list) {
        C11839m.m70686d("CheckPolicyService", "enter doCheckUpdate,from: " + this.f51375m);
        if (list != null) {
            for (SignInfo signInfo : list) {
                short agrType = signInfo.getAgrType();
                if (agrType == 125) {
                    this.f51366d = signInfo.isNeedSign();
                } else if (agrType == 10000) {
                    this.f51368f = signInfo.isNeedSign();
                } else if (agrType == 10013) {
                    this.f51367e = signInfo.isNeedSign();
                }
            }
        }
        this.f51368f = this.f51368f && "CN".equalsIgnoreCase(C11829c.m70533N());
        C11839m.m70688i("CheckPolicyService", "doCheckUpdate result:" + this.f51366d + '|' + this.f51367e + '|' + this.f51368f);
        if (this.f51366d || this.f51367e || this.f51368f) {
            C11839m.m70688i("CheckPolicyService", "Terms need to re-sign");
            mo7530X();
        } else {
            C11839m.m70688i("CheckPolicyService", "Terms no need to re-sign.");
            C10028c.m62183d0(this.f51363a).m62377p3("agr_force_query", false);
            m65426A();
        }
    }

    /* renamed from: s */
    public final void m65435s(boolean z10, String str) {
        C11839m.m70688i("CheckPolicyService", "enter exitCloud()");
        mo7529M(false);
        try {
            Handler handler = this.f51364b;
            if (handler != null) {
                handler.postDelayed(new b(z10, str), 500L);
            } else {
                m65436t(z10, str);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CheckPolicyService", "Exception: " + e10.toString());
        }
    }

    /* renamed from: t */
    public final void m65436t(boolean z10, String str) {
        try {
            if (z10) {
                C13452e.m80781L().m80885a();
                C10028c.m62182c0().m62343j();
                m65423p(str);
            } else {
                C9062b.m57146k().m57155h(false, false);
                Activity activity = this.f51363a;
                if (activity != null) {
                    activity.finish();
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CheckPolicyService", "Exception: " + e10.toString());
        }
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: u */
    public void mo7532u() {
        if (this.f51371i == null) {
            this.f51371i = new AlertDialogC11014a(this.f51363a, this);
        }
        if (this.f51374l == null) {
            this.f51371i.show();
            return;
        }
        C11839m.m70688i("CheckPolicyService", "processLocalSyncDataDialog canshow checkpolicy");
        Message messageObtainMessage = this.f51374l.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = this.f51371i;
        m65427B(messageObtainMessage);
        m65439y();
    }

    /* renamed from: v */
    public d m65437v() {
        return this.f51373k;
    }

    /* renamed from: x */
    public void m65438x() {
        if (this.f51363a != null) {
            C11839m.m70686d("CheckPolicyService", "mActivity: " + this.f51363a);
            this.f51363a = null;
        }
    }

    /* renamed from: y */
    public final void m65439y() {
        this.f51374l = null;
    }

    @Override // bo.InterfaceC1268b
    /* renamed from: z */
    public void mo7533z() {
        if (this.f51370h == null) {
            this.f51370h = new AlertDialogC11015b(this.f51363a, this);
        }
        if (this.f51374l == null) {
            C11839m.m70688i("CheckPolicyService", "disagreeDialog show from:" + this.f51375m);
            this.f51370h.show();
            return;
        }
        C11839m.m70688i("CheckPolicyService", "disagreeDialog canshow checkpolicy,from:" + this.f51375m);
        Message messageObtainMessage = this.f51374l.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = this.f51370h;
        m65427B(messageObtainMessage);
    }
}
