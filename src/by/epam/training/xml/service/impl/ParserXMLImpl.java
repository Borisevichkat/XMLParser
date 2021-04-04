package by.epam.training.xml.service.impl;

import by.epam.training.xml.data.Node;
import by.epam.training.xml.parser.NodeService;
import by.epam.training.xml.service.ParserXML;
import by.epam.training.xml.service.ServiceException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserXMLImpl implements ParserXML {
    private static final String openTagPattern = "<[A-Za-z-]+.*>";
    private static final String closeTagPattern = "</[A-Za-z-]+>";

    @Override
    public Node getMainNode(ArrayList<String> fileContent) throws ServiceException {
        LinkedList<Node> stack = new LinkedList();
        Node result = null;
        Pattern openTag = Pattern.compile(openTagPattern);
        Pattern closeTag = Pattern.compile(closeTagPattern);

        for(String line :fileContent) {
            Matcher openTagMatcher = openTag.matcher(line);
            Matcher closeTagMatcher = closeTag.matcher(line);

            if(openTagMatcher.find()) {
                Node node = NodeService.createNewNode(line);
                stack.addFirst(node);
            }

            if(closeTagMatcher.find()) {
                Node child = stack.pollFirst();
                if(!openTagMatcher.find()){
                    child.appendValue(NodeService.getValue(line));
                }
                if(stack.size()!=0){
                    Node parent = stack.peekFirst();
                    parent.addChildNode(child);
                }
                result = child;
            }

            if(!openTagMatcher.find() && !closeTagMatcher.find() && !stack.isEmpty() && !line.isEmpty()){
                    Node child = stack.peekFirst();
                    child.appendValue(line);
            }
        }
        return result;
    }
}
