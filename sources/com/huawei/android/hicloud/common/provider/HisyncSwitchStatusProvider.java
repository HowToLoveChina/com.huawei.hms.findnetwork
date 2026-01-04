package com.huawei.android.hicloud.common.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.task.simple.C3017c;
import com.huawei.android.p073ds.R$string;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p020ap.C1006a;
import p336he.C10155f;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import to.C13049a;

/* loaded from: classes3.dex */
public class HisyncSwitchStatusProvider extends ContentProvider {

    /* renamed from: a */
    public static UriMatcher f11974a = new UriMatcher(-1);

    /* renamed from: com.huawei.android.hicloud.common.provider.HisyncSwitchStatusProvider$a */
    public static class C2756a extends AbstractC12368e {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("HisyncSwitchStatusProvider", "closeSwitchTask");
            try {
                CloudSpace cloudSpaceM78754r = new C13049a(EnumC12999a.CLOUD_BACKUP, null).m78754r();
                long jQueryinitopentime = new SettingOperator().queryinitopentime();
                C11839m.m70688i("HisyncSwitchStatusProvider", "closeSwitchTask reportCloseCloudBackup");
                C13225d.m79490f1().m79601y0(jQueryinitopentime, cloudSpaceM78754r);
            } catch (C9721b e10) {
                C11839m.m70688i("HisyncSwitchStatusProvider", "reportCloseBackup error: " + e10.toString());
            }
        }
    }

    /* renamed from: a */
    public final MatrixCursor m15705a(int i10, String[] strArr, String[] strArr2) {
        switch (i10) {
            case 7:
                return m15709e(strArr, strArr2);
            case 8:
                return m15711g(strArr, strArr2);
            case 9:
                return m15708d(strArr, strArr2);
            case 10:
                return m15712h(strArr, strArr2);
            case 11:
                return m15713i(strArr, strArr2);
            case 12:
                return m15715k(strArr, strArr2);
            default:
                throw new IllegalArgumentException("Unkown URI ");
        }
    }

    /* renamed from: b */
    public final int m15706b() {
        C11839m.m70688i("HisyncSwitchStatusProvider", "query more info");
        C10028c c10028cM62183d0 = C10028c.m62183d0(getContext());
        if (c10028cM62183d0 == null || !c10028cM62183d0.m62395t1("is_already_configed_NV4")) {
            return 0;
        }
        if (c10028cM62183d0.m62395t1("funcfg_huawei_drive")) {
            return c10028cM62183d0.m62216G1(getContext()) ? 1 : 0;
        }
        return -1;
    }

    /* renamed from: c */
    public final int m15707c(C10028c c10028c) {
        if (c10028c == null || !C2783d.m16097N()) {
            return 0;
        }
        if (c10028c.m62395t1("funcfg_cloud_backup")) {
            return c10028c.m62388s("backup_key") ? 1 : 0;
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        C0209d.m1247e(getContext());
        C10028c c10028cM62183d0 = C10028c.m62183d0(getContext());
        C11839m.m70686d("HisyncSwitchStatusProvider", "call method = " + str + " arg = " + str2);
        if (!"method_turn_on_backup_switch".equalsIgnoreCase(str)) {
            return super.call(str, str2, bundle);
        }
        Bundle bundle2 = new Bundle();
        int iM15707c = m15707c(c10028cM62183d0);
        if ("turn_on_backup_switch".equalsIgnoreCase(str2) && iM15707c == 0) {
            CloudBackupService.getInstance().cloudbackupOpr(true);
            bundle2.putString("METHOD_TURN_ON_BACKUP_SWITCH", "turn_on_backup_switch");
            C13225d.m79490f1().m79558J0("9");
        } else if ("turn_off_backup_switch".equalsIgnoreCase(str2) && iM15707c == 1) {
            CloudBackupService.getInstance().abort(PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED);
            CloudBackupService.getInstance().getState();
            if (c10028cM62183d0.m62388s("backup_key")) {
                C12515a.m75110o().m75172d(new C2756a());
            }
            CloudBackupService.getInstance().cloudbackupOpr(false);
            bundle2.putString("METHOD_TURN_ON_BACKUP_SWITCH", "turn_off_backup_switch");
        }
        m15714j(getContext());
        return bundle2;
    }

    /* renamed from: d */
    public final MatrixCursor m15708d(String[] strArr, String[] strArr2) {
        return m15710f("deviceNameSp", strArr, strArr2, false);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: e */
    public final MatrixCursor m15709e(String[] strArr, String[] strArr2) {
        return m15710f(SharedPreferencesStorage.BACKUPOPTION_SPFILE, strArr, strArr2, false);
    }

    /* renamed from: f */
    public final MatrixCursor m15710f(String str, String[] strArr, String[] strArr2, boolean z10) {
        boolean zM5975v;
        MatrixCursor matrixCursor = new MatrixCursor(strArr2);
        if (strArr == null || strArr.length != 1) {
            throw new IllegalArgumentException("selection args is error.");
        }
        if (C13452e.m80781L().m80842P0()) {
            if ("atlas".equals(strArr[0])) {
                zM5975v = C1006a.m5936k().m5975v(getContext());
            } else {
                SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), str, 0);
                zM5975v = sharedPreferencesM1382b != null ? sharedPreferencesM1382b.getBoolean(strArr[0], z10) : false;
            }
            C11839m.m70686d("HisyncSwitchStatusProvider", "module = " + strArr[0] + ",switch status = " + zM5975v);
            matrixCursor.addRow(new Object[]{String.valueOf(zM5975v)});
        } else {
            matrixCursor.addRow(new Object[]{"false"});
        }
        return matrixCursor;
    }

    /* renamed from: g */
    public final MatrixCursor m15711g(String[] strArr, String[] strArr2) {
        return m15710f("sync_contact_spfile", strArr, strArr2, false);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* renamed from: h */
    public final MatrixCursor m15712h(String[] strArr, String[] strArr2) {
        return m15710f(NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, strArr, strArr2, false);
    }

    /* renamed from: i */
    public final MatrixCursor m15713i(String[] strArr, String[] strArr2) {
        return m15710f(NotifyConstants.InterfaceC4909SP.USERINFO_SPFILE, strArr, strArr2, true);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* renamed from: j */
    public final void m15714j(Context context) {
        if (context == null) {
            C11839m.m70689w("HisyncSwitchStatusProvider", "reportSwitchStatus failed, context is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("backup_key");
        C12515a.m75110o().m75172d(new C3017c((ArrayList<String>) arrayList));
    }

    /* renamed from: k */
    public final MatrixCursor m15715k(String[] strArr, String[] strArr2) {
        C11839m.m70688i("HisyncSwitchStatusProvider", "updateBadgeForDs");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", CloudBackupConstant.Command.PMS_CMD_BACKUP, 1);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "netdisk", 2);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "switchState", 3);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "accountinfo", 4);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "hicloud", 5);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "switchStatedefault", 6);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "globalSettings", 7);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "syncContact", 8);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "deviceName", 9);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "syncSettings", 10);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "syncSettingsDefaultTrue", 11);
        f11974a.addURI("com.huawei.android.hicloud.SwitchStatusProvider", "updateBadgeForDs", 12);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C11839m.m70686d("HisyncSwitchStatusProvider", "login query from " + getCallingPackage());
        int iMatch = f11974a.match(uri);
        Context context = getContext();
        C0209d.m1247e(context);
        String[] strArr3 = {"switch_status"};
        MatrixCursor matrixCursor = new MatrixCursor(strArr3);
        C10028c c10028cM62183d0 = C10028c.m62183d0(context);
        switch (iMatch) {
            case -1:
                matrixCursor.close();
                break;
            case 0:
            default:
                matrixCursor = m15705a(iMatch, strArr2, strArr3);
                break;
            case 1:
                C11839m.m70688i("HisyncSwitchStatusProvider", "query backup");
                matrixCursor.addRow(new Object[]{Integer.valueOf(m15707c(c10028cM62183d0))});
                break;
            case 2:
                matrixCursor.addRow(new Object[]{Integer.valueOf(m15706b())});
                break;
            case 3:
                C11839m.m70687e("HisyncSwitchStatusProvider", "URI_MATCH_SWITCH deprecated, please use other uri");
                break;
            case 4:
                C11839m.m70687e("HisyncSwitchStatusProvider", "URI_MATCH_ACCOUNT deprecated, please use other uri");
                break;
            case 5:
                C11839m.m70686d("HisyncSwitchStatusProvider", "query hicloud main switch status");
                int i10 = R$string.settings_hicloud_disabled;
                int i11 = C10155f.m63291o(context) ? R$string.settings_hicloud_open : i10;
                if (C13612b.m81829B().isLogin() && !C0209d.m1173G1(context)) {
                    i10 = i11;
                }
                matrixCursor.addRow(new Object[]{Integer.valueOf(i10)});
                break;
            case 6:
                C11839m.m70687e("HisyncSwitchStatusProvider", "URI_PATH_SWITCH_DEFAULT deprecated, please use other uri");
                break;
        }
        C13230i.m79500C0(C0213f.m1377a(), "HisyncSwitchStatusProvider", getCallingPackage(), String.valueOf(iMatch));
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (5 != f11974a.match(uri)) {
            return 0;
        }
        C11839m.m70686d("HisyncSwitchStatusProvider", "notifyChange hicloud main switch");
        getContext().getContentResolver().notifyChange(uri, null);
        return 1;
    }
}
