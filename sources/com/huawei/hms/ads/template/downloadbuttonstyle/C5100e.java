package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.ExtandAppDownloadButtonStyleHm;

/* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.e */
/* loaded from: classes8.dex */
public class C5100e extends AbstractC5096a {

    /* renamed from: d */
    private RemoteButtonStyleAttr f23289d;

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.e$a */
    public static class a extends ExtandAppDownloadButtonStyleHm {
        public a(Context context, RemoteButtonStyleAttr remoteButtonStyleAttr) {
            super(context);
            this.normalStyle.setBackground(remoteButtonStyleAttr.m30427h());
            this.normalStyle.setTextSize((int) remoteButtonStyleAttr.m30443u());
            this.normalStyle.setTextColor(remoteButtonStyleAttr.m30433k());
            this.processingStyle.setBackground(C7818dk.m48368a(remoteButtonStyleAttr.m30434l()));
            this.processingStyle.setTextSize((int) remoteButtonStyleAttr.m30443u());
            this.processingStyle.setTextColor(remoteButtonStyleAttr.m30435m());
            this.installingStyle.setBackground(remoteButtonStyleAttr.m30436n());
            this.installingStyle.setTextSize((int) remoteButtonStyleAttr.m30443u());
            this.installingStyle.setTextColor(remoteButtonStyleAttr.m30437o());
            this.cancelBtnStyle.setBackground(remoteButtonStyleAttr.m30431j());
            this.cancelBtnDrawable = remoteButtonStyleAttr.m30438p() == null ? context.getResources().getDrawable(C6849R.drawable.hiad_app_down_cancel_btn_dark) : remoteButtonStyleAttr.m30438p();
        }
    }

    /* renamed from: com.huawei.hms.ads.template.downloadbuttonstyle.e$b */
    public static class b extends ExtandAppDownloadButtonStyleHm {
        public b(Context context, RemoteButtonStyleAttr remoteButtonStyleAttr) {
            super(context);
            this.normalStyle.setBackground(remoteButtonStyleAttr.m30406a());
            this.normalStyle.setTextSize((int) remoteButtonStyleAttr.m30443u());
            this.normalStyle.setTextColor(remoteButtonStyleAttr.m30410b());
            this.processingStyle.setBackground(C7818dk.m48368a(remoteButtonStyleAttr.m30413c()));
            this.processingStyle.setTextSize((int) remoteButtonStyleAttr.m30443u());
            this.processingStyle.setTextColor(remoteButtonStyleAttr.m30416d());
            this.installingStyle.setBackground(remoteButtonStyleAttr.m30419e());
            this.installingStyle.setTextSize((int) remoteButtonStyleAttr.m30443u());
            this.installingStyle.setTextColor(remoteButtonStyleAttr.m30422f());
            this.cancelBtnStyle.setBackground(remoteButtonStyleAttr.m30429i());
            this.cancelBtnDrawable = remoteButtonStyleAttr.m30425g() == null ? context.getResources().getDrawable(C6849R.drawable.hiad_app_down_cancel_btn) : remoteButtonStyleAttr.m30425g();
        }
    }

    public C5100e(Context context, AppDownloadButton appDownloadButton, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        super(context, appDownloadButton);
        this.f23289d = remoteButtonStyleAttr;
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a
    /* renamed from: a */
    public void mo30450a() {
        AppDownloadButton appDownloadButton = this.f23283c.get();
        if (appDownloadButton == null) {
            AbstractC7185ho.m43820b("RemoteButtonStyle", "btn is null");
            return;
        }
        boolean zM30454a = m30454a(this.f23281a.getResources().getConfiguration().uiMode);
        boolean zM48340p = AbstractC7811dd.m48340p(this.f23281a);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("RemoteButtonStyle", "mediaUiMode %s, emui9DarkMode %s, isNight %s", Integer.valueOf(this.f23282b), Boolean.valueOf(zM48340p), Boolean.valueOf(zM30454a));
        }
        appDownloadButton.setAppDownloadButtonStyle((zM30454a || 1 == this.f23282b || zM48340p) ? new a(this.f23281a, this.f23289d) : new b(this.f23281a, this.f23289d));
    }

    @Override // com.huawei.hms.ads.template.downloadbuttonstyle.AbstractC5096a
    /* renamed from: b */
    public void mo30453b(Context context) {
        AppDownloadButton appDownloadButton = this.f23283c.get();
        if (appDownloadButton == null) {
            AbstractC7185ho.m43820b("RemoteButtonStyle", "btn is null");
            return;
        }
        if (this.f23289d.m30442t() != -111111) {
            appDownloadButton.setMinWidth(this.f23289d.m30442t());
        }
        if (this.f23289d.m30441s() != -111111) {
            appDownloadButton.setMaxWidth(this.f23289d.m30441s());
        }
        appDownloadButton.setPaddingRelative(this.f23289d.m30445w(), this.f23289d.m30447y(), this.f23289d.m30446x(), this.f23289d.m30448z());
        appDownloadButton.setResetWidth(this.f23289d.m30440r());
        appDownloadButton.setFixedWidth(this.f23289d.m30439q());
        appDownloadButton.setFontFamily(this.f23289d.m30444v());
        appDownloadButton.setTextSize(this.f23289d.m30443u());
        appDownloadButton.updateLayoutHeight();
        appDownloadButton.setVisibility(0);
        appDownloadButton.updateLayoutHeight();
        appDownloadButton.refreshStatusAsync(null);
        appDownloadButton.setVisibility(0);
    }

    /* renamed from: a */
    private boolean m30454a(int i10) {
        return (i10 & 48) == 32;
    }
}
