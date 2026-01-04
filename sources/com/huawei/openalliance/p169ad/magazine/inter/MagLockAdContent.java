package com.huawei.openalliance.p169ad.magazine.inter;

import com.huawei.openalliance.p169ad.C7202hw;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface MagLockAdContent {

    @OuterVisible
    public static final class Builder {
        @OuterVisible
        public final MagLockAdContent build() {
            return new C7202hw();
        }
    }

    String getAdLabelStr();

    String getAdSign();

    int getAppType();

    String getContentId();

    String getContentUrl();

    String getDeeplinkUrl();

    String getDescription();

    long getEndTime();

    long getFileSize();

    String getImagePath();

    int getInteractionType();

    String getLabel();

    String getMetaData();

    String getMonitor();

    String getParamFromServer();

    String getPreviewSha256();

    String getPreviewUrl();

    String getSha256();

    String getTargetAppName();

    String getTargetPkgName();

    String getTitle();

    String getUrl();

    void setContentId(String str);

    void setDescription(String str);

    void setEndTime(long j10);

    void setFileSize(long j10);

    void setMetaData(String str);

    void setMonitor(String str);

    void setParamFromServer(String str);

    void setPreviewSha256(String str);

    void setPreviewUrl(String str);

    void setSha256(String str);

    void setTitle(String str);

    void setUrl(String str);
}
