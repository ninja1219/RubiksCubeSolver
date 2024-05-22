package CubeStructure;

public class CornerCubie {
  private Face face1;
  private Face face2;
  private Face face3;

  public CornerCubie(Face face1, Face face2, Face face3) {
    this.face1=face1;
    this.face2=face2;
    this.face3=face3;
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

  public Face getFace3() {
    return face3;
  }

  public void setFace3(Face face3) {
    this.face3=face3;
  }
}
