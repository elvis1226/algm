package org.dgf.tree;

public class SmartBST {
    static class BST {
        public int value; // > left value, <= right value
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST cur = this;
            BST pre = null;
            while (cur != null) {
                pre = cur;
                if (cur.value <= value) {
                    cur = cur.right;
                }
                else {
                    cur = cur.left;
                }
            }

            BST node = new BST(value);
            if (pre.value <= value) {
                pre.right = node;
            }
            else {
                pre.left = node;
            }
            return this;
        }

        public boolean contains(int value) {
            BST cur = this;
            while (cur != null) {
                if (cur.value < value) {
                    cur = cur.right;
                }
                else if (cur.value > value) {
                    cur = cur.left;
                }
                else {
                    return true;
                }
            }
            return false;
        }

        public BST[] findSuccessor(BST node) {
            BST succ = node, preSuc = node;
            while (succ != null && succ.left != null) {
                preSuc = succ;
                succ = succ.left;
            }
            return new BST[] {preSuc, succ};
        }

        public BST[] find(BST root, int value) {
            BST cur = root, pre = root;
            while (cur != null) {
                if (cur.value < value) {
                    pre = cur;
                    cur = cur.right;
                }
                else if (cur.value > value) {
                    pre = cur;
                    cur = cur.left;
                }
                else {
                    break;
                }
            }
            return new BST[] {pre, cur};
        }

        public void setChild(BST pre, BST old, BST newN) {
            if (pre == old) {
                pre.value = newN.value;
                pre.left = newN.left;
                pre.right = newN.right;
                return;
            }

            if (pre.left == old) {
                pre.left = newN;
            }
            else {
                pre.right = newN;
            }
        }

        //Only remove the 1st instance of given value
        // can't remove if only one node in the tree, just do nothing.
        public BST remove(int value) {
            if (this.left == null && this.right == null) {
                return this;
            }
            BST[] matched = find(this, value);
            BST cur = matched[1], pre = matched[0];

            // if leave node
            if (cur.left == null && cur.right == null) {
                setChild(pre, cur, null);
                return this;
            }
            // only left node present
            if (cur.left != null && cur.right == null) {
                setChild(pre, cur, cur.left);
                return this;
            }
            //right present, left present
            BST[] succors = findSuccessor(cur.right);
            BST preSucc = succors[0];
            BST succ = succors[1];

            if (preSucc == succ) { // cur.right is next and without left node
                cur.right = succ.right;
                cur.value = succ.value;
            }
            else {
                preSucc.left = succ.right;
                cur.value = succ.value;
            }
            return this;
        }
    }
}
