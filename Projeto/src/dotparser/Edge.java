package dotparser;

import java.util.*;

public class Edge {
	private Vertex sourceVertex;
	private Vertex destinationVertex;
	private int length; // factor that applies to the  edge	length (ranks for normal edges, or minimum node separation for flat edges).
	private int weight; /* cost of the edge.  Values greater than 1 tend to shorten the edge.  
							Weight 0 flat edges are ignored for ordering nodes.*/
	private String label; /* = text where  text	may include escaped newlines \n, \l, or \r for
    						centered, left, or right justified lines.  If  the  substring  '\T'  is
    						found  in  a  label  it will be replaced by the tail_node name.	If the
    						substring '\H' is found in a label it will be replaced by the head_node
    						name.   If  the	substring  '\E'	 value	is found in a label it will be
    						replaced by: tail_node_name->head_node_name If the  substring  '\G'  is
    						found  in  a  label  it	will  be  replaced  by the graph name.	or by:
    						tail_node_name--head_node_name for undirected graphs.*/
	private int fontsize; // sets the label type size to fontsize.
	private int fontname; // name sets the label font family name.
	/* TODO
	 * fontcolor=colorvalue sets the label text color.
	 * A colorvalue may be  "h,s,v"  (hue,  saturation,	 brightness)  floating
	 * point numbers between 0 and 1, or an X11 color name such as white black
	 * red green blue yellow magenta cyan or burlywood, or a  "#rrggbb"	 (red,
	 * green, blue, 2 hex characters each) value.
	 * color=colorvalue sets the line color for edges.
	 * color=colorvaluelist a ':' separated list of colorvalue creates	paral-
	 * lel edges, one edge for each color.
	 * dir=forward back both none controls arrow direction.
	 */
	private boolean tailclip,headclip; //false disables endpoint shape clipping.
	/* TODO
	 * href="url"  sets	 the  url for the node in imagemap, PostScript and SVG
       files.  The substrings '\T', '\H', '\E' and '\G' are substituted in the
       same  manner  as	 for  the edge label attribute.	 Additionally the sub-
       string '\L' is substituted with the edge label string.
       URL="url" ("URL" is a synonym for "href".)
       target="target" is a target string for client-side imagemaps  and  SVG,
       effective  when	edges  have a URL.  If the target string is empty, the
       default, then no target attribute is included in the output.  The  sub-
       strings '\T', '\H', '\E' and '\G' are substituted in the same manner as
       for the edge label attribute.  Additionally the substring '\L' is  sub-
       stituted with the edge label string.
       tooltip="tooltip"  is a tooltip string for client-side imagemaps effec-
       tive when edges have a URL.  The tooltip string defaults to be the same
       as the edge label string.  The substrings '\T', '\H', '\E' and '\G' are
       substituted in the same manner as for the edge label attribute.	 Addi-
       tionally	 the substring '\L' is substituted with the edge label string.
	 */
	private String arrowhead,arrowtail; /*none, normal, inv, dot, odot, invdot, invodot, tee,
											empty, invempty, open, halfopen, diamond, odiamond, box, obox, crow.*/
	private int[] arrowsize = new int[5]; // (norm_length=10,norm_width=5, inv_length=6,inv_width=7,dot_radius=2)
	/* TODO
	 *  headlabel,taillabel=string for port labels.   labelfontcolor,labelfont-
       name,labelfontsize  for	head  and  tail	 labels.  The substrings '\T',
       '\H', '\E' and '\G' are substituted in the same manner as for the  edge
       label  attribute.   Additionally the substring '\L' is substituted with
       the edge label string.
       headhref="url" sets the url for the head port in	 imagemap,  PostScript
       and  SVG	 files.	  The substrings '\T', '\H', '\E' and '\G' are substi-
       tuted in the same manner as for the edge label attribute.  Additionally
       the substring '\L' is substituted with the edge label string.
       headURL="url" ("headURL" is a synonym for "headhref".)
       headtarget="headtarget"	is  a  target string for client-side imagemaps
       and SVG, effective when edge heads have a URL.  The  headtarget	string
       is  used	 to determine which window of the browser is used for the URL.
       If the  headtarget  string  is  empty,  the  default,  then  headtarget
       defaults	 to  the  same	value  as target for the edge.	The substrings
       '\T', '\H', '\E' and '\G' are substituted in the same manner as for the
       edge  label  attribute.	Additionally the substring '\L' is substituted
       with the edge label string.
       headtooltip="tooltip" is a tooltip  string  for	client-side  imagemaps
       effective  when	head ports have a URL.	The tooltip string defaults to
       be the same as the headlabel string.  The substrings  '\T',  '\H',  and
       '\E'  are  substituted  in  the	same  manner  as  for  the  edge label
       attribute.  Additionally the substring '\L'  is	substituted  with  the
       edge label string.
       tailhref="url"  sets  the url for the tail port in imagemap, PostScript
       and SVG files.  The substrings '\T', '\H', '\E' and  '\G'  are  substi-
       tuted in the same manner as for the edge label attribute.  Additionally
       the substring '\L' is substituted with the edge label string.
       tailURL="url" ("tailURL" is a synonym for "tailhref".)
       tailtarget="tailtarget" is a target string  for	client-side  imagemaps
       and  SVG,  effective when edge tails have a URL.	 The tailtarget string
       is used to determine which window of the browser is used for  the  URL.
       If  the	tailtarget  string  is	empty,	the  default,  then tailtarget
       defaults to the same value as target  for  the  edge.   The  substrings
       '\T', '\H', '\E' and '\G' are substituted in the same manner as for the
       edge label attribute.  Additionally the substring '\L'  is  substituted
       with the edge label string.
       tailtooltip="tooltip"  is  a  tooltip  string for client-side imagemaps
       effective when tail ports have a URL.  The tooltip string  defaults  to
       be  the	same as the taillabel string.  The substrings '\T', '\H', '\E'
       and '\G' are substituted in the same  manner  as	 for  the  edge	 label
       attribute.   Additionally  the  substring  '\L' is substituted with the
       edge label string.
	 */
	private float labeldistance,labelangle; // (in degrees CCW) specify the placement of head and tail labels.
	/* TODO
	 *  decorate draws line from edge to label.
	 *  samehead,sametail  aim  edges  having  the same value to the same port,
       using the average landing point.
	 */
	private boolean constraint; // false causes an edge to be ignored for rank assignment.
	/* TODO
	 * private String layer; // =id or id:id or "all" sets the edge's active  layers. The empty string means no layers (invisible).
	 * (neato-specific attributes)
       w=f  sets the weight (spring constant) of an edge to the given floating
       point value.  The default is 1.0; greater values	 make  the  edge  tend
       more toward its optimal length.
       len=f sets the optimal length of an edge.  The default is 1.0.
       (fdp-specific attributes)
       weight=f	 sets the weight of an edge to the given floating point value.
       The default is 1.0; greater values make the edge tend more  toward  its
       optimal length.
	 */


	public Edge(Vertex source, Vertex destination) {
		this.sourceVertex = source;
		this.destinationVertex = destination;

		source.addDestinationEdge(this);
		destination.addSourceEdge(this);
	}

	public Vertex getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(Vertex sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public Vertex getDestinationVertex() {
		return destinationVertex;
	}

	public void setDestinationVertex(Vertex destinationVertex) {
		this.destinationVertex = destinationVertex;
	}

}
