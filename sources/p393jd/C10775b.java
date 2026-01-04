package p393jd;

import android.app.Activity;
import android.os.Handler;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import p651t8.C12998f;
import p778xk.C13821b;
import p778xk.C13823d;
import p802y8.AbstractC13919c;

/* renamed from: jd.b */
/* loaded from: classes3.dex */
public class C10775b extends AbstractC13919c {

    /* renamed from: a */
    public Activity f51509a;

    /* renamed from: b */
    public Handler f51510b;

    /* renamed from: c */
    public String f51511c;

    /* renamed from: d */
    public String f51512d;

    public C10775b(Activity activity, Handler handler, String str, String str2) {
        this.f51509a = activity;
        this.f51510b = handler;
        this.f51511c = str;
        this.f51512d = str2;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws IOException {
        C12998f.m78034R().m78104i(this.f51510b, C12998f.m78034R().m78053F(this.f51511c, this.f51512d, C13821b.m82867w().m82894u(), (List) C13823d.m82904y().m82926j(this.f51509a).stream().map(new C10774a()).collect(Collectors.toList())));
    }
}
