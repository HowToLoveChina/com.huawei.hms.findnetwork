package com.huawei.openalliance.p169ad.views;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.uiengine.common.IInterstitialView;
import com.huawei.hms.ads.uiengine.common.InterstitialApi;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractC7687ti;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7331je;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7495nc;
import com.huawei.openalliance.p169ad.C7563ox;
import com.huawei.openalliance.p169ad.C7686th;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.EnumC7480mo;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.activity.ComplianceActivity;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a;
import com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.utils.C7756bc;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.views.gif.C8101b;
import com.huawei.openalliance.p169ad.views.gif.GifPlayView;
import com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d;
import com.huawei.openalliance.p169ad.views.interfaces.C8109b;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8106a;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class PPSInterstitialView extends AutoScaleSizeRelativeLayout implements View.OnClickListener, IInterstitialView, C7331je.a, InterfaceC7337jk, InterfaceC7403lm, MuteListener, SegmentMediaStateListener, InterfaceC7470a, NetworkChangeListener {

    /* renamed from: A */
    private int f36687A;

    /* renamed from: B */
    private boolean f36688B;

    /* renamed from: C */
    private long f36689C;

    /* renamed from: D */
    private int f36690D;

    /* renamed from: E */
    private long f36691E;

    /* renamed from: F */
    private boolean f36692F;

    /* renamed from: G */
    private boolean f36693G;

    /* renamed from: H */
    private boolean f36694H;

    /* renamed from: I */
    private int f36695I;

    /* renamed from: J */
    private int f36696J;

    /* renamed from: K */
    private long f36697K;

    /* renamed from: L */
    private boolean f36698L;

    /* renamed from: M */
    private boolean f36699M;

    /* renamed from: N */
    private C7331je f36700N;

    /* renamed from: O */
    private InterfaceC7311a f36701O;

    /* renamed from: P */
    private final String f36702P;

    /* renamed from: Q */
    private AdLandingPageData f36703Q;

    /* renamed from: R */
    private int f36704R;

    /* renamed from: S */
    private CountDownTimer f36705S;

    /* renamed from: T */
    private int f36706T;

    /* renamed from: U */
    private Context f36707U;

    /* renamed from: V */
    private boolean f36708V;

    /* renamed from: W */
    private boolean f36709W;

    /* renamed from: a */
    private InterfaceC7416lz f36710a;

    /* renamed from: aa */
    private C7022dk f36711aa;

    /* renamed from: ab */
    private PPSAppDetailTemplateView f36712ab;

    /* renamed from: ac */
    private TextView f36713ac;

    /* renamed from: ad */
    private PPSAppDownLoadWithAnimationView f36714ad;

    /* renamed from: ae */
    private MaterialClickInfo f36715ae;

    /* renamed from: af */
    private boolean f36716af;

    /* renamed from: ag */
    private boolean f36717ag;

    /* renamed from: ah */
    private TextView f36718ah;

    /* renamed from: ai */
    private int f36719ai;

    /* renamed from: aj */
    private int f36720aj;

    /* renamed from: b */
    private C7301d f36721b;

    /* renamed from: c */
    private ContentRecord f36722c;

    /* renamed from: d */
    private String f36723d;

    /* renamed from: e */
    private PPSInterstitialVideoView f36724e;

    /* renamed from: f */
    private ImageView f36725f;

    /* renamed from: g */
    private int f36726g;

    /* renamed from: h */
    private View f36727h;

    /* renamed from: i */
    private PPSAppDetailView f36728i;

    /* renamed from: j */
    private PPSAppDetailView f36729j;

    /* renamed from: k */
    private PPSExpandButtonDetailView f36730k;

    /* renamed from: l */
    private TextView f36731l;

    /* renamed from: m */
    private ImageView f36732m;

    /* renamed from: n */
    private GifPlayView f36733n;

    /* renamed from: o */
    private ViewGroup f36734o;

    /* renamed from: p */
    private TextView f36735p;

    /* renamed from: q */
    private PPSLabelSourceView f36736q;

    /* renamed from: r */
    private PPSLabelView f36737r;

    /* renamed from: s */
    private boolean f36738s;

    /* renamed from: t */
    private InterfaceC7956b f36739t;

    /* renamed from: u */
    private C7495nc f36740u;

    /* renamed from: v */
    private ChoicesView f36741v;

    /* renamed from: w */
    private boolean f36742w;

    /* renamed from: x */
    private Dialog f36743x;

    /* renamed from: y */
    private ProgressBar f36744y;

    /* renamed from: z */
    private boolean f36745z;

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$1 */
    public class ViewOnClickListenerC79411 implements View.OnClickListener {
        public ViewOnClickListenerC79411() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PPSInterstitialView.this.f36721b == null) {
                AbstractC7185ho.m43823c("PPSInterstitialView", "AdInfo is null or contentData is null");
            } else if (AbstractC7760bg.m47767a(PPSInterstitialView.this.f36721b.getCompliance())) {
                AbstractC7807d.m48214a(PPSInterstitialView.this.getContext(), PPSInterstitialView.this.f36721b);
            } else {
                ComplianceActivity.m38595a(PPSInterstitialView.this.getContext(), view, C7563ox.m46653a(PPSInterstitialView.this.f36721b), true);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$10 */
    public class RunnableC794210 implements Runnable {

        /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$10$1 */
        public class AnonymousClass1 implements AbstractC7846y.a {
            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
            /* renamed from: a */
            public void mo42634a() {
                PPSInterstitialView.this.f36745z = false;
                PPSInterstitialView.this.m49131b(false);
            }

            @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
            /* renamed from: a */
            public void mo42635a(boolean z10) {
                PPSInterstitialView.this.m49158i();
            }
        }

        public RunnableC794210() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            if (PPSInterstitialView.this.f36743x != null && PPSInterstitialView.this.f36743x.isShowing()) {
                PPSInterstitialView.this.f36743x.dismiss();
            }
            AbstractC7185ho.m43820b("PPSInterstitialView", "pop up dialog");
            Resources resources = PPSInterstitialView.this.getResources();
            String string = resources.getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size);
            String string2 = resources.getString(C6849R.string.hiad_reward_close_dialog_continue);
            String string3 = resources.getString(C6849R.string.hiad_reward_close_dialog_close);
            PPSInterstitialView pPSInterstitialView = PPSInterstitialView.this;
            pPSInterstitialView.f36743x = AbstractC7846y.m48620a(pPSInterstitialView.getContext(), "", string, string2, string3, new AbstractC7846y.a() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.10.1
                public AnonymousClass1() {
                }

                @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
                /* renamed from: a */
                public void mo42634a() {
                    PPSInterstitialView.this.f36745z = false;
                    PPSInterstitialView.this.m49131b(false);
                }

                @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
                /* renamed from: a */
                public void mo42635a(boolean z10) {
                    PPSInterstitialView.this.m49158i();
                }
            });
            PPSInterstitialView.this.f36743x.setCancelable(false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$11 */
    public class C794311 implements InterfaceC8110c {
        public C794311() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c
        /* renamed from: a */
        public void mo38703a(C8109b c8109b) {
            if (c8109b == null || c8109b.m50306e() == null) {
                AbstractC7185ho.m43823c("PPSInterstitialView", "invalid click");
                return;
            }
            Integer numM50306e = c8109b.m50306e();
            int iIntValue = numM50306e.intValue();
            AbstractC7185ho.m43821b("PPSInterstitialView", "action: %d", numM50306e);
            if (iIntValue != 0) {
                return;
            }
            PPSInterstitialView.this.m49122a(c8109b);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$12 */
    public class C794412 implements InterfaceC8106a {
        public C794412() {
        }

        @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8106a
        /* renamed from: a */
        public void mo47419a(int i10) {
            PPSInterstitialView.this.m49138c(Integer.valueOf(i10));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$13 */
    public class C794513 implements C7752az.a {

        /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$13$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Drawable f36752a;

            /* renamed from: b */
            final /* synthetic */ Drawable f36753b;

            public AnonymousClass1(Drawable drawable, Drawable drawable2) {
                drawable = drawable;
                drawable = drawable2;
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSInterstitialView.this.f36728i.setAppIconImageDrawable(drawable);
                if (PPSInterstitialView.this.f36712ab != null) {
                    PPSInterstitialView.this.f36712ab.setAppIconImageDrawable(drawable);
                }
                if (!(drawable instanceof C8101b) && PPSInterstitialView.this.f36734o != null && drawable != null && PPSInterstitialView.this.f36726g != 3) {
                    PPSInterstitialView.this.f36734o.setBackground(drawable);
                    View viewM48374d = C7818dk.m48374d(PPSInterstitialView.this.f36707U);
                    if (viewM48374d != null) {
                        PPSInterstitialView.this.f36734o.addView(viewM48374d, 0);
                    }
                }
                AbstractC7185ho.m43817a("PPSInterstitialView", "get icon suucess");
            }
        }

        public C794513() {
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30231a() {
            AbstractC7185ho.m43820b("PPSInterstitialView", "get icon failed");
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30232a(Drawable drawable) {
            if (drawable != null) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.13.1

                    /* renamed from: a */
                    final /* synthetic */ Drawable f36752a;

                    /* renamed from: b */
                    final /* synthetic */ Drawable f36753b;

                    public AnonymousClass1(Drawable drawable2, Drawable drawable22) {
                        drawable = drawable2;
                        drawable = drawable22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PPSInterstitialView.this.f36728i.setAppIconImageDrawable(drawable);
                        if (PPSInterstitialView.this.f36712ab != null) {
                            PPSInterstitialView.this.f36712ab.setAppIconImageDrawable(drawable);
                        }
                        if (!(drawable instanceof C8101b) && PPSInterstitialView.this.f36734o != null && drawable != null && PPSInterstitialView.this.f36726g != 3) {
                            PPSInterstitialView.this.f36734o.setBackground(drawable);
                            View viewM48374d = C7818dk.m48374d(PPSInterstitialView.this.f36707U);
                            if (viewM48374d != null) {
                                PPSInterstitialView.this.f36734o.addView(viewM48374d, 0);
                            }
                        }
                        AbstractC7185ho.m43817a("PPSInterstitialView", "get icon suucess");
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$14 */
    public class ViewOnClickListenerC794614 implements View.OnClickListener {
        public ViewOnClickListenerC794614() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PPSInterstitialView.this.f36738s) {
                PPSInterstitialView.this.f36724e.m49097h();
            } else {
                PPSInterstitialView.this.f36724e.m49096g();
            }
            if (PPSInterstitialView.this.f36740u != null) {
                PPSInterstitialView.this.f36740u.m45929a(!PPSInterstitialView.this.f36738s);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$2 */
    public class ViewOnClickListenerC79472 implements View.OnClickListener {
        public ViewOnClickListenerC79472() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PPSInterstitialView.this.m49161k();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$3 */
    public class C79483 implements C7752az.a {

        /* renamed from: a */
        final /* synthetic */ int f36757a;

        /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$3$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Drawable f36759a;

            public AnonymousClass1(Drawable drawable) {
                drawable = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PPSInterstitialView.this.f36706T == 1 && !AbstractC7741ao.m47592n(PPSInterstitialView.this.f36707U)) {
                    PPSInterstitialView.this.f36734o.setBackgroundColor(PPSInterstitialView.this.getResources().getColor(C6849R.color.hiad_70_percent_black));
                }
                if (drawable instanceof C8101b) {
                    PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                    Drawable drawable = drawable;
                    ((C8101b) drawable).m50248a(PPSInterstitialView.this.new C7955a(drawable));
                } else {
                    PPSInterstitialView.this.f36744y.setVisibility(8);
                    PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                    PPSInterstitialView.this.f36698L = true;
                    PPSInterstitialView.this.f36697K = System.currentTimeMillis();
                    PPSInterstitialView.this.m49103F();
                }
                PPSInterstitialView pPSInterstitialView = PPSInterstitialView.this;
                pPSInterstitialView.m49152f(pPSInterstitialView.f36704R * 1000);
            }
        }

        /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$3$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSInterstitialView.this.f36735p.setVisibility(8);
                PPSInterstitialView.this.f36732m.setVisibility(0);
                PPSInterstitialView.this.f36733n.setImageResource(i);
            }
        }

        public C79483(int i10) {
            i = i10;
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30231a() {
            AbstractC7185ho.m43826d("PPSInterstitialView", "loadImage fail");
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.3.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSInterstitialView.this.f36735p.setVisibility(8);
                    PPSInterstitialView.this.f36732m.setVisibility(0);
                    PPSInterstitialView.this.f36733n.setImageResource(i);
                }
            });
        }

        @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
        /* renamed from: a */
        public void mo30232a(Drawable drawable) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.3.1

                /* renamed from: a */
                final /* synthetic */ Drawable f36759a;

                public AnonymousClass1(Drawable drawable2) {
                    drawable = drawable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (PPSInterstitialView.this.f36706T == 1 && !AbstractC7741ao.m47592n(PPSInterstitialView.this.f36707U)) {
                        PPSInterstitialView.this.f36734o.setBackgroundColor(PPSInterstitialView.this.getResources().getColor(C6849R.color.hiad_70_percent_black));
                    }
                    if (drawable instanceof C8101b) {
                        PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                        Drawable drawable2 = drawable;
                        ((C8101b) drawable2).m50248a(PPSInterstitialView.this.new C7955a(drawable2));
                    } else {
                        PPSInterstitialView.this.f36744y.setVisibility(8);
                        PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                        PPSInterstitialView.this.f36698L = true;
                        PPSInterstitialView.this.f36697K = System.currentTimeMillis();
                        PPSInterstitialView.this.m49103F();
                    }
                    PPSInterstitialView pPSInterstitialView = PPSInterstitialView.this;
                    pPSInterstitialView.m49152f(pPSInterstitialView.f36704R * 1000);
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$4 */
    public class RunnableC79494 implements Runnable {
        public RunnableC79494() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSInterstitialView.this.f36735p.setVisibility(8);
            PPSInterstitialView.this.f36732m.setVisibility(0);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$5 */
    public class RunnableC79505 implements Runnable {
        public RunnableC79505() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7301d c7301d = PPSInterstitialView.this.f36721b;
            if (PPSInterstitialView.this.f36698L) {
                if ((PPSInterstitialView.this.m49181u() || PPSInterstitialView.this.m49183v()) && PPSInterstitialView.this.f36700N != null) {
                    PPSInterstitialView.this.m49123a(Long.valueOf(c7301d.getMinEffectiveShowTime()), Integer.valueOf(PPSInterstitialView.this.f36700N.m45277c()), (Integer) null);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$6 */
    public class CountDownTimerC79516 extends CountDownTimer {
        public CountDownTimerC79516(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PPSInterstitialView.this.f36735p.setVisibility(8);
            PPSInterstitialView.this.f36732m.setVisibility(0);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            int i10 = (int) (j10 / 1000);
            PPSInterstitialView.this.m49109a(i10 + 1, false);
            AbstractC7185ho.m43818a("PPSInterstitialView", "count down time: %d seconds: %d", Long.valueOf(j10), Integer.valueOf(i10));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$7 */
    public class RunnableC79527 implements Runnable {
        public RunnableC79527() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSInterstitialView.this.f36716af = true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$8 */
    public class RunnableC79538 implements Runnable {
        public RunnableC79538() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSInterstitialView.this.f36724e.m49095f();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$9 */
    public class RunnableC79549 implements Runnable {
        public RunnableC79549() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSInterstitialView.this.m49174r();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$a */
    public class C7955a implements InterfaceC8103d {

        /* renamed from: b */
        private Drawable f36769b;

        public C7955a(Drawable drawable) {
            this.f36769b = drawable;
        }

        @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
        /* renamed from: a */
        public void mo48916a() {
            if (PPSInterstitialView.this.f36699M || this.f36769b.getIntrinsicHeight() == PPSInterstitialView.this.f36690D || this.f36769b.getIntrinsicWidth() == PPSInterstitialView.this.f36690D) {
                return;
            }
            PPSInterstitialView.this.f36699M = true;
            PPSInterstitialView.this.f36744y.setVisibility(8);
            PPSInterstitialView.this.f36733n.requestLayout();
            PPSInterstitialView.this.f36698L = true;
            PPSInterstitialView.this.f36697K = System.currentTimeMillis();
            PPSInterstitialView.this.m49103F();
        }

        @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
        /* renamed from: b */
        public void mo48917b() {
            PPSInterstitialView.this.f36735p.setVisibility(8);
            PPSInterstitialView.this.f36732m.setVisibility(0);
        }

        @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
        /* renamed from: c */
        public void mo48918c() {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$b */
    public interface InterfaceC7956b {
        /* renamed from: b */
        void mo38736b();
    }

    public PPSInterstitialView(Context context) {
        super(context);
        this.f36710a = new C7405lo();
        this.f36738s = true;
        this.f36742w = true;
        this.f36745z = true;
        this.f36687A = -1;
        this.f36688B = false;
        this.f36689C = -1L;
        this.f36690D = -1;
        this.f36691E = 0L;
        this.f36692F = false;
        this.f36693G = false;
        this.f36694H = false;
        this.f36698L = false;
        this.f36699M = false;
        this.f36702P = "interstitial_imp_monitor_" + hashCode();
        this.f36706T = 0;
        this.f36709W = false;
        this.f36716af = true;
        this.f36717ag = false;
        m49112a(context, (AttributeSet) null);
    }

    /* renamed from: A */
    private boolean m49098A() {
        int i10 = this.f36726g;
        return i10 == 4 || i10 == 5;
    }

    /* renamed from: B */
    private void m49099B() {
        if (TextUtils.isEmpty(this.f36721b.m44690G()) && TextUtils.isEmpty(this.f36721b.getCta())) {
            this.f36728i.setVisibility(8);
        } else {
            AppInfo appInfo = new AppInfo();
            appInfo.m44419o(this.f36721b.m44690G());
            this.f36703Q.m44266a(appInfo);
            this.f36728i.setAppRelated(false);
        }
        if (this.f36721b.m44686E() == 0) {
            this.f36728i.setVisibility(8);
        }
    }

    /* renamed from: C */
    private void m49100C() {
        TextView textView;
        if ((m49101D() || this.f36709W) && (textView = this.f36713ac) != null && this.f36726g == 3) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: D */
    private boolean m49101D() {
        return AbstractC7558os.m46467f(this.f36721b.getCtrlSwitchs()) == 2 || AbstractC7741ao.m47592n(this.f36707U);
    }

    /* renamed from: E */
    private void m49102E() {
        if (!m49179t()) {
            this.f36724e.setVisibility(8);
            this.f36725f.setVisibility(8);
            this.f36727h.setVisibility(8);
            return;
        }
        this.f36724e.m49086a((InterfaceC7470a) this);
        this.f36724e.m49084a((MuteListener) this);
        this.f36724e.m49085a((SegmentMediaStateListener) this);
        this.f36724e.m49087a((NetworkChangeListener) this);
        m49114a(this.f36722c);
        this.f36724e.m49082a(this.f36721b, this.f36722c);
        this.f36725f.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.14
            public ViewOnClickListenerC794614() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSInterstitialView.this.f36738s) {
                    PPSInterstitialView.this.f36724e.m49097h();
                } else {
                    PPSInterstitialView.this.f36724e.m49096g();
                }
                if (PPSInterstitialView.this.f36740u != null) {
                    PPSInterstitialView.this.f36740u.m45929a(!PPSInterstitialView.this.f36738s);
                }
            }
        });
        VideoInfo videoInfoM44698K = this.f36721b.m44698K();
        if (videoInfoM44698K != null) {
            if (!videoInfoM44698K.m44582e()) {
                this.f36725f.setVisibility(4);
            }
            if (this.f36696J <= 0) {
                this.f36696J = videoInfoM44698K.getVideoDuration();
            }
        }
        if (this.f36696J <= 0) {
            this.f36696J = (int) this.f36721b.m44716W();
        }
        this.f36727h.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.2
            public ViewOnClickListenerC79472() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSInterstitialView.this.m49161k();
            }
        });
    }

    /* renamed from: F */
    public void m49103F() {
        if (this.f36721b != null) {
            AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.5
                public RunnableC79505() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7301d c7301d = PPSInterstitialView.this.f36721b;
                    if (PPSInterstitialView.this.f36698L) {
                        if ((PPSInterstitialView.this.m49181u() || PPSInterstitialView.this.m49183v()) && PPSInterstitialView.this.f36700N != null) {
                            PPSInterstitialView.this.m49123a(Long.valueOf(c7301d.getMinEffectiveShowTime()), Integer.valueOf(PPSInterstitialView.this.f36700N.m45277c()), (Integer) null);
                        }
                    }
                }
            }, this.f36702P, this.f36721b.getMinEffectiveShowTime());
        }
    }

    /* renamed from: G */
    private void m49104G() {
        PPSLabelView pPSLabelView = this.f36737r;
        if (pPSLabelView == null) {
            return;
        }
        pPSLabelView.m49216b();
    }

    /* renamed from: H */
    private void m49105H() {
        C7301d c7301d = this.f36721b;
        if (c7301d == null || AbstractC7558os.m46460H(c7301d.getCtrlSwitchs())) {
            return;
        }
        this.f36738s = this.f36721b.m44714U();
    }

    /* renamed from: b */
    private int m49127b(ContentRecord contentRecord) {
        int iM40272I = (contentRecord == null || contentRecord.m41568i() == null) ? 2 : contentRecord.m41568i().m40272I();
        if ((this.f36706T == 1 && !AbstractC7741ao.m47592n(this.f36707U)) || iM40272I < 1 || iM40272I > 5 || ((iM40272I == 1 || iM40272I == 5) && (contentRecord == null || contentRecord.m41484af() == null || TextUtils.isEmpty(contentRecord.m41484af().getIconUrl())))) {
            return 2;
        }
        if (2 == getResources().getConfiguration().orientation && iM40272I != 1) {
            return 2;
        }
        int iM48335k = AbstractC7811dd.m48335k(getContext());
        if (((iM48335k == 0 || 8 == iM48335k) && iM40272I != 1) || !m49140c(contentRecord)) {
            return 2;
        }
        return iM40272I;
    }

    /* renamed from: c */
    private void m49134c(int i10) {
        int i11;
        if (this.f36688B && (i11 = this.f36687A) >= 0) {
            this.f36689C = i10 - i11;
            this.f36688B = false;
        }
        this.f36687A = -1;
    }

    /* renamed from: e */
    private int m49146e(int i10) {
        int i11 = (this.f36696J / 1000) - i10;
        if (i11 < 0) {
            return 0;
        }
        return i11;
    }

    /* renamed from: k */
    public void m49161k() {
        if (!m49164l()) {
            if (!C7775bv.m47831e(getContext())) {
                Toast.makeText(getContext().getApplicationContext(), C6849R.string.hiad_network_error, 0).show();
                return;
            } else if (this.f36745z) {
                m49184w();
                return;
            }
        }
        m49177s();
    }

    /* renamed from: n */
    private boolean m49167n() {
        if (m49179t()) {
            return m49170o() || C7775bv.m47829c(getContext());
        }
        return false;
    }

    /* renamed from: r */
    public void m49174r() {
        AbstractC7185ho.m43820b("PPSInterstitialView", "loop");
        if (m49167n()) {
            m49177s();
            return;
        }
        if (m49173q()) {
            this.f36724e.m49080a();
        }
        this.f36745z = true;
        View view = this.f36727h;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void setTryResumeVideoView(boolean z10) {
        this.f36717ag = z10;
    }

    /* renamed from: w */
    private void m49184w() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.10

            /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$10$1 */
            public class AnonymousClass1 implements AbstractC7846y.a {
                public AnonymousClass1() {
                }

                @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
                /* renamed from: a */
                public void mo42634a() {
                    PPSInterstitialView.this.f36745z = false;
                    PPSInterstitialView.this.m49131b(false);
                }

                @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
                /* renamed from: a */
                public void mo42635a(boolean z10) {
                    PPSInterstitialView.this.m49158i();
                }
            }

            public RunnableC794210() {
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                if (PPSInterstitialView.this.f36743x != null && PPSInterstitialView.this.f36743x.isShowing()) {
                    PPSInterstitialView.this.f36743x.dismiss();
                }
                AbstractC7185ho.m43820b("PPSInterstitialView", "pop up dialog");
                Resources resources = PPSInterstitialView.this.getResources();
                String string = resources.getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size);
                String string2 = resources.getString(C6849R.string.hiad_reward_close_dialog_continue);
                String string3 = resources.getString(C6849R.string.hiad_reward_close_dialog_close);
                PPSInterstitialView pPSInterstitialView = PPSInterstitialView.this;
                pPSInterstitialView.f36743x = AbstractC7846y.m48620a(pPSInterstitialView.getContext(), "", string, string2, string3, new AbstractC7846y.a() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.10.1
                    public AnonymousClass1() {
                    }

                    @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
                    /* renamed from: a */
                    public void mo42634a() {
                        PPSInterstitialView.this.f36745z = false;
                        PPSInterstitialView.this.m49131b(false);
                    }

                    @Override // com.huawei.openalliance.p169ad.utils.AbstractC7846y.a
                    /* renamed from: a */
                    public void mo42635a(boolean z10) {
                        PPSInterstitialView.this.m49158i();
                    }
                });
                PPSInterstitialView.this.f36743x.setCancelable(false);
            }
        });
    }

    /* renamed from: x */
    private void m49186x() {
        if (C7756bc.m47707b(this.f36721b.m44686E())) {
            this.f36709W = true;
        }
        m49188y();
        this.f36728i.setVisibility(0);
        if (C7756bc.m47709d(this.f36721b.m44686E())) {
            this.f36703Q.m44282c(true);
        } else {
            m49099B();
        }
        this.f36728i.setAppDetailClickListener(new InterfaceC8110c() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.11
            public C794311() {
            }

            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8110c
            /* renamed from: a */
            public void mo38703a(C8109b c8109b) {
                if (c8109b == null || c8109b.m50306e() == null) {
                    AbstractC7185ho.m43823c("PPSInterstitialView", "invalid click");
                    return;
                }
                Integer numM50306e = c8109b.m50306e();
                int iIntValue = numM50306e.intValue();
                AbstractC7185ho.m43821b("PPSInterstitialView", "action: %d", numM50306e);
                if (iIntValue != 0) {
                    return;
                }
                PPSInterstitialView.this.m49122a(c8109b);
            }
        });
        this.f36728i.setNeedPerBeforDownload(true);
        int i10 = this.f36726g;
        if (i10 == 1 || i10 == 3 || i10 == 5) {
            this.f36728i.setLoadAppIconSelf(false);
        }
        this.f36728i.setAdLandingData(this.f36703Q);
        this.f36728i.setInteractedListener(new InterfaceC8106a() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.12
            public C794412() {
            }

            @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8106a
            /* renamed from: a */
            public void mo47419a(int i102) {
                PPSInterstitialView.this.m49138c(Integer.valueOf(i102));
            }
        });
        if (this.f36728i.getVisibility() == 8) {
            this.f36736q.setVisibility(0);
        }
        m49115a(this.f36703Q.getAppInfo());
    }

    /* renamed from: y */
    private void m49188y() {
        if (m49191z() && m49140c(this.f36722c) && m49098A()) {
            this.f36728i = this.f36714ad;
            return;
        }
        this.f36729j = (PPSAppDetailView) findViewById(C6849R.id.interstitial_download_area);
        this.f36730k = (PPSExpandButtonDetailView) findViewById(C6849R.id.interstitial_expand_button_download_area);
        this.f36728i = (m49101D() || this.f36709W) ? this.f36730k : this.f36729j;
        this.f36728i.setBackgroundColor(getResources().getColor(C6849R.color.hiad_90_percent_white));
    }

    @OuterVisible
    public void addInterstitialAdStatusListener(InterfaceC7311a interfaceC7311a) {
        if (interfaceC7311a == null) {
            return;
        }
        this.f36701O = interfaceC7311a;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void bindData(String str) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void destroyView() {
        AbstractC7817dj.m48366a(this.f36702P);
        C7495nc c7495nc = this.f36740u;
        if (c7495nc != null) {
            c7495nc.m45927a((C7301d) null);
        }
        C7331je c7331je = this.f36700N;
        if (c7331je != null) {
            c7331je.m45275b();
        }
        if (this.f36724e != null) {
            setTryResumeVideoView(false);
            if (m49179t()) {
                this.f36724e.m49095f();
            }
            this.f36724e.m49094e();
        }
        CountDownTimer countDownTimer = this.f36705S;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f36705S = null;
        }
        this.f36710a.mo45613b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                this.f36715ae = C7694tp.m47283a(this, motionEvent);
            }
            if (1 == iM47282a) {
                C7694tp.m47284a(this, motionEvent, null, this.f36715ae);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSInterstitialView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public ViewGroup getContentContainer() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    public int getmInsreTemplate() {
        return this.f36726g;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void onAppStatusChanged(String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43817a("PPSInterstitialView", "onAttachedToWindow");
        C7331je c7331je = this.f36700N;
        if (c7331je != null) {
            c7331je.m45301h();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void onBtnClick(Bundle bundle) {
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void onCallBack(String str, Bundle bundle) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f36716af) {
            this.f36716af = false;
            int id2 = view.getId();
            C7730ad.m47436b();
            if (id2 == C6849R.id.interstitial_close) {
                m49158i();
            } else if (id2 == C6849R.id.interstitial_video_view || id2 == C6849R.id.interstitial_image_view || id2 == C6849R.id.interstitial_content_view) {
                m49156h();
            } else {
                AbstractC7185ho.m43826d("PPSInterstitialView", "un handle action");
            }
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.7
                public RunnableC79527() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSInterstitialView.this.f36716af = true;
                }
            }, 500L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("PPSInterstitialView", "onDetechedFromWindow");
        C7331je c7331je = this.f36700N;
        if (c7331je != null) {
            c7331je.m45302i();
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
    public void onMute() {
        this.f36738s = true;
        m49125a(true);
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkConnectedOrChanged(boolean z10) {
        this.f36745z = !z10;
        C7301d c7301d = this.f36721b;
        boolean z11 = c7301d != null && c7301d.m44729ae();
        if (z10 || !m49173q() || m49170o() || !z11) {
            return;
        }
        pauseView();
        m49184w();
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkDisconnected() {
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaCompletion(String str, String str2, int i10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSInterstitialView", "video end");
        }
        if (!this.f36694H) {
            this.f36694H = true;
            m49134c(i10);
            m49160j();
        }
        AbstractC7768bo.m47807a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.9
            public RunnableC79549() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSInterstitialView.this.m49174r();
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaError(String str, String str2, int i10, int i11, int i12) {
        AbstractC7185ho.m43820b("PPSInterstitialView", "onSegmentMediaError");
        TextView textView = this.f36735p;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f36732m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (!C7775bv.m47831e(getContext())) {
            Toast.makeText(getContext().getApplicationContext(), C6849R.string.hiad_network_error, 0).show();
        }
        m49134c(i10);
        InterfaceC7311a interfaceC7311a = this.f36701O;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38578a(i11, i12);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaPause(String str, String str2, int i10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSInterstitialView", "video pause");
        }
        m49134c(i10);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaStart(String str, String str2, int i10) {
        InterfaceC7311a interfaceC7311a;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSInterstitialView", "video start");
        }
        if (this.f36708V) {
            TextView textView = this.f36735p;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.f36708V = false;
        }
        ProgressBar progressBar = this.f36744y;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (!this.f36688B && (interfaceC7311a = this.f36701O) != null) {
            interfaceC7311a.mo38583f();
        }
        this.f36688B = true;
        this.f36687A = i10;
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaStop(String str, String str2, int i10) {
        PPSInterstitialVideoView pPSInterstitialVideoView;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSInterstitialView", "video stop");
        }
        if (!this.f36694H) {
            m49134c(i10);
        }
        if (i10 < this.f36696J || (pPSInterstitialVideoView = this.f36724e) == null) {
            return;
        }
        pPSInterstitialVideoView.m49092c(i10);
        onSegmentMediaCompletion(null, str2, i10);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentProgress(String str, String str2, int i10, int i11) {
        int i12;
        boolean z10 = this.f36688B;
        if (!z10 && this.f36687A < 0) {
            this.f36687A = i11;
            this.f36688B = true;
        } else if (z10 && (i12 = this.f36687A) >= 0) {
            long j10 = i11 - i12;
            this.f36689C = j10;
            C7331je c7331je = this.f36700N;
            if (c7331je != null) {
                m49135c(this.f36691E + j10, c7331je.m45277c());
            }
            C7495nc c7495nc = this.f36740u;
            if (c7495nc != null) {
                c7495nc.m45315a(i11, this.f36696J);
            }
        }
        int i13 = this.f36696J;
        if (i11 > i13 && i13 > 0) {
            i11 = i13;
        }
        int i14 = i11 / 1000;
        if (this.f36704R * 1000 >= i13) {
            this.f36704R = i13 / 1000;
        }
        int i15 = this.f36704R - i14;
        if (i15 > 0) {
            m49109a(i15, false);
        } else {
            ImageView imageView = this.f36732m;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            m49109a(i14, true);
        }
        if (i11 < this.f36696J || i10 >= 100) {
            return;
        }
        this.f36691E += i11 - this.f36687A;
        if (this.f36724e != null) {
            AbstractC7768bo.m47807a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.8
                public RunnableC79538() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSInterstitialView.this.f36724e.m49095f();
                }
            });
        }
        TextView textView = this.f36735p;
        if (textView != null) {
            textView.setVisibility(8);
        }
        AbstractC7185ho.m43820b("PPSInterstitialView", "check end");
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
    public void onUnmute() {
        this.f36738s = false;
        m49125a(false);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        C7331je c7331je = this.f36700N;
        if (c7331je != null) {
            c7331je.m45303j();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void pauseView() {
        AbstractC7185ho.m43820b("PPSInterstitialView", RewardMethods.PAUSE_VIEW);
        setTryResumeVideoView(false);
        PPSInterstitialVideoView pPSInterstitialVideoView = this.f36724e;
        if (pPSInterstitialVideoView != null) {
            pPSInterstitialVideoView.m49093d();
        }
        if (m49179t()) {
            View view = this.f36727h;
            if (view != null) {
                view.setVisibility(0);
            }
            PPSInterstitialVideoView pPSInterstitialVideoView2 = this.f36724e;
            if (pPSInterstitialVideoView2 != null) {
                pPSInterstitialVideoView2.m49080a();
            }
        }
    }

    @OuterVisible
    public void removeInterstitialAdStatusListener() {
        this.f36701O = null;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void resumeVideoView() {
        m49131b(true);
    }

    public void setFullScreen(int i10) {
        this.f36706T = i10;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void setIsNeedRemindData(boolean z10) {
    }

    public void setOnCloseListener(InterfaceC7956b interfaceC7956b) {
        this.f36739t = interfaceC7956b;
    }

    @Override // com.huawei.hms.ads.uiengine.common.IInterstitialView
    public void setProxy(InterstitialApi interstitialApi) {
    }

    public PPSInterstitialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36710a = new C7405lo();
        this.f36738s = true;
        this.f36742w = true;
        this.f36745z = true;
        this.f36687A = -1;
        this.f36688B = false;
        this.f36689C = -1L;
        this.f36690D = -1;
        this.f36691E = 0L;
        this.f36692F = false;
        this.f36693G = false;
        this.f36694H = false;
        this.f36698L = false;
        this.f36699M = false;
        this.f36702P = "interstitial_imp_monitor_" + hashCode();
        this.f36706T = 0;
        this.f36709W = false;
        this.f36716af = true;
        this.f36717ag = false;
        m49112a(context, attributeSet);
    }

    /* renamed from: c */
    private void m49135c(long j10, int i10) {
        C7301d c7301d = this.f36721b;
        if (c7301d == null || this.f36692F || j10 <= c7301d.getMinEffectiveShowTime() || i10 < this.f36721b.getMinEffectiveShowRatio()) {
            return;
        }
        this.f36692F = true;
        m49123a(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null);
    }

    /* renamed from: d */
    private void m49142d() {
        this.f36735p.setMaxWidth((int) (AbstractC7807d.m48203a(getContext(), AbstractC7811dd.m48335k(getContext())) * 0.5d));
    }

    /* renamed from: f */
    private void m49151f() {
        if (C7124fh.m43316b(this.f36707U).mo43392bS() == 0 || !m49191z()) {
            return;
        }
        this.f36734o.setOnClickListener(this);
        PPSAppDetailTemplateView pPSAppDetailTemplateView = this.f36712ab;
        if (pPSAppDetailTemplateView != null) {
            pPSAppDetailTemplateView.setEnabled(false);
        }
    }

    /* renamed from: g */
    private void m49154g() {
        if (m49140c(this.f36722c)) {
            int i10 = this.f36726g;
            if (i10 == 3 || i10 == 4 || i10 == 5) {
                PPSAppDetailTemplateView pPSAppDetailTemplateView = this.f36712ab;
                if (pPSAppDetailTemplateView != null) {
                    pPSAppDetailTemplateView.setVisibility(0);
                    this.f36712ab.setAdLandingData(this.f36703Q);
                }
                if (this.f36713ac != null) {
                    C7301d c7301d = this.f36721b;
                    if (c7301d == null || c7301d.getAppInfo() == null || TextUtils.isEmpty(this.f36721b.getAppInfo().getAppDesc())) {
                        this.f36713ac.setVisibility(4);
                    } else {
                        this.f36713ac.setVisibility(0);
                        this.f36713ac.setText(this.f36721b.getAppInfo().getAppDesc());
                    }
                }
                m49110a(this.f36707U);
                m49100C();
            }
        }
    }

    /* renamed from: h */
    private void m49156h() {
        InterfaceC7311a interfaceC7311a = this.f36701O;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38579b();
        }
        m49138c((Integer) 1);
        m49133b((Integer) null);
    }

    /* renamed from: i */
    public void m49158i() {
        InterfaceC7956b interfaceC7956b = this.f36739t;
        if (interfaceC7956b != null) {
            interfaceC7956b.mo38736b();
        }
        C7495nc c7495nc = this.f36740u;
        if (c7495nc != null) {
            c7495nc.m45930b();
        }
        m49138c((Integer) 3);
        m49193a((Integer) 3);
        InterfaceC7311a interfaceC7311a = this.f36701O;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38581d();
        }
        CountDownTimer countDownTimer = this.f36705S;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f36705S = null;
        }
    }

    /* renamed from: j */
    private void m49160j() {
        TextView textView = this.f36735p;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f36732m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        InterfaceC7311a interfaceC7311a = this.f36701O;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38580c();
        }
    }

    /* renamed from: l */
    private boolean m49164l() {
        if (!m49173q()) {
            return m49167n() || m49166m();
        }
        AbstractC7185ho.m43820b("PPSInterstitialView", "in play");
        return true;
    }

    /* renamed from: m */
    private boolean m49166m() {
        return (AbstractC7558os.m46459G(this.f36721b.getCtrlSwitchs()) || this.f36721b.m44729ae()) ? false : true;
    }

    /* renamed from: o */
    private boolean m49170o() {
        String videoDownloadUrl = this.f36721b.m44698K().getVideoDownloadUrl();
        boolean z10 = (AbstractC7806cz.m48181j(videoDownloadUrl) && TextUtils.isEmpty(this.f36711aa.m41970e(videoDownloadUrl))) ? false : true;
        AbstractC7185ho.m43821b("PPSInterstitialView", "cache %s", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: q */
    private boolean m49173q() {
        return this.f36724e != null && m49179t() && this.f36724e.m49090b();
    }

    /* renamed from: s */
    private void m49177s() {
        if (m49173q()) {
            AbstractC7185ho.m43820b("PPSInterstitialView", "played");
            return;
        }
        View view = this.f36727h;
        if (view != null) {
            view.setVisibility(8);
        }
        PPSInterstitialVideoView pPSInterstitialVideoView = this.f36724e;
        if (pPSInterstitialVideoView != null) {
            pPSInterstitialVideoView.m49089a(true, this.f36738s);
        }
    }

    /* renamed from: t */
    private boolean m49179t() {
        C7301d c7301d = this.f36721b;
        return (c7301d == null || c7301d.m44698K() == null || this.f36721b.getCreativeType() != 9) ? false : true;
    }

    /* renamed from: u */
    public boolean m49181u() {
        C7301d c7301d = this.f36721b;
        return c7301d != null && c7301d.getCreativeType() == 2;
    }

    /* renamed from: v */
    public boolean m49183v() {
        C7301d c7301d = this.f36721b;
        return c7301d != null && c7301d.getCreativeType() == 4;
    }

    /* renamed from: z */
    private boolean m49191z() {
        return this.f36706T != 1 || AbstractC7741ao.m47592n(this.f36707U);
    }

    public PPSInterstitialView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36710a = new C7405lo();
        this.f36738s = true;
        this.f36742w = true;
        this.f36745z = true;
        this.f36687A = -1;
        this.f36688B = false;
        this.f36689C = -1L;
        this.f36690D = -1;
        this.f36691E = 0L;
        this.f36692F = false;
        this.f36693G = false;
        this.f36694H = false;
        this.f36698L = false;
        this.f36699M = false;
        this.f36702P = "interstitial_imp_monitor_" + hashCode();
        this.f36706T = 0;
        this.f36709W = false;
        this.f36716af = true;
        this.f36717ag = false;
        m49112a(context, attributeSet);
    }

    /* renamed from: b */
    private String m49129b(int i10, boolean z10) {
        return (z10 || "1".equals(this.f36721b.getAdSign())) ? getResources().getQuantityString(C6849R.plurals.hiad_reward_countdown, i10, Integer.valueOf(i10)) : getResources().getQuantityString(C6849R.plurals.hiad_interstitial_time_countdown, i10, Integer.valueOf(i10));
    }

    /* renamed from: d */
    private void m49143d(int i10) {
        if (m49179t()) {
            this.f36733n.setVisibility(8);
            return;
        }
        String strM41968c = this.f36711aa.m41968c(this.f36721b.m44727ac());
        if (AbstractC7731ae.m47458b(strM41968c)) {
            C7752az.m47690a(getContext(), strM41968c, new C7752az.a() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.3

                /* renamed from: a */
                final /* synthetic */ int f36757a;

                /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$3$1 */
                public class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Drawable f36759a;

                    public AnonymousClass1(Drawable drawable2) {
                        drawable = drawable2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSInterstitialView.this.f36706T == 1 && !AbstractC7741ao.m47592n(PPSInterstitialView.this.f36707U)) {
                            PPSInterstitialView.this.f36734o.setBackgroundColor(PPSInterstitialView.this.getResources().getColor(C6849R.color.hiad_70_percent_black));
                        }
                        if (drawable instanceof C8101b) {
                            PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                            Drawable drawable2 = drawable;
                            ((C8101b) drawable2).m50248a(PPSInterstitialView.this.new C7955a(drawable2));
                        } else {
                            PPSInterstitialView.this.f36744y.setVisibility(8);
                            PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                            PPSInterstitialView.this.f36698L = true;
                            PPSInterstitialView.this.f36697K = System.currentTimeMillis();
                            PPSInterstitialView.this.m49103F();
                        }
                        PPSInterstitialView pPSInterstitialView = PPSInterstitialView.this;
                        pPSInterstitialView.m49152f(pPSInterstitialView.f36704R * 1000);
                    }
                }

                /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$3$2 */
                public class AnonymousClass2 implements Runnable {
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PPSInterstitialView.this.f36735p.setVisibility(8);
                        PPSInterstitialView.this.f36732m.setVisibility(0);
                        PPSInterstitialView.this.f36733n.setImageResource(i);
                    }
                }

                public C79483(int i102) {
                    i = i102;
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30231a() {
                    AbstractC7185ho.m43826d("PPSInterstitialView", "loadImage fail");
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.3.2
                        public AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            PPSInterstitialView.this.f36735p.setVisibility(8);
                            PPSInterstitialView.this.f36732m.setVisibility(0);
                            PPSInterstitialView.this.f36733n.setImageResource(i);
                        }
                    });
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30232a(Drawable drawable2) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.3.1

                        /* renamed from: a */
                        final /* synthetic */ Drawable f36759a;

                        public AnonymousClass1(Drawable drawable22) {
                            drawable = drawable22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (PPSInterstitialView.this.f36706T == 1 && !AbstractC7741ao.m47592n(PPSInterstitialView.this.f36707U)) {
                                PPSInterstitialView.this.f36734o.setBackgroundColor(PPSInterstitialView.this.getResources().getColor(C6849R.color.hiad_70_percent_black));
                            }
                            if (drawable instanceof C8101b) {
                                PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                                Drawable drawable22 = drawable;
                                ((C8101b) drawable22).m50248a(PPSInterstitialView.this.new C7955a(drawable22));
                            } else {
                                PPSInterstitialView.this.f36744y.setVisibility(8);
                                PPSInterstitialView.this.f36733n.setImageDrawable(drawable);
                                PPSInterstitialView.this.f36698L = true;
                                PPSInterstitialView.this.f36697K = System.currentTimeMillis();
                                PPSInterstitialView.this.m49103F();
                            }
                            PPSInterstitialView pPSInterstitialView = PPSInterstitialView.this;
                            pPSInterstitialView.m49152f(pPSInterstitialView.f36704R * 1000);
                        }
                    });
                }
            });
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.4
                public RunnableC79494() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSInterstitialView.this.f36735p.setVisibility(8);
                    PPSInterstitialView.this.f36732m.setVisibility(0);
                }
            });
        }
    }

    /* renamed from: e */
    private boolean m49148e() {
        int i10 = this.f36726g;
        return (i10 == 3 || i10 == 4 || i10 == 5) ? false : true;
    }

    /* renamed from: f */
    public void m49152f(int i10) {
        this.f36735p.setVisibility(0);
        CountDownTimer countDownTimer = this.f36705S;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimerC79516 countDownTimerC79516 = new CountDownTimer(i10, 500L) { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.6
            public CountDownTimerC79516(long i102, long j11) {
                super(i102, j11);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                PPSInterstitialView.this.f36735p.setVisibility(8);
                PPSInterstitialView.this.f36732m.setVisibility(0);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                int i102 = (int) (j10 / 1000);
                PPSInterstitialView.this.m49109a(i102 + 1, false);
                AbstractC7185ho.m43818a("PPSInterstitialView", "count down time: %d seconds: %d", Long.valueOf(j10), Integer.valueOf(i102));
            }
        };
        this.f36705S = countDownTimerC79516;
        countDownTimerC79516.start();
    }

    public PPSInterstitialView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36710a = new C7405lo();
        this.f36738s = true;
        this.f36742w = true;
        this.f36745z = true;
        this.f36687A = -1;
        this.f36688B = false;
        this.f36689C = -1L;
        this.f36690D = -1;
        this.f36691E = 0L;
        this.f36692F = false;
        this.f36693G = false;
        this.f36694H = false;
        this.f36698L = false;
        this.f36699M = false;
        this.f36702P = "interstitial_imp_monitor_" + hashCode();
        this.f36706T = 0;
        this.f36709W = false;
        this.f36716af = true;
        this.f36717ag = false;
        m49112a(context, attributeSet);
    }

    /* renamed from: d */
    private void m49144d(ContentRecord contentRecord) {
        if (contentRecord == null || contentRecord.m41506b(this.f36707U) == null) {
            return;
        }
        this.f36710a.mo45607a(getContext(), contentRecord, this, true);
        this.f36710a.mo45612a(false);
        this.f36710a.mo45616c();
        m49116a(this.f36710a, contentRecord);
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45279a() {
        this.f36687A = -1;
        this.f36688B = false;
        this.f36691E = 0L;
        if (this.f36698L) {
            m49103F();
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45281b() {
        this.f36692F = false;
        this.f36693G = false;
        long jM47566c = AbstractC7741ao.m47566c();
        AbstractC7185ho.m43818a("PPSInterstitialView", "onViewPhysicalShowStart, currentTime: %s", Long.valueOf(jM47566c));
        String strValueOf = String.valueOf(jM47566c);
        C7301d c7301d = this.f36721b;
        if (c7301d != null) {
            c7301d.m44740g(false);
            this.f36721b.m44612a(false);
        }
        ContentRecord contentRecord = this.f36722c;
        if (contentRecord != null) {
            contentRecord.m41536c(strValueOf);
            this.f36722c.m41560g(jM47566c);
        }
        C7495nc c7495nc = this.f36740u;
        if (c7495nc != null) {
            c7495nc.mo45318a(strValueOf);
            this.f36740u.m45313a(jM47566c);
        }
        PPSInterstitialVideoView pPSInterstitialVideoView = this.f36724e;
        if (pPSInterstitialVideoView != null) {
            pPSInterstitialVideoView.m49088a(strValueOf);
            this.f36724e.m49081a(jM47566c);
        }
        AdLandingPageData adLandingPageData = this.f36703Q;
        if (adLandingPageData != null && this.f36728i != null) {
            adLandingPageData.m44280c(strValueOf);
            this.f36703Q.m44264a(jM47566c);
            this.f36728i.setAdLandingData(this.f36703Q);
        }
        C7495nc c7495nc2 = this.f36740u;
        if (c7495nc2 != null) {
            c7495nc2.m45931c();
        }
        resumeVideoView();
    }

    /* renamed from: c */
    public void m49138c(Integer num) {
        if (this.f36700N != null) {
            m49123a(Long.valueOf(System.currentTimeMillis() - this.f36700N.m45278d()), Integer.valueOf(this.f36700N.m45277c()), num);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
    /* renamed from: a */
    public void mo45566a(int i10) {
        AbstractC7185ho.m43818a("PPSInterstitialView", "onDurationReady %d", Integer.valueOf(i10));
        if (i10 > 0) {
            this.f36696J = i10;
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
    /* renamed from: b */
    public void mo45567b(int i10) {
    }

    /* renamed from: a */
    public void m49109a(int i10, boolean z10) {
        if (this.f36735p == null) {
            return;
        }
        if (z10 && (i10 = m49146e(i10)) == 0) {
            this.f36735p.setVisibility(8);
        }
        this.f36735p.setText(m49129b(i10, z10));
    }

    /* renamed from: c */
    private boolean m49139c() {
        int i10 = this.f36719ai;
        return i10 == C6849R.layout.hiad_interstitial_layout || i10 == C6849R.layout.hiad_interstitial_half_layout || this.f36726g == 5 || C7756bc.m47708c(this.f36722c.m41388C());
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45282b(long j10, int i10) {
        AbstractC7817dj.m48366a(this.f36702P);
        if (!this.f36693G) {
            this.f36693G = true;
            C7495nc c7495nc = this.f36740u;
            if (c7495nc != null) {
                c7495nc.m45924a(j10, i10);
            }
        }
        m49104G();
        pauseView();
    }

    /* renamed from: b */
    private void m49130b(String str) {
        if (!this.f36742w || TextUtils.isEmpty(str)) {
            this.f36731l.setVisibility(8);
        } else {
            this.f36731l.setText(str);
            if (this.f36718ah.getVisibility() == 8) {
                this.f36731l.setVisibility(0);
            }
        }
        if (this.f36742w) {
            return;
        }
        String adChoiceUrl = this.f36721b.getAdChoiceUrl();
        String adChoiceIcon = this.f36721b.getAdChoiceIcon();
        if (!TextUtils.isEmpty(adChoiceUrl)) {
            if (TextUtils.isEmpty(adChoiceIcon)) {
                this.f36741v.m30230b();
            } else {
                this.f36741v.setAdChoiceIcon(adChoiceIcon);
            }
        }
        this.f36741v.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.1
            public ViewOnClickListenerC79411() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSInterstitialView.this.f36721b == null) {
                    AbstractC7185ho.m43823c("PPSInterstitialView", "AdInfo is null or contentData is null");
                } else if (AbstractC7760bg.m47767a(PPSInterstitialView.this.f36721b.getCompliance())) {
                    AbstractC7807d.m48214a(PPSInterstitialView.this.getContext(), PPSInterstitialView.this.f36721b);
                } else {
                    ComplianceActivity.m38595a(PPSInterstitialView.this.getContext(), view, C7563ox.m46653a(PPSInterstitialView.this.f36721b), true);
                }
            }
        });
    }

    /* renamed from: c */
    private boolean m49140c(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return false;
        }
        return C7756bc.m47706a(contentRecord.m41388C());
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45280a(long j10, int i10) {
        C7331je c7331je;
        AbstractC7817dj.m48366a(this.f36702P);
        if (this.f36698L) {
            if ((m49181u() || m49183v()) && (c7331je = this.f36700N) != null) {
                m49135c(j10 - (this.f36697K - c7331je.m45278d()), i10);
            }
        }
    }

    /* renamed from: a */
    private void m49110a(Context context) {
        RelativeLayout.LayoutParams layoutParams;
        View view;
        if (AbstractC7741ao.m47592n(context)) {
            this.f36713ac.setTextSize(1, 21.0f);
            int i10 = this.f36726g;
            if (i10 == 3) {
                this.f36713ac.setVisibility(8);
                layoutParams = (RelativeLayout.LayoutParams) this.f36712ab.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin - ((int) C7818dk.m48367a(context, 14)));
                view = this.f36712ab;
            } else {
                if (i10 == 4) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f36712ab.getLayoutParams();
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin - ((int) C7818dk.m48367a(context, 8)), layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    this.f36712ab.setLayoutParams(layoutParams2);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f36713ac.getLayoutParams();
                    layoutParams3.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
                    this.f36713ac.setLayoutParams(layoutParams3);
                    return;
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f36712ab.getLayoutParams();
                layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, layoutParams4.bottomMargin + ((int) C7818dk.m48367a(context, 2)));
                this.f36712ab.setLayoutParams(layoutParams4);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f36713ac.getLayoutParams();
                layoutParams5.setMargins(layoutParams5.leftMargin, layoutParams5.topMargin, layoutParams5.rightMargin, layoutParams5.bottomMargin);
                this.f36713ac.setLayoutParams(layoutParams5);
                PPSAppDownLoadWithAnimationView pPSAppDownLoadWithAnimationView = this.f36714ad;
                if (pPSAppDownLoadWithAnimationView == null) {
                    return;
                }
                layoutParams = (RelativeLayout.LayoutParams) pPSAppDownLoadWithAnimationView.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + ((int) C7818dk.m48367a(context, 12)), layoutParams.rightMargin, layoutParams.bottomMargin);
                view = this.f36714ad;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: b */
    public void m49131b(boolean z10) {
        AbstractC7185ho.m43821b("PPSInterstitialView", "resume %s", Boolean.valueOf(z10));
        if (m49179t()) {
            if (z10 && this.f36717ag) {
                return;
            }
            this.f36717ag = true;
            PPSInterstitialVideoView pPSInterstitialVideoView = this.f36724e;
            if (pPSInterstitialVideoView != null) {
                pPSInterstitialVideoView.m49091c();
                m49161k();
                if (this.f36738s) {
                    this.f36724e.m49096g();
                } else {
                    this.f36724e.m49097h();
                }
            }
            m49125a(this.f36738s);
        }
    }

    /* renamed from: a */
    private void m49111a(Context context, int i10, int i11, int i12) {
        View.inflate(context, i10, this);
        this.f36719ai = i10;
        ViewGroup viewGroup = (ViewGroup) findViewById(i11);
        this.f36734o = viewGroup;
        viewGroup.setBackgroundColor(getResources().getColor(i12));
    }

    /* renamed from: a */
    private void m49112a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.ViewFullScreen)) != null) {
            try {
                int integer = typedArrayObtainStyledAttributes.getInteger(C6849R.styleable.ViewFullScreen_fullScreen, 0);
                this.f36706T = integer;
                AbstractC7185ho.m43818a("PPSInterstitialView", "mFullScreen %d", Integer.valueOf(integer));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f36707U = context;
        this.f36708V = true;
        this.f36711aa = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        this.f36740u = new C7495nc(context, this);
        this.f36700N = new C7331je(this, this);
    }

    /* renamed from: b */
    private boolean m49133b(Integer num) {
        HashMap map = new HashMap();
        C7301d c7301d = this.f36721b;
        if (c7301d != null) {
            map.put("appId", c7301d.m44696J());
            map.put("thirdId", this.f36721b.m44694I());
        }
        AbstractC7687ti abstractC7687tiM47245a = C7686th.m47245a(getContext(), this.f36722c, map);
        if (!abstractC7687tiM47245a.mo47233a()) {
            return false;
        }
        InterfaceC7311a interfaceC7311a = this.f36701O;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38582e();
        }
        C7495nc c7495nc = this.f36740u;
        if (c7495nc != null) {
            c7495nc.m45928a(abstractC7687tiM47245a, num, this.f36715ae);
            this.f36715ae = null;
        }
        m49193a((Integer) 1);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0227  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m49113a(android.content.Context r8, com.huawei.openalliance.p169ad.p171db.bean.ContentRecord r9) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSInterstitialView.m49113a(android.content.Context, com.huawei.openalliance.ad.db.bean.ContentRecord):void");
    }

    /* renamed from: a */
    private void m49114a(ContentRecord contentRecord) {
        int i10;
        PPSInterstitialVideoView pPSInterstitialVideoView = this.f36724e;
        Resources resources = getResources();
        int i11 = C6849R.color.hiad_black;
        pPSInterstitialVideoView.setVideoBackgroundColor(resources.getColor(i11));
        this.f36724e.setBackgroundColor(getResources().getColor(i11));
        this.f36724e.setVideoScaleMode(1);
        if (!m49140c(contentRecord) || (i10 = this.f36726g) == 1 || i10 == 2 || !(i10 == 3 || i10 == 4 || i10 == 5)) {
            this.f36724e.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        } else {
            this.f36724e.setUnUseDefault(false);
            this.f36724e.setAutoScaleResizeLayoutOnVideoSizeChange(true);
        }
    }

    /* renamed from: a */
    private void m49115a(AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.getIconUrl()) || !m49140c(this.f36722c)) {
            return;
        }
        int i10 = this.f36726g;
        if (i10 == 1 || i10 == 3 || i10 == 5) {
            this.f36728i.m48960a(new ImageView(this.f36707U), appInfo.getIconUrl(), new C7752az.a() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.13

                /* renamed from: com.huawei.openalliance.ad.views.PPSInterstitialView$13$1 */
                public class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Drawable f36752a;

                    /* renamed from: b */
                    final /* synthetic */ Drawable f36753b;

                    public AnonymousClass1(Drawable drawable2, Drawable drawable22) {
                        drawable = drawable2;
                        drawable = drawable22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PPSInterstitialView.this.f36728i.setAppIconImageDrawable(drawable);
                        if (PPSInterstitialView.this.f36712ab != null) {
                            PPSInterstitialView.this.f36712ab.setAppIconImageDrawable(drawable);
                        }
                        if (!(drawable instanceof C8101b) && PPSInterstitialView.this.f36734o != null && drawable != null && PPSInterstitialView.this.f36726g != 3) {
                            PPSInterstitialView.this.f36734o.setBackground(drawable);
                            View viewM48374d = C7818dk.m48374d(PPSInterstitialView.this.f36707U);
                            if (viewM48374d != null) {
                                PPSInterstitialView.this.f36734o.addView(viewM48374d, 0);
                            }
                        }
                        AbstractC7185ho.m43817a("PPSInterstitialView", "get icon suucess");
                    }
                }

                public C794513() {
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30231a() {
                    AbstractC7185ho.m43820b("PPSInterstitialView", "get icon failed");
                }

                @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
                /* renamed from: a */
                public void mo30232a(Drawable drawable2) {
                    if (drawable2 != null) {
                        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialView.13.1

                            /* renamed from: a */
                            final /* synthetic */ Drawable f36752a;

                            /* renamed from: b */
                            final /* synthetic */ Drawable f36753b;

                            public AnonymousClass1(Drawable drawable22, Drawable drawable222) {
                                drawable = drawable22;
                                drawable = drawable222;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                PPSInterstitialView.this.f36728i.setAppIconImageDrawable(drawable);
                                if (PPSInterstitialView.this.f36712ab != null) {
                                    PPSInterstitialView.this.f36712ab.setAppIconImageDrawable(drawable);
                                }
                                if (!(drawable instanceof C8101b) && PPSInterstitialView.this.f36734o != null && drawable != null && PPSInterstitialView.this.f36726g != 3) {
                                    PPSInterstitialView.this.f36734o.setBackground(drawable);
                                    View viewM48374d = C7818dk.m48374d(PPSInterstitialView.this.f36707U);
                                    if (viewM48374d != null) {
                                        PPSInterstitialView.this.f36734o.addView(viewM48374d, 0);
                                    }
                                }
                                AbstractC7185ho.m43817a("PPSInterstitialView", "get icon suucess");
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m49192a(C7301d c7301d, int i10, String str) {
        Resources resources;
        int i11;
        this.f36704R = C7124fh.m43316b(this.f36707U).mo43389bP();
        this.f36721b = c7301d;
        ContentRecord contentRecordM46653a = C7563ox.m46653a(c7301d);
        this.f36722c = contentRecordM46653a;
        this.f36703Q = new AdLandingPageData(contentRecordM46653a, getContext(), true);
        this.f36723d = str;
        this.f36695I = i10;
        m49105H();
        try {
            m49113a(this.f36707U, this.f36722c);
            C7331je c7331je = this.f36700N;
            if (c7331je != null) {
                c7331je.m45276b(this.f36721b.getMinEffectiveShowTime(), this.f36721b.getMinEffectiveShowRatio());
            }
            C7495nc c7495nc = this.f36740u;
            if (c7495nc != null) {
                c7495nc.m45927a(this.f36721b);
            }
            m49186x();
            m49154g();
            m49151f();
            m49102E();
            m49143d(C6849R.drawable.hiad_loading_image);
            m49130b(this.f36721b.getLabel());
            InterfaceC7311a interfaceC7311a = this.f36701O;
            if (interfaceC7311a != null) {
                interfaceC7311a.mo38577a();
            }
            if ((this.f36725f.getVisibility() == 0 || this.f36741v.getVisibility() == 0) && this.f36718ah.getVisibility() == 0) {
                if (this.f36719ai == C6849R.layout.hiad_interstitial_half_layout) {
                    resources = getResources();
                    i11 = C6849R.dimen.haid_interstitial_template_half;
                } else {
                    resources = getResources();
                    i11 = C6849R.dimen.haid_interstitial_template;
                }
                this.f36720aj = resources.getDimensionPixelSize(i11);
                if (AbstractC7811dd.m48315c()) {
                    this.f36720aj = 0;
                }
                this.f36736q.setPadding(0, 0, AbstractC7741ao.m47535a(getContext(), this.f36720aj), 0);
            }
            m49144d(C7563ox.m46653a(c7301d));
            if (C7124fh.m43316b(this.f36707U).mo43391bR() == 1 && this.f36733n != null && m49148e()) {
                ViewGroup.LayoutParams layoutParams = this.f36733n.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f36733n.setLayoutParams(layoutParams);
            }
        } catch (RuntimeException | Exception unused) {
            AbstractC7185ho.m43826d("PPSInterstitialView", "refresh ui error");
        }
    }

    /* renamed from: a */
    private void m49116a(InterfaceC7416lz interfaceC7416lz, ContentRecord contentRecord) {
        if (this.f36724e != null && contentRecord.m41419S() != null) {
            this.f36724e.m49083a(interfaceC7416lz);
        } else {
            if (this.f36733n == null || AbstractC7806cz.m48165b(contentRecord.m41619z())) {
                return;
            }
            interfaceC7416lz.mo45619f();
        }
    }

    /* renamed from: a */
    public void m49122a(C8109b c8109b) {
        AbstractC7185ho.m43821b("PPSInterstitialView", "onClick, isAppRelated: %s, isHandled: %s, destination:%s", Boolean.valueOf(c8109b.m50302a()), Boolean.valueOf(c8109b.m50303b()), c8109b.m50304c());
        InterfaceC7311a interfaceC7311a = this.f36701O;
        if (interfaceC7311a != null) {
            interfaceC7311a.mo38579b();
        }
        m49138c((Integer) 1);
        if (c8109b.m50303b()) {
            m49193a((Integer) 1);
        } else {
            m49133b(c8109b.m50305d());
        }
    }

    /* renamed from: a */
    public void m49193a(Integer num) {
        if (this.f36710a == null || num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 1) {
            this.f36710a.mo45610a(EnumC7480mo.CLICK);
        } else if (iIntValue == 3 && !this.f36694H) {
            this.f36710a.mo45623j();
            this.f36710a.mo45613b();
        }
    }

    /* renamed from: a */
    public void m49123a(Long l10, Integer num, Integer num2) {
        C7301d c7301d = this.f36721b;
        if (c7301d == null) {
            return;
        }
        boolean zM47867a = C7780c.m47867a(c7301d.m44627d(), num2);
        if (!this.f36721b.m44711R() || (zM47867a && !this.f36721b.m44619b())) {
            C7495nc c7495nc = this.f36740u;
            if (c7495nc != null) {
                c7495nc.m45925a(l10.longValue(), num.intValue(), num2);
            }
            if (zM47867a) {
                this.f36721b.m44612a(true);
            }
            if (this.f36721b.m44711R()) {
                return;
            }
            this.f36721b.m44740g(true);
            InterfaceC7416lz interfaceC7416lz = this.f36710a;
            if (interfaceC7416lz != null) {
                interfaceC7416lz.mo45618e();
            }
        }
    }

    /* renamed from: a */
    private void m49124a(String str) {
        if (!this.f36742w || TextUtils.isEmpty(str)) {
            this.f36718ah.setVisibility(8);
            return;
        }
        this.f36718ah.setText(str);
        this.f36731l.setVisibility(8);
        this.f36718ah.setVisibility(0);
    }

    /* renamed from: a */
    private void m49125a(boolean z10) {
        int iM48283a = AbstractC7811dd.m48283a(this.f36726g, z10);
        ImageView imageView = this.f36725f;
        if (imageView != null) {
            imageView.setImageResource(iM48283a);
        }
    }
}
