import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

            private class Node{
                public E e;
                public Node left,right;

                public Node(E e){
                    this.e = e;
                    left = null;
                    right = null;
                }
            }

            private Node root;
            private int size;

            public BST(){
                root = null;
                size = 0;
            }

            public int size(){
                return size;
            }

            public boolean isEmpty(){
                return size == 0;
            }

            public void add(E e){
              root = add(root,e);
            }

            // 向以node为根的二分搜索树中插入元素E,递归算法
            private Node add(Node node,E e){

                if(node == null){
                    size++;
                    return new Node(e);
                }
                if(e.compareTo(node.e)<0){
                    node.left = add(node.left,e);
                }
                else if(e.compareTo(node.e)>0){
                    node.right = add(node.right,e);
                }
                    return node;
            }

            public boolean contains(E e){
                return contains(root,e);
            }

            //宏观语义：看以node为根的二分搜索树中是否包含元素e,递归算法
            private boolean contains(Node node,E e){

                if(node == null) return false;
                if(e.compareTo(node.e) == 0) return true;
                else if(e.compareTo(node.e)<0){
                    return contains(node.left,e); // 看当前节点的左子树是否包含元素e
                }
                else{
                    return contains(node.right,e);
                }
            }

            //二分搜索树的前序遍历
            public void preOrder(){
                preOrder(root);
            }

            //前序遍历以node为根的二分搜索树
            private void preOrder(Node node){

                    if(node == null) return;
                    System.out.println(node.e);
                    preOrder(node.left);
                    preOrder(node.right);

            }

            public void inOrder(){
                inOrder(root);
            }

            //中序遍历以node为根的二分搜素树，递归算法
            private void inOrder(Node node){

                if(node == null) return;

                inOrder(node.left);
                System.out.println(node.e);
                inOrder(node.right);
            }

            public void postOrder(){
                postOrder(root);
            }

            private void postOrder(Node node){

                if(node == null) return;

                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.e);
            }

            //二分搜索树前序遍历的非递归写法

            public void preOrderNR(){
                Stack<Node> stack = new Stack<>();
                stack.push(root);
                while(!stack.isEmpty()){
                    Node cur = stack.pop();
                    System.out.println(cur.e);
                    if(cur.right!=null) stack.push(cur.right);
                    if(cur.left!=null) stack.push(cur.left);
                }
            }

            //队列实现层序遍历
            public void levelOrder(){
                Queue<Node> queue = new LinkedList<>();
                queue.add(root);
                while(!queue.isEmpty()){
                    Node cur = queue.remove();
                    System.out.println(cur.e);
                    if(cur.left!=null) {
                        queue.add(cur.left);
                    }
                    if(cur.right!=null){
                        queue.add(cur.right);
                    }
                }
            }

            @Override
            public String toString(){
                StringBuilder res = new StringBuilder();
                generateBSTString(root,0,res);
                return res.toString();
            }

            private void generateBSTString(Node node,int depth,StringBuilder res){

                if(node == null){
                    res.append(generateDepthString(depth) + "null\n");
                    return;
                }

                res.append(generateDepthString(depth) + node.e + "\n");
                generateBSTString(node.left,depth+1,res);
                generateBSTString(node.right,depth+1,res);
            }

            private String generateDepthString(int depth){
                StringBuilder res = new StringBuilder();
                for(int i = 0;i<depth;i++){
                    res.append("--");
                }
                return res.toString();
            }
}
