package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.p171db.bean.ThirdPartyEventRecord;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.fv */
/* loaded from: classes8.dex */
public interface InterfaceC7138fv {
    /* renamed from: a */
    long mo43159a(Class<? extends EventRecord> cls, EventRecord eventRecord);

    /* renamed from: a */
    Map<String, EventRecord> mo43161a(Class<? extends EventRecord> cls, int i10);

    /* renamed from: a */
    void mo43163a(long j10, int i10);

    /* renamed from: a */
    void mo43164a(long j10, List<String> list);

    /* renamed from: a */
    void mo43166a(ThirdPartyEventRecord thirdPartyEventRecord);

    /* renamed from: a */
    void mo43167a(Class<? extends EventRecord> cls, String str, String str2, long j10, List<String> list);

    /* renamed from: a */
    void mo43169a(String str, String str2);

    /* renamed from: a */
    void mo43170a(List<String> list);

    /* renamed from: b */
    List<ThirdPartyEventRecord> mo43171b(long j10, int i10);

    /* renamed from: b */
    void mo43172b(long j10, List<String> list);

    /* renamed from: b */
    void mo43173b(Class<? extends EventRecord> cls, List<String> list);
}
