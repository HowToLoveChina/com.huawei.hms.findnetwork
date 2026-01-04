package com.huawei.openalliance.p169ad.views.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7738al;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.huawei.openalliance.ad.views.gif.b */
/* loaded from: classes2.dex */
public class C8101b extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: f */
    private Paint f37724f;

    /* renamed from: i */
    private String f37727i;

    /* renamed from: l */
    private int f37730l;

    /* renamed from: m */
    private int f37731m;

    /* renamed from: o */
    private C8100a f37733o;

    /* renamed from: p */
    private Context f37734p;

    /* renamed from: r */
    private C8102c f37736r;

    /* renamed from: s */
    private boolean f37737s;

    /* renamed from: t */
    private C7738al f37738t;

    /* renamed from: v */
    private InterfaceC8103d f37740v;

    /* renamed from: a */
    private final String f37719a = "render_frame" + hashCode();

    /* renamed from: b */
    private Canvas f37720b = new Canvas();

    /* renamed from: c */
    private Rect f37721c = new Rect();

    /* renamed from: d */
    private Rect f37722d = new Rect();

    /* renamed from: e */
    private Rect f37723e = new Rect();

    /* renamed from: g */
    private boolean f37725g = false;

    /* renamed from: h */
    private int f37726h = 0;

    /* renamed from: j */
    private Queue<C8102c> f37728j = new ConcurrentLinkedQueue();

    /* renamed from: k */
    private Queue<Bitmap> f37729k = new ConcurrentLinkedQueue();

    /* renamed from: n */
    private boolean f37732n = false;

    /* renamed from: q */
    private long f37735q = 0;

    /* renamed from: u */
    private final WeakHashMap<Drawable.Callback, Void> f37739u = new WeakHashMap<>();

    public C8101b(Context context, String str) {
        this.f37734p = context.getApplicationContext();
        this.f37727i = str;
        C7738al c7738al = new C7738al("gif-thread");
        this.f37738t = c7738al;
        c7738al.m47517a();
        setCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap m50203a(android.graphics.Bitmap r7, boolean r8) {
        /*
            r6 = this;
            boolean r0 = com.huawei.openalliance.p169ad.AbstractC7185ho.m43819a()
            if (r0 == 0) goto L1d
            java.lang.String r0 = r6.m50246o()
            java.util.Queue<android.graphics.Bitmap> r1 = r6.f37729k
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r2 = "image pool size: %d"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43818a(r0, r2, r1)
        L1d:
            java.util.Queue<android.graphics.Bitmap> r0 = r6.f37729k
            java.lang.Object r0 = r0.poll()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 != 0) goto L7e
            java.lang.String r0 = r6.m50246o()
            java.lang.String r1 = "cache bitmap null"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r0, r1)
            if (r8 == 0) goto L74
            int r8 = r7.getWidth()
            int r0 = r7.getHeight()
            if (r8 >= r0) goto L41
            r1 = 640(0x280, float:8.97E-43)
            if (r8 <= r1) goto L46
            goto L47
        L41:
            r1 = 960(0x3c0, float:1.345E-42)
            if (r8 <= r1) goto L46
            goto L47
        L46:
            r1 = r8
        L47:
            int r2 = r1 * r0
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 * r3
            float r3 = (float) r8
            float r2 = r2 / r3
            int r2 = (int) r2
            java.lang.String r3 = r6.m50246o()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r8 = new java.lang.Object[]{r4, r5, r8, r0}
            java.lang.String r0 = "reduce image size to w: %d, h: %d src w: %d, h: %d"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r3, r0, r8)
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.RGB_565
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r8)
            goto L7e
        L74:
            android.graphics.Bitmap$Config r6 = r7.getConfig()
            r8 = 1
            android.graphics.Bitmap r6 = r7.copy(r6, r8)
            return r6
        L7e:
            r6.m50205a(r7, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.gif.C8101b.m50203a(android.graphics.Bitmap, boolean):android.graphics.Bitmap");
    }

    /* renamed from: d */
    private Paint m50221d() {
        if (this.f37724f == null) {
            this.f37724f = new Paint(2);
        }
        return this.f37724f;
    }

    /* renamed from: e */
    private InputStream m50224e(String str) throws NumberFormatException {
        String strM50246o;
        StringBuilder sb2;
        try {
            return this.f37734p.getResources().openRawResource(Integer.parseInt(str.substring(Scheme.RES.toString().length())));
        } catch (Resources.NotFoundException e10) {
            e = e10;
            strM50246o = this.m50246o();
            sb2 = new StringBuilder();
            sb2.append("loadFile ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c(strM50246o, sb2.toString());
            return null;
        } catch (NumberFormatException e11) {
            e = e11;
            strM50246o = this.m50246o();
            sb2 = new StringBuilder();
            sb2.append("loadFile ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c(strM50246o, sb2.toString());
            return null;
        }
    }

    /* renamed from: i */
    public static /* synthetic */ int m50234i(C8101b c8101b) {
        int i10 = c8101b.f37730l;
        c8101b.f37730l = i10 + 1;
        return i10;
    }

    /* renamed from: l */
    private void m50240l() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.6
            @Override // java.lang.Runnable
            public void run() {
                if (C8101b.this.f37740v != null) {
                    C8101b.this.f37740v.mo48916a();
                }
            }
        });
    }

    /* renamed from: m */
    private void m50242m() {
        this.f37729k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m50244n() {
        AbstractC7185ho.m43820b(m50246o(), "on play end");
        m50242m();
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.8
            @Override // java.lang.Runnable
            public void run() {
                if (C8101b.this.f37740v != null) {
                    C8101b.this.f37740v.mo48918c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public String m50246o() {
        return "GifDrawable_" + hashCode();
    }

    /* renamed from: c */
    public int m50250c() {
        int size = (this.f37729k.size() + this.f37728j.size()) * getIntrinsicWidth() * getIntrinsicHeight() * 4;
        if (size > 0) {
            return size;
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C8102c c8102c = this.f37736r;
        if (c8102c == null || c8102c.f37752b == null) {
            return;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(m50246o(), "draw frame: %d", Integer.valueOf(this.f37736r.f37751a));
        }
        if (this.f37737s) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f37721c);
            this.f37737s = false;
        }
        canvas.drawBitmap(this.f37736r.f37752b, (Rect) null, this.f37721c, m50221d());
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.f37738t.m47521b();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        C8102c c8102c = this.f37736r;
        return c8102c != null ? c8102c.f37752b.getHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        C8102c c8102c = this.f37736r;
        return c8102c != null ? c8102c.f37752b.getWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        for (Drawable.Callback callback : this.f37739u.keySet()) {
            if (callback != null) {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f37725g;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f37737s = true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        for (Drawable.Callback callback : this.f37739u.keySet()) {
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        m50221d().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m50221d().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        AbstractC7185ho.m43820b(m50246o(), "setVisible " + z10);
        if (!z10) {
            stop();
        } else if (!this.f37725g) {
            start();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AbstractC7185ho.m43820b(m50246o(), "start");
        this.f37725g = true;
        m50247a();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        AbstractC7185ho.m43820b(m50246o(), "stop");
        this.f37725g = false;
        m50249b();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        for (Drawable.Callback callback : this.f37739u.keySet()) {
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: c */
    private InputStream m50218c(String str) {
        try {
            return this.f37734p.getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e10) {
            AbstractC7185ho.m43823c(this.m50246o(), "oPIs " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: d */
    private InputStream m50222d(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e10) {
            AbstractC7185ho.m43823c(m50246o(), "loadFile " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m50225e() {
        AbstractC7185ho.m43820b(m50246o(), "replay " + AbstractC7819dl.m48375a(this.f37727i));
        m50210a(this.f37727i);
    }

    /* renamed from: f */
    private InputStream m50228f(String str) {
        try {
            return this.f37734p.getAssets().open(str.substring(Scheme.ASSET.toString().length()));
        } catch (IOException e10) {
            AbstractC7185ho.m43823c(this.m50246o(), "loadFile " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m50231g() {
        C8100a c8100a = this.f37733o;
        if (c8100a != null) {
            c8100a.m50201b();
            this.f37733o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public synchronized boolean m50233h() {
        return this.f37732n;
    }

    /* renamed from: i */
    private void m50235i() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (C8101b.this.f37740v != null) {
                    C8101b.this.f37740v.mo48917b();
                }
                C8101b.this.m50249b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m50237j() {
        final C8100a c8100a;
        if (m50233h() || (c8100a = this.f37733o) == null || c8100a.m50202c()) {
            return;
        }
        this.f37738t.m47518a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.4
            @Override // java.lang.Runnable
            public void run() throws InterruptedException, IOException {
                C8102c c8102c;
                C8101b c8101b;
                AbstractC7185ho.m43820b(C8101b.this.m50246o(), "fetch next");
                long jCurrentTimeMillis = System.currentTimeMillis();
                C8102c c8102cM50200a = c8100a.m50200a();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                AbstractC7185ho.m43818a(C8101b.this.m50246o(), "frame fetch - decoding duration: %d gif: %s", Long.valueOf(jCurrentTimeMillis2), c8102cM50200a);
                C8101b c8101b2 = C8101b.this;
                if (c8102cM50200a != null) {
                    boolean zM50213a = c8101b2.m50213a(c8102cM50200a, jCurrentTimeMillis2);
                    AbstractC7185ho.m43818a(C8101b.this.m50246o(), "need reduce size: %s", Boolean.valueOf(zM50213a));
                    C8102c c8102cM50251a = c8102cM50200a.m50251a();
                    c8102cM50251a.f37752b = C8101b.this.m50203a(c8102cM50200a.f37752b, zM50213a);
                    if (!C8101b.this.f37728j.offer(c8102cM50251a)) {
                        AbstractC7185ho.m43823c(C8101b.this.m50246o(), "fail to add frame to cache");
                    }
                    int i10 = c8102cM50251a.f37753c;
                    if (jCurrentTimeMillis2 <= i10) {
                        AbstractC7185ho.m43820b(C8101b.this.m50246o(), "send to render directly");
                        c8101b = C8101b.this;
                    } else {
                        int i11 = (int) ((jCurrentTimeMillis2 * 1.0d) / i10);
                        if (i11 > 5) {
                            i11 = 5;
                        }
                        AbstractC7185ho.m43818a(C8101b.this.m50246o(), "preferred cached frame num: %d", Integer.valueOf(i11));
                        int size = C8101b.this.f37728j.size();
                        c8101b = C8101b.this;
                        if (size < i11) {
                            c8101b.m50237j();
                            return;
                        }
                    }
                    c8102c = (C8102c) c8101b.f37728j.poll();
                } else {
                    c8102c = (C8102c) c8101b2.f37728j.poll();
                    if (c8102c == null) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - C8101b.this.f37735q;
                        if (jCurrentTimeMillis3 < C8101b.this.f37731m) {
                            try {
                                Thread.sleep(C8101b.this.f37731m - jCurrentTimeMillis3);
                            } catch (InterruptedException unused) {
                                AbstractC7185ho.m43817a(C8101b.this.m50246o(), "InterruptedException");
                            }
                        }
                        C8101b.this.m50239k();
                        return;
                    }
                    c8101b = C8101b.this;
                }
                c8101b.m50209a(c8102c);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m50239k() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.5
            @Override // java.lang.Runnable
            public void run() {
                C8101b.m50234i(C8101b.this);
                if (C8101b.this.f37726h == 0 || C8101b.this.f37730l < C8101b.this.f37726h) {
                    C8101b.this.m50225e();
                } else {
                    C8101b.this.m50249b();
                    C8101b.this.m50244n();
                }
            }
        });
    }

    /* renamed from: f */
    private void m50229f() {
        m50211a(false);
        this.f37730l = 0;
        this.f37728j.clear();
    }

    /* renamed from: a */
    public void m50247a() {
        if (TextUtils.isEmpty(this.f37727i)) {
            return;
        }
        AbstractC7185ho.m43820b(m50246o(), "play " + AbstractC7819dl.m48375a(this.f37727i));
        m50249b();
        m50229f();
        m50210a(this.f37727i);
    }

    /* renamed from: b */
    public void m50249b() {
        AbstractC7185ho.m43820b(m50246o(), "stop play " + AbstractC7819dl.m48375a(this.f37727i));
        AbstractC7817dj.m48366a(this.f37719a);
        m50211a(true);
        this.f37728j.clear();
        this.f37738t.m47518a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.1
            @Override // java.lang.Runnable
            public void run() {
                C8101b.this.m50231g();
            }
        });
    }

    /* renamed from: a */
    private void m50205a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            this.f37720b.setBitmap(bitmap2);
            this.f37720b.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f37722d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.f37723e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.f37720b.drawBitmap(bitmap, this.f37722d, this.f37723e, (Paint) null);
        }
    }

    /* renamed from: b */
    private void m50216b(C8102c c8102c) {
        m50220c(this.f37736r);
        this.f37736r = c8102c;
        this.f37731m = c8102c.f37753c;
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (C8101b.this.m50233h()) {
                    C8101b.this.f37736r = null;
                } else {
                    C8101b.this.invalidateSelf();
                    C8101b.this.m50237j();
                }
            }
        }, this.f37719a, 0L);
        this.f37735q = System.currentTimeMillis();
    }

    /* renamed from: c */
    private void m50220c(C8102c c8102c) {
        if (c8102c == null || this.f37729k.size() >= 2) {
            AbstractC7185ho.m43820b(m50246o(), "drop frame");
        } else {
            if (this.f37729k.contains(c8102c.f37752b) || this.f37729k.offer(c8102c.f37752b)) {
                return;
            }
            AbstractC7185ho.m43823c(m50246o(), "fail to release frame to pool");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m50217b(String str) {
        m50231g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStreamM50228f = str.startsWith(Scheme.ASSET.toString()) ? m50228f(str) : str.startsWith(Scheme.RES.toString()) ? m50224e(str) : str.startsWith(Scheme.CONTENT.toString()) ? m50218c(str) : m50222d(str);
        if (inputStreamM50228f != null) {
            try {
                this.f37733o = new C8100a(inputStreamM50228f, 100);
                m50237j();
            } catch (Exception unused) {
                AbstractC7185ho.m43823c(m50246o(), "exception in creating gif decoder");
                m50235i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50209a(C8102c c8102c) throws InterruptedException {
        if (c8102c == null) {
            AbstractC7185ho.m43820b(m50246o(), "invalid frame.");
            return;
        }
        AbstractC7185ho.m43821b(m50246o(), "onFrameDecoded index: %d isstop: %s", Integer.valueOf(c8102c.f37751a), Boolean.valueOf(m50233h()));
        if (m50233h()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f37735q;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(m50246o(), "onFrameDecoded decodeInterval: %d currentFrameDuration: %d", Long.valueOf(jCurrentTimeMillis), Integer.valueOf(this.f37731m));
        }
        if (c8102c.f37751a == 1) {
            m50240l();
        } else {
            int i10 = this.f37731m;
            if (jCurrentTimeMillis < i10) {
                try {
                    Thread.sleep(i10 - jCurrentTimeMillis);
                } catch (InterruptedException unused) {
                    AbstractC7185ho.m43817a(m50246o(), "sleep InterruptedException");
                }
            }
        }
        m50216b(c8102c);
    }

    /* renamed from: a */
    public void m50248a(InterfaceC8103d interfaceC8103d) {
        this.f37740v = interfaceC8103d;
    }

    /* renamed from: a */
    private void m50210a(final String str) {
        this.f37738t.m47518a(new Runnable() { // from class: com.huawei.openalliance.ad.views.gif.b.2
            @Override // java.lang.Runnable
            public void run() {
                C8101b.this.m50217b(str);
            }
        });
    }

    /* renamed from: a */
    private synchronized void m50211a(boolean z10) {
        this.f37732n = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m50213a(C8102c c8102c, long j10) {
        int iCeil;
        long width = c8102c.f37752b.getWidth() * c8102c.f37752b.getHeight() * (c8102c.f37752b.getConfig() == Bitmap.Config.RGB_565 ? 2 : 4);
        int i10 = c8102c.f37753c;
        if (j10 > i10) {
            iCeil = (int) Math.ceil((j10 * 1.0d) / i10);
            if (iCeil > 5) {
                iCeil = 5;
            }
        } else {
            iCeil = 1;
        }
        long jMax = width * Math.max(iCeil, this.f37728j.size());
        long jM47559b = AbstractC7741ao.m47559b();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a(m50246o(), "max frame mem: %d unused memory: %d", Long.valueOf(jMax), Long.valueOf(jM47559b));
        }
        return jMax >= jM47559b;
    }
}
