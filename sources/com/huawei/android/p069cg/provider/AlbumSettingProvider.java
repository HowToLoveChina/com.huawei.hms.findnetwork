package com.huawei.android.p069cg.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.provider.AlbumSettingProvider;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0229n;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p336he.C10155f;
import p431ko.C11079e;
import p616rk.C12515a;
import p709vj.C13452e;
import p742wj.C13612b;
import p783xp.C13843a;
import p837z9.C14163d;

/* loaded from: classes2.dex */
public class AlbumSettingProvider extends ContentProvider {

    /* renamed from: a */
    public static final UriMatcher f11047a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f11047a = uriMatcher;
        uriMatcher.addURI("com.huawei.android.cg.albumSettingProvider", "switchStatus", 1);
        uriMatcher.addURI("com.huawei.android.cg.albumSettingProvider", "queryLoginStatus", 2);
    }

    /* renamed from: c */
    public static /* synthetic */ void m14587c(UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null || userDataStateInfo.getBmType() == -1) {
            return;
        }
        if (!TextUtils.isEmpty(userDataStateInfo.getBsGrade())) {
            C1120a.m6677i("AlbumSettingProvider", "bs grade:" + userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
        }
        if (userDataStateInfo.getBmType() == 1) {
            C13452e.m80781L().m80985w2(true);
            C1120a.m6677i("AlbumSettingProvider", "new bm type:true");
        } else if (userDataStateInfo.getBmType() == 0) {
            C1120a.m6677i("AlbumSettingProvider", "new bm type:false");
            C13452e.m80781L().m80985w2(false);
        }
        C1120a.m6677i("AlbumSettingProvider", "bm grade state and period: " + userDataStateInfo.getBmGradeState() + ", " + userDataStateInfo.getDataPeriod());
        C1136q.m6954L(userDataStateInfo.getBmGradeState());
        C1136q.m6953K(userDataStateInfo.getDataPeriod());
        C1136q.m6955M(System.currentTimeMillis());
    }

    /* renamed from: b */
    public boolean m14588b(Context context) {
        if (C13452e.m80781L().m80912f1()) {
            C1120a.m6676e("AlbumSettingProvider", "site not match return");
            return false;
        }
        if (!C10155f.m63290n()) {
            C1120a.m6676e("AlbumSettingProvider", "gallery not support sync");
            return false;
        }
        if (C0209d.m1173G1(context)) {
            C1120a.m6677i("AlbumSettingProvider", "isPrivacyUser return");
            return false;
        }
        if (!C13612b.m81829B().m81853R()) {
            C1120a.m6677i("AlbumSettingProvider", "isLoginWithoutDecrypt return");
            return false;
        }
        if (C13612b.m81829B().m81855T() || !C13612b.m81829B().isLogin()) {
            return false;
        }
        C1120a.m6675d("AlbumSettingProvider", "enter isLogin");
        C13612b.m81829B().m81876o();
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (!c10028cM62182c0.m62221H1()) {
            C1120a.m6678w("AlbumSettingProvider", "isHiCloudTermsConfirm return false");
            return false;
        }
        if (!c10028cM62182c0.m62395t1("is_already_configed_NV4")) {
            C1120a.m6678w("AlbumSettingProvider", "hasSetConfigTag return false");
            return false;
        }
        if (c10028cM62182c0.m62369o0() == 0) {
            C1120a.m6678w("AlbumSettingProvider", "getLastQueryV3ConfigTime return false");
            return false;
        }
        if (C14163d.m84990g().m85009o()) {
            C1120a.m6677i("AlbumSettingProvider", "isShowDataMigrateWarn return");
            return false;
        }
        if (C0229n.m1608g("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")) {
            return true;
        }
        C1120a.m6678w("AlbumSettingProvider", "do not have Permission");
        return false;
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
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Context context = getContext();
        if (context == null) {
            C1120a.m6678w("AlbumSettingProvider", "query: context is null!");
            return null;
        }
        if (!C13843a.m83054F(context).equals(getCallingPackage())) {
            C1120a.m6678w("AlbumSettingProvider", "query: package name is not photos!");
            return null;
        }
        int iMatch = f11047a.match(uri);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"queryLoginStatus"});
        if (iMatch == -1) {
            matrixCursor.close();
        } else {
            if (iMatch != 2) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            boolean zM14588b = m14588b(context);
            C1120a.m6677i("AlbumSettingProvider", "queryLoginStatus: " + zM14588b);
            matrixCursor.addRow(new Object[]{Boolean.valueOf(zM14588b)});
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) throws SQLException {
        if (f11047a.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        Context context = getContext();
        if (context == null) {
            C1120a.m6678w("AlbumSettingProvider", "update switchStatus: context is null!");
            return -1;
        }
        if (!C13843a.m83054F(context).equals(getCallingPackage())) {
            C1120a.m6678w("AlbumSettingProvider", "update switchStatus: package name is not photos!");
            return -1;
        }
        if (!C10028c.m62182c0().m62413x()) {
            C1120a.m6677i("AlbumSettingProvider", "update switchStatus: function item switch not open!");
            return -1;
        }
        if (!C0209d.m1166E1()) {
            C1120a.m6677i("AlbumSettingProvider", "update switchStatus: current user is not owner!");
            return -1;
        }
        if (!m14588b(context)) {
            Intent intent = new Intent("com.huawei.hicloud.action.GALLERY_LOGIN_NEW");
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
            return -1;
        }
        Boolean asBoolean = contentValues.getAsBoolean("switchStatus");
        boolean zBooleanValue = asBoolean.booleanValue();
        C1120a.m6677i("AlbumSettingProvider", "update switchStatus: " + zBooleanValue);
        Bundle bundle = new Bundle();
        if (zBooleanValue) {
            if (C13452e.m80781L().m80791C0() && C1136q.m6977r() == 1) {
                InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
                if (interfaceC9283b != null) {
                    C1120a.m6677i("AlbumSettingProvider", "jump to cloud space upgrade page.");
                    interfaceC9283b.mo58515k(C0213f.m1377a(), "OPEN_CLOUD_PHOTO_FROM_OTHER");
                } else {
                    C1120a.m6676e("AlbumSettingProvider", "jumpToCloudSpaceUpgradePage cloudBackupRouter is null");
                }
            } else if (C1122c.m6708J1()) {
                InterfaceC9283b interfaceC9283b2 = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
                if (interfaceC9283b2 != null) {
                    C1120a.m6677i("AlbumSettingProvider", "jump to data expire download page.");
                    interfaceC9283b2.mo58530u(C0213f.m1377a(), "OPEN_CLOUD_PHOTO_FROM_OTHER");
                } else {
                    C1120a.m6676e("AlbumSettingProvider", "jumpToDataExpiresDownloadPage cloudBackupRouter is null");
                }
            } else {
                bundle.putBoolean("GeneralAblum", zBooleanValue);
                C0209d.m1151A2(context, "hicloud_cloudPhoto", zBooleanValue);
                C1136q.e.m7174l(asBoolean, context);
                CloudAlbumManager.m14456v().m14470O(context, bundle, 32);
                C1122c.m6764b2(32, true);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.bm.type");
            arrayList.add("bs.bm.usergrade.info");
            C12515a.m75110o().m75175e(new C11079e(new C11079e.a() { // from class: u6.b
                @Override // p431ko.C11079e.a
                /* renamed from: a */
                public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                    AlbumSettingProvider.m14587c(userDataStateInfo);
                }
            }, false, arrayList, "PhotoSwitch"), false);
        } else {
            bundle.putBoolean("GeneralAblum", zBooleanValue);
            C0209d.m1151A2(context, "hicloud_cloudPhoto", zBooleanValue);
            C1136q.e.m7174l(asBoolean, context);
            CloudAlbumManager.m14456v().m14470O(context, bundle, 32);
            C1122c.m6764b2(32, false);
        }
        return -1;
    }
}
