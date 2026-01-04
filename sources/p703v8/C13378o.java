package p703v8;

import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import fk.C9721b;
import p514o9.C11839m;
import sn.C12818a;

/* renamed from: v8.o */
/* loaded from: classes2.dex */
public class C13378o extends C12818a<QuotaInfoRsp> {

    /* renamed from: a */
    public C13377n f60296a = new C13377n();

    @Override // sn.C12818a
    /* renamed from: a */
    public String mo76960a() {
        return "QuotaSummaryDetail";
    }

    /* renamed from: e */
    public QuotaInfoRsp m80309e() {
        try {
            QuotaInfoRsp quotaInfoRspM80308d = this.f60296a.m80308d();
            m76963d(quotaInfoRspM80308d);
            return quotaInfoRspM80308d;
        } catch (C9721b e10) {
            C11839m.m70687e("QuotaSummaryDetailReliableRequestor", "request exception:" + e10.toString());
            return m76961b();
        }
    }
}
