package com.huawei.android.hicloud.syncdrive.util;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Environment;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Base64;
import bd.C1164a;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.space.QuotaUsedInfoRsp;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.sync.jobscheduler.ContactKeepLockJobService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.syncutil.C2985n;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.About;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Assets;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.Locks;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.util.SafeBase64;
import fk.C9720a;
import fk.C9721b;
import fk.C9722c;
import gp.C10028c;
import hk.C10278a;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import je.C10812z;
import md.C11440c;
import org.json.JSONArray;
import org.json.JSONObject;
import p012ab.C0087b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p020ap.C1008c;
import p237du.C9310c;
import p255ed.C9453i;
import p260ek.C9499a;
import p283fa.C9679b;
import p286fd.C9683a;
import p365ic.C10466a;
import p514o9.C11839m;
import p616rk.C12515a;
import p652t9.EnumC12999a;
import p675uc.C13153a;
import p709vj.C13452e;
import tc.C13007b;
import tm.C13040c;
import to.C13049a;

/* loaded from: classes3.dex */
public class DriveSyncUtil {

    /* renamed from: a */
    public static int f13039a;

    /* renamed from: b */
    public static final ArrayList<String> f13040b = new C2991a();

    /* renamed from: c */
    public static final ArrayList<String> f13041c = new C2992b();

    /* renamed from: d */
    public static final ArrayList<String> f13042d = new C2993c();

    /* renamed from: e */
    public static final ArrayList<String> f13043e = new C2994d();

    /* renamed from: f */
    public static final ArrayList<String> f13044f = new C2995e();

    /* renamed from: g */
    public static final Map<String, List<String>> f13045g = Collections.unmodifiableMap(new C2996f());

    /* renamed from: h */
    public static final Map<String, String> f13046h = Collections.unmodifiableMap(new C2997g());

    /* renamed from: i */
    public static final Map<String, String> f13047i = Collections.unmodifiableMap(new C2998h());

    /* renamed from: j */
    public static final Map<String, String> f13048j = new HashMap(10);

    /* renamed from: k */
    public static final Map<String, String> f13049k = new HashMap(10);

    /* renamed from: l */
    public static final Map<String, String> f13050l = Collections.unmodifiableMap(new C2999i());

    /* renamed from: m */
    public static final Map<String, String> f13051m = new HashMap(10);

    public interface CloseSwitchScenes {
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$a */
    public class C2991a extends ArrayList<String> {
        public C2991a() {
            add("com.huawei.contacts.sync");
            add("com.hihonor.contacts.sync");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$b */
    public class C2992b extends ArrayList<String> {
        public C2992b() {
            add(NextRestoreConstants.PKG_NAME_MEMO);
            add("com.example.android.notepad");
            add("com.hihonor.notepad");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$c */
    public class C2993c extends ArrayList<String> {
        public C2993c() {
            add("com.android.providers.calendar");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$d */
    public class C2994d extends ArrayList<String> {
        public C2994d() {
            add(NextRestoreConstants.PKG_NAME_GALLERY_DATA);
            add(NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D);
            add("com.hihonor.photos");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$e */
    public class C2995e extends ArrayList<String> {
        public C2995e() {
            add(Constants.HW_BROWSER_PACKAGE);
            add("com.android.browser");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$f */
    public class C2996f extends HashMap<String, List<String>> {
        public C2996f() {
            put("addressbook", DriveSyncUtil.f13040b);
            put("notepad", DriveSyncUtil.f13041c);
            put("calendar", DriveSyncUtil.f13042d);
            put("atlas", DriveSyncUtil.f13043e);
            put("browser", DriveSyncUtil.f13044f);
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$g */
    public class C2997g extends HashMap<String, String> {
        public C2997g() {
            put("addressbook", "1000");
            put("notepad", "1001");
            put("calendar", "1002");
            put("atlas", "1003");
            put("wlan", FaqConstants.CHANNEL_HICARE);
            put("browser", "1005");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$h */
    public class C2998h extends HashMap<String, String> {
        public C2998h() {
            put("1000", "addressbook");
            put("1001", "notepad");
            put("1002", "calendar");
            put("1003", "atlas");
            put(FaqConstants.CHANNEL_HICARE, "wlan");
            put("1005", "browser");
        }
    }

    /* renamed from: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil$i */
    public class C2999i extends HashMap<String, String> {
        public C2999i() {
            put("addressbook", DownloadTaskBaseCallable.DOWNLOAD_POOL_SHUTDOWN);
            put("calendar", "14");
            put("notepad", "15");
            put("wlan", "16");
            put("browser", "17");
            put("atlas", "18");
        }
    }

    /* renamed from: A */
    public static String m17956A() throws C9722c {
        if (!C10028c.m62182c0().m62221H1()) {
            C11839m.m70689w("DriveSyncUtil", "start get cloud sync url empty as terms is not confirmed ");
            throw new C9722c(2232, "getCloudSync terms is not confirmed", "", "get_cloud_sync_drive_domain");
        }
        try {
            C11839m.m70686d("DriveSyncUtil", "start get cloud sync url");
            return C13040c.m78609F().m78670w();
        } catch (C9721b e10) {
            C11839m.m70687e("DriveSyncUtil", "syncV2 get cloud sync url error ," + e10.toString());
            throw new C9722c(2233, "getCloudSync get cloud sync url error", "", "get_cloud_sync_drive_domain");
        }
    }

    /* renamed from: B */
    public static Set<String> m17957B(About about) {
        HashSet hashSet = new HashSet();
        List<String> kinds = about.getKinds();
        if (kinds != null) {
            hashSet = new HashSet(kinds.size());
            for (String str : kinds) {
                hashSet.add(str);
                C11839m.m70686d("DriveSyncUtil", "abouts, kind = " + str);
            }
        }
        return hashSet;
    }

    /* renamed from: C */
    public static String m17958C(String str) {
        Map<String, String> map = f13046h;
        if (map.get(str) != null) {
            return map.get(str);
        }
        Map<String, String> map2 = f13048j;
        if (map2.get(str) != null) {
            return map2.get(str);
        }
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
        if (serviceById == null || serviceById.getDatabaseId() == null) {
            return "";
        }
        String databaseId = serviceById.getDatabaseId();
        map2.put(str, databaseId);
        f13049k.put(databaseId, str);
        return databaseId;
    }

    /* renamed from: D */
    public static String m17959D(String str) throws C9722c {
        String strM17958C = m17958C(str);
        if (TextUtils.isEmpty(strM17958C)) {
            throw new C9722c(2212, "syncV2 get database null", str, "");
        }
        return strM17958C;
    }

    /* renamed from: E */
    public static int m17960E() {
        int i10;
        int i11 = f13039a;
        if (i11 < 6 && (i10 = 6 - i11) > 2) {
            return i10;
        }
        return 2;
    }

    /* renamed from: F */
    public static int m17961F(IOException iOException) {
        if (iOException instanceof C4616s) {
            return C0241z.m1685c(m17980Y((C4616s) iOException));
        }
        return 5;
    }

    /* renamed from: G */
    public static String m17962G(String str) {
        Map<String, String> map = f13050l;
        if (map.get(str) != null) {
            return map.get(str);
        }
        Map<String, String> map2 = f13051m;
        if (map2.get(str) != null) {
            return map2.get(str);
        }
        SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
        if (serviceById == null || serviceById.getKeyType() == null) {
            return "";
        }
        String keyType = serviceById.getKeyType();
        map2.put(str, keyType);
        return keyType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:167:0x00a2, code lost:
    
        p514o9.C11839m.m70689w("DriveSyncUtil", "lost result is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00a7, code lost:
    
        p514o9.C11839m.m70688i("DriveSyncUtil", "syncV2 Refund result: dataType = " + r21 + ", original = " + r11.size() + ", avalibale = " + r12.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00d1, code lost:
    
        if (r11.size() <= 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00d3, code lost:
    
        r9 = new java.util.LinkedHashMap();
        r9.put("originalLostSize", java.lang.String.valueOf(r11.size()));
        r9.put(r18, java.lang.String.valueOf(r12.size()));
        je.C10812z.m65847p(r24, r20, r21, 0, r16, "03001", "getLostList", r23, r9, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0103, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x011f, code lost:
    
        p514o9.C11839m.m70689w("DriveSyncUtil", "lost changes is null, update cursor and time");
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x012c, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.getNewStartCursor()) != false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x012e, code lost:
    
        r17.m78217F0(r20, r21, r4.getNewStartCursor());
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0137, code lost:
    
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x013e, code lost:
    
        com.huawei.android.hicloud.sync.syncutil.C2985n.m17942l(r1, r20, r21);
        com.huawei.android.hicloud.sync.syncutil.C2985n.m17943m(r1, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0144, code lost:
    
        p514o9.C11839m.m70688i("DriveSyncUtil", "syncV2 Refund result: dataType = " + r21 + ", original = " + r11.size() + ", avalibale = " + r12.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x016e, code lost:
    
        if (r11.size() <= 0) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0170, code lost:
    
        r9 = new java.util.LinkedHashMap();
        r9.put("originalLostSize", java.lang.String.valueOf(r11.size()));
        r9.put(r13, java.lang.String.valueOf(r12.size()));
        je.C10812z.m65847p(r24, r20, r21, 0, r16, "03001", "getLostList", r23, r9, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x019e, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x019f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x01a3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x023d, code lost:
    
        if (r12.size() > 0) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x023f, code lost:
    
        p514o9.C11839m.m70688i("DriveSyncUtil", "no data refund, update lost cusor");
        com.huawei.android.hicloud.sync.syncutil.C2985n.m17942l(r24, r20, r21);
        com.huawei.android.hicloud.sync.syncutil.C2985n.m17943m(r24, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x024a, code lost:
    
        p514o9.C11839m.m70688i("DriveSyncUtil", "syncV2 Refund result: dataType = " + r21 + ", original = " + r11.size() + ", avalibale = " + r12.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0274, code lost:
    
        if (r11.size() <= 0) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0276, code lost:
    
        r9 = new java.util.LinkedHashMap();
        r9.put("originalLostSize", java.lang.String.valueOf(r11.size()));
        r9.put(r13, java.lang.String.valueOf(r12.size()));
        r7 = "getLostList";
        r10 = false;
        r6 = "03001";
        r1 = r24;
        r2 = r20;
        r3 = r21;
        r4 = 0;
        r5 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x037f  */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.huawei.android.hicloud.syncdrive.cloudsync.model.Record> m17963H(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, android.content.Context r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 941
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil.m17963H(java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.content.Context):java.util.List");
    }

    /* renamed from: I */
    public static UserKeyObject m17964I(String str, KeyChain keyChain) throws C9721b {
        String id2 = keyChain.getId();
        C0087b c0087b = new C0087b(C9679b.m60452d().m60455e());
        String strM17962G = m17962G(str);
        if (TextUtils.isEmpty(strM17962G)) {
            C11839m.m70687e("DriveSyncUtil", "syncV2 error getKeyType null, syncType: " + str);
            return null;
        }
        UserKeyObject userKeyObjectM680c = c0087b.m680c("", Integer.parseInt(strM17962G), UserKeyBaseReq.KEY_TYPE_AES_128);
        if (TextUtils.isEmpty(id2) || id2.equals(userKeyObjectM680c.getUserKeyGuid())) {
            return userKeyObjectM680c;
        }
        UserKeyObject userKeyObjectM681d = c0087b.m681d("", Integer.parseInt(strM17962G), UserKeyBaseReq.KEY_TYPE_AES_256);
        if (id2.equals(userKeyObjectM681d.getUserKeyGuid())) {
            return userKeyObjectM681d;
        }
        UserKeyObject syncUser = UserKeyUtils.getInstance().getSyncUser(Integer.parseInt(strM17962G), "");
        if (id2.equals(userKeyObjectM681d.getUserKeyGuid())) {
            return syncUser;
        }
        C11839m.m70689w("DriveSyncUtil", "no match userKey.");
        return null;
    }

    /* renamed from: J */
    public static String m17965J(String str, String str2) {
        if ("wlan".equals(str)) {
            return "com.huawei.hidisk";
        }
        String str3 = C10812z.m65833b(str2).get("packageName");
        return !TextUtils.isEmpty(str3) ? str3 : "addressbook".equals(str) ? "com.huawei.hidisk" : "";
    }

    /* renamed from: K */
    public static QuotaUsedInfoRsp m17966K(Context context, String str, String str2, String str3, String str4) {
        LinkedHashMap<String, String> linkedHashMap;
        if (TextUtils.isEmpty(str2)) {
            C11839m.m70689w("DriveSyncUtil", "quotaRequest is null");
            return null;
        }
        try {
            try {
                try {
                    String strM78761z = new C13049a(EnumC12999a.CLOUD_SYNC, str4).m78761z(str3, str2);
                    C11839m.m70686d("DriveSyncUtil", "QueryPimNumBaseTask response=" + strM78761z);
                    QuotaUsedInfoRsp quotaUsedInfoRsp = (QuotaUsedInfoRsp) new Gson().fromJson(strM78761z, QuotaUsedInfoRsp.class);
                    if (quotaUsedInfoRsp == null) {
                        C11839m.m70689w("DriveSyncUtil", "quotaRsp is null");
                        return null;
                    }
                    int retCode = quotaUsedInfoRsp.getRetCode();
                    String retDesc = quotaUsedInfoRsp.getRetDesc();
                    String string = Arrays.toString(quotaUsedInfoRsp.getQuotaDetails());
                    LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("extra", string);
                    C1008c.m6035v().m6055T(context, str, retCode, retDesc, "03001", "get_cloud_struct_num", str4, linkedHashMap2);
                    return quotaUsedInfoRsp;
                } catch (C9721b e10) {
                    C11839m.m70687e("DriveSyncUtil", "QueryPimNumBaseTask exception:" + e10.toString());
                    linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put("extra", "");
                    C1008c.m6035v().m6055T(context, str, 0, "", "03001", "get_cloud_struct_num", str4, linkedHashMap);
                    return null;
                }
            } catch (JsonSyntaxException e11) {
                C11839m.m70687e("DriveSyncUtil", "QueryPimNumBaseTask JsonSyntaxEx:" + e11.toString());
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("extra", "");
                C1008c.m6035v().m6055T(context, str, 0, "", "03001", "get_cloud_struct_num", str4, linkedHashMap);
                return null;
            }
        } finally {
            LinkedHashMap<String, String> linkedHashMap3 = new LinkedHashMap<>();
            linkedHashMap3.put("extra", "");
            C1008c.m6035v().m6055T(context, str, 0, "", "03001", "get_cloud_struct_num", str4, linkedHashMap3);
        }
    }

    /* renamed from: L */
    public static String m17967L(Context context) {
        String[] packagesForUid;
        if (context == null) {
            return "";
        }
        try {
            String strM1256g0 = C0209d.m1256g0(context, Binder.getCallingPid());
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (packagesForUid = packageManager.getPackagesForUid(Binder.getCallingUid())) == null || packagesForUid.length <= 0) ? "" : Arrays.toString(packagesForUid).contains(strM1256g0) ? strM1256g0 : "";
        } catch (Exception e10) {
            C11839m.m70687e("DriveSyncUtil", "getRealCallingPackageName error: " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: M */
    public static File m17968M() {
        Context contextM1377a = C0213f.m1377a();
        return ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? contextM1377a.getExternalFilesDir("") : contextM1377a.getFilesDir();
    }

    /* renamed from: N */
    public static String m17969N(String str) {
        Map<String, String> map = f13047i;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        Map<String, String> map2 = f13049k;
        if (map2.containsKey(str)) {
            return map2.get(str);
        }
        SyncConfigService serviceByDatabaseId = new SyncConfigOperator().getServiceByDatabaseId(str);
        if (serviceByDatabaseId == null || serviceByDatabaseId.getDatabaseId() == null) {
            return "";
        }
        String id2 = serviceByDatabaseId.getId();
        f13048j.put(id2, str);
        map2.put(str, id2);
        return id2;
    }

    /* renamed from: O */
    public static String m17970O(String str) {
        String str2 = C10812z.m65833b(str).get("appId");
        return !TextUtils.isEmpty(str2) ? str2 : "";
    }

    /* renamed from: P */
    public static String m17971P(String str, String str2) {
        if ("wlan".equals(str)) {
            return "16.0.0.300";
        }
        String str3 = C10812z.m65833b(str2).get("versionName");
        return !TextUtils.isEmpty(str3) ? str3 : "addressbook".equals(str) ? "16.0.0.300" : "";
    }

    /* renamed from: Q */
    public static boolean m17972Q(Exception exc) {
        return m17975T(403, "4031", exc);
    }

    /* renamed from: R */
    public static boolean m17973R(Context context, String str) {
        C9453i c9453iM7268d;
        C13007b c13007bM78205Y;
        String strM78296y;
        try {
            c9453iM7268d = C1164a.m7265f().m7268d(str);
            c13007bM78205Y = C13007b.m78205Y(context);
            strM78296y = c13007bM78205Y.m78296y(str);
        } catch (Exception e10) {
            C11839m.m70688i("DriveSyncUtil", "isFirstMigrateV2 error: " + e10.getMessage());
        }
        if ("V2.0".equalsIgnoreCase(strM78296y) && 1 == c13007bM78205Y.m78246X(str) && System.currentTimeMillis() - c13007bM78205Y.m78216F(str) < 86400000) {
            C11839m.m70686d("DriveSyncUtil", "syncV2 syncType: " + str + " in 24 hours, no need query dataVersion");
            return false;
        }
        About aboutExecute = c9453iM7268d.m59248g().get(m17959D(str)).setFields2("dataVersion,kinds,maxBatchNumber,status").execute();
        C11839m.m70686d("DriveSyncUtil", "syncV2 isFirstMigrateV2 about syncType: " + str + ", run: " + aboutExecute.toString());
        String dataVersion = aboutExecute.getDataVersion();
        int iIntValue = aboutExecute.getStatus().getV2cut().intValue();
        if ("V2.0".equalsIgnoreCase(dataVersion) && 1 == iIntValue && !CloudSyncUtil.m15955I(context, str) && (TextUtils.isEmpty(strM78296y) || !strM78296y.equals(dataVersion))) {
            C11839m.m70688i("DriveSyncUtil", "syncV2 push setFirstMigrateV2.");
            c13007bM78205Y.m78281q0(str, false);
            return true;
        }
        return false;
    }

    /* renamed from: S */
    public static boolean m17974S(int i10) {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("DriveSyncUtil", "jobscheduler is null");
            return false;
        }
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: T */
    public static boolean m17975T(int i10, String str, Exception exc) {
        JSONArray jSONArrayM59433a;
        if (!(exc instanceof C4616s)) {
            return false;
        }
        C4616s c4616s = (C4616s) exc;
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return false;
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d) || C9499a.m59434b(strM59436d, "code") != i10 || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null) {
            return false;
        }
        String strM59436d2 = C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        if (strM59436d2.length() > str.length()) {
            strM59436d2 = strM59436d2.substring(strM59436d2.length() - str.length());
        }
        return str.equals(strM59436d2);
    }

    /* renamed from: U */
    public static boolean m17976U(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strValueOf = String.valueOf(i10);
        if (strValueOf.length() > str.length()) {
            strValueOf = strValueOf.substring(strValueOf.length() - str.length());
        }
        return str.equals(strValueOf);
    }

    /* renamed from: V */
    public static boolean m17977V(String str) {
        return SyncLogicService.getSdkVersion(str) >= 101;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0197 A[Catch: all -> 0x01aa, TRY_ENTER, TryCatch #2 {all -> 0x01aa, blocks: (B:148:0x0197, B:151:0x01b2), top: B:158:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01b2 A[Catch: all -> 0x01aa, TRY_LEAVE, TryCatch #2 {all -> 0x01aa, blocks: (B:148:0x0197, B:151:0x01b2), top: B:158:0x0195 }] */
    /* renamed from: W */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m17978W(android.content.Context r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil.m17978W(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    /* renamed from: X */
    public static void m17979X(String str, String str2, String str3, String str4, String str5, String str6, Asset asset) throws Throwable {
        Object obj;
        Object obj2;
        LinkedHashMap linkedHashMap;
        String str7;
        String message;
        Context contextM1377a;
        boolean z10;
        String str8;
        String str9;
        int i10;
        String str10;
        String str11;
        String str12;
        Assets.Revisions.Update updateAddHeader;
        StringBuilder sb2;
        if (!C2985n.m17935e(str2)) {
            C11839m.m70689w("DriveSyncUtil", "no need notifySyncLost, not support");
            return;
        }
        String str13 = "";
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i11 = 0;
        try {
        } catch (Exception e10) {
            e = e10;
            obj = "usageName";
            obj2 = "assetId";
            linkedHashMap = linkedHashMap2;
            str7 = "DriveSyncUtil";
        } catch (Throwable th2) {
            th = th2;
            obj = "usageName";
            obj2 = "assetId";
            linkedHashMap = linkedHashMap2;
        }
        if (asset.getStatus() != null && C2985n.m17937g(asset.getStatus().intValue())) {
            C11839m.m70689w("DriveSyncUtil", "no need repeat notifySyncLost, assetId = " + asset.getId());
            linkedHashMap2.put("assetStatus", String.valueOf(2));
            linkedHashMap2.put("recordId", str5);
            linkedHashMap2.put("assetId", asset.getId());
            linkedHashMap2.put("usageName", str4);
            linkedHashMap2.putAll(C10812z.m65833b(str6));
            C10812z.m65847p(C0213f.m1377a(), str2, str3, 0, "", "03001", "sync_notify_lost", str, linkedHashMap2, false);
            return;
        }
        C9453i c9453iM7268d = C1164a.m7265f().m7268d(str2);
        m18002l(str2, "sync_notify_lost");
        String strM17959D = m17959D(str2);
        Asset asset2 = new Asset();
        asset2.setId(asset.getId());
        asset2.setStatus(2);
        asset2.setVersionId(asset.getVersionId());
        linkedHashMap = linkedHashMap2;
        str7 = "DriveSyncUtil";
        try {
            updateAddHeader = c9453iM7268d.m59242a().revisions().update(strM17959D, str3, str5, asset.getId(), asset.getVersionId(), "attributes,cipher,createdTime,id,mimeType,modifiedTime,resource,state,version,versionId,status", asset2).addHeader("x-hw-lock", (Object) C13007b.m78205Y(C0213f.m1377a()).m78224J(str2, str6));
            try {
                m17994g(updateAddHeader.getHeaders(), str, str2, str6);
                updateAddHeader.execute();
                sb2 = new StringBuilder();
                sb2.append("notify lost success, dataType = ");
            } catch (Exception e11) {
                e = e11;
                obj2 = "assetId";
                obj = "usageName";
                try {
                    message = e.getMessage();
                    try {
                        C11839m.m70687e(str7, "notify lost error, fileName = " + str4 + ", msg = " + e.getMessage());
                        linkedHashMap.put("recordId", str5);
                        linkedHashMap.put(obj2, asset.getId());
                        linkedHashMap.put(obj, str4);
                        linkedHashMap.putAll(C10812z.m65833b(str6));
                        contextM1377a = C0213f.m1377a();
                        z10 = false;
                        str8 = str2;
                        str9 = str3;
                        i10 = 5;
                        str10 = message;
                        str11 = "03001";
                        str12 = "sync_notify_lost";
                        C10812z.m65847p(contextM1377a, str8, str9, i10, str10, str11, str12, str, linkedHashMap, z10);
                    } catch (Throwable th3) {
                        th = th3;
                        i11 = 5;
                        str13 = message;
                        linkedHashMap.put("recordId", str5);
                        linkedHashMap.put(obj2, asset.getId());
                        linkedHashMap.put(obj, str4);
                        linkedHashMap.putAll(C10812z.m65833b(str6));
                        C10812z.m65847p(C0213f.m1377a(), str2, str3, i11, str13, "03001", "sync_notify_lost", str, linkedHashMap, false);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i11 = 5;
                }
            } catch (Throwable th5) {
                th = th5;
                obj2 = "assetId";
                obj = "usageName";
                linkedHashMap.put("recordId", str5);
                linkedHashMap.put(obj2, asset.getId());
                linkedHashMap.put(obj, str4);
                linkedHashMap.putAll(C10812z.m65833b(str6));
                C10812z.m65847p(C0213f.m1377a(), str2, str3, i11, str13, "03001", "sync_notify_lost", str, linkedHashMap, false);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            sb2.append(str3);
            sb2.append(", fileName = ");
            sb2.append(str4);
            C11839m.m70688i(str7, sb2.toString());
            m17985b0(1, updateAddHeader.getLastResponseHeaders());
            linkedHashMap.put("recordId", str5);
            linkedHashMap.put("assetId", asset.getId());
            linkedHashMap.put("usageName", str4);
            linkedHashMap.putAll(C10812z.m65833b(str6));
            contextM1377a = C0213f.m1377a();
            str12 = "sync_notify_lost";
            z10 = false;
            str11 = "03001";
            str8 = str2;
            str9 = str3;
            i10 = 0;
            str10 = "";
        } catch (Exception e13) {
            e = e13;
            obj2 = "assetId";
            obj = "usageName";
            message = e.getMessage();
            C11839m.m70687e(str7, "notify lost error, fileName = " + str4 + ", msg = " + e.getMessage());
            linkedHashMap.put("recordId", str5);
            linkedHashMap.put(obj2, asset.getId());
            linkedHashMap.put(obj, str4);
            linkedHashMap.putAll(C10812z.m65833b(str6));
            contextM1377a = C0213f.m1377a();
            z10 = false;
            str8 = str2;
            str9 = str3;
            i10 = 5;
            str10 = message;
            str11 = "03001";
            str12 = "sync_notify_lost";
            C10812z.m65847p(contextM1377a, str8, str9, i10, str10, str11, str12, str, linkedHashMap, z10);
        } catch (Throwable th7) {
            th = th7;
            obj2 = "assetId";
            obj = "usageName";
            linkedHashMap.put("recordId", str5);
            linkedHashMap.put(obj2, asset.getId());
            linkedHashMap.put(obj, str4);
            linkedHashMap.putAll(C10812z.m65833b(str6));
            C10812z.m65847p(C0213f.m1377a(), str2, str3, i11, str13, "03001", "sync_notify_lost", str, linkedHashMap, false);
            throw th;
        }
        C10812z.m65847p(contextM1377a, str8, str9, i10, str10, str11, str12, str, linkedHashMap, z10);
    }

    /* renamed from: Y */
    public static String m17980Y(C4616s c4616s) {
        JSONArray jSONArrayM59433a;
        try {
            if (TextUtils.isEmpty(c4616s.m28319c())) {
                return "1";
            }
            String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
            return (TextUtils.isEmpty(strM59436d) || (jSONArrayM59433a = C9499a.m59433a(strM59436d, "errorDetail")) == null || jSONArrayM59433a.optJSONObject(0) == null) ? "1" : C9499a.m59436d(jSONArrayM59433a.optJSONObject(0).toString(), AddressConstants.Extras.EXTRA_NAME_ERR_CODE);
        } catch (Exception e10) {
            C11839m.m70687e("DriveSyncUtil", "parseErrorCode error : " + e10.toString());
            return "1";
        }
    }

    /* renamed from: Z */
    public static void m17981Z(Context context, String str, About about) {
        String dataVersion = about.getDataVersion();
        int iIntValue = about.getStatus().getV2cut().intValue();
        Set<String> setM17957B = m17957B(about);
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        if (setM17957B.size() > 0) {
            c13007bM78205Y.m78229L0(str, setM17957B);
        }
        c13007bM78205Y.m78273m0(str, dataVersion);
        c13007bM78205Y.m78239Q0(str, iIntValue);
        if (about.getMaxBatchNumber() != null) {
            c13007bM78205Y.m78211C0(str, about.getMaxBatchNumber().intValue());
        }
        c13007bM78205Y.m78295x0(str, System.currentTimeMillis());
    }

    /* renamed from: a0 */
    public static void m17983a0(Context context, String str, About about) {
        Set<String> setM17957B = m17957B(about);
        if (setM17957B.size() > 0) {
            C13007b c13007bM78205Y = C13007b.m78205Y(context);
            Iterator<String> it = setM17957B.iterator();
            while (it.hasNext()) {
                c13007bM78205Y.m78279p0(str, it.next(), true);
            }
        }
    }

    /* renamed from: b0 */
    public static void m17985b0(int i10, C4609l c4609l) {
        if (c4609l != null) {
            String strM28237v = c4609l.m28237v("x-hw-quicswitch");
            C11839m.m70688i("DriveSyncUtil", "quicType = " + i10 + " , isUseQuic = " + strM28237v);
            if (i10 == 1) {
                C13007b.m78205Y(C0213f.m1377a()).m78237P0(C0241z.m1685c(strM28237v) == 1);
            } else if (i10 == 2) {
                C13007b.m78205Y(C0213f.m1377a()).m78277o0(C0241z.m1685c(strM28237v) == 1);
            }
        }
    }

    /* renamed from: c0 */
    public static void m17987c0(String str, long j10, String str2, String str3, String str4) {
        C11839m.m70688i("DriveSyncUtil", "syncV2 keepLockV2 registerScheduler lockInterval:" + j10);
        if (m17974S(FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE)) {
            C11839m.m70688i("DriveSyncUtil", "ContactKeepLock JobServiceOn");
            return;
        }
        C11839m.m70688i("DriveSyncUtil", "syncV2 keepLockV2 register do job");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("DriveSyncUtil", "jobscheduler is null");
            return;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("syncType", str);
        persistableBundle.putString("sessionId", str2);
        persistableBundle.putString("callingPackageName", str3);
        persistableBundle.putString("traceId", str4);
        jobScheduler.schedule(new JobInfo.Builder(FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, new ComponentName(C0213f.m1377a(), (Class<?>) ContactKeepLockJobService.class)).setMinimumLatency(j10 * 1000).setRequiredNetworkType(1).setOverrideDeadline(600000L).setPersisted(true).setExtras(persistableBundle).build());
    }

    /* renamed from: d0 */
    public static void m17989d0(int i10) {
        if (i10 == 0) {
            return;
        }
        int i11 = f13039a;
        if (i11 <= 2) {
            f13039a = 0;
        } else {
            f13039a = i11 - i10;
        }
    }

    /* renamed from: e0 */
    public static void m17991e0(Context context, String str, String str2, String str3) {
        String str4 = "netWorkStatus = " + (C0209d.m1254f2(context) ? C6661f.f30885g : C0209d.m1150A1(context) ? "netWork" : "noNetWork") + ", isCharging = " + CloudSyncUtil.m15941B(context) + ", isScreenOn = " + CloudSyncUtil.m15967O(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("syncInfo", str4);
        linkedHashMap.putAll(C10812z.m65833b(str2));
        C10812z.m65846o(context, str, 0, "", "03001", "local_device_status", str3, linkedHashMap, false);
    }

    /* renamed from: f */
    public static void m17992f(Context context, String str, String str2, C4609l c4609l) {
        String strM78230M = C13007b.m78205Y(context).m78230M(str2);
        if (TextUtils.isEmpty(strM78230M)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("prepareTraceId", strM78230M);
            jSONObject.putOpt("traceId", str);
            c4609l.set("x-hw-context", jSONObject.toString());
        } catch (Exception e10) {
            C11839m.m70687e("DriveSyncUtil", "addDeleteContextHeader error " + e10.getMessage());
        }
    }

    /* renamed from: f0 */
    public static void m17993f0(String str, int i10, String str2, String str3, String str4) {
        if (i10 < 0) {
            C11839m.m70689w("DriveSyncUtil", "syncV2 keepLockV2 scheduleKeepLock error: mInterval < 0");
            return;
        }
        C11839m.m70688i("DriveSyncUtil", "syncV2 keepLockV2 schedule syncType: " + str + " interval: " + i10);
        m17999i0();
        m17987c0(str, (long) i10, str2, str3, str4);
    }

    /* renamed from: g */
    public static void m17994g(C4609l c4609l, String str, String str2, String str3) {
        c4609l.set("x-hw-trace-id", str).set("x-hw-3rdapp-packagename", m17965J(str2, str3)).set("x-hw-3rdapp-version", m17971P(str2, str3)).set("x-hw-thinsdkapp-version", m17971P(str2, str3));
        if (TextUtils.isEmpty(m17970O(str3))) {
            return;
        }
        c4609l.set("x-hw-3rdapp-appid", m17970O(str3));
    }

    /* renamed from: g0 */
    public static String m17995g0(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return "";
        }
        if (set.size() == 1) {
            return set.iterator().next();
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(",");
        }
        return sb2.toString().substring(0, sb2.toString().length() - 1);
    }

    /* renamed from: h */
    public static void m17996h(int i10) {
        f13039a += i10;
    }

    /* renamed from: h0 */
    public static void m17997h0(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C12515a.m75110o().m75175e(new C9683a(context, arrayList, str2, str3), false);
    }

    /* renamed from: i */
    public static List<String> m17998i(String str, List<String> list) throws Throwable {
        String[] applications;
        ArrayList arrayList = new ArrayList(list);
        if (TextUtils.equals(str, "notepad")) {
            SyncConfigService serviceById = new SyncConfigOperator().getServiceById(NotifyUtil.HI_NOTE_SYNC_TYPE);
            if (serviceById != null && (applications = serviceById.getApplications()) != null) {
                arrayList.addAll(Arrays.asList(applications));
            }
        } else if (TextUtils.equals(str, NotifyUtil.HI_NOTE_SYNC_TYPE)) {
            arrayList.add(NextRestoreConstants.PKG_NAME_MEMO);
            arrayList.add("com.example.android.notepad");
        }
        return arrayList;
    }

    /* renamed from: i0 */
    public static void m17999i0() {
        C11839m.m70688i("DriveSyncUtil", "syncV2 keepLockV2 unRegisterScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("DriveSyncUtil", "jobscheduler is null");
        } else {
            jobScheduler.cancel(FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE);
        }
    }

    /* renamed from: j */
    public static String m18000j(int i10) {
        String strValueOf = String.valueOf(i10);
        Map<String, String> map = f13047i;
        if (map.containsKey(strValueOf)) {
            return map.get(strValueOf);
        }
        Map<String, String> map2 = f13049k;
        if (map2.containsKey(strValueOf)) {
            return map2.get(strValueOf);
        }
        SyncConfigService serviceByDatabaseId = new SyncConfigOperator().getServiceByDatabaseId(strValueOf);
        if (serviceByDatabaseId == null || serviceByDatabaseId.getDatabaseId() == null) {
            return "";
        }
        String id2 = serviceByDatabaseId.getId();
        f13048j.put(id2, strValueOf);
        map2.put(strValueOf, id2);
        return id2;
    }

    /* renamed from: k */
    public static boolean m18001k(String str, String str2) throws Throwable {
        String[] applications;
        List<String> arrayList = new ArrayList<>();
        Map<String, List<String>> map = f13045g;
        if (map.containsKey(str)) {
            arrayList = map.get(str);
        } else {
            SyncConfigService serviceById = new SyncConfigOperator().getServiceById(str);
            if (serviceById != null && (applications = serviceById.getApplications()) != null) {
                arrayList = Arrays.asList(applications);
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.contains(str2) || m17998i(str, arrayList).contains(str2)) {
            return true;
        }
        C11839m.m70689w("DriveSyncUtil", "aild pkg not avaliable, syncType = " + str);
        return false;
    }

    /* renamed from: l */
    public static void m18002l(String str, String str2) throws C9722c {
        if (C1164a.m7265f().m7268d(str) == null) {
            throw new C9722c(2208, "drive builder is null", str, str2);
        }
        if (C13452e.m80781L().m80917g1()) {
            throw new C9722c(1102, "cloudsync error st invalid.", str, str2);
        }
        if (C13452e.m80781L().m80927i1()) {
            throw new C9722c(FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED, "cloudsync error syncrisk effective.", str, str2);
        }
        if (C10028c.m62182c0().m62380q1() && C10028c.m62182c0().m62320e1()) {
            throw new C9722c(2201, "cloudsync error force upgrade.", str, str2);
        }
    }

    /* renamed from: m */
    public static void m18003m(Context context, String str) {
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        c13007bM78205Y.m78262h(str);
        c13007bM78205Y.m78264i(str);
    }

    /* renamed from: n */
    public static int m18004n(Context context, String str) {
        int iM79133s;
        C11839m.m70688i("DriveSyncUtil", "clear tag");
        try {
            iM79133s = C13153a.m79133s(str, context);
        } catch (SQLException unused) {
            C11839m.m70687e("DriveSyncUtil", "deleteTag SQLException");
            iM79133s = -2;
        } catch (Exception e10) {
            C11839m.m70687e("DriveSyncUtil", "deleteTag Exception = " + e10.toString());
            iM79133s = -1;
        }
        C13153a.m79132r(context, str, 2, "local_on_data_sync_clear");
        return iM79133s;
    }

    /* renamed from: o */
    public static void m18005o(Closeable closeable) throws IOException {
        if (closeable == null) {
            C11839m.m70686d("DriveSyncUtil", "cursor is already null");
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            C11839m.m70687e("DriveSyncUtil", "close fialed: " + e10.toString());
        }
    }

    /* renamed from: p */
    public static String m18006p(String str, byte[] bArr) throws C9721b {
        try {
            byte[] bArrDecode = SafeBase64.decode(str, 2);
            if (bArrDecode.length == 0) {
                return "";
            }
            byte[] bArr2 = new byte[16];
            for (int i10 = 0; i10 < 16; i10++) {
                bArr2[i10] = bArrDecode[i10];
            }
            return new String(C10466a.m64326q(2, bArr, bArr2).doFinal(bArrDecode, 16, bArrDecode.length - 16), Constants.UTF_8);
        } catch (Exception e10) {
            throw new C9721b(4005, "syncV2 decryptData error:" + e10.toString());
        }
    }

    /* renamed from: q */
    public static String m18007q(String str, byte[] bArr) throws C9721b {
        try {
            return new String(C10466a.m64326q(2, bArr, C10466a.m64329t(str.substring(0, 32))).doFinal(C10466a.m64329t(str.substring(32))), Constants.UTF_8);
        } catch (Exception e10) {
            throw new C9721b(4005, "syncV2 decryptEdek error:" + e10.toString());
        }
    }

    /* renamed from: r */
    public static String m18008r(UserKeyObject userKeyObject, DataDecryptReq dataDecryptReq) throws C9721b {
        C9720a.m60653b(dataDecryptReq.getSrcData(), "source is invalid.");
        C9720a.m60653b(dataDecryptReq.getEdek(), "edek is invalid.");
        return m18006p(dataDecryptReq.getSrcData(), C10466a.m64329t(m18007q(dataDecryptReq.getEdek(), userKeyObject.getUserKey())));
    }

    /* renamed from: s */
    public static long m18009s(String str, String str2, String str3, String str4) throws C9722c {
        try {
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(str);
            if (c9453iM7268d == null) {
                throw new C9722c(2208, "drive builder is null", str, "locks_get");
            }
            String strM17959D = m17959D(str);
            if (TextUtils.isEmpty(str2)) {
                throw new C9722c(2003, "lock is empty", str, "locks_delete");
            }
            Locks.Delete deleteAddHeader = c9453iM7268d.m59246e().delete(strM17959D).addHeader("x-hw-lock", (Object) str2).addHeader("x-hw-channel-Id", (Object) C9310c.m58618b(C13452e.m80781L().m80950o() + "10055832"));
            m17992f(C0213f.m1377a(), str4, str, deleteAddHeader.getHeaders());
            m17994g(deleteAddHeader.getHeaders(), str4, str, str3);
            long jCurrentTimeMillis = System.currentTimeMillis();
            deleteAddHeader.execute();
            C11440c.m68542u(str, SNSCode.Status.GET_GROUP_LIST_FAIL);
            return jCurrentTimeMillis;
        } catch (C9722c e10) {
            C11839m.m70687e("DriveSyncUtil", "delete lock SyncException: " + e10.getMessage());
            return 0L;
        } catch (IOException e11) {
            C11839m.m70687e("DriveSyncUtil", "delete lock IOException: " + e11.getMessage());
            return 0L;
        }
    }

    /* renamed from: t */
    public static String m18010t(String str, byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, C9721b {
        try {
            byte[] bArrDoFinal = C10466a.m64326q(1, bArr, bArr2).doFinal(str.getBytes(Constants.UTF_8));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrDoFinal.length + 16);
            byteBufferAllocate.put(bArr2);
            byteBufferAllocate.put(bArrDoFinal);
            byteBufferAllocate.array();
            return Base64.encodeToString(byteBufferAllocate.array(), 2);
        } catch (Exception e10) {
            throw new C9721b(4004, "encryptData error:" + e10.toString());
        }
    }

    /* renamed from: u */
    public static String m18011u(String str, byte[] bArr, byte[] bArr2) throws BadPaddingException, IllegalBlockSizeException, C9721b {
        try {
            return C10466a.m64310a(bArr2) + C10466a.m64310a(C10466a.m64326q(1, bArr, bArr2).doFinal(str.getBytes(Constants.UTF_8)));
        } catch (Exception e10) {
            throw new C9721b(4004, "encryptData error:" + e10.toString());
        }
    }

    /* renamed from: v */
    public static EncryptedData m18012v(UserKeyObject userKeyObject, DataEncryptReq dataEncryptReq) throws C9721b {
        C9720a.m60653b(dataEncryptReq.getSrcData(), "source is invalid.");
        byte[] bArrM64328s = dataEncryptReq.getDek() == null ? C10466a.m64328s() : C10466a.m64329t(dataEncryptReq.getDek());
        byte[] bArrM64328s2 = C10466a.m64328s();
        EncryptedData encryptedData = new EncryptedData();
        encryptedData.setData(m18010t(dataEncryptReq.getSrcData(), bArrM64328s, bArrM64328s2));
        encryptedData.setEdek(m18011u(C10466a.m64310a(bArrM64328s), userKeyObject.getUserKey(), bArrM64328s2));
        encryptedData.setKeyGuid(userKeyObject.getUserKeyGuid());
        if (!TextUtils.isEmpty(dataEncryptReq.getSrcExtensionData())) {
            encryptedData.setExtensionData(m18010t(dataEncryptReq.getSrcExtensionData(), bArrM64328s, bArrM64328s2));
        }
        return encryptedData;
    }

    /* renamed from: w */
    public static File m18013w() {
        File fileM63441g = C10278a.m63441g(m17968M(), ".sync_asset");
        if (!fileM63441g.exists() && fileM63441g.mkdirs()) {
            C11839m.m70688i("DriveSyncUtil", "external parent create success.");
        }
        return fileM63441g;
    }

    /* renamed from: x */
    public static String m18014x(C4609l c4609l) {
        if (c4609l == null) {
            C11839m.m70687e("DriveSyncUtil", "headers is null");
            return null;
        }
        Object obj = c4609l.get("hw-cdn-url");
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        Object obj2 = arrayList.get(0);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        return null;
    }

    /* renamed from: y */
    public static String m18015y(IOException iOException) {
        if (!(iOException instanceof C4616s)) {
            return "0";
        }
        C4616s c4616s = (C4616s) iOException;
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return "0";
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d)) {
            return "0";
        }
        String strM59436d2 = C9499a.m59436d(strM59436d, "errorData");
        if (TextUtils.isEmpty(strM59436d2)) {
            return "0";
        }
        String strM59436d3 = C9499a.m59436d(strM59436d2, "clearDataScene");
        return TextUtils.isEmpty(strM59436d3) ? "0" : strM59436d3;
    }

    /* renamed from: z */
    public static String m18016z(IOException iOException) {
        if (!(iOException instanceof C4616s)) {
            return "";
        }
        C4616s c4616s = (C4616s) iOException;
        if (TextUtils.isEmpty(c4616s.m28319c())) {
            return "";
        }
        String strM59436d = C9499a.m59436d(c4616s.m28319c(), VastAttribute.ERROR);
        if (TextUtils.isEmpty(strM59436d)) {
            return "";
        }
        String strM59436d2 = C9499a.m59436d(strM59436d, "errorData");
        if (TextUtils.isEmpty(strM59436d2)) {
            return "";
        }
        String strM59436d3 = C9499a.m59436d(strM59436d2, "serviceName");
        return TextUtils.isEmpty(strM59436d3) ? "" : strM59436d3;
    }
}
