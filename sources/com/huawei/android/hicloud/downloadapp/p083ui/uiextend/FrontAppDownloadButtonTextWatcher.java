package com.huawei.android.hicloud.downloadapp.p083ui.uiextend;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.sync.R$string;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;

/* loaded from: classes3.dex */
public class FrontAppDownloadButtonTextWatcher implements AppDownloadButton.ButtonTextWatcher {

    /* renamed from: a */
    public Context f12149a;

    /* renamed from: b */
    public String f12150b;

    /* renamed from: com.huawei.android.hicloud.downloadapp.ui.uiextend.FrontAppDownloadButtonTextWatcher$a */
    public static /* synthetic */ class C2795a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f12151a;

        static {
            int[] iArr = new int[AppStatus.values().length];
            f12151a = iArr;
            try {
                iArr[AppStatus.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12151a[AppStatus.INSTALLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12151a[AppStatus.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public FrontAppDownloadButtonTextWatcher(Context context) {
        this.f12149a = context;
    }

    /* renamed from: a */
    public void m16254a(String str) {
        this.f12150b = str;
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.ButtonTextWatcher
    public CharSequence beforeTextChanged(CharSequence charSequence, AppStatus appStatus) {
        int i10 = C2795a.f12151a[appStatus.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? charSequence : TextUtils.isEmpty(this.f12150b) ? this.f12149a.getString(R$string.front_app_btn_downloading) : this.f12150b : this.f12149a.getString(R$string.front_app_btn_downloaded) : this.f12149a.getString(R$string.front_app_btn_before_download);
    }
}
