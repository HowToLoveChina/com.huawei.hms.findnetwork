package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.drive.cloudphoto.model.MediaList;
import com.huawei.android.hicloud.drive.cloudphoto.request.Medias;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.secure.android.common.util.SafeString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p547p7.C12113a;
import p547p7.C12115c;
import p649t6.C12942b;
import p649t6.C12946f;
import p671u7.C13130b;

/* renamed from: t7.k */
/* loaded from: classes2.dex */
public class C12973k extends AbstractC12988v {

    /* renamed from: g */
    public int f59087g;

    /* renamed from: h */
    public int f59088h;

    /* renamed from: i */
    public boolean f59089i;

    /* renamed from: l */
    public long f59092l = 0;

    /* renamed from: j */
    public C12942b f59090j = new C12942b();

    /* renamed from: k */
    public C12946f f59091k = new C12946f();

    public C12973k(int i10, int i11, boolean z10) {
        this.f59087g = i10;
        this.f59088h = i11;
        this.f59089i = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [t7.k, t7.v, x6.d] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [t7.v] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.os.BaseBundle, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r5v37, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v42, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v10, types: [int] */
    /* JADX WARN: Type inference failed for: r8v13, types: [int] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [int] */
    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Throwable {
        String str;
        String str2;
        String str3;
        ?? M6802l0;
        String str4;
        String str5;
        String string;
        String str6;
        String str7;
        String string2;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z10;
        ?? r12 = this;
        C1120a.m6675d("GetAllFilesExecutor", "execute, offset=" + r12.f59087g + ", limit=" + r12.f59088h + ", isRecycleAlbumFlag=" + r12.f59089i);
        r12.f59133f = new Bundle();
        ?? arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        if (r12.f59089i) {
            str = "recycled = true and (albumType = 0)";
            str2 = "default-album-3";
        } else {
            str = "recycled = false and (albumType = 0)";
            str2 = "GetAllFilesExecutor";
        }
        int i10 = r12.f59087g;
        String str12 = ", cursor: ";
        String str13 = str;
        String str14 = "code";
        if (i10 != 0) {
            String strM77757n = r12.f59090j.m77757n(str2, i10);
            if (TextUtils.isEmpty(strM77757n)) {
                C1120a.m6678w("GetAllFilesExecutor", "GetAllFilesExecutor transfer nextCursor error, clear cache");
                r12.f59133f.putInt("code", FamilyShareConstants.StatusCode.FAMILY_SHARE_NOT_OPEN);
                r12.f59133f.putString("info", "offset to nextCursor error");
                C1122c.m6821q();
                return "";
            }
            if (strM77757n.equals("COMPLETE")) {
                C1120a.m6678w("GetAllFilesExecutor", "GetAllFilesExecutor complete, return success");
                r12.f59133f.putParcelableArrayList("FileInfoList", arrayList);
                r12.f59133f.putBoolean("HasMore", false);
                r12.f59133f.putString("errMsg", "offset: " + r12.f59087g + ", size: " + arrayList.size() + ", hasMore: false, cursor: " + strM77757n);
                r12.f59133f.putBoolean("IsRecycleAlbum", r12.f59089i);
                r12.f59133f.putInt("code", 0);
                r12.f59133f.putString("info", "OK");
                return "";
            }
            str4 = "IsRecycleAlbum";
            str12 = ", cursor: ";
            M6802l0 = ", hasMore: ";
            str3 = "OK";
            str6 = "code";
            str5 = "info";
            string = strM77757n;
        } else {
            str3 = "OK";
            M6802l0 = ", hasMore: ";
            str4 = "IsRecycleAlbum";
            str5 = "info";
            r12.f59090j.m77753j(str2);
            string = null;
            str6 = "code";
        }
        try {
            try {
                try {
                    try {
                        if (r12.f59087g == 0) {
                            try {
                                str8 = str4;
                                str9 = "errMsg";
                                r12.f59133f.putInt("Total", 0);
                                if (!r12.f59089i) {
                                    C12115c.m72560h().m72584y(C12115c.m72560h().m72578s());
                                    C12115c.m72560h().m72580u();
                                    C12115c.m72560h().m72579t();
                                    C12115c.m72560h().m72562b();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                str14 = str5;
                                arrayList = str6;
                                M6802l0 = 0;
                                r12.f59133f.putInt(arrayList, M6802l0);
                                r12.f59133f.putString(str14, str3);
                                throw th;
                            }
                        } else {
                            str9 = "errMsg";
                            str8 = str4;
                        }
                        Medias.List fields2 = r12.f61708b.m83556m().list("0").setPageSize(Integer.valueOf(r12.f59088h)).setQueryParam(str13).setOrderBy("createdTime desc").setCursor(string).setFields2("nextCursor,media(albumId,createdTime,editedTime,favorite,fileName,fileType,hashId,sha256,id,status,mediaOwnerId,properties,size,source,recycledTime,recycled,creator(userId,displayName),pictureMetadata,videoMetadata,cipher,description)");
                        fields2.getHeaders().set("x-hw-trace-id", r12.f61710d);
                        MediaList mediaListExecute = fields2.execute();
                        r12.m77921q(arrayList, sb2, mediaListExecute.getMedia());
                        String nextCursor = mediaListExecute.getNextCursor();
                        if (TextUtils.isEmpty(nextCursor)) {
                            str10 = "offset: ";
                            str11 = "HasMore";
                            if (r12.f59089i) {
                                C1120a.m6677i("GetAllFilesExecutor", "nextCursor is empty");
                                C1136q.b.m7117z0(C0213f.m1377a(), true);
                            }
                            r12.f59090j.m77756m(str2, r12.f59087g + r12.f59088h, "COMPLETE");
                            z10 = false;
                        } else {
                            str10 = "offset: ";
                            str11 = "HasMore";
                            r12.f59090j.m77756m(str2, r12.f59087g + r12.f59088h, nextCursor);
                            z10 = true;
                        }
                        ?? sb3 = new StringBuilder();
                        sb3.append("code: ");
                        try {
                            sb3.append(0);
                            sb3.append(", info: ");
                            sb3.append(str3);
                            sb3.append(", size: ");
                            sb3.append(arrayList.size());
                            sb3.append(M6802l0);
                            sb3.append(z10);
                            sb3.append(str12);
                            sb3.append(nextCursor);
                            sb3.append(", uniqueIds: ");
                            sb3.append(sb2);
                            sb3.append(", hideListSize: ");
                            sb3.append(r12.f59092l);
                            C1120a.m6677i("GetAllFilesExecutor", sb3.toString());
                            r12.f59133f.putParcelableArrayList("FileInfoList", arrayList);
                            r12.f59133f.putBoolean(str11, z10);
                            String strM77922r = r12.m77922r(nextCursor, 6);
                            ?? sb4 = new StringBuilder();
                            sb4.append(str10);
                            sb4.append(r12.f59087g);
                            sb4.append(", size: ");
                            sb4.append(arrayList.size());
                            sb4.append(", total: ");
                            try {
                                sb4.append(0);
                                sb4.append(M6802l0);
                                sb4.append(z10);
                                sb4.append(str12);
                                sb4.append(strM77922r);
                                r12.f59133f.putString(str9, sb4.toString() + ", hideListSize: " + r12.f59092l);
                                r12.f59133f.putBoolean(str8, r12.f59089i);
                                r12.f59133f.putInt(str6, 0);
                                r12.f59133f.putString(str5, str3);
                            } catch (IOException e10) {
                                e = e10;
                                string = null;
                                str14 = str5;
                                arrayList = str6;
                                C1120a.m6676e("GetAllFilesExecutor", "GetAllFilesExecutor runTask IOException: " + e.toString());
                                if (e instanceof C4616s) {
                                    C4616s c4616s = (C4616s) e;
                                    M6802l0 = C1122c.m6802l0(c4616s);
                                    string = e.toString();
                                    try {
                                        if (r12.m77943n(M6802l0, c4616s)) {
                                            C1120a.m6678w("GetAllFilesExecutor", "GetAllFilesExecutor cursor invalid, clear cache");
                                            C1122c.m6821q();
                                        }
                                        string2 = string;
                                        arrayList = arrayList;
                                        M6802l0 = M6802l0;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str3 = string;
                                        r12.f59133f.putInt(arrayList, M6802l0);
                                        r12.f59133f.putString(str14, str3);
                                        throw th;
                                    }
                                } else {
                                    int iM6845x0 = C1122c.m6845x0(e);
                                    string2 = e.toString();
                                    arrayList = arrayList;
                                    M6802l0 = iM6845x0;
                                }
                                r12.f59133f.putInt(arrayList, M6802l0);
                                r12 = r12.f59133f;
                                r12.putString(str14, string2);
                                C0068f.m459d().m468l();
                                return "";
                            } catch (Exception e11) {
                                e = e11;
                                string = null;
                                str14 = str5;
                                str7 = str6;
                                C1120a.m6676e("GetAllFilesExecutor", "GetAllFilesExecutor runTask Exception: " + e.toString());
                                M6802l0 = 9000;
                                string2 = e.toString();
                                arrayList = str7;
                                r12.f59133f.putInt(arrayList, M6802l0);
                                r12 = r12.f59133f;
                                r12.putString(str14, string2);
                                C0068f.m459d().m468l();
                                return "";
                            } catch (Throwable th4) {
                                th = th4;
                                string = null;
                                str14 = str5;
                                arrayList = str6;
                                M6802l0 = string;
                                r12.f59133f.putInt(arrayList, M6802l0);
                                r12.f59133f.putString(str14, str3);
                                throw th;
                            }
                        } catch (IOException e12) {
                            e = e12;
                            string = null;
                        } catch (Exception e13) {
                            e = e13;
                            string = null;
                        } catch (Throwable th5) {
                            th = th5;
                            string = null;
                        }
                    } catch (IOException e14) {
                        e = e14;
                        str14 = str5;
                        arrayList = str6;
                        string = null;
                    } catch (Exception e15) {
                        e = e15;
                        str14 = str5;
                        str7 = str6;
                        string = null;
                    }
                    C0068f.m459d().m468l();
                    return "";
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            th = th8;
            str14 = str5;
            arrayList = str6;
            string = null;
        }
    }

    /* renamed from: q */
    public final void m77921q(ArrayList<FileData> arrayList, StringBuilder sb2, List<Media> list) {
        if (list != null) {
            C1120a.m6677i("GetAllFilesExecutor", "mediaList size: " + list.size());
            ArrayList<C12113a> arrayList2 = new ArrayList<>();
            boolean zM72569j = C12115c.m72560h().m72569j();
            for (Media media : list) {
                if (media != null) {
                    if (C12115c.m72560h().m72573n(media.getStatus().intValue(), zM72569j)) {
                        C1120a.m6675d("GetAllFilesExecutor", "hideMediaAtFullSync, " + media.getId());
                        arrayList2.add(new C12113a(media));
                    } else {
                        if (C1443a.f6214b.booleanValue()) {
                            C1120a.m6675d("GetAllFilesExecutor", "analysisMedia: " + media.toString());
                        }
                        FileData fileDataM78987p = C13130b.m78987p(media, this.f59089i);
                        if (TextUtils.isEmpty(fileDataM78987p.getAlbumId())) {
                            C1120a.m6678w("GetAllFilesExecutor", "AlbumId Hash is empty");
                        }
                        if (TextUtils.isEmpty(fileDataM78987p.getHash())) {
                            C1120a.m6678w("GetAllFilesExecutor", "Hash is empty");
                            fileDataM78987p.setHash(media.getProperties().get(HicloudH5ConfigManager.KEY_HASH));
                        }
                        FileData fileData = new FileData(fileDataM78987p);
                        arrayList.add(fileData);
                        sb2.append(m77922r(fileData.getUniqueId(), 6));
                        sb2.append(",");
                    }
                }
            }
            this.f59091k.m77776i(arrayList2);
            this.f59092l = arrayList2.size();
        }
    }

    /* renamed from: r */
    public final String m77922r(String str, int i10) {
        return TextUtils.isEmpty(str) ? "" : str.length() > i10 ? SafeString.substring(str, str.length() - i10) : str;
    }
}
