package p644t1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p598r1.C12455a;
import p629s1.C12663b;
import p629s1.C12665d;

/* renamed from: t1.a */
/* loaded from: classes.dex */
public class C12913a implements InterfaceC12915c {

    /* renamed from: a */
    public final ExecutorService f58902a = Executors.newFixedThreadPool(1);

    /* renamed from: b */
    public final C12916d f58903b;

    /* renamed from: c */
    public final InterfaceC12914b f58904c;

    /* renamed from: d */
    public final HandlerThread f58905d;

    /* renamed from: e */
    public final d f58906e;

    /* renamed from: t1.a$a */
    public class a implements Runnable {

        /* renamed from: a */
        public String f58907a;

        /* renamed from: b */
        public int f58908b;

        /* renamed from: c */
        public int f58909c;

        /* renamed from: d */
        public int f58910d;

        public a(String str, int i10, int i11, int i12) {
            this.f58907a = str;
            this.f58908b = i10;
            this.f58909c = i11;
            this.f58910d = i12;
        }

        @Override // java.lang.Runnable
        public void run() {
            C12913a.this.f58904c.mo8618a(C12663b.m76216c(this.f58907a, this.f58908b, this.f58909c, this.f58910d));
        }
    }

    /* renamed from: t1.a$b */
    public class b implements Handler.Callback {

        /* renamed from: a */
        public int f58912a;

        public b() {
            this.f58912a = 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            C12916d c12916d;
            StringBuilder sb2;
            d dVar;
            Message messageObtainMessage;
            d dVar2;
            Message messageObtainMessage2;
            C12916d c12916d2;
            int i10;
            d dVar3;
            try {
                C12665d.a.m76242a("Customizable-Player", "msg what:" + message.what + ", arg:" + message.arg1 + ",mStatus:" + C12913a.this.f58903b.m77557e());
                int i11 = message.what;
                if (i11 != 1020) {
                    if (i11 != 1099) {
                        switch (i11) {
                            case 1001:
                                if (C12913a.this.f58903b.f58926m == 0) {
                                    C12913a.this.f58903b.f58915b = SystemClock.elapsedRealtime();
                                }
                                if (C12913a.this.f58903b.f58931r != null && !"".equals(C12913a.this.f58903b.f58931r)) {
                                    C12665d.a.m76242a("Customizable-Player", "mRemainderHEString:" + C12913a.this.f58903b.f58931r);
                                    C12913a.this.f58903b.f58930q = C12913a.this.f58903b.f58921h;
                                    C12913a.this.f58903b.f58926m = C12913a.this.f58903b.f58920g.m74711b(C12913a.this.f58903b.f58921h);
                                    C12913a.this.f58903b.f58928o = C12663b.m76233t(C12913a.this.f58903b.f58914a, C12913a.this.f58903b.f58921h);
                                    C12913a.this.f58903b.f58927n = C12663b.m76228o(C12913a.this.f58903b.f58928o, 2);
                                    C12665d.a.m76242a("Customizable-Player", "MSG_CHECK_NEXT_PATTERN resume paused pattern,  mCurrentPatternIndex:" + C12913a.this.f58903b.f58926m + ",mCurrentPatternString:" + C12913a.this.f58903b.f58928o);
                                    C12913a.this.f58903b.f58931r = null;
                                    dVar = C12913a.this.f58906e;
                                    messageObtainMessage = C12913a.this.f58906e.obtainMessage(1002);
                                    dVar.m77551b(messageObtainMessage, 0, true);
                                    break;
                                } else {
                                    int i12 = C12913a.this.f58903b.f58920g.f57380b.get(C12913a.this.f58903b.f58926m).f57384a - C12913a.this.f58903b.f58930q;
                                    C12913a.this.f58903b.f58930q = C12913a.this.f58903b.f58920g.f57380b.get(C12913a.this.f58903b.f58926m).f57384a;
                                    C12913a.this.f58903b.f58927n = C12913a.this.f58903b.f58920g.f57380b.get(C12913a.this.f58903b.f58926m).m74712a();
                                    C12913a.this.f58903b.f58928o = C12663b.m76220g(C12913a.this.f58903b.f58920g.f57380b.get(C12913a.this.f58903b.f58926m), true);
                                    C12913a.this.f58903b.getClass();
                                    C12665d.a.m76242a("Customizable-Player", "will play pattern after waitTime :" + i12);
                                    C12913a.this.f58906e.m77551b(C12913a.this.f58906e.obtainMessage(1002), i12, true);
                                    break;
                                }
                                break;
                            case 1002:
                                C12665d.a.m76242a("Customizable-Player", "MSG_PLAY_PATTERN mFreq" + C12913a.this.f58903b.f58918e + ",mAmplitude:" + C12913a.this.f58903b.f58917d + "mCurrentPlayingInfo.mCurrentPatternIndex:" + C12913a.this.f58903b.f58926m);
                                if (6 == C12913a.this.f58903b.m77557e()) {
                                    C12913a.this.f58902a.execute(C12913a.this.new a(C12913a.this.f58903b.f58928o + "", C12913a.this.f58903b.f58917d, C12913a.this.f58903b.f58918e, C12913a.this.f58904c.mo8621d()));
                                    if (C12913a.this.f58903b.f58926m + 1 > C12913a.this.f58903b.m77554a() - 1) {
                                        C12916d c12916d3 = C12913a.this.f58903b;
                                        int i13 = c12916d3.f58929p + 1;
                                        c12916d3.f58929p = i13;
                                        if (i13 >= C12913a.this.f58903b.f58916c) {
                                            dVar2 = C12913a.this.f58906e;
                                            messageObtainMessage2 = C12913a.this.f58906e.obtainMessage(PlayerConstants.ErrorCode.UNKNOWN);
                                            c12916d2 = C12913a.this.f58903b;
                                        } else {
                                            dVar2 = C12913a.this.f58906e;
                                            messageObtainMessage2 = C12913a.this.f58906e.obtainMessage(1007);
                                            c12916d2 = C12913a.this.f58903b;
                                        }
                                        i10 = c12916d2.f58927n;
                                        dVar2.m77551b(messageObtainMessage2, i10, true);
                                        break;
                                    } else {
                                        C12913a.this.f58903b.f58926m++;
                                        dVar = C12913a.this.f58906e;
                                        dVar3 = C12913a.this.f58906e;
                                        messageObtainMessage = dVar3.obtainMessage(1001);
                                        dVar.m77551b(messageObtainMessage, 0, true);
                                        break;
                                    }
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append("ignore MSG_PLAY_PATTERN as status:");
                                    sb2.append(C12913a.this.f58903b.m77557e());
                                    C12665d.a.m76242a("Customizable-Player", sb2.toString());
                                    break;
                                }
                            case 1003:
                                C12913a.this.f58904c.stop();
                                break;
                            default:
                                switch (i11) {
                                    case 1005:
                                        this.f58912a = 0;
                                        C12665d.a.m76242a("Customizable-Player", "MSG_START mStartPosition:" + C12913a.this.f58903b.f58921h + ", lastMediaPosition:" + this.f58912a);
                                        if (C12913a.this.f58903b.f58921h >= 0 && C12913a.this.f58903b.f58921h <= C12913a.this.f58903b.f58920g.getDuration()) {
                                            C12665d.a.m76242a("Customizable-Player", "MSG_START will generate remainder and partial pattern!");
                                            C12913a.this.f58903b.f58931r = C12663b.m76226m(C12913a.this.f58903b.f58914a, C12913a.this.f58903b.f58921h);
                                            if (C12913a.this.f58903b.f58931r == null) {
                                                C12665d.a.m76242a("Customizable-Player", "null == mCurrentPlayingInfo.mRemainderHEString");
                                                C12916d c12916d4 = C12913a.this.f58903b;
                                                int i14 = c12916d4.f58929p + 1;
                                                c12916d4.f58929p = i14;
                                                if (i14 >= C12913a.this.f58903b.f58916c) {
                                                    C12665d.a.m76242a("Customizable-Player", "last loop finished!");
                                                    dVar = C12913a.this.f58906e;
                                                    messageObtainMessage = C12913a.this.f58906e.obtainMessage(PlayerConstants.ErrorCode.UNKNOWN);
                                                } else {
                                                    C12913a.this.f58903b.m77555b(6, 0);
                                                    dVar = C12913a.this.f58906e;
                                                    messageObtainMessage = C12913a.this.f58906e.obtainMessage(1007);
                                                }
                                                dVar.m77551b(messageObtainMessage, 0, true);
                                                break;
                                            }
                                        }
                                        C12913a.this.f58903b.f58915b = SystemClock.elapsedRealtime();
                                        C12913a.this.f58903b.m77555b(6, 0);
                                        dVar = C12913a.this.f58906e;
                                        dVar3 = C12913a.this.f58906e;
                                        messageObtainMessage = dVar3.obtainMessage(1001);
                                        dVar.m77551b(messageObtainMessage, 0, true);
                                        break;
                                    case 1006:
                                        C12913a.this.f58903b.getClass();
                                        long jElapsedRealtime = SystemClock.elapsedRealtime() - C12913a.this.f58903b.f58915b;
                                        if (jElapsedRealtime >= 0) {
                                            C12913a.this.f58903b.f58921h = (int) (r1.f58921h + jElapsedRealtime);
                                            C12665d.a.m76242a("Customizable-Player", "MSG_PAUSE mStartPosition:" + C12913a.this.f58903b.f58921h);
                                            C12913a.this.f58903b.m77555b(7, 0);
                                            break;
                                        } else {
                                            C12665d.a.m76243b("Customizable-Player", "pause delta < 0");
                                            C12913a.this.f58903b.f58921h = 0;
                                            C12913a.this.f58903b.m77555b(2, 0);
                                            break;
                                        }
                                    case 1007:
                                        C12913a.this.f58903b.f58921h = 0;
                                        C12913a.this.f58903b.f58926m = 0;
                                        C12913a.this.f58903b.f58930q = 0;
                                        this.f58912a = 0;
                                        dVar2 = C12913a.this.f58906e;
                                        messageObtainMessage2 = C12913a.this.f58906e.obtainMessage(1001);
                                        i10 = C12913a.this.f58903b.f58919f;
                                        dVar2.m77551b(messageObtainMessage2, i10, true);
                                        break;
                                    case FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST /* 1008 */:
                                        C12913a.this.f58903b.f58921h = message.arg1;
                                        this.f58912a = 0;
                                        if (6 == C12913a.this.f58903b.m77557e()) {
                                            C12913a.this.f58906e.m77551b(C12913a.this.f58906e.obtainMessage(1005), 0, true);
                                        } else {
                                            C12665d.a.m76244c("Customizable-Player", "MSG_SEEK status:" + C12913a.this.f58903b.m77557e());
                                        }
                                        c12916d = C12913a.this.f58903b;
                                        c12916d.getClass();
                                        break;
                                }
                        }
                    } else {
                        C12913a.this.f58903b.f58921h = 0;
                        C12913a.this.f58903b.f58926m = 0;
                        C12913a.this.f58903b.f58929p = 0;
                        C12913a.this.f58903b.f58930q = 0;
                        this.f58912a = 0;
                        C12913a.this.f58903b.m77555b(9, 0);
                    }
                } else if (6 != C12913a.this.f58903b.m77557e()) {
                    sb2 = new StringBuilder();
                    sb2.append("ignore MSG_SYNC_WITH_MEDIA as status:");
                    sb2.append(C12913a.this.f58903b.m77557e());
                    C12665d.a.m76242a("Customizable-Player", sb2.toString());
                } else if (C12913a.this.f58903b.f58926m <= C12913a.this.f58903b.m77554a() - 1) {
                    c12916d = C12913a.this.f58903b;
                    c12916d.getClass();
                }
            } catch (Throwable th2) {
                C12665d.a.m76243b("Customizable-Player", "checking it！！！");
                th2.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: t1.a$d */
    public static class d extends Handler {
        public d(Looper looper, Handler.Callback callback) {
            super(looper, callback);
        }

        /* renamed from: a */
        public void m77550a() {
            removeMessages(1005);
            removeMessages(1006);
            removeMessages(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
            removeMessages(PlayerConstants.ErrorCode.UNKNOWN);
            removeMessages(1007);
            removeMessages(1003);
            removeMessages(1001);
            removeMessages(1020);
            removeMessages(1002);
        }

        /* renamed from: b */
        public boolean m77551b(Message message, int i10, boolean z10) {
            if (z10) {
                m77550a();
            }
            return sendMessageDelayed(message, i10);
        }
    }

    public C12913a(InterfaceC12914b interfaceC12914b) {
        C12916d c12916d = new C12916d();
        this.f58903b = c12916d;
        C12665d.a.m76244c("Customizable-Player", "initialize!");
        if (interfaceC12914b == null) {
            C12665d.a.m76243b("Customizable-Player", "CustomizableHapticPlayer() null == performer");
            c12916d.m77555b(2, 0);
        }
        this.f58904c = interfaceC12914b;
        HandlerThread handlerThread = new HandlerThread("Customizable-Player");
        this.f58905d = handlerThread;
        handlerThread.start();
        this.f58906e = new d(handlerThread.getLooper(), new b());
    }

    @Override // p644t1.InterfaceC12915c
    /* renamed from: a */
    public void mo70249a() throws Throwable {
        if (3 != this.f58903b.m77557e() && 8 != this.f58903b.m77557e()) {
            C12665d.a.m76245d("Customizable-Player", "call prepare() in invalid status:" + this.f58903b.m77557e() + ", do nothing!");
            return;
        }
        if (1 == C12663b.m76230q(this.f58903b.f58914a)) {
            C12916d c12916d = this.f58903b;
            c12916d.f58914a = C12663b.m76215b(c12916d.f58914a);
        }
        C12916d c12916d2 = this.f58903b;
        String str = c12916d2.f58914a;
        c12916d2.f58924k = str;
        C12455a c12455aM76229p = C12663b.m76229p(str);
        if (!C12916d.m77553d(c12455aM76229p)) {
            C12665d.a.m76243b("Customizable-Player", "prepare error, invalid HE");
            this.f58903b.m77560h();
            this.f58903b.m77555b(2, 4097);
            return;
        }
        C12916d c12916d3 = this.f58903b;
        c12916d3.f58920g = c12455aM76229p;
        c12916d3.m77559g();
        this.f58904c.mo8620c(this.f58903b.f58925l);
        this.f58904c.mo8619b(HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        this.f58903b.m77555b(5, 0);
        C12665d.m76239a("prepared.he", this.f58903b.f58914a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[PHI: r4
  0x0047: PHI (r4v8 int) = (r4v1 int), (r4v2 int) binds: [B:12:0x0045, B:15:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p644t1.InterfaceC12915c
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo70250b(java.lang.String r3, int r4, int r5, int r6, int r7, p665u1.InterfaceC13109a r8) {
        /*
            r2 = this;
            t1.d r8 = r2.f58903b
            int r8 = r8.m77557e()
            java.lang.String r0 = "Customizable-Player"
            if (r8 == 0) goto L2a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "setDataSource in invalid status:"
            r3.append(r4)
            t1.d r2 = r2.f58903b
            int r2 = r2.m77557e()
            r3.append(r2)
            java.lang.String r2 = ",do nothing!"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            p629s1.C12665d.a.m76245d(r0, r2)
            return
        L2a:
            t1.d r8 = r2.f58903b
            r8.m77560h()
            t1.d r8 = r2.f58903b
            r8.f58914a = r3
            r8.f58917d = r4
            r8.f58918e = r5
            r3 = 0
            r1 = 511(0x1ff, float:7.16E-43)
            if (r4 <= r1) goto L3f
            r8.f58917d = r1
            goto L43
        L3f:
            if (r4 >= 0) goto L43
            r8.f58917d = r3
        L43:
            r4 = 100
            if (r5 <= r4) goto L4a
        L47:
            r8.f58918e = r4
            goto L4f
        L4a:
            r4 = -100
            if (r5 >= r4) goto L4f
            goto L47
        L4f:
            if (r6 < 0) goto L55
            int r4 = r6 + 1
            r8.f58916c = r4
        L55:
            r4 = -1
            if (r4 != r6) goto L5d
            r4 = 2147483647(0x7fffffff, float:NaN)
            r8.f58916c = r4
        L5d:
            if (r7 < 0) goto L61
            r8.f58919f = r7
        L61:
            java.lang.String r4 = "will change to initialized!"
            p629s1.C12665d.a.m76242a(r0, r4)
            t1.d r2 = r2.f58903b
            r4 = 3
            r2.m77555b(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p644t1.C12913a.mo70250b(java.lang.String, int, int, int, int, u1.a):void");
    }

    @Override // p644t1.InterfaceC12915c
    public boolean isPlaying() {
        return 6 == this.f58903b.m77557e();
    }

    @Override // p644t1.InterfaceC12915c
    public void release() {
        C12665d.a.m76244c("Customizable-Player", " released!");
        if (isPlaying()) {
            d dVar = this.f58906e;
            dVar.m77551b(dVar.obtainMessage(1003), 0, true);
        }
        this.f58903b.m77560h();
        this.f58903b.m77555b(1, 0);
        HandlerThread handlerThread = this.f58905d;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        ExecutorService executorService = this.f58902a;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // p644t1.InterfaceC12915c
    public void reset() {
        if (isPlaying()) {
            d dVar = this.f58906e;
            dVar.m77551b(dVar.obtainMessage(1003), 0, true);
        }
        this.f58903b.m77560h();
        this.f58903b.m77555b(0, 0);
    }

    @Override // p644t1.InterfaceC12915c
    public void start() {
        if (5 != this.f58903b.m77557e() && 7 != this.f58903b.m77557e() && 9 != this.f58903b.m77557e()) {
            C12665d.a.m76245d("Customizable-Player", "call start() in invalid status:" + this.f58903b.m77557e() + ", do nothing!");
            return;
        }
        C12665d.a.m76242a("Customizable-Player", "  start() in, mCurrentHePausePosition:" + this.f58903b.f58921h);
        if (9 == this.f58903b.m77557e()) {
            C12665d.a.m76242a("Customizable-Player", "  start() return, already COMPLETED, start from 0");
            this.f58903b.f58921h = 0;
        }
        d dVar = this.f58906e;
        dVar.m77551b(dVar.obtainMessage(1005), 0, true);
        this.f58903b.m77555b(6, 0);
    }

    @Override // p644t1.InterfaceC12915c
    public void stop() {
        if (6 == this.f58903b.m77557e() || 7 == this.f58903b.m77557e() || 9 == this.f58903b.m77557e()) {
            d dVar = this.f58906e;
            dVar.m77551b(dVar.obtainMessage(1003), 0, true);
            this.f58903b.m77560h();
            this.f58903b.m77555b(8, 0);
            return;
        }
        C12665d.a.m76245d("Customizable-Player", "call stop() in invalid status:" + this.f58903b.m77557e() + ", do nothing!");
    }
}
