package p009a8;

import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.logic.callable.DisableCallable;
import com.huawei.android.hicloud.album.service.logic.callable.QueryDisableStateCallable;
import com.huawei.android.hicloud.album.service.logic.callable.QueryUnSavedOriginalsCallable;
import com.huawei.android.hicloud.album.service.logic.callable.ResumeCallable;
import com.huawei.android.hicloud.album.service.logic.callable.SaveOriginalCallable;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p251e8.C9423b;
import p850zo.InterfaceC14350a;
import p850zo.InterfaceC14351b;
import p850zo.InterfaceC14352c;
import p850zo.InterfaceC14353d;

/* renamed from: a8.b */
/* loaded from: classes2.dex */
public class C0064b {

    /* renamed from: b */
    public static volatile C0064b f212b;

    /* renamed from: a */
    public ExecutorService f213a = Executors.newFixedThreadPool(1);

    /* renamed from: c */
    public static C0064b m422c() {
        if (f212b == null) {
            synchronized (C0064b.class) {
                try {
                    if (f212b == null) {
                        f212b = new C0064b();
                    }
                } finally {
                }
            }
        }
        return f212b;
    }

    /* renamed from: a */
    public void m423a(Context context, int i10) throws SQLException {
        Bundle bundle = new Bundle();
        bundle.putBoolean("GeneralAblum", false);
        CloudAlbumManager.m14456v().m14470O(context, bundle, i10);
        C1122c.m6764b2(i10, false);
    }

    /* renamed from: b */
    public void m424b(InterfaceC14351b interfaceC14351b) {
        if (this.f213a.submit(new DisableCallable(interfaceC14351b)) == null) {
            C1120a.m6676e("DisableAndResumeManager", "future fail");
        }
    }

    /* renamed from: d */
    public void m425d(Context context, boolean z10) {
        C9423b.m59098f(context, z10);
    }

    /* renamed from: e */
    public void m426e(Context context, int i10) {
        C1120a.m6677i("DisableAndResumeManager", "notifySaveOriginal type: " + i10);
        C9423b.m59099g(context, i10, C1136q.b.m7019P(context));
    }

    /* renamed from: f */
    public int m427f(InterfaceC14350a interfaceC14350a) {
        if (this.f213a.submit(new QueryDisableStateCallable(interfaceC14350a)) != null) {
            return 0;
        }
        C1120a.m6676e("DisableAndResumeManager", "future fail");
        return 0;
    }

    /* renamed from: g */
    public void m428g(Context context, InterfaceC14352c interfaceC14352c) {
        if (this.f213a.submit(new QueryUnSavedOriginalsCallable(context, QueryUnSavedOriginalsCallable.QueryType.UNSAVED_NUM, interfaceC14352c)) == null) {
            C1120a.m6676e("DisableAndResumeManager", "future fail");
        }
    }

    /* renamed from: h */
    public void m429h(Context context, InterfaceC14352c interfaceC14352c) {
        if (this.f213a.submit(new QueryUnSavedOriginalsCallable(context, QueryUnSavedOriginalsCallable.QueryType.UNSAVED_SIZE, interfaceC14352c)) == null) {
            C1120a.m6676e("DisableAndResumeManager", "future fail");
        }
    }

    /* renamed from: i */
    public void m430i(InterfaceC14351b interfaceC14351b, Context context) {
        if (this.f213a.submit(new ResumeCallable(interfaceC14351b, context)) == null) {
            C1120a.m6676e("DisableAndResumeManager", "future fail");
        }
    }

    /* renamed from: j */
    public void m431j(Context context, boolean z10, InterfaceC14353d interfaceC14353d) {
        if (this.f213a.submit(new SaveOriginalCallable(context, z10, interfaceC14353d)) == null) {
            C1120a.m6676e("DisableAndResumeManager", "future fail");
        }
    }
}
