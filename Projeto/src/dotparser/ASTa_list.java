/* Generated By:JJTree: Do not edit this line. ASTa_list.java */

package dotparser;

public class ASTa_list extends SimpleNode {
  public ASTa_list(int id) {
    super(id);
  }

  public ASTa_list(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
