package com.huawei.hms.findnetwork.sdk;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall;
import com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean;
import com.huawei.hms.findnetwork.comm.request.bean.DeviceDetail;
import com.huawei.hms.findnetwork.comm.request.bean.PairedDeviceInfo;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkResult;
import com.huawei.hms.findnetwork.comm.util.CollectionUtil;
import com.huawei.hms.findnetwork.comm.util.JsonUtils;
import com.huawei.hms.findnetwork.comm.util.MaskUtil;
import com.huawei.hms.findnetwork.sdk.C5355e0;
import com.huawei.hms.findnetwork.util.HmsFindSDKLog;
import com.huawei.hms.support.api.client.Status;
import java.util.List;
import java.util.Map;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.findnetwork.sdk.l0 */
/* loaded from: classes8.dex */
public class C5376l0 extends BaseTaskApiCall<HmsClient, BaseRequestBean, FindNetworkResult<List<PairedDeviceInfo>>> {

    /* renamed from: com.huawei.hms.findnetwork.sdk.l0$b */
    public static class b extends TypeToken<FindNetworkResult<List<PairedDeviceInfo>>> {
        public b() {
        }
    }

    public C5376l0(BaseRequestBean baseRequestBean) {
        super("findnetwork.queryPairedDevices", baseRequestBean);
    }

    @Override // com.huawei.hms.findnetwork.comm.request.BaseTaskApiCall
    public void handleBusiness(HmsClient hmsClient, ResponseErrorCode responseErrorCode, String str, C8941i<FindNetworkResult<List<PairedDeviceInfo>>> c8941i) {
        Map map;
        ApiException apiException;
        if (TextUtils.isEmpty(str)) {
            HmsFindSDKLog.m32127i("QueryPairedDevicesApiCall", "body null");
            apiException = new ApiException(new Status(-1, "body null"));
        } else {
            FindNetworkResult<List<PairedDeviceInfo>> findNetworkResult = (FindNetworkResult) JsonUtils.json2Object(str, new b().getType());
            if (findNetworkResult != null) {
                HmsFindSDKLog.m32127i("QueryPairedDevicesApiCall", "success to call query paired devices. fncResult=" + findNetworkResult.getRespCode());
                if (findNetworkResult.getRespCode() != 0) {
                    c8941i.m56657c(new ApiException(new Status(findNetworkResult.getRespCode(), findNetworkResult.getDescription())));
                    return;
                }
                List<PairedDeviceInfo> data = findNetworkResult.getData();
                if (CollectionUtil.isEmpty(data)) {
                    c8941i.m56658d(findNetworkResult);
                    return;
                }
                for (PairedDeviceInfo pairedDeviceInfo : data) {
                    if (pairedDeviceInfo != null && (map = (Map) JsonUtils.json2Object(pairedDeviceInfo.getAccessoryCapabilities(), C5355e0.b.class)) != null && map.get(DeviceDetail.CAP_KEY_ULTRA_SOUND) != null && ((Integer) map.get(DeviceDetail.CAP_KEY_ULTRA_SOUND)).intValue() != 0) {
                        boolean zM32025a = C5381n.m32000a().m32025a(hmsClient.getContext(), pairedDeviceInfo.getProductId(), pairedDeviceInfo.getSequence());
                        map.put(DeviceDetail.CAP_KEY_ULTRA_SOUND, Integer.valueOf(zM32025a ? 1 : 0));
                        pairedDeviceInfo.setAccessoryCapabilities(JsonUtils.object2Json(map));
                        HmsFindSDKLog.m32127i("QueryPairedDevicesApiCall", MaskUtil.maskSn(pairedDeviceInfo.getSn()) + " supportResult:" + (zM32025a ? 1 : 0) + ", productId:" + pairedDeviceInfo.getProductId() + ", sequence:" + pairedDeviceInfo.getSequence());
                    }
                }
                c8941i.m56658d(findNetworkResult);
                return;
            }
            HmsFindSDKLog.m32127i("QueryPairedDevicesApiCall", "body parse error");
            apiException = new ApiException(new Status(-1, "body parse error"));
        }
        c8941i.m56657c(apiException);
    }
}
