package com.huawei.openalliance.p169ad.views.interfaces;

import android.view.View;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.views.interfaces.n */
/* loaded from: classes2.dex */
public interface InterfaceC8121n extends InterfaceC7337jk, InterfaceC7403lm, IViewLifeCycle {
    /* renamed from: a */
    void mo50309a(int i10);

    /* renamed from: a */
    void mo50310a(int i10, int i11);

    /* renamed from: a */
    void mo50311a(View view, Integer num);

    /* renamed from: a */
    void mo50312a(InterfaceC7416lz interfaceC7416lz);

    /* renamed from: b */
    void mo50313b();

    /* renamed from: c */
    void mo50314c();

    /* renamed from: c */
    void mo50315c(int i10);

    /* renamed from: d */
    void mo50316d();

    /* renamed from: e */
    boolean mo50317e();

    /* renamed from: g */
    void mo50318g();

    InterfaceC7328jb getAdMediator();

    /* renamed from: h */
    void mo50319h();

    /* renamed from: i */
    boolean mo50320i();

    void setAdContent(ContentRecord contentRecord);

    void setAdMediator(InterfaceC7328jb interfaceC7328jb);

    void setAudioFocusType(int i10);

    void setDisplayDuration(int i10);
}
