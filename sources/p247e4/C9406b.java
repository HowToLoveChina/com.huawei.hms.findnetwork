package p247e4;

import android.text.TextUtils;
import com.huawei.ads.adsrec.p066db.table.AdCreativeContentRecord;
import com.huawei.ads.adsrec.p066db.table.AdSlotMapRecord;
import com.huawei.ads.adsrec.p066db.table.MaterialSummaryRecord;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import org.json.JSONException;
import org.json.JSONObject;
import p216d4.C9036w;
import p326h4.InterfaceC10095e;
import p405jt.AbstractC10915a;

/* renamed from: e4.b */
/* loaded from: classes.dex */
public class C9406b implements Cloneable {

    /* renamed from: a */
    public String f47007a;

    /* renamed from: b */
    public String f47008b;

    /* renamed from: c */
    public String f47009c;

    /* renamed from: d */
    public int f47010d;

    /* renamed from: e */
    public String f47011e;

    /* renamed from: f */
    public double f47012f;

    /* renamed from: g */
    @InterfaceC10095e
    public String f47013g;

    /* renamed from: h */
    public AdSlotMapRecord f47014h;

    /* renamed from: i */
    public AdCreativeContentRecord f47015i;

    /* renamed from: j */
    public MaterialSummaryRecord f47016j;

    /* renamed from: k */
    public JSONObject f47017k;

    /* renamed from: l */
    public JSONObject f47018l;

    public C9406b(AdSlotMapRecord adSlotMapRecord, AdCreativeContentRecord adCreativeContentRecord) {
        this.f47012f = -100.0d;
        this.f47010d = 1;
        this.f47014h = adSlotMapRecord;
        this.f47015i = adCreativeContentRecord;
        if (adSlotMapRecord != null) {
            this.f47007a = adSlotMapRecord.m12496y();
            this.f47008b = adSlotMapRecord.m12497z();
            this.f47009c = adSlotMapRecord.m12494w();
        }
        m58972c();
    }

    /* renamed from: a */
    public final JSONObject m58971a(AdSlotMapRecord adSlotMapRecord) {
        if (adSlotMapRecord == null || TextUtils.isEmpty(adSlotMapRecord.m12492t())) {
            return new JSONObject();
        }
        try {
            return new JSONObject(adSlotMapRecord.m12492t());
        } catch (JSONException unused) {
            AbstractC10915a.m65978j("Content", "create valued json obj err");
            return new JSONObject();
        }
    }

    /* renamed from: c */
    public final void m58972c() {
        AdCreativeContentRecord adCreativeContentRecord;
        if (this.f47017k == null) {
            this.f47017k = m58971a(this.f47014h);
            m58983p();
        }
        if (this.f47018l != null || (adCreativeContentRecord = this.f47015i) == null) {
            return;
        }
        this.f47018l = C9036w.m56990d(adCreativeContentRecord.m12460v());
    }

    /* renamed from: d */
    public final void m58973d(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f47009c = jSONObject.optString("contentid");
        this.f47010d = 0;
        this.f47015i = new AdCreativeContentRecord(jSONObject);
        this.f47018l = C9036w.m56990d(jSONObject.optString("metaData"));
        m58983p();
        this.f47016j = new MaterialSummaryRecord(this.f47007a, str, this.f47008b, this.f47009c, jSONObject);
        jSONObject.remove("metaData");
        jSONObject.remove(MapKeyNames.THIRD_MONITORS);
        jSONObject.remove("deviceAiParam");
        this.f47014h = new AdSlotMapRecord(this.f47007a, this.f47008b, jSONObject);
    }

    /* renamed from: f */
    public C9406b m58974f() {
        try {
            C9406b c9406b = (C9406b) super.clone();
            AdCreativeContentRecord adCreativeContentRecord = this.f47015i;
            if (adCreativeContentRecord != null) {
                c9406b.f47015i = (AdCreativeContentRecord) adCreativeContentRecord.m64212n();
            }
            AdSlotMapRecord adSlotMapRecord = this.f47014h;
            if (adSlotMapRecord != null) {
                c9406b.f47014h = (AdSlotMapRecord) adSlotMapRecord.m64212n();
            }
            MaterialSummaryRecord materialSummaryRecord = this.f47016j;
            if (materialSummaryRecord != null) {
                c9406b.f47016j = (MaterialSummaryRecord) materialSummaryRecord.m64212n();
            }
            return c9406b;
        } catch (CloneNotSupportedException unused) {
            AbstractC10915a.m65978j("Content", "copy failed");
            return null;
        }
    }

    /* renamed from: g */
    public AdCreativeContentRecord m58975g() {
        return this.f47015i;
    }

    /* renamed from: i */
    public AdSlotMapRecord m58976i() {
        return this.f47014h;
    }

    /* renamed from: j */
    public String m58977j() {
        return this.f47009c;
    }

    /* renamed from: k */
    public JSONObject m58978k() throws JSONException {
        C9036w.m56988b(this.f47017k, "recallSource", this.f47010d);
        AdCreativeContentRecord adCreativeContentRecord = this.f47015i;
        if (adCreativeContentRecord != null) {
            C9036w.m56989c(this.f47017k, "metaData", C9036w.m56990d(adCreativeContentRecord.m12460v()));
            C9036w.m56989c(this.f47017k, MapKeyNames.THIRD_MONITORS, C9036w.m56987a(this.f47015i.m12461w()));
        }
        return this.f47017k;
    }

    /* renamed from: l */
    public MaterialSummaryRecord m58979l() {
        return this.f47016j;
    }

    /* renamed from: m */
    public String m58980m() {
        return this.f47007a;
    }

    /* renamed from: n */
    public int m58981n() {
        return this.f47010d;
    }

    /* renamed from: o */
    public String m58982o() {
        return this.f47008b;
    }

    /* renamed from: p */
    public final void m58983p() {
        JSONObject jSONObject = this.f47017k;
        if (jSONObject != null) {
            this.f47011e = jSONObject.optString("interactiontype");
            this.f47013g = this.f47017k.optString("dspid");
        }
    }

    public String toString() {
        return "Content{pkgName='" + this.f47007a + "', slotId='" + this.f47008b + "', contentId='" + this.f47009c + "', recallSource='" + this.f47010d + '}';
    }

    public C9406b(String str, String str2, String str3, JSONObject jSONObject) {
        this.f47012f = -100.0d;
        this.f47007a = str;
        this.f47008b = str3;
        this.f47017k = jSONObject;
        m58973d(str2, jSONObject);
    }
}
