package p031b7;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Formatter;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p072vo.FileInfo;
import java.util.ArrayList;
import java.util.HashMap;
import p514o9.C11829c;

/* renamed from: b7.n */
/* loaded from: classes2.dex */
public class C1133n {

    /* renamed from: c */
    public static final long f5391c;

    /* renamed from: a */
    public final HashMap<String, ArrayList<MediaFileBean>> f5392a;

    /* renamed from: b */
    public final HashMap<String, c> f5393b;

    /* renamed from: b7.n$b */
    public static class b {

        /* renamed from: a */
        public static final C1133n f5394a = new C1133n();
    }

    /* renamed from: b7.n$c */
    public static class c {

        /* renamed from: a */
        public long f5395a;

        /* renamed from: b */
        public long f5396b;

        /* renamed from: c */
        public long f5397c;

        /* renamed from: d */
        public int f5398d;

        public c() {
            long j10 = C1133n.f5391c;
            this.f5395a = 20 * j10;
            this.f5396b = 600000L;
            this.f5397c = j10 * 200;
            this.f5398d = 100;
        }
    }

    static {
        f5391c = C11829c.f54756b ? 1000000L : 1048576L;
    }

    public /* synthetic */ C1133n(a aVar) {
        this();
    }

    /* renamed from: e */
    public static C1133n m6927e() {
        return b.f5394a;
    }

    /* renamed from: a */
    public void m6928a(String str, c cVar) {
        if (this.f5393b.containsKey(str)) {
            this.f5393b.remove(str, cVar);
        }
        this.f5393b.put(str, cVar);
    }

    /* renamed from: b */
    public int m6929b(String str, MediaFileBean mediaFileBean, c cVar) {
        ArrayList<MediaFileBean> arrayList = this.f5392a.get(str);
        if (arrayList == null) {
            C1120a.m6677i("PhotoPickerSelectedCache", "add " + str + " cache");
            arrayList = new ArrayList<>();
            this.f5392a.put(str, arrayList);
        }
        int iM6930c = m6930c(mediaFileBean, cVar);
        if (iM6930c != 0) {
            return iM6930c;
        }
        if (arrayList.size() >= cVar.f5398d) {
            return 4;
        }
        if (arrayList.contains(mediaFileBean)) {
            return iM6930c;
        }
        arrayList.add(mediaFileBean);
        return iM6930c;
    }

    /* renamed from: c */
    public int m6930c(MediaFileBean mediaFileBean, c cVar) {
        int iM14338j = mediaFileBean.m14338j();
        FileInfo fileInfoM14329e = mediaFileBean.m14329e();
        if (fileInfoM14329e == null) {
            return 0;
        }
        if (iM14338j != 3) {
            return (iM14338j != 2 || fileInfoM14329e.getSize() <= cVar.f5395a) ? 0 : 3;
        }
        if (mediaFileBean.m14325c() > cVar.f5396b) {
            return 2;
        }
        return fileInfoM14329e.getSize() > cVar.f5397c ? 1 : 0;
    }

    /* renamed from: d */
    public final String m6931d(long j10, Resources resources) {
        int i10 = (int) (j10 / 60000);
        boolean z10 = true;
        if (i10 <= 0) {
            i10 = 0;
        } else {
            int i11 = i10 / 60;
            if (i11 > 0) {
                i10 = i11;
            } else {
                z10 = false;
            }
        }
        return z10 ? resources.getQuantityString(R$plurals.remain_time_hour, i10, Integer.valueOf(i10)) : resources.getQuantityString(R$plurals.cloudbackup_prepare_all_data_time_end, i10, Integer.valueOf(i10));
    }

    /* renamed from: f */
    public String m6932f(Context context, int i10, c cVar) {
        Resources resources = context.getResources();
        if (resources != null) {
            if (i10 == 1) {
                return resources.getString(R$string.album_photo_picker_video_size_limit_tip, Formatter.formatShortFileSize(context, cVar.f5397c));
            }
            if (i10 == 2) {
                return resources.getString(R$string.album_photo_picker_video_duration_limit_tip, m6931d(cVar.f5396b, resources));
            }
            if (i10 == 3) {
                return resources.getString(R$string.album_photo_picker_image_size_limit_tip, Formatter.formatShortFileSize(context, cVar.f5395a));
            }
            if (i10 == 4) {
                return resources.getString(R$string.album_photo_picker_count_limit_tip);
            }
        }
        return null;
    }

    /* renamed from: g */
    public c m6933g(String str) {
        return this.f5393b.get(str);
    }

    /* renamed from: h */
    public ArrayList<MediaFileBean> m6934h(String str) {
        ArrayList<MediaFileBean> arrayList = this.f5392a.get(str);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<MediaFileBean> arrayList2 = new ArrayList<>();
        this.f5392a.put(str, arrayList2);
        return arrayList2;
    }

    /* renamed from: i */
    public void m6935i(String str) {
        this.f5392a.remove(str);
        this.f5393b.remove(str);
    }

    /* renamed from: j */
    public void m6936j(String str, MediaFileBean mediaFileBean) {
        ArrayList<MediaFileBean> arrayList = this.f5392a.get(str);
        if (arrayList != null) {
            arrayList.remove(mediaFileBean);
        }
    }

    public C1133n() {
        this.f5392a = new HashMap<>();
        this.f5393b = new HashMap<>();
    }
}
