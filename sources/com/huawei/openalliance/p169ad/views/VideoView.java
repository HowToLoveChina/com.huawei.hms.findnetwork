package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.views.BaseVideoView;

@OuterVisible
/* loaded from: classes2.dex */
public class VideoView extends BaseVideoView {

    /* renamed from: a */
    private static final String f37451a = "VideoView";

    @OuterVisible
    public VideoView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView
    /* renamed from: a */
    public void mo48786a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_view_video, this);
        TextureView textureView = (TextureView) findViewById(C6849R.id.hiad_id_video_texture_view);
        this.f36360k = textureView;
        textureView.setSurfaceTextureListener(this);
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView
    /* renamed from: d */
    public void mo48790d() {
        super.mo48790d();
        Surface surface = this.f36365p;
        if (surface != null) {
            surface.release();
        }
        this.f36365p = null;
        this.f36366q = null;
    }

    public Bitmap getSurfaceBitmap() {
        return this.f36360k.getBitmap();
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m48791f();
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        String str = f37451a;
        AbstractC7185ho.m43821b(str, "onSurfaceTextureAvailable width: %d height: %d", Integer.valueOf(i10), Integer.valueOf(i11));
        this.f36362m = true;
        Surface surface = this.f36365p;
        if (surface == null || this.f36366q != surfaceTexture) {
            if (surface != null) {
                AbstractC7185ho.m43820b(str, "release old surface when onSurfaceTextureAvailable");
                this.f36365p.release();
            }
            if (this.f36366q != null) {
                AbstractC7185ho.m43820b(str, "release old SurfaceTexture when onSurfaceTextureAvailable");
                this.f36366q.release();
            }
            Surface surface2 = new Surface(surfaceTexture);
            this.f36365p = surface2;
            this.f36363n.setSurface(surface2);
            this.f36366q = surfaceTexture;
        }
        if (this.f36370u == null) {
            BaseVideoView.C7898h c7898h = new BaseVideoView.C7898h(this.f36373x);
            this.f36370u = c7898h;
            this.f36363n.setVideoSizeChangeListener(c7898h);
        }
        if (this.f36361l) {
            play(this.f36367r);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        String str = f37451a;
        AbstractC7185ho.m43820b(str, "onSurfaceTextureDestroyed");
        this.f36362m = false;
        if (this.f36369t) {
            pause();
        }
        m48792g();
        if (this.f36365p != null) {
            AbstractC7185ho.m43820b(str, "release old surface when onSurfaceTextureDestroyed");
            this.f36365p.release();
            this.f36365p = null;
        }
        if (this.f36366q == null) {
            return true;
        }
        AbstractC7185ho.m43820b(str, "release old surfaceTexture when onSurfaceTextureDestroyed");
        this.f36366q.release();
        this.f36366q = null;
        return true;
    }

    @OuterVisible
    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @OuterVisible
    public VideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
