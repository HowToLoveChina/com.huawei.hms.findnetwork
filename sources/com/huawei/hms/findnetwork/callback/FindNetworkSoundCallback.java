package com.huawei.hms.findnetwork.callback;

import com.huawei.hms.findnetwork.comm.request.bean.SoundRequestBean;
import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;

/* loaded from: classes8.dex */
public interface FindNetworkSoundCallback {
    void onFail(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult);

    void onFinished(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult);

    void onSuccess(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult);

    void onUpdate(FindNetworkConfigResult<SoundRequestBean> findNetworkConfigResult);
}
