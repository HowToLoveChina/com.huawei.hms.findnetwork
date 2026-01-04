package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8125r;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class RewardMediaView extends AutoScaleSizeRelativeLayout implements IViewLifeCycle, InterfaceC8125r {

    /* renamed from: a */
    protected C7305h f37312a;

    /* renamed from: b */
    protected String f37313b;

    /* renamed from: c */
    protected boolean f37314c;

    /* renamed from: d */
    protected boolean f37315d;

    /* renamed from: e */
    private VideoInfo f37316e;

    /* renamed from: f */
    private final Set<SegmentMediaStateListener> f37317f;

    /* renamed from: g */
    private int f37318g;

    /* renamed from: h */
    private long f37319h;

    /* renamed from: i */
    private long f37320i;

    /* renamed from: j */
    private long f37321j;

    /* renamed from: k */
    private boolean f37322k;

    /* renamed from: l */
    private boolean f37323l;

    /* renamed from: m */
    private long f37324m;

    /* renamed from: n */
    private Handler f37325n;

    public RewardMediaView(Context context) {
        super(context);
        this.f37317f = new CopyOnWriteArraySet();
        this.f37318g = 0;
        this.f37319h = 0L;
        this.f37320i = 0L;
        this.f37322k = false;
        this.f37323l = false;
        this.f37314c = false;
        this.f37315d = false;
        this.f37324m = 0L;
        this.f37325n = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.RewardMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        RewardMediaView.this.f37318g = (int) ((AbstractC7741ao.m47566c() - RewardMediaView.this.f37319h) - RewardMediaView.this.f37321j);
                        if (RewardMediaView.this.m49868k()) {
                            RewardMediaView.this.m49867j();
                        } else {
                            RewardMediaView.this.m49865h();
                            RewardMediaView.this.f37325n.removeMessages(1);
                            RewardMediaView.this.f37325n.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                } catch (Throwable th2) {
                    str = "handleMessage " + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                }
            }
        };
    }

    /* renamed from: g */
    private void m49864g() {
        if (this.f37322k) {
            return;
        }
        this.f37322k = true;
        Iterator<SegmentMediaStateListener> it = this.f37317f.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaStart(this.f37312a.getContentId(), this.f37313b, this.f37318g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m49865h() {
        if (this.f37324m <= 0 || this.f37323l) {
            return;
        }
        for (SegmentMediaStateListener segmentMediaStateListener : this.f37317f) {
            String contentId = this.f37312a.getContentId();
            String str = this.f37313b;
            int i10 = this.f37318g;
            segmentMediaStateListener.onSegmentProgress(contentId, str, (int) (i10 / this.f37324m), i10);
        }
    }

    /* renamed from: i */
    private void m49866i() {
        Iterator<SegmentMediaStateListener> it = this.f37317f.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaPause(this.f37312a.getContentId(), this.f37313b, this.f37318g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m49867j() {
        this.f37322k = false;
        Iterator<SegmentMediaStateListener> it = this.f37317f.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaCompletion(this.f37312a.getContentId(), this.f37313b, this.f37318g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public boolean m49868k() {
        return ((long) this.f37318g) >= this.f37324m;
    }

    /* renamed from: c */
    public void mo49875c() {
    }

    /* renamed from: d */
    public void mo49876d() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f37325n.removeMessages(1);
        this.f37317f.clear();
    }

    /* renamed from: e */
    public void m49877e() {
        this.f37322k = false;
        this.f37323l = true;
        Iterator<SegmentMediaStateListener> it = this.f37317f.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaError(this.f37312a.getContentId(), this.f37313b, 0, -1, -1);
        }
    }

    public IRewardAd getRewardAd() {
        return this.f37312a;
    }

    public void setRewardAd(IRewardAd iRewardAd) {
        String videoDownloadUrl;
        m49863f();
        if (iRewardAd instanceof C7305h) {
            C7305h c7305h = (C7305h) iRewardAd;
            this.f37312a = c7305h;
            this.f37316e = c7305h.m44918K();
            this.f37324m = r3.getVideoDuration();
            videoDownloadUrl = this.f37316e.getVideoDownloadUrl();
        } else {
            this.f37312a = null;
            this.f37316e = null;
            this.f37325n.removeMessages(1);
            videoDownloadUrl = "";
        }
        this.f37313b = videoDownloadUrl;
    }

    public RewardMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37317f = new CopyOnWriteArraySet();
        this.f37318g = 0;
        this.f37319h = 0L;
        this.f37320i = 0L;
        this.f37322k = false;
        this.f37323l = false;
        this.f37314c = false;
        this.f37315d = false;
        this.f37324m = 0L;
        this.f37325n = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.RewardMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        RewardMediaView.this.f37318g = (int) ((AbstractC7741ao.m47566c() - RewardMediaView.this.f37319h) - RewardMediaView.this.f37321j);
                        if (RewardMediaView.this.m49868k()) {
                            RewardMediaView.this.m49867j();
                        } else {
                            RewardMediaView.this.m49865h();
                            RewardMediaView.this.f37325n.removeMessages(1);
                            RewardMediaView.this.f37325n.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                } catch (Throwable th2) {
                    str = "handleMessage " + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                }
            }
        };
    }

    /* renamed from: f */
    private void m49863f() {
        this.f37324m = 0L;
        this.f37318g = 0;
        this.f37319h = 0L;
        this.f37320i = 0L;
        this.f37321j = 0L;
        this.f37322k = false;
        this.f37323l = false;
        this.f37315d = false;
        this.f37314c = false;
    }

    /* renamed from: b */
    public void mo49874b() {
    }

    public RewardMediaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37317f = new CopyOnWriteArraySet();
        this.f37318g = 0;
        this.f37319h = 0L;
        this.f37320i = 0L;
        this.f37322k = false;
        this.f37323l = false;
        this.f37314c = false;
        this.f37315d = false;
        this.f37324m = 0L;
        this.f37325n = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.RewardMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        RewardMediaView.this.f37318g = (int) ((AbstractC7741ao.m47566c() - RewardMediaView.this.f37319h) - RewardMediaView.this.f37321j);
                        if (RewardMediaView.this.m49868k()) {
                            RewardMediaView.this.m49867j();
                        } else {
                            RewardMediaView.this.m49865h();
                            RewardMediaView.this.f37325n.removeMessages(1);
                            RewardMediaView.this.f37325n.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                } catch (Throwable th2) {
                    str = "handleMessage " + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo49869a() {
        this.f37325n.removeMessages(1);
        this.f37320i = AbstractC7741ao.m47566c();
        m49866i();
    }

    @TargetApi(21)
    public RewardMediaView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37317f = new CopyOnWriteArraySet();
        this.f37318g = 0;
        this.f37319h = 0L;
        this.f37320i = 0L;
        this.f37322k = false;
        this.f37323l = false;
        this.f37314c = false;
        this.f37315d = false;
        this.f37324m = 0L;
        this.f37325n = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.RewardMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        RewardMediaView.this.f37318g = (int) ((AbstractC7741ao.m47566c() - RewardMediaView.this.f37319h) - RewardMediaView.this.f37321j);
                        if (RewardMediaView.this.m49868k()) {
                            RewardMediaView.this.m49867j();
                        } else {
                            RewardMediaView.this.m49865h();
                            RewardMediaView.this.f37325n.removeMessages(1);
                            RewardMediaView.this.f37325n.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                } catch (Throwable th2) {
                    str = "handleMessage " + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("RewardMediaView", str);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo49870a(long j10) {
    }

    /* renamed from: a */
    public void mo49871a(SegmentMediaStateListener segmentMediaStateListener) {
        if (segmentMediaStateListener != null) {
            this.f37317f.add(segmentMediaStateListener);
        }
    }

    /* renamed from: a */
    public void mo49872a(String str) {
    }

    /* renamed from: a */
    public void mo49873a(boolean z10, boolean z11) {
        if (this.f37314c) {
            if (!this.f37315d) {
                m49877e();
                return;
            }
            this.f37325n.removeMessages(1);
            this.f37325n.sendEmptyMessage(1);
            m49864g();
            if (0 == this.f37319h) {
                this.f37319h = AbstractC7741ao.m47566c();
            }
            if (this.f37320i != 0) {
                this.f37321j += AbstractC7741ao.m47566c() - this.f37320i;
            }
        }
    }
}
