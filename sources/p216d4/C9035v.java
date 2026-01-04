package p216d4;

import com.huawei.ads.adsrec.p066db.table.AdContentRspRecord;
import com.huawei.ads.adsrec.p066db.table.AdCreativeContentRecord;
import com.huawei.ads.adsrec.p066db.table.AdEventRecord;
import com.huawei.ads.adsrec.p066db.table.AdIECFeedbackRecord;
import com.huawei.ads.adsrec.p066db.table.AdIECImpRecord;
import com.huawei.ads.adsrec.p066db.table.AdSlotMapRecord;
import com.huawei.ads.adsrec.p066db.table.AdTraceRecord;
import com.huawei.ads.adsrec.p066db.table.DsContentRelRecord;
import com.huawei.ads.adsrec.p066db.table.MaterialSummaryRecord;
import com.huawei.ads.adsrec.p066db.table.SlotRecord;
import p357i4.AbstractC10437b;

/* renamed from: d4.v */
/* loaded from: classes.dex */
public class C9035v extends AbstractC10437b {
    public C9035v(C9033t c9033t) {
        super(c9033t);
        m56985b();
    }

    /* renamed from: b */
    private void m56985b() {
        AdCreativeContentRecord adCreativeContentRecord = new AdCreativeContentRecord();
        AdEventRecord adEventRecord = new AdEventRecord();
        AdIECFeedbackRecord adIECFeedbackRecord = new AdIECFeedbackRecord();
        AdIECImpRecord adIECImpRecord = new AdIECImpRecord();
        AdSlotMapRecord adSlotMapRecord = new AdSlotMapRecord();
        SlotRecord slotRecord = new SlotRecord();
        AdContentRspRecord adContentRspRecord = new AdContentRspRecord();
        AdTraceRecord adTraceRecord = new AdTraceRecord();
        MaterialSummaryRecord materialSummaryRecord = new MaterialSummaryRecord();
        DsContentRelRecord dsContentRelRecord = new DsContentRelRecord();
        this.f50385b.add(adCreativeContentRecord);
        this.f50385b.add(adEventRecord);
        this.f50385b.add(adIECFeedbackRecord);
        this.f50385b.add(adIECImpRecord);
        this.f50385b.add(adSlotMapRecord);
        this.f50385b.add(slotRecord);
        this.f50385b.add(adContentRspRecord);
        this.f50385b.add(adTraceRecord);
        this.f50385b.add(materialSummaryRecord);
        this.f50385b.add(dsContentRelRecord);
        this.f50386c.add(adCreativeContentRecord);
        this.f50386c.add(adEventRecord);
        this.f50386c.add(adIECFeedbackRecord);
        this.f50386c.add(adIECImpRecord);
        this.f50386c.add(adSlotMapRecord);
        this.f50386c.add(slotRecord);
        this.f50386c.add(adContentRspRecord);
        this.f50386c.add(adTraceRecord);
        this.f50386c.add(materialSummaryRecord);
        this.f50386c.add(dsContentRelRecord);
    }

    @Override // p357i4.AbstractC10437b
    /* renamed from: h */
    public String mo56986h() {
        return "AdsRecDbUpdateHelper";
    }
}
