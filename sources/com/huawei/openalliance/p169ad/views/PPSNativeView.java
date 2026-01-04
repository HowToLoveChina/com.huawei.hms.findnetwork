package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdFeedbackExtraListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.C5063a;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.DislikeAdListener;
import com.huawei.hms.ads.InterfaceC5064b;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.InterfaceC5110e;
import com.huawei.hms.ads.uiengine.common.IMediaStateApiTransfer;
import com.huawei.hms.ads.uiengine.common.MediaStateApi;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.BinderC6977bu;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7012db;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7129fm;
import com.huawei.openalliance.p169ad.C7172hb;
import com.huawei.openalliance.p169ad.C7331je;
import com.huawei.openalliance.p169ad.C7335ji;
import com.huawei.openalliance.p169ad.C7339jm;
import com.huawei.openalliance.p169ad.C7340jn;
import com.huawei.openalliance.p169ad.C7341jo;
import com.huawei.openalliance.p169ad.C7344jr;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7497ne;
import com.huawei.openalliance.p169ad.C7556oq;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.C7665sn;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.EnumC7473mh;
import com.huawei.openalliance.p169ad.EnumC7480mo;
import com.huawei.openalliance.p169ad.InterfaceC7342jp;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7474mi;
import com.huawei.openalliance.p169ad.activity.ComplianceActivity;
import com.huawei.openalliance.p169ad.activity.FeedbackActivity;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.NativeSdkCallbackMethods;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.views.feedback.C8093c;
import com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton;
import com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.INativeWindowImageView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSNativeView extends AbstractC8151u implements C7331je.a, InterfaceC7403lm, IPPSNativeView {

    /* renamed from: A */
    private AdCloseBtnClickListener f36808A;

    /* renamed from: B */
    private String f36809B;

    /* renamed from: C */
    private String f36810C;

    /* renamed from: D */
    private MaterialClickInfo f36811D;

    /* renamed from: E */
    private C5063a.a f36812E;

    /* renamed from: F */
    private InterfaceC7474mi f36813F;

    /* renamed from: G */
    private IRemoteCreator f36814G;

    /* renamed from: H */
    private BinderC6977bu f36815H;

    /* renamed from: I */
    private View f36816I;

    /* renamed from: J */
    private InterfaceC7342jp f36817J;

    /* renamed from: K */
    private AtomicBoolean f36818K;

    /* renamed from: L */
    private C7560ou f36819L;

    /* renamed from: M */
    private ContentRecord f36820M;

    /* renamed from: N */
    private View.OnClickListener f36821N;

    /* renamed from: a */
    protected InterfaceC7416lz f36822a;

    /* renamed from: b */
    private boolean f36823b;

    /* renamed from: c */
    private ChoicesView f36824c;

    /* renamed from: d */
    private int f36825d;

    /* renamed from: e */
    private View f36826e;

    /* renamed from: f */
    private ImageView f36827f;

    /* renamed from: g */
    private C5063a f36828g;

    /* renamed from: h */
    private boolean f36829h;

    /* renamed from: i */
    private boolean f36830i;

    /* renamed from: j */
    private C7497ne f36831j;

    /* renamed from: k */
    private C7331je f36832k;

    /* renamed from: l */
    private C7302e f36833l;

    /* renamed from: m */
    private OnBtnClickListener f36834m;

    /* renamed from: n */
    private OnNativeAdClickListener f36835n;

    /* renamed from: o */
    private OnNativeAdShowListener f36836o;

    /* renamed from: p */
    private OnNativeAdStatusChangedListener f36837p;

    /* renamed from: q */
    private InterfaceC7979b f36838q;

    /* renamed from: r */
    private INativeVideoView f36839r;

    /* renamed from: s */
    private INativeWindowImageView f36840s;

    /* renamed from: t */
    private IAppDownloadButton f36841t;

    /* renamed from: u */
    private List<View> f36842u;

    /* renamed from: v */
    private boolean f36843v;

    /* renamed from: w */
    private final String f36844w;

    /* renamed from: x */
    private boolean f36845x;

    /* renamed from: y */
    private DislikeAdListener f36846y;

    /* renamed from: z */
    private AdFeedbackListener f36847z;

    @OuterVisible
    public interface OnBtnClickListener {
        void onClick();
    }

    @OuterVisible
    public interface OnNativeAdClickListener {
        void onClick(View view);
    }

    @OuterVisible
    public interface OnNativeAdShowListener {
        void onAdShow();
    }

    @OuterVisible
    public interface OnNativeAdStatusChangedListener {
        void onStatusChanged();
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSNativeView$a */
    public static class C7978a implements AdFeedbackListener {

        /* renamed from: a */
        private final WeakReference<PPSNativeView> f36857a;

        public C7978a(PPSNativeView pPSNativeView) {
            this.f36857a = new WeakReference<>(pPSNativeView);
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            PPSNativeView pPSNativeView = this.f36857a.get();
            if (pPSNativeView != null) {
                pPSNativeView.m49343z();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSNativeView$b */
    public interface InterfaceC7979b {
        /* renamed from: a */
        void mo49025a();
    }

    @OuterVisible
    public PPSNativeView(Context context) throws Resources.NotFoundException {
        super(context);
        this.f36822a = new C7405lo();
        this.f36829h = true;
        this.f36830i = true;
        this.f36843v = false;
        this.f36844w = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f36812E = C5063a.a.NONE;
        this.f36818K = new AtomicBoolean();
        this.f36821N = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.m49344a(view, 7);
            }
        };
        m49306a(context);
    }

    /* renamed from: d */
    private void m49321d(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.bringToFront();
    }

    private HashMap<String, String> getBtnText() {
        AppInfo appInfo;
        IAppDownloadButton iAppDownloadButton = this.f36841t;
        if (!(iAppDownloadButton instanceof AppDownloadButton) || (appInfo = ((AppDownloadButton) iAppDownloadButton).getAppInfo()) == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.BF_DOWNLOAD_TXT, appInfo.m44409k());
        map.put(Constants.AF_DOWNLOAD_TXT, appInfo.m44412l());
        return map;
    }

    private MediaStateApi getMediaProxy() {
        if (!(this.f36817J instanceof C7344jr)) {
            return null;
        }
        AbstractC7185ho.m43817a("PPSNativeView", "custMonitor is VideoMzMonitor");
        return new C7339jm((C7344jr) this.f36817J);
    }

    private void getMonitor() {
        boolean z10 = false;
        if (this.f36818K.get() || this.f36833l == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f36818K.get());
            objArr[1] = this.f36833l == null ? "null" : "not null";
            AbstractC7185ho.m43821b("PPSNativeView", "hasRegister %s, nativeAd %s", objArr);
            return;
        }
        AbstractC7185ho.m43820b("PPSNativeView", "getMonitor");
        this.f36818K.set(true);
        ContentRecord contentRecordM46698a = C7570pd.m46698a(this.f36833l);
        this.f36819L.m46575a(contentRecordM46698a.m41505b());
        this.f36819L.mo46590a(contentRecordM46698a);
        Context context = getContext();
        if (!this.f36833l.isVideoAd() && !this.f36833l.m44772P()) {
            z10 = true;
        }
        InterfaceC7342jp interfaceC7342jpM45339a = C7340jn.m45339a(context, z10, this.f36819L, contentRecordM46698a, m49316a(this.f36833l.m44808ad(), this.f36833l.getCreativeType()));
        this.f36817J = interfaceC7342jpM45339a;
        interfaceC7342jpM45339a.mo45352a(this);
        C7340jn.m45343a(contentRecordM46698a.m41588n(), this.f36817J);
        C7560ou c7560ou = this.f36819L;
        if (this.f36817J instanceof C7341jo) {
            c7560ou = null;
        }
        IAppDownloadButton iAppDownloadButton = this.f36841t;
        if (iAppDownloadButton instanceof AppDownloadButton) {
            ((AppDownloadButton) iAppDownloadButton).setMonitorEp(c7560ou);
            ((AppDownloadButton) this.f36841t).setCustMonitor(this.f36817J);
        }
        C7497ne c7497ne = this.f36831j;
        if (c7497ne != null) {
            c7497ne.m45317a(c7560ou);
        }
    }

    private C5063a.a getWhyAdViewStatus() {
        return this.f36812E;
    }

    @OuterVisible
    public static void hideComplain() {
        C7335ji.m45308a().m45309a(NotifyMessageNames.AD_COMPLAIN_MESSAGE_NAME, new Intent(NotifyMessageNames.AD_COMPLAIN_ACTION));
    }

    @OuterVisible
    public static void hideFeedback() {
        C7335ji.m45308a().m45309a(NotifyMessageNames.FEEDBACK_RECEIVE, new Intent("com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY"));
    }

    /* renamed from: j */
    private void m49327j() throws Resources.NotFoundException {
        AbstractC7185ho.m43817a("PPSNativeView", "initChoicesView start");
        if (this.f36824c == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C6849R.layout.hiad_choices_wrapper, (ViewGroup) null);
            this.f36826e = viewInflate;
            this.f36824c = (ChoicesView) viewInflate.findViewById(C6849R.id.hiad_choices_icon);
            this.f36827f = (ImageView) this.f36826e.findViewById(C6849R.id.compliance_icon);
            addView(this.f36826e);
            View view = this.f36826e;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        setChoiceViewPosition(1);
        this.f36824c.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.m49350c()) {
                    return;
                }
                if (PPSNativeView.this.f36833l == null) {
                    AbstractC7185ho.m43820b("PPSNativeView", "adInfo is null");
                } else if (AbstractC7760bg.m47767a(PPSNativeView.this.f36833l.getCompliance())) {
                    AbstractC7807d.m48214a(PPSNativeView.this.getContext(), PPSNativeView.this.f36833l);
                } else {
                    ComplianceActivity.m38595a(PPSNativeView.this.getContext(), view2, C7570pd.m46698a(PPSNativeView.this.f36833l), true);
                }
            }
        });
        this.f36827f.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.f36845x || PPSNativeView.this.f36833l == null) {
                    return;
                }
                ComplianceActivity.m38595a(PPSNativeView.this.getContext(), view2, C7570pd.m46698a(PPSNativeView.this.f36833l), false);
            }
        });
    }

    /* renamed from: k */
    private void m49328k() {
        AbstractC7185ho.m43817a("PPSNativeView", "update choiceView start.");
        if (this.f36824c == null) {
            AbstractC7185ho.m43817a("PPSNativeView", "do not need update choiceView");
            return;
        }
        if (this.f36828g == null) {
            m49329l();
        }
        if (!this.f36845x && this.f36828g != null) {
            AbstractC7185ho.m43817a("PPSNativeView", "cusWhyView is not null, set choiceView as close.");
            this.f36824c.m30228a();
        } else {
            if (TextUtils.isEmpty(this.f36809B)) {
                return;
            }
            AbstractC7185ho.m43817a("PPSNativeView", "update choiceView.");
            if (TextUtils.isEmpty(this.f36810C)) {
                this.f36824c.m30230b();
            } else {
                this.f36824c.setAdChoiceIcon(this.f36810C);
            }
        }
    }

    /* renamed from: l */
    private void m49329l() {
        if (this.f36828g == null || getWhyAdViewStatus() != C5063a.a.INIT) {
            C5063a c5063a = this.f36828g;
            if (c5063a != null) {
                m49309a(c5063a);
                this.f36828g = null;
            }
            setWhyAdViewStatus(C5063a.a.INIT);
            C5063a c5063a2 = new C5063a(getContext(), this);
            this.f36828g = c5063a2;
            addView(c5063a2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f36828g.getLayoutParams());
            layoutParams.addRule(13);
            this.f36828g.setLayoutParams(layoutParams);
        }
        this.f36828g.setOnCloseCallBack(new InterfaceC5064b() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.3
            @Override // com.huawei.hms.ads.InterfaceC5064b
            /* renamed from: a */
            public void mo30240a() {
                PPSNativeView.this.m49330m();
            }

            @Override // com.huawei.hms.ads.InterfaceC5064b
            /* renamed from: b */
            public void mo30242b() {
                if (PPSNativeView.this.f36833l != null) {
                    AbstractC7807d.m48214a(PPSNativeView.this.getContext(), PPSNativeView.this.f36833l);
                } else {
                    AbstractC7185ho.m43823c("PPSNativeView", "processWhyThisAdEvent nativaAd is null");
                }
            }

            @Override // com.huawei.hms.ads.InterfaceC5064b
            /* renamed from: c */
            public List<String> mo30243c() {
                if (PPSNativeView.this.f36833l != null) {
                    return PPSNativeView.this.f36833l.getAdCloseKeyWords();
                }
                AbstractC7185ho.m43823c("PPSNativeView", "getKeyWords nativaAd is null");
                return null;
            }

            @Override // com.huawei.hms.ads.InterfaceC5064b
            /* renamed from: a */
            public void mo30241a(String str) {
                PPSNativeView.this.m49330m();
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSNativeView.this.setWhyAdViewStatus(C5063a.a.DISLIKED);
                PPSNativeView.this.onClose(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m49330m() {
        C5063a c5063a = this.f36828g;
        if (c5063a != null) {
            ViewGroup viewGroup = (ViewGroup) c5063a.getParent();
            if (viewGroup != null) {
                m49318b(viewGroup, 4);
            }
            this.f36828g.setVisibility(0);
            setViewBackgroundColor(getResources().getColor(C6849R.color.hiad_whythisad_root_bg));
        }
    }

    /* renamed from: n */
    private boolean m49331n() {
        if (!m49316a(this.f36833l.m44808ad(), this.f36833l.getCreativeType())) {
            return false;
        }
        Context applicationContext = getContext().getApplicationContext();
        m49308a(applicationContext, AdContentData.m39272a(applicationContext, this.f36833l));
        return true;
    }

    /* renamed from: o */
    private void m49332o() throws Resources.NotFoundException {
        m49305a(this.f36825d);
        m49321d(this.f36824c);
        if (this.f36829h || !m49333p()) {
            return;
        }
        setWhyAdViewStatus(C5063a.a.NONE);
        this.f36830i = true;
        m49318b(this, 0);
    }

    /* renamed from: p */
    private boolean m49333p() {
        return getWhyAdViewStatus() != C5063a.a.NONE && getWhyAdViewStatus() == C5063a.a.INIT;
    }

    /* renamed from: q */
    private void m49334q() {
        InterfaceC7342jp interfaceC7342jp = this.f36817J;
        if (interfaceC7342jp != null) {
            IAppDownloadButton iAppDownloadButton = this.f36841t;
            if (iAppDownloadButton instanceof AppDownloadButton) {
                ((AppDownloadButton) iAppDownloadButton).setMonitorEp(interfaceC7342jp instanceof C7341jo ? null : this.f36819L);
                ((AppDownloadButton) this.f36841t).setCustMonitor(this.f36817J);
                return;
            }
        }
        AbstractC7185ho.m43820b("PPSNativeView", "setDownBtnMonitorEp, not register monitor or appDownloadButton invalid");
    }

    /* renamed from: r */
    private void m49335r() {
        View view;
        IRemoteCreator iRemoteCreator = this.f36814G;
        if (iRemoteCreator != null && (view = this.f36816I) != null) {
            try {
                iRemoteCreator.destroyView(ObjectWrapper.wrap(view));
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("PPSNativeView", "destory remote view err: %s", th2.getClass().getSimpleName());
            }
        }
        if (this.f36833l != null) {
            C7012db.m41242a().m41247b(this.f36833l.getUniqueId());
        }
        this.f36814G = null;
        this.f36816I = null;
        BinderC6977bu binderC6977bu = this.f36815H;
        if (binderC6977bu != null) {
            binderC6977bu.m41098f();
            this.f36815H = null;
        }
    }

    /* renamed from: s */
    private void m49336s() {
        this.f36832k.m45275b();
        C7172hb.m43677a(getContext()).m43682b();
        INativeVideoView iNativeVideoView = this.f36839r;
        if (iNativeVideoView != null) {
            iNativeVideoView.setPpsNativeView(null);
        }
        this.f36839r = null;
        this.f36840s = null;
        this.f36846y = null;
        this.f36847z = null;
        m49339v();
        m49335r();
    }

    private void setNativeVideoViewClickable(INativeVideoView iNativeVideoView) {
        if (iNativeVideoView instanceof NativeVideoView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeVideoView) iNativeVideoView);
            m49314a(arrayList);
        }
    }

    private void setViewBackgroundColor(int i10) {
        setBackgroundColor(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhyAdViewStatus(C5063a.a aVar) {
        this.f36812E = aVar;
    }

    private void setWindowImageViewClickable(INativeWindowImageView iNativeWindowImageView) {
        if (iNativeWindowImageView instanceof NativeWindowImageView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeWindowImageView) iNativeWindowImageView);
            m49314a(arrayList);
        }
    }

    /* renamed from: t */
    private boolean m49337t() {
        C7302e c7302e;
        return (this.f36816I == null || (c7302e = this.f36833l) == null || (c7302e.m44808ad() != null && 3 == this.f36833l.m44808ad().intValue())) ? false : true;
    }

    /* renamed from: u */
    private void m49338u() {
        C7302e c7302e;
        if (!mo49351d() || (c7302e = this.f36833l) == null || c7302e.m44814aj()) {
            return;
        }
        AbstractC7185ho.m43820b("PPSNativeView", " maybe report show start.");
        mo45281b();
    }

    /* renamed from: v */
    private void m49339v() {
        List<View> list = this.f36842u;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.f36842u) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    /* renamed from: w */
    private void m49340w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.f36842u = arrayList;
        m49314a(arrayList);
    }

    /* renamed from: x */
    private void m49341x() {
        m49342y();
        mo49347a((Integer) 3);
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45623j();
            this.f36822a.mo45613b();
        }
        INativeVideoView iNativeVideoView = this.f36839r;
        if (iNativeVideoView != null) {
            iNativeVideoView.stop();
        }
        DislikeAdListener dislikeAdListener = this.f36846y;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        InterfaceC7342jp interfaceC7342jp = this.f36817J;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45354b();
        }
        m49336s();
    }

    /* renamed from: y */
    private void m49342y() {
        if (this.f36841t != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.9
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.f36841t.cancel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m49343z() {
        m49342y();
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45623j();
            this.f36822a.mo45613b();
        }
        INativeVideoView iNativeVideoView = this.f36839r;
        if (iNativeVideoView != null) {
            iNativeVideoView.stop();
        }
        DislikeAdListener dislikeAdListener = this.f36846y;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        m49336s();
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45281b() {
        this.f36843v = false;
        long jM47566c = AbstractC7741ao.m47566c();
        AbstractC7185ho.m43818a("PPSNativeView", "onViewPhysicalShowStart: %s", Long.valueOf(jM47566c));
        String strValueOf = String.valueOf(jM47566c);
        C7302e c7302e = this.f36833l;
        if (c7302e == null) {
            AbstractC7185ho.m43820b("PPSNativeView", "nativeAd is null! please register first");
            return;
        }
        c7302e.m44642h(strValueOf);
        if (!this.f36833l.isVideoAd() || this.f36833l.m44659q() == null || this.f36833l.m44659q().intValue() == 0) {
            this.f36833l.m44842h(false);
            this.f36833l.m44612a(false);
        }
        this.f36833l.m44847j(true);
        this.f36833l.m44622c(jM47566c);
        if (!this.f36833l.m44784V()) {
            this.f36833l.m44840g(true);
            if (this.f36837p != null) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSNativeView.this.f36837p != null) {
                            PPSNativeView.this.f36837p.onStatusChanged();
                        }
                    }
                });
            }
        }
        this.f36831j.mo45318a(strValueOf);
        this.f36831j.m45313a(jM47566c);
        INativeVideoView iNativeVideoView = this.f36839r;
        if (iNativeVideoView != null) {
            iNativeVideoView.updateContent(strValueOf);
            this.f36839r.updateStartShowTime(jM47566c);
        }
        IAppDownloadButton iAppDownloadButton = this.f36841t;
        if (iAppDownloadButton != null) {
            iAppDownloadButton.updateContent(strValueOf);
            this.f36841t.updateStartShowTime(jM47566c);
        }
        BinderC6977bu binderC6977bu = this.f36815H;
        if (binderC6977bu != null) {
            binderC6977bu.m41096a(strValueOf);
            this.f36815H.m41095a(jM47566c);
        }
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45619f();
        }
        this.f36831j.m45947a();
        BinderC6977bu binderC6977bu2 = this.f36815H;
        if (binderC6977bu2 != null) {
            binderC6977bu2.m41097a(NativeSdkCallbackMethods.ATTACH_TO_WINDOW, (Bundle) null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView
    /* renamed from: c */
    public void mo49349c(View view) {
        OnNativeAdClickListener onNativeAdClickListener = this.f36835n;
        if (onNativeAdClickListener != null) {
            onNativeAdClickListener.onClick(view);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8151u, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                MaterialClickInfo materialClickInfoM47283a = C7694tp.m47283a(this, motionEvent);
                this.f36811D = materialClickInfoM47283a;
                IAppDownloadButton iAppDownloadButton = this.f36841t;
                if (iAppDownloadButton != null) {
                    ((AppDownloadButton) iAppDownloadButton).m48702a(materialClickInfoM47283a);
                }
            }
            if (1 == iM47282a) {
                C7694tp.m47284a(this, motionEvent, null, this.f36811D);
                IAppDownloadButton iAppDownloadButton2 = this.f36841t;
                if (iAppDownloadButton2 != null) {
                    ((AppDownloadButton) iAppDownloadButton2).m48702a(this.f36811D);
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @OuterVisible
    public void focusPlay() {
        try {
            InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
            View view = this.f36816I;
            if (view == null || interfaceC5110eM42838b == null) {
                return;
            }
            interfaceC5110eM42838b.mo30528c(ObjectWrapper.wrap(view), null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "focusPlay err: %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public void focusStop() {
        try {
            InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
            View view = this.f36816I;
            if (view == null || interfaceC5110eM42838b == null) {
                return;
            }
            interfaceC5110eM42838b.mo30529d(ObjectWrapper.wrap(view), null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "focusStop err: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8113f
    public IAd getAd() {
        return getNativeAd();
    }

    public InterfaceC7474mi getAdSessionAgent() {
        return this.f36813F;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView
    public String getAdTag() {
        if (!m49337t() || this.f36833l.m44809ae() == null) {
            return null;
        }
        return this.f36833l.m44809ae().m40014a();
    }

    public MaterialClickInfo getClickInfo() {
        return this.f36811D;
    }

    @OuterVisible
    public View getFeedBackView() {
        try {
            InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
            View view = this.f36816I;
            if (view == null || interfaceC5110eM42838b == null) {
                return null;
            }
            return (View) ObjectWrapper.unwrap(interfaceC5110eM42838b.mo30520a(ObjectWrapper.wrap(view)));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "get anchor view err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    public C7302e getNativeAd() {
        return this.f36833l;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8151u
    public String getTAG() {
        return "PPSNativeView_" + hashCode();
    }

    @OuterVisible
    public void gotoWhyThisAdPage() {
        if (this.f36833l != null) {
            AbstractC7807d.m48214a(getContext(), this.f36833l);
        } else {
            AbstractC7185ho.m43823c("PPSNativeView", "gotoWhyThisAdPage nativeAd is null");
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView
    /* renamed from: h */
    public void mo49355h() {
        if (this.f36834m != null) {
            AbstractC7185ho.m43820b("PPSNativeView", "notifyBtnClick");
            this.f36834m.onClick();
        }
    }

    @OuterVisible
    public void hideAdvertiserInfoDialog() {
        hideFeedback();
    }

    @OuterVisible
    public void hideTransparencyDialog() {
        hideFeedback();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f36823b = true;
        C7331je c7331je = this.f36832k;
        if (c7331je != null) {
            c7331je.m45301h();
        }
        C7302e c7302e = this.f36833l;
        if (c7302e != null) {
            m49346a(c7302e);
        }
        if (this.f36820M != null) {
            m50516i();
        }
        C7556oq.m46397a(getContext()).m46409b(getContext());
    }

    @OuterVisible
    public void onClose() {
        AbstractC7185ho.m43820b("PPSNativeView", "onClose");
        onClose(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f36823b = false;
        AbstractC7185ho.m43820b("PPSNativeView", "onDetechedFromWindow");
        C7331je c7331je = this.f36832k;
        if (c7331je != null) {
            c7331je.m45302i();
        }
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45613b();
        }
    }

    @OuterVisible
    public void onFeedback(int i10, List<FeedbackInfo> list) {
        AbstractC7185ho.m43821b("PPSNativeView", "onFeedback, type: %s", Integer.valueOf(i10));
        if (1 == i10 || 3 == i10) {
            this.f36831j.m45956b(list);
            m49341x();
        } else if (i10 == 2) {
            this.f36831j.m45958c(list);
        }
    }

    @OuterVisible
    public void onViewUpdate() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("PPSNativeView", "manual updateView");
        }
        this.f36832k.onGlobalLayout();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        C7331je c7331je = this.f36832k;
        if (c7331je != null) {
            c7331je.m45303j();
        }
    }

    @OuterVisible
    public void pause() {
        try {
            InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
            View view = this.f36816I;
            if (view == null || interfaceC5110eM42838b == null) {
                return;
            }
            interfaceC5110eM42838b.mo30523a(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "pauseVideo err: %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public void register(INativeAd iNativeAd) throws Resources.NotFoundException {
        if (iNativeAd == null) {
            return;
        }
        this.f36833l = (C7302e) iNativeAd;
        getMonitor();
        m49332o();
        if (!m49331n()) {
            this.f36809B = iNativeAd.getAdChoiceUrl();
            this.f36810C = iNativeAd.getAdChoiceIcon();
            m49328k();
        }
        this.f36832k.m45276b(this.f36833l.getMinEffectiveShowTime(), this.f36833l.getMinEffectiveShowRatio());
        this.f36831j.m45950a(this.f36833l);
        m49338u();
        this.f36831j.m45954b();
        m49340w();
        m49346a(iNativeAd);
        ContentRecord contentRecordM46698a = C7570pd.m46698a(this.f36833l);
        this.f36820M = contentRecordM46698a;
        super.setAdData(contentRecordM46698a);
        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.4
            @Override // java.lang.Runnable
            public void run() {
                if (PPSNativeView.this.f36823b) {
                    PPSNativeView.this.m50516i();
                }
            }
        }, 100L);
    }

    @OuterVisible
    public void resume() {
        try {
            InterfaceC5110e interfaceC5110eM42838b = C7084e.m42838b();
            View view = this.f36816I;
            if (view == null || interfaceC5110eM42838b == null) {
                return;
            }
            interfaceC5110eM42838b.mo30527b(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "resumeVideo err: %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public void setAdCloseBtnClickListener(AdCloseBtnClickListener adCloseBtnClickListener) {
        this.f36808A = adCloseBtnClickListener;
    }

    public void setAdContainerSizeMatched(String str) {
        this.f36831j.m45955b(str);
    }

    @OuterVisible
    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        AbstractC7185ho.m43821b("PPSNativeView", "setAdFeedbackListener is extra: %s", Boolean.valueOf(adFeedbackListener instanceof AdFeedbackExtraListener));
        this.f36847z = adFeedbackListener;
    }

    @OuterVisible
    public void setChoiceViewPosition(int i10) throws Resources.NotFoundException {
        AbstractC7185ho.m43818a("PPSNativeView", "setChoiceViewPosition option = %d", Integer.valueOf(i10));
        if (this.f36833l == null) {
            this.f36825d = i10;
        } else {
            m49305a(i10);
        }
    }

    @OuterVisible
    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        if (this.f36829h) {
            AbstractC7185ho.m43823c("PPSNativeView", "china rom should not call setChoiceViewPosition method");
        } else {
            this.f36846y = dislikeAdListener;
        }
    }

    @OuterVisible
    public void setIsCustomDislikeThisAdEnabled(boolean z10) {
        AbstractC7185ho.m43817a("PPSNativeView", "isCustomDislikeThisAdEnabled = " + z10);
        if (this.f36829h) {
            AbstractC7185ho.m43823c("PPSNativeView", "china rom should not call this method and isCustomDislikeThisAdEnabled = " + z10);
            return;
        }
        this.f36845x = z10;
        if (z10) {
            AbstractC7185ho.m43817a("PPSNativeView", "dont like default feedback!");
            return;
        }
        AbstractC7185ho.m43817a("PPSNativeView", "like default feedback!");
        ChoicesView choicesView = this.f36824c;
        if (choicesView != null) {
            choicesView.m30228a();
        }
    }

    public void setMaterialClickInfo(MaterialClickInfo materialClickInfo) {
        this.f36811D = materialClickInfo;
    }

    public void setMetaData(String str) {
        this.f36831j.m45957c(str);
    }

    @OuterVisible
    public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
        this.f36834m = onBtnClickListener;
    }

    @OuterVisible
    public void setOnNativeAdClickListener(OnNativeAdClickListener onNativeAdClickListener) {
        this.f36835n = onNativeAdClickListener;
    }

    public void setOnNativeAdImpressionListener(InterfaceC7979b interfaceC7979b) {
        this.f36838q = interfaceC7979b;
    }

    @OuterVisible
    public void setOnNativeAdShowListener(OnNativeAdShowListener onNativeAdShowListener) {
        this.f36836o = onNativeAdShowListener;
    }

    @OuterVisible
    public void setOnNativeAdStatusChangedListener(OnNativeAdStatusChangedListener onNativeAdStatusChangedListener) {
        this.f36837p = onNativeAdStatusChangedListener;
    }

    @OuterVisible
    public void setVideoAutoPlayNet(int i10) {
        C7124fh.m43316b(getContext().getApplicationContext()).mo43472l(i10);
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        this.f36831j.m45949a(videoInfo);
    }

    @OuterVisible
    public void showAdvertiserInfoDialog(View view, boolean z10) {
        if (view == null) {
            AbstractC7185ho.m43823c("PPSNativeView", "anchorView is null");
        }
        try {
            C7302e c7302e = this.f36833l;
            if (c7302e == null) {
                AbstractC7185ho.m43823c("PPSNativeView", "adInfo is null");
                return;
            }
            ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
            if (AbstractC7760bg.m47767a(contentRecordM46698a.m41468aT())) {
                AbstractC7185ho.m43823c("PPSNativeView", "advertiser Info is null");
            } else {
                ComplianceActivity.m38595a(getContext(), view, contentRecordM46698a, z10);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "showAdvertiserInfoDialog has exception %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public void showFeedback(View view) {
        m49307a((Context) null, view);
    }

    @OuterVisible
    public void showTransparencyDialog(View view) {
        showTransparencyDialog(view, null);
    }

    @OuterVisible
    public void unregister() {
        m49336s();
        C7172hb.m43677a(getContext()).m43682b();
        if (!this.f36829h) {
            m49309a(this.f36826e);
            this.f36826e = null;
            this.f36824c = null;
            m49309a(this.f36828g);
            this.f36828g = null;
        }
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45613b();
        }
        InterfaceC7342jp interfaceC7342jp = this.f36817J;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45354b();
        }
    }

    @OuterVisible
    public PPSNativeView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.f36822a = new C7405lo();
        this.f36829h = true;
        this.f36830i = true;
        this.f36843v = false;
        this.f36844w = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f36812E = C5063a.a.NONE;
        this.f36818K = new AtomicBoolean();
        this.f36821N = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.m49344a(view, 7);
            }
        };
        m49306a(context);
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45279a() {
        C7302e c7302e = this.f36833l;
        if (c7302e != null) {
            AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.5
                @Override // java.lang.Runnable
                public void run() {
                    C7302e c7302e2 = PPSNativeView.this.f36833l;
                    if (c7302e2 != null) {
                        if (!c7302e2.isVideoAd() || c7302e2.m44659q() == null || c7302e2.m44659q().intValue() == 0) {
                            PPSNativeView.this.m49313a(Long.valueOf(c7302e2.getMinEffectiveShowTime()), Integer.valueOf(PPSNativeView.this.f36832k.m45277c()), (Integer) null);
                        }
                    }
                }
            }, this.f36844w, c7302e.getMinEffectiveShowTime());
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45282b(long j10, int i10) {
        int playedTime;
        int playedProgress;
        int i11;
        int i12;
        Object obj;
        AbstractC7817dj.m48366a(this.f36844w);
        C7302e c7302e = this.f36833l;
        if (c7302e == null) {
            return;
        }
        c7302e.m44847j(false);
        if (this.f36833l.isVideoAd() && (obj = this.f36839r) != null && (obj instanceof NativeMediaView)) {
            NativeMediaView nativeMediaView = (NativeMediaView) obj;
            playedTime = nativeMediaView.getPlayedTime();
            playedProgress = nativeMediaView.getPlayedProgress();
        } else {
            playedTime = -1;
            playedProgress = -1;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSNativeView", "onAdPhyShow  duration: %s  maxShowRatio: %s  playedTime: %s  playedProgress: %s", Long.valueOf(j10), Integer.valueOf(i10), Integer.valueOf(playedTime), Integer.valueOf(playedProgress));
        }
        if (!this.f36833l.isVideoAd()) {
            this.f36831j.m45948a(j10, i10);
            return;
        }
        if (playedTime <= 0) {
            i12 = 0;
            i11 = 0;
        } else {
            i11 = playedProgress;
            i12 = playedTime;
        }
        this.f36831j.m45314a(j10, i10, i12, i11);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8113f
    /* renamed from: d */
    public boolean mo49351d() {
        C7331je c7331je = this.f36832k;
        if (c7331je != null) {
            return c7331je.m45307n();
        }
        return false;
    }

    /* renamed from: e */
    public void m49352e() {
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45613b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView
    /* renamed from: f */
    public void mo49353f() {
        InterfaceC7416lz interfaceC7416lz = this.f36822a;
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45610a(EnumC7480mo.CLICK);
        }
    }

    /* renamed from: g */
    public void m49354g() {
        AdCloseBtnClickListener adCloseBtnClickListener = this.f36808A;
        if (adCloseBtnClickListener != null) {
            adCloseBtnClickListener.onCloseBtnClick();
        }
    }

    @OuterVisible
    public void onClose(List<String> list) {
        AbstractC7185ho.m43820b("PPSNativeView", "onClose with keyWords");
        this.f36831j.m45952a(list);
        m49341x();
    }

    @OuterVisible
    public void register(INativeAd iNativeAd, INativeVideoView iNativeVideoView) throws Resources.NotFoundException {
        register(iNativeAd);
        this.f36839r = iNativeVideoView;
        if (iNativeVideoView != null) {
            iNativeVideoView.setPpsNativeView(this);
            iNativeVideoView.setNativeAd(iNativeAd);
            setNativeVideoViewClickable(iNativeVideoView);
            InterfaceC7342jp interfaceC7342jp = this.f36817J;
            if (interfaceC7342jp != null) {
                interfaceC7342jp.mo45353a(iNativeVideoView.getVideoView());
            }
        }
        m49340w();
    }

    @OuterVisible
    public void showTransparencyDialog(View view, int[] iArr) {
        if (view == null) {
            AbstractC7185ho.m43823c("PPSNativeView", "anchorView is null");
        }
        try {
            C7302e c7302e = this.f36833l;
            if (c7302e == null) {
                AbstractC7185ho.m43823c("PPSNativeView", "adInfo is null");
                return;
            }
            ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
            if (m49317a(iArr)) {
                C6980bx.m41133a(getContext(), view, iArr, contentRecordM46698a);
            } else {
                C6980bx.m41131a(getContext(), view, contentRecordM46698a);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "showTransparencyDialog has exception %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public void unregister(IAppDownloadButton iAppDownloadButton) {
        IAppDownloadButton iAppDownloadButton2;
        if (iAppDownloadButton == null || iAppDownloadButton != (iAppDownloadButton2 = this.f36841t)) {
            return;
        }
        iAppDownloadButton2.setPpsNativeView(null);
        this.f36841t.setNativeAd(null);
        this.f36841t = null;
    }

    @OuterVisible
    public PPSNativeView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f36822a = new C7405lo();
        this.f36829h = true;
        this.f36830i = true;
        this.f36843v = false;
        this.f36844w = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f36812E = C5063a.a.NONE;
        this.f36818K = new AtomicBoolean();
        this.f36821N = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.m49344a(view, 7);
            }
        };
        m49306a(context);
    }

    /* renamed from: a */
    private void m49305a(int i10) throws Resources.NotFoundException {
        C7302e c7302e;
        AbstractC7185ho.m43818a("PPSNativeView", "changeChoiceViewPosition option = %d", Integer.valueOf(i10));
        if (this.f36829h) {
            AbstractC7185ho.m43823c("PPSNativeView", "china rom should not call setChoiceViewPosition method");
            return;
        }
        if (this.f36826e == null) {
            AbstractC7185ho.m43817a("PPSNativeView", "choicesView is null, error");
            return;
        }
        if (!this.f36845x && this.f36827f != null && (c7302e = this.f36833l) != null && !AbstractC7760bg.m47767a(c7302e.getCompliance())) {
            this.f36827f.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f36826e.getLayoutParams());
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(C6849R.dimen.hiad_10_dp);
        if (i10 != 0) {
            if (i10 == 2) {
                layoutParams.addRule(12);
            } else if (i10 == 3) {
                layoutParams.addRule(12);
            } else {
                if (i10 == 4) {
                    if (this.f36845x) {
                        AbstractC7185ho.m43817a("PPSNativeView", "ADCHOICES_INVISIBLE is called and not default feedback!");
                        m49318b(this.f36826e, 8);
                        return;
                    }
                    this.f36826e.setVisibility(0);
                    this.f36826e.setLayoutParams(layoutParams);
                    this.f36826e.bringToFront();
                }
                layoutParams.addRule(10);
            }
            layoutParams.addRule(21);
            layoutParams.setMargins(0, 0, dimensionPixelOffset, 0);
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.f36826e.setVisibility(0);
            this.f36826e.setLayoutParams(layoutParams);
            this.f36826e.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, 0, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.f36826e.setScaleX(-1.0f);
        this.f36824c.setScaleX(-1.0f);
        this.f36826e.setVisibility(0);
        this.f36826e.setLayoutParams(layoutParams);
        this.f36826e.bringToFront();
    }

    /* renamed from: b */
    public void m49348b(View view) {
        m49307a(getContext(), view);
    }

    /* renamed from: c */
    public boolean m49350c() {
        if (this.f36845x || this.f36828g == null) {
            return false;
        }
        setWhyAdViewStatus(C5063a.a.SHOWN);
        m49330m();
        this.f36828g.m30236b();
        m49339v();
        this.f36830i = false;
        return true;
    }

    @OuterVisible
    public void register(INativeAd iNativeAd, INativeWindowImageView iNativeWindowImageView) throws Resources.NotFoundException {
        register(iNativeAd);
        this.f36840s = iNativeWindowImageView;
        if (iNativeWindowImageView != null) {
            iNativeWindowImageView.setNativeAd(iNativeAd);
            setWindowImageViewClickable(this.f36840s);
        }
        m49340w();
    }

    @OuterVisible
    @TargetApi(21)
    public PPSNativeView(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        this.f36822a = new C7405lo();
        this.f36829h = true;
        this.f36830i = true;
        this.f36843v = false;
        this.f36844w = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f36812E = C5063a.a.NONE;
        this.f36818K = new AtomicBoolean();
        this.f36821N = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.m49344a(view, 7);
            }
        };
        m49306a(context);
    }

    /* renamed from: b */
    private void m49318b(View view, int i10) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                viewGroup.getChildAt(i11).setVisibility(i10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45280a(long j10, int i10) {
        AbstractC7817dj.m48366a(this.f36844w);
        if (!this.f36832k.m45274a(j10) || this.f36843v) {
            return;
        }
        this.f36843v = true;
        C7302e c7302e = this.f36833l;
        if (c7302e != null) {
            if (!c7302e.isVideoAd() || this.f36833l.m44659q() == null || this.f36833l.m44659q().intValue() == 0) {
                m49313a(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null);
            }
        }
    }

    @OuterVisible
    public void register(INativeAd iNativeAd, List<View> list) throws Resources.NotFoundException {
        if (iNativeAd == null) {
            return;
        }
        this.f36833l = (C7302e) iNativeAd;
        getMonitor();
        m49332o();
        if (!m49331n()) {
            this.f36809B = iNativeAd.getAdChoiceUrl();
            this.f36810C = iNativeAd.getAdChoiceIcon();
            m49328k();
        }
        this.f36832k.m45276b(this.f36833l.getMinEffectiveShowTime(), this.f36833l.getMinEffectiveShowRatio());
        this.f36831j.m45950a(this.f36833l);
        m49338u();
        this.f36831j.m45954b();
        this.f36842u = list;
        m49314a(list);
        m49346a(iNativeAd);
    }

    /* renamed from: a */
    private void m49306a(Context context) throws Resources.NotFoundException {
        this.f36831j = new C7497ne(context, this);
        this.f36832k = new C7331je(this, this);
        this.f36829h = C6982bz.m41148a(context).mo41175d();
        this.f36819L = new C7560ou(context, new C7665sn(context, 3));
        AbstractC7185ho.m43818a("PPSNativeView", "isChinaRom = %s", Boolean.valueOf(this.f36829h));
        if (this.f36829h) {
            return;
        }
        m49327j();
    }

    @OuterVisible
    public void register(INativeAd iNativeAd, List<View> list, INativeVideoView iNativeVideoView) throws Resources.NotFoundException {
        register(iNativeAd);
        this.f36839r = iNativeVideoView;
        if (iNativeVideoView != null) {
            iNativeVideoView.setPpsNativeView(this);
            iNativeVideoView.setNativeAd(iNativeAd);
            setNativeVideoViewClickable(iNativeVideoView);
            InterfaceC7342jp interfaceC7342jp = this.f36817J;
            if (interfaceC7342jp != null) {
                interfaceC7342jp.mo45353a(iNativeVideoView.getVideoView());
            }
        }
        this.f36842u = list;
        m49314a(list);
    }

    /* renamed from: a */
    private void m49307a(Context context, View view) {
        C8093c c8093c = new C8093c();
        c8093c.m50144a(context);
        c8093c.m50145a(view);
        c8093c.m50148b(this.f36847z);
        c8093c.m50146a(new C7978a(this));
        AbstractC7014dc.m41871a(this.f36833l);
        FeedbackActivity.m38613a(getContext(), c8093c);
    }

    @OuterVisible
    public void register(INativeAd iNativeAd, List<View> list, INativeWindowImageView iNativeWindowImageView) throws Resources.NotFoundException {
        register(iNativeAd);
        this.f36840s = iNativeWindowImageView;
        if (iNativeWindowImageView != null) {
            iNativeWindowImageView.setNativeAd(iNativeAd);
            setWindowImageViewClickable(this.f36840s);
        }
        this.f36842u = list;
        m49314a(list);
    }

    /* renamed from: a */
    private void m49308a(Context context, AdContentData adContentData) {
        AbstractC7185ho.m43820b("PPSNativeView", "showV3Ad");
        IRemoteCreator iRemoteCreatorM42835a = C7084e.m42835a(getContext().getApplicationContext());
        this.f36814G = iRemoteCreatorM42835a;
        if (iRemoteCreatorM42835a == null) {
            AbstractC7185ho.m43820b("PPSNativeView", "Creator is null");
            return;
        }
        this.f36815H = new BinderC6977bu(context, this, this.f36833l);
        String strM47742b = AbstractC7758be.m47742b(adContentData);
        AbstractC7185ho.m43818a("PPSNativeView", "showV3Ad contentJson: %s", strM47742b);
        Bundle bundle = new Bundle();
        bundle.putBinder(ParamConstants.Param.CONTEXT, (IBinder) ObjectWrapper.wrap(getContext()));
        bundle.putString("content", strM47742b);
        bundle.putInt(ParamConstants.Param.SDK_VERSION, 30476300);
        boolean zM48340p = AbstractC7811dd.m48340p(getContext().getApplicationContext());
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSNativeView", "emui9Dark %s", Boolean.valueOf(zM48340p));
        }
        bundle.putBoolean(ParamConstants.Param.EMUI9_DARK_MODE, zM48340p);
        bundle.putBoolean(ParamConstants.Param.SHOW_V2_TPT, C7780c.m47863a(getContext(), this.f36833l.m44809ae(), this.f36833l.getSlotId(), this.f36833l.m44632e()));
        try {
            View view = (View) ObjectWrapper.unwrap(this.f36814G.newNativeTemplateView(bundle, this.f36815H));
            this.f36816I = view;
            if (view == null) {
                AbstractC7185ho.m43823c("PPSNativeView", "templateView is null");
                return;
            }
            this.f36822a = null;
            removeAllViews();
            addView(this.f36816I);
            this.f36814G.bindData(ObjectWrapper.wrap(this.f36816I), strM47742b);
            KeyEvent.Callback callback = this.f36816I;
            if (callback instanceof IMediaStateApiTransfer) {
                ((IMediaStateApiTransfer) callback).setProxy(getMediaProxy());
            } else {
                AbstractC7185ho.m43823c("PPSNativeView", "Native template view is not a IMediaStateApiTransfer instance");
            }
            AbstractC7185ho.m43821b("PPSNativeView", "binddata end, slotid: %s", this.f36833l.getSlotId());
            if (m49337t()) {
                C7129fm.m43536a(getContext().getApplicationContext()).mo43542a(this.f36833l.getSlotId(), System.currentTimeMillis());
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSNativeView", "create newNativeTemplateView err: %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public boolean register(IAppDownloadButton iAppDownloadButton) {
        boolean nativeAd;
        if (this.f36833l == null) {
            throw new IllegalStateException("Register INativeAd first");
        }
        this.f36841t = iAppDownloadButton;
        m49334q();
        if (iAppDownloadButton != null) {
            iAppDownloadButton.setPpsNativeView(this);
            nativeAd = iAppDownloadButton.setNativeAd(this.f36833l);
        } else {
            nativeAd = false;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSNativeView", "register downloadbutton, succ:%s", Boolean.valueOf(nativeAd));
        }
        return nativeAd;
    }

    /* renamed from: a */
    public static void m49309a(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    /* renamed from: a */
    public void m49344a(View view, int i10) {
        m49345a(view, i10, true);
    }

    /* renamed from: a */
    public void m49345a(View view, int i10, boolean z10) {
        C7302e c7302e;
        if (this.f36830i) {
            this.f36830i = false;
            C7172hb.m43677a(getContext()).m43680a();
            AbstractC7185ho.m43820b("PPSNativeView", "onClick");
            mo49347a((Integer) 1);
            C7730ad.m47436b();
            if (this.f36831j.m45953a(this.f36811D, Integer.valueOf(i10), getAdTag(), z10, getBtnText())) {
                InterfaceC7416lz interfaceC7416lz = this.f36822a;
                if (interfaceC7416lz != null) {
                    interfaceC7416lz.mo45610a(EnumC7480mo.CLICK);
                }
                InterfaceC7342jp interfaceC7342jp = this.f36817J;
                if (interfaceC7342jp != null) {
                    interfaceC7342jp.mo45351a();
                }
            } else {
                IAppDownloadButton iAppDownloadButton = this.f36841t;
                if (iAppDownloadButton != null && (iAppDownloadButton instanceof AppDownloadButton)) {
                    if (AppStatus.DOWNLOAD == ((AppDownloadButton) iAppDownloadButton).getStatus() && (c7302e = this.f36833l) != null && c7302e.isAutoDownloadApp() && AbstractC7558os.m46469h(this.f36833l.getCtrlSwitchs())) {
                        AbstractC7185ho.m43820b("PPSNativeView", "download app directly");
                        ((AppDownloadButton) this.f36841t).performClick();
                    }
                }
            }
            this.f36811D = null;
            OnNativeAdClickListener onNativeAdClickListener = this.f36835n;
            if (onNativeAdClickListener != null) {
                onNativeAdClickListener.onClick(view);
            }
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.8
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.f36830i = true;
                }
            }, 500L);
        }
    }

    /* renamed from: a */
    public void m49346a(IAd iAd) {
        InterfaceC7416lz interfaceC7416lz;
        AbstractC7185ho.m43820b("PPSNativeView", "initOmsdkResource");
        if (iAd instanceof C7302e) {
            C7302e c7302e = (C7302e) iAd;
            ContentRecord contentRecordM46698a = C7570pd.m46698a(c7302e);
            if (m49316a(Integer.valueOf(contentRecordM46698a.m41464aP()), contentRecordM46698a.m41392E()) || (interfaceC7416lz = this.f36822a) == null) {
                return;
            }
            interfaceC7416lz.mo45607a(getContext(), contentRecordM46698a, this, true);
            this.f36822a.mo45612a(false);
            this.f36822a.mo45616c();
            InterfaceC7474mi interfaceC7474miMo45604a = this.f36822a.mo45604a();
            this.f36813F = interfaceC7474miMo45604a;
            if (interfaceC7474miMo45604a != null) {
                ChoicesView choicesView = this.f36824c;
                EnumC7473mh enumC7473mh = EnumC7473mh.OTHER;
                interfaceC7474miMo45604a.mo45609a(choicesView, enumC7473mh, null);
                this.f36813F.mo45609a(this.f36828g, enumC7473mh, null);
                this.f36813F.mo45609a(this.f36826e, enumC7473mh, null);
            }
            m49310a(this.f36822a, c7302e);
        }
    }

    /* renamed from: a */
    private void m49310a(InterfaceC7416lz interfaceC7416lz, C7302e c7302e) {
        INativeVideoView iNativeVideoView = this.f36839r;
        if (iNativeVideoView instanceof NativeVideoView) {
            ((NativeVideoView) iNativeVideoView).m48892a(interfaceC7416lz, c7302e);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView
    /* renamed from: a */
    public void mo49347a(Integer num) {
        m49313a(Long.valueOf(System.currentTimeMillis() - this.f36832k.m45278d()), Integer.valueOf(this.f36832k.m45277c()), num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49313a(Long l10, Integer num, Integer num2) {
        InterfaceC7979b interfaceC7979b = this.f36838q;
        if (interfaceC7979b != null) {
            interfaceC7979b.mo49025a();
        }
        C7302e c7302e = this.f36833l;
        if (c7302e == null) {
            return;
        }
        boolean zM47867a = C7780c.m47867a(c7302e.m44627d(), num2);
        if (!this.f36833l.m44790Y() || (zM47867a && !this.f36833l.m44619b())) {
            AbstractC7185ho.m43820b("PPSNativeView", "reportAdShowEvent, customExposureType： real onAdShow");
            this.f36831j.m45951a(l10, num, num2, getAdTag());
            if (zM47867a) {
                this.f36833l.m44612a(true);
            }
            if (this.f36833l.m44790Y()) {
                return;
            }
            this.f36833l.m44842h(true);
            InterfaceC7416lz interfaceC7416lz = this.f36822a;
            if (interfaceC7416lz != null) {
                interfaceC7416lz.mo45618e();
            }
            OnNativeAdShowListener onNativeAdShowListener = this.f36836o;
            if (onNativeAdShowListener != null) {
                onNativeAdShowListener.onAdShow();
            }
        }
    }

    /* renamed from: a */
    private void m49314a(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof NativeVideoView) {
                ((NativeVideoView) view).setCoverClickListener(this.f36821N);
            } else if (view != null) {
                view.setOnClickListener(this.f36821N);
            }
        }
    }

    /* renamed from: a */
    private boolean m49316a(Integer num, int i10) {
        return (num != null && 3 == num.intValue()) || 99 == i10;
    }

    /* renamed from: a */
    private boolean m49317a(int[] iArr) {
        return iArr != null && iArr.length == 2;
    }
}
