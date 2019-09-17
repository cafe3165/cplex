import java.util.*;

public class PlanePlan {
    public class Data {
        int flightNum;
        int parkNum;
        List<Flight> flightList;
        List<Deport> deportList;
        List<Passenger> passengerList;
        int[][] isTypeMatching;
        int[][] isConflict;
        int[][][][][] tranTime = {{{{{15, 0}, {20, 1}}, {{20, 1}, {15, 0}}},
                                    {{{35, 0}, {40, 1}}, {{40, 1}, {35, 0}}}},
                                    {{{{35, 0}, {40, 1}}, {{40, 1}, {45, 2}}},
                                     {{{20, 0}, {30, 1}}, {{30, 1}, {20, 0}}}}};
        ;
    }

    //定义航班
    public class Flight {
        String name;
        int startTime;
        int endTime;
        int arriveType;
        int leaveType;
        char planeType;
    }

    //定义登机口
    public class Deport {
        String name;
        char location;
        String area;
        int arriveType;
        int leaveType;
        char planeType;
    }

    //定义乘客信息
    public class Passenger {
        int passengerNum;
        int arriveFlight;
        int leaveFlight;
    }
};

