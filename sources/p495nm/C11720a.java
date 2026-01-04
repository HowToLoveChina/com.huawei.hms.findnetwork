package p495nm;

import com.huawei.hicloud.cloudbackup.p104v3.model.BackupItem;
import fk.C9721b;
import java.util.ArrayList;
import p514o9.C11839m;
import p617rl.C12519c;

/* renamed from: nm.a */
/* loaded from: classes6.dex */
public class C11720a {

    /* renamed from: c */
    public static final C11720a f54223c = new C11720a();

    /* renamed from: d */
    public static final Object f54224d = new Object();

    /* renamed from: a */
    public ArrayList<BackupItem> f54225a = new ArrayList<>();

    /* renamed from: b */
    public boolean f54226b;

    /* renamed from: a */
    public static C11720a m69921a() {
        return f54223c;
    }

    /* renamed from: b */
    public boolean m69922b() {
        return this.f54226b;
    }

    /* renamed from: c */
    public void m69923c() {
        try {
            if (new C12519c().m75306q().contains("music")) {
                this.f54226b = true;
            } else {
                this.f54226b = false;
            }
        } catch (C9721b e10) {
            C11839m.m70688i("RestoreCache", "updateMusicVirtual e " + e10.toString());
        }
    }
}
