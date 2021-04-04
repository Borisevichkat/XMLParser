package by.epam.training.xml.data;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String name;
    private List<Node> child;
    private List<Attribute> attributes;
    private String value;

    public Node() {
        this.child = new ArrayList<Node>();
        this.attributes = new ArrayList<Attribute>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildNodes(List<Node> child) {
        this.child = child;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public List<Node> getChildNodes() {
        return child;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public String getValue() {
        return value;
    }

    public void addChildNode(Node node) {
        this.child.add(node);
    }

    public void appendValue(String addValue) {
        if (addValue != null) {
            this.value += " " + addValue;
        }
    }
}