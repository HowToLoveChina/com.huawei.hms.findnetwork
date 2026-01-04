package com.huawei.android.hicloud.sync.protocol;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.text.TextUtils;
import bd.C1164a;
import cd.C1421d;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.DownloadResult;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncimpl.FileProcess;
import com.huawei.android.hicloud.sync.syncutil.C2981j;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import fk.C9721b;
import fk.C9722c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p255ed.C9453i;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p572qb.C12308f0;
import p572qb.C12316j0;
import p709vj.C13452e;
import p746wn.C13622a;
import sb.C12767a;
import vc.C13404h;

/* renamed from: com.huawei.android.hicloud.sync.protocol.j */
/* loaded from: classes3.dex */
public class C2931j extends AbstractCallableC2922a<DownloadResult> {

    /* renamed from: d */
    public final String f12966d;

    /* renamed from: e */
    public final Context f12967e;

    /* renamed from: f */
    public final String f12968f;

    /* renamed from: g */
    public final String f12969g;

    /* renamed from: h */
    public final boolean f12970h;

    /* renamed from: i */
    public final UnstructData f12971i;

    /* renamed from: j */
    public final String f12972j;

    /* renamed from: k */
    public final String f12973k;

    /* renamed from: l */
    public final String f12974l;

    /* renamed from: m */
    public final String f12975m;

    /* renamed from: n */
    public final String f12976n;

    /* renamed from: o */
    public final String f12977o;

    /* renamed from: p */
    public final C1421d f12978p;

    /* renamed from: q */
    public final C13404h f12979q;

    public C2931j(Context context, String str, String str2, String str3, String str4, UnstructData unstructData, String str5, String str6, String str7, boolean z10, C13404h c13404h) {
        this.f12967e = context;
        this.f12968f = str;
        this.f12969g = str2;
        this.f12973k = str3;
        this.f12972j = str4;
        this.f12971i = unstructData;
        this.f12977o = str5;
        this.f12975m = str6;
        this.f12976n = str7;
        this.f12970h = z10;
        this.f12978p = new C1421d(CloudSyncUtil.m15961L(str), str7, str2, unstructData.getUnstructUuid(), DriveSyncUtil.m17958C(str));
        this.f12979q = c13404h;
        this.f12966d = C12308f0.m74000d().m74003c(str, str2, unstructData);
        this.f12974l = context.getFilesDir() + "/sync/" + str2 + "/sync_require_download";
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractCallableC2922a
    /* renamed from: a */
    public void mo17735a() {
        super.mo17735a();
        C13404h c13404h = this.f12979q;
        if (c13404h != null) {
            c13404h.m80591e(true, 6000);
        }
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractCallableC2922a
    /* renamed from: e */
    public void mo17739e() {
        C12308f0.m74000d().m74005f(this);
    }

    /* renamed from: g */
    public final void m17773g(UnstructData unstructData) {
        if (FileProcess.m17795b(new File(this.f12974l + "/" + unstructData.getName()))) {
            return;
        }
        C11839m.m70688i("SingleRequireDownloadCallable", "delete temp dir fail, fielName = " + unstructData.getName());
    }

    @Override // com.huawei.android.hicloud.sync.protocol.AbstractCallableC2922a
    /* renamed from: h */
    public DownloadResult mo17737c() throws C9722c {
        String strM17958C = DriveSyncUtil.m17958C(this.f12968f);
        try {
            m17777k();
            C9453i c9453iM7268d = C1164a.m7265f().m7268d(this.f12968f);
            DriveSyncUtil.m18002l(this.f12968f, "require_download_struct");
            if (!C0209d.m1208S0(this.f12967e)) {
                C11839m.m70689w("SingleRequireDownloadCallable", "network not connect error ");
                throw new C9722c(2028, "network not connect error", this.f12969g, "require_download_struct");
            }
            if (TextUtils.isEmpty(this.f12971i.getName())) {
                throw new C9722c(2003, "getAssetList usage is empty", this.f12969g, "require_download_struct");
            }
            if (C12316j0.m74076d().m74086k(strM17958C, this.f12969g, this.f12972j)) {
                throw new C9722c(SNSCode.Status.GET_FRIEND_LIST_FAIL, "getAssetList record not exits, over times", this.f12969g, "require_download_struct");
            }
            AssetList assetListExecute = c9453iM7268d.m59242a().list(strM17958C, this.f12969g, this.f12972j, this.f12971i.getName(), "assets(cipher,createdTime,id,keepPolicy,mimeType,modifiedTime,resource,state,version,versionId,lastModifyingUser,scaState,properties,status,appVer)").addHeader("x-hw-trace-id", (Object) this.f12976n).addHeader("x-hw-thinsdkapp-version", (Object) DriveSyncUtil.m17971P(this.f12968f, this.f12973k)).addHeader("x-hw-3rdapp-packagename", (Object) DriveSyncUtil.m17965J(this.f12968f, this.f12973k)).addHeader("x-hw-3rdapp-version", (Object) DriveSyncUtil.m17971P(this.f12968f, this.f12973k)).execute();
            if (assetListExecute == null) {
                C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 Cloud no file : guid:" + this.f12971i.getUnstructUuid() + ",name:" + this.f12971i.getName());
                C2981j.m17891e(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, 3207, this.f12975m);
                return new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), 3207);
            }
            List<Asset> assets = assetListExecute.getAssets();
            if (assets != null && assets.size() > 0) {
                Asset asset = assets.get(0);
                if (asset == null) {
                    C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 Cloud no file : guid:" + this.f12971i.getUnstructUuid() + ",name:" + this.f12971i.getName());
                    C2981j.m17891e(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, 3207, this.f12975m);
                    return new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), 3207);
                }
                m17777k();
                this.f12978p.m8268a(asset, this.f12974l + "/" + this.f12971i.getName(), this.f12979q, this.f12971i.getName(), this.f12968f, this.f12973k, "require_download_struct");
                if (m17778l(this.f12971i)) {
                    C2981j.m17893g(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, this.f12975m);
                    C12767a.m76619c().m76622d(this.f12968f);
                    return new DownloadResult(this.f12971i.getId(), this.f12971i.getName());
                }
                C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 restore error");
                C2981j.m17891e(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, 2229, this.f12975m);
                return new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), 2229);
            }
            C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 Cloud no file : guid:" + this.f12971i.getUnstructUuid() + ",name:" + this.f12971i.getName());
            C2981j.m17891e(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, 3207, this.f12975m);
            return new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), 3207);
        } catch (C9721b e10) {
            C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 CException : " + e10.toString() + ", error code : " + e10.m60659c());
            DownloadResult downloadResult = new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), e10.m60659c());
            C2981j.m17894h(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, e10.m60659c(), this.f12975m);
            return downloadResult;
        } catch (C9722c e11) {
            C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 SyncException : " + e11.toString() + ", error code : " + e11.m60666c());
            DownloadResult downloadResult2 = new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), e11.m60666c());
            C2981j.m17894h(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, e11.m60666c(), this.f12975m);
            return downloadResult2;
        } catch (Exception e12) {
            if (e12 instanceof C4616s) {
                C12316j0.m74076d().m74077a(strM17958C, this.f12969g, this.f12972j, ((C4616s) e12).m28322f());
            }
            C11839m.m70687e("SingleRequireDownloadCallable", "syncV2 error message:" + e12.getMessage());
            int i10 = C0209d.m1208S0(this.f12967e) ? 2217 : 2028;
            DownloadResult downloadResult3 = new DownloadResult(this.f12971i.getId(), this.f12971i.getName(), i10);
            C2981j.m17894h(this.f12967e, this.f12968f, this.f12969g, this.f12973k, this.f12971i, i10, this.f12975m);
            return downloadResult3;
        }
    }

    /* renamed from: i */
    public String m17775i() {
        return this.f12973k;
    }

    /* renamed from: j */
    public String m17776j() {
        return this.f12966d;
    }

    /* renamed from: k */
    public final void m17777k() throws C9722c {
        if (m17738d() || this.f12979q.m80590c()) {
            throw new C9722c(this.f12979q.m80589b(), "task is aborted", this.f12969g, "require_download_struct");
        }
    }

    /* renamed from: l */
    public final boolean m17778l(UnstructData unstructData) {
        C11839m.m70688i("SingleRequireDownloadCallable", "Enter restoreAndSaveData, downloadFile = " + unstructData.getName());
        File file = new File(this.f12974l);
        if (!file.exists() && !file.mkdirs()) {
            C11839m.m70688i("SingleRequireDownloadCallable", "create file fail");
            return false;
        }
        try {
            boolean zM17779m = m17779m(unstructData);
            C11839m.m70688i("SingleRequireDownloadCallable", "restoreResult = " + zM17779m);
            return zM17779m;
        } catch (Exception e10) {
            C11839m.m70687e("SingleRequireDownloadCallable", "restoreAndSaveData error message:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: m */
    public final boolean m17779m(UnstructData unstructData) throws Exception {
        try {
            C11839m.m70686d("SingleRequireDownloadCallable", "Enter restoreFile, downloadFile = " + unstructData.getName());
            String strM80971t0 = C13452e.m80781L().m80971t0();
            C11060c c11060cM66626a = C11058a.m66626a(this.f12976n, "restoreFile_begin", strM80971t0);
            c11060cM66626a.m66665u("0");
            C13622a.m81968n(this.f12967e, c11060cM66626a);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11060c c11060cM66626a2 = C11058a.m66626a(this.f12976n, "restoreFile_end", strM80971t0);
            c11060cM66626a2.m66665u("0");
            Uri requireDownloadProviderUri = SyncLogicServiceUtil.getRequireDownloadProviderUri(this.f12968f, this.f12969g, unstructData.getName(), this.f12973k);
            if (requireDownloadProviderUri == null) {
                c11060cM66626a2.m66665u(String.valueOf(2229));
                c11060cM66626a2.m66635A("destUri is nul");
                C11839m.m70688i("SingleRequireDownloadCallable", "destUri is nul");
                return false;
            }
            if (!C0209d.m1227Y1(this.f12967e, requireDownloadProviderUri)) {
                c11060cM66626a2.m66665u(String.valueOf(2229));
                c11060cM66626a2.m66635A("TargetApp is not SystemApp");
                C11839m.m70687e("SingleRequireDownloadCallable", "TargetApp is not SystemApp");
                return false;
            }
            return m17780n(new File(this.f12974l + "/" + unstructData.getName()), requireDownloadProviderUri, c11060cM66626a2, "restoreFile Success", jCurrentTimeMillis);
        } finally {
            m17773g(unstructData);
        }
    }

    /* renamed from: n */
    public final boolean m17780n(File file, Uri uri, C11060c c11060c, String str, long j10) throws Throwable {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            C11839m.m70686d("SingleRequireDownloadCallable", "open file restore");
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    assetFileDescriptorOpenAssetFileDescriptor = this.f12967e.getContentResolver().openAssetFileDescriptor(uri, "rwxrwxrwx");
                    if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                        C0209d.m1263i(fileInputStream2);
                        C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                        C0209d.m1263i(null);
                        return false;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                        while (true) {
                            try {
                                int i10 = fileInputStream2.read(bArr);
                                if (i10 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i10);
                            } catch (Exception e10) {
                                e = e10;
                                fileInputStream = fileInputStream2;
                                try {
                                    String string = e.toString();
                                    c11060c.m66665u(String.valueOf(2229));
                                    c11060c.m66635A(string);
                                    C11839m.m70687e("SingleRequireDownloadCallable", "doEachRestore exception:" + string);
                                    C0209d.m1263i(fileInputStream);
                                    C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                                    C0209d.m1263i(fileOutputStream);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    C0209d.m1263i(fileInputStream);
                                    C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                                    C0209d.m1263i(fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                C0209d.m1263i(fileInputStream);
                                C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                                C0209d.m1263i(fileOutputStream);
                                throw th;
                            }
                        }
                        c11060c.m66665u("0");
                        c11060c.m66635A(str);
                        C0209d.m1263i(fileInputStream2);
                        C0209d.m1263i(assetFileDescriptorOpenAssetFileDescriptor);
                        C0209d.m1263i(fileOutputStream);
                    } catch (Exception e11) {
                        e = e11;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                } catch (Exception e12) {
                    e = e12;
                    assetFileDescriptorOpenAssetFileDescriptor = null;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    assetFileDescriptorOpenAssetFileDescriptor = null;
                    fileOutputStream = null;
                }
            } catch (Exception e13) {
                e = e13;
                assetFileDescriptorOpenAssetFileDescriptor = null;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                assetFileDescriptorOpenAssetFileDescriptor = null;
                fileOutputStream = null;
            }
        } else {
            c11060c.m66665u(String.valueOf(2229));
            c11060c.m66635A("zipPath path not find");
            C11839m.m70687e("SingleRequireDownloadCallable", "zipPath path not find");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
        C13622a.m81969o(this.f12967e, c11060c, linkedHashMap);
        return true;
    }
}
