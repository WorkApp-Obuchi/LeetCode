package LeetCode.ArrayString;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        if(columnTitle == null || columnTitle.isEmpty()) return 0;

        int result = 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();

        String num1 = "A";
        String num2 = "AB";
        String num3 = "ZY";
        int title1 = solution.titleToNumber(num1);
        int title2 = solution.titleToNumber(num2);
        int title3 = solution.titleToNumber(num3);

        System.out.println("Input = A : " + "output = " + title1);
        System.out.println("Input = AB : " + "output = " + title2);
        System.out.println("Input = ZY : " + "output = " + title3);
    }
}
