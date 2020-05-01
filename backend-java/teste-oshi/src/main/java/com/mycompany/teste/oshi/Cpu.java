/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste.oshi;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

/**
 *
 * @author reis
 */
public class Cpu {
    
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    
    CentralProcessor cpu = hal.getProcessor();
    
    private Long cpuTotal = cpu.getMaxFreq();

    //public Double getCpuTotal() {
       // return cpuTotal / Math.pow(10,9);
    //}
    
    
    private long[] oldTicks;

    private double cpuData(CentralProcessor proc) {
        double d = proc.getSystemCpuLoadBetweenTicks(oldTicks);
        oldTicks = proc.getSystemCpuLoadTicks();
        return d;
    }   
    
}
