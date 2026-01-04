package p486n6;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.dialog.HowGetInvitationCodeDialog;
import com.huawei.android.p069cg.p071ui.InvitationCodeView;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1136q;
import p031b7.C1140u;
import p514o9.C11829c;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import p684un.C13224c;
import p709vj.C13452e;

/* renamed from: n6.m */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC11648m extends AlertDialogC13154a implements View.OnClickListener {

    /* renamed from: a */
    public Button f54034a;

    /* renamed from: b */
    public Button f54035b;

    /* renamed from: c */
    public TextView f54036c;

    /* renamed from: d */
    public TextView f54037d;

    /* renamed from: e */
    public InvitationCodeView f54038e;

    /* renamed from: f */
    public Activity f54039f;

    /* renamed from: g */
    public int f54040g;

    /* renamed from: h */
    public Handler f54041h;

    /* renamed from: n6.m$a */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Inviter inviter;
            Bundle data = message.getData();
            C1120a.m6677i("InputInvitationCodeDialog", "msg what:" + message.what);
            int i10 = message.what;
            if (i10 == 1001) {
                ViewOnClickListenerC11648m.this.m69568n();
                ViewOnClickListenerC11648m.this.m69567m();
                ViewOnClickListenerC11648m.this.f54038e.m14717j();
                ViewOnClickListenerC11648m viewOnClickListenerC11648m = ViewOnClickListenerC11648m.this;
                viewOnClickListenerC11648m.m69569o(viewOnClickListenerC11648m.f54039f, R$string.invitation_code_dialog_error_tips);
                return;
            }
            if (i10 == 1002) {
                ViewOnClickListenerC11648m.this.m69565k();
                try {
                    inviter = (Inviter) data.getSerializable("key_check_code_success_inviter");
                } catch (Exception unused) {
                    C1120a.m6676e("InputInvitationCodeDialog", "check code success inviter is null");
                    inviter = null;
                }
                if (inviter == null) {
                    Toast.makeText(ViewOnClickListenerC11648m.this.f54039f, ViewOnClickListenerC11648m.this.f54039f.getString(R$string.server_error), 0).show();
                    C1120a.m6676e("InputInvitationCodeDialog", "inviter is null");
                } else if (inviter.getShareType().intValue() != 1 || CloudAlbumSettings.m14363h().m14373i()) {
                    C1140u.m7198j(inviter, ViewOnClickListenerC11648m.this.f54039f, ViewOnClickListenerC11648m.this);
                } else {
                    Toast.makeText(ViewOnClickListenerC11648m.this.f54039f, R$string.invite_code_not_support_toast, 0).show();
                }
            }
        }
    }

    /* renamed from: n6.m$b */
    public class b implements InvitationCodeView.InterfaceC2340b {

        /* renamed from: a */
        public final /* synthetic */ Activity f54043a;

        public b(Activity activity) {
            this.f54043a = activity;
        }

        @Override // com.huawei.android.p069cg.p071ui.InvitationCodeView.InterfaceC2340b
        /* renamed from: a */
        public void mo14719a() {
            ViewOnClickListenerC11648m.this.m69564j();
        }

        @Override // com.huawei.android.p069cg.p071ui.InvitationCodeView.InterfaceC2340b
        /* renamed from: b */
        public void mo14720b() {
            ViewOnClickListenerC11648m.this.m69569o(this.f54043a, R$string.invitation_code_dialog_limit_text);
        }
    }

    /* renamed from: n6.m$c */
    public class c extends AbstractC12367d {

        /* renamed from: a */
        public String f54045a;

        public c(String str) {
            this.f54045a = str;
        }

        /* renamed from: c */
        public final void m69571c() {
            Message messageObtainMessage = ViewOnClickListenerC11648m.this.f54041h.obtainMessage();
            messageObtainMessage.what = 1001;
            ViewOnClickListenerC11648m.this.f54041h.sendMessage(messageObtainMessage);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                Inviter inviterM74758m = C12469b.m74746l().m74758m(this.f54045a);
                Message messageObtainMessage = ViewOnClickListenerC11648m.this.f54041h.obtainMessage();
                messageObtainMessage.what = 1002;
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_check_code_success_inviter", inviterM74758m);
                messageObtainMessage.setData(bundle);
                ViewOnClickListenerC11648m.this.f54041h.sendMessage(messageObtainMessage);
            } catch (C4616s e10) {
                m69571c();
                C1120a.m6676e("InputInvitationCodeDialog", "getInviter HttpResponseException " + e10.toString());
            } catch (Exception e11) {
                m69571c();
                C1120a.m6676e("InputInvitationCodeDialog", "InviteCodeCreateTask error:" + e11.getMessage());
            }
        }
    }

    public ViewOnClickListenerC11648m(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        super(activity);
        this.f54040g = 1;
        this.f54041h = new a();
        this.f54039f = activity;
        View viewInflate = getLayoutInflater().inflate(R$layout.view_input_invitation_code_dialog, (ViewGroup) null);
        setView(viewInflate);
        C11829c.m70594l1(activity, this);
        setCanceledOnTouchOutside(false);
        this.f54034a = (Button) viewInflate.findViewById(R$id.cancel);
        this.f54035b = (Button) viewInflate.findViewById(R$id.confirm);
        this.f54036c = (TextView) viewInflate.findViewById(R$id.get_code_link);
        this.f54037d = (TextView) viewInflate.findViewById(R$id.tips);
        InvitationCodeView invitationCodeView = (InvitationCodeView) viewInflate.findViewById(R$id.invitationcodeview);
        this.f54038e = invitationCodeView;
        invitationCodeView.setOnCodeErrorListener(new b(activity));
        this.f54034a.setOnClickListener(this);
        this.f54035b.setOnClickListener(this);
        this.f54036c.setOnClickListener(this);
    }

    /* renamed from: i */
    public final boolean m69563i(long j10) {
        if (!C0209d.m1333z1(this.f54039f)) {
            Activity activity = this.f54039f;
            Toast.makeText(activity, activity.getString(R$string.invitation_code_dialog_net_error_tips), 0).show();
            return false;
        }
        this.f54040g = C1136q.b.m7116z(C0213f.m1377a());
        C1120a.m6675d("InputInvitationCodeDialog", "checkCanRequest failedNumber:" + this.f54040g);
        if (j10 <= 600000 || this.f54040g < 5) {
            return this.f54040g < 5;
        }
        m69565k();
        return true;
    }

    /* renamed from: j */
    public final void m69564j() {
        this.f54037d.setVisibility(8);
    }

    /* renamed from: k */
    public final void m69565k() {
        C1120a.m6677i("InputInvitationCodeDialog", "initFailNumberAndTime set failedNumber 0");
        C1136q.b.m7008J0(C0213f.m1377a(), 0);
        C1136q.b.m7006I0(C0213f.m1377a(), 0L);
        C1136q.b.m7004H0(C0213f.m1377a(), 0L);
    }

    /* renamed from: l */
    public final void m69566l() {
        C1120a.m6675d("InputInvitationCodeDialog", "reportConfirmEvent");
        C13224c.m79487f1().m79585f0("action_code_click_confirm_invite", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "action_code_click_confirm_invite", "1", "InputInvitationCodeDialog");
    }

    /* renamed from: m */
    public final void m69567m() {
        this.f54040g = C1136q.b.m7116z(C0213f.m1377a()) + 1;
        C1120a.m6677i("InputInvitationCodeDialog", "saveFailNumber:" + this.f54040g);
        C1136q.b.m7008J0(C0213f.m1377a(), this.f54040g);
        if (this.f54040g >= 5) {
            C1136q.b.m7006I0(C0213f.m1377a(), System.currentTimeMillis());
        }
    }

    /* renamed from: n */
    public final void m69568n() {
        this.f54040g = C1136q.b.m7116z(C0213f.m1377a());
        C1120a.m6677i("InputInvitationCodeDialog", "saveFirstErrorTime failedNumber:" + this.f54040g);
        long jM7110x = C1136q.b.m7110x(C0213f.m1377a());
        if (System.currentTimeMillis() - jM7110x <= PreConnectManager.CONNECT_SUCCESS_INTERNAL || jM7110x == 0) {
            if (this.f54040g == 0) {
                C1136q.b.m7004H0(C0213f.m1377a(), System.currentTimeMillis());
            }
        } else {
            C1120a.m6677i("InputInvitationCodeDialog", "saveFirstErrorTime set failedNumber 0");
            C1136q.b.m7006I0(C0213f.m1377a(), System.currentTimeMillis());
            C1136q.b.m7008J0(C0213f.m1377a(), 0);
            C1136q.b.m7004H0(C0213f.m1377a(), 0L);
        }
    }

    /* renamed from: o */
    public final void m69569o(Context context, int i10) {
        this.f54037d.setText(context.getResources().getString(i10));
        this.f54037d.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        if (view.getId() == R$id.cancel) {
            dismiss();
            return;
        }
        if (view.getId() != R$id.confirm) {
            if (view.getId() == R$id.get_code_link) {
                if (C0209d.m1226Y0()) {
                    C1120a.m6677i("InputInvitationCodeDialog", "get code dialog click fast return");
                    return;
                } else {
                    new HowGetInvitationCodeDialog(this.f54039f).show();
                    return;
                }
            }
            return;
        }
        if (C0209d.m1226Y0()) {
            C1120a.m6677i("InputInvitationCodeDialog", "click fast return");
            return;
        }
        m69566l();
        long jCurrentTimeMillis = System.currentTimeMillis() - C1136q.b.m7113y(C0213f.m1377a());
        if (m69563i(jCurrentTimeMillis)) {
            String resultStr = this.f54038e.getResultStr();
            C12515a.m75110o().m75172d(new c(resultStr));
            C1120a.m6675d("InputInvitationCodeDialog", "code:" + resultStr);
            return;
        }
        double d10 = jCurrentTimeMillis / 60000.0d;
        C1120a.m6675d("InputInvitationCodeDialog", "not can request failedNumber:" + this.f54040g + " time:" + d10);
        if (this.f54040g < 5 || jCurrentTimeMillis >= 600000) {
            return;
        }
        int iIntValue = 10 - Double.valueOf(Math.floor(d10)).intValue();
        if (iIntValue <= 0) {
            iIntValue = 1;
        }
        this.f54037d.setText(this.f54039f.getResources().getQuantityString(R$plurals.invitation_code_dialog_input_error_too_many_tips, iIntValue, Integer.valueOf(iIntValue)));
        this.f54037d.setVisibility(0);
    }

    /* renamed from: p */
    public void m69570p() {
        getWindow().clearFlags(131080);
        getWindow().setSoftInputMode(5);
    }
}
