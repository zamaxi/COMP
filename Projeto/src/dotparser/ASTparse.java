/* Generated By:JJTree: Do not edit this line. ASTparse.java */

package dotparser;

public class ASTparse extends SimpleNode {
  public ASTparse(int id) {
    super(id);
  }

  public ASTparse(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}