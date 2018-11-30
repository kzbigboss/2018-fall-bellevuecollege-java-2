
//Final Program 4 Example

public class IntTree {
    private IntTreeNode overallRoot;
	
public static void main(String[] args) {
			
IntTreeNode P = 
	new IntTreeNode(-1, null, new IntTreeNode(1, null, new IntTreeNode(-2, null, new IntTreeNode(1, null, new IntTreeNode(10, null, null)))));
IntTree Q = new IntTree(P);
		
		System.out.println(Q.mystery11());				// 4.
		
		Q. printPreorder();								// 5.
		
		
	}
	public int mystery11() {
		    return mystery12(overallRoot);
		}
	private int mystery12(IntTreeNode root) {
	    if (root != null) {
	        return 1;
	    } else {
	        return mystery12(root.right) + mystery12(root.left) ;
	    }
	}
	public String toString() {
		    return toString(overallRoot);
		}
	private String toString(IntTreeNode root) {
		    if (root == null) {
		        return "empty";
		    } else if (root.left == null && root.right == null) {
		        return "" + root.data;
		    } else {
		        return "(" + root.data + ", " + toString(root.left) +
		                ", " + toString(root.right) + ")";
		    }
	}
		

    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }
    public IntTree() {
        overallRoot = null;
    }
    public IntTree(IntTreeNode given) {
        overallRoot = given;
    }
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    } 
}