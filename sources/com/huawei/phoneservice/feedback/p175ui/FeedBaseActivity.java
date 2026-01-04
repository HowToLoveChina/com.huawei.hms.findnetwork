package com.huawei.phoneservice.feedback.p175ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.phoneservice.faq.base.util.FaqDialogUtil;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.widget.ActionBarExCompat;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.adapter.C8466e;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.uikit.hwresources.C8732R;

/* loaded from: classes5.dex */
public abstract class FeedBaseActivity extends FeedbackAbstractBaseActivity {

    /* renamed from: A */
    public ProgressDialog f39700A;

    /* renamed from: B */
    public AlertDialog f39701B;

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedBaseActivity$a */
    public class ViewOnClickListenerC8511a implements View.OnClickListener {
        public ViewOnClickListenerC8511a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedBaseActivity.this.onBackPressed(view);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedBaseActivity$b */
    public class ViewOnClickListenerC8512b implements View.OnClickListener {
        public ViewOnClickListenerC8512b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            FeedBaseActivity.this.m52879w0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedBaseActivity$c */
    public class C8513c implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        public final /* synthetic */ DialogInterface.OnClickListener f39704a;

        public C8513c(DialogInterface.OnClickListener onClickListener) {
            this.f39704a = onClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            DialogInterface.OnClickListener onClickListener = this.f39704a;
            if (onClickListener != null) {
                onClickListener.onClick(FeedBaseActivity.this.f39701B, i10);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedBaseActivity$d */
    public static class DialogInterfaceOnClickListenerC8514d implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC8514d() {
        }

        public /* synthetic */ DialogInterfaceOnClickListenerC8514d(ViewOnClickListenerC8511a viewOnClickListenerC8511a) {
            this();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: m0 */
    public int mo52871m0() {
        return C8732R.dimen.padding_m;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            try {
                ActionBarExCompat.setDisplayHomeAsUpEnabled(actionBar, true, new ViewOnClickListenerC8511a());
                ActionBarExCompat.setHomeButtonEnabled(actionBar, true);
                TextView textViewM52881y0 = m52881y0();
                if (textViewM52881y0 != null) {
                    ActionBarExCompat.initTitleStyle(actionBar, textViewM52881y0);
                }
                actionBar.setHomeActionContentDescription(R$string.feedback_sdk_back);
            } catch (Exception e10) {
                FaqLogger.m51840e("FeedBaseActivity", e10.getMessage());
            }
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() throws Throwable {
        m52880x0();
        m52879w0();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        setTitle(getTitle());
        super.onResume();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: p0 */
    public int mo52872p0() {
        return C8732R.dimen.emui_dimens_max_start;
    }

    /* renamed from: q0 */
    public void m52873q0(long j10, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View viewInflate = getLayoutInflater().inflate(R$layout.feedback_sdk_dialog_upload_flow, (ViewGroup) null);
        if (viewInflate == null) {
            return;
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.txtContent);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btnYes);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.btnNo);
        if (textView == null || textView2 == null || textView3 == null) {
            return;
        }
        textView.setText("CN".equals(SdkProblemManager.getSdk().getSdk("country")) ? getResources().getString(R$string.feedback_sdk_upload_flow_zh, Formatter.formatFileSize(this, j10)) : getString(R$string.feedback_sdk_upload_flow, Formatter.formatFileSize(this, j10)));
        if (onClickListener != null) {
            textView2.setOnClickListener(onClickListener);
        }
        if (onClickListener2 != null) {
            textView3.setOnClickListener(onClickListener2);
        }
        showAlertDialog(viewInflate);
    }

    /* renamed from: r0 */
    public void m52874r0(Activity activity, String str, String str2, CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog == null || !alertDialog.isShowing()) {
            ViewOnClickListenerC8511a viewOnClickListenerC8511a = null;
            if (!this.f39784y) {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).setTitle(str).setCancelable(false).setNegativeButton(str2, new DialogInterfaceOnClickListenerC8514d(viewOnClickListenerC8511a)).setSingleChoiceItems(charSequenceArr, i10, onClickListener).create();
                this.f39701B = alertDialogCreate;
                alertDialogCreate.setCanceledOnTouchOutside(true);
                FaqDialogUtil.showDialog(this.f39701B);
                return;
            }
            AlertDialog alertDialogCreate2 = new AlertDialog.Builder(activity).create();
            this.f39701B = alertDialogCreate2;
            alertDialogCreate2.setCanceledOnTouchOutside(false);
            AlertDialog alertDialog2 = this.f39701B;
            if (alertDialog2 == null || alertDialog2.isShowing()) {
                return;
            }
            this.f39701B.show();
            View viewInflate = getLayoutInflater().inflate(R$layout.feedback_sdk_dialog_list, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R$id.title)).setText(str);
            TextView textView = (TextView) viewInflate.findViewById(R$id.cancel);
            textView.setText(str2);
            textView.setOnClickListener(new ViewOnClickListenerC8512b());
            m52877u0(viewInflate, charSequenceArr, i10, onClickListener);
        }
    }

    /* renamed from: s0 */
    public void m52875s0(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View viewInflate = getLayoutInflater().inflate(R$layout.feedback_sdk_dialog_delete_history, (ViewGroup) null);
        if (viewInflate == null) {
            return;
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.delete_history_dialog_cancel);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.delete_history_dialog_delete);
        if (textView == null || textView2 == null) {
            return;
        }
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        if (onClickListener2 != null) {
            textView2.setOnClickListener(onClickListener2);
        }
        m52876t0(viewInflate, false);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            ActionBarExCompat.setTitle(actionBar, charSequence);
        }
    }

    public void showAlertDialog(View view) {
        m52876t0(view, true);
    }

    /* renamed from: t0 */
    public void m52876t0(View view, boolean z10) {
        Window window;
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.f39701B = null;
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
            this.f39701B = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(z10);
            this.f39701B.setCancelable(z10);
            AlertDialog alertDialog2 = this.f39701B;
            if (alertDialog2 == null || alertDialog2.isShowing()) {
                return;
            }
            this.f39701B.show();
            this.f39701B.setContentView(view);
            if (this.f39784y && (window = this.f39701B.getWindow()) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(80);
                attributes.y = 50;
                attributes.dimAmount = 0.2f;
                window.setAttributes(attributes);
            }
        }
    }

    /* renamed from: u0 */
    public final void m52877u0(View view, CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
        ListView listView = (ListView) view.findViewById(R$id.list);
        listView.setAdapter((ListAdapter) new C8466e(charSequenceArr, i10));
        listView.setOnItemClickListener(new C8513c(onClickListener));
        this.f39701B.setContentView(view);
        Window window = this.f39701B.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(80);
        attributes.y = 50;
        attributes.dimAmount = 0.2f;
        window.setAttributes(attributes);
    }

    /* renamed from: v0 */
    public void m52878v0(String str, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View viewInflate = getLayoutInflater().inflate(R$layout.feedback_sdk_dialog_upload_prompt, (ViewGroup) null);
        if (viewInflate == null) {
            return;
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.txtContent);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btnYes);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.btnNo);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            textView3.setText(str3);
        }
        if (onClickListener != null) {
            textView2.setOnClickListener(onClickListener);
        }
        if (onClickListener2 != null) {
            textView3.setOnClickListener(onClickListener2);
        }
        m52876t0(viewInflate, false);
    }

    /* renamed from: w0 */
    public void m52879w0() throws Throwable {
        try {
            AlertDialog alertDialog = this.f39701B;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.f39701B.dismiss();
            this.f39701B = null;
        } catch (Exception e10) {
            FaqLogger.m51840e("FeedBaseActivity", e10.getMessage());
        }
    }

    /* renamed from: x0 */
    public void m52880x0() {
        ProgressDialog progressDialog;
        if (isFinishing() || isDestroyed() || (progressDialog = this.f39700A) == null || !progressDialog.isShowing()) {
            return;
        }
        this.f39700A.dismiss();
        this.f39700A = null;
    }

    /* renamed from: y0 */
    public TextView m52881y0() {
        return (TextView) getWindow().findViewById(Resources.getSystem().getIdentifier("action_bar_title", "id", OsType.ANDROID));
    }
}
