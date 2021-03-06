package kr.ac.kaist.se.simulator;

import java.util.HashMap;

/**
 * SIMResult.java

 * Author: Junho Kim <jhkim@se.kaist.ac.kr>

 * The MIT License (MIT)

 * Copyright (c) 2016 Junho Kim

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions: TBD
 */

public class SIMResult {
    /*
     * Simulation SIMResult class
     */

    private int numTicks;
    private int SoSBenefit;
    private HashMap<Integer, DebugTick> debugTraces;

    public SIMResult(int numTicks, int SoSBenefit){
        this.numTicks = numTicks;
        this.SoSBenefit = SoSBenefit;
    }

    public int getNumTicks(){
        return this.numTicks;
    }

    public int getSoSBenefit(){
        return this.SoSBenefit;
    }

    public void setDebugTraces(HashMap<Integer, DebugTick> debugTraces){
        this.debugTraces = debugTraces;
    }

    public HashMap<Integer, DebugTick> getDebugTraces(){
        return this.debugTraces;
    }

}
