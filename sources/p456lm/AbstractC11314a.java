package p456lm;

import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: lm.a */
/* loaded from: classes6.dex */
public abstract class AbstractC11314a extends CloudBackupBaseTask implements Comparable<AbstractC11314a> {

    /* renamed from: d */
    public static final AtomicLong f53001d = new AtomicLong();

    /* renamed from: a */
    public String f53002a;

    /* renamed from: b */
    public long f53003b = f53001d.getAndIncrement();

    /* renamed from: c */
    public int f53004c;

    public AbstractC11314a(String str, int i10) {
        this.f53002a = str;
        this.f53004c = i10;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC11314a abstractC11314a) {
        int i10 = this.f53004c;
        int i11 = abstractC11314a.f53004c;
        return i10 == i11 ? Long.compare(this.f53003b, abstractC11314a.f53003b) : i10 < i11 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC11314a abstractC11314a = (AbstractC11314a) obj;
        return this.f53003b == abstractC11314a.f53003b && this.f53004c == abstractC11314a.f53004c;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f53003b), Integer.valueOf(this.f53004c));
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        C11315b.m67979c().m67985g(this.f53002a, this);
    }
}
