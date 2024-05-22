package Solving;

import CubeStructure.Cube;

import java.util.ArrayList;

public class OptimalSolver {
  private Cube cube;
  private ArrayList<ArrayList<String>> pathToSolve;

  public OptimalSolver(Cube cube) {
    this.cube=cube;
    pathToSolve = new ArrayList<>();
  }

  public Cube getCube() {
    return cube;
  }

  public void setCube(Cube cube) {
    this.cube=cube;
  }

  public void solve() {

  }

  private int heuristic() {
    Cube tempCube = cube;

    return 0;
  }

  private void heuristicHelper() {

  }
}
