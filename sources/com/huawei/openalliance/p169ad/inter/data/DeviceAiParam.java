package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes2.dex */
public class DeviceAiParam implements Serializable {
    private static final long serialVersionUID = -1906936698381690943L;
    private String basicTargetTag;
    private String creativeLabel;
    private String encryptEcpm;
    private String encryptPrice;
    private String priceType;
    private String tradeMode;

    /* renamed from: a */
    public void m44458a(String str) {
        this.creativeLabel = str;
    }

    /* renamed from: b */
    public void m44459b(String str) {
        this.basicTargetTag = str;
    }

    /* renamed from: c */
    public void m44460c(String str) {
        this.encryptEcpm = str;
    }

    /* renamed from: d */
    public void m44461d(String str) {
        this.encryptPrice = str;
    }

    /* renamed from: e */
    public void m44462e(String str) {
        this.priceType = str;
    }

    /* renamed from: f */
    public void m44463f(String str) {
        this.tradeMode = str;
    }
}
