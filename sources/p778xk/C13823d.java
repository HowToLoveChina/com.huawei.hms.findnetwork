package p778xk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.hicloud.bean.EntryQuestBean;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.campaign.bean.CampaignActivityConfig;
import com.huawei.hicloud.campaign.bean.CampaignEntery;
import com.huawei.hicloud.campaign.bean.ThirdAppJumpBean;
import com.huawei.hicloud.messagecenter.bean.ClientMessageBody;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.NotifyTypeAndUriGoto;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.network.embedded.C6148x2;
import gp.C10028c;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p035bk.C1248a;
import p292fn.C9733f;
import p399jk.AbstractC10896a;
import p664u0.C13108a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p743wk.C13616a;

/* renamed from: xk.d */
/* loaded from: classes6.dex */
public class C13823d {

    /* renamed from: e */
    public static long f62029e = Long.MIN_VALUE;

    /* renamed from: a */
    public long f62030a;

    /* renamed from: b */
    public long f62031b;

    /* renamed from: c */
    public final HashMap<String, Drawable> f62032c;

    /* renamed from: d */
    public final HashMap<String, String> f62033d;

    /* renamed from: xk.d$a */
    public class a extends TypeToken<List<EntryQuestBean>> {
        public a() {
        }
    }

    /* renamed from: xk.d$b */
    public static class b {

        /* renamed from: a */
        public static final C13823d f62035a = new C13823d(null);
    }

    public /* synthetic */ C13823d(a aVar) {
        this();
    }

    /* renamed from: M */
    public static void m82900M(String str, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
    }

    /* renamed from: N */
    public static void m82901N() {
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.action.updateCampaign"));
    }

    /* renamed from: O */
    public static void m82902O(long j10) {
        f62029e = j10;
    }

    /* renamed from: c */
    public static void m82903c() {
        f62029e = Long.MIN_VALUE;
    }

    /* renamed from: y */
    public static C13823d m82904y() {
        return b.f62035a;
    }

    /* renamed from: A */
    public NotifyTypeAndUriGoto m82905A(int i10, String str, Map<String, String> map) {
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = new NotifyTypeAndUriGoto();
        notifyTypeAndUriGoto.setNotifyType(NotifyConstants.TYPE_DEEPLINK);
        if ("campaignNotify_6".equals(str)) {
            notifyTypeAndUriGoto.setNotifyUri(String.format("hicloud://cloudDrive/getInfo?path=CouponCenterActivity&srcChannel=%1s", C13616a.m81910b().get(Integer.valueOf(i10))));
        } else if ("campaignNotify_8".equals(str) || "campaignNotify_9".equals(str)) {
            notifyTypeAndUriGoto.setNotifyUri(m82925i(i10, str, map));
        } else {
            notifyTypeAndUriGoto.setNotifyUri(m82924h(i10, str));
        }
        return notifyTypeAndUriGoto;
    }

    /* renamed from: B */
    public Long m82906B(Context context) {
        return Long.valueOf(C0212e0.m1359i(context, "hicloud_campaign_activity_entry_sp", "pendant_period", -1L));
    }

    /* renamed from: C */
    public Drawable m82907C(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("HiCloudCampaignManager", "getPictureWithCache filePath is null");
            return null;
        }
        try {
            Drawable drawable = this.f62032c.get(str);
            if (drawable != null) {
                return drawable;
            }
            File file = new File(str);
            if (!file.exists()) {
                NotifyLogger.m29914e("HiCloudCampaignManager", "getPictureWithCache file not exists");
                return null;
            }
            Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
            this.f62032c.put(str, drawableDecodeDrawable);
            return drawableDecodeDrawable;
        } catch (Exception e10) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "getPictureWithCache exception" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: D */
    public String m82908D(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return "";
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            ThirdAppJumpBean thirdAppJumpBean = new ThirdAppJumpBean();
            thirdAppJumpBean.setChannel(iIntValue);
            String strM82922f = m82922f(C0213f.m1377a());
            thirdAppJumpBean.setEffectTime(m82921e(strM82922f));
            if (m82911G(C0213f.m1377a(), iIntValue) && m82938v(iIntValue) != null) {
                thirdAppJumpBean.setDeepLink(m82923g(iIntValue));
                thirdAppJumpBean.setPictures(m82938v(iIntValue));
                thirdAppJumpBean.setActivityId(strM82922f);
                if (iIntValue == 4) {
                    String strM82932p = m82932p();
                    thirdAppJumpBean.setBannerTitle(C13821b.m82867w().m82896x(strM82932p));
                    thirdAppJumpBean.setBannerTitleName(strM82932p);
                }
            }
            arrayList.add(thirdAppJumpBean);
        }
        return new Gson().toJson(arrayList);
    }

    /* renamed from: E */
    public long m82909E() {
        return this.f62030a;
    }

    /* renamed from: F */
    public boolean m82910F(Context context) {
        long jM1359i = C0212e0.m1359i(context, "hicloud_campaign_activity_entry_sp", "updateTime", 0L);
        return jM1359i != 0 && System.currentTimeMillis() - jM1359i <= m82909E();
    }

    /* renamed from: G */
    public boolean m82911G(Context context, int i10) {
        if (!C10028c.m62182c0().m62413x()) {
            NotifyLogger.m29916w("HiCloudCampaignManager", "isChannelsAvailable extendFuncSwitch is false");
            return false;
        }
        if (C13821b.m82867w().m82873F(m82922f(context))) {
            NotifyLogger.m29916w("HiCloudCampaignManager", "isChannelsAvailable isActivityFinished is true");
            return false;
        }
        if (i10 == 6 && m82906B(context).longValue() != -1 && System.currentTimeMillis() - m82906B(context).longValue() < m82939w()) {
            NotifyLogger.m29916w("HiCloudCampaignManager", "isChannelsAvailable getPendantPeriod is invalid");
            return false;
        }
        if (!m82910F(context)) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "isChannelsAvailable isActivityEntryValid is false");
            return false;
        }
        Iterator it = C0212e0.m1356f(context, "hicloud_campaign_activity_entry_sp", "channels").iterator();
        while (it.hasNext()) {
            if (String.valueOf(i10).equals((String) it.next())) {
                return true;
            }
        }
        NotifyLogger.m29916w("HiCloudCampaignManager", "isChannelsAvailable not include channel");
        return false;
    }

    /* renamed from: H */
    public boolean m82912H() {
        return Math.abs(System.currentTimeMillis() - f62029e) < 60000;
    }

    /* renamed from: I */
    public boolean m82913I(Context context, int i10) {
        try {
            String strM82923g = m82923g(i10);
            if (TextUtils.isEmpty(strM82923g)) {
                return false;
            }
            Intent intent = new Intent();
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(strM82923g));
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "start goto activity exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: J */
    public final String m82914J(Context context, String str, String[] strArr) throws IOException {
        int iM82886m;
        String strM82922f = m82922f(context);
        if (TextUtils.isEmpty(strM82922f)) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "processEmptyParamsMsg getActivityId is empty");
            return str;
        }
        if (str.contains(strArr[0])) {
            String strM82898z = C13821b.m82867w().m82898z(strM82922f);
            if (!TextUtils.isEmpty(strM82898z)) {
                str = str.replace(strArr[0], strM82898z);
            }
        }
        if (str.contains(strArr[1])) {
            String strM82868A = C13821b.m82867w().m82868A(strM82922f);
            if (!TextUtils.isEmpty(strM82868A)) {
                str = str.replace(strArr[1], strM82868A);
            }
        }
        return (!str.contains(strArr[5]) || (iM82886m = C13821b.m82867w().m82886m(strM82922f)) < 0) ? str : str.replace(strArr[5], String.valueOf(iM82886m));
    }

    /* renamed from: K */
    public void m82915K(Context context, String str) {
        C0212e0.m1372v(context, "hicloud_campaign_activity_entry_sp", "entryOriginJson", str);
    }

    /* renamed from: L */
    public void m82916L(int i10, String str) {
        String strM82922f = m82922f(C0213f.m1377a());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("srcChannel", String.valueOf(C13616a.m81910b().get(Integer.valueOf(i10))));
        linkedHashMap.put("activityCode", String.valueOf(C13616a.m81909a().get(Integer.valueOf(i10))));
        linkedHashMap.put("activityId", strM82922f);
        linkedHashMap.put("notifyWay", str);
        m82900M("task_center_entry_show_event", linkedHashMap);
    }

    /* renamed from: P */
    public void m82917P(Context context, long j10) {
        C0212e0.m1370t(context, "hicloud_campaign_activity_entry_sp", "pendant_period", j10);
    }

    /* renamed from: a */
    public void m82918a() {
        long pendantPeriod;
        long taskActivityValidity;
        if (this.f62030a <= 0 || this.f62031b <= 0) {
            HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
            if (hiCloudSysParamMapM60757p != null) {
                taskActivityValidity = hiCloudSysParamMapM60757p.getTaskActivityValidity();
                pendantPeriod = hiCloudSysParamMapM60757p.getPendantPeriod();
            } else {
                pendantPeriod = 0;
                taskActivityValidity = 0;
            }
            if (taskActivityValidity > 0) {
                this.f62030a = taskActivityValidity;
            } else {
                this.f62030a = 43200000L;
            }
            if (pendantPeriod > 0) {
                this.f62031b = pendantPeriod;
            } else {
                this.f62031b = 86400000L;
            }
            NotifyLogger.m29913d("HiCloudCampaignManager", "updateInterval:" + this.f62030a + "entryCloseInterval:" + this.f62031b);
        }
    }

    /* renamed from: b */
    public void m82919b(Context context) {
        C0212e0.m1372v(context, "hicloud_campaign_activity_entry_sp", "quests", "");
    }

    /* renamed from: d */
    public void m82920d(Context context) {
        NotifyLogger.m29915i("HiCloudCampaignManager", "clearSpFile");
        C0212e0.m1351a(context, "hicloud_campaign_activity_entry_sp");
    }

    /* renamed from: e */
    public final long m82921e(String str) {
        return Math.min(m82928l(), C13821b.m82867w().m82885l(str));
    }

    /* renamed from: f */
    public String m82922f(Context context) {
        if (m82910F(context)) {
            return C0212e0.m1363m(context, "hicloud_campaign_activity_entry_sp", "activityId", "");
        }
        NotifyLogger.m29914e("HiCloudCampaignManager", "getActivityId isActivityEntryValid is false");
        return "";
    }

    /* renamed from: g */
    public String m82923g(int i10) {
        String strM1363m = C0212e0.m1363m(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "activityId", "");
        if (!TextUtils.isEmpty(strM1363m)) {
            return String.format("hicloud://cloudDrive/getInfo?path=CampaignActivity&srcChannel=%1s&activityCode=%2s&taskActivityId=%3s&url=%4s&notifyType=%5s", C13616a.m81910b().get(Integer.valueOf(i10)), C13616a.m81909a().get(Integer.valueOf(i10)), strM1363m, "", "");
        }
        NotifyLogger.m29915i("HiCloudCampaignManager", "activityId is null");
        return "";
    }

    /* renamed from: h */
    public String m82924h(int i10, String str) {
        String strM1363m = C0212e0.m1363m(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "activityId", "");
        if (!TextUtils.isEmpty(strM1363m)) {
            return String.format("hicloud://cloudDrive/getInfo?path=CampaignActivity&srcChannel=%1s&activityCode=%2s&taskActivityId=%3s&url=%4s&notifyType=%5s", C13616a.m81910b().get(Integer.valueOf(i10)), C13616a.m81909a().get(Integer.valueOf(i10)), strM1363m, "", str);
        }
        NotifyLogger.m29915i("HiCloudCampaignManager", "activityId is null");
        return "";
    }

    /* renamed from: i */
    public String m82925i(int i10, String str, Map<String, String> map) {
        if (map == null) {
            NotifyLogger.m29915i("HiCloudCampaignManager", "params is null");
            return "";
        }
        String str2 = map.get("activityId");
        String str3 = map.get("activityUrl");
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29915i("HiCloudCampaignManager", "getActivityLinkWithActivityId activityId is null");
            return "";
        }
        if (!StringUtil.isBlank(str3)) {
            return String.format("hicloud://cloudDrive/getInfo?path=CampaignActivity&srcChannel=%1s&activityCode=%2s&taskActivityId=%3s&url=%4s&notifyType=%5s", C13616a.m81910b().get(Integer.valueOf(i10)), C13616a.m81909a().get(Integer.valueOf(i10)), str2, str3, str);
        }
        NotifyLogger.m29915i("HiCloudCampaignManager", "getActivityLinkWithActivityId url is null");
        return "";
    }

    /* renamed from: j */
    public List<EntryQuestBean> m82926j(Context context) {
        if (!m82910F(context)) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "getActivityQuests isActivityEntryValid is false");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("hicloud_campaign_activity_entry_sp", 0);
            if (sharedPreferences == null) {
                return arrayList;
            }
            String string = sharedPreferences.getString("quests", "");
            return TextUtils.isEmpty(string) ? arrayList : (List) new Gson().fromJson(string, new a().getType());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiCloudCampaignManager", "get ActivityQuests exception: " + e10.getMessage());
            return arrayList;
        }
    }

    /* renamed from: k */
    public String m82927k(Context context) {
        return C0212e0.m1363m(context, "hicloud_campaign_activity_entry_sp", "entryOriginJson", "");
    }

    /* renamed from: l */
    public final long m82928l() {
        long jM1359i = C0212e0.m1359i(C0213f.m1377a(), "hicloud_campaign_activity_entry_sp", "updateTime", 0L);
        return jM1359i == 0 ? m82909E() : jM1359i + m82909E();
    }

    /* renamed from: m */
    public String m82929m(List<CommonPicture> list) {
        String strM82870C;
        if (list == null) {
            return "";
        }
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                strM82870C = "";
                break;
            }
            CommonPicture commonPicture = list.get(i10);
            if (commonPicture != null) {
                String url = commonPicture.getUrl();
                String resolution = commonPicture.getResolution();
                if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(resolution) && resolution.equals(RecommendCardConstants.Resolution.PICTURE_SECOND)) {
                    strM82870C = C13821b.m82867w().m82870C(url);
                    break;
                }
            }
            i10++;
        }
        return (!TextUtils.isEmpty(strM82870C) && new File(strM82870C).exists()) ? strM82870C : "";
    }

    /* renamed from: n */
    public String m82930n(List<CommonPicture> list, boolean z10) {
        String strM82870C;
        if (list == null) {
            return "";
        }
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                strM82870C = "";
                break;
            }
            CommonPicture commonPicture = list.get(i10);
            if (commonPicture != null) {
                String url = commonPicture.getUrl();
                String resolution = commonPicture.getResolution();
                if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(resolution)) {
                    if (z10) {
                        if (resolution.equals(RecommendCardConstants.Resolution.PHONE_LANDSCAPE)) {
                            strM82870C = C13821b.m82867w().m82870C(url);
                            break;
                        }
                    } else if (resolution.equals(RecommendCardConstants.Resolution.PHONE_PORTRAIT)) {
                        strM82870C = C13821b.m82867w().m82870C(url);
                        break;
                    }
                }
            }
            i10++;
        }
        return (!TextUtils.isEmpty(strM82870C) && new File(strM82870C).exists()) ? strM82870C : "";
    }

    /* renamed from: o */
    public String m82931o() throws IOException {
        String strM82922f = m82922f(C0213f.m1377a());
        if (TextUtils.isEmpty(strM82922f)) {
            return "";
        }
        return C13821b.m82867w().m82872E(C13821b.m82867w().m82890q(strM82922f));
    }

    /* renamed from: p */
    public String m82932p() {
        String strM82922f = m82922f(C0213f.m1377a());
        return TextUtils.isEmpty(strM82922f) ? "" : C13821b.m82867w().m82890q(strM82922f);
    }

    /* renamed from: q */
    public String m82933q(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("HiCloudCampaignManager", "getBitmapFromFile filePath is null");
            return "";
        }
        try {
            String str2 = this.f62033d.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            C1248a.m7473d(str, options);
            String str3 = options.outMimeType;
            this.f62033d.put(str, str3);
            return str3;
        } catch (Exception e10) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "getBitmapTypeWithCache exception" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: r */
    public Intent m82934r(int i10) {
        Intent intent = new Intent();
        String strM82923g = m82923g(i10);
        if (TextUtils.isEmpty(strM82923g)) {
            return intent;
        }
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(strM82923g));
        return intent;
    }

    /* renamed from: s */
    public CampaignEntery m82935s(int i10) {
        if (m82911G(C0213f.m1377a(), i10)) {
            return C13821b.m82867w().m82892s(i10, m82922f(C0213f.m1377a()));
        }
        return null;
    }

    /* renamed from: t */
    public String m82936t(Context context, String str, ClientMessageBody clientMessageBody) throws IOException {
        String strM82914J = str;
        if (strM82914J == null || clientMessageBody == null) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "getCampaignMessageText text or message is null");
            return "";
        }
        Map<String, String> params = clientMessageBody.getParams();
        boolean zEquals = "campaignNotify_1".equals(clientMessageBody.getNotifyType());
        String[] strArr = {"%{p1}", "%{p2}", "%{p3}", "%{p4}", "%{p5}", "%{p6}", "%{p7}", "%{p8}", "%{p9}"};
        String[] strArr2 = {"p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9"};
        if (params == null || params.isEmpty()) {
            strM82914J = m82914J(context, strM82914J, strArr);
        } else {
            for (int i10 = 0; i10 < 9; i10++) {
                if (strM82914J.contains(strArr[i10]) && params.containsKey(strArr2[i10]) && !TextUtils.isEmpty(params.get(strArr2[i10]))) {
                    String str2 = strArr[i10];
                    CharSequence charSequence = (String) params.get(strArr2[i10]);
                    Objects.requireNonNull(charSequence);
                    strM82914J = strM82914J.replace(str2, charSequence);
                }
            }
        }
        if (zEquals && (strM82914J.contains(strArr[0]) || strM82914J.contains(strArr[1]) || strM82914J.contains(strArr[5]))) {
            strM82914J = m82914J(context, strM82914J, strArr);
        }
        for (int i11 = 0; i11 < 9; i11++) {
            String str3 = strArr[i11];
            if (strM82914J.contains(str3)) {
                NotifyLogger.m29914e("HiCloudCampaignManager", "getCampaignMessageText has unplaced holder " + str3);
                return "";
            }
        }
        return strM82914J;
    }

    /* renamed from: u */
    public String m82937u(int i10, String str, Map<String, String> map) {
        return "campaignNotify_6".equals(str) ? String.format("hicloud://cloudDrive/getInfo?path=CouponCenterActivity&srcChannel=%1s", C13616a.m81910b().get(Integer.valueOf(i10))) : ("campaignNotify_8".equals(str) || "campaignNotify_9".equals(str)) ? m82925i(i10, str, map) : m82924h(i10, str);
    }

    /* renamed from: v */
    public final List<CommonPicture> m82938v(int i10) throws IOException {
        CampaignActivityConfig campaignActivityConfigM82883j = C13821b.m82867w().m82883j(m82922f(C0213f.m1377a()));
        if (campaignActivityConfigM82883j != null && campaignActivityConfigM82883j.getEnterys() != null) {
            for (CampaignEntery campaignEntery : campaignActivityConfigM82883j.getEnterys()) {
                if (campaignEntery != null && campaignEntery.getChannel() != null && campaignEntery.getPictures() != null && String.valueOf(i10).equals(campaignEntery.getChannel())) {
                    return campaignEntery.getPictures();
                }
            }
        }
        return null;
    }

    /* renamed from: w */
    public long m82939w() {
        return this.f62031b;
    }

    /* renamed from: x */
    public String m82940x(int i10) {
        try {
            List<CommonPicture> listM82938v = m82938v(i10);
            if (listM82938v != null && listM82938v.size() != 0 && listM82938v.get(0) != null) {
                return C13821b.m82867w().m82870C(listM82938v.get(0).getUrl());
            }
            return "";
        } catch (Exception e10) {
            NotifyLogger.m29914e("HiCloudCampaignManager", "getFloatViewPictureByChannel exception: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: z */
    public NotifyTypeAndUriGoto m82941z(int i10) {
        NotifyTypeAndUriGoto notifyTypeAndUriGoto = new NotifyTypeAndUriGoto();
        notifyTypeAndUriGoto.setNotifyType(NotifyConstants.TYPE_DEEPLINK);
        notifyTypeAndUriGoto.setNotifyUri(m82923g(i10));
        return notifyTypeAndUriGoto;
    }

    public C13823d() {
        this.f62032c = new HashMap<>();
        this.f62033d = new HashMap<>();
        m82918a();
    }
}
