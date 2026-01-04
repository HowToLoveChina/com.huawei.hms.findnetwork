package com.huawei.fastengine.fastview.card.helpler;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.VersionInfo;
import com.huawei.fastengine.fastview.card.bean.CardInfo;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.util.FastViewUtils;
import com.huawei.fastengine.fastview.util.ThreadUtil;
import com.huawei.fastengine.internal.DistributeType;
import com.huawei.fastengine.internal.FastSdkLoader;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CardHelper {
    private static final String CARD_FILE_DIR = "quick_app_card_js_files";
    private static final String CARD_FILE_PREFIX = "card_js_";
    private static final String TAG = "CardHelper";

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static File getCardFile(Context context, String str) {
        int iIndexOf = str.indexOf(Constants.QUESTION_STR);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        String strHash = hash(str);
        File file = new File(context.getFilesDir(), CARD_FILE_DIR);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return new File(file, CARD_FILE_PREFIX + strHash);
    }

    public static int getPlatformVersionCode(Context context) {
        String str;
        if (DistributeType.HostMode == FastSdkLoader.HostMode.Full) {
            return VersionInfo.PLATFORM_VERSION;
        }
        if (context == null) {
            FastViewLogUtils.m28724e(TAG, "getPlatformVersionCode context == null");
            return -1;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                Bundle bundle = packageManager.getApplicationInfo(Config.getPackageName(), 128).metaData;
                if (bundle != null) {
                    return bundle.getInt("com.huawei.fastapp.apilevel", -1);
                }
                return -1;
            } catch (PackageManager.NameNotFoundException unused) {
                str = "getPlatformVersionCode exception";
            }
        } else {
            str = "getPlatformVersionCode packageManager == null";
        }
        FastViewLogUtils.m28724e(TAG, str);
        return -1;
    }

    private static String hash(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            FastViewLogUtils.m28728w(TAG, "NoSuchAlgorithmException!");
            return "";
        }
    }

    public static void limitCardCacheJsFile(Context context, final int i10) {
        final File[] fileArrListFiles;
        FastViewLogUtils.m28726i(TAG, "limitCardCacheJsFile,maxFile:" + i10);
        if (i10 > 0 && context != null) {
            File file = new File(context.getFilesDir(), CARD_FILE_DIR);
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                ThreadUtil.INST.excute(new Runnable() { // from class: com.huawei.fastengine.fastview.card.helpler.CardHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList();
                        int i11 = 0;
                        while (true) {
                            File[] fileArr = fileArrListFiles;
                            if (i11 >= fileArr.length) {
                                break;
                            }
                            File file2 = fileArr[i11];
                            if (file2 != null && file2.getName().startsWith(CardHelper.CARD_FILE_PREFIX)) {
                                arrayList.add(file2);
                            }
                            i11++;
                        }
                        if (arrayList.size() > i10) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.huawei.fastengine.fastview.card.helpler.CardHelper.1.1
                                @Override // java.util.Comparator
                                public int compare(File file3, File file4) {
                                    return file3.lastModified() > file4.lastModified() ? -1 : 1;
                                }
                            });
                            int size = arrayList.size() / 2;
                            for (int size2 = arrayList.size() - 1; size2 > size; size2 += -1) {
                                FastViewLogUtils.m28722d(CardHelper.TAG, "delete file result:" + ((File) arrayList.get(size2)).delete());
                            }
                        }
                    }
                });
            }
        }
    }

    public static CardInfo parseCardInfoByUrl(String str) {
        int iIndexOf;
        CardInfo cardInfo = new CardInfo();
        cardInfo.setOriginUrl(str);
        if (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf(Constants.QUESTION_STR)) != -1) {
            String strSubstring = str.substring(iIndexOf + 1);
            if (strSubstring.contains("=")) {
                JSONObject jSONObject = new JSONObject();
                for (String str2 : strSubstring.split("&")) {
                    String[] strArrSplit = str2.split("=");
                    if (strArrSplit.length == 2) {
                        try {
                            jSONObject.put(strArrSplit[0], strArrSplit[1]);
                        } catch (ClassCastException | IllegalArgumentException | NullPointerException | UnsupportedOperationException | JSONException unused) {
                            FastViewLogUtils.m28724e(TAG, "parseCardParamsDataByUrl throw." + strArrSplit[0] + ",1:" + strArrSplit[1]);
                        }
                    }
                }
                Object objRemove = jSONObject.remove(CardInfo.COMMON_PACKAGE_NAME);
                cardInfo.setPackageName(objRemove == null ? null : String.valueOf(objRemove));
                cardInfo.setApiLevel(FastViewUtils.parseInt(jSONObject.remove(CardInfo.COMMON_API_LEVEL), 0));
                Object objRemove2 = jSONObject.remove(CardInfo.COMMON_HW_SIGNATURE);
                cardInfo.setSignature(objRemove2 != null ? String.valueOf(objRemove2) : null);
                cardInfo.setJsParam(jSONObject.toString());
            }
        }
        return cardInfo;
    }
}
