package com.huawei.hms.findnetwork.callback;

import com.huawei.hms.findnetwork.comm.request.bean.PairingResultBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;

/* loaded from: classes8.dex */
public interface PairingCallback {
    void onPairingFail(FindNetworkConfigResult<PairingResultBean> findNetworkConfigResult);

    void onPairingSuccess(FindNetworkConfigResult<PairingResultBean> findNetworkConfigResult);
}
