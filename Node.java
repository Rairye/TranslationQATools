package commentAna.commentAna;

import java.util.HashMap;
import java.util.HashSet;

public class Node implements Cloneable {

	private String name;
	private HashMap<String, Node> children;
	private boolean isWordEnd;
	private String sourceTerm;
	private String targetTerm;

	public Node (String name) {
		this.name = name;
		this.children = new HashMap<>();
		this.isWordEnd = false;
	}
	
	public void addChild (String childName) {
		children.put(childName, new Node(childName));
	}
	
	public boolean hasChild(String childName) {
		return children.containsKey(childName);
	}
	
	public void setAsWordEnd(String sourceTerm, String targetTerm) {
		this.isWordEnd = true;
		this.sourceTerm = sourceTerm;
		this.targetTerm = targetTerm;
	}
	
	public boolean isWordEnd() {
		return this.isWordEnd;
	}
	
	public Node getChild(String childName) {
		return children.get(childName);
	}
	
	public String getSourceTerm() {
		return this.sourceTerm;
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public HashSet<Node> getChildren(){
		HashSet<Node> results = new HashSet<>();
		for (Node node : children.values()) {
			results.add(node);
		}
		return results;
	}
	
	@Override
	public String toString() {
		return this.sourceTerm + " -> " + this.targetTerm;
	}
	
	@Override
	public Node clone() throws CloneNotSupportedException {
		return (Node) super.clone();
	}
}