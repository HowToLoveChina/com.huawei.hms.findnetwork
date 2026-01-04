package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.BaseVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8129v;

/* renamed from: com.huawei.openalliance.ad.views.al */
/* loaded from: classes2.dex */
public class C8077al implements MediaBufferListener, MediaErrorListener, MediaStateListener, BaseVideoView.SurfaceListener, NetworkChangeListener {

    /* renamed from: a */
    private VideoView f37524a;

    /* renamed from: b */
    private InterfaceC8129v f37525b;

    /* renamed from: c */
    private ImageView f37526c;

    /* renamed from: d */
    private ImageView f37527d;

    /* renamed from: e */
    private View f37528e;

    /* renamed from: f */
    private ImageView f37529f;

    /* renamed from: g */
    private View f37530g;

    /* renamed from: h */
    private View f37531h;

    /* renamed from: i */
    private View f37532i;

    /* renamed from: m */
    private boolean f37536m;

    /* renamed from: o */
    private int f37538o;

    /* renamed from: p */
    private boolean f37539p;

    /* renamed from: q */
    private View.OnClickListener f37540q;

    /* renamed from: r */
    private a f37541r;

    /* renamed from: s */
    private int f37542s;

    /* renamed from: u */
    private VideoInfo f37544u;

    /* renamed from: v */
    private String f37545v;

    /* renamed from: j */
    private int f37533j = 10;

    /* renamed from: k */
    private final String f37534k = "hidePanelTask" + hashCode();

    /* renamed from: l */
    private final String f37535l = "autoPlayTask" + hashCode();

    /* renamed from: n */
    private boolean f37537n = true;

    /* renamed from: t */
    private boolean f37543t = false;

    /* renamed from: w */
    private boolean f37546w = true;

    /* renamed from: x */
    private boolean f37547x = false;

    /* renamed from: y */
    private Runnable f37548y = new Runnable() { // from class: com.huawei.openalliance.ad.views.al.1
        @Override // java.lang.Runnable
        public void run() {
            if (C8077al.this.f37524a == null || !C8077al.this.f37536m) {
                return;
            }
            C8077al.this.m50057b(true);
        }
    };

    /* renamed from: z */
    private View.OnClickListener f37549z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.al.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C8077al.this.f37547x = true;
            C8077al.this.m50023i(!view.isSelected());
        }
    };

    /* renamed from: A */
    private Runnable f37523A = new Runnable() { // from class: com.huawei.openalliance.ad.views.al.7
        @Override // java.lang.Runnable
        public void run() {
            C8077al.this.m50008a(false, true);
        }
    };

    /* renamed from: com.huawei.openalliance.ad.views.al$a */
    public interface a {
        /* renamed from: a */
        void mo48893a();

        /* renamed from: a */
        void mo48894a(boolean z10);

        /* renamed from: a */
        void mo48895a(boolean z10, int i10);

        /* renamed from: b */
        void mo48896b(boolean z10);

        /* renamed from: b */
        void mo48897b(boolean z10, int i10);

        /* renamed from: b */
        boolean mo48898b();
    }

    public C8077al(VideoView videoView, InterfaceC8129v interfaceC8129v) {
        m50005a(videoView);
        m50007a(interfaceC8129v);
    }

    /* renamed from: i */
    private void m50022i() {
        InterfaceC8129v interfaceC8129v = this.f37525b;
        if (interfaceC8129v == null) {
            return;
        }
        this.f37528e = interfaceC8129v.mo48842e();
        this.f37530g = this.f37525b.mo48846i();
        View viewMo48844g = this.f37525b.mo48844g();
        this.f37531h = viewMo48844g;
        if (viewMo48844g != null) {
            viewMo48844g.setClickable(true);
        }
        this.f37529f = this.f37525b.mo48843f();
        m50014c(this.f37525b);
        m50034o();
        m50030m();
        m50025j(false);
        m50061d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m50024j() {
        AbstractC7817dj.m48366a(this.f37535l);
        m50030m();
        if (this.f37533j == 10) {
            m50039t();
        }
        VideoView videoView = this.f37524a;
        if (videoView != null && !videoView.getCurrentState().m45811a()) {
            m50026k();
        }
        m50057b(false);
    }

    /* renamed from: k */
    private void m50026k() {
        if (this.f37529f == null) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("VideoControlBridge", "showPreviewView");
        }
        Animation animation = this.f37529f.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        AbstractC7811dd.m48304a((View) this.f37529f, true);
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.setAlpha(0.0f);
        }
    }

    /* renamed from: l */
    private void m50028l() {
        VideoView videoView;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("VideoControlBridge", "hidePreviewView");
        }
        C7822do.m48383a(this.f37529f, 8, 300, 300);
        if (this.f37529f == null || (videoView = this.f37524a) == null) {
            return;
        }
        videoView.setAlpha(1.0f);
    }

    /* renamed from: m */
    private void m50030m() {
        View view = this.f37531h;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: n */
    private void m50032n() {
        View view = this.f37531h;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* renamed from: o */
    private void m50034o() {
        m50035p();
        m50016d(this.f37525b);
        m50011b(this.f37525b);
        if (this.f37533j == 10) {
            m50036q();
        }
    }

    /* renamed from: p */
    private void m50035p() {
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.addMediaStateListener(this);
            this.f37524a.addMediaBufferListener(this);
            this.f37524a.addMediaErrorListener(this);
            this.f37524a.addNetworkChangeListener(this);
            this.f37524a.setSurfaceListener(this);
            this.f37524a.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.al.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C8077al.this.m50038s();
                }
            });
        }
    }

    /* renamed from: q */
    private void m50036q() {
        InterfaceC8129v interfaceC8129v = this.f37525b;
        if (interfaceC8129v instanceof NativeVideoControlPanel) {
            ((NativeVideoControlPanel) interfaceC8129v).setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.al.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C8077al.this.m50039t();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m50037r() {
        if (this.f37524a == null) {
            return;
        }
        AbstractC7817dj.m48366a(this.f37535l);
        if (this.f37524a.isPlaying()) {
            AbstractC7817dj.m48366a(this.f37534k);
            this.f37524a.pause();
            m50029l(true);
        } else {
            if (!C7775bv.m47831e(this.f37524a.getContext())) {
                Toast.makeText(this.f37524a.getContext(), C6849R.string.hiad_network_no_available, 0).show();
                return;
            }
            m50029l(false);
            if (this.f37543t || this.f37542s == 1 || C7775bv.m47829c(this.f37524a.getContext())) {
                m50057b(false);
                m50041v();
            } else {
                AbstractC7185ho.m43820b("VideoControlBridge", "in non wifi, show alert view");
                this.f37524a.pause();
                m50032n();
                m50040u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m50038s() {
        View.OnClickListener onClickListener;
        VideoView videoView = this.f37524a;
        if (videoView == null || (onClickListener = this.f37540q) == null) {
            return;
        }
        onClickListener.onClick(videoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m50039t() {
        View.OnClickListener onClickListener;
        if (this.f37524a == null || (onClickListener = this.f37540q) == null) {
            return;
        }
        onClickListener.onClick((NativeVideoControlPanel) this.f37525b);
    }

    /* renamed from: u */
    private void m50040u() {
        m50008a(false, false);
    }

    /* renamed from: v */
    private void m50041v() {
        AbstractC7817dj.m48366a(this.f37534k);
        AbstractC7817dj.m48365a(this.f37523A, this.f37534k, 3000L);
    }

    /* renamed from: w */
    private void m50042w() {
        if (this.f37524a == null) {
            return;
        }
        m50030m();
        if (!this.f37524a.getCurrentState().m45811a()) {
            m50026k();
        }
        a aVar = this.f37541r;
        if (aVar != null) {
            this.f37536m = aVar.mo48898b();
        }
        if (this.f37536m && !this.f37539p) {
            m50057b(true);
        } else {
            if (this.f37524a.isPlaying()) {
                return;
            }
            m50061d();
        }
    }

    /* renamed from: x */
    private void m50043x() {
        if (this.f37524a == null || !m50044y() || this.f37542s == 1) {
            return;
        }
        this.f37524a.stop();
        if (this.f37531h != null) {
            m50032n();
            m50040u();
        }
    }

    /* renamed from: y */
    private boolean m50044y() {
        return (this.f37524a.getCurrentState().isState(MediaState.State.PREPARING) || this.f37524a.isPlaying()) && !this.f37543t;
    }

    /* renamed from: z */
    private void m50045z() {
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            if (videoView.getCurrentState().isState(MediaState.State.PREPARING) || this.f37524a.isPlaying()) {
                this.f37524a.pause();
            }
        }
    }

    /* renamed from: b */
    public void m50055b() {
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.stop();
        }
        m50030m();
        m50025j(false);
        m50061d();
        m50026k();
    }

    /* renamed from: c */
    public void m50058c() {
        AbstractC7185ho.m43820b("VideoControlBridge", "autoPlayByNetworkState");
        VideoView videoView = this.f37524a;
        if (videoView == null) {
            return;
        }
        Context context = videoView.getContext();
        if (!C7775bv.m47831e(context)) {
            this.f37524a.pause();
            return;
        }
        if (this.f37543t || this.f37542s == 1 || C7775bv.m47829c(context)) {
            m50057b(true);
            return;
        }
        AbstractC7185ho.m43820b("VideoControlBridge", "autoPlayByNetworkState - in non wifi, show alert view");
        this.f37524a.pause();
        m50032n();
        m50040u();
    }

    /* renamed from: d */
    public void m50061d() {
        m50008a(true, false);
    }

    /* renamed from: e */
    public void m50063e() {
        this.f37539p = true;
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.pauseView();
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
    public void onBufferUpdate(int i10) {
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
    public void onBufferingEnd() {
        View view = this.f37528e;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f37528e.setVisibility(8);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
    public void onBufferingStart() {
        View view = this.f37528e;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.f37528e.setVisibility(0);
        ImageView imageView = this.f37526c;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
    public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
        m50004a(i10, false, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m50004a(i10, false, true);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m50004a(i10, true, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
        InterfaceC8129v interfaceC8129v;
        m50029l(false);
        if (this.f37526c != null && (interfaceC8129v = this.f37525b) != null && interfaceC8129v.mo48840c() != 0) {
            this.f37526c.setImageResource(this.f37525b.mo48840c());
        }
        m50028l();
        if (this.f37537n) {
            m50008a(false, false);
        } else {
            m50041v();
        }
        m50025j(true);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m50004a(i10, false, false);
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkConnectedOrChanged(boolean z10) {
        AbstractC7185ho.m43818a("VideoControlBridge", "onNetworkConnectedOrChanged, isWifi= %s", Boolean.valueOf(z10));
        m50027k(z10);
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkDisconnected() {
        m50045z();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onProgress(int i10, int i11) {
        VideoInfo videoInfo;
        if (i11 <= 0 || (videoInfo = this.f37544u) == null) {
            return;
        }
        videoInfo.m44579e(i11);
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView.SurfaceListener
    public void onSurfaceDestroyed() {
        m50026k();
        m50025j(false);
    }

    /* renamed from: h */
    private void m50021h(boolean z10) {
        a aVar = this.f37541r;
        if (aVar != null) {
            aVar.mo48896b(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m50023i(boolean z10) {
        AbstractC7185ho.m43820b("VideoControlBridge", "switchSound enableSound: " + z10);
        VideoView videoView = this.f37524a;
        if (videoView == null) {
            return;
        }
        if (z10) {
            videoView.unmute();
        } else {
            videoView.mute();
        }
        AbstractC7817dj.m48366a(this.f37534k);
        if (this.f37524a.isPlaying()) {
            m50041v();
        }
    }

    /* renamed from: j */
    private void m50025j(boolean z10) {
        this.f37537n = !z10;
        InterfaceC8129v interfaceC8129v = this.f37525b;
        if (interfaceC8129v != null) {
            interfaceC8129v.mo48838a(z10);
        }
    }

    /* renamed from: k */
    private void m50027k(boolean z10) {
        if (this.f37524a == null) {
            return;
        }
        if (z10 || this.f37542s == 1 || this.f37543t) {
            m50042w();
        } else {
            m50043x();
        }
    }

    /* renamed from: l */
    private void m50029l(boolean z10) {
        a aVar = this.f37541r;
        if (aVar != null) {
            aVar.mo48894a(z10);
        }
    }

    /* renamed from: m */
    private void m50031m(boolean z10) {
        VideoView videoView;
        a aVar = this.f37541r;
        if (aVar == null || (videoView = this.f37524a) == null) {
            return;
        }
        aVar.mo48895a(z10, videoView.getCurrentState().getStateCode());
    }

    /* renamed from: n */
    private void m50033n(boolean z10) {
        VideoView videoView;
        a aVar = this.f37541r;
        if (aVar == null || (videoView = this.f37524a) == null) {
            return;
        }
        aVar.mo48897b(z10, videoView.getCurrentState().getStateCode());
    }

    /* renamed from: a */
    public void m50046a() {
        AbstractC7817dj.m48366a(this.f37535l);
    }

    /* renamed from: b */
    public void m50056b(int i10) {
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.setDefaultDuration(i10);
        }
    }

    /* renamed from: c */
    public void m50059c(int i10) {
        this.f37542s = i10;
    }

    /* renamed from: f */
    public void m50065f() {
        this.f37539p = false;
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.resumeView();
        }
    }

    /* renamed from: g */
    public void m50067g() {
        VideoView videoView = this.f37524a;
        if (videoView != null) {
            videoView.pause();
        }
    }

    /* renamed from: d */
    private void m50016d(InterfaceC8129v interfaceC8129v) {
        ImageView imageViewMo48837a = interfaceC8129v.mo48837a();
        this.f37526c = imageViewMo48837a;
        if (imageViewMo48837a != null) {
            imageViewMo48837a.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.al.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C8077al.this.f37541r != null) {
                        C8077al.this.f37541r.mo48893a();
                    }
                    if (C8077al.this.f37533j != 10) {
                        C8077al.this.m50037r();
                    } else {
                        AbstractC7185ho.m43818a("VideoControlBridge", "linkedVideoMode is %d", Integer.valueOf(C8077al.this.f37533j));
                        C8077al.this.m50039t();
                    }
                }
            });
            if (interfaceC8129v.mo48839b() > 0) {
                this.f37526c.setImageResource(interfaceC8129v.mo48839b());
                AbstractC7811dd.m48296a(this.f37526c);
            }
        }
    }

    /* renamed from: a */
    public void m50047a(int i10) {
        this.f37538o = i10;
        if (this.f37524a != null) {
            AbstractC7185ho.m43818a("VideoControlBridge", "setPreferStartPlayTime %d", Integer.valueOf(i10));
            this.f37524a.setPreferStartPlayTime(i10);
        }
    }

    /* renamed from: e */
    public void m50064e(boolean z10) {
        AbstractC7185ho.m43820b("VideoControlBridge", "setMuteButtonState mute: " + z10);
        ImageView imageViewMo48841d = this.f37525b.mo48841d();
        if (imageViewMo48841d != null) {
            imageViewMo48841d.setSelected(!z10);
        }
    }

    /* renamed from: f */
    public void m50066f(boolean z10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoControlBridge", "setPlayButtonEnabled: %s", Boolean.valueOf(z10));
        }
        ImageView imageView = this.f37526c;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
    }

    /* renamed from: g */
    public void m50068g(boolean z10) {
        if (z10) {
            m50053a((String) null);
            m50047a(0);
            m50056b(0);
            m50049a((Drawable) null);
        }
        m50026k();
        m50061d();
    }

    /* renamed from: h */
    public boolean m50069h() {
        return this.f37547x;
    }

    /* renamed from: a */
    private void m50004a(int i10, boolean z10, boolean z11) {
        InterfaceC8129v interfaceC8129v;
        m50046a();
        if (z11) {
            i10 = 0;
        }
        this.f37538o = i10;
        AbstractC7817dj.m48366a(this.f37534k);
        if (this.f37526c != null && (interfaceC8129v = this.f37525b) != null && interfaceC8129v.mo48839b() != 0) {
            this.f37526c.setImageResource(this.f37525b.mo48839b());
            AbstractC7811dd.m48296a(this.f37526c);
        }
        if (!z10) {
            m50026k();
            m50025j(false);
        }
        View view = this.f37531h;
        if (view == null || view.getVisibility() != 0) {
            m50008a(true, true);
        }
        ImageView imageView = this.f37526c;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m50011b(InterfaceC8129v interfaceC8129v) {
        View viewMo48845h = interfaceC8129v.mo48845h();
        this.f37532i = viewMo48845h;
        if (viewMo48845h != null) {
            viewMo48845h.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.al.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C8077al.this.m50024j();
                }
            });
        }
    }

    /* renamed from: c */
    private void m50014c(InterfaceC8129v interfaceC8129v) {
        ImageView imageViewMo48841d = interfaceC8129v.mo48841d();
        this.f37527d = imageViewMo48841d;
        if (imageViewMo48841d != null) {
            imageViewMo48841d.setOnClickListener(this.f37549z);
        }
    }

    /* renamed from: d */
    public void m50062d(boolean z10) {
        AbstractC7185ho.m43820b("VideoControlBridge", "toggleVideoMute mute: " + z10);
        if (this.f37524a == null || this.f37525b == null) {
            return;
        }
        m50064e(z10);
        VideoView videoView = this.f37524a;
        if (z10) {
            videoView.mute();
        } else {
            videoView.unmute();
        }
    }

    /* renamed from: a */
    public void m50048a(long j10) {
        AbstractC7185ho.m43821b("VideoControlBridge", "autoPlay - canAutoPlay: %s, autoPlayOnFirstShow: %s, delayMs: %d", Boolean.valueOf(this.f37536m), Boolean.valueOf(this.f37546w), Long.valueOf(j10));
        AbstractC7817dj.m48366a(this.f37535l);
        if (this.f37536m && this.f37546w) {
            if (this.f37524a.isPlaying()) {
                AbstractC7185ho.m43817a("VideoControlBridge", "autoPlay - video is playing");
                m50057b(true);
                return;
            }
            AbstractC7185ho.m43817a("VideoControlBridge", "autoPlay - start delay runnable");
            if (!TextUtils.isEmpty(this.f37545v) && !this.f37545v.startsWith(Constants.LOCAL_HOST)) {
                this.f37524a.prefetch();
            }
            AbstractC7817dj.m48365a(this.f37548y, this.f37535l, j10);
        }
    }

    /* renamed from: b */
    public void m50057b(boolean z10) {
        if (this.f37524a != null) {
            m50021h(z10);
            this.f37524a.setPreferStartPlayTime(this.f37538o);
            this.f37524a.play(z10);
        }
    }

    /* renamed from: c */
    public void m50060c(boolean z10) {
        this.f37536m = z10;
    }

    /* renamed from: a */
    public void m50049a(Drawable drawable) {
        ImageView imageView = this.f37529f;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    /* renamed from: a */
    public void m50050a(View.OnClickListener onClickListener) {
        this.f37540q = onClickListener;
    }

    /* renamed from: a */
    public void m50051a(VideoInfo videoInfo) {
        this.f37544u = videoInfo;
    }

    /* renamed from: a */
    private void m50005a(VideoView videoView) {
        this.f37524a = videoView;
    }

    /* renamed from: a */
    public void m50052a(a aVar) {
        this.f37541r = aVar;
    }

    /* renamed from: a */
    private void m50007a(InterfaceC8129v interfaceC8129v) {
        this.f37525b = interfaceC8129v;
        m50022i();
    }

    /* renamed from: a */
    public void m50053a(String str) {
        VideoView videoView;
        if (this.f37525b == null || (videoView = this.f37524a) == null) {
            return;
        }
        this.f37545v = str;
        videoView.setVideoFileUrl(str);
    }

    /* renamed from: a */
    public void m50054a(boolean z10) {
        AbstractC7185ho.m43821b("VideoControlBridge", "setAutoPlayOnFirstShow: %s", Boolean.valueOf(z10));
        this.f37546w = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50008a(boolean z10, boolean z11) {
        boolean zM48304a;
        View view = this.f37530g;
        if (z11) {
            zM48304a = AbstractC7811dd.m48303a(view, z10 ? 0 : 8);
        } else {
            zM48304a = AbstractC7811dd.m48304a(view, z10);
        }
        if (zM48304a) {
            if (z10) {
                m50031m(z11);
            } else {
                m50033n(z11);
            }
        }
    }
}
