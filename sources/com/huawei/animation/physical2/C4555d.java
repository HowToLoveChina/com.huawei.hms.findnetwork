package com.huawei.animation.physical2;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.animation.physical2.d */
/* loaded from: classes4.dex */
public class C4555d extends AbstractC4560i<AbstractC4561j> {

    /* renamed from: b */
    public int f20917b = 0;

    /* renamed from: c */
    public List<AbstractC4561j> f20918c = new ArrayList();

    @Override // com.huawei.animation.physical2.AbstractC4560i
    /* renamed from: a */
    public AbstractC4561j mo27977a() {
        return mo27979c(m27982h());
    }

    @Override // com.huawei.animation.physical2.AbstractC4560i
    /* renamed from: b */
    public AbstractC4561j mo27978b(AbstractC4561j abstractC4561j) {
        if (abstractC4561j == null) {
            return null;
        }
        return mo27979c(abstractC4561j.getIndex() + 1);
    }

    @Override // com.huawei.animation.physical2.AbstractC4560i
    /* renamed from: c */
    public AbstractC4561j mo27979c(int i10) {
        if (m27983i(i10)) {
            return this.f20918c.get(i10);
        }
        return null;
    }

    @Override // com.huawei.animation.physical2.AbstractC4560i
    /* renamed from: d */
    public int mo27980d() {
        return this.f20918c.size();
    }

    /* renamed from: g */
    public void m27981g(AbstractC4561j abstractC4561j) {
        this.f20918c.add(abstractC4561j);
        m28021e(abstractC4561j);
    }

    /* renamed from: h */
    public int m27982h() {
        return this.f20917b;
    }

    /* renamed from: i */
    public boolean m27983i(int i10) {
        return i10 < this.f20918c.size() && i10 >= 0;
    }

    /* renamed from: j */
    public void m27984j(int i10) {
        if (i10 >= 0) {
            m27985k(i10);
            return;
        }
        for (int size = this.f20918c.size() - 1; size >= 0; size--) {
            int i11 = size + i10;
            AbstractC4561j abstractC4561j = i11 < 0 ? this.f20918c.get(0) : this.f20918c.get(i11);
            AbstractC4561j abstractC4561j2 = this.f20918c.get(size);
            if (!(abstractC4561j instanceof AbstractC4557f) || !(abstractC4561j2 instanceof AbstractC4557f)) {
                return;
            }
            m27987m(abstractC4561j2, abstractC4561j);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    /* renamed from: k */
    public final void m27985k(int r5) {
        /*
            r4 = this;
            r0 = 0
        L1:
            java.util.List<com.huawei.animation.physical2.j> r1 = r4.f20918c
            int r1 = r1.size()
            if (r0 >= r1) goto L3f
            int r1 = r0 + r5
            java.util.List<com.huawei.animation.physical2.j> r2 = r4.f20918c
            int r2 = r2.size()
            if (r1 < r2) goto L22
            java.util.List<com.huawei.animation.physical2.j> r1 = r4.f20918c
            int r2 = r1.size()
            int r2 = r2 + (-1)
            java.lang.Object r1 = r1.get(r2)
        L1f:
            com.huawei.animation.physical2.j r1 = (com.huawei.animation.physical2.AbstractC4561j) r1
            goto L29
        L22:
            java.util.List<com.huawei.animation.physical2.j> r2 = r4.f20918c
            java.lang.Object r1 = r2.get(r1)
            goto L1f
        L29:
            java.util.List<com.huawei.animation.physical2.j> r2 = r4.f20918c
            java.lang.Object r2 = r2.get(r0)
            com.huawei.animation.physical2.j r2 = (com.huawei.animation.physical2.AbstractC4561j) r2
            boolean r3 = r1 instanceof com.huawei.animation.physical2.AbstractC4557f
            if (r3 == 0) goto L3f
            boolean r3 = r2 instanceof com.huawei.animation.physical2.AbstractC4557f
            if (r3 == 0) goto L3f
            r4.m27987m(r2, r1)
            int r0 = r0 + 1
            goto L1
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.animation.physical2.C4555d.m27985k(int):void");
    }

    /* renamed from: l */
    public void m27986l(int i10) {
        if (m27983i(i10)) {
            this.f20917b = i10;
        }
    }

    /* renamed from: m */
    public final void m27987m(AbstractC4561j abstractC4561j, AbstractC4561j abstractC4561j2) {
        AbstractC4557f abstractC4557f = (AbstractC4557f) abstractC4561j;
        AbstractC4557f abstractC4557f2 = (AbstractC4557f) abstractC4561j2;
        if (abstractC4561j.getIndex() == m27982h()) {
            abstractC4557f.resetNode(abstractC4557f2.getValue(), 0.0f);
        } else {
            abstractC4557f.resetNode(abstractC4557f2.getValue(), abstractC4557f2.getVelocity());
        }
    }
}
