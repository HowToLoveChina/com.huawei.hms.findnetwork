package p427kf;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.track.C4443e;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0241z;
import p394jf.C10814b;
import p394jf.C10815c;
import p521og.C11877j;
import p576qf.C12349b;
import p576qf.C12350c;
import p638sf.C12795b;
import p664u0.C13108a;
import p774xg.C13811a;
import p809yg.C13981a;

/* renamed from: kf.b */
/* loaded from: classes4.dex */
public class C11048b extends AbstractC1177c {

    /* renamed from: l */
    public String f52200l;

    /* renamed from: m */
    public String f52201m;

    /* renamed from: n */
    public String f52202n;

    /* renamed from: o */
    public String f52203o;

    /* renamed from: p */
    public String f52204p;

    /* renamed from: q */
    public String f52205q;

    /* renamed from: kf.b$a */
    public class a implements Handler.Callback {

        /* renamed from: a */
        public final int f52206a;

        public a(int i10) {
            this.f52206a = i10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException, InterruptedException {
            C13981a.m83987d("StartLossMode", "HttpCallback->handleMessage");
            if (3027 != this.f52206a) {
                return true;
            }
            C11048b.this.m66602Y(message);
            return true;
        }
    }

    public C11048b(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f52202n = "";
        if (pushCmdParser != null) {
            this.f52205q = pushCmdParser.getSessionId();
        }
    }

    @Override // bf.AbstractC1177c
    /* renamed from: J */
    public boolean mo7422J() {
        JSONObject jSONObjectM7436u = m7436u(RemoteMessageConst.MessageBody.PARAM);
        if (jSONObjectM7436u == null) {
            C13981a.m83988e("StartLossMode", "parseControlCmd error:param is null");
            return false;
        }
        try {
            if (jSONObjectM7436u.has("isCrypt")) {
                this.f5585f = C0241z.m1686d(jSONObjectM7436u.getString("isCrypt"), 0);
            }
            if (jSONObjectM7436u.has("phoneNum")) {
                this.f52203o = m7429m(jSONObjectM7436u.getString("email"), this.f5585f);
                String strM7429m = m7429m(jSONObjectM7436u.getString("phoneNum"), this.f5585f);
                this.f52204p = strM7429m;
                if (this.f5585f == 0) {
                    this.f52204p = URLDecoder.decode(strM7429m, Constants.UTF_8);
                }
            }
            this.f52202n = m7429m(jSONObjectM7436u.getString("message"), this.f5585f);
            if (!this.f5581b.isVersionV8() || this.f5588i || this.f5585f == 1) {
                this.f52200l = m7429m(jSONObjectM7436u.getString("lockScreen"), this.f5585f);
                this.f52201m = m7429m(jSONObjectM7436u.getString("lockSdcard"), this.f5585f);
            }
            C11877j.m71247Z0(this.f5580a, this.f52202n, "user_lock_message");
            C11877j.m71247Z0(this.f5580a, this.f52204p, "user_lock_phone");
            C11877j.m71247Z0(this.f5580a, this.f52203o, "user_lock_email");
            return true;
        } catch (JSONException unused) {
            C13981a.m83988e("StartLossMode", "parseControlCmd JSONException");
            return false;
        } catch (Exception e10) {
            C13981a.m83988e("StartLossMode", "parseControlCmd Exception " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: X */
    public final void m66601X() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C10814b.m65858a().m65860c(this.f5580a, this.f52202n, this.f52204p, this.f52203o);
        m66603Z();
        if (!C0209d.m1203Q1(this.f5580a)) {
            C10815c.m65863b(this.f5580a);
            this.f5582c = 103;
            m7417D(new a(3027));
            m7427Q("StartLossMode", "001_1013", -1, "phoneFinder start loss parseControlCmd fail: OOBE lostMode", null, this.f5581b.getOperation(), "pushLossMode", false, null);
            return;
        }
        int iM65862a = C10815c.m65862a(this.f52200l, this.f52201m, this.f52202n, this.f5580a);
        C13981a.m83989i("StartLossMode", "lock screen result=" + iM65862a);
        C13811a.m82787E(this.f5580a, true, "loss_mode");
        C13811a.m82797O(this.f5580a);
        if (iM65862a == 0) {
            this.f5582c = 0;
            m7417D(new a(3027));
            C13981a.m83989i("StartLossMode", "ExecuteStartLossMode success,AppEventLogParam report");
            m7427Q("StartLossMode", "0", -1, "ExecuteStartLossMode lock screen success", null, this.f5581b.getOperation(), "pushLossMode", false, null);
            return;
        }
        if (1 == iM65862a) {
            this.f5582c = 104;
            m7417D(new a(3027));
            m7427Q("StartLossMode", "-1", -1, "ExecuteStartLossMode lock screen fail", null, this.f5581b.getOperation(), "pushLossMode", false, null);
        } else if (2 == iM65862a) {
            this.f5582c = 102;
            m7417D(new a(3027));
        }
    }

    /* renamed from: Y */
    public final void m66602Y(Message message) throws JSONException, InterruptedException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i("StartLossMode", "handleReportStartLossModeCallback result:" + iM1685c + ";resultCode:" + iM7438x);
        if (iM1685c != 200) {
            C11877j.m71203D0(this.f5580a, true);
            C11877j.m71201C0(this.f5580a, this.f5582c);
            m7427Q("StartLossMode", "001_3003", -1, "ExecuteStartLossMode lock screen handleReportStartLossModeCallback fail,result:" + iM1685c, null, this.f5581b.getOperation(), "pushLossMode", true, null);
            return;
        }
        C11877j.m71203D0(this.f5580a, false);
        C11877j.m71201C0(this.f5580a, -1);
        if (iM7438x != 0) {
            C12795b.m76766b(this.f5580a, this.f5584e);
            m7427Q("StartLossMode", "001_3004", iM7438x, "ExecuteStartLossMode lock screen handleReportStartLossModeCallback fail,resultCode:" + iM7438x, null, this.f5581b.getOperation(), "pushLossMode", true, null);
            return;
        }
        if (TextUtils.isEmpty(this.f52205q)) {
            C13981a.m83988e("StartLossMode", "sessionId is empty");
            return;
        }
        C13981a.m83989i("StartLossMode", "LossMode result = " + this.f5582c);
        int i10 = this.f5582c;
        if (i10 == 0 || i10 == 102 || i10 == 103) {
            C4443e.m26984h(this.f5580a);
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e10) {
                C13981a.m83988e("StartLossMode", "Thread sleep InterruptedException:" + e10.getMessage());
            }
            C4443e.m26979c(this.f5580a, this.f52205q);
            C13981a.m83989i("StartLossMode", "ExecuteStartLossMode handleReportEditLossModeCallback success,AppEventLogParam report");
            m7427Q("StartLossMode", "0", -1, "ExecuteStartLossMode lock screen handleReportStartLossModeCallback success", null, this.f5581b.getOperation(), "pushLossMode", true, null);
            C13981a.m83989i("StartLossMode", "send remote lock changed broadcast");
            Intent intent = new Intent("com.huawei.android.remotecontrol.intent.LOST_PATTERN_MODE_CHANGED");
            this.f5580a.sendBroadcast(intent, "com.huawei.remotocontrol.permission.REMOTECALL");
            C13108a.m78878b(this.f5580a).m78881d(intent);
        }
    }

    /* renamed from: Z */
    public final void m66603Z() {
        C13811a.m82807d(this.f5580a);
        C13811a.m82808e(this.f5580a);
    }

    /* renamed from: a0 */
    public void m66604a0() {
        C13981a.m83988e("StartLossMode", "reportStartLossModeFail");
        this.f5582c = 104;
        m7417D(new a(3027));
        m7427Q("StartLossMode", "001_1005", -1, "start loss fail", null, this.f5581b.getOperation(), "pushLossMode", false, null);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13811a.m82805b(true, "loss_mode");
        if (!mo7422J()) {
            C13981a.m83988e("StartLossMode", "Execute StartLossMode parseControlCmd fail");
            this.f5582c = 9;
            m7417D(new a(3027));
            m7427Q("StartLossMode", "001_1005", -1, "phoneFinder start loss parseControlCmd fail handleControlCmd", null, this.f5581b.getOperation(), "pushLossMode", false, null);
            return;
        }
        if (!this.f5581b.isVersionV8() || !m7434s("isNeedQuery") || this.f5588i) {
            m66601X();
        } else {
            new C12350c(m7433r(), new C12349b(this.f5580a, this.f5581b, m7436u(RemoteMessageConst.MessageBody.PARAM)), this.f5580a).m74323d();
            C13981a.m83988e("StartLossMode", "StartLossMode needQuery first,CMD excute break.");
        }
    }
}
