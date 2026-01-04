package com.huawei.openalliance.p169ad.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.exception.C7111c;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaPlayerReleaseListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7738al;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;

@OuterVisible
/* loaded from: classes2.dex */
public class MediaPlayerAgent {

    /* renamed from: a */
    private static final C7738al f34490a = new C7738al("thread_media_player_ctrl");

    /* renamed from: A */
    private int f34491A;

    /* renamed from: C */
    private Context f34493C;

    /* renamed from: D */
    private boolean f34494D;

    /* renamed from: b */
    private C7469b f34513b;

    /* renamed from: c */
    private MediaPlayer f34514c;

    /* renamed from: e */
    private String f34516e;

    /* renamed from: f */
    private volatile String f34517f;

    /* renamed from: g */
    private boolean f34518g;

    /* renamed from: l */
    private int f34523l;

    /* renamed from: m */
    private long f34524m;

    /* renamed from: s */
    private AudioManager f34530s;

    /* renamed from: y */
    private Object f34536y;

    /* renamed from: z */
    private WeakReference<Surface> f34537z;

    /* renamed from: d */
    private int f34515d = 0;

    /* renamed from: h */
    private boolean f34519h = false;

    /* renamed from: i */
    private boolean f34520i = false;

    /* renamed from: j */
    private boolean f34521j = false;

    /* renamed from: k */
    private int f34522k = 0;

    /* renamed from: n */
    private final MediaState f34525n = new MediaState();

    /* renamed from: o */
    private final byte[] f34526o = new byte[0];

    /* renamed from: p */
    private final byte[] f34527p = new byte[0];

    /* renamed from: q */
    private final byte[] f34528q = new byte[0];

    /* renamed from: r */
    private int f34529r = 0;

    /* renamed from: t */
    private boolean f34531t = false;

    /* renamed from: u */
    private boolean f34532u = false;

    /* renamed from: v */
    private int f34533v = 0;

    /* renamed from: w */
    private boolean f34534w = false;

    /* renamed from: x */
    private volatile int f34535x = 0;

    /* renamed from: B */
    private boolean f34492B = false;

    /* renamed from: E */
    private boolean f34495E = false;

    /* renamed from: F */
    private final CopyOnWriteArraySet<MediaStateListener> f34496F = new CopyOnWriteArraySet<>();

    /* renamed from: G */
    private final CopyOnWriteArraySet<MediaBufferListener> f34497G = new CopyOnWriteArraySet<>();

    /* renamed from: H */
    private final CopyOnWriteArraySet<MediaErrorListener> f34498H = new CopyOnWriteArraySet<>();

    /* renamed from: I */
    private final CopyOnWriteArraySet<MuteListener> f34499I = new CopyOnWriteArraySet<>();

    /* renamed from: J */
    private final CopyOnWriteArraySet<InterfaceC7470a> f34500J = new CopyOnWriteArraySet<>();

    /* renamed from: K */
    private final CopyOnWriteArraySet<MediaPlayer.OnVideoSizeChangedListener> f34501K = new CopyOnWriteArraySet<>();

    /* renamed from: L */
    private final CopyOnWriteArraySet<PPSVideoRenderListener> f34502L = new CopyOnWriteArraySet<>();

    /* renamed from: M */
    private final CopyOnWriteArraySet<MediaPlayerReleaseListener> f34503M = new CopyOnWriteArraySet<>();

    /* renamed from: N */
    private final MediaPlayer.OnVideoSizeChangedListener f34504N = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.1
        public C74241() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            MediaPlayerAgent.this.m45698a(mediaPlayer, i10, i11);
        }
    };

    /* renamed from: O */
    private MediaPlayer.OnCompletionListener f34505O = new MediaPlayer.OnCompletionListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.12
        public C742712() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (MediaPlayerAgent.this.f34525n.isState(MediaState.State.ERROR)) {
                return;
            }
            MediaState mediaState = MediaPlayerAgent.this.f34525n;
            MediaState.State state = MediaState.State.PLAYBACK_COMPLETED;
            if (mediaState.isState(state)) {
                return;
            }
            MediaPlayerAgent.this.f34525n.m45810a(state);
            int currentPosition = mediaPlayer.getCurrentPosition();
            int iM45756h = MediaPlayerAgent.this.m45756h();
            AbstractC7185ho.m43821b("MediaPlayerAgent", "onCompletion %d duration: %d", Integer.valueOf(currentPosition), Integer.valueOf(iM45756h));
            int iMax = Math.max(currentPosition, iM45756h);
            MediaPlayerAgent.this.m45696a(100, iMax);
            MediaPlayerAgent.this.m45717b(iMax);
            MediaPlayerAgent.this.m45774q();
            MediaPlayerAgent.m45741d(MediaPlayerAgent.this.f34516e);
            MediaPlayerAgent.this.f34522k = 0;
            MediaPlayerAgent.this.f34529r = 0;
        }
    };

    /* renamed from: P */
    private MediaPlayer.OnInfoListener f34506P = new MediaPlayer.OnInfoListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.23
        public C743923() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            AbstractC7185ho.m43821b("MediaPlayerAgent", "onInfo what: %d extra: %d", Integer.valueOf(i10), Integer.valueOf(i11));
            if (i10 == 3) {
                MediaPlayerAgent.this.m45770o();
            } else {
                if (i10 == 701) {
                    MediaPlayerAgent.this.m45768n();
                    return true;
                }
                if (i10 != 702) {
                    if (i10 != 804 && i10 != 805) {
                        return true;
                    }
                    MediaPlayerAgent.this.m45718b(i10, i11);
                    return true;
                }
            }
            MediaPlayerAgent.this.m45774q();
            return true;
        }
    };

    /* renamed from: Q */
    private MediaPlayer.OnPreparedListener f34507Q = new MediaPlayer.OnPreparedListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.34
        public C745134() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "onPrepared");
            MediaPlayerAgent.this.f34520i = false;
            mediaPlayer.setOnInfoListener(MediaPlayerAgent.this.f34506P);
            if (MediaPlayerAgent.this.f34521j || MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PREPARING)) {
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.PREPARED);
                MediaPlayerAgent mediaPlayerAgent = MediaPlayerAgent.this;
                mediaPlayerAgent.m45755g(mediaPlayerAgent.m45756h());
                return;
            }
            try {
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.PREPARED);
                mediaPlayer.start();
                MediaPlayerAgent.m45719b(mediaPlayer, MediaPlayerAgent.this.f34524m, 3);
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.PLAYING);
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MediaPlayerAgent", "seek to prefer pos: %d", Long.valueOf(MediaPlayerAgent.this.f34524m));
                }
                MediaPlayerAgent.this.m45739d(mediaPlayer.getCurrentPosition());
                MediaPlayerAgent mediaPlayerAgent2 = MediaPlayerAgent.this;
                mediaPlayerAgent2.m45755g(mediaPlayerAgent2.m45756h());
                MediaPlayerAgent.this.m45781t();
            } catch (IllegalStateException unused) {
                AbstractC7185ho.m43823c("MediaPlayerAgent", "onPrepared - IllegalStateException");
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.ERROR);
                MediaPlayerAgent.this.m45697a(0, -1, -1);
            }
        }
    };

    /* renamed from: R */
    private MediaPlayer.OnErrorListener f34508R = new MediaPlayer.OnErrorListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.39
        public C745639() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            AbstractC7185ho.m43824c("MediaPlayerAgent", "onError - what: %d extra: %d currentState: %s - agent: %s", Integer.valueOf(i10), Integer.valueOf(i11), MediaPlayerAgent.this.f34525n, MediaPlayerAgent.this);
            MediaPlayerAgent.this.m45774q();
            MediaState mediaState = MediaPlayerAgent.this.f34525n;
            MediaState.State state = MediaState.State.ERROR;
            if (mediaState.isState(state)) {
                AbstractC7185ho.m43820b("MediaPlayerAgent", "do not notify error when already error");
                return true;
            }
            MediaPlayerAgent.this.f34525n.m45810a(state);
            MediaPlayerAgent.this.m45697a(mediaPlayer.getCurrentPosition(), i10, i11);
            return true;
        }
    };

    /* renamed from: S */
    private MediaPlayer.OnBufferingUpdateListener f34509S = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.40
        public C745840() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            if (MediaPlayerAgent.this.f34525n.m45811a()) {
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 > 100) {
                    i10 = 100;
                }
                MediaPlayerAgent.this.m45732c(i10);
            }
        }
    };

    /* renamed from: T */
    private Callable<Boolean> f34510T = new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.8
        public CallableC74658() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(MediaPlayerAgent.this.m45761j());
        }
    };

    /* renamed from: U */
    private Runnable f34511U = new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.32
        public RunnableC744932() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iM45756h;
            MediaPlayerAgent.m45741d(MediaPlayerAgent.this.f34516e);
            if (MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PREPARING) && MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PLAYING) && MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PREPARED)) {
                return;
            }
            int currentPlayPosition = MediaPlayerAgent.this.getCurrentPlayPosition();
            if (MediaPlayerAgent.this.f34496F.size() > 0 && (iM45756h = MediaPlayerAgent.this.m45756h()) > 0) {
                int iCeil = (int) Math.ceil((currentPlayPosition * 100.0f) / iM45756h);
                if (iCeil > 100) {
                    iCeil = 100;
                }
                MediaPlayerAgent.this.m45696a(iCeil, currentPlayPosition);
                if (currentPlayPosition >= iM45756h) {
                    MediaPlayerAgent.m45790y(MediaPlayerAgent.this);
                    if (MediaPlayerAgent.this.f34529r > 2) {
                        AbstractC7185ho.m43820b("MediaPlayerAgent", "reach end count exceeds");
                        MediaPlayerAgent.this.f34505O.onCompletion(MediaPlayerAgent.this.m45730c());
                        return;
                    }
                }
            }
            if (MediaPlayerAgent.this.f34518g && MediaPlayerAgent.this.f34497G.size() > 0 && MediaPlayerAgent.this.f34529r == 0) {
                if (Math.abs(currentPlayPosition - MediaPlayerAgent.this.f34522k) < 100) {
                    MediaPlayerAgent.this.m45768n();
                } else {
                    MediaPlayerAgent.this.m45774q();
                    MediaPlayerAgent.this.f34522k = currentPlayPosition;
                }
            }
            MediaPlayerAgent.m45724b(MediaPlayerAgent.this.f34511U, MediaPlayerAgent.this.f34516e, 200L);
        }
    };

    /* renamed from: V */
    private AudioManager.OnAudioFocusChangeListener f34512V = new AudioManager.OnAudioFocusChangeListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.38

        /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$38$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f34586a;

            public AnonymousClass1(int i10) {
                i = i10;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                AbstractC7185ho.m43821b("MediaPlayerAgent", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(MediaPlayerAgent.this.f34533v));
                int i10 = i;
                if (i10 == -3) {
                    C745538.this.m45805b();
                } else if (i10 == -2 || i10 == -1) {
                    C745538.this.m45803a();
                } else if (i10 == 1 || i10 == 2) {
                    C745538.this.m45807c();
                }
                MediaPlayerAgent.this.f34533v = i;
            }
        }

        public C745538() {
        }

        /* renamed from: a */
        public void m45803a() {
            if (MediaPlayerAgent.this.f34492B) {
                AbstractC7185ho.m43820b("MediaPlayerAgent", "handleAudioFocusLoss muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.f34492B);
                m45805b();
                return;
            }
            boolean zM45761j = MediaPlayerAgent.this.m45761j();
            AbstractC7185ho.m43821b("MediaPlayerAgent", "handleAudioFocusLoss isPlaying: %s", Boolean.valueOf(zM45761j));
            if (zM45761j) {
                MediaPlayerAgent.this.pause();
                MediaPlayerAgent.this.f34531t = true;
            }
        }

        /* renamed from: b */
        public void m45805b() {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "handleAudioFocusLossTransientCanDuck soundMuted: " + MediaPlayerAgent.this.f34534w);
            if (MediaPlayerAgent.this.f34534w) {
                return;
            }
            MediaPlayerAgent.this.m45764l();
            MediaPlayerAgent.this.f34532u = true;
        }

        /* renamed from: c */
        public void m45807c() throws IllegalStateException {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "handleAudioFocusGain - muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.f34492B);
            if (MediaPlayerAgent.this.f34492B) {
                if (MediaPlayerAgent.this.f34532u) {
                    MediaPlayerAgent.this.m45766m();
                }
            } else {
                if (MediaPlayerAgent.this.f34533v == -2 || MediaPlayerAgent.this.f34533v == -1) {
                    if (MediaPlayerAgent.this.f34531t) {
                        MediaPlayerAgent.this.m45708a((Long) null);
                        MediaPlayerAgent.this.f34531t = false;
                        return;
                    }
                    return;
                }
                if (MediaPlayerAgent.this.f34533v == -3 && MediaPlayerAgent.this.f34532u) {
                    MediaPlayerAgent.this.m45766m();
                }
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            MediaPlayerAgent.m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.38.1

                /* renamed from: a */
                final /* synthetic */ int f34586a;

                public AnonymousClass1(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() throws IllegalStateException {
                    AbstractC7185ho.m43821b("MediaPlayerAgent", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(MediaPlayerAgent.this.f34533v));
                    int i102 = i;
                    if (i102 == -3) {
                        C745538.this.m45805b();
                    } else if (i102 == -2 || i102 == -1) {
                        C745538.this.m45803a();
                    } else if (i102 == 1 || i102 == 2) {
                        C745538.this.m45807c();
                    }
                    MediaPlayerAgent.this.f34533v = i;
                }
            });
        }
    };

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$1 */
    public class C74241 implements MediaPlayer.OnVideoSizeChangedListener {
        public C74241() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            MediaPlayerAgent.this.m45698a(mediaPlayer, i10, i11);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$10 */
    public class RunnableC742510 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Surface f34539a;

        public RunnableC742510(Surface surface) {
            surface = surface;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45700a(surface);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$11 */
    public class RunnableC742611 implements Runnable {
        public RunnableC742611() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45764l();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$12 */
    public class C742712 implements MediaPlayer.OnCompletionListener {
        public C742712() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (MediaPlayerAgent.this.f34525n.isState(MediaState.State.ERROR)) {
                return;
            }
            MediaState mediaState = MediaPlayerAgent.this.f34525n;
            MediaState.State state = MediaState.State.PLAYBACK_COMPLETED;
            if (mediaState.isState(state)) {
                return;
            }
            MediaPlayerAgent.this.f34525n.m45810a(state);
            int currentPosition = mediaPlayer.getCurrentPosition();
            int iM45756h = MediaPlayerAgent.this.m45756h();
            AbstractC7185ho.m43821b("MediaPlayerAgent", "onCompletion %d duration: %d", Integer.valueOf(currentPosition), Integer.valueOf(iM45756h));
            int iMax = Math.max(currentPosition, iM45756h);
            MediaPlayerAgent.this.m45696a(100, iMax);
            MediaPlayerAgent.this.m45717b(iMax);
            MediaPlayerAgent.this.m45774q();
            MediaPlayerAgent.m45741d(MediaPlayerAgent.this.f34516e);
            MediaPlayerAgent.this.f34522k = 0;
            MediaPlayerAgent.this.f34529r = 0;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$13 */
    public class RunnableC742813 implements Runnable {
        public RunnableC742813() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45766m();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$14 */
    public class RunnableC742914 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f34544a;

        public RunnableC742914(float f10) {
            f = f10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43818a("MediaPlayerAgent", "setSoundVolume %f result: %s", Float.valueOf(f), Boolean.valueOf(MediaPlayerAgent.this.m45727b(f)));
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$15 */
    public class RunnableC743015 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f34546a;

        public RunnableC743015(float f10) {
            f = f10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45731c(f);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$16 */
    public class RunnableC743116 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34548a;

        /* renamed from: b */
        final /* synthetic */ int f34549b;

        public RunnableC743116(int i10, int i11) {
            i = i10;
            i = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34496F.iterator();
            while (it.hasNext()) {
                MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                if (mediaStateListener != null) {
                    mediaStateListener.onProgress(i, i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$17 */
    public class RunnableC743217 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34551a;

        public RunnableC743217(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34496F.iterator();
            while (it.hasNext()) {
                MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                if (mediaStateListener != null) {
                    mediaStateListener.onMediaCompletion(MediaPlayerAgent.this, i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$18 */
    public class RunnableC743318 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34553a;

        public RunnableC743318(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34497G.iterator();
            while (it.hasNext()) {
                MediaBufferListener mediaBufferListener = (MediaBufferListener) it.next();
                if (mediaBufferListener != null) {
                    mediaBufferListener.onBufferUpdate(i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$19 */
    public class RunnableC743419 implements Runnable {
        public RunnableC743419() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34497G.iterator();
            while (it.hasNext()) {
                MediaBufferListener mediaBufferListener = (MediaBufferListener) it.next();
                if (mediaBufferListener != null) {
                    mediaBufferListener.onBufferingStart();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$2 */
    public class RunnableC74352 implements Runnable {
        public RunnableC74352() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            MediaPlayerAgent.this.m45744e();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$20 */
    public class RunnableC743620 implements Runnable {
        public RunnableC743620() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34502L.iterator();
            while (it.hasNext()) {
                PPSVideoRenderListener pPSVideoRenderListener = (PPSVideoRenderListener) it.next();
                if (pPSVideoRenderListener != null) {
                    pPSVideoRenderListener.onVideoRenderStart();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$21 */
    public class RunnableC743721 implements Runnable {
        public RunnableC743721() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34503M.iterator();
            while (it.hasNext()) {
                MediaPlayerReleaseListener mediaPlayerReleaseListener = (MediaPlayerReleaseListener) it.next();
                if (mediaPlayerReleaseListener != null) {
                    mediaPlayerReleaseListener.onPlayerRelease();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$22 */
    public class RunnableC743822 implements Runnable {
        public RunnableC743822() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34497G.iterator();
            while (it.hasNext()) {
                MediaBufferListener mediaBufferListener = (MediaBufferListener) it.next();
                if (mediaBufferListener != null) {
                    mediaBufferListener.onBufferingEnd();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$23 */
    public class C743923 implements MediaPlayer.OnInfoListener {
        public C743923() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            AbstractC7185ho.m43821b("MediaPlayerAgent", "onInfo what: %d extra: %d", Integer.valueOf(i10), Integer.valueOf(i11));
            if (i10 == 3) {
                MediaPlayerAgent.this.m45770o();
            } else {
                if (i10 == 701) {
                    MediaPlayerAgent.this.m45768n();
                    return true;
                }
                if (i10 != 702) {
                    if (i10 != 804 && i10 != 805) {
                        return true;
                    }
                    MediaPlayerAgent.this.m45718b(i10, i11);
                    return true;
                }
            }
            MediaPlayerAgent.this.m45774q();
            return true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$24 */
    public class RunnableC744024 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34561a;

        public RunnableC744024(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34496F.iterator();
            while (it.hasNext()) {
                MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                if (mediaStateListener != null) {
                    mediaStateListener.onMediaStart(MediaPlayerAgent.this, i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$25 */
    public class RunnableC744125 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34563a;

        public RunnableC744125(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34496F.iterator();
            while (it.hasNext()) {
                MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                if (mediaStateListener != null) {
                    mediaStateListener.onMediaStop(MediaPlayerAgent.this, i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$26 */
    public class RunnableC744226 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34565a;

        public RunnableC744226(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34496F.iterator();
            while (it.hasNext()) {
                MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                if (mediaStateListener != null) {
                    mediaStateListener.onMediaPause(MediaPlayerAgent.this, i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$27 */
    public class RunnableC744327 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34567a;

        /* renamed from: b */
        final /* synthetic */ int f34568b;

        /* renamed from: c */
        final /* synthetic */ int f34569c;

        public RunnableC744327(int i10, int i11, int i12) {
            i = i10;
            i = i11;
            i = i12;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34498H.iterator();
            while (it.hasNext()) {
                MediaErrorListener mediaErrorListener = (MediaErrorListener) it.next();
                if (mediaErrorListener != null) {
                    mediaErrorListener.onError(MediaPlayerAgent.this, i, i, i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$28 */
    public class RunnableC744428 implements Runnable {
        public RunnableC744428() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34499I.iterator();
            while (it.hasNext()) {
                MuteListener muteListener = (MuteListener) it.next();
                if (muteListener != null) {
                    muteListener.onMute();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$29 */
    public class RunnableC744529 implements Runnable {
        public RunnableC744529() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34499I.iterator();
            while (it.hasNext()) {
                MuteListener muteListener = (MuteListener) it.next();
                if (muteListener != null) {
                    muteListener.onUnmute();
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$3 */
    public class RunnableC74463 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f34573a;

        public RunnableC74463(boolean z10) {
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            MediaPlayerAgent.this.m45742d(z);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$30 */
    public class RunnableC744730 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34575a;

        public RunnableC744730(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34500J.iterator();
            while (it.hasNext()) {
                InterfaceC7470a interfaceC7470a = (InterfaceC7470a) it.next();
                if (interfaceC7470a != null) {
                    interfaceC7470a.mo45566a(i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$31 */
    public class RunnableC744831 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f34577a;

        public RunnableC744831(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = MediaPlayerAgent.this.f34500J.iterator();
            while (it.hasNext()) {
                InterfaceC7470a interfaceC7470a = (InterfaceC7470a) it.next();
                if (interfaceC7470a != null) {
                    interfaceC7470a.mo45567b(i);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$32 */
    public class RunnableC744932 implements Runnable {
        public RunnableC744932() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iM45756h;
            MediaPlayerAgent.m45741d(MediaPlayerAgent.this.f34516e);
            if (MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PREPARING) && MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PLAYING) && MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PREPARED)) {
                return;
            }
            int currentPlayPosition = MediaPlayerAgent.this.getCurrentPlayPosition();
            if (MediaPlayerAgent.this.f34496F.size() > 0 && (iM45756h = MediaPlayerAgent.this.m45756h()) > 0) {
                int iCeil = (int) Math.ceil((currentPlayPosition * 100.0f) / iM45756h);
                if (iCeil > 100) {
                    iCeil = 100;
                }
                MediaPlayerAgent.this.m45696a(iCeil, currentPlayPosition);
                if (currentPlayPosition >= iM45756h) {
                    MediaPlayerAgent.m45790y(MediaPlayerAgent.this);
                    if (MediaPlayerAgent.this.f34529r > 2) {
                        AbstractC7185ho.m43820b("MediaPlayerAgent", "reach end count exceeds");
                        MediaPlayerAgent.this.f34505O.onCompletion(MediaPlayerAgent.this.m45730c());
                        return;
                    }
                }
            }
            if (MediaPlayerAgent.this.f34518g && MediaPlayerAgent.this.f34497G.size() > 0 && MediaPlayerAgent.this.f34529r == 0) {
                if (Math.abs(currentPlayPosition - MediaPlayerAgent.this.f34522k) < 100) {
                    MediaPlayerAgent.this.m45768n();
                } else {
                    MediaPlayerAgent.this.m45774q();
                    MediaPlayerAgent.this.f34522k = currentPlayPosition;
                }
            }
            MediaPlayerAgent.m45724b(MediaPlayerAgent.this.f34511U, MediaPlayerAgent.this.f34516e, 200L);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$33 */
    public class RunnableC745033 implements Runnable {
        public RunnableC745033() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45783u();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$34 */
    public class C745134 implements MediaPlayer.OnPreparedListener {
        public C745134() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "onPrepared");
            MediaPlayerAgent.this.f34520i = false;
            mediaPlayer.setOnInfoListener(MediaPlayerAgent.this.f34506P);
            if (MediaPlayerAgent.this.f34521j || MediaPlayerAgent.this.f34525n.isNotState(MediaState.State.PREPARING)) {
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.PREPARED);
                MediaPlayerAgent mediaPlayerAgent = MediaPlayerAgent.this;
                mediaPlayerAgent.m45755g(mediaPlayerAgent.m45756h());
                return;
            }
            try {
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.PREPARED);
                mediaPlayer.start();
                MediaPlayerAgent.m45719b(mediaPlayer, MediaPlayerAgent.this.f34524m, 3);
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.PLAYING);
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MediaPlayerAgent", "seek to prefer pos: %d", Long.valueOf(MediaPlayerAgent.this.f34524m));
                }
                MediaPlayerAgent.this.m45739d(mediaPlayer.getCurrentPosition());
                MediaPlayerAgent mediaPlayerAgent2 = MediaPlayerAgent.this;
                mediaPlayerAgent2.m45755g(mediaPlayerAgent2.m45756h());
                MediaPlayerAgent.this.m45781t();
            } catch (IllegalStateException unused) {
                AbstractC7185ho.m43823c("MediaPlayerAgent", "onPrepared - IllegalStateException");
                MediaPlayerAgent.this.f34525n.m45810a(MediaState.State.ERROR);
                MediaPlayerAgent.this.m45697a(0, -1, -1);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$35 */
    public class RunnableC745235 implements Runnable {
        public RunnableC745235() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45783u();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$36 */
    public class RunnableC745336 implements Runnable {
        public RunnableC745336() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45785v();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$37 */
    public class RunnableC745437 implements Runnable {
        public RunnableC745437() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45789x();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$38 */
    public class C745538 implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$38$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f34586a;

            public AnonymousClass1(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                AbstractC7185ho.m43821b("MediaPlayerAgent", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(MediaPlayerAgent.this.f34533v));
                int i102 = i;
                if (i102 == -3) {
                    C745538.this.m45805b();
                } else if (i102 == -2 || i102 == -1) {
                    C745538.this.m45803a();
                } else if (i102 == 1 || i102 == 2) {
                    C745538.this.m45807c();
                }
                MediaPlayerAgent.this.f34533v = i;
            }
        }

        public C745538() {
        }

        /* renamed from: a */
        public void m45803a() {
            if (MediaPlayerAgent.this.f34492B) {
                AbstractC7185ho.m43820b("MediaPlayerAgent", "handleAudioFocusLoss muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.f34492B);
                m45805b();
                return;
            }
            boolean zM45761j = MediaPlayerAgent.this.m45761j();
            AbstractC7185ho.m43821b("MediaPlayerAgent", "handleAudioFocusLoss isPlaying: %s", Boolean.valueOf(zM45761j));
            if (zM45761j) {
                MediaPlayerAgent.this.pause();
                MediaPlayerAgent.this.f34531t = true;
            }
        }

        /* renamed from: b */
        public void m45805b() {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "handleAudioFocusLossTransientCanDuck soundMuted: " + MediaPlayerAgent.this.f34534w);
            if (MediaPlayerAgent.this.f34534w) {
                return;
            }
            MediaPlayerAgent.this.m45764l();
            MediaPlayerAgent.this.f34532u = true;
        }

        /* renamed from: c */
        public void m45807c() throws IllegalStateException {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "handleAudioFocusGain - muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.f34492B);
            if (MediaPlayerAgent.this.f34492B) {
                if (MediaPlayerAgent.this.f34532u) {
                    MediaPlayerAgent.this.m45766m();
                }
            } else {
                if (MediaPlayerAgent.this.f34533v == -2 || MediaPlayerAgent.this.f34533v == -1) {
                    if (MediaPlayerAgent.this.f34531t) {
                        MediaPlayerAgent.this.m45708a((Long) null);
                        MediaPlayerAgent.this.f34531t = false;
                        return;
                    }
                    return;
                }
                if (MediaPlayerAgent.this.f34533v == -3 && MediaPlayerAgent.this.f34532u) {
                    MediaPlayerAgent.this.m45766m();
                }
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i102) {
            MediaPlayerAgent.m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.38.1

                /* renamed from: a */
                final /* synthetic */ int f34586a;

                public AnonymousClass1(int i1022) {
                    i = i1022;
                }

                @Override // java.lang.Runnable
                public void run() throws IllegalStateException {
                    AbstractC7185ho.m43821b("MediaPlayerAgent", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(MediaPlayerAgent.this.f34533v));
                    int i1022 = i;
                    if (i1022 == -3) {
                        C745538.this.m45805b();
                    } else if (i1022 == -2 || i1022 == -1) {
                        C745538.this.m45803a();
                    } else if (i1022 == 1 || i1022 == 2) {
                        C745538.this.m45807c();
                    }
                    MediaPlayerAgent.this.f34533v = i;
                }
            });
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$39 */
    public class C745639 implements MediaPlayer.OnErrorListener {
        public C745639() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            AbstractC7185ho.m43824c("MediaPlayerAgent", "onError - what: %d extra: %d currentState: %s - agent: %s", Integer.valueOf(i10), Integer.valueOf(i11), MediaPlayerAgent.this.f34525n, MediaPlayerAgent.this);
            MediaPlayerAgent.this.m45774q();
            MediaState mediaState = MediaPlayerAgent.this.f34525n;
            MediaState.State state = MediaState.State.ERROR;
            if (mediaState.isState(state)) {
                AbstractC7185ho.m43820b("MediaPlayerAgent", "do not notify error when already error");
                return true;
            }
            MediaPlayerAgent.this.f34525n.m45810a(state);
            MediaPlayerAgent.this.m45697a(mediaPlayer.getCurrentPosition(), i10, i11);
            return true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$4 */
    public class RunnableC74574 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34589a;

        public RunnableC74574(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            String str = str;
            if (str == null || !TextUtils.equals(str, MediaPlayerAgent.this.f34517f)) {
                return;
            }
            MediaPlayerAgent.this.m45748f();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$40 */
    public class C745840 implements MediaPlayer.OnBufferingUpdateListener {
        public C745840() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            if (MediaPlayerAgent.this.f34525n.m45811a()) {
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 > 100) {
                    i10 = 100;
                }
                MediaPlayerAgent.this.m45732c(i10);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$41 */
    public class RunnableC745941 implements Runnable {
        public RunnableC745941() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            MediaPlayerAgent.this.m45708a((Long) null);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$42 */
    public class RunnableC746042 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Long f34593a;

        public RunnableC746042(Long l10) {
            l = l10;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            MediaPlayerAgent.this.m45708a(l);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$43 */
    public class RunnableC746143 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34595a;

        public RunnableC746143(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            String str = str;
            if (str == null || !TextUtils.equals(str, MediaPlayerAgent.this.f34517f)) {
                AbstractC7185ho.m43820b("MediaPlayerAgent", "playWhenUrlMatchs - url not match");
            } else {
                MediaPlayerAgent.this.m45708a((Long) null);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$5 */
    public class RunnableC74625 implements Runnable {
        public RunnableC74625() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            MediaPlayerAgent.this.m45754g();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$6 */
    public class RunnableC74636 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34598a;

        public RunnableC74636(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            String str = str;
            if (str == null || !TextUtils.equals(str, MediaPlayerAgent.this.f34517f)) {
                return;
            }
            MediaPlayerAgent.this.m45754g();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$7 */
    public class RunnableC74647 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f34600a;

        /* renamed from: b */
        final /* synthetic */ int f34601b;

        public RunnableC74647(long j10, int i10) {
            j = j10;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayerAgent.this.m45796a(j, i);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$8 */
    public class CallableC74658 implements Callable<Boolean> {
        public CallableC74658() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(MediaPlayerAgent.this.m45761j());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.media.MediaPlayerAgent$9 */
    public class RunnableC74669 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34604a;

        public RunnableC74669(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaPlayerAgent.this.m45725b(str);
            } catch (C7111c e10) {
                AbstractC7185ho.m43818a("MediaPlayerAgent", "set media file error:%s", e10.getMessage());
                AbstractC7185ho.m43823c("MediaPlayerAgent", "set media file error:" + e10.getClass().getSimpleName());
            }
        }
    }

    @OuterVisible
    public MediaPlayerAgent(Context context) {
        this.f34494D = false;
        Context applicationContext = context.getApplicationContext();
        this.f34493C = applicationContext;
        this.f34494D = HiAd.m44014a(applicationContext).mo44061n();
        this.f34530s = (AudioManager) context.getSystemService("audio");
        this.f34516e = "progress_task" + hashCode();
        f34490a.m47517a();
    }

    /* renamed from: e */
    public void m45744e() throws IllegalStateException {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "prepareInternal - current state: %s - agent: %s", this.f34525n, this);
        if (this.f34525n.isState(MediaState.State.END)) {
            return;
        }
        if (this.f34494D && m45762k() == null) {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "setSurfaceFirst, current surface is null, prepare on setSurface.");
            this.f34495E = true;
            return;
        }
        AbstractC7185ho.m43821b("MediaPlayerAgent", "prepareInternal - current state after set file: %s", this.f34525n);
        if (this.f34525n.isState(MediaState.State.INITIALIZED)) {
            this.f34521j = true;
            m45726b(false);
        }
    }

    /* renamed from: f */
    public void m45748f() throws IllegalStateException {
        m45742d(true);
    }

    /* renamed from: h */
    public int m45756h() {
        MediaPlayer mediaPlayer;
        int duration;
        if (this.f34525n.isState(MediaState.State.END)) {
            return 0;
        }
        int iM45758i = m45758i();
        if (!this.f34525n.m45811a() || this.f34520i) {
            return iM45758i;
        }
        try {
            synchronized (this.f34526o) {
                mediaPlayer = this.f34514c;
            }
            return (mediaPlayer == null || (duration = mediaPlayer.getDuration()) <= 0) ? iM45758i : duration;
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "getDuration IllegalStateException");
            return iM45758i;
        }
    }

    /* renamed from: i */
    private int m45758i() {
        int i10;
        synchronized (this.f34527p) {
            i10 = this.f34523l;
        }
        return i10;
    }

    /* renamed from: k */
    private Surface m45762k() {
        WeakReference<Surface> weakReference = this.f34537z;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: l */
    public void m45764l() {
        this.f34532u = false;
        if (m45727b(0.0f)) {
            m45777r();
        }
        if (this.f34535x == 1 && m45761j()) {
            m45802b();
        }
    }

    /* renamed from: m */
    public void m45766m() {
        this.f34532u = false;
        if (m45727b(1.0f)) {
            m45779s();
        }
        if (this.f34535x == 1 && m45761j()) {
            m45787w();
        }
    }

    /* renamed from: n */
    public void m45768n() {
        if (!this.f34519h && this.f34518g && this.f34497G.size() > 0) {
            if (this.f34525n.isState(MediaState.State.PLAYING) || this.f34525n.isState(MediaState.State.PREPARING)) {
                AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyBufferingStart currentState: %s", this.f34525n);
                this.f34519h = true;
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.19
                    public RunnableC743419() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = MediaPlayerAgent.this.f34497G.iterator();
                        while (it.hasNext()) {
                            MediaBufferListener mediaBufferListener = (MediaBufferListener) it.next();
                            if (mediaBufferListener != null) {
                                mediaBufferListener.onBufferingStart();
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: o */
    public void m45770o() {
        CopyOnWriteArraySet<PPSVideoRenderListener> copyOnWriteArraySet = this.f34502L;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        AbstractC7185ho.m43820b("MediaPlayerAgent", "notifyRenderStart");
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.20
            public RunnableC743620() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34502L.iterator();
                while (it.hasNext()) {
                    PPSVideoRenderListener pPSVideoRenderListener = (PPSVideoRenderListener) it.next();
                    if (pPSVideoRenderListener != null) {
                        pPSVideoRenderListener.onVideoRenderStart();
                    }
                }
            }
        });
    }

    /* renamed from: p */
    private void m45772p() {
        CopyOnWriteArraySet<MediaPlayerReleaseListener> copyOnWriteArraySet = this.f34503M;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        AbstractC7185ho.m43820b("MediaPlayerAgent", "notify player release");
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.21
            public RunnableC743721() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34503M.iterator();
                while (it.hasNext()) {
                    MediaPlayerReleaseListener mediaPlayerReleaseListener = (MediaPlayerReleaseListener) it.next();
                    if (mediaPlayerReleaseListener != null) {
                        mediaPlayerReleaseListener.onPlayerRelease();
                    }
                }
            }
        });
    }

    /* renamed from: q */
    public void m45774q() {
        if (this.f34519h && this.f34518g) {
            this.f34519h = false;
            AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyBufferingEnd currentState: %s", this.f34525n);
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.22
                public RunnableC743822() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = MediaPlayerAgent.this.f34497G.iterator();
                    while (it.hasNext()) {
                        MediaBufferListener mediaBufferListener = (MediaBufferListener) it.next();
                        if (mediaBufferListener != null) {
                            mediaBufferListener.onBufferingEnd();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: y */
    public static /* synthetic */ int m45790y(MediaPlayerAgent mediaPlayerAgent) {
        int i10 = mediaPlayerAgent.f34529r;
        mediaPlayerAgent.f34529r = i10 + 1;
        return i10;
    }

    @OuterVisible
    public void acquire() {
        synchronized (this.f34528q) {
            try {
                this.f34515d++;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MediaPlayerAgent", "acquire - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f34515d), this);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @OuterVisible
    public void addMediaBufferListener(MediaBufferListener mediaBufferListener) {
        if (mediaBufferListener == null) {
            return;
        }
        this.f34497G.add(mediaBufferListener);
    }

    @OuterVisible
    public void addMediaErrorListener(MediaErrorListener mediaErrorListener) {
        if (mediaErrorListener == null) {
            return;
        }
        this.f34498H.add(mediaErrorListener);
    }

    @OuterVisible
    public void addMediaInfoListener(InterfaceC7470a interfaceC7470a) {
        if (interfaceC7470a == null) {
            return;
        }
        this.f34500J.add(interfaceC7470a);
    }

    @OuterVisible
    public void addMediaStateListener(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.f34496F.add(mediaStateListener);
    }

    @OuterVisible
    public void addMuteListener(MuteListener muteListener) {
        if (muteListener == null) {
            return;
        }
        this.f34499I.add(muteListener);
    }

    @OuterVisible
    public void addReportVideoTimeListenersSet(ReportVideoTimeListener reportVideoTimeListener) {
        if (this.f34513b == null) {
            this.f34513b = new C7469b(this.f34493C);
        }
        this.f34513b.m45830a(reportVideoTimeListener);
    }

    public void finalize() throws Throwable {
        super.finalize();
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.35
            public RunnableC745235() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45783u();
            }
        });
    }

    @OuterVisible
    public int getCurrentPlayPosition() {
        MediaPlayer mediaPlayer;
        if (!this.f34525n.isState(MediaState.State.END) && !this.f34525n.isState(MediaState.State.ERROR) && !this.f34525n.isState(MediaState.State.IDLE)) {
            try {
                synchronized (this.f34526o) {
                    mediaPlayer = this.f34514c;
                }
                if (mediaPlayer != null) {
                    return mediaPlayer.getCurrentPosition();
                }
            } catch (IllegalStateException unused) {
                AbstractC7185ho.m43823c("MediaPlayerAgent", "getCurrentPlayPosition IllegalStateException");
            }
        }
        return 0;
    }

    @OuterVisible
    public MediaState getCurrentState() {
        return this.f34525n;
    }

    @OuterVisible
    public int getInstanceRefCount() {
        int i10;
        synchronized (this.f34528q) {
            i10 = this.f34515d;
        }
        return i10;
    }

    @OuterVisible
    public boolean isPlaying() {
        if (this.f34525n.isState(MediaState.State.END)) {
            return false;
        }
        return ((Boolean) AbstractC7810dc.m48268a(this.f34510T, 300L, Boolean.valueOf(this.f34525n.isState(MediaState.State.PLAYING)))).booleanValue();
    }

    @OuterVisible
    public void muteSound() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.11
            public RunnableC742611() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45764l();
            }
        });
    }

    @OuterVisible
    public void pause() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.5
            public RunnableC74625() {
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                MediaPlayerAgent.this.m45754g();
            }
        });
    }

    @OuterVisible
    public void pauseWhenUrlMatchs(String str) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.6

            /* renamed from: a */
            final /* synthetic */ String f34598a;

            public RunnableC74636(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.f34517f)) {
                    return;
                }
                MediaPlayerAgent.this.m45754g();
            }
        });
    }

    @OuterVisible
    public void play() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.41
            public RunnableC745941() {
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                MediaPlayerAgent.this.m45708a((Long) null);
            }
        });
    }

    @OuterVisible
    public void playWhenUrlMatchs(String str) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.43

            /* renamed from: a */
            final /* synthetic */ String f34595a;

            public RunnableC746143(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.f34517f)) {
                    AbstractC7185ho.m43820b("MediaPlayerAgent", "playWhenUrlMatchs - url not match");
                } else {
                    MediaPlayerAgent.this.m45708a((Long) null);
                }
            }
        });
    }

    @OuterVisible
    public void prepare() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.2
            public RunnableC74352() {
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                MediaPlayerAgent.this.m45744e();
            }
        });
    }

    @OuterVisible
    public void release() {
        synchronized (this.f34528q) {
            try {
                int i10 = this.f34515d - 1;
                this.f34515d = i10;
                if (i10 < 0) {
                    this.f34515d = 0;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MediaPlayerAgent", "release - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f34515d), this);
                }
                if (this.f34515d == 0) {
                    m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.33
                        public RunnableC745033() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            MediaPlayerAgent.this.m45783u();
                        }
                    });
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @OuterVisible
    public void removeMediaBufferListener(MediaBufferListener mediaBufferListener) {
        if (mediaBufferListener == null) {
            return;
        }
        this.f34497G.remove(mediaBufferListener);
    }

    @OuterVisible
    public void removeMediaErrorListener(MediaErrorListener mediaErrorListener) {
        if (mediaErrorListener == null) {
            return;
        }
        this.f34498H.remove(mediaErrorListener);
    }

    @OuterVisible
    public void removeMediaInfoListener(InterfaceC7470a interfaceC7470a) {
        if (interfaceC7470a == null) {
            return;
        }
        this.f34500J.remove(interfaceC7470a);
    }

    @OuterVisible
    public void removeMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        if (mediaPlayerReleaseListener == null) {
            return;
        }
        this.f34503M.remove(mediaPlayerReleaseListener);
    }

    @OuterVisible
    public void removeMediaStateListener(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.f34496F.remove(mediaStateListener);
    }

    @OuterVisible
    public void removeMuteListener(MuteListener muteListener) {
        if (muteListener == null) {
            return;
        }
        this.f34499I.remove(muteListener);
    }

    @OuterVisible
    public void removePPSVideoRenderListener(PPSVideoRenderListener pPSVideoRenderListener) {
        if (pPSVideoRenderListener == null) {
            return;
        }
        this.f34502L.remove(pPSVideoRenderListener);
    }

    @OuterVisible
    public void removeVideoSizeChangeListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.f34501K.remove(onVideoSizeChangedListener);
    }

    @OuterVisible
    public void reset() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.36
            public RunnableC745336() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45785v();
            }
        });
    }

    @OuterVisible
    public void seekTo(int i10) {
        seekTo(i10, 0);
    }

    @OuterVisible
    public void seekToMillis(long j10, int i10) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.7

            /* renamed from: a */
            final /* synthetic */ long f34600a;

            /* renamed from: b */
            final /* synthetic */ int f34601b;

            public RunnableC74647(long j102, int i102) {
                j = j102;
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45796a(j, i);
            }
        });
    }

    @OuterVisible
    public void setDefaultDuration(int i10) {
        synchronized (this.f34527p) {
            this.f34523l = i10;
        }
    }

    @OuterVisible
    public void setMediaFile(String str) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.9

            /* renamed from: a */
            final /* synthetic */ String f34604a;

            public RunnableC74669(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaPlayerAgent.this.m45725b(str);
                } catch (C7111c e10) {
                    AbstractC7185ho.m43818a("MediaPlayerAgent", "set media file error:%s", e10.getMessage());
                    AbstractC7185ho.m43823c("MediaPlayerAgent", "set media file error:" + e10.getClass().getSimpleName());
                }
            }
        });
    }

    @OuterVisible
    public void setMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        m45798a(mediaPlayerReleaseListener);
    }

    @OuterVisible
    public void setPPSVideoRenderListener(PPSVideoRenderListener pPSVideoRenderListener) {
        m45799a(pPSVideoRenderListener);
    }

    @OuterVisible
    public void setPreferStartPlayTime(int i10) {
        this.f34524m = i10;
    }

    @OuterVisible
    public void setSoundVolume(float f10) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.14

            /* renamed from: a */
            final /* synthetic */ float f34544a;

            public RunnableC742914(float f102) {
                f = f102;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43818a("MediaPlayerAgent", "setSoundVolume %f result: %s", Float.valueOf(f), Boolean.valueOf(MediaPlayerAgent.this.m45727b(f)));
            }
        });
    }

    @OuterVisible
    public void setSurface(Surface surface) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.10

            /* renamed from: a */
            final /* synthetic */ Surface f34539a;

            public RunnableC742510(Surface surface2) {
                surface = surface2;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45700a(surface);
            }
        });
    }

    @OuterVisible
    public void setVideoSizeChangeListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        m45797a(onVideoSizeChangedListener);
    }

    @OuterVisible
    public void stop() {
        m45735c(true);
    }

    @OuterVisible
    public void stopWhenUrlMatchs(String str) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.4

            /* renamed from: a */
            final /* synthetic */ String f34589a;

            public RunnableC74574(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.f34517f)) {
                    return;
                }
                MediaPlayerAgent.this.m45748f();
            }
        });
    }

    public String toString() {
        return "MediaPlayerAgent@" + Integer.toHexString(hashCode()) + " [" + AbstractC7819dl.m48375a(this.f34517f) + "]";
    }

    @OuterVisible
    public void unmuteSound() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.13
            public RunnableC742813() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45766m();
            }
        });
    }

    /* renamed from: c */
    public MediaPlayer m45730c() {
        MediaPlayer mediaPlayer;
        synchronized (this.f34526o) {
            try {
                if (this.f34514c == null) {
                    MediaPlayer mediaPlayer2 = new MediaPlayer();
                    mediaPlayer2.setOnCompletionListener(this.f34505O);
                    mediaPlayer2.setOnPreparedListener(this.f34507Q);
                    mediaPlayer2.setOnErrorListener(this.f34508R);
                    mediaPlayer2.setOnBufferingUpdateListener(this.f34509S);
                    mediaPlayer2.setOnVideoSizeChangedListener(this.f34504N);
                    mediaPlayer2.setLooping(false);
                    mediaPlayer2.setAudioStreamType(3);
                    this.f34514c = mediaPlayer2;
                }
                mediaPlayer = this.f34514c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaPlayer;
    }

    /* renamed from: d */
    private void m45738d() throws IllegalStateException {
        try {
            m45725b(this.f34517f);
            AbstractC7185ho.m43821b("MediaPlayerAgent", "play - current state after set file: %s", this.f34525n);
            if (this.f34525n.isState(MediaState.State.INITIALIZED)) {
                m45726b(true);
            }
        } catch (C7111c e10) {
            AbstractC7185ho.m43818a("MediaPlayerAgent", "set media file error:%s", e10.getMessage());
            AbstractC7185ho.m43823c("MediaPlayerAgent", "set media file error:" + e10.getClass().getSimpleName());
            this.f34525n.m45810a(MediaState.State.ERROR);
            m45697a(0, -1, -1);
        }
    }

    /* renamed from: e */
    private void m45745e(int i10) {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyMediaStop playTime: %d", Integer.valueOf(i10));
        m45802b();
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.25

            /* renamed from: a */
            final /* synthetic */ int f34563a;

            public RunnableC744125(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34496F.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaStop(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        C7469b c7469b = this.f34513b;
        if (c7469b != null) {
            c7469b.m45828a(i102);
        }
    }

    /* renamed from: f */
    private void m45749f(int i10) {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyMediaPause playTime: %d", Integer.valueOf(i10));
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.26

            /* renamed from: a */
            final /* synthetic */ int f34565a;

            public RunnableC744226(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34496F.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaPause(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        C7469b c7469b = this.f34513b;
        if (c7469b != null) {
            c7469b.m45831b(i102);
        }
    }

    /* renamed from: j */
    public boolean m45761j() {
        MediaPlayer mediaPlayer;
        if (this.f34525n.m45811a()) {
            try {
                synchronized (this.f34526o) {
                    mediaPlayer = this.f34514c;
                }
                if (mediaPlayer != null) {
                    AbstractC7185ho.m43821b("MediaPlayerAgent", "in play %s", Boolean.valueOf(mediaPlayer.isPlaying()));
                    return mediaPlayer.isPlaying();
                }
            } catch (IllegalStateException unused) {
                AbstractC7185ho.m43823c("MediaPlayerAgent", "isPlaying IllegalStateException");
            }
        }
        return false;
    }

    /* renamed from: r */
    private void m45777r() {
        if (this.f34534w) {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "already muted, don't notify");
            return;
        }
        AbstractC7185ho.m43820b("MediaPlayerAgent", "notifyMute");
        this.f34534w = true;
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.28
            public RunnableC744428() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34499I.iterator();
                while (it.hasNext()) {
                    MuteListener muteListener = (MuteListener) it.next();
                    if (muteListener != null) {
                        muteListener.onMute();
                    }
                }
            }
        });
    }

    /* renamed from: s */
    private void m45779s() {
        if (!this.f34534w) {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "already unmuted, don't notify");
            return;
        }
        AbstractC7185ho.m43820b("MediaPlayerAgent", "notifyUnmute");
        this.f34534w = false;
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.29
            public RunnableC744529() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34499I.iterator();
                while (it.hasNext()) {
                    MuteListener muteListener = (MuteListener) it.next();
                    if (muteListener != null) {
                        muteListener.onUnmute();
                    }
                }
            }
        });
    }

    /* renamed from: t */
    public void m45781t() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("MediaPlayerAgent", VastAttribute.PROGRESS);
        }
        m45741d(this.f34516e);
        if (this.f34496F.size() > 0) {
            m45723b(this.f34511U);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.media.MediaPlayer, android.media.MediaPlayer$OnVideoSizeChangedListener] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: u */
    public void m45783u() {
        synchronized (this.f34526o) {
            try {
                MediaState mediaState = this.f34525n;
                MediaState.State state = MediaState.State.END;
                if (mediaState.isState(state)) {
                    return;
                }
                this.f34525n.m45810a(state);
                AbstractC7185ho.m43821b("MediaPlayerAgent", "release - agent: %s", this);
                f34490a.m47521b();
                m45785v();
                MediaPlayer mediaPlayer = this.f34514c;
                if (mediaPlayer != null) {
                    ?? r22 = 0;
                    r22 = 0;
                    try {
                        try {
                            mediaPlayer.setSurface(null);
                            this.f34514c.setOnVideoSizeChangedListener(null);
                            this.f34514c.release();
                            this.f34514c = null;
                            AbstractC7185ho.m43820b("MediaPlayerAgent", "release media player");
                            r22 = "release media player";
                        } catch (IllegalStateException unused) {
                            AbstractC7185ho.m43823c("MediaPlayerAgent", "media player reset surface IllegalStateException");
                            this.f34514c.setOnVideoSizeChangedListener(null);
                            this.f34514c.release();
                            this.f34514c = null;
                            AbstractC7185ho.m43820b("MediaPlayerAgent", "release media player");
                            r22 = "release media player";
                        }
                        m45772p();
                    } catch (Throwable th2) {
                        this.f34514c.setOnVideoSizeChangedListener(r22);
                        this.f34514c.release();
                        this.f34514c = r22;
                        AbstractC7185ho.m43820b("MediaPlayerAgent", "release media player");
                        m45772p();
                        throw th2;
                    }
                }
                this.f34496F.clear();
                this.f34497G.clear();
                this.f34498H.clear();
                this.f34499I.clear();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* renamed from: v */
    public void m45785v() {
        synchronized (this.f34526o) {
            try {
                AbstractC7185ho.m43821b("MediaPlayerAgent", "resetInternal - agent: %s", this);
                try {
                    try {
                        if (this.f34514c != null) {
                            if (this.f34525n.m45811a()) {
                                int currentPosition = this.f34514c.getCurrentPosition();
                                this.f34514c.stop();
                                if (this.f34525n.isState(MediaState.State.PLAYBACK_COMPLETED)) {
                                    currentPosition = 0;
                                }
                                m45745e(currentPosition);
                                m45696a(0, 0);
                                m45732c(0);
                            }
                            this.f34514c.reset();
                        }
                    } catch (IllegalStateException unused) {
                        AbstractC7185ho.m43823c("MediaPlayerAgent", "media player reset IllegalStateException");
                    }
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("MediaPlayerAgent", "media player reset exception: %s", th2.getClass().getSimpleName());
                }
                this.f34522k = 0;
                this.f34529r = 0;
                this.f34520i = false;
                this.f34532u = false;
                this.f34531t = false;
                this.f34533v = 0;
                this.f34491A = 0;
                this.f34525n.m45810a(MediaState.State.IDLE);
                m45774q();
                m45741d(this.f34516e);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* renamed from: w */
    private void m45787w() {
        String str;
        if (!m45791y()) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "audio focus is not needed");
            return;
        }
        try {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "requestAudioFocus");
            AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.f34512V).build();
            this.f34536y = audioFocusRequestBuild;
            this.f34530s.requestAudioFocus(audioFocusRequestBuild);
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            AbstractC7185ho.m43823c("MediaPlayerAgent", str);
        } catch (Exception e10) {
            str = "requestAudioFocus " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("MediaPlayerAgent", str);
        }
    }

    /* renamed from: x */
    public void m45789x() {
        String str;
        try {
            try {
                AbstractC7185ho.m43820b("MediaPlayerAgent", "abandonAudioFocus");
                Object obj = this.f34536y;
                if (obj instanceof AudioFocusRequest) {
                    this.f34530s.abandonAudioFocusRequest((AudioFocusRequest) obj);
                }
                this.f34536y = null;
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                AbstractC7185ho.m43823c("MediaPlayerAgent", str);
                this.f34532u = false;
                this.f34531t = false;
                this.f34533v = 0;
            } catch (Exception e10) {
                str = "abandonAudioFocus " + e10.getClass().getSimpleName();
                AbstractC7185ho.m43823c("MediaPlayerAgent", str);
                this.f34532u = false;
                this.f34531t = false;
                this.f34533v = 0;
            }
            this.f34532u = false;
            this.f34531t = false;
            this.f34533v = 0;
        } catch (Throwable th2) {
            this.f34532u = false;
            this.f34531t = false;
            this.f34533v = 0;
            throw th2;
        }
    }

    /* renamed from: y */
    private boolean m45791y() {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.f34535x), Boolean.valueOf(this.f34534w));
        if (this.f34535x == 0) {
            return true;
        }
        if (this.f34535x == 2) {
            return false;
        }
        return (this.f34535x == 1 && this.f34534w) ? false : true;
    }

    /* renamed from: a */
    public String m45793a() {
        return this.f34517f;
    }

    @OuterVisible
    public void play(Long l10) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.42

            /* renamed from: a */
            final /* synthetic */ Long f34593a;

            public RunnableC746042(Long l102) {
                l = l102;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                MediaPlayerAgent.this.m45708a(l);
            }
        });
    }

    @OuterVisible
    public void seekTo(int i10, int i11) {
        MediaPlayer mediaPlayer;
        try {
            if (!this.f34525n.m45811a() || this.f34520i) {
                return;
            }
            synchronized (this.f34526o) {
                mediaPlayer = this.f34514c;
            }
            int iM45756h = (m45756h() * i10) / 100;
            m45719b(mediaPlayer, iM45756h, i11);
            m45696a(i10, iM45756h);
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "seekTo IllegalStateException");
        }
    }

    /* renamed from: c */
    public void m45731c(float f10) {
        this.f34532u = false;
        if (m45727b(f10)) {
            m45779s();
        }
        if (this.f34535x == 1 && m45761j()) {
            m45787w();
        }
    }

    /* renamed from: d */
    public void m45739d(int i10) {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyMediaStart playTime: %d", Integer.valueOf(i10));
        m45787w();
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.24

            /* renamed from: a */
            final /* synthetic */ int f34561a;

            public RunnableC744024(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34496F.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaStart(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        C7469b c7469b = this.f34513b;
        if (c7469b != null) {
            c7469b.m45827a();
        }
    }

    /* renamed from: g */
    public void m45754g() throws IllegalStateException {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "pauseInternal before State: %s - agent: %s", this.f34525n, this);
        this.f34531t = false;
        if (this.f34525n.isState(MediaState.State.ERROR) || m45714a(this.f34525n) || m45728b(this.f34525n)) {
            return;
        }
        try {
            MediaPlayer mediaPlayerM45730c = m45730c();
            if (mediaPlayerM45730c.isPlaying()) {
                mediaPlayerM45730c.pause();
            }
            this.f34525n.m45810a(MediaState.State.PAUSED);
            m45749f(mediaPlayerM45730c.getCurrentPosition());
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "pause IllegalStateException");
            this.f34525n.m45810a(MediaState.State.ERROR);
        }
        m45774q();
        m45741d(this.f34516e);
        AbstractC7185ho.m43820b("MediaPlayerAgent", VastAttribute.PAUSE);
    }

    /* renamed from: a */
    public void m45794a(float f10) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.15

            /* renamed from: a */
            final /* synthetic */ float f34546a;

            public RunnableC743015(float f102) {
                f = f102;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45731c(f);
            }
        });
    }

    /* renamed from: b */
    public void m45802b() {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.37
            public RunnableC745437() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.m45789x();
            }
        });
    }

    /* renamed from: b */
    public void m45717b(int i10) {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyMediaCompletion playTime: %d", Integer.valueOf(i10));
        m45802b();
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.17

            /* renamed from: a */
            final /* synthetic */ int f34551a;

            public RunnableC743217(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34496F.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaCompletion(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        C7469b c7469b = this.f34513b;
        if (c7469b != null) {
            c7469b.m45829a(i102);
        }
    }

    /* renamed from: c */
    public void m45732c(int i10) {
        if (this.f34518g) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.18

                /* renamed from: a */
                final /* synthetic */ int f34553a;

                public RunnableC743318(int i102) {
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = MediaPlayerAgent.this.f34497G.iterator();
                    while (it.hasNext()) {
                        MediaBufferListener mediaBufferListener = (MediaBufferListener) it.next();
                        if (mediaBufferListener != null) {
                            mediaBufferListener.onBufferUpdate(i);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: g */
    public void m45755g(int i10) {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyDurationReady: %d", Integer.valueOf(i10));
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.30

            /* renamed from: a */
            final /* synthetic */ int f34575a;

            public RunnableC744730(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34500J.iterator();
                while (it.hasNext()) {
                    InterfaceC7470a interfaceC7470a = (InterfaceC7470a) it.next();
                    if (interfaceC7470a != null) {
                        interfaceC7470a.mo45566a(i);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void m45795a(int i10) {
        this.f34535x = i10;
    }

    /* renamed from: a */
    public void m45696a(int i10, int i11) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.16

            /* renamed from: a */
            final /* synthetic */ int f34548a;

            /* renamed from: b */
            final /* synthetic */ int f34549b;

            public RunnableC743116(int i102, int i112) {
                i = i102;
                i = i112;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34496F.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onProgress(i, i);
                    }
                }
            }
        });
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: b */
    public void m45718b(int i10, int i11) {
        AbstractC7185ho.m43820b("MediaPlayerAgent", "notifyVideoPictureNotPlaying");
        if (i11 < -10000 || i11 == -1004) {
            int i12 = this.f34491A;
            if (i12 < 20) {
                this.f34491A = i12 + 1;
                m45735c(false);
                play();
            } else {
                stop();
                this.f34508R.onError(m45730c(), i10, i11);
            }
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.31

            /* renamed from: a */
            final /* synthetic */ int f34577a;

            public RunnableC744831(int i112) {
                i = i112;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34500J.iterator();
                while (it.hasNext()) {
                    InterfaceC7470a interfaceC7470a = (InterfaceC7470a) it.next();
                    if (interfaceC7470a != null) {
                        interfaceC7470a.mo45567b(i);
                    }
                }
            }
        });
    }

    /* renamed from: d */
    public static void m45741d(String str) {
        f34490a.m47520a(str);
    }

    /* renamed from: a */
    public void m45697a(int i10, int i11, int i12) {
        AbstractC7185ho.m43821b("MediaPlayerAgent", "notifyError playTime: %d", Integer.valueOf(i10));
        m45802b();
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.27

            /* renamed from: a */
            final /* synthetic */ int f34567a;

            /* renamed from: b */
            final /* synthetic */ int f34568b;

            /* renamed from: c */
            final /* synthetic */ int f34569c;

            public RunnableC744327(int i102, int i112, int i122) {
                i = i102;
                i = i112;
                i = i122;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.f34498H.iterator();
                while (it.hasNext()) {
                    MediaErrorListener mediaErrorListener = (MediaErrorListener) it.next();
                    if (mediaErrorListener != null) {
                        mediaErrorListener.onError(MediaPlayerAgent.this, i, i, i);
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public static void m45719b(MediaPlayer mediaPlayer, long j10, int i10) {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(j10, i10);
        }
    }

    /* renamed from: c */
    private void m45734c(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException, C7111c {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer mediaPlayerM45730c = m45730c();
        if (Uri.parse(str).getScheme() == null) {
            mediaPlayerM45730c.setDataSource(str);
        } else {
            Scheme scheme = Scheme.FILE;
            if (str.startsWith(scheme.toString())) {
                str = str.substring(scheme.toString().length());
            } else if (str.startsWith(Scheme.DISKCACHE.toString())) {
                String strM41968c = C7019dh.m41937a(this.f34493C, Constants.NORMAL_CACHE).m41968c(str);
                if (!AbstractC7731ae.m47464d(new File(strM41968c))) {
                    strM41968c = C7019dh.m41937a(this.f34493C, Constants.TPLATE_CACHE).m41968c(str);
                }
                mediaPlayerM45730c.setDataSource(strM41968c);
            } else if (str.startsWith(Scheme.CONTENT.toString())) {
                if (!m45801a(str, mediaPlayerM45730c)) {
                    AbstractC7185ho.m43823c("MediaPlayerAgent", "set remote media fail");
                    throw new C7111c();
                }
            } else if (str.startsWith(Scheme.HTTP.toString()) || str.startsWith(Scheme.HTTPS.toString())) {
                this.f34518g = true;
            }
            mediaPlayerM45730c.setDataSource(str);
        }
        mediaPlayerM45730c.setVideoScalingMode(1);
        this.f34525n.m45810a(MediaState.State.INITIALIZED);
    }

    /* renamed from: d */
    public void m45742d(boolean z10) throws IllegalStateException {
        if (this.f34525n.isState(MediaState.State.END) || this.f34525n.isState(MediaState.State.ERROR) || this.f34525n.isState(MediaState.State.IDLE)) {
            return;
        }
        if (this.f34525n.m45811a() || this.f34525n.isState(MediaState.State.PREPARING)) {
            try {
                MediaPlayer mediaPlayerM45730c = m45730c();
                int currentPosition = mediaPlayerM45730c.getCurrentPosition();
                if (this.f34525n.m45811a() && !this.f34520i) {
                    mediaPlayerM45730c.stop();
                }
                if (this.f34525n.isState(MediaState.State.PLAYBACK_COMPLETED)) {
                    currentPosition = 0;
                }
                m45745e(currentPosition);
                if (z10) {
                    m45696a(0, 0);
                }
                this.f34525n.m45810a(MediaState.State.INITIALIZED);
            } catch (IllegalStateException unused) {
                AbstractC7185ho.m43823c("MediaPlayerAgent", "stop IllegalStateException");
                this.f34525n.m45810a(MediaState.State.ERROR);
            }
        }
        this.f34522k = 0;
        this.f34529r = 0;
        m45774q();
        m45741d(this.f34516e);
        AbstractC7185ho.m43821b("MediaPlayerAgent", "stop - agent: %s", this);
    }

    /* renamed from: c */
    private void m45735c(boolean z10) {
        m45723b(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.3

            /* renamed from: a */
            final /* synthetic */ boolean f34573a;

            public RunnableC74463(boolean z102) {
                z = z102;
            }

            @Override // java.lang.Runnable
            public void run() throws IllegalStateException {
                MediaPlayerAgent.this.m45742d(z);
            }
        });
    }

    /* renamed from: a */
    public void m45796a(long j10, int i10) {
        MediaPlayer mediaPlayer;
        try {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "seekToMillis " + j10);
            if (this.f34525n.m45811a()) {
                synchronized (this.f34526o) {
                    mediaPlayer = this.f34514c;
                }
                m45719b(mediaPlayer, j10, i10);
                long jM45756h = m45756h();
                if (jM45756h > 0) {
                    m45696a((int) ((100 * j10) / jM45756h), (int) j10);
                }
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "seekTo IllegalStateException");
        }
    }

    /* renamed from: a */
    public void m45797a(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.f34501K.add(onVideoSizeChangedListener);
    }

    /* renamed from: a */
    public void m45698a(MediaPlayer mediaPlayer, int i10, int i11) {
        Iterator<MediaPlayer.OnVideoSizeChangedListener> it = this.f34501K.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(mediaPlayer, i10, i11);
        }
    }

    /* renamed from: b */
    public static void m45723b(Runnable runnable) {
        f34490a.m47518a(runnable);
    }

    /* renamed from: a */
    public void m45700a(Surface surface) {
        String str;
        if (this.f34525n.isState(MediaState.State.END)) {
            return;
        }
        if (surface != null && !surface.isValid()) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "setSurfaceInternal - surface is invalid");
            return;
        }
        if (surface == m45762k()) {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "setSurfaceInternal - pass-in surface is the same as currentSurface");
            return;
        }
        this.f34537z = new WeakReference<>(surface);
        try {
            AbstractC7185ho.m43821b("MediaPlayerAgent", "setSurfaceInternal, prepareOnSetSurface: %s", Boolean.valueOf(this.f34495E));
            m45730c().setSurface(surface);
            if (this.f34495E) {
                this.f34495E = false;
                m45744e();
            }
        } catch (IllegalArgumentException unused) {
            str = "setSurface IllegalArgumentException";
            AbstractC7185ho.m43823c("MediaPlayerAgent", str);
        } catch (IllegalStateException unused2) {
            str = "setSurface IllegalStateException";
            AbstractC7185ho.m43823c("MediaPlayerAgent", str);
        }
    }

    /* renamed from: b */
    public static void m45724b(Runnable runnable, String str, long j10) {
        f34490a.m47519a(runnable, str, j10);
    }

    /* renamed from: b */
    public void m45725b(String str) throws C7111c {
        if (this.f34525n.isState(MediaState.State.END)) {
            return;
        }
        AbstractC7185ho.m43818a("MediaPlayerAgent", "setMediaFileUrl: %s", AbstractC7819dl.m48375a(str));
        MediaPlayer mediaPlayerM45730c = m45730c();
        try {
            if (this.f34525n.m45811a()) {
                mediaPlayerM45730c.stop();
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "setMediaFileUrl stop IllegalStateException");
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("MediaPlayerAgent", "setMediaFileUrl exception: %s", th2.getClass().getSimpleName());
        }
        try {
            mediaPlayerM45730c.reset();
            this.f34525n.m45810a(MediaState.State.IDLE);
        } catch (Throwable th3) {
            AbstractC7185ho.m43824c("MediaPlayerAgent", "mediaPlayer reset exception: %s", th3.getClass().getSimpleName());
        }
        this.f34517f = str;
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "media file url is empty");
            this.f34525n.m45810a(MediaState.State.ERROR);
            throw new C7111c("media file url is empty");
        }
        try {
            m45734c(str);
        } catch (Exception unused2) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "setMediaFileUrl Exception");
            this.f34525n.m45810a(MediaState.State.ERROR);
            throw new C7111c("setMediaFileUrl Exception");
        }
    }

    /* renamed from: b */
    private void m45726b(boolean z10) throws IllegalStateException {
        if (this.f34525n.isState(MediaState.State.END)) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("MediaPlayerAgent", "prepareMediaPlayer");
            this.f34525n.m45810a(MediaState.State.PREPARING);
            this.f34520i = true;
            m45730c().prepareAsync();
            if (z10) {
                m45768n();
            }
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "prepareMediaPlayer IllegalStateException");
            this.f34525n.m45810a(MediaState.State.ERROR);
            m45697a(0, -1, -1);
        }
    }

    /* renamed from: b */
    public boolean m45727b(float f10) {
        if (this.f34525n.isState(MediaState.State.END)) {
            return false;
        }
        try {
            m45730c().setVolume(f10, f10);
            return true;
        } catch (IllegalStateException unused) {
            AbstractC7185ho.m43823c("MediaPlayerAgent", "mute IllegalStateException");
            return false;
        }
    }

    /* renamed from: b */
    private boolean m45728b(MediaState mediaState) {
        return mediaState.isState(MediaState.State.END) || mediaState.isState(MediaState.State.PAUSED) || mediaState.isState(MediaState.State.PLAYBACK_COMPLETED);
    }

    /* renamed from: a */
    public void m45798a(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        if (mediaPlayerReleaseListener == null) {
            return;
        }
        this.f34503M.add(mediaPlayerReleaseListener);
    }

    /* renamed from: a */
    public void m45799a(PPSVideoRenderListener pPSVideoRenderListener) {
        if (pPSVideoRenderListener == null) {
            return;
        }
        this.f34502L.add(pPSVideoRenderListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b0 A[Catch: IllegalStateException -> 0x00c0, TryCatch #0 {IllegalStateException -> 0x00c0, blocks: (B:79:0x008a, B:81:0x008f, B:82:0x0093, B:86:0x00a4, B:90:0x00b4, B:89:0x00b0, B:83:0x0097, B:85:0x00a1), top: B:103:0x008a }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m45708a(java.lang.Long r9) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.media.MediaPlayerAgent.m45708a(java.lang.Long):void");
    }

    /* renamed from: a */
    public void m45800a(boolean z10) {
        this.f34492B = z10;
    }

    /* renamed from: a */
    private boolean m45714a(MediaState mediaState) {
        return mediaState.isState(MediaState.State.INITIALIZED) || mediaState.isState(MediaState.State.IDLE);
    }

    /* renamed from: a */
    public boolean m45801a(String str, MediaPlayer mediaPlayer) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = this.f34493C.getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "*/*", null);
        if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
            AbstractC7805cy.m48142a(assetFileDescriptorOpenTypedAssetFileDescriptor);
            return false;
        }
        try {
            if (assetFileDescriptorOpenTypedAssetFileDescriptor.getDeclaredLength() < 0) {
                mediaPlayer.setDataSource(assetFileDescriptorOpenTypedAssetFileDescriptor.getFileDescriptor());
            } else {
                mediaPlayer.setDataSource(assetFileDescriptorOpenTypedAssetFileDescriptor.getFileDescriptor(), assetFileDescriptorOpenTypedAssetFileDescriptor.getStartOffset(), assetFileDescriptorOpenTypedAssetFileDescriptor.getDeclaredLength());
            }
            AbstractC7805cy.m48142a(assetFileDescriptorOpenTypedAssetFileDescriptor);
            return true;
        } catch (Throwable th2) {
            AbstractC7805cy.m48142a(assetFileDescriptorOpenTypedAssetFileDescriptor);
            throw th2;
        }
    }
}
