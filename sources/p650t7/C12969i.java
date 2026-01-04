package p650t7;

import com.huawei.android.hicloud.album.service.hihttp.request.response.BaseResponse;
import com.huawei.android.hicloud.drive.cloudphoto.model.UpsertStatusRequest;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.IOException;
import p031b7.C1120a;
import p031b7.C1122c;

/* renamed from: t7.i */
/* loaded from: classes2.dex */
public class C12969i extends AbstractC12988v<BaseResponse> {
    @Override // p650t7.AbstractC12988v
    /* renamed from: k */
    public BaseResponse mo77904k(Class<BaseResponse> cls) {
        int iM6802l0;
        String string;
        BaseResponse baseResponse = new BaseResponse();
        try {
            try {
                UpsertStatusRequest upsertStatusRequest = new UpsertStatusRequest();
                upsertStatusRequest.setKey("suspend");
                upsertStatusRequest.setStatus(FaqConstants.DISABLE_HA_REPORT);
                this.f61708b.m83560q().upsert(upsertStatusRequest).execute();
            } catch (IOException e10) {
                C1120a.m6676e("DisuseExecutor", "DisuseExecutor runTask IOException: " + e10.toString());
                if (e10 instanceof C4616s) {
                    iM6802l0 = C1122c.m6802l0((C4616s) e10);
                    string = e10.toString();
                } else {
                    iM6802l0 = C1122c.m6845x0(e10);
                    string = e10.toString();
                }
                baseResponse.setCode(iM6802l0);
                baseResponse.setInfo(string);
                return baseResponse;
            } catch (Exception e11) {
                C1120a.m6676e("DisuseExecutor", "DisuseExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                baseResponse.setCode(iM6802l0);
                baseResponse.setInfo(string);
                return baseResponse;
            }
            return baseResponse;
        } finally {
            baseResponse.setCode(0);
            baseResponse.setInfo("OK");
        }
    }
}
