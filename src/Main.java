public class Main {
    public static void main(String[] args) {
        int[] p = {1, 2, 1, 2, 1};
        int[] q = {2, 3, 3, 5, 5};
        int[] demand = {1, 1, 2, 2, 2, 2};
        int[] demand2 = {2, 2, 3, 2, 2, 4};
        int[] demand3 = {3, 1, 2, 4, 3, 3, 2, 1, 1, 2, 2, 1};
        int[][] r = {
                {1, 0, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0},
        };
        int[][] r2 = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 0, 1, 0},
        };
        //POVMainModel povModel = new POVMainModel(10, 5, 6, demand, p, q, r);
        //POVMainModel povModel = new POVMainModel(15, 5, 6, demand2, p, q, r);
        POVMainModel povModel = new POVMainModel(25, 5, 12, demand3, p, q, r2);
        povModel.solver.showShortStatistics();
        povModel.solver.solve();
        System.out.println("\n=========== CSP Resolution with Choco-Solver ===========\n");
        System.out.println(povModel.printSolution());
    }
}