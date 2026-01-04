package com.huawei.openalliance.p169ad;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;

/* renamed from: com.huawei.openalliance.ad.ed */
/* loaded from: classes8.dex */
public final class C7088ed {

    /* renamed from: a */
    private EGLDisplay f32628a;

    /* renamed from: b */
    private EGLContext f32629b;

    /* renamed from: c */
    private EGLConfig f32630c;

    /* renamed from: d */
    private final int[] f32631d = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344};

    public C7088ed() {
        m42877d();
        m42876c();
        EGL14.eglQueryContext(this.f32628a, this.f32629b, 12440, new int[1], 0);
    }

    /* renamed from: c */
    private void m42876c() {
        EGLConfig eGLConfigM42878e = m42878e();
        if (eGLConfigM42878e == null) {
            throw new IllegalStateException("fail to get config");
        }
        this.f32629b = EGL14.eglCreateContext(this.f32628a, eGLConfigM42878e, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        m42875a("create context fail");
        this.f32630c = eGLConfigM42878e;
    }

    /* renamed from: d */
    private void m42877d() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f32628a = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("fail to get gl display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return;
        }
        this.f32628a = null;
        throw new IllegalStateException("fail to init gl");
    }

    /* renamed from: e */
    private EGLConfig m42878e() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f32628a, this.f32631d, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        AbstractC7185ho.m43823c("GlEngine", "fail to choose gl config");
        return null;
    }

    /* renamed from: a */
    public int m42879a(EGLSurface eGLSurface, int i10) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f32628a, eGLSurface, i10, iArr, 0);
        return iArr[0];
    }

    /* renamed from: b */
    public void m42883b() {
        EGLDisplay eGLDisplay = this.f32628a;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new IllegalStateException("set no current fail");
        }
    }

    public void finalize() throws Throwable {
        try {
            if (this.f32628a != EGL14.EGL_NO_DISPLAY) {
                m42881a();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: a */
    public EGLSurface m42880a(Surface surface) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f32628a, this.f32630c, surface, new int[]{12344}, 0);
        m42875a("create window surface fail");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new IllegalStateException("gl surface is null");
    }

    /* renamed from: b */
    public void m42884b(EGLSurface eGLSurface) {
        if (!EGL14.eglMakeCurrent(this.f32628a, eGLSurface, eGLSurface, this.f32629b)) {
            throw new IllegalStateException("set current fail");
        }
    }

    /* renamed from: c */
    public void m42885c(EGLSurface eGLSurface) {
        if (EGL14.eglSwapBuffers(this.f32628a, eGLSurface)) {
            return;
        }
        AbstractC7185ho.m43817a("GlEngine", "fail to update buffer");
    }

    /* renamed from: a */
    public void m42881a() {
        EGLDisplay eGLDisplay = this.f32628a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f32628a, this.f32629b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f32628a);
        }
        this.f32628a = EGL14.EGL_NO_DISPLAY;
        this.f32629b = EGL14.EGL_NO_CONTEXT;
        this.f32630c = null;
    }

    /* renamed from: a */
    public void m42882a(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f32628a, eGLSurface);
    }

    /* renamed from: a */
    private void m42875a(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + " err code " + Integer.toHexString(iEglGetError));
    }
}
