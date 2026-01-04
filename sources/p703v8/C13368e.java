package p703v8;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudspace.bean.AlbumSavedInfo;
import com.huawei.android.hicloud.cloudspace.bean.BackupCacheInfo;
import com.huawei.android.hicloud.cloudspace.bean.BackupStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.DiskStorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.HDSpaceDetail;
import com.huawei.android.hicloud.cloudspace.bean.StorageInfo;
import com.huawei.android.hicloud.cloudspace.bean.StorageModuleInfo;
import com.huawei.android.hicloud.cloudspace.bean.TotalStorageInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback;
import com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback;
import com.huawei.android.hicloud.commonlib.space.FullQuotaInfo;
import com.huawei.android.hicloud.commonlib.space.UsedSpaceInfo;
import com.huawei.hicloud.base.bean.CloudSpaceInfo;
import com.huawei.hicloud.base.bean.QuotaInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hicloud.router.data.CloudSpaceUsageConfig;
import com.huawei.hicloud.router.data.CloudSpaceUsageItemColor;
import com.huawei.hicloud.router.data.FamilySharePageConfig;
import com.huawei.hicloud.space.R$drawable;
import com.huawei.hms.network.embedded.C5963j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0239x;
import p020ap.C1006a;
import p020ap.C1007b;
import p020ap.C1008c;
import p037bp.C1270a;
import p232dp.InterfaceC9283b;
import p232dp.InterfaceC9284c;
import p336he.C10155f;
import p371ik.C10527a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12299b;
import p572qb.C12330v;
import p616rk.C12515a;
import p664u0.C13108a;
import p709vj.C13452e;
import p732w8.AsyncTaskC13556g;
import p732w8.AsyncTaskC13557h;
import p732w8.AsyncTaskC13559j;
import p732w8.AsyncTaskC13570u;
import p732w8.AsyncTaskC13571v;
import p732w8.C13549a0;
import p742wj.C13612b;
import p746wn.C13622a;
import p783xp.C13843a;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;

/* renamed from: v8.e */
/* loaded from: classes2.dex */
public class C13368e implements InterfaceC14351b {

    /* renamed from: v */
    public static final HashMap<String, Integer> f60252v = new e();

    /* renamed from: a */
    public C11060c f60253a;

    /* renamed from: b */
    public List<CloudStorageCallback> f60254b;

    /* renamed from: c */
    public final Object f60255c;

    /* renamed from: d */
    public final Object f60256d;

    /* renamed from: e */
    public final Object f60257e;

    /* renamed from: f */
    public final Object f60258f;

    /* renamed from: g */
    public volatile boolean f60259g;

    /* renamed from: h */
    public volatile boolean f60260h;

    /* renamed from: i */
    public volatile boolean f60261i;

    /* renamed from: j */
    public volatile boolean f60262j;

    /* renamed from: k */
    public volatile StorageInfo f60263k;

    /* renamed from: l */
    public Context f60264l;

    /* renamed from: m */
    public C12330v f60265m;

    /* renamed from: n */
    public volatile boolean f60266n;

    /* renamed from: o */
    public volatile boolean f60267o;

    /* renamed from: p */
    public Random f60268p;

    /* renamed from: q */
    public volatile FullQuotaInfo f60269q;

    /* renamed from: r */
    public C13364a f60270r;

    /* renamed from: s */
    public Handler.Callback f60271s;

    /* renamed from: t */
    public CloudStorageTaskCallback f60272t;

    /* renamed from: u */
    public QuotaInfoCallback f60273u;

    /* renamed from: v8.e$a */
    public class a implements InterfaceC14350a {
        public a() {
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: a */
        public void mo13562a() {
            C11839m.m70688i("CloudStorageManager", "oncloudnormal");
            C1006a.m5936k().m5954R(C0213f.m1377a(), 0, 0L);
            C13368e.this.f60263k.setDisuseState(0);
            C13368e.this.f60265m.m74150f("gallery_use", true);
            C13368e.this.m80260v0("space_shelve", "space_operate_finish", "space_result_success", "", -1L);
            C13368e.this.m80261w();
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: b */
        public void mo13563b() {
            C11839m.m70688i("CloudStorageManager", "onqueryfail");
            C13368e.this.f60263k.setDisuseState(-2);
            C13368e.this.f60265m.m74150f("gallery_use", true);
            C13368e.this.m80260v0("space_shelve", "space_operate_finish", "space_result_success", "", -1L);
            C13368e.this.m80261w();
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: c */
        public void mo13564c() {
            C11839m.m70688i("CloudStorageManager", "oncloudnonsupport");
            C1006a.m5936k().m5954R(C0213f.m1377a(), -1, 0L);
            C13368e.this.f60263k.setDisuseState(-1);
            C13368e.this.f60265m.m74150f("gallery_use", true);
            C13368e.this.m80260v0("space_shelve", "space_operate_finish", "space_result_success", "", -1L);
            C13368e.this.m80261w();
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: d */
        public void mo13565d(int i10, int i11, long j10, int i12) {
            C11839m.m70688i("CloudStorageManager", "onclouddisabled");
            C1006a.m5936k().m5954R(C0213f.m1377a(), 1, j10);
            C13368e.this.f60263k.setLeftDays(C1007b.m5980s().m6029u(C13368e.this.m80235Y()));
            C13368e.this.f60263k.setDisuseState(1);
            C13368e.this.f60265m.m74150f("gallery_use", true);
            C13368e.this.m80260v0("space_shelve", "space_operate_finish", "space_result_success", "", -1L);
            C13368e.this.m80261w();
        }
    }

    /* renamed from: v8.e$b */
    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.arg1 == 1) {
                C13368e.this.m80244i0(1);
                return false;
            }
            int i10 = message.what;
            if (i10 == 32317) {
                C13368e.this.f60260h = true;
                C13368e.this.m80259v();
            } else if (i10 == 32319) {
                C13368e.this.m80243h0(2);
                C13368e.this.f60260h = true;
            } else if (i10 == 32324) {
                C13368e.this.f60261i = true;
                C13368e.this.m80259v();
            } else if (i10 == 32337) {
                C13368e.this.f60262j = true;
                C13368e.this.m80259v();
            }
            return false;
        }
    }

    /* renamed from: v8.e$c */
    public class c implements CloudStorageTaskCallback {
        public c() {
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback
        /* renamed from: a */
        public void mo15484a(String str, Object obj, int i10) {
            synchronized (C13368e.this.f60255c) {
                try {
                    if (str.equals("used_size")) {
                        Long l10 = obj != null ? (Long) obj : null;
                        if (l10 != null) {
                            C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", ---TASK_NAME_USED_SIZE=" + l10);
                            C13368e.this.m80217G0(l10.longValue(), i10);
                            C13368e.this.m80245j0(l10.longValue());
                        }
                    } else {
                        if (str.equals("total_size")) {
                            TotalStorageInfo totalStorageInfo = (TotalStorageInfo) obj;
                            C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", ---TASK_NAME_TOTAL_SIZE=" + (totalStorageInfo != null ? totalStorageInfo.getTotalSize() : -1L));
                            C13368e.this.m80215F0(totalStorageInfo, i10);
                            C13368e.this.f60263k.setTotalInfo(totalStorageInfo);
                        } else if (str.equals(CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
                            BackupStorageInfo backupStorageInfo = (BackupStorageInfo) obj;
                            C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", ---TASK_NAME_BACKUP=" + (backupStorageInfo != null ? backupStorageInfo.getBackupUsedSize() : -1L));
                            C13368e.this.m80268z0(backupStorageInfo, i10);
                        } else if (str.equals("disk")) {
                            DiskStorageInfo diskStorageInfo = (DiskStorageInfo) obj;
                            if (diskStorageInfo == null) {
                                C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", ---TASK_NAME_DISK=-1");
                                C13368e.this.f60265m.m74150f("disk", false);
                                C13368e.this.m80260v0("space_disk", "space_operate_finish", "space_result_failed", String.valueOf(i10), -1L);
                                C13368e.this.m80263x(i10, str);
                                return;
                            }
                            long diskUsedSize = diskStorageInfo.getDiskUsedSize();
                            C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", ---TASK_NAME_DISK=" + diskUsedSize);
                            C13368e.this.f60265m.m74150f("disk", true);
                            C13368e.this.f60263k.setDiskDetails(diskStorageInfo.getDiskDetails());
                            C13368e.this.f60263k.setDiskUsedSize(diskStorageInfo.getDiskUsedSize());
                            C13368e.this.f60263k.setRecycleSize(diskStorageInfo.getRecycleSize());
                            C13368e.this.f60263k.setAppSize(C13368e.this.m80211D());
                            C13368e.this.f60263k.setCloudDriveSize(diskStorageInfo.getCloudDriveSize());
                            C13368e.this.m80260v0("space_disk", "space_operate_finish", "space_result_success", String.valueOf(i10), diskUsedSize);
                        }
                    }
                    C13368e.this.m80263x(i10, str);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageTaskCallback
        /* renamed from: b */
        public void mo15485b(String str, Object obj, int i10) {
            long backupUsedSize;
            if (str.equals(CloudBackupConstant.Command.PMS_CMD_BACKUP)) {
                BackupCacheInfo backupCacheInfo = obj instanceof BackupCacheInfo ? (BackupCacheInfo) obj : null;
                if (backupCacheInfo == null) {
                    C11839m.m70687e("CloudStorageManager", "backupSize query failed");
                    C13368e.this.f60265m.m74150f(CloudBackupConstant.Command.PMS_CMD_BACKUP, false);
                    backupUsedSize = -1;
                    C13368e.this.m80242g0(-1L);
                } else {
                    C13368e.this.f60265m.m74150f(CloudBackupConstant.Command.PMS_CMD_BACKUP, true);
                    backupUsedSize = backupCacheInfo.getBackupUsedSize();
                    C13368e.this.m80242g0(backupUsedSize);
                    C13368e.this.f60263k.setBackupCacheInfo(backupCacheInfo);
                    C13368e.this.f60263k.setEnterSpaceDetailUseCache(true);
                }
                C11839m.m70688i("CloudStorageManager", "onTaskFinishWithCache, requestId=" + i10 + ", ---TASK_NAME_BACKUP=" + backupUsedSize);
            }
        }
    }

    /* renamed from: v8.e$d */
    public class d implements QuotaInfoCallback {
        public d() {
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback
        /* renamed from: a */
        public void mo15490a() {
            C11839m.m70688i("CloudStorageManager", "query quota info failed");
            C13368e.this.m80251p0();
        }

        @Override // com.huawei.android.hicloud.cloudspace.manager.QuotaInfoCallback
        /* renamed from: b */
        public void mo15491b() {
            C11839m.m70688i("CloudStorageManager", "query quota info success");
            C13368e.this.m80252q0();
        }
    }

    /* renamed from: v8.e$e */
    public class e extends HashMap<String, Integer> {
        public e() {
            put(CloudBackupConstant.Command.PMS_CMD_BACKUP, Integer.valueOf(R$drawable.space_display_backup_icon));
            put("drive", Integer.valueOf(R$drawable.space_display_drive_icon));
            put("photos", Integer.valueOf(R$drawable.space_display_photos_icon));
            put("other", Integer.valueOf(R$drawable.space_display_other_icon));
            put("family", Integer.valueOf(R$drawable.space_display_family_icon));
        }
    }

    /* renamed from: v8.e$f */
    public static class f {

        /* renamed from: a */
        public static C13368e f60278a = new C13368e(null);
    }

    public /* synthetic */ C13368e(a aVar) {
        this();
    }

    /* renamed from: A */
    public static String m80183A(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmap = null;
        try {
            try {
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a == null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e10) {
                        C11839m.m70687e("CloudStorageManager", e10.toString());
                    }
                    return "";
                }
                Resources resources = contextM1377a.getResources();
                if (resources == null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e11) {
                        C11839m.m70687e("CloudStorageManager", e11.toString());
                    }
                    return "";
                }
                Integer num = m80185N().get(str);
                if (num == null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e12) {
                        C11839m.m70687e("CloudStorageManager", e12.toString());
                    }
                    return "";
                }
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, num.intValue());
                if (bitmapDecodeResource == null) {
                    if (bitmapDecodeResource != null) {
                        try {
                            bitmapDecodeResource.recycle();
                        } catch (Exception e13) {
                            C11839m.m70687e("CloudStorageManager", e13.toString());
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e14) {
                        C11839m.m70687e("CloudStorageManager", e14.toString());
                    }
                    return "";
                }
                bitmapDecodeResource.compress(Bitmap.CompressFormat.WEBP, 100, byteArrayOutputStream);
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                try {
                    bitmapDecodeResource.recycle();
                } catch (Exception e15) {
                    C11839m.m70687e("CloudStorageManager", e15.toString());
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e16) {
                    C11839m.m70687e("CloudStorageManager", e16.toString());
                }
                return strEncodeToString;
            } catch (Exception e17) {
                C11839m.m70687e("CloudStorageManager", "convertDrawableToBase64 error " + e17);
                if (0 != 0) {
                    try {
                        bitmap.recycle();
                    } catch (Exception e18) {
                        C11839m.m70687e("CloudStorageManager", e18.toString());
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e19) {
                    C11839m.m70687e("CloudStorageManager", e19.toString());
                }
                return "";
            }
        } finally {
        }
    }

    /* renamed from: F */
    public static C13368e m80184F() {
        return f.f60278a;
    }

    /* renamed from: N */
    public static HashMap<String, Integer> m80185N() {
        return f60252v;
    }

    /* renamed from: e0 */
    public static boolean m80191e0(long j10) {
        return j10 <= 0 && !(C13452e.m80781L().m80798E() == 0 && C13452e.m80781L().m80791C0());
    }

    /* renamed from: A0 */
    public void m80206A0(StorageInfo storageInfo) {
        C11839m.m70687e("CloudStorageManager", "updateDiskDataEu");
        if (storageInfo == null) {
            C11839m.m70687e("CloudStorageManager", "diskSize query failed");
            this.f60265m.m74150f("disk", false);
            m80261w();
            return;
        }
        this.f60265m.m74150f(PowerKitApplyUtil.GROUP_ALBUM, true);
        this.f60265m.m74150f("disk", true);
        this.f60263k.setGalleryUsedSize(storageInfo.getGalleryUsedSize());
        this.f60263k.setGalleryDeleteSize(storageInfo.getGalleryDeleteSize());
        this.f60263k.setBackupUsedSize(storageInfo.getBackupUsedSize());
        this.f60263k.setBackupDetails(storageInfo.getBackupDetails());
        this.f60263k.setDiskDetails(storageInfo.getDiskDetails());
        this.f60263k.setDiskUsedSize(storageInfo.getDiskUsedSize());
        this.f60263k.setRecycleSize(storageInfo.getRecycleSize());
        this.f60263k.setAppSize(m80211D());
        this.f60263k.setCloudDriveSize(storageInfo.getCloudDriveSize());
        Message message = new Message();
        message.what = 32324;
        long galleryUsedSize = storageInfo.getGalleryUsedSize();
        long galleryDeleteSize = storageInfo.getGalleryDeleteSize();
        if (galleryUsedSize < 0) {
            galleryUsedSize = 0;
        }
        if (galleryDeleteSize < 0) {
            galleryDeleteSize = 0;
        }
        C11839m.m70688i("CloudStorageManager", "gallery space=" + galleryUsedSize + " galleryDeleteSize = " + galleryDeleteSize);
        message.arg1 = 0;
        message.obj = Long.valueOf(galleryUsedSize);
        storageInfo.setGalleryUsedSize(galleryUsedSize);
        storageInfo.setGalleryDeleteSize(galleryDeleteSize);
        C1007b.m5980s().m6000T(message);
        m80261w();
    }

    /* renamed from: B */
    public void m80207B(Messenger messenger) {
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17119d0(m80235Y(), messenger);
        }
    }

    /* renamed from: B0 */
    public void m80208B0(long j10, long j11) {
        if (this.f60263k == null) {
            return;
        }
        this.f60263k.setGalleryUsedSize(j10);
        this.f60263k.setGalleryDeleteSize(j11);
        this.f60265m.m74150f(PowerKitApplyUtil.GROUP_ALBUM, true);
    }

    /* renamed from: C */
    public void m80209C(Messenger messenger) {
        InterfaceC9284c interfaceC9284c = (InterfaceC9284c) C1270a.m7534b().m7535a(InterfaceC9284c.class);
        if (interfaceC9284c != null) {
            interfaceC9284c.mo17161y0(m80235Y(), messenger);
        }
    }

    /* renamed from: C0 */
    public void m80210C0(FullQuotaInfo fullQuotaInfo) {
        synchronized (this.f60256d) {
            this.f60269q = fullQuotaInfo;
        }
    }

    /* renamed from: D */
    public final long m80211D() {
        long fsize = 0;
        if (this.f60263k == null) {
            C11839m.m70687e("CloudStorageManager", "getAppSize storageInfo null");
            return 0L;
        }
        for (HDSpaceDetail hDSpaceDetail : this.f60263k.getDiskDetails()) {
            String moduleName = hDSpaceDetail.getModuleName();
            if (moduleName == null) {
                C11839m.m70687e("CloudStorageManager", "getAppSize module name null");
            } else {
                if (moduleName.equals("notepad") || moduleName.equals(HNConstants.DataType.CONTACT) || moduleName.equals("sync")) {
                    fsize += hDSpaceDetail.getFsize();
                }
                if (moduleName.equals("record") || moduleName.equals("phonemanager")) {
                    if (!C10155f.m63288l()) {
                        fsize += hDSpaceDetail.getFsize();
                    }
                }
            }
        }
        return fsize;
    }

    /* renamed from: D0 */
    public void m80212D0() {
        this.f60263k.setDisuseState(C1006a.m5936k().m5969p(m80235Y()));
        this.f60263k.setLeftDays(C1007b.m5980s().m6029u(m80235Y()));
    }

    /* renamed from: E */
    public long m80213E() {
        long j10 = 0;
        try {
            JSONArray jSONArray = new JSONArray(C0212e0.m1364n(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_space_info_list", ""));
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    String str = (String) jSONObject.get("key");
                    if (!TextUtils.isEmpty(str) && str.equals("family")) {
                        j10 = jSONObject.getLong("module_used_size");
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudStorageManager", "getQuotaStorageCache exception: " + e10.toString());
        }
        return j10;
    }

    /* renamed from: E0 */
    public void m80214E0(TotalStorageInfo totalStorageInfo) {
        C11839m.m70687e("CloudStorageManager", "updateTotalSizeEu");
        if (this.f60263k == null) {
            C11839m.m70687e("CloudStorageManager", "totalSize query failed");
            this.f60265m.m74150f("total_size", false);
            m80261w();
        } else {
            this.f60265m.m74150f("total_size", true);
            m80215F0(totalStorageInfo, 0);
            this.f60263k.setTotalInfo(totalStorageInfo);
            m80261w();
        }
    }

    /* renamed from: F0 */
    public final void m80215F0(TotalStorageInfo totalStorageInfo, int i10) {
        String str;
        long j10;
        if (totalStorageInfo == null) {
            this.f60265m.m74150f("total_size", false);
            str = "space_result_failed";
            j10 = -1;
        } else {
            long totalSize = totalStorageInfo.getTotalSize();
            this.f60265m.m74150f("total_size", true);
            str = "space_result_success";
            j10 = totalSize;
        }
        m80260v0("space_total", "space_operate_finish", str, String.valueOf(i10), j10);
    }

    /* renamed from: G */
    public final StorageModuleInfo m80216G(String str) {
        HashMap map;
        try {
            map = new HashMap();
            map.put("operation", "om_match");
            map.put("brief", str);
        } catch (Exception e10) {
            C11839m.m70687e("CloudStorageManager", "getModuleInfoFromOMByKey exception: " + e10.toString());
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudStorageManager", "getModuleInfoFromOMByKey key null");
            map.put("result", "2");
            map.put("error_reason", "011");
            C13376m.m80302a().m80304c(map);
            return null;
        }
        List<CloudSpaceUsageItemColor> listM80228R = m80228R();
        if (listM80228R == null) {
            C11839m.m70687e("CloudStorageManager", "usageItems null");
            map.put("result", "2");
            map.put("error_reason", "012");
            C13376m.m80302a().m80304c(map);
            listM80228R = C1007b.m5980s().m6016g();
        }
        for (CloudSpaceUsageItemColor cloudSpaceUsageItemColor : listM80228R) {
            if (cloudSpaceUsageItemColor == null) {
                C11839m.m70687e("CloudStorageManager", "itemColor null");
            } else {
                String key = cloudSpaceUsageItemColor.getKey();
                if (TextUtils.isEmpty(key)) {
                    C11839m.m70687e("CloudStorageManager", "getModuleInfoFromOMByKey itemKey null");
                } else if (str.equals(key)) {
                    String strM6024o = C1007b.m5980s().m6024o(key);
                    if (TextUtils.isEmpty(strM6024o)) {
                        C11839m.m70687e("CloudStorageManager", "getModuleInfoFromOMByKey moduleName null, key=" + str);
                        strM6024o = C1007b.m5980s().m6031w(str);
                    }
                    if (!TextUtils.isEmpty(strM6024o)) {
                        String color = cloudSpaceUsageItemColor.getColor();
                        String darkColor = cloudSpaceUsageItemColor.getDarkColor();
                        int color2 = Color.parseColor(color);
                        int color3 = Color.parseColor(darkColor);
                        StorageModuleInfo storageModuleInfo = new StorageModuleInfo();
                        storageModuleInfo.setModuleName(strM6024o);
                        storageModuleInfo.setModuleColor(color2);
                        storageModuleInfo.setModuleDarkColor(color3);
                        return storageModuleInfo;
                    }
                } else {
                    continue;
                }
            }
        }
        map.put("result", "2");
        map.put("error_reason", "013");
        C13376m.m80302a().m80304c(map);
        C11839m.m70687e("CloudStorageManager", "getModuleInfoFromOMByKey key not match:" + str);
        return null;
    }

    /* renamed from: G0 */
    public final void m80217G0(long j10, int i10) {
        String str;
        if (j10 == -1) {
            this.f60265m.m74150f("used_size", false);
            str = "space_result_failed";
        } else {
            this.f60265m.m74150f("used_size", true);
            str = "space_result_success";
        }
        m80260v0("space_used", "space_operate_finish", str, String.valueOf(i10), j10);
    }

    /* renamed from: H */
    public ArrayList<StorageModuleInfo> m80218H() {
        QuotaInfo quotaInfo;
        QuotaSpaceInfo quotaSpaceInfo;
        if (this.f60269q != null && (quotaInfo = this.f60269q.getQuotaInfo()) != null && (quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo()) != null) {
            long total = quotaSpaceInfo.getTotal();
            long used = quotaSpaceInfo.getUsed();
            if (used > total) {
                total = used;
            }
            if (total > 0) {
                List<UsedSpaceInfo> usedInfos = this.f60269q.getUsedInfos();
                if (usedInfos == null) {
                    C11839m.m70687e("CloudStorageManager", "getModuleSizePercent moduleUsedInfos null");
                    return null;
                }
                List<CloudSpaceUsageItemColor> listM80229S = m80229S();
                ArrayList<StorageModuleInfo> arrayList = new ArrayList<>();
                for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
                    if (usedSpaceInfo == null) {
                        C11839m.m70687e("CloudStorageManager", "getModuleSizePercent spaceInfo null");
                        return null;
                    }
                    StorageModuleInfo storageModuleInfoM80216G = m80216G(usedSpaceInfo.getKey());
                    if (storageModuleInfoM80216G == null) {
                        C11839m.m70687e("CloudStorageManager", "getModuleSizePercent moduleInfo null");
                        return null;
                    }
                    storageModuleInfoM80216G.setPercent(usedSpaceInfo.getUsed() / total);
                    arrayList.add(storageModuleInfoM80216G);
                }
                if (listM80229S != null && listM80229S.size() > usedInfos.size()) {
                    int size = listM80229S.size() - usedInfos.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        arrayList.add(new StorageModuleInfo());
                    }
                }
                Collections.sort(arrayList);
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: H0 */
    public void m80219H0(long j10) {
        C11839m.m70687e("CloudStorageManager", "updateUsedSizeEu");
        this.f60265m.m74150f("used_size", true);
        m80217G0(j10, 0);
        m80245j0(j10);
        m80261w();
    }

    /* renamed from: I */
    public ArrayList<StorageModuleInfo> m80220I() throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(C0212e0.m1364n(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_space_info_list", ""));
            ArrayList<StorageModuleInfo> arrayList = new ArrayList<>();
            long jM1360j = C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "total_size", 0L);
            long jM1360j2 = C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_size", 0L);
            if (m80191e0(jM1360j)) {
                return null;
            }
            if (jM1360j2 > jM1360j) {
                jM1360j = jM1360j2;
            }
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (jSONObject != null) {
                    float f10 = jSONObject.getLong("module_used_size") / jM1360j;
                    StorageModuleInfo storageModuleInfoM80216G = m80216G((String) jSONObject.get("key"));
                    if (storageModuleInfoM80216G != null) {
                        storageModuleInfoM80216G.setPercent(f10);
                        arrayList.add(storageModuleInfoM80216G);
                    }
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } catch (Exception e10) {
            C11839m.m70687e("CloudStorageManager", "getQuotaStorageCache exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: J */
    public UsedSpaceInfo m80221J(String str) {
        if (this.f60269q == null) {
            C11839m.m70687e("CloudStorageManager", "getModuleUsedSpaceInfo mQuotaInfo is null");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("CloudStorageManager", "getModuleUsedSpaceInfo serviceName is null");
            return null;
        }
        List<UsedSpaceInfo> usedInfos = this.f60269q.getUsedInfos();
        if (usedInfos != null) {
            for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
                if (usedSpaceInfo != null && str.equals(usedSpaceInfo.getService())) {
                    return usedSpaceInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: K */
    public final String m80222K() {
        AlbumSavedInfo albumSavedInfoM80158e = this.f60270r.m80158e();
        if (albumSavedInfoM80158e == null) {
            this.f60265m.m74150f(PowerKitApplyUtil.GROUP_ALBUM, false);
            return "space_result_failed";
        }
        synchronized (this.f60255c) {
            this.f60263k.setGalleryUsedSize(albumSavedInfoM80158e.getGalleryUsedSize());
            this.f60263k.setGalleryDeleteSize(albumSavedInfoM80158e.getGalleryDeleteSize());
        }
        this.f60265m.m74150f(PowerKitApplyUtil.GROUP_ALBUM, true);
        return "space_result_success";
    }

    /* renamed from: L */
    public QuotaSpaceInfo m80223L() {
        QuotaInfo quotaInfo;
        if (this.f60269q == null || (quotaInfo = this.f60269q.getQuotaInfo()) == null) {
            return null;
        }
        return quotaInfo.getQuotaSpaceInfo();
    }

    /* renamed from: M */
    public QuotaSpaceInfo m80224M() {
        long jM1360j = C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "total_size", 0L);
        if (m80191e0(jM1360j)) {
            return null;
        }
        QuotaSpaceInfo quotaSpaceInfo = new QuotaSpaceInfo();
        quotaSpaceInfo.setTotal(jM1360j);
        quotaSpaceInfo.setUsed(C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_size", 0L));
        quotaSpaceInfo.setAvailable(C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "available_size", 0L));
        return quotaSpaceInfo;
    }

    /* renamed from: O */
    public CloudSpaceInfo.AddInfo m80225O() {
        QuotaInfo quotaInfo;
        if (this.f60269q == null) {
            this.f60269q = (FullQuotaInfo) C10527a.m64629g(C0212e0.m1364n(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_space_info_list_json", ""), FullQuotaInfo.class);
        }
        if (this.f60269q != null && (quotaInfo = this.f60269q.getQuotaInfo()) != null) {
            CloudSpaceInfo.AddInfo addInfo = new CloudSpaceInfo.AddInfo();
            QuotaSpaceInfo quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo();
            if (quotaSpaceInfo != null) {
                long total = quotaSpaceInfo.getTotal();
                long used = quotaSpaceInfo.getUsed();
                if (used > total) {
                    total = used;
                }
                addInfo.setTotalSpace(used);
                if (total > 0) {
                    List<UsedSpaceInfo> usedInfos = this.f60269q.getUsedInfos();
                    if (usedInfos == null) {
                        C11839m.m70687e("CloudStorageManager", "getModuleSizePercent moduleUsedInfos null");
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int percent = 0;
                    for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
                        if (usedSpaceInfo == null) {
                            C11839m.m70687e("CloudStorageManager", "getModuleSizePercent spaceInfo null");
                            return null;
                        }
                        StorageModuleInfo storageModuleInfoM80216G = m80216G(usedSpaceInfo.getKey());
                        if (storageModuleInfoM80216G == null) {
                            C11839m.m70687e("CloudStorageManager", "getModuleSizePercent moduleInfo null");
                            return null;
                        }
                        CloudSpaceInfo.ProgressModel progressModel = new CloudSpaceInfo.ProgressModel();
                        if (C11842p.m70732H0(m80235Y())) {
                            progressModel.setColor("#" + Integer.toHexString(storageModuleInfoM80216G.getModuleDarkColor()).toUpperCase());
                        } else {
                            progressModel.setColor("#" + Integer.toHexString(storageModuleInfoM80216G.getModuleColor()).toUpperCase());
                        }
                        progressModel.setService(storageModuleInfoM80216G.getModuleName());
                        progressModel.setUsed(usedSpaceInfo.getUsed());
                        progressModel.setPercent(BigDecimal.valueOf((usedSpaceInfo.getUsed() / total) * 100.0f).setScale(2, RoundingMode.HALF_UP).intValue());
                        percent += progressModel.getPercent();
                        progressModel.setKey(usedSpaceInfo.getKey());
                        progressModel.setIcon("data:image/png;base64," + m80183A(usedSpaceInfo.getKey()));
                        arrayList.add(progressModel);
                    }
                    Collections.sort(arrayList);
                    addInfo.setDataPanelList(arrayList);
                    if (percent < 100 && !arrayList.isEmpty()) {
                        CloudSpaceInfo.ProgressModel progressModel2 = arrayList.get(0);
                        progressModel2.setPercent((progressModel2.getPercent() + 100) - percent);
                    }
                    return addInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: P */
    public StorageInfo m80226P() {
        StorageInfo storageInfo;
        synchronized (this.f60255c) {
            storageInfo = this.f60263k;
        }
        return storageInfo;
    }

    /* renamed from: Q */
    public List<StorageModuleInfo> m80227Q() {
        ArrayList arrayList = new ArrayList();
        try {
            List<CloudSpaceUsageItemColor> listM80228R = m80228R();
            if (listM80228R == null) {
                C11839m.m70687e("CloudStorageManager", "usageItems null");
                listM80228R = C1007b.m5980s().m6016g();
            }
            for (CloudSpaceUsageItemColor cloudSpaceUsageItemColor : listM80228R) {
                if (cloudSpaceUsageItemColor == null) {
                    C11839m.m70687e("CloudStorageManager", "itemColor null");
                } else {
                    String key = cloudSpaceUsageItemColor.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String strM6024o = C1007b.m5980s().m6024o(key);
                        if (TextUtils.isEmpty(strM6024o)) {
                            strM6024o = C1007b.m5980s().m6031w(key);
                        }
                        if (!TextUtils.isEmpty(strM6024o)) {
                            int color = Color.parseColor(cloudSpaceUsageItemColor.getColor());
                            StorageModuleInfo storageModuleInfo = new StorageModuleInfo();
                            storageModuleInfo.setModuleName(strM6024o);
                            storageModuleInfo.setModuleColor(color);
                            arrayList.add(storageModuleInfo);
                        }
                    }
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudStorageManager", "getStorageModuleFromOM exception:" + e10.toString());
        }
        return arrayList;
    }

    /* renamed from: R */
    public final List<CloudSpaceUsageItemColor> m80228R() {
        InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        FamilySharePageConfig familySharePageConfigMo58534y = interfaceC9283b != null ? interfaceC9283b.mo58534y(FamilyShareConstants.FamilyShareConfig.CLOUD_USAGE) : null;
        if (familySharePageConfigMo58534y == null) {
            C11839m.m70687e("CloudStorageManager", "getStorageModuleFromOM fullConfig null");
            return null;
        }
        CloudSpaceUsageConfig cloudSpaceUsageConfig = familySharePageConfigMo58534y.getCloudSpaceUsageConfig();
        if (cloudSpaceUsageConfig != null) {
            return cloudSpaceUsageConfig.getItemColorList();
        }
        C11839m.m70687e("CloudStorageManager", "spaceConfig null");
        return null;
    }

    /* renamed from: S */
    public final List<CloudSpaceUsageItemColor> m80229S() {
        List<CloudSpaceUsageItemColor> listM80228R = m80228R();
        return listM80228R == null ? C1007b.m5980s().m6016g() : listM80228R;
    }

    /* renamed from: T */
    public long m80230T() {
        return C0212e0.m1360j(C0213f.m1377a(), "com.huawei.android.ds_spcace_detail_cache", "used_size", 0L);
    }

    /* renamed from: U */
    public ArrayList<StorageModuleInfo> m80231U() {
        QuotaInfo quotaInfo;
        QuotaSpaceInfo quotaSpaceInfo;
        if (this.f60269q != null && (quotaInfo = this.f60269q.getQuotaInfo()) != null && (quotaSpaceInfo = quotaInfo.getQuotaSpaceInfo()) != null) {
            long used = quotaSpaceInfo.getUsed();
            if (used > 0) {
                List<UsedSpaceInfo> usedInfos = this.f60269q.getUsedInfos();
                if (usedInfos == null) {
                    C11839m.m70687e("CloudStorageManager", "getModuleSizePercent moduleUsedInfos null");
                    return null;
                }
                List<CloudSpaceUsageItemColor> listM80229S = m80229S();
                ArrayList<StorageModuleInfo> arrayList = new ArrayList<>();
                for (UsedSpaceInfo usedSpaceInfo : usedInfos) {
                    if (usedSpaceInfo == null) {
                        C11839m.m70687e("CloudStorageManager", "getModuleSizePercent spaceInfo null");
                        return null;
                    }
                    StorageModuleInfo storageModuleInfoM80216G = m80216G(usedSpaceInfo.getKey());
                    if (storageModuleInfoM80216G == null) {
                        C11839m.m70687e("CloudStorageManager", "getModuleSizePercent moduleInfo null");
                        return null;
                    }
                    storageModuleInfoM80216G.setPercent(usedSpaceInfo.getUsed() / used);
                    arrayList.add(storageModuleInfoM80216G);
                }
                if (listM80229S != null && listM80229S.size() > usedInfos.size()) {
                    int size = listM80229S.size() - usedInfos.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        arrayList.add(new StorageModuleInfo());
                    }
                }
                Collections.sort(arrayList);
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: V */
    public Object m80232V() {
        return this.f60257e;
    }

    /* renamed from: W */
    public Object m80233W() {
        return this.f60258f;
    }

    /* renamed from: X */
    public long m80234X() {
        long cloudDriveSize;
        synchronized (this.f60255c) {
            cloudDriveSize = this.f60263k.getCloudDriveSize();
        }
        return cloudDriveSize;
    }

    /* renamed from: Y */
    public final Context m80235Y() {
        Context context = this.f60264l;
        return context == null ? C0213f.m1377a() : context;
    }

    /* renamed from: Z */
    public long m80236Z() {
        long galleryUsedSize;
        synchronized (this.f60255c) {
            galleryUsedSize = this.f60263k.getGalleryUsedSize();
        }
        return galleryUsedSize;
    }

    /* renamed from: a0 */
    public long m80237a0() {
        long backupUsedSize;
        synchronized (this.f60255c) {
            backupUsedSize = this.f60263k.getBackupUsedSize();
        }
        return backupUsedSize;
    }

    /* renamed from: b0 */
    public final void m80238b0() {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07001"), "07001", C13452e.m80781L().m80971t0());
        this.f60253a = c11060cM66626a;
        c11060cM66626a.m66665u("0");
    }

    /* renamed from: c0 */
    public final void m80239c0() {
        this.f60265m = new C12330v();
        C12330v.a aVar = new C12330v.a("used_size");
        C12330v.a aVar2 = new C12330v.a("total_size");
        C12330v.a aVar3 = new C12330v.a(CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C12330v.a aVar4 = new C12330v.a("disk");
        C12330v.a aVar5 = new C12330v.a("gallery_use");
        C12330v.a aVar6 = new C12330v.a(PowerKitApplyUtil.GROUP_ALBUM);
        this.f60265m.m74145a(aVar);
        this.f60265m.m74145a(aVar2);
        this.f60265m.m74145a(aVar3);
        this.f60265m.m74145a(aVar4);
        this.f60265m.m74145a(aVar5);
        this.f60265m.m74145a(aVar6);
    }

    /* renamed from: d0 */
    public boolean m80240d0() {
        return this.f60266n;
    }

    /* renamed from: f0 */
    public boolean m80241f0() {
        return this.f60267o;
    }

    /* renamed from: g0 */
    public final void m80242g0(long j10) {
        synchronized (this.f60257e) {
            this.f60266n = true;
            this.f60263k.setBackupUsedSize(j10);
            this.f60257e.notifyAll();
        }
    }

    /* renamed from: h0 */
    public final void m80243h0(int i10) {
        C11839m.m70686d("CloudStorageManager", "notifyCallback");
        Iterator<CloudStorageCallback> it = this.f60254b.iterator();
        while (it.hasNext()) {
            it.next().mo15483q();
        }
    }

    /* renamed from: i0 */
    public final void m80244i0(int i10) {
        C11839m.m70686d("CloudStorageManager", "notifyFailedCallBack");
        Iterator<CloudStorageCallback> it = this.f60254b.iterator();
        while (it.hasNext()) {
            it.next().mo15483q();
        }
    }

    /* renamed from: j0 */
    public final void m80245j0(long j10) {
        synchronized (this.f60258f) {
            this.f60267o = true;
            this.f60263k.setUsedSize(j10);
            this.f60258f.notifyAll();
        }
    }

    /* renamed from: k0 */
    public final void m80246k0(int i10) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1006a.m5936k().m5972s(m80235Y(), this, i10);
        C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", queryAlbumStorageInfo gallerySize starttime=" + jCurrentTimeMillis);
    }

    /* renamed from: l0 */
    public synchronized void m80247l0() {
        int iNextInt = this.f60268p.nextInt(10000);
        C11839m.m70688i("CloudStorageManager", "queryBackupStorageInfo");
        AsyncTaskC13556g asyncTaskC13556gM81497h = AsyncTaskC13556g.m81497h(m80235Y(), this.f60272t);
        if (!AsyncTask.Status.RUNNING.equals(asyncTaskC13556gM81497h.getStatus())) {
            asyncTaskC13556gM81497h.m81503f(iNextInt);
            asyncTaskC13556gM81497h.m81502e(false);
            asyncTaskC13556gM81497h.m81504g(true);
            asyncTaskC13556gM81497h.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: m0 */
    public final void m80248m0() {
        C1006a.m5936k().m5948L(new a());
    }

    /* renamed from: n0 */
    public final void m80249n0() {
        C11839m.m70688i("CloudStorageManager", "queryFailed");
        this.f60259g = true;
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.QUERY_STORAGE_FINISHED");
        intent.putExtra("result", 0);
        C13108a.m78878b(m80235Y()).m78881d(intent);
    }

    /* renamed from: o0 */
    public void m80250o0() {
        InterfaceC9283b interfaceC9283b = (InterfaceC9283b) C1270a.m7534b().m7535a(InterfaceC9283b.class);
        if (interfaceC9283b == null) {
            this.f60273u.mo15490a();
            return;
        }
        C12515a.m75110o().m75172d(new C13549a0(this.f60273u));
        if (interfaceC9283b.mo58513j()) {
            C11839m.m70688i("CloudStorageManager", "config exist");
            return;
        }
        HashMap map = new HashMap();
        map.put("result", "0");
        map.put("error_reason", "010");
        C13376m.m80302a().m80304c(map);
    }

    @Override // p850zo.InterfaceC14351b
    public void onResult(Bundle bundle) {
        String strM80222K;
        long j10;
        if (bundle == null) {
            C11839m.m70688i("CloudStorageManager", "onResult bundle null");
            this.f60265m.m74150f(PowerKitApplyUtil.GROUP_ALBUM, false);
            m80261w();
            return;
        }
        int i10 = bundle.getInt(C5963j.f27041j);
        int i11 = bundle.getInt("requestId");
        C11839m.m70688i("CloudStorageManager", "requestId=" + i11 + ", --- TASK_NAME_ALBUM query album onResult retCode=" + i10);
        if (i10 == 0) {
            long j11 = bundle.getLong("photoTotalSize");
            long j12 = bundle.getLong("recycleTotalSize");
            if (j11 < 0) {
                j11 = 0;
            }
            if (j12 < 0) {
                j12 = 0;
            }
            j10 = j11 + j12;
            C11839m.m70688i("CloudStorageManager", "requestId=" + i11 + ", gallery space=" + j11 + " galleryDeleteSize = " + j12);
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestId=");
            sb2.append(i11);
            sb2.append(", onResult gallerySize endtime=");
            sb2.append(jCurrentTimeMillis);
            C11839m.m70688i("CloudStorageManager", sb2.toString());
            synchronized (this.f60255c) {
                this.f60263k.setGalleryUsedSize(j11);
                this.f60263k.setGalleryDeleteSize(j12);
                this.f60270r.m80159f(j11, j12);
            }
            this.f60265m.m74150f(PowerKitApplyUtil.GROUP_ALBUM, true);
            strM80222K = "space_result_success";
        } else {
            if (i10 == 3) {
                C11839m.m70689w("CloudStorageManager", "requestId=" + i11 + ", get gallery space INTFACE_FAIL_LOGOFF");
                C13612b.m81830Y(m80235Y());
                strM80222K = m80222K();
            } else {
                C11839m.m70688i("CloudStorageManager", "requestId=" + i11 + ", get gallery space failed");
                strM80222K = m80222K();
            }
            j10 = -1;
        }
        m80260v0("space_gallery", "space_operate_finish", strM80222K, String.valueOf(i11), j10);
        m80261w();
    }

    /* renamed from: p0 */
    public final void m80251p0() {
        C11839m.m70688i("CloudStorageManager", "queryQuotaInfoFailed");
        this.f60259g = true;
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
        intent.putExtra("result", 0);
        C13108a.m78878b(m80235Y()).m78881d(intent);
    }

    /* renamed from: q0 */
    public final void m80252q0() {
        C11839m.m70688i("CloudStorageManager", "queryQuotaInfoSuccess");
        m80257u();
        C1007b.m5980s().m6012c0();
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.QUERY_QUOTA_INFO_FINISHED");
        intent.putExtra("result", 1);
        C13108a.m78878b(m80235Y()).m78881d(intent);
    }

    /* renamed from: r0 */
    public void m80253r0() {
        m80254s0(false);
    }

    /* renamed from: s0 */
    public synchronized void m80254s0(boolean z10) {
        C11839m.m70688i("CloudStorageManager", "queryStorageInfoWithMultiTask");
        if (!this.f60259g) {
            C11839m.m70688i("CloudStorageManager", "query not finished");
            return;
        }
        this.f60259g = false;
        m80262w0();
        this.f60265m.m74147c();
        int iNextInt = this.f60268p.nextInt(10000);
        m80260v0("space_all", "space_operate_start", "", String.valueOf(iNextInt), -1L);
        AsyncTaskC13571v asyncTaskC13571vM81560b = AsyncTaskC13571v.m81560b(this.f60272t);
        AsyncTask.Status status = AsyncTask.Status.RUNNING;
        if (!status.equals(asyncTaskC13571vM81560b.getStatus())) {
            asyncTaskC13571vM81560b.m81563d(iNextInt);
            asyncTaskC13571vM81560b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        AsyncTaskC13570u asyncTaskC13570uM81556b = AsyncTaskC13570u.m81556b(m80235Y(), this.f60272t);
        if (!status.equals(asyncTaskC13570uM81556b.getStatus())) {
            asyncTaskC13570uM81556b.m81559d(iNextInt);
            asyncTaskC13570uM81556b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        boolean z11 = z10 && C13379p.m80310f().m80316g();
        AsyncTaskC13557h asyncTaskC13557hM81498b = AsyncTaskC13557h.m81498b(m80235Y(), this.f60272t);
        if (!status.equals(asyncTaskC13557hM81498b.getStatus())) {
            asyncTaskC13557hM81498b.m81503f(iNextInt);
            asyncTaskC13557hM81498b.m81502e(z11);
            asyncTaskC13557hM81498b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        AsyncTaskC13559j asyncTaskC13559jM81510b = AsyncTaskC13559j.m81510b(m80235Y(), this.f60272t);
        if (!status.equals(asyncTaskC13559jM81510b.getStatus())) {
            asyncTaskC13559jM81510b.m81513d(iNextInt);
            asyncTaskC13559jM81510b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        m80246k0(iNextInt);
        m80248m0();
    }

    /* renamed from: t */
    public final void m80255t(String str, String str2, String str3, String str4, Map<String, String> map) {
        map.put("space_module", str);
        map.put("space_operate", str2);
        map.put("space_result", str3);
        map.put("space_timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("space_request_id", str4);
    }

    /* renamed from: t0 */
    public void m80256t0(Messenger messenger) {
        C1008c.m6035v().m6049N(m80235Y(), messenger);
        m80260v0("space_structure", "space_operate_start", "", "", -1L);
    }

    /* renamed from: u */
    public final void m80257u() {
        if (this.f60263k == null) {
            C11839m.m70688i("CloudStorageManager", "storageInfo is null");
            return;
        }
        TotalStorageInfo totalInfo = this.f60263k.getTotalInfo();
        long usedSize = this.f60263k.getUsedSize() + this.f60263k.getGalleryUsedSize() + this.f60263k.getGalleryDeleteSize();
        ContentValues contentValues = new ContentValues();
        contentValues.put("usedSize", Long.valueOf(usedSize));
        C12299b.m73937s(contentValues);
        if (totalInfo != null) {
            totalInfo.setUsedSize(usedSize);
            long totalSize = totalInfo.getTotalSize() - usedSize;
            C11839m.m70688i("CloudStorageManager", "calculateUsedSize usedSize=" + usedSize + ",available=" + totalSize);
            if (totalSize < 0) {
                totalSize = 0;
            }
            totalInfo.setAvailableSize(totalSize);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("totalSize", Long.valueOf(totalInfo.getTotalSize()));
            C12299b.m73937s(contentValues2);
        }
    }

    /* renamed from: u0 */
    public final void m80258u0() {
        C11839m.m70688i("CloudStorageManager", "querySuccess");
        m80257u();
        C1007b.m5980s().m6012c0();
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.QUERY_STORAGE_FINISHED");
        intent.putExtra("result", 1);
        C13108a.m78878b(m80235Y()).m78881d(intent);
    }

    /* renamed from: v */
    public final boolean m80259v() {
        if (!this.f60260h || !this.f60262j || !this.f60261i) {
            return false;
        }
        m80243h0(1);
        C1007b.m5980s().m6006Z(this.f60271s);
        return true;
    }

    /* renamed from: v0 */
    public void m80260v0(String str, String str2, String str3, String str4, long j10) {
        HashMap map = new HashMap();
        m80255t(str, str2, str3, str4, map);
        map.put("cloud_size", C13843a.m83086h(C0213f.m1377a(), j10));
        map.put("gradeCode", C13452e.m80781L().m80790C());
        C0239x.m1671c().m1672a(map);
        C13622a.m81969o(C0213f.m1377a(), this.f60253a, map);
    }

    /* renamed from: w */
    public final void m80261w() {
        String str;
        C11839m.m70688i("CloudStorageManager", "checkTask:" + this.f60265m.f57082b.size());
        if (this.f60265m.m74146b()) {
            C11839m.m70688i("CloudStorageManager", "taskChecker.check true");
            this.f60259g = true;
            if (this.f60265m.m74149e()) {
                C11839m.m70688i("CloudStorageManager", "checkTask isSuccess true");
                m80258u0();
                str = "space_result_success";
            } else {
                C11839m.m70688i("CloudStorageManager", "checkTask isSuccess false");
                m80249n0();
                str = "space_result_failed";
            }
            m80260v0("space_all", "space_operate_finish", str, "", -1L);
            this.f60265m.m74147c();
        }
    }

    /* renamed from: w0 */
    public void m80262w0() {
        synchronized (this.f60258f) {
            m80266y0(false);
        }
        synchronized (this.f60257e) {
            m80264x0(false);
        }
    }

    /* renamed from: x */
    public final void m80263x(int i10, String str) {
        String str2;
        C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", checkTask moduleName=" + str);
        if (this.f60265m.m74146b()) {
            C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", taskChecker.check true");
            this.f60259g = true;
            if (this.f60265m.m74149e()) {
                C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", checkTask isSuccess true");
                m80258u0();
                str2 = "space_result_success";
            } else {
                C11839m.m70688i("CloudStorageManager", "requestId=" + i10 + ", checkTask isSuccess false");
                m80249n0();
                str2 = "space_result_failed";
            }
            m80260v0("space_all", "space_operate_finish", str2, String.valueOf(i10), -1L);
            this.f60265m.m74147c();
        }
    }

    /* renamed from: x0 */
    public void m80264x0(boolean z10) {
        this.f60266n = z10;
    }

    /* renamed from: y */
    public void m80265y() {
        C11839m.m70688i("CloudStorageManager", "clear");
        this.f60259g = true;
    }

    /* renamed from: y0 */
    public void m80266y0(boolean z10) {
        this.f60267o = z10;
    }

    /* renamed from: z */
    public void m80267z() {
        this.f60269q = null;
    }

    /* renamed from: z0 */
    public void m80268z0(BackupStorageInfo backupStorageInfo, int i10) {
        long backupUsedSize;
        String str;
        C11839m.m70687e("CloudStorageManager", "updateBackupSizeFinish");
        if (backupStorageInfo == null) {
            C11839m.m70687e("CloudStorageManager", "backupSize query failed");
            this.f60265m.m74150f(CloudBackupConstant.Command.PMS_CMD_BACKUP, false);
            backupUsedSize = -1;
            m80242g0(-1L);
            str = "space_result_failed";
        } else {
            this.f60265m.m74150f(CloudBackupConstant.Command.PMS_CMD_BACKUP, true);
            backupUsedSize = backupStorageInfo.getBackupUsedSize();
            m80242g0(backupUsedSize);
            this.f60263k.setBackupDetails(backupStorageInfo.getBackupDetails());
            this.f60263k.setOtherDeviceDetails(backupStorageInfo.getOtherDeviceBackupDetails());
            this.f60263k.setCurrentDeviceBackupDetails(backupStorageInfo.getCurrentDeviceBackupDetails());
            this.f60263k.setBackupCacheInfo(C13379p.m80310f().m80313c(backupStorageInfo));
            C13379p.m80310f().m80311a(backupStorageInfo);
            str = "space_result_success";
        }
        m80260v0("space_backup", "space_operate_finish", str, String.valueOf(i10), backupUsedSize);
    }

    public C13368e() {
        this.f60254b = new ArrayList();
        this.f60255c = new Object();
        this.f60256d = new Object();
        this.f60257e = new Object();
        this.f60258f = new Object();
        this.f60259g = true;
        this.f60260h = false;
        this.f60261i = false;
        this.f60262j = false;
        this.f60263k = new StorageInfo();
        this.f60266n = false;
        this.f60267o = false;
        this.f60268p = new Random();
        this.f60270r = new C13364a();
        this.f60271s = new b();
        this.f60272t = new c();
        this.f60273u = new d();
        m80239c0();
        m80238b0();
    }
}
