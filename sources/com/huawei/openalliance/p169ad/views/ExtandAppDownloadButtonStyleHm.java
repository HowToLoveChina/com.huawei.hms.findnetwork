package com.huawei.openalliance.p169ad.views;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;

@OuterVisible
/* loaded from: classes2.dex */
public class ExtandAppDownloadButtonStyleHm extends AppDownloadButtonStyle {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23, types: [android.graphics.drawable.Drawable] */
    @OuterVisible
    public ExtandAppDownloadButtonStyleHm(Context context) {
        AppDownloadButtonStyle.Style style;
        LayerDrawable layerDrawableM48372b;
        super(context);
        boolean zM47592n = AbstractC7741ao.m47592n(context);
        this.normalStyle.setBackground(context.getResources().getDrawable(zM47592n ? C6849R.drawable.hiad_extand_landing_app_down_btn_normal_hm_elderly : C6849R.drawable.hiad_extand_landing_app_down_btn_normal_hm));
        AppDownloadButtonStyle.Style style2 = this.normalStyle;
        Resources resources = context.getResources();
        int i10 = C6849R.color.hiad_down_btn_white;
        style2.setTextColor(resources.getColor(i10));
        LayerDrawable layerDrawable = (LayerDrawable) C7818dk.m48372b(context, zM47592n ? C6849R.drawable.hiad_extand_app_down_btn_processing_hm_elderly : C6849R.drawable.hiad_extand_app_down_btn_processing_hm);
        Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.progress);
        if (drawableFindDrawableByLayerId instanceof ClipDrawable) {
            PPSHwRoundRectEclipseClipDrawable pPSHwRoundRectEclipseClipDrawable = new PPSHwRoundRectEclipseClipDrawable(drawableFindDrawableByLayerId, 17, 1);
            layerDrawable.mutate();
            layerDrawable.setDrawableByLayerId(R.id.progress, pPSHwRoundRectEclipseClipDrawable);
            layerDrawableM48372b = layerDrawable;
            style = this.processingStyle;
        } else {
            AbstractC7185ho.m43823c("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            int i11 = zM47592n ? C6849R.drawable.hiad_extand_app_down_btn_processing_elderly : C6849R.drawable.hiad_extand_app_down_btn_processing;
            AppDownloadButtonStyle.Style style3 = this.processingStyle;
            layerDrawableM48372b = C7818dk.m48372b(context, i11);
            style = style3;
        }
        style.setBackground(layerDrawableM48372b);
        this.processingStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_black));
        LayerDrawable layerDrawable2 = (LayerDrawable) C7818dk.m48372b(context, zM47592n ? C6849R.drawable.hiad_extand_app_down_btn_installing_hm_elderly : C6849R.drawable.hiad_extand_app_down_btn_installing_hm);
        if (layerDrawable2.findDrawableByLayerId(R.id.progress) instanceof ClipDrawable) {
            PPSFlickerDrawable pPSFlickerDrawable = new PPSFlickerDrawable(AbstractC7741ao.m47535a(context, zM47592n ? 20 : 18));
            layerDrawable2.mutate();
            layerDrawable2.setDrawableByLayerId(R.id.progress, pPSFlickerDrawable);
            this.installingStyle.setBackground(layerDrawable2);
            pPSFlickerDrawable.m49051a();
        } else {
            AbstractC7185ho.m43823c("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.installingStyle.setBackground(C7818dk.m48372b(context, zM47592n ? C6849R.drawable.hiad_extand_app_down_btn_installing_elderly : C6849R.drawable.hiad_extand_app_down_btn_installing));
        }
        this.installingStyle.setTextColor(context.getResources().getColor(i10));
        this.f36313a.setBackground(context.getResources().getDrawable(zM47592n ? C6849R.drawable.hiad_linked_app_down_btn_installing_elderly : C6849R.drawable.hiad_linked_app_down_btn_installing));
        this.f36313a.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_white));
    }
}
