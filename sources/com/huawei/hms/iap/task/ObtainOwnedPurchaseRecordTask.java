package com.huawei.hms.iap.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.iap.entity.C5637d;
import com.huawei.hms.iap.entity.OwnedPurchasesReq;
import com.huawei.hms.iap.entity.OwnedPurchasesResult;
import com.huawei.hms.iapfull.IIapFullAPIVer4;
import com.huawei.hms.iapfull.webpay.callback.WebPayCallback;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: classes8.dex */
public class ObtainOwnedPurchaseRecordTask extends BaseIapFullTask<OwnedPurchasesResult, OwnedPurchasesReq> {
    public ObtainOwnedPurchaseRecordTask(Context context, OwnedPurchasesReq ownedPurchasesReq) {
        super(context, ownedPurchasesReq);
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
    public com.huawei.hms.iapfull.bean.WebOwnedPurchasesRequest createRequest(
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
    public void handleRequest(OwnedPurchasesReq ownedPurchasesReq, IIapFullAPIVer4 iIapFullAPIVer4) {
        iIapFullAPIVer4.obtainOwnedPurchaseRecord(createRequest(ownedPurchasesReq), new WebPayCallback() { // from class: com.huawei.hms.iap.task.ObtainOwnedPurchaseRecordTask.1
            public void onFailure(int i10, String str) {
                ObtainOwnedPurchaseRecordTask.this.handleRequestFailed(i10, str);
            }

            public void onSuccess(String str) {
                C5637d c5637d = new C5637d();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JsonUtil.jsonToEntity(str, c5637d);
                    } catch (IllegalArgumentException e10) {
                        HMSLog.m36986e("ObtainOwnedPurchaseRecordTask", "OwnedPurchasesResp jsonToEntity " + e10.getMessage());
                    }
                }
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setReturnCode(c5637d.getReturnCode());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setErrMsg(c5637d.getErrMsg());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setStatus(c5637d.getCommonStatus());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setContinuationToken(c5637d.getContinuationToken());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setInAppPurchaseDataList(c5637d.getInAppPurchaseDataList());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setInAppSignature(c5637d.getInAppSignatureList());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setItemList(c5637d.getItemList());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setPlacedInappPurchaseDataList(c5637d.getPlacedInappPurchaseDataList());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setPlacedInappSignatureList(c5637d.getPlacedInappSignatureList());
                ((OwnedPurchasesResult) ObtainOwnedPurchaseRecordTask.this.mResult).setSignatureAlgorithm(c5637d.getSignatureAlgorithm());
                ObtainOwnedPurchaseRecordTask.this.handleRequestSuccess();
            }
        });
    }

    @Override // com.huawei.hms.iap.task.BaseIapFullTask
    public void setResult() {
        this.mResult = new OwnedPurchasesResult();
    }
}
