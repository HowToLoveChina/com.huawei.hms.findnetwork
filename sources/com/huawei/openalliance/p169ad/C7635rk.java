package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.huawei.openalliance.ad.rk */
/* loaded from: classes8.dex */
public class C7635rk extends AbstractC7627rc {
    @Override // com.huawei.openalliance.p169ad.AbstractC7627rc
    /* renamed from: a */
    public List<VastContent> mo47082a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        try {
            return AbstractC7627rc.m47080b(xmlPullParser).m41007a();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("Vast30Parser", "read vast content error: %s", th2.getClass().getSimpleName());
            return arrayList;
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7627rc
    /* renamed from: a */
    public void mo47083a(XmlPullParser xmlPullParser, VastContent vastContent) {
    }
}
