package com.huawei.openalliance.p169ad.media;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.huawei.openalliance.ad.media.a */
/* loaded from: classes2.dex */
public class C7468a implements IMultiMediaPlayingManager {

    /* renamed from: a */
    private static C7468a f34609a;

    /* renamed from: b */
    private static final byte[] f34610b = new byte[0];

    /* renamed from: d */
    private MediaPlayerAgent f34612d;

    /* renamed from: f */
    private Context f34614f;

    /* renamed from: c */
    private final byte[] f34611c = new byte[0];

    /* renamed from: e */
    private Queue<a> f34613e = new ConcurrentLinkedQueue();

    /* renamed from: g */
    private MediaStateListener f34615g = new MediaStateListener() { // from class: com.huawei.openalliance.ad.media.a.1
        /* renamed from: a */
        private void m45817a() {
            synchronized (C7468a.this.f34611c) {
                try {
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("MultiMediaPlayingManager", "checkAndPlayNext current player: %s", C7468a.this.f34612d);
                    }
                    if (C7468a.this.f34612d == null) {
                        C7468a.this.m45813a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("MultiMediaPlayingManager", "onMediaCompletion: %s", mediaPlayerAgent);
            }
            C7468a.this.m45813a();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("MultiMediaPlayingManager", "onMediaPause: %s", mediaPlayerAgent);
            }
            m45817a();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("MultiMediaPlayingManager", "onMediaStop: %s", mediaPlayerAgent);
            }
            m45817a();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onProgress(int i10, int i11) {
        }
    };

    /* renamed from: h */
    private MediaErrorListener f34616h = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.media.a.2
        @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
        public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("MultiMediaPlayingManager", "onError: %s", mediaPlayerAgent);
            }
            synchronized (C7468a.this.f34611c) {
                mediaPlayerAgent.removeMediaErrorListener(this);
            }
            C7468a.this.m45813a();
        }
    };

    /* renamed from: com.huawei.openalliance.ad.media.a$a */
    public static class a {

        /* renamed from: a */
        final String f34619a;

        /* renamed from: b */
        final MediaPlayerAgent f34620b;

        public a(String str, MediaPlayerAgent mediaPlayerAgent) {
            this.f34619a = str;
            this.f34620b = mediaPlayerAgent;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f34619a, aVar.f34619a) && this.f34620b == aVar.f34620b;
        }

        public int hashCode() {
            String str = this.f34619a;
            int iHashCode = str != null ? str.hashCode() : -1;
            MediaPlayerAgent mediaPlayerAgent = this.f34620b;
            return super.hashCode() & iHashCode & (mediaPlayerAgent != null ? mediaPlayerAgent.hashCode() : -1);
        }

        public String toString() {
            return "Task [" + AbstractC7819dl.m48375a(this.f34619a) + "]";
        }
    }

    private C7468a(Context context) {
        this.f34614f = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C7468a m45812a(Context context) {
        C7468a c7468a;
        synchronized (f34610b) {
            try {
                if (f34609a == null) {
                    f34609a = new C7468a(context);
                }
                c7468a = f34609a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7468a;
    }

    @Override // com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager
    public void autoPlay(String str, MediaPlayerAgent mediaPlayerAgent) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.f34611c) {
            try {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MultiMediaPlayingManager", "autoPlay - url: %s player: %s currentPlayer: %s", AbstractC7819dl.m48375a(str), mediaPlayerAgent, this.f34612d);
                }
                MediaPlayerAgent mediaPlayerAgent2 = this.f34612d;
                if (mediaPlayerAgent == mediaPlayerAgent2 || mediaPlayerAgent2 == null) {
                    mediaPlayerAgent.addMediaStateListener(this.f34615g);
                    mediaPlayerAgent.addMediaErrorListener(this.f34616h);
                    mediaPlayerAgent.playWhenUrlMatchs(str);
                    this.f34612d = mediaPlayerAgent;
                    str2 = "MultiMediaPlayingManager";
                    str3 = "autoPlay - play directly";
                } else {
                    a aVar = new a(str, mediaPlayerAgent);
                    this.f34613e.remove(aVar);
                    this.f34613e.add(aVar);
                    str2 = "MultiMediaPlayingManager";
                    str3 = "autoPlay - add to queue";
                }
                AbstractC7185ho.m43820b(str2, str3);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager
    public void manualPlay(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.f34611c) {
            try {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MultiMediaPlayingManager", "manualPlay - url: %s player: %s  currentPlayer: %s", AbstractC7819dl.m48375a(str), mediaPlayerAgent, this.f34612d);
                }
                MediaPlayerAgent mediaPlayerAgent2 = this.f34612d;
                if (mediaPlayerAgent2 != null && mediaPlayerAgent != mediaPlayerAgent2) {
                    mediaPlayerAgent2.stop();
                    AbstractC7185ho.m43820b("MultiMediaPlayingManager", "manualPlay - stop other");
                }
                AbstractC7185ho.m43820b("MultiMediaPlayingManager", "manualPlay - play new");
                mediaPlayerAgent.addMediaStateListener(this.f34615g);
                mediaPlayerAgent.addMediaErrorListener(this.f34616h);
                mediaPlayerAgent.playWhenUrlMatchs(str);
                this.f34612d = mediaPlayerAgent;
                this.f34613e.remove(new a(str, mediaPlayerAgent));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager
    public void pause(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.f34611c) {
            try {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MultiMediaPlayingManager", "pause - url: %s player: %s  currentPlayer: %s", AbstractC7819dl.m48375a(str), mediaPlayerAgent, this.f34612d);
                }
                if (mediaPlayerAgent == this.f34612d) {
                    AbstractC7185ho.m43820b("MultiMediaPlayingManager", "pause current");
                    mediaPlayerAgent.pauseWhenUrlMatchs(str);
                } else {
                    AbstractC7185ho.m43820b("MultiMediaPlayingManager", "pause - remove from queue");
                    this.f34613e.remove(new a(str, mediaPlayerAgent));
                    removeListenersForMediaPlayerAgent(mediaPlayerAgent);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager
    public void removeListenersForMediaPlayerAgent(MediaPlayerAgent mediaPlayerAgent) {
        synchronized (this.f34611c) {
            if (mediaPlayerAgent != null) {
                try {
                    mediaPlayerAgent.removeMediaStateListener(this.f34615g);
                    mediaPlayerAgent.removeMediaErrorListener(this.f34616h);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager
    public void removeMediaPlayerAgent(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.f34611c) {
            try {
                MediaPlayerAgent mediaPlayerAgent2 = this.f34612d;
                if (mediaPlayerAgent == mediaPlayerAgent2) {
                    removeListenersForMediaPlayerAgent(mediaPlayerAgent2);
                    this.f34612d = null;
                }
                Iterator<a> it = this.f34613e.iterator();
                while (it.hasNext()) {
                    MediaPlayerAgent mediaPlayerAgent3 = it.next().f34620b;
                    if (mediaPlayerAgent3 == mediaPlayerAgent) {
                        removeListenersForMediaPlayerAgent(mediaPlayerAgent3);
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager
    public void stop(String str, MediaPlayerAgent mediaPlayerAgent) {
        if (TextUtils.isEmpty(str) || mediaPlayerAgent == null) {
            return;
        }
        synchronized (this.f34611c) {
            try {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("MultiMediaPlayingManager", "stop - url: %s player: %s  currentPlayer: %s", AbstractC7819dl.m48375a(str), mediaPlayerAgent, this.f34612d);
                }
                if (mediaPlayerAgent == this.f34612d) {
                    AbstractC7185ho.m43820b("MultiMediaPlayingManager", "stop current");
                    this.f34612d = null;
                    mediaPlayerAgent.stopWhenUrlMatchs(str);
                } else {
                    AbstractC7185ho.m43820b("MultiMediaPlayingManager", "stop - remove from queue");
                    this.f34613e.remove(new a(str, mediaPlayerAgent));
                    removeListenersForMediaPlayerAgent(mediaPlayerAgent);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45813a() {
        if (C7775bv.m47829c(this.f34614f)) {
            synchronized (this.f34611c) {
                try {
                    a aVarPoll = this.f34613e.poll();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("MultiMediaPlayingManager", "playNextTask - task: %s currentPlayer: %s", aVarPoll, this.f34612d);
                    }
                    if (aVarPoll != null) {
                        if (AbstractC7185ho.m43819a()) {
                            AbstractC7185ho.m43818a("MultiMediaPlayingManager", "playNextTask - play: %s", aVarPoll.f34620b);
                        }
                        aVarPoll.f34620b.addMediaStateListener(this.f34615g);
                        aVarPoll.f34620b.addMediaErrorListener(this.f34616h);
                        aVarPoll.f34620b.playWhenUrlMatchs(aVarPoll.f34619a);
                        this.f34612d = aVarPoll.f34620b;
                    } else {
                        this.f34612d = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
