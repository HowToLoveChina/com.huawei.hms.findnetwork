package com.huawei.phoneservice.feedback.p175ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;

/* loaded from: classes5.dex */
public class FeedbackSubmitSuccessActivity extends FeedBaseActivity implements View.OnClickListener {

    /* renamed from: C */
    public Button f39828C;

    /* renamed from: D */
    public TextView f39829D;

    /* renamed from: E */
    public boolean f39830E = false;

    /* renamed from: F */
    public String f39831F;

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_submit_success;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: i0 */
    public int[] mo52895i0() {
        return new int[]{R$id.rl_submit};
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        boolean booleanExtra = safeIntent.getBooleanExtra("COME_FROM", false);
        this.f39830E = booleanExtra;
        setTitle(booleanExtra ? R$string.feedback_sdk_question : R$string.faq_sdk_feedback);
        String stringExtra = safeIntent.getStringExtra("problemId");
        this.f39831F = stringExtra;
        this.f39829D.setText(stringExtra);
        this.f39828C.setVisibility(ModuleConfigUtils.feedbackHistoryEnabled() ? 0 : 8);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39828C.setOnClickListener(this);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        this.f39828C = (Button) findViewById(R$id.btn_submit);
        this.f39829D = (TextView) findViewById(R$id.tv_sr_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!NoDoubleClickUtil.isDoubleClick(view) && R$id.btn_submit == view.getId()) {
            Intent intent = new Intent(this, (Class<?>) FeedDetailsActivity.class);
            intent.putExtra("questionId", this.f39831F);
            intent.putExtra("COME_FROM", this.f39830E);
            startActivity(intent);
        }
    }
}
