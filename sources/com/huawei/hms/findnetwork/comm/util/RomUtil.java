package com.huawei.hms.findnetwork.comm.util;

import com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes8.dex */
public class RomUtil {
    private static final int EMUI_10_1 = 23;
    private static final int EMUI_11_0 = 25;
    private static final int EMUI_3_0 = 7;
    private static final int EMUI_3_1 = 8;
    private static final int EMUI_4_0 = 9;
    private static final int EMUI_4_1 = 10;
    private static final int EMUI_5_0 = 11;
    private static final int EMUI_6_0 = 14;
    private static final int EMUI_8_0_1 = 15;
    private static final int EMUI_9_0 = 17;
    private static final int EMUI_TYPE_UNKNOWN = -1;
    private static final String KEY_OS_NAME = "ro.build.version.emui";
    private static final String TAG = "RomUtil";
    private static final int TYPE_EMUI_30 = 30;
    private static final int TYPE_EMUI_31 = 31;
    private static final int TYPE_EMUI_40 = 40;
    private static final int TYPE_EMUI_41 = 41;
    private static final int TYPE_EMUI_50 = 50;
    private static final int TYPE_EMUI_60 = 60;
    private static final int TYPE_EMUI_801 = 81;
    private static final int TYPE_EMUI_90 = 90;
    private static int emuiType = -1;
    private static int emuiVersionCode;

    static {
        initEmuiType();
    }

    private RomUtil() {
    }

    private static void dealTypeUnknown() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, KEY_OS_NAME);
            HmsFindCommonLog.m31925i(TAG, "isNeed2UseHwEmui :");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    emuiType = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    emuiType = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    emuiType = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    emuiType = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    emuiType = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    emuiType = 60;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e10) {
            HmsFindCommonLog.m31926w(TAG, "deal type unknown exception " + e10.getMessage());
        }
    }

    public static int getEMUIVersionCode() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        Object obj;
        try {
            Class<?> cls = Class.forName(EmuiUtil.BUILDEX_VERSION);
            Field declaredField = cls.getDeclaredField(EmuiUtil.EMUI_SDK_INT);
            AccessibleObject.setAccessible(new Field[]{declaredField}, true);
            obj = declaredField.get(cls);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e10) {
            HmsFindCommonLog.m31926w(TAG, "getEMUIVersionCode exception: " + e10.getMessage());
            obj = null;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void initEmuiType() throws java.lang.ClassNotFoundException {
        /*
            int r0 = getEMUIVersionCode()
            com.huawei.hms.findnetwork.comm.util.RomUtil.emuiVersionCode = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getEmuiType emuiVersionCode="
            r0.append(r1)
            int r1 = com.huawei.hms.findnetwork.comm.util.RomUtil.emuiVersionCode
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RomUtil"
            com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog.m31925i(r1, r0)
            int r0 = com.huawei.hms.findnetwork.comm.util.RomUtil.emuiVersionCode
            r1 = 17
            if (r0 < r1) goto L29
            r0 = 90
        L26:
            com.huawei.hms.findnetwork.comm.util.RomUtil.emuiType = r0
            goto L59
        L29:
            r1 = 15
            if (r0 < r1) goto L30
            r0 = 81
            goto L26
        L30:
            r1 = 14
            if (r0 < r1) goto L37
            r0 = 60
            goto L26
        L37:
            r1 = 11
            if (r0 < r1) goto L3e
            r0 = 50
            goto L26
        L3e:
            r1 = 10
            if (r0 < r1) goto L45
            r0 = 41
            goto L26
        L45:
            r1 = 9
            if (r0 < r1) goto L4c
            r0 = 40
            goto L26
        L4c:
            r1 = 8
            if (r0 < r1) goto L53
            r0 = 31
            goto L26
        L53:
            r1 = 7
            if (r0 < r1) goto L59
            r0 = 30
            goto L26
        L59:
            int r0 = com.huawei.hms.findnetwork.comm.util.RomUtil.emuiType
            r1 = -1
            if (r0 != r1) goto L61
            dealTypeUnknown()
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.findnetwork.comm.util.RomUtil.initEmuiType():void");
    }

    public static boolean isEMUI() {
        return -1 != emuiType;
    }

    public static boolean isSmallerThanEMUI11() {
        return getEMUIVersionCode() < 25;
    }
}
