package mm;

import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: mm.p */
/* loaded from: classes6.dex */
public abstract class AbstractC11494p<T> {
    private static final int DEFAULT_BATCHPAGE = 5000;
    private String tableName = UUID.randomUUID().toString().replaceAll("-", "");
    private int batchPage = 5000;

    public void batchExecute(InterfaceC11493o interfaceC11493o) throws C9721b {
        try {
            create();
            int iSummary = summary();
            if (iSummary > 0) {
                int i10 = 1;
                while (i10 <= iSummary) {
                    int i11 = this.batchPage + i10;
                    interfaceC11493o.mo15310a(batchQuery(i10, i11), iSummary);
                    i10 = i11 + 1;
                }
            }
        } finally {
            drop();
        }
    }

    public List<T> batchQuery(long j10, long j11) throws C9721b {
        return new ArrayList();
    }

    public abstract void create() throws C9721b;

    public abstract void drop() throws C9721b;

    public void execute(InterfaceC11495q interfaceC11495q) throws C9721b {
        try {
            create();
            int iSummary = summary();
            if (iSummary > 0) {
                interfaceC11495q.mo1695a(this, iSummary);
            }
        } finally {
            drop();
        }
    }

    public String getTableName() {
        return this.tableName;
    }

    public abstract T query(int i10) throws C9721b;

    public void setBatchPage(int i10) {
        this.batchPage = i10;
    }

    public abstract int summary() throws C9721b;

    public void execute(InterfaceC11496r interfaceC11496r, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, String str) throws C9721b {
        try {
            create();
            int iSummary = summary();
            if (iSummary > 0) {
                interfaceC11496r.mo57663a(this, iSummary, atomicBoolean, atomicBoolean2, str);
            }
        } finally {
            drop();
        }
    }
}
