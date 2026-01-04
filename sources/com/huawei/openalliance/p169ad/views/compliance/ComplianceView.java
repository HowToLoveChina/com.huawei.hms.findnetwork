package com.huawei.openalliance.p169ad.views.compliance;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterfaceC7181hk;
import com.huawei.openalliance.p169ad.inter.data.AdvertiserInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7752az;
import com.huawei.openalliance.p169ad.views.AbstractC8104h;
import java.util.List;

/* loaded from: classes2.dex */
public class ComplianceView extends AbstractC8104h {

    /* renamed from: k */
    private View f37583k;

    /* renamed from: l */
    private TextView f37584l;

    /* renamed from: m */
    private RelativeLayout f37585m;

    /* renamed from: n */
    private TextView f37586n;

    /* renamed from: o */
    private ContentRecord f37587o;

    /* renamed from: p */
    private ImageView f37588p;

    /* renamed from: q */
    private InterfaceC7181hk f37589q;

    public ComplianceView(Context context) {
        super(context);
    }

    /* renamed from: f */
    private void m50091f() {
        TextView textView;
        if (!AbstractC7741ao.m47592n(getContext()) || (textView = this.f37584l) == null || this.f37586n == null) {
            return;
        }
        textView.setTextSize(1, 28.0f);
        this.f37586n.setTextSize(1, 28.0f);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: c */
    public void mo50094c() {
        try {
            AbstractC7185ho.m43821b("ComplianceView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f37760g), Integer.valueOf(this.f37761h));
            if (m50257d()) {
                this.f37755b.setPadding(this.f37760g, 0, this.f37761h, 0);
                this.f37755b.requestLayout();
                this.f37755b.getViewTreeObserver().addOnGlobalLayoutListener(this.f37763j);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ComplianceView", "adapterView error, %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    public void setAdContent(ContentRecord contentRecord) {
        if (contentRecord == null) {
            return;
        }
        this.f37587o = contentRecord;
        m50088a();
        m50090b();
        mo50094c();
        m50091f();
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    public void setViewClickListener(InterfaceC7181hk interfaceC7181hk) {
        this.f37589q = interfaceC7181hk;
    }

    public ComplianceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private void m50088a() {
        if (this.f37583k == null || this.f37585m == null) {
            AbstractC7185ho.m43820b("ComplianceView", "partingLine or whyThisAdClick view not init");
            return;
        }
        Boolean bool = this.f37762i;
        if (bool != null && !bool.booleanValue()) {
            AbstractC7185ho.m43820b("ComplianceView", "not need show why this ad");
            return;
        }
        this.f37583k.setVisibility(0);
        this.f37585m.setVisibility(0);
        this.f37585m.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.compliance.ComplianceView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ComplianceView.this.f37587o != null) {
                    AbstractC7741ao.m47548a(ComplianceView.this.getContext(), ComplianceView.this.f37587o);
                    if (ComplianceView.this.f37589q != null) {
                        ComplianceView.this.f37589q.mo38605a();
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private void m50090b() {
        String value;
        ContentRecord contentRecord = this.f37587o;
        if (contentRecord != null) {
            List<AdvertiserInfo> listM41468aT = contentRecord.m41468aT();
            StringBuffer stringBuffer = new StringBuffer();
            if (AbstractC7760bg.m47767a(listM41468aT)) {
                AbstractC7185ho.m43820b("ComplianceView", "complianceInfo is null");
                return;
            }
            for (int i10 = 0; i10 < listM41468aT.size(); i10++) {
                if (i10 != listM41468aT.size() - 1) {
                    stringBuffer.append(listM41468aT.get(i10).getValue());
                    value = ", ";
                } else {
                    value = listM41468aT.get(i10).getValue();
                }
                stringBuffer.append(value);
            }
            TextView textView = this.f37584l;
            if (textView != null) {
                textView.setText(stringBuffer);
            }
        }
    }

    public ComplianceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: a */
    public void mo50092a(Context context) {
        try {
            View viewInflate = LayoutInflater.from(context).inflate(C6849R.layout.hiad_compliance_choice_view, this);
            this.f37755b = viewInflate.findViewById(C6849R.id.compliance_view_root);
            this.f37583k = viewInflate.findViewById(C6849R.id.why_this_ad_line);
            this.f37584l = (TextView) viewInflate.findViewById(C6849R.id.compliance_info);
            this.f37585m = (RelativeLayout) viewInflate.findViewById(C6849R.id.why_this_ad_btn);
            this.f37756c = viewInflate.findViewById(C6849R.id.compliance_scrollview);
            this.f37586n = (TextView) viewInflate.findViewById(C6849R.id.why_this_ad_tv);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ComplianceView", "initView error, %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8104h
    /* renamed from: b */
    public void mo50093b(Context context) throws Resources.NotFoundException {
        ImageView imageView = (ImageView) findViewById(C6849R.id.right_arrow);
        this.f37588p = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(C6849R.drawable.hiad_feedback_right_arrow);
            if (AbstractC7811dd.m48315c()) {
                this.f37588p.setImageBitmap(C7752az.m47693b(drawable));
            }
        }
    }
}
