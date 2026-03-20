package Tree.SegmentTree;

import java.util.*;

public class MaxOccurrenceSegmentTree {

    static class Node {
        int maxValue;
        int freq;

        Node(int maxValue, int freq) {
            this.maxValue = maxValue;
            this.freq = freq;
        }
    }

    static class SegmentTree {
        int n;
        Node[] tree;
        int[] arr;

        SegmentTree(int[] arr) {
            this.n = arr.length;
            this.arr = arr;
            tree = new Node[4 * n];
            build(0, 0, n - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = new Node(arr[start], 1);
                return;
            }

            int mid = (start + end) / 2;
            build(2 * node + 1, start, mid);
            build(2 * node + 2, mid + 1, end);

            tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
        }

        private Node merge(Node left, Node right) {
            if (left.maxValue > right.maxValue) return left;
            if (right.maxValue > left.maxValue) return right;
            return new Node(left.maxValue, left.freq + right.freq);
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                arr[idx] += val;
                tree[node] = new Node(arr[idx], 1);
                return;
            }

            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }

            tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public Node queryMax() {
            return tree[0];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 3, 1};

        SegmentTree st = new SegmentTree(arr);

        Node result = st.queryMax();
        System.out.println("Max Value: " + result.maxValue + ", Frequency: " + result.freq);

        // Update index 2 by +3 → arr[2] becomes 5
        st.update(2, 3);

        result = st.queryMax();
        System.out.println("After Update -> Max Value: " + result.maxValue + ", Frequency: " + result.freq);
    }
}