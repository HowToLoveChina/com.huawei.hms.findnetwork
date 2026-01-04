package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import ca.C1399b;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.activity.GuideWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.ConfirmBuyPackageDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.MemberQuitFamilyShareDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.PayResultErrorDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.HicloudPushGuideDialog;
import com.huawei.cloud.pay.R$plurals;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.AcceptSignGiftResp;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CampaignInfo;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.ConvertInfo;
import com.huawei.cloud.pay.model.CreateFreeOrderResp;
import com.huawei.cloud.pay.model.CreateOrder;
import com.huawei.cloud.pay.model.DlAppCampInfo;
import com.huawei.cloud.pay.model.EstimateResp;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.FilterDataForRecommend;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetAvaVouchersResp;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetGradeRightDetailResp;
import com.huawei.cloud.pay.model.H5WMPayUrlAttr;
import com.huawei.cloud.pay.model.InAppPurchaseData;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.MonthOrder;
import com.huawei.cloud.pay.model.MonthSign;
import com.huawei.cloud.pay.model.NotifyReq;
import com.huawei.cloud.pay.model.OrderResult;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.PaySuccessShowNeedData;
import com.huawei.cloud.pay.model.Payload;
import com.huawei.cloud.pay.model.QuerySignStatusResp;
import com.huawei.cloud.pay.model.QuerySubOrderStatusResp;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.Response;
import com.huawei.cloud.pay.model.SignPurchaseResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.base.bean.FamilyShareInfoResult;
import com.huawei.hicloud.base.bean.RetResult;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.BasicBaseResp;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.agreement.request.QueryPushGuideRsp;
import com.huawei.hicloud.request.basic.bean.GetUserRegisterResp;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.iap.Iap;
import com.huawei.hms.iap.IapApiException;
import com.huawei.hms.iap.entity.IsEnvReadyResult;
import com.huawei.hms.iap.entity.OwnedPurchasesReq;
import com.huawei.hms.iap.entity.OwnedPurchasesResult;
import com.huawei.hms.iap.entity.PurchaseIntentReq;
import com.huawei.hms.iap.entity.PurchaseIntentResult;
import com.huawei.hms.iap.entity.PurchaseResultInfo;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.api.pay.PayResult;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9158a;
import gp.C10028c;
import hu.C10342a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.function.Function;
import je.C10804r;
import mk.C11477c;
import org.json.JSONException;
import org.json.JSONObject;
import p010a9.C0079a;
import p014aj.C0202a;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0225l;
import p015ak.C0226l0;
import p020ap.C1008c;
import p054cj.C1442a;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p329h7.C10121i;
import p429kk.C11060c;
import p454lj.C11282e;
import p454lj.C11293p;
import p454lj.C11296s;
import p454lj.C11303z;
import p514o9.C11829c;
import p514o9.C11839m;
import p572qb.C12303d;
import p572qb.C12331w;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13197n;
import p684un.C13222a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p771xd.HandlerC13762f;
import p778xk.C13823d;
import tj.C13019a;

/* loaded from: classes3.dex */
public abstract class BuyPackageBaseActivity extends BasePayActivity {

    /* renamed from: g1 */
    public static final HashMap<String, String> f16497g1 = new C3573c();

    /* renamed from: B0 */
    public AlertDialog f16499B0;

    /* renamed from: C */
    public String f16500C;

    /* renamed from: D */
    public String f16502D;

    /* renamed from: E0 */
    public MemberQuitFamilyShareDialog f16505E0;

    /* renamed from: F */
    public String f16506F;

    /* renamed from: F0 */
    public String f16507F0;

    /* renamed from: G */
    public String f16508G;

    /* renamed from: G0 */
    public Payload f16509G0;

    /* renamed from: H */
    public String f16510H;

    /* renamed from: H0 */
    public String f16511H0;

    /* renamed from: I */
    public String f16512I;

    /* renamed from: I0 */
    public ChannelInfo f16513I0;

    /* renamed from: J */
    public String f16514J;

    /* renamed from: J0 */
    public boolean f16515J0;

    /* renamed from: K */
    public String f16516K;

    /* renamed from: K0 */
    public String f16517K0;

    /* renamed from: L */
    public H5WMPayUrlAttr f16518L;

    /* renamed from: L0 */
    public String f16519L0;

    /* renamed from: M */
    public CloudSpace f16520M;

    /* renamed from: M0 */
    public boolean f16521M0;

    /* renamed from: N */
    public ConfirmBuyPackageDialog f16522N;

    /* renamed from: Q */
    public PayResultErrorDialog f16528Q;

    /* renamed from: R */
    public Response f16530R;

    /* renamed from: S */
    public boolean f16532S;

    /* renamed from: T */
    public boolean f16534T;

    /* renamed from: T0 */
    public List<Voucher> f16535T0;

    /* renamed from: U0 */
    public QueryPushGuideRsp f16537U0;

    /* renamed from: V */
    public GetClientUIConfigResp f16538V;

    /* renamed from: V0 */
    public BigDecimal f16539V0;

    /* renamed from: W */
    public ArrayList<FilterAvailabalGradePackage> f16540W;

    /* renamed from: W0 */
    public SignPurchaseResp f16541W0;

    /* renamed from: X */
    public ArrayList<FilterAvailabalGradePackage> f16542X;

    /* renamed from: X0 */
    public boolean f16543X0;

    /* renamed from: Y0 */
    public CampaignInfo f16545Y0;

    /* renamed from: Z */
    public GetUserRegisterResp f16546Z;

    /* renamed from: Z0 */
    public AcceptSignGiftResp f16547Z0;

    /* renamed from: a0 */
    public ArrayList<FilterAvailabalGradePackage> f16548a0;

    /* renamed from: a1 */
    public String f16549a1;

    /* renamed from: b0 */
    public FamilyShareInfoResult f16550b0;

    /* renamed from: b1 */
    public String f16551b1;

    /* renamed from: c1 */
    public boolean f16553c1;

    /* renamed from: d0 */
    public AlertDialog f16554d0;

    /* renamed from: e1 */
    public boolean f16557e1;

    /* renamed from: f1 */
    public ConfirmRenewAgreementDialog f16559f1;

    /* renamed from: g0 */
    public String f16560g0;

    /* renamed from: i0 */
    public int f16562i0;

    /* renamed from: k0 */
    public CloudPackage f16564k0;

    /* renamed from: l0 */
    public int f16565l0;

    /* renamed from: m0 */
    public int f16566m0;

    /* renamed from: n0 */
    public GetGradeRightDetailResp f16567n0;

    /* renamed from: o0 */
    public GetAvailableGradePackagesResp f16568o0;

    /* renamed from: q0 */
    public String f16570q0;

    /* renamed from: r0 */
    public String f16571r0;

    /* renamed from: s0 */
    public int f16572s0;

    /* renamed from: t0 */
    public int f16573t0;

    /* renamed from: u0 */
    public String f16574u0;

    /* renamed from: v0 */
    public AdParametersExt f16575v0;

    /* renamed from: w0 */
    public String f16576w0;

    /* renamed from: x0 */
    public Dialog f16577x0;

    /* renamed from: y0 */
    public HicloudPushGuideDialog f16578y0;

    /* renamed from: E */
    public int f16504E = -1;

    /* renamed from: O */
    public HandlerC3583m f16524O = new HandlerC3583m(this);

    /* renamed from: P */
    public HandlerC13762f f16526P = new HandlerC13762f(this);

    /* renamed from: U */
    public NotifyReq f16536U = new NotifyReq();

    /* renamed from: Y */
    public boolean f16544Y = false;

    /* renamed from: c0 */
    public boolean f16552c0 = false;

    /* renamed from: e0 */
    public boolean f16556e0 = false;

    /* renamed from: f0 */
    public boolean f16558f0 = false;

    /* renamed from: h0 */
    public Gson f16561h0 = new Gson();

    /* renamed from: j0 */
    public ArrayList<Voucher> f16563j0 = new ArrayList<>();

    /* renamed from: p0 */
    public int f16569p0 = 0;

    /* renamed from: z0 */
    public volatile boolean f16579z0 = false;

    /* renamed from: A0 */
    public volatile boolean f16498A0 = false;

    /* renamed from: C0 */
    public boolean f16501C0 = false;

    /* renamed from: D0 */
    public int f16503D0 = 0;

    /* renamed from: N0 */
    public String f16523N0 = "";

    /* renamed from: O0 */
    public boolean f16525O0 = false;

    /* renamed from: P0 */
    public boolean f16527P0 = false;

    /* renamed from: Q0 */
    public boolean f16529Q0 = false;

    /* renamed from: R0 */
    public boolean f16531R0 = false;

    /* renamed from: S0 */
    public boolean f16533S0 = false;

    /* renamed from: d1 */
    public String f16555d1 = "";

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$a */
    public class C3571a implements InterfaceC8938f {
        public C3571a() {
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            C1442a.m8289e("BuyPackageBaseActivity", "obtainOwnedPurchases mSignPurchaseResp onFailure.");
            BuyPackageBaseActivity.this.m22786N3(4002);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$b */
    public class C3572b implements InterfaceC8939g<OwnedPurchasesResult> {
        public C3572b() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(OwnedPurchasesResult ownedPurchasesResult) {
            C1442a.m8290i("BuyPackageBaseActivity", "obtainOwnedPurchases mSignPurchaseResp onSuccess.");
            if (ownedPurchasesResult == null || ownedPurchasesResult.getInAppPurchaseDataList() == null || ownedPurchasesResult.getInAppPurchaseDataList().isEmpty()) {
                BuyPackageBaseActivity.this.m22786N3(5);
                return;
            }
            for (int i10 = 0; i10 < ownedPurchasesResult.getInAppPurchaseDataList().size(); i10++) {
                try {
                    BuyPackageBaseActivity.this.m22766G3((InAppPurchaseData) new Gson().fromJson(ownedPurchasesResult.getInAppPurchaseDataList().get(i10), InAppPurchaseData.class), false);
                    return;
                } catch (JsonSyntaxException e10) {
                    C1442a.m8289e("BuyPackageBaseActivity", "obtainOwnedPurchases e : " + e10.getMessage());
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$c */
    public class C3573c extends HashMap<String, String> {
        public C3573c() {
            put("upgrade_purchase", "upgrade_purchase_success");
            put("pay_manage_purchase", "pay_manage_purchase_success");
            put("recommend_purchase", "recommend_purchase_success");
            put("cloud_card_purchase", "cloud_card_purchase_success");
            put("h5_purchase", "upgrade_purchase_success");
            put("push_guide_purchase", "push_guide_purchase_success");
            put("backup_dialog_purchase", "backup_dialog_purchase_success");
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$d */
    public class RunnableC3574d implements Runnable {
        public RunnableC3574d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C11296s.m67786J(BuyPackageBaseActivity.this.getApplicationContext())) {
                BuyPackageBaseActivity.this.m22786N3(4004);
                BuyPackageBaseActivity.this.m22751C4("failed_by_get_notify_no_net");
            } else {
                C9158a c9158aM57503F = C9158a.m57503F();
                BuyPackageBaseActivity buyPackageBaseActivity = BuyPackageBaseActivity.this;
                c9158aM57503F.m57509G(buyPackageBaseActivity.f16524O, buyPackageBaseActivity.f16536U, buyPackageBaseActivity.f21448i);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$e */
    public class RunnableC3575e implements Runnable {
        public RunnableC3575e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C11296s.m67786J(BuyPackageBaseActivity.this.getApplicationContext())) {
                C1442a.m8290i("BuyPackageBaseActivity", "startQuerySubOrderStatus network is not ok.");
                BuyPackageBaseActivity.this.m22786N3(4004);
                BuyPackageBaseActivity.this.m22751C4("failed_by_sub_order_query_no_net");
                return;
            }
            BuyPackageBaseActivity buyPackageBaseActivity = BuyPackageBaseActivity.this;
            if (buyPackageBaseActivity.f16520M == null) {
                buyPackageBaseActivity.mo19460T3();
                C1442a.m8289e("BuyPackageBaseActivity", "startQuerySubOrderStatus select is null");
            } else {
                C9158a c9158aM57503F = C9158a.m57503F();
                BuyPackageBaseActivity buyPackageBaseActivity2 = BuyPackageBaseActivity.this;
                c9158aM57503F.m57534c0(buyPackageBaseActivity2.f16524O, buyPackageBaseActivity2.f21448i, buyPackageBaseActivity2.f16520M.getId(), BuyPackageBaseActivity.this);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$f */
    public class DialogInterfaceOnClickListenerC3576f implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3576f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            BuyPackageBaseActivity.this.m22865q4();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$g */
    public class C3577g implements InterfaceC8938f {

        /* renamed from: a */
        public final /* synthetic */ int f16585a;

        public C3577g(int i10) {
            this.f16585a = i10;
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            int i10 = this.f16585a;
            if (i10 == 7034) {
                if (exc instanceof IapApiException) {
                    Status status = ((IapApiException) exc).getStatus();
                    linkedHashMapM79497A.put("iap_exception_code", String.valueOf(status.getStatusCode()));
                    if (status.getStatusCode() == 60050) {
                        C1442a.m8289e("BuyPackageBaseActivity", "confirmSupportNewIap fail. order hwid not login.");
                        BuyPackageBaseActivity.this.m22786N3(4002);
                    } else if (status.getStatusCode() == 60054) {
                        C1442a.m8289e("BuyPackageBaseActivity", "confirmSupportNewIap fail. order account area not support iap 4.0");
                        BuyPackageBaseActivity buyPackageBaseActivity = BuyPackageBaseActivity.this;
                        buyPackageBaseActivity.m22894y2(buyPackageBaseActivity.m22882v2());
                    } else {
                        C1442a.m8289e("BuyPackageBaseActivity", "confirmSupportNewIap fail. status.getStatusCode() = " + status.getStatusCode());
                        BuyPackageBaseActivity buyPackageBaseActivity2 = BuyPackageBaseActivity.this;
                        buyPackageBaseActivity2.m22894y2(buyPackageBaseActivity2.m22882v2());
                    }
                } else {
                    C1442a.m8289e("BuyPackageBaseActivity", "test fail other err.");
                    BuyPackageBaseActivity buyPackageBaseActivity3 = BuyPackageBaseActivity.this;
                    buyPackageBaseActivity3.m22894y2(buyPackageBaseActivity3.m22882v2());
                }
            } else if (i10 == 7036) {
                BuyPackageBaseActivity.this.m22889w5();
            }
            linkedHashMapM79497A.put("iap_result_code", String.valueOf(this.f16585a));
            BuyPackageBaseActivity.this.m28593u1(linkedHashMapM79497A);
            BuyPackageBaseActivity buyPackageBaseActivity4 = BuyPackageBaseActivity.this;
            buyPackageBaseActivity4.m22851n2(linkedHashMapM79497A, buyPackageBaseActivity4.f16520M);
            BuyPackageBaseActivity.this.m28575A1("UNIFORM_CLOUDPAY_IAP_CONFIRM_ERROR", linkedHashMapM79497A);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$h */
    public class C3578h implements InterfaceC8939g<IsEnvReadyResult> {

        /* renamed from: a */
        public final /* synthetic */ SignPurchaseResp f16587a;

        public C3578h(SignPurchaseResp signPurchaseResp) {
            this.f16587a = signPurchaseResp;
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(IsEnvReadyResult isEnvReadyResult) throws JSONException {
            C1442a.m8290i("BuyPackageBaseActivity", "confirmSupportNewIap success. carrierId = " + isEnvReadyResult.getCarrierId());
            BuyPackageBaseActivity.this.m22893x5(this.f16587a);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$i */
    public class C3579i implements InterfaceC8938f {
        public C3579i() {
        }

        @Override // p208cq.InterfaceC8938f
        public void onFailure(Exception exc) {
            if (!(exc instanceof IapApiException)) {
                C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap fail.");
                BuyPackageBaseActivity.this.m22786N3(4002);
                return;
            }
            C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap IapApiException errCode = " + ((IapApiException) exc).getStatusCode());
            BuyPackageBaseActivity.this.m22786N3(4002);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$j */
    public class C3580j implements InterfaceC8939g<PurchaseIntentResult> {

        /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$j$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BuyPackageBaseActivity.this.mo22867r2();
            }
        }

        public C3580j() {
        }

        @Override // p208cq.InterfaceC8939g
        /* renamed from: a */
        public void onSuccess(PurchaseIntentResult purchaseIntentResult) {
            HandlerC3583m handlerC3583m;
            Status status = purchaseIntentResult.getStatus();
            if (!status.hasResolution()) {
                C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap onSuccess , but fail.");
                BuyPackageBaseActivity.this.m22786N3(4002);
                return;
            }
            try {
                C1442a.m8290i("BuyPackageBaseActivity", "startPullNewIap success, start pull pay.");
                status.startResolutionForResult(BuyPackageBaseActivity.this, RequestManager.NOTIFY_CONNECT_SUSPENDED);
                BuyPackageBaseActivity.this.m22892x4();
                C1008c.m6035v().m6064b();
                BuyPackageBaseActivity buyPackageBaseActivity = BuyPackageBaseActivity.this;
                if (!buyPackageBaseActivity.f16557e1 || (handlerC3583m = buyPackageBaseActivity.f16524O) == null) {
                    return;
                }
                handlerC3583m.postDelayed(new a(), 1000L);
            } catch (IntentSender.SendIntentException e10) {
                C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap onSuccess , but exception : " + e10.getMessage());
                BuyPackageBaseActivity.this.m22786N3(4002);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$k */
    public class RunnableC3581k implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ InAppPurchaseData f16592a;

        /* renamed from: b */
        public final /* synthetic */ boolean f16593b;

        public RunnableC3581k(InAppPurchaseData inAppPurchaseData, boolean z10) {
            this.f16592a = inAppPurchaseData;
            this.f16593b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C11296s.m67786J(BuyPackageBaseActivity.this.getApplicationContext())) {
                C1442a.m8289e("BuyPackageBaseActivity", "getNotifyForIAP4 network not ok.");
                BuyPackageBaseActivity.this.m22786N3(4004);
                BuyPackageBaseActivity.this.m22751C4("failed_by_get_notify_no_net");
                BuyPackageBaseActivity buyPackageBaseActivity = BuyPackageBaseActivity.this;
                if (buyPackageBaseActivity.f16521M0) {
                    buyPackageBaseActivity.m22753D2();
                    return;
                }
                return;
            }
            if (this.f16592a == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "getNotifyForIAP4 inAppPurchaseData is null.");
                BuyPackageBaseActivity.this.m22786N3(4002);
                BuyPackageBaseActivity buyPackageBaseActivity2 = BuyPackageBaseActivity.this;
                if (buyPackageBaseActivity2.f16521M0) {
                    buyPackageBaseActivity2.m22753D2();
                    return;
                }
                return;
            }
            BuyPackageBaseActivity buyPackageBaseActivity3 = BuyPackageBaseActivity.this;
            if (buyPackageBaseActivity3.f16509G0 == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "getNotifyForIAP4 mPaylod is null.");
                BuyPackageBaseActivity.this.m22786N3(4002);
                BuyPackageBaseActivity buyPackageBaseActivity4 = BuyPackageBaseActivity.this;
                if (buyPackageBaseActivity4.f16521M0) {
                    buyPackageBaseActivity4.m22753D2();
                    return;
                }
                return;
            }
            CloudSpace cloudSpace = buyPackageBaseActivity3.f16520M;
            if (cloudSpace == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "getNotifyForIAP4 select is null.");
                BuyPackageBaseActivity.this.m22786N3(4002);
                BuyPackageBaseActivity buyPackageBaseActivity5 = BuyPackageBaseActivity.this;
                if (buyPackageBaseActivity5.f16521M0) {
                    buyPackageBaseActivity5.m22753D2();
                    return;
                }
                return;
            }
            buyPackageBaseActivity3.f16536U.setId(cloudSpace.getId());
            BuyPackageBaseActivity buyPackageBaseActivity6 = BuyPackageBaseActivity.this;
            buyPackageBaseActivity6.f16536U.setPreorderId(buyPackageBaseActivity6.f16509G0.getPreorderId());
            BuyPackageBaseActivity.this.f16536U.setOrderId(this.f16592a.getPayOrderId());
            BuyPackageBaseActivity.this.f16536U.setRequestId(this.f16592a.getOrderId());
            BuyPackageBaseActivity.this.f16536U.setProductId(this.f16592a.getProductId());
            BuyPackageBaseActivity.this.f16536U.setSubscriptionId(this.f16592a.getSubscriptionId());
            BuyPackageBaseActivity.this.f16536U.setPurchaseToken(this.f16592a.getPurchaseToken());
            C9158a c9158aM57503F = C9158a.m57503F();
            BuyPackageBaseActivity buyPackageBaseActivity7 = BuyPackageBaseActivity.this;
            c9158aM57503F.m57510H(buyPackageBaseActivity7.f16524O, buyPackageBaseActivity7.f16536U, buyPackageBaseActivity7.f21448i, this.f16593b);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$l */
    public class C3582l implements ResultCallback<PayResult> {

        /* renamed from: a */
        public int f16595a;

        /* renamed from: b */
        public Activity f16596b;

        public C3582l(int i10, Activity activity) {
            this.f16595a = i10;
            this.f16596b = activity;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(PayResult payResult) {
            Status status = payResult.getStatus();
            C11060c c11060c = BuyPackageBaseActivity.this.f21448i;
            if (c11060c != null) {
                c11060c.m66665u("114_" + status.getStatusCode());
                BuyPackageBaseActivity.this.f21448i.m66635A(status.getStatusMessage());
            }
            if (status.getStatusCode() != 0) {
                C1442a.m8290i("BuyPackageBaseActivity", "hms pay error. code = " + status.getStatusCode() + " msg = " + status.getStatusMessage());
                BuyPackageBaseActivity.this.m22786N3(4002);
                return;
            }
            try {
                status.startResolutionForResult(this.f16596b, this.f16595a);
            } catch (IntentSender.SendIntentException e10) {
                C1442a.m8289e("BuyPackageBaseActivity", "hms pay error." + e10.getMessage());
                BuyPackageBaseActivity.this.m22786N3(4002);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.BuyPackageBaseActivity$m */
    public class HandlerC3583m extends Handler {

        /* renamed from: a */
        public WeakReference<Activity> f16598a;

        public HandlerC3583m(Activity activity) {
            this.f16598a = new WeakReference<>(activity);
        }

        /* renamed from: a */
        public final boolean m22906a(Activity activity) {
            return activity == null || activity.isFinishing();
        }

        /* renamed from: b */
        public final void m22907b(Message message) {
            int i10 = message.what;
            if (i10 == 2023) {
                BuyPackageBaseActivity.this.m22765G2(message.obj);
                return;
            }
            if (i10 == 2101) {
                C1442a.m8290i("BuyPackageBaseActivity", "getUserPackagesFail code = " + message.arg1);
                BuyPackageBaseActivity.this.m22896y4(1, "pay_result_get_userpackage_fail_" + message.arg1);
                BuyPackageBaseActivity.this.mo19477k5();
                return;
            }
            if (i10 == 2123) {
                BuyPackageBaseActivity.this.m22896y4(1, "pay_result_get_card_support_fail_" + message.arg1);
                BuyPackageBaseActivity.this.m22765G2(null);
                return;
            }
            if (i10 == 2026) {
                BuyPackageBaseActivity.this.m22770I2(message.obj);
                return;
            }
            if (i10 == 2027) {
                BuyPackageBaseActivity.this.mo22871s3(message.obj);
                return;
            }
            if (i10 == 2126) {
                BuyPackageBaseActivity.this.m22768H2(message.arg1);
                return;
            }
            if (i10 == 2127) {
                BuyPackageBaseActivity.this.mo22868r3(message.arg1);
                return;
            }
            if (i10 == 6009) {
                BuyPackageBaseActivity.this.m22815Z2(message.obj);
                return;
            }
            if (i10 != 6010) {
                m22908c(message);
                return;
            }
            C1442a.m8290i("BuyPackageBaseActivity", "getPackagesByPackages Fail code = " + message.arg1);
            BuyPackageBaseActivity.this.m22751C4("pay_result_get_packages_by_space_rule_fail_" + message.arg1);
            BuyPackageBaseActivity.this.mo19466Y2();
        }

        /* renamed from: c */
        public final void m22908c(Message message) {
            int i10 = message.what;
            if (i10 == 108) {
                BuyPackageBaseActivity.this.mo22789P2(message.obj);
            }
            if (i10 == 2102) {
                BuyPackageBaseActivity.this.m22799T2(message.arg1);
                return;
            }
            if (i10 == 7011) {
                BuyPackageBaseActivity.this.mo22807W2(message.obj);
                return;
            }
            if (i10 == 7012) {
                BuyPackageBaseActivity.this.mo22847l4(message.getData());
                return;
            }
            if (i10 == 7040) {
                BuyPackageBaseActivity.this.m22783M3(message.obj);
                return;
            }
            if (i10 == 7041) {
                BuyPackageBaseActivity.this.m22751C4("failed_by_get_notify_or_estimate_" + message.what);
                BuyPackageBaseActivity.this.mo22788O2(message.arg1);
                return;
            }
            switch (i10) {
                case 6015:
                    C1442a.m8290i("BuyPackageBaseActivity", "quit success");
                    BuyPackageBaseActivity.this.m22841j3((RetResult) message.obj);
                    break;
                case 6016:
                    BuyPackageBaseActivity.this.m22838i3();
                    break;
                case 6017:
                    C1442a.m8290i("BuyPackageBaseActivity", "getFamilyShareInfo success");
                    BuyPackageBaseActivity buyPackageBaseActivity = BuyPackageBaseActivity.this;
                    buyPackageBaseActivity.f16550b0 = (FamilyShareInfoResult) message.obj;
                    buyPackageBaseActivity.mo19479s5();
                    break;
                case 6018:
                    C1442a.m8289e("BuyPackageBaseActivity", "getFamilyShareInfo code = " + message.arg1);
                    BuyPackageBaseActivity.this.mo19477k5();
                    break;
                default:
                    m22909d(message);
                    break;
            }
        }

        /* renamed from: d */
        public final void m22909d(Message message) {
            int i10 = message.what;
            if (i10 == 7001) {
                BuyPackageBaseActivity.this.mo22835g4(message);
            }
            if (i10 == 7002) {
                BuyPackageBaseActivity.this.mo22832f4(message);
                return;
            }
            if (i10 == 9007) {
                BuyPackageBaseActivity.this.mo22774J3();
                return;
            }
            switch (i10) {
                case 7027:
                    BuyPackageBaseActivity.this.mo22887w3(message.obj);
                    break;
                case 7028:
                    BuyPackageBaseActivity.this.mo22883v3();
                    break;
                case 7029:
                    BuyPackageBaseActivity.this.mo19452O3(message);
                    break;
                default:
                    m22910e(message);
                    break;
            }
        }

        /* renamed from: e */
        public final void m22910e(Message message) {
            int i10 = message.what;
            if (i10 == 2001) {
                BuyPackageBaseActivity.this.mo19473f3(message.obj);
            }
            if (i10 == 2101) {
                BuyPackageBaseActivity.this.m22830e3(message.arg1);
                return;
            }
            switch (i10) {
                case 6019:
                    BuyPackageBaseActivity.this.mo19456R2(message.obj);
                    break;
                case 6020:
                    BuyPackageBaseActivity.this.mo19455Q2(message.arg1);
                    break;
                case 6021:
                    BuyPackageBaseActivity.this.m22801U2(message.obj);
                    break;
                case 6022:
                    C1442a.m8290i("BuyPackageBaseActivity", "getGradeRightDetail Fail code = " + message.arg1);
                    BuyPackageBaseActivity.this.mo19477k5();
                    break;
                case 6023:
                    BuyPackageBaseActivity.this.mo22856o3(message.obj);
                    break;
                case 6024:
                    BuyPackageBaseActivity.this.mo22852n3(message);
                    break;
                default:
                    m22912g(message);
                    break;
            }
        }

        /* renamed from: f */
        public final void m22911f(Message message) {
            int i10 = message.what;
            if (i10 == 2006) {
                BuyPackageBaseActivity.this.mo22846l3(message.obj);
            }
            if (i10 == 2015) {
                BuyPackageBaseActivity.this.m22822b3(message.obj);
                return;
            }
            if (i10 == 2115) {
                BuyPackageBaseActivity.this.m22818a3(message.arg1);
                return;
            }
            if (i10 == 2130) {
                BuyPackageBaseActivity.this.m22782M2(message);
                return;
            }
            switch (i10) {
                case 2104:
                    BuyPackageBaseActivity.this.m22751C4("failed_by_get_notify_or_estimate_" + message.what);
                    BuyPackageBaseActivity.this.mo22788O2(message.arg1);
                    break;
                case 2105:
                    BuyPackageBaseActivity.this.mo22779L2(message.arg1);
                    break;
                case 2106:
                    BuyPackageBaseActivity.this.mo22844k3(message.arg1);
                    break;
                default:
                    switch (i10) {
                        case 6028:
                            BuyPackageBaseActivity.this.mo22891x3(message.obj);
                            break;
                        case 6029:
                            BuyPackageBaseActivity.this.m22757E2(message.obj);
                            break;
                        case 6030:
                            BuyPackageBaseActivity.this.m22761F2();
                            break;
                        default:
                            m22913h(message);
                            break;
                    }
            }
        }

        /* renamed from: g */
        public final void m22912g(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                BuyPackageBaseActivity.this.m22854n5(message);
                return;
            }
            if (i10 == 1) {
                C1442a.m8290i("BuyPackageBaseActivity", "policy show fail");
                BuyPackageBaseActivity.this.mo22837h4();
                return;
            }
            if (i10 == 3) {
                C1442a.m8290i("BuyPackageBaseActivity", "hms policy update");
                return;
            }
            if (i10 == 5) {
                C1442a.m8290i("BuyPackageBaseActivity", "policy has agree");
                BuyPackageBaseActivity.this.mo22837h4();
                return;
            }
            if (i10 == 7018) {
                BuyPackageBaseActivity.this.mo22858o5(message.obj);
                return;
            }
            if (i10 == 31003) {
                BuyPackageBaseActivity.this.f16579z0 = true;
                C11839m.m70688i("BuyPackageBaseActivity", "query push guide success");
                BuyPackageBaseActivity.this.m22855o2(message.obj);
                return;
            }
            if (i10 == 31004) {
                C11839m.m70688i("BuyPackageBaseActivity", "query push guide failed");
                return;
            }
            C1442a.m8290i("BuyPackageBaseActivity", "default show no data. msg.what = " + message.what + " msg.arg1 = " + message.arg1);
            BuyPackageBaseActivity.this.mo19477k5();
        }

        /* renamed from: h */
        public final void m22913h(Message message) {
            int i10 = message.what;
            if (i10 == 2016) {
                BuyPackageBaseActivity.this.m22776K2(message.obj);
            }
            if (i10 == 2116) {
                BuyPackageBaseActivity.this.m22773J2(message.arg1);
                return;
            }
            if (i10 == 2128) {
                BuyPackageBaseActivity.this.mo22792Q3(message.obj.toString());
                return;
            }
            if (i10 == 6027) {
                BuyPackageBaseActivity.this.mo22804V2(message.obj);
                return;
            }
            if (i10 == 6007) {
                BuyPackageBaseActivity.this.m22828d3((GetUserRegisterResp) message.obj);
                return;
            }
            if (i10 == 6008) {
                BuyPackageBaseActivity.this.m22896y4(1, "pay_result_get_user_register_fail_" + message.arg1);
                BuyPackageBaseActivity.this.m22825c3();
                return;
            }
            if (i10 == 7044) {
                BuyPackageBaseActivity.this.m22745B2(message.obj);
                return;
            }
            if (i10 == 7045) {
                BuyPackageBaseActivity.this.m22741A2(message.arg1);
                return;
            }
            if (i10 == 20000) {
                BuyPackageBaseActivity.this.m22751C4("pay_result_get_service_country_fail");
                if (TextUtils.isEmpty(C13452e.m80781L().m80921h0())) {
                    C1442a.m8289e("BuyPackageBaseActivity", "get account user info fail , want to use cache , but cache serviceCode is empty.");
                    BuyPackageBaseActivity.this.mo19477k5();
                    return;
                }
                C1442a.m8290i("BuyPackageBaseActivity", "get account user info fail , use cache success.");
                Bundle bundle = new Bundle();
                bundle.putString("account_head_pic_url", C13452e.m80781L().m80806G());
                bundle.putString("account_nick_name", C13452e.m80781L().m80841P());
                BuyPackageBaseActivity.this.mo19451H3(bundle);
                return;
            }
            if (i10 == 20001) {
                BuyPackageBaseActivity.this.mo19451H3(message.getData());
                return;
            }
            switch (i10) {
                case 6035:
                    BuyPackageBaseActivity.this.mo22836h3(message.obj);
                    break;
                case 6036:
                    BuyPackageBaseActivity.this.mo22895y3(message.obj);
                    break;
                case 6037:
                    BuyPackageBaseActivity.this.mo22834g3(message.arg1);
                    break;
                default:
                    m22907b(message);
                    break;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            if (m22906a(this.f16598a.get())) {
            }
            int i10 = message.what;
            if (i10 == 2025) {
                BuyPackageBaseActivity.this.m22864q3(message.obj);
                return;
            }
            if (i10 == 2125) {
                BuyPackageBaseActivity.this.m22751C4("pay_result_query_sign_status_fail_" + message.arg1);
                BuyPackageBaseActivity.this.mo22860p3(message.arg1);
                return;
            }
            if (i10 == 2134) {
                BuyPackageBaseActivity.this.m22777K3(message.obj);
                return;
            }
            if (i10 == 2135) {
                BuyPackageBaseActivity.this.m22780L3(message.arg1);
                return;
            }
            switch (i10) {
                case 2002:
                    BuyPackageBaseActivity.this.m22797S2(message.obj);
                    break;
                case 2003:
                    C1442a.m8290i("BuyPackageBaseActivity", "GET_UIPACKAGE_SUCCESS");
                    break;
                case 2004:
                    BuyPackageBaseActivity.this.mo22795R3(message.obj);
                    break;
                case 2005:
                    BuyPackageBaseActivity.this.m22785N2((CreateOrder) message.obj);
                    break;
                default:
                    switch (i10) {
                        case 7034:
                            BuyPackageBaseActivity.this.m22878u3(message.obj, 7034);
                            break;
                        case 7035:
                            BuyPackageBaseActivity.this.m22874t3(message.arg1, 7035);
                            break;
                        case 7036:
                            BuyPackageBaseActivity.this.m22878u3(message.obj, 7036);
                            break;
                        case 7037:
                            BuyPackageBaseActivity.this.m22874t3(message.arg1, 7037);
                            break;
                        default:
                            m22911f(message);
                            break;
                    }
            }
        }
    }

    /* renamed from: c5 */
    private void m22731c5(int i10) {
        if (isFinishing()) {
            C1442a.m8291w("BuyPackageBaseActivity", "showErrDialog , Activity is Finishing.");
            return;
        }
        PayResultErrorDialog payResultErrorDialog = this.f16528Q;
        if (payResultErrorDialog != null && payResultErrorDialog.isShowing()) {
            this.f16528Q.dismiss();
        }
        this.f16528Q = null;
        PayResultErrorDialog payResultErrorDialog2 = new PayResultErrorDialog(this, this.f16521M0);
        this.f16528Q = payResultErrorDialog2;
        payResultErrorDialog2.show(i10);
    }

    /* renamed from: k2 */
    private void m22738k2() {
        try {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "backMainActivity err : " + e10.getMessage());
            finish();
        }
    }

    /* renamed from: l2 */
    private void m22739l2() {
        String strM82922f = C13823d.m82904y().m82922f(this);
        Intent intent = new Intent(this, (Class<?>) CampaignActivity.class);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra("channels", 9);
        intent.putExtra("taskActivityId", strM82922f);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("is_activity_need_back_to_main", true);
        intent.putExtra("entrance_from", 9);
        AdParametersExt adParametersExtM63035a = C10121i.m63035a();
        if (adParametersExtM63035a != null) {
            intent.putExtra("agd_resource_enable", adParametersExtM63035a.getEnabled());
            intent.putExtra("agd_resource_slot_id", adParametersExtM63035a.getAgdAdid());
            intent.putExtra("pps_threshold", adParametersExtM63035a.getThreshold());
        }
        startActivity(intent);
    }

    /* renamed from: r5 */
    private void m22740r5(ConfirmBuyPackageDialog confirmBuyPackageDialog, EstimateResp estimateResp, GetClientUIConfigResp getClientUIConfigResp) {
        if (estimateResp == null || confirmBuyPackageDialog == null || confirmBuyPackageDialog.isShowing()) {
            C1442a.m8291w("BuyPackageBaseActivity", "cloudSpace or dialog is null");
        } else {
            confirmBuyPackageDialog.showConvertDialog(estimateResp, getClientUIConfigResp, m22882v2());
        }
    }

    /* renamed from: A2 */
    public final void m22741A2(int i10) {
        C1442a.m8289e("BuyPackageBaseActivity", "acceptSignGift fail, errCode = " + i10);
        m22751C4("pay_result_accept_sign_gift_fail_" + i10);
        m22786N3(i10);
    }

    /* renamed from: A3 */
    public void mo22742A3(GetAvailableGradePackagesResp getAvailableGradePackagesResp) {
        String[] strArr = this.f21457r;
        if (strArr == null || strArr.length == 0) {
            C11839m.m70689w("BuyPackageBaseActivity", "there are no specifiedPackageIds");
            return;
        }
        C11839m.m70688i("BuyPackageBaseActivity", "filterSpecifiedPkg,specifiedPackageIds:" + Arrays.toString(this.f21457r));
        List listM1579c = C0225l.m1579c(getAvailableGradePackagesResp.getSpacePackages(), new Function() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17533a.m22808W3((CloudPackage) obj);
            }
        });
        if (listM1579c.size() == this.f21457r.length) {
            this.f16542X = C11296s.m67831o(getAvailableGradePackagesResp.getPackageGrades(), listM1579c, getAvailableGradePackagesResp.getServerTime());
        } else {
            C0226l0.m1585e(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.b
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, IllegalArgumentException {
                    this.f17534a.m22850m5();
                }
            }, 1500L);
        }
        this.f16544Y = !C0209d.m1205R0(this.f16542X);
        C11839m.m70688i("BuyPackageBaseActivity", "isExistSpecifiedPkgPush:" + this.f16544Y);
    }

    /* renamed from: A4 */
    public void m22743A4(int i10, String str) {
        m22747B4(i10, str, null);
    }

    /* renamed from: A5 */
    public void m22744A5() {
        m22748B5(false);
    }

    /* renamed from: B2 */
    public final void m22745B2(Object obj) {
        if (!(obj instanceof AcceptSignGiftResp)) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealAcceptSignGiftSuccess obj is not AcceptSignGiftResp.");
            mo19477k5();
        } else {
            C1442a.m8290i("BuyPackageBaseActivity", "dealAcceptSignGiftSuccess");
            this.f16547Z0 = (AcceptSignGiftResp) obj;
            mo19479s5();
        }
    }

    /* renamed from: B3 */
    public <T> T m22746B3(String str, Class<T> cls) {
        try {
            return (T) this.f16561h0.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            C1442a.m8290i("BuyPackageBaseActivity", "json error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: B4 */
    public void m22747B4(int i10, String str, PaySuccessShowNeedData paySuccessShowNeedData) {
        CloudSpace cloudSpaceM67757a;
        MemGradeRights gradeRights;
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            m22851n2(linkedHashMapM79497A, this.f16520M);
            String stringExtra = new SafeIntent(getIntent()).getStringExtra("forOtherPage");
            if (!TextUtils.isEmpty(stringExtra)) {
                linkedHashMapM79497A.put("forOtherPage", stringExtra);
            }
            linkedHashMapM79497A.put("pay_result", String.valueOf(i10));
            linkedHashMapM79497A.put("pay_result_description", str);
            if (i10 == 0) {
                if (paySuccessShowNeedData != null) {
                    if (paySuccessShowNeedData.getSubType() == 0) {
                        UserPackage userPackage = this.f21452m;
                        if (userPackage != null && (gradeRights = userPackage.getGradeRights()) != null) {
                            linkedHashMapM79497A.put("pay_success_before_grade", gradeRights.getGradeCode());
                        }
                        MemGradeRights gradeRights2 = paySuccessShowNeedData.getGradeRights();
                        if (gradeRights2 != null) {
                            linkedHashMapM79497A.put("pay_success_after_grade", gradeRights2.getGradeCode());
                        }
                    }
                    if (paySuccessShowNeedData.getScheme() == 2) {
                        linkedHashMapM79497A.put("pay_success_worry_free_scheme", String.valueOf(2));
                    }
                }
                if (TextUtils.isEmpty(this.f16507F0)) {
                    UserPackage userPackage2 = this.f21452m;
                    if (userPackage2 != null && (cloudSpaceM67757a = C11293p.m67757a(userPackage2)) != null) {
                        linkedHashMapM79497A.put("old_package_id", cloudSpaceM67757a.getId());
                        C1442a.m8288d("BuyPackageBaseActivity", "reportPayResult user effective package id is " + cloudSpaceM67757a.getId());
                    }
                } else {
                    linkedHashMapM79497A.put("old_package_id", this.f16507F0);
                    C1442a.m8288d("BuyPackageBaseActivity", "reportPayResult old package id is " + this.f16507F0);
                }
                linkedHashMapM79497A.put("pay_success_way_of_purchase", this.f16576w0);
                linkedHashMapM79497A.put("is_system_retread", String.valueOf(C10028c.m62182c0().m62325f1()));
            }
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_PAY_RESULT", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_CLICK_PAY_RESULT", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_PAY_RESULT", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportPayResult " + i10 + ", error occur:" + e10.getMessage());
        }
    }

    /* renamed from: B5 */
    public void m22748B5(boolean z10) {
        if (this.f21452m == null) {
            C1442a.m8291w("BuyPackageBaseActivity", "startSignPurchaseTask user is null");
            return;
        }
        this.f16532S = true;
        this.f16541W0 = null;
        mo19478l5();
        if (this.f16520M == null || this.f21452m == null) {
            C11839m.m70687e("BuyPackageBaseActivity", "select or user is null");
        } else {
            C9158a.m57503F().m57542g0(this.f16524O, this.f21448i, this.f16520M.getId(), m22886w2(z10), mo22754D3(), C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), null, 1, this.f16539V0);
        }
    }

    /* renamed from: C2 */
    public void m22749C2() {
        if (this.f16521M0) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealAopPayErr");
            m22753D2();
        }
    }

    /* renamed from: C3 */
    public void m22750C3(int i10) {
        C9158a.m57503F().m57552q(this.f16524O, null, i10);
    }

    /* renamed from: C4 */
    public void m22751C4(String str) {
        m22743A4(1, str);
    }

    /* renamed from: C5 */
    public void m22752C5() {
        C1442a.m8290i("BuyPackageBaseActivity", "startSignPurchaseTaskForAop");
        HashMap map = new HashMap();
        map.put("aopInfo", this.f16523N0);
        C9158a.m57503F().m57542g0(this.f16524O, this.f21448i, "", m22886w2(false), map, new ArrayList(), null, 0, this.f16539V0);
    }

    /* renamed from: D2 */
    public void m22753D2() {
        this.f16521M0 = false;
        Intent intent = new Intent();
        intent.putExtra("renew_call_back_scene", "pay_result");
        setResult(0, intent);
        finish();
    }

    /* renamed from: D3 */
    public Map<String, String> mo22754D3() {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(this.f16506F)) {
            return null;
        }
        map.put(Inviter.INVITE_CODE, this.f16506F);
        return map;
    }

    /* renamed from: D4 */
    public void m22755D4(String str, PaySuccessShowNeedData paySuccessShowNeedData) {
        m22747B4(0, str, paySuccessShowNeedData);
    }

    /* renamed from: D5 */
    public void m22756D5(String str) {
        if (this.f21452m == null || this.f16520M == null) {
            C11839m.m70687e("BuyPackageBaseActivity", "startSignPurchaseTaskForPresent user is null");
            mo19476h5();
        } else {
            this.f16541W0 = null;
            this.f16532S = true;
            mo19478l5();
            C9158a.m57503F().m57542g0(this.f16524O, this.f21448i, this.f16520M.getId(), m22882v2(), mo22754D3(), C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), str, 1, this.f16539V0);
        }
    }

    /* renamed from: E2 */
    public void m22757E2(Object obj) {
        C1442a.m8290i("BuyPackageBaseActivity", "dealAvaVochers()");
        if (obj instanceof GetAvaVouchersResp) {
            this.f16535T0 = ((GetAvaVouchersResp) obj).getVouchers();
            mo19479s5();
            if (m22813Y3()) {
                this.f16569p0 = 0;
            }
        }
    }

    /* renamed from: E3 */
    public void m22758E3() {
        this.f16524O.postDelayed(new RunnableC3574d(), 3000L);
    }

    /* renamed from: E4 */
    public void m22759E4() throws JSONException {
        CloudSpace cloudSpaceM67757a;
        JSONObject jSONObjectM79464f = C13222a.m79464f(getApplicationContext(), "CLOUDPAY_PAY_SUCCESS", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        try {
            CloudSpace cloudSpace = this.f16520M;
            if (cloudSpace != null) {
                String id2 = cloudSpace.getId();
                jSONObjectM79464f.put("new_package_id", id2);
                C1442a.m8288d("BuyPackageBaseActivity", "new package id is " + id2);
                int scheme = this.f16520M.getScheme();
                jSONObjectM79464f.put("new_package_scheme", scheme);
                C1442a.m8288d("BuyPackageBaseActivity", "new package scheme is " + scheme);
            }
            if (TextUtils.isEmpty(this.f16507F0)) {
                UserPackage userPackage = this.f21452m;
                if (userPackage != null && (cloudSpaceM67757a = C11293p.m67757a(userPackage)) != null) {
                    jSONObjectM79464f.put("old_package_id", cloudSpaceM67757a.getId());
                    C1442a.m8288d("BuyPackageBaseActivity", "user effective package id is " + cloudSpaceM67757a.getId());
                }
            } else {
                jSONObjectM79464f.put("old_package_id", this.f16507F0);
                C1442a.m8288d("BuyPackageBaseActivity", "old package id is " + this.f16507F0);
            }
            String str = this.f16576w0;
            if (str != null) {
                String str2 = f16497g1.get(str);
                jSONObjectM79464f.put("way_of_purchase_success", str2);
                C1442a.m8288d("BuyPackageBaseActivity", "wayOfPurchaseSuccess is " + str2);
            }
            jSONObjectM79464f.put("is_system_retread", String.valueOf(C10028c.m62182c0().m62325f1()));
        } catch (JSONException e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79464f);
        UBAAnalyze.m29952M("CKC", "CLOUDPAY_PAY_SUCCESS", jSONObjectM79464f);
    }

    /* renamed from: E5 */
    public void mo22760E5(QueryPushGuideRsp queryPushGuideRsp) {
    }

    /* renamed from: F2 */
    public void m22761F2() {
        boolean zM22813Y3 = m22813Y3();
        if (this.f16535T0 == null || zM22813Y3) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealAvaVochersFail()");
            this.f16535T0 = new ArrayList();
            mo19479s5();
            if (zM22813Y3) {
                this.f16569p0 = 0;
            }
        }
    }

    /* renamed from: F3 */
    public void m22762F3(InAppPurchaseData inAppPurchaseData) {
        m22766G3(inAppPurchaseData, true);
    }

    /* renamed from: F4 */
    public void m22763F4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
            linkedHashMapM79497A.put("capacity", String.valueOf(this.f16520M.getCapacity()));
        }
        m22842j4("UNIFORM_CLOUDPAY_PRESENT_DELAY_SHOW", linkedHashMapM79497A);
    }

    /* renamed from: F5 */
    public void m22764F5(int i10, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) GuideWebViewActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("isEnableJs", true);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_TYPE, str3);
            intent.putExtra(NotifyConstants.Keys.NOTIFY_URI, str4);
            intent.putExtra("activeUri", str5);
            intent.putExtra("packageId", str2);
            intent.putExtra("notifyAction", i10);
            intent.putExtra("gradeCode", str6);
            intent.putExtra("expireTime", str7);
            startActivity(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C0212e0.m1370t(this, FrequencyManager.CHECK_GUID_H5_DIALOG_SP, FrequencyManager.CHECK_GUID_H5_DIALOG_TIME, jCurrentTimeMillis);
            C11839m.m70688i("BuyPackageBaseActivity", " QueryGuideH5Task  showGuidH5 System.currentTimeMillis(): " + jCurrentTimeMillis);
        } catch (Exception e10) {
            C11839m.m70687e("BuyPackageBaseActivity", "viewWeb Exception: " + e10.toString());
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_EXCEPTION, "viewWeb Exception: " + e10.getMessage());
        }
    }

    /* renamed from: G2 */
    public void m22765G2(Object obj) {
        if (obj instanceof Response) {
            this.f16530R = (Response) obj;
        } else {
            Response response = new Response();
            this.f16530R = response;
            response.setResultCode(BasicBaseResp.COUNTRY_OFF_LINE);
            this.f16530R.setResultDesc("get card support error");
        }
        mo22843j5();
        mo19479s5();
    }

    /* renamed from: G3 */
    public final void m22766G3(InAppPurchaseData inAppPurchaseData, boolean z10) {
        this.f16524O.postDelayed(new RunnableC3581k(inAppPurchaseData, z10), 3000L);
    }

    /* renamed from: G4 */
    public void m22767G4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
            linkedHashMapM79497A.put("capacity", String.valueOf(this.f16520M.getCapacity()));
        }
        m22842j4("UNIFORM_CLOUDPAY_PRESENT_FAIL_REFUND_SHOW", linkedHashMapM79497A);
    }

    /* renamed from: H2 */
    public final void m22768H2(int i10) {
        C1442a.m8290i("BuyPackageBaseActivity", "dealCreateFreeOrderFail code = " + i10);
        m22786N3(i10);
        m22751C4("failed_by_create_free_order_exception_" + i10);
    }

    /* renamed from: H3 */
    public abstract void mo19451H3(Bundle bundle);

    /* renamed from: H4 */
    public final void m22769H4() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            m22851n2(linkedHashMapM79497A, this.f16520M);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_PULL_PAY_EVENT", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_PULL_PAY_EVENT", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_PULL_PAY_EVENT", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportPullPayEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: I2 */
    public final void m22770I2(Object obj) {
        mo19474g5();
        if (obj == null) {
            C1442a.m8290i("BuyPackageBaseActivity", "dealCreateFreeOrderSuccess object is null.");
            m22786N3(4002);
            m22751C4("failed_by_create_free_order_obj_null");
            return;
        }
        if (!(obj instanceof CreateFreeOrderResp)) {
            C1442a.m8290i("BuyPackageBaseActivity", "dealCreateFreeOrderSuccess CreateFreeOrderResp instanceof fail.");
            m22786N3(4002);
            m22751C4("failed_by_free_order_obj_instance_exception");
            return;
        }
        CreateFreeOrderResp createFreeOrderResp = (CreateFreeOrderResp) obj;
        this.f21448i.m66668x("1");
        C13622a.m81968n(this, this.f21448i);
        this.f16520M.setEndTime(createFreeOrderResp.getEndTime());
        PaySuccessShowNeedData paySuccessShowNeedData = new PaySuccessShowNeedData();
        paySuccessShowNeedData.setCurrency(createFreeOrderResp.getCurrency());
        paySuccessShowNeedData.setAmount(createFreeOrderResp.getAmount());
        paySuccessShowNeedData.setRenewalTime(createFreeOrderResp.getEndTime());
        paySuccessShowNeedData.setProductType(createFreeOrderResp.getProductType());
        paySuccessShowNeedData.setGradeRights(createFreeOrderResp.getGradeRights());
        paySuccessShowNeedData.setPackageGrade(createFreeOrderResp.getPackageGrade());
        paySuccessShowNeedData.setSubType(0);
        paySuccessShowNeedData.setCapacity(createFreeOrderResp.getCapacity());
        m22755D4("success_by_free_order", paySuccessShowNeedData);
        C1442a.m8288d("BuyPackageBaseActivity", "sendPaySuccessBroadcast, create free order success, backup frequency is " + this.f16562i0);
        C11296s.m67818h0(this, createFreeOrderResp.getGradeRights(), this.f16562i0);
        m22816Z3();
        m22771I3(paySuccessShowNeedData);
    }

    /* renamed from: I3 */
    public final void m22771I3(PaySuccessShowNeedData paySuccessShowNeedData) {
        String stringExtra;
        C1442a.m8290i("BuyPackageBaseActivity", "payResultType:" + this.f16549a1 + ",isH5SpecificPayResult:" + this.f16553c1);
        boolean booleanExtra = false;
        if (StringUtil.equals(this.f16549a1, "2")) {
            Intent intent = new Intent(this, (Class<?>) OperationWebViewActivity.class);
            intent.putExtra("srcChannel", true);
            intent.putExtra("is_activity_need_back_to_main", false);
            intent.putExtra("url", this.f16551b1);
            intent.putExtra("salChannel", true);
            intent.putExtra("isEnableJs", true);
            intent.putExtra("launch_web_type", -1);
            startActivity(intent);
            finish();
            return;
        }
        if (this.f16553c1) {
            C1442a.m8290i("BuyPackageBaseActivity", "goToCloudSpacePayActivity h5 specific pay success.");
            Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
            intent2.putExtra("is_specific_h5_pay_return", true);
            intent2.putExtra("payResultUrl", this.f16551b1);
            intent2.putExtra("srcChannel", this.f16510H);
            intent2.putExtra("salChannel", this.f16512I);
            intent2.putExtra("activityCode", this.f16514J);
            intent2.putExtra("pkg_name", "com.huawei.hidisk");
            startActivity(intent2);
            finish();
            return;
        }
        Intent intent3 = new Intent(this, (Class<?>) CloudSpacePayActivity.class);
        intent3.putExtra("pay_sucess_show_need_data", paySuccessShowNeedData);
        intent3.putExtra("showToast", new SafeIntent(getIntent()).getStringExtra("showToast"));
        SafeIntent safeIntent = new SafeIntent(getIntent());
        int intExtra = safeIntent.getIntExtra("page_type", 0);
        String stringExtra2 = safeIntent.getStringExtra("page_detail");
        intent3.putExtra("page_type", intExtra);
        intent3.putExtra("page_detail", stringExtra2);
        H5WMPayUrlAttr h5WMPayUrlAttr = this.f16518L;
        if (h5WMPayUrlAttr != null && h5WMPayUrlAttr.getTranUrlSuccess() != null) {
            intent3.putExtra("url", h5WMPayUrlAttr.getTranUrlSuccess());
            intent3.putExtra("srcChannel", h5WMPayUrlAttr.getSrcChannel());
            intent3.putExtra("salChannel", h5WMPayUrlAttr.getSalChannel());
            intent3.putExtra("activityCode", h5WMPayUrlAttr.getActivityCode());
            m22859p2();
        }
        if (paySuccessShowNeedData.getProductType() == 12) {
            intent3.putExtra("pay_success_show_worry_free_product_name", this.f16520M.getProductName());
        }
        Intent intent4 = getIntent();
        if (intent4 != null) {
            booleanExtra = intent4.getBooleanExtra("is_finish_for_result", false);
            stringExtra = intent4.getStringExtra("forOtherPage");
        } else {
            stringExtra = "";
        }
        intent3.putExtra("is_finish_for_result", booleanExtra);
        intent3.putExtra("forOtherPage", stringExtra);
        m28580X0(intent3);
        startActivityForResult(intent3, 10002);
        if (!TextUtils.isEmpty(this.f16576w0) && "recommend_purchase".equals(this.f16576w0)) {
            C11296s.m67813f(this);
        }
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
        if (cloudSpaceM67757a != null) {
            this.f16507F0 = cloudSpaceM67757a.getId();
        }
        this.f21452m.setEffectivePackage(this.f16520M);
        if (this.f16520M.getType() == 8 || this.f16520M.getType() == 6) {
            this.f21452m.setIsAutoPay(1);
            C13452e.m80781L().m80816I1(true);
        }
    }

    /* renamed from: I4 */
    public void m22772I4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
            linkedHashMapM79497A.put("capacity", String.valueOf(this.f16520M.getCapacity()));
        }
        m22842j4("UNIFORM_CLOUDPAY_CONTINUE_BUY_SHOW", linkedHashMapM79497A);
    }

    /* renamed from: J2 */
    public final void m22773J2(int i10) {
        if (i10 != 1 && i10 != 4 && i10 != 13) {
            if (i10 != 811) {
                if (i10 != 10) {
                    if (i10 == 11) {
                        Toast.makeText(this, getString(R$string.cloudpay_package_released), 0).show();
                        mo19460T3();
                        return;
                    }
                    if (i10 == 802) {
                        if (!this.f16534T) {
                            m22786N3(4002);
                            return;
                        } else if (!C11296s.m67786J(this) || this.f16520M == null) {
                            m22786N3(4004);
                            return;
                        } else {
                            C9158a.m57503F().m57519Q(this.f16524O, this.f16520M.getId(), this.f21448i);
                            return;
                        }
                    }
                    if (i10 != 803) {
                        switch (i10) {
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                                break;
                            default:
                                m22786N3(4002);
                                break;
                        }
                    }
                }
            }
            m22786N3(4006);
            return;
        }
        m22786N3(i10);
    }

    /* renamed from: J3 */
    public void mo22774J3() {
    }

    /* renamed from: J4 */
    public void m22775J4(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("way_of_purchase", str);
        m22842j4("UNIFORM_CLOUDPAY_SERVICE_DIFF_COUNTRY", linkedHashMapM79497A);
    }

    /* renamed from: K2 */
    public final void m22776K2(Object obj) {
        if (obj == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealCreateMonthOrderSuccess obj is null.");
            m22786N3(4002);
        } else if (obj instanceof MonthOrder) {
            MonthOrder monthOrder = (MonthOrder) obj;
            NotifyReq notifyReq = this.f16536U;
            if (notifyReq != null) {
                notifyReq.setRequestId(monthOrder.getRequestId());
                this.f16536U.setOrderId(monthOrder.getOrderId());
            } else {
                C1442a.m8289e("BuyPackageBaseActivity", "dealCreateMonthOrderSuccess request is null.");
            }
            m22758E3();
        }
    }

    /* renamed from: K3 */
    public void m22777K3(Object obj) {
        C1442a.m8290i("BuyPackageBaseActivity", "handleAopEstimate");
        m28583a1();
        GetClientUIConfigResp getClientUIConfigResp = this.f16538V;
        if (obj instanceof EstimateResp) {
            EstimateResp estimateResp = (EstimateResp) obj;
            ConvertInfo convertInfo = estimateResp.getConvertInfo();
            if (convertInfo == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "convertInfo is null.");
                m22752C5();
            } else if (getClientUIConfigResp == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleAopEstimate params is null.");
                mo19476h5();
            } else {
                this.f16522N = new ConfirmBuyPackageDialog(this, true);
                convertInfo.getConvertPopType();
                m22740r5(this.f16522N, estimateResp, getClientUIConfigResp);
            }
        }
    }

    /* renamed from: K4 */
    public void m22778K4(String str, String str2) throws JSONException {
        JSONObject jSONObjectM79464f = C13222a.m79464f(getApplicationContext(), "CLOUDPAY_CLICK_PAY_BUTTON", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        try {
            jSONObjectM79464f.put("package_id", str);
            jSONObjectM79464f.put("way_of_purchase", str2);
        } catch (JSONException e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79464f);
        UBAAnalyze.m29963X("PVC", "CLOUDPAY_CLICK_PAY_BUTTON", "1", "31", jSONObjectM79464f);
    }

    /* renamed from: L2 */
    public void mo22779L2(int i10) {
        m22751C4("failed_by_create_order_exception_" + i10);
        m22786N3(i10);
    }

    /* renamed from: L3 */
    public void m22780L3(int i10) {
        m22786N3(i10);
    }

    /* renamed from: L4 */
    public void m22781L4(String str, ReportVoucherInfo reportVoucherInfo) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            m22851n2(linkedHashMapM79497A, this.f16520M);
            linkedHashMapM79497A.put("way_of_purchase", str);
            linkedHashMapM79497A.put("last_at_time", String.valueOf(C0214f0.m1382b(C0213f.m1377a(), "account_info", 0).getLong("get_at_time", 0L)));
            if (reportVoucherInfo != null) {
                linkedHashMapM79497A.put("package_voucher_list", reportVoucherInfo.getPackageVoucherList());
                linkedHashMapM79497A.put("select_vouchers", reportVoucherInfo.getSelectVoucherList());
                linkedHashMapM79497A.put("is_recommend_vouchers", String.valueOf(reportVoucherInfo.isRecommendVouchers()));
            }
            Intent intent = getIntent();
            String stringExtra = intent != null ? intent.getStringExtra("forOtherPage") : "";
            if (!TextUtils.isEmpty(stringExtra)) {
                linkedHashMapM79497A.put("forOtherPage", stringExtra);
            }
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_PAY_BUTTON", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_PAY_BUTTON", "1", "31", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_PAY_BUTTON", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: M2 */
    public void m22782M2(Message message) {
        m22751C4("failed_by_create_order_exception_" + message.arg1);
        Bundle data = message.getData();
        m22862p5(data != null ? data.getString("receiver_user_account") : "");
    }

    /* renamed from: M3 */
    public final void m22783M3(Object obj) {
        C1442a.m8290i("BuyPackageBaseActivity", "handleDeductEstimate");
        m28583a1();
        GetClientUIConfigResp getClientUIConfigResp = this.f16538V;
        if (!this.f16525O0) {
            if (this.f16527P0) {
                this.f16527P0 = false;
                mo19479s5();
            } else {
                mo19476h5();
            }
        }
        if (getClientUIConfigResp == null) {
            C1442a.m8290i("BuyPackageBaseActivity", "handleDeductEstimate uiParams is null.");
        } else {
            if (!(obj instanceof EstimateResp)) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleDeductEstimate obj is invalid.");
                return;
            }
            this.f16522N = new ConfirmBuyPackageDialog(this);
            this.f16522N.showDeductConvertDialog(((EstimateResp) obj).getConvertInfo().getTotalConvertDays(), getClientUIConfigResp.getDeductionUpgradeDialogText(), m22882v2());
        }
    }

    /* renamed from: M4 */
    public void m22784M4(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        try {
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("is_support_show_voucher", String.valueOf(C11296s.m67787K() && C11296s.m67789M(this)));
            List<Voucher> list = this.f16535T0;
            if (list == null || list.isEmpty()) {
                linkedHashMapM79497A.put("is_has_show_voucher", String.valueOf(false));
            } else {
                linkedHashMapM79497A.put("is_has_show_voucher", String.valueOf(true));
                linkedHashMapM79497A.put("available_voucher_id_list", C11296s.m67801Y(this.f16535T0));
            }
            linkedHashMapM79497A.put("way_of_purchase", str);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_ENTER_VOUCHER_INFO", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_ENTER_VOUCHER_INFO", "1", "31", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_ENTER_VOUCHER_INFO", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportActivityBaseEvent occur:" + e10.getMessage());
        }
    }

    /* renamed from: N2 */
    public final void m22785N2(CreateOrder createOrder) {
        CloudSpace cloudSpace;
        if (createOrder == null || (cloudSpace = this.f16520M) == null) {
            m22786N3(4002);
            return;
        }
        this.f16536U.setId(cloudSpace.getId());
        this.f16536U.setRequestId(createOrder.getRequestId());
        PayReq payReq = new PayReq();
        payReq.productName = createOrder.getProductName();
        payReq.productDesc = createOrder.getProductDesc();
        payReq.applicationID = createOrder.getApplicationID();
        payReq.requestId = createOrder.getRequestId();
        payReq.amount = createOrder.getAmount();
        payReq.merchantId = createOrder.getMerchantId();
        payReq.merchantName = getString(R$string.cloudpay_pay_name);
        payReq.url = createOrder.getNotifyUrl();
        payReq.serviceCatalog = "X8";
        payReq.sdkChannel = createOrder.getSdkChannel();
        payReq.urlVer = createOrder.getUrlVer();
        payReq.reservedInfor = createOrder.getReservedInfor();
        payReq.country = createOrder.getCountry();
        payReq.currency = createOrder.getCurrency();
        payReq.sign = createOrder.getSign();
        C13197n.m79381a().m79382b(payReq, new C3582l(10001, this));
        m22769H4();
        m22803U4();
        this.f16527P0 = false;
    }

    /* renamed from: N3 */
    public void m22786N3(int i10) {
        this.f21448i.m66668x("1");
        if (String.valueOf(0).equals(this.f21448i.m66647c())) {
            this.f21448i.m66665u("114_" + String.valueOf(i10));
        }
        C13622a.m81968n(this, this.f21448i);
        if (!this.f16521M0) {
            m28583a1();
            mo19476h5();
        }
        m22859p2();
        if (i10 == 6) {
            C1442a.m8289e("BuyPackageBaseActivity", "handleErrorCode st is invalid.");
            m22749C2();
            return;
        }
        if (i10 != 10) {
            if (i10 == 107) {
                mo22716i5();
                return;
            }
            if (i10 == 109) {
                Toast.makeText(this, R$string.not_satisfied_rule_tip, 0).show();
                m22749C2();
                return;
            }
            if (i10 == 123) {
                Toast.makeText(this, getString(R$string.cloudpay_invalid_deduct_amount), 0).show();
                m22749C2();
                mo19460T3();
                return;
            } else if (i10 == 1020) {
                C1442a.m8290i("BuyPackageBaseActivity", "dealSignPurchaseFail , server not support demo device");
                Toast.makeText(this, getString(com.huawei.android.p073ds.R$string.cloudpay_demo_device_pay_toast_show), 0).show();
                m22749C2();
                return;
            } else if (i10 != 16 && i10 != 17) {
                m22731c5(i10);
                return;
            }
        }
        C1442a.m8290i("BuyPackageBaseActivity", "handleErrorCode release errCode : " + i10);
        Toast.makeText(this, getString(R$string.cloudpay_package_released), 0).show();
        if (this.f16521M0) {
            m22753D2();
        } else {
            mo19460T3();
        }
    }

    /* renamed from: N4 */
    public void m22787N4() {
        this.f16527P0 = false;
        mo19460T3();
    }

    /* renamed from: O2 */
    public void mo22788O2(int i10) {
        m22786N3(i10);
    }

    /* renamed from: O3 */
    public void mo19452O3(Message message) {
    }

    /* renamed from: O4 */
    public void mo19453O4(int i10, Intent intent) throws JSONException {
        String stringExtra;
        SafeIntent safeIntent = new SafeIntent(intent);
        boolean booleanExtra = false;
        switch (i10) {
            case 10001:
            case 10007:
                mo22829d4(safeIntent);
                break;
            case 10002:
                m22759E4();
                C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
                if (!this.f16552c0) {
                    if (!this.f16556e0) {
                        Intent intent2 = getIntent();
                        if (intent2 != null) {
                            booleanExtra = intent2.getBooleanExtra("is_finish_for_result", false);
                            stringExtra = intent2.getStringExtra("forOtherPage");
                        } else {
                            stringExtra = "";
                        }
                        C1442a.m8290i("BuyPackageBaseActivity", "isFinishForResult " + booleanExtra + ",forOtherPage," + stringExtra);
                        if (!booleanExtra) {
                            if (!"BackupOptionsActivity".equals(stringExtra)) {
                                mo19460T3();
                                break;
                            } else {
                                Activity last = C13019a.m78347n().m78349k().getLast();
                                if (last != null && "BackupOptionsActivity".equals(last.getClass().getSimpleName())) {
                                    finish();
                                    break;
                                } else {
                                    SafeIntent safeIntent2 = new SafeIntent(new Intent(this, (Class<?>) BackupOptionsActivity.class));
                                    safeIntent2.putExtra("forOtherPage", stringExtra);
                                    C10342a.m63676b(this, safeIntent2);
                                    finish();
                                    break;
                                }
                            }
                        } else {
                            SafeIntent safeIntent3 = new SafeIntent(new Intent());
                            safeIntent3.putExtra("is_upgrade_success", true);
                            setResult(-1, safeIntent3);
                            finish();
                            break;
                        }
                    } else {
                        m22739l2();
                        finish();
                        break;
                    }
                } else {
                    Intent intent3 = new Intent(this, (Class<?>) CloudSpaceShareActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f16565l0);
                    bundle.putInt(FamilyShareConstants.EXTRA_KEY, this.f16566m0);
                    intent3.putExtras(bundle);
                    startActivity(intent3);
                    finish();
                    break;
                }
                break;
            case 10003:
            case 10005:
            case NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE /* 10006 */:
                mo19460T3();
                break;
            case 10004:
                m22759E4();
                C13108a.m78878b(getApplicationContext()).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
                mo19460T3();
                break;
            case 10010:
                if (safeIntent.getBooleanExtra("right_to_join_family_for_result", false)) {
                    mo19460T3();
                    break;
                }
                break;
            case RequestManager.NOTIFY_CONNECT_FAILED /* 10012 */:
                if (safeIntent.getBooleanExtra("is_refresh_upgrade", false)) {
                    mo19460T3();
                    break;
                }
                break;
            case RequestManager.NOTIFY_CONNECT_SUSPENDED /* 10013 */:
                mo22790P3(safeIntent);
                C12303d.m73958f().m73962h("user-contact_sync_apply");
                break;
        }
    }

    /* renamed from: P2 */
    public void mo22789P2(Object obj) {
    }

    /* renamed from: P3 */
    public void mo22790P3(Intent intent) {
        if (intent == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "handleIAP4PayResult , data is null");
            this.f16543X0 = false;
            return;
        }
        PurchaseResultInfo purchaseResultInfoFromIntent = Iap.getIapClient((Activity) this).parsePurchaseResultInfoFromIntent(intent);
        int returnCode = purchaseResultInfoFromIntent.getReturnCode();
        C1442a.m8290i("BuyPackageBaseActivity", "handleIAP4PayResult , returnCode = " + returnCode);
        if (returnCode != 0 && this.f16553c1) {
            C1442a.m8289e("BuyPackageBaseActivity", "handleIAP4PayResult isH5SpecificPayResult is true and not success, returnCode = " + returnCode);
            m22831e5();
            return;
        }
        if (returnCode == -1) {
            m22786N3(4002);
            this.f16543X0 = false;
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (returnCode == 0) {
            C11296s.m67816g0(this);
            m22826c4();
            if (this.f16543X0) {
                C11296s.m67812e0(this);
            }
            String inAppPurchaseData = purchaseResultInfoFromIntent.getInAppPurchaseData();
            C1442a.m8288d("BuyPackageBaseActivity", "handleIAP4PayResult inAppPurchaseDataStr = " + inAppPurchaseData);
            C1442a.m8288d("BuyPackageBaseActivity", "handleIAP4PayResult inAppPurchaseDataSignature = " + purchaseResultInfoFromIntent.getInAppDataSignature());
            try {
                InAppPurchaseData inAppPurchaseData2 = (InAppPurchaseData) new Gson().fromJson(inAppPurchaseData, InAppPurchaseData.class);
                if (this.f16557e1) {
                    mo19478l5();
                }
                m22762F3(inAppPurchaseData2);
            } catch (JsonSyntaxException e10) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleIAP4PayResult e : " + e10.getMessage());
                if (this.f16521M0) {
                    m22753D2();
                    return;
                }
            }
            this.f16543X0 = false;
            return;
        }
        if (returnCode == 60000) {
            if (this.f16521M0) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleIAP4PayResult isAOPSubscribePay not success, returnCode = " + returnCode);
                m22753D2();
                return;
            }
            mo19476h5();
            mo22839i4();
            this.f16543X0 = false;
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (returnCode != 60003) {
            if (returnCode != 60051) {
                this.f16543X0 = false;
                m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
                m22786N3(4002);
                return;
            }
            m22823b4();
            this.f16543X0 = false;
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (this.f16521M0) {
            C1442a.m8289e("BuyPackageBaseActivity", "handleIAP4PayResult isAOPSubscribePay not success, returnCode = " + returnCode);
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            m22786N3(4002);
            return;
        }
        if (this.f16543X0) {
            m22794R1();
        } else if (this.f16515J0) {
            m22889w5();
            this.f16543X0 = false;
        } else {
            m22894y2(m22882v2());
            this.f16543X0 = false;
        }
        m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
    }

    /* renamed from: P4 */
    public final void m22791P4() {
        C11839m.m70688i("BuyPackageBaseActivity", "sendRefreshUpgradePage");
        Intent intent = new Intent();
        intent.setAction(FamilyShareConstants.Report.CLICK_JOIN_BUTTON);
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: Q2 */
    public void mo19455Q2(int i10) {
        mo19477k5();
    }

    /* renamed from: Q3 */
    public void mo22792Q3(String str) {
    }

    /* renamed from: Q4 */
    public void m22793Q4(String str, String str2) {
        this.f16500C = str;
        this.f16502D = str2;
    }

    /* renamed from: R1 */
    public void m22794R1() {
        C1442a.m8290i("BuyPackageBaseActivity", "acceptHandleSignInfo");
        AcceptSignGiftResp acceptSignGiftResp = this.f16547Z0;
        if (acceptSignGiftResp == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "acceptHandleSignInfo mAcceptSignGiftResp is null.");
            return;
        }
        int signMode = acceptSignGiftResp.getSignMode();
        if (signMode == 1) {
            C1442a.m8290i("BuyPackageBaseActivity", "acceptHandleSignInfo dealQuerySignStatusSuccess");
            m22864q3(this.f16547Z0.getSignInfo());
        } else {
            if (signMode == 2) {
                C1442a.m8290i("BuyPackageBaseActivity", "acceptHandleSignInfo dealSignPurchaseSuccess");
                m22878u3(this.f16547Z0.getPurchaseInfo(), 7034);
                return;
            }
            C1442a.m8289e("BuyPackageBaseActivity", "acceptHandleSignInfo invalid signMode = " + signMode);
            mo19460T3();
            this.f16543X0 = false;
        }
    }

    /* renamed from: R2 */
    public void mo19456R2(Object obj) {
        if (!(obj instanceof GetAvailableGradePackagesResp)) {
            C11839m.m70688i("BuyPackageBaseActivity", "GetAvailableGradePackagesResp cast error");
            mo19477k5();
            return;
        }
        GetAvailableGradePackagesResp getAvailableGradePackagesResp = (GetAvailableGradePackagesResp) obj;
        this.f16540W = C11296s.m67831o(getAvailableGradePackagesResp.getPackageGrades(), getAvailableGradePackagesResp.getSpacePackages(), getAvailableGradePackagesResp.getServerTime());
        mo22742A3(getAvailableGradePackagesResp);
        mo19479s5();
        m22876t5(this.f16540W);
    }

    /* renamed from: R3 */
    public void mo22795R3(Object obj) throws Resources.NotFoundException {
        C1442a.m8290i("BuyPackageBaseActivity", "handleNoDeductEstimate");
        m28583a1();
        UserPackage userPackage = this.f21452m;
        CloudSpace cloudSpace = this.f16520M;
        GetClientUIConfigResp getClientUIConfigResp = this.f16538V;
        if (!this.f16525O0 && !this.f16543X0) {
            if (this.f16527P0) {
                this.f16527P0 = false;
                mo19479s5();
            } else {
                mo19476h5();
            }
        }
        if (obj instanceof EstimateResp) {
            EstimateResp estimateResp = (EstimateResp) obj;
            if (cloudSpace == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleNoDeductEstimate selectPackage is null.");
                return;
            }
            if (userPackage == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleNoDeductEstimate userPackage is null.");
                return;
            }
            CloudSpace cloudSpaceM67757a = C11293p.m67757a(userPackage);
            long capacity = cloudSpaceM67757a.getCapacity();
            long capacity2 = cloudSpace.getCapacity();
            if (estimateResp.getConvertInfo() == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleNoDeductEstimate error, convert info is null");
                return;
            }
            if (capacity >= capacity2 && (cloudSpace.getType() != 12 || cloudSpace.getDurationMonth() != 12)) {
                m22899z3(cloudSpaceM67757a, cloudSpace, estimateResp);
                return;
            }
            if (getClientUIConfigResp == null) {
                C1442a.m8289e("BuyPackageBaseActivity", "handleNoDeductEstimate params is null.");
                mo19476h5();
            } else {
                ConfirmBuyPackageDialog confirmBuyPackageDialog = new ConfirmBuyPackageDialog(this);
                this.f16522N = confirmBuyPackageDialog;
                m22740r5(confirmBuyPackageDialog, estimateResp, getClientUIConfigResp);
            }
        }
    }

    /* renamed from: R4 */
    public void m22796R4(String str, String str2, String str3) {
        this.f16500C = str;
        this.f16502D = str2;
        this.f16508G = str3;
    }

    /* renamed from: S2 */
    public void m22797S2(Object obj) {
        C1442a.m8290i("BuyPackageBaseActivity", "getClientUiConfigSuccess");
        this.f16538V = (GetClientUIConfigResp) obj;
        mo22843j5();
        mo19479s5();
    }

    /* renamed from: S3 */
    public boolean m22798S3() {
        return this.f16503D0 == 2;
    }

    /* renamed from: S4 */
    public abstract boolean mo19458S4();

    /* renamed from: T2 */
    public void m22799T2(int i10) {
        C1442a.m8289e("BuyPackageBaseActivity", "getClientUIConfig code = " + i10);
        m22896y4(1, "pay_result_get_client_ui_config_fail_" + i10);
        mo19477k5();
    }

    /* renamed from: T3 */
    public abstract void mo19460T3();

    /* renamed from: T4 */
    public void m22800T4(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f16518L = new H5WMPayUrlAttr(str, str2, str3, str4, str5, str6);
    }

    /* renamed from: U2 */
    public void m22801U2(Object obj) {
        this.f16567n0 = (GetGradeRightDetailResp) obj;
        mo19479s5();
    }

    /* renamed from: U3 */
    public boolean m22802U3() {
        return this.f16503D0 == 1;
    }

    /* renamed from: U4 */
    public void m22803U4() {
        this.f16525O0 = false;
        this.f16500C = null;
        this.f16502D = null;
        this.f16508G = null;
        this.f16506F = null;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        safeIntent.putExtra("from_where", this.f16525O0);
        C1442a.m8290i("BuyPackageBaseActivity", "setIsFromH5PayFalse isFromH5 = " + this.f16525O0);
        setIntent(safeIntent);
    }

    /* renamed from: V2 */
    public void mo22804V2(Object obj) {
    }

    /* renamed from: V3 */
    public boolean m22805V3() {
        return this.f16501C0;
    }

    /* renamed from: V4 */
    public void m22806V4(String str, String str2, String str3, String str4) {
        this.f16510H = str;
        this.f16512I = str2;
        this.f16514J = str3;
        this.f16516K = str4;
    }

    /* renamed from: W2 */
    public void mo22807W2(Object obj) {
    }

    /* renamed from: W3 */
    public final /* synthetic */ CloudPackage m22808W3(CloudPackage cloudPackage) {
        for (String str : this.f21457r) {
            if (cloudPackage.getId().equals(str)) {
                return cloudPackage;
            }
        }
        return null;
    }

    /* renamed from: W4 */
    public void m22809W4(int i10, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (i10 == 7 || i10 == 8) {
            this.f16520M.setPrice(bigDecimal2);
        } else {
            this.f16520M.setPrice(bigDecimal);
        }
    }

    /* renamed from: X2 */
    public void m22810X2(String str) {
        C1442a.m8291w("BuyPackageBaseActivity", "notify status = " + str);
        if (this.f16532S) {
            this.f16532S = false;
            m22758E3();
        } else if ("Initial".equals(str)) {
            m22786N3(4);
            m22751C4("failed_by_get_notify_still_initial");
        } else if ("Invalid".equals(str)) {
            m22786N3(4002);
            m22751C4("failed_by_get_notify_invalid");
        }
    }

    /* renamed from: X3 */
    public final /* synthetic */ void m22811X3(DialogInterface dialogInterface, int i10) {
        AlertDialog alertDialog = this.f16554d0;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: X4 */
    public void m22812X4(boolean z10) {
        this.f16501C0 = z10;
    }

    /* renamed from: Y2 */
    public void mo19466Y2() {
        C1442a.m8290i("BuyPackageBaseActivity", "abstract base dealGetPackagesBySpaceRuleFail.");
    }

    /* renamed from: Y3 */
    public boolean m22813Y3() {
        return (m22802U3() || m22798S3()) && C11303z.m67859c().m67860a(this.f16568o0);
    }

    /* renamed from: Y4 */
    public void m22814Y4(String str) {
        this.f16506F = str;
    }

    /* renamed from: Z2 */
    public final void m22815Z2(Object obj) {
        try {
            FilterDataForRecommend filterDataForRecommend = (FilterDataForRecommend) obj;
            this.f16548a0 = filterDataForRecommend.getFilterAvailabalGradePackageList();
            List<Voucher> voucherList = filterDataForRecommend.getVoucherList();
            this.f16535T0 = voucherList;
            if (voucherList == null || !C11296s.m67787K() || !C11296s.m67789M(this)) {
                this.f16535T0 = new ArrayList();
            }
            if (this.f16548a0 == null) {
                this.f16548a0 = new ArrayList<>();
            }
            mo19479s5();
        } catch (Exception unused) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealGetPackagesBySpaceRuleSuccess object is invalid.");
            m22786N3(4002);
        }
    }

    /* renamed from: Z3 */
    public void m22816Z3() {
        C1442a.m8290i("BuyPackageBaseActivity", "notifyGalleryUpgradeSpace");
        C12515a.m75110o().m75172d(new C12331w(true, true, 26));
    }

    /* renamed from: Z4 */
    public void m22817Z4(List<Voucher> list) {
        this.f16563j0.clear();
        if (list != null) {
            this.f16563j0.addAll(list);
        }
    }

    /* renamed from: a3 */
    public final void m22818a3(int i10) {
        m28583a1();
        if (i10 != 1 && i10 != 10 && i10 != 13) {
            if (i10 == 801) {
                if (this.f16534T) {
                    m28582Z0();
                    return;
                } else {
                    m22890x2();
                    return;
                }
            }
            if (i10 == 803 || i10 == 811) {
                m22786N3(4006);
                return;
            }
            switch (i10) {
                case 15:
                case 16:
                case 17:
                case 18:
                    break;
                default:
                    m22786N3(4002);
                    break;
            }
        }
        m22786N3(i10);
    }

    /* renamed from: a4 */
    public void m22819a4(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8290i("BuyPackageBaseActivity", "notifyRefreshSpace");
            C11296s.m67816g0(this);
        }
    }

    /* renamed from: a5 */
    public void m22820a5(C0079a c0079a) {
        ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(this, c0079a);
        this.f16559f1 = confirmRenewAgreementDialog;
        confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
        this.f16559f1.show();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: b1 */
    public void mo22821b1() {
        if (!C11296s.m67798V()) {
            m22894y2(m22882v2());
        } else if (this.f16521M0) {
            m22752C5();
        } else {
            m22744A5();
        }
    }

    /* renamed from: b3 */
    public final void m22822b3(Object obj) {
        m28583a1();
        if (obj == null) {
            m22786N3(4002);
            m22751C4("failed_by_sign_obj_null");
            return;
        }
        if (!(obj instanceof MonthSign)) {
            m22786N3(4002);
            m22751C4("failed_by_sign_obj_not_monthly");
            return;
        }
        MonthSign monthSign = (MonthSign) obj;
        WithholdRequest withholdRequest = new WithholdRequest();
        withholdRequest.productName = monthSign.getProductName();
        withholdRequest.productDesc = monthSign.getProductDesc();
        withholdRequest.amount = monthSign.getAmount();
        withholdRequest.merchantId = monthSign.getMerchantId();
        withholdRequest.merchantName = getString(R$string.cloudpay_pay_name);
        withholdRequest.currency = monthSign.getCurrency();
        withholdRequest.country = monthSign.getCountry();
        withholdRequest.sdkChannel = monthSign.getSdkChannel();
        withholdRequest.url = monthSign.getUrl();
        withholdRequest.applicationID = monthSign.getApplicationID();
        withholdRequest.requestId = monthSign.getRequestId();
        withholdRequest.serviceCatalog = monthSign.getServiceCatalog();
        withholdRequest.tradeType = monthSign.getTradeType();
        withholdRequest.sign = monthSign.getSign();
        C13197n.m79381a().m79383c(withholdRequest, new C3582l(10007, this));
        m22769H4();
    }

    /* renamed from: b4 */
    public void m22823b4() {
        if (this.f16541W0 == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "obtainOwnedPurchases mSignPurchaseResp is null.");
            m22786N3(4002);
        } else {
            OwnedPurchasesReq ownedPurchasesReq = new OwnedPurchasesReq();
            ownedPurchasesReq.setPriceType(this.f16541W0.getPriceType().intValue());
            Iap.getIapClient((Activity) this).obtainOwnedPurchases(ownedPurchasesReq).addOnSuccessListener(new C3572b()).addOnFailureListener(new C3571a());
        }
    }

    /* renamed from: b5 */
    public final void m22824b5() {
        mo19476h5();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton(R$string.cloudpay_payment_result_dialog_agree, new DialogInterfaceOnClickListenerC3576f());
        builder.setMessage(R$string.cloudpay_h5_invalid_package);
        AlertDialog alertDialogCreate = builder.create();
        this.f16499B0 = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
            m22888w4();
        }
    }

    /* renamed from: c3 */
    public final void m22825c3() {
        if (TextUtils.isEmpty(C11282e.m67709b(this).m67712d("ACCOUNT_REGISTER_TIMEZONE"))) {
            String id2 = TimeZone.getDefault().getID();
            C1442a.m8288d("BuyPackageBaseActivity", "dealGetUserGegisterFail timeZone = " + id2);
            C11282e.m67709b(this).m67717i("ACCOUNT_REGISTER_TIMEZONE", C11477c.m68636f(id2));
        }
        this.f16546Z = new GetUserRegisterResp();
        mo19479s5();
    }

    /* renamed from: c4 */
    public void m22826c4() {
        C1442a.m8290i("BuyPackageBaseActivity", "OpenSyncItemSwitch");
        try {
            String stringExtra = new SafeIntent(getIntent()).getStringExtra("srcChannel");
            C1442a.m8290i("BuyPackageBaseActivity", "OpenSyncItemSwitch, mSrcChannel:" + stringExtra);
            if ("544".equals(stringExtra)) {
                C10028c.m62182c0().m62245M2(NotifyUtil.HI_NOTE_SYNC_TYPE, 1);
                C10028c.m62182c0().m62336h2(NotifyUtil.HI_NOTE_SYNC_TYPE, true);
                C1442a.m8290i("BuyPackageBaseActivity", "setSwitchStatusToSp appName: hinote,switchStatus:true");
                C2783d.m16116W0(NotifyUtil.HI_NOTE_SYNC_TYPE, "1", "1", 13, 0);
            }
        } catch (Throwable th2) {
            C1442a.m8289e("BuyPackageBaseActivity", "openFullDataServiceSwitch getStringExtra e " + th2.toString());
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: d1 */
    public void mo22827d1() {
        m22890x2();
    }

    /* renamed from: d3 */
    public void m22828d3(GetUserRegisterResp getUserRegisterResp) {
        if (getUserRegisterResp != null) {
            this.f16546Z = getUserRegisterResp;
            HashMap<String, String> resultMap = getUserRegisterResp.getResultMap();
            if (resultMap != null) {
                String str = resultMap.get("userTimeZone");
                C1442a.m8288d("BuyPackageBaseActivity", "dealGetUserGegisterSuccess timeZone = " + str);
                if (TextUtils.isEmpty(str)) {
                    C1442a.m8291w("BuyPackageBaseActivity", "dealGetUserGegisterSuccess timeZone is null.");
                } else {
                    String strM68636f = C11477c.m68636f(str);
                    C13452e.m80781L().m80809G2(strM68636f);
                    C11282e.m67709b(this).m67717i("ACCOUNT_REGISTER_TIMEZONE", strM68636f);
                }
            }
        } else {
            this.f16546Z = new GetUserRegisterResp();
        }
        mo19479s5();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013b A[Catch: RuntimeException -> 0x0058, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0058, blocks: (B:56:0x0019, B:58:0x0038, B:61:0x005b, B:63:0x006b, B:65:0x006f, B:67:0x0087, B:69:0x008b, B:85:0x00c0, B:86:0x00c3, B:87:0x00c6, B:88:0x00dd, B:89:0x00f9, B:90:0x0104, B:91:0x0128, B:93:0x0137, B:94:0x013b), top: B:99:0x0019 }] */
    /* renamed from: d4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo22829d4(android.content.Intent r10) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity.mo22829d4(android.content.Intent):void");
    }

    /* renamed from: d5 */
    public void mo19541d5() {
        if (C13452e.m80781L().m80795D0()) {
            C11839m.m70688i("BuyPackageBaseActivity", "showGuidH5  child account!");
            onBackPressed();
            return;
        }
        int iM1357g = C0212e0.m1357g(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NUM, -1);
        String strM1363m = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_H5URL, "");
        if (TextUtils.isEmpty(strM1363m) || iM1357g == -1) {
            onBackPressed();
            C11839m.m70688i("BuyPackageBaseActivity", "showGuidH5  h5Url == null:  true");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "BuyPackageBaseActivity_h5Url_return_queryh5oknum: " + iM1357g);
            return;
        }
        if (FrequencyManager.checkInValidTime(this, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE)) {
            C11839m.m70688i("BuyPackageBaseActivity", "showGuidH5 CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PAGETYPE checkInValidTime true");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "BuyPackageBaseActivity_checkInValidTime_return");
            onBackPressed();
            return;
        }
        int iM1357g2 = C0212e0.m1357g(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_FREQUENCY, 1);
        FrequencyManager frequencyManager = new FrequencyManager();
        C11839m.m70688i("BuyPackageBaseActivity", "showGuidH5  frequency: " + iM1357g2);
        if (!frequencyManager.checkGuideH5DialogFrequency(this, iM1357g2, -1, iM1357g2 == 0 ? C0212e0.m1357g(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_INTERVAL, 0) : 0)) {
            C11839m.m70688i("BuyPackageBaseActivity", "showGuidH5  checkGuideH5DialogFrequency:  false");
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.H5_GUIDE_DIALOG_ONBACK_CHECK, "BuyPackageBaseActivity_checkGuideH5DialogFrequency_return");
            finish();
            return;
        }
        String strM1363m2 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_ACTIVEURL, "");
        String strM1363m3 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_PACKAGEID, "");
        String strM1363m4 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NOTIFYTYPE, "");
        String strM1363m5 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, FrequencyManager.CHECK_GUID_H5_RECOMMEND_DATA_RECORD_NOTIFYURL, "");
        String strM1363m6 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, "check_guid_h5_dialog_recommend_data_gradeCode", "");
        String strM1363m7 = C0212e0.m1363m(this, FrequencyManager.CHECK_GUID_H5_DATA_RECORDSP, "check_guid_h5_dialog_recommend_data_expireTime", "");
        if (iM1357g == 0) {
            m22764F5(iM1357g, strM1363m, strM1363m3, "", "", "", "", "");
            return;
        }
        if (iM1357g == 1) {
            m22764F5(iM1357g, strM1363m, "", "", "", strM1363m2, "", "");
            return;
        }
        if (iM1357g == 2) {
            m22764F5(iM1357g, strM1363m, "", strM1363m4, strM1363m5, "", "", "");
        } else if (iM1357g == 3 || iM1357g == 4) {
            m22764F5(iM1357g, strM1363m, strM1363m3, strM1363m4, strM1363m5, strM1363m2, strM1363m6, strM1363m7);
        }
    }

    /* renamed from: e3 */
    public void m22830e3(int i10) {
        C1442a.m8290i("BuyPackageBaseActivity", "getUserPackagesFail code = " + i10);
        m22896y4(1, "pay_result_get_userpackage_fail_" + i10);
        mo19477k5();
    }

    /* renamed from: e4 */
    public void mo19472e4(long j10) {
    }

    /* renamed from: e5 */
    public void m22831e5() {
        C10804r c10804rM23288W6;
        Toast.makeText(this, R$string.cloudpay_sign_err_tip, 1).show();
        if ((this instanceof CloudSpaceUpgradeActivity) && (c10804rM23288W6 = CloudSpaceUpgradeActivity.m23288W6()) != null) {
            c10804rM23288W6.m65759f("GET_SPACE_OK_H5_DIALOG");
        }
        m22738k2();
        finish();
    }

    /* renamed from: f3 */
    public void mo19473f3(Object obj) {
        if (obj == null || !(obj instanceof UserPackage)) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealGetUserPackageSuccess obj is not UserPackage.");
            mo19477k5();
        } else {
            C1442a.m8290i("BuyPackageBaseActivity", "dealGetUserPackageSuccess");
            this.f21452m = (UserPackage) obj;
            mo19479s5();
        }
    }

    /* renamed from: f4 */
    public void mo22832f4(Message message) {
        if (message == null) {
            C11839m.m70687e("BuyPackageBaseActivity", "process get activity entry fail, but msg is null");
            return;
        }
        C11839m.m70687e("BuyPackageBaseActivity", "process get activity entry fail, code: " + message.arg1 + ", message: " + message.obj);
    }

    /* renamed from: f5 */
    public final void m22833f5() {
        Toast.makeText(this, R$string.cloudpay_h5_signed_err_tip, 1).show();
        m22738k2();
        finish();
    }

    /* renamed from: g3 */
    public void mo22834g3(int i10) {
    }

    /* renamed from: g4 */
    public boolean mo22835g4(Message message) {
        if (message == null) {
            C11839m.m70687e("BuyPackageBaseActivity", "process get activity entry success, but msg is null");
            return false;
        }
        Object obj = message.obj;
        if (!(obj instanceof GetActivityEntryResp)) {
            C11839m.m70687e("BuyPackageBaseActivity", "process get activity entry success, but msg obj is not GetActivityEntryResp");
            return false;
        }
        C11839m.m70688i("BuyPackageBaseActivity", "process get activity entry success, message object is " + obj.toString());
        GetActivityEntryResp getActivityEntryResp = (GetActivityEntryResp) obj;
        if (getActivityEntryResp.getResultCode() == 0) {
            long clientVersion = getActivityEntryResp.getClientVersion();
            ActivityEntry entry = getActivityEntryResp.getEntry();
            if (entry == null) {
                C11839m.m70687e("BuyPackageBaseActivity", "get activity entry SUCCESS, but campaignInfoList is null");
                return false;
            }
            if (!"dlApp".equals(entry.getcType())) {
                C11839m.m70687e("BuyPackageBaseActivity", "get activity entry SUCCESS , but cType is not dlApp , so no campaignInfo ");
                return false;
            }
            this.f16570q0 = entry.getResource();
            this.f16571r0 = entry.getUrl();
            C11839m.m70686d("BuyPackageBaseActivity", "get activity entry SUCCESS , resourceId " + this.f16570q0 + " url " + this.f16571r0);
            DlAppCampInfo campaignInfo = entry.getCampaignInfo();
            if (campaignInfo == null) {
                C11839m.m70687e("BuyPackageBaseActivity", "get activity entry SUCCESS, but campaignInfo is null");
                return false;
            }
            this.f16572s0 = campaignInfo.getMinLimit();
            this.f16573t0 = campaignInfo.getLaunchNo();
            AdParametersExt adParametersExt = campaignInfo.getAdParametersExt();
            this.f16575v0 = adParametersExt;
            if (adParametersExt == null) {
                C11839m.m70687e("BuyPackageBaseActivity", " but adParametersExt is null");
                return false;
            }
            this.f16574u0 = adParametersExt.getPpsAdid();
            C11839m.m70688i("BuyPackageBaseActivity", "tPpsAdid:" + this.f16574u0);
            C10121i.m63036b(this.f16575v0);
            C11839m.m70686d("BuyPackageBaseActivity", "get activity entry SUCCESS , minLimit " + this.f16572s0 + " launchNo " + this.f16573t0 + " adId " + this.f16574u0);
            if (!TextUtils.isEmpty(this.f16570q0) && !TextUtils.isEmpty(this.f16571r0) && !TextUtils.isEmpty(this.f16574u0)) {
                mo19472e4(clientVersion);
                return true;
            }
            C11839m.m70687e("BuyPackageBaseActivity", "get activity entry SUCCESS, resourceId or url is null");
        }
        return false;
    }

    /* renamed from: g5 */
    public abstract void mo19474g5();

    /* renamed from: h3 */
    public void mo22836h3(Object obj) {
    }

    /* renamed from: h4 */
    public void mo22837h4() {
    }

    /* renamed from: h5 */
    public abstract void mo19476h5();

    /* renamed from: i3 */
    public void m22838i3() {
        C1442a.m8290i("BuyPackageBaseActivity", "dealMemberQuitFamilyShareFail");
        finish();
    }

    /* renamed from: i4 */
    public void mo22839i4() {
    }

    /* renamed from: i5 */
    public void mo22716i5() {
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog;
        if (!isFinishing() && (memberQuitFamilyShareDialog = this.f16505E0) != null && memberQuitFamilyShareDialog.isShowing()) {
            this.f16505E0.dismiss();
        }
        this.f16505E0 = null;
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog2 = new MemberQuitFamilyShareDialog(this, this.f16521M0);
        this.f16505E0 = memberQuitFamilyShareDialog2;
        memberQuitFamilyShareDialog2.setCanceledOnTouchOutside(false);
        this.f16505E0.showStopFamilyShareDialog();
    }

    /* renamed from: j2 */
    public void m22840j2(Intent intent) {
        m28580X0(intent);
    }

    /* renamed from: j3 */
    public void m22841j3(RetResult retResult) {
        if (retResult == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealMemberQuitFamilyShareSuccess retResult is null.");
            finish();
            return;
        }
        int retCode = retResult.getRetCode();
        if (retCode != 0) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealMemberQuitFamilyShareSuccess code = " + retCode);
            finish();
            return;
        }
        if (this.f16521M0) {
            m22752C5();
            return;
        }
        mo19460T3();
        C1399b.m8034o().m8053t(false);
        m22791P4();
    }

    /* renamed from: j4 */
    public void m22842j4(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null) {
            try {
                if (this.f16521M0) {
                    C11296s.m67807c(this.f16523N0, linkedHashMap);
                    linkedHashMap.put("aop_from_where", String.valueOf(this.f16504E));
                }
                m28593u1(linkedHashMap);
                m22851n2(linkedHashMap, this.f16520M);
                C13227f.m79492i1().m79567R(str, linkedHashMap);
                UBAAnalyze.m29958S("PVC", str, "1", "31", linkedHashMap);
                m28575A1(str, linkedHashMap);
            } catch (Exception e10) {
                C1442a.m8289e("BuyPackageBaseActivity", "reportActivityBaseEvent occur:" + e10.getMessage());
            }
        }
    }

    /* renamed from: j5 */
    public void mo22843j5() {
    }

    /* renamed from: k3 */
    public void mo22844k3(int i10) {
        m22751C4("failed_by_get_notify_or_estimate_" + i10);
        m22786N3(i10);
    }

    /* renamed from: k4 */
    public void m22845k4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("package_id", String.valueOf(cloudSpace.getId()));
        }
        m22842j4("UNIFORM_CLOUDPAY_ESTIMATE_AOP_DIALOG", linkedHashMapM79497A);
    }

    /* renamed from: k5 */
    public abstract void mo19477k5();

    /* renamed from: l3 */
    public void mo22846l3(Object obj) {
        C1442a.m8290i("BuyPackageBaseActivity", "dealNotifySuccess");
        m22866q5((OrderResult) obj);
    }

    /* renamed from: l4 */
    public void mo22847l4(Bundle bundle) {
    }

    /* renamed from: l5 */
    public abstract void mo19478l5();

    /* renamed from: m2 */
    public C0079a m22848m2(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback) {
        C0079a c0079a = new C0079a();
        c0079a.m652i(this.f16538V.getCheckDialogRenewAgreement());
        c0079a.m656m(cloudPackage);
        c0079a.m653j(packageGrades);
        c0079a.m657n(list);
        c0079a.m655l(reportVoucherInfo);
        c0079a.m651h(agreementDlgCallback);
        return c0079a;
    }

    /* renamed from: m3 */
    public void mo20372m3(Intent intent, String str) {
        C1442a.m8290i("BuyPackageBaseActivity", "dealPayStateSuccess witholdID = " + str);
        C0202a.m1119c().m1123e(1);
        if (str != null) {
            this.f16534T = false;
            m22897y5();
            return;
        }
        this.f16532S = true;
        if (this.f16536U != null) {
            this.f16536U.setOrderId(new SafeIntent(intent).getStringExtra("orderID"));
        }
        m22758E3();
    }

    /* renamed from: m4 */
    public void m22849m4() throws JSONException {
        JSONObject jSONObjectM79464f = C13222a.m79464f(getApplicationContext(), "CLOUDPAY_CANCEL_PAY_BUTTON", "1", C13452e.m80781L().m80971t0(), C13222a.m79465g(this));
        try {
            CloudSpace cloudSpace = this.f16520M;
            if (cloudSpace != null) {
                jSONObjectM79464f.put("package_id", cloudSpace.getId());
            }
        } catch (JSONException e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79464f);
        UBAAnalyze.m29963X("PVC", "CLOUDPAY_CANCEL_PAY_BUTTON", "1", "31", jSONObjectM79464f);
        m22751C4("failed_by_cancel_pay");
    }

    /* renamed from: m5 */
    public final void m22850m5() throws IllegalAccessException, IllegalArgumentException {
        C11839m.m70688i("BuyPackageBaseActivity", "showPkgNotMatchDialog");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f16554d0 = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f16554d0.setMessage(getString(R$string.package_not_match_notice));
        this.f16554d0.setButton(-1, getString(R$string.cloudpay_huaweipay_sure), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f17536a.m22811X3(dialogInterface, i10);
            }
        });
        this.f16554d0.show();
    }

    /* renamed from: n2 */
    public void m22851n2(LinkedHashMap<String, String> linkedHashMap, CloudSpace cloudSpace) {
        if (cloudSpace != null) {
            linkedHashMap.put("package_id", cloudSpace.getId());
            linkedHashMap.put("is_aop_pay", String.valueOf(this.f16521M0));
            if (!this.f16521M0) {
                linkedHashMap.put("capacity", String.valueOf(cloudSpace.getCapacity()));
                linkedHashMap.put("productType", String.valueOf(cloudSpace.getType()));
                linkedHashMap.put("duration_month", String.valueOf(cloudSpace.getDurationMonth()));
                linkedHashMap.put("price", String.valueOf(cloudSpace.getPrice()));
            }
        }
        UserPackage userPackage = this.f21452m;
        if (userPackage != null) {
            linkedHashMap.put("can_deduct_amount", String.valueOf(userPackage.getDeductAmount()));
        }
        if (this.f16521M0) {
            C11296s.m67807c(this.f16523N0, linkedHashMap);
            linkedHashMap.put("aop_from_where", String.valueOf(this.f16504E));
        }
        linkedHashMap.put("final_deduct_amount", String.valueOf(this.f16539V0));
        linkedHashMap.put("way_of_purchase", this.f16576w0);
        linkedHashMap.put("pay_success_sal_channel", this.f16512I);
        linkedHashMap.put("pay_success_src_channel", this.f16510H);
        linkedHashMap.put("pay_success_activity_code", this.f16514J);
        linkedHashMap.put("pay_success_invite_code", this.f16516K);
        linkedHashMap.put("h5_pull_pay", String.valueOf(this.f16553c1));
    }

    /* renamed from: n3 */
    public void mo22852n3(Message message) {
    }

    /* renamed from: n4 */
    public void m22853n4(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
            linkedHashMapM79497A.put("capacity", String.valueOf(this.f16520M.getCapacity()));
            linkedHashMapM79497A.put("dialog_click_btn_type", str);
        }
        m22842j4("UNIFORM_CLOUDPAY_DIALOG_CLICK_BTN", linkedHashMapM79497A);
    }

    /* renamed from: n5 */
    public final void m22854n5(Message message) {
        Object obj = message.obj;
        if (obj == null || !(obj instanceof Dialog)) {
            return;
        }
        ((Dialog) obj).show();
    }

    /* renamed from: o2 */
    public final void m22855o2(Object obj) {
        if (obj instanceof QueryPushGuideRsp) {
            this.f16537U0 = (QueryPushGuideRsp) obj;
        }
        mo22760E5(this.f16537U0);
    }

    /* renamed from: o3 */
    public void mo22856o3(Object obj) {
    }

    /* renamed from: o4 */
    public void m22857o4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
        }
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_CLICK_ESTIMAE_NAGATIVE_BTN", linkedHashMapM79497A);
    }

    /* renamed from: o5 */
    public void mo22858o5(Object obj) {
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f16552c0 = hiCloudSafeIntent.getBooleanExtra("family_share", false);
        this.f16565l0 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, -1);
        this.f16566m0 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.EXTRA_KEY, -1);
        this.f16560g0 = hiCloudSafeIntent.getStringExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY);
        this.f16562i0 = hiCloudSafeIntent.getIntExtra("chosen_backup_frequency", 0);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ConfirmBuyPackageDialog confirmBuyPackageDialog = this.f16522N;
        if (confirmBuyPackageDialog != null) {
            confirmBuyPackageDialog.dismiss();
            this.f16522N = null;
        }
        PayResultErrorDialog payResultErrorDialog = this.f16528Q;
        if (payResultErrorDialog != null) {
            payResultErrorDialog.dismiss();
            this.f16528Q = null;
        }
        AlertDialog alertDialog = this.f16499B0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f16499B0 = null;
        }
        HandlerC3583m handlerC3583m = this.f16524O;
        if (handlerC3583m != null) {
            handlerC3583m.removeCallbacksAndMessages(null);
            this.f16524O = null;
        }
        Dialog dialog = this.f16577x0;
        if (dialog != null) {
            dialog.dismiss();
            this.f16577x0 = null;
        }
        MemberQuitFamilyShareDialog memberQuitFamilyShareDialog = this.f16505E0;
        if (memberQuitFamilyShareDialog != null) {
            memberQuitFamilyShareDialog.dismiss();
            this.f16505E0 = null;
        }
        ConfirmRenewAgreementDialog confirmRenewAgreementDialog = this.f16559f1;
        if (confirmRenewAgreementDialog != null) {
            confirmRenewAgreementDialog.dismiss();
            this.f16559f1 = null;
        }
        C12303d.m73958f().m73962h("user-contact_sync_apply");
    }

    /* renamed from: p2 */
    public void m22859p2() {
        this.f16518L = null;
    }

    /* renamed from: p3 */
    public void mo22860p3(int i10) {
        C1442a.m8290i("BuyPackageBaseActivity", "dealQuerySignStatusFail code = " + i10);
        if (this.f16553c1) {
            m22831e5();
        } else {
            m22786N3(i10);
        }
    }

    /* renamed from: p4 */
    public void m22861p4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
        }
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_CLICK_ESTIMAE_POSITIVE_BTN", linkedHashMapM79497A);
    }

    /* renamed from: p5 */
    public final void m22862p5(String str) {
        if (isFinishing()) {
            C1442a.m8291w("BuyPackageBaseActivity", "showRepeatPresentDialog , Activity is Finishing.");
            return;
        }
        PayResultErrorDialog payResultErrorDialog = this.f16528Q;
        if (payResultErrorDialog != null && payResultErrorDialog.isShowing()) {
            this.f16528Q.dismiss();
        }
        this.f16528Q = null;
        PayResultErrorDialog payResultErrorDialog2 = new PayResultErrorDialog(this, this.f16521M0);
        this.f16528Q = payResultErrorDialog2;
        payResultErrorDialog2.showRepeatPurchaseDialog(str);
    }

    /* renamed from: q2 */
    public void m22863q2() {
        C1442a.m8290i("BuyPackageBaseActivity", "clickConfirmNegativeBtn");
        this.f16521M0 = false;
        Intent intent = new Intent();
        intent.putExtra("renew_call_back_scene", "pay_result");
        setResult(0, intent);
        finish();
    }

    /* renamed from: q3 */
    public void m22864q3(Object obj) {
        float fFloatValue;
        this.f16527P0 = false;
        if (obj == null) {
            C1442a.m8290i("BuyPackageBaseActivity", "object is null.");
            m22786N3(4002);
            m22751C4("failed_by_sign_status_obj_null");
            m22803U4();
            return;
        }
        if (obj instanceof QuerySignStatusResp) {
            QuerySignStatusResp querySignStatusResp = (QuerySignStatusResp) obj;
            if (querySignStatusResp.getSignStatus() == 0) {
                WithholdRequest withholdRequest = new WithholdRequest();
                withholdRequest.productName = querySignStatusResp.getProductName();
                withholdRequest.productDesc = querySignStatusResp.getProductDesc();
                withholdRequest.amount = querySignStatusResp.getAmount();
                withholdRequest.merchantId = querySignStatusResp.getMerchantId();
                withholdRequest.merchantName = getString(R$string.cloudpay_pay_name);
                withholdRequest.currency = querySignStatusResp.getCurrency();
                withholdRequest.country = querySignStatusResp.getCountry();
                withholdRequest.sdkChannel = querySignStatusResp.getSdkChannel();
                withholdRequest.url = querySignStatusResp.getUrl();
                withholdRequest.applicationID = querySignStatusResp.getApplicationID();
                withholdRequest.requestId = querySignStatusResp.getRequestId();
                withholdRequest.serviceCatalog = querySignStatusResp.getServiceCatalog();
                withholdRequest.tradeType = querySignStatusResp.getTradeType();
                withholdRequest.sign = querySignStatusResp.getSign();
                C13197n.m79381a().m79383c(withholdRequest, new C3582l(10007, this));
                m22769H4();
                C1442a.m8290i("BuyPackageBaseActivity", "dealQuerySignStatusSuccess unSign deduction fee.");
            } else if (querySignStatusResp.getSignStatus() == 1) {
                try {
                    fFloatValue = Float.valueOf(querySignStatusResp.getAmount()).floatValue();
                } catch (NumberFormatException unused) {
                    C1442a.m8289e("BuyPackageBaseActivity", "packagePrice NumberFormatException");
                    fFloatValue = -1.0f;
                }
                CloudSpace cloudSpace = this.f16520M;
                if (cloudSpace == null) {
                    C1442a.m8289e("BuyPackageBaseActivity", "dealQuerySignStatusSuccess select is null.");
                    mo19460T3();
                    m22803U4();
                    return;
                }
                if (fFloatValue == 0.0f) {
                    C9158a.m57503F().m57544i(this.f16524O, this.f21448i, this.f16520M.getId(), this, m22882v2(), mo22754D3(), this.f16539V0);
                    C1442a.m8290i("BuyPackageBaseActivity", "dealQuerySignStatusSuccess Sign price is zero.");
                } else if (fFloatValue > 0.0f) {
                    NotifyReq notifyReq = this.f16536U;
                    if (notifyReq == null) {
                        C1442a.m8289e("BuyPackageBaseActivity", "dealQuerySignStatusSuccess request is null.");
                        mo19460T3();
                        m22803U4();
                        return;
                    }
                    notifyReq.setId(cloudSpace.getId());
                    this.f16536U.setRequestId(querySignStatusResp.getRequestId());
                    PayReq payReq = new PayReq();
                    payReq.productName = querySignStatusResp.getProductName();
                    payReq.productDesc = querySignStatusResp.getProductDesc();
                    payReq.applicationID = querySignStatusResp.getApplicationID();
                    payReq.requestId = querySignStatusResp.getRequestId();
                    payReq.amount = querySignStatusResp.getAmount();
                    payReq.merchantId = querySignStatusResp.getMerchantId();
                    payReq.merchantName = getString(R$string.cloudpay_pay_name);
                    payReq.url = querySignStatusResp.getUrl();
                    payReq.serviceCatalog = querySignStatusResp.getServiceCatalog();
                    payReq.sdkChannel = querySignStatusResp.getSdkChannel();
                    payReq.urlVer = querySignStatusResp.getUrlVer();
                    payReq.reservedInfor = querySignStatusResp.getReservedInfor();
                    payReq.country = querySignStatusResp.getCountry();
                    payReq.currency = querySignStatusResp.getCurrency();
                    payReq.sign = querySignStatusResp.getSign();
                    C13197n.m79381a().m79382b(payReq, new C3582l(10001, this));
                    m22769H4();
                    C1442a.m8290i("BuyPackageBaseActivity", "dealQuerySignStatusSuccess Sign subscribe.");
                } else {
                    C1442a.m8291w("BuyPackageBaseActivity", "packagePrice < 0");
                    m22786N3(4002);
                    m22751C4("failed_by_package_price_negative");
                }
            } else {
                C1442a.m8290i("BuyPackageBaseActivity", "signStatus is not 0 or 1,status is not right.");
                m22786N3(4002);
                m22751C4("failed_by_sign_status_unknow");
            }
        } else {
            C1442a.m8290i("BuyPackageBaseActivity", "object is not instanceof QuerySignStatusResp.");
            m22786N3(4002);
            m22751C4("failed_by_sign_status_obj_instance_exception");
        }
        m22803U4();
    }

    /* renamed from: q4 */
    public void m22865q4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        try {
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_HAS_HIGHEST_GRADE", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_HAS_HIGHEST_GRADE", "1", "31", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_HAS_HIGHEST_GRADE", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportClickHasHighestGrade occur:" + e10.getMessage());
        }
    }

    /* renamed from: q5 */
    public final void m22866q5(OrderResult orderResult) {
        if (this.f16520M == null) {
            C1442a.m8291w("BuyPackageBaseActivity", "select is null");
            m22751C4("failed_by_get_notify_obj_null");
            return;
        }
        String status = orderResult.getStatus();
        if (!"Valid".equals(status)) {
            m22810X2(status);
            return;
        }
        if (this.f16521M0) {
            C1442a.m8290i("BuyPackageBaseActivity", "aop notify success");
            m22747B4(0, "success_by_get_notify", null);
            this.f16521M0 = false;
            if (orderResult.getSubType() != 1) {
                C1442a.m8288d("BuyPackageBaseActivity", "sendPaySuccessBroadcast, get notify success, backup frequency is " + this.f16562i0);
                C11296s.m67818h0(this, orderResult.getGradeRights(), this.f16562i0);
                m22816Z3();
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.hicloud.intent.action.ACTION_AOP_PAY_SUCCESS");
            C13108a.m78878b(this).m78881d(intent);
            Intent intent2 = new Intent();
            intent2.putExtra("renew_call_back_scene", "pay_result");
            setResult(-1, intent2);
            finish();
            return;
        }
        C11060c c11060c = this.f21448i;
        if (c11060c != null) {
            c11060c.m66668x("1");
        }
        C13622a.m81968n(this, this.f21448i);
        this.f16520M.setEndTime(orderResult.getEndTime());
        PaySuccessShowNeedData paySuccessShowNeedData = new PaySuccessShowNeedData();
        paySuccessShowNeedData.setCurrency(orderResult.getCurrency());
        paySuccessShowNeedData.setAmount(orderResult.getAmount());
        paySuccessShowNeedData.setRenewalTime(orderResult.getEndTime());
        paySuccessShowNeedData.setProductType(orderResult.getProductType());
        paySuccessShowNeedData.setGradeRights(orderResult.getGradeRights());
        paySuccessShowNeedData.setPackageGrade(orderResult.getPackageGrade());
        paySuccessShowNeedData.setSubType(orderResult.getSubType());
        paySuccessShowNeedData.setCapacity(orderResult.getCapacity());
        paySuccessShowNeedData.setUser(this.f21452m);
        paySuccessShowNeedData.setParams(this.f16538V);
        paySuccessShowNeedData.setDurationMonth(orderResult.getDurationMonth());
        paySuccessShowNeedData.setDurationUnit(orderResult.getDurationUnit());
        paySuccessShowNeedData.setIsAutoPay(orderResult.getIsAutoPay());
        paySuccessShowNeedData.setTotalCapacity(orderResult.getTotalCapacity());
        paySuccessShowNeedData.setScheme(orderResult.getScheme());
        m22755D4("success_by_get_notify", paySuccessShowNeedData);
        if (orderResult.getSubType() != 1) {
            C1442a.m8288d("BuyPackageBaseActivity", "sendPaySuccessBroadcast, get notify success, backup frequency is " + this.f16562i0);
            C11296s.m67818h0(this, orderResult.getGradeRights(), this.f16562i0);
            m22816Z3();
        }
        m22771I3(paySuccessShowNeedData);
    }

    /* renamed from: r2 */
    public void mo22867r2() {
    }

    /* renamed from: r3 */
    public void mo22868r3(int i10) {
        C1442a.m8290i("BuyPackageBaseActivity", "dealQuerySubOrderStatusFail code = " + i10);
        m22751C4("failed_by_sub_order_query_exception_" + i10);
        m22786N3(i10);
    }

    /* renamed from: r4 */
    public void m22869r4(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C13227f.m79492i1().m79591l0(str, linkedHashMap);
        UBAAnalyze.m29947H("CKC", str, linkedHashMap);
    }

    /* renamed from: s2 */
    public final void m22870s2(SignPurchaseResp signPurchaseResp, int i10) {
        C1442a.m8290i("BuyPackageBaseActivity", "confirmSupportNewIap start");
        Iap.getIapClient((Activity) this).isEnvReady().addOnSuccessListener(new C3578h(signPurchaseResp)).addOnFailureListener(new C3577g(i10));
    }

    /* renamed from: s3 */
    public void mo22871s3(Object obj) {
        if (obj == null || !(obj instanceof QuerySubOrderStatusResp)) {
            C1442a.m8291w("BuyPackageBaseActivity", "dealQuerySubOrderStatusSuccess object is null.");
            m22751C4("failed_by_sign_check_failed");
            m22786N3(4002);
            return;
        }
        QuerySubOrderStatusResp querySubOrderStatusResp = (QuerySubOrderStatusResp) obj;
        this.f21448i.m66668x("1");
        C13622a.m81968n(this, this.f21448i);
        this.f16520M.setEndTime(querySubOrderStatusResp.getEndTime());
        PaySuccessShowNeedData paySuccessShowNeedData = new PaySuccessShowNeedData();
        paySuccessShowNeedData.setCurrency(querySubOrderStatusResp.getCurrency());
        paySuccessShowNeedData.setAmount(querySubOrderStatusResp.getAmount());
        paySuccessShowNeedData.setRenewalTime(querySubOrderStatusResp.getEndTime());
        paySuccessShowNeedData.setProductType(querySubOrderStatusResp.getProductType());
        paySuccessShowNeedData.setGradeRights(querySubOrderStatusResp.getGradeRights());
        paySuccessShowNeedData.setPackageGrade(querySubOrderStatusResp.getPackageGrade());
        paySuccessShowNeedData.setSubType(0);
        paySuccessShowNeedData.setCapacity(querySubOrderStatusResp.getCapacity());
        paySuccessShowNeedData.setDurationMonth(querySubOrderStatusResp.getDurationMonth());
        paySuccessShowNeedData.setDurationUnit(querySubOrderStatusResp.getDurationUnit());
        paySuccessShowNeedData.setTotalCapacity(querySubOrderStatusResp.getTotalCapacity());
        m22755D4("success_by_sub_order_query", paySuccessShowNeedData);
        C1442a.m8288d("BuyPackageBaseActivity", "sendPaySuccessBroadcast, query suborder status success, backup frequency is " + this.f16562i0);
        C11296s.m67818h0(this, querySubOrderStatusResp.getGradeRights(), this.f16562i0);
        m22816Z3();
        m22771I3(paySuccessShowNeedData);
    }

    /* renamed from: s4 */
    public void m22872s4(CloudPackage cloudPackage, PackageGrades packageGrades, String str, int i10) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            if (cloudPackage != null) {
                linkedHashMapM79497A.put("package_id", cloudPackage.getId());
                linkedHashMapM79497A.put("capacity", String.valueOf(cloudPackage.getCapacity()));
                linkedHashMapM79497A.put("productType", String.valueOf(cloudPackage.getProductType()));
                linkedHashMapM79497A.put("duration_month", String.valueOf(cloudPackage.getDurationMonth()));
                linkedHashMapM79497A.put("price", String.valueOf(cloudPackage.getPrice()));
                if (packageGrades != null) {
                    linkedHashMapM79497A.put("grade_code", packageGrades.getGradeCode());
                }
            }
            linkedHashMapM79497A.put("way_of_purchase", str);
            linkedHashMapM79497A.put("voucher_column_state", String.valueOf(i10));
            m22842j4("UNIFORM_CLOUDPAY_CLICK_PACKAGE_CARD", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportClickPackageCardInfo ERROR OCCUR:" + e10.getMessage());
        }
    }

    /* renamed from: s5 */
    public abstract void mo19479s5();

    /* renamed from: t2 */
    public void m22873t2() {
        C1442a.m8290i("BuyPackageBaseActivity", "continueSignPurchaseTask");
        if (this.f21452m == null || this.f16520M == null) {
            C11839m.m70687e("BuyPackageBaseActivity", "continueSignPurchaseTask user is null");
            mo19476h5();
        } else {
            this.f16532S = true;
            mo19478l5();
            C9158a.m57503F().m57542g0(this.f16524O, this.f21448i, this.f16520M.getId(), m22882v2(), mo22754D3(), C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), this.f16511H0, 0, this.f16539V0);
        }
    }

    /* renamed from: t3 */
    public void m22874t3(int i10, int i11) {
        PayResultErrorDialog payResultErrorDialog;
        if (i10 == 405) {
            C1442a.m8291w("BuyPackageBaseActivity", "dealSignPurchaseFail , server not support iap 4.0");
            if (i11 == 7035) {
                m22894y2(m22882v2());
                return;
            } else {
                m22889w5();
                return;
            }
        }
        if (i10 != 106) {
            C1442a.m8289e("BuyPackageBaseActivity", "dealSignPurchaseFail , errCode = " + i10);
            m22786N3(i10);
            return;
        }
        if (!isFinishing() && (payResultErrorDialog = this.f16528Q) != null && payResultErrorDialog.isShowing()) {
            this.f16528Q.dismiss();
        }
        this.f16528Q = null;
        PayResultErrorDialog payResultErrorDialog2 = new PayResultErrorDialog(this, this.f16521M0);
        this.f16528Q = payResultErrorDialog2;
        payResultErrorDialog2.showRepeatPurchaseDialog(null, true);
    }

    /* renamed from: t4 */
    public void m22875t4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("package_id", String.valueOf(cloudSpace.getId()));
        }
        m22842j4("UNIFORM_CLOUDPAY_ESTIMATE_DEDUCT_DIALOG", linkedHashMapM79497A);
    }

    /* renamed from: t5 */
    public boolean m22876t5(ArrayList<FilterAvailabalGradePackage> arrayList) {
        if (!C11296s.m67787K() || !C11296s.m67789M(this) || arrayList == null || arrayList.isEmpty()) {
            C1442a.m8290i("BuyPackageBaseActivity", "startGetVoucherList -> showView");
            this.f16535T0 = new ArrayList();
            mo19479s5();
            return false;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<FilterAvailabalGradePackage> it = arrayList.iterator();
        while (it.hasNext()) {
            FilterAvailabalGradePackage next = it.next();
            if (next != null) {
                arrayList2.addAll(next.getPackageIdList());
            }
        }
        C1442a.m8290i("BuyPackageBaseActivity", "startGetVoucherList -> getAvaVouchersByPkgIdTimerTask");
        C9158a.m57503F().m57556u(this.f16524O, arrayList2);
        return true;
    }

    /* renamed from: u2 */
    public void m22877u2(String str) {
        C1442a.m8290i("BuyPackageBaseActivity", "continueToCreateOrder");
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace == null || this.f21452m == null) {
            return;
        }
        int type = cloudSpace.getType();
        if (type != 5) {
            if (type != 6) {
                if (type != 7) {
                    if (type != 8) {
                        return;
                    }
                }
            }
            mo19478l5();
            C9158a.m57503F().m57532b0(this.f16524O, this.f21448i, this.f16520M.getId(), 0, C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), m22882v2(), mo22754D3(), this.f16539V0);
            return;
        }
        mo19478l5();
        if (this.f16563j0.size() > 0) {
            C9158a.m57503F().m57546k(this.f16524O, this.f16520M.getId(), this.f21448i, 0, str, 1, C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), m22882v2(), mo22754D3());
        } else {
            C9158a.m57503F().m57547l(this.f16524O, this.f16520M.getId(), this.f21448i, 0, str, m22882v2(), mo22754D3());
        }
    }

    /* renamed from: u3 */
    public void m22878u3(Object obj, int i10) {
        if (obj instanceof SignPurchaseResp) {
            this.f16541W0 = (SignPurchaseResp) obj;
            if (this.f16521M0) {
                CloudSpace cloudSpace = new CloudSpace();
                this.f16520M = cloudSpace;
                cloudSpace.setId(this.f16541W0.getId());
            }
            m22870s2(this.f16541W0, i10);
        } else {
            C1442a.m8289e("BuyPackageBaseActivity", "dealSignPurchaseSuccess faild.");
            m22786N3(4002);
        }
        this.f16527P0 = false;
        m22803U4();
    }

    /* renamed from: u4 */
    public void m22879u4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("productType", String.valueOf(cloudSpace.getType()));
        }
        m22842j4("UNIFORM_CLOUDPAY_UPGRADE_ESTIMAE_SHOW", linkedHashMapM79497A);
    }

    /* renamed from: u5 */
    public void m22880u5(CloudPackage cloudPackage, PackageGrades packageGrades, String str, List<Voucher> list, ChannelInfo channelInfo, ReportVoucherInfo reportVoucherInfo, BigDecimal bigDecimal) throws JSONException {
        ConfirmBuyPackageDialog confirmBuyPackageDialog;
        C1442a.m8290i("BuyPackageBaseActivity", "startPay start");
        if (cloudPackage == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "startPay order is null.");
            return;
        }
        if (this.f21452m == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "startPay user is null.");
            return;
        }
        if ("1".equals(this.f16555d1) && m28589p1()) {
            m22833f5();
            return;
        }
        BigDecimal bigDecimalM67832p = C11296s.m67832p(cloudPackage, list, bigDecimal);
        this.f16539V0 = bigDecimalM67832p;
        this.f16564k0 = cloudPackage;
        m22817Z4(list);
        this.f16576w0 = str;
        m22778K4(cloudPackage.getId(), str);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("type", Integer.valueOf(cloudPackage.getDurationMonth()));
        C13227f.m79492i1().m79591l0("mecloud_upgrade_click_timelong", linkedHashMapM79499C);
        UBAAnalyze.m29957R("PVC", "mecloud_upgrade_click_timelong", "1", "30", "type", String.valueOf(cloudPackage.getDurationMonth()));
        if (mo19458S4()) {
            m22751C4("failed_by_no_net");
            return;
        }
        int productType = cloudPackage.getProductType();
        CloudSpace cloudSpace = new CloudSpace();
        this.f16520M = cloudSpace;
        cloudSpace.setId(cloudPackage.getId());
        if (cloudPackage.getProductType() == 12) {
            this.f16520M.setProductName(cloudPackage.getProductName());
        } else {
            this.f16520M.setProductName(cloudPackage.getProductName(this));
        }
        this.f16520M.setProductType(productType);
        this.f16520M.setDurationMonth(cloudPackage.getDurationMonth());
        this.f16520M.setCapacity(cloudPackage.getCapacity());
        this.f16520M.setBaseCapacity(this.f21452m.getBaseCapacity());
        this.f16520M.setCurrency(cloudPackage.getCurrency());
        this.f16520M.setDurationUnit(cloudPackage.getDurationUnit());
        this.f16520M.setGrade(packageGrades);
        m22809W4(productType, cloudPackage.getPrice(), cloudPackage.getSpPrice());
        int productType2 = cloudPackage.getProductType();
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
        ProgressDialog progressDialog = this.f21453n;
        if ((progressDialog != null && progressDialog.isShowing()) || ((confirmBuyPackageDialog = this.f16522N) != null && confirmBuyPackageDialog.isShowing())) {
            C1442a.m8288d("BuyPackageBaseActivity", "mWaittingDlg or dialog is showing");
            m22751C4("failed_by_dialog_waiting");
            return;
        }
        m22806V4(this.f16500C, this.f16502D, this.f16508G, this.f16506F);
        m22781L4(str, reportVoucherInfo);
        if (cloudPackage.getProductType() == 12 && cloudPackage.getDurationMonth() == 12 && C11293p.m67773q(this.f21452m)) {
            this.f16532S = true;
            C9158a.m57503F().m57548m(this.f16524O, cloudPackage.getId(), productType2, this.f21448i, bigDecimalM67832p);
            m28578L1();
            return;
        }
        if (C11293p.m67775s(this.f21452m) && cloudPackage.getCapacity() != 2199023255552L) {
            C1442a.m8290i("BuyPackageBaseActivity", "is only 2t increment");
            this.f16532S = true;
            C9158a.m57503F().m57548m(this.f16524O, cloudPackage.getId(), productType2, this.f21448i, bigDecimalM67832p);
            m28578L1();
            return;
        }
        if (cloudSpaceM67757a.getCapacity() != cloudPackage.getCapacity() && ((cloudSpaceM67757a.getCapacity() == cloudPackage.getCapacity() || cloudSpaceM67757a.getEndTime() >= this.f21452m.getServerTime()) && (cloudSpaceM67757a.getType() != 0 || cloudSpaceM67757a.getCapacity() != 0))) {
            this.f16532S = true;
            C9158a.m57503F().m57548m(this.f16524O, cloudPackage.getId(), productType2, this.f21448i, bigDecimalM67832p);
            if (this.f16527P0) {
                return;
            }
            m28578L1();
            return;
        }
        C1442a.m8288d("BuyPackageBaseActivity", "channelInfo appid:" + channelInfo.getSrcAppId());
        m28588o1("06004");
        this.f16527P0 = false;
        this.f16532S = true;
        this.f16534T = true;
        if (!C11296s.m67798V()) {
            m22894y2(cloudPackage.getProductType() == 12 ? m22886w2(true) : m22882v2());
        } else if (cloudPackage.getProductType() == 12) {
            m22748B5(true);
        } else {
            m22744A5();
        }
        m22803U4();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: v1 */
    public void mo22881v1() {
        mo19460T3();
    }

    /* renamed from: v2 */
    public ChannelInfo m22882v2() {
        return m22886w2(false);
    }

    /* renamed from: v3 */
    public void mo22883v3() {
    }

    /* renamed from: v4 */
    public void m22884v4(LinkedHashMap<String, String> linkedHashMap) {
        m22842j4("UNIFORM_CLOUDPAY_CLICK_RIGHT", linkedHashMap);
    }

    /* renamed from: v5 */
    public void m22885v5(CloudPackage cloudPackage, PackageGrades packageGrades, String str, List<Voucher> list, ChannelInfo channelInfo, BigDecimal bigDecimal) throws JSONException {
        m22880u5(cloudPackage, packageGrades, str, list, channelInfo, null, bigDecimal);
    }

    /* renamed from: w2 */
    public ChannelInfo m22886w2(boolean z10) {
        ChannelInfo channelInfo = new ChannelInfo();
        if (!TextUtils.isEmpty(this.f21459t)) {
            channelInfo.setSrcAppId(this.f21459t);
        }
        if (!TextUtils.isEmpty(this.f16502D)) {
            channelInfo.setSalChannel(this.f16502D);
        }
        if (!TextUtils.isEmpty(this.f16500C)) {
            channelInfo.setSrcChannel(this.f16500C);
        }
        if (!TextUtils.isEmpty(this.f16508G)) {
            channelInfo.setActivityCode(this.f16508G);
        }
        if (z10) {
            channelInfo.setSalChannel("1");
        }
        return channelInfo;
    }

    /* renamed from: w3 */
    public void mo22887w3(Object obj) {
    }

    /* renamed from: w4 */
    public void m22888w4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        try {
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_HAS_HIGHEST_GRADE_DIALOG_SHOW", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_HAS_HIGHEST_GRADE_DIALOG_SHOW", "1", "31", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_HAS_HIGHEST_GRADE_DIALOG_SHOW", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportHasHighestGradeDialogShow occur:" + e10.getMessage());
        }
    }

    /* renamed from: w5 */
    public final void m22889w5() {
        if (this.f16563j0.size() <= 0) {
            C9158a.m57503F().m57547l(this.f16524O, this.f16520M.getId(), this.f21448i, 1, this.f16511H0, this.f16513I0, mo22754D3());
        } else if (this.f21452m != null && this.f16520M != null) {
            C9158a.m57503F().m57546k(this.f16524O, this.f16520M.getId(), this.f21448i, 1, this.f16511H0, 1, C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), this.f16513I0, mo22754D3());
        } else {
            C11839m.m70687e("BuyPackageBaseActivity", "startPresentTask user is null");
            mo19476h5();
        }
    }

    /* renamed from: x2 */
    public final void m22890x2() {
        if (this.f16520M == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "createMonthOrder select is null.");
            return;
        }
        mo19478l5();
        NotifyReq notifyReq = this.f16536U;
        if (notifyReq != null) {
            notifyReq.setId(this.f16520M.getId());
        } else {
            C1442a.m8289e("BuyPackageBaseActivity", "createMonthOrder request is null.");
        }
        C9158a.m57503F().m57545j(this.f16524O, this.f16520M.getId(), this.f21448i, mo22754D3());
    }

    /* renamed from: x3 */
    public void mo22891x3(Object obj) {
    }

    /* renamed from: x4 */
    public final void m22892x4() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            m22851n2(linkedHashMapM79497A, this.f16520M);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_PULL_IAP_4_EVENT", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_PULL_IAP_4_EVENT", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_PULL_IAP_4_EVENT", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportIAP4PullPayEvent error occur:" + e10.getMessage());
        }
    }

    /* renamed from: x5 */
    public void m22893x5(SignPurchaseResp signPurchaseResp) throws JSONException {
        String stringExtra;
        String stringExtra2 = "";
        if (signPurchaseResp == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap fail, signPurchaseResp is null.");
            return;
        }
        String applicationId = signPurchaseResp.getApplicationId();
        if (TextUtils.isEmpty(applicationId)) {
            C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap fail, applicationId is null or empty.");
            return;
        }
        C1442a.m8290i("BuyPackageBaseActivity", "applicationId :" + applicationId);
        PurchaseIntentReq purchaseIntentReq = new PurchaseIntentReq();
        purchaseIntentReq.setProductId(signPurchaseResp.getId());
        purchaseIntentReq.setPriceType(signPurchaseResp.getPriceType().intValue());
        this.f16509G0 = signPurchaseResp.getPayload();
        purchaseIntentReq.setDeveloperPayload(new Gson().toJson(this.f16509G0));
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            stringExtra = safeIntent.getStringExtra("srcChannel");
        } catch (Throwable th2) {
            th = th2;
            stringExtra = "";
        }
        try {
            stringExtra2 = safeIntent.getStringExtra("salChannel");
        } catch (Throwable th3) {
            th = th3;
            C1442a.m8289e("BuyPackageBaseActivity", "startPullNewIap getStringExtra e " + th.toString());
            String strM67805b = C11296s.m67805b(signPurchaseResp.getReservedInfor(), this.f16520M.getId(), stringExtra, stringExtra2);
            C1442a.m8288d("BuyPackageBaseActivity", "appendSupportPayment reservedInfoStr :" + strM67805b);
            purchaseIntentReq.setReservedInfor(strM67805b);
            C1442a.m8290i("BuyPackageBaseActivity", "startPullNewIap start");
            Iap.getIapClient((Activity) this, applicationId).createPurchaseIntent(purchaseIntentReq).addOnSuccessListener(new C3580j()).addOnFailureListener(new C3579i());
        }
        String strM67805b2 = C11296s.m67805b(signPurchaseResp.getReservedInfor(), this.f16520M.getId(), stringExtra, stringExtra2);
        C1442a.m8288d("BuyPackageBaseActivity", "appendSupportPayment reservedInfoStr :" + strM67805b2);
        purchaseIntentReq.setReservedInfor(strM67805b2);
        C1442a.m8290i("BuyPackageBaseActivity", "startPullNewIap start");
        Iap.getIapClient((Activity) this, applicationId).createPurchaseIntent(purchaseIntentReq).addOnSuccessListener(new C3580j()).addOnFailureListener(new C3579i());
    }

    /* renamed from: y2 */
    public void m22894y2(ChannelInfo channelInfo) {
        if (mo19458S4()) {
            m22751C4("failed_by_create_order_no_net");
            mo19476h5();
            return;
        }
        if (this.f16520M == null || this.f21452m == null) {
            mo19476h5();
            return;
        }
        C1442a.m8290i("BuyPackageBaseActivity", "start createOrder.");
        this.f16532S = true;
        this.f16534T = true;
        int type = this.f16520M.getType();
        if (type != 5) {
            if (type != 6) {
                if (type != 7) {
                    if (type != 8 && type != 12) {
                        return;
                    }
                }
            }
            mo19478l5();
            C9158a.m57503F().m57532b0(this.f16524O, this.f21448i, this.f16520M.getId(), 1, C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), m22882v2(), mo22754D3(), this.f16539V0);
            return;
        }
        mo19478l5();
        if (this.f16563j0.size() > 0) {
            C9158a.m57503F().m57546k(this.f16524O, this.f16520M.getId(), this.f21448i, 1, null, 1, C11296s.m67779C(this.f16564k0, this.f16563j0, this.f21452m.getDeductAmount()), channelInfo, mo22754D3());
        } else {
            C9158a.m57503F().m57547l(this.f16524O, this.f16520M.getId(), this.f21448i, 1, null, channelInfo, mo22754D3());
        }
    }

    /* renamed from: y3 */
    public void mo22895y3(Object obj) {
    }

    /* renamed from: y4 */
    public void m22896y4(int i10, String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            linkedHashMapM79497A.put("pay_result", String.valueOf(i10));
            linkedHashMapM79497A.put("pay_result_description", str);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_INIT_DATA_RESULT", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_INIT_DATA_RESULT", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_INIT_DATA_RESULT", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("BuyPackageBaseActivity", "reportInitDataResult " + i10 + ", error occur:" + e10.getMessage());
        }
    }

    /* renamed from: y5 */
    public void m22897y5() {
        C1442a.m8290i("BuyPackageBaseActivity", "startQuerySubOrderStatus");
        this.f16524O.postDelayed(new RunnableC3575e(), 3000L);
    }

    /* renamed from: z2 */
    public void m22898z2(String str, ChannelInfo channelInfo) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("BuyPackageBaseActivity", "createPresentOrder error: receiver uid is null");
            return;
        }
        if (this.f16520M == null) {
            C1442a.m8289e("BuyPackageBaseActivity", "createPresentOrder error: select package is null");
            return;
        }
        this.f16532S = true;
        this.f16534T = true;
        mo19478l5();
        this.f16511H0 = str;
        this.f16513I0 = channelInfo;
        if (C11296s.m67798V()) {
            m22756D5(str);
        } else {
            m22889w5();
        }
    }

    /* renamed from: z3 */
    public void m22899z3(CloudSpace cloudSpace, CloudSpace cloudSpace2, EstimateResp estimateResp) throws Resources.NotFoundException {
        this.f16522N = new ConfirmBuyPackageDialog(this);
        ConvertInfo convertInfo = estimateResp.getConvertInfo();
        NumberFormat numberFormat = NumberFormat.getInstance();
        int durationMonth = cloudSpace2.getDurationMonth();
        String quantityString = getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, durationMonth, numberFormat.format(durationMonth));
        int packageConvertDays = convertInfo.getPackageConvertDays();
        String quantityString2 = getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_day, packageConvertDays, numberFormat.format(packageConvertDays));
        String gradeName = cloudSpace2.getGrade().getGradeName();
        String gradeName2 = estimateResp.getGrade().getGradeName();
        int i10 = R$string.cloudpay_package_urse_space_detail;
        int i11 = R$string.cloudpay_parenthesis;
        String string = getString(i10, gradeName, getString(i11, quantityString));
        String string2 = getString(i10, gradeName2, getString(i11, quantityString2));
        ChannelInfo channelInfoM22882v2 = m22882v2();
        if (m28589p1()) {
            if (cloudSpace2.getType() == 6 || cloudSpace2.getType() == 8) {
                C1442a.m8289e("BuyPackageBaseActivity", "big month type buy small month type, error state");
                m22824b5();
                return;
            }
            GetClientUIConfigResp getClientUIConfigResp = this.f16538V;
            if (getClientUIConfigResp != null) {
                this.f16522N.showMonthBigBuyBasicSmall(string, string2, channelInfoM22882v2, getClientUIConfigResp.getBigBuySmallDialogText());
                return;
            } else {
                C1442a.m8289e("BuyPackageBaseActivity", "estimateBigBuySmall,big month type buy small,params is null.");
                return;
            }
        }
        if (cloudSpace2.getType() == 6 || cloudSpace2.getType() == 8) {
            C1442a.m8289e("BuyPackageBaseActivity", "big basic type buy small month type, error state");
            m22824b5();
            return;
        }
        GetClientUIConfigResp getClientUIConfigResp2 = this.f16538V;
        if (getClientUIConfigResp2 != null) {
            this.f16522N.showBasicBigBuyBasicSmall(string, string2, channelInfoM22882v2, getClientUIConfigResp2.getBigBuySmallDialogText());
        } else {
            C1442a.m8289e("BuyPackageBaseActivity", "estimateBigBuySmall,big buy small,params is null.");
        }
    }

    /* renamed from: z4 */
    public void m22900z4() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        CloudSpace cloudSpace = this.f16520M;
        if (cloudSpace != null) {
            linkedHashMapM79497A.put("package_id", String.valueOf(cloudSpace.getId()));
        }
        m22842j4("UNIFORM_CLOUDPAY_ESTIMATE_NO_DEDUCT_DIALOG", linkedHashMapM79497A);
    }

    /* renamed from: z5 */
    public void mo22901z5() {
    }
}
