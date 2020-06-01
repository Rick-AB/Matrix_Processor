import java.util.Scanner;

public class MatrixProcessor {
    Scanner scanner = new Scanner(System.in);
    public MatrixProcessor(){
        showMenu();
    }
    public void showMenu(){
        char op;
        do {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");

            System.out.print("Your choice: > ");
            op = scanner.nextLine().charAt(0);
            switch (op){
                case '1':
                    sum();
                    break;
                case '2':
                    multiplyByConstant();
                    break;
                case '3':
                    multiplyMatrices();
                    break;
                case '4':
                    transposeMatrix();
                    break;
                case '5':
                    getMatrix();
                    break;
                case '6':
                    getMatrixI();
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }while (op != '0');

    }

    public void sum(){
        System.out.print("Enter size of first matrix (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int rowFirst = Integer.parseInt(arr[0]);
        int columnFirst = Integer.parseInt(arr[1]);

        double[][] firstArr = new double[rowFirst][columnFirst];
        System.out.println("Enter first matrix:");

        for (int i =0; i<firstArr.length; i++){
            String[] dummyArr= scanner.nextLine().split(" ");
            for (int j = 0; j < dummyArr.length; j++){
                firstArr[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }
        System.out.print("Enter size of second matrix (separated by a space): > ");
        String[] arr1 = scanner.nextLine().split(" ");
        int rowSecond = Integer.parseInt(arr1[0]);
        int columnSecond = Integer.parseInt(arr1[1]);

        double[][] secondArr = new double[rowSecond][columnSecond];
        System.out.println("Enter second matrix:");
        System.out.println();
        for (int i =0; i<secondArr.length; i++){
            String[] dummyArr= scanner.nextLine().split(" ");
            for (int j = 0; j < dummyArr.length; j++){
                secondArr[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }
        double[][] resultArr = new double[rowSecond][columnSecond];

        if (rowFirst == rowSecond && columnFirst == columnSecond){
            for (int i = 0; i<resultArr.length; i++){
                for (int j = 0; j<resultArr[0].length; j++){
                    resultArr[i][j] = firstArr[i][j] + secondArr[i][j];
                }
            }
            for (double[] doubles : resultArr) {
                for (int j = 0; j < resultArr[0].length; j++) {
                    System.out.print(doubles[j] + " ");
                }
                System.out.println();
            }
        }else {
            System.out.println("ERROR");
        }
    }
    public void multiplyByConstant(){
        System.out.print("Enter size of matrix (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);
        int[][] Arr = new int[row][column];
        int[][] resultArr = new int[row][column];

        System.out.println("Enter matrix:");
        for (int i = 0; i<Arr.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                Arr[i][j] = Integer.parseInt(dummyArr[j]);
            }
        }
        System.out.print("Enter constant: ");
        int constant = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i<Arr.length; i++){
            for (int j = 0; j<Arr[0].length; j++){
                resultArr[i][j] = Arr[i][j] * constant;
            }
        }

        System.out.println("The multiplication result is:");
        for (int[] ints : resultArr) {
            for (int j = 0; j < resultArr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    public void multiplyMatrices(){
        System.out.print("Enter size of first matrix (separated by a space): > ");
        String[] firstDimension = scanner.nextLine().split(" ");
        int rowFirst = Integer.parseInt(firstDimension[0]);
        int columnFirst = Integer.parseInt(firstDimension[1]);
        double[][] firstArr = new double[rowFirst][columnFirst];

        System.out.println("Enter first matrix:");
        for (int i = 0; i<firstArr.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                firstArr[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }


        System.out.print("Enter size of second matrix (separated by a space): > ");
        String[] secondDimension = scanner.nextLine().split(" ");
        int rowSecond = Integer.parseInt(secondDimension[0]);
        int columnSecond = Integer.parseInt(secondDimension[1]);
        double[][] secondArr = new double[rowSecond][columnSecond];

        System.out.println("Enter second matrix:");
        for (int i = 0; i<secondArr.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                secondArr[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }
        double[][] resultArr = new double[rowFirst][columnSecond];
        double sum = 0;

        if (columnFirst == rowSecond){
            for (int i = 0; i<rowFirst; i++){
                for (int j = 0; j<columnSecond; j++){
                    for (int k = 0; k<columnFirst; k++){
                        sum = sum + firstArr[i][k] * secondArr[k][j];
                    }
                    resultArr[i][j] = sum;
                    sum = 0;
                }
            }

            System.out.println("The multiplication result is:");

            for (double[] doubles : resultArr) {
                for (int j = 0; j < resultArr[0].length; j++) {
                    System.out.print(doubles[j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }else {
            System.out.println("Impossible Calculation!\nIncompatible matrices");
        }
    }
    public void transposeMatrix(){
        char op;
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        System.out.print("Your choice: > ");
        op = scanner.nextLine().charAt(0);
        switch (op){
            case '1':
                mainDiagonalTranspose();
                break;
            case '2':
                sideDiagonalTranspose();
                break;
            case '3':
                verticalLineTranspose();
                break;
            case '4':
                horizontalLineTranspose();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    public void mainDiagonalTranspose(){
        System.out.print("Enter matrix size (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);

        double[][] array = new double[row][column];
        double[][] resultArray = new double[column][row];

        for (int i = 0; i<array.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                array[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }

        for (int i = 0; i<resultArray.length; i++){
            for (int j = 0; j<resultArray[0].length; j++){
                resultArray[i][j] = array[j][i];
            }
        }

        System.out.println("The result is:");
        for (double[] doubles : resultArray) {
            for (int j = 0; j < resultArray[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void sideDiagonalTranspose(){
        System.out.print("Enter matrix size (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);

        double[][] array = new double[row][column];
        double[][] resultArray = new double[column][row];

        for (int i = 0; i<array.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                array[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }

        for (int i = 0; i<resultArray.length; i++){
            for (int j = 0; j<resultArray[0].length; j++){
                resultArray[i][j] = array[array[0].length - j -1][array.length - 1 -i];
            }
        }

        System.out.println("The result is:");
        for (double[] doubles : resultArray) {
            for (int j = 0; j < resultArray[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void verticalLineTranspose(){
        System.out.print("Enter matrix size (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);

        double[][] array = new double[row][column];


        for (int i = 0; i<array.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                array[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }

        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<(array[0].length/2); j++){
                double temp = array[i][(array[0].length) - j -1];
                array[i][array[0].length - j -1 ] = array[i][j];
                array[i][j] = temp;
            }

        }

        System.out.println("The result is:");
        for (double[] doubles : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void horizontalLineTranspose(){
        System.out.print("Enter matrix size (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);

        double[][] array = new double[row][column];

        for (int i = 0; i<array.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                array[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }

        for (int i = 0; i<(array.length/2); i++){
            double[] temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i -1] = temp;
        }

        System.out.println("The result is:");
        for (double[] doubles : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void getMatrix(){
        System.out.print("Enter matrix size (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);

        double[][] array = new double[row][column];
        for (int i = 0; i<array.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                array[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }
        if (row == column) {
            System.out.println("The result is:");
            System.out.println(findDeterminant(array));
            System.out.println();
        }else {
            System.out.println("Impossible calculation \n" + "Matrix is not a square matrix");
        }

    }
    public double findDeterminant(double[][] matrix){
        double[][] temporary;
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow (-1, i) * findDeterminant(temporary);
        }
        return (result);
    }
    public void getMatrixI(){
        System.out.print("Enter matrix size (separated by a space): > ");
        String[] arr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);

        double[][] array = new double[row][column];
        for (int i = 0; i<array.length; i++){
            String[] dummyArr = scanner.nextLine().split(" ");
            for (int j = 0; j<dummyArr.length; j++){
                array[i][j] = Double.parseDouble(dummyArr[j]);
            }
        }
        double[][] result = inverseMatrix(array);
        System.out.println("The result is");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                double val = result[i][j];
                System.out.printf("%.2f ", val);
            }
            System.out.println();
        }
    }
    public double[][] inverseMatrix(double[][] matrix){
        double[][] auxiliaryMatrix, invertedMatrix;
        int[] index;

        auxiliaryMatrix = new double[matrix.length][matrix.length];
        invertedMatrix = new double[matrix.length][matrix.length];
        index = new int[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            auxiliaryMatrix[i][i] = 1;
        }

        transformToUpperTriangle(matrix, index);

        for (int i = 0; i < (matrix.length - 1); ++i) {
            for (int j = (i + 1); j < matrix.length; ++j) {
                for (int k = 0; k < matrix.length; ++k) {
                    auxiliaryMatrix[index[j]][k] -= matrix[index[j]][i] * auxiliaryMatrix[index[i]][k];
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            invertedMatrix[matrix.length - 1][i] = (auxiliaryMatrix[index[matrix.length - 1]][i] / matrix[index[matrix.length - 1]][matrix.length - 1]);

            for (int j = (matrix.length - 2); j >= 0; --j) {
                invertedMatrix[j][i] = auxiliaryMatrix[index[j]][i];

                for (int k = (j + 1); k < matrix.length; ++k) {
                    invertedMatrix[j][i] -= (matrix[index[j]][k] * invertedMatrix[k][i]);
                }

                invertedMatrix[j][i] /= matrix[index[j]][j];
            }
        }

        return (invertedMatrix);
    }

    private void transformToUpperTriangle(double[][] matrix, int[] index) {
        double[] c;
        double c0, c1, pi0, pi1, pj;
        int itmp, k;

        c = new double[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            index[i] = i;
        }

        for (int i = 0; i < matrix.length; ++i) {
            c1 = 0;

            for (int j = 0; j < matrix.length; ++j) {
                c0 = Math.abs (matrix[i][j]);

                if (c0 > c1) {
                    c1 = c0;
                }
            }

            c[i] = c1;
        }

        k = 0;

        for (int j = 0; j < (matrix.length - 1); ++j) {
            pi1 = 0;

            for (int i = j; i < matrix.length; ++i) {
                pi0 = Math.abs (matrix[index[i]][j]);
                pi0 /= c[index[i]];

                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;

            for (int i = (j + 1); i < matrix.length; ++i) {
                pj = matrix[index[i]][j] / matrix[index[j]][j];
                matrix[index[i]][j] = pj;

                for (int l = (j + 1); l < matrix.length; ++l) {
                    matrix[index[i]][l] -= pj * matrix[index[j]][l];
                }
            }
        }
    }
}

