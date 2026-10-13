package com.uts.bpm.project;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BpmProjectApplication implements CommandLineRunner {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(String[] args) {
        SpringApplication.run(BpmProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String processKey = "Process_ApprovalProposal"; 

        System.out.println("\n--- Memulai Proses BPMN HIMTI ---");

        Map<String, Object> variablesSetuju = new HashMap<>();
        variablesSetuju.put("namaKegiatan", "HIMTI Peduli X MELATI 2026 - INFORMA-AKSI di Desa Sipayung");
        variablesSetuju.put("isApproved", true); 
        
        runtimeService.startProcessInstanceByKey(processKey, variablesSetuju);

        System.out.println("\n--- Memulai Simulasi Kedua ---");
        Map<String, Object> variablesTolak = new HashMap<>();
        variablesTolak.put("namaKegiatan", "HIMTI Peduli X MELATI 2026 - INFORMA-AKSI di Desa Sipayung");
        variablesTolak.put("isApproved", false); 
        variablesTolak.put("alasanPenolakan", "Anggaran transportasi ke Lebak, Banten terlalu besar, harap direvisi.");

        runtimeService.startProcessInstanceByKey(processKey, variablesTolak);
    }
}