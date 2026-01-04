package p454lj;

import android.content.Context;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5TaskCacheBean;
import com.huawei.cloud.pay.model.OrderPrefission;
import com.huawei.cloud.pay.model.OrderPrefissionQuest;
import fj.C9718g;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p672u8.C13135e;

/* renamed from: lj.c */
/* loaded from: classes5.dex */
public class C11280c {

    /* renamed from: a */
    public static String f52919a;

    /* renamed from: a */
    public static boolean m67694a(H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBean.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70686d("CampaignPrefissionUtils", "checkBusinessPayReport false");
            return false;
        }
        C11839m.m70688i("CampaignPrefissionUtils", "checkBusinessPayReport");
        return true;
    }

    /* renamed from: b */
    public static boolean m67695b(H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBean.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70686d("CampaignPrefissionUtils", "checkBusinessSignReport false");
            return false;
        }
        C11839m.m70688i("CampaignPrefissionUtils", "checkBusinessSignReport");
        return true;
    }

    /* renamed from: c */
    public static boolean m67696c(H5TaskCacheBean h5TaskCacheBean) {
        if (h5TaskCacheBean == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long startTime = h5TaskCacheBean.getStartTime();
        if (jCurrentTimeMillis < startTime || jCurrentTimeMillis - startTime > C9718g.m60602t().m60643y()) {
            C11839m.m70686d("CampaignPrefissionUtils", "checkBusinessUpgradeReport false");
            return false;
        }
        C11839m.m70688i("CampaignPrefissionUtils", "checkBusinessUpgradeReport");
        return true;
    }

    /* renamed from: d */
    public static void m67697d() {
        Context contextM1377a = C0213f.m1377a();
        C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "business_pay");
        C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "business_upgrade");
        C0212e0.m1375y(contextM1377a, "com.huawei.hidisk.campaign.config_quests", "business_sign");
    }

    /* renamed from: e */
    public static H5TaskCacheBean m67698e() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "business_pay", "");
        if (strM1364n == null) {
            return null;
        }
        try {
            return (H5TaskCacheBean) C13135e.m79002b(strM1364n, H5TaskCacheBean.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70686d("CampaignPrefissionUtils", "getBusinessPayTime json is: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public static H5TaskCacheBean m67699f() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "business_sign", "");
        if (strM1364n == null) {
            return null;
        }
        try {
            return (H5TaskCacheBean) C13135e.m79002b(strM1364n, H5TaskCacheBean.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70686d("CampaignPrefissionUtils", "getBusinessSignTime json exception: " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public static H5TaskCacheBean m67700g() {
        String strM1364n = C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "business_upgrade", "");
        if (strM1364n == null) {
            return null;
        }
        try {
            return (H5TaskCacheBean) C13135e.m79002b(strM1364n, H5TaskCacheBean.class);
        } catch (JsonSyntaxException e10) {
            C11839m.m70689w("CampaignPrefissionUtils", "getBusinessUpgradeTime error is :" + e10.getMessage());
            return null;
        }
    }

    /* renamed from: h */
    public static String m67701h() {
        return f52919a;
    }

    /* renamed from: i */
    public static OrderPrefission m67702i() {
        H5TaskCacheBean h5TaskCacheBeanM67698e = m67698e();
        if (m67694a(h5TaskCacheBeanM67698e)) {
            OrderPrefission orderPrefission = new OrderPrefission();
            orderPrefission.setActivityCode(h5TaskCacheBeanM67698e.getActivityId());
            orderPrefission.setActivityName("");
            orderPrefission.setActivitySource(2);
            OrderPrefissionQuest orderPrefissionQuest = new OrderPrefissionQuest();
            orderPrefissionQuest.setQuestId(h5TaskCacheBeanM67698e.getQuestId());
            orderPrefissionQuest.setSessionId(h5TaskCacheBeanM67698e.getSessionId());
            orderPrefission.setQuest(orderPrefissionQuest);
            return orderPrefission;
        }
        H5TaskCacheBean h5TaskCacheBeanM67700g = m67700g();
        if (m67696c(h5TaskCacheBeanM67700g)) {
            OrderPrefission orderPrefission2 = new OrderPrefission();
            orderPrefission2.setActivityCode(h5TaskCacheBeanM67700g.getActivityId());
            orderPrefission2.setActivityName("");
            orderPrefission2.setActivitySource(2);
            OrderPrefissionQuest orderPrefissionQuest2 = new OrderPrefissionQuest();
            orderPrefissionQuest2.setQuestId(h5TaskCacheBeanM67700g.getQuestId());
            orderPrefissionQuest2.setSessionId(h5TaskCacheBeanM67700g.getSessionId());
            orderPrefission2.setQuest(orderPrefissionQuest2);
            return orderPrefission2;
        }
        H5TaskCacheBean h5TaskCacheBeanM67699f = m67699f();
        if (!m67695b(h5TaskCacheBeanM67699f)) {
            return null;
        }
        OrderPrefission orderPrefission3 = new OrderPrefission();
        orderPrefission3.setActivityCode(h5TaskCacheBeanM67699f.getActivityId());
        orderPrefission3.setActivityName("");
        orderPrefission3.setActivitySource(2);
        OrderPrefissionQuest orderPrefissionQuest3 = new OrderPrefissionQuest();
        orderPrefissionQuest3.setQuestId(h5TaskCacheBeanM67699f.getQuestId());
        orderPrefissionQuest3.setSessionId(h5TaskCacheBeanM67699f.getSessionId());
        orderPrefission3.setQuest(orderPrefissionQuest3);
        return orderPrefission3;
    }

    /* renamed from: j */
    public static void m67703j(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "business_pay", str);
    }

    /* renamed from: k */
    public static void m67704k(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "business_sign", str);
    }

    /* renamed from: l */
    public static void m67705l(String str) {
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "business_upgrade", str);
    }

    /* renamed from: m */
    public static void m67706m(String str) {
        f52919a = str;
    }
}
