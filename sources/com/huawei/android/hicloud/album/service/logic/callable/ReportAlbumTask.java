package com.huawei.android.hicloud.album.service.logic.callable;

import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.p075vo.GalleryAlbum;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1136q;
import p581qk.AbstractC12367d;
import p649t6.C12944d;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class ReportAlbumTask extends AbstractC12367d {
    private static final String TAG = "ReportAlbumTask";

    private void report() {
        if (!C1136q.e.m7166d(C0213f.m1377a())) {
            C1120a.m6678w(TAG, "report album switch off");
            return;
        }
        ArrayList<GalleryAlbum> arrayListM77766c = C12944d.m77766c();
        if (arrayListM77766c == null) {
            C1120a.m6676e(TAG, "report galleryAlbum is null");
            return;
        }
        String json = new Gson().toJson(arrayListM77766c);
        C1120a.m6675d(TAG, "reportString: " + json);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("gallery_album_info", json);
        C13224c.m79487f1().m79591l0("gallery_album_info", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "gallery_album_info", "1", "1", linkedHashMapM79497A);
        C1136q.m6951I();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C1120a.m6677i(TAG, "latestReportTime: " + C1136q.m6975p());
        report();
    }
}
