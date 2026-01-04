package p805yb;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.google.gson.Gson;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.languageoperator.NpsNotifyLanguageOperator;
import com.huawei.hicloud.notification.task.QueryHiCloudBannerPicturesTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5023q;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0234s;
import p015ak.C0241z;
import p292fn.C9734g;
import p514o9.C11839m;
import p616rk.C12515a;
import p705vb.C13392a;
import p705vb.C13393b;
import p705vb.C13394c;
import p705vb.C13395d;
import p705vb.C13396e;
import p735wb.C13580a;
import p769xb.C13737a;
import pk.C12158a;

/* renamed from: yb.c */
/* loaded from: classes3.dex */
public class C13933c {

    /* renamed from: a */
    public static C13933c f62486a;

    /* renamed from: b */
    public static final Object f62487b = new Object();

    /* renamed from: n */
    public static C13933c m83668n() {
        C13933c c13933c;
        synchronized (f62487b) {
            try {
                if (f62486a == null) {
                    f62486a = new C13933c();
                }
                c13933c = f62486a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13933c;
    }

    /* renamed from: t */
    public static /* synthetic */ void m83669t(StringBuilder sb2, String str, String str2) {
        sb2.append("&");
        sb2.append(str);
        sb2.append("=");
        sb2.append(str2);
    }

    /* renamed from: b */
    public String m83670b(String str) {
        if (!str.contains(Constants.QUESTION_STR)) {
            return str;
        }
        HashMap map = new HashMap();
        map.put("appVersion", C1443a.f6213a);
        map.put(FaqConstants.FAQ_MODEL, Build.MODEL);
        map.put(FaqConstants.FAQ_OSVERSION, C0209d.m1186L());
        map.put(JsbMapKeyNames.H5_DEVICE_TYPE, C0209d.m1170F1() ? "pad" : "phone");
        return str + m83671c(map);
    }

    /* renamed from: c */
    public final String m83671c(Map<String, String> map) {
        final StringBuilder sb2 = new StringBuilder();
        map.forEach(new BiConsumer() { // from class: yb.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                C13933c.m83669t(sb2, (String) obj, (String) obj2);
            }
        });
        return sb2.toString();
    }

    /* renamed from: d */
    public boolean m83672d() {
        Context contextM1377a = C0213f.m1377a();
        String strM1363m = C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, "");
        if (TextUtils.isEmpty(strM1363m)) {
            return true;
        }
        return strM1363m.equals(C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_CLICK_ID, ""));
    }

    /* renamed from: e */
    public void m83673e() {
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("NPSInfoManager", "clearNPSInfoConfig context is null.");
                return;
            }
            C0212e0.m1351a(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP);
            File file = new File(contextM1377a.getFilesDir() + "/HiCloudNPSConfig.json");
            if (!file.exists()) {
                C11839m.m70688i("NPSInfoManager", "clearNPSInfoConfig file not exist");
            } else {
                if (file.delete()) {
                    return;
                }
                C11839m.m70687e("NPSInfoManager", "clearNPSInfoConfig deleteResult is false");
            }
        } catch (Exception e10) {
            C11839m.m70687e("NPSInfoManager", "clearNPSInfoConfig exception:" + e10.toString());
        }
    }

    /* renamed from: f */
    public void m83674f(ClientMessageBody clientMessageBody) throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("NPSInfoManager", "dealNotification context is null.");
            return;
        }
        if (clientMessageBody == null) {
            C11839m.m70688i("NPSInfoManager", "dealNotification message is null.");
            return;
        }
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        if (TextUtils.isEmpty(cfgResourceId)) {
            C11839m.m70688i("NPSInfoManager", "dealNotification configId is null.");
            return;
        }
        C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, cfgResourceId);
        C13393b c13393bM81582a = new C13580a().m81582a();
        if (c13393bM81582a == null) {
            C11839m.m70688i("NPSInfoManager", "dealNotification configRootBean is null.");
            return;
        }
        C13395d c13395dM83683p = m83683p(c13393bM81582a, cfgResourceId);
        if (c13395dM83683p == null) {
            C11839m.m70688i("NPSInfoManager", "dealNotification npsConfigBean is null.");
            return;
        }
        if (TextUtils.isEmpty(c13395dM83683p.m80495k())) {
            C11839m.m70688i("NPSInfoManager", "dealNotification url is null.");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0212e0.m1372v(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_PUSH_DATE, new SimpleDateFormat("yyyy-MM-dd").format(new Date(jCurrentTimeMillis)));
        if (m83686s(contextM1377a, c13395dM83683p)) {
            C13396e c13396eM80493i = c13395dM83683p.m80493i();
            if (c13396eM80493i == null) {
                C11839m.m70688i("NPSInfoManager", "dealNotification notifyBar is null.");
                return;
            }
            m83681m();
            if (cfgResourceId.equals(C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_CLICK_ID, ""))) {
                C11839m.m70688i("NPSInfoManager", "dealNotification has deal.");
                return;
            }
            String strM83685r = m83685r(c13396eM80493i.m80497b());
            String strM83685r2 = m83685r(c13396eM80493i.m80496a());
            if (TextUtils.isEmpty(strM83685r2) || TextUtils.isEmpty(strM83685r)) {
                C11839m.m70688i("NPSInfoManager", "dealNotification content is null.");
            } else {
                C13934d.m83693b().m83696d(strM83685r, strM83685r2);
            }
        }
    }

    /* renamed from: g */
    public void m83675g() {
        C13934d.m83693b().m83694a();
        Context contextM1377a = C0213f.m1377a();
        C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_CLICK_ID, C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, ""));
    }

    /* renamed from: h */
    public boolean m83676h() throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("NPSInfoManager", "dealNpsConfigResult context is null.");
            return false;
        }
        if (m83672d()) {
            C11839m.m70688i("NPSInfoManager", "dealNpsConfigResult has click.");
            return false;
        }
        C13393b c13393bM81582a = new C13580a().m81582a();
        if (c13393bM81582a == null) {
            C11839m.m70688i("NPSInfoManager", "dealNpsConfigResult configRootBean is null.");
            return true;
        }
        C13395d c13395dM83683p = m83683p(c13393bM81582a, C0212e0.m1363m(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, ""));
        if (c13395dM83683p == null) {
            C11839m.m70688i("NPSInfoManager", "dealNpsConfigResult npsConfigBean is null.");
            return true;
        }
        if (!m83686s(contextM1377a, c13395dM83683p)) {
            C11839m.m70688i("NPSInfoManager", "dealNpsConfigResult param is dissatisfy.");
            return false;
        }
        m83681m();
        m83691y(contextM1377a, c13395dM83683p.m80491g());
        m83679k(c13395dM83683p, c13393bM81582a.m80480c());
        return false;
    }

    /* renamed from: i */
    public void m83677i(ClientMessageBody clientMessageBody) throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushBannerType context is null.");
            return;
        }
        if (clientMessageBody == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushBannerType message is null.");
            return;
        }
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        if (TextUtils.isEmpty(cfgResourceId)) {
            C11839m.m70688i("NPSInfoManager", "dealPushBannerType configId is null.");
            return;
        }
        if (TextUtils.isEmpty(cfgResourceId)) {
            C11839m.m70688i("NPSInfoManager", "dealPushBannerType context is null.");
            return;
        }
        C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, cfgResourceId);
        C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ENTRY, "banner");
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0212e0.m1372v(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_PUSH_DATE, new SimpleDateFormat("yyyy-MM-dd").format(new Date(jCurrentTimeMillis)));
        C13393b c13393bM81582a = new C13580a().m81582a();
        if (c13393bM81582a == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushBannerType configRootBean is null.");
            return;
        }
        C13395d c13395dM83683p = m83683p(c13393bM81582a, cfgResourceId);
        if (c13395dM83683p == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushBannerType npsConfigBean is null.");
        } else {
            m83686s(contextM1377a, c13395dM83683p);
            m83679k(c13395dM83683p, c13393bM81582a.m80480c());
        }
    }

    /* renamed from: j */
    public void m83678j(ClientMessageBody clientMessageBody) throws Throwable {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushMenuType context is null.");
            return;
        }
        if (clientMessageBody == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushMenuType message is null.");
            return;
        }
        String cfgResourceId = clientMessageBody.getCfgResourceId();
        if (TextUtils.isEmpty(cfgResourceId)) {
            C11839m.m70688i("NPSInfoManager", "dealPushMenuType configId is null.");
            return;
        }
        C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ID, cfgResourceId);
        C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ENTRY, "menu");
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0212e0.m1372v(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_PUSH_DATE, new SimpleDateFormat("yyyy-MM-dd").format(new Date(jCurrentTimeMillis)));
        C13393b c13393bM81582a = new C13580a().m81582a();
        if (c13393bM81582a == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushMenuType configRootBean is null.");
            return;
        }
        C13395d c13395dM83683p = m83683p(c13393bM81582a, cfgResourceId);
        if (c13395dM83683p == null) {
            C11839m.m70688i("NPSInfoManager", "dealPushMenuType npsConfigBean is null.");
        } else {
            m83686s(contextM1377a, c13395dM83683p);
        }
    }

    /* renamed from: k */
    public void m83679k(C13395d c13395d, Map<String, CommonPicture> map) {
        if (c13395d == null || map == null) {
            C11839m.m70688i("NPSInfoManager", "downloadBanner param is null.");
            return;
        }
        if (!"banner".equals(c13395d.m80491g())) {
            C11839m.m70686d("NPSInfoManager", "downloadBanner is not banner entry.");
            return;
        }
        String[] strArrM80494j = c13395d.m80494j();
        if (strArrM80494j == null || strArrM80494j.length <= 0) {
            return;
        }
        CommonPicture commonPicture = map.get(strArrM80494j[0]);
        if (commonPicture == null) {
            C11839m.m70687e("NPSInfoManager", "downloadBanner commonPicture is null");
            return;
        }
        String url = commonPicture.getUrl();
        if (TextUtils.isEmpty(url)) {
            C11839m.m70687e("NPSInfoManager", "downloadBanner url is null.");
            return;
        }
        if (RecommendCardConstants.Resolution.PICTURE_SECOND.equals(commonPicture.getResolution())) {
            C0212e0.m1372v(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_BANNER_PICTURE_SECOND_URL, url);
        }
        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(new CommonPicture[]{commonPicture}), false);
    }

    /* renamed from: l */
    public final void m83680l(C5023q c5023q) {
        C11839m.m70688i("NPSInfoManager", "downloadConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                C11839m.m70687e("NPSInfoManager", "getLatestConfig exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudNPSConfig")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    C11839m.m70688i("NPSInfoManager", "getLatestConfig HTTP_NOT_MODIFY");
                    return;
                } else {
                    if (!c5023q.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    C11839m.m70688i("NPSInfoManager", "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (c5023q.getLatestConfig()) {
                C11839m.m70688i("NPSInfoManager", "getLatestConfig OK");
                C9734g.m60767a().m60769c("HiCloudNPSConfig");
                return;
            }
            C11839m.m70687e("NPSInfoManager", "getLatestConfig failed");
            if (i10 >= 2) {
                return;
            }
            C11839m.m70688i("NPSInfoManager", "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    /* renamed from: m */
    public void m83681m() throws Throwable {
        C13393b c13393bM81582a = new C13580a().m81582a();
        if (c13393bM81582a == null) {
            C11839m.m70688i("NPSInfoManager", "dealNpsConfigResult configRootBean is null.");
        } else {
            new C13931a().extractCommonLanguage(c13393bM81582a.m80479b());
        }
    }

    /* renamed from: o */
    public final List<CommonLanguageDbString> m83682o(String str, String str2, String str3) {
        return new NpsNotifyLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    /* renamed from: p */
    public C13395d m83683p(C13393b c13393b, String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("NPSInfoManager", "getNpsConfigBean spDataId is null.");
            return null;
        }
        List<C13392a> listM80478a = c13393b.m80478a();
        if (listM80478a != null) {
            Iterator<C13392a> it = listM80478a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C13392a next = it.next();
                if (next != null) {
                    List<C13395d> listM80477a = next.m80477a();
                    if (!listM80477a.isEmpty()) {
                        for (C13395d c13395d : listM80477a) {
                            if (str.equals(c13395d.m80492h())) {
                                return c13395d;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: q */
    public Intent m83684q() {
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("com.huawei.hicloud.action.NPS_SHOW");
        return intent;
    }

    /* renamed from: r */
    public String m83685r(String str) {
        return NotifyUtil.getStringFromConfig(str, true, true, m83682o(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    /* renamed from: s */
    public boolean m83686s(Context context, C13395d c13395d) {
        if (context == null) {
            C11839m.m70688i("NPSInfoManager", "initNpsParam context is null.");
            return false;
        }
        if (c13395d == null) {
            C11839m.m70688i("NPSInfoManager", "initNpsParam npsConfigBean is null.");
            return false;
        }
        try {
            C0212e0.m1368r(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_EFFECTIVE_DAY, C0241z.m1685c(c13395d.m80488d()));
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_START_SHOW_DATE, c13395d.m80489e());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_END_SHOW_DATE, c13395d.m80490f());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_DAY_BEGIN_TIME, c13395d.m80486b());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_DAY_END_TIME, c13395d.m80487c());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL, c13395d.m80495k());
            C13394c c13394cM80485a = c13395d.m80485a();
            if (c13394cM80485a == null) {
                return true;
            }
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_TITLE_ID, c13394cM80485a.m80484d());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_REMARK_ID, c13394cM80485a.m80483c());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_DESCRIPTION_ID, c13394cM80485a.m80482b());
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_BUTTON_ID, c13394cM80485a.m80481a());
            return true;
        } catch (Exception e10) {
            C11839m.m70688i("NPSInfoManager", "initNpsParam Exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: u */
    public String m83687u(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("NPSInfoManager", "original url is null");
            return str;
        }
        try {
            String strM72864a = C12158a.m72864a(str, Constants.UTF_8);
            Map<String, String> mapM83690x = m83690x();
            if (mapM83690x == null || mapM83690x.size() == 0) {
                C11839m.m70687e("NPSInfoManager", "decode map no size.");
                return str;
            }
            for (Map.Entry<String, String> entry : mapM83690x.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key)) {
                    if (TextUtils.isEmpty(value)) {
                        value = HNConstants.DataType.f22634NA;
                    }
                    strM72864a = strM72864a.replace("${" + key + "}", value);
                }
            }
            return m83670b(strM72864a);
        } catch (C9721b e10) {
            C11839m.m70687e("NPSInfoManager", "decode url exception: " + e10.toString());
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudNPSConfig") >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        p514o9.C11839m.m70688i("NPSInfoManager", "version updated, query config");
        m83680l(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        m83681m();
        p514o9.C11839m.m70688i("NPSInfoManager", "version not update, update view");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        return false;
     */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m83688v(com.huawei.hicloud.service.C5023q r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "queryConfigVersion"
            java.lang.String r1 = "NPSInfoManager"
            p514o9.C11839m.m70688i(r1, r0)
            if (r8 != 0) goto Lf
            com.huawei.hicloud.service.q r8 = new com.huawei.hicloud.service.q
            r0 = 0
            r8.<init>(r0)
        Lf:
            r0 = 0
            r2 = r0
        L11:
            r3 = 2
            if (r2 > r3) goto L52
            long r2 = r8.getConfigVersion()     // Catch: fk.C9721b -> L19
            goto L54
        L19:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "queryConfigVersion exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70687e(r1, r5)
            boolean r4 = r8.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L51
            if (r2 >= r3) goto L51
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "queryConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            p514o9.C11839m.m70688i(r1, r3)
            int r2 = r2 + 1
            goto L11
        L51:
            return r0
        L52:
            r2 = 0
        L54:
            java.lang.String r4 = "HiCloudNPSConfig"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L68
            java.lang.String r0 = "version updated, query config"
            p514o9.C11839m.m70688i(r1, r0)
            r7.m83680l(r8)
            r7 = 1
            return r7
        L68:
            r7.m83681m()
            java.lang.String r7 = "version not update, update view"
            p514o9.C11839m.m70688i(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p805yb.C13933c.m83688v(com.huawei.hicloud.service.q):boolean");
    }

    /* renamed from: w */
    public void m83689w(String str) {
        C12515a.m75110o().m75172d(new C13737a(str));
    }

    /* renamed from: x */
    public Map<String, String> m83690x() {
        try {
            return (Map) new Gson().fromJson(C0212e0.m1363m(C0213f.m1377a(), FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL_PARAMS, ""), Map.class);
        } catch (Exception e10) {
            C11839m.m70687e("NPSInfoManager", "readParamsFromLocal error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: y */
    public final void m83691y(Context context, String str) {
        if (context == null) {
            C11839m.m70688i("NPSInfoManager", "setEntry context is null.");
            return;
        }
        str.hashCode();
        if (str.equals("banner") || str.equals("menu")) {
            C0212e0.m1372v(context, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_ENTRY, str);
            return;
        }
        C11839m.m70688i("NPSInfoManager", "setEntry entry dissatisfy: " + str);
    }

    /* renamed from: z */
    public void m83692z(Map<String, String> map) {
        Context contextM1377a = C0213f.m1377a();
        if (map == null || map.size() == 0) {
            C11839m.m70688i("NPSInfoManager", "transParamToJson map is null.");
        } else {
            C0212e0.m1372v(contextM1377a, FrequencyManager.CHECK_NSP_SHOW_INFO_SP, FrequencyManager.CHECK_NSP_UPDATE_DATA_URL_PARAMS, new JSONObject(map).toString());
        }
    }
}
