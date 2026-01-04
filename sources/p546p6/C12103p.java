package p546p6;

import android.content.Intent;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.p069cg.R$string;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p471m6.C11415a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12941a;
import p649t6.C12947g;
import p664u0.C13108a;

/* renamed from: p6.p */
/* loaded from: classes2.dex */
public class C12103p extends AbstractC12367d {
    /* renamed from: d */
    public static /* synthetic */ int m72492d(C11415a c11415a, C11415a c11415a2) {
        return Long.valueOf(c11415a2.m68364c()).compareTo(Long.valueOf(c11415a.m68364c()));
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        ArrayList arrayList = new ArrayList();
        ArrayList<Album> arrayListM77727B = new C12941a().m77727B(1, false);
        String strM7155s = C1136q.d.m7155s();
        Iterator<Album> it = arrayListM77727B.iterator();
        C11415a c11415a = null;
        while (it.hasNext()) {
            Album next = it.next();
            if (!C1122c.m6705I1(next)) {
                C11415a c11415a2 = new C11415a();
                c11415a2.m68368g(next);
                c11415a2.m68369h(next.getAlbumName());
                if (next.getShareType().intValue() == 1) {
                    c11415a2.m68376o(C0213f.m1377a().getString(R$string.album_baby));
                }
                c11415a2.m68371j(next.getFileUpdateTime());
                c11415a2.m68370i(next.getAlbumOwnerName());
                C1120a.m6675d("GetShareAlbumListTask", next.getAlbumName() + " getPicCount:" + next.getPicCount());
                c11415a2.m68374m(next.getPicCount());
                c11415a2.m68377p(next.getVideoCount());
                c11415a2.m68372k(next.getPermissions().size());
                if (strM7155s.equals(next.getId())) {
                    c11415a = c11415a2;
                } else {
                    arrayList.add(c11415a2);
                }
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: p6.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12103p.m72492d((C11415a) obj, (C11415a) obj2);
            }
        });
        if (c11415a != null) {
            arrayList.add(0, c11415a);
        }
        C1120a.m6677i("GetShareAlbumListTask", "send  broadcast:" + arrayList.size());
        Intent intent = new Intent("com.huawei.hicloud.getShareAlbumList");
        C12091d.m72280a0().m72355g1(arrayList);
        intent.putExtra("param_share_count_all", new C12947g().m77805R());
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_FIX;
    }
}
