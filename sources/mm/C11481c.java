package mm;

import fk.C9721b;
import pl.C12162d;
import pl.C12170l;

/* renamed from: mm.c */
/* loaded from: classes6.dex */
public class C11481c extends AbstractC11494p<C12170l> {

    /* renamed from: a */
    public String f53387a;

    /* renamed from: b */
    public C12162d f53388b;

    public C11481c(String str, C12162d c12162d) {
        this.f53387a = str;
        this.f53388b = c12162d;
    }

    @Override // mm.AbstractC11494p
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C12170l query(int i10) throws C9721b {
        return this.f53388b.query("t_del", getTableName(), i10);
    }

    @Override // mm.AbstractC11494p
    public void create() throws C9721b {
        this.f53388b.build(getTableName(), "select id from t_del where app_id = ? and flag != 1;", new String[]{this.f53387a});
    }

    @Override // mm.AbstractC11494p
    public void drop() throws C9721b {
        this.f53388b.dropIdx(getTableName());
    }

    @Override // mm.AbstractC11494p
    public int summary() throws C9721b {
        return this.f53388b.summary(getTableName());
    }
}
