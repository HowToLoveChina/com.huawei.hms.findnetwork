package com.huawei.android.hicloud.album.service.logic;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.HttpErrorHandler;
import com.huawei.android.hicloud.album.service.hihttp.able.Requestable;
import com.huawei.android.hicloud.album.service.hihttp.rest.OnResponseListener;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.FileDownloadStatus;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.album.service.p075vo.SettingParams;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import com.huawei.android.hicloud.album.service.p075vo.SmartAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.SmartTagData;
import com.huawei.android.hicloud.album.service.p075vo.SyncPrompt;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.album.service.report.OpsReport;
import com.huawei.android.hicloud.constant.CommonConstants;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5863b6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009a8.C0067e;
import p009a8.C0074l;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p220d8.C9047a;
import p220d8.C9048b;
import p220d8.C9049c;
import p220d8.C9050d;
import p220d8.C9051e;
import p220d8.C9052f;
import p281f8.C9673j;
import p281f8.C9674k;
import p292fn.C9733f;
import p312g8.C9894e;
import p429kk.C11058a;
import p511o6.C11820b;
import p635s7.C12721a0;
import p635s7.C12736i;
import p664u0.C13108a;
import p681uj.C13194k;
import p681uj.C13195l;
import p681uj.C13199p;
import p701v6.AbstractC13354a;
import p709vj.C13452e;
import p731w7.AbstractC13540g;
import p731w7.C13542i;
import p801y7.C13916d;

/* loaded from: classes2.dex */
public class CloudAlbumSdkLogic implements Requestable, HttpErrorHandler {
    private static final int SHARE_POOL_SIZE = 1;
    private static final String TAG = "CloudAlbumSdkLogic";
    private static final int THREAD_POOL_SIZE = 3;
    private CallbackHandler callbackHandler;
    private C9047a commonServiceLogic;
    private Context context;
    private C9048b generalSyncServiceLogic;
    private C13542i requestQueue;
    private C13542i shareRequestQueue;
    private C9050d shareServiceLogic;
    private C9051e shareSyncLogic;
    private C9674k syncStrategy;
    private C9052f tagSyncLogic;

    /* renamed from: com.huawei.android.hicloud.album.service.logic.CloudAlbumSdkLogic$a */
    public static /* synthetic */ class C2419a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f11558a;

        static {
            int[] iArr = new int[C9674k.b.values().length];
            f11558a = iArr;
            try {
                iArr[C9674k.b.CAN_START_SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11558a[C9674k.b.SYNC_STOPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11558a[C9674k.b.STOP_DOWNLOAD_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CloudAlbumSdkLogic(Context context, CallbackHandler callbackHandler, C9674k c9674k) {
        this.context = context;
        this.callbackHandler = callbackHandler;
        this.syncStrategy = c9674k;
        C13542i c13542i = new C13542i(3);
        this.requestQueue = c13542i;
        c13542i.m81468c();
        C13542i c13542i2 = new C13542i(1);
        this.shareRequestQueue = c13542i2;
        c13542i2.m81468c();
        this.commonServiceLogic = new C9047a(context, callbackHandler, this);
        this.generalSyncServiceLogic = new C9048b(context, callbackHandler, this);
        this.shareSyncLogic = new C9051e(context, callbackHandler, this);
        this.shareServiceLogic = new C9050d(context, callbackHandler, this);
        this.tagSyncLogic = new C9052f(context, callbackHandler, this);
    }

    private void cancelAllRequest() {
        this.requestQueue.m81467b();
        this.shareRequestQueue.m81467b();
    }

    private void sendDeleteRepeat(List<FileData> list, String str) {
        Bundle bundleM76562x = C12736i.m76562x(list, 1005, "delete repeat");
        bundleM76562x.putString("sessionId", str);
        this.callbackHandler.sendMessage(9132, bundleM76562x);
    }

    private void sendDownloadFail(FileData fileData, int i10) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("FileInfo", fileData);
        bundle.putInt("ResolutionType", i10);
        bundle.putParcelable("HttpResult", new HttpResult(200, 14, null));
        this.callbackHandler.sendMessage(9143, bundle);
    }

    private void sendModifyRepeat(List<FileData> list, String str) {
        Bundle bundleM76542A = C12721a0.m76542A(list, 1003, "modify repeat");
        bundleM76542A.putString("sessionId", str);
        this.callbackHandler.sendMessage(9132, bundleM76542A);
    }

    private void sendNonsupport(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", 0);
        bundle.putInt("DisableQueryType", i10);
        bundle.putString("sessionId", str);
        bundle.putInt("disableStatus", -1);
        bundle.putLong("DisableTime", 0L);
        bundle.putInt("Remain", 0);
        this.callbackHandler.sendMessage(9060, bundle);
    }

    private void sendUploadComplete(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        this.callbackHandler.sendMessage(9034, bundle);
    }

    private void sendUploadRepeat(FileData fileData, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        bundle.putParcelable("FileInfo", fileData);
        bundle.putParcelable("HttpResult", new HttpResult(200, 1006, "upload repeat"));
        this.callbackHandler.sendMessage(9148, bundle);
    }

    private void sendUploadShareComplete(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        this.callbackHandler.sendMessage(9039, bundle);
    }

    private void sendUploadShareRepeat(FileData fileData, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", str);
        bundle.putParcelable("FileInfo", fileData);
        bundle.putParcelable("HttpResult", new HttpResult(200, 1006, "upload repeat"));
        this.callbackHandler.sendMessage(9158, bundle);
    }

    private void stopAllSync(int i10, boolean z10) {
        C1120a.m6677i(TAG, "stopAllSync: " + i10);
        cancelAllRequest();
        stopUpload(i10, z10);
    }

    private void updateSpaceSize(long j10, long j11) {
        C1136q.b.m7112x1(this.context, "userCapacityUsed", j10);
        C1136q.b.m7112x1(this.context, "userCapacityTotal", j11);
        C1136q.b.m7112x1(this.context, "userCapacityRecordTime", System.currentTimeMillis());
    }

    public void addShareReceiver(ShareAlbumData shareAlbumData, List<ShareReceiverData> list) throws RemoteException {
        this.shareServiceLogic.m57091n(shareAlbumData, list, 0);
    }

    public void albumVersionReset() throws InterruptedException, SQLException {
        if (System.currentTimeMillis() - C1136q.m6968i() < C5863b6.g.f26453g) {
            C1120a.m6676e(TAG, "albumVersionReset interval");
        } else {
            C1136q.m6944B(System.currentTimeMillis());
            CloudAlbumManager.m14456v().m14479Y(this.context);
        }
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.able.HttpErrorHandler
    public String atInvalid(AbstractC13354a abstractC13354a) {
        C1120a.m6677i(TAG, "Deal atInvalid!");
        try {
            C13195l.m79272J().m79325o0(abstractC13354a.m80108g());
            C1120a.m6677i(TAG, " [AT OPERATION] At invalid, retry");
            return abstractC13354a.mo76565p();
        } catch (C13199p e10) {
            C1120a.m6676e(TAG, "atInvalid auth error: " + e10.getMessage());
            this.stInvalid(false);
            return null;
        } catch (Exception e11) {
            C1120a.m6676e(TAG, "sessionFailedHandle request task error: " + e11.getMessage());
            return null;
        }
    }

    public void cancelDownload(List<FileData> list) {
        new C9049c(this.context, this.callbackHandler).m57062d(C9894e.m61401d(list, false, true));
    }

    public void cancelDownloadAll() {
        new C9049c(this.context, this.callbackHandler).m57063e();
    }

    public void cancelReceivedShare(ShareAlbumData shareAlbumData) throws RemoteException {
        this.shareServiceLogic.m57080b(shareAlbumData);
    }

    public void checkAccount(List<String> list) {
        this.shareServiceLogic.m57081c(list);
    }

    public void copyGeneralFiles(List<FileData> list, String str, String str2, long j10, long j11) {
        this.generalSyncServiceLogic.m57036c(list, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2, j10, j11);
    }

    public void createBatch(String str, String str2, String str3) {
        this.shareServiceLogic.m57082d(str, str2, str3);
    }

    public void createGeneralAlbums(List<GeneralAlbumData> list, String str, String str2) {
        this.generalSyncServiceLogic.m57037d(list, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
    }

    public void createGeneralFiles(List<FileData> list, String str, boolean z10, String str2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            FileData next = it.next();
            if (next != null) {
                String strM6841w = C1122c.m6841w(next);
                C1120a.m6675d(TAG, "createGeneralFiles tempFileKey: " + strM6841w);
                Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 4);
                if (numM15193q != null && numM15193q.intValue() > 10) {
                    arrayList.add(next);
                    sb2.append(C1122c.m6818p0(next.getFileName()));
                    sb2.append("_");
                    sb2.append("create too much");
                    sb2.append(";");
                    it.remove();
                } else if (SyncSessionManager.m15153t().m15157D("cloudphoto.file.batchcreate", str2, next.getAlbumId())) {
                    C1120a.m6676e(TAG, "createGeneralFiles albumId not exist: " + next.getAlbumId() + " " + next.getUniqueId());
                    arrayList.add(next);
                    sb2.append(next.getAlbumId());
                    sb2.append("_");
                    sb2.append("not exist");
                    sb2.append(";");
                    it.remove();
                }
            }
        }
        C1120a.m6677i(TAG, "createGeneralFiles currentUploadFiles: " + list.size());
        SyncSessionManager.m15153t().m15190n().put("uploadStartTime", Long.valueOf(System.currentTimeMillis()));
        C1120a.m6677i(TAG, "upload rate,traceId:" + str2);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sendUploadRepeat((FileData) it2.next(), str2);
        }
        if (!arrayList.isEmpty()) {
            C1120a.m6677i(TAG, "createGeneralFiles, uploadRepeatFiles size: " + arrayList.size());
            new CommonOpsReport(this.context).m15209C(str2, "repeat_upload", 1006, sb2.toString());
        }
        C1120a.m6677i(TAG, "createGeneralFiles, end size: " + list.size());
        if (list.isEmpty()) {
            sendUploadComplete(str2);
            return;
        }
        C13916d c13916d = new C13916d(this.context, this.callbackHandler, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
        C13916d.m83410z(str2);
        c13916d.m83420t(C9894e.m61401d(list, false, false));
    }

    public void createShareAlbum(ShareAlbumData shareAlbumData) {
        this.shareServiceLogic.m57083e(shareAlbumData);
    }

    public void createShareFiles(List<FileData> list, boolean z10, String str) {
        C0074l.m603c().m611i(true);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            FileData next = it.next();
            if (next != null) {
                String strM6850z = C1122c.m6850z(next);
                C1120a.m6675d(TAG, "createShareFiles tempFileKey: " + strM6850z);
                Integer numM605b = C0074l.m603c().m605b(strM6850z);
                if (numM605b != null && numM605b.intValue() > 10) {
                    arrayList.add(next);
                    sb2.append(C1122c.m6818p0(next.getFileName()));
                    sb2.append("_");
                    sb2.append(next.getAlbumId());
                    sb2.append(";");
                    it.remove();
                }
            }
        }
        C1120a.m6677i(TAG, "createShareFiles currentUploadFiles: " + list.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sendUploadShareRepeat((FileData) it2.next(), str);
        }
        if (!arrayList.isEmpty()) {
            C1120a.m6677i(TAG, "createShareFiles, uploadRepeatFiles size: " + arrayList.size());
            new CommonOpsReport(this.context).m15209C(str, "repeat_upload", 1006, sb2.toString());
        }
        C1120a.m6677i(TAG, "createShareFiles, end size: " + list.size());
        if (list.isEmpty()) {
            sendUploadShareComplete(str);
            return;
        }
        List<FileInfo> listM61401d = C9894e.m61401d(list, true, false);
        C13916d.m83392H(listM61401d);
        new C13916d(this.context, this.callbackHandler, str).m83420t(listM61401d);
    }

    public void createShortLink(String str) throws RemoteException {
        this.shareServiceLogic.m57084f(str);
    }

    public void dealStateChangedEvent(int i10, int i11) {
        C1120a.m6677i(TAG, "dealStateChangedEvent, syncState: " + i10 + ", state: " + i11);
        if (this.syncStrategy.m60428r() && !Version.isSupportMemoryOptimize() && DownloadPhotoBase.m14411f()) {
            C9049c.m57054f(this.context, 105, false);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("SyncState", i10);
        bundle.putInt("State", i11);
        this.callbackHandler.sendMessage(9099, bundle);
    }

    public void dealStateEvent(int i10, boolean z10) {
        C1120a.m6677i(TAG, "dealStateEvent, mask: " + i10 + ", flag: " + z10);
        if ((i10 == 1 || i10 == 2) && z10) {
            cancelAllRequest();
        }
    }

    public void dealSyncStateChangedEvent(int i10, int i11) {
        String str;
        C1120a.m6677i(TAG, "dealSyncStateChangedEvent, syncState: " + i10 + ", errCode: " + i11);
        int i12 = C2419a.f11558a[C9674k.b.values()[i10].ordinal()];
        if (i12 == 2) {
            C1120a.m6677i(TAG, "stop all sync.");
            stopAllSync(i11, true);
        } else if (i12 == 3) {
            C1120a.m6677i(TAG, "stop download task");
            C9049c.m57054f(this.context, i11, true);
            Bundle bundle = new Bundle();
            bundle.putInt("Code", i11);
            this.callbackHandler.sendMessage(9199, bundle);
        }
        if (i11 == 109) {
            C1120a.m6676e(TAG, "system_remote_service_disconnect local report");
            if (!C9733f.m60705z().m60724S(1)) {
                return;
            } else {
                str = "serviceDisconnect";
            }
        } else {
            str = "syncstate";
        }
        new CommonOpsReport(this.context).m15209C(OpsReport.m15259j(), str, i11, this.syncStrategy.m60416f(i11));
    }

    public void deleteDownloadHistory(List<FileData> list) {
        new C9049c(this.context, this.callbackHandler).m57064i(C9894e.m61401d(list, false, true));
    }

    public void deleteDownloadHistoryAll(int i10) {
        new C9049c(this.context, this.callbackHandler).m57065j(i10);
    }

    public void deleteGeneralAlbums(List<String> list, String str, String str2) {
        this.generalSyncServiceLogic.m57038e(list, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
    }

    public void deleteGeneralFiles(List<FileData> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            FileData next = it.next();
            if (next != null) {
                String strM6841w = C1122c.m6841w(next);
                C1120a.m6675d(TAG, "deleteGeneralFiles tempFileKey: " + strM6841w);
                Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 3);
                if (numM15193q != null && numM15193q.intValue() > 10) {
                    arrayList.add(next);
                    sb2.append(C1122c.m6818p0(next.getFileName()));
                    sb2.append("_");
                    sb2.append(next.getAlbumId());
                    sb2.append(";");
                    it.remove();
                }
            }
        }
        C1120a.m6677i(TAG, "deleteGeneralFiles currentCopyFiles: " + list.size());
        if (!arrayList.isEmpty()) {
            C1120a.m6677i(TAG, "deleteGeneralFiles, deleteRepeatFiles size: " + arrayList.size());
            new CommonOpsReport(this.context).m15209C(str2, "repeat_delete", 1005, sb2.toString());
        }
        C1120a.m6677i(TAG, "deleteGeneralFiles, end size: " + list.size());
        if (list.isEmpty()) {
            sendDeleteRepeat(arrayList, str2);
        } else {
            SyncSessionManager.m15153t().m15169P(true);
            this.generalSyncServiceLogic.m57039f(list, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
        }
    }

    public void deleteShareAlbum(ShareAlbumData shareAlbumData, String str) {
        this.shareSyncLogic.m57094b(shareAlbumData, str);
    }

    public void deleteShareFile(String str, String str2, List<FileData> list, String str3) {
        this.shareSyncLogic.m57095c(str, str2, list, str3);
    }

    public void destroy() {
        C1120a.m6677i(TAG, "destroy");
        this.requestQueue.m81469d();
        this.shareRequestQueue.m81469d();
    }

    public void destroyGeneralTasks(int i10, int i11) {
        if ((i10 & 2) == 2) {
            C13916d.m83404n(this.context, this.callbackHandler, 152);
        }
        if ((i10 & 1) == 1) {
            if ((i11 & 4) == 4 || (i11 & 2) == 2) {
                C9049c.m57053c(152, false, true);
            }
            if ((i11 & 1) == 1) {
                C9049c.m57055g(this.context, 152, true);
            }
        }
    }

    public void destroyShareTasks(int i10, int i11) {
        if ((i10 & 2) == 2) {
            C13916d.m83405o(this.context, this.callbackHandler, 152);
        }
        if ((i10 & 1) == 1) {
            if ((i11 & 4) == 4 || (i11 & 2) == 2) {
                C9049c.m57053c(152, true, true);
            }
            if ((i11 & 1) == 1) {
                C9049c.m57056h(this.context, 152, true);
            }
        }
    }

    public void downloadAvatar(List<ShareReceiverData> list, String str) throws RemoteException {
        C9049c c9049c = new C9049c(this.context, this.callbackHandler);
        for (ShareReceiverData shareReceiverData : list) {
            C1120a.m6675d(TAG, "downloadAvatar shareReceiverData: " + shareReceiverData.toString());
            c9049c.m57067l(shareReceiverData, str, "");
        }
    }

    public void downloadGeneralFiles(List<FileData> list, int i10, int i11, boolean z10, boolean z11, String str) {
        if (CommonConstants.f12114a) {
            C1120a.m6675d(TAG, "downloadGeneralFiles: thumbType:" + i10 + "operationType:" + i11 + "files:" + new Gson().toJson(list));
        }
        String strM66627b = C11058a.m66627b("04004");
        C1120a.m6677i(TAG, "downloadGeneralFiles, traceId change from " + str + " to " + strM66627b);
        if (!CloudAlbumSettings.m14363h().m14376l()) {
            new C9049c(this.context, this.callbackHandler).m57068m(C9894e.m61399b(this.context, list, i10, false), i10, i11, z10, z11, strM66627b);
            return;
        }
        C1120a.m6677i(TAG, "downloadGeneralFiles currentFiles: " + list.size());
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            FileData next = it.next();
            if (next != null) {
                String strM70401f = C11820b.m70401f(next.getAlbumId(), next.getUniqueId(), i10);
                C1120a.m6675d(TAG, "downloadGeneralFiles tempFileKey: " + strM70401f);
                Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM70401f, 5);
                if ((numM15193q != null && numM15193q.intValue() > 10) || C0067e.m443e().m453k(next, i10, false)) {
                    arrayList.add(next);
                    sb2.append(C1122c.m6818p0(next.getFileName()));
                    sb2.append("_");
                    sb2.append(next.getAlbumId());
                    sb2.append("_");
                    sb2.append(i10);
                    sb2.append(";");
                    it.remove();
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            sendDownloadFail((FileData) it2.next(), i10);
        }
        if (!arrayList.isEmpty()) {
            C1120a.m6677i(TAG, "downloadGeneralFiles, mediaGetFailFiles size: " + arrayList.size());
            new CommonOpsReport(this.context).m15209C(strM66627b, "repeat_download", FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, sb2.toString());
        }
        C1120a.m6677i(TAG, "downloadGeneralFiles, end size: " + list.size());
        new C9049c(this.context, this.callbackHandler).m57068m(C9894e.m61399b(this.context, list, i10, false), i10, i11, z10, z11, strM66627b);
    }

    public void downloadShareFiles(List<FileData> list, int i10, int i11, boolean z10, boolean z11, String str) {
        if (CommonConstants.f12114a) {
            C1120a.m6675d(TAG, "downloadShareFiles: thumbType:" + i10 + "operationType:" + i11 + "files:" + new Gson().toJson(list));
        }
        new C9049c(this.context, this.callbackHandler).m57069n(C9894e.m61399b(this.context, list, i10, true), i10, i11, z10, z11, str);
    }

    public void getAllGeneralFiles(List<String> list, int i10, int i11, String str) {
        this.generalSyncServiceLogic.m57040g(list, i10, i11, str);
    }

    public void getAllShareFiles(ShareAlbumData shareAlbumData, int i10, String str) {
        this.shareSyncLogic.m57096d(shareAlbumData, i10, str);
    }

    public void getAllSimplifyInfo(String str, List<String> list, int i10, int i11, String str2) {
        this.generalSyncServiceLogic.m57041h(str, list, i10, i11, str2);
    }

    public void getAllTagFiles(SmartTagData smartTagData, String str, String str2) {
        this.tagSyncLogic.m57103b(smartTagData, str, str2);
    }

    public void getAvatar(List<String> list) throws RemoteException {
        this.shareServiceLogic.m57085g(list);
    }

    public void getCategoryInfoList(String str) {
        this.tagSyncLogic.m57104c(str);
    }

    public void getChangeTagFiles(SmartTagData smartTagData, String str, String str2) {
        this.tagSyncLogic.m57105d(smartTagData, str, str2);
    }

    public void getChangedGeneralFiles(List<String> list, long j10, int i10, String str, String str2) {
        this.generalSyncServiceLogic.m57042i(list, j10, i10, str, str2);
    }

    public void getChangedShareFiles(ShareAlbumData shareAlbumData, String str, String str2) {
        this.shareSyncLogic.m57097e(shareAlbumData, str, str2);
    }

    public void getDetailedInfo(String str, List<SimplifyInfo> list, boolean z10) {
        this.generalSyncServiceLogic.m57043j(str, list, z10);
    }

    public int getDownloadFileCount(int i10) {
        return new C9049c(this.context, this.callbackHandler).m57070o(i10);
    }

    public List<FileDownloadStatus> getDownloadFileStatus(List<FileData> list) {
        return new C9049c(this.context, this.callbackHandler).m57071p(C9894e.m61401d(list, false, true));
    }

    public List<FileDownloadStatus> getDownloadFileStatusLimit(int i10, int i11, int i12) {
        return new C9049c(this.context, this.callbackHandler).m57072q(i10, i11, i12);
    }

    public void getFileTransferStatus(String str) {
        this.commonServiceLogic.m57021a(str);
    }

    public void getGeneralAlbumVersion(String str) {
        this.commonServiceLogic.m57022b(str);
    }

    public void getGeneralAlbums(String str) {
        this.generalSyncServiceLogic.m57044k(str);
    }

    public void getGroupAlbums(String str) {
        this.shareSyncLogic.m57098f(str);
    }

    public void getGroupIdList() {
        this.shareServiceLogic.m57086h();
    }

    public void getServerTime() {
        this.commonServiceLogic.m57023c();
    }

    public void getShareAlbumList() {
        this.shareServiceLogic.m57087i();
    }

    public void getShareAlbumVersion(String str) {
        this.shareSyncLogic.m57099g(str);
    }

    public void getShareAlbums(String str) {
        this.shareSyncLogic.m57100h(str);
    }

    public void getSyncLock(String str) {
        C1136q.m6946D(SyncSessionManager.m15153t().m15194r());
        this.commonServiceLogic.m57024d(str);
    }

    public void getTagInfo(SmartAlbumData smartAlbumData, String str, String str2) {
        this.tagSyncLogic.m57106e(smartAlbumData, str, str2);
    }

    public void getTagTransferStatus() {
        this.commonServiceLogic.m57025e();
    }

    public void getTagVersion(String str) {
        this.tagSyncLogic.m57107f(str);
    }

    public void getVideoPlayUrlAsync(FileData fileData) {
        this.shareServiceLogic.m57088k(fileData);
    }

    public void keepSyncLock(String str, String str2) {
        this.commonServiceLogic.m57026f(SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
    }

    public void modifyGeneralAlbums(List<GeneralAlbumData> list, String str, String str2) {
        this.generalSyncServiceLogic.m57045l(list, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
    }

    public void modifyGeneralFiles(List<FileData> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        Iterator<FileData> it = list.iterator();
        while (it.hasNext()) {
            FileData next = it.next();
            if (next != null) {
                String strM6841w = C1122c.m6841w(next);
                C1120a.m6675d(TAG, "modifyGeneralFiles tempFileKey: " + strM6841w);
                Integer numM15193q = SyncSessionManager.m15153t().m15193q(strM6841w, 1);
                if (numM15193q != null && numM15193q.intValue() > 10) {
                    arrayList.add(next);
                    sb2.append(C1122c.m6818p0(next.getFileName()));
                    sb2.append("_");
                    sb2.append("modify too much");
                    sb2.append(";");
                    it.remove();
                }
            }
        }
        C1120a.m6677i(TAG, "modifyGeneralFiles currentModifyFiles: " + list.size());
        if (!arrayList.isEmpty()) {
            C1120a.m6677i(TAG, "modifyGeneralFiles, modifyRepeatFiles size: " + arrayList.size());
            new CommonOpsReport(this.context).m15209C(str2, "repeat_update", 1003, sb2.toString());
        }
        C1120a.m6677i(TAG, "modifyGeneralFiles, end size: " + list.size());
        if (list.isEmpty()) {
            sendModifyRepeat(arrayList, str2);
        } else {
            this.generalSyncServiceLogic.m57046m(list, SyncSessionManager.m15153t().m15197v(this.callbackHandler), str2);
        }
    }

    public void modifyShareAlbum(ShareAlbumData shareAlbumData, String str) {
        this.shareSyncLogic.m57101i(shareAlbumData, str);
    }

    public void modifyShareAlbumData(ShareAlbumData shareAlbumData) {
        this.shareServiceLogic.m57089l(shareAlbumData);
    }

    public void modifyShareAlbumPrivilege(String str, int i10) {
        this.shareServiceLogic.m57090m(str, i10);
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.able.HttpErrorHandler
    public void opsReport(String str, int i10, String str2, String str3, long j10) {
        C1120a.m6675d(TAG, "opsReport, sessionId: " + str + ", code: " + i10 + ", errInfo: " + str2 + ", businessId: " + str3);
        CommonOpsReport commonOpsReport = new CommonOpsReport(this.context);
        commonOpsReport.m15278z(String.valueOf(j10));
        commonOpsReport.m15209C(str, str3, i10, str2);
    }

    public void pauseDownload(List<FileData> list) {
        new C9049c(this.context, this.callbackHandler).m57062d(C9894e.m61401d(list, false, true));
    }

    public void pauseDownloadAll() {
        new C9049c(this.context, this.callbackHandler).m57063e();
    }

    public void queryDisableState(int i10, String str) {
        if (CloudAlbumSettings.m14363h().m14378n()) {
            sendNonsupport(i10, str);
        } else {
            this.commonServiceLogic.m57029i(i10, str);
        }
    }

    public void queryUserSpace(String str, int i10, String str2, String str3, String str4) {
        this.commonServiceLogic.m57030j(str, i10, str2, str3, str4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0133, code lost:
    
        if (r5 != false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0135, code lost:
    
        r1 = r1.context;
        r4 = "04005";
        r5 = "queryUserSpaceSync";
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x016a, code lost:
    
        if (r7 != 0) goto L131;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b5  */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.huawei.android.hicloud.album.service.vo.UserSpace] */
    /* JADX WARN: Type inference failed for: r1v16, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.android.hicloud.album.service.p075vo.UserSpace queryUserSpaceSync(java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.album.service.logic.CloudAlbumSdkLogic.queryUserSpaceSync(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):com.huawei.android.hicloud.album.service.vo.UserSpace");
    }

    public void releaseSyncLock(String str, String str2) {
        this.commonServiceLogic.m57031k(str, str2);
    }

    public void removeShareReceiver(ShareAlbumData shareAlbumData, List<ShareReceiverData> list) throws RemoteException {
        this.shareServiceLogic.m57091n(shareAlbumData, list, 1);
    }

    public void reportTagTransferStatus(String str) {
        this.commonServiceLogic.m57032l(str);
    }

    public <T> void request(int i10, AbstractC13540g<T> abstractC13540g, OnResponseListener<T> onResponseListener) {
        request(i10, abstractC13540g, null, onResponseListener);
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.able.Requestable
    public <T> void requestSingle(int i10, AbstractC13540g<T> abstractC13540g, AbstractC13354a abstractC13354a, OnResponseListener<T> onResponseListener) {
        abstractC13540g.m81451B(abstractC13354a);
        abstractC13540g.m81452C(this);
        abstractC13540g.m81453D(OpsReport.m15257h());
        this.shareRequestQueue.m81466a(i10, abstractC13540g, onResponseListener);
    }

    public void sendSyncFailure() {
        Bundle bundle = new Bundle();
        String strM15201z = SyncSessionManager.m15153t().m15201z();
        C1120a.m6677i(TAG, "sendSyncFailure sessionId: " + strM15201z);
        bundle.putString("sessionId", strM15201z);
        this.callbackHandler.sendMessage(9207, bundle);
    }

    public void setAlbumProperties(SettingParams settingParams) {
        C1120a.m6675d(TAG, "setAlbumProperties, SettingParams: " + settingParams.toString());
        C1136q.c.m7123f(this.context, C9894e.m61402e(settingParams));
    }

    public void shareResultConfirm(String str, String str2, int i10) throws RemoteException {
        this.shareServiceLogic.m57092o(str, str2, i10);
    }

    public void stInvalid(boolean z10) {
        C1120a.m6677i(TAG, "Deal stInvalid!");
        if (z10) {
            try {
                C13195l.m79272J().m79290C("com.huawei.hidisk.cloudAlbum", "CloudAlbum", "");
                return;
            } catch (C13194k e10) {
                C1120a.m6676e(TAG, "HmsException: " + e10.getMessage());
                return;
            } catch (C13199p e11) {
                C1120a.m6676e(TAG, "hmsSTInvalidException: " + e11.getMessage());
            }
        }
        if (!C13452e.m80781L().m80842P0()) {
            C1120a.m6678w(TAG, "not login, ignore auth fail.");
            return;
        }
        this.syncStrategy.m60406L(true);
        C1120a.m6677i(TAG, "auth fail, sendBroadCast");
        C13108a.m78878b(this.context).m78881d(new Intent("com.huawei.hicloud.intent.action.CLOUDALBUM_AUTHFAILED"));
    }

    public void startDownload(List<FileData> list) {
        if (CommonConstants.f12114a) {
            C1120a.m6675d(TAG, "startDownload:" + new Gson().toJson(list));
        }
        new C9049c(this.context, this.callbackHandler).m57076y(C9894e.m61401d(list, true, true), false);
    }

    public void startDownloadAll() {
        new C9049c(this.context, this.callbackHandler).m57077z();
    }

    public void startDownloadFile(List<FileData> list, boolean z10) {
        if (CommonConstants.f12114a) {
            C1120a.m6675d(TAG, "startDownloadFile:" + new Gson().toJson(list));
        }
        new C9049c(this.context, this.callbackHandler).m57076y(C9894e.m61401d(list, true, true), z10);
    }

    public void stopAllTask(int i10) {
        stopAllSync(i10, false);
        C9049c.m57054f(this.context, i10, false);
    }

    public void stopUpload(int i10, boolean z10) {
        C13916d.m83407q(this.context, z10 ? this.callbackHandler : null, i10);
    }

    public void updateSaveOriginalStatus(int i10, int i11, int i12) {
        C1120a.m6677i(TAG, "updateSaveOriginalStatus saveOriginalStatus: " + i10 + ", haveAnotherNum: " + i11 + ", downloadNum: " + i12);
        C1136q.b.m7049c1(this.context, i10);
        if (i10 >= 2) {
            C1136q.b.m7046b1(this.context, false);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("SaveOriginalStatus", i10);
        bundle.putInt("HaveAnotherNum", i11);
        bundle.putInt("DownloadNum", i12);
        this.callbackHandler.sendMessage(10000, bundle);
    }

    public void updateSyncPrompt(SyncPrompt syncPrompt) {
        C1120a.m6675d(TAG, "updateSyncPrompt, syncPrompt: " + syncPrompt.toString());
        C9673j.m60394f(this.context, this.callbackHandler, syncPrompt);
    }

    public <T> void request(int i10, AbstractC13540g<T> abstractC13540g, AbstractC13354a abstractC13354a, OnResponseListener<T> onResponseListener) {
        abstractC13540g.m81451B(abstractC13354a);
        abstractC13540g.m81452C(this);
        this.requestQueue.m81466a(i10, abstractC13540g, onResponseListener);
    }

    @Override // com.huawei.android.hicloud.album.service.hihttp.able.Requestable
    public <T> void request(int i10, String str, AbstractC13540g<T> abstractC13540g, AbstractC13354a abstractC13354a, OnResponseListener<T> onResponseListener) {
        abstractC13540g.m81451B(abstractC13354a);
        abstractC13540g.m81452C(this);
        abstractC13540g.m81453D(str);
        this.requestQueue.m81466a(i10, abstractC13540g, onResponseListener);
    }

    public void request(int i10, Bundle bundle) {
        this.commonServiceLogic.m57033m(i10, bundle);
    }
}
