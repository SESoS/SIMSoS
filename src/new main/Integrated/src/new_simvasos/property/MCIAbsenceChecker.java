package new_simvasos.property;

import new_simvasos.log.Log;
import new_simvasos.log.Snapshot;
import new_simvasos.property.pattern.AbsenceChecker;

import java.util.StringTokenizer;

public class MCIAbsenceChecker extends AbsenceChecker {
    
    
    public boolean evaluateState(Snapshot snapshot, Property verificationProperty) {
        StringTokenizer st = new StringTokenizer(snapshot.getSnapshotString(), " ");
        while(st.hasMoreTokens()) {
            if(st.nextToken().equals("RescuedRate:"))
                break;
        }
    
        double rescueRate = Double.parseDouble(st.nextToken());
    
        if(rescueRate > verificationProperty.getValue()){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public boolean check(Log log, Property verificationProperty, int until) {
        return false;
    }
    
    @Override
    public boolean check(Log log, Property verificationProperty, double prob, int T) {
        return false;
    }
    
    @Override
    public boolean check(Log log, Property verificationProperty, double prob, int t, int T) {
        return false;
    }
    
    @Override
    public boolean check(Log log, Property verificationProperty, int t, int T) {
        return false;
    }

    @Override
    public boolean check(String fileName, String time, String vehicleNum, String distance) {
        return false;
    }
}
