package p328h6;

import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: h6.i */
/* loaded from: classes.dex */
public final class C10109i {

    /* renamed from: b */
    public static LinkedBlockingQueue<C10108h> f49325b = new LinkedBlockingQueue<>();

    /* renamed from: c */
    public static Map<String, List<C10107g>> f49326c = new HashMap();

    /* renamed from: d */
    public static C10109i f49327d = new C10109i();

    /* renamed from: a */
    public int f49328a = -1;

    /* renamed from: b */
    public static C10109i m62949b() {
        return f49327d;
    }

    /* renamed from: a */
    public C10108h m62950a() {
        try {
            return f49325b.take();
        } catch (InterruptedException e10) {
            C2111d.m12648d("TarTaskSplit", "tarTask queue take exception,exception info is " + e10.getLocalizedMessage());
            return null;
        }
    }
}
