package md;

import android.os.Messenger;
import com.huawei.android.hicloud.task.frame.ICBTask;
import java.util.ArrayList;
import java.util.List;

/* renamed from: md.d */
/* loaded from: classes3.dex */
public class C11441d {

    /* renamed from: a */
    public final Messenger f53306a;

    /* renamed from: b */
    public int f53307b;

    /* renamed from: c */
    public boolean f53308c = true;

    /* renamed from: d */
    public final List<ICBTask> f53309d = new ArrayList(12);

    public C11441d(Messenger messenger, int i10) {
        this.f53306a = messenger;
        this.f53307b = i10;
    }

    /* renamed from: a */
    public void m68546a() {
        synchronized (this.f53309d) {
            this.f53309d.clear();
        }
    }

    /* renamed from: b */
    public Messenger m68547b() {
        return this.f53306a;
    }

    /* renamed from: c */
    public void m68548c(int i10) {
        this.f53307b = i10;
    }
}
