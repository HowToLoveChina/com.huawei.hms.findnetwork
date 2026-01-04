package com.huawei.phoneservice.faq.p174ui;

import android.content.Intent;
import android.view.View;
import com.huawei.phoneservice.faq.FaqBaseActivity;
import com.huawei.phoneservice.faq.R$id;
import com.huawei.phoneservice.faq.R$layout;
import com.huawei.phoneservice.faq.R$string;
import com.huawei.phoneservice.faq.adapter.FaqProblemTypeAdapter;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.tracker.FaqTrack;
import com.huawei.phoneservice.faq.base.util.FaqOnDoubleClickUtil;
import com.huawei.phoneservice.faq.base.widget.SimpleBaseAdapter;
import com.huawei.phoneservice.faq.response.FaqClassification;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.phoneservice.faq.widget.FaqListGridView;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class FaqProblemClassifyActivity extends FaqBaseActivity implements View.OnClickListener {

    /* renamed from: A */
    public FaqListGridView f38962A;

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f */
    public void mo51677f() throws Throwable {
        ArrayList parcelableArrayListExtra;
        setTitle(getResources().getString(R$string.faq_sdk_problem_type));
        Intent intent = getIntent();
        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("data")) == null) {
            return;
        }
        FaqProblemTypeAdapter faqProblemTypeAdapter = new FaqProblemTypeAdapter(this, 1);
        faqProblemTypeAdapter.setResource(parcelableArrayListExtra);
        faqProblemTypeAdapter.setOnClickListener(this);
        FaqListGridView faqListGridView = this.f38962A;
        if (faqListGridView != null) {
            faqListGridView.setNumColumns(4);
            this.f38962A.setAdapter((SimpleBaseAdapter) faqProblemTypeAdapter);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: f0 */
    public int mo51678f0() {
        return R$layout.faq_sdk_activity_problem_classify_layout;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: h0 */
    public void mo51671h0() {
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: i0 */
    public void mo51672i0() {
        this.f38962A = (FaqListGridView) findViewById(R$id.problem_classify_list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        FaqClassification.Classification classification = (FaqClassification.Classification) view.getTag();
        if (classification != null) {
            String strM51922e = classification.m51922e();
            String strM51921d = classification.m51921d();
            if ("Y".equals(classification.m51919a())) {
                FaqThirdListActivity.m52269D0(this, strM51922e, null, strM51921d);
            } else {
                FaqSecondaryListActivity.m52247r0(this, strM51922e, null, strM51921d);
            }
            FaqTrack.event(SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL) + "+SDK", "Click on FAQ Category", classification.m51922e());
        }
        FaqOnDoubleClickUtil.conClick(view);
    }
}
