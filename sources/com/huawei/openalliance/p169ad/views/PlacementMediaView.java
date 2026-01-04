package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaPlayerReleaseListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8123p;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class PlacementMediaView extends AutoScaleSizeRelativeLayout implements InterfaceC7403lm, IViewLifeCycle, InterfaceC8123p {

    /* renamed from: a */
    protected C7304g f37258a;

    /* renamed from: b */
    protected String f37259b;

    /* renamed from: c */
    protected String f37260c;

    /* renamed from: d */
    protected boolean f37261d;

    /* renamed from: e */
    protected boolean f37262e;

    /* renamed from: f */
    protected boolean f37263f;

    /* renamed from: g */
    private PlacementMediaFile f37264g;

    /* renamed from: h */
    private final Set<SegmentMediaStateListener> f37265h;

    /* renamed from: i */
    private int f37266i;

    /* renamed from: j */
    private long f37267j;

    /* renamed from: k */
    private long f37268k;

    /* renamed from: l */
    private long f37269l;

    /* renamed from: m */
    private long f37270m;

    /* renamed from: n */
    private boolean f37271n;

    /* renamed from: o */
    private boolean f37272o;

    /* renamed from: p */
    private Handler f37273p;

    public PlacementMediaView(Context context) {
        super(context);
        this.f37265h = new CopyOnWriteArraySet();
        this.f37266i = 0;
        this.f37267j = 0L;
        this.f37268k = 0L;
        this.f37269l = 0L;
        this.f37271n = false;
        this.f37272o = false;
        this.f37261d = false;
        this.f37262e = false;
        this.f37263f = false;
        this.f37273p = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.f37266i = (int) ((AbstractC7741ao.m47566c() - PlacementMediaView.this.f37267j) - PlacementMediaView.this.f37270m);
                        if (PlacementMediaView.this.m49802o()) {
                            PlacementMediaView.this.m49801n();
                        } else {
                            PlacementMediaView.this.m49799l();
                            PlacementMediaView.this.f37273p.removeMessages(1);
                            PlacementMediaView.this.f37273p.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    AbstractC7185ho.m43823c("PlacementMediaView", str);
                } catch (Throwable th2) {
                    str = "handleMessage " + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("PlacementMediaView", str);
                }
            }
        };
    }

    /* renamed from: j */
    private void m49797j() {
        this.f37266i = 0;
        this.f37267j = 0L;
        this.f37269l = 0L;
        this.f37268k = 0L;
        this.f37270m = 0L;
        this.f37271n = false;
        this.f37272o = false;
        this.f37262e = false;
        this.f37261d = false;
        this.f37263f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m49798k() {
        if (this.f37271n) {
            return;
        }
        this.f37271n = true;
        Iterator<SegmentMediaStateListener> it = this.f37265h.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaStart(this.f37260c, this.f37259b, this.f37266i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m49799l() {
        if (this.f37268k <= 0 || this.f37272o) {
            return;
        }
        for (SegmentMediaStateListener segmentMediaStateListener : this.f37265h) {
            String str = this.f37260c;
            String str2 = this.f37259b;
            int i10 = this.f37266i;
            segmentMediaStateListener.onSegmentProgress(str, str2, (int) (i10 / this.f37268k), i10);
        }
    }

    /* renamed from: m */
    private void m49800m() {
        Iterator<SegmentMediaStateListener> it = this.f37265h.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaPause(this.f37260c, this.f37259b, this.f37266i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m49801n() {
        this.f37271n = false;
        Iterator<SegmentMediaStateListener> it = this.f37265h.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaCompletion(this.f37260c, this.f37259b, this.f37266i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public boolean m49802o() {
        return ((long) this.f37266i) >= this.f37268k;
    }

    /* renamed from: a */
    public abstract void mo49803a();

    /* renamed from: a */
    public abstract void mo49804a(int i10);

    /* renamed from: a */
    public abstract void mo49808a(MediaPlayerReleaseListener mediaPlayerReleaseListener);

    /* renamed from: b */
    public abstract void mo49814b();

    /* renamed from: c */
    public void mo49821c() {
    }

    /* renamed from: d */
    public void mo49823d() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f37273p.removeMessages(1);
        this.f37265h.clear();
        mo49803a();
    }

    /* renamed from: e */
    public void mo49825e() {
    }

    /* renamed from: g */
    public void mo49827g() {
    }

    public long getDuration() {
        PlacementMediaFile mediaFile;
        C7304g c7304g = this.f37258a;
        if (c7304g == null || (mediaFile = c7304g.getMediaFile()) == null) {
            return 0L;
        }
        return mediaFile.getDuration();
    }

    public abstract ImageView getLastFrame();

    public abstract MediaState getMediaState();

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    public IPlacementAd getPlacementAd() {
        return this.f37258a;
    }

    /* renamed from: i */
    public boolean mo49829i() {
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
    }

    public void setAudioFocusType(int i10) {
    }

    public abstract void setMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener);

    public void setPlacementAd(IPlacementAd iPlacementAd) {
        String contentId;
        m49797j();
        if (iPlacementAd instanceof C7304g) {
            C7304g c7304g = (C7304g) iPlacementAd;
            this.f37258a = c7304g;
            PlacementMediaFile mediaFile = c7304g.getMediaFile();
            this.f37264g = mediaFile;
            this.f37268k = mediaFile.getDuration();
            this.f37259b = this.f37264g.getUrl();
            contentId = iPlacementAd.getContentId();
        } else {
            this.f37258a = null;
            this.f37264g = null;
            this.f37273p.removeMessages(1);
            contentId = "";
            this.f37259b = "";
        }
        this.f37260c = contentId;
    }

    public void setSoundVolume(float f10) {
    }

    /* renamed from: c */
    public void mo49822c(int i10) {
    }

    /* renamed from: d */
    public void mo49824d(int i10) {
    }

    /* renamed from: f */
    public void mo49826f() {
        this.f37273p.removeMessages(1);
        this.f37269l = AbstractC7741ao.m47566c();
        m49800m();
    }

    /* renamed from: h */
    public void m49828h() {
        this.f37271n = false;
        this.f37272o = true;
        Iterator<SegmentMediaStateListener> it = this.f37265h.iterator();
        while (it.hasNext()) {
            it.next().onSegmentMediaError(this.f37260c, this.f37259b, 0, -1, -1);
        }
    }

    /* renamed from: b */
    public void mo49815b(int i10) {
    }

    /* renamed from: a */
    public void mo49805a(long j10) {
    }

    /* renamed from: b */
    public void mo49816b(long j10) {
    }

    /* renamed from: a */
    public void mo49806a(MediaBufferListener mediaBufferListener) {
    }

    /* renamed from: b */
    public void mo49817b(MediaBufferListener mediaBufferListener) {
    }

    /* renamed from: a */
    public void mo49807a(MediaErrorListener mediaErrorListener) {
    }

    /* renamed from: b */
    public void mo49818b(MediaErrorListener mediaErrorListener) {
    }

    /* renamed from: a */
    public void mo49809a(MuteListener muteListener) {
    }

    /* renamed from: b */
    public void mo49819b(MuteListener muteListener) {
    }

    /* renamed from: a */
    public void mo49810a(PPSVideoRenderListener pPSVideoRenderListener) {
    }

    /* renamed from: b */
    public void mo49820b(SegmentMediaStateListener segmentMediaStateListener) {
        if (segmentMediaStateListener != null) {
            this.f37265h.add(segmentMediaStateListener);
        }
    }

    /* renamed from: a */
    public void mo49811a(SegmentMediaStateListener segmentMediaStateListener) {
    }

    /* renamed from: a */
    public void mo49812a(String str) {
    }

    /* renamed from: a */
    public void mo49813a(boolean z10, boolean z11) {
        AbstractC7185ho.m43821b("PlacementMediaView", "play, mediaCached: %s, mediaAvalible: %s", Boolean.valueOf(this.f37261d), Boolean.valueOf(this.f37262e));
        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.2
            @Override // java.lang.Runnable
            public void run() {
                PlacementMediaView placementMediaView = PlacementMediaView.this;
                if (!placementMediaView.f37261d) {
                    placementMediaView.f37263f = true;
                    return;
                }
                if (!placementMediaView.f37262e) {
                    placementMediaView.m49828h();
                    return;
                }
                placementMediaView.f37273p.removeMessages(1);
                PlacementMediaView.this.f37273p.sendEmptyMessage(1);
                PlacementMediaView.this.m49798k();
                if (0 == PlacementMediaView.this.f37267j) {
                    PlacementMediaView.this.f37267j = AbstractC7741ao.m47566c();
                }
                if (PlacementMediaView.this.f37269l != 0) {
                    PlacementMediaView.this.f37270m += AbstractC7741ao.m47566c() - PlacementMediaView.this.f37269l;
                }
            }
        }, 1L);
    }
}
