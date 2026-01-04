package com.huawei.android.hicloud.cloudbackup.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.PowerConnectJobService;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.cloud.base.util.C4633d0;
import hu.C10343b;
import java.io.Serializable;
import java.util.Optional;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p639sp.C12821b;
import p657tp.C13054e;
import p664u0.C13108a;
import p686up.InterfaceC13233a;
import p711vl.C13463c;
import p711vl.C13464d;

/* loaded from: classes2.dex */
public class CloudBackupDsProvider extends ContentProvider {
    public static final String AUTHORITY = "com.huawei.android.ds.cloudbackup.provider";
    private static final int AUTO_BACKUP_BATTERY_CHARGE = 11;
    private static final int BACKUPKEY_CODE = 1;
    private static final int BACKUPRESETSTATUS_CODE = 3;
    private static final int BACKUPTIMES_CODE = 2;
    private static final int BACKUPUSERINFO_CODE = 4;
    private static final int BACKUP_DISPERSE_RULE = 10;
    private static final int BACKUP_END_CODE = 12;
    private static final int BACKUP_FAILED_ERROR_CODE = 9;
    private static final int BACKUP_THERMAL_CONTROL_CODE = 13;
    private static final int BACKUP_THERMAL_CONTROL_GROUP_CODE = 16;
    private static final int BACKUP_UPDATE_STRING_KEY_VALUE_CODE = 15;
    private static final int BACKUP_USER_FREQUENCY = 6;
    private static final int CLEAR = 5;
    private static final String IS_CONTAINS_KEY = "isConstainsKey";
    private static final UriMatcher MATCHER;
    private static final int QUERY_CONTAINS_KEY = 7;
    private static final int QUERY_LONG_VALUE_BY_KEY = 14;
    private static final int QUERY_STRING_VALUE_BY_KEY = 17;
    private static final int RESET_AUTO_BACKUP_CHECK = 8;
    private static final String TAG = "CloudBackupDsProvider";
    private static final String UNKNOWN_URI = "Unknown URI ";
    private static final int UPDATE_BOOLEAN_VALUE_BY_KEY_CODE = 18;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        MATCHER = uriMatcher;
        uriMatcher.addURI(AUTHORITY, "backupKey", 1);
        uriMatcher.addURI(AUTHORITY, "backupTimes", 2);
        uriMatcher.addURI(AUTHORITY, "backupResetStatus", 3);
        uriMatcher.addURI(AUTHORITY, "backupUserInfo", 4);
        uriMatcher.addURI(AUTHORITY, "clear", 5);
        uriMatcher.addURI(AUTHORITY, "backupUserFrequency", 6);
        uriMatcher.addURI(AUTHORITY, "queryBackupKey", 7);
        uriMatcher.addURI(AUTHORITY, "queryLongValueBykey", 14);
        uriMatcher.addURI(AUTHORITY, "queryStringValueBykey", 17);
        uriMatcher.addURI(AUTHORITY, "resetAutoBackupCheck", 8);
        uriMatcher.addURI(AUTHORITY, "backupFailedErrorCode", 9);
        uriMatcher.addURI(AUTHORITY, "backupDisperseRule", 10);
        uriMatcher.addURI(AUTHORITY, "autoBackupBatteryCharge", 11);
        uriMatcher.addURI(AUTHORITY, "backupEndCodePath", 12);
        uriMatcher.addURI(AUTHORITY, "thermalControl", 13);
        uriMatcher.addURI(AUTHORITY, "backup_update_string_key_value", 15);
        uriMatcher.addURI(AUTHORITY, "backup_update_boolean_key_value", 18);
        uriMatcher.addURI(AUTHORITY, "thermalControlGroup", 16);
    }

    private void backupBatteryCharge(ContentValues contentValues, C13464d c13464d) {
        int iIntValue = contentValues.getAsInteger("batteryChargeConnected").intValue();
        C11839m.m70688i(TAG, "update backupBatteryCharge");
        c13464d.m81046q("batteryChargeConnected", iIntValue);
    }

    private Bundle dataMethodCall(String str, String str2, Bundle bundle) throws C12821b {
        C10343b c10343b = new C10343b(bundle);
        Bundle bundle2 = new Bundle();
        final Class<?> configurableClassZ = getConfigurableClassZ(c10343b);
        if ("configurable_get".equals(str)) {
            if (configurableClassZ != null) {
                bundle2.putString("data", C13054e.m78777c(configurableClassZ));
            }
        } else if ("configurable_save".equals(str)) {
            if (configurableClassZ != null) {
                Optional.ofNullable(c10343b.m63694p(SyncProtocol.Constant.UPDATE)).ifPresent(new Consumer() { // from class: k8.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) throws C12821b {
                        C13054e.m78778d(configurableClassZ, (String) obj);
                    }
                });
            }
        } else if ("configurable_clear".equals(str)) {
            if (configurableClassZ != null) {
                C13054e.m78776b(configurableClassZ);
            }
        } else if ("configurable_clear_all".equals(str)) {
            C13054e.m78775a();
        }
        return bundle2;
    }

    private Class<?> getConfigurableClassZ(C10343b c10343b) {
        Serializable serializableM63693o = c10343b.m63693o("type");
        if (!(serializableM63693o instanceof Class)) {
            return null;
        }
        Class<?> cls = (Class) serializableM63693o;
        if (InterfaceC13233a.class.isAssignableFrom(cls)) {
            return cls;
        }
        return null;
    }

    private boolean isValid(ContentValues contentValues) {
        return (contentValues == null || contentValues.keySet() == null) ? false : true;
    }

    private int processOtherUri(Uri uri, ContentValues contentValues, int i10) {
        C13464d c13464dM81030f = C13464d.m81030f(getContext());
        switch (i10) {
            case 8:
                boolean zBooleanValue = contentValues.getAsBoolean("isAgreeTerms").booleanValue();
                if (contentValues.getAsBoolean("isDsStartSticky").booleanValue()) {
                    C11839m.m70688i(TAG, "ds is start sticky, reset timer");
                    C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.CB_OBSERVER_TIMER_REGISTER"));
                    return 1;
                }
                C11839m.m70688i(TAG, "ds is not start sticky, reset jobscheduler");
                CloudBackupJobManager.getInstance().unRegisterPowerConnectScheduler();
                CloudBackupJobManager.getInstance().registerPowerConnectScheduler(zBooleanValue, 0L);
                return 1;
            case 9:
                String asString = contentValues.getAsString("backupFailedErrorCode");
                if (TextUtils.isEmpty(asString)) {
                    return 1;
                }
                C11839m.m70688i(TAG, "update error code: " + asString);
                c13464dM81030f.m81049t("backupFailedErrorCode", asString);
                return 1;
            case 10:
                String asString2 = contentValues.getAsString("disperseRule");
                if (asString2 == null) {
                    return 1;
                }
                C11839m.m70688i(TAG, "update disperseRule");
                c13464dM81030f.m81049t("disperseRule", asString2);
                return 1;
            case 11:
            case 14:
            case 17:
            default:
                throw new IllegalArgumentException("Unknown URI  " + uri);
            case 12:
                updateBackupEndCode(contentValues, c13464dM81030f);
                return -1;
            case 13:
                String asString3 = contentValues.getAsString("thermalControl");
                if (asString3 == null) {
                    return 1;
                }
                C11839m.m70688i(TAG, "update thermalControl");
                c13464dM81030f.m81049t("thermalControl", asString3);
                return 1;
            case 15:
                String asString4 = contentValues.getAsString("backup_ds_string_key");
                String asString5 = contentValues.getAsString("backup_ds_string_value");
                if (TextUtils.isEmpty(asString4) || asString5 == null) {
                    C11839m.m70688i(TAG, "key or value is empty" + asString4 + "," + asString5);
                    return 1;
                }
                C11839m.m70688i(TAG, "update str key: " + asString4 + " ,value: " + asString5);
                c13464dM81030f.m81049t(asString4, asString5);
                return 1;
            case 16:
                String asString6 = contentValues.getAsString("thermalControlGroup");
                if (asString6 == null) {
                    return 1;
                }
                C11839m.m70688i(TAG, "update thermalControlGroup");
                c13464dM81030f.m81049t("thermalControlGroup", asString6);
                return 1;
            case 18:
                String asString7 = contentValues.getAsString("backup_ds_boolean_key");
                Boolean asBoolean = contentValues.getAsBoolean("backup_ds_boolean_value");
                if (TextUtils.isEmpty(asString7) || asBoolean == null) {
                    C11839m.m70688i(TAG, "update boolean key or value is empty" + asString7 + "," + asBoolean);
                    return 1;
                }
                C11839m.m70688i(TAG, "update boolean key: " + asString7 + " ,value: " + asBoolean);
                c13464dM81030f.m81045p(asString7, asBoolean.booleanValue());
                return 1;
        }
    }

    private void updateBackupEndCode(ContentValues contentValues, C13464d c13464d) {
        String asString = contentValues.getAsString("backup_end_code");
        C11839m.m70688i(TAG, "updateBackupEndCode: " + asString);
        c13464d.m81049t("backup_end_code", asString);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        if (!TextUtils.equals(getCallingPackage(), "com.huawei.hidisk")) {
            C11839m.m70687e(TAG, "call not match package name");
            return null;
        }
        if (!C4633d0.m28404a(str) && str.startsWith("configurable")) {
            return dataMethodCall(str, str2, bundle);
        }
        if (TextUtils.equals(str, "method_do_powerconnect_job")) {
            PowerConnectJobService.doPowerConnectJob(bundle.getBoolean("isAgreeTerms"), getContext().getApplicationContext());
        } else if (TextUtils.equals(str, "method_notify_restore_timer")) {
            Intent intent = new Intent("com.huawei.hicloud.intent.action.CB_OBSERVER_RESTORE_TIMER_REGISTER_OR_UNREGISTER");
            intent.putExtras(bundle);
            C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
        }
        return super.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (MATCHER.match(uri) == 5) {
            C13464d.m81030f(getContext()).m81031a();
            C13463c.m81022c(getContext()).m81023a();
            return 1;
        }
        throw new IllegalArgumentException("Unknown URI  " + uri);
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
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{IS_CONTAINS_KEY});
        int iMatch = MATCHER.match(uri);
        if (iMatch == 6) {
            matrixCursor.addRow(new Integer[]{Integer.valueOf(C13464d.m81030f(getContext()).m81035e())});
        } else if (iMatch == 7) {
            matrixCursor.addRow(new Integer[]{Integer.valueOf(C13464d.m81030f(getContext()).m81032b(str) ? 0 : -1)});
        } else if (iMatch == 14) {
            matrixCursor.addRow(new Long[]{Long.valueOf(C13464d.m81030f(getContext()).m81037h(str))});
        } else {
            if (iMatch != 17) {
                matrixCursor.close();
                throw new IllegalArgumentException("Unknown URI  " + uri);
            }
            matrixCursor.addRow(new String[]{C13464d.m81030f(getContext()).m81039j(str, "")});
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C0209d.m1247e(getContext());
        int iMatch = MATCHER.match(uri);
        C11839m.m70688i(TAG, "match: " + iMatch);
        if (!isValid(contentValues)) {
            return -1;
        }
        C13464d c13464dM81030f = C13464d.m81030f(getContext());
        if (iMatch == 1) {
            boolean zBooleanValue = contentValues.getAsBoolean("backup_key").booleanValue();
            c13464dM81030f.m81045p("backup_key", zBooleanValue);
            C11839m.m70688i(TAG, "update switch: " + zBooleanValue);
        } else if (iMatch == 2) {
            for (String str2 : contentValues.keySet()) {
                c13464dM81030f.m81048s(str2, contentValues.getAsLong(str2).longValue());
                C11839m.m70688i(TAG, "update timesKey: " + str2);
            }
        } else if (iMatch == 3) {
            int iIntValue = contentValues.getAsInteger("push_reset_status").intValue();
            c13464dM81030f.m81046q("push_reset_status", iIntValue);
            C11839m.m70688i(TAG, "update resetStatus: " + iIntValue);
        } else if (iMatch == 4) {
            for (String str3 : contentValues.keySet()) {
                c13464dM81030f.m81050u(str3, contentValues.getAsString(str3));
                C11839m.m70688i(TAG, "update user info success");
            }
        } else {
            if (iMatch != 6) {
                if (iMatch != 11) {
                    return processOtherUri(uri, contentValues, iMatch);
                }
                backupBatteryCharge(contentValues, c13464dM81030f);
                return -1;
            }
            if (contentValues.containsKey("backup_frequency")) {
                int iIntValue2 = contentValues.getAsInteger("backup_frequency").intValue();
                C11839m.m70688i(TAG, "update frequency: " + iIntValue2);
                c13464dM81030f.m81046q("backup_frequency", iIntValue2);
            } else if (contentValues.containsKey("gradeCode")) {
                String asString = contentValues.getAsString("gradeCode");
                c13464dM81030f.m81049t("gradeCode", asString);
                C11839m.m70688i(TAG, "update gradeCode: " + asString);
            }
        }
        return 1;
    }
}
