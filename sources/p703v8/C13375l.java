package p703v8;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import fk.C9721b;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: v8.l */
/* loaded from: classes2.dex */
public class C13375l {
    /* renamed from: a */
    public long m80300a(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("QuotaInfoModuleRequestor", "moduleName null");
            return -1L;
        }
        try {
            C11839m.m70688i("QuotaInfoModuleRequestor", "moduleName=" + str);
            QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78760y(str), QuotaUsedInfoRsp.class);
            if (quotaUsedInfoRsp == null || quotaUsedInfoRsp.getRetCode() != 0) {
                return -1L;
            }
            return quotaUsedInfoRsp.getUsed();
        } catch (Exception e10) {
            C11839m.m70687e("QuotaInfoModuleRequestor", "get quotaUsedInfo exception:" + e10.toString() + ", url=" + str);
            return -1L;
        }
    }

    /* renamed from: b */
    public QuotaUsedInfoRsp m80301b() throws C9721b {
        String strM78702A = new C13049a(EnumC12999a.CLOUD_MORE, null).m78702A();
        C11839m.m70686d("QuotaInfoModuleRequestor", "requestCarryParams response=" + strM78702A);
        try {
            return (QuotaUsedInfoRsp) new Gson().fromJson(strM78702A, QuotaUsedInfoRsp.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("QuotaInfoModuleRequestor", "requestCarryParams json exception is: " + e10.toString());
            throw new C9721b(1, "json err ");
        }
    }
}
