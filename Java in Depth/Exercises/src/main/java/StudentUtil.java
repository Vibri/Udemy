public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        double[] studentsGpa = new double[studentIdList.length];
        for (int i = 0; i < studentIdList.length; i++) {
            studentsGpa[i] = getGPA(studentsGrades[i]);
        }
        return studentsGpa;
    }


    private static double getValue(final char grade) {
        double value = 0;
        switch(grade) {
            case 'A': value = 4;
                break;
            case 'B': value = 3;
                break;
            case 'C': value = 2;
                break;
        }
        return value;
    }

    private static double getGPA(char[] grades) {
        double sum = 0;
        for(char grade : grades) {
            sum+= getValue(grade);
        }
        return sum/grades.length;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }
        // invoke calculateGPA
        double[] studentsGpa = calculateGPA(studentIdList,studentsGrades);
        int length = 0;
        for(double gpa : studentsGpa) {
            if (lower <= gpa && gpa <= higher) {
                length++;
            }
        }
        int[] studentByGpa = new int[length];
        int nextPossition = 0;
        for(int i=0;i<studentsGpa.length;i++) {
            if (lower <= studentsGpa[i] && studentsGpa[i] <= higher) {
                studentByGpa[nextPossition++] = studentIdList[i];
            }
        }
        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
        return studentByGpa;
    }
}
