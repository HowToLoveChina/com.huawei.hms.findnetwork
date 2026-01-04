package p446l7;

import android.os.Handler;
import android.os.Message;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p709vj.C13452e;
import p746wn.C13622a;
import p846zj.C14306d;
import p861do.C9281a;

/* renamed from: l7.d */
/* loaded from: classes2.dex */
public class C11256d extends AbstractC12367d {

    /* renamed from: d */
    public static final Object f52846d = new Object();

    /* renamed from: a */
    public Handler f52847a;

    /* renamed from: b */
    public String f52848b;

    /* renamed from: c */
    public C11060c f52849c;

    public C11256d(WeakReference<Handler> weakReference) {
        this.f52848b = null;
        this.f52849c = null;
        this.f52847a = weakReference.get();
        String strM66627b = C11058a.m66627b("07031");
        this.f52848b = strM66627b;
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "cs.user.client.query", C13452e.m80781L().m80971t0());
        this.f52849c = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: d */
    private void m67590d() {
        Message messageObtain = Message.obtain(this.f52847a);
        synchronized (f52846d) {
            try {
                C9281a c9281a = new C9281a();
                int iM67591c = m67591c();
                if (iM67591c == -1) {
                    C11839m.m70687e("QueryPushGuideTask", "queryIsChildAccount error");
                    HashMap map = new HashMap();
                    map.put("push_guide_type", "push_guide_query");
                    map.put("query_push_guide_status", NotifyConstants.CommonReportConstants.FAILED);
                    map.put("fail_reason", "queryIsChildAccount error");
                    C13622a.m81970p(this.f52849c, map, false);
                }
                if (iM67591c == 1) {
                    C11839m.m70688i("QueryPushGuideTask", "is Child Account, can not show push guide");
                    messageObtain.what = 31004;
                } else {
                    try {
                        messageObtain.what = 31003;
                        messageObtain.obj = c9281a.m58353h();
                        HashMap map2 = new HashMap();
                        map2.put("push_guide_type", "push_guide_query");
                        map2.put("query_push_guide_status", "success");
                        map2.put(TrackConstants$Opers.RESPONSE, messageObtain.obj.toString());
                        C13622a.m81970p(this.f52849c, map2, false);
                    } catch (C9721b e10) {
                        C11839m.m70687e("QueryPushGuideTask", "QueryPushGuideTask failed, " + e10.getMessage());
                        messageObtain.what = 31004;
                        HashMap map3 = new HashMap();
                        map3.put("push_guide_type", "push_guide_query");
                        map3.put("query_push_guide_status", NotifyConstants.CommonReportConstants.FAILED);
                        map3.put("fail_reason", e10.toString());
                        C13622a.m81970p(this.f52849c, map3, false);
                    }
                }
                this.f52847a.sendMessage(messageObtain);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public final int m67591c() {
        String strM80910f = C13452e.m80781L().m80910f();
        if (strM80910f != null && (strM80910f.equals(String.valueOf(1)) || strM80910f.equals(String.valueOf(2)))) {
            return 1;
        }
        C11839m.m70688i("QueryPushGuideTask", "childAccountModeFromLogin can not get result");
        return C14306d.m85215p();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        m67590d();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
