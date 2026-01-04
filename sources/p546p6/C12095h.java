package p546p6;

import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import fk.C9721b;
import java.util.ArrayList;
import p031b7.C1122c;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: p6.h */
/* loaded from: classes2.dex */
public class C12095h extends AbstractC12367d {

    /* renamed from: a */
    public ArrayList<Album> f56093a;

    public C12095h(ArrayList<Album> arrayList) {
        this.f56093a = arrayList;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C1122c.m6688D(this.f56093a);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.ALBUM_FIX;
    }
}
