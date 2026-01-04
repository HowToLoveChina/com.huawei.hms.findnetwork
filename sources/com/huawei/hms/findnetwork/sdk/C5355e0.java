package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import java.util.HashMap;
import java.util.Map;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.e0 */
/* loaded from: classes8.dex */
public class C5355e0 extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult<DeviceDetail>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.e0$b */
    public static class b extends HashMap<String, Integer> {
    }

    /* renamed from: com.huawei.hms.findnetwork.sdk.e0$c */
    public static class c extends TypeToken<FindNetworkResult<DeviceDetail>> {
        public c() {
        }
    }

    public C5355e0(BaseRequestBean baseRequestBean) {
        super("findnetwork.queryDeviceDetail", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<DeviceDetail>> c8941i) {
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32126e("QueryDeviceDetailApiCall", "handleBusiness invalid, body null.");
            c8941i.m56657c(new ApiException(new Status(-1, "body null")));
            return;
        }
        FindNetworkResult<DeviceDetail> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new c().getType());
        if (findNetworkResult == null) {
            HmsFindSDKLog.m32126e("QueryDeviceDetailApiCall", "handleBusiness invalid, body parse error.");
            c8941i.m56657c(new ApiException(new Status(-1, "body parse error")));
            return;
        }
        if (findNetworkResult.getRespCode() != 0) {
            HmsFindSDKLog.m32126e("QueryDeviceDetailApiCall", "handleBusiness failed. code:" + findNetworkResult.getRespCode());
            c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
            return;
        }
        DeviceDetail data = findNetworkResult.getData();
        if (data == null) {
            HmsFindSDKLog.m32126e("QueryDeviceDetailApiCall", "handleBusiness invalid. device null.");
            c8941i.m56657c(new ApiException(new Status(-1, "device null")));
            return;
        }
        Map map = (Map) JsonUtils.json2Object(data.getAccessoryCapabilities(), b.class);
        if (map != null && map.get(DeviceDetail.CAP_KEY_ULTRA_SOUND) != null && ((Integer) map.get(DeviceDetail.CAP_KEY_ULTRA_SOUND)).intValue() != 0) {
            map.put(DeviceDetail.CAP_KEY_ULTRA_SOUND, Integer.valueOf(C5381n.m32000a().m32025a(hmsClient.getContext(), data.getProductId(), data.getSequence()) ? 1 : 0));
            data.setAccessoryCapabilities(JsonUtils.object2Json(map));
        }
        if ("localDevice".equals(data.getExtendData()) && !C5342a.m31942c().m31947c(hmsClient.getContext()) && map != null && map.containsKey(DeviceDetail.CAP_KEY_LOST_NEAR_LINK_NAVIGATION)) {
            map.put(DeviceDetail.CAP_KEY_LOST_NEAR_LINK_NAVIGATION, 0);
            data.setAccessoryCapabilities(JsonUtils.object2Json(map));
        }
        HmsFindSDKLog.m32127i("QueryDeviceDetailApiCall", "handleBusiness succeed." + data);
        c8941i.m56658d(findNetworkResult);
    }
}
