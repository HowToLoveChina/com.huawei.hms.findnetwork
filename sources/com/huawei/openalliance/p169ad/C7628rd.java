package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.C7632rh;
import com.huawei.openalliance.p169ad.beans.vast.LinearCreative;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.huawei.openalliance.ad.rd */
/* loaded from: classes8.dex */
public class C7628rd extends AbstractC7625ra {

    /* renamed from: a */
    private Set<String> f35545a = new HashSet(Arrays.asList(VastAttribute.CREATIVE_VIEW, "start", "firstQuartile", "midpoint", "thirdQuartile", "complete", "mute", "unmute", VastAttribute.PAUSE, "resume", VastAttribute.CLOSE_LINEAR, "skip", VastAttribute.PROGRESS));

    @Override // com.huawei.openalliance.p169ad.AbstractC7625ra
    /* renamed from: a */
    public Set<String> mo47064a() {
        return this.f35545a;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7625ra
    /* renamed from: a */
    public void mo47066a(LinearCreative linearCreative, XmlPullParser xmlPullParser, Map<String, C7632rh.a> map) {
    }
}
