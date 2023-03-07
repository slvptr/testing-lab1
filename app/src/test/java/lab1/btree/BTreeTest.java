package lab1.btree;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BTreeTest {

    private BTree bTree;

    private boolean isPrefixEqual(int[] arr, int ...prefix) {
        for (int i = 0; i < prefix.length; ++i) {
            if (i >= arr.length || arr[i] != prefix[i]) return false;
        }
        return true;
    }

    @Before
    public void setUp() {
        bTree = new BTree(3);
    }

    @Test
    public void insert1() {
        bTree.insert(8);
        bTree.insert(9);
        bTree.insert(3);
        bTree.insert(10);
        bTree.insert(21);
        bTree.insert(11);
        bTree.insert(15);
        bTree.insert(20);
        bTree.insert(17);

        assertTrue(isPrefixEqual(bTree.root.key, 9, 15));
        assertTrue(isPrefixEqual(bTree.root.child[0].key, 3, 8));
        assertTrue(isPrefixEqual(bTree.root.child[1].key, 10, 11));
        assertTrue(isPrefixEqual(bTree.root.child[2].key, 17, 20, 21));
    }

    @Test
    public void insert2() {
        bTree.insert(1);
        bTree.insert(3);
        bTree.insert(5);

        assertTrue(isPrefixEqual(bTree.root.key, 1, 3, 5));
    }
}