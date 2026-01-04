package p732w8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.hicloud.commonlib.space.QuotaDetail;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import java.util.HashMap;
import p015ak.C0209d;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p703v8.C13375l;
import p703v8.C13376m;

/* renamed from: w8.b0 */
/* loaded from: classes2.dex */
public class C13551b0 extends AbstractC12367d {

    /* renamed from: a */
    public Handler f60954a;

    /* renamed from: b */
    public int f60955b = C0209d.m1260h0(1, 10000);

    public C13551b0(Handler handler) {
        this.f60954a = handler;
    }

    /* renamed from: c */
    public final void m81493c(int i10, long j10) {
        Message messageObtainMessage = this.f60954a.obtainMessage();
        messageObtainMessage.what = i10;
        Bundle bundle = new Bundle();
        bundle.putLong("cloud_drive_recycle_size", j10);
        messageObtainMessage.setData(bundle);
        this.f60954a.sendMessage(messageObtainMessage);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        QuotaUsedInfoRsp quotaUsedInfoRspM80301b;
        C13375l c13375l = new C13375l();
        HashMap map = new HashMap();
        map.put("operation", "QuotaUsedInfoTask_Drive_Recycle");
        map.put(MapKeyNames.REQUEST_ID, String.valueOf(this.f60955b));
        try {
            quotaUsedInfoRspM80301b = c13375l.m80301b();
        } catch (Exception e10) {
            C11839m.m70687e("QuotaUsedInfoTask", "call exception:" + e10.toString());
            map.put("result", "0");
            map.put("error_reason", "009");
            if (e10 instanceof C9721b) {
                map.put("error_reason", "008");
                map.put("brief", String.valueOf(((C9721b) e10).m60659c()));
            }
            m81493c(1, 0L);
        }
        if (quotaUsedInfoRspM80301b == null) {
            C11839m.m70688i("QuotaUsedInfoTask", "quotaRsp is null");
            map.put("result", "0");
            map.put("error_reason", "001");
            C13376m.m80302a().m80304c(map);
            m81493c(1, 0L);
            return;
        }
        int retCode = quotaUsedInfoRspM80301b.getRetCode();
        QuotaDetail[] quotaDetails = quotaUsedInfoRspM80301b.getQuotaDetails();
        if (retCode == 0) {
            C11839m.m70688i("QuotaUsedInfoTask", "quotausedinfo request success");
            map.put("result", "1");
            long recordsQuotadSpace = 0;
            if (quotaDetails.length > 0) {
                for (QuotaDetail quotaDetail : quotaDetails) {
                    recordsQuotadSpace += quotaDetail.getRecordsQuotadSpace() + quotaDetail.getAssetsQuotadSpace();
                }
            }
            C11839m.m70688i("QuotaUsedInfoTask", "quotausedinfo clouddrive recycle size:" + recordsQuotadSpace);
            m81493c(0, recordsQuotadSpace);
        } else {
            C11839m.m70688i("QuotaUsedInfoTask", "quotausedinfo request failed");
            map.put("result", "0");
            m81493c(1, 0L);
        }
        C13376m.m80302a().m80304c(map);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.FAMILY_SHARE;
    }
}
