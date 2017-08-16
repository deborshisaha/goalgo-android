package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RestoreIPAddress {

    ArrayList<String> result = new ArrayList<String>();
    
    public ArrayList<String> getResult() {
        return result;
    }
    
    public static void driver() {
        RestoreIPAddress restoreIP = new RestoreIPAddress();
        //List<String> result = 
        //restoreIP.restore("101023310");
        restoreIP.restore("101023310");
        System.out.println("Possible IPs");
        for(String s: restoreIP.getResult()) {
            System.out.println(s);
        }
    }

    public void restore(String s) {
        HashMap<Integer, String> subnets = new HashMap();
        x(subnets, 0, 0, s);
    }

    public boolean x(HashMap<Integer, String> subnets, int startIdx, int currentSubnetNum, String ips) {

        int endIdx = ((currentSubnetNum == 3)?ips.length():(startIdx+1));
        
        for ( ; endIdx <= Math.min((startIdx+3),ips.length()); endIdx++) {

            String substring = ips.substring(startIdx, endIdx);
            
            if (substring.length()==0) {continue;/*Try with next endIdx*/}
            
            Integer value = Integer.valueOf(substring);

            if (value <= 255 && value >= 0) {
                // value of makes sure that 023 is stored
                subnets.put(currentSubnetNum, String.valueOf(value));

                if (currentSubnetNum == 3) {
                    putInBucket(subnets);
                }
                
                int nextSubnet = currentSubnetNum + 1;
                
                if (endIdx!=ips.length() && nextSubnet!=4 && !x(subnets, endIdx, nextSubnet, ips)) {
                    // undo what I did before
                    subnets.put(currentSubnetNum, null);
                }
            }
        }

        return endIdx == ips.length();
    }

    private void putInBucket(HashMap<Integer, String> subnets) {
        StringBuilder sb = new StringBuilder();
        //System.out.println();
        for (int k = 0; k < 4; k++) {

            sb.append(subnets.get(k));
            if (k != 3) {
                sb.append(".");
            }
        }
        //System.out.println();
        result.add(sb.toString());
    }
}
