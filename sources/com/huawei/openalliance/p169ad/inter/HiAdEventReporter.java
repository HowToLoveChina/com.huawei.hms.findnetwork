package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.C7662sk;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.ClickDestination;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.inter.data.AdEventRecord;
import com.huawei.openalliance.p169ad.inter.data.AdEventType;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7793cm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class HiAdEventReporter {

    /* renamed from: a */
    private static HiAdEventReporter f33350a;

    /* renamed from: b */
    private static final byte[] f33351b = new byte[0];

    /* renamed from: c */
    private Context f33352c;

    /* renamed from: d */
    private C6922c f33353d;

    private HiAdEventReporter(Context context) {
        this.f33352c = context.getApplicationContext();
        this.f33353d = new C6922c(context);
    }

    /* renamed from: a */
    private static HiAdEventReporter m44064a(Context context) {
        HiAdEventReporter hiAdEventReporter;
        synchronized (f33351b) {
            try {
                if (f33350a == null) {
                    f33350a = new HiAdEventReporter(context);
                }
                hiAdEventReporter = f33350a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hiAdEventReporter;
    }

    /* renamed from: b */
    private void m44069b(List<AdEventRecord> list) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String slotId = ((C7302e) list.get(i10).m44245a()).getSlotId();
            if (C7793cm.m48074a(this.f33352c, slotId)) {
                hashSet2.add(slotId);
            } else {
                hashSet.add(slotId);
            }
        }
        if (!AbstractC7760bg.m47767a(hashSet2)) {
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                HiAd.m44014a(this.f33352c).mo44048b((String) it.next());
            }
        }
        if (AbstractC7760bg.m47767a(hashSet)) {
            return;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            HiAd.m44014a(this.f33352c).mo44050c((String) it2.next());
        }
    }

    @OuterVisible
    public static HiAdEventReporter getInstance(Context context) {
        return m44064a(context);
    }

    @OuterVisible
    public void reportEvent(List<AdEventRecord> list) {
        List<AdEventRecord> listM44065a = m44065a(list);
        AbstractC7185ho.m43821b("HiAdEventReporter", "batch report events size:%s", Integer.valueOf(listM44065a.size()));
        if (AbstractC7760bg.m47767a(listM44065a)) {
            return;
        }
        m44069b(listM44065a);
        int i10 = 0;
        while (i10 < listM44065a.size()) {
            AdEventRecord adEventRecord = listM44065a.get(i10);
            C7302e c7302e = (C7302e) adEventRecord.m44245a();
            ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
            if (contentRecordM46698a != null) {
                String strM44248d = listM44065a.get(i10).m44248d();
                boolean z10 = i10 >= listM44065a.size() - 1;
                Context context = this.f33352c;
                C7560ou c7560ou = new C7560ou(context, C7662sk.m47225a(context, c7302e.m44632e()), contentRecordM46698a);
                if ("imp".equalsIgnoreCase(strM44248d)) {
                    m44066a(contentRecordM46698a, z10, c7560ou);
                    m44067a(c7302e, z10, c7560ou, adEventRecord.m44247c() - adEventRecord.m44246b());
                } else if (AdEventType.SHOW_START.equalsIgnoreCase(strM44248d)) {
                    m44066a(contentRecordM46698a, z10, c7560ou);
                } else if ("click".equalsIgnoreCase(strM44248d)) {
                    C7587b.a aVar = new C7587b.a();
                    aVar.m46920b(ClickDestination.ADCONTENTINTERFACE).m46915a((Integer) 12).m46921b(z10);
                    c7560ou.mo46594a(aVar.m46918a());
                } else if (AdEventType.INTENTSUCCESS.equalsIgnoreCase(strM44248d)) {
                    c7560ou.mo46589a(EventType.INTENTSUCCESS, (Integer) 1, (Integer) null, z10);
                }
            }
            i10++;
        }
    }

    /* renamed from: a */
    private List<AdEventRecord> m44065a(List<AdEventRecord> list) {
        C7302e c7302e;
        ArrayList arrayList = new ArrayList();
        if (AbstractC7760bg.m47767a(list)) {
            return arrayList;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            AdEventRecord adEventRecord = list.get(i10);
            if (adEventRecord != null && (adEventRecord.m44245a() instanceof C7302e) && (c7302e = (C7302e) adEventRecord.m44245a()) != null && c7302e.isAdIdInWhiteList() && m44068a(adEventRecord)) {
                arrayList.add(adEventRecord);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m44066a(ContentRecord contentRecord, boolean z10, C7560ou c7560ou) {
        if (contentRecord == null) {
            return;
        }
        contentRecord.m41536c(String.valueOf(AbstractC7741ao.m47566c()));
        c7560ou.mo46590a(contentRecord);
        c7560ou.m46605a(z10);
    }

    /* renamed from: a */
    private void m44067a(C7302e c7302e, boolean z10, C7560ou c7560ou, long j10) {
        C7586a.a aVar = new C7586a.a();
        aVar.m46874a(Long.valueOf(j10)).m46873a(Integer.valueOf(c7302e.getMinEffectiveShowRatio())).m46880b(z10).m46878b((Integer) 7);
        c7560ou.mo46593a(aVar.m46877a());
    }

    /* renamed from: a */
    private boolean m44068a(AdEventRecord adEventRecord) {
        if (!"imp".equalsIgnoreCase(adEventRecord.m44248d())) {
            return true;
        }
        if (adEventRecord.m44249e() != null && adEventRecord.m44249e().booleanValue()) {
            return true;
        }
        C7302e c7302e = (C7302e) adEventRecord.m44245a();
        long jM44247c = adEventRecord.m44247c() - adEventRecord.m44246b();
        if (c7302e.getMaxEffectiveShowTime() == 0 || c7302e.getMinEffectiveShowTime() >= c7302e.getMaxEffectiveShowTime()) {
            if (jM44247c >= c7302e.getMinEffectiveShowTime()) {
                return true;
            }
        } else if (jM44247c >= c7302e.getMinEffectiveShowTime() && jM44247c <= c7302e.getMaxEffectiveShowTime()) {
            return true;
        }
        this.f33353d.m39062a(this.f33352c, c7302e, jM44247c);
        return false;
    }
}
