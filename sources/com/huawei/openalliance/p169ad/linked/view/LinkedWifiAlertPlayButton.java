package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.openalliance.p169ad.views.ProgressButton;

/* loaded from: classes2.dex */
public class LinkedWifiAlertPlayButton extends ProgressButton {

    /* renamed from: o */
    private Context f34352o;

    /* renamed from: p */
    private C7396a f34353p;

    /* renamed from: q */
    private InterfaceC7395a f34354q;

    /* renamed from: com.huawei.openalliance.ad.linked.view.LinkedWifiAlertPlayButton$a */
    public interface InterfaceC7395a {
        /* renamed from: a */
        void m45519a();
    }

    public LinkedWifiAlertPlayButton(Context context) {
        super(context);
        m45518a(context);
    }

    /* renamed from: a */
    private void m45518a(Context context) {
        this.f34352o = context;
        this.f34353p = new C7396a(context);
    }

    public C7396a getStyle() {
        return this.f34353p;
    }

    @Override // com.huawei.openalliance.p169ad.views.ProgressButton, com.huawei.hms.ads.uiengine.common.IProgressButton
    public CharSequence getText() {
        return super.getText();
    }

    @Override // com.huawei.openalliance.p169ad.views.ProgressButton, android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC7395a interfaceC7395a = this.f34354q;
        if (interfaceC7395a != null) {
            interfaceC7395a.m45519a();
        }
    }

    public void setCoverListener(InterfaceC7395a interfaceC7395a) {
        this.f34354q = interfaceC7395a;
    }

    public void setText(int i10) {
        super.setText(this.f34352o.getResources().getString(i10));
    }

    @Override // com.huawei.openalliance.p169ad.views.ProgressButton, com.huawei.hms.ads.uiengine.common.IProgressButton
    public void setTextColor(int i10) {
        super.setTextColor(i10);
    }

    public LinkedWifiAlertPlayButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m45518a(context);
    }

    public LinkedWifiAlertPlayButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m45518a(context);
    }

    public LinkedWifiAlertPlayButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        m45518a(context);
    }
}
