/* Generated By:JJTree: Do not edit this line. ASTattr_list.java */

package dotparser;

public class ASTattr_list extends SimpleNode {
  public ASTattr_list(int id) {
    super(id);
  }

  public ASTattr_list(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
