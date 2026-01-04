package gr;

import as.C1016d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: gr.d */
/* loaded from: classes8.dex */
public final class C10041d extends AbstractC10038a {

    /* renamed from: f */
    public File f49009f;

    public C10041d(String str) {
        super(str);
        this.f49009f = new File("");
    }

    @Override // gr.AbstractC10038a
    /* renamed from: b */
    public final InputStream mo62432b() {
        if (!this.f49009f.exists()) {
            C1016d.m6183c("UploadRequest", "file not exist");
            return null;
        }
        try {
            return new FileInputStream(this.f49009f);
        } catch (FileNotFoundException unused) {
            C1016d.m6183c("UploadRequest", "file open failed");
            return null;
        }
    }

    /* renamed from: m */
    public final C10041d m62447m(String str) {
        this.f49009f = new File(str);
        return this;
    }
}
