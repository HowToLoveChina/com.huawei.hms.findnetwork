package com.huawei.uikit.hwlunar.utils;

import android.util.Log;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.p169ad.constant.PriorInstallWay;
import com.huawei.uikit.hwdatepicker.utils.HwConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HwLunarUtils {

    /* renamed from: a */
    private static final String f43024a = "HwAbsLunarUtils";

    /* renamed from: b */
    private static final String f43025b = "";

    /* renamed from: c */
    private static final String f43026c = "_";

    /* renamed from: d */
    private static final int f43027d = 3;

    /* renamed from: e */
    private static final int f43028e = 10;

    /* renamed from: f */
    private static final int f43029f = -1;

    /* renamed from: g */
    private static final int f43030g = 2;
    public static final String[] WESTERN_MONTH = {HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    public static final String[] WESTERN_DAY = {HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN, "14", "15", "16", "17", "18", "19", "20", PriorInstallWay.PRIOR_ACTION_LANDING_PAGE, "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    public static final String[] TIAN_GAN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    public static final String[] DI_ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    public static final String[] ZIADOC = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    public static final String[] LUNAR_MONTH = {"正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};
    public static final String[] LUNAR_DAY = {HwConstants.LUNAR_DAY_FIRST, "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", HwConstants.LUNAR_DAY_TWEENTY_NINE, HwConstants.LUNAR_DAY_THIRTY};

    public static String changeLunarYearMonth(String str) {
        if (str == null || str.indexOf("_") == -1) {
            return "";
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length < 2) {
            return "";
        }
        return strArrSplit[0] + strArrSplit[1];
    }

    public static void closeBufferedReader(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
                Log.e(f43024a, "br close fail");
            }
        }
    }

    public static void closeInputStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                Log.e(f43024a, "io close fail");
            }
        }
    }

    public static int findIndex(String str, String[] strArr) {
        if (strArr == null || str == null) {
            return 0;
        }
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (strArr[i10].equals(str)) {
                return i10;
            }
        }
        return 0;
    }

    public static String[] getMaxDisplayStrings(int i10, String[] strArr) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(10);
        int i11 = i10 + 1;
        if (i11 < 3) {
            int length = strArr.length - 1;
            for (int i12 = 3 - i11; i12 > 0 && length >= 0; i12--) {
                arrayList.add(strArr[length]);
                length--;
            }
        }
        for (int i13 = 0; i13 <= i10; i13++) {
            arrayList.add(strArr[i13]);
        }
        String[] strArr2 = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i14 = 0; i14 < size; i14++) {
            strArr2[i14] = (String) arrayList.get(i14);
        }
        return strArr2;
    }

    public static String[] getMinDisplayStrings(int i10, String[] strArr) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(10);
        while (i10 < strArr.length) {
            arrayList.add(strArr[i10]);
            i10++;
        }
        if (arrayList.size() < 3) {
            int i11 = 0;
            for (int size = 3 - arrayList.size(); size > 0; size--) {
                if (i11 < strArr.length) {
                    arrayList.add(strArr[i11]);
                    i11++;
                }
            }
        }
        String[] strArr2 = new String[arrayList.size()];
        int size2 = arrayList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            strArr2[i12] = (String) arrayList.get(i12);
        }
        return strArr2;
    }

    public static void getTwoMaxList(int i10, String[] strArr, String[] strArr2, List<String> list, List<String> list2) {
        if (strArr == null || strArr2 == null) {
            Log.e(f43024a, "getTwoMaxList: currentStrings or currentNumberStrings is null!");
            return;
        }
        if (strArr.length > strArr2.length) {
            Log.e(f43024a, "getTwoMaxList: currentStrings's length is greater than currentNumberStrings's length!");
            return;
        }
        if (list == null || list2 == null) {
            Log.e(f43024a, "getTwoMaxList: displayList or displayNumberList is null!");
            return;
        }
        int i11 = i10 + 1;
        if (i11 < 3) {
            int length = strArr.length - 1;
            for (int i12 = 3 - i11; i12 > 0 && length >= 0; i12--) {
                list.add(strArr[length]);
                list2.add(strArr2[length]);
                length--;
            }
        }
        for (int i13 = 0; i13 <= i10; i13++) {
            list.add(strArr[i13]);
            list2.add(strArr2[i13]);
        }
    }

    public static void getTwoMinList(int i10, String[] strArr, String[] strArr2, List<String> list, List<String> list2) {
        if (strArr == null || strArr2 == null) {
            Log.e(f43024a, "getTwoMaxList: currentStrings or currentNumberStrings is null!");
            return;
        }
        if (strArr.length > strArr2.length) {
            Log.e(f43024a, "getTwoMaxList: currentStrings's length is greater than to currentNumberStrings's length!");
            return;
        }
        if (list == null || list2 == null) {
            Log.e(f43024a, "getTwoMaxList: displayList or displayNumberList is null!");
            return;
        }
        while (i10 < strArr.length) {
            list.add(strArr[i10]);
            list2.add(strArr2[i10]);
            i10++;
        }
        if (list.size() < 3) {
            int i11 = 0;
            for (int size = 3 - list.size(); size > 0 && i11 < strArr.length && i11 < strArr2.length; size--) {
                list.add(strArr[i11]);
                list2.add(strArr2[i11]);
                i11++;
            }
        }
    }

    public static String[] listChangeGroup(List<String> list) {
        if (list == null) {
            Log.e(f43024a, "listChangeGroup | but list is null !");
            return new String[0];
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = list.get(i10);
        }
        return strArr;
    }
}
