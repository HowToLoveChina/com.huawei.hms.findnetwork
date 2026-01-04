package com.huawei.fastengine.fastview.download.emui.widget;

import android.os.SystemProperties;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class EMUISupportUtil {
    public static final int EMUI_1_0 = 1;
    public static final int EMUI_1_5 = 2;
    public static final int EMUI_1_6 = 3;
    public static final int EMUI_2_0_JB = 4;
    public static final int EMUI_2_0_KK = 5;
    public static final int EMUI_2_3 = 6;
    public static final int EMUI_3_0 = 7;
    public static final int EMUI_3_0_5 = 8;
    public static final int EMUI_3_1 = 8;
    public static final int EMUI_4_0 = 9;
    public static final int EMUI_4_1 = 10;
    public static final int EMUI_5_0 = 11;
    public static final int EMUI_5_1 = 12;
    private static final Map<Integer, String> EMUI_VERSION_MAP;
    private static final String TAG = "EMUISupportUtil";
    private static final String UNDERLINE_SYMBOL = "_";
    public static final int UNKNOWN_EMUI = 0;
    private static EMUISupportUtil instance;
    private int emuiVersion;
    private String emuiVersionName;

    static {
        HashMap map = new HashMap();
        EMUI_VERSION_MAP = map;
        map.put(1, "1.0");
        map.put(2, "1.5");
        map.put(3, "1.6");
        map.put(4, "2.0");
        map.put(5, "2.0");
        map.put(6, "2.3");
        map.put(7, "3.0");
        map.put(8, "3.0.5");
        map.put(8, "3.1");
        map.put(9, "4.0");
        map.put(10, "4.1");
        map.put(11, "5.0");
        map.put(12, "5.1");
    }

    private EMUISupportUtil() {
        this.emuiVersion = 0;
        this.emuiVersionName = "";
        int emuiVersionCode = getEmuiVersionCode();
        this.emuiVersion = emuiVersionCode;
        if (emuiVersionCode == 0) {
            this.emuiVersion = getEmuiVerFromBuild();
        }
        this.emuiVersionName = initEmuiVersionName();
    }

    private int getEmuiVerFromBuild() {
        String emuiVersionName = getEmuiVersionName(SystemProperties.get("ro.build.version.emui", ""));
        if (TextUtils.isEmpty(emuiVersionName)) {
            return 0;
        }
        for (Map.Entry<Integer, String> entry : EMUI_VERSION_MAP.entrySet()) {
            if (emuiVersionName.startsWith(entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    private int getEmuiVersionCode() {
        return SystemProperties.getInt("ro.build.hw_emui_api_level", 0);
    }

    public static synchronized EMUISupportUtil getInstance() {
        try {
            if (instance == null) {
                instance = new EMUISupportUtil();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return instance;
    }

    private String initEmuiVersionName() {
        String str = EMUI_VERSION_MAP.get(Integer.valueOf(this.emuiVersion));
        return str == null ? "" : str;
    }

    public int getEmuiVersion() {
        return this.emuiVersion;
    }

    public String getEmuiVersionName() {
        return this.emuiVersionName;
    }

    public boolean isEMUI3() {
        int i10 = this.emuiVersion;
        return i10 > 6 && i10 < 9;
    }

    public boolean isEMUI4() {
        int i10 = this.emuiVersion;
        return i10 > 8 && i10 < 11;
    }

    public boolean isEMUI4Style() {
        return this.emuiVersion >= 9;
    }

    public boolean isEMUI5() {
        return this.emuiVersion >= 11;
    }

    private String getEmuiVersionName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }
}
