package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncObserverServiceInvoker;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import gp.C10028c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0233r;
import p015ak.C0240y;
import p020ap.C1006a;
import p514o9.C11839m;
import p675uc.C13153a;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class SyncProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11984a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11984a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.sync.syncProvider", "switchState", 1);
        uriMatcher.addURI("com.huawei.android.sync.syncProvider", "isSyncRecycle", 2);
        uriMatcher.addURI("com.huawei.android.sync.syncProvider", "setSwitchState", 3);
    }

    /* renamed from: a */
    public final boolean m15733a() {
        BatteryManager batteryManager = (BatteryManager) getContext().getSystemService("batterymanager");
        if (batteryManager == null) {
            return false;
        }
        int intProperty = batteryManager.getIntProperty(4);
        if (intProperty >= 10) {
            C11839m.m70686d("SyncProvider", "isGallerySyncConditionPermit, battery state is = " + intProperty);
            return true;
        }
        C11839m.m70689w("SyncProvider", "isGallerySyncConditionPermit, battery state is = " + intProperty);
        return false;
    }

    /* renamed from: b */
    public final void m15734b(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            C11839m.m70687e("SyncProvider", "query, selectionArgs is null");
            throw new IllegalArgumentException("selection args is error.");
        }
        List<String> allShownSyncServiceId = NotifyUtil.getAllShownSyncServiceId(getContext());
        String str = strArr[0];
        if (!allShownSyncServiceId.contains(str)) {
            throw new IllegalArgumentException("selection args is error: syncType = " + str);
        }
        if (strArr.length >= 2) {
            String str2 = strArr[1];
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("selection args is error: syncType or dataType is null");
            }
        }
    }

    /* renamed from: c */
    public final boolean m15735c() {
        if (!C1006a.m5936k().m5975v(getContext())) {
            C11839m.m70689w("SyncProvider", "isGallerySyncConditionPermit, switch is off");
            return false;
        }
        if ((!C1006a.m5936k().m5977x() || !C0209d.m1333z1(getContext())) && !C0209d.m1254f2(getContext())) {
            C11839m.m70689w("SyncProvider", "isGallerySyncConditionPermit, wifi is not available");
            return false;
        }
        return m15733a();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) throws JSONException {
        super.call(str, str2, bundle);
        C11839m.m70688i("SyncProvider", "Sync provider call method name = " + str);
        if (TextUtils.equals("reportPrepare", str)) {
            if (bundle == null) {
                C11839m.m70689w("SyncProvider", "Sync provider bundle null");
                return null;
            }
            try {
                String callingPackage = getCallingPackage();
                String strM1681c = C0240y.m1681c(getContext(), callingPackage);
                JSONObject jSONObject = new JSONObject(bundle.getString("report_param"));
                jSONObject.put("thirdAppPkgName", callingPackage);
                jSONObject.put("thirdAppVersion", strM1681c);
                C11839m.m70686d("SyncProvider", "Sync provider report param: " + jSONObject.toString());
                UBAAnalyze.m29952M("CKC", "cloudsync_sync_prepare", jSONObject);
            } catch (Exception e10) {
                C11839m.m70687e("SyncProvider", "Sync provider call param error " + e10.getMessage());
            }
        }
        return null;
    }

    /* renamed from: d */
    public final boolean m15736d(Context context, String[] strArr) throws Throwable {
        if (strArr.length == 1) {
            boolean zIsServiceSupportRecycleProcess = SyncLogicService.isServiceSupportRecycleProcess(strArr[0]);
            C11839m.m70688i("SyncProvider", "Module name: " + strArr[0] + ", isSyncRecycle: " + zIsServiceSupportRecycleProcess);
            return zIsServiceSupportRecycleProcess;
        }
        if (strArr.length < 2) {
            return false;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        boolean zIsServiceSupportRecycleProcess2 = SyncLogicService.isServiceSupportRecycleProcess(context, str, str2);
        C11839m.m70688i("SyncProvider", "Module name: " + strArr[0] + ", dataType: " + str2 + ", isSyncRecycle: " + zIsServiceSupportRecycleProcess2);
        return zIsServiceSupportRecycleProcess2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final String m15737e(String[] strArr) {
        if (strArr.length < 2) {
            C11839m.m70687e("SyncProvider", "setSwitchState selectionArgs invalid");
            throw new IllegalArgumentException("selectionArgs invalid");
        }
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("SyncProvider", "setSwitchState syncType is null");
            throw new IllegalArgumentException("syncType is null");
        }
        String str2 = strArr[1];
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70687e("SyncProvider", "setSwitchState switchState is null");
            throw new IllegalArgumentException("switchState is null");
        }
        if (!"1".equals(str2) && !"0".equals(str2)) {
            C11839m.m70687e("SyncProvider", "setSwitchState switchState invalid: " + str2);
            throw new IllegalArgumentException("switchState invalid");
        }
        if (!C13452e.m80781L().m80842P0()) {
            C11839m.m70687e("SyncProvider", "setSwitchState cloud not login");
            return "-2";
        }
        if (!NotifyUtil.getSyncTypes().contains(str) && !NotifyUtil.getShownSyncServiceId(getContext()).contains(str)) {
            C11839m.m70687e("SyncProvider", "setSwitchState syncType invalid: " + str);
            throw new IllegalArgumentException("syncType invalid: " + str);
        }
        C11839m.m70688i("SyncProvider", "setSwitchState syncType: " + str + " switchState: " + str2);
        boolean zEquals = "1".equals(str2);
        C10028c.m62182c0().m62336h2(str, zEquals);
        SyncObserverServiceInvoker.getInstance();
        SyncObserverServiceInvoker.notifySwitchChange(getContext(), str, zEquals, "syncProvider");
        CloudSyncUtil.m16020j1(str, zEquals ? "1" : "2", zEquals ? "1" : "2", 3);
        return "0";
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        boolean zM62388s;
        int iM82983a = C0233r.m1618b().m1619c().m82980j(1500L).m82983a();
        if (iM82983a != 0) {
            C11839m.m70689w("SyncProvider", "init not complete yet: " + iM82983a);
            return null;
        }
        C11839m.m70686d("SyncProvider", "query, uri = " + uri);
        int iMatch = f11984a.match(uri);
        C0209d.m1247e(getContext());
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"switchState", "getVersionCode"});
        C10028c c10028cM62183d0 = C10028c.m62183d0(getContext());
        C13230i.m79500C0(C0213f.m1377a(), "SyncProvider", getCallingPackage(), String.valueOf(iMatch));
        if (iMatch == -1) {
            matrixCursor.close();
            return matrixCursor;
        }
        if (iMatch != 1) {
            if (iMatch == 2) {
                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"isSyncRecycle"});
                m15734b(strArr2);
                matrixCursor2.addRow(new Object[]{Boolean.valueOf(m15736d(getContext(), strArr2))});
                return matrixCursor2;
            }
            if (iMatch == 3) {
                MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{"result"});
                matrixCursor3.addRow(new Object[]{m15737e(strArr2)});
                return matrixCursor3;
            }
            throw new IllegalArgumentException("Unkown URI " + uri);
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "account_info", 0);
        boolean z10 = (sharedPreferencesM1382b == null || sharedPreferencesM1382b.getString("user_id", null) == null) ? false : true;
        m15734b(strArr2);
        boolean zM16060y0 = !"atlas".equals(strArr2[0]) ? CloudSyncUtil.m16060y0(strArr2[0]) : false;
        if (!z10 || zM16060y0) {
            matrixCursor.addRow(new Object[]{"false", 107});
            C11839m.m70688i("SyncProvider", "Module name: " + strArr2[0] + ", switch status = false");
            return matrixCursor;
        }
        if ("atlas".equals(strArr2[0])) {
            zM62388s = m15735c();
        } else if ("addressbook".equals(strArr2[0])) {
            boolean zM79113A = C13153a.m79113A();
            C11839m.m70688i("SyncProvider", "isDeletingContact: " + zM79113A);
            zM62388s = c10028cM62183d0.m62388s(strArr2[0]) && !zM79113A;
        } else {
            zM62388s = c10028cM62183d0.m62388s(strArr2[0]);
        }
        C11839m.m70688i("SyncProvider", "Module name: " + strArr2[0] + ", isSwitchOn = " + zM62388s);
        matrixCursor.addRow(new Object[]{String.valueOf(zM62388s), 107});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
