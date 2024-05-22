package CubeStructure;

public class Face {
  private char color;
  private char side;
  // private int position;

  public Face(char color, char side/*, int position*/) {
    this.color=color;
    this.side=side;
    // this.position=position;
  }

  public char getColor() {
    return color;
  }

  public void setColor(char color) {
    this.color=color;
  }

  public char getSide() {
    return side;
  }

  public void setSide(char side) {
    this.side=side;
  }

//  public int getPosition() {
//    return position;
//  }
//
//  public void setPosition(int position) {
//    this.position=position;
//  }
}
