package com.huawei.phoneservice.feedback.p175ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
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
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$color;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$menu;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter;
import com.huawei.phoneservice.feedback.entity.C8471b;
import com.huawei.phoneservice.feedback.entity.FeedbackBean;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a;
import com.huawei.phoneservice.feedback.mvp.presenter.C8505a;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8510b;
import com.huawei.phoneservice.feedback.photolibrary.internal.widget.BadgeHelper;
import com.huawei.phoneservice.feedback.utils.EnumC8594a;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.phoneservice.feedbackcommon.utils.OnReadListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.phoneservice.feedbackcommon.utils.UriDeserializer;
import com.huawei.phoneservice.feedbackcommon.utils.UriSerializer;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ProductSuggestionActivity extends FeedbackBaseActivity<C8505a> implements View.OnClickListener, InterfaceC8499a, View.OnFocusChangeListener, ProblemSuggestPhotoAdapter.InterfaceC8460b {

    /* renamed from: D */
    public C8505a f39940D;

    /* renamed from: F */
    public EditText f39942F;

    /* renamed from: G */
    public TextView f39943G;

    /* renamed from: H */
    public Button f39944H;

    /* renamed from: I */
    public LinearLayout f39945I;

    /* renamed from: J */
    public Button f39946J;

    /* renamed from: K */
    public ScrollView f39947K;

    /* renamed from: L */
    public FeedbackNoticeView f39948L;

    /* renamed from: M */
    public GridView f39949M;

    /* renamed from: N */
    public FeedbackBean f39950N;

    /* renamed from: O */
    public AsCache f39951O;

    /* renamed from: P */
    public ProblemSuggestPhotoAdapter f39952P;

    /* renamed from: E */
    public int f39941E = 0;

    /* renamed from: Q */
    public boolean f39953Q = false;

    /* renamed from: R */
    public int f39954R = 0;

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$a */
    public class RunnableC8581a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f39955a;

        /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$a$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ boolean f39957a;

            public a(boolean z10) {
                this.f39957a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10 = this.f39957a;
                RunnableC8581a runnableC8581a = RunnableC8581a.this;
                if (z10) {
                    ProductSuggestionActivity.this.m53112c1(runnableC8581a.f39955a);
                } else {
                    ProductSuggestionActivity.this.m53109Y0(runnableC8581a.f39955a);
                }
            }
        }

        public RunnableC8581a(String str) {
            this.f39955a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ProductSuggestionActivity.this.f39951O != null) {
                ProductSuggestionActivity.this.f39951O.remove("productLastSubmit");
            }
            ProductSuggestionActivity.this.runOnUiThread(new a(!FaqStringUtil.isEmpty(SdkProblemManager.getSdk().getSdk("accessToken")) && ProductSuggestionActivity.this.f39954R == 0));
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$b */
    public class ViewOnClickListenerC8582b implements View.OnClickListener {
        public ViewOnClickListenerC8582b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view) || !ProductSuggestionActivity.this.f39940D.m52810y() || ProductSuggestionActivity.this.f39946J.getVisibility() == 0) {
                return;
            }
            ProductSuggestionActivity.this.f39941E = 0;
            ProductSuggestionActivity.this.invalidateOptionsMenu();
            Intent intent = new Intent(ProductSuggestionActivity.this, (Class<?>) FeedListActivity.class);
            intent.putExtra("COME_FROM", true);
            ProductSuggestionActivity.this.startActivity(intent);
            FaqSdk.getISdk().onClick(ProductSuggestionActivity.this.getClass().getName(), "Click", ProductSuggestionActivity.this.f39950N);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$c */
    public class ViewOnClickListenerC8583c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f39960a;

        public ViewOnClickListenerC8583c(String str) {
            this.f39960a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            AlertDialog alertDialog = ProductSuggestionActivity.this.f39701B;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            Intent intent = new Intent();
            intent.putExtra("parentProblemId", this.f39960a);
            intent.putExtra("problemId", ProductSuggestionActivity.this.f39950N.getProblemId());
            intent.putExtra("srCode", ProductSuggestionActivity.this.f39950N.getSrCode());
            ProductSuggestionActivity.this.setResult(-1, intent);
            ProductSuggestionActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$d */
    public class ViewOnTouchListenerC8584d implements View.OnTouchListener {
        public ViewOnTouchListenerC8584d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R$id.edit_desc && C8510b.m52865b(ProductSuggestionActivity.this.f39942F)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$e */
    public class C8585e implements OnReadListener {
        public C8585e() {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnReadListener
        public void read(Throwable th2, String str) {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnReadListener
        public void unread(Throwable th2, String str, int i10) {
            ProductSuggestionActivity.this.f39941E = i10;
            ProductSuggestionActivity.this.invalidateOptionsMenu();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$f */
    public class C8586f implements TextWatcher {
        public C8586f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) throws Throwable {
            if (ProductSuggestionActivity.this.f39950N != null) {
                String strTrim = ProductSuggestionActivity.this.f39942F.getText().toString().trim();
                ProductSuggestionActivity.this.f39950N.setProblemDesc(strTrim);
                int length = strTrim.length();
                ProductSuggestionActivity.this.f39943G.setTextColor(ContextCompat.getColor(ProductSuggestionActivity.this, length >= 500 ? R$color.feedback_sdk_problem_question_max_number : R$color.feedback_sdk_problem_question_number));
                ProductSuggestionActivity.this.f39943G.setText(String.format(ProductSuggestionActivity.this.getResources().getString(R$string.feedback_sdk_problem_input_number), Integer.valueOf(length), 500));
                ProductSuggestionActivity.this.m53097I0();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$g */
    public class ViewOnClickListenerC8587g implements View.OnClickListener {
        public ViewOnClickListenerC8587g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProductSuggestionActivity.this.m52879w0();
            ProductSuggestionActivity.this.m53096H0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$h */
    public class ViewOnClickListenerC8588h implements View.OnClickListener {
        public ViewOnClickListenerC8588h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            ProductSuggestionActivity.this.m52879w0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$i */
    public class ViewOnClickListenerC8589i implements View.OnClickListener {
        public ViewOnClickListenerC8589i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProductSuggestionActivity.this.m52744D0();
            ProductSuggestionActivity.this.m53098N0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$j */
    public class ViewOnClickListenerC8590j implements View.OnClickListener {
        public ViewOnClickListenerC8590j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProductSuggestionActivity.this.m52744D0();
            if (ProductSuggestionActivity.this.f39951O != null) {
                ProductSuggestionActivity.this.f39951O.remove("productLastSubmit");
            }
            ProductSuggestionActivity productSuggestionActivity = ProductSuggestionActivity.this;
            productSuggestionActivity.m52741A0(productSuggestionActivity.f39950N);
            ProductSuggestionActivity.this.f39950N = new FeedbackBean();
            ProductSuggestionActivity.this.f39942F.setText(ProductSuggestionActivity.this.f39950N.getProblemDesc());
            ProductSuggestionActivity.this.f39952P.m52608d(ProductSuggestionActivity.this.f39950N.getMedias());
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$k */
    public class ViewOnClickListenerC8591k implements View.OnClickListener {
        public ViewOnClickListenerC8591k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProductSuggestionActivity.this.m52744D0();
            ProductSuggestionActivity.this.f39940D.m52796I();
            FaqSdk.getISdk().onClick(ProductSuggestionActivity.this.getClass().getName(), "Quit", ProductSuggestionActivity.this.f39950N);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProductSuggestionActivity$l */
    public class ViewOnClickListenerC8592l implements View.OnClickListener {
        public ViewOnClickListenerC8592l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProductSuggestionActivity.this.m52744D0();
            ProductSuggestionActivity.this.f39940D.m52795G();
            FaqSdk.getISdk().onClick(ProductSuggestionActivity.this.getClass().getName(), "Cancel", ProductSuggestionActivity.this.f39950N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m53096H0() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "doLastSubmit......");
        Gson gsonCreate = this.f39950N.haveMedias() ? new GsonBuilder().registerTypeAdapter(Uri.class, new UriSerializer()).create() : new Gson();
        AsCache asCache = this.f39951O;
        if (asCache != null) {
            asCache.put("productLastSubmit", gsonCreate.toJson(this.f39950N), 172800);
        }
        FaqSdk.getISdk().onClick(getClass().getName(), "Submit", this.f39950N);
        this.f39940D.m52804n(this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public void m53097I0() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "isChangeSubmitColor......");
        this.f39944H.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public void m53098N0() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "submit......");
        int i10 = 10;
        try {
            int i11 = Integer.parseInt(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MIN_DESC_INPUT));
            if (i11 >= 1 && i11 <= 10) {
                i10 = i11;
            }
        } catch (NumberFormatException unused) {
        }
        if (TextUtils.isEmpty(this.f39950N.getProblemDesc()) || this.f39950N.getProblemDesc().trim().length() < i10) {
            mo52756c(getString(R$string.feedback_sdk_feedback_desc_hint, Integer.valueOf(i10)));
            return;
        }
        if (!NetworkUtils.isNetworkConnected(this)) {
            mo52756c(getResources().getString(R$string.feedback_sdk_no_network));
        } else if (!this.f39950N.haveMedias() || NetworkUtils.isWifiConnected(this)) {
            m53096H0();
        } else {
            m53125a1(C6661f.f30885g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public void m53109Y0(String str) {
        View viewInflate = getLayoutInflater().inflate(R$layout.feedback_sdk_dialog_close, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btnClose);
        textView.setText(R$string.feedback_sdk_already_known);
        textView.setOnClickListener(new ViewOnClickListenerC8583c(str));
        m52876t0(viewInflate, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1 */
    public void m53112c1(String str) {
        Intent intent = new Intent(this, (Class<?>) FeedbackSubmitSuccessActivity.class);
        intent.putExtra("problemId", str);
        intent.putExtra("COME_FROM", true);
        startActivity(intent);
        finish();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public C8505a mo52746F0() {
        C8505a c8505a = new C8505a(this, this, this);
        this.f39940D = c8505a;
        return c8505a;
    }

    /* renamed from: K0 */
    public void m53122K0() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "openUploadContinue......");
        m52878v0(getString(R$string.feedback_sdk_tips_continue_to_submit), getString(R$string.feedback_sdk_appupdate3_continue), getString(R$string.feedback_sdk_common_cancel), new ViewOnClickListenerC8589i(), new ViewOnClickListenerC8590j());
    }

    /* renamed from: L0 */
    public void m53123L0() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "openUploadExit......");
        m52878v0(getString(R$string.feedback_sdk_tips_upload_waiting_or_exit_new), null, null, new ViewOnClickListenerC8591k(), new ViewOnClickListenerC8592l());
        this.f39940D.m52794E();
    }

    /* renamed from: M0 */
    public final boolean m53124M0() throws Throwable {
        if (this.f39951O != null && TextUtils.isEmpty(this.f39950N.getProblemId())) {
            String asString = this.f39951O.getAsString("productLastSubmit");
            if (!TextUtils.isEmpty(asString)) {
                this.f39950N = (FeedbackBean) new GsonBuilder().registerTypeAdapter(Uri.class, new UriDeserializer()).create().fromJson(asString, FeedbackBean.class);
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: a */
    public void mo52754a() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "hideLoading......");
        this.f39945I.setVisibility(8);
        this.f39946J.setVisibility(8);
        m53097I0();
        AsCache asCache = this.f39951O;
        if (asCache != null) {
            asCache.remove("productLastSubmit");
        }
    }

    /* renamed from: a1 */
    public void m53125a1(String str) throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "openUploadFlow......" + str);
        long filesSize = this.f39950N.getFilesSize();
        if (filesSize == 0) {
            filesSize = 1;
        }
        m52873q0(filesSize, new ViewOnClickListenerC8587g(), new ViewOnClickListenerC8588h());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: b */
    public FeedbackInfo mo52755b() {
        return this.f39950N.getInfo();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8496e
    /* renamed from: c */
    public FeedbackBean mo52764c() {
        return this.f39950N;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: e */
    public void mo52757e() throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "showLoading......");
        this.f39944H.setEnabled(false);
        this.f39945I.setVisibility(0);
        this.f39946J.setVisibility(0);
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: f */
    public void mo52611f() throws Throwable {
        m52747G0();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_product_suggestion;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        try {
            this.f39948L.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
            setTitle(getString(R$string.feedback_sdk_question));
            try {
                this.f39951O = AsCache.get(this, "productSuggest");
            } catch (IOException | RuntimeException e10) {
                FaqLogger.m51840e("ProductSuggestionActivity__", e10.getMessage());
            }
            SafeIntent safeIntent = new SafeIntent(getIntent());
            ProblemInfo problemInfo = safeIntent.hasExtra("problem_info") ? (ProblemInfo) safeIntent.getParcelableExtra("problem_info") : null;
            if (problemInfo == null || !problemInfo.isDetail()) {
                this.f39954R = 0;
                this.f39941E = problemInfo == null ? 0 : problemInfo.getUnread();
                this.f39950N = new FeedbackBean();
                this.f39953Q = ModuleConfigUtils.productSuggestLsEnabled();
                this.f39948L.setVisibility(8);
            } else {
                this.f39954R = 1;
                this.f39950N = new FeedbackBean(problemInfo.getProblemId(), problemInfo.getProblemType(), problemInfo.getProblemType(), problemInfo.getContact());
                this.f39953Q = false;
            }
            invalidateOptionsMenu();
            this.f39940D.m52808v(this, false);
            if (FaqStringUtil.isEmpty(SdkProblemManager.getSdk().getSdk("accessToken"))) {
                return;
            }
            SdkProblemManager.getManager().getUnread(this, "", new C8585e());
        } catch (RuntimeException e11) {
            FaqLogger.print("ProductSuggestionActivity__", e11.getMessage());
            finish();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39942F.addTextChangedListener(new C8586f());
        this.f39952P.m52607c(this);
        this.f39944H.setOnClickListener(this);
        this.f39942F.setOnFocusChangeListener(this);
        this.f39948L.setOnClickListener(this);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        this.f39949M = (GridView) findViewById(R$id.list_media);
        this.f39952P = new ProblemSuggestPhotoAdapter(this);
        this.f39944H = (Button) findViewById(R$id.btn_submit);
        this.f39948L = (FeedbackNoticeView) findViewById(R$id.feedback_problem_noticeView);
        ScrollView scrollView = (ScrollView) findViewById(R$id.scroll_view);
        this.f39947K = scrollView;
        scrollView.setOverScrollMode(0);
        C8510b.m52864a(this, this.f39944H);
        this.f39945I = (LinearLayout) findViewById(R$id.layout_loading);
        this.f39942F = (EditText) findViewById(R$id.edit_question);
        this.f39946J = (Button) findViewById(R$id.bg_dismiss);
        TextView textView = (TextView) findViewById(R$id.txt_number);
        this.f39943G = textView;
        textView.setText(String.format(getResources().getString(R$string.feedback_sdk_problem_input_number), 0, 500));
        this.f39942F.setFilters(new InputFilter[]{new InputFilter.LengthFilter(500), new AttackCharFilter()});
        this.f39942F.setOnTouchListener(new ViewOnTouchListenerC8584d());
        this.f39949M.setAdapter((ListAdapter) this.f39952P);
        this.f39949M.setNumColumns(m52745E0());
        this.f39949M.requestFocus();
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_HIDE_ADD_ATTACHMENT);
        if (sdk == null || !"Y".equals(sdk.toUpperCase(Locale.ROOT))) {
            this.f39949M.setVisibility(0);
        } else {
            this.f39949M.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        List<MediaItem> listM52748z0;
        super.onActivityResult(i10, i11, intent);
        SafeIntent safeIntent = new SafeIntent(intent);
        if (i10 != 100 || safeIntent.getData() == null || (listM52748z0 = m52748z0(safeIntent, this.f39950N)) == null) {
            return;
        }
        this.f39950N.setMedias(listM52748z0);
        this.f39952P.m52608d(listM52748z0);
        this.f39940D.m52799i(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() throws Throwable {
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f39701B.dismiss();
            return;
        }
        if (!this.f39940D.m52810y()) {
            m53123L0();
        } else {
            if (this.f39946J.getVisibility() == 0) {
                return;
            }
            m52741A0(this.f39950N);
            FaqCommonUtils.hideIme(this);
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
            m53098N0();
        } else if (view == this.f39948L) {
            mo52896j0();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        this.f39949M.setNumColumns(m52745E0());
        Button button = this.f39944H;
        if (button != null) {
            C8510b.m52864a(this, button);
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            C10343b c10343b = new C10343b(bundle);
            this.f39950N = (FeedbackBean) c10343b.m63690l("FeedbackBean");
            FaqSdk.getSdk().saveMapOnSaveInstanceState(c10343b.m63694p("CacheMap"));
        }
        super.onCreate(bundle);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        String string;
        EditText editText = (EditText) view;
        if (view.getId() == R$id.edit_question) {
            if (z10) {
                editText.setTag(editText.getHint().toString());
                string = "";
            } else {
                string = editText.getTag().toString();
            }
            editText.setHint(string);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R$menu.feedback_sdk_problem_menu_item, menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.feedback_sdk_show_history);
        View actionView = menuItemFindItem.getActionView();
        new BadgeHelper(this).m52867b(true).m52866a((ImageView) actionView.findViewById(R$id.menu_history)).setBadgeNumber(this.f39941E);
        actionView.setOnClickListener(new ViewOnClickListenerC8582b());
        if (FaqStringUtil.isEmpty(SdkProblemManager.getSdk().getSdk("accessToken"))) {
            this.f39953Q = false;
        }
        menuItemFindItem.setVisible(this.f39953Q);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: v */
    public void mo52772v(FaqConstants.FaqErrorCode faqErrorCode) throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "showError......" + faqErrorCode);
        m52880x0();
        this.f39948L.m53143g(faqErrorCode);
        this.f39948L.setVisibility(0);
        this.f39948L.setEnabled(true);
        this.f39947K.setVisibility(8);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: z */
    public void mo52758z(EnumC8594a enumC8594a) {
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: a */
    public void mo52609a(int i10) throws Throwable {
        FeedbackBean feedbackBean = this.f39950N;
        if (feedbackBean != null) {
            m52743C0(feedbackBean.getMediaItem(i10));
        }
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: b */
    public void mo52610b(int i10) throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "onDelete......" + i10);
        m52742B0(this.f39950N, i10);
        this.f39950N.remove(i10);
        this.f39952P.m52608d(this.f39950N.getMedias());
        this.f39949M.setAdapter((ListAdapter) this.f39952P);
        this.f39940D.m52799i(this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: c */
    public void mo52771c(int i10) {
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: a */
    public void mo52767a(String str) throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "submitDone......" + str);
        m52879w0();
        String problemId = TextUtils.isEmpty(this.f39950N.getProblemId()) ? str : this.f39950N.getProblemId();
        this.f39950N.setProblemId(str);
        new Thread(new RunnableC8581a(problemId)).start();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: b */
    public void mo52769b(String str) throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "uploadFileDone......" + str);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: c */
    public void mo52756c(String str) throws Throwable {
        FaqToastUtils.makeText(this, str);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: a */
    public void mo52768a(boolean z10) throws Throwable {
        FaqLogger.m51836d("ProductSuggestionActivity__", "isCompress......" + z10);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: b */
    public void mo52770b(List<C8471b> list) throws Throwable {
        m52880x0();
        this.f39947K.setVisibility(0);
        this.f39948L.setVisibility(8);
        boolean zM53124M0 = m53124M0();
        FeedbackBean feedbackBean = this.f39950N;
        if (feedbackBean != null) {
            this.f39942F.setText(feedbackBean.getProblemDesc());
            if (this.f39950N.haveMedias()) {
                this.f39940D.m52799i(this);
                this.f39952P.m52608d(this.f39950N.getMedias());
            }
        }
        if (zM53124M0) {
            m53122K0();
        }
        FaqLogger.m51836d("ProductSuggestionActivity__", "showStyles......");
    }
}
