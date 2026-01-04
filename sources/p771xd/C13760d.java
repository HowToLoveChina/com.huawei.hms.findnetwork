package p771xd;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.BackupHomepageNotificationCardBean;
import com.huawei.hicloud.bean.BackupHomepageNotificationCardItemBean;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import p015ak.C0213f;
import p292fn.C9733f;
import p371ik.C10527a;
import p514o9.C11839m;
import p654tb.C13002a;
import p654tb.C13003b;
import p654tb.C13004c;
import p815ym.AbstractC14026a;

/* renamed from: xd.d */
/* loaded from: classes3.dex */
public class C13760d implements ISpaceRemindHandler {

    /* renamed from: a */
    public final Map<String, Map<String, Integer>> f61862a = new HashMap();

    /* renamed from: b */
    public String f61863b;

    /* renamed from: c */
    public final C13003b f61864c;

    public C13760d(C13003b c13003b) {
        this.f61864c = c13003b;
        m82658h();
    }

    /* renamed from: i */
    public static /* synthetic */ boolean m82653i(String str, BackupHomepageNotificationCardItemBean backupHomepageNotificationCardItemBean) {
        return str.equals(backupHomepageNotificationCardItemBean.getType());
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: a */
    public C13004c mo24386a() {
        try {
            C13003b c13003b = this.f61864c;
            if (c13003b == null) {
                C11839m.m70689w("CardDataHandler", "context is null");
                return C13004c.m78185a("context is null", null, null, false);
            }
            String strM78179c = c13003b.m78179c();
            this.f61863b = strM78179c;
            if (strM78179c == null) {
                C11839m.m70687e("CardDataHandler", "userSpaceState is null");
                return C13004c.m78185a("userSpaceState is null", null, null, false);
            }
            BackupHomepageNotificationCardItemBean backupHomepageNotificationCardItemBeanM82656f = m82656f(strM78179c);
            if (backupHomepageNotificationCardItemBeanM82656f == null) {
                C11839m.m70689w("CardDataHandler", "configBeans is null");
                return C13004c.m78185a("configBeans is null", this.f61863b, null, false);
            }
            C13002a c13002a = new C13002a();
            c13002a.m78175j(m82657g(this.f61863b));
            c13002a.m78172g(m82655e(backupHomepageNotificationCardItemBeanM82656f.getContent(), "content"));
            c13002a.m78176k(m82655e(backupHomepageNotificationCardItemBeanM82656f.getTitle(), "title"));
            c13002a.m78174i(m82655e(backupHomepageNotificationCardItemBeanM82656f.getButton(), "button"));
            c13002a.m78173h(backupHomepageNotificationCardItemBeanM82656f.getDeeplink());
            this.f61864c.m78182f(c13002a);
            return C13004c.m78186f(this.f61863b, c13002a, false);
        } catch (Exception e10) {
            C11839m.m70687e("CardDataHandler", "CardDataHandler handle error:" + e10.getMessage());
            return C13004c.m78185a("CardDataHandler handle error", null, null, false);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.handler.ISpaceRemindHandler
    /* renamed from: b */
    public boolean mo24387b() {
        C13003b c13003b = this.f61864c;
        return (c13003b == null || !c13003b.m78180d() || "spaceNormal".equals(this.f61864c.m78179c())) ? false : true;
    }

    /* renamed from: d */
    public final String m82654d(String str) {
        Integer num;
        if (TextUtils.isEmpty(this.f61863b) || TextUtils.isEmpty(str)) {
            C11839m.m70687e("CardDataHandler", "userSpaceState or textType is empty.");
            return "";
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CardDataHandler", "context is null.");
            return "";
        }
        Map<String, Integer> map = this.f61862a.get(this.f61863b);
        return (map == null || (num = map.get(str)) == null) ? "" : contextM1377a.getString(num.intValue());
    }

    /* renamed from: e */
    public final String m82655e(String str, String str2) {
        String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage(str);
        if (!TextUtils.isEmpty(spaceMultLanguage)) {
            return spaceMultLanguage;
        }
        C11839m.m70688i("CardDataHandler", "get default multiLanguage,textType:" + str2);
        return m82654d(str2);
    }

    /* renamed from: f */
    public final BackupHomepageNotificationCardItemBean m82656f(final String str) {
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C11839m.m70687e("CardDataHandler", "sysParamMap is null");
            return null;
        }
        BackupHomepageNotificationCardBean backupHomepageNotificationCardBean = (BackupHomepageNotificationCardBean) C10527a.m64629g(hiCloudSysParamMapM60758q.getBackupHomepageNotificationCard(), BackupHomepageNotificationCardBean.class);
        if (backupHomepageNotificationCardBean == null) {
            C11839m.m70687e("CardDataHandler", "config bean is null");
            return null;
        }
        List<BackupHomepageNotificationCardItemBean> notificationCards = backupHomepageNotificationCardBean.getNotificationCards();
        if (!AbstractC14026a.m84159a(notificationCards)) {
            return notificationCards.stream().filter(new Predicate() { // from class: xd.c
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C13760d.m82653i(str, (BackupHomepageNotificationCardItemBean) obj);
                }
            }).findFirst().orElse(null);
        }
        C11839m.m70687e("CardDataHandler", "config items is empty");
        return null;
    }

    /* renamed from: g */
    public final int m82657g(String str) {
        return (CloudBackupConstant.RestoreDataDictionaryType.FULL.equals(str) || "fullHighLevel".equals(str)) ? R$drawable.icon_space_already_full : R$drawable.icon_space_almost_full;
    }

    /* renamed from: h */
    public final void m82658h() {
        HashMap map = new HashMap();
        int i10 = R$string.cloudbackup_space_almost_full_title;
        map.put("title", Integer.valueOf(i10));
        map.put("content", Integer.valueOf(R$string.cloudbackup_space_almost_full_content));
        int i11 = R$string.increase_cloud_space_btn;
        map.put("button", Integer.valueOf(i11));
        this.f61862a.put("almostFull", map);
        HashMap map2 = new HashMap();
        map2.put("title", Integer.valueOf(i10));
        map2.put("content", Integer.valueOf(R$string.cloudbackup_space_almost_full_highest_level_content));
        int i12 = R$string.managing_space;
        map2.put("button", Integer.valueOf(i12));
        this.f61862a.put("almostFullHighLevel", map2);
        HashMap map3 = new HashMap();
        int i13 = R$string.cloudbackup_space_already_full_title;
        map3.put("title", Integer.valueOf(i13));
        map3.put("content", Integer.valueOf(R$string.cloudbackup_space_already_full_content));
        map3.put("button", Integer.valueOf(i11));
        this.f61862a.put(CloudBackupConstant.RestoreDataDictionaryType.FULL, map3);
        HashMap map4 = new HashMap();
        map4.put("title", Integer.valueOf(i13));
        map4.put("content", Integer.valueOf(R$string.cloudbackup_space_already_full_highest_level_content));
        map4.put("button", Integer.valueOf(i12));
        this.f61862a.put("fullHighLevel", map4);
        HashMap map5 = new HashMap();
        map5.put("title", Integer.valueOf(R$string.cloudbackup_premium_plan_will_expiration_title));
        map5.put("content", Integer.valueOf(R$string.cloudbackup_premium_plan_will_expiration_content));
        map5.put("button", Integer.valueOf(R$string.cloudbackup_subscribe_to_premium));
        this.f61862a.put("planAboutToExpire", map5);
    }
}
