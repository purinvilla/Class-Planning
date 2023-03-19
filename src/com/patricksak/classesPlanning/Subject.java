package com.patricksak.classesPlanning;

public class Subject {

    int id = 0;
    String name = "";
    String startTime = "";
    String endTime = "";
    private int[] days = new int[7];

    static int timeToSlot(String timeString) {
        String time[] = timeString.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 12 + minute / 5;
    }

    static String slotToTime(int slot) {
        int hour = slot / 12;
        if (hour > 12) {
            hour -= 12;
        }
        int minute = slot % 12 * 5;
        return String.format("%02d:%02d", hour, minute) ;
    }

    public Subject() {
    }

    public Subject(String line) {
        String sl[] = line.split(";");
        for(int i = 0; i < sl.length; i++) {
            switch(i) {
                case 0:
                    id = Integer.parseInt(sl[0]);
                    break;
                case 1:
                    name = sl[1];
                    break;
                case 2:
                    startTime = sl[2];
                    break;
                case 3:
                    endTime = sl[3];
                    break;
                case 4:
                    setDays(sl[4]);
                    break;
            }
        }
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int[] getDays() {
        return days;
    }

    public void setDays(String days) {
        String[] whichDay = days.split(":");
        for(String day:whichDay)
        {
            switch(day) {
                case "m":
                    this.days[0] = 1;
                    break;
                case "t":
                    this.days[1] = 1;
                    break;
                case "w":
                    this.days[2] = 1;
                    break;
                case "h":
                    this.days[3] = 1;
                    break;
                case "f":
                    this.days[4] = 1;
                    break;
                case "s":
                    this.days[5] = 1;
                    break;
                case "u":
                    this.days[6] = 1;
                    break;
            }
        }
    }

    public String toString() {
        return String.format("ID: %d | Name: %s | Start Time: %s | End Time: %s", id, name, startTime, endTime);
    }

}
