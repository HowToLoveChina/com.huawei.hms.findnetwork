package com.huawei.hicloud.notification.manager;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;

/* loaded from: classes6.dex */
public class SpaceNoticeV3Bean {

    @SerializedName("HiCloudSpaceNoticeConfigV3")
    private SpaceNotifyConfig mSpaceNotifyConfig;

    public SpaceNotifyConfig getmSpaceNotifyConfig() {
        return this.mSpaceNotifyConfig;
    }

    public void setmSpaceNotifyConfig(SpaceNotifyConfig spaceNotifyConfig) {
        this.mSpaceNotifyConfig = spaceNotifyConfig;
    }
}
