/* Generated By:JJTree: Do not edit this line. ASTsubgraph.java */

package dotparser;

public class ASTsubgraph extends SimpleNode {
  public ASTsubgraph(int id) {
    super(id);
  }

  public ASTsubgraph(DOTParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(DOTParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
