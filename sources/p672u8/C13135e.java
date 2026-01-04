package p672u8;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.manager.IconManager;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import dj.C9159b;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p399jk.AbstractC10896a;
import p514o9.C11839m;
import p684un.C13230i;

/* renamed from: u8.e */
/* loaded from: classes2.dex */
public class C13135e {
    /* renamed from: b */
    public static <T> T m79002b(String str, Class<T> cls) {
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("CloudDIskUtils", "fromJson err = " + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static void m79003c(Activity activity, int i10, int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (C0209d.m1269j1()) {
            m79004d(activity, i11);
        } else {
            m79005e(activity, i10, i11);
        }
    }

    /* renamed from: d */
    public static void m79004d(Activity activity, int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_HONOR");
        C0209d.m1302r2(intent, "com.hihonor.filemanager");
        intent.putExtra("campaignTaskId", i10);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.resolveActivity(activity.getPackageManager()) == null) {
            m79005e(activity, 0, i10);
            return;
        }
        C11839m.m70688i("CloudDIskUtils", "gotoCloudDrive4Honor , resolveActivity is not null");
        try {
            activity.startActivity(hiCloudSafeIntent);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDIskUtils", "gotoCloudDrive4Honor startactivity error:" + e10.toString());
        }
        m79008h(activity);
    }

    /* renamed from: e */
    public static void m79005e(Activity activity, int i10, int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intent intent = new Intent();
        intent.setAction("com.huawei.hidisk.cloud.CLOUD_DISK_COMPATIBLE_NEW");
        C0209d.m1302r2(intent, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        intent.putExtra("fromWhere", "hidisk");
        intent.putExtra("campaignTaskId", i11);
        C9159b.m57571j(intent);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (hiCloudSafeIntent.resolveActivity(activity.getPackageManager()) != null) {
            C11839m.m70688i("CloudDIskUtils", "resolveActivity is not null");
            try {
                hiCloudSafeIntent.putExtra("from_to", i10);
                hiCloudSafeIntent.addFlags(268468224);
                activity.startActivity(hiCloudSafeIntent);
            } catch (Exception e10) {
                C11839m.m70687e("CloudDIskUtils", "gotoHwCloudDrive startactivity error:" + e10.toString());
            }
            m79008h(activity);
            return;
        }
        C11839m.m70688i("CloudDIskUtils", "resolveActivity is null,goto old");
        Intent intent2 = new Intent();
        intent2.setAction("android.intent.action.VIEW");
        C0209d.m1302r2(intent2, NextRestoreConstants.PKG_NAME_FILE_MANAGER);
        HiCloudSafeIntent hiCloudSafeIntent2 = new HiCloudSafeIntent(intent2);
        if (hiCloudSafeIntent2.resolveActivity(activity.getPackageManager()) == null) {
            C11839m.m70687e("CloudDIskUtils", "FileManager not Install");
            return;
        }
        hiCloudSafeIntent2.setComponent(new ComponentName(NextRestoreConstants.PKG_NAME_FILE_MANAGER, "com.huawei.hidisk.filemanager.FileManager"));
        hiCloudSafeIntent2.putExtra("HiCloud_toHwDriveTab", 2);
        hiCloudSafeIntent2.putExtra("from_to", i10);
        hiCloudSafeIntent2.putExtra("campaignTaskId", i11);
        hiCloudSafeIntent2.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        try {
            activity.startActivity(hiCloudSafeIntent2);
        } catch (Exception e11) {
            AbstractC10896a.m65886e("CloudDIskUtils", "startActivity failed" + e11.toString());
        }
        m79008h(activity);
    }

    /* renamed from: f */
    public static void m79006f(final Activity activity, final int i10, final int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (activity == null) {
            C11839m.m70687e("CloudDIskUtils", "context is null");
            return;
        }
        if (activity.getPackageManager() == null) {
            C11839m.m70687e("CloudDIskUtils", "gotoHwCloudDrive package manager is null");
            return;
        }
        IconManager iconManager = new IconManager(activity);
        if (iconManager.m16463w(iconManager.m16456p())) {
            m79003c(activity, i10, i11);
            return;
        }
        C13230i.m79504I().m79567R("mecloud_filemanager_icon_is_not_exist", new LinkedHashMap<>());
        UBAAnalyze.m29943D("CKC", "mecloud_filemanager_icon_is_not_exist");
        if (iconManager.m16434A("filemanagerLastTime")) {
            iconManager.m16450R(new IconManager.CallBack() { // from class: u8.d
                @Override // com.huawei.android.hicloud.manager.IconManager.CallBack
                /* renamed from: a */
                public final void mo16466a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    C13135e.m79003c(activity, i10, i11);
                }
            });
        } else {
            m79003c(activity, i10, i11);
        }
    }

    /* renamed from: h */
    public static void m79008h(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        context.getSharedPreferences("toHwDriveTab", 0).edit().putBoolean("goToNetTab", true).commit();
        new HwAnimationReflection(context).m15927c(1);
    }

    /* renamed from: i */
    public static String m79009i(Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e10) {
            C11839m.m70687e("CloudDIskUtils", "toJson err = " + e10.getMessage());
            return null;
        }
    }
}
