package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.views.af */
/* loaded from: classes2.dex */
public class C8071af extends RelativeLayout {

    /* renamed from: a */
    private AutoScaleSizeRelativeLayout f37500a;

    /* renamed from: b */
    private CornerImageView f37501b;

    public C8071af(Context context) {
        super(context);
        m49994a(context);
    }

    /* renamed from: a */
    private void m49994a(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(C6849R.layout.hiad_dest_icon_view, this)).setBackgroundColor(0);
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = (AutoScaleSizeRelativeLayout) findViewById(C6849R.id.hiad_round_layout);
        this.f37500a = autoScaleSizeRelativeLayout;
        autoScaleSizeRelativeLayout.setBackgroundColor(-1);
        this.f37500a.setRectCornerRadius(AbstractC7741ao.m47535a(context, 8.0f));
        CornerImageView cornerImageView = (CornerImageView) findViewById(C6849R.id.hiad_dest_icon);
        this.f37501b = cornerImageView;
        cornerImageView.setRectCornerRadius(AbstractC7741ao.m47535a(context, 6.0f));
    }

    public CornerImageView getIcon() {
        return this.f37501b;
    }

    public AutoScaleSizeRelativeLayout getRoundLayout() {
        return this.f37500a;
    }
}
