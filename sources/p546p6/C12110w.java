package p546p6;

import com.huawei.android.hicloud.album.service.p075vo.FileData;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import java.util.List;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;

/* renamed from: p6.w */
/* loaded from: classes2.dex */
public class C12110w {

    /* renamed from: p6.w$b */
    public static class b {

        /* renamed from: a */
        public static final C12110w f56165a = new C12110w();
    }

    /* renamed from: a */
    public static C12110w m72533a() {
        return b.f56165a;
    }

    /* renamed from: b */
    public final boolean m72534b(List<FileData> list) {
        if (list == null || list.isEmpty()) {
            C1120a.m6676e("RestartSyncManager", "isContainDirtyData fileDataList is null or empty");
            return false;
        }
        for (FileData fileData : list) {
            if (fileData != null && C1122c.m6831s1(fileData.getFileId())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public synchronized boolean m72535c(List<FileData> list) {
        if (System.currentTimeMillis() - C1136q.m6965f() < 604800000) {
            return false;
        }
        int iM6960a = C1136q.m6960a();
        long j10 = iM6960a;
        if (j10 > 3) {
            return false;
        }
        if (m72534b(list)) {
            if (j10 < 3) {
                CloudAlbumManager.m14456v().m14474T(C0213f.m1377a());
                C1136q.m6985z(System.currentTimeMillis());
                C1136q.m6982w(iM6960a + 1);
                return true;
            }
            if (j10 == 3) {
                CloudAlbumManager.m14456v().m14479Y(C0213f.m1377a());
                C1136q.m6985z(System.currentTimeMillis());
                C1136q.m6982w(iM6960a + 1);
                return true;
            }
        }
        return false;
    }

    public C12110w() {
    }
}
