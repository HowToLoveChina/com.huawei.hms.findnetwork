package p762x4;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.PackageSizeUtils;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import p229di.C9153r;
import p699v4.C13348q;

/* renamed from: x4.h */
/* loaded from: classes.dex */
public class CallableC13701h implements Callable<HashMap> {

    /* renamed from: a */
    public List<String> f61686a;

    /* renamed from: b */
    public Context f61687b;

    public CallableC13701h(Context context, List<String> list) {
        new ArrayList(15);
        this.f61687b = context;
        this.f61686a = list;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Long> call() {
        C2111d.m12653i("GetAppDataSizeTask", "GetAppDataSizeTask task start");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (C13348q.m80082b(this.f61686a)) {
            C2111d.m12657m("GetAppDataSizeTask", "packageNameList is empty.");
            return new HashMap<>(0);
        }
        HashMap<String, Long> map = new HashMap<>(this.f61686a.size());
        PackageSizeUtils packageSizeUtils = new PackageSizeUtils(this.f61687b);
        for (String str : this.f61686a) {
            if (!C2157a.m13170E(str)) {
                map.put(str, Long.valueOf(packageSizeUtils.m12738c(this.f61687b, str, C9153r.m57494b())));
            }
        }
        C2111d.m12654j("GetAppDataSizeTask", "GetAppDataSizeTask task end, cost total time [", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "]");
        return map;
    }
}
