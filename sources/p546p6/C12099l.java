package p546p6;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import fk.C9721b;
import p015ak.C0213f;
import p031b7.C1120a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p649t6.C12947g;
import p664u0.C13108a;

/* renamed from: p6.l */
/* loaded from: classes2.dex */
public class C12099l extends AbstractC12367d {

    /* renamed from: a */
    public String f56120a;

    /* renamed from: b */
    public boolean f56121b;

    /* renamed from: c */
    public boolean f56122c;

    /* renamed from: d */
    public Context f56123d;

    public C12099l(Context context, String str, boolean z10, boolean z11) {
        this.f56120a = str;
        this.f56121b = z10;
        this.f56123d = context;
        this.f56122c = z11;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Resources.NotFoundException, C9721b {
        String str;
        C1120a.m6677i("GetCloudPhotoTotalSizeTask", "GetCloudPhotoTotalSizeTask call");
        if (this.f56123d == null) {
            C1120a.m6675d("GetCloudPhotoTotalSizeTask", "GetCloudPhotoTotalSizeTask context is null ");
            return;
        }
        C12947g c12947g = new C12947g();
        int iM77803P = c12947g.m77803P();
        int iM77804Q = c12947g.m77804Q();
        C1120a.m6675d("GetCloudPhotoTotalSizeTask", "picSize " + iM77803P + " videoSize " + iM77804Q);
        if (iM77803P == 0 && iM77804Q == 0 && !this.f56122c) {
            str = "";
        } else {
            String quantityString = this.f56123d.getResources().getQuantityString(R$plurals.cloud_pic_num, iM77803P, Integer.valueOf(iM77803P));
            String quantityString2 = this.f56123d.getResources().getQuantityString(R$plurals.cloud_video_num, iM77804Q, Integer.valueOf(iM77804Q));
            C1120a.m6675d("GetCloudPhotoTotalSizeTask", "picSizeStr " + quantityString + " videoSizeStr " + quantityString2);
            String string = this.f56123d.getString(R$string.cloud_pic_and_video, quantityString, quantityString2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("picAndVideoSize ");
            sb2.append(string);
            C1120a.m6675d("GetCloudPhotoTotalSizeTask", sb2.toString());
            str = string;
        }
        Intent intent = new Intent("com.huawei.hicloud.getCloudPhotoTotalSize");
        intent.putExtra("param_pic_and_video_content", str);
        intent.putExtra("param_num_content", this.f56120a);
        C12091d.m72280a0().m72351e1(iM77803P + iM77804Q);
        intent.putExtra("is_num_append", this.f56121b);
        C13108a.m78878b(C0213f.m1377a()).m78881d(intent);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_SHARE_UI;
    }
}
