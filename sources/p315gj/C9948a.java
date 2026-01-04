package p315gj;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.agd.ads.AdSlot;
import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.cloud.pay.model.AcceptRightGiftReq;
import com.huawei.cloud.pay.model.AcceptRightGiftResp;
import com.huawei.cloud.pay.model.AcceptSignGiftReq;
import com.huawei.cloud.pay.model.AcceptSignGiftResp;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.AdAppsQueryReq;
import com.huawei.cloud.pay.model.AdAppsQueryResp;
import com.huawei.cloud.pay.model.AdAppsReportReq;
import com.huawei.cloud.pay.model.BuyPackageReq;
import com.huawei.cloud.pay.model.CalRefundFeeReq;
import com.huawei.cloud.pay.model.CalRefundFeeResp;
import com.huawei.cloud.pay.model.CampaignInfo;
import com.huawei.cloud.pay.model.CardPackageReq;
import com.huawei.cloud.pay.model.CardPackageResp;
import com.huawei.cloud.pay.model.CardPayReq;
import com.huawei.cloud.pay.model.CardPayResp;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.ContinueBuyPackageReq;
import com.huawei.cloud.pay.model.CreateFreeOrderReq;
import com.huawei.cloud.pay.model.CreateFreeOrderResp;
import com.huawei.cloud.pay.model.CreateOrder;
import com.huawei.cloud.pay.model.EstimateReq;
import com.huawei.cloud.pay.model.EstimateResp;
import com.huawei.cloud.pay.model.FileterAdInfoReq;
import com.huawei.cloud.pay.model.FileterAdInfoRsp;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.ForwardIMReq;
import com.huawei.cloud.pay.model.ForwardIMResp;
import com.huawei.cloud.pay.model.GetActivityEntryReq;
import com.huawei.cloud.pay.model.GetActivityEntryResp;
import com.huawei.cloud.pay.model.GetAllVouchersReq;
import com.huawei.cloud.pay.model.GetAllVouchersResp;
import com.huawei.cloud.pay.model.GetAvaVouchersReq;
import com.huawei.cloud.pay.model.GetAvaVouchersResp;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesReq;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetCardCountryReq;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetFreePackageReq;
import com.huawei.cloud.pay.model.GetFreePackageResp;
import com.huawei.cloud.pay.model.GetGradeRightDetailReq;
import com.huawei.cloud.pay.model.GetGradeRightDetailResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleReq;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.GetPublicKeyReq;
import com.huawei.cloud.pay.model.GetPublicKeyResp;
import com.huawei.cloud.pay.model.GetRecommendActivityReq;
import com.huawei.cloud.pay.model.GetRecommendActivityResp;
import com.huawei.cloud.pay.model.GetSignReq;
import com.huawei.cloud.pay.model.GetUserPackageReq;
import com.huawei.cloud.pay.model.MonthDetail;
import com.huawei.cloud.pay.model.MonthOrder;
import com.huawei.cloud.pay.model.MonthPayReq;
import com.huawei.cloud.pay.model.MonthSign;
import com.huawei.cloud.pay.model.NotifyReq;
import com.huawei.cloud.pay.model.OrderResult;
import com.huawei.cloud.pay.model.PickWelfareRequest;
import com.huawei.cloud.pay.model.PickWelfareResponse;
import com.huawei.cloud.pay.model.PresentAuthReq;
import com.huawei.cloud.pay.model.PresentAuthResp;
import com.huawei.cloud.pay.model.QueryAdListReq;
import com.huawei.cloud.pay.model.QueryAdListRsp;
import com.huawei.cloud.pay.model.QueryGiftableWelfaresResp;
import com.huawei.cloud.pay.model.QueryO2OActivityResp;
import com.huawei.cloud.pay.model.QueryPickedWelfaresResp;
import com.huawei.cloud.pay.model.QueryPresentReq;
import com.huawei.cloud.pay.model.QueryPresentResp;
import com.huawei.cloud.pay.model.QuerySignStatusReq;
import com.huawei.cloud.pay.model.QuerySignStatusResp;
import com.huawei.cloud.pay.model.QuerySubOrderStatusReq;
import com.huawei.cloud.pay.model.QuerySubOrderStatusResp;
import com.huawei.cloud.pay.model.ReceiveActivityGiftReq;
import com.huawei.cloud.pay.model.ReceiveActivityGiftResq;
import com.huawei.cloud.pay.model.ReportCampaignReq;
import com.huawei.cloud.pay.model.ReportCampaignResp;
import com.huawei.cloud.pay.model.Request;
import com.huawei.cloud.pay.model.Response;
import com.huawei.cloud.pay.model.SignPurchaseReq;
import com.huawei.cloud.pay.model.SignPurchaseResp;
import com.huawei.cloud.pay.model.TransactionItem;
import com.huawei.cloud.pay.model.TrxReq;
import com.huawei.cloud.pay.model.TrxResp;
import com.huawei.cloud.pay.model.UIConfigReq;
import com.huawei.cloud.pay.model.UpdateUserBMInfoReq;
import com.huawei.cloud.pay.model.UpdateUserBMInfoResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.UserTags;
import com.huawei.cloud.pay.model.VoucherInfo;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.opengw.bean.QuotaSpace;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9720a;
import fk.C9721b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0211e;
import p015ak.C0213f;
import p054cj.C1442a;
import p292fn.C9733f;
import p336he.C10155f;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11280c;
import p454lj.C11282e;
import p454lj.C11296s;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p845zi.C14302a;
import tm.C13040c;
import to.C13049a;

/* renamed from: gj.a */
/* loaded from: classes5.dex */
public class C9948a {

    /* renamed from: a */
    public static final Gson f48717a = new Gson();

    /* renamed from: gj.a$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ int f48718a;

        public a(int i10) {
            this.f48718a = i10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("key_update_bm_type", String.valueOf(this.f48718a));
            linkedHashMapM79497A.put("userType", C13452e.m80781L().m80892b1() ? "0" : "1");
            C13227f.m79492i1().m79567R("updateUserBMInfo", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "updateUserBMInfo", linkedHashMapM79497A);
        }
    }

    /* renamed from: gj.a$b */
    public static class b {

        /* renamed from: a */
        public static C9948a f48719a = new C9948a();
    }

    /* renamed from: gj.a$c */
    public static class c extends TypeToken<HashMap<String, String>> {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* renamed from: C */
    public static C9948a m61631C() {
        return b.f48719a;
    }

    /* renamed from: n0 */
    public static void m61632n0(int i10) {
        C12515a.m75110o().m75172d(new a(i10));
    }

    /* renamed from: A */
    public GetFreePackageResp m61633A(C11060c c11060c) throws C9721b {
        try {
            return (GetFreePackageResp) m61687p(m61645N(new GetFreePackageReq(), c11060c), GetFreePackageResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: B */
    public GetGradeRightDetailResp m61634B(C11060c c11060c, String str, int i10) throws C9721b {
        try {
            GetGradeRightDetailReq getGradeRightDetailReq = new GetGradeRightDetailReq("getGradeRightDetail", str, i10);
            m61690q0(c11060c, getGradeRightDetailReq);
            GetGradeRightDetailResp getGradeRightDetailResp = (GetGradeRightDetailResp) m61687p(m61645N(getGradeRightDetailReq, c11060c), GetGradeRightDetailResp.class);
            C11282e.m67709b(C0213f.m1377a()).m67716h("get_grade_right_detail_cache_key_" + str, new Gson().toJson(getGradeRightDetailResp));
            return getGradeRightDetailResp;
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        } catch (C9721b e11) {
            String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_grade_right_detail_cache_key_" + str);
            if (TextUtils.isEmpty(strM67711c)) {
                throw e11;
            }
            C1442a.m8289e("BusinessService", "getGradeRightDetail fail, user cache.");
            try {
                return (GetGradeRightDetailResp) new Gson().fromJson(strM67711c, GetGradeRightDetailResp.class);
            } catch (JsonSyntaxException unused) {
                throw new C9721b(1, "json err " + e11.toString());
            }
        }
    }

    /* renamed from: D */
    public MonthDetail m61635D(C11060c c11060c) throws C9721b {
        Request request = new Request("getMonthPay");
        m61690q0(c11060c, request);
        try {
            return (MonthDetail) m61687p(m61645N(request, c11060c), MonthDetail.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: E */
    public MonthDetail m61636E(C11060c c11060c, int i10, String str) throws C9721b {
        MonthPayReq monthPayReq = new MonthPayReq("getMonthPay");
        monthPayReq.setScheme(2);
        if (!TextUtils.isEmpty(str)) {
            monthPayReq.setSubscriptionId(str);
        }
        m61690q0(c11060c, monthPayReq);
        try {
            return (MonthDetail) m61687p(m61645N(monthPayReq, c11060c), MonthDetail.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: F */
    public GetPackagesBySpaceRuleResp m61637F(C11060c c11060c, int i10, long j10, int i11, int i12, String str, ChannelInfo channelInfo, boolean z10) throws C9721b {
        GetPackagesBySpaceRuleReq getPackagesBySpaceRuleReq = new GetPackagesBySpaceRuleReq(i10, j10, i11, i12, str, channelInfo);
        if (!C11296s.m67798V()) {
            getPackagesBySpaceRuleReq.setClientVer("2");
            getPackagesBySpaceRuleReq.setFeatures("");
        }
        if (z10) {
            getPackagesBySpaceRuleReq.setScheme(2);
        }
        m61690q0(c11060c, getPackagesBySpaceRuleReq);
        try {
            return (GetPackagesBySpaceRuleResp) m61687p(m61645N(getPackagesBySpaceRuleReq, c11060c), GetPackagesBySpaceRuleResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: G */
    public GetPackagesBySpaceRuleResp m61638G(C11060c c11060c, int i10, long j10, int i11, ChannelInfo channelInfo, boolean z10) throws C9721b {
        GetPackagesBySpaceRuleReq getPackagesBySpaceRuleReq = new GetPackagesBySpaceRuleReq(i10, j10, i11, channelInfo);
        if (!C11296s.m67798V()) {
            getPackagesBySpaceRuleReq.setClientVer("2");
            getPackagesBySpaceRuleReq.setFeatures("");
        }
        if (z10) {
            getPackagesBySpaceRuleReq.setScheme(2);
        }
        m61690q0(c11060c, getPackagesBySpaceRuleReq);
        try {
            return (GetPackagesBySpaceRuleResp) m61687p(m61645N(getPackagesBySpaceRuleReq, c11060c), GetPackagesBySpaceRuleResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: H */
    public String m61639H(C11060c c11060c) throws C9721b {
        GetPublicKeyReq getPublicKeyReq = new GetPublicKeyReq();
        m61690q0(c11060c, getPublicKeyReq);
        try {
            return ((GetPublicKeyResp) m61687p(m61645N(getPublicKeyReq, c11060c), GetPublicKeyResp.class)).getPublicKey();
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: I */
    public GetRecommendActivityResp m61640I(List<Integer> list, int i10, C11060c c11060c) throws C9721b {
        try {
            return (GetRecommendActivityResp) m61687p(m61645N(new GetRecommendActivityReq(list, i10), c11060c), GetRecommendActivityResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: J */
    public MonthSign m61641J(String str, C11060c c11060c) throws C9721b {
        C9720a.m60653b(str, "getSignInfo id is null.");
        GetSignReq getSignReq = new GetSignReq(str);
        m61690q0(c11060c, getSignReq);
        try {
            return (MonthSign) m61687p(m61645N(getSignReq, c11060c), MonthSign.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: K */
    public final String m61642K(String str) {
        if (m61650S(str)) {
            return "/cloudpay/user";
        }
        if ("signPurchase".equals(str)) {
            str = "purchase/sign";
        }
        return "/HiCloudBusinessService/Client/" + str;
    }

    /* renamed from: L */
    public long m61643L(C11060c c11060c) throws C9721b {
        try {
            m61690q0(c11060c, new Request("nsp.user.getQuotaInfo"));
            QuotaSpace quotaSpaceM78759x = new C13049a(EnumC12999a.CLOUD_PAY, c11060c.m66661q()).m78759x();
            C11282e.m67709b(C0213f.m1377a()).m67716h("get_user_space_cache_key", new Gson().toJson(quotaSpaceM78759x));
            return quotaSpaceM78759x.getUsed();
        } catch (C9721b e10) {
            C1442a.m8289e("BusinessService", "getUsedSpace e : " + e10.getMessage());
            String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_user_space_cache_key");
            if (TextUtils.isEmpty(strM67711c)) {
                throw new C9721b(4003, "cexception:" + e10.getMessage());
            }
            C1442a.m8291w("BusinessService", "getUsedSpace get info faild, use cache. ");
            try {
                return ((QuotaSpace) new Gson().fromJson(strM67711c, QuotaSpace.class)).getUsed();
            } catch (JsonSyntaxException e11) {
                throw new C9721b(1, "json err " + e11.getMessage());
            }
        }
    }

    /* renamed from: M */
    public UserPackage m61644M(C11060c c11060c, String str) throws C9721b {
        GetUserPackageReq getUserPackageReq = new GetUserPackageReq("getUserPackage");
        m61690q0(c11060c, getUserPackageReq);
        c11060c.m66643I(C11058a.m66627b(str));
        try {
            return (UserPackage) m61687p(m61645N(getUserPackageReq, c11060c), UserPackage.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: N */
    public final String m61645N(Request request, C11060c c11060c) throws C9721b {
        return m61646O(request, c11060c, 50, null);
    }

    /* renamed from: O */
    public final String m61646O(Request request, C11060c c11060c, int i10, String str) throws C9721b {
        return m61648Q(request, c11060c, m61700w(request.getCmd()), i10, str);
    }

    /* renamed from: P */
    public final String m61647P(Request request, C11060c c11060c, String str) throws C9721b {
        return m61646O(request, c11060c, 50, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00fc, code lost:
    
        throw new fk.C9721b(r12, r11.getResultDesc());
     */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m61648Q(com.huawei.cloud.pay.model.Request r19, p429kk.C11060c r20, java.lang.String r21, int r22, java.lang.String r23) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p315gj.C9948a.m61648Q(com.huawei.cloud.pay.model.Request, kk.c, java.lang.String, int, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d8, code lost:
    
        if (r4 != 403) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00e5, code lost:
    
        throw new fk.C9721b(30010, r3.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f1, code lost:
    
        throw new fk.C9721b(com.huawei.hms.support.api.entity.pay.PayStatusCodes.PAY_STATE_NET_ERROR, r3.toString());
     */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m61649R(java.lang.String r22, java.lang.String r23, p429kk.C11060c r24, java.lang.String r25) throws fk.C9721b {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p315gj.C9948a.m61649R(java.lang.String, java.lang.String, kk.c, java.lang.String):java.lang.String");
    }

    /* renamed from: S */
    public final boolean m61650S(String str) {
        str.hashCode();
        switch (str) {
            case "createFreeOrder":
            case "getSignInfo":
            case "getPackagesBySpace":
            case "getUserPackage":
            case "getActivePackages":
            case "getCardPackages":
            case "payByCard":
            case "notify":
            case "calRefundFee":
            case "getAvailablePackages":
            case "getPackagesBySpaceRule":
            case "createOrder":
            case "queryOrderPage":
            case "querySignStatus":
            case "queryOrder":
            case "getClientUIConfig":
            case "createMonthOrder":
            case "getCardCountry":
            case "cancelDegradePackage":
            case "querySubOrderStatus":
            case "getDegradePackage":
            case "getPublicKey":
            case "degradePackage":
            case "getMonthPay":
            case "estimatePackage":
            case "cancelMonthPay":
                return true;
            default:
                return false;
        }
    }

    /* renamed from: T */
    public OrderResult m61651T(NotifyReq notifyReq, C11060c c11060c) throws C9721b {
        C9720a.m60657f(notifyReq, "request is null.");
        C9720a.m60657f(notifyReq.getId(), "package id is null.");
        m61690q0(c11060c, notifyReq);
        try {
            return (OrderResult) m61687p(m61645N(notifyReq, c11060c), OrderResult.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: U */
    public CardPayResp m61652U(CardPayReq cardPayReq, C11060c c11060c) throws C9721b {
        C9720a.m60657f(cardPayReq, "request is invalid.");
        m61690q0(c11060c, cardPayReq);
        try {
            return (CardPayResp) m61687p(m61645N(cardPayReq, c11060c), CardPayResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: V */
    public PickWelfareResponse m61653V(String str, C11060c c11060c) throws C9721b {
        PickWelfareRequest pickWelfareRequest = new PickWelfareRequest("pickWelfare", str);
        m61690q0(c11060c, pickWelfareRequest);
        try {
            return (PickWelfareResponse) m61687p(m61645N(pickWelfareRequest, c11060c), PickWelfareResponse.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: W */
    public PresentAuthResp m61654W(C11060c c11060c, String str, String str2) throws C9721b {
        PresentAuthReq presentAuthReq = new PresentAuthReq("presentAuth", str, str2);
        m61690q0(c11060c, presentAuthReq);
        try {
            return (PresentAuthResp) m61687p(m61645N(presentAuthReq, c11060c), PresentAuthResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: X */
    public final void m61655X(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.length() <= 3072) {
            C1442a.m8288d(str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String strSubstring = str2.substring(0, 3072);
            str2 = str2.replace(strSubstring, "");
            C1442a.m8288d(str, strSubstring);
        }
        C1442a.m8288d(str, str2);
    }

    /* renamed from: Y */
    public QueryAdListRsp m61656Y(AdSlot adSlot, List<RestoreAdAppInfo> list) throws C9721b {
        C11060c c11060cM66626a = C11058a.m66626a(m61676j("07045"), "queryAGDList", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u(String.valueOf(0));
        C1442a.m8290i("BusinessService", "queryAGDList, requestId:" + c11060cM66626a.m66661q());
        QueryAdListReq queryAdListReq = new QueryAdListReq(adSlot, c11060cM66626a.m66661q());
        queryAdListReq.setCmd("queryAGDList");
        queryAdListReq.setAppInfoList(list);
        queryAdListReq.setQueryType(1);
        String strM61688p0 = m61688p0(queryAdListReq);
        try {
            QueryAdListRsp queryAdListRsp = (QueryAdListRsp) m61687p(m61645N(queryAdListReq, c11060cM66626a), QueryAdListRsp.class);
            if (!TextUtils.isEmpty(strM61688p0)) {
                m61683m0(strM61688p0);
            }
            return queryAdListRsp;
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: Z */
    public AdAppsQueryResp m61657Z(C11060c c11060c, int i10, int i11, int i12, int i13) throws C9721b {
        AdAppsQueryReq adAppsQueryReq = new AdAppsQueryReq("queryAdApps", i10, i11, i13, c11060c.m66661q());
        m61690q0(c11060c, adAppsQueryReq);
        try {
            return (AdAppsQueryResp) m61687p(m61646O(adAppsQueryReq, c11060c, i12, null), AdAppsQueryResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: a */
    public AcceptRightGiftResp m61658a(Map<String, String> map, C11060c c11060c) throws C9721b {
        try {
            return (AcceptRightGiftResp) m61687p(m61645N(new AcceptRightGiftReq(map), c11060c), AcceptRightGiftResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: a0 */
    public QueryAdListRsp m61659a0(AdSlot adSlot) throws C9721b {
        C11060c c11060cM66626a = C11058a.m66626a(m61676j("07045"), NotifyConstants.CommonReportConstants.SRC_QUERY_AD_LIST, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u(String.valueOf(0));
        C1442a.m8290i("BusinessService", "queryAdList,requestId:" + c11060cM66626a.m66661q());
        QueryAdListReq queryAdListReq = new QueryAdListReq(adSlot, c11060cM66626a.m66661q());
        String strM61688p0 = m61688p0(queryAdListReq);
        try {
            QueryAdListRsp queryAdListRsp = (QueryAdListRsp) m61687p(m61645N(queryAdListReq, c11060cM66626a), QueryAdListRsp.class);
            if (!TextUtils.isEmpty(strM61688p0)) {
                m61683m0(strM61688p0);
            }
            return queryAdListRsp;
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: b */
    public AcceptSignGiftResp m61660b(C11060c c11060c, CampaignInfo campaignInfo) throws C9721b {
        campaignInfo.setVersion("4");
        AcceptSignGiftReq acceptSignGiftReq = C11296s.m67798V() ? new AcceptSignGiftReq("acceptSignGift", campaignInfo, 2, C11296s.m67834r()) : new AcceptSignGiftReq("acceptSignGift", campaignInfo, 1, C11296s.m67834r());
        m61690q0(c11060c, acceptSignGiftReq);
        try {
            return (AcceptSignGiftResp) m61687p(m61645N(acceptSignGiftReq, c11060c), AcceptSignGiftResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: b0 */
    public Response m61661b0(C11060c c11060c) throws C9721b {
        GetCardCountryReq getCardCountryReq = new GetCardCountryReq("getCardCountry");
        m61690q0(c11060c, getCardCountryReq);
        try {
            return (Response) m61687p(m61645N(getCardCountryReq, c11060c), Response.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: c */
    public String m61662c(String str, String str2, String str3, String str4) throws C9721b {
        C11060c c11060cM66626a = C11058a.m66626a(str3, str, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66644J(C13452e.m80781L().m80971t0());
        c11060cM66626a.m66664t(str);
        try {
            return m61649R(str, str2, c11060cM66626a, str4);
        } finally {
            C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        }
    }

    /* renamed from: c0 */
    public QueryGiftableWelfaresResp m61663c0(C11060c c11060c) throws C9721b {
        Request request = new Request("queryGiftableWelfares");
        m61690q0(c11060c, request);
        try {
            return (QueryGiftableWelfaresResp) m61687p(m61645N(request, c11060c), QueryGiftableWelfaresResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: d */
    public CalRefundFeeResp m61664d(int i10, C11060c c11060c) throws C9721b {
        try {
            return (CalRefundFeeResp) m61687p(m61645N(new CalRefundFeeReq("calRefundFee", i10), c11060c), CalRefundFeeResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: d0 */
    public QueryO2OActivityResp m61665d0(C11060c c11060c) throws C9721b {
        Request request = new Request("queryO2OActivity");
        m61690q0(c11060c, request);
        return (QueryO2OActivityResp) m61687p(m61645N(request, c11060c), QueryO2OActivityResp.class);
    }

    /* renamed from: e */
    public void m61666e(C11060c c11060c) throws C9721b {
        Request request = new Request("cancelMonthPay");
        m61690q0(c11060c, request);
        m61645N(request, c11060c);
    }

    /* renamed from: e0 */
    public QueryPickedWelfaresResp m61667e0(C11060c c11060c) throws C9721b {
        Request request = new Request("queryPickedWelfares");
        m61690q0(c11060c, request);
        try {
            return (QueryPickedWelfaresResp) m61687p(m61645N(request, c11060c), QueryPickedWelfaresResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: f */
    public void m61668f(C11060c c11060c) throws C9721b {
        MonthPayReq monthPayReq = new MonthPayReq("cancelMonthPay");
        monthPayReq.setScheme(2);
        m61690q0(c11060c, monthPayReq);
        m61645N(monthPayReq, c11060c);
    }

    /* renamed from: f0 */
    public QueryPresentResp m61669f0(C11060c c11060c, String str) throws C9721b {
        QueryPresentReq queryPresentReq = new QueryPresentReq("queryPresent", str);
        m61690q0(c11060c, queryPresentReq);
        try {
            return (QueryPresentResp) m61687p(m61645N(queryPresentReq, c11060c), QueryPresentResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: g */
    public CreateFreeOrderResp m61670g(C11060c c11060c, String str, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) throws C9721b {
        C9720a.m60653b(str, "createFreeOrder id is null.");
        CreateFreeOrderReq createFreeOrderReq = new CreateFreeOrderReq(str, channelInfo, map, bigDecimal);
        createFreeOrderReq.setPrefission(C11280c.m67702i());
        m61690q0(c11060c, createFreeOrderReq);
        try {
            return (CreateFreeOrderResp) m61687p(m61645N(createFreeOrderReq, c11060c), CreateFreeOrderResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: g0 */
    public QuerySignStatusResp m61671g0(C11060c c11060c, String str, int i10, int i11, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map, BigDecimal bigDecimal) throws C9721b {
        C9720a.m60653b(str, "querySignStatus id is null.");
        QuerySignStatusReq querySignStatusReq = new QuerySignStatusReq(str, i10, "4.0", channelInfo, map, bigDecimal);
        querySignStatusReq.setPrefission(C11280c.m67702i());
        querySignStatusReq.setVoucherInfos(list);
        querySignStatusReq.setSupportVoucher(i11);
        m61690q0(c11060c, querySignStatusReq);
        try {
            return (QuerySignStatusResp) m61687p(m61645N(querySignStatusReq, c11060c), QuerySignStatusResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: h */
    public MonthOrder m61672h(String str, C11060c c11060c, Map<String, String> map) throws C9721b {
        C9720a.m60653b(str, "createMonthOrder id is null.");
        BuyPackageReq buyPackageReq = new BuyPackageReq(str, map);
        buyPackageReq.setCmd("createMonthOrder");
        buyPackageReq.setVersion("2.0");
        m61690q0(c11060c, buyPackageReq);
        try {
            return (MonthOrder) m61687p(m61645N(buyPackageReq, c11060c), MonthOrder.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: h0 */
    public QuerySubOrderStatusResp m61673h0(C11060c c11060c, String str) throws C9721b {
        C9720a.m60653b(str, "querySubOrderStatus id is null.");
        QuerySubOrderStatusReq querySubOrderStatusReq = new QuerySubOrderStatusReq(str);
        m61690q0(c11060c, querySubOrderStatusReq);
        try {
            return (QuerySubOrderStatusResp) m61687p(m61645N(querySubOrderStatusReq, c11060c), QuerySubOrderStatusResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: i */
    public CreateOrder m61674i(String str, C11060c c11060c, int i10, String str2, int i11, List<VoucherInfo> list, ChannelInfo channelInfo, Map<String, String> map) throws C9721b {
        C9720a.m60653b(str, "createOrder id is null.");
        ContinueBuyPackageReq continueBuyPackageReq = new ContinueBuyPackageReq(str, i10, str2, i11, list, channelInfo, map);
        continueBuyPackageReq.setPrefission(C11280c.m67702i());
        m61690q0(c11060c, continueBuyPackageReq);
        try {
            return (CreateOrder) m61687p(m61645N(continueBuyPackageReq, c11060c), CreateOrder.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: i0 */
    public List<TransactionItem> m61675i0(TrxReq trxReq, C11060c c11060c) throws C9721b {
        C9720a.m60657f(trxReq, "queryOrder request is invalid.");
        m61690q0(c11060c, trxReq);
        try {
            TrxResp trxResp = (TrxResp) m61687p(m61645N(trxReq, c11060c), TrxResp.class);
            List<TransactionItem> trxItems = trxResp.getTrxItems();
            String cursor = trxResp.getCursor();
            if (trxResp.getResultCode() == 0 && TextUtils.isEmpty(cursor)) {
                trxItems = new ArrayList<>();
            } else {
                C14302a.m85176d().m85184i(cursor);
            }
            if (trxItems != null) {
                return trxItems;
            }
            throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "queryTrxPage response is null.");
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: j */
    public final String m61676j(String str) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder(8);
        Random random = new Random();
        for (int i10 = 0; i10 < 15; i10++) {
            sb3.append(random.nextInt(10));
        }
        sb2.append(str);
        sb2.append(HiAnalyticsConstant.KeyAndValue.NUMBER_01);
        sb2.append(System.currentTimeMillis() / 1000);
        sb2.append((CharSequence) sb3);
        return sb2.toString();
    }

    /* renamed from: j0 */
    public ReceiveActivityGiftResq m61677j0(boolean z10, String str) throws C9721b {
        ReceiveActivityGiftReq.ExtendParams extendParams = new ReceiveActivityGiftReq.ExtendParams();
        extendParams.setUserType(!z10 ? 1 : 0);
        return (ReceiveActivityGiftResq) m61687p(m61647P(new ReceiveActivityGiftReq(extendParams, str), C11058a.m66626a(C11058a.m66627b("06027"), "updateNewBM", C13452e.m80781L().m80971t0()), C13452e.m80781L().m80877Y()), ReceiveActivityGiftResq.class);
    }

    /* renamed from: k */
    public EstimateResp m61678k(String str, int i10, C11060c c11060c, BigDecimal bigDecimal, Integer num, String str2) throws C9721b {
        C9720a.m60653b(str, "estimatePackage id is null.");
        EstimateReq estimateReq = new EstimateReq(str, i10, "4.0", bigDecimal, num, str2);
        m61690q0(c11060c, estimateReq);
        try {
            return (EstimateResp) m61687p(m61645N(estimateReq, c11060c), EstimateResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: k0 */
    public Response m61679k0(C11060c c11060c, List<AdAppsReportReq.AdAppInfo> list) throws C9721b {
        AdAppsReportReq adAppsReportReq = new AdAppsReportReq("reportAdApps", list, c11060c.m66661q());
        m61690q0(c11060c, adAppsReportReq);
        try {
            return (Response) m61687p(m61645N(adAppsReportReq, c11060c), Response.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: l */
    public EstimateResp m61680l(C11060c c11060c, Map<String, String> map) throws C9721b {
        EstimateReq estimateReq = new EstimateReq(map);
        m61690q0(c11060c, estimateReq);
        try {
            return (EstimateResp) m61687p(m61645N(estimateReq, c11060c), EstimateResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: l0 */
    public ReportCampaignResp m61681l0(Map<String, String> map, C11060c c11060c) throws C9721b {
        try {
            return (ReportCampaignResp) m61687p(m61645N(new ReportCampaignReq(map), c11060c), ReportCampaignResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: m */
    public FileterAdInfoRsp m61682m(List<RestoreAdAppInfo> list) throws C9721b {
        C1442a.m8290i("BusinessService", "enter filterAdInfo");
        C11060c c11060cM66626a = C11058a.m66626a(m61676j("07060"), "filterAdInfo", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u(String.valueOf(0));
        FileterAdInfoReq fileterAdInfoReq = new FileterAdInfoReq(c11060cM66626a.m66661q());
        fileterAdInfoReq.setAppInfoList(list);
        try {
            return (FileterAdInfoRsp) m61687p(m61645N(fileterAdInfoReq, c11060cM66626a), FileterAdInfoRsp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: m0 */
    public final void m61683m0(String str) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07045"), "07045", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        c11060cM66626a.m66635A(str);
        C13622a.m81968n(C0213f.m1377a(), c11060cM66626a);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("detail", str);
        C13227f.m79492i1().m79567R(NotifyConstants.CommonReportConstants.SRC_QUERY_AD_LIST, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", NotifyConstants.CommonReportConstants.SRC_QUERY_AD_LIST, linkedHashMapM79497A);
    }

    /* renamed from: n */
    public final String m61684n(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder(str);
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                sb2.append(" ");
                sb2.append(obj == null ? "" : obj.toString());
            }
        }
        return sb2.toString();
    }

    /* renamed from: o */
    public ForwardIMResp m61685o(String str, C11060c c11060c) throws C9721b {
        try {
            return (ForwardIMResp) m61687p(m61645N(new ForwardIMReq(str), c11060c), ForwardIMResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: o0 */
    public final void m61686o0() {
        C1442a.m8291w("BusinessService", "sendAuthFail business server auth failed.");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    /* renamed from: p */
    public final <T> T m61687p(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f48717a.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10);
        }
    }

    /* renamed from: p0 */
    public final String m61688p0(QueryAdListReq queryAdListReq) {
        String str;
        if (queryAdListReq.getDeviceInfo() == null || queryAdListReq.getAdSlot() == null) {
            C1442a.m8289e("BusinessService", "deviceInfo or adSlot is null");
            return "deviceInfo or adSlot is null";
        }
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C1442a.m8290i("BusinessService", "not china region");
            return "not china region";
        }
        if (C13452e.m80781L().m80795D0()) {
            C1442a.m8290i("BusinessService", "child account");
            return "child account";
        }
        if (!AdSwitchManager.getInstance().canDisplayAd(NotifyConstants.CommonReportConstants.SRC_QUERY_AD_LIST)) {
            String str2 = "settingAd: " + AdSwitchManager.getInstance().getSettingAdSwitch() + ", personalizationAd: " + AdSwitchManager.getInstance().getPersonalizationAdSwitch() + ", huaweiAd: " + AdSwitchManager.getInstance().getHuaweiAdSwitch();
            C1442a.m8290i("BusinessService", str2);
            return str2;
        }
        if (!C0211e.m1344c().m1347d()) {
            C1442a.m8290i("BusinessService", "all switch not open");
            return "all switch not open";
        }
        queryAdListReq.getAdSlot().setPersonalize(1);
        queryAdListReq.getDeviceInfo().setDeviceType(Integer.valueOf(C11842p.m70762R0() ? 4 : 0));
        String oaid = AdSwitchManager.getInstance().getOaid();
        if (TextUtils.isEmpty(oaid)) {
            str = "oaid null.";
        } else {
            queryAdListReq.getDeviceInfo().setOaid(oaid);
            str = "oaid get.";
        }
        C1442a.m8290i("BusinessService", str);
        if ("11".equals(C13452e.m80781L().m80970t())) {
            String strM80958q = C13452e.m80781L().m80958q();
            if (TextUtils.isEmpty(strM80958q)) {
                str = str + "imei vudid null";
            } else {
                str = str + "imei vudid get";
                queryAdListReq.getDeviceInfo().setVudid(strM80958q);
            }
            C1442a.m8290i("BusinessService", str);
        }
        return str;
    }

    /* renamed from: q */
    public GetActivityEntryResp m61689q(UserTags userTags, int i10, C11060c c11060c) throws C9721b {
        return m61691r(userTags, i10, c11060c, true);
    }

    /* renamed from: q0 */
    public final void m61690q0(C11060c c11060c, Request request) throws C9721b {
        C9720a.m60657f(c11060c, "stat is null.");
        C9720a.m60657f(request, "request is null.");
        C9720a.m60653b(c11060c.m66661q(), "x-hw-trace-id is null.");
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C9720a.m60653b(strM80971t0, "userid is null.");
        c11060c.m66644J(strM80971t0);
        c11060c.m66664t(request.getCmd());
    }

    /* renamed from: r */
    public GetActivityEntryResp m61691r(UserTags userTags, int i10, C11060c c11060c, boolean z10) throws C9721b {
        try {
            String strM61645N = m61645N(new GetActivityEntryReq(userTags, i10), c11060c);
            GetActivityEntryResp getActivityEntryResp = (GetActivityEntryResp) m61687p(strM61645N, GetActivityEntryResp.class);
            if (getActivityEntryResp != null && z10) {
                ActivityEntry entry = getActivityEntryResp.getEntry();
                entry.setUrl(NoticeWithActivityUtil.addLanguageType(entry.getUrl()));
            }
            C1442a.m8288d("BusinessService", "getActivityEntry:" + getActivityEntryResp.toString());
            C11282e.m67709b(C0213f.m1377a()).m67716h("get_activity_entry_cache_key_" + i10, strM61645N);
            return getActivityEntryResp;
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        } catch (C9721b e11) {
            String strM67711c = C11282e.m67709b(C0213f.m1377a()).m67711c("get_activity_entry_cache_key_" + i10);
            if (TextUtils.isEmpty(strM67711c) || e11.m60659c() == 110) {
                throw e11;
            }
            C1442a.m8289e("BusinessService", "getActivityEntry fail, use cache.");
            try {
                return (GetActivityEntryResp) new Gson().fromJson(strM67711c, GetActivityEntryResp.class);
            } catch (JsonSyntaxException unused) {
                throw new C9721b(1, "json err " + e11.toString());
            }
        }
    }

    /* renamed from: r0 */
    public SignPurchaseResp m61692r0(C11060c c11060c, String str, ChannelInfo channelInfo, Map<String, String> map, List<VoucherInfo> list, String str2, int i10, BigDecimal bigDecimal) throws C9721b {
        SignPurchaseReq signPurchaseReq = new SignPurchaseReq("signPurchase", str, channelInfo, map, list, str2, i10, bigDecimal, C11296s.m67834r());
        signPurchaseReq.setPrefission(C11280c.m67702i());
        m61690q0(c11060c, signPurchaseReq);
        try {
            JsonObject jsonObject = new JsonObject();
            if (signPurchaseReq.getChannel() != null) {
                JsonObject jsonObject2 = new JsonObject();
                ChannelInfo channel = signPurchaseReq.getChannel();
                jsonObject2.addProperty("srcChannel", channel.getSrcChannel());
                jsonObject2.addProperty("activityCode", channel.getActivityCode());
                jsonObject2.addProperty(FaqConstants.FAQ_MODEL, Build.MODEL);
                jsonObject.addProperty("x-hw-extend-fields", jsonObject2.toString());
            }
            return (SignPurchaseResp) m61687p(m61647P(signPurchaseReq, c11060c, jsonObject.toString()), SignPurchaseResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: s */
    public GetAllVouchersResp m61693s(C11060c c11060c, String str, String str2, String str3, String str4) throws C9721b {
        GetAllVouchersReq getAllVouchersReq = new GetAllVouchersReq("getAllVouchers", str, str2, str3, str4);
        if (!C11296s.m67798V()) {
            getAllVouchersReq.setClientVer("2");
            getAllVouchersReq.setFeatures("");
        }
        m61690q0(c11060c, getAllVouchersReq);
        try {
            return (GetAllVouchersResp) m61687p(m61645N(getAllVouchersReq, c11060c), GetAllVouchersResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: s0 */
    public final boolean m61694s0(C9721b c9721b) {
        return c9721b.m60659c() == 9002 || c9721b.m60659c() == 9005 || c9721b.m60659c() == 9003 || c9721b.m60659c() == 9001 || c9721b.m60659c() == 9100;
    }

    /* renamed from: t */
    public GetAvaVouchersResp m61695t(C11060c c11060c, List<String> list, List<String> list2) throws C9721b {
        GetAvaVouchersReq getAvaVouchersReq = new GetAvaVouchersReq("getAvaVouchers", list, list2);
        m61690q0(c11060c, getAvaVouchersReq);
        try {
            return (GetAvaVouchersResp) m61687p(m61645N(getAvaVouchersReq, c11060c), GetAvaVouchersResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: t0 */
    public boolean m61696t0() {
        UpdateUserBMInfoResp updateUserBMInfoRespM61698u0;
        boolean zM80892b1 = C13452e.m80781L().m80892b1();
        C1442a.m8290i("BusinessService", "newUser:" + zM80892b1);
        String strM80790C = C13452e.m80781L().m80790C();
        if (!zM80892b1 || ((!TextUtils.isEmpty(strM80790C) && strM80790C.length() >= 2) || C10155f.m63295s())) {
            C1442a.m8290i("BusinessService", "No switchover required");
            m61632n0(0);
            return false;
        }
        boolean zM60720O = C9733f.m60705z().m60720O("bmEnabled");
        C1442a.m8290i("BusinessService", "bmEnabled:" + zM60720O);
        if (!zM60720O) {
            m61632n0(0);
            return false;
        }
        try {
            updateUserBMInfoRespM61698u0 = m61698u0(C11058a.m66626a(C11058a.m66627b("06025"), "updateNewBM", C13452e.m80781L().m80971t0()), zM80892b1, false);
        } catch (C9721b e10) {
            C1442a.m8289e("BusinessService", "updateUserBMInfo error" + e10.toString());
            updateUserBMInfoRespM61698u0 = null;
        }
        if (updateUserBMInfoRespM61698u0 != null && updateUserBMInfoRespM61698u0.getGradeInfo() != null) {
            C13452e.m80781L().m80965r2(true);
            C13452e.m80781L().m80940l1(updateUserBMInfoRespM61698u0.getGradeInfo().getGradeCode());
            C13452e.m80781L().m80985w2(true);
            m61632n0(2);
            return true;
        }
        C1442a.m8291w("BusinessService", "updateUserBMInfo resp is null:" + updateUserBMInfoRespM61698u0);
        m61632n0(1);
        return false;
    }

    /* renamed from: u */
    public GetAvailableGradePackagesResp m61697u(C11060c c11060c, Filter filter, String str, ChannelInfo channelInfo) throws C9721b {
        GetAvailableGradePackagesReq getAvailableGradePackagesReq = new GetAvailableGradePackagesReq("getAvailableGradePackages", filter, str, channelInfo, String.valueOf(C11296s.m67834r()));
        if (!C11296s.m67798V()) {
            getAvailableGradePackagesReq.setClientVer("2");
            getAvailableGradePackagesReq.setFeatures("");
        }
        m61690q0(c11060c, getAvailableGradePackagesReq);
        try {
            return (GetAvailableGradePackagesResp) m61687p(m61645N(getAvailableGradePackagesReq, c11060c), GetAvailableGradePackagesResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: u0 */
    public UpdateUserBMInfoResp m61698u0(C11060c c11060c, boolean z10, boolean z11) throws C9721b {
        try {
            return (UpdateUserBMInfoResp) m61687p(m61647P(new UpdateUserBMInfoReq(z10, z11), c11060c, C13452e.m80781L().m80877Y()), UpdateUserBMInfoResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: v */
    public GetAvailableGradePackagesResp m61699v(C11060c c11060c, Filter filter, String str, ChannelInfo channelInfo, long j10) throws C9721b {
        GetAvailableGradePackagesReq getAvailableGradePackagesReq = new GetAvailableGradePackagesReq("getAvailableGradePackages", filter, str, channelInfo, String.valueOf(C11296s.m67834r()));
        getAvailableGradePackagesReq.setSpaceNeeded(j10);
        if (!C11296s.m67798V()) {
            getAvailableGradePackagesReq.setClientVer("2");
            getAvailableGradePackagesReq.setFeatures("");
        }
        m61690q0(c11060c, getAvailableGradePackagesReq);
        try {
            return (GetAvailableGradePackagesResp) m61687p(m61645N(getAvailableGradePackagesReq, c11060c), GetAvailableGradePackagesResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: w */
    public final String m61700w(String str) throws C9721b {
        return m61701x(str, null);
    }

    /* renamed from: x */
    public final String m61701x(String str, String str2) throws C9721b {
        String str3 = C13040c.m78609F().m78664q() + m61642K(str);
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        return str3 + str2;
    }

    /* renamed from: y */
    public CardPackageResp m61702y(String str, C11060c c11060c) throws C9721b {
        C9720a.m60653b(str, "innerNo is invalid.");
        CardPackageReq cardPackageReq = new CardPackageReq(str, "4.0");
        m61690q0(c11060c, cardPackageReq);
        try {
            return (CardPackageResp) m61687p(m61645N(cardPackageReq, c11060c), CardPackageResp.class);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        }
    }

    /* renamed from: z */
    public GetClientUIConfigResp m61703z(C11060c c11060c) throws C9721b {
        UIConfigReq uIConfigReq = new UIConfigReq("3.0", C11296s.m67821j(), "0");
        m61690q0(c11060c, uIConfigReq);
        try {
            Map<String, String> map = (Map) f48717a.fromJson(new JSONObject(m61645N(uIConfigReq, c11060c)).getJSONObject("uiConfigMap").toString(), new c(null).getType());
            GetClientUIConfigResp getClientUIConfigResp = new GetClientUIConfigResp();
            getClientUIConfigResp.setClientUIMap(map);
            return getClientUIConfigResp;
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1, "json err " + e10.toString());
        } catch (JSONException e11) {
            throw new C9721b(1, "json err " + e11.toString());
        }
    }
}
