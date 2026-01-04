package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.C7818dk;

@OuterVisible
/* loaded from: classes2.dex */
public class AppDownloadButtonStyle {

    /* renamed from: b */
    private Context f36314b;

    @OuterVisible
    protected Drawable cancelBtnDrawable;

    @OuterVisible
    protected Style normalStyle = new Style();

    @OuterVisible
    protected Style processingStyle = new Style();

    /* renamed from: a */
    protected Style f36313a = new Style();

    @OuterVisible
    protected Style cancelBtnStyle = new Style();

    @OuterVisible
    protected Style installingStyle = new Style();

    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButtonStyle$1 */
    public static /* synthetic */ class C78821 {

        /* renamed from: a */
        static final /* synthetic */ int[] f36315a;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f36315a = iArr;
            try {
                iArr[AppStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36315a[AppStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36315a[AppStatus.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36315a[AppStatus.WAITING_FOR_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36315a[AppStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36315a[AppStatus.DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36315a[AppStatus.INSTALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @OuterVisible
    public static class Style {

        @OuterVisible
        protected Drawable background;

        @OuterVisible
        protected int textColor;

        @OuterVisible
        protected int textSize = 12;

        @OuterVisible
        public Drawable getBackground() {
            return this.background;
        }

        @OuterVisible
        public int getTextColor() {
            return this.textColor;
        }

        @OuterVisible
        public int getTextSize() {
            return this.textSize;
        }

        @OuterVisible
        public void setBackground(Drawable drawable) {
            this.background = drawable;
        }

        @OuterVisible
        public void setTextColor(int i10) {
            this.textColor = i10;
        }

        @OuterVisible
        public void setTextSize(int i10) {
            this.textSize = i10;
        }
    }

    @OuterVisible
    public AppDownloadButtonStyle() {
    }

    /* renamed from: a */
    public Style m48716a() {
        return this.normalStyle;
    }

    /* renamed from: b */
    public Style m48718b() {
        return this.cancelBtnStyle;
    }

    /* renamed from: c */
    public Style m48719c() {
        return this.f36313a;
    }

    /* renamed from: d */
    public int m48720d() {
        return AbstractC7741ao.m47592n(this.f36314b) ? 28 : 18;
    }

    @OuterVisible
    public Drawable getCancelBtnDrawable() {
        return this.cancelBtnDrawable;
    }

    @OuterVisible
    public Style getStyle(Context context, AppStatus appStatus) {
        if (appStatus == null) {
            return m48716a();
        }
        int i10 = C78821.f36315a[appStatus.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3) {
                return this.installingStyle;
            }
            if (i10 != 4) {
                return m48716a();
            }
        }
        return this.processingStyle;
    }

    @OuterVisible
    public void setCancelBtnDrawable(Drawable drawable) {
        this.cancelBtnDrawable = drawable;
    }

    @OuterVisible
    public AppDownloadButtonStyle(Context context) {
        this.f36314b = context;
        this.normalStyle.background = context.getResources().getDrawable(C6849R.drawable.hiad_app_down_btn_normal);
        this.normalStyle.textColor = context.getResources().getColor(C6849R.color.hiad_down_normal_text);
        this.processingStyle.setBackground(C7818dk.m48372b(context, C6849R.drawable.hiad_app_down_btn_processing));
        this.processingStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_app_down_processing_text));
        this.installingStyle.setBackground(context.getResources().getDrawable(C6849R.drawable.hiad_app_down_btn_installing));
        this.installingStyle.setTextColor(context.getResources().getColor(C6849R.color.hiad_app_down_installing_text));
        this.f36313a.setBackground(context.getResources().getDrawable(C6849R.drawable.hiad_linked_app_down_btn_installing));
        this.f36313a.setTextColor(context.getResources().getColor(C6849R.color.hiad_emui_white));
        this.cancelBtnDrawable = context.getResources().getDrawable(C6849R.drawable.hiad_app_down_cancel_btn);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.openalliance.ad.views.AppDownloadButtonStyle.Style m48717a(android.content.Context r2, com.huawei.openalliance.p169ad.download.app.AppStatus r3, int r4) {
        /*
            r1 = this;
            if (r3 != 0) goto L7
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r1 = r1.m48716a()
            return r1
        L7:
            r0 = 11
            if (r4 != r0) goto L27
            int[] r4 = com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle.C78821.f36315a
            int r0 = r3.ordinal()
            r4 = r4[r0]
            r0 = 1
            if (r4 == r0) goto L22
            r0 = 2
            if (r4 == r0) goto L22
            r0 = 3
            if (r4 == r0) goto L1d
            goto L27
        L1d:
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r4 = r1.m48719c()
            goto L28
        L22:
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r4 = r1.m48716a()
            goto L28
        L27:
            r4 = 0
        L28:
            if (r4 != 0) goto L2e
            com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style r4 = r1.getStyle(r2, r3)
        L2e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle.m48717a(android.content.Context, com.huawei.openalliance.ad.download.app.AppStatus, int):com.huawei.openalliance.ad.views.AppDownloadButtonStyle$Style");
    }
}
