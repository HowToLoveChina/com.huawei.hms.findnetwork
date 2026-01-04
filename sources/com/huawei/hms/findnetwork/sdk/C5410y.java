package com.huawei.hms.findnetwork.sdk;

import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.MultiTerminalDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.bean.SnRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import java.util.List;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.y */
/* loaded from: classes8.dex */
public class C5410y extends BaseTaskApiCall<HmsClient, SnRequestBean, FindNetworkResult<List<MultiTerminalDeviceInfo>>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.y$b */
    public static class b extends TypeToken<FindNetworkResult<List<MultiTerminalDeviceInfo>>> {
        public b() {
        }
    }

    public C5410y(SnRequestBean snRequestBean) {
        super("findnetwork.multiTerminalDeviceInfo", snRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<List<MultiTerminalDeviceInfo>>> c8941i) {
        int errorCode = responseErrorCode.getErrorCode();
        FindNetworkResult<List<MultiTerminalDeviceInfo>> findNetworkResult = new FindNetworkResult<>();
        findNetworkResult.setRespCode(errorCode);
        FindNetworkResult findNetworkResult2 = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
        if (findNetworkResult2 == null) {
            HmsFindSDKLog.m32127i("MultiTerminalDeviceInfoApiCall", "body parse error");
            c8941i.m56657c(new ApiException(new Status(-1, "body parse error")));
            return;
        }
        findNetworkResult.setData((List) findNetworkResult2.getData());
        findNetworkResult.setDescription(findNetworkResult2.getDescription());
        findNetworkResult.setRespCode(findNetworkResult2.getRespCode());
        HmsFindSDKLog.m32127i("MultiTerminalDeviceInfoApiCall", "success to call multi terminal. fncResult=" + findNetworkResult2.getRespCode());
        if (findNetworkResult.getRespCode() == 0) {
            c8941i.m56658d(findNetworkResult);
        } else {
            c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
        }
    }
}
