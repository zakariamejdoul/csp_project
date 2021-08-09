import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;


// Model main class
public class POVMainModel {
    int nbrCars;                    // Number of cars
    int nbrOptions;                 // Number of options
    int nbrClasses;                 // Number of classes
    int[] p;                        // Number of cars with option i in a partition
    int[] q;                        // Size of a partition for option i
    int[] demand;                   // Number of cars of class i
    int[][] r;                      // r[i][j]=1 if class i requires option j
    Model model;                    // The model
    Solver solver;                  // The solver
    IntVar[] positionClass;         // The class of car in position i of a sequence
    IntVar[][] optionPosition;      // positionOption[i][j]=1 if option i is in position j

    // Model constructor
    public POVMainModel(int V, int O, int nbrClasses, int[] dm, int[] pArray, int[] qArray, int[][] r) {
        this.nbrCars = V;
        this.nbrOptions = O;
        this.nbrClasses = nbrClasses;
        this.p = pArray;
        this.q = qArray;
        this.demand = dm;
        this.r = r;
        this.model = new Model("POV Resolution with Choco-Solver");
        this.solver = this.model.getSolver();
        this.positionClass = model.intVarArray("positionClass", nbrCars, 0, nbrClasses - 1);
        this.optionPosition = model.intVarMatrix("optionPosition", nbrOptions, nbrCars, 0, 1);

        for (int i = 0; i < nbrOptions; i++) {
            frequencyConstraint(p[i], q[i], i);
        }
        demandConstraint();
        for (int i = 0; i < nbrClasses; i++)
            for (int j = 0; j < nbrCars; j++) {
                relationConstraint(i, j);
            }
    }

    // If a car of class 'Class' is in position 'position' and 'Class' requires an option :
    // optionPosition[option][position]=1
    public void relationConstraint(int Class, int position) {
        Constraint[] constraints = new Constraint[nbrOptions];
        for (int i = 0; i < nbrOptions; i++)
            constraints[i] = model.arithm(optionPosition[i][position], "=", r[Class][i]);
        model.ifThen(model.arithm(positionClass[position], "=", Class), model.and(constraints));
    }

    // Each position have a class according to values of classDm (cars per each class)
    public void demandConstraint() {
        int[] classes = new int[nbrClasses];
        IntVar[] classDm = new IntVar[nbrClasses];
        for (int i = 0; i < nbrClasses; i++) {
            classes[i] = i;
            classDm[i] = model.intVar("classDm[" + i + "]", demand[i]);
        }
        model.globalCardinality(positionClass, classes, classDm, true).post();
    }

    // For an option 'option' at most 'p' of these
    // options are allowed in a partition of length 'q'
    public void frequencyConstraint(int p, int q, int option) {
        for (int i = 0; i < nbrCars - q; i++) {
            IntVar[] var = new IntVar[q];
            if (q >= 0) System.arraycopy(optionPosition[option], i, var, 0, q);
            model.sum(var, "<=", p).post();
        }
    }

    // Print 'positionClass' Array and 'optionPosition' Matrix
    public String printSolution() {
        StringBuilder m = new StringBuilder();
        m.append("\t\t\t").append("Required Options").append("\n");
        m.append("-".repeat(Math.max(0, nbrOptions * (nbrOptions + 1))));
        m.append("\n");
        m.append("Class").append("\t\t");
        for (int i = 0; i < nbrOptions; i++) {
            m.append(i + 1).append("\t");
        }
        m.append("\n");
        m.append("-".repeat(Math.max(0, nbrOptions * (nbrOptions + 1))));
        m.append("\n");
        for (int i = 0; i < nbrCars; i++) {
            m.append(positionClass[i].getValue()+1).append("\t\t\t");
            for (int j = 0; j < nbrOptions; j++) {
                m.append(optionPosition[j][i].getValue()).append("\t");
            }
            m.append("\n");
        }
        return m.toString();
    }
}