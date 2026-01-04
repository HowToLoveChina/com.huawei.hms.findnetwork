package p650t7;

import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.android.hicloud.album.service.p075vo.AlbumUpdatedResult;
import com.huawei.android.hicloud.album.service.p075vo.GeneralAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.request.Albums;
import com.huawei.android.hicloud.drive.cloudphoto.request.CloudPhotoBatch;
import com.huawei.cloud.base.http.C4609l;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hicloud.base.drive.model.ErrorResp;
import com.huawei.hms.api.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p009a8.C0068f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p635s7.C12734h;
import p671u7.C13129a;
import p804ya.AbstractC13926c;

/* renamed from: t7.z */
/* loaded from: classes2.dex */
public class C12992z extends AbstractC12988v {

    /* renamed from: g */
    public List<GeneralAlbumData> f59140g;

    /* renamed from: h */
    public ShareAlbumData f59141h;

    /* renamed from: i */
    public List<GeneralAlbumData> f59142i = new ArrayList();

    /* renamed from: t7.z$a */
    public static class a extends AbstractC13926c<Album> {

        /* renamed from: a */
        public GeneralAlbumData f59143a;

        /* renamed from: b */
        public ArrayList<AlbumUpdatedResult> f59144b;

        /* renamed from: c */
        public List<String> f59145c;

        /* renamed from: d */
        public List<GeneralAlbumData> f59146d;

        public a(GeneralAlbumData generalAlbumData, ArrayList<AlbumUpdatedResult> arrayList, List<String> list, List<GeneralAlbumData> list2) {
            this.f59143a = generalAlbumData;
            this.f59144b = arrayList;
            this.f59145c = list;
            this.f59146d = list2;
        }

        @Override // p804ya.AbstractC13926c
        /* renamed from: a */
        public void mo74862a(ErrorResp.Error error, C4609l c4609l) {
            this.f59144b.add(new AlbumUpdatedResult(this.f59143a.getAlbumName(), this.f59143a.getAlbumId(), error.getCode().intValue(), error.getDescription()));
            this.f59146d.add(this.f59143a);
        }

        @Override // p369ii.InterfaceC10510a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Album album, C4609l c4609l) {
            this.f59145c.add(this.f59143a.getAlbumId());
        }
    }

    public C12992z(List<GeneralAlbumData> list) {
        this.f59140g = list;
    }

    @Override // p650t7.AbstractC12988v
    /* renamed from: l */
    public String mo77876l() throws Exception {
        int iM6806m0;
        String str;
        String str2;
        String str3;
        String string;
        int i10;
        List<GeneralAlbumData> list;
        String str4 = "ModifyAlbumsExecutor";
        String str5 = "";
        this.f59133f = new Bundle();
        try {
            try {
                try {
                    try {
                        list = this.f59140g;
                        try {
                        } catch (IOException e10) {
                            e = e10;
                        } catch (Exception e11) {
                            e = e11;
                            C1120a.m6676e(str, "ModifyAlbumsExecutor runTask Exception: " + e.toString());
                            iM6806m0 = ConnectionResult.NETWORK_ERROR;
                            string = e.toString();
                            this.f59133f.putInt("Code", iM6806m0);
                            this.f59133f.putInt("code", iM6806m0);
                            this.f59133f.putString("info", string);
                            m77955s(string);
                            return str2;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        str = str4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    this.f59133f.putInt("Code", iM6806m0);
                    this.f59133f.putInt("code", iM6806m0);
                    this.f59133f.putString("info", "OK");
                    m77955s("OK");
                    throw th;
                }
            } catch (IOException e13) {
                e = e13;
                str2 = "";
                str3 = "ModifyAlbumsExecutor";
            }
            if (list != null) {
                try {
                } catch (IOException e14) {
                    e = e14;
                    str = str4;
                }
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                    CloudPhotoBatch cloudPhotoBatchM83551h = this.f61708b.m83551h();
                    int size = this.f59140g.size();
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < this.f59140g.size()) {
                        GeneralAlbumData generalAlbumData = this.f59140g.get(i11);
                        str = str4;
                        try {
                            String str6 = str5;
                            this.f61708b.m83547d().update(generalAlbumData.getAlbumId(), m77953q(generalAlbumData)).setAutoRename(true).addHeader("x-hw-lock", (Object) C12106s.m72509c().m72512d(true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f61710d).queue(cloudPhotoBatchM83551h, new a(generalAlbumData, arrayList2, arrayList, this.f59142i));
                            int i13 = i12 + 1;
                            if ((i13 % C1136q.d.m7148l() == 0 || size == i13) && cloudPhotoBatchM83551h.size() > 0) {
                                cloudPhotoBatchM83551h.execute();
                                CloudPhotoBatch cloudPhotoBatchM83551h2 = this.f61708b.m83551h();
                                C0068f.m459d().m468l();
                                cloudPhotoBatchM83551h = cloudPhotoBatchM83551h2;
                            }
                            i11++;
                            i12 = i13;
                            str4 = str;
                            str5 = str6;
                        } catch (IOException e15) {
                            e = e15;
                            str2 = str5;
                            str3 = str;
                            try {
                                C1120a.m6676e(str3, "ModifyAlbumsExecutor runTask IOException: " + e.toString());
                                if (e instanceof C4616s) {
                                    i10 = 0;
                                    try {
                                        iM6806m0 = C1122c.m6806m0((C4616s) e, false);
                                        string = e.toString();
                                    } catch (Throwable th3) {
                                        th = th3;
                                        iM6806m0 = i10;
                                        this.f59133f.putInt("Code", iM6806m0);
                                        this.f59133f.putInt("code", iM6806m0);
                                        this.f59133f.putString("info", "OK");
                                        m77955s("OK");
                                        throw th;
                                    }
                                } else {
                                    iM6806m0 = C1122c.m6845x0(e);
                                    string = e.toString();
                                }
                                this.f59133f.putInt("Code", iM6806m0);
                                this.f59133f.putInt("code", iM6806m0);
                                this.f59133f.putString("info", string);
                                m77955s(string);
                                return str2;
                            } catch (Throwable th4) {
                                th = th4;
                                i10 = 0;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            str2 = str5;
                            C1120a.m6676e(str, "ModifyAlbumsExecutor runTask Exception: " + e.toString());
                            iM6806m0 = ConnectionResult.NETWORK_ERROR;
                            string = e.toString();
                            this.f59133f.putInt("Code", iM6806m0);
                            this.f59133f.putInt("code", iM6806m0);
                            this.f59133f.putString("info", string);
                            m77955s(string);
                            return str2;
                        }
                    }
                    str2 = str5;
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new AlbumUpdatedResult(null, (String) it.next(), 0, null));
                        }
                    }
                    C12734h.m76557A(arrayList2, this.f59140g);
                    this.f59133f.putParcelableArrayList("AlbumUpdatedResultList", arrayList2);
                    this.f59133f.putInt("Code", 0);
                    this.f59133f.putInt("code", 0);
                    this.f59133f.putString("info", "OK");
                    m77955s("OK");
                    return str2;
                }
            }
            try {
                ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
                this.f59133f.putInt("modifyShareType", -1);
                this.f59133f.putParcelable("ShareInfo", this.f59141h);
                this.f59133f.putParcelableArrayList("ShareReceiverList", arrayList3);
                C12106s c12106sM72509c = C12106s.m72509c();
                EnumC12107t enumC12107t = EnumC12107t.SHARE_MODIFY_ALBUM;
                Albums.Update updateAddHeader = this.f61708b.m83547d().update(this.f59141h.getShareId(), m77954r()).addHeader("x-hw-lock", (Object) c12106sM72509c.m72513e(enumC12107t, true).getSessionId()).addHeader("x-hw-trace-id", (Object) this.f61710d);
                updateAddHeader.setRiskToken();
                updateAddHeader.execute();
                this.f59133f.putInt("code", 0);
                this.f59133f.putString("info", "success");
                C12106s.m72509c().m72520l(enumC12107t);
                this.f59133f.putInt("Code", 0);
                this.f59133f.putInt("code", 0);
                this.f59133f.putString("info", "OK");
                m77955s("OK");
                return "";
            } catch (Throwable th5) {
                C12106s.m72509c().m72520l(EnumC12107t.SHARE_MODIFY_ALBUM);
                throw th5;
            }
        } catch (Throwable th6) {
            th = th6;
            iM6806m0 = 0;
        }
    }

    /* renamed from: q */
    public final Album m77953q(GeneralAlbumData generalAlbumData) {
        Album album = new Album();
        album.setAlbumName(generalAlbumData.getAlbumName());
        album.setCreatedTime(new C4644l(generalAlbumData.getCreateTime()));
        album.setEditedTime(new C4644l(generalAlbumData.getTimestamp()));
        album.setProperties(C13129a.m78968i(generalAlbumData.getExpandString()));
        album.setLocalPath(generalAlbumData.getLpath());
        album.setSource(generalAlbumData.getSource());
        return album;
    }

    /* renamed from: r */
    public final Album m77954r() {
        Album album = new Album();
        album.setProperties(C13129a.m78968i(this.f59141h.getExpandString()));
        album.setAlbumName(this.f59141h.getShareName());
        album.setCreatedTime(new C4644l(this.f59141h.getCreateTime()));
        album.setEditedTime(new C4644l(System.currentTimeMillis()));
        album.setResource(this.f59141h.getResource());
        album.setSource(this.f59141h.getSource());
        if (Version.isSupportRiskReport()) {
            album.setOnlyFrdCanBeShared(Boolean.valueOf(this.f59141h.getOnlyFrdCanBeShared() != 0));
        }
        return album;
    }

    /* renamed from: s */
    public final void m77955s(String str) {
        if (this.f59142i.size() > 0) {
            this.f59133f.putInt("opsreportcode", 4312);
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<GeneralAlbumData> it = this.f59142i.iterator();
            while (it.hasNext()) {
                stringBuffer.append(C1122c.m6740U0(it.next().getAlbumId()));
                stringBuffer.append(",");
            }
            this.f59133f.putString("info", str + "Fails:" + stringBuffer.toString());
        }
    }

    public C12992z(ShareAlbumData shareAlbumData) {
        this.f59141h = shareAlbumData;
    }
}
