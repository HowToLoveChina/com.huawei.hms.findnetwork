package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.hicloud.sync.R$id;
import com.huawei.hicloud.sync.R$layout;
import com.huawei.hicloud.sync.R$string;
import p514o9.C11839m;
import sk.C12809f;

/* loaded from: classes3.dex */
public class HiCloudListTipsLayout extends LinearLayout {

    /* renamed from: a */
    public SpanClickText f17938a;

    public HiCloudListTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.list_tips_layout, this);
        this.f17938a = (SpanClickText) C12809f.m76831d(this, R$id.success_time);
    }

    /* renamed from: a */
    public void m23994a() {
        this.f17938a.setVisibility(8);
    }

    /* renamed from: b */
    public void m23995b() {
        C11839m.m70686d("HiCloudListTipsLayout", "setNoTips");
        this.f17938a.setVisibility(8);
    }

    /* renamed from: c */
    public void m23996c(String str, String str2, SpanClickText.ISpanClickListener iSpanClickListener) {
        C11839m.m70686d("HiCloudListTipsLayout", "setText : " + str + " linkClickText " + str2);
        this.f17938a.setVisibility(0);
        this.f17938a.m15931c(str2, iSpanClickListener);
        this.f17938a.m15934g(str, false);
    }

    /* renamed from: d */
    public void m23997d() {
        this.f17938a.setVisibility(0);
    }

    /* renamed from: e */
    public void m23998e(int i10) {
        this.f17938a.setMaxWidth(i10);
    }

    public void setDefaultTips(String str) {
        this.f17938a.setVisibility(0);
        this.f17938a.setText(str);
    }

    public void setLoadingText(String str) throws Resources.NotFoundException {
        C11839m.m70686d("HiCloudListTipsLayout", "setLoadingText : " + str);
        if (getResources() != null) {
            str = getResources().getString(R$string.general_append_handling2, str);
        }
        this.f17938a.setVisibility(0);
        this.f17938a.setText(str);
    }

    public void setText(CharSequence charSequence) {
        C11839m.m70686d("HiCloudListTipsLayout", "setText : " + ((Object) charSequence));
        this.f17938a.setVisibility(0);
        this.f17938a.setText(charSequence);
    }

    public void setTextColor(int i10) {
        C11839m.m70686d("HiCloudListTipsLayout", "setTextColor : " + i10);
        this.f17938a.setVisibility(0);
        this.f17938a.setTextColor(i10);
    }
}
