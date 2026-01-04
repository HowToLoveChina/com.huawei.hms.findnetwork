package com.huawei.openalliance.p169ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.activity.PPSActivity;
import com.huawei.openalliance.p169ad.linked.view.LinkedNativeViewControlPanel;
import com.huawei.openalliance.p169ad.linked.view.LinkedWifiAlertPlayButton;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.BaseVideoView;
import com.huawei.openalliance.p169ad.views.NetworkChangeListener;
import com.huawei.openalliance.p169ad.views.VideoView;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.hd */
/* loaded from: classes8.dex */
public class C7174hd implements MediaBufferListener, MediaErrorListener, MediaStateListener, BaseVideoView.SurfaceListener, NetworkChangeListener {

    /* renamed from: B */
    private int f33022B;

    /* renamed from: H */
    private View.OnClickListener f33028H;

    /* renamed from: I */
    private a f33029I;

    /* renamed from: N */
    private PPSActivity.InterfaceC6882b f33034N;

    /* renamed from: S */
    private boolean f33039S;

    /* renamed from: d */
    private VideoView f33043d;

    /* renamed from: e */
    private SeekBar f33044e;

    /* renamed from: f */
    private LinkedNativeViewControlPanel f33045f;

    /* renamed from: g */
    private ImageView f33046g;

    /* renamed from: h */
    private ImageView f33047h;

    /* renamed from: i */
    private ImageView f33048i;

    /* renamed from: j */
    private ImageView f33049j;

    /* renamed from: k */
    private TextView f33050k;

    /* renamed from: l */
    private TextView f33051l;

    /* renamed from: m */
    private Context f33052m;

    /* renamed from: n */
    private int f33053n;

    /* renamed from: o */
    private View f33054o;

    /* renamed from: p */
    private ImageView f33055p;

    /* renamed from: q */
    private View f33056q;

    /* renamed from: r */
    private LinkedWifiAlertPlayButton f33057r;

    /* renamed from: s */
    private InterfaceC7168gy f33058s;

    /* renamed from: t */
    private boolean f33059t;

    /* renamed from: v */
    private int f33061v;

    /* renamed from: w */
    private boolean f33062w;

    /* renamed from: x */
    private int f33063x;

    /* renamed from: z */
    private int f33065z;

    /* renamed from: a */
    private final String f33040a = "hPlT" + hashCode();

    /* renamed from: b */
    private final String f33041b = "hBPlT" + hashCode();

    /* renamed from: c */
    private final String f33042c = "aPT" + hashCode();

    /* renamed from: u */
    private boolean f33060u = true;

    /* renamed from: y */
    private boolean f33064y = true;

    /* renamed from: A */
    private int f33021A = 0;

    /* renamed from: C */
    private int f33023C = 0;

    /* renamed from: D */
    private String f33024D = "n";

    /* renamed from: E */
    private boolean f33025E = false;

    /* renamed from: F */
    private boolean f33026F = false;

    /* renamed from: G */
    private final Runnable f33027G = new Runnable() { // from class: com.huawei.openalliance.ad.hd.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7174hd.this.f33043d == null || !C7174hd.this.f33059t) {
                return;
            }
            C7174hd c7174hd = C7174hd.this;
            c7174hd.m43724g(c7174hd.f33058s.mo43648a(2, C7174hd.this.f33064y));
        }
    };

    /* renamed from: J */
    private C7173hc f33030J = new C7173hc();

    /* renamed from: K */
    private final Runnable f33031K = new Runnable() { // from class: com.huawei.openalliance.ad.hd.4
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7174hd.this.m43784v();
        }
    };

    /* renamed from: L */
    private final Runnable f33032L = new Runnable() { // from class: com.huawei.openalliance.ad.hd.5
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7174hd.this.m43775m();
        }
    };

    /* renamed from: M */
    private final View.OnClickListener f33033M = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.6
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd.this.m43730k(!view.isSelected());
        }
    };

    /* renamed from: O */
    private boolean f33035O = false;

    /* renamed from: P */
    private final View.OnClickListener f33036P = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.7
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd.this.f33035O = !r2.f33035O;
            if (C7174hd.this.f33034N != null) {
                C7174hd.this.f33034N.mo38704a(C7174hd.this.f33035O);
            }
        }
    };

    /* renamed from: Q */
    private final View.OnClickListener f33037Q = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.8
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C7174hd.this.f33030J != null && C7174hd.this.f33030J.m43688d()) {
                C7174hd.this.f33030J.m43687c();
            }
            C7174hd.this.m43755c();
            C7174hd.this.m43776n();
            C7174hd.this.m43785w();
            int i10 = C7174hd.this.f33053n;
            if (i10 == 0) {
                C7174hd.this.f33029I.mo43790b();
            } else if (i10 != 1) {
                C7174hd.this.f33029I.mo43792d();
            } else {
                C7174hd.this.f33029I.mo43791c();
            }
            C7174hd.this.m43694F();
        }
    };

    /* renamed from: R */
    private SeekBar.OnSeekBarChangeListener f33038R = new SeekBar.OnSeekBarChangeListener() { // from class: com.huawei.openalliance.ad.hd.3
        public AnonymousClass3() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                AbstractC7185ho.m43818a("LinkedVideoControlBridge", "onProgressChanged %d", Integer.valueOf(i10));
                C7174hd.this.f33043d.seekTo(i10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            C7174hd.this.f33039S = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            C7174hd.this.f33039S = false;
        }
    };

    /* renamed from: com.huawei.openalliance.ad.hd$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C7174hd.this.f33043d == null || !C7174hd.this.f33059t) {
                return;
            }
            C7174hd c7174hd = C7174hd.this;
            c7174hd.m43724g(c7174hd.f33058s.mo43648a(2, C7174hd.this.f33064y));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$10 */
    public class AnonymousClass10 implements View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd.this.m43696H();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$11 */
    public class AnonymousClass11 implements View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CharSequence text = C7174hd.this.f33057r.getText();
            String string = C7174hd.this.f33052m != null ? C7174hd.this.f33052m.getResources().getString(C6849R.string.hiad_continue_to_play) : null;
            if (string != null && string.equals(text)) {
                C7174hd.this.f33064y = false;
                if (C7174hd.this.f33029I != null) {
                    C7174hd.this.f33029I.mo43788a();
                }
            }
            if (C7174hd.this.f33058s != null) {
                C7174hd c7174hd = C7174hd.this;
                c7174hd.m43724g(c7174hd.f33058s.mo43648a(1, C7174hd.this.f33064y));
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AbstractC7185ho.m43818a("LinkedVideoControlBridge", "onClick, currentState %s", C7174hd.this.f33043d.getCurrentState().toString());
            if (C7174hd.this.f33029I != null) {
                if (C7174hd.this.f33043d.isPlaying()) {
                    C7174hd.this.f33029I.mo43791c();
                } else {
                    C7174hd.this.f33029I.mo43790b();
                }
            }
            C7174hd.this.m43694F();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$3 */
    public class AnonymousClass3 implements SeekBar.OnSeekBarChangeListener {
        public AnonymousClass3() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                AbstractC7185ho.m43818a("LinkedVideoControlBridge", "onProgressChanged %d", Integer.valueOf(i10));
                C7174hd.this.f33043d.seekTo(i10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            C7174hd.this.f33039S = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            C7174hd.this.f33039S = false;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7174hd.this.m43784v();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C7174hd.this.m43775m();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$6 */
    public class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd.this.m43730k(!view.isSelected());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$7 */
    public class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd.this.f33035O = !r2.f33035O;
            if (C7174hd.this.f33034N != null) {
                C7174hd.this.f33034N.mo38704a(C7174hd.this.f33035O);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$8 */
    public class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C7174hd.this.f33030J != null && C7174hd.this.f33030J.m43688d()) {
                C7174hd.this.f33030J.m43687c();
            }
            C7174hd.this.m43755c();
            C7174hd.this.m43776n();
            C7174hd.this.m43785w();
            int i10 = C7174hd.this.f33053n;
            if (i10 == 0) {
                C7174hd.this.f33029I.mo43790b();
            } else if (i10 != 1) {
                C7174hd.this.f33029I.mo43792d();
            } else {
                C7174hd.this.f33029I.mo43791c();
            }
            C7174hd.this.m43694F();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$9 */
    public class AnonymousClass9 implements View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C7174hd.this.m43695G();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.hd$a */
    public interface a {
        /* renamed from: a */
        void mo43788a();

        /* renamed from: a */
        void mo43789a(boolean z10);

        /* renamed from: b */
        void mo43790b();

        /* renamed from: c */
        void mo43791c();

        /* renamed from: d */
        void mo43792d();
    }

    public C7174hd(Context context, VideoView videoView, LinkedNativeViewControlPanel linkedNativeViewControlPanel) {
        this.f33052m = context;
        m43707a(videoView);
        m43706a(linkedNativeViewControlPanel);
    }

    /* renamed from: A */
    private void m43689A() {
        if (this.f33055p == null) {
            return;
        }
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "showPreviewView");
        Animation animation = this.f33055p.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        C7822do.m48384a((View) this.f33055p, true);
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.setAlpha(0.0f);
        }
    }

    /* renamed from: B */
    private String m43690B() {
        int i10 = this.f33022B;
        if (i10 == 0) {
            return null;
        }
        long j10 = ((100 - this.f33063x) * i10) / 100;
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", " left data is %d", Long.valueOf(j10));
        if (j10 == 0) {
            return null;
        }
        return AbstractC7731ae.m47438a(this.f33052m, j10);
    }

    /* renamed from: C */
    private void m43691C() {
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.addMediaStateListener(this);
            this.f33043d.addMediaBufferListener(this);
            this.f33043d.addMediaErrorListener(this);
            this.f33043d.addNetworkChangeListener(this);
            this.f33043d.setSurfaceListener(this);
        }
    }

    /* renamed from: D */
    private void m43692D() {
        ImageView imageViewM45511i = this.f33045f.m45511i();
        this.f33049j = imageViewM45511i;
        if (imageViewM45511i != null) {
            imageViewM45511i.setOnClickListener(this.f33037Q);
        }
    }

    /* renamed from: E */
    private void m43693E() {
        LinkedNativeViewControlPanel linkedNativeViewControlPanel = this.f33045f;
        if (linkedNativeViewControlPanel == null) {
            return;
        }
        ImageView imageViewM45509g = linkedNativeViewControlPanel.m45509g();
        this.f33048i = imageViewM45509g;
        if (imageViewM45509g != null) {
            imageViewM45509g.setOnClickListener(this.f33036P);
        }
    }

    /* renamed from: F */
    public void m43694F() {
        if (this.f33043d == null) {
            return;
        }
        m43771i(true);
        AbstractC7817dj.m48366a(this.f33042c);
        if (this.f33043d.isPlaying()) {
            AbstractC7817dj.m48366a(this.f33040a);
            this.f33043d.pause();
            m43762e(0);
        } else {
            InterfaceC7168gy interfaceC7168gy = this.f33058s;
            if (interfaceC7168gy != null) {
                m43724g(interfaceC7168gy.mo43648a(1, this.f33064y));
            }
        }
    }

    /* renamed from: G */
    public void m43695G() {
        View.OnClickListener onClickListener = this.f33028H;
        if (onClickListener != null) {
            onClickListener.onClick(this.f33055p);
        }
        m43787y();
        m43785w();
    }

    /* renamed from: H */
    public void m43696H() {
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            this.f33028H.onClick(videoView);
            m43787y();
            m43785w();
        }
    }

    /* renamed from: I */
    private void m43697I() {
        AbstractC7817dj.m48366a(this.f33040a);
        AbstractC7817dj.m48365a(this.f33031K, this.f33040a, 200L);
    }

    /* renamed from: J */
    private void m43698J() {
        VideoView videoView = this.f33043d;
        if (videoView == null) {
            return;
        }
        if (videoView.getCurrentState().m45811a()) {
            this.f33043d.pause();
        }
        m43766g();
        m43770i();
    }

    /* renamed from: K */
    private void m43699K() {
        m43698J();
    }

    /* renamed from: z */
    private void m43736z() {
        if (this.f33045f == null) {
            return;
        }
        m43786x();
        this.f33054o = this.f33045f.m45514l();
        View viewM45516n = this.f33045f.m45516n();
        this.f33056q = viewM45516n;
        if (viewM45516n != null) {
            viewM45516n.setClickable(true);
        }
        ImageView imageViewM45515m = this.f33045f.m45515m();
        this.f33055p = imageViewM45515m;
        if (imageViewM45515m != null) {
            imageViewM45515m.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.9
                public AnonymousClass9() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C7174hd.this.m43695G();
                }
            });
        }
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.10
                public AnonymousClass10() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C7174hd.this.m43696H();
                }
            });
        }
        m43719e(this.f33045f);
        m43713c(this.f33045f);
        m43693E();
        m43717d(this.f33045f);
        m43692D();
        m43691C();
        m43709b(this.f33045f);
        m43766g();
        m43732l(false);
        m43783u();
    }

    /* renamed from: b */
    public void m43751b() {
        m43732l(false);
        m43784v();
    }

    /* renamed from: c */
    public void m43755c() {
        View view = this.f33056q;
        if (view == null || view.getVisibility() != 0) {
            m43783u();
        }
        m43784v();
        if (this.f33044e != null) {
            m43771i(true);
        }
    }

    /* renamed from: e */
    public void m43761e() {
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.stop();
        }
        m43766g();
        m43783u();
        m43689A();
    }

    /* renamed from: j */
    public void m43772j() {
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.pause();
        }
    }

    /* renamed from: k */
    public void m43773k() {
        this.f33062w = true;
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.pauseView();
        }
    }

    /* renamed from: l */
    public void m43774l() {
        this.f33062w = false;
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.resumeView();
        }
    }

    /* renamed from: o */
    public void m43777o() {
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "showProgressControlPanel: ");
        m43743a(this.f33044e);
        m43743a(this.f33050k);
        m43743a(this.f33051l);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
    public void onBufferUpdate(int i10) {
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
    public void onBufferingEnd() {
        View view = this.f33054o;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f33054o.setVisibility(8);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
    public void onBufferingStart() {
        View view = this.f33054o;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.f33054o.setVisibility(0);
        m43784v();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
    public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
        m43703a(i10, false, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "onMediaCompletion");
        this.f33025E = true;
        m43703a(i10, false, true);
        if (this.f33030J.m43686b()) {
            m43751b();
            this.f33030J.m43683a();
            m43762e(2);
            m43776n();
        } else {
            m43755c();
            m43762e(2);
        }
        m43702a(i10, this.f33024D, true);
        this.f33063x = 0;
        m43771i(false);
        InterfaceC7168gy interfaceC7168gy = this.f33058s;
        if (interfaceC7168gy != null) {
            interfaceC7168gy.mo43650b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m43703a(i10, true, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
        if (this.f33046g != null && this.f33045f != null && LinkedNativeViewControlPanel.m45504b() != 0) {
            this.f33046g.setImageResource(LinkedNativeViewControlPanel.m45504b());
        }
        this.f33025E = false;
        m43784v();
        m43764f();
        m43762e(1);
        if (this.f33060u) {
            m43784v();
        } else {
            m43697I();
        }
        m43732l(true);
        m43776n();
        m43785w();
        m43702a(i10, this.f33024D, true);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "onMediaStop playtime is %d", Integer.valueOf(i10));
        m43703a(i10, false, false);
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkConnectedOrChanged(boolean z10) {
        C7173hc c7173hc;
        if (this.f33058s == null || this.f33043d == null || this.f33025E || (c7173hc = this.f33030J) == null || c7173hc.m43688d()) {
            return;
        }
        m43724g(this.f33058s.mo43649a(z10, this.f33064y));
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkDisconnected() {
        C7173hc c7173hc;
        InterfaceC7168gy interfaceC7168gy;
        if (this.f33043d == null || this.f33025E || (c7173hc = this.f33030J) == null || c7173hc.m43688d() || (interfaceC7168gy = this.f33058s) == null) {
            return;
        }
        m43724g(interfaceC7168gy.mo43647a());
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onProgress(int i10, int i11) {
        SeekBar seekBar;
        if (!this.f33039S && (seekBar = this.f33044e) != null && i11 > 0) {
            seekBar.setProgress(i10);
            m43744a(this.f33050k, i11);
        }
        if (i11 > 0) {
            this.f33063x = i10;
            this.f33023C += 200;
            m43702a(i11, this.f33024D, false);
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView.SurfaceListener
    public void onSurfaceDestroyed() {
        m43689A();
        m43732l(false);
    }

    /* renamed from: p */
    public void m43778p() {
        m43753b(this.f33044e);
        m43753b(this.f33050k);
        m43753b(this.f33051l);
    }

    /* renamed from: q */
    public void m43779q() {
        m43743a(this.f33049j);
    }

    /* renamed from: r */
    public void m43780r() {
        m43753b(this.f33049j);
    }

    /* renamed from: s */
    public void m43781s() {
        m43753b(this.f33047h);
    }

    /* renamed from: t */
    public void m43782t() {
        m43743a(this.f33047h);
    }

    /* renamed from: u */
    public void m43783u() {
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "showPlayButton");
        View view = this.f33056q;
        if (view != null && view.getVisibility() == 0) {
            m43784v();
            return;
        }
        View view2 = this.f33054o;
        if (view2 != null && view2.getVisibility() == 0) {
            m43784v();
        } else if (this.f33030J.m43688d()) {
            m43784v();
        } else {
            m43753b(this.f33046g);
        }
    }

    /* renamed from: v */
    public void m43784v() {
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "hidePlayButton");
        m43743a(this.f33046g);
    }

    /* renamed from: w */
    public void m43785w() {
        AbstractC7817dj.m48366a(this.f33041b);
        AbstractC7817dj.m48365a(this.f33032L, this.f33041b, 3000L);
    }

    /* renamed from: x */
    public void m43786x() {
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "hideAllControlPanelDirectly");
        m43784v();
        AbstractC7817dj.m48366a(this.f33041b);
        m43775m();
    }

    /* renamed from: y */
    public void m43787y() {
        m43783u();
        m43776n();
    }

    /* renamed from: a */
    public void m43737a() {
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "setForImageOnly");
        m43707a((VideoView) null);
        m43771i(false);
        m43784v();
        m43732l(false);
    }

    /* renamed from: b */
    public void m43752b(int i10) {
        this.f33021A = i10;
    }

    /* renamed from: c */
    public void m43756c(int i10) {
        this.f33065z = i10;
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.setDefaultDuration(i10);
            m43744a(this.f33051l, i10);
        }
    }

    /* renamed from: d */
    public void m43758d() {
        AbstractC7817dj.m48366a(this.f33042c);
    }

    /* renamed from: e */
    public void m43762e(int i10) {
        int iM45502a;
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "updateButtonState: %d", Integer.valueOf(i10));
        this.f33053n = i10;
        ImageView imageView = this.f33049j;
        if (imageView == null) {
            return;
        }
        if (i10 == 0) {
            iM45502a = LinkedNativeViewControlPanel.m45502a();
        } else if (i10 == 1) {
            imageView.setImageResource(LinkedNativeViewControlPanel.m45504b());
            return;
        } else if (i10 != 2) {
            return;
        } else {
            iM45502a = LinkedNativeViewControlPanel.m45505c();
        }
        imageView.setImageResource(iM45502a);
        AbstractC7811dd.m48296a(this.f33049j);
    }

    /* renamed from: f */
    public void m43764f() {
        VideoView videoView;
        C7822do.m48383a(this.f33055p, 8, 300, 300);
        if (this.f33055p == null || (videoView = this.f33043d) == null) {
            return;
        }
        videoView.setAlpha(1.0f);
    }

    /* renamed from: g */
    public void m43766g() {
        m43743a(this.f33056q);
    }

    /* renamed from: h */
    public void m43768h() {
        m43762e(0);
        if (this.f33056q != null) {
            String strM43690B = m43690B();
            this.f33045f.setNonWifiAlertMsg(strM43690B != null ? this.f33052m.getResources().getString(C6849R.string.hiad_consuming_data_to_play_video, strM43690B) : this.f33052m.getResources().getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size));
            this.f33057r.setText(C6849R.string.hiad_continue_to_play);
            m43786x();
            this.f33030J.m43687c();
            m43753b(this.f33056q);
            this.f33043d.m48793h();
        }
    }

    /* renamed from: i */
    public void m43770i() {
        if (this.f33030J.m43688d()) {
            this.f33030J.m43683a();
            return;
        }
        if (this.f33053n == 1) {
            m43762e(0);
        }
        this.f33045f.setNonWifiAlertMsg(C6849R.string.hiad_network_disconnect_to_try);
        this.f33057r.setText(C6849R.string.hiad_click_to_try_again);
        m43786x();
        m43753b(this.f33056q);
    }

    /* renamed from: m */
    public void m43775m() {
        m43777o();
        m43779q();
        m43782t();
        m43784v();
    }

    /* renamed from: n */
    public void m43776n() {
        View view = this.f33056q;
        if (view != null && view.getVisibility() == 0) {
            m43775m();
            return;
        }
        if (this.f33053n != 2) {
            m43778p();
        }
        m43780r();
        m43781s();
    }

    /* renamed from: c */
    private void m43713c(LinkedNativeViewControlPanel linkedNativeViewControlPanel) {
        ImageView imageViewM45508f = linkedNativeViewControlPanel.m45508f();
        this.f33047h = imageViewM45508f;
        if (imageViewM45508f != null) {
            m43781s();
            this.f33047h.setOnClickListener(this.f33033M);
        }
    }

    /* renamed from: e */
    private void m43719e(LinkedNativeViewControlPanel linkedNativeViewControlPanel) {
        ImageView imageViewM45507e = linkedNativeViewControlPanel.m45507e();
        this.f33046g = imageViewM45507e;
        if (imageViewM45507e != null) {
            imageViewM45507e.setClickable(true);
            this.f33046g.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.2
                public AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AbstractC7185ho.m43818a("LinkedVideoControlBridge", "onClick, currentState %s", C7174hd.this.f33043d.getCurrentState().toString());
                    if (C7174hd.this.f33029I != null) {
                        if (C7174hd.this.f33043d.isPlaying()) {
                            C7174hd.this.f33029I.mo43791c();
                        } else {
                            C7174hd.this.f33029I.mo43790b();
                        }
                    }
                    C7174hd.this.m43694F();
                }
            });
            if (LinkedNativeViewControlPanel.m45502a() > 0) {
                this.f33046g.setImageResource(LinkedNativeViewControlPanel.m45502a());
                AbstractC7811dd.m48296a(this.f33046g);
            }
            m43783u();
        }
    }

    /* renamed from: f */
    private void m43722f(int i10) {
        int i11 = this.f33065z;
        if (i11 != 0) {
            int i12 = (i10 * 100) / i11;
            this.f33063x = i12;
            AbstractC7185ho.m43818a("LinkedVideoControlBridge", " currentProgress is %d", Integer.valueOf(i12));
        } else {
            int i13 = this.f33021A;
            if (i13 != 0) {
                AbstractC7185ho.m43818a("LinkedVideoControlBridge", "calculateCurrentProgress defaultVideoDuration %d", Integer.valueOf(i13));
                int i14 = (i10 * 100) / this.f33021A;
                this.f33063x = i14;
                AbstractC7185ho.m43818a("LinkedVideoControlBridge", " currentProgress is %d", Integer.valueOf(i14));
            }
        }
        if (this.f33063x >= 100) {
            AbstractC7185ho.m43820b("LinkedVideoControlBridge", "progress bigger than 100, play from start.");
            this.f33063x = 0;
        }
    }

    /* renamed from: g */
    public void m43724g(int i10) {
        AbstractC7185ho.m43821b("LinkedVideoControlBridge", "strategyMode is %d", Integer.valueOf(i10));
        if (i10 == 1) {
            m43699K();
            return;
        }
        if (i10 == 101) {
            m43708a(false, true);
            return;
        }
        if (i10 == 102) {
            m43708a(true, false);
        } else if (i10 == 201) {
            m43734m(true);
        } else {
            if (i10 != 202) {
                return;
            }
            m43734m(false);
        }
    }

    /* renamed from: j */
    private void m43728j(boolean z10) {
        a aVar = this.f33029I;
        if (aVar != null) {
            aVar.mo43789a(z10);
        }
    }

    /* renamed from: k */
    public void m43730k(boolean z10) {
        String str;
        AbstractC7185ho.m43820b("LinkedVideoControlBridge", "switchSound: " + z10);
        VideoView videoView = this.f33043d;
        if (videoView == null) {
            return;
        }
        if (z10) {
            videoView.unmute();
            str = "y";
        } else {
            videoView.mute();
            str = "n";
        }
        this.f33024D = str;
        m43710b(this.f33024D);
        AbstractC7817dj.m48366a(this.f33040a);
        if (this.f33043d.isPlaying()) {
            m43697I();
        }
    }

    /* renamed from: l */
    private void m43732l(boolean z10) {
        this.f33060u = !z10;
    }

    /* renamed from: m */
    private void m43734m(boolean z10) {
        VideoView videoView = this.f33043d;
        if (videoView == null) {
            return;
        }
        MediaState currentState = videoView.getCurrentState();
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "currentState %s", currentState.toString());
        if (currentState.isState(MediaState.State.PLAYING)) {
            this.f33043d.pause();
        } else if (currentState.isState(MediaState.State.PREPARING)) {
            this.f33043d.stop();
            m43689A();
        }
        m43766g();
        m43768h();
    }

    /* renamed from: a */
    public void m43738a(int i10) {
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "setPreferStartPlayTime %d", Integer.valueOf(i10));
        this.f33061v = i10;
        m43722f(i10);
        VideoView videoView = this.f33043d;
        if (videoView != null) {
            videoView.setPreferStartPlayTime(i10);
        }
    }

    /* renamed from: b */
    public void m43753b(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* renamed from: d */
    public void m43759d(int i10) {
        this.f33022B = i10;
    }

    /* renamed from: h */
    public void m43769h(boolean z10) {
        this.f33064y = z10;
    }

    /* renamed from: i */
    public void m43771i(boolean z10) {
        SeekBar seekBar = this.f33044e;
        if (seekBar != null) {
            if (z10 && seekBar.getVisibility() != 0) {
                m43778p();
            } else {
                if (z10 || this.f33044e.getVisibility() == 8) {
                    return;
                }
                m43777o();
            }
        }
    }

    /* renamed from: a */
    private void m43701a(int i10, String str) {
        AbstractC7185ho.m43820b("LinkedVideoControlBridge", "sendLinkedAdChangeBroadcast");
        Intent intent = new Intent("com.huawei.hms.pps.action.LANDING_AD_STATUS_CHANGED");
        intent.putExtra("linked_ad_play_progress", i10);
        intent.putExtra("linked_ad_sound_switch", str);
        intent.setPackage(this.f33052m.getPackageName());
        this.f33052m.sendBroadcast(intent);
    }

    /* renamed from: b */
    private void m43709b(LinkedNativeViewControlPanel linkedNativeViewControlPanel) {
        LinkedWifiAlertPlayButton linkedWifiAlertPlayButtonM45517o = linkedNativeViewControlPanel.m45517o();
        this.f33057r = linkedWifiAlertPlayButtonM45517o;
        if (linkedWifiAlertPlayButtonM45517o != null) {
            linkedWifiAlertPlayButtonM45517o.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.hd.11
                public AnonymousClass11() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CharSequence text = C7174hd.this.f33057r.getText();
                    String string = C7174hd.this.f33052m != null ? C7174hd.this.f33052m.getResources().getString(C6849R.string.hiad_continue_to_play) : null;
                    if (string != null && string.equals(text)) {
                        C7174hd.this.f33064y = false;
                        if (C7174hd.this.f33029I != null) {
                            C7174hd.this.f33029I.mo43788a();
                        }
                    }
                    if (C7174hd.this.f33058s != null) {
                        C7174hd c7174hd = C7174hd.this;
                        c7174hd.m43724g(c7174hd.f33058s.mo43648a(1, C7174hd.this.f33064y));
                    }
                }
            });
        }
    }

    /* renamed from: d */
    private void m43717d(LinkedNativeViewControlPanel linkedNativeViewControlPanel) {
        SeekBar seekBarM45510h = linkedNativeViewControlPanel.m45510h();
        this.f33044e = seekBarM45510h;
        if (seekBarM45510h != null) {
            m43778p();
            this.f33044e.setOnSeekBarChangeListener(this.f33038R);
        }
        this.f33050k = linkedNativeViewControlPanel.m45512j();
        this.f33051l = linkedNativeViewControlPanel.m45513k();
    }

    /* renamed from: c */
    public void m43757c(boolean z10) {
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "setCanAutoPlay %s", Boolean.valueOf(z10));
        this.f33059t = z10;
    }

    /* renamed from: e */
    public void m43763e(boolean z10) {
        AbstractC7185ho.m43820b("LinkedVideoControlBridge", "setMuteBtn: " + z10);
        ImageView imageViewM45508f = this.f33045f.m45508f();
        if (imageViewM45508f != null) {
            imageViewM45508f.setImageResource(AbstractC7811dd.m48287a(true, z10));
            imageViewM45508f.setSelected(!z10);
            AbstractC7811dd.m48296a(imageViewM45508f);
        }
    }

    /* renamed from: f */
    public void m43765f(boolean z10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("LinkedVideoControlBridge", "setPlayBtn: %s", Boolean.valueOf(z10));
        }
        if (this.f33046g == null) {
            return;
        }
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "isDetailViewVisible %s", Boolean.valueOf(this.f33030J.m43688d()));
        if (this.f33030J.m43688d()) {
            m43784v();
        } else {
            this.f33046g.setEnabled(z10);
        }
    }

    /* renamed from: g */
    public void m43767g(boolean z10) {
        if (z10) {
            m43749a((String) null);
            m43738a(0);
            m43756c(0);
            m43740a((Bitmap) null);
        }
        m43689A();
        m43783u();
    }

    /* renamed from: a */
    private void m43702a(int i10, String str, boolean z10) {
        int i11 = this.f33023C;
        if (i11 >= 1000 || i11 == 0 || z10) {
            AbstractC7185ho.m43821b("LinkedVideoControlBridge", "set progress from linked view, progress: %s, soundSwitch: %s ", Integer.valueOf(i10), str);
            C7169gz c7169gz = new C7169gz();
            c7169gz.m43661b(true);
            c7169gz.m43652a(i10);
            c7169gz.m43657a(str);
            C7171ha.m43673a(c7169gz);
            this.f33023C = 0;
            if (this.f33026F) {
                m43701a(i10, str);
            }
        }
    }

    /* renamed from: b */
    private void m43710b(String str) {
        C7171ha.m43674a(str);
    }

    /* renamed from: d */
    public void m43760d(boolean z10) {
        String str;
        AbstractC7185ho.m43820b("LinkedVideoControlBridge", "toggleMute: " + z10);
        if (this.f33043d == null || this.f33045f == null) {
            return;
        }
        m43763e(z10);
        if (z10) {
            this.f33043d.mute();
            str = "n";
        } else {
            this.f33043d.unmute();
            str = "y";
        }
        this.f33024D = str;
    }

    /* renamed from: a */
    private void m43703a(int i10, boolean z10, boolean z11) {
        if (z11 || this.f33030J.m43688d()) {
            m43762e(2);
        } else {
            m43762e(0);
        }
        m43722f(i10);
        m43758d();
        if (z11) {
            i10 = 0;
        }
        this.f33061v = i10;
        AbstractC7817dj.m48366a(this.f33040a);
        if (this.f33046g != null && LinkedNativeViewControlPanel.m45502a() != 0) {
            this.f33046g.setImageResource(LinkedNativeViewControlPanel.m45502a());
            AbstractC7811dd.m48296a(this.f33046g);
        }
        if (!z10) {
            m43689A();
            m43732l(false);
        }
        if (!z11) {
            m43783u();
        }
        m43776n();
    }

    /* renamed from: b */
    public void m43754b(boolean z10) {
        if (this.f33043d != null) {
            m43728j(z10);
            if (this.f33053n == 2 || this.f33063x == 0) {
                this.f33061v = 0;
                this.f33063x = 0;
                SeekBar seekBar = this.f33044e;
                if (seekBar != null) {
                    seekBar.setProgress(0);
                    this.f33043d.seekTo(this.f33063x);
                }
            }
            this.f33030J.m43687c();
            this.f33043d.setPreferStartPlayTime(this.f33061v);
            this.f33043d.play(z10);
        }
    }

    /* renamed from: a */
    public void m43739a(long j10) {
        VideoView videoView;
        AbstractC7185ho.m43821b("LinkedVideoControlBridge", "autoPlay - delayMs: %d", Long.valueOf(j10));
        AbstractC7817dj.m48366a(this.f33042c);
        if (!this.f33059t || (videoView = this.f33043d) == null) {
            return;
        }
        if (!videoView.isPlaying()) {
            AbstractC7185ho.m43817a("LinkedVideoControlBridge", "autoPlay - start delay runnable");
            AbstractC7817dj.m48365a(this.f33027G, this.f33042c, j10);
            return;
        }
        AbstractC7185ho.m43817a("LinkedVideoControlBridge", "autoPlay - video is playing");
        InterfaceC7168gy interfaceC7168gy = this.f33058s;
        if (interfaceC7168gy != null) {
            m43724g(interfaceC7168gy.mo43648a(2, this.f33064y));
        }
    }

    /* renamed from: a */
    public void m43740a(Bitmap bitmap) {
        ImageView imageView = this.f33055p;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    /* renamed from: a */
    public void m43741a(Drawable drawable) {
        ImageView imageView = this.f33055p;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    /* renamed from: a */
    public void m43742a(View.OnClickListener onClickListener) {
        this.f33028H = onClickListener;
    }

    /* renamed from: a */
    public void m43743a(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public void m43744a(TextView textView, int i10) {
        if (textView == null) {
            return;
        }
        int i11 = i10 / 1000;
        textView.setText(String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf((i11 % AsCache.TIME_HOUR) / 60), Integer.valueOf(i11 % 60)));
    }

    /* renamed from: a */
    public void m43745a(PPSActivity.InterfaceC6882b interfaceC6882b) {
        this.f33034N = interfaceC6882b;
    }

    /* renamed from: a */
    public void m43746a(InterfaceC7168gy interfaceC7168gy) {
        this.f33058s = interfaceC7168gy;
    }

    /* renamed from: a */
    public void m43747a(C7173hc c7173hc) {
        this.f33030J = c7173hc;
    }

    /* renamed from: a */
    public void m43748a(a aVar) {
        this.f33029I = aVar;
    }

    /* renamed from: a */
    private void m43706a(LinkedNativeViewControlPanel linkedNativeViewControlPanel) {
        this.f33045f = linkedNativeViewControlPanel;
        m43736z();
    }

    /* renamed from: a */
    private void m43707a(VideoView videoView) {
        this.f33043d = videoView;
    }

    /* renamed from: a */
    public void m43749a(String str) {
        VideoView videoView;
        if (this.f33045f == null || (videoView = this.f33043d) == null) {
            return;
        }
        videoView.setVideoFileUrl(str);
    }

    /* renamed from: a */
    public void m43750a(boolean z10) {
        this.f33026F = z10;
    }

    /* renamed from: a */
    private void m43708a(boolean z10, boolean z11) {
        VideoView videoView = this.f33043d;
        if (videoView == null || videoView.isPlaying()) {
            return;
        }
        m43766g();
        MediaState currentState = this.f33043d.getCurrentState();
        AbstractC7185ho.m43818a("LinkedVideoControlBridge", "currentState %s", currentState.toString());
        if (z11 || !currentState.isState(MediaState.State.PLAYBACK_COMPLETED)) {
            if (!currentState.m45811a()) {
                m43689A();
            }
            if (!z10) {
                AbstractC7817dj.m48366a(this.f33042c);
            }
            AbstractC7185ho.m43818a("LinkedVideoControlBridge", "playVideo, viewPaused is %s", Boolean.valueOf(this.f33062w));
            if ((this.f33059t || z11) && !this.f33062w) {
                m43754b(z10);
                m43762e(1);
            } else if (this.f33043d.isPlaying()) {
                return;
            } else {
                m43783u();
            }
            m43776n();
            m43785w();
        }
    }
}
