package p546p6;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.cloudphoto.model.Lock;
import java.io.IOException;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p429kk.C11058a;
import p429kk.C11060c;
import p709vj.C13452e;
import p746wn.C13622a;
import p764x6.C13717i;

/* renamed from: p6.q */
/* loaded from: classes2.dex */
public class C12104q {

    /* renamed from: a */
    public String f56125a;

    /* renamed from: b */
    public Handler f56126b;

    /* renamed from: c */
    public HandlerThread f56127c;

    /* renamed from: p6.q$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String strM6755Z0 = C1122c.m6755Z0("04001");
            if (message.what == 0) {
                int i10 = 0;
                String message2 = "OK";
                String str = "0:1";
                while (i10 < 3) {
                    try {
                        C1120a.m6677i("KeepLockTask", "keepLock: thread" + Thread.currentThread().getId());
                        int i11 = message.arg1;
                        Lock lockM82466t = i11 == 1 ? new C13717i().m82466t(C12104q.this.f56125a, strM6755Z0) : i11 == 2 ? new C13717i().m82467u(C12104q.this.f56125a, strM6755Z0) : new C13717i().m82465s(C12104q.this.f56125a, strM6755Z0);
                        if (lockM82466t == null) {
                            throw new IllegalStateException("keepExecute lock is null");
                        }
                        String sessionId = lockM82466t.getSessionId();
                        if (!TextUtils.isEmpty(sessionId) && !sessionId.equals(C12104q.this.f56125a)) {
                            C12104q.this.f56125a = sessionId;
                            C1120a.m6675d("KeepLockTask", "keepLock refreshLockCache: " + lockM82466t.toString());
                            int i12 = message.arg1;
                            if (i12 == 1) {
                                C12088a.m72266c().m72273h(lockM82466t);
                            } else if (i12 == 2) {
                                C12109v.m72524c().m72530g(lockM82466t);
                            } else {
                                C12106s.m72509c().m72518j(lockM82466t);
                            }
                        }
                        int i13 = message.arg1;
                        if (i13 == 1) {
                            C12088a.m72266c().m72271f();
                        } else if (i13 == 2) {
                            C12109v.m72524c().m72528e();
                        } else {
                            C12106s.m72509c().m72516h();
                        }
                        Message messageObtain = Message.obtain();
                        int i14 = message.arg1;
                        if (i14 == 1) {
                            messageObtain.arg1 = 1;
                        } else if (i14 == 2) {
                            messageObtain.arg1 = 2;
                        }
                        messageObtain.what = 0;
                        sendMessageDelayed(messageObtain, lockM82466t.getLockInterval().intValue() * 1000);
                        C11060c c11060cM66626a = C11058a.m66626a(strM6755Z0, "Keep.Locks.get", C13452e.m80781L().m80971t0());
                        c11060cM66626a.m66665u(str);
                        c11060cM66626a.m66635A(message2);
                        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
                        return;
                    } catch (IOException e10) {
                        str = "101_4313:1";
                        message2 = e10.getMessage();
                        C1120a.m6676e("KeepLockTask", "keepLock IOException retry: " + i10);
                        i10++;
                        if (i10 == 3) {
                            int i15 = message.arg1;
                            if (i15 == 1) {
                                C12088a.m72266c().m72274i();
                            } else if (i15 == 2) {
                                C12109v.m72524c().m72531h();
                            } else {
                                C12106s.m72509c().m72519k();
                            }
                        }
                        C11060c c11060cM66626a2 = C11058a.m66626a(strM6755Z0, "Keep.Locks.get", C13452e.m80781L().m80971t0());
                        c11060cM66626a2.m66665u(str);
                        c11060cM66626a2.m66635A(message2);
                        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a2);
                    } catch (Exception e11) {
                        try {
                            message2 = e11.getMessage();
                            C1120a.m6676e("KeepLockTask", "keepLock Exception retry: " + i10);
                            i10++;
                            if (i10 == 3) {
                                int i16 = message.arg1;
                                if (i16 == 1) {
                                    C12088a.m72266c().m72274i();
                                } else if (i16 == 2) {
                                    C12109v.m72524c().m72531h();
                                } else {
                                    C12106s.m72509c().m72519k();
                                }
                            }
                            C11060c c11060cM66626a22 = C11058a.m66626a(strM6755Z0, "Keep.Locks.get", C13452e.m80781L().m80971t0());
                            c11060cM66626a22.m66665u(str);
                            c11060cM66626a22.m66635A(message2);
                            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a22);
                        } catch (Throwable th2) {
                            C11060c c11060cM66626a3 = C11058a.m66626a(strM6755Z0, "Keep.Locks.get", C13452e.m80781L().m80971t0());
                            c11060cM66626a3.m66665u(str);
                            c11060cM66626a3.m66635A(message2);
                            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a3);
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public void m72495c() {
        Handler handler = this.f56126b;
        if (handler != null) {
            handler.removeMessages(0);
        }
        HandlerThread handlerThread = this.f56127c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f56126b = null;
        this.f56127c = null;
    }

    /* renamed from: d */
    public final void m72496d() {
        HandlerThread handlerThread = new HandlerThread("KeepLockTaskV2");
        this.f56127c = handlerThread;
        handlerThread.start();
        this.f56126b = new a(this.f56127c.getLooper());
    }

    /* renamed from: e */
    public void m72497e(long j10) {
        C1120a.m6677i("KeepLockTask", "scheduleKeepLock delay: " + j10);
        if (this.f56126b == null) {
            m72496d();
        }
        this.f56126b.removeMessages(0);
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        this.f56126b.sendMessageDelayed(messageObtain, j10);
    }

    /* renamed from: f */
    public void m72498f(long j10) {
        C1120a.m6677i("KeepLockTask", "scheduleKeepLockAlbumClient delay: " + j10);
        if (this.f56126b == null) {
            m72496d();
        }
        this.f56126b.removeMessages(0);
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.arg1 = 1;
        this.f56126b.sendMessageDelayed(messageObtain, j10);
    }

    /* renamed from: g */
    public void m72499g(long j10) {
        C1120a.m6677i("KeepLockTask", "scheduleKeepLockRefund delay: " + j10);
        if (this.f56126b == null) {
            m72496d();
        }
        this.f56126b.removeMessages(0);
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.arg1 = 2;
        this.f56126b.sendMessageDelayed(messageObtain, j10);
    }

    /* renamed from: h */
    public C12104q m72500h(String str) {
        this.f56125a = str;
        return this;
    }
}
