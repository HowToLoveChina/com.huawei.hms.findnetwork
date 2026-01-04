package p427kf;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.track.C4443e;
import org.json.JSONException;
import p015ak.C0241z;
import p394jf.AbstractC10816d;
import p394jf.C10818f;
import p521og.C11877j;
import p638sf.C12795b;
import p664u0.C13108a;
import p774xg.C13811a;
import p809yg.C13981a;

/* renamed from: kf.c */
/* loaded from: classes4.dex */
public class C11049c extends AbstractC1177c {

    /* renamed from: kf.c$a */
    public class a implements Handler.Callback {

        /* renamed from: a */
        public int f52208a;

        public a(int i10) {
            this.f52208a = i10;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            C13981a.m83987d("StopLossMode", "HttpCallback->handleMessage");
            if (3029 != this.f52208a) {
                return true;
            }
            C11049c.this.m66607Y(message);
            return true;
        }
    }

    public C11049c(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    /* renamed from: X */
    public final void m66606X() {
        Intent intent = new Intent();
        intent.setAction("finish_lockActivity");
        C13108a.m78878b(this.f5580a).m78881d(intent);
        Intent intent2 = new Intent();
        intent2.setAction("com.huawei.android.remotecontrol.UNREGISTER_ACTION_SCREEN_ON");
        C13108a.m78878b(this.f5580a).m78881d(intent2);
        AbstractC10816d.m65869e(this.f5580a, false);
        AbstractC10816d.m65870f(this.f5580a, "");
        C13811a.m82809f(this.f5580a, true, true);
        this.f5582c = 0;
        m7417D(new a(3029));
        C13981a.m83989i("StopLossMode", "executeStopLossMode success,AppEventLogParam report");
        m7427Q("StopLossMode", "0", -1, "executeStopLossMode success", null, this.f5581b.getOperation(), "pushStopLossMode", false, null);
        C4443e.m26985i(this.f5580a);
        C12795b.m76765a(this.f5580a);
        C13981a.m83989i("StopLossMode", "send remote lock changed broadcast");
        this.f5580a.sendBroadcast(new Intent("com.huawei.android.remotecontrol.intent.LOST_PATTERN_MODE_CHANGED"), "com.huawei.remotocontrol.permission.REMOTECALL");
        C11877j.m71203D0(this.f5580a, false);
        C11877j.m71201C0(this.f5580a, -1);
    }

    /* renamed from: Y */
    public final void m66607Y(Message message) throws JSONException {
        int iM1685c = C0241z.m1685c(message.getData().getString("result"));
        int iM7438x = m7438x(message.getData().getString("response_info"));
        C13981a.m83989i("StopLossMode", "handleReportStopLossModeCallback result:" + iM1685c + ";resultCode:" + iM7438x);
        if (iM1685c != 200) {
            C10818f.m65874a().m65879f(this.f5580a, true);
            m7427Q("StopLossMode", "001_3003", -1, "phonefinder exceute stoploss handleReportStopLossModeCallback fail, result:" + iM1685c, null, this.f5581b.getOperation(), "pushStopLossMode", true, null);
            return;
        }
        if (iM7438x != 0) {
            C10818f.m65874a().m65879f(this.f5580a, true);
            m7427Q("StopLossMode", "001_3004", iM7438x, "phonefinder exceute stoploss handleReportStopLossModeCallback fail, resultCode:" + iM7438x, null, this.f5581b.getOperation(), "pushStopLossMode", true, null);
            return;
        }
        if (this.f5582c != 1) {
            C13981a.m83989i("StopLossMode", "Stoplossmode handleReportStopLossModeCallback result success, AppEventLogParam report");
            m7427Q("StopLossMode", "0", -1, "phonefinder exceute stoploss handleReportStopLossModeCallback success", null, this.f5581b.getOperation(), "pushStopLossMode", true, null);
        }
        C10818f.m65874a().m65879f(this.f5580a, false);
        C10818f.m65874a().m65880g(false);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (mo7422J()) {
            m66606X();
            return;
        }
        C13981a.m83988e("StopLossMode", "executeStopLossMode parseControlCmd fail");
        this.f5582c = 9;
        m7417D(new a(3029));
        m7427Q("StopLossMode", "001_1005", -1, "executeStopLossMode parseControlCmd fail", null, this.f5581b.getOperation(), "pushStopLossMode", false, null);
    }
}
