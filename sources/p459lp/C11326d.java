package p459lp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.C1461a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.extend.C3948f;
import com.huawei.hicloud.bean.FeatureGray;
import com.huawei.hicloud.bean.FeatureGrayList;
import com.huawei.hicloud.bean.FirstTimeOverview;
import com.huawei.hicloud.bean.GradeMemberPrivilege;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HiCloudSysParamMapCache;
import com.huawei.hicloud.bean.IapUnsubscribeRetention;
import com.huawei.hms.utils.HEX;
import com.huawei.hms.utils.SHA256;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import dk.EnumC9164e;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONArray;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p371ik.C10527a;
import p399jk.AbstractC10896a;
import p657tp.C13055f;
import p664u0.C13108a;
import p686up.InterfaceC13233a;
import p686up.InterfaceC13235c;
import p783xp.C13843a;
import p815ym.AbstractC14026a;

/* renamed from: lp.d */
/* loaded from: classes7.dex */
public class C11326d {
    /* renamed from: c */
    public static List<GradeMemberPrivilege.PackageDisplayLevel> m68041c() {
        ArrayList arrayList = new ArrayList();
        GradeMemberPrivilege.PackageDisplayLevel packageDisplayLevel = new GradeMemberPrivilege.PackageDisplayLevel();
        packageDisplayLevel.setLevel(0);
        packageDisplayLevel.setGradCode(new ArrayList(Arrays.asList("N", CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)));
        arrayList.add(packageDisplayLevel);
        GradeMemberPrivilege.PackageDisplayLevel packageDisplayLevel2 = new GradeMemberPrivilege.PackageDisplayLevel();
        packageDisplayLevel2.setLevel(1);
        packageDisplayLevel2.setGradCode(new ArrayList(Arrays.asList(CloudBackupConstant.UserPackageInfo.SILVER_MEMBER, CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_50GB)));
        arrayList.add(packageDisplayLevel2);
        GradeMemberPrivilege.PackageDisplayLevel packageDisplayLevel3 = new GradeMemberPrivilege.PackageDisplayLevel();
        packageDisplayLevel3.setLevel(2);
        packageDisplayLevel3.setGradCode(new ArrayList(Arrays.asList(CloudBackupConstant.UserPackageInfo.GOLD_MEMBER, CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_200GB)));
        arrayList.add(packageDisplayLevel3);
        GradeMemberPrivilege.PackageDisplayLevel packageDisplayLevel4 = new GradeMemberPrivilege.PackageDisplayLevel();
        packageDisplayLevel4.setLevel(3);
        packageDisplayLevel4.setGradCode(new ArrayList(Arrays.asList("D", "Q", "K", CloudBackupConstant.UserPackageInfo.FULL_DATA_SERVICE_2048GB, "NQ", "NK")));
        arrayList.add(packageDisplayLevel4);
        return arrayList;
    }

    /* renamed from: d */
    public static int m68042d(final String str) {
        if (str == null) {
            AbstractC10896a.m65888w("BaseConfigUtil", "getFeatureGrayStatus,input is null.");
            return 0;
        }
        FeatureGrayList featureGrayList = (FeatureGrayList) C13055f.m78779g().m78764c(FeatureGrayList.class);
        if (featureGrayList == null) {
            AbstractC10896a.m65888w("BaseConfigUtil", "featureGrayList in sp is null.");
            return 0;
        }
        List<FeatureGray> featureGrayList2 = featureGrayList.getFeatureGrayList();
        if (AbstractC14026a.m84159a(featureGrayList2)) {
            return 0;
        }
        return ((Integer) featureGrayList2.stream().filter(new Predicate() { // from class: lp.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C11326d.m68052n(str, (FeatureGray) obj);
            }
        }).findFirst().map(new Function() { // from class: lp.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((FeatureGray) obj).getStatus());
            }
        }).orElse(0)).intValue();
    }

    /* renamed from: e */
    public static FirstTimeOverview m68043e(String str) {
        C1461a.m8359i("BaseConfigUtil", "getFirstTimeOverview start");
        String firstTimeOverview = HiCloudSysParamMapCache.getFirstTimeOverview();
        if (TextUtils.isEmpty(firstTimeOverview)) {
            HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
            if (hiCloudSysParamMapM60758q == null) {
                C1461a.m8358e("BaseConfigUtil", "getCardBean, sysParamMap is null!");
                return null;
            }
            firstTimeOverview = hiCloudSysParamMapM60758q.getFirstTimeOverview();
            if (TextUtils.isEmpty(firstTimeOverview)) {
                C1461a.m8358e("BaseConfigUtil", "firstTimeOverview,is empty");
                return null;
            }
        }
        List<FirstTimeOverview> listM64626d = C10527a.m64626d(firstTimeOverview, FirstTimeOverview.class);
        if (listM64626d.isEmpty()) {
            C1461a.m8358e("BaseConfigUtil", "getFirstTimeOverview, config list is empty");
            return null;
        }
        for (FirstTimeOverview firstTimeOverview2 : listM64626d) {
            if (!TextUtils.isEmpty(str) && TextUtils.equals(firstTimeOverview2.getService(), str)) {
                C1461a.m8359i("BaseConfigUtil", "getFirstTimeOverview end");
                return firstTimeOverview2;
            }
        }
        return null;
    }

    /* renamed from: f */
    public static EnumC9164e m68044f(String str) {
        if (TextUtils.isEmpty(str)) {
            return EnumC9164e.UNKNOWN;
        }
        List<GradeMemberPrivilege.PackageDisplayLevel> packageDisplayLevel = C9733f.m60705z().m60765x().getPackageDisplayLevel();
        if (AbstractC14026a.m84159a(packageDisplayLevel)) {
            packageDisplayLevel = m68041c();
        }
        for (GradeMemberPrivilege.PackageDisplayLevel packageDisplayLevel2 : packageDisplayLevel) {
            if (packageDisplayLevel2 != null) {
                List<String> gradCode = packageDisplayLevel2.getGradCode();
                if (AbstractC14026a.m84159a(gradCode)) {
                    continue;
                } else {
                    int level = packageDisplayLevel2.getLevel();
                    if (gradCode.contains(str)) {
                        return EnumC9164e.m57586b(level);
                    }
                }
            }
        }
        return EnumC9164e.UNKNOWN;
    }

    /* renamed from: g */
    public static List<String> m68045g() {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q != null) {
            return hiCloudSysParamMapM60758q.getGrayScaleUserTags();
        }
        AbstractC10896a.m65888w("BaseConfigUtil", "getNeedSwitchNewBMUserTags hiCloudSysParamMap is null!");
        return null;
    }

    /* renamed from: h */
    public static List<String> m68046h() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            return hiCloudSysParamMapM60757p.getGrayScaleUserTags();
        }
        AbstractC10896a.m65888w("BaseConfigUtil", "getNeedSwitchNewBMUserTags hiCloudSysParamMap is null!");
        return null;
    }

    /* renamed from: i */
    public static IapUnsubscribeRetention m68047i() {
        C1461a.m8359i("BaseConfigUtil", "getIapUnsubscribeRetention start");
        String iapUnsubscribeRetention = HiCloudSysParamMapCache.getIapUnsubscribeRetention();
        if (TextUtils.isEmpty(iapUnsubscribeRetention)) {
            HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
            if (hiCloudSysParamMapM60758q == null) {
                C1461a.m8358e("BaseConfigUtil", "getIapUnsubscribeRetention, sysParamMap is null!");
                return null;
            }
            iapUnsubscribeRetention = hiCloudSysParamMapM60758q.getIapUnsubscribeRetention();
            if (TextUtils.isEmpty(iapUnsubscribeRetention)) {
                C1461a.m8358e("BaseConfigUtil", "getIapUnsubscribeRetention,is empty");
                return null;
            }
        }
        IapUnsubscribeRetention iapUnsubscribeRetention2 = (IapUnsubscribeRetention) C10527a.m64629g(iapUnsubscribeRetention, IapUnsubscribeRetention.class);
        if (iapUnsubscribeRetention2 != null) {
            return iapUnsubscribeRetention2;
        }
        C1461a.m8358e("BaseConfigUtil", "getIapUnsubscribeRetention, config list is empty");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: j */
    public static List<String> m68048j(Context context, String str) {
        ArrayList arrayList;
        AbstractC10896a.m65887i("BaseConfigUtil", "getPackageNamesForSyncType: syncType = " + str);
        arrayList = new ArrayList();
        str.hashCode();
        switch (str) {
            case "addressbook":
                arrayList.add(C13843a.m83094p(context));
                return arrayList;
            case "calendar":
                arrayList.add("com.android.providers.calendar");
                return arrayList;
            case "browser":
                if (C13843a.m83078b0(context, "com.android.browser")) {
                    arrayList.add("com.android.browser");
                }
                String strM83092n = C13843a.m83092n(context);
                if (strM83092n != null) {
                    arrayList.add(strM83092n);
                }
                return arrayList;
            case "notepad":
                arrayList.add(C13843a.m83050B(context));
                return arrayList;
            default:
                return arrayList;
        }
    }

    /* renamed from: k */
    public static int m68049k() {
        C1461a.m8359i("BaseConfigUtil", "getPkgPriceCacheTime start");
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C1461a.m8360w("BaseConfigUtil", "getPkgPriceCacheTime, sysParamMap is null!");
            return AsCache.TIME_HOUR;
        }
        int pkgPriceCacheTime = hiCloudSysParamMapM60758q.getPkgPriceCacheTime();
        if (pkgPriceCacheTime == -1) {
            C1461a.m8360w("BaseConfigUtil", "getPkgPriceCacheTime,is empty");
            return AsCache.TIME_HOUR;
        }
        C1461a.m8359i("BaseConfigUtil", "getIapUnsubscribeRetention end,cacheTime is " + pkgPriceCacheTime);
        return pkgPriceCacheTime;
    }

    /* renamed from: l */
    public static String m68050l(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || str == null) {
            C1461a.m8358e("BaseConfigUtil", "getSignForPkgName: context or pkgName is null");
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C1461a.m8358e("BaseConfigUtil", "getSignForPkgName: packageManager is null");
                return "";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo == null) {
                C1461a.m8358e("BaseConfigUtil", "getSignForPkgName: packageInfo is null");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr != null && signatureArr.length >= 1) {
                return HEX.encodeHexString(SHA256.digest(signatureArr[0].toByteArray()), true);
            }
            C1461a.m8358e("BaseConfigUtil", "getSignForPkgName: signs is null or signs.length < 1");
            return "";
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C1461a.m8358e("BaseConfigUtil", "getSignForPkgName: NameNotFoundException pkgName =" + str);
            return "";
        }
    }

    /* renamed from: m */
    public static String[] m68051m(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            try {
                arrayList.add(jSONArray.getString(i10));
            } catch (JSONException e10) {
                C1461a.m8358e("BaseConfigUtil", "jsonArrayToStrArr JSONException: " + e10.toString());
                arrayList.clear();
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: n */
    public static /* synthetic */ boolean m68052n(String str, FeatureGray featureGray) {
        return str.equals(featureGray.getFunctionId());
    }

    /* renamed from: o */
    public static /* synthetic */ void m68053o(FeatureGray featureGray, FeatureGrayList featureGrayList) {
        FeatureGrayList featureGrayList2 = (FeatureGrayList) C13055f.m78779g().m78764c(FeatureGrayList.class);
        if (featureGrayList2 == null) {
            featureGrayList2 = new FeatureGrayList();
        }
        List<FeatureGray> featureGrayList3 = featureGrayList2.getFeatureGrayList();
        if (AbstractC14026a.m84159a(featureGrayList3)) {
            featureGrayList3 = new ArrayList<>();
            featureGrayList3.add(featureGray);
        } else {
            Iterator<FeatureGray> it = featureGrayList3.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().getFunctionId(), featureGray.getFunctionId())) {
                    it.remove();
                }
            }
            featureGrayList3.add(featureGray);
        }
        featureGrayList.setFeatureGrayList(featureGrayList3);
    }

    /* renamed from: p */
    public static boolean m68054p() throws ParseException {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C1461a.m8359i("BaseConfigUtil", "hiCloudSysParamMap is null, no need delay");
            return false;
        }
        String noticeSuppressStartTimeList = hiCloudSysParamMapM60758q.getNoticeSuppressStartTimeList();
        String noticeSuppressEndTimeList = hiCloudSysParamMapM60758q.getNoticeSuppressEndTimeList();
        if (TextUtils.isEmpty(noticeSuppressStartTimeList) || TextUtils.isEmpty(noticeSuppressEndTimeList)) {
            C1461a.m8359i("BaseConfigUtil", "suppressTimeList is null, no need delay");
            return false;
        }
        try {
            boolean zM1289o1 = C0209d.m1289o1(m68051m(new JSONArray(noticeSuppressStartTimeList)), m68051m(new JSONArray(noticeSuppressEndTimeList)));
            C1461a.m8358e("BaseConfigUtil", "isInDelayTime: " + zM1289o1);
            return zM1289o1;
        } catch (JSONException e10) {
            C1461a.m8358e("BaseConfigUtil", "needDelay catch exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: q */
    public static void m68055q(final FeatureGray featureGray) {
        if (featureGray == null) {
            AbstractC10896a.m65888w("BaseConfigUtil", "featureGray is null.");
        } else {
            C13055f.m78779g().m78765d(FeatureGrayList.class, new InterfaceC13235c() { // from class: lp.a
                @Override // p686up.InterfaceC13235c
                /* renamed from: a */
                public final void mo1517a(InterfaceC13233a interfaceC13233a) {
                    C11326d.m68053o(featureGray, (FeatureGrayList) interfaceC13233a);
                }
            });
        }
    }

    /* renamed from: r */
    public static void m68056r(String str) {
        AbstractC10896a.m65887i("BaseConfigUtil", "sendLocalBroadcast action:" + str);
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("BaseConfigUtil", "sendLocalBroadcast context null");
        } else if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("BaseConfigUtil", "action is null");
        } else {
            C13108a.m78878b(contextM1377a).m78881d(new Intent(str));
        }
    }

    /* renamed from: s */
    public static void m68057s(String str, boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65886e("BaseConfigUtil", "sendNotifyAccountInfoBroadcast context null");
            return;
        }
        C3948f.m24064g().m24078r(str, z10 ? 1 : 0);
        List<String> listM68048j = m68048j(contextM1377a, str);
        if (listM68048j.size() != 0) {
            for (String str2 : listM68048j) {
                AbstractC10896a.m65887i("BaseConfigUtil", "notifySyncSwitchChanged: syncType = " + str + ", packageName = " + str2 + ", state = " + (z10 ? 1 : 0));
                Intent intent = new Intent("com.huawei.android.hicloud.intent.SWITCH_CHANGED");
                C0209d.m1302r2(intent, str2);
                intent.putExtra("syncType", str);
                intent.putExtra("switchState", z10 ? 1 : 0);
                contextM1377a.sendBroadcast(intent, "com.huawei.hicloud.permission.hicloudSync");
            }
        }
    }
}
