class Sum {
    public static int sumOfAreas(Shape[] array) {
        int areas = 0;
        for (Shape shape : array) {
            if (shape.getClass() == Square.class) {
                areas += (int) Math.pow(((Square) shape).getSide(), 2);
            } else if (shape.getClass() == Rectangle.class) {
                areas += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
            }
        }
        return areas;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}