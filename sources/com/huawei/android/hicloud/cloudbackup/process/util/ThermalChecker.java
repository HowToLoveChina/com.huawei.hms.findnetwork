package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.ContentValues;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AbsThermalControl;
import com.huawei.android.hicloud.cloudbackup.bean.ThermalControlGroup;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p572qb.C12299b;
import p617rl.C12526j;
import p709vj.C13452e;
import p711vl.C13464d;
import p746wn.C13622a;

/* loaded from: classes2.dex */
public class ThermalChecker {
    private static final String TAG = "ThermalChecker";

    public static AbsThermalControl getThermalControl(boolean z10) {
        if (z10) {
            ThermalControlGroup thermalControlGroupM81041l = C13464d.m81030f(C0213f.m1377a()).m81041l();
            if (thermalControlGroupM81041l == null) {
                return C13464d.m81030f(C0213f.m1377a()).m81040k();
            }
            thermalControlGroupM81041l.setCurrentThermalPolicy();
            return thermalControlGroupM81041l;
        }
        C12526j c12526j = new C12526j();
        if (!c12526j.m75385d1("thermalControlGroup")) {
            return c12526j.m75363T0();
        }
        ThermalControlGroup thermalControlGroupM75365U0 = c12526j.m75365U0();
        if (thermalControlGroupM75365U0 == null) {
            return new ThermalControlGroup();
        }
        thermalControlGroupM75365U0.setCurrentThermalPolicy();
        return thermalControlGroupM75365U0;
    }

    public static String getThermalInfo(int i10) {
        AbsThermalControl thermalControl = getThermalControl(false);
        if (thermalControl == null) {
            C11839m.m70689w(TAG, "getThermalInfo thermalControl is null.");
            return "getThermalInfo,level:" + i10 + ",thermal control is null";
        }
        return "level:" + i10 + ",scope:[" + thermalControl.getStartLevel() + "," + thermalControl.getStopLevel() + ")";
    }

    public static boolean isBlowOut(boolean z10) {
        long jM73924f;
        long jM73924f2;
        long jCurrentTimeMillis;
        boolean z11;
        AbsThermalControl thermalControl = getThermalControl(z10);
        if (z10) {
            C13464d c13464dM81030f = C13464d.m81030f(C0213f.m1377a());
            jM73924f = c13464dM81030f.m81037h("autobackupstarttime");
            jM73924f2 = c13464dM81030f.m81037h("autobackupblowouttime");
        } else {
            jM73924f = C12299b.m73924f("autobackupstarttime");
            jM73924f2 = C12299b.m73924f("autobackupblowouttime");
        }
        boolean z12 = true;
        if (thermalControl == null) {
            C11839m.m70688i(TAG, "isBlowOut thermalControl is empty");
            return true;
        }
        if (thermalControl.checkIllegalArgument()) {
            C11839m.m70688i(TAG, "isBlowOut IllegalArgument");
            return true;
        }
        long blowoutThreshold = thermalControl.getBlowoutThreshold() * 86400000;
        long blowoutDuration = thermalControl.getBlowoutDuration() * C5863b6.g.f26453g;
        ContentValues contentValues = new ContentValues();
        long j10 = 0;
        if (jM73924f == 0) {
            z11 = false;
        } else {
            if (jM73924f2 == 0) {
                if (System.currentTimeMillis() - jM73924f >= blowoutThreshold) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    j10 = jCurrentTimeMillis;
                }
                j10 = jM73924f2;
                z12 = false;
            } else {
                if (System.currentTimeMillis() - jM73924f2 >= 0) {
                    if (System.currentTimeMillis() - jM73924f2 <= blowoutDuration) {
                        j10 = jM73924f2;
                        z11 = true;
                        z12 = false;
                    } else if (System.currentTimeMillis() - jM73924f2 > blowoutThreshold) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                        j10 = jCurrentTimeMillis;
                    }
                }
                j10 = jM73924f2;
                z12 = false;
            }
            z11 = z12;
        }
        if (z12) {
            if (z10) {
                C13464d.m81030f(C0213f.m1377a()).m81048s("autobackupblowouttime", j10);
            } else {
                contentValues.put("autobackupblowouttime", Long.valueOf(j10));
                C12299b.m73937s(contentValues);
            }
        }
        C11839m.m70688i(TAG, "isBlowOut autoBackupStartTime: " + jM73924f + " ,autoBackupBlowoutTime: " + j10 + ",isDs:" + z10 + " ,isUpdateBlowoutTime: " + z12 + " ,blowoutThreshold: " + blowoutThreshold + ",blowoutDuration: " + blowoutDuration + " ,result: " + z11);
        return z11;
    }

    public static boolean isThermalControlByDs(int i10) {
        if (i10 < 0) {
            C11839m.m70688i(TAG, "isThermalControlByDs currentLevel " + i10);
            return true;
        }
        if (!matchThermalControlDevice(true)) {
            return false;
        }
        if (isBlowOut(true)) {
            return true;
        }
        AbsThermalControl thermalControl = getThermalControl(true);
        if (thermalControl == null) {
            C11839m.m70689w(TAG, "isThermalControlByDs thermalControl is null.");
            return true;
        }
        if (thermalControl.checkIllegalArgument()) {
            C11839m.m70688i(TAG, "isThermalControlByDs IllegalArgument");
            return true;
        }
        int startLevel = thermalControl.getStartLevel();
        C11839m.m70688i(TAG, "isThermalControlByDs startLevel: " + startLevel + " ,currentLevel: " + i10);
        return i10 <= startLevel;
    }

    public static boolean isThermalControlByMain(int i10) {
        return isThermalControlByMain(i10, false);
    }

    public static boolean isUniSchedulerControlByMain(int i10) {
        if (i10 <= 0) {
            C11839m.m70688i(TAG, "isUniSchedulerControlByMain currentLevel " + i10);
            return true;
        }
        AbsThermalControl thermalControl = getThermalControl(false);
        if (thermalControl == null) {
            C11839m.m70688i(TAG, "isThermalControlByMain thermalControl is empty");
            return true;
        }
        int uniStopLevel = thermalControl.getUniStopLevel();
        C11839m.m70688i(TAG, "isUniSchedulerControlByMain uniStopLevel: " + uniStopLevel + " ,currentLevel: " + i10);
        return i10 < uniStopLevel;
    }

    public static boolean matchThermalControlDevice(boolean z10) {
        AbsThermalControl thermalControl = getThermalControl(z10);
        if (thermalControl != null) {
            return thermalControl.isCurrentDeviceMatched();
        }
        C11839m.m70689w(TAG, "matchThermalControlDevice thermalControl is null.");
        return false;
    }

    public static boolean isThermalControlByMain(int i10, boolean z10) {
        if (i10 < 0) {
            C11839m.m70688i(TAG, "isThermalControlByMain currentLevel " + i10);
            return true;
        }
        if (isBlowOut(false)) {
            if (z10) {
                String strM66627b = C11058a.m66627b("02012");
                String strM80971t0 = C13452e.m80781L().m80971t0();
                String strM80987x0 = C13452e.m80781L().m80987x0();
                C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "blowout", strM80971t0);
                c11060cM66626a.m66665u("0");
                if (!TextUtils.isEmpty(strM80971t0) && !TextUtils.isEmpty(strM80987x0)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM80971t0);
                    linkedHashMap.put("userType", strM80987x0);
                    linkedHashMap.put("pn", "com.huawei.hidisk\u0001_cloudbackup");
                    C13622a.m81971q(c11060cM66626a, linkedHashMap, true, true);
                }
            }
            return true;
        }
        AbsThermalControl thermalControl = getThermalControl(false);
        if (thermalControl == null) {
            C11839m.m70688i(TAG, "isThermalControlByMain thermalControl is empty");
            return true;
        }
        if (thermalControl.checkIllegalArgument()) {
            C11839m.m70688i(TAG, "isThermalControlByMain IllegalArgument");
            return true;
        }
        int stopLevel = thermalControl.getStopLevel();
        C11839m.m70688i(TAG, "isThermalControlByMain stopLevel: " + stopLevel + " ,currentLevel: " + i10);
        return i10 < stopLevel;
    }
}
