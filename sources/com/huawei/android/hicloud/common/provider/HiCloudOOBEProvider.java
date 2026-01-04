package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import ge.C9908c;
import gp.C10028c;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p514o9.C11839m;
import p681uj.C13192i;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class HiCloudOOBEProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11949a = new UriMatcher(-1);

    /* renamed from: a */
    public final MatrixCursor m15634a(Uri uri, String str, String[] strArr) {
        int iMatch = f11949a.match(uri);
        C11839m.m70686d("HiCloudOOBEProvider", "match Other result: " + iMatch);
        switch (iMatch) {
            case 6:
                if (!TextUtils.isEmpty(str)) {
                    C13227f.m79492i1().m79584d0(str);
                    UBAAnalyze.m29967a0("PVC", str, "1", "18");
                    break;
                }
                break;
            case 7:
                if (strArr.length >= 2) {
                    C13227f.m79492i1().m79580Z(strArr[0]);
                    UBAAnalyze.m29964Y("PVC", strArr[0], "1", "18", Integer.parseInt(strArr[1]));
                    break;
                } else {
                    AbstractC10896a.m65886e("HiCloudOOBEProvider", "selectionArgs is less than 2");
                    break;
                }
            case 8:
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a != null) {
                    C13223b.m79480h(contextM1377a, 3, "");
                    break;
                } else {
                    AbstractC10896a.m65886e("HiCloudOOBEProvider", "context is null");
                    break;
                }
            case 9:
                if (strArr.length >= 3) {
                    LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                    linkedHashMapM79497A.put(FamilyShareConstants.ENTRY_TYPE, strArr[1]);
                    linkedHashMapM79497A.put("result", strArr[2]);
                    if (C13230i.m79506N()) {
                        C13227f.m79492i1().m79567R(strArr[0], linkedHashMapM79497A);
                    } else {
                        C13230i.m79512W0(false, strArr[0], linkedHashMapM79497A);
                    }
                    UBAAnalyze.m29947H("CKC", strArr[0], linkedHashMapM79497A);
                    break;
                } else {
                    AbstractC10896a.m65886e("HiCloudOOBEProvider", "selectionArgs is less than 3");
                    break;
                }
        }
        return null;
    }

    /* renamed from: b */
    public final MatrixCursor m15635b(Uri uri, String str, String[] strArr) {
        int iMatch = f11949a.match(uri);
        C11839m.m70686d("HiCloudOOBEProvider", "match Other result: " + iMatch);
        switch (iMatch) {
            case 10:
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"oobe_provider_result"});
                matrixCursor.addRow(new Object[]{Boolean.valueOf(CBAccess.inBackup())});
                return matrixCursor;
            case 11:
                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"oobe_provider_result"});
                matrixCursor2.addRow(new Object[]{Boolean.valueOf(CBAccess.inRestore())});
                return matrixCursor2;
            case 12:
                MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{"oobe_provider_result"});
                matrixCursor3.addRow(new Object[]{Boolean.valueOf(CBAccess.inRestoreFirst())});
                return matrixCursor3;
            case 13:
                MatrixCursor matrixCursor4 = new MatrixCursor(new String[]{"oobe_provider_result"});
                matrixCursor4.addRow(new Object[]{Integer.valueOf(C13452e.m80781L().m80916g0())});
                return matrixCursor4;
            case 14:
                C13227f.m79492i1().m79561L0(str);
                return null;
            case 15:
                MatrixCursor matrixCursor5 = new MatrixCursor(new String[]{"oobe_provider_result"});
                matrixCursor5.addRow(new Object[]{Boolean.valueOf(C10028c.m62182c0().m62395t1("is_already_configed_NV4"))});
                return matrixCursor5;
            case 16:
                C13452e.m80781L().m80885a();
                return null;
            case 17:
                if (strArr.length < 2) {
                    AbstractC10896a.m65886e("HiCloudOOBEProvider", "selectionArgs is less than 2");
                    return null;
                }
                C11839m.m70688i("HiCloudOOBEProvider", "Invoke the installation interface.");
                C9908c.m61499D().m61540Z(strArr[0], strArr[1]);
                Intent intent = new Intent("com.huawei.android.hicloud.intent.INSTALL_COMPLETE");
                if (C0213f.m1377a() == null) {
                    return null;
                }
                C0213f.m1377a().sendBroadcast(intent, "com.huawei.hidisk.permission.launcher.START_OOBE_QUERY");
                C11839m.m70688i("HiCloudOOBEProvider", "Installation completed and send broadcast.");
                return null;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
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
        UriMatcher uriMatcher = f11949a;
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "is_hicloud_terms_confirm", 1);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "is_login", 2);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "set_query_module_info", 3);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "is_module_enable", 4);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "page_action_event", 5);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "on_resume", 6);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "on_pause", 7);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "collect_oobe_migrate", 8);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "online_update_on_event", 9);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "in_backup", 10);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "in_restore", 11);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "in_restore_first", 12);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "get_restore_status", 13);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "report_open_cloud", 14);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "is_already_configed", 15);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "clear_accountsetting", 16);
        uriMatcher.addURI("com.huawei.android.hicloud.hicloudoobeprovider", "install_apk", 17);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!C0209d.m1247e(getContext())) {
            return null;
        }
        int iMatch = f11949a.match(uri);
        C11839m.m70686d("HiCloudOOBEProvider", "match result: " + iMatch);
        if (iMatch == 1) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"oobe_provider_result"});
            matrixCursor.addRow(new Object[]{Boolean.valueOf(C10028c.m62182c0().m62221H1())});
            return matrixCursor;
        }
        if (iMatch == 2) {
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"oobe_provider_result"});
            matrixCursor2.addRow(new Object[]{Boolean.valueOf(C13452e.m80781L().m80842P0())});
            return matrixCursor2;
        }
        if (iMatch == 3) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            C13192i.m79258g().m79267m(str.equals(FaqConstants.DISABLE_HA_REPORT));
            return null;
        }
        if (iMatch == 4) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{"oobe_provider_result"});
            matrixCursor3.addRow(new Object[]{Boolean.valueOf(C10028c.m62182c0().m62395t1(str))});
            return matrixCursor3;
        }
        if (iMatch != 5) {
            return m15634a(uri, str, strArr2);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C13227f.m79492i1().m79585f0(str, C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", str, "1", "18");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
