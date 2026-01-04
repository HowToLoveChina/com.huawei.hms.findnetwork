package p511o6;

import android.content.Context;
import com.huawei.android.p069cg.p072vo.FileInfo;
import com.huawei.android.p069cg.request.threadpool.AbstractC2324e;
import com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a;
import com.huawei.android.p069cg.request.threadpool.C2332m;
import java.util.Map;
import java.util.Vector;
import p031b7.C1120a;

/* renamed from: o6.e */
/* loaded from: classes2.dex */
public class C11823e {

    /* renamed from: o6.e$a */
    public class a extends Thread {

        /* renamed from: a */
        public final /* synthetic */ AbstractC2324e f54730a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, AbstractC2324e abstractC2324e) {
            super(str);
            this.f54730a = abstractC2324e;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Vector<Map<String, Object>> vectorM14611D = C2332m.m14608s().m14611D();
                if (vectorM14611D != null && vectorM14611D.size() > 0) {
                    int i10 = 0;
                    while (i10 < vectorM14611D.size()) {
                        Map<String, Object> map = vectorM14611D.get(i10);
                        AbstractCallableC2320a abstractCallableC2320a = (AbstractCallableC2320a) map.get("FIXED_BASECALLABLE_KEY");
                        if (abstractCallableC2320a != null) {
                            AbstractC2324e abstractC2324e = this.f54730a;
                            if (abstractC2324e != null) {
                                abstractC2324e.handle(abstractCallableC2320a.getCallParam());
                            }
                            vectorM14611D.remove(map);
                            i10--;
                        }
                        i10++;
                    }
                }
                Vector<Map<String, Object>> vectorM14610C = C2332m.m14608s().m14610C();
                if (vectorM14610C != null) {
                    for (int i11 = 0; i11 < vectorM14610C.size(); i11++) {
                        AbstractCallableC2320a abstractCallableC2320a2 = (AbstractCallableC2320a) vectorM14610C.get(i11).get("FIXED_BASECALLABLE_KEY");
                        if (abstractCallableC2320a2 != null) {
                            AbstractC2324e abstractC2324e2 = this.f54730a;
                            if (abstractC2324e2 != null) {
                                abstractC2324e2.handle(abstractCallableC2320a2.getCallParam());
                            }
                            FileInfo fileInfo = (FileInfo) abstractCallableC2320a2.getCallParam();
                            if (fileInfo != null) {
                                C1120a.m6675d("TaskThreadManualUploadManager", "cancelUploadTask type:" + fileInfo.getFileType() + ";fileName:" + fileInfo.getFileName());
                                abstractCallableC2320a2.cancel();
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                C1120a.m6676e("TaskThreadManualUploadManager", "cancelUploadTaskAll error:" + e10.toString());
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m70443a(Context context, AbstractC2324e abstractC2324e) {
        new a("TaskThreadManualUploadManager-Thread-2", abstractC2324e).start();
    }
}
