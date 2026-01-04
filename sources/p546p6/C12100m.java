package p546p6;

import android.content.Intent;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import java.util.ArrayList;
import p015ak.C0213f;
import p031b7.C1120a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12947g;
import p664u0.C13108a;

/* renamed from: p6.m */
/* loaded from: classes2.dex */
public class C12100m extends AbstractC12367d {

    /* renamed from: a */
    public String f56124a;

    public C12100m(String str) {
        this.f56124a = str;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        C12947g c12947g;
        ArrayList<DayModeGroup> arrayListM77808U;
        C1120a.m6677i("GetNormalAlbumCountTask", "GetPicTabCountTask call");
        c12947g = new C12947g();
        C1120a.m6675d("GetNormalAlbumCountTask", "GetPicTabCountTask start query");
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.f56124a;
        str.hashCode();
        switch (str) {
            case "album_id_collection":
                arrayListM77808U = c12947g.m77808U();
                break;
            case "album_id_screenshot":
                arrayListM77808U = c12947g.m77791D("default-album-2");
                break;
            case "album_id_camera":
                arrayListM77808U = c12947g.m77791D("default-album-1");
                break;
            case "album_id_video":
                arrayListM77808U = c12947g.m77817d0();
                break;
            default:
                arrayListM77808U = c12947g.m77791D(this.f56124a);
                break;
        }
        C1120a.m6675d("GetNormalAlbumCountTask", "useTime = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        C1120a.m6675d("GetNormalAlbumCountTask", "GetPicTabCountTask end query");
        if (arrayListM77808U.size() == 0) {
            C1120a.m6676e("GetNormalAlbumCountTask", "GetPicTabCountTask mediaRaws is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hicloud.getNormalAlbum.picList");
        C12091d.m72280a0().m72357h1(this.f56124a, arrayListM77808U);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_SHARE_UI;
    }
}
