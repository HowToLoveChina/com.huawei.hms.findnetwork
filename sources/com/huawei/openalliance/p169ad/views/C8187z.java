package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7519nn;
import com.huawei.openalliance.p169ad.InterfaceC7535oc;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaPlayerReleaseListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8122o;

/* renamed from: com.huawei.openalliance.ad.views.z */
/* loaded from: classes2.dex */
public class C8187z extends PlacementMediaView implements InterfaceC8122o {

    /* renamed from: g */
    private ImageView f38412g;

    /* renamed from: h */
    private PlacementMediaFile f38413h;

    /* renamed from: i */
    private InterfaceC7535oc f38414i;

    /* renamed from: j */
    private MuteListener f38415j;

    public C8187z(Context context) {
        super(context);
        m50721a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49803a() {
        this.f38412g.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49814b() {
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: c */
    public void mo49821c() {
        MuteListener muteListener = this.f38415j;
        if (muteListener != null) {
            muteListener.onMute();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: d */
    public void mo49823d() {
        MuteListener muteListener = this.f38415j;
        if (muteListener != null) {
            muteListener.onUnmute();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f38412g.setImageDrawable(null);
        super.destroyView();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        return this.f38412g;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public MediaState getMediaState() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8123p
    public VideoView getVideoView() {
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public void setPlacementAd(IPlacementAd iPlacementAd) {
        super.setPlacementAd(iPlacementAd);
        AbstractC7185ho.m43817a("PlacementImageView", "setPlacementAd");
        C7304g c7304g = ((PlacementMediaView) this).f37258a;
        if (c7304g != null) {
            PlacementMediaFile mediaFile = c7304g.getMediaFile();
            this.f38413h = mediaFile;
            if (mediaFile.isVideo()) {
                return;
            }
            this.f38414i.mo46165a(((PlacementMediaView) this).f37258a);
            ((PlacementMediaView) this).f37259b = this.f38413h.m44549b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49804a(int i10) {
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49819b(MuteListener muteListener) {
        this.f38415j = null;
    }

    /* renamed from: a */
    private void m50721a(Context context) {
        this.f38414i = new C7519nn(getContext(), this);
        this.f38412g = new ImageView(context);
        addView(this.f38412g, new RelativeLayout.LayoutParams(-1, -1));
        this.f38412g.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8122o
    /* renamed from: a */
    public void mo50321a(PlacementMediaFile placementMediaFile, Drawable drawable) {
        ((PlacementMediaView) this).f37261d = true;
        if (placementMediaFile == null || drawable == null) {
            ((PlacementMediaView) this).f37262e = false;
        } else if (this.f38413h != null && TextUtils.equals(placementMediaFile.getUrl(), this.f38413h.getUrl())) {
            ((PlacementMediaView) this).f37262e = true;
            this.f38412g.setImageDrawable(drawable);
        }
        if (this.f37263f) {
            mo49813a(true, true);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49808a(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49809a(MuteListener muteListener) {
        this.f38415j = muteListener;
    }
}
