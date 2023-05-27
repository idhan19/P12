import java.util.*;

public class SortSearchTreeString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BT binaryTree = new BT();
        System.out.println("Sort & Search Mahasiswa ");
        
        char ch;
        do{
            System.out.println("\nMenu Tree");
            System.out.println("1. Masukan Nama Mahasiswa");
            System.out.println("2. Search Data Mahasiswa");
            System.out.println("3. Tampilkan Sorting");
            System.out.print("Pilih: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nama Mahasiswa: ");
                    binaryTree.insert(scan.next());
                    break;
                case 2:
                    System.out.print("Mencari Data: ");
                    System.out.println("Data tersedia: " + binaryTree.search(scan.next()));
                    break;
                case 3:
                /* Display tree */
                    System.out.print("\nPost order: ");
                    binaryTree.postorder();
                    System.out.print("\nPre order: ");
                    binaryTree.preorder();
                    System.out.print("\nIn order: ");
                    binaryTree.inorder();
                    System.out.println("");
                    break;
                default:
                    System.out.println("Wrong Entry ");
                    break;
            }
            System.out.print("\nLanjutkan? (Y | y)" + "\n" + "Pilih: ");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}

class BTNode {
    BTNode left, right;
    String data;
    /* Constructor */
    public BTNode() {
        left = null;
        right = null;
        data = "";
    }
    /* Constructor */
    public BTNode(String n) {
        left = null;
        right = null;
        data = n;
    }
    
    public void setLeft(BTNode n) {
        left = n;
    }
    
    public void setRight(BTNode n) {
        right = n;
    }
    
    public BTNode getLeft() {
        return left;
    }
    
    public BTNode getRight() {
        return right;
    }
  
    public void setData(String d) {
        data = d;
    }
   
    public String getData() {
        return data;
    }
}
/* Class BT */
class BT {
    private BTNode root;

    public BT() {
        root = null;
    }
  
    public boolean isEmpty() {
        return root == null;
    }
    
    public void insert(String data) {
        root = insert(root, data);
    }
    
    private BTNode insert(BTNode node, String data) {
        if (node == null)
            node = new BTNode(data);
        else {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    public boolean search(String val) {
        return search(root, val);
    }

    private boolean search(BTNode r, String val) {
        if (r.getData().equalsIgnoreCase(val))
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
        return false;
    }

    public void inorder() {
        inorder(root);
    }
    private void inorder(BTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
   
    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }
}
