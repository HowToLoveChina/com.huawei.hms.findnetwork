package com.huawei.hms.iap.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.iap.entity.C5634a;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseReq;
import com.huawei.hms.iap.entity.ConsumeOwnedPurchaseResult;
import com.huawei.hms.iapfull.IIapFullAPIVer4;
import com.huawei.hms.iapfull.webpay.callback.WebPayCallback;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class ConsumeOwnedPurchaseTask extends BaseIapFullTask<ConsumeOwnedPurchaseResult, ConsumeOwnedPurchaseReq> {
    public ConsumeOwnedPurchaseTask(Context context, ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq) {
        super(context, consumeOwnedPurchaseReq);
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
    private com.huawei.hms.iapfull.bean.WebConsumeOwnedPurchaseRequest m33004a(
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

    @Override // com.huawei.hms.iap.task.BaseIapFullTask
    public void handleRequest(ConsumeOwnedPurchaseReq consumeOwnedPurchaseReq, IIapFullAPIVer4 iIapFullAPIVer4) {
        iIapFullAPIVer4.consumeOwnedPurchase(m33004a(consumeOwnedPurchaseReq), new WebPayCallback() { // from class: com.huawei.hms.iap.task.ConsumeOwnedPurchaseTask.1
            public void onFailure(int i10, String str) {
                ConsumeOwnedPurchaseTask.this.handleRequestFailed(i10, str);
            }

            public void onSuccess(String str) {
                C5634a c5634a = new C5634a();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JsonUtil.jsonToEntity(str, c5634a);
                    } catch (IllegalArgumentException e10) {
                        HMSLog.m36986e("ConsumeOwnedPurchaseTask", "ConsumeOwnedPurchaseResp jsonToEntity " + e10.getMessage());
                    }
                }
                ConsumeOwnedPurchaseTask.this.mResult = new ConsumeOwnedPurchaseResult();
                ((ConsumeOwnedPurchaseResult) ConsumeOwnedPurchaseTask.this.mResult).setReturnCode(c5634a.getReturnCode());
                ((ConsumeOwnedPurchaseResult) ConsumeOwnedPurchaseTask.this.mResult).setErrMsg(c5634a.getErrMsg());
                ((ConsumeOwnedPurchaseResult) ConsumeOwnedPurchaseTask.this.mResult).setStatus(c5634a.getCommonStatus());
                ((ConsumeOwnedPurchaseResult) ConsumeOwnedPurchaseTask.this.mResult).setConsumePurchaseData(c5634a.getConsumePurchaseData());
                ((ConsumeOwnedPurchaseResult) ConsumeOwnedPurchaseTask.this.mResult).setDataSignature(c5634a.getDataSignature());
                ((ConsumeOwnedPurchaseResult) ConsumeOwnedPurchaseTask.this.mResult).setSignatureAlgorithm(c5634a.getSignatureAlgorithm());
                ConsumeOwnedPurchaseTask.this.handleRequestSuccess();
            }
        });
    }

    @Override // com.huawei.hms.iap.task.BaseIapFullTask
    public void setResult() {
        this.mResult = new ConsumeOwnedPurchaseResult();
    }
}
