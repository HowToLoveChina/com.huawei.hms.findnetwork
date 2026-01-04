package com.huawei.android.hicloud.album.service.logic.callable;

import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import fk.C9721b;
import java.util.ArrayList;
import java.util.Iterator;
import p031b7.C1120a;
import p031b7.C1122c;
import p399jk.AbstractC10896a;
import p546p6.C12096i;
import p546p6.C12111x;
import p581qk.AbstractC12367d;
import p604r7.C12470c;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12941a;
import p649t6.C12947g;

/* loaded from: classes2.dex */
public class ThumbnailPreloadTask extends AbstractC12367d {
    private static final String TAG = "ThumbnailPreloadTask";

    private void checkDownloadThumb(ArrayList<Media> arrayList) throws InterruptedException {
        C1120a.m6675d(TAG, "checkDownloadThumb size:" + C12111x.m72537e().m72542f() + " mediaListSize:" + arrayList.size());
        while (C12111x.m72537e().m72542f() > 100) {
            sleep(5);
        }
        C12096i.m72418I().m72435D(arrayList);
        sleep(2);
    }

    private void sleep(int i10) throws InterruptedException {
        try {
            Thread.sleep(i10 * 1000);
        } catch (InterruptedException e10) {
            AbstractC10896a.m65886e(TAG, "delay exception:" + e10.getMessage());
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException, C9721b {
        C1120a.m6677i(TAG, "ThumbnailPreloadTask execute start");
        if (C12470c.m74770d().m74780k()) {
            C1120a.m6677i(TAG, "ThumbnailPreloadTask complete");
            return;
        }
        C12941a c12941a = new C12941a();
        ArrayList<Album> arrayListM77750y = CloudAlbumSettings.m14363h().m14383s() ? c12941a.m77750y(true) : c12941a.m77727B(0, true);
        C1120a.m6675d(TAG, "ThumbnailPreloadTask albumList.size=" + arrayListM77750y.size());
        Iterator<Album> it = arrayListM77750y.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            if (next.getPicCount() + next.getVideoCount() == 0) {
                it.remove();
            }
        }
        C1120a.m6675d(TAG, "ThumbnailPreloadTask preload album size=" + arrayListM77750y.size());
        C12947g c12947g = new C12947g();
        int iM6739U = C1122c.m6739U();
        Iterator<Album> it2 = arrayListM77750y.iterator();
        while (it2.hasNext()) {
            Album next2 = it2.next();
            int i10 = 0;
            long j10 = 0;
            while (true) {
                ArrayList<Media> arrayListM77798K = c12947g.m77798K(next2.getId(), 300 * j10, 300L);
                if (!arrayListM77798K.isEmpty()) {
                    if (j10 == 0) {
                        if (arrayListM77798K.size() <= 40) {
                            C12096i.m72418I().m72432A(arrayListM77798K);
                        } else {
                            C12096i.m72418I().m72432A(arrayListM77798K.subList(0, 40));
                        }
                    }
                    checkDownloadThumb(arrayListM77798K);
                    int size = arrayListM77798K.size() + i10;
                    j10++;
                    if (iM6739U > 0 && C1122c.m6695F0(arrayListM77750y.size()) <= size) {
                        C1120a.m6677i(TAG, "ThumbnailPreloadTask download number over");
                        break;
                    }
                    i10 = size;
                }
            }
        }
        C1120a.m6677i(TAG, "ThumbnailPreloadTask execute end");
        C12470c.m74770d().m74787r(true);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_FIX;
    }
}
