package com.huawei.android.p069cg.provider;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.android.backup.service.logic.C2126b;
import com.huawei.android.hicloud.album.service.hihttp.request.response.DisableStateResponse;
import com.huawei.android.hicloud.album.service.logic.callable.DisableStateRequestCallable;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.provider.AlbumProvider;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p069cg.request.response.QueryUserSpaceResponse;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.appmashup.bean.C4987f;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.hicloud.request.notify.NotifyService;
import com.huawei.hicloud.request.notify.bean.DynamicAction;
import com.huawei.hicloud.request.notify.bean.DynamicDataInfo;
import com.huawei.hicloud.request.notify.bean.DynamicDataResponse;
import com.huawei.hicloud.request.notify.bean.DynamicLangList;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p009a8.C0077o;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0223k;
import p020ap.C1007b;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p037bp.C1270a;
import p232dp.InterfaceC9284c;
import p292fn.C9733f;
import p431ko.C11079e;
import p514o9.C11827a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p664u0.C13108a;
import p701v6.C13361h;
import p703v8.C13368e;
import p709vj.C13452e;
import p836z8.C14157f;
import to.C13049a;

/* loaded from: classes2.dex */
public class AlbumProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11037a;

    /* renamed from: com.huawei.android.cg.provider.AlbumProvider$a */
    public class CallableC2313a implements Callable<Bundle> {

        /* renamed from: a */
        public final /* synthetic */ Bundle f11038a;

        public CallableC2313a(Bundle bundle) {
            this.f11038a = bundle;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle call() throws Exception {
            return AlbumProvider.this.m14576q(this.f11038a);
        }
    }

    /* renamed from: com.huawei.android.cg.provider.AlbumProvider$b */
    public class CallableC2314b implements Callable<Bundle> {

        /* renamed from: a */
        public final /* synthetic */ Bundle f11040a;

        public CallableC2314b(Bundle bundle) {
            this.f11040a = bundle;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle call() throws Exception {
            return AlbumProvider.this.m14571i(this.f11040a);
        }
    }

    /* renamed from: com.huawei.android.cg.provider.AlbumProvider$c */
    public class C2315c extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f11042a;

        /* renamed from: b */
        public final /* synthetic */ String[] f11043b;

        public C2315c(String str, String[] strArr) {
            this.f11042a = str;
            this.f11043b = strArr;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            String strM6755Z0 = C1122c.m6755Z0("04017");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("uriName", "switchStatus");
            linkedHashMap.put("callerPackageName", this.f11042a);
            String[] strArr = this.f11043b;
            if (strArr != null && strArr.length > 0) {
                linkedHashMap.put("selectionArgs", strArr[0]);
            }
            C1122c.m6753Y1(AlbumProvider.this.getContext(), C1122c.m6713L0("3027", true), "AlbumProvider switch status called", "04017", "albumProviderCall", strM6755Z0, false, linkedHashMap);
        }
    }

    /* renamed from: com.huawei.android.cg.provider.AlbumProvider$d */
    public static class C2316d extends AbstractC12367d {

        /* renamed from: a */
        public Context f11045a;

        /* renamed from: b */
        public boolean f11046b;

        public /* synthetic */ C2316d(Context context, boolean z10, CallableC2313a callableC2313a) {
            this(context, z10);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            new CommonOpsReport(this.f11045a).m15209C(OpsReport.m15259j(), "MobileSwitch", 0, String.valueOf(this.f11046b));
        }

        public C2316d(Context context, boolean z10) {
            this.f11045a = context;
            this.f11046b = z10;
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11037a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "switchStatus", 1);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "queryUid", 2);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "queryFVersion", 3);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "queryUserStatus", 4);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "albumVersionStatus", 5);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "recycleAlbumVersionStatus", 6);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "albumVersionStatus_guid", 7);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "isCloudSupportRecycle", 8);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "querySyncStatus", 10);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "updateTagFileInfo", 11);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "cloudLimitDownload", 12);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "featureList", 13);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "isCloudDisabled", 14);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "queryRemainState", 20);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "save_original_status", 15);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "update_share_localRealPath", 16);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "isCloudSupported", 17);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "mobile_data_switch", 18);
        uriMatcher.addURI("com.huawei.android.cg.albumProvider", "gallery_network_switch", 19);
    }

    /* renamed from: A */
    public static boolean m14554A(DynamicDataInfo dynamicDataInfo, List<DynamicLangList> list, Bundle bundle) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            DynamicLangList dynamicLangList = list.get(i10);
            if ("title".equals(dynamicLangList.getKey()) && dynamicLangList.getValue() != null) {
                String value = dynamicLangList.getValue();
                bundle.putString("title", value);
                m14555B(value, m14561n(value), bundle, "title");
            }
            if ("content".equals(dynamicLangList.getKey()) && dynamicLangList.getValue() != null) {
                String value2 = dynamicLangList.getValue();
                bundle.putString("content", value2);
                m14555B(value2, m14561n(value2), bundle, "content");
            }
            if ("actionDisplayName".equals(dynamicLangList.getKey()) && dynamicLangList.getValue() != null) {
                bundle.putString("confirm", dynamicLangList.getValue());
            }
            if ("title2".equals(dynamicLangList.getKey()) && dynamicLangList.getValue() != null) {
                bundle.putString("negativeTitle", dynamicLangList.getValue());
            }
            if ("content2".equals(dynamicLangList.getKey()) && dynamicLangList.getValue() != null) {
                bundle.putString("negativeContent", dynamicLangList.getValue());
            }
            if ("actionDisplayName2".equals(dynamicLangList.getKey()) && dynamicLangList.getValue() != null) {
                bundle.putString("negativeConfirm", dynamicLangList.getValue());
            }
        }
        if (bundle.get("title") == null || bundle.get("content") == null || bundle.get("confirm") == null) {
            C1120a.m6676e("AlbumProvider", "title or content null");
            return true;
        }
        if (dynamicDataInfo.getType() != 2 || (bundle.get("negativeTitle") != null && bundle.get("negativeContent") != null && bundle.get("negativeConfirm") != null)) {
            return false;
        }
        C1120a.m6676e("AlbumProvider", "title or content null");
        return true;
    }

    /* renamed from: B */
    public static void m14555B(String str, String str2, Bundle bundle, String str3) {
        if (str2 == null) {
            C11839m.m70686d("AlbumProvider", "setPlaceHolderStr,key is null");
            return;
        }
        if (str.contains(str2)) {
            C11839m.m70688i("AlbumProvider", "setPlaceHolderStr,param contains number");
            String strM14558f = m14558f(str2);
            if (TextUtils.isEmpty(strM14558f)) {
                bundle.putString(str3, null);
                return;
            }
            if (!"cp.dsu.local".equals(str2)) {
                bundle.putString(str3, bundle.getString(str3).replace("%" + str2 + "%", strM14558f));
                return;
            }
            String strM1520c = C0223k.m1520c(C0213f.m1377a(), Long.parseLong(strM14558f));
            if (strM1520c == null) {
                bundle.putString(str3, null);
                return;
            }
            bundle.putString(str3, bundle.getString(str3).replace("%" + str2 + "%", strM1520c));
        }
    }

    /* renamed from: C */
    public static JsonObject m14556C(String str) {
        try {
            return (JsonObject) new Gson().fromJson(str, JsonObject.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static String m14558f(String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        ArrayList arrayList2 = new ArrayList();
        C14157f.m84942g().m84954n(arrayList, arrayList2, "EnableSync");
        if (arrayList2.isEmpty()) {
            return null;
        }
        C4987f c4987f = (C4987f) arrayList2.get(0);
        if (c4987f.m30027c().equals("0")) {
            return null;
        }
        return c4987f.m30027c();
    }

    /* renamed from: l */
    public static Bundle m14559l(DynamicDataInfo dynamicDataInfo) {
        Bundle bundle = new Bundle();
        Context contextM1377a = C0213f.m1377a();
        bundle.putInt("dialogStyle", dynamicDataInfo.getType());
        bundle.putString("cancel", contextM1377a.getString(R$string.gallery_shelve_cancel));
        bundle.putString("actionType", dynamicDataInfo.getAction().getActionType());
        bundle.putString(dynamicDataInfo.getAction().getActionType(), dynamicDataInfo.getAction().getTarget());
        if (m14554A(dynamicDataInfo, dynamicDataInfo.getLangList(), bundle)) {
            return null;
        }
        return bundle;
    }

    /* renamed from: m */
    public static Bundle m14560m(DynamicDataInfo dynamicDataInfo, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Context contextM1377a = C0213f.m1377a();
        if (m14554A(dynamicDataInfo, dynamicDataInfo.getLangList(), bundle2)) {
            return null;
        }
        bundle2.putInt("dialogStyle", dynamicDataInfo.getType());
        bundle2.putString("cancel", contextM1377a.getString(R$string.gallery_shelve_cancel));
        bundle2.putString("actionType", dynamicDataInfo.getAction().getActionType());
        if (dynamicDataInfo.getType() == 2) {
            bundle2.putString("negativeActionType", "activity");
            bundle2.putString("negativeActivity", NotifyConstants.Action.GALLERY_MAIN_ACTION);
        }
        String string = bundle.getString("customOption");
        boolean zM80830M0 = C13452e.m80781L().m80830M0();
        bundle2.putString(C2126b.MODULE_INFO_URI, dynamicDataInfo.getAction().getTarget());
        if (string == null || string.length() <= 0) {
            if (dynamicDataInfo.getType() == 1) {
                if (zM80830M0) {
                    bundle2.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=00");
                } else {
                    bundle2.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=512&sceneCode=10");
                }
            }
        } else {
            if (zM80830M0) {
                bundle2.putString("userType", "0");
                return m14563z(dynamicDataInfo, bundle2);
            }
            bundle2.putString("userType", "1");
        }
        return bundle2;
    }

    /* renamed from: n */
    public static String m14561n(String str) {
        if (!str.contains("%")) {
            return null;
        }
        return str.substring(str.indexOf("%") + 1, str.lastIndexOf("%"));
    }

    /* renamed from: t */
    public static /* synthetic */ void m14562t(MatrixCursor matrixCursor, CompletableFuture completableFuture, UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo != null && userDataStateInfo.getBmType() != -1) {
            if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
                C1120a.m6677i("AlbumProvider", "bs grade:" + userDataStateInfo.getBsGrade());
                C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            }
            int i10 = 1;
            if (userDataStateInfo.getBmType() == 1) {
                C13452e.m80781L().m80985w2(true);
                C1120a.m6677i("AlbumProvider", "new bm type:true");
            } else if (userDataStateInfo.getBmType() == 0) {
                C1120a.m6677i("AlbumProvider", "new bm type:false");
                C13452e.m80781L().m80985w2(false);
            }
            C1120a.m6677i("AlbumProvider", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
            C1136q.m6954L(userDataStateInfo.getBmGradeState());
            C1136q.m6953K(userDataStateInfo.getDataPeriod());
            C1136q.m6955M(System.currentTimeMillis());
            StorageInfo storageInfoM80226P = C13368e.m80184F().m80226P();
            long galleryUsedSize = storageInfoM80226P != null ? storageInfoM80226P.getGalleryUsedSize() : -1L;
            int remainDwnldDays = userDataStateInfo.getRemainDwnldDays() - userDataStateInfo.getDwnldPeriod2Days();
            if (remainDwnldDays < 1) {
                remainDwnldDays = 1;
            }
            int iM6977r = C1136q.m6977r();
            int iM6976q = C1136q.m6976q();
            if (iM6977r != 0 || (iM6976q != 1 && iM6976q != 2)) {
                i10 = iM6977r;
            }
            matrixCursor.addRow(new Object[]{Integer.valueOf(i10), Integer.valueOf(remainDwnldDays), Integer.valueOf(userDataStateInfo.getDwnldPeriod1Days()), Long.valueOf(galleryUsedSize)});
        }
        completableFuture.complete(matrixCursor);
    }

    /* renamed from: z */
    public static Bundle m14563z(DynamicDataInfo dynamicDataInfo, Bundle bundle) {
        if (dynamicDataInfo.getType() == 1 && bundle != null) {
            String strM6692E0 = C1122c.m6692E0();
            String strM70484i = C11827a.m70484i();
            String strM6745W = C1122c.m6745W();
            if (TextUtils.isEmpty(strM6692E0) || TextUtils.isEmpty(strM70484i) || TextUtils.isEmpty(strM6745W)) {
                C1120a.m6676e("AlbumProvider", "userAgreementAddress or autoRenewalAddress is null");
                return null;
            }
            bundle.putString("autoRenewalAgreementsAddress", strM6745W);
            bundle.putString("userAgreementsAddress", strM70484i);
            bundle.putString(C2126b.MODULE_INFO_URI, bundle.getString(C2126b.MODULE_INFO_URI) + "&packageId=" + strM6692E0);
        }
        return bundle;
    }

    /* renamed from: D */
    public final int m14564D(boolean z10) {
        return z10 ? 1 : 0;
    }

    /* renamed from: b */
    public final void m14565b(MatrixCursor matrixCursor) {
        if (!C13452e.m80781L().m80842P0()) {
            matrixCursor.addRow(new Integer[]{Integer.valueOf(C0209d.m1202Q0() ? -1 : 0)});
        } else if (CloudAlbumSettings.m14363h().m14378n()) {
            matrixCursor.addRow(new Integer[]{0});
        } else {
            matrixCursor.addRow(new Integer[]{-1});
        }
    }

    /* renamed from: c */
    public final String m14566c(double d10) {
        int i10 = (int) (d10 * 10.0d);
        int i11 = i10 / 10;
        int i12 = i10 % 10;
        if (i12 == 0) {
            return String.valueOf(i11);
        }
        return String.valueOf(i11) + "." + String.valueOf(i12);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) throws JSONException {
        C1120a.m6677i("AlbumProvider", "method: " + str);
        if ("getAlbumString".equals(str)) {
            Bundle bundle2 = new Bundle();
            if (!C10028c.m62182c0().m62413x()) {
                C1120a.m6678w("AlbumProvider", "function item switch not open");
                return bundle2;
            }
            Context contextM1377a = C0213f.m1377a();
            bundle2.putString("album_data_sync", contextM1377a.getString(R$string.mecloud_gallery_data_sync_title));
            bundle2.putString("sync_data_merge_confirm", contextM1377a.getString(R$string.sync_data_merge_confirm_tips, contextM1377a.getString(R$string.gallery_item_title)));
            bundle2.putString("dialog_cancel", contextM1377a.getString(R$string.sync_data_merge_btn_confirm));
            bundle2.putString("dialog_merge", contextM1377a.getString(R$string.notepad_switch_open_dialog_merge));
            bundle2.putString("dialog_close", contextM1377a.getString(R$string.dialog_disable));
            bundle2.putString("close_album_data_sync", contextM1377a.getString(R$string.gallery_shelve_close_switch));
            bundle2.putString("close_album_switch_confirm", contextM1377a.getString(R$string.close_switch_dialog_msg));
            return bundle2;
        }
        if ("getSpaceFullString".equals(str)) {
            Bundle bundle3 = (Bundle) C0077o.m632b().m633a(new CallableC2313a(bundle), 30L, TimeUnit.SECONDS);
            if (bundle3 != null) {
                C1120a.m6675d("AlbumProvider", "returnBundle : " + bundle3.toString());
            }
            return bundle3;
        }
        if ("getEnableSyncString".equals(str)) {
            Bundle bundle4 = (Bundle) C0077o.m632b().m633a(new CallableC2314b(bundle), 30L, TimeUnit.SECONDS);
            if (bundle4 != null) {
                C1120a.m6675d("AlbumProvider", "getEnableSyncString:title:" + bundle4.getString("title") + ";content:" + bundle4.getString("content") + ";userLabel:" + bundle4.getString("userLabel"));
                m14579u(bundle4);
            }
            return bundle4;
        }
        ArrayList<Integer> arrayList = null;
        if ("albumProviderReport".equals(str)) {
            C1120a.m6677i("AlbumProvider", "albumProviderReport start");
            if (C9733f.m60705z().m60720O("cloudPhotoDisablePrepareReport")) {
                C1120a.m6677i("AlbumProvider", "cloudPhotoDisablePrepareReport is open.");
                return null;
            }
            C1120a.m6677i("AlbumProvider", "cloudPhotoDisablePrepareReport is close.");
            if (bundle == null) {
                C1120a.m6678w("AlbumProvider", "albumProviderReport bundle is null");
                return null;
            }
            String string = bundle.getString("reportDots");
            C1120a.m6675d("AlbumProvider", "Sync provider report param: " + string);
            try {
                JSONObject jSONObject = new JSONObject(string);
                jSONObject.put("thirdAppVersion", C1122c.m6833t0(C0213f.m1377a()));
                UBAAnalyze.m29952M("CKC", "cloudphoto_sync_prepare", jSONObject);
            } catch (JSONException unused) {
                C1120a.m6676e("AlbumProvider", "albumProviderReport JSONException.");
            }
            C1120a.m6677i("AlbumProvider", "albumProviderReport end");
        } else {
            if ("getUserSpaceSize".equals(str)) {
                try {
                    C1120a.m6677i("AlbumProvider", "getUserSpaceSize start");
                    long j10 = C0214f0.m1382b(getContext().getApplicationContext(), "com.huawei.android.ds_spcace_detail_cache", 0).getLong("total_space_sp_key", -1L);
                    C1120a.m6677i("AlbumProvider", "total Space Size: " + j10);
                    Bundle bundle5 = new Bundle();
                    bundle5.putLong("totalSpaceSize", j10);
                    C1120a.m6677i("AlbumProvider", "getUserSpaceSize end");
                    return bundle5;
                } catch (Exception e10) {
                    C1120a.m6676e("AlbumProvider", "getUserSpaceSize exception:" + e10.toString());
                }
            } else if ("getIntervalTime".equals(str)) {
                try {
                    C1120a.m6677i("AlbumProvider", "getIntervalTime start");
                    HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
                    if (hiCloudSysParamMapM60757p == null) {
                        C1120a.m6678w("AlbumProvider", "configMap is null, getGalleryFrequencyList fail");
                    } else {
                        String galleryFrequencyList = hiCloudSysParamMapM60757p.getGalleryFrequencyList();
                        if (!TextUtils.isEmpty(galleryFrequencyList)) {
                            try {
                                JSONArray jSONArray = new JSONArray(galleryFrequencyList);
                                if (jSONArray.length() > 0) {
                                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                        arrayList2.add(Integer.valueOf(jSONArray.getInt(i10)));
                                    }
                                    arrayList = arrayList2;
                                }
                            } catch (Exception e11) {
                                C1120a.m6676e("AlbumProvider", "get galleryFrequencyList exception: " + e11.toString());
                            }
                        }
                    }
                    Bundle bundle6 = new Bundle();
                    bundle6.putIntegerArrayList("intervalArray", arrayList);
                    C1120a.m6677i("AlbumProvider", "getIntervalTime end");
                    return bundle6;
                } catch (Exception e12) {
                    C1120a.m6676e("AlbumProvider", "getIntervalTime exception:" + e12.toString());
                }
            }
        }
        return super.call(str, str2, bundle);
    }

    /* renamed from: d */
    public double m14567d(Context context) {
        if (C13368e.m80184F().m80224M() != null) {
            return (r2.getTotal() - r2.getUsed()) / 1048576.0d;
        }
        C1120a.m6677i("AlbumProvider", "Failed to query the space from the cache.");
        return Double.MAX_VALUE;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* renamed from: e */
    public double m14568e(Context context) {
        ?? M15254d;
        long j10;
        long j11;
        long totalSpaceSize;
        ?? r62 = "AlbumProvider";
        long j12 = 0;
        try {
            M15254d = OpsReport.m15254d();
            try {
            } catch (Exception e10) {
                e = e10;
                C1120a.m6676e(r62, "queryUserSpaceSync error:" + e.toString());
                j10 = M15254d;
                return (j12 - j10) / 1048576.0d;
            }
        } catch (Exception e11) {
            e = e11;
            M15254d = 0;
        }
        if (CloudAlbumSettings.m14363h().m14378n()) {
            CloudSpace cloudSpaceM78755s = new C13049a(EnumC12999a.CLOUD_ALBUM, M15254d).m78755s(true);
            long used = cloudSpaceM78755s.getUsed();
            totalSpaceSize = cloudSpaceM78755s.getTotal();
            M15254d = used;
        } else {
            QueryUserSpaceResponse queryUserSpaceResponseM80152u = new C13361h((String) M15254d, context).m80152u(QueryUserSpaceResponse.class, true);
            int code = queryUserSpaceResponseM80152u.getCode();
            C1120a.m6677i("AlbumProvider", "queryUserSpaceSync bapi.dbank.queryspace: " + code);
            if (code != 0) {
                j11 = 0;
                j10 = j12;
                j12 = j11;
                return (j12 - j10) / 1048576.0d;
            }
            long useSpaceSize = queryUserSpaceResponseM80152u.getUseSpaceSize();
            totalSpaceSize = queryUserSpaceResponseM80152u.getTotalSpaceSize();
            M15254d = useSpaceSize;
        }
        r62 = totalSpaceSize;
        j12 = M15254d;
        j11 = r62;
        j10 = j12;
        j12 = j11;
        return (j12 - j10) / 1048576.0d;
    }

    /* renamed from: g */
    public final MatrixCursor m14569g() {
        final MatrixCursor matrixCursor = new MatrixCursor(new String[]{"remainState", "remainTime", "remainMax", "galleryUsed"});
        final CompletableFuture completableFuture = new CompletableFuture();
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.bm.type");
        arrayList.add("bs.bm.usergrade.info");
        C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: u6.a
            @Override // p431ko.C11079e.a
            /* renamed from: a */
            public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                AlbumProvider.m14562t(matrixCursor, completableFuture, userDataStateInfo);
            }
        }, false, arrayList, "StateAndRemain"), false);
        try {
            return (MatrixCursor) completableFuture.get(30L, TimeUnit.SECONDS);
        } catch (Exception e10) {
            C1120a.m6677i("AlbumProvider", "getDateStateAndRemainDays fail:" + e10.getMessage());
            return matrixCursor;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* renamed from: h */
    public final MatrixCursor m14570h() throws ExecutionException, InterruptedException, TimeoutException {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"switchStatus", "Remain", "DisableTime"});
        if (!CloudAlbumSettings.m14363h().m14385u() || CloudAlbumSettings.m14363h().m14378n()) {
            C1120a.m6678w("AlbumProvider", "getDisableStatusCursor nonSupport");
            matrixCursor.addRow(new Object[]{2, 0, 0});
            return matrixCursor;
        }
        if (C13452e.m80781L().m80932j1()) {
            C1120a.m6678w("AlbumProvider", "queryDisableState sync risk effective or st invalid");
            matrixCursor.addRow(new Object[]{-1, 0, 0});
            return matrixCursor;
        }
        if (!C0209d.m1333z1(getContext())) {
            C1120a.m6678w("AlbumProvider", "queryDisableState network disconnected!");
            matrixCursor.addRow(new Object[]{-1, 0, 0});
            return matrixCursor;
        }
        DisableStateRequestCallable disableStateRequestCallable = new DisableStateRequestCallable(getContext());
        C12515a.m75110o().m75175e(disableStateRequestCallable, false);
        Future<?> future = disableStateRequestCallable.getFuture();
        if (future == null) {
            C1120a.m6678w("AlbumProvider", "queryDisableState CloudTaskManager execute error");
            matrixCursor.addRow(new Object[]{-1, 0, 0});
            return matrixCursor;
        }
        try {
            future.get(10000L, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e10) {
            C1120a.m6676e("AlbumProvider", "init timeout:" + e10.getMessage());
        } catch (Exception e11) {
            C1120a.m6676e("AlbumProvider", "future get error: " + e11.getMessage());
        }
        DisableStateResponse response = disableStateRequestCallable.getResponse();
        if (response == null) {
            C1120a.m6676e("AlbumProvider", "disableStateResponse is null");
        } else {
            int code = response.getCode();
            int status = response.getStatus();
            if (code == 0) {
                C1136q.b.m6992B0(getContext(), status);
                C1136q.b.m7097s1(C0213f.m1377a(), status, response.getDeleteTime());
            } else {
                C1120a.m6676e("AlbumProvider", "disableStateResponse code is " + code);
            }
        }
        int iM7095s = C1136q.b.m7095s(getContext());
        int i10 = iM7095s != -1 ? iM7095s : 2;
        int iM6683B0 = C1122c.m6683B0(getContext());
        long jM7025S = C1136q.b.m7025S(getContext());
        C1120a.m6677i("AlbumProvider", "queryDisableState: status, remain, deadline:" + i10 + "," + iM6683B0 + "," + jM7025S);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i10), Integer.valueOf(iM6683B0), Long.valueOf(jM7025S)});
        return matrixCursor;
    }

    /* renamed from: i */
    public Bundle m14571i(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("AlbumProvider", "getEnableSyncString bundle is null.");
            return null;
        }
        if (C13452e.m80781L().m80887a1()) {
            if (C9733f.m60705z().m60720O("enableProvideGalleryDisplayContentV2")) {
                return m14572j();
            }
            C1120a.m6678w("AlbumProvider", "enableProvideGalleryDisplayContentV2 is close.");
            return null;
        }
        if (C9733f.m60705z().m60720O("enableProvideGalleryDisplayContent")) {
            return m14573k(bundle);
        }
        C1120a.m6678w("AlbumProvider", "enableProvideGalleryDisplayContent is close.");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* renamed from: j */
    public Bundle m14572j() {
        DynamicDataResponse dynamicDataResponseQueryObtain = new NotifyService().queryObtain("OPEN_CLOUD_PHOTO_IN_APP");
        if (dynamicDataResponseQueryObtain == null || dynamicDataResponseQueryObtain.getData() == null || dynamicDataResponseQueryObtain.getTitle() == null) {
            C1120a.m6676e("AlbumProvider", "getEnableSyncStringNewBusiness response null");
            return null;
        }
        DynamicDataInfo data = dynamicDataResponseQueryObtain.getData();
        if (data.getLangList() == null || data.getAction() == null) {
            C1120a.m6676e("AlbumProvider", "getEnableSyncStringNewBusiness response  or lang list  or action is null");
            return null;
        }
        DynamicAction action = data.getAction();
        if (action.getActionType() == null || action.getTarget() == null) {
            C1120a.m6676e("AlbumProvider", "getEnableSyncStringNewBusiness action content null");
            return null;
        }
        Bundle bundleM14559l = m14559l(dynamicDataResponseQueryObtain.getData());
        if (bundleM14559l != null) {
            bundleM14559l.putString("userLabel", dynamicDataResponseQueryObtain.getTitle());
            if (C13452e.m80781L().m80830M0()) {
                bundleM14559l.putString("userType", "0");
            } else {
                bundleM14559l.putString("userType", "1");
            }
            C1120a.m6675d("AlbumProvider", "getEnableSyncStringNewBusiness:" + bundleM14559l.toString());
        }
        return bundleM14559l;
    }

    /* renamed from: k */
    public Bundle m14573k(Bundle bundle) {
        String string = bundle.getString(SnapshotBackupMeta.KEY_SHOW_TYPE);
        Bundle bundle2 = new Bundle();
        Context contextM1377a = C0213f.m1377a();
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean z10 = !C11829c.m70532M0() || C10028c.m62182c0().m62413x();
        if (!C13452e.m80781L().m80842P0() || !zM62221H1 || !z10) {
            C1120a.m6675d("AlbumProvider", "The user has not logged in.");
            return m14582x(contextM1377a);
        }
        C1120a.m6675d("AlbumProvider", "The user has logged in.");
        boolean zM6807m1 = C1122c.m6807m1(contextM1377a);
        if (zM6807m1) {
            C1120a.m6675d("AlbumProvider", "The album sync Switch is open.");
            return null;
        }
        if (C13452e.m80781L().m80791C0()) {
            C1120a.m6675d("AlbumProvider", "The user switch to a new business model.");
            return m14582x(contextM1377a);
        }
        double dM14567d = (string == null || !string.equals("headView")) ? m14567d(contextM1377a) : m14568e(contextM1377a);
        C1120a.m6677i("AlbumProvider", "remainingSpace:" + dM14567d);
        if (dM14567d < 10.0d) {
            C1120a.m6675d("AlbumProvider", "The current cloud storage space is full.");
            bundle2.putString("sceneCode", "33");
            String string2 = contextM1377a.getString(R$string.cancel);
            Locale locale = Locale.ROOT;
            bundle2.putString("cancel", string2.toUpperCase(locale));
            bundle2.putString("title", contextM1377a.getString(R$string.enable_sync_title_33));
            bundle2.putString("content", contextM1377a.getString(R$string.enable_sync_content_33));
            bundle2.putString("confirm", contextM1377a.getString(R$string.enable_and_upgrade).toUpperCase(locale));
            bundle2.putString("actionType", C2126b.MODULE_INFO_URI);
            bundle2.putString("activity", null);
            bundle2.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=33");
            return bundle2;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        boolean zM6017h = C1007b.m5980s().m6017h();
        if (!zM62388s || !zM6017h) {
            return !zM6807m1 ? m14582x(contextM1377a) : bundle2;
        }
        C1120a.m6675d("AlbumProvider", "user enable backup.");
        bundle2.putString("sceneCode", "32");
        String string3 = contextM1377a.getString(R$string.cancel);
        Locale locale2 = Locale.ROOT;
        bundle2.putString("cancel", string3.toUpperCase(locale2));
        bundle2.putString("title", contextM1377a.getString(R$string.enable_sync_title_32));
        bundle2.putString("content", contextM1377a.getString(R$string.enable_sync_content_32));
        bundle2.putString("confirm", contextM1377a.getString(R$string.start_enabled_now).toUpperCase(locale2));
        bundle2.putString("actionType", "activity");
        bundle2.putString("activity", NotifyConstants.Action.GALLERY_MAIN_ACTION);
        bundle2.putString(C2126b.MODULE_INFO_URI, null);
        return bundle2;
    }

    /* renamed from: o */
    public final Bundle m14574o(Bundle bundle) {
        double d10 = bundle.getDouble("releasableSize");
        int i10 = bundle.getInt("cloudPhotoCount");
        int i11 = bundle.getInt("notUploadedCount");
        int i12 = bundle.getInt("extendedFlags");
        ArrayList arrayList = new ArrayList();
        arrayList.add("bc.device.count");
        String strM30027c = null;
        List<C4987f> listM84949i = C14157f.m84942g().m84949i(arrayList, null, "SpaceFull");
        if (listM84949i != null && listM84949i.size() != 0) {
            strM30027c = listM84949i.get(0).m30027c();
        }
        boolean zM80791C0 = C13452e.m80781L().m80791C0();
        C1120a.m6677i("AlbumProvider", "getSpaceFullString: releasableSize, cloudPhotoCount, notUploadedCount,extendedFlags,deviceCount,isFreeUser:" + d10 + "," + i10 + "," + i11 + "," + i12 + "," + strM30027c + "," + zM80791C0);
        return m14578s(d10, i10, i11, i12, strM30027c, zM80791C0);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    /* renamed from: p */
    public final Bundle m14575p(Bundle bundle) {
        C1122c.m6804l2(bundle.getInt("notUploadedCount"), getContext().getApplicationContext());
        DynamicDataResponse dynamicDataResponseQueryObtain = new NotifyService().queryObtain("USER_SPACE_FULL_IN_APP");
        if (dynamicDataResponseQueryObtain == null || dynamicDataResponseQueryObtain.getData() == null || dynamicDataResponseQueryObtain.getTitle() == null) {
            C1120a.m6676e("AlbumProvider", "getSpaceFullOldBusiness response  or lang list  or action is null");
            return null;
        }
        DynamicDataInfo data = dynamicDataResponseQueryObtain.getData();
        if (data.getLangList() == null || data.getAction() == null) {
            C1120a.m6676e("AlbumProvider", "getSpaceFullOldBusiness response  or lang list  or action is null");
            return null;
        }
        DynamicAction action = data.getAction();
        if (action.getActionType() == null || action.getTarget() == null) {
            C1120a.m6676e("AlbumProvider", "getSpaceFullOldBusiness action content null");
            return null;
        }
        Bundle bundleM14560m = m14560m(data, bundle);
        if (bundleM14560m != null) {
            bundleM14560m.putString("userLabel", dynamicDataResponseQueryObtain.getTitle());
        }
        return bundleM14560m;
    }

    /* renamed from: q */
    public Bundle m14576q(Bundle bundle) {
        if (bundle == null) {
            C1120a.m6676e("AlbumProvider", "GET_SPACE_FULL_STRING bundle is null.");
            return null;
        }
        if (C13452e.m80781L().m80887a1()) {
            if (C9733f.m60705z().m60720O("enableProvideGalleryDisplayContent")) {
                return m14574o(bundle);
            }
            C1120a.m6678w("AlbumProvider", "enableProvideGalleryDisplayContent is close.");
            return null;
        }
        if (C9733f.m60705z().m60720O("enableProvideGalleryDisplayContentV2")) {
            return m14575p(bundle);
        }
        C1120a.m6678w("AlbumProvider", "enableProvideGalleryDisplayContentV2 is close.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x017e  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.Cursor query(android.net.Uri r5, java.lang.String[] r6, java.lang.String r7, java.lang.String[] r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.provider.AlbumProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* renamed from: r */
    public final MatrixCursor m14577r(Uri uri, MatrixCursor matrixCursor, int i10) {
        if (matrixCursor == null) {
            return null;
        }
        if (i10 == 10) {
            int iM7033W = C1136q.e.m7166d(getContext()) ? C1136q.b.m7033W(getContext()) : 1;
            long jM7003H = C1136q.e.m7166d(getContext()) ? C1136q.b.m7003H(getContext()) : 0L;
            matrixCursor.addRow(new Integer[]{Integer.valueOf(iM7033W)});
            matrixCursor.addRow(new Long[]{Long.valueOf(jM7003H)});
            return matrixCursor;
        }
        if (i10 == 20) {
            return m14569g();
        }
        if (i10 == 13) {
            matrixCursor.addRow(new Integer[]{7});
            return matrixCursor;
        }
        if (i10 == 14) {
            return m14570h();
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    /* renamed from: s */
    public final Bundle m14578s(double d10, int i10, int i11, int i12, String str, boolean z10) {
        Bundle bundleM14583y;
        new Bundle();
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        int asInt = 2000;
        int i13 = 10;
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6677i("AlbumProvider", "configMap is null, about minReleasableSize and minCloudPhotoCount.");
        } else {
            String scenarioConditionsForGallerySpaceFull = hiCloudSysParamMapM60757p.getScenarioConditionsForGallerySpaceFull();
            if (scenarioConditionsForGallerySpaceFull == null) {
                C1120a.m6677i("AlbumProvider", "scenarioConditions is null, about minReleasableSize and minCloudPhotoCount.");
            } else {
                JsonObject jsonObjectM14556C = m14556C(scenarioConditionsForGallerySpaceFull);
                try {
                    int asInt2 = jsonObjectM14556C.get("minReleasableSize").getAsInt();
                    asInt = jsonObjectM14556C.get("minCloudPhotoCount").getAsInt();
                    i13 = asInt2;
                } catch (Exception unused) {
                    C1120a.m6677i("AlbumProvider", "scenarioConditions is not legal, about minReleasableSize and minCloudPhotoCount.");
                }
            }
        }
        C1120a.m6677i("AlbumProvider", "minReleasableSize,minCloudPhotoCount:" + i13 + "," + asInt);
        String str2 = z10 ? "free" : "paying";
        if (str != null && Integer.parseInt(str) >= 2) {
            C1120a.m6677i("AlbumProvider", "scenarioNo is 2");
            bundleM14583y = m14583y(d10, i10, i11, "free".equals(str2) ? "02" : "12");
        } else if (d10 > i13) {
            C1120a.m6677i("AlbumProvider", "scenarioNo is 1");
            bundleM14583y = m14583y(d10, i10, i11, "free".equals(str2) ? HiAnalyticsConstant.KeyAndValue.NUMBER_01 : "11");
        } else if (i10 >= asInt) {
            C1120a.m6677i("AlbumProvider", "scenarioNo is 4");
            bundleM14583y = m14583y(d10, i10, i11, "free".equals(str2) ? "04" : "14");
        } else if ((i12 & 1) > 0) {
            C1120a.m6677i("AlbumProvider", "scenarioNo is 3");
            bundleM14583y = m14583y(d10, i10, i11, "free".equals(str2) ? "03" : DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN);
        } else {
            C1120a.m6677i("AlbumProvider", "scenarioNo is default");
            bundleM14583y = m14583y(d10, i10, i11, "free".equals(str2) ? "00" : "10");
        }
        m14580v(bundleM14583y, str2);
        return bundleM14583y;
    }

    /* renamed from: u */
    public final void m14579u(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sceneCode", bundle.getString("sceneCode"));
        UBAAnalyze.m29947H("CKC", "gallery_guide_open_copywriting", linkedHashMap);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iMatch = f11037a.match(uri);
        if (iMatch != 18) {
            if (iMatch != 19) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            boolean zBooleanValue = contentValues.getAsBoolean("GalleryNetworkSwitch").booleanValue();
            C1120a.m6677i("AlbumProvider", "update galleryNetworkSwitch: " + zBooleanValue);
            if (!CloudAlbumSettings.m14363h().m14386v()) {
                return -1;
            }
            CloudAlbumSettings.m14363h().m14365B(zBooleanValue);
            return -1;
        }
        boolean zBooleanValue2 = contentValues.getAsBoolean("MobileSwitch").booleanValue();
        C1120a.m6677i("AlbumProvider", "update mobileSwitch: " + zBooleanValue2);
        CloudAlbumSettings.m14363h().m14367D(zBooleanValue2);
        Intent intent = new Intent("com.huawei.cg.action.MOBILE_SWITCH");
        intent.putExtra("MobileSwitch", zBooleanValue2);
        Context context = getContext();
        if (context == null) {
            C1120a.m6676e("AlbumProvider", "update mobileSwitch context is null");
            return -1;
        }
        C13108a.m78878b(context).m78881d(intent);
        if (!zBooleanValue2 && !C0209d.m1254f2(context)) {
            InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
            if (interfaceC9284c == null) {
                C1120a.m6676e("AlbumProvider", "update mobileSwitch cloudSyncRouter is null");
            } else {
                interfaceC9284c.mo17102Q("atlas", FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
            }
        }
        CloudAlbumManager.m14456v().m14475U(context, zBooleanValue2);
        C12515a.m75110o().m75175e(new C2316d(context, zBooleanValue2, null), false);
        return -1;
    }

    /* renamed from: v */
    public final void m14580v(Bundle bundle, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sceneCode", bundle.getString("sceneCode"));
        linkedHashMap.put("userType", str);
        UBAAnalyze.m29947H("CKC", "gallery_full_text", linkedHashMap);
    }

    /* renamed from: w */
    public final void m14581w(String[] strArr, String str) {
        C12515a.m75110o().m75175e(new C2315c(str, strArr), false);
    }

    /* renamed from: x */
    public final Bundle m14582x(Context context) {
        C1120a.m6675d("AlbumProvider", "backup and synchronization are not enabled.");
        Bundle bundle = new Bundle();
        bundle.putString("sceneCode", "31");
        String string = context.getString(R$string.cancel);
        Locale locale = Locale.ROOT;
        bundle.putString("cancel", string.toUpperCase(locale));
        bundle.putString("title", context.getString(R$string.enable_sync_title_31));
        bundle.putString("content", context.getString(R$string.enable_sync_content_31));
        bundle.putString("confirm", context.getString(R$string.start_enabled_now).toUpperCase(locale));
        bundle.putString("actionType", "activity");
        bundle.putString("activity", NotifyConstants.Action.GALLERY_MAIN_ACTION);
        bundle.putString(C2126b.MODULE_INFO_URI, null);
        return bundle;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @SuppressLint({"ResourceType"})
    /* renamed from: y */
    public final Bundle m14583y(double d10, int i10, int i11, String str) {
        char c10;
        Bundle bundle = new Bundle();
        Context contextM1377a = C0213f.m1377a();
        Resources resources = contextM1377a.getResources();
        bundle.putString("cancel", contextM1377a.getString(R$string.cancel));
        bundle.putString("actionType", C2126b.MODULE_INFO_URI);
        bundle.putString("activity", null);
        if ("0".equals(str.substring(0, 1))) {
            bundle.putString("confirm", contextM1377a.getString(R$string.low_space_tip_buy));
        } else {
            bundle.putString("confirm", contextM1377a.getString(R$string.gallery_full_dialog_confirm));
        }
        int i12 = (int) ((1000.0d * d10) / 5.0d);
        String strM14566c = m14566c(d10);
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c10 = 2;
                    c11 = c10;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c10 = 3;
                    c11 = c10;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c10 = 4;
                    c11 = c10;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c10 = 5;
                    c11 = c10;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c10 = 6;
                    c11 = c10;
                    break;
                }
                break;
            case 1570:
                if (str.equals(DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN)) {
                    c10 = 7;
                    c11 = c10;
                    break;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    c10 = '\b';
                    c11 = c10;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 00");
                bundle.putString("sceneCode", "00");
                bundle.putString("title", contextM1377a.getString(R$string.gallery_full_dialog_title_00));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_free_00));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=00");
                return bundle;
            case 1:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 01");
                bundle.putString("sceneCode", HiAnalyticsConstant.KeyAndValue.NUMBER_01);
                bundle.putString("title", resources.getString(R$string.gallery_full_dialog_title_01, C0223k.m1529l(resources.getString(R$string.hidisk_file_size_gb, strM14566c))));
                bundle.putString("content", StringUtil.globalizeNum(contextM1377a.getResources().getQuantityString(R$plurals.gallery_full_dialog_content_free_01, i12, Integer.valueOf(i12)), Integer.valueOf(i12)));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=01");
                return bundle;
            case 2:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 02");
                bundle.putString("sceneCode", "02");
                bundle.putString("title", contextM1377a.getResources().getQuantityString(R$plurals.gallery_full_dialog_title_02, i11, Integer.valueOf(i11)));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_free_02));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=02");
                return bundle;
            case 3:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 03");
                bundle.putString("sceneCode", "03");
                bundle.putString("title", contextM1377a.getString(R$string.gallery_full_dialog_title_03));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_free_03));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=03");
                return bundle;
            case 4:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 04");
                bundle.putString("sceneCode", "04");
                bundle.putString("title", contextM1377a.getResources().getQuantityString(R$plurals.gallery_full_dialog_title_04, i10, Integer.valueOf(i10)));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_free_04));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=PackageInfoActivity&srcChannel=512&salChannel=500&activityCode=100&sceneCode=04");
                return bundle;
            case 5:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 11");
                bundle.putString("sceneCode", "11");
                bundle.putString("title", resources.getString(R$string.gallery_full_dialog_title_01, C0223k.m1529l(resources.getString(R$string.hidisk_file_size_gb, strM14566c))));
                bundle.putString("content", StringUtil.globalizeNum(contextM1377a.getResources().getQuantityString(R$plurals.gallery_full_dialog_content_paying_11, i12, Integer.valueOf(i12)), Integer.valueOf(i12)));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=512&sceneCode=11");
                return bundle;
            case 6:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 12");
                bundle.putString("sceneCode", "12");
                bundle.putString("title", contextM1377a.getResources().getQuantityString(R$plurals.gallery_full_dialog_title_02, i11, Integer.valueOf(i11)));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_paying_12));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=512&sceneCode=12");
                return bundle;
            case 7:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 13");
                bundle.putString("sceneCode", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN);
                bundle.putString("title", contextM1377a.getString(R$string.gallery_full_dialog_title_03));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_paying_13));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=512&sceneCode=13");
                return bundle;
            case '\b':
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 14");
                bundle.putString("sceneCode", "14");
                bundle.putString("title", contextM1377a.getResources().getQuantityString(R$plurals.gallery_full_dialog_title_04, i10, Integer.valueOf(i10)));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_paying_14));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=512&sceneCode=14");
                return bundle;
            default:
                C1120a.m6677i("AlbumProvider", "scenarioNo is : 10");
                bundle.putString("sceneCode", "10");
                bundle.putString("title", contextM1377a.getString(R$string.gallery_full_dialog_title_00));
                bundle.putString("content", contextM1377a.getString(R$string.gallery_full_dialog_content_paying_10));
                bundle.putString(C2126b.MODULE_INFO_URI, "hicloud://cloudDrive/getInfo?path=HisyncSpaceDetailActivity&srcChannel=512&sceneCode=10");
                return bundle;
        }
    }
}
