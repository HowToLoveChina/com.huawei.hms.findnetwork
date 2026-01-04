package com.huawei.android.hicloud.album.service.logic.callable;

import android.content.Context;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1136q;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12941a;
import p649t6.C12947g;

/* loaded from: classes2.dex */
public class CloudAlbumThumbClearTask extends AbstractC12367d {
    private static final long OVER_SPACE = 419430400;
    private static final String TAG = "CloudAlbumThumbClearTask";

    private void cleanMediaThumb(ArrayList<Media> arrayList, int i10, int i11) {
        if (arrayList == null) {
            C1120a.m6676e(TAG, "cleanMediaThumb media is null");
            return;
        }
        int size = arrayList.size();
        C1120a.m6677i(TAG, "cleanMediaThumb mediaSize: " + size);
        if (size <= i10) {
            C1120a.m6677i(TAG, "saveCount equals media.size");
            return;
        }
        while (i10 < size) {
            Media media = arrayList.get(i10);
            if (media != null) {
                if (i11 == 2) {
                    C1122c.m6694F(media.getLocalThumbPath());
                    C12091d.m72280a0().m72352f0().m30075f(media.getId());
                } else {
                    C1122c.m6694F(media.getLocalBigThumbPath());
                }
            }
            i10++;
        }
    }

    private void doClear() throws Throwable {
        ArrayList<Album> arrayListM77750y = new C12941a().m77750y(true);
        if (arrayListM77750y.isEmpty()) {
            C1120a.m6677i(TAG, "CloudAlbumThumbClearTask no albums");
            C1136q.m6945C();
            return;
        }
        int size = arrayListM77750y.size();
        int iM6695F0 = C1122c.m6695F0(size);
        C1120a.m6675d(TAG, "albumSize: " + size + ", saveCount: " + iM6695F0);
        ArrayList arrayList = new ArrayList();
        Iterator<Album> it = arrayListM77750y.iterator();
        while (it.hasNext()) {
            Album next = it.next();
            int picCount = next.getPicCount() + next.getVideoCount();
            C1120a.m6677i(TAG, "album: " + next.getAlbumName() + ", mediaCount: " + picCount);
            if (picCount >= iM6695F0) {
                arrayList.add(next);
            }
        }
        C1120a.m6677i(TAG, "needCleanAlbums size: " + arrayList.size());
        C12947g c12947g = new C12947g();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Album album = (Album) it2.next();
            C1120a.m6677i(TAG, "needCleanAlbum: " + album.getAlbumName());
            long j10 = 0L;
            while (true) {
                ArrayList<Media> arrayListM77800M = c12947g.m77800M(album.getId(), RippleView.SINGLE_RIPPLE_TIME * j10, RippleView.SINGLE_RIPPLE_TIME);
                if (arrayListM77800M.isEmpty()) {
                    break;
                }
                if (j10 == 0) {
                    cleanMediaThumb(arrayListM77800M, iM6695F0, 2);
                    cleanMediaThumb(arrayListM77800M, 40, 1);
                } else {
                    cleanMediaThumb(arrayListM77800M, 0, 2);
                    cleanMediaThumb(arrayListM77800M, 0, 1);
                }
                j10++;
            }
        }
        C1136q.m6945C();
    }

    private boolean isDirectory(File file) {
        return file.exists() && file.isDirectory();
    }

    private boolean isFile(File file) {
        return file.exists() && file.isFile();
    }

    private boolean overSpace() {
        String[] list;
        String[] list2;
        File fileM63442h = C10278a.m63442h(C1124e.m6871o(C0213f.m1377a()) + "/.cloudShare/thumb");
        int i10 = 0;
        long length = 0;
        if (isDirectory(fileM63442h)) {
            String[] list3 = fileM63442h.list();
            if (list3 == null) {
                C1120a.m6677i(TAG, "thumbCacheFolder list is null");
                return false;
            }
            int length2 = list3.length;
            int i11 = 0;
            while (i11 < length2) {
                File fileM63441g = C10278a.m63441g(fileM63442h, list3[i11]);
                if (isDirectory(fileM63441g) && (list = fileM63441g.list()) != null) {
                    int length3 = list.length;
                    int i12 = i10;
                    while (i12 < length3) {
                        File fileM63441g2 = C10278a.m63441g(fileM63441g, list[i12]);
                        if (isDirectory(fileM63441g2) && (list2 = fileM63441g2.list()) != null) {
                            int length4 = list2.length;
                            while (i10 < length4) {
                                File file = fileM63442h;
                                File fileM63441g3 = C10278a.m63441g(fileM63441g2, list2[i10]);
                                if (isFile(fileM63441g3)) {
                                    length += fileM63441g3.length();
                                }
                                i10++;
                                fileM63442h = file;
                            }
                        }
                        i12++;
                        fileM63442h = fileM63442h;
                        i10 = 0;
                    }
                }
                i11++;
                fileM63442h = fileM63442h;
                i10 = 0;
            }
        }
        C1120a.m6677i(TAG, "thumbCacheSize: " + length);
        return length >= OVER_SPACE;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        long jM6969j = C1136q.m6969j();
        int iM6733S = C1122c.m6733S();
        int iM6739U = C1122c.m6739U();
        if (iM6733S <= 0 || iM6739U <= 0) {
            C1120a.m6677i(TAG, "CloudAlbumThumbClearTask no need clear");
            return;
        }
        long j10 = iM6733S * 86400000;
        C1120a.m6677i(TAG, "CloudAlbumThumbClearTask latestClearTime: " + jM6969j);
        if (System.currentTimeMillis() - jM6969j < j10) {
            C1120a.m6677i(TAG, "CloudAlbumThumbClearTask no need clear in interval");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (overSpace() && C1136q.e.m7166d(contextM1377a)) {
            doClear();
        } else {
            C1136q.m6945C();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_FIX;
    }
}
