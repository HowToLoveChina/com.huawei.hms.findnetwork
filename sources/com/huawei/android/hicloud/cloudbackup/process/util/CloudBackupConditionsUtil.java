package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.DisperseRule;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.FeatureGrayList;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11326d;
import p514o9.C11839m;
import p572qb.C12299b;
import p617rl.C12526j;
import p657tp.C13055f;
import p711vl.C13464d;
import p711vl.C13466f;
import p711vl.C13467g;

/* loaded from: classes2.dex */
public class CloudBackupConditionsUtil {
    private static final long DAY_MILLIS = 86400000;
    private static final long MINITE_MILLIS = 60000;
    private static final String TAG = "CloudBackupConditionsUtil";

    public static class ChargeAttr {
        private boolean isCharging = false;
        private int chargePlug = 0;
        private int chargeLevel = 0;

        public int getChargeLevel() {
            return this.chargeLevel;
        }

        public int getChargePlug() {
            return this.chargePlug;
        }

        public boolean isCharging() {
            return this.isCharging;
        }

        public void setChargeLevel(int i10) {
            this.chargeLevel = i10;
        }

        public void setChargePlug(int i10) {
            this.chargePlug = i10;
        }

        public void setCharging(boolean z10) {
            this.isCharging = z10;
        }

        public String toString() {
            return "ChargeAttr{isCharging=" + this.isCharging + ", chargePlug=" + this.chargePlug + ", chargeLevel=" + this.chargeLevel + '}';
        }
    }

    public static long checkDelayTime(long j10) {
        long jCurrentTimeMillis = j10 - System.currentTimeMillis();
        long j11 = jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L;
        C11839m.m70688i(TAG, "target backup time = " + j10 + ", advancedDelayTime: " + jCurrentTimeMillis);
        return j11;
    }

    public static int delayedAutoBackup(List<DisperseRule> list, boolean z10) throws NoSuchAlgorithmException {
        Calendar calendar;
        Calendar calendar2;
        Calendar calendar3;
        if (list == null) {
            C11839m.m70688i(TAG, "delay time is yet been add ");
            return 0;
        }
        if (z10) {
            C11839m.m70688i(TAG, "backup now for pre disperse");
            return 0;
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            C11839m.m70688i(TAG, "len of disperseRules:" + list.size());
            Iterator<DisperseRule> it = list.iterator();
            while (it.hasNext()) {
                DisperseRule next = it.next();
                int delaySegment = next.getDelaySegment() * 60;
                try {
                    calendar = Calendar.getInstance();
                    calendar2 = Calendar.getInstance();
                    calendar3 = Calendar.getInstance();
                    String left = next.getLeft();
                    String right = next.getRight();
                    calendar.setTime(simpleDateFormat.parse(left));
                    calendar2.setTime(simpleDateFormat.parse(right));
                    C11839m.m70688i(TAG, "time interval normal");
                    calendar3.setTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
                } catch (ParseException e10) {
                    C11839m.m70687e(TAG, "parse date error: " + e10.toString());
                }
                if (!calendar3.equals(calendar) && !calendar3.equals(calendar2) && (!calendar3.after(calendar) || !calendar3.before(calendar2))) {
                }
                C11839m.m70688i(TAG, "time interval normal: time to be delayed");
                return instanceStrong.nextInt(delaySegment + 1);
            }
        } catch (Exception e11) {
            C11839m.m70687e(TAG, "no algorithm error: " + e11.toString());
        }
        return 0;
    }

    public static String getBackUpCheckType() {
        Context context = getContext();
        boolean zM1309t1 = C0209d.m1309t1(context);
        String strM81079g = zM1309t1 ? C13466f.m81073d().m81079g("checkType", "0") : C13464d.m81030f(context).m81039j("checkType", "0");
        C11839m.m70688i(TAG, "getUserBackUpFrequency mainProcess: " + zM1309t1 + " , checkType: " + strM81079g);
        return strM81079g;
    }

    public static ChargeAttr getChargeAttr() {
        ChargeAttr chargeAttr = new ChargeAttr();
        Intent intentRegisterReceiver = getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intentRegisterReceiver);
            int intExtra = hiCloudSafeIntent.getIntExtra("status", -1);
            boolean z10 = intExtra == 2 || intExtra == 5;
            chargeAttr.setCharging(z10);
            chargeAttr.setChargeLevel(hiCloudSafeIntent.getIntExtra(FaqConstants.FAQ_LEVEL, 0));
            int intExtra2 = hiCloudSafeIntent.getIntExtra("plugged", -1);
            chargeAttr.setChargePlug(intExtra2);
            C11839m.m70688i(TAG, "battery status charging: " + z10 + ", status: " + intExtra + ", chargePlug: " + intExtra2);
        } else {
            C11839m.m70689w(TAG, "getChargeAttr intent is null");
        }
        return chargeAttr;
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    public static ICycleChecker getCycleChecker() {
        return ICycleChecker.get(null);
    }

    public static long getLastFailedTime(boolean z10) {
        long jQuerylastfailedtime = z10 ? new SettingOperator().querylastfailedtime() : C13464d.m81030f(getContext()).m81037h("lastfailedtime");
        if (jQuerylastfailedtime <= System.currentTimeMillis()) {
            return jQuerylastfailedtime;
        }
        C11839m.m70689w(TAG, "getLastFailedTime lastFailedTime invalid :" + jQuerylastfailedtime);
        return 0L;
    }

    private static int getOMBatteryCharge() {
        Context context = getContext();
        boolean zM1309t1 = C0209d.m1309t1(context);
        int iM75425w = zM1309t1 ? new C12526j().m75425w() : C13464d.m81030f(context).m81036g("batteryChargeConnected", -1);
        C11839m.m70688i(TAG, "getOMBatteryCharge mainProcess: " + zM1309t1 + " ,batteryCharge: " + iM75425w);
        return iM75425w;
    }

    public static long getTargetBackupTime(boolean z10, ICycleChecker iCycleChecker, boolean z11, boolean z12) {
        boolean zM1309t1 = C0209d.m1309t1(getContext());
        C13464d c13464dM81030f = C13464d.m81030f(getContext());
        long jQuerynextbackuptime = zM1309t1 ? new SettingOperator().querynextbackuptime() : c13464dM81030f.m81037h("nextbackuptime");
        long lastFailedTime = getLastFailedTime(zM1309t1);
        long targetBackupTime = !z10 ? iCycleChecker.getTargetBackupTime() : (z12 || jQuerynextbackuptime <= 0) ? !z11 ? lastFailedTime + (c13464dM81030f.m81037h("retryInterval") * 60000) : 0L : lastFailedTime + jQuerynextbackuptime;
        C11839m.m70688i(TAG, "isMainProcess is " + zM1309t1 + ", getTargetBackupTime, isCycleSatisfy: " + z10 + ", isRetryIntervalSatisfy: " + z11 + ", isNextBackupTimeSatisfy: " + z12 + ", nextBackupTime: " + jQuerynextbackuptime + ", targetBackupTime: " + targetBackupTime);
        return targetBackupTime;
    }

    public static int getUserBackUpFrequency() {
        Context context = getContext();
        boolean zM1309t1 = C0209d.m1309t1(context);
        int iM81091f = zM1309t1 ? C13467g.m81086c().m81091f() : C13464d.m81030f(context).m81036g("backup_frequency", 0);
        C11839m.m70688i(TAG, "getUserBackUpFrequency mainProcess: " + zM1309t1 + " , frequency: " + iM81091f);
        return iM81091f;
    }

    public static boolean isConfigureBatteryChanger() {
        boolean z10 = getOMBatteryCharge() >= 10;
        C11839m.m70688i(TAG, "isConfigureBatteryChanger result: " + z10);
        return z10;
    }

    public static boolean isInterimBackupThermalControlDisable(boolean z10) {
        if (!z10) {
            return false;
        }
        int iM68042d = ((FeatureGrayList) C13055f.m78779g().m78764c(FeatureGrayList.class)) == null ? 0 : C11326d.m68042d("interimBackupDisableThermalControl");
        C11839m.m70688i(TAG, "interimBackupDisableThermalControl:" + iM68042d);
        return iM68042d != 0;
    }

    public static boolean isNextBackupTimeSatisfy() {
        long jM81037h;
        long jM81037h2;
        boolean zM1309t1 = C0209d.m1309t1(getContext());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zM1309t1) {
            SettingOperator settingOperator = new SettingOperator();
            jM81037h = settingOperator.querylastsuccesstime();
            jM81037h2 = settingOperator.querynextbackuptime();
        } else {
            C13464d c13464dM81030f = C13464d.m81030f(getContext());
            jM81037h = c13464dM81030f.m81037h("lastsuccesstime");
            jM81037h2 = c13464dM81030f.m81037h("nextbackuptime");
        }
        long lastFailedTime = getLastFailedTime(zM1309t1);
        C11839m.m70688i(TAG, "isMainProcess is " + zM1309t1 + ", nextBackupTime = " + jM81037h2 + ", lastFailedTime = " + lastFailedTime + ", lastSuccessTime: " + jM81037h);
        return jM81037h2 > 0 && jCurrentTimeMillis - lastFailedTime > jM81037h2;
    }

    public static boolean isResetStatus() {
        if (C13464d.m81030f(getContext()).m81036g("push_reset_status", 0) == 0) {
            return false;
        }
        C11839m.m70688i(TAG, "doBackup clear not finish.");
        return true;
    }

    public static boolean isRetryIntervalSatisfy() {
        long jM81037h;
        long jM81037h2;
        boolean zM1309t1 = C0209d.m1309t1(getContext());
        C13464d c13464dM81030f = C13464d.m81030f(getContext());
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM81037h3 = c13464dM81030f.m81037h("retryInterval");
        String strM81039j = c13464dM81030f.m81039j("backupFailedErrorCode", "");
        if (zM1309t1) {
            SettingOperator settingOperator = new SettingOperator();
            jM81037h = settingOperator.querylastsuccesstime();
            jM81037h2 = settingOperator.querynextbackuptime();
        } else {
            jM81037h = c13464dM81030f.m81037h("lastsuccesstime");
            jM81037h2 = c13464dM81030f.m81037h("nextbackuptime");
        }
        long lastFailedTime = getLastFailedTime(zM1309t1);
        C11839m.m70688i(TAG, "isMainProcess is " + zM1309t1 + ", nextBackupTime = " + jM81037h2 + ", lastFailedTime = " + lastFailedTime + ", lastSuccessTime: " + jM81037h + ", retryInterval: " + jM81037h3);
        if (lastFailedTime <= jM81037h || !ICBUtil.getAutoBackupErrCode().contains(strM81039j)) {
            return jM81037h2 == 0 && jCurrentTimeMillis - lastFailedTime > jM81037h3 * 60000;
        }
        C11839m.m70688i(TAG, "errorCode: " + strM81039j);
        return true;
    }

    public static boolean isScreenOn() {
        PowerManager powerManager = (PowerManager) getContext().getSystemService("power");
        if (powerManager != null) {
            return powerManager.isInteractive();
        }
        return true;
    }

    public static boolean isSmartCharging(ChargeAttr chargeAttr) {
        int chargePlug = chargeAttr.getChargePlug();
        int chargeLevel = chargeAttr.getChargeLevel();
        boolean zIsCharging = chargeAttr.isCharging();
        C11839m.m70688i(TAG, "isSmartCharging " + chargeAttr);
        if (zIsCharging) {
            C11839m.m70688i(TAG, "isSmartCharging charging");
            return true;
        }
        int oMBatteryCharge = getOMBatteryCharge();
        return (chargePlug == 1 || chargePlug == 2 || chargePlug == 4) && oMBatteryCharge >= 10 && chargeLevel > oMBatteryCharge;
    }

    public static boolean isWiFiActive() {
        return C0209d.m1254f2(getContext());
    }

    public static void recordCycleCondition(String str, Context context) {
        C11839m.m70686d(TAG, "recordCycleCondition: " + str);
        if (TextUtils.isEmpty(str) || str.contains(Boolean.toString(true))) {
            C13464d.m81030f(context).m81049t("cycle_check_type", "");
        } else {
            C13464d.m81030f(context).m81049t("cycle_check_type", str);
        }
    }

    public static void saveCheckTypeToSp(String str) {
        if (str.equals(getBackUpCheckType())) {
            return;
        }
        C13466f.m81073d().m81084l("checkType", str);
        C12299b.m73932n("checkType", str);
    }

    public static boolean isSmartCharging() {
        return isConfigureBatteryChanger() && isSmartCharging(getChargeAttr());
    }
}
