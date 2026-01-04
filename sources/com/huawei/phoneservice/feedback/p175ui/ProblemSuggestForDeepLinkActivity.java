package com.huawei.phoneservice.feedback.p175ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
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
import com.huawei.phoneservice.feedback.R$dimen;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$plurals;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter;
import com.huawei.phoneservice.feedback.entity.C8471b;
import com.huawei.phoneservice.feedback.entity.C8474e;
import com.huawei.phoneservice.feedback.entity.FeedbackBean;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a;
import com.huawei.phoneservice.feedback.mvp.presenter.C8505a;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8510b;
import com.huawei.phoneservice.feedback.utils.EnumC8594a;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.CharInputFilter;
import com.huawei.phoneservice.feedbackcommon.utils.EmojiFilter;
import com.huawei.phoneservice.feedbackcommon.utils.FaqRegexMatches;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ProblemSuggestForDeepLinkActivity extends FeedbackBaseActivity<C8505a> implements View.OnClickListener, InterfaceC8499a, View.OnFocusChangeListener, ProblemSuggestPhotoAdapter.InterfaceC8460b {

    /* renamed from: D */
    public C8505a f39909D;

    /* renamed from: E */
    public FeedbackBean f39910E;

    /* renamed from: F */
    public TextView f39911F;

    /* renamed from: G */
    public TextView f39912G;

    /* renamed from: H */
    public TextView f39913H;

    /* renamed from: I */
    public EditText f39914I;

    /* renamed from: J */
    public ProblemSuggestPhotoAdapter f39915J;

    /* renamed from: K */
    public TextView f39916K;

    /* renamed from: L */
    public LinearLayout f39917L;

    /* renamed from: M */
    public EditText f39918M;

    /* renamed from: N */
    public Button f39919N;

    /* renamed from: O */
    public LinearLayout f39920O;

    /* renamed from: P */
    public Button f39921P;

    /* renamed from: Q */
    public FeedbackNoticeView f39922Q;

    /* renamed from: R */
    public boolean f39923R;

    /* renamed from: S */
    public ScrollView f39924S;

    /* renamed from: T */
    public GridView f39925T;

    /* renamed from: U */
    public boolean f39926U;

    /* renamed from: V */
    public String f39927V;

    /* renamed from: W */
    public String f39928W;

    /* renamed from: X */
    public String f39929X;

    /* renamed from: Y */
    public String f39930Y;

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$a */
    public class ViewOnTouchListenerC8574a implements View.OnTouchListener {
        public ViewOnTouchListenerC8574a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R$id.edit_desc && C8510b.m52865b(ProblemSuggestForDeepLinkActivity.this.f39914I)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$b */
    public class C8575b implements TextWatcher {
        public C8575b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextView textView;
            ProblemSuggestForDeepLinkActivity problemSuggestForDeepLinkActivity;
            int i10;
            if (ProblemSuggestForDeepLinkActivity.this.f39910E != null) {
                String strTrim = ProblemSuggestForDeepLinkActivity.this.f39914I.getText().toString().trim();
                ProblemSuggestForDeepLinkActivity.this.f39910E.setProblemDesc(strTrim);
                if (strTrim.length() >= 500) {
                    textView = ProblemSuggestForDeepLinkActivity.this.f39916K;
                    problemSuggestForDeepLinkActivity = ProblemSuggestForDeepLinkActivity.this;
                    i10 = R$color.feedback_sdk_problem_question_max_number;
                } else {
                    textView = ProblemSuggestForDeepLinkActivity.this.f39916K;
                    problemSuggestForDeepLinkActivity = ProblemSuggestForDeepLinkActivity.this;
                    i10 = R$color.feedback_sdk_problem_question_number;
                }
                textView.setTextColor(ContextCompat.getColor(problemSuggestForDeepLinkActivity, i10));
                ProblemSuggestForDeepLinkActivity.this.f39916K.setText(String.format(ProblemSuggestForDeepLinkActivity.this.getResources().getString(R$string.feedback_sdk_problem_input_number), Integer.valueOf(strTrim.length()), 500));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$c */
    public class C8576c implements TextWatcher {
        public C8576c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            int i10;
            if (ProblemSuggestForDeepLinkActivity.this.f39910E != null) {
                String strTrim = ProblemSuggestForDeepLinkActivity.this.f39918M.getText().toString().trim();
                if (strTrim.length() >= 100) {
                    editText = ProblemSuggestForDeepLinkActivity.this.f39918M;
                    i10 = R$drawable.feedback_sdk_problem_max_num_rectangle_bg;
                } else {
                    editText = ProblemSuggestForDeepLinkActivity.this.f39918M;
                    i10 = R$drawable.feedback_sdk_problem_rectangle_bg;
                }
                editText.setBackgroundResource(i10);
                ProblemSuggestForDeepLinkActivity.this.f39910E.setContact(strTrim);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$d */
    public class ViewOnClickListenerC8577d implements View.OnClickListener {
        public ViewOnClickListenerC8577d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestForDeepLinkActivity.this.m52879w0();
            ProblemSuggestForDeepLinkActivity.this.m53081I0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$e */
    public class ViewOnClickListenerC8578e implements View.OnClickListener {
        public ViewOnClickListenerC8578e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            ProblemSuggestForDeepLinkActivity.this.m52879w0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$f */
    public class RunnableC8579f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ SdkProblemListener f39936a;

        /* renamed from: b */
        public final /* synthetic */ String f39937b;

        /* renamed from: c */
        public final /* synthetic */ String f39938c;

        public RunnableC8579f(SdkProblemListener sdkProblemListener, String str, String str2) {
            this.f39936a = sdkProblemListener;
            this.f39937b = str;
            this.f39938c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SdkProblemListener sdkProblemListener = this.f39936a;
            if (sdkProblemListener != null) {
                sdkProblemListener.onSubmitResult(0, this.f39937b, this.f39938c, ProblemSuggestForDeepLinkActivity.this.f39910E.getSrCode(), null);
            }
            Intent intent = new Intent();
            intent.putExtra("parentProblemId", this.f39938c);
            intent.putExtra("problemId", this.f39937b);
            intent.putExtra("srCode", ProblemSuggestForDeepLinkActivity.this.f39910E.getSrCode());
            ProblemSuggestForDeepLinkActivity.this.setResult(-1, intent);
            ProblemSuggestForDeepLinkActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestForDeepLinkActivity$g */
    public static class ViewOnTouchListenerC8580g implements View.OnTouchListener {
        public ViewOnTouchListenerC8580g() {
        }

        public /* synthetic */ ViewOnTouchListenerC8580g(ViewOnTouchListenerC8574a viewOnTouchListenerC8574a) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: H0 */
    private void m53080H0() throws Throwable {
        if (!NetworkUtils.isNetworkConnected(this)) {
            this.f39921P.setVisibility(8);
            mo52756c(getResources().getString(R$string.feedback_sdk_no_network));
        } else if ((!this.f39910E.haveMedias() && 0 == this.f39910E.getLogsSize()) || NetworkUtils.isWifiConnected(this)) {
            m53081I0();
        } else {
            this.f39921P.setVisibility(8);
            m53095V0(C6661f.f30885g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public void m53081I0() throws Throwable {
        this.f39923R = true;
        this.f39910E.setProblemName(this.f39912G.getText().toString());
        try {
            this.f39910E.setAssociatedId(Long.parseLong(this.f39929X));
        } catch (NumberFormatException unused) {
            FaqLogger.print("ProblemSuggestForDeep", "NumberFormatException");
        }
        this.f39910E.setUniqueCode(this.f39930Y);
        FaqSdk.getISdk().onClick(getClass().getName(), "Submit", this.f39910E);
        this.f39909D.m52804n(this, false);
    }

    /* renamed from: J0 */
    private void m53082J0() {
        C10343b c10343b = new C10343b(new SafeIntent(getIntent()).getExtras());
        this.f39926U = "Y".equals(c10343b.m63694p("showContact"));
        this.f39927V = c10343b.m63694p("appId");
        this.f39928W = c10343b.m63694p("categoryId");
        this.f39929X = c10343b.m63694p("problemId");
        this.f39930Y = c10343b.m63694p("unicode");
    }

    /* renamed from: K0 */
    private void m53083K0() {
        CharInputFilter charInputFilter = new CharInputFilter("[&<>\"'()\"\\n\" ]");
        EmojiFilter emojiFilter = new EmojiFilter();
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(500);
        InputFilter.LengthFilter lengthFilter2 = new InputFilter.LengthFilter(100);
        this.f39914I.setFilters(new InputFilter[]{lengthFilter, new AttackCharFilter()});
        this.f39918M.setFilters(new InputFilter[]{charInputFilter, emojiFilter, lengthFilter2});
        this.f39914I.setOnFocusChangeListener(this);
        this.f39918M.setOnFocusChangeListener(this);
        this.f39918M.setOnTouchListener(new ViewOnTouchListenerC8580g(null));
        this.f39914I.setHint(getResources().getQuantityString(R$plurals.feedback_sdk_problem_question_info_update, 10, 10));
        this.f39914I.setOnTouchListener(new ViewOnTouchListenerC8574a());
    }

    /* renamed from: L0 */
    private void m53084L0() {
        this.f39919N.setEnabled(true);
    }

    /* renamed from: N0 */
    private void m53085N0() throws Throwable {
        FeedbackBean feedbackBean = this.f39910E;
        if (feedbackBean == null) {
            return;
        }
        if (TextUtils.isEmpty(feedbackBean.getProblemDesc()) || this.f39910E.getProblemDesc().trim().length() < 10) {
            mo52756c(getString(R$string.feedback_sdk_feedback_desc_hint, 10));
            return;
        }
        if (this.f39917L.getVisibility() == 0) {
            String contact = this.f39910E.getContact();
            if (TextUtils.isEmpty(contact)) {
                mo52756c(getResources().getString(R$string.feedback_sdk_problem_phone_email));
                return;
            }
            boolean zIsEmail = FaqRegexMatches.isEmail(contact);
            boolean zIsMobile = FaqRegexMatches.isMobile(contact);
            if (!zIsEmail && !zIsMobile) {
                mo52756c(getResources().getString(R$string.feedback_sdk_problem_please_check_phone_email_formatted));
                return;
            }
        }
        this.f39921P.setVisibility(0);
        m53080H0();
    }

    /* renamed from: T0 */
    private void m53090T0(int i10) {
        this.f39913H.setVisibility(0);
        this.f39913H.setText(i10);
        this.f39920O.setVisibility(0);
        this.f39919N.setEnabled(false);
    }

    /* renamed from: W0 */
    private void m53092W0(String str) throws Throwable {
        FeedbackNoticeView feedbackNoticeView = this.f39922Q;
        FaqConstants.FaqErrorCode faqErrorCode = FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR;
        feedbackNoticeView.m53143g(faqErrorCode);
        this.f39922Q.m53144h(faqErrorCode, R$drawable.ic_icon_tips_disable);
        this.f39922Q.m53151s(faqErrorCode, getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_loading_empty_icon_size));
        this.f39922Q.getNoticeTextView().setText(str);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public C8505a mo52746F0() {
        C8505a c8505a = new C8505a(this, this, this);
        this.f39909D = c8505a;
        return c8505a;
    }

    /* renamed from: P0 */
    public final void m53094P0(boolean z10, EditText editText) {
        String string;
        if (z10) {
            editText.setTag(editText.getHint().toString());
            string = "";
        } else {
            string = editText.getTag().toString();
        }
        editText.setHint(string);
    }

    /* renamed from: V0 */
    public void m53095V0(String str) throws Throwable {
        FaqLogger.m51836d("ProblemSuggestForDeep", "openUploadFlow      " + str);
        long filesSize = this.f39910E.getFilesSize();
        if (filesSize == 0) {
            filesSize = 1;
        }
        m52873q0(filesSize, new ViewOnClickListenerC8577d(), new ViewOnClickListenerC8578e());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: a */
    public void mo52754a() {
        this.f39920O.setVisibility(8);
        this.f39921P.setVisibility(8);
        m53084L0();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: b */
    public FeedbackInfo mo52755b() {
        return this.f39910E.getInfo();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8496e
    /* renamed from: c */
    public FeedbackBean mo52764c() {
        return this.f39910E;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: e */
    public void mo52757e() {
        m53090T0(R$string.feedback_sdk_common_in_submission);
        this.f39921P.setVisibility(0);
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: f */
    public void mo52611f() throws Throwable {
        m52747G0();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_deeplink;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: i0 */
    public int[] mo52895i0() {
        return new int[]{R$id.ll_channel, R$id.txt_channel, R$id.rl_description, R$id.ll_contact, R$id.edit_contact, R$id.ll_category, R$id.txt_style, R$id.ll_description};
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        setTitle(R$string.faq_sdk_feedback);
        try {
            this.f39922Q.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
            m53082J0();
            if (!FaqCommonUtils.isConnectionAvailable(this)) {
                this.f39922Q.m53143g(FaqConstants.FaqErrorCode.INTERNET_ERROR);
                return;
            }
            this.f39910E = new FeedbackBean();
            this.f39909D.m52803m(this, this.f39927V, this.f39929X, this.f39930Y);
            this.f39917L.setVisibility(this.f39926U ? 0 : 8);
        } catch (RuntimeException e10) {
            FaqLogger.print("ProblemSuggestForDeep", e10.getMessage());
            finish();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39915J.m52607c(this);
        this.f39914I.addTextChangedListener(new C8575b());
        this.f39918M.addTextChangedListener(new C8576c());
        this.f39919N.setOnClickListener(this);
        this.f39922Q.setOnClickListener(this);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        TextView textView = (TextView) findViewById(R$id.txt_style);
        this.f39912G = textView;
        textView.setSelected(true);
        TextView textView2 = (TextView) findViewById(R$id.txt_channel);
        this.f39911F = textView2;
        textView2.setSelected(true);
        this.f39914I = (EditText) findViewById(R$id.edit_question);
        this.f39916K = (TextView) findViewById(R$id.txt_number);
        this.f39913H = (TextView) findViewById(R$id.tv_progress);
        this.f39916K.setText(String.format(getResources().getString(R$string.feedback_sdk_problem_input_number), 0, 500));
        this.f39915J = new ProblemSuggestPhotoAdapter(this);
        GridView gridView = (GridView) findViewById(R$id.list_media);
        this.f39925T = gridView;
        gridView.setAdapter((ListAdapter) this.f39915J);
        this.f39925T.setNumColumns(m52745E0());
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_HIDE_ADD_ATTACHMENT);
        if (sdk == null || !"Y".equals(sdk.toUpperCase(Locale.ROOT))) {
            this.f39925T.setVisibility(0);
        } else {
            this.f39925T.setVisibility(8);
        }
        this.f39918M = (EditText) findViewById(R$id.edit_contact);
        Button button = (Button) findViewById(R$id.btn_submit);
        this.f39919N = button;
        C8510b.m52864a(this, button);
        this.f39920O = (LinearLayout) findViewById(R$id.layout_loading);
        this.f39921P = (Button) findViewById(R$id.bg_dismiss);
        ScrollView scrollView = (ScrollView) findViewById(R$id.scroll_view);
        this.f39924S = scrollView;
        scrollView.setOverScrollMode(0);
        this.f39917L = (LinearLayout) findViewById(R$id.ll_phone_or_email);
        this.f39922Q = (FeedbackNoticeView) findViewById(R$id.feedback_problem_noticeView);
        m53083K0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        List<MediaItem> listM52748z0;
        super.onActivityResult(i10, i11, intent);
        SafeIntent safeIntent = new SafeIntent(intent);
        if (safeIntent.getData() == null || i10 != 100 || (listM52748z0 = m52748z0(safeIntent, this.f39910E)) == null) {
            return;
        }
        this.f39910E.setMedias(listM52748z0);
        this.f39915J.m52608d(listM52748z0);
        this.f39909D.m52799i(this);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    public void onBackPressed(View view) throws Throwable {
        super.onBackPressed(view);
        if ("Y".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_IS_DEEPLICK))) {
            FaqLogger.print("ProblemSuggestForDeep", "ONBACKPRESSED IS DEEPLINK RELEASE");
            FaqSdk.getSdk().release();
        }
        m52741A0(this.f39910E);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        if (view.getId() == R$id.btn_submit) {
            FaqCommonUtils.hideIme(this);
            m53085N0();
        } else if (view.getId() == R$id.feedback_problem_noticeView) {
            mo52896j0();
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        this.f39925T.setNumColumns(m52745E0());
        Button button = this.f39919N;
        if (button != null) {
            C8510b.m52864a(this, button);
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            C10343b c10343b = new C10343b(bundle);
            String strM63694p = c10343b.m63694p("CacheMap");
            this.f39910E = (FeedbackBean) c10343b.m63690l("FeedbackBean");
            FaqSdk.getSdk().saveMapOnSaveInstanceState(strM63694p);
        }
        super.onCreate(bundle);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        EditText editText = (EditText) view;
        int id2 = view.getId();
        if (id2 == R$id.edit_contact || id2 == R$id.edit_desc) {
            m53094P0(z10, editText);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) throws Throwable {
        if (i10 == 4 && "Y".equals(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_IS_DEEPLICK))) {
            FaqLogger.print("ProblemSuggestForDeep", "ONKEYDOWN IS DEEPLINK RELEASE");
            FaqSdk.getSdk().release();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("FeedbackBean", this.f39910E);
        bundle.putString("CacheMap", FaqSdk.getSdk().getMapOnSaveInstance());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: v */
    public void mo52772v(FaqConstants.FaqErrorCode faqErrorCode) throws Throwable {
        FaqLogger.m51836d("ProblemSuggestForDeep", "showError      " + faqErrorCode);
        m52880x0();
        this.f39922Q.m53143g(faqErrorCode);
        this.f39922Q.setVisibility(0);
        this.f39922Q.setEnabled(true);
        this.f39924S.setVisibility(8);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: z */
    public void mo52758z(EnumC8594a enumC8594a) throws Throwable {
        FaqLogger.m51836d("ProblemSuggestForDeep", "zipCompressFinished......" + enumC8594a);
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: a */
    public void mo52609a(int i10) throws Throwable {
        FeedbackBean feedbackBean = this.f39910E;
        if (feedbackBean != null) {
            m52743C0(feedbackBean.getMediaItem(i10));
        }
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: b */
    public void mo52610b(int i10) {
        m52742B0(this.f39910E, i10);
        this.f39910E.remove(i10);
        this.f39915J.m52608d(this.f39910E.getMedias());
        this.f39925T.setAdapter((ListAdapter) this.f39915J);
        this.f39909D.m52799i(this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: c */
    public void mo52771c(int i10) throws Throwable {
        Resources resources;
        int i11;
        FaqLogger.m51836d("ProblemSuggestForDeep", "showErrorCode:" + i10);
        if (i10 == 401) {
            resources = getResources();
            i11 = R$string.feedback_sdk_lapsed;
        } else {
            if (i10 != 405) {
                mo52772v(FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
                m52880x0();
                this.f39922Q.setVisibility(0);
                this.f39922Q.setEnabled(true);
                this.f39924S.setVisibility(8);
            }
            resources = getResources();
            i11 = R$string.feedback_sdk_submit_repeated;
        }
        m53092W0(resources.getString(i11));
        m52880x0();
        this.f39922Q.setVisibility(0);
        this.f39922Q.setEnabled(true);
        this.f39924S.setVisibility(8);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: a */
    public void mo52767a(String str) throws Throwable {
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f39701B.dismiss();
        }
        mo52756c(getString(R$string.feedback_sdk_submit_successs));
        String problemId = TextUtils.isEmpty(this.f39910E.getProblemId()) ? str : this.f39910E.getProblemId();
        this.f39910E.setProblemId(str);
        SdkProblemListener sdkListener = SdkProblemManager.getManager().getSdkListener();
        this.f39919N.setEnabled(true);
        this.f39921P.setVisibility(0);
        this.f39921P.postDelayed(new RunnableC8579f(sdkListener, str, problemId), RippleView.SINGLE_RIPPLE_TIME);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: b */
    public void mo52769b(String str) throws Throwable {
        FaqLogger.m51836d("ProblemSuggestForDeep", "uploadFileDone......" + str);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: c */
    public void mo52756c(String str) throws Throwable {
        FaqToastUtils.makeText(this, str);
        Log.e("ProblemSuggestForDeep", "showToast...." + str);
        if (this.f39923R) {
            this.f39919N.setEnabled(true);
        }
        this.f39923R = false;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: a */
    public void mo52768a(boolean z10) throws Throwable {
        FaqLogger.m51836d("ProblemSuggestForDeep", "isCompress......" + z10);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: b */
    public void mo52770b(List<C8471b> list) throws Throwable {
        if (FaqStringUtil.isEmpty(ModuleConfigUtils.getChannelName())) {
            mo52772v(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
            FaqLogger.m51836d("ProblemSuggestForDeep", "channelName is NULL......");
            return;
        }
        FaqLogger.m51836d("ProblemSuggestForDeep", "showStyles......");
        this.f39911F.setText(ModuleConfigUtils.getChannelName());
        m52880x0();
        this.f39924S.setVisibility(0);
        this.f39922Q.setVisibility(8);
        if (list == null) {
            return;
        }
        ArrayList<C8471b> arrayList = new ArrayList(list);
        Iterator<C8471b> it = list.iterator();
        while (it.hasNext()) {
            for (C8474e c8474e : it.next().f39532d) {
                C8471b c8471b = new C8471b();
                c8471b.f39530b = c8474e.f39542b;
                c8471b.f39531c = c8474e.f39543c;
                c8471b.f39529a = c8474e.f39541a;
                arrayList.add(c8471b);
            }
        }
        for (C8471b c8471b2 : arrayList) {
            if (this.f39928W.equals(c8471b2.f39529a)) {
                this.f39912G.setText(c8471b2.f39530b);
                this.f39910E.setProblemType(c8471b2.f39529a, null);
                return;
            }
        }
    }
}
