package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C6160y1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.huawei.hms.network.embedded.t1 */
/* loaded from: classes8.dex */
public class C6095t1 extends InputStream {

    /* renamed from: h */
    public static final String f28314h = "DecryptInputStream";

    /* renamed from: i */
    public static final int f28315i = 28;

    /* renamed from: j */
    public static final int f28316j = 8220;

    /* renamed from: a */
    public InputStream f28317a;

    /* renamed from: b */
    public C5842a f28318b;

    /* renamed from: c */
    public String f28319c;

    /* renamed from: d */
    public int f28320d;

    /* renamed from: e */
    public int f28321e;

    /* renamed from: f */
    public byte[] f28322f = new byte[8192];

    /* renamed from: g */
    public byte[] f28323g = new byte[f28316j];

    public C6095t1(C5842a c5842a, String str, InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("delegrate == null");
        }
        this.f28317a = inputStream;
        this.f28318b = c5842a;
        this.f28319c = str;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* renamed from: a */
    private java.io.IOException m35381a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:311)
        */

    /* renamed from: s */
    private void m35383s() throws IOException {
        int i10 = this.f28317a.read(this.f28323g);
        if (i10 == -1) {
            this.f28320d = 0;
        } else {
            m35382a(i10, this.f28323g);
            this.f28320d = this.f28322f.length;
        }
        this.f28321e = 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28317a.close();
    }

    public boolean isDecryptable() {
        try {
            m35383s();
            return true;
        } catch (IOException unused) {
            Logger.m32145w(f28314h, "Decrypt failed");
            return false;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return 0;
    }

    /* renamed from: a */
    private void m35382a(int i10, byte[] bArr) throws IOException {
        if (i10 != 8220) {
            bArr = Arrays.copyOfRange(bArr, 0, i10);
        }
        try {
            this.f28322f = C6160y1.decryptBody(bArr);
        } catch (C6160y1.a e10) {
            Logger.m32145w(f28314h, "Decrypt body failed, the requested cache files are deleted");
            this.f28318b.m33699d(this.f28319c);
            close();
            throw m35381a(e10);
        } catch (C6160y1.b e11) {
            Logger.m32145w(f28314h, "WorkKey is invalid, all requested cache files are deleted");
            this.f28318b.m33701s();
            close();
            throw m35381a(e11);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int length = this.f28320d - this.f28321e;
        if (length <= 0) {
            m35383s();
            if (bArr.length > 8192) {
                byte[] bArr2 = this.f28322f;
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                return this.f28322f.length;
            }
            length = this.f28320d - this.f28321e;
            if (length <= 0) {
                return -1;
            }
        }
        if (length >= bArr.length) {
            length = bArr.length;
        }
        System.arraycopy(this.f28322f, this.f28321e, bArr, 0, length);
        this.f28321e += length;
        return length;
    }
}
