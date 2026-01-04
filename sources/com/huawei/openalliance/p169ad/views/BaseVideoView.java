package com.huawei.openalliance.p169ad.views;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.media.C7469b;
import com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaPlayerReleaseListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class BaseVideoView extends AutoScaleSizeRelativeLayout implements TextureView.SurfaceTextureListener, IViewLifeCycle {

    /* renamed from: A */
    private boolean f36321A;

    /* renamed from: B */
    private boolean f36322B;

    /* renamed from: C */
    private boolean f36323C;

    /* renamed from: D */
    private String f36324D;

    /* renamed from: E */
    private String[] f36325E;

    /* renamed from: F */
    private int f36326F;

    /* renamed from: G */
    private SparseBooleanArray f36327G;

    /* renamed from: H */
    private SurfaceListener f36328H;

    /* renamed from: I */
    private boolean f36329I;

    /* renamed from: J */
    private boolean f36330J;

    /* renamed from: K */
    private boolean f36331K;

    /* renamed from: L */
    private String f36332L;

    /* renamed from: M */
    private Context f36333M;

    /* renamed from: N */
    private C7022dk f36334N;

    /* renamed from: O */
    private boolean f36335O;

    /* renamed from: P */
    private C7469b f36336P;

    /* renamed from: Q */
    private MediaStateListener f36337Q;

    /* renamed from: R */
    private MediaBufferListener f36338R;

    /* renamed from: S */
    private PPSVideoRenderListener f36339S;

    /* renamed from: T */
    private MediaErrorListener f36340T;

    /* renamed from: U */
    private MuteListener f36341U;

    /* renamed from: V */
    private InterfaceC7470a f36342V;

    /* renamed from: W */
    private C7895e f36343W;

    /* renamed from: a */
    private final String f36344a;

    /* renamed from: aa */
    private C7892b f36345aa;

    /* renamed from: ab */
    private C7897g f36346ab;

    /* renamed from: ac */
    private C7893c f36347ac;

    /* renamed from: ad */
    private C7896f f36348ad;

    /* renamed from: ae */
    private C7894d f36349ae;

    /* renamed from: af */
    private BroadcastReceiver f36350af;

    /* renamed from: b */
    private int f36351b;

    /* renamed from: c */
    private IMultiMediaPlayingManager f36352c;

    /* renamed from: d */
    private final Set<NetworkChangeListener> f36353d;

    /* renamed from: e */
    private final Set<MediaStateListener> f36354e;

    /* renamed from: f */
    private final Set<MediaBufferListener> f36355f;

    /* renamed from: g */
    private final Set<MuteListener> f36356g;

    /* renamed from: h */
    private final Set<MediaErrorListener> f36357h;

    /* renamed from: i */
    private final Set<InterfaceC7470a> f36358i;

    /* renamed from: j */
    private final Set<SegmentMediaStateListener> f36359j;

    /* renamed from: k */
    protected TextureView f36360k;

    /* renamed from: l */
    protected boolean f36361l;

    /* renamed from: m */
    protected boolean f36362m;

    /* renamed from: n */
    protected MediaPlayerAgent f36363n;

    /* renamed from: o */
    protected MediaPlayerAgent f36364o;

    /* renamed from: p */
    protected Surface f36365p;

    /* renamed from: q */
    protected SurfaceTexture f36366q;

    /* renamed from: r */
    protected boolean f36367r;

    /* renamed from: s */
    protected int f36368s;

    /* renamed from: t */
    protected boolean f36369t;

    /* renamed from: u */
    protected MediaPlayer.OnVideoSizeChangedListener f36370u;

    /* renamed from: v */
    protected int f36371v;

    /* renamed from: w */
    protected int f36372w;

    /* renamed from: x */
    protected C7899i f36373x;

    /* renamed from: y */
    private final Set<SegmentMediaStateListener> f36374y;

    /* renamed from: z */
    private final Set<PPSVideoRenderListener> f36375z;

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$1 */
    public class C78831 implements MediaStateListener {
        public C78831() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
            BaseVideoView.this.m48760e(i10);
            if (BaseVideoView.this.m48762e()) {
                return;
            }
            BaseVideoView.this.m48782q();
            BaseVideoView.this.m48756d(mediaPlayerAgent, i10);
            if (BaseVideoView.this.f36336P != null) {
                BaseVideoView.this.f36336P.m45829a(i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
            BaseVideoView.this.m48782q();
            BaseVideoView.this.m48751c(i10);
            BaseVideoView.this.m48744b(mediaPlayerAgent, i10);
            if (BaseVideoView.this.f36336P != null) {
                BaseVideoView.this.f36336P.m45831b(i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
            if (BaseVideoView.this.f36323C) {
                BaseVideoView.this.setKeepScreenOn(true);
            }
            BaseVideoView.this.m48727a();
            BaseVideoView.this.m48741b(i10);
            BaseVideoView.this.m48731a(mediaPlayerAgent, i10);
            if (BaseVideoView.this.f36336P != null) {
                BaseVideoView.this.f36336P.m45827a();
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
            BaseVideoView.this.m48782q();
            BaseVideoView.this.m48755d(i10);
            BaseVideoView.this.m48752c(mediaPlayerAgent, i10);
            if (BaseVideoView.this.f36336P != null) {
                BaseVideoView.this.f36336P.m45828a(i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onProgress(int i10, int i11) {
            BaseVideoView.this.m48742b(i10, i11);
            BaseVideoView.this.m48729a(i10, i11);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$2 */
    public class C78842 implements MediaBufferListener {
        public C78842() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferUpdate(int i10) {
            BaseVideoView.this.m48728a(i10);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferingEnd() {
            BaseVideoView.this.m48775k();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferingStart() {
            BaseVideoView.this.m48772j();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$3 */
    public class C78853 implements PPSVideoRenderListener {
        public C78853() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
        public void onVideoRenderStart() {
            BaseVideoView.this.m48776l();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$4 */
    public class C78864 implements MediaErrorListener {
        public C78864() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
        public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
            BaseVideoView.this.m48782q();
            BaseVideoView.this.m48730a(i10, i11, i12);
            BaseVideoView.this.m48732a(mediaPlayerAgent, i10, i11, i12);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$5 */
    public class C78875 implements MuteListener {
        public C78875() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
        public void onMute() {
            BaseVideoView.this.f36330J = true;
            BaseVideoView.this.m48780n();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
        public void onUnmute() {
            BaseVideoView.this.f36330J = false;
            BaseVideoView.this.m48781o();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$6 */
    public class C78886 implements InterfaceC7470a {
        public C78886() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
        /* renamed from: a */
        public void mo45566a(int i10) {
            BaseVideoView.this.m48764f(i10);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
        /* renamed from: b */
        public void mo45567b(int i10) {
            BaseVideoView.this.m48767g(i10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$7 */
    public class RunnableC78897 implements Runnable {
        public RunnableC78897() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseVideoView baseVideoView = BaseVideoView.this;
            baseVideoView.f36373x.m48795a(baseVideoView.f36371v, baseVideoView.f36372w);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$8 */
    public class C78908 extends BroadcastReceiver {
        public C78908() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return;
                    }
                    AbstractC7185ho.m43821b(BaseVideoView.this.f36344a, "Build.VERSION: %s", Integer.valueOf(Build.VERSION.SDK_INT));
                    connectivityManager.registerDefaultNetworkCallback(new C7891a(BaseVideoView.this));
                } catch (Throwable unused) {
                    AbstractC7185ho.m43823c(BaseVideoView.this.f36344a, "fail to get networkChangeReceiver");
                }
            }
        }
    }

    @OuterVisible
    public interface SurfaceListener {
        void onSurfaceDestroyed();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$a */
    public static class C7891a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a */
        private WeakReference<BaseVideoView> f36384a;

        /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$a$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ BaseVideoView f36385a;

            /* renamed from: b */
            final /* synthetic */ boolean f36386b;

            public AnonymousClass1(BaseVideoView baseVideoView, boolean z10) {
                baseVideoView = baseVideoView;
                z = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                baseVideoView.m48738a(z);
            }
        }

        /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$a$2 */
        public class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ BaseVideoView f36388a;

            public AnonymousClass2(BaseVideoView baseVideoView) {
                baseVideoView = baseVideoView;
            }

            @Override // java.lang.Runnable
            public void run() {
                baseVideoView.m48778m();
            }
        }

        public C7891a(BaseVideoView baseVideoView) {
            this.f36384a = new WeakReference<>(baseVideoView);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            BaseVideoView baseVideoView = this.f36384a.get();
            if (baseVideoView == null) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.a.1

                /* renamed from: a */
                final /* synthetic */ BaseVideoView f36385a;

                /* renamed from: b */
                final /* synthetic */ boolean f36386b;

                public AnonymousClass1(BaseVideoView baseVideoView2, boolean z10) {
                    baseVideoView = baseVideoView2;
                    z = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    baseVideoView.m48738a(z);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            BaseVideoView baseVideoView = this.f36384a.get();
            if (baseVideoView == null) {
                return;
            }
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.a.2

                /* renamed from: a */
                final /* synthetic */ BaseVideoView f36388a;

                public AnonymousClass2(BaseVideoView baseVideoView2) {
                    baseVideoView = baseVideoView2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    baseVideoView.m48778m();
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$b */
    public static class C7892b implements MediaBufferListener {

        /* renamed from: a */
        private WeakReference<MediaBufferListener> f36390a;

        public C7892b(MediaBufferListener mediaBufferListener) {
            this.f36390a = new WeakReference<>(mediaBufferListener);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferUpdate(int i10) {
            MediaBufferListener mediaBufferListener = this.f36390a.get();
            if (mediaBufferListener != null) {
                mediaBufferListener.onBufferUpdate(i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferingEnd() {
            MediaBufferListener mediaBufferListener = this.f36390a.get();
            if (mediaBufferListener != null) {
                mediaBufferListener.onBufferingEnd();
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferingStart() {
            MediaBufferListener mediaBufferListener = this.f36390a.get();
            if (mediaBufferListener != null) {
                mediaBufferListener.onBufferingStart();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$c */
    public static class C7893c implements MediaErrorListener {

        /* renamed from: a */
        private WeakReference<MediaErrorListener> f36391a;

        public C7893c(MediaErrorListener mediaErrorListener) {
            this.f36391a = new WeakReference<>(mediaErrorListener);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
        public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
            MediaErrorListener mediaErrorListener = this.f36391a.get();
            if (mediaErrorListener != null) {
                mediaErrorListener.onError(mediaPlayerAgent, i10, i11, i12);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$d */
    public static class C7894d implements InterfaceC7470a {

        /* renamed from: a */
        private WeakReference<InterfaceC7470a> f36392a;

        public C7894d(InterfaceC7470a interfaceC7470a) {
            this.f36392a = new WeakReference<>(interfaceC7470a);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
        /* renamed from: a */
        public void mo45566a(int i10) {
            InterfaceC7470a interfaceC7470a = this.f36392a.get();
            if (interfaceC7470a != null) {
                interfaceC7470a.mo45566a(i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
        /* renamed from: b */
        public void mo45567b(int i10) {
            InterfaceC7470a interfaceC7470a = this.f36392a.get();
            if (interfaceC7470a != null) {
                interfaceC7470a.mo45567b(i10);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$e */
    public static class C7895e implements MediaStateListener {

        /* renamed from: a */
        private WeakReference<MediaStateListener> f36393a;

        public C7895e(MediaStateListener mediaStateListener) {
            this.f36393a = new WeakReference<>(mediaStateListener);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
            MediaStateListener mediaStateListener = this.f36393a.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaCompletion(mediaPlayerAgent, i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
            MediaStateListener mediaStateListener = this.f36393a.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaPause(mediaPlayerAgent, i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
            MediaStateListener mediaStateListener = this.f36393a.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaStart(mediaPlayerAgent, i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
            MediaStateListener mediaStateListener = this.f36393a.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaStop(mediaPlayerAgent, i10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onProgress(int i10, int i11) {
            MediaStateListener mediaStateListener = this.f36393a.get();
            if (mediaStateListener != null) {
                mediaStateListener.onProgress(i10, i11);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$f */
    public static class C7896f implements MuteListener {

        /* renamed from: a */
        private WeakReference<MuteListener> f36394a;

        public C7896f(MuteListener muteListener) {
            this.f36394a = new WeakReference<>(muteListener);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
        public void onMute() {
            MuteListener muteListener = this.f36394a.get();
            if (muteListener != null) {
                muteListener.onMute();
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
        public void onUnmute() {
            MuteListener muteListener = this.f36394a.get();
            if (muteListener != null) {
                muteListener.onUnmute();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$g */
    public static class C7897g implements PPSVideoRenderListener {

        /* renamed from: a */
        WeakReference<PPSVideoRenderListener> f36395a;

        public C7897g(PPSVideoRenderListener pPSVideoRenderListener) {
            this.f36395a = new WeakReference<>(pPSVideoRenderListener);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
        public void onVideoRenderStart() {
            PPSVideoRenderListener pPSVideoRenderListener = this.f36395a.get();
            if (pPSVideoRenderListener != null) {
                pPSVideoRenderListener.onVideoRenderStart();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$h */
    public static class C7898h implements MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a */
        private WeakReference<MediaPlayer.OnVideoSizeChangedListener> f36396a;

        public C7898h(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.f36396a = new WeakReference<>(onVideoSizeChangedListener);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f36396a.get();
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i10, i11);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$i */
    public class C7899i implements MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a */
        float f36397a = 0.0f;

        /* renamed from: b */
        float f36398b = 0.0f;

        /* renamed from: com.huawei.openalliance.ad.views.BaseVideoView$i$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f36400a;

            /* renamed from: b */
            final /* synthetic */ int f36401b;

            public AnonymousClass1(int i10, int i11) {
                i = i10;
                i = i11;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7899i.this.m48795a(i, i);
            }
        }

        public C7899i() {
        }

        /* renamed from: a */
        public void m48795a(int i10, int i11) {
            AbstractC7185ho.m43820b(BaseVideoView.this.f36344a, "video size changed - w: " + i10 + " h: " + i11);
            if (i10 == 0 || i11 == 0) {
                return;
            }
            BaseVideoView baseVideoView = BaseVideoView.this;
            baseVideoView.f36371v = i10;
            baseVideoView.f36372w = i11;
            float f10 = (i10 * 1.0f) / i11;
            float fAbs = Math.abs(f10 - this.f36397a);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a(BaseVideoView.this.f36344a, "video ratio: %s oldRatio: %s diff: %s", Float.valueOf(f10), Float.valueOf(this.f36397a), Float.valueOf(fAbs));
            }
            this.f36397a = f10;
            if (BaseVideoView.this.f36329I) {
                if (fAbs > 0.01f) {
                    AbstractC7185ho.m43817a(BaseVideoView.this.f36344a, "set video ratio");
                    BaseVideoView.this.setRatio(Float.valueOf(f10));
                    BaseVideoView.this.requestLayout();
                    return;
                }
                return;
            }
            int width = BaseVideoView.this.getWidth();
            int height = BaseVideoView.this.getHeight();
            AbstractC7185ho.m43820b(BaseVideoView.this.f36344a, "resizeVideo view width: " + width + " height: " + height);
            if (height == 0 || width == 0) {
                return;
            }
            float f11 = (width * 1.0f) / height;
            float fAbs2 = Math.abs(f11 - this.f36398b);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a(BaseVideoView.this.f36344a, "view ratio: %s oldRatio: %s diff: %s", Float.valueOf(f11), Float.valueOf(this.f36398b), Float.valueOf(fAbs2));
            }
            this.f36398b = f11;
            if (fAbs2 > 0.01f) {
                BaseVideoView.this.mo48785a(f10, f11, width, height);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.i.1

                /* renamed from: a */
                final /* synthetic */ int f36400a;

                /* renamed from: b */
                final /* synthetic */ int f36401b;

                public AnonymousClass1(int i102, int i112) {
                    i = i102;
                    i = i112;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C7899i.this.m48795a(i, i);
                }
            });
        }
    }

    @OuterVisible
    public BaseVideoView(Context context) {
        super(context);
        this.f36344a = getClass().getSimpleName();
        this.f36351b = 0;
        this.f36353d = new CopyOnWriteArraySet();
        this.f36354e = new CopyOnWriteArraySet();
        this.f36355f = new CopyOnWriteArraySet();
        this.f36356g = new CopyOnWriteArraySet();
        this.f36357h = new CopyOnWriteArraySet();
        this.f36358i = new CopyOnWriteArraySet();
        this.f36359j = new CopyOnWriteArraySet();
        this.f36374y = new CopyOnWriteArraySet();
        this.f36375z = new CopyOnWriteArraySet();
        this.f36321A = true;
        this.f36322B = false;
        this.f36323C = false;
        this.f36327G = new SparseBooleanArray(3);
        this.f36368s = 1;
        this.f36329I = true;
        this.f36369t = true;
        this.f36330J = false;
        this.f36335O = false;
        this.f36373x = new C7899i();
        this.f36337Q = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            public C78831() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                BaseVideoView.this.m48760e(i10);
                if (BaseVideoView.this.m48762e()) {
                    return;
                }
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48756d(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45829a(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48751c(i10);
                BaseVideoView.this.m48744b(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45831b(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (BaseVideoView.this.f36323C) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.m48727a();
                BaseVideoView.this.m48741b(i10);
                BaseVideoView.this.m48731a(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45827a();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48755d(i10);
                BaseVideoView.this.m48752c(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45828a(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                BaseVideoView.this.m48742b(i10, i11);
                BaseVideoView.this.m48729a(i10, i11);
            }
        };
        this.f36338R = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            public C78842() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
                BaseVideoView.this.m48728a(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                BaseVideoView.this.m48775k();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                BaseVideoView.this.m48772j();
            }
        };
        this.f36339S = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            public C78853() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                BaseVideoView.this.m48776l();
            }
        };
        this.f36340T = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            public C78864() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48730a(i10, i11, i12);
                BaseVideoView.this.m48732a(mediaPlayerAgent, i10, i11, i12);
            }
        };
        this.f36341U = new MuteListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            public C78875() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                BaseVideoView.this.f36330J = true;
                BaseVideoView.this.m48780n();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                BaseVideoView.this.f36330J = false;
                BaseVideoView.this.m48781o();
            }
        };
        this.f36342V = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            public C78886() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                BaseVideoView.this.m48764f(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
                BaseVideoView.this.m48767g(i10);
            }
        };
        this.f36343W = new C7895e(this.f36337Q);
        this.f36345aa = new C7892b(this.f36338R);
        this.f36346ab = new C7897g(this.f36339S);
        this.f36347ac = new C7893c(this.f36340T);
        this.f36348ad = new C7896f(this.f36341U);
        this.f36349ae = new C7894d(this.f36342V);
        this.f36350af = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            public C78908() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            return;
                        }
                        AbstractC7185ho.m43821b(BaseVideoView.this.f36344a, "Build.VERSION: %s", Integer.valueOf(Build.VERSION.SDK_INT));
                        connectivityManager.registerDefaultNetworkCallback(new C7891a(BaseVideoView.this));
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c(BaseVideoView.this.f36344a, "fail to get networkChangeReceiver");
                    }
                }
            }
        };
        m48743b(context);
    }

    /* renamed from: b */
    public void m48741b(int i10) {
        Iterator<SegmentMediaStateListener> it = this.f36374y.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaStart(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<SegmentMediaStateListener> it2 = this.f36359j.iterator();
        while (it2.hasNext()) {
            it2.next().onSegmentMediaStart(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* renamed from: e */
    public void m48760e(int i10) {
        Iterator<SegmentMediaStateListener> it = this.f36374y.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaCompletion(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<SegmentMediaStateListener> it2 = this.f36359j.iterator();
        while (it2.hasNext()) {
            it2.next().onSegmentMediaCompletion(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    private String getCurrentVideoUrl() {
        if (this.f36326F < getVideoFileUrlArrayLength()) {
            return this.f36325E[this.f36326F];
        }
        return null;
    }

    private MediaPlayerAgent getNextPlayerAgent() {
        if (this.f36364o == null) {
            MediaPlayerAgent mediaPlayerAgent = new MediaPlayerAgent(getContext());
            this.f36364o = mediaPlayerAgent;
            mediaPlayerAgent.acquire();
        }
        return this.f36364o;
    }

    private String getNextVideoUrl() {
        int i10 = this.f36326F + 1;
        if (i10 < getVideoFileUrlArrayLength()) {
            return this.f36325E[i10];
        }
        return null;
    }

    private int getVideoFileUrlArrayLength() {
        String[] strArr = this.f36325E;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    /* renamed from: j */
    public void m48772j() {
        Iterator<MediaBufferListener> it = this.f36355f.iterator();
        while (it.hasNext()) {
            it.next().onBufferingStart();
        }
    }

    /* renamed from: l */
    public void m48776l() {
        Iterator<PPSVideoRenderListener> it = this.f36375z.iterator();
        while (it.hasNext()) {
            it.next().onVideoRenderStart();
        }
    }

    /* renamed from: m */
    public void m48778m() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f36344a, "notifyNetworkDisconnected");
        }
        Iterator<NetworkChangeListener> it = this.f36353d.iterator();
        while (it.hasNext()) {
            it.next().onNetworkDisconnected();
        }
    }

    /* renamed from: n */
    public void m48780n() {
        Iterator<MuteListener> it = this.f36356g.iterator();
        while (it.hasNext()) {
            it.next().onMute();
        }
    }

    /* renamed from: o */
    public void m48781o() {
        Iterator<MuteListener> it = this.f36356g.iterator();
        while (it.hasNext()) {
            it.next().onUnmute();
        }
    }

    /* renamed from: q */
    public void m48782q() {
        if (this.f36323C) {
            setKeepScreenOn(false);
        }
    }

    /* renamed from: a */
    public MediaPlayerAgent m48783a(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            AbstractC7185ho.m43823c(this.f36344a, "no agent to switch");
            return null;
        }
        MediaPlayerAgent mediaPlayerAgent2 = this.f36363n;
        if (mediaPlayerAgent2 != null) {
            mediaPlayerAgent2.removeMediaStateListener(this.f36343W);
            mediaPlayerAgent2.removeMediaBufferListener(this.f36345aa);
            mediaPlayerAgent2.removePPSVideoRenderListener(this.f36346ab);
            mediaPlayerAgent2.removeMediaErrorListener(this.f36347ac);
            mediaPlayerAgent2.removeMuteListener(this.f36348ad);
            mediaPlayerAgent2.removeMediaInfoListener(this.f36349ae);
            mediaPlayerAgent2.setSurface(null);
        }
        mediaPlayerAgent.addMediaStateListener(this.f36343W);
        mediaPlayerAgent.addMediaBufferListener(this.f36345aa);
        mediaPlayerAgent.m45799a(this.f36346ab);
        mediaPlayerAgent.addMediaErrorListener(this.f36347ac);
        mediaPlayerAgent.addMuteListener(this.f36348ad);
        mediaPlayerAgent.addMediaInfoListener(this.f36349ae);
        mediaPlayerAgent.m45800a(this.f36331K);
        mediaPlayerAgent.m45795a(this.f36351b);
        Surface surface = this.f36365p;
        if (surface != null) {
            mediaPlayerAgent.setSurface(surface);
        }
        this.f36363n = mediaPlayerAgent;
        return mediaPlayerAgent2;
    }

    @OuterVisible
    public void addMediaBufferListener(MediaBufferListener mediaBufferListener) {
        if (mediaBufferListener == null) {
            return;
        }
        this.f36355f.add(mediaBufferListener);
    }

    @OuterVisible
    public void addMediaErrorListener(MediaErrorListener mediaErrorListener) {
        if (mediaErrorListener == null) {
            return;
        }
        this.f36357h.add(mediaErrorListener);
    }

    @OuterVisible
    public void addMediaInfoListener(InterfaceC7470a interfaceC7470a) {
        if (interfaceC7470a == null) {
            return;
        }
        this.f36358i.add(interfaceC7470a);
    }

    @OuterVisible
    public void addMediaStateListener(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.f36354e.add(mediaStateListener);
    }

    @OuterVisible
    public void addMuteListener(MuteListener muteListener) {
        if (muteListener == null) {
            return;
        }
        this.f36356g.add(muteListener);
    }

    @OuterVisible
    public void addNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        if (networkChangeListener == null) {
            return;
        }
        this.f36353d.add(networkChangeListener);
    }

    @OuterVisible
    public void addOmSegmentMediaStateListener(SegmentMediaStateListener segmentMediaStateListener) {
        if (segmentMediaStateListener != null) {
            this.f36374y.add(segmentMediaStateListener);
        }
    }

    @OuterVisible
    public void addPPSVideoRenderListener(PPSVideoRenderListener pPSVideoRenderListener) {
        if (pPSVideoRenderListener == null) {
            return;
        }
        this.f36375z.add(pPSVideoRenderListener);
    }

    @OuterVisible
    public void addReportVideoTimeListenersSet(ReportVideoTimeListener reportVideoTimeListener) {
        if (this.f36336P == null) {
            this.f36336P = new C7469b(this.f36333M);
        }
        this.f36336P.m45830a(reportVideoTimeListener);
    }

    @OuterVisible
    public void addSegmentMediaStateListener(SegmentMediaStateListener segmentMediaStateListener) {
        if (segmentMediaStateListener != null) {
            this.f36359j.add(segmentMediaStateListener);
        }
    }

    /* renamed from: d */
    public void mo48790d() {
        TextureView textureView = this.f36360k;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            ViewParent parent = this.f36360k.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f36360k);
            }
            TextureView textureView2 = new TextureView(getContext());
            this.f36360k = textureView2;
            textureView2.setSurfaceTextureListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f36360k, layoutParams);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f36363n.removeVideoSizeChangeListener(this.f36370u);
        if (!this.f36321A) {
            this.f36352c.removeMediaPlayerAgent(this.f36363n);
        }
        this.f36363n.release();
        MediaPlayerAgent mediaPlayerAgent = this.f36364o;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.release();
        }
    }

    /* renamed from: f */
    public void m48791f() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager;
        AbstractC7185ho.m43820b(this.f36344a, "resetVideoView");
        if (this.f36363n.getInstanceRefCount() <= 1) {
            this.f36363n.setSurface(null);
            this.f36363n.reset();
            if (!this.f36321A && (iMultiMediaPlayingManager = this.f36352c) != null) {
                iMultiMediaPlayingManager.removeMediaPlayerAgent(this.f36363n);
            }
        }
        MediaPlayerAgent mediaPlayerAgent = this.f36364o;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.setSurface(null);
            this.f36364o.reset();
        }
        Surface surface = this.f36365p;
        if (surface != null) {
            surface.release();
            this.f36365p = null;
        }
        SurfaceTexture surfaceTexture = this.f36366q;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.f36366q = null;
        this.f36361l = false;
    }

    /* renamed from: g */
    public void m48792g() {
        SurfaceListener surfaceListener = this.f36328H;
        if (surfaceListener != null) {
            surfaceListener.onSurfaceDestroyed();
        }
    }

    public String getContentId() {
        return this.f36332L;
    }

    @OuterVisible
    public int getCurrentPosition() {
        return this.f36363n.getCurrentPlayPosition();
    }

    @OuterVisible
    public MediaState getCurrentState() {
        return this.f36363n.getCurrentState();
    }

    public MediaPlayerAgent getMediaPlayerAgent() {
        return this.f36363n;
    }

    public MediaState getMediaState() {
        MediaPlayerAgent mediaPlayerAgent = this.f36363n;
        if (mediaPlayerAgent != null) {
            return mediaPlayerAgent.getCurrentState();
        }
        return null;
    }

    public int getVideoHeight() {
        return this.f36372w;
    }

    public int getVideoWidth() {
        return this.f36371v;
    }

    /* renamed from: h */
    public void m48793h() {
        this.f36363n.m45802b();
    }

    /* renamed from: i */
    public void m48794i() {
        MediaPlayerAgent mediaPlayerAgent = this.f36363n;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.release();
        }
    }

    @OuterVisible
    public boolean isPlaying() {
        return this.f36363n.isPlaying();
    }

    @OuterVisible
    public void mute() {
        AbstractC7185ho.m43820b(this.f36344a, "mute");
        this.f36363n.muteSound();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            AbstractC7185ho.m43826d(this.f36344a, "hardware acceleration is off");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        HiAd.m44014a(getContext()).mo44043a(this.f36350af, intentFilter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        String str;
        String str2;
        super.onDetachedFromWindow();
        try {
            HiAd.m44014a(getContext()).mo44042a(this.f36350af);
        } catch (IllegalStateException unused) {
            str = this.f36344a;
            str2 = "unregisterReceiver IllegalArgumentException";
            AbstractC7185ho.m43823c(str, str2);
        } catch (Exception unused2) {
            str = this.f36344a;
            str2 = "unregisterReceiver Exception";
            AbstractC7185ho.m43823c(str, str2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(this.f36344a, "onSurfaceTextureSizeChanged width: %d height: %d", Integer.valueOf(i10), Integer.valueOf(i11));
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.7
            public RunnableC78897() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseVideoView baseVideoView = BaseVideoView.this;
                baseVideoView.f36373x.m48795a(baseVideoView.f36371v, baseVideoView.f36372w);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.huawei.openalliance.p169ad.views.AutoScaleSizeRelativeLayout
    /* renamed from: p */
    public boolean mo48725p() {
        return this.f36335O;
    }

    @OuterVisible
    public void pause() {
        AbstractC7185ho.m43820b(this.f36344a, "pause standalone " + this.f36321A);
        this.f36361l = false;
        if (this.f36321A) {
            this.f36363n.pause();
        } else {
            this.f36352c.pause(this.f36324D, this.f36363n);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        this.f36322B = true;
        this.f36363n.m45802b();
    }

    @OuterVisible
    public void play() {
        play(false);
    }

    @OuterVisible
    public void prefetch() {
        this.f36363n.prepare();
    }

    @OuterVisible
    public void removeMediaBufferListener(MediaBufferListener mediaBufferListener) {
        if (mediaBufferListener == null) {
            return;
        }
        this.f36355f.remove(mediaBufferListener);
    }

    @OuterVisible
    public void removeMediaErrorListener(MediaErrorListener mediaErrorListener) {
        if (mediaErrorListener == null) {
            return;
        }
        this.f36357h.remove(mediaErrorListener);
    }

    @OuterVisible
    public void removeMediaInfoListener(InterfaceC7470a interfaceC7470a) {
        if (interfaceC7470a == null) {
            return;
        }
        this.f36358i.remove(interfaceC7470a);
    }

    @OuterVisible
    public void removeMediaStateListener(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.f36354e.remove(mediaStateListener);
    }

    @OuterVisible
    public void removeMuteListener(MuteListener muteListener) {
        if (muteListener == null) {
            return;
        }
        this.f36356g.remove(muteListener);
    }

    @OuterVisible
    public void removeNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        if (networkChangeListener == null) {
            return;
        }
        this.f36353d.remove(networkChangeListener);
    }

    @OuterVisible
    public void removeOmSegmentMediaStateListener(SegmentMediaStateListener segmentMediaStateListener) {
        if (segmentMediaStateListener != null) {
            this.f36374y.remove(segmentMediaStateListener);
        }
    }

    @OuterVisible
    public void removePPSVideoRenderListener(PPSVideoRenderListener pPSVideoRenderListener) {
        if (pPSVideoRenderListener == null) {
            return;
        }
        this.f36375z.remove(pPSVideoRenderListener);
    }

    @OuterVisible
    public void removeSegmentMediaStateListener(SegmentMediaStateListener segmentMediaStateListener) {
        if (segmentMediaStateListener != null) {
            this.f36359j.remove(segmentMediaStateListener);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        this.f36322B = false;
    }

    @OuterVisible
    public void seekTo(int i10) {
        this.f36363n.seekTo(i10);
    }

    public void setAudioFocusType(int i10) {
        this.f36351b = i10;
        this.f36363n.m45795a(i10);
    }

    @OuterVisible
    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z10) {
        this.f36329I = z10;
    }

    public void setContentId(String str) {
        this.f36332L = str;
    }

    @OuterVisible
    public void setDefaultDuration(int i10) {
        this.f36363n.setDefaultDuration(i10);
    }

    @OuterVisible
    public void setMediaPlayerAgent(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            return;
        }
        mediaPlayerAgent.acquire();
        MediaPlayerAgent mediaPlayerAgentM48783a = m48783a(mediaPlayerAgent);
        if (mediaPlayerAgentM48783a != null) {
            mediaPlayerAgentM48783a.release();
        }
    }

    public void setMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        MediaPlayerAgent mediaPlayerAgent = this.f36363n;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.setMediaPlayerReleaseListener(mediaPlayerReleaseListener);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z10) {
        this.f36331K = z10;
        this.f36363n.m45800a(z10);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z10) {
        this.f36369t = z10;
    }

    @OuterVisible
    public void setPreferStartPlayTime(int i10) {
        this.f36363n.setPreferStartPlayTime(i10);
    }

    public void setRemediate(boolean z10) {
        this.f36335O = z10;
    }

    @OuterVisible
    public void setScreenOnWhilePlaying(boolean z10) {
        this.f36323C = z10;
        setKeepScreenOn(z10 && getCurrentState().isState(MediaState.State.PLAYING));
    }

    public void setSoundVolume(float f10) {
        this.f36363n.setSoundVolume(f10);
    }

    @OuterVisible
    public void setStandalone(boolean z10) {
        this.f36321A = z10;
    }

    @OuterVisible
    public void setSurfaceListener(SurfaceListener surfaceListener) {
        this.f36328H = surfaceListener;
    }

    @OuterVisible
    public void setVideoFileUrl(String str) {
        m48788a(str, true);
    }

    @OuterVisible
    public void setVideoFileUrls(String[] strArr) {
        String[] strArr2 = strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : null;
        this.f36325E = strArr2;
        this.f36326F = 0;
        this.f36327G.clear();
        if (strArr2 == null || strArr2.length <= 0) {
            this.f36324D = null;
            AbstractC7185ho.m43823c(this.f36344a, "setVideoFileUrls - url array is empty");
        } else {
            AbstractC7185ho.m43821b(this.f36344a, "setVideoFileUrls - size: %d", Integer.valueOf(strArr2.length));
            String str = strArr2[this.f36326F];
            this.f36324D = str;
            this.f36363n.setMediaFile(str);
        }
    }

    @OuterVisible
    public void setVideoScaleMode(int i10) {
        if (i10 == 1 || i10 == 2) {
            this.f36368s = i10;
            return;
        }
        throw new IllegalArgumentException("Not supported video scale mode: " + i10);
    }

    @OuterVisible
    public void stop() {
        AbstractC7185ho.m43820b(this.f36344a, "stop standalone " + this.f36321A);
        this.f36361l = false;
        if (this.f36321A) {
            this.f36363n.stop();
        } else {
            this.f36352c.stop(this.f36324D, this.f36363n);
        }
    }

    @OuterVisible
    public void unmute() {
        AbstractC7185ho.m43820b(this.f36344a, "unmute");
        this.f36363n.unmuteSound();
    }

    @OuterVisible
    public BaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36344a = getClass().getSimpleName();
        this.f36351b = 0;
        this.f36353d = new CopyOnWriteArraySet();
        this.f36354e = new CopyOnWriteArraySet();
        this.f36355f = new CopyOnWriteArraySet();
        this.f36356g = new CopyOnWriteArraySet();
        this.f36357h = new CopyOnWriteArraySet();
        this.f36358i = new CopyOnWriteArraySet();
        this.f36359j = new CopyOnWriteArraySet();
        this.f36374y = new CopyOnWriteArraySet();
        this.f36375z = new CopyOnWriteArraySet();
        this.f36321A = true;
        this.f36322B = false;
        this.f36323C = false;
        this.f36327G = new SparseBooleanArray(3);
        this.f36368s = 1;
        this.f36329I = true;
        this.f36369t = true;
        this.f36330J = false;
        this.f36335O = false;
        this.f36373x = new C7899i();
        this.f36337Q = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            public C78831() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                BaseVideoView.this.m48760e(i10);
                if (BaseVideoView.this.m48762e()) {
                    return;
                }
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48756d(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45829a(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48751c(i10);
                BaseVideoView.this.m48744b(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45831b(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (BaseVideoView.this.f36323C) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.m48727a();
                BaseVideoView.this.m48741b(i10);
                BaseVideoView.this.m48731a(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45827a();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48755d(i10);
                BaseVideoView.this.m48752c(mediaPlayerAgent, i10);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45828a(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                BaseVideoView.this.m48742b(i10, i11);
                BaseVideoView.this.m48729a(i10, i11);
            }
        };
        this.f36338R = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            public C78842() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
                BaseVideoView.this.m48728a(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                BaseVideoView.this.m48775k();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                BaseVideoView.this.m48772j();
            }
        };
        this.f36339S = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            public C78853() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                BaseVideoView.this.m48776l();
            }
        };
        this.f36340T = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            public C78864() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48730a(i10, i11, i12);
                BaseVideoView.this.m48732a(mediaPlayerAgent, i10, i11, i12);
            }
        };
        this.f36341U = new MuteListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            public C78875() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                BaseVideoView.this.f36330J = true;
                BaseVideoView.this.m48780n();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                BaseVideoView.this.f36330J = false;
                BaseVideoView.this.m48781o();
            }
        };
        this.f36342V = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            public C78886() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                BaseVideoView.this.m48764f(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
                BaseVideoView.this.m48767g(i10);
            }
        };
        this.f36343W = new C7895e(this.f36337Q);
        this.f36345aa = new C7892b(this.f36338R);
        this.f36346ab = new C7897g(this.f36339S);
        this.f36347ac = new C7893c(this.f36340T);
        this.f36348ad = new C7896f(this.f36341U);
        this.f36349ae = new C7894d(this.f36342V);
        this.f36350af = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            public C78908() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            return;
                        }
                        AbstractC7185ho.m43821b(BaseVideoView.this.f36344a, "Build.VERSION: %s", Integer.valueOf(Build.VERSION.SDK_INT));
                        connectivityManager.registerDefaultNetworkCallback(new C7891a(BaseVideoView.this));
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c(BaseVideoView.this.f36344a, "fail to get networkChangeReceiver");
                    }
                }
            }
        };
        m48743b(context);
    }

    /* renamed from: a */
    private String m48726a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Scheme.DISKCACHE.toString()) || str.startsWith(Scheme.DATAPARTITION.toString())) {
            AbstractC7185ho.m43820b(this.f36344a, "video cached, play from local.");
            return str;
        }
        String strM41968c = this.f36334N.m41968c(C7022dk.m41953d(str));
        if (TextUtils.isEmpty(strM41968c) || !AbstractC7731ae.m47456b(this.f36333M, strM41968c)) {
            AbstractC7185ho.m43820b(this.f36344a, "video not cached, play from net.");
            return str;
        }
        AbstractC7185ho.m43820b(this.f36344a, "video cached, play from local.");
        return strM41968c;
    }

    /* renamed from: b */
    public void m48742b(int i10, int i11) {
        Iterator<SegmentMediaStateListener> it = this.f36374y.iterator();
        while (it.hasNext()) {
            it.next().onSegmentProgress(getContentId(), getCurrentVideoUrl(), i10, i11);
        }
        Iterator<SegmentMediaStateListener> it2 = this.f36359j.iterator();
        while (it2.hasNext()) {
            it2.next().onSegmentProgress(getContentId(), getCurrentVideoUrl(), i10, i11);
        }
    }

    /* renamed from: c */
    public void m48751c(int i10) {
        Iterator<SegmentMediaStateListener> it = this.f36374y.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaPause(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<SegmentMediaStateListener> it2 = this.f36359j.iterator();
        while (it2.hasNext()) {
            it2.next().onSegmentMediaPause(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* renamed from: d */
    public void m48755d(int i10) {
        Iterator<SegmentMediaStateListener> it = this.f36374y.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaStop(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<SegmentMediaStateListener> it2 = this.f36359j.iterator();
        while (it2.hasNext()) {
            it2.next().onSegmentMediaStop(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* renamed from: f */
    public void m48764f(int i10) {
        Iterator<InterfaceC7470a> it = this.f36358i.iterator();
        while (it.hasNext()) {
            it.next().mo45566a(i10);
        }
    }

    /* renamed from: g */
    public void m48767g(int i10) {
        Iterator<InterfaceC7470a> it = this.f36358i.iterator();
        while (it.hasNext()) {
            it.next().mo45567b(i10);
        }
    }

    /* renamed from: k */
    public void m48775k() {
        Iterator<MediaBufferListener> it = this.f36355f.iterator();
        while (it.hasNext()) {
            it.next().onBufferingEnd();
        }
    }

    @OuterVisible
    public void play(long j10) {
        play(false, Long.valueOf(j10));
    }

    @OuterVisible
    public BaseVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36344a = getClass().getSimpleName();
        this.f36351b = 0;
        this.f36353d = new CopyOnWriteArraySet();
        this.f36354e = new CopyOnWriteArraySet();
        this.f36355f = new CopyOnWriteArraySet();
        this.f36356g = new CopyOnWriteArraySet();
        this.f36357h = new CopyOnWriteArraySet();
        this.f36358i = new CopyOnWriteArraySet();
        this.f36359j = new CopyOnWriteArraySet();
        this.f36374y = new CopyOnWriteArraySet();
        this.f36375z = new CopyOnWriteArraySet();
        this.f36321A = true;
        this.f36322B = false;
        this.f36323C = false;
        this.f36327G = new SparseBooleanArray(3);
        this.f36368s = 1;
        this.f36329I = true;
        this.f36369t = true;
        this.f36330J = false;
        this.f36335O = false;
        this.f36373x = new C7899i();
        this.f36337Q = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            public C78831() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                BaseVideoView.this.m48760e(i102);
                if (BaseVideoView.this.m48762e()) {
                    return;
                }
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48756d(mediaPlayerAgent, i102);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45829a(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48751c(i102);
                BaseVideoView.this.m48744b(mediaPlayerAgent, i102);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45831b(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (BaseVideoView.this.f36323C) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.m48727a();
                BaseVideoView.this.m48741b(i102);
                BaseVideoView.this.m48731a(mediaPlayerAgent, i102);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45827a();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48755d(i102);
                BaseVideoView.this.m48752c(mediaPlayerAgent, i102);
                if (BaseVideoView.this.f36336P != null) {
                    BaseVideoView.this.f36336P.m45828a(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i11) {
                BaseVideoView.this.m48742b(i102, i11);
                BaseVideoView.this.m48729a(i102, i11);
            }
        };
        this.f36338R = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            public C78842() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
                BaseVideoView.this.m48728a(i102);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                BaseVideoView.this.m48775k();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                BaseVideoView.this.m48772j();
            }
        };
        this.f36339S = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            public C78853() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                BaseVideoView.this.m48776l();
            }
        };
        this.f36340T = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            public C78864() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i11, int i12) {
                BaseVideoView.this.m48782q();
                BaseVideoView.this.m48730a(i102, i11, i12);
                BaseVideoView.this.m48732a(mediaPlayerAgent, i102, i11, i12);
            }
        };
        this.f36341U = new MuteListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            public C78875() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                BaseVideoView.this.f36330J = true;
                BaseVideoView.this.m48780n();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                BaseVideoView.this.f36330J = false;
                BaseVideoView.this.m48781o();
            }
        };
        this.f36342V = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            public C78886() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i102) {
                BaseVideoView.this.m48764f(i102);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i102) {
                BaseVideoView.this.m48767g(i102);
            }
        };
        this.f36343W = new C7895e(this.f36337Q);
        this.f36345aa = new C7892b(this.f36338R);
        this.f36346ab = new C7897g(this.f36339S);
        this.f36347ac = new C7893c(this.f36340T);
        this.f36348ad = new C7896f(this.f36341U);
        this.f36349ae = new C7894d(this.f36342V);
        this.f36350af = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            public C78908() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            return;
                        }
                        AbstractC7185ho.m43821b(BaseVideoView.this.f36344a, "Build.VERSION: %s", Integer.valueOf(Build.VERSION.SDK_INT));
                        connectivityManager.registerDefaultNetworkCallback(new C7891a(BaseVideoView.this));
                    } catch (Throwable unused) {
                        AbstractC7185ho.m43823c(BaseVideoView.this.f36344a, "fail to get networkChangeReceiver");
                    }
                }
            }
        };
        m48743b(context);
    }

    /* renamed from: a */
    public void m48727a() {
        String nextVideoUrl = getNextVideoUrl();
        if (nextVideoUrl == null) {
            AbstractC7185ho.m43821b(this.f36344a, "no next video url need to prepare, current: %d", Integer.valueOf(this.f36326F));
            return;
        }
        int i10 = this.f36326F + 1;
        if (this.f36327G.get(i10)) {
            AbstractC7185ho.m43821b(this.f36344a, "player for url %d is already set", Integer.valueOf(i10));
            return;
        }
        AbstractC7185ho.m43821b(this.f36344a, "prepare to set next player[%d]", Integer.valueOf(i10));
        MediaPlayerAgent nextPlayerAgent = getNextPlayerAgent();
        nextPlayerAgent.setMediaFile(nextVideoUrl);
        nextPlayerAgent.prepare();
        this.f36327G.put(i10, true);
    }

    /* renamed from: b */
    private void m48743b(Context context) {
        this.f36333M = context;
        setBackgroundColor(-16777216);
        this.f36352c = HiAd.m44014a(context).mo44049c();
        setMediaPlayerAgent(new MediaPlayerAgent(context));
        mo48786a(context);
        this.f36334N = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
    }

    /* renamed from: d */
    public void m48756d(MediaPlayerAgent mediaPlayerAgent, int i10) {
        Iterator<MediaStateListener> it = this.f36354e.iterator();
        while (it.hasNext()) {
            it.next().onMediaCompletion(mediaPlayerAgent, i10);
        }
    }

    /* renamed from: e */
    public boolean m48762e() {
        String nextVideoUrl;
        int i10 = this.f36326F + 1;
        if (!this.f36327G.get(i10) || (nextVideoUrl = getNextVideoUrl()) == null) {
            AbstractC7185ho.m43821b(this.f36344a, "no next player to switch, current: %d", Integer.valueOf(this.f36326F));
            return false;
        }
        this.f36324D = nextVideoUrl;
        this.f36364o = m48783a(getNextPlayerAgent());
        if (!TextUtils.equals(nextVideoUrl, this.f36363n.m45793a())) {
            this.f36363n.setMediaFile(nextVideoUrl);
        }
        if (this.f36330J) {
            this.f36363n.muteSound();
        } else {
            this.f36363n.unmuteSound();
        }
        this.f36363n.play();
        this.f36326F = i10;
        AbstractC7185ho.m43821b(this.f36344a, "switch to next player [%d] and play", Integer.valueOf(i10));
        return true;
    }

    /* renamed from: c */
    public void m48789c(int i10, int i11) {
        this.f36363n.seekTo(i10, i11);
    }

    @OuterVisible
    public void play(boolean z10) {
        play(z10, null);
    }

    /* renamed from: b */
    public void m48744b(MediaPlayerAgent mediaPlayerAgent, int i10) {
        Iterator<MediaStateListener> it = this.f36354e.iterator();
        while (it.hasNext()) {
            it.next().onMediaPause(mediaPlayerAgent, i10);
        }
    }

    /* renamed from: c */
    public void m48752c(MediaPlayerAgent mediaPlayerAgent, int i10) {
        Iterator<MediaStateListener> it = this.f36354e.iterator();
        while (it.hasNext()) {
            it.next().onMediaStop(mediaPlayerAgent, i10);
        }
    }

    /* renamed from: a */
    public void m48784a(float f10) {
        AbstractC7185ho.m43821b(this.f36344a, "unmute, volume: %s", Float.valueOf(f10));
        this.f36363n.m45794a(f10);
    }

    @OuterVisible
    public void play(boolean z10, Long l10) {
        if (this.f36322B) {
            AbstractC7185ho.m43823c(this.f36344a, "play action is not performed - view paused");
            return;
        }
        AbstractC7185ho.m43821b(this.f36344a, "play auto: %s surfaceAvailable: %s standalone: %s url: %s", Boolean.valueOf(z10), Boolean.valueOf(this.f36362m), Boolean.valueOf(this.f36321A), AbstractC7819dl.m48375a(this.f36324D));
        if (!this.f36362m) {
            this.f36361l = true;
            this.f36367r = z10;
            return;
        }
        Surface surface = this.f36365p;
        if (surface != null) {
            this.f36363n.setSurface(surface);
        }
        if (this.f36321A) {
            this.f36363n.play(l10);
        } else if (z10) {
            this.f36352c.autoPlay(this.f36324D, this.f36363n);
        } else {
            this.f36352c.manualPlay(this.f36324D, this.f36363n);
        }
    }

    /* renamed from: a */
    public void mo48785a(float f10, float f11, int i10, int i11) {
        Matrix matrix;
        float f12;
        if (this.f36360k == null) {
            return;
        }
        float f13 = 1.0f;
        float f14 = (i10 * 1.0f) / 2.0f;
        float f15 = (i11 * 1.0f) / 2.0f;
        int i12 = this.f36368s;
        if (i12 == 1) {
            AbstractC7185ho.m43820b(this.f36344a, "set video scale mode as fit");
            matrix = new Matrix();
            matrix.setScale(1.0f, 1.0f, f14, f15);
        } else {
            if (i12 != 2) {
                return;
            }
            AbstractC7185ho.m43820b(this.f36344a, "set video scale mode as fit with cropping");
            if (f11 < f10) {
                float f16 = f10 / f11;
                f12 = 1.0f;
                f13 = f16;
            } else {
                f12 = f11 / f10;
            }
            AbstractC7185ho.m43818a(this.f36344a, "calculateScaleMatrix scaleX: %s scaleY: %s pivotPointX: %s pivotPointY: %s", Float.valueOf(f13), Float.valueOf(f12), Float.valueOf(f14), Float.valueOf(f15));
            matrix = new Matrix();
            matrix.setScale(f13, f12, f14, f15);
        }
        this.f36360k.setTransform(matrix);
    }

    /* renamed from: a */
    public void m48728a(int i10) {
        Iterator<MediaBufferListener> it = this.f36355f.iterator();
        while (it.hasNext()) {
            it.next().onBufferUpdate(i10);
        }
    }

    /* renamed from: a */
    public void m48729a(int i10, int i11) {
        Iterator<MediaStateListener> it = this.f36354e.iterator();
        while (it.hasNext()) {
            it.next().onProgress(i10, i11);
        }
    }

    /* renamed from: a */
    public void m48730a(int i10, int i11, int i12) {
        Iterator<SegmentMediaStateListener> it = this.f36359j.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaError(getContentId(), getCurrentVideoUrl(), i10, i11, i12);
        }
    }

    /* renamed from: a */
    public void mo48786a(Context context) {
    }

    /* renamed from: a */
    public void m48731a(MediaPlayerAgent mediaPlayerAgent, int i10) {
        Iterator<MediaStateListener> it = this.f36354e.iterator();
        while (it.hasNext()) {
            it.next().onMediaStart(mediaPlayerAgent, i10);
        }
    }

    /* renamed from: a */
    public void m48732a(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
        Iterator<MediaErrorListener> it = this.f36357h.iterator();
        while (it.hasNext()) {
            it.next().onError(mediaPlayerAgent, i10, i11, i12);
        }
    }

    /* renamed from: a */
    public void m48787a(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        MediaPlayerAgent mediaPlayerAgent = this.f36363n;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.removeMediaPlayerReleaseListener(mediaPlayerReleaseListener);
        }
    }

    /* renamed from: a */
    public void m48788a(String str, boolean z10) {
        if (z10) {
            str = m48726a(str);
        }
        setVideoFileUrls(new String[]{str});
    }

    /* renamed from: a */
    public void m48738a(boolean z10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(this.f36344a, "notifyNetworkConnectedOrChanged wifi: %s", Boolean.valueOf(z10));
        }
        Iterator<NetworkChangeListener> it = this.f36353d.iterator();
        while (it.hasNext()) {
            it.next().onNetworkConnectedOrChanged(z10);
        }
    }
}
