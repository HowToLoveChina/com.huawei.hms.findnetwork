package com.huawei.hms.videokit.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.videokit.player.InitBufferTimeStrategy;
import com.huawei.hms.videokit.player.WisePlayer;
import com.huawei.hms.videokit.player.bean.PreviewPicture;
import com.huawei.hms.videokit.player.bean.Proxy;
import com.huawei.hms.videokit.player.bean.recommend.RecommendOptions;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.hms.videokit.player.internal.InterfaceC6566a;
import com.huawei.hms.videokit.player.internal.InterfaceC6567b;
import com.huawei.hms.videokit.player.internal.InterfaceC6568c;
import com.huawei.hms.videokit.player.internal.InterfaceC6570e;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;
import com.huawei.hms.videokit.player.internal.InterfaceC6573h;
import com.huawei.hms.videokit.player.internal.InterfaceC6574i;
import com.huawei.hms.videokit.player.internal.InterfaceC6575j;
import com.huawei.hms.videokit.player.internal.InterfaceC6577l;
import com.huawei.hms.videokit.player.internal.ObjectParameter;
import com.huawei.hms.videokit.player.internal.SubtitleInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.videokit.player.l */
/* loaded from: classes8.dex */
class C6584l implements WisePlayer {

    /* renamed from: G0 */
    private static final Map<Integer, Integer> f30545G0 = new d();

    /* renamed from: A */
    private InitBitrateParam f30546A;

    /* renamed from: B */
    private InitBufferTimeStrategy f30548B;

    /* renamed from: D */
    private Proxy f30552D;

    /* renamed from: I */
    private SurfaceView f30560I;

    /* renamed from: J */
    private TextureView f30561J;

    /* renamed from: K */
    private C6599t f30562K;

    /* renamed from: M */
    private InterfaceC6594q f30564M;

    /* renamed from: N */
    private C6590o f30565N;

    /* renamed from: a */
    private InterfaceC6571f f30578a;

    /* renamed from: d */
    private C6543b f30584d;

    /* renamed from: d0 */
    private View f30585d0;

    /* renamed from: e */
    private String f30586e;

    /* renamed from: e0 */
    private ImageView f30587e0;

    /* renamed from: f */
    private Context f30588f;

    /* renamed from: f0 */
    private WisePlayer.ReadyListener f30589f0;

    /* renamed from: g */
    private String f30590g;

    /* renamed from: g0 */
    private WisePlayer.LoadingListener f30591g0;

    /* renamed from: h */
    private String f30592h;

    /* renamed from: h0 */
    private WisePlayer.PlayEndListener f30593h0;

    /* renamed from: i */
    private String f30594i;

    /* renamed from: i0 */
    private WisePlayer.SeekEndListener f30595i0;

    /* renamed from: j0 */
    private WisePlayer.ResolutionUpdatedListener f30597j0;

    /* renamed from: k0 */
    private WisePlayer.SubtitleUpdateListener f30599k0;

    /* renamed from: l0 */
    private WisePlayer.EventListener f30601l0;

    /* renamed from: m0 */
    private WisePlayer.ErrorListener f30603m0;

    /* renamed from: n0 */
    private WisePlayer.PreviewPicListener f30605n0;

    /* renamed from: o0 */
    private volatile C6561h0 f30607o0;

    /* renamed from: v0 */
    private Future<?> f30621v0;

    /* renamed from: c */
    private C6556f f30582c = C6556f.m37359a();

    /* renamed from: j */
    private int f30596j = 0;

    /* renamed from: k */
    private int f30598k = 0;

    /* renamed from: l */
    private boolean f30600l = false;

    /* renamed from: m */
    private volatile boolean f30602m = false;

    /* renamed from: n */
    private boolean f30604n = false;

    /* renamed from: o */
    private boolean f30606o = false;

    /* renamed from: p */
    private boolean f30608p = false;

    /* renamed from: q */
    private boolean f30610q = false;

    /* renamed from: r */
    private boolean f30612r = true;

    /* renamed from: s */
    private int f30614s = 0;

    /* renamed from: t */
    private boolean f30616t = false;

    /* renamed from: u */
    private int f30618u = -1;

    /* renamed from: v */
    private float f30620v = 0.0f;

    /* renamed from: w */
    private boolean f30622w = true;

    /* renamed from: x */
    private float f30624x = 1.0f;

    /* renamed from: y */
    private int f30626y = 0;

    /* renamed from: z */
    private int f30628z = -1;

    /* renamed from: C */
    private AtomicBoolean f30550C = new AtomicBoolean(false);

    /* renamed from: E */
    private int f30554E = -1;

    /* renamed from: F */
    private int f30556F = -1;

    /* renamed from: G */
    private int f30558G = -1;

    /* renamed from: H */
    private int f30559H = -1;

    /* renamed from: L */
    private int f30563L = -1;

    /* renamed from: O */
    private AtomicBoolean f30566O = new AtomicBoolean(false);

    /* renamed from: P */
    private AtomicBoolean f30567P = new AtomicBoolean(false);

    /* renamed from: Q */
    private AtomicBoolean f30568Q = new AtomicBoolean(false);

    /* renamed from: R */
    private AtomicBoolean f30569R = new AtomicBoolean(false);

    /* renamed from: S */
    private AtomicBoolean f30570S = new AtomicBoolean(false);

    /* renamed from: T */
    private AtomicBoolean f30571T = new AtomicBoolean(false);

    /* renamed from: U */
    private final Object f30572U = new Object();

    /* renamed from: V */
    private boolean f30573V = true;

    /* renamed from: W */
    private boolean f30574W = false;

    /* renamed from: X */
    private boolean f30575X = false;

    /* renamed from: Y */
    private boolean f30576Y = false;

    /* renamed from: Z */
    private boolean f30577Z = true;

    /* renamed from: a0 */
    private boolean f30579a0 = false;

    /* renamed from: b0 */
    private boolean f30581b0 = false;

    /* renamed from: c0 */
    private boolean f30583c0 = false;

    /* renamed from: p0 */
    private Timer f30609p0 = null;

    /* renamed from: q0 */
    private C6548c f30611q0 = new C6548c();

    /* renamed from: r0 */
    private String f30613r0 = "0";

    /* renamed from: s0 */
    private AtomicBoolean f30615s0 = new AtomicBoolean(false);

    /* renamed from: t0 */
    private int f30617t0 = -1;

    /* renamed from: u0 */
    private CountDownLatch f30619u0 = null;

    /* renamed from: w0 */
    private InterfaceC6573h f30623w0 = new f();

    /* renamed from: x0 */
    private InterfaceC6568c f30625x0 = new g();

    /* renamed from: y0 */
    private InterfaceC6570e f30627y0 = new h();

    /* renamed from: z0 */
    private InterfaceC6575j f30629z0 = new i();

    /* renamed from: A0 */
    private InterfaceC6574i f30547A0 = new j();

    /* renamed from: B0 */
    private InterfaceC6577l f30549B0 = new k();

    /* renamed from: C0 */
    private InterfaceC6567b f30551C0 = new l();

    /* renamed from: D0 */
    private List<Integer> f30553D0 = new ArrayList();

    /* renamed from: E0 */
    private InterfaceC6566a f30555E0 = new a();

    /* renamed from: F0 */
    Handler f30557F0 = new b(Looper.getMainLooper());

    /* renamed from: b */
    private WisePlayer f30580b = this;

    /* renamed from: com.huawei.hms.videokit.player.l$a */
    public class a extends InterfaceC6566a.a {
        public a() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6566a
        /* renamed from: a */
        public boolean mo37404a(InterfaceC6571f interfaceC6571f, int i10, int i11, String str) throws RemoteException {
            C6550c1.m37264c("WisePlayerImp", "onError:" + i10 + " extra:" + i11);
            if ((C6584l.this.f30578a instanceof C6540a) && !(interfaceC6571f instanceof C6540a)) {
                C6550c1.m37264c("WisePlayerImp", "The PlayerCore and WP types are inconsistent");
                return true;
            }
            C6584l.this.m37540r();
            long jM37681c = C6600t0.m37681c();
            C6584l.this.f30564M.mo37629f(jM37681c);
            C6584l.this.m37543s();
            C6584l.this.m37544t();
            C6584l.this.m37520h();
            C6584l.this.f30564M.mo37604a(C6600t0.m37688f(), jM37681c, i10, i11, str);
            C6584l.this.m37504c();
            if (C6584l.this.m37496a(i10)) {
                C6584l.this.f30564M.mo37596a();
                C6584l.this.m37555z();
                return false;
            }
            C6584l.this.f30564M.mo37597a(4);
            if (C6543b.m37207b() != null) {
                C6543b.m37207b().m37209a(C6584l.this.f30594i + C6584l.this.f30598k);
            }
            WisePlayer.ErrorListener errorListener = C6584l.this.f30603m0;
            if (errorListener == null) {
                return false;
            }
            errorListener.onError(C6584l.this.f30580b, i10, i11);
            return false;
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$b */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            super.handleMessage(message);
            C6550c1.m37256a("WisePlayerImp", "mHandler handleMessage what:" + message.what);
            int i10 = message.what;
            if (i10 == 0) {
                C6584l.this.m37515f();
                return;
            }
            if (i10 == 1) {
                C6584l.this.m37550w();
                return;
            }
            if (i10 == 2) {
                C6584l.this.m37525j();
            } else if (i10 == 3) {
                C6584l.this.m37509d();
            } else {
                if (i10 != 4) {
                    return;
                }
                C6584l.this.m37530m();
            }
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$c */
    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C6584l.this.f30564M.mo37607a(C6584l.this.m37522i(), false);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$d */
    public class d extends HashMap<Integer, Integer> {
        public d() {
            put(208201, 1100);
            put(1, 1101);
            put(208203, 1101);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$e */
    public class e implements Callable {

        /* renamed from: a */
        final /* synthetic */ String f30633a;

        public e(String str) {
            this.f30633a = str;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            if (C6584l.this.f30588f != null) {
                C6550c1.m37256a("WisePlayerImp", "background authentication begin");
                C6584l.this.f30562K = new C6599t();
                long jM37688f = C6600t0.m37688f();
                C6560h c6560hM37652a = C6584l.this.f30562K.m37652a(C6584l.this.f30588f, this.f30633a, C6584l.this.f30592h, C6584l.this.f30596j, C6584l.this.f30598k);
                C6584l.this.f30564M.mo37628e(C6600t0.m37688f(), C6600t0.m37681c());
                C6584l.this.f30564M.mo37614b(C6584l.this.f30562K.m37657f());
                C6584l.this.f30564M.mo37631g(C6584l.this.f30562K.m37661j());
                String[] strArrM37376b = c6560hM37652a.m37376b();
                if (strArrM37376b.length > 0) {
                    C6584l.this.f30590g = strArrM37376b[0];
                    C6584l.this.f30584d.m37210a(this.f30633a + C6584l.this.f30598k, c6560hM37652a);
                }
                long jM37688f2 = C6600t0.m37688f();
                C6584l.this.f30564M.mo37624d(C6584l.this.f30562K.m37659h(), C6584l.this.f30562K.m37658g());
                C6584l.this.f30564M.mo37610a(C6584l.this.f30562K.m37663l(), C6584l.this.f30562K.m37653b(), C6584l.this.f30562K.m37660i());
                C6584l.this.f30564M.mo37605a(jM37688f, jM37688f2, C6584l.this.f30562K.m37656e(), C6584l.this.f30562K.m37662k(), C6584l.this.f30562K.m37651a());
                C6550c1.m37256a("WisePlayerImp", "background authentication end");
                if (C6584l.this.f30619u0 != null) {
                    try {
                        C6584l.this.f30619u0.await();
                    } catch (InterruptedException e10) {
                        C6550c1.m37258a("WisePlayerImp", "Exception:", e10);
                    }
                }
                C6584l.this.f30602m = false;
                C6550c1.m37256a("WisePlayerImp", "background latch.await end");
                if (strArrM37376b.length > 0) {
                    try {
                        C6550c1.m37256a("WisePlayerImp", "background reSetPlayUrl");
                        C6584l.this.m37495a(strArrM37376b);
                        C6584l.this.m37502b(c6560hM37652a.m37377c());
                        C6584l.this.f30564M.mo37602a(C6600t0.m37688f());
                        C6584l.this.ready();
                    } catch (Exception e11) {
                        C6550c1.m37258a("WisePlayerImp", "Exception:", e11);
                    }
                }
                C6584l.this.m37532n();
                return null;
            }
            return null;
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$f */
    public class f extends InterfaceC6573h.a {
        public f() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6573h
        /* renamed from: b */
        public void mo37418b(InterfaceC6571f interfaceC6571f) throws RemoteException {
            String str;
            if (C6584l.this.f30571T.get()) {
                str = "Reset status, the onReady callback returns directly";
            } else {
                if (!C6584l.this.f30570S.get()) {
                    C6584l.this.f30564M.mo37632h(C6600t0.m37688f());
                    WisePlayer.ReadyListener readyListener = C6584l.this.f30589f0;
                    if (readyListener != null) {
                        C6584l.this.f30570S.set(true);
                        readyListener.onReady(C6584l.this.f30580b);
                        return;
                    }
                    return;
                }
                str = "onReady() has been reported, not necessary to report again";
            }
            C6550c1.m37264c("WisePlayerImp", str);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$g */
    public class g extends InterfaceC6568c.a {
        public g() {
        }

        /* renamed from: f */
        private void m37558f(int i10) {
            C6550c1.m37256a("WisePlayerImp", "countStalling:" + i10 + ", isStartStatus:" + C6584l.this.f30566O.get() + ", isCountStalling:" + C6584l.this.f30567P.get());
            if (C6584l.this.f30566O.get() && C6584l.this.f30567P.get()) {
                long jM37681c = C6600t0.m37681c();
                if (i10 >= 100) {
                    C6584l.this.f30611q0.m37243a(jM37681c);
                    C6584l.this.f30564M.mo37629f(jM37681c);
                } else {
                    C6584l.this.f30611q0.m37246b(jM37681c);
                    C6584l.this.f30564M.mo37633i(jM37681c);
                }
            }
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6568c
        /* renamed from: a */
        public void mo37406a(InterfaceC6571f interfaceC6571f) throws RemoteException {
            String str;
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onStartPlaying callback returns directly");
                return;
            }
            C6550c1.m37256a("WisePlayerImp", "onStartPlaying");
            C6584l.this.f30615s0.set(true);
            C6584l.this.m37501b();
            WisePlayer.LoadingListener loadingListener = C6584l.this.f30591g0;
            C6584l.this.f30567P.set(true);
            C6584l.this.f30564M.mo37627e(C6600t0.m37681c());
            if (C6584l.this.f30577Z) {
                C6584l.this.f30577Z = false;
                if (C6584l.this.f30563L == 2) {
                    C6584l.this.m37543s();
                }
                C6584l.this.f30564M.mo37597a(1);
            }
            if (loadingListener != null) {
                try {
                    loadingListener.onStartPlaying(C6584l.this.f30580b);
                } catch (Error e10) {
                    e = e10;
                    str = "onStartPlaying error:";
                    C6550c1.m37258a("WisePlayerImp", str, e);
                } catch (Exception e11) {
                    e = e11;
                    str = "onStartPlaying e:";
                    C6550c1.m37258a("WisePlayerImp", str, e);
                }
            }
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6568c
        /* renamed from: a */
        public void mo37407a(InterfaceC6571f interfaceC6571f, int i10) throws RemoteException {
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onLoadingUpdate callback returns directly");
                return;
            }
            C6584l.this.m37518g();
            long jM37681c = C6600t0.m37681c();
            C6584l.this.f30564M.mo37635k(jM37681c);
            m37558f(i10);
            if (i10 >= 100 && C6584l.this.f30612r) {
                C6584l.this.f30612r = false;
                if (C6584l.this.f30563L == 2) {
                    C6584l.this.m37543s();
                }
                C6584l.this.f30564M.mo37615b(C6600t0.m37688f(), jM37681c);
            }
            if (i10 >= 100 && C6584l.this.f30573V) {
                C6584l.this.f30573V = false;
                C6584l.this.m37504c();
                C6584l.this.m37552x();
            }
            WisePlayer.LoadingListener loadingListener = C6584l.this.f30591g0;
            if (loadingListener != null) {
                try {
                    loadingListener.onLoadingUpdate(C6584l.this.f30580b, i10);
                } catch (Exception e10) {
                    C6550c1.m37258a("WisePlayerImp", "loading update error:", e10);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$h */
    public class h extends InterfaceC6570e.a {
        public h() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6570e
        /* renamed from: c */
        public void mo37410c(InterfaceC6571f interfaceC6571f) throws RemoteException {
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onPlayEnd callback returns directly");
                return;
            }
            C6550c1.m37264c("WisePlayerImp", "onPlayEnd cycleMode:" + C6584l.this.f30626y);
            C6584l.this.f30574W = true;
            C6584l.this.m37540r();
            long jM37681c = C6600t0.m37681c();
            C6584l.this.f30564M.mo37629f(jM37681c);
            C6584l.this.m37543s();
            C6584l.this.m37544t();
            C6584l.this.m37520h();
            C6584l.this.f30564M.mo37630f(C6600t0.m37688f(), jM37681c);
            C6584l.this.f30564M.mo37597a(4);
            C6584l.this.f30573V = true;
            C6584l.this.f30577Z = true;
            if (C6584l.this.f30626y == 1) {
                C6584l.this.f30575X = true;
                C6584l.this.f30564M.mo37613b(1);
                C6584l.this.start();
            } else {
                C6584l.this.m37504c();
                WisePlayer.PlayEndListener playEndListener = C6584l.this.f30593h0;
                if (playEndListener != null) {
                    playEndListener.onPlayEnd(C6584l.this.f30580b);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$i */
    public class i extends InterfaceC6575j.a {
        public i() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6575j
        /* renamed from: d */
        public void mo37420d(InterfaceC6571f interfaceC6571f) throws RemoteException {
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onSeekEnd callback returns directly");
                return;
            }
            C6550c1.m37264c("WisePlayerImp", "onSeekComplete");
            if (C6584l.this.f30574W) {
                C6584l.this.f30574W = false;
                return;
            }
            WisePlayer.SeekEndListener seekEndListener = C6584l.this.f30595i0;
            if (seekEndListener != null) {
                seekEndListener.onSeekEnd(C6584l.this.f30580b);
            }
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$j */
    public class j extends InterfaceC6574i.a {
        public j() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6574i
        /* renamed from: a */
        public void mo37419a(InterfaceC6571f interfaceC6571f, int i10, int i11) throws RemoteException {
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onResolutionUpdated callback returns directly");
                return;
            }
            WisePlayer.ResolutionUpdatedListener resolutionUpdatedListener = C6584l.this.f30597j0;
            if (resolutionUpdatedListener != null) {
                resolutionUpdatedListener.onResolutionUpdated(C6584l.this.f30580b, i10, i11);
            }
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$k */
    public class k extends InterfaceC6577l.a {
        public k() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6577l
        /* renamed from: a */
        public void mo37425a(InterfaceC6571f interfaceC6571f, SubtitleInfo[] subtitleInfoArr) throws RemoteException {
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onSubtitleUpdate callback returns directly");
                return;
            }
            WisePlayer.SubtitleUpdateListener subtitleUpdateListener = C6584l.this.f30599k0;
            if (subtitleUpdateListener != null) {
                subtitleUpdateListener.onSubtitleUpdate(C6584l.this.f30580b, subtitleInfoArr);
            }
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.l$l */
    public class l extends InterfaceC6567b.a {
        public l() {
        }

        @Override // com.huawei.hms.videokit.player.internal.InterfaceC6567b
        /* renamed from: a */
        public boolean mo37405a(InterfaceC6571f interfaceC6571f, int i10, int i11, ObjectParameter objectParameter) throws RemoteException {
            if (C6584l.this.f30571T.get()) {
                C6550c1.m37264c("WisePlayerImp", "Reset status, the onEvent callback returns directly");
                return false;
            }
            C6550c1.m37256a("WisePlayerImp", "onEvent what:" + i10 + " extra:" + i11 + " obj:" + objectParameter);
            WisePlayer.EventListener eventListener = C6584l.this.f30601l0;
            if (i10 == -1) {
                C6584l.this.f30564M.mo37603a(C6600t0.m37688f(), C6600t0.m37681c());
                return true;
            }
            if (i10 == 207) {
                C6584l.this.f30576Y = true;
                C6584l.this.f30557F0.removeMessages(1);
                C6584l.this.f30557F0.sendEmptyMessage(1);
            } else {
                if (i10 == 2000) {
                    C6584l.this.f30564M.mo37599a(1, Long.valueOf(C6600t0.m37688f()));
                    return true;
                }
                switch (i10) {
                    case 213:
                        if (C6584l.this.f30566O.get() && C6584l.this.f30567P.get()) {
                            C6584l.this.f30564M.mo37634j(C6600t0.m37681c());
                        }
                        C6584l.this.f30564M.mo37607a(C6584l.this.m37522i(), true);
                        C6584l.this.m37504c();
                        C6584l.this.m37552x();
                        if (objectParameter != null && (objectParameter.m37399a() instanceof String)) {
                            C6584l.this.f30564M.mo37609a((String) objectParameter.m37399a(), C6600t0.m37681c());
                            objectParameter = null;
                            break;
                        }
                        break;
                    case 214:
                        C6584l.this.m37537p();
                        C6584l.this.m37501b();
                        break;
                    case PlayerConstants.EventCode.VIDEO_MATCH_PRELOAD /* 215 */:
                        C6584l.this.f30564M.mo37621d();
                        break;
                }
            }
            if (eventListener != null) {
                eventListener.onEvent(C6584l.this.f30580b, i10, i11, objectParameter != null ? objectParameter.m37399a() : null);
            }
            return false;
        }
    }

    private C6584l(Context context, InterfaceC6571f interfaceC6571f, String str) {
        this.f30588f = context;
        this.f30578a = interfaceC6571f;
        this.f30586e = str;
        C6590o c6590o = new C6590o(new C6603v(context), "OMData_Thread_Imp");
        this.f30565N = c6590o;
        Object objM37570a = c6590o.m37570a();
        if (objM37570a instanceof InterfaceC6594q) {
            this.f30564M = (InterfaceC6594q) objM37570a;
        }
        this.f30584d = C6543b.m37207b();
        m37487a();
    }

    /* renamed from: A */
    private void m37460A() {
        m37462B();
        this.f30564M.mo37635k(C6600t0.m37681c());
    }

    /* renamed from: B */
    private void m37462B() {
        long jM37681c = C6600t0.m37681c();
        this.f30611q0.m37243a(jM37681c);
        this.f30564M.mo37629f(jM37681c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m37504c() {
        synchronized (this.f30572U) {
            try {
                if (this.f30609p0 != null) {
                    C6550c1.m37256a("WisePlayerImp", "cancel collect timer");
                    this.f30609p0.cancel();
                    this.f30609p0.purge();
                    this.f30609p0 = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m37520h() {
        try {
            IObjectWrapper iObjectWrapperMo37186c = this.f30578a.mo37186c(0);
            if (iObjectWrapperMo37186c != null) {
                this.f30564M.mo37599a(0, ObjectWrapper.unwrap(iObjectWrapperMo37186c));
            }
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "get first buffer complete time error:", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public long m37522i() {
        try {
            return this.f30578a.mo37166a();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "collectTimer: RemoteException", e10);
            return 0L;
        }
    }

    /* renamed from: l */
    private String m37528l() {
        StringBuilder sb2;
        String str;
        if (this.f30548B == null) {
            C6550c1.m37262b("WisePlayerImp", "initBufferTimeStrategy is null");
            return "";
        }
        StringBuilder sb3 = new StringBuilder();
        List<InitBufferTimeStrategy.DownloadMultipleZone> downloadMultipleZones = this.f30548B.getDownloadMultipleZones();
        for (int i10 = 0; i10 < downloadMultipleZones.size(); i10++) {
            InitBufferTimeStrategy.DownloadMultipleZone downloadMultipleZone = downloadMultipleZones.get(i10);
            if (downloadMultipleZone.getMin() == 0) {
                sb2 = new StringBuilder();
                str = "others:";
            } else {
                sb2 = new StringBuilder();
                sb2.append(downloadMultipleZone.getMin());
                str = ":";
            }
            sb2.append(str);
            sb2.append(downloadMultipleZone.getBufferTime());
            sb2.append(",");
            sb3.append(sb2.toString());
        }
        sb3.append("Window:" + this.f30548B.getMaxBufferTime());
        C6550c1.m37264c("WisePlayerImp", "setInitBufferTimeStrategy:" + sb3.toString());
        return sb3.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m37530m() {
        try {
            ImageView imageView = this.f30587e0;
            if (imageView != null) {
                ViewParent parent = imageView.getParent();
                if (parent instanceof ViewGroup) {
                    C6550c1.m37256a("WisePlayerImp", "removeLogo");
                    ((ViewGroup) parent).removeView(this.f30587e0);
                    this.f30587e0 = null;
                }
            }
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "removeLogo:", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m37532n() {
        if (this.f30603m0 != null) {
            try {
                Map<Integer, Integer> map = f30545G0;
                int iIntValue = map.containsKey(Integer.valueOf(this.f30562K.m37654c())) ? map.get(Integer.valueOf(this.f30562K.m37654c())).intValue() : PlayerConstants.ErrorCode.GET_URL_FAILED;
                C6550c1.m37264c("WisePlayerImp", "reportError errorCode:" + iIntValue);
                this.f30603m0.onError(this, iIntValue, this.f30562K.m37654c());
                if (iIntValue != 0) {
                    this.f30564M.mo37598a(iIntValue, this.f30562K.m37654c(), this.f30562K.m37655d());
                }
            } catch (Exception e10) {
                C6550c1.m37258a("WisePlayerImp", "reportError:", e10);
            }
        }
    }

    /* renamed from: o */
    private void m37534o() {
        try {
            this.f30578a.mo37172a(this.f30625x0);
            this.f30578a.mo37170a(this.f30555E0);
            this.f30578a.mo37171a(this.f30551C0);
            this.f30578a.mo37174a(this.f30623w0);
            this.f30578a.mo37173a(this.f30627y0);
            this.f30578a.mo37175a(this.f30547A0);
            this.f30578a.mo37176a(this.f30629z0);
            if (this.f30599k0 != null) {
                this.f30578a.mo37177a(this.f30549B0);
            } else {
                this.f30578a.mo37177a((InterfaceC6577l) null);
            }
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "reset listener error:", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m37540r() {
        this.f30611q0.m37243a(C6600t0.m37681c());
        m37537p();
        String strM37245b = this.f30611q0.m37245b();
        C6550c1.m37256a("WisePlayerImp", "setOMBitrateTrack record:" + strM37245b);
        if (C6600t0.m37683c(strM37245b)) {
            return;
        }
        this.f30564M.mo37608a(strM37245b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m37544t() {
        try {
            this.f30564M.mo37618c(this.f30578a.mo37185c());
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setPreconnectType:", e10);
        }
    }

    /* renamed from: y */
    private void m37553y() {
        this.f30557F0.removeCallbacksAndMessages(null);
        if (this.f30621v0 == null) {
            return;
        }
        try {
            C6550c1.m37256a("WisePlayerImp", "getUrlFuture isDone:" + this.f30621v0.isDone() + " isCancelled:" + this.f30621v0.isCancelled());
            if (this.f30621v0.isCancelled()) {
                return;
            }
            C6596r0.m37637a().m37639a(this.f30621v0);
            this.f30621v0 = null;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "stopUrlThread:", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m37555z() {
        try {
            int currentTime = this.f30578a.getCurrentTime();
            boolean z10 = true;
            this.f30579a0 = true;
            release();
            this.f30564M.mo37626e(0);
            this.f30578a = new C6540a();
            m37534o();
            int i10 = this.f30618u;
            if (i10 != -1) {
                this.f30578a.setVideoType(i10);
            }
            this.f30578a.setCycleMode(this.f30626y);
            this.f30578a.setPlayMode(this.f30614s);
            this.f30578a.setMute(this.f30622w);
            this.f30578a.setVolume(this.f30624x);
            this.f30578a.mo37178a(this.f30590g);
            if (currentTime > 0) {
                this.f30578a.setBookmark(currentTime);
            }
            this.f30578a.mo37187c(ObjectWrapper.wrap(this.f30585d0));
            this.f30578a.mo37184b(true);
            float f10 = this.f30620v;
            if (f10 != 0.0f) {
                this.f30578a.setPlaySpeed(f10);
            }
            InterfaceC6571f interfaceC6571f = this.f30578a;
            if (!this.f30566O.get() || !this.f30569R.get()) {
                z10 = false;
            }
            interfaceC6571f.mo37180a(z10);
            this.f30578a.ready();
            if (this.f30551C0 != null) {
                C6550c1.m37264c("WisePlayerImp", "switch player");
                if (this.f30552D != null) {
                    this.f30551C0.mo37405a(this.f30578a, PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY, 0, null);
                }
            }
            this.f30564M.mo37620c(C6600t0.m37688f(), C6600t0.m37681c());
            if (this.f30617t0 != -1) {
                this.f30578a.mo37168a(ObjectWrapper.wrap(this.f30588f), this.f30617t0);
            }
        } catch (RemoteException e10) {
            C6550c1.m37264c("WisePlayerImp", "switch player error :" + e10);
        }
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void closeLogo() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "closeLogo");
        this.f30557F0.sendEmptyMessage(3);
        try {
            this.f30578a.closeLogo();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "closeLogo:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void deselectSubtitleTrack() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "deselectSubtitleTrack");
        try {
            this.f30578a.deselectSubtitleTrack();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "deselectSubtitleTrack:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public AudioTrackInfo[] getAudioTracks() {
        AudioTrackInfo[] audioTracks;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getAudioTracks");
        try {
            audioTracks = this.f30578a.getAudioTracks();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "getAudioTracks:", e10);
            audioTracks = null;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return audioTracks;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getBufferTime() throws RemoteException {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37256a("WisePlayerImp", "getBufferTime");
        int bufferTime = 0;
        try {
            i10 = 0;
            bufferTime = this.f30578a.getBufferTime();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getBufferTime:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return bufferTime;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public long getBufferingSpeed() {
        long bufferingSpeed;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37256a("WisePlayerImp", "getBufferingSpeed");
        try {
            bufferingSpeed = this.f30578a.getBufferingSpeed();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getBufferingSpeed:", e10);
            bufferingSpeed = 0;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return bufferingSpeed;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public StreamInfo getCurrentStreamInfo() {
        StreamInfo currentStreamInfo;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getCurrentStreamInfo");
        try {
            currentStreamInfo = this.f30578a.getCurrentStreamInfo();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "getCurrentStreamInfo:", e10);
            currentStreamInfo = null;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return currentStreamInfo;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getCurrentTime() throws RemoteException {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37256a("WisePlayerImp", "getCurrentTime");
        int currentTime = 0;
        try {
            i10 = 0;
            currentTime = this.f30578a.getCurrentTime();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getCurrentTime:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return currentTime;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getCycleMode() {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getCycleMode");
        this.f30582c.m37362a(jM37688f, 0, this.f30586e);
        return this.f30626y;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getDuration() throws RemoteException {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getDuration");
        int duration = 0;
        int i10 = 1;
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the duration cannot be obtained for the live TV");
            return 0;
        }
        try {
            i10 = 0;
            duration = this.f30578a.getDuration();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getDuration:", e10);
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return duration;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getPlayMode() throws RemoteException {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getPlayMode");
        int playMode = 0;
        try {
            i10 = 0;
            playMode = this.f30578a.getPlayMode();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getPlayMode:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return playMode;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public float getPlaySpeed() {
        float playSpeed;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getPlaySpeed");
        try {
            playSpeed = this.f30578a.getPlaySpeed();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getPlaySpeed:", e10);
            playSpeed = 0.0f;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return playSpeed;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void getRecommendVideoList(String str, RecommendOptions recommendOptions, String str2, WisePlayer.IRecommendVideoCallback iRecommendVideoCallback) {
        long jM37688f = C6600t0.m37688f();
        if (this.f30607o0 == null) {
            synchronized (this) {
                try {
                    if (this.f30607o0 == null) {
                        this.f30607o0 = new C6561h0(this.f30588f);
                    }
                } finally {
                }
            }
        }
        this.f30607o0.m37388a(str, recommendOptions, str2, iRecommendVideoCallback);
        this.f30582c.m37362a(jM37688f, 0, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public AudioTrackInfo getSelectedAudioTrack() {
        AudioTrackInfo selectedAudioTrack;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getSelectedAudioTrack");
        try {
            selectedAudioTrack = this.f30578a.getSelectedAudioTrack();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "getSelectedAudioTrack:", e10);
            selectedAudioTrack = null;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return selectedAudioTrack;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public SubtitleTrackInfo getSelectedSubtitleTrack() {
        SubtitleTrackInfo selectedSubtitleTrack;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getSelectedSubtitleTrack");
        try {
            selectedSubtitleTrack = this.f30578a.getSelectedSubtitleTrack();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getSelectedSubtitleTrack:", e10);
            selectedSubtitleTrack = null;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return selectedSubtitleTrack;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public SubtitleTrackInfo[] getSubtitleTracks() {
        SubtitleTrackInfo[] subtitleTracks;
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getSubtitleTracks");
        try {
            subtitleTracks = this.f30578a.getSubtitleTracks();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getSubtitleTracks:", e10);
            subtitleTracks = null;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return subtitleTracks;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getVideoHeight() throws RemoteException {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getVideoHeight");
        int videoHeight = 0;
        try {
            i10 = 0;
            videoHeight = this.f30578a.getVideoHeight();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getVideoHeight:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return videoHeight;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public VideoInfo getVideoInfo() {
        VideoInfo videoInfo;
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            videoInfo = this.f30578a.getVideoInfo();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "getVideoInfo:", e10);
            videoInfo = null;
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return videoInfo;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int getVideoWidth() throws RemoteException {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "getVideoWidth");
        int videoWidth = 0;
        try {
            i10 = 0;
            videoWidth = this.f30578a.getVideoWidth();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "getVideoWidth:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return videoWidth;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public boolean isPlaying() throws RemoteException {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "isPlaying");
        boolean zIsPlaying = false;
        try {
            i10 = 0;
            zIsPlaying = this.f30578a.isPlaying();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "isPlaying:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
        return zIsPlaying;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void pause() {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", VastAttribute.PAUSE);
        int i10 = 0;
        this.f30567P.set(false);
        this.f30566O.set(false);
        this.f30569R.set(false);
        m37518g();
        m37460A();
        try {
            this.f30578a.pause();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "pause:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void presetAudioLanguage(String str) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "presetAudioLanguage");
        try {
            this.f30578a.presetAudioLanguage(str);
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "presetAudioLanguage:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void presetSubtitleLanguage(String str) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "presetSubtitleLanguage");
        try {
            this.f30578a.presetSubtitleLanguage(str);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "presetSubtitleLanguage:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void ready() {
        Proxy proxy;
        InterfaceC6571f interfaceC6571f;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "ready");
        int i10 = 0;
        if (this.f30602m) {
            this.f30564M.mo37620c(C6600t0.m37688f(), C6600t0.m37681c());
            String str = this.f30590g;
            if (str != null) {
                m37506c(str);
            }
            m37494a("");
            CountDownLatch countDownLatch = this.f30619u0;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } else {
            this.f30564M.mo37611a(true);
            this.f30564M.mo37597a(5);
            if (TextUtils.isEmpty(this.f30590g)) {
                try {
                    this.f30555E0.mo37404a(this.f30578a, 1100, 0, "The playback url set is empty");
                    return;
                } catch (Exception e10) {
                    C6550c1.m37258a("WisePlayerImp", "url set is empty, and onError:", e10);
                    return;
                }
            }
            if (this.f30604n) {
                View view = this.f30560I;
                if (view == null && (view = this.f30561J) == null) {
                    C6550c1.m37256a("WisePlayerImp", "set view fail");
                } else {
                    setView(view);
                }
                this.f30604n = false;
            }
            this.f30567P.set(false);
            this.f30564M.mo37628e(C6600t0.m37688f(), C6600t0.m37681c());
            try {
                proxy = this.f30552D;
            } catch (RemoteException e11) {
                C6550c1.m37258a("WisePlayerImp", "ready:", e11);
                i10 = 1;
            }
            try {
                if (proxy == null) {
                    interfaceC6571f = this.f30578a;
                } else if (proxy.getType() != Proxy.Type.SOCKS) {
                    if (this.f30551C0 != null) {
                        C6550c1.m37265d("WisePlayerImp", "not socks Proxy");
                        this.f30551C0.mo37405a(this.f30578a, PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY, 0, null);
                    }
                    C6580j.m37443b(0);
                    this.f30578a.ready();
                } else {
                    if (!this.f30552D.getHost().isEmpty() && !this.f30552D.getPort().isEmpty()) {
                        m37557v();
                        this.f30578a.ready();
                    }
                    interfaceC6571f = this.f30578a;
                }
                this.f30578a.ready();
            } catch (RemoteException e12) {
                C6550c1.m37258a("WisePlayerImp", "ready:", e12);
                i10 = 1;
            }
            interfaceC6571f.mo37179a("", "", "", "");
            C6580j.m37443b(0);
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void refreshPlayUrl(String str) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "refreshPlayUrl");
        int i10 = 0;
        this.f30567P.set(false);
        if (this.f30618u == 1) {
            try {
                this.f30578a.refreshPlayUrl(str);
            } catch (RemoteException e10) {
                C6550c1.m37258a("WisePlayerImp", "refreshPlayUrl:", e10);
                i10 = 1;
            }
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void release() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "release");
        m37540r();
        long jM37681c = C6600t0.m37681c();
        this.f30564M.mo37629f(jM37681c);
        m37543s();
        m37544t();
        if (!this.f30579a0) {
            m37520h();
            this.f30564M.mo37606a(C6600t0.m37688f(), jM37681c, this.f30574W, false);
            this.f30565N.m37571b();
        }
        m37553y();
        this.f30557F0.sendEmptyMessage(4);
        try {
            this.f30578a.release();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "release:", e10);
            i10 = 1;
        }
        this.f30612r = true;
        this.f30577Z = true;
        this.f30573V = true;
        this.f30579a0 = false;
        this.f30618u = -1;
        this.f30628z = -1;
        this.f30546A = null;
        this.f30548B = null;
        this.f30550C.set(false);
        this.f30558G = -1;
        this.f30559H = -1;
        this.f30554E = -1;
        this.f30556F = -1;
        this.f30619u0 = null;
        this.f30616t = false;
        this.f30568Q.set(false);
        this.f30570S.set(false);
        this.f30615s0.set(false);
        m37504c();
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void reset() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "reset");
        this.f30571T.set(true);
        m37540r();
        long jM37681c = C6600t0.m37681c();
        this.f30564M.mo37629f(jM37681c);
        m37543s();
        m37544t();
        m37520h();
        this.f30564M.mo37606a(C6600t0.m37688f(), jM37681c, this.f30574W, true);
        m37553y();
        this.f30557F0.sendEmptyMessage(4);
        this.f30585d0 = null;
        this.f30560I = null;
        this.f30561J = null;
        this.f30590g = null;
        this.f30562K = null;
        this.f30566O.set(false);
        this.f30569R.set(false);
        this.f30567P.set(false);
        this.f30570S.set(false);
        this.f30574W = false;
        this.f30579a0 = false;
        this.f30604n = false;
        this.f30602m = false;
        this.f30610q = false;
        this.f30606o = false;
        this.f30576Y = false;
        this.f30583c0 = false;
        this.f30608p = false;
        this.f30600l = false;
        this.f30612r = true;
        this.f30622w = false;
        this.f30614s = 0;
        this.f30626y = 0;
        this.f30620v = 0.0f;
        this.f30624x = 1.0f;
        this.f30618u = -1;
        this.f30628z = -1;
        this.f30546A = null;
        this.f30548B = null;
        this.f30550C.set(false);
        this.f30558G = -1;
        this.f30559H = -1;
        this.f30554E = -1;
        this.f30556F = -1;
        this.f30594i = "";
        this.f30581b0 = true;
        this.f30619u0 = null;
        this.f30568Q.set(false);
        this.f30616t = false;
        m37504c();
        try {
            this.f30578a.reset();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "reset:", e10);
            i10 = 1;
        }
        this.f30577Z = true;
        this.f30573V = true;
        this.f30615s0.set(false);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void resume(int i10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "resume");
        if (this.f30574W) {
            this.f30564M.mo37625e();
            this.f30564M.mo37613b(2);
        }
        int i11 = 1;
        if (this.f30583c0) {
            if (i10 == 0) {
                this.f30569R.set(true);
            } else if (i10 == 1) {
                this.f30569R.set(false);
            }
        }
        this.f30566O.set(true);
        this.f30574W = false;
        try {
            if (this.f30583c0 || !(this.f30578a instanceof C6540a)) {
                this.f30578a.resume(i10);
            } else {
                C6550c1.m37265d("WisePlayerImp", "Failed to called resume because start is not set");
            }
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "resume:", e10);
        }
        this.f30564M.mo37623d(C6600t0.m37681c());
        if (this.f30568Q.get()) {
            this.f30568Q.set(false);
            m37504c();
            m37552x();
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void seek(int i10) {
        int i11 = 1;
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the live TV does not support seek");
            return;
        }
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "seek");
        m37518g();
        this.f30567P.set(false);
        m37460A();
        if (this.f30574W) {
            this.f30564M.mo37625e();
            this.f30564M.mo37613b(2);
            this.f30574W = false;
        }
        try {
            this.f30578a.seek(i10);
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "seek:", e10);
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void selectAudioTrack(int i10) {
        int i11;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "selectAudioTrack");
        try {
            this.f30578a.selectAudioTrack(i10);
            i11 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "selectAudioTrack:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void selectSubtitleTrack(int i10) {
        int i11;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "selectSubtitleTrack");
        try {
            this.f30578a.selectSubtitleTrack(i10);
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "selectSubtitleTrack:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int setBandwidthSwitchMode(int i10) throws RemoteException {
        int i11;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setBandwidthSwitchMode mod:" + i10);
        int bandwidthSwitchMode = 0;
        try {
            bandwidthSwitchMode = this.f30578a.setBandwidthSwitchMode(i10);
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setBandwidthSwitchMode:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
        return bandwidthSwitchMode;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setBitrateRange(int i10, int i11) {
        int i12;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setBitrateRange minBitrate:" + i10 + " maxBitrate:" + i11);
        this.f30558G = i10;
        this.f30559H = i11;
        try {
            this.f30578a.setBitrateRange(i10, i11);
            i12 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setBitrateRange:", e10);
            i12 = 1;
        }
        this.f30582c.m37362a(jM37688f, i12, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setBookmark(int i10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setBookmark");
        int i11 = 1;
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the live TV does not support bookmark");
            return;
        }
        this.f30628z = i10;
        try {
            this.f30578a.setBookmark(i10);
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setBookmark:", e10);
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setBufferingStatus(boolean z10) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setBufferingStatus");
        if (!z10) {
            m37462B();
        }
        try {
            this.f30578a.setBufferingStatus(z10);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setBufferingStatus:", e10);
            i10 = 1;
        }
        this.f30564M.setBufferingStatus(z10);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setCycleMode(int i10) {
        int i11 = 1;
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the live TV does not support cycle mode");
            return;
        }
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setCycleMode mode:" + i10);
        if (i10 == 0 || i10 == 1) {
            this.f30626y = i10;
            try {
                this.f30578a.setCycleMode(i10);
                i11 = 0;
            } catch (RemoteException e10) {
                C6550c1.m37258a("WisePlayerImp", "setCycleMode:", e10);
            }
        } else {
            C6550c1.m37265d("WisePlayerImp", "mode is invalid");
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setErrorListener(WisePlayer.ErrorListener errorListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setErrorListener");
            this.f30603m0 = errorListener;
            this.f30578a.mo37170a(this.f30555E0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setErrorListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setEventListener(WisePlayer.EventListener eventListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setEventListener");
            this.f30601l0 = eventListener;
            this.f30578a.mo37171a(this.f30551C0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setEventListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setInitBitrate(InitBitrateParam initBitrateParam) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setInitBitrate");
        this.f30546A = initBitrateParam;
        try {
            this.f30578a.setInitBitrate(initBitrateParam);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setInitBitrate:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setInitBufferTimeStrategy(InitBufferTimeStrategy initBufferTimeStrategy) {
        C6550c1.m37264c("WisePlayerImp", "setInitBufferTimeStrategy");
        this.f30548B = initBufferTimeStrategy;
        if (this.f30550C.get()) {
            C6550c1.m37262b("WisePlayerImp", "current InitBufferTime Data is set");
            return;
        }
        int i10 = 1;
        this.f30550C.set(true);
        long jM37688f = C6600t0.m37688f();
        try {
            this.f30578a.mo37188c(m37528l());
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setInitBufferTimeStrategy remoteException:", e10);
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setLoadingListener(WisePlayer.LoadingListener loadingListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setLoadingListener");
            this.f30591g0 = loadingListener;
            this.f30578a.mo37172a(this.f30625x0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setLoadingListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setMute(boolean z10) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setMute");
        this.f30622w = z10;
        try {
            this.f30578a.setMute(z10);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setMute:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlayEndListener(WisePlayer.PlayEndListener playEndListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setPlayEndListener");
            this.f30593h0 = playEndListener;
            this.f30578a.mo37173a(this.f30627y0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setPlayEndListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlayMode(int i10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setPlayMode playMode:" + i10);
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the live TV does not support play mode reset");
            return;
        }
        if (this.f30614s != i10 && i10 == 0) {
            m37518g();
        }
        this.f30614s = i10;
        int i11 = 0;
        if (i10 == 0) {
            this.f30567P.set(false);
            m37462B();
        }
        try {
            this.f30578a.setPlayMode(i10);
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setPlayMode:", e10);
            i11 = 1;
        }
        this.f30557F0.removeMessages(1);
        this.f30557F0.sendEmptyMessage(1);
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlaySpeed(float f10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setPlaySpeed speed:" + f10);
        int i10 = 1;
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the live TV does not support play speed reset");
            return;
        }
        this.f30620v = f10;
        try {
            this.f30578a.setPlaySpeed(f10);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setPlaySpeed:", e10);
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlayUrl(String str) {
        String str2;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setPlayUrl");
        int i10 = 0;
        if (this.f30600l) {
            str2 = "already setPlayUrl";
        } else {
            if (!C6600t0.m37683c(str)) {
                m37494a(str);
                this.f30600l = true;
                this.f30571T.set(false);
                this.f30590g = str;
                this.f30563L = 1;
                this.f30564M.mo37600a(1, str);
                this.f30564M.mo37617c();
                this.f30564M.mo37613b(0);
                try {
                    this.f30578a.mo37191d(str);
                    this.f30578a.mo37178a(str);
                } catch (RemoteException e10) {
                    C6550c1.m37258a("WisePlayerImp", "setPlayUrl:", e10);
                    i10 = 1;
                }
                this.f30582c.m37362a(jM37688f, i10, this.f30586e);
            }
            str2 = "setPlayUrl url is null";
        }
        C6550c1.m37265d("WisePlayerImp", str2);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPreviewPicListener(WisePlayer.PreviewPicListener previewPicListener) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setPreviewPicListener");
        this.f30605n0 = previewPicListener;
        this.f30582c.m37362a(jM37688f, 0, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public int setProperties(int i10, Object... objArr) {
        int i11;
        long jM37688f = C6600t0.m37688f();
        int i12 = 1;
        try {
            i11 = 0;
            if (objArr.length != 0) {
                m37488a(i10, objArr[0]);
                i12 = 0;
            } else {
                C6550c1.m37262b("WisePlayerImp", "setProperties value is null");
            }
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setProperties:", e10);
            i11 = i12;
            i12 = -1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
        return i12;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setProxy(Proxy proxy) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setProxy");
        this.f30552D = proxy;
        int i10 = 0;
        try {
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setProxy:", e10);
            i10 = 1;
        }
        if (proxy == null) {
            this.f30578a.mo37179a("", "", "", "");
        } else {
            if (proxy.getType() == Proxy.Type.SOCKS) {
                if (TextUtils.isEmpty(this.f30552D.getHost()) || TextUtils.isEmpty(this.f30552D.getPort())) {
                    C6580j.m37443b(0);
                    this.f30578a.mo37179a("", "", "", "");
                } else {
                    m37557v();
                }
                this.f30582c.m37362a(jM37688f, i10, this.f30586e);
            }
            if (this.f30551C0 != null) {
                C6550c1.m37265d("WisePlayerImp", "not socks Proxy");
                this.f30551C0.mo37405a(this.f30578a, PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY, 0, null);
            }
        }
        C6580j.m37443b(0);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setReadyListener(WisePlayer.ReadyListener readyListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setReadyListener");
            this.f30589f0 = readyListener;
            this.f30578a.mo37174a(this.f30623w0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setReadyListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setResolutionUpdatedListener(WisePlayer.ResolutionUpdatedListener resolutionUpdatedListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setResolutionUpdatedListener");
            this.f30597j0 = resolutionUpdatedListener;
            this.f30578a.mo37175a(this.f30547A0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setResolutionUpdatedListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setSeekEndListener(WisePlayer.SeekEndListener seekEndListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setSeekEndListener");
            this.f30595i0 = seekEndListener;
            this.f30578a.mo37176a(this.f30629z0);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setOnSeekCompleteListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setSubtitleUpdateListener(WisePlayer.SubtitleUpdateListener subtitleUpdateListener) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        try {
            C6550c1.m37264c("WisePlayerImp", "setSubtitleUpdateListener:" + subtitleUpdateListener);
            this.f30599k0 = subtitleUpdateListener;
            if (subtitleUpdateListener != null) {
                this.f30578a.mo37177a(this.f30549B0);
            } else {
                this.f30578a.mo37177a((InterfaceC6577l) null);
            }
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setSubtitleUpdateListener:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setSurfaceChange() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setSurfaceChange");
        if (this.f30606o && this.f30585d0 != null && this.f30587e0 != null) {
            this.f30557F0.sendEmptyMessage(2);
        }
        try {
            this.f30578a.setSurfaceChange();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setSurfaceChange:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setVideoType(int i10) {
        int i11;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setVideoType videoType:" + i10);
        this.f30564M.setVideoType(i10);
        this.f30618u = i10;
        try {
            this.f30578a.setVideoType(i10);
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setVideoType:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setView(View view) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setView");
        int i10 = 1;
        if (this.f30602m) {
            this.f30604n = true;
            if (view instanceof SurfaceView) {
                this.f30560I = (SurfaceView) view;
            } else if (view instanceof TextureView) {
                this.f30561J = (TextureView) view;
            } else {
                C6550c1.m37262b("WisePlayerImp", "view is invalid");
            }
            i10 = 0;
        } else {
            try {
                this.f30578a.mo37187c(ObjectWrapper.wrap(view));
                i10 = 0;
            } catch (RemoteException e10) {
                C6550c1.m37258a("WisePlayerImp", "setView:", e10);
            }
        }
        this.f30585d0 = view;
        this.f30557F0.sendEmptyMessage(0);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setVolume(float f10) {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setVolume volume:" + f10);
        this.f30624x = f10;
        try {
            this.f30578a.setVolume(f10);
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setVolume:", e10);
            i10 = 1;
        }
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setWakeMode(Context context, int i10) {
        int i11;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setWakeMode");
        try {
            this.f30617t0 = i10;
            this.f30578a.mo37168a(ObjectWrapper.wrap(context), i10);
            i11 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "set wake mode error:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void start() {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "start");
        this.f30564M.mo37623d(C6600t0.m37681c());
        int i10 = 0;
        if (this.f30574W) {
            this.f30564M.mo37625e();
            if (!this.f30575X) {
                this.f30564M.mo37613b(2);
            }
            this.f30567P.set(false);
            this.f30575X = false;
        }
        try {
            this.f30578a.start();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "start:", e10);
            i10 = 1;
        }
        this.f30583c0 = true;
        this.f30566O.set(true);
        this.f30569R.set(true);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void stop() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "stop");
        m37544t();
        m37553y();
        try {
            this.f30578a.stop();
            i10 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "stop:", e10);
            i10 = 1;
        }
        m37540r();
        this.f30564M.mo37629f(C6600t0.m37681c());
        m37543s();
        this.f30564M.mo37597a(4);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void suspend() {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "suspend");
        int i10 = 0;
        this.f30567P.set(false);
        this.f30566O.set(false);
        m37518g();
        m37460A();
        try {
            this.f30578a.suspend();
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "suspend:", e10);
            i10 = 1;
        }
        this.f30564M.mo37619c(C6600t0.m37681c());
        this.f30568Q.set(true);
        m37504c();
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void switchBitrateDesignated(int i10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "switchBitrateDesignated");
        int i11 = 0;
        this.f30567P.set(false);
        m37460A();
        m37518g();
        try {
            this.f30578a.switchBitrateDesignated(i10);
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "switchBitrateDesignated:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void switchBitrateSmooth(int i10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "switchBitrateSmooth");
        int i11 = 0;
        this.f30567P.set(false);
        m37462B();
        try {
            this.f30578a.switchBitrateSmooth(i10);
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "switchBitrateSmooth:", e10);
            i11 = 1;
        }
        this.f30582c.m37362a(jM37688f, i11, this.f30586e);
    }

    /* renamed from: a */
    public static C6584l m37485a(Context context, String str) {
        return new C6584l(context, new C6551d(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m37509d() {
        C6550c1.m37264c("WisePlayerImp", "closeLogo");
        this.f30610q = true;
        ImageView imageView = this.f30587e0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: e */
    private void m37512e() {
        if (this.f30578a instanceof C6540a) {
            return;
        }
        this.f30578a = new C6540a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m37515f() throws Throwable {
        ViewGroup viewGroup;
        if (this.f30585d0 == null) {
            C6550c1.m37265d("WisePlayerImp", "createLogo view is null");
            return;
        }
        C6550c1.m37256a("WisePlayerImp", "create logo");
        ImageView imageView = this.f30587e0;
        if (imageView != null && (viewGroup = (ViewGroup) imageView.getParent()) != null) {
            viewGroup.removeView(this.f30587e0);
            this.f30587e0 = null;
        }
        this.f30587e0 = new ImageView(this.f30585d0.getContext());
        ViewGroup.LayoutParams layoutParams = this.f30585d0.getLayoutParams();
        ViewGroup viewGroup2 = (ViewGroup) this.f30585d0.getParent();
        m37539q();
        this.f30587e0.setVisibility(8);
        if (viewGroup2 != null) {
            try {
                viewGroup2.addView(this.f30587e0, -1, layoutParams);
                C6550c1.m37256a("WisePlayerImp", "has been added successfully");
            } catch (Exception e10) {
                C6550c1.m37258a("WisePlayerImp", "addView:", e10);
            }
        } else {
            C6550c1.m37265d("WisePlayerImp", "view.getParent is null");
        }
        m37525j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m37518g() {
        this.f30611q0.m37247c(C6600t0.m37681c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m37525j() {
        ViewGroup.MarginLayoutParams layoutParams;
        View view = this.f30585d0;
        if (view == null) {
            C6550c1.m37265d("WisePlayerImp", "layoutLogo view is null");
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        } else {
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                this.f30608p = false;
                m37550w();
            }
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        m37490a(layoutParams);
        this.f30608p = true;
        m37550w();
    }

    /* renamed from: k */
    private boolean m37527k() {
        return !this.f30610q && this.f30608p && this.f30606o && this.f30614s == 0 && this.f30576Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m37537p() {
        if (!this.f30613r0.equals("0")) {
            m37518g();
            this.f30611q0.m37244a(this.f30613r0);
        }
        try {
            StreamInfo currentStreamInfo = this.f30578a.getCurrentStreamInfo();
            if (currentStreamInfo != null) {
                this.f30613r0 = String.valueOf(currentStreamInfo.getBitrate());
            } else {
                this.f30613r0 = "0";
            }
        } catch (RemoteException unused) {
            C6550c1.m37265d("WisePlayerImp", "getCurrentStreamInfo fail");
            this.f30613r0 = "0";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ResourceType"})
    /* renamed from: q */
    private void m37539q() throws Throwable {
        InputStream inputStreamOpenRawResource;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedInputStream = null;
        BufferedInputStream bufferedInputStream3 = null;
        bufferedInputStream2 = null;
        try {
            try {
                inputStreamOpenRawResource = this.f30588f.getResources().openRawResource(C6532R.drawable.hw_himovie_logo);
                try {
                    bufferedInputStream = new BufferedInputStream(inputStreamOpenRawResource);
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                        this.f30587e0.setImageBitmap(bitmapDecodeStream);
                        bufferedInputStream2 = bitmapDecodeStream;
                    } catch (Exception e10) {
                        e = e10;
                        bufferedInputStream3 = bufferedInputStream;
                        C6550c1.m37258a("WisePlayerImp", "load logo view error:", e);
                        bufferedInputStream = bufferedInputStream3;
                        bufferedInputStream2 = bufferedInputStream3;
                        C6563i0.m37397a(inputStreamOpenRawResource);
                        C6563i0.m37397a(bufferedInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        C6563i0.m37397a(inputStreamOpenRawResource);
                        C6563i0.m37397a(bufferedInputStream2);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                inputStreamOpenRawResource = null;
            } catch (Throwable th3) {
                th = th3;
                inputStreamOpenRawResource = null;
            }
            C6563i0.m37397a(inputStreamOpenRawResource);
            C6563i0.m37397a(bufferedInputStream);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m37543s() {
        try {
            this.f30564M.mo37616b(this.f30578a.mo37182b());
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setOMCdnUrl:", e10);
        }
    }

    /* renamed from: u */
    private void m37547u() {
        int i10 = 0;
        try {
            this.f30581b0 = false;
            int i11 = this.f30618u;
            if (i11 != -1) {
                this.f30578a.setVideoType(i11);
            }
            this.f30578a.setCycleMode(this.f30626y);
            this.f30578a.setPlayMode(this.f30614s);
            this.f30578a.mo37189c(this.f30616t);
            this.f30578a.setMute(this.f30622w);
            this.f30578a.setVolume(this.f30624x);
            int i12 = this.f30628z;
            if (i12 > 0) {
                this.f30578a.setBookmark(i12);
            }
            this.f30578a.mo37184b(false);
            this.f30578a.setBitrateRange(this.f30558G, this.f30559H);
            InitBitrateParam initBitrateParam = this.f30546A;
            if (initBitrateParam != null) {
                this.f30578a.setInitBitrate(initBitrateParam);
            }
            float f10 = this.f30620v;
            if (f10 != 0.0f) {
                this.f30578a.setPlaySpeed(f10);
            }
            if (this.f30548B != null) {
                this.f30578a.mo37188c(m37528l());
            }
            int i13 = this.f30554E;
            if (i13 != -1) {
                this.f30578a.mo37193e(i13 != 0);
            }
            int i14 = this.f30556F;
            if (i14 != -1) {
                if (i14 != 0) {
                    i10 = 1;
                }
                this.f30578a.mo37190d(i10);
            }
            if (this.f30617t0 != -1) {
                this.f30578a.mo37168a(ObjectWrapper.wrap(this.f30588f), this.f30617t0);
            }
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "reset play param error:", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m37550w() {
        ImageView imageView;
        int i10;
        if (this.f30587e0 == null) {
            C6550c1.m37256a("WisePlayerImp", "show logo view is null");
            return;
        }
        C6550c1.m37256a("WisePlayerImp", "showLogo isCloseLogo:" + this.f30610q + " hasRenderStart:" + this.f30576Y + " isHMMediaInfo:" + this.f30606o + " enableLayout:" + this.f30608p + " playMode:" + this.f30614s);
        if (m37527k()) {
            C6550c1.m37264c("WisePlayerImp", "showLogo");
            imageView = this.f30587e0;
            i10 = 0;
        } else {
            imageView = this.f30587e0;
            i10 = 8;
        }
        imageView.setVisibility(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m37552x() {
        synchronized (this.f30572U) {
            C6550c1.m37256a("WisePlayerImp", "start collect timer");
            Timer timer = new Timer(true);
            this.f30609p0 = timer;
            try {
                timer.scheduleAtFixedRate(new c(), 1000L, 1000L);
            } catch (IllegalStateException e10) {
                C6550c1.m37258a("WisePlayerImp", "collectTimer: scheduleAtFixedRate error:", e10);
            }
        }
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void seek(int i10, int i11) {
        int i12 = 1;
        if (i11 != 1) {
            seek(i10);
            return;
        }
        if (this.f30618u == 1) {
            C6550c1.m37265d("WisePlayerImp", "the live TV does not support seek");
            return;
        }
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "seekPrecisely");
        m37518g();
        this.f30567P.set(false);
        m37460A();
        if (this.f30574W) {
            this.f30564M.mo37625e();
            this.f30564M.mo37613b(2);
            this.f30574W = false;
        }
        try {
            this.f30578a.mo37192e(i10);
            i12 = 0;
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "seekPrecisely:", e10);
        }
        this.f30582c.m37362a(jM37688f, i12, this.f30586e);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlayUrl(String str, String str2, int i10) {
        setPlayUrl(str, str2, i10, 0);
    }

    /* renamed from: v */
    public void m37557v() {
        try {
            this.f30578a.mo37179a(this.f30552D.getHost(), this.f30552D.getPort(), this.f30552D.getUser(), this.f30552D.getPasswd());
            if (this.f30578a instanceof C6540a) {
                return;
            }
            C6580j.m37443b(1);
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "setProxyAndOMDataUseProxy:", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m37501b() {
        this.f30611q0.m37248d(C6600t0.m37681c());
    }

    /* renamed from: c */
    private void m37506c(String str) {
        try {
            this.f30621v0 = C6596r0.m37637a().m37638a(new e(str));
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "call:", e10);
            m37532n();
        }
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlayUrl(String str, String str2, int i10, int i11) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setPlayUrl videoFormat:" + i11);
        if (this.f30600l) {
            C6550c1.m37265d("WisePlayerImp", "already setPlayUrl");
            this.f30582c.m37362a(jM37688f, 0, this.f30586e);
            return;
        }
        if (C6600t0.m37683c(str)) {
            C6550c1.m37265d("WisePlayerImp", "setPlayUrl playParam is null");
            this.f30582c.m37362a(jM37688f, 0, this.f30586e);
            return;
        }
        this.f30592h = str2;
        this.f30596j = i10;
        this.f30590g = str;
        this.f30598k = i11;
        this.f30594i = str;
        this.f30606o = true;
        this.f30571T.set(false);
        this.f30563L = 2;
        this.f30564M.mo37601a(2, str, str2);
        this.f30564M.mo37617c();
        this.f30564M.mo37613b(0);
        C6560h c6560hM37211b = this.f30584d.m37211b(str + i11);
        if (c6560hM37211b.m37378d()) {
            C6550c1.m37264c("WisePlayerImp", "use cache play url");
            this.f30602m = false;
            String str3 = c6560hM37211b.m37376b()[0];
            this.f30590g = str3;
            try {
                m37494a(str3);
                m37495a(c6560hM37211b.m37376b());
                m37502b(c6560hM37211b.m37377c());
                this.f30564M.mo37610a(C6598s0.m37645b(this.f30588f), "", "");
                this.f30564M.mo37612b();
            } catch (Exception e10) {
                C6550c1.m37258a("WisePlayerImp", "Exception: ", e10);
                m37532n();
                return;
            }
        } else {
            this.f30602m = true;
            if (this.f30619u0 == null) {
                this.f30619u0 = new CountDownLatch(1);
            }
        }
        this.f30582c.m37362a(jM37688f, 0, this.f30586e);
    }

    /* renamed from: a */
    private void m37487a() {
        this.f30553D0.add(1002);
        this.f30553D0.add(1003);
        this.f30553D0.add(1004);
        this.f30553D0.add(1000);
        this.f30553D0.add(Integer.valueOf(PlayerConstants.ErrorCode.INVALID_SERVER));
        this.f30553D0.add(Integer.valueOf(PlayerConstants.ErrorCode.NO_SSL_CERTIFICATE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m37502b(String str) {
        PreviewPicture previewPicture;
        if (this.f30605n0 == null) {
            C6550c1.m37264c("WisePlayerImp", "previewPicListener is null, not need further treatment");
            return;
        }
        try {
            previewPicture = (PreviewPicture) new Gson().fromJson(str, PreviewPicture.class);
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerImp", "parse preview picture json error:", e10);
            previewPicture = null;
        }
        m37491a(previewPicture);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayer
    public void setPlayUrl(String[] strArr) {
        String str;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerImp", "setPlayUrl urlArray");
        int i10 = 0;
        if (this.f30600l) {
            str = "already setPlayUrl";
        } else {
            if (strArr != null && !C6600t0.m37683c(strArr[0])) {
                this.f30600l = true;
                this.f30571T.set(false);
                String str2 = strArr[0];
                this.f30590g = str2;
                m37494a(str2);
                this.f30563L = 1;
                this.f30564M.mo37600a(1, this.f30590g);
                this.f30564M.mo37617c();
                this.f30564M.mo37613b(0);
                try {
                    this.f30578a.mo37191d(this.f30590g);
                    this.f30578a.mo37181a(strArr);
                } catch (RemoteException e10) {
                    C6550c1.m37258a("WisePlayerImp", "setPlayUrl:", e10);
                    i10 = 1;
                }
                this.f30582c.m37362a(jM37688f, i10, this.f30586e);
            }
            str = "setMediaUrlArray urlArray is null";
        }
        C6550c1.m37265d("WisePlayerImp", str);
        this.f30582c.m37362a(jM37688f, i10, this.f30586e);
    }

    /* renamed from: a */
    private void m37488a(int i10, Object obj) throws RemoteException {
        if (i10 == 1) {
            if (obj instanceof Boolean) {
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                this.f30554E = zBooleanValue ? 1 : 0;
                this.f30578a.mo37193e(zBooleanValue);
                return;
            }
            return;
        }
        if (i10 == 2) {
            if (obj instanceof Boolean) {
                boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
                this.f30556F = zBooleanValue2 ? 1 : 0;
                this.f30578a.mo37190d(zBooleanValue2 ? 1 : 0);
                return;
            }
            return;
        }
        if (i10 == 3) {
            if (obj instanceof Integer) {
                boolean z10 = ((Integer) obj).intValue() == 1;
                this.f30616t = z10;
                this.f30578a.mo37189c(z10);
                return;
            }
            return;
        }
        if (i10 == 4) {
            if (obj instanceof Integer) {
                this.f30578a.mo37183b(((Integer) obj).intValue());
            }
        } else {
            C6550c1.m37265d("WisePlayerImp", "unknow key:" + i10);
        }
    }

    /* renamed from: a */
    private void m37489a(Context context) {
        try {
            IBinder iBinderM37341a = C6554e.m37335a(context).m37341a("com.huawei.hms.videokit.player.PlayerCore");
            if (iBinderM37341a != null) {
                InterfaceC6571f interfaceC6571fM37411a = InterfaceC6571f.a.m37411a(iBinderM37341a);
                if (interfaceC6571fM37411a != null) {
                    interfaceC6571fM37411a.mo37169a(ObjectWrapper.wrap(context), ObjectWrapper.wrap(C6554e.m37335a(context).m37343c()));
                    this.f30578a = interfaceC6571fM37411a;
                }
            } else {
                m37512e();
            }
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "create WisePlayerImp fail ", e10);
        }
    }

    /* renamed from: a */
    private void m37490a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int right;
        int iM37666a;
        int right2;
        int right3;
        int right4;
        int right5;
        int i10;
        int iM37666a2;
        if (this.f30587e0 == null) {
            C6550c1.m37265d("WisePlayerImp", "layoutImageView view is null");
            return;
        }
        int iM37666a3 = C6600t0.m37666a(this.f30588f, 78);
        int iM37666a4 = C6600t0.m37666a(this.f30588f, 21);
        marginLayoutParams.width = iM37666a3;
        marginLayoutParams.height = iM37666a4;
        WindowManager windowManager = (WindowManager) this.f30588f.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        if (C6600t0.m37695l()) {
            if (!C6600t0.m37693j() || C6600t0.m37689f(this.f30588f)) {
                if (C6585l0.m37559a(this.f30588f)) {
                    right4 = displayMetrics.widthPixels;
                    right5 = this.f30585d0.getRight();
                    i10 = right4 - right5;
                    iM37666a2 = C6600t0.m37666a(this.f30588f, 24);
                } else {
                    right2 = displayMetrics.widthPixels;
                    right3 = this.f30585d0.getRight();
                    i10 = right2 - right3;
                    iM37666a2 = C6600t0.m37666a(this.f30588f, 16);
                }
            } else if (C6585l0.m37559a(this.f30588f)) {
                right4 = displayMetrics.widthPixels - this.f30585d0.getRight();
                right5 = C6600t0.m37686e(this.f30588f);
                i10 = right4 - right5;
                iM37666a2 = C6600t0.m37666a(this.f30588f, 24);
            } else {
                right2 = displayMetrics.widthPixels - this.f30585d0.getRight();
                right3 = C6600t0.m37686e(this.f30588f);
                i10 = right2 - right3;
                iM37666a2 = C6600t0.m37666a(this.f30588f, 16);
            }
            marginLayoutParams.rightMargin = i10 + iM37666a2;
        } else {
            if (C6585l0.m37559a(this.f30588f)) {
                right = this.f30585d0.getRight() - iM37666a3;
                iM37666a = C6600t0.m37666a(this.f30588f, 24);
            } else {
                right = this.f30585d0.getRight() - iM37666a3;
                iM37666a = C6600t0.m37666a(this.f30588f, 16);
            }
            marginLayoutParams.leftMargin = right - iM37666a;
        }
        marginLayoutParams.topMargin = this.f30585d0.getTop() + C6600t0.m37666a(this.f30588f, 8);
        this.f30587e0.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: a */
    private void m37491a(PreviewPicture previewPicture) {
        if (this.f30605n0 != null) {
            try {
                C6550c1.m37264c("WisePlayerImp", "on preview picture notify");
                this.f30605n0.onPreviewPicNotify(this.f30580b, previewPicture);
            } catch (Exception e10) {
                C6550c1.m37258a("WisePlayerImp", "onPreviewPicNotify error:", e10);
            }
        }
    }

    /* renamed from: a */
    private void m37494a(String str) {
        if (this.f30581b0) {
            return;
        }
        C6550c1.m37256a("WisePlayerImp", "create player engine start.");
        if (WisePlayerFactory.f30260d && (C6600t0.m37683c(str) || C6593p0.m37595b(str))) {
            m37489a(this.f30588f);
            this.f30564M.mo37626e(1);
            this.f30564M.mo37622d(1);
            Proxy proxy = this.f30552D;
            if (proxy == null || proxy.getType() != Proxy.Type.SOCKS) {
                C6580j.m37443b(0);
            } else {
                C6580j.m37443b(1);
            }
        } else {
            m37512e();
            this.f30564M.mo37626e(0);
            this.f30564M.mo37622d(0);
            try {
                if (this.f30552D != null) {
                    C6550c1.m37265d("WisePlayerImp", "proxy not support");
                    InterfaceC6567b interfaceC6567b = this.f30551C0;
                    if (interfaceC6567b != null) {
                        interfaceC6567b.mo37405a(this.f30578a, PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY, 0, null);
                    }
                }
            } catch (RemoteException e10) {
                C6550c1.m37258a("WisePlayerImp", "createPlayer ", e10);
            }
        }
        m37534o();
        m37547u();
        C6550c1.m37256a("WisePlayerImp", "create player engine end.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m37495a(String[] strArr) {
        try {
            this.f30578a.mo37191d(this.f30594i + this.f30592h);
            this.f30578a.mo37181a(strArr);
            this.f30578a.mo37167a(this.f30563L);
        } catch (RemoteException e10) {
            C6550c1.m37258a("WisePlayerImp", "reSetPlayUrl:", e10);
        }
        this.f30564M.setPlayUrl(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m37496a(int i10) {
        return (this.f30615s0.get() || !this.f30553D0.contains(Integer.valueOf(i10)) || C6593p0.m37593a(this.f30590g) == EnumC6602u0.DASH || C6593p0.m37593a(this.f30590g) == EnumC6602u0.FLV || (this.f30578a instanceof C6540a)) ? false : true;
    }
}
