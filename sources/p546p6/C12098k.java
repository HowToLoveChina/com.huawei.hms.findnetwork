package p546p6;

import android.content.Intent;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0213f;
import p031b7.C1120a;
import p471m6.C11424j;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12941a;
import p664u0.C13108a;

/* renamed from: p6.k */
/* loaded from: classes2.dex */
public class C12098k extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask");
        ArrayList<Album> arrayListM77727B = new C12941a().m77727B(0, false);
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask query album db end.");
        ArrayList arrayList = new ArrayList();
        C11424j c11424j = new C11424j();
        c11424j.m68462j(1);
        arrayList.add(c11424j);
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask cameraAlbumInfo");
        C11424j c11424j2 = new C11424j();
        c11424j2.m68462j(2);
        c11424j2.m68460h("video_album_id");
        arrayList.add(c11424j2);
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask videoAlbumInfo");
        C11424j c11424j3 = new C11424j();
        c11424j3.m68462j(3);
        arrayList.add(c11424j3);
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask screenShotAlbumInfo");
        C11424j c11424j4 = new C11424j();
        c11424j4.m68462j(4);
        c11424j4.m68460h("favorite_album_id");
        arrayList.add(c11424j4);
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask favoriteAlbumInfo");
        Iterator<Album> it = arrayListM77727B.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            String id2 = next.getId();
            if ("default-album-1".equals(id2)) {
                c11424j.m68459g(next);
                c11424j.m68460h(id2);
            } else if ("default-album-2".equals(id2)) {
                c11424j3.m68459g(next);
                c11424j3.m68460h(id2);
            } else {
                C11424j c11424j5 = new C11424j();
                c11424j5.m68460h(id2);
                c11424j5.m68461i(next.getAlbumName());
                c11424j5.m68462j(5);
                c11424j5.m68459g(next);
                arrayList.add(c11424j5);
            }
        }
        C1120a.m6677i("GetAllNormalAlbumInfoTask", "GetAllNormalAlbumInfoTask end");
        C12091d.m72280a0().m72349d1(arrayList);
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.getPhotoTabList"));
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.GET_ALL_NORMAL_ALBUM;
    }
}
