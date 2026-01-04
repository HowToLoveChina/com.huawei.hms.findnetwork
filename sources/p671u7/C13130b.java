package p671u7;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.album.service.p075vo.SimplifyInfo;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.Cipher;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.PictureMetaData;
import com.huawei.android.hicloud.drive.cloudphoto.model.VideoMetaData;
import com.huawei.android.hicloud.security.bean.DataDecryptReq;
import com.huawei.android.hicloud.security.bean.DataEncryptReq;
import com.huawei.android.hicloud.security.bean.EncryptedData;
import com.huawei.android.hicloud.security.bean.UserKeyObject;
import com.huawei.android.hicloud.security.service.UserKeyUtils;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.KeyChain;
import com.huawei.hicloud.base.drive.user.model.User;
import com.huawei.hicloud.request.userk.bean.UserKeyBaseReq;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import hk.C10278a;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p012ab.C0087b;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p283fa.C9679b;
import p312g8.C9894e;
import p365ic.C10466a;
import p783xp.AbstractC13844b;
import p818yp.C14034a;

/* renamed from: u7.b */
/* loaded from: classes2.dex */
public class C13130b {

    /* renamed from: a */
    public static final Gson f59631a = new Gson();

    /* renamed from: a */
    public static Media m78972a(FileInfo fileInfo, boolean z10) throws JSONException, NumberFormatException {
        Media media = new Media();
        media.setAlbumId(fileInfo.getAlbumId());
        media.setFileName(fileInfo.getFileName());
        media.setHashId(fileInfo.getHash());
        media.setSize(Long.valueOf(fileInfo.getSize()));
        media.setSource(fileInfo.getSource());
        media.setFileType(Integer.valueOf(fileInfo.getFileType()));
        media.setCreatedTime(new C4644l(fileInfo.getCreateTime()));
        media.setFavorite(Boolean.valueOf(fileInfo.isFavorite()));
        User user = new User();
        user.setUserId(fileInfo.getUserID());
        media.setOwner(user);
        media.setCreator(new User());
        media.setCipher(fileInfo.getCipher());
        Media mediaM78984m = m78984m(fileInfo.getExpand(), media, z10);
        mediaM78984m.setMimeType(C14034a.m84171h(C10278a.m63442h(fileInfo.getLocalRealPath())).m73356b());
        return mediaM78984m;
    }

    /* renamed from: b */
    public static void m78973b(JSONObject jSONObject, Media media, int i10) throws JSONException {
        Object obj;
        String position;
        if (i10 == 4) {
            if (media.getVideoMetaData() == null) {
                C1120a.m6678w("FileTransformation", "VideoMetaData is empty");
                return;
            } else {
                obj = media.getVideoMetaData().get("#position");
                position = media.getVideoMetaData().getPosition();
            }
        } else if (media.getPictureMetaData() == null) {
            C1120a.m6678w("FileTransformation", "PictureMetaData is empty");
            return;
        } else {
            obj = media.getPictureMetaData().get("#position");
            position = media.getPictureMetaData().getPosition();
        }
        if (obj == null) {
            C1120a.m6678w("FileTransformation", "posEncrypted is null");
            C9894e.m61398a(jSONObject, media.getCipher(), position);
            return;
        }
        if (media.getCipher() == null) {
            C1120a.m6678w("FileTransformation", "cipher is null");
            return;
        }
        if (media.getCipher().getKeyChains().size() == 0) {
            C1120a.m6678w("FileTransformation", "keychains is empty");
            return;
        }
        String[] strArrSplit = ((String) obj).split("\\|");
        if (strArrSplit.length < 2) {
            C1120a.m6676e("FileTransformation", "posEncrypted is illegal");
            return;
        }
        DataDecryptReq dataDecryptReq = new DataDecryptReq();
        dataDecryptReq.setEdek(media.getCipher().getKeyChains().get(0).getEkey());
        dataDecryptReq.setSrcData(strArrSplit[1]);
        try {
            UserKeyObject userKeyObjectM78975d = m78975d(media.getCipher().getKeyChains().get(0));
            if (userKeyObjectM78975d != null) {
                String strM64317h = C10466a.m64317h(userKeyObjectM78975d, dataDecryptReq);
                if (TextUtils.isEmpty(strM64317h)) {
                    C1120a.m6678w("FileTransformation", "position is empty");
                } else {
                    jSONObject.put("position", strM64317h);
                }
            }
        } catch (C9721b e10) {
            C1120a.m6676e("FileTransformation", "decrypt position data error: " + e10.getMessage());
        }
    }

    /* renamed from: c */
    public static void m78974c(Media media, int i10, String str, boolean z10) {
        if (media.getCipher() != null) {
            C1120a.m6675d("FileTransformation", "cipher is already created");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C1120a.m6678w("FileTransformation", "pos is empty");
            return;
        }
        try {
            String strM83106b = AbstractC13844b.m83106b();
            DataEncryptReq dataEncryptReq = new DataEncryptReq();
            dataEncryptReq.setDek(strM83106b);
            dataEncryptReq.setSrcData(str);
            try {
                EncryptedData encryptedDataM64324o = C10466a.m64324o(new C0087b(C9679b.m60452d().m60455e(), C1122c.m6833t0(C0213f.m1377a())).m680c("", 12, UserKeyBaseReq.KEY_TYPE_AES_128), dataEncryptReq);
                try {
                    EncryptedData encryptedDataM64324o2 = C10466a.m64324o(new C0087b(C9679b.m60452d().m60455e(), C1122c.m6833t0(C0213f.m1377a())).m681d("", 12, UserKeyBaseReq.KEY_TYPE_AES_256), dataEncryptReq);
                    Cipher cipher = new Cipher();
                    cipher.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
                    cipher.setDataType(12);
                    ArrayList arrayList = new ArrayList();
                    if (z10) {
                        KeyChain keyChain = new KeyChain();
                        keyChain.setEkey(encryptedDataM64324o.getEdek());
                        keyChain.setType(1);
                        keyChain.setId(encryptedDataM64324o.getKeyGuid());
                        keyChain.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_128_FULL);
                        arrayList.add(keyChain);
                    }
                    KeyChain keyChain2 = new KeyChain();
                    keyChain2.setEkey(encryptedDataM64324o2.getEdek());
                    keyChain2.setType(3);
                    keyChain2.setId(encryptedDataM64324o2.getKeyGuid());
                    keyChain2.setAlgorithm(UserKeyBaseReq.KEY_TYPE_AES_256_FULL);
                    arrayList.add(keyChain2);
                    cipher.setKeyChains(arrayList);
                    media.setCipher(cipher);
                    if (i10 == 4) {
                        if (media.getVideoMetaData() == null) {
                            media.setVideoMetaData(new VideoMetaData());
                        }
                        media.getVideoMetaData().set("#position", (Object) ("3|" + encryptedDataM64324o.getData()));
                        return;
                    }
                    if (media.getPictureMetaData() == null) {
                        media.setPictureMetaData(new PictureMetaData());
                    }
                    media.getPictureMetaData().set("#position", (Object) ("3|" + encryptedDataM64324o.getData()));
                } catch (C9721b e10) {
                    C1120a.m6676e("FileTransformation", "Encrypt pos fail skey, errorCode = " + e10.m60659c() + ", msg = " + e10.getMessage());
                }
            } catch (C9721b e11) {
                C1120a.m6676e("FileTransformation", "Encrypt pos fail ekey, errorCode = " + e11.m60659c() + ", msg = " + e11.getMessage());
            }
        } catch (NoSuchAlgorithmException e12) {
            C1120a.m6676e("FileTransformation", "getChallenge exception: " + e12.toString());
        }
    }

    /* renamed from: d */
    public static UserKeyObject m78975d(KeyChain keyChain) throws C9721b {
        C1120a.m6675d("FileTransformation", "getMatchUserKey");
        String id2 = keyChain.getId();
        C0087b c0087b = new C0087b(C9679b.m60452d().m60455e(), C1122c.m6833t0(C0213f.m1377a()));
        UserKeyObject userKeyObjectM680c = c0087b.m680c("", 12, UserKeyBaseReq.KEY_TYPE_AES_128);
        if (TextUtils.isEmpty(id2) || id2.equals(userKeyObjectM680c.getUserKeyGuid())) {
            return userKeyObjectM680c;
        }
        UserKeyObject userKeyObjectM681d = c0087b.m681d("", 12, UserKeyBaseReq.KEY_TYPE_AES_256);
        if (id2.equals(userKeyObjectM681d.getUserKeyGuid())) {
            return userKeyObjectM681d;
        }
        UserKeyObject syncUser = UserKeyUtils.getInstance().getSyncUser(0, "");
        if (id2.equals(userKeyObjectM681d.getUserKeyGuid())) {
            return syncUser;
        }
        C1120a.m6678w("FileTransformation", "no match userKey.");
        return null;
    }

    /* renamed from: e */
    public static String m78976e(String str) {
        return TextUtils.isEmpty(str) ? "" : str.length() > 6 ? SafeString.substring(str, str.length() - 6) : str;
    }

    /* renamed from: f */
    public static void m78977f(Media media, int i10, String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str) || i10 != 4) {
            return;
        }
        try {
            int i11 = Integer.parseInt(str);
            if (media.getVideoMetaData() == null) {
                media.setVideoMetaData(new VideoMetaData());
            }
            media.getVideoMetaData().setDurationTime(Integer.valueOf(i11));
        } catch (NumberFormatException e10) {
            C1120a.m6676e("FileTransformation", "initDuration error " + e10.toString());
        }
    }

    /* renamed from: g */
    public static void m78978g(Media media, int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split(Constants.MULTIPLE_SIGN);
            if (strArrSplit.length != 2) {
                return;
            }
            if (i10 == 4) {
                if (media.getVideoMetaData() == null) {
                    media.setVideoMetaData(new VideoMetaData());
                }
                media.getVideoMetaData().setWidth(Integer.valueOf(C0241z.m1685c(strArrSplit[0])));
                media.getVideoMetaData().setHeight(Integer.valueOf(C0241z.m1685c(strArrSplit[1])));
                return;
            }
            if (media.getPictureMetaData() == null) {
                media.setPictureMetaData(new PictureMetaData());
            }
            media.getPictureMetaData().setWidth(Integer.valueOf(C0241z.m1685c(strArrSplit[0])));
            media.getPictureMetaData().setHeight(Integer.valueOf(C0241z.m1685c(strArrSplit[1])));
        } catch (Exception unused) {
            C1120a.m6676e("FileTransformation", "resolution error");
        }
    }

    /* renamed from: h */
    public static void m78979h(Media media, int i10, String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int i11 = Integer.parseInt(str);
            if (i10 == 4) {
                if (media.getVideoMetaData() == null) {
                    media.setVideoMetaData(new VideoMetaData());
                }
                media.getVideoMetaData().setRotation(Integer.valueOf(i11));
            } else {
                if (media.getPictureMetaData() == null) {
                    media.setPictureMetaData(new PictureMetaData());
                }
                media.getPictureMetaData().setRotation(Integer.valueOf(i11));
            }
        } catch (NumberFormatException e10) {
            C1120a.m6676e("FileTransformation", "initRotate error " + e10.toString());
        }
    }

    /* renamed from: i */
    public static String m78980i(Media media) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            int iIntValue = media.getFileType().intValue();
            Map<String, String> properties = media.getProperties();
            if (properties.size() > 0) {
                jSONObject = new JSONObject(properties);
            }
            User creator = media.getCreator();
            if (creator != null) {
                jSONObject.put("createrId", creator.getUserId());
                if (properties.containsKey("createrAccount")) {
                    jSONObject.put("createrAccount", properties.get("createrAccount"));
                } else {
                    jSONObject.put("createrAccount", creator.getDisplayName());
                }
            }
            PictureMetaData pictureMetaData = media.getPictureMetaData();
            VideoMetaData videoMetaData = media.getVideoMetaData();
            m78973b(jSONObject, media, iIntValue);
            m78981j(jSONObject, pictureMetaData, videoMetaData);
            Cipher cipher = media.getCipher();
            if (cipher != null && cipher.getKeyChains() != null && cipher.getKeyChains().size() > 0) {
                jSONObject.put(SyncProtocol.Constant.DEK, cipher.getKeyChains().get(0).getEkey());
            }
            jSONObject.put("description", media.getDescription());
            if (iIntValue == 4) {
                if (videoMetaData != null && videoMetaData.getWidth() != null && videoMetaData.getHeight() != null) {
                    jSONObject.put("resolution", videoMetaData.getWidth() + Constants.MULTIPLE_SIGN + videoMetaData.getHeight());
                }
            } else if (pictureMetaData != null && pictureMetaData.getWidth() != null && pictureMetaData.getHeight() != null) {
                jSONObject.put("resolution", pictureMetaData.getWidth() + Constants.MULTIPLE_SIGN + pictureMetaData.getHeight());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            C1120a.m6676e("FileTransformation", "packageExpand error");
            return null;
        }
    }

    /* renamed from: j */
    public static void m78981j(JSONObject jSONObject, PictureMetaData pictureMetaData, VideoMetaData videoMetaData) throws JSONException {
        if (pictureMetaData != null && pictureMetaData.getRotation() != null) {
            jSONObject.put("rotate", String.valueOf(pictureMetaData.getRotation()));
        }
        if (videoMetaData != null) {
            if (videoMetaData.getRotation() != null) {
                jSONObject.put("rotate", String.valueOf(videoMetaData.getRotation()));
            }
            if (videoMetaData.getDurationTime() != null) {
                jSONObject.put("duration", String.valueOf(videoMetaData.getDurationTime()));
            }
        }
    }

    /* renamed from: k */
    public static void m78982k(Media media, String str, int i10) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if ("description".equals(next)) {
                media.setDescription(strOptString);
            }
            if ("rotate".equals(next)) {
                m78979h(media, i10, strOptString);
            }
            m78983l(map, next, strOptString);
        }
        media.setProperties(map);
    }

    /* renamed from: l */
    public static void m78983l(Map<String, String> map, String str, String str2) {
        if ("createrId".equals(str) || "position".equals(str) || "rotate".equals(str) || "duration".equals(str) || "resolution".equals(str) || "description".equals(str) || "createrAccount".equals(str)) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: m */
    public static Media m78984m(String str, Media media, boolean z10) throws JSONException, NumberFormatException {
        try {
            int iIntValue = media.getFileType().intValue();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                String strValueOf = obj instanceof String ? String.valueOf(obj) : "";
                if (obj instanceof Integer) {
                    strValueOf = String.valueOf((Integer) obj);
                }
                if ("createrId".equals(next)) {
                    media.getCreator().setUserId(strValueOf);
                } else if ("position".equals(next)) {
                    m78974c(media, iIntValue, strValueOf, z10);
                } else if ("rotate".equals(next)) {
                    m78979h(media, iIntValue, strValueOf);
                } else if ("duration".equals(next)) {
                    m78977f(media, iIntValue, strValueOf);
                } else if ("resolution".equals(next)) {
                    m78978g(media, iIntValue, strValueOf);
                } else if ("description".equals(next)) {
                    media.setDescription(strValueOf);
                } else if (!"createrAccount".equals(next)) {
                    map.put(next, strValueOf);
                }
            }
            media.setProperties(map);
        } catch (JSONException unused) {
            C1120a.m6676e("FileTransformation", "JSONException expandJson split error");
        }
        return media;
    }

    /* renamed from: n */
    public static void m78985n(Media media, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int iIntValue = media.getFileType().intValue();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                String strValueOf = obj instanceof String ? String.valueOf(obj) : "";
                if (obj instanceof Integer) {
                    strValueOf = String.valueOf(obj);
                }
                if ("createrId".equals(next)) {
                    if (media.getCreator() == null) {
                        media.setCreator(new User());
                    }
                    media.getCreator().setUserId(strValueOf);
                } else if ("rotate".equals(next)) {
                    m78979h(media, iIntValue, strValueOf);
                } else if ("duration".equals(next)) {
                    m78977f(media, iIntValue, strValueOf);
                } else if ("resolution".equals(next)) {
                    m78978g(media, iIntValue, strValueOf);
                } else if (!"createrAccount".equals(next)) {
                    map.put(next, strValueOf);
                }
            }
            media.setProperties(map);
        } catch (Exception unused) {
            C1120a.m6676e("FileTransformation", "splitExpandForV1 Exception");
        }
    }

    /* renamed from: o */
    public static FileData m78986o(Change change, long j10) throws JSONException {
        FileData fileData = new FileData();
        fileData.setDeviceId(change.getDevice());
        if (change.getDeleted().booleanValue()) {
            fileData.setOtype("2");
            fileData.setFileId(change.getMediaId());
            fileData.setUniqueId(change.getMediaId());
            fileData.setOversion(j10);
            fileData.setHash(change.getMediaHashId());
            fileData.setAlbumId(change.getAlbumId());
            return fileData;
        }
        Media media = change.getMedia();
        if (media == null) {
            return null;
        }
        fileData.setOtype("1");
        fileData.setOversion(j10);
        fileData.setFileId(media.getId());
        fileData.setUniqueId(media.getId());
        fileData.setAlbumId(media.getAlbumId());
        if (media.getCreatedTime() == null) {
            C1120a.m6678w("FileTransformation", "createTime null, id: " + m78976e(media.getId()));
        } else {
            fileData.setCreateTime(media.getCreatedTime().m28458c());
        }
        fileData.setFavorite(media.getFavorite() == null ? false : media.getFavorite().booleanValue());
        fileData.setFileName(media.getFileName() == null ? "" : media.getFileName());
        fileData.setFileType(media.getFileType().intValue());
        fileData.setHash(media.getHashId());
        fileData.setUserID(media.getMediaOwnerId());
        fileData.setSize(media.getSize() == null ? 0L : media.getSize().longValue());
        fileData.setSource(media.getSource());
        fileData.setThumbFileId("");
        fileData.setLcdFileId("");
        fileData.setThumbUrl("");
        fileData.setFileUrl("");
        fileData.setSdsctime("");
        if (media.getEditedTime() == null) {
            C1120a.m6678w("FileTransformation", "editedTime null, id: " + m78976e(media.getId()));
        } else {
            fileData.setSdsmtime(C1122c.m6721O(media.getEditedTime().m28458c()));
        }
        if (media.getRecycled() == null || !media.getRecycled().booleanValue()) {
            fileData.setRecycleAlbumId("");
        } else {
            fileData.setRecycleAlbumId("default-album-3");
            if (media.getRecycledTime() == null) {
                C1120a.m6678w("FileTransformation", "recycledTime null, id: " + m78976e(media.getId()));
            } else {
                fileData.setRecycleTime(media.getRecycledTime().m28458c());
            }
            fileData.setAlbumId("default-album-3");
            fileData.setSrcAlbumId(media.getAlbumId());
        }
        fileData.setDstAlbumId("");
        fileData.setTimestamp(0L);
        fileData.setLocalThumbPath("");
        fileData.setLocalBigThumbPath("");
        fileData.setLocalRealPath("");
        fileData.setFileUploadType("");
        fileData.setLpath("");
        fileData.setAlbumName("");
        fileData.setResource("");
        fileData.setLocalId("");
        fileData.setSrcAlbumId("");
        String strM78980i = m78980i(media);
        fileData.setExpandString(strM78980i);
        fileData.setExpand(m78988q(strM78980i));
        return fileData;
    }

    /* renamed from: p */
    public static FileData m78987p(Media media, boolean z10) {
        FileData fileData = new FileData();
        fileData.setAlbumId(media.getAlbumId());
        if (media.getCreatedTime() == null) {
            C1120a.m6678w("FileTransformation", "createTime null, id: " + m78976e(media.getId()));
        } else {
            fileData.setCreateTime(media.getCreatedTime().m28458c());
        }
        fileData.setFavorite(media.getFavorite() == null ? false : media.getFavorite().booleanValue());
        fileData.setFileName(media.getFileName() == null ? "" : media.getFileName());
        fileData.setFileType(media.getFileType().intValue());
        fileData.setHash(media.getHashId());
        fileData.setFileId(media.getId());
        fileData.setUniqueId(media.getId());
        fileData.setUserID(media.getMediaOwnerId());
        fileData.setSize(media.getSize() == null ? 0L : media.getSize().longValue());
        fileData.setSource(media.getSource());
        fileData.setThumbFileId("");
        fileData.setLcdFileId("");
        fileData.setThumbUrl("");
        fileData.setFileUrl("");
        fileData.setOversion(0L);
        fileData.setOtype("0");
        fileData.setSdsctime("");
        if (media.getEditedTime() == null) {
            C1120a.m6678w("FileTransformation", "editedTime null, id: " + m78976e(media.getId()));
        } else {
            fileData.setSdsmtime(C1122c.m6721O(media.getEditedTime().m28458c()));
        }
        if (z10) {
            fileData.setRecycleAlbumId("default-album-3");
            if (media.getRecycledTime() == null) {
                C1120a.m6678w("FileTransformation", "recycledTime null, id: " + m78976e(media.getId()));
            } else {
                fileData.setRecycleTime(media.getRecycledTime().m28458c());
            }
        } else {
            fileData.setRecycleAlbumId("");
        }
        fileData.setDstAlbumId("");
        fileData.setTimestamp(0L);
        fileData.setLocalThumbPath("");
        fileData.setLocalBigThumbPath("");
        fileData.setLocalRealPath("");
        fileData.setFileUploadType("");
        fileData.setLpath("");
        fileData.setAlbumName("");
        fileData.setResource("");
        fileData.setLocalId("");
        fileData.setSrcAlbumId("");
        String strM78980i = m78980i(media);
        fileData.setExpandString(strM78980i);
        fileData.setExpand(m78988q(strM78980i));
        return fileData;
    }

    /* renamed from: q */
    public static JsonObject m78988q(String str) {
        try {
            return (JsonObject) f59631a.fromJson(str, JsonObject.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: r */
    public static SimplifyInfo m78989r(Media media) {
        SimplifyInfo simplifyInfo = new SimplifyInfo();
        simplifyInfo.setAlbumId(media.getAlbumId());
        if (media.getCreatedTime() == null) {
            C1120a.m6678w("FileTransformation", "createTime null, id: " + m78976e(media.getId()));
        } else {
            simplifyInfo.setCreateTime(media.getCreatedTime().m28458c());
        }
        simplifyInfo.setUniqueId(media.getId());
        if (media.getEditedTime() == null) {
            C1120a.m6678w("FileTransformation", "editedTime null, id: " + m78976e(media.getId()));
        } else {
            simplifyInfo.setSdsmtime(C1122c.m6721O(media.getEditedTime().m28458c()));
        }
        return simplifyInfo;
    }
}
