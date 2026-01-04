package com.huawei.openalliance.p169ad;

import android.opengl.GLES20;
import java.nio.Buffer;

/* renamed from: com.huawei.openalliance.ad.eh */
/* loaded from: classes8.dex */
public class C7092eh {

    /* renamed from: a */
    private int f32652a;

    /* renamed from: b */
    private int f32653b;

    /* renamed from: c */
    private int f32654c;

    /* renamed from: d */
    private int f32655d;

    /* renamed from: e */
    private int f32656e;

    /* renamed from: f */
    private int f32657f;

    /* renamed from: g */
    private int f32658g;

    /* renamed from: h */
    private int f32659h;

    /* renamed from: i */
    private int f32660i = 36197;

    /* renamed from: j */
    private final float[] f32661j = new float[9];

    /* renamed from: k */
    private float[] f32662k = {-0.00390625f, -0.00390625f, 0.0f, -0.00390625f, 0.00390625f, -0.00390625f, -0.00390625f, 0.0f, 0.0f, 0.0f, 0.00390625f, 0.0f, -0.00390625f, 0.00390625f, 0.0f, 0.00390625f, 0.00390625f, 0.00390625f};

    /* renamed from: l */
    private float f32663l;

    public C7092eh() {
        int iM42909c = m42909c();
        this.f32652a = iM42909c;
        if (iM42909c == 0) {
            throw new IllegalStateException("fail to create program");
        }
        m42913e();
        if (this.f32655d >= 0) {
            m42911d();
            return;
        }
        this.f32655d = -1;
        this.f32656e = -1;
        this.f32657f = -1;
    }

    /* renamed from: a */
    private static int m42904a(int i10, int i11) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        m42906a("create program");
        if (iGlCreateProgram == 0) {
            AbstractC7185ho.m43823c("TexProgram", "fail not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, i10);
        m42906a("attach shader");
        GLES20.glAttachShader(iGlCreateProgram, i11);
        m42906a("attach shader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        AbstractC7185ho.m43823c("TexProgram", "fail to link");
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* renamed from: c */
    private static int m42909c() {
        int iM42907b;
        int iM42907b2 = m42907b(35633, "uniform mat4 matrixLocation; uniform mat4 texMatrixLocation; attribute vec4 positionLocation; attribute vec4 textureCoordLocation; varying vec2 textureCoordination; void main() { gl_Position = matrixLocation * positionLocation; textureCoordination = (texMatrixLocation * textureCoordLocation).xy;}");
        if (iM42907b2 == 0 || (iM42907b = m42907b(35632, "#extension GL_OES_EGL_image_external : require\n precision mediump float; varying vec2 textureCoordination; uniform samplerExternalOES sTexture; void main() {gl_FragColor = texture2D(sTexture, textureCoordination);}")) == 0) {
            return 0;
        }
        return m42904a(iM42907b2, iM42907b);
    }

    /* renamed from: d */
    private void m42911d() {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f32652a, "textureOffsetLocation");
        this.f32656e = iGlGetUniformLocation;
        m42905a(iGlGetUniformLocation, "textureOffsetLocation");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f32652a, "colorAdjustLocation");
        this.f32657f = iGlGetUniformLocation2;
        m42905a(iGlGetUniformLocation2, "colorAdjustLocation");
        System.arraycopy(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0, this.f32661j, 0, 9);
        this.f32663l = 0.0f;
    }

    /* renamed from: e */
    private void m42913e() {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f32652a, "positionLocation");
        this.f32658g = iGlGetAttribLocation;
        m42905a(iGlGetAttribLocation, "positionLocation");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.f32652a, "textureCoordLocation");
        this.f32659h = iGlGetAttribLocation2;
        m42905a(iGlGetAttribLocation2, "textureCoordLocation");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f32652a, "matrixLocation");
        this.f32653b = iGlGetUniformLocation;
        m42905a(iGlGetUniformLocation, "matrixLocation");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f32652a, "texMatrixLocation");
        this.f32654c = iGlGetUniformLocation2;
        m42905a(iGlGetUniformLocation2, "texMatrixLocation");
        this.f32655d = GLES20.glGetUniformLocation(this.f32652a, "coreLocation");
    }

    /* renamed from: f */
    private void m42914f() {
        int i10 = this.f32655d;
        if (i10 >= 0) {
            GLES20.glUniform1fv(i10, 9, this.f32661j, 0);
            GLES20.glUniform2fv(this.f32656e, 9, this.f32662k, 0);
            GLES20.glUniform1f(this.f32657f, this.f32663l);
        }
    }

    /* renamed from: b */
    public int m42917b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        m42906a("fail to generate texture");
        int i10 = iArr[0];
        GLES20.glBindTexture(this.f32660i, i10);
        m42906a("fail to bind texture ");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        m42906a("fail to create texture");
        return i10;
    }

    /* renamed from: b */
    private static int m42907b(int i10, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        m42906a("create shader " + i10);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        AbstractC7185ho.m43823c("TexProgram", "fail to compile shader: " + i10 + " " + GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: c */
    private void m42910c(C7093ei c7093ei) {
        GLES20.glEnableVertexAttribArray(this.f32658g);
        m42906a("rv - 1");
        GLES20.glVertexAttribPointer(this.f32658g, c7093ei.m42922e(), 5126, false, c7093ei.m42923f(), (Buffer) c7093ei.m42919b());
        m42906a("rv - 2");
        GLES20.glEnableVertexAttribArray(this.f32659h);
        m42906a("rv - 3");
        GLES20.glVertexAttribPointer(this.f32659h, 2, 5126, false, c7093ei.m42927j(), (Buffer) c7093ei.m42925h());
        m42906a("rv - 4");
    }

    /* renamed from: d */
    private void m42912d(C7093ei c7093ei) {
        GLES20.glDrawArrays(5, c7093ei.m42920c(), c7093ei.m42921d());
        m42906a("pr4 - 1");
        GLES20.glDisableVertexAttribArray(this.f32658g);
        GLES20.glDisableVertexAttribArray(this.f32659h);
        GLES20.glBindTexture(this.f32660i, 0);
        GLES20.glUseProgram(0);
    }

    /* renamed from: a */
    public void m42915a() {
        try {
            GLES20.glDeleteProgram(this.f32652a);
            this.f32652a = -1;
        } catch (Throwable th2) {
            AbstractC7185ho.m43813a(5, "TexProgram", "release", th2);
        }
    }

    /* renamed from: a */
    public static void m42905a(int i10, String str) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalStateException("program fail to find " + str);
    }

    /* renamed from: b */
    private void m42908b(C7093ei c7093ei) {
        GLES20.glUseProgram(this.f32652a);
        m42906a("rtm - 1");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f32660i, c7093ei.m42926i());
        GLES20.glUniformMatrix4fv(this.f32653b, 1, false, c7093ei.m42918a(), 0);
        m42906a("rtm - 2");
        GLES20.glUniformMatrix4fv(this.f32654c, 1, false, c7093ei.m42924g(), 0);
        m42906a("rtm - 3");
    }

    /* renamed from: a */
    public void m42916a(C7093ei c7093ei) {
        m42906a("render - 1");
        m42908b(c7093ei);
        m42910c(c7093ei);
        m42914f();
        m42912d(c7093ei);
    }

    /* renamed from: a */
    public static void m42906a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + " error: " + Integer.toHexString(iGlGetError);
        AbstractC7185ho.m43823c("TexProgram", str2);
        throw new IllegalStateException(str2);
    }
}
