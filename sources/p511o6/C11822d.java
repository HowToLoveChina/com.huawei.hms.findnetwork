package p511o6;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.callable.DownloadTaskBaseCallable;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import okhttp3.C11949p;
import okhttp3.InterfaceC11919f;
import p031b7.C1120a;
import p031b7.C1122c;
import p701v6.C13358e;

/* renamed from: o6.d */
/* loaded from: classes2.dex */
public class C11822d {

    /* renamed from: o6.d$a */
    public class a extends Thread {

        /* renamed from: a */
        public final /* synthetic */ int f54728a;

        /* renamed from: b */
        public final /* synthetic */ int f54729b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, int i10, int i11) {
            super(str);
            this.f54728a = i10;
            this.f54729b = i11;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Vector<Map<String, Object>> vectorM14655u;
            Vector<Map<String, Object>> vectorM14654t;
            FileInfo fileInfo;
            try {
                int i10 = this.f54728a;
                if (i10 == 0) {
                    vectorM14655u = C2332m.m14608s().m14651p();
                    vectorM14654t = C2332m.m14608s().m14650o();
                } else if (i10 == 2) {
                    vectorM14655u = C2332m.m14608s().m14653r();
                    vectorM14654t = C2332m.m14608s().m14652q();
                } else if (i10 == 1) {
                    vectorM14655u = C2332m.m14608s().m14655u();
                    vectorM14654t = C2332m.m14608s().m14654t();
                } else {
                    vectorM14655u = null;
                    vectorM14654t = null;
                }
                if (vectorM14655u != null) {
                    vectorM14655u.clear();
                }
                if (vectorM14654t == null) {
                    return;
                }
                for (int i11 = 0; i11 < vectorM14654t.size(); i11++) {
                    DownloadTaskBaseCallable downloadTaskBaseCallable = (DownloadTaskBaseCallable) vectorM14654t.get(i11).get("FIXED_BASECALLABLE_KEY");
                    if (downloadTaskBaseCallable != null && (fileInfo = (FileInfo) downloadTaskBaseCallable.getCallParam()) != null) {
                        downloadTaskBaseCallable.cancel(this.f54729b);
                        C1120a.m6677i("TaskThreadManualDownloadManager", "cancelDownloadTaskAll type:" + fileInfo.getFileType() + ";fileName:" + C1122c.m6818p0(fileInfo.getFileName()));
                    }
                }
            } catch (Exception e10) {
                C1120a.m6676e("TaskThreadManualDownloadManager", "cancelDownloadTaskAll error,error message:" + e10.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m70437a() {
        C11949p c11949pM71482m = C13358e.m80141d(0).m71482m();
        C11949p c11949pM71482m2 = C13358e.m80141d(3).m71482m();
        m70438b(c11949pM71482m);
        m70438b(c11949pM71482m2);
    }

    /* renamed from: b */
    public static void m70438b(C11949p c11949p) {
        List<InterfaceC11919f> listM71833j = c11949p.m71833j();
        List<InterfaceC11919f> listM71836m = c11949p.m71836m();
        Iterator<InterfaceC11919f> it = listM71833j.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        Iterator<InterfaceC11919f> it2 = listM71836m.iterator();
        while (it2.hasNext()) {
            it2.next().cancel();
        }
        C13358e.m80142e();
    }

    /* renamed from: c */
    public static synchronized void m70439c(Context context, int i10, int i11) {
        new a("TaskThreadManualDownloadManager-Thread-1", i10, i11).start();
    }

    /* renamed from: d */
    public static synchronized boolean m70440d(FileInfo fileInfo, int i10) {
        C1120a.m6677i("TaskThreadManualDownloadManager", "isInManualDownloadExecutingTask");
        return m70442f(fileInfo, C2332m.m14608s().m14650o(), i10);
    }

    /* renamed from: e */
    public static boolean m70441e(FileInfo fileInfo, FileInfo fileInfo2) {
        boolean z10 = (fileInfo.getAlbumId() == null || fileInfo2.getAlbumId() == null || fileInfo.getAlbumId().equals(fileInfo2.getAlbumId())) ? false : true;
        if (fileInfo.getUniqueId() != null && fileInfo2.getUniqueId() != null && !fileInfo.getUniqueId().equals(fileInfo2.getUniqueId())) {
            z10 = true;
        }
        if (fileInfo.getShareId() != null && fileInfo2.getShareId() != null && !fileInfo.getShareId().equals(fileInfo2.getShareId())) {
            z10 = true;
        }
        if (fileInfo.getFileId() != null && fileInfo2.getFileId() != null && !fileInfo.getFileId().equals(fileInfo2.getFileId())) {
            z10 = true;
        }
        return !z10;
    }

    /* renamed from: f */
    public static boolean m70442f(FileInfo fileInfo, Vector<Map<String, Object>> vector, int i10) {
        if (vector.isEmpty()) {
            return false;
        }
        if (TextUtils.isEmpty(fileInfo.getFileId()) && TextUtils.isEmpty(fileInfo.getUniqueId()) && TextUtils.isEmpty(fileInfo.getShareId()) && TextUtils.isEmpty(fileInfo.getAlbumId())) {
            return false;
        }
        try {
            Iterator<Map<String, Object>> it = vector.iterator();
            while (it.hasNext()) {
                AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) it.next().get("FIXED_BASECALLABLE_KEY");
                FileInfo fileInfo2 = (FileInfo) abstractCallableC2320a.getCallParam();
                if (fileInfo2 == null) {
                    C1120a.m6678w("TaskThreadManualDownloadManager", "fileInfoExec is null! continue");
                } else if (m70441e(fileInfo2, fileInfo) && i10 == abstractCallableC2320a.getThumbType()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManualDownloadManager", "isTaskInVector Exception:" + e10.toString());
            return false;
        }
    }
}
