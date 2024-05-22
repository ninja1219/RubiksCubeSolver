package CubeStructure;

import java.util.ArrayList;

public class Cube {
  // Edge and corner cubies are stored in this order: Top to bottom layer and clockwise starting at top left when looking down on cube
  private ArrayList<EdgeCubie> edgeCubies;
  private ArrayList<CornerCubie> cornerCubies;

  public Cube(ArrayList<EdgeCubie> edgeCubies, ArrayList<CornerCubie> cornerCubies) {
    this.edgeCubies=edgeCubies;
    this.cornerCubies=cornerCubies;
  }

  public ArrayList<EdgeCubie> getEdgeCubies() {
    return edgeCubies;
  }

  public void setEdgeCubies(ArrayList<EdgeCubie> edgeCubies) {
    this.edgeCubies=edgeCubies;
  }

  public ArrayList<CornerCubie> getCornerCubies() {
    return cornerCubies;
  }

  public void setCornerCubies(ArrayList<CornerCubie> cornerCubies) {
    this.cornerCubies=cornerCubies;
  }

  // Turns
  public void turnT() {
    // Swap edge cubies
    EdgeCubie topB = new EdgeCubie(new Face(edgeCubies.get(3).getFace1().getColor(), 't'), new Face(edgeCubies.get(3).getFace2().getColor(), 'b'));
    EdgeCubie topR = new EdgeCubie(new Face(edgeCubies.get(0).getFace1().getColor(), 't'), new Face(edgeCubies.get(0).getFace2().getColor(), 'r'));
    EdgeCubie topF = new EdgeCubie(new Face(edgeCubies.get(1).getFace1().getColor(), 't'), new Face(edgeCubies.get(1).getFace2().getColor(), 'f'));
    EdgeCubie topL = new EdgeCubie(new Face(edgeCubies.get(2).getFace1().getColor(), 't'), new Face(edgeCubies.get(2).getFace2().getColor(), 'l'));
    edgeCubies.set(0, topB);
    edgeCubies.set(1, topR);
    edgeCubies.set(2, topF);
    edgeCubies.set(3, topL);

    // Swap corner cubies
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(3).getFace1().getColor(), 't'), new Face(cornerCubies.get(3).getFace3().getColor(), 'b'), new Face(cornerCubies.get(3).getFace2().getColor(), 'l'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(0).getFace1().getColor(), 't'), new Face(cornerCubies.get(0).getFace3().getColor(), 'b'), new Face(cornerCubies.get(0).getFace2().getColor(), 'r'));
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(1).getFace1().getColor(), 't'), new Face(cornerCubies.get(1).getFace3().getColor(), 'f'), new Face(cornerCubies.get(1).getFace2().getColor(), 'r'));
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(2).getFace1().getColor(), 't'), new Face(cornerCubies.get(2).getFace3().getColor(), 'f'), new Face(cornerCubies.get(2).getFace2().getColor(), 'l'));
    cornerCubies.set(0, topBL);
    cornerCubies.set(1, topBR);
    cornerCubies.set(2, topFR);
    cornerCubies.set(3, topFL);
  }

  public void turnTT() {
    // Swap edge cubies
    EdgeCubie topB = new EdgeCubie(new Face(edgeCubies.get(2).getFace1().getColor(), 't'), new Face(edgeCubies.get(2).getFace2().getColor(), 'b'));
    EdgeCubie topR = new EdgeCubie(new Face(edgeCubies.get(3).getFace1().getColor(), 't'), new Face(edgeCubies.get(3).getFace2().getColor(), 'r'));
    EdgeCubie topF = new EdgeCubie(new Face(edgeCubies.get(0).getFace1().getColor(), 't'), new Face(edgeCubies.get(0).getFace2().getColor(), 'f'));
    EdgeCubie topL = new EdgeCubie(new Face(edgeCubies.get(1).getFace1().getColor(), 't'), new Face(edgeCubies.get(1).getFace2().getColor(), 'l'));
    edgeCubies.set(0, topB);
    edgeCubies.set(1, topR);
    edgeCubies.set(2, topF);
    edgeCubies.set(3, topL);

    // Swap corner cubies
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(2).getFace1().getColor(), 't'), new Face(cornerCubies.get(2).getFace2().getColor(), 'b'), new Face(cornerCubies.get(2).getFace3().getColor(), 'l'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(3).getFace1().getColor(), 't'), new Face(cornerCubies.get(3).getFace2().getColor(), 'b'), new Face(cornerCubies.get(3).getFace3().getColor(), 'r'));
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(0).getFace1().getColor(), 't'), new Face(cornerCubies.get(0).getFace2().getColor(), 'f'), new Face(cornerCubies.get(0).getFace3().getColor(), 'r'));
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(1).getFace1().getColor(), 't'), new Face(cornerCubies.get(1).getFace2().getColor(), 'f'), new Face(cornerCubies.get(1).getFace3().getColor(), 'l'));
    cornerCubies.set(0, topBL);
    cornerCubies.set(1, topBR);
    cornerCubies.set(2, topFR);
    cornerCubies.set(3, topFL);
  }

  public void turnTPrime() {
    // Swap edge cubies
    EdgeCubie topB = new EdgeCubie(new Face(edgeCubies.get(1).getFace1().getColor(), 't'), new Face(edgeCubies.get(1).getFace2().getColor(), 'b'));
    EdgeCubie topR = new EdgeCubie(new Face(edgeCubies.get(2).getFace1().getColor(), 't'), new Face(edgeCubies.get(2).getFace2().getColor(), 'r'));
    EdgeCubie topF = new EdgeCubie(new Face(edgeCubies.get(3).getFace1().getColor(), 't'), new Face(edgeCubies.get(3).getFace2().getColor(), 'f'));
    EdgeCubie topL = new EdgeCubie(new Face(edgeCubies.get(0).getFace1().getColor(), 't'), new Face(edgeCubies.get(0).getFace2().getColor(), 'l'));
    edgeCubies.set(0, topB);
    edgeCubies.set(1, topR);
    edgeCubies.set(2, topF);
    edgeCubies.set(3, topL);

    // Swap corner cubies
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(1).getFace1().getColor(), 't'), new Face(cornerCubies.get(1).getFace3().getColor(), 'b'), new Face(cornerCubies.get(1).getFace2().getColor(), 'l'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(2).getFace1().getColor(), 't'), new Face(cornerCubies.get(2).getFace3().getColor(), 'b'), new Face(cornerCubies.get(2).getFace2().getColor(), 'r'));
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(3).getFace1().getColor(), 't'), new Face(cornerCubies.get(3).getFace3().getColor(), 'f'), new Face(cornerCubies.get(3).getFace2().getColor(), 'r'));
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(0).getFace1().getColor(), 't'), new Face(cornerCubies.get(0).getFace3().getColor(), 'f'), new Face(cornerCubies.get(0).getFace2().getColor(), 'l'));
    cornerCubies.set(0, topBL);
    cornerCubies.set(1, topBR);
    cornerCubies.set(2, topFR);
    cornerCubies.set(3, topFL);
  }

  public void turnU() {
    // Swap edge cubies
    EdgeCubie underB = new EdgeCubie(new Face(edgeCubies.get(9).getFace1().getColor(), 'u'), new Face(edgeCubies.get(9).getFace2().getColor(), 'b'));
    EdgeCubie underR = new EdgeCubie(new Face(edgeCubies.get(10).getFace1().getColor(), 'u'), new Face(edgeCubies.get(10).getFace2().getColor(), 'r'));
    EdgeCubie underF = new EdgeCubie(new Face(edgeCubies.get(11).getFace1().getColor(), 'u'), new Face(edgeCubies.get(11).getFace2().getColor(), 'f'));
    EdgeCubie underL = new EdgeCubie(new Face(edgeCubies.get(8).getFace1().getColor(), 'u'), new Face(edgeCubies.get(8).getFace2().getColor(), 'l'));
    edgeCubies.set(8, underB);
    edgeCubies.set(9, underR);
    edgeCubies.set(10, underF);
    edgeCubies.set(11, underL);

    // Swap corner cubies
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(5).getFace1().getColor(), 'u'), new Face(cornerCubies.get(5).getFace3().getColor(), 'b'), new Face(cornerCubies.get(5).getFace2().getColor(), 'l'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(6).getFace1().getColor(), 'u'), new Face(cornerCubies.get(6).getFace3().getColor(), 'b'), new Face(cornerCubies.get(6).getFace2().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(7).getFace1().getColor(), 'u'), new Face(cornerCubies.get(7).getFace3().getColor(), 'f'), new Face(cornerCubies.get(7).getFace2().getColor(), 'r'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(4).getFace1().getColor(), 'u'), new Face(cornerCubies.get(4).getFace3().getColor(), 'f'), new Face(cornerCubies.get(4).getFace2().getColor(), 'l'));
    cornerCubies.set(4, underBL);
    cornerCubies.set(5, underBR);
    cornerCubies.set(6, underFR);
    cornerCubies.set(7, underFL);
  }

  public void turnUU() {
    // Swap edge cubies
    EdgeCubie underB = new EdgeCubie(new Face(edgeCubies.get(10).getFace1().getColor(), 'u'), new Face(edgeCubies.get(10).getFace2().getColor(), 'b'));
    EdgeCubie underR = new EdgeCubie(new Face(edgeCubies.get(11).getFace1().getColor(), 'u'), new Face(edgeCubies.get(11).getFace2().getColor(), 'r'));
    EdgeCubie underF = new EdgeCubie(new Face(edgeCubies.get(8).getFace1().getColor(), 'u'), new Face(edgeCubies.get(8).getFace2().getColor(), 'f'));
    EdgeCubie underL = new EdgeCubie(new Face(edgeCubies.get(9).getFace1().getColor(), 'u'), new Face(edgeCubies.get(9).getFace2().getColor(), 'l'));
    edgeCubies.set(8, underB);
    edgeCubies.set(9, underR);
    edgeCubies.set(10, underF);
    edgeCubies.set(11, underL);

    // Swap corner cubies
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(6).getFace1().getColor(), 'u'), new Face(cornerCubies.get(6).getFace2().getColor(), 'b'), new Face(cornerCubies.get(6).getFace3().getColor(), 'l'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(7).getFace1().getColor(), 'u'), new Face(cornerCubies.get(7).getFace2().getColor(), 'b'), new Face(cornerCubies.get(7).getFace3().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(4).getFace1().getColor(), 'u'), new Face(cornerCubies.get(4).getFace2().getColor(), 'f'), new Face(cornerCubies.get(4).getFace3().getColor(), 'r'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(5).getFace1().getColor(), 'u'), new Face(cornerCubies.get(5).getFace2().getColor(), 'f'), new Face(cornerCubies.get(5).getFace3().getColor(), 'l'));
    cornerCubies.set(4, underBL);
    cornerCubies.set(5, underBR);
    cornerCubies.set(6, underFR);
    cornerCubies.set(7, underFL);
  }

  public void turnUPrime() {
    // Swap edge cubies
    EdgeCubie underB = new EdgeCubie(new Face(edgeCubies.get(11).getFace1().getColor(), 'u'), new Face(edgeCubies.get(11).getFace2().getColor(), 'b'));
    EdgeCubie underR = new EdgeCubie(new Face(edgeCubies.get(8).getFace1().getColor(), 'u'), new Face(edgeCubies.get(8).getFace2().getColor(), 'r'));
    EdgeCubie underF = new EdgeCubie(new Face(edgeCubies.get(9).getFace1().getColor(), 'u'), new Face(edgeCubies.get(9).getFace2().getColor(), 'f'));
    EdgeCubie underL = new EdgeCubie(new Face(edgeCubies.get(10).getFace1().getColor(), 'u'), new Face(edgeCubies.get(10).getFace2().getColor(), 'l'));
    edgeCubies.set(8, underB);
    edgeCubies.set(9, underR);
    edgeCubies.set(10, underF);
    edgeCubies.set(11, underL);

    // Swap corner cubies
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(7).getFace1().getColor(), 'u'), new Face(cornerCubies.get(7).getFace3().getColor(), 'b'), new Face(cornerCubies.get(7).getFace2().getColor(), 'l'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(4).getFace1().getColor(), 'u'), new Face(cornerCubies.get(4).getFace3().getColor(), 'b'), new Face(cornerCubies.get(4).getFace2().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(5).getFace1().getColor(), 'u'), new Face(cornerCubies.get(5).getFace3().getColor(), 'f'), new Face(cornerCubies.get(5).getFace2().getColor(), 'r'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(6).getFace1().getColor(), 'u'), new Face(cornerCubies.get(6).getFace3().getColor(), 'f'), new Face(cornerCubies.get(6).getFace2().getColor(), 'l'));
    cornerCubies.set(4, underBL);
    cornerCubies.set(5, underBR);
    cornerCubies.set(6, underFR);
    cornerCubies.set(7, underFL);
  }

  public void turnF() {
    // Swap edge cubies
    EdgeCubie topF = new EdgeCubie(new Face(edgeCubies.get(7).getFace2().getColor(), 't'), new Face(edgeCubies.get(7).getFace1().getColor(), 'f'));
    EdgeCubie midFR = new EdgeCubie(new Face(edgeCubies.get(2).getFace2().getColor(), 'f'), new Face(edgeCubies.get(2).getFace1().getColor(), 'r'));
    EdgeCubie underF = new EdgeCubie(new Face(edgeCubies.get(6).getFace2().getColor(), 'u'), new Face(edgeCubies.get(6).getFace1().getColor(), 'f'));
    EdgeCubie midFL = new EdgeCubie(new Face(edgeCubies.get(10).getFace2().getColor(), 'f'), new Face(edgeCubies.get(10).getFace1().getColor(), 'l'));
    edgeCubies.set(2, topF);
    edgeCubies.set(6, midFR);
    edgeCubies.set(10, underF);
    edgeCubies.set(7, midFL);

    // Swap corner cubies
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(7).getFace3().getColor(), 't'), new Face(cornerCubies.get(7).getFace2().getColor(), 'f'), new Face(cornerCubies.get(7).getFace1().getColor(), 'l'));
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(3).getFace3().getColor(), 't'), new Face(cornerCubies.get(3).getFace2().getColor(), 'f'), new Face(cornerCubies.get(3).getFace1().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(2).getFace3().getColor(), 'u'), new Face(cornerCubies.get(2).getFace2().getColor(), 'f'), new Face(cornerCubies.get(2).getFace1().getColor(), 'r'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(6).getFace3().getColor(), 'u'), new Face(cornerCubies.get(6).getFace2().getColor(), 'f'), new Face(cornerCubies.get(6).getFace1().getColor(), 'l'));
    cornerCubies.set(3, topFL);
    cornerCubies.set(2, topFR);
    cornerCubies.set(6, underFR);
    cornerCubies.set(7, underFL);
  }

  public void turnFF() {
    // Swap edge cubies
    EdgeCubie topF = new EdgeCubie(new Face(edgeCubies.get(10).getFace1().getColor(), 't'), new Face(edgeCubies.get(10).getFace2().getColor(), 'f'));
    EdgeCubie midFR = new EdgeCubie(new Face(edgeCubies.get(7).getFace1().getColor(), 'f'), new Face(edgeCubies.get(7).getFace2().getColor(), 'r'));
    EdgeCubie underF = new EdgeCubie(new Face(edgeCubies.get(2).getFace1().getColor(), 'u'), new Face(edgeCubies.get(2).getFace2().getColor(), 'f'));
    EdgeCubie midFL = new EdgeCubie(new Face(edgeCubies.get(6).getFace1().getColor(), 'f'), new Face(edgeCubies.get(6).getFace2().getColor(), 'l'));
    edgeCubies.set(2, topF);
    edgeCubies.set(6, midFR);
    edgeCubies.set(10, underF);
    edgeCubies.set(7, midFL);

    // Swap corner cubies
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(6).getFace1().getColor(), 't'), new Face(cornerCubies.get(6).getFace2().getColor(), 'f'), new Face(cornerCubies.get(6).getFace3().getColor(), 'l'));
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(7).getFace1().getColor(), 't'), new Face(cornerCubies.get(7).getFace2().getColor(), 'f'), new Face(cornerCubies.get(7).getFace3().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(3).getFace1().getColor(), 'u'), new Face(cornerCubies.get(3).getFace2().getColor(), 'f'), new Face(cornerCubies.get(3).getFace3().getColor(), 'r'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(2).getFace1().getColor(), 'u'), new Face(cornerCubies.get(2).getFace2().getColor(), 'f'), new Face(cornerCubies.get(2).getFace3().getColor(), 'l'));
    cornerCubies.set(3, topFL);
    cornerCubies.set(2, topFR);
    cornerCubies.set(6, underFR);
    cornerCubies.set(7, underFL);
  }

  public void turnFPrime() {
    // Swap edge cubies
    EdgeCubie topF = new EdgeCubie(new Face(edgeCubies.get(6).getFace2().getColor(), 't'), new Face(edgeCubies.get(6).getFace1().getColor(), 'f'));
    EdgeCubie midFR = new EdgeCubie(new Face(edgeCubies.get(10).getFace2().getColor(), 'f'), new Face(edgeCubies.get(10).getFace1().getColor(), 'r'));
    EdgeCubie underF = new EdgeCubie(new Face(edgeCubies.get(7).getFace2().getColor(), 'u'), new Face(edgeCubies.get(7).getFace1().getColor(), 'f'));
    EdgeCubie midFL = new EdgeCubie(new Face(edgeCubies.get(2).getFace2().getColor(), 'f'), new Face(edgeCubies.get(2).getFace1().getColor(), 'l'));
    edgeCubies.set(2, topF);
    edgeCubies.set(6, midFR);
    edgeCubies.set(10, underF);
    edgeCubies.set(7, midFL);

    // Swap corner cubies
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(2).getFace3().getColor(), 't'), new Face(cornerCubies.get(2).getFace2().getColor(), 'f'), new Face(cornerCubies.get(2).getFace1().getColor(), 'l'));
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(6).getFace3().getColor(), 't'), new Face(cornerCubies.get(6).getFace2().getColor(), 'f'), new Face(cornerCubies.get(6).getFace1().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(7).getFace3().getColor(), 'u'), new Face(cornerCubies.get(7).getFace2().getColor(), 'f'), new Face(cornerCubies.get(7).getFace1().getColor(), 'r'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(3).getFace3().getColor(), 'u'), new Face(cornerCubies.get(3).getFace2().getColor(), 'f'), new Face(cornerCubies.get(3).getFace1().getColor(), 'l'));
    cornerCubies.set(3, topFL);
    cornerCubies.set(2, topFR);
    cornerCubies.set(6, underFR);
    cornerCubies.set(7, underFL);
  }

  public void turnB() {
    // Swap edge cubies
    EdgeCubie underB = new EdgeCubie(new Face(edgeCubies.get(4).getFace2().getColor(), 'u'), new Face(edgeCubies.get(4).getFace1().getColor(), 'b'));
    EdgeCubie midBR = new EdgeCubie(new Face(edgeCubies.get(8).getFace2().getColor(), 'b'), new Face(edgeCubies.get(8).getFace1().getColor(), 'r'));
    EdgeCubie topB = new EdgeCubie(new Face(edgeCubies.get(5).getFace2().getColor(), 't'), new Face(edgeCubies.get(5).getFace1().getColor(), 'b'));
    EdgeCubie midBL = new EdgeCubie(new Face(edgeCubies.get(0).getFace2().getColor(), 'b'), new Face(edgeCubies.get(0).getFace1().getColor(), 'l'));
    edgeCubies.set(8, underB);
    edgeCubies.set(5, midBR);
    edgeCubies.set(0, topB);
    edgeCubies.set(4, midBL);

    // Swap corner cubies
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(0).getFace3().getColor(), 'u'), new Face(cornerCubies.get(0).getFace2().getColor(), 'b'), new Face(cornerCubies.get(0).getFace1().getColor(), 'l'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(4).getFace3().getColor(), 'u'), new Face(cornerCubies.get(4).getFace2().getColor(), 'b'), new Face(cornerCubies.get(4).getFace1().getColor(), 'r'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(5).getFace3().getColor(), 't'), new Face(cornerCubies.get(5).getFace2().getColor(), 'b'), new Face(cornerCubies.get(5).getFace1().getColor(), 'r'));
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(1).getFace3().getColor(), 't'), new Face(cornerCubies.get(1).getFace2().getColor(), 'b'), new Face(cornerCubies.get(1).getFace1().getColor(), 'l'));
    cornerCubies.set(4, underBL);
    cornerCubies.set(5, underBR);
    cornerCubies.set(1, topBR);
    cornerCubies.set(0, topBL);
  }

  public void turnBB() {
    // Swap edge cubies
    EdgeCubie underB = new EdgeCubie(new Face(edgeCubies.get(0).getFace1().getColor(), 'u'), new Face(edgeCubies.get(0).getFace2().getColor(), 'b'));
    EdgeCubie midBR = new EdgeCubie(new Face(edgeCubies.get(4).getFace1().getColor(), 'b'), new Face(edgeCubies.get(4).getFace2().getColor(), 'r'));
    EdgeCubie topB = new EdgeCubie(new Face(edgeCubies.get(8).getFace1().getColor(), 't'), new Face(edgeCubies.get(8).getFace2().getColor(), 'b'));
    EdgeCubie midBL = new EdgeCubie(new Face(edgeCubies.get(5).getFace1().getColor(), 'b'), new Face(edgeCubies.get(5).getFace2().getColor(), 'l'));
    edgeCubies.set(8, underB);
    edgeCubies.set(5, midBR);
    edgeCubies.set(0, topB);
    edgeCubies.set(4, midBL);

    // Swap corner cubies
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(1).getFace1().getColor(), 'u'), new Face(cornerCubies.get(1).getFace2().getColor(), 'b'), new Face(cornerCubies.get(1).getFace3().getColor(), 'l'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(0).getFace1().getColor(), 'u'), new Face(cornerCubies.get(0).getFace2().getColor(), 'b'), new Face(cornerCubies.get(0).getFace3().getColor(), 'r'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(4).getFace1().getColor(), 't'), new Face(cornerCubies.get(4).getFace2().getColor(), 'b'), new Face(cornerCubies.get(4).getFace3().getColor(), 'r'));
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(5).getFace1().getColor(), 't'), new Face(cornerCubies.get(5).getFace2().getColor(), 'b'), new Face(cornerCubies.get(5).getFace3().getColor(), 'l'));
    cornerCubies.set(4, underBL);
    cornerCubies.set(5, underBR);
    cornerCubies.set(1, topBR);
    cornerCubies.set(0, topBL);
  }

  public void turnBPrime() {
    // Swap edge cubies
    EdgeCubie underB = new EdgeCubie(new Face(edgeCubies.get(5).getFace2().getColor(), 'u'), new Face(edgeCubies.get(5).getFace1().getColor(), 'b'));
    EdgeCubie midBR = new EdgeCubie(new Face(edgeCubies.get(0).getFace2().getColor(), 'b'), new Face(edgeCubies.get(0).getFace1().getColor(), 'r'));
    EdgeCubie topB = new EdgeCubie(new Face(edgeCubies.get(4).getFace2().getColor(), 't'), new Face(edgeCubies.get(4).getFace1().getColor(), 'b'));
    EdgeCubie midBL = new EdgeCubie(new Face(edgeCubies.get(8).getFace2().getColor(), 'b'), new Face(edgeCubies.get(8).getFace1().getColor(), 'l'));
    edgeCubies.set(8, underB);
    edgeCubies.set(5, midBR);
    edgeCubies.set(0, topB);
    edgeCubies.set(4, midBL);

    // Swap corner cubies
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(5).getFace3().getColor(), 'u'), new Face(cornerCubies.get(5).getFace2().getColor(), 'b'), new Face(cornerCubies.get(5).getFace1().getColor(), 'l'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(1).getFace3().getColor(), 'u'), new Face(cornerCubies.get(1).getFace2().getColor(), 'b'), new Face(cornerCubies.get(1).getFace1().getColor(), 'r'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(0).getFace3().getColor(), 't'), new Face(cornerCubies.get(0).getFace2().getColor(), 'b'), new Face(cornerCubies.get(0).getFace1().getColor(), 'r'));
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(4).getFace3().getColor(), 't'), new Face(cornerCubies.get(4).getFace2().getColor(), 'b'), new Face(cornerCubies.get(4).getFace1().getColor(), 'l'));
    cornerCubies.set(4, underBL);
    cornerCubies.set(5, underBR);
    cornerCubies.set(1, topBR);
    cornerCubies.set(0, topBL);
  }

  public void turnR() {
    // Swap edge cubies
    EdgeCubie topR = new EdgeCubie(new Face(edgeCubies.get(6).getFace1().getColor(), 't'), new Face(edgeCubies.get(6).getFace2().getColor(), 'r'));
    EdgeCubie midBR = new EdgeCubie(new Face(edgeCubies.get(1).getFace1().getColor(), 'b'), new Face(edgeCubies.get(1).getFace2().getColor(), 'r'));
    EdgeCubie underR = new EdgeCubie(new Face(edgeCubies.get(5).getFace1().getColor(), 'u'), new Face(edgeCubies.get(5).getFace2().getColor(), 'r'));
    EdgeCubie midFR = new EdgeCubie(new Face(edgeCubies.get(9).getFace1().getColor(), 'f'), new Face(edgeCubies.get(9).getFace2().getColor(), 'r'));
    edgeCubies.set(1, topR);
    edgeCubies.set(5, midBR);
    edgeCubies.set(9, underR);
    edgeCubies.set(6, midFR);

    // Swap corner cubies
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(6).getFace2().getColor(), 't'), new Face(cornerCubies.get(6).getFace1().getColor(), 'f'), new Face(cornerCubies.get(6).getFace3().getColor(), 'r'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(2).getFace2().getColor(), 't'), new Face(cornerCubies.get(2).getFace1().getColor(), 'b'), new Face(cornerCubies.get(2).getFace3().getColor(), 'r'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(1).getFace2().getColor(), 'u'), new Face(cornerCubies.get(1).getFace1().getColor(), 'b'), new Face(cornerCubies.get(1).getFace3().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(5).getFace2().getColor(), 'u'), new Face(cornerCubies.get(5).getFace1().getColor(), 'f'), new Face(cornerCubies.get(5).getFace3().getColor(), 'r'));
    cornerCubies.set(2, topFR);
    cornerCubies.set(1, topBR);
    cornerCubies.set(5, underBR);
    cornerCubies.set(6, underFR);
  }

  public void turnRR() {
    // Swap edge cubies
    EdgeCubie topR = new EdgeCubie(new Face(edgeCubies.get(9).getFace1().getColor(), 't'), new Face(edgeCubies.get(9).getFace2().getColor(), 'r'));
    EdgeCubie midBR = new EdgeCubie(new Face(edgeCubies.get(6).getFace1().getColor(), 'b'), new Face(edgeCubies.get(6).getFace2().getColor(), 'r'));
    EdgeCubie underR = new EdgeCubie(new Face(edgeCubies.get(1).getFace1().getColor(), 'u'), new Face(edgeCubies.get(1).getFace2().getColor(), 'r'));
    EdgeCubie midFR = new EdgeCubie(new Face(edgeCubies.get(5).getFace1().getColor(), 'f'), new Face(edgeCubies.get(5).getFace2().getColor(), 'r'));
    edgeCubies.set(1, topR);
    edgeCubies.set(5, midBR);
    edgeCubies.set(9, underR);
    edgeCubies.set(6, midFR);

    // Swap corner cubies
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(5).getFace1().getColor(), 't'), new Face(cornerCubies.get(5).getFace2().getColor(), 'f'), new Face(cornerCubies.get(5).getFace3().getColor(), 'r'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(6).getFace1().getColor(), 't'), new Face(cornerCubies.get(6).getFace2().getColor(), 'b'), new Face(cornerCubies.get(6).getFace3().getColor(), 'r'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(2).getFace1().getColor(), 'u'), new Face(cornerCubies.get(2).getFace2().getColor(), 'b'), new Face(cornerCubies.get(2).getFace3().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(1).getFace1().getColor(), 'u'), new Face(cornerCubies.get(1).getFace2().getColor(), 'f'), new Face(cornerCubies.get(1).getFace3().getColor(), 'r'));
    cornerCubies.set(2, topFR);
    cornerCubies.set(1, topBR);
    cornerCubies.set(5, underBR);
    cornerCubies.set(6, underFR);
  }

  public void turnRPrime() {
    // Swap edge cubies
    EdgeCubie topR = new EdgeCubie(new Face(edgeCubies.get(5).getFace1().getColor(), 't'), new Face(edgeCubies.get(5).getFace2().getColor(), 'r'));
    EdgeCubie midBR = new EdgeCubie(new Face(edgeCubies.get(9).getFace1().getColor(), 'b'), new Face(edgeCubies.get(9).getFace2().getColor(), 'r'));
    EdgeCubie underR = new EdgeCubie(new Face(edgeCubies.get(6).getFace1().getColor(), 'u'), new Face(edgeCubies.get(6).getFace2().getColor(), 'r'));
    EdgeCubie midFR = new EdgeCubie(new Face(edgeCubies.get(1).getFace1().getColor(), 'f'), new Face(edgeCubies.get(1).getFace2().getColor(), 'r'));
    edgeCubies.set(1, topR);
    edgeCubies.set(5, midBR);
    edgeCubies.set(9, underR);
    edgeCubies.set(6, midFR);

    // Swap corner cubies
    CornerCubie topFR = new CornerCubie(new Face(cornerCubies.get(1).getFace2().getColor(), 't'), new Face(cornerCubies.get(1).getFace1().getColor(), 'f'), new Face(cornerCubies.get(1).getFace3().getColor(), 'r'));
    CornerCubie topBR = new CornerCubie(new Face(cornerCubies.get(5).getFace2().getColor(), 't'), new Face(cornerCubies.get(5).getFace1().getColor(), 'b'), new Face(cornerCubies.get(5).getFace3().getColor(), 'r'));
    CornerCubie underBR = new CornerCubie(new Face(cornerCubies.get(6).getFace2().getColor(), 'u'), new Face(cornerCubies.get(6).getFace1().getColor(), 'b'), new Face(cornerCubies.get(6).getFace3().getColor(), 'r'));
    CornerCubie underFR = new CornerCubie(new Face(cornerCubies.get(2).getFace2().getColor(), 'u'), new Face(cornerCubies.get(2).getFace1().getColor(), 'f'), new Face(cornerCubies.get(2).getFace3().getColor(), 'r'));
    cornerCubies.set(2, topFR);
    cornerCubies.set(1, topBR);
    cornerCubies.set(5, underBR);
    cornerCubies.set(6, underFR);
  }

  public void turnL() {
    // Swap edge cubies
    EdgeCubie topL = new EdgeCubie(new Face(edgeCubies.get(4).getFace1().getColor(), 't'), new Face(edgeCubies.get(4).getFace2().getColor(), 'l'));
    EdgeCubie midFL = new EdgeCubie(new Face(edgeCubies.get(3).getFace1().getColor(), 'f'), new Face(edgeCubies.get(3).getFace2().getColor(), 'l'));
    EdgeCubie underL = new EdgeCubie(new Face(edgeCubies.get(7).getFace1().getColor(), 'u'), new Face(edgeCubies.get(7).getFace2().getColor(), 'l'));
    EdgeCubie midBL = new EdgeCubie(new Face(edgeCubies.get(11).getFace1().getColor(), 'b'), new Face(edgeCubies.get(11).getFace2().getColor(), 'l'));
    edgeCubies.set(3, topL);
    edgeCubies.set(7, midFL);
    edgeCubies.set(11, underL);
    edgeCubies.set(4, midBL);

    // Swap corner cubies
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(4).getFace2().getColor(), 't'), new Face(cornerCubies.get(4).getFace1().getColor(), 'b'), new Face(cornerCubies.get(4).getFace3().getColor(), 'l'));
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(0).getFace2().getColor(), 't'), new Face(cornerCubies.get(0).getFace1().getColor(), 'f'), new Face(cornerCubies.get(0).getFace3().getColor(), 'l'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(3).getFace2().getColor(), 'u'), new Face(cornerCubies.get(3).getFace1().getColor(), 'f'), new Face(cornerCubies.get(3).getFace3().getColor(), 'l'));
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(7).getFace2().getColor(), 'u'), new Face(cornerCubies.get(7).getFace1().getColor(), 'b'), new Face(cornerCubies.get(7).getFace3().getColor(), 'l'));
    cornerCubies.set(0, topBL);
    cornerCubies.set(3, topFL);
    cornerCubies.set(7, underFL);
    cornerCubies.set(4, underBL);
  }

  public void turnLL() {
    // Swap edge cubies
    EdgeCubie topL = new EdgeCubie(new Face(edgeCubies.get(11).getFace1().getColor(), 't'), new Face(edgeCubies.get(11).getFace2().getColor(), 'l'));
    EdgeCubie midFL = new EdgeCubie(new Face(edgeCubies.get(4).getFace1().getColor(), 'f'), new Face(edgeCubies.get(4).getFace2().getColor(), 'l'));
    EdgeCubie underL = new EdgeCubie(new Face(edgeCubies.get(3).getFace1().getColor(), 'u'), new Face(edgeCubies.get(3).getFace2().getColor(), 'l'));
    EdgeCubie midBL = new EdgeCubie(new Face(edgeCubies.get(7).getFace1().getColor(), 'b'), new Face(edgeCubies.get(7).getFace2().getColor(), 'l'));
    edgeCubies.set(3, topL);
    edgeCubies.set(7, midFL);
    edgeCubies.set(11, underL);
    edgeCubies.set(4, midBL);

    // Swap corner cubies
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(7).getFace1().getColor(), 't'), new Face(cornerCubies.get(7).getFace2().getColor(), 'b'), new Face(cornerCubies.get(7).getFace3().getColor(), 'l'));
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(4).getFace1().getColor(), 't'), new Face(cornerCubies.get(4).getFace2().getColor(), 'f'), new Face(cornerCubies.get(4).getFace3().getColor(), 'l'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(0).getFace1().getColor(), 'u'), new Face(cornerCubies.get(0).getFace2().getColor(), 'f'), new Face(cornerCubies.get(0).getFace3().getColor(), 'l'));
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(3).getFace1().getColor(), 'u'), new Face(cornerCubies.get(3).getFace2().getColor(), 'b'), new Face(cornerCubies.get(3).getFace3().getColor(), 'l'));
    cornerCubies.set(0, topBL);
    cornerCubies.set(3, topFL);
    cornerCubies.set(7, underFL);
    cornerCubies.set(4, underBL);
  }

  public void turnLPrime() {
    // Swap edge cubies
    EdgeCubie topL = new EdgeCubie(new Face(edgeCubies.get(7).getFace1().getColor(), 't'), new Face(edgeCubies.get(7).getFace2().getColor(), 'l'));
    EdgeCubie midFL = new EdgeCubie(new Face(edgeCubies.get(11).getFace1().getColor(), 'f'), new Face(edgeCubies.get(11).getFace2().getColor(), 'l'));
    EdgeCubie underL = new EdgeCubie(new Face(edgeCubies.get(4).getFace1().getColor(), 'u'), new Face(edgeCubies.get(4).getFace2().getColor(), 'l'));
    EdgeCubie midBL = new EdgeCubie(new Face(edgeCubies.get(3).getFace1().getColor(), 'b'), new Face(edgeCubies.get(3).getFace2().getColor(), 'l'));
    edgeCubies.set(3, topL);
    edgeCubies.set(7, midFL);
    edgeCubies.set(11, underL);
    edgeCubies.set(4, midBL);

    // Swap corner cubies
    CornerCubie topBL = new CornerCubie(new Face(cornerCubies.get(3).getFace2().getColor(), 't'), new Face(cornerCubies.get(3).getFace1().getColor(), 'b'), new Face(cornerCubies.get(3).getFace3().getColor(), 'l'));
    CornerCubie topFL = new CornerCubie(new Face(cornerCubies.get(7).getFace2().getColor(), 't'), new Face(cornerCubies.get(7).getFace1().getColor(), 'f'), new Face(cornerCubies.get(7).getFace3().getColor(), 'l'));
    CornerCubie underFL = new CornerCubie(new Face(cornerCubies.get(4).getFace2().getColor(), 'u'), new Face(cornerCubies.get(4).getFace1().getColor(), 'f'), new Face(cornerCubies.get(4).getFace3().getColor(), 'l'));
    CornerCubie underBL = new CornerCubie(new Face(cornerCubies.get(0).getFace2().getColor(), 'u'), new Face(cornerCubies.get(0).getFace1().getColor(), 'b'), new Face(cornerCubies.get(0).getFace3().getColor(), 'l'));
    cornerCubies.set(0, topBL);
    cornerCubies.set(3, topFL);
    cornerCubies.set(7, underFL);
    cornerCubies.set(4, underBL);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    // Back side
    String cubeString = "       _ _ _\n" +
                        "      |" + cornerCubies.get(4).getFace2().getColor() + " " + edgeCubies.get(8).getFace2().getColor() + " " + cornerCubies.get(5).getFace2().getColor() + "|\n" +
                        "      |" + edgeCubies.get(4).getFace1().getColor() + " o " + edgeCubies.get(5).getFace1().getColor() + "|\n" +
                        "      |" + cornerCubies.get(0).getFace2().getColor() + " " + edgeCubies.get(0).getFace2().getColor() + " " + cornerCubies.get(1).getFace2().getColor() + "|\n";

    // Top side
    cubeString += "      |" + cornerCubies.get(0).getFace1().getColor() + " " + edgeCubies.get(0).getFace1().getColor() + " " + cornerCubies.get(1).getFace1().getColor() + "|\n" +
                  "      |" + edgeCubies.get(3).getFace1().getColor() + " w " + edgeCubies.get(1).getFace1().getColor() + "|\n" +
                  " _ _ _|" + cornerCubies.get(3).getFace1().getColor() + " " + edgeCubies.get(2).getFace1().getColor() + " " + cornerCubies.get(2).getFace1().getColor() + "|_ _ _\n";

    // Left, Front, and Right sides
    cubeString += "|" + cornerCubies.get(0).getFace3().getColor() + " " + edgeCubies.get(3).getFace2().getColor() + " " + cornerCubies.get(3).getFace3().getColor() + "|" + cornerCubies.get(3).getFace2().getColor() + " " + edgeCubies.get(2).getFace2().getColor() + " " + cornerCubies.get(2).getFace2().getColor() + "|" + cornerCubies.get(2).getFace3().getColor() + " " + edgeCubies.get(1).getFace2().getColor() + " " + cornerCubies.get(1).getFace3().getColor() + "|\n" +
                  "|" + edgeCubies.get(4).getFace2().getColor() + " g " + edgeCubies.get(7).getFace2().getColor() + "|" + edgeCubies.get(7).getFace1().getColor() + " r " + edgeCubies.get(6).getFace1().getColor() + "|" + edgeCubies.get(6).getFace2().getColor() + " b " + edgeCubies.get(5).getFace2().getColor() + "|\n" +
                  "|" + cornerCubies.get(4).getFace3().getColor() + " " + edgeCubies.get(11).getFace2().getColor() + " " + cornerCubies.get(7).getFace3().getColor() + "|" + cornerCubies.get(7).getFace2().getColor() + " " + edgeCubies.get(10).getFace2().getColor() + " " + cornerCubies.get(6).getFace2().getColor() + "|" + cornerCubies.get(6).getFace3().getColor() + " " + edgeCubies.get(9).getFace2().getColor() + " " + cornerCubies.get(5).getFace3().getColor() + "|\n";

    // Under side
    cubeString += "      |" + cornerCubies.get(7).getFace1().getColor() + " " + edgeCubies.get(10).getFace1().getColor() + " " + cornerCubies.get(6).getFace1().getColor() + "|\n" +
                  "      |" + edgeCubies.get(11).getFace1().getColor() + " y " + edgeCubies.get(9).getFace1().getColor() + "|\n" +
                  "      |" + cornerCubies.get(4).getFace1().getColor() + " " + edgeCubies.get(8).getFace1().getColor() + " " + cornerCubies.get(5).getFace1().getColor() + "|\n";

    return cubeString;
  }
}
