package Solving;

import CubeStructure.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  private static final String[] sideNames = {"Top", "Under", "Front", "Back", "Right", "Left"};

  public static void main(String[] args) {
    // Give basic info to user
    System.out.println("When inputting your cube data, use this structure to define positions:");
    System.out.print(   "       _ _ _\n" +
            "      |     |\n" +
            "      |Back |\n" +
            "      |_ _ _|\n" +
            "      |     |\n" +
            "      | Top |\n" +
            " _ _ _|_ _ _|_ _ _\n" +
            "|     |     |     |\n" +
            "|Left |Front|Right|\n" +
            "|_ _ _|_ _ _|_ _ _|\n" +
            "      |     |\n" +
            "      |Under|\n" +
            "      |_ _ _|\n\n");
    System.out.println("Position the TOP to have a WHITE center, the FRONT to have a RED center, and the RIGHT to have a BLUE center");
    System.out.println("When typing in colors, type W for White, Y for Yellow, O for Orange, R for Red, " + "B for Blue, and G for Green");
    System.out.println("For each side, type 9 letters with no spaces, starting with the top left, going across, then down");

    // Set up variables
    String top = "";
    String under = "";
    String front = "";
    String back = "";
    String right = "";
    String left = "";

    // Get color positions on all sides
    for (String sideName : sideNames) {
      // Get colors and positions
      String sideColorsInput = "";
      try {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.printf("Enter the list of nine colors for the %s side:%n", sideName);
        sideColorsInput = br.readLine();
      }
      catch (IOException e) {
        e.printStackTrace();
      }

      // Check that input is valid
      if (sideColorsInput.length() != 9) {
        System.out.println("Invalid number of colors");
        return;
      }
      // TODO: Check that the center color is correct for the correct side, else print error message and return
      //  Check that sideColorsInput only has valid chars, else print error message and return

      // Store the cube side as the correct string
      switch(sideName) {
        case("Top"):
          top = sideColorsInput;
        case("Under"):
          under = sideColorsInput;
        case("Front"):
          front = sideColorsInput;
        case("Back"):
          back = sideColorsInput;
        case("Right"):
          right = sideColorsInput;
        case("Left"):
          left = sideColorsInput;
      }
    }

    // Create Cube
    Cube cube = createCube(top, under, front, back, right, left);
    System.out.println(cube.toString());

    // Solve the cube
    Solver solver = new Solver(cube);
    solver.solve();
    System.out.print(solver.printPath());
    System.out.println(cube.toString());

    // Testing
    /*
    cube.setFront(new CubeSide("rrrrrrrrr"));
    cube.setBottom(new CubeSide("yyyyyyyyy"));
    cube.setLeft(new CubeSide("ggggggggg"));
    cube.setRight(new CubeSide("bbbbbbbbb"));
    cube.setTop(new CubeSide("wwwwwwwww"));
    cube.setBack(new CubeSide("ooooooooo"));
    cube.turnFrontCC();
    cube.turnTopCC();
    cube.turnRightCC();
    cube.turnLeftCC();
    cube.turnBackCC();
    cube.turnBottomCC();
    System.out.print(cube.toString()); */
  }

  private static Cube createCube(String top, String under, String front, String back, String right, String left) {
    // Create edge cubies
    // Set up
    ArrayList<EdgeCubie> edgeCubies = new ArrayList<>();
    Face face1;
    Face face2;

    // Top layer
    face1 = new Face(top.charAt(1), 't');
    face2 = new Face(back.charAt(7), 'b');
    EdgeCubie topB = new EdgeCubie(face1, face2);
    edgeCubies.add(topB);

    face1 = new Face(top.charAt(5), 't');
    face2 = new Face(right.charAt(1), 'r');
    EdgeCubie topR = new EdgeCubie(face1, face2);
    edgeCubies.add(topR);

    face1 = new Face(top.charAt(7), 't');
    face2 = new Face(front.charAt(1), 'f');
    EdgeCubie topF = new EdgeCubie(face1, face2);
    edgeCubies.add(topF);

    face1 = new Face(top.charAt(3), 't');
    face2 = new Face(left.charAt(1), 'l');
    EdgeCubie topL = new EdgeCubie(face1, face2);
    edgeCubies.add(topL);

    // Middle layer
    face1 = new Face(back.charAt(3), 'b');
    face2 = new Face(left.charAt(3), 'l');
    EdgeCubie midBL = new EdgeCubie(face1, face2);
    edgeCubies.add(midBL);

    face1 = new Face(back.charAt(5), 'b');
    face2 = new Face(right.charAt(5), 'r');
    EdgeCubie midBR = new EdgeCubie(face1, face2);
    edgeCubies.add(midBR);

    face1 = new Face(front.charAt(5), 'f');
    face2 = new Face(right.charAt(3), 'r');
    EdgeCubie midFR = new EdgeCubie(face1, face2);
    edgeCubies.add(midFR);

    face1 = new Face(front.charAt(3), 'f');
    face2 = new Face(left.charAt(5), 'l');
    EdgeCubie midFL = new EdgeCubie(face1, face2);
    edgeCubies.add(midFL);

    // Bottom layer
    face1 = new Face(under.charAt(7), 'u');
    face2 = new Face(back.charAt(1), 'b');
    EdgeCubie underB = new EdgeCubie(face1, face2);
    edgeCubies.add(underB);

    face1 = new Face(under.charAt(5), 'u');
    face2 = new Face(right.charAt(7), 'r');
    EdgeCubie underR = new EdgeCubie(face1, face2);
    edgeCubies.add(underR);

    face1 = new Face(under.charAt(1), 'u');
    face2 = new Face(front.charAt(7), 'f');
    EdgeCubie underF = new EdgeCubie(face1, face2);
    edgeCubies.add(underF);

    face1 = new Face(under.charAt(3), 'u');
    face2 = new Face(left.charAt(7), 'l');
    EdgeCubie underL = new EdgeCubie(face1, face2);
    edgeCubies.add(underL);

    // Create corner cubies
    // Set up
    ArrayList<CornerCubie> cornerCubies = new ArrayList<>();
    Face face3;

    // Top layer
    face1 = new Face(top.charAt(0), 't');
    face2 = new Face(back.charAt(6), 'b');
    face3 = new Face(left.charAt(0), 'l');
    CornerCubie topBL = new CornerCubie(face1, face2, face3);
    cornerCubies.add(topBL);

    face1 = new Face(top.charAt(2), 't');
    face2 = new Face(back.charAt(8), 'b');
    face3 = new Face(right.charAt(2), 'r');
    CornerCubie topBR = new CornerCubie(face1, face2, face3);
    cornerCubies.add(topBR);

    face1 = new Face(top.charAt(8), 't');
    face2 = new Face(front.charAt(2), 'f');
    face3 = new Face(right.charAt(0), 'r');
    CornerCubie topFR = new CornerCubie(face1, face2, face3);
    cornerCubies.add(topFR);

    face1 = new Face(top.charAt(6), 't');
    face2 = new Face(front.charAt(0), 'f');
    face3 = new Face(left.charAt(2), 'l');
    CornerCubie topFL = new CornerCubie(face1, face2, face3);
    cornerCubies.add(topFL);

    // Bottom layer
    face1 = new Face(under.charAt(6), 'u');
    face2 = new Face(back.charAt(0), 'b');
    face3 = new Face(left.charAt(6), 'l');
    CornerCubie underBL = new CornerCubie(face1, face2, face3);
    cornerCubies.add(underBL);

    face1 = new Face(under.charAt(8), 'u');
    face2 = new Face(back.charAt(2), 'b');
    face3 = new Face(right.charAt(8), 'r');
    CornerCubie underBR = new CornerCubie(face1, face2, face3);
    cornerCubies.add(underBR);

    face1 = new Face(under.charAt(2), 'u');
    face2 = new Face(front.charAt(8), 'f');
    face3 = new Face(right.charAt(6), 'r');
    CornerCubie underFR = new CornerCubie(face1, face2, face3);
    cornerCubies.add(underFR);

    face1 = new Face(under.charAt(0), 'u');
    face2 = new Face(front.charAt(6), 'f');
    face3 = new Face(left.charAt(8), 'l');
    CornerCubie underFL = new CornerCubie(face1, face2, face3);
    cornerCubies.add(underFL);

    // Create and return cube
    return new Cube(edgeCubies, cornerCubies);
  }

}
