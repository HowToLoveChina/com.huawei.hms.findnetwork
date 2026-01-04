package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.commonlib.space.FullQuotaInfo;
import com.huawei.android.hicloud.commonlib.space.QuotaInfoRsp;
import com.huawei.android.hicloud.commonlib.space.UsedSpaceInfo;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import gp.C10028c;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0223k;
import p336he.C10155f;
import p459lp.C11333k;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13227f;
import p703v8.C13367d;
import p703v8.C13375l;
import p703v8.C13378o;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class SettingTabProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11976a = new UriMatcher(-1);

    /* renamed from: com.huawei.android.hicloud.common.provider.SettingTabProvider$a */
    public static class C2757a extends AbstractC12367d {

        /* renamed from: a */
        public UsedSpaceInfo f11977a;

        /* renamed from: b */
        public CountDownLatch f11978b;

        public C2757a(UsedSpaceInfo usedSpaceInfo, CountDownLatch countDownLatch) {
            this.f11977a = usedSpaceInfo;
            this.f11978b = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            UsedSpaceInfo usedSpaceInfo = this.f11977a;
            if (usedSpaceInfo == null) {
                C11839m.m70687e("QuotaModuleInfoTask", "mSpaceInfo is null");
                this.f11978b.countDown();
                return;
            }
            try {
                String service = usedSpaceInfo.getService();
                long jM80300a = new C13375l().m80300a(this.f11977a.getUrl());
                C11839m.m70688i("QuotaModuleInfoTask", "service=" + service + ", result=" + jM80300a);
                this.f11977a.setUsed(jM80300a);
                this.f11978b.countDown();
            } catch (Exception e10) {
                C11839m.m70688i("QuotaModuleInfoTask", "service=" + this.f11977a.getService() + ", exception=" + e10.toString());
                this.f11977a.setUsed(-1L);
                this.f11978b.countDown();
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DATA_ANALYZE;
        }
    }

    /* renamed from: e */
    public static boolean m15717e() {
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("is_already_configed_NV4");
        boolean zM62395t12 = C10028c.m62182c0().m62395t1("is_all_guide_over");
        C11839m.m70688i("SettingTabProvider", "isConfigTag: " + zM62395t1 + ", isAllGuideOver: " + zM62395t12);
        return zM62395t1 && zM62395t12;
    }

    /* renamed from: a */
    public final void m15718a(Context context, List<UsedSpaceInfo> list, String str, JSONArray jSONArray) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("moduleKey", str);
        for (UsedSpaceInfo usedSpaceInfo : list) {
            if (usedSpaceInfo == null) {
                throw new C9721b(4003, "module is null");
            }
            if (str.equals(usedSpaceInfo.getKey())) {
                long used = usedSpaceInfo.getUsed();
                if (used == -1) {
                    throw new C9721b(4003, "get moduleUsed fail, moduleKey: " + str);
                }
                String strM1524g = C0223k.m1524g(context, used);
                if (TextUtils.isEmpty(strM1524g)) {
                    throw new C9721b(4003, "moduleUsedStr is empty");
                }
                jSONObject.put("moduleName", m15720c(context, str));
                jSONObject.put("moduleUsed", used);
                jSONObject.put("moduleUsedStr", strM1524g);
                jSONArray.put(jSONObject);
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m15719b(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject.length() != 0) {
                return;
            }
            C11839m.m70689w("SettingTabProvider", "load data error");
            if (C0209d.m1333z1(context)) {
                C11839m.m70689w("SettingTabProvider", "unknown error");
                m15724h(jSONObject, 5, null, context.getString(R$string.connect_server_fail_msg1), null);
            } else {
                C11839m.m70689w("SettingTabProvider", "network not connected");
                m15724h(jSONObject, 6, null, context.getString(R$string.network_unavailable), context.getString(R$string.set_net));
            }
        } catch (JSONException e10) {
            C11839m.m70687e("SettingTabProvider", "checkData exception: " + e10.toString());
        }
    }

    /* renamed from: c */
    public String m15720c(Context context, String str) throws Exception {
        str.hashCode();
        switch (str) {
            case "backup":
                return context.getString(R$string.space_display_backup_title);
            case "family":
                return context.getString(R$string.space_display_family_title);
            case "photos":
                return context.getString(R$string.space_display_photos_title);
            case "drive":
                return context.getString(R$string.space_display_drive_title);
            case "other":
                return context.getString(R$string.space_display_other_title);
            default:
                throw new C9721b(4003, "match moduleKey fail: " + str);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C11839m.m70688i("SettingTabProvider", "call is support :" + str);
        if (!"checkMenuIsSupportToShow".equals(str)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("IS_SUPPORT", m15717e() && !C13452e.m80781L().m80791C0());
        return bundle2;
    }

    /* renamed from: d */
    public final Cursor m15721d(Context context) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"is_cloud_enable"});
        JSONObject jSONObject = new JSONObject();
        try {
            if (!m15717e()) {
                C11839m.m70688i("SettingTabProvider", "not enable cloud");
                m15724h(jSONObject, 1, context.getString(R$string.setting_tab_title), context.getString(R$string.setting_tab_unlogin_content), context.getString(R$string.setting_tab_enable_cloud));
            } else if (!C10155f.m63251D() || ModuleConfigUtil.getInstance().isAllModuleDisabledIncludePhonefinder(context)) {
                C11839m.m70688i("SettingTabProvider", "not support cloud");
                int i10 = R$string.set_get_info_not_avi;
                int i11 = R$string.contact_email_value;
                m15724h(jSONObject, 4, context.getString(i10, context.getString(i11)), context.getString(i11), context.getString(R$string.hidisk_hwcloud_email_address_for_feedback));
            } else {
                m15725i(context, jSONObject);
                if (jSONObject.length() != 0) {
                    C13227f.m79492i1().m79585f0("show_cloud_storage_in_system_settings", C13452e.m80781L().m80971t0());
                    UBAAnalyze.m29954O("PVC", "show_cloud_storage_in_system_settings", "1", "100");
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("SettingTabProvider", "getModuleSize exception: " + e10.toString());
        }
        m15719b(context, jSONObject);
        if (jSONObject.length() == 0) {
            C11839m.m70689w("SettingTabProvider", "return data is null");
            return null;
        }
        matrixCursor.addRow(new Object[]{jSONObject.toString()});
        C11839m.m70686d("SettingTabProvider", "isCloudEnable resJson: " + jSONObject);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: f */
    public final boolean m15722f(QuotaInfoRsp quotaInfoRsp) throws Exception {
        if (quotaInfoRsp == null) {
            C11839m.m70687e("SettingTabProvider", "rsp is null");
            return false;
        }
        int retCode = quotaInfoRsp.getRetCode();
        C11839m.m70688i("SettingTabProvider", "getModuleSize retCode: " + retCode);
        if (retCode != 0) {
            C11839m.m70689w("SettingTabProvider", "retCode not success");
            return false;
        }
        FullQuotaInfo retBody = quotaInfoRsp.getRetBody();
        if (retBody == null) {
            C11839m.m70687e("SettingTabProvider", "info is null");
            return false;
        }
        String retType = retBody.getRetType();
        C11839m.m70688i("SettingTabProvider", "getModuleSize quotaDetailType: " + retType);
        if (TextUtils.isEmpty(retType)) {
            C11839m.m70687e("SettingTabProvider", "quotaDetailType is empty");
            return false;
        }
        if (retType.equals("val")) {
            return true;
        }
        if (retType.equals("url")) {
            return m15723g(retBody);
        }
        return false;
    }

    /* renamed from: g */
    public final boolean m15723g(FullQuotaInfo fullQuotaInfo) throws Exception {
        List<UsedSpaceInfo> usedInfos = fullQuotaInfo.getUsedInfos();
        if (usedInfos == null || usedInfos.size() <= 0) {
            C11839m.m70687e("SettingTabProvider", "usedInfos is null");
            return false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(usedInfos.size());
        for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
            if (usedSpaceInfo == null) {
                C11839m.m70687e("SettingTabProvider", "spaceInfo is null");
                return false;
            }
            C12515a.m75110o().m75175e(new C2757a(usedSpaceInfo, countDownLatch), false);
        }
        if (countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
            return true;
        }
        C11839m.m70687e("SettingTabProvider", "latch timeout");
        return false;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* renamed from: h */
    public final void m15724h(JSONObject jSONObject, int i10, String str, String str2, String str3) throws JSONException {
        jSONObject.put("cloudStatus", i10);
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("title", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("content", str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        jSONObject.put("button", str3);
    }

    /* renamed from: i */
    public final void m15725i(Context context, JSONObject jSONObject) throws Exception {
        QuotaInfoRsp quotaInfoRspM80309e = new C13378o().m80309e();
        if (!m15722f(quotaInfoRspM80309e)) {
            throw new C9721b(4003, "quota request fail");
        }
        FullQuotaInfo retBody = quotaInfoRspM80309e.getRetBody();
        if (retBody == null) {
            throw new C9721b(4003, "info is null");
        }
        QuotaInfo quotaInfo = retBody.getQuotaInfo();
        if (quotaInfo == null) {
            throw new C9721b(4003, "quotaDetailInfo is null");
        }
        QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
        if (quotaSpaceInfo == null) {
            throw new C9721b(4003, "spaceInfo is null");
        }
        List<UsedSpaceInfo> usedInfos = retBody.getUsedInfos();
        if (usedInfos == null || usedInfos.size() <= 0) {
            throw new C9721b(4003, "usedInfos is null");
        }
        long available = quotaSpaceInfo.getAvailable();
        long used = quotaSpaceInfo.getUsed();
        long total = quotaSpaceInfo.getTotal();
        if (total == 0) {
            throw new C9721b(4003, "total is zero");
        }
        int i10 = (int) ((used * 100.0f) / total);
        if (used != 0 && i10 == 0) {
            i10 = 1;
        }
        jSONObject.put("total", Math.max(used, total) + 1);
        if (C11333k.m68086b().m68090e(available)) {
            jSONObject.put("percentStr", context.getString(R$string.sapce_fill_detail_title));
            jSONObject.put("isFull", true);
        } else {
            jSONObject.put("percentStr", String.valueOf(i10));
            jSONObject.put("isFull", false);
        }
        String strM1526i = C0223k.m1526i(context, total, 1024, true, true);
        String strM1526i2 = C0223k.m1526i(context, used, 1024, true, true);
        if (TextUtils.isEmpty(strM1526i) || TextUtils.isEmpty(strM1526i2)) {
            throw new C9721b(4003, "totalStr or is empty");
        }
        jSONObject.put("usedStr", context.getString(R$string.frag_cloud_storage_value, strM1526i2, strM1526i));
        if (C10028c.m62182c0().m62413x()) {
            jSONObject.put("cloudStatus", 2);
            jSONObject.put("button", context.getString(R$string.manage_space_title_new1));
        } else {
            jSONObject.put("cloudStatus", 3);
            jSONObject.put("button", context.getString(R$string.setting_tab_enable_extend));
        }
        JSONArray jSONArray = new JSONArray();
        m15718a(context, usedInfos, "photos", jSONArray);
        m15718a(context, usedInfos, CloudBackupConstant.Command.PMS_CMD_BACKUP, jSONArray);
        m15718a(context, usedInfos, "drive", jSONArray);
        m15718a(context, usedInfos, "family", jSONArray);
        m15718a(context, usedInfos, "other", jSONArray);
        jSONObject.put("moduleSize", jSONArray.toString());
        C13367d.m80177a(quotaSpaceInfo);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f11976a.addURI("com.huawei.android.hicloud.SettingTabProvider", "is_cloud_enable", 1);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!C0209d.m1247e(getContext())) {
            C11839m.m70687e("SettingTabProvider", "provider context is null");
            return null;
        }
        Context contextM1148A = C0209d.m1148A(getContext(), str2);
        int iMatch = f11976a.match(uri);
        C11839m.m70686d("SettingTabProvider", "match result: " + iMatch + ", selection: " + str);
        if (1 == iMatch) {
            return m15721d(contextM1148A);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
