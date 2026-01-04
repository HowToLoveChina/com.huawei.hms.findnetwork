package p312g8;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.SettingParams;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.p072vo.SettingsProp;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1125f;
import p365ic.C10466a;
import p511o6.C11820b;
import p603r6.C12467a;
import p649t6.C12943c;
import p709vj.C13452e;

/* renamed from: g8.e */
/* loaded from: classes2.dex */
public class C9894e {
    /* renamed from: a */
    public static void m61398a(JSONObject jSONObject, Cipher cipher, String str) throws JSONException {
        if (cipher == null || cipher.getKeyChains() == null || cipher.getKeyChains().size() <= 0) {
            jSONObject.put("position", str);
            return;
        }
        String ekey = cipher.getKeyChains().get(0).getEkey();
        DataDecryptReq dataDecryptReq = new DataDecryptReq();
        dataDecryptReq.setEdek(ekey);
        if (jSONObject.has("createrAccount")) {
            String strOptString = jSONObject.optString("createrAccount");
            dataDecryptReq.setSrcData(strOptString);
            try {
                C1120a.m6675d("VOTransform", "decryptPosition createrAccount:" + C10466a.m64316g(dataDecryptReq));
            } catch (C9721b e10) {
                C1120a.m6676e("VOTransform", "decryptPosition createrAccount failed:" + e10.getMessage());
            }
            jSONObject.put("createrAccount", strOptString);
            jSONObject.put("createrAccountDEK", strOptString);
        }
        if (jSONObject.has("position")) {
            String strOptString2 = jSONObject.optString("position");
            dataDecryptReq.setSrcData(strOptString2);
            String strM64316g = null;
            try {
                strM64316g = C10466a.m64316g(dataDecryptReq);
                JSONObject jSONObject2 = new JSONObject(strM64316g);
                if (jSONObject2.has("y")) {
                    C1120a.m6675d("VOTransform", "decryptPosition longtitude:" + jSONObject2.getDouble("y"));
                }
                if (jSONObject2.has(Constants.MULTIPLE_SIGN)) {
                    C1120a.m6675d("VOTransform", "decryptPosition latitude:" + jSONObject2.getDouble(Constants.MULTIPLE_SIGN));
                }
                jSONObject.put("position", strM64316g);
            } catch (C9721b e11) {
                C1120a.m6676e("VOTransform", "decryptPosition position failed:" + e11.getMessage());
            } catch (JSONException unused) {
                C1120a.m6676e("VOTransform", "decryptPosition setFileInfoExpand JSONException");
            }
            jSONObject.put("position", strM64316g);
            jSONObject.put("positionDEK", strOptString2);
        }
    }

    /* renamed from: b */
    public static ArrayList<FileInfo> m61399b(Context context, List<FileData> list, int i10, boolean z10) {
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        for (FileData fileData : list) {
            FileInfo fileInfoM61400c = m61400c(fileData);
            fileInfoM61400c.setFileNum(list.size());
            if (z10) {
                fileInfoM61400c.setShareId(fileInfoM61400c.getAlbumId());
                fileInfoM61400c.setAlbumId("");
                fileInfoM61400c.setDataVersion(new C12943c().m77763n(fileData.getAlbumId()));
            } else if (CloudAlbumSettings.m14363h().m14376l()) {
                fileInfoM61400c.setDataVersion("2.0");
            } else {
                fileInfoM61400c.setDataVersion("1.0");
            }
            m61409l(context, fileInfoM61400c, fileData, i10, z10);
            arrayList.add(fileInfoM61400c);
        }
        return arrayList;
    }

    /* renamed from: c */
    public static FileInfo m61400c(FileData fileData) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileId(fileData.getFileId());
        fileInfo.setVideoThumbId(fileData.getVideoThumbId());
        fileInfo.setFileUrl(fileData.getFileUrl());
        fileInfo.setThumbUrl(fileData.getThumbUrl());
        fileInfo.setFileName(fileData.getFileName());
        fileInfo.setCreateTime(fileData.getCreateTime());
        fileInfo.setAlbumId(fileData.getAlbumId());
        fileInfo.setHash(fileData.getHash());
        fileInfo.setSize(fileData.getSize());
        fileInfo.setSource(fileData.getSource());
        fileInfo.setFileType(fileData.getFileType());
        fileInfo.setExpand(fileData.getExpandString());
        fileInfo.setOversion(fileData.getOversion());
        if (TextUtils.isEmpty(fileData.getOtype())) {
            fileInfo.setOtype(0);
        } else {
            fileInfo.setOtype(C1122c.m6824q2(fileData.getOtype()));
        }
        if (TextUtils.isEmpty(fileData.getSdsctime())) {
            fileInfo.setSdsTime(0L);
        } else {
            fileInfo.setSdsTime(C1122c.m6794j0(fileData.getSdsctime()));
        }
        if (TextUtils.isEmpty(fileData.getAlbumId()) || !fileData.getAlbumId().equals("default-album-3")) {
            fileInfo.setFileAttribute(0);
        } else {
            fileInfo.setFileAttribute(1);
        }
        fileInfo.setUniqueId(fileData.getUniqueId());
        fileInfo.setRecycleAlbumId(fileData.getRecycleAlbumId());
        fileInfo.setRecycleTime(fileData.getRecycleTime());
        fileInfo.setDeviceId(fileData.getDeviceId());
        fileInfo.setFavorite(fileData.isFavorite());
        fileInfo.setThumbFileId(fileData.getThumbFileId());
        fileInfo.setLcdFileId(fileData.getLcdFileId());
        fileInfo.setUserID(fileData.getUserID());
        fileInfo.setLocalThumbPath(fileData.getLocalThumbPath());
        fileInfo.setLocalBigThumbPath(fileData.getLocalBigThumbPath());
        fileInfo.setLocalRealPath(fileData.getLocalRealPath());
        fileInfo.setFileUploadType(fileData.getFileUploadType());
        fileInfo.setAddTime(fileData.getAddTime());
        fileInfo.setResource(fileData.getResource());
        fileInfo.setLpath(fileData.getLpath());
        fileInfo.setLocalId(fileData.getLocalId());
        fileInfo.setTimestamp(fileData.getTimestamp());
        return fileInfo;
    }

    /* renamed from: d */
    public static List<FileInfo> m61401d(List<FileData> list, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (FileData fileData : list) {
            FileInfo fileInfoM61400c = m61400c(fileData);
            fileInfoM61400c.setFileNum(list.size());
            if (z10 && fileData.getAlbumId() != null && !fileData.getAlbumId().startsWith("default-album")) {
                fileInfoM61400c.setDataVersion(new C12943c().m77763n(fileData.getAlbumId()));
            } else if (CloudAlbumSettings.m14363h().m14376l()) {
                fileInfoM61400c.setDataVersion("2.0");
            } else {
                fileInfoM61400c.setDataVersion("1.0");
            }
            arrayList.add(fileInfoM61400c);
        }
        return arrayList;
    }

    /* renamed from: e */
    public static SettingsProp m61402e(SettingParams settingParams) {
        SettingsProp settingsProp = new SettingsProp();
        Parcel parcelObtain = Parcel.obtain();
        settingParams.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        settingsProp.readFromParcel(parcelObtain);
        parcelObtain.recycle();
        return settingsProp;
    }

    /* renamed from: f */
    public static String m61403f(Context context, String str, String str2, long j10, String str3) {
        String strM6871o = C1124e.m6871o(context);
        if (TextUtils.isEmpty(strM6871o)) {
            C1120a.m6676e("VOTransform", "FileHelper getInternalStoragePath is null");
            return null;
        }
        if (!str.startsWith("default-album-")) {
            return strM6871o + "/PhotoShareDownload/" + str3 + "/" + str2;
        }
        String strM6862f = C1124e.m6862f(context, str, j10);
        if (strM6862f == null) {
            C1120a.m6676e("VOTransform", "getOrgSavePath rootPath is null");
            return null;
        }
        return strM6862f + str3 + "/" + str2;
    }

    /* renamed from: g */
    public static boolean m61404g(FileInfo fileInfo, int i10) {
        return !TextUtils.isEmpty(i10 != 0 ? i10 != 1 ? i10 != 2 ? null : fileInfo.getLocalThumbPath() : fileInfo.getLocalBigThumbPath() : fileInfo.getLocalRealPath());
    }

    /* renamed from: h */
    public static void m61405h(FileInfo fileInfo, int i10, String str) {
        if (i10 == 0) {
            fileInfo.setLocalRealPath(str);
        } else if (i10 == 1) {
            fileInfo.setLocalBigThumbPath(str);
        } else {
            if (i10 != 2) {
                return;
            }
            fileInfo.setLocalThumbPath(str);
        }
    }

    /* renamed from: i */
    public static FileData m61406i(FileInfo fileInfo) throws JSONException {
        FileData fileData = new FileData();
        fileData.setFileId(fileInfo.getFileId());
        fileData.setVideoThumbId(fileInfo.getVideoThumbId());
        fileData.setFileUrl(fileInfo.getFileUrl());
        fileData.setThumbUrl(fileInfo.getThumbUrl());
        fileData.setFileName(fileInfo.getFileName());
        fileData.setCreateTime(fileInfo.getCreateTime());
        if (TextUtils.isEmpty(fileInfo.getAlbumId())) {
            fileData.setAlbumId(fileInfo.getShareId());
        } else {
            fileData.setAlbumId(fileInfo.getAlbumId());
        }
        fileData.setHash(fileInfo.getHash());
        fileData.setSize(fileInfo.getSize());
        fileData.setSource(fileInfo.getSource());
        fileData.setFileType(fileInfo.getFileType());
        if (!TextUtils.isEmpty(fileInfo.getExpand()) && !TextUtils.isEmpty(fileInfo.getFileId()) && "NMD".equals(fileInfo.getFileId()) && !TextUtils.isEmpty(fileInfo.getPositionGallery())) {
            try {
                JSONObject jSONObject = new JSONObject(fileInfo.getExpand());
                if (jSONObject.has("position")) {
                    jSONObject.put("positionDEK", jSONObject.getString("position"));
                    jSONObject.remove("position");
                    jSONObject.put("position", fileInfo.getPositionGallery());
                }
                if (jSONObject.has("createrAccount")) {
                    jSONObject.put("createrAccountDEK", jSONObject.getString("createrAccount"));
                }
                fileInfo.setExpand(jSONObject.toString());
            } catch (JSONException unused) {
                C1120a.m6676e("VOTransform", "toSdkFileInfo expand to json error");
            }
        }
        fileData.setExpandString(fileInfo.getExpand());
        fileData.setOversion(fileInfo.getOversion());
        fileData.setOtype(String.valueOf(fileInfo.getOtype()));
        if (fileInfo.getSdsTime() == 0) {
            fileData.setSdsctime("");
        } else {
            fileData.setSdsctime(C1122c.m6721O(fileInfo.getSdsTime()));
        }
        fileData.setUniqueId(fileInfo.getUniqueId());
        fileData.setRecycleAlbumId(fileInfo.getRecycleAlbumId());
        fileData.setRecycleTime(fileInfo.getRecycleTime());
        fileData.setDeviceId(fileInfo.getDeviceId());
        fileData.setFavorite(fileInfo.isFavorite());
        fileData.setThumbFileId(fileInfo.getThumbFileId());
        fileData.setLcdFileId(fileInfo.getLcdFileId());
        fileData.setUserID(fileInfo.getUserID());
        fileData.setLocalThumbPath(fileInfo.getLocalThumbPath());
        fileData.setLocalBigThumbPath(fileInfo.getLocalBigThumbPath());
        fileData.setLocalRealPath(fileInfo.getLocalRealPath());
        fileData.setFileUploadType(fileInfo.getFileUploadType());
        fileData.setAddTime(fileInfo.getAddTime());
        fileData.setResource(fileInfo.getResource());
        fileData.setLpath(fileInfo.getLpath());
        fileData.setAlbumName("");
        fileData.setLocalId(fileInfo.getLocalId());
        fileData.setTimestamp(fileInfo.getTimestamp());
        return fileData;
    }

    /* renamed from: j */
    public static void m61407j(FileData fileData) throws JSONException {
        JsonObject expand = fileData.getExpand();
        if (expand == null) {
            return;
        }
        if (expand.has(HicloudH5ConfigManager.KEY_HASH)) {
            String asString = expand.get(HicloudH5ConfigManager.KEY_HASH).getAsString();
            fileData.setHash(asString);
            C1120a.m6675d("VOTransform", "fillFieldFromExpand hash:" + asString);
        }
        if (!CloudAlbumSettings.m14363h().m14378n()) {
            if (expand.has(SyncProtocol.Constant.DEK)) {
                expand.remove(SyncProtocol.Constant.DEK);
            }
            if (expand.has("positionDEK")) {
                expand.remove("positionDEK");
            }
            if (expand.has("createrAccountDEK")) {
                expand.remove("createrAccountDEK");
                return;
            }
            return;
        }
        if (expand.has(SyncProtocol.Constant.DEK)) {
            DataDecryptReq dataDecryptReq = new DataDecryptReq();
            dataDecryptReq.setEdek(expand.get(SyncProtocol.Constant.DEK).getAsString());
            if (expand.has("createrAccount")) {
                String asString2 = expand.get("createrAccount").getAsString();
                dataDecryptReq.setSrcData(asString2);
                try {
                    C1120a.m6675d("VOTransform", "fillFieldFromExpand createrAccount:" + C10466a.m64316g(dataDecryptReq));
                } catch (C9721b e10) {
                    C1120a.m6676e("VOTransform", "decryptStructData createrAccount failed:" + e10.getMessage());
                }
                expand.addProperty("createrAccount", asString2);
                expand.addProperty("createrAccountDEK", asString2);
            }
            if (expand.has("position")) {
                String asString3 = expand.get("position").getAsString();
                dataDecryptReq.setSrcData(asString3);
                String strM64316g = null;
                try {
                    strM64316g = C10466a.m64316g(dataDecryptReq);
                    JSONObject jSONObject = new JSONObject(strM64316g);
                    if (jSONObject.has("y")) {
                        C1120a.m6675d("VOTransform", "fillFieldFromExpand longtitude:" + jSONObject.getDouble("y"));
                    }
                    if (jSONObject.has(Constants.MULTIPLE_SIGN)) {
                        C1120a.m6675d("VOTransform", "fillFieldFromExpand latitude:" + jSONObject.getDouble(Constants.MULTIPLE_SIGN));
                    }
                    expand.addProperty("position", strM64316g);
                } catch (C9721b e11) {
                    C1120a.m6676e("VOTransform", "decryptStructData position failed:" + e11.getMessage());
                } catch (JSONException unused) {
                    C1120a.m6676e("VOTransform", "convertFileInfoJSON setFileInfoExpand JSONException");
                }
                expand.addProperty("position", strM64316g);
                expand.addProperty("positionDEK", asString3);
            }
        }
    }

    /* renamed from: k */
    public static void m61408k(Context context, FileData fileData) throws JSONException {
        String expandString = fileData.getExpandString();
        if (TextUtils.isEmpty(expandString)) {
            C1120a.m6676e("VOTransform", "expandString is empty!");
            return;
        }
        String hash = fileData.getHash();
        try {
            JSONObject jSONObject = new JSONObject(expandString);
            if (TextUtils.isEmpty(fileData.getFileId()) || !fileData.getFileId().equals("NMD")) {
                if (jSONObject.has(SyncProtocol.Constant.DEK)) {
                    jSONObject.remove(SyncProtocol.Constant.DEK);
                }
                if (jSONObject.has("positionDEK")) {
                    jSONObject.remove("positionDEK");
                }
                if (jSONObject.has("createrAccountDEK")) {
                    jSONObject.remove("createrAccountDEK");
                }
                jSONObject.put("createrAccount", C13452e.m80781L().m80900d());
            } else {
                if (!TextUtils.isEmpty(hash) && !jSONObject.has(HicloudH5ConfigManager.KEY_HASH)) {
                    jSONObject.put(HicloudH5ConfigManager.KEY_HASH, hash);
                }
                C11820b.m70397b(context, jSONObject);
            }
            fileData.setExpandString(jSONObject.toString());
        } catch (JSONException unused) {
            C1120a.m6676e("VOTransform", "TransformExpandToServer json error");
        }
    }

    /* renamed from: l */
    public static void m61409l(Context context, FileInfo fileInfo, FileData fileData, int i10, boolean z10) {
        String albumName;
        if (m61404g(fileInfo, i10)) {
            return;
        }
        C1120a.m6675d("VOTransform", "Did not has Save Path, which file is: " + C1122c.m6818p0(fileInfo.getFileName()) + ", thumbType: " + i10);
        String shareId = z10 ? fileInfo.getShareId() : fileInfo.getAlbumId();
        if (TextUtils.isEmpty(shareId)) {
            C1120a.m6676e("VOTransform", "albumId or shareId is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
            return;
        }
        if (shareId.startsWith("default-album-")) {
            albumName = fileData.getLpath();
        } else {
            if (TextUtils.isEmpty(fileInfo.getFileName())) {
                C1120a.m6676e("VOTransform", "Not a default album, album name is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
                return;
            }
            albumName = fileData.getAlbumName();
        }
        String str = albumName;
        if (TextUtils.isEmpty(str)) {
            C1120a.m6676e("VOTransform", "Default album, lpath or albumName is null, which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
            return;
        }
        C1120a.m6675d("VOTransform", "appendParam:" + str + ", which file is: " + C1122c.m6818p0(fileInfo.getFileName()));
        String strM6895p = (i10 == 0 || z10) ? C1125f.m6895p(fileInfo, i10) : C1125f.m6890k(fileInfo, i10);
        String strM61403f = i10 == 0 ? m61403f(context, shareId, strM6895p, fileInfo.getSize(), str) : C12467a.m74744b(context, i10, shareId, strM6895p);
        if (TextUtils.isEmpty(strM61403f)) {
            C1120a.m6675d("VOTransform", "thumbSavePath is null!");
        } else {
            m61405h(fileInfo, i10, strM61403f);
        }
    }
}
