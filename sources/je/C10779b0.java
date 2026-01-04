package je;

import jp.C10906b;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: je.b0 */
/* loaded from: classes3.dex */
public class C10779b0 {
    /* renamed from: a */
    public void m65622a() {
        C0212e0.m1351a(C0213f.m1377a(), "negative_feedback_sp");
        C11839m.m70688i("TextLinkManager", "clearNegativeFeedbackSP: SP_FILE_PATH is clear");
    }

    /* renamed from: b */
    public final int m65623b(String str) {
        C11839m.m70688i("TextLinkManager", "getTextLinkShieldCount");
        return C0212e0.m1357g(C0213f.m1377a(), "negative_feedback_sp", str + "_textLinkCount", 0);
    }

    /* renamed from: c */
    public long m65624c(String str) {
        C11839m.m70688i("TextLinkManager", "getTextLinkShieldTime");
        return C0212e0.m1359i(C0213f.m1377a(), "negative_feedback_sp", str + "_textLinkTime", 0L);
    }

    /* renamed from: d */
    public void m65625d(C10906b c10906b) {
        int iM65623b = m65623b(c10906b.m65935g()) + 1;
        m65627f(c10906b.m65935g(), iM65623b);
        m65626e(c10906b, iM65623b);
    }

    /* renamed from: e */
    public final void m65626e(C10906b c10906b, int i10) {
        m65628g(c10906b.m65935g(), System.currentTimeMillis() + (c10906b.m65930b() * 86400000));
        if (i10 >= c10906b.m65940l()) {
            m65628g(c10906b.m65935g(), System.currentTimeMillis() + 3122064000000L);
            C11839m.m70688i("TextLinkManager", "SP textLinkShieldCount is max, next show is 99 years later");
        }
    }

    /* renamed from: f */
    public final void m65627f(String str, int i10) {
        C0212e0.m1368r(C0213f.m1377a(), "negative_feedback_sp", str + "_textLinkCount", i10);
        C11839m.m70688i("TextLinkManager", "SP save textLinkCount : " + i10);
    }

    /* renamed from: g */
    public final void m65628g(String str, long j10) {
        C0212e0.m1370t(C0213f.m1377a(), "negative_feedback_sp", str + "_textLinkTime", j10);
        C11839m.m70688i("TextLinkManager", "SP save textLinkTime : " + j10);
    }
}
