/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        if ("MAX".equals(operator)) {
            int max = 0;
            for (int i = 1; i < args.length; i++) {
                if (max < Integer.parseInt(args[i])) {
                    max = Integer.parseInt(args[i]);
                }
            }
            System.out.println(max);
        } else if ("MIN".equals(operator)) {
            int min = Integer.parseInt(args[1]);
            for (int i = 1; i < args.length; i++) {
                if (min > Integer.parseInt(args[i])) {
                    min = Integer.parseInt(args[i]);
                }
            }
            System.out.println(min);
        } else if ("SUM".equals(operator)) {
            int sum = 0;
            for (int i = 1; i < args.length; i++) {
                sum += Integer.parseInt(args[i]);
            }
            System.out.println(sum);
        }
    }
}