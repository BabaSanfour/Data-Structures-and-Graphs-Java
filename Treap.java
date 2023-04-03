import java.util.Random;

// A Treap Node
class TreapNode
{
	int data;
	int priority;
	TreapNode left, right;

	// constructor
	TreapNode(int data)
	{
		this.data = data;
		this.priority = new Random().nextInt(100);
		this.left = this.right = null;
	}
}

class Treap
{
	
	public static TreapNode rotateLeft(TreapNode root)
	{
		TreapNode R = root.right;
		TreapNode X = root.right.left;

		// rotate
		R.left = root;
		root.right = X;

		// set a new root
		return R;
	}


	public static TreapNode rotateRight(TreapNode root)
	{
		TreapNode L = root.left;
		TreapNode Y = root.left.right;

		// rotate
		L.right = root;
		root.left = Y;

		// set a new root
		return L;
	}

	
	public static TreapNode insertNode(TreapNode root, int data)
	{
		
		if (root == null) {
			return new TreapNode(data);
		}

		
		if (data < root.data)
		{   
			root.left = insertNode(root.left, data);
			if (root.left.priority > root.priority) {
				root = rotateRight(root);
			}
		}
		else {
			root.right = insertNode(root.right, data);
			if (root.right.priority > root.priority) {
				root = rotateLeft(root);
			}
		}
		return root;
	}

	
	public static boolean searchNode(TreapNode root, int key)
	{
		if (root == null)
			return false;
		if (root.data == key)
			return true;
		else if (key < root.data) 
			return searchNode(root.left, key);
		return searchNode(root.right, key);	
	}

	
	public static TreapNode deleteNode(TreapNode root, int key)
	{
		if (root == null) // cas 1
			return null;
		else if (key < root.data) // cas 2 
			root.left = deleteNode(root.left, key);
		else if (key > root.data) 
			root.right = deleteNode(root.right, key); 
		else { // cas 3
			if (root.left == null && root.right == null) 
				return null;
			else if (root.left == null) 
				root = root.right;
			else if (root.right == null) 
				root = root.left;
			else {
				if (root.left.priority < root.right.priority) {
					root = rotateLeft(root);
					root.left = deleteNode(root.left, key);
				}
				else {
					root = rotateRight(root);
					root.right = deleteNode(root.right, key);
				}
			}
		}
		return root;
	}

	

}

