
import ilog.concert.*;
import ilog.cplex.IloCplex;
import ilog.concert.IloException;
import ilog.concert.IloNumExpr;
import ilog.concert.IloNumVar;
import ilog.concert.IloNumVarType;
import ilog.*;
public class TestCplex {
    /**
     * obj = x1 + 5x2 + 1X3
     * -x1 + x2 + x3 <=56;
     * x1 - 3x2 + x3 <= 39;
     * 0 <= x1 <= 40;
     * 0 <= x2, x3
     * @param args
     */

    public static void main(String[] args) {
//        double[] lb = { 0.0, 0.0, 0.0};
//        double[] ub = { 40.0, Double.MAX_VALUE, Double.MAX_VALUE};
        try {
            IloCplex cplex = new IloCplex(); // creat a model

            double[] lb = {0.0, 0.0, 0.0};
            double[] ub = {40.0, Double.MAX_VALUE, Double.MAX_VALUE};
            IloNumVar[] x = cplex.numVarArray(3, lb, ub);

            double[] objvals = {1.0, 2.0, 3.0};
            cplex.addMaximize(cplex.scalProd(x, objvals));

            double[] coeff1 = {-1.0, 1.0, 1.0};
            double[] coeff2 = {1.0, -3.0, 1.0};

            cplex.addLe(cplex.scalProd(x, coeff1), 20.0);
            cplex.addLe(cplex.scalProd(x, coeff2), 30.0);
//            cplex.addGe(cplex.scalProd(x, coeff2), 30.0);
            if (cplex.solve()) {
                cplex.output().println("Solution status = " + cplex.getStatus());
                cplex.output().println("Solution value = " + cplex.getObjValue());
                double[] val = cplex.getValues(x);
                for (int j = 0; j < val.length; j++)
                    cplex.output().println("x" + (j+1) + "  = " + val[j]);
            }
            cplex.end();

        } catch (IloException e) {
            System.err.println("Concert exception caught: " + e);
        }
    }
}
