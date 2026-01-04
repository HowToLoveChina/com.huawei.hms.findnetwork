package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.utils.C7780c;

/* loaded from: classes2.dex */
public class RewardEndCardSixElementsView extends SixElementsView {

    /* renamed from: q */
    private TextView f37311q;

    public RewardEndCardSixElementsView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.SixElementsView
    /* renamed from: a */
    public void mo49854a(Context context, AttributeSet attributeSet) {
        m49943b(context, attributeSet);
        this.f37391b = context;
        if (m49944b()) {
            View viewInflate = View.inflate(context, C6849R.layout.reward_endcard_six_elements_elderly_layout, this);
            this.f37392c = viewInflate;
            this.f37402m = (TextView) viewInflate.findViewById(C6849R.id.endcard_six_elements_splicing);
        } else {
            this.f37392c = View.inflate(context, this.f37390a == 1 ? C6849R.layout.reward_endcard_six_elements_center_layout : C6849R.layout.reward_endcard_six_elements_layout, this);
            this.f37395f = (TextView) this.f37392c.findViewById(C6849R.id.endcard_six_elements_version);
            TextView textView = (TextView) this.f37392c.findViewById(C6849R.id.endcard_six_elements_desc);
            this.f37396g = textView;
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) this.f37392c.findViewById(C6849R.id.endcard_six_elements_privacy_policy);
            this.f37397h = textView2;
            textView2.setOnClickListener(this);
            TextView textView3 = (TextView) this.f37392c.findViewById(C6849R.id.endcard_six_elements_permission);
            this.f37398i = textView3;
            textView3.setOnClickListener(this);
            this.f37399j = (TextView) this.f37392c.findViewById(C6849R.id.endcard_version_line);
            this.f37400k = (TextView) this.f37392c.findViewById(C6849R.id.endcard_privacy_line);
            this.f37401l = (TextView) this.f37392c.findViewById(C6849R.id.endcard_permission_line);
            m49941a(this.f37392c, true);
        }
        this.f37311q = (TextView) this.f37392c.findViewById(C6849R.id.reward_endcard_jump_text);
        this.f37393d = (TextView) this.f37392c.findViewById(C6849R.id.endcard_six_elements_name);
        this.f37394e = (TextView) this.f37392c.findViewById(C6849R.id.endcard_six_elements_develop_name);
        m49940a();
    }

    public RewardEndCardSixElementsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.p169ad.views.SixElementsView
    /* renamed from: a */
    public void mo49855a(AdLandingPageData adLandingPageData) {
        super.mo49855a(adLandingPageData);
        TextView textView = this.f37311q;
        if (textView != null) {
            textView.setText(C7780c.m47859a(this.f37404o, this.f37391b, true));
        }
    }

    public RewardEndCardSixElementsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
