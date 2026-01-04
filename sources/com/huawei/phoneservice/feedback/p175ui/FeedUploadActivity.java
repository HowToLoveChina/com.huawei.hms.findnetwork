package com.huawei.phoneservice.feedback.p175ui;

import android.app.AlertDialog;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.AttackCharFilter;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$color;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.entity.FeedbackBean;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8504f;
import com.huawei.phoneservice.feedback.mvp.presenter.C8508d;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8510b;
import com.huawei.phoneservice.feedback.utils.EnumC8594a;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.phoneservice.feedbackcommon.utils.UriDeserializer;
import com.huawei.phoneservice.feedbackcommon.utils.UriSerializer;
import com.huawei.phoneservice.feedbackcommon.utils.ZipUtil;
import hu.C10343b;
import java.io.File;
import java.io.IOException;

/* loaded from: classes5.dex */
public class FeedUploadActivity extends FeedbackBaseActivity<C8508d> implements View.OnClickListener, View.OnFocusChangeListener, InterfaceC8504f {

    /* renamed from: D */
    public TextView f39759D;

    /* renamed from: E */
    public Button f39760E;

    /* renamed from: F */
    public Button f39761F;

    /* renamed from: G */
    public C8508d f39762G;

    /* renamed from: H */
    public EditText f39763H;

    /* renamed from: I */
    public FeedbackBean f39764I;

    /* renamed from: J */
    public AsCache f39765J;

    /* renamed from: K */
    public boolean f39766K = false;

    /* renamed from: L */
    public TextView f39767L;

    /* renamed from: M */
    public TextView f39768M;

    /* renamed from: N */
    public boolean f39769N;

    /* renamed from: O */
    public LinearLayout f39770O;

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$a */
    public class ViewOnClickListenerC8528a implements View.OnClickListener {
        public ViewOnClickListenerC8528a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedUploadActivity.this.m52744D0();
            FeedUploadActivity.this.f39762G.m52858j();
            FaqSdk.getISdk().onClick(FeedUploadActivity.this.getClass().getName(), "Cancel", FeedUploadActivity.this.f39764I);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$b */
    public class ViewOnClickListenerC8529b implements View.OnClickListener {
        public ViewOnClickListenerC8529b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedUploadActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$c */
    public class RunnableC8530c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ EnumC8594a f39773a;

        public RunnableC8530c(EnumC8594a enumC8594a) {
            this.f39773a = enumC8594a;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            FeedUploadActivity.this.f39770O.setVisibility(8);
            EnumC8594a enumC8594a = this.f39773a;
            if (enumC8594a == EnumC8594a.ZIP_COMPRESS_FAILED) {
                FeedUploadActivity.this.f39768M.setVisibility(0);
            } else if (enumC8594a == EnumC8594a.ZIP_COMPRESS_SUCCESS && FeedUploadActivity.this.f39769N) {
                FeedUploadActivity.this.m52961Q0();
                return;
            }
            FeedUploadActivity.this.m52934J0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$d */
    public class RunnableC8531d implements Runnable {
        public RunnableC8531d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedUploadActivity.this.f39762G.m52860l();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$e */
    public class ViewOnTouchListenerC8532e implements View.OnTouchListener {
        public ViewOnTouchListenerC8532e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            FeedUploadActivity.this.f39763H.setFocusableInTouchMode(true);
            if (view.getId() == R$id.edit_desc && C8510b.m52865b(FeedUploadActivity.this.f39763H)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$f */
    public class C8533f implements TextWatcher {
        public C8533f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (FeedUploadActivity.this.f39764I != null) {
                String strTrim = FeedUploadActivity.this.f39763H.getText().toString().trim();
                FeedUploadActivity.this.f39764I.setProblemDesc(strTrim);
                int length = strTrim.length();
                FeedUploadActivity.this.f39759D.setTextColor(ContextCompat.getColor(FeedUploadActivity.this, length >= 500 ? R$color.feedback_sdk_problem_question_max_number : R$color.feedback_sdk_problem_question_number));
                FeedUploadActivity.this.f39759D.setText(String.format(FeedUploadActivity.this.getResources().getString(R$string.feedback_sdk_problem_input_number), Integer.valueOf(length), 500));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$g */
    public class RunnableC8534g implements Runnable {
        public RunnableC8534g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedUploadActivity.this.f39762G.m52860l();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$h */
    public class ViewOnClickListenerC8535h implements View.OnClickListener {
        public ViewOnClickListenerC8535h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedUploadActivity.this.m52744D0();
            FeedUploadActivity.this.m52933I0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$i */
    public class ViewOnClickListenerC8536i implements View.OnClickListener {
        public ViewOnClickListenerC8536i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedUploadActivity.this.m52744D0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$j */
    public class ViewOnClickListenerC8537j implements View.OnClickListener {
        public ViewOnClickListenerC8537j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedUploadActivity.this.m52744D0();
            FeedUploadActivity.this.m52935L0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$k */
    public class ViewOnClickListenerC8538k implements View.OnClickListener {
        public ViewOnClickListenerC8538k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedUploadActivity.this.m52744D0();
            if (FeedUploadActivity.this.f39765J != null) {
                FeedUploadActivity.this.f39765J.remove("lastSubmitzip");
            }
            FeedUploadActivity.this.f39764I = new FeedbackBean();
            FeedUploadActivity.this.f39763H.setText(FeedUploadActivity.this.f39764I.getProblemDesc());
            FeedUploadActivity.this.f39763H.setSelection(FeedUploadActivity.this.f39764I.getProblemDesc().length());
            FeedUploadActivity.this.f39769N = false;
            FeedUploadActivity.this.m52935L0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedUploadActivity$l */
    public class ViewOnClickListenerC8539l implements View.OnClickListener {
        public ViewOnClickListenerC8539l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedUploadActivity.this.m52744D0();
            FeedUploadActivity.this.f39762G.m52859k();
            FaqSdk.getISdk().onClick(FeedUploadActivity.this.getClass().getName(), "Quit", FeedUploadActivity.this.f39764I);
        }
    }

    /* renamed from: H0 */
    private void m52932H0() {
        View viewInflate = getLayoutInflater().inflate(R$layout.feedback_sdk_dialog_uploadzip, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R$id.close)).setOnClickListener(new ViewOnClickListenerC8529b());
        m52876t0(viewInflate, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public void m52933I0() throws Throwable {
        Gson gsonCreate = this.f39764I.haveMedias() ? new GsonBuilder().registerTypeAdapter(Uri.class, new UriSerializer()).create() : new Gson();
        AsCache asCache = this.f39765J;
        if (asCache != null) {
            asCache.put("lastSubmitzip", gsonCreate.toJson(this.f39764I), 172800);
        }
        this.f39762G.m52854f(0, 0);
        this.f39762G.m52855g(this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public void m52934J0() {
        this.f39760E.setEnabled(this.f39766K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public void m52935L0() {
        ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(this)));
        m52962W0(R$string.feedback_sdk_zipcompressing);
        new Handler().postDelayed(new RunnableC8531d(), 500L);
        this.f39770O.setVisibility(0);
        m52934J0();
    }

    /* renamed from: O0 */
    private void m52936O0() {
        if (this.f39760E.getMeasuredWidth() < FaqCommonUtils.getScreenWidthHeight(this)) {
            C8510b.m52864a(this, this.f39760E);
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public C8508d mo52746F0() {
        C8508d c8508d = new C8508d(this, this);
        this.f39762G = c8508d;
        return c8508d;
    }

    /* renamed from: M0 */
    public void m52958M0() {
        m52878v0(getString(R$string.feedback_sdk_tips_continue_to_submit), getString(R$string.feedback_sdk_appupdate3_continue), getString(R$string.feedback_sdk_common_cancel), new ViewOnClickListenerC8537j(), new ViewOnClickListenerC8538k());
    }

    /* renamed from: N0 */
    public void m52959N0() {
        m52878v0(getString(R$string.feedback_sdk_tips_upload_waiting_or_exit_new), null, null, new ViewOnClickListenerC8539l(), new ViewOnClickListenerC8528a());
        this.f39762G.m52857i();
    }

    /* renamed from: P0 */
    public final boolean m52960P0() throws Throwable {
        AsCache asCache = this.f39765J;
        if (asCache == null) {
            return false;
        }
        String asString = asCache.getAsString("lastSubmitzip");
        if (TextUtils.isEmpty(asString)) {
            return false;
        }
        this.f39764I = (FeedbackBean) new GsonBuilder().registerTypeAdapter(Uri.class, new UriDeserializer()).create().fromJson(asString, FeedbackBean.class);
        return true;
    }

    /* renamed from: Q0 */
    public final void m52961Q0() throws Throwable {
        if (this.f39764I == null) {
            return;
        }
        int i10 = 10;
        try {
            int i11 = Integer.parseInt(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MIN_DESC_INPUT));
            if (i11 >= 1 && i11 <= 10) {
                i10 = i11;
            }
        } catch (NumberFormatException unused) {
        }
        if (TextUtils.isEmpty(this.f39764I.getProblemDesc()) || this.f39764I.getProblemDesc().trim().length() < i10) {
            mo52756c(getString(R$string.feedback_sdk_feedback_desc_hint, Integer.valueOf(i10)));
            return;
        }
        if (!NetworkUtils.isNetworkConnected(this)) {
            mo52756c(getResources().getString(R$string.feedback_sdk_no_network));
        } else if (0 == this.f39764I.getLogsSize() || NetworkUtils.isWifiConnected(this)) {
            m52933I0();
        } else {
            m52963Z0(C6661f.f30885g);
        }
    }

    /* renamed from: W0 */
    public final void m52962W0(int i10) {
        this.f39767L.setText(i10);
        this.f39770O.setVisibility(0);
        this.f39760E.setEnabled(false);
    }

    /* renamed from: Z0 */
    public void m52963Z0(String str) {
        long logsSize = this.f39764I.getLogsSize();
        if (logsSize == 0) {
            logsSize = 1;
        }
        m52873q0(logsSize, new ViewOnClickListenerC8535h(), new ViewOnClickListenerC8536i());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: a */
    public void mo52754a() {
        AsCache asCache = this.f39765J;
        if (asCache != null) {
            asCache.remove("lastSubmitzip");
        }
        this.f39770O.setVisibility(8);
        this.f39761F.setVisibility(8);
        this.f39760E.setEnabled(true);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: b */
    public FeedbackInfo mo52755b() {
        return this.f39764I.getInfo();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8496e
    /* renamed from: c */
    public FeedbackBean mo52764c() {
        return this.f39764I;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: e */
    public void mo52757e() {
        m52962W0(R$string.feedback_sdk_common_in_submission);
        this.f39761F.setVisibility(0);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_uploadfile;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: i0 */
    public int[] mo52895i0() {
        return new int[]{R$id.rl_uploadfile};
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        try {
            this.f39765J = AsCache.get(this, "feedback");
        } catch (IOException | RuntimeException e10) {
            FaqLogger.m51840e("FeedUploadActivity", e10.getMessage());
        }
        boolean zM52960P0 = m52960P0();
        this.f39769N = zM52960P0;
        if (zM52960P0) {
            m52958M0();
        } else {
            this.f39764I = new FeedbackBean();
            m52935L0();
        }
        this.f39764I.setShowLog(true);
        this.f39763H.setText(this.f39764I.getProblemDesc());
        this.f39763H.setSelection(this.f39764I.getProblemDesc().length());
        m52936O0();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39760E.setOnClickListener(this);
        this.f39763H.setOnFocusChangeListener(this);
        this.f39768M.setOnClickListener(this);
        this.f39763H.setOnTouchListener(new ViewOnTouchListenerC8532e());
        this.f39763H.addTextChangedListener(new C8533f());
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        setTitle(R$string.feedback_sdk_uploadfile_title);
        TextView textView = (TextView) findViewById(R$id.txt_number);
        this.f39759D = textView;
        textView.setText(String.format(getResources().getString(R$string.feedback_sdk_problem_input_number), 0, 500));
        this.f39760E = (Button) findViewById(R$id.btn_submit);
        this.f39763H = (EditText) findViewById(R$id.edit_desc);
        this.f39770O = (LinearLayout) findViewById(R$id.layout_loading);
        this.f39761F = (Button) findViewById(R$id.bg_dismiss);
        this.f39767L = (TextView) findViewById(R$id.tv_progress);
        this.f39768M = (TextView) findViewById(R$id.tv_tryagain);
        this.f39763H.setFilters(new InputFilter[]{new InputFilter.LengthFilter(500), new AttackCharFilter()});
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f39701B.dismiss();
        } else if (!this.f39762G.m52856h()) {
            m52959N0();
        } else {
            if (this.f39761F.getVisibility() == 0) {
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        if (view.getId() == R$id.btn_submit) {
            FaqCommonUtils.hideIme(this);
            m52961Q0();
        } else if (view.getId() == R$id.tv_tryagain) {
            this.f39768M.setVisibility(8);
            ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(this)));
            new Handler().postDelayed(new RunnableC8534g(), 500L);
            m52962W0(R$string.feedback_sdk_zipcompress_again);
            this.f39770O.setVisibility(0);
            this.f39769N = false;
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        Button button = this.f39760E;
        if (button != null) {
            C8510b.m52864a(this, button);
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            C10343b c10343b = new C10343b(bundle);
            this.f39764I = (FeedbackBean) c10343b.m63690l("FeedbackBean");
            FaqSdk.getSdk().saveMapOnSaveInstanceState(c10343b.m63694p("CacheMap"));
        }
        super.onCreate(bundle);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        String string;
        EditText editText = (EditText) view;
        if (view.getId() == R$id.edit_desc) {
            if (z10) {
                editText.setTag(editText.getHint().toString());
                string = "";
            } else {
                string = editText.getTag().toString();
            }
            editText.setHint(string);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("FeedbackBean", this.f39764I);
        bundle.putString("CacheMap", FaqSdk.getSdk().getMapOnSaveInstance());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: z */
    public void mo52758z(EnumC8594a enumC8594a) {
        int i10;
        if (enumC8594a != EnumC8594a.ZIP_COMPRESS_SUCCESS) {
            if (enumC8594a == EnumC8594a.ZIP_COMPRESS_FAILED) {
                i10 = R$string.feedback_sdk_zipcompressfailed;
            }
            new Handler().postDelayed(new RunnableC8530c(enumC8594a), 500L);
        }
        this.f39766K = true;
        i10 = R$string.feedback_sdk_zipcompresssuccess;
        m52962W0(i10);
        new Handler().postDelayed(new RunnableC8530c(enumC8594a), 500L);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8504f
    /* renamed from: a */
    public void mo52779a(String str) {
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f39701B.dismiss();
        }
        m52932H0();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: c */
    public void mo52756c(String str) throws Throwable {
        FaqToastUtils.makeText(this, str);
    }
}
