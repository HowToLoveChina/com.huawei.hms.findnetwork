package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import ca.C1399b;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.LearnMorePayClickListener;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.ScanRedeemResultDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.cloud.pay.model.CardPackage;
import com.huawei.cloud.pay.model.CardPackageResp;
import com.huawei.cloud.pay.model.CardPayResp;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.ConvertInfo;
import com.huawei.cloud.pay.model.EstimateResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GradeCardDisplayBean;
import com.huawei.cloud.pay.model.InAppPurchaseData;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.NotifyReq;
import com.huawei.cloud.pay.model.OrderResult;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.QuerySubOrderStatusResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.iap.Iap;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iap.entity.PurchaseResultInfo;
import com.huawei.hms.iap.entity.RedeemCodeResultInfo;
import com.huawei.hms.iap.entity.ScanRedeemCodeResult;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.huawei.uikit.phone.hwedittext.widget.HwEditText;
import com.huawei.uikit.phone.hwedittext.widget.HwErrorTipTextLayout;
import dj.C9158a;
import fk.C9721b;
import gp.C10028c;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0234s;
import p054cj.C1442a;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p252e9.C9433j;
import p336he.C10155f;
import p387j7.C10718a;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11282e;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11828b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CardNumConfirmActivity extends BaseCardActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: A1 */
    public TextView f16647A1;

    /* renamed from: A3 */
    public View f16648A3;

    /* renamed from: B1 */
    public TextView f16649B1;

    /* renamed from: B3 */
    public C10718a f16650B3;

    /* renamed from: C1 */
    public TextView f16651C1;

    /* renamed from: C3 */
    public String f16652C3;

    /* renamed from: D1 */
    public AutoSizeButton f16653D1;

    /* renamed from: D3 */
    public CloudSpace f16654D3;

    /* renamed from: E1 */
    public AutoSizeButton f16655E1;

    /* renamed from: E3 */
    public ImageView f16656E3;

    /* renamed from: F1 */
    public long f16657F1;

    /* renamed from: F3 */
    public ScanRedeemResultDialog f16658F3;

    /* renamed from: G1 */
    public long f16659G1;

    /* renamed from: G3 */
    public boolean f16660G3;

    /* renamed from: H1 */
    public long f16661H1;

    /* renamed from: H3 */
    public int f16662H3;

    /* renamed from: I1 */
    public long f16663I1;

    /* renamed from: I3 */
    public boolean f16664I3;

    /* renamed from: J1 */
    public long f16665J1;

    /* renamed from: K1 */
    public HwErrorTipTextLayout f16666K1;

    /* renamed from: L1 */
    public HwEditText f16667L1;

    /* renamed from: M1 */
    public AutoSizeButton f16668M1;

    /* renamed from: N1 */
    public TextView f16669N1;

    /* renamed from: O1 */
    public RelativeLayout f16670O1;

    /* renamed from: P1 */
    public CheckBox f16671P1;

    /* renamed from: Q1 */
    public SpanClickText f16672Q1;

    /* renamed from: R1 */
    public ScrollView f16673R1;

    /* renamed from: S1 */
    public ScrollView f16674S1;

    /* renamed from: T1 */
    public RelativeLayout f16675T1;

    /* renamed from: U1 */
    public LinearLayout f16676U1;

    /* renamed from: V1 */
    public HandlerC3597d f16677V1 = new HandlerC3597d(this, null);

    /* renamed from: W1 */
    public boolean f16678W1 = true;

    /* renamed from: X1 */
    public PackageGrades f16679X1;

    /* renamed from: Y1 */
    public CardPackage f16680Y1;

    /* renamed from: Z1 */
    public EstimateResp f16681Z1;

    /* renamed from: a2 */
    public CardPayResp f16682a2;

    /* renamed from: b2 */
    public OrderResult f16683b2;

    /* renamed from: c2 */
    public String f16684c2;

    /* renamed from: d2 */
    public String f16685d2;

    /* renamed from: e2 */
    public String f16686e2;

    /* renamed from: h1 */
    public NotchTopFitLinearLayout f16687h1;

    /* renamed from: i1 */
    public NotchFitLinearLayout f16688i1;

    /* renamed from: j1 */
    public GradeCardView f16689j1;

    /* renamed from: k1 */
    public GetClientUIConfigResp f16690k1;

    /* renamed from: l1 */
    public TextView f16691l1;

    /* renamed from: m1 */
    public TextView f16692m1;

    /* renamed from: n1 */
    public LinearLayout f16693n1;

    /* renamed from: o1 */
    public TextView f16694o1;

    /* renamed from: p1 */
    public TextView f16695p1;

    /* renamed from: q1 */
    public TextView f16696q1;

    /* renamed from: r1 */
    public TextView f16697r1;

    /* renamed from: s1 */
    public TextView f16698s1;

    /* renamed from: t1 */
    public TextView f16699t1;

    /* renamed from: u1 */
    public TextView f16700u1;

    /* renamed from: v1 */
    public TextView f16701v1;

    /* renamed from: w1 */
    public TextView f16702w1;

    /* renamed from: x1 */
    public TextView f16703x1;

    /* renamed from: x3 */
    public TextView f16704x3;

    /* renamed from: y1 */
    public LinearLayout f16705y1;

    /* renamed from: y3 */
    public View f16706y3;

    /* renamed from: z1 */
    public TextView f16707z1;

    /* renamed from: z3 */
    public View f16708z3;

    public interface QueryNewBmTypeCallback {
        /* renamed from: a */
        void mo23103a(boolean z10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$a */
    public class C3594a implements InputFilter {
        public C3594a() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            if (charSequence == null) {
                return null;
            }
            String string = charSequence.toString();
            return string.contains(" ") ? string.replaceAll(" ", "") : string;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$b */
    public class C3595b implements TextWatcher {
        public C3595b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence == null) {
                return;
            }
            String string = charSequence.toString();
            if (string.length() > 18) {
                CardNumConfirmActivity.this.f16667L1.setText(string.substring(0, 18));
                CardNumConfirmActivity.this.f16667L1.setSelection(CardNumConfirmActivity.this.f16667L1.length());
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$c */
    public class RunnableC3596c implements Runnable {
        public RunnableC3596c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C11296s.m67786J(CardNumConfirmActivity.this)) {
                C9158a.m57503F().m57509G(CardNumConfirmActivity.this.f16677V1, new NotifyReq(CardNumConfirmActivity.this.f16682a2.getId(), CardNumConfirmActivity.this.f16682a2.getRequestId(), CardNumConfirmActivity.this.f16682a2.getOrderId()), CardNumConfirmActivity.this.f21448i);
                return;
            }
            C1442a.m8288d("CardNumConfirmActivity", "getNotify no network!");
            CardNumConfirmActivity.this.m28583a1();
            CardNumConfirmActivity.this.m22715K5(4004);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$d */
    public static class HandlerC3597d extends Handler {

        /* renamed from: a */
        public WeakReference<CardNumConfirmActivity> f16712a;

        public /* synthetic */ HandlerC3597d(CardNumConfirmActivity cardNumConfirmActivity, C3594a c3594a) {
            this(cardNumConfirmActivity);
        }

        /* renamed from: a */
        public final void m23104a(CardNumConfirmActivity cardNumConfirmActivity, Message message) {
            Object obj = message.obj;
            if (obj instanceof CardPackageResp) {
                CardPackageResp cardPackageResp = (CardPackageResp) obj;
                List<PackageGrades> packageGrades = cardPackageResp.getPackageGrades();
                if (packageGrades == null || packageGrades.isEmpty()) {
                    C1442a.m8289e("CardNumConfirmActivity", "dealGetCardSuccess packageGradesList is null.");
                    return;
                }
                cardNumConfirmActivity.f16679X1 = packageGrades.get(0);
                cardNumConfirmActivity.f16680Y1 = cardPackageResp.getCardPackage();
                cardNumConfirmActivity.f16684c2 = cardNumConfirmActivity.f16680Y1.getId();
                cardNumConfirmActivity.f16686e2 = cardNumConfirmActivity.f16680Y1.getEncCardNo();
                C1442a.m8288d("CardNumConfirmActivity", "cardPackage.id:" + cardNumConfirmActivity.f16680Y1.getId());
            }
            if (C11296s.m67786J(cardNumConfirmActivity)) {
                C9158a.m57503F().m57549n(cardNumConfirmActivity.f16677V1, cardNumConfirmActivity.f16684c2, 9, cardNumConfirmActivity.f21448i, null, Integer.valueOf(cardNumConfirmActivity.f16680Y1.getSupportAutoPay()), null);
                return;
            }
            C1442a.m8288d("CardNumConfirmActivity", "estimate no network!");
            cardNumConfirmActivity.m28583a1();
            cardNumConfirmActivity.m22715K5(4004);
            cardNumConfirmActivity.m23061J6("fail_by_get_card_packages_no_net");
        }

        /* renamed from: b */
        public final void m23105b(CardNumConfirmActivity cardNumConfirmActivity, Message message) {
            Object obj = message.obj;
            if (obj instanceof OrderResult) {
                cardNumConfirmActivity.f16683b2 = (OrderResult) obj;
            }
            if (!"Valid".equals(cardNumConfirmActivity.f16683b2.getStatus())) {
                cardNumConfirmActivity.m23066O6("fail_card_exchange_notify" + cardNumConfirmActivity.f16683b2.getStatus());
                cardNumConfirmActivity.m23092p6();
                return;
            }
            cardNumConfirmActivity.f21448i.m66668x("1");
            C13622a.m81968n(cardNumConfirmActivity, cardNumConfirmActivity.f21448i);
            C13108a.m78878b(cardNumConfirmActivity.getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
            cardNumConfirmActivity.m28583a1();
            cardNumConfirmActivity.m23084h7(cardNumConfirmActivity.f16683b2.getIsAutoPay(), cardNumConfirmActivity.f16683b2.getEndTime());
            C1442a.m8288d("CardNumConfirmActivity", "sendPaySuccessBroadcast, card get notify success, backup frequency is " + cardNumConfirmActivity.f16562i0);
            C11296s.m67818h0(cardNumConfirmActivity, cardNumConfirmActivity.f16683b2.getGradeRights(), cardNumConfirmActivity.f16562i0);
            cardNumConfirmActivity.m22816Z3();
            C1399b.m8034o().m8053t(false);
            cardNumConfirmActivity.m23068Q6("exchange_success", cardNumConfirmActivity.f16683b2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CardNumConfirmActivity cardNumConfirmActivity = this.f16712a.get();
            if (cardNumConfirmActivity == null || cardNumConfirmActivity.isFinishing()) {
                return;
            }
            int i10 = message.what;
            if (i10 == 2001) {
                cardNumConfirmActivity.f21452m = (UserPackage) message.obj;
                return;
            }
            if (i10 == 2002) {
                cardNumConfirmActivity.f16690k1 = (GetClientUIConfigResp) message.obj;
                return;
            }
            if (i10 == 2004) {
                Object obj = message.obj;
                if (obj instanceof EstimateResp) {
                    cardNumConfirmActivity.f16681Z1 = (EstimateResp) obj;
                }
                cardNumConfirmActivity.m28583a1();
                cardNumConfirmActivity.m23080d7();
                return;
            }
            if (i10 == 2006) {
                m23105b(cardNumConfirmActivity, message);
                return;
            }
            if (i10 == 2027) {
                cardNumConfirmActivity.mo22871s3(message.obj);
                return;
            }
            if (i10 == 2104) {
                cardNumConfirmActivity.m28583a1();
                cardNumConfirmActivity.m22715K5(message.arg1);
                cardNumConfirmActivity.m23061J6("fail_by_estimate_package_" + message.arg1);
                return;
            }
            if (i10 == 2106) {
                cardNumConfirmActivity.m23092p6();
                cardNumConfirmActivity.m23066O6("fail_card_exchange_notify_" + message.arg1);
                return;
            }
            if (i10 == 2008) {
                m23104a(cardNumConfirmActivity, message);
                return;
            }
            if (i10 == 2009) {
                Object obj2 = message.obj;
                if (obj2 instanceof CardPayResp) {
                    cardNumConfirmActivity.f16682a2 = (CardPayResp) obj2;
                }
                cardNumConfirmActivity.f16678W1 = true;
                cardNumConfirmActivity.m23060I6();
                return;
            }
            if (i10 == 2108) {
                cardNumConfirmActivity.m28583a1();
                cardNumConfirmActivity.m22715K5(message.arg1);
                cardNumConfirmActivity.m23061J6("fail_by_get_card_packages_" + message.arg1);
                return;
            }
            if (i10 == 2109) {
                cardNumConfirmActivity.m28583a1();
                cardNumConfirmActivity.m22715K5(799);
                cardNumConfirmActivity.m23066O6("fail_pay_by_card_" + message.arg1);
                return;
            }
            if (i10 == 2127) {
                cardNumConfirmActivity.mo22868r3(message.arg1);
            } else if (i10 != 2128) {
                super.handleMessage(message);
            } else {
                cardNumConfirmActivity.m23100x6(message.obj.toString());
            }
        }

        public HandlerC3597d(CardNumConfirmActivity cardNumConfirmActivity) {
            this.f16712a = new WeakReference<>(cardNumConfirmActivity);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$e */
    public static class ActionModeCallbackC3598e implements ActionMode.Callback {
        public ActionModeCallbackC3598e() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public /* synthetic */ ActionModeCallbackC3598e(C3594a c3594a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$f */
    public static class C3599f implements PrivilegedAction {

        /* renamed from: a */
        public Method f16713a;

        public /* synthetic */ C3599f(Method method, C3594a c3594a) {
            this(method);
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f16713a.setAccessible(true);
            return null;
        }

        public C3599f(Method method) {
            this.f16713a = method;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$g */
    public static class C3600g implements TextWatcher {

        /* renamed from: a */
        public HwErrorTipTextLayout f16714a;

        /* renamed from: b */
        public AutoSizeButton f16715b;

        /* renamed from: c */
        public HwEditText f16716c;

        public /* synthetic */ C3600g(HwErrorTipTextLayout hwErrorTipTextLayout, AutoSizeButton autoSizeButton, HwEditText hwEditText, C3594a c3594a) {
            this(hwErrorTipTextLayout, autoSizeButton, hwEditText);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            HwErrorTipTextLayout hwErrorTipTextLayout = this.f16714a;
            if (hwErrorTipTextLayout == null) {
                C1442a.m8289e("CardNumConfirmActivity", "HwErrorTipTextLayout is null");
                return;
            }
            if (!TextUtils.isEmpty(hwErrorTipTextLayout.getError())) {
                this.f16714a.setError(null);
            }
            if (this.f16716c.getText().toString().isEmpty()) {
                this.f16715b.setEnabled(false);
            } else {
                this.f16715b.setEnabled(true);
                this.f16715b.setAlpha(1.0f);
            }
        }

        public C3600g(HwErrorTipTextLayout hwErrorTipTextLayout, AutoSizeButton autoSizeButton, HwEditText hwEditText) {
            this.f16714a = hwErrorTipTextLayout;
            this.f16715b = autoSizeButton;
            this.f16716c = hwEditText;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity$h */
    public static class C3601h extends AbstractC12367d {

        /* renamed from: a */
        public QueryNewBmTypeCallback f16717a;

        public C3601h(QueryNewBmTypeCallback queryNewBmTypeCallback) {
            this.f16717a = queryNewBmTypeCallback;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C1442a.m8290i("CardNumConfirmActivity", "QueryNewBmTypeTask start");
            this.f16717a.mo23103a(C10155f.m63293q(RippleView.SINGLE_RIPPLE_TIME));
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.FAMILY_SHARE;
        }
    }

    /* renamed from: A6 */
    private void m23023A6() {
        try {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
            GetClientUIConfigResp getClientUIConfigResp = (GetClientUIConfigResp) hiCloudSafeIntent.getSerializableExtra("params");
            this.f16690k1 = getClientUIConfigResp;
            if (getClientUIConfigResp == null) {
                String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_client_ui_config_cache_key");
                if (!TextUtils.isEmpty(strM67711c)) {
                    try {
                        this.f16690k1 = (GetClientUIConfigResp) new Gson().fromJson(strM67711c, GetClientUIConfigResp.class);
                    } catch (JsonSyntaxException e10) {
                        C1442a.m8289e("CardNumConfirmActivity", "params e : " + e10.getMessage());
                    }
                }
                C9158a.m57503F().m57505B(this.f16677V1, this.f21448i, true);
            }
            UserPackage userPackage = (UserPackage) hiCloudSafeIntent.getSerializableExtra("user");
            this.f21452m = userPackage;
            if (userPackage == null) {
                String strM67711c2 = C11282e.m67709b(C0213f.m1377a()).m67711c("get_user_package_cache_key");
                if (!TextUtils.isEmpty(strM67711c2)) {
                    try {
                        this.f21452m = (UserPackage) new Gson().fromJson(strM67711c2, UserPackage.class);
                    } catch (JsonSyntaxException e11) {
                        C1442a.m8289e("CardNumConfirmActivity", "user e : " + e11.getMessage());
                    }
                }
            }
            this.f16562i0 = hiCloudSafeIntent.getIntExtra("chosen_backup_frequency", 0);
            this.f16652C3 = hiCloudSafeIntent.getStringExtra("enter_type");
            this.f16662H3 = hiCloudSafeIntent.getIntExtra("from_where", 0);
            CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
            this.f16657F1 = C11293p.m67762f(this.f21452m);
            this.f16659G1 = cloudSpaceM67757a.getBaseCapacity();
            this.f16661H1 = C11293p.m67765i(this.f21452m);
            this.f16665J1 = this.f21452m.getUsed();
            this.f16663I1 = cloudSpaceM67757a.getEndTime();
        } catch (RuntimeException unused) {
            C1442a.m8289e("CardNumConfirmActivity", "intent Serializable error.");
            setResult(0, null);
            finish();
        }
        this.f16687h1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f16688i1 = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_card_num);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.scan_redeem_code);
        this.f16656E3 = imageView;
        imageView.setContentDescription(getString(R$string.cloudpay_card_sacn_and_convert));
        this.f16656E3.setOnClickListener(this);
        this.f16706y3 = C12809f.m76829b(this, R$id.layout_card_input);
        this.f16666K1 = (HwErrorTipTextLayout) C12809f.m76829b(this, R$id.card_input_num_layout);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.card_exchange);
        this.f16668M1 = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f16668M1.setEnabled(false);
        C11842p.m70866t1(this, this.f16668M1);
        HwEditText hwEditText = (HwEditText) C12809f.m76829b(this, R$id.card_input_num);
        this.f16667L1 = hwEditText;
        hwEditText.setHint(getString(R$string.cloudpay_card_input_pwd, 18));
        this.f16667L1.setImeOptions(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        if (C13843a.m83071W(this)) {
            this.f16667L1.setTextDirection(3);
        } else {
            this.f16667L1.setTextDirection(5);
        }
        this.f16667L1.setFilters(new InputFilter[]{new C3594a()});
        this.f16667L1.addTextChangedListener(new C3595b());
        m23077Z6(this.f16667L1);
        HwEditText hwEditText2 = this.f16667L1;
        hwEditText2.addTextChangedListener(new C3600g(this.f16666K1, this.f16668M1, hwEditText2, null));
        this.f16673R1 = (ScrollView) C12809f.m76829b(this, R$id.input_num_scroll_view);
        this.f16674S1 = (ScrollView) C12809f.m76829b(this, R$id.pay_detail_scroll_view);
        this.f16675T1 = (RelativeLayout) C12809f.m76829b(this, R$id.pay_detail_bottom_view);
        this.f16676U1 = (LinearLayout) C12809f.m76829b(this, R$id.exchanged_view);
        ((TextView) C12809f.m76829b(this, R$id.card_hint1)).setText(getString(R$string.cloudpay_card_exchange_hint1, 1));
        ((TextView) C12809f.m76829b(this, R$id.card_hint2)).setText(getString(R$string.cloudpay_card_exchange_hint2, 2));
        ((TextView) C12809f.m76829b(this, R$id.card_hint3)).setText(getString(R$string.cloudpay_card_exchange_hint3, 3));
        this.f16708z3 = C12809f.m76829b(this, R$id.layout_card_detail);
        this.f16689j1 = (GradeCardView) C12809f.m76829b(this, R$id.grade_card_view);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.now_detail);
        int i10 = R$id.current_title;
        this.f16691l1 = (TextView) C12809f.m76831d(linearLayout, i10);
        int i11 = R$id.current_title_value;
        this.f16692m1 = (TextView) C12809f.m76831d(linearLayout, i11);
        this.f16693n1 = (LinearLayout) C12809f.m76831d(linearLayout, R$id.card_capacity_info);
        int i12 = R$id.used_capacity_title;
        this.f16694o1 = (TextView) C12809f.m76831d(linearLayout, i12);
        int i13 = R$id.base_capacity_title;
        this.f16695p1 = (TextView) C12809f.m76831d(linearLayout, i13);
        int i14 = R$id.pay_capacity_title;
        this.f16696q1 = (TextView) C12809f.m76831d(linearLayout, i14);
        int i15 = R$id.used_capacity_value;
        this.f16697r1 = (TextView) C12809f.m76831d(linearLayout, i15);
        int i16 = R$id.base_capacity_value;
        this.f16698s1 = (TextView) C12809f.m76831d(linearLayout, i16);
        int i17 = R$id.pay_capacity_value;
        this.f16699t1 = (TextView) C12809f.m76831d(linearLayout, i17);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.after_detail);
        this.f16700u1 = (TextView) C12809f.m76831d(linearLayout2, i10);
        this.f16701v1 = (TextView) C12809f.m76831d(linearLayout2, i11);
        this.f16702w1 = (TextView) C12809f.m76831d(linearLayout2, i12);
        this.f16703x1 = (TextView) C12809f.m76831d(linearLayout2, i13);
        this.f16705y1 = (LinearLayout) C12809f.m76831d(linearLayout2, R$id.layout_basespace);
        this.f16707z1 = (TextView) C12809f.m76831d(linearLayout2, i14);
        this.f16647A1 = (TextView) C12809f.m76831d(linearLayout2, i15);
        this.f16649B1 = (TextView) C12809f.m76831d(linearLayout2, i16);
        this.f16651C1 = (TextView) C12809f.m76831d(linearLayout2, i17);
        this.f16669N1 = (TextView) C12809f.m76829b(this, R$id.estimate_hint);
        this.f16670O1 = (RelativeLayout) C12809f.m76829b(this, R$id.estimate_rule_layout);
        CheckBox checkBox = (CheckBox) C12809f.m76829b(this, R$id.estimate_rule_checkbox);
        this.f16671P1 = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.f16672Q1 = (SpanClickText) C12809f.m76829b(this, R$id.estimate_rule_text);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.card_submit);
        this.f16653D1 = autoSizeButton2;
        C11842p.m70866t1(this, autoSizeButton2);
        this.f16653D1.setOnClickListener(this);
        this.f16653D1.setClickable(false);
        this.f16648A3 = C12809f.m76829b(this, R$id.layout_exchanged);
        this.f16704x3 = (TextView) C12809f.m76829b(this, R$id.card_exchanged_hint);
        AutoSizeButton autoSizeButton3 = (AutoSizeButton) C12809f.m76829b(this, R$id.card_ok_btn);
        this.f16655E1 = autoSizeButton3;
        autoSizeButton3.setOnClickListener(this);
        C11842p.m70866t1(this, this.f16655E1);
        C10718a c10718a = new C10718a(this);
        this.f16650B3 = c10718a;
        c10718a.m65432m("cardnumConfirm");
        C12515a.m75110o().m75172d(new C3601h(new QueryNewBmTypeCallback() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.k
            @Override // com.huawei.android.hicloud.ui.activity.cloudpay.CardNumConfirmActivity.QueryNewBmTypeCallback
            /* renamed from: a */
            public final void mo23103a(boolean z10) {
                this.f17553a.m23055D6(z10);
            }
        }));
    }

    /* renamed from: c7 */
    private void m23042c7() {
        int iM70841n0 = (C11842p.m70771U0() && C11842p.m70774V0(this)) ? C11842p.m70841n0() : C11842p.m70837m0();
        if (!this.f16660G3) {
            this.f16691l1.setMaxWidth(iM70841n0);
        }
        this.f16700u1.setMaxWidth(iM70841n0);
    }

    /* renamed from: o6 */
    private void m23052o6(int i10, Intent intent) {
        ErrorStatus errorStatus;
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07009"), "termProcessHMSResult", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("hms_agreement_result_code", String.valueOf(i10));
        map.put("hms_current_activity", getClass().getName());
        C10028c c10028cM62183d0 = C10028c.m62183d0(this);
        if (i10 == 0) {
            C11839m.m70687e("CardNumConfirmActivity", "agreement update result cancel");
            if (intent != null) {
                try {
                    errorStatus = (ErrorStatus) intent.getParcelableExtra("parce");
                } catch (Exception e10) {
                    C11839m.m70687e("CardNumConfirmActivity", "class ErrorStatus pkg path hms apk sdk not match  " + e10.getMessage());
                    errorStatus = null;
                }
                if (errorStatus != null) {
                    int errorCode = errorStatus.getErrorCode();
                    C11839m.m70687e("CardNumConfirmActivity", "error code = " + errorCode + ", error reason = " + errorStatus.getErrorReason());
                    map.put("hms_agreement_result_error_code", String.valueOf(errorCode));
                    if (errorCode == 10002) {
                        c10028cM62183d0.m62377p3("hms_agr_force_query", false);
                    }
                }
            }
        } else {
            C11839m.m70688i("CardNumConfirmActivity", "agreement update success");
            c10028cM62183d0.m62377p3("hms_agr_force_query", false);
            c10028cM62183d0.m62377p3("is_hicloud_terms_confirm", true);
            C11829c.m70604p();
        }
        C13622a.m81969o(this, c11060cM66626a, map);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f16673R1, this.f16674S1, this.f16675T1, this.f16676U1);
    }

    /* renamed from: B6 */
    public final boolean m23053B6() {
        if (this.f21452m.getUserPayType() != 0) {
            if (C11293p.m67757a(this.f21452m).getCapacity() != this.f16680Y1.getCapacity()) {
                return true;
            }
            C11839m.m70688i("CardNumConfirmActivity", "same capacity, no need show estimate rule");
            return false;
        }
        if (this.f16680Y1.getCapacity() != this.f16681Z1.getCapacity().longValue()) {
            C11839m.m70688i("CardNumConfirmActivity", "free user, but has worry free or renewal fail");
            return true;
        }
        C11839m.m70688i("CardNumConfirmActivity", "free user, no need show estimate rule");
        return false;
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f16673R1, this.f16674S1, this.f16675T1, this.f16676U1);
    }

    /* renamed from: C6 */
    public final boolean m23054C6() {
        EstimateResp estimateResp = this.f16681Z1;
        if (estimateResp == null) {
            return false;
        }
        return (1 == estimateResp.getIsAutoPay() || this.f16681Z1.getIsAutoPay() == 0) ? 1 == this.f16681Z1.getIsAutoPay() : m28589p1() && this.f16681Z1.getCapacity().longValue() == C11293p.m67757a(this.f21452m).getCapacity();
    }

    /* renamed from: D6 */
    public final /* synthetic */ void m23055D6(boolean z10) {
        C1442a.m8290i("CardNumConfirmActivity", "postOnUiThread setTitleMaxWidth");
        this.f16660G3 = z10;
        m23042c7();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f16673R1, this.f16674S1, this.f16675T1, this.f16676U1);
    }

    /* renamed from: E6 */
    public final /* synthetic */ void m23056E6(ScanRedeemCodeResult scanRedeemCodeResult) {
        if (scanRedeemCodeResult != null) {
            scanRedeemCodeResult.startActivityForResult(this, 10015);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f16673R1, this.f16674S1, this.f16675T1, this.f16676U1);
    }

    /* renamed from: F6 */
    public final /* synthetic */ void m23057F6(Exception exc) {
        if (exc instanceof IapApiException) {
            IapApiException iapApiException = (IapApiException) exc;
            C1442a.m8289e("CardNumConfirmActivity", "scanRedeemCode iap fail code: " + iapApiException.getStatusCode() + " iapException: " + iapApiException.getMessage());
        } else {
            C1442a.m8289e("CardNumConfirmActivity", "scanRedeemCode other fail code: " + exc.getMessage());
        }
        m23086j7(11);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f16673R1, this.f16674S1, this.f16675T1, this.f16676U1);
    }

    /* renamed from: G6 */
    public final void m23058G6(boolean z10) {
        C11839m.m70688i("CardNumConfirmActivity", "estimate rule checked changed: " + z10);
        m23074W6(z10);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f16673R1, this.f16674S1, this.f16675T1, this.f16676U1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
    }

    /* renamed from: H6 */
    public final void m23059H6() {
        C1442a.m8288d("CardNumConfirmActivity", "card num:" + this.f16685d2);
        this.f16671P1.setChecked(false);
        if (!m22711G5(this.f16685d2) && this.f16706y3.getVisibility() == 0) {
            if (m22712H5(this.f16685d2)) {
                this.f16666K1.setError(getString(R$string.cloudpay_card_input_pwd, 18));
            } else {
                this.f16666K1.setError(getString(R$string.cloudpay_card_input_pwd_error_format));
            }
            m23061J6("number_of_digits_error");
            return;
        }
        if (C11296s.m67786J(this)) {
            m28588o1("06005");
            m28579M1(getString(R$string.cloudpay_card_processing));
            C9158a.m57503F().m57561z(this, this.f16677V1, this.f16685d2, this.f21448i);
        } else {
            C1442a.m8288d("CardNumConfirmActivity", "getCard no network!");
            m22715K5(4004);
            m23061J6("num_confirm_no_net");
        }
    }

    /* renamed from: I6 */
    public final void m23060I6() {
        CardPayResp cardPayResp = this.f16682a2;
        if (cardPayResp == null) {
            C1442a.m8289e("CardNumConfirmActivity", "queryExchangedResult cardPayResp is null.");
            m28583a1();
            m22715K5(4004);
            return;
        }
        this.f16536U.setId(cardPayResp.getId());
        this.f16536U.setRequestId(this.f16682a2.getRequestId());
        CloudSpace cloudSpace = new CloudSpace();
        this.f16520M = cloudSpace;
        cloudSpace.setId(this.f16682a2.getId());
        int signMode = this.f16682a2.getSignMode();
        if (signMode == 2) {
            if (this.f16682a2.getSignStatus() == 0) {
                C1442a.m8290i("CardNumConfirmActivity", "queryExchangedResult dealSignPurchaseSuccess");
                m22878u3(this.f16682a2.getPurchaseInfo(), 7034);
                return;
            } else {
                C1442a.m8290i("CardNumConfirmActivity", "queryExchangedResult IAP_4 startNotifyTask");
                m23087k7();
                return;
            }
        }
        if (signMode != 1) {
            C1442a.m8289e("CardNumConfirmActivity", "queryExchangedResult other signMode = " + signMode);
            m23087k7();
            return;
        }
        if (this.f16682a2.getSignStatus() == 0) {
            C1442a.m8290i("CardNumConfirmActivity", "queryExchangedResult dealQuerySignStatusSuccess");
            m22864q3(this.f16682a2.getSignInfo());
        } else {
            C1442a.m8290i("CardNumConfirmActivity", "queryExchangedResult IAP_2 startNotifyTask");
            m23087k7();
        }
    }

    /* renamed from: J6 */
    public final void m23061J6(String str) {
        m23062K6(1, str);
    }

    /* renamed from: K6 */
    public final void m23062K6(int i10, String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("card_num_confirm_result", String.valueOf(i10));
            linkedHashMapM79497A.put("card_num_confirm_result_desc", str);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CARD_NUM_CONFIRM_RESULT", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_CARD_NUM_CONFIRM_RESULT", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CARD_NUM_CONFIRM_RESULT", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CardNumConfirmActivity", "reportCardNumConfirmFail ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: L6 */
    public final void m23063L6(String str) {
        m23062K6(0, str);
    }

    /* renamed from: M6 */
    public final void m23064M6(int i10) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("get_card_num_way", String.valueOf(i10));
            linkedHashMapM79497A.put("from_where", String.valueOf(this.f16662H3));
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_CARD_NUM_CONFIRM", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_CARD_NUM_CONFIRM", "1", "36", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_CARD_NUM_CONFIRM", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CardNumConfirmActivity", "reportClickCardConfirmButton ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: N6 */
    public final void m23065N6() {
        try {
            if (this.f16680Y1 != null) {
                LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                m28593u1(linkedHashMapM79497A);
                linkedHashMapM79497A.put("package_id", this.f16680Y1.getId());
                linkedHashMapM79497A.put("capacity", String.valueOf(this.f16680Y1.getCapacity()));
                linkedHashMapM79497A.put("productType", String.valueOf(this.f16680Y1.getProductType()));
                linkedHashMapM79497A.put("duration_month", String.valueOf(this.f16680Y1.getDurationMonth()));
                linkedHashMapM79497A.put("price", String.valueOf(this.f16680Y1.getPrice()));
                linkedHashMapM79497A.put("from_where", String.valueOf(this.f16662H3));
                C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_CARD_EXCHANGE", linkedHashMapM79497A);
                UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_CARD_EXCHANGE", "1", "36", linkedHashMapM79497A);
                m28575A1("UNIFORM_CLOUDPAY_CLICK_CARD_EXCHANGE", linkedHashMapM79497A);
            } else {
                m23066O6("fail_report_cardpackage_is_null");
            }
        } catch (Exception e10) {
            C1442a.m8289e("CardNumConfirmActivity", "reportClickCardConfirmButton ERROR OCCUR:" + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O4 */
    public void mo19453O4(int i10, Intent intent) throws JSONException {
        super.mo19453O4(i10, intent);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (i10 == 10015) {
            m23093q6(hiCloudSafeIntent);
        }
    }

    /* renamed from: O6 */
    public final void m23066O6(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        m28593u1(linkedHashMapM79497A);
        m23067P6(1, str, linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: P3 */
    public void mo22790P3(Intent intent) {
        if (intent == null) {
            C1442a.m8289e("CardNumConfirmActivity", "handleIAP4PayResult , data is null");
            m28583a1();
            return;
        }
        PurchaseResultInfo purchaseResultInfoFromIntent = Iap.getIapClient((Activity) this).parsePurchaseResultInfoFromIntent(intent);
        int returnCode = purchaseResultInfoFromIntent.getReturnCode();
        C1442a.m8290i("CardNumConfirmActivity", "handleIAP4PayResult , returnCode = " + returnCode);
        if (returnCode == -1) {
            m22786N3(4002);
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            m28583a1();
            return;
        }
        if (returnCode == 0) {
            String inAppPurchaseData = purchaseResultInfoFromIntent.getInAppPurchaseData();
            C1442a.m8288d("CardNumConfirmActivity", "handleIAP4PayResult inAppPurchaseDataStr = " + inAppPurchaseData);
            C1442a.m8288d("CardNumConfirmActivity", "handleIAP4PayResult inAppPurchaseDataSignature = " + purchaseResultInfoFromIntent.getInAppDataSignature());
            C11296s.m67816g0(this);
            try {
                m22762F3((InAppPurchaseData) new Gson().fromJson(inAppPurchaseData, InAppPurchaseData.class));
                return;
            } catch (JsonSyntaxException e10) {
                C1442a.m8289e("CardNumConfirmActivity", "handleIAP4PayResult e : " + e10.getMessage());
                return;
            }
        }
        if (returnCode == 60000) {
            m28583a1();
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (returnCode == 60003) {
            C1442a.m8290i("CardNumConfirmActivity", "handleIAP4PayResult err,ORDER_STATE_PRODUCT_INVALID");
            m22864q3(this.f16682a2.getSignInfo());
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (returnCode == 60051) {
            m22823b4();
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        m28583a1();
        m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
        m22786N3(4002);
    }

    /* renamed from: P6 */
    public final void m23067P6(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            linkedHashMap.put("card_exchange_result", String.valueOf(i10));
            linkedHashMap.put("card_exchange_result_desc", str);
            linkedHashMap.put("from_where", String.valueOf(this.f16662H3));
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CARD_EXCHANGE_RESULT", linkedHashMap);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_CARD_EXCHANGE_RESULT", linkedHashMap);
            m28575A1("UNIFORM_CLOUDPAY_CARD_EXCHANGE_RESULT", linkedHashMap);
        } catch (Exception e10) {
            C1442a.m8289e("CardNumConfirmActivity", "reportCardNumConfirmFail ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: Q6 */
    public final void m23068Q6(String str, OrderResult orderResult) {
        MemGradeRights gradeRights;
        MemGradeRights gradeRights2;
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        m28593u1(linkedHashMapM79497A);
        UserPackage userPackage = this.f21452m;
        if (userPackage != null && (gradeRights2 = userPackage.getGradeRights()) != null) {
            linkedHashMapM79497A.put("card_exchange_before_grade", gradeRights2.getGradeCode());
        }
        if (orderResult != null && (gradeRights = orderResult.getGradeRights()) != null) {
            linkedHashMapM79497A.put("card_exchange_after_grade", gradeRights.getGradeCode());
        }
        m23067P6(0, str, linkedHashMapM79497A);
    }

    /* renamed from: R6 */
    public final void m23069R6(int i10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
        linkedHashMap.put("key_scan_redeem_error_code", String.valueOf(i10));
        C13227f.m79492i1().m79573U("scan_redeem_error_code", linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S6 */
    public final void m23070S6() {
        m23085i7();
        this.f16679X1 = null;
        this.f16680Y1 = null;
        this.f16684c2 = null;
        this.f16686e2 = null;
        this.f16681Z1 = null;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C9158a.m57503F().m57517O(this.f16677V1, this.f21448i, true, true, "CardNumConfirmActivity");
    }

    /* renamed from: T6 */
    public final void m23071T6(int i10, HiCloudSafeIntent hiCloudSafeIntent) {
        if (i10 == 10015) {
            m23093q6(hiCloudSafeIntent);
        }
    }

    /* renamed from: U6 */
    public final void m23072U6(ConvertInfo convertInfo, CloudSpace cloudSpace) {
        String string;
        String strM67741b = C11290m.m67741b(this, this.f16681Z1.getEndtime().longValue());
        if (this.f16680Y1.getSupportAutoPay() == 1) {
            int isAutoPay = this.f21452m.getIsAutoPay();
            int supportAutoPay = convertInfo.getSupportAutoPay();
            if (isAutoPay == 0) {
                if (supportAutoPay == 1) {
                    if (cloudSpace != null) {
                        string = getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time_and_price, this.f16681Z1.getGrade().getGradeName(), strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this)));
                    } else {
                        string = getString(R$string.cloudpay_exchange_month_package_with_price, strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this));
                    }
                } else if (cloudSpace != null) {
                    string = getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, this.f16681Z1.getGrade().getGradeName(), strM67741b));
                } else {
                    string = getString(R$string.package_info_capacity_package, strM67741b);
                }
            } else if (supportAutoPay == 1) {
                if (cloudSpace != null) {
                    string = getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time_and_price, this.f16681Z1.getGrade().getGradeName(), strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this)));
                } else {
                    string = getString(R$string.cloudpay_exchange_month_package_with_price, strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this));
                }
            } else if (this.f16681Z1.getIsAutoPay() == 1) {
                if (cloudSpace != null) {
                    string = getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time, this.f16681Z1.getGrade().getGradeName(), strM67741b));
                } else {
                    string = getString(R$string.cloudpay_exchange_month_package, strM67741b);
                }
            } else if (cloudSpace != null) {
                string = getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, this.f16681Z1.getGrade().getGradeName(), strM67741b));
            } else {
                string = getString(R$string.package_info_capacity_package, strM67741b);
            }
        } else if (m23054C6()) {
            if (cloudSpace != null) {
                string = getString(R$string.cloudpay_parenthesis, getString(R$string.auto_pay_and_date, this.f16681Z1.getGrade().getGradeName(), strM67741b));
            } else {
                string = getString(R$string.cloudpay_monthly_expire_upd, strM67741b);
            }
        } else if (cloudSpace != null) {
            string = getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, this.f16681Z1.getGrade().getGradeName(), strM67741b));
        } else {
            string = getString(R$string.package_info_capacity_package, strM67741b);
        }
        long jLongValue = this.f16681Z1.getCapacity().longValue();
        if (cloudSpace != null) {
            jLongValue += cloudSpace.getCapacity();
        }
        String string2 = getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, jLongValue), string);
        SpannableString spannableString = new SpannableString(string2);
        try {
            int iIndexOf = string2.indexOf(string);
            spannableString.setSpan(new ForegroundColorSpan(getColor(R$color.emui_functional_red)), iIndexOf, string.length() + iIndexOf, 33);
        } catch (IndexOutOfBoundsException e10) {
            C1442a.m8289e("CardNumConfirmActivity", "showDetailView error: " + e10.toString());
        }
        this.f16651C1.setText(spannableString);
    }

    /* renamed from: V6 */
    public final void m23073V6(CloudSpace cloudSpace) {
        String gradeName = this.f16681Z1.getGrade().getGradeName();
        String productName = cloudSpace != null ? cloudSpace.getProductName() : "";
        if (!TextUtils.isEmpty(productName)) {
            gradeName = gradeName + " + " + productName;
        }
        this.f16701v1.setText(gradeName);
    }

    /* renamed from: W6 */
    public final void m23074W6(boolean z10) {
        AutoSizeButton autoSizeButton = this.f16653D1;
        if (autoSizeButton == null) {
            return;
        }
        if (z10) {
            autoSizeButton.setClickable(true);
            this.f16653D1.setAlpha(1.0f);
        } else {
            autoSizeButton.setClickable(false);
            this.f16653D1.setAlpha(0.62f);
        }
    }

    /* renamed from: X6 */
    public final void m23075X6(CloudSpace cloudSpace) {
        if (this.f16661H1 > 0) {
            String strM67741b = C11290m.m67741b(this, this.f16663I1);
            String strM23099w6 = (!m28589p1() || m28590q1()) ? m23099w6(cloudSpace, false, strM67741b) : m23099w6(cloudSpace, true, strM67741b);
            if (!C11293p.m67774r(this.f21452m)) {
                this.f16699t1.setText(getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, this.f16661H1), strM23099w6));
            } else if (cloudSpace != null) {
                this.f16699t1.setText(C0223k.m1524g(this, this.f16661H1));
            }
        }
    }

    /* renamed from: Y6 */
    public final void m23076Y6(CloudSpace cloudSpace) {
        String strM67763g = C11293p.m67763g(this.f21452m);
        String productName = cloudSpace != null ? cloudSpace.getProductName() : "";
        if (!TextUtils.isEmpty(productName)) {
            if (C11293p.m67774r(this.f21452m)) {
                strM67763g = C11293p.m67766j(this.f21452m);
            } else {
                strM67763g = strM67763g + " + " + productName;
            }
        }
        this.f16692m1.setText(strM67763g);
    }

    /* renamed from: Z6 */
    public final void m23077Z6(EditText editText) {
        editText.setCustomSelectionActionModeCallback(new ActionModeCallbackC3598e(null));
    }

    /* renamed from: a7 */
    public final void m23078a7() {
        Intent intent = new Intent();
        intent.putExtra(MapKeyNames.RESULT_CODE, 0);
        setResult(-1, intent);
    }

    /* renamed from: b7 */
    public final void m23079b7(LearnMorePayClickListener learnMorePayClickListener, String str, String str2) {
        this.f16672Q1.m15931c(str, learnMorePayClickListener);
        this.f16672Q1.m15934g(str2, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: d4 */
    public void mo22829d4(Intent intent) throws JSONException {
        if (intent == null) {
            C1442a.m8291w("CardNumConfirmActivity", "payResult data is null.");
            m28583a1();
            m22786N3(4002);
            m22751C4("failed_by_data_null");
            return;
        }
        try {
            int intExtra = intent.getIntExtra("returnCode", -1);
            C1442a.m8290i("CardNumConfirmActivity", "payResult resultCode = " + intExtra);
            C11060c c11060c = this.f21448i;
            if (c11060c != null) {
                c11060c.m66635A(intent.getStringExtra("errMsg"));
                this.f21448i.m66665u("114_" + intExtra);
            }
            String stringExtra = intent.getStringExtra("withholdID");
            m22819a4(stringExtra);
            if (intExtra != -1) {
                if (intExtra == 0) {
                    mo20372m3(intent, stringExtra);
                    return;
                }
                if (intExtra != 30005 && intExtra != 30006) {
                    if (intExtra == 30031 || intExtra == 30032) {
                        m22751C4("pay_result_hwpay_callback_result_" + intExtra);
                        Toast.makeText(this, getString(com.huawei.cloud.pay.R$string.cloudpay_subscribe_later_try_again), 1).show();
                        m28583a1();
                        return;
                    }
                    if (intExtra != 30099 && intExtra != 907135005) {
                        switch (intExtra) {
                            case 30000:
                                m22849m4();
                                m28583a1();
                                return;
                            case PayStatusCodes.PAY_STATE_PARAM_ERROR /* 30001 */:
                                break;
                            case PayStatusCodes.PAY_STATE_TIME_OUT /* 30002 */:
                                m22751C4("pay_result_hwpay_callback_result_" + intExtra);
                                m22786N3(PayStatusCodes.PAY_STATE_TIME_OUT);
                                m28583a1();
                                return;
                            default:
                                switch (intExtra) {
                                    case PayStatusCodes.PRODUCT_NOT_EXIST /* 40001 */:
                                    case PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED /* 40002 */:
                                    case PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION /* 40003 */:
                                        break;
                                    default:
                                        m22751C4("pay_result_hwpay_callback_result_" + intExtra);
                                        m22786N3(4002);
                                        m28583a1();
                                        break;
                                }
                                return;
                        }
                    }
                }
            }
            m28583a1();
            m22786N3(4002);
            m22751C4("pay_result_hwpay_callback_result_" + intExtra);
        } catch (RuntimeException e10) {
            m22786N3(4002);
            m28583a1();
            m22751C4("pay_result_hwpay_callback_result_" + e10.getMessage());
            C1442a.m8290i("CardNumConfirmActivity", "payResult err = " + e10.getMessage());
        }
    }

    /* renamed from: d7 */
    public final void m23080d7() {
        this.f16706y3.setVisibility(8);
        this.f16708z3.setVisibility(0);
        this.f16648A3.setVisibility(8);
        if (getActionBar() != null) {
            getActionBar().setTitle(R$string.cloudpay_card_detail_title);
        }
        CardPackage cardPackage = this.f16680Y1;
        if (cardPackage == null || this.f16681Z1 == null) {
            C1442a.m8289e("CardNumConfirmActivity", "CardPackage or CloudSpace is null.");
            m23061J6("fail_show_estimate_info");
            setResult(0, null);
            finish();
            return;
        }
        this.f16684c2 = cardPackage.getId();
        GradeCardDisplayBean gradeCardDisplayBean = new GradeCardDisplayBean(this.f16680Y1, this.f16679X1);
        C11828b c11828bM59165b = C9433j.m59164c().m59165b();
        if (this.f16680Y1.getSupportAutoPay() == 1) {
            this.f16689j1.setData(gradeCardDisplayBean, this.f16690k1.getRightTitle(), c11828bM59165b, false, false, this.f16681Z1.getConvertInfo().getSupportAutoPay(), 0, m23090m7(), this.f16660G3);
        } else {
            this.f16689j1.setData(gradeCardDisplayBean, this.f16690k1.getRightTitle(), c11828bM59165b, false, false, this.f16681Z1.getConvertInfo().getSupportAutoPay(), -1, false, this.f16660G3);
        }
        this.f16654D3 = null;
        UserPackage userPackage = this.f21452m;
        if (userPackage != null) {
            this.f16654D3 = C11293p.m67760d(userPackage.getEffectivePackages(), 2);
        }
        m23102z6(this.f16654D3, this.f16660G3);
        ConvertInfo convertInfo = this.f16681Z1.getConvertInfo();
        m23101y6(convertInfo, this.f16660G3);
        if (this.f16680Y1.getSupportAutoPay() == 1) {
            if (convertInfo.getSupportAutoPay() == 1) {
                m23081e7();
            } else {
                m23083g7();
            }
        } else if (m23053B6()) {
            m23074W6(false);
            m23083g7();
        } else {
            this.f16670O1.setVisibility(8);
            m23074W6(true);
        }
        m23082f7();
        m23063L6("success_confirm_card_num");
    }

    /* renamed from: e7 */
    public final void m23081e7() {
        String str;
        this.f16670O1.setVisibility(0);
        m23074W6(false);
        String string = getString(R$string.cloudpay_upgrade_instruction_new);
        String string2 = getString(R$string.cloudpay_continuous_monthly_agreement_new);
        String string3 = getString(R$string.cloudpay_exchange_rule_text, string, string2);
        LearnMorePayClickListener learnMorePayClickListener = new LearnMorePayClickListener(this, m23098v6());
        LearnMorePayClickListener learnMorePayClickListener2 = new LearnMorePayClickListener(this, "/payagreement?lang=");
        this.f16672Q1.m15931c(string, learnMorePayClickListener);
        this.f16672Q1.m15931c(string2, learnMorePayClickListener2);
        String strM1636n = C0234s.m1636n();
        if (TextUtils.isEmpty(strM1636n) || !strM1636n.equals(Constants.AR_CACHE)) {
            str = string3 + "  ";
        } else {
            str = string3 + "   ";
        }
        this.f16672Q1.m15935h(str, false, true);
    }

    /* renamed from: f7 */
    public final void m23082f7() {
        if (this.f16669N1 == null) {
            C1442a.m8290i("CardNumConfirmActivity", "showEstimateHintText() estimateHintText is null.");
            return;
        }
        String strM23096t6 = m23096t6();
        if (TextUtils.isEmpty(strM23096t6)) {
            this.f16669N1.setVisibility(8);
        } else {
            this.f16669N1.setVisibility(0);
            this.f16669N1.setText(strM23096t6);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
    }

    /* renamed from: g7 */
    public final void m23083g7() {
        this.f16670O1.setVisibility(0);
        m23074W6(false);
        String string = getString(R$string.cloudpay_upgrade_instruction_new);
        m23079b7(new LearnMorePayClickListener(this, m23098v6()), string, getString(R$string.cloudpay_card_estimate_rule_text, string));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16687h1);
        arrayList.add(this.f16688i1);
        arrayList.add(this.f16708z3);
        arrayList.add(this.f16648A3);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
    }

    /* renamed from: h7 */
    public final void m23084h7(int i10, long j10) {
        CloudSpace cloudSpaceM67760d;
        this.f16664I3 = true;
        this.f16706y3.setVisibility(8);
        this.f16708z3.setVisibility(8);
        this.f16648A3.setVisibility(0);
        if (getActionBar() != null) {
            getActionBar().setTitle(R$string.cloudpay_upgrade_storage);
        }
        EstimateResp estimateResp = this.f16681Z1;
        long jLongValue = estimateResp != null ? estimateResp.getCapacity().longValue() : 0L;
        UserPackage userPackage = this.f21452m;
        if (userPackage != null) {
            cloudSpaceM67760d = C11293p.m67760d(userPackage.getEffectivePackages(), 2);
            if (cloudSpaceM67760d != null) {
                jLongValue += cloudSpaceM67760d.getCapacity();
            }
        } else {
            cloudSpaceM67760d = null;
        }
        if (1 != i10) {
            C1442a.m8290i("CardNumConfirmActivity", "showExchangedView Fixed Time.");
            if (cloudSpaceM67760d != null) {
                this.f16704x3.setText(getString(R$string.card_num_valid, C0223k.m1524g(this, this.f16659G1 + jLongValue), this.f16681Z1.getGrade().getGradeName(), C11290m.m67741b(this, j10)));
                return;
            } else {
                this.f16704x3.setText(getString(R$string.cloudpay_card_exchanged_hint, C0223k.m1524g(this, this.f16659G1 + jLongValue), C11290m.m67741b(this, j10)));
                return;
            }
        }
        C1442a.m8290i("CardNumConfirmActivity", "showExchangedView AUTOPAY_MONTH.");
        String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this, this.f16659G1 + jLongValue));
        if (cloudSpaceM67760d != null) {
            this.f16704x3.setText(getString(R$string.card_num_next, strM1157C0, this.f16681Z1.getGrade().getGradeName(), C11290m.m67741b(this, j10)));
        } else {
            this.f16704x3.setText(getString(R$string.cloudpay_card_exchanged_month_hint, strM1157C0, C11290m.m67741b(this, j10)));
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "CardNumConfirmActivity";
    }

    /* renamed from: i7 */
    public final void m23085i7() {
        this.f16706y3.setVisibility(0);
        this.f16708z3.setVisibility(8);
        this.f16648A3.setVisibility(8);
        if (getActionBar() != null) {
            GetClientUIConfigResp getClientUIConfigResp = this.f16690k1;
            if (getClientUIConfigResp == null || TextUtils.isEmpty(getClientUIConfigResp.getPromotionCardTitle())) {
                getActionBar().setTitle(R$string.cloudpay_card_exchange_title);
            } else {
                getActionBar().setTitle(this.f16690k1.getPromotionCardTitle());
            }
        }
    }

    /* renamed from: j7 */
    public final void m23086j7(int i10) {
        if (this.f16658F3 == null) {
            this.f16658F3 = new ScanRedeemResultDialog(this);
        }
        this.f16658F3.show(i10);
        m23069R6(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
    }

    /* renamed from: k7 */
    public final void m23087k7() {
        this.f16677V1.postDelayed(new RunnableC3596c(), 3000L);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l3 */
    public void mo22846l3(Object obj) {
        if (obj instanceof OrderResult) {
            this.f16683b2 = (OrderResult) obj;
        }
        if (!"Valid".equals(this.f16683b2.getStatus())) {
            m23066O6("fail_card_exchange_notify" + this.f16683b2.getStatus());
            m23092p6();
            return;
        }
        C1442a.m8290i("CardNumConfirmActivity", "dealNotifySuccess, order is valid.");
        this.f21448i.m66668x("1");
        C13622a.m81968n(this, this.f21448i);
        C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
        m28583a1();
        m23084h7(this.f16683b2.getIsAutoPay(), this.f16683b2.getEndTime());
        C1442a.m8288d("CardNumConfirmActivity", "sendPaySuccessBroadcast, card get notify success, backup frequency is " + this.f16562i0);
        C11296s.m67818h0(this, this.f16683b2.getGradeRights(), this.f16562i0);
        m22816Z3();
        C1399b.m8034o().m8053t(false);
        m23068Q6("exchange_success", this.f16683b2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
    }

    /* renamed from: l7 */
    public final void m23088l7() {
        Iap.getIapClient((Activity) this).scanRedeemCode().addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.i
            @Override // p208cq.InterfaceC8939g
            public final void onSuccess(Object obj) {
                this.f17549a.m23056E6((ScanRedeemCodeResult) obj);
            }
        }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.j
            @Override // p208cq.InterfaceC8938f
            public final void onFailure(Exception exc) {
                this.f17551a.m23057F6(exc);
            }
        });
        C13227f.m79492i1().m79585f0("scan_redeem_code", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "scan_redeem_code", "1", "36");
    }

    /* renamed from: m6 */
    public final String m23089m6(CardPackage cardPackage, EstimateResp estimateResp) throws Resources.NotFoundException {
        ConvertInfo convertInfo = estimateResp.getConvertInfo();
        NumberFormat numberFormat = NumberFormat.getInstance();
        int durationMonth = cardPackage.getDurationMonth();
        String quantityString = getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, durationMonth, numberFormat.format(durationMonth));
        int packageConvertDays = convertInfo.getPackageConvertDays();
        String quantityString2 = getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_day, packageConvertDays, numberFormat.format(packageConvertDays));
        String gradeName = this.f16679X1.getGradeName();
        return getString(R$string.cloudpay_card_estimate_hint_big_buy_small, cardPackage.getSupportAutoPay() == 1 ? m23097u6(cardPackage, gradeName) : getString(R$string.cloudpay_package_urse_space_detail, gradeName, getString(R$string.cloudpay_parenthesis, quantityString)), getString(R$string.cloudpay_package_urse_space_detail, estimateResp.getGrade().getGradeName(), getString(R$string.cloudpay_parenthesis, quantityString2)));
    }

    /* renamed from: m7 */
    public boolean m23090m7() {
        CardPackage cardPackage;
        CloudSpace cloudSpaceM67759c = C11293p.m67759c(this.f21452m, 0);
        return (cloudSpaceM67759c == null || cloudSpaceM67759c.getType() != 0 || cloudSpaceM67759c.getCapacity() != 0 || (cardPackage = this.f16680Y1) == null || this.f16681Z1 == null || cardPackage.getCapacity() == this.f16681Z1.getCapacity().longValue()) ? false : true;
    }

    /* renamed from: n6 */
    public final String m23091n6(EstimateResp estimateResp) throws Resources.NotFoundException {
        ConvertInfo convertInfo = estimateResp.getConvertInfo();
        NumberFormat numberFormat = NumberFormat.getInstance();
        int remainDays = convertInfo.getRemainDays();
        Resources resources = getResources();
        int i10 = R$plurals.cloudpay_package_duration_time_unit_day;
        String quantityString = resources.getQuantityString(i10, remainDays, numberFormat.format(remainDays));
        int convertDays = convertInfo.getConvertDays();
        String quantityString2 = getResources().getQuantityString(i10, convertDays, numberFormat.format(convertDays));
        String gradeName = C11293p.m67757a(this.f21452m).getGradeName();
        String gradeName2 = estimateResp.getGrade().getGradeName();
        int i11 = R$string.cloudpay_package_urse_space_detail;
        int i12 = R$string.cloudpay_parenthesis;
        String string = getString(i11, gradeName, getString(i12, quantityString));
        String string2 = getString(i11, gradeName2, getString(i12, quantityString2));
        return this.f16680Y1.getSupportAutoPay() == 1 ? getString(R$string.cloudpay_card_estimate_hint_small_buy_big, string, string2) : (m28589p1() && convertInfo.getSupportAutoPay() == 0) ? getString(R$string.cloudpay_card_estimate_hint_monthly_small_buy_big, gradeName, string, string2) : getString(R$string.cloudpay_card_estimate_hint_small_buy_big, string, string2);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        C1442a.m8290i("CardNumConfirmActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (i11 == -1) {
            mo19453O4(i10, hiCloudSafeIntent);
        } else if (i11 != 8903) {
            if (i11 != 10028) {
                m23071T6(i10, hiCloudSafeIntent);
            } else {
                m23052o6(i11, hiCloudSafeIntent);
            }
        } else if (this.f16650B3 != null) {
            C13195l.m79272J().m79297M(this, this.f16650B3.m65437v(), i11, hiCloudSafeIntent);
        }
        super.onActivityResult(i10, i11, hiCloudSafeIntent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        View view = this.f16708z3;
        if (view != null && view.getVisibility() == 0) {
            m23070S6();
            return;
        }
        if (this.f16664I3) {
            m23078a7();
        }
        super.onBackPressed();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == R$id.estimate_rule_checkbox) {
            m23058G6(z10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.card_exchange == id2) {
            m23064M6(1);
            m22713I5();
            this.f16685d2 = this.f16667L1.getText().toString();
            m23059H6();
            return;
        }
        if (R$id.card_submit != id2) {
            if (R$id.card_ok_btn != id2) {
                if (R$id.scan_redeem_code == id2) {
                    m23088l7();
                    return;
                }
                return;
            } else {
                if (TextUtils.isEmpty(this.f16652C3) || !this.f16652C3.equals("huawei_card_enter")) {
                    m22714J5(0);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(this, CloudSpaceUpgradeActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        }
        if (!C11296s.m67786J(this)) {
            m23066O6("fail_click_exchange_no_net");
            C1442a.m8288d("CardNumConfirmActivity", "createCard no network!");
            m22715K5(4004);
        } else {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("CardNumConfirmActivity", "card_submit click too fast");
                return;
            }
            m23065N6();
            m28579M1(getString(R$string.cloudpay_card_exchanging));
            if (this.f16680Y1.getSupportAutoPay() != 1) {
                C1442a.m8290i("CardNumConfirmActivity", "card_submit click old");
                C9158a.m57503F().m57541g(this.f16677V1, this.f16686e2, this.f16684c2, this.f21448i);
                return;
            }
            C1442a.m8290i("CardNumConfirmActivity", "card_submit click new");
            if (C11296s.m67798V()) {
                C9158a.m57503F().m57543h(this.f16677V1, this.f16686e2, this.f16684c2, this.f21448i, C11296s.m67834r(), 2);
            } else {
                C9158a.m57503F().m57543h(this.f16677V1, this.f16686e2, this.f16684c2, this.f21448i, C11296s.m67834r(), 1);
            }
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70866t1(this, this.f16653D1);
        C11842p.m70866t1(this, this.f16668M1);
        C11842p.m70866t1(this, this.f16655E1);
        m23042c7();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(8192, 8192);
            try {
                Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", Integer.TYPE);
                AccessController.doPrivileged(new C3599f(declaredMethod, null));
                declaredMethod.invoke(window, Integer.valueOf(ARImageMetadata.LENS_APERTURE));
            } catch (ClassNotFoundException e10) {
                C1442a.m8289e("CardNumConfirmActivity", "onCreate:" + e10.toString());
            } catch (IllegalAccessException e11) {
                C1442a.m8289e("CardNumConfirmActivity", "onCreate:" + e11.toString());
            } catch (NoSuchMethodException e12) {
                C1442a.m8289e("CardNumConfirmActivity", "onCreate:" + e12.toString());
            } catch (InvocationTargetException e13) {
                C1442a.m8289e("CardNumConfirmActivity", "onCreate:" + e13.toString());
            }
        }
        super.onCreate(bundle);
        this.f16664I3 = false;
        setContentView(R$layout.pay_card_num_confirm_activity);
        m28588o1("06008");
        C9158a.m57503F().m57517O(this.f16677V1, this.f21448i, true, true, "CardNumConfirmActivity");
        m23023A6();
        m28587n1();
        m23085i7();
        mo23770l1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BaseCardActivity, com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        HandlerC3597d handlerC3597d = this.f16677V1;
        if (handlerC3597d != null) {
            handlerC3597d.removeCallbacksAndMessages(null);
            this.f16677V1 = null;
        }
        C10718a c10718a = this.f16650B3;
        if (c10718a != null) {
            c10718a.m65430k();
            this.f16650B3.m65438x();
        }
        ScanRedeemResultDialog scanRedeemResultDialog = this.f16658F3;
        if (scanRedeemResultDialog == null || !scanRedeemResultDialog.isShowing()) {
            return;
        }
        this.f16658F3.dismiss();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            super.onOptionsItemSelected(menuItem);
            return true;
        }
        View view = this.f16708z3;
        if (view != null && view.getVisibility() == 0) {
            m23070S6();
            return true;
        }
        if (this.f16664I3) {
            m23078a7();
        }
        super.onOptionsItemSelected(menuItem);
        return true;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        C10718a c10718a = this.f16650B3;
        if (c10718a != null) {
            c10718a.m65431l();
        }
    }

    /* renamed from: p6 */
    public final void m23092p6() {
        if (!this.f16678W1) {
            m28583a1();
            m22715K5(799);
        } else {
            this.f16678W1 = false;
            C1442a.m8290i("CardNumConfirmActivity", "dealNotifyErr is first.");
            m23087k7();
        }
    }

    /* renamed from: q6 */
    public final void m23093q6(HiCloudSafeIntent hiCloudSafeIntent) {
        RedeemCodeResultInfo redeemCodeResultInfoFromIntent = Iap.getIapClient((Activity) this).parseRedeemCodeResultInfoFromIntent(hiCloudSafeIntent);
        int returnCode = redeemCodeResultInfoFromIntent.getReturnCode();
        if (returnCode == -1) {
            m23086j7(-1);
        } else if (returnCode == 0) {
            m23094r6(redeemCodeResultInfoFromIntent);
        } else if (returnCode != 60000 && returnCode != 70000) {
            m23086j7(11);
        }
        C1442a.m8291w("CardNumConfirmActivity", "dealScanRedeemCode redeemReturnCode: " + returnCode);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: r3 */
    public void mo22868r3(int i10) {
        C1442a.m8290i("CardNumConfirmActivity", "dealQuerySubOrderStatusFail code = " + i10);
        m22751C4("failed_by_sub_order_query_exception_" + i10);
        m22786N3(i10);
    }

    /* renamed from: r6 */
    public final void m23094r6(RedeemCodeResultInfo redeemCodeResultInfo) {
        HwEditText hwEditText;
        String redeemCode = redeemCodeResultInfo.getRedeemCode();
        HwErrorTipTextLayout hwErrorTipTextLayout = this.f16666K1;
        if (hwErrorTipTextLayout == null) {
            C1442a.m8291w("CardNumConfirmActivity", "cardInputNumLayoutTwo is null");
            return;
        }
        if (!TextUtils.isEmpty(hwErrorTipTextLayout.getError())) {
            this.f16666K1.setError(null);
        }
        if (TextUtils.isEmpty(redeemCode) || (hwEditText = this.f16667L1) == null) {
            C1442a.m8291w("CardNumConfirmActivity", "redeemCode is empty or cardInput is null");
            return;
        }
        hwEditText.setText(redeemCode);
        this.f16667L1.setSelection(redeemCode.length());
        C1442a.m8288d("CardNumConfirmActivity", "check QRCode success redeemCode: " + redeemCode);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s3 */
    public void mo22871s3(Object obj) {
        if (obj == null || !(obj instanceof QuerySubOrderStatusResp)) {
            C1442a.m8291w("CardNumConfirmActivity", "dealQuerySubOrderStatusSuccess object is null.");
            m28583a1();
            m22751C4("failed_by_sign_check_failed");
            m22786N3(4002);
            return;
        }
        QuerySubOrderStatusResp querySubOrderStatusResp = (QuerySubOrderStatusResp) obj;
        this.f21448i.m66668x("1");
        C13622a.m81968n(this, this.f21448i);
        C13108a.m78878b(this).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
        m28583a1();
        m23084h7(1, querySubOrderStatusResp.getEndTime());
        C1442a.m8288d("CardNumConfirmActivity", "sendPaySuccessBroadcast, card get notify success, backup frequency is " + this.f16562i0);
        C11296s.m67818h0(this, querySubOrderStatusResp.getGradeRights(), this.f16562i0);
        m22816Z3();
        C1399b.m8034o().m8053t(false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
    }

    /* renamed from: s6 */
    public String m23095s6(int i10, NumberFormat numberFormat, CardPackage cardPackage, String str) throws Resources.NotFoundException {
        int durationUnit = cardPackage.getDurationUnit();
        if (durationUnit == 1) {
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_day, i10, numberFormat.format(i10))));
        }
        if (durationUnit == 2) {
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, i10, numberFormat.format(i10))));
        }
        if (durationUnit != 3) {
            return "";
        }
        return getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, i10, numberFormat.format(i10))));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0043  */
    /* renamed from: t6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m23096t6() {
        /*
            r13 = this;
            com.huawei.cloud.pay.model.UserPackage r0 = r13.f21452m
            com.huawei.cloud.pay.model.CloudSpace r0 = p454lj.C11293p.m67757a(r0)
            long r1 = r0.getCapacity()
            com.huawei.cloud.pay.model.CardPackage r3 = r13.f16680Y1
            long r3 = r3.getCapacity()
            int r5 = r0.getType()
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 != 0) goto L3b
            long r9 = r0.getCapacity()
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L3b
            com.huawei.cloud.pay.model.EstimateResp r0 = r13.f16681Z1
            java.lang.Long r0 = r0.getCapacity()
            long r1 = r0.longValue()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L32
            goto L3f
        L32:
            long r0 = r0.longValue()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            goto L43
        L3b:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L41
        L3f:
            r8 = r7
            goto L44
        L41:
            if (r0 >= 0) goto L44
        L43:
            r8 = r6
        L44:
            if (r8 != r7) goto L4f
            com.huawei.cloud.pay.model.CardPackage r0 = r13.f16680Y1
            com.huawei.cloud.pay.model.EstimateResp r1 = r13.f16681Z1
            java.lang.String r13 = r13.m23089m6(r0, r1)
            goto L61
        L4f:
            if (r8 != r6) goto L58
            com.huawei.cloud.pay.model.EstimateResp r0 = r13.f16681Z1
            java.lang.String r13 = r13.m23091n6(r0)
            goto L61
        L58:
            java.lang.String r13 = "CardNumConfirmActivity"
            java.lang.String r0 = "capacity is same, no need show estimate hint, error"
            p054cj.C1442a.m8289e(r13, r0)
            java.lang.String r13 = ""
        L61:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.CardNumConfirmActivity.m23096t6():java.lang.String");
    }

    /* renamed from: u6 */
    public final String m23097u6(CardPackage cardPackage, String str) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        int durationMonth = cardPackage.getDurationMonth();
        int supportAutoPay = this.f16681Z1.getConvertInfo().getSupportAutoPay();
        if (supportAutoPay == 0) {
            return m23095s6(durationMonth, numberFormat, cardPackage, str);
        }
        if (supportAutoPay == 1) {
            if (m23090m7()) {
                return m23095s6(durationMonth, numberFormat, cardPackage, str);
            }
            if (cardPackage.getDurationUnit() == 2) {
                return durationMonth == 1 ? getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, getResources().getString(R$string.cloudpay_renew_month))) : durationMonth == 12 ? getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, getResources().getString(R$string.cloudpay_renew_year))) : getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, getResources().getString(R$string.cloudpay_continuous_monthly_title_new)));
            }
        }
        return "";
    }

    /* renamed from: v6 */
    public final String m23098v6() {
        return C13452e.m80781L().m80887a1() ? "/changespace3?lang=" : "/changespace?lang=";
    }

    /* renamed from: w6 */
    public final String m23099w6(CloudSpace cloudSpace, boolean z10, String str) {
        String strM67766j = C11293p.m67766j(this.f21452m);
        return z10 ? cloudSpace != null ? getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time, strM67766j, str)) : getString(R$string.cloudpay_parenthesis, getString(R$string.auto_pay_member_tip, str)) : cloudSpace != null ? getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, strM67766j, str)) : getString(R$string.package_info_capacity_package, str);
    }

    /* renamed from: x6 */
    public final void m23100x6(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CardNumConfirmActivity", "handleShowChangeSpaceAgreement host is empty");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str + m23098v6() + C0234s.m1627e() + "#card"));
        PackageManager packageManager = getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            return;
        }
        startActivity(intent);
    }

    /* renamed from: y6 */
    public final void m23101y6(ConvertInfo convertInfo, boolean z10) {
        this.f16700u1.setText(getString(R$string.cloudpay_card_title_after_exchange));
        this.f16702w1.setText(this.f16690k1.getPlanDetailUesdSpaceTile());
        this.f16707z1.setText(this.f16690k1.getPlanDetailPaySpaceTile());
        if (z10) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16700u1.getLayoutParams();
            layoutParams.setMarginEnd(0);
            this.f16700u1.setLayoutParams(layoutParams);
            this.f16701v1.setText(getString(R$string.cloudpay_bm_current_plan_value, this.f16681Z1.getGrade().getGradeName(), C0223k.m1524g(this, convertInfo.getTotalCapacity())));
            this.f16705y1.setVisibility(8);
        } else {
            m23073V6(this.f16654D3);
            this.f16703x1.setText(this.f16690k1.getPlanDetailFreeSpaceTile());
            CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
            if (cloudSpaceM67757a != null) {
                this.f16649B1.setText(C0223k.m1524g(this, cloudSpaceM67757a.getBaseCapacity()));
            } else {
                this.f16649B1.setText(C0223k.m1524g(this, this.f16659G1));
            }
        }
        this.f16647A1.setText(C11290m.m67751l(this, this.f16665J1, convertInfo.getTotalCapacity()));
        m23072U6(convertInfo, this.f16654D3);
    }

    /* renamed from: z6 */
    public final void m23102z6(CloudSpace cloudSpace, boolean z10) {
        if (!z10) {
            this.f16691l1.setText(getString(R$string.cloudpay_card_title_before_exchange));
            this.f16694o1.setText(this.f16690k1.getPlanDetailUesdSpaceTile());
            this.f16695p1.setText(this.f16690k1.getPlanDetailFreeSpaceTile());
            this.f16696q1.setText(this.f16690k1.getPlanDetailPaySpaceTile());
            m23076Y6(cloudSpace);
            this.f16697r1.setText(C11290m.m67751l(this, this.f16665J1, this.f21452m.getTotalCapacity()));
            CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
            if (cloudSpaceM67757a != null) {
                this.f16698s1.setText(C0223k.m1524g(this, cloudSpaceM67757a.getBaseCapacity()));
            } else {
                this.f16698s1.setText(C0223k.m1524g(this, this.f16659G1));
            }
            this.f16698s1.setText(C0223k.m1524g(this, this.f16659G1));
            m23075X6(cloudSpace);
            return;
        }
        this.f16693n1.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16691l1.getLayoutParams();
        layoutParams.setMarginEnd(0);
        this.f16691l1.setLayoutParams(layoutParams);
        List<CloudSpace> effectivePackages = this.f21452m.getEffectivePackages();
        CloudSpace cloudSpace2 = null;
        if (effectivePackages.size() != 0) {
            for (CloudSpace cloudSpace3 : effectivePackages) {
                if (cloudSpace2 == null || cloudSpace3.getCapacity() > cloudSpace2.getCapacity()) {
                    cloudSpace2 = cloudSpace3;
                }
            }
        }
        this.f16691l1.setText(getString(R$string.cloudpay_bm_current_plan, CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(cloudSpace2.getGradeCode()) ? cloudSpace2.getGradeName() : getString(R$string.cloudpay_bm_current_plan_value, cloudSpace2.getGradeName(), C0223k.m1524g(this, this.f21452m.getTotalCapacity()))));
    }
}
