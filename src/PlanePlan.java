import ilog.concert.IloException;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;
import ilog.concert.*;
import ilog.cplex.*;

import java.util.*;

public class PlanePlan {
    class Data {
        int flightNum;
        int parkNum;
        List<Flight> flightList;
        List<Deport> deportList;
        List<Passenger> passengerList;
        int[][] isTypeMatching;
        int[][] isConflict;
        int[][][][][] tranTime = {{{{{15, 0}, {20, 1}}, {{20, 1}, {15, 0}}}, {{{35, 0}, {40, 1}}, {{40, 1}, {35, 0}}}}, {{{{35, 0}, {40, 1}}, {{40, 1}, {45, 2}}}, {{{20, 0}, {30, 1}}, {{30, 1}, {20, 0}}}}};
        ;
    }

    //定义航班
    class Flight {
        String name;
        int startTime;
        int endTime;
        int arriveType;
        int leaveType;
        char planeType;
    }

    //定义登机口
    class Deport {
        String name;
        char location;
        String area;
        int arriveType;
        int leaveType;
        char planeType;
    }

    //定义乘客信息
    class Passenger {
        int passengerNum;
        int arriveFlight;
        int leaveFlight;
    }

    public class AGAPSchedule2 {
        Data data; //定义类Data的对象
        IloCplex model; //定义cplex内部类的对象
        public IloNumVar[][] xVar; //x[i][j]表示航班i选择登机口j
        public IloNumVar[] yVar;
        public IloNumVar[] flightLocation1;
        public IloNumVar[] flightLocation2;
        double cost; //目标值object

        public AGAPSchedule2(Data data) {
            this.data = data;
        }

        public void build_model() throws IloException {
//model
            model = new IloCplex();
//variables
            xVar = new IloNumVar[data.flightNum][data.parkNum];
            yVar = new IloNumVar[data.parkNum];
            flightLocation1 = new IloNumVar[data.flightNum];
            flightLocation2 = new IloNumVar[data.flightNum];
//定义变量的类型和取值范围
            for (int i = 0; i < data.flightNum; i++) {
                for (int j = 0; j < data.parkNum; j++) {
                    xVar[i][j] = model.numVar(0, 1, IloNumVarType.Int, "xVar" + i + "," + j);
                }
            }
            for (int i = 0; i < data.parkNum; i++) {
                yVar[i] = model.numVar(0, 1, IloNumVarType.Int, "yVar" + i);
            }
            for (int i = 0; i < data.flightNum; i++) {
                flightLocation1[i] = model.numVar(0, 1, IloNumVarType.Int, "flightALocation1" + i);
            }
            for (int i = 0; i < data.flightNum; i++) {
                flightLocation2[i] = model.numVar(0, 1, IloNumVarType.Int, "flightALocation2" + i);
            }
//优化目标
            IloNumExpr obj1 = model.numExpr();
            for (int i = 0; i < data.flightNum; i++) {
                for (int j = 0; j < data.parkNum; j++) {
                    obj1 = model.sum(obj1, xVar[i][j]);
                }
            }
            IloNumExpr obj2 = model.numExpr();
            for (int i = 0; i < data.parkNum; i++) {
                obj2 = model.sum(obj2, yVar[i]);
            }
        }

//        //........问题1优化目标..............
////model.addMaximize(model.sum(obj1, model.prod(-0.01, obj2)));
////...............................
//        IloNumExpr obj3 = model.numExpr();
//for(int i = 0; i<data.passengerList.size();i++)
//
//        {
//            Passenger p = data.passengerList.get(i);
//            int pArrive = p.arriveFlight;
//            int pLeave = p.leaveFlight;
//            IloNumExpr exp = model.numExpr();
//            exp = model.sum(exp, model.prod(model.prod(flightLocation1[pArrive], flightLocation1[pLeave]), data.tranTime[1 - data.flightList.get(pArrive).arriveType][1 - data.flightList.get(pLeave).leaveType][0][0][0]));
//            exp = model.sum(exp, model.prod(model.prod(flightLocation1[pArrive], flightLocation2[pLeave]), data.tranTime[1 - data.flightList.get(pArrive).arriveType][1 - data.flightList.get(pLeave).leaveType][0][1][0]));
//            exp = model.sum(exp, model.prod(model.prod(flightLocation2[pArrive], flightLocation1[pLeave]), data.tranTime[1 - data.flightList.get(pArrive).arriveType][1 - data.flightList.get(pLeave).leaveType][1][0][0]));
//            exp = model.sum(exp, model.prod(model.prod(flightLocation2[pArrive], flightLocation2[pLeave]), data.tranTime[1 - data.flightList.get(pArrive).arriveType][1 - data.flightList.get(pLeave).leaveType][1][1][0]));
//            obj3 = model.sum(obj3, model.prod(exp, p.passengerNum));
//        }
//    }
    }
}