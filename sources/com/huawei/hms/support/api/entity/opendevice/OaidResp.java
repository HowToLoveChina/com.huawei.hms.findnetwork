package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class OaidResp extends AbstractMessageEntity {

    /* renamed from: id */
    @Packed
    private String f29794id;

    @Packed
    private boolean isTrackLimited;

    @Packed
    private PendingIntent settingIntent;

    public String getId() {
        return this.f29794id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String str) {
        this.f29794id = str;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean z10) {
        this.isTrackLimited = z10;
    }
}
