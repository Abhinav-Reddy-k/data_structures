package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private class Node{
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "label='" + label + '\'' +
                    '}';
        }
    }
    private Map<String,Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjecencyList =  new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjecencyList.putIfAbsent(node,new ArrayList<>());
    }
    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode==null || toNode == null)
            throw new IllegalStateException();

        adjecencyList.get(fromNode).add(toNode);

    }

    public void print() {
        for (var source:nodes.keySet()) {
            var targets = adjecencyList.get(nodes.get(source));
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void remove(String label){
        var node = nodes.get(label);
        if (!(node == null)){
            for (var n:adjecencyList.keySet()) {
                adjecencyList.get(n).remove(node);
            }
            adjecencyList.remove(node);
            nodes.remove(node.label);
        }
    }

    public void removeEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode==null || toNode == null)
            return;
        adjecencyList.get(fromNode).remove(toNode);
    }
}
