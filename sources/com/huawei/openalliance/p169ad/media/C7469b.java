package com.huawei.openalliance.p169ad.media;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.huawei.openalliance.ad.media.b */
/* loaded from: classes2.dex */
public class C7469b {

    /* renamed from: a */
    private final Set<ReportVideoTimeListener> f34621a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private final String f34622b = Constants.TIMEOUT_TASK_ID + hashCode();

    /* renamed from: c */
    private long f34623c;

    /* renamed from: d */
    private long f34624d;

    /* renamed from: e */
    private long f34625e;

    /* renamed from: f */
    private long f34626f;

    /* renamed from: g */
    private boolean f34627g;

    /* renamed from: h */
    private boolean f34628h;

    /* renamed from: i */
    private int f34629i;

    /* renamed from: j */
    private Context f34630j;

    public C7469b(Context context) {
        this.f34630j = context;
    }

    /* renamed from: c */
    private void m45823c(int i10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f34624d = jCurrentTimeMillis;
        this.f34626f = jCurrentTimeMillis;
        this.f34629i = i10;
        this.f34625e = this.f34623c;
    }

    /* renamed from: a */
    public void m45827a() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoPlayTimeProcessor", "notifyVideoTimeWithVideoStart: videoStartTime %s ", Long.valueOf(this.f34623c));
        }
        if (this.f34623c == 0) {
            this.f34623c = System.currentTimeMillis();
        } else {
            AbstractC7768bo.m47810a(this.f34622b);
        }
        if (this.f34624d != 0) {
            this.f34624d = 0L;
        }
        this.f34628h = false;
    }

    /* renamed from: b */
    public void m45831b(int i10) {
        m45823c(i10);
        long jMo43063ak = C7124fh.m43316b(this.f34630j).mo43063ak();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("VideoPlayTimeProcessor", "notifyVideoTimeWithVideoPause: %s", Long.valueOf(jMo43063ak));
        }
        AbstractC7768bo.m47809a(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("VideoPlayTimeProcessor", "notifyVideoTimeWithVideoPause: videoStartTime %s , videoPauseTime %s", Long.valueOf(C7469b.this.f34625e), Long.valueOf(C7469b.this.f34626f));
                }
                if (C7469b.this.f34627g) {
                    return;
                }
                if (C7469b.this.f34625e == 0) {
                    C7469b c7469b = C7469b.this;
                    c7469b.m45822b(c7469b.f34623c);
                    return;
                }
                long j10 = C7469b.this.f34626f - C7469b.this.f34625e;
                C7469b c7469b2 = C7469b.this;
                if (j10 > c7469b2.f34629i || j10 < 0) {
                    j10 = C7469b.this.f34629i;
                }
                c7469b2.m45822b(j10);
                C7469b.this.f34627g = true;
            }
        }, this.f34622b, jMo43063ak);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m45822b(long j10) {
        AbstractC7185ho.m43821b("VideoPlayTimeProcessor", "notifyVideoTime: videoTime: %s ", Long.valueOf(j10));
        Iterator<ReportVideoTimeListener> it = this.f34621a.iterator();
        while (it.hasNext()) {
            it.next().reportVideoTime(j10);
        }
    }

    /* renamed from: a */
    public void m45828a(int i10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("VideoPlayTimeProcessor", "notifyVideoTimeWithVideoStop");
        }
        m45829a(i10);
        AbstractC7768bo.m47810a(this.f34622b);
        this.f34623c = 0L;
    }

    /* renamed from: a */
    public void m45829a(long j10) {
        if (this.f34627g || this.f34628h) {
            this.f34627g = false;
            this.f34628h = true;
            return;
        }
        long j11 = this.f34623c;
        if (j11 != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f34623c;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("VideoPlayTimeProcessor", "notifyVideoTimeWithVideoEnd: videoTime %s  ,playTime %s", Long.valueOf(jCurrentTimeMillis), Long.valueOf(j10));
            }
            if (jCurrentTimeMillis <= j10 && jCurrentTimeMillis >= 0) {
                j10 = jCurrentTimeMillis;
            }
            m45822b(j10);
            this.f34623c = 0L;
        } else {
            m45822b(j11);
        }
        if (this.f34624d != 0) {
            this.f34624d = 0L;
        }
        this.f34628h = true;
    }

    /* renamed from: a */
    public void m45830a(ReportVideoTimeListener reportVideoTimeListener) {
        if (reportVideoTimeListener == null) {
            return;
        }
        this.f34621a.add(reportVideoTimeListener);
    }
}
