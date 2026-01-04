package com.huawei.cloud.pay.p098ui.uiextend.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.huawei.cloud.pay.R$id;
import com.huawei.cloud.pay.R$layout;
import com.huawei.cloud.pay.R$string;
import p054cj.C1442a;
import p676ud.AlertDialogC13154a;
import sk.C12809f;

/* loaded from: classes5.dex */
public class AutoRenewRuleDialog extends AlertDialogC13154a {

    /* renamed from: com.huawei.cloud.pay.ui.uiextend.view.AutoRenewRuleDialog$a */
    public class ViewOnClickListenerC4670a implements View.OnClickListener {
        public ViewOnClickListenerC4670a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1442a.m8290i("AutoRenewRuleDialog", "AutoRenewRuleDialog click btn");
            AutoRenewRuleDialog.this.dismiss();
        }
    }

    public AutoRenewRuleDialog(Context context) {
        super(context);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        setContentView(R$layout.auto_renew_rule_dialog_view);
        TextView textView = (TextView) C12809f.m76830c(this, R$id.renew_rule_dialog_first_text);
        TextView textView2 = (TextView) C12809f.m76830c(this, R$id.renew_rule_dialog_second_text);
        TextView textView3 = (TextView) C12809f.m76830c(this, R$id.renew_rule_dialog_third_text);
        textView.setText(getContext().getString(R$string.cloudpay_renew_rule_first, 1, 5));
        textView2.setText(getContext().getString(R$string.cloudpay_renew_rule_second, 2));
        textView3.setText(getContext().getString(R$string.cloudpay_renew_rule_third, 3, getContext().getString(R$string.cloudpay_renew_rule_third_s, 1, 2, 3, 4)));
        ((Button) C12809f.m76830c(this, R$id.renew_rule_dialog_btn)).setOnClickListener(new ViewOnClickListenerC4670a());
    }

    @Override // android.app.Dialog
    public void show() {
        getContext().getTheme();
        super.show();
    }
}
