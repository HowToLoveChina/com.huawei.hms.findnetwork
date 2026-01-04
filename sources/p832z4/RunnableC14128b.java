package p832z4;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p029b5.C1117j;
import p029b5.InterfaceC1118k;
import p669u5.C13124b;

/* renamed from: z4.b */
/* loaded from: classes.dex */
public class RunnableC14128b implements Runnable {

    /* renamed from: a */
    public Context f63163a;

    /* renamed from: b */
    public InterfaceC14130d f63164b;

    /* renamed from: z4.b$a */
    public static class a {

        /* renamed from: m */
        public C1117j.a f63177m;

        /* renamed from: n */
        public String f63178n;

        /* renamed from: a */
        public HashMap<String, String> f63165a = BackupConstant.m13133g();

        /* renamed from: b */
        public ConcurrentHashMap<String, String> f63166b = BackupConstant.m13146t();

        /* renamed from: c */
        public HashMap<String, String> f63167c = BackupConstant.m13131e();

        /* renamed from: e */
        public ArrayList<String> f63169e = BackupConstant.m13135i();

        /* renamed from: f */
        public Set<String> f63170f = C2157a.m13203k();

        /* renamed from: g */
        public ArrayList<String> f63171g = BackupConstant.m13141o();

        /* renamed from: h */
        public ArrayList<String> f63172h = BackupConstant.m13148v();

        /* renamed from: i */
        public Set<String> f63173i = BackupConstant.m13144r();

        /* renamed from: j */
        public Set<String> f63174j = BackupConstant.m13147u();

        /* renamed from: k */
        public HashSet<String> f63175k = BackupConstant.BackupObject.getBackupSystemObject();

        /* renamed from: l */
        public Set<String> f63176l = BackupConstant.m13140n();

        /* renamed from: d */
        public Map<String, String> f63168d = BackupConstant.m13143q();

        /* renamed from: j */
        public final a m84789j(C1117j.a aVar, String str) {
            this.f63177m = aVar;
            this.f63178n = str;
            this.f63165a.put(str, aVar.m6650d());
            this.f63166b.put(str, aVar.m6649c());
            this.f63174j.add(str);
            this.f63175k.add(str);
            return this;
        }

        /* renamed from: k */
        public final a m84790k() {
            if (this.f63177m.m6656j()) {
                this.f63168d.put(this.f63178n, "");
            }
            return this;
        }

        /* renamed from: l */
        public final a m84791l() {
            if (TextUtils.isEmpty(this.f63177m.m6647a())) {
                this.f63167c.put(this.f63178n, C13124b.class.getName());
            } else {
                this.f63167c.put(this.f63178n, this.f63177m.m6647a());
            }
            return this;
        }

        /* renamed from: m */
        public final a m84792m() {
            if (this.f63177m.m6651e()) {
                this.f63170f.add(this.f63178n);
            }
            return this;
        }

        /* renamed from: n */
        public final a m84793n() {
            if (this.f63177m.m6652f()) {
                this.f63172h.add(this.f63178n);
            }
            return this;
        }

        /* renamed from: o */
        public final a m84794o() {
            if (this.f63177m.m6653g()) {
                this.f63171g.add(this.f63178n);
            }
            return this;
        }

        /* renamed from: p */
        public final a m84795p() {
            if (this.f63177m.m6654h()) {
                this.f63173i.add(this.f63178n);
            }
            return this;
        }

        /* renamed from: q */
        public final a m84796q() {
            if (this.f63177m.m6655i()) {
                this.f63176l.add(this.f63178n);
            } else {
                C2111d.m12653i("LoadUncoupleModuleInfoTask", "hide in systemModule. do nothing here.");
            }
            return this;
        }

        /* renamed from: r */
        public final a m84797r() {
            if (this.f63177m.m6657k()) {
                this.f63169e.add(this.f63178n);
            }
            return this;
        }
    }

    public RunnableC14128b(Context context, InterfaceC14130d interfaceC14130d) {
        this.f63163a = context;
        this.f63164b = interfaceC14130d;
    }

    /* renamed from: a */
    public final List<C1117j.a> m84777a(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add((C1117j.a) it.next());
        }
        return arrayList;
    }

    /* renamed from: c */
    public final boolean m84778c(InterfaceC1118k interfaceC1118k) {
        if (interfaceC1118k == null) {
            return false;
        }
        boolean zMo6615f = interfaceC1118k.getVersion() != 0 ? interfaceC1118k.mo6615f(this.f63163a, "configParam/uncouple_module_setting.xml") : false;
        C2111d.m12654j("LoadUncoupleModuleInfoTask", "parse param result is:", Boolean.valueOf(zMo6615f));
        return zMo6615f;
    }

    /* renamed from: d */
    public final void m84779d(List<C1117j.a> list) {
        a aVar = new a();
        for (C1117j.a aVar2 : list) {
            String strM6648b = aVar2.m6648b();
            if (strM6648b == null) {
                C2111d.m12657m("LoadUncoupleModuleInfoTask", "read xml result module name = null!");
            } else {
                aVar.m84789j(aVar2, strM6648b).m84791l().m84792m().m84793n().m84794o().m84790k().m84795p().m84797r().m84796q();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f63163a == null) {
            C2111d.m12648d("LoadUncoupleModuleInfoTask", "context is null.");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        C2111d.m12653i("LoadUncoupleModuleInfoTask", "begin parse param.");
        C1117j c1117j = new C1117j();
        boolean zM84778c = m84778c(c1117j);
        Object objMo6616h = c1117j.mo6616h();
        if (zM84778c && (objMo6616h instanceof List)) {
            m84779d(m84777a(objMo6616h));
        }
        C2111d.m12654j("LoadUncoupleModuleInfoTask", "end parse param, result is:", Boolean.valueOf(zM84778c), ", cost time: ", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        this.f63164b.mo12700a();
    }
}
