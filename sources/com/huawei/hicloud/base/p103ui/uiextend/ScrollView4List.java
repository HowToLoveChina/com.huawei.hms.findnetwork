package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes6.dex */
public class ScrollView4List extends ScrollView {

    /* renamed from: a */
    public InterfaceC4859a f22173a;

    /* renamed from: com.huawei.hicloud.base.ui.uiextend.ScrollView4List$a */
    public interface InterfaceC4859a {
        /* renamed from: a */
        void mo23907a(ScrollView scrollView, int i10, int i11, int i12, int i13);
    }

    public ScrollView4List(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return true;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        InterfaceC4859a interfaceC4859a = this.f22173a;
        if (interfaceC4859a != null) {
            interfaceC4859a.mo23907a(this, i10, i11, i12, i13);
        }
    }

    public void setOnScrollChangedListener(InterfaceC4859a interfaceC4859a) {
        this.f22173a = interfaceC4859a;
    }

    public ScrollView4List(Context context) {
        super(context);
    }

    public ScrollView4List(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
