package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.hwidrecommend.bean.RecommendContent;
import com.huawei.android.hicloud.hwidrecommend.bean.RecommendItem;
import com.huawei.android.hicloud.hwidrecommend.bean.RecommendLink;
import com.huawei.android.hicloud.hwidrecommend.bean.RecommendResult;
import com.huawei.android.p073ds.R$string;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.bean.GetCampaignActivityEntryResp;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.util.ModuleConfigUtil;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fj.C9718g;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0223k;
import p015ak.C0241z;
import p020ap.C1006a;
import p020ap.C1010e;
import p033b9.C1146a;
import p052cb.C1412i;
import p054cj.C1442a;
import p252e9.C9432i;
import p292fn.C9733f;
import p336he.C10155f;
import p454lj.C11293p;
import p459lp.C11333k;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p651t8.C12997e;
import p651t8.C12998f;
import p684un.C13230i;
import p703v8.C13373j;
import p703v8.C13377n;
import p709vj.C13452e;
import p742wj.C13612b;
import p807yd.C13948d;
import p836z8.C14157f;
import zm.C14343a;
import zm.C14344b;
import zm.C14346d;

/* loaded from: classes3.dex */
public class HicloudFeatursProvider extends ContentProvider {

    /* renamed from: e */
    public static final UriMatcher f11953e;

    /* renamed from: b */
    public C14346d f11955b;

    /* renamed from: c */
    public C14344b f11956c;

    /* renamed from: a */
    public C14343a f11954a = null;

    /* renamed from: d */
    public SQLiteDatabase f11957d = null;

    /* renamed from: com.huawei.android.hicloud.common.provider.HicloudFeatursProvider$a */
    public class C2753a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ MatrixCursor f11958a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f11959b;

        public C2753a(MatrixCursor matrixCursor, CountDownLatch countDownLatch) {
            this.f11958a = matrixCursor;
            this.f11959b = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            QuotaSpaceInfo quotaSpaceInfoM80306b = new C13377n().m80306b();
            int iM68088c = C11333k.m68086b().m68088c(quotaSpaceInfoM80306b.getAvailable());
            this.f11958a.addRow(new Object[]{Integer.valueOf(iM68088c), Long.valueOf(quotaSpaceInfoM80306b.getUsed()), Long.valueOf(quotaSpaceInfoM80306b.getTotal())});
            C11839m.m70688i("HicloudFeatursProvider", "result cursor,storageLimitStatus:" + iM68088c + ",usedStorageSize:" + quotaSpaceInfoM80306b.getUsed() + ",packageStorageSize:" + quotaSpaceInfoM80306b.getTotal());
            this.f11959b.countDown();
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.provider.HicloudFeatursProvider$b */
    public class C2754b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ QuotaSpaceInfo[] f11961a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f11962b;

        public C2754b(QuotaSpaceInfo[] quotaSpaceInfoArr, CountDownLatch countDownLatch) {
            this.f11961a = quotaSpaceInfoArr;
            this.f11962b = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            this.f11961a[0] = new C13377n().m80306b();
            this.f11962b.countDown();
        }
    }

    /* renamed from: com.huawei.android.hicloud.common.provider.HicloudFeatursProvider$c */
    public class C2755c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ CountDownLatch f11964a;

        public C2755c(CountDownLatch countDownLatch) {
            this.f11964a = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.grade");
            C4987f c4987f = C14157f.m84942g().m84949i(null, arrayList, "HicloudFeatursProvider").get(0);
            if (c4987f != null) {
                C11839m.m70688i("HicloudFeatursProvider", "queryGradeCode:" + c4987f.m30027c());
                C13452e.m80781L().m80940l1(c4987f.m30027c());
            }
            this.f11964a.countDown();
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11953e = uriMatcher;
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "is_support_cloudphoto", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "is_login", 2);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "query_switch_status", 3);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "query_album_switch_status", 4);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "is_support_eassistant", 5);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "display_content_uri_query", 6);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "support_netdisk", 7);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "query_for_hwid", 8);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "badge", 9);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "query_cloud_backup_status", 10);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "query_phone_finder_status", 11);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_module_switch_result", 12);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_funcfg_huawei_drive", 13);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_data", 14);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "cloud_has_config_tag", 15);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_setting_data", 16);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_bookmark_data", 17);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_source_data", 18);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_quick_access_moved", 19);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_shield_source_data", 20);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "query_device_operations", 23);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_device_operations_num", 24);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_upload_list", 25);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_download_list", 26);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "is_agreed_hicloud_agreement", 27);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_file_manager_cloud_info_list", 28);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_encrypt_status", 29);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_gallery_switch_status", 30);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "get_gallery_release_size", 31);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "queryStorage", 32);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "is_support_cloud_photo_ex", 33);
        uriMatcher.addURI("com.huawei.android.hicloud.provider", "getParams", 34);
    }

    /* renamed from: Q */
    public static /* synthetic */ void m15640Q(CountDownLatch countDownLatch, GetCampaignActivityEntryResp getCampaignActivityEntryResp) {
        C11839m.m70688i("HicloudFeatursProvider", "getActivityLink success");
        if (getCampaignActivityEntryResp == null || getCampaignActivityEntryResp.getResultCode() != 0) {
            C1442a.m8289e("HicloudFeatursProvider", "getActivityLink rsp is null");
        } else {
            C9718g.m60602t().m60620V(C0213f.m1377a(), getCampaignActivityEntryResp);
            countDownLatch.countDown();
        }
    }

    /* renamed from: A */
    public final Cursor m15642A(String[] strArr, String str, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("table_source_bean");
        Cursor cursorQuery = null;
        try {
            C14346d c14346d = this.f11955b;
            if (c14346d != null) {
                SQLiteDatabase readableDatabase = c14346d.getReadableDatabase();
                this.f11957d = readableDatabase;
                cursorQuery = sQLiteQueryBuilder.query(readableDatabase, strArr, str, null, null, null, str2);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HicloudFeatursProvider", "fileManagerDbHelper Query failed in provider error: " + e10.toString());
        }
        if (cursorQuery != null) {
            C11839m.m70688i("HicloudFeatursProvider", "cursor count: " + cursorQuery.getCount());
        }
        return cursorQuery;
    }

    /* renamed from: B */
    public final String m15643B(Context context, QuotaSpaceInfo quotaSpaceInfo) {
        if (C13452e.m80781L().m80790C().equals(CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)) {
            return context.getString(R$string.basic_data_service);
        }
        if (quotaSpaceInfo == null) {
            return "";
        }
        C11839m.m70688i("HicloudFeatursProvider", "spaceInfo is not null");
        long used = quotaSpaceInfo.getUsed();
        C11839m.m70688i("HicloudFeatursProvider", "usedSize:" + used);
        long available = quotaSpaceInfo.getAvailable();
        C11839m.m70688i("HicloudFeatursProvider", "availableSize:" + available);
        return m15681l(available, used, context);
    }

    /* renamed from: C */
    public final Cursor m15644C() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"is_agreed_hicloud_agreement"});
        matrixCursor.addRow(new Object[]{Boolean.valueOf(C10028c.m62182c0().m62221H1())});
        return matrixCursor;
    }

    /* renamed from: D */
    public final boolean m15645D(Context context) {
        boolean zIsLogin = C13612b.m81829B().isLogin();
        C11839m.m70686d("HicloudFeatursProvider", "isAccountSaved: " + zIsLogin);
        String strM80942m = zIsLogin ? C13452e.m80781L().m80942m() : C0209d.m1328y0(context);
        C11839m.m70686d("HicloudFeatursProvider", "countryCode is: " + strM80942m);
        return "CN".equalsIgnoreCase(strM80942m);
    }

    /* renamed from: E */
    public final boolean m15646E(Context context) {
        boolean zM1354d = C0212e0.m1354d(context, "sp_stop_use_cloud_services", "key_stop_use_cloud_services", false);
        C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo isCloudDisableByHand: " + zM1354d);
        return zM1354d;
    }

    /* renamed from: F */
    public final boolean m15647F(Context context) {
        boolean zM62413x = C10028c.m62183d0(context).m62413x();
        C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo extendFuncSwitch: " + zM62413x);
        return !zM62413x;
    }

    /* renamed from: G */
    public final boolean m15648G() {
        try {
            return C11829c.m70629x0(true);
        } catch (C1412i e10) {
            C11839m.m70687e("HicloudFeatursProvider", "isFamilyShareMember exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: H */
    public final boolean m15649H(Bundle bundle) {
        if (bundle != null && bundle.containsKey("accountStatus")) {
            return !bundle.getBoolean("accountStatus");
        }
        return false;
    }

    /* renamed from: I */
    public final Cursor m15650I() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"featureName", "value"});
        Context context = getContext();
        boolean zIsLogin = C13612b.m81829B().isLogin();
        C11839m.m70686d("HicloudFeatursProvider", "isLogin:" + zIsLogin);
        matrixCursor.addRow(new Object[]{"IsLogin", Boolean.valueOf(zIsLogin)});
        if (zIsLogin) {
            C1146a.m7210b(context);
        }
        return matrixCursor;
    }

    /* renamed from: J */
    public final boolean m15651J(String str) {
        return C10028c.m62182c0().m62395t1(str);
    }

    /* renamed from: K */
    public final Cursor m15652K(String str, String[] strArr) {
        C11839m.m70688i("HicloudFeatursProvider", "start check is need to show red dot");
        Context context = getContext();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"badge"});
        if (context == null) {
            C11839m.m70688i("HicloudFeatursProvider", "check red dot, context is null");
            C10028c.m62182c0().m62203D3(false);
            matrixCursor.addRow(new Object[]{0});
            return matrixCursor;
        }
        if (!C0209d.m1166E1()) {
            C11839m.m70688i("HicloudFeatursProvider", "the account do not need to show red dot");
            C10028c.m62182c0().m62203D3(false);
            matrixCursor.addRow(new Object[]{0});
            return matrixCursor;
        }
        int iM1685c = (str == null || strArr == null || strArr.length <= 1) ? 0 : C0241z.m1685c(strArr[1]);
        if (!C13452e.m80781L().m80850R0()) {
            C11839m.m70688i("HicloudFeatursProvider", "Cloud is not login");
            C10028c.m62182c0().m62203D3(true);
            matrixCursor.addRow(new Object[]{1});
        } else if ((C2783d.m16119Y(context) && !C0209d.m1293p1() && C10028c.m62182c0().m62413x()) || C2783d.m16121Z(context, iM1685c)) {
            C11839m.m70688i("HicloudFeatursProvider", "CloudBackup or PhoneFinder is not open , need show red dot");
            C10028c.m62182c0().m62203D3(true);
            matrixCursor.addRow(new Object[]{1});
        } else {
            C11839m.m70688i("HicloudFeatursProvider", "do not need show red dot");
            C10028c.m62182c0().m62203D3(false);
            matrixCursor.addRow(new Object[]{0});
        }
        return matrixCursor;
    }

    /* renamed from: L */
    public final boolean m15653L(Context context) {
        HiCloudSysParamMap hiCloudSysParamMapM60759r = C9733f.m60705z().m60759r(context);
        return hiCloudSysParamMapM60759r == null || hiCloudSysParamMapM60759r.getEnableHwIdSuggest() != 0;
    }

    /* renamed from: M */
    public final Cursor m15654M() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"featureName", "value"});
        C11839m.m70686d("HicloudFeatursProvider", "is support cloud disk");
        matrixCursor.addRow(new Object[]{1});
        return matrixCursor;
    }

    /* renamed from: N */
    public final Cursor m15655N(String str, String[] strArr) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"featureName", "value"});
        C11839m.m70686d("HicloudFeatursProvider", "is_support_cloudphoto");
        boolean zM16107S = C2783d.m16107S();
        if (str == null || strArr == null || strArr.length != 1) {
            matrixCursor.addRow(new Object[]{"IsSupportNewCloudPhoto", Boolean.valueOf(zM16107S)});
        } else {
            String str2 = strArr[0];
            if (!"IsPhotoshareOpen".equals(str2) && !"IsSupportNewCloudPhoto".equals(str2)) {
                matrixCursor.close();
                throw new IllegalArgumentException("IllegalArgument featureName = " + str2);
            }
            matrixCursor.addRow(new Object[]{str2, Boolean.valueOf(zM16107S)});
        }
        return matrixCursor;
    }

    /* renamed from: O */
    public final Cursor m15656O() {
        boolean z10;
        C11839m.m70688i("HicloudFeatursProvider", "isSupportCloudPhotoEx");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"isSupportCloudPhotoEx"});
        Context context = getContext();
        boolean z11 = false;
        if (context == null) {
            C11839m.m70688i("HicloudFeatursProvider", "IsSupportCloudPhotoEx, context is null");
            z10 = false;
        } else {
            z10 = true;
        }
        if (C0209d.m1173G1(getContext()) || !C0209d.m1166E1() || m15647F(context)) {
            C11839m.m70688i("HicloudFeatursProvider", "The user is privacyUser or not owner user or extendFuncDisable");
            z10 = false;
        }
        if (!C13612b.m81829B().isLogin() || C10155f.m63290n()) {
            z11 = z10;
        } else {
            C11839m.m70688i("HicloudFeatursProvider", "IsSupportCloudPhotoEx is false");
        }
        matrixCursor.addRow(new Object[]{Boolean.valueOf(z11)});
        return matrixCursor;
    }

    /* renamed from: P */
    public final Cursor m15657P() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"featureName", "value"});
        C11839m.m70686d("HicloudFeatursProvider", "is_support_eassistant");
        return matrixCursor;
    }

    /* renamed from: R */
    public final void m15658R(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && !key.equals("deviceId")) {
                C11839m.m70688i("HicloudFeatursProvider", "printModuleSwitchResult Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
    }

    /* renamed from: S */
    public final Cursor m15659S() {
        C11839m.m70686d("HicloudFeatursProvider", "query_album_swtich_status");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"isPhotoUpOn", "isVideoUpOn", "isScreenShotOn", "isPowerContrl", "isCloudAlbumOn", "isAlbum3GAllow"});
        Context context = getContext();
        if (C13612b.m81829B().m81853R()) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "cloud_photo_cfg", 0);
            matrixCursor.addRow(new Object[]{Boolean.valueOf(sharedPreferencesM1382b.getBoolean("cloud_photoup_switch", false)), Boolean.valueOf(sharedPreferencesM1382b.getBoolean("cloud_videoup_switch", false)), Boolean.valueOf(sharedPreferencesM1382b.getBoolean("cloud_screenshot_switch", false)), Boolean.valueOf(C0214f0.m1382b(context, NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, 0).getBoolean("need_battery_condition", true)), Boolean.valueOf(sharedPreferencesM1382b.getBoolean("cloud_album_switch", false)), Boolean.valueOf(sharedPreferencesM1382b.getBoolean("cloud_album_netswitch", false))});
        }
        return matrixCursor;
    }

    /* renamed from: T */
    public final Cursor m15660T(String[] strArr, String[] strArr2, String str, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("tab_bookmark");
        try {
            return sQLiteQueryBuilder.query(this.f11954a.getWritableDatabase(), strArr, str, strArr2, null, null, str2);
        } catch (Exception e10) {
            C11839m.m70687e("HicloudFeatursProvider", "error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: U */
    public final Cursor m15661U(String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("cloudFileInfo");
        Cursor cursorQuery = null;
        try {
            C14344b c14344b = this.f11956c;
            if (c14344b != null) {
                cursorQuery = sQLiteQueryBuilder.query(c14344b.getReadableDatabase(), strArr, str, strArr2, null, null, str2);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HicloudFeatursProvider", "queryDownAndUploadList failed in provider error: " + e10.toString());
        }
        if (cursorQuery != null) {
            C11839m.m70688i("HicloudFeatursProvider", "queryDownAndUploadList cursor count: " + cursorQuery.getCount());
        }
        return cursorQuery;
    }

    /* renamed from: V */
    public final Cursor m15662V() {
        if (!C13452e.m80781L().m80842P0() || !C10028c.m62182c0().m62221H1()) {
            return null;
        }
        C13373j.m80291c().m80296g();
        return null;
    }

    /* renamed from: W */
    public Cursor m15663W(String str, String[] strArr) throws InterruptedException {
        String string;
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"display_content"});
        C11839m.m70688i("HicloudFeatursProvider", "query_display_content");
        Context context = getContext();
        int iM1685c = (str == null || strArr == null || strArr.length <= 1) ? 0 : C0241z.m1685c(strArr[1]);
        if (C13612b.m81829B().m81855T() || !C10155f.m63291o(getContext()) || !C13612b.m81829B().isLogin() || C0209d.m1173G1(getContext())) {
            C11839m.m70688i("HicloudFeatursProvider", "show disable.");
            string = context.getString(R$string.sync_switch_button_close);
            C10028c.m62182c0().m62273S2(false);
        } else if (C0209d.m1166E1()) {
            C11839m.m70688i("HicloudFeatursProvider", "show displayStringsToHwid");
            string = m15675f(context, iM1685c);
        } else {
            C11839m.m70688i("HicloudFeatursProvider", "is sub user");
            string = context.getString(R$string.settings_hicloud_open);
            C10028c.m62182c0().m62273S2(false);
        }
        C11839m.m70688i("HicloudFeatursProvider", "displayContent:" + string);
        matrixCursor.addRow(new Object[]{string});
        return matrixCursor;
    }

    /* renamed from: X */
    public final Cursor m15664X(String[] strArr, String str, String[] strArr2, String str2, boolean z10) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        if (z10) {
            sQLiteQueryBuilder.setTables("cloudUpload");
        } else {
            sQLiteQueryBuilder.setTables("downloadlist");
        }
        Cursor cursorQuery = null;
        try {
            C14344b c14344b = this.f11956c;
            if (c14344b != null) {
                cursorQuery = sQLiteQueryBuilder.query(c14344b.getReadableDatabase(), strArr, str, strArr2, null, null, str2);
            }
        } catch (Exception e10) {
            C11839m.m70687e("HicloudFeatursProvider", "queryDownAndUploadList failed in provider error: " + e10.toString());
        }
        if (cursorQuery != null) {
            C11839m.m70688i("HicloudFeatursProvider", "queryDownAndUploadList cursor count: " + cursorQuery.getCount());
        }
        return cursorQuery;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* renamed from: Y */
    public final Cursor m15665Y() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"service_navigate_memo", "service_logout_memo", "service_login_flag"});
        Context context = getContext();
        boolean zIsLogin = C13612b.m81829B().isLogin();
        boolean zM62395t1 = C10028c.m62183d0(context).m62395t1("funcfg_gallery");
        boolean zM62395t12 = C10028c.m62183d0(context).m62395t1("funcfg_find_my_phone_globe");
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zIsGeneralVersion = ModuleConfigUtil.getInstance().isGeneralVersion();
        C11839m.m70688i("HicloudFeatursProvider", "first=" + zM62395t1 + ",second=" + zM62395t12 + ",third=" + zIsGeneralVersion + ",four=" + zM62388s + ",isLogin=" + zIsLogin);
        boolean z10 = false;
        ?? r72 = zM62395t1 && zM62395t12 && zIsGeneralVersion;
        ?? r82 = !zM62395t1 && zM62395t12 && zIsGeneralVersion;
        ?? r92 = zM62395t1 && zM62395t12 && !zIsGeneralVersion;
        ?? r10 = (zM62395t1 || !zM62395t12 || zIsGeneralVersion) ? false : true;
        if (zM62395t1 && !zM62395t12 && zIsGeneralVersion) {
            z10 = true;
        }
        String string = (r72 == true || r82 == true || r92 == true) ? getContext().getString(R$string.hicloud_logout_tips_new) : r10 != false ? getContext().getString(R$string.hicloud_logout_tips_3) : z10 ? getContext().getString(R$string.hicloud_logout_tips_4_new) : "";
        matrixCursor.addRow(new Object[]{"hicloud navigation tips", string, Integer.valueOf(zIsLogin ? 1 : 0)});
        return matrixCursor;
    }

    /* renamed from: Z */
    public final Cursor m15666Z(String[] strArr, String str) {
        Context context = getContext();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"module_switch_current_device", "module_switch_retcode", "module_switch_content", "module_switch_subtitle"});
        if (strArr == null || strArr.length <= 0 || context == null) {
            C11839m.m70687e("HicloudFeatursProvider", "queryModuleSwitchStatus moduleName=" + str + ", args illegal");
            matrixCursor.addRow(new Object[]{"unknow", "illegal", null, null});
            return matrixCursor;
        }
        boolean zM62395t1 = C10028c.m62182c0().m62395t1("is_already_configed_NV4");
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        if (!C13612b.m81829B().isLogin() || !zM62395t1 || !zM62221H1) {
            C11839m.m70688i("HicloudFeatursProvider", "queryModuleSwitchStatus moduleName=" + str + ", hicloud not login");
            matrixCursor.addRow(new Object[]{"unknow", "unlogin", null, null});
            return matrixCursor;
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        String strM80950o = C13452e.m80781L().m80950o();
        if (TextUtils.isEmpty(strM80950o) || !strM80950o.equals(str2)) {
            m15678i(str, str2, str3, matrixCursor);
        } else {
            m15689t(context, str, matrixCursor);
        }
        return matrixCursor;
    }

    /* renamed from: a0 */
    public final Cursor m15667a0(int i10, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        switch (i10) {
            case 25:
                return m15664X(strArr, str, strArr2, str2, true);
            case 26:
                return m15664X(strArr, str, strArr2, str2, false);
            case 27:
                return m15644C();
            case 28:
                return m15661U(strArr, str, strArr2, str2);
            case 29:
                return m15682m();
            case 30:
            case 31:
            default:
                throw new IllegalArgumentException("Unkown URI " + uri);
            case 32:
                return m15673d0(str, strArr2);
            case 33:
                return m15656O();
        }
    }

    /* renamed from: b */
    public final RecommendItem m15668b(Context context, Bundle bundle) {
        C11839m.m70686d("HicloudFeatursProvider", "buildOpenCloud start");
        if (m15674e(bundle, "2002")) {
            C11839m.m70689w("HicloudFeatursProvider", "buildOpenCloud, recommend id restrained");
            return null;
        }
        RecommendLink recommendLink = new RecommendLink();
        recommendLink.setPackageName("com.huawei.hidisk");
        recommendLink.setVersion("0");
        recommendLink.setUri("hicloud://cloudDrive/getInfo?path=MainActivity&srcChannel=2");
        ArrayList arrayList = new ArrayList();
        arrayList.add(recommendLink);
        RecommendContent recommendContent = new RecommendContent();
        recommendContent.setLinkType("1");
        recommendContent.setTitle(context.getString(R$string.hwid_recom_open_cloud_title));
        recommendContent.setSubTitle(context.getString(R$string.hwid_recom_open_cloud_sub_title));
        recommendContent.setLinkName(context.getString(R$string.hwid_recom_open_cloud_link_name));
        recommendContent.setLinks(arrayList);
        RecommendItem recommendItem = new RecommendItem();
        recommendItem.setRecommendId("2002");
        recommendItem.setContent(recommendContent);
        recommendItem.setContentType("1");
        C11839m.m70686d("HicloudFeatursProvider", "buildOpenCloud end");
        return recommendItem;
    }

    /* renamed from: b0 */
    public final Cursor m15669b0() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"featureName", "value"});
        C11839m.m70686d("HicloudFeatursProvider", "query_swtich_status");
        Context context = getContext();
        if (C13612b.m81829B().isLogin()) {
            SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "cloud_photo_cfg", 0);
            matrixCursor.addRow(new Object[]{"isOpenPhoto", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("photo_stream_switch", false))});
            matrixCursor.addRow(new Object[]{"isOpenShare", Boolean.valueOf(sharedPreferencesM1382b.getBoolean("share_photo_switch", false))});
            matrixCursor.addRow(new Object[]{"is3Gdl", Boolean.valueOf(!sharedPreferencesM1382b.getBoolean("net_3g_switch", true))});
        }
        return matrixCursor;
    }

    /* renamed from: c */
    public final RecommendItem m15670c(Context context, Bundle bundle) {
        String string;
        String str;
        C11839m.m70686d("HicloudFeatursProvider", "buildSpaceFull start");
        if (m15674e(bundle, "2001")) {
            C11839m.m70689w("HicloudFeatursProvider", "buildSpaceFull, recommend id restrained");
            return null;
        }
        if (!m15653L(context)) {
            C11839m.m70687e("HicloudFeatursProvider", "recommend switch closed, not recommend");
            return null;
        }
        QuotaSpaceInfo quotaSpaceInfoM80306b = new C13377n().m80306b();
        if (quotaSpaceInfoM80306b == null) {
            C11839m.m70687e("HicloudFeatursProvider", "spaceInfo null");
            return null;
        }
        if (quotaSpaceInfoM80306b.getRetCode() != 0) {
            C11839m.m70687e("HicloudFeatursProvider", "space query not success, return");
            return null;
        }
        long available = quotaSpaceInfoM80306b.getAvailable();
        C11839m.m70686d("HicloudFeatursProvider", "availableSize is: " + available);
        if (C11333k.m68086b().m68092g(available)) {
            C11839m.m70687e("HicloudFeatursProvider", "space not full, return");
            return null;
        }
        if (m15648G()) {
            C11839m.m70687e("HicloudFeatursProvider", "familyShare member, space full, return");
            return null;
        }
        C11839m.m70686d("HicloudFeatursProvider", "totalSize is: " + quotaSpaceInfoM80306b.getTotal());
        if (C11293p.m67767k(C13948d.m83788f().m83800m()) == 1) {
            string = context.getString(R$string.hwid_recom_space_full_pay_link_name);
            str = "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=2";
        } else {
            string = context.getString(R$string.hwid_recom_space_full_free_link_name);
            str = "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=2";
        }
        RecommendLink recommendLink = new RecommendLink();
        recommendLink.setPackageName("com.huawei.hidisk");
        recommendLink.setVersion("0");
        recommendLink.setUri(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(recommendLink);
        RecommendContent recommendContent = new RecommendContent();
        recommendContent.setLinkType("1");
        recommendContent.setTitle(context.getString(R$string.hwid_recom_space_full_title));
        recommendContent.setSubTitle(context.getString(R$string.hwid_recom_space_full_sub_title));
        recommendContent.setLinkName(string);
        recommendContent.setLinks(arrayList);
        RecommendItem recommendItem = new RecommendItem();
        recommendItem.setRecommendId("2001");
        recommendItem.setContent(recommendContent);
        recommendItem.setContentType("1");
        C11839m.m70686d("HicloudFeatursProvider", "buildSpaceFull end");
        return recommendItem;
    }

    /* renamed from: c0 */
    public Cursor m15671c0(int i10, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (i10 == 23) {
            return m15662V();
        }
        if (i10 == 24) {
            return m15680k();
        }
        if (i10 == 30) {
            return m15687r();
        }
        if (i10 == 31) {
            return m15686q();
        }
        switch (i10) {
            case 13:
                return m15685p();
            case 14:
                return m15683n(str);
            case 15:
                return m15672d();
            case 16:
                return m15684o(str);
            case 17:
                return m15660T(strArr, strArr2, str, str2);
            case 18:
                return m15642A(strArr, str, str2);
            case 19:
                return m15692w();
            case 20:
                return m15695z(str);
            default:
                return m15667a0(i10, uri, strArr, str, strArr2, str2);
        }
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) throws InterruptedException {
        C0209d.m1247e(getContext());
        Bundle bundle2 = new Bundle();
        if ("getInfo".equalsIgnoreCase(str)) {
            bundle2.putString("result", m15688s(bundle));
        } else if ("getActivityLINK".equalsIgnoreCase(str)) {
            m15676g(bundle2, bundle);
        } else if ("setCampaignTaskResult".equals(str)) {
            if (bundle != null) {
                int i10 = bundle.getInt("campaignTaskId", 0);
                C11839m.m70688i("HicloudFeatursProvider", "set_campaign_task_result campaignTaskId is " + i10);
                C12998f.m78034R().m78045B(getContext(), C12997e.m78019l(), true, i10);
            } else {
                C11839m.m70688i("HicloudFeatursProvider", "set_campaign_task_result extras is null!");
            }
        }
        return bundle2;
    }

    /* renamed from: d */
    public final Cursor m15672d() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cloudHasConfigTag"});
        Context context = getContext();
        boolean z10 = false;
        if (context == null) {
            C11839m.m70687e("HicloudFeatursProvider", "context is null");
        } else if (C2783d.m16097N() && C10028c.m62183d0(context).m62324f0("is_all_guide_over")) {
            z10 = true;
        }
        C11839m.m70686d("HicloudFeatursProvider", "hasConfigTag:" + z10);
        matrixCursor.addRow(new Object[]{Boolean.valueOf(z10)});
        return matrixCursor;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* renamed from: d0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.database.Cursor m15673d0(java.lang.String r6, java.lang.String[] r7) throws java.lang.InterruptedException {
        /*
            r5 = this;
            java.lang.String r0 = "queryStorage"
            java.lang.String r1 = "HicloudFeatursProvider"
            p514o9.C11839m.m70688i(r1, r0)
            un.f r0 = p684un.C13227f.m79492i1()
            java.lang.String r2 = r5.getCallingPackage()
            java.lang.String r3 = "query_storage_provider"
            r0.m79564O0(r2, r3)
            android.database.MatrixCursor r0 = new android.database.MatrixCursor
            java.lang.String r2 = "usedStorageSize"
            java.lang.String r3 = "packageStorageSize"
            java.lang.String r4 = "storageLimitStatus"
            java.lang.String[] r2 = new java.lang.String[]{r4, r2, r3}
            r0.<init>(r2)
            fn.f r2 = p292fn.C9733f.m60705z()
            java.lang.String r3 = "providerStorageLimitQuery"
            boolean r2 = r2.m60720O(r3)
            if (r2 != 0) goto L35
            java.lang.String r5 = "queryStorage Feature is close"
            p514o9.C11839m.m70688i(r1, r5)
            return r0
        L35:
            android.content.Context r2 = r5.getContext()
            if (r2 != 0) goto L41
            java.lang.String r5 = "queryStorage, context is null"
            p514o9.C11839m.m70688i(r1, r5)
            return r0
        L41:
            wj.b r2 = p742wj.C13612b.m81829B()
            boolean r2 = r2.m81855T()
            if (r2 != 0) goto Lc5
            wj.b r2 = p742wj.C13612b.m81829B()
            boolean r2 = r2.isLogin()
            if (r2 == 0) goto Lc5
            android.content.Context r2 = r5.getContext()
            boolean r2 = p015ak.C0209d.m1173G1(r2)
            if (r2 == 0) goto L60
            goto Lc5
        L60:
            int r6 = r5.m15691v(r6, r7)
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch
            r2 = 1
            r7.<init>(r2)
            rk.a r2 = p616rk.C12515a.m75110o()
            com.huawei.android.hicloud.common.provider.HicloudFeatursProvider$a r3 = new com.huawei.android.hicloud.common.provider.HicloudFeatursProvider$a
            r3.<init>(r0, r7)
            r5 = 0
            r2.m75175e(r3, r5)
            long r2 = (long) r6
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L95
            boolean r6 = r7.await(r2, r6)     // Catch: java.lang.Exception -> L95
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L93
            r7.<init>()     // Catch: java.lang.Exception -> L93
            java.lang.String r2 = "queryStorage wait:"
            r7.append(r2)     // Catch: java.lang.Exception -> L93
            r7.append(r6)     // Catch: java.lang.Exception -> L93
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L93
            p514o9.C11839m.m70688i(r1, r7)     // Catch: java.lang.Exception -> L93
            goto Laf
        L93:
            r7 = move-exception
            goto L97
        L95:
            r7 = move-exception
            r6 = r5
        L97:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "queryStorage Exception:"
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            p514o9.C11839m.m70687e(r1, r7)
        Laf:
            if (r6 != 0) goto Lc5
            r6 = -1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r6, r7, r5}
            r0.addRow(r5)
        Lc5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.common.provider.HicloudFeatursProvider.m15673d0(java.lang.String, java.lang.String[]):android.database.Cursor");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final boolean m15674e(Bundle bundle, String str) {
        ArrayList<String> stringArrayList;
        if (bundle == null || (stringArrayList = bundle.getStringArrayList("restrainIds")) == null || stringArrayList.isEmpty()) {
            return false;
        }
        return stringArrayList.contains(str);
    }

    /* renamed from: f */
    public final String m15675f(Context context, int i10) throws InterruptedException {
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        boolean zM62395t1 = c10028cM62183d0.m62395t1("funcfg_cloud_backup");
        boolean zM62388s = c10028cM62183d0.m62388s("backup_key");
        if (zM62395t1 && !zM62388s && !C0209d.m1293p1()) {
            C11839m.m70688i("HicloudFeatursProvider", "set nav to backup activity: true");
            C10028c.m62182c0().m62273S2(true);
            return context.getString(R$string.cloud_backup_not_open);
        }
        C11839m.m70688i("HicloudFeatursProvider", "set nav to backup activity: false");
        C10028c.m62182c0().m62273S2(false);
        boolean zM6148n = C1010e.m6125b().m6148n(C13452e.m80781L().m80942m());
        if (i10 == 1 && zM6148n) {
            if (!zM62395t1) {
                return context.getString(R$string.settings_hicloud_open);
            }
            String strM15677h = m15677h();
            return TextUtils.isEmpty(strM15677h) ? context.getString(R$string.settings_hicloud_open) : strM15677h;
        }
        boolean zM62395t12 = c10028cM62183d0.m62395t1("funcfg_find_my_phone_globe");
        boolean zM6139e = C1010e.m6125b().m6139e(context);
        if (zM62395t12 && !zM6139e) {
            return context.getString(C11842p.m70762R0() ? R$string.phone_finder_not_open_pad : R$string.phone_finder_not_open);
        }
        if (!zM62395t1 && !zM62395t12) {
            return context.getString(R$string.settings_hicloud_open);
        }
        String strM15677h2 = m15677h();
        return TextUtils.isEmpty(strM15677h2) ? context.getString(R$string.settings_hicloud_open) : strM15677h2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m15676g(android.os.Bundle r8, android.os.Bundle r9) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.lang.String r7 = "getActivityLink"
            java.lang.String r0 = "HicloudFeatursProvider"
            p514o9.C11839m.m70688i(r0, r7)
            android.content.Context r7 = p015ak.C0213f.m1377a()
            boolean r7 = p336he.C10155f.m63291o(r7)
            r1 = 1
            java.lang.String r2 = "code"
            if (r7 != 0) goto L18
            r8.putInt(r2, r1)
            return
        L18:
            fj.g r7 = fj.C9718g.m60602t()
            android.content.Context r3 = p015ak.C0213f.m1377a()
            r4 = 0
            boolean r7 = r7.m60607E(r3, r4)
            if (r7 != 0) goto L7d
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch
            r7.<init>(r1)
            hj.w r3 = new hj.w
            g9.c r5 = new g9.c
            r5.<init>()
            r3.<init>(r5)
            java.lang.String r5 = "HicloudFeaturesProvider"
            r3.m63434i(r5)
            r3.m63381g()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Exception -> L5d
            r5 = 20000(0x4e20, double:9.8813E-320)
            boolean r7 = r7.await(r5, r3)     // Catch: java.lang.Exception -> L5d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5b
            r3.<init>()     // Catch: java.lang.Exception -> L5b
            java.lang.String r5 = "getActivityLink wait:"
            r3.append(r5)     // Catch: java.lang.Exception -> L5b
            r3.append(r7)     // Catch: java.lang.Exception -> L5b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L5b
            p514o9.C11839m.m70688i(r0, r3)     // Catch: java.lang.Exception -> L5b
            goto L77
        L5b:
            r3 = move-exception
            goto L5f
        L5d:
            r3 = move-exception
            r7 = r4
        L5f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "getActivityLink Exception:"
            r5.append(r6)
            java.lang.String r3 = r3.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            p514o9.C11839m.m70687e(r0, r3)
        L77:
            if (r7 != 0) goto L7d
            r8.putInt(r2, r1)
            return
        L7d:
            java.lang.String r7 = "channels"
            java.util.ArrayList r7 = r9.getIntegerArrayList(r7)
            r8.putInt(r2, r4)
            xk.d r9 = p778xk.C13823d.m82904y()
            java.lang.String r7 = r9.m82908D(r7)
            java.lang.String r9 = "result"
            r8.putString(r9, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.common.provider.HicloudFeatursProvider.m15676g(android.os.Bundle, android.os.Bundle):void");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* renamed from: h */
    public final String m15677h() throws InterruptedException {
        boolean zAwait;
        QuotaSpaceInfo[] quotaSpaceInfoArr = {null};
        Context context = getContext();
        if (context == null) {
            C11839m.m70687e("HicloudFeatursProvider", "get cloud space context null");
            return "";
        }
        CountDownLatch countDownLatch = new CountDownLatch(2);
        C12515a.m75110o().m75175e(new C2754b(quotaSpaceInfoArr, countDownLatch), false);
        C12515a.m75110o().m75175e(new C2755c(countDownLatch), false);
        try {
            zAwait = countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            C11839m.m70687e("HicloudFeatursProvider", "queryStorage Exception:" + e10.getMessage());
            zAwait = false;
        }
        C11839m.m70688i("HicloudFeatursProvider", "using space cache, get quota is:" + zAwait);
        return m15643B(context, quotaSpaceInfoArr[0]);
    }

    /* renamed from: i */
    public final void m15678i(String str, String str2, String str3, MatrixCursor matrixCursor) {
        C11839m.m70688i("HicloudFeatursProvider", "getCloudSwitchStatus moduleName=" + str);
        matrixCursor.addRow(new Object[]{"false", C9432i.m59149j().m59160o(str, str2, str3), null, null});
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* renamed from: j */
    public final Cursor m15679j(String[] strArr) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"params"});
        if (strArr != null) {
            try {
                if (strArr.length == 0) {
                    matrixCursor.addRow(new Object[]{"params", null});
                } else {
                    List<C4987f> listM84949i = C14157f.m84942g().m84949i(Arrays.asList(strArr), Arrays.asList(strArr), "GetData");
                    JsonObject jsonObject = new JsonObject();
                    for (C4987f c4987f : listM84949i) {
                        jsonObject.addProperty(c4987f.m30026b(), c4987f.m30027c());
                    }
                    matrixCursor.addRow(new Object[]{new Gson().toJson((JsonElement) jsonObject)});
                }
            } catch (Exception unused) {
                C11839m.m70688i("HicloudFeatursProvider", "getDataParams err");
            }
        } else {
            matrixCursor.addRow(new Object[]{"params", null});
        }
        return matrixCursor;
    }

    /* renamed from: k */
    public final Cursor m15680k() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"device_operations_num"});
        matrixCursor.addRow(new Object[]{Integer.valueOf(C13373j.m80291c().m80292b())});
        return matrixCursor;
    }

    /* renamed from: l */
    public final String m15681l(long j10, long j11, Context context) {
        C11839m.m70688i("HicloudFeatursProvider", "getDisplayStr");
        if (C13452e.m80781L().m80790C().equals(CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE)) {
            return context.getString(R$string.basic_data_service);
        }
        if (C11333k.m68086b().m68091f(j10)) {
            C11839m.m70688i("HicloudFeatursProvider", "space well be full, 500MB");
            return C11333k.m68086b().m68090e(j10) ? context.getString(R$string.main_space_full_title) : context.getString(R$string.main_space_will_full_title);
        }
        String strM1526i = C0223k.m1526i(context, j11, 1024, true, true);
        C11839m.m70688i("HicloudFeatursProvider", "usedStr:" + strM1526i);
        return context.getString(R$string.frag_cloud_storage_value_style_2, strM1526i);
    }

    /* renamed from: m */
    public final Cursor m15682m() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"get_encrypt_status"});
        matrixCursor.addRow(new Object[]{Integer.valueOf(C10028c.m62182c0().m62373p())});
        return matrixCursor;
    }

    /* renamed from: n */
    public final Cursor m15683n(String str) {
        Context context = getContext();
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(context, "account_bind_box");
        if (str != null) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"bindUserId"});
            if (sharedPreferencesM1362l != null) {
                matrixCursor.addRow(new Object[]{sharedPreferencesM1362l.getString(str, "")});
            }
            return matrixCursor;
        }
        MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"createTime", "deviceId", "boxName", "boxFolderName", "cardPos", "cardRootpath", "cardUuid", "popFinger", "popFace", "bindUserId", "bindFinger", "bindFace", "newBiometricVerifyState"});
        SharedPreferences sharedPreferencesM1362l2 = C0212e0.m1362l(context, "FileManager_SP");
        if (sharedPreferencesM1362l2 == null) {
            return matrixCursor2;
        }
        Object[] objArr = new Object[13];
        objArr[0] = Long.valueOf(sharedPreferencesM1362l2.getLong("createTime", 0L));
        objArr[1] = sharedPreferencesM1362l2.getString("deviceId", "");
        objArr[2] = sharedPreferencesM1362l2.getString("boxName", "");
        objArr[3] = sharedPreferencesM1362l2.getString("boxFolderName", "");
        objArr[4] = Integer.valueOf(sharedPreferencesM1362l2.getInt("cardPos", 3));
        objArr[5] = sharedPreferencesM1362l2.getString("cardRootpath", "");
        objArr[6] = sharedPreferencesM1362l2.getString("cardUuid", "");
        objArr[7] = Boolean.valueOf(sharedPreferencesM1362l2.getBoolean("popFinger", false));
        objArr[8] = Boolean.valueOf(sharedPreferencesM1362l2.getBoolean("popFace", false));
        objArr[9] = sharedPreferencesM1362l == null ? null : sharedPreferencesM1362l.getString(sharedPreferencesM1362l2.getString("boxFolderName", ""), "");
        objArr[10] = Boolean.valueOf(sharedPreferencesM1362l2.getBoolean("fingerprint_isbindbox", false));
        objArr[11] = Boolean.valueOf(sharedPreferencesM1362l2.getBoolean("_isfacebindbox", false));
        objArr[12] = Integer.valueOf(sharedPreferencesM1362l2.getInt("new_biometric_need_verify", -1));
        matrixCursor2.addRow(objArr);
        return matrixCursor2;
    }

    /* renamed from: o */
    public final Cursor m15684o(String str) {
        Context context = getContext();
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(context, "MyPrefsFile");
        SharedPreferences sharedPreferencesM1362l2 = C0212e0.m1362l(context, "image_filter_size");
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "init_client", 0);
        SharedPreferences sharedPreferencesM1362l3 = C0212e0.m1362l(context, "init_client");
        SharedPreferences sharedPreferencesM1362l4 = C0212e0.m1362l(context, "HwID");
        SharedPreferences sharedPreferencesM1362l5 = C0212e0.m1362l(context, "download_save_path");
        SharedPreferences sharedPreferencesM1382b2 = C0214f0.m1382b(context, "sortInfo", 0);
        SharedPreferences sharedPreferencesM1362l6 = C0212e0.m1362l(context, "documentFilter");
        SharedPreferences sharedPreferencesM1362l7 = C0212e0.m1362l(context, "imageFilter");
        SharedPreferences sharedPreferencesM1362l8 = C0212e0.m1362l(context, "videoFilter");
        SharedPreferences sharedPreferencesM1362l9 = C0212e0.m1362l(context, "audioFilter");
        SharedPreferences sharedPreferencesM1362l10 = C0212e0.m1362l(context, "compressFilter");
        SharedPreferences sharedPreferencesM1382b3 = C0214f0.m1382b(context, SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        SharedPreferences sharedPreferencesM1382b4 = C0214f0.m1382b(context, "cloud_disk_sync_config", 0);
        SharedPreferences sharedPreferencesM1382b5 = C0214f0.m1382b(context, "MyGuideWin", 0);
        boolean z10 = sharedPreferencesM1382b2 == null;
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"setting_wifi", "setting_filter_picture", "show_system_file", "show_nomedia_file", "image_custom_size", "size_image_option", "first_boot", "confirm_upgrade", "click_back", "click_upgrade_later_time", "IFPOP", "currentPage1", "currentPage2", "ifPopWindow", "ifFirstUse", "isNeedNotify", "hasLogin", "download_path", "has_init", "allSortInfo", "InitSort", "InitCategoryFolder", "InitStorageFolder", "isShowGrid", "dochasInit", "docswitchType", "docswitchSuggestion", "imagehasInit", "imageswitchType", "videohasInit", "videoswitchType", "videoswitchSuggestion", "audiohasInit", "audioswitchType", "audioswitchSuggestion", "compresshasInit", "compressswitchType", "encrypt_mode", "changes_startCursor", "temp_startCursor", "temp_nextCursor", "comparison_startCursor", "comparison_nextCursor", "root_file_id", "push_token", "sync_all_timestamp", "force_comparison_requested", "bulk_insert_enable", "sync_endSyncTime", "setting_sync_using_mobile_network", "setting_network", "setting_auto_network"});
        Object[] objArr = new Object[52];
        objArr[0] = Boolean.valueOf(sharedPreferencesM1362l.getBoolean("setting_wifi", true));
        objArr[1] = Boolean.valueOf(sharedPreferencesM1362l.getBoolean("setting_filter_picture", true));
        objArr[2] = Boolean.valueOf(sharedPreferencesM1362l.getBoolean("show_system_file", false));
        objArr[3] = Boolean.valueOf(sharedPreferencesM1362l.getBoolean("show_nomedia_file", false));
        objArr[4] = Integer.valueOf(sharedPreferencesM1362l2.getInt("image_custom_size", 30));
        objArr[5] = Integer.valueOf(sharedPreferencesM1362l2.getInt("size_image_option", 0));
        objArr[6] = Boolean.valueOf(sharedPreferencesM1382b.getBoolean("first_boot", true));
        objArr[7] = Boolean.valueOf(sharedPreferencesM1362l3.getBoolean("confirm_upgrade", false));
        objArr[8] = Boolean.valueOf(sharedPreferencesM1362l3.getBoolean("click_back", false));
        objArr[9] = Long.valueOf(sharedPreferencesM1362l3.getLong("click_upgrade_later_time", 0L));
        objArr[10] = Boolean.valueOf(sharedPreferencesM1382b5.getBoolean("IFPOP", false));
        objArr[11] = Integer.valueOf(sharedPreferencesM1382b5.getInt("currentPage1", 0));
        objArr[12] = Integer.valueOf(sharedPreferencesM1382b5.getInt("currentPage2", 0));
        objArr[13] = Boolean.valueOf(sharedPreferencesM1382b5.getBoolean("ifPopWindow", false));
        objArr[14] = Boolean.valueOf(sharedPreferencesM1382b5.getBoolean("ifFirstUse", false));
        objArr[15] = Boolean.valueOf(sharedPreferencesM1362l4.getBoolean("isNeedNotify", false));
        objArr[16] = Boolean.valueOf(sharedPreferencesM1362l4.getBoolean("hasLogin", false));
        objArr[17] = sharedPreferencesM1362l5.getString("download_path", "");
        objArr[18] = Boolean.valueOf(sharedPreferencesM1362l5.getBoolean("has_init", false));
        objArr[19] = Long.valueOf(z10 ? 0L : sharedPreferencesM1382b2.getLong("allSortInfo", 0L));
        objArr[20] = m15693x(sharedPreferencesM1382b2, "InitSort");
        objArr[21] = m15693x(sharedPreferencesM1382b2, "InitCategoryFolder");
        objArr[22] = m15693x(sharedPreferencesM1382b2, "InitStorageFolder");
        objArr[23] = m15693x(sharedPreferencesM1382b2, "isShowGrid");
        objArr[24] = m15693x(sharedPreferencesM1362l6, "hasInit");
        objArr[25] = m15694y(sharedPreferencesM1362l6, "switchType");
        objArr[26] = m15694y(sharedPreferencesM1362l6, "switchSuggestion");
        objArr[27] = m15693x(sharedPreferencesM1362l7, "hasInit");
        objArr[28] = m15694y(sharedPreferencesM1362l7, "switchType");
        objArr[29] = m15693x(sharedPreferencesM1362l8, "hasInit");
        objArr[30] = m15694y(sharedPreferencesM1362l8, "switchType");
        objArr[31] = m15694y(sharedPreferencesM1362l8, "switchSuggestion");
        objArr[32] = m15693x(sharedPreferencesM1362l9, "hasInit");
        objArr[33] = m15694y(sharedPreferencesM1362l9, "switchType");
        objArr[34] = m15694y(sharedPreferencesM1362l9, "switchSuggestion");
        objArr[35] = m15693x(sharedPreferencesM1362l10, "hasInit");
        objArr[36] = m15694y(sharedPreferencesM1362l10, "switchType");
        objArr[37] = Integer.valueOf(sharedPreferencesM1382b3.getInt("encrypt_mode", 0));
        objArr[38] = sharedPreferencesM1382b4.getString("changes_startCursor", null);
        objArr[39] = sharedPreferencesM1382b4.getString("temp_startCursor", null);
        objArr[40] = sharedPreferencesM1382b4.getString("temp_nextCursor", null);
        objArr[41] = sharedPreferencesM1382b4.getString("comparison_startCursor", null);
        objArr[42] = sharedPreferencesM1382b4.getString("comparison_nextCursor", null);
        objArr[43] = sharedPreferencesM1382b4.getString("root_file_id", null);
        objArr[44] = sharedPreferencesM1382b4.getString("push_token", null);
        objArr[45] = Long.valueOf(sharedPreferencesM1382b4.getLong("sync_all_timestamp", 0L));
        objArr[46] = Boolean.valueOf(sharedPreferencesM1382b4.getBoolean("force_comparison_requested", false));
        objArr[47] = Boolean.valueOf(sharedPreferencesM1382b4.getBoolean("bulk_insert_enable", true));
        objArr[48] = Long.valueOf(sharedPreferencesM1382b4.getLong("sync_endSyncTime", 0L));
        objArr[49] = Boolean.valueOf(sharedPreferencesM1362l.getBoolean("setting_sync_using_mobile_network", false));
        objArr[50] = Integer.valueOf(sharedPreferencesM1362l.getInt("setting_network", 273));
        objArr[51] = Boolean.valueOf(sharedPreferencesM1362l.getBoolean("setting_auto_network", false));
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f11954a = C14343a.m85521b(getContext());
        this.f11955b = C14346d.m85527b(getContext());
        this.f11956c = C14344b.m85522d(getContext());
        return true;
    }

    /* renamed from: p */
    public final Cursor m15685p() {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"support_huawei_drive"});
        boolean zM15651J = m15651J("funcfg_huawei_drive");
        C11839m.m70686d("HicloudFeatursProvider", "supportHuaweiDrive:" + zM15651J);
        matrixCursor.addRow(new Object[]{Boolean.valueOf(zM15651J)});
        return matrixCursor;
    }

    /* renamed from: q */
    public final Cursor m15686q() {
        long jM5967n;
        if (C1006a.m5936k().m5974u()) {
            jM5967n = C1006a.m5936k().m5967n(C0213f.m1377a().getApplicationContext());
        } else {
            C11839m.m70686d("HicloudFeatursProvider", "getGalleryReleaseSize, isGallerySupportSetting()=false");
            jM5967n = 0;
        }
        C11839m.m70686d("HicloudFeatursProvider", "getGalleryReleaseSize, releaseSize=" + jM5967n);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"gallery_release_size"});
        matrixCursor.addRow(new Object[]{Long.valueOf(jM5967n)});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int iMatch = f11953e.match(uri);
        C0209d.m1247e(getContext());
        C13230i.m79500C0(C0213f.m1377a(), "HicloudFeatursProvider", getCallingPackage(), String.valueOf(iMatch));
        if (iMatch == 34) {
            return m15679j(strArr);
        }
        switch (iMatch) {
            case 1:
                return m15655N(str, strArr2);
            case 2:
                return m15650I();
            case 3:
                return m15669b0();
            case 4:
                return m15659S();
            case 5:
                return m15657P();
            case 6:
                return m15663W(str, strArr2);
            case 7:
                return m15654M();
            case 8:
                return m15665Y();
            case 9:
                return m15652K(str, strArr2);
            case 10:
                return m15666Z(strArr2, "cloudbackup");
            case 11:
                return m15666Z(strArr2, "phonefinder");
            case 12:
                return m15690u(strArr2);
            default:
                return m15671c0(iMatch, uri, strArr, str, strArr2, str2);
        }
    }

    /* renamed from: r */
    public final Cursor m15687r() {
        boolean zM5975v = C1006a.m5936k().m5975v(C0213f.m1377a());
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"gallery_switch_status"});
        matrixCursor.addRow(new Object[]{Boolean.valueOf(zM5975v)});
        return matrixCursor;
    }

    /* renamed from: s */
    public final String m15688s(Bundle bundle) {
        RecommendItem recommendItemM15670c;
        C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo start");
        Context context = getContext();
        if (context == null) {
            C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo, context is null");
            return "";
        }
        try {
            if (m15646E(context)) {
                C11839m.m70687e("HicloudFeatursProvider", "cloud disable by hand, not recommend");
                return "";
            }
            if (m15647F(context)) {
                C11839m.m70687e("HicloudFeatursProvider", "extend func switch is closed, not recommend");
                return "";
            }
            if (!m15645D(context)) {
                C11839m.m70687e("HicloudFeatursProvider", "not china region, not recommend");
                return "";
            }
            boolean zM62388s = C10028c.m62183d0(context).m62388s("is_hicloud_terms_confirm");
            C11839m.m70686d("HicloudFeatursProvider", "isAgreedHiCloudTerms is: " + zM62388s);
            if (zM62388s) {
                boolean zM15649H = m15649H(bundle);
                C11839m.m70686d("HicloudFeatursProvider", "isHwidNotLogin: " + zM15649H);
                if (zM15649H) {
                    C11839m.m70687e("HicloudFeatursProvider", "hwid not login but cloud is login");
                    return "";
                }
                recommendItemM15670c = m15670c(context, bundle);
            } else {
                recommendItemM15670c = m15668b(context, bundle);
            }
            if (recommendItemM15670c == null) {
                C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo, recommendItem is null");
                return "";
            }
            C11839m.m70686d("HicloudFeatursProvider", "add recommendItem to result");
            ArrayList arrayList = new ArrayList();
            arrayList.add(recommendItemM15670c);
            RecommendResult recommendResult = new RecommendResult();
            recommendResult.setRecommendSize(arrayList.size());
            recommendResult.setRecommends(arrayList);
            C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo end");
            return new Gson().toJson(arrayList);
        } catch (Exception e10) {
            C11839m.m70688i("HicloudFeatursProvider", "getHwidRecommendInfo exception: " + e10.toString());
            return "";
        }
    }

    /* renamed from: t */
    public final void m15689t(Context context, String str, MatrixCursor matrixCursor) {
        boolean zM6139e;
        boolean zM15651J;
        String string;
        String str2;
        C11839m.m70688i("HicloudFeatursProvider", "getLocalSwitchStatus moduleName=" + str);
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if ("cloudbackup".equals(str)) {
            zM15651J = C0209d.m1293p1() ? false : m15651J("funcfg_cloud_backup");
            zM6139e = c10028cM62182c0.m62388s("backup_key");
        } else if (!"phonefinder".equals(str)) {
            C11839m.m70688i("HicloudFeatursProvider", "no backup or phonefinder key");
            matrixCursor.addRow(new Object[]{"unknow", "illegal", null, null});
            return;
        } else {
            boolean zM15651J2 = m15651J("funcfg_find_my_phone_globe");
            zM6139e = C1010e.m6125b().m6139e(getContext());
            zM15651J = zM15651J2;
        }
        if (!zM15651J) {
            C11839m.m70688i("HicloudFeatursProvider", "module not support");
            matrixCursor.addRow(new Object[]{FaqConstants.DISABLE_HA_REPORT, "unsupport", null, null});
            return;
        }
        C11839m.m70688i("HicloudFeatursProvider", "getLocalSwitchStatus moduleName:" + str + ", switch status:" + zM6139e);
        if (zM6139e) {
            string = context.getString(R$string.settings_hicloud_open);
            str2 = JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN;
        } else {
            string = context.getString(R$string.sync_switch_button_close);
            str2 = "close";
        }
        matrixCursor.addRow(new Object[]{FaqConstants.DISABLE_HA_REPORT, str2, string, C9432i.m59149j().m59156k(str)});
    }

    /* renamed from: u */
    public final Cursor m15690u(String[] strArr) {
        String str;
        String string;
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"module_switch_result", "module_switch_content"});
        if (strArr == null || strArr.length <= 0) {
            C11839m.m70688i("HicloudFeatursProvider", "getModuleSwitchResult, args illegal");
            matrixCursor.addRow(new Object[]{"illegal", null});
            return matrixCursor;
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        Map<String, String> mapM59157l = C9432i.m59149j().m59157l(str3);
        m15658R(mapM59157l);
        Context context = getContext();
        if (context != null && mapM59157l != null && mapM59157l.containsKey("result_status") && "query_success".equals(mapM59157l.get("result_status")) && mapM59157l.containsKey(str2)) {
            String str4 = mapM59157l.get(str2);
            str = JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN;
            if (JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN.equals(str4)) {
                string = context.getString(R$string.settings_hicloud_open);
            } else {
                string = context.getString(R$string.sync_switch_button_close);
                str = "close";
            }
        } else {
            str = "query_failed";
            string = "";
        }
        C11839m.m70688i("HicloudFeatursProvider", "getModuleSwitchResult, moduleName=" + str2 + ", requestId=" + str3 + ",status=" + str + ", statusContent=" + string);
        matrixCursor.addRow(new Object[]{str, string});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: v */
    public final int m15691v(String str, String[] strArr) {
        int iM68089d = C11333k.m68086b().m68089d();
        C11839m.m70688i("HicloudFeatursProvider", "getQueryStorageTimeout, OM timeout config：" + iM68089d);
        if (str == null || strArr == null || strArr.length <= 0) {
            return iM68089d;
        }
        int iM1686d = C0241z.m1686d(strArr[0], -1);
        C11839m.m70688i("HicloudFeatursProvider", "provider set timeout config：" + iM1686d);
        return iM1686d;
    }

    /* renamed from: w */
    public final Cursor m15692w() {
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(getContext(), "FileManager_SP");
        boolean z10 = sharedPreferencesM1362l.getBoolean("quick_access_moved", false) || sharedPreferencesM1362l.getBoolean("quick_access_is_sort", false);
        C11839m.m70688i("HicloudFeatursProvider", "quickAccessMoved: " + z10);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"quick_access_original_moved"});
        matrixCursor.addRow(new Object[]{Boolean.valueOf(z10)});
        return matrixCursor;
    }

    /* renamed from: x */
    public final Object m15693x(SharedPreferences sharedPreferences, String str) {
        boolean z10 = false;
        if (sharedPreferences != null && sharedPreferences.getBoolean(str, false)) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    /* renamed from: y */
    public final Object m15694y(SharedPreferences sharedPreferences, String str) {
        return Integer.valueOf(sharedPreferences != null ? sharedPreferences.getInt(str, 0) : 0);
    }

    /* renamed from: z */
    public final Cursor m15695z(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesM1362l = C0212e0.m1362l(context, "recent_shield_preference");
        Map<String, ?> all = sharedPreferencesM1362l != null ? sharedPreferencesM1362l.getAll() : null;
        if (all == null) {
            return null;
        }
        int size = all.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i10 = 0;
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            strArr[i10] = entry.getKey();
            strArr2[i10] = (String) entry.getValue();
            i10++;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        matrixCursor.addRow(strArr2);
        return matrixCursor;
    }
}
