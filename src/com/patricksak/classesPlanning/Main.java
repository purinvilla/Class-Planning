package com.patricksak.classesPlanning;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ClassSchedule cs = new ClassSchedule();

        ArrayList<Subject> allSubjects = new ArrayList<Subject>();

        int startTimeSlot = Integer.MAX_VALUE;
        int endTimeSlot = Integer.MIN_VALUE;

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                switch (i) {
                    case 0:
                        try {
                            BufferedReader reader;
                            reader = new BufferedReader(new FileReader(args[0]));
                            String line = null;
                            while ((line = reader.readLine()) != null) {
                                if (line.charAt(0) != '#') {
                                    System.out.println(line);
                                    Subject subject = new Subject(line);
                                    allSubjects.add(subject);

                                    //Calculate the Start Time and End Time of the whole week
                                    int subjectStartTimeSlot = Subject.timeToSlot(subject.startTime);
                                    if (subjectStartTimeSlot < startTimeSlot)
                                        startTimeSlot = subjectStartTimeSlot;
                                    int subjectEndTimeSlot = Subject.timeToSlot(subject.endTime);
                                    if (subjectEndTimeSlot > endTimeSlot)
                                        endTimeSlot = subjectEndTimeSlot;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }

        //Fill Class Schedule with all subjects
        for (Subject s : allSubjects) {
            System.out.println(s);
            int startTimeSection = s.timeToSlot(s.startTime);
            int endTimeSection = s.timeToSlot(s.endTime);
            for(int d = 0; d < 7; d++) {
                //If there is a class in that day
                if (s.getDays()[d] == 1) {
                    for(int i = startTimeSection; i < endTimeSection; i++) {
                        cs.addClass(d, i, s.getID());
                    }
                }
            }
        }

        cs.generateClassScheduleText(startTimeSlot, endTimeSlot);

    }

}
