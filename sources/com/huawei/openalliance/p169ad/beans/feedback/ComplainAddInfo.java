package com.huawei.openalliance.p169ad.beans.feedback;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.constant.Constants;

@DataKeep
/* loaded from: classes8.dex */
public class ComplainAddInfo {

    @InterfaceC6929a
    private String appId = Constants.COMPLAIN_APP_ID;
    private String sceneId = "2";
    private String subSceneId = "6";

    @InterfaceC6929a
    private String deviceId = "";
    private boolean disableUserUpload = true;
    private AdditionalContext additionalContext = new AdditionalContext();

    /* renamed from: a */
    public AdditionalContext m39268a() {
        return this.additionalContext;
    }

    /* renamed from: a */
    public void m39269a(AdditionalContext additionalContext) {
        this.additionalContext = additionalContext;
    }

    /* renamed from: a */
    public void m39270a(String str) {
        this.deviceId = str;
    }
}
