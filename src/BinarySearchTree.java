public class BinarySearchTree {
    class Node {
        private int key;
        private Node left, right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    private Node root;

    // hàm dựng constructor
    public BinarySearchTree() {
        this.root = null;
    }

    /* Hàm đệ qui thực hiện việc chèn phần từ vào cây */
    private Node insertRec(Node root, int key) {

        /* nếu cây rỗng trả về node mới */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* ngược lại sẽ thực hiện duyệt dọc cây */
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        /* trả về cây nhị phân đã được thêm phần tử mới */
        return root;
    }

    // Gọi phương thức insertRec
    public void insert(int key) {
        root = insertRec(root, key);
    }

    //Hàm thực hiện việc sắp xếp, in và Duyệt trung tố cây nhị phân
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key + " ");
            inorderRec(root.right);
        }
    }

    //Hàm thực hiện việc sắp xếp, in và Duyệt tiền tố cây nhị phân
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    //Hàm thực hiện việc sắp xếp, in và Duyệt hậu tố cây nhị phân
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.key + " ");
        }
    }

    //Phương thức gọi hàm sắp xếp trung tố
    public void inorder() {
        inorderRec(root);
    }

    //Phương thức gọi hàm sắp xếp tiền tố
    public void preoder() {
        preorderRec(root);
    }

    //Phương thức gọi hàm sắp xếp hậu tố
    public void postoder() {
        postorderRec(root);
    }

    //Tìm kiếm vị trí trên cây nhị phân
    private Node searchRec(Node root, int key) {
        // Trường hợp gốc : nếu node null hoặc là node root
        if (root==null || root.key==key)
            return root;

        // gia trị lớn hơn giá trị code node root
        if (root.key > key)
            return searchRec(root.left, key);

        // giá trị bé hơn giá trị của node root
        return searchRec(root.right, key);
    }

    //Phương thức gọi hàm tìm kiếm
    public void search(int key) {
        root = searchRec(root, key);
        if (root!=null){
            System.out.println("Key "+key+" có trong cây nhị phân");
        }else {
            System.out.println("Key "+key+" không có trong cây nhị phân");
        }
    }

    /* Hàm đệ qui để xóa phần tử khỏi mảng */
    private Node deleteRec(Node root, int key) {
        /* trường hợp gốc : nếu node root null */
        if (root == null) return root;

        /* ngược lại chúng ta sẽ duyệt dọc cây  */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // nếu key có cùng giá trị với node key thì chính là node cần xóa
        else {
            // node không có hoặc chỉ có 1 node con
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node có 2 node con.
            root.key = minValue(root.right);

            // Xóa phần từ nhỏ nhất bên phải
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }
}
