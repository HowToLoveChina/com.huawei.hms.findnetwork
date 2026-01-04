package com.huawei.android.hicloud.album.service.logic.callable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.HttpResult;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.android.p069cg.request.threadpool.C2334o;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.hidisk.common.kvdb.KvDatabaseWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import p009a8.C0069g;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1125f;
import p031b7.C1132m;
import p031b7.C1136q;
import p031b7.C1138s;
import p220d8.C9049c;
import p281f8.C9674k;
import p546p6.C12091d;
import p546p6.C12096i;
import p546p6.C12105r;
import p546p6.C12111x;
import p649t6.C12941a;
import p649t6.C12947g;
import p649t6.C12950j;
import p664u0.C13108a;
import p709vj.C13452e;
import p723w.C13502a;

/* loaded from: classes2.dex */
public class CloudAlbumDownloadCheckCallable implements Callable<Object> {
    private static final Object OBJ = new Object();
    private static final String TAG = "CloudAlbumDownloadCheckCallable";
    private static final long TOAST_INTERVAL_TIME = 5000;
    private static long tempToastTime;
    private Context context;
    private Handler coverCallback;
    private List<FileInfo> fileList;
    private Handler handler;
    private ImageView imageView;
    private boolean isShare;
    private boolean isSingle;
    private int position;
    private C12096i.e priority;
    private int thumbType;

    public CloudAlbumDownloadCheckCallable(Context context, int i10, List<FileInfo> list, Handler handler, boolean z10) {
        this.position = -1;
        this.priority = C12096i.e.NORMAL;
        this.context = context;
        this.thumbType = i10;
        this.fileList = list;
        this.handler = handler;
        this.isSingle = z10;
    }

    private void addDownloadCallableTask(final FileInfo fileInfo, final int i10, boolean z10, final boolean z11, int i11, String str, String str2, String str3, String str4, int i12, boolean z12, String str5) {
        String fileInfoKey = getFileInfoKey(fileInfo, i10, z11);
        AbstractCallableC2320a<Object> abstractCallableC2320aBuildDownloadCallable = CallableBuilder.getInstance().buildDownloadCallable(this.context, new CallbackHandler() { // from class: com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadCheckCallable.1
            @Override // com.huawei.android.hicloud.album.service.CallbackHandler
            public boolean canStartDownloading(boolean z13, int i13) {
                return true;
            }

            public boolean canStartSync(boolean z13, int i13) {
                return true;
            }

            @Override // com.huawei.android.hicloud.album.service.CallbackHandler
            public C9674k getSyncStrategy() {
                return new C9674k(CloudAlbumDownloadCheckCallable.this.context, this);
            }

            @Override // com.huawei.android.hicloud.album.service.CallbackHandler
            public boolean invokeEvent(int i13, Bundle bundle) {
                return false;
            }

            @Override // com.huawei.android.hicloud.album.service.CallbackHandler
            public void sendMessage(int i13, Bundle bundle) {
                if (CloudAlbumDownloadCheckCallable.this.handler == null || i10 != 0) {
                    return;
                }
                if (CloudAlbumDownloadCheckCallable.this.isSingle && (i13 == 9042 || i13 == 9052)) {
                    CloudAlbumDownloadCheckCallable.this.handler.obtainMessage(202, bundle).sendToTarget();
                } else {
                    CloudAlbumDownloadCheckCallable.this.handler.obtainMessage(i13, bundle).sendToTarget();
                }
            }

            @Override // com.huawei.android.hicloud.album.service.CallbackHandler
            public void stInvalid(boolean z13) {
            }
        }, str, str3, true, fileInfo, str2, z10, i10, str4, i12, i11, z12, str5, true);
        AbstractC2324e abstractC2324e = new AbstractC2324e("") { // from class: com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadCheckCallable.2
            @Override // com.huawei.android.p069cg.request.threadpool.AbstractC2324e
            public void handle(Object obj) throws SQLException {
                HashMap<String, Object> map;
                if (obj != null) {
                    C1120a.m6675d(CloudAlbumDownloadCheckCallable.TAG, "HandleCallable addDownloadCallableTask fileName: " + C1122c.m6818p0(fileInfo.getFileName()) + ", thumbType is: " + i10 + ", download result: " + obj.toString());
                    if (obj instanceof HashMap) {
                        map = (HashMap) obj;
                    } else {
                        map = new HashMap<>();
                        map.put("code", "1");
                    }
                    CloudAlbumDownloadCheckCallable.this.downloadResultHandle(map, fileInfo, i10, z11);
                }
            }
        };
        if (i10 == 0) {
            addOriginalTask(abstractCallableC2320aBuildDownloadCallable, abstractC2324e);
        } else {
            addThumbTask(fileInfoKey, abstractCallableC2320aBuildDownloadCallable, abstractC2324e);
        }
    }

    private void addOriginalTask(List<FileInfo> list, int i10, boolean z10, boolean z11) {
        String strM80971t0 = C13452e.m80781L().m80971t0();
        for (FileInfo fileInfo : list) {
            if (!z11) {
                fileInfo.setUserID(strM80971t0);
            } else if (TextUtils.isEmpty(fileInfo.getUserID()) && TextUtils.isEmpty(fileInfo.getFileId())) {
                C1120a.m6676e(TAG, "userId is null fileName is: " + C1122c.m6818p0(fileInfo.getFileName()));
            }
            fileInfo.setAlbumId(z11 ? fileInfo.getShareId() : fileInfo.getAlbumId());
            String localRealPath = fileInfo.getLocalRealPath();
            String localRealPath2 = fileInfo.getLocalRealPath();
            if (TextUtils.isEmpty(localRealPath2) || TextUtils.isEmpty(localRealPath)) {
                C1120a.m6675d(TAG, "saveGetPath: " + localRealPath2 + " saveCachePath: " + localRealPath);
                sendCallbackMessageError(fileInfo, i10, 124, z11);
                return;
            }
            addDownloadPhotoThreadTask(fileInfo, i10, z10, z11, 0, 0, false, C1122c.m6755Z0("04019"));
        }
    }

    private void addThumbTask(String str, AbstractCallableC2320a<Object> abstractCallableC2320a, AbstractC2324e abstractC2324e) {
        C2334o<Object> c2334o = new C2334o<>(abstractCallableC2320a);
        c2334o.m14680k(abstractC2324e);
        c2334o.m14682q(str);
        if (this.thumbType == 2) {
            if (this.priority == C12096i.e.HIGH) {
                C12111x.m72537e().m72541d(str, c2334o);
                return;
            } else {
                C12111x.m72537e().m72540c(str, c2334o);
                return;
            }
        }
        if (this.priority == C12096i.e.HIGH) {
            C12105r.m72501e().m72505d(str, c2334o);
        } else {
            C12105r.m72501e().m72504c(str, c2334o);
        }
    }

    private void checkNet() {
        if (C0209d.m1333z1(C0213f.m1377a()) || this.imageView == null) {
            return;
        }
        synchronized (OBJ) {
            try {
                if (System.currentTimeMillis() - tempToastTime > 5000) {
                    C1120a.m6677i(TAG, "toast network error");
                    final Activity activity = (Activity) this.imageView.getContext();
                    activity.runOnUiThread(new Runnable() { // from class: com.huawei.android.hicloud.album.service.logic.callable.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            CloudAlbumDownloadCheckCallable.lambda$checkNet$0(activity);
                        }
                    });
                    tempToastTime = System.currentTimeMillis();
                }
            } finally {
            }
        }
    }

    private String getFileInfoKey(FileInfo fileInfo, int i10, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fileInfo.getAlbumId());
        sb2.append("_");
        sb2.append(!z10 ? fileInfo.getUniqueId() : fileInfo.getHash());
        sb2.append("_");
        sb2.append(i10);
        sb2.append("_");
        return sb2.toString();
    }

    private int getMsgId(boolean z10) {
        if (this.isSingle) {
            return 200;
        }
        return z10 ? 9053 : 9043;
    }

    private void getUrlAndAddTask(List<FileInfo> list, int i10, boolean z10) {
        C1120a.m6677i(TAG, "getUrlAndAddTask size: " + list.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FileInfo fileInfo : list) {
            if (fileInfo.isMigratedData()) {
                arrayList2.add(fileInfo);
            } else {
                arrayList.add(fileInfo);
            }
        }
        if (arrayList.isEmpty() && arrayList2.isEmpty()) {
            return;
        }
        C9049c.m57060u(this.context, arrayList, i10, z10, C1122c.m6755Z0("04004"), true);
        C9049c.m57060u(this.context, arrayList2, i10, z10, C1122c.m6755Z0("04004"), true);
        for (FileInfo fileInfo2 : list) {
            if (TextUtils.isEmpty(fileInfo2.getThumbUrl()) && fileInfo2.getAsset() == null) {
                C1120a.m6678w(TAG, "thumb url is empty, filename:" + C1122c.m6818p0(fileInfo2.getFileName()));
                sendCallbackMessageError(fileInfo2, i10, 125, z10);
                if (CloudAlbumSettings.m14363h().m14376l()) {
                    C1122c.m6765c(i10, fileInfo2);
                }
            } else {
                addDownloadPhotoThreadTask(fileInfo2, i10, false, z10, 0, 0, false, C1122c.m6755Z0("04019"));
            }
        }
    }

    private boolean isExistInGalleryPathAndCopy(String str, String str2, int i10) {
        if (!C1122c.m6837u1(str2)) {
            return false;
        }
        if (i10 == 0) {
            return true;
        }
        return C1125f.m6885f(str2, str, true);
    }

    private boolean isLocalSpaceTooLow(FileInfo fileInfo) {
        long jM6698G0 = C1122c.m6698G0(C1124e.m6871o(this.context));
        if (!C1122c.m6681A1(this.thumbType, jM6698G0, fileInfo == null ? 0L : fileInfo.getSize())) {
            return false;
        }
        C1120a.m6676e(TAG, "checkDownload LocalSpaceTooLow, availSize:" + jM6698G0);
        return true;
    }

    private boolean isParamsError(FileInfo fileInfo, boolean z10) {
        if (fileInfo != null && !TextUtils.isEmpty(fileInfo.getAlbumId())) {
            if (!TextUtils.isEmpty(!z10 ? fileInfo.getUniqueId() : fileInfo.getHash()) && !TextUtils.isEmpty(fileInfo.getFileName())) {
                return false;
            }
        }
        return true;
    }

    private boolean isPathEmpty(String str, String str2) {
        return TextUtils.isEmpty(str2) || TextUtils.isEmpty(str);
    }

    private boolean isShareFileInfo(FileInfo fileInfo) {
        return !fileInfo.getAlbumId().startsWith("default-album-");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkNet$0(Activity activity) {
        Toast.makeText(activity, activity.getString(R$string.album_media_download_network_error), 0).show();
    }

    private boolean onlyOriginalDisplay(FileInfo fileInfo) {
        if (fileInfo.getOtype() != 1) {
            return false;
        }
        fileInfo.setLocalRealPath(new C12950j().m77859o(fileInfo));
        C1120a.m6675d(TAG, "onlyOriginalDisplay, filename:" + fileInfo.toString());
        Media mediaM72424e0 = C12096i.m72424e0(fileInfo);
        String strM480A = C0069g.m479y().m480A(mediaM72424e0);
        ImageView imageView = this.imageView;
        if (imageView != null && strM480A.equals(imageView.getTag())) {
            Bitmap bitmapM6719N0 = C1122c.m6719N0(mediaM72424e0.getFileType().intValue() == 4 ? C0209d.m1153B0(fileInfo.getLocalRealPath()) : C0209d.m1287o(fileInfo.getLocalRealPath(), this.imageView.getLayoutParams().width, this.imageView.getLayoutParams().height), fileInfo.getOrientation());
            C1138s.m7181d().m7182a(strM480A, bitmapM6719N0);
            if (bitmapM6719N0 != null) {
                C1120a.m6675d(TAG, "onlyOriginalDisplay, bitmap.size=" + C13502a.m81215a(bitmapM6719N0));
            } else {
                C1120a.m6678w(TAG, "onlyOriginalDisplay, bitmap is null");
            }
            ((Activity) this.imageView.getContext()).runOnUiThread(new C12091d.q0(bitmapM6719N0, this.imageView));
        }
        return true;
    }

    private void refreshImage(C12091d.q0 q0Var, Context context) {
        C1120a.m6675d(TAG, "start refreshImage");
        if (context instanceof Activity) {
            C1120a.m6675d(TAG, "imageContext is activity");
            ((Activity) context).runOnUiThread(q0Var);
        } else {
            Object tag = this.imageView.getTag(R$id.album_head_picture);
            if (tag instanceof Activity) {
                ((Activity) tag).runOnUiThread(q0Var);
            }
        }
    }

    private void sendCoverCallback(FileInfo fileInfo) {
        Handler handler = this.coverCallback;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.obj = fileInfo;
            this.coverCallback.sendMessage(messageObtainMessage);
        }
    }

    private void sendExistCallback(ArrayList<FileInfo> arrayList) throws SQLException {
        Iterator<FileInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo next = it.next();
            C1120a.m6677i(TAG, "sendExistCallback");
            sendCallbackMessageSuccess(next, this.thumbType, this.isShare);
        }
    }

    private void setOriginalLpath(FileInfo fileInfo) {
        Album albumM77726A = new C12941a().m77726A(fileInfo.getAlbumId(), false);
        if (albumM77726A == null) {
            fileInfo.setLpath("/CloudShareDownload/" + fileInfo.getAlbumId());
            return;
        }
        if (isShareFileInfo(fileInfo)) {
            fileInfo.setLpath("/PhotoShareDownload/" + albumM77726A.getAlbumName());
            return;
        }
        if (!TextUtils.isEmpty(albumM77726A.getLocalPath())) {
            fileInfo.setLpath(albumM77726A.getLocalPath());
            return;
        }
        fileInfo.setLpath("/CloudShareDownload/" + albumM77726A.getAlbumName());
    }

    private void updatePathToDB(FileInfo fileInfo, int i10) throws SQLException {
        new C12947g().m77820g0(fileInfo, i10);
    }

    public void addDownloadPhotoThreadTask(FileInfo fileInfo, int i10, boolean z10, boolean z11, int i11, int i12, boolean z12, String str) {
        String localRealPath;
        String localThumbPath;
        String thumbUrl;
        if (isParamsError(fileInfo, z11)) {
            C1120a.m6676e(TAG, "addDownloadPhotoThreadTask albumId or hash is null");
            return;
        }
        if (i10 == 1) {
            String localBigThumbPath = fileInfo.getLocalBigThumbPath();
            thumbUrl = fileInfo.getThumbUrl();
            localRealPath = fileInfo.getLocalBigThumbPath();
            localThumbPath = localBigThumbPath;
        } else if (i10 == 0) {
            String fileUrl = fileInfo.getFileUrl();
            localRealPath = fileInfo.getLocalRealPath();
            localThumbPath = C1122c.m6786h0(0, fileInfo.getAlbumId(), fileInfo.getFileName());
            thumbUrl = fileUrl;
        } else if (i10 == 2) {
            String localThumbPath2 = fileInfo.getLocalThumbPath();
            String thumbUrl2 = fileInfo.getThumbUrl();
            localThumbPath = fileInfo.getLocalThumbPath();
            thumbUrl = thumbUrl2;
            localRealPath = localThumbPath2;
        } else {
            localRealPath = null;
            localThumbPath = null;
            thumbUrl = null;
        }
        if (!isPathEmpty(localThumbPath, localRealPath)) {
            addDownloadCallableTask(fileInfo, i10, z10, z11, i11, localRealPath, localThumbPath, thumbUrl, z11 ? fileInfo.getResource() : PowerKitApplyUtil.GROUP_ALBUM, i12, z12, str);
            return;
        }
        C1120a.m6675d(TAG, "saveGetPath: " + localRealPath + " saveCachePath: " + localThumbPath);
        sendCallbackMessageError(fileInfo, i10, 124, z11);
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        String strM6786h0;
        int iLastIndexOf;
        int iLastIndexOf2;
        C1120a.m6677i(TAG, "check list: " + this.fileList.size());
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (FileInfo fileInfo : this.fileList) {
            if (!onlyOriginalDisplay(fileInfo)) {
                boolean zIsShareFileInfo = isShareFileInfo(fileInfo);
                this.isShare = zIsShareFileInfo;
                int i10 = this.thumbType;
                String strM6895p = (i10 == 0 || zIsShareFileInfo) ? C1125f.m6895p(fileInfo, i10) : C1125f.m6890k(fileInfo, i10);
                int i11 = this.thumbType;
                if (i11 == 2) {
                    if (!strM6895p.endsWith(CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT) && (iLastIndexOf2 = strM6895p.lastIndexOf(".")) > 0) {
                        strM6895p = strM6895p.substring(0, iLastIndexOf2) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
                    }
                    strM6786h0 = C1122c.m6786h0(2, fileInfo.getAlbumId(), strM6895p);
                    fileInfo.setLocalThumbPath(strM6786h0);
                } else if (i11 == 1) {
                    if (!strM6895p.endsWith(CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT) && (iLastIndexOf = strM6895p.lastIndexOf(".")) > 0) {
                        strM6895p = strM6895p.substring(0, iLastIndexOf) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
                    }
                    strM6786h0 = C1122c.m6786h0(1, fileInfo.getAlbumId(), strM6895p);
                    fileInfo.setLocalBigThumbPath(strM6786h0);
                } else if (i11 == 0) {
                    setOriginalLpath(fileInfo);
                    strM6786h0 = C1124e.m6866j() + fileInfo.getLpath() + "/" + fileInfo.getFileName();
                    fileInfo.setLocalRealPath(strM6786h0);
                } else {
                    strM6786h0 = "";
                }
                C1120a.m6675d(TAG, "fileName: " + fileInfo.getFileName() + ", cachePath: " + strM6786h0);
                if (C1122c.m6837u1(strM6786h0)) {
                    arrayList.add(fileInfo);
                    C1120a.m6675d(TAG, "already exist localThumbPath: " + strM6786h0);
                } else if (isLocalSpaceTooLow(fileInfo)) {
                    sendCallbackMessageError(fileInfo, this.thumbType, 126, this.isShare);
                } else {
                    String strM6864h = C1124e.m6864h(this.context, fileInfo, this.thumbType);
                    C1120a.m6675d(TAG, "fileInfo: " + fileInfo.getFileName() + "thumbType: " + this.thumbType + ", galleryCachePath: " + strM6864h);
                    if (isExistInGalleryPathAndCopy(strM6786h0, strM6864h, this.thumbType)) {
                        arrayList.add(fileInfo);
                    } else {
                        arrayList2.add(fileInfo);
                    }
                }
            }
        }
        C1120a.m6677i(TAG, "needDownList size: " + arrayList2.size());
        C1120a.m6677i(TAG, "existList size: " + arrayList.size());
        sendExistCallback(arrayList);
        int i12 = this.thumbType;
        if (i12 == 0) {
            addOriginalTask(arrayList2, i12, true, this.isShare);
            return null;
        }
        getUrlAndAddTask(arrayList2, i12, this.isShare);
        return null;
    }

    public void downloadResultHandle(HashMap<String, Object> map, FileInfo fileInfo, int i10, boolean z10) throws SQLException {
        int iM1685c;
        boolean zBooleanValue = map.containsKey("NeedCallback") ? ((Boolean) map.get("NeedCallback")).booleanValue() : true;
        if (map.containsKey("isForceDownload")) {
            C1120a.m6677i(TAG, "res containsKey isForceDownload:" + ((Boolean) map.get("isForceDownload")).booleanValue());
        }
        if (String.valueOf(0).equals(map.get("code"))) {
            sendCallbackMessageSuccess(fileInfo, i10, z10);
            return;
        }
        if ("11".equals(map.get("code"))) {
            if (map.containsKey("DownloadFailReason")) {
                String str = (String) map.get("DownloadFailReason");
                C1120a.m6677i(TAG, "start get failCode is:" + str);
                iM1685c = C0241z.m1685c(str);
            } else {
                iM1685c = 115;
            }
            sendCallbackMessageError(fileInfo, i10, iM1685c, z10);
            return;
        }
        if ("7".equals(map.get("code"))) {
            C1120a.m6676e(TAG, "download retry: " + C1122c.m6818p0(fileInfo.getFileName()) + ", thumbType: " + i10);
            sendCallbackMessageError(fileInfo, i10, 7, z10);
            return;
        }
        int iIntValue = map.containsKey("DownloadFailReason") ? ((Integer) map.get("DownloadFailReason")).intValue() : 101;
        if (C1136q.b.m7057f0(this.context)) {
            iIntValue = 105;
        }
        C1120a.m6676e(TAG, "download failed: " + C1122c.m6818p0(fileInfo.getFileName()) + ", type: " + i10 + ", DownloadFailReason: " + iIntValue + ", ret: " + map.get("code") + ", needCallback: " + zBooleanValue);
        sendCallbackMessageError(fileInfo, i10, iIntValue, z10);
    }

    public void sendCallbackMessageError(FileInfo fileInfo, int i10, int i11, boolean z10) {
        if (i10 == 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("FileInfo", fileInfo);
            bundle.putInt("ResolutionType", i10);
            bundle.putParcelable("HttpResult", new HttpResult(200, i11, null));
            int i12 = this.isSingle ? 201 : z10 ? 9153 : 9143;
            Message messageObtainMessage = this.handler.obtainMessage();
            messageObtainMessage.what = i12;
            messageObtainMessage.obj = bundle;
            this.handler.sendMessage(messageObtainMessage);
        } else if (i10 == 2) {
            checkNet();
        }
        sendCoverCallback(fileInfo);
    }

    public void sendCallbackMessageSuccess(FileInfo fileInfo, int i10, boolean z10) throws SQLException {
        Bitmap bitmapM6719N0;
        C1120a.m6677i(TAG, "sendCallbackMessageSuccess");
        updatePathToDB(fileInfo, i10);
        if (i10 == 0) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("FileInfo", fileInfo);
            bundle.putInt("ResolutionType", i10);
            int msgId = getMsgId(z10);
            Message messageObtainMessage = this.handler.obtainMessage();
            messageObtainMessage.what = msgId;
            messageObtainMessage.obj = bundle;
            this.handler.sendMessage(messageObtainMessage);
        }
        Media mediaM72424e0 = C12096i.m72424e0(fileInfo);
        String strM480A = C0069g.m479y().m480A(mediaM72424e0);
        if (i10 == 1) {
            bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(fileInfo.getLocalBigThumbPath()), fileInfo.getOrientation());
            if (this.position >= 0) {
                Intent intent = new Intent("com.huawei.hicloud.checkLCDDownloaded");
                intent.putExtra("param_file_viewer_position", this.position);
                C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
            }
        } else {
            bitmapM6719N0 = C1122c.m6719N0(C0209d.m1311u(fileInfo.getLocalThumbPath()), fileInfo.getOrientation());
        }
        C1138s.m7181d().m7182a(mediaM72424e0.getId(), bitmapM6719N0);
        C1132m.m6921c().m6922a(mediaM72424e0.getId(), mediaM72424e0);
        if (i10 != 0) {
            KvDatabaseWrapper kvDatabaseWrapperM72352f0 = C12091d.m72280a0().m72352f0();
            String id2 = mediaM72424e0.getId();
            if (kvDatabaseWrapperM72352f0 != null && !TextUtils.isEmpty(id2)) {
                kvDatabaseWrapperM72352f0.m30074e(id2, bitmapM6719N0);
            }
        }
        ImageView imageView = this.imageView;
        if (imageView != null && strM480A.equals(imageView.getTag())) {
            if (this.imageView.getLayoutParams().width > 0 && this.imageView.getLayoutParams().height > 0) {
                bitmapM6719N0 = C1122c.m6734S0(bitmapM6719N0, this.imageView.getLayoutParams().width, this.imageView.getLayoutParams().height);
            }
            refreshImage(new C12091d.q0(bitmapM6719N0, this.imageView), this.imageView.getContext());
        } else if (this.imageView != null) {
            C1120a.m6675d(TAG, "uniqueKey = " + strM480A + " , tag = " + this.imageView.getTag());
        } else {
            C1120a.m6675d(TAG, "imageView is null");
        }
        sendCoverCallback(fileInfo);
    }

    public void setPriority(C12096i.e eVar) {
        this.priority = eVar;
    }

    public CloudAlbumDownloadCheckCallable(Context context, int i10, List<FileInfo> list, Handler handler, ImageView imageView) {
        this.position = -1;
        this.priority = C12096i.e.NORMAL;
        this.context = context;
        this.thumbType = i10;
        this.fileList = list;
        this.handler = handler;
        this.imageView = imageView;
    }

    public CloudAlbumDownloadCheckCallable(Context context, int i10, List<FileInfo> list, Handler handler, ImageView imageView, Handler handler2) {
        this.position = -1;
        this.priority = C12096i.e.NORMAL;
        this.context = context;
        this.thumbType = i10;
        this.fileList = list;
        this.handler = handler;
        this.imageView = imageView;
        this.coverCallback = handler2;
    }

    private void addOriginalTask(AbstractCallableC2320a<Object> abstractCallableC2320a, AbstractC2324e abstractC2324e) {
        if (this.isSingle) {
            C2332m.m14608s().m14632Y(abstractCallableC2320a, abstractC2324e, false);
        } else {
            C2332m.m14608s().m14631X(abstractCallableC2320a, abstractC2324e, false);
        }
    }

    public CloudAlbumDownloadCheckCallable(Context context, int i10, List<FileInfo> list, Handler handler, ImageView imageView, int i11) {
        this.position = -1;
        this.priority = C12096i.e.NORMAL;
        this.context = context;
        this.thumbType = i10;
        this.fileList = list;
        this.handler = handler;
        this.imageView = imageView;
        this.position = i11;
    }
}
