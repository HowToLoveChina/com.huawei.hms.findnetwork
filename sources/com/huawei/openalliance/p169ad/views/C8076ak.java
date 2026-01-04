package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;

/* renamed from: com.huawei.openalliance.ad.views.ak */
/* loaded from: classes2.dex */
public class C8076ak extends AbstractC8078b {

    /* renamed from: A */
    private boolean f37519A;

    /* renamed from: B */
    private Surface f37520B;

    /* renamed from: y */
    private final int f37521y;

    /* renamed from: z */
    private SurfaceTexture f37522z;

    public C8076ak(Context context) {
        super(context);
        this.f37521y = hashCode();
        this.f37519A = false;
    }

    /* renamed from: k */
    private void m50001k() {
        Surface surface = this.f37520B;
        if (surface != null) {
            surface.release();
            this.f37520B = null;
        }
        SurfaceTexture surfaceTexture = this.f37522z;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f37522z = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView
    /* renamed from: a */
    public void mo48786a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_view_video, this);
        TextureView textureView = (TextureView) findViewById(C6849R.id.hiad_id_video_texture_view);
        this.f36360k = textureView;
        textureView.setSurfaceTextureListener(this);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8078b
    public String getLogTag() {
        return "TextureGlVideoView" + this.f37521y;
    }

    /* renamed from: j */
    public boolean m50002j() {
        return this.f37519A;
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43820b(getLogTag(), "onAttachedToWindow");
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b(getLogTag(), "onDetachedFromWindow");
        m50001k();
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        this.f37519A = true;
        m50001k();
        this.f37522z = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.f37520B = surface;
        m50081a(surface);
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f37519A = false;
        m50001k();
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        m50083b(i10, i11);
    }
}
