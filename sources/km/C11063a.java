package km;

import com.huawei.hicloud.base.slice.LengthGetter;
import com.huawei.hicloud.base.slice.Slice;
import com.huawei.hicloud.base.slice.SliceItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: km.a */
/* loaded from: classes6.dex */
public class C11063a<T> {

    /* renamed from: a */
    public List<T> f52253a;

    /* renamed from: b */
    public int f52254b = 0;

    /* renamed from: c */
    public long f52255c = 0;

    /* renamed from: d */
    public long f52256d = 0;

    /* renamed from: e */
    public LengthGetter<T> f52257e;

    public C11063a(List<T> list, LengthGetter<T> lengthGetter) {
        this.f52253a = list;
        this.f52257e = lengthGetter;
    }

    /* renamed from: a */
    public boolean m66676a() {
        int size = this.f52253a.size() - 1;
        int i10 = this.f52254b;
        if (i10 >= size) {
            return i10 == size && this.f52255c < this.f52257e.getLength(i10, this.f52253a.get(size));
        }
        return true;
    }

    /* renamed from: b */
    public Slice<T> m66677b(long j10) {
        return m66678c(j10, true);
    }

    /* renamed from: c */
    public Slice<T> m66678c(long j10, boolean z10) {
        int i10;
        ArrayList arrayList = new ArrayList();
        long length = 0;
        long j11 = 0;
        while (true) {
            if (this.f52254b >= this.f52253a.size()) {
                break;
            }
            T t10 = this.f52253a.get(this.f52254b);
            long length2 = this.f52257e.getLength(this.f52254b, t10) - this.f52255c;
            long j12 = j10 - j11;
            if (j12 > length2) {
                if (length2 != 0) {
                    j11 += length2;
                    arrayList.add(new SliceItem(t10, this.f52254b, this.f52256d, length2));
                }
                this.f52255c = 0L;
                this.f52256d = 0L;
                if (z10 && (t10 instanceof File) && (i10 = this.f52254b) == 0) {
                    this.f52254b = i10 + 1;
                    break;
                }
                this.f52254b++;
            } else {
                arrayList.add(new SliceItem(t10, this.f52254b, this.f52256d, j12));
                this.f52255c += j12;
                this.f52256d += j12;
                break;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            length += ((SliceItem) it.next()).getLength();
        }
        return new Slice<>(arrayList, length);
    }
}
