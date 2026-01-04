package p841ze;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import bf.AbstractC1177c;
import bf.C1175a;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.android.remotecontrol.http.C4347e;
import p015ak.C0209d;
import p015ak.C0241z;
import p809yg.C13981a;

/* renamed from: ze.c */
/* loaded from: classes4.dex */
public class C14289c extends AbstractC1177c {

    /* renamed from: l */
    public static final String f63525l = "c";

    /* renamed from: ze.c$a */
    public class a implements Handler.Callback {

        /* renamed from: a */
        public int f63526a;

        /* renamed from: b */
        public int f63527b = 0;

        public a(int i10, int i11) {
            this.f63526a = i11;
            C13981a.m83989i(C14289c.f63525l, "HttpCallback param:" + this.f63526a);
        }

        /* renamed from: a */
        public final void m85144a(Message message) {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            this.f63527b = iM1685c;
            if (200 != iM1685c) {
                C13981a.m83989i(C14289c.f63525l, "handleClearCancleReportResult->report error:result=" + this.f63527b);
                C14289c.this.m7427Q(C14289c.f63525l, "001_3003", -1, "phonefinder handleClearCancleReportResult fail,result:" + this.f63527b, null, C14289c.this.f5581b.getOperation(), "pushCancelClear", true, null);
                return;
            }
            int iM26233d = C4347e.m26233d(message.getData().getString("response_info"));
            C13981a.m83989i(C14289c.f63525l, "handleClearCancleReportResult->resultCode =" + iM26233d);
            if (iM26233d == 0) {
                C13981a.m83989i(C14289c.f63525l, "handleClearCancleReportResult success,AppEventLogParam report success");
                C14289c.this.m7427Q(C14289c.f63525l, "0", -1, "handleClearCancleReportResult success", null, C14289c.this.f5581b.getOperation(), "pushCancelClear", true, null);
                return;
            }
            C14289c.this.m7427Q(C14289c.f63525l, "001_3004", iM26233d, "phonefinder handleClearCancleReportResult fail,resultCode:" + iM26233d, null, C14289c.this.f5581b.getOperation(), "pushCancelClear", true, null);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                m85144a(message);
            }
            return true;
        }
    }

    public C14289c(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!mo7422J()) {
            this.f5582c = 9;
            m7417D(new a(1, 0));
            m7427Q(f63525l, "001_1005", -1, "cancle clear data parseControlCmd fail", null, this.f5581b.getOperation(), "pushCancelClear", false, null);
            return;
        }
        int iM85118r0 = C14288b.m85118r0(this.f5580a);
        if (1 == iM85118r0) {
            C14288b.m85122z0(this.f5580a, 2);
            this.f5582c = 0;
            m7417D(new a(1, 0));
            String str = f63525l;
            C13981a.m83989i(str, "handleControlCmd cancle clear data when locate,AppEventLogParam report success");
            m7427Q(str, "0", -1, "cancle clear data when locate success", null, this.f5581b.getOperation(), "pushCancelClear", false, null);
            return;
        }
        if (3 == iM85118r0 || 4 == iM85118r0 || 5 == iM85118r0) {
            this.f5582c = 1;
            m7417D(new a(1, 0));
            String str2 = f63525l;
            C13981a.m83989i(str2, "handleControlCmd cancle clear data failure,AppEventLogParam report failure:clearState=" + iM85118r0);
            m7427Q(str2, "001_3004", -1, "cancle clear data failure:clearState=" + iM85118r0, null, this.f5581b.getOperation(), "pushCancelClear", false, null);
            return;
        }
        if (!C1175a.m7389k(this.f5580a) || C0209d.m1206R1(this.f5580a)) {
            C14288b.m85122z0(this.f5580a, 0);
            this.f5582c = 0;
            m7417D(new a(1, 0));
            String str3 = f63525l;
            C13981a.m83989i(str3, "handleControlCmd cancle clear while no clear,AppEventLogParam report success");
            m7427Q(str3, "0", -1, "cancle clear data while no clear success", null, this.f5581b.getOperation(), "pushCancelClear", false, null);
            return;
        }
        this.f5582c = 1;
        m7417D(new a(1, 0));
        String str4 = f63525l;
        C13981a.m83989i(str4, "handleControlCmd cancle clear data failure while in activation lock,AppEventLogParam report failure:clearState=" + iM85118r0);
        m7427Q(str4, "001_3004", -1, "cancle clear data failure while in activation lock,:clearState=" + iM85118r0, null, this.f5581b.getOperation(), "pushCancelClear", false, null);
    }
}
