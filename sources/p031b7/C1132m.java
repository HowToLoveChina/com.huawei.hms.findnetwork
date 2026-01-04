package p031b7;

import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.p069cg.bean.MediaFileBean;

/* renamed from: b7.m */
/* loaded from: classes2.dex */
public class C1132m {

    /* renamed from: a */
    public LruCache<String, Media> f5388a;

    /* renamed from: b */
    public LruCache<String, MediaFileBean> f5389b;

    /* renamed from: b7.m$b */
    public static class b {

        /* renamed from: a */
        public static final C1132m f5390a = new C1132m();
    }

    public /* synthetic */ C1132m(a aVar) {
        this();
    }

    /* renamed from: c */
    public static C1132m m6921c() {
        return b.f5390a;
    }

    /* renamed from: a */
    public void m6922a(String str, Media media) {
        if (TextUtils.isEmpty(str) || media == null || C1122c.m6819p1(media)) {
            return;
        }
        this.f5388a.put(str, media);
    }

    /* renamed from: b */
    public void m6923b(String str, MediaFileBean mediaFileBean) {
        if (TextUtils.isEmpty(str) || mediaFileBean == null) {
            return;
        }
        this.f5389b.put(str, mediaFileBean);
    }

    /* renamed from: d */
    public Media m6924d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f5388a.get(str);
    }

    /* renamed from: e */
    public MediaFileBean m6925e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f5389b.get(str);
    }

    public C1132m() {
        this.f5388a = new LruCache<>(20971520);
        this.f5389b = new LruCache<>(20971520);
    }
}
