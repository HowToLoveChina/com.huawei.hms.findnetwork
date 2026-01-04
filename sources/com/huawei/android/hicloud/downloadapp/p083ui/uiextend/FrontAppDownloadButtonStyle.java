package com.huawei.android.hicloud.downloadapp.p083ui.uiextend;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import com.huawei.hicloud.sync.R$color;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.PPSHwRoundRectEclipseClipDrawable;
import java.util.Locale;

/* loaded from: classes3.dex */
public class FrontAppDownloadButtonStyle extends AppDownloadButtonStyle {
    public FrontAppDownloadButtonStyle(Context context) throws Resources.NotFoundException {
        super(context);
        m16251f(context);
        m16253h(context);
        m16250e(context);
    }

    /* renamed from: e */
    public final void m16250e(Context context) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(R$drawable.front_app_download_button, null);
        drawable.setAlpha(102);
        this.installingStyle.setBackground(drawable);
        this.installingStyle.setTextColor(context.getResources().getColor(R$color.marketing_FFFFFF, null));
        this.installingStyle.setTextSize(context.getResources().getDimensionPixelSize(R$dimen.cloud_space_14_sp));
    }

    /* renamed from: f */
    public final void m16251f(Context context) {
        this.normalStyle.setBackground(context.getResources().getDrawable(R$drawable.front_app_download_button, null));
        this.normalStyle.setTextColor(context.getResources().getColor(R$color.marketing_FFFFFF, null));
        this.normalStyle.setTextSize(context.getResources().getDimensionPixelSize(R$dimen.cloud_space_14_sp));
    }

    /* renamed from: g */
    public final Drawable m16252g(Context context, int i10) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i10, null);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            drawable.setLayoutDirection(1);
        }
        return drawable;
    }

    @Override // com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle
    public AppDownloadButtonStyle.Style getStyle(Context context, AppStatus appStatus) {
        return AppStatus.INSTALLING.equals(appStatus) ? this.installingStyle : (AppStatus.PAUSE.equals(appStatus) || AppStatus.DOWNLOADING.equals(appStatus)) ? this.processingStyle : this.normalStyle;
    }

    /* renamed from: h */
    public final void m16253h(Context context) {
        int i10 = R$drawable.app_dl_btn_processing_bg_hm;
        if (m16252g(context, i10) instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) m16252g(context, i10);
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
            if (drawableFindDrawableByLayerId instanceof ClipDrawable) {
                PPSHwRoundRectEclipseClipDrawable pPSHwRoundRectEclipseClipDrawable = new PPSHwRoundRectEclipseClipDrawable(drawableFindDrawableByLayerId, 17, 1);
                layerDrawable.mutate();
                layerDrawable.setDrawableByLayerId(R.id.progress, pPSHwRoundRectEclipseClipDrawable);
                this.processingStyle.setBackground(layerDrawable);
            }
        }
    }
}
