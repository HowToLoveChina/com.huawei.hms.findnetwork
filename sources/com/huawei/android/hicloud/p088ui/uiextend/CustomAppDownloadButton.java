package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import p020ap.C1009d;

/* loaded from: classes3.dex */
public class CustomAppDownloadButton extends AppDownloadButton {
    public CustomAppDownloadButton(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.AppDownloadButton, com.huawei.openalliance.p169ad.views.AbstractViewOnClickListenerC8065a, android.view.View.OnClickListener
    public void onClick(View view) {
        C1009d.m6109e().m6120l(getStatus());
        super.onClick(view);
    }

    public CustomAppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomAppDownloadButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public CustomAppDownloadButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
