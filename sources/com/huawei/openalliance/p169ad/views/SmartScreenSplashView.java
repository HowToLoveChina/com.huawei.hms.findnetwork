package com.huawei.openalliance.p169ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.uiengine.common.MediaStateApi;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7323ix;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7324iy;
import com.huawei.openalliance.p169ad.C7339jm;
import com.huawei.openalliance.p169ad.C7340jn;
import com.huawei.openalliance.p169ad.C7341jo;
import com.huawei.openalliance.p169ad.C7344jr;
import com.huawei.openalliance.p169ad.C7494nb;
import com.huawei.openalliance.p169ad.C7526nu;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7668sq;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7182hl;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.InterfaceC7342jp;
import com.huawei.openalliance.p169ad.InterfaceC7540oh;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.constant.AdLoadState;
import com.huawei.openalliance.p169ad.constant.ApiNames;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.exception.C7110b;
import com.huawei.openalliance.p169ad.inter.C7288c;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.HiAdSplash;
import com.huawei.openalliance.p169ad.inter.IHiAdSplash;
import com.huawei.openalliance.p169ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7766bm;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class SmartScreenSplashView extends RelativeLayout implements IViewLifeCycle, InterfaceC8119l {

    /* renamed from: A */
    private float f37420A;

    /* renamed from: B */
    private InterfaceC7342jp f37421B;

    /* renamed from: C */
    private C7560ou f37422C;

    /* renamed from: a */
    protected InterfaceC7146gc f37423a;

    /* renamed from: b */
    private int f37424b;

    /* renamed from: c */
    private AdSlotParam f37425c;

    /* renamed from: d */
    private AdListener f37426d;

    /* renamed from: e */
    private InterfaceC7328jb f37427e;

    /* renamed from: f */
    private AdActionListener f37428f;

    /* renamed from: g */
    private InterfaceC7540oh f37429g;

    /* renamed from: h */
    private C8070ae f37430h;

    /* renamed from: i */
    private View f37431i;

    /* renamed from: j */
    private View f37432j;

    /* renamed from: k */
    private InterfaceC8121n f37433k;

    /* renamed from: l */
    private TextView f37434l;

    /* renamed from: m */
    private PPSCircleProgressBar f37435m;

    /* renamed from: n */
    private PPSLabelView f37436n;

    /* renamed from: o */
    private TextView f37437o;

    /* renamed from: p */
    private int f37438p;

    /* renamed from: q */
    private RelativeLayout f37439q;

    /* renamed from: r */
    private RelativeLayout f37440r;

    /* renamed from: s */
    private long f37441s;

    /* renamed from: t */
    private int f37442t;

    /* renamed from: u */
    private final String f37443u;

    /* renamed from: v */
    private long f37444v;

    /* renamed from: w */
    private boolean f37445w;

    /* renamed from: x */
    private boolean f37446x;

    /* renamed from: y */
    private int f37447y;

    /* renamed from: z */
    private C8064a f37448z;

    /* renamed from: com.huawei.openalliance.ad.views.SmartScreenSplashView$a */
    public static class C8064a extends BroadcastReceiver {

        /* renamed from: a */
        private WeakReference<InterfaceC8121n> f37450a;

        public C8064a(InterfaceC8121n interfaceC8121n) {
            this.f37450a = new WeakReference<>(interfaceC8121n);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            InterfaceC8121n interfaceC8121n;
            if (intent == null || !Constants.VOLUME_CHANGED_ACTION.equals(intent.getAction()) || (interfaceC8121n = this.f37450a.get()) == null || !(interfaceC8121n instanceof C8166w)) {
                return;
            }
            ((C8166w) interfaceC8121n).m50634j();
        }
    }

    @OuterVisible
    public SmartScreenSplashView(Context context) {
        super(context);
        this.f37424b = 0;
        this.f37438p = 0;
        this.f37442t = 0;
        this.f37443u = "skip_btn_delay_id_" + hashCode();
        this.f37445w = false;
        this.f37446x = false;
        this.f37447y = 1;
        this.f37420A = 0.18f;
        m49946a(context);
    }

    /* renamed from: d */
    private void m49953d() {
        List<String> listM40627a = this.f37425c.m40627a();
        this.f37429g.mo46217a(!AbstractC7760bg.m47767a(listM40627a) ? listM40627a.get(0) : null, 18);
        this.f37429g.mo46220h();
        InterfaceC7342jp interfaceC7342jp = this.f37421B;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45354b();
        }
        C7288c.m44224a(getContext().getApplicationContext()).m44229a(false);
    }

    /* renamed from: e */
    private void m49955e() {
        if (this.f37434l == null || this.f37435m == null) {
            return;
        }
        int i10 = this.f37442t;
        if (i10 > 0) {
            AbstractC7185ho.m43821b("SmartScreenSplashView", "%d delay, skip btn show", Integer.valueOf(i10));
            AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.SmartScreenSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SmartScreenSplashView.this.f37434l != null) {
                        AbstractC7185ho.m43817a("SmartScreenSplashView", "skip hint show");
                        SmartScreenSplashView.this.f37434l.setVisibility(0);
                    }
                    if (SmartScreenSplashView.this.f37435m != null) {
                        AbstractC7185ho.m43817a("SmartScreenSplashView", "coutDownView show");
                        SmartScreenSplashView.this.f37435m.setVisibility(0);
                    }
                    SmartScreenSplashView.this.f37446x = true;
                }
            }, this.f37443u, this.f37442t);
        } else {
            AbstractC7185ho.m43820b("SmartScreenSplashView", "direct show skip hint");
            this.f37446x = true;
            this.f37434l.setVisibility(0);
            this.f37435m.setVisibility(0);
        }
    }

    private void setVisibleAndBringToFont(View view) {
        if (view != null) {
            view.setVisibility(0);
            view.bringToFront();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: c */
    public void mo49718c() {
        C8070ae c8070ae = this.f37430h;
        if (c8070ae != null) {
            c8070ae.m49993b();
        }
        View view = this.f37431i;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        AbstractC7185ho.m43820b("SmartScreenSplashView", "destroyView ");
        InterfaceC8121n interfaceC8121n = this.f37433k;
        if (interfaceC8121n != null) {
            interfaceC8121n.destroyView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterfaceC7328jb interfaceC7328jb;
        AbstractC7185ho.m43820b("SmartScreenSplashView", "dispatchKeyEvent:" + keyEvent.getKeyCode() + ", " + keyEvent.getAction());
        if (this.f37446x && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (interfaceC7328jb = this.f37427e) != null) {
            interfaceC7328jb.mo45150a(0, 0);
        }
        return true;
    }

    public AdListener getAdListener() {
        return this.f37426d;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public AdSlotParam getAdSlotParam() {
        AdSlotParam adSlotParam = this.f37425c;
        if (adSlotParam != null) {
            adSlotParam.m40648d(18);
        }
        return this.f37425c;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public int getAdType() {
        return 18;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public int getAudioFocusType() {
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public MediaStateApi getMediaProxy() {
        InterfaceC7342jp interfaceC7342jp = this.f37421B;
        if (interfaceC7342jp instanceof C7344jr) {
            return new C7339jm((C7344jr) interfaceC7342jp);
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public C7560ou getMonitorEp() {
        if (this.f37421B instanceof C7341jo) {
            return null;
        }
        return this.f37422C;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    @OuterVisible
    public float getStartMaxVol() {
        return this.f37420A;
    }

    public String getUniqueId() {
        return null;
    }

    @OuterVisible
    public boolean isLoaded() {
        InterfaceC7328jb interfaceC7328jb = this.f37427e;
        return interfaceC7328jb != null && interfaceC7328jb.mo45163b() == AdLoadState.LOADED;
    }

    @OuterVisible
    public boolean isLoading() {
        InterfaceC7328jb interfaceC7328jb = this.f37427e;
        return interfaceC7328jb == null ? this.f37445w : interfaceC7328jb.mo45163b() == AdLoadState.LOADING;
    }

    @OuterVisible
    public void loadAd() {
        AdSlotParam adSlotParam;
        this.f37441s = System.currentTimeMillis();
        AbstractC7185ho.m43820b("SmartScreenSplashView", ApiNames.LOAD_AD);
        if (this.f37429g.mo46218b()) {
            if (this.f37429g.mo46219c() && (adSlotParam = this.f37425c) != null) {
                Integer numM40665r = adSlotParam.m40665r();
                AbstractC7185ho.m43821b("SmartScreenSplashView", "startMode %s", numM40665r);
                if ((numM40665r != null && numM40665r.intValue() == 0) || (numM40665r.intValue() == 1 && C7288c.m44224a(getContext()).m44230a())) {
                    m49953d();
                    return;
                }
            }
            if (this.f37425c != null) {
                C7762bi.m47788b(getContext().getApplicationContext(), this.f37425c.m40659l());
            }
            this.f37445w = true;
            this.f37429g.mo46215a();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        InterfaceC7328jb interfaceC7328jb;
        AbstractC7185ho.m43821b("SmartScreenSplashView", "onKeyDown, keyCode: %s", Integer.valueOf(keyEvent.getKeyCode()));
        if (this.f37446x && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (interfaceC7328jb = this.f37427e) != null) {
            interfaceC7328jb.mo45150a(0, 0);
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        AbstractC7185ho.m43820b("SmartScreenSplashView", "pauseView ");
        InterfaceC8121n interfaceC8121n = this.f37433k;
        if (interfaceC8121n != null) {
            interfaceC8121n.pauseView();
        }
        if (getContext() != null) {
            try {
                if (this.f37448z != null) {
                    getContext().unregisterReceiver(this.f37448z);
                    this.f37448z = null;
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("SmartScreenSplashView", "unregister err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        AbstractC7185ho.m43820b("SmartScreenSplashView", "resumeView ");
        InterfaceC8121n interfaceC8121n = this.f37433k;
        if (interfaceC8121n != null) {
            interfaceC8121n.resumeView();
        }
    }

    @OuterVisible
    public void setAdActionListener(AdActionListener adActionListener) {
        this.f37428f = adActionListener;
        InterfaceC7328jb interfaceC7328jb = this.f37427e;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45155a(adActionListener);
        }
    }

    @OuterVisible
    public void setAdListener(AdListener adListener) {
        this.f37426d = adListener;
        this.f37429g.mo46216a(adListener);
        InterfaceC7328jb interfaceC7328jb = this.f37427e;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45156a(adListener);
        }
    }

    @OuterVisible
    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (AbstractC7741ao.m47562b(getContext())) {
            int iM48203a = AbstractC7807d.m48203a(getContext(), adSlotParam.m40639b());
            int iM48216b = AbstractC7807d.m48216b(getContext(), adSlotParam.m40639b());
            adSlotParam.m40640b(iM48203a);
            adSlotParam.m40643c(iM48216b);
            adSlotParam.m40628a(8);
            adSlotParam.m40641b(Integer.valueOf(this.f37424b));
            adSlotParam.m40644c((Integer) 0);
            adSlotParam.m40649d(Integer.valueOf((HiAd.m44014a(getContext()).mo44052e() && AbstractC7807d.m48257t(getContext())) ? 0 : 1));
            this.f37425c = adSlotParam;
            IHiAdSplash hiAdSplash = HiAdSplash.getInstance(getContext());
            if (hiAdSplash instanceof HiAdSplash) {
                ((HiAdSplash) hiAdSplash).m44089a(adSlotParam);
            }
        }
    }

    @OuterVisible
    public void setAudioFocusType(int i10) {
        this.f37447y = i10;
        InterfaceC8121n interfaceC8121n = this.f37433k;
        if (interfaceC8121n != null) {
            interfaceC8121n.setAudioFocusType(i10);
        }
    }

    @OuterVisible
    public void setLinkedSupportMode(int i10) {
        this.f37424b = i10;
    }

    @OuterVisible
    public void setLogo(View view) {
        setLogo(view, 0);
    }

    @OuterVisible
    public void setSloganResId(int i10) {
        if (AbstractC7741ao.m47562b(getContext())) {
            if (AbstractC7811dd.m48317c(getContext())) {
                AbstractC7185ho.m43823c("SmartScreenSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.f37425c == null) {
                throw new C7110b("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.f37430h == null) {
                C8070ae c8070ae = new C8070ae(getContext(), this.f37425c.m40639b(), i10, 18);
                this.f37430h = c8070ae;
                this.f37439q.addView(c8070ae, new RelativeLayout.LayoutParams(-1, -1));
                this.f37430h.m49993b();
            }
        }
    }

    @OuterVisible
    public void setSloganView(View view) {
        if (view != null) {
            this.f37431i = view;
            view.setVisibility(8);
        }
    }

    @OuterVisible
    public void setStartMaxVol(float f10) {
        if (f10 >= 0.0f) {
            if (f10 <= 1.0f) {
                AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                AbstractC7185ho.m43821b("SmartScreenSplashView", "music max %s, current %s， maxVol： %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f10));
                float f11 = streamVolume;
                float f12 = streamMaxVolume * 1.0f * f10;
                float f13 = f11 * 1.0f >= f12 ? f12 / f11 : 1.0f;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("SmartScreenSplashView", "maxVol end: %s", Float.valueOf(f13));
                }
                this.f37420A = f13;
                return;
            }
        }
        AbstractC7185ho.m43823c("SmartScreenSplashView", "valid max vol is from 0.0 to 1.0");
    }

    @OuterVisible
    public SmartScreenSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37424b = 0;
        this.f37438p = 0;
        this.f37442t = 0;
        this.f37443u = "skip_btn_delay_id_" + hashCode();
        this.f37445w = false;
        this.f37446x = false;
        this.f37447y = 1;
        this.f37420A = 0.18f;
        m49946a(context);
    }

    /* renamed from: c */
    private boolean m49952c(ContentRecord contentRecord) {
        if (contentRecord.m41464aP() == 2 && contentRecord.m41419S() != null) {
            return false;
        }
        if (contentRecord.m41464aP() != 3 || AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
            return true;
        }
        Iterator<Asset> it = contentRecord.m41471aW().iterator();
        while (it.hasNext()) {
            if (it.next().m40517e() != null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private void m49954d(ContentRecord contentRecord) {
        MetaData metaDataM41568i;
        if (contentRecord == null) {
            return;
        }
        if (this.f37436n != null) {
            String strM41411O = contentRecord.m41411O();
            this.f37436n.setDataAndRefreshUi(contentRecord);
            if (TextUtils.isEmpty(strM41411O) || !this.f37436n.m49215a()) {
                this.f37436n.setVisibility(8);
            } else {
                MetaData metaDataM41568i2 = contentRecord.m41568i();
                if (metaDataM41568i2 == null || AdSource.m39547a(metaDataM41568i2.m40275L()) == null) {
                    this.f37436n.setText(strM41411O);
                } else {
                    this.f37436n.m49210a(AdSource.m39547a(metaDataM41568i2.m40275L()), strM41411O);
                }
                this.f37436n.setVisibility(0);
            }
        }
        if (this.f37437o == null || (metaDataM41568i = contentRecord.m41568i()) == null) {
            return;
        }
        String strM48168c = AbstractC7806cz.m48168c(metaDataM41568i.m40326l());
        if (TextUtils.isEmpty(strM48168c)) {
            this.f37437o.setVisibility(8);
        } else {
            this.f37437o.setText(strM48168c);
            this.f37437o.setVisibility(0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public InterfaceC8121n mo49705a(int i10) {
        if (i10 == 2) {
            return new C8147q(getContext(), 18);
        }
        if (i10 != 9) {
            return null;
        }
        C8166w c8166w = new C8166w(getContext(), this.f37425c.m40639b(), 0, this.f37425c.m40647d(), 18);
        c8166w.setHideSoundIcon(true);
        c8166w.setIgnoreSoundCtrl(false);
        c8166w.setStartVol(this.f37420A);
        return c8166w;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: b */
    public Integer mo49715b(ContentRecord contentRecord) {
        return null;
    }

    @OuterVisible
    public void setLogo(View view, int i10) {
        this.f37432j = view;
        view.setVisibility(i10);
        this.f37438p = i10;
    }

    @OuterVisible
    public SmartScreenSplashView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37424b = 0;
        this.f37438p = 0;
        this.f37442t = 0;
        this.f37443u = "skip_btn_delay_id_" + hashCode();
        this.f37445w = false;
        this.f37446x = false;
        this.f37447y = 1;
        this.f37420A = 0.18f;
        m49946a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49706a() {
        InterfaceC7342jp interfaceC7342jp = this.f37421B;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45351a();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: b */
    public void mo49716b() {
        InterfaceC7342jp interfaceC7342jp = this.f37421B;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45354b();
            this.f37421B = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49707a(int i10, int i11, String str, boolean z10, Integer num) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: b */
    public void mo49717b(int i10) {
        AbstractC7185ho.m43818a("SmartScreenSplashView", "update left time, total: %s, left: %s", Long.valueOf(this.f37444v), Integer.valueOf(i10));
        long j10 = this.f37444v;
        int iDoubleValue = j10 > 0 ? (int) ((1.0d - C7766bm.m47803a(Double.valueOf(((i10 - 1) * 1000) / j10), 2, 4).doubleValue()) * 100.0d) : 0;
        if (iDoubleValue >= 100) {
            iDoubleValue = 100;
        }
        PPSCircleProgressBar pPSCircleProgressBar = this.f37435m;
        if (pPSCircleProgressBar != null) {
            pPSCircleProgressBar.m49035a(iDoubleValue, AbstractC7806cz.m48153a(Integer.valueOf(i10)));
        }
    }

    /* renamed from: b */
    private void m49951b(Context context) {
        View.inflate(context, AbstractC7741ao.m47593o(context) ? C6849R.layout.hiad_view_tv_splash_ad_elderly : C6849R.layout.hiad_view_tv_splash_ad, this);
        this.f37439q = (RelativeLayout) findViewById(C6849R.id.rl_splash_container);
        this.f37440r = (RelativeLayout) findViewById(C6849R.id.hiad_logo_container);
        this.f37434l = (TextView) findViewById(C6849R.id.hiad_skip_text);
        this.f37435m = (PPSCircleProgressBar) findViewById(C6849R.id.hiad_count_progress);
        this.f37436n = (PPSLabelView) findViewById(C6849R.id.hiad_ad_label);
        this.f37437o = (TextView) findViewById(C6849R.id.hiad_ad_source);
        setFocusable(true);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49708a(int i10, boolean z10) {
    }

    /* renamed from: a */
    private void m49946a(Context context) {
        m49951b(context);
        this.f37423a = C7124fh.m43316b(context.getApplicationContext());
        this.f37429g = new C7526nu(context.getApplicationContext(), this);
        this.f37442t = this.f37423a.mo43396bW();
        this.f37422C = new C7560ou(context, new C7668sq(context, 1));
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49709a(View view, ContentRecord contentRecord) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49710a(AdLoadMode adLoadMode) {
        AbstractC7323ix abstractC7323ixM45202a = C7324iy.m45202a(adLoadMode, this);
        this.f37427e = abstractC7323ixM45202a;
        abstractC7323ixM45202a.mo45156a(this.f37426d);
        this.f37427e.mo45155a(this.f37428f);
        this.f37427e.mo45149a(this.f37424b);
        this.f37427e.mo45165b(this.f37441s);
        this.f37427e.mo45208A();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49711a(ContentRecord contentRecord) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49712a(ContentRecord contentRecord, int i10) {
        AbstractC7185ho.m43817a("SmartScreenSplashView", "showLabelView and logo.");
        if (this.f37434l != null && this.f37435m != null) {
            if (contentRecord != null && contentRecord.m41568i() != null && contentRecord.m41392E() == 9) {
                long jM40345y = contentRecord.m41568i().m40345y();
                this.f37444v = jM40345y;
                this.f37435m.m49035a(0, AbstractC7806cz.m48153a(Integer.valueOf((int) ((jM40345y * 1.0f) / 1000.0f))));
            }
            m49955e();
        }
        if (this.f37440r != null && this.f37432j != null) {
            AbstractC7185ho.m43821b("SmartScreenSplashView", "show logo, visibility: %s", Integer.valueOf(this.f37438p));
            this.f37440r.addView(this.f37432j);
            this.f37432j.setVisibility(this.f37438p);
        }
        m49954d(contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49713a(InterfaceC7182hl interfaceC7182hl) {
        View view = this.f37431i;
        if (view != null) {
            view.setVisibility(0);
            new C7494nb(this.f37423a, interfaceC7182hl).mo45920a();
            return;
        }
        C8070ae c8070ae = this.f37430h;
        if (c8070ae == null) {
            AbstractC7185ho.m43820b("SmartScreenSplashView", "create default slogan");
            setSloganResId(C6849R.drawable.hiad_default_slogan);
            c8070ae = this.f37430h;
            if (c8070ae == null) {
                return;
            }
        }
        c8070ae.setSloganShowListener(interfaceC7182hl);
        this.f37430h.m49991a();
    }

    /* renamed from: a */
    private void m49947a(InterfaceC8121n interfaceC8121n) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.VOLUME_CHANGED_ACTION);
        if (this.f37448z == null) {
            this.f37448z = new C8064a(interfaceC8121n);
        }
        AbstractC7741ao.m47536a(getContext(), this.f37448z, intentFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49714a(InterfaceC8121n interfaceC8121n, ContentRecord contentRecord) {
        if (AbstractC7811dd.m48317c(getContext())) {
            AbstractC7185ho.m43823c("SmartScreenSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (interfaceC8121n == 0 || !(interfaceC8121n instanceof View)) {
            return;
        }
        View view = (View) interfaceC8121n;
        this.f37433k = interfaceC8121n;
        m49948a(false, view, contentRecord);
        interfaceC8121n.setAudioFocusType(this.f37447y);
        m49947a(this.f37433k);
        ViewParent parent = view.getParent();
        if (parent == this.f37439q) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            AbstractC7185ho.m43820b("SmartScreenSplashView", "showAdView, remove adView.");
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        setVisibleAndBringToFont(this.f37440r);
        setVisibleAndBringToFont(this.f37432j);
        this.f37439q.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    /* renamed from: a */
    private void m49948a(boolean z10, View view, ContentRecord contentRecord) {
        if (contentRecord == null) {
            AbstractC7185ho.m43820b("SmartScreenSplashView", "getMonitor, contentRecord is null.");
            return;
        }
        this.f37422C.m46575a(contentRecord.m41505b());
        InterfaceC7342jp interfaceC7342jpM45339a = C7340jn.m45339a(getContext(), m49952c(contentRecord), this.f37422C, contentRecord, z10);
        this.f37421B = interfaceC7342jpM45339a;
        interfaceC7342jpM45339a.mo45352a(view);
        if (view instanceof C8166w) {
            this.f37421B.mo45353a(((C8166w) view).getVideoView());
        }
        C7340jn.m45343a(contentRecord.m41588n(), this.f37421B);
    }
}
