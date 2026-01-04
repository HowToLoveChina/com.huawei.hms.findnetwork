package com.huawei.ads.adsrec;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
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
import com.huawei.ads.fund.p067db.BaseDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p216d4.AbstractC9017j0;
import p216d4.AbstractC9019k0;
import p216d4.C8998a;
import p216d4.C9005d0;
import p216d4.C9027o0;
import p216d4.C9031r;
import p216d4.C9033t;
import p216d4.InterfaceC9006e;
import p216d4.InterfaceC9024n;
import p216d4.InterfaceC9026o;
import p216d4.InterfaceC9030q;
import p247e4.C9405a;
import p247e4.C9406b;
import p357i4.AbstractC10436a;
import p357i4.C10438c;
import p384j4.AbstractC10706e;
import p384j4.AbstractC10707f;
import p405jt.AbstractC10915a;

/* renamed from: com.huawei.ads.adsrec.e */
/* loaded from: classes.dex */
public class C2093e extends BaseDao implements InterfaceC9024n {
    public C2093e(Context context) {
        super(context);
    }

    /* renamed from: A */
    public final void m12520A(C9406b c9406b) {
        m12566l(InterfaceC9026o.f45667c, new Object[]{Long.valueOf(System.currentTimeMillis()), c9406b.m58980m(), c9406b.m58977j()});
    }

    /* renamed from: B */
    public final boolean m12521B(String str, String[] strArr) {
        Arrays.toString(strArr);
        if (!AbstractC10706e.m65375b(strArr)) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: C */
    public final String[] m12522C(String str, int i10) {
        List<String> listM56927a = AbstractC9017j0.m56927a(str, i10);
        if (!AbstractC10706e.m65374a(listM56927a)) {
            return (String[]) listM56927a.toArray(new String[listM56927a.size()]);
        }
        InterfaceC9006e interfaceC9006eM56860d = C8998a.m56860d();
        return interfaceC9006eM56860d != null ? interfaceC9006eM56860d.getAllowCachedTradeModeList(str, String.valueOf(i10)) : InterfaceC9030q.f45682a;
    }

    /* renamed from: D */
    public final C10438c m12523D(AdContentRspRecord adContentRspRecord) {
        return new C10438c(adContentRspRecord.mo64206d(), null, null, "pkgName=?", new String[]{adContentRspRecord.m12457u()}, adContentRspRecord.m64217s(this.f9507a));
    }

    /* renamed from: E */
    public final void m12524E(AdEventRecord adEventRecord) {
        String strM12465C = adEventRecord.m12465C();
        strM12465C.hashCode();
        switch (strM12465C) {
            case "repeatedClick":
            case "click":
                m12545w(adEventRecord);
                m12546x(adEventRecord, 1);
                break;
            case "imp":
            case "repeatedImp":
                m12526G(adEventRecord);
                m12546x(adEventRecord, 0);
                break;
            case "userclose":
                m12525F(adEventRecord);
                break;
        }
    }

    /* renamed from: F */
    public final void m12525F(AdEventRecord adEventRecord) {
        if (C9027o0.m56955b(this.f9507a).m56959e(adEventRecord.m12472K()) == 0) {
            return;
        }
        String[] strArr = {adEventRecord.m12477x()};
        List listM12569o = m12569o(AdIECFeedbackRecord.class, null, "contentId=?", strArr, null, null);
        if (AbstractC10706e.m65374a(listM12569o)) {
            AdIECFeedbackRecord adIECFeedbackRecord = new AdIECFeedbackRecord();
            adIECFeedbackRecord.m12482v(adEventRecord.m12477x());
            adIECFeedbackRecord.m12480t(1);
            m12567m(AdIECFeedbackRecord.class, adIECFeedbackRecord.m64216r());
        } else {
            AdIECFeedbackRecord adIECFeedbackRecord2 = (AdIECFeedbackRecord) listM12569o.get(0);
            adIECFeedbackRecord2.m12480t(1);
            adIECFeedbackRecord2.m12481u(System.currentTimeMillis());
            m12571q(AdIECFeedbackRecord.class, adIECFeedbackRecord2.m64216r(), "contentId=?", strArr);
        }
        m12564j(AdSlotMapRecord.class, null, null);
        m12564j(AdCreativeContentRecord.class, null, null);
        m12564j(MaterialSummaryRecord.class, null, null);
    }

    /* renamed from: G */
    public final void m12526G(AdEventRecord adEventRecord) {
        m12566l(InterfaceC9026o.f45665a, new Object[]{adEventRecord.m12467E(), adEventRecord.m12472K(), adEventRecord.m12477x()});
        String[] strArr = {adEventRecord.m12467E(), adEventRecord.m12477x()};
        List listM12569o = m12569o(AdIECImpRecord.class, null, "pkgName=? and contentId=?", strArr, null, null);
        if (!AbstractC10706e.m65374a(listM12569o)) {
            AdIECImpRecord adIECImpRecord = (AdIECImpRecord) listM12569o.get(0);
            adIECImpRecord.m12486v(adEventRecord.m12463A());
            adIECImpRecord.m12485u(adIECImpRecord.m12483A() + 1);
            adIECImpRecord.m12489y(System.currentTimeMillis());
            m12571q(AdIECImpRecord.class, adIECImpRecord.m64216r(), "pkgName=? and contentId=?", strArr);
            return;
        }
        AdIECImpRecord adIECImpRecord2 = new AdIECImpRecord();
        adIECImpRecord2.m12490z(adEventRecord.m12467E());
        adIECImpRecord2.m12487w(adEventRecord.m12477x());
        adIECImpRecord2.m12486v(adEventRecord.m12463A());
        adIECImpRecord2.m12485u(1);
        m12567m(AdIECImpRecord.class, adIECImpRecord2.m64216r());
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: a */
    public C9031r mo12527a(String str, String str2) {
        List listM12569o = m12569o(SlotRecord.class, null, "pkgName=? and slotId=?", new String[]{str, str2}, null, null);
        return !AbstractC10706e.m65374a(listM12569o) ? new C9031r((SlotRecord) listM12569o.get(0)) : new C9031r(str, str2);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: b */
    public AdContentRspRecord mo12532b(String str) {
        List listM12569o = m12569o(AdContentRspRecord.class, null, "pkgName=?", new String[]{str}, null, null);
        if (AbstractC10706e.m65374a(listM12569o)) {
            return null;
        }
        return (AdContentRspRecord) listM12569o.get(0);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: c */
    public void mo12536c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(jSONArray.optString(i10));
        }
        m12565k(AdCreativeContentRecord.class, "contentId=?", arrayList);
        m12565k(AdSlotMapRecord.class, "contentId=?", arrayList);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: d */
    public void mo12537d(AdContentRspRecord adContentRspRecord) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(m12523D(adContentRspRecord));
        m12568n(arrayList);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: e */
    public List<C9406b> mo12538e(C10438c c10438c) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList(5);
        AbstractC10436a abstractC10436a = null;
        Cursor cursorM64178Y = null;
        try {
            AbstractC10436a abstractC10436aMo12533b = mo12533b();
            try {
                cursorM64178Y = abstractC10436aMo12533b.m64178Y(c10438c.m64195a(), c10438c.m64196b());
                if (cursorM64178Y != null) {
                    while (cursorM64178Y.moveToNext()) {
                        try {
                            AdCreativeContentRecord adCreativeContentRecord = new AdCreativeContentRecord();
                            AdSlotMapRecord adSlotMapRecord = new AdSlotMapRecord();
                            adCreativeContentRecord.m64215q(cursorM64178Y);
                            adSlotMapRecord.m64215q(cursorM64178Y);
                            arrayList.add(new C9406b(adSlotMapRecord, adCreativeContentRecord));
                        } catch (Throwable th2) {
                            AbstractC10915a.m65970b(mo12528a(), "queryContents:" + th2.getClass().getSimpleName());
                        }
                    }
                }
                m12563i(cursorM64178Y);
                m12570p(abstractC10436aMo12533b);
            } catch (Throwable th3) {
                th = th3;
                cursor = cursorM64178Y;
                abstractC10436a = abstractC10436aMo12533b;
                try {
                    AbstractC10915a.m65971c(mo12528a(), "queryContents exception: %s", th.getClass().getSimpleName());
                    return arrayList;
                } finally {
                    m12563i(cursor);
                    m12570p(abstractC10436a);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return arrayList;
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: f */
    public void mo12539f(List<C9031r> list) {
        if (AbstractC10706e.m65374a(list)) {
            return;
        }
        ArrayList<SlotRecord> arrayList = new ArrayList(list.size());
        Iterator<C9031r> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m56977r());
        }
        if (AbstractC10706e.m65374a(arrayList)) {
            AbstractC10915a.m65978j("AdRecDao", "all slotRecords: empty");
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (SlotRecord slotRecord : arrayList) {
            if (slotRecord != null) {
                arrayList2.add(m12543u(slotRecord));
            }
        }
        m12568n(arrayList2);
    }

    /* renamed from: r */
    public final C10438c m12540r(AdCreativeContentRecord adCreativeContentRecord) {
        return new C10438c(adCreativeContentRecord.mo64206d(), null, null, "contentId=?", new String[]{adCreativeContentRecord.m12459u()}, adCreativeContentRecord.m64217s(this.f9507a));
    }

    /* renamed from: s */
    public final C10438c m12541s(AdSlotMapRecord adSlotMapRecord) {
        return new C10438c(adSlotMapRecord.mo64206d(), null, null, "pkgName=? and slotId=? and contentId=?", new String[]{adSlotMapRecord.m12496y(), adSlotMapRecord.m12497z(), adSlotMapRecord.m12494w()}, adSlotMapRecord.m64217s(this.f9507a));
    }

    /* renamed from: t */
    public final C10438c m12542t(MaterialSummaryRecord materialSummaryRecord) {
        return new C10438c(materialSummaryRecord.mo64206d(), null, null, "pkgName=? and adType=? and slotId=? and contentId=?", new String[]{materialSummaryRecord.m12513w(), materialSummaryRecord.m12510t(), materialSummaryRecord.m12514x(), materialSummaryRecord.m12511u()}, materialSummaryRecord.m64217s(this.f9507a));
    }

    /* renamed from: u */
    public final C10438c m12543u(SlotRecord slotRecord) {
        return new C10438c(slotRecord.mo64206d(), null, null, "pkgName=? and slotId=?", new String[]{slotRecord.m12518u(), slotRecord.m12519v()}, slotRecord.m64217s(this.f9507a));
    }

    /* renamed from: v */
    public String m12544v(String str, AdEventRecord adEventRecord, int i10) {
        try {
            JSONArray jSONArray = AbstractC10707f.m65379d(str) ? new JSONArray() : new JSONArray(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", AbstractC10707f.m65385j(adEventRecord.m12471J()));
            if (i10 == 0) {
                jSONObject.put("range", adEventRecord.m12469G());
            }
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Throwable th2) {
            AbstractC10915a.m65977i(3, th2);
            AbstractC10915a.m65970b("AdRecDao", "build json array error");
            return null;
        }
    }

    /* renamed from: w */
    public final void m12545w(AdEventRecord adEventRecord) {
        m12566l(InterfaceC9026o.f45666b, new Object[]{adEventRecord.m12467E(), adEventRecord.m12472K(), adEventRecord.m12477x()});
    }

    /* renamed from: x */
    public final void m12546x(AdEventRecord adEventRecord, int i10) {
        C10438c c10438c;
        if (C9005d0.m56871a()) {
            String strM12477x = adEventRecord.m12477x();
            String strM12473t = adEventRecord.m12473t();
            if (AbstractC10706e.m65374a(m12569o(DsContentRelRecord.class, null, "clientRequestId=? and contentId=?", new String[]{strM12473t, strM12477x}, null, null))) {
                return;
            }
            String strM56932a = AbstractC9019k0.m56932a(strM12473t);
            List listM12569o = m12569o(AdTraceRecord.class, null, "uniqueId=? and contentId=?", new String[]{strM56932a, strM12477x}, null, "1");
            listM12569o.size();
            ArrayList arrayList = new ArrayList();
            if (AbstractC10706e.m65374a(listM12569o)) {
                AdTraceRecord adTraceRecord = new AdTraceRecord();
                adTraceRecord.m12505v(true);
                adTraceRecord.m12502E(strM56932a);
                adTraceRecord.m12509z(strM12477x);
                List listM12569o2 = m12569o(AdCreativeContentRecord.class, null, "contentId=?", new String[]{strM12477x}, null, null);
                if (!AbstractC10706e.m65374a(listM12569o2) && listM12569o2.get(0) != null) {
                    adTraceRecord.m12500C(((AdCreativeContentRecord) listM12569o2.get(0)).m12462x());
                }
                List listM12569o3 = m12569o(MaterialSummaryRecord.class, null, "contentId=? and pkgName=? and slotId=?", new String[]{strM12477x, adEventRecord.m12467E(), adEventRecord.m12472K()}, null, "1");
                if (!AbstractC10706e.m65374a(listM12569o3) && listM12569o3.get(0) != null) {
                    adTraceRecord.m12504u(((MaterialSummaryRecord) listM12569o3.get(0)).m12515y());
                }
                adTraceRecord.m12503t(System.currentTimeMillis());
                if (i10 == 0) {
                    adTraceRecord.m12499B(m12544v(null, adEventRecord, i10));
                }
                if (i10 == 1) {
                    adTraceRecord.m12507x(m12544v(null, adEventRecord, i10));
                }
                c10438c = new C10438c(AdTraceRecord.class.getSimpleName(), null, null, "uniqueId=? and contentId=?", new String[]{strM56932a, strM12477x}, adTraceRecord.m64216r());
            } else {
                AdTraceRecord adTraceRecord2 = (AdTraceRecord) listM12569o.get(0);
                if (i10 == 0) {
                    String strM12544v = m12544v(adTraceRecord2.m12498A(), adEventRecord, i10);
                    if (!AbstractC10707f.m65379d(strM12544v)) {
                        adTraceRecord2.m12499B(strM12544v);
                    }
                } else if (i10 == 1) {
                    String strM12544v2 = m12544v(adTraceRecord2.m12506w(), adEventRecord, i10);
                    if (!AbstractC10707f.m65379d(strM12544v2)) {
                        adTraceRecord2.m12507x(strM12544v2);
                    }
                }
                List listM12569o4 = m12569o(MaterialSummaryRecord.class, null, "contentId=? and pkgName=? and slotId=?", new String[]{strM12477x, adEventRecord.m12467E(), adEventRecord.m12472K()}, null, "1");
                if (!AbstractC10706e.m65374a(listM12569o4) && listM12569o4.get(0) != null) {
                    adTraceRecord2.m12504u(((MaterialSummaryRecord) listM12569o4.get(0)).m12515y());
                }
                adTraceRecord2.m12503t(System.currentTimeMillis());
                c10438c = new C10438c(AdTraceRecord.class.getSimpleName(), null, null, "uniqueId=? and contentId=?", new String[]{strM56932a, strM12477x}, adTraceRecord2.m64216r());
            }
            arrayList.add(c10438c);
            m12568n(arrayList);
        }
    }

    /* renamed from: y */
    public final void m12547y(C9031r c9031r, int i10) {
        AdCreativeContentRecord adCreativeContentRecordM58975g;
        List<C9406b> listM56974o = c9031r.m56974o();
        if (AbstractC10706e.m65374a(listM56974o)) {
            return;
        }
        ArrayList arrayList = new ArrayList(listM56974o.size());
        ArrayList arrayList2 = new ArrayList(listM56974o.size());
        String[] strArrM12522C = m12522C(c9031r.m56975p(), i10);
        ArrayList arrayList3 = new ArrayList(listM56974o.size());
        for (C9406b c9406b : listM56974o) {
            if (c9406b != null && c9406b.m58981n() == 0 && (adCreativeContentRecordM58975g = c9406b.m58975g()) != null && m12521B(adCreativeContentRecordM58975g.m12462x(), strArrM12522C)) {
                arrayList.add(m12540r(adCreativeContentRecordM58975g));
                AdSlotMapRecord adSlotMapRecordM58976i = c9406b.m58976i();
                if (adSlotMapRecordM58976i != null) {
                    adSlotMapRecordM58976i.m12495x(0);
                    adSlotMapRecordM58976i.m12493u(0);
                    arrayList2.add(m12541s(adSlotMapRecordM58976i));
                }
                arrayList3.add(m12542t(c9406b.m58979l()));
                m12520A(c9406b);
            }
        }
        m12568n(arrayList);
        m12568n(arrayList2);
        m12568n(arrayList3);
    }

    /* renamed from: z */
    public void m12548z(C9405a c9405a) {
        if (c9405a != null) {
            AdEventRecord adEventRecordM58960a = c9405a.m58960a();
            m12567m(AdEventRecord.class, adEventRecordM58960a.m64216r());
            m12524E(adEventRecordM58960a);
        }
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: a */
    public List<AdIECImpRecord> mo12529a(String str) {
        return m12569o(AdIECImpRecord.class, null, "pkgName=?", new String[]{str}, null, null);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: b */
    public List<MaterialSummaryRecord> mo12534b(String str, String str2) {
        return m12569o(MaterialSummaryRecord.class, null, "pkgName=? and adType=?", new String[]{str, str2}, null, null);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: a */
    public void mo12530a(List<String[]> list) {
        m12561g(InterfaceC9026o.f45674j, list);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: b */
    public void mo12535b(List<String[]> list) {
        m12561g(InterfaceC9026o.f45673i, list);
    }

    @Override // p216d4.InterfaceC9024n
    /* renamed from: a */
    public void mo12531a(List<C9031r> list, int i10) {
        if (AbstractC10706e.m65374a(list)) {
            AbstractC10915a.m65978j("AdRecDao", "iu all slots: empty");
            return;
        }
        for (C9031r c9031r : list) {
            if (c9031r != null) {
                m12547y(c9031r, i10);
            }
        }
    }

    @Override // p357i4.InterfaceC10439d
    /* renamed from: b */
    public AbstractC10436a mo12533b() {
        return C9033t.m56980a0(this.f9507a);
    }

    @Override // p357i4.InterfaceC10439d
    /* renamed from: a */
    public String mo12528a() {
        return "AdRecDao";
    }
}
