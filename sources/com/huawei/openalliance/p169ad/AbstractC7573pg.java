package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.metadata.Precontent;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateV3;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.pg */
/* loaded from: classes8.dex */
public abstract class AbstractC7573pg {
    /* renamed from: a */
    public static List<ContentRecord> m46757a(AdContentRsp adContentRsp, int i10) {
        List<Ad30> listM40830c = adContentRsp.m40830c();
        ArrayList arrayList = new ArrayList();
        if (AbstractC7760bg.m47767a(listM40830c)) {
            return arrayList;
        }
        for (Ad30 ad30 : listM40830c) {
            String strM39419a = ad30.m39419a();
            int iM39424b = ad30.m39424b();
            String strM39434g = ad30.m39434g();
            if (200 != iM39424b) {
                AbstractC7185ho.m43821b("NetElementGetter", "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), strM39419a);
            }
            ArrayList<Content> arrayList2 = new ArrayList();
            if (ad30.m39428c() != null) {
                arrayList2.addAll(ad30.m39428c());
            }
            if (!AbstractC7760bg.m47767a(arrayList2)) {
                for (Content content : arrayList2) {
                    content.m39925a(adContentRsp.m40847h(), i10);
                    ContentRecord contentRecordM46744a = AbstractC7572pf.m46744a(strM39419a, content, i10, strM39434g);
                    if (contentRecordM46744a != null) {
                        contentRecordM46744a.m41592o(adContentRsp.m40855o());
                        contentRecordM46744a.m41618y(adContentRsp.m40851k());
                        contentRecordM46744a.m41479ab(adContentRsp.m40852l());
                        contentRecordM46744a.m41391D(adContentRsp.m40857q());
                        contentRecordM46744a.m41393E(adContentRsp.m40858r());
                        contentRecordM46744a.m41422T(adContentRsp.m40862v());
                        arrayList.add(contentRecordM46744a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<ContentRecord> m46759b(AdContentRsp adContentRsp, int i10) {
        ArrayList arrayList = new ArrayList();
        if (adContentRsp == null) {
            return arrayList;
        }
        List<Precontent> listM40842f = adContentRsp.m40842f();
        String strM40851k = adContentRsp.m40851k();
        if (AbstractC7760bg.m47767a(listM40842f)) {
            return arrayList;
        }
        for (Precontent precontent : listM40842f) {
            precontent.m40414a(adContentRsp.m40847h(), i10);
            ContentRecord contentRecordM46746a = AbstractC7572pf.m46746a(precontent.m40407a(), precontent, i10);
            if (contentRecordM46746a != null) {
                contentRecordM46746a.m41618y(strM40851k);
                contentRecordM46746a.m41479ab(adContentRsp.m40852l());
                contentRecordM46746a.m41391D(adContentRsp.m40857q());
                contentRecordM46746a.m41393E(adContentRsp.m40858r());
                List<TemplateV3> listM40433m = precontent.m40433m();
                if (AbstractC7760bg.m47767a(listM40433m)) {
                    arrayList.add(contentRecordM46746a);
                } else {
                    for (TemplateV3 templateV3 : listM40433m) {
                        contentRecordM46746a.m41406L(templateV3.m40557a());
                        contentRecordM46746a.m41440a(templateV3.m40560b());
                        contentRecordM46746a.m41414P(templateV3.m40562c());
                        contentRecordM46746a.m41432Y(templateV3.m40564d());
                        contentRecordM46746a.m41434Z(templateV3.m40566e());
                        arrayList.add(contentRecordM46746a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<ContentRecord> m46758a(Map<String, List<IPlacementAd>> map) {
        ContentRecord contentRecordM46766a;
        ArrayList arrayList = new ArrayList();
        if (C7765bl.m47802a(map)) {
            return arrayList;
        }
        Iterator<List<IPlacementAd>> it = map.values().iterator();
        while (it.hasNext()) {
            for (IPlacementAd iPlacementAd : it.next()) {
                if ((iPlacementAd instanceof C7304g) && (contentRecordM46766a = C7575pi.m46766a((C7304g) iPlacementAd)) != null) {
                    arrayList.add(contentRecordM46766a);
                }
            }
        }
        return arrayList;
    }
}
