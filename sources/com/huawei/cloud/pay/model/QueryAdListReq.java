package com.huawei.cloud.pay.model;

import com.huawei.android.hicloud.agd.ads.AdSlot;
import com.huawei.android.hicloud.agd.ads.DeviceInfo;
import com.huawei.android.hicloud.agd.ads.MediaInfo;
import com.huawei.android.hicloud.agd.ads.NetworkInfo;
import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.List;

/* loaded from: classes5.dex */
public class QueryAdListReq extends Request {
    private AdSlot adSlot;
    private List<RestoreAdAppInfo> appInfoList;
    private DeviceInfo deviceInfo;
    private MediaInfo mediaInfo;
    private NetworkInfo networkInfo;
    private int queryType;
    private String requestId;

    public QueryAdListReq(AdSlot adSlot, String str) {
        super(NotifyConstants.CommonReportConstants.SRC_QUERY_AD_LIST);
        this.adSlot = adSlot;
        this.mediaInfo = new MediaInfo();
        this.networkInfo = new NetworkInfo();
        this.requestId = str;
        this.deviceInfo = new DeviceInfo();
    }

    public AdSlot getAdSlot() {
        return this.adSlot;
    }

    public List<RestoreAdAppInfo> getAppInfoList() {
        return this.appInfoList;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    public int getQueryType() {
        return this.queryType;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAdSlot(AdSlot adSlot) {
        this.adSlot = adSlot;
    }

    public void setAppInfoList(List<RestoreAdAppInfo> list) {
        this.appInfoList = list;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public void setNetworkInfo(NetworkInfo networkInfo) {
        this.networkInfo = networkInfo;
    }

    public void setQueryType(int i10) {
        this.queryType = i10;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
