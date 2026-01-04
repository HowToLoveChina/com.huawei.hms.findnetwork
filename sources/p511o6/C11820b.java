package p511o6;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p365ic.C10466a;
import p709vj.C13452e;
import p783xp.AbstractC13844b;

/* renamed from: o6.b */
/* loaded from: classes2.dex */
public class C11820b {

    /* renamed from: o6.b$a */
    public class a implements Comparator<FileInfo> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            if (fileInfo.getAddTime() > fileInfo2.getAddTime()) {
                return 1;
            }
            if (fileInfo.getAddTime() < fileInfo2.getAddTime() || fileInfo.getCreateTime() > fileInfo2.getCreateTime()) {
                return -1;
            }
            if (fileInfo.getCreateTime() < fileInfo2.getCreateTime()) {
                return 1;
            }
            return C1122c.m6835u(fileInfo.getFileName(), fileInfo2.getFileName());
        }
    }

    /* renamed from: a */
    public static Comparator<FileInfo> m70396a() {
        return new a();
    }

    /* renamed from: b */
    public static void m70397b(Context context, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("position")) {
            return;
        }
        try {
            if (jSONObject.has("positionDEK")) {
                jSONObject.remove("positionDEK");
            }
            if (jSONObject.has("createrAccountDEK")) {
                jSONObject.remove("createrAccountDEK");
            }
            String strOptString = jSONObject.optString("position");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            String strM80900d = C13452e.m80781L().m80900d();
            String strM83106b = AbstractC13844b.m83106b();
            if (TextUtils.isEmpty(strM83106b)) {
                return;
            }
            DataEncryptReq dataEncryptReq = new DataEncryptReq();
            dataEncryptReq.setDek(strM83106b);
            dataEncryptReq.setSrcData(strM80900d);
            EncryptedData encryptedDataM64323n = C10466a.m64323n(dataEncryptReq);
            jSONObject.put("createrAccount", encryptedDataM64323n.getData());
            jSONObject.put(SyncProtocol.Constant.DEK, encryptedDataM64323n.getEdek());
            DataEncryptReq dataEncryptReq2 = new DataEncryptReq();
            dataEncryptReq2.setDek(strM83106b);
            JSONObject jSONObject2 = new JSONObject(strOptString);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Constants.MULTIPLE_SIGN, jSONObject2.getString(Constants.MULTIPLE_SIGN));
            jSONObject3.put("y", jSONObject2.getString("y"));
            dataEncryptReq2.setSrcData(jSONObject3.toString());
            EncryptedData encryptedDataM64323n2 = C10466a.m64323n(dataEncryptReq2);
            jSONObject.remove("position");
            jSONObject.put("position", encryptedDataM64323n2.getData());
        } catch (C9721b e10) {
            C1120a.m6676e("OperationUtil", "encrypt data error: " + e10.getMessage());
        } catch (NoSuchAlgorithmException e11) {
            C1120a.m6676e("OperationUtil", "encryptPositionExpand NoSuchAlgorithmException" + e11.toString());
        } catch (JSONException unused) {
            C1120a.m6676e("OperationUtil", "encryptPositionExpand JSONException");
        }
    }

    /* renamed from: c */
    public static JSONObject m70398c(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            C1120a.m6676e("OperationUtil", "getDefaultExpand JSONException");
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9 A[Catch: JSONException -> 0x0157, TryCatch #1 {JSONException -> 0x0157, blocks: (B:6:0x0019, B:18:0x006e, B:20:0x0074, B:22:0x007a, B:23:0x008c, B:26:0x00a3, B:27:0x00c7, B:29:0x00cd, B:31:0x00d7, B:32:0x00e1, B:34:0x00e9, B:36:0x00f5, B:37:0x00fc, B:39:0x0106, B:40:0x0113, B:42:0x011d, B:43:0x012a, B:45:0x0130, B:46:0x013d, B:48:0x0145, B:49:0x0152, B:13:0x004c, B:14:0x0053, B:16:0x005d), top: B:56:0x0019, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106 A[Catch: JSONException -> 0x0157, TryCatch #1 {JSONException -> 0x0157, blocks: (B:6:0x0019, B:18:0x006e, B:20:0x0074, B:22:0x007a, B:23:0x008c, B:26:0x00a3, B:27:0x00c7, B:29:0x00cd, B:31:0x00d7, B:32:0x00e1, B:34:0x00e9, B:36:0x00f5, B:37:0x00fc, B:39:0x0106, B:40:0x0113, B:42:0x011d, B:43:0x012a, B:45:0x0130, B:46:0x013d, B:48:0x0145, B:49:0x0152, B:13:0x004c, B:14:0x0053, B:16:0x005d), top: B:56:0x0019, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[Catch: JSONException -> 0x0157, TryCatch #1 {JSONException -> 0x0157, blocks: (B:6:0x0019, B:18:0x006e, B:20:0x0074, B:22:0x007a, B:23:0x008c, B:26:0x00a3, B:27:0x00c7, B:29:0x00cd, B:31:0x00d7, B:32:0x00e1, B:34:0x00e9, B:36:0x00f5, B:37:0x00fc, B:39:0x0106, B:40:0x0113, B:42:0x011d, B:43:0x012a, B:45:0x0130, B:46:0x013d, B:48:0x0145, B:49:0x0152, B:13:0x004c, B:14:0x0053, B:16:0x005d), top: B:56:0x0019, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0130 A[Catch: JSONException -> 0x0157, TryCatch #1 {JSONException -> 0x0157, blocks: (B:6:0x0019, B:18:0x006e, B:20:0x0074, B:22:0x007a, B:23:0x008c, B:26:0x00a3, B:27:0x00c7, B:29:0x00cd, B:31:0x00d7, B:32:0x00e1, B:34:0x00e9, B:36:0x00f5, B:37:0x00fc, B:39:0x0106, B:40:0x0113, B:42:0x011d, B:43:0x012a, B:45:0x0130, B:46:0x013d, B:48:0x0145, B:49:0x0152, B:13:0x004c, B:14:0x0053, B:16:0x005d), top: B:56:0x0019, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145 A[Catch: JSONException -> 0x0157, TryCatch #1 {JSONException -> 0x0157, blocks: (B:6:0x0019, B:18:0x006e, B:20:0x0074, B:22:0x007a, B:23:0x008c, B:26:0x00a3, B:27:0x00c7, B:29:0x00cd, B:31:0x00d7, B:32:0x00e1, B:34:0x00e9, B:36:0x00f5, B:37:0x00fc, B:39:0x0106, B:40:0x0113, B:42:0x011d, B:43:0x012a, B:45:0x0130, B:46:0x013d, B:48:0x0145, B:49:0x0152, B:13:0x004c, B:14:0x0053, B:16:0x005d), top: B:56:0x0019, inners: #0 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m70399d(com.huawei.android.p069cg.p072vo.FileInfo r10, java.lang.String r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p511o6.C11820b.m70399d(com.huawei.android.cg.vo.FileInfo, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2 A[Catch: JSONException -> 0x00e0, TryCatch #2 {JSONException -> 0x00e0, blocks: (B:7:0x001a, B:19:0x0064, B:21:0x006a, B:23:0x0070, B:24:0x0082, B:26:0x0088, B:28:0x0092, B:29:0x009c, B:31:0x00a2, B:33:0x00b0, B:34:0x00b7, B:36:0x00bf, B:38:0x00c5, B:40:0x00d4, B:41:0x00db, B:14:0x003f, B:15:0x0046, B:17:0x0050), top: B:50:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4 A[Catch: JSONException -> 0x00e0, TryCatch #2 {JSONException -> 0x00e0, blocks: (B:7:0x001a, B:19:0x0064, B:21:0x006a, B:23:0x0070, B:24:0x0082, B:26:0x0088, B:28:0x0092, B:29:0x009c, B:31:0x00a2, B:33:0x00b0, B:34:0x00b7, B:36:0x00bf, B:38:0x00c5, B:40:0x00d4, B:41:0x00db, B:14:0x003f, B:15:0x0046, B:17:0x0050), top: B:50:0x001a }] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m70400e(android.content.Context r12, com.huawei.android.p069cg.p072vo.FileInfo r13, org.json.JSONObject r14) throws java.lang.Throwable {
        /*
            java.lang.String r12 = "fileCreateTime"
            java.lang.String r0 = "rotate"
            java.lang.String r1 = "OperationUtil"
            java.lang.String r2 = "position"
            java.lang.String r3 = "fileRepeatList"
            java.lang.String r4 = ""
            if (r13 == 0) goto Le5
            java.lang.String r5 = r13.getLocalRealPath()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L1a
            goto Le5
        L1a:
            java.lang.String r5 = r13.getExpand()     // Catch: org.json.JSONException -> Le0
            org.json.JSONObject r5 = m70398c(r5)     // Catch: org.json.JSONException -> Le0
            java.lang.String r6 = r5.optString(r2)     // Catch: org.json.JSONException -> Le0
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: org.json.JSONException -> Le0
            java.lang.String r8 = "y"
            java.lang.String r9 = "x"
            if (r7 != 0) goto L46
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L3e
            r7.<init>(r6)     // Catch: org.json.JSONException -> L3e
            java.lang.String r6 = r7.optString(r9)     // Catch: org.json.JSONException -> L3e
            java.lang.String r7 = r7.optString(r8)     // Catch: org.json.JSONException -> L3f
            goto L64
        L3e:
            r6 = r4
        L3f:
            java.lang.String r7 = "convert position JSONException"
            p031b7.C1120a.m6676e(r1, r7)     // Catch: org.json.JSONException -> Le0
            r7 = r4
            goto L64
        L46:
            java.lang.String r6 = r13.getLocalRealPath()     // Catch: org.json.JSONException -> Le0
            float[] r6 = p031b7.C1125f.m6886g(r6)     // Catch: org.json.JSONException -> Le0
            if (r6 == 0) goto L62
            r7 = 0
            r7 = r6[r7]     // Catch: org.json.JSONException -> Le0
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: org.json.JSONException -> Le0
            r10 = 1
            r6 = r6[r10]     // Catch: org.json.JSONException -> Le0
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: org.json.JSONException -> Le0
            r11 = r7
            r7 = r6
            r6 = r11
            goto L64
        L62:
            r6 = r4
            r7 = r6
        L64:
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch: org.json.JSONException -> Le0
            if (r10 != 0) goto L82
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch: org.json.JSONException -> Le0
            if (r10 != 0) goto L82
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: org.json.JSONException -> Le0
            r10.<init>()     // Catch: org.json.JSONException -> Le0
            r10.put(r9, r6)     // Catch: org.json.JSONException -> Le0
            r10.put(r8, r7)     // Catch: org.json.JSONException -> Le0
            java.lang.String r6 = r10.toString()     // Catch: org.json.JSONException -> Le0
            r5.put(r2, r6)     // Catch: org.json.JSONException -> Le0
        L82:
            boolean r2 = r5.has(r0)     // Catch: org.json.JSONException -> Le0
            if (r2 != 0) goto L9c
            java.lang.String r2 = r13.getLocalRealPath()     // Catch: org.json.JSONException -> Le0
            java.lang.String r2 = p031b7.C1125f.m6889j(r2)     // Catch: org.json.JSONException -> Le0
            if (r2 == 0) goto L9c
            int r6 = p015ak.C0241z.m1685c(r2)     // Catch: org.json.JSONException -> Le0
            r13.setOrientation(r6)     // Catch: org.json.JSONException -> Le0
            r5.put(r0, r2)     // Catch: org.json.JSONException -> Le0
        L9c:
            boolean r0 = r5.has(r12)     // Catch: org.json.JSONException -> Le0
            if (r0 != 0) goto Lb7
            java.lang.String r0 = r13.getLocalRealPath()     // Catch: org.json.JSONException -> Le0
            long r6 = p031b7.C1125f.m6888i(r0)     // Catch: org.json.JSONException -> Le0
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 == 0) goto Lb7
            java.lang.String r0 = java.lang.String.valueOf(r6)     // Catch: org.json.JSONException -> Le0
            r5.put(r12, r0)     // Catch: org.json.JSONException -> Le0
        Lb7:
            m70405j(r5)     // Catch: org.json.JSONException -> Le0
            m70404i(r13, r5)     // Catch: org.json.JSONException -> Le0
            if (r14 == 0) goto Ldb
            boolean r12 = r14.has(r3)     // Catch: org.json.JSONException -> Le0
            if (r12 == 0) goto Ldb
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch: org.json.JSONException -> Le0
            java.lang.String r13 = r14.getString(r3)     // Catch: org.json.JSONException -> Le0
            r12.<init>(r13)     // Catch: org.json.JSONException -> Le0
            int r13 = r12.length()     // Catch: org.json.JSONException -> Le0
            if (r13 <= 0) goto Ldb
            java.lang.String r12 = r12.toString()     // Catch: org.json.JSONException -> Le0
            r5.put(r3, r12)     // Catch: org.json.JSONException -> Le0
        Ldb:
            java.lang.String r4 = r5.toString()     // Catch: org.json.JSONException -> Le0
            goto Le5
        Le0:
            java.lang.String r12 = "upload file convert position JSONException"
            p031b7.C1120a.m6676e(r1, r12)
        Le5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p511o6.C11820b.m70400e(android.content.Context, com.huawei.android.cg.vo.FileInfo, org.json.JSONObject):java.lang.String");
    }

    /* renamed from: f */
    public static String m70401f(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1120a.m6676e("OperationUtil", "getFileIdKey param error");
            return null;
        }
        return str + "_" + str2 + "_" + i10 + "_";
    }

    /* renamed from: g */
    public static boolean m70402g(Context context) {
        if (context == null) {
            C1120a.m6676e("OperationUtil", "context is null");
            return false;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            C1120a.m6678w("OperationUtil", "batteryStatus is null");
            return false;
        }
        try {
            return intentRegisterReceiver.getIntExtra(FaqConstants.FAQ_LEVEL, 100) < 10;
        } catch (Exception e10) {
            C1120a.m6676e("OperationUtil", "isDownloadBatteryNotAllow exception: " + e10.toString());
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m70403h(FileInfo fileInfo, String str, String str2) {
        return fileInfo == null || TextUtils.isEmpty(fileInfo.getLocalRealPath()) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* renamed from: i */
    public static void m70404i(FileInfo fileInfo, JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(fileInfo.getCreaterId())) {
            jSONObject.put("createrId", String.valueOf(fileInfo.getCreaterId()));
        }
        if (!TextUtils.isEmpty(fileInfo.getCreaterAccount())) {
            jSONObject.put("createrAccount", String.valueOf(fileInfo.getCreaterAccount()));
        }
        if (fileInfo.getBatchId() != 0) {
            jSONObject.put("batchId", String.valueOf(fileInfo.getBatchId()));
        }
        if (fileInfo.getBatchCtime() != 0) {
            jSONObject.put("batchCtime", String.valueOf(fileInfo.getBatchCtime()));
        }
    }

    /* renamed from: j */
    public static void m70405j(JSONObject jSONObject) {
        if (jSONObject.has(SyncProtocol.Constant.DEK)) {
            jSONObject.remove(SyncProtocol.Constant.DEK);
        }
        if (jSONObject.has("positionDEK")) {
            jSONObject.remove("positionDEK");
        }
        if (jSONObject.has("createrAccountDEK")) {
            jSONObject.remove("createrAccountDEK");
        }
    }
}
