package vc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import cd.C1421d;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.Usage;
import com.huawei.android.hicloud.sync.contact.SyncProcessBase;
import com.huawei.android.hicloud.sync.service.aidl.SerializableMap;
import com.huawei.android.hicloud.sync.service.aidl.SyncData;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicService;
import com.huawei.android.hicloud.sync.service.aidl.SyncLogicServiceUtil;
import com.huawei.android.hicloud.sync.service.aidl.UnstructData;
import com.huawei.android.hicloud.sync.syncimpl.FileProcess;
import com.huawei.android.hicloud.sync.syncutil.C2977f;
import com.huawei.android.hicloud.sync.syncutil.C2980i;
import com.huawei.android.hicloud.sync.syncutil.C2984m;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.AssetList;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import fk.C9721b;
import fk.C9722c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import je.C10812z;
import p015ak.C0209d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;
import sb.C12767a;
import sc.C12771d;
import sc.C12773f;

/* renamed from: vc.f */
/* loaded from: classes3.dex */
public class C13402f extends SyncProcessBase {

    /* renamed from: l */
    public static long f60444l;

    /* renamed from: a */
    public List<String> f60445a;

    /* renamed from: b */
    public List<SyncData> f60446b;

    /* renamed from: c */
    public C2984m f60447c;

    /* renamed from: d */
    public boolean f60448d;

    /* renamed from: e */
    public String f60449e;

    /* renamed from: f */
    public CopyOnWriteArrayList<UnstructData> f60450f;

    /* renamed from: g */
    public ArrayList<UnstructData> f60451g;

    /* renamed from: h */
    public ArrayList<UnstructData> f60452h;

    /* renamed from: i */
    public Map<String, Integer> f60453i;

    /* renamed from: j */
    public ExecutorService f60454j;

    /* renamed from: k */
    public final String f60455k;

    /* renamed from: vc.f$a */
    public class a implements Callable<Boolean> {

        /* renamed from: a */
        public Usage f60456a;

        public a(Usage usage) {
            this.f60456a = usage;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            if (this.f60456a == null) {
                return Boolean.FALSE;
            }
            C11839m.m70688i("SaveResultImpl", "syncV2 SyncDownLoadFileTask download file, RecordId: " + this.f60456a.getRecordId() + ", name: " + this.f60456a.getUsage());
            return C13402f.this.m80539d(this.f60456a);
        }
    }

    public C13402f(Context context, String str, String str2, List<SyncData> list, List<String> list2, boolean z10, String str3, String str4, String str5, String str6, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        super(context, str, str2, str3, str4, str5, concurrentHashMap);
        this.f60445a = new ArrayList(10);
        this.f60446b = new ArrayList(10);
        this.f60447c = null;
        this.f60448d = false;
        this.f60449e = null;
        this.f60450f = new CopyOnWriteArrayList<>();
        this.f60451g = new ArrayList<>();
        this.f60452h = new ArrayList<>();
        this.f60453i = new HashMap();
        this.mContext = context;
        if (list2 != null) {
            this.f60445a = list2;
        }
        if (list != null) {
            this.f60446b = list;
        }
        this.f60448d = z10;
        this.f60455k = str6;
        this.f60449e = this.mContext.getFilesDir() + "/sync/" + this.mDataType + "/sync_download";
        C11839m.m70688i("SaveResultImpl", "Sync type = " + this.mSyncType + ", dataType = " + this.mDataType + ", save size = " + this.f60446b.size() + " delete size = " + this.f60445a.size() + ", isUpload = " + z10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mDataType);
        sb2.append(" Save list: ");
        sb2.append(this.f60446b.toString());
        sb2.append("delete list: ");
        sb2.append(this.f60445a.toString());
        C11839m.m70686d("SaveResultImpl", sb2.toString());
    }

    /* renamed from: b */
    private void m80535b(int i10) {
        C11839m.m70688i("SaveResultImpl", this.mDataType + " CallBack, value = " + i10);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.intent.SENDCALLBACK");
        intent.putExtra("msgType", this.mSyncType);
        if (this.f60448d) {
            intent.putExtra("msgID", 10003);
        } else {
            intent.putExtra("msgID", 10004);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.RESULT_CODE, i10);
        bundle.putString("sync_module_package_name", this.mSyncModulePackageName);
        appendBundleParamToSaveResult(bundle, this.f60455k);
        if (!this.f60448d && i10 == 0) {
            if (!this.f60452h.isEmpty()) {
                CloudSyncUtil.m15988Y0(this.mContext, this.mSyncType, true);
            }
            this.f60451g.addAll(this.f60450f);
            bundle.putParcelableArrayList("unstructresult", this.f60451g);
            bundle.putParcelableArrayList("unstructfailresult", this.f60452h);
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(SyncLogicServiceUtil.buildFailErrorCodeMap(this.f60453i));
            bundle.putSerializable("fail_error_code_map", serializableMap);
            C11839m.m70688i("SaveResultImpl", this.mDataType + " failIdMap.size() : " + this.f60453i.size());
        }
        if (i10 == 0) {
            C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 0, "", this.operationType, "batch_of_local_download_unstruct", this.traceId);
        }
        C11839m.m70688i("SaveResultImpl", this.mDataType + " start send msg");
        intent.putExtra("bundle", bundle);
        C13108a.m78878b(this.mContext).m78881d(intent);
        CloudSyncUtil.m15993a1(this.mContext, this.mSyncType, i10);
    }

    /* renamed from: h */
    private void m80536h() {
        C11839m.m70688i("SaveResultImpl", "Enter restoreAndSaveData");
        C12773f c12773f = new C12773f();
        try {
            boolean zM80537i = m80537i();
            C11839m.m70688i("SaveResultImpl", "restoreResult = " + zM80537i);
            if (!zM80537i || SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
                return;
            }
            c12773f.m76669k(this.f60450f, this.mDataType);
        } catch (Exception e10) {
            C11839m.m70687e("SaveResultImpl", "restoreAndSaveData error message:" + e10.getMessage());
        }
    }

    /* renamed from: i */
    private boolean m80537i() throws Exception {
        C11839m.m70686d("SaveResultImpl", "Enter restoreFile");
        boolean zM17861d = C2977f.m17861d(this.f60449e, this.traceId, this.mContext);
        C11839m.m70686d("SaveResultImpl", "file to zip result = " + zM17861d);
        String strM80971t0 = C13452e.m80781L().m80971t0();
        C11060c c11060cM66626a = C11058a.m66626a(this.traceId, "restoreFile_begin", strM80971t0);
        c11060cM66626a.m66665u("0");
        C13622a.m81968n(this.mContext, c11060cM66626a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11060c c11060cM66626a2 = C11058a.m66626a(this.traceId, "restoreFile_end", strM80971t0);
        if (!zM17861d) {
            c11060cM66626a2.m66665u(String.valueOf(2228));
            c11060cM66626a2.m66635A("file to zip result false");
            C13622a.m81968n(this.mContext, c11060cM66626a2);
            return false;
        }
        Uri normalDownloadProviderUri = SyncLogicServiceUtil.getNormalDownloadProviderUri(this.mSyncType, this.mDataType, this.mSyncModulePackageName);
        if (normalDownloadProviderUri == null) {
            c11060cM66626a2.m66665u(String.valueOf(2229));
            c11060cM66626a2.m66635A("destUri is nul");
            C13622a.m81968n(this.mContext, c11060cM66626a2);
            C11839m.m70688i("SaveResultImpl", "destUri is nul");
            return false;
        }
        if (C0209d.m1227Y1(this.mContext, normalDownloadProviderUri)) {
            return startSyncRestoreFile(new File(this.f60449e + "/sync_download.zip"), normalDownloadProviderUri, c11060cM66626a2, "restoreFile Success", jCurrentTimeMillis);
        }
        c11060cM66626a2.m66665u(String.valueOf(2229));
        c11060cM66626a2.m66635A("TargetApp is not SystemApp");
        C13622a.m81968n(this.mContext, c11060cM66626a2);
        C11839m.m70687e("SaveResultImpl", "TargetApp is not SystemApp");
        return false;
    }

    /* renamed from: c */
    public final void m80538c(List<UnstructData> list, List<Usage> list2) throws C9722c {
        C11839m.m70688i("SaveResultImpl", "syncV2 Enter downAndRestoreAssetFile data");
        File file = new File(this.f60449e);
        if (!FileProcess.m17795b(file)) {
            C11839m.m70688i("SaveResultImpl", "syncV2 delete dir fail");
            this.f60452h.addAll(list);
        } else if (file.exists() || file.mkdirs()) {
            m80540e(list2);
            m80536h();
        } else {
            C11839m.m70688i("SaveResultImpl", "syncV2 create file fail");
            this.f60452h.addAll(list);
        }
    }

    /* renamed from: d */
    public final Boolean m80539d(Usage usage) throws C9722c {
        if (usage == null) {
            C11839m.m70689w("SaveResultImpl", "syncV2 downLoadAssetFile usage is null ");
            return Boolean.FALSE;
        }
        String str = this.f60449e + "/" + usage.getUsage();
        C11839m.m70686d("SaveResultImpl", "syncV2 downLoadAssetFile localPath = " + str);
        try {
            isCancel();
            if (!C0209d.m1208S0(this.mContext)) {
                C11839m.m70689w("SaveResultImpl", "downLoadAssetFile network not connect error ");
                throw new C9722c(2028, "network not connect error", this.mDataType, "local_download_struct");
            }
            String strM17958C = DriveSyncUtil.m17958C(this.mSyncType);
            AssetList assetList = getAssetList(usage.getRecordId(), usage.getUsage(), "local_download_struct");
            if (assetList == null) {
                C11839m.m70689w("SaveResultImpl", "syncV2 downAndRestoreAssetFile Cloud no file : guid:" + usage.getRecordId() + ",name:" + usage.getUsage());
                m80541f(usage, 3207);
                return Boolean.FALSE;
            }
            List<Asset> assets = assetList.getAssets();
            if (assets == null || assets.size() <= 0) {
                C11839m.m70689w("SaveResultImpl", "syncV2 downAndRestoreAssetFile Cloud no file : guid:" + usage.getRecordId() + ",name:" + usage.getUsage());
                m80541f(usage, 3207);
                return Boolean.FALSE;
            }
            Asset asset = assets.get(0);
            new C1421d(CloudSyncUtil.m15961L(this.mSyncType), this.traceId, this.mDataType, usage.getRecordId(), strM17958C).m8268a(asset, str, new C13404h(), usage.getUsage(), this.mSyncType, this.mSyncModulePackageName, "local_download_struct");
            if (asset.getResource() != null) {
                f60444l += asset.getResource().getLength().longValue();
            }
            C12767a.m76619c().m76622d(this.mSyncType);
            UnstructData unstructData = usage.getUnstructData();
            if (unstructData != null) {
                this.f60450f.add(unstructData);
            }
            C11839m.m70688i("SaveResultImpl", "syncV2 downLoadAssetFile downSuc : " + this.f60450f.size());
            return Boolean.TRUE;
        } catch (C9721b e10) {
            C11839m.m70687e("SaveResultImpl", "syncV2 downLoadAssetFile CException : " + e10.getMessage() + ", error code : " + e10.m60659c() + ", recordId = " + usage.getRecordId() + ", fileName = " + usage.getUsage());
            m80541f(usage, e10.m60659c());
            return Boolean.FALSE;
        } catch (C9722c e11) {
            C11839m.m70687e("SaveResultImpl", "syncV2 downLoadAssetFile SyncException : " + e11.getMessage() + ", error code : " + e11.m60666c() + ", recordId = " + usage.getRecordId() + ", fileName = " + usage.getUsage());
            m80541f(usage, e11.m60666c());
            return Boolean.FALSE;
        } catch (Exception e12) {
            C11839m.m70687e("SaveResultImpl", "syncV2 downLoadAssetFile error message:" + e12.getMessage() + ", recordId = " + usage.getRecordId() + ", fileName = " + usage.getUsage());
            m80541f(usage, C0209d.m1208S0(this.mContext) ? 2263 : 2028);
            return Boolean.FALSE;
        }
    }

    /* renamed from: e */
    public final void m80540e(List<Usage> list) throws C9722c {
        ExecutorService executorService;
        if (list == null || list.isEmpty()) {
            C11839m.m70689w("SaveResultImpl", "syncV2 downLoadAssetFileList: downDataList.size is 0 or null");
            return;
        }
        C11839m.m70688i("SaveResultImpl", "syncV2 downLoadAssetFileList: downDataList.size = " + list.size());
        if (!C0209d.m1208S0(this.mContext)) {
            C11839m.m70689w("SaveResultImpl", "downLoadAssetFileList network not connect error ");
            throw new C9722c(2028, "network not connect error", this.mDataType, "local_download_struct");
        }
        int iM17960E = 0;
        try {
            try {
                if (this.f60454j == null) {
                    iM17960E = DriveSyncUtil.m17960E();
                    C11839m.m70688i("SaveResultImpl", "syncV2 downExecutor null, syncType: " + this.mSyncType + ",dataType: " + this.mDataType + ",create threadsNum: " + iM17960E);
                    this.f60454j = Executors.newFixedThreadPool(iM17960E);
                    DriveSyncUtil.m17996h(iM17960E);
                }
                ArrayList arrayList = new ArrayList();
                for (Usage usage : list) {
                    isCancel();
                    arrayList.add(this.f60454j.submit(new a(usage)));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((Future) it.next()).get();
                    } catch (InterruptedException | ExecutionException e10) {
                        C11839m.m70687e("SaveResultImpl", "syncV2 downLoadFileList: " + e10.toString());
                    }
                }
                C11839m.m70686d("SaveResultImpl", "syncV2 mDownloadAssetExecutor shutdown ");
                executorService = this.f60454j;
                if (executorService == null) {
                    return;
                }
            } catch (Throwable th2) {
                C11839m.m70686d("SaveResultImpl", "syncV2 mDownloadAssetExecutor shutdown ");
                ExecutorService executorService2 = this.f60454j;
                if (executorService2 != null) {
                    executorService2.shutdown();
                    DriveSyncUtil.m17989d0(iM17960E);
                }
                throw th2;
            }
        } catch (Exception e11) {
            C11839m.m70687e("SaveResultImpl", "syncV2 downLoadFile: " + e11.toString());
            C11839m.m70686d("SaveResultImpl", "syncV2 mDownloadAssetExecutor shutdown ");
            executorService = this.f60454j;
            if (executorService == null) {
                return;
            }
        }
        executorService.shutdown();
        DriveSyncUtil.m17989d0(iM17960E);
    }

    /* renamed from: f */
    public final void m80541f(Usage usage, int i10) {
        UnstructData unstructData = usage.getUnstructData();
        if (unstructData != null) {
            if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName)) {
                this.f60453i.put(unstructData.getId(), Integer.valueOf(i10));
            }
            this.f60452h.add(unstructData);
        }
    }

    /* renamed from: g */
    public final void m80542g() throws C9722c {
        C11839m.m70688i("SaveResultImpl", "syncV2 Enter processAsset");
        List<SyncData> list = this.f60446b;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<UnstructData> arrayList2 = new ArrayList<>();
        List<Usage> arrayList3 = new ArrayList<>();
        for (SyncData syncData : this.f60446b) {
            C11839m.m70686d("SaveResultImpl", "syncV2 processAsset guid :" + syncData.getGuid() + ", data id = " + syncData.getLuid() + ", deleteFileList = " + syncData.getDeleteFileList() + ", downFileList = " + syncData.getDownFileList());
            arrayList.addAll(syncData.getDeleteFileList());
            List<UnstructData> downFileList = syncData.getDownFileList();
            arrayList2.addAll(downFileList);
            for (UnstructData unstructData : downFileList) {
                arrayList3.add(new Usage(syncData.getGuid(), unstructData.getName(), unstructData));
            }
        }
        C11839m.m70688i("SaveResultImpl", "syncV2 processAsset deleteFileList size " + arrayList.size() + ", downFileList size " + arrayList2.size() + ",usagesArrayList size :" + arrayList3.size());
        try {
            isCancel();
            if (arrayList.size() > 0 && !SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName)) {
                C11839m.m70688i("SaveResultImpl", "syncV2 processAsset , deleteData = " + arrayList.toString());
                new C12773f().m76664f(arrayList, this.mDataType);
            }
            isCancel();
            if (arrayList2.size() > 0) {
                C2980i.m17882q(this.mReportEndInfo, true);
                m80538c(arrayList2, arrayList3);
            }
        } catch (C9722c e10) {
            C11839m.m70687e("SaveResultImpl", "syncV2 processAsset error code: " + e10.m60666c() + " message:" + e10.getMessage());
            throw new C9722c(e10.m60666c(), "SaveResultImpl processAsset result fail " + e10.getMessage(), this.mSyncType, "local_download_struct");
        } catch (Exception e11) {
            C11839m.m70687e("SaveResultImpl", "syncV2 processAsset exception message:" + e11.getMessage());
            throw new C9722c(2263, "SaveResultImpl processAsset result fail " + e11.getMessage(), this.mSyncType, "local_download_struct");
        }
    }

    /* renamed from: j */
    public int m80543j() {
        File file;
        this.f60447c = new C2984m();
        boolean zIsPersistedDataSavedInCloudSyncSDK = SyncLogicService.isPersistedDataSavedInCloudSyncSDK(this.mSyncModulePackageName);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String message = "";
        int iM17923a = 0;
        try {
            try {
                isCancel();
                if (!zIsPersistedDataSavedInCloudSyncSDK) {
                    m80544k();
                }
                if (!this.f60448d) {
                    isCancel();
                    m80542g();
                }
                isCancel();
                m80535b(0);
                file = new File(this.f60449e);
            } catch (C9722c e10) {
                iM17923a = this.f60447c.m17923a(e10);
                if (SyncLogicService.cloudSyncSDKHasCollaborativeAbility(this.mSyncModulePackageName)) {
                    iM17923a = e10.m60666c();
                }
                message = e10.getMessage();
                C10812z.m65841j(this.mContext, e10.m60668e(), this.mDataType, e10.m60666c(), e10.m60667d(), e10.getMessage(), this.operationType, e10.m60665b(), this.traceId);
                m80535b(iM17923a);
                file = new File(this.f60449e);
            } catch (Exception e11) {
                iM17923a = 5;
                message = e11.getMessage();
                C11839m.m70687e("SaveResultImpl", this.mDataType + " Exception occurred = " + e11.toString());
                C10812z.m65840i(this.mContext, this.mSyncType, this.mDataType, 5, e11.toString(), this.operationType, "local_download_struct", this.traceId);
                m80535b(5);
                file = new File(this.f60449e);
            }
            FileProcess.m17795b(file);
            C2980i.m17879n(this.mReportEndInfo, iM17923a, message);
            C2980i.m17873h(this.mReportEndInfo, this.mDataType, f60444l);
            C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            return iM17923a;
        } catch (Throwable th2) {
            m80535b(0);
            FileProcess.m17795b(new File(this.f60449e));
            C2980i.m17879n(this.mReportEndInfo, 0, "");
            C2980i.m17873h(this.mReportEndInfo, this.mDataType, f60444l);
            C2980i.m17874i(this.mReportEndInfo, this.mDataType, System.currentTimeMillis() - jCurrentTimeMillis);
            throw th2;
        }
    }

    /* renamed from: k */
    public void m80544k() throws C9722c {
        C12771d c12771d = new C12771d();
        try {
            List<String> list = this.f60445a;
            if (list != null && list.size() > 0) {
                C11839m.m70688i("SaveResultImpl", "updateLocalEtag , process deleteData");
                c12771d.m76643e(this.f60445a, this.mDataType);
                C11839m.m70687e("SaveResultImpl", "updateLocaldb , delete num = " + this.f60445a.size());
                new C12773f().m76663e(this.f60445a, this.mDataType);
            }
            List<SyncData> list2 = this.f60446b;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            C11839m.m70688i("SaveResultImpl", "updateLocalEtag , process updateData");
            C11839m.m70688i("SaveResultImpl", "mSaveResult = " + this.f60446b.toString() + ", mDataType = " + this.mDataType);
            c12771d.m76644f(this.f60446b, this.mDataType);
            C11839m.m70688i("SaveResultImpl", "updateLocaldb , update num = " + this.f60446b.size());
        } catch (Exception e10) {
            C11839m.m70687e("SaveResultImpl", "database error message:" + e10.getMessage());
            throw new C9722c(2007, "SaveResultImpl update cloud process result fail " + e10.getMessage(), this.mSyncType, "local_download_struct");
        }
    }
}
