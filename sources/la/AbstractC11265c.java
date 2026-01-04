package la;

import com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.Chunking;
import com.huawei.android.hicloud.drive.clouddisk.model.DeltaFragment;
import com.huawei.android.hicloud.drive.clouddisk.model.Digest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p514o9.C11839m;

/* renamed from: la.c */
/* loaded from: classes3.dex */
public abstract class AbstractC11265c implements Chunking {

    /* renamed from: la.c$a */
    public static class a {

        /* renamed from: a */
        public int f52881a;

        /* renamed from: b */
        public int f52882b;

        /* renamed from: d */
        public MessageDigest f52884d;

        /* renamed from: e */
        public b f52885e;

        /* renamed from: c */
        public List<DeltaFragment> f52883c = new ArrayList();

        /* renamed from: f */
        public long f52886f = 0;

        /* renamed from: g */
        public long f52887g = 0;

        public a(int i10, int i11, b bVar) throws NoSuchAlgorithmException {
            this.f52881a = i10;
            this.f52882b = i11;
            m67610b(bVar, "SHA-256");
        }

        /* renamed from: a */
        public Digest m67609a() {
            if (this.f52887g > 0) {
                this.f52883c.add(new DeltaFragment(this.f52886f, this.f52887g, this.f52884d.digest()));
                m67613e();
            }
            Digest digest = new Digest(this.f52881a, this.f52882b, this.f52883c);
            m67611c();
            C11839m.m70688i("Rolling", "fragment size: " + digest.getFragments().size());
            return digest;
        }

        /* renamed from: b */
        public final void m67610b(b bVar, String str) throws NoSuchAlgorithmException {
            this.f52884d = MessageDigest.getInstance(str);
            this.f52885e = bVar;
            this.f52886f = 0L;
            this.f52887g = 0L;
        }

        /* renamed from: c */
        public void m67611c() {
            this.f52883c = new ArrayList();
            this.f52884d.reset();
            this.f52885e.reset();
            this.f52886f = 0L;
            this.f52887g = 0L;
        }

        /* renamed from: d */
        public void m67612d(byte[] bArr, int i10, int i11) {
            Objects.requireNonNull(bArr);
            int iMo67606a = this.f52885e.mo67606a(bArr, i10, i11);
            if (iMo67606a < 0) {
                this.f52887g += i11;
                this.f52884d.update(bArr, i10, i11);
                return;
            }
            this.f52887g += iMo67606a;
            this.f52884d.update(bArr, i10, iMo67606a);
            this.f52883c.add(new DeltaFragment(this.f52886f, this.f52887g, this.f52884d.digest()));
            m67613e();
            if (iMo67606a == 0) {
                throw new IllegalArgumentException();
            }
            if (iMo67606a < i11) {
                m67612d(bArr, i10 + iMo67606a, i11 - iMo67606a);
            }
        }

        /* renamed from: e */
        public final void m67613e() {
            this.f52885e.reset();
            this.f52884d.reset();
            this.f52886f += this.f52887g;
            this.f52887g = 0L;
        }
    }

    /* renamed from: la.c$b */
    public interface b {
        /* renamed from: a */
        int mo67606a(byte[] bArr, int i10, int i11);

        void reset();
    }

    @Override // com.huawei.android.hicloud.drive.clouddisk.asset.deltasync.chunk.Chunking
    /* renamed from: b */
    public Digest mo16344b(Digest digest, File file) throws NoSuchAlgorithmException, IOException {
        C11839m.m70688i("Rolling", "chunking tag: " + mo16343a() + ", blockSize: " + digest.getBlockSize());
        return m67608c(file, digest.getBlockSize(), this);
    }

    /* renamed from: c */
    public final Digest m67608c(File file, int i10, AbstractC11265c abstractC11265c) throws NoSuchAlgorithmException, IOException {
        a aVar = new a(abstractC11265c.mo16343a(), i10, abstractC11265c.mo67605d(i10));
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        while (true) {
            try {
                int i11 = bufferedInputStream.read(bArr);
                if (i11 < 0) {
                    bufferedInputStream.close();
                    return aVar.m67609a();
                }
                if (i11 != 0) {
                    aVar.m67612d(bArr, 0, i11);
                }
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public abstract b mo67605d(int i10);
}
