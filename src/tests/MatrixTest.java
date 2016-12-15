package tests;

import java.io.*;

import main.DenseMatrix;
import main.SparseMatrix;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class MatrixTest {
    BufferedReader s;
    SparseMatrix ASparse1;
    DenseMatrix ADense1;
    SparseMatrix ASparse2;
    DenseMatrix ADense2;
    SparseMatrix result;
    DenseMatrix result1;


    public MatrixTest() {
        try {
            s = new BufferedReader(new FileReader("src/tests/test1.txt"));
            ASparse1 = new SparseMatrix(s);
            s = new BufferedReader(new FileReader("src/tests/test1.txt"));
            ADense1 = new DenseMatrix(s);

            s = new BufferedReader(new FileReader("src/tests/test2.txt"));
            ASparse2 = new SparseMatrix(s);
            s = new BufferedReader(new FileReader("src/tests/test2.txt"));
            ADense2 = new DenseMatrix(s);

            s = new BufferedReader(new FileReader("src/tests/test_result.txt"));
            result = new SparseMatrix(s);
            s = new BufferedReader(new FileReader("src/tests/test_result.txt"));
            result1 = new DenseMatrix(s);
        } catch (IOException e)

        {
            e.printStackTrace();
        }
    }


    @Test
    public void mulSD() {
        SparseMatrix sd = (SparseMatrix) ASparse1.mul(ADense2);
        result.equals(sd);
    }

    @Test
    public void mulSS() {
        SparseMatrix ss = (SparseMatrix) ASparse1.mul(ASparse2);
        result.equals(ss);
    }

    @Test
    public void mulDS() {
        SparseMatrix ds = (SparseMatrix) ADense1.mul(ASparse2);
        result.equals(ds);
    }

    @Test
    public void mulDD() {
        DenseMatrix dd = (DenseMatrix) ADense1.mul(ADense2);
        result1.equals(dd);
    }

    @Test
    public void tmulDD() throws InterruptedException {
        DenseMatrix dd = (DenseMatrix) ADense1.mulDenseDense(ADense2);
        result1.equals(dd);
    }

    @Test
    public void tmulSS() throws InterruptedException {
        SparseMatrix ss = (SparseMatrix) ASparse1.mulSparseSparse(ASparse2);
        result.equals(ss);
    }
}

