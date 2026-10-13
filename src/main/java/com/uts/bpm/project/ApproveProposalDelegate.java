package com.uts.bpm.project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("approveProposalDelegate")
public class ApproveProposalDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String namaKegiatan = (String) execution.getVariable("namaKegiatan");
        
        System.out.println("=========================================");
        System.out.println("STATUS PROPOSAL: DISETUJUI");
        System.out.println("Kegiatan: " + namaKegiatan);
        System.out.println("Ketua HIMTI telah menyetujui pelaksanaan acara ini.");
        System.out.println("Sistem secara otomatis mengirim notifikasi ke panitia pelaksana.");
        System.out.println("=========================================");
    }
}