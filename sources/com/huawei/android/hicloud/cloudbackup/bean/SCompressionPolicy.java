package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class SCompressionPolicy {
    private String bundles;
    private List<SCompressionPolicyEncoding> encodingConfig;
    private List<String> processStep;
    private int spotCheckAmount;
    private float spotCheckRate;

    public String getBundles() {
        return this.bundles;
    }

    public List<SCompressionPolicyEncoding> getEncodingConfig() {
        return this.encodingConfig;
    }

    public List<String> getProcessStep() {
        return this.processStep;
    }

    public int getSpotCheckAmount() {
        return this.spotCheckAmount;
    }

    public float getSpotCheckRate() {
        return this.spotCheckRate;
    }
}
