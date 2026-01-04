package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.analysis.C6921b;
import com.huawei.openalliance.p169ad.beans.inner.DownloadBlockInfo;
import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.download.app.AppDownloadTask;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EventRecord;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7586a;
import com.huawei.openalliance.p169ad.processor.eventbeans.C7587b;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.qq */
/* loaded from: classes8.dex */
public interface InterfaceC7615qq {
    /* renamed from: a */
    ContentRecord mo46574a();

    /* renamed from: a */
    void mo46576a(int i10, int i11);

    /* renamed from: a */
    void mo46577a(int i10, int i11, List<String> list);

    /* renamed from: a */
    void mo46578a(int i10, long j10);

    /* renamed from: a */
    void mo46580a(long j10);

    /* renamed from: a */
    void mo46581a(long j10, int i10);

    /* renamed from: a */
    void mo46582a(long j10, int i10, C7559ot c7559ot);

    /* renamed from: a */
    void mo46583a(long j10, long j11, int i10, int i11);

    /* renamed from: a */
    void mo46584a(long j10, long j11, int i10, int i11, String str);

    /* renamed from: a */
    void mo46585a(Context context, ContentRecord contentRecord);

    /* renamed from: a */
    void mo46588a(EventType eventType, Integer num, Integer num2);

    /* renamed from: a */
    void mo46589a(EventType eventType, Integer num, Integer num2, boolean z10);

    /* renamed from: a */
    void mo46590a(ContentRecord contentRecord);

    /* renamed from: a */
    void mo46591a(EventRecord eventRecord, boolean z10, boolean z11);

    /* renamed from: a */
    void mo46592a(AppDownloadTask appDownloadTask);

    /* renamed from: a */
    void mo46593a(C7586a c7586a);

    /* renamed from: a */
    void mo46594a(C7587b c7587b);

    /* renamed from: a */
    void mo46595a(Integer num);

    /* renamed from: a */
    void mo46596a(Integer num, Integer num2, String str, String str2, String str3);

    /* renamed from: a */
    void mo46597a(Integer num, String str, int i10, DownloadBlockInfo downloadBlockInfo, int i11, String str2, String str3, String str4);

    /* renamed from: a */
    void mo46598a(Integer num, String str, int i10, String str2, String str3, String str4);

    /* renamed from: a */
    void mo46599a(Integer num, String str, DownloadBlockInfo downloadBlockInfo, int i10, String str2, String str3, String str4);

    /* renamed from: a */
    void mo46601a(String str, String str2, String str3);

    /* renamed from: a */
    void mo46604a(List<FeedbackInfo> list);

    /* renamed from: b */
    void mo46606b();

    /* renamed from: b */
    void mo46607b(int i10, int i11);

    /* renamed from: b */
    void mo46608b(long j10, long j11, int i10, int i11);

    /* renamed from: b */
    void mo46609b(C6921b c6921b, boolean z10, boolean z11);

    /* renamed from: b */
    void mo46610b(C7586a c7586a);

    /* renamed from: b */
    void mo46611b(Integer num, Integer num2, String str, String str2, String str3);

    /* renamed from: b */
    void mo46612b(Integer num, String str, int i10, String str2, String str3, String str4);

    /* renamed from: b */
    void mo46613b(Integer num, String str, DownloadBlockInfo downloadBlockInfo, int i10, String str2, String str3, String str4);

    /* renamed from: b */
    void mo46614b(List<FeedbackInfo> list);

    /* renamed from: b */
    void mo46615b(boolean z10);

    /* renamed from: c */
    void mo46616c();

    /* renamed from: c */
    void mo46617c(long j10, long j11, int i10, int i11);

    /* renamed from: c */
    void mo46618c(C7586a c7586a);

    /* renamed from: c */
    void mo46619c(Integer num, Integer num2, String str, String str2, String str3);

    /* renamed from: d */
    void mo46620d();

    /* renamed from: d */
    void mo46621d(long j10, long j11, int i10, int i11);

    /* renamed from: e */
    void mo46622e();

    /* renamed from: f */
    void mo46623f();

    /* renamed from: g */
    void mo46624g();

    /* renamed from: h */
    void mo46625h();

    /* renamed from: i */
    void mo46626i();

    /* renamed from: j */
    void mo46627j();

    /* renamed from: k */
    void mo46628k();

    /* renamed from: l */
    void mo46629l();

    /* renamed from: m */
    void mo46630m();

    /* renamed from: n */
    void mo46631n();

    /* renamed from: o */
    void mo46632o();

    /* renamed from: p */
    void mo46633p();

    /* renamed from: q */
    void mo46634q();

    /* renamed from: r */
    void mo46635r();

    /* renamed from: s */
    void mo46636s();

    /* renamed from: t */
    void mo46637t();

    /* renamed from: u */
    void mo46638u();
}
