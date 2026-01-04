package com.huawei.hms.support.api.tss;

import com.huawei.hmf.tasks.Task;
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

/* loaded from: classes8.dex */
public interface TssClient {
    Task<DataExportResp> dataExport(DataExportRequ dataExportRequ);

    Task<DataImportResp> dataImport(DataImportRequ dataImportRequ);

    Task<DecryptDataResp> decryptData(DecryptDataRequ decryptDataRequ);

    Task<DecryptKekResp> decryptKek(DecryptKekRequ decryptKekRequ);

    Task<EcdhResp> ecdh(EcdhRequ ecdhRequ);

    Task<EcdhForKdResp> ecdhForKd(EcdhForKdRequ ecdhForKdRequ);

    Task<EncryptDataResp> encryptData(EncryptDataRequ encryptDataRequ);

    Task<EnrollCertResp> enrollCert(EnrollCertRequ enrollCertRequ);

    Task<GenerateKeyResp> generateKey(GenerateKeyRequ generateKeyRequ);

    Task<GetAttestCertChainResp> getAttestCertChain(GetAttestCertChainRequ getAttestCertChainRequ);

    Task<GetCertificationKeyResp> getCertificationKey(GetCertificationKeyRequ getCertificationKeyRequ);

    Task<GetCertifiedCredentialResp> getCertifiedCredential(GetCertifiedCredentialRequ getCertifiedCredentialRequ);

    Task<GetDeviceIdResp> getDeviceId(GetDeviceIdRequ getDeviceIdRequ);

    Task<GetHuksTaAvailableResp> getHuksTaAvaliable(GetHuksTaAvailableRequ getHuksTaAvailableRequ);

    Task<GetKeyInfoResp> getKeyInfo(GetKeyInfoRequ getKeyInfoRequ);

    Task<GetKeyVersionResp> getKeyVersion(GetKeyVersionRequ getKeyVersionRequ);

    Task<GetPublicKeyResp> getPublicKey(GetPublicKeyRequ getPublicKeyRequ);

    Task<GetServiceCertChainResp> getServiceCertChain(GetServiceCertChainRequ getServiceCertChainRequ);

    Task<GetTaVersionResp> getTaVersion(GetTaVersionRequ getTaVersionRequ);

    Task<HasKeyResp> hasKey(HasKeyRequ hasKeyRequ);

    Task<KeyDerivationResp> keyDerivation(KeyDerivationRequ keyDerivationRequ);

    Task<KeyExportResp> keyExport(KeyExportRequ keyExportRequ);

    Task<KeyImportResp> keyImport(KeyImportRequ keyImportRequ);

    Task<RemoveKeyResp> removeKey(RemoveKeyRequ removeKeyRequ);

    Task<SignDataResp> signData(SignDataRequ signDataRequ);

    Task<SupportKmsResp> supportKms(SupportKmsRequ supportKmsRequ);

    Task<SupportMkResp> supportMk(SupportMkRequ supportMkRequ);

    Task<SysIntegrityResp> sysIntegrity(SysIntegrityRequ sysIntegrityRequ);

    Task<TransformEncryptDataResp> transformEncryptData(TransformEncryptDataRequ transformEncryptDataRequ);

    Task<UpdateKeyComponentResp> updateKeyComponent(UpdateKeyComponentRequ updateKeyComponentRequ);

    Task<VerifySignatureResp> verifySignature(VerifySignatureRequ verifySignatureRequ);
}
