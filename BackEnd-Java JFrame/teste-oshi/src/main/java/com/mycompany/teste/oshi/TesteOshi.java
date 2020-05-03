/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste.oshi;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author rafae
 */
public class TesteOshi {
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    
    GlobalMemory ram = hal.getMemory();
    //CentralProcessor cpu = hal.getProcessor();
    
   // private Long cpuTotal = cpu.getMaxFreq();

    //public Double getCpuTotal() {
       // return cpuTotal / Math.pow(10,9);
    //}
    
    private long[] oldTicks;

    private double cpuData(CentralProcessor proc) {
        double d = proc.getSystemCpuLoadBetweenTicks(oldTicks);
        oldTicks = proc.getSystemCpuLoadTicks();
        return d;
    }   
    
    private Long memoriaTotal = ram.getTotal();
    private Long memoriaEmUso = memoriaTotal - ram.getAvailable();
    private Double porcentagemAtual = (memoriaEmUso * 100.0)/memoriaTotal;
    
    
    public Double getMemoriaTotal() {
        return (memoriaTotal / Math.pow(10,9)) - 0.5;
    }

    public Double getMemoriaEmUso() {
        return (memoriaEmUso / Math.pow(10,9)) - 0.5;
    }

    public Double getPorcentagemAtual() {
        return porcentagemAtual;
    }
    
    public void mostrar(){
        System.out.println(String.format("%.2f", memoriaTotal / Math.pow(10,9)));
    }

}
