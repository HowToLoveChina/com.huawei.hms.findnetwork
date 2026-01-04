package com.huawei.android.remotecontrol.p093ui.activation;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import java.text.NumberFormat;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ActivationIntroduceActivity extends ActivationBaseActivity {
    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEPhoneFinderBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: G */
    public void mo16559G() throws Resources.NotFoundException {
        super.mo16559G();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.activation_introduce_2_content2);
        if (textView != null) {
            textView.setText(getString(C11842p.m70762R0() ? R$string.activation_introduction_2_content2_pad : R$string.activation_introduction_2_content2, 1));
        }
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.activation_introduce_2_content3);
        if (textView2 != null) {
            textView2.setText(getString(R$string.activation_introduction_2_content3, 2));
        }
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.activation_introduce_2_content4);
        if (textView3 != null) {
            textView3.setText(getString(R$string.activation_introduction_2_content4, 3));
        }
        TextView textView4 = (TextView) C12809f.m76829b(this, R$id.activation_introduce_1_title);
        TextView textView5 = (TextView) C12809f.m76829b(this, R$id.activation_introduce_2_title);
        textView4.setText(NumberFormat.getNumberInstance().format(1L) + ". " + getResources().getString(R$string.activation_introduction));
        textView5.setText(NumberFormat.getNumberInstance().format(2L) + ". " + getResources().getString(R$string.activation_introduction_2));
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity
    /* renamed from: R0 */
    public String mo27240R0() {
        return getResources().getString(R$string.activation_introduction);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity
    /* renamed from: c */
    public int mo16578c() {
        return R$layout.activation_introduce;
    }

    @Override // com.huawei.android.remotecontrol.p093ui.activation.ActivationBaseActivity, com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.activity.OOBEBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
