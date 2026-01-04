package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n;

/* renamed from: com.huawei.openalliance.ad.nh */
/* loaded from: classes8.dex */
public abstract class AbstractC7513nh<V extends InterfaceC8121n> extends C7336jj<V> implements InterfaceC7534ob<V> {

    /* renamed from: d */
    protected Context f34896d;

    /* renamed from: e */
    private boolean f34897e = false;

    /* renamed from: f */
    private boolean f34898f = false;

    /* renamed from: g */
    private CountDownTimer f34899g;

    /* renamed from: com.huawei.openalliance.ad.nh$1 */
    public class AnonymousClass1 extends CountDownTimer {
        public AnonymousClass1(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ((InterfaceC8121n) AbstractC7513nh.this.mo45320d()).mo50315c(1);
            AbstractC7513nh.this.mo46116b();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            int iMax = Math.max(1, (int) Math.ceil((j10 * 1.0f) / 1000.0f));
            AbstractC7185ho.m43818a("PPSBaseViewPresenter", "count down time: %d seconds: %d", Long.valueOf(j10), Integer.valueOf(iMax));
            ((InterfaceC8121n) AbstractC7513nh.this.mo45320d()).mo50315c(iMax);
        }
    }

    public AbstractC7513nh(Context context, V v10, int i10) {
        Context applicationContext = context.getApplicationContext();
        this.f34896d = applicationContext;
        this.f34190b = new C7560ou(applicationContext, new C7668sq(applicationContext, i10));
        mo45316a((AbstractC7513nh<V>) v10);
    }

    /* renamed from: a */
    public void m46109a() {
        AbstractC7185ho.m43820b("PPSBaseViewPresenter", "cancelDisplayDurationCountTask");
        CountDownTimer countDownTimer = this.f34899g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f34899g = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: b */
    public void mo46116b() {
        AbstractC7185ho.m43821b("PPSBaseViewPresenter", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.f34897e));
        if (this.f34897e) {
            return;
        }
        this.f34897e = true;
        m46108a(true);
        InterfaceC7328jb adMediator = mo45320d().getAdMediator();
        if (adMediator != null) {
            adMediator.mo45194u();
        }
    }

    /* renamed from: b */
    public abstract void mo46119b(String str);

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: c */
    public void mo46120c() {
        InterfaceC7328jb adMediator = mo45320d().getAdMediator();
        if (adMediator != null) {
            adMediator.mo45195v();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: h */
    public boolean mo46121h() {
        return this.f34898f;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: a */
    public void mo46110a(int i10) {
        AbstractC7185ho.m43821b("PPSBaseViewPresenter", "startDisplayDurationCountTask duration: %d", Integer.valueOf(i10));
        CountDownTimer countDownTimer = this.f34899g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AnonymousClass1 anonymousClass1 = new CountDownTimer(i10, 500L) { // from class: com.huawei.openalliance.ad.nh.1
            public AnonymousClass1(long i102, long j11) {
                super(i102, j11);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((InterfaceC8121n) AbstractC7513nh.this.mo45320d()).mo50315c(1);
                AbstractC7513nh.this.mo46116b();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                int iMax = Math.max(1, (int) Math.ceil((j10 * 1.0f) / 1000.0f));
                AbstractC7185ho.m43818a("PPSBaseViewPresenter", "count down time: %d seconds: %d", Long.valueOf(j10), Integer.valueOf(iMax));
                ((InterfaceC8121n) AbstractC7513nh.this.mo45320d()).mo50315c(iMax);
            }
        };
        this.f34899g = anonymousClass1;
        anonymousClass1.start();
    }

    /* renamed from: b */
    public void m46117b(ContentRecord contentRecord) {
        InterfaceC7328jb adMediator = mo45320d().getAdMediator();
        if (adMediator != null) {
            adMediator.mo45178f(contentRecord);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: a */
    public void mo46111a(int i10, int i11, ContentRecord contentRecord, Long l10, MaterialClickInfo materialClickInfo, int i12) {
        AbstractC7185ho.m43820b("PPSBaseViewPresenter", "onTouch");
        InterfaceC7328jb adMediator = mo45320d().getAdMediator();
        if (adMediator == null || !adMediator.mo45162a(i10, i11, contentRecord, l10, materialClickInfo, i12)) {
            return;
        }
        if (this.f34897e) {
            AbstractC7185ho.m43820b("PPSBaseViewPresenter", "onDoActionSucc hasShowFinish");
            return;
        }
        this.f34897e = true;
        m46108a(false);
        m46109a();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: b */
    public void mo46118b(Long l10) {
        m46107a(11, "feedback", l10);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: a */
    public void mo46112a(int i10, int i11, Long l10) {
        AbstractC7185ho.m43821b("PPSBaseViewPresenter", "skip ad - hasShowFinish: %s", Boolean.valueOf(this.f34897e));
        if (this.f34897e) {
            return;
        }
        m46108a(false);
        this.f34897e = true;
        m46109a();
    }

    /* renamed from: a */
    private void m46107a(int i10, String str, Long l10) {
        if (this.f34897e) {
            AbstractC7185ho.m43821b("PPSBaseViewPresenter", "%s hasShowFinish", str);
            return;
        }
        this.f34897e = true;
        mo46120c();
        m46109a();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: a */
    public void mo46113a(ContentRecord contentRecord) {
        this.f34189a = contentRecord;
        if (contentRecord == null) {
            AbstractC7185ho.m43823c("PPSBaseViewPresenter", "loadAdMaterial contentRecord is null");
            mo45320d().mo50309a(-7);
            return;
        }
        AbstractC7185ho.m43820b("PPSBaseViewPresenter", "loadAdMaterial");
        String strM41384A = contentRecord.m41384A();
        if (TextUtils.isEmpty(strM41384A)) {
            strM41384A = contentRecord.m41619z();
        }
        this.f34190b.mo46590a(contentRecord);
        mo46119b(strM41384A);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: a */
    public void mo46114a(ContentRecord contentRecord, long j10, int i10) {
        InterfaceC7328jb adMediator = mo45320d().getAdMediator();
        if (adMediator != null) {
            adMediator.mo45153a(contentRecord, j10, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7534ob
    /* renamed from: a */
    public void mo46115a(Long l10) {
        m46107a(10, "onWhyThisAd", l10);
    }

    /* renamed from: a */
    private void m46108a(boolean z10) {
        AbstractC7185ho.m43821b("PPSBaseViewPresenter", "setNormalEnd, isNormalEnd= %s", Boolean.valueOf(z10));
        this.f34898f = z10;
    }
}
