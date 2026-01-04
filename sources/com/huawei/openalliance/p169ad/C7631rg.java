package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.Tracking;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.huawei.openalliance.ad.rg */
/* loaded from: classes8.dex */
public class C7631rg extends AbstractC7626rb {

    /* renamed from: a */
    private Set<String> f35558a = new HashSet(Arrays.asList(VastAttribute.CREATIVE_VIEW, "start", "firstQuartile", "midpoint", "thirdQuartile", "complete", "mute", "unmute", VastAttribute.PAUSE, "resume", "close"));

    @Override // com.huawei.openalliance.p169ad.AbstractC7626rb
    /* renamed from: a */
    public Set<String> mo47077a() {
        return this.f35558a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7626rb
    /* renamed from: a */
    public void mo47079a(XmlPullParser xmlPullParser, List<Tracking> list, Map<String, C7632rh.a> map) {
    }
}
