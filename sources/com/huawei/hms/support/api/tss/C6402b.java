package com.huawei.hms.support.api.tss;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.entity.tss.DataExportRequ;
import com.huawei.hms.support.api.entity.tss.DataExportResp;
import com.huawei.hms.support.api.entity.tss.DataImportRequ;
import com.huawei.hms.support.api.entity.tss.DataImportResp;
import com.huawei.hms.support.api.entity.tss.DecryptDataRequ;
import com.huawei.hms.support.api.entity.tss.DecryptDataResp;
import com.huawei.hms.support.api.entity.tss.DecryptKekRequ;
import com.huawei.hms.support.api.entity.tss.DecryptKekResp;
import com.huawei.hms.support.api.entity.tss.EcdhForKdRequ;
import com.huawei.hms.support.api.entity.tss.EcdhForKdResp;
import com.huawei.hms.support.api.entity.tss.EcdhRequ;
import com.huawei.hms.support.api.entity.tss.EcdhResp;
import com.huawei.hms.support.api.entity.tss.EncryptDataRequ;
import com.huawei.hms.support.api.entity.tss.EncryptDataResp;
import com.huawei.hms.support.api.entity.tss.EnrollCertRequ;
import com.huawei.hms.support.api.entity.tss.EnrollCertResp;
import com.huawei.hms.support.api.entity.tss.GenerateKeyRequ;
import com.huawei.hms.support.api.entity.tss.GenerateKeyResp;
import com.huawei.hms.support.api.entity.tss.GetAttestCertChainRequ;
import com.huawei.hms.support.api.entity.tss.GetAttestCertChainResp;
import com.huawei.hms.support.api.entity.tss.GetCertificationKeyRequ;
import com.huawei.hms.support.api.entity.tss.GetCertificationKeyResp;
import com.huawei.hms.support.api.entity.tss.GetCertifiedCredentialRequ;
import com.huawei.hms.support.api.entity.tss.GetCertifiedCredentialResp;
import com.huawei.hms.support.api.entity.tss.GetDeviceIdRequ;
import com.huawei.hms.support.api.entity.tss.GetDeviceIdResp;
import com.huawei.hms.support.api.entity.tss.GetHuksTaAvailableRequ;
import com.huawei.hms.support.api.entity.tss.GetHuksTaAvailableResp;
import com.huawei.hms.support.api.entity.tss.GetKeyInfoRequ;
import com.huawei.hms.support.api.entity.tss.GetKeyInfoResp;
import com.huawei.hms.support.api.entity.tss.GetKeyVersionRequ;
import com.huawei.hms.support.api.entity.tss.GetKeyVersionResp;
import com.huawei.hms.support.api.entity.tss.GetPublicKeyRequ;
import com.huawei.hms.support.api.entity.tss.GetPublicKeyResp;
import com.huawei.hms.support.api.entity.tss.GetServiceCertChainRequ;
import com.huawei.hms.support.api.entity.tss.GetServiceCertChainResp;
import com.huawei.hms.support.api.entity.tss.GetTaVersionRequ;
import com.huawei.hms.support.api.entity.tss.GetTaVersionResp;
import com.huawei.hms.support.api.entity.tss.HasKeyRequ;
import com.huawei.hms.support.api.entity.tss.HasKeyResp;
import com.huawei.hms.support.api.entity.tss.KeyDerivationRequ;
import com.huawei.hms.support.api.entity.tss.KeyDerivationResp;
import com.huawei.hms.support.api.entity.tss.KeyExportRequ;
import com.huawei.hms.support.api.entity.tss.KeyExportResp;
import com.huawei.hms.support.api.entity.tss.KeyImportRequ;
import com.huawei.hms.support.api.entity.tss.KeyImportResp;
import com.huawei.hms.support.api.entity.tss.RemoveKeyRequ;
import com.huawei.hms.support.api.entity.tss.RemoveKeyResp;
import com.huawei.hms.support.api.entity.tss.SignDataRequ;
import com.huawei.hms.support.api.entity.tss.SignDataResp;
import com.huawei.hms.support.api.entity.tss.SupportKmsRequ;
import com.huawei.hms.support.api.entity.tss.SupportKmsResp;
import com.huawei.hms.support.api.entity.tss.SupportMkRequ;
import com.huawei.hms.support.api.entity.tss.SupportMkResp;
import com.huawei.hms.support.api.entity.tss.SysIntegrityRequ;
import com.huawei.hms.support.api.entity.tss.SysIntegrityResp;
import com.huawei.hms.support.api.entity.tss.TransformEncryptDataRequ;
import com.huawei.hms.support.api.entity.tss.TransformEncryptDataResp;
import com.huawei.hms.support.api.entity.tss.UpdateKeyComponentRequ;
import com.huawei.hms.support.api.entity.tss.UpdateKeyComponentResp;
import com.huawei.hms.support.api.entity.tss.VerifySignatureRequ;
import com.huawei.hms.support.api.entity.tss.VerifySignatureResp;
import com.huawei.hms.support.api.tss.callback.C6405a0;
import com.huawei.hms.support.api.tss.callback.C6406b;
import com.huawei.hms.support.api.tss.callback.C6407b0;
import com.huawei.hms.support.api.tss.callback.C6408c;
import com.huawei.hms.support.api.tss.callback.C6409c0;
import com.huawei.hms.support.api.tss.callback.C6410d;
import com.huawei.hms.support.api.tss.callback.C6411d0;
import com.huawei.hms.support.api.tss.callback.C6412e;
import com.huawei.hms.support.api.tss.callback.C6413e0;
import com.huawei.hms.support.api.tss.callback.C6414f;
import com.huawei.hms.support.api.tss.callback.C6415f0;
import com.huawei.hms.support.api.tss.callback.C6416g;
import com.huawei.hms.support.api.tss.callback.C6417g0;
import com.huawei.hms.support.api.tss.callback.C6418h;
import com.huawei.hms.support.api.tss.callback.C6419i;
import com.huawei.hms.support.api.tss.callback.C6420j;
import com.huawei.hms.support.api.tss.callback.C6421k;
import com.huawei.hms.support.api.tss.callback.C6422l;
import com.huawei.hms.support.api.tss.callback.C6423m;
import com.huawei.hms.support.api.tss.callback.C6424n;
import com.huawei.hms.support.api.tss.callback.C6425o;
import com.huawei.hms.support.api.tss.callback.C6426p;
import com.huawei.hms.support.api.tss.callback.C6427q;
import com.huawei.hms.support.api.tss.callback.C6428r;
import com.huawei.hms.support.api.tss.callback.C6429s;
import com.huawei.hms.support.api.tss.callback.C6430t;
import com.huawei.hms.support.api.tss.callback.C6431u;
import com.huawei.hms.support.api.tss.callback.C6432v;
import com.huawei.hms.support.api.tss.callback.C6433w;
import com.huawei.hms.support.api.tss.callback.C6434x;
import com.huawei.hms.support.api.tss.callback.C6436z;
import com.huawei.hms.utils.Checker;

/* renamed from: com.huawei.hms.support.api.tss.b */
/* loaded from: classes8.dex */
public class C6402b extends HuaweiApi<TssOptions> implements TssClient {

    /* renamed from: b */
    public static final C6401a f29957b = new C6401a();

    /* renamed from: c */
    public static final Api<TssOptions> f29958c = new Api<>("HuaweiTss.API");

    /* renamed from: a */
    public String f29959a;

    public C6402b(Context context, String str, TssOptions tssOptions) {
        super(context, f29958c, tssOptions, f29957b);
        this.f29959a = str;
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<DataExportResp> dataExport(DataExportRequ dataExportRequ) {
        Checker.checkNonNull(dataExportRequ);
        return doWrite(new C6406b(getContext(), "tss.dataExport", dataExportRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<DataImportResp> dataImport(DataImportRequ dataImportRequ) {
        Checker.checkNonNull(dataImportRequ);
        return doWrite(new C6408c(getContext(), "tss.dataImport", dataImportRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<DecryptDataResp> decryptData(DecryptDataRequ decryptDataRequ) {
        Checker.checkNonNull(decryptDataRequ);
        return doWrite(new C6410d(getContext(), "tss.decryptData", decryptDataRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<DecryptKekResp> decryptKek(DecryptKekRequ decryptKekRequ) {
        Checker.checkNonNull(decryptKekRequ);
        return doWrite(new C6412e(getContext(), "tss.decryptKEK", decryptKekRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<EcdhResp> ecdh(EcdhRequ ecdhRequ) {
        Checker.checkNonNull(ecdhRequ);
        return doWrite(new C6416g(getContext(), "tss.ecdh", ecdhRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<EcdhForKdResp> ecdhForKd(EcdhForKdRequ ecdhForKdRequ) {
        Checker.checkNonNull(ecdhForKdRequ);
        return doWrite(new C6414f(getContext(), "tss.ecdhForKd", ecdhForKdRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<EncryptDataResp> encryptData(EncryptDataRequ encryptDataRequ) {
        Checker.checkNonNull(encryptDataRequ);
        return doWrite(new C6418h(getContext(), "tss.encryptData", encryptDataRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<EnrollCertResp> enrollCert(EnrollCertRequ enrollCertRequ) {
        Checker.checkNonNull(enrollCertRequ);
        return doWrite(new C6419i(getContext(), "tss.enrollCert", enrollCertRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GenerateKeyResp> generateKey(GenerateKeyRequ generateKeyRequ) {
        Checker.checkNonNull(generateKeyRequ);
        return doWrite(new C6420j(getContext(), "tss.generateKey", generateKeyRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetAttestCertChainResp> getAttestCertChain(GetAttestCertChainRequ getAttestCertChainRequ) {
        Checker.checkNonNull(getAttestCertChainRequ);
        return doWrite(new C6421k(getContext(), "tss.getAttestCertChain", getAttestCertChainRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetCertificationKeyResp> getCertificationKey(GetCertificationKeyRequ getCertificationKeyRequ) {
        Checker.checkNonNull(getCertificationKeyRequ);
        return doWrite(new C6422l(getContext(), "tss.getCertificationKey", getCertificationKeyRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetCertifiedCredentialResp> getCertifiedCredential(GetCertifiedCredentialRequ getCertifiedCredentialRequ) {
        Checker.checkNonNull(getCertifiedCredentialRequ);
        return doWrite(new C6423m(getContext(), "tss.getCertifiedCredential", getCertifiedCredentialRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetDeviceIdResp> getDeviceId(GetDeviceIdRequ getDeviceIdRequ) {
        Checker.checkNonNull(getDeviceIdRequ);
        return doWrite(new C6424n(getContext(), "tss.getVUdid", getDeviceIdRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetHuksTaAvailableResp> getHuksTaAvaliable(GetHuksTaAvailableRequ getHuksTaAvailableRequ) {
        Checker.checkNonNull(getHuksTaAvailableRequ);
        return doWrite(new C6425o(getContext(), "tss.getHuksTaAvaliable", getHuksTaAvailableRequ.toJson(), false));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetKeyInfoResp> getKeyInfo(GetKeyInfoRequ getKeyInfoRequ) {
        Checker.checkNonNull(getKeyInfoRequ);
        return doWrite(new C6426p(getContext(), "tss.getKeyInfo", getKeyInfoRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetKeyVersionResp> getKeyVersion(GetKeyVersionRequ getKeyVersionRequ) {
        Checker.checkNonNull(getKeyVersionRequ);
        return doWrite(new C6427q(getContext(), "tss.getKeyVersion", getKeyVersionRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetPublicKeyResp> getPublicKey(GetPublicKeyRequ getPublicKeyRequ) {
        Checker.checkNonNull(getPublicKeyRequ);
        return doWrite(new C6428r(getContext(), "tss.getPublicKey", getPublicKeyRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetServiceCertChainResp> getServiceCertChain(GetServiceCertChainRequ getServiceCertChainRequ) {
        Checker.checkNonNull(getServiceCertChainRequ);
        return doWrite(new C6429s(getContext(), "tss.getServiceCertChain", getServiceCertChainRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<GetTaVersionResp> getTaVersion(GetTaVersionRequ getTaVersionRequ) {
        Checker.checkNonNull(getTaVersionRequ);
        return doWrite(new C6430t(getContext(), "tss.getTaVersion", getTaVersionRequ.toJson(), false));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<HasKeyResp> hasKey(HasKeyRequ hasKeyRequ) {
        Checker.checkNonNull(hasKeyRequ);
        return doWrite(new C6431u(getContext(), "tss.hasKey", hasKeyRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<KeyDerivationResp> keyDerivation(KeyDerivationRequ keyDerivationRequ) {
        Checker.checkNonNull(keyDerivationRequ);
        return doWrite(new C6432v(getContext(), "tss.keyDerivation", keyDerivationRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<KeyExportResp> keyExport(KeyExportRequ keyExportRequ) {
        Checker.checkNonNull(keyExportRequ);
        return doWrite(new C6433w(getContext(), "tss.keyExport", keyExportRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<KeyImportResp> keyImport(KeyImportRequ keyImportRequ) {
        Checker.checkNonNull(keyImportRequ);
        return doWrite(new C6434x(getContext(), "tss.keyImport", keyImportRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<RemoveKeyResp> removeKey(RemoveKeyRequ removeKeyRequ) {
        Checker.checkNonNull(removeKeyRequ);
        return doWrite(new C6436z(getContext(), "tss.removeKey", removeKeyRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<SignDataResp> signData(SignDataRequ signDataRequ) {
        Checker.checkNonNull(signDataRequ);
        return doWrite(new C6405a0(getContext(), "tss.signData", signDataRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<SupportKmsResp> supportKms(SupportKmsRequ supportKmsRequ) {
        Checker.checkNonNull(supportKmsRequ);
        return doWrite(new C6407b0(getContext(), "tss.supportKms", supportKmsRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<SupportMkResp> supportMk(SupportMkRequ supportMkRequ) {
        Checker.checkNonNull(supportMkRequ);
        return doWrite(new C6409c0(getContext(), "tss.supportMk", supportMkRequ.toJson(this.f29959a), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<SysIntegrityResp> sysIntegrity(SysIntegrityRequ sysIntegrityRequ) {
        Checker.checkNonNull(sysIntegrityRequ);
        return doWrite(new C6411d0(getContext(), "tss.sysIntegrityDetect", sysIntegrityRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<TransformEncryptDataResp> transformEncryptData(TransformEncryptDataRequ transformEncryptDataRequ) {
        Checker.checkNonNull(transformEncryptDataRequ);
        return doWrite(new C6413e0(getContext(), "tss.transformEncryptData", transformEncryptDataRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<UpdateKeyComponentResp> updateKeyComponent(UpdateKeyComponentRequ updateKeyComponentRequ) {
        Checker.checkNonNull(updateKeyComponentRequ);
        return doWrite(new C6415f0(getContext(), "tss.updateKeyComponent", updateKeyComponentRequ.toJson(), true));
    }

    @Override // com.huawei.hms.support.api.tss.TssClient
    public Task<VerifySignatureResp> verifySignature(VerifySignatureRequ verifySignatureRequ) {
        Checker.checkNonNull(verifySignatureRequ);
        return doWrite(new C6417g0(getContext(), "tss.verifySignature", verifySignatureRequ.toJson(), true));
    }

    public C6402b(Activity activity, String str, TssOptions tssOptions) {
        super(activity, f29958c, tssOptions, (AbstractClientBuilder) f29957b);
        this.f29959a = str;
    }
}
