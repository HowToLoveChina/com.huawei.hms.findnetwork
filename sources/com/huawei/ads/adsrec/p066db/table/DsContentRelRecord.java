package com.huawei.ads.adsrec.p066db.table;

import com.huawei.ads.fund.anno.DataKeep;
import p357i4.AbstractC10440e;

@DataKeep
/* loaded from: classes.dex */
public class DsContentRelRecord extends AbstractC10440e {
    private double adIntentScore;
    private double adMergedScore;
    private double adScore;
    private int adType;
    private String aes128EncryptEcpm;
    private String clientRequestId;
    private String contentId;
    private String dayIntentId1st;
    private String dayIntentId2nd;
    private String dspId;
    private String hostPkgName;
    private String industryId1st;
    private String industryId2nd;
    private int interactionType;
    private String mediaType;
    private String reqIntentId1st;
    private String reqIntentId2nd;
    private long updateTime;

    @Override // p357i4.InterfaceC10441f
    /* renamed from: f */
    public long mo12454f() {
        return 1296000000L;
    }

    @Override // p357i4.InterfaceC10441f
    /* renamed from: i */
    public String mo12455i() {
        return "updateTime<?";
    }

    public String toString() {
        return "DsContentRelRecord{contentId='" + this.contentId + "', clientRequestId='" + this.clientRequestId + "', updateTime='" + this.updateTime + "', mediaType='" + this.mediaType + "', adScore=" + this.adScore + ", adIntentScore=" + this.adIntentScore + ", adMergedScore='" + this.adMergedScore + '}';
    }
}
