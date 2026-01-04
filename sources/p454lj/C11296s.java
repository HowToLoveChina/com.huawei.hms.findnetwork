package p454lj;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import cn.C1461a;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.android.hicloud.bean.aop.AopInfo;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.MemGradeRight;
import com.huawei.cloud.pay.model.MemGradeRights;
import com.huawei.cloud.pay.model.OnePackegeVouchers;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.PayTypePolicy;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.VoucherInfo;
import com.huawei.cloud.pay.model.VoucherItemData;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fj.C9719h;
import fk.C9720a;
import fk.C9721b;
import hu.C10344c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0213f;
import p015ak.C0226l0;
import p037bp.C1270a;
import p054cj.C1442a;
import p232dp.InterfaceC9283b;
import p292fn.C9733f;
import p384j4.AbstractC10707f;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11296s;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13222a;
import p684un.C13227f;
import p709vj.C13452e;
import p746wn.C13622a;
import p778xk.C13823d;
import p815ym.AbstractC14026a;
import p845zi.C14302a;

/* renamed from: lj.s */
/* loaded from: classes5.dex */
public class C11296s {

    /* renamed from: a */
    public static final String f52947a = "s";

    /* renamed from: b */
    public static boolean f52948b = false;

    /* renamed from: lj.s$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f52949a;

        public a(Context context) {
            this.f52949a = context;
        }

        /* renamed from: d */
        public static /* synthetic */ void m67844d(Context context) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.hicloud.intent.action.ACTION_SPACE_ENOUGH");
            C13108a.m78878b(context).m78881d(intent);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
            if (interfaceC9283b == null || !interfaceC9283b.mo58532w()) {
                return;
            }
            final Context context = this.f52949a;
            C0226l0.m1584d(new Runnable() { // from class: lj.r
                @Override // java.lang.Runnable
                public final void run() {
                    C11296s.a.m67844d(context);
                }
            });
        }
    }

    /* renamed from: lj.s$b */
    public class b extends TypeToken<List<String>> {
    }

    /* renamed from: lj.s$c */
    public class c extends TypeToken<List<PayTypePolicy>> {
    }

    /* renamed from: A */
    public static String m67777A(String str, String str2, String str3) {
        String str4 = f52947a;
        C1442a.m8290i(str4, "getSupportPayment: mSrcChannel = " + str2 + " , mSalChannel = " + str3 + " , packageId = " + str);
        String strM60708C = C9733f.m60705z().m60708C();
        if (AbstractC10707f.m65379d(strM60708C)) {
            C1442a.m8291w(str4, "getSupportPayment payTypePolicy is blank!");
            return "";
        }
        try {
            List<PayTypePolicy> list = (List) new Gson().fromJson(strM60708C, new c().getType());
            if (AbstractC14026a.m84159a(list)) {
                C1442a.m8291w(str4, "getSupportPayment payTypePolicyList is empty!");
                return "";
            }
            Collections.sort(list, new Comparator() { // from class: lj.q
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C11296s.m67799W((PayTypePolicy) obj, (PayTypePolicy) obj2);
                }
            });
            for (PayTypePolicy payTypePolicy : list) {
                if (TextUtils.equals(str, payTypePolicy.getPackageId()) && m67802Z(str3, payTypePolicy.getSalChannel()) && m67802Z(str2, payTypePolicy.getSrcChannel())) {
                    return payTypePolicy.getPayment();
                }
            }
            return "";
        } catch (JsonSyntaxException e10) {
            C1442a.m8289e(f52947a, "getSupportPayment json exception: " + e10.getMessage());
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x002b  */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.math.BigDecimal m67778B(com.huawei.cloud.pay.model.CloudPackage r2, java.util.List<com.huawei.cloud.pay.model.Voucher> r3, java.math.BigDecimal r4, java.math.BigDecimal r5) {
        /*
            java.math.BigDecimal r0 = m67838v(r2)
            int r1 = r2.getProductType()
            boolean r1 = m67785I(r4, r1)
            if (r1 != 0) goto Lf
            goto L2b
        Lf:
            boolean r1 = m67788L(r0)
            if (r1 != 0) goto L16
            goto L2b
        L16:
            boolean r1 = m67788L(r5)
            if (r1 != 0) goto L25
            boolean r2 = m67788L(r4)
            if (r2 != 0) goto L46
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            goto L46
        L25:
            boolean r1 = m67788L(r4)
            if (r1 != 0) goto L2d
        L2b:
            r4 = r5
            goto L46
        L2d:
            boolean r1 = m67791O(r3)
            if (r1 == 0) goto L34
            goto L46
        L34:
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.huawei.cloud.pay.model.Voucher r1 = (com.huawei.cloud.pay.model.Voucher) r1
            if (r1 != 0) goto L3e
            goto L46
        L3e:
            java.math.BigDecimal r2 = m67832p(r2, r3, r4)
            java.math.BigDecimal r4 = r5.add(r2)
        L46:
            if (r4 != 0) goto L4b
            java.math.BigDecimal r2 = java.math.BigDecimal.ZERO
            return r2
        L4b:
            int r2 = r4.compareTo(r0)
            r3 = 1
            if (r2 != r3) goto L53
            return r0
        L53:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p454lj.C11296s.m67778B(com.huawei.cloud.pay.model.CloudPackage, java.util.List, java.math.BigDecimal, java.math.BigDecimal):java.math.BigDecimal");
    }

    /* renamed from: C */
    public static List<VoucherInfo> m67779C(CloudPackage cloudPackage, List<Voucher> list, BigDecimal bigDecimal) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            if (list.size() != 1) {
                BigDecimal spPrice = (cloudPackage.getProductType() == 7 || cloudPackage.getProductType() == 8) ? cloudPackage.getSpPrice() : cloudPackage.getPrice();
                Iterator<Voucher> it = list.iterator();
                int i10 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Voucher next = it.next();
                    if (spPrice.compareTo(next.getBalance()) <= 0) {
                        VoucherInfo voucherInfo = new VoucherInfo();
                        voucherInfo.setVoucherCode(list.get(i10).getVoucherCode());
                        voucherInfo.setDiscountAmt(spPrice);
                        voucherInfo.setFeeMode(list.get(0).getFeeMode());
                        arrayList.add(voucherInfo);
                        break;
                    }
                    VoucherInfo voucherInfo2 = new VoucherInfo();
                    voucherInfo2.setVoucherCode(list.get(i10).getVoucherCode());
                    voucherInfo2.setDiscountAmt(m67823k(cloudPackage, list.get(i10), bigDecimal));
                    voucherInfo2.setFeeMode(list.get(0).getFeeMode());
                    arrayList.add(voucherInfo2);
                    spPrice = spPrice.subtract(next.getBalance());
                    i10++;
                }
            } else {
                VoucherInfo voucherInfo3 = new VoucherInfo();
                Voucher voucher = list.get(0);
                voucherInfo3.setVoucherCode(voucher.getVoucherCode());
                voucherInfo3.setDiscountAmt(m67823k(cloudPackage, voucher, bigDecimal));
                voucherInfo3.setFeeMode(list.get(0).getFeeMode());
                arrayList.add(voucherInfo3);
                return arrayList;
            }
        }
        return arrayList;
    }

    /* renamed from: D */
    public static BigDecimal m67780D(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str) {
        return str.equals("C") ? bigDecimal.multiply(bigDecimal2).setScale(0, 2) : str.equals("F") ? bigDecimal.multiply(bigDecimal2).setScale(0, 3) : bigDecimal.multiply(bigDecimal2).setScale(0, 4);
    }

    /* renamed from: E */
    public static void m67781E(Context context, View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                if (C11842p.m70771U0()) {
                    m67830n0(context, view);
                } else if (C11842p.m70747M0(context)) {
                    m67822j0(context, view);
                } else {
                    m67828m0(context, view);
                }
            }
        }
    }

    /* renamed from: F */
    public static void m67782F(List<VoucherItemData> list, List<Voucher> list2, List<Voucher> list3) {
        for (Voucher voucher : list2) {
            VoucherItemData voucherItemData = new VoucherItemData();
            voucherItemData.setItemType(2);
            voucherItemData.setVoucher(voucher);
            m67826l0(voucherItemData, voucher, list3);
            list.add(voucherItemData);
        }
    }

    /* renamed from: G */
    public static void m67783G(List<VoucherItemData> list, List<Voucher> list2, List<Voucher> list3) {
        for (Voucher voucher : list2) {
            VoucherItemData voucherItemData = new VoucherItemData();
            voucherItemData.setItemType(1);
            voucherItemData.setVoucher(voucher);
            m67826l0(voucherItemData, voucher, list3);
            list.add(voucherItemData);
        }
    }

    /* renamed from: H */
    public static void m67784H(List<VoucherItemData> list, String str) {
        VoucherItemData voucherItemData = new VoucherItemData();
        voucherItemData.setItemType(0);
        voucherItemData.setTitle(str);
        voucherItemData.setSelected(false);
        list.add(voucherItemData);
    }

    /* renamed from: I */
    public static boolean m67785I(BigDecimal bigDecimal, int i10) {
        return bigDecimal != null && m67797U() && BigDecimal.ZERO.compareTo(bigDecimal) != 0 && m67792P(i10);
    }

    /* renamed from: J */
    public static boolean m67786J(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (RuntimeException unused) {
            C1442a.m8289e(f52947a, "isConnect(final Context context)");
        } catch (Exception unused2) {
            C1442a.m8289e(f52947a, "isConnect(final Context context)");
        }
        return false;
    }

    /* renamed from: K */
    public static boolean m67787K() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        return hiCloudSysParamMapM60757p != null && hiCloudSysParamMapM60757p.getEnableVoucher() == 1;
    }

    /* renamed from: L */
    public static boolean m67788L(BigDecimal bigDecimal) {
        return bigDecimal != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0;
    }

    /* renamed from: M */
    public static boolean m67789M(Context context) {
        String strM79270H;
        if (context == null) {
            C1442a.m8289e(f52947a, "isIAPSupportVoucher context is null.");
            return false;
        }
        try {
            strM79270H = C13195l.m79270H(context);
        } catch (Exception e10) {
            C1442a.m8289e(f52947a, "isIAPSupportVoucher err : " + e10.toString());
        }
        if (TextUtils.isEmpty(strM79270H)) {
            C11839m.m70687e(f52947a, "hmsPackage is invalid!");
            return false;
        }
        String str = context.getPackageManager().getPackageInfo(strM79270H, 16384).versionName;
        return !TextUtils.isEmpty(str) && str.compareTo("5.0.1.100") >= 0;
    }

    /* renamed from: N */
    public static boolean m67790N() {
        return f52948b;
    }

    /* renamed from: O */
    public static boolean m67791O(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: P */
    public static boolean m67792P(int i10) {
        return i10 == 6 || i10 == 8;
    }

    /* renamed from: Q */
    public static boolean m67793Q(List<Voucher> list, CloudPackage cloudPackage) {
        if (cloudPackage == null) {
            C1442a.m8289e(f52947a, "isParameterVaild getPackageVouchers currentSelectedPackage is null.");
            return false;
        }
        if (list != null && !list.isEmpty()) {
            return true;
        }
        C1442a.m8289e(f52947a, "isParameterVaild getPackageVouchers voucherList is null.");
        return false;
    }

    /* renamed from: R */
    public static boolean m67794R(List<Voucher> list, RecommendVouchers recommendVouchers) {
        List<Voucher> voucherList;
        if (list == null || list.isEmpty() || recommendVouchers == null || (voucherList = recommendVouchers.getVoucherList()) == null || list.size() != voucherList.size()) {
            return false;
        }
        Iterator<Voucher> it = list.iterator();
        while (it.hasNext()) {
            String voucherCode = it.next().getVoucherCode();
            int size = voucherList.size();
            int i10 = 0;
            while (i10 < size) {
                Voucher voucher = voucherList.get(i10);
                if (voucher != null) {
                    if (voucherCode.equals(voucher.getVoucherCode())) {
                        i10 = size;
                    } else if (i10 == size - 1) {
                        return false;
                    }
                }
                i10++;
            }
        }
        return true;
    }

    /* renamed from: S */
    public static boolean m67795S() {
        String strM80942m = C13452e.m80781L().m80942m();
        String strM80921h0 = C13452e.m80781L().m80921h0();
        if (!TextUtils.isEmpty(strM80942m) && !TextUtils.isEmpty(strM80921h0)) {
            return !strM80942m.equals(strM80921h0);
        }
        C1442a.m8289e(f52947a, "registerCountryCode or serviceCountryCode is null.");
        return false;
    }

    /* renamed from: T */
    public static boolean m67796T() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        return hiCloudSysParamMapM60757p != null && hiCloudSysParamMapM60757p.getBusinessShowCardEntry() == 1;
    }

    /* renamed from: U */
    public static boolean m67797U() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        return hiCloudSysParamMapM60757p != null && hiCloudSysParamMapM60757p.getBusinessSupportDeduct() == 1;
    }

    /* renamed from: V */
    public static boolean m67798V() throws JSONException {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null && hiCloudSysParamMapM60757p.getIap4Enabled() == 1) {
            String hmsVerBlockList = hiCloudSysParamMapM60757p.getHmsVerBlockList();
            if (TextUtils.isEmpty(hmsVerBlockList)) {
                return true;
            }
            try {
                JSONArray jSONArray = new JSONArray(hmsVerBlockList);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    String string = jSONArray.getString(i10);
                    if (TextUtils.isEmpty(string)) {
                        break;
                    }
                    if (string.split("~").length < 2) {
                        return false;
                    }
                    long jM67834r = m67834r();
                    if (jM67834r == -1) {
                        C1442a.m8289e(f52947a, "isSupportIap4 get hms version code err.");
                        return false;
                    }
                    if (jM67834r >= Integer.parseInt(r4[0]) && jM67834r <= Integer.parseInt(r4[1])) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e10) {
                C11839m.m70687e(f52947a, "isSupportIap4 catch exception: " + e10.toString());
            }
        }
        return false;
    }

    /* renamed from: W */
    public static /* synthetic */ int m67799W(PayTypePolicy payTypePolicy, PayTypePolicy payTypePolicy2) {
        return payTypePolicy2.getIndex() > payTypePolicy.getIndex() ? 1 : 0;
    }

    @SuppressLint({"StringFormatInvalid"})
    /* renamed from: X */
    public static List<VoucherItemData> m67800X(OnePackegeVouchers onePackegeVouchers, List<Voucher> list, Context context) {
        ArrayList arrayList = new ArrayList();
        if (onePackegeVouchers == null) {
            return arrayList;
        }
        List<Voucher> commonVoucherList = onePackegeVouchers.getCommonVoucherList();
        List<Voucher> singleChoiceVoucherList = onePackegeVouchers.getSingleChoiceVoucherList();
        if (!commonVoucherList.isEmpty() && !singleChoiceVoucherList.isEmpty()) {
            if (context != null) {
                m67784H(arrayList, context.getString(R$string.cloudpay_voucher_single_choice, 1));
            }
            m67783G(arrayList, onePackegeVouchers.getSingleChoiceVoucherList(), list);
            if (context != null) {
                m67784H(arrayList, context.getString(R$string.cloudpay_voucher_multiple_choice));
            }
            m67782F(arrayList, onePackegeVouchers.getCommonVoucherList(), list);
        } else if (!commonVoucherList.isEmpty()) {
            m67782F(arrayList, onePackegeVouchers.getCommonVoucherList(), list);
        } else if (!singleChoiceVoucherList.isEmpty()) {
            m67783G(arrayList, onePackegeVouchers.getSingleChoiceVoucherList(), list);
        }
        return arrayList;
    }

    /* renamed from: Y */
    public static String m67801Y(List<Voucher> list) {
        String str = "";
        if (list == null) {
            return "";
        }
        boolean z10 = true;
        for (Voucher voucher : list) {
            if (voucher != null) {
                String voucherId = voucher.getVoucherId();
                if (!TextUtils.isEmpty(voucherId)) {
                    if (z10) {
                        z10 = false;
                        str = voucherId;
                    } else {
                        str = str + "/" + voucherId;
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: Z */
    public static boolean m67802Z(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return TextUtils.equals(str2, str);
    }

    /* renamed from: a0 */
    public static void m67804a0(Context context) {
        if (context == null) {
            C1442a.m8289e(f52947a, "onLogout ctx null");
            return;
        }
        C14302a.m85176d().m85178b();
        C11282e.m67709b(context).m67710a();
        C9719h.m60646d().m60650c();
        C9719h.m60647e();
    }

    /* renamed from: b */
    public static String m67805b(JsonObject jsonObject, String str, String str2, String str3) throws JSONException {
        String string = jsonObject == null ? new JSONObject().toString() : new Gson().toJson((JsonElement) jsonObject);
        String strM67777A = m67777A(str, str2, str3);
        C1442a.m8290i(f52947a, "appendSupportPayment supportPayment ：" + strM67777A);
        if (TextUtils.isEmpty(strM67777A)) {
            return string;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("IncludePayment", strM67777A);
            jSONObject.put("PayTypePolicy", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e10) {
            C1442a.m8289e(f52947a, "appendSupportPayment e :" + e10.toString());
            return string;
        }
    }

    /* renamed from: b0 */
    public static void m67806b0(String str, LinkedHashMap<String, String> linkedHashMap, String str2) {
        C13227f.m79492i1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "1", "31", linkedHashMap);
        m67810d0(str, linkedHashMap, str2);
    }

    /* renamed from: c */
    public static void m67807c(String str, LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("is_aop_pay", FaqConstants.DISABLE_HA_REPORT);
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e(f52947a, "buildAopInfo str is empty");
            return;
        }
        try {
            AopInfo aopInfo = (AopInfo) new Gson().fromJson(str, AopInfo.class);
            linkedHashMap.put("campaignId", aopInfo.getCampaignId());
            linkedHashMap.put("purchaseScene", aopInfo.getPurchaseScene());
        } catch (Exception e10) {
            C1442a.m8289e(f52947a, "buildAopInfo err: " + e10.getMessage());
        }
    }

    /* renamed from: c0 */
    public static void m67808c0(MemGradeRights memGradeRights) {
        if (memGradeRights == null) {
            C1442a.m8291w(f52947a, "refreshMemGradeRightListCache, rights is null");
            return;
        }
        List<MemGradeRight> rights = memGradeRights.getRights();
        if (rights == null) {
            C1442a.m8291w(f52947a, "refreshMemGradeRightListCache, rightList is null");
            return;
        }
        boolean z10 = false;
        if (rights.isEmpty()) {
            C1442a.m8291w(f52947a, "refreshMemGradeRightListCache, rightList is empty, start clear sp");
            C13452e.m80781L().m80944m1("");
            C13452e.m80781L().m80827L1(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MemGradeRight memGradeRight : rights) {
            if (memGradeRight != null && memGradeRight.getStatus() == 1) {
                arrayList.add(memGradeRight.getRightCode());
                if ("WL".equalsIgnoreCase(memGradeRight.getRightCode())) {
                    C11839m.m70688i(f52947a, "contain WL.");
                    z10 = true;
                }
            }
        }
        C13452e.m80781L().m80827L1(z10);
        try {
            C13452e.m80781L().m80944m1(new Gson().toJson(arrayList));
        } catch (Exception e10) {
            C1442a.m8289e(f52947a, "refreshMemGradeRightListCache, toJson error: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static BigDecimal m67809d(CloudPackage cloudPackage, Voucher voucher, BigDecimal bigDecimal) {
        BigDecimal bigDecimalM67838v = m67838v(cloudPackage);
        if (m67785I(bigDecimal, cloudPackage.getProductType())) {
            bigDecimalM67838v = bigDecimalM67838v.subtract(bigDecimal);
        }
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        if (bigDecimalM67838v.compareTo(bigDecimal2) == -1) {
            bigDecimalM67838v = bigDecimal2;
        }
        return m67811e(bigDecimalM67838v, voucher);
    }

    /* renamed from: d0 */
    public static void m67810d0(String str, LinkedHashMap<String, String> linkedHashMap, String str2) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b(str2), str2, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMap);
    }

    /* renamed from: e */
    public static BigDecimal m67811e(BigDecimal bigDecimal, Voucher voucher) {
        String roundMode = voucher.getRoundMode();
        String roundPrecision = voucher.getRoundPrecision();
        BigDecimal bigDecimalSubtract = new BigDecimal(1).subtract(new BigDecimal(voucher.getDiscount()));
        C11839m.m70686d(f52947a, "discount:" + bigDecimalSubtract);
        BigDecimal bigDecimal2 = new BigDecimal(0);
        if (roundPrecision.equals("0.01")) {
            bigDecimal2 = m67825l(bigDecimal, bigDecimalSubtract, roundMode);
        } else if (roundPrecision.equals("1")) {
            bigDecimal2 = m67780D(bigDecimal, bigDecimalSubtract, roundMode);
        } else if (roundPrecision.equals("1000")) {
            bigDecimal2 = m67835s(bigDecimal, bigDecimalSubtract, roundMode);
        }
        return bigDecimal2.compareTo(bigDecimal) >= 0 ? new BigDecimal(0) : bigDecimal2;
    }

    /* renamed from: e0 */
    public static void m67812e0(Context context) {
        C1442a.m8290i(f52947a, "sendAcceptGiftSuccessBroadCast");
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.intent.action.accept.gift.success");
        C13108a.m78878b(context).m78881d(intent);
    }

    /* renamed from: f */
    public static void m67813f(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.cancel(265);
        notificationManager.cancel(273);
        notificationManager.cancel(288);
        notificationManager.cancel(775);
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        if (activeNotifications.length == 1 && activeNotifications[0].getId() == 22) {
            notificationManager.cancel(22);
        }
    }

    /* renamed from: f0 */
    public static void m67814f0(Context context) {
        C12515a.m75110o().m75172d(new a(context));
    }

    /* renamed from: g */
    public static boolean m67815g(ActivityEntry activityEntry) {
        String str = f52947a;
        C11839m.m70688i(str, "checkIsUrlSupportFrontApp start");
        if (activityEntry == null) {
            C11839m.m70687e(str, "checkIsUrlSupportFrontApp error, activityEntry response is null");
            return false;
        }
        String url = activityEntry.getUrl();
        if (TextUtils.isEmpty(url)) {
            C11839m.m70688i(str, "checkIsUrlSupportFrontApp error, url is null");
            return false;
        }
        String strM63704b = C10344c.m63704b(Uri.parse(url), "supportPreApp");
        C11839m.m70688i(str, "checkIsUrlSupportFrontApp: " + strM63704b);
        return TextUtils.equals(strM63704b, "1");
    }

    /* renamed from: g0 */
    public static void m67816g0(Context context) {
        String str = f52947a;
        C1442a.m8290i(str, "sendBroadcastRefreshCloudspace");
        if (context == null) {
            C1442a.m8289e(str, "sendBroadcastRefreshCloudspace context is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.cloud.pay.action.updatespace");
        C13108a.m78878b(context).m78881d(intent);
        m67820i0(context);
    }

    /* renamed from: h */
    public static void m67817h(Context context, String str, String str2, String str3, String str4) {
        C13222a.m79460b(context, str, str2, str3, str4);
    }

    /* renamed from: h0 */
    public static void m67818h0(Context context, MemGradeRights memGradeRights, int i10) {
        String str = f52947a;
        C1442a.m8290i(str, "sendPaySuccessBroadcast");
        if (context == null) {
            C1442a.m8289e(str, "sendPaySuccessBroadcast err, context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS");
        Bundle bundle = new Bundle();
        bundle.putInt("pay_success_chosen_backup_frequency", i10);
        if (memGradeRights != null) {
            String gradeCode = memGradeRights.getGradeCode();
            if (!TextUtils.isEmpty(gradeCode)) {
                C13452e.m80781L().m80940l1(gradeCode);
            }
            bundle.putString("pay_success_current_grade_code", gradeCode);
            m67814f0(context);
        }
        intent.putExtra("pay_success_backup_freq_bundle_key", bundle);
        C13108a.m78878b(context).m78881d(intent);
        C13823d.m82901N();
    }

    /* renamed from: i */
    public static RecommendVouchers m67819i(List<Voucher> list, CloudPackage cloudPackage) {
        BigDecimal bigDecimalM67838v = m67838v(cloudPackage);
        RecommendVouchers recommendVouchers = new RecommendVouchers();
        recommendVouchers.setVoucherType("0");
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            BigDecimal bigDecimal = new BigDecimal(0);
            for (Voucher voucher : list) {
                if (arrayList.size() == 10) {
                    return recommendVouchers;
                }
                bigDecimal = bigDecimal.add(voucher.getBalance());
                arrayList.add(voucher);
                if (bigDecimal.compareTo(bigDecimalM67838v) >= 0) {
                    recommendVouchers.setDiscountAmount(bigDecimalM67838v);
                    recommendVouchers.setVoucherList(arrayList);
                    return recommendVouchers;
                }
                recommendVouchers.setDiscountAmount(bigDecimal);
                recommendVouchers.setVoucherList(arrayList);
            }
        }
        return recommendVouchers;
    }

    /* renamed from: i0 */
    public static void m67820i0(Context context) {
        String str = f52947a;
        C1442a.m8290i(str, "send refreshSpace filemanager");
        if (context == null) {
            C1442a.m8289e(str, "send refreshSpace filemanager context is null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.cloud.pay.action.updatespace");
            intent.setPackage(NextRestoreConstants.PKG_NAME_FILE_MANAGER);
            context.sendBroadcast(intent, "com.huawei.cloud.permission.cloudupdate");
        } catch (Exception e10) {
            C1442a.m8289e(f52947a, "exception is: " + e10.getMessage());
        }
    }

    /* renamed from: j */
    public static String m67821j() throws C9721b {
        String strM80921h0 = C13452e.m80781L().m80921h0();
        C9720a.m60653b(strM80921h0, "country code is null.");
        return strM80921h0;
    }

    /* renamed from: j0 */
    public static void m67822j0(Context context, View view) {
        if (C11842p.m70753O0(context)) {
            C11842p.m70879w2(context, 540, view);
        } else {
            C11842p.m70879w2(context, 472, view);
        }
    }

    /* renamed from: k */
    public static BigDecimal m67823k(CloudPackage cloudPackage, Voucher voucher, BigDecimal bigDecimal) {
        BigDecimal spPrice;
        if (voucher == null) {
            return new BigDecimal(0);
        }
        spPrice = (cloudPackage.getProductType() == 7 || cloudPackage.getProductType() == 8) ? cloudPackage.getSpPrice() : cloudPackage.getPrice();
        String feeMode = voucher.getFeeMode();
        feeMode.hashCode();
        switch (feeMode) {
            case "0":
                if (spPrice.compareTo(voucher.getBalance()) > 0) {
                    break;
                }
                break;
            case "1":
                if (spPrice.compareTo(voucher.getMinFee()) >= 0) {
                    break;
                } else {
                    break;
                }
        }
        return new BigDecimal(0);
    }

    /* renamed from: k0 */
    public static void m67824k0(boolean z10) {
        f52948b = z10;
    }

    /* renamed from: l */
    public static BigDecimal m67825l(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str) {
        return str.equals("C") ? bigDecimal.multiply(bigDecimal2).setScale(2, 2) : str.equals("F") ? bigDecimal.multiply(bigDecimal2).setScale(2, 3) : bigDecimal.multiply(bigDecimal2).setScale(2, 4);
    }

    /* renamed from: l0 */
    public static void m67826l0(VoucherItemData voucherItemData, Voucher voucher, List<Voucher> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Voucher> it = list.iterator();
        while (it.hasNext()) {
            if (voucher.getVoucherCode().equals(it.next().getVoucherCode())) {
                voucherItemData.setSelected(true);
                return;
            }
            voucherItemData.setSelected(false);
        }
    }

    /* renamed from: m */
    public static FilterAvailabalGradePackage m67827m(PackageGrades packageGrades, String str, List<CloudPackage> list, long j10) {
        FilterAvailabalGradePackage filterAvailabalGradePackage = new FilterAvailabalGradePackage();
        long capacity = packageGrades.getCapacity();
        filterAvailabalGradePackage.setPackageGrades(packageGrades);
        filterAvailabalGradePackage.setGradeCode(str);
        filterAvailabalGradePackage.setCapacity(capacity);
        List<CloudPackage> basicPackageList = filterAvailabalGradePackage.getBasicPackageList();
        List<CloudPackage> monthlyPackageList = filterAvailabalGradePackage.getMonthlyPackageList();
        List<String> packageIdList = filterAvailabalGradePackage.getPackageIdList();
        List<CloudPackage> incrementList = filterAvailabalGradePackage.getIncrementList();
        for (CloudPackage cloudPackage : list) {
            if (cloudPackage != null && str.equals(packageGrades.getGradeCode()) && capacity == cloudPackage.getCapacity()) {
                packageIdList.add(cloudPackage.getId());
                int productType = cloudPackage.getProductType();
                if (productType == 8 || productType == 6) {
                    monthlyPackageList.add(cloudPackage);
                } else if (productType == 7 || productType == 5) {
                    basicPackageList.add(cloudPackage);
                } else if (productType == 12) {
                    incrementList.add(cloudPackage);
                }
                String renewChooseDesc = cloudPackage.getRenewChooseDesc();
                if (!TextUtils.isEmpty(renewChooseDesc)) {
                    filterAvailabalGradePackage.setRenewChooseDesc(renewChooseDesc);
                }
                filterAvailabalGradePackage.setRenewChooseType(cloudPackage.getRenewChooseType());
                String memAD = cloudPackage.getMemAD();
                if (!TextUtils.isEmpty(memAD)) {
                    filterAvailabalGradePackage.setMemAD(memAD);
                }
                filterAvailabalGradePackage.setServerTime(j10);
                filterAvailabalGradePackage.setCountDownConfig(cloudPackage.getCountDownConfig());
            }
        }
        return filterAvailabalGradePackage;
    }

    /* renamed from: m0 */
    public static void m67828m0(Context context, View view) {
        if (C11842p.m70753O0(context)) {
            C11842p.m70879w2(context, 472, view);
        } else {
            C11842p.m70863s2(view);
        }
    }

    /* renamed from: n */
    public static ArrayList<FilterAvailabalGradePackage> m67829n(List<PackageGrades> list, List<CloudPackage> list2) {
        return m67831o(list, list2, -1L);
    }

    /* renamed from: n0 */
    public static void m67830n0(Context context, View view) {
        if (C11842p.m70753O0(context)) {
            C11842p.m70879w2(context, ErrorCode.ERROR_SIGTOOL_FAIL, view);
        } else {
            C11842p.m70879w2(context, 466, view);
        }
    }

    /* renamed from: o */
    public static ArrayList<FilterAvailabalGradePackage> m67831o(List<PackageGrades> list, List<CloudPackage> list2, long j10) {
        PackageGrades next;
        ArrayList<FilterAvailabalGradePackage> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            Iterator<PackageGrades> it = list.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                String gradeCode = next.getGradeCode();
                if (TextUtils.isEmpty(gradeCode)) {
                    return arrayList;
                }
                FilterAvailabalGradePackage filterAvailabalGradePackageM67827m = m67827m(next, gradeCode, list2, j10);
                if (!filterAvailabalGradePackageM67827m.getMonthlyPackageList().isEmpty() || !filterAvailabalGradePackageM67827m.getBasicPackageList().isEmpty() || !filterAvailabalGradePackageM67827m.getIncrementList().isEmpty()) {
                    arrayList.add(filterAvailabalGradePackageM67827m);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: p */
    public static BigDecimal m67832p(CloudPackage cloudPackage, List<Voucher> list, BigDecimal bigDecimal) {
        if (cloudPackage == null) {
            C1442a.m8289e(f52947a, "getFinalDeduct cloudPackage is null.");
            return BigDecimal.ZERO;
        }
        if (!m67785I(bigDecimal, cloudPackage.getProductType())) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimalM67838v = m67838v(cloudPackage);
        if (list == null || list.isEmpty()) {
            return bigDecimal.compareTo(bigDecimalM67838v) > -1 ? bigDecimalM67838v : bigDecimal;
        }
        Voucher voucher = list.get(0);
        String feeMode = voucher.getFeeMode();
        BigDecimal bigDecimalAdd = BigDecimal.ZERO;
        Iterator<Voucher> it = list.iterator();
        while (it.hasNext()) {
            bigDecimalAdd = bigDecimalAdd.add(m67823k(cloudPackage, it.next(), bigDecimal));
        }
        if (bigDecimalAdd.compareTo(bigDecimalM67838v) >= 0) {
            bigDecimalAdd = bigDecimalM67838v;
        }
        if ("0".equals(feeMode)) {
            BigDecimal bigDecimalSubtract = bigDecimalM67838v.subtract(bigDecimalAdd);
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            return bigDecimalSubtract.compareTo(bigDecimal2) == 1 ? bigDecimal.compareTo(bigDecimalSubtract) > -1 ? bigDecimalM67838v.subtract(bigDecimalAdd) : bigDecimal : bigDecimal2;
        }
        if ("1".equals(feeMode)) {
            BigDecimal bigDecimalSubtract2 = bigDecimalM67838v.subtract(voucher.getMinFee());
            return bigDecimal.compareTo(bigDecimalSubtract2) < 1 ? bigDecimal : bigDecimalSubtract2;
        }
        if ("2".equals(feeMode)) {
            if (bigDecimal.compareTo(bigDecimalM67838v) == -1) {
                return bigDecimal;
            }
            C1442a.m8289e(f52947a, "getFinalDeduct voucherList clear.");
            list.clear();
            return bigDecimalM67838v;
        }
        C1442a.m8289e(f52947a, "getFinalDeduct invalid voucher type = " + feeMode);
        return BigDecimal.ZERO;
    }

    /* renamed from: q */
    public static BigDecimal m67833q(CloudPackage cloudPackage, List<Voucher> list, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal bigDecimalSubtract;
        if (!m67785I(bigDecimal, cloudPackage.getProductType())) {
            bigDecimal = BigDecimal.ZERO;
        }
        BigDecimal bigDecimalM67838v = m67838v(cloudPackage);
        if (!m67788L(bigDecimalM67838v)) {
            return BigDecimal.ZERO;
        }
        if (m67788L(bigDecimal2)) {
            bigDecimalSubtract = !m67788L(bigDecimal) ? bigDecimalM67838v.subtract(bigDecimal2) : (m67791O(list) || list.get(0) == null) ? bigDecimalM67838v.subtract(bigDecimal) : bigDecimalM67838v.subtract(bigDecimal2).subtract(m67832p(cloudPackage, list, bigDecimal));
        } else {
            if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                return bigDecimalM67838v;
            }
            bigDecimalSubtract = bigDecimalM67838v.subtract(bigDecimal);
        }
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        return bigDecimalSubtract.compareTo(bigDecimal3) <= 0 ? bigDecimal3 : bigDecimalSubtract;
    }

    /* renamed from: r */
    public static int m67834r() {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C1442a.m8289e(f52947a, "getHMSVersionCode() context is null.");
                return -1;
            }
            String strM79270H = C13195l.m79270H(contextM1377a);
            if (!TextUtils.isEmpty(strM79270H)) {
                return contextM1377a.getPackageManager().getPackageInfo(strM79270H, 16384).versionCode;
            }
            C11839m.m70687e(f52947a, "hmsPackage is invalid!");
            return -1;
        } catch (Exception e10) {
            C1442a.m8289e(f52947a, "getHMSVersionCode() err : " + e10.toString());
            return -1;
        }
    }

    /* renamed from: s */
    public static BigDecimal m67835s(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str) {
        if (!str.equals("C") && !str.equals("F")) {
            return bigDecimal.divide(new BigDecimal(1000)).multiply(bigDecimal2).setScale(0, 4).multiply(new BigDecimal(1000));
        }
        return bigDecimal.divide(new BigDecimal(1000)).multiply(bigDecimal2).setScale(0, 2).multiply(new BigDecimal(1000));
    }

    /* renamed from: t */
    public static List<String> m67836t() {
        try {
            return (List) new Gson().fromJson(C13452e.m80781L().m80845Q(), new b().getType());
        } catch (JsonSyntaxException e10) {
            C1461a.m8358e(f52947a, "getMemGradeRightListCache err : " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: u */
    public static OnePackegeVouchers m67837u(List<Voucher> list, CloudPackage cloudPackage, BigDecimal bigDecimal) {
        List<String> relatedPackages;
        OnePackegeVouchers onePackegeVouchers = new OnePackegeVouchers();
        if (!m67793Q(list, cloudPackage)) {
            return onePackegeVouchers;
        }
        List<Voucher> commonVoucherList = onePackegeVouchers.getCommonVoucherList();
        List<Voucher> singleChoiceVoucherList = onePackegeVouchers.getSingleChoiceVoucherList();
        for (Voucher voucher : list) {
            if (voucher != null && (relatedPackages = voucher.getRelatedPackages()) != null && !relatedPackages.isEmpty()) {
                for (String str : relatedPackages) {
                    if (!TextUtils.isEmpty(str) && str.equals(cloudPackage.getId())) {
                        String feeMode = voucher.getFeeMode();
                        if ("1".equals(feeMode)) {
                            singleChoiceVoucherList.add(voucher);
                        } else if ("2".equals(feeMode)) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(voucher);
                            if (m67811e(m67838v(cloudPackage).subtract(m67832p(cloudPackage, arrayList, bigDecimal)), voucher).compareTo(BigDecimal.ZERO) == 1) {
                                singleChoiceVoucherList.add(voucher);
                            }
                        } else if ("0".equals(feeMode)) {
                            commonVoucherList.add(voucher);
                        }
                    }
                }
            }
        }
        if (commonVoucherList.isEmpty() && singleChoiceVoucherList.isEmpty()) {
            return null;
        }
        Collections.sort(commonVoucherList);
        Collections.sort(singleChoiceVoucherList);
        return onePackegeVouchers;
    }

    /* renamed from: v */
    public static BigDecimal m67838v(CloudPackage cloudPackage) {
        BigDecimal spPrice = cloudPackage.getSpPrice();
        if (spPrice != null && spPrice.compareTo(cloudPackage.getPrice()) < 0) {
            return spPrice;
        }
        C1442a.m8288d(f52947a, "getPackgePrice spprice is null or <=price, id = " + cloudPackage.getId());
        return cloudPackage.getPrice();
    }

    /* renamed from: w */
    public static RecommendVouchers m67839w(CloudPackage cloudPackage, OnePackegeVouchers onePackegeVouchers, BigDecimal bigDecimal) {
        RecommendVouchers recommendVouchers = new RecommendVouchers();
        if (onePackegeVouchers == null) {
            C1442a.m8289e(f52947a, "getRecommendVouchers onePackegeVouchers is null.");
            return recommendVouchers;
        }
        List<Voucher> singleChoiceVoucherList = onePackegeVouchers.getSingleChoiceVoucherList();
        List<Voucher> commonVoucherList = onePackegeVouchers.getCommonVoucherList();
        BigDecimal bigDecimal2 = new BigDecimal(-1);
        BigDecimal bigDecimalM67838v = m67838v(cloudPackage);
        if (!singleChoiceVoucherList.isEmpty()) {
            if (singleChoiceVoucherList.size() == 1) {
                ArrayList arrayList = new ArrayList();
                Voucher voucher = singleChoiceVoucherList.get(0);
                BigDecimal bigDecimalM67823k = m67823k(cloudPackage, voucher, bigDecimal);
                BigDecimal bigDecimalM67778B = m67778B(cloudPackage, singleChoiceVoucherList, bigDecimal, bigDecimalM67823k);
                recommendVouchers.setVoucherType(voucher.getFeeMode());
                recommendVouchers.setDiscountAmount(bigDecimalM67823k);
                recommendVouchers.setTotalDiscount(bigDecimalM67778B);
                arrayList.clear();
                arrayList.add(voucher);
                recommendVouchers.setVoucherList(arrayList);
                bigDecimal2 = bigDecimalM67778B;
            } else {
                for (Voucher voucher2 : singleChoiceVoucherList) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(voucher2);
                    BigDecimal bigDecimalM67823k2 = m67823k(cloudPackage, voucher2, bigDecimal);
                    BigDecimal bigDecimalM67778B2 = m67778B(cloudPackage, arrayList2, bigDecimal, bigDecimalM67823k2);
                    if (bigDecimal2.compareTo(bigDecimalM67778B2) < 0) {
                        recommendVouchers.setVoucherType(voucher2.getFeeMode());
                        recommendVouchers.setDiscountAmount(bigDecimalM67823k2);
                        recommendVouchers.setTotalDiscount(bigDecimalM67778B2);
                        recommendVouchers.setVoucherList(arrayList2);
                        if (bigDecimalM67778B2.compareTo(bigDecimalM67838v) >= 0) {
                            return recommendVouchers;
                        }
                        bigDecimal2 = bigDecimalM67778B2;
                    }
                }
            }
        }
        RecommendVouchers recommendVouchersM67819i = m67819i(commonVoucherList, cloudPackage);
        BigDecimal bigDecimalM67778B3 = m67778B(cloudPackage, commonVoucherList, bigDecimal, recommendVouchersM67819i.getDiscountAmount());
        recommendVouchersM67819i.setTotalDiscount(bigDecimalM67778B3);
        if (bigDecimalM67778B3 == null || commonVoucherList == null || commonVoucherList.isEmpty()) {
            bigDecimalM67778B3 = BigDecimal.ZERO;
            recommendVouchersM67819i.setDiscountAmount(bigDecimalM67778B3);
            recommendVouchersM67819i.setVoucherType("0");
            recommendVouchersM67819i.setVoucherList(new ArrayList());
        }
        return bigDecimal2.compareTo(bigDecimalM67778B3) >= 0 ? recommendVouchers : recommendVouchersM67819i;
    }

    /* renamed from: x */
    public static RecommendVouchers m67840x(GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp) {
        if (getPackagesBySpaceRuleResp == null) {
            C1442a.m8289e(f52947a, "getRecommendVouchers resp is null.");
            return null;
        }
        List<CloudPackage> spacePackages = getPackagesBySpaceRuleResp.getSpacePackages();
        if (spacePackages == null || spacePackages.isEmpty()) {
            C1442a.m8289e(f52947a, "getRecommendVouchers packageList is null.");
            return null;
        }
        CloudPackage cloudPackage = spacePackages.get(0);
        return m67839w(cloudPackage, m67837u(getPackagesBySpaceRuleResp.getVoucherList(), cloudPackage, getPackagesBySpaceRuleResp.getDeductAmount()), getPackagesBySpaceRuleResp.getDeductAmount());
    }

    /* renamed from: y */
    public static int m67841y(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* renamed from: z */
    public static int m67842z() {
        return m67798V() ? 4 : 2;
    }
}
