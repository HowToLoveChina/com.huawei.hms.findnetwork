package se;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import org.json.JSONException;
import p015ak.C0241z;
import p809yg.C13981a;

/* renamed from: se.a */
/* loaded from: classes4.dex */
public class C12779a extends AbstractC1177c {

    /* renamed from: se.a$a */
    public class a implements Handler.Callback {

        /* renamed from: a */
        public int f58431a;

        public a(int i10, int i11) {
            this.f58431a = i10;
            C13981a.m83989i("Alarm", "HttpCallback param:" + i11);
        }

        /* renamed from: a */
        public final void m76697a(Message message) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            if (200 != iM1685c) {
                C13981a.m83989i("Alarm", "HandleAlarmReportResult->report error, result:" + iM1685c);
                C12779a.this.m7427Q("Alarm", "001_3003", -1, "handleAlarmReportResult whistle device fail,result:" + iM1685c, null, C12779a.this.f5581b.getOperation(), "pushAlarm", true, null);
                return;
            }
            int iM7438x = C12779a.this.m7438x(message.getData().getString("response_info"));
            C13981a.m83989i("Alarm", "HandleAlarmReportResult->resultCode =" + iM7438x);
            if (iM7438x == 0) {
                C13981a.m83989i("Alarm", "phoneFinder whistle device success,AppEventLogParam report success");
                C12779a c12779a = C12779a.this;
                c12779a.m7427Q("Alarm", "0", -1, "handleAlarmReportResult whistle device success", null, c12779a.f5581b.getOperation(), "pushAlarm", true, null);
            } else {
                C12779a.this.m7427Q("Alarm", "001_3004", iM7438x, "handleAlarmReportResult whistle device fail,resultCode:" + iM7438x, null, C12779a.this.f5581b.getOperation(), "pushAlarm", true, null);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            if (3022 != this.f58431a) {
                return true;
            }
            m76697a(message);
            return true;
        }
    }

    public C12779a(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!mo7422J()) {
            this.f5582c = 9;
            m7417D(new a(3022, 0));
        } else {
            C12782d.m76703f(this.f5580a);
            this.f5582c = 0;
            m7417D(new a(3022, 0));
        }
    }
}
