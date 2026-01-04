package p546p6;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import fk.C9721b;
import java.text.NumberFormat;
import java.util.ArrayList;
import p031b7.C1120a;
import p471m6.C11424j;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12941a;
import p649t6.C12947g;

/* renamed from: p6.u */
/* loaded from: classes2.dex */
public class C12108u extends AbstractC12367d {

    /* renamed from: a */
    public C11424j f56154a;

    /* renamed from: b */
    public ImageView f56155b;

    /* renamed from: c */
    public TextView f56156c;

    /* renamed from: d */
    public ImageView f56157d;

    /* renamed from: p6.u$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public int f56158a;

        /* renamed from: b */
        public TextView f56159b;

        /* renamed from: c */
        public ImageView f56160c;

        public a(int i10, TextView textView, ImageView imageView) {
            this.f56158a = i10;
            this.f56159b = textView;
            this.f56160c = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.f56159b;
            if (textView != null) {
                textView.setText(NumberFormat.getInstance().format(this.f56158a));
            }
            ImageView imageView = this.f56160c;
            if (imageView != null) {
                if (this.f56158a > 0) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
        }
    }

    public C12108u(C11424j c11424j, ImageView imageView, TextView textView, ImageView imageView2) {
        this.f56154a = c11424j;
        this.f56155b = imageView;
        this.f56156c = textView;
        this.f56157d = imageView2;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11424j c11424j = this.f56154a;
        if (c11424j == null) {
            C1120a.m6676e("RefreshNormalAlbumCoverAndNumTask", "normalAlbumInfo is null.");
            return;
        }
        Album albumM68453a = c11424j.m68453a();
        String strM68454b = this.f56154a.m68454b();
        int iM68456d = this.f56154a.m68456d();
        ArrayList arrayList = new ArrayList();
        C12947g c12947g = new C12947g();
        if (1 == iM68456d) {
            arrayList.addAll(c12947g.m77798K("default-album-1", 0L, 1L));
        } else if (3 == iM68456d) {
            arrayList.addAll(c12947g.m77798K("default-album-2", 0L, 1L));
        } else if (2 == iM68456d) {
            arrayList.addAll(c12947g.m77796I());
        } else if (4 == iM68456d) {
            arrayList.addAll(c12947g.m77793F());
        } else {
            arrayList.addAll(c12947g.m77798K(strM68454b, 0L, 1L));
        }
        int size = arrayList.size();
        C1120a.m6677i("RefreshNormalAlbumCoverAndNumTask", "albumType = " + iM68456d + "  mediaArrayList.size = " + arrayList.size());
        int size2 = 0;
        if (size > 0 && this.f56156c.getTag().equals(strM68454b)) {
            C12091d.m72280a0().m72298C((Media) arrayList.get(0), this.f56155b);
        }
        if (2 != iM68456d && 4 != iM68456d) {
            Album albumM77743r = new C12941a().m77743r(albumM68453a);
            size2 = albumM77743r.getPicCount() + albumM77743r.getVideoCount();
        } else if (size > 0) {
            size2 = arrayList.size();
        }
        C1120a.m6677i("RefreshNormalAlbumCoverAndNumTask", "albumType = " + iM68456d + " albumNum = " + size2);
        if (this.f56156c.getTag().equals(strM68454b)) {
            ((Activity) this.f56156c.getContext()).runOnUiThread(new a(size2, this.f56156c, this.f56157d));
        }
        this.f56154a.m68464l(size2);
        this.f56154a.m68463k(arrayList);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.NORMAL_ALBUM_UI;
    }
}
