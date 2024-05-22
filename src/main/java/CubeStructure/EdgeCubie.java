package CubeStructure;

public class EdgeCubie {
  private Face face1;
  private Face face2;

  public EdgeCubie(Face face1, Face face2) {
    this.face1=face1;
    this.face2=face2;
  }

  public Face getFace1() {
    return face1;
  }

  public void setFace1(Face face1) {
    this.face1=face1;
  }

  public Face getFace2() {
    return face2;
  }

  public void setFace2(Face face2) {
    this.face2=face2;
  }
}
