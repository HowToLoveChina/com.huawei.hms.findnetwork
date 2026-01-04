package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ql */
/* loaded from: classes8.dex */
public interface InterfaceC7610ql {
    /* renamed from: a */
    AdContentRsp mo46329a(Context context, AdSlotParam adSlotParam, int i10);

    /* renamed from: a */
    AdContentRsp mo46333a(AdSlotParam adSlotParam, List<String> list, List<String> list2);

    /* renamed from: a */
    void mo46335a(DelayInfo delayInfo);

    /* renamed from: a */
    void mo46336a(AdContentRsp adContentRsp, AdSlotParam adSlotParam, InterfaceC7621qw interfaceC7621qw, InterfaceC7609qk interfaceC7609qk, long j10, int i10);
}
