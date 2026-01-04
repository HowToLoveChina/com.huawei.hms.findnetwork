package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyleHm;

/* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.d */
/* loaded from: classes8.dex */
public class C5099d extends AbstractC5096a {

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.d$a */
    public static class a extends ExtandAppDownloadButtonStyleHm {
        public a(Context context) {
            super(context);
            Resources resources = context.getResources();
            this.normalStyle.setBackground(resources.getDrawable(C6849R.drawable.hiad_app_down_btn_normal_night));
            this.normalStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_down_normal_text_night));
            this.processingStyle.setBackground(resources.getDrawable(C6849R.drawable.hiad_app_down_btn_processing_night));
            this.processingStyle.setTextColor(resources.getColor(C6849R.color.hiad_app_down_processing_text_night));
            this.installingStyle.setBackground(resources.getDrawable(C6849R.drawable.hiad_app_down_btn_installing_night));
            this.installingStyle.setTextColor(resources.getColor(C6849R.color.hiad_app_down_installing_text));
            this.cancelBtnDrawable = resources.getDrawable(C6849R.drawable.hiad_app_down_cancel_btn_dark);
        }
    }

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.d$b */
    public static class b extends ExtandAppDownloadButtonStyleHm {
        public b(Context context) {
            super(context);
            Resources resources = context.getResources();
            this.normalStyle.setBackground(resources.getDrawable(C6849R.drawable.hiad_app_down_btn_normal));
            this.normalStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_down_normal_text));
            this.processingStyle.setBackground(resources.getDrawable(C6849R.drawable.hiad_app_down_btn_processing));
            this.processingStyle.setTextColor(resources.getColor(C6849R.color.hiad_app_down_processing_text));
            this.installingStyle.setBackground(resources.getDrawable(C6849R.drawable.hiad_app_down_btn_installing));
            this.installingStyle.setTextColor(resources.getColor(C6849R.color.hiad_app_down_installing_text));
        }
    }

    public C5099d(Context context, AppDownloadButton appDownloadButton) {
        super(context, appDownloadButton);
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a
    /* renamed from: a */
    public void mo30450a() {
        AppDownloadButton appDownloadButton = this.f23283c.get();
        if (appDownloadButton == null) {
            AbstractC7185ho.m43820b("IconDwnButtonStyle", "btn is null");
        } else {
            appDownloadButton.setAppDownloadButtonStyle(1 == this.f23282b ? new a(this.f23281a) : new b(this.f23281a));
        }
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a
    /* renamed from: b */
    public void mo30453b(Context context) {
        AppDownloadButton appDownloadButton = this.f23283c.get();
        if (appDownloadButton == null) {
            AbstractC7185ho.m43820b("IconDwnButtonStyle", "btn is null");
            return;
        }
        Resources resources = context.getResources();
        int i10 = C6849R.dimen.hiad_56_dp;
        appDownloadButton.setMinWidth((int) resources.getDimension(i10));
        appDownloadButton.setMaxWidth((int) context.getResources().getDimension(i10));
        appDownloadButton.setFixedWidth(false);
        int dimension = (int) context.getResources().getDimension(C6849R.dimen.hiad_8_dp);
        appDownloadButton.setPadding(dimension, dimension, dimension, dimension);
        appDownloadButton.setFontFamily("HwChinese-medium");
        appDownloadButton.setTextSize((int) context.getResources().getDimension(C6849R.dimen.hiad_12_dp));
        appDownloadButton.updateLayoutHeight();
        appDownloadButton.refreshStatusAsync(null);
        appDownloadButton.setVisibility(0);
    }
}
