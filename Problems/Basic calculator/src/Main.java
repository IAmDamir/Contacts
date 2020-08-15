class Problem {

    public static void main(String[] args) {
        if ("+".equals(args[0])) {
            System.out.println(Integer.parseInt(args[1]) + Integer.parseInt(args[2]));
        } else if ("-".equals(args[0])) {
            System.out.println(Integer.parseInt(args[1]) - Integer.parseInt(args[2]));
        } else if ("*".equals(args[0])) {
            System.out.println(Integer.parseInt(args[1]) * Integer.parseInt(args[2]));
        } else {
            System.out.println("Unknown operator");
        }
    }
}