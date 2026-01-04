package com.huawei.android.hicloud.cloudbackup.manager;

import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.huawei.android.hicloud.cloudbackup.callable.DownloadDeviceIconCallBack;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.feedback.mail.util.IoUtils;
import com.huawei.hicloud.notification.util.NotifyUtil;
import hk.C10278a;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import p015ak.C0213f;
import p035bk.C1248a;
import p514o9.C11829c;
import p514o9.C11835i;
import p514o9.C11839m;
import p514o9.C11842p;
import p626ry.C12652a;
import p626ry.C12653b;

/* loaded from: classes2.dex */
public class DeviceIconManager {
    private static final String GET_DEVICE_ICON_ROOT = "GetDeviceIconRoot";
    private static final long MILLISECONDS_OF_SEVEN_DAYS = 604800000;
    private static final String TAG = "DeviceIconManager";
    private static DeviceIconManager instance = new DeviceIconManager();
    private SharedPreferences deviceIconSp;

    private static Drawable drawableDefault(String str) {
        if (C11829c.m70520H0(str)) {
            return C0213f.m1377a().getResources().getDrawable(R$drawable.ic_public_pad);
        }
        if (!"phone".equals(str) && C11842p.m70762R0()) {
            return C0213f.m1377a().getResources().getDrawable(R$drawable.ic_public_pad);
        }
        return C0213f.m1377a().getResources().getDrawable(R$drawable.ic_agr_phone);
    }

    public static DeviceIconManager getInstance() {
        return instance;
    }

    public void clearCache() {
        SharedPreferences sharedPreferences = C0213f.m1377a().getSharedPreferences("deviceIconValidityFileInfo", 0);
        this.deviceIconSp = sharedPreferences;
        if (sharedPreferences == null) {
            C11839m.m70689w(TAG, "clearCache deviceIconSp is null");
        } else {
            C11835i.m70643g(getCacheFilePath(GET_DEVICE_ICON_ROOT));
            this.deviceIconSp.edit().clear().commit();
        }
    }

    public void downloadDeviceIcon(HashMap<String, String> map) {
        C11839m.m70688i(TAG, "downloadDeviceIcon start. ");
        try {
            HashMap map2 = new HashMap(map);
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (!C12653b.m76182b(str2) && !C12653b.m76182b(str)) {
                    if (isCacheVaild(str)) {
                        C11839m.m70688i(TAG, "downloadDeviceIcon terminalType:" + str + " is valid, no need to download");
                        return;
                    }
                    String cacheFilePath = getCacheFilePath(str);
                    if (C12653b.m76182b(cacheFilePath)) {
                        C11839m.m70688i(TAG, "cache path isEmpty");
                        return;
                    }
                    C11839m.m70688i(TAG, "terminalType : " + str);
                    NotifyUtil.downloadFileToPath(cacheFilePath, str2, new DownloadDeviceIconCallBack(str2, cacheFilePath, 0L, map2, str));
                }
            }
        } catch (Exception e10) {
            C11839m.m70688i(TAG, "downloadDeviceIcon error:" + e10.getMessage());
        }
    }

    public String getCacheFilePath(String str) {
        if (C12653b.m76182b(str)) {
            C11839m.m70689w(TAG, "getCacheFilePath: terminalType is empty");
            return null;
        }
        try {
            String backupDeviceIconRootPath = CloudBackupUtil.getBackupDeviceIconRootPath(C0213f.m1377a());
            return C12653b.m76181a(str, GET_DEVICE_ICON_ROOT) ? backupDeviceIconRootPath : backupDeviceIconRootPath.concat(str);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getCacheFilePath error: " + e10.getMessage() + ", terminalType: " + str);
            return null;
        }
    }

    public Drawable getDeviceIconFromCache(String str, String str2) {
        if (!isCacheFileExist(str)) {
            return drawableDefault(str2);
        }
        String cacheFilePath = getCacheFilePath(str);
        try {
            return new BitmapDrawable(C1248a.m7472c(cacheFilePath));
        } catch (Exception e10) {
            IoUtils.deleteFile(cacheFilePath);
            C11839m.m70688i(TAG, "getDeviceIconFromCache error, terminalType:" + str + " , deviceCategory : " + str2 + ", err:" + e10.getMessage());
            return drawableDefault(str2);
        }
    }

    public boolean isCacheFileExist(String str) {
        try {
            if (C12653b.m76182b(str)) {
                C11839m.m70689w(TAG, "isCacheFileExist terminalType is empty");
                return false;
            }
            File fileM63442h = C10278a.m63442h(getCacheFilePath(str));
            C11839m.m70688i(TAG, "isCacheFileExist terminalType: " + str + ", is Exist:" + C11835i.m70650n(fileM63442h));
            return C11835i.m70650n(fileM63442h);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "isCacheFileExist terminalType error: " + e10.getMessage());
            return false;
        }
    }

    public boolean isCacheVaild(String str) {
        if (C12653b.m76182b(str)) {
            C11839m.m70689w(TAG, "isCacheVaild terminalType is empty");
            return false;
        }
        SharedPreferences sharedPreferences = C0213f.m1377a().getSharedPreferences("deviceIconValidityFileInfo", 0);
        this.deviceIconSp = sharedPreferences;
        if (sharedPreferences == null) {
            C11839m.m70689w(TAG, "isCacheValid storage is null");
            return false;
        }
        try {
            long j10 = sharedPreferences.getLong(str, 0L);
            if (C12652a.m76180b(Long.valueOf(j10))) {
                return false;
            }
            long time = new Date().getTime();
            if (time <= j10) {
                return isCacheFileExist(str);
            }
            C11839m.m70689w(TAG, "isCacheValid: terminalType:" + str + ", expirationTime is :" + j10 + ", currentTime is :" + time);
            return false;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, String.format("isCacheValid error: terminalType=%s, exception=%s", str, e10.getMessage()));
            return false;
        }
    }

    public void updateCacheValidity(String str) {
        if (C12653b.m76182b(str)) {
            C11839m.m70689w(TAG, "updateCacheValidity terminalType is empty");
            return;
        }
        long time = new Date().getTime() + 604800000;
        C11839m.m70688i(TAG, String.format("updateCacheValidity: terminalType=%s, expirationTime=%s", str, Long.valueOf(time)));
        SharedPreferences sharedPreferences = C0213f.m1377a().getSharedPreferences("deviceIconValidityFileInfo", 0);
        this.deviceIconSp = sharedPreferences;
        if (sharedPreferences == null) {
            C11839m.m70689w(TAG, "updateCacheValidity deviceIconSp is null");
        } else {
            sharedPreferences.edit().putLong(str, time).commit();
        }
    }
}
