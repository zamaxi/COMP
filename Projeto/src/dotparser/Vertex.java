package dotparser;

import java.util.*;

public class Vertex {
	private List<Edge> sourceEdges; // List containing all the Edges with source on this Vertex
	private List<Edge> destinationEdges; // List containing all the Edges with destination on this Vertex
	private String name; // Vertex name
	private int height; // sets  minimum  height  or	 width.
	private int width; // sets  minimum  height  or	 width.
	private boolean fixed_size; // forces these to be the actual size (text labels are ignored).
	/* TODO 
	 * SHAPE
	 * POLYGON SHAPE VERTEX
	 *      regular=n if n is non-zero then the polygon is made regular, i.e.  sym-
       metric  about  the  x  and  y  axis, otherwise the polygon takes on the
       aspect ratio of the label.  builtin_polygons that are not already regu-
       lar  are	 made  regular	by  this attribute.  builtin_polygons that are
       already regular are not affected (i.e.  they cannot  be	made  asymmet-
       ric).
       peripheries=n sets the number of periphery lines drawn around the poly-
       gon.   This  value  supersedes  the  number  of	periphery   lines   of
       builtin_polygons.
       sides=n	sets  the  number  of  sides to the polygon. n<3 results in an
       ellipse.	 This attribute is ignored by builtin_polygons.
       orientation=f sets the orientation of the first	apex  of  the  polygon
       counterclockwise	 from  the  vertical, in degrees.  f may be a floating
       point number.  The orientation  of  labels  is  not  affected  by  this
       attribute.   This  attribute  is	 added	to  the initial orientation of
       builtin_polygons.
       distortion=f sets the amount of broadening of the top and narrowing  of
       the  bottom  of	the  polygon  (relative to its orientation).  Floating
       point values between -1	and  +1	 are  suggested.   This	 attribute  is
       ignored by builtin_polygons.
       skew=f  sets  the amount of right-displacement of the top and left-dis-
       placement of the bottom of the polygon (relative to  its	 orientation).
       Floating	 point values between -1 and +1 are suggested.	This attribute
       is ignored by builtin_polygons.
       (circo-specific attributes)
       root=true/false. This specifies that the	 block	containing  the	 given
       node be treated as the root of the spanning tree in the layout.
       (fdp-specific attributes)
       pin=val.	 If  val  is "true", the node will remain at its initial posi-
       tion.
	 */
	private String label; /* =text where text may include escaped newlines \n, \l,  or  \r  for
		       				center, left, and right justified lines.	 The string '\N' value will be
		       				replaced by the node name.  The string '\G' value will be  replaced  by
		       				the  graph  name.  Record labels may contain recursive box lists delim-
		       				ited by { | }.  Port identifiers in labels are set off by angle	brack-
		       				ets < >.	 In the graph file, use colon (such as, node0:port28).*/
	private float fontsize; // sets the label type size to fontsize points.
	private String fontname; // name sets the label font family name.
	/* TODO 
	 * private float color; // sets the outline color, and the default fill color if
	 * style=filled and fillcolor is not specified.
	 * style=filled solid dashed dotted bold invis or any Postscript code.
	 * fillcolor=colorvalue sets the fill color	 when  style=filled.   If  not
       specified,  the	fillcolor when style=filled defaults to be the same as
       the outline color.
       fontcolor=colorvalue sets the label text color.
       A colorvalue may be  "h,s,v"  (hue,  saturation,	 brightness)  floating
       point numbers between 0 and 1, or an X11 color name such as white black
       red green blue yellow magenta cyan or burlywood, or a  "#rrggbb"	 (red,
       green, blue, 2 hex characters each) value.




       href="url"  sets	 the  url for the node in imagemap, PostScript and SVG
       files.  The substrings '\N' and '\G' are substituted in the same manner
       as  for	the  node label attribute.  Additionally the substring '\L' is
       substituted with the node label string.
       URL="url" ("URL" is a synonym for "href".)
       target="target" is a target string for client-side imagemaps  and  SVG,
       effective  when	nodes have a URL.  The target string is used to deter-
       mine which window of the browser is used for the URL.   Setting	it  to
       "_graphviz"  will  open	a  new	window if it doesn't already exist, or
       reuse it if it does.  If the target string is empty, the default,  then
       no target attribute is included in the output.  The substrings '\N' and
       '\G' are	 substituted  in  the  same  manner  as	 for  the  node	 label
       attribute.   Additionally  the  substring  '\L' is substituted with the
       node label string.
       tooltip="tooltip" is a tooltip string  for  client-side	imagemaps  and
       SVG,  effective	when nodes have a URL.	The tooltip string defaults to
       be the same as the label string, but this attribute permits nodes with-
       out  labels  to still have tooltips thus permitting denser graphs.  The
       substrings '\N' and '\G' are substituted in the same manner as for  the
       node  label  attribute.	Additionally the substring '\L' is substituted
       with the node label string.


	 */


	public void Vertex(String name) {
		this.name = name;
	}

	public boolean addSourceEdge(Edge edge) {

		for (Edge edgeIt : sourceEdges) {
			if (edgeIt.getSourceVertex() == edge.getSourceVertex()) {
				// already added
				return false;
			}
		}

		sourceEdges.add(edge);
		return true;
	}

	public boolean addDestinationEdge(Edge edge) {
		for (Edge edgeIt : destinationEdges) {
			if (edgeIt.getDestinationVertex() == edge.getDestinationVertex()) {
				// already added
				return false;
			}
		}

		destinationEdges.add(edge);
		return true;
	}

}
