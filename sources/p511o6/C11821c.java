package p511o6;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.DownloadPhotoBase;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import fk.C9721b;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import okhttp3.C11949p;
import okhttp3.InterfaceC11919f;
import p031b7.C1120a;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p701v6.C13358e;

/* renamed from: o6.c */
/* loaded from: classes2.dex */
public class C11821c {

    /* renamed from: o6.c$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f54721a;

        /* renamed from: b */
        public final /* synthetic */ int f54722b;

        /* renamed from: c */
        public final /* synthetic */ AbstractC2324e f54723c;

        public a(String str, int i10, AbstractC2324e abstractC2324e) {
            this.f54721a = str;
            this.f54722b = i10;
            this.f54723c = abstractC2324e;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11821c.m70417g(this.f54721a, this.f54722b, this.f54723c);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public String getTag() {
            return "com.huawei.android.cg.logic.TaskThreadManager.cancelGeneralUploadTask";
        }
    }

    /* renamed from: o6.c$b */
    public static class b extends AbstractC12367d {

        /* renamed from: a */
        public Context f54724a;

        /* renamed from: b */
        public FileInfo f54725b;

        /* renamed from: c */
        public int f54726c;

        /* renamed from: d */
        public boolean f54727d;

        public b(Context context, FileInfo fileInfo, int i10, boolean z10) {
            this.f54724a = context;
            this.f54725b = fileInfo;
            this.f54726c = i10;
            this.f54727d = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C11821c.m70413c(this.f54724a, this.f54725b, this.f54726c, this.f54727d);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.ALBUM_FIX;
        }
    }

    /* renamed from: A */
    public static void m70407A(Vector<Map<String, Object>> vector, String str) {
        m70408B(vector, str, null);
    }

    /* renamed from: B */
    public static void m70408B(Vector<Map<String, Object>> vector, String str, AbstractC2324e abstractC2324e) {
        int i10 = 0;
        while (i10 < vector.size()) {
            Map<String, Object> map = vector.get(i10);
            AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) map.get("FIXED_BASECALLABLE_KEY");
            if (abstractCallableC2320a != null) {
                FileInfo fileInfo = (FileInfo) abstractCallableC2320a.getCallParam();
                if (fileInfo.getFileUploadType() != null && fileInfo.getAlbumId().startsWith("default-album-")) {
                    C1120a.m6675d("TaskThreadManager", "processCallableListRemove lpath: " + fileInfo.getLpath() + ", fileuploadeype: " + fileInfo.getFileUploadType());
                    if ("0".equals(str) || fileInfo.getFileUploadType().equals(str) || fileInfo.getLpath().equals(str)) {
                        vector.remove(map);
                        i10--;
                    }
                }
                if (abstractC2324e != null) {
                    abstractC2324e.handle(abstractCallableC2320a.getCallParam());
                }
            }
            i10++;
        }
    }

    /* renamed from: C */
    public static synchronized boolean m70409C(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            C11949p c11949pM71482m = C13358e.m80141d(m70426p(z10)).m71482m();
            Iterator<InterfaceC11919f> it = c11949pM71482m.m71833j().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().request().m71571k())) {
                    C1120a.m6675d("TaskThreadManager", "task in queued calls, fileKey:" + str);
                    return true;
                }
            }
            Iterator<InterfaceC11919f> it2 = c11949pM71482m.m71836m().iterator();
            while (it2.hasNext()) {
                if (str.equals(it2.next().request().m71571k())) {
                    C1120a.m6675d("TaskThreadManager", "task in running calls, fileKey:" + str);
                    return true;
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManager", "queryDownloadTaskInCalls exception: " + e10.toString());
        }
        return false;
    }

    /* renamed from: D */
    public static boolean m70410D(Map<String, Object> map, Vector<Map<String, Object>> vector, int i10, boolean z10, String str, String str2, AbstractCallableC2320a abstractCallableC2320a, String str3, String str4) {
        if (!str.equals(str4) || !str2.equals(str3) || abstractCallableC2320a.getThumbType() != i10) {
            return false;
        }
        if (z10) {
            return m70418h(abstractCallableC2320a);
        }
        vector.remove(map);
        return true;
    }

    /* renamed from: b */
    public static void m70412b(Context context, FileInfo fileInfo, int i10, boolean z10) {
        C12515a.m75110o().m75175e(new b(context, fileInfo, i10, z10), false);
    }

    /* renamed from: c */
    public static synchronized int m70413c(Context context, FileInfo fileInfo, int i10, boolean z10) {
        if (fileInfo == null) {
            C1120a.m6676e("TaskThreadManager", "fileinfo is null");
            return 1;
        }
        String strM70401f = C11820b.m70401f(m70422l(fileInfo, z10), !z10 ? fileInfo.getUniqueId() : fileInfo.getHash(), i10);
        if (strM70401f == null) {
            C1120a.m6676e("TaskThreadManager", "fileInfoKey is null");
            return 1;
        }
        Map<String, Object> mapM14407b = i10 != 2 ? DownloadPhotoBase.m14407b(strM70401f) : DownloadPhotoBase.m14408c(strM70401f);
        if (mapM14407b != null && mapM14407b.size() >= 1) {
            C1120a.m6675d("TaskThreadManager", "downloadTaskMap size" + mapM14407b.size());
            m70429s(context, fileInfo, i10, z10);
            int iM70425o = m70425o(i10, m70415e(m70423m(i10), fileInfo, i10, z10, true), mapM14407b);
            C1120a.m6677i("TaskThreadManager", "cancelDownloadTask result:" + iM70425o + ", cancelThumbType: " + i10 + ", currentThread id: " + Thread.currentThread().getId());
            return iM70425o;
        }
        C1120a.m6675d("TaskThreadManager", "downloadTaskMap is null or empty,cancel fileInfoKey:" + strM70401f);
        return 1;
    }

    /* renamed from: d */
    public static boolean m70414d(Map<String, Object> map, Vector<Map<String, Object>> vector, int i10, boolean z10, boolean z11, String str, String str2) {
        FileInfo fileInfo;
        AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) map.get("FIXED_BASECALLABLE_KEY");
        if (abstractCallableC2320a == null || abstractCallableC2320a.getCallParam() == null || (fileInfo = (FileInfo) abstractCallableC2320a.getCallParam()) == null) {
            return false;
        }
        return m70410D(map, vector, i10, z11, str, str2, abstractCallableC2320a, !z10 ? fileInfo.getUniqueId() : fileInfo.getHash(), z10 ? fileInfo.getShareId() : fileInfo.getAlbumId());
    }

    /* renamed from: e */
    public static synchronized int m70415e(Vector<Map<String, Object>> vector, FileInfo fileInfo, int i10, boolean z10, boolean z11) {
        if (vector == null || fileInfo == null) {
            return 1;
        }
        try {
            String uniqueId = !z10 ? fileInfo.getUniqueId() : fileInfo.getHash();
            String shareId = z10 ? fileInfo.getShareId() : fileInfo.getAlbumId();
            Thread threadCurrentThread = Thread.currentThread();
            StringBuilder sb2 = new StringBuilder("checkDownloadTask albumId: ");
            sb2.append(shareId);
            sb2.append(", fileName is: ");
            sb2.append(fileInfo.getFileName());
            sb2.append(!z10 ? ", UniqueId is: " : ", hash is: ");
            sb2.append(uniqueId);
            sb2.append(", isCancel: ");
            sb2.append(z11);
            sb2.append(", thumbType: ");
            sb2.append(i10);
            sb2.append(", currentThread id: ");
            sb2.append(threadCurrentThread.getId());
            C1120a.m6675d("TaskThreadManager", sb2.toString());
            if (uniqueId == null || shareId == null) {
                return 1;
            }
            for (int i11 = 0; i11 < vector.size(); i11++) {
                try {
                    m70414d(vector.get(i11), vector, i10, z10, z11, shareId, uniqueId);
                } catch (Exception e10) {
                    C1120a.m6676e("TaskThreadManager", "checkDownloadTask error:" + e10.toString());
                }
            }
            return 1;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: f */
    public static boolean m70416f(FileInfo fileInfo, Map<String, Object> map) {
        if (fileInfo == null) {
            C1120a.m6676e("TaskThreadManager", "cancelExectingTask: fileInfo is null");
            return false;
        }
        AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) map.get("FIXED_BASECALLABLE_KEY");
        if (abstractCallableC2320a == null) {
            C1120a.m6676e("TaskThreadManager", "cancelExectingTask: updateTask is null");
            return false;
        }
        FileInfo fileInfo2 = (FileInfo) abstractCallableC2320a.getCallParam();
        if (fileInfo2 == null) {
            C1120a.m6676e("TaskThreadManager", "cancelExectingTask: fileInfoExec is null");
            return false;
        }
        String albumId = fileInfo2.getAlbumId();
        if (albumId == null) {
            C1120a.m6676e("TaskThreadManager", "cancelExectingTask: id is null");
            return false;
        }
        if (!albumId.equals(fileInfo.getAlbumId())) {
            C1120a.m6676e("TaskThreadManager", "cancelExectingTask: id is not equal");
            return false;
        }
        boolean zIsEmpty = TextUtils.isEmpty(fileInfo2.getShareId());
        String uniqueId = zIsEmpty ? fileInfo2.getUniqueId() : fileInfo2.getHash();
        if (uniqueId == null) {
            if (zIsEmpty) {
                C1120a.m6676e("TaskThreadManager", "cancelExectingTask: uniqueid is null");
            } else {
                C1120a.m6676e("TaskThreadManager", "cancelExectingTask: hash is null");
            }
            return false;
        }
        if (!uniqueId.equals(TextUtils.isEmpty(fileInfo.getShareId()) ? fileInfo.getUniqueId() : fileInfo.getHash())) {
            if (zIsEmpty) {
                C1120a.m6676e("TaskThreadManager", "cancelExectingTask: uniqueid is not equal");
            } else {
                C1120a.m6676e("TaskThreadManager", "cancelExectingTask: hash is not equal");
            }
            return false;
        }
        C1120a.m6675d("TaskThreadManager", "deleteFileUploadTaskInThread fileName: " + fileInfo2.getFileName() + ", albumId: " + albumId);
        return abstractCallableC2320a.cancel();
    }

    /* renamed from: g */
    public static void m70417g(String str, int i10, AbstractC2324e abstractC2324e) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1120a.m6675d("TaskThreadManager", "cancelUploadTask begin: " + jCurrentTimeMillis);
        try {
            Vector<Map<String, Object>> vectorM14669h = C2333n.m14663f().m14669h();
            if (vectorM14669h != null && vectorM14669h.size() > 0) {
                m70408B(vectorM14669h, str, abstractC2324e);
            }
            Vector<Map<String, Object>> vectorM14668g = C2333n.m14663f().m14668g();
            if (vectorM14668g != null) {
                for (int i11 = 0; i11 < vectorM14668g.size(); i11++) {
                    AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) vectorM14668g.get(i11).get("FIXED_BASECALLABLE_KEY");
                    if (abstractC2324e != null) {
                        abstractC2324e.handle(abstractCallableC2320a.getCallParam());
                    }
                    AbstractCallableC2320a abstractCallableC2320aM70436z = m70436z(str, abstractCallableC2320a);
                    if (abstractCallableC2320aM70436z != null) {
                        abstractCallableC2320aM70436z.cancel(i10);
                    }
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManager", "cancelUploadTask Exception:" + e10.toString());
        }
        C1120a.m6675d("TaskThreadManager", "cancelUploadTask end: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    /* renamed from: h */
    public static boolean m70418h(AbstractCallableC2320a abstractCallableC2320a) {
        if (abstractCallableC2320a.getThumbType() == 0) {
            abstractCallableC2320a.setCancel(true);
            if (CloudAlbumSettings.m14363h().m14378n() && !CloudAlbumSettings.m14363h().m14376l()) {
                return true;
            }
        }
        return abstractCallableC2320a.cancel();
    }

    /* renamed from: i */
    public static synchronized void m70419i(String str, int i10, AbstractC2324e abstractC2324e) {
        C12515a.m75110o().m75175e(new a(str, i10, abstractC2324e), false);
    }

    /* renamed from: j */
    public static synchronized void m70420j(String str) {
        try {
            Vector<Map<String, Object>> vectorM14669h = C2333n.m14663f().m14669h();
            if (vectorM14669h != null && vectorM14669h.size() > 0) {
                m70407A(vectorM14669h, str);
            }
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManager", "cancelWaitUploadTask Exception:" + e10.toString());
        }
    }

    /* renamed from: k */
    public static synchronized boolean m70421k(FileInfo fileInfo) {
        Vector<Map<String, Object>> vectorM14669h;
        if (fileInfo == null) {
            C1120a.m6676e("TaskThreadManager", "deleteFileUploadTaskInThread: fileInfo is null");
            return false;
        }
        try {
            Vector<Map<String, Object>> vectorM14668g = C2333n.m14663f().m14668g();
            if (vectorM14668g != null) {
                Iterator<Map<String, Object>> it = vectorM14668g.iterator();
                while (it.hasNext()) {
                    if (m70416f(fileInfo, it.next())) {
                        return true;
                    }
                }
            }
            vectorM14669h = C2333n.m14663f().m14669h();
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManager", "deleteFileUploadTaskInThread Exception: " + e10.toString());
        }
        if (vectorM14669h == null) {
            C1120a.m6676e("TaskThreadManager", "deleteFileUploadTaskInThread: callableList is null");
            return false;
        }
        Iterator<Map<String, Object>> it2 = vectorM14669h.iterator();
        while (it2.hasNext()) {
            if (m70432v(it2, fileInfo)) {
                C1120a.m6675d("TaskThreadManager", "delete fileName:" + fileInfo.getFileName() + ", albumId:" + fileInfo.getAlbumId());
                it2.remove();
                return true;
            }
        }
        C1120a.m6675d("TaskThreadManager", "deleteFileUploadTaskInThread: no matched file");
        return false;
    }

    /* renamed from: l */
    public static String m70422l(FileInfo fileInfo, boolean z10) {
        return z10 ? fileInfo.getShareId() : fileInfo.getAlbumId();
    }

    /* renamed from: m */
    public static Vector<Map<String, Object>> m70423m(int i10) {
        if (i10 == 0) {
            return C2332m.m14608s().m14650o();
        }
        if (i10 == 1) {
            return C2332m.m14608s().m14654t();
        }
        if (i10 == 2) {
            return C2332m.m14608s().m14648m();
        }
        return null;
    }

    /* renamed from: n */
    public static String m70424n(FileInfo fileInfo, boolean z10, boolean z11) {
        return (!z11 || z10) ? fileInfo.getHash() : fileInfo.getUniqueId();
    }

    /* renamed from: o */
    public static int m70425o(int i10, int i11, Map<String, Object> map) {
        if (i11 != 1 || !map.containsKey("FIXED_BASECALLABLE_KEY")) {
            return i11;
        }
        Vector<Map<String, Object>> vectorM14651p = i10 == 0 ? C2332m.m14608s().m14651p() : i10 == 1 ? C2332m.m14608s().m14655u() : i10 == 2 ? C2332m.m14608s().m14649n() : null;
        if (vectorM14651p == null || !vectorM14651p.remove(map)) {
            return i11;
        }
        return 0;
    }

    /* renamed from: p */
    public static int m70426p(boolean z10) {
        return z10 ? 3 : 0;
    }

    /* renamed from: q */
    public static boolean m70427q(Vector<Map<String, Object>> vector) {
        return vector == null || vector.isEmpty();
    }

    /* renamed from: r */
    public static synchronized boolean m70428r(FileInfo fileInfo, int i10, boolean z10) {
        Vector<Map<String, Object>> vectorM14652q;
        Vector<Map<String, Object>> vectorM14648m;
        if (fileInfo == null) {
            return false;
        }
        try {
            if (i10 == 2) {
                if (z10) {
                    vectorM14648m = C2332m.m14608s().m14652q();
                    vectorM14652q = C2332m.m14608s().m14648m();
                } else {
                    vectorM14652q = C2332m.m14608s().m14652q();
                    vectorM14648m = C2332m.m14608s().m14648m();
                }
                if (m70435y(fileInfo, vectorM14648m, i10, true) || m70435y(fileInfo, vectorM14652q, i10, false)) {
                    return true;
                }
            } else if (i10 == 1 && m70435y(fileInfo, C2332m.m14608s().m14654t(), i10, true)) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: s */
    public static void m70429s(Context context, FileInfo fileInfo, int i10, boolean z10) {
        if (i10 != 2) {
            DownloadPhotoBase.m14410e(context, fileInfo, i10, z10, true);
        }
    }

    /* renamed from: t */
    public static synchronized boolean m70430t(FileInfo fileInfo, int i10, boolean z10) {
        Vector<Map<String, Object>> vectorM14652q;
        Vector<Map<String, Object>> vectorM14654t;
        Vector<Map<String, Object>> vectorM14652q2;
        Vector<Map<String, Object>> vectorM14648m;
        if (fileInfo == null) {
            return false;
        }
        try {
            if (i10 == 2) {
                if (z10) {
                    vectorM14648m = C2332m.m14608s().m14652q();
                    vectorM14652q2 = C2332m.m14608s().m14648m();
                } else {
                    vectorM14652q2 = C2332m.m14608s().m14652q();
                    vectorM14648m = C2332m.m14608s().m14648m();
                }
                if (m70435y(fileInfo, vectorM14648m, i10, true) || m70435y(fileInfo, vectorM14652q2, i10, false)) {
                    return true;
                }
            } else if (i10 == 1) {
                if (z10) {
                    vectorM14654t = C2332m.m14608s().m14652q();
                    vectorM14652q = C2332m.m14608s().m14654t();
                } else {
                    vectorM14652q = C2332m.m14608s().m14652q();
                    vectorM14654t = C2332m.m14608s().m14654t();
                }
                if (m70435y(fileInfo, vectorM14654t, i10, true) || m70435y(fileInfo, vectorM14652q, i10, false)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: u */
    public static boolean m70431u(AbstractCallableC2320a abstractCallableC2320a, FileInfo fileInfo) {
        if (abstractCallableC2320a == null) {
            C1120a.m6678w("TaskThreadManager", "no upload task");
            return false;
        }
        if (fileInfo == null) {
            C1120a.m6678w("TaskThreadManager", "fileInfo is null");
            return false;
        }
        FileInfo fileInfo2 = (FileInfo) abstractCallableC2320a.getCallParam();
        if (fileInfo2 == null) {
            C1120a.m6676e("TaskThreadManager", "queue fileInfo is null");
            return false;
        }
        String albumId = fileInfo2.getAlbumId();
        if (!TextUtils.isEmpty(albumId) && albumId.equals(fileInfo.getAlbumId())) {
            String hash = fileInfo2.getHash();
            if (!TextUtils.isEmpty(hash) && hash.equals(fileInfo.getHash())) {
                String fileName = fileInfo2.getFileName();
                if (!TextUtils.isEmpty(fileName) && fileName.equals(fileInfo.getFileName())) {
                    return true;
                }
                C1120a.m6676e("TaskThreadManager", "fileName is null or not equal");
            }
        }
        return false;
    }

    /* renamed from: v */
    public static boolean m70432v(Iterator<Map<String, Object>> it, FileInfo fileInfo) {
        Map<String, Object> next = it.next();
        if (next == null) {
            C1120a.m6678w("TaskThreadManager", "callable is null");
            return false;
        }
        AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) next.get("FIXED_BASECALLABLE_KEY");
        if (abstractCallableC2320a == null) {
            C1120a.m6678w("TaskThreadManager", "uploadTask is null");
            return false;
        }
        FileInfo fileInfo2 = (FileInfo) abstractCallableC2320a.getCallParam();
        if (fileInfo2 == null) {
            C1120a.m6676e("TaskThreadManager", "queue fileInfo is null");
            return false;
        }
        String albumId = fileInfo2.getAlbumId();
        if (TextUtils.isEmpty(albumId)) {
            C1120a.m6676e("TaskThreadManager", "albumId is null");
            return false;
        }
        String hash = fileInfo2.getHash();
        if (TextUtils.isEmpty(hash)) {
            C1120a.m6676e("TaskThreadManager", "hash is null");
            return false;
        }
        String fileName = fileInfo2.getFileName();
        if (!TextUtils.isEmpty(fileName)) {
            return albumId.equals(fileInfo.getAlbumId()) && hash.equals(fileInfo.getHash()) && fileName.equals(fileInfo.getFileName());
        }
        C1120a.m6676e("TaskThreadManager", "fileName is null");
        return false;
    }

    /* renamed from: w */
    public static synchronized boolean m70433w(FileInfo fileInfo) {
        try {
            Vector<Map<String, Object>> vectorM14669h = C2333n.m14663f().m14669h();
            if (vectorM14669h != null) {
                Iterator<Map<String, Object>> it = vectorM14669h.iterator();
                while (it.hasNext()) {
                    if (m70432v(it, fileInfo)) {
                        return true;
                    }
                }
            }
            Vector<Map<String, Object>> vectorM14668g = C2333n.m14663f().m14668g();
            if (vectorM14668g != null) {
                Iterator<Map<String, Object>> it2 = vectorM14668g.iterator();
                while (it2.hasNext()) {
                    if (m70431u((AbstractCallableC2320a) it2.next().get("FIXED_BASECALLABLE_KEY"), fileInfo)) {
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManager", "isGeneralTaskInQueue Exception:" + e10.toString());
        }
        return false;
    }

    /* renamed from: x */
    public static boolean m70434x(FileInfo fileInfo) {
        return !TextUtils.isEmpty(fileInfo.getShareId());
    }

    /* renamed from: y */
    public static boolean m70435y(FileInfo fileInfo, Vector<Map<String, Object>> vector, int i10, boolean z10) {
        if (m70427q(vector)) {
            return false;
        }
        boolean zM70434x = m70434x(fileInfo);
        String strM70422l = m70422l(fileInfo, zM70434x);
        String strM70424n = m70424n(fileInfo, zM70434x, true);
        try {
            Iterator<Map<String, Object>> it = vector.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) it.next().get("FIXED_BASECALLABLE_KEY");
                FileInfo fileInfo2 = (FileInfo) abstractCallableC2320a.getCallParam();
                if (fileInfo2 == null) {
                    C1120a.m6678w("TaskThreadManager", "fileInfoExec is null! continue");
                } else {
                    String shareId = zM70434x ? fileInfo2.getShareId() : fileInfo2.getAlbumId();
                    String uniqueId = TextUtils.isEmpty(fileInfo2.getShareId()) ? fileInfo2.getUniqueId() : fileInfo2.getHash();
                    if (fileInfo.getHash() != null && strM70422l != null && strM70422l.equals(shareId) && strM70424n.equals(uniqueId) && i10 == abstractCallableC2320a.getThumbType()) {
                        if (!z10) {
                            C1120a.m6677i("TaskThreadManager", "isSameTaskInExecing not in same list result:true ,fileName:" + fileInfo.getFileName());
                            return true;
                        }
                        i11++;
                    }
                }
            }
            if (i11 > 1) {
                C1120a.m6677i("TaskThreadManager", "isDownRollTaskExecing in same list result:true ,fileName:" + fileInfo.getFileName());
                return true;
            }
        } catch (Exception e10) {
            C1120a.m6676e("TaskThreadManager", "isDownRollTaskExecing Exception:" + e10.toString());
        }
        return false;
    }

    /* renamed from: z */
    public static AbstractCallableC2320a m70436z(String str, AbstractCallableC2320a abstractCallableC2320a) {
        if (abstractCallableC2320a == null) {
            C1120a.m6676e("TaskThreadManager", "uploadTask is null");
            return null;
        }
        FileInfo fileInfo = (FileInfo) abstractCallableC2320a.getCallParam();
        if (fileInfo == null) {
            C1120a.m6676e("TaskThreadManager", "fileInfoExec is null");
            return null;
        }
        String fileUploadType = fileInfo.getFileUploadType();
        if (fileUploadType == null) {
            C1120a.m6676e("TaskThreadManager", "uploadType is null");
            return null;
        }
        C1120a.m6677i("TaskThreadManager", "processUploadTask type:" + fileInfo.getFileType() + ";fileName:" + fileInfo.getFileName() + ", fileUploadType: " + fileInfo.getFileUploadType() + "lpath: " + fileInfo.getLpath());
        String albumId = fileInfo.getAlbumId();
        if (albumId == null) {
            C1120a.m6676e("TaskThreadManager", "albumId is null");
            return null;
        }
        if (!albumId.startsWith("default-album-")) {
            C1120a.m6676e("TaskThreadManager", "not default albumId");
            return null;
        }
        if ("0".equals(str) || fileUploadType.equals(str) || str.equals(fileInfo.getLpath())) {
            return abstractCallableC2320a;
        }
        return null;
    }
}
