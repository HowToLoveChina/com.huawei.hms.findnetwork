package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.huawei.openalliance.p169ad.C7088ed;
import com.huawei.openalliance.p169ad.C7092eh;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.utils.C7738al;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.huawei.openalliance.ad.views.g */
/* loaded from: classes2.dex */
public class C8099g {

    /* renamed from: a */
    private final C7738al f37664a;

    /* renamed from: b */
    private C7088ed f37665b;

    /* renamed from: c */
    private MediaPlayerAgent f37666c;

    /* renamed from: d */
    private C7092eh f37667d;

    /* renamed from: e */
    private SurfaceTexture f37668e;

    /* renamed from: f */
    private int f37669f;

    /* renamed from: g */
    private Surface f37670g;

    /* renamed from: h */
    private final Set<WeakReference<InterfaceC8128u>> f37671h;

    /* renamed from: i */
    private SurfaceTexture.OnFrameAvailableListener f37672i;

    public C8099g(Context context) {
        C7738al c7738al = new C7738al("video_render");
        this.f37664a = c7738al;
        this.f37671h = new CopyOnWriteArraySet();
        this.f37672i = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.huawei.openalliance.ad.views.g.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                C8099g.this.m50166j();
            }
        };
        this.f37666c = new MediaPlayerAgent(context);
        c7738al.m47517a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m50166j() {
        Iterator<WeakReference<InterfaceC8128u>> it = this.f37671h.iterator();
        while (it.hasNext()) {
            InterfaceC8128u interfaceC8128u = it.next().get();
            if (interfaceC8128u != null) {
                interfaceC8128u.mo48803b();
                interfaceC8128u.mo48804c();
            }
        }
    }

    /* renamed from: a */
    public synchronized void m50167a() {
        try {
        } finally {
        }
        if (this.f37667d != null) {
            return;
        }
        C7092eh c7092eh = new C7092eh();
        this.f37667d = c7092eh;
        this.f37669f = c7092eh.m42917b();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f37669f);
        this.f37668e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this.f37672i);
        Surface surface = new Surface(this.f37668e);
        this.f37670g = surface;
        this.f37666c.setSurface(surface);
    }

    /* renamed from: b */
    public synchronized void m50170b() {
        if (this.f37665b != null) {
            return;
        }
        this.f37665b = new C7088ed();
    }

    /* renamed from: c */
    public synchronized Surface m50172c() {
        return this.f37670g;
    }

    /* renamed from: d */
    public synchronized int m50173d() {
        return this.f37669f;
    }

    /* renamed from: e */
    public synchronized SurfaceTexture m50174e() {
        return this.f37668e;
    }

    /* renamed from: f */
    public synchronized C7092eh m50175f() {
        return this.f37667d;
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.f37664a.m47521b();
    }

    /* renamed from: g */
    public synchronized C7088ed m50176g() {
        return this.f37665b;
    }

    /* renamed from: h */
    public synchronized MediaPlayerAgent m50177h() {
        return this.f37666c;
    }

    /* renamed from: i */
    public void m50178i() {
        C7092eh c7092eh = this.f37667d;
        if (c7092eh != null) {
            c7092eh.m42915a();
            this.f37667d = null;
        }
        C7088ed c7088ed = this.f37665b;
        if (c7088ed != null) {
            c7088ed.m42883b();
            this.f37665b.m42881a();
            this.f37665b = null;
        }
        SurfaceTexture surfaceTexture = this.f37668e;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    /* renamed from: b */
    public void m50171b(InterfaceC8128u interfaceC8128u) {
        WeakReference<InterfaceC8128u> weakReference = null;
        for (WeakReference<InterfaceC8128u> weakReference2 : this.f37671h) {
            if (weakReference2.get() == interfaceC8128u) {
                weakReference = weakReference2;
            }
        }
        if (weakReference != null) {
            this.f37671h.remove(weakReference);
        }
    }

    /* renamed from: a */
    public void m50168a(InterfaceC8128u interfaceC8128u) {
        interfaceC8128u.mo48802a(this);
        this.f37671h.add(new WeakReference<>(interfaceC8128u));
    }

    /* renamed from: a */
    public void m50169a(Runnable runnable) {
        this.f37664a.m47518a(runnable);
    }
}
