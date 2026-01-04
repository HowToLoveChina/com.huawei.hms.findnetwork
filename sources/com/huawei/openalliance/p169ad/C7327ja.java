package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.metadata.Ad30;
import com.huawei.openalliance.p169ad.beans.metadata.Content;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.ja */
/* loaded from: classes8.dex */
public class C7327ja extends AbstractC7323ix {

    /* renamed from: p */
    boolean f34117p;

    /* renamed from: q */
    private final int f34118q;

    /* renamed from: r */
    private boolean f34119r;

    /* renamed from: s */
    private boolean f34120s;

    /* renamed from: t */
    private boolean f34121t;

    /* renamed from: u */
    private ContentRecord f34122u;

    /* renamed from: v */
    private boolean f34123v;

    public C7327ja(InterfaceC8119l interfaceC8119l) {
        super(interfaceC8119l);
        this.f34118q = hashCode();
        this.f34119r = false;
        this.f34120s = false;
        this.f34117p = false;
        this.f34121t = false;
        this.f34123v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m45232D() {
        AbstractC7185ho.m43821b(mo45199z(), "doOnShowSloganEnd, adHasShown:%s ", Boolean.valueOf(this.f34117p));
        this.f34120s = true;
        if (this.f34121t) {
            AbstractC7185ho.m43820b(mo45199z(), "Ad fails to display or loading timeout, ad dismiss");
            mo45168c(ErrorCode.ERROR_CODE_OTHER);
            mo45183j();
            return;
        }
        if (this.f34117p) {
            return;
        }
        AbstractC7185ho.m43820b(mo45199z(), "doOnShowSloganEnd Ad has been loaded, but not shown yet");
        if (!this.f34123v) {
            if (this.f34122u != null) {
                AbstractC7185ho.m43820b(mo45199z(), "show splash");
                mo45171d(this.f34122u);
                return;
            }
            synchronized (this) {
                try {
                    if (!m45172d(-2)) {
                        AbstractC7185ho.m43820b(mo45199z(), "no ad to display when slogan ends");
                        m45244h(-2);
                    }
                } finally {
                }
            }
            return;
        }
        ContentRecord contentRecordM41884g = AbstractC7014dc.m41884g();
        this.f34122u = contentRecordM41884g;
        if (contentRecordM41884g == null) {
            AbstractC7185ho.m43820b(mo45199z(), "linked loaded, do not call play");
            m45244h(-6);
        } else {
            AbstractC7185ho.m43820b(mo45199z(), "linked loaded, display normal when slogan ends");
            mo45171d(this.f34122u);
            AbstractC7014dc.m41868a((ContentRecord) null);
            mo45174e(1202);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m45233E() {
        AbstractC7185ho.m43821b(mo45199z(), "doOnReachMinSloganShowTime, adHasShown:%s ", Boolean.valueOf(this.f34117p));
        this.f34119r = true;
        if (!this.f34117p && this.f34122u != null && !this.f34123v) {
            AbstractC7185ho.m43820b(mo45199z(), "doOnReachMinSloganShowTime Ad has been loaded, but not shown yet");
            mo45171d(this.f34122u);
            return;
        }
        boolean zMo43400ba = this.f34048c.mo43400ba();
        AbstractC7185ho.m43821b(mo45199z(), "doOnReachMinSloganShowTime finish splash: %s adFailToDisplay: %s", Boolean.valueOf(zMo43400ba), Boolean.valueOf(this.f34121t));
        if (zMo43400ba && this.f34121t) {
            AbstractC7185ho.m43820b(mo45199z(), "ad fail to load when reach min slogan show time");
            mo45168c(ErrorCode.ERROR_CODE_OTHER);
            mo45183j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public ContentRecord m45242b(AdContentRsp adContentRsp, String str, Content content, String str2) {
        if (content == null) {
            return null;
        }
        content.m39925a(adContentRsp.m40847h(), this.f34059n);
        ContentRecord contentRecordM46744a = AbstractC7572pf.m46744a(str, content, this.f34059n, str2);
        if (contentRecordM46744a != null) {
            contentRecordM46744a.m41391D(adContentRsp.m40857q());
            contentRecordM46744a.m41393E(adContentRsp.m40858r());
            contentRecordM46744a.m41422T(adContentRsp.m40862v());
        }
        return contentRecordM46744a;
    }

    /* renamed from: h */
    private void m45244h(int i10) {
        mo45168c(i10);
        mo45183j();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: A */
    public void mo45208A() {
        AbstractC7185ho.m43820b(mo45199z(), "start");
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p == null) {
            mo45168c(-4);
            mo45183j();
        } else {
            m45186m();
            AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ja.1
                @Override // java.lang.Runnable
                public void run() {
                    C7327ja.this.m45181h();
                }
            });
            interfaceC8119lM45189p.mo49713a(new InterfaceC7182hl() { // from class: com.huawei.openalliance.ad.ja.2
                @Override // com.huawei.openalliance.p169ad.InterfaceC7182hl
                /* renamed from: a */
                public void mo43801a() {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ja.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C7327ja.this.m45233E();
                        }
                    });
                }

                @Override // com.huawei.openalliance.p169ad.InterfaceC7182hl
                /* renamed from: b */
                public void mo43802b() {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ja.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            C7327ja.this.m45232D();
                        }
                    });
                }
            });
            m45187n();
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7328jb
    /* renamed from: B */
    public void mo45209B() {
        boolean zMo43400ba = this.f34048c.mo43400ba();
        AbstractC7185ho.m43821b(mo45199z(), "onAdFailToDisplay - finishSplashOnMinSlogan: %s reachMinSloganShowTime: %s sloganShowEnd: %s", Boolean.valueOf(zMo43400ba), Boolean.valueOf(this.f34119r), Boolean.valueOf(this.f34120s));
        this.f34121t = true;
        if ((zMo43400ba && this.f34119r) || this.f34120s) {
            mo45183j();
        }
    }

    /* renamed from: C */
    public boolean m45245C() {
        return this.f34117p;
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7323ix
    /* renamed from: d */
    public void mo45171d(ContentRecord contentRecord) {
        AbstractC7185ho.m43820b(mo45199z(), "on content loaded, content record: " + AbstractC7806cz.m48162b(contentRecord));
        this.f34122u = contentRecord;
        this.f34050e.mo46590a(contentRecord);
        m45175e(contentRecord);
        if (contentRecord == null) {
            AbstractC7185ho.m43817a(mo45199z(), "ERROR_CODE_EMPTY_REQ_PARAM: contentRecord is null. ");
            mo45168c(ErrorCode.ERROR_CODE_NO_AD_RECORD);
            mo45209B();
            return;
        }
        InterfaceC8119l interfaceC8119lM45189p = m45189p();
        if (interfaceC8119lM45189p == null) {
            mo45168c(ErrorCode.ERROR_CODE_NULL_AD_VIEW);
            mo45209B();
            return;
        }
        Context context = interfaceC8119lM45189p.getContext();
        C7011da c7011da = new C7011da(context);
        if (c7011da.mo41237a()) {
            mo45168c(ErrorCode.ERROR_CODE_TRIGGER_DISTURB);
            mo45209B();
            return;
        }
        if (contentRecord.m41392E() != 12) {
            if (!this.f34119r && !this.f34120s) {
                AbstractC7185ho.m43820b(mo45199z(), "slogan hasn't reach min show time or end, show ad later");
                return;
            }
            if (c7011da.mo41237a()) {
                mo45168c(ErrorCode.ERROR_CODE_TRIGGER_DISTURB);
                mo45209B();
                return;
            }
            boolean zMo45169c = mo45169c(contentRecord);
            this.f34117p = true;
            if (zMo45169c) {
                return;
            }
            mo45164b(ErrorCode.ERROR_CODE_NULL_AD_VIEW);
            return;
        }
        if (mo45170d() == 1 && (m45167c() instanceof LinkedAdListener)) {
            AbstractC7185ho.m43820b(mo45199z(), "on linked loaded, sloganShowEnd:" + this.f34120s);
            if (!this.f34120s) {
                LinkedAdListener linkedAdListener = (LinkedAdListener) m45167c();
                LinkedSplashAd linkedSplashAdM46668a = C7565oz.m46668a(context, contentRecord);
                AbstractC7185ho.m43820b(mo45199z(), "on content loaded, linkedAd loaded. ");
                this.f34057l.m40035b(System.currentTimeMillis());
                linkedAdListener.onLinkedAdLoaded(linkedSplashAdM46668a);
                this.f34056k = contentRecord;
                this.f34123v = true;
                m45180g(200);
                return;
            }
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.ja.5
            @Override // java.lang.Runnable
            public void run() {
                C7327ja.this.mo45168c(1200);
                C7327ja.this.mo45209B();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7323ix
    /* renamed from: r */
    public String mo45191r() {
        return String.valueOf(2);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7323ix
    /* renamed from: z */
    public String mo45199z() {
        return "RealtimeAdMediator" + this.f34118q;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
    /* renamed from: a */
    public List<ContentRecord> mo44094a(AdContentRsp adContentRsp) {
        return AbstractC7573pg.m46759b(adContentRsp, this.f34059n);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
    /* renamed from: b */
    public List<ContentRecord> mo44095b(AdContentRsp adContentRsp) {
        List<Ad30> list;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (adContentRsp == null) {
            return arrayList2;
        }
        List<Ad30> listM40830c = adContentRsp.m40830c();
        if (AbstractC7760bg.m47767a(listM40830c)) {
            return arrayList2;
        }
        int i10 = 0;
        String str = "";
        String str2 = str;
        Content content = null;
        Content content2 = null;
        Content content3 = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        while (i10 < listM40830c.size() && !z10) {
            Ad30 ad30 = listM40830c.get(i10);
            String strM39419a = ad30.m39419a();
            String strM39434g = ad30.m39434g();
            int iM39424b = ad30.m39424b();
            if (200 != iM39424b) {
                list = listM40830c;
                AbstractC7185ho.m43821b("RealtimeAdMediator", "ad failed, retcode30: %s, slotId: %s.", Integer.valueOf(iM39424b), strM39419a);
            } else {
                list = listM40830c;
            }
            List<Content> listM39428c = ad30.m39428c();
            if (AbstractC7760bg.m47767a(listM39428c)) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<Content> it = listM39428c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    arrayList = arrayList2;
                    break;
                }
                Content next = it.next();
                if (m45241a(z11, z12, z13)) {
                    arrayList = arrayList2;
                    z10 = true;
                    break;
                }
                ArrayList arrayList4 = arrayList2;
                if (!z11 && next.m39958f() == 12) {
                    content = next;
                    z11 = true;
                } else if (!z12 && next.m39958f() != 12 && next.m39895J() == 0) {
                    content2 = next;
                    z12 = true;
                } else if (!z13 && next.m39958f() != 12 && next.m39895J() != 0) {
                    content3 = next;
                    z13 = true;
                }
                arrayList3.add(next.m39962g());
                arrayList2 = arrayList4;
            }
            m45238a(m45189p().getContext().getApplicationContext(), arrayList3);
            i10++;
            str = strM39419a;
            str2 = strM39434g;
            listM40830c = list;
            arrayList2 = arrayList;
        }
        AbstractC7185ho.m43821b(mo45199z(), "linkedSupportMode:%s, firstNormal: %s, firstLink:%s, firstSpare: %s", Integer.valueOf(mo45170d()), content2, content, content3);
        String str3 = str2;
        m45239a(content, content2, content3, adContentRsp, str, str3);
        return m45236a(adContentRsp, str, content, content2, content3, str3);
    }

    /* renamed from: a */
    private List<ContentRecord> m45235a(AdContentRsp adContentRsp, Content content, Content content2, String str, String str2) {
        AbstractC7014dc.m41868a((ContentRecord) null);
        if (content != null) {
            content.m39925a(adContentRsp.m40847h(), this.f34059n);
            AbstractC7014dc.m41877b(AbstractC7572pf.m46744a(str, content, this.f34059n, str2));
        } else {
            AbstractC7014dc.m41877b((ContentRecord) null);
        }
        if (content2 != null) {
            return m45237a(adContentRsp, str, content2, str2);
        }
        return null;
    }

    /* renamed from: a */
    private List<ContentRecord> m45236a(AdContentRsp adContentRsp, String str, Content content, Content content2, Content content3, String str2) {
        ContentRecord contentRecordM46744a;
        if (mo45170d() != 1 || content == null) {
            return m45235a(adContentRsp, content3, content2, str, str2);
        }
        if (content2 != null) {
            content2.m39925a(adContentRsp.m40847h(), this.f34059n);
            contentRecordM46744a = AbstractC7572pf.m46744a(str, content2, this.f34059n, str2);
        } else {
            contentRecordM46744a = null;
        }
        AbstractC7014dc.m41868a(contentRecordM46744a);
        return m45237a(adContentRsp, str, content, str2);
    }

    /* renamed from: b */
    public void m45246b(boolean z10) {
        this.f34117p = z10;
    }

    /* renamed from: a */
    private List<ContentRecord> m45237a(AdContentRsp adContentRsp, String str, Content content, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m45242b(adContentRsp, str, content, str2));
        return arrayList;
    }

    /* renamed from: a */
    private void m45238a(final Context context, final List<String> list) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.ja.3
            @Override // java.lang.Runnable
            public void run() {
                C7019dh.m41937a(context, Constants.NORMAL_CACHE).m41961a(list, false);
                C7019dh.m41937a(context, Constants.AR_CACHE).m41961a(list, false);
            }
        });
    }

    /* renamed from: a */
    private void m45239a(final Content content, final Content content2, final Content content3, final AdContentRsp adContentRsp, final String str, final String str2) {
        AbstractC7834m.m48479a(new Runnable() { // from class: com.huawei.openalliance.ad.ja.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(C7327ja.this.m45242b(adContentRsp, str, content, str2));
                arrayList.add(C7327ja.this.m45242b(adContentRsp, str, content2, str2));
                arrayList.add(C7327ja.this.m45242b(adContentRsp, str, content3, str2));
                C7327ja c7327ja = C7327ja.this;
                c7327ja.m45159a(arrayList, c7327ja.m45184k().m40639b(), 2);
            }
        });
    }

    /* renamed from: a */
    private boolean m45241a(boolean z10, boolean z11, boolean z12) {
        if (z10 && z11) {
            return true;
        }
        return z11 && z12;
    }
}
