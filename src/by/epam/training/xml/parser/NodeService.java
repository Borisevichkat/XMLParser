package by.epam.training.xml.parser;

import by.epam.training.xml.data.Attribute;
import by.epam.training.xml.data.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeService {
    private static final String tagNamePattern = "<([A-Za-z-]+\\b)";
    private static final String attributePattern = "(([a-z]+)=\"(\\S+)\")";
    private static final String valuePattern = "(>|^)([A-Za-z-\\s$.0-9]+)(<|$)";

    public static String getValue(String line){
        Pattern pattern = Pattern.compile(valuePattern);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            return matcher.group(2).trim();
        }
        return null;
    }

    public static String getTagName(String line){
        Pattern pattern = Pattern.compile(tagNamePattern);
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            return matcher.group(1).trim();
        }
        return null;
    }

    public static List<Attribute> getAttributes(String line){
        List<Attribute> attributes = new ArrayList<>();
        Pattern pattern = Pattern.compile(attributePattern);
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            String nameAttribute = matcher.group(2);
            String value = matcher.group(3);
            attributes.add(new Attribute(nameAttribute, value));
        }
        return attributes;
    }

    public static Node createNewNode(String line){
        Node node = new Node();
        node.setName(getTagName(line));
        node.setAttributes(getAttributes(line));
        node.setValue(getValue(line));
        return node;
    }
}
