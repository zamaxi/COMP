/* Generated By:JJTree: Do not edit this line. ASTgraph.java */

package dotparser;

public class ASTgraph extends SimpleNode {
  public ASTgraph(int id) {
    super(id);
  }

  public ASTgraph(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
