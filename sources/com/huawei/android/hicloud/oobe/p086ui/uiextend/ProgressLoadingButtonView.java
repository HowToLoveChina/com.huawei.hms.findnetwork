package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.R$id;
import com.huawei.android.hicloud.oobe.R$layout;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ProgressLoadingButtonView extends FrameLayout {

    /* renamed from: a */
    public Context f12706a;

    /* renamed from: b */
    public RelativeLayout f12707b;

    public ProgressLoadingButtonView(Context context) {
        super(context);
        this.f12706a = context;
        m17064a();
    }

    /* renamed from: a */
    public final void m17064a() {
        this.f12707b = (RelativeLayout) C12809f.m76831d(View.inflate(this.f12706a, R$layout.progress_loading_button_view, this), R$id.layout);
    }

    public void setLayoutHeight(int i10) {
        this.f12707b.setMinimumHeight(i10);
    }

    public ProgressLoadingButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12706a = context;
        m17064a();
    }
}
