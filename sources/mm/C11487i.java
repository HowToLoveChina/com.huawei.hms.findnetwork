package mm;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoForUploadOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import fk.C9721b;
import java.util.Locale;

/* renamed from: mm.i */
/* loaded from: classes6.dex */
public class C11487i extends AbstractC11480b {

    /* renamed from: c */
    public final String f53392c;

    public C11487i(String str, String str2, PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3) {
        super(str2, pmsFullBriefFilesInfoForUploadOperatorV3);
        this.f53392c = str;
    }

    @Override // mm.AbstractC11480b
    /* renamed from: a */
    public void mo68639a(String str, PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3) throws C9721b {
        pmsFullBriefFilesInfoForUploadOperatorV3.build(getTableName(), String.format(Locale.ENGLISH, "select id from %s where file_id = ? order by id;", PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3), new String[]{this.f53392c});
    }
}
