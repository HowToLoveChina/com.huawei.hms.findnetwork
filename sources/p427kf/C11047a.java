package p427kf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0241z;
import p394jf.AbstractC10816d;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: kf.a */
/* loaded from: classes4.dex */
public class C11047a extends AbstractC1177c {

    /* renamed from: l */
    public String f52197l;

    /* renamed from: kf.a$a */
    public class a implements Handler.Callback {

        /* renamed from: a */
        public int f52198a;

        public a(int i10) {
            this.f52198a = i10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            C13981a.m83989i("EditLossMode", "HttpCallback->handleMessage" + this.f52198a);
            if (3028 != this.f52198a) {
                return true;
            }
            C11047a.this.m66599Y(message);
            return true;
        }
    }

    public C11047a(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
        this.f52197l = "";
    }

    @Override // bf.AbstractC1177c
    /* renamed from: J */
    public boolean mo7422J() {
        JSONObject jSONObjectM7436u = m7436u(RemoteMessageConst.MessageBody.PARAM);
        if (jSONObjectM7436u == null) {
            C13981a.m83988e("EditLossMode", "parseControlCmd error:param is null");
            return false;
        }
        try {
            if (jSONObjectM7436u.has("isCrypt")) {
                this.f5585f = C0241z.m1686d(jSONObjectM7436u.getString("isCrypt"), 0);
            }
            this.f52197l = m7429m(jSONObjectM7436u.getString("message"), this.f5585f);
            return true;
        } catch (JSONException unused) {
            C13981a.m83988e("EditLossMode", "parseControlCmd JSONException");
            return false;
        }
    }

    /* renamed from: X */
    public final void m66598X() {
        AbstractC10816d.m65870f(this.f5580a, this.f52197l);
        this.f5582c = 0;
        m7417D(new a(3028));
        C13981a.m83989i("EditLossMode", "excuteEditLossMode success,AppEventLogParam report");
        new C12797b().m76783i(this.f5580a, "EditLossMode", "0", "excuteEditLossMode success", null, this.f5581b, "pushResult_reported", false);
    }

    /* renamed from: Y */
    public final void m66599Y(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i("EditLossMode", "handleReportEditLossModeCallback result:" + iM1685c + ";resultCode:" + iM7438x);
        C12797b c12797b = new C12797b();
        if (iM1685c != 200) {
            c12797b.m76783i(this.f5580a, "EditLossMode", "001_3003", "editloss handleReportEditLossModeCallback fail,result:" + iM1685c, null, this.f5581b, "pushResult_reported", true);
            return;
        }
        if (iM7438x == 0) {
            C13981a.m83989i("EditLossMode", "EditlossMode handleReportEditLossModeCallback success,AppEventLogParam report");
            c12797b.m76783i(this.f5580a, "EditLossMode", "0", "editloss handleReportEditLossModeCallback success", null, this.f5581b, "pushResult_reported", true);
            return;
        }
        c12797b.m76781g(this.f5580a, "EditLossMode", "001_3004", iM7438x, "editloss handleReportEditLossModeCallback fail,resultCode:" + iM7438x, null, this.f5581b, "pushResult_reported", true);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (mo7422J()) {
            m66598X();
            return;
        }
        C13981a.m83988e("EditLossMode", "editloss mode parseControlCmd fail");
        this.f5582c = 9;
        m7417D(new a(3028));
        new C12797b().m76783i(this.f5580a, "EditLossMode", "001_1005", "editloss parseControlCmd fail handleControlCmd", null, this.f5581b, "pushResult_reported", false);
    }
}
