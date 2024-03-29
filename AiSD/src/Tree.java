import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Tree {
    protected Node node;
    public int iter = 0;

    public Tree(int value) {
        this.node = new Node(value);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.value) {
            node.setRight(insert(node.getRight(), value));
        }
        iter++;
        return node;
    }

    public void inOrderAsc(Node node, OutputStream fr) throws IOException {
        if (node != null) {
            inOrderAsc(node.getLeft(), fr);
            fr.write((Integer.toString(node.getValue()) + "\n").getBytes());
            inOrderAsc(node.getRight(), fr);
        }
    }

    public void inOrderDesc(Node node, OutputStream fr) throws IOException {
        if (node != null) {
            inOrderDesc(node.getRight(), fr);
            fr.write((Integer.toString(node.getValue()) + "\n").getBytes());
            inOrderDesc(node.getLeft(), fr);
        }
    }

    public Node getNode() {
        return this.node;
    }

    public int getIter() {
        return iter;
    }
}
