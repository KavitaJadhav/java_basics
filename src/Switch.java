public class Switch {
    public static void main(String[] args) {
        String value = "bubble";
        switch (value) {
            case "bubble":
                System.out.println("input type bubble sort");
                break;
            case "merge":
                System.out.println("input type merge sort");
                break;
            case "quick":
                System.out.println("input type quick sort");
                break;
            default:
                System.out.println("invalid option");
        }

        int num = 0;
        switch (num) {
            case 0:
                System.out.println("input is 0");
                break;
            case 1:
                System.out.println("input is 1");
                break;
            case 2:
                System.out.println("input is 2");
                break;
            default:
                System.out.println("invalid option");
        }
    }
}
