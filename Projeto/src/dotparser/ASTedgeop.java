/* Generated By:JJTree: Do not edit this line. ASTedgeop.java */

package dotparser;

public class ASTedgeop extends SimpleNode {
  public ASTedgeop(int id) {
    super(id);
  }

  public ASTedgeop(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}