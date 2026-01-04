package p650t7;

import android.os.Bundle;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.hicloud.drive.cloudphoto.model.Change;
import com.huawei.android.hicloud.drive.cloudphoto.model.ChangeList;
import com.huawei.android.hicloud.drive.cloudphoto.request.Changes;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p009a8.C0068f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p671u7.C13130b;
import p765x7.C13719a;

/* renamed from: t7.g0 */
/* loaded from: classes2.dex */
public class C12966g0 extends AbstractC12988v {

    /* renamed from: g */
    public String f59067g;

    /* renamed from: h */
    public String f59068h;

    /* renamed from: i */
    public long f59069i;

    /* renamed from: j */
    public int f59070j;

    /* renamed from: k */
    public String f59071k;

    public C12966g0(String str, String str2, long j10, int i10, String str3) {
        this.f59067g = str;
        this.f59068h = str2;
        this.f59069i = j10;
        this.f59070j = i10;
        this.f59071k = str3;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() {
        long jM1688f;
        String strM82477e;
        int iM6802l0;
        String string;
        FileData fileDataM78986o;
        this.f59133f = new Bundle();
        ArrayList<FileData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(this.f59071k)) {
            jM1688f = this.f59069i;
            strM82477e = C13719a.m82477e(String.valueOf(jM1688f));
        } else {
            jM1688f = C0241z.m1688f(this.f59071k);
            strM82477e = C13719a.m82477e(this.f59071k);
        }
        try {
            try {
                try {
                    Changes.List listAddHeader = this.f61708b.m83546c().list(strM82477e).setPageSize(Integer.valueOf(this.f59070j)).setKinds(ReportRisksCallable.RISK_INFO_CREATE_KIND).setFields2("newStartCursor,nextCursor,changes(changeType,device,deleted,albumId,mediaId,mediaHashId,media(id,status,mediaOwnerId,fileName,hashId,fileType,favorite,recycled,recycledTime,albumId,properties,createdTime,editedTime,size,source,deviceId,creator(userId,displayName),pictureMetadata,videoMetadata,cipher,description))").addHeader("x-hw-trace-id", (Object) this.f61710d);
                    C4609l headers = listAddHeader.getHeaders();
                    headers.put("x-hw-album-owner-Id", (Object) this.f59068h);
                    headers.put("x-hw-album-Id", (Object) this.f59067g);
                    ChangeList changeListExecute = listAddHeader.execute();
                    if (C1443a.f6214b.booleanValue()) {
                        C1120a.m6675d("ShareFileIncExecutor", "changeList: " + changeListExecute.toString());
                    }
                    List<Change> changes = changeListExecute.getChanges();
                    if (changes != null) {
                        C1120a.m6677i("ShareFileIncExecutor", "changeList size: " + changes.size());
                        for (Change change : changes) {
                            if (change != null && (fileDataM78986o = C13130b.m78986o(change, jM1688f)) != null && this.f59067g.equals(fileDataM78986o.getAlbumId())) {
                                arrayList.add(new FileData(fileDataM78986o));
                            }
                        }
                    }
                    String bigNextCursor = changeListExecute.getBigNextCursor();
                    String bigStartCursor = changeListExecute.getBigStartCursor();
                    C1120a.m6677i("ShareFileIncExecutor", "code: 0, info: OK, size: " + arrayList.size() + ", cursor: " + bigNextCursor);
                    m77911q(arrayList, bigNextCursor, bigStartCursor);
                    this.f59133f.putParcelableArrayList("FileInfoList", arrayList);
                    this.f59133f.putString("Cursor", bigNextCursor);
                    this.f59133f.putInt("code", 0);
                    this.f59133f.putString("info", "OK");
                } catch (IOException e10) {
                    C1120a.m6676e("ShareFileIncExecutor", "ShareFileIncExecutor runTask IOException: " + e10.toString());
                    if (e10 instanceof C4616s) {
                        C4616s c4616s = (C4616s) e10;
                        iM6802l0 = C1122c.m6802l0(c4616s);
                        String string2 = e10.toString();
                        if (m77943n(iM6802l0, c4616s)) {
                            C1120a.m6678w("ShareFileIncExecutor", "ShareFileIncExecutor cursor invalid, clear cache");
                            C1122c.m6821q();
                        }
                        string = string2;
                    } else {
                        iM6802l0 = C1122c.m6845x0(e10);
                        string = e10.toString();
                    }
                    this.f59133f.putInt("code", iM6802l0);
                    this.f59133f.putString("info", string);
                    C0068f.m459d().m468l();
                    return "";
                }
            } catch (Exception e11) {
                C1120a.m6676e("ShareFileIncExecutor", "ShareFileIncExecutor runTask Exception: " + e11.toString());
                iM6802l0 = ConnectionResult.NETWORK_ERROR;
                string = e11.toString();
                this.f59133f.putInt("code", iM6802l0);
                this.f59133f.putString("info", string);
                C0068f.m459d().m468l();
                return "";
            }
            C0068f.m459d().m468l();
            return "";
        } catch (Throwable th2) {
            this.f59133f.putInt("code", 0);
            this.f59133f.putString("info", "OK");
            throw th2;
        }
    }

    /* renamed from: q */
    public final void m77911q(ArrayList<FileData> arrayList, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (arrayList.size() > 0) {
                arrayList.get(arrayList.size() - 1).setOversion(C0241z.m1688f(str));
            }
        } else {
            if (arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
                return;
            }
            arrayList.get(arrayList.size() - 1).setOversion(C0241z.m1688f(str2));
        }
    }
}
