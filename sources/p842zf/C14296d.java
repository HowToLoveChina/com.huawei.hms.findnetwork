package p842zf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import bf.AbstractC1177c;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import java.util.function.Consumer;
import nf.C11690w;
import org.json.JSONException;
import p015ak.C0241z;
import p809yg.C13981a;

/* renamed from: zf.d */
/* loaded from: classes4.dex */
public class C14296d extends AbstractC1177c {

    /* renamed from: zf.d$a */
    public class a implements Handler.Callback {

        /* renamed from: a */
        public final int f63541a;

        public a(int i10, int i11) {
            this.f63541a = i10;
            C13981a.m83989i("PullUpFindNetwork", "HttpCallback param:" + i11);
        }

        /* renamed from: a */
        public final void m85156a(Message message) throws JSONException {
            int iM1685c = C0241z.m1685c(message.getData().getString("result"));
            if (200 != iM1685c) {
                C13981a.m83989i("PullUpFindNetwork", "handleReportResult report error, result:" + iM1685c);
                C14296d.this.m7427Q("PullUpFindNetwork", "001_3003", -1, "handleReportResult report fail,result:" + iM1685c, null, C14296d.this.f5581b.getOperation(), "PullUpFindNetwork", true, null);
                return;
            }
            int iM7438x = C14296d.this.m7438x(message.getData().getString("response_info"));
            C13981a.m83989i("PullUpFindNetwork", "handleReportResult, resultCode =" + iM7438x);
            if (iM7438x == 0) {
                C13981a.m83989i("PullUpFindNetwork", "handleReportResult report success");
                C14296d c14296d = C14296d.this;
                c14296d.m7427Q("PullUpFindNetwork", "0", -1, "handleReportResult report success", null, c14296d.f5581b.getOperation(), "PullUpFindNetwork", true, null);
            } else {
                C14296d.this.m7427Q("PullUpFindNetwork", "001_3004", iM7438x, "handleReportResult report fail,resultCode:" + iM7438x, null, C14296d.this.f5581b.getOperation(), "pushAlarm", true, null);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) throws JSONException {
            if (3115 != this.f63541a) {
                return true;
            }
            m85156a(message);
            return true;
        }
    }

    public C14296d(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    /* renamed from: d0 */
    public final /* synthetic */ void m85155d0(Boolean bool) {
        this.f5582c = !bool.booleanValue() ? 1 : 0;
        m7417D(new a(3115, 0));
    }

    @Override // bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        if (!mo7422J()) {
            this.f5582c = 9;
            m7417D(new a(3115, 0));
            return;
        }
        C13981a.m83989i("PullUpFindNetwork", "handleControlCmd");
        this.f5582c = 0;
        try {
            C11690w.m69703Z(new Consumer() { // from class: zf.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f63540a.m85155d0((Boolean) obj);
                }
            });
        } catch (Exception e10) {
            C13981a.m83988e("PullUpFindNetwork", "handleControlCmd e: " + e10.getMessage());
            this.f5582c = 1;
            m7417D(new a(3115, 0));
        }
    }
}
