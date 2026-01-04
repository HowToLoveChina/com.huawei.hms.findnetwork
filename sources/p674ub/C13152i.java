package p674ub;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.manager.HiCLoudStockActiveManager;
import com.huawei.hicloud.notification.p106db.bean.UrgencyAppConfig;
import com.huawei.hicloud.notification.p106db.bean.UrgencyDetail;
import com.huawei.hicloud.notification.p106db.bean.UrgencyDetailPicture;
import com.huawei.hicloud.notification.p106db.bean.UrgencyGoto;
import com.huawei.hicloud.notification.p106db.bean.UrgencyLanguage;
import com.huawei.hicloud.notification.p106db.bean.UrgencyNotice;
import com.huawei.hicloud.notification.p106db.bean.UrgencyNoticeInfo;
import com.huawei.hicloud.notification.p106db.bean.UrgencyNotification;
import com.huawei.hicloud.notification.p106db.bean.UrgencyPolicy;
import com.huawei.hicloud.notification.p106db.bean.UrgencyScenario;
import com.huawei.hicloud.notification.p106db.bean.UrgencyString;
import com.huawei.hicloud.notification.p106db.bean.UrgencyTop;
import com.huawei.hicloud.notification.p106db.operator.UrgencyLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.UrgencyNoticeInfoOperator;
import com.huawei.hicloud.notification.p106db.operator.UrgencyPolicyOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5013g0;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import no.C11739b;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0227m;
import p015ak.C0234s;
import p015ak.C0238w;
import p052cb.C1416m;
import p292fn.C9734g;
import p459lp.C11327e;
import p514o9.C11829c;
import p514o9.C11839m;
import p572qb.C12318k0;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;

/* renamed from: ub.i */
/* loaded from: classes3.dex */
public class C13152i {

    /* renamed from: h */
    public static final C13152i f59648h = new C13152i();

    /* renamed from: a */
    public C5013g0 f59649a = new C5013g0(null);

    /* renamed from: b */
    public UrgencyPolicyOperator f59650b = new UrgencyPolicyOperator();

    /* renamed from: c */
    public UrgencyNoticeInfoOperator f59651c = new UrgencyNoticeInfoOperator();

    /* renamed from: d */
    public UrgencyLanguageOperator f59652d = new UrgencyLanguageOperator();

    /* renamed from: e */
    public UrgencyPolicy f59653e;

    /* renamed from: f */
    public UrgencyPolicy f59654f;

    /* renamed from: g */
    public String f59655g;

    /* renamed from: ub.i$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public String f59656a;

        /* renamed from: b */
        public String f59657b;

        public a(String str, String str2) {
            this.f59656a = str;
            this.f59657b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                Context contextM1378b = C0213f.m1378b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(contextM1378b.getFilesDir());
                String str = File.separator;
                sb2.append(str);
                sb2.append(RemoteMessageConst.URGENCY);
                sb2.append(str);
                sb2.append("icon");
                sb2.append(this.f59657b);
                String string = sb2.toString();
                C11739b c11739b = new C11739b(this.f59656a, string, 0L);
                C11829c.m70595m(string, c11739b.m70044b(), c11739b);
                if (new File(string).exists()) {
                    return;
                }
                C11839m.m70688i("UrgencyNoticeManager", "IconTask call end");
            } catch (Exception e10) {
                C11839m.m70687e("UrgencyNoticeManager", "IconTask exception:" + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    /* renamed from: m */
    public static String m79068m() {
        return C0234s.m1636n();
    }

    /* renamed from: n */
    public static String m79069n() {
        return C0234s.m1631i();
    }

    /* renamed from: o */
    public static C13152i m79070o() {
        return f59648h;
    }

    /* renamed from: w */
    public static String m79071w(String str) {
        String strM79069n = m79069n();
        List<UrgencyString> listQueryString = new UrgencyLanguageOperator().queryString(strM79069n, m79068m(), HNConstants.Language.EN_STANDARD, str);
        if (listQueryString == null || listQueryString.size() <= 0) {
            C11839m.m70687e("UrgencyNoticeManager", "getStringFromConfig no language configs,stringId=" + str);
            return null;
        }
        UrgencyString urgencyString = null;
        UrgencyString urgencyString2 = null;
        for (UrgencyString urgencyString3 : listQueryString) {
            String country = urgencyString3.getCountry();
            if (country == null) {
                C11839m.m70687e("UrgencyNoticeManager", "tmpLanguageName null, stringId=" + str);
            } else if (country.equals(strM79069n)) {
                urgencyString2 = urgencyString3;
            } else if (country.equals(HNConstants.Language.EN_STANDARD)) {
                urgencyString = urgencyString3;
            }
        }
        if (urgencyString != null) {
            listQueryString.remove(urgencyString);
        }
        if (urgencyString2 != null) {
            C11839m.m70688i("UrgencyNoticeManager", "fullMatchString stringId=" + str);
            listQueryString.remove(urgencyString2);
            urgencyString = urgencyString2;
        } else if (listQueryString.size() > 0) {
            C11839m.m70688i("UrgencyNoticeManager", "partMatch stringId=" + str);
            UrgencyString urgencyString4 = listQueryString.get(0);
            urgencyString = urgencyString4 != null ? urgencyString4 : null;
        } else {
            C11839m.m70688i("UrgencyNoticeManager", "no match, using default stringId=" + str);
        }
        if (urgencyString != null) {
            return urgencyString.getValue();
        }
        return null;
    }

    /* renamed from: A */
    public final void m79072A(UrgencyAppConfig urgencyAppConfig) throws Exception {
        this.f59651c = new UrgencyNoticeInfoOperator();
        UrgencyNoticeInfo urgencyNoticeInfo = new UrgencyNoticeInfo();
        urgencyNoticeInfo.setKey(FaqConstants.FAQ_EMUI_LANGUAGE);
        urgencyNoticeInfo.setValue(urgencyAppConfig.getLanguageJsonStr());
        UrgencyNoticeInfo urgencyNoticeInfo2 = new UrgencyNoticeInfo();
        urgencyNoticeInfo2.setKey("config_version");
        urgencyNoticeInfo2.setValue(String.valueOf(C11327e.m68063f("HiCloudTrigger")));
        ArrayList<UrgencyNoticeInfo> arrayList = new ArrayList<>();
        arrayList.add(urgencyNoticeInfo);
        arrayList.add(urgencyNoticeInfo2);
        this.f59651c.batchInsert(arrayList);
    }

    /* renamed from: B */
    public final void m79073B(UrgencyAppConfig urgencyAppConfig) throws Exception {
        List<UrgencyPolicy> policyList = urgencyAppConfig.getPolicyList();
        if (policyList == null) {
            C11839m.m70687e("UrgencyNoticeManager", "init policies null");
            return;
        }
        UrgencyPolicyOperator urgencyPolicyOperator = new UrgencyPolicyOperator();
        this.f59650b = urgencyPolicyOperator;
        urgencyPolicyOperator.batchInsert(policyList);
    }

    /* renamed from: C */
    public final boolean m79074C(UrgencyScenario urgencyScenario, String str) {
        if (urgencyScenario == null) {
            C11839m.m70687e("UrgencyNoticeManager", "isErrorIdAvailable scenario null");
            return false;
        }
        List<String> errorScenarioIds = urgencyScenario.getErrorScenarioIds();
        if (errorScenarioIds == null) {
            C11839m.m70687e("UrgencyNoticeManager", "isErrorIdAvailable errorScenarioIds null");
            return false;
        }
        for (String str2 : errorScenarioIds) {
            C11839m.m70687e("UrgencyNoticeManager", "isErrorIdAvailable condition:" + str + ", id:" + str2);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: D */
    public final boolean m79075D(UrgencyScenario urgencyScenario, String str) {
        if (urgencyScenario == null) {
            C11839m.m70687e("UrgencyNoticeManager", "isStatusAvailable scenario null");
            return false;
        }
        List<String> userStatus = urgencyScenario.getUserStatus();
        if (userStatus == null) {
            C11839m.m70687e("UrgencyNoticeManager", "isStatusAvailable policyUserStatus null");
            return false;
        }
        for (String str2 : userStatus) {
            C11839m.m70687e("UrgencyNoticeManager", "isStatusAvailable userStatus:" + str + ", status:" + str2);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m79076E(java.lang.String r5, com.huawei.hicloud.notification.p106db.bean.UrgencyLanguage r6) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "parseLanguageXml exception:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "parseLanguageXml xmlPath = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "UrgencyNoticeManager"
            p514o9.C11839m.m70688i(r2, r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r5 = r1.exists()
            if (r5 != 0) goto L29
            java.lang.String r4 = "language xml not exist"
            p514o9.C11839m.m70687e(r2, r4)
            return
        L29:
            r5 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L51 org.xmlpull.v1.XmlPullParserException -> L55 java.io.IOException -> L59 fk.C9721b -> L5d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L51 org.xmlpull.v1.XmlPullParserException -> L55 java.io.IOException -> L59 fk.C9721b -> L5d
            org.xmlpull.v1.XmlPullParser r5 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43 org.xmlpull.v1.XmlPullParserException -> L45 java.io.IOException -> L47 fk.C9721b -> L49
            java.lang.String r1 = "utf-8"
            r5.setInput(r3, r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43 org.xmlpull.v1.XmlPullParserException -> L45 java.io.IOException -> L47 fk.C9721b -> L49
            r4.m79089R(r6, r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43 org.xmlpull.v1.XmlPullParserException -> L45 java.io.IOException -> L47 fk.C9721b -> L49
        L3b:
            r4.m79079H(r3)
            goto Lc6
        L40:
            r5 = move-exception
            goto Lc7
        L43:
            r5 = move-exception
            goto L61
        L45:
            r5 = move-exception
            goto L7a
        L47:
            r5 = move-exception
            goto L93
        L49:
            r5 = move-exception
            goto Lac
        L4c:
            r6 = move-exception
            r3 = r5
            r5 = r6
            goto Lc7
        L51:
            r6 = move-exception
            r3 = r5
            r5 = r6
            goto L61
        L55:
            r6 = move-exception
            r3 = r5
            r5 = r6
            goto L7a
        L59:
            r6 = move-exception
            r3 = r5
            r5 = r6
            goto L93
        L5d:
            r6 = move-exception
            r3 = r5
            r5 = r6
            goto Lac
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r6.<init>()     // Catch: java.lang.Throwable -> L40
            r6.append(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L40
            r6.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L40
            p514o9.C11839m.m70687e(r2, r5)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto Lc6
            goto L3b
        L7a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r6.<init>()     // Catch: java.lang.Throwable -> L40
            r6.append(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L40
            r6.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L40
            p514o9.C11839m.m70687e(r2, r5)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto Lc6
            goto L3b
        L93:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r6.<init>()     // Catch: java.lang.Throwable -> L40
            r6.append(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L40
            r6.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L40
            p514o9.C11839m.m70687e(r2, r5)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto Lc6
            goto L3b
        Lac:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r6.<init>()     // Catch: java.lang.Throwable -> L40
            r6.append(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L40
            r6.append(r5)     // Catch: java.lang.Throwable -> L40
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L40
            p514o9.C11839m.m70687e(r2, r5)     // Catch: java.lang.Throwable -> L40
            if (r3 == 0) goto Lc6
            goto L3b
        Lc6:
            return
        Lc7:
            if (r3 == 0) goto Lcc
            r4.m79079H(r3)
        Lcc:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p674ub.C13152i.m79076E(java.lang.String, com.huawei.hicloud.notification.db.bean.UrgencyLanguage):void");
    }

    /* renamed from: F */
    public void m79077F(String str) {
        try {
            m79095e(new JSONObject(str).optString("userStatus"), "PushMsg");
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "processPushMsg exception:" + e10.toString());
        }
    }

    /* renamed from: G */
    public final void m79078G() throws Throwable {
        try {
            UrgencyNotice urgencyNoticeM79102l = m79102l();
            if (urgencyNoticeM79102l == null) {
                C11839m.m70687e("UrgencyNoticeManager", "init notice null");
                return;
            }
            UrgencyAppConfig appConfig = urgencyNoticeM79102l.getAppConfig();
            if (appConfig == null) {
                C11839m.m70687e("UrgencyNoticeManager", "init appConfig null");
                return;
            }
            if (!this.f59650b.hasRecord()) {
                C11839m.m70688i("UrgencyNoticeManager", "reInit policy");
                m79073B(appConfig);
            }
            if (!this.f59651c.hasRecord()) {
                C11839m.m70688i("UrgencyNoticeManager", "reInit init");
                m79072A(appConfig);
            }
            if (this.f59652d.hasRecord()) {
                return;
            }
            C11839m.m70688i("UrgencyNoticeManager", "reInit language");
            m79072A(appConfig);
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "reinit exception:" + e10.toString());
        }
    }

    /* renamed from: H */
    public final void m79079H(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                C11839m.m70687e("UrgencyNoticeManager", "safeClose exceptions:" + e10.toString());
            }
        }
    }

    /* renamed from: I */
    public void m79080I(UrgencyPolicy urgencyPolicy) {
        UrgencyTop ontop = urgencyPolicy.getOntop();
        if (ontop != null) {
            this.f59655g = ontop.getContent();
        }
    }

    /* renamed from: J */
    public void m79081J(UrgencyPolicy urgencyPolicy) {
        if (urgencyPolicy != null) {
            this.f59653e = urgencyPolicy;
        }
    }

    /* renamed from: K */
    public void m79082K(UrgencyPolicy urgencyPolicy) {
        if (urgencyPolicy != null) {
            this.f59654f = urgencyPolicy;
        }
    }

    /* renamed from: L */
    public final void m79083L(String str, String str2, Notification notification, NotificationManager notificationManager) {
        if (TextUtils.isEmpty(str) || str.equals(str2)) {
            notificationManager.notify(294, notification);
        } else {
            notificationManager.notify(295, notification);
        }
        C10028c.m62182c0().m62391s2(str2);
        C11839m.m70688i("UrgencyNoticeManager", "notice urgency id" + str2);
    }

    /* renamed from: M */
    public final void m79084M(UrgencyPolicy urgencyPolicy) {
        try {
            Gson gson = new Gson();
            urgencyPolicy.setScenario((UrgencyScenario) gson.fromJson(urgencyPolicy.getScenarioStr(), UrgencyScenario.class));
            String[] strArr = (String[]) gson.fromJson(urgencyPolicy.getActionStr(), String[].class);
            if (strArr == null) {
                strArr = new String[0];
            }
            urgencyPolicy.setAction(Arrays.asList(strArr));
            String[] strArr2 = (String[]) gson.fromJson(urgencyPolicy.getNoticeTypeStr(), String[].class);
            if (strArr2 == null) {
                strArr2 = new String[0];
            }
            urgencyPolicy.setNoticeType(Arrays.asList(strArr2));
            urgencyPolicy.setNotice((UrgencyNotification) gson.fromJson(urgencyPolicy.getNoticeStr(), UrgencyNotification.class));
            urgencyPolicy.setOntop((UrgencyTop) gson.fromJson(urgencyPolicy.getOnTopStr(), UrgencyTop.class));
            urgencyPolicy.setDetail((UrgencyDetail) gson.fromJson(urgencyPolicy.getDetailStr(), UrgencyDetail.class));
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("UrgencyNoticeManager", "transformPolicyJson json exception:" + e10.toString());
        }
    }

    /* renamed from: N */
    public void m79085N(UrgencyPolicy urgencyPolicy, String str, String str2) {
        String url;
        String hash;
        UrgencyDetailPicture picture;
        if (HiCLoudStockActiveManager.getInstance().isActiveCloudAuto()) {
            C11839m.m70688i("UrgencyNoticeManager", "isActiveCloudAuto");
            return;
        }
        if (urgencyPolicy == null) {
            C11839m.m70687e("UrgencyNoticeManager", "policy is null.");
            return;
        }
        List<String> noticeType = urgencyPolicy.getNoticeType();
        if (noticeType == null) {
            C11839m.m70687e("UrgencyNoticeManager", "noticeType is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("UrgencyNoticeManager", "urgencyId is null.");
            return;
        }
        UrgencyDetail detail = urgencyPolicy.getDetail();
        if (detail == null || (picture = detail.getPicture()) == null) {
            url = null;
            hash = null;
        } else {
            url = picture.getUrl();
            hash = picture.getHash();
        }
        if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(hash)) {
            Context contextM1378b = C0213f.m1378b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contextM1378b.getFilesDir());
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(RemoteMessageConst.URGENCY);
            sb2.append(str3);
            sb2.append("icon");
            sb2.append(str);
            String string = sb2.toString();
            if (!TextUtils.isEmpty(string)) {
                if (m79100j(string).equals(hash)) {
                    C11839m.m70688i("UrgencyNoticeManager", "picture has existence");
                } else {
                    C12515a.m75110o().m75175e(new a(url, str), false);
                }
            }
        }
        m79088Q(urgencyPolicy, noticeType, str, str2);
    }

    /* renamed from: O */
    public final void m79086O(UrgencyNotification urgencyNotification, String str, String str2, String str3) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("UrgencyNoticeManager", "triggerNotification context is null.");
                return;
            }
            if (urgencyNotification == null) {
                C11839m.m70687e("UrgencyNoticeManager", "triggerNotification notice is null");
                return;
            }
            if (!m79092b(urgencyNotification.getDayonce(), urgencyNotification.getTimes(), str3)) {
                linkedHashMap.put("urgency notice failed", "checkFrequency false");
                C12318k0.m74089a("urgency notice event", linkedHashMap);
                return;
            }
            NotificationManager notificationManager = (NotificationManager) contextM1377a.getSystemService("notification");
            NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(contextM1377a, urgencyNotification.getTitle());
            builderM1668i.m3823x(true);
            String strM79071w = m79071w(urgencyNotification.getTitle());
            if (TextUtils.isEmpty(strM79071w)) {
                C11839m.m70687e("UrgencyNoticeManager", "title is empty");
                return;
            }
            String strM79071w2 = m79071w(urgencyNotification.getContent());
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", contextM1377a.getResources().getString(R$string.HiCloud_app_name));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3839h(strM79071w2);
            builderM1668i.m3825z(c0605b);
            Intent intentM79104q = m79104q(urgencyNotification.getTo(), str, str2);
            C0216g0.m1402e(contextM1377a).m1408F(intentM79104q, "SOURCE_ID_URGENCY_NOTIFY");
            m79083L(C10028c.m62182c0().m62194C(), str2, builderM1668i.m3811l(strM79071w).m3810k(strM79071w2).m3809j(C0209d.m1248e0(contextM1377a, 4, intentM79104q, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK)).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d(), notificationManager);
            C10028c.m62182c0().m62352k3(System.currentTimeMillis(), str3);
            int iM62199D = C10028c.m62182c0().m62199D(str3) + 1;
            C10028c.m62182c0().m62396t2(iM62199D, str3);
            linkedHashMap.put("urgency notice success", String.valueOf(strM79071w + "," + strM79071w2 + ",Number = " + iM62199D + ",Time =" + System.currentTimeMillis()));
            C12318k0.m74089a("urgency notice event", linkedHashMap);
        } catch (C1416m e10) {
            C11839m.m70687e("UrgencyNoticeManager", "triggerNotification exception:" + e10.toString());
        }
    }

    /* renamed from: P */
    public final void m79087P(String str, String str2, String str3) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("UrgencyNoticeManager", "triggerOnTop context null");
            return;
        }
        C13108a c13108aM78878b = C13108a.m78878b(contextM1377a);
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("notify_urgency_top_banner");
        intent.putExtra("detail_urgency_top_banner", str);
        intent.putExtra("detail_urgency_top_detail", str2);
        intent.putExtra("detail_urgency_ID", str3);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("urgency notice success", String.valueOf("detail_urgency_top_banner,Time =" + System.currentTimeMillis()));
        C12318k0.m74089a("urgency notice event", linkedHashMap);
        c13108aM78878b.m78881d(intent);
    }

    /* renamed from: Q */
    public final void m79088Q(UrgencyPolicy urgencyPolicy, List<String> list, String str, String str2) {
        for (String str3 : list) {
            if (!TextUtils.isEmpty(str3)) {
                if (str3.equals("notice")) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("urgency notice start", String.valueOf("current time:" + System.currentTimeMillis() + ", type = notice"));
                    C12318k0.m74089a("urgency notice event", linkedHashMap);
                    m79086O(urgencyPolicy.getNotice(), urgencyPolicy.getDetailJsonStr(), str, str2);
                } else if (str3.equals("ontop")) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("urgency notice start", String.valueOf("current time:" + System.currentTimeMillis() + ", type = ontop"));
                    C12318k0.m74089a("urgency notice event", linkedHashMap2);
                    m79087P(urgencyPolicy.getTopJsonStr(), urgencyPolicy.getDetailJsonStr(), str);
                    m79080I(urgencyPolicy);
                }
            }
        }
    }

    /* renamed from: R */
    public final void m79089R(UrgencyLanguage urgencyLanguage, XmlPullParser xmlPullParser) throws Exception {
        int eventType = xmlPullParser.getEventType();
        ArrayList<UrgencyString> arrayList = null;
        String str = "";
        while (eventType != 1) {
            String name = xmlPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3 && !"resource".equals(name) && !"text".equals(name) && arrayList != null) {
                    new UrgencyLanguageOperator().batchInsert(arrayList);
                    arrayList.clear();
                }
            } else if ("resource".equals(name)) {
                arrayList = new ArrayList<>();
            } else if ("text".equals(name)) {
                UrgencyString urgencyString = new UrgencyString();
                urgencyString.setVersion(String.valueOf(urgencyLanguage.getVersion()));
                urgencyString.setName(xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "name"));
                urgencyString.setValue(xmlPullParser.getAttributeValue(xmlPullParser.getNamespace(), "value"));
                urgencyString.setCountry(str);
                if (arrayList != null) {
                    arrayList.add(urgencyString);
                }
            } else {
                str = name;
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: S */
    public String m79090S() {
        String str = this.f59655g;
        if (str != null) {
            return m79071w(str);
        }
        return null;
    }

    /* renamed from: a */
    public void m79091a(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Server Return scenarioId", String.valueOf("source = " + str2 + ",scenarioId = " + str));
        C12318k0.m74089a("Accepted from server", linkedHashMap);
        C12515a.m75110o().m75175e(new C13144a(str), true);
    }

    /* renamed from: b */
    public final boolean m79092b(float f10, int i10, String str) {
        long jM62404v0 = C10028c.m62182c0().m62404v0(str);
        int iM62199D = C10028c.m62182c0().m62199D(str);
        long jCurrentTimeMillis = System.currentTimeMillis() - jM62404v0;
        if (jCurrentTimeMillis > f10 * 8.64E7f && iM62199D < i10) {
            return true;
        }
        C11839m.m70688i("UrgencyNoticeManager", "checkFrequency failed, gap=" + jCurrentTimeMillis);
        C11839m.m70688i("UrgencyNoticeManager", "checkFrequency failed, notifyTimes=" + iM62199D);
        return false;
    }

    /* renamed from: c */
    public void m79093c() throws Throwable {
        C11839m.m70688i("UrgencyNoticeManager", "UrgenctNoticeManager checkLanguageDataBase");
        UrgencyNotice urgencyNoticeM79102l = m79102l();
        if (urgencyNoticeM79102l == null) {
            C11839m.m70688i("UrgencyNoticeManager", "checkLanguageDataBase config == null");
            return;
        }
        UrgencyLanguageOperator urgencyLanguageOperator = new UrgencyLanguageOperator();
        if (urgencyLanguageOperator.hasRecord()) {
            return;
        }
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(RemoteMessageConst.URGENCY);
        sb2.append(str);
        sb2.append("language.xml");
        String string = sb2.toString();
        if (!new File(string).exists()) {
            C11839m.m70688i("UrgencyNoticeManager", "checkLanguageDataBase languageFile == null");
            return;
        }
        UrgencyAppConfig appConfig = urgencyNoticeM79102l.getAppConfig();
        if (appConfig == null) {
            C11839m.m70687e("UrgencyNoticeManager", "init appConfig null");
        } else {
            urgencyLanguageOperator.clear();
            m79076E(string, appConfig.getLanguage());
        }
    }

    /* renamed from: d */
    public boolean m79094d(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null) {
            C11839m.m70687e("UrgencyNoticeManager", "checkShowPages pageName or pages null");
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m79095e(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Server Return userStatus", String.valueOf("source = " + str2 + ",userStatus = " + str));
        C12318k0.m74089a("Accepted from server", linkedHashMap);
        C12515a.m75110o().m75175e(new C13145b(str), true);
    }

    /* renamed from: f */
    public final void m79096f() {
        new UrgencyNoticeInfoOperator().clear();
        new UrgencyPolicyOperator().clear();
    }

    /* renamed from: g */
    public void m79097g() {
        new UrgencyNoticeInfoOperator().clear();
        new UrgencyPolicyOperator().clear();
        new UrgencyLanguageOperator().clear();
    }

    /* renamed from: h */
    public void m79098h() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("urgency config download", String.valueOf("UrgencyNoticeManager, downloadConfigFile start : " + System.currentTimeMillis()));
        C12318k0.m74089a("urgency config", linkedHashMap);
        C12515a.m75110o().m75175e(new C13150g(), false);
    }

    /* renamed from: i */
    public final void m79099i(UrgencyAppConfig urgencyAppConfig, long j10) {
        UrgencyLanguage language = urgencyAppConfig.getLanguage();
        if (language == null) {
            C11839m.m70687e("UrgencyNoticeManager", "init language null");
            return;
        }
        C11839m.m70688i("UrgencyNoticeManager", "local lang version:" + j10 + ", cloud verion:" + language.getVersion());
        if (j10 < language.getVersion()) {
            C12515a.m75110o().m75175e(new C13151h(language), true);
        }
    }

    /* renamed from: j */
    public final String m79100j(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    /* renamed from: k */
    public final void m79101k() throws Throwable {
        C11839m.m70688i("UrgencyNoticeManager", "getConfig() start");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C11839m.m70687e("UrgencyNoticeManager", "getConfig() exception:" + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudTrigger")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    C11839m.m70687e("UrgencyNoticeManager", "urgency config HTTP_NOT_MODIFY");
                    return;
                } else {
                    if (!this.f59649a.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    C11839m.m70688i("UrgencyNoticeManager", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (C0213f.m1377a() == null) {
                C11839m.m70687e("UrgencyNoticeManager", "getConfig() context is null.");
                return;
            }
            if (this.f59649a.getLatestConfig()) {
                C11839m.m70688i("UrgencyNoticeManager", "getConfig success");
                C9734g.m60767a().m60769c("HiCloudTrigger");
                m79112z();
                return;
            }
            C11839m.m70687e("UrgencyNoticeManager", "query hicloud urgency config failed");
            if (i10 >= 2) {
                return;
            }
            C11839m.m70688i("UrgencyNoticeManager", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* renamed from: l */
    public final UrgencyNotice m79102l() throws Throwable {
        C11839m.m70688i("UrgencyNoticeManager", "getConfigFromFile");
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(RemoteMessageConst.URGENCY);
        sb2.append(str);
        sb2.append("urgency_config.json");
        try {
            return (UrgencyNotice) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(new File(sb2.toString()))), UrgencyNotice.class);
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "urgency config file not exitst, msg:" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: p */
    public final long m79103p() {
        UrgencyNoticeInfo urgencyNoticeInfo;
        UrgencyLanguage urgencyLanguage;
        try {
            UrgencyNoticeInfoOperator urgencyNoticeInfoOperator = new UrgencyNoticeInfoOperator();
            this.f59651c = urgencyNoticeInfoOperator;
            List<UrgencyNoticeInfo> listQuery = urgencyNoticeInfoOperator.query(FaqConstants.FAQ_EMUI_LANGUAGE);
            if (listQuery == null || listQuery.size() <= 0 || (urgencyNoticeInfo = listQuery.get(0)) == null || (urgencyLanguage = (UrgencyLanguage) new Gson().fromJson(urgencyNoticeInfo.getValue(), UrgencyLanguage.class)) == null) {
                return 0L;
            }
            return urgencyLanguage.getVersion();
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "getLangVersion exception:" + e10.toString());
            return 0L;
        }
    }

    /* renamed from: q */
    public final Intent m79104q(UrgencyGoto urgencyGoto, String str, String str2) throws C1416m {
        if (urgencyGoto == null) {
            throw new C1416m("no goto");
        }
        String type = urgencyGoto.getType();
        String uri = urgencyGoto.getUri();
        if (TextUtils.isEmpty(type)) {
            throw new C1416m("uri null");
        }
        if (!type.equals("detail")) {
            if (!type.equals("web")) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("urgency goto", String.valueOf("web:" + uri + ",Time =" + System.currentTimeMillis()));
            C12318k0.m74089a("urgency notice event", linkedHashMap);
            return m79111y(uri);
        }
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("com.huawei.android.hicloud.ui.activity.UrgencyDetailActivity");
        intent.putExtra("urgency_goto_detail", str);
        intent.putExtra("detail_urgency_ID", str2);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("urgency goto", String.valueOf("urgency_goto_detail,Time =" + System.currentTimeMillis()));
        C12318k0.m74089a("urgency notice event", linkedHashMap2);
        return intent;
    }

    /* renamed from: r */
    public UrgencyPolicy m79105r(String str) {
        return m79106s(str, 1);
    }

    /* renamed from: s */
    public final UrgencyPolicy m79106s(String str, int i10) throws Throwable {
        UrgencyPolicyOperator urgencyPolicyOperator = new UrgencyPolicyOperator();
        this.f59650b = urgencyPolicyOperator;
        List<UrgencyPolicy> allPolicy = urgencyPolicyOperator.getAllPolicy();
        if (allPolicy == null) {
            C11839m.m70687e("UrgencyNoticeManager", "getPolicyByUserStatus policies null");
            return null;
        }
        for (UrgencyPolicy urgencyPolicy : allPolicy) {
            if (urgencyPolicy == null) {
                C11839m.m70687e("UrgencyNoticeManager", "getPolicyByUserStatus policy null");
            } else {
                m79084M(urgencyPolicy);
                if (i10 == 0) {
                    if (m79075D(urgencyPolicy.getScenario(), str)) {
                        return urgencyPolicy;
                    }
                } else if (i10 == 1 && m79074C(urgencyPolicy.getScenario(), str)) {
                    return urgencyPolicy;
                }
            }
        }
        return null;
    }

    /* renamed from: t */
    public UrgencyPolicy m79107t(String str) {
        return m79106s(str, 0);
    }

    /* renamed from: u */
    public String m79108u() {
        try {
            return this.f59653e != null ? new Gson().toJson(this.f59653e) : "";
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "getPolicyByCode exception:" + e10.toString());
            return "";
        }
    }

    /* renamed from: v */
    public String m79109v() {
        try {
            return this.f59654f != null ? new Gson().toJson(this.f59654f) : "";
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "getPolicyByStatus exception:" + e10.toString());
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        r3 = p459lp.C11327e.m68063f("HiCloudTrigger");
        r5 = new java.util.LinkedHashMap();
        r6 = "UrgencyNoticeManager,latestVersion =" + r0 + ",localVersion =" + r3;
        r5.put("urgency config download", java.lang.String.valueOf(r6));
        p572qb.C12318k0.m74089a("urgency config", r5);
        p514o9.C11839m.m70688i("UrgencyNoticeManager", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
    
        if (r3 >= r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0099, code lost:
    
        p514o9.C11839m.m70688i("UrgencyNoticeManager", "version updated, query config");
        m79101k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a0, code lost:
    
        if (r3 != r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a2, code lost:
    
        p514o9.C11839m.m70688i("UrgencyNoticeManager", "version updated, query config");
        m79101k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a9, code lost:
    
        p514o9.C11839m.m70689w("UrgencyNoticeManager", "getVersion fail. localVersion > latestVersion");
        m79078G();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m79110x() {
        /*
            r9 = this;
            r0 = 0
        L1:
            r1 = 2
            java.lang.String r2 = "UrgencyNoticeManager"
            if (r0 > r1) goto L5c
            com.huawei.hicloud.service.g0 r3 = r9.f59649a     // Catch: fk.C9721b -> Ld
            long r0 = r3.getConfigVersion()     // Catch: fk.C9721b -> Ld
            goto L5e
        Ld:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getUrgencyConfigVersion exception:"
            r4.append(r5)
            java.lang.String r5 = r3.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = " retryNum = "
            r5.append(r4)
            r5.append(r0)
            java.lang.String r4 = r5.toString()
            p514o9.C11839m.m70687e(r2, r4)
            com.huawei.hicloud.service.g0 r4 = r9.f59649a
            boolean r3 = r4.isExceptionNeedRetry(r3)
            if (r3 == 0) goto L5b
            if (r0 >= r1) goto L5b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "getVersion exception retry, retry num: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            p514o9.C11839m.m70688i(r2, r1)
            int r0 = r0 + 1
            goto L1
        L5b:
            return
        L5c:
            r0 = 0
        L5e:
            java.lang.String r3 = "HiCloudTrigger"
            long r3 = p459lp.C11327e.m68063f(r3)
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "UrgencyNoticeManager,latestVersion ="
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = ",localVersion ="
            r6.append(r7)
            r6.append(r3)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = java.lang.String.valueOf(r6)
            java.lang.String r8 = "urgency config download"
            r5.put(r8, r7)
            java.lang.String r7 = "urgency config"
            p572qb.C12318k0.m74089a(r7, r5)
            p514o9.C11839m.m70688i(r2, r6)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            java.lang.String r1 = "version updated, query config"
            if (r0 >= 0) goto La0
            p514o9.C11839m.m70688i(r2, r1)
            r9.m79101k()
            goto Lb1
        La0:
            if (r0 != 0) goto La9
            p514o9.C11839m.m70688i(r2, r1)
            r9.m79101k()
            goto Lb1
        La9:
            java.lang.String r0 = "getVersion fail. localVersion > latestVersion"
            p514o9.C11839m.m70689w(r2, r0)
            r9.m79078G()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p674ub.C13152i.m79110x():void");
    }

    /* renamed from: y */
    public Intent m79111y(String str) throws C1416m {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (C0209d.m1251f(intent)) {
            return intent;
        }
        throw new C1416m("cannot resove intent");
    }

    /* renamed from: z */
    public void m79112z() throws Throwable {
        long jM79103p = m79103p();
        m79096f();
        C11839m.m70688i("UrgencyNoticeManager", "init");
        try {
            UrgencyNotice urgencyNoticeM79102l = m79102l();
            if (urgencyNoticeM79102l == null) {
                C11839m.m70687e("UrgencyNoticeManager", "init notice null");
                return;
            }
            UrgencyAppConfig appConfig = urgencyNoticeM79102l.getAppConfig();
            if (appConfig == null) {
                C11839m.m70687e("UrgencyNoticeManager", "init appConfig null");
                return;
            }
            m79073B(appConfig);
            m79072A(appConfig);
            m79099i(appConfig, jM79103p);
        } catch (Exception e10) {
            C11839m.m70687e("UrgencyNoticeManager", "init exception:" + e10.toString());
        }
    }
}
