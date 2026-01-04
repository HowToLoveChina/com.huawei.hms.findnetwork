package com.huawei.skytone.servicehub.core;

import com.huawei.skytone.servicehub.serviceinfo.AGRestoreFinalizerProcessorHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.AGRestorePrepareProcessorHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.BackupEventDecisionCenterHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.BackupEventDispatcherHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.BackupFailDecisionMakerHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.BackupNotifyMissionHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.ConditionLimitCycleCheckerHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.ConfigBackupProxyHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.ConfigurableRemoteServiceImplHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.NoticeBeforeBackupDecisionMakerHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.OriginCycleCheckerHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.PPSRestoreFinalizerProcessorHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.PPSRestorePrepareProcessorHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.RefurbishmentCycleCheckerHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.SpaceNotEnoughNotifyOlderHubInfo;
import com.huawei.skytone.servicehub.serviceinfo.SpaceNotEnoughNotifyV5HubInfo;
import com.huawei.skytone.servicehub.serviceinfo.TempBackupCycleCheckerHubInfo;
import nu.C11755h;

/* loaded from: classes5.dex */
public class ServiceHubRegistry {
    public final C11755h infoList = new C11755h(this);

    public void register() {
        this.infoList.add(AGRestoreFinalizerProcessorHubInfo.class);
        this.infoList.add(AGRestorePrepareProcessorHubInfo.class);
        this.infoList.add(BackupNotifyMissionHubInfo.class);
        this.infoList.add(ConditionLimitCycleCheckerHubInfo.class);
        this.infoList.add(ConfigBackupProxyHubInfo.class);
        this.infoList.add(ConfigurableRemoteServiceImplHubInfo.class);
        this.infoList.add(OriginCycleCheckerHubInfo.class);
        this.infoList.add(PPSRestoreFinalizerProcessorHubInfo.class);
        this.infoList.add(PPSRestorePrepareProcessorHubInfo.class);
        this.infoList.add(RefurbishmentCycleCheckerHubInfo.class);
        this.infoList.add(SpaceNotEnoughNotifyOlderHubInfo.class);
        this.infoList.add(SpaceNotEnoughNotifyV5HubInfo.class);
        this.infoList.add(TempBackupCycleCheckerHubInfo.class);
        this.infoList.add(BackupEventDecisionCenterHubInfo.class);
        this.infoList.add(BackupEventDispatcherHubInfo.class);
        this.infoList.add(BackupFailDecisionMakerHubInfo.class);
        this.infoList.add(NoticeBeforeBackupDecisionMakerHubInfo.class);
    }
}
