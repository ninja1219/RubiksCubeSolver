package Solving;

import CubeStructure.*;
import java.util.ArrayList;

public class Solver {
  private Cube cube;
  private ArrayList<ArrayList<String> > pathToSolve;

  public Solver(Cube cube) {
    this.cube=cube;
    pathToSolve = new ArrayList<>();
  }

  public Cube getCube() {
    return cube;
  }

  public void setCube(Cube cube) {
    this.cube=cube;
  }

  public void solve() {  // Push each turn onto deque to store the path to solve
    // Solve top layer edges
    solveTopEdges();

    // Solve top layer corners
    solveTopCorners();

    // Solve middle layer edges
    solveMidEdges();

    // Solve bottom layer cross
    solveBottomCross();

    // Solve bottom layer edges
    solveBottomEdges();

    // Solve bottom layer corners
    solveBottomCorners();
  }

  private void solveTopEdges() {
    // Set up variables
    ArrayList<String> path = new ArrayList<>();

    // White and Orange Edge
    solveTopEdgesHelper('w', 'o', 0, path);

    // White and Blue Edge
    solveTopEdgesHelper('w', 'b', 1, path);

    // White and Red Edge
    solveTopEdgesHelper('w', 'r', 2, path);

    // White and Green Edge
    solveTopEdgesHelper('w', 'g', 3, path);

    // Add path to pathToSolve
    pathToSolve.add(path);
  }

  private void solveTopEdgesHelper(char color1, char color2, int solvedPosition, ArrayList<String> path) {
    // Set up variables
    int position = 12;
    int orientation = 2;

    // Find location
    for (int i = 0; i < 12; i++) {
      if (cube.getEdgeCubies().get(i).getFace1().getColor() == color1 && cube.getEdgeCubies().get(i).getFace2().getColor() == color2) {
        position = i;
        orientation = 0;
      }
      else if (cube.getEdgeCubies().get(i).getFace1().getColor() == color2 && cube.getEdgeCubies().get(i).getFace2().getColor() == color1) {
        position = i;
        orientation = 1;
      }
    }

    // Check if edge is already in correct position
    if (position == solvedPosition && orientation == 0) {
      return;
    }

    // Solve
    if (orientation == 0) {
      if (position == 0) {
        cube.turnBPrime();
        path.add("B'");
        if (solvedPosition == 1) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnB();
          path.add("B");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 2) {
          cube.turnTT();
          path.add("TT");
          cube.turnB();
          path.add("B");
          cube.turnTT();
          path.add("TT");
        }
        else {  // solvedPosition == 3
          cube.turnT();
          path.add("T");
          cube.turnB();
          path.add("B");
          cube.turnTPrime();
          path.add("T'");
        }
      }
      else if (position == 1) {
        cube.turnRPrime();
        path.add("R'");
        if (solvedPosition == 0) {
          cube.turnT();
          path.add("T");
          cube.turnR();
          path.add("R");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 2) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnR();
          path.add("R");
          cube.turnT();
          path.add("T");
        }
        else {  // solvedPosition == 3
          cube.turnTT();
          path.add("TT");
          cube.turnR();
          path.add("R");
          cube.turnTT();
          path.add("TT");
        }
      }
      else if (position == 2) {
        cube.turnFPrime();
        path.add("F'");
        if (solvedPosition == 0) {
          cube.turnTT();
          path.add("TT");
          cube.turnF();
          path.add("F");
          cube.turnTT();
          path.add("TT");
        }
        else if (solvedPosition == 1) {
          cube.turnT();
          path.add("T");
          cube.turnF();
          path.add("F");
          cube.turnTPrime();
          path.add("T'");
        }
        else {  // solvedPosition == 3
          cube.turnTPrime();
          path.add("T'");
          cube.turnF();
          path.add("F");
          cube.turnT();
          path.add("T");
        }
      }
      else if (position == 3) {
        cube.turnLPrime();
        path.add("L'");
        if (solvedPosition == 0) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 1) {
          cube.turnTT();
          path.add("TT");
          cube.turnL();
          path.add("L");
          cube.turnTT();
          path.add("TT");
        }
        else {  // solvedPosition == 2
          cube.turnT();
          path.add("T");
          cube.turnL();
          path.add("L");
          cube.turnTPrime();
          path.add("T'");
        }
      }
      else if (position == 4) {
        if (solvedPosition == 0) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 1) {
          cube.turnTT();
          path.add("TT");
          cube.turnL();
          path.add("L");
          cube.turnTT();
          path.add("TT");
        }
        else if (solvedPosition == 2) {
          cube.turnT();
          path.add("T");
          cube.turnL();
          path.add("L");
          cube.turnTPrime();
          path.add("T'");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
        }
      }
      else if (position == 5) {
        if (solvedPosition == 0) {
          cube.turnT();
          path.add("T");
          cube.turnRPrime();
          path.add("R'");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 1) {
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnT();
          path.add("T");
        }
        else {  // solvedPosition == 3
          cube.turnTT();
          path.add("TT");
          cube.turnRPrime();
          path.add("R'");
          cube.turnTT();
          path.add("TT");
        }
      }
      else if (position == 6) {
        if (solvedPosition == 0) {
          cube.turnT();
          path.add("T");
          cube.turnR();
          path.add("R");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
        }
        else if (solvedPosition == 2) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnR();
          path.add("R");
          cube.turnT();
          path.add("T");
        }
        else {  // solvedPosition == 3
          cube.turnTT();
          path.add("TT");
          cube.turnR();
          path.add("R");
          cube.turnTT();
          path.add("TT");
        }
      }
      else if (position == 7) {
        if (solvedPosition == 0) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnLPrime();
          path.add("L'");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 1) {
          cube.turnTT();
          path.add("TT");
          cube.turnLPrime();
          path.add("L'");
          cube.turnTT();
          path.add("TT");
        }
        else if (solvedPosition == 2) {
          cube.turnT();
          path.add("T");
          cube.turnLPrime();
          path.add("L'");
          cube.turnTPrime();
          path.add("T'");
        }
        else {  // solvedPosition == 3
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 8) {
        if (solvedPosition == 0) {
          cube.turnBB();
          path.add("BB");
        }
        else if (solvedPosition == 1) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnRR();
          path.add("RR");
        }
        else if (solvedPosition == 2) {
          cube.turnUU();
          path.add("UU");
          cube.turnFF();
          path.add("FF");
        }
        else {  // solvedPosition == 3
          cube.turnU();
          path.add("U");
          cube.turnLL();
          path.add("LL");
        }
      }
      else if (position == 9) {
        if (solvedPosition == 0) {
          cube.turnU();
          path.add("U");
          cube.turnBB();
          path.add("BB");
        }
        else if (solvedPosition == 1) {
          cube.turnRR();
          path.add("RR");
        }
        else if (solvedPosition == 2) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnFF();
          path.add("FF");
        }
        else {  // solvedPosition == 3
          cube.turnUU();
          path.add("UU");
          cube.turnLL();
          path.add("LL");
        }
      }
      else if (position == 10) {
        if (solvedPosition == 0) {
          cube.turnUU();
          path.add("UU");
          cube.turnBB();
          path.add("BB");
        }
        else if (solvedPosition == 1) {
          cube.turnU();
          path.add("U");
          cube.turnRR();
          path.add("RR");
        }
        else if (solvedPosition == 2) {
          cube.turnFF();
          path.add("FF");
        }
        else {  // solvedPosition == 3
          cube.turnUPrime();
          path.add("U'");
          cube.turnLL();
          path.add("LL");
        }
      }
      else {  // position == 11
        if (solvedPosition == 0) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnBB();
          path.add("BB");
        }
        else if (solvedPosition == 1) {
          cube.turnUU();
          path.add("UU");
          cube.turnRR();
          path.add("RR");
        }
        else if (solvedPosition == 2) {
          cube.turnU();
          path.add("U");
          cube.turnFF();
          path.add("FF");
        }
        else {  // solvedPosition == 3
          cube.turnLL();
          path.add("LL");
        }
      }
    }
    else {  // orientation == 1
      if (position == 0) {
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
          cube.turnTPrime();
          path.add("T'");
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnB();
          path.add("B");
          cube.turnT();
          path.add("T");
          cube.turnL();
          path.add("L");
          cube.turnTPrime();
          path.add("T'");
        }
        else {  // solvedPosition == 3
          cube.turnB();
          path.add("B");
          cube.turnL();
          path.add("L");
        }
      }
      else if (position == 1) {
        if (solvedPosition == 0) {
          cube.turnR();
          path.add("R");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnTPrime();
          path.add("T'");
          cube.turnB();
          path.add("B");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnR();
          path.add("R");
          cube.turnT();
          path.add("T");
          cube.turnB();
          path.add("B");
          cube.turnTPrime();
          path.add("T'");
        }
      }
      else if (position == 2) {
        if (solvedPosition == 0) {
          cube.turnF();
          path.add("F");
          cube.turnT();
          path.add("T");
          cube.turnR();
          path.add("R");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 1) {
          cube.turnF();
          path.add("F");
          cube.turnR();
          path.add("R");
        }
        else if (solvedPosition == 2) {
          cube.turnF();
          path.add("F");
          cube.turnTPrime();
          path.add("T'");
          cube.turnR();
          path.add("R");
          cube.turnT();
          path.add("T");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 3) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
          cube.turnF();
          path.add("F");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 2) {
          cube.turnL();
          path.add("L");
          cube.turnF();
          path.add("F");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnTPrime();
          path.add("T'");
          cube.turnF();
          path.add("F");
          cube.turnT();
          path.add("T");
        }
      }
      else if (position == 4) {
        if (solvedPosition == 0) {
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 2) {
          cube.turnTT();
          path.add("TT");
          cube.turnBPrime();
          path.add("B'");
          cube.turnTT();
          path.add("TT");
        }
        else {  // solvedPosition == 3
          cube.turnT();
          path.add("T");
          cube.turnBPrime();
          path.add("B'");
          cube.turnTPrime();
          path.add("T'");
        }
      }
      else if (position == 5) {
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 1) {
          cube.turnTPrime();
          path.add("T'");
          cube.turnB();
          path.add("B");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 2) {
          cube.turnTT();
          path.add("TT");
          cube.turnB();
          path.add("B");
          cube.turnTT();
          path.add("TT");
        }
        else {  // solvedPosition == 3
          cube.turnT();
          path.add("T");
          cube.turnB();
          path.add("B");
          cube.turnTPrime();
          path.add("T'");
        }
      }
      else if (position == 6) {
        if (solvedPosition == 0) {
          cube.turnTT();
          path.add("TT");
          cube.turnFPrime();
          path.add("F'");
          cube.turnTT();
          path.add("TT");
        }
        else if (solvedPosition == 1) {
          cube.turnT();
          path.add("T");
          cube.turnFPrime();
          path.add("F'");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 2) {
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnTPrime();
          path.add("T'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnT();
          path.add("T");
        }
      }
      else if (position == 7) {
        if (solvedPosition == 0) {
          cube.turnTT();
          path.add("TT");
          cube.turnF();
          path.add("F");
          cube.turnTT();
          path.add("TT");
        }
        else if (solvedPosition == 1) {
          cube.turnT();
          path.add("T");
          cube.turnF();
          path.add("F");
          cube.turnTPrime();
          path.add("T'");
        }
        else if (solvedPosition == 2) {
          cube.turnF();
          path.add("F");
        }
        else {  // solvedPosition == 3
          cube.turnTPrime();
          path.add("T'");
          cube.turnF();
          path.add("F");
          cube.turnT();
          path.add("T");
        }
      }
      else if (position == 8) {
        if (solvedPosition == 0) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnTPrime();
          path.add("T'");
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 1) {
          cube.turnB();
          path.add("B");
          cube.turnRPrime();
          path.add("R'");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 2) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
          cube.turnFPrime();
          path.add("F'");
          cube.turnRPrime();
          path.add("R'");
        }
        else {  // solvedPosition == 3
          cube.turnBPrime();
          path.add("B'");
          cube.turnL();
          path.add("L");
          cube.turnB();
          path.add("B");
        }
      }
      else if (position == 9) {
        if (solvedPosition == 0) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnB();
          path.add("B");
          cube.turnR();
          path.add("R");
        }
        else if (solvedPosition == 1) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnTPrime();
          path.add("T'");
          cube.turnB();
          path.add("B");
          cube.turnT();
          path.add("T");
        }
        else if (solvedPosition == 2) {
          cube.turnR();
          path.add("R");
          cube.turnFPrime();
          path.add("F'");
          cube.turnRPrime();
          path.add("R'");
        }
        else {  // solvedPosition == 3
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
          cube.turnLPrime();
          path.add("L'");
          cube.turnFPrime();
          path.add("F'");
        }
      }
      else if (position == 10) {
        if (solvedPosition == 0) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
          cube.turnBPrime();
          path.add("B'");
          cube.turnLPrime();
          path.add("L'");
        }
        else if (solvedPosition == 1) {
          cube.turnFPrime();
          path.add("F'");
          cube.turnR();
          path.add("R");
          cube.turnF();
          path.add("F");
        }
        else if (solvedPosition == 2) {
          cube.turnFPrime();
          path.add("F'");
          cube.turnTPrime();
          path.add("T'");
          cube.turnR();
          path.add("R");
          cube.turnT();
          path.add("T");
        }
        else {  // solvedPosition == 3
          cube.turnF();
          path.add("F");
          cube.turnLPrime();
          path.add("L'");
          cube.turnFPrime();
          path.add("F'");
        }
      }
      else {  // position == 11
        if (solvedPosition == 0) {
          cube.turnL();
          path.add("L");
          cube.turnBPrime();
          path.add("B'");
          cube.turnLPrime();
          path.add("L'");
        }
        else if (solvedPosition == 1) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
          cube.turnRPrime();
          path.add("R'");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 2) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnF();
          path.add("F");
          cube.turnL();
          path.add("L");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
          cube.turnBPrime();
          path.add("B'");
          cube.turnTPrime();
          path.add("T'");
        }
      }
    }
  }

  private void solveTopCorners() {
    // Set up variables
    ArrayList<String> path = new ArrayList<>();

    // White, Orange, Green Corner
    solveTopCornersHelper('w', 'o', 'g', 0, path);

    // White, Orange, Blue Corner
    solveTopCornersHelper('w', 'o', 'b', 1, path);

    // White, Red, Blue Corner
    solveTopCornersHelper('w', 'r', 'b', 2, path);

    // White, Red, Green Corner
    solveTopCornersHelper('w', 'r', 'g', 3, path);

    // Add path to pathToSolve
    pathToSolve.add(path);
  }

  private void solveTopCornersHelper(char color1, char color2, char color3, int solvedPosition, ArrayList<String> path) {
    // Set up variables
    int position = 8;  // Initialized to invalid position
    int orientation = 3;  // Initialized to invalid orientation

    // Find location
    for (int i = 0; i < 8; i++) {
      if ((solvedPosition % 2 == 0 && (i == 0 || i == 2 || i == 5 || i == 7)) || (solvedPosition % 2 == 1 && (i == 1 || i == 3 || i == 4 || i == 6))) {
        if (cube.getCornerCubies().get(i).getFace1().getColor() == color1 && cube.getCornerCubies().get(i).getFace2().getColor() == color2 && cube.getCornerCubies().get(i).getFace3().getColor() == color3) {
          position=i;
          orientation=0;
        } else if (cube.getCornerCubies().get(i).getFace1().getColor() == color3 && cube.getCornerCubies().get(i).getFace2().getColor() == color1 && cube.getCornerCubies().get(i).getFace3().getColor() == color2) {
          position=i;
          orientation=1;
        } else if (cube.getCornerCubies().get(i).getFace1().getColor() == color2 && cube.getCornerCubies().get(i).getFace2().getColor() == color3 && cube.getCornerCubies().get(i).getFace3().getColor() == color1) {
          position=i;
          orientation=2;
        }
      }
      else {  // (solvedPosition % 2 == 0 and i == 1, 3, 4, or 6) or (solvedPosition % 2 == 1 and i == 0, 2, 5, or 7)
        if (cube.getCornerCubies().get(i).getFace1().getColor() == color1 && cube.getCornerCubies().get(i).getFace2().getColor() == color3 && cube.getCornerCubies().get(i).getFace3().getColor() == color2) {
          position=i;
          orientation=0;
        } else if (cube.getCornerCubies().get(i).getFace1().getColor() == color2 && cube.getCornerCubies().get(i).getFace2().getColor() == color1 && cube.getCornerCubies().get(i).getFace3().getColor() == color3) {
          position=i;
          orientation=1;
        } else if (cube.getCornerCubies().get(i).getFace1().getColor() == color3 && cube.getCornerCubies().get(i).getFace2().getColor() == color2 && cube.getCornerCubies().get(i).getFace3().getColor() == color1) {
          position=i;
          orientation=2;
        }
      }
    }

    // Check if edge is already in correct position
    if (position == solvedPosition && orientation == 0) {
      return;
    }

    // Solve
    if (orientation == 0) {
      if (position == 0) {
        if (solvedPosition == 1) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUU();
          path.add("UU");
          cube.turnR();
          path.add("R");
          cube.turnL();
          path.add("L");
        }
        else {  // solvedPosition == 3
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
        }
      }
      else if (position == 1) {
        if (solvedPosition == 0) {
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 2) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnR();
          path.add("R");
          cube.turnL();
          path.add("L");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 2) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUU();
          path.add("UU");
          cube.turnL();
          path.add("L");
          cube.turnR();
          path.add("R");
        }
        else if (solvedPosition == 1) {
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else {  // solvedPosition == 3
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 3) {
        if (solvedPosition == 0) {
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnL();
          path.add("L");
          cube.turnR();
          path.add("R");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
          cube.turnLPrime();
          path.add("L'");
        }
        else {  // solvedPosition == 2
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
        }
      }
      else if (position == 4) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnUU();
          path.add("UU");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnUU();
          path.add("UU");
          cube.turnF();
          path.add("F");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 5) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnUU();
          path.add("UU");
          cube.turnL();
          path.add("L");
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnU();
          path.add("U");
          cube.turnR();
          path.add("R");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 6) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnUU();
          path.add("UU");
          cube.turnB();
          path.add("B");
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUU();
          path.add("UU");
          cube.turnR();
          path.add("R");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnUU();
          path.add("UU");
          cube.turnLPrime();
          path.add("L'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
        }
      }
      else {  // position == 7
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
          cube.turnUU();
          path.add("UU");
          cube.turnBPrime();
          path.add("B'");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnUU();
          path.add("UU");
          cube.turnR();
          path.add("R");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnU();
          path.add("U");
          cube.turnL();
          path.add("L");
          cube.turnUU();
          path.add("UU");
          cube.turnLPrime();
          path.add("L'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
        }
      }
    }
    else if (orientation == 1) {
      if (position == 0) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnU();
          path.add("U");
          cube.turnL();
          path.add("L");
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBB();
          path.add("BB");
          cube.turnUU();
          path.add("UU");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnB();
          path.add("B");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUU();
          path.add("UU");
          cube.turnR();
          path.add("R");
          cube.turnBPrime();
          path.add("B'");
        }
        else {  // solvedPosition == 3
          cube.turnB();
          path.add("B");
          cube.turnFPrime();
          path.add("F'");
          cube.turnU();
          path.add("U");
          cube.turnF();
          path.add("F");
          cube.turnBPrime();
          path.add("B'");
        }
      }
      else if (position == 1) {
        if (solvedPosition == 0) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnBB();
          path.add("BB");
          cube.turnUU();
          path.add("UU");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnUPrime();
          path.add("U'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnF();
          path.add("F");
          cube.turnUPrime();
          path.add("U'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnB();
          path.add("B");
        }
        else {  // solvedPosition == 3
          cube.turnBPrime();
          path.add("B'");
          cube.turnL();
          path.add("L");
          cube.turnUU();
          path.add("UU");
          cube.turnLPrime();
          path.add("L'");
          cube.turnB();
          path.add("B");
        }
      }
      else if (position == 2) {
        if (solvedPosition == 0) {
          cube.turnF();
          path.add("F");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUU();
          path.add("UU");
          cube.turnL();
          path.add("L");
          cube.turnFPrime();
          path.add("F'");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnB();
          path.add("B");
          cube.turnFPrime();
          path.add("F'");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnU();
          path.add("U");
          cube.turnR();
          path.add("R");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFF();
          path.add("FF");
          cube.turnUU();
          path.add("UU");
          cube.turnF();
          path.add("F");
        }
      }
      else if (position == 3) {
        if (solvedPosition == 0) {
          cube.turnFPrime();
          path.add("F'");
          cube.turnB();
          path.add("B");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnFPrime();
          path.add("F'");
          cube.turnR();
          path.add("R");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
          cube.turnF();
          path.add("F");
        }
        else if (solvedPosition == 2) {
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnFF();
          path.add("FF");
          cube.turnUU();
          path.add("UU");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnUPrime();
          path.add("U'");
          cube.turnLPrime();
          path.add("L'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
        }
      }
      else if (position == 4) {
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnUU();
          path.add("UU");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnU();
          path.add("U");
          cube.turnF();
          path.add("F");
        }
      }
      else if (position == 5) {
        if (solvedPosition == 0) {
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnF();
          path.add("F");
          cube.turnUPrime();
          path.add("U'");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnUU();
          path.add("UU");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 6) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnUU();
          path.add("UU");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnU();
          path.add("U");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else {  // position == 7
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
          cube.turnUPrime();
          path.add("U'");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
        }
      }
    }
    else {  // orientation == 2
      if (position == 0) {
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
          cube.turnUPrime();
          path.add("U'");
          cube.turnBPrime();
          path.add("B'");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 2) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnF();
          path.add("F");
          cube.turnUU();
          path.add("UU");
          cube.turnFPrime();
          path.add("F'");
          cube.turnL();
          path.add("L");
        }
        else {  // solvedPosition == 3
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnLL();
          path.add("LL");
          cube.turnUU();
          path.add("UU");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 1) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnL();
          path.add("L");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnU();
          path.add("U");
          cube.turnB();
          path.add("B");
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRR();
          path.add("RR");
          cube.turnUU();
          path.add("UU");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnR();
          path.add("R");
          cube.turnFPrime();
          path.add("F'");
          cube.turnUU();
          path.add("UU");
          cube.turnF();
          path.add("F");
          cube.turnRPrime();
          path.add("R'");
        }
      }
      else if (position == 2) {
        if (solvedPosition == 0) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnB();
          path.add("B");
          cube.turnUU();
          path.add("UU");
          cube.turnBPrime();
          path.add("B'");
          cube.turnR();
          path.add("R");
        }
        else if (solvedPosition == 1) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnRR();
          path.add("RR");
          cube.turnUU();
          path.add("UU");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnF();
          path.add("F");
          cube.turnUPrime();
          path.add("U'");
          cube.turnFPrime();
          path.add("F'");
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnRPrime();
          path.add("R'");
          cube.turnL();
          path.add("L");
          cube.turnUPrime();
          path.add("U'");
          cube.turnLPrime();
          path.add("L'");
          cube.turnR();
          path.add("R");
        }
      }
      else if (position == 3) {
        if (solvedPosition == 0) {
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLL();
          path.add("LL");
          cube.turnUU();
          path.add("UU");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnL();
          path.add("L");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUU();
          path.add("UU");
          cube.turnB();
          path.add("B");
          cube.turnLPrime();
          path.add("L'");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnU();
          path.add("U");
          cube.turnF();
          path.add("F");
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else if (position == 4) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnUPrime();
          path.add("U'");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnF();
          path.add("F");
          cube.turnUU();
          path.add("UU");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
        }
      }
      else if (position == 5) {
        if (solvedPosition == 0) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnU();
          path.add("U");
          cube.turnL();
          path.add("L");
        }
        else if (solvedPosition == 1) {
          cube.turnR();
          path.add("R");
          cube.turnU();
          path.add("U");
          cube.turnRPrime();
          path.add("R'");
        }
        else if (solvedPosition == 2) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnF();
          path.add("F");
          cube.turnU();
          path.add("U");
          cube.turnFPrime();
          path.add("F'");
        }
        else {  // solvedPosition == 3
          cube.turnFPrime();
          path.add("F'");
          cube.turnUU();
          path.add("UU");
          cube.turnF();
          path.add("F");
        }
      }
      else if (position == 6) {
        if (solvedPosition == 0) {
          cube.turnB();
          path.add("B");
          cube.turnUU();
          path.add("UU");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnUPrime();
          path.add("U'");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnUPrime();
          path.add("U'");
          cube.turnLPrime();
          path.add("L'");
        }
      }
      else {  // position == 7
        if (solvedPosition == 0) {
          cube.turnUPrime();
          path.add("U'");
          cube.turnB();
          path.add("B");
          cube.turnU();
          path.add("U");
          cube.turnBPrime();
          path.add("B'");
        }
        else if (solvedPosition == 1) {
          cube.turnBPrime();
          path.add("B'");
          cube.turnUU();
          path.add("UU");
          cube.turnB();
          path.add("B");
        }
        else if (solvedPosition == 2) {
          cube.turnRPrime();
          path.add("R'");
          cube.turnU();
          path.add("U");
          cube.turnR();
          path.add("R");
        }
        else {  // solvedPosition == 3
          cube.turnL();
          path.add("L");
          cube.turnU();
          path.add("U");
          cube.turnLPrime();
          path.add("L'");
        }
      }
    }
  }

  private void solveMidEdges() {
    // Set up variables
    ArrayList<String> path = new ArrayList<>();

    // Check each piece on bottom layer - if its a middle edge, solve it by putting it in correct bottom position then doing the correct moves
    int numSolved = 0;
    boolean changes = true;
    while (changes) {
      changes = false;
      for (int i = 8; i < 12; i++) {
        char color1 = cube.getEdgeCubies().get(i).getFace1().getColor();
        char color2 = cube.getEdgeCubies().get(i).getFace2().getColor();
        if (color1 != 'y' && color2 != 'y') {
          solveMidEdgesHelper(i, color1, color2, path);
          numSolved++;
          changes = true;
        }
      }
    }

    // Check each middle piece if i haven't solved all four edges yet, and get it out of position, then solve
    if (numSolved != 4) {
      char color1 = cube.getEdgeCubies().get(4).getFace1().getColor();
      char color2 = cube.getEdgeCubies().get(4).getFace2().getColor();
      if (color1 != 'o' || color2 != 'g') {
        solveMidEdgesHelper(9, 'g', 'o', path);
        solveMidEdgesHelper(10, color1, color2, path);
      }

      color1 = cube.getEdgeCubies().get(5).getFace1().getColor();
      color2 = cube.getEdgeCubies().get(5).getFace2().getColor();
      if (color1 != 'o' || color2 != 'b') {
        solveMidEdgesHelper(11, 'b', 'o', path);
        solveMidEdgesHelper(10, color1, color2, path);
      }

      color1 = cube.getEdgeCubies().get(6).getFace1().getColor();
      color2 = cube.getEdgeCubies().get(6).getFace2().getColor();
      if (color1 != 'r' || color2 != 'b') {
        solveMidEdgesHelper(11, 'b', 'r', path);
        solveMidEdgesHelper(8, color1, color2, path);
      }

      color1 = cube.getEdgeCubies().get(7).getFace1().getColor();
      color2 = cube.getEdgeCubies().get(7).getFace2().getColor();
      if (color1 != 'r' || color2 != 'g') {
        solveMidEdgesHelper(9, 'g', 'r', path);
        solveMidEdgesHelper(8, color1, color2, path);
      }
    }

    // Add path to pathToSolve
    pathToSolve.add(path);
  }

  private void solveMidEdgesHelper(int position, char color1, char color2, ArrayList<String> path) {
    if (color2 == 'r') {
      if (color1 == 'b') {
        if (position == 8) {
          cube.turnU();
          path.add("U");
        }
        else if (position == 9) {
          cube.turnUU();
          path.add("UU");
        }
        else if (position == 10) {
          cube.turnUPrime();
          path.add("U'");
        }
        cube.turnRPrime();
        path.add("R'");
        cube.turnU();
        path.add("U");
        cube.turnR();
        path.add("R");
        cube.turnFPrime();
        path.add("F'");
        cube.turnR();
        path.add("R");
        cube.turnF();
        path.add("F");
        cube.turnRPrime();
        path.add("R'");
      }
      else {  // color1 == 'g'
        if (position == 8) {
          cube.turnUPrime();
          path.add("U'");
        }
        else if (position == 10) {
          cube.turnU();
          path.add("U");
        }
        else if (position == 11) {
          cube.turnUU();
          path.add("UU");
        }
        cube.turnL();
        path.add("L");
        cube.turnUPrime();
        path.add("U'");
        cube.turnLPrime();
        path.add("L'");
        cube.turnF();
        path.add("F");
        cube.turnLPrime();
        path.add("L'");
        cube.turnFPrime();
        path.add("F'");
        cube.turnL();
        path.add("L");
      }
    }
    else if (color2 == 'b') {
      if (color1 == 'r') {
        if (position == 9) {
          cube.turnU();
          path.add("U");
        }
        else if (position == 10) {
          cube.turnUU();
          path.add("UU");
        }
        else if (position == 11) {
          cube.turnUPrime();
          path.add("U'");
        }
        cube.turnF();
        path.add("F");
        cube.turnUPrime();
        path.add("U'");
        cube.turnFPrime();
        path.add("F'");
        cube.turnR();
        path.add("R");
        cube.turnFPrime();
        path.add("F'");
        cube.turnRPrime();
        path.add("R'");
        cube.turnF();
        path.add("F");
      }
      else {  // color1 == 'o'
        if (position == 8) {
          cube.turnUU();
          path.add("UU");
        }
        else if (position == 9) {
          cube.turnUPrime();
          path.add("U'");
        }
        else if (position == 11) {
          cube.turnU();
          path.add("U");
        }
        cube.turnBPrime();
        path.add("B'");
        cube.turnU();
        path.add("U");
        cube.turnB();
        path.add("B");
        cube.turnRPrime();
        path.add("R'");
        cube.turnB();
        path.add("B");
        cube.turnR();
        path.add("R");
        cube.turnBPrime();
        path.add("B'");
      }
    }
    else if (color2 == 'o') {
      if (color1 == 'b') {
        if (position == 8) {
          cube.turnU();
          path.add("U");
        }
        else if (position == 9) {
          cube.turnUU();
          path.add("UU");
        }
        else if (position == 10) {
          cube.turnUPrime();
          path.add("U'");
        }
        cube.turnR();
        path.add("R");
        cube.turnUPrime();
        path.add("U'");
        cube.turnRPrime();
        path.add("R'");
        cube.turnB();
        path.add("B");
        cube.turnRPrime();
        path.add("R'");
        cube.turnBPrime();
        path.add("B'");
        cube.turnR();
        path.add("R");
      }
      else {  // color1 == 'g'
        if (position == 8) {
          cube.turnUPrime();
          path.add("U'");
        }
        else if (position == 10) {
          cube.turnU();
          path.add("U");
        }
        else if (position == 11) {
          cube.turnUU();
          path.add("UU");
        }
        cube.turnLPrime();
        path.add("L'");
        cube.turnU();
        path.add("U");
        cube.turnL();
        path.add("L");
        cube.turnBPrime();
        path.add("B'");
        cube.turnL();
        path.add("L");
        cube.turnB();
        path.add("B");
        cube.turnLPrime();
        path.add("L'");
      }
    }
    else {  // color2 == 'g'
      if (color1 == 'r') {
        if (position == 9) {
          cube.turnU();
          path.add("U");
        }
        else if (position == 10) {
          cube.turnUU();
          path.add("UU");
        }
        else if (position == 11) {
          cube.turnUPrime();
          path.add("U'");
        }
        cube.turnFPrime();
        path.add("F'");
        cube.turnU();
        path.add("U");
        cube.turnF();
        path.add("F");
        cube.turnLPrime();
        path.add("L'");
        cube.turnF();
        path.add("F");
        cube.turnL();
        path.add("L");
        cube.turnFPrime();
        path.add("F'");
      }
      else {  // color1 == 'o'
        if (position == 8) {
          cube.turnUU();
          path.add("UU");
        }
        else if (position == 9) {
          cube.turnUPrime();
          path.add("U'");
        }
        else if (position == 11) {
          cube.turnU();
          path.add("U");
        }
        cube.turnB();
        path.add("B");
        cube.turnUPrime();
        path.add("U'");
        cube.turnBPrime();
        path.add("B'");
        cube.turnL();
        path.add("L");
        cube.turnBPrime();
        path.add("B'");
        cube.turnLPrime();
        path.add("L'");
        cube.turnB();
        path.add("B");
      }
    }
  }

  private void solveBottomCross() {
    // Set up variables
    ArrayList<String> path = new ArrayList<>();

    // Check if solved
    if (cube.getEdgeCubies().get(8).getFace1().getColor() == 'y' && cube.getEdgeCubies().get(9).getFace1().getColor() == 'y'
            && cube.getEdgeCubies().get(10).getFace1().getColor() == 'y' && cube.getEdgeCubies().get(11).getFace1().getColor() == 'y') {
      pathToSolve.add(path);
      return;
    }

    // Find path
    path = solveBottomCrossHelper(path, 0);

    // Add path to pathToSolve
    pathToSolve.add(path);
  }

  private ArrayList<String> solveBottomCrossHelper(ArrayList<String> tempPath, int counter) {

    // Delete path and undo cube turns if needed
    if (counter == 3 || counter == 4) {
      for (int i = 0; i < 12; i++) {
        tempPath.remove(tempPath.size() - 1);
      }

      cube.turnR();
      cube.turnU();
      cube.turnF();
      cube.turnUPrime();
      cube.turnFPrime();
      cube.turnRPrime();

      cube.turnF();
      cube.turnU();
      cube.turnL();
      cube.turnUPrime();
      cube.turnLPrime();
      cube.turnFPrime();
    }
    else if (counter == 7) {
      for (int i = 0; i < 12; i++) {
        tempPath.remove(tempPath.size() - 1);
      }

      cube.turnF();
      cube.turnU();
      cube.turnL();
      cube.turnUPrime();
      cube.turnLPrime();
      cube.turnFPrime();

      cube.turnR();
      cube.turnU();
      cube.turnF();
      cube.turnUPrime();
      cube.turnFPrime();
      cube.turnRPrime();
    }

    // Find path
    if (counter == 0 || counter == 1 || counter == 6 || counter == 7) {
      cube.turnF();
      tempPath.add("F");
      cube.turnL();
      tempPath.add("L");
      cube.turnU();
      tempPath.add("U");
      cube.turnLPrime();
      tempPath.add("L'");
      cube.turnUPrime();
      tempPath.add("U'");
      cube.turnFPrime();
      tempPath.add("F'");
    }
    else if (counter == 2 || counter == 3 || counter == 4 || counter == 5) {
      cube.turnR();
      tempPath.add("R");
      cube.turnF();
      tempPath.add("F");
      cube.turnU();
      tempPath.add("U");
      cube.turnFPrime();
      tempPath.add("F'");
      cube.turnUPrime();
      tempPath.add("U'");
      cube.turnRPrime();
      tempPath.add("R'");
    }

    // Check if solved
    if (cube.getEdgeCubies().get(8).getFace1().getColor() == 'y' && cube.getEdgeCubies().get(9).getFace1().getColor() == 'y'
            && cube.getEdgeCubies().get(10).getFace1().getColor() == 'y' && cube.getEdgeCubies().get(11).getFace1().getColor() == 'y') {
      return tempPath;
    }
    else {
      counter++;
      tempPath = solveBottomCrossHelper(tempPath, counter);
    }

    return tempPath;
  }

  private void solveBottomEdges() {
    ArrayList<String> path = new ArrayList<>();

    // Find red-yellow edge and move to correct position
    int redPos = 0;
    if (cube.getEdgeCubies().get(8).getFace2().getColor() == 'r') {
      redPos = 8;
      cube.turnUU();
      path.add("UU");
    }
    else if (cube.getEdgeCubies().get(9).getFace2().getColor() == 'r') {
      redPos = 9;
      cube.turnUPrime();
      path.add("U'");
    }
    else if (cube.getEdgeCubies().get(10).getFace2().getColor() == 'r') {
      redPos = 10;
    }
    else if (cube.getEdgeCubies().get(11).getFace2().getColor() == 'r') {
      redPos = 11;
      cube.turnU();
      path.add("U");
    }

    // Check which edges are correct
    int numCorrect = 1;
    int[] edgesCorrect = new int[4];
    edgesCorrect[2] = 1;
    if (cube.getEdgeCubies().get(8).getFace2().getColor() == 'o') {
      edgesCorrect[0] = 1;
      numCorrect++;
    }
    if (cube.getEdgeCubies().get(9).getFace2().getColor() == 'b') {
      edgesCorrect[1] = 1;
      numCorrect++;
    }
    if (cube.getEdgeCubies().get(11).getFace2().getColor() == 'g') {
      edgesCorrect[3] = 1;
      numCorrect++;
    }

    // If 4 edges are correct, return
    if (numCorrect == 4) {
      pathToSolve.add(path);
      return;
    }

    // If 2 edges across from each other are correct, then switch edges once and put red-yellow edge back in correct spot
    if (edgesCorrect[0] == 1) {
      cube.turnR();
      path.add("R");
      cube.turnUU();
      path.add("UU");
      cube.turnRPrime();
      path.add("R'");
      cube.turnUPrime();
      path.add("U'");
      cube.turnR();
      path.add("R");
      cube.turnUPrime();
      path.add("U'");
      cube.turnRPrime();
      path.add("R'");
      cube.turnUPrime();
      path.add("U'");

      numCorrect = 1;
    }

    // If 1 red-yellow edge is correct, then solve edges
    if (numCorrect == 1) {
      boolean solved = false;
      while (!solved) {
        cube.turnL();
        path.add("L");
        cube.turnUU();
        path.add("UU");
        cube.turnLPrime();
        path.add("L'");
        cube.turnUPrime();
        path.add("U'");
        cube.turnL();
        path.add("L");
        cube.turnUPrime();
        path.add("U'");
        cube.turnLPrime();
        path.add("L'");

        if (cube.getEdgeCubies().get(8).getFace2().getColor() == 'o') {
          solved = true;
        }
      }
    }

    // If 2 edges next to each other are correct, then find orange-yellow edge instead and move to correct position
    if (numCorrect == 2) {
      if (edgesCorrect[1] == 1) {
        cube.turnUPrime();
        path.add("U'");
      }
      else {  // edgesCorrect[3] == 1
        cube.turnU();
        path.add("U");
      }

      // Solve for orange-yellow edge and return
      boolean solved = false;
      while (!solved) {
        cube.turnR();
        path.add("R");
        cube.turnUU();
        path.add("UU");
        cube.turnRPrime();
        path.add("R'");
        cube.turnUPrime();
        path.add("U'");
        cube.turnR();
        path.add("R");
        cube.turnUPrime();
        path.add("U'");
        cube.turnRPrime();
        path.add("R'");

        if (cube.getEdgeCubies().get(10).getFace2().getColor() == 'r') {
          solved = true;
        }
      }
    }

    // Store path in pathToSolve
    pathToSolve.add(path);
  }

  private void solveBottomCorners() {
    // Set up variables
    ArrayList<String> path = new ArrayList<>();

    // Put corners in the correct positions
    solveBottomCornersHelper(path);

    // Once all corners are in the correct positions, perform algorithm to get all bottom corners in the correct orientations
    for (int i = 0; i < 4; i++) {
      while (cube.getCornerCubies().get(7).getFace1().getColor() != 'y') {
        for (int j=0; j < 2; j++) {
          cube.turnLPrime();
          path.add("L'");
          cube.turnTPrime();
          path.add("T'");
          cube.turnL();
          path.add("L");
          cube.turnT();
          path.add("T");
        }
      }
      cube.turnUPrime();
      path.add("U'");
    }

    // Store path in pathToSolve
    pathToSolve.add(path);
  }

  private void solveBottomCornersHelper(ArrayList<String> path) {
    // Check how many corners are in the correct positions
    int correctCorners = getNumCorrectCorners();

    // If only 0 or 1 corners were correct, then perform algorithm to get all bottom corners in the correct positions
    boolean allCorrect = true;
    if (correctCorners != 1) {
      allCorrect = false;
    }
    while (!allCorrect) {
      // Perform algorithm
      if (correctCorners == 4) {
        cube.turnUPrime();
        path.add("U'");
        cube.turnLPrime();
        path.add("L'");
        cube.turnU();
        path.add("U");
        cube.turnR();
        path.add("R");
        cube.turnUPrime();
        path.add("U'");
        cube.turnL();
        path.add("L");
        cube.turnU();
        path.add("U");
        cube.turnRPrime();
        path.add("R'");
      }
      else if (correctCorners == 5) {
        cube.turnU();
        path.add("U");
        cube.turnR();
        path.add("R");
        cube.turnUPrime();
        path.add("U'");
        cube.turnLPrime();
        path.add("L'");
        cube.turnU();
        path.add("U");
        cube.turnRPrime();
        path.add("R'");
        cube.turnUPrime();
        path.add("U'");
        cube.turnL();
        path.add("L");
      }
      else if (correctCorners == 6) {
        cube.turnUPrime();
        path.add("U'");
        cube.turnRPrime();
        path.add("R'");
        cube.turnU();
        path.add("U");
        cube.turnL();
        path.add("L");
        cube.turnUPrime();
        path.add("U'");
        cube.turnR();
        path.add("R");
        cube.turnU();
        path.add("U");
        cube.turnLPrime();
        path.add("L'");
      }
      else {  // numCorrectCorners == 7 or == 0
        cube.turnU();
        path.add("U");
        cube.turnL();
        path.add("L");
        cube.turnUPrime();
        path.add("U'");
        cube.turnRPrime();
        path.add("R'");
        cube.turnU();
        path.add("U");
        cube.turnLPrime();
        path.add("L'");
        cube.turnUPrime();
        path.add("U'");
        cube.turnR();
        path.add("R");
      }

      // Check how many corners are correct again, and loop if not all are correct
      correctCorners = getNumCorrectCorners();
      if (correctCorners == 1) {
        allCorrect = true;
      }
    }
  }

  private int getNumCorrectCorners() {
    int numCorrectCorners = 0;
    int correctPosition = 0;

    if ((cube.getCornerCubies().get(4).getFace1().getColor() == 'y' && cube.getCornerCubies().get(4).getFace2().getColor() == 'o' && cube.getCornerCubies().get(4).getFace3().getColor() == 'g')
            || (cube.getCornerCubies().get(4).getFace1().getColor() == 'g' && cube.getCornerCubies().get(4).getFace2().getColor() == 'y' && cube.getCornerCubies().get(4).getFace3().getColor() == 'o')
            || (cube.getCornerCubies().get(4).getFace1().getColor() == 'o' && cube.getCornerCubies().get(4).getFace2().getColor() == 'g' && cube.getCornerCubies().get(4).getFace3().getColor() == 'y')) {
      numCorrectCorners++;
      correctPosition = 4;
    }
    if ((cube.getCornerCubies().get(5).getFace1().getColor() == 'y' && cube.getCornerCubies().get(5).getFace2().getColor() == 'o' && cube.getCornerCubies().get(5).getFace3().getColor() == 'b')
            || (cube.getCornerCubies().get(5).getFace1().getColor() == 'b' && cube.getCornerCubies().get(5).getFace2().getColor() == 'y' && cube.getCornerCubies().get(5).getFace3().getColor() == 'o')
            || (cube.getCornerCubies().get(5).getFace1().getColor() == 'o' && cube.getCornerCubies().get(5).getFace2().getColor() == 'b' && cube.getCornerCubies().get(5).getFace3().getColor() == 'y')) {
      numCorrectCorners++;
      correctPosition = 5;
    }
    if ((cube.getCornerCubies().get(6).getFace1().getColor() == 'y' && cube.getCornerCubies().get(6).getFace2().getColor() == 'r' && cube.getCornerCubies().get(6).getFace3().getColor() == 'b')
            || (cube.getCornerCubies().get(6).getFace1().getColor() == 'b' && cube.getCornerCubies().get(6).getFace2().getColor() == 'y' && cube.getCornerCubies().get(6).getFace3().getColor() == 'r')
            || (cube.getCornerCubies().get(6).getFace1().getColor() == 'r' && cube.getCornerCubies().get(6).getFace2().getColor() == 'b' && cube.getCornerCubies().get(6).getFace3().getColor() == 'y')) {
      numCorrectCorners++;
      correctPosition = 6;
    }
    if ((cube.getCornerCubies().get(7).getFace1().getColor() == 'y' && cube.getCornerCubies().get(7).getFace2().getColor() == 'r' && cube.getCornerCubies().get(7).getFace3().getColor() == 'g')
            || (cube.getCornerCubies().get(7).getFace1().getColor() == 'g' && cube.getCornerCubies().get(7).getFace2().getColor() == 'y' && cube.getCornerCubies().get(7).getFace3().getColor() == 'r')
            || (cube.getCornerCubies().get(7).getFace1().getColor() == 'r' && cube.getCornerCubies().get(7).getFace2().getColor() == 'g' && cube.getCornerCubies().get(7).getFace3().getColor() == 'y')) {
      numCorrectCorners++;
      correctPosition = 7;
    }

    // return 0 if 0 are correct, 1 if all are correct, and the position if only 1 is correct
    if (numCorrectCorners == 0) {
      return 0;
    }
    else if (numCorrectCorners == 4) {
      return 1;
    }
    else {
      return correctPosition;
    }
  }

  public String printPath() {
    String[] steps = {"Step 1: Solve Top Edges\n", "Step 2: Solve Top Corners\n", "Step 3: Solve Middle Edges\n", "Step 4: Solve Bottom Cross\n",  "Step 5: Solve Bottom Edges\n",  "Step 6: Solve Bottom Corners\n"};
    StringBuilder pathString = new StringBuilder();

    // Shorten path before printing out
    shortenPath();

    for (int i = 0; i < pathToSolve.size(); i++) {
      pathString.append(steps[i]);
      for (int j = 0; j < pathToSolve.get(i).size(); j++) {
        pathString.append(pathToSolve.get(i).get(j)).append(" ");
        if ((j + 1) % 5 == 0 && j < pathToSolve.get(i).size() - 1) {
          pathString.append("\n");
        }
      }
      pathString.append("\n");
    }

    return pathString.toString();
  }

  private void shortenPath() {
    for (ArrayList<String> steps : pathToSolve) {
      for (int j = 1; j < steps.size(); j++) {
        if (j <= 0) {
          j++;
        }
        String prevTurn = steps.get(j - 1);
        String currTurn = steps.get(j);
        if (currTurn.length() == 1) {
          if (currTurn.equals(prevTurn)) {
            steps.set(j, currTurn + currTurn);
            j--;
            steps.remove(j);
          }
          else if (prevTurn.charAt(0) == currTurn.charAt(0)) {
            if (prevTurn.charAt(1) == '\'') {
              steps.remove(j - 1);
              steps.remove(j - 1);
              j -= 2;
            }
            else {
              steps.set(j, currTurn + "'");
              j--;
              steps.remove(j);
            }
          }
        }
        else if (prevTurn.length() == 1) {
          if (prevTurn.charAt(0) == currTurn.charAt(0)) {
            if (currTurn.charAt(1) == '\'') {
              steps.remove(j - 1);
              steps.remove(j - 1);
              j -= 2;
            }
            else {
              steps.set(j, currTurn + "'");
              j--;
              steps.remove(j);
            }
          }
        }
        else if (currTurn.equals(prevTurn)) {
          if (currTurn.charAt(1) == '\'') {
            currTurn = currTurn.replace('\'', currTurn.charAt(0));
            steps.set(j, currTurn);
            j--;
            steps.remove(j);
          }
          else {
            steps.remove(j - 1);
            steps.remove(j - 1);
            j -= 2;
          }
        }
        else if (currTurn.charAt(0) == prevTurn.charAt(0)) {
          currTurn = "" + currTurn.charAt(0);
          steps.set(j, currTurn);
          j--;
          steps.remove(j);
        }
      }
    }
  }
}
