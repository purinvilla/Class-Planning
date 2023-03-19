package com.patricksak.classesPlanning;

import java.util.ArrayList;

public class ClassSchedule {

    final int TOTALDAYS = 7;
    final int MINUTES = 5;
    final int TOTALHOURS = 24;

    ArrayList<Integer> timeSlots[][] = new ArrayList[TOTALDAYS][TOTALHOURS * 60/MINUTES];

    /*
    return
    - true = add class.
    - false = class existed.
     */
    public boolean addClass(int day, int slot, int classID) {
        if (timeSlots[day][slot] == null)
            timeSlots[day][slot] = new ArrayList<Integer>();

        boolean classExist = false;
        for(int v : timeSlots[day][slot])
            if (v == classID)
                classExist = true;

        if (!classExist) {
            timeSlots[day][slot].add(classID);
            return true;
        }

        return false;
    }

    public void generateClassScheduleText(int startTimeSlot,int endTimeSlot) {
        System.out.format("%5s|%15s|%15s|%15s|%15s|%15s|%15s|%15s|\n", "Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        for(int i = startTimeSlot; i < endTimeSlot; i++) {
            System.out.print(Subject.slotToTime(i) + "|");
            for(int d = 0; d < 7; d++) {
                if(this.timeSlots[d][i] != null) {
                    StringBuffer line = new StringBuffer();
                    for(int s = 0; s < this.timeSlots[d][i].size(); s++) {
                        if (s > 0)
                            line.append("+");
                        line.append(this.timeSlots[d][i].get(s));
                    }
                    System.out.format("%15s|",line);
                } else
                    System.out.print(" ".repeat(15) + "|");
            }
            System.out.println();
        }
    }

}
