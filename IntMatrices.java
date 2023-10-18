public class IntMatrices {
    static int[][] createRandomMatrix(int lines, int columns) {
        int[][] matrix = new int[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int)(Math.random() * 10);
            }
        }
        return matrix;
    }

    static int[][] createRandomSquareMatrix(int n) {
        return createRandomMatrix(n, n);
    }

    static int sumMatrix(int[][] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sum += m[i][j];
            }
        }
        return sum;
    }

    static int numElements(int[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            count += m[i].length;
        }
        return count;
    }

    static int[] unroll(int[][] m) {
        int[] array = new int[numElements(m)];
        int index = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                array[index++] = m[i][j];
            }
        }
        return array;
    }

    static int[][] createMatrix(int[] values, int lines, int columns) {
        int[][] matrix = new int[lines][columns];
        int index = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = values[index++];
            }
        }
        return matrix;
    }
}

class Algebra {
	static int[][] createIdentity(int order) {
        int[][] matrix = new int[order][order];
        for (int i = 0; i < order; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    static void scalarMultiplication(int[][] m, int c) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] *= c;
            }
        }
    }
    
    static boolean identifiedMatrix(int[][] matrix) {
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	
    	if (rows != columns) {
    		return false;
    	}
    	
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < columns; j++) {
    			if (i == j && matrix[i][j] != 1) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

    static void addition(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] += b[i][j];
            }
        }
    }
    
    static boolean length(int[][] a, int[][] b) {
    	for (int i = 0; i < a.length; i++) {
    		for (int j = 0; j < b.length; j++) {
    			if (a.length == b.length) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    static boolean lengthRows(int[][] a, int[][] b) {
    	for (int i = 0; i < a.length; i++) {
    		for (int j = 0; j < b.length; j++) {
    			if (a.length == b.length) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    static boolean sameMatrixes(int[][] a, int[][] b) {
    	for (int i = 0; i < a.length; i++) {
    		for (int j = 0; j < b.length; j++) {
    			if (a.length == b.length) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    static void multiplication(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] *= b[i][j];
            }
        }
    }
}