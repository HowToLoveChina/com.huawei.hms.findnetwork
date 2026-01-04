package p703v8;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.space.FullQuotaInfo;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import fk.C9721b;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: v8.n */
/* loaded from: classes2.dex */
public class C13377n {
    /* renamed from: a */
    public final QuotaInfoRsp m80305a(String[] strArr) throws C9721b {
        try {
            return (QuotaInfoRsp) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78757v(strArr), QuotaInfoRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("QuotaInfoRequestor", "doRequest json exception is: " + e10.toString());
            throw new C9721b(1, "json err ");
        }
    }

    /* renamed from: b */
    public QuotaSpaceInfo m80306b() {
        QuotaInfoRsp quotaInfoRspM80305a;
        QuotaSpaceInfo quotaSpaceInfoM80307c = null;
        try {
            quotaInfoRspM80305a = m80305a(new String[]{"quota.summary"});
        } catch (Exception e10) {
            C11839m.m70687e("QuotaInfoRequestor", "getQuotaSummary exception:" + e10.toString());
        }
        if (quotaInfoRspM80305a == null) {
            return null;
        }
        if (quotaInfoRspM80305a.getRetCode() == 0) {
            C11839m.m70688i("QuotaInfoRequestor", "getQuotaSummary Success");
            quotaSpaceInfoM80307c = m80307c(quotaInfoRspM80305a);
            quotaSpaceInfoM80307c.setRetCode(0);
            C13367d.m80177a(quotaSpaceInfoM80307c);
        } else {
            C11839m.m70687e("QuotaInfoRequestor", "getQuotaSummary Failed");
        }
        return quotaSpaceInfoM80307c;
    }

    /* renamed from: c */
    public final QuotaSpaceInfo m80307c(QuotaInfoRsp quotaInfoRsp) {
        QuotaInfo quotaInfo;
        FullQuotaInfo retBody = quotaInfoRsp.getRetBody();
        if (retBody == null || (quotaInfo = retBody.getQuotaInfo()) == null) {
            return null;
        }
        return quotaInfo.getQuotaSpaceInfo();
    }

    /* renamed from: d */
    public QuotaInfoRsp m80308d() throws C9721b {
        return m80305a(new String[]{"quota.summary", "quota.details"});
    }
}
