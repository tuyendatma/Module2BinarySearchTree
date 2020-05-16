import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Hien thi cay trung to: ");
        tree.inorder();
        System.out.println("Hien thi cay tien to: ");
        tree.preoder();
        System.out.println("Hien thi cay hau to: ");
        tree.postoder();

//        System.out.println(Arrays.toString(tree.search(20)));
//        tree.search(20);


//        System.out.println("Trước khi xóa 60:");
//        tree.inorder();
//        tree.delete(60);
//        System.out.println("Sau khi xóa 60:");
//        tree.inorder();
    }
}
