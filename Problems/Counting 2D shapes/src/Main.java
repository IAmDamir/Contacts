class Counter {
    public static int count2DShapes(Shape[] shapes) {
        int counter = 0;
        for (Shape shape : shapes) {
            if (shape.getClass() == Circle.class || shape.getClass() == Shape2DSub1.class || shape.getClass() == Shape2DSub2.class)
                counter++;
        }
        return counter;
    }
}

// Don't change the code below

class Shape {
}

class Shape2D extends Shape {
}

class Shape3D extends Shape {
}


class Circle extends Shape2D {
}

class Shape2DSub1 extends Shape2D {
}

class Shape2DSub2 extends Shape2D {
}


class Cube extends Shape3D {
}

class Shape3DSub1 extends Shape3D {
}

class Shape3DSub2 extends Shape3D {
}