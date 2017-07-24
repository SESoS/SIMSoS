package simsos.scenario.mci;

import org.apache.commons.math3.distribution.NormalDistribution;
import simsos.simulation.component.Action;
import simsos.simulation.component.World;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mgjin on 2017-06-28.
 */
public class MCIWorld extends World {
    public static final Pair<Integer, Integer> MAP_SIZE = new Pair<Integer, Integer>(19, 19);

    private int[] patientRaisePlan;
    private int patientNumbering = 0;

    public MCIWorld(int nPatient) {
        ArrayList<Integer> raiseTime = new ArrayList<>();
        NormalDistribution nd = new NormalDistribution(1, 1); // 30, 15

        for(int i=0; i< nPatient; i++)
            raiseTime.add(new Double(nd.sample()).intValue());

        Collections.sort(raiseTime);
        for(int i =0; i< raiseTime.size(); i++)
            if (raiseTime.get(i) < 0)
                raiseTime.set(i, 0);

        this.patientRaisePlan = raiseTime.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public void reset() {
        super.reset();

        this.patientNumbering = 0;
        this.agents.removeIf(a -> a instanceof Patient);
    }

    @Override
    public ArrayList<Action> generateExogenousActions() {
        ArrayList<Action> patients = new ArrayList<Action>();
        World world = this;

        for (int raiseTime : patientRaisePlan)
            if (raiseTime == this.time)
                patients.add(new Action(0) {

                    @Override
                    public void execute() {
                        patientNumbering++;
                        Patient p = new Patient(world, "Patient" + patientNumbering);
                        agents.add(p);
                    }

                    @Override
                    public String getName() {
                        return "World: Generate a Patient";
                    }
                });

        return patients;
    }
}