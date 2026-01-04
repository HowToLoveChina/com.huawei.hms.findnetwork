package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.AdLoadState;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdShowListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.jb */
/* loaded from: classes8.dex */
public interface InterfaceC7328jb {
    /* renamed from: A */
    void mo45208A();

    /* renamed from: B */
    void mo45209B();

    /* renamed from: a */
    void mo45149a(int i10);

    /* renamed from: a */
    void mo45150a(int i10, int i11);

    /* renamed from: a */
    void mo45151a(long j10);

    /* renamed from: a */
    void mo45152a(ContentRecord contentRecord);

    /* renamed from: a */
    void mo45153a(ContentRecord contentRecord, long j10, int i10);

    /* renamed from: a */
    void mo45154a(RewardVerifyConfig rewardVerifyConfig);

    /* renamed from: a */
    void mo45155a(AdActionListener adActionListener);

    /* renamed from: a */
    void mo45156a(AdListener adListener);

    /* renamed from: a */
    void mo45157a(AdShowListener adShowListener);

    /* renamed from: a */
    boolean mo45162a(int i10, int i11, ContentRecord contentRecord, Long l10, MaterialClickInfo materialClickInfo, int i12);

    /* renamed from: b */
    AdLoadState mo45163b();

    /* renamed from: b */
    void mo45164b(int i10);

    /* renamed from: b */
    void mo45165b(long j10);

    /* renamed from: c */
    void mo45168c(int i10);

    /* renamed from: c */
    boolean mo45169c(ContentRecord contentRecord);

    /* renamed from: d */
    int mo45170d();

    /* renamed from: e */
    void mo45173e();

    /* renamed from: e */
    void mo45174e(int i10);

    /* renamed from: f */
    void mo45176f();

    /* renamed from: f */
    void mo45177f(int i10);

    /* renamed from: f */
    void mo45178f(ContentRecord contentRecord);

    /* renamed from: i */
    void mo45182i();

    /* renamed from: j */
    void mo45183j();

    /* renamed from: s */
    void mo45192s();

    /* renamed from: t */
    boolean mo45193t();

    /* renamed from: u */
    void mo45194u();

    /* renamed from: v */
    void mo45195v();

    /* renamed from: w */
    String mo45196w();

    /* renamed from: x */
    BiddingInfo mo45197x();

    /* renamed from: y */
    String mo45198y();
}
