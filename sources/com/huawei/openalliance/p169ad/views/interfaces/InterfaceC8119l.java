package com.huawei.openalliance.p169ad.views.interfaces;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.uiengine.common.MediaStateApi;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.InterfaceC7182hl;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.views.interfaces.l */
/* loaded from: classes2.dex */
public interface InterfaceC8119l extends InterfaceC7337jk, InterfaceC7403lm {
    /* renamed from: a */
    InterfaceC8121n mo49705a(int i10);

    /* renamed from: a */
    void mo49706a();

    /* renamed from: a */
    void mo49707a(int i10, int i11, String str, boolean z10, Integer num);

    /* renamed from: a */
    void mo49708a(int i10, boolean z10);

    /* renamed from: a */
    void mo49709a(View view, ContentRecord contentRecord);

    /* renamed from: a */
    void mo49710a(AdLoadMode adLoadMode);

    /* renamed from: a */
    void mo49711a(ContentRecord contentRecord);

    /* renamed from: a */
    void mo49712a(ContentRecord contentRecord, int i10);

    /* renamed from: a */
    void mo49713a(InterfaceC7182hl interfaceC7182hl);

    /* renamed from: a */
    void mo49714a(InterfaceC8121n interfaceC8121n, ContentRecord contentRecord);

    /* renamed from: b */
    Integer mo49715b(ContentRecord contentRecord);

    /* renamed from: b */
    void mo49716b();

    /* renamed from: b */
    void mo49717b(int i10);

    /* renamed from: c */
    void mo49718c();

    AdSlotParam getAdSlotParam();

    int getAdType();

    int getAudioFocusType();

    Context getContext();

    MediaStateApi getMediaProxy();

    C7560ou getMonitorEp();
}
