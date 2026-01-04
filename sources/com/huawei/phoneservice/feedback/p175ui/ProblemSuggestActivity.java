package com.huawei.phoneservice.feedback.p175ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.util.AttackCharFilter;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import com.huawei.phoneservice.faq.base.util.FaqToastUtils;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.faq.base.util.NoDoubleClickUtil;
import com.huawei.phoneservice.feedback.R$color;
import com.huawei.phoneservice.feedback.R$drawable;
import com.huawei.phoneservice.feedback.R$id;
import com.huawei.phoneservice.feedback.R$layout;
import com.huawei.phoneservice.feedback.R$menu;
import com.huawei.phoneservice.feedback.R$plurals;
import com.huawei.phoneservice.feedback.R$string;
import com.huawei.phoneservice.feedback.adapter.C8467f;
import com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter;
import com.huawei.phoneservice.feedback.entity.C8471b;
import com.huawei.phoneservice.feedback.entity.C8474e;
import com.huawei.phoneservice.feedback.entity.FeedbackBean;
import com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a;
import com.huawei.phoneservice.feedback.mvp.presenter.C8505a;
import com.huawei.phoneservice.feedback.photolibrary.internal.utils.C8510b;
import com.huawei.phoneservice.feedback.photolibrary.internal.widget.BadgeHelper;
import com.huawei.phoneservice.feedback.utils.EnumC8594a;
import com.huawei.phoneservice.feedback.widget.AutoLineLayoutManager;
import com.huawei.phoneservice.feedback.widget.FeedbackNoticeView;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.entity.ProblemInfo;
import com.huawei.phoneservice.feedbackcommon.entity.QueryIsoLanguageResponse;
import com.huawei.phoneservice.feedbackcommon.entity.QueryNoticeResponse;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import com.huawei.phoneservice.feedbackcommon.utils.CharInputFilter;
import com.huawei.phoneservice.feedbackcommon.utils.EmojiFilter;
import com.huawei.phoneservice.feedbackcommon.utils.FaqRegexMatches;
import com.huawei.phoneservice.feedbackcommon.utils.FeedbackCommonManager;
import com.huawei.phoneservice.feedbackcommon.utils.NetworkUtils;
import com.huawei.phoneservice.feedbackcommon.utils.OnReadListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemListener;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import com.huawei.phoneservice.feedbackcommon.utils.UriDeserializer;
import com.huawei.phoneservice.feedbackcommon.utils.UriSerializer;
import com.huawei.phoneservice.feedbackcommon.utils.ZipUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ProblemSuggestActivity extends FeedbackBaseActivity<C8505a> implements View.OnClickListener, InterfaceC8499a, View.OnFocusChangeListener, ProblemSuggestPhotoAdapter.InterfaceC8460b {

    /* renamed from: D */
    public C8505a f39832D;

    /* renamed from: E */
    public AsCache f39833E;

    /* renamed from: F */
    public FeedbackBean f39834F;

    /* renamed from: M */
    public TextView f39841M;

    /* renamed from: N */
    public TextView f39842N;

    /* renamed from: O */
    public TextView f39843O;

    /* renamed from: P */
    public LinearLayout f39844P;

    /* renamed from: Q */
    public TextView f39845Q;

    /* renamed from: R */
    public RecyclerView f39846R;

    /* renamed from: S */
    public C8467f f39847S;

    /* renamed from: T */
    public EditText f39848T;

    /* renamed from: U */
    public ProblemSuggestPhotoAdapter f39849U;

    /* renamed from: V */
    public TextView f39850V;

    /* renamed from: W */
    public LinearLayout f39851W;

    /* renamed from: X */
    public EditText f39852X;

    /* renamed from: Y */
    public RelativeLayout f39853Y;

    /* renamed from: Z */
    public CheckBox f39854Z;

    /* renamed from: a0 */
    public TextView f39855a0;

    /* renamed from: b0 */
    public Button f39856b0;

    /* renamed from: c0 */
    public TextView f39857c0;

    /* renamed from: d0 */
    public LinearLayout f39858d0;

    /* renamed from: e0 */
    public Button f39859e0;

    /* renamed from: f0 */
    public FeedbackNoticeView f39860f0;

    /* renamed from: g0 */
    public boolean f39861g0;

    /* renamed from: h0 */
    public boolean f39862h0;

    /* renamed from: i0 */
    public boolean f39863i0;

    /* renamed from: j0 */
    public boolean f39864j0;

    /* renamed from: k0 */
    public boolean f39865k0;

    /* renamed from: l0 */
    public boolean f39866l0;

    /* renamed from: m0 */
    public ScrollView f39867m0;

    /* renamed from: n0 */
    public GridView f39868n0;

    /* renamed from: o0 */
    public boolean f39869o0;

    /* renamed from: p0 */
    public boolean f39870p0;

    /* renamed from: q0 */
    public boolean f39871q0;

    /* renamed from: r0 */
    public boolean f39872r0;

    /* renamed from: s0 */
    public boolean f39873s0;

    /* renamed from: u0 */
    public boolean f39875u0;

    /* renamed from: G */
    public int f39835G = 0;

    /* renamed from: H */
    public boolean f39836H = false;

    /* renamed from: I */
    public boolean f39837I = false;

    /* renamed from: J */
    public boolean f39838J = false;

    /* renamed from: K */
    public boolean f39839K = true;

    /* renamed from: L */
    public int f39840L = 0;

    /* renamed from: t0 */
    public int f39874t0 = 10;

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$a */
    public static class ViewOnTouchListenerC8547a implements View.OnTouchListener {
        public ViewOnTouchListenerC8547a() {
        }

        public /* synthetic */ ViewOnTouchListenerC8547a(C8559l c8559l) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$a0 */
    public class DialogInterfaceOnClickListenerC8548a0 implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ List f39876a;

        public DialogInterfaceOnClickListenerC8548a0(List list) {
            this.f39876a = list;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            TextView textView;
            String str;
            List list = this.f39876a;
            if (list == null || i10 < 0 || i10 >= list.size()) {
                return;
            }
            C8471b c8471b = (C8471b) this.f39876a.get(i10);
            boolean z10 = !c8471b.f39529a.equals(ProblemSuggestActivity.this.f39834F.getParentId());
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            List<C8474e> list2 = c8471b.f39532d;
            if (list2 != null && list2.size() > 0) {
                ProblemSuggestActivity.this.m53074l1(c8471b);
                return;
            }
            if (z10) {
                ProblemSuggestActivity.this.f39834F.setProblemType(c8471b.f39529a, null);
                textView = ProblemSuggestActivity.this.f39842N;
                str = c8471b.f39530b;
            } else {
                ProblemSuggestActivity.this.f39834F.setProblemType(null, null);
                textView = ProblemSuggestActivity.this.f39842N;
                str = "";
            }
            textView.setText(str);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$b */
    public class DialogInterfaceOnClickListenerC8549b implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ C8471b f39878a;

        public DialogInterfaceOnClickListenerC8549b(C8471b c8471b) {
            this.f39878a = c8471b;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            TextView textView;
            String str;
            C8474e c8474e = this.f39878a.f39532d.get(i10);
            boolean z10 = !c8474e.f39541a.equals(ProblemSuggestActivity.this.f39834F.getChildId());
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            FeedbackBean feedbackBean = ProblemSuggestActivity.this.f39834F;
            if (z10) {
                feedbackBean.setProblemType(this.f39878a.f39529a, c8474e.f39541a);
                textView = ProblemSuggestActivity.this.f39842N;
                str = c8474e.f39542b;
            } else {
                feedbackBean.setProblemType(null, null);
                textView = ProblemSuggestActivity.this.f39842N;
                str = "";
            }
            textView.setText(str);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$c */
    public class ViewOnClickListenerC8550c implements View.OnClickListener {
        public ViewOnClickListenerC8550c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestActivity.this.m52744D0();
            ProblemSuggestActivity.this.m53015P0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$d */
    public class ViewOnClickListenerC8551d implements View.OnClickListener {
        public ViewOnClickListenerC8551d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog = ProblemSuggestActivity.this.f39701B;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$e */
    public class ViewOnClickListenerC8552e implements View.OnClickListener {
        public ViewOnClickListenerC8552e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestActivity.this.m52744D0();
            ProblemSuggestActivity.this.f39865k0 = true;
            FaqLogger.m51836d("ProblemSuggestActivity_", "break submit " + ProblemSuggestActivity.this.f39834F.getLogsSize() + " " + ProblemSuggestActivity.this.f39834F.getShowLog() + " " + ProblemSuggestActivity.this.f39861g0);
            if (!ProblemSuggestActivity.this.f39834F.getShowLog()) {
                ProblemSuggestActivity.this.m53015P0();
            } else {
                ProblemSuggestActivity.this.f39859e0.setVisibility(0);
                ProblemSuggestActivity.this.m53065b1();
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$f */
    public class ViewOnClickListenerC8553f implements View.OnClickListener {
        public ViewOnClickListenerC8553f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestActivity.this.m53012N0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$g */
    public class ViewOnClickListenerC8554g implements View.OnClickListener {
        public ViewOnClickListenerC8554g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestActivity.this.m52744D0();
            ProblemSuggestActivity.this.f39832D.m52796I();
            FaqSdk.getISdk().onClick(ProblemSuggestActivity.this.getClass().getName(), "Quit", ProblemSuggestActivity.this.f39834F);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$h */
    public class ViewOnClickListenerC8555h implements View.OnClickListener {
        public ViewOnClickListenerC8555h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestActivity.this.m52744D0();
            ProblemSuggestActivity.this.f39832D.m52795G();
            FaqSdk.getISdk().onClick(ProblemSuggestActivity.this.getClass().getName(), "Cancel", ProblemSuggestActivity.this.f39834F);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$i */
    public class RunnableC8556i implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ SdkProblemListener f39886a;

        /* renamed from: b */
        public final /* synthetic */ String f39887b;

        /* renamed from: c */
        public final /* synthetic */ String f39888c;

        public RunnableC8556i(SdkProblemListener sdkProblemListener, String str, String str2) {
            this.f39886a = sdkProblemListener;
            this.f39887b = str;
            this.f39888c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SdkProblemListener sdkProblemListener = this.f39886a;
            if (sdkProblemListener != null) {
                sdkProblemListener.onSubmitResult(0, this.f39887b, this.f39888c, ProblemSuggestActivity.this.f39834F.getSrCode(), null);
            }
            if (!FaqStringUtil.isEmpty(SdkProblemManager.getSdk().getSdk("accessToken")) && ProblemSuggestActivity.this.f39840L == 0) {
                ProblemSuggestActivity.this.m53057L1(this.f39887b);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("parentProblemId", this.f39888c);
            intent.putExtra("problemId", this.f39887b);
            intent.putExtra("srCode", ProblemSuggestActivity.this.f39834F.getSrCode());
            ProblemSuggestActivity.this.setResult(-1, intent);
            if (ProblemSuggestActivity.this.f39833E != null) {
                ProblemSuggestActivity.this.f39833E.remove("feedBackCache");
            }
            ProblemSuggestActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$j */
    public class C8557j implements OnReadListener {
        public C8557j() {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnReadListener
        public void read(Throwable th2, String str) {
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.OnReadListener
        public void unread(Throwable th2, String str, int i10) {
            ProblemSuggestActivity.this.f39835G = i10;
            ProblemSuggestActivity.this.invalidateOptionsMenu();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$k */
    public class C8558k implements C8467f.c {

        /* renamed from: a */
        public final /* synthetic */ List f39891a;

        public C8558k(List list) {
            this.f39891a = list;
        }

        @Override // com.huawei.phoneservice.feedback.adapter.C8467f.c
        /* renamed from: a */
        public void mo52631a(int i10) {
            TextView textView;
            String str;
            if (i10 < 0) {
                ProblemSuggestActivity.this.f39834F.setProblemType(null, null);
                textView = ProblemSuggestActivity.this.f39842N;
                str = "";
            } else {
                C8471b c8471b = (C8471b) this.f39891a.get(i10);
                ProblemSuggestActivity.this.f39834F.setProblemType(c8471b.f39529a, null);
                textView = ProblemSuggestActivity.this.f39842N;
                str = c8471b.f39530b;
            }
            textView.setText(str);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$l */
    public class C8559l implements CompoundButton.OnCheckedChangeListener {
        public C8559l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            ProblemSuggestActivity.this.f39861g0 = z10;
            if (!z10) {
                ProblemSuggestActivity.this.f39863i0 = true;
                ProblemSuggestActivity.this.f39857c0.setVisibility(8);
                ProblemSuggestActivity.this.f39845Q.setVisibility(8);
                ProblemSuggestActivity.this.f39858d0.setVisibility(8);
                ProblemSuggestActivity.this.m53062Y0();
                ProblemSuggestActivity.this.f39866l0 = false;
            }
            ProblemSuggestActivity problemSuggestActivity = ProblemSuggestActivity.this;
            problemSuggestActivity.f39864j0 = (problemSuggestActivity.f39862h0 && !ProblemSuggestActivity.this.f39863i0) || ProblemSuggestActivity.this.f39866l0 || ProblemSuggestActivity.this.f39865k0;
            ProblemSuggestActivity.this.f39834F.setShowLog(z10);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$m */
    public class RunnableC8560m implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ EnumC8594a f39894a;

        public RunnableC8560m(EnumC8594a enumC8594a) {
            this.f39894a = enumC8594a;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ProblemSuggestActivity.this.f39858d0.setVisibility(8);
            boolean z10 = true;
            ProblemSuggestActivity.this.f39856b0.setEnabled(true);
            EnumC8594a enumC8594a = this.f39894a;
            EnumC8594a enumC8594a2 = EnumC8594a.ZIP_COMPRESS_SUCCESS;
            if ((enumC8594a != enumC8594a2 || !ProblemSuggestActivity.this.f39869o0) && (this.f39894a != enumC8594a2 || (!ProblemSuggestActivity.this.f39865k0 && !ProblemSuggestActivity.this.f39866l0))) {
                z10 = false;
            }
            if (this.f39894a != EnumC8594a.ZIP_COMPRESS_FAILED) {
                if (z10) {
                    ProblemSuggestActivity.this.m53073j1();
                    return;
                }
                return;
            }
            ProblemSuggestActivity.this.f39859e0.setVisibility(8);
            if (ProblemSuggestActivity.this.f39861g0) {
                if (ProblemSuggestActivity.this.f39865k0 || ((ProblemSuggestActivity.this.f39862h0 && !ProblemSuggestActivity.this.f39863i0) || ProblemSuggestActivity.this.f39866l0)) {
                    ProblemSuggestActivity.this.f39856b0.setEnabled(false);
                    ProblemSuggestActivity.this.f39857c0.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$n */
    public class RunnableC8561n implements Runnable {
        public RunnableC8561n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProblemSuggestActivity.this.f39839K = true;
            ProblemSuggestActivity.this.f39832D.m52797J();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$o */
    public class RunnableC8562o implements Runnable {
        public RunnableC8562o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProblemSuggestActivity.this.f39839K = true;
            ProblemSuggestActivity.this.f39832D.m52797J();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$p */
    public class ViewOnClickListenerC8563p implements View.OnClickListener {
        public ViewOnClickListenerC8563p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            if (NoDoubleClickUtil.isDoubleClick(view) || (alertDialog = ProblemSuggestActivity.this.f39701B) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$q */
    public class ViewOnClickListenerC8564q implements View.OnClickListener {
        public ViewOnClickListenerC8564q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view) || ProblemSuggestActivity.this.f39834F == null) {
                return;
            }
            if (ProblemSuggestActivity.this.f39833E != null) {
                ProblemSuggestActivity.this.f39833E.remove("feedBackCache");
            }
            ProblemSuggestActivity.this.m53019R0();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$r */
    public class ViewOnClickListenerC8565r implements View.OnClickListener {
        public ViewOnClickListenerC8565r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Throwable {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            ProblemSuggestActivity.this.m53010L0();
            ProblemSuggestActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$s */
    public class ViewOnClickListenerC8566s implements View.OnClickListener {
        public ViewOnClickListenerC8566s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view)) {
                return;
            }
            if (ProblemSuggestActivity.this.f39833E != null) {
                ProblemSuggestActivity.this.f39833E.remove("feedBackCache");
            }
            ProblemSuggestActivity problemSuggestActivity = ProblemSuggestActivity.this;
            problemSuggestActivity.m52741A0(problemSuggestActivity.f39834F);
            ProblemSuggestActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$t */
    public class ViewOnClickListenerC8567t implements View.OnClickListener {
        public ViewOnClickListenerC8567t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProblemSuggestActivity.this.f39854Z.setChecked(!ProblemSuggestActivity.this.f39854Z.isChecked());
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$u */
    public class ViewOnTouchListenerC8568u implements View.OnTouchListener {
        public ViewOnTouchListenerC8568u() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R$id.edit_desc && C8510b.m52865b(ProblemSuggestActivity.this.f39848T)) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$v */
    public class C8569v implements TextWatcher {
        public C8569v() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (ProblemSuggestActivity.this.f39834F != null) {
                String strTrim = ProblemSuggestActivity.this.f39848T.getText().toString().trim();
                ProblemSuggestActivity.this.f39834F.setProblemDesc(strTrim);
                int length = strTrim.length();
                ProblemSuggestActivity.this.f39850V.setTextColor(ContextCompat.getColor(ProblemSuggestActivity.this, length >= 500 ? R$color.feedback_sdk_problem_question_max_number : R$color.feedback_sdk_problem_question_number));
                ProblemSuggestActivity.this.f39850V.setText(String.format(ProblemSuggestActivity.this.getResources().getString(R$string.feedback_sdk_problem_input_number), Integer.valueOf(length), 500));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$w */
    public class C8570w implements TextWatcher {
        public C8570w() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            int i10;
            if (ProblemSuggestActivity.this.f39834F != null) {
                String strTrim = ProblemSuggestActivity.this.f39852X.getText().toString().trim();
                if (strTrim.length() >= 100) {
                    editText = ProblemSuggestActivity.this.f39852X;
                    i10 = R$drawable.feedback_sdk_problem_max_num_rectangle_bg;
                } else {
                    editText = ProblemSuggestActivity.this.f39852X;
                    i10 = R$drawable.feedback_sdk_problem_rectangle_bg;
                }
                editText.setBackgroundResource(i10);
                ProblemSuggestActivity.this.f39834F.setContact(strTrim);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$x */
    public class C8571x extends FaqCallback<QueryIsoLanguageResponse> {
        public C8571x(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2, QueryIsoLanguageResponse queryIsoLanguageResponse) {
            if (th2 == null && queryIsoLanguageResponse != null) {
                String langCode = queryIsoLanguageResponse.getLangCode();
                if (!TextUtils.isEmpty(langCode)) {
                    ProblemSuggestActivity.this.m53005H1(langCode);
                    return;
                }
            }
            ProblemSuggestActivity.this.f39855a0.setVisibility(8);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$y */
    public class C8572y extends FaqCallback<QueryNoticeResponse> {
        public C8572y(Class cls, Activity activity) {
            super(cls, activity);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onResult(java.lang.Throwable r1, com.huawei.phoneservice.feedbackcommon.entity.QueryNoticeResponse r2) {
            /*
                r0 = this;
                if (r1 != 0) goto L30
                if (r2 == 0) goto L30
                java.lang.String r1 = r2.getContent()
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 == 0) goto Lf
                goto L30
            Lf:
                com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity r2 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.this
                android.widget.TextView r2 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.m53013N1(r2)
                android.text.Spanned r1 = android.text.Html.fromHtml(r1)
                r2.setText(r1)
                com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity r1 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.this
                android.widget.TextView r1 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.m53013N1(r1)
                com.huawei.phoneservice.feedback.widget.ClickUrlSpan.m53128a(r1)
                com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity r0 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.this
                android.widget.TextView r0 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.m53013N1(r0)
                r1 = 0
            L2c:
                r0.setVisibility(r1)
                goto L39
            L30:
                com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity r0 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.this
                android.widget.TextView r0 = com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.m53013N1(r0)
                r1 = 8
                goto L2c
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.p175ui.ProblemSuggestActivity.C8572y.onResult(java.lang.Throwable, com.huawei.phoneservice.feedbackcommon.entity.QueryNoticeResponse):void");
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.ui.ProblemSuggestActivity$z */
    public class ViewOnClickListenerC8573z implements View.OnClickListener {
        public ViewOnClickListenerC8573z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NoDoubleClickUtil.isDoubleClick(view) || !ProblemSuggestActivity.this.f39832D.m52810y() || ProblemSuggestActivity.this.f39859e0.getVisibility() == 0) {
                return;
            }
            ProblemSuggestActivity.this.f39835G = 0;
            ProblemSuggestActivity.this.invalidateOptionsMenu();
            ProblemSuggestActivity.this.startActivity(new Intent(ProblemSuggestActivity.this, (Class<?>) FeedListActivity.class));
            FaqSdk.getISdk().onClick(ProblemSuggestActivity.this.getClass().getName(), "Click", ProblemSuggestActivity.this.f39834F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H1 */
    public void m53005H1(String str) {
        FeedbackCommonManager.INSTANCE.queryNotice(this, str, new C8572y(QueryNoticeResponse.class, this));
    }

    /* renamed from: K0 */
    private void m53008K0() throws Throwable {
        this.f39859e0.setVisibility(0);
        if (this.f39839K && this.f39861g0) {
            this.f39865k0 = true;
            m53051z1(R$string.feedback_sdk_zipcompressing);
            return;
        }
        if (this.f39837I && this.f39861g0) {
            this.f39859e0.setVisibility(8);
            this.f39865k0 = false;
            mo52756c(getResources().getString(R$string.feedback_sdk_zipcompressfailed));
            this.f39857c0.setVisibility(0);
            this.f39856b0.setEnabled(false);
            return;
        }
        if (!NetworkUtils.isNetworkConnected(this)) {
            this.f39859e0.setVisibility(8);
            mo52756c(getResources().getString(R$string.feedback_sdk_no_network));
        } else if ((!this.f39834F.haveMedias() && (0 == this.f39834F.getLogsSize() || !this.f39861g0)) || NetworkUtils.isWifiConnected(this)) {
            m53015P0();
        } else {
            this.f39859e0.setVisibility(8);
            m53053D1(C6661f.f30885g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public void m53010L0() throws Throwable {
        Gson gsonCreate = new GsonBuilder().registerTypeAdapter(Uri.class, new UriSerializer()).create();
        FeedbackBean feedbackBean = this.f39834F;
        if (feedbackBean != null) {
            feedbackBean.setContact("");
        }
        AsCache asCache = this.f39833E;
        if (asCache != null) {
            asCache.put(this, "feedBackCache", gsonCreate.toJson(this.f39834F));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public void m53012N0() throws Throwable {
        FeedbackBean feedbackBean;
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        m52741A0(this.f39834F);
        String srCode = this.f39834F.getSrCode();
        AsCache asCache = this.f39833E;
        if (asCache != null) {
            asCache.remove(TextUtils.isEmpty(srCode) ? "lastSubmit" : "lastSubmit_srCode");
        }
        if (this.f39853Y.getVisibility() == 0) {
            this.f39854Z.setChecked(this.f39834F.getShowLog());
        }
        if (TextUtils.isEmpty(this.f39834F.getSrCode())) {
            C8467f c8467f = this.f39847S;
            if (c8467f != null) {
                c8467f.m52628H(-1);
            }
            this.f39842N.setText("");
            feedbackBean = new FeedbackBean();
        } else {
            String problemId = this.f39834F.getProblemId();
            String problemType = this.f39834F.getProblemType();
            feedbackBean = new FeedbackBean(srCode, problemId, problemType, problemType, this.f39834F.getProblemName());
        }
        this.f39834F = feedbackBean;
        this.f39832D.m52792A();
        this.f39834F.setShowLog(this.f39862h0);
        this.f39854Z.setChecked(this.f39862h0);
        FaqLogger.m51836d("ProblemSuggestActivity_", "break cancel " + this.f39834F.getLogsSize() + " " + this.f39834F.getShowLog() + " " + this.f39861g0);
        m53056I1(this.f39832D.m52793C());
        this.f39869o0 = false;
        if (this.f39834F.getShowLog()) {
            m53065b1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public void m53015P0() throws Throwable {
        this.f39865k0 = true;
        Gson gsonCreate = this.f39834F.haveMedias() ? new GsonBuilder().registerTypeAdapter(Uri.class, new UriSerializer()).create() : new Gson();
        this.f39834F.setProblemName((this.f39840L == 2 ? this.f39843O : this.f39842N).getText().toString());
        String srCode = this.f39834F.getSrCode();
        AsCache asCache = this.f39833E;
        if (asCache != null) {
            asCache.put(TextUtils.isEmpty(srCode) ? "lastSubmit" : "lastSubmit_srCode", gsonCreate.toJson(this.f39834F), 172800);
        }
        FaqSdk.getISdk().onClick(getClass().getName(), "Submit", this.f39834F);
        this.f39832D.m52798h(0, 0);
        this.f39832D.m52804n(this, this.f39861g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public void m53019R0() {
        this.f39834F.setParentId("");
        this.f39834F.setChildId("");
        this.f39834F.setProblemDesc("");
        m52741A0(this.f39834F);
        List<MediaItem> medias = this.f39834F.getMedias();
        if (medias != null) {
            medias.clear();
        }
        this.f39832D.m52792A();
        this.f39834F.setContact("");
        this.f39834F.setShowLog(this.f39862h0);
        C8467f c8467f = this.f39847S;
        if (c8467f != null) {
            c8467f.m52628H(-1);
        }
        this.f39842N.setText("");
        this.f39848T.setText(this.f39834F.getProblemDesc());
        this.f39849U.m52608d(this.f39834F.getMedias());
        this.f39852X.setText(this.f39834F.getContact());
        this.f39854Z.setChecked(this.f39834F.getShowLog());
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: T0 */
    private void m53023T0() {
        if (!ModuleConfigUtils.feedbackLogEnabled() || !ModuleConfigUtils.feedbackNoticeEnabled()) {
            this.f39855a0.setVisibility(8);
            return;
        }
        String lowerCase = Locale.getDefault().getLanguage().toLowerCase(Locale.ENGLISH);
        if ("zh".equals(lowerCase)) {
            lowerCase = Locale.getDefault().toLanguageTag().contains("zh-Hant") ? "zh-tw" : FeedbackConst.SDK.EMUI_LANGUAGE;
        }
        FeedbackCommonManager.INSTANCE.queryIsoLanguage(this, lowerCase, new C8571x(QueryIsoLanguageResponse.class, this));
    }

    /* renamed from: U0 */
    private void m53025U0() {
        SdkProblemManager.getManager().getUnread(this, "", new C8557j());
    }

    /* renamed from: W0 */
    private void m53028W0() {
        this.f39848T.addTextChangedListener(new C8569v());
        this.f39852X.addTextChangedListener(new C8570w());
    }

    /* renamed from: z1 */
    private void m53051z1(int i10) {
        this.f39845Q.setVisibility(0);
        this.f39845Q.setText(i10);
        this.f39858d0.setVisibility(0);
        this.f39856b0.setEnabled(false);
    }

    /* renamed from: B1 */
    public final boolean m53052B1(List<C8471b> list) {
        if (list == null) {
            return false;
        }
        for (C8471b c8471b : list) {
            if (c8471b != null && !FaqCommonUtils.isEmpty(c8471b.f39532d) && c8471b.f39532d.size() > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: D1 */
    public void m53053D1(String str) {
        long filesSize = this.f39861g0 ? this.f39834F.getFilesSize() + this.f39834F.getLogsSize() : this.f39834F.getFilesSize();
        if (filesSize == 0) {
            filesSize = 1;
        }
        m52873q0(filesSize, new ViewOnClickListenerC8550c(), new ViewOnClickListenerC8551d());
    }

    /* renamed from: E1 */
    public void m53054E1(List<C8471b> list) {
        int size = list == null ? 0 : list.size();
        String[] strArr = new String[size];
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = list.get(i11).f39530b;
            if (list.get(i11).f39529a.equals(this.f39834F.getParentId())) {
                i10 = i11;
            }
        }
        m52874r0(this, getString(R$string.feedback_sdk_problem_type), getString(R$string.feedback_sdk_common_cancel), strArr, i10, new DialogInterfaceOnClickListenerC8548a0(list));
    }

    /* renamed from: I0 */
    public final boolean m53055I0() {
        FeedbackBean feedbackBean;
        return (this.f39840L != 0 || (feedbackBean = this.f39834F) == null || ((this.f39873s0 || TextUtils.isEmpty(feedbackBean.getParentId())) && TextUtils.isEmpty(this.f39834F.getProblemDesc()) && !this.f39834F.haveMedias())) ? false : true;
    }

    /* renamed from: I1 */
    public final void m53056I1(List<C8471b> list) {
        if (TextUtils.isEmpty(this.f39834F.getSrCode())) {
            this.f39841M.setVisibility(0);
            this.f39843O.setVisibility(8);
            if (m53052B1(list)) {
                if (this.f39840L == 1) {
                    m53077w1(list);
                }
                m53059O1(list);
            } else {
                m53058M1(list);
            }
            if (!TextUtils.isEmpty(this.f39834F.getProblemId())) {
                this.f39836H = false;
                invalidateOptionsMenu();
            } else if (!FaqStringUtil.isEmpty(SdkProblemManager.getSdk().getSdk("accessToken")) && ModuleConfigUtils.feedbackHistoryEnabled()) {
                this.f39836H = true;
                invalidateOptionsMenu();
                if (this.f39835G <= 0) {
                    m53025U0();
                }
            }
            this.f39851W.setVisibility(8);
            if (ModuleConfigUtils.feedbackContactEnabled()) {
                this.f39851W.setVisibility(0);
            }
        } else {
            this.f39842N.setVisibility(8);
            if (TextUtils.isEmpty(this.f39834F.getProblemName())) {
                this.f39841M.setVisibility(8);
                this.f39843O.setVisibility(8);
                this.f39846R.setVisibility(8);
            } else {
                this.f39841M.setVisibility(0);
                this.f39843O.setVisibility(0);
                this.f39846R.setVisibility(8);
                this.f39843O.setText(this.f39834F.getProblemName());
            }
            this.f39836H = false;
            invalidateOptionsMenu();
            this.f39851W.setVisibility(8);
        }
        this.f39848T.setText(this.f39834F.getProblemDesc());
        this.f39848T.setSelection(this.f39834F.getProblemDesc().length());
        this.f39849U.m52608d(this.f39834F.getMedias());
        this.f39852X.setText(this.f39834F.getContact());
        this.f39854Z.setChecked(this.f39834F.getShowLog());
    }

    /* renamed from: L1 */
    public final void m53057L1(String str) {
        Intent intent = new Intent(this, (Class<?>) FeedbackSubmitSuccessActivity.class);
        intent.putExtra("problemId", str);
        startActivity(intent);
        AsCache asCache = this.f39833E;
        if (asCache != null) {
            asCache.remove("feedBackCache");
        }
        finish();
    }

    /* renamed from: M1 */
    public final void m53058M1(List<C8471b> list) {
        this.f39846R.setVisibility(0);
        this.f39842N.setVisibility(8);
        this.f39846R.setLayoutManager(new AutoLineLayoutManager());
        C8467f c8467f = new C8467f(list, this);
        this.f39847S = c8467f;
        c8467f.m52629I(new C8558k(list));
        this.f39846R.setAdapter(this.f39847S);
        if (TextUtils.isEmpty(this.f39834F.getProblemType())) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            C8471b c8471b = list.get(i10);
            if (c8471b != null && c8471b.f39529a.equals(this.f39834F.getParentId())) {
                this.f39847S.m52628H(i10);
                this.f39842N.setText(c8471b.f39530b);
                return;
            }
        }
    }

    /* renamed from: O1 */
    public final void m53059O1(List<C8471b> list) {
        TextView textView;
        String str;
        List<C8474e> list2;
        this.f39846R.setVisibility(8);
        this.f39842N.setVisibility(0);
        this.f39842N.setEnabled(true);
        if (TextUtils.isEmpty(this.f39834F.getProblemType()) || list == null) {
            return;
        }
        for (C8471b c8471b : list) {
            String str2 = c8471b.f39529a;
            if (str2 != null && str2.equals(this.f39834F.getParentId())) {
                if (!TextUtils.isEmpty(this.f39834F.getChildId()) && (list2 = c8471b.f39532d) != null && !list2.isEmpty()) {
                    for (C8474e c8474e : c8471b.f39532d) {
                        String str3 = c8474e.f39541a;
                        if (str3 != null && str3.equals(this.f39834F.getChildId())) {
                            textView = this.f39842N;
                            str = c8474e.f39542b;
                        }
                    }
                    return;
                }
                textView = this.f39842N;
                str = c8471b.f39530b;
                textView.setText(str);
                return;
            }
        }
    }

    /* renamed from: V0 */
    public final void m53060V0() {
        GridView gridView;
        int i10;
        this.f39868n0 = (GridView) findViewById(R$id.list_media);
        ProblemSuggestPhotoAdapter problemSuggestPhotoAdapter = new ProblemSuggestPhotoAdapter(this);
        this.f39849U = problemSuggestPhotoAdapter;
        this.f39868n0.setAdapter((ListAdapter) problemSuggestPhotoAdapter);
        this.f39868n0.setNumColumns(m52745E0());
        String sdk = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_HIDE_ADD_ATTACHMENT);
        if (sdk == null || !"Y".equals(sdk.toUpperCase(Locale.ROOT))) {
            gridView = this.f39868n0;
            i10 = 0;
        } else {
            gridView = this.f39868n0;
            i10 = 8;
        }
        gridView.setVisibility(i10);
    }

    /* renamed from: X0 */
    public final void m53061X0() throws NumberFormatException {
        CharInputFilter charInputFilter = new CharInputFilter("[&<>\"'()\"\\n\" ]");
        EmojiFilter emojiFilter = new EmojiFilter();
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(500);
        InputFilter.LengthFilter lengthFilter2 = new InputFilter.LengthFilter(100);
        this.f39848T.setFilters(new InputFilter[]{lengthFilter, new AttackCharFilter()});
        this.f39852X.setFilters(new InputFilter[]{charInputFilter, emojiFilter, lengthFilter2});
        this.f39848T.setOnFocusChangeListener(this);
        this.f39852X.setOnFocusChangeListener(this);
        this.f39854Z.setOnCheckedChangeListener(new C8559l());
        findViewById(R$id.cbx_text).setOnClickListener(new ViewOnClickListenerC8567t());
        m53068e1();
    }

    /* renamed from: Y0 */
    public final void m53062Y0() {
        if (!this.f39870p0) {
            this.f39856b0.setEnabled(this.f39838J);
        } else {
            this.f39856b0.setEnabled(true);
            this.f39870p0 = false;
        }
    }

    /* renamed from: Z0 */
    public final void m53063Z0() {
        this.f39856b0.setEnabled(true);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: a */
    public void mo52754a() {
        String srCode = this.f39834F.getSrCode();
        AsCache asCache = this.f39833E;
        if (asCache != null) {
            asCache.remove(TextUtils.isEmpty(srCode) ? "lastSubmit" : "lastSubmit_srCode");
        }
        this.f39858d0.setVisibility(8);
        this.f39859e0.setVisibility(8);
        m53063Z0();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public C8505a mo52746F0() {
        C8505a c8505a = new C8505a(this, this, this);
        this.f39832D = c8505a;
        return c8505a;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: b */
    public FeedbackInfo mo52755b() {
        return this.f39834F.getInfo();
    }

    /* renamed from: b1 */
    public final void m53065b1() {
        ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(this)));
        boolean z10 = (this.f39862h0 && !this.f39863i0) || this.f39866l0 || this.f39865k0;
        this.f39864j0 = z10;
        if (z10) {
            m53051z1(R$string.feedback_sdk_zipcompressing);
        }
        new Handler().postDelayed(new RunnableC8561n(), 500L);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8496e
    /* renamed from: c */
    public FeedbackBean mo52764c() {
        return this.f39834F;
    }

    /* renamed from: c1 */
    public void m53066c1() {
        m52878v0(getString(R$string.feedback_sdk_tips_continue_to_submit), getString(R$string.feedback_sdk_appupdate3_continue), getString(R$string.feedback_sdk_common_cancel), new ViewOnClickListenerC8552e(), new ViewOnClickListenerC8553f());
    }

    /* renamed from: d1 */
    public void m53067d1() {
        m52878v0(getString(R$string.feedback_sdk_tips_upload_waiting_or_exit_new), null, null, new ViewOnClickListenerC8554g(), new ViewOnClickListenerC8555h());
        this.f39832D.m52794E();
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: e */
    public void mo52757e() {
        m53051z1(R$string.feedback_sdk_common_in_submission);
        this.f39859e0.setVisibility(0);
    }

    /* renamed from: e1 */
    public final void m53068e1() throws NumberFormatException {
        this.f39852X.setOnTouchListener(new ViewOnTouchListenerC8547a(null));
        try {
            int i10 = Integer.parseInt(FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MIN_DESC_INPUT));
            this.f39874t0 = i10;
            if (i10 < 1 || i10 > 10) {
                this.f39874t0 = 10;
            }
        } catch (NumberFormatException unused) {
            this.f39874t0 = 10;
        }
        EditText editText = this.f39848T;
        Resources resources = getResources();
        int i11 = R$plurals.feedback_sdk_problem_question_info_update;
        int i12 = this.f39874t0;
        editText.setHint(resources.getQuantityString(i11, i12, Integer.valueOf(i12)));
        this.f39848T.setOnTouchListener(new ViewOnTouchListenerC8568u());
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: f */
    public void mo52611f() throws Throwable {
        m52747G0();
    }

    /* renamed from: f1 */
    public final void m53069f1() {
        m52878v0(getString(R$string.feedback_sdk_tips_save_edit), getString(R$string.feedback_sdk_common_yes), getString(R$string.feedback_sdk_common_no), new ViewOnClickListenerC8565r(), new ViewOnClickListenerC8566s());
    }

    /* renamed from: g1 */
    public final boolean m53070g1() throws Throwable {
        if (this.f39833E == null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f39834F.getSrCode())) {
            String asString = this.f39833E.getAsString("lastSubmit_srCode");
            if (!TextUtils.isEmpty(asString)) {
                FeedbackBean feedbackBean = (FeedbackBean) new GsonBuilder().registerTypeAdapter(Uri.class, new UriDeserializer()).create().fromJson(asString, FeedbackBean.class);
                if (this.f39834F.getSrCode().equals(feedbackBean.getSrCode())) {
                    this.f39834F = feedbackBean;
                    return true;
                }
            }
        } else if (TextUtils.isEmpty(this.f39834F.getProblemId())) {
            String asString2 = this.f39833E.getAsString("lastSubmit");
            if (!TextUtils.isEmpty(asString2)) {
                this.f39834F = (FeedbackBean) new GsonBuilder().registerTypeAdapter(Uri.class, new UriDeserializer()).create().fromJson(asString2, FeedbackBean.class);
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: h0 */
    public int mo52894h0() {
        return R$layout.feedback_sdk_activity_problem_suggest;
    }

    /* renamed from: h1 */
    public final void m53071h1() {
        m52878v0(getString(R$string.feedback_sdk_tips_continue_edit), getString(R$string.feedback_sdk_common_yes), getString(R$string.feedback_sdk_common_no), new ViewOnClickListenerC8563p(), new ViewOnClickListenerC8564q());
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: i0 */
    public int[] mo52895i0() {
        return new int[]{R$id.ll_category, R$id.txt_style, R$id.txt_style_2, R$id.grid_styles, R$id.ll_description, R$id.rl_description, R$id.ll_contact, R$id.problem_suggest_tv_privacy, R$id.edit_contact, R$id.cbx_log};
    }

    /* renamed from: i1 */
    public final void m53072i1() {
        if (ModuleConfigUtils.feedbackLogEnabled()) {
            if (!TextUtils.isEmpty(this.f39834F.getSrCode()) || TextUtils.isEmpty(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID))) {
                this.f39853Y.setVisibility(8);
                return;
            }
            this.f39853Y.setVisibility(0);
            if (0 == this.f39834F.getLogsSize()) {
                m53065b1();
            }
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: j0 */
    public void mo52896j0() throws Throwable {
        this.f39860f0.m53146j(FeedbackNoticeView.EnumC8597c.PROGRESS);
        m53023T0();
        if (!FaqCommonUtils.isConnectionAvailable(this)) {
            mo52772v(FaqConstants.FaqErrorCode.INTERNET_ERROR);
            return;
        }
        try {
            this.f39833E = AsCache.get(this, "feedback");
        } catch (IOException | RuntimeException e10) {
            FaqLogger.print("ProblemSuggestActivity_", e10.getMessage());
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            m53075o1(safeIntent.hasExtra("problem_info") ? (ProblemInfo) safeIntent.getParcelableExtra("problem_info") : null);
            this.f39854Z.setChecked(this.f39862h0);
            boolean zIsChecked = this.f39854Z.isChecked();
            this.f39861g0 = zIsChecked;
            this.f39834F.setShowLog(zIsChecked);
            FaqLogger.m51840e("ProblemSuggestActivity_", "   init data isChooseZip：" + this.f39861g0);
        } catch (Exception e11) {
            FaqLogger.m51840e("ProblemSuggestActivity_", e11.getMessage());
            this.f39860f0.setVisibility(8);
        }
    }

    /* renamed from: j1 */
    public final void m53073j1() throws Throwable {
        String string;
        Resources resources;
        int i10;
        FeedbackBean feedbackBean = this.f39834F;
        if (feedbackBean == null) {
            return;
        }
        if (!TextUtils.isEmpty(feedbackBean.getSrCode()) || !TextUtils.isEmpty(this.f39834F.getProblemType())) {
            if (TextUtils.isEmpty(this.f39834F.getProblemDesc()) || this.f39834F.getProblemDesc().trim().length() < this.f39874t0) {
                string = getString(R$string.feedback_sdk_feedback_desc_hint, Integer.valueOf(this.f39874t0));
                mo52756c(string);
            }
            if (this.f39851W.getVisibility() == 0) {
                String contact = this.f39834F.getContact();
                if (this.f39875u0 || !TextUtils.isEmpty(contact)) {
                    boolean zIsEmail = FaqRegexMatches.isEmail(contact);
                    boolean zIsMobile = FaqRegexMatches.isMobile(contact);
                    String string2 = getResources().getString(R$string.feedback_sdk_problem_please_check_phone_email_formatted);
                    if (this.f39875u0) {
                        if (!TextUtils.isEmpty(contact) && !zIsEmail && !zIsMobile) {
                            mo52756c(string2);
                            return;
                        }
                    } else if (!zIsEmail && !zIsMobile) {
                        mo52756c(string2);
                        return;
                    }
                } else {
                    resources = getResources();
                    i10 = R$string.feedback_sdk_problem_phone_email;
                }
            }
            m53008K0();
            return;
        }
        resources = getResources();
        i10 = R$string.feedback_sdk_problem_choose_question_type;
        string = resources.getString(i10);
        mo52756c(string);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: k0 */
    public void mo52897k0() {
        this.f39849U.m52607c(this);
        m53028W0();
        this.f39842N.setOnClickListener(this);
        this.f39856b0.setOnClickListener(this);
        this.f39860f0.setOnClickListener(this);
        this.f39857c0.setOnClickListener(this);
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity
    /* renamed from: l0 */
    public void mo52898l0() throws NumberFormatException {
        boolean zEquals = "1".equals(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_ISSELECTED));
        this.f39862h0 = zEquals;
        this.f39870p0 = !zEquals;
        setTitle(R$string.faq_sdk_feedback);
        TextView textView = (TextView) findViewById(R$id.description);
        textView.getPaint().setFakeBoldText(true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getString(R$string.feedback_sdk_problem_question_info_advice));
        sb2.append(" ");
        int i10 = R$string.feedback_sdk_required_fields;
        sb2.append(getString(i10));
        textView.setContentDescription(sb2.toString());
        TextView textView2 = (TextView) findViewById(R$id.feedback_contact_view);
        textView2.getPaint().setFakeBoldText(true);
        textView2.setContentDescription(getString(R$string.feedback_sdk_problem_contact_type) + " " + getString(i10));
        this.f39844P = (LinearLayout) findViewById(R$id.ll_category);
        TextView textView3 = (TextView) findViewById(R$id.txt_style_title);
        this.f39841M = textView3;
        textView3.setContentDescription(getString(R$string.feedback_sdk_problem_type) + " " + getString(R$string.feedback_sdk_mandatory));
        this.f39842N = (TextView) findViewById(R$id.txt_style);
        this.f39843O = (TextView) findViewById(R$id.txt_style_2);
        this.f39846R = (RecyclerView) findViewById(R$id.grid_styles);
        this.f39848T = (EditText) findViewById(R$id.edit_desc);
        this.f39850V = (TextView) findViewById(R$id.txt_number);
        this.f39857c0 = (TextView) findViewById(R$id.tv_tryagain);
        this.f39845Q = (TextView) findViewById(R$id.tv_progress);
        this.f39850V.setText(String.format(getResources().getString(R$string.feedback_sdk_problem_input_number), 0, 500));
        m53060V0();
        ImageView imageView = (ImageView) findViewById(R$id.feedback_contact_red_star);
        boolean zEqualsIgnoreCase = "Y".equalsIgnoreCase(SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_CONTACT_NOT_NECESSARY));
        this.f39875u0 = zEqualsIgnoreCase;
        imageView.setVisibility(zEqualsIgnoreCase ? 8 : 0);
        this.f39852X = (EditText) findViewById(R$id.edit_contact);
        this.f39853Y = (RelativeLayout) findViewById(R$id.cbx_host);
        this.f39854Z = (CheckBox) findViewById(R$id.cbx_log);
        this.f39855a0 = (TextView) findViewById(R$id.problem_suggest_tv_privacy);
        Button button = (Button) findViewById(R$id.btn_submit);
        this.f39856b0 = button;
        C8510b.m52864a(this, button);
        this.f39858d0 = (LinearLayout) findViewById(R$id.layout_loading);
        this.f39859e0 = (Button) findViewById(R$id.bg_dismiss);
        ScrollView scrollView = (ScrollView) findViewById(R$id.scroll_view);
        this.f39867m0 = scrollView;
        scrollView.setOverScrollMode(0);
        this.f39851W = (LinearLayout) findViewById(R$id.ll_phone_or_email);
        this.f39860f0 = (FeedbackNoticeView) findViewById(R$id.feedback_problem_noticeView);
        m53061X0();
        this.f39841M.getPaint().setFakeBoldText(true);
        this.f39842N.getPaint().setFakeBoldText(true);
    }

    /* renamed from: l1 */
    public void m53074l1(C8471b c8471b) {
        List<C8474e> list;
        int size = (c8471b == null || (list = c8471b.f39532d) == null) ? 0 : list.size();
        String[] strArr = new String[size];
        int i10 = -1;
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = c8471b.f39532d.get(i11).f39542b;
            if (c8471b.f39532d.get(i11).f39541a.equals(this.f39834F.getChildId())) {
                i10 = i11;
            }
        }
        if (c8471b == null) {
            return;
        }
        m52874r0(this, c8471b.f39530b, getString(R$string.feedback_sdk_common_cancel), strArr, i10, new DialogInterfaceOnClickListenerC8549b(c8471b));
    }

    /* renamed from: o1 */
    public final void m53075o1(ProblemInfo problemInfo) throws Throwable {
        if (problemInfo != null && problemInfo.isInteract()) {
            this.f39840L = 2;
            this.f39834F = new FeedbackBean(problemInfo.getSrCode(), problemInfo.getProblemId(), problemInfo.getProblemType(), problemInfo.getProblemType(), problemInfo.getProblemName());
            mo52770b(this.f39832D.m52793C());
            return;
        }
        if (problemInfo == null || !problemInfo.isDetail()) {
            this.f39835G = problemInfo == null ? 0 : problemInfo.getUnread();
            this.f39840L = 0;
            if (this.f39834F == null) {
                this.f39834F = new FeedbackBean();
            }
        } else {
            this.f39840L = 1;
            if (this.f39834F == null) {
                this.f39834F = new FeedbackBean(problemInfo.getProblemId(), problemInfo.getProblemType(), problemInfo.getProblemType(), problemInfo.getContact());
            }
        }
        this.f39832D.m52808v(this, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        List<MediaItem> listM52748z0;
        super.onActivityResult(i10, i11, intent);
        SafeIntent safeIntent = new SafeIntent(intent);
        if (i10 != 100 || safeIntent.getData() == null || (listM52748z0 = m52748z0(safeIntent, this.f39834F)) == null) {
            return;
        }
        this.f39834F.setMedias(listM52748z0);
        this.f39849U.m52608d(listM52748z0);
        this.f39832D.m52799i(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FeedbackBean feedbackBean;
        AsCache asCache;
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f39701B.dismiss();
            return;
        }
        if (!this.f39832D.m52810y()) {
            m53067d1();
            return;
        }
        if (this.f39859e0.getVisibility() == 0) {
            return;
        }
        FaqCommonUtils.hideIme(this);
        if (m53055I0()) {
            m53069f1();
            return;
        }
        if (this.f39840L == 0 && (feedbackBean = this.f39834F) != null && TextUtils.isEmpty(feedbackBean.getParentId()) && TextUtils.isEmpty(this.f39834F.getProblemDesc()) && !this.f39834F.haveMedias() && (asCache = this.f39833E) != null) {
            asCache.remove("feedBackCache");
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (NoDoubleClickUtil.isDoubleClick(view)) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.txt_style) {
            m53054E1(this.f39832D.m52793C());
            return;
        }
        if (id2 == R$id.btn_submit) {
            FaqCommonUtils.hideIme(this);
            m53073j1();
            return;
        }
        if (view.getId() == R$id.feedback_problem_noticeView) {
            mo52896j0();
            return;
        }
        if (view.getId() == R$id.tv_tryagain) {
            this.f39866l0 = true;
            this.f39857c0.setVisibility(8);
            ZipUtil.deleteFile(new File(FeedbackWebConstants.getZipFilePath(this)));
            m53051z1(R$string.feedback_sdk_zipcompress_again);
            this.f39869o0 = false;
            new Handler().postDelayed(new RunnableC8562o(), 500L);
        }
    }

    @Override // com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Throwable {
        super.onConfigurationChanged(configuration);
        this.f39868n0.setNumColumns(m52745E0());
        Button button = this.f39856b0;
        if (button != null) {
            C8510b.m52864a(this, button);
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.FeedbackBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedBaseActivity, com.huawei.phoneservice.feedback.p175ui.FeedbackAbstractBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Throwable {
        if (bundle != null) {
            C10343b c10343b = new C10343b(bundle);
            this.f39834F = (FeedbackBean) c10343b.m63690l("FeedbackBean");
            FaqSdk.getSdk().saveMapOnSaveInstanceState(c10343b.m63694p("CacheMap"));
            FeedbackBean feedbackBean = this.f39834F;
            this.f39872r0 = feedbackBean != null;
            if (feedbackBean != null) {
                this.f39839K = feedbackBean.getLogsSize() == 0;
            }
            this.f39838J = c10343b.m63681c("isCompress");
        }
        super.onCreate(bundle);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        int id2 = view.getId();
        if (id2 == R$id.edit_contact || id2 == R$id.edit_desc) {
            m53076r1(view, z10);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R$menu.feedback_sdk_problem_menu_item, menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.feedback_sdk_show_history);
        View actionView = menuItemFindItem.getActionView();
        new BadgeHelper(this).m52867b(true).m52866a((ImageView) actionView.findViewById(R$id.menu_history)).setBadgeNumber(this.f39835G);
        actionView.setOnClickListener(new ViewOnClickListenerC8573z());
        menuItemFindItem.setVisible(this.f39836H);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("FeedbackBean", this.f39834F);
        bundle.putString("CacheMap", FaqSdk.getSdk().getMapOnSaveInstance());
        bundle.putBoolean("isCompress", this.f39838J);
    }

    /* renamed from: r1 */
    public final void m53076r1(View view, boolean z10) {
        String string;
        EditText editText = (EditText) view;
        if (editText == null) {
            return;
        }
        if (z10) {
            CharSequence hint = editText.getHint();
            if (hint != null) {
                editText.setTag(hint.toString());
            }
            string = "";
        } else {
            Object tag = editText.getTag();
            if (tag == null) {
                return;
            } else {
                string = tag.toString();
            }
        }
        editText.setHint(string);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: v */
    public void mo52772v(FaqConstants.FaqErrorCode faqErrorCode) throws Throwable {
        FeedbackBean feedbackBean;
        m52880x0();
        if (faqErrorCode == FaqConstants.FaqErrorCode.INTERNET_ERROR) {
            this.f39860f0.m53143g(faqErrorCode);
            this.f39860f0.setVisibility(0);
            this.f39860f0.setEnabled(true);
            return;
        }
        this.f39873s0 = true;
        this.f39860f0.setVisibility(8);
        this.f39844P.setVisibility(8);
        if (this.f39840L == 0 && (feedbackBean = this.f39834F) != null) {
            feedbackBean.setProblemType("1004003", null);
        }
        FeedbackBean feedbackBean2 = this.f39834F;
        if (feedbackBean2 != null && !TextUtils.isEmpty(feedbackBean2.getProblemId())) {
            this.f39836H = false;
            invalidateOptionsMenu();
        } else if (ModuleConfigUtils.feedbackHistoryEnabled() && !FaqStringUtil.isEmpty(SdkProblemManager.getSdk().getSdk("accessToken"))) {
            this.f39836H = true;
            invalidateOptionsMenu();
            if (this.f39835G <= 0) {
                m53025U0();
            }
        }
        if (ModuleConfigUtils.feedbackContactEnabled()) {
            this.f39851W.setVisibility(0);
        }
        this.f39848T.setText(this.f39834F.getProblemDesc());
        this.f39852X.setText(this.f39834F.getContact());
        m53072i1();
    }

    /* renamed from: w1 */
    public final void m53077w1(List<C8471b> list) {
        List<C8474e> list2;
        for (C8471b c8471b : list) {
            if (!TextUtils.isEmpty(this.f39834F.getChildId()) && (list2 = c8471b.f39532d) != null && !list2.isEmpty()) {
                Iterator<C8474e> it = c8471b.f39532d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = it.next().f39541a;
                    if (str != null && str.equals(this.f39834F.getChildId())) {
                        this.f39834F.setParentId(c8471b.f39529a);
                        break;
                    }
                }
            }
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: z */
    public void mo52758z(EnumC8594a enumC8594a) throws Throwable {
        int i10;
        this.f39839K = false;
        this.f39864j0 = (this.f39862h0 && !this.f39863i0) || (this.f39866l0 && this.f39861g0) || (this.f39865k0 && this.f39861g0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("zipCompressFinished  ");
        sb2.append(this.f39862h0);
        sb2.append(" ");
        sb2.append(!this.f39863i0);
        sb2.append(" ");
        sb2.append(this.f39866l0);
        sb2.append(" ");
        sb2.append(this.f39865k0);
        sb2.append(" ");
        sb2.append(this.f39861g0);
        sb2.append(" ");
        sb2.append(enumC8594a.toString());
        FaqLogger.m51836d("ProblemSuggestActivity_", sb2.toString());
        if (enumC8594a == EnumC8594a.ZIP_COMPRESS_SUCCESS) {
            this.f39838J = true;
            this.f39837I = false;
            if (this.f39864j0) {
                i10 = R$string.feedback_sdk_zipcompresssuccess;
                m53051z1(i10);
            }
        } else if (enumC8594a == EnumC8594a.ZIP_COMPRESS_FAILED) {
            this.f39838J = false;
            this.f39837I = true;
            if (this.f39864j0) {
                i10 = R$string.feedback_sdk_zipcompressfailed;
                m53051z1(i10);
            }
        }
        new Handler().postDelayed(new RunnableC8560m(enumC8594a), 500L);
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: a */
    public void mo52609a(int i10) throws Throwable {
        FeedbackBean feedbackBean = this.f39834F;
        if (feedbackBean != null) {
            m52743C0(feedbackBean.getMediaItem(i10));
        }
    }

    @Override // com.huawei.phoneservice.feedback.adapter.ProblemSuggestPhotoAdapter.InterfaceC8460b
    /* renamed from: b */
    public void mo52610b(int i10) {
        m52742B0(this.f39834F, i10);
        this.f39834F.remove(i10);
        this.f39849U.m52608d(this.f39834F.getMedias());
        this.f39868n0.setAdapter((ListAdapter) this.f39849U);
        this.f39832D.m52799i(this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: c */
    public void mo52771c(int i10) {
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: a */
    public void mo52767a(String str) throws Throwable {
        AlertDialog alertDialog = this.f39701B;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f39701B.dismiss();
        }
        if (TextUtils.isEmpty(this.f39834F.getSrCode())) {
            mo52756c(getString(!TextUtils.isEmpty(this.f39834F.getProblemId()) ? R$string.feedback_sdk_commit_successs : R$string.feedback_sdk_submit_successs));
        }
        String problemId = TextUtils.isEmpty(this.f39834F.getProblemId()) ? str : this.f39834F.getProblemId();
        this.f39834F.setProblemId(str);
        SdkProblemListener sdkListener = SdkProblemManager.getManager().getSdkListener();
        this.f39856b0.setEnabled(false);
        this.f39859e0.setVisibility(0);
        this.f39859e0.postDelayed(new RunnableC8556i(sdkListener, str, problemId), RippleView.SINGLE_RIPPLE_TIME);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: b */
    public void mo52769b(String str) {
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8493b
    /* renamed from: c */
    public void mo52756c(String str) throws Throwable {
        FaqToastUtils.makeText(this, str);
        Log.e("ProblemSuggestActivity_", "showToast...." + str);
        if (this.f39865k0) {
            this.f39856b0.setEnabled(true);
        }
        this.f39865k0 = false;
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: a */
    public void mo52768a(boolean z10) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isCompress()  ");
        sb2.append(z10);
        sb2.append(" ");
        sb2.append((this.f39837I || this.f39839K) ? false : true);
        FaqLogger.m51836d("ProblemSuggestActivity_", sb2.toString());
        boolean z11 = !z10;
        this.f39838J = z11;
        if (this.f39837I || this.f39839K) {
            return;
        }
        this.f39856b0.setEnabled(z11);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a
    /* renamed from: b */
    public void mo52770b(List<C8471b> list) throws Throwable {
        AsCache asCache;
        m52880x0();
        this.f39867m0.setVisibility(0);
        this.f39860f0.setVisibility(8);
        boolean zM53070g1 = m53070g1();
        this.f39869o0 = zM53070g1;
        if (!zM53070g1 && (asCache = this.f39833E) != null && !this.f39872r0) {
            String asString = asCache.getAsString("feedBackCache");
            if (!TextUtils.isEmpty(asString)) {
                FeedbackBean feedbackBean = (FeedbackBean) new GsonBuilder().registerTypeAdapter(Uri.class, new UriDeserializer()).create().fromJson(asString, FeedbackBean.class);
                this.f39834F = feedbackBean;
                if (feedbackBean != null) {
                    this.f39871q0 = true;
                    feedbackBean.setLogsSize(0L);
                } else {
                    FeedbackBean feedbackBean2 = new FeedbackBean();
                    this.f39834F = feedbackBean2;
                    feedbackBean2.setShowLog(this.f39862h0);
                }
            }
        }
        m53056I1(list);
        m53072i1();
        if (this.f39834F.haveMedias()) {
            this.f39832D.m52799i(this);
            this.f39849U.m52608d(this.f39834F.getMedias());
        }
        if (this.f39869o0) {
            m53066c1();
        } else if (this.f39871q0) {
            m53071h1();
        }
    }
}
