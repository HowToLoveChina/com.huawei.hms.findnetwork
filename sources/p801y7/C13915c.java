package p801y7;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.C2414a;
import com.huawei.android.hicloud.album.service.hihttp.request.response.FileCreateResponse;
import com.huawei.android.hicloud.drive.cloudphoto.CloudPhotoMediaUploaderProgressListener;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import gp.C10028c;
import hk.C10278a;
import java.io.File;
import java.util.LinkedHashMap;
import org.json.JSONException;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;

/* renamed from: y7.c */
/* loaded from: classes2.dex */
public class C13915c {

    /* renamed from: a */
    public CloudPhotoMediaUploaderProgressListener f62287a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.AbstractMap, java.util.LinkedHashMap<java.lang.String, java.lang.String>] */
    /* renamed from: a */
    public final boolean m83378a(FileInfo fileInfo, String str, LinkedHashMap<String, String> linkedHashMap) throws Throwable {
        ?? IsEmpty = "checksum is null";
        try {
        } catch (Throwable th2) {
            th = th2;
            IsEmpty = "";
        }
        try {
            if (TextUtils.isEmpty(str) && C10028c.m62182c0().m62420y1() && !fileInfo.isMigratedData()) {
                C1120a.m6678w("SDKFileInfoCreateManage", "checksum is null");
                C1120a.m6678w("SDKFileInfoCreateManage", "checksum is null");
                linkedHashMap.put("reportMsg", "checksum is null");
                return true;
            }
            if (fileInfo == null) {
                C1120a.m6678w("SDKFileInfoCreateManage", "preFileInfo is null");
                linkedHashMap.put("reportMsg", "preFileInfo is null");
                return true;
            }
            IsEmpty = TextUtils.isEmpty(fileInfo.getFileName());
            if (IsEmpty != 0) {
                C1120a.m6678w("SDKFileInfoCreateManage", "fileName is null");
                linkedHashMap.put("reportMsg", "fileName is null");
                return true;
            }
            try {
                IsEmpty = fileInfo.getUserID();
                C0241z.m1688f(IsEmpty);
                linkedHashMap.put("reportMsg", "");
                return false;
            } catch (NumberFormatException unused) {
                C1120a.m6678w("SDKFileInfoCreateManage", "uid invalid");
                linkedHashMap.put("reportMsg", "uid invalid");
                return true;
            }
        } catch (Throwable th3) {
            th = th3;
            linkedHashMap.put("reportMsg", IsEmpty);
            throw th;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:135:0x0378
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    /* renamed from: b */
    public int m83379b(android.content.Context r20, com.huawei.android.p069cg.p072vo.FileInfo r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, boolean r25, java.lang.String r26, com.huawei.android.hicloud.album.service.CallbackHandler r27) {
        /*
            Method dump skipped, instructions count: 1467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p801y7.C13915c.m83379b(android.content.Context, com.huawei.android.cg.vo.FileInfo, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, com.huawei.android.hicloud.album.service.CallbackHandler):int");
    }

    /* renamed from: c */
    public final void m83380c(FileInfo fileInfo) {
        String strM6763b1 = C1122c.m6763b1(fileInfo);
        if (TextUtils.isEmpty(strM6763b1)) {
            return;
        }
        File file = new File(strM6763b1);
        if (file.exists()) {
            C1120a.m6675d("SDKFileInfoCreateManage", "delete: " + file.delete());
        }
    }

    /* renamed from: d */
    public final void m83381d(FileInfo fileInfo, String str, boolean z10, Context context) {
        if (fileInfo == null || str == null) {
            return;
        }
        fileInfo.setLocalRealPath(m83388k(fileInfo));
    }

    /* renamed from: e */
    public final String m83382e(boolean z10) {
        return z10 ? "cloudphoto.file.create.share" : "cloudphoto.file.create";
    }

    /* renamed from: f */
    public final FileInfo m83383f(FileInfo fileInfo, FileCreateResponse fileCreateResponse, int i10, boolean z10, Context context) throws JSONException {
        if (fileInfo == null) {
            C1120a.m6678w("SDKFileInfoCreateManage", "preFileInfo is null");
            return null;
        }
        if (context == null) {
            C1120a.m6678w("SDKFileInfoCreateManage", "context is null");
            return null;
        }
        if (fileCreateResponse == null) {
            C1120a.m6678w("SDKFileInfoCreateManage", "createResJson is null");
            return null;
        }
        String fileName = fileInfo.getFileName();
        String fileName2 = !TextUtils.isEmpty(fileCreateResponse.getFileName()) ? fileCreateResponse.getFileName() : fileInfo.getFileName();
        long jM6794j0 = C1122c.m6794j0(TextUtils.isEmpty(fileCreateResponse.getSdsctime()) ? null : fileCreateResponse.getSdsctime());
        fileInfo.setFileName(fileName2);
        fileInfo.setSdsTime(jM6794j0);
        if (i10 == 6 && fileName != null && !fileName.equals(fileName2)) {
            m83381d(fileInfo, fileName, z10, context);
        }
        if (TextUtils.isEmpty(fileInfo.getFileId()) || fileInfo.getFileId().equals("NMD")) {
            fileInfo.setFileId(fileInfo.getUniqueId());
        }
        return fileInfo;
    }

    /* renamed from: g */
    public final void m83384g(FileInfo fileInfo, FileCreateResponse fileCreateResponse, int i10, boolean z10, Context context) throws JSONException {
        C1120a.m6677i("SDKFileInfoCreateManage", "processCreateFileInfoSuccess begin");
        if (fileInfo == null || fileCreateResponse == null) {
            C1120a.m6676e("SDKFileInfoCreateManage", "priFileInfo or res null");
            return;
        }
        if (!z10) {
            String uniqueId = fileCreateResponse.getUniqueId();
            if (TextUtils.isEmpty(uniqueId)) {
                C1120a.m6676e("SDKFileInfoCreateManage", "uniqueId is empty");
                return;
            }
            fileInfo.setUniqueId(uniqueId);
        }
        FileInfo fileInfoM83383f = m83383f(fileInfo, fileCreateResponse, i10, z10, context);
        long jM7089q = C1136q.b.m7089q(context, "userCapacityUsed");
        if (jM7089q > 0) {
            C1136q.b.m7112x1(context, "userCapacityUsed", jM7089q + fileInfoM83383f.getSize());
        }
    }

    /* renamed from: h */
    public final void m83385h(FileInfo fileInfo, FileCreateResponse fileCreateResponse, boolean z10, Context context) throws JSONException {
        C1120a.m6677i("SDKFileInfoCreateManage", "processFileInfoExist begin");
        if (fileInfo == null || fileCreateResponse == null) {
            C1120a.m6676e("SDKFileInfoCreateManage", "priFileInfo or res null");
            return;
        }
        String fileName = !TextUtils.isEmpty(fileCreateResponse.getFileName()) ? fileCreateResponse.getFileName() : fileInfo.getFileName();
        long jM6794j0 = C1122c.m6794j0(!TextUtils.isEmpty(fileCreateResponse.getSdsctime()) ? fileCreateResponse.getSdsctime() : null);
        fileInfo.setFileName(fileName);
        fileInfo.setSdsTime(jM6794j0);
        C1122c.m6828r2(fileInfo);
    }

    /* renamed from: i */
    public final void m83386i(boolean z10) {
        if (CloudAlbumSettings.m14363h().m14376l()) {
            Bundle bundle = new Bundle();
            bundle.putInt("Code", 36);
            if (z10) {
                C13916d.m83405o(C0213f.m1377a(), null, 36);
                C2414a.m15051l().sendMessage(9093, bundle);
            } else {
                C13916d.m83404n(C0213f.m1377a(), null, 36);
                C2414a.m15051l().sendMessage(9091, bundle);
            }
        }
    }

    /* renamed from: j */
    public void m83387j(CloudPhotoMediaUploaderProgressListener cloudPhotoMediaUploaderProgressListener) {
        this.f62287a = cloudPhotoMediaUploaderProgressListener;
    }

    /* renamed from: k */
    public final String m83388k(FileInfo fileInfo) {
        File parentFile;
        if (fileInfo == null || fileInfo.getLocalRealPath() == null || fileInfo.getLocalRealPath().isEmpty() || fileInfo.getFileName() == null || fileInfo.getFileName().isEmpty() || (parentFile = C10278a.m63442h(fileInfo.getLocalRealPath()).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        String str = parentFile.toString() + "/" + fileInfo.getFileName();
        C1120a.m6677i("SDKFileInfoCreateManage", "rename FileData, oldPath: " + fileInfo.getLocalRealPath() + ", newPath: " + str);
        C1122c.m6735S1(fileInfo.getLocalRealPath(), str);
        return str;
    }
}
