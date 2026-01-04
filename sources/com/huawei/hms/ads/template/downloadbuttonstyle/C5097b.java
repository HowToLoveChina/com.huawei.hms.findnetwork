package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyleHm;

/* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.b */
/* loaded from: classes8.dex */
public class C5097b extends AbstractC5096a {

    /* renamed from: d */
    protected int f23287d;

    /* renamed from: e */
    protected int f23288e;

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.b$a */
    public static class a extends ExtandAppDownloadButtonStyleHm {
        public a(Context context, int i10) {
            super(context);
            Resources resources = context.getResources();
            AppDownloadButtonStyle.Style style = this.normalStyle;
            int i11 = C6849R.drawable.hiad_native_tpt_list_page_btn_night;
            style.setBackground(resources.getDrawable(i11));
            this.normalStyle.setTextSize(i10);
            this.normalStyle.setTextColor(resources.getColor(C6849R.color.hiad_down_btn_normal_night));
            this.processingStyle.setBackground(resources.getDrawable(i11));
            this.processingStyle.setTextSize(i10);
            this.processingStyle.setTextColor(resources.getColor(C6849R.color.hiad_down_btn_process_night));
            this.installingStyle.setBackground(resources.getDrawable(i11));
            this.installingStyle.setTextSize(i10);
            this.installingStyle.setTextColor(resources.getColor(C6849R.color.hiad_down_btn_installing_night));
            this.cancelBtnDrawable = resources.getDrawable(C6849R.drawable.hiad_app_down_cancel_btn_dark);
        }
    }

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.b$b */
    public static class b extends ExtandAppDownloadButtonStyleHm {
        public b(Context context, int i10) {
            super(context);
            Resources resources = context.getResources();
            AppDownloadButtonStyle.Style style = this.normalStyle;
            int i11 = C6849R.drawable.hiad_native_tpt_list_page_btn;
            style.setBackground(resources.getDrawable(i11));
            this.normalStyle.setTextSize(i10);
            this.normalStyle.setTextColor(resources.getColor(C6849R.color.hiad_down_btn_normal));
            this.processingStyle.setBackground(resources.getDrawable(i11));
            this.processingStyle.setTextSize(i10);
            this.processingStyle.setTextColor(resources.getColor(C6849R.color.hiad_down_btn_process));
            this.installingStyle.setBackground(resources.getDrawable(i11));
            this.installingStyle.setTextSize(i10);
            this.installingStyle.setTextColor(resources.getColor(C6849R.color.hiad_down_btn_installing));
        }
    }

    public C5097b(Context context, AppDownloadButton appDownloadButton) {
        super(context, appDownloadButton);
        this.f23287d = (int) context.getResources().getDimension(C6849R.dimen.hiad_12_dp);
        this.f23288e = (int) context.getResources().getDimension(C6849R.dimen.hiad_6_dp);
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a
    /* renamed from: a */
    public void mo30450a() {
        AppDownloadButton appDownloadButton = this.f23283c.get();
        if (appDownloadButton == null) {
            AbstractC7185ho.m43820b("DefaultDwnButtonStyle", "btn is null");
        } else {
            appDownloadButton.setAppDownloadButtonStyle(1 == this.f23282b ? new a(this.f23281a, this.f23287d) : new b(this.f23281a, this.f23287d));
        }
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a
    /* renamed from: b */
    public void mo30453b(Context context) {
        AppDownloadButton appDownloadButton = this.f23283c.get();
        if (appDownloadButton == null) {
            AbstractC7185ho.m43820b("DefaultDwnButtonStyle", "btn is null");
            return;
        }
        appDownloadButton.setMinWidth((int) context.getResources().getDimension(C6849R.dimen.hiad_64_dp));
        appDownloadButton.setPadding(0, 0, 0, this.f23288e);
        appDownloadButton.setMaxWidth((int) context.getResources().getDimension(C6849R.dimen.hiad_144_dp));
        appDownloadButton.setFontFamily("HwChinese-medium");
        appDownloadButton.setTextSize(this.f23287d);
        appDownloadButton.setVisibility(0);
        appDownloadButton.updateLayoutHeight();
        appDownloadButton.refreshStatusAsync(null);
        appDownloadButton.setVisibility(0);
    }
}
