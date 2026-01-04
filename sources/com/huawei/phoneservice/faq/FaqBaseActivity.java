package com.huawei.phoneservice.faq;

import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.widget.ActionBarExCompat;
import com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity;
import com.huawei.phoneservice.faq.utils.SdkFaqManager;
import com.huawei.uikit.hwresources.C8732R;

/* loaded from: classes4.dex */
public abstract class FaqBaseActivity extends AbstractBaseActivity {

    /* renamed from: com.huawei.phoneservice.faq.FaqBaseActivity$a */
    public class ViewOnClickListenerC8267a implements View.OnClickListener {
        public ViewOnClickListenerC8267a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FaqBaseActivity.this.onBackPressed(view);
        }
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: j0 */
    public int mo51645j0() {
        return C8732R.dimen.padding_m;
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity
    /* renamed from: l0 */
    public int mo51646l0() {
        return C8732R.dimen.emui_dimens_max_start;
    }

    /* renamed from: m0 */
    public TextView m51647m0() {
        return (TextView) getWindow().findViewById(Resources.getSystem().getIdentifier("action_bar_title", "id", OsType.ANDROID));
    }

    /* renamed from: n0 */
    public String m51648n0() {
        String sdk = SdkFaqManager.getSdk().getSdk(FaqConstants.FAQ_KNOWLEDGE_CHANNEL);
        return !TextUtils.isEmpty(sdk) ? sdk : "10003";
    }

    @Override // com.huawei.phoneservice.faq.p174ui.AbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            try {
                ActionBarExCompat.setDisplayHomeAsUpEnabled(actionBar, true, new ViewOnClickListenerC8267a());
                ActionBarExCompat.setHomeButtonEnabled(actionBar, true);
                TextView textViewM51647m0 = m51647m0();
                if (textViewM51647m0 != null) {
                    ActionBarExCompat.initTitleStyle(actionBar, textViewM51647m0);
                }
            } catch (Exception e10) {
                FaqLogger.m51840e("FaqBaseActivity", e10.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        ActionBar actionBar;
        super.setTitle(charSequence);
        if (this.f38861y && (actionBar = getActionBar()) != null) {
            ActionBarExCompat.setTitle(actionBar, charSequence);
        }
    }
}
