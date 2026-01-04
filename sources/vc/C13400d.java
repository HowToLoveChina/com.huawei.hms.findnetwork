package vc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import cd.C1421d;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.ToolSyncService;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncimpl.FileProcess;
import com.huawei.android.hicloud.sync.syncutil.C2977f;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import fk.C9722c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import je.C10812z;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;
import sb.C12767a;
import sc.C12773f;

/* renamed from: vc.d */
/* loaded from: classes3.dex */
public class C13400d extends SyncProcessBase {

    /* renamed from: a */
    public C2984m f60425a;

    /* renamed from: b */
    public String f60426b;

    /* renamed from: c */
    public List<UnstructData> f60427c;

    /* renamed from: d */
    public ArrayList<UnstructData> f60428d;

    /* renamed from: e */
    public ArrayList<UnstructData> f60429e;

    /* renamed from: f */
    public Map<String, Integer> f60430f;

    /* renamed from: g */
    public final String f60431g;

    /* renamed from: h */
    public int f60432h;

    public C13400d(Context context, String str, String str2, List<UnstructData> list, String str3, String str4, String str5, String str6, int i10, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f60425a = null;
        this.f60426b = null;
        this.f60427c = new ArrayList();
        this.f60428d = new ArrayList<>();
        this.f60429e = new ArrayList<>();
        this.f60430f = new HashMap();
        this.f60432h = -1;
        this.mContext = context;
        if (list != null) {
            this.f60427c = list;
        }
        this.f60431g = str6;
        this.f60432h = i10;
        this.f60426b = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_download";
        C11839m.m70686d("QueryUnstructDataImpl", "SaveResultImpl ,type = " + this.mSyncType + ", dataType = " + this.mDataType + ", downSuc = " + this.f60427c.toString());
    }

    /* renamed from: a */
    private void m80515a(int i10) {
        C11839m.m70688i("QueryUnstructDataImpl", "CallBack, value = " + i10);
        Intent intent = new Intent();
        if (m80519e()) {
            intent.setAction("com.huawei.android.hicloud.intent.TOOLSYNCCALLBACK");
        } else {
            intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        }
        intent.putExtra("msgType", this.mSyncType);
        intent.putExtra("msgID", 10005);
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        bundle.putString("syncType", this.mSyncType);
        bundle.putString("dataType", this.mDataType);
        bundle.putString("callbackUuid", this.f60431g);
        if (i10 == 0) {
            bundle.putParcelableArrayList("unstructresult", this.f60428d);
            bundle.putParcelableArrayList("unstructfailresult", this.f60429e);
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(this.f60430f));
            bundle.putSerializable("fail_error_code_map", serializableMap);
            C11839m.m70686d("QueryUnstructDataImpl", "failIdMap : " + this.f60430f.toString());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isCharging", String.valueOf(C0209d.m1196O0(this.mContext)));
            C10812z.m65842k(this.mContext, this.mSyncType, this.mDataType, 0, "", "", this.operationType, "batch_of_single_downUnstruct_end", this.traceId, linkedHashMap, false);
        }
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
    }

    /* renamed from: b */
    public final void m80516b(InputStream inputStream, AssetFileDescriptor assetFileDescriptor, OutputStream outputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e10) {
                C11839m.m70687e("QueryUnstructDataImpl", "doEachRestore exception: " + e10.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e11) {
                C11839m.m70687e("QueryUnstructDataImpl", "doEachRestore exception: " + e11.toString());
            }
        }
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (Exception e12) {
                C11839m.m70687e("QueryUnstructDataImpl", "doEachRestore exception: " + e12.toString());
            }
        }
    }

    /* renamed from: c */
    public final void m80517c(List<UnstructData> list) throws C9722c {
        String str;
        List<Asset> assets;
        Asset asset;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (UnstructData unstructData : list) {
            try {
                str = this.f60426b + "/" + unstructData.getName();
                C11839m.m70686d("QueryUnstructDataImpl", "syncV2 localPath = " + str);
                isCancel();
            } catch (C9721b e10) {
                C11839m.m70687e("QueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile CException : " + e10.toString() + ", error code : " + e10.m60659c() + ", recordId = " + unstructData.getUnstructUuid() + ", fileName = " + unstructData.getName());
                m80518d(unstructData, e10.m60659c());
            } catch (C9722c e11) {
                C11839m.m70687e("QueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile syncException : " + e11.toString() + ", error code : " + e11.m60666c() + ", recordId = " + unstructData.getUnstructUuid() + ", fileName = " + unstructData.getName());
                m80518d(unstructData, e11.m60666c());
            } catch (Exception e12) {
                C11839m.m70687e("QueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile error message:" + e12.getMessage() + ", recordId = " + unstructData.getUnstructUuid() + ", fileName = " + unstructData.getName());
                m80518d(unstructData, C0209d.m1208S0(this.mContext) ? 2263 : 2028);
            }
            if (!C0209d.m1208S0(this.mContext)) {
                C11839m.m70689w("QueryUnstructDataImpl", "downAndRestoreAssetFile network not connect error ");
                throw new C9722c(2028, "network not connect error", this.mDataType, "single_download_struct");
            }
            String strM17958C = DriveSyncUtil.m17958C(this.mSyncType);
            AssetList assetList = getAssetList(unstructData.getUnstructUuid(), unstructData.getName(), "single_download_struct");
            if (assetList == null || (assets = assetList.getAssets()) == null || assets.size() <= 0 || (asset = assets.get(0)) == null) {
                C11839m.m70687e("QueryUnstructDataImpl", "syncV2 downAndRestoreAssetFile Cloud no file : guid:" + unstructData.getUnstructUuid() + ",name:" + unstructData.getName());
                m80518d(unstructData, 3207);
            } else {
                new C1421d(CloudSyncUtil.m15961L(this.mSyncType), this.traceId, this.mDataType, unstructData.getUnstructUuid(), strM17958C).m8268a(asset, str, new C13404h(), unstructData.getName(), this.mSyncType, this.mSyncModulePackageName, "single_download_struct");
                C12767a.m76619c().m76622d(this.mSyncType);
                this.f60428d.add(unstructData);
            }
        }
        m80521g();
    }

    /* renamed from: d */
    public final void m80518d(UnstructData unstructData, int i10) {
        if (unstructData != null) {
            if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName) || ToolSyncService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName)) {
                this.f60430f.put(unstructData.getId(), Integer.valueOf(i10));
            }
            this.f60429e.add(unstructData);
        }
    }

    /* renamed from: e */
    public final boolean m80519e() {
        return this.f60432h >= 0;
    }

    /* renamed from: f */
    public int m80520f() throws Throwable {
        File file;
        C11839m.m70688i("QueryUnstructDataImpl", "Begin saveResult");
        this.f60425a = new C2984m();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("downloadSize", String.valueOf(this.f60427c.size()));
        linkedHashMap.put("isCharging", String.valueOf(C0209d.m1196O0(this.mContext)));
        C10812z.m65842k(this.mContext, this.mSyncType, this.mDataType, 0, "", "", this.operationType, "batch_of_single_downUnstruct_begin", this.traceId, linkedHashMap, false);
        int iM17923a = 0;
        try {
            try {
                isCancel();
                m80517c(this.f60427c);
                file = new File(this.f60426b);
            } catch (C9722c e10) {
                iM17923a = this.f60425a.m17923a(e10);
                if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName) || ToolSyncService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName)) {
                    iM17923a = e10.m60666c();
                }
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
                file = new File(this.f60426b);
            } catch (Exception e11) {
                try {
                    C11839m.m70687e("QueryUnstructDataImpl", "Exception occurred = " + e11.toString());
                    Context context = this.mContext;
                    String str = this.mDataType;
                    C10812z.m65840i(context, str, str, 5, e11.toString(), this.operationType, "single_download_struct", this.traceId);
                    FileProcess.m17795b(new File(this.f60426b));
                    m80515a(5);
                    iM17923a = 5;
                } catch (Throwable th2) {
                    th = th2;
                    iM17923a = 5;
                    FileProcess.m17795b(new File(this.f60426b));
                    m80515a(iM17923a);
                    throw th;
                }
            }
            FileProcess.m17795b(file);
            m80515a(iM17923a);
            C11839m.m70688i("QueryUnstructDataImpl", "End saveResult , value = " + iM17923a);
            return iM17923a;
        } catch (Throwable th3) {
            th = th3;
            FileProcess.m17795b(new File(this.f60426b));
            m80515a(iM17923a);
            throw th;
        }
    }

    /* renamed from: g */
    public final void m80521g() {
        C11839m.m70688i("QueryUnstructDataImpl", "Enter restoreAndSaveData");
        C12773f c12773f = new C12773f();
        try {
            boolean zM80522h = m80522h();
            C11839m.m70688i("QueryUnstructDataImpl", "restoreResult = " + zM80522h);
            if (!zM80522h || SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName) || ToolSyncService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
                return;
            }
            c12773f.m76669k(this.f60428d, this.mDataType);
        } catch (Exception e10) {
            C11839m.m70687e("QueryUnstructDataImpl", "restoreAndSaveData error message:" + e10.getMessage());
        }
    }

    /* renamed from: h */
    public final boolean m80522h() throws Exception {
        C11839m.m70686d("QueryUnstructDataImpl", "Enter restoreFile");
        boolean zM17861d = C2977f.m17861d(this.f60426b, this.traceId, this.mContext);
        C11839m.m70686d("QueryUnstructDataImpl", "file to zip result = " + zM17861d);
        String str = this.traceId;
        String strM66627b = (str == null || str.isEmpty()) ? C11058a.m66627b("00000") : this.traceId;
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C11060c c11060cM66626a = C11058a.m66626a(strM66627b, "restoreFile_begin", strM80971t0);
        c11060cM66626a.m66665u("0");
        C13622a.m81968n(this.mContext, c11060cM66626a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11060c c11060cM66626a2 = C11058a.m66626a(strM66627b, "restoreFile_end", strM80971t0);
        c11060cM66626a2.m66665u("0");
        if (!zM17861d) {
            return false;
        }
        Uri normalDownloadProviderUri = SyncLogicServiceUtil.getNormalDownloadProviderUri(this.mSyncType, this.mDataType, this.mSyncModulePackageName);
        if (normalDownloadProviderUri == null) {
            c11060cM66626a2.m66665u(String.valueOf(2229));
            c11060cM66626a2.m66635A("destUri is nul");
            C11839m.m70688i("QueryUnstructDataImpl", "destUri is nul");
            return false;
        }
        if (!C0209d.m1227Y1(this.mContext, normalDownloadProviderUri)) {
            c11060cM66626a2.m66665u(String.valueOf(2229));
            c11060cM66626a2.m66635A("TargetApp is not SystemApp");
            C11839m.m70687e("QueryUnstructDataImpl", "TargetApp is not SystemApp");
            return false;
        }
        return m80523i(new File(this.f60426b + "/sync_download.zip"), normalDownloadProviderUri, c11060cM66626a2, "restoreFile Success", jCurrentTimeMillis);
    }

    /* renamed from: i */
    public final boolean m80523i(File file, Uri uri, C11060c c11060c, String str, long j10) throws Throwable {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            C11839m.m70686d("QueryUnstructDataImpl", "open file restore");
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    assetFileDescriptorOpenAssetFileDescriptor = this.mContext.getContentResolver().openAssetFileDescriptor(uri, "rwxrwxrwx");
                    if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                        m80516b(fileInputStream2, assetFileDescriptorOpenAssetFileDescriptor, null);
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
                                    C11839m.m70687e("QueryUnstructDataImpl", "doEachRestore exception:" + string);
                                    m80516b(fileInputStream, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                                    return false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    m80516b(fileInputStream, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                m80516b(fileInputStream, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                                throw th;
                            }
                        }
                        c11060c.m66665u("0");
                        c11060c.m66635A(str);
                        m80516b(fileInputStream2, assetFileDescriptorOpenAssetFileDescriptor, fileOutputStream);
                        try {
                            this.mContext.getContentResolver().update(uri, new ContentValues(), null, null);
                        } catch (Exception e11) {
                            C11839m.m70687e("QueryUnstructDataImpl", "startRestoreFile update exception:" + e11.toString());
                        }
                    } catch (Exception e12) {
                        e = e12;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                    }
                } catch (Exception e13) {
                    e = e13;
                    assetFileDescriptorOpenAssetFileDescriptor = null;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    assetFileDescriptorOpenAssetFileDescriptor = null;
                    fileOutputStream = null;
                }
            } catch (Exception e14) {
                e = e14;
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
            C11839m.m70687e("QueryUnstructDataImpl", "zipPath path not find");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("useTime", String.valueOf(System.currentTimeMillis() - j10));
        C13622a.m81969o(this.mContext, c11060c, linkedHashMap);
        return true;
    }
}
