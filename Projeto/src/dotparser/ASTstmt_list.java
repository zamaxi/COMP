/* Generated By:JJTree: Do not edit this line. ASTstmt_list.java */

package dotparser;

public class ASTstmt_list extends SimpleNode {
  public ASTstmt_list(int id) {
    super(id);
  }

  public ASTstmt_list(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}