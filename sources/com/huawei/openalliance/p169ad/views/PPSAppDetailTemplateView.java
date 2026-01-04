package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.C7818dk;

/* loaded from: classes2.dex */
public class PPSAppDetailTemplateView extends PPSAppDetailView {

    /* renamed from: e */
    private TextView f36495e;

    /* renamed from: f */
    private TextView f36496f;

    /* renamed from: g */
    private int f36497g;

    public PPSAppDetailTemplateView(Context context) {
        super(context);
    }

    /* renamed from: c */
    private void m48920c(Context context) {
        if (!AbstractC7741ao.m47592n(context)) {
            AbstractC7185ho.m43820b("PPSAppDetailTemplateView", "do not deal elderly font.");
            return;
        }
        TextView textView = this.f36495e;
        if (textView == null || this.f36496f == null) {
            AbstractC7185ho.m43823c("PPSAppDetailTemplateView", "appName or appDeveloper tv is null.");
            return;
        }
        m48919a(textView, 28);
        m48919a(this.f36496f, 21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) C7818dk.m48367a(context, 4), 0, 0);
        if (this.f36497g != 4) {
            this.f36495e.setLayoutParams(layoutParams);
        }
        this.f36496f.setLayoutParams(layoutParams);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: a */
    public int mo48921a(Context context) {
        return this.f36497g == 4 ? C6849R.layout.hiad_landing_app_detail_insretemplate4 : C6849R.layout.hiad_landing_app_detail_template_custom;
    }

    public PPSAppDetailTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: a */
    public void mo48922a() {
        super.mo48922a();
        this.f36495e = (TextView) findViewById(C6849R.id.app_name);
        this.f36496f = (TextView) findViewById(C6849R.id.app_develop_name);
        AppInfo appInfo = getAppInfo();
        if (appInfo != null) {
            this.f36495e.setText(appInfo.getAppName());
            this.f36496f.setText(appInfo.getDeveloperName());
        }
        m48920c(getContext());
    }

    public PPSAppDetailTemplateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.PPSAppDetailView
    /* renamed from: a */
    public void mo48923a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.InsreTemplate)) == null) {
            return;
        }
        try {
            int integer = typedArrayObtainStyledAttributes.getInteger(C6849R.styleable.InsreTemplate_insreTemplate, 2);
            this.f36497g = integer;
            AbstractC7185ho.m43818a("PPSAppDetailTemplateView", "insreTemplate %s", Integer.valueOf(integer));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m48919a(TextView textView, int i10) {
        if (textView != null) {
            textView.setTextSize(1, i10);
        }
    }
}
