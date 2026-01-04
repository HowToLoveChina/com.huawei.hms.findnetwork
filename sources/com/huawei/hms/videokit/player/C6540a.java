package com.huawei.hms.videokit.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
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
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.secure.android.common.util.SafeString;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.huawei.hms.videokit.player.a */
/* loaded from: classes8.dex */
class C6540a implements InterfaceC6571f {

    /* renamed from: x */
    private static final Map<Integer, Integer> f30273x = new a();

    /* renamed from: y */
    private static final Map<Integer, Integer> f30274y = new b();

    /* renamed from: j */
    private boolean f30284j;

    /* renamed from: k */
    private boolean f30285k;

    /* renamed from: l */
    private boolean f30286l;

    /* renamed from: m */
    private MediaPlayer f30287m;

    /* renamed from: o */
    private InterfaceC6566a f30289o;

    /* renamed from: p */
    private InterfaceC6573h f30290p;

    /* renamed from: q */
    private InterfaceC6570e f30291q;

    /* renamed from: r */
    private InterfaceC6568c f30292r;

    /* renamed from: s */
    private InterfaceC6574i f30293s;

    /* renamed from: t */
    private InterfaceC6575j f30294t;

    /* renamed from: u */
    private InterfaceC6567b f30295u;

    /* renamed from: w */
    private c f30297w;

    /* renamed from: a */
    private int f30275a = 0;

    /* renamed from: b */
    private boolean f30276b = false;

    /* renamed from: c */
    private int f30277c = -1;

    /* renamed from: d */
    private int f30278d = -1;

    /* renamed from: e */
    private boolean f30279e = false;

    /* renamed from: f */
    private float f30280f = 1.0f;

    /* renamed from: g */
    private int f30281g = 0;

    /* renamed from: h */
    private boolean f30282h = false;

    /* renamed from: i */
    public Surface f30283i = null;

    /* renamed from: n */
    private d f30288n = new d(this, null);

    /* renamed from: v */
    private AtomicBoolean f30296v = new AtomicBoolean(true);

    /* renamed from: com.huawei.hms.videokit.player.a$a */
    public class a extends HashMap<Integer, Integer> {
        public a() {
            put(-1004, 1201);
            put(-1007, 1003);
            put(200, 1002);
            put(-1010, 1002);
            put(-110, 1202);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.a$b */
    public class b extends HashMap<Integer, Integer> {
        public b() {
            put(Integer.valueOf(ErrorCode.ERROR_PLACEMENT_INVALID_PARAM), 201);
            put(805, 202);
            put(800, 203);
            put(Integer.valueOf(ErrorCode.ERROR_PLACEMENT_AD_LOADING), 206);
            put(3, Integer.valueOf(PlayerConstants.EventCode.VIDEO_FIRST_FRAME));
            put(Integer.valueOf(ErrorCode.ERROR_NATIVE_AD_NO), Integer.valueOf(PlayerConstants.EventCode.VIDEO_DECODE_LAGGING));
            put(Integer.valueOf(ErrorCode.ERROR_PLACEMENT_EMPTY_AD_IDS), Integer.valueOf(PlayerConstants.EventCode.MEDIA_INFO_METADATA_UPDATE));
            put(901, 210);
            put(902, 211);
            put(1, 212);
            put(2, 212);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.a$c */
    public static class c extends Handler {

        /* renamed from: a */
        private final WeakReference<C6540a> f30298a;

        public c(C6540a c6540a) {
            super(Looper.getMainLooper());
            this.f30298a = new WeakReference<>(c6540a);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            super.handleMessage(message);
            if (message.what != 0) {
                str = "handler do not process messages";
            } else {
                C6540a c6540a = this.f30298a.get();
                if (c6540a != null) {
                    c6540a.m37159j();
                    return;
                }
                str = "WeakReference: MediaPlayer object is empty";
            }
            C6550c1.m37264c("AndroidMediaPlayer", str);
        }
    }

    /* renamed from: com.huawei.hms.videokit.player.a$d */
    public class d implements MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener {
        private d() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            if (C6540a.this.f30277c == 0) {
                C6540a.this.f30281g = (i10 * mediaPlayer.getDuration()) / 100;
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            C6550c1.m37264c("AndroidMediaPlayer", "onCompletion");
            C6540a.this.f30276b = true;
            if (C6540a.this.f30297w == null) {
                C6540a.this.f30297w = new c(C6540a.this);
            }
            C6540a.this.f30297w.sendEmptyMessage(0);
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            int iIntValue;
            C6550c1.m37264c("AndroidMediaPlayer", "onError what:" + i10 + " extra:" + i11);
            if (!C6540a.this.f30296v.get()) {
                C6550c1.m37264c("AndroidMediaPlayer", "It has been reported, so it is not necessary to report again");
                return true;
            }
            C6540a.this.f30277c = 1;
            if (C6540a.this.f30289o != null) {
                if (i10 == 100) {
                    iIntValue = 1000;
                } else {
                    try {
                        iIntValue = C6540a.f30273x.containsKey(Integer.valueOf(i11)) ? ((Integer) C6540a.f30273x.get(Integer.valueOf(i11))).intValue() : PlayerConstants.ErrorCode.UNKNOWN;
                    } catch (RemoteException e10) {
                        C6550c1.m37258a("AndroidMediaPlayer", "onError:", e10);
                    }
                }
                C6540a.this.f30289o.mo37404a(C6540a.this, iIntValue, i11, "");
                C6540a.this.f30296v.set(false);
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            InterfaceC6567b interfaceC6567b;
            C6540a c6540a;
            Integer num;
            C6550c1.m37264c("AndroidMediaPlayer", "onInfo:" + i10 + " extra:" + i11);
            try {
                if (i10 != 3) {
                    if (i10 == 701) {
                        C6540a.this.f30284j = true;
                        if (C6540a.this.f30292r != null) {
                            C6540a.this.f30292r.mo37407a(C6540a.this, 0);
                        }
                    } else if (i10 == 702) {
                        C6540a.this.f30284j = false;
                        if (C6540a.this.f30292r != null) {
                            C6540a.this.f30292r.mo37407a(C6540a.this, 100);
                        }
                        if (C6540a.this.f30292r != null && C6540a.this.f30285k) {
                            C6540a.this.f30292r.mo37406a(C6540a.this);
                        }
                    } else if (C6540a.this.f30295u != null) {
                        if (C6540a.f30274y.containsKey(Integer.valueOf(i10))) {
                            interfaceC6567b = C6540a.this.f30295u;
                            c6540a = C6540a.this;
                            num = (Integer) C6540a.f30274y.get(Integer.valueOf(i10));
                            interfaceC6567b.mo37405a(c6540a, num.intValue(), i11, null);
                        } else {
                            C6550c1.m37264c("AndroidMediaPlayer", "ignore info code is :" + i10);
                        }
                    }
                } else if (C6540a.this.f30295u != null) {
                    interfaceC6567b = C6540a.this.f30295u;
                    c6540a = C6540a.this;
                    num = (Integer) C6540a.f30274y.get(Integer.valueOf(i10));
                    interfaceC6567b.mo37405a(c6540a, num.intValue(), i11, null);
                }
            } catch (RemoteException e10) {
                C6550c1.m37258a("AndroidMediaPlayer", "onInfo:", e10);
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[Catch: RemoteException -> 0x006a, TryCatch #2 {RemoteException -> 0x006a, blocks: (B:18:0x0054, B:20:0x005c, B:23:0x006c, B:25:0x0074, B:27:0x007c, B:28:0x0082, B:30:0x008a), top: B:34:0x0054 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[Catch: RemoteException -> 0x006a, TryCatch #2 {RemoteException -> 0x006a, blocks: (B:18:0x0054, B:20:0x005c, B:23:0x006c, B:25:0x0074, B:27:0x007c, B:28:0x0082, B:30:0x008a), top: B:34:0x0054 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[Catch: RemoteException -> 0x006a, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x006a, blocks: (B:18:0x0054, B:20:0x005c, B:23:0x006c, B:25:0x0074, B:27:0x007c, B:28:0x0082, B:30:0x008a), top: B:34:0x0054 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPrepared(android.media.MediaPlayer r5) throws java.lang.IllegalStateException {
            /*
                r4 = this;
                java.lang.String r0 = "onPrepared"
                java.lang.String r1 = "AndroidMediaPlayer"
                com.huawei.hms.videokit.player.C6550c1.m37264c(r1, r0)
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this
                r2 = 0
                com.huawei.hms.videokit.player.C6540a.m37140b(r0, r2)
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                int r0 = com.huawei.hms.videokit.player.C6540a.m37148e(r0)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                r3 = -1
                if (r0 == r3) goto L54
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                boolean r0 = com.huawei.hms.videokit.player.C6540a.m37151f(r0)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                if (r0 == 0) goto L28
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                com.huawei.hms.videokit.player.C6540a.m37139a(r0, r2)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                goto L2e
            L24:
                r5 = move-exception
                goto L3d
            L26:
                r5 = move-exception
                goto L4a
            L28:
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                r2 = 1
                com.huawei.hms.videokit.player.C6540a.m37139a(r0, r2)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
            L2e:
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                int r0 = com.huawei.hms.videokit.player.C6540a.m37148e(r0)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                r5.seekTo(r0)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                com.huawei.hms.videokit.player.C6540a.m37135a(r5, r3)     // Catch: java.lang.IllegalArgumentException -> L24 java.lang.IllegalStateException -> L26
                goto L54
            L3d:
                java.lang.String r0 = "seekTo caused IllegalArgumentException:"
                com.huawei.hms.videokit.player.C6550c1.m37258a(r1, r0, r5)
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this
                java.lang.String r0 = "seekTo caused illegal argument exception"
            L46:
                com.huawei.hms.videokit.player.C6540a.m37138a(r5, r0)
                goto L54
            L4a:
                java.lang.String r0 = "seekTo caused IllegalStateException:"
                com.huawei.hms.videokit.player.C6550c1.m37258a(r1, r0, r5)
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this
                java.lang.String r0 = "seekTo caused illegal state exception"
                goto L46
            L54:
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                com.huawei.hms.videokit.player.internal.c r5 = com.huawei.hms.videokit.player.C6540a.m37141b(r5)     // Catch: android.os.RemoteException -> L6a
                if (r5 == 0) goto L6c
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                com.huawei.hms.videokit.player.internal.c r5 = com.huawei.hms.videokit.player.C6540a.m37141b(r5)     // Catch: android.os.RemoteException -> L6a
                com.huawei.hms.videokit.player.a r0 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                r2 = 100
                r5.mo37407a(r0, r2)     // Catch: android.os.RemoteException -> L6a
                goto L6c
            L6a:
                r4 = move-exception
                goto L96
            L6c:
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                boolean r5 = com.huawei.hms.videokit.player.C6540a.m37151f(r5)     // Catch: android.os.RemoteException -> L6a
                if (r5 == 0) goto L82
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                boolean r5 = com.huawei.hms.videokit.player.C6540a.m37145c(r5)     // Catch: android.os.RemoteException -> L6a
                if (r5 == 0) goto L82
                com.huawei.hms.videokit.player.a r4 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                r4.start()     // Catch: android.os.RemoteException -> L6a
                goto L9b
            L82:
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                com.huawei.hms.videokit.player.internal.h r5 = com.huawei.hms.videokit.player.C6540a.m37154h(r5)     // Catch: android.os.RemoteException -> L6a
                if (r5 == 0) goto L9b
                com.huawei.hms.videokit.player.a r5 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                com.huawei.hms.videokit.player.internal.h r5 = com.huawei.hms.videokit.player.C6540a.m37154h(r5)     // Catch: android.os.RemoteException -> L6a
                com.huawei.hms.videokit.player.a r4 = com.huawei.hms.videokit.player.C6540a.this     // Catch: android.os.RemoteException -> L6a
                r5.mo37418b(r4)     // Catch: android.os.RemoteException -> L6a
                goto L9b
            L96:
                java.lang.String r5 = "onPrepared:"
                com.huawei.hms.videokit.player.C6550c1.m37258a(r1, r5, r4)
            L9b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6540a.d.onPrepared(android.media.MediaPlayer):void");
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                if (!C6540a.this.f30286l) {
                    C6550c1.m37256a("AndroidMediaPlayer", "The onSeekComplete() does not need to be reported");
                    return;
                }
                C6550c1.m37264c("AndroidMediaPlayer", "onSeekComplete");
                if (C6540a.this.f30294t != null) {
                    C6540a.this.f30294t.mo37420d(C6540a.this);
                }
                if (C6540a.this.f30292r == null || !C6540a.this.f30285k) {
                    return;
                }
                C6540a.this.f30292r.mo37406a(C6540a.this);
            } catch (RemoteException e10) {
                C6550c1.m37258a("AndroidMediaPlayer", "onSeekComplete:", e10);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            C6550c1.m37264c("AndroidMediaPlayer", "onVideoSizeChanged");
            try {
                if (C6540a.this.f30293s != null) {
                    C6540a.this.f30293s.mo37419a(C6540a.this, i10, i11);
                }
            } catch (RemoteException e10) {
                C6550c1.m37258a("AndroidMediaPlayer", "onVideoSizeChanged:", e10);
            }
        }

        public /* synthetic */ d(C6540a c6540a, a aVar) {
            this();
        }
    }

    public C6540a() {
        C6550c1.m37264c("AndroidMediaPlayer", "Android mediaPlayer create");
        this.f30287m = new MediaPlayer();
        this.f30297w = new c(this);
        m37161k();
    }

    /* renamed from: a */
    private float m37134a(float f10) {
        if (f10 > 1.0d) {
            return 1.0f;
        }
        if (f10 < 0.0f) {
            return 0.0f;
        }
        return f10;
    }

    /* renamed from: f */
    private void m37150f(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str2;
        try {
            this.f30287m.setDataSource(SafeString.replace(str, " ", "%20"));
        } catch (IOException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayUrl: IOException ", e10);
            str2 = "setPlayUrl caused IO exception";
            m37142b(PlayerConstants.ErrorCode.URL_ERROR, str2);
        } catch (IllegalArgumentException e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayUrl: IllegalArgumentException ", e11);
            str2 = "setPlayUrl caused illegal argument exception";
            m37142b(PlayerConstants.ErrorCode.URL_ERROR, str2);
        } catch (IllegalStateException e12) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayUrl: IllegalStateException ", e12);
            str2 = "setPlayUrl caused illegal state exception";
            m37142b(PlayerConstants.ErrorCode.URL_ERROR, str2);
        } catch (SecurityException e13) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayUrl: SecurityException ", e13);
            str2 = "setPlayUrl caused security exception";
            m37142b(PlayerConstants.ErrorCode.URL_ERROR, str2);
        } catch (Exception e14) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayUrl: UndefinedException ", e14);
            str2 = "setPlayUrl caused undefined exception";
            m37142b(PlayerConstants.ErrorCode.URL_ERROR, str2);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public int mo37185c() throws RemoteException {
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void closeLogo() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "closeLogo");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void deselectSubtitleTrack() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "deselectSubtitleTrack");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public AudioTrackInfo[] getAudioTracks() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getAudioTracks");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getBufferTime() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getBufferTime :" + this.f30281g);
        return this.f30281g;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public long getBufferingSpeed() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getBufferingSpeed");
        return 0L;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public StreamInfo getCurrentStreamInfo() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getCurrentStreamInfo");
        StreamInfo streamInfo = new StreamInfo();
        streamInfo.setVideoHeight(getVideoHeight());
        streamInfo.setVideoWidth(getVideoWidth());
        return streamInfo;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getCurrentTime() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getCurrentTime");
        if (this.f30277c != 0) {
            return 0;
        }
        try {
            return this.f30287m.getCurrentPosition();
        } catch (Exception e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "getCurrentTime caused Exception:", e10);
            return 0;
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getDuration() throws RemoteException {
        if (this.f30277c != 0) {
            return 0;
        }
        C6550c1.m37256a("AndroidMediaPlayer", "getDuration");
        try {
            return this.f30287m.getDuration();
        } catch (Exception e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "getDuration caused Exception:", e10);
            return 0;
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getPlayMode() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getPlayMode");
        return this.f30275a;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public float getPlaySpeed() throws RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "getPlaySpeed");
        try {
            if (m37157i()) {
                C6550c1.m37256a("AndroidMediaPlayer", "getPlaySpeed = " + this.f30287m.getPlaybackParams().getSpeed());
                return this.f30287m.getPlaybackParams().getSpeed();
            }
        } catch (IllegalStateException e10) {
            e = e10;
            str = "getPlaySpeed caused IllegalStateException:";
            C6550c1.m37258a("AndroidMediaPlayer", str, e);
            this.m37149e("getPlaySpeed caused illegal argument exception");
            C6550c1.m37265d("AndroidMediaPlayer", " current android sdk unsupport getPlaybackParams ");
            return 1.0f;
        } catch (Exception e11) {
            e = e11;
            str = "getPlaySpeed caused Exception:";
            C6550c1.m37258a("AndroidMediaPlayer", str, e);
            this.m37149e("getPlaySpeed caused illegal argument exception");
            C6550c1.m37265d("AndroidMediaPlayer", " current android sdk unsupport getPlaybackParams ");
            return 1.0f;
        }
        C6550c1.m37265d("AndroidMediaPlayer", " current android sdk unsupport getPlaybackParams ");
        return 1.0f;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public AudioTrackInfo getSelectedAudioTrack() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getSelectedAudioTrack");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public SubtitleTrackInfo getSelectedSubtitleTrack() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getSelectedSubtitleTrack");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public SubtitleTrackInfo[] getSubtitleTracks() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getSubtitleTracks");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getVideoHeight() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getVideoHeight");
        int i10 = this.f30277c;
        if (i10 == 1 || i10 == 2) {
            return 0;
        }
        try {
            return this.f30287m.getVideoHeight();
        } catch (Exception e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "getVideoHeight caused Exception:", e10);
            return 0;
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public VideoInfo getVideoInfo() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getVideoInfo");
        VideoInfo videoInfo = new VideoInfo();
        ArrayList arrayList = new ArrayList();
        StreamInfo streamInfo = new StreamInfo();
        streamInfo.setVideoHeight(getVideoHeight());
        streamInfo.setVideoWidth(getVideoWidth());
        arrayList.add(streamInfo);
        videoInfo.setStreamInfos(arrayList);
        videoInfo.setDuration(getDuration());
        return videoInfo;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getVideoWidth() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "getVideoWidth");
        int i10 = this.f30277c;
        if (i10 == 1 || i10 == 2) {
            return 0;
        }
        try {
            return this.f30287m.getVideoWidth();
        } catch (Exception e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "getVideoWidth caused Exception:", e10);
            return 0;
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public boolean isPlaying() throws RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "isPlaying");
        try {
            if (this.f30277c != 1) {
                return this.f30287m.isPlaying();
            }
            return false;
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "isPlaying caused IllegalStateException:", e10);
            str = "isPlaying caused illegal state exception";
            this.m37149e(str);
            return false;
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "isPlaying caused Exception:", e11);
            str = "isPlaying caused Exception";
            this.m37149e(str);
            return false;
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void pause() throws IllegalStateException, RemoteException {
        String str;
        C6550c1.m37264c("AndroidMediaPlayer", VastAttribute.PAUSE);
        try {
            this.f30287m.pause();
            this.f30282h = true;
            this.f30285k = false;
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "pause caused IllegalStateException:", e10);
            str = "pause caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "pause caused Exception:", e11);
            str = "pause caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void presetAudioLanguage(String str) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "presetAudioLanguage");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void presetSubtitleLanguage(String str) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "presetSubtitleLanguage language:" + str);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void ready() throws IllegalStateException, RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "ready");
        try {
            this.f30287m.prepareAsync();
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "ready caused IllegalStateException:", e10);
            str = "ready caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "ready caused Exception:", e11);
            str = "ready caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void refreshPlayUrl(String str) throws RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "refreshPlayUrl");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void release() throws RemoteException {
        String str;
        C6550c1.m37264c("AndroidMediaPlayer", "release");
        try {
            this.f30296v.set(true);
            this.f30276b = false;
            this.f30277c = -1;
            this.f30281g = 0;
            this.f30280f = 1.0f;
            this.f30287m.release();
            c cVar = this.f30297w;
            if (cVar != null) {
                cVar.removeCallbacksAndMessages(null);
                this.f30297w = null;
            }
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "release caused IllegalStateException:", e10);
            str = "release caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "release caused Exception:", e11);
            str = "release caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void reset() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "reset");
        try {
            this.f30296v.set(true);
            this.f30276b = false;
            this.f30285k = false;
            this.f30277c = 2;
            this.f30281g = 0;
            this.f30280f = 1.0f;
            this.f30287m.reset();
        } catch (Exception e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "reset caused Exception:", e10);
            m37149e("reset caused Exception");
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void resume(int i10) throws IllegalStateException, RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "resume");
        if (this.f30277c != 0) {
            C6550c1.m37264c("AndroidMediaPlayer", "resume: play error");
            return;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                return;
            }
        } else if (this.f30282h) {
            return;
        }
        m37163l();
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void seek(int i10) throws IllegalStateException, RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "seekTo time:" + i10 + ", status :" + this.f30277c);
        if (this.f30276b) {
            this.f30276b = false;
        }
        try {
            if (this.f30277c != 0) {
                this.f30278d = i10;
            } else {
                this.f30286l = true;
                this.f30287m.seekTo(i10);
            }
        } catch (IllegalArgumentException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "seek caused IllegalArgumentException:", e10);
            str = "seek caused illegal argument exception";
            m37149e(str);
        } catch (IllegalStateException e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "seek caused IllegalStateException:", e11);
            str = "seek caused illegal state exception";
            m37149e(str);
        } catch (Exception e12) {
            C6550c1.m37258a("AndroidMediaPlayer", "seek caused Exception:", e12);
            str = "seek caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void selectAudioTrack(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "selectAudioTrack");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void selectSubtitleTrack(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "selectSubtitleTrack id:" + i10);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int setBandwidthSwitchMode(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setBandwidthSwitchMode");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setBitrateRange(int i10, int i11) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setBitrateRange");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setBookmark(int i10) throws IllegalStateException, RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setBookmark");
        seek(i10);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setBufferingStatus(boolean z10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setBufferingStatus");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setCycleMode(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setCycleMode");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setInitBitrate(InitBitrateParam initBitrateParam) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setInitBitrate");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setMute(boolean z10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setMute");
        setVolume(z10 ? 0.0f : this.f30280f);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setPlayMode(int i10) throws RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "playMode:" + i10);
        try {
            this.f30275a = i10;
            if (i10 == 0) {
                Surface surface = this.f30283i;
                if (surface != null) {
                    this.f30287m.setSurface(surface);
                    this.f30287m.setScreenOnWhilePlaying(true);
                }
            } else {
                this.f30287m.setSurface(null);
            }
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayMode caused IllegalStateException:", e10);
            str = "setPlayMode caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlayMode caused Exception:", e11);
            str = "setPlayMode caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setPlaySpeed(float f10) throws RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "setPlaySpeed");
        try {
            if (m37157i()) {
                PlaybackParams playbackParams = new PlaybackParams();
                playbackParams.allowDefaults();
                playbackParams.setSpeed(f10);
                this.f30287m.setPlaybackParams(playbackParams);
            } else {
                C6550c1.m37265d("AndroidMediaPlayer", " current android sdk unsupport setPlaybackParams ");
            }
        } catch (IllegalArgumentException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlaySpeed caused IllegalArgumentException:", e10);
            str = "setPlaySpeed caused illegal argument exception";
            m37149e(str);
        } catch (IllegalStateException e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlaySpeed caused IllegalStateException:", e11);
            str = "setPlaySpeed caused illegal state exception";
            m37149e(str);
        } catch (Exception e12) {
            C6550c1.m37258a("AndroidMediaPlayer", "setPlaySpeed caused Exception:", e12);
            str = "setPlaySpeed caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setSurfaceChange() throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setSurfaceChange");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setVideoType(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setVideoType");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setVolume(float f10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setVolume");
        if (this.f30277c == 1) {
            C6550c1.m37256a("AndroidMediaPlayer", "play error, can not set volume");
            return;
        }
        if (f10 != 0.0f) {
            try {
                this.f30280f = f10;
            } catch (Exception e10) {
                C6550c1.m37258a("AndroidMediaPlayer", "setVolume caused Exception:", e10);
                return;
            }
        }
        this.f30287m.setVolume(m37134a(f10), m37134a(f10));
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void start() throws IllegalStateException, RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "start");
        if (this.f30276b) {
            seek(0);
        }
        this.f30282h = false;
        m37163l();
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void stop() throws IllegalStateException, RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "stop");
        try {
            this.f30287m.stop();
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "stop caused IllegalStateException:", e10);
            str = "stop caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "stop caused Exception:", e11);
            str = "stop caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void suspend() throws IllegalStateException, RemoteException {
        String str;
        C6550c1.m37264c("AndroidMediaPlayer", "suspend");
        try {
            if (this.f30277c == 1 || !isPlaying()) {
                return;
            }
            this.f30287m.pause();
            this.f30285k = false;
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "suspend caused IllegalStateException:", e10);
            str = "suspend caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "suspend caused Exception:", e11);
            str = "suspend caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void switchBitrateDesignated(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "switchBitrateDesignated");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void switchBitrateSmooth(int i10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "switchBitrateSmooth");
    }

    /* renamed from: i */
    private boolean m37157i() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m37159j() {
        InterfaceC6570e interfaceC6570e = this.f30291q;
        if (interfaceC6570e != null) {
            try {
                interfaceC6570e.mo37410c(this);
            } catch (RemoteException e10) {
                C6550c1.m37258a("AndroidMediaPlayer", "onCompletion:", e10);
            }
        }
    }

    /* renamed from: k */
    private void m37161k() {
        this.f30287m.setOnBufferingUpdateListener(this.f30288n);
        this.f30287m.setOnPreparedListener(this.f30288n);
        this.f30287m.setOnCompletionListener(this.f30288n);
        this.f30287m.setOnSeekCompleteListener(this.f30288n);
        this.f30287m.setOnInfoListener(this.f30288n);
        this.f30287m.setOnErrorListener(this.f30288n);
        this.f30287m.setOnVideoSizeChangedListener(this.f30288n);
    }

    /* renamed from: l */
    private void m37163l() throws IllegalStateException {
        String str;
        try {
            this.f30287m.start();
            this.f30285k = true;
            InterfaceC6568c interfaceC6568c = this.f30292r;
            if (interfaceC6568c == null || this.f30284j) {
                return;
            }
            interfaceC6568c.mo37406a(this);
        } catch (RemoteException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "start play error:", e10);
        } catch (IllegalStateException e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "start caused IllegalStateException:", e11);
            str = "start caused illegal state exception";
            m37149e(str);
        } catch (Exception e12) {
            C6550c1.m37258a("AndroidMediaPlayer", "start caused Exception:", e12);
            str = "start caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: d */
    public void mo37190d(int i10) throws RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "setCloseIPV6");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: e */
    public void mo37192e(int i10) throws RemoteException {
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "precise seekTo time:" + i10 + ", status :" + this.f30277c);
        if (this.f30276b) {
            this.f30276b = false;
        }
        try {
            if (this.f30277c != 0) {
                this.f30278d = i10;
            } else {
                this.f30286l = true;
                this.f30287m.seekTo(i10, 3);
            }
        } catch (IllegalArgumentException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "seek caused IllegalArgumentException:", e10);
            str = "seek caused illegal argument exception";
            m37149e(str);
        } catch (IllegalStateException e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "seek caused IllegalStateException:", e11);
            str = "seek caused illegal state exception";
            m37149e(str);
        } catch (Exception e12) {
            C6550c1.m37258a("AndroidMediaPlayer", "seek caused Exception:", e12);
            str = "seek caused Exception";
            m37149e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m37149e(String str) {
        m37142b(PlayerConstants.ErrorCode.UNKNOWN, str);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public long mo37166a() throws RemoteException {
        return 0L;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: b */
    public String mo37182b() throws RemoteException {
        return "";
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public IObjectWrapper mo37186c(int i10) throws RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "getProperties");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: d */
    public void mo37191d(String str) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setVodInfo");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: b */
    public void mo37183b(int i10) throws RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "setDeviceType");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public void mo37187c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Surface surface;
        String str;
        C6550c1.m37256a("AndroidMediaPlayer", "setView");
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (view instanceof SurfaceView) {
            this.f30283i = ((SurfaceView) view).getHolder().getSurface();
        } else if (view instanceof TextureView) {
            this.f30283i = new Surface(((TextureView) view).getSurfaceTexture());
        } else {
            C6550c1.m37264c("AndroidMediaPlayer", "setView is not SurfaceView or TextureView");
        }
        if (this.f30275a != 0 || (surface = this.f30283i) == null) {
            return;
        }
        try {
            this.f30287m.setSurface(surface);
        } catch (IllegalStateException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "setView caused IllegalStateException:", e10);
            str = "setView caused illegal state exception";
            m37149e(str);
        } catch (Exception e11) {
            C6550c1.m37258a("AndroidMediaPlayer", "setView caused Exception:", e11);
            str = "setView caused Exception";
            m37149e(str);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: e */
    public void mo37193e(boolean z10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setSingleLinkDownload");
    }

    /* renamed from: b */
    private void m37142b(int i10, String str) {
        try {
            if (!this.f30296v.get()) {
                C6550c1.m37264c("AndroidMediaPlayer", "It has been reported, so it is not necessary to report again");
                return;
            }
            InterfaceC6566a interfaceC6566a = this.f30289o;
            if (interfaceC6566a != null) {
                interfaceC6566a.mo37404a(this, i10, 0, str);
            }
            this.f30296v.set(false);
        } catch (RemoteException e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "report Error:", e10);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37167a(int i10) throws RemoteException {
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public void mo37188c(String str) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "media player setInitBufferTimeStrategy");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37168a(IObjectWrapper iObjectWrapper, int i10) throws RemoteException {
        try {
            C6550c1.m37256a("AndroidMediaPlayer", "setWakeMode : " + i10);
            this.f30287m.setWakeMode((Context) ObjectWrapper.unwrap(iObjectWrapper), i10);
        } catch (Exception e10) {
            C6550c1.m37258a("AndroidMediaPlayer", "setWakeMode error: ", e10);
        }
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: b */
    public void mo37184b(boolean z10) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setSwitchEnable");
        this.f30279e = z10;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public void mo37189c(boolean z10) throws RemoteException {
        C6550c1.m37264c("AndroidMediaPlayer", "setPreciseSeeking");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37169a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "create");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37170a(InterfaceC6566a interfaceC6566a) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setErrorListener");
        this.f30289o = interfaceC6566a;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37171a(InterfaceC6567b interfaceC6567b) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setEventListener");
        this.f30295u = interfaceC6567b;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37172a(InterfaceC6568c interfaceC6568c) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setLoadingListener");
        this.f30292r = interfaceC6568c;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37173a(InterfaceC6570e interfaceC6570e) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setPlayEndListener");
        this.f30291q = interfaceC6570e;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37174a(InterfaceC6573h interfaceC6573h) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setReadyListener");
        this.f30290p = interfaceC6573h;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37175a(InterfaceC6574i interfaceC6574i) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setResolutionUpdatedListener");
        this.f30293s = interfaceC6574i;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37176a(InterfaceC6575j interfaceC6575j) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setSeekEndListener");
        this.f30294t = interfaceC6575j;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37177a(InterfaceC6577l interfaceC6577l) throws RemoteException {
        C6550c1.m37256a("AndroidMediaPlayer", "setSubtitleUpdateListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37178a(String str) throws IllegalStateException, IOException, SecurityException, RemoteException, IllegalArgumentException {
        C6550c1.m37256a("AndroidMediaPlayer", "setMediaUrl");
        m37150f(str);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37179a(String str, String str2, String str3, String str4) throws RemoteException {
        InterfaceC6567b interfaceC6567b;
        C6550c1.m37256a("AndroidMediaPlayer", "setProxy");
        if (str.isEmpty() || str2.isEmpty() || (interfaceC6567b = this.f30295u) == null) {
            return;
        }
        interfaceC6567b.mo37405a(this, PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY, 0, null);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37180a(boolean z10) throws RemoteException {
        this.f30285k = z10;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37181a(String[] strArr) throws IllegalStateException, IOException, SecurityException, RemoteException, IllegalArgumentException {
        C6550c1.m37256a("AndroidMediaPlayer", "setMediaUrlArray");
        m37150f(strArr[0]);
    }
}
