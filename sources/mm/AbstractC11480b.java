package mm;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoForUploadOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import fk.C9721b;

/* renamed from: mm.b */
/* loaded from: classes6.dex */
public abstract class AbstractC11480b extends AbstractC11494p<PmsMetaV3> {

    /* renamed from: a */
    public String f53385a;

    /* renamed from: b */
    public PmsFullBriefFilesInfoForUploadOperatorV3 f53386b;

    public AbstractC11480b(String str, PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3) {
        this.f53385a = str;
        this.f53386b = pmsFullBriefFilesInfoForUploadOperatorV3;
    }

    /* renamed from: a */
    public abstract void mo68639a(String str, PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3) throws C9721b;

    @Override // mm.AbstractC11494p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PmsMetaV3 query(int i10) throws C9721b {
        return this.f53386b.query(PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3, getTableName(), i10);
    }

    @Override // mm.AbstractC11494p
    public void create() throws C9721b {
        mo68639a(this.f53385a, this.f53386b);
    }

    @Override // mm.AbstractC11494p
    public void drop() throws C9721b {
        this.f53386b.dropIdx(getTableName());
    }

    @Override // mm.AbstractC11494p
    public int summary() throws C9721b {
        return this.f53386b.summary(getTableName());
    }
}
