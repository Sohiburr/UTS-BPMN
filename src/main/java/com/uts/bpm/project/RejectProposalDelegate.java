package com.uts.bpm.project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("rejectProposalDelegate")
public class RejectProposalDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String namaKegiatan = (String) execution.getVariable("namaKegiatan");
        String alasanPenolakan = (String) execution.getVariable("alasanPenolakan");
        
        System.out.println("=========================================");
        System.out.println("STATUS PROPOSAL: DITOLAK / REVISI");
        System.out.println("Kegiatan: " + namaKegiatan);
        System.out.println("Alasan: " + alasanPenolakan);
        System.out.println("Proposal dikembalikan ke divisi Sosmas untuk direvisi.");
        System.out.println("=========================================");
    }
}