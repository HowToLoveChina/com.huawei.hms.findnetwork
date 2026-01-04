package com.huawei.openalliance.p169ad;

import android.view.View;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;

/* renamed from: com.huawei.openalliance.ad.oe */
/* loaded from: classes8.dex */
public interface InterfaceC7537oe<V extends InterfaceC8118k> {
    /* renamed from: a */
    int mo46177a(ContentRecord contentRecord, int i10);

    /* renamed from: a */
    View mo46178a(IRemoteCreator iRemoteCreator, BinderC6978bv binderC6978bv, ContentRecord contentRecord, C7305h c7305h);

    /* renamed from: a */
    String mo46179a(int i10, int i11, C7305h c7305h);

    /* renamed from: a */
    void mo46180a();

    /* renamed from: a */
    void m46269a(long j10);

    /* renamed from: a */
    void m46270a(long j10, int i10, int i11, int i12);

    /* renamed from: a */
    void mo46181a(long j10, int i10, Integer num);

    /* renamed from: a */
    void m46271a(long j10, long j11);

    /* renamed from: a */
    void m46272a(String str);

    /* renamed from: a */
    void mo46182a(String str, ContentRecord contentRecord);

    /* renamed from: a */
    void mo46184a(String str, C7305h c7305h, IRewardAdStatusListener iRewardAdStatusListener);

    /* renamed from: a */
    void mo46185a(boolean z10);

    /* renamed from: a */
    boolean mo46186a(int i10, MaterialClickInfo materialClickInfo);

    /* renamed from: a */
    boolean mo46187a(C7305h c7305h);

    /* renamed from: a */
    boolean mo46188a(String str, int i10);

    /* renamed from: b */
    void mo46189b();

    /* renamed from: b */
    void mo46190b(String str);

    /* renamed from: b */
    void mo46191b(String str, C7305h c7305h, IRewardAdStatusListener iRewardAdStatusListener);

    /* renamed from: b */
    boolean mo46192b(ContentRecord contentRecord);

    /* renamed from: b */
    boolean mo46193b(C7305h c7305h);

    /* renamed from: c */
    void mo46194c(C7305h c7305h);

    /* renamed from: c */
    boolean mo46195c();
}
