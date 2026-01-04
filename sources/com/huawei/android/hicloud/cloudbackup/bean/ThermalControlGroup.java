package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import ne.C11667a;
import p292fn.C9733f;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ThermalControlGroup extends AbsThermalControl {
    private static final String TAG = "ThermalControlGroup";
    private ThermalPolicy currentPolicy;
    public List<ThermalDevices> effectDevices;
    public List<ThermalPolicy> policies;

    private ThermalPolicy getPolicyById(int i10) {
        List<ThermalPolicy> list = this.policies;
        if (list == null) {
            C11839m.m70688i(TAG, "policies is null");
            return null;
        }
        for (ThermalPolicy thermalPolicy : list) {
            if (thermalPolicy.getId() == i10) {
                return thermalPolicy;
            }
        }
        return null;
    }

    private boolean isCommonParamsInvalid() {
        return this.thermalRetryInteval < 0 || this.blowoutThreshold < 0 || this.blowoutDuration < 0;
    }

    private boolean isEffectiveDevicesEmpty() {
        List<ThermalDevices> list = this.effectDevices;
        if (list != null && list.size() != 0) {
            return false;
        }
        C11839m.m70687e(TAG, "effectDevices is null or empty");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$isCurrentDeviceMatched$0(ThermalDevices thermalDevices) {
        return super.isCurrentDeviceMatched(thermalDevices.getDevices());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setCurrentThermalPolicy$1(ThermalDevices thermalDevices) {
        return super.isCurrentDeviceMatched(thermalDevices.getDevices());
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public boolean checkIllegalArgument() {
        if (isCommonParamsInvalid()) {
            C11839m.m70688i(TAG, "common params invalid.");
            return true;
        }
        ThermalPolicy thermalPolicy = this.currentPolicy;
        if (thermalPolicy == null) {
            return true;
        }
        return thermalPolicy.isArgumentInvalid();
    }

    public ThermalPolicy getCurrentPolicy() {
        return this.currentPolicy;
    }

    public List<ThermalDevices> getEffectDevice() {
        return this.effectDevices;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getStartLevel() {
        if (this.currentPolicy == null) {
            C11839m.m70687e(TAG, "currentPolicy is null.");
            return -1;
        }
        if (C9733f.m60705z().m60720O("cloudBackupPriorityThermalControl") && localTimeInPriorityTimeScope()) {
            C11839m.m70688i(TAG, "return priorityStartLevel.");
            return this.currentPolicy.getPriorityStartLevel();
        }
        C11839m.m70688i(TAG, "return normalStartLevel.");
        return this.currentPolicy.getStartLevel();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public int getStopLevel() {
        if (this.currentPolicy == null) {
            C11839m.m70687e(TAG, "currentPolicy is null.");
            return -1;
        }
        if (C9733f.m60705z().m60720O("cloudBackupPriorityThermalControl") && localTimeInPriorityTimeScope()) {
            C11839m.m70688i(TAG, "return priorityStopLevel.");
            return this.currentPolicy.getPriorityStopLevel();
        }
        C11839m.m70688i(TAG, "return normalStopLevel.");
        return this.currentPolicy.getStopLevel();
    }

    @Override // com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl
    public boolean isCurrentDeviceMatched() {
        if (isEffectiveDevicesEmpty()) {
            return false;
        }
        return this.effectDevices.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.bean.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f11664a.lambda$isCurrentDeviceMatched$0((ThermalDevices) obj);
            }
        }).findFirst().isPresent();
    }

    public boolean localTimeInPriorityTimeScope() {
        Date date = new Date();
        for (TimeScope timeScope : this.currentPolicy.getPriorityTimeScope()) {
            if (C11667a.m69671m(date, timeScope.getStartTime(), timeScope.getEndTime(), "HH:mm")) {
                return true;
            }
        }
        C11839m.m70688i(TAG, "local time is not in priority time scope.");
        return false;
    }

    public void setCurrentThermalPolicy() {
        if (isEffectiveDevicesEmpty()) {
            return;
        }
        Optional<ThermalDevices> optionalFindFirst = this.effectDevices.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.bean.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f11663a.lambda$setCurrentThermalPolicy$1((ThermalDevices) obj);
            }
        }).findFirst();
        if (optionalFindFirst.isPresent()) {
            this.currentPolicy = getPolicyById(optionalFindFirst.get().getPolicyId());
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("thermalControlGroup:{");
        stringBuffer.append(", uniStopLevel=");
        stringBuffer.append(this.uniStopLevel);
        stringBuffer.append(", thermalRetryInteval=");
        stringBuffer.append(this.thermalRetryInteval);
        stringBuffer.append(", blowoutThreshold=");
        stringBuffer.append(this.blowoutThreshold);
        stringBuffer.append(", blowoutDuration=");
        stringBuffer.append(this.blowoutDuration);
        stringBuffer.append(", effectDevices=");
        stringBuffer.append(this.effectDevices);
        stringBuffer.append(", currentPolicy=");
        stringBuffer.append(this.currentPolicy);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
