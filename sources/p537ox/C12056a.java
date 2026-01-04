package p537ox;

/* renamed from: ox.a */
/* loaded from: classes9.dex */
public class C12056a {

    /* renamed from: a */
    public b f55811a;

    /* renamed from: b */
    public long f55812b;

    /* renamed from: c */
    public long f55813c;

    /* renamed from: d */
    public int f55814d;

    /* renamed from: e */
    public c f55815e;

    /* renamed from: f */
    public String f55816f;

    /* renamed from: g */
    public a f55817g;

    /* renamed from: h */
    public Exception f55818h;

    /* renamed from: i */
    public boolean f55819i;

    /* renamed from: j */
    public boolean f55820j;

    /* renamed from: ox.a$a */
    public enum a {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    /* renamed from: ox.a$b */
    public enum b {
        READY,
        BUSY
    }

    /* renamed from: ox.a$c */
    public enum c {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public C12056a() {
        m72198f();
    }

    /* renamed from: a */
    public void m72193a() {
        this.f55817g = a.SUCCESS;
        this.f55814d = 100;
        m72198f();
    }

    /* renamed from: b */
    public void m72194b(Exception exc) {
        this.f55817g = a.ERROR;
        this.f55818h = exc;
        m72198f();
    }

    /* renamed from: c */
    public void m72195c() {
        m72198f();
        this.f55816f = null;
        this.f55812b = 0L;
        this.f55813c = 0L;
        this.f55814d = 0;
    }

    /* renamed from: d */
    public b m72196d() {
        return this.f55811a;
    }

    /* renamed from: e */
    public boolean m72197e() {
        return this.f55819i;
    }

    /* renamed from: f */
    public final void m72198f() {
        this.f55815e = c.NONE;
        this.f55811a = b.READY;
    }

    /* renamed from: g */
    public void m72199g(c cVar) {
        this.f55815e = cVar;
    }

    /* renamed from: h */
    public void m72200h(String str) {
        this.f55816f = str;
    }

    /* renamed from: i */
    public void m72201i(a aVar) {
        this.f55817g = aVar;
    }

    /* renamed from: j */
    public void m72202j(b bVar) {
        this.f55811a = bVar;
    }

    /* renamed from: k */
    public void m72203k(long j10) {
        this.f55812b = j10;
    }

    /* renamed from: l */
    public void m72204l(long j10) throws InterruptedException {
        long j11 = this.f55813c + j10;
        this.f55813c = j11;
        long j12 = this.f55812b;
        if (j12 > 0) {
            int i10 = (int) ((j11 * 100) / j12);
            this.f55814d = i10;
            if (i10 > 100) {
                this.f55814d = 100;
            }
        }
        while (this.f55820j) {
            try {
                Thread.sleep(150L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
