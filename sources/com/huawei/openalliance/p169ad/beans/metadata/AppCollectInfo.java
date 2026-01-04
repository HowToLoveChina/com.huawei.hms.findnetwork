package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6934f;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AppCollectInfo {
    private List<AppCollectInfo> appHourInfos;
    private String appName;
    private String appSign;
    private String channelInfo;
    private Long clctEndT;
    private Long clctStartT;
    private String contentId;
    private String dstPage;
    private String dstPkg;
    private Long firstTimeStamp;
    private Long firstTimeUsed;
    private List<HapModuleInfo> hapModules;
    private String installMode;
    private Long lastTimeStamp;
    private Long lastTimeUsed;
    private Integer launchCount;

    @InterfaceC6934f
    private int launchCountType;
    private Long mobileDataSize;
    private Boolean mulFrame;
    private String packageName;
    private String reportSource;
    private String srcPage;
    private String srcPkg;
    private String taskId;
    private long totalTime;
    private Long triggerTime;
    private String versionName;
    private Long wifiDataSize;
}
