import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CalQustion1 {
    public static void process_AGAPSchedule(PlanePlan.Data data) throws FileNotFoundException {
        String line = null;
        String[] substr = null;
//        System.out.println(data.tranTime);
//        Scanner cin = new Scanner(new BufferedReader(new FileReader("Pucks.xlsx"))); //读取文件
//        line = cin.nextLine();//读取一行
//        System.out.println(line);
//初始化参数
        data.flightNum = 303;
        data.parkNum = 69;
        data.deportList = new ArrayList<PlanePlan.Deport>();
        data.flightList = new ArrayList<PlanePlan.Flight>();
//        data.passengerList = new ArrayList<PlanePlan.Passenger>();
        data.isTypeMatching = new int[data.flightNum][data.parkNum];
        data.isConflict = new int[data.flightNum][data.flightNum];
//        while (cin.hasNextLine()) {
////            line = cin.nextLine();
////            substr = line.split((","));
//////            PlanePlan.Flight flight = new PlanePlan.Flight();
////            PlanePlan pp = new PlanePlan();
////            PlanePlan.Flight flight = pp.new Flight();
////            flight.name = substr[0];
////            if (substr[1].charAt(0) == '-') {
////                String number = substr[1].substring(1);
////                flight.startTime = -1 * Integer.parseInt(number);
////            } else
////                flight.startTime = Integer.parseInt(substr[1]);
////            flight.arriveType = Integer.parseInt(substr[3]);
////            flight.endTime = Integer.parseInt(substr[5]);
////            flight.leaveType = Integer.parseInt(substr[7]);
////            flight.planeType = substr[10].charAt(0);
////            data.flightList.add(flight);
////        }
////        cin.close();//关闭流
////        cin = new Scanner(new BufferedReader(new FileReader("D://data//AGAP//InputData.csv")));
////        cin.nextLine();
////        while (cin.hasNextLine()) {
////            line = cin.nextLine();
////            substr = line.split((","));
//////            PlanePlan.Deport deport = new PlanePlan.Deport();
////            PlanePlan pp = new PlanePlan();
////            PlanePlan.Deport deport = pp.new Deport();
////            deport.name = substr[0];
////            deport.location = substr[1].charAt(0);
////            deport.area = substr[2];
////            deport.arriveType = Integer.parseInt(substr[3]);
////            deport.leaveType = Integer.parseInt(substr[4]);
////            deport.planeType = substr[5].charAt(0);
////            data.deportList.add(deport);
////        }
////        cin.close();
////        cin = new Scanner(new BufferedReader(new FileReader("D://data//AGAP//passenger.csv")));
////        cin.nextLine();
////        while (cin.hasNextLine()) {
////
////            line = cin.nextLine();
////            substr = line.split((","));
//////            PlanePlan.Passenger passenger = new PlanePlan.Passenger();
////            PlanePlan pp = new PlanePlan();
////            PlanePlan.Passenger passenger = pp.new Passenger();
////            passenger.passengerNum = Integer.parseInt(substr[0]);
////            passenger.arriveFlight = Integer.parseInt(substr[1]);
////            passenger.leaveFlight = Integer.parseInt(substr[2]);
////            data.passengerList.add(passenger);
////        }
////        cin.close();
////        for (int i = 0; i < data.flightList.size(); i++) {
////            for (int j = 0; j < data.deportList.size(); j++) {
////                if ((data.flightList.get(i).arriveType == data.deportList.get(j).arriveType || data.deportList.get(j).arriveType == 2) &&
////                        (data.flightList.get(i).leaveType == data.deportList.get(j).leaveType || data.deportList.get(j).leaveType == 2) &&
////                        data.flightList.get(i).planeType == data.deportList.get(j).planeType)
////                    data.isTypeMatching[i][j] = 1;
////            }
////        }
////        for (int i = 0; i < data.flightList.size(); i++) {
////            for (int j = 0; j < data.flightList.size(); j++) {
////                if (i == j)
////                    continue;
////                PlanePlan.Flight flight1 = data.flightList.get(i);
////                PlanePlan.Flight flight2 = data.flightList.get(j);
////                data.isConflict[i][j] = 1;
////                if (flight1.endTime + 45 <= flight2.startTime)
////                    data.isConflict[i][j] = 0;
////                if (flight1.startTime - 45 >= flight2.endTime)
////                    data.isConflict[i][j] = 0;
////            }
////        }
    }

    public static void main(String[] args) throws Exception {
        PlanePlan planePlan = new PlanePlan();
        PlanePlan.Data data = planePlan.new Data();
        process_AGAPSchedule(data);

    }
}
