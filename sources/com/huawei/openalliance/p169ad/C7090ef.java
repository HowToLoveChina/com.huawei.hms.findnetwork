package com.huawei.openalliance.p169ad;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.huawei.openalliance.ad.ef */
/* loaded from: classes8.dex */
public class C7090ef {

    /* renamed from: a */
    private static final float[] f32634a;

    /* renamed from: b */
    private static final float[] f32635b;

    /* renamed from: c */
    private static final FloatBuffer f32636c;

    /* renamed from: d */
    private static final FloatBuffer f32637d;

    /* renamed from: e */
    private final FloatBuffer f32638e = f32636c;

    /* renamed from: f */
    private final FloatBuffer f32639f = f32637d;

    /* renamed from: g */
    private final int f32640g = 2;

    /* renamed from: h */
    private final int f32641h = f32634a.length / 2;

    static {
        float[] fArr = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        f32634a = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f32635b = fArr2;
        f32636c = m42891a(fArr);
        f32637d = m42891a(fArr2);
    }

    /* renamed from: a */
    public FloatBuffer m42892a() {
        return this.f32638e;
    }

    /* renamed from: b */
    public FloatBuffer m42893b() {
        return this.f32639f;
    }

    /* renamed from: c */
    public int m42894c() {
        return this.f32641h;
    }

    /* renamed from: d */
    public int m42895d() {
        return 8;
    }

    /* renamed from: e */
    public int m42896e() {
        return 8;
    }

    /* renamed from: f */
    public int m42897f() {
        return 2;
    }

    /* renamed from: a */
    private static FloatBuffer m42891a(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
