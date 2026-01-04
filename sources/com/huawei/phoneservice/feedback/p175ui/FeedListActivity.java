package com.huawei.phoneservice.feedback.p175ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.FaqUiUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$dimen;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$menu;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.adapter.C8462a;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackNoMoreDrawable;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8502d;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e;
import com.huawei.phoneservice.feedback.mvp.presenter.C8507c;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import hu.C10343b;
import java.util.List;

/* loaded from: classes5.dex */
public class FeedListActivity extends FeedbackBaseActivity<InterfaceC8502d> implements InterfaceC8503e {

    /* renamed from: D */
    public C8507c f39731D;

    /* renamed from: E */
    public ListView f39732E;

    /* renamed from: F */
    public C8462a f39733F;

    /* renamed from: G */
    public FeedbackNoticeView f39734G;

    /* renamed from: H */
    public View f39735H;

    /* renamed from: I */
    public LinearLayout f39736I;

    /* renamed from: J */
    public TextView f39737J;

    /* renamed from: K */
    public Space f39738K;

    /* renamed from: L */
    public TextView f39739L;

    /* renamed from: O */
    public String f39742O;

    /* renamed from: Q */
    public int f39744Q;

    /* renamed from: M */
    public boolean f39740M = false;

    /* renamed from: N */
    public FeedbackNoMoreDrawable f39741N = null;

    /* renamed from: P */
    public boolean f39743P = false;

    /* renamed from: R */
    public int f39745R = -1;

    /* renamed from: S */
    public boolean f39746S = false;

    /* renamed from: T */
    public float f39747T = 0.0f;

    /* renamed from: U */
    public AbsListView.OnScrollListener f39748U = new C8519a();

    /* renamed from: V */
    public AdapterView.OnItemClickListener f39749V = new C8520b();

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$a */
    public class C8519a implements AbsListView.OnScrollListener {
        public C8519a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (FeedListActivity.this.m52930a1(i10) && FeedListActivity.this.f39740M) {
                FeedListActivity.this.f39740M = false;
                FeedListActivity.this.f39731D.m52852c(FeedListActivity.this.m52900I0());
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$b */
    public class C8520b implements AdapterView.OnItemClickListener {
        public C8520b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            FeedBackResponse.ProblemEnity problemEnity;
            if (!FeedListActivity.this.f39746S) {
                if (NoDoubleClickUtil.isDoubleClick(view) || (problemEnity = (FeedBackResponse.ProblemEnity) adapterView.getAdapter().getItem(i10)) == null) {
                    return;
                }
                problemEnity.setIsRead(true);
                FeedListActivity.this.f39733F.notifyDataSetChanged();
                FeedListActivity.this.f39743P = new SafeIntent(FeedListActivity.this.getIntent()).getBooleanExtra("COME_FROM", false);
                Intent intent = new Intent(FeedListActivity.this, (Class<?>) FeedDetailsActivity.class);
                intent.putExtra("questionId", problemEnity.getProblemId());
                intent.putExtra("COME_FROM", FeedListActivity.this.f39743P);
                FeedListActivity.this.startActivity(intent);
                return;
            }
            if (FeedListActivity.this.f39733F == null || FeedListActivity.this.f39733F.m52613b() == null) {
                return;
            }
            FeedListActivity.this.f39745R = i10;
            for (FeedBackResponse.ProblemEnity problemEnity2 : FeedListActivity.this.f39733F.m52613b()) {
                if (problemEnity2 != null) {
                    problemEnity2.setChecked(false);
                }
            }
            if (FeedListActivity.this.f39733F.getItem(i10) != null) {
                FeedListActivity.this.f39733F.getItem(i10).setChecked(true);
            }
            FeedListActivity.this.f39733F.notifyDataSetChanged();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$c */
    public class ViewOnClickListenerC8521c implements View.OnClickListener {
        public ViewOnClickListenerC8521c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            FeedListActivity.this.mo52896j0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$d */
    public class C8522d implements AdapterView.OnItemLongClickListener {
        public C8522d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (FeedListActivity.this.f39733F != null && FeedListActivity.this.f39733F.m52613b() != null) {
                FeedListActivity.this.f39746S = true;
                FeedListActivity.this.f39745R = i10;
                if (view != null) {
                    FeedListActivity.this.f39747T = view.getY();
                }
                FeedListActivity.this.m52931b1(i10);
                FeedListActivity.this.m52903N0();
                FeedListActivity.this.m52901L0();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$e */
    public class ViewOnClickListenerC8523e implements View.OnClickListener {
        public ViewOnClickListenerC8523e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedListActivity.this.m52902M0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$f */
    public class ViewOnClickListenerC8524f implements View.OnClickListener {
        public ViewOnClickListenerC8524f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedListActivity.this.m52929O0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$g */
    public class ViewOnClickListenerC8525g implements View.OnClickListener {
        public ViewOnClickListenerC8525g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedListActivity.this.m52744D0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$h */
    public class ViewOnClickListenerC8526h implements View.OnClickListener {
        public ViewOnClickListenerC8526h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            FeedListActivity.this.m52744D0();
            boolean zIsNetworkConnected = NetworkUtils.isNetworkConnected(FeedListActivity.this);
            FeedListActivity feedListActivity = FeedListActivity.this;
            if (zIsNetworkConnected) {
                feedListActivity.m52899H0();
            } else {
                FaqToastUtils.makeText(feedListActivity, feedListActivity.getString(R$string.feedback_sdk_no_network));
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.FeedListActivity$i */
    public class RunnableC8527i implements Runnable {
        public RunnableC8527i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView;
            int i10;
            int iDip2px;
            if (FeedListActivity.this.f39745R >= FeedListActivity.this.f39732E.getLastVisiblePosition()) {
                listView = FeedListActivity.this.f39732E;
                i10 = FeedListActivity.this.f39745R;
                iDip2px = (int) (FeedListActivity.this.f39747T - FaqUiUtils.dip2px(FeedListActivity.this.getApplicationContext(), 56.0f));
            } else {
                listView = FeedListActivity.this.f39732E;
                i10 = FeedListActivity.this.f39745R;
                iDip2px = (int) FeedListActivity.this.f39747T;
            }
            listView.setSelectionFromTop(i10, iDip2px);
        }
    }

    /* renamed from: H0 */
    public void m52899H0() {
        FeedBackResponse.ProblemEnity item;
        C8507c c8507c;
        C8462a c8462a = this.f39733F;
        if (c8462a == null || (item = c8462a.getItem(this.f39745R)) == null || TextUtils.isEmpty(item.getProblemId()) || (c8507c = this.f39731D) == null) {
            return;
        }
        c8507c.m52853d(item.getProblemId());
    }

    /* renamed from: I0 */
    public FeedBackRequest m52900I0() {
        if (!TextUtils.isEmpty(this.f39742O)) {
            this.f39732E.setOverscrollFooter(null);
            this.f39732E.addFooterView(this.f39735H);
            this.f39733F.notifyDataSetChanged();
        }
        FeedBackRequest feedBackRequest = new FeedBackRequest();
        feedBackRequest.setAccessToken(SdkProblemManager.getSdk().getSdk("accessToken"));
        feedBackRequest.setProblemId(null);
        feedBackRequest.setStartWith(this.f39742O);
        feedBackRequest.setPageSize(50);
        feedBackRequest.setProblemSourceCode(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL));
        feedBackRequest.setOrderType(this.f39744Q);
        return feedBackRequest;
    }

    /* renamed from: L0 */
    public void m52901L0() {
        ListView listView = this.f39732E;
        if (listView == null) {
            return;
        }
        listView.post(new RunnableC8527i());
    }

    /* renamed from: M0 */
    public void m52902M0() {
        C8462a c8462a = this.f39733F;
        if (c8462a == null || c8462a.m52613b() == null) {
            return;
        }
        this.f39746S = false;
        this.f39747T = 0.0f;
        for (FeedBackResponse.ProblemEnity problemEnity : this.f39733F.m52613b()) {
            if (problemEnity != null) {
                problemEnity.setSelectMode(false);
                problemEnity.setChecked(false);
            }
        }
        this.f39733F.notifyDataSetChanged();
        this.f39736I.setVisibility(8);
        invalidateOptionsMenu();
    }

    /* renamed from: N0 */
    public void m52903N0() {
        ViewGroup.LayoutParams layoutParams;
        int singleColumnWidth;
        HwColumnSystem hwColumnSystem = new HwColumnSystem(getApplicationContext());
        int totalColumnCount = hwColumnSystem.getTotalColumnCount();
        if (totalColumnCount == 4) {
            this.f39736I.setVisibility(0);
            this.f39738K.setVisibility(0);
            layoutParams = this.f39736I.getLayoutParams();
            if (layoutParams == null) {
                return;
            } else {
                singleColumnWidth = -1;
            }
        } else {
            if (totalColumnCount != 8) {
                if (totalColumnCount == 12) {
                    this.f39736I.setVisibility(8);
                    invalidateOptionsMenu();
                    return;
                }
                return;
            }
            this.f39736I.setVisibility(0);
            this.f39738K.setVisibility(8);
            layoutParams = this.f39736I.getLayoutParams();
            if (layoutParams == null) {
                return;
            } else {
                singleColumnWidth = (int) ((hwColumnSystem.getSingleColumnWidth() * 6.0f) + (hwColumnSystem.getGutter() * 5));
            }
        }
        layoutParams.width = singleColumnWidth;
    }

    /* renamed from: J0 */
    public final boolean m52927J0() {
        return new HwColumnSystem(getApplicationContext()).getTotalColumnCount() == 12;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity
    /* renamed from: K0 */
    public InterfaceC8502d mo52746F0() {
        C8507c c8507c = new C8507c(this);
        this.f39731D = c8507c;
        return c8507c;
    }

    /* renamed from: O0 */
    public final void m52929O0() {
        m52875s0(new ViewOnClickListenerC8525g(), new ViewOnClickListenerC8526h());
    }

    /* renamed from: a1 */
    public final boolean m52930a1(int i10) {
        return i10 == 0 && this.f39733F != null && this.f39732E.getLastVisiblePosition() == this.f39733F.getCount() - 1;
    }

    /* renamed from: b1 */
    public final void m52931b1(int i10) {
        C8462a c8462a = this.f39733F;
        if (c8462a == null) {
            return;
        }
        for (FeedBackResponse.ProblemEnity problemEnity : c8462a.m52613b()) {
            if (problemEnity != null) {
                problemEnity.setSelectMode(true);
                problemEnity.setChecked(false);
            }
        }
        if (this.f39733F.getItem(i10) != null) {
            this.f39733F.getItem(i10).setChecked(true);
        }
        this.f39733F.notifyDataSetChanged();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e
    public void deleteLocalData() throws Throwable {
        C8507c c8507c;
        C8462a c8462a = this.f39733F;
        if (c8462a == null) {
            return;
        }
        c8462a.m52615d(this.f39745R);
        m52902M0();
        if (this.f39733F.getCount() < 50 && this.f39742O != null && (c8507c = this.f39731D) != null) {
            c8507c.m52852c(m52900I0());
        } else if (this.f39733F.getCount() <= 0) {
            setErrorView(FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR);
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_feedlist;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        this.f39734G.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
        this.f39734G.setEnabled(false);
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            setErrorView(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            this.f39734G.setEnabled(true);
            return;
        }
        this.f39742O = null;
        this.f39740M = false;
        try {
            this.f39744Q = Integer.valueOf(SdkProblemManager.getSdk().getSdk(FaqConstants.FEEDBACK_ODERTYPE)).intValue();
        } catch (NumberFormatException e10) {
            this.f39744Q = 3;
            FaqLogger.print("FeedListActivity", e10.getMessage());
        }
        this.f39731D.m52851b(this);
        this.f39731D.m52852c(m52900I0());
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39732E.setOnScrollListener(this.f39748U);
        this.f39732E.setOnItemClickListener(this.f39749V);
        this.f39734G.setOnClickListener(new ViewOnClickListenerC8521c());
        this.f39732E.setOnItemLongClickListener(new C8522d());
        this.f39737J.setOnClickListener(new ViewOnClickListenerC8523e());
        this.f39739L.setOnClickListener(new ViewOnClickListenerC8524f());
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() {
        setTitle(getResources().getString(R$string.feedback_sdk_question_history_title));
        this.f39732E = (ListView) findViewById(R$id.lv_feedlist);
        this.f39734G = (FeedbackNoticeView) findViewById(R$id.noticeview_feedlist);
        this.f39736I = (LinearLayout) findViewById(R$id.feed_list_option_host);
        this.f39737J = (TextView) findViewById(R$id.feed_list_tv_cancel);
        this.f39738K = (Space) findViewById(R$id.feed_list_space);
        this.f39739L = (TextView) findViewById(R$id.feed_list_tv_delete);
        C8462a c8462a = new C8462a();
        this.f39733F = c8462a;
        this.f39732E.setAdapter((ListAdapter) c8462a);
        this.f39735H = LayoutInflater.from(this).inflate(R$layout.feedback_sdk_list_footer_layout, (ViewGroup) null);
        this.f39741N = new FeedbackNoMoreDrawable(this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e
    /* renamed from: n */
    public void mo52778n(List<FeedBackResponse.ProblemEnity> list, List<FeedBackResponse.ProblemEnity> list2) {
        boolean z10;
        for (FeedBackResponse.ProblemEnity problemEnity : list2) {
            if (problemEnity != null) {
                problemEnity.setSelectMode(this.f39746S);
            }
        }
        this.f39734G.setVisibility(8);
        if (TextUtils.isEmpty(this.f39742O)) {
            this.f39733F.setResource(list2);
        } else {
            this.f39733F.appendToList(list2);
        }
        if (list.size() >= 50) {
            this.f39742O = list.get(49).getProblemId();
            z10 = true;
        } else {
            this.f39742O = null;
            z10 = false;
        }
        this.f39740M = z10;
        if (this.f39732E.getFooterViewsCount() > 0) {
            this.f39732E.removeFooterView(this.f39735H);
        }
        if (TextUtils.isEmpty(this.f39742O)) {
            this.f39732E.setOverscrollFooter(this.f39741N);
        }
        this.f39733F.notifyDataSetChanged();
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        if (this.f39746S) {
            invalidateOptionsMenu();
            m52903N0();
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            FaqSdk.getSdk().saveMapOnSaveInstanceState(new C10343b(bundle).m63694p("CacheMap"));
        }
        super.onCreate(bundle);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            return true;
        }
        if (menuItem.getItemId() == R$id.menu_feed_list_cancel) {
            m52902M0();
        }
        if (menuItem.getItemId() == R$id.menu_feed_list_delete) {
            m52929O0();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f39746S && m52927J0()) {
            menu.clear();
            getMenuInflater().inflate(R$menu.feedback_sdk_feed_list_menu_item, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("CacheMap", FaqSdk.getSdk().getMapOnSaveInstance());
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e
    public void setErrorView(FaqConstants.FaqErrorCode faqErrorCode) throws Throwable {
        if (!TextUtils.isEmpty(this.f39742O)) {
            this.f39732E.removeFooterView(this.f39735H);
            this.f39740M = false;
            return;
        }
        FaqConstants.FaqErrorCode faqErrorCode2 = FaqConstants.FaqErrorCode.EMPTY_DATA_ERROR;
        if (faqErrorCode2.equals(faqErrorCode)) {
            this.f39734G.m53144h(faqErrorCode2, R$drawable.feedback_sdk_ic_no_search_result);
            this.f39734G.m53143g(faqErrorCode2);
            this.f39734G.m53151s(faqErrorCode2, getResources().getDimensionPixelOffset(R$dimen.feedback_sdk_loading_empty_icon_size));
            this.f39734G.setShouldHideContactUsButton(true);
            this.f39734G.getNoticeTextView().setText(getResources().getString(R$string.faq_sdk_data_error_text));
        } else {
            this.f39734G.m53143g(faqErrorCode);
        }
        this.f39734G.setEnabled(true);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e
    public void setThrowableView(Throwable th2) throws Throwable {
        if (TextUtils.isEmpty(this.f39742O)) {
            this.f39734G.m53147l(th2);
            this.f39734G.setEnabled(true);
        } else {
            this.f39732E.removeFooterView(this.f39735H);
            this.f39740M = false;
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8503e
    public void showErrorToast() throws Throwable {
        FaqToastUtils.makeText(this, getString(R$string.feedback_sdk_common_server_disconnected_toast));
    }
}
